package org.apache.commons.collections;

import org.apache.commons.collections.functors.WhileClosure;
import org.apache.commons.collections.functors.TransformerClosure;
import org.apache.commons.collections.functors.SwitchClosure;
import org.apache.commons.collections.functors.NOPClosure;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.functors.ChainedClosure;
import java.util.Collection;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.ExceptionClosure;
import org.apache.commons.collections.functors.ForClosure;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.functors.IfClosure;
import org.apache.commons.collections.functors.InvokerTransformer;
import java.util.Map;

public class ClosureUtils {
    public ClosureUtils() {
        super();
        MethodContext _bcornu_methode_context50 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public static <E> Closure<E> exceptionClosure() {
        MethodContext _bcornu_methode_context322 = new MethodContext(Closure.class);
        try {
            return ExceptionClosure.<E>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context322.methodEnd();
        }
    }

    public static <E> Closure<E> nopClosure() {
        MethodContext _bcornu_methode_context323 = new MethodContext(Closure.class);
        try {
            return NOPClosure.<E>getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context323.methodEnd();
        }
    }

    public static <E> Closure<E> asClosure(Transformer<? super E, ?> transformer) {
        MethodContext _bcornu_methode_context324 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(transformer, "transformer", 99, 3310, 3869);
            return TransformerClosure.getInstance(transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context324.methodEnd();
        }
    }

    public static <E> Closure<E> forClosure(int count, Closure<? super E> closure) {
        MethodContext _bcornu_methode_context325 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure, "closure", 114, 3876, 4419);
            CallChecker.varInit(count, "count", 114, 3876, 4419);
            return ForClosure.getInstance(count, closure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context325.methodEnd();
        }
    }

