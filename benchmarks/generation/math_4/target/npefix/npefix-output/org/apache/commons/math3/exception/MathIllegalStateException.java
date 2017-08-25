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

public class MathIllegalStateException extends IllegalStateException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    private final ExceptionContext context;

    public MathIllegalStateException(Localizable pattern, Object... args) {
        ConstructorContext _bcornu_methode_context1238 = new ConstructorContext(MathIllegalStateException.class, 44, 1556, 1912);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 46, 1827, 1863);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 47, 1873, 1879)) {
                CallChecker.isCalled(context, ExceptionContext.class, 47, 1873, 1879).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context1238.methodEnd();
        }
    }

    public MathIllegalStateException(Throwable cause, Localizable pattern, Object... args) {
        super(cause);
        ConstructorContext _bcornu_methode_context1239 = new ConstructorContext(MathIllegalStateException.class, 57, 1919, 2383);
        try {
            context = new ExceptionContext(this);
            CallChecker.varAssign(this.context, "this.context", 61, 2298, 2334);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 62, 2344, 2350)) {
                CallChecker.isCalled(context, ExceptionContext.class, 62, 2344, 2350).addMessage(pattern, args);
            }
        } finally {
            _bcornu_methode_context1239.methodEnd();
        }
    }

    public MathIllegalStateException() {
        this(LocalizedFormats.ILLEGAL_STATE);
        ConstructorContext _bcornu_methode_context1240 = new ConstructorContext(MathIllegalStateException.class, 68, 2390, 2521);
        try {
        } finally {
            _bcornu_methode_context1240.methodEnd();
        }
    }

    public ExceptionContext getContext() {
        MethodContext _bcornu_methode_context5561 = new MethodContext(ExceptionContext.class, 73, 2528, 2620);
        try {
            CallChecker.varInit(this, "this", 73, 2528, 2620);
            CallChecker.varInit(this.context, "context", 73, 2528, 2620);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalStateException.serialVersionUID", 73, 2528, 2620);
            return context;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExceptionContext) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5561.methodEnd();
        }
    }

    @Override
    public String getMessage() {
        MethodContext _bcornu_methode_context5562 = new MethodContext(String.class, 79, 2627, 2736);
        try {
            CallChecker.varInit(this, "this", 79, 2627, 2736);
            CallChecker.varInit(this.context, "context", 79, 2627, 2736);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalStateException.serialVersionUID", 79, 2627, 2736);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 80, 2710, 2716)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 80, 2710, 2716).getMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5562.methodEnd();
        }
    }

    @Override
    public String getLocalizedMessage() {
        MethodContext _bcornu_methode_context5563 = new MethodContext(String.class, 85, 2743, 2870);
        try {
            CallChecker.varInit(this, "this", 85, 2743, 2870);
            CallChecker.varInit(this.context, "context", 85, 2743, 2870);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalStateException.serialVersionUID", 85, 2743, 2870);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 86, 2835, 2841)) {
                return CallChecker.isCalled(context, ExceptionContext.class, 86, 2835, 2841).getLocalizedMessage();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5563.methodEnd();
        }
    }
}

