package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.FieldElement;

public class DefaultFieldMatrixPreservingVisitor<T extends FieldElement<T>> implements FieldMatrixPreservingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixPreservingVisitor(final T zero) {
        ConstructorContext _bcornu_methode_context1264 = new ConstructorContext(DefaultFieldMatrixPreservingVisitor.class, 41, 1421, 1598);
        try {
            this.zero = zero;
            CallChecker.varAssign(this.zero, "this.zero", 42, 1576, 1592);
        } finally {
            _bcornu_methode_context1264.methodEnd();
        }
    }

    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
        MethodContext _bcornu_methode_context5650 = new MethodContext(void.class, 46, 1605, 1757);
        try {
            CallChecker.varInit(this, "this", 46, 1605, 1757);
            CallChecker.varInit(endColumn, "endColumn", 46, 1605, 1757);
            CallChecker.varInit(startColumn, "startColumn", 46, 1605, 1757);
            CallChecker.varInit(endRow, "endRow", 46, 1605, 1757);
            CallChecker.varInit(startRow, "startRow", 46, 1605, 1757);
            CallChecker.varInit(columns, "columns", 46, 1605, 1757);
            CallChecker.varInit(rows, "rows", 46, 1605, 1757);
            CallChecker.varInit(this.zero, "zero", 46, 1605, 1757);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5650.methodEnd();
        }
    }

    public void visit(int row, int column, T value) {
        MethodContext _bcornu_methode_context5651 = new MethodContext(void.class, 51, 1764, 1838);
        try {
            CallChecker.varInit(this, "this", 51, 1764, 1838);
            CallChecker.varInit(value, "value", 51, 1764, 1838);
            CallChecker.varInit(column, "column", 51, 1764, 1838);
            CallChecker.varInit(row, "row", 51, 1764, 1838);
            CallChecker.varInit(this.zero, "zero", 51, 1764, 1838);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5651.methodEnd();
        }
    }

    public T end() {
        MethodContext _bcornu_methode_context5652 = new MethodContext(null, 54, 1845, 1912);
        try {
            CallChecker.varInit(this, "this", 54, 1845, 1912);
            CallChecker.varInit(this.zero, "zero", 54, 1845, 1912);
            return zero;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5652.methodEnd();
        }
    }
}

