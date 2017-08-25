package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class LoggerNameAndLevelFilter extends Filter<ILoggingEvent> implements EffectiveLevelFilter {
    private final Filter<ILoggingEvent> _filter;

    private final String _loggerName;

    private volatile Level _level;

    public LoggerNameAndLevelFilter(String loggerName, Level level) {
        MethodContext _bcornu_methode_context5 = new MethodContext(null);
        try {
            _level = level;
            CallChecker.varAssign(this._level, "this._level", 37, 1373, 1387);
            _loggerName = loggerName;
            CallChecker.varAssign(this._loggerName, "this._loggerName", 38, 1397, 1421);
            _filter = createFilter(loggerName);
            CallChecker.varAssign(this._filter, "this._filter", 39, 1431, 1465);
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        MethodContext _bcornu_methode_context35 = new MethodContext(FilterReply.class);
        try {
            CallChecker.varInit(this, "this", 43, 1478, 1587);
            CallChecker.varInit(event, "event", 43, 1478, 1587);
            CallChecker.varInit(this._level, "_level", 43, 1478, 1587);
            CallChecker.varInit(this._loggerName, "_loggerName", 43, 1478, 1587);
            CallChecker.varInit(this._filter, "_filter", 43, 1478, 1587);
            if (CallChecker.beforeDeref(_filter, Filter.class, 45, 1560, 1566)) {
                return CallChecker.isCalled(_filter, Filter.class, 45, 1560, 1566).decide(event);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public void setLevel(Level level) {
        MethodContext _bcornu_methode_context36 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 48, 1594, 1662);
            CallChecker.varInit(level, "level", 48, 1594, 1662);
            CallChecker.varInit(this._level, "_level", 48, 1594, 1662);
            CallChecker.varInit(this._loggerName, "_loggerName", 48, 1594, 1662);
            CallChecker.varInit(this._filter, "_filter", 48, 1594, 1662);
            _level = level;
            CallChecker.varAssign(this._level, "this._level", 50, 1642, 1656);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public Level getLevel() {
        MethodContext _bcornu_methode_context37 = new MethodContext(Level.class);
        try {
            CallChecker.varInit(this, "this", 53, 1669, 1726);
            CallChecker.varInit(this._level, "_level", 53, 1669, 1726);
            CallChecker.varInit(this._loggerName, "_loggerName", 53, 1669, 1726);
            CallChecker.varInit(this._filter, "_filter", 53, 1669, 1726);
            return _level;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Level) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public String getLoggerName() {
        MethodContext _bcornu_methode_context38 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 58, 1733, 1801);
            CallChecker.varInit(this._level, "_level", 58, 1733, 1801);
            CallChecker.varInit(this._loggerName, "_loggerName", 58, 1733, 1801);
            CallChecker.varInit(this._filter, "_filter", 58, 1733, 1801);
            return _loggerName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    private Filter<ILoggingEvent> createFilter(final String loggerName) {
        MethodContext _bcornu_methode_context42 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 63, 1808, 3241);
            CallChecker.varInit(loggerName, "loggerName", 63, 1808, 3241);
            CallChecker.varInit(this._level, "_level", 63, 1808, 3241);
            CallChecker.varInit(this._loggerName, "_loggerName", 63, 1808, 3241);
            CallChecker.varInit(this._filter, "_filter", 63, 1808, 3241);
            if (CallChecker.beforeDeref("", String.class, 65, 1915, 1916)) {
                if (CallChecker.beforeDeref(Logger.ROOT_LOGGER_NAME, String.class, 65, 1940, 1962)) {
                    if (((loggerName == null) || (CallChecker.isCalled("", String.class, 65, 1915, 1916).equals(loggerName))) || (CallChecker.isCalled(Logger.ROOT_LOGGER_NAME, String.class, 65, 1940, 1962).equals(loggerName))) {
                        return new Filter<ILoggingEvent>() {
                            @Override
                            public FilterReply decide(final ILoggingEvent event) {
                                MethodContext _bcornu_methode_context39 = new MethodContext(FilterReply.class);
                                try {
                                    CallChecker.varInit(this, "this", 70, 2071, 2297);
                                    CallChecker.varInit(event, "event", 70, 2071, 2297);
                                    if (CallChecker.beforeDeref(event, ILoggingEvent.class, 72, 2195, 2199)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(event, ILoggingEvent.class, 72, 2195, 2199).getLevel(), Level.class, 72, 2195, 2210)) {
                                            if (CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 72, 2195, 2199).getLevel(), Level.class, 72, 2195, 2210).isGreaterOrEqual(_level)) {
                                                return FilterReply.ACCEPT;
                                            }else {
                                                return FilterReply.NEUTRAL;
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context39.methodEnd();
                                }
                            }
                        };
                    }else
                        if (loggerName.endsWith(".*")) {
                            final String prefixName = CallChecker.varInit(loggerName.substring(0, ((loggerName.length()) - 2)), "prefixName", 78, 2389, 2460);
                            return new Filter<ILoggingEvent>() {
                                @Override
                                public FilterReply decide(final ILoggingEvent event) {
                                    MethodContext _bcornu_methode_context40 = new MethodContext(FilterReply.class);
                                    try {
                                        CallChecker.varInit(this, "this", 82, 2539, 2813);
                                        CallChecker.varInit(event, "event", 82, 2539, 2813);
                                        if (CallChecker.beforeDeref(event, ILoggingEvent.class, 84, 2663, 2667)) {
                                            if (CallChecker.beforeDeref(event, ILoggingEvent.class, 84, 2708, 2712)) {
                                                if ((CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 84, 2663, 2667).getLevel(), Level.class, 84, 2663, 2678).isGreaterOrEqual(_level)) && (CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 84, 2708, 2712).getLoggerName(), String.class, 84, 2708, 2728).startsWith(prefixName))) {
                                                    return FilterReply.ACCEPT;
                                                }else {
                                                    return FilterReply.NEUTRAL;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context40.methodEnd();
                                    }
                                }
                            };
                        }else {
                            return new Filter<ILoggingEvent>() {
                                @Override
                                public FilterReply decide(final ILoggingEvent event) {
                                    MethodContext _bcornu_methode_context41 = new MethodContext(FilterReply.class);
                                    try {
                                        CallChecker.varInit(this, "this", 93, 2940, 3210);
                                        CallChecker.varInit(event, "event", 93, 2940, 3210);
                                        if (CallChecker.beforeDeref(event, ILoggingEvent.class, 95, 3064, 3068)) {
                                            if (CallChecker.beforeDeref(event, ILoggingEvent.class, 95, 3109, 3113)) {
                                                if ((CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 95, 3064, 3068).getLevel(), Level.class, 95, 3064, 3079).isGreaterOrEqual(_level)) && (CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 95, 3109, 3113).getLoggerName(), String.class, 95, 3109, 3129).equals(loggerName))) {
                                                    return FilterReply.ACCEPT;
                                                }else {
                                                    return FilterReply.NEUTRAL;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    } catch (ForceReturn _bcornu_return_t) {
                                        return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
                                    } finally {
                                        _bcornu_methode_context41.methodEnd();
                                    }
                                }
                            };
                        }
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public Level getEffectiveLevel(final Logger logger) {
        MethodContext _bcornu_methode_context43 = new MethodContext(Level.class);
        try {
            CallChecker.varInit(this, "this", 101, 3248, 3699);
            CallChecker.varInit(logger, "logger", 101, 3248, 3699);
            CallChecker.varInit(this._level, "_level", 101, 3248, 3699);
            CallChecker.varInit(this._loggerName, "_loggerName", 101, 3248, 3699);
            CallChecker.varInit(this._filter, "_filter", 101, 3248, 3699);
            if (CallChecker.beforeDeref("", String.class, 103, 3341, 3342)) {
                if (CallChecker.beforeDeref(Logger.ROOT_LOGGER_NAME, String.class, 103, 3367, 3389)) {
                    if (CallChecker.beforeDeref(logger, Logger.class, 104, 3456, 3461)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(logger, Logger.class, 104, 3456, 3461).getName(), String.class, 104, 3456, 3471)) {
                            if (CallChecker.beforeDeref(logger, Logger.class, 105, 3566, 3571)) {
                                if ((((((_loggerName) == null) || (CallChecker.isCalled("", String.class, 103, 3341, 3342).equals(_loggerName))) || (CallChecker.isCalled(Logger.ROOT_LOGGER_NAME, String.class, 103, 3367, 3389).equals(_loggerName))) || ((_loggerName.endsWith(".*")) && (CallChecker.isCalled(CallChecker.isCalled(logger, Logger.class, 104, 3456, 3461).getName(), String.class, 104, 3456, 3471).startsWith(_loggerName.substring(0, ((_loggerName.length()) - 2)))))) || (_loggerName.equals(CallChecker.isCalled(logger, Logger.class, 105, 3566, 3571).getName()))) {
                                    return _level;
                                }else {
                                    return Level.OFF;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Level) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }
}

