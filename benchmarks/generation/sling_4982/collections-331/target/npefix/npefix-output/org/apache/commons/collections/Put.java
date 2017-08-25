package org.apache.commons.collections;

import java.util.Map;

public interface Put<K, V> {
    public void clear();

    public Object put(K key, V value);

    public void putAll(Map<? extends K, ? extends V> t);
}

