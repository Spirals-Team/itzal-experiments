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
package org.apache.qpid.server.store;

import org.apache.qpid.server.BrokerOptions;
import org.apache.qpid.server.configuration.updater.CurrentThreadTaskExecutor;
import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.logging.EventLogger;
import org.apache.qpid.server.model.AuthenticationProvider;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.BrokerModel;
import org.apache.qpid.server.model.JsonSystemConfigImpl;
import org.apache.qpid.server.model.SystemConfig;
import org.apache.qpid.test.utils.QpidTestCase;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BrokerRecovererTest extends QpidTestCase
{
    private ConfiguredObjectRecord _brokerEntry = mock(ConfiguredObjectRecord.class);

    private UUID _brokerId = UUID.randomUUID();
    private AuthenticationProvider<?> _authenticationProvider1;
    private UUID _authenticationProvider1Id = UUID.randomUUID();
    private SystemConfig<?> _systemConfig;
    private TaskExecutor _taskExecutor;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        _taskExecutor = new CurrentThreadTaskExecutor();
        _taskExecutor.start();
        _systemConfig = new JsonSystemConfigImpl(_taskExecutor,
                                               mock(EventLogger.class),
                                                 new BrokerOptions().convertToSystemConfigAttributes());

        when(_brokerEntry.getId()).thenReturn(_brokerId);
        when(_brokerEntry.getType()).thenReturn(Broker.class.getSimpleName());
        Map<String, Object> attributesMap = new HashMap<String, Object>();
        attributesMap.put(Broker.MODEL_VERSION, BrokerModel.MODEL_VERSION);
        attributesMap.put(Broker.NAME, getName());

        when(_brokerEntry.getAttributes()).thenReturn(attributesMap);
        when(_brokerEntry.getParents()).thenReturn(Collections.singletonMap(SystemConfig.class.getSimpleName(), _systemConfig
                .getId()));

        //Add a base AuthenticationProvider for all tests
        _authenticationProvider1 = mock(AuthenticationProvider.class);
        when(_authenticationProvider1.getName()).thenReturn("authenticationProvider1");
        when(_authenticationProvider1.getId()).thenReturn(_authenticationProvider1Id);
    }

    @Override
    protected void tearDown() throws Exception
    {
        try
        {
            super.tearDown();
        }
        finally
        {
            _taskExecutor.stop();
        }
    }
}
