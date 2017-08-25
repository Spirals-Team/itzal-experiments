package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

public class PointValuePair extends Pair<double[], Double> implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513L;

        private final double[] point;

        private final double value;

        public DataTransferObject(final double[] point, final double value) {
            ConstructorContext _bcornu_methode_context123 = new ConstructorContext(PointValuePair.DataTransferObject.class, 110, 3444, 3751);
            try {
                this.point = CallChecker.isCalled(point, double[].class, 111, 3696, 3700).clone();
                CallChecker.varAssign(this.point, "this.point", 111, 3683, 3709);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 112, 3723, 3741);
            } finally {
                _bcornu_methode_context123.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context459 = new MethodContext(Object.class, 118, 3762, 4016);
            try {
                CallChecker.varInit(this, "this", 118, 3762, 4016);
                CallChecker.varInit(this.value, "value", 118, 3762, 4016);
                CallChecker.varInit(this.point, "point", 118, 3762, 4016);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointValuePair.DataTransferObject.serialVersionUID", 118, 3762, 4016);
                return new PointValuePair(point, value, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context459.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20120513L;

    public PointValuePair(final double[] point, final double value) {
        this(point, value, true);
        ConstructorContext _bcornu_methode_context124 = new ConstructorContext(PointValuePair.class, 42, 1315, 1713);
        try {
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public PointValuePair(final double[] point, final double value, final boolean copyArray) {
        super((copyArray ? point == null ? null : CallChecker.isCalled(point, double[].class, 59, 2236, 2240).clone() : point), value);
        ConstructorContext _bcornu_methode_context125 = new ConstructorContext(PointValuePair.class, 55, 1720, 2300);
        try {
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context460 = new MethodContext(double[].class, 69, 2307, 2511);
        try {
            CallChecker.varInit(this, "this", 69, 2307, 2511);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointValuePair.serialVersionUID", 69, 2307, 2511);
            final double[] p = CallChecker.varInit(getKey(), "p", 70, 2433, 2460);
            if (p == null) {
                return null;
            }else {
                return p.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context460.methodEnd();
        }
    }

    public double[] getPointRef() {
        MethodContext _bcornu_methode_context461 = new MethodContext(double[].class, 79, 2518, 2708);
        try {
            CallChecker.varInit(this, "this", 79, 2518, 2708);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointValuePair.serialVersionUID", 79, 2518, 2708);
            return getKey();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context461.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context462 = new MethodContext(Object.class, 87, 2715, 2963);
        try {
            CallChecker.varInit(this, "this", 87, 2715, 2963);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointValuePair.serialVersionUID", 87, 2715, 2963);
            return new PointValuePair.DataTransferObject(getKey(), getValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context462.methodEnd();
        }
    }
}

