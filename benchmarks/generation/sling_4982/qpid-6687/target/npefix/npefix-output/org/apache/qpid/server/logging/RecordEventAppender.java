package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.helpers.CyclicBuffer;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.concurrent.atomic.AtomicLong;

public class RecordEventAppender extends AppenderBase<ILoggingEvent> {
    private CyclicBuffer<LogRecord> _buffer;

    private final int _size;

    private AtomicLong _recordId;

    RecordEventAppender(final int size) {
        MethodContext _bcornu_methode_context8 = new MethodContext(null);
        try {
            _size = size;
            CallChecker.varAssign(this._size, "this._size", 38, 1278, 1290);
            _recordId = new AtomicLong();
            CallChecker.varAssign(this._recordId, "this._recordId", 39, 1300, 1328);
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public void start() {
        MethodContext _bcornu_methode_context71 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1341, 1439);
            CallChecker.varInit(this._recordId, "_recordId", 42, 1341, 1439);
            CallChecker.varInit(this._size, "_size", 42, 1341, 1439);
            CallChecker.varInit(this._buffer, "_buffer", 42, 1341, 1439);
            _buffer = new CyclicBuffer<>(_size);
            CallChecker.varAssign(this._buffer, "this._buffer", 44, 1375, 1410);
            super.start();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    public void stop() {
        MethodContext _bcornu_methode_context72 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 48, 1446, 1521);
            CallChecker.varInit(this._recordId, "_recordId", 48, 1446, 1521);
            CallChecker.varInit(this._size, "_size", 48, 1446, 1521);
            CallChecker.varInit(this._buffer, "_buffer", 48, 1446, 1521);
            _buffer = null;
            CallChecker.varAssign(this._buffer, "this._buffer", 50, 1479, 1493);
            super.stop();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        MethodContext _bcornu_methode_context73 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1528, 1728);
            CallChecker.varInit(eventObject, "eventObject", 55, 1528, 1728);
            CallChecker.varInit(this._recordId, "_recordId", 55, 1528, 1728);
            CallChecker.varInit(this._size, "_size", 55, 1528, 1728);
            CallChecker.varInit(this._buffer, "_buffer", 55, 1528, 1728);
            if (isStarted()) {
                if (CallChecker.beforeDeref(_recordId, AtomicLong.class, 59, 1670, 1678)) {
                    if (CallChecker.beforeDeref(_buffer, CyclicBuffer.class, 59, 1644, 1650)) {
                        _recordId = CallChecker.beforeCalled(_recordId, AtomicLong.class, 59, 1670, 1678);
                        _buffer = CallChecker.beforeCalled(_buffer, CyclicBuffer.class, 59, 1644, 1650);
                        CallChecker.isCalled(_buffer, CyclicBuffer.class, 59, 1644, 1650).add(new LogRecord(CallChecker.isCalled(_recordId, AtomicLong.class, 59, 1670, 1678).incrementAndGet(), eventObject));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public CyclicBuffer<LogRecord> getBuffer() {
        MethodContext _bcornu_methode_context74 = new MethodContext(CyclicBuffer.class);
        try {
            CallChecker.varInit(this, "this", 63, 1735, 1812);
            CallChecker.varInit(this._recordId, "_recordId", 63, 1735, 1812);
            CallChecker.varInit(this._size, "_size", 63, 1735, 1812);
            CallChecker.varInit(this._buffer, "_buffer", 63, 1735, 1812);
            return _buffer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((CyclicBuffer<LogRecord>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }
}

