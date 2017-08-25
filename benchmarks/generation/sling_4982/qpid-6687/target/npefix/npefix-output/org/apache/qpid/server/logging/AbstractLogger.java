package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Map;
import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.model.AbstractConfiguredObject;
import org.apache.qpid.server.model.ConfigurationChangeListener;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.ConfiguredObjectFactory;
import org.apache.qpid.server.model.State;
import org.apache.qpid.server.model.StateTransition;
import org.slf4j.LoggerFactory;
import static org.slf4j.Logger.ROOT_LOGGER_NAME;

public abstract class AbstractLogger<X extends AbstractLogger<X>> extends AbstractConfiguredObject<X> {
    private class FilterListener implements ConfigurationChangeListener {
        @Override
        public void childAdded(final ConfiguredObject<?> object, final ConfiguredObject<?> child) {
            MethodContext _bcornu_methode_context829 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 151, 5097, 5347);
                CallChecker.varInit(child, "child", 151, 5097, 5347);
                CallChecker.varInit(object, "object", 151, 5097, 5347);
                if (child instanceof LoggerFilter) {
                    addFilter(((LoggerFilter) (child)));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context829.methodEnd();
            }
        }

        @Override
        public void childRemoved(final ConfiguredObject<?> object, final ConfiguredObject<?> child) {
            MethodContext _bcornu_methode_context830 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 160, 5358, 5613);
                CallChecker.varInit(child, "child", 160, 5358, 5613);
                CallChecker.varInit(object, "object", 160, 5358, 5613);
                if (child instanceof LoggerFilter) {
                    removeFilter(((LoggerFilter) (child)));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context830.methodEnd();
            }
        }

        @Override
        public void stateChanged(final ConfiguredObject<?> object, final State oldState, final State newState) {
            MethodContext _bcornu_methode_context831 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 169, 5624, 5763);
                CallChecker.varInit(newState, "newState", 169, 5624, 5763);
                CallChecker.varInit(oldState, "oldState", 169, 5624, 5763);
                CallChecker.varInit(object, "object", 169, 5624, 5763);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context831.methodEnd();
            }
        }

        @Override
        public void attributeSet(final ConfiguredObject<?> object, final String attributeName, final Object oldAttributeValue, final Object newAttributeValue) {
            MethodContext _bcornu_methode_context832 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 174, 5774, 6060);
                CallChecker.varInit(newAttributeValue, "newAttributeValue", 174, 5774, 6060);
                CallChecker.varInit(oldAttributeValue, "oldAttributeValue", 174, 5774, 6060);
                CallChecker.varInit(attributeName, "attributeName", 174, 5774, 6060);
                CallChecker.varInit(object, "object", 174, 5774, 6060);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context832.methodEnd();
            }
        }

        @Override
        public void bulkChangeStart(final ConfiguredObject<?> object) {
            MethodContext _bcornu_methode_context833 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 182, 6071, 6169);
                CallChecker.varInit(object, "object", 182, 6071, 6169);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context833.methodEnd();
            }
        }

        @Override
        public void bulkChangeEnd(final ConfiguredObject<?> object) {
            MethodContext _bcornu_methode_context834 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 187, 6180, 6276);
                CallChecker.varInit(object, "object", 187, 6180, 6276);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context834.methodEnd();
            }
        }
    }

    private static final Logger ROOT_LOGGER = ((Logger) (LoggerFactory.getLogger(ROOT_LOGGER_NAME)));

    private final CompositeFilter _compositeFilter = new CompositeFilter();

    protected AbstractLogger(Map<String, Object> attributes, ConfiguredObject<?> parent) {
        super(AbstractConfiguredObject.parentsMap(parent), attributes);
        MethodContext _bcornu_methode_context60 = new MethodContext(null);
        try {
            addChangeListener(new FilterListener());
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    protected final void addFilter(LoggerFilter filter) {
        MethodContext _bcornu_methode_context835 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 54, 2113, 2219);
            CallChecker.varInit(filter, "filter", 54, 2113, 2219);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 54, 2113, 2219);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 54, 2113, 2219);
            if (CallChecker.beforeDeref(_compositeFilter, CompositeFilter.class, 56, 2179, 2194)) {
                CallChecker.isCalled(_compositeFilter, CompositeFilter.class, 56, 2179, 2194).addFilter(filter);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context835.methodEnd();
        }
    }

    protected final void removeFilter(LoggerFilter filter) {
        MethodContext _bcornu_methode_context836 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 59, 2226, 2338);
            CallChecker.varInit(filter, "filter", 59, 2226, 2338);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 59, 2226, 2338);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 59, 2226, 2338);
            if (CallChecker.beforeDeref(_compositeFilter, CompositeFilter.class, 61, 2295, 2310)) {
                CallChecker.isCalled(_compositeFilter, CompositeFilter.class, 61, 2295, 2310).removeFilter(filter);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context836.methodEnd();
        }
    }

    @Override
    protected void postResolveChildren() {
        MethodContext _bcornu_methode_context837 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 65, 2345, 3267);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 65, 2345, 3267);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 65, 2345, 3267);
            super.postResolveChildren();
            LoggerContext loggerContext = CallChecker.init(LoggerContext.class);
            if (CallChecker.beforeDeref(AbstractLogger.ROOT_LOGGER, Logger.class, 69, 2478, 2488)) {
                loggerContext = CallChecker.isCalled(AbstractLogger.ROOT_LOGGER, Logger.class, 69, 2478, 2488).getLoggerContext();
                CallChecker.varAssign(loggerContext, "loggerContext", 69, 2478, 2488);
            }
            QpidLoggerTurboFilter.installIfNecessary(loggerContext);
            Appender<ILoggingEvent> appender = CallChecker.varInit(createAppenderInstance(loggerContext), "appender", 71, 2583, 2655);
            if (CallChecker.beforeDeref(appender, Appender.class, 72, 2665, 2672)) {
                appender = CallChecker.beforeCalled(appender, Appender.class, 72, 2665, 2672);
                CallChecker.isCalled(appender, Appender.class, 72, 2665, 2672).setName(getName());
            }
            if (CallChecker.beforeDeref(appender, Appender.class, 73, 2702, 2709)) {
                appender = CallChecker.beforeCalled(appender, Appender.class, 73, 2702, 2709);
                CallChecker.isCalled(appender, Appender.class, 73, 2702, 2709).setContext(loggerContext);
            }
            for (LoggerFilter filter : getLoggerFilters()) {
                if (CallChecker.beforeDeref(_compositeFilter, CompositeFilter.class, 77, 2815, 2830)) {
                    CallChecker.isCalled(_compositeFilter, CompositeFilter.class, 77, 2815, 2830).addFilter(filter);
                }
            }
            if (CallChecker.beforeDeref(appender, Appender.class, 79, 2869, 2876)) {
                appender = CallChecker.beforeCalled(appender, Appender.class, 79, 2869, 2876);
                CallChecker.isCalled(appender, Appender.class, 79, 2869, 2876).addFilter(_compositeFilter);
            }
            if (CallChecker.beforeDeref(AbstractLogger.ROOT_LOGGER, Logger.class, 81, 2916, 2926)) {
                CallChecker.isCalled(AbstractLogger.ROOT_LOGGER, Logger.class, 81, 2916, 2926).addAppender(appender);
            }
            if (CallChecker.beforeDeref(appender, Appender.class, 82, 2959, 2966)) {
                appender = CallChecker.beforeCalled(appender, Appender.class, 82, 2959, 2966);
                CallChecker.isCalled(appender, Appender.class, 82, 2959, 2966).start();
            }
            StartupAppender startupAppender = CallChecker.init(StartupAppender.class);
            if (CallChecker.beforeDeref(AbstractLogger.ROOT_LOGGER, Logger.class, 85, 3085, 3095)) {
                startupAppender = ((StartupAppender) (CallChecker.isCalled(AbstractLogger.ROOT_LOGGER, Logger.class, 85, 3085, 3095).getAppender(StartupAppender.class.getName())));
                CallChecker.varAssign(startupAppender, "startupAppender", 85, 3085, 3095);
            }
            if (startupAppender != null) {
                startupAppender.replayAccumulatedEvents(appender);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context837.methodEnd();
        }
    }

    protected abstract Appender<ILoggingEvent> createAppenderInstance(Context context);

    protected abstract Collection<? extends LoggerFilter> getLoggerFilters();

    @StateTransition(currentState = { State.ERRORED , State.UNINITIALIZED , State.STOPPED }, desiredState = State.ACTIVE)
    private ListenableFuture<Void> doActivate() {
        MethodContext _bcornu_methode_context840 = new MethodContext(ListenableFuture.class);
        try {
            CallChecker.varInit(this, "this", 97, 3442, 3696);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 97, 3442, 3696);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 97, 3442, 3696);
            setState(State.ACTIVE);
            return Futures.immediateFuture(null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenableFuture<Void>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context840.methodEnd();
        }
    }

    @StateTransition(currentState = { State.ACTIVE , State.UNINITIALIZED , State.ERRORED , State.STOPPED }, desiredState = State.DELETED)
    private ListenableFuture<Void> doDelete() {
        MethodContext _bcornu_methode_context842 = new MethodContext(ListenableFuture.class);
        try {
            CallChecker.varInit(this, "this", 104, 3703, 4305);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 104, 3703, 4305);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 104, 3703, 4305);
            final SettableFuture<Void> returnVal = CallChecker.varInit(SettableFuture.create(), "returnVal", 106, 3892, 3954);
            if (CallChecker.beforeDeref(getTaskExecutor(), TaskExecutor.class, 117, 4241, 4257)) {
                if (CallChecker.beforeDeref(closeAsync(), ListenableFuture.class, 107, 3964, 3975)) {
                    CallChecker.isCalled(closeAsync(), ListenableFuture.class, 107, 3964, 3975).addListener(new Runnable() {
                        @Override
                        public void run() {
                            MethodContext _bcornu_methode_context841 = new MethodContext(void.class);
                            try {
                                CallChecker.varInit(this, "this", 110, 4026, 4228);
                                deleted();
                                setState(State.DELETED);
                                stopLogging();
                                if (CallChecker.beforeDeref(returnVal, SettableFuture.class, 115, 4195, 4203)) {
                                    CallChecker.isCalled(returnVal, SettableFuture.class, 115, 4195, 4203).set(null);
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                _bcornu_return_t.getDecision().getValue();
                                return ;
                            } finally {
                                _bcornu_methode_context841.methodEnd();
                            }
                        }
                    }, CallChecker.isCalled(getTaskExecutor(), TaskExecutor.class, 117, 4241, 4257).getExecutor());
                }
            }
            return returnVal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenableFuture<Void>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context842.methodEnd();
        }
    }

    @Override
    protected <C extends ConfiguredObject> ListenableFuture<C> addChildAsync(Class<C> childClass, Map<String, Object> attributes, ConfiguredObject... otherParents) {
        MethodContext _bcornu_methode_context843 = new MethodContext(ListenableFuture.class);
        try {
            CallChecker.varInit(this, "this", 122, 4312, 4573);
            CallChecker.varInit(otherParents, "otherParents", 122, 4312, 4573);
            CallChecker.varInit(attributes, "attributes", 122, 4312, 4573);
            CallChecker.varInit(childClass, "childClass", 122, 4312, 4573);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 122, 4312, 4573);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 122, 4312, 4573);
            if (CallChecker.beforeDeref(getObjectFactory(), ConfiguredObjectFactory.class, 124, 4507, 4524)) {
                return CallChecker.isCalled(getObjectFactory(), ConfiguredObjectFactory.class, 124, 4507, 4524).createAsync(childClass, attributes, this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListenableFuture<C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context843.methodEnd();
        }
    }

    public final long getErrorCount() {
        MethodContext _bcornu_methode_context844 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 127, 4580, 4673);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 127, 4580, 4673);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 127, 4580, 4673);
            if (CallChecker.beforeDeref(_compositeFilter, CompositeFilter.class, 129, 4635, 4650)) {
                return CallChecker.isCalled(_compositeFilter, CompositeFilter.class, 129, 4635, 4650).getErrorCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context844.methodEnd();
        }
    }

    public final long getWarnCount() {
        MethodContext _bcornu_methode_context845 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 132, 4680, 4771);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 132, 4680, 4771);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 132, 4680, 4771);
            if (CallChecker.beforeDeref(_compositeFilter, CompositeFilter.class, 134, 4734, 4749)) {
                return CallChecker.isCalled(_compositeFilter, CompositeFilter.class, 134, 4734, 4749).getWarnCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context845.methodEnd();
        }
    }

    public void stopLogging() {
        MethodContext _bcornu_methode_context846 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 137, 4778, 5007);
            CallChecker.varInit(this._compositeFilter, "_compositeFilter", 137, 4778, 5007);
            CallChecker.varInit(ROOT_LOGGER, "org.apache.qpid.server.logging.AbstractLogger.ROOT_LOGGER", 137, 4778, 5007);
            Appender appender = CallChecker.init(Appender.class);
            if (CallChecker.beforeDeref(AbstractLogger.ROOT_LOGGER, Logger.class, 139, 4838, 4848)) {
                appender = CallChecker.isCalled(AbstractLogger.ROOT_LOGGER, Logger.class, 139, 4838, 4848).getAppender(getName());
                CallChecker.varAssign(appender, "appender", 139, 4838, 4848);
            }
            if (appender != null) {
                appender.stop();
                if (CallChecker.beforeDeref(AbstractLogger.ROOT_LOGGER, Logger.class, 143, 4955, 4965)) {
                    CallChecker.isCalled(AbstractLogger.ROOT_LOGGER, Logger.class, 143, 4955, 4965).detachAppender(appender);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context846.methodEnd();
        }
    }
}

