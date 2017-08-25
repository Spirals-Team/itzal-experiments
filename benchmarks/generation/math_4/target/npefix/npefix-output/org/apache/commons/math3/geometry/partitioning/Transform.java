package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;

public interface Transform<S extends Space, T extends Space> {
    Vector<S> apply(Vector<S> point);

    Hyperplane<S> apply(Hyperplane<S> hyperplane);

    SubHyperplane<T> apply(SubHyperplane<T> sub, Hyperplane<S> original, Hyperplane<S> transformed);
}

