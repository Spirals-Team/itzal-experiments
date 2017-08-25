package org.apache.commons.collections;

import java.util.Iterator;

public interface ResettableIterator<E> extends Iterator<E> {
    public void reset();
}

