package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class NotNullPredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = 7533784454832764388L;

    public static final Predicate<Object> INSTANCE = new NotNullPredicate<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> getInstance() {
        MethodContext _bcornu_methode_context1585 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NotNullPredicate.INSTANCE", 46, 1483, 1757);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotNullPredicate.serialVersionUID", 46, 1483, 1757);
            return ((Predicate<T>) (NotNullPredicate.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1585.methodEnd();
        }
    }

    private NotNullPredicate() {
        super();
        MethodContext _bcornu_methode_context309 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context309.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1586 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 63, 1868, 2122);
            CallChecker.varInit(object, "object", 63, 1868, 2122);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NotNullPredicate.INSTANCE", 63, 1868, 2122);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotNullPredicate.serialVersionUID", 63, 1868, 2122);
            return object != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1586.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1587 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 67, 2129, 2189);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NotNullPredicate.INSTANCE", 67, 2129, 2189);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotNullPredicate.serialVersionUID", 67, 2129, 2189);
            return NotNullPredicate.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1587.methodEnd();
        }
    }
}

