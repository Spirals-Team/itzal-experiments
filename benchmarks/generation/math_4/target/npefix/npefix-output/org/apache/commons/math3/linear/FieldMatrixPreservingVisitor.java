package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

public interface FieldMatrixPreservingVisitor<T extends FieldElement<?>> {
    void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn);

    void visit(int row, int column, T value);

    T end();
}

