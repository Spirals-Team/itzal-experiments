package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathInternalError extends MathIllegalStateException {
    private static final long serialVersionUID = -6276776513966934846L;

    private static final String REPORT_URL = "https://issues.apache.org/jira/browse/MATH";

    public MathInternalError() {
        ConstructorContext _bcornu_methode_context99 = new ConstructorContext(MathInternalError.class, 37, 1399, 1553);
        try {
            final ExceptionContext npe_invocation_var45 = getContext();
            if (CallChecker.beforeDeref(npe_invocation_var45, ExceptionContext.class, 38, 1479, 1490)) {
                CallChecker.isCalled(npe_invocation_var45, ExceptionContext.class, 38, 1479, 1490).addMessage(LocalizedFormats.INTERNAL_ERROR, MathInternalError.REPORT_URL);
            }
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public MathInternalError(final Throwable cause) {
        super(cause, LocalizedFormats.INTERNAL_ERROR, MathInternalError.REPORT_URL);
        ConstructorContext _bcornu_methode_context100 = new ConstructorContext(MathInternalError.class, 45, 1560, 1755);
        try {
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public MathInternalError(Localizable pattern, Object... args) {
        super(pattern, args);
        ConstructorContext _bcornu_methode_context101 = new ConstructorContext(MathInternalError.class, 55, 1762, 2037);
        try {
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }
}

