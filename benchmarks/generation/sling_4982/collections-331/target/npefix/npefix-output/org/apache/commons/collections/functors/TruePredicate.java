package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class TruePredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 3374767158756189740L;

    public static final Predicate<?> INSTANCE = new TruePredicate<Object>();

    @Deprecated
    public static <T> Predicate<T> getInstance() {
        MethodContext _bcornu_methode_context1922 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.TruePredicate.INSTANCE", 48, 1480, 1746);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TruePredicate.serialVersionUID", 48, 1480, 1746);
            return TruePredicate.truePredicate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1922.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> truePredicate() {
        MethodContext _bcornu_methode_context1923 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.TruePredicate.INSTANCE", 59, 1753, 2029);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TruePredicate.serialVersionUID", 59, 1753, 2029);
            return ((Predicate<T>) (TruePredicate.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1923.methodEnd();
        }
    }

    private TruePredicate() {
        super();
        MethodContext _bcornu_methode_context368 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context368.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1924 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 76, 2137, 2341);
            CallChecker.varInit(object, "object", 76, 2137, 2341);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.TruePredicate.INSTANCE", 76, 2137, 2341);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TruePredicate.serialVersionUID", 76, 2137, 2341);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1924.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1925 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 80, 2348, 2408);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.TruePredicate.INSTANCE", 80, 2348, 2408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.TruePredicate.serialVersionUID", 80, 2348, 2408);
            return TruePredicate.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1925.methodEnd();
        }
    }
}

