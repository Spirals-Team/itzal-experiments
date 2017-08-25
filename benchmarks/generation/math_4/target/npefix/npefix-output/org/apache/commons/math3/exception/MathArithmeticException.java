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

public class MathArithmeticException extends ArithmeticException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    private final ExceptionContext context;

    public MathArithmeticException() {
        ConstructorContext _bcornu_methode_context847 = new ConstructorContext(MathArithmeticException.class, 43, 1634, 1830);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 44, 1721, 1757);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 45, 1767, 1773)) {
                CallChecker.isCalled(context, ExceptionContext.class, 45, 1767, 1773).addMessage(LocalizedFormats.ARITHMETIC_EXCEPTION);
            }
        } finally {
            _bcornu_methode_context847.methodEnd();
        }
    }

    public MathArithmeticException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context848 = new ConstructorContext(MathArithmeticException.class, 55, 1837, 2223);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 57, 2138, 2174);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 58, 2184, 2190)) {
                CallChecker.isCalled(context, ExceptionContext.class, 58, 2184, 2190).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context848.methodEnd();
        }
    }

    public ExceptionContext getContext() {
        MethodContext _bcornu_methode_context3698 = new MethodContext(ExceptionContext.class, 62, 2230, 2322);
        try {
            CallChecker.varInit(this, "this", 62, 2230, 2322);
            CallChecker.varInit(this.context, "context", 62, 2230, 2322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathArithmeticException.serialVersionUID", 62, 2230, 2322);
            return context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExceptionContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3698.methodEnd();
        }
    }

    @Override
    public String getMessage() {
        MethodContext _bcornu_methode_context3699 = new MethodContext(String.class, 68, 2329, 2438);
        try {
            CallChecker.varInit(this, "this", 68, 2329, 2438);
            CallChecker.varInit(this.context, "context", 68, 2329, 2438);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathArithmeticException.serialVersionUID", 68, 2329, 2438);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 69, 2412, 2418)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 69, 2412, 2418).getMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3699.methodEnd();
        }
    }

    @Override
    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context3700 = new MethodContext(String.class, 74, 2445, 2572);
        try {
            CallChecker.varInit(this, "this", 74, 2445, 2572);
            CallChecker.varInit(this.context, "context", 74, 2445, 2572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathArithmeticException.serialVersionUID", 74, 2445, 2572);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 75, 2537, 2543)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 75, 2537, 2543).getLocalizedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3700.methodEnd();
        }
    }
}

