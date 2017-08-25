package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Vector2D implements Vector<Euclidean2D> {
    public static final Vector2D ZERO = new Vector2D(0, 0);

    public static final Vector2D NaN = new Vector2D(Double.NaN, Double.NaN);

    public static final Vector2D POSITIVE_INFINITY = new Vector2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

    public static final Vector2D NEGATIVE_INFINITY = new Vector2D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

    private static final long serialVersionUID = 266938651998679754L;

    private final double x;

    private final double y;

    public Vector2D(double x, double y) {
        ConstructorContext _bcornu_methode_context384 = new ConstructorContext(Vector2D.class, 68, 2388, 2639);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 69, 2603, 2613);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 70, 2623, 2633);
        } finally {
            _bcornu_methode_context384.methodEnd();
        }
    }

    public Vector2D(double[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context385 = new ConstructorContext(Vector2D.class, 79, 2646, 3077);
        try {
            if (CallChecker.beforeDeref(v, double[].class, 80, 2937, 2937)) {
                v = CallChecker.beforeCalled(v, double[].class, 80, 2937, 2937);
                if ((CallChecker.isCalled(v, double[].class, 80, 2937, 2937).length) != 2) {
                    if (CallChecker.beforeDeref(v, double[].class, 81, 3003, 3003)) {
                        v = CallChecker.beforeCalled(v, double[].class, 81, 3003, 3003);
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 81, 3003, 3003).length, 2);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            v = CallChecker.beforeCalled(v, double[].class, 83, 3044, 3044);
            this.x = CallChecker.isCalled(v, double[].class, 83, 3044, 3044)[0];
            CallChecker.varAssign(this.x, "this.x", 83, 3035, 3048);
            v = CallChecker.beforeCalled(v, double[].class, 84, 3067, 3067);
            this.y = CallChecker.isCalled(v, double[].class, 84, 3067, 3067)[1];
            CallChecker.varAssign(this.y, "this.y", 84, 3058, 3071);
        } finally {
            _bcornu_methode_context385.methodEnd();
        }
    }

    public Vector2D(double a, Vector2D u) {
        ConstructorContext _bcornu_methode_context386 = new ConstructorContext(Vector2D.class, 93, 3084, 3388);
        try {
            u = CallChecker.beforeCalled(u, Vector2D.class, 94, 3353, 3353);
            this.x = a * (CallChecker.isCalled(u, Vector2D.class, 94, 3353, 3353).x);
            CallChecker.varAssign(this.x, "this.x", 94, 3340, 3356);
            u = CallChecker.beforeCalled(u, Vector2D.class, 95, 3379, 3379);
            this.y = a * (CallChecker.isCalled(u, Vector2D.class, 95, 3379, 3379).y);
            CallChecker.varAssign(this.y, "this.y", 95, 3366, 3382);
        } finally {
            _bcornu_methode_context386.methodEnd();
        }
    }

    public Vector2D(double a1, Vector2D u1, double a2, Vector2D u2) {
        ConstructorContext _bcornu_methode_context387 = new ConstructorContext(Vector2D.class, 106, 3395, 3871);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 107, 3809, 3810);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 107, 3821, 3822);
            this.x = (a1 * (CallChecker.isCalled(u1, Vector2D.class, 107, 3809, 3810).x)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 107, 3821, 3822).x));
            CallChecker.varAssign(this.x, "this.x", 107, 3795, 3825);
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 108, 3849, 3850);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 108, 3861, 3862);
            this.y = (a1 * (CallChecker.isCalled(u1, Vector2D.class, 108, 3849, 3850).y)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 108, 3861, 3862).y));
            CallChecker.varAssign(this.y, "this.y", 108, 3835, 3865);
        } finally {
            _bcornu_methode_context387.methodEnd();
        }
    }

    public Vector2D(double a1, Vector2D u1, double a2, Vector2D u2, double a3, Vector2D u3) {
        ConstructorContext _bcornu_methode_context388 = new ConstructorContext(Vector2D.class, 121, 3878, 4515);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 123, 4429, 4430);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 123, 4441, 4442);
            u3 = CallChecker.beforeCalled(u3, Vector2D.class, 123, 4453, 4454);
            this.x = ((a1 * (CallChecker.isCalled(u1, Vector2D.class, 123, 4429, 4430).x)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 123, 4441, 4442).x))) + (a3 * (CallChecker.isCalled(u3, Vector2D.class, 123, 4453, 4454).x));
            CallChecker.varAssign(this.x, "this.x", 123, 4415, 4457);
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 124, 4481, 4482);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 124, 4493, 4494);
            u3 = CallChecker.beforeCalled(u3, Vector2D.class, 124, 4505, 4506);
            this.y = ((a1 * (CallChecker.isCalled(u1, Vector2D.class, 124, 4481, 4482).y)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 124, 4493, 4494).y))) + (a3 * (CallChecker.isCalled(u3, Vector2D.class, 124, 4505, 4506).y));
            CallChecker.varAssign(this.y, "this.y", 124, 4467, 4509);
        } finally {
            _bcornu_methode_context388.methodEnd();
        }
    }

    public Vector2D(double a1, Vector2D u1, double a2, Vector2D u2, double a3, Vector2D u3, double a4, Vector2D u4) {
        ConstructorContext _bcornu_methode_context389 = new ConstructorContext(Vector2D.class, 139, 4522, 5300);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 141, 5190, 5191);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 141, 5202, 5203);
            u3 = CallChecker.beforeCalled(u3, Vector2D.class, 141, 5214, 5215);
            u4 = CallChecker.beforeCalled(u4, Vector2D.class, 141, 5226, 5227);
            this.x = (((a1 * (CallChecker.isCalled(u1, Vector2D.class, 141, 5190, 5191).x)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 141, 5202, 5203).x))) + (a3 * (CallChecker.isCalled(u3, Vector2D.class, 141, 5214, 5215).x))) + (a4 * (CallChecker.isCalled(u4, Vector2D.class, 141, 5226, 5227).x));
            CallChecker.varAssign(this.x, "this.x", 141, 5176, 5230);
            u1 = CallChecker.beforeCalled(u1, Vector2D.class, 142, 5254, 5255);
            u2 = CallChecker.beforeCalled(u2, Vector2D.class, 142, 5266, 5267);
            u3 = CallChecker.beforeCalled(u3, Vector2D.class, 142, 5278, 5279);
            u4 = CallChecker.beforeCalled(u4, Vector2D.class, 142, 5290, 5291);
            this.y = (((a1 * (CallChecker.isCalled(u1, Vector2D.class, 142, 5254, 5255).y)) + (a2 * (CallChecker.isCalled(u2, Vector2D.class, 142, 5266, 5267).y))) + (a3 * (CallChecker.isCalled(u3, Vector2D.class, 142, 5278, 5279).y))) + (a4 * (CallChecker.isCalled(u4, Vector2D.class, 142, 5290, 5291).y));
            CallChecker.varAssign(this.y, "this.y", 142, 5240, 5294);
        } finally {
            _bcornu_methode_context389.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context1659 = new MethodContext(double.class, 149, 5307, 5476);
        try {
            CallChecker.varInit(this, "this", 149, 5307, 5476);
            CallChecker.varInit(this.y, "y", 149, 5307, 5476);
            CallChecker.varInit(this.x, "x", 149, 5307, 5476);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 149, 5307, 5476);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 149, 5307, 5476);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 149, 5307, 5476);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 149, 5307, 5476);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 149, 5307, 5476);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1659.methodEnd();
        }
    }

    public double getY() {
        MethodContext _bcornu_methode_context1660 = new MethodContext(double.class, 157, 5483, 5652);
        try {
            CallChecker.varInit(this, "this", 157, 5483, 5652);
            CallChecker.varInit(this.y, "y", 157, 5483, 5652);
            CallChecker.varInit(this.x, "x", 157, 5483, 5652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 157, 5483, 5652);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 157, 5483, 5652);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 157, 5483, 5652);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 157, 5483, 5652);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 157, 5483, 5652);
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1660.methodEnd();
        }
    }

    public double[] toArray() {
        MethodContext _bcornu_methode_context1661 = new MethodContext(double[].class, 165, 5659, 5862);
        try {
            CallChecker.varInit(this, "this", 165, 5659, 5862);
            CallChecker.varInit(this.y, "y", 165, 5659, 5862);
            CallChecker.varInit(this.x, "x", 165, 5659, 5862);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 165, 5659, 5862);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 165, 5659, 5862);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 165, 5659, 5862);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 165, 5659, 5862);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 165, 5659, 5862);
            return new double[]{ x , y };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1661.methodEnd();
        }
    }

    public Space getSpace() {
        MethodContext _bcornu_methode_context1662 = new MethodContext(Space.class, 170, 5869, 5966);
        try {
            CallChecker.varInit(this, "this", 170, 5869, 5966);
            CallChecker.varInit(this.y, "y", 170, 5869, 5966);
            CallChecker.varInit(this.x, "x", 170, 5869, 5966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 170, 5869, 5966);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 170, 5869, 5966);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 170, 5869, 5966);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 170, 5869, 5966);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 170, 5869, 5966);
            return Euclidean2D.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Space) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1662.methodEnd();
        }
    }

    public Vector2D getZero() {
        MethodContext _bcornu_methode_context1663 = new MethodContext(Vector2D.class, 175, 5973, 6051);
        try {
            CallChecker.varInit(this, "this", 175, 5973, 6051);
            CallChecker.varInit(this.y, "y", 175, 5973, 6051);
            CallChecker.varInit(this.x, "x", 175, 5973, 6051);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 175, 5973, 6051);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 175, 5973, 6051);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 175, 5973, 6051);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 175, 5973, 6051);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 175, 5973, 6051);
            return Vector2D.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1663.methodEnd();
        }
    }

    public double getNorm1() {
        MethodContext _bcornu_methode_context1664 = new MethodContext(double.class, 180, 6058, 6164);
        try {
            CallChecker.varInit(this, "this", 180, 6058, 6164);
            CallChecker.varInit(this.y, "y", 180, 6058, 6164);
            CallChecker.varInit(this.x, "x", 180, 6058, 6164);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 180, 6058, 6164);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 180, 6058, 6164);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 180, 6058, 6164);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 180, 6058, 6164);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 180, 6058, 6164);
            return (FastMath.abs(x)) + (FastMath.abs(y));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1664.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context1665 = new MethodContext(double.class, 185, 6171, 6272);
        try {
            CallChecker.varInit(this, "this", 185, 6171, 6272);
            CallChecker.varInit(this.y, "y", 185, 6171, 6272);
            CallChecker.varInit(this.x, "x", 185, 6171, 6272);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 185, 6171, 6272);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 185, 6171, 6272);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 185, 6171, 6272);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 185, 6171, 6272);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 185, 6171, 6272);
            return FastMath.sqrt((((x) * (x)) + ((y) * (y))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1665.methodEnd();
        }
    }

    public double getNormSq() {
        MethodContext _bcornu_methode_context1666 = new MethodContext(double.class, 190, 6279, 6366);
        try {
            CallChecker.varInit(this, "this", 190, 6279, 6366);
            CallChecker.varInit(this.y, "y", 190, 6279, 6366);
            CallChecker.varInit(this.x, "x", 190, 6279, 6366);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 190, 6279, 6366);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 190, 6279, 6366);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 190, 6279, 6366);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 190, 6279, 6366);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 190, 6279, 6366);
            return ((x) * (x)) + ((y) * (y));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1666.methodEnd();
        }
    }

    public double getNormInf() {
        MethodContext _bcornu_methode_context1667 = new MethodContext(double.class, 195, 6373, 6494);
        try {
            CallChecker.varInit(this, "this", 195, 6373, 6494);
            CallChecker.varInit(this.y, "y", 195, 6373, 6494);
            CallChecker.varInit(this.x, "x", 195, 6373, 6494);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 195, 6373, 6494);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 195, 6373, 6494);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 195, 6373, 6494);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 195, 6373, 6494);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 195, 6373, 6494);
            return FastMath.max(FastMath.abs(x), FastMath.abs(y));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1667.methodEnd();
        }
    }

    public Vector2D add(Vector<Euclidean2D> v) {
        MethodContext _bcornu_methode_context1668 = new MethodContext(Vector2D.class, 200, 6501, 6670);
        try {
            CallChecker.varInit(this, "this", 200, 6501, 6670);
            CallChecker.varInit(v, "v", 200, 6501, 6670);
            CallChecker.varInit(this.y, "y", 200, 6501, 6670);
            CallChecker.varInit(this.x, "x", 200, 6501, 6670);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 200, 6501, 6670);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 200, 6501, 6670);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 200, 6501, 6670);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 200, 6501, 6670);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 200, 6501, 6670);
            Vector2D v2 = CallChecker.varInit(((Vector2D) (v)), "v2", 201, 6579, 6605);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 202, 6639, 6640);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 202, 6654, 6655);
            return new Vector2D(((x) + (CallChecker.isCalled(v2, Vector2D.class, 202, 6639, 6640).getX())), ((y) + (CallChecker.isCalled(v2, Vector2D.class, 202, 6654, 6655).getY())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1668.methodEnd();
        }
    }

    public Vector2D add(double factor, Vector<Euclidean2D> v) {
        MethodContext _bcornu_methode_context1669 = new MethodContext(Vector2D.class, 206, 6677, 6879);
        try {
            CallChecker.varInit(this, "this", 206, 6677, 6879);
            CallChecker.varInit(v, "v", 206, 6677, 6879);
            CallChecker.varInit(factor, "factor", 206, 6677, 6879);
            CallChecker.varInit(this.y, "y", 206, 6677, 6879);
            CallChecker.varInit(this.x, "x", 206, 6677, 6879);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 206, 6677, 6879);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 206, 6677, 6879);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 206, 6677, 6879);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 206, 6677, 6879);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 206, 6677, 6879);
            Vector2D v2 = CallChecker.varInit(((Vector2D) (v)), "v2", 207, 6770, 6796);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 208, 6839, 6840);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 208, 6863, 6864);
            return new Vector2D(((x) + (factor * (CallChecker.isCalled(v2, Vector2D.class, 208, 6839, 6840).getX()))), ((y) + (factor * (CallChecker.isCalled(v2, Vector2D.class, 208, 6863, 6864).getY()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1669.methodEnd();
        }
    }

    public Vector2D subtract(Vector<Euclidean2D> p) {
        MethodContext _bcornu_methode_context1670 = new MethodContext(Vector2D.class, 212, 6886, 7050);
        try {
            CallChecker.varInit(this, "this", 212, 6886, 7050);
            CallChecker.varInit(p, "p", 212, 6886, 7050);
            CallChecker.varInit(this.y, "y", 212, 6886, 7050);
            CallChecker.varInit(this.x, "x", 212, 6886, 7050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 212, 6886, 7050);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 212, 6886, 7050);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 212, 6886, 7050);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 212, 6886, 7050);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 212, 6886, 7050);
            Vector2D p3 = CallChecker.varInit(((Vector2D) (p)), "p3", 213, 6969, 6995);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 214, 7029, 7030);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 214, 7039, 7040);
            return new Vector2D(((x) - (CallChecker.isCalled(p3, Vector2D.class, 214, 7029, 7030).x)), ((y) - (CallChecker.isCalled(p3, Vector2D.class, 214, 7039, 7040).y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1670.methodEnd();
        }
    }

    public Vector2D subtract(double factor, Vector<Euclidean2D> v) {
        MethodContext _bcornu_methode_context1671 = new MethodContext(Vector2D.class, 218, 7057, 7264);
        try {
            CallChecker.varInit(this, "this", 218, 7057, 7264);
            CallChecker.varInit(v, "v", 218, 7057, 7264);
            CallChecker.varInit(factor, "factor", 218, 7057, 7264);
            CallChecker.varInit(this.y, "y", 218, 7057, 7264);
            CallChecker.varInit(this.x, "x", 218, 7057, 7264);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 218, 7057, 7264);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 218, 7057, 7264);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 218, 7057, 7264);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 218, 7057, 7264);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 218, 7057, 7264);
            Vector2D v2 = CallChecker.varInit(((Vector2D) (v)), "v2", 219, 7155, 7181);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 220, 7224, 7225);
            v2 = CallChecker.beforeCalled(v2, Vector2D.class, 220, 7248, 7249);
            return new Vector2D(((x) - (factor * (CallChecker.isCalled(v2, Vector2D.class, 220, 7224, 7225).getX()))), ((y) - (factor * (CallChecker.isCalled(v2, Vector2D.class, 220, 7248, 7249).getY()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1671.methodEnd();
        }
    }

    public Vector2D normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context1672 = new MethodContext(Vector2D.class, 224, 7271, 7562);
        try {
            CallChecker.varInit(this, "this", 224, 7271, 7562);
            CallChecker.varInit(this.y, "y", 224, 7271, 7562);
            CallChecker.varInit(this.x, "x", 224, 7271, 7562);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 224, 7271, 7562);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 224, 7271, 7562);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 224, 7271, 7562);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 224, 7271, 7562);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 224, 7271, 7562);
            double s = CallChecker.varInit(((double) (getNorm())), "s", 225, 7365, 7385);
            if (s == 0) {
                throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
            }
            return scalarMultiply((1 / s));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1672.methodEnd();
        }
    }

    public Vector2D negate() {
        MethodContext _bcornu_methode_context1673 = new MethodContext(Vector2D.class, 232, 7568, 7661);
        try {
            CallChecker.varInit(this, "this", 232, 7568, 7661);
            CallChecker.varInit(this.y, "y", 232, 7568, 7661);
            CallChecker.varInit(this.x, "x", 232, 7568, 7661);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 232, 7568, 7661);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 232, 7568, 7661);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 232, 7568, 7661);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 232, 7568, 7661);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 232, 7568, 7661);
            return new Vector2D((-(x)), (-(y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1673.methodEnd();
        }
    }

    public Vector2D scalarMultiply(double a) {
        MethodContext _bcornu_methode_context1674 = new MethodContext(Vector2D.class, 237, 7668, 7783);
        try {
            CallChecker.varInit(this, "this", 237, 7668, 7783);
            CallChecker.varInit(a, "a", 237, 7668, 7783);
            CallChecker.varInit(this.y, "y", 237, 7668, 7783);
            CallChecker.varInit(this.x, "x", 237, 7668, 7783);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 237, 7668, 7783);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 237, 7668, 7783);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 237, 7668, 7783);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 237, 7668, 7783);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 237, 7668, 7783);
            return new Vector2D((a * (x)), (a * (y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1674.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context1675 = new MethodContext(boolean.class, 242, 7790, 7895);
        try {
            CallChecker.varInit(this, "this", 242, 7790, 7895);
            CallChecker.varInit(this.y, "y", 242, 7790, 7895);
            CallChecker.varInit(this.x, "x", 242, 7790, 7895);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 242, 7790, 7895);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 242, 7790, 7895);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 242, 7790, 7895);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 242, 7790, 7895);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 242, 7790, 7895);
            return (Double.isNaN(x)) || (Double.isNaN(y));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1675.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context1676 = new MethodContext(boolean.class, 247, 7902, 8036);
        try {
            CallChecker.varInit(this, "this", 247, 7902, 8036);
            CallChecker.varInit(this.y, "y", 247, 7902, 8036);
            CallChecker.varInit(this.x, "x", 247, 7902, 8036);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 247, 7902, 8036);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 247, 7902, 8036);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 247, 7902, 8036);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 247, 7902, 8036);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 247, 7902, 8036);
            return (!(isNaN())) && ((Double.isInfinite(x)) || (Double.isInfinite(y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1676.methodEnd();
        }
    }

    public double distance1(Vector<Euclidean2D> p) {
        MethodContext _bcornu_methode_context1677 = new MethodContext(double.class, 252, 8043, 8281);
        try {
            CallChecker.varInit(this, "this", 252, 8043, 8281);
            CallChecker.varInit(p, "p", 252, 8043, 8281);
            CallChecker.varInit(this.y, "y", 252, 8043, 8281);
            CallChecker.varInit(this.x, "x", 252, 8043, 8281);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 252, 8043, 8281);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 252, 8043, 8281);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 252, 8043, 8281);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 252, 8043, 8281);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 252, 8043, 8281);
            Vector2D p3 = CallChecker.varInit(((Vector2D) (p)), "p3", 253, 8125, 8151);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 254, 8192, 8193);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector2D.class, 254, 8192, 8193).x) - (this.x))))), "dx", 254, 8161, 8201);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 255, 8242, 8243);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector2D.class, 255, 8242, 8243).y) - (this.y))))), "dy", 255, 8211, 8251);
            return dx + dy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1677.methodEnd();
        }
    }

    public double distance(Vector<Euclidean2D> p) {
        MethodContext _bcornu_methode_context1678 = new MethodContext(double.class, 260, 8288, 8522);
        try {
            CallChecker.varInit(this, "this", 260, 8288, 8522);
            CallChecker.varInit(p, "p", 260, 8288, 8522);
            CallChecker.varInit(this.y, "y", 260, 8288, 8522);
            CallChecker.varInit(this.x, "x", 260, 8288, 8522);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 260, 8288, 8522);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 260, 8288, 8522);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 260, 8288, 8522);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 260, 8288, 8522);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 260, 8288, 8522);
            Vector2D p3 = CallChecker.varInit(((Vector2D) (p)), "p3", 261, 8369, 8395);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 262, 8423, 8424);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector2D.class, 262, 8423, 8424).x) - (this.x))), "dx", 262, 8405, 8431);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 263, 8459, 8460);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector2D.class, 263, 8459, 8460).y) - (this.y))), "dy", 263, 8441, 8467);
            return FastMath.sqrt(((dx * dx) + (dy * dy)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1678.methodEnd();
        }
    }

    public double distanceInf(Vector<Euclidean2D> p) {
        MethodContext _bcornu_methode_context1679 = new MethodContext(double.class, 268, 8529, 8782);
        try {
            CallChecker.varInit(this, "this", 268, 8529, 8782);
            CallChecker.varInit(p, "p", 268, 8529, 8782);
            CallChecker.varInit(this.y, "y", 268, 8529, 8782);
            CallChecker.varInit(this.x, "x", 268, 8529, 8782);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 268, 8529, 8782);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 268, 8529, 8782);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 268, 8529, 8782);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 268, 8529, 8782);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 268, 8529, 8782);
            Vector2D p3 = CallChecker.varInit(((Vector2D) (p)), "p3", 269, 8613, 8639);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 270, 8680, 8681);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector2D.class, 270, 8680, 8681).x) - (this.x))))), "dx", 270, 8649, 8689);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 271, 8730, 8731);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(p3, Vector2D.class, 271, 8730, 8731).y) - (this.y))))), "dy", 271, 8699, 8739);
            return FastMath.max(dx, dy);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1679.methodEnd();
        }
    }

    public double distanceSq(Vector<Euclidean2D> p) {
        MethodContext _bcornu_methode_context1680 = new MethodContext(double.class, 276, 8789, 9010);
        try {
            CallChecker.varInit(this, "this", 276, 8789, 9010);
            CallChecker.varInit(p, "p", 276, 8789, 9010);
            CallChecker.varInit(this.y, "y", 276, 8789, 9010);
            CallChecker.varInit(this.x, "x", 276, 8789, 9010);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 276, 8789, 9010);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 276, 8789, 9010);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 276, 8789, 9010);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 276, 8789, 9010);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 276, 8789, 9010);
            Vector2D p3 = CallChecker.varInit(((Vector2D) (p)), "p3", 277, 8872, 8898);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 278, 8926, 8927);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector2D.class, 278, 8926, 8927).x) - (this.x))), "dx", 278, 8908, 8934);
            p3 = CallChecker.beforeCalled(p3, Vector2D.class, 279, 8962, 8963);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(p3, Vector2D.class, 279, 8962, 8963).y) - (this.y))), "dy", 279, 8944, 8970);
            return (dx * dx) + (dy * dy);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1680.methodEnd();
        }
    }

    public double dotProduct(final Vector<Euclidean2D> v) {
        MethodContext _bcornu_methode_context1681 = new MethodContext(double.class, 284, 9017, 9180);
        try {
            CallChecker.varInit(this, "this", 284, 9017, 9180);
            CallChecker.varInit(v, "v", 284, 9017, 9180);
            CallChecker.varInit(this.y, "y", 284, 9017, 9180);
            CallChecker.varInit(this.x, "x", 284, 9017, 9180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 284, 9017, 9180);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 284, 9017, 9180);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 284, 9017, 9180);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 284, 9017, 9180);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 284, 9017, 9180);
            final Vector2D v2 = CallChecker.varInit(((Vector2D) (v)), "v2", 285, 9106, 9138);
            return ((x) * (CallChecker.isCalled(v2, Vector2D.class, 286, 9159, 9160).x)) + ((y) * (CallChecker.isCalled(v2, Vector2D.class, 286, 9170, 9171).y));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1681.methodEnd();
        }
    }

    public static double distance(Vector2D p1, Vector2D p2) {
        MethodContext _bcornu_methode_context1682 = new MethodContext(double.class, 297, 9187, 9675);
        try {
            CallChecker.varInit(p2, "p2", 297, 9187, 9675);
            CallChecker.varInit(p1, "p1", 297, 9187, 9675);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 297, 9187, 9675);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 297, 9187, 9675);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 297, 9187, 9675);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 297, 9187, 9675);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 297, 9187, 9675);
            if (CallChecker.beforeDeref(p1, Vector2D.class, 298, 9654, 9655)) {
                p1 = CallChecker.beforeCalled(p1, Vector2D.class, 298, 9654, 9655);
                return CallChecker.isCalled(p1, Vector2D.class, 298, 9654, 9655).distance(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1682.methodEnd();
        }
    }

    public static double distanceInf(Vector2D p1, Vector2D p2) {
        MethodContext _bcornu_methode_context1683 = new MethodContext(double.class, 309, 9682, 10191);
        try {
            CallChecker.varInit(p2, "p2", 309, 9682, 10191);
            CallChecker.varInit(p1, "p1", 309, 9682, 10191);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 309, 9682, 10191);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 309, 9682, 10191);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 309, 9682, 10191);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 309, 9682, 10191);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 309, 9682, 10191);
            if (CallChecker.beforeDeref(p1, Vector2D.class, 310, 10167, 10168)) {
                p1 = CallChecker.beforeCalled(p1, Vector2D.class, 310, 10167, 10168);
                return CallChecker.isCalled(p1, Vector2D.class, 310, 10167, 10168).distanceInf(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1683.methodEnd();
        }
    }

    public static double distanceSq(Vector2D p1, Vector2D p2) {
        MethodContext _bcornu_methode_context1684 = new MethodContext(double.class, 321, 10198, 10648);
        try {
            CallChecker.varInit(p2, "p2", 321, 10198, 10648);
            CallChecker.varInit(p1, "p1", 321, 10198, 10648);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 321, 10198, 10648);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 321, 10198, 10648);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 321, 10198, 10648);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 321, 10198, 10648);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 321, 10198, 10648);
            if (CallChecker.beforeDeref(p1, Vector2D.class, 322, 10625, 10626)) {
                p1 = CallChecker.beforeCalled(p1, Vector2D.class, 322, 10625, 10626);
                return CallChecker.isCalled(p1, Vector2D.class, 322, 10625, 10626).distanceSq(p2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1684.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context1685 = new MethodContext(boolean.class, 345, 10655, 11812);
        try {
            CallChecker.varInit(this, "this", 345, 10655, 11812);
            CallChecker.varInit(other, "other", 345, 10655, 11812);
            CallChecker.varInit(this.y, "y", 345, 10655, 11812);
            CallChecker.varInit(this.x, "x", 345, 10655, 11812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 345, 10655, 11812);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 345, 10655, 11812);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 345, 10655, 11812);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 345, 10655, 11812);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 345, 10655, 11812);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Vector2D) {
                final Vector2D rhs = CallChecker.varInit(((Vector2D) (other)), "rhs", 352, 11606, 11642);
                if (CallChecker.beforeDeref(rhs, Vector2D.class, 353, 11660, 11662)) {
                    if (CallChecker.isCalled(rhs, Vector2D.class, 353, 11660, 11662).isNaN()) {
                        return this.isNaN();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return ((x) == (CallChecker.isCalled(rhs, Vector2D.class, 357, 11752, 11754).x)) && ((y) == (CallChecker.isCalled(rhs, Vector2D.class, 357, 11768, 11770).y));
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1685.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1686 = new MethodContext(int.class, 370, 11819, 12161);
        try {
            CallChecker.varInit(this, "this", 370, 11819, 12161);
            CallChecker.varInit(this.y, "y", 370, 11819, 12161);
            CallChecker.varInit(this.x, "x", 370, 11819, 12161);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 370, 11819, 12161);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 370, 11819, 12161);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 370, 11819, 12161);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 370, 11819, 12161);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 370, 11819, 12161);
            if (isNaN()) {
                return 542;
            }
            return 122 * ((76 * (MathUtils.hash(x))) + (MathUtils.hash(y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1686.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1687 = new MethodContext(String.class, 381, 12168, 12385);
        try {
            CallChecker.varInit(this, "this", 381, 12168, 12385);
            CallChecker.varInit(this.y, "y", 381, 12168, 12385);
            CallChecker.varInit(this.x, "x", 381, 12168, 12385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 381, 12168, 12385);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 381, 12168, 12385);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 381, 12168, 12385);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 381, 12168, 12385);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 381, 12168, 12385);
            final Vector2DFormat npe_invocation_var156 = Vector2DFormat.getInstance();
            if (CallChecker.beforeDeref(npe_invocation_var156, Vector2DFormat.class, 382, 12338, 12365)) {
                return CallChecker.isCalled(npe_invocation_var156, Vector2DFormat.class, 382, 12338, 12365).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1687.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context1688 = new MethodContext(String.class, 386, 12392, 12529);
        try {
            CallChecker.varInit(this, "this", 386, 12392, 12529);
            CallChecker.varInit(format, "format", 386, 12392, 12529);
            CallChecker.varInit(this.y, "y", 386, 12392, 12529);
            CallChecker.varInit(this.x, "x", 386, 12392, 12529);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.serialVersionUID", 386, 12392, 12529);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NEGATIVE_INFINITY", 386, 12392, 12529);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.POSITIVE_INFINITY", 386, 12392, 12529);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.NaN", 386, 12392, 12529);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.twod.Vector2D.ZERO", 386, 12392, 12529);
            if (CallChecker.beforeDeref(new Vector2DFormat(format), Vector2DFormat.class, 387, 12484, 12509)) {
                return CallChecker.isCalled(new Vector2DFormat(format), Vector2DFormat.class, 387, 12484, 12509).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1688.methodEnd();
        }
    }
}

