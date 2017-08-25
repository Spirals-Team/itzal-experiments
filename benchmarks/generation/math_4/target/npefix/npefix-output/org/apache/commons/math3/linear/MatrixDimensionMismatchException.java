package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MultiDimensionMismatchException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MatrixDimensionMismatchException extends MultiDimensionMismatchException {
    private static final long serialVersionUID = -8415396756375798143L;

    public MatrixDimensionMismatchException(int wrongRowDim, int wrongColDim, int expectedRowDim, int expectedColDim) {
        super(LocalizedFormats.DIMENSIONS_MISMATCH_2x2, new Integer[]{ wrongRowDim , wrongColDim }, new Integer[]{ expectedRowDim , expectedColDim });
        ConstructorContext _bcornu_methode_context670 = new ConstructorContext(MatrixDimensionMismatchException.class, 41, 1360, 2082);
        try {
        } finally {
            _bcornu_methode_context670.methodEnd();
        }
    }

    public int getWrongRowDimension() {
        MethodContext _bcornu_methode_context2959 = new MethodContext(int.class, 53, 2089, 2225);
        try {
            CallChecker.varInit(this, "this", 53, 2089, 2225);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.MatrixDimensionMismatchException.serialVersionUID", 53, 2089, 2225);
            return getWrongDimension(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2959.methodEnd();
        }
    }

    public int getExpectedRowDimension() {
        MethodContext _bcornu_methode_context2960 = new MethodContext(int.class, 59, 2231, 2373);
        try {
            CallChecker.varInit(this, "this", 59, 2231, 2373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.MatrixDimensionMismatchException.serialVersionUID", 59, 2231, 2373);
            return getExpectedDimension(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2960.methodEnd();
        }
    }

    public int getWrongColumnDimension() {
        MethodContext _bcornu_methode_context2961 = new MethodContext(int.class, 65, 2379, 2518);
        try {
            CallChecker.varInit(this, "this", 65, 2379, 2518);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.MatrixDimensionMismatchException.serialVersionUID", 65, 2379, 2518);
            return getWrongDimension(1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2961.methodEnd();
        }
    }

    public int getExpectedColumnDimension() {
        MethodContext _bcornu_methode_context2962 = new MethodContext(int.class, 71, 2524, 2672);
        try {
            CallChecker.varInit(this, "this", 71, 2524, 2672);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.MatrixDimensionMismatchException.serialVersionUID", 71, 2524, 2672);
            return getExpectedDimension(1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2962.methodEnd();
        }
    }
}

