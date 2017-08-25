package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

@Deprecated
public class PointValuePair extends Pair<double[], Double> implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513L;

        private final double[] point;

        private final double value;

        public DataTransferObject(final double[] point, final double value) {
            ConstructorContext _bcornu_methode_context120 = new ConstructorContext(PointValuePair.DataTransferObject.class, 115, 3515, 3822);
            try {
                this.point = CallChecker.isCalled(point, double[].class, 116, 3767, 3771).clone();
                CallChecker.varAssign(this.point, "this.point", 116, 3754, 3780);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 117, 3794, 3812);
            } finally {
                _bcornu_methode_context120.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context455 = new MethodContext(Object.class, 123, 3833, 4087);
            try {
                CallChecker.varInit(this, "this", 123, 3833, 4087);
                CallChecker.varInit(this.value, "value", 123, 3833, 4087);
                CallChecker.varInit(this.point, "point", 123, 3833, 4087);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointValuePair.DataTransferObject.serialVersionUID", 123, 3833, 4087);
                return new PointValuePair(point, value, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context455.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20120513L;

    public PointValuePair(final double[] point, final double value) {
        this(point, value, true);
        ConstructorContext _bcornu_methode_context121 = new ConstructorContext(PointValuePair.class, 47, 1386, 1784);
        try {
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    public PointValuePair(final double[] point, final double value, final boolean copyArray) {
        super((copyArray ? point == null ? null : CallChecker.isCalled(point, double[].class, 64, 2307, 2311).clone() : point), value);
        ConstructorContext _bcornu_methode_context122 = new ConstructorContext(PointValuePair.class, 60, 1791, 2371);
        try {
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context456 = new MethodContext(double[].class, 74, 2378, 2582);
        try {
            CallChecker.varInit(this, "this", 74, 2378, 2582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointValuePair.serialVersionUID", 74, 2378, 2582);
            final double[] p = CallChecker.varInit(getKey(), "p", 75, 2504, 2531);
            if (p == null) {
                return null;
            }else {
                return p.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context456.methodEnd();
        }
    }

    public double[] getPointRef() {
        MethodContext _bcornu_methode_context457 = new MethodContext(double[].class, 84, 2589, 2779);
        try {
            CallChecker.varInit(this, "this", 84, 2589, 2779);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointValuePair.serialVersionUID", 84, 2589, 2779);
            return getKey();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context458 = new MethodContext(Object.class, 92, 2786, 3034);
        try {
            CallChecker.varInit(this, "this", 92, 2786, 3034);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointValuePair.serialVersionUID", 92, 2786, 3034);
            return new PointValuePair.DataTransferObject(getKey(), getValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context458.methodEnd();
        }
    }
}

