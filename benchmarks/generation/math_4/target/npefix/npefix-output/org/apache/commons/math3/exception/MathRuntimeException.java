package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.Localizable;

public class MathRuntimeException extends RuntimeException implements ExceptionContextProvider {
    private static final long serialVersionUID = 20120926L;

    private final ExceptionContext context;

    public MathRuntimeException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context912 = new ConstructorContext(MathRuntimeException.class, 44, 1666, 1978);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 46, 1893, 1929);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 47, 1939, 1945)) {
                CallChecker.isCalled(context, ExceptionContext.class, 47, 1939, 1945).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context912.methodEnd();
        }
    }

    public ExceptionContext getContext() {
        MethodContext _bcornu_methode_context4144 = new MethodContext(ExceptionContext.class, 51, 1985, 2077);
        try {
            CallChecker.varInit(this, "this", 51, 1985, 2077);
            CallChecker.varInit(this.context, "context", 51, 1985, 2077);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathRuntimeException.serialVersionUID", 51, 1985, 2077);
            return context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExceptionContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4144.methodEnd();
        }
    }

    @Override
    public String getMessage() {
        MethodContext _bcornu_methode_context4145 = new MethodContext(String.class, 57, 2084, 2193);
        try {
            CallChecker.varInit(this, "this", 57, 2084, 2193);
            CallChecker.varInit(this.context, "context", 57, 2084, 2193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathRuntimeException.serialVersionUID", 57, 2084, 2193);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 58, 2167, 2173)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 58, 2167, 2173).getMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4145.methodEnd();
        }
    }

    @Override
    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context4146 = new MethodContext(String.class, 63, 2200, 2327);
        try {
            CallChecker.varInit(this, "this", 63, 2200, 2327);
            CallChecker.varInit(this.context, "context", 63, 2200, 2327);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathRuntimeException.serialVersionUID", 63, 2200, 2327);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 64, 2292, 2298)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 64, 2292, 2298).getLocalizedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4146.methodEnd();
        }
    }
}

