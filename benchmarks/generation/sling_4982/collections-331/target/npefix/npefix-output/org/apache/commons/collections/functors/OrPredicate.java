package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class OrPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -8791518325735182855L;

    private final Predicate<? super T> iPredicate1;

    private final Predicate<? super T> iPredicate2;

    public static <T> Predicate<T> getInstance(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        MethodContext _bcornu_methode_context2061 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate2, "predicate2", 49, 1583, 2209);
            CallChecker.varInit(predicate1, "predicate1", 49, 1583, 2209);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OrPredicate.serialVersionUID", 49, 1583, 2209);
            if ((predicate1 == null) || (predicate2 == null)) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            return new OrPredicate<T>(predicate1, predicate2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2061.methodEnd();
        }
    }

    public OrPredicate(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        super();
        MethodContext _bcornu_methode_context398 = new MethodContext(null);
        try {
            iPredicate1 = predicate1;
            CallChecker.varAssign(this.iPredicate1, "this.iPredicate1", 65, 2584, 2608);
            iPredicate2 = predicate2;
            CallChecker.varAssign(this.iPredicate2, "this.iPredicate2", 66, 2618, 2642);
        } finally {
            _bcornu_methode_context398.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context2062 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2655, 2978);
            CallChecker.varInit(object, "object", 75, 2655, 2978);
            CallChecker.varInit(this.iPredicate2, "iPredicate2", 75, 2655, 2978);
            CallChecker.varInit(this.iPredicate1, "iPredicate1", 75, 2655, 2978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OrPredicate.serialVersionUID", 75, 2655, 2978);
            return (CallChecker.isCalled(iPredicate1, Predicate.class, 76, 2911, 2921).evaluate(object)) || (CallChecker.isCalled(iPredicate2, Predicate.class, 76, 2943, 2953).evaluate(object));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2062.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context2063 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 86, 2985, 3282);
            CallChecker.varInit(this.iPredicate2, "iPredicate2", 86, 2985, 3282);
            CallChecker.varInit(this.iPredicate1, "iPredicate1", 86, 2985, 3282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OrPredicate.serialVersionUID", 86, 2985, 3282);
            return new Predicate[]{ iPredicate1 , iPredicate2 };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2063.methodEnd();
        }
    }
}

