package org.apache.commons.collections;

import java.util.Set;
import java.util.Iterator;
import java.util.Collection;

public interface Bag<E> extends Collection<E> {
    int getCount(Object object);

    boolean add(E object);

    boolean add(E object, int nCopies);

    boolean remove(Object object);

    boolean remove(Object object, int nCopies);

    Set<E> uniqueSet();

    int size();

    boolean containsAll(Collection<?> coll);

    boolean removeAll(Collection<?> coll);

    boolean retainAll(Collection<?> coll);

    Iterator<E> iterator();
}