    public static <E> Closure<E> whileClosure(Predicate<? super E> predicate, Closure<? super E> closure) {
        MethodContext _bcornu_methode_context326 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure, "closure", 129, 4426, 5063);
            CallChecker.varInit(predicate, "predicate", 129, 4426, 5063);
            return WhileClosure.<E>getInstance(predicate, closure, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context326.methodEnd();
        }
    }

    public static <E> Closure<E> doWhileClosure(Closure<? super E> closure, Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context327 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(predicate, "predicate", 144, 5070, 5724);
            CallChecker.varInit(closure, "closure", 144, 5070, 5724);
            return WhileClosure.<E>getInstance(predicate, closure, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context327.methodEnd();
        }
    }

    public static <E> Closure<E> invokerClosure(String methodName) {
        MethodContext _bcornu_methode_context328 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(methodName, "methodName", 159, 5731, 6429);
            return ClosureUtils.asClosure(InvokerTransformer.<E, Object>getInstance(methodName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context328.methodEnd();
        }
    }

    public static <E> Closure<E> invokerClosure(String methodName, Class<?>[] paramTypes, Object[] args) {
        MethodContext _bcornu_methode_context329 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(args, "args", 178, 6436, 7349);
            CallChecker.varInit(paramTypes, "paramTypes", 178, 6436, 7349);
            CallChecker.varInit(methodName, "methodName", 178, 6436, 7349);
            return ClosureUtils.asClosure(InvokerTransformer.<E, Object>getInstance(methodName, paramTypes, args));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context329.methodEnd();
        }
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E> closure1, Closure<? super E> closure2) {
        MethodContext _bcornu_methode_context330 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure2, "closure2", 194, 7356, 7937);
            CallChecker.varInit(closure1, "closure1", 194, 7356, 7937);
            return ChainedClosure.<E>getInstance(closure1, closure2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context330.methodEnd();
        }
    }

    public static <E> Closure<E> chainedClosure(Closure<? super E>[] closures) {
        MethodContext _bcornu_methode_context331 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closures, "closures", 209, 7944, 8536);
            return ChainedClosure.getInstance(closures);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    public static <E> Closure<E> chainedClosure(Collection<Closure<E>> closures) {
        MethodContext _bcornu_methode_context332 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closures, "closures", 226, 8543, 9299);
            return ChainedClosure.getInstance(closures);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context332.methodEnd();
        }
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> trueClosure) {
        MethodContext _bcornu_methode_context333 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(trueClosure, "trueClosure", 243, 9306, 10014);
            CallChecker.varInit(predicate, "predicate", 243, 9306, 10014);
            return IfClosure.<E>getInstance(predicate, trueClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context333.methodEnd();
        }
    }

    public static <E> Closure<E> ifClosure(Predicate<? super E> predicate, Closure<? super E> trueClosure, Closure<? super E> falseClosure) {
        MethodContext _bcornu_methode_context334 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(falseClosure, "falseClosure", 260, 10021, 10815);
            CallChecker.varInit(trueClosure, "trueClosure", 260, 10021, 10815);
            CallChecker.varInit(predicate, "predicate", 260, 10021, 10815);
            return IfClosure.<E>getInstance(predicate, trueClosure, falseClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context334.methodEnd();
        }
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicates, Closure<? super E>[] closures) {
        MethodContext _bcornu_methode_context335 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closures, "closures", 281, 10822, 11780);
            CallChecker.varInit(predicates, "predicates", 281, 10822, 11780);
            return SwitchClosure.<E>getInstance(predicates, closures, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context335.methodEnd();
        }
    }

    public static <E> Closure<E> switchClosure(Predicate<? super E>[] predicates, Closure<? super E>[] closures, Closure<? super E> defaultClosure) {
        MethodContext _bcornu_methode_context336 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(defaultClosure, "defaultClosure", 304, 11787, 12936);
            CallChecker.varInit(closures, "closures", 304, 11787, 12936);
            CallChecker.varInit(predicates, "predicates", 304, 11787, 12936);
            return SwitchClosure.<E>getInstance(predicates, closures, defaultClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context336.methodEnd();
        }
    }

    public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> predicatesAndClosures) {
        MethodContext _bcornu_methode_context337 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(predicatesAndClosures, "predicatesAndClosures", 328, 12947, 14124);
            return SwitchClosure.getInstance(predicatesAndClosures);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context337.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> switchMapClosure(Map<? extends E, Closure<E>> objectsAndClosures) {
        MethodContext _bcornu_methode_context338 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(objectsAndClosures, "objectsAndClosures", 350, 14131, 15723);
            Closure<? super E>[] trs = CallChecker.varInit(null, "trs", 351, 15010, 15041);
            Predicate<E>[] preds = CallChecker.varInit(null, "preds", 352, 15051, 15078);
            if (objectsAndClosures == null) {
                throw new IllegalArgumentException("The object and closure map must not be null");
            }
            Closure<? super E> def = CallChecker.varInit(objectsAndClosures.remove(null), "def", 356, 15235, 15291);
            int size = CallChecker.varInit(((int) (objectsAndClosures.size())), "size", 357, 15301, 15337);
            trs = new Closure[size];
            CallChecker.varAssign(trs, "trs", 358, 15347, 15370);
            preds = new Predicate[size];
            CallChecker.varAssign(preds, "preds", 359, 15380, 15407);
            int i = CallChecker.varInit(((int) (0)), "i", 360, 15417, 15426);
            for (Map.Entry<? extends E, Closure<E>> entry : objectsAndClosures.entrySet()) {
                if (CallChecker.beforeDeref(preds, Predicate[].class, 362, 15529, 15533)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 362, 15573, 15577)) {
                        preds = CallChecker.beforeCalled(preds, Predicate[].class, 362, 15529, 15533);
                        CallChecker.isCalled(preds, Predicate[].class, 362, 15529, 15533)[i] = EqualPredicate.<E>equalPredicate(entry.getKey());
                        CallChecker.varAssign(CallChecker.isCalled(preds, Predicate[].class, 362, 15529, 15533)[i], "CallChecker.isCalled(preds, Predicate[].class, 362, 15529, 15533)[i]", 362, 15529, 15588);
                    }
                }
                if (CallChecker.beforeDeref(trs, Closure[].class, 363, 15602, 15604)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 363, 15611, 15615)) {
                        trs = CallChecker.beforeCalled(trs, Closure[].class, 363, 15602, 15604);
                        CallChecker.isCalled(trs, Closure[].class, 363, 15602, 15604)[i] = CallChecker.isCalled(entry, Map.Entry.class, 363, 15611, 15615).getValue();
                        CallChecker.varAssign(CallChecker.isCalled(trs, Closure[].class, 363, 15602, 15604)[i], "CallChecker.isCalled(trs, Closure[].class, 363, 15602, 15604)[i]", 363, 15602, 15627);
                    }
                }
                i++;
            }
            return ClosureUtils.<E>switchClosure(preds, trs, def);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context338.methodEnd();
        }
    }
}

