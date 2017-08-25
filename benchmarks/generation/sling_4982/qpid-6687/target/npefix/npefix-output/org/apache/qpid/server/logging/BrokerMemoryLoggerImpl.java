package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.apache.qpid.server.security.SecurityManager;

public class BrokerMemoryLoggerImpl extends AbstractBrokerLogger<BrokerMemoryLoggerImpl> implements BrokerMemoryLogger<BrokerMemoryLoggerImpl> {
    @ManagedAttributeField
    private int _maxRecords;

    private LogRecorder _logRecorder;

    @ManagedObjectFactoryConstructor
    protected BrokerMemoryLoggerImpl(final Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context26 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    @Override
    public int getMaxRecords() {
        MethodContext _bcornu_methode_context298 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 54, 1909, 1988);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 54, 1909, 1988);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 54, 1909, 1988);
            CallChecker.varInit(this.TYPE, "TYPE", 54, 1909, 1988);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 54, 1909, 1988);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 54, 1909, 1988);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 54, 1909, 1988);
            return _maxRecords;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    @Override
    protected void postResolveChildren() {
        MethodContext _bcornu_methode_context299 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 60, 1995, 2278);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 60, 1995, 2278);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 60, 1995, 2278);
            CallChecker.varInit(this.TYPE, "TYPE", 60, 1995, 2278);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 60, 1995, 2278);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 60, 1995, 2278);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 60, 1995, 2278);
            int maxRecords = CallChecker.varInit(((int) (getMaxRecords())), "maxRecords", 63, 2166, 2198);
            validateLimits(maxRecords);
            super.postResolveChildren();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    @Override
    protected void validateChange(final ConfiguredObject<?> proxyForValidation, final Set<String> changedAttributes) {
        MethodContext _bcornu_methode_context300 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 2285, 2764);
            CallChecker.varInit(changedAttributes, "changedAttributes", 70, 2285, 2764);
            CallChecker.varInit(proxyForValidation, "proxyForValidation", 70, 2285, 2764);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 70, 2285, 2764);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 70, 2285, 2764);
            CallChecker.varInit(this.TYPE, "TYPE", 70, 2285, 2764);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 70, 2285, 2764);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 70, 2285, 2764);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 70, 2285, 2764);
            super.validateChange(proxyForValidation, changedAttributes);
            BrokerMemoryLogger brokerMemoryLogger = CallChecker.varInit(((BrokerMemoryLogger) (proxyForValidation)), "brokerMemoryLogger", 73, 2495, 2574);
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 74, 2588, 2604)) {
                if (CallChecker.isCalled(changedAttributes, Set.class, 74, 2588, 2604).contains(BrokerMemoryLogger.MAX_RECORDS)) {
                    brokerMemoryLogger = CallChecker.beforeCalled(brokerMemoryLogger, BrokerMemoryLogger.class, 76, 2674, 2691);
                    final int maxRecords = CallChecker.varInit(((int) (CallChecker.isCalled(brokerMemoryLogger, BrokerMemoryLogger.class, 76, 2674, 2691).getMaxRecords())), "maxRecords", 76, 2651, 2708);
                    validateLimits(maxRecords);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }

    private void validateLimits(int maxRecords) {
        MethodContext _bcornu_methode_context301 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 81, 2771, 3231);
            CallChecker.varInit(maxRecords, "maxRecords", 81, 2771, 3231);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 81, 2771, 3231);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 81, 2771, 3231);
            CallChecker.varInit(this.TYPE, "TYPE", 81, 2771, 3231);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 81, 2771, 3231);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 81, 2771, 3231);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 81, 2771, 3231);
            if (maxRecords > (BrokerMemoryLogger.MAX_RECORD_LIMIT)) {
                throw new IllegalConfigurationException(String.format("Maximum number of records (%d) exceeds limit (%d)", maxRecords, BrokerMemoryLogger.MAX_RECORD_LIMIT));
            }else
                if (maxRecords < 1) {
                    throw new IllegalConfigurationException(String.format("Maximum number of records (%d) must be larger than zero", maxRecords));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context301.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context context) {
        MethodContext _bcornu_methode_context302 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 94, 3238, 3634);
            CallChecker.varInit(context, "context", 94, 3238, 3634);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 94, 3238, 3634);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 94, 3238, 3634);
            CallChecker.varInit(this.TYPE, "TYPE", 94, 3238, 3634);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 94, 3238, 3634);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 94, 3238, 3634);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 94, 3238, 3634);
            if ((_logRecorder) != null) {
                throw new IllegalStateException("RecordEventAppender is already created");
            }
            RecordEventAppender appender = CallChecker.varInit(new RecordEventAppender(getMaxRecords()), "appender", 100, 3481, 3553);
            _logRecorder = new LogRecorder(appender);
            CallChecker.varAssign(this._logRecorder, "this._logRecorder", 101, 3563, 3603);
            return appender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context302.methodEnd();
        }
    }

    @Override
    public Collection<LogRecord> getLogEntries(long lastLogId) {
        MethodContext _bcornu_methode_context303 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 106, 3641, 4147);
            CallChecker.varInit(lastLogId, "lastLogId", 106, 3641, 4147);
            CallChecker.varInit(this.MAX_RECORD_LIMIT, "MAX_RECORD_LIMIT", 106, 3641, 4147);
            CallChecker.varInit(this.BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR, "BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR", 106, 3641, 4147);
            CallChecker.varInit(this.TYPE, "TYPE", 106, 3641, 4147);
            CallChecker.varInit(this.MAX_RECORDS, "MAX_RECORDS", 106, 3641, 4147);
            CallChecker.varInit(this._logRecorder, "_logRecorder", 106, 3641, 4147);
            CallChecker.varInit(this._maxRecords, "_maxRecords", 106, 3641, 4147);
            if (CallChecker.beforeDeref(getSecurityManager(), SecurityManager.class, 108, 3733, 3752)) {
                if (!(CallChecker.isCalled(getSecurityManager(), SecurityManager.class, 108, 3733, 3752).authoriseLogsAccess(this))) {
                    throw new AccessControlException("Access to log entries is denied");
                }
            }else
                throw new AbnormalExecutionError();
            
            List<LogRecord> logRecords = CallChecker.varInit(new ArrayList<>(), "logRecords", 113, 3891, 3937);
            if (CallChecker.beforeDeref(_logRecorder, Collection.class, 114, 3970, 3981)) {
                for (LogRecord record : _logRecorder) {
                    if (CallChecker.beforeDeref(record, LogRecord.class, 116, 4010, 4015)) {
                        if ((CallChecker.isCalled(record, LogRecord.class, 116, 4010, 4015).getId()) > lastLogId) {
                            if (CallChecker.beforeDeref(logRecords, List.class, 118, 4068, 4077)) {
                                logRecords = CallChecker.beforeCalled(logRecords, List.class, 118, 4068, 4077);
                                CallChecker.isCalled(logRecords, List.class, 118, 4068, 4077).add(record);
                            }
                        }
                    }
                }
            }
            return logRecords;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<LogRecord>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context303.methodEnd();
        }
    }
}

