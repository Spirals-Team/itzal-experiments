package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.IterableMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public abstract class AbstractIterableMap<K, V> implements IterableMap<K, V> {
    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context453 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 35, 1266, 1415);
            return new EntrySetToMapIteratorAdapter<K, V>(entrySet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context453.methodEnd();
        }
    }
}

