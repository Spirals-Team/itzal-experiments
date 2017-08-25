package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class NotPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -2654603322338049674L;

    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> getInstance(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1582 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 46, 1485, 1957);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotPredicate.serialVersionUID", 46, 1485, 1957);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new NotPredicate<T>(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1582.methodEnd();
        }
    }

    public NotPredicate(Predicate<? super T> predicate) {
        super();
        MethodContext _bcornu_methode_context308 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 61, 2237, 2259);
        } finally {
            _bcornu_methode_context308.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1583 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 70, 2272, 2548);
            CallChecker.varInit(object, "object", 70, 2272, 2548);
            CallChecker.varInit(this.iPredicate, "iPredicate", 70, 2272, 2548);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotPredicate.serialVersionUID", 70, 2272, 2548);
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 71, 2514, 2523)) {
                return !(CallChecker.isCalled(iPredicate, Predicate.class, 71, 2514, 2523).evaluate(object));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1583.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context1584 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 81, 2555, 2853);
            CallChecker.varInit(this.iPredicate, "iPredicate", 81, 2555, 2853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NotPredicate.serialVersionUID", 81, 2555, 2853);
            return new Predicate[]{ iPredicate };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1584.methodEnd();
        }
    }
}

