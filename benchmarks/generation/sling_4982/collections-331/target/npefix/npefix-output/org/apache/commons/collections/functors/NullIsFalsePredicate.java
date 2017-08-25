package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class NullIsFalsePredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -2997501534564735525L;

    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> getInstance(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 46, 1472, 1958);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsFalsePredicate.serialVersionUID", 46, 1472, 1958);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new NullIsFalsePredicate<T>(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public NullIsFalsePredicate(Predicate<? super T> predicate) {
        super();
        MethodContext _bcornu_methode_context1 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 61, 2245, 2267);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 71, 2280, 2690);
            CallChecker.varInit(object, "object", 71, 2280, 2690);
            CallChecker.varInit(this.iPredicate, "iPredicate", 71, 2280, 2690);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsFalsePredicate.serialVersionUID", 71, 2280, 2690);
            if (object == null) {
                return false;
            }
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 75, 2657, 2666)) {
                return CallChecker.isCalled(iPredicate, Predicate.class, 75, 2657, 2666).evaluate(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context3 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 85, 2697, 2996);
            CallChecker.varInit(this.iPredicate, "iPredicate", 85, 2697, 2996);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsFalsePredicate.serialVersionUID", 85, 2697, 2996);
            return new Predicate[]{ iPredicate };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }
}

