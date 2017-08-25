package org.apache.qpid.server.logging;

import ch.qos.logback.classic.net.SocketAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.util.Duration;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.slf4j.MDC;

public class BrokerLogbackSocketLoggerImpl extends AbstractBrokerLogger<BrokerLogbackSocketLoggerImpl> implements BrokerLogbackSocketLogger<BrokerLogbackSocketLoggerImpl> {
    @ManagedAttributeField
    private String _remoteHost;

    @ManagedAttributeField
    private long _reconnectionDelay;

    @ManagedAttributeField
    private int _port;

    @ManagedAttributeField
    private boolean _includeCallerData;

    @ManagedAttributeField
    private Map<String, String> _mappedDiagnosticContext;

    @ManagedObjectFactoryConstructor
    protected BrokerLogbackSocketLoggerImpl(final Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context49 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    @Override
    public String getRemoteHost() {
        MethodContext _bcornu_methode_context728 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 66, 2123, 2205);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 66, 2123, 2205);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 66, 2123, 2205);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 66, 2123, 2205);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 66, 2123, 2205);
            CallChecker.varInit(this.PORT, "PORT", 66, 2123, 2205);
            CallChecker.varInit(this.TYPE, "TYPE", 66, 2123, 2205);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 66, 2123, 2205);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 66, 2123, 2205);
            CallChecker.varInit(this._port, "_port", 66, 2123, 2205);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 66, 2123, 2205);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 66, 2123, 2205);
            return _remoteHost;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context728.methodEnd();
        }
    }

    @Override
    public int getPort() {
        MethodContext _bcornu_methode_context729 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 72, 2212, 2279);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 72, 2212, 2279);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 72, 2212, 2279);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 72, 2212, 2279);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 72, 2212, 2279);
            CallChecker.varInit(this.PORT, "PORT", 72, 2212, 2279);
            CallChecker.varInit(this.TYPE, "TYPE", 72, 2212, 2279);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 72, 2212, 2279);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 72, 2212, 2279);
            CallChecker.varInit(this._port, "_port", 72, 2212, 2279);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 72, 2212, 2279);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 72, 2212, 2279);
            return _port;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context729.methodEnd();
        }
    }

    @Override
    public long getReconnectionDelay() {
        MethodContext _bcornu_methode_context730 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 78, 2286, 2380);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 78, 2286, 2380);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 78, 2286, 2380);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 78, 2286, 2380);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 78, 2286, 2380);
            CallChecker.varInit(this.PORT, "PORT", 78, 2286, 2380);
            CallChecker.varInit(this.TYPE, "TYPE", 78, 2286, 2380);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 78, 2286, 2380);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 78, 2286, 2380);
            CallChecker.varInit(this._port, "_port", 78, 2286, 2380);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 78, 2286, 2380);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 78, 2286, 2380);
            return _reconnectionDelay;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context730.methodEnd();
        }
    }

    @Override
    public boolean getIncludeCallerData() {
        MethodContext _bcornu_methode_context731 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 84, 2387, 2484);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 84, 2387, 2484);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 84, 2387, 2484);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 84, 2387, 2484);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 84, 2387, 2484);
            CallChecker.varInit(this.PORT, "PORT", 84, 2387, 2484);
            CallChecker.varInit(this.TYPE, "TYPE", 84, 2387, 2484);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 84, 2387, 2484);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 84, 2387, 2484);
            CallChecker.varInit(this._port, "_port", 84, 2387, 2484);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 84, 2387, 2484);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 84, 2387, 2484);
            return _includeCallerData;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context731.methodEnd();
        }
    }

    @Override
    public Map<String, String> getMappedDiagnosticContext() {
        MethodContext _bcornu_methode_context732 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 90, 2491, 2612);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 90, 2491, 2612);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 90, 2491, 2612);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 90, 2491, 2612);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 90, 2491, 2612);
            CallChecker.varInit(this.PORT, "PORT", 90, 2491, 2612);
            CallChecker.varInit(this.TYPE, "TYPE", 90, 2491, 2612);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 90, 2491, 2612);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 90, 2491, 2612);
            CallChecker.varInit(this._port, "_port", 90, 2491, 2612);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 90, 2491, 2612);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 90, 2491, 2612);
            return _mappedDiagnosticContext;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context732.methodEnd();
        }
    }

    @Override
    protected Appender<ILoggingEvent> createAppenderInstance(Context loggerContext) {
        MethodContext _bcornu_methode_context734 = new MethodContext(Appender.class);
        try {
            CallChecker.varInit(this, "this", 96, 2619, 4728);
            CallChecker.varInit(loggerContext, "loggerContext", 96, 2619, 4728);
            CallChecker.varInit(this.MAPPED_DIAGNOSTIC_CONTEXT, "MAPPED_DIAGNOSTIC_CONTEXT", 96, 2619, 4728);
            CallChecker.varInit(this.INCLUDE_CALLER_DATA, "INCLUDE_CALLER_DATA", 96, 2619, 4728);
            CallChecker.varInit(this.RECONNECTION_DELAY, "RECONNECTION_DELAY", 96, 2619, 4728);
            CallChecker.varInit(this.REMOTE_HOST, "REMOTE_HOST", 96, 2619, 4728);
            CallChecker.varInit(this.PORT, "PORT", 96, 2619, 4728);
            CallChecker.varInit(this.TYPE, "TYPE", 96, 2619, 4728);
            CallChecker.varInit(this._mappedDiagnosticContext, "_mappedDiagnosticContext", 96, 2619, 4728);
            CallChecker.varInit(this._includeCallerData, "_includeCallerData", 96, 2619, 4728);
            CallChecker.varInit(this._port, "_port", 96, 2619, 4728);
            CallChecker.varInit(this._reconnectionDelay, "_reconnectionDelay", 96, 2619, 4728);
            CallChecker.varInit(this._remoteHost, "_remoteHost", 96, 2619, 4728);
            SocketAppender socketAppender = new SocketAppender() {
                @Override
                protected void append(final ILoggingEvent event) {
                    MethodContext _bcornu_methode_context733 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 101, 2866, 4397);
                        CallChecker.varInit(event, "event", 101, 2866, 4397);
                        Set<String> keys = CallChecker.varInit(new HashSet<>(), "keys", 103, 3063, 3097);
                        TryContext _bcornu_try_context_4 = new TryContext(4, BrokerLogbackSocketLoggerImpl.class);
                        try {
                            _mappedDiagnosticContext = CallChecker.beforeCalled(_mappedDiagnosticContext, Map.class, 106, 3292, 3315);
                            for (Map.Entry<String, String> entry : CallChecker.isCalled(_mappedDiagnosticContext, Map.class, 106, 3292, 3315).entrySet()) {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 108, 3447, 3451)) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 108, 3463, 3467)) {
                                        MDC.put(CallChecker.isCalled(entry, Map.Entry.class, 108, 3447, 3451).getKey(), CallChecker.isCalled(entry, Map.Entry.class, 108, 3463, 3467).getValue());
                                    }
                                }
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 109, 3547, 3551)) {
                                    if (CallChecker.beforeDeref(keys, Set.class, 109, 3538, 3541)) {
                                        keys = CallChecker.beforeCalled(keys, Set.class, 109, 3538, 3541);
                                        CallChecker.isCalled(keys, Set.class, 109, 3538, 3541).add(CallChecker.isCalled(entry, Map.Entry.class, 109, 3547, 3551).getKey());
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(event, ILoggingEvent.class, 113, 3779, 3783)) {
                                CallChecker.isCalled(event, ILoggingEvent.class, 113, 3779, 3783).prepareForDeferredProcessing();
                            }
                            super.append(event);
                        } finally {
                            _bcornu_try_context_4.finallyStart(4);
                            if (CallChecker.beforeDeref(keys, void.class, 118, 4116, 4119)) {
                                for (String key : keys) {
                                    MDC.remove(key);
                                }
                            }
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context733.methodEnd();
                    }
                }
            };
            if (CallChecker.beforeDeref(socketAppender, SocketAppender.class, 125, 4450, 4463)) {
                socketAppender = CallChecker.beforeCalled(socketAppender, SocketAppender.class, 125, 4450, 4463);
                CallChecker.isCalled(socketAppender, SocketAppender.class, 125, 4450, 4463).setPort(_port);
            }
            if (CallChecker.beforeDeref(socketAppender, SocketAppender.class, 126, 4489, 4502)) {
                socketAppender = CallChecker.beforeCalled(socketAppender, SocketAppender.class, 126, 4489, 4502);
                CallChecker.isCalled(socketAppender, SocketAppender.class, 126, 4489, 4502).setRemoteHost(_remoteHost);
            }
            if (CallChecker.beforeDeref(socketAppender, SocketAppender.class, 127, 4540, 4553)) {
                socketAppender = CallChecker.beforeCalled(socketAppender, SocketAppender.class, 127, 4540, 4553);
                CallChecker.isCalled(socketAppender, SocketAppender.class, 127, 4540, 4553).setIncludeCallerData(_includeCallerData);
            }
            if (CallChecker.beforeDeref(socketAppender, SocketAppender.class, 128, 4605, 4618)) {
                socketAppender = CallChecker.beforeCalled(socketAppender, SocketAppender.class, 128, 4605, 4618);
                CallChecker.isCalled(socketAppender, SocketAppender.class, 128, 4605, 4618).setReconnectionDelay(Duration.buildByMilliseconds(_reconnectionDelay));
            }
            return socketAppender;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Appender<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context734.methodEnd();
        }
    }
}

