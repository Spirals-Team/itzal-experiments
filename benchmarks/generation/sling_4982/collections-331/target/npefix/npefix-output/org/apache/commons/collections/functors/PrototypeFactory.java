package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import java.io.IOException;

public class PrototypeFactory {
    @SuppressWarnings(value = "unchecked")
    public static <T> Factory<T> getInstance(T prototype) {
        MethodContext _bcornu_methode_context2432 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(prototype, "prototype", 59, 1534, 3293);
            if (prototype == null) {
                return ConstantFactory.<T>getInstance(null);
            }
            TryContext _bcornu_try_context_30 = new TryContext(30, PrototypeFactory.class, "java.lang.NoSuchMethodException");
            try {
                Method method = CallChecker.init(Method.class);
                if (CallChecker.beforeDeref(prototype.getClass(), Class.class, 64, 2424, 2443)) {
                    method = CallChecker.isCalled(prototype.getClass(), Class.class, 64, 2424, 2443).getMethod("clone", ((Class[]) (null)));
                    CallChecker.varAssign(method, "method", 64, 2424, 2443);
                }
                return new PrototypeFactory.PrototypeCloneFactory<T>(prototype, method);
            } catch (NoSuchMethodException ex) {
                _bcornu_try_context_30.catchStart(30);
                TryContext _bcornu_try_context_29 = new TryContext(29, PrototypeFactory.class, "java.lang.NoSuchMethodException");
                try {
                    if (CallChecker.beforeDeref(prototype.getClass(), Class.class, 69, 2629, 2648)) {
                        CallChecker.isCalled(prototype.getClass(), Class.class, 69, 2629, 2648).getConstructor(new Class<?>[]{ prototype.getClass() });
                    }
                    return new InstantiateFactory<T>(((Class<T>) (prototype.getClass())), new Class<?>[]{ prototype.getClass() }, new Object[]{ prototype });
                } catch (NoSuchMethodException ex2) {
                    _bcornu_try_context_29.catchStart(29);
                    if (prototype instanceof Serializable) {
                        return ((Factory<T>) (new PrototypeFactory.PrototypeSerializationFactory<Serializable>(((Serializable) (prototype)))));
                    }
                } finally {
                    _bcornu_try_context_29.finallyStart(29);
                }
            } finally {
                _bcornu_try_context_30.finallyStart(30);
            }
            throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2432.methodEnd();
        }
    }

    private PrototypeFactory() {
        super();
        MethodContext _bcornu_methode_context461 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context461.methodEnd();
        }
    }

    static class PrototypeCloneFactory<T> implements Serializable , Factory<T> {
        private static final long serialVersionUID = 5604271422565175555L;

        private final T iPrototype;

        private transient Method iCloneMethod;

        private PrototypeCloneFactory(T prototype, Method method) {
            super();
            MethodContext _bcornu_methode_context462 = new MethodContext(null);
            try {
                iPrototype = prototype;
                CallChecker.varAssign(this.iPrototype, "this.iPrototype", 111, 4230, 4252);
                iCloneMethod = method;
                CallChecker.varAssign(this.iCloneMethod, "this.iCloneMethod", 112, 4266, 4287);
            } finally {
                _bcornu_methode_context462.methodEnd();
            }
        }

        private void findCloneMethod() {
            MethodContext _bcornu_methode_context2433 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 118, 4308, 4722);
                CallChecker.varInit(this.iCloneMethod, "iCloneMethod", 118, 4308, 4722);
                CallChecker.varInit(this.iPrototype, "iPrototype", 118, 4308, 4722);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.PrototypeFactory.PrototypeCloneFactory.serialVersionUID", 118, 4308, 4722);
                TryContext _bcornu_try_context_31 = new TryContext(31, PrototypeFactory.class, "java.lang.NoSuchMethodException");
                try {
                    if (CallChecker.beforeDeref(iPrototype, null, 120, 4472, 4481)) {
                        if (CallChecker.beforeDeref(iPrototype.getClass(), Class.class, 120, 4472, 4492)) {
                            iCloneMethod = CallChecker.isCalled(iPrototype.getClass(), Class.class, 120, 4472, 4492).getMethod("clone", ((Class[]) (null)));
                            CallChecker.varAssign(this.iCloneMethod, "this.iCloneMethod", 120, 4457, 4528);
                        }
                    }
                } catch (NoSuchMethodException ex) {
                    _bcornu_try_context_31.catchStart(31);
                    throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
                } finally {
                    _bcornu_try_context_31.finallyStart(31);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2433.methodEnd();
            }
        }

        @SuppressWarnings(value = "unchecked")
        public T create() {
            if ((iCloneMethod) == null) {
                findCloneMethod();
            }
            TryContext _bcornu_try_context_32 = new TryContext(32, PrototypeFactory.class, "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
            try {
                if (CallChecker.beforeDeref(iCloneMethod, Method.class, 139, 5100, 5111)) {
                    iCloneMethod = CallChecker.beforeCalled(iCloneMethod, Method.class, 139, 5100, 5111);
                    return ((T) (CallChecker.isCalled(iCloneMethod, Method.class, 139, 5100, 5111).invoke(iPrototype, ((Object[]) (null)))));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IllegalAccessException ex) {
                _bcornu_try_context_32.catchStart(32);
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", ex);
            } catch (InvocationTargetException ex) {
                _bcornu_try_context_32.catchStart(32);
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", ex);
            } finally {
                _bcornu_try_context_32.finallyStart(32);
            }
        }
    }

    static class PrototypeSerializationFactory<T extends Serializable> implements Serializable , Factory<T> {
        private static final long serialVersionUID = -8704966966139178833L;

        private final T iPrototype;

        private PrototypeSerializationFactory(T prototype) {
            super();
            MethodContext _bcornu_methode_context463 = new MethodContext(null);
            try {
                iPrototype = prototype;
                CallChecker.varAssign(this.iPrototype, "this.iPrototype", 166, 6217, 6239);
            } finally {
                _bcornu_methode_context463.methodEnd();
            }
        }

        @SuppressWarnings(value = "unchecked")
        public T create() {
            ByteArrayOutputStream baos = CallChecker.varInit(new ByteArrayOutputStream(512), "baos", 176, 6451, 6510);
            ByteArrayInputStream bais = CallChecker.varInit(null, "bais", 177, 6524, 6556);
            TryContext _bcornu_try_context_35 = new TryContext(35, PrototypeFactory.class, "java.lang.ClassNotFoundException", "java.io.IOException");
            try {
                ObjectOutputStream out = CallChecker.varInit(new ObjectOutputStream(baos), "out", 179, 6592, 6645);
                if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 180, 6663, 6665)) {
                    out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 180, 6663, 6665);
                    CallChecker.isCalled(out, ObjectOutputStream.class, 180, 6663, 6665).writeObject(iPrototype);
                }
                if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 182, 6741, 6744)) {
                    baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 182, 6741, 6744);
                    bais = new ByteArrayInputStream(CallChecker.isCalled(baos, ByteArrayOutputStream.class, 182, 6741, 6744).toByteArray());
                    CallChecker.varAssign(bais, "bais", 182, 6709, 6760);
                }
                ObjectInputStream in = CallChecker.varInit(new ObjectInputStream(bais), "in", 183, 6778, 6828);
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 184, 6857, 6858)) {
                    in = CallChecker.beforeCalled(in, ObjectInputStream.class, 184, 6857, 6858);
                    return ((T) (CallChecker.isCalled(in, ObjectInputStream.class, 184, 6857, 6858).readObject()));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassNotFoundException ex) {
                _bcornu_try_context_35.catchStart(35);
                throw new FunctorException(ex);
            } catch (IOException ex) {
                _bcornu_try_context_35.catchStart(35);
                throw new FunctorException(ex);
            } finally {
                _bcornu_try_context_35.finallyStart(35);
                TryContext _bcornu_try_context_33 = new TryContext(33, PrototypeFactory.class, "java.io.IOException");
                try {
                    if (bais != null) {
                        bais.close();
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_33.catchStart(33);
                } finally {
                    _bcornu_try_context_33.finallyStart(33);
                }
                TryContext _bcornu_try_context_34 = new TryContext(34, PrototypeFactory.class, "java.io.IOException");
                try {
                    if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 199, 7339, 7342)) {
                        baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 199, 7339, 7342);
                        CallChecker.isCalled(baos, ByteArrayOutputStream.class, 199, 7339, 7342).close();
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_34.catchStart(34);
                } finally {
                    _bcornu_try_context_34.finallyStart(34);
                }
            }
        }
    }
}

