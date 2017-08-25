package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class EmptyMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements MapIterator<K, V> , ResettableIterator<K> {
    public static final MapIterator<Object, Object> INSTANCE = new EmptyMapIterator<Object, Object>();

    @SuppressWarnings(value = "unchecked")
    public static <K, V> MapIterator<K, V> getInstance() {
        MethodContext _bcornu_methode_context771 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.iterators.EmptyMapIterator.INSTANCE", 46, 1531, 1808);
            return ((MapIterator<K, V>) (EmptyMapIterator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context771.methodEnd();
        }
    }

    protected EmptyMapIterator() {
        super();
        MethodContext _bcornu_methode_context143 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }
}

