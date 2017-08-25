package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.lang.reflect.Constructor;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import java.lang.reflect.InvocationTargetException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class InstantiateFactory<T> implements Serializable , Factory<T> {
    private static final long serialVersionUID = -7732226881069447957L;

    private final Class<T> iClassToInstantiate;

    private final Class<?>[] iParamTypes;

    private final Object[] iArgs;

    private transient Constructor<T> iConstructor = null;

    public static <T> Factory<T> getInstance(Class<T> classToInstantiate, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context345 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(args, "args", 56, 1822, 2958);
            CallChecker.varInit(paramTypes, "paramTypes", 56, 1822, 2958);
            CallChecker.varInit(classToInstantiate, "classToInstantiate", 56, 1822, 2958);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstantiateFactory.serialVersionUID", 56, 1822, 2958);
            if (classToInstantiate == null) {
                throw new IllegalArgumentException("Class to instantiate must not be null");
            }
            if ((((paramTypes == null) && (args != null)) || ((paramTypes != null) && (args == null))) || (((paramTypes != null) && (args != null)) && ((paramTypes.length) != (args.length)))) {
                throw new IllegalArgumentException("Parameter types must match the arguments");
            }
            if ((paramTypes == null) || ((paramTypes.length) == 0)) {
                return new InstantiateFactory<T>(classToInstantiate);
            }
            paramTypes = paramTypes.clone();
            CallChecker.varAssign(paramTypes, "paramTypes", 69, 2812, 2843);
            args = args.clone();
            CallChecker.varAssign(args, "args", 70, 2853, 2872);
            return new InstantiateFactory<T>(classToInstantiate, paramTypes, args);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context345.methodEnd();
        }
    }

    public InstantiateFactory(Class<T> classToInstantiate) {
        super();
        MethodContext _bcornu_methode_context53 = new MethodContext(null);
        try {
            iClassToInstantiate = classToInstantiate;
            CallChecker.varAssign(this.iClassToInstantiate, "this.iClassToInstantiate", 82, 3232, 3272);
            iParamTypes = null;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 83, 3282, 3300);
            iArgs = null;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 84, 3310, 3322);
            findConstructor();
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public InstantiateFactory(Class<T> classToInstantiate, Class<?>[] paramTypes, Object[] args) {
        super();
        MethodContext _bcornu_methode_context54 = new MethodContext(null);
        try {
            iClassToInstantiate = classToInstantiate;
            CallChecker.varAssign(this.iClassToInstantiate, "this.iClassToInstantiate", 98, 3795, 3835);
            iParamTypes = paramTypes;
            CallChecker.varAssign(this.iParamTypes, "this.iParamTypes", 99, 3845, 3869);
            iArgs = args;
            CallChecker.varAssign(this.iArgs, "this.iArgs", 100, 3879, 3891);
            findConstructor();
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    private void findConstructor() {
        MethodContext _bcornu_methode_context346 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 107, 3931, 4296);
            CallChecker.varInit(this.iConstructor, "iConstructor", 107, 3931, 4296);
            CallChecker.varInit(this.iArgs, "iArgs", 107, 3931, 4296);
            CallChecker.varInit(this.iParamTypes, "iParamTypes", 107, 3931, 4296);
            CallChecker.varInit(this.iClassToInstantiate, "iClassToInstantiate", 107, 3931, 4296);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.InstantiateFactory.serialVersionUID", 107, 3931, 4296);
            TryContext _bcornu_try_context_2 = new TryContext(2, InstantiateFactory.class, "java.lang.NoSuchMethodException");
            try {
                if (CallChecker.beforeDeref(iClassToInstantiate, Class.class, 109, 4074, 4092)) {
                    iConstructor = CallChecker.isCalled(iClassToInstantiate, Class.class, 109, 4074, 4092).getConstructor(iParamTypes);
                    CallChecker.varAssign(this.iConstructor, "this.iConstructor", 109, 4059, 4121);
                }
            } catch (NoSuchMethodException ex) {
                _bcornu_try_context_2.catchStart(2);
                throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
            } finally {
                _bcornu_try_context_2.finallyStart(2);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }

    public T create() {
        if ((iConstructor) == null) {
            findConstructor();
        }
        TryContext _bcornu_try_context_3 = new TryContext(3, InstantiateFactory.class, "java.lang.InstantiationException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
        try {
            if (CallChecker.beforeDeref(iConstructor, Constructor.class, 128, 4584, 4595)) {
                return iConstructor.newInstance(iArgs);
            }else
                throw new AbnormalExecutionError();
            
        } catch (InstantiationException ex) {
            _bcornu_try_context_3.catchStart(3);
            throw new FunctorException("InstantiateFactory: InstantiationException", ex);
        } catch (IllegalAccessException ex) {
            _bcornu_try_context_3.catchStart(3);
            throw new FunctorException("InstantiateFactory: Constructor must be public", ex);
        } catch (InvocationTargetException ex) {
            _bcornu_try_context_3.catchStart(3);
            throw new FunctorException("InstantiateFactory: Constructor threw an exception", ex);
        } finally {
            _bcornu_try_context_3.finallyStart(3);
        }
    }
}

