package org.apache.commons.collections;

import java.util.Collection;

public interface Buffer<E> extends Collection<E> {
    E remove();

    E get();
}

