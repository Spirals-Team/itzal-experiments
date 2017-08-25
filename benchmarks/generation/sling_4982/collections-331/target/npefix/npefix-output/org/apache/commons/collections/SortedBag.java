package org.apache.commons.collections;

import java.util.Comparator;

public interface SortedBag<E> extends Bag<E> {
    public Comparator<? super E> comparator();

    public E first();

    public E last();
}

