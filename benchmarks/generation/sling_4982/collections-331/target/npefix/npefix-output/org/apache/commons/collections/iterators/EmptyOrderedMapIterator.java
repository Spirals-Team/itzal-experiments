package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class EmptyOrderedMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements OrderedMapIterator<K, V> , ResettableIterator<K> {
    public static final OrderedMapIterator<Object, Object> INSTANCE = new EmptyOrderedMapIterator<Object, Object>();

    @SuppressWarnings(value = "unchecked")
    public static <K, V> OrderedMapIterator<K, V> getInstance() {
        MethodContext _bcornu_methode_context348 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyOrderedMapIterator.INSTANCE", 46, 1574, 1872);
            return ((OrderedMapIterator<K, V>) (EmptyOrderedMapIterator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context348.methodEnd();
        }
    }

    protected EmptyOrderedMapIterator() {
        super();
        MethodContext _bcornu_methode_context55 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }
}

