package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class DimensionMismatchException extends MathIllegalNumberException {
    private static final long serialVersionUID = -8415396756375798143L;

    private final int dimension;

    public DimensionMismatchException(Localizable specific, int wrong, int expected) {
        super(specific, wrong, expected);
        ConstructorContext _bcornu_methode_context532 = new ConstructorContext(DimensionMismatchException.class, 41, 1323, 1784);
        try {
            dimension = expected;
            CallChecker.varAssign(this.dimension, "this.dimension", 45, 1758, 1778);
        } finally {
            _bcornu_methode_context532.methodEnd();
        }
    }

    public DimensionMismatchException(int wrong, int expected) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, wrong, expected);
        ConstructorContext _bcornu_methode_context533 = new ConstructorContext(DimensionMismatchException.class, 54, 1791, 2135);
        try {
        } finally {
            _bcornu_methode_context533.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2496 = new MethodContext(int.class, 62, 2142, 2255);
        try {
            CallChecker.varInit(this, "this", 62, 2142, 2255);
            CallChecker.varInit(this.dimension, "dimension", 62, 2142, 2255);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.DimensionMismatchException.serialVersionUID", 62, 2142, 2255);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2496.methodEnd();
        }
    }
}

