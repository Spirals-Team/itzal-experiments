package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.model.AbstractConfiguredObject;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.State;
import org.apache.qpid.server.model.StateTransition;

public abstract class AbstractNameAndLevelFilter<X extends AbstractNameAndLevelFilter<X>> extends AbstractConfiguredObject<X> {
    @ManagedAttributeField
    private String _loggerName;

    @ManagedAttributeField(afterSet = "logLevelAfterSet")
    private LogLevel _level;

    private LoggerNameAndLevelFilter _filter;

    protected AbstractNameAndLevelFilter(final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parents, Map<String, Object> attributes) {
        super(parents, attributes);
        MethodContext _bcornu_methode_context37 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    @Override
    protected void postResolve() {
        MethodContext _bcornu_methode_context589 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 34, 1195, 1376);
            CallChecker.varInit(this._filter, "_filter", 34, 1195, 1376);
            CallChecker.varInit(this._level, "_level", 34, 1195, 1376);
            CallChecker.varInit(this._loggerName, "_loggerName", 34, 1195, 1376);
            super.postResolve();
            final LogLevel npe_invocation_var74 = getLevel();
            if (CallChecker.beforeDeref(npe_invocation_var74, LogLevel.class, 37, 1351, 1360)) {
                _filter = new LoggerNameAndLevelFilter(getLoggerName(), Level.toLevel(CallChecker.isCalled(npe_invocation_var74, LogLevel.class, 37, 1351, 1360).name()));
                CallChecker.varAssign(this._filter, "this._filter", 37, 1281, 1370);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context589.methodEnd();
        }
    }

    public String getLoggerName() {
        MethodContext _bcornu_methode_context590 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 41, 1384, 1452);
            CallChecker.varInit(this._filter, "_filter", 41, 1384, 1452);
            CallChecker.varInit(this._level, "_level", 41, 1384, 1452);
            CallChecker.varInit(this._loggerName, "_loggerName", 41, 1384, 1452);
            return _loggerName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context590.methodEnd();
        }
    }

    public LogLevel getLevel() {
        MethodContext _bcornu_methode_context591 = new MethodContext(LogLevel.class);
        try {
            CallChecker.varInit(this, "this", 46, 1459, 1519);
            CallChecker.varInit(this._filter, "_filter", 46, 1459, 1519);
            CallChecker.varInit(this._level, "_level", 46, 1459, 1519);
            CallChecker.varInit(this._loggerName, "_loggerName", 46, 1459, 1519);
            return _level;
        } catch (ForceReturn _bcornu_return_t) {
            return ((LogLevel) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context591.methodEnd();
        }
    }

    private void logLevelAfterSet() {
        MethodContext _bcornu_methode_context592 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 51, 1526, 1681);
            CallChecker.varInit(this._filter, "_filter", 51, 1526, 1681);
            CallChecker.varInit(this._level, "_level", 51, 1526, 1681);
            CallChecker.varInit(this._loggerName, "_loggerName", 51, 1526, 1681);
            if ((_filter) != null) {
                final LogLevel npe_invocation_var75 = getLevel();
                if (CallChecker.beforeDeref(npe_invocation_var75, LogLevel.class, 55, 1646, 1655)) {
                    _filter.setLevel(Level.toLevel(CallChecker.isCalled(npe_invocation_var75, LogLevel.class, 55, 1646, 1655).name()));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context592.methodEnd();
        }
    }

    public Filter<ILoggingEvent> asFilter() {
        MethodContext _bcornu_methode_context593 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 59, 1688, 1762);
            CallChecker.varInit(this._filter, "_filter", 59, 1688, 1762);
            CallChecker.varInit(this._level, "_level", 59, 1688, 1762);
            CallChecker.varInit(this._loggerName, "_loggerName", 59, 1688, 1762);
            return _filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context593.methodEnd();
        }
    }

    @StateTransition(currentState = { State.ACTIVE , State.ERRORED , State.UNINITIALIZED }, desiredState = State.DELETED)
    private ListenableFuture<Void> doDelete() {
        MethodContext _bcornu_methode_context595 = new MethodContext(ListenableFuture.class);
        try {
            CallChecker.varInit(this, "this", 65, 1769, 2407);
            CallChecker.varInit(this._filter, "_filter", 65, 1769, 2407);
            CallChecker.varInit(this._level, "_level", 65, 1769, 2407);
            CallChecker.varInit(this._loggerName, "_loggerName", 65, 1769, 2407);
            final SettableFuture<Void> returnVal = CallChecker.varInit(SettableFuture.create(), "returnVal", 67, 1947, 2009);
            if (CallChecker.beforeDeref(getTaskExecutor(), TaskExecutor.class, 79, 2343, 2359)) {
                if (CallChecker.beforeDeref(closeAsync(), ListenableFuture.class, 68, 2019, 2030)) {
                    CallChecker.isCalled(closeAsync(), ListenableFuture.class, 68, 2019, 2030).addListener(new Runnable() {
                        @Override
                        public void run() {
                            MethodContext _bcornu_methode_context594 = new MethodContext(void.class);
                            try {
                                CallChecker.varInit(this, "this", 71, 2081, 2330);
                                deleted();
                                QpidLoggerTurboFilter.filterRemovedFromRootContext(_filter);
                                setState(State.DELETED);
                                if (CallChecker.beforeDeref(returnVal, SettableFuture.class, 76, 2296, 2304)) {
                                    CallChecker.isCalled(returnVal, SettableFuture.class, 76, 2296, 2304).set(null);
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                _bcornu_return_t.getDecision().getValue();
                                return ;
                            } finally {
                                _bcornu_methode_context594.methodEnd();
                            }
                        }
                    }, CallChecker.isCalled(getTaskExecutor(), TaskExecutor.class, 79, 2343, 2359).getExecutor());
                }
            }
            return returnVal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenableFuture<Void>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context595.methodEnd();
        }
    }

    @StateTransition(currentState = { State.ERRORED , State.UNINITIALIZED }, desiredState = State.ACTIVE)
    private ListenableFuture<Void> doActivate() {
        MethodContext _bcornu_methode_context596 = new MethodContext(ListenableFuture.class);
        try {
            CallChecker.varInit(this, "this", 84, 2414, 2718);
            CallChecker.varInit(this._filter, "_filter", 84, 2414, 2718);
            CallChecker.varInit(this._level, "_level", 84, 2414, 2718);
            CallChecker.varInit(this._loggerName, "_loggerName", 84, 2414, 2718);
            setState(State.ACTIVE);
            QpidLoggerTurboFilter.filterAddedToRootContext(_filter);
            return Futures.immediateFuture(null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenableFuture<Void>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context596.methodEnd();
        }
    }
}

