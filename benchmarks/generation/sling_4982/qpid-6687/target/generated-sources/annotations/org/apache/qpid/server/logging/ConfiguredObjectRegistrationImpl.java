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

package org.apache.qpid.server.logging;

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
        if(!Boolean.getBoolean("qpid.type.disabled:brokerlogger.Syslog"))
        {
             implementations.add(BrokerSyslogLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:brokerlogger.Memory"))
        {
             implementations.add(BrokerMemoryLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:brokerlogger.Console"))
        {
             implementations.add(BrokerConsoleLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostlogger.Syslog"))
        {
             implementations.add(VirtualHostSyslogLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostlogger.File"))
        {
             implementations.add(VirtualHostFileLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:brokerlogger.BrokerLogbackSocket"))
        {
             implementations.add(BrokerLogbackSocketLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:brokerlogger.File"))
        {
             implementations.add(BrokerFileLogger.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:brokerloggerfilter.NameAndLevel"))
        {
             implementations.add(BrokerNameAndLevelFilter.class);
        }
        if(!Boolean.getBoolean("qpid.type.disabled:virtualhostloggerfilter.NameAndLevel"))
        {
             implementations.add(VirtualHostNameAndLevelFilter.class);
        }
        _implementations = Collections.unmodifiableSet(implementations);
    }

    public String getType()
    {
        return "org.apache.qpid.server.logging";
    }

    public Set<Class<? extends ConfiguredObject>> getConfiguredObjectClasses()
    {
        return _implementations;
    }

}