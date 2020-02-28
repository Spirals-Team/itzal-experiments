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
package org.apache.qpid.server.virtualhost;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.qpid.server.consumer.ConsumerImpl;
import org.apache.qpid.server.consumer.ConsumerTarget;
import org.apache.qpid.server.filter.FilterManager;
import org.apache.qpid.server.message.ServerMessage;
import org.apache.qpid.server.message.internal.InternalMessage;
import org.apache.qpid.server.message.internal.InternalMessageHeader;

public class VirtualHostPropertiesNode extends AbstractSystemMessageSource
{

    public VirtualHostPropertiesNode(final VirtualHostImpl virtualHost)
    {
        this(virtualHost, "$virtualhostProperties");
    }
    public VirtualHostPropertiesNode(final VirtualHostImpl virtualHost, String name)
    {
        super(name, virtualHost);
    }

    @Override
    public Consumer addConsumer(final ConsumerTarget target,
                                    final FilterManager filters,
                                    final Class<? extends ServerMessage> messageClass,
                                    final String consumerName,
                                    final EnumSet<ConsumerImpl.Option> options)
            throws ExistingExclusiveConsumer, ExistingConsumerPreventsExclusive,
                   ConsumerAccessRefused
    {
        final Consumer consumer = super.addConsumer(target, filters, messageClass, consumerName, options);
        consumer.send(createMessage());
        target.queueEmpty();
        return consumer;
    }

    protected InternalMessage createMessage()
    {

        Map<String, Object> headers = new HashMap<>();

        final List<String> globalAddresseDomains = _virtualHost.getGlobalAddressDomains();
        if (globalAddresseDomains != null && !globalAddresseDomains.isEmpty())
        {
            String primaryDomain = globalAddresseDomains.get(0);
            if(primaryDomain != null)
            {
                primaryDomain = primaryDomain.trim();
                if(!primaryDomain.endsWith("/"))
                {
                    primaryDomain += "/";
                }
                headers.put("virtualHost.temporaryQueuePrefix", primaryDomain);
            }
        }

        InternalMessageHeader header = new InternalMessageHeader(headers,
                                                                 null, 0l, null, null, UUID.randomUUID().toString(),
                                                                 null, null, (byte) 4, System.currentTimeMillis(),
                                                                 null, null);
        final InternalMessage message =
                InternalMessage.createBytesMessage(_virtualHost.getMessageStore(), header, new byte[0]);
        message.setInitialRoutingAddress(getName());
        return message;
    }


}
