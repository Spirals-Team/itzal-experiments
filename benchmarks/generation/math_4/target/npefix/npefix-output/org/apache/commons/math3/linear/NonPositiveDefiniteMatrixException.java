package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonPositiveDefiniteMatrixException extends NumberIsTooSmallException {
    private static final long serialVersionUID = 1641613838113738061L;

    private final int index;

    private final double threshold;

    public NonPositiveDefiniteMatrixException(double wrong, int index, double threshold) {
        super(wrong, threshold, false);
        ConstructorContext _bcornu_methode_context108 = new ConstructorContext(NonPositiveDefiniteMatrixException.class, 44, 1478, 2182);
        try {
            this.index = index;
            CallChecker.varAssign(this.index, "this.index", 48, 1917, 1935);
            this.threshold = threshold;
            CallChecker.varAssign(this.threshold, "this.threshold", 49, 1945, 1971);
            final ExceptionContext context = CallChecker.varInit(getContext(), "context", 51, 1982, 2027);
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 52, 2037, 2043)) {
                CallChecker.isCalled(context, ExceptionContext.class, 52, 2037, 2043).addMessage(LocalizedFormats.NOT_POSITIVE_DEFINITE_MATRIX);
            }
            if (CallChecker.beforeDeref(context, ExceptionContext.class, 53, 2112, 2118)) {
                CallChecker.isCalled(context, ExceptionContext.class, 53, 2112, 2118).addMessage(LocalizedFormats.ARRAY_ELEMENT, wrong, index);
            }
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public int getRow() {
        MethodContext _bcornu_methode_context404 = new MethodContext(int.class, 59, 2189, 2283);
        try {
            CallChecker.varInit(this, "this", 59, 2189, 2283);
            CallChecker.varInit(this.threshold, "threshold", 59, 2189, 2283);
            CallChecker.varInit(this.index, "index", 59, 2189, 2283);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException.serialVersionUID", 59, 2189, 2283);
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context404.methodEnd();
        }
    }

    public int getColumn() {
        MethodContext _bcornu_methode_context405 = new MethodContext(int.class, 65, 2289, 2389);
        try {
            CallChecker.varInit(this, "this", 65, 2289, 2389);
            CallChecker.varInit(this.threshold, "threshold", 65, 2289, 2389);
            CallChecker.varInit(this.index, "index", 65, 2289, 2389);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException.serialVersionUID", 65, 2289, 2389);
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context405.methodEnd();
        }
    }

    public double getThreshold() {
        MethodContext _bcornu_methode_context406 = new MethodContext(double.class, 71, 2395, 2522);
        try {
            CallChecker.varInit(this, "this", 71, 2395, 2522);
            CallChecker.varInit(this.threshold, "threshold", 71, 2395, 2522);
            CallChecker.varInit(this.index, "index", 71, 2395, 2522);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException.serialVersionUID", 71, 2395, 2522);
            return threshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context406.methodEnd();
        }
    }
}

