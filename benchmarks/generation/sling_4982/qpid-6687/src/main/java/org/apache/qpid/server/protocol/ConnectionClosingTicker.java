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
package org.apache.qpid.server.protocol;

import org.apache.qpid.transport.network.NetworkConnection;
import org.apache.qpid.transport.network.Ticker;

public class ConnectionClosingTicker implements Ticker
{
    private final long _timeoutTime;
    private final NetworkConnection _network;

    public ConnectionClosingTicker(final long timeoutTime, final NetworkConnection network)
    {
        _timeoutTime = timeoutTime;
        _network = network;
    }

    @Override
    public int getTimeToNextTick(final long currentTime)
    {
        return (int) (_timeoutTime - currentTime);
    }

    @Override
    public int tick(final long currentTime)
    {
        int nextTick = getTimeToNextTick(currentTime);
        if(nextTick <= 0)
        {
            _network.close();
        }
        return nextTick;
    }
}
