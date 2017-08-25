package org.apache.commons.collections;

import java.util.Collection;

public interface BoundedCollection<E> extends Collection<E> {
    boolean isFull();

    int maxSize();
}

