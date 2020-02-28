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

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import org.apache.qpid.server.logging.logback.RollingPolicyDecorator;
import org.apache.qpid.server.logging.logback.RolloverWatcher;
import org.apache.qpid.server.logging.messages.BrokerMessages;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.Content;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.apache.qpid.server.model.Param;
import org.apache.qpid.server.model.SystemConfig;
import org.apache.qpid.server.util.DaemonThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BrokerFileLoggerImpl extends AbstractBrokerLogger<BrokerFileLoggerImpl> implements BrokerFileLogger<BrokerFileLoggerImpl>, FileLoggerSettings
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BrokerFileLoggerImpl.class);

    private RolloverWatcher _rolloverWatcher;
    private ScheduledExecutorService _rolledPolicyExecutor;

    @ManagedAttributeField
    private String _layout;
    @ManagedAttributeField
    private String _fileName;
    @ManagedAttributeField
    private boolean _rollDaily;
    @ManagedAttributeField
    private boolean _rollOnRestart;
    @ManagedAttributeField
    private boolean _compressOldFiles;
    @ManagedAttributeField
    private int _maxHistory;
    @ManagedAttributeField
    private int _maxFileSize;
    private StatusManager _statusManager;
    private StatusListener _logbackStatusListener;

    @ManagedObjectFactoryConstructor
    protected BrokerFileLoggerImpl(final Map<String, Object> attributes, Broker<?> broker)
    {
        super(attributes, broker);
    }

    @Override
    protected void postResolveChildren()
    {
        _rolloverWatcher = new RolloverWatcher(getFileName());
        _rolledPolicyExecutor = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory("RolledFileScanner-" + getName()));

        super.postResolveChildren();
    }

    @Override
    protected void validateChange(ConfiguredObject<?> proxyForValidation, Set<String> changedAttributes)
    {
        super.validateChange(proxyForValidation, changedAttributes);
        BrokerFileLogger brokerFileLogger = (BrokerFileLogger) proxyForValidation;
        if (changedAttributes.contains(FILE_NAME) && (brokerFileLogger.getFileName() != null))
        {
            AppenderUtils.validateLogFilePermissions(new File(brokerFileLogger.getFileName()));
        }
        if (changedAttributes.contains(MAX_FILE_SIZE))
        {
            AppenderUtils.validateMaxFileSize(brokerFileLogger.getMaxFileSize());
        }
    }

    @Override
    public String getFileName()
    {
        return _fileName;
    }

    @Override
    public boolean isRollDaily()
    {
        return _rollDaily;
    }

    @Override
    public boolean isRollOnRestart()
    {
        return _rollOnRestart;
    }

    @Override
    public boolean isCompressOldFiles()
    {
        return _compressOldFiles;
    }

    @Override
    public int getMaxHistory()
    {
        return _maxHistory;
    }

    @Override
    public int getMaxFileSize()
    {
        return _maxFileSize;
    }

    @Override
    public String getLayout()
    {
        return _layout;
    }

    @Override
    public List<LogFileDetails> getLogFiles()
    {
        return _rolloverWatcher == null ? Collections.<LogFileDetails>emptyList() :_rolloverWatcher.getLogFileDetails();
    }

    @Override
    public Content getFile(final String fileName)
    {
        if (!getSecurityManager().authoriseLogsAccess(this))
        {
            throw new AccessControlException("Permission denied to access log content");
        }

        return _rolloverWatcher == null ? null : _rolloverWatcher.getFileContent(fileName);
    }

    @Override
    public Content getFiles(@Param(name = "fileName") Set<String> fileName)
    {
        if (!getSecurityManager().authoriseLogsAccess(this))
        {
            throw new AccessControlException("Permission denied to access log content");
        }

        return _rolloverWatcher == null ? null :_rolloverWatcher.getFilesAsZippedContent(fileName);
    }

    @Override
    public Content getAllFiles()
    {
        if (!getSecurityManager().authoriseLogsAccess(this))
        {
            throw new AccessControlException("Permission denied to access log content");
        }

        return _rolloverWatcher == null ? null : _rolloverWatcher.getAllFilesAsZippedContent();
    }

    @Override
    public void stopLogging()
    {
        super.stopLogging();
        _rolledPolicyExecutor.shutdown();
    }

    @Override
    public RollingPolicyDecorator.RolloverListener getRolloverListener()
    {
        return _rolloverWatcher;
    }

    @Override
    public ScheduledExecutorService getExecutorService()
    {
        return _rolledPolicyExecutor;
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context loggerContext)
    {
        SystemConfig<?> systemConfig = (SystemConfig<?>)getParent(Broker.class).getParent(SystemConfig.class);
        _logbackStatusListener = new BrokerFileLoggerStatusListener(this, systemConfig);
        _statusManager = loggerContext.getStatusManager();
        _statusManager.add(_logbackStatusListener);

        final RollingFileAppender<ILoggingEvent> appender = new RollingFileAppender<>();
        AppenderUtils.configureRollingFileAppender(this, loggerContext, appender);
        return appender;
    }

    @Override
    protected void onClose()
    {
        super.onClose();

        if (_statusManager != null)
        {
            _statusManager.remove(_logbackStatusListener);
        }
    }

    static class BrokerFileLoggerStatusListener implements StatusListener
    {
        private final SystemConfig<?> _systemConfig;
        private final BrokerFileLogger<?> _brokerFileLogger;

        public BrokerFileLoggerStatusListener(BrokerFileLogger<?> brokerFileLogger, SystemConfig<?> systemConfig)
        {
            _brokerFileLogger = brokerFileLogger;
            _systemConfig = systemConfig;
        }

        @Override
        public void addStatusEvent(Status status)
        {
            Throwable throwable = status.getThrowable();
            if (status.getEffectiveLevel() == Status.ERROR
                    && (throwable instanceof IOException || throwable instanceof IOError))
            {
                LOGGER.error("Unexpected I/O error whilst trying to write to log file. Log messages could be lost.", throwable);
                if (_brokerFileLogger.getContextValue(Boolean.class, BROKER_FAIL_ON_LOGGER_IO_ERROR))
                {
                    try
                    {
                        _brokerFileLogger.stopLogging();
                        _systemConfig.getEventLogger().message(BrokerMessages.FATAL_ERROR(
                                String.format("Shutting down the broker because context variable '%s' is set and unexpected i/o issue occurred: %s",
                                        BROKER_FAIL_ON_LOGGER_IO_ERROR, throwable.getMessage())));
                    }
                    finally
                    {
                        _systemConfig.closeAsync();
                    }
                }
            }
        }
    }

}
