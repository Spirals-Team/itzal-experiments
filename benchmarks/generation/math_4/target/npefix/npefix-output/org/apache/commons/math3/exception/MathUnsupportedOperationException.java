package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathUnsupportedOperationException extends UnsupportedOperationException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    private final ExceptionContext context;

    public MathUnsupportedOperationException() {
        this(LocalizedFormats.UNSUPPORTED_OPERATION);
        ConstructorContext _bcornu_methode_context654 = new ConstructorContext(MathUnsupportedOperationException.class, 43, 1667, 1814);
        try {
        } finally {
            _bcornu_methode_context654.methodEnd();
        }
    }

    public MathUnsupportedOperationException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context655 = new ConstructorContext(MathUnsupportedOperationException.class, 51, 1820, 2175);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 53, 2090, 2126);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 54, 2136, 2142)) {
                CallChecker.isCalled(context, ExceptionContext.class, 54, 2136, 2142).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context655.methodEnd();
        }
    }

    public ExceptionContext getContext() {
        MethodContext _bcornu_methode_context2900 = new MethodContext(ExceptionContext.class, 58, 2182, 2274);
        try {
            CallChecker.varInit(this, "this", 58, 2182, 2274);
            CallChecker.varInit(this.context, "context", 58, 2182, 2274);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathUnsupportedOperationException.serialVersionUID", 58, 2182, 2274);
            return context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExceptionContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2900.methodEnd();
        }
    }

    @Override
    public String getMessage() {
        MethodContext _bcornu_methode_context2901 = new MethodContext(String.class, 64, 2281, 2390);
        try {
            CallChecker.varInit(this, "this", 64, 2281, 2390);
            CallChecker.varInit(this.context, "context", 64, 2281, 2390);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathUnsupportedOperationException.serialVersionUID", 64, 2281, 2390);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 65, 2364, 2370)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 65, 2364, 2370).getMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2901.methodEnd();
        }
    }

    @Override
    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context2902 = new MethodContext(String.class, 70, 2397, 2524);
        try {
            CallChecker.varInit(this, "this", 70, 2397, 2524);
            CallChecker.varInit(this.context, "context", 70, 2397, 2524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathUnsupportedOperationException.serialVersionUID", 70, 2397, 2524);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 71, 2489, 2495)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 71, 2489, 2495).getLocalizedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2902.methodEnd();
        }
    }
}

