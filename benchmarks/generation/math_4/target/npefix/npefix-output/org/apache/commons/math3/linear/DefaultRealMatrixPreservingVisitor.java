package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class DefaultRealMatrixPreservingVisitor implements RealMatrixPreservingVisitor {
    public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
        MethodContext _bcornu_methode_context2519 = new MethodContext(void.class, 32, 1227, 1379);
        try {
            CallChecker.varInit(this, "this", 32, 1227, 1379);
            CallChecker.varInit(endColumn, "endColumn", 32, 1227, 1379);
            CallChecker.varInit(startColumn, "startColumn", 32, 1227, 1379);
            CallChecker.varInit(endRow, "endRow", 32, 1227, 1379);
            CallChecker.varInit(startRow, "startRow", 32, 1227, 1379);
            CallChecker.varInit(columns, "columns", 32, 1227, 1379);
            CallChecker.varInit(rows, "rows", 32, 1227, 1379);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2519.methodEnd();
        }
    }

    public void visit(int row, int column, double value) {
        MethodContext _bcornu_methode_context2520 = new MethodContext(void.class, 37, 1386, 1465);
        try {
            CallChecker.varInit(this, "this", 37, 1386, 1465);
            CallChecker.varInit(value, "value", 37, 1386, 1465);
            CallChecker.varInit(column, "column", 37, 1386, 1465);
            CallChecker.varInit(row, "row", 37, 1386, 1465);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2520.methodEnd();
        }
    }

    public double end() {
        MethodContext _bcornu_methode_context2521 = new MethodContext(double.class, 40, 1472, 1541);
        try {
            CallChecker.varInit(this, "this", 40, 1472, 1541);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2521.methodEnd();
        }
    }
}

