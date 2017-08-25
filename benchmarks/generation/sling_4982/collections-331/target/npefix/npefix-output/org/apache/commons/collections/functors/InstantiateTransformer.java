package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.lang.reflect.Constructor;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import java.lang.reflect.InvocationTargetException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class InstantiateTransformer<T> implements Serializable , Transformer<Class<? extends T>, T> {
    private static final long serialVersionUID = 3786388740793356347L;

    public static final Transformer<Class<?>, ?> NO_ARG_INSTANCE = new InstantiateTransformer<Object>();

    private final Class<?>[] iParamTypes;

    private final Object[] iArgs;

    public static <T> Transformer<Class<? extends T>, T> getInstance() {
        MethodContext _bcornu_methode_context773 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(NO_ARG_INSTANCE, "org.apache.commons.collections.functors.InstantiateTransformer.NO_ARG_INSTANCE", 52, 1862, 2103);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstantiateTransformer.serialVersionUID", 52, 1862, 2103);
            return new InstantiateTransformer<T>();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<Class<? extends T>, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context773.methodEnd();
        }
    }

    public static <T> Transformer<Class<? extends T>, T> getInstance(Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context774 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(args, "args", 63, 2110, 3005);
            CallChecker.varInit(paramTypes, "paramTypes", 63, 2110, 3005);
            CallChecker.varInit(NO_ARG_INSTANCE, "org.apache.commons.collections.functors.InstantiateTransformer.NO_ARG_INSTANCE", 63, 2110, 3005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstantiateTransformer.serialVersionUID", 63, 2110, 3005);
            if ((((paramTypes == null) && (args != null)) || ((paramTypes != null) && (args == null))) || (((paramTypes != null) && (args != null)) && ((paramTypes.length) != (args.length)))) {
                throw new IllegalArgumentException("Parameter types must match the arguments");
            }
            if ((paramTypes == null) || ((paramTypes.length) == 0)) {
                return new InstantiateTransformer<T>();
            }
            paramTypes = paramTypes.clone();
            CallChecker.varAssign(paramTypes, "paramTypes", 73, 2875, 2906);
            args = args.clone();
            CallChecker.varAssign(args, "args", 74, 2916, 2935);
            return new InstantiateTransformer<T>(paramTypes, args);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<Class<? extends T>, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context774.methodEnd();
        }
    }

    private InstantiateTransformer() {
        super();
        MethodContext _bcornu_methode_context147 = new MethodContext(null);
        try {
            iParamTypes = null;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 83, 3128, 3146);
            iArgs = null;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 84, 3156, 3168);
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public InstantiateTransformer(Class<?>[] paramTypes, Object[] args) {
        super();
        MethodContext _bcornu_methode_context148 = new MethodContext(null);
        try {
            iParamTypes = paramTypes;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 96, 3529, 3553);
            iArgs = args;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 97, 3563, 3575);
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public T transform(Class<? extends T> input) {
        TryContext _bcornu_try_context_7 = new TryContext(7, InstantiateTransformer.class, "java.lang.NoSuchMethodException", "java.lang.InstantiationException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
        try {
            if ((input instanceof Class) == false) {
                if (CallChecker.beforeDeref(input, Class.class, 111, 4084, 4088)) {
                    input = CallChecker.beforeCalled(input, Class.class, 111, 4084, 4088);
                    if ((input == null) || (CallChecker.beforeDeref(CallChecker.isCalled(input, Class.class, 111, 4084, 4088).getClass(), Class.class, 111, 4084, 4099))) {
                        input = CallChecker.beforeCalled(input, Class.class, 111, 4084, 4088);
                        throw new FunctorException(("InstantiateTransformer: Input object was not an instanceof Class, it was a " + ((input == null) ? "null object" : CallChecker.isCalled(CallChecker.isCalled(input, Class.class, 111, 4084, 4088).getClass(), Class.class, 111, 4084, 4099).getName())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            Constructor<? extends T> con = CallChecker.init(Constructor.class);
            if (CallChecker.beforeDeref(input, Class.class, 113, 4171, 4175)) {
                input = CallChecker.beforeCalled(input, Class.class, 113, 4171, 4175);
                con = CallChecker.isCalled(input, Class.class, 113, 4171, 4175).getConstructor(iParamTypes);
                CallChecker.varAssign(con, "con", 113, 4171, 4175);
            }
            if (CallChecker.beforeDeref(con, Constructor.class, 114, 4225, 4227)) {
                return con.newInstance(iArgs);
            }else
                throw new AbnormalExecutionError();
            
        } catch (NoSuchMethodException ex) {
            _bcornu_try_context_7.catchStart(7);
            throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
        } catch (InstantiationException ex) {
            _bcornu_try_context_7.catchStart(7);
            throw new FunctorException("InstantiateTransformer: InstantiationException", ex);
        } catch (IllegalAccessException ex) {
            _bcornu_try_context_7.catchStart(7);
            throw new FunctorException("InstantiateTransformer: Constructor must be public", ex);
        } catch (InvocationTargetException ex) {
            _bcornu_try_context_7.catchStart(7);
            throw new FunctorException("InstantiateTransformer: Constructor threw an exception", ex);
        } finally {
            _bcornu_try_context_7.finallyStart(7);
        }
    }
}

