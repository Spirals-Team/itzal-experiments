package org.apache.commons.collections;


public interface OrderedMapIterator<K, V> extends MapIterator<K, V> , OrderedIterator<K> {
    boolean hasPrevious();

    K previous();
}

