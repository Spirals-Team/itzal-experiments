package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class InvalidSyntaxException extends Exception {
    static final long serialVersionUID = -4295194420816491875L;

    private final String filter;

    public InvalidSyntaxException(String msg, String filter) {
        super(InvalidSyntaxException.message(msg, filter));
        MethodContext _bcornu_methode_context139 = new MethodContext(null);
        try {
            this.filter = filter;
            CallChecker.varAssign(this.filter, "this.filter", 53, 1725, 1745);
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public InvalidSyntaxException(String msg, String filter, Throwable cause) {
        super(InvalidSyntaxException.message(msg, filter), cause);
        MethodContext _bcornu_methode_context140 = new MethodContext(null);
        try {
            this.filter = filter;
            CallChecker.varAssign(this.filter, "this.filter", 70, 2244, 2264);
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    private static String message(String msg, String filter) {
        MethodContext _bcornu_methode_context1426 = new MethodContext(String.class);
        try {
            CallChecker.varInit(filter, "filter", 76, 2271, 2510);
            CallChecker.varInit(msg, "msg", 76, 2271, 2510);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.InvalidSyntaxException.serialVersionUID", 76, 2271, 2510);
            if (((msg == null) || (filter == null)) || ((msg.indexOf(filter)) >= 0)) {
                return msg;
            }
            return (msg + ": ") + filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1426.methodEnd();
        }
    }

    public String getFilter() {
        MethodContext _bcornu_methode_context1427 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 92, 2514, 2891);
            CallChecker.varInit(this.filter, "filter", 92, 2514, 2891);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.InvalidSyntaxException.serialVersionUID", 92, 2514, 2891);
            return filter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1427.methodEnd();
        }
    }

    @Override
    public Throwable getCause() {
        MethodContext _bcornu_methode_context1428 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 103, 2895, 3148);
            CallChecker.varInit(this.filter, "filter", 103, 2895, 3148);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.InvalidSyntaxException.serialVersionUID", 103, 2895, 3148);
            return super.getCause();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1428.methodEnd();
        }
    }

    @Override
    public Throwable initCause(Throwable cause) {
        MethodContext _bcornu_methode_context1429 = new MethodContext(Throwable.class);
        try {
            CallChecker.varInit(this, "this", 119, 3152, 3605);
            CallChecker.varInit(cause, "cause", 119, 3152, 3605);
            CallChecker.varInit(this.filter, "filter", 119, 3152, 3605);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.InvalidSyntaxException.serialVersionUID", 119, 3152, 3605);
            return super.initCause(cause);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Throwable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1429.methodEnd();
        }
    }
}

