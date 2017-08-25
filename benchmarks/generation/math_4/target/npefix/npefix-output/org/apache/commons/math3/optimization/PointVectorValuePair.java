package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

@Deprecated
public class PointVectorValuePair extends Pair<double[], double[]> implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513L;

        private final double[] point;

        private final double[] value;

        public DataTransferObject(final double[] point, final double[] value) {
            ConstructorContext _bcornu_methode_context186 = new ConstructorContext(PointVectorValuePair.DataTransferObject.class, 140, 4220, 4537);
            try {
                this.point = CallChecker.isCalled(point, double[].class, 141, 4474, 4478).clone();
                CallChecker.varAssign(this.point, "this.point", 141, 4461, 4487);
                this.value = CallChecker.isCalled(value, double[].class, 142, 4514, 4518).clone();
                CallChecker.varAssign(this.value, "this.value", 142, 4501, 4527);
            } finally {
                _bcornu_methode_context186.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context694 = new MethodContext(Object.class, 148, 4548, 4808);
            try {
                CallChecker.varInit(this, "this", 148, 4548, 4808);
                CallChecker.varInit(this.value, "value", 148, 4548, 4808);
                CallChecker.varInit(this.point, "point", 148, 4548, 4808);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.DataTransferObject.serialVersionUID", 148, 4548, 4808);
                return new PointVectorValuePair(point, value, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context694.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20120513L;

    public PointVectorValuePair(final double[] point, final double[] value) {
        this(point, value, true);
        ConstructorContext _bcornu_methode_context187 = new ConstructorContext(PointVectorValuePair.class, 47, 1404, 1816);
        try {
        } finally {
            _bcornu_methode_context187.methodEnd();
        }
    }

    public PointVectorValuePair(final double[] point, final double[] value, final boolean copyArray) {
        super((copyArray ? point == null ? null : CallChecker.isCalled(point, double[].class, 65, 2363, 2367).clone() : point), (copyArray ? value == null ? null : CallChecker.isCalled(value, double[].class, 69, 2482, 2486).clone() : value));
        ConstructorContext _bcornu_methode_context188 = new ConstructorContext(PointVectorValuePair.class, 60, 1823, 2525);
        try {
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    public double[] getPoint() {
        MethodContext _bcornu_methode_context695 = new MethodContext(double[].class, 78, 2532, 2736);
        try {
            CallChecker.varInit(this, "this", 78, 2532, 2736);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.serialVersionUID", 78, 2532, 2736);
            final double[] p = CallChecker.varInit(getKey(), "p", 79, 2658, 2685);
            if (p == null) {
                return null;
            }else {
                return p.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context695.methodEnd();
        }
    }

    public double[] getPointRef() {
        MethodContext _bcornu_methode_context696 = new MethodContext(double[].class, 88, 2743, 2933);
        try {
            CallChecker.varInit(this, "this", 88, 2743, 2933);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.serialVersionUID", 88, 2743, 2933);
            return getKey();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context696.methodEnd();
        }
    }

    @Override
    public double[] getValue() {
        MethodContext _bcornu_methode_context697 = new MethodContext(double[].class, 98, 2940, 3218);
        try {
            CallChecker.varInit(this, "this", 98, 2940, 3218);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.serialVersionUID", 98, 2940, 3218);
            final double[] v = CallChecker.varInit(super.getValue(), "v", 99, 3132, 3167);
            if (v == null) {
                return null;
            }else {
                return v.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context697.methodEnd();
        }
    }

    public double[] getValueRef() {
        MethodContext _bcornu_methode_context698 = new MethodContext(double[].class, 109, 3225, 3482);
        try {
            CallChecker.varInit(this, "this", 109, 3225, 3482);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.serialVersionUID", 109, 3225, 3482);
            return super.getValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context698.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context699 = new MethodContext(Object.class, 117, 3489, 3737);
        try {
            CallChecker.varInit(this, "this", 117, 3489, 3737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.PointVectorValuePair.serialVersionUID", 117, 3489, 3737);
            return new PointVectorValuePair.DataTransferObject(getKey(), getValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context699.methodEnd();
        }
    }
}

