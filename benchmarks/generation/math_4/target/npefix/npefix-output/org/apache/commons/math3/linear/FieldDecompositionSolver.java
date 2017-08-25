package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

public interface FieldDecompositionSolver<T extends FieldElement<T>> {
    FieldVector<T> solve(final FieldVector<T> b);

    FieldMatrix<T> solve(final FieldMatrix<T> b);

    boolean isNonSingular();

    FieldMatrix<T> getInverse();
}

