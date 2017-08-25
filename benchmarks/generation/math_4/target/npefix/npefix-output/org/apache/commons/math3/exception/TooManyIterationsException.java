package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class TooManyIterationsException extends MaxCountExceededException {
    private static final long serialVersionUID = 20121211L;

    public TooManyIterationsException(Number max) {
        super(max);
        ConstructorContext _bcornu_methode_context998 = new ConstructorContext(TooManyIterationsException.class, 36, 1210, 1448);
        try {
            final ExceptionContext npe_invocation_var931 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var931, ExceptionContext.class, 38, 1390, 1401)) {
                CallChecker.isCalled(npe_invocation_var931, ExceptionContext.class, 38, 1390, 1401).addMessage(LocalizedFormats.ITERATIONS);
            }
        } finally {
            _bcornu_methode_context998.methodEnd();
        }
    }
}

