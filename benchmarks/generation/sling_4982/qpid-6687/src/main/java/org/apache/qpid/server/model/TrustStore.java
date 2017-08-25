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
package org.apache.qpid.server.model;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.List;

import javax.net.ssl.TrustManager;

@ManagedObject( defaultType = "FileTrustStore" )
public interface TrustStore<X extends TrustStore<X>> extends ConfiguredObject<X>
{
    @ManagedAttribute( defaultValue = "false" )
    boolean isExposedAsMessageSource();

    @ManagedAttribute( defaultValue = "[]" )
    List<VirtualHost> getIncludedVirtualHostMessageSources();

    @ManagedAttribute( defaultValue = "[]" )
    List<VirtualHost> getExcludedVirtualHostMessageSources();


    public TrustManager[] getTrustManagers() throws GeneralSecurityException;

    public Certificate[] getCertificates() throws GeneralSecurityException;

}