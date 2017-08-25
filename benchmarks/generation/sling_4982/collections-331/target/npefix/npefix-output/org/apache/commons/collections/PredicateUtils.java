package org.apache.commons.collections;

import org.apache.commons.collections.functors.UniquePredicate;
import org.apache.commons.collections.functors.TruePredicate;
import org.apache.commons.collections.functors.TransformerPredicate;
import org.apache.commons.collections.functors.TransformedPredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.apache.commons.collections.functors.OnePredicate;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.functors.FalsePredicate;
import org.apache.commons.collections.functors.ExceptionPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.functors.AnyPredicate;
import org.apache.commons.collections.functors.AndPredicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.IdentityPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.InvokerTransformer;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.functors.NonePredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.collections.functors.NotPredicate;
import org.apache.commons.collections.functors.NullIsExceptionPredicate;
import org.apache.commons.collections.functors.NullIsFalsePredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.apache.commons.collections.functors.NullPredicate;

public class PredicateUtils {
    public PredicateUtils() {
        super();
        MethodContext _bcornu_methode_context113 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public static <T> Predicate<T> exceptionPredicate() {
        MethodContext _bcornu_methode_context609 = new MethodContext(Predicate.class);
        try {
            return ExceptionPredicate.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context609.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> truePredicate() {
        MethodContext _bcornu_methode_context610 = new MethodContext(Predicate.class);
        try {
            return TruePredicate.truePredicate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context610.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> falsePredicate() {
        MethodContext _bcornu_methode_context611 = new MethodContext(Predicate.class);
        try {
            return FalsePredicate.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context611.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> nullPredicate() {
        MethodContext _bcornu_methode_context612 = new MethodContext(Predicate.class);
        try {
            return NullPredicate.nullPredicate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context612.methodEnd();
        }
    }

    public static <T> Predicate<T> notNullPredicate() {
        MethodContext _bcornu_methode_context613 = new MethodContext(Predicate.class);
        try {
            return NotNullPredicate.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context613.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> equalPredicate(T value) {
        MethodContext _bcornu_methode_context614 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(value, "value", 160, 5796, 6295);
            return EqualPredicate.equalPredicate(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context614.methodEnd();
        }
    }

    public static <T> Predicate<T> identityPredicate(T value) {
        MethodContext _bcornu_methode_context615 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(value, "value", 173, 6302, 6713);
            return IdentityPredicate.<T>getInstance(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context615.methodEnd();
        }
    }

    public static Predicate<Object> instanceofPredicate(Class<?> type) {
        MethodContext _bcornu_methode_context616 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(type, "type", 188, 6720, 7283);
            return InstanceofPredicate.getInstance(type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context616.methodEnd();
        }
    }

    public static <T> Predicate<T> uniquePredicate() {
        MethodContext _bcornu_methode_context617 = new MethodContext(Predicate.class);
        try {
            return UniquePredicate.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context617.methodEnd();
        }
    }

    public static <T> Predicate<T> invokerPredicate(String methodName) {
        MethodContext _bcornu_methode_context618 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(methodName, "methodName", 225, 7881, 8936);
            return PredicateUtils.asPredicate(InvokerTransformer.<Object, Boolean>getInstance(methodName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context618.methodEnd();
        }
    }

    public static <T> Predicate<T> invokerPredicate(String methodName, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context619 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(args, "args", 250, 8943, 10213);
            CallChecker.varInit(paramTypes, "paramTypes", 250, 8943, 10213);
            CallChecker.varInit(methodName, "methodName", 250, 8943, 10213);
            return PredicateUtils.asPredicate(InvokerTransformer.<Object, Boolean>getInstance(methodName, paramTypes, args));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context619.methodEnd();
        }
    }

    public static <T> Predicate<T> andPredicate(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        MethodContext _bcornu_methode_context620 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate2, "predicate2", 269, 10220, 10959);
            CallChecker.varInit(predicate1, "predicate1", 269, 10220, 10959);
            return AndPredicate.<T>getInstance(predicate1, predicate2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context620.methodEnd();
        }
    }

    @Deprecated
    public static <T> Predicate<T> allPredicate(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context621 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 287, 10966, 11750);
            return AllPredicate.allPredicate(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context621.methodEnd();
        }
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context622 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 303, 11757, 12522);
            return AllPredicate.allPredicate(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context622.methodEnd();
        }
    }

    public static <T> Predicate<T> orPredicate(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        MethodContext _bcornu_methode_context623 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate2, "predicate2", 318, 12529, 13148);
            CallChecker.varInit(predicate1, "predicate1", 318, 12529, 13148);
            return OrPredicate.<T>getInstance(predicate1, predicate2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context623.methodEnd();
        }
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context624 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 334, 13155, 13838);
            return AnyPredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context624.methodEnd();
        }
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context625 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 350, 13845, 14605);
            return AnyPredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context625.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> eitherPredicate(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        MethodContext _bcornu_methode_context626 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate2, "predicate2", 366, 14612, 15297);
            CallChecker.varInit(predicate1, "predicate1", 366, 14612, 15297);
            return PredicateUtils.onePredicate(new Predicate[]{ predicate1 , predicate2 });
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context626.methodEnd();
        }
    }

    public static <T> Predicate<T> onePredicate(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context627 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 382, 15304, 15992);
            return OnePredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context627.methodEnd();
        }
    }

    public static <T> Predicate<T> onePredicate(Collection<Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context628 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 398, 15999, 16754);
            return OnePredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context628.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Predicate<T> neitherPredicate(Predicate<? super T> predicate1, Predicate<? super T> predicate2) {
        MethodContext _bcornu_methode_context629 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate2, "predicate2", 414, 16761, 17435);
            CallChecker.varInit(predicate1, "predicate1", 414, 16761, 17435);
            return PredicateUtils.nonePredicate(new Predicate[]{ predicate1 , predicate2 });
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context629.methodEnd();
        }
    }

    public static <T> Predicate<T> nonePredicate(Predicate<? super T>[] predicates) {
        MethodContext _bcornu_methode_context630 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 430, 17442, 18129);
            return NonePredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context630.methodEnd();
        }
    }

    public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<T>> predicates) {
        MethodContext _bcornu_methode_context631 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicates, "predicates", 446, 18136, 18900);
            return NonePredicate.getInstance(predicates);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context631.methodEnd();
        }
    }

    public static <T> Predicate<T> notPredicate(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context632 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 460, 18907, 19405);
            return NotPredicate.getInstance(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context632.methodEnd();
        }
    }

    public static <T> Predicate<T> asPredicate(Transformer<? super T, Boolean> transformer) {
        MethodContext _bcornu_methode_context633 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(transformer, "transformer", 478, 19412, 20139);
            return TransformerPredicate.getInstance(transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context633.methodEnd();
        }
    }

    public static <T> Predicate<T> nullIsExceptionPredicate(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context634 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 496, 20146, 20899);
            return NullIsExceptionPredicate.getInstance(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context634.methodEnd();
        }
    }

    public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context635 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 511, 20906, 21535);
            return NullIsFalsePredicate.getInstance(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context635.methodEnd();
        }
    }

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context636 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 526, 21542, 22167);
            return NullIsTruePredicate.getInstance(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context636.methodEnd();
        }
    }

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context637 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(predicate, "predicate", 544, 22174, 22993);
            CallChecker.varInit(transformer, "transformer", 544, 22174, 22993);
            return TransformedPredicate.<T>getInstance(transformer, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context637.methodEnd();
        }
    }
}

