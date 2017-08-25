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

package org.apache.qpid.server.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.plugin.ConfiguredObjectRegistration;
import org.apache.qpid.server.plugin.PluggableService;

@PluggableService
public class ConfiguredObjectRegistrationImpl implements ConfiguredObjectRegistration
{
    private final Set<Class<? extends ConfiguredObject>> _implementations;

    public ConfiguredObjectRegistrationImpl()
    {
        Set<Class<? extends ConfiguredObject>> implementations = new HashSet<>();
        implementations.add(VirtualHostLogger.class);
        implementations.add(User.class);
        implementations.add(VirtualHost.class);
        implementations.add(VirtualHostAlias.class);
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostalias.hostnameAlias"))
        {
             implementations.add(HostNameAlias.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:systemconfig.JSON"))
        {
             implementations.add(JsonSystemConfigImpl.class);
        }
        implementations.add(VirtualHostLoggerFilter.class);
        implementations.add(Connection.class);
        implementations.add(Group.class);
        implementations.add(PreferencesProvider.class);
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostalias.patternMatchingAlias"))
        {
             implementations.add(PatternMatchingAlias.class);
        }
        implementations.add(Exchange.class);
        implementations.add(Session.class);
        implementations.add(Broker.class);
        implementations.add(SystemConfig.class);
        implementations.add(Plugin.class);
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostalias.defaultAlias"))
        {
             implementations.add(DefaultVirtualHostAlias.class);
        }
        implementations.add(Queue.class);
        implementations.add(Binding.class);
        implementations.add(BrokerLoggerFilter.class);
        implementations.add(AccessControlProvider.class);
        implementations.add(GroupMember.class);
        implementations.add(RemoteReplicationNode.class);
        implementations.add(AuthenticationProvider.class);
        implementations.add(TrustStore.class);
        implementations.add(ConfiguredObject.class);
        implementations.add(VirtualHostNode.class);
        implementations.add(Publisher.class);
        implementations.add(BrokerLogger.class);
        implementations.add(Port.class);
        implementations.add(GroupProvider.class);
        implementations.add(Consumer.class);
        implementations.add(KeyStore.class);
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostalias.nameAlias"))
        {
             implementations.add(VirtualHostNameAlias.class);
        }
        _implementations = Collections.unmodifiableSet(implementations);
    }

    public String getType()
    {
        return "org.apache.qpid.server.model";
    }

    public Set<Class<? extends ConfiguredObject>> getConfiguredObjectClasses()
    {
        return _implementations;
    }

}
