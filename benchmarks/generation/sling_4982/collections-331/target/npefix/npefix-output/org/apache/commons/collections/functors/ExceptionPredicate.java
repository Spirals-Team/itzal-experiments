package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class ExceptionPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 7179106032121985545L;

    public static final Predicate<Object> INSTANCE = new ExceptionPredicate<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> getInstance() {
        MethodContext _bcornu_methode_context1926 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionPredicate.INSTANCE", 47, 1532, 1806);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionPredicate.serialVersionUID", 47, 1532, 1806);
            return ((Predicate<T>) (ExceptionPredicate.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1926.methodEnd();
        }
    }

    private ExceptionPredicate() {
        super();
        MethodContext _bcornu_methode_context369 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context369.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1927 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 65, 1919, 2208);
            CallChecker.varInit(object, "object", 65, 1919, 2208);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionPredicate.INSTANCE", 65, 1919, 2208);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionPredicate.serialVersionUID", 65, 1919, 2208);
            throw new FunctorException("ExceptionPredicate invoked");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1927.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1928 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 69, 2215, 2275);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionPredicate.INSTANCE", 69, 2215, 2275);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionPredicate.serialVersionUID", 69, 2215, 2275);
            return ExceptionPredicate.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1928.methodEnd();
        }
    }
}

