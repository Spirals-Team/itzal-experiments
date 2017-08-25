package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class ExceptionFactory<T> implements Serializable , Factory<T> {
    private static final long serialVersionUID = 7179106032121985545L;

    public static final Factory<Object> INSTANCE = new ExceptionFactory<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Factory<T> getInstance() {
        MethodContext _bcornu_methode_context701 = new MethodContext(Factory.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionFactory.INSTANCE", 47, 1520, 1791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionFactory.serialVersionUID", 47, 1520, 1791);
            return ((Factory<T>) (ExceptionFactory.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Factory<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context701.methodEnd();
        }
    }

    private ExceptionFactory() {
        super();
        MethodContext _bcornu_methode_context124 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public T create() {
        throw new FunctorException("ExceptionFactory invoked");
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context703 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 68, 2116, 2176);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionFactory.INSTANCE", 68, 2116, 2176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionFactory.serialVersionUID", 68, 2116, 2176);
            return ExceptionFactory.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context703.methodEnd();
        }
    }
}

