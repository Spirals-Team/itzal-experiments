package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Vector1D implements Vector<Euclidean1D> {
    public static final Vector1D ZERO = new Vector1D(0.0);

    public static final Vector1D ONE = new Vector1D(1.0);

    public static final Vector1D NaN = new Vector1D(Double.NaN);

    public static final Vector1D POSITIVE_INFINITY = new Vector1D(Double.POSITIVE_INFINITY);

    public static final Vector1D NEGATIVE_INFINITY = new Vector1D(Double.NEGATIVE_INFINITY);

    private static final long serialVersionUID = 7556674948671647925L;

    private final double x;

    public Vector1D(double x) {
        ConstructorContext _bcornu_methode_context327 = new ConstructorContext(Vector1D.class, 65, 2293, 2469);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 66, 2453, 2463);
        } finally {
            _bcornu_methode_context327.methodEnd();
        }
    }

    public Vector1D(double a, Vector1D u) {
        ConstructorContext _bcornu_methode_context328 = new ConstructorContext(Vector1D.class, 75, 2476, 2754);
        try {
            u = CallChecker.beforeCalled(u, Vector1D.class, 76, 2745, 2745);
            this.x = a * (CallChecker.isCalled(u, Vector1D.class, 76, 2745, 2745).x);
            CallChecker.varAssign(this.x, "this.x", 76, 2732, 2748);
        } finally {
            _bcornu_methode_context328.methodEnd();
        }
    }

    public Vector1D(double a1, Vector1D u1, double a2, Vector1D u2) {
        ConstructorContext _bcornu_methode_context329 = new ConstructorContext(Vector1D.class, 87, 2761, 3197);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector1D.class, 88, 3175, 3176);
            u2 = CallChecker.beforeCalled(u2, Vector1D.class, 88, 3187, 3188);
            this.x = (a1 * (CallChecker.isCalled(u1, Vector1D.class, 88, 3175, 3176).x)) + (a2 * (CallChecker.isCalled(u2, Vector1D.class, 88, 3187, 3188).x));
            CallChecker.varAssign(this.x, "this.x", 88, 3161, 3191);
        } finally {
            _bcornu_methode_context329.methodEnd();
        }
    }

    public Vector1D(double a1, Vector1D u1, double a2, Vector1D u2, double a3, Vector1D u3) {
        ConstructorContext _bcornu_methode_context330 = new ConstructorContext(Vector1D.class, 101, 3204, 3789);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector1D.class, 103, 3755, 3756);
            u2 = CallChecker.beforeCalled(u2, Vector1D.class, 103, 3767, 3768);
            u3 = CallChecker.beforeCalled(u3, Vector1D.class, 103, 3779, 3780);
            this.x = ((a1 * (CallChecker.isCalled(u1, Vector1D.class, 103, 3755, 3756).x)) + (a2 * (CallChecker.isCalled(u2, Vector1D.class, 103, 3767, 3768).x))) + (a3 * (CallChecker.isCalled(u3, Vector1D.class, 103, 3779, 3780).x));
            CallChecker.varAssign(this.x, "this.x", 103, 3741, 3783);
        } finally {
            _bcornu_methode_context330.methodEnd();
        }
    }

    public Vector1D(double a1, Vector1D u1, double a2, Vector1D u2, double a3, Vector1D u3, double a4, Vector1D u4) {
        ConstructorContext _bcornu_methode_context331 = new ConstructorContext(Vector1D.class, 118, 3796, 4510);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector1D.class, 120, 4464, 4465);
            u2 = CallChecker.beforeCalled(u2, Vector1D.class, 120, 4476, 4477);
            u3 = CallChecker.beforeCalled(u3, Vector1D.class, 120, 4488, 4489);
            u4 = CallChecker.beforeCalled(u4, Vector1D.class, 120, 4500, 4501);
            this.x = (((a1 * (CallChecker.isCalled(u1, Vector1D.class, 120, 4464, 4465).x)) + (a2 * (CallChecker.isCalled(u2, Vector1D.class, 120, 4476, 4477).x))) + (a3 * (CallChecker.isCalled(u3, Vector1D.class, 120, 4488, 4489).x))) + (a4 * (CallChecker.isCalled(u4, Vector1D.class, 120, 4500, 4501).x));
            CallChecker.varAssign(this.x, "this.x", 120, 4450, 4504);
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context1516 = new MethodContext(double.class, 127, 4517, 4678);
        try {
            CallChecker.varInit(this, "this", 127, 4517, 4678);
            CallChecker.varInit(this.x, "x", 127, 4517, 4678);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 127, 4517, 4678);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 127, 4517, 4678);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 127, 4517, 4678);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 127, 4517, 4678);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 127, 4517, 4678);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 127, 4517, 4678);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1516.methodEnd();
        }
    }

    public Space getSpace() {
        MethodContext _bcornu_methode_context1517 = new MethodContext(Space.class, 132, 4685, 4782);
        try {
            CallChecker.varInit(this, "this", 132, 4685, 4782);
            CallChecker.varInit(this.x, "x", 132, 4685, 4782);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 132, 4685, 4782);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 132, 4685, 4782);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 132, 4685, 4782);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 132, 4685, 4782);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 132, 4685, 4782);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 132, 4685, 4782);
            return Euclidean1D.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Space) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1517.methodEnd();
        }
    }

    public Vector1D getZero() {
        MethodContext _bcornu_methode_context1518 = new MethodContext(Vector1D.class, 137, 4789, 4867);
        try {
            CallChecker.varInit(this, "this", 137, 4789, 4867);
            CallChecker.varInit(this.x, "x", 137, 4789, 4867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 137, 4789, 4867);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 137, 4789, 4867);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 137, 4789, 4867);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 137, 4789, 4867);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 137, 4789, 4867);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 137, 4789, 4867);
            return Vector1D.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1518.methodEnd();
        }
    }

    public double getNorm1() {
        MethodContext _bcornu_methode_context1519 = new MethodContext(double.class, 142, 4874, 4962);
        try {
            CallChecker.varInit(this, "this", 142, 4874, 4962);
            CallChecker.varInit(this.x, "x", 142, 4874, 4962);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 142, 4874, 4962);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 142, 4874, 4962);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 142, 4874, 4962);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 142, 4874, 4962);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 142, 4874, 4962);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 142, 4874, 4962);
            return FastMath.abs(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1519.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context1520 = new MethodContext(double.class, 147, 4969, 5056);
        try {
            CallChecker.varInit(this, "this", 147, 4969, 5056);
            CallChecker.varInit(this.x, "x", 147, 4969, 5056);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 147, 4969, 5056);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 147, 4969, 5056);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 147, 4969, 5056);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 147, 4969, 5056);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 147, 4969, 5056);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 147, 4969, 5056);
            return FastMath.abs(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1520.methodEnd();
        }
    }

    public double getNormSq() {
        MethodContext _bcornu_methode_context1521 = new MethodContext(double.class, 152, 5063, 5142);
        try {
            CallChecker.varInit(this, "this", 152, 5063, 5142);
            CallChecker.varInit(this.x, "x", 152, 5063, 5142);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 152, 5063, 5142);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 152, 5063, 5142);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 152, 5063, 5142);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 152, 5063, 5142);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 152, 5063, 5142);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 152, 5063, 5142);
            return (x) * (x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1521.methodEnd();
        }
    }

    public double getNormInf() {
        MethodContext _bcornu_methode_context1522 = new MethodContext(double.class, 157, 5149, 5239);
        try {
            CallChecker.varInit(this, "this", 157, 5149, 5239);
            CallChecker.varInit(this.x, "x", 157, 5149, 5239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 157, 5149, 5239);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 157, 5149, 5239);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 157, 5149, 5239);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 157, 5149, 5239);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 157, 5149, 5239);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 157, 5149, 5239);
            return FastMath.abs(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1522.methodEnd();
        }
    }

    public Vector1D add(Vector<Euclidean1D> v) {
        MethodContext _bcornu_methode_context1523 = new MethodContext(Vector1D.class, 162, 5246, 5400);
        try {
            CallChecker.varInit(this, "this", 162, 5246, 5400);
            CallChecker.varInit(v, "v", 162, 5246, 5400);
            CallChecker.varInit(this.x, "x", 162, 5246, 5400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 162, 5246, 5400);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 162, 5246, 5400);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 162, 5246, 5400);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 162, 5246, 5400);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 162, 5246, 5400);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 162, 5246, 5400);
            Vector1D v1 = CallChecker.varInit(((Vector1D) (v)), "v1", 163, 5324, 5350);
            v1 = CallChecker.beforeCalled(v1, Vector1D.class, 164, 5384, 5385);
            return new Vector1D(((x) + (CallChecker.isCalled(v1, Vector1D.class, 164, 5384, 5385).getX())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1523.methodEnd();
        }
    }

    public Vector1D add(double factor, Vector<Euclidean1D> v) {
        MethodContext _bcornu_methode_context1524 = new MethodContext(Vector1D.class, 168, 5407, 5585);
        try {
            CallChecker.varInit(this, "this", 168, 5407, 5585);
            CallChecker.varInit(v, "v", 168, 5407, 5585);
            CallChecker.varInit(factor, "factor", 168, 5407, 5585);
            CallChecker.varInit(this.x, "x", 168, 5407, 5585);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 168, 5407, 5585);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 168, 5407, 5585);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 168, 5407, 5585);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 168, 5407, 5585);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 168, 5407, 5585);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 168, 5407, 5585);
            Vector1D v1 = CallChecker.varInit(((Vector1D) (v)), "v1", 169, 5500, 5526);
            v1 = CallChecker.beforeCalled(v1, Vector1D.class, 170, 5569, 5570);
            return new Vector1D(((x) + (factor * (CallChecker.isCalled(v1, Vector1D.class, 170, 5569, 5570).getX()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1524.methodEnd();
        }
    }

    public Vector1D subtract(Vector<Euclidean1D> p) {
        MethodContext _bcornu_methode_context1525 = new MethodContext(Vector1D.class, 174, 5592, 5746);
        try {
            CallChecker.varInit(this, "this", 174, 5592, 5746);
            CallChecker.varInit(p, "p", 174, 5592, 5746);
            CallChecker.varInit(this.x, "x", 174, 5592, 5746);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 174, 5592, 5746);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 174, 5592, 5746);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 174, 5592, 5746);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 174, 5592, 5746);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 174, 5592, 5746);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 174, 5592, 5746);
            Vector1D p3 = CallChecker.varInit(((Vector1D) (p)), "p3", 175, 5675, 5701);
            p3 = CallChecker.beforeCalled(p3, Vector1D.class, 176, 5735, 5736);
            return new Vector1D(((x) - (CallChecker.isCalled(p3, Vector1D.class, 176, 5735, 5736).x)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1525.methodEnd();
        }
    }

    public Vector1D subtract(double factor, Vector<Euclidean1D> v) {
        MethodContext _bcornu_methode_context1526 = new MethodContext(Vector1D.class, 180, 5753, 5936);
        try {
            CallChecker.varInit(this, "this", 180, 5753, 5936);
            CallChecker.varInit(v, "v", 180, 5753, 5936);
            CallChecker.varInit(factor, "factor", 180, 5753, 5936);
            CallChecker.varInit(this.x, "x", 180, 5753, 5936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 180, 5753, 5936);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 180, 5753, 5936);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 180, 5753, 5936);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 180, 5753, 5936);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 180, 5753, 5936);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 180, 5753, 5936);
            Vector1D v1 = CallChecker.varInit(((Vector1D) (v)), "v1", 181, 5851, 5877);
            v1 = CallChecker.beforeCalled(v1, Vector1D.class, 182, 5920, 5921);
            return new Vector1D(((x) - (factor * (CallChecker.isCalled(v1, Vector1D.class, 182, 5920, 5921).getX()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1526.methodEnd();
        }
    }

    public Vector1D normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context1527 = new MethodContext(Vector1D.class, 186, 5943, 6234);
        try {
            CallChecker.varInit(this, "this", 186, 5943, 6234);
            CallChecker.varInit(this.x, "x", 186, 5943, 6234);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 186, 5943, 6234);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 186, 5943, 6234);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 186, 5943, 6234);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 186, 5943, 6234);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 186, 5943, 6234);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 186, 5943, 6234);
            double s = CallChecker.varInit(((double) (getNorm())), "s", 187, 6037, 6057);
            if (s == 0) {
                throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
            }
            return scalarMultiply((1 / s));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1527.methodEnd();
        }
    }

    public Vector1D negate() {
        MethodContext _bcornu_methode_context1528 = new MethodContext(Vector1D.class, 194, 6240, 6329);
        try {
            CallChecker.varInit(this, "this", 194, 6240, 6329);
            CallChecker.varInit(this.x, "x", 194, 6240, 6329);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 194, 6240, 6329);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 194, 6240, 6329);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 194, 6240, 6329);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 194, 6240, 6329);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 194, 6240, 6329);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 194, 6240, 6329);
            return new Vector1D((-(x)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1528.methodEnd();
        }
    }

    public Vector1D scalarMultiply(double a) {
        MethodContext _bcornu_methode_context1529 = new MethodContext(Vector1D.class, 199, 6336, 6444);
        try {
            CallChecker.varInit(this, "this", 199, 6336, 6444);
            CallChecker.varInit(a, "a", 199, 6336, 6444);
            CallChecker.varInit(this.x, "x", 199, 6336, 6444);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 199, 6336, 6444);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 199, 6336, 6444);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 199, 6336, 6444);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 199, 6336, 6444);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 199, 6336, 6444);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 199, 6336, 6444);
            return new Vector1D((a * (x)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1529.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context1530 = new MethodContext(boolean.class, 204, 6451, 6537);
        try {
            CallChecker.varInit(this, "this", 204, 6451, 6537);
            CallChecker.varInit(this.x, "x", 204, 6451, 6537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 204, 6451, 6537);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 204, 6451, 6537);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 204, 6451, 6537);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 204, 6451, 6537);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 204, 6451, 6537);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 204, 6451, 6537);
            return Double.isNaN(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1530.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context1531 = new MethodContext(boolean.class, 209, 6544, 6652);
        try {
            CallChecker.varInit(this, "this", 209, 6544, 6652);
            CallChecker.varInit(this.x, "x", 209, 6544, 6652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 209, 6544, 6652);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 209, 6544, 6652);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 209, 6544, 6652);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 209, 6544, 6652);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 209, 6544, 6652);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 209, 6544, 6652);
            return (!(isNaN())) && (Double.isInfinite(x));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1531.methodEnd();
        }
    }

    public double distance1(Vector<Euclidean1D> p) {
        MethodContext _bcornu_methode_context1532 = new MethodContext(double.class, 214, 6659, 6842);
        try {
            CallChecker.varInit(this, "this", 214, 6659, 6842);
            CallChecker.varInit(p, "p", 214, 6659, 6842);
            CallChecker.varInit(this.x, "x", 214, 6659, 6842);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 214, 6659, 6842);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 214, 6659, 6842);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 214, 6659, 6842);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 214, 6659, 6842);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 214, 6659, 6842);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 214, 6659, 6842);
            Vector1D p3 = CallChecker.varInit(((Vector1D) (p)), "p3", 215, 6741, 6767);
            p3 = CallChecker.beforeCalled(p3, Vector1D.class, 216, 6808, 6809);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector1D.class, 216, 6808, 6809).x) - (this.x))))), "dx", 216, 6777, 6817);
            return dx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1532.methodEnd();
        }
    }

    public double distance(Vector<Euclidean1D> p) {
        MethodContext _bcornu_methode_context1533 = new MethodContext(double.class, 221, 6849, 7031);
        try {
            CallChecker.varInit(this, "this", 221, 6849, 7031);
            CallChecker.varInit(p, "p", 221, 6849, 7031);
            CallChecker.varInit(this.x, "x", 221, 6849, 7031);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 221, 6849, 7031);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 221, 6849, 7031);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 221, 6849, 7031);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 221, 6849, 7031);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 221, 6849, 7031);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 221, 6849, 7031);
            Vector1D p3 = CallChecker.varInit(((Vector1D) (p)), "p3", 222, 6930, 6956);
            p3 = CallChecker.beforeCalled(p3, Vector1D.class, 223, 6984, 6985);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector1D.class, 223, 6984, 6985).x) - (this.x))), "dx", 223, 6966, 6992);
            return FastMath.abs(dx);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1533.methodEnd();
        }
    }

    public double distanceInf(Vector<Euclidean1D> p) {
        MethodContext _bcornu_methode_context1534 = new MethodContext(double.class, 228, 7038, 7223);
        try {
            CallChecker.varInit(this, "this", 228, 7038, 7223);
            CallChecker.varInit(p, "p", 228, 7038, 7223);
            CallChecker.varInit(this.x, "x", 228, 7038, 7223);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 228, 7038, 7223);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 228, 7038, 7223);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 228, 7038, 7223);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 228, 7038, 7223);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 228, 7038, 7223);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 228, 7038, 7223);
            Vector1D p3 = CallChecker.varInit(((Vector1D) (p)), "p3", 229, 7122, 7148);
            p3 = CallChecker.beforeCalled(p3, Vector1D.class, 230, 7189, 7190);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector1D.class, 230, 7189, 7190).x) - (this.x))))), "dx", 230, 7158, 7198);
            return dx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1534.methodEnd();
        }
    }

    public double distanceSq(Vector<Euclidean1D> p) {
        MethodContext _bcornu_methode_context1535 = new MethodContext(double.class, 235, 7230, 7405);
        try {
            CallChecker.varInit(this, "this", 235, 7230, 7405);
            CallChecker.varInit(p, "p", 235, 7230, 7405);
            CallChecker.varInit(this.x, "x", 235, 7230, 7405);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 235, 7230, 7405);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 235, 7230, 7405);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 235, 7230, 7405);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 235, 7230, 7405);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 235, 7230, 7405);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 235, 7230, 7405);
            Vector1D p3 = CallChecker.varInit(((Vector1D) (p)), "p3", 236, 7313, 7339);
            p3 = CallChecker.beforeCalled(p3, Vector1D.class, 237, 7367, 7368);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector1D.class, 237, 7367, 7368).x) - (this.x))), "dx", 237, 7349, 7375);
            return dx * dx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1535.methodEnd();
        }
    }

    public double dotProduct(final Vector<Euclidean1D> v) {
        MethodContext _bcornu_methode_context1536 = new MethodContext(double.class, 242, 7412, 7564);
        try {
            CallChecker.varInit(this, "this", 242, 7412, 7564);
            CallChecker.varInit(v, "v", 242, 7412, 7564);
            CallChecker.varInit(this.x, "x", 242, 7412, 7564);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 242, 7412, 7564);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 242, 7412, 7564);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 242, 7412, 7564);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 242, 7412, 7564);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 242, 7412, 7564);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 242, 7412, 7564);
            final Vector1D v1 = CallChecker.varInit(((Vector1D) (v)), "v1", 243, 7501, 7533);
            return (x) * (CallChecker.isCalled(v1, Vector1D.class, 244, 7554, 7555).x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1536.methodEnd();
        }
    }

    public static double distance(Vector1D p1, Vector1D p2) {
        MethodContext _bcornu_methode_context1537 = new MethodContext(double.class, 255, 7571, 8059);
        try {
            CallChecker.varInit(p2, "p2", 255, 7571, 8059);
            CallChecker.varInit(p1, "p1", 255, 7571, 8059);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 255, 7571, 8059);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 255, 7571, 8059);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 255, 7571, 8059);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 255, 7571, 8059);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 255, 7571, 8059);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 255, 7571, 8059);
            if (CallChecker.beforeDeref(p1, Vector1D.class, 256, 8038, 8039)) {
                p1 = CallChecker.beforeCalled(p1, Vector1D.class, 256, 8038, 8039);
                return CallChecker.isCalled(p1, Vector1D.class, 256, 8038, 8039).distance(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1537.methodEnd();
        }
    }

    public static double distanceInf(Vector1D p1, Vector1D p2) {
        MethodContext _bcornu_methode_context1538 = new MethodContext(double.class, 267, 8066, 8575);
        try {
            CallChecker.varInit(p2, "p2", 267, 8066, 8575);
            CallChecker.varInit(p1, "p1", 267, 8066, 8575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 267, 8066, 8575);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 267, 8066, 8575);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 267, 8066, 8575);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 267, 8066, 8575);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 267, 8066, 8575);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 267, 8066, 8575);
            if (CallChecker.beforeDeref(p1, Vector1D.class, 268, 8551, 8552)) {
                p1 = CallChecker.beforeCalled(p1, Vector1D.class, 268, 8551, 8552);
                return CallChecker.isCalled(p1, Vector1D.class, 268, 8551, 8552).distanceInf(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1538.methodEnd();
        }
    }

    public static double distanceSq(Vector1D p1, Vector1D p2) {
        MethodContext _bcornu_methode_context1539 = new MethodContext(double.class, 279, 8582, 9032);
        try {
            CallChecker.varInit(p2, "p2", 279, 8582, 9032);
            CallChecker.varInit(p1, "p1", 279, 8582, 9032);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 279, 8582, 9032);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 279, 8582, 9032);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 279, 8582, 9032);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 279, 8582, 9032);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 279, 8582, 9032);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 279, 8582, 9032);
            if (CallChecker.beforeDeref(p1, Vector1D.class, 280, 9009, 9010)) {
                p1 = CallChecker.beforeCalled(p1, Vector1D.class, 280, 9009, 9010);
                return CallChecker.isCalled(p1, Vector1D.class, 280, 9009, 9010).distanceSq(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1539.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context1540 = new MethodContext(boolean.class, 303, 9039, 10178);
        try {
            CallChecker.varInit(this, "this", 303, 9039, 10178);
            CallChecker.varInit(other, "other", 303, 9039, 10178);
            CallChecker.varInit(this.x, "x", 303, 9039, 10178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 303, 9039, 10178);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 303, 9039, 10178);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 303, 9039, 10178);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 303, 9039, 10178);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 303, 9039, 10178);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 303, 9039, 10178);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Vector1D) {
                final Vector1D rhs = CallChecker.varInit(((Vector1D) (other)), "rhs", 310, 9990, 10026);
                if (CallChecker.beforeDeref(rhs, Vector1D.class, 311, 10044, 10046)) {
                    if (CallChecker.isCalled(rhs, Vector1D.class, 311, 10044, 10046).isNaN()) {
                        return this.isNaN();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return (x) == (CallChecker.isCalled(rhs, Vector1D.class, 315, 10135, 10137).x);
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1540.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1541 = new MethodContext(int.class, 328, 10185, 10500);
        try {
            CallChecker.varInit(this, "this", 328, 10185, 10500);
            CallChecker.varInit(this.x, "x", 328, 10185, 10500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 328, 10185, 10500);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 328, 10185, 10500);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 328, 10185, 10500);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 328, 10185, 10500);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 328, 10185, 10500);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 328, 10185, 10500);
            if (isNaN()) {
                return 7785;
            }
            return 997 * (MathUtils.hash(x));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1541.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1542 = new MethodContext(String.class, 339, 10507, 10724);
        try {
            CallChecker.varInit(this, "this", 339, 10507, 10724);
            CallChecker.varInit(this.x, "x", 339, 10507, 10724);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 339, 10507, 10724);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 339, 10507, 10724);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 339, 10507, 10724);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 339, 10507, 10724);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 339, 10507, 10724);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 339, 10507, 10724);
            final Vector1DFormat npe_invocation_var137 = Vector1DFormat.getInstance();
            if (CallChecker.beforeDeref(npe_invocation_var137, Vector1DFormat.class, 340, 10677, 10704)) {
                return CallChecker.isCalled(npe_invocation_var137, Vector1DFormat.class, 340, 10677, 10704).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1542.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context1543 = new MethodContext(String.class, 344, 10731, 10868);
        try {
            CallChecker.varInit(this, "this", 344, 10731, 10868);
            CallChecker.varInit(format, "format", 344, 10731, 10868);
            CallChecker.varInit(this.x, "x", 344, 10731, 10868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.serialVersionUID", 344, 10731, 10868);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NEGATIVE_INFINITY", 344, 10731, 10868);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.POSITIVE_INFINITY", 344, 10731, 10868);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.NaN", 344, 10731, 10868);
            CallChecker.varInit(ONE, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ONE", 344, 10731, 10868);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.oned.Vector1D.ZERO", 344, 10731, 10868);
            if (CallChecker.beforeDeref(new Vector1DFormat(format), Vector1DFormat.class, 345, 10823, 10848)) {
                return CallChecker.isCalled(new Vector1DFormat(format), Vector1DFormat.class, 345, 10823, 10848).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1543.methodEnd();
        }
    }
}

