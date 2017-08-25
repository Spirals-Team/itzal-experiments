package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MaxCountExceededException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;

    private final Number max;

    public MaxCountExceededException(Number max) {
        this(LocalizedFormats.MAX_COUNT_EXCEEDED, max);
        ConstructorContext _bcornu_methode_context493 = new ConstructorContext(MaxCountExceededException.class, 41, 1358, 1547);
        try {
        } finally {
            _bcornu_methode_context493.methodEnd();
        }
    }

    public MaxCountExceededException(Localizable specific, Number max, Object... args) {
        ConstructorContext _bcornu_methode_context494 = new ConstructorContext(MaxCountExceededException.class, 51, 1553, 1991);
        try {
            final ExceptionContext npe_invocation_var631 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var631, ExceptionContext.class, 54, 1917, 1928)) {
                CallChecker.isCalled(npe_invocation_var631, ExceptionContext.class, 54, 1917, 1928).addMessage(specific, max, args);
            }
            this.max = max;
            CallChecker.varAssign(this.max, "this.max", 55, 1971, 1985);
        } finally {
            _bcornu_methode_context494.methodEnd();
        }
    }

    public Number getMax() {
        MethodContext _bcornu_methode_context2252 = new MethodContext(Number.class, 61, 1998, 2113);
        try {
            CallChecker.varInit(this, "this", 61, 1998, 2113);
            CallChecker.varInit(this.max, "max", 61, 1998, 2113);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MaxCountExceededException.serialVersionUID", 61, 1998, 2113);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2252.methodEnd();
        }
    }
}

