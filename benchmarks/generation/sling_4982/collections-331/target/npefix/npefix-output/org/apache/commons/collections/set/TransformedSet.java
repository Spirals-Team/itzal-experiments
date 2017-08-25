package org.apache.commons.collections.set;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;

public class TransformedSet<E> extends TransformedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 306127383500410386L;

    public static <E> Set<E> decorate(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1895 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(transformer, "transformer", 55, 1749, 2360);
            CallChecker.varInit(set, "set", 55, 1749, 2360);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSet.serialVersionUID", 55, 1749, 2360);
            return new TransformedSet<E>(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1895.methodEnd();
        }
    }

    public static <E> Set<E> decorateTransform(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context1896 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(transformer, "transformer", 73, 2371, 3536);
            CallChecker.varInit(set, "set", 73, 2371, 3536);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSet.serialVersionUID", 73, 2371, 3536);
            TransformedSet<E> decorated = CallChecker.varInit(new TransformedSet<E>(set, transformer), "decorated", 74, 3086, 3155);
            if (((transformer != null) && (set != null)) && ((set.size()) > 0)) {
                @SuppressWarnings(value = "unchecked")
                E[] values = CallChecker.varInit(((E[]) (set.toArray())), "values", 77, 3237, 3329);
                set.clear();
                values = CallChecker.beforeCalled(values, null, 79, 3383, 3388);
                for (int i = 0; i < (CallChecker.isCalled(values, null, 79, 3383, 3388).length); i++) {
                    if (CallChecker.beforeDeref(decorated, TransformedSet.class, 80, 3421, 3429)) {
                        if (CallChecker.beforeDeref(values, null, 80, 3469, 3474)) {
                            decorated = CallChecker.beforeCalled(decorated, TransformedSet.class, 80, 3421, 3429);
                            final Collection<E> npe_invocation_var369 = CallChecker.isCalled(decorated, TransformedSet.class, 80, 3421, 3429).decorated();
                            if (CallChecker.beforeDeref(npe_invocation_var369, Collection.class, 80, 3421, 3441)) {
                                CallChecker.isCalled(npe_invocation_var369, Collection.class, 80, 3421, 3441).add(transformer.transform(values[i]));
                            }
                        }
                    }
                }
            }
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1896.methodEnd();
        }
    }

    protected TransformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        super(set, transformer);
        MethodContext _bcornu_methode_context363 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context363.methodEnd();
        }
    }
}

