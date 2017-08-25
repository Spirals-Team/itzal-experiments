package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
        ConstructorContext _bcornu_methode_context221 = new ConstructorContext(Vector3D.class, 95, 3453, 3777);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 96, 3721, 3731);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 97, 3741, 3751);
            this.z = z;
            CallChecker.varAssign(this.z, "this.z", 98, 3761, 3771);
        } finally {
            _bcornu_methode_context221.methodEnd();
        }
    }

    public Vector3D(double[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context222 = new ConstructorContext(Vector3D.class, 107, 3784, 4238);
        try {
            if (CallChecker.beforeDeref(v, double[].class, 108, 4075, 4075)) {
                v = CallChecker.beforeCalled(v, double[].class, 108, 4075, 4075);
                if ((CallChecker.isCalled(v, double[].class, 108, 4075, 4075).length) != 3) {
                    if (CallChecker.beforeDeref(v, double[].class, 109, 4141, 4141)) {
                        v = CallChecker.beforeCalled(v, double[].class, 109, 4141, 4141);
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 109, 4141, 4141).length, 3);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            v = CallChecker.beforeCalled(v, double[].class, 111, 4182, 4182);
            this.x = CallChecker.isCalled(v, double[].class, 111, 4182, 4182)[0];
            CallChecker.varAssign(this.x, "this.x", 111, 4173, 4186);
            v = CallChecker.beforeCalled(v, double[].class, 112, 4205, 4205);
            this.y = CallChecker.isCalled(v, double[].class, 112, 4205, 4205)[1];
            CallChecker.varAssign(this.y, "this.y", 112, 4196, 4209);
            v = CallChecker.beforeCalled(v, double[].class, 113, 4228, 4228);
            this.z = CallChecker.isCalled(v, double[].class, 113, 4228, 4228)[2];
            CallChecker.varAssign(this.z, "this.z", 113, 4219, 4232);
        } finally {
            _bcornu_methode_context222.methodEnd();
        }
    }

    public Vector3D(double alpha, double delta) {
        ConstructorContext _bcornu_methode_context223 = new ConstructorContext(Vector3D.class, 124, 4245, 4818);
        try {
            double cosDelta = CallChecker.varInit(((double) (FastMath.cos(delta))), "cosDelta", 125, 4639, 4676);
            this.x = (FastMath.cos(alpha)) * cosDelta;
            CallChecker.varAssign(this.x, "this.x", 126, 4686, 4725);
            this.y = (FastMath.sin(alpha)) * cosDelta;
            CallChecker.varAssign(this.y, "this.y", 127, 4735, 4774);
            this.z = FastMath.sin(delta);
            CallChecker.varAssign(this.z, "this.z", 128, 4784, 4812);
        } finally {
            _bcornu_methode_context223.methodEnd();
        }
    }

    public Vector3D(double a, Vector3D u) {
        ConstructorContext _bcornu_methode_context224 = new ConstructorContext(Vector3D.class, 137, 4825, 5155);
        try {
            u = CallChecker.beforeCalled(u, Vector3D.class, 138, 5094, 5094);
            this.x = a * (CallChecker.isCalled(u, Vector3D.class, 138, 5094, 5094).x);
            CallChecker.varAssign(this.x, "this.x", 138, 5081, 5097);
            u = CallChecker.beforeCalled(u, Vector3D.class, 139, 5120, 5120);
            this.y = a * (CallChecker.isCalled(u, Vector3D.class, 139, 5120, 5120).y);
            CallChecker.varAssign(this.y, "this.y", 139, 5107, 5123);
            u = CallChecker.beforeCalled(u, Vector3D.class, 140, 5146, 5146);
            this.z = a * (CallChecker.isCalled(u, Vector3D.class, 140, 5146, 5146).z);
            CallChecker.varAssign(this.z, "this.z", 140, 5133, 5149);
        } finally {
            _bcornu_methode_context224.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2) {
        ConstructorContext _bcornu_methode_context225 = new ConstructorContext(Vector3D.class, 151, 5162, 5759);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 152, 5604, 5605);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 152, 5614, 5615);
            this.x = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 152, 5604, 5605).x, a2, CallChecker.isCalled(u2, Vector3D.class, 152, 5614, 5615).x);
            CallChecker.varAssign(this.x, "this.x", 152, 5562, 5619);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 153, 5671, 5672);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 153, 5681, 5682);
            this.y = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 153, 5671, 5672).y, a2, CallChecker.isCalled(u2, Vector3D.class, 153, 5681, 5682).y);
            CallChecker.varAssign(this.y, "this.y", 153, 5629, 5686);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 154, 5738, 5739);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 154, 5748, 5749);
            this.z = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 154, 5738, 5739).z, a2, CallChecker.isCalled(u2, Vector3D.class, 154, 5748, 5749).z);
            CallChecker.varAssign(this.z, "this.z", 154, 5696, 5753);
        } finally {
            _bcornu_methode_context225.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3) {
        ConstructorContext _bcornu_methode_context226 = new ConstructorContext(Vector3D.class, 167, 5766, 6531);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 169, 6346, 6347);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 169, 6356, 6357);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 169, 6366, 6367);
            this.x = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 169, 6346, 6347).x, a2, CallChecker.isCalled(u2, Vector3D.class, 169, 6356, 6357).x, a3, CallChecker.isCalled(u3, Vector3D.class, 169, 6366, 6367).x);
            CallChecker.varAssign(this.x, "this.x", 169, 6304, 6371);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 170, 6423, 6424);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 170, 6433, 6434);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 170, 6443, 6444);
            this.y = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 170, 6423, 6424).y, a2, CallChecker.isCalled(u2, Vector3D.class, 170, 6433, 6434).y, a3, CallChecker.isCalled(u3, Vector3D.class, 170, 6443, 6444).y);
            CallChecker.varAssign(this.y, "this.y", 170, 6381, 6448);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 171, 6500, 6501);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 171, 6510, 6511);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 171, 6520, 6521);
            this.z = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 171, 6500, 6501).z, a2, CallChecker.isCalled(u2, Vector3D.class, 171, 6510, 6511).z, a3, CallChecker.isCalled(u3, Vector3D.class, 171, 6520, 6521).z);
            CallChecker.varAssign(this.z, "this.z", 171, 6458, 6525);
        } finally {
            _bcornu_methode_context226.methodEnd();
        }
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3, double a4, Vector3D u4) {
        ConstructorContext _bcornu_methode_context227 = new ConstructorContext(Vector3D.class, 186, 6538, 7450);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 188, 7235, 7236);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 188, 7245, 7246);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 188, 7255, 7256);
            u4 = CallChecker.beforeCalled(u4, Vector3D.class, 188, 7265, 7266);
            this.x = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 188, 7235, 7236).x, a2, CallChecker.isCalled(u2, Vector3D.class, 188, 7245, 7246).x, a3, CallChecker.isCalled(u3, Vector3D.class, 188, 7255, 7256).x, a4, CallChecker.isCalled(u4, Vector3D.class, 188, 7265, 7266).x);
            CallChecker.varAssign(this.x, "this.x", 188, 7193, 7270);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 189, 7322, 7323);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 189, 7332, 7333);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 189, 7342, 7343);
            u4 = CallChecker.beforeCalled(u4, Vector3D.class, 189, 7352, 7353);
            this.y = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 189, 7322, 7323).y, a2, CallChecker.isCalled(u2, Vector3D.class, 189, 7332, 7333).y, a3, CallChecker.isCalled(u3, Vector3D.class, 189, 7342, 7343).y, a4, CallChecker.isCalled(u4, Vector3D.class, 189, 7352, 7353).y);
            CallChecker.varAssign(this.y, "this.y", 189, 7280, 7357);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 190, 7409, 7410);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 190, 7419, 7420);
            u3 = CallChecker.beforeCalled(u3, Vector3D.class, 190, 7429, 7430);
            u4 = CallChecker.beforeCalled(u4, Vector3D.class, 190, 7439, 7440);
            this.z = MathArrays.linearCombination(a1, CallChecker.isCalled(u1, Vector3D.class, 190, 7409, 7410).z, a2, CallChecker.isCalled(u2, Vector3D.class, 190, 7419, 7420).z, a3, CallChecker.isCalled(u3, Vector3D.class, 190, 7429, 7430).z, a4, CallChecker.isCalled(u4, Vector3D.class, 190, 7439, 7440).z);
            CallChecker.varAssign(this.z, "this.z", 190, 7367, 7444);
        } finally {
            _bcornu_methode_context227.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context894 = new MethodContext(double.class, 197, 7457, 7634);
        try {
            CallChecker.varInit(this, "this", 197, 7457, 7634);
            CallChecker.varInit(this.z, "z", 197, 7457, 7634);
            CallChecker.varInit(this.y, "y", 197, 7457, 7634);
            CallChecker.varInit(this.x, "x", 197, 7457, 7634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 197, 7457, 7634);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 197, 7457, 7634);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 197, 7457, 7634);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 197, 7457, 7634);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 197, 7457, 7634);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 197, 7457, 7634);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 197, 7457, 7634);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 197, 7457, 7634);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 197, 7457, 7634);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 197, 7457, 7634);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 197, 7457, 7634);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context894.methodEnd();
        }
    }

    public double getY() {
        MethodContext _bcornu_methode_context895 = new MethodContext(double.class, 205, 7641, 7818);
        try {
            CallChecker.varInit(this, "this", 205, 7641, 7818);
            CallChecker.varInit(this.z, "z", 205, 7641, 7818);
            CallChecker.varInit(this.y, "y", 205, 7641, 7818);
            CallChecker.varInit(this.x, "x", 205, 7641, 7818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 205, 7641, 7818);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 205, 7641, 7818);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 205, 7641, 7818);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 205, 7641, 7818);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 205, 7641, 7818);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 205, 7641, 7818);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 205, 7641, 7818);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 205, 7641, 7818);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 205, 7641, 7818);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 205, 7641, 7818);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 205, 7641, 7818);
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context895.methodEnd();
        }
    }

    public double getZ() {
        MethodContext _bcornu_methode_context896 = new MethodContext(double.class, 213, 7825, 7998);
        try {
            CallChecker.varInit(this, "this", 213, 7825, 7998);
            CallChecker.varInit(this.z, "z", 213, 7825, 7998);
            CallChecker.varInit(this.y, "y", 213, 7825, 7998);
            CallChecker.varInit(this.x, "x", 213, 7825, 7998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 213, 7825, 7998);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 213, 7825, 7998);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 213, 7825, 7998);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 213, 7825, 7998);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 213, 7825, 7998);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 213, 7825, 7998);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 213, 7825, 7998);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 213, 7825, 7998);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 213, 7825, 7998);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 213, 7825, 7998);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 213, 7825, 7998);
            return z;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context896.methodEnd();
        }
    }

    public double[] toArray() {
        MethodContext _bcornu_methode_context897 = new MethodContext(double[].class, 221, 8005, 8211);
        try {
            CallChecker.varInit(this, "this", 221, 8005, 8211);
            CallChecker.varInit(this.z, "z", 221, 8005, 8211);
            CallChecker.varInit(this.y, "y", 221, 8005, 8211);
            CallChecker.varInit(this.x, "x", 221, 8005, 8211);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 221, 8005, 8211);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 221, 8005, 8211);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 221, 8005, 8211);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 221, 8005, 8211);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 221, 8005, 8211);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 221, 8005, 8211);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 221, 8005, 8211);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 221, 8005, 8211);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 221, 8005, 8211);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 221, 8005, 8211);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 221, 8005, 8211);
            return new double[]{ x , y , z };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context897.methodEnd();
        }
    }

    public Space getSpace() {
        MethodContext _bcornu_methode_context898 = new MethodContext(Space.class, 226, 8218, 8315);
        try {
            CallChecker.varInit(this, "this", 226, 8218, 8315);
            CallChecker.varInit(this.z, "z", 226, 8218, 8315);
            CallChecker.varInit(this.y, "y", 226, 8218, 8315);
            CallChecker.varInit(this.x, "x", 226, 8218, 8315);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 226, 8218, 8315);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 226, 8218, 8315);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 226, 8218, 8315);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 226, 8218, 8315);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 226, 8218, 8315);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 226, 8218, 8315);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 226, 8218, 8315);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 226, 8218, 8315);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 226, 8218, 8315);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 226, 8218, 8315);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 226, 8218, 8315);
            return Euclidean3D.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Space) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context898.methodEnd();
        }
    }

    public Vector3D getZero() {
        MethodContext _bcornu_methode_context899 = new MethodContext(Vector3D.class, 231, 8322, 8400);
        try {
            CallChecker.varInit(this, "this", 231, 8322, 8400);
            CallChecker.varInit(this.z, "z", 231, 8322, 8400);
            CallChecker.varInit(this.y, "y", 231, 8322, 8400);
            CallChecker.varInit(this.x, "x", 231, 8322, 8400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 231, 8322, 8400);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 231, 8322, 8400);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 231, 8322, 8400);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 231, 8322, 8400);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 231, 8322, 8400);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 231, 8322, 8400);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 231, 8322, 8400);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 231, 8322, 8400);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 231, 8322, 8400);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 231, 8322, 8400);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 231, 8322, 8400);
            return Vector3D.ZERO;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context899.methodEnd();
        }
    }

    public double getNorm1() {
        MethodContext _bcornu_methode_context900 = new MethodContext(double.class, 236, 8407, 8531);
        try {
            CallChecker.varInit(this, "this", 236, 8407, 8531);
            CallChecker.varInit(this.z, "z", 236, 8407, 8531);
            CallChecker.varInit(this.y, "y", 236, 8407, 8531);
            CallChecker.varInit(this.x, "x", 236, 8407, 8531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 236, 8407, 8531);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 236, 8407, 8531);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 236, 8407, 8531);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 236, 8407, 8531);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 236, 8407, 8531);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 236, 8407, 8531);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 236, 8407, 8531);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 236, 8407, 8531);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 236, 8407, 8531);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 236, 8407, 8531);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 236, 8407, 8531);
            return ((FastMath.abs(x)) + (FastMath.abs(y))) + (FastMath.abs(z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context900.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context901 = new MethodContext(double.class, 241, 8538, 8737);
        try {
            CallChecker.varInit(this, "this", 241, 8538, 8737);
            CallChecker.varInit(this.z, "z", 241, 8538, 8737);
            CallChecker.varInit(this.y, "y", 241, 8538, 8737);
            CallChecker.varInit(this.x, "x", 241, 8538, 8737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 241, 8538, 8737);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 241, 8538, 8737);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 241, 8538, 8737);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 241, 8538, 8737);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 241, 8538, 8737);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 241, 8538, 8737);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 241, 8538, 8737);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 241, 8538, 8737);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 241, 8538, 8737);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 241, 8538, 8737);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 241, 8538, 8737);
            return FastMath.sqrt(((((x) * (x)) + ((y) * (y))) + ((z) * (z))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context901.methodEnd();
        }
    }

    public double getNormSq() {
        MethodContext _bcornu_methode_context902 = new MethodContext(double.class, 247, 8744, 8929);
        try {
            CallChecker.varInit(this, "this", 247, 8744, 8929);
            CallChecker.varInit(this.z, "z", 247, 8744, 8929);
            CallChecker.varInit(this.y, "y", 247, 8744, 8929);
            CallChecker.varInit(this.x, "x", 247, 8744, 8929);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 247, 8744, 8929);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 247, 8744, 8929);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 247, 8744, 8929);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 247, 8744, 8929);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 247, 8744, 8929);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 247, 8744, 8929);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 247, 8744, 8929);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 247, 8744, 8929);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 247, 8744, 8929);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 247, 8744, 8929);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 247, 8744, 8929);
            return (((x) * (x)) + ((y) * (y))) + ((z) * (z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context902.methodEnd();
        }
    }

    public double getNormInf() {
        MethodContext _bcornu_methode_context903 = new MethodContext(double.class, 253, 8936, 9088);
        try {
            CallChecker.varInit(this, "this", 253, 8936, 9088);
            CallChecker.varInit(this.z, "z", 253, 8936, 9088);
            CallChecker.varInit(this.y, "y", 253, 8936, 9088);
            CallChecker.varInit(this.x, "x", 253, 8936, 9088);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 253, 8936, 9088);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 253, 8936, 9088);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 253, 8936, 9088);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 253, 8936, 9088);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 253, 8936, 9088);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 253, 8936, 9088);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 253, 8936, 9088);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 253, 8936, 9088);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 253, 8936, 9088);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 253, 8936, 9088);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 253, 8936, 9088);
            return FastMath.max(FastMath.max(FastMath.abs(x), FastMath.abs(y)), FastMath.abs(z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context903.methodEnd();
        }
    }

    public double getAlpha() {
        MethodContext _bcornu_methode_context904 = new MethodContext(double.class, 261, 9095, 9320);
        try {
            CallChecker.varInit(this, "this", 261, 9095, 9320);
            CallChecker.varInit(this.z, "z", 261, 9095, 9320);
            CallChecker.varInit(this.y, "y", 261, 9095, 9320);
            CallChecker.varInit(this.x, "x", 261, 9095, 9320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 261, 9095, 9320);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 261, 9095, 9320);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 261, 9095, 9320);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 261, 9095, 9320);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 261, 9095, 9320);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 261, 9095, 9320);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 261, 9095, 9320);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 261, 9095, 9320);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 261, 9095, 9320);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 261, 9095, 9320);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 261, 9095, 9320);
            return FastMath.atan2(y, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context904.methodEnd();
        }
    }

    public double getDelta() {
        MethodContext _bcornu_methode_context905 = new MethodContext(double.class, 269, 9327, 9568);
        try {
            CallChecker.varInit(this, "this", 269, 9327, 9568);
            CallChecker.varInit(this.z, "z", 269, 9327, 9568);
            CallChecker.varInit(this.y, "y", 269, 9327, 9568);
            CallChecker.varInit(this.x, "x", 269, 9327, 9568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 269, 9327, 9568);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 269, 9327, 9568);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 269, 9327, 9568);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 269, 9327, 9568);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 269, 9327, 9568);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 269, 9327, 9568);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 269, 9327, 9568);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 269, 9327, 9568);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 269, 9327, 9568);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 269, 9327, 9568);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 269, 9327, 9568);
            return FastMath.asin(((z) / (getNorm())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context905.methodEnd();
        }
    }

    public Vector3D add(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context906 = new MethodContext(Vector3D.class, 274, 9575, 9756);
        try {
            CallChecker.varInit(this, "this", 274, 9575, 9756);
            CallChecker.varInit(v, "v", 274, 9575, 9756);
            CallChecker.varInit(this.z, "z", 274, 9575, 9756);
            CallChecker.varInit(this.y, "y", 274, 9575, 9756);
            CallChecker.varInit(this.x, "x", 274, 9575, 9756);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 274, 9575, 9756);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 274, 9575, 9756);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 274, 9575, 9756);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 274, 9575, 9756);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 274, 9575, 9756);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 274, 9575, 9756);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 274, 9575, 9756);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 274, 9575, 9756);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 274, 9575, 9756);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 274, 9575, 9756);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 274, 9575, 9756);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 275, 9659, 9691);
            return new Vector3D(((x) + (CallChecker.isCalled(v3, Vector3D.class, 276, 9725, 9726).x)), ((y) + (CallChecker.isCalled(v3, Vector3D.class, 276, 9735, 9736).y)), ((z) + (CallChecker.isCalled(v3, Vector3D.class, 276, 9745, 9746).z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context906.methodEnd();
        }
    }

    public Vector3D add(double factor, final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context907 = new MethodContext(Vector3D.class, 280, 9763, 9918);
        try {
            CallChecker.varInit(this, "this", 280, 9763, 9918);
            CallChecker.varInit(v, "v", 280, 9763, 9918);
            CallChecker.varInit(factor, "factor", 280, 9763, 9918);
            CallChecker.varInit(this.z, "z", 280, 9763, 9918);
            CallChecker.varInit(this.y, "y", 280, 9763, 9918);
            CallChecker.varInit(this.x, "x", 280, 9763, 9918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 280, 9763, 9918);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 280, 9763, 9918);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 280, 9763, 9918);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 280, 9763, 9918);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 280, 9763, 9918);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 280, 9763, 9918);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 280, 9763, 9918);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 280, 9763, 9918);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 280, 9763, 9918);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 280, 9763, 9918);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 280, 9763, 9918);
            return new Vector3D(1, this, factor, ((Vector3D) (v)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context907.methodEnd();
        }
    }

    public Vector3D subtract(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context908 = new MethodContext(Vector3D.class, 285, 9925, 10111);
        try {
            CallChecker.varInit(this, "this", 285, 9925, 10111);
            CallChecker.varInit(v, "v", 285, 9925, 10111);
            CallChecker.varInit(this.z, "z", 285, 9925, 10111);
            CallChecker.varInit(this.y, "y", 285, 9925, 10111);
            CallChecker.varInit(this.x, "x", 285, 9925, 10111);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 285, 9925, 10111);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 285, 9925, 10111);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 285, 9925, 10111);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 285, 9925, 10111);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 285, 9925, 10111);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 285, 9925, 10111);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 285, 9925, 10111);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 285, 9925, 10111);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 285, 9925, 10111);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 285, 9925, 10111);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 285, 9925, 10111);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 286, 10014, 10046);
            return new Vector3D(((x) - (CallChecker.isCalled(v3, Vector3D.class, 287, 10080, 10081).x)), ((y) - (CallChecker.isCalled(v3, Vector3D.class, 287, 10090, 10091).y)), ((z) - (CallChecker.isCalled(v3, Vector3D.class, 287, 10100, 10101).z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context908.methodEnd();
        }
    }

    public Vector3D subtract(final double factor, final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context909 = new MethodContext(Vector3D.class, 291, 10118, 10285);
        try {
            CallChecker.varInit(this, "this", 291, 10118, 10285);
            CallChecker.varInit(v, "v", 291, 10118, 10285);
            CallChecker.varInit(factor, "factor", 291, 10118, 10285);
            CallChecker.varInit(this.z, "z", 291, 10118, 10285);
            CallChecker.varInit(this.y, "y", 291, 10118, 10285);
            CallChecker.varInit(this.x, "x", 291, 10118, 10285);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 291, 10118, 10285);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 291, 10118, 10285);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 291, 10118, 10285);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 291, 10118, 10285);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 291, 10118, 10285);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 291, 10118, 10285);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 291, 10118, 10285);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 291, 10118, 10285);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 291, 10118, 10285);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 291, 10118, 10285);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 291, 10118, 10285);
            return new Vector3D(1, this, (-factor), ((Vector3D) (v)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context909.methodEnd();
        }
    }

    public Vector3D normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context910 = new MethodContext(Vector3D.class, 296, 10292, 10583);
        try {
            CallChecker.varInit(this, "this", 296, 10292, 10583);
            CallChecker.varInit(this.z, "z", 296, 10292, 10583);
            CallChecker.varInit(this.y, "y", 296, 10292, 10583);
            CallChecker.varInit(this.x, "x", 296, 10292, 10583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 296, 10292, 10583);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 296, 10292, 10583);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 296, 10292, 10583);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 296, 10292, 10583);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 296, 10292, 10583);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 296, 10292, 10583);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 296, 10292, 10583);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 296, 10292, 10583);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 296, 10292, 10583);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 296, 10292, 10583);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 296, 10292, 10583);
            double s = CallChecker.varInit(((double) (getNorm())), "s", 297, 10386, 10406);
            if (s == 0) {
                throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
            }
            return scalarMultiply((1 / s));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context910.methodEnd();
        }
    }

    public Vector3D orthogonal() throws MathArithmeticException {
        MethodContext _bcornu_methode_context911 = new MethodContext(Vector3D.class, 319, 10590, 12050);
        try {
            CallChecker.varInit(this, "this", 319, 10590, 12050);
            CallChecker.varInit(this.z, "z", 319, 10590, 12050);
            CallChecker.varInit(this.y, "y", 319, 10590, 12050);
            CallChecker.varInit(this.x, "x", 319, 10590, 12050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 319, 10590, 12050);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 319, 10590, 12050);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 319, 10590, 12050);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 319, 10590, 12050);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 319, 10590, 12050);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 319, 10590, 12050);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 319, 10590, 12050);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 319, 10590, 12050);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 319, 10590, 12050);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 319, 10590, 12050);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 319, 10590, 12050);
            double threshold = CallChecker.varInit(((double) (0.6 * (getNorm()))), "threshold", 321, 11415, 11449);
            if (threshold == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            if ((FastMath.abs(x)) <= threshold) {
                double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.y) * (this.y)) + ((this.z) * (this.z))))))), "inverse", 327, 11623, 11673);
                return new Vector3D(0, (inverse * (z)), ((-inverse) * (y)));
            }else
                if ((FastMath.abs(y)) <= threshold) {
                    double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.x) * (this.x)) + ((this.z) * (this.z))))))), "inverse", 330, 11801, 11851);
                    return new Vector3D(((-inverse) * (z)), 0, (inverse * (x)));
                }
            
            double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt((((this.x) * (this.x)) + ((this.y) * (this.y))))))), "inverse", 333, 11934, 11984);
            return new Vector3D((inverse * (y)), ((-inverse) * (x)), 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context911.methodEnd();
        }
    }

    public static double angle(Vector3D v1, Vector3D v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context912 = new MethodContext(double.class, 349, 12057, 13453);
        try {
            CallChecker.varInit(v2, "v2", 349, 12057, 13453);
            CallChecker.varInit(v1, "v1", 349, 12057, 13453);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 349, 12057, 13453);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 349, 12057, 13453);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 349, 12057, 13453);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 349, 12057, 13453);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 349, 12057, 13453);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 349, 12057, 13453);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 349, 12057, 13453);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 349, 12057, 13453);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 349, 12057, 13453);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 349, 12057, 13453);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 349, 12057, 13453);
            double normProduct = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 351, 12727, 12728)) {
                if (CallChecker.beforeDeref(v2, Vector3D.class, 351, 12742, 12743)) {
                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 351, 12727, 12728);
                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 351, 12742, 12743);
                    normProduct = (CallChecker.isCalled(v1, Vector3D.class, 351, 12727, 12728).getNorm()) * (CallChecker.isCalled(v2, Vector3D.class, 351, 12742, 12743).getNorm());
                    CallChecker.varAssign(normProduct, "normProduct", 351, 12727, 12728);
                }
            }
            if (normProduct == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            double dot = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 356, 12895, 12896)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 356, 12895, 12896);
                dot = CallChecker.isCalled(v1, Vector3D.class, 356, 12895, 12896).dotProduct(v2);
                CallChecker.varAssign(dot, "dot", 356, 12895, 12896);
            }
            double threshold = CallChecker.varInit(((double) (normProduct * 0.9999)), "threshold", 357, 12922, 12961);
            if ((dot < (-threshold)) || (dot > threshold)) {
                Vector3D v3 = CallChecker.varInit(Vector3D.crossProduct(v1, v2), "v3", 360, 13100, 13134);
                if (dot >= 0) {
                    v3 = CallChecker.beforeCalled(v3, Vector3D.class, 362, 13201, 13202);
                    return FastMath.asin(((CallChecker.isCalled(v3, Vector3D.class, 362, 13201, 13202).getNorm()) / normProduct));
                }
                v3 = CallChecker.beforeCalled(v3, Vector3D.class, 364, 13291, 13292);
                return (FastMath.PI) - (FastMath.asin(((CallChecker.isCalled(v3, Vector3D.class, 364, 13291, 13292).getNorm()) / normProduct)));
            }
            return FastMath.acos((dot / normProduct));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context912.methodEnd();
        }
    }

    public Vector3D negate() {
        MethodContext _bcornu_methode_context913 = new MethodContext(Vector3D.class, 373, 13460, 13557);
        try {
            CallChecker.varInit(this, "this", 373, 13460, 13557);
            CallChecker.varInit(this.z, "z", 373, 13460, 13557);
            CallChecker.varInit(this.y, "y", 373, 13460, 13557);
            CallChecker.varInit(this.x, "x", 373, 13460, 13557);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 373, 13460, 13557);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 373, 13460, 13557);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 373, 13460, 13557);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 373, 13460, 13557);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 373, 13460, 13557);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 373, 13460, 13557);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 373, 13460, 13557);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 373, 13460, 13557);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 373, 13460, 13557);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 373, 13460, 13557);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 373, 13460, 13557);
            return new Vector3D((-(x)), (-(y)), (-(z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context913.methodEnd();
        }
    }

    public Vector3D scalarMultiply(double a) {
        MethodContext _bcornu_methode_context914 = new MethodContext(Vector3D.class, 378, 13564, 13686);
        try {
            CallChecker.varInit(this, "this", 378, 13564, 13686);
            CallChecker.varInit(a, "a", 378, 13564, 13686);
            CallChecker.varInit(this.z, "z", 378, 13564, 13686);
            CallChecker.varInit(this.y, "y", 378, 13564, 13686);
            CallChecker.varInit(this.x, "x", 378, 13564, 13686);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 378, 13564, 13686);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 378, 13564, 13686);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 378, 13564, 13686);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 378, 13564, 13686);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 378, 13564, 13686);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 378, 13564, 13686);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 378, 13564, 13686);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 378, 13564, 13686);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 378, 13564, 13686);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 378, 13564, 13686);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 378, 13564, 13686);
            return new Vector3D((a * (x)), (a * (y)), (a * (z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context914.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context915 = new MethodContext(boolean.class, 383, 13693, 13817);
        try {
            CallChecker.varInit(this, "this", 383, 13693, 13817);
            CallChecker.varInit(this.z, "z", 383, 13693, 13817);
            CallChecker.varInit(this.y, "y", 383, 13693, 13817);
            CallChecker.varInit(this.x, "x", 383, 13693, 13817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 383, 13693, 13817);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 383, 13693, 13817);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 383, 13693, 13817);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 383, 13693, 13817);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 383, 13693, 13817);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 383, 13693, 13817);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 383, 13693, 13817);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 383, 13693, 13817);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 383, 13693, 13817);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 383, 13693, 13817);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 383, 13693, 13817);
            return ((Double.isNaN(x)) || (Double.isNaN(y))) || (Double.isNaN(z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context915.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context916 = new MethodContext(boolean.class, 388, 13824, 13982);
        try {
            CallChecker.varInit(this, "this", 388, 13824, 13982);
            CallChecker.varInit(this.z, "z", 388, 13824, 13982);
            CallChecker.varInit(this.y, "y", 388, 13824, 13982);
            CallChecker.varInit(this.x, "x", 388, 13824, 13982);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 388, 13824, 13982);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 388, 13824, 13982);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 388, 13824, 13982);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 388, 13824, 13982);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 388, 13824, 13982);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 388, 13824, 13982);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 388, 13824, 13982);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 388, 13824, 13982);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 388, 13824, 13982);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 388, 13824, 13982);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 388, 13824, 13982);
            return (!(isNaN())) && (((Double.isInfinite(x)) || (Double.isInfinite(y))) || (Double.isInfinite(z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context916.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context917 = new MethodContext(boolean.class, 412, 13989, 15162);
        try {
            CallChecker.varInit(this, "this", 412, 13989, 15162);
            CallChecker.varInit(other, "other", 412, 13989, 15162);
            CallChecker.varInit(this.z, "z", 412, 13989, 15162);
            CallChecker.varInit(this.y, "y", 412, 13989, 15162);
            CallChecker.varInit(this.x, "x", 412, 13989, 15162);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 412, 13989, 15162);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 412, 13989, 15162);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 412, 13989, 15162);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 412, 13989, 15162);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 412, 13989, 15162);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 412, 13989, 15162);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 412, 13989, 15162);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 412, 13989, 15162);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 412, 13989, 15162);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 412, 13989, 15162);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 412, 13989, 15162);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Vector3D) {
                final Vector3D rhs = CallChecker.varInit(((Vector3D) (other)), "rhs", 419, 14940, 14976);
                if (CallChecker.beforeDeref(rhs, Vector3D.class, 420, 14994, 14996)) {
                    if (CallChecker.isCalled(rhs, Vector3D.class, 420, 14994, 14996).isNaN()) {
                        return this.isNaN();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return (((x) == (CallChecker.isCalled(rhs, Vector3D.class, 424, 15086, 15088).x)) && ((y) == (CallChecker.isCalled(rhs, Vector3D.class, 424, 15102, 15104).y))) && ((z) == (CallChecker.isCalled(rhs, Vector3D.class, 424, 15118, 15120).z));
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context917.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context918 = new MethodContext(int.class, 437, 15169, 15537);
        try {
            CallChecker.varInit(this, "this", 437, 15169, 15537);
            CallChecker.varInit(this.z, "z", 437, 15169, 15537);
            CallChecker.varInit(this.y, "y", 437, 15169, 15537);
            CallChecker.varInit(this.x, "x", 437, 15169, 15537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 437, 15169, 15537);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 437, 15169, 15537);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 437, 15169, 15537);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 437, 15169, 15537);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 437, 15169, 15537);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 437, 15169, 15537);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 437, 15169, 15537);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 437, 15169, 15537);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 437, 15169, 15537);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 437, 15169, 15537);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 437, 15169, 15537);
            if (isNaN()) {
                return 642;
            }
            return 643 * (((164 * (MathUtils.hash(x))) + (3 * (MathUtils.hash(y)))) + (MathUtils.hash(z)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context918.methodEnd();
        }
    }

    public double dotProduct(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context919 = new MethodContext(double.class, 452, 15544, 16070);
        try {
            CallChecker.varInit(this, "this", 452, 15544, 16070);
            CallChecker.varInit(v, "v", 452, 15544, 16070);
            CallChecker.varInit(this.z, "z", 452, 15544, 16070);
            CallChecker.varInit(this.y, "y", 452, 15544, 16070);
            CallChecker.varInit(this.x, "x", 452, 15544, 16070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 452, 15544, 16070);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 452, 15544, 16070);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 452, 15544, 16070);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 452, 15544, 16070);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 452, 15544, 16070);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 452, 15544, 16070);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 452, 15544, 16070);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 452, 15544, 16070);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 452, 15544, 16070);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 452, 15544, 16070);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 452, 15544, 16070);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 453, 15960, 15992);
            if (CallChecker.beforeDeref(v3, Vector3D.class, 454, 16041, 16042)) {
                if (CallChecker.beforeDeref(v3, Vector3D.class, 454, 16050, 16051)) {
                    if (CallChecker.beforeDeref(v3, Vector3D.class, 454, 16059, 16060)) {
                        return MathArrays.linearCombination(x, CallChecker.isCalled(v3, Vector3D.class, 454, 16041, 16042).x, y, CallChecker.isCalled(v3, Vector3D.class, 454, 16050, 16051).y, z, CallChecker.isCalled(v3, Vector3D.class, 454, 16059, 16060).z);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context919.methodEnd();
        }
    }

    public Vector3D crossProduct(final Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context920 = new MethodContext(Vector3D.class, 461, 16077, 16583);
        try {
            CallChecker.varInit(this, "this", 461, 16077, 16583);
            CallChecker.varInit(v, "v", 461, 16077, 16583);
            CallChecker.varInit(this.z, "z", 461, 16077, 16583);
            CallChecker.varInit(this.y, "y", 461, 16077, 16583);
            CallChecker.varInit(this.x, "x", 461, 16077, 16583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 461, 16077, 16583);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 461, 16077, 16583);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 461, 16077, 16583);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 461, 16077, 16583);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 461, 16077, 16583);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 461, 16077, 16583);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 461, 16077, 16583);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 461, 16077, 16583);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 461, 16077, 16583);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 461, 16077, 16583);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 461, 16077, 16583);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 462, 16313, 16345);
            if (CallChecker.beforeDeref(v3, Vector3D.class, 463, 16407, 16408)) {
                if (CallChecker.beforeDeref(v3, Vector3D.class, 463, 16417, 16418)) {
                    if (CallChecker.beforeDeref(v3, Vector3D.class, 464, 16484, 16485)) {
                        if (CallChecker.beforeDeref(v3, Vector3D.class, 464, 16494, 16495)) {
                            if (CallChecker.beforeDeref(v3, Vector3D.class, 465, 16561, 16562)) {
                                if (CallChecker.beforeDeref(v3, Vector3D.class, 465, 16571, 16572)) {
                                    return new Vector3D(MathArrays.linearCombination(y, CallChecker.isCalled(v3, Vector3D.class, 463, 16407, 16408).z, (-(z)), CallChecker.isCalled(v3, Vector3D.class, 463, 16417, 16418).y), MathArrays.linearCombination(z, CallChecker.isCalled(v3, Vector3D.class, 464, 16484, 16485).x, (-(x)), CallChecker.isCalled(v3, Vector3D.class, 464, 16494, 16495).z), MathArrays.linearCombination(x, CallChecker.isCalled(v3, Vector3D.class, 465, 16561, 16562).y, (-(y)), CallChecker.isCalled(v3, Vector3D.class, 465, 16571, 16572).x));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context920.methodEnd();
        }
    }

    public double distance1(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context921 = new MethodContext(double.class, 469, 16590, 16889);
        try {
            CallChecker.varInit(this, "this", 469, 16590, 16889);
            CallChecker.varInit(v, "v", 469, 16590, 16889);
            CallChecker.varInit(this.z, "z", 469, 16590, 16889);
            CallChecker.varInit(this.y, "y", 469, 16590, 16889);
            CallChecker.varInit(this.x, "x", 469, 16590, 16889);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 469, 16590, 16889);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 469, 16590, 16889);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 469, 16590, 16889);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 469, 16590, 16889);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 469, 16590, 16889);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 469, 16590, 16889);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 469, 16590, 16889);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 469, 16590, 16889);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 469, 16590, 16889);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 469, 16590, 16889);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 469, 16590, 16889);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 470, 16672, 16704);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 471, 16745, 16746).x) - (this.x))))), "dx", 471, 16714, 16754);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 472, 16795, 16796).y) - (this.y))))), "dy", 472, 16764, 16804);
            final double dz = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 473, 16845, 16846).z) - (this.z))))), "dz", 473, 16814, 16854);
            return (dx + dy) + dz;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context921.methodEnd();
        }
    }

    public double distance(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context922 = new MethodContext(double.class, 478, 16896, 17182);
        try {
            CallChecker.varInit(this, "this", 478, 16896, 17182);
            CallChecker.varInit(v, "v", 478, 16896, 17182);
            CallChecker.varInit(this.z, "z", 478, 16896, 17182);
            CallChecker.varInit(this.y, "y", 478, 16896, 17182);
            CallChecker.varInit(this.x, "x", 478, 16896, 17182);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 478, 16896, 17182);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 478, 16896, 17182);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 478, 16896, 17182);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 478, 16896, 17182);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 478, 16896, 17182);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 478, 16896, 17182);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 478, 16896, 17182);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 478, 16896, 17182);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 478, 16896, 17182);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 478, 16896, 17182);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 478, 16896, 17182);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 479, 16977, 17009);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 480, 17037, 17038).x) - (this.x))), "dx", 480, 17019, 17045);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 481, 17073, 17074).y) - (this.y))), "dy", 481, 17055, 17081);
            final double dz = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 482, 17109, 17110).z) - (this.z))), "dz", 482, 17091, 17117);
            return FastMath.sqrt((((dx * dx) + (dy * dy)) + (dz * dz)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context922.methodEnd();
        }
    }

    public double distanceInf(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context923 = new MethodContext(double.class, 487, 17189, 17516);
        try {
            CallChecker.varInit(this, "this", 487, 17189, 17516);
            CallChecker.varInit(v, "v", 487, 17189, 17516);
            CallChecker.varInit(this.z, "z", 487, 17189, 17516);
            CallChecker.varInit(this.y, "y", 487, 17189, 17516);
            CallChecker.varInit(this.x, "x", 487, 17189, 17516);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 487, 17189, 17516);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 487, 17189, 17516);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 487, 17189, 17516);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 487, 17189, 17516);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 487, 17189, 17516);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 487, 17189, 17516);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 487, 17189, 17516);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 487, 17189, 17516);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 487, 17189, 17516);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 487, 17189, 17516);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 487, 17189, 17516);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 488, 17273, 17305);
            final double dx = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 489, 17346, 17347).x) - (this.x))))), "dx", 489, 17315, 17355);
            final double dy = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 490, 17396, 17397).y) - (this.y))))), "dy", 490, 17365, 17405);
            final double dz = CallChecker.varInit(((double) (FastMath.abs(((CallChecker.isCalled(v3, Vector3D.class, 491, 17446, 17447).z) - (this.z))))), "dz", 491, 17415, 17455);
            return FastMath.max(FastMath.max(dx, dy), dz);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context923.methodEnd();
        }
    }

    public double distanceSq(Vector<Euclidean3D> v) {
        MethodContext _bcornu_methode_context924 = new MethodContext(double.class, 496, 17523, 17796);
        try {
            CallChecker.varInit(this, "this", 496, 17523, 17796);
            CallChecker.varInit(v, "v", 496, 17523, 17796);
            CallChecker.varInit(this.z, "z", 496, 17523, 17796);
            CallChecker.varInit(this.y, "y", 496, 17523, 17796);
            CallChecker.varInit(this.x, "x", 496, 17523, 17796);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 496, 17523, 17796);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 496, 17523, 17796);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 496, 17523, 17796);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 496, 17523, 17796);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 496, 17523, 17796);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 496, 17523, 17796);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 496, 17523, 17796);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 496, 17523, 17796);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 496, 17523, 17796);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 496, 17523, 17796);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 496, 17523, 17796);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (v)), "v3", 497, 17606, 17638);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 498, 17666, 17667).x) - (this.x))), "dx", 498, 17648, 17674);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 499, 17702, 17703).y) - (this.y))), "dy", 499, 17684, 17710);
            final double dz = CallChecker.varInit(((double) ((CallChecker.isCalled(v3, Vector3D.class, 500, 17738, 17739).z) - (this.z))), "dz", 500, 17720, 17746);
            return ((dx * dx) + (dy * dy)) + (dz * dz);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context924.methodEnd();
        }
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context925 = new MethodContext(double.class, 509, 17803, 18055);
        try {
            CallChecker.varInit(v2, "v2", 509, 17803, 18055);
            CallChecker.varInit(v1, "v1", 509, 17803, 18055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 509, 17803, 18055);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 509, 17803, 18055);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 509, 17803, 18055);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 509, 17803, 18055);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 509, 17803, 18055);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 509, 17803, 18055);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 509, 17803, 18055);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 509, 17803, 18055);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 509, 17803, 18055);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 509, 17803, 18055);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 509, 17803, 18055);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 510, 18032, 18033)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 510, 18032, 18033);
                return CallChecker.isCalled(v1, Vector3D.class, 510, 18032, 18033).dotProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context925.methodEnd();
        }
    }

    public static Vector3D crossProduct(final Vector3D v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context926 = new MethodContext(Vector3D.class, 518, 18062, 18354);
        try {
            CallChecker.varInit(v2, "v2", 518, 18062, 18354);
            CallChecker.varInit(v1, "v1", 518, 18062, 18354);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 518, 18062, 18354);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 518, 18062, 18354);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 518, 18062, 18354);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 518, 18062, 18354);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 518, 18062, 18354);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 518, 18062, 18354);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 518, 18062, 18354);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 518, 18062, 18354);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 518, 18062, 18354);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 518, 18062, 18354);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 518, 18062, 18354);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 519, 18329, 18330)) {
                return CallChecker.isCalled(v1, Vector3D.class, 519, 18329, 18330).crossProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context926.methodEnd();
        }
    }

    public static double distance1(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context927 = new MethodContext(double.class, 530, 18361, 18852);
        try {
            CallChecker.varInit(v2, "v2", 530, 18361, 18852);
            CallChecker.varInit(v1, "v1", 530, 18361, 18852);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 530, 18361, 18852);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 530, 18361, 18852);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 530, 18361, 18852);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 530, 18361, 18852);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 530, 18361, 18852);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 530, 18361, 18852);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 530, 18361, 18852);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 530, 18361, 18852);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 530, 18361, 18852);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 530, 18361, 18852);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 530, 18361, 18852);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 531, 18830, 18831)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 531, 18830, 18831);
                return CallChecker.isCalled(v1, Vector3D.class, 531, 18830, 18831).distance1(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context927.methodEnd();
        }
    }

    public static double distance(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context928 = new MethodContext(double.class, 542, 18859, 19347);
        try {
            CallChecker.varInit(v2, "v2", 542, 18859, 19347);
            CallChecker.varInit(v1, "v1", 542, 18859, 19347);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 542, 18859, 19347);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 542, 18859, 19347);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 542, 18859, 19347);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 542, 18859, 19347);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 542, 18859, 19347);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 542, 18859, 19347);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 542, 18859, 19347);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 542, 18859, 19347);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 542, 18859, 19347);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 542, 18859, 19347);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 542, 18859, 19347);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 543, 19326, 19327)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 543, 19326, 19327);
                return CallChecker.isCalled(v1, Vector3D.class, 543, 19326, 19327).distance(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context928.methodEnd();
        }
    }

    public static double distanceInf(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context929 = new MethodContext(double.class, 554, 19354, 19863);
        try {
            CallChecker.varInit(v2, "v2", 554, 19354, 19863);
            CallChecker.varInit(v1, "v1", 554, 19354, 19863);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 554, 19354, 19863);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 554, 19354, 19863);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 554, 19354, 19863);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 554, 19354, 19863);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 554, 19354, 19863);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 554, 19354, 19863);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 554, 19354, 19863);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 554, 19354, 19863);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 554, 19354, 19863);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 554, 19354, 19863);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 554, 19354, 19863);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 555, 19839, 19840)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 555, 19839, 19840);
                return CallChecker.isCalled(v1, Vector3D.class, 555, 19839, 19840).distanceInf(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context929.methodEnd();
        }
    }

    public static double distanceSq(Vector3D v1, Vector3D v2) {
        MethodContext _bcornu_methode_context930 = new MethodContext(double.class, 566, 19870, 20320);
        try {
            CallChecker.varInit(v2, "v2", 566, 19870, 20320);
            CallChecker.varInit(v1, "v1", 566, 19870, 20320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 566, 19870, 20320);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 566, 19870, 20320);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 566, 19870, 20320);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 566, 19870, 20320);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 566, 19870, 20320);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 566, 19870, 20320);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 566, 19870, 20320);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 566, 19870, 20320);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 566, 19870, 20320);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 566, 19870, 20320);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 566, 19870, 20320);
            if (CallChecker.beforeDeref(v1, Vector3D.class, 567, 20297, 20298)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 567, 20297, 20298);
                return CallChecker.isCalled(v1, Vector3D.class, 567, 20297, 20298).distanceSq(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context930.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context931 = new MethodContext(String.class, 574, 20327, 20544);
        try {
            CallChecker.varInit(this, "this", 574, 20327, 20544);
            CallChecker.varInit(this.z, "z", 574, 20327, 20544);
            CallChecker.varInit(this.y, "y", 574, 20327, 20544);
            CallChecker.varInit(this.x, "x", 574, 20327, 20544);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 574, 20327, 20544);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 574, 20327, 20544);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 574, 20327, 20544);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 574, 20327, 20544);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 574, 20327, 20544);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 574, 20327, 20544);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 574, 20327, 20544);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 574, 20327, 20544);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 574, 20327, 20544);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 574, 20327, 20544);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 574, 20327, 20544);
            final Vector3DFormat npe_invocation_var97 = Vector3DFormat.getInstance();
            if (CallChecker.beforeDeref(npe_invocation_var97, Vector3DFormat.class, 575, 20497, 20524)) {
                return CallChecker.isCalled(npe_invocation_var97, Vector3DFormat.class, 575, 20497, 20524).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context931.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context932 = new MethodContext(String.class, 579, 20551, 20688);
        try {
            CallChecker.varInit(this, "this", 579, 20551, 20688);
            CallChecker.varInit(format, "format", 579, 20551, 20688);
            CallChecker.varInit(this.z, "z", 579, 20551, 20688);
            CallChecker.varInit(this.y, "y", 579, 20551, 20688);
            CallChecker.varInit(this.x, "x", 579, 20551, 20688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.serialVersionUID", 579, 20551, 20688);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NEGATIVE_INFINITY", 579, 20551, 20688);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.POSITIVE_INFINITY", 579, 20551, 20688);
            CallChecker.varInit(NaN, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.NaN", 579, 20551, 20688);
            CallChecker.varInit(MINUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_K", 579, 20551, 20688);
            CallChecker.varInit(PLUS_K, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_K", 579, 20551, 20688);
            CallChecker.varInit(MINUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_J", 579, 20551, 20688);
            CallChecker.varInit(PLUS_J, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_J", 579, 20551, 20688);
            CallChecker.varInit(MINUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.MINUS_I", 579, 20551, 20688);
            CallChecker.varInit(PLUS_I, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.PLUS_I", 579, 20551, 20688);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.geometry.euclidean.threed.Vector3D.ZERO", 579, 20551, 20688);
            if (CallChecker.beforeDeref(new Vector3DFormat(format), Vector3DFormat.class, 580, 20643, 20668)) {
                return CallChecker.isCalled(new Vector3DFormat(format), Vector3DFormat.class, 580, 20643, 20668).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context932.methodEnd();
        }
    }
}

