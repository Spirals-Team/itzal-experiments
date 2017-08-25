package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

public interface FieldMatrixChangingVisitor<T extends FieldElement<?>> {
    void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn);

    T visit(int row, int column, T value);

    T end();
}

