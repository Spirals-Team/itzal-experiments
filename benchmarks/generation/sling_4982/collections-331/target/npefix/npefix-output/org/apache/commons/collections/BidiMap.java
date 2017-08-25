package org.apache.commons.collections;


public interface BidiMap<K, V> extends IterableMap<K, V> {
    V put(K key, V value);

    K getKey(Object value);

    K removeValue(Object value);

    BidiMap<V, K> inverseBidiMap();
}

