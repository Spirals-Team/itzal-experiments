package org.apache.commons.collections.functors;


public interface Equator<T> {
    boolean equate(T o1, T o2);

    int hash(T o);
}

