package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;

public class DoublePoint implements Serializable , Clusterable {
    private static final long serialVersionUID = 3946024775784901369L;

    private final double[] point;

    public DoublePoint(final double[] point) {
        ConstructorContext _bcornu_methode_context771 = new ConstructorContext(DoublePoint.class, 43, 1283, 1570);
        try {
            this.point = point;
            CallChecker.varAssign(this.point, "this.point", 44, 1546, 1564);
        } finally {
            _bcornu_methode_context771.methodEnd();
        }
    }

    public DoublePoint(final int[] point) {
        ConstructorContext _bcornu_methode_context772 = new ConstructorContext(DoublePoint.class, 54, 1577, 1977);
        try {
            this.point = new double[CallChecker.isCalled(point, int[].class, 55, 1860, 1864).length];
            CallChecker.varAssign(this.point, "this.point", 55, 1836, 1873);
            for (int i = 0; i < (CallChecker.isCalled(point, int[].class, 56, 1904, 1908).length); i++) {
                if (CallChecker.beforeDeref(this.point, double[].class, 57, 1937, 1946)) {
                    if (CallChecker.beforeDeref(point, int[].class, 57, 1953, 1957)) {
                        CallChecker.isCalled(this.point, double[].class, 57, 1937, 1946)[i] = CallChecker.isCalled(point, int[].class, 57, 1953, 1957)[i];
                        CallChecker.varAssign(CallChecker.isCalled(this.point, double[].class, 57, 1937, 1946)[i], "CallChecker.isCalled(this.point, double[].class, 57, 1937, 1946)[i]", 57, 1937, 1961);
                    }
                }
            }
        } finally {
            _bcornu_methode_context772.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context3450 = new MethodContext(double[].class, 62, 1984, 2064);
        try {
            CallChecker.varInit(this, "this", 62, 1984, 2064);
            CallChecker.varInit(this.point, "point", 62, 1984, 2064);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.DoublePoint.serialVersionUID", 62, 1984, 2064);
            return point;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3450.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context3451 = new MethodContext(boolean.class, 68, 2071, 2307);
        try {
            CallChecker.varInit(this, "this", 68, 2071, 2307);
            CallChecker.varInit(other, "other", 68, 2071, 2307);
            CallChecker.varInit(this.point, "point", 68, 2071, 2307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.DoublePoint.serialVersionUID", 68, 2071, 2307);
            if (!(other instanceof DoublePoint)) {
                return false;
            }
            if (CallChecker.beforeDeref(other, Object.class, 72, 2288, 2292)) {
                return Arrays.equals(point, CallChecker.isCalled(((DoublePoint) (other)), DoublePoint.class, 72, 2288, 2292).point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3451.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3452 = new MethodContext(int.class, 77, 2314, 2420);
        try {
            CallChecker.varInit(this, "this", 77, 2314, 2420);
            CallChecker.varInit(this.point, "point", 77, 2314, 2420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.DoublePoint.serialVersionUID", 77, 2314, 2420);
            return Arrays.hashCode(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3452.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context3453 = new MethodContext(String.class, 83, 2427, 2536);
        try {
            CallChecker.varInit(this, "this", 83, 2427, 2536);
            CallChecker.varInit(this.point, "point", 83, 2427, 2536);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.DoublePoint.serialVersionUID", 83, 2427, 2536);
            return Arrays.toString(point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3453.methodEnd();
        }
    }
}

