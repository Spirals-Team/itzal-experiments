/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.qpid.server.transport;

import org.apache.qpid.bytebuffer.QpidByteBuffer;
import org.apache.qpid.server.model.port.AmqpPort;
import org.apache.qpid.transport.network.security.ssl.SSLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NonBlockingConnectionTLSDelegate implements NonBlockingConnectionDelegate
{
    private static final Logger LOGGER = LoggerFactory.getLogger(NonBlockingConnectionTLSDelegate.class);

    private final SSLEngine _sslEngine;
    private final NonBlockingConnection _parent;
    private final int _initialApplicationBufferSize;
    private SSLEngineResult _status;
    private final List<QpidByteBuffer> _encryptedOutput = new ArrayList<>();
    private Principal _principal;
    private Certificate _peerCertificate;
    private boolean _principalChecked;
    private QpidByteBuffer _netInputBuffer;
    private QpidByteBuffer _applicationBuffer;


    public NonBlockingConnectionTLSDelegate(NonBlockingConnection parent, AmqpPort port)
    {
        _parent = parent;
        _sslEngine = createSSLEngine(port);
        _netInputBuffer = QpidByteBuffer.allocateDirect(Math.max(parent.getReceiveBufferSize(),
                                                                 _sslEngine.getSession().getPacketBufferSize()));

        _initialApplicationBufferSize =
                Math.max(_sslEngine.getSession().getApplicationBufferSize() + 50, _parent.getReceiveBufferSize());
        _applicationBuffer = QpidByteBuffer.allocateDirect(_initialApplicationBufferSize);

    }

    @Override
    public boolean readyForRead()
    {
        return _sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_WRAP && (_status == null || _status.getStatus() != SSLEngineResult.Status.CLOSED);
    }

    @Override
    public boolean processData() throws IOException
    {
        _netInputBuffer.flip();
        boolean readData = false;
        boolean tasksRun;
        int oldNetBufferPos;
        do
        {
            int oldAppBufPos = _applicationBuffer.position();
            oldNetBufferPos = _netInputBuffer.position();

            _status = _netInputBuffer.decryptSSL(_sslEngine, _applicationBuffer);
            if (_status.getStatus() == SSLEngineResult.Status.CLOSED)
            {
                // KW If SSLEngine changes state to CLOSED, what will ever set _closed to true?
                LOGGER.debug("SSLEngine closed");
            }

            tasksRun = runSSLEngineTasks(_status);
            _applicationBuffer.flip();
            if(_applicationBuffer.position() > oldAppBufPos)
            {
                readData = true;
            }

            _parent.processAmqpData(_applicationBuffer);

            restoreApplicationBufferForWrite();

        }
        while((_netInputBuffer.hasRemaining() && (_netInputBuffer.position()>oldNetBufferPos)) || tasksRun);

        if(_netInputBuffer.hasRemaining())
        {
            _netInputBuffer.compact();
        }
        else
        {
            _netInputBuffer.clear();
        }
        return readData;
    }

    @Override
    public boolean doWrite(Collection<QpidByteBuffer> bufferArray) throws IOException
    {
        final int bufCount = bufferArray.size();
        int byteBuffersWritten = wrapBufferArray(bufferArray);

        _parent.writeToTransport(_encryptedOutput);

        ListIterator<QpidByteBuffer> iter = _encryptedOutput.listIterator();
        while(iter.hasNext())
        {
            QpidByteBuffer buf = iter.next();
            if(buf.remaining() == 0)
            {
                iter.remove();
            }
            else
            {
                break;
            }
        }

        return (bufCount <= byteBuffersWritten) && _encryptedOutput.isEmpty();
    }

    protected void restoreApplicationBufferForWrite()
    {
        _applicationBuffer = _applicationBuffer.slice();
        if (_applicationBuffer.limit() != _applicationBuffer.capacity())
        {
            _applicationBuffer.position(_applicationBuffer.limit());
            _applicationBuffer.limit(_applicationBuffer.capacity());
        }
        else
        {
            QpidByteBuffer currentBuffer = _applicationBuffer;
            int newBufSize = (currentBuffer.capacity() < _initialApplicationBufferSize)
                    ? _initialApplicationBufferSize
                    : currentBuffer.capacity() + _initialApplicationBufferSize;

            _applicationBuffer = QpidByteBuffer.allocateDirect(newBufSize);
            _applicationBuffer.put(currentBuffer);
        }

    }

    private int wrapBufferArray(Collection<QpidByteBuffer> bufferArray) throws SSLException
    {
        int byteBuffersWritten = 0;
        int remaining = 0;
        do
        {
            if(_sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP)
            {
                final QpidByteBuffer netBuffer = QpidByteBuffer.allocateDirect(_sslEngine.getSession().getPacketBufferSize());
                _status = QpidByteBuffer.encryptSSL(_sslEngine,bufferArray, netBuffer);
                runSSLEngineTasks(_status);

                netBuffer.flip();
                remaining = netBuffer.remaining();
                if (remaining != 0)
                {
                    _encryptedOutput.add(netBuffer);
                }
                Iterator<QpidByteBuffer> iter = bufferArray.iterator();
                while (iter.hasNext())
                {
                    QpidByteBuffer buf = iter.next();
                    if (buf.remaining() == 0)
                    {
                        byteBuffersWritten++;
                        iter.remove();
                    }
                    else
                    {
                        break;
                    }
                }
            }

        }
        while(remaining != 0 && _sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP);
        return byteBuffersWritten;
    }

    private boolean runSSLEngineTasks(final SSLEngineResult status)
    {
        if(status.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK)
        {
            Runnable task;
            while((task = _sslEngine.getDelegatedTask()) != null)
            {
                task.run();
            }

            return true;
        }

        return false;
    }

    @Override
    public Principal getPeerPrincipal()
    {
        checkPeerPrincipal();
        return _principal;
    }

    @Override
    public Certificate getPeerCertificate()
    {
        checkPeerPrincipal();
        return _peerCertificate;
    }

    @Override
    public boolean needsWork()
    {
        return _sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private synchronized void checkPeerPrincipal()
    {
        if (!_principalChecked)
        {
            try
            {
                _principal = _sslEngine.getSession().getPeerPrincipal();
                final Certificate[] peerCertificates =
                        _sslEngine.getSession().getPeerCertificates();
                if (peerCertificates != null && peerCertificates.length > 0)
                {
                    _peerCertificate = peerCertificates[0];
                }
            }
            catch (SSLPeerUnverifiedException e)
            {
                _principal = null;
                _peerCertificate = null;
            }

            _principalChecked = true;
        }
    }

    private SSLEngine createSSLEngine(AmqpPort port)
    {
        SSLEngine sslEngine = port.getSSLContext().createSSLEngine();
        sslEngine.setUseClientMode(false);
        SSLUtil.removeSSLv3Support(sslEngine);
        SSLUtil.updateEnabledCipherSuites(sslEngine, port.getEnabledCipherSuites(), port.getDisabledCipherSuites());

        if(port.getNeedClientAuth())
        {
            sslEngine.setNeedClientAuth(true);
        }
        else if(port.getWantClientAuth())
        {
            sslEngine.setWantClientAuth(true);
        }
        return sslEngine;
    }

    @Override
    public QpidByteBuffer getNetInputBuffer()
    {
        return _netInputBuffer;
    }

}
