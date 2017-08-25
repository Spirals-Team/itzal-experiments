package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class TooManyEvaluationsException extends MaxCountExceededException {
    private static final long serialVersionUID = 4330003017885151975L;

    public TooManyEvaluationsException(Number max) {
        super(max);
        ConstructorContext _bcornu_methode_context544 = new ConstructorContext(TooManyEvaluationsException.class, 36, 1223, 1463);
        try {
            final ExceptionContext npe_invocation_var681 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var681, ExceptionContext.class, 38, 1404, 1415)) {
                CallChecker.isCalled(npe_invocation_var681, ExceptionContext.class, 38, 1404, 1415).addMessage(LocalizedFormats.EVALUATIONS);
            }
        } finally {
            _bcornu_methode_context544.methodEnd();
        }
    }
}

