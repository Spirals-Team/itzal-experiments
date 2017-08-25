package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractEmptyMapIterator<K, V> extends AbstractEmptyIterator<K> {
    public AbstractEmptyMapIterator() {
        super();
        MethodContext _bcornu_methode_context503 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context503.methodEnd();
        }
    }

    public K getKey() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public V getValue() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public V setValue(V value) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}

