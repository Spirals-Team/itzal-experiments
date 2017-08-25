package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class OnePredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    private final Predicate<? super T>[] iPredicates;

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> getInstance(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context776 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 58, 1724, 2660);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OnePredicate.serialVersionUID", 58, 1724, 2660);
            FunctorUtils.validate(predicates);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 60, 2368, 2377)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 60, 2368, 2377);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 60, 2368, 2377).length) == 0) {
                    return FalsePredicate.<T>falsePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 63, 2471, 2480)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 63, 2471, 2480);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 63, 2471, 2480).length) == 1) {
                    if (CallChecker.beforeDeref(predicates, Predicate[].class, 64, 2531, 2540)) {
                        predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 64, 2531, 2540);
                        return ((Predicate<T>) (CallChecker.isCalled(predicates, Predicate[].class, 64, 2531, 2540)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            predicates = FunctorUtils.copy(predicates);
            CallChecker.varAssign(predicates, "predicates", 66, 2564, 2606);
            return new OnePredicate<T>(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context776.methodEnd();
        }
    }

    public static <T> Predicate<T> getInstance(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context777 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 78, 2667, 3207);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OnePredicate.serialVersionUID", 78, 2667, 3207);
            Predicate<? super T>[] preds = CallChecker.varInit(FunctorUtils.validate(predicates), "preds", 79, 3094, 3158);
            return new OnePredicate<T>(preds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context777.methodEnd();
        }
    }

    public OnePredicate(Predicate<? super T>[] predicates) {
        super();
        MethodContext _bcornu_methode_context149 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 91, 3494, 3518);
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context778 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 101, 3531, 4092);
            CallChecker.varInit(object, "object", 101, 3531, 4092);
            CallChecker.varInit(this.iPredicates, "iPredicates", 101, 3531, 4092);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OnePredicate.serialVersionUID", 101, 3531, 4092);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 102, 3802, 3823);
            for (int i = 0; i < (CallChecker.isCalled(iPredicates, Predicate[].class, 103, 3853, 3863).length); i++) {
                if (CallChecker.beforeDeref(iPredicates, Predicate[].class, 104, 3896, 3906)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iPredicates, Predicate[].class, 104, 3896, 3906)[i], Predicate.class, 104, 3896, 3909)) {
                        CallChecker.isCalled(iPredicates, Predicate[].class, 104, 3896, 3906)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 104, 3896, 3906)[i], Predicate.class, 104, 3896, 3909);
                        if (CallChecker.isCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 104, 3896, 3906)[i], Predicate.class, 104, 3896, 3909).evaluate(object)) {
                            if (match) {
                                return false;
                            }
                            match = true;
                            CallChecker.varAssign(match, "match", 108, 4028, 4040);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return match;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context778.methodEnd();
        }
    }

    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context779 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 120, 4099, 4324);
            CallChecker.varInit(this.iPredicates, "iPredicates", 120, 4099, 4324);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.OnePredicate.serialVersionUID", 120, 4099, 4324);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context779.methodEnd();
        }
    }
}

