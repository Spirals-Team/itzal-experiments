package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class Vector3D implements Serializable , Vector<Euclidean3D> {
    public static final Vector3D ZERO = new Vector3D(0, 0, 0);

    public static final Vector3D PLUS_I = new Vector3D(1, 0, 0);

    public static final Vector3D MINUS_I = new Vector3D((-1), 0, 0);

    public static final Vector3D PLUS_J = new Vector3D(0, 1, 0);

    public static final Vector3D MINUS_J = new Vector3D(0, (-1), 0);

    public static final Vector3D PLUS_K = new Vector3D(0, 0, 1);

    public static final Vector3D MINUS_K = new Vector3D(0, 0, (-1));

    public static final Vector3D NaN = new Vector3D(Double.NaN, Double.NaN, Double.NaN);

    public static final Vector3D POSITIVE_INFINITY = new Vector3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

    public static final Vector3D NEGATIVE_INFINITY = new Vector3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

    private static final long serialVersionUID = 1313493323784566947L;

    private final double x;

    private final double y;

    private final double z;

    public Vector3D(double x, double y, double z) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(Vector3D.class, 95, 3502, 3826);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 96, 3770, 3780);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 97, 3790, 3800);
            this.z = z;
            CallChecker.varAssign(this.z, "this.z", 98, 3810, 3820);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public Vector3D(double[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(Vector3D.class, 107, 3833, 4287);
        try {
            if ((v.length) != 3) {
                throw new DimensionMismatchException(v.length, 3);
            }
            this.x = v[0];
            CallChecker.varAssign(this.x, "this.x", 111, 4222, 4235);
            this.y = v[1];
            CallChecker.varAssign(this.y, "this.y", 112, 4245, 4258);
            this.z = v[2];
            CallChecker.varAssign(this.z, "this.z", 113, 4268, 4281);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public Vector3D(double alpha, double delta) {
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(Vector3D.class, 124, 4294, 4867);
        try {
            double cosDelta = CallChecker.varInit(((double) (FastMath.cos(delta))), "cosDelta", 125, 4688, 4725);
            this.x = (FastMath.cos(alpha)) * cosDelta;
            CallChecker.varAssign(this.x, "this.x", 126, 4735, 4774);
            this.y = (FastMath.sin(alpha)) * cosDelta;
            CallChecker.varAssign(this.y, "this.y", 127, 4784, 4823);
            this.z = FastMath.sin(delta);
            CallChecker.varAssign(this.z, "this.z", 128, 4833, 4861);
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public Vector3D(double a, Vector3D u) {
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(Vector3D.class, 137, 4874, 5204);
        try {
            this.x = a * (u.x);
            CallChecker.varAssign(this.x, "this.x", 138, 5130, 5146);
            this.y = a * (u.y);
            CallChecker.varAssign(this.y, "this.y", 139, 5156, 5172);
            this.z = a * (u.z);
            CallChecker.varAssign(this.z, "this.z", 140, 5182, 5198);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2) {
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(Vector3D.class, 151, 5211, 5808);
        try {
            this.x = MathArrays.linearCombination(a1, u1.x, a2, u2.x);
            CallChecker.varAssign(this.x, "this.x", 152, 5611, 5668);
            this.y = MathArrays.linearCombination(a1, u1.y, a2, u2.y);
            CallChecker.varAssign(this.y, "this.y", 153, 5678, 5735);
            this.z = MathArrays.linearCombination(a1, u1.z, a2, u2.z);
            CallChecker.varAssign(this.z, "this.z", 154, 5745, 5802);
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3) {
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(Vector3D.class, 167, 5815, 6580);
        try {
            this.x = MathArrays.linearCombination(a1, u1.x, a2, u2.x, a3, u3.x);
            CallChecker.varAssign(this.x, "this.x", 169, 6353, 6420);
            this.y = MathArrays.linearCombination(a1, u1.y, a2, u2.y, a3, u3.y);
            CallChecker.varAssign(this.y, "this.y", 170, 6430, 6497);
            this.z = MathArrays.linearCombination(a1, u1.z, a2, u2.z, a3, u3.z);
            CallChecker.varAssign(this.z, "this.z", 171, 6507, 6574);
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3, double a4, Vector3D u4) {
        ConstructorContext _bcornu_methode_context7 = new ConstructorContext(Vector3D.class, 186, 6587, 7499);
        try {
            this.x = MathArrays.linearCombination(a1, u1.x, a2, u2.x, a3, u3.x, a4, u4.x);
            CallChecker.varAssign(this.x, "this.x", 188, 7242, 7319);
            this.y = MathArrays.linearCombination(a1, u1.y, a2, u2.y, a3, u3.y, a4, u4.y);
            CallChecker.varAssign(this.y, "this.y", 189, 7329, 7406);
            this.z = MathArrays.linearCombination(a1, u1.z, a2, u2.z, a3, u3.z, a4, u4.z);
            CallChecker.varAssign(this.z, "this.z", 190, 7416, 7493);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context1 = new MethodContext(double.class, 197, 7506, 7683);
        try {
            CallChecker.varInit(this, "this", 197, 7506, 7683);
            CallChecker.varInit(this.z, "z", 197, 7506, 7683);
            CallChecker.varInit(this.y, "y", 197, 7506, 7683);
            CallChecker.varInit(this.x, "x", 197, 7506, 7683);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 197, 7506, 7683);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 197, 7506, 7683);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 197, 7506, 7683);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 197, 7506, 7683);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 197, 7506, 7683);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 197, 7506, 7683);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 197, 7506, 7683);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 197, 7506, 7683);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 197, 7506, 7683);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 197, 7506, 7683);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 197, 7506, 7683);
            return x;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public double getY() {
        MethodContext _bcornu_methode_context2 = new MethodContext(double.class, 205, 7690, 7867);
        try {
            CallChecker.varInit(this, "this", 205, 7690, 7867);
            CallChecker.varInit(this.z, "z", 205, 7690, 7867);
            CallChecker.varInit(this.y, "y", 205, 7690, 7867);
            CallChecker.varInit(this.x, "x", 205, 7690, 7867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 205, 7690, 7867);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 205, 7690, 7867);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 205, 7690, 7867);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 205, 7690, 7867);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 205, 7690, 7867);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 205, 7690, 7867);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 205, 7690, 7867);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 205, 7690, 7867);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 205, 7690, 7867);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 205, 7690, 7867);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 205, 7690, 7867);
            return y;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public double getZ() {
        MethodContext _bcornu_methode_context3 = new MethodContext(double.class, 213, 7874, 8047);
        try {
            CallChecker.varInit(this, "this", 213, 7874, 8047);
            CallChecker.varInit(this.z, "z", 213, 7874, 8047);
            CallChecker.varInit(this.y, "y", 213, 7874, 8047);
            CallChecker.varInit(this.x, "x", 213, 7874, 8047);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 213, 7874, 8047);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 213, 7874, 8047);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 213, 7874, 8047);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 213, 7874, 8047);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 213, 7874, 8047);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 213, 7874, 8047);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 213, 7874, 8047);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 213, 7874, 8047);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 213, 7874, 8047);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 213, 7874, 8047);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 213, 7874, 8047);
            return z;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public double[] toArray() {
        MethodContext _bcornu_methode_context4 = new MethodContext(double[].class, 221, 8054, 8260);
        try {
            CallChecker.varInit(this, "this", 221, 8054, 8260);
            CallChecker.varInit(this.z, "z", 221, 8054, 8260);
            CallChecker.varInit(this.y, "y", 221, 8054, 8260);
            CallChecker.varInit(this.x, "x", 221, 8054, 8260);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 221, 8054, 8260);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 221, 8054, 8260);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 221, 8054, 8260);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 221, 8054, 8260);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 221, 8054, 8260);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 221, 8054, 8260);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 221, 8054, 8260);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 221, 8054, 8260);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 221, 8054, 8260);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 221, 8054, 8260);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 221, 8054, 8260);
            return new double[]{ x , y , z };
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[]) (CallChecker.isToCatch(_bcornu_return_t, double[].class)));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public Space getSpace() {
        MethodContext _bcornu_methode_context5 = new MethodContext(Space.class, 226, 8267, 8364);
        try {
            CallChecker.varInit(this, "this", 226, 8267, 8364);
            CallChecker.varInit(this.z, "z", 226, 8267, 8364);
            CallChecker.varInit(this.y, "y", 226, 8267, 8364);
            CallChecker.varInit(this.x, "x", 226, 8267, 8364);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 226, 8267, 8364);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 226, 8267, 8364);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 226, 8267, 8364);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 226, 8267, 8364);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 226, 8267, 8364);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 226, 8267, 8364);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 226, 8267, 8364);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 226, 8267, 8364);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 226, 8267, 8364);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 226, 8267, 8364);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 226, 8267, 8364);
            return Euclidean3D.getInstance();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Space) (CallChecker.isToCatch(_bcornu_return_t, Space.class)));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public Vector3D getZero() {
        MethodContext _bcornu_methode_context6 = new MethodContext(Vector3D.class, 231, 8371, 8449);
        try {
            CallChecker.varInit(this, "this", 231, 8371, 8449);
            CallChecker.varInit(this.z, "z", 231, 8371, 8449);
            CallChecker.varInit(this.y, "y", 231, 8371, 8449);
            CallChecker.varInit(this.x, "x", 231, 8371, 8449);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 231, 8371, 8449);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 231, 8371, 8449);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 231, 8371, 8449);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 231, 8371, 8449);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 231, 8371, 8449);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 231, 8371, 8449);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 231, 8371, 8449);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 231, 8371, 8449);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 231, 8371, 8449);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 231, 8371, 8449);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 231, 8371, 8449);
            return Vector3D.ZERO;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public double getNorm1() {
        MethodContext _bcornu_methode_context7 = new MethodContext(double.class, 236, 8456, 8580);
        try {
            CallChecker.varInit(this, "this", 236, 8456, 8580);
            CallChecker.varInit(this.z, "z", 236, 8456, 8580);
            CallChecker.varInit(this.y, "y", 236, 8456, 8580);
            CallChecker.varInit(this.x, "x", 236, 8456, 8580);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 236, 8456, 8580);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 236, 8456, 8580);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 236, 8456, 8580);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 236, 8456, 8580);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 236, 8456, 8580);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 236, 8456, 8580);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 236, 8456, 8580);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 236, 8456, 8580);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 236, 8456, 8580);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 236, 8456, 8580);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 236, 8456, 8580);
            return ((FastMath.abs(x)) + (FastMath.abs(y))) + (FastMath.abs(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context8 = new MethodContext(double.class, 241, 8587, 8786);
        try {
            CallChecker.varInit(this, "this", 241, 8587, 8786);
            CallChecker.varInit(this.z, "z", 241, 8587, 8786);
            CallChecker.varInit(this.y, "y", 241, 8587, 8786);
            CallChecker.varInit(this.x, "x", 241, 8587, 8786);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 241, 8587, 8786);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 241, 8587, 8786);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 241, 8587, 8786);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 241, 8587, 8786);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 241, 8587, 8786);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 241, 8587, 8786);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 241, 8587, 8786);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 241, 8587, 8786);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 241, 8587, 8786);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 241, 8587, 8786);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 241, 8587, 8786);
            return FastMath.sqrt(((((x) * (x)) + ((y) * (y))) + ((z) * (z))));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public double getNormSq() {
        MethodContext _bcornu_methode_context9 = new MethodContext(double.class, 247, 8793, 8978);
        try {
            CallChecker.varInit(this, "this", 247, 8793, 8978);
            CallChecker.varInit(this.z, "z", 247, 8793, 8978);
            CallChecker.varInit(this.y, "y", 247, 8793, 8978);
            CallChecker.varInit(this.x, "x", 247, 8793, 8978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 247, 8793, 8978);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 247, 8793, 8978);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 247, 8793, 8978);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 247, 8793, 8978);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 247, 8793, 8978);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 247, 8793, 8978);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 247, 8793, 8978);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 247, 8793, 8978);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 247, 8793, 8978);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 247, 8793, 8978);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 247, 8793, 8978);
            return (((x) * (x)) + ((y) * (y))) + ((z) * (z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public double getNormInf() {
        MethodContext _bcornu_methode_context10 = new MethodContext(double.class, 253, 8985, 9137);
        try {
            CallChecker.varInit(this, "this", 253, 8985, 9137);
            CallChecker.varInit(this.z, "z", 253, 8985, 9137);
            CallChecker.varInit(this.y, "y", 253, 8985, 9137);
            CallChecker.varInit(this.x, "x", 253, 8985, 9137);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 253, 8985, 9137);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 253, 8985, 9137);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 253, 8985, 9137);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 253, 8985, 9137);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 253, 8985, 9137);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 253, 8985, 9137);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 253, 8985, 9137);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 253, 8985, 9137);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 253, 8985, 9137);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 253, 8985, 9137);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 253, 8985, 9137);
            return FastMath.max(FastMath.max(FastMath.abs(x), FastMath.abs(y)), FastMath.abs(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public double getAlpha() {
        MethodContext _bcornu_methode_context11 = new MethodContext(double.class, 261, 9144, 9369);
        try {
            CallChecker.varInit(this, "this", 261, 9144, 9369);
            CallChecker.varInit(this.z, "z", 261, 9144, 9369);
            CallChecker.varInit(this.y, "y", 261, 9144, 9369);
            CallChecker.varInit(this.x, "x", 261, 9144, 9369);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 261, 9144, 9369);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 261, 9144, 9369);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 261, 9144, 9369);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 261, 9144, 9369);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 261, 9144, 9369);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 261, 9144, 9369);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 261, 9144, 9369);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 261, 9144, 9369);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 261, 9144, 9369);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 261, 9144, 9369);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 261, 9144, 9369);
            return FastMath.atan2(y, x);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public double getDelta() {
        MethodContext _bcornu_methode_context12 = new MethodContext(double.class, 269, 9376, 9617);
        try {
            CallChecker.varInit(this, "this", 269, 9376, 9617);
            CallChecker.varInit(this.z, "z", 269, 9376, 9617);
            CallChecker.varInit(this.y, "y", 269, 9376, 9617);
            CallChecker.varInit(this.x, "x", 269, 9376, 9617);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 269, 9376, 9617);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 269, 9376, 9617);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 269, 9376, 9617);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 269, 9376, 9617);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 269, 9376, 9617);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 269, 9376, 9617);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 269, 9376, 9617);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 269, 9376, 9617);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 269, 9376, 9617);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 269, 9376, 9617);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 269, 9376, 9617);
            return FastMath.asin(((z) / (getNorm())));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public Vector3D add(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context13 = new MethodContext(Vector3D.class, 274, 9624, 9805);
        try {
            CallChecker.varInit(this, "this", 274, 9624, 9805);
            CallChecker.varInit(v, "v", 274, 9624, 9805);
            CallChecker.varInit(this.z, "z", 274, 9624, 9805);
            CallChecker.varInit(this.y, "y", 274, 9624, 9805);
            CallChecker.varInit(this.x, "x", 274, 9624, 9805);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 274, 9624, 9805);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 274, 9624, 9805);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 274, 9624, 9805);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 274, 9624, 9805);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 274, 9624, 9805);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 274, 9624, 9805);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 274, 9624, 9805);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 274, 9624, 9805);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 274, 9624, 9805);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 274, 9624, 9805);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 274, 9624, 9805);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 275, 9708, 9740);
            return new Vector3D(((x) + (v3.x)), ((y) + (v3.y)), ((z) + (v3.z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public Vector3D add(double factor, final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context14 = new MethodContext(Vector3D.class, 280, 9812, 9967);
        try {
            CallChecker.varInit(this, "this", 280, 9812, 9967);
            CallChecker.varInit(v, "v", 280, 9812, 9967);
            CallChecker.varInit(factor, "factor", 280, 9812, 9967);
            CallChecker.varInit(this.z, "z", 280, 9812, 9967);
            CallChecker.varInit(this.y, "y", 280, 9812, 9967);
            CallChecker.varInit(this.x, "x", 280, 9812, 9967);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 280, 9812, 9967);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 280, 9812, 9967);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 280, 9812, 9967);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 280, 9812, 9967);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 280, 9812, 9967);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 280, 9812, 9967);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 280, 9812, 9967);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 280, 9812, 9967);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 280, 9812, 9967);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 280, 9812, 9967);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 280, 9812, 9967);
            return new Vector3D(1, this, factor, ((Vector3D) (v)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public Vector3D subtract(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context15 = new MethodContext(Vector3D.class, 285, 9974, 10160);
        try {
            CallChecker.varInit(this, "this", 285, 9974, 10160);
            CallChecker.varInit(v, "v", 285, 9974, 10160);
            CallChecker.varInit(this.z, "z", 285, 9974, 10160);
            CallChecker.varInit(this.y, "y", 285, 9974, 10160);
            CallChecker.varInit(this.x, "x", 285, 9974, 10160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 285, 9974, 10160);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 285, 9974, 10160);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 285, 9974, 10160);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 285, 9974, 10160);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 285, 9974, 10160);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 285, 9974, 10160);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 285, 9974, 10160);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 285, 9974, 10160);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 285, 9974, 10160);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 285, 9974, 10160);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 285, 9974, 10160);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 286, 10063, 10095);
            return new Vector3D(((x) - (v3.x)), ((y) - (v3.y)), ((z) - (v3.z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public Vector3D subtract(final double factor, final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context16 = new MethodContext(Vector3D.class, 291, 10167, 10334);
        try {
            CallChecker.varInit(this, "this", 291, 10167, 10334);
            CallChecker.varInit(v, "v", 291, 10167, 10334);
            CallChecker.varInit(factor, "factor", 291, 10167, 10334);
            CallChecker.varInit(this.z, "z", 291, 10167, 10334);
            CallChecker.varInit(this.y, "y", 291, 10167, 10334);
            CallChecker.varInit(this.x, "x", 291, 10167, 10334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 291, 10167, 10334);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 291, 10167, 10334);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 291, 10167, 10334);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 291, 10167, 10334);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 291, 10167, 10334);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 291, 10167, 10334);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 291, 10167, 10334);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 291, 10167, 10334);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 291, 10167, 10334);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 291, 10167, 10334);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 291, 10167, 10334);
            return new Vector3D(1, this, (-factor), ((Vector3D) (v)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public Vector3D normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context17 = new MethodContext(Vector3D.class, 296, 10341, 10632);
        try {
            CallChecker.varInit(this, "this", 296, 10341, 10632);
            CallChecker.varInit(this.z, "z", 296, 10341, 10632);
            CallChecker.varInit(this.y, "y", 296, 10341, 10632);
            CallChecker.varInit(this.x, "x", 296, 10341, 10632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 296, 10341, 10632);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 296, 10341, 10632);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 296, 10341, 10632);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 296, 10341, 10632);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 296, 10341, 10632);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 296, 10341, 10632);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 296, 10341, 10632);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 296, 10341, 10632);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 296, 10341, 10632);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 296, 10341, 10632);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 296, 10341, 10632);
            double s = CallChecker.varInit(((double) (getNorm())), "s", 297, 10435, 10455);
            if (s == 0) {
                throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
            }
            return scalarMultiply((1 / s));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public Vector3D orthogonal() throws MathArithmeticException {
        MethodContext _bcornu_methode_context18 = new MethodContext(Vector3D.class, 319, 10639, 12099);
        try {
            CallChecker.varInit(this, "this", 319, 10639, 12099);
            CallChecker.varInit(this.z, "z", 319, 10639, 12099);
            CallChecker.varInit(this.y, "y", 319, 10639, 12099);
            CallChecker.varInit(this.x, "x", 319, 10639, 12099);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 319, 10639, 12099);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 319, 10639, 12099);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 319, 10639, 12099);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 319, 10639, 12099);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 319, 10639, 12099);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 319, 10639, 12099);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 319, 10639, 12099);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 319, 10639, 12099);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 319, 10639, 12099);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 319, 10639, 12099);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 319, 10639, 12099);
            double threshold = CallChecker.varInit(((double) (0.6 * (getNorm()))), "threshold", 321, 11464, 11498);
            if (threshold == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            if ((FastMath.abs(x)) <= threshold) {
                double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.y) * (this.y)) + ((this.z) * (this.z))))))), "inverse", 327, 11672, 11722);
                return new Vector3D(0, (inverse * (z)), ((-inverse) * (y)));
            }else
                if ((FastMath.abs(y)) <= threshold) {
                    double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.x) * (this.x)) + ((this.z) * (this.z))))))), "inverse", 330, 11850, 11900);
                    return new Vector3D(((-inverse) * (z)), 0, (inverse * (x)));
                }
            
            double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.x) * (this.x)) + ((this.y) * (this.y))))))), "inverse", 333, 11983, 12033);
            return new Vector3D((inverse * (y)), ((-inverse) * (x)), 0);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public static double angle(Vector3D v1, Vector3D v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context19 = new MethodContext(double.class, 349, 12106, 13502);
        try {
            CallChecker.varInit(v2, "v2", 349, 12106, 13502);
            CallChecker.varInit(v1, "v1", 349, 12106, 13502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 349, 12106, 13502);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 349, 12106, 13502);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 349, 12106, 13502);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 349, 12106, 13502);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 349, 12106, 13502);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 349, 12106, 13502);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 349, 12106, 13502);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 349, 12106, 13502);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 349, 12106, 13502);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 349, 12106, 13502);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 349, 12106, 13502);
            double normProduct = CallChecker.varInit(((double) ((v1.getNorm()) * (v2.getNorm()))), "normProduct", 351, 12755, 12803);
            if (normProduct == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            double dot = CallChecker.varInit(((double) (v1.dotProduct(v2))), "dot", 356, 12931, 12961);
            double threshold = CallChecker.varInit(((double) (normProduct * 0.9999)), "threshold", 357, 12971, 13010);
            if ((dot < (-threshold)) || (dot > threshold)) {
                Vector3D v3 = CallChecker.varInit(Vector3D.crossProduct(v1, v2), "v3", 360, 13149, 13183);
                if (dot >= 0) {
                    return FastMath.asin(((v3.getNorm()) / normProduct));
                }
                return (FastMath.PI) - (FastMath.asin(((v3.getNorm()) / normProduct)));
            }
            return FastMath.acos((dot / normProduct));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public Vector3D negate() {
        MethodContext _bcornu_methode_context20 = new MethodContext(Vector3D.class, 373, 13509, 13606);
        try {
            CallChecker.varInit(this, "this", 373, 13509, 13606);
            CallChecker.varInit(this.z, "z", 373, 13509, 13606);
            CallChecker.varInit(this.y, "y", 373, 13509, 13606);
            CallChecker.varInit(this.x, "x", 373, 13509, 13606);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 373, 13509, 13606);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 373, 13509, 13606);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 373, 13509, 13606);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 373, 13509, 13606);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 373, 13509, 13606);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 373, 13509, 13606);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 373, 13509, 13606);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 373, 13509, 13606);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 373, 13509, 13606);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 373, 13509, 13606);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 373, 13509, 13606);
            return new Vector3D((-(x)), (-(y)), (-(z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public Vector3D scalarMultiply(double a) {
        MethodContext _bcornu_methode_context21 = new MethodContext(Vector3D.class, 378, 13613, 13735);
        try {
            CallChecker.varInit(this, "this", 378, 13613, 13735);
            CallChecker.varInit(a, "a", 378, 13613, 13735);
            CallChecker.varInit(this.z, "z", 378, 13613, 13735);
            CallChecker.varInit(this.y, "y", 378, 13613, 13735);
            CallChecker.varInit(this.x, "x", 378, 13613, 13735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 378, 13613, 13735);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 378, 13613, 13735);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 378, 13613, 13735);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 378, 13613, 13735);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 378, 13613, 13735);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 378, 13613, 13735);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 378, 13613, 13735);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 378, 13613, 13735);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 378, 13613, 13735);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 378, 13613, 13735);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 378, 13613, 13735);
            return new Vector3D((a * (x)), (a * (y)), (a * (z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class, 383, 13742, 13866);
        try {
            CallChecker.varInit(this, "this", 383, 13742, 13866);
            CallChecker.varInit(this.z, "z", 383, 13742, 13866);
            CallChecker.varInit(this.y, "y", 383, 13742, 13866);
            CallChecker.varInit(this.x, "x", 383, 13742, 13866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 383, 13742, 13866);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 383, 13742, 13866);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 383, 13742, 13866);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 383, 13742, 13866);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 383, 13742, 13866);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 383, 13742, 13866);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 383, 13742, 13866);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 383, 13742, 13866);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 383, 13742, 13866);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 383, 13742, 13866);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 383, 13742, 13866);
            return ((Double.isNaN(x)) || (Double.isNaN(y))) || (Double.isNaN(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context23 = new MethodContext(boolean.class, 388, 13873, 14031);
        try {
            CallChecker.varInit(this, "this", 388, 13873, 14031);
            CallChecker.varInit(this.z, "z", 388, 13873, 14031);
            CallChecker.varInit(this.y, "y", 388, 13873, 14031);
            CallChecker.varInit(this.x, "x", 388, 13873, 14031);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 388, 13873, 14031);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 388, 13873, 14031);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 388, 13873, 14031);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 388, 13873, 14031);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 388, 13873, 14031);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 388, 13873, 14031);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 388, 13873, 14031);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 388, 13873, 14031);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 388, 13873, 14031);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 388, 13873, 14031);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 388, 13873, 14031);
            return (!(isNaN())) && (((Double.isInfinite(x)) || (Double.isInfinite(y))) || (Double.isInfinite(z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context24 = new MethodContext(boolean.class, 412, 14038, 15211);
        try {
            CallChecker.varInit(this, "this", 412, 14038, 15211);
            CallChecker.varInit(other, "other", 412, 14038, 15211);
            CallChecker.varInit(this.z, "z", 412, 14038, 15211);
            CallChecker.varInit(this.y, "y", 412, 14038, 15211);
            CallChecker.varInit(this.x, "x", 412, 14038, 15211);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 412, 14038, 15211);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 412, 14038, 15211);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 412, 14038, 15211);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 412, 14038, 15211);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 412, 14038, 15211);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 412, 14038, 15211);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 412, 14038, 15211);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 412, 14038, 15211);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 412, 14038, 15211);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 412, 14038, 15211);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 412, 14038, 15211);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Vector3D) {
                final Vector3D rhs = CallChecker.varInit(((Vector3D) (other)), "rhs", 419, 14989, 15025);
                if (rhs.isNaN()) {
                    return this.isNaN();
                }
                return (((x) == (rhs.x)) && ((y) == (rhs.y))) && ((z) == (rhs.z));
            }
            return false;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context25 = new MethodContext(int.class, 437, 15218, 15586);
        try {
            CallChecker.varInit(this, "this", 437, 15218, 15586);
            CallChecker.varInit(this.z, "z", 437, 15218, 15586);
            CallChecker.varInit(this.y, "y", 437, 15218, 15586);
            CallChecker.varInit(this.x, "x", 437, 15218, 15586);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 437, 15218, 15586);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 437, 15218, 15586);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 437, 15218, 15586);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 437, 15218, 15586);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 437, 15218, 15586);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 437, 15218, 15586);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 437, 15218, 15586);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 437, 15218, 15586);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 437, 15218, 15586);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 437, 15218, 15586);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 437, 15218, 15586);
            if (isNaN()) {
                return 642;
            }
            return 643 * (((164 * (MathUtils.hash(x))) + (3 * (MathUtils.hash(y)))) + (MathUtils.hash(z)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Integer) (CallChecker.isToCatch(_bcornu_return_t, int.class)));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public double dotProduct(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context26 = new MethodContext(double.class, 452, 15593, 16119);
        try {
            CallChecker.varInit(this, "this", 452, 15593, 16119);
            CallChecker.varInit(v, "v", 452, 15593, 16119);
            CallChecker.varInit(this.z, "z", 452, 15593, 16119);
            CallChecker.varInit(this.y, "y", 452, 15593, 16119);
            CallChecker.varInit(this.x, "x", 452, 15593, 16119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 452, 15593, 16119);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 452, 15593, 16119);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 452, 15593, 16119);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 452, 15593, 16119);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 452, 15593, 16119);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 452, 15593, 16119);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 452, 15593, 16119);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 452, 15593, 16119);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 452, 15593, 16119);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 452, 15593, 16119);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 452, 15593, 16119);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 453, 16009, 16041);
            return MathArrays.linearCombination(x, v3.x, y, v3.y, z, v3.z);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public Vector3D crossProduct(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context27 = new MethodContext(Vector3D.class, 461, 16126, 16632);
        try {
            CallChecker.varInit(this, "this", 461, 16126, 16632);
            CallChecker.varInit(v, "v", 461, 16126, 16632);
            CallChecker.varInit(this.z, "z", 461, 16126, 16632);
            CallChecker.varInit(this.y, "y", 461, 16126, 16632);
            CallChecker.varInit(this.x, "x", 461, 16126, 16632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 461, 16126, 16632);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 461, 16126, 16632);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 461, 16126, 16632);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 461, 16126, 16632);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 461, 16126, 16632);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 461, 16126, 16632);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 461, 16126, 16632);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 461, 16126, 16632);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 461, 16126, 16632);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 461, 16126, 16632);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 461, 16126, 16632);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 462, 16362, 16394);
            return new Vector3D(MathArrays.linearCombination(y, v3.z, (-(z)), v3.y), MathArrays.linearCombination(z, v3.x, (-(x)), v3.z), MathArrays.linearCombination(x, v3.y, (-(y)), v3.x));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public double distance1(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context28 = new MethodContext(double.class, 469, 16639, 16938);
        try {
            CallChecker.varInit(this, "this", 469, 16639, 16938);
            CallChecker.varInit(v, "v", 469, 16639, 16938);
            CallChecker.varInit(this.z, "z", 469, 16639, 16938);
            CallChecker.varInit(this.y, "y", 469, 16639, 16938);
            CallChecker.varInit(this.x, "x", 469, 16639, 16938);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 469, 16639, 16938);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 469, 16639, 16938);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 469, 16639, 16938);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 469, 16639, 16938);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 469, 16639, 16938);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 469, 16639, 16938);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 469, 16639, 16938);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 469, 16639, 16938);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 469, 16639, 16938);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 469, 16639, 16938);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 469, 16639, 16938);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 470, 16721, 16753);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((v3.x) - (this.x))))), "dx", 471, 16763, 16803);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((v3.y) - (this.y))))), "dy", 472, 16813, 16853);
            final double dz = CallChecker.varInit(((double) (FastMath.abs(((v3.z) - (this.z))))), "dz", 473, 16863, 16903);
            return (dx + dy) + dz;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public double distance(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context29 = new MethodContext(double.class, 478, 16945, 17231);
        try {
            CallChecker.varInit(this, "this", 478, 16945, 17231);
            CallChecker.varInit(v, "v", 478, 16945, 17231);
            CallChecker.varInit(this.z, "z", 478, 16945, 17231);
            CallChecker.varInit(this.y, "y", 478, 16945, 17231);
            CallChecker.varInit(this.x, "x", 478, 16945, 17231);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 478, 16945, 17231);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 478, 16945, 17231);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 478, 16945, 17231);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 478, 16945, 17231);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 478, 16945, 17231);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 478, 16945, 17231);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 478, 16945, 17231);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 478, 16945, 17231);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 478, 16945, 17231);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 478, 16945, 17231);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 478, 16945, 17231);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 479, 17026, 17058);
            final double dx = CallChecker.varInit(((double) ((v3.x) - (this.x))), "dx", 480, 17068, 17094);
            final double dy = CallChecker.varInit(((double) ((v3.y) - (this.y))), "dy", 481, 17104, 17130);
            final double dz = CallChecker.varInit(((double) ((v3.z) - (this.z))), "dz", 482, 17140, 17166);
            return FastMath.sqrt((((dx * dx) + (dy * dy)) + (dz * dz)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public double distanceInf(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context30 = new MethodContext(double.class, 487, 17238, 17565);
        try {
            CallChecker.varInit(this, "this", 487, 17238, 17565);
            CallChecker.varInit(v, "v", 487, 17238, 17565);
            CallChecker.varInit(this.z, "z", 487, 17238, 17565);
            CallChecker.varInit(this.y, "y", 487, 17238, 17565);
            CallChecker.varInit(this.x, "x", 487, 17238, 17565);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 487, 17238, 17565);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 487, 17238, 17565);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 487, 17238, 17565);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 487, 17238, 17565);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 487, 17238, 17565);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 487, 17238, 17565);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 487, 17238, 17565);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 487, 17238, 17565);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 487, 17238, 17565);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 487, 17238, 17565);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 487, 17238, 17565);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 488, 17322, 17354);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((v3.x) - (this.x))))), "dx", 489, 17364, 17404);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((v3.y) - (this.y))))), "dy", 490, 17414, 17454);
            final double dz = CallChecker.varInit(((double) (FastMath.abs(((v3.z) - (this.z))))), "dz", 491, 17464, 17504);
            return FastMath.max(FastMath.max(dx, dy), dz);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public double distanceSq(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context31 = new MethodContext(double.class, 496, 17572, 17845);
        try {
            CallChecker.varInit(this, "this", 496, 17572, 17845);
            CallChecker.varInit(v, "v", 496, 17572, 17845);
            CallChecker.varInit(this.z, "z", 496, 17572, 17845);
            CallChecker.varInit(this.y, "y", 496, 17572, 17845);
            CallChecker.varInit(this.x, "x", 496, 17572, 17845);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 496, 17572, 17845);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 496, 17572, 17845);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 496, 17572, 17845);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 496, 17572, 17845);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 496, 17572, 17845);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 496, 17572, 17845);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 496, 17572, 17845);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 496, 17572, 17845);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 496, 17572, 17845);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 496, 17572, 17845);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 496, 17572, 17845);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 497, 17655, 17687);
            final double dx = CallChecker.varInit(((double) ((v3.x) - (this.x))), "dx", 498, 17697, 17723);
            final double dy = CallChecker.varInit(((double) ((v3.y) - (this.y))), "dy", 499, 17733, 17759);
            final double dz = CallChecker.varInit(((double) ((v3.z) - (this.z))), "dz", 500, 17769, 17795);
            return ((dx * dx) + (dy * dy)) + (dz * dz);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context32 = new MethodContext(double.class, 509, 17852, 18104);
        try {
            CallChecker.varInit(v2, "v2", 509, 17852, 18104);
            CallChecker.varInit(v1, "v1", 509, 17852, 18104);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 509, 17852, 18104);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 509, 17852, 18104);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 509, 17852, 18104);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 509, 17852, 18104);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 509, 17852, 18104);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 509, 17852, 18104);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 509, 17852, 18104);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 509, 17852, 18104);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 509, 17852, 18104);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 509, 17852, 18104);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 509, 17852, 18104);
            return v1.dotProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static Vector3D crossProduct(final Vector3D v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context33 = new MethodContext(Vector3D.class, 518, 18111, 18403);
        try {
            CallChecker.varInit(v2, "v2", 518, 18111, 18403);
            CallChecker.varInit(v1, "v1", 518, 18111, 18403);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 518, 18111, 18403);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 518, 18111, 18403);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 518, 18111, 18403);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 518, 18111, 18403);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 518, 18111, 18403);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 518, 18111, 18403);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 518, 18111, 18403);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 518, 18111, 18403);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 518, 18111, 18403);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 518, 18111, 18403);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 518, 18111, 18403);
            return v1.crossProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public static double distance1(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context34 = new MethodContext(double.class, 530, 18410, 18901);
        try {
            CallChecker.varInit(v2, "v2", 530, 18410, 18901);
            CallChecker.varInit(v1, "v1", 530, 18410, 18901);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 530, 18410, 18901);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 530, 18410, 18901);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 530, 18410, 18901);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 530, 18410, 18901);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 530, 18410, 18901);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 530, 18410, 18901);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 530, 18410, 18901);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 530, 18410, 18901);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 530, 18410, 18901);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 530, 18410, 18901);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 530, 18410, 18901);
            return v1.distance1(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public static double distance(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context35 = new MethodContext(double.class, 542, 18908, 19396);
        try {
            CallChecker.varInit(v2, "v2", 542, 18908, 19396);
            CallChecker.varInit(v1, "v1", 542, 18908, 19396);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 542, 18908, 19396);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 542, 18908, 19396);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 542, 18908, 19396);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 542, 18908, 19396);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 542, 18908, 19396);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 542, 18908, 19396);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 542, 18908, 19396);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 542, 18908, 19396);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 542, 18908, 19396);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 542, 18908, 19396);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 542, 18908, 19396);
            return v1.distance(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public static double distanceInf(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context36 = new MethodContext(double.class, 554, 19403, 19912);
        try {
            CallChecker.varInit(v2, "v2", 554, 19403, 19912);
            CallChecker.varInit(v1, "v1", 554, 19403, 19912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 554, 19403, 19912);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 554, 19403, 19912);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 554, 19403, 19912);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 554, 19403, 19912);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 554, 19403, 19912);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 554, 19403, 19912);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 554, 19403, 19912);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 554, 19403, 19912);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 554, 19403, 19912);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 554, 19403, 19912);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 554, 19403, 19912);
            return v1.distanceInf(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public static double distanceSq(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context37 = new MethodContext(double.class, 566, 19919, 20369);
        try {
            CallChecker.varInit(v2, "v2", 566, 19919, 20369);
            CallChecker.varInit(v1, "v1", 566, 19919, 20369);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 566, 19919, 20369);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 566, 19919, 20369);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 566, 19919, 20369);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 566, 19919, 20369);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 566, 19919, 20369);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 566, 19919, 20369);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 566, 19919, 20369);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 566, 19919, 20369);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 566, 19919, 20369);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 566, 19919, 20369);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 566, 19919, 20369);
            return v1.distanceSq(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context38 = new MethodContext(String.class, 574, 20376, 20593);
        try {
            CallChecker.varInit(this, "this", 574, 20376, 20593);
            CallChecker.varInit(this.z, "z", 574, 20376, 20593);
            CallChecker.varInit(this.y, "y", 574, 20376, 20593);
            CallChecker.varInit(this.x, "x", 574, 20376, 20593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 574, 20376, 20593);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 574, 20376, 20593);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 574, 20376, 20593);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 574, 20376, 20593);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 574, 20376, 20593);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 574, 20376, 20593);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 574, 20376, 20593);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 574, 20376, 20593);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 574, 20376, 20593);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 574, 20376, 20593);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 574, 20376, 20593);
            return Vector3DFormat.getInstance().format(this);
        } catch (RuntimeException _bcornu_return_t) {
            return ((String) (CallChecker.isToCatch(_bcornu_return_t, String.class)));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context39 = new MethodContext(String.class, 579, 20600, 20737);
        try {
            CallChecker.varInit(this, "this", 579, 20600, 20737);
            CallChecker.varInit(format, "format", 579, 20600, 20737);
            CallChecker.varInit(this.z, "z", 579, 20600, 20737);
            CallChecker.varInit(this.y, "y", 579, 20600, 20737);
            CallChecker.varInit(this.x, "x", 579, 20600, 20737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 579, 20600, 20737);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 579, 20600, 20737);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 579, 20600, 20737);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 579, 20600, 20737);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 579, 20600, 20737);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 579, 20600, 20737);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 579, 20600, 20737);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 579, 20600, 20737);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 579, 20600, 20737);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 579, 20600, 20737);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 579, 20600, 20737);
            return new Vector3DFormat(format).format(this);
        } catch (RuntimeException _bcornu_return_t) {
            return ((String) (CallChecker.isToCatch(_bcornu_return_t, String.class)));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }
}

