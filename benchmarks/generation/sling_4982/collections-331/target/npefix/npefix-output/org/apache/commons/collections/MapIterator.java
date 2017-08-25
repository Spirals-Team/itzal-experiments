package org.apache.commons.collections;

import java.util.Iterator;

public interface MapIterator<K, V> extends Iterator<K> {
    boolean hasNext();

    K next();

    K getKey();

    V getValue();

    void remove();

    V setValue(V value);
}
