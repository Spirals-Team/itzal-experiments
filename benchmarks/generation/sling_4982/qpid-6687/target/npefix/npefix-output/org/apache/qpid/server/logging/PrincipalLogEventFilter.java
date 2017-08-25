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

public class PrincipalLogEventFilter extends Filter<ILoggingEvent> implements LoggerFilter {
    private final Principal _principal;

    public PrincipalLogEventFilter(final Principal principal) {
        MethodContext _bcornu_methode_context2 = new MethodContext(null);
        try {
            _principal = principal;
            CallChecker.varAssign(this._principal, "this._principal", 39, 1311, 1333);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        MethodContext _bcornu_methode_context3 = new MethodContext(FilterReply.class);
        try {
            CallChecker.varInit(this, "this", 43, 1346, 1664);
            CallChecker.varInit(event, "event", 43, 1346, 1664);
            CallChecker.varInit(this._principal, "_principal", 43, 1346, 1664);
            Subject subject = CallChecker.varInit(Subject.getSubject(AccessController.getContext()), "subject", 45, 1421, 1488);
            subject = CallChecker.beforeCalled(subject, Subject.class, 46, 1521, 1527);
            if (CallChecker.beforeDeref(CallChecker.isCalled(subject, Subject.class, 46, 1521, 1527).getPrincipals(), Set.class, 46, 1521, 1543)) {
                if ((subject != null) && (CallChecker.isCalled(subject.getPrincipals(), Set.class, 46, 1521, 1543).contains(_principal))) {
                    return FilterReply.NEUTRAL;
                }
            }else
                throw new AbnormalExecutionError();
            
            return FilterReply.DENY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FilterReply) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    @Override
    public Filter<ILoggingEvent> asFilter() {
        MethodContext _bcornu_methode_context4 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 54, 1671, 1756);
            CallChecker.varInit(this._principal, "_principal", 54, 1671, 1756);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter<ILoggingEvent>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    @Override
    public String getName() {
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 60, 1763, 1854);
            CallChecker.varInit(this._principal, "_principal", 60, 1763, 1854);
            return "$" + (CallChecker.isCalled(getClass(), Class.class, 62, 1828, 1837).getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }
}

