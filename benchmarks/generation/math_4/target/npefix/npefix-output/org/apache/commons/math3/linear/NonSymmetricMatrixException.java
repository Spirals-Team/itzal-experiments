package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonSymmetricMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7518495577824189882L;

    private final int row;

    private final int column;

    private final double threshold;

    public NonSymmetricMatrixException(int row, int column, double threshold) {
        super(LocalizedFormats.NON_SYMMETRIC_MATRIX, row, column, threshold);
        ConstructorContext _bcornu_methode_context796 = new ConstructorContext(NonSymmetricMatrixException.class, 45, 1431, 1928);
        try {
            this.row = row;
            CallChecker.varAssign(this.row, "this.row", 49, 1842, 1856);
            this.column = column;
            CallChecker.varAssign(this.column, "this.column", 50, 1866, 1886);
            this.threshold = threshold;
            CallChecker.varAssign(this.threshold, "this.threshold", 51, 1896, 1922);
        } finally {
            _bcornu_methode_context796.methodEnd();
        }
    }

    public int getRow() {
        MethodContext _bcornu_methode_context3499 = new MethodContext(int.class, 57, 1935, 2040);
        try {
            CallChecker.varInit(this, "this", 57, 1935, 2040);
            CallChecker.varInit(this.threshold, "threshold", 57, 1935, 2040);
            CallChecker.varInit(this.column, "column", 57, 1935, 2040);
            CallChecker.varInit(this.row, "row", 57, 1935, 2040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonSymmetricMatrixException.serialVersionUID", 57, 1935, 2040);
            return row;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3499.methodEnd();
        }
    }

    public int getColumn() {
        MethodContext _bcornu_methode_context3500 = new MethodContext(int.class, 63, 2046, 2160);
        try {
            CallChecker.varInit(this, "this", 63, 2046, 2160);
            CallChecker.varInit(this.threshold, "threshold", 63, 2046, 2160);
            CallChecker.varInit(this.column, "column", 63, 2046, 2160);
            CallChecker.varInit(this.row, "row", 63, 2046, 2160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonSymmetricMatrixException.serialVersionUID", 63, 2046, 2160);
            return column;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3500.methodEnd();
        }
    }

    public double getThreshold() {
        MethodContext _bcornu_methode_context3501 = new MethodContext(double.class, 69, 2166, 2291);
        try {
            CallChecker.varInit(this, "this", 69, 2166, 2291);
            CallChecker.varInit(this.threshold, "threshold", 69, 2166, 2291);
            CallChecker.varInit(this.column, "column", 69, 2166, 2291);
            CallChecker.varInit(this.row, "row", 69, 2166, 2291);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonSymmetricMatrixException.serialVersionUID", 69, 2166, 2291);
            return threshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3501.methodEnd();
        }
    }
}

