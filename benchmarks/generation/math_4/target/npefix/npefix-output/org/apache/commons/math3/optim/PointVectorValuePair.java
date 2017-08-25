package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

public class PointVectorValuePair extends Pair<double[], double[]> implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513L;

        private final double[] point;

        private final double[] value;

        public DataTransferObject(final double[] point, final double[] value) {
            ConstructorContext _bcornu_methode_context189 = new ConstructorContext(PointVectorValuePair.DataTransferObject.class, 135, 4149, 4466);
            try {
                this.point = CallChecker.isCalled(point, double[].class, 136, 4403, 4407).clone();
                CallChecker.varAssign(this.point, "this.point", 136, 4390, 4416);
                this.value = CallChecker.isCalled(value, double[].class, 137, 4443, 4447).clone();
                CallChecker.varAssign(this.value, "this.value", 137, 4430, 4456);
            } finally {
                _bcornu_methode_context189.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context700 = new MethodContext(Object.class, 143, 4477, 4737);
            try {
                CallChecker.varInit(this, "this", 143, 4477, 4737);
                CallChecker.varInit(this.value, "value", 143, 4477, 4737);
                CallChecker.varInit(this.point, "point", 143, 4477, 4737);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.DataTransferObject.serialVersionUID", 143, 4477, 4737);
                return new PointVectorValuePair(point, value, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context700.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20120513L;

    public PointVectorValuePair(final double[] point, final double[] value) {
        this(point, value, true);
        ConstructorContext _bcornu_methode_context190 = new ConstructorContext(PointVectorValuePair.class, 42, 1333, 1745);
        try {
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    public PointVectorValuePair(final double[] point, final double[] value, final boolean copyArray) {
        super((copyArray ? point == null ? null : CallChecker.isCalled(point, double[].class, 60, 2292, 2296).clone() : point), (copyArray ? value == null ? null : CallChecker.isCalled(value, double[].class, 64, 2411, 2415).clone() : value));
        ConstructorContext _bcornu_methode_context191 = new ConstructorContext(PointVectorValuePair.class, 55, 1752, 2454);
        try {
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context701 = new MethodContext(double[].class, 73, 2461, 2665);
        try {
            CallChecker.varInit(this, "this", 73, 2461, 2665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.serialVersionUID", 73, 2461, 2665);
            final double[] p = CallChecker.varInit(getKey(), "p", 74, 2587, 2614);
            if (p == null) {
                return null;
            }else {
                return p.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context701.methodEnd();
        }
    }

    public double[] getPointRef() {
        MethodContext _bcornu_methode_context702 = new MethodContext(double[].class, 83, 2672, 2862);
        try {
            CallChecker.varInit(this, "this", 83, 2672, 2862);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.serialVersionUID", 83, 2672, 2862);
            return getKey();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context702.methodEnd();
        }
    }

    @Override
    public double[] getValue() {
        MethodContext _bcornu_methode_context703 = new MethodContext(double[].class, 93, 2869, 3147);
        try {
            CallChecker.varInit(this, "this", 93, 2869, 3147);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.serialVersionUID", 93, 2869, 3147);
            final double[] v = CallChecker.varInit(super.getValue(), "v", 94, 3061, 3096);
            if (v == null) {
                return null;
            }else {
                return v.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context703.methodEnd();
        }
    }

    public double[] getValueRef() {
        MethodContext _bcornu_methode_context704 = new MethodContext(double[].class, 104, 3154, 3411);
        try {
            CallChecker.varInit(this, "this", 104, 3154, 3411);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.serialVersionUID", 104, 3154, 3411);
            return super.getValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context704.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context705 = new MethodContext(Object.class, 112, 3418, 3666);
        try {
            CallChecker.varInit(this, "this", 112, 3418, 3666);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.PointVectorValuePair.serialVersionUID", 112, 3418, 3666);
            return new PointVectorValuePair.DataTransferObject(getKey(), getValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context705.methodEnd();
        }
    }
}

