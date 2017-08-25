package org.apache.commons.collections;


public interface IterableGet<K, V> extends Get<K, V> {
    MapIterator<K, V> mapIterator();
}

