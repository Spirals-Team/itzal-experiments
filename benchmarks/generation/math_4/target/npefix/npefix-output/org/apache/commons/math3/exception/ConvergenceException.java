package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class ConvergenceException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;

    public ConvergenceException() {
        this(LocalizedFormats.CONVERGENCE_FAILED);
        ConstructorContext _bcornu_methode_context1221 = new ConstructorContext(ConvergenceException.class, 36, 1334, 1469);
        try {
        } finally {
            _bcornu_methode_context1221.methodEnd();
        }
    }

    public ConvergenceException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context1222 = new ConstructorContext(ConvergenceException.class, 47, 1476, 1841);
        try {
            final ExceptionContext npe_invocation_var1007 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var1007, ExceptionContext.class, 49, 1797, 1808)) {
                CallChecker.isCalled(npe_invocation_var1007, ExceptionContext.class, 49, 1797, 1808).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context1222.methodEnd();
        }
    }
}

