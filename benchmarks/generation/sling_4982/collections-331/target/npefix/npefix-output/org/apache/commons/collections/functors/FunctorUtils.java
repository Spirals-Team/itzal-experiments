package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Closure;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Predicate;

class FunctorUtils {
    private FunctorUtils() {
        super();
        MethodContext _bcornu_methode_context359 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context359.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <T> Predicate<T>[] copy(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context1826 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(predicates, "predicates", 52, 1383, 1954);
            if (predicates == null) {
                return null;
            }
            return ((Predicate<T>[]) (predicates.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1826.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1827 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 72, 1961, 2637);
            return ((Predicate<T>) (predicate));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1827.methodEnd();
        }
    }

    static void validate(Predicate<?>[] predicates) {
        MethodContext _bcornu_methode_context1828 = new MethodContext(void.class);
        try {
            CallChecker.varInit(predicates, "predicates", 81, 2644, 3219);
            if (predicates == null) {
                throw new IllegalArgumentException("The predicate array must not be null");
            }
            for (int i = 0; i < (predicates.length); i++) {
                if ((predicates[i]) == null) {
                    throw new IllegalArgumentException((("The predicate array must not contain a null predicate, index " + i) + " was null"));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1828.methodEnd();
        }
    }

    static <T> Predicate<T>[] validate(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context1829 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(predicates, "predicates", 98, 3226, 4142);
            if (predicates == null) {
                throw new IllegalArgumentException("The predicate collection must not be null");
            }
            @SuppressWarnings(value = "unchecked")
            Predicate<T>[] preds = CallChecker.varInit(new Predicate[predicates.size()], "preds", 104, 3692, 3792);
            int i = CallChecker.varInit(((int) (0)), "i", 105, 3802, 3811);
            for (Predicate<T> predicate : predicates) {
                if (CallChecker.beforeDeref(preds, Predicate[].class, 107, 3877, 3881)) {
                    preds = CallChecker.beforeCalled(preds, Predicate[].class, 107, 3877, 3881);
                    CallChecker.isCalled(preds, Predicate[].class, 107, 3877, 3881)[i] = predicate;
                    CallChecker.varAssign(CallChecker.isCalled(preds, Predicate[].class, 107, 3877, 3881)[i], "CallChecker.isCalled(preds, Predicate[].class, 107, 3877, 3881)[i]", 107, 3877, 3897);
                }
                if (CallChecker.beforeDeref(preds, Predicate[].class, 108, 3915, 3919)) {
                    preds = CallChecker.beforeCalled(preds, Predicate[].class, 108, 3915, 3919);
                    if ((CallChecker.isCalled(preds, Predicate[].class, 108, 3915, 3919)[i]) == null) {
                        throw new IllegalArgumentException((("The predicate collection must not contain a null predicate, index " + i) + " was null"));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                i++;
            }
            return preds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1829.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <E> Closure<E>[] copy(Closure<? super E>[] closures) {
        MethodContext _bcornu_methode_context1830 = new MethodContext(Closure[].class);
        try {
            CallChecker.varInit(closures, "closures", 123, 4149, 4554);
            if (closures == null) {
                return null;
            }
            return ((Closure<E>[]) (closures.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1830.methodEnd();
        }
    }

    static void validate(Closure<?>[] closures) {
        MethodContext _bcornu_methode_context1831 = new MethodContext(void.class);
        try {
            CallChecker.varInit(closures, "closures", 135, 4561, 5114);
            if (closures == null) {
                throw new IllegalArgumentException("The closure array must not be null");
            }
            for (int i = 0; i < (closures.length); i++) {
                if ((closures[i]) == null) {
                    throw new IllegalArgumentException((("The closure array must not contain a null closure, index " + i) + " was null"));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1831.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <T> Closure<T> coerce(Closure<? super T> closure) {
        MethodContext _bcornu_methode_context1832 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure, "closure", 157, 5121, 5629);
            return ((Closure<T>) (closure));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1832.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>[] transformers) {
        MethodContext _bcornu_methode_context1833 = new MethodContext(Transformer[].class);
        try {
            CallChecker.varInit(transformers, "transformers", 168, 5636, 6036);
            if (transformers == null) {
                return null;
            }
            return ((Transformer<I, O>[]) (transformers.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1833.methodEnd();
        }
    }

    static void validate(Transformer<?, ?>[] transformers) {
        MethodContext _bcornu_methode_context1834 = new MethodContext(void.class);
        try {
            CallChecker.varInit(transformers, "transformers", 180, 6043, 6626);
            if (transformers == null) {
                throw new IllegalArgumentException("The transformer array must not be null");
            }
            for (int i = 0; i < (transformers.length); i++) {
                if ((transformers[i]) == null) {
                    throw new IllegalArgumentException((("The transformer array must not contain a null transformer, index " + i) + " was null"));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1834.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        MethodContext _bcornu_methode_context1835 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformer, "transformer", 203, 6633, 7224);
            return ((Transformer<I, O>) (transformer));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1835.methodEnd();
        }
    }
}

