package org.apache.commons.collections.keyvalue;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.commons.collections.KeyValue;

public final class DefaultMapEntry<K, V> extends AbstractMapEntry<K, V> {
    public DefaultMapEntry(final K key, final V value) {
        super(key, value);
        MethodContext _bcornu_methode_context107 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public DefaultMapEntry(final KeyValue<K, V> pair) {
        super(pair.getKey(), pair.getValue());
        MethodContext _bcornu_methode_context108 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public DefaultMapEntry(final Map.Entry<K, V> entry) {
        super(entry.getKey(), entry.getValue());
        MethodContext _bcornu_methode_context109 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context109.methodEnd();
        }
    }
}

