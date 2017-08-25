package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class AllPredicate<T> implements Serializable , Predicate<T> , PredicateDecorator<T> {
    private static final long serialVersionUID = -3094696765038308799L;

    private final Predicate<? super T>[] iPredicates;

    @Deprecated
    public static <T> Predicate<T> getInstance(Predicate<? super T>... predicates) {
        MethodContext _bcornu_methode_context575 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 64, 1977, 2660);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 64, 1977, 2660);
            return AllPredicate.allPredicate(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context575.methodEnd();
        }
    }

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicates) {
        MethodContext _bcornu_methode_context576 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 79, 2667, 3512);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 79, 2667, 3512);
            FunctorUtils.validate(predicates);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 81, 3278, 3287)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 81, 3278, 3287);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 81, 3278, 3287).length) == 0) {
                    return TruePredicate.truePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 84, 3362, 3371)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 84, 3362, 3371);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 84, 3362, 3371).length) == 1) {
                    if (CallChecker.beforeDeref(predicates, Predicate[].class, 85, 3414, 3423)) {
                        predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 85, 3414, 3423);
                        return FunctorUtils.coerce(CallChecker.isCalled(predicates, Predicate[].class, 85, 3414, 3423)[0]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return new AllPredicate<T>(FunctorUtils.copy(predicates));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context576.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> getInstance(Collection<Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context577 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 104, 3519, 4210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 104, 3519, 4210);
            return AllPredicate.allPredicate(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context577.methodEnd();
        }
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context578 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 119, 4217, 5050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 119, 4217, 5050);
            final Predicate<T>[] preds = CallChecker.varInit(FunctorUtils.validate(predicates), "preds", 120, 4801, 4850);
            if (CallChecker.beforeDeref(preds, Predicate[].class, 121, 4864, 4868)) {
                if ((CallChecker.isCalled(preds, Predicate[].class, 121, 4864, 4868).length) == 0) {
                    return TruePredicate.truePredicate();
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(preds, Predicate[].class, 124, 4943, 4947)) {
                if ((CallChecker.isCalled(preds, Predicate[].class, 124, 4943, 4947).length) == 1) {
                    if (CallChecker.beforeDeref(preds, Predicate[].class, 125, 4983, 4987)) {
                        return CallChecker.isCalled(preds, Predicate[].class, 125, 4983, 4987)[0];
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return new AllPredicate<T>(preds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context578.methodEnd();
        }
    }

    public AllPredicate(Predicate<? super T>... predicates) {
        super();
        MethodContext _bcornu_methode_context105 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 138, 5338, 5362);
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public boolean evaluate(T object) {
        MethodContext _bcornu_methode_context579 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 147, 5375, 5800);
            CallChecker.varInit(object, "object", 147, 5375, 5800);
            CallChecker.varInit(this.iPredicates, "iPredicates", 147, 5375, 5800);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 147, 5375, 5800);
            if (CallChecker.beforeDeref(iPredicates, boolean.class, 148, 5658, 5668)) {
                for (Predicate<? super T> iPredicate : iPredicates) {
                    if (CallChecker.beforeDeref(iPredicate, Predicate.class, 149, 5690, 5699)) {
                        if (!(CallChecker.isCalled(iPredicate, Predicate.class, 149, 5690, 5699).evaluate(object))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context579.methodEnd();
        }
    }

    public Predicate<? super T>[] getPredicates() {
        MethodContext _bcornu_methode_context580 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 162, 5807, 6032);
            CallChecker.varInit(this.iPredicates, "iPredicates", 162, 5807, 6032);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.AllPredicate.serialVersionUID", 162, 5807, 6032);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context580.methodEnd();
        }
    }
}

