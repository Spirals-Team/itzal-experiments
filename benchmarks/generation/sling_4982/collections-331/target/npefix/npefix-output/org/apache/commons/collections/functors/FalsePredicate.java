package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class FalsePredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 7533784454832764388L;

    public static final Predicate<Object> INSTANCE = new FalsePredicate<Object>();

    @Deprecated
    public static <T> Predicate<T> getInstance() {
        MethodContext _bcornu_methode_context2372 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.FalsePredicate.INSTANCE", 47, 1462, 1766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FalsePredicate.serialVersionUID", 47, 1462, 1766);
            return FalsePredicate.<T>falsePredicate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2372.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> falsePredicate() {
        MethodContext _bcornu_methode_context2373 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.FalsePredicate.INSTANCE", 58, 1773, 2028);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FalsePredicate.serialVersionUID", 58, 1773, 2028);
            return ((Predicate<T>) (FalsePredicate.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2373.methodEnd();
        }
    }

    private FalsePredicate() {
        super();
        MethodContext _bcornu_methode_context448 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context448.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context2374 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2137, 2344);
            CallChecker.varInit(object, "object", 75, 2137, 2344);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.FalsePredicate.INSTANCE", 75, 2137, 2344);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FalsePredicate.serialVersionUID", 75, 2137, 2344);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2374.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2375 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 79, 2351, 2411);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.FalsePredicate.INSTANCE", 79, 2351, 2411);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.FalsePredicate.serialVersionUID", 79, 2351, 2411);
            return FalsePredicate.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2375.methodEnd();
        }
    }
}

