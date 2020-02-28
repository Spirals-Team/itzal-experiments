/*
 *
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
 *
 */
package org.apache.qpid.server.logging;

import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.configuration.updater.TaskExecutorImpl;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.BrokerModel;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.Model;
import org.apache.qpid.server.model.State;
import org.apache.qpid.server.model.SystemConfig;
import org.apache.qpid.server.model.VirtualHost;
import org.apache.qpid.server.model.VirtualHostLogger;
import org.apache.qpid.server.model.VirtualHostNode;
import org.apache.qpid.server.security.SecurityManager;
import org.apache.qpid.server.store.DurableConfigurationStore;
import org.apache.qpid.server.virtualhost.TestMemoryVirtualHost;
import org.apache.qpid.test.utils.QpidTestCase;
import org.apache.qpid.util.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VirtualHostLoggerTest  extends QpidTestCase
{
    private VirtualHost<?,?,?> _virtualHost;
    private TaskExecutor _taskExecutor;
    private File _baseFolder;
    private File _logFile;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        _taskExecutor = new TaskExecutorImpl();
       _taskExecutor.start();

        Model model = BrokerModel.getInstance();

        SecurityManager securityManager = mock(SecurityManager.class);
        EventLogger eventLogger = mock(EventLogger.class);

        SystemConfig<?> systemConfig = mock(SystemConfig.class);
        when(systemConfig.getModel()).thenReturn(model);
        when(systemConfig.getChildExecutor()).thenReturn(_taskExecutor);
        when(systemConfig.getEventLogger()).thenReturn(eventLogger);
        doReturn(SystemConfig.class).when(systemConfig).getCategoryClass();

        Broker<?> broker = mock(Broker.class);
        when(broker.getSecurityManager()).thenReturn(securityManager);
        when(broker.getModel()).thenReturn(model);
        when(broker.getChildExecutor()).thenReturn(_taskExecutor);
        when(broker.getParent(SystemConfig.class)).thenReturn(systemConfig);
        doReturn(Broker.class).when(broker).getCategoryClass();

        VirtualHostNode<?> node =  mock(VirtualHostNode.class);
        when(node.getModel()).thenReturn(model);
        when(node.getChildExecutor()).thenReturn(_taskExecutor);
        when(node.getParent(Broker.class)).thenReturn(broker);
        when(node.getConfigurationStore()).thenReturn(mock(DurableConfigurationStore.class));
        doReturn(VirtualHostNode.class).when(node).getCategoryClass();

        // use real VH object rather then mock in order to test create/start/stop functionality
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(VirtualHost.NAME, getName());
        attributes.put(VirtualHost.TYPE, TestMemoryVirtualHost.VIRTUAL_HOST_TYPE);
        _virtualHost = new TestMemoryVirtualHost(attributes, node);
        _virtualHost.open();

        _baseFolder = new File(TMP_FOLDER, "test-sub-folder");
        _logFile = new File(_baseFolder, "tmp-virtual-host.log." + System.currentTimeMillis());
        if (_baseFolder.exists())
        {
            FileUtils.delete(_baseFolder, true);
        }
    }

    @Override
    public void tearDown() throws Exception
    {
        try
        {
            _virtualHost.close();
            _taskExecutor.stopImmediately();
            if (_baseFolder != null && _baseFolder.exists())
            {
                FileUtils.delete(_baseFolder, true);
            }
        }
        finally
        {
            super.tearDown();
        }
    }

    public void testStopLoggingLoggerInErroredState()
    {
        VirtualHostFileLogger logger = createErrorredLogger();
        logger.stopLogging();
    }

    private VirtualHostFileLogger createErrorredLogger()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(VirtualHostLogger.NAME, getTestName());
        attributes.put(ConfiguredObject.TYPE, VirtualHostFileLogger.TYPE);
        attributes.put(VirtualHostFileLogger.FILE_NAME, _logFile.getPath());
        attributes.put(VirtualHostFileLogger.MAX_FILE_SIZE, "invalid");

        VirtualHostFileLogger logger = new VirtualHostFileLoggerImpl(attributes, _virtualHost);
        logger.open();

        assertEquals("Unexpected state", State.ERRORED, logger.getState());
        return logger;
    }

}
