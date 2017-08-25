package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.security.AccessController;
import java.security.Principal;
import java.util.Set;
import javax.security.auth.Subject;
import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.virtualhost.VirtualHostPrincipal;

public class VirtualHostLogEventExcludingFilter extends Filter<ILoggingEvent> implements LoggerFilter {
    private final BrokerLogger<?> _brokerLogger;

    public VirtualHostLogEventExcludingFilter(BrokerLogger<?> brokerLogger) {
        super();
        MethodContext _bcornu_methode_context20 = new MethodContext(null);
        try {
            _brokerLogger = brokerLogger;
            CallChecker.varAssign(this._brokerLogger, "this._brokerLogger", 42, 1498, 1526);
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    @Override
    public Filter<ILoggingEvent> asFilter() {
        MethodContext _bcornu_methode_context197 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 47, 1540, 1625);
            CallChecker.varInit(this._brokerLogger, "_brokerLogger", 47, 1540, 1625);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context197.methodEnd();
        }
    }

    @Override
    public String getName() {
        MethodContext _bcornu_methode_context198 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 53, 1632, 1723);
            CallChecker.varInit(this._brokerLogger, "_brokerLogger", 53, 1632, 1723);
            return "$" + (CallChecker.isCalled(getClass(), Class.class, 55, 1697, 1706).getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context198.methodEnd();
        }
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        MethodContext _bcornu_methode_context199 = new MethodContext(FilterReply.class);
        try {
            CallChecker.varInit(this, "this", 59, 1730, 1997);
            CallChecker.varInit(event, "event", 59, 1730, 1997);
            CallChecker.varInit(this._brokerLogger, "_brokerLogger", 59, 1730, 1997);
            if (CallChecker.beforeDeref(_brokerLogger, BrokerLogger.class, 61, 1810, 1822)) {
                if ((!(CallChecker.isCalled(_brokerLogger, BrokerLogger.class, 61, 1810, 1822).isVirtualHostLogEventExcluded())) || (!(subjectContainsVirtualHostPrincipal()))) {
                    return FilterReply.NEUTRAL;
                }
            }else
                throw new AbnormalExecutionError();
            
            return FilterReply.DENY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    private boolean subjectContainsVirtualHostPrincipal() {
        MethodContext _bcornu_methode_context200 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 68, 2004, 2490);
            CallChecker.varInit(this._brokerLogger, "_brokerLogger", 68, 2004, 2490);
            Subject subject = CallChecker.varInit(Subject.getSubject(AccessController.getContext()), "subject", 70, 2072, 2139);
            if (subject != null) {
                Set<Principal> principals = CallChecker.varInit(subject.getPrincipals(), "principals", 73, 2192, 2242);
                if (CallChecker.beforeDeref(principals, boolean.class, 74, 2282, 2291)) {
                    for (Principal principal : principals) {
                        if (principal instanceof VirtualHostPrincipal) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }
}

