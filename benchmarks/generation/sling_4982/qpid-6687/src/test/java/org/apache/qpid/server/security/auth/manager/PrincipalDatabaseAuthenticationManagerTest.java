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
package org.apache.qpid.server.security.auth.manager;

import static org.apache.qpid.server.security.auth.AuthenticatedPrincipalTestHelper.assertOnlyContainsWrapped;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.security.auth.callback.CallbackHandler;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import javax.security.sasl.SaslServerFactory;

import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.security.auth.AuthenticationResult;
import org.apache.qpid.server.security.auth.AuthenticationResult.AuthenticationStatus;
import org.apache.qpid.server.security.auth.UsernamePrincipal;
import org.apache.qpid.server.security.auth.database.PlainPasswordFilePrincipalDatabase;
import org.apache.qpid.server.security.auth.database.PrincipalDatabase;
import org.apache.qpid.server.util.BrokerTestHelper;
import org.apache.qpid.test.utils.QpidTestCase;

/**
 * Tests the public methods of PrincipalDatabaseAuthenticationManager.
 *
 */
public class PrincipalDatabaseAuthenticationManagerTest extends QpidTestCase
{
    private static final String LOCALHOST = "localhost";
    private static final String MOCK_MECH_NAME = "MOCK-MECH-NAME";
    private static final UsernamePrincipal PRINCIPAL = new UsernamePrincipal("guest");

    private PrincipalDatabaseAuthenticationManager _manager = null; // Class under test
    private PrincipalDatabase _principalDatabase;
    private String _passwordFileLocation;

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        _passwordFileLocation = TMP_FOLDER + File.separator + PrincipalDatabaseAuthenticationManagerTest.class.getSimpleName() + "-" + getName();
        deletePasswordFileIfExists();
    }

    @Override
    public void tearDown() throws Exception
    {
        try
        {
            if (_manager != null)
            {
                _manager.close();
            }
        }
        finally
        {
            deletePasswordFileIfExists();
        }
        super.tearDown();
    }

    private void deletePasswordFileIfExists()
    {
        File passwordFile = new File(_passwordFileLocation);
        if (passwordFile.exists())
        {
            passwordFile.delete();
        }
    }
}
