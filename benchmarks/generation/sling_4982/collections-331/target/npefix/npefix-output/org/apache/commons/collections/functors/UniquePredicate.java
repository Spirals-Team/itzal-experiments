package org.apache.commons.collections.functors;

import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.HashSet;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class UniquePredicate<T> implements Serializable , Predicate<T> {
    private static final long serialVersionUID = -3319417438027438040L;

    private final Set<T> iSet = new HashSet<T>();

    public static <E> Predicate<E> getInstance() {
        MethodContext _bcornu_methode_context2117 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.UniquePredicate.serialVersionUID", 48, 1535, 1784);
            return new UniquePredicate<E>();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2117.methodEnd();
        }
    }

    public UniquePredicate() {
        super();
        MethodContext _bcornu_methode_context405 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context405.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context2118 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 67, 1964, 2263);
            CallChecker.varInit(object, "object", 67, 1964, 2263);
            CallChecker.varInit(this.iSet, "iSet", 67, 1964, 2263);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.UniquePredicate.serialVersionUID", 67, 1964, 2263);
            if (CallChecker.beforeDeref(iSet, Set.class, 68, 2241, 2244)) {
                return CallChecker.isCalled(iSet, Set.class, 68, 2241, 2244).add(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2118.methodEnd();
        }
    }
}

