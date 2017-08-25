package org.apache.commons.collections.keyvalue;

import org.apache.commons.collections.Unmodifiable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.commons.collections.KeyValue;

public final class UnmodifiableMapEntry<K, V> extends AbstractMapEntry<K, V> implements Unmodifiable {
    public UnmodifiableMapEntry(final K key, final V value) {
        super(key, value);
        MethodContext _bcornu_methode_context386 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context386.methodEnd();
        }
    }

    public UnmodifiableMapEntry(final KeyValue<K, V> pair) {
        super(pair.getKey(), pair.getValue());
        MethodContext _bcornu_methode_context387 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context387.methodEnd();
        }
    }

    public UnmodifiableMapEntry(final Map.Entry<K, V> entry) {
        super(entry.getKey(), entry.getValue());
        MethodContext _bcornu_methode_context388 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context388.methodEnd();
        }
    }

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }
}

