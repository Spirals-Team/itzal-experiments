package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class NonePredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = 2007613066565892961L;

    private final Predicate<? super T>[] iPredicates;

    public static <T> Predicate<T> getInstance(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context760 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 56, 1711, 2447);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NonePredicate.serialVersionUID", 56, 1711, 2447);
            FunctorUtils.validate(predicates);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 58, 2253, 2262)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 58, 2253, 2262);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 58, 2253, 2262).length) == 0) {
                    return TruePredicate.<T>truePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            predicates = FunctorUtils.copy(predicates);
            CallChecker.varAssign(predicates, "predicates", 61, 2350, 2392);
            return new NonePredicate<T>(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context760.methodEnd();
        }
    }

    public static <T> Predicate<T> getInstance(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context761 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 75, 2454, 3176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NonePredicate.serialVersionUID", 75, 2454, 3176);
            Predicate<? super T>[] preds = CallChecker.varInit(FunctorUtils.validate(predicates), "preds", 76, 2966, 3030);
            if (CallChecker.beforeDeref(preds, Predicate[].class, 77, 3044, 3048)) {
                preds = CallChecker.beforeCalled(preds, Predicate[].class, 77, 3044, 3048);
                if ((CallChecker.isCalled(preds, Predicate[].class, 77, 3044, 3048).length) == 0) {
                    return TruePredicate.<T>truePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            return new NonePredicate<T>(preds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context761.methodEnd();
        }
    }

    public NonePredicate(Predicate<? super T>[] predicates) {
        super();
        MethodContext _bcornu_methode_context141 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 91, 3463, 3487);
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context762 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 100, 3500, 3933);
            CallChecker.varInit(object, "object", 100, 3500, 3933);
            CallChecker.varInit(this.iPredicates, "iPredicates", 100, 3500, 3933);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NonePredicate.serialVersionUID", 100, 3500, 3933);
            for (int i = 0; i < (CallChecker.isCalled(iPredicates, Predicate[].class, 101, 3776, 3786).length); i++) {
                if (CallChecker.beforeDeref(iPredicates, Predicate[].class, 102, 3819, 3829)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iPredicates, Predicate[].class, 102, 3819, 3829)[i], Predicate.class, 102, 3819, 3832)) {
                        CallChecker.isCalled(iPredicates, Predicate[].class, 102, 3819, 3829)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 102, 3819, 3829)[i], Predicate.class, 102, 3819, 3832);
                        if (CallChecker.isCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 102, 3819, 3829)[i], Predicate.class, 102, 3819, 3832).evaluate(object)) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context762.methodEnd();
        }
    }

    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context763 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 115, 3940, 4164);
            CallChecker.varInit(this.iPredicates, "iPredicates", 115, 3940, 4164);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NonePredicate.serialVersionUID", 115, 3940, 4164);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context763.methodEnd();
        }
    }
}

