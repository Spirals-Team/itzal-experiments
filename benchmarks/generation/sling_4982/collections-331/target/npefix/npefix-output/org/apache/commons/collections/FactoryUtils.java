package org.apache.commons.collections;

import org.apache.commons.collections.functors.PrototypeFactory;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.functors.InstantiateFactory;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.functors.ExceptionFactory;
import org.apache.commons.collections.functors.ConstantFactory;
import fr.inria.spirals.npefix.resi.CallChecker;

public class FactoryUtils {
    public FactoryUtils() {
        super();
        MethodContext _bcornu_methode_context367 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context367.methodEnd();
        }
    }

    public static <T> Factory<T> exceptionFactory() {
        MethodContext _bcornu_methode_context1916 = new MethodContext(Factory.class);
        try {
            return ExceptionFactory.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1916.methodEnd();
        }
    }

    public static <T> Factory<T> nullFactory() {
        MethodContext _bcornu_methode_context1917 = new MethodContext(Factory.class);
        try {
            return ConstantFactory.<T>getInstance(null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1917.methodEnd();
        }
    }

    public static <T> Factory<T> constantFactory(T constantToReturn) {
        MethodContext _bcornu_methode_context1918 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(constantToReturn, "constantToReturn", 85, 2646, 3290);
            return ConstantFactory.getInstance(constantToReturn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1918.methodEnd();
        }
    }

    public static <T> Factory<T> prototypeFactory(T prototype) {
        MethodContext _bcornu_methode_context1919 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(prototype, "prototype", 106, 3297, 4097);
            return PrototypeFactory.<T>getInstance(prototype);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1919.methodEnd();
        }
    }

    public static <T> Factory<T> instantiateFactory(Class<T> classToInstantiate) {
        MethodContext _bcornu_methode_context1920 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(classToInstantiate, "classToInstantiate", 120, 4104, 4681);
            return InstantiateFactory.getInstance(classToInstantiate, null, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1920.methodEnd();
        }
    }

    public static <T> Factory<T> instantiateFactory(Class<T> classToInstantiate, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context1921 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(args, "args", 138, 4688, 5627);
            CallChecker.varInit(paramTypes, "paramTypes", 138, 4688, 5627);
            CallChecker.varInit(classToInstantiate, "classToInstantiate", 138, 4688, 5627);
            return InstantiateFactory.getInstance(classToInstantiate, paramTypes, args);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1921.methodEnd();
        }
    }
}

