package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class NullIsTruePredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -7625133768987126273L;

    private final Predicate<? super T> iPredicate;

    public static <T> Predicate<T> getInstance(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1574 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 46, 1478, 1963);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsTruePredicate.serialVersionUID", 46, 1478, 1963);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new NullIsTruePredicate<T>(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1574.methodEnd();
        }
    }

    public NullIsTruePredicate(Predicate<? super T> predicate) {
        super();
        MethodContext _bcornu_methode_context303 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 61, 2250, 2272);
        } finally {
            _bcornu_methode_context303.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context1575 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 71, 2285, 2688);
            CallChecker.varInit(object, "object", 71, 2285, 2688);
            CallChecker.varInit(this.iPredicate, "iPredicate", 71, 2285, 2688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsTruePredicate.serialVersionUID", 71, 2285, 2688);
            if (object == null) {
                return true;
            }
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 75, 2655, 2664)) {
                return CallChecker.isCalled(iPredicate, Predicate.class, 75, 2655, 2664).evaluate(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1575.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context1576 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 85, 2695, 2995);
            CallChecker.varInit(this.iPredicate, "iPredicate", 85, 2695, 2995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NullIsTruePredicate.serialVersionUID", 85, 2695, 2995);
            return new Predicate[]{ iPredicate };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1576.methodEnd();
        }
    }
}

