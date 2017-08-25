package org.apache.commons.collections;


public interface OrderedMap<K, V> extends IterableMap<K, V> {
    OrderedMapIterator<K, V> mapIterator();

    public K firstKey();

    public K lastKey();

    public K nextKey(K key);

    public K previousKey(K key);
}

