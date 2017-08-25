package org.apache.commons.collections;

import java.util.Collection;

public interface MultiMap<K, V> extends IterableMap<K, Object> {
    public V remove(K key, V item);

    int size();

    boolean containsValue(Object value);

    Object put(K key, Object value);

    Collection<Object> values();
}

