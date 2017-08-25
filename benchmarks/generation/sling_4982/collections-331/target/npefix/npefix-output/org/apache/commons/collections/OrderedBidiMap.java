package org.apache.commons.collections;


public interface OrderedBidiMap<K, V> extends BidiMap<K, V> , OrderedMap<K, V> {
    public OrderedBidiMap<V, K> inverseBidiMap();
}

