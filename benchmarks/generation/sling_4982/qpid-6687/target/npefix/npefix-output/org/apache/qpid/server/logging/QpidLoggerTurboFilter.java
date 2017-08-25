package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.TurboFilterList;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import static org.slf4j.Logger.ROOT_LOGGER_NAME;

public final class QpidLoggerTurboFilter extends TurboFilter {
    private final CopyOnWriteArrayList<EffectiveLevelFilter> _filters = new CopyOnWriteArrayList<>();

    private final AtomicReference<ConcurrentMap<Logger, Level>> _effectiveLevels = new AtomicReference<>();

    public QpidLoggerTurboFilter() {
        MethodContext _bcornu_methode_context14 = new MethodContext(null);
        try {
            clearCachedResults();
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    @Override
    public FilterReply decide(final Marker marker, final Logger logger, final Level level, final String format, final Object[] params, final Throwable t) {
        MethodContext _bcornu_methode_context127 = new MethodContext(FilterReply.class);
        try {
            CallChecker.varInit(this, "this", 50, 1689, 2763);
            CallChecker.varInit(t, "t", 50, 1689, 2763);
            CallChecker.varInit(params, "params", 50, 1689, 2763);
            CallChecker.varInit(format, "format", 50, 1689, 2763);
            CallChecker.varInit(level, "level", 50, 1689, 2763);
            CallChecker.varInit(logger, "logger", 50, 1689, 2763);
            CallChecker.varInit(marker, "marker", 50, 1689, 2763);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 50, 1689, 2763);
            CallChecker.varInit(this._filters, "_filters", 50, 1689, 2763);
            final ConcurrentMap<Logger, Level> effectiveLevels = CallChecker.varInit(CallChecker.isCalled(_effectiveLevels, AtomicReference.class, 57, 2070, 2085).get(), "effectiveLevels", 57, 2017, 2092);
            Level effectiveLoggerLevel = CallChecker.init(Level.class);
            if (CallChecker.beforeDeref(effectiveLevels, ConcurrentMap.class, 58, 2131, 2145)) {
                effectiveLoggerLevel = CallChecker.isCalled(effectiveLevels, ConcurrentMap.class, 58, 2131, 2145).get(logger);
                CallChecker.varAssign(effectiveLoggerLevel, "effectiveLoggerLevel", 58, 2131, 2145);
            }
            if (effectiveLoggerLevel == null) {
                effectiveLoggerLevel = Level.OFF;
                CallChecker.varAssign(effectiveLoggerLevel, "effectiveLoggerLevel", 62, 2224, 2256);
                if (CallChecker.beforeDeref(_filters, FilterReply.class, 63, 2304, 2311)) {
                    for (EffectiveLevelFilter filter : _filters) {
                        Level loggerLevel = CallChecker.init(Level.class);
                        if (CallChecker.beforeDeref(filter, EffectiveLevelFilter.class, 65, 2364, 2369)) {
                            loggerLevel = CallChecker.isCalled(filter, EffectiveLevelFilter.class, 65, 2364, 2369).getEffectiveLevel(logger);
                            CallChecker.varAssign(loggerLevel, "loggerLevel", 65, 2364, 2369);
                        }
                        if (CallChecker.beforeDeref(effectiveLoggerLevel, Level.class, 66, 2417, 2436)) {
                            effectiveLoggerLevel = CallChecker.beforeCalled(effectiveLoggerLevel, Level.class, 66, 2417, 2436);
                            if (CallChecker.isCalled(effectiveLoggerLevel, Level.class, 66, 2417, 2436).isGreaterOrEqual(loggerLevel)) {
                                effectiveLoggerLevel = loggerLevel;
                                CallChecker.varAssign(effectiveLoggerLevel, "effectiveLoggerLevel", 68, 2507, 2541);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(effectiveLevels, ConcurrentMap.class, 71, 2587, 2601)) {
                    CallChecker.isCalled(effectiveLevels, ConcurrentMap.class, 71, 2587, 2601).putIfAbsent(logger, effectiveLoggerLevel);
                }
            }
            if (CallChecker.beforeDeref(level, Level.class, 75, 2673, 2677)) {
                if (CallChecker.isCalled(level, Level.class, 75, 2673, 2677).isGreaterOrEqual(effectiveLoggerLevel)) {
                    return FilterReply.ACCEPT;
                }else {
                    return FilterReply.DENY;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public void filterAdded(EffectiveLevelFilter filter) {
        MethodContext _bcornu_methode_context128 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 78, 2770, 2928);
            CallChecker.varInit(filter, "filter", 78, 2770, 2928);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 78, 2770, 2928);
            CallChecker.varInit(this._filters, "_filters", 78, 2770, 2928);
            if (CallChecker.beforeDeref(_filters, CopyOnWriteArrayList.class, 80, 2840, 2847)) {
                if (CallChecker.isCalled(_filters, CopyOnWriteArrayList.class, 80, 2840, 2847).addIfAbsent(filter)) {
                    clearCachedResults();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    private void clearCachedResults() {
        MethodContext _bcornu_methode_context129 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 2935, 3049);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 86, 2935, 3049);
            CallChecker.varInit(this._filters, "_filters", 86, 2935, 3049);
            if (CallChecker.beforeDeref(_effectiveLevels, AtomicReference.class, 88, 2983, 2998)) {
                CallChecker.isCalled(_effectiveLevels, AtomicReference.class, 88, 2983, 2998).set(new ConcurrentHashMap<Logger, Level>());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public void filterRemoved(EffectiveLevelFilter filter) {
        MethodContext _bcornu_methode_context130 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 91, 3056, 3211);
            CallChecker.varInit(filter, "filter", 91, 3056, 3211);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 91, 3056, 3211);
            CallChecker.varInit(this._filters, "_filters", 91, 3056, 3211);
            if (CallChecker.beforeDeref(_filters, CopyOnWriteArrayList.class, 93, 3128, 3135)) {
                if (CallChecker.isCalled(_filters, CopyOnWriteArrayList.class, 93, 3128, 3135).remove(filter)) {
                    clearCachedResults();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object o) {
        MethodContext _bcornu_methode_context131 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 100, 3218, 3338);
            CallChecker.varInit(o, "o", 100, 3218, 3338);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 100, 3218, 3338);
            CallChecker.varInit(this._filters, "_filters", 100, 3218, 3338);
            return (o != null) && ((getClass()) == (CallChecker.isCalled(o, Object.class, 102, 3319, 3319).getClass()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context132 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 106, 3345, 3409);
            CallChecker.varInit(this._effectiveLevels, "_effectiveLevels", 106, 3345, 3409);
            CallChecker.varInit(this._filters, "_filters", 106, 3345, 3409);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public static QpidLoggerTurboFilter installIfNecessary(LoggerContext loggerContext) {
        MethodContext _bcornu_methode_context133 = new MethodContext(QpidLoggerTurboFilter.class);
        try {
            CallChecker.varInit(loggerContext, "loggerContext", 111, 3416, 3982);
            QpidLoggerTurboFilter filter = CallChecker.varInit(new QpidLoggerTurboFilter(), "filter", 113, 3514, 3572);
            if (CallChecker.beforeDeref(loggerContext, LoggerContext.class, 114, 3586, 3598)) {
                loggerContext = CallChecker.beforeCalled(loggerContext, LoggerContext.class, 114, 3586, 3598);
                if (CallChecker.beforeDeref(CallChecker.isCalled(loggerContext, LoggerContext.class, 114, 3586, 3598).getTurboFilterList(), TurboFilterList.class, 114, 3586, 3619)) {
                    loggerContext = CallChecker.beforeCalled(loggerContext, LoggerContext.class, 114, 3586, 3598);
                    if (!(CallChecker.isCalled(CallChecker.isCalled(loggerContext, LoggerContext.class, 114, 3586, 3598).getTurboFilterList(), TurboFilterList.class, 114, 3586, 3619).addIfAbsent(filter))) {
                        loggerContext = CallChecker.beforeCalled(loggerContext, LoggerContext.class, 116, 3692, 3704);
                        for (TurboFilter candidate : CallChecker.isCalled(loggerContext, LoggerContext.class, 116, 3692, 3704).getTurboFilterList()) {
                            if (candidate instanceof QpidLoggerTurboFilter) {
                                filter = ((QpidLoggerTurboFilter) (candidate));
                                CallChecker.varAssign(filter, "filter", 120, 3843, 3884);
                                break;
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((QpidLoggerTurboFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    public static QpidLoggerTurboFilter installIfNecessaryToRootContext() {
        MethodContext _bcornu_methode_context134 = new MethodContext(QpidLoggerTurboFilter.class);
        try {
            return QpidLoggerTurboFilter.installIfNecessary(QpidLoggerTurboFilter.getRootContext());
        } catch (ForceReturn _bcornu_return_t) {
            return ((QpidLoggerTurboFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    private static LoggerContext getRootContext() {
        MethodContext _bcornu_methode_context135 = new MethodContext(LoggerContext.class);
        try {
            final Logger rootLogger = CallChecker.varInit(((Logger) (LoggerFactory.getLogger(ROOT_LOGGER_NAME))), "rootLogger", 136, 4190, 4285);
            if (CallChecker.beforeDeref(rootLogger, Logger.class, 137, 4302, 4311)) {
                return CallChecker.isCalled(rootLogger, Logger.class, 137, 4302, 4311).getLoggerContext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((LoggerContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public static void filterAdded(EffectiveLevelFilter filter, LoggerContext context) {
        MethodContext _bcornu_methode_context136 = new MethodContext(void.class);
        try {
            CallChecker.varInit(context, "context", 140, 4344, 4551);
            CallChecker.varInit(filter, "filter", 140, 4344, 4551);
            QpidLoggerTurboFilter turboFilter = CallChecker.varInit(QpidLoggerTurboFilter.installIfNecessary(context), "turboFilter", 142, 4441, 4504);
            if (CallChecker.beforeDeref(turboFilter, QpidLoggerTurboFilter.class, 143, 4514, 4524)) {
                turboFilter = CallChecker.beforeCalled(turboFilter, QpidLoggerTurboFilter.class, 143, 4514, 4524);
                CallChecker.isCalled(turboFilter, QpidLoggerTurboFilter.class, 143, 4514, 4524).filterAdded(filter);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }

    public static void filterRemoved(EffectiveLevelFilter filter, LoggerContext context) {
        MethodContext _bcornu_methode_context137 = new MethodContext(void.class);
        try {
            CallChecker.varInit(context, "context", 146, 4558, 4769);
            CallChecker.varInit(filter, "filter", 146, 4558, 4769);
            QpidLoggerTurboFilter turboFilter = CallChecker.varInit(QpidLoggerTurboFilter.installIfNecessary(context), "turboFilter", 148, 4657, 4720);
            if (CallChecker.beforeDeref(turboFilter, QpidLoggerTurboFilter.class, 149, 4730, 4740)) {
                turboFilter = CallChecker.beforeCalled(turboFilter, QpidLoggerTurboFilter.class, 149, 4730, 4740);
                CallChecker.isCalled(turboFilter, QpidLoggerTurboFilter.class, 149, 4730, 4740).filterRemoved(filter);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    public static void filterAddedToRootContext(EffectiveLevelFilter filter) {
        MethodContext _bcornu_methode_context138 = new MethodContext(void.class);
        try {
            CallChecker.varInit(filter, "filter", 152, 4776, 4906);
            QpidLoggerTurboFilter.filterAdded(filter, QpidLoggerTurboFilter.getRootContext());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    public static void filterRemovedFromRootContext(EffectiveLevelFilter filter) {
        MethodContext _bcornu_methode_context139 = new MethodContext(void.class);
        try {
            CallChecker.varInit(filter, "filter", 157, 4913, 5049);
            QpidLoggerTurboFilter.filterRemoved(filter, QpidLoggerTurboFilter.getRootContext());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }
}

