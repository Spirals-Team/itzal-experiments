package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class NullPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 7533784454832764388L;

    public static final Predicate<?> INSTANCE = new NullPredicate<Object>();

    @Deprecated
    public static <T> Predicate<T> getInstance() {
        MethodContext _bcornu_methode_context1984 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NullPredicate.INSTANCE", 47, 1468, 1772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullPredicate.serialVersionUID", 47, 1468, 1772);
            return NullPredicate.nullPredicate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1984.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> nullPredicate() {
        MethodContext _bcornu_methode_context1985 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NullPredicate.INSTANCE", 58, 1779, 2055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullPredicate.serialVersionUID", 58, 1779, 2055);
            return ((Predicate<T>) (NullPredicate.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1985.methodEnd();
        }
    }

    private NullPredicate() {
        super();
        MethodContext _bcornu_methode_context384 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context384.methodEnd();
        }
    }

    public boolean evaluate(Object object) {
        MethodContext _bcornu_methode_context1986 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2163, 2408);
            CallChecker.varInit(object, "object", 75, 2163, 2408);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NullPredicate.INSTANCE", 75, 2163, 2408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullPredicate.serialVersionUID", 75, 2163, 2408);
            return object == null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1986.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1987 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 79, 2415, 2475);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NullPredicate.INSTANCE", 79, 2415, 2475);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullPredicate.serialVersionUID", 79, 2415, 2475);
            return NullPredicate.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1987.methodEnd();
        }
    }
}

