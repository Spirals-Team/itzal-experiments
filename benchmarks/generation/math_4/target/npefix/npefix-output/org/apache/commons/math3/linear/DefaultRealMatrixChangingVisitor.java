package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class DefaultRealMatrixChangingVisitor implements RealMatrixChangingVisitor {
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
        MethodContext _bcornu_methode_context5512 = new MethodContext(void.class, 32, 1221, 1373);
        try {
            CallChecker.varInit(this, "this", 32, 1221, 1373);
            CallChecker.varInit(endColumn, "endColumn", 32, 1221, 1373);
            CallChecker.varInit(startColumn, "startColumn", 32, 1221, 1373);
            CallChecker.varInit(endRow, "endRow", 32, 1221, 1373);
            CallChecker.varInit(startRow, "startRow", 32, 1221, 1373);
            CallChecker.varInit(columns, "columns", 32, 1221, 1373);
            CallChecker.varInit(rows, "rows", 32, 1221, 1373);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5512.methodEnd();
        }
    }

    public double visit(int row, int column, double value) {
        MethodContext _bcornu_methode_context5513 = new MethodContext(double.class, 37, 1380, 1488);
        try {
            CallChecker.varInit(this, "this", 37, 1380, 1488);
            CallChecker.varInit(value, "value", 37, 1380, 1488);
            CallChecker.varInit(column, "column", 37, 1380, 1488);
            CallChecker.varInit(row, "row", 37, 1380, 1488);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5513.methodEnd();
        }
    }

    public double end() {
        MethodContext _bcornu_methode_context5514 = new MethodContext(double.class, 42, 1495, 1564);
        try {
            CallChecker.varInit(this, "this", 42, 1495, 1564);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5514.methodEnd();
        }
    }
}

