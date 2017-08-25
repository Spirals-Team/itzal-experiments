package org.apache.commons.collections;

import java.util.SortedMap;
import java.util.Comparator;

public interface SortedBidiMap<K, V> extends SortedMap<K, V> , OrderedBidiMap<K, V> {
    public SortedBidiMap<V, K> inverseBidiMap();

    public Comparator<? super V> valueComparator();
}

