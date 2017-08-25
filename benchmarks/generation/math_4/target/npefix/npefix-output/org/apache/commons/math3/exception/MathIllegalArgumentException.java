package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.Localizable;

public class MathIllegalArgumentException extends IllegalArgumentException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    private final ExceptionContext context;

    public MathIllegalArgumentException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context872 = new ConstructorContext(MathIllegalArgumentException.class, 43, 1648, 1976);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 45, 1891, 1927);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 46, 1937, 1943)) {
                CallChecker.isCalled(context, ExceptionContext.class, 46, 1937, 1943).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context872.methodEnd();
        }
    }

    public ExceptionContext getContext() {
        MethodContext _bcornu_methode_context3890 = new MethodContext(ExceptionContext.class, 50, 1983, 2075);
        try {
            CallChecker.varInit(this, "this", 50, 1983, 2075);
            CallChecker.varInit(this.context, "context", 50, 1983, 2075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalArgumentException.serialVersionUID", 50, 1983, 2075);
            return context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExceptionContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3890.methodEnd();
        }
    }

    @Override
    public String getMessage() {
        MethodContext _bcornu_methode_context3891 = new MethodContext(String.class, 56, 2082, 2191);
        try {
            CallChecker.varInit(this, "this", 56, 2082, 2191);
            CallChecker.varInit(this.context, "context", 56, 2082, 2191);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalArgumentException.serialVersionUID", 56, 2082, 2191);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 57, 2165, 2171)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 57, 2165, 2171).getMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3891.methodEnd();
        }
    }

    @Override
    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context3892 = new MethodContext(String.class, 62, 2198, 2325);
        try {
            CallChecker.varInit(this, "this", 62, 2198, 2325);
            CallChecker.varInit(this.context, "context", 62, 2198, 2325);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalArgumentException.serialVersionUID", 62, 2198, 2325);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 63, 2290, 2296)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 63, 2290, 2296).getLocalizedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3892.methodEnd();
        }
    }
}

