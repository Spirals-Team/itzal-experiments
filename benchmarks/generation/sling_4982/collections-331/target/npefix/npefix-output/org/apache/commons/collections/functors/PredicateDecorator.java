package org.apache.commons.collections.functors;

import org.apache.commons.collections.Predicate;

public interface PredicateDecorator<T> extends Predicate<T> {
    Predicate<? super T>[] getPredicates();
}

