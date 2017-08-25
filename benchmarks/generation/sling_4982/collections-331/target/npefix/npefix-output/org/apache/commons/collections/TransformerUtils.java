package org.apache.commons.collections;

import org.apache.commons.collections.functors.SwitchTransformer;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.functors.FactoryTransformer;
import org.apache.commons.collections.functors.ExceptionTransformer;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.ConstantTransformer;
import java.util.Collection;
import org.apache.commons.collections.functors.ClosureTransformer;
import org.apache.commons.collections.functors.CloneTransformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import java.util.Map;
import org.apache.commons.collections.functors.MapTransformer;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.functors.NOPTransformer;
import org.apache.commons.collections.functors.PredicateTransformer;
import org.apache.commons.collections.functors.StringValueTransformer;

public class TransformerUtils {
    public TransformerUtils() {
        super();
        MethodContext _bcornu_methode_context459 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context459.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        MethodContext _bcornu_methode_context2407 = new MethodContext(Transformer.class);
        try {
            return ExceptionTransformer.<I, O>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2407.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        MethodContext _bcornu_methode_context2408 = new MethodContext(Transformer.class);
        try {
            return ConstantTransformer.<I, O>getNullInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2408.methodEnd();
        }
    }

    public static <T> Transformer<T, T> nopTransformer() {
        MethodContext _bcornu_methode_context2409 = new MethodContext(Transformer.class);
        try {
            return NOPTransformer.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2409.methodEnd();
        }
    }

    public static <T> Transformer<T, T> cloneTransformer() {
        MethodContext _bcornu_methode_context2410 = new MethodContext(Transformer.class);
        try {
            return CloneTransformer.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2410.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> constantTransformer(O constantToReturn) {
        MethodContext _bcornu_methode_context2411 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(constantToReturn, "constantToReturn", 137, 4962, 5444);
            return ConstantTransformer.getInstance(constantToReturn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2411.methodEnd();
        }
    }

    public static <T> Transformer<T, T> asTransformer(Closure<? super T> closure) {
        MethodContext _bcornu_methode_context2412 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(closure, "closure", 151, 5451, 6002);
            return ClosureTransformer.getInstance(closure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2412.methodEnd();
        }
    }

    public static <T> Transformer<T, Boolean> asTransformer(Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context2413 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(predicate, "predicate", 165, 6009, 6608);
            return PredicateTransformer.getInstance(predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, Boolean>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2413.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> asTransformer(Factory<? extends O> factory) {
        MethodContext _bcornu_methode_context2414 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(factory, "factory", 179, 6615, 7192);
            return FactoryTransformer.getInstance(factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2414.methodEnd();
        }
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T> transformer1, Transformer<? super T, ? extends T> transformer2) {
        MethodContext _bcornu_methode_context2415 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformer2, "transformer2", 194, 7199, 7885);
            CallChecker.varInit(transformer1, "transformer1", 194, 7199, 7885);
            return ChainedTransformer.<T>getInstance(transformer1, transformer2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2415.methodEnd();
        }
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>[] transformers) {
        MethodContext _bcornu_methode_context2416 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformers, "transformers", 211, 7892, 8539);
            return ChainedTransformer.getInstance(transformers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2416.methodEnd();
        }
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<T, T>> transformers) {
        MethodContext _bcornu_methode_context2417 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformers, "transformers", 227, 8546, 9294);
            return ChainedTransformer.getInstance(transformers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2417.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> trueTransformer, Transformer<? super I, ? extends O> falseTransformer) {
        MethodContext _bcornu_methode_context2418 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(falseTransformer, "falseTransformer", 246, 9301, 10305);
            CallChecker.varInit(trueTransformer, "trueTransformer", 246, 9301, 10305);
            CallChecker.varInit(predicate, "predicate", 246, 9301, 10305);
            return SwitchTransformer.getInstance(new Predicate[]{ predicate }, new Transformer[]{ trueTransformer }, falseTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2418.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicates, Transformer<? super I, ? extends O>[] transformers) {
        MethodContext _bcornu_methode_context2419 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(transformers, "transformers", 269, 10312, 11425);
            CallChecker.varInit(predicates, "predicates", 269, 10312, 11425);
            return SwitchTransformer.<I, O>getInstance(predicates, transformers, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2419.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicates, Transformer<? super I, ? extends O>[] transformers, Transformer<? super I, ? extends O> defaultTransformer) {
        MethodContext _bcornu_methode_context2420 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(defaultTransformer, "defaultTransformer", 292, 11432, 12807);
            CallChecker.varInit(transformers, "transformers", 292, 11432, 12807);
            CallChecker.varInit(predicates, "predicates", 292, 11432, 12807);
            return SwitchTransformer.<I, O>getInstance(predicates, transformers, defaultTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2420.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<Predicate<I>, Transformer<I, O>> predicatesAndTransformers) {
        MethodContext _bcornu_methode_context2421 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(predicatesAndTransformers, "predicatesAndTransformers", 319, 12814, 14149);
            return SwitchTransformer.<I, O>getInstance(predicatesAndTransformers);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2421.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> switchMapTransformer(Map<I, Transformer<I, O>> objectsAndTransformers) {
        MethodContext _bcornu_methode_context2422 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(objectsAndTransformers, "objectsAndTransformers", 342, 14156, 15921);
            Transformer<? super I, ? extends O>[] trs = CallChecker.varInit(null, "trs", 343, 15157, 15205);
            Predicate<I>[] preds = CallChecker.varInit(null, "preds", 344, 15215, 15242);
            if (objectsAndTransformers == null) {
                throw new IllegalArgumentException("The object and transformer map must not be null");
            }
            Transformer<? super I, ? extends O> def = CallChecker.varInit(objectsAndTransformers.remove(null), "def", 348, 15407, 15484);
            int size = CallChecker.varInit(((int) (objectsAndTransformers.size())), "size", 349, 15494, 15534);
            trs = new Transformer[size];
            CallChecker.varAssign(trs, "trs", 350, 15544, 15571);
            preds = new Predicate[size];
            CallChecker.varAssign(preds, "preds", 351, 15581, 15608);
            int i = CallChecker.varInit(((int) (0)), "i", 352, 15618, 15627);
            for (Map.Entry<I, Transformer<I, O>> entry : objectsAndTransformers.entrySet()) {
                if (CallChecker.beforeDeref(preds, Predicate[].class, 354, 15731, 15735)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 354, 15775, 15779)) {
                        preds = CallChecker.beforeCalled(preds, Predicate[].class, 354, 15731, 15735);
                        CallChecker.isCalled(preds, Predicate[].class, 354, 15731, 15735)[i] = EqualPredicate.<I>equalPredicate(entry.getKey());
                        CallChecker.varAssign(CallChecker.isCalled(preds, Predicate[].class, 354, 15731, 15735)[i], "CallChecker.isCalled(preds, Predicate[].class, 354, 15731, 15735)[i]", 354, 15731, 15790);
                    }
                }
                if (CallChecker.beforeDeref(trs, Transformer[].class, 355, 15804, 15806)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 355, 15815, 15819)) {
                        trs = CallChecker.beforeCalled(trs, Transformer[].class, 355, 15804, 15806);
                        CallChecker.isCalled(trs, Transformer[].class, 355, 15804, 15806)[(i++)] = CallChecker.isCalled(entry, Map.Entry.class, 355, 15815, 15819).getValue();
                        CallChecker.varAssign(CallChecker.isCalled(trs, Transformer[].class, 355, 15804, 15806)[(i - 1)], "CallChecker.isCalled(trs, Transformer[].class, 355, 15804, 15806)[(i - 1)]", 355, 15804, 15831);
                    }
                }
            }
            return TransformerUtils.<I, O>switchTransformer(preds, trs, def);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2422.methodEnd();
        }
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
        MethodContext _bcornu_methode_context2423 = new MethodContext(Transformer.class);
        try {
            return InstantiateTransformer.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<Class<? extends T>, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2423.methodEnd();
        }
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context2424 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(args, "args", 383, 16300, 17054);
            CallChecker.varInit(paramTypes, "paramTypes", 383, 16300, 17054);
            return InstantiateTransformer.<T>getInstance(paramTypes, args);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<Class<? extends T>, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2424.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        MethodContext _bcornu_methode_context2425 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(map, "map", 398, 17061, 17567);
            return MapTransformer.getInstance(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2425.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String methodName) {
        MethodContext _bcornu_methode_context2426 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(methodName, "methodName", 417, 17574, 18393);
            return InvokerTransformer.<I, O>getInstance(methodName, null, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2426.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String methodName, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context2427 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(args, "args", 435, 18400, 19180);
            CallChecker.varInit(paramTypes, "paramTypes", 435, 18400, 19180);
            CallChecker.varInit(methodName, "methodName", 435, 18400, 19180);
            return InvokerTransformer.<I, O>getInstance(methodName, paramTypes, args);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2427.methodEnd();
        }
    }

    public static <T> Transformer<T, String> stringValueTransformer() {
        MethodContext _bcornu_methode_context2428 = new MethodContext(Transformer.class);
        try {
            return StringValueTransformer.<T>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<T, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2428.methodEnd();
        }
    }
}

