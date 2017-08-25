package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
import org.apache.qpid.server.security.SecurityManager;
import org.apache.qpid.server.util.DaemonThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokerFileLoggerImpl extends AbstractBrokerLogger<BrokerFileLoggerImpl> implements BrokerFileLogger<BrokerFileLoggerImpl> , FileLoggerSettings {
    static class BrokerFileLoggerStatusListener implements StatusListener {
        private final SystemConfig<?> _systemConfig;

        private final BrokerFileLogger<?> _brokerFileLogger;

        public BrokerFileLoggerStatusListener(BrokerFileLogger<?> brokerFileLogger, SystemConfig<?> systemConfig) {
            MethodContext _bcornu_methode_context9 = new MethodContext(null);
            try {
                _brokerFileLogger = brokerFileLogger;
                CallChecker.varAssign(this._brokerFileLogger, "this._brokerFileLogger", 240, 7544, 7580);
                _systemConfig = systemConfig;
                CallChecker.varAssign(this._systemConfig, "this._systemConfig", 241, 7594, 7622);
            } finally {
                _bcornu_methode_context9.methodEnd();
            }
        }

        @Override
        public void addStatusEvent(Status status) {
            MethodContext _bcornu_methode_context80 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 245, 7643, 8811);
                CallChecker.varInit(status, "status", 245, 7643, 8811);
                CallChecker.varInit(this._brokerFileLogger, "_brokerFileLogger", 245, 7643, 8811);
                CallChecker.varInit(this._systemConfig, "_systemConfig", 245, 7643, 8811);
                Throwable throwable = CallChecker.init(Throwable.class);
                if (CallChecker.beforeDeref(status, Status.class, 247, 7747, 7752)) {
                    status = CallChecker.beforeCalled(status, Status.class, 247, 7747, 7752);
                    throwable = CallChecker.isCalled(status, Status.class, 247, 7747, 7752).getThrowable();
                    CallChecker.varAssign(throwable, "throwable", 247, 7747, 7752);
                }
                if (CallChecker.beforeDeref(status, Status.class, 248, 7786, 7791)) {
                    status = CallChecker.beforeCalled(status, Status.class, 248, 7786, 7791);
                    if (((CallChecker.isCalled(status, Status.class, 248, 7786, 7791).getEffectiveLevel()) == (Status.ERROR)) && ((throwable instanceof IOException) || (throwable instanceof IOError))) {
                        if (CallChecker.beforeDeref(BrokerFileLoggerImpl.LOGGER, Logger.class, 251, 7950, 7955)) {
                            CallChecker.isCalled(BrokerFileLoggerImpl.LOGGER, Logger.class, 251, 7950, 7955).error("Unexpected I/O error whilst trying to write to log file. Log messages could be lost.", throwable);
                        }
                        if (CallChecker.beforeDeref(_brokerFileLogger, BrokerFileLogger.class, 252, 8083, 8099)) {
                            if (CallChecker.isCalled(_brokerFileLogger, BrokerFileLogger.class, 252, 8083, 8099).getContextValue(Boolean.class, BrokerFileLogger.BROKER_FAIL_ON_LOGGER_IO_ERROR)) {
                                TryContext _bcornu_try_context_2 = new TryContext(2, BrokerFileLoggerImpl.class);
                                try {
                                    if (CallChecker.beforeDeref(_brokerFileLogger, BrokerFileLogger.class, 256, 8253, 8269)) {
                                        CallChecker.isCalled(_brokerFileLogger, BrokerFileLogger.class, 256, 8253, 8269).stopLogging();
                                    }
                                    if (CallChecker.beforeDeref(_systemConfig, SystemConfig.class, 257, 8310, 8322)) {
                                        if (CallChecker.beforeDeref(throwable, Throwable.class, 259, 8598, 8606)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(_systemConfig, SystemConfig.class, 257, 8310, 8322).getEventLogger(), EventLogger.class, 257, 8310, 8339)) {
                                                throwable = CallChecker.beforeCalled(throwable, Throwable.class, 259, 8598, 8606);
                                                CallChecker.isCalled(CallChecker.isCalled(_systemConfig, SystemConfig.class, 257, 8310, 8322).getEventLogger(), EventLogger.class, 257, 8310, 8339).message(BrokerMessages.FATAL_ERROR(String.format("Shutting down the broker because context variable '%s' is set and unexpected i/o issue occurred: %s", BrokerFileLogger.BROKER_FAIL_ON_LOGGER_IO_ERROR, CallChecker.isCalled(throwable, Throwable.class, 259, 8598, 8606).getMessage())));
                                            }
                                        }
                                    }
                                } finally {
                                    _bcornu_try_context_2.finallyStart(2);
                                    if (CallChecker.beforeDeref(_systemConfig, SystemConfig.class, 263, 8721, 8733)) {
                                        CallChecker.isCalled(_systemConfig, SystemConfig.class, 263, 8721, 8733).closeAsync();
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context80.methodEnd();
            }
        }
    }

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
    protected BrokerFileLoggerImpl(final Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context10 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    @Override
    protected void postResolveChildren() {
        MethodContext _bcornu_methode_context81 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 3203, 3500);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 86, 3203, 3500);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 86, 3203, 3500);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 86, 3203, 3500);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 86, 3203, 3500);
            CallChecker.varInit(this.TYPE, "TYPE", 86, 3203, 3500);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 86, 3203, 3500);
            CallChecker.varInit(this._statusManager, "_statusManager", 86, 3203, 3500);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 86, 3203, 3500);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 86, 3203, 3500);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 86, 3203, 3500);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 86, 3203, 3500);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 86, 3203, 3500);
            CallChecker.varInit(this._fileName, "_fileName", 86, 3203, 3500);
            CallChecker.varInit(this._layout, "_layout", 86, 3203, 3500);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 86, 3203, 3500);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 86, 3203, 3500);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 86, 3203, 3500);
            _rolloverWatcher = new RolloverWatcher(getFileName());
            CallChecker.varAssign(this._rolloverWatcher, "this._rolloverWatcher", 88, 3268, 3321);
            _rolledPolicyExecutor = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory(("RolledFileScanner-" + (getName()))));
            CallChecker.varAssign(this._rolledPolicyExecutor, "this._rolledPolicyExecutor", 89, 3331, 3456);
            super.postResolveChildren();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    @Override
    protected void validateChange(ConfiguredObject<?> proxyForValidation, Set<String> changedAttributes) {
        MethodContext _bcornu_methode_context82 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 3507, 4152);
            CallChecker.varInit(changedAttributes, "changedAttributes", 95, 3507, 4152);
            CallChecker.varInit(proxyForValidation, "proxyForValidation", 95, 3507, 4152);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 95, 3507, 4152);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 95, 3507, 4152);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 95, 3507, 4152);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 95, 3507, 4152);
            CallChecker.varInit(this.TYPE, "TYPE", 95, 3507, 4152);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 95, 3507, 4152);
            CallChecker.varInit(this._statusManager, "_statusManager", 95, 3507, 4152);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 95, 3507, 4152);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 95, 3507, 4152);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 95, 3507, 4152);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 95, 3507, 4152);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 95, 3507, 4152);
            CallChecker.varInit(this._fileName, "_fileName", 95, 3507, 4152);
            CallChecker.varInit(this._layout, "_layout", 95, 3507, 4152);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 95, 3507, 4152);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 95, 3507, 4152);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 95, 3507, 4152);
            super.validateChange(proxyForValidation, changedAttributes);
            BrokerFileLogger brokerFileLogger = CallChecker.varInit(((BrokerFileLogger) (proxyForValidation)), "brokerFileLogger", 98, 3705, 3778);
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 99, 3792, 3808)) {
                if (CallChecker.beforeDeref(brokerFileLogger, BrokerFileLogger.class, 99, 3834, 3849)) {
                    changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 99, 3792, 3808);
                    brokerFileLogger = CallChecker.beforeCalled(brokerFileLogger, BrokerFileLogger.class, 99, 3834, 3849);
                    if ((CallChecker.isCalled(changedAttributes, Set.class, 99, 3792, 3808).contains(BrokerFileLogger.FILE_NAME)) && ((CallChecker.isCalled(brokerFileLogger, BrokerFileLogger.class, 99, 3834, 3849).getFileName()) != null)) {
                        if (CallChecker.beforeDeref(brokerFileLogger, BrokerFileLogger.class, 101, 3947, 3962)) {
                            brokerFileLogger = CallChecker.beforeCalled(brokerFileLogger, BrokerFileLogger.class, 101, 3947, 3962);
                            AppenderUtils.validateLogFilePermissions(new File(CallChecker.isCalled(brokerFileLogger, BrokerFileLogger.class, 101, 3947, 3962).getFileName()));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 103, 4003, 4019)) {
                changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 103, 4003, 4019);
                if (CallChecker.isCalled(changedAttributes, Set.class, 103, 4003, 4019).contains(BrokerFileLogger.MAX_FILE_SIZE)) {
                    if (CallChecker.beforeDeref(brokerFileLogger, BrokerFileLogger.class, 105, 4102, 4117)) {
                        brokerFileLogger = CallChecker.beforeCalled(brokerFileLogger, BrokerFileLogger.class, 105, 4102, 4117);
                        AppenderUtils.validateMaxFileSize(CallChecker.isCalled(brokerFileLogger, BrokerFileLogger.class, 105, 4102, 4117).getMaxFileSize());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    @Override
    public String getFileName() {
        MethodContext _bcornu_methode_context83 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 110, 4159, 4237);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 110, 4159, 4237);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 110, 4159, 4237);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 110, 4159, 4237);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 110, 4159, 4237);
            CallChecker.varInit(this.TYPE, "TYPE", 110, 4159, 4237);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 110, 4159, 4237);
            CallChecker.varInit(this._statusManager, "_statusManager", 110, 4159, 4237);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 110, 4159, 4237);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 110, 4159, 4237);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 110, 4159, 4237);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 110, 4159, 4237);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 110, 4159, 4237);
            CallChecker.varInit(this._fileName, "_fileName", 110, 4159, 4237);
            CallChecker.varInit(this._layout, "_layout", 110, 4159, 4237);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 110, 4159, 4237);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 110, 4159, 4237);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 110, 4159, 4237);
            return _fileName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context83.methodEnd();
        }
    }

    @Override
    public boolean isRollDaily() {
        MethodContext _bcornu_methode_context84 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 116, 4244, 4324);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 116, 4244, 4324);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 116, 4244, 4324);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 116, 4244, 4324);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 116, 4244, 4324);
            CallChecker.varInit(this.TYPE, "TYPE", 116, 4244, 4324);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 116, 4244, 4324);
            CallChecker.varInit(this._statusManager, "_statusManager", 116, 4244, 4324);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 116, 4244, 4324);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 116, 4244, 4324);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 116, 4244, 4324);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 116, 4244, 4324);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 116, 4244, 4324);
            CallChecker.varInit(this._fileName, "_fileName", 116, 4244, 4324);
            CallChecker.varInit(this._layout, "_layout", 116, 4244, 4324);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 116, 4244, 4324);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 116, 4244, 4324);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 116, 4244, 4324);
            return _rollDaily;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    @Override
    public boolean isRollOnRestart() {
        MethodContext _bcornu_methode_context85 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 122, 4331, 4419);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 122, 4331, 4419);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 122, 4331, 4419);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 122, 4331, 4419);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 122, 4331, 4419);
            CallChecker.varInit(this.TYPE, "TYPE", 122, 4331, 4419);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 122, 4331, 4419);
            CallChecker.varInit(this._statusManager, "_statusManager", 122, 4331, 4419);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 122, 4331, 4419);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 122, 4331, 4419);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 122, 4331, 4419);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 122, 4331, 4419);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 122, 4331, 4419);
            CallChecker.varInit(this._fileName, "_fileName", 122, 4331, 4419);
            CallChecker.varInit(this._layout, "_layout", 122, 4331, 4419);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 122, 4331, 4419);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 122, 4331, 4419);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 122, 4331, 4419);
            return _rollOnRestart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    @Override
    public boolean isCompressOldFiles() {
        MethodContext _bcornu_methode_context86 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4426, 4520);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 128, 4426, 4520);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 128, 4426, 4520);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 128, 4426, 4520);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 128, 4426, 4520);
            CallChecker.varInit(this.TYPE, "TYPE", 128, 4426, 4520);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 128, 4426, 4520);
            CallChecker.varInit(this._statusManager, "_statusManager", 128, 4426, 4520);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 128, 4426, 4520);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 128, 4426, 4520);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 128, 4426, 4520);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 128, 4426, 4520);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 128, 4426, 4520);
            CallChecker.varInit(this._fileName, "_fileName", 128, 4426, 4520);
            CallChecker.varInit(this._layout, "_layout", 128, 4426, 4520);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 128, 4426, 4520);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 128, 4426, 4520);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 128, 4426, 4520);
            return _compressOldFiles;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    @Override
    public int getMaxHistory() {
        MethodContext _bcornu_methode_context87 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 134, 4527, 4606);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 134, 4527, 4606);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 134, 4527, 4606);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 134, 4527, 4606);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 134, 4527, 4606);
            CallChecker.varInit(this.TYPE, "TYPE", 134, 4527, 4606);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 134, 4527, 4606);
            CallChecker.varInit(this._statusManager, "_statusManager", 134, 4527, 4606);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 134, 4527, 4606);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 134, 4527, 4606);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 134, 4527, 4606);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 134, 4527, 4606);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 134, 4527, 4606);
            CallChecker.varInit(this._fileName, "_fileName", 134, 4527, 4606);
            CallChecker.varInit(this._layout, "_layout", 134, 4527, 4606);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 134, 4527, 4606);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 134, 4527, 4606);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 134, 4527, 4606);
            return _maxHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    @Override
    public int getMaxFileSize() {
        MethodContext _bcornu_methode_context88 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 140, 4613, 4694);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 140, 4613, 4694);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 140, 4613, 4694);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 140, 4613, 4694);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 140, 4613, 4694);
            CallChecker.varInit(this.TYPE, "TYPE", 140, 4613, 4694);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 140, 4613, 4694);
            CallChecker.varInit(this._statusManager, "_statusManager", 140, 4613, 4694);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 140, 4613, 4694);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 140, 4613, 4694);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 140, 4613, 4694);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 140, 4613, 4694);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 140, 4613, 4694);
            CallChecker.varInit(this._fileName, "_fileName", 140, 4613, 4694);
            CallChecker.varInit(this._layout, "_layout", 140, 4613, 4694);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 140, 4613, 4694);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 140, 4613, 4694);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 140, 4613, 4694);
            return _maxFileSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    @Override
    public String getLayout() {
        MethodContext _bcornu_methode_context89 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 146, 4701, 4775);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 146, 4701, 4775);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 146, 4701, 4775);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 146, 4701, 4775);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 146, 4701, 4775);
            CallChecker.varInit(this.TYPE, "TYPE", 146, 4701, 4775);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 146, 4701, 4775);
            CallChecker.varInit(this._statusManager, "_statusManager", 146, 4701, 4775);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 146, 4701, 4775);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 146, 4701, 4775);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 146, 4701, 4775);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 146, 4701, 4775);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 146, 4701, 4775);
            CallChecker.varInit(this._fileName, "_fileName", 146, 4701, 4775);
            CallChecker.varInit(this._layout, "_layout", 146, 4701, 4775);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 146, 4701, 4775);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 146, 4701, 4775);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 146, 4701, 4775);
            return _layout;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    @Override
    public List<LogFileDetails> getLogFiles() {
        MethodContext _bcornu_methode_context90 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 152, 4782, 4969);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 152, 4782, 4969);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 152, 4782, 4969);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 152, 4782, 4969);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 152, 4782, 4969);
            CallChecker.varInit(this.TYPE, "TYPE", 152, 4782, 4969);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 152, 4782, 4969);
            CallChecker.varInit(this._statusManager, "_statusManager", 152, 4782, 4969);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 152, 4782, 4969);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 152, 4782, 4969);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 152, 4782, 4969);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 152, 4782, 4969);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 152, 4782, 4969);
            CallChecker.varInit(this._fileName, "_fileName", 152, 4782, 4969);
            CallChecker.varInit(this._layout, "_layout", 152, 4782, 4969);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 152, 4782, 4969);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 152, 4782, 4969);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 152, 4782, 4969);
            if ((_rolloverWatcher) == null) {
                return Collections.<LogFileDetails>emptyList();
            }else {
                return _rolloverWatcher.getLogFileDetails();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LogFileDetails>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    @Override
    public Content getFile(final String fileName) {
        MethodContext _bcornu_methode_context91 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 158, 4976, 5309);
            CallChecker.varInit(fileName, "fileName", 158, 4976, 5309);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 158, 4976, 5309);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 158, 4976, 5309);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 158, 4976, 5309);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 158, 4976, 5309);
            CallChecker.varInit(this.TYPE, "TYPE", 158, 4976, 5309);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 158, 4976, 5309);
            CallChecker.varInit(this._statusManager, "_statusManager", 158, 4976, 5309);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 158, 4976, 5309);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 158, 4976, 5309);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 158, 4976, 5309);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 158, 4976, 5309);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 158, 4976, 5309);
            CallChecker.varInit(this._fileName, "_fileName", 158, 4976, 5309);
            CallChecker.varInit(this._layout, "_layout", 158, 4976, 5309);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 158, 4976, 5309);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 158, 4976, 5309);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 158, 4976, 5309);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 160, 5055, 5074)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 160, 5055, 5074).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getFileContent(fileName);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    @Override
    public Content getFiles(@Param(name = "fileName")
    Set<String> fileName) {
        MethodContext _bcornu_methode_context92 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 169, 5316, 5683);
            CallChecker.varInit(fileName, "fileName", 169, 5316, 5683);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 169, 5316, 5683);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 169, 5316, 5683);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 169, 5316, 5683);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 169, 5316, 5683);
            CallChecker.varInit(this.TYPE, "TYPE", 169, 5316, 5683);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 169, 5316, 5683);
            CallChecker.varInit(this._statusManager, "_statusManager", 169, 5316, 5683);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 169, 5316, 5683);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 169, 5316, 5683);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 169, 5316, 5683);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 169, 5316, 5683);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 169, 5316, 5683);
            CallChecker.varInit(this._fileName, "_fileName", 169, 5316, 5683);
            CallChecker.varInit(this._layout, "_layout", 169, 5316, 5683);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 169, 5316, 5683);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 169, 5316, 5683);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 169, 5316, 5683);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 171, 5421, 5440)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 171, 5421, 5440).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getFilesAsZippedContent(fileName);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    @Override
    public Content getAllFiles() {
        MethodContext _bcornu_methode_context93 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 180, 5690, 6010);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 180, 5690, 6010);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 180, 5690, 6010);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 180, 5690, 6010);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 180, 5690, 6010);
            CallChecker.varInit(this.TYPE, "TYPE", 180, 5690, 6010);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 180, 5690, 6010);
            CallChecker.varInit(this._statusManager, "_statusManager", 180, 5690, 6010);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 180, 5690, 6010);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 180, 5690, 6010);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 180, 5690, 6010);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 180, 5690, 6010);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 180, 5690, 6010);
            CallChecker.varInit(this._fileName, "_fileName", 180, 5690, 6010);
            CallChecker.varInit(this._layout, "_layout", 180, 5690, 6010);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 180, 5690, 6010);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 180, 5690, 6010);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 180, 5690, 6010);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 182, 5752, 5771)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 182, 5752, 5771).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Permission denied to access log content");
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((_rolloverWatcher) == null) {
                return null;
            }else {
                return _rolloverWatcher.getAllFilesAsZippedContent();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    @Override
    public void stopLogging() {
        MethodContext _bcornu_methode_context94 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 191, 6017, 6138);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 191, 6017, 6138);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 191, 6017, 6138);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 191, 6017, 6138);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 191, 6017, 6138);
            CallChecker.varInit(this.TYPE, "TYPE", 191, 6017, 6138);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 191, 6017, 6138);
            CallChecker.varInit(this._statusManager, "_statusManager", 191, 6017, 6138);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 191, 6017, 6138);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 191, 6017, 6138);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 191, 6017, 6138);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 191, 6017, 6138);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 191, 6017, 6138);
            CallChecker.varInit(this._fileName, "_fileName", 191, 6017, 6138);
            CallChecker.varInit(this._layout, "_layout", 191, 6017, 6138);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 191, 6017, 6138);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 191, 6017, 6138);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 191, 6017, 6138);
            super.stopLogging();
            if (CallChecker.beforeDeref(_rolledPolicyExecutor, ScheduledExecutorService.class, 194, 6100, 6120)) {
                _rolledPolicyExecutor = CallChecker.beforeCalled(_rolledPolicyExecutor, ScheduledExecutorService.class, 194, 6100, 6120);
                CallChecker.isCalled(_rolledPolicyExecutor, ScheduledExecutorService.class, 194, 6100, 6120).shutdown();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    @Override
    public RollingPolicyDecorator.RolloverListener getRolloverListener() {
        MethodContext _bcornu_methode_context95 = new MethodContext(RollingPolicyDecorator.RolloverListener.class);
        try {
            CallChecker.varInit(this, "this", 198, 6145, 6271);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 198, 6145, 6271);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 198, 6145, 6271);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 198, 6145, 6271);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 198, 6145, 6271);
            CallChecker.varInit(this.TYPE, "TYPE", 198, 6145, 6271);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 198, 6145, 6271);
            CallChecker.varInit(this._statusManager, "_statusManager", 198, 6145, 6271);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 198, 6145, 6271);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 198, 6145, 6271);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 198, 6145, 6271);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 198, 6145, 6271);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 198, 6145, 6271);
            CallChecker.varInit(this._fileName, "_fileName", 198, 6145, 6271);
            CallChecker.varInit(this._layout, "_layout", 198, 6145, 6271);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 198, 6145, 6271);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 198, 6145, 6271);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 198, 6145, 6271);
            return _rolloverWatcher;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RollingPolicyDecorator.RolloverListener) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    @Override
    public ScheduledExecutorService getExecutorService() {
        MethodContext _bcornu_methode_context96 = new MethodContext(ScheduledExecutorService.class);
        try {
            CallChecker.varInit(this, "this", 204, 6278, 6393);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 204, 6278, 6393);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 204, 6278, 6393);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 204, 6278, 6393);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 204, 6278, 6393);
            CallChecker.varInit(this.TYPE, "TYPE", 204, 6278, 6393);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 204, 6278, 6393);
            CallChecker.varInit(this._statusManager, "_statusManager", 204, 6278, 6393);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 204, 6278, 6393);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 204, 6278, 6393);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 204, 6278, 6393);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 204, 6278, 6393);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 204, 6278, 6393);
            CallChecker.varInit(this._fileName, "_fileName", 204, 6278, 6393);
            CallChecker.varInit(this._layout, "_layout", 204, 6278, 6393);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 204, 6278, 6393);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 204, 6278, 6393);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 204, 6278, 6393);
            return _rolledPolicyExecutor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ScheduledExecutorService) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context loggerContext) {
        MethodContext _bcornu_methode_context97 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 210, 6400, 7013);
            CallChecker.varInit(loggerContext, "loggerContext", 210, 6400, 7013);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 210, 6400, 7013);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 210, 6400, 7013);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 210, 6400, 7013);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 210, 6400, 7013);
            CallChecker.varInit(this.TYPE, "TYPE", 210, 6400, 7013);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 210, 6400, 7013);
            CallChecker.varInit(this._statusManager, "_statusManager", 210, 6400, 7013);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 210, 6400, 7013);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 210, 6400, 7013);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 210, 6400, 7013);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 210, 6400, 7013);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 210, 6400, 7013);
            CallChecker.varInit(this._fileName, "_fileName", 210, 6400, 7013);
            CallChecker.varInit(this._layout, "_layout", 210, 6400, 7013);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 210, 6400, 7013);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 210, 6400, 7013);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 210, 6400, 7013);
            SystemConfig<?> systemConfig = CallChecker.init(SystemConfig.class);
            if (CallChecker.beforeDeref(getParent(Broker.class), Broker.class, 212, 6556, 6578)) {
                systemConfig = ((SystemConfig<?>) (CallChecker.isCalled(getParent(Broker.class), Broker.class, 212, 6556, 6578).getParent(SystemConfig.class)));
                CallChecker.varAssign(systemConfig, "systemConfig", 212, 6556, 6578);
            }
            _logbackStatusListener = new BrokerFileLoggerImpl.BrokerFileLoggerStatusListener(this, systemConfig);
            CallChecker.varAssign(this._logbackStatusListener, "this._logbackStatusListener", 213, 6619, 6698);
            if (CallChecker.beforeDeref(loggerContext, Context.class, 214, 6725, 6737)) {
                loggerContext = CallChecker.beforeCalled(loggerContext, Context.class, 214, 6725, 6737);
                _statusManager = CallChecker.isCalled(loggerContext, Context.class, 214, 6725, 6737).getStatusManager();
                CallChecker.varAssign(this._statusManager, "this._statusManager", 214, 6708, 6757);
            }
            if (CallChecker.beforeDeref(_statusManager, StatusManager.class, 215, 6767, 6780)) {
                _statusManager = CallChecker.beforeCalled(_statusManager, StatusManager.class, 215, 6767, 6780);
                CallChecker.isCalled(_statusManager, StatusManager.class, 215, 6767, 6780).add(_logbackStatusListener);
            }
            final RollingFileAppender<ILoggingEvent> appender = CallChecker.varInit(new RollingFileAppender<>(), "appender", 217, 6820, 6899);
            AppenderUtils.configureRollingFileAppender(this, loggerContext, appender);
            return appender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    @Override
    protected void onClose() {
        MethodContext _bcornu_methode_context98 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 223, 7020, 7210);
            CallChecker.varInit(this.DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR, "DEFAULT_BROKER_FAIL_ON_LOGGER_IO_ERROR", 223, 7020, 7210);
            CallChecker.varInit(this.BROKER_FAIL_ON_LOGGER_IO_ERROR, "BROKER_FAIL_ON_LOGGER_IO_ERROR", 223, 7020, 7210);
            CallChecker.varInit(this.MAX_FILE_SIZE, "MAX_FILE_SIZE", 223, 7020, 7210);
            CallChecker.varInit(this.FILE_NAME, "FILE_NAME", 223, 7020, 7210);
            CallChecker.varInit(this.TYPE, "TYPE", 223, 7020, 7210);
            CallChecker.varInit(this._logbackStatusListener, "_logbackStatusListener", 223, 7020, 7210);
            CallChecker.varInit(this._statusManager, "_statusManager", 223, 7020, 7210);
            CallChecker.varInit(this._maxFileSize, "_maxFileSize", 223, 7020, 7210);
            CallChecker.varInit(this._maxHistory, "_maxHistory", 223, 7020, 7210);
            CallChecker.varInit(this._compressOldFiles, "_compressOldFiles", 223, 7020, 7210);
            CallChecker.varInit(this._rollOnRestart, "_rollOnRestart", 223, 7020, 7210);
            CallChecker.varInit(this._rollDaily, "_rollDaily", 223, 7020, 7210);
            CallChecker.varInit(this._fileName, "_fileName", 223, 7020, 7210);
            CallChecker.varInit(this._layout, "_layout", 223, 7020, 7210);
            CallChecker.varInit(this._rolledPolicyExecutor, "_rolledPolicyExecutor", 223, 7020, 7210);
            CallChecker.varInit(this._rolloverWatcher, "_rolloverWatcher", 223, 7020, 7210);
            CallChecker.varInit(LOGGER, "org.apache.qpid.server.logging.BrokerFileLoggerImpl.LOGGER", 223, 7020, 7210);
            super.onClose();
            if ((_statusManager) != null) {
                _statusManager.remove(_logbackStatusListener);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }
}

