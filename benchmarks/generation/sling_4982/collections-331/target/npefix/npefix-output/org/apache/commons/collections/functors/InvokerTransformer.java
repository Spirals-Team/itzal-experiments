package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class InvokerTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = -8653385846894047688L;

    private final String iMethodName;

    private final Class<?>[] iParamTypes;

    private final Object[] iArgs;

    public static <I, O> Transformer<I, O> getInstance(String methodName) {
        MethodContext _bcornu_methode_context2399 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(methodName, "methodName", 53, 1764, 2269);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InvokerTransformer.serialVersionUID", 53, 1764, 2269);
            if (methodName == null) {
                throw new IllegalArgumentException("The method to invoke must not be null");
            }
            return new InvokerTransformer<I, O>(methodName);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2399.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> getInstance(String methodName, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context2400 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(args, "args", 68, 2276, 3460);
            CallChecker.varInit(paramTypes, "paramTypes", 68, 2276, 3460);
            CallChecker.varInit(methodName, "methodName", 68, 2276, 3460);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InvokerTransformer.serialVersionUID", 68, 2276, 3460);
            if (methodName == null) {
                throw new IllegalArgumentException("The method to invoke must not be null");
            }
            if ((((paramTypes == null) && (args != null)) || ((paramTypes != null) && (args == null))) || (((paramTypes != null) && (args != null)) && ((paramTypes.length) != (args.length)))) {
                throw new IllegalArgumentException("The parameter types must match the arguments");
            }
            if ((paramTypes == null) || ((paramTypes.length) == 0)) {
                return new InvokerTransformer<I, O>(methodName);
            }else {
                paramTypes = paramTypes.clone();
                CallChecker.varAssign(paramTypes, "paramTypes", 80, 3301, 3332);
                args = args.clone();
                CallChecker.varAssign(args, "args", 81, 3346, 3365);
                return new InvokerTransformer<I, O>(methodName, paramTypes, args);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2400.methodEnd();
        }
    }

    private InvokerTransformer(String methodName) {
        super();
        MethodContext _bcornu_methode_context456 = new MethodContext(null);
        try {
            iMethodName = methodName;
            CallChecker.varAssign(this.iMethodName, "this.iMethodName", 93, 3649, 3673);
            iParamTypes = null;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 94, 3683, 3701);
            iArgs = null;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 95, 3711, 3723);
        } finally {
            _bcornu_methode_context456.methodEnd();
        }
    }

    public InvokerTransformer(String methodName, Class<?>[] paramTypes, Object[] args) {
        super();
        MethodContext _bcornu_methode_context457 = new MethodContext(null);
        try {
            iMethodName = methodName;
            CallChecker.varAssign(this.iMethodName, "this.iMethodName", 108, 4145, 4169);
            iParamTypes = paramTypes;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 109, 4179, 4203);
            iArgs = args;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 110, 4213, 4225);
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public O transform(Object input) {
        if (input == null) {
            return null;
        }
        TryContext _bcornu_try_context_28 = new TryContext(28, InvokerTransformer.class, "java.lang.NoSuchMethodException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
        try {
            Class<?> cls = CallChecker.varInit(input.getClass(), "cls", 125, 4604, 4635);
            Method method = CallChecker.init(Method.class);
            if (CallChecker.beforeDeref(cls, Class.class, 126, 4665, 4667)) {
                cls = CallChecker.beforeCalled(cls, Class.class, 126, 4665, 4667);
                method = CallChecker.isCalled(cls, Class.class, 126, 4665, 4667).getMethod(iMethodName, iParamTypes);
                CallChecker.varAssign(method, "method", 126, 4665, 4667);
            }
            if (CallChecker.beforeDeref(method, Method.class, 127, 4729, 4734)) {
                method = CallChecker.beforeCalled(method, Method.class, 127, 4729, 4734);
                return ((O) (CallChecker.isCalled(method, Method.class, 127, 4729, 4734).invoke(input, iArgs)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (NoSuchMethodException ex) {
            _bcornu_try_context_28.catchStart(28);
            throw new FunctorException((((("InvokerTransformer: The method '" + (iMethodName)) + "' on '") + (input.getClass())) + "' does not exist"));
        } catch (IllegalAccessException ex) {
            _bcornu_try_context_28.catchStart(28);
            throw new FunctorException((((("InvokerTransformer: The method '" + (iMethodName)) + "' on '") + (input.getClass())) + "' cannot be accessed"));
        } catch (InvocationTargetException ex) {
            _bcornu_try_context_28.catchStart(28);
            throw new FunctorException((((("InvokerTransformer: The method '" + (iMethodName)) + "' on '") + (input.getClass())) + "' threw an exception"), ex);
        } finally {
            _bcornu_try_context_28.finallyStart(28);
        }
    }
}

