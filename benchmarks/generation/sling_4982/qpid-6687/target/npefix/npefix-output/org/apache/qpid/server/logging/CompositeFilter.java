package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class CompositeFilter extends Filter<ILoggingEvent> {
    private List<Filter<ILoggingEvent>> _filterList = new CopyOnWriteArrayList<>();

    private final AtomicLong _warnCount = new AtomicLong();

    private final AtomicLong _errorCount = new AtomicLong();

    public void addFilter(LoggerFilter filter) {
        MethodContext _bcornu_methode_context75 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 44, 1669, 1840);
            CallChecker.varInit(filter, "filter", 44, 1669, 1840);
            CallChecker.varInit(this._errorCount, "_errorCount", 44, 1669, 1840);
            CallChecker.varInit(this._warnCount, "_warnCount", 44, 1669, 1840);
            CallChecker.varInit(this._filterList, "_filterList", 44, 1669, 1840);
            Filter<ILoggingEvent> f = CallChecker.init(Filter.class);
            if (CallChecker.beforeDeref(filter, LoggerFilter.class, 46, 1752, 1757)) {
                filter = CallChecker.beforeCalled(filter, LoggerFilter.class, 46, 1752, 1757);
                f = CallChecker.isCalled(filter, LoggerFilter.class, 46, 1752, 1757).asFilter();
                CallChecker.varAssign(f, "f", 46, 1752, 1757);
            }
            if (CallChecker.beforeDeref(filter, LoggerFilter.class, 47, 1789, 1794)) {
                if (CallChecker.beforeDeref(f, Filter.class, 47, 1779, 1779)) {
                    filter = CallChecker.beforeCalled(filter, LoggerFilter.class, 47, 1789, 1794);
                    f = CallChecker.beforeCalled(f, Filter.class, 47, 1779, 1779);
                    CallChecker.isCalled(f, Filter.class, 47, 1779, 1779).setName(CallChecker.isCalled(filter, LoggerFilter.class, 47, 1789, 1794).getName());
                }
            }
            if (CallChecker.beforeDeref(_filterList, List.class, 48, 1816, 1826)) {
                _filterList = CallChecker.beforeCalled(_filterList, List.class, 48, 1816, 1826);
                CallChecker.isCalled(_filterList, List.class, 48, 1816, 1826).add(f);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public void removeFilter(LoggerFilter filter) {
        MethodContext _bcornu_methode_context76 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 51, 1847, 2198);
            CallChecker.varInit(filter, "filter", 51, 1847, 2198);
            CallChecker.varInit(this._errorCount, "_errorCount", 51, 1847, 2198);
            CallChecker.varInit(this._warnCount, "_warnCount", 51, 1847, 2198);
            CallChecker.varInit(this._filterList, "_filterList", 51, 1847, 2198);
            Iterator<Filter<ILoggingEvent>> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(_filterList, List.class, 53, 1944, 1954)) {
                _filterList = CallChecker.beforeCalled(_filterList, List.class, 53, 1944, 1954);
                it = CallChecker.isCalled(_filterList, List.class, 53, 1944, 1954).iterator();
                CallChecker.varAssign(it, "it", 53, 1944, 1954);
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 54, 1982, 1983);
            while (CallChecker.isCalled(it, Iterator.class, 54, 1982, 1983).hasNext()) {
                Filter f = CallChecker.init(Filter.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 56, 2029, 2030)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 56, 2029, 2030);
                    f = CallChecker.isCalled(it, Iterator.class, 56, 2029, 2030).next();
                    CallChecker.varAssign(f, "f", 56, 2029, 2030);
                }
                if (CallChecker.beforeDeref(f, Filter.class, 57, 2056, 2056)) {
                    if (CallChecker.beforeDeref(filter, LoggerFilter.class, 57, 2075, 2080)) {
                        f = CallChecker.beforeCalled(f, Filter.class, 57, 2056, 2056);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(f, Filter.class, 57, 2056, 2056).getName(), String.class, 57, 2056, 2066)) {
                            f = CallChecker.beforeCalled(f, Filter.class, 57, 2056, 2056);
                            filter = CallChecker.beforeCalled(filter, LoggerFilter.class, 57, 2075, 2080);
                            if (CallChecker.isCalled(CallChecker.isCalled(f, Filter.class, 57, 2056, 2056).getName(), String.class, 57, 2056, 2066).equals(CallChecker.isCalled(filter, LoggerFilter.class, 57, 2075, 2080).getName())) {
                                if (CallChecker.beforeDeref(_filterList, List.class, 59, 2124, 2134)) {
                                    _filterList = CallChecker.beforeCalled(_filterList, List.class, 59, 2124, 2134);
                                    CallChecker.isCalled(_filterList, List.class, 59, 2124, 2134).remove(f);
                                }
                                break;
                            }
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        MethodContext _bcornu_methode_context77 = new MethodContext(FilterReply.class);
        try {
            CallChecker.varInit(this, "this", 66, 2205, 2975);
            CallChecker.varInit(event, "event", 66, 2205, 2975);
            CallChecker.varInit(this._errorCount, "_errorCount", 66, 2205, 2975);
            CallChecker.varInit(this._warnCount, "_warnCount", 66, 2205, 2975);
            CallChecker.varInit(this._filterList, "_filterList", 66, 2205, 2975);
            FilterReply reply = CallChecker.varInit(FilterReply.DENY, "reply", 68, 2280, 2304);
            if (CallChecker.beforeDeref(_filterList, FilterReply.class, 69, 2349, 2359)) {
                for (Filter<ILoggingEvent> filter : _filterList) {
                    if (CallChecker.beforeDeref(filter, Filter.class, 71, 2392, 2397)) {
                        reply = CallChecker.isCalled(filter, Filter.class, 71, 2392, 2397).decide(event);
                        CallChecker.varAssign(reply, "reply", 71, 2384, 2412);
                    }
                    if ((reply == (FilterReply.DENY)) || (reply == (FilterReply.ACCEPT))) {
                        break;
                    }
                }
            }
            if (reply == (FilterReply.ACCEPT)) {
                if (CallChecker.beforeDeref(event, ILoggingEvent.class, 79, 2582, 2586)) {
                    event = CallChecker.beforeCalled(event, ILoggingEvent.class, 79, 2582, 2586);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(event, ILoggingEvent.class, 79, 2582, 2586).getLevel(), Level.class, 79, 2582, 2597)) {
                        event = CallChecker.beforeCalled(event, ILoggingEvent.class, 79, 2582, 2586);
                        switch (CallChecker.isCalled(CallChecker.isCalled(event, ILoggingEvent.class, 79, 2582, 2586).getLevel(), Level.class, 79, 2582, 2597).toInt()) {
                            case Level.WARN_INT :
                                if (CallChecker.beforeDeref(_warnCount, AtomicLong.class, 82, 2673, 2682)) {
                                    CallChecker.isCalled(_warnCount, AtomicLong.class, 82, 2673, 2682).incrementAndGet();
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            case Level.ERROR_INT :
                                if (CallChecker.beforeDeref(_errorCount, AtomicLong.class, 85, 2782, 2792)) {
                                    CallChecker.isCalled(_errorCount, AtomicLong.class, 85, 2782, 2792).incrementAndGet();
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            default :
                        }
                    }
                }
                return FilterReply.ACCEPT;
            }
            return FilterReply.DENY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public long getErrorCount() {
        MethodContext _bcornu_methode_context78 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 95, 2982, 3054);
            CallChecker.varInit(this._errorCount, "_errorCount", 95, 2982, 3054);
            CallChecker.varInit(this._warnCount, "_warnCount", 95, 2982, 3054);
            CallChecker.varInit(this._filterList, "_filterList", 95, 2982, 3054);
            if (CallChecker.beforeDeref(_errorCount, AtomicLong.class, 97, 3031, 3041)) {
                return CallChecker.isCalled(_errorCount, AtomicLong.class, 97, 3031, 3041).get();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public long getWarnCount() {
        MethodContext _bcornu_methode_context79 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 100, 3061, 3131);
            CallChecker.varInit(this._errorCount, "_errorCount", 100, 3061, 3131);
            CallChecker.varInit(this._warnCount, "_warnCount", 100, 3061, 3131);
            CallChecker.varInit(this._filterList, "_filterList", 100, 3061, 3131);
            if (CallChecker.beforeDeref(_warnCount, AtomicLong.class, 102, 3109, 3118)) {
                return CallChecker.isCalled(_warnCount, AtomicLong.class, 102, 3109, 3118).get();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }
}

