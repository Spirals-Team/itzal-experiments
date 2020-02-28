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
package org.apache.qpid.server.transport;

import java.net.SocketAddress;
import java.security.Principal;

import org.apache.qpid.protocol.AMQConstant;
import org.apache.qpid.server.model.Connection;
import org.apache.qpid.server.protocol.AMQSessionModel;
import org.apache.qpid.server.util.Deletable;

public interface AMQPConnection<C extends AMQPConnection<C>> extends Connection<C>, Deletable<C>
{
    boolean isMessageAssignmentSuspended();

    long getConnectionId();

    Principal getAuthorizedPrincipal();

    String getRemoteAddressString();

    String getVirtualHostName();

    void notifyWork();

    String getRemoteContainerName();

    boolean isConnectionStopped();

    void registerMessageReceived(long size, long arrivalTime);

    void registerMessageDelivered(long size);

    void closeSessionAsync(AMQSessionModel<?> session, AMQConstant cause, String message);

    SocketAddress getRemoteSocketAddress();

    void block();

    void unblock();

    void setScheduler(NetworkConnectionScheduler networkConnectionScheduler);

    boolean hasSessionWithName(byte[] name);

    void sendConnectionCloseAsync(AMQConstant connectionForced, String reason);

}
