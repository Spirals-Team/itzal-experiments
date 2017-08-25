package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class AnyPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    private final Predicate<? super T>[] iPredicates;

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> getInstance(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context747 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 58, 1710, 2613);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AnyPredicate.serialVersionUID", 58, 1710, 2613);
            FunctorUtils.validate(predicates);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 60, 2354, 2363)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 60, 2354, 2363);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 60, 2354, 2363).length) == 0) {
                    return FalsePredicate.<T>falsePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 63, 2457, 2466)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 63, 2457, 2466);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 63, 2457, 2466).length) == 1) {
                    if (CallChecker.beforeDeref(predicates, Predicate[].class, 64, 2517, 2526)) {
                        predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 64, 2517, 2526);
                        return ((Predicate<T>) (CallChecker.isCalled(predicates, Predicate[].class, 64, 2517, 2526)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return new AnyPredicate<T>(FunctorUtils.copy(predicates));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context747.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> getInstance(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context748 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 81, 2620, 3537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AnyPredicate.serialVersionUID", 81, 2620, 3537);
            Predicate<? super T>[] preds = CallChecker.varInit(FunctorUtils.validate(predicates), "preds", 82, 3239, 3303);
            if (CallChecker.beforeDeref(preds, Predicate[].class, 83, 3317, 3321)) {
                preds = CallChecker.beforeCalled(preds, Predicate[].class, 83, 3317, 3321);
                if ((CallChecker.isCalled(preds, Predicate[].class, 83, 3317, 3321).length) == 0) {
                    return FalsePredicate.<T>falsePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(preds, Predicate[].class, 86, 3415, 3419)) {
                preds = CallChecker.beforeCalled(preds, Predicate[].class, 86, 3415, 3419);
                if ((CallChecker.isCalled(preds, Predicate[].class, 86, 3415, 3419).length) == 1) {
                    if (CallChecker.beforeDeref(preds, Predicate[].class, 87, 3470, 3474)) {
                        preds = CallChecker.beforeCalled(preds, Predicate[].class, 87, 3470, 3474);
                        return ((Predicate<T>) (CallChecker.isCalled(preds, Predicate[].class, 87, 3470, 3474)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return new AnyPredicate<T>(preds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context748.methodEnd();
        }
    }

    public AnyPredicate(Predicate<? super T>[] predicates) {
        super();
        MethodContext _bcornu_methode_context135 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 100, 3823, 3847);
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context749 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 109, 3860, 4279);
            CallChecker.varInit(object, "object", 109, 3860, 4279);
            CallChecker.varInit(this.iPredicates, "iPredicates", 109, 3860, 4279);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AnyPredicate.serialVersionUID", 109, 3860, 4279);
            for (int i = 0; i < (CallChecker.isCalled(iPredicates, Predicate[].class, 110, 4122, 4132).length); i++) {
                if (CallChecker.beforeDeref(iPredicates, Predicate[].class, 111, 4165, 4175)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iPredicates, Predicate[].class, 111, 4165, 4175)[i], Predicate.class, 111, 4165, 4178)) {
                        CallChecker.isCalled(iPredicates, Predicate[].class, 111, 4165, 4175)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 111, 4165, 4175)[i], Predicate.class, 111, 4165, 4178);
                        if (CallChecker.isCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 111, 4165, 4175)[i], Predicate.class, 111, 4165, 4178).evaluate(object)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context749.methodEnd();
        }
    }

    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context750 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 124, 4286, 4510);
            CallChecker.varInit(this.iPredicates, "iPredicates", 124, 4286, 4510);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AnyPredicate.serialVersionUID", 124, 4286, 4510);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context750.methodEnd();
        }
    }
}

