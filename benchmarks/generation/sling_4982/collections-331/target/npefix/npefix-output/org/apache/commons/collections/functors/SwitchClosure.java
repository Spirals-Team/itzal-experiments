package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Predicate;
import java.io.Serializable;

public class SwitchClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;

    private final Predicate<? super E>[] iPredicates;

    private final Closure<? super E>[] iClosures;

    private final Closure<? super E> iDefault;

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance(Predicate<? super E>[] predicates, Closure<? super E>[] closures, Closure<? super E> defaultClosure) {
        MethodContext _bcornu_methode_context2135 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(defaultClosure, "defaultClosure", 57, 1729, 2985);
            CallChecker.varInit(closures, "closures", 57, 1729, 2985);
            CallChecker.varInit(predicates, "predicates", 57, 1729, 2985);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 57, 1729, 2985);
            FunctorUtils.validate(predicates);
            FunctorUtils.validate(closures);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 60, 2498, 2507)) {
                if (CallChecker.beforeDeref(closures, Closure[].class, 60, 2519, 2526)) {
                    predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 60, 2498, 2507);
                    closures = CallChecker.beforeCalled(closures, Closure[].class, 60, 2519, 2526);
                    if ((CallChecker.isCalled(predicates, Predicate[].class, 60, 2498, 2507).length) != (CallChecker.isCalled(closures, Closure[].class, 60, 2519, 2526).length)) {
                        throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 63, 2666, 2675)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 63, 2666, 2675);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 63, 2666, 2675).length) == 0) {
                    if (defaultClosure == null) {
                        return ((Closure<E>) (NOPClosure.<E>getInstance()));
                    }else {
                        return ((Closure<E>) (defaultClosure));
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            predicates = FunctorUtils.copy(predicates);
            CallChecker.varAssign(predicates, "predicates", 66, 2814, 2856);
            closures = FunctorUtils.copy(closures);
            CallChecker.varAssign(closures, "closures", 67, 2866, 2904);
            return new SwitchClosure<E>(predicates, closures, defaultClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2135.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance(Map<Predicate<E>, Closure<E>> predicatesAndClosures) {
        MethodContext _bcornu_methode_context2136 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(predicatesAndClosures, "predicatesAndClosures", 89, 2992, 4885);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 89, 2992, 4885);
            if (predicatesAndClosures == null) {
                throw new IllegalArgumentException("The predicate and closure map must not be null");
            }
            Closure<? super E> defaultClosure = CallChecker.varInit(predicatesAndClosures.remove(null), "defaultClosure", 94, 4225, 4295);
            int size = CallChecker.varInit(((int) (predicatesAndClosures.size())), "size", 95, 4305, 4344);
            if (size == 0) {
                if (defaultClosure == null) {
                    return ((Closure<E>) (NOPClosure.<E>getInstance()));
                }else {
                    return ((Closure<E>) (defaultClosure));
                }
            }
            Closure<E>[] closures = CallChecker.varInit(new Closure[size], "closures", 99, 4494, 4535);
            Predicate<E>[] preds = CallChecker.varInit(new Predicate[size], "preds", 100, 4545, 4587);
            int i = CallChecker.varInit(((int) (0)), "i", 101, 4597, 4606);
            for (Map.Entry<Predicate<E>, Closure<E>> entry : predicatesAndClosures.entrySet()) {
                if (CallChecker.beforeDeref(preds, Predicate[].class, 103, 4713, 4717)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 103, 4724, 4728)) {
                        preds = CallChecker.beforeCalled(preds, Predicate[].class, 103, 4713, 4717);
                        CallChecker.isCalled(preds, Predicate[].class, 103, 4713, 4717)[i] = CallChecker.isCalled(entry, Map.Entry.class, 103, 4724, 4728).getKey();
                        CallChecker.varAssign(CallChecker.isCalled(preds, Predicate[].class, 103, 4713, 4717)[i], "CallChecker.isCalled(preds, Predicate[].class, 103, 4713, 4717)[i]", 103, 4713, 4738);
                    }
                }
                if (CallChecker.beforeDeref(closures, Closure[].class, 104, 4752, 4759)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 104, 4766, 4770)) {
                        closures = CallChecker.beforeCalled(closures, Closure[].class, 104, 4752, 4759);
                        CallChecker.isCalled(closures, Closure[].class, 104, 4752, 4759)[i] = CallChecker.isCalled(entry, Map.Entry.class, 104, 4766, 4770).getValue();
                        CallChecker.varAssign(CallChecker.isCalled(closures, Closure[].class, 104, 4752, 4759)[i], "CallChecker.isCalled(closures, Closure[].class, 104, 4752, 4759)[i]", 104, 4752, 4782);
                    }
                }
                i++;
            }
            return new SwitchClosure<E>(preds, closures, defaultClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2136.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public SwitchClosure(Predicate<? super E>[] predicates, Closure<? super E>[] closures, Closure<? super E> defaultClosure) {
        super();
        MethodContext _bcornu_methode_context407 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 121, 5419, 5443);
            iClosures = closures;
            CallChecker.varAssign(this.iClosures, "this.iClosures", 122, 5453, 5473);
            if (defaultClosure == null) {
                iDefault = ((Closure<? super E>) (NOPClosure.<E>getInstance()));
                CallChecker.varAssign(this.iDefault, "this.iDefault", 123, 5483, 5586);
            }else {
                iDefault = ((Closure<? super E>) (defaultClosure));
                CallChecker.varAssign(this.iDefault, "this.iDefault", 123, 5483, 5586);
            }
        } finally {
            _bcornu_methode_context407.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context2137 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 131, 5599, 6000);
            CallChecker.varInit(input, "input", 131, 5599, 6000);
            CallChecker.varInit(this.iDefault, "iDefault", 131, 5599, 6000);
            CallChecker.varInit(this.iClosures, "iClosures", 131, 5599, 6000);
            CallChecker.varInit(this.iPredicates, "iPredicates", 131, 5599, 6000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 131, 5599, 6000);
            for (int i = 0; i < (CallChecker.isCalled(iPredicates, Predicate[].class, 132, 5785, 5795).length); i++) {
                if (CallChecker.beforeDeref(iPredicates, Predicate[].class, 133, 5828, 5838)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iPredicates, Predicate[].class, 133, 5828, 5838)[i], Predicate.class, 133, 5828, 5841)) {
                        CallChecker.isCalled(iPredicates, Predicate[].class, 133, 5828, 5838)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 133, 5828, 5838)[i], Predicate.class, 133, 5828, 5841);
                        if ((CallChecker.isCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 133, 5828, 5838)[i], Predicate.class, 133, 5828, 5841).evaluate(input)) == true) {
                            if (CallChecker.beforeDeref(iClosures, Closure[].class, 134, 5886, 5894)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(iClosures, Closure[].class, 134, 5886, 5894)[i], Closure.class, 134, 5886, 5897)) {
                                    CallChecker.isCalled(iClosures, Closure[].class, 134, 5886, 5894)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iClosures, Closure[].class, 134, 5886, 5894)[i], Closure.class, 134, 5886, 5897);
                                    CallChecker.isCalled(CallChecker.isCalled(iClosures, Closure[].class, 134, 5886, 5894)[i], Closure.class, 134, 5886, 5897).execute(input);
                                }
                            }
                            return ;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(iDefault, Closure.class, 138, 5971, 5978)) {
                CallChecker.isCalled(iDefault, Closure.class, 138, 5971, 5978).execute(input);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2137.methodEnd();
        }
    }

    public Predicate<? super E>[] getPredicates() {
        MethodContext _bcornu_methode_context2138 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 147, 6007, 6231);
            CallChecker.varInit(this.iDefault, "iDefault", 147, 6007, 6231);
            CallChecker.varInit(this.iClosures, "iClosures", 147, 6007, 6231);
            CallChecker.varInit(this.iPredicates, "iPredicates", 147, 6007, 6231);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 147, 6007, 6231);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2138.methodEnd();
        }
    }

    public Closure<? super E>[] getClosures() {
        MethodContext _bcornu_methode_context2139 = new MethodContext(Closure[].class);
        try {
            CallChecker.varInit(this, "this", 157, 6238, 6452);
            CallChecker.varInit(this.iDefault, "iDefault", 157, 6238, 6452);
            CallChecker.varInit(this.iClosures, "iClosures", 157, 6238, 6452);
            CallChecker.varInit(this.iPredicates, "iPredicates", 157, 6238, 6452);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 157, 6238, 6452);
            return iClosures;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2139.methodEnd();
        }
    }

    public Closure<? super E> getDefaultClosure() {
        MethodContext _bcornu_methode_context2140 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 167, 6459, 6665);
            CallChecker.varInit(this.iDefault, "iDefault", 167, 6459, 6665);
            CallChecker.varInit(this.iClosures, "iClosures", 167, 6459, 6665);
            CallChecker.varInit(this.iPredicates, "iPredicates", 167, 6459, 6665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchClosure.serialVersionUID", 167, 6459, 6665);
            return iDefault;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2140.methodEnd();
        }
    }
}

