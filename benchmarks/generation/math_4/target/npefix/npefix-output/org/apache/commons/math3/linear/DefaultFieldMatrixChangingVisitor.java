package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.FieldElement;

public class DefaultFieldMatrixChangingVisitor<T extends FieldElement<T>> implements FieldMatrixChangingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixChangingVisitor(final T zero) {
        ConstructorContext _bcornu_methode_context708 = new ConstructorContext(DefaultFieldMatrixChangingVisitor.class, 41, 1415, 1590);
        try {
            this.zero = zero;
            CallChecker.varAssign(this.zero, "this.zero", 42, 1568, 1584);
        } finally {
            _bcornu_methode_context708.methodEnd();
        }
    }

    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
        MethodContext _bcornu_methode_context3116 = new MethodContext(void.class, 46, 1597, 1749);
        try {
            CallChecker.varInit(this, "this", 46, 1597, 1749);
            CallChecker.varInit(endColumn, "endColumn", 46, 1597, 1749);
            CallChecker.varInit(startColumn, "startColumn", 46, 1597, 1749);
            CallChecker.varInit(endRow, "endRow", 46, 1597, 1749);
            CallChecker.varInit(startRow, "startRow", 46, 1597, 1749);
            CallChecker.varInit(columns, "columns", 46, 1597, 1749);
            CallChecker.varInit(rows, "rows", 46, 1597, 1749);
            CallChecker.varInit(this.zero, "zero", 46, 1597, 1749);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3116.methodEnd();
        }
    }

    public T visit(int row, int column, T value) {
        MethodContext _bcornu_methode_context3117 = new MethodContext(null, 51, 1756, 1854);
        try {
            CallChecker.varInit(this, "this", 51, 1756, 1854);
            CallChecker.varInit(value, "value", 51, 1756, 1854);
            CallChecker.varInit(column, "column", 51, 1756, 1854);
            CallChecker.varInit(row, "row", 51, 1756, 1854);
            CallChecker.varInit(this.zero, "zero", 51, 1756, 1854);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3117.methodEnd();
        }
    }

    public T end() {
        MethodContext _bcornu_methode_context3118 = new MethodContext(null, 56, 1861, 1928);
        try {
            CallChecker.varInit(this, "this", 56, 1861, 1928);
            CallChecker.varInit(this.zero, "zero", 56, 1861, 1928);
            return zero;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3118.methodEnd();
        }
    }
}

