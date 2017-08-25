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
package org.apache.qpid.server.virtualhostnode;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.apache.qpid.server.configuration.updater.CurrentThreadTaskExecutor;
import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.BrokerModel;
import org.apache.qpid.server.model.ConfiguredObjectFactoryImpl;
import org.apache.qpid.server.model.Model;
import org.apache.qpid.server.model.RemoteReplicationNode;
import org.apache.qpid.server.model.SystemConfig;
import org.apache.qpid.server.model.VirtualHost;
import org.apache.qpid.server.security.SecurityManager;
import org.apache.qpid.server.store.ConfiguredObjectRecord;
import org.apache.qpid.server.store.DurableConfigurationStore;
import org.apache.qpid.server.store.NullMessageStore;
import org.apache.qpid.server.store.StoreException;
import org.apache.qpid.server.store.handler.ConfiguredObjectRecordHandler;
import org.apache.qpid.server.util.BrokerTestHelper;
import org.apache.qpid.server.virtualhost.TestMemoryVirtualHost;
import org.apache.qpid.test.utils.QpidTestCase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractStandardVirtualHostNodeTest extends QpidTestCase
{
    private static final String TEST_VIRTUAL_HOST_NODE_NAME = "testNode";
    private static final String TEST_VIRTUAL_HOST_NAME = "testVirtualHost";

    private final UUID _nodeId = UUID.randomUUID();
    private final SecurityManager _mockSecurityManager = mock(SecurityManager.class);
    private Broker<?> _broker;
    private TaskExecutor _taskExecutor;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        _broker = BrokerTestHelper.createBrokerMock();
        SystemConfig<?> systemConfig = _broker.getParent(SystemConfig.class);
        when(systemConfig.getObjectFactory()).thenReturn(new ConfiguredObjectFactoryImpl(mock(Model.class)));

        _taskExecutor = new CurrentThreadTaskExecutor();
        _taskExecutor.start();
        when(_broker.getTaskExecutor()).thenReturn(_taskExecutor);
        when(_broker.getChildExecutor()).thenReturn(_taskExecutor);

    }

    @Override
    protected void tearDown() throws Exception
    {
        try
        {
            _taskExecutor.stopImmediately();
        }
        finally
        {
            super.tearDown();
        }
    }

    private ConfiguredObjectRecord createVirtualHostConfiguredObjectRecord(UUID virtualHostId)
    {
        Map<String, Object> virtualHostAttributes = new HashMap<>();
        virtualHostAttributes.put(VirtualHost.NAME, TEST_VIRTUAL_HOST_NAME);
        virtualHostAttributes.put(VirtualHost.TYPE, TestMemoryVirtualHost.VIRTUAL_HOST_TYPE);
        virtualHostAttributes.put(VirtualHost.MODEL_VERSION, BrokerModel.MODEL_VERSION);

        ConfiguredObjectRecord record = mock(ConfiguredObjectRecord.class);
        when(record.getId()).thenReturn(virtualHostId);
        when(record.getAttributes()).thenReturn(virtualHostAttributes);
        when(record.getType()).thenReturn(VirtualHost.class.getSimpleName());
        return record;
    }

    private NullMessageStore configStoreThatProduces(final ConfiguredObjectRecord record)
    {
        return new NullMessageStore(){

            @Override
            public void visitConfiguredObjectRecords(ConfiguredObjectRecordHandler handler) throws StoreException
            {
                handler.begin();
                if (record != null)
                {
                    handler.handle(record);
                }
                handler.end();
            }
        };
    }

    private NullMessageStore configStoreThatProducesNoRecords()
    {
        return configStoreThatProduces(null);
    }


    private AbstractStandardVirtualHostNode createTestStandardVirtualHostNode(final Map<String, Object> attributes,
                                                                              final DurableConfigurationStore store)
    {
        return new AbstractStandardVirtualHostNode(attributes,  _broker){

            @Override
            protected void writeLocationEventLog()
            {

            }

            @Override
            protected DurableConfigurationStore createConfigurationStore()
            {
                return store;
            }
        };
    }

    private class TestAbstractVirtualHostNode extends AbstractVirtualHostNode
    {
        private DurableConfigurationStore _store;

        public TestAbstractVirtualHostNode(Broker parent, Map attributes, DurableConfigurationStore store)
        {
            super(parent, attributes);
            _store = store;
        }

        @Override
        public void onValidate()
        {
            throw new RuntimeException("Cannot validate");
        }

        @Override
        protected DurableConfigurationStore createConfigurationStore()
        {
            return _store;
        }

        @Override
        protected ListenableFuture<Void> activate()
        {
            return Futures.immediateFuture(null);
        }

        @Override
        protected ConfiguredObjectRecord enrichInitialVirtualHostRootRecord(ConfiguredObjectRecord vhostRecord)
        {
            return null;
        }

        @Override
        public Collection<? extends RemoteReplicationNode> getRemoteReplicationNodes()
        {
            return null;
        }
    }
}
