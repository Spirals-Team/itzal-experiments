package org.apache.commons.collections;

import java.util.Set;
import java.util.Map;
import java.util.Collection;

public interface Get<K, V> {
    public boolean containsKey(Object key);

    public boolean containsValue(Object value);

    public Set<Map.Entry<K, V>> entrySet();

    public V get(Object key);

    public V remove(Object key);

    public boolean isEmpty();

    public Set<K> keySet();

    public int size();

    public Collection<V> values();
}

