package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class Rotation implements Serializable {
    public static final Rotation IDENTITY = new Rotation(1.0, 0.0, 0.0, 0.0, false);

    private static final long serialVersionUID = -2153622329907944313L;

    private final double q0;

    private final double q1;

    private final double q2;

    private final double q3;

    public Rotation(double q0, double q1, double q2, double q3, boolean needsNormalization) {
        ConstructorContext _bcornu_methode_context59 = new ConstructorContext(Rotation.class, 135, 6004, 7494);
        try {
            if (needsNormalization) {
                double inv = CallChecker.varInit(((double) (1.0 / (FastMath.sqrt(((((q0 * q0) + (q1 * q1)) + (q2 * q2)) + (q3 * q3)))))), "inv", 140, 7271, 7342);
                q0 *= inv;
                CallChecker.varAssign(q0, "q0", 141, 7350, 7359);
                q1 *= inv;
                CallChecker.varAssign(q1, "q1", 142, 7367, 7376);
                q2 *= inv;
                CallChecker.varAssign(q2, "q2", 143, 7384, 7393);
                q3 *= inv;
                CallChecker.varAssign(q3, "q3", 144, 7401, 7410);
            }
            this.q0 = q0;
            CallChecker.varAssign(this.q0, "this.q0", 147, 7423, 7435);
            this.q1 = q1;
            CallChecker.varAssign(this.q1, "this.q1", 148, 7441, 7453);
            this.q2 = q2;
            CallChecker.varAssign(this.q2, "this.q2", 149, 7459, 7471);
            this.q3 = q3;
            CallChecker.varAssign(this.q3, "this.q3", 150, 7477, 7489);
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public Rotation(Vector3D axis, double angle) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context60 = new ConstructorContext(Rotation.class, 175, 7499, 9202);
        try {
            double norm = CallChecker.varInit(((double) (axis.getNorm())), "norm", 177, 8835, 8863);
            if (norm == 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS);
            }
            double halfAngle = CallChecker.varInit(((double) ((-0.5) * angle)), "halfAngle", 182, 8989, 9020);
            double coeff = CallChecker.varInit(((double) ((FastMath.sin(halfAngle)) / norm)), "coeff", 183, 9026, 9071);
            q0 = FastMath.cos(halfAngle);
            CallChecker.varAssign(this.q0, "this.q0", 185, 9078, 9107);
            q1 = coeff * (axis.getX());
            CallChecker.varAssign(this.q1, "this.q1", 186, 9113, 9137);
            q2 = coeff * (axis.getY());
            CallChecker.varAssign(this.q2, "this.q2", 187, 9143, 9167);
            q3 = coeff * (axis.getZ());
            CallChecker.varAssign(this.q3, "this.q3", 188, 9173, 9197);
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public Rotation(double[][] m, double threshold) throws NotARotationMatrixException {
        ConstructorContext _bcornu_methode_context61 = new ConstructorContext(Rotation.class, 222, 9207, 11723);
        try {
            if (((((m.length) != 3) || ((m[0].length) != 3)) || ((m[1].length) != 3)) || ((m[2].length) != 3)) {
                throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, m.length, m[0].length);
            }
            double[][] ort = CallChecker.varInit(orthogonalizeMatrix(m, threshold), "ort", 234, 11107, 11157);
            double det = CallChecker.varInit(((double) ((((ort[0][0]) * (((ort[1][1]) * (ort[2][2])) - ((ort[2][1]) * (ort[1][2])))) - ((ort[1][0]) * (((ort[0][1]) * (ort[2][2])) - ((ort[2][1]) * (ort[0][2]))))) + ((ort[2][0]) * (((ort[0][1]) * (ort[1][2])) - ((ort[1][1]) * (ort[0][2])))))), "det", 237, 11205, 11435);
            if (det < 0.0) {
                throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, det);
            }
            double[] quat = CallChecker.varInit(Rotation.mat2quat(ort), "quat", 246, 11617, 11646);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 247, 11652, 11664);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 248, 11670, 11682);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 249, 11688, 11700);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 250, 11706, 11718);
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public Rotation(Vector3D u1, Vector3D u2, Vector3D v1, Vector3D v2) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context62 = new ConstructorContext(Rotation.class, 273, 11728, 14656);
        try {
            final Vector3D u3 = CallChecker.varInit(u1.crossProduct(u2).normalize(), "u3", 278, 12807, 13001);
            u2 = u3.crossProduct(u1).normalize();
            CallChecker.varAssign(u2, "u2", 279, 13009, 13045);
            u1 = u1.normalize();
            CallChecker.varAssign(u1, "u1", 280, 13053, 13072);
            final Vector3D v3 = CallChecker.varInit(v1.crossProduct(v2).normalize(), "v3", 284, 13081, 13278);
            v2 = v3.crossProduct(v1).normalize();
            CallChecker.varAssign(v2, "v2", 285, 13286, 13322);
            v1 = v1.normalize();
            CallChecker.varAssign(v1, "v1", 286, 13330, 13349);
            final double[][] m = CallChecker.varInit(new double[][]{ new double[]{ MathArrays.linearCombination(u1.getX(), v1.getX(), u2.getX(), v2.getX(), u3.getX(), v3.getX()) , MathArrays.linearCombination(u1.getY(), v1.getX(), u2.getY(), v2.getX(), u3.getY(), v3.getX()) , MathArrays.linearCombination(u1.getZ(), v1.getX(), u2.getZ(), v2.getX(), u3.getZ(), v3.getX()) } , new double[]{ MathArrays.linearCombination(u1.getX(), v1.getY(), u2.getX(), v2.getY(), u3.getX(), v3.getY()) , MathArrays.linearCombination(u1.getY(), v1.getY(), u2.getY(), v2.getY(), u3.getY(), v3.getY()) , MathArrays.linearCombination(u1.getZ(), v1.getY(), u2.getZ(), v2.getY(), u3.getZ(), v3.getY()) } , new double[]{ MathArrays.linearCombination(u1.getX(), v1.getZ(), u2.getX(), v2.getZ(), u3.getX(), v3.getZ()) , MathArrays.linearCombination(u1.getY(), v1.getZ(), u2.getY(), v2.getZ(), u3.getY(), v3.getZ()) , MathArrays.linearCombination(u1.getZ(), v1.getZ(), u2.getZ(), v2.getZ(), u3.getZ(), v3.getZ()) } }, "m", 289, 13429, 14535);
            double[] quat = CallChecker.varInit(Rotation.mat2quat(m), "quat", 307, 14544, 14571);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 308, 14579, 14591);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 309, 14599, 14611);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 310, 14619, 14631);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 311, 14639, 14651);
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    public Rotation(Vector3D u, Vector3D v) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context63 = new ConstructorContext(Rotation.class, 328, 14661, 16252);
        try {
            double normProduct = CallChecker.varInit(((double) ((u.getNorm()) * (v.getNorm()))), "normProduct", 330, 15369, 15415);
            if (normProduct == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR);
            }
            double dot = CallChecker.varInit(((double) (u.dotProduct(v))), "dot", 335, 15556, 15584);
            if (dot < ((2.0E-15 - 1.0) * normProduct)) {
                Vector3D w = CallChecker.varInit(u.orthogonal(), "w", 340, 15754, 15781);
                q0 = 0.0;
                CallChecker.varAssign(this.q0, "this.q0", 341, 15789, 15797);
                q1 = -(w.getX());
                CallChecker.varAssign(this.q1, "this.q1", 342, 15805, 15819);
                q2 = -(w.getY());
                CallChecker.varAssign(this.q2, "this.q2", 343, 15827, 15841);
                q3 = -(w.getZ());
                CallChecker.varAssign(this.q3, "this.q3", 344, 15849, 15863);
            }else {
                q0 = FastMath.sqrt((0.5 * (1.0 + (dot / normProduct))));
                CallChecker.varAssign(this.q0, "this.q0", 348, 16012, 16063);
                double coeff = CallChecker.varInit(((double) (1.0 / ((2.0 * (this.q0)) * normProduct))), "coeff", 349, 16071, 16116);
                Vector3D q = CallChecker.varInit(v.crossProduct(u), "q", 350, 16124, 16154);
                q1 = coeff * (q.getX());
                CallChecker.varAssign(this.q1, "this.q1", 351, 16162, 16183);
                q2 = coeff * (q.getY());
                CallChecker.varAssign(this.q2, "this.q2", 352, 16191, 16212);
                q3 = coeff * (q.getZ());
                CallChecker.varAssign(this.q3, "this.q3", 353, 16220, 16241);
            }
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    public Rotation(RotationOrder order, double alpha1, double alpha2, double alpha3) {
        ConstructorContext _bcornu_methode_context64 = new ConstructorContext(Rotation.class, 377, 16257, 17719);
        try {
            Rotation r1 = CallChecker.varInit(new Rotation(order.getA1(), alpha1), "r1", 379, 17402, 17451);
            Rotation r2 = CallChecker.varInit(new Rotation(order.getA2(), alpha2), "r2", 380, 17459, 17508);
            Rotation r3 = CallChecker.varInit(new Rotation(order.getA3(), alpha3), "r3", 381, 17516, 17565);
            Rotation composed = CallChecker.varInit(r1.applyTo(r2.applyTo(r3)), "composed", 382, 17573, 17619);
            q0 = composed.q0;
            CallChecker.varAssign(this.q0, "this.q0", 383, 17627, 17643);
            q1 = composed.q1;
            CallChecker.varAssign(this.q1, "this.q1", 384, 17651, 17667);
            q2 = composed.q2;
            CallChecker.varAssign(this.q2, "this.q2", 385, 17675, 17691);
            q3 = composed.q3;
            CallChecker.varAssign(this.q3, "this.q3", 386, 17699, 17715);
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    private static double[] mat2quat(final double[][] ort) {
        MethodContext _bcornu_methode_context235 = new MethodContext(double[].class, 393, 17724, 20435);
        try {
            CallChecker.varInit(ort, "ort", 393, 17724, 20435);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 393, 17724, 20435);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 393, 17724, 20435);
            final double[] quat = CallChecker.varInit(new double[4], "quat", 395, 17950, 17985);
            double s = CallChecker.varInit(((double) (((ort[0][0]) + (ort[1][1])) + (ort[2][2]))), "s", 408, 18749, 18793);
            if (s > (-0.19)) {
                quat[0] = 0.5 * (FastMath.sqrt((s + 1.0)));
                CallChecker.varAssign(quat[0], "quat[0]", 411, 18877, 18915);
                double inv = CallChecker.varInit(((double) (0.25 / (quat[0]))), "inv", 412, 18927, 18954);
                quat[1] = inv * ((ort[1][2]) - (ort[2][1]));
                CallChecker.varAssign(quat[1], "quat[1]", 413, 18966, 19005);
                quat[2] = inv * ((ort[2][0]) - (ort[0][2]));
                CallChecker.varAssign(quat[2], "quat[2]", 414, 19017, 19056);
                quat[3] = inv * ((ort[0][1]) - (ort[1][0]));
                CallChecker.varAssign(quat[3], "quat[3]", 415, 19068, 19107);
            }else {
                s = ((ort[0][0]) - (ort[1][1])) - (ort[2][2]);
                CallChecker.varAssign(s, "s", 417, 19134, 19171);
                if (s > (-0.19)) {
                    quat[1] = 0.5 * (FastMath.sqrt((s + 1.0)));
                    CallChecker.varAssign(quat[1], "quat[1]", 420, 19267, 19305);
                    double inv = CallChecker.varInit(((double) (0.25 / (quat[1]))), "inv", 421, 19321, 19348);
                    quat[0] = inv * ((ort[1][2]) - (ort[2][1]));
                    CallChecker.varAssign(quat[0], "quat[0]", 422, 19364, 19403);
                    quat[2] = inv * ((ort[0][1]) + (ort[1][0]));
                    CallChecker.varAssign(quat[2], "quat[2]", 423, 19419, 19458);
                    quat[3] = inv * ((ort[0][2]) + (ort[2][0]));
                    CallChecker.varAssign(quat[3], "quat[3]", 424, 19474, 19513);
                }else {
                    s = ((ort[1][1]) - (ort[0][0])) - (ort[2][2]);
                    CallChecker.varAssign(s, "s", 426, 19548, 19585);
                    if (s > (-0.19)) {
                        quat[2] = 0.5 * (FastMath.sqrt((s + 1.0)));
                        CallChecker.varAssign(quat[2], "quat[2]", 429, 19693, 19731);
                        double inv = CallChecker.varInit(((double) (0.25 / (quat[2]))), "inv", 430, 19751, 19778);
                        quat[0] = inv * ((ort[2][0]) - (ort[0][2]));
                        CallChecker.varAssign(quat[0], "quat[0]", 431, 19798, 19837);
                        quat[1] = inv * ((ort[0][1]) + (ort[1][0]));
                        CallChecker.varAssign(quat[1], "quat[1]", 432, 19857, 19896);
                        quat[3] = inv * ((ort[2][1]) + (ort[1][2]));
                        CallChecker.varAssign(quat[3], "quat[3]", 433, 19916, 19955);
                    }else {
                        s = ((ort[2][2]) - (ort[0][0])) - (ort[1][1]);
                        CallChecker.varAssign(s, "s", 436, 20055, 20092);
                        quat[3] = 0.5 * (FastMath.sqrt((s + 1.0)));
                        CallChecker.varAssign(quat[3], "quat[3]", 437, 20112, 20150);
                        double inv = CallChecker.varInit(((double) (0.25 / (quat[3]))), "inv", 438, 20170, 20197);
                        quat[0] = inv * ((ort[0][1]) - (ort[1][0]));
                        CallChecker.varAssign(quat[0], "quat[0]", 439, 20217, 20256);
                        quat[1] = inv * ((ort[0][2]) + (ort[2][0]));
                        CallChecker.varAssign(quat[1], "quat[1]", 440, 20276, 20315);
                        quat[2] = inv * ((ort[2][1]) + (ort[1][2]));
                        CallChecker.varAssign(quat[2], "quat[2]", 441, 20335, 20374);
                    }
                }
            }
            return quat;
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[]) (CallChecker.isToCatch(_bcornu_return_t, double[].class)));
        } finally {
            _bcornu_methode_context235.methodEnd();
        }
    }

    public Rotation revert() {
        MethodContext _bcornu_methode_context236 = new MethodContext(Rotation.class, 457, 20440, 20798);
        try {
            CallChecker.varInit(this, "this", 457, 20440, 20798);
            CallChecker.varInit(this.q3, "q3", 457, 20440, 20798);
            CallChecker.varInit(this.q2, "q2", 457, 20440, 20798);
            CallChecker.varInit(this.q1, "q1", 457, 20440, 20798);
            CallChecker.varInit(this.q0, "q0", 457, 20440, 20798);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 457, 20440, 20798);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 457, 20440, 20798);
            return new Rotation((-(q0)), q1, q2, q3, false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Rotation) (CallChecker.isToCatch(_bcornu_return_t, Rotation.class)));
        } finally {
            _bcornu_methode_context236.methodEnd();
        }
    }

    public double getQ0() {
        MethodContext _bcornu_methode_context237 = new MethodContext(double.class, 464, 20803, 20950);
        try {
            CallChecker.varInit(this, "this", 464, 20803, 20950);
            CallChecker.varInit(this.q3, "q3", 464, 20803, 20950);
            CallChecker.varInit(this.q2, "q2", 464, 20803, 20950);
            CallChecker.varInit(this.q1, "q1", 464, 20803, 20950);
            CallChecker.varInit(this.q0, "q0", 464, 20803, 20950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 464, 20803, 20950);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 464, 20803, 20950);
            return q0;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    public double getQ1() {
        MethodContext _bcornu_methode_context238 = new MethodContext(double.class, 471, 20955, 21144);
        try {
            CallChecker.varInit(this, "this", 471, 20955, 21144);
            CallChecker.varInit(this.q3, "q3", 471, 20955, 21144);
            CallChecker.varInit(this.q2, "q2", 471, 20955, 21144);
            CallChecker.varInit(this.q1, "q1", 471, 20955, 21144);
            CallChecker.varInit(this.q0, "q0", 471, 20955, 21144);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 471, 20955, 21144);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 471, 20955, 21144);
            return q1;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    public double getQ2() {
        MethodContext _bcornu_methode_context239 = new MethodContext(double.class, 478, 21149, 21340);
        try {
            CallChecker.varInit(this, "this", 478, 21149, 21340);
            CallChecker.varInit(this.q3, "q3", 478, 21149, 21340);
            CallChecker.varInit(this.q2, "q2", 478, 21149, 21340);
            CallChecker.varInit(this.q1, "q1", 478, 21149, 21340);
            CallChecker.varInit(this.q0, "q0", 478, 21149, 21340);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 478, 21149, 21340);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 478, 21149, 21340);
            return q2;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }

    public double getQ3() {
        MethodContext _bcornu_methode_context240 = new MethodContext(double.class, 485, 21345, 21534);
        try {
            CallChecker.varInit(this, "this", 485, 21345, 21534);
            CallChecker.varInit(this.q3, "q3", 485, 21345, 21534);
            CallChecker.varInit(this.q2, "q2", 485, 21345, 21534);
            CallChecker.varInit(this.q1, "q1", 485, 21345, 21534);
            CallChecker.varInit(this.q0, "q0", 485, 21345, 21534);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 485, 21345, 21534);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 485, 21345, 21534);
            return q3;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context240.methodEnd();
        }
    }

    public Vector3D getAxis() {
        MethodContext _bcornu_methode_context241 = new MethodContext(Vector3D.class, 493, 21539, 22099);
        try {
            CallChecker.varInit(this, "this", 493, 21539, 22099);
            CallChecker.varInit(this.q3, "q3", 493, 21539, 22099);
            CallChecker.varInit(this.q2, "q2", 493, 21539, 22099);
            CallChecker.varInit(this.q1, "q1", 493, 21539, 22099);
            CallChecker.varInit(this.q0, "q0", 493, 21539, 22099);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 493, 21539, 22099);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 493, 21539, 22099);
            double squaredSine = CallChecker.varInit(((double) ((((this.q1) * (this.q1)) + ((this.q2) * (this.q2))) + ((this.q3) * (this.q3)))), "squaredSine", 494, 21707, 21755);
            if (squaredSine == 0) {
                return new Vector3D(1, 0, 0);
            }else
                if ((q0) < 0) {
                    double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt(squaredSine)))), "inverse", 498, 21852, 21899);
                    return new Vector3D(((q1) * inverse), ((q2) * inverse), ((q3) * inverse));
                }
            
            double inverse = CallChecker.varInit(((double) ((-1) / (FastMath.sqrt(squaredSine)))), "inverse", 501, 21980, 22028);
            return new Vector3D(((q1) * inverse), ((q2) * inverse), ((q3) * inverse));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context241.methodEnd();
        }
    }

    public double getAngle() {
        MethodContext _bcornu_methode_context242 = new MethodContext(double.class, 509, 22104, 22485);
        try {
            CallChecker.varInit(this, "this", 509, 22104, 22485);
            CallChecker.varInit(this.q3, "q3", 509, 22104, 22485);
            CallChecker.varInit(this.q2, "q2", 509, 22104, 22485);
            CallChecker.varInit(this.q1, "q1", 509, 22104, 22485);
            CallChecker.varInit(this.q0, "q0", 509, 22104, 22485);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 509, 22104, 22485);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 509, 22104, 22485);
            if (((q0) < (-0.1)) || ((q0) > 0.1)) {
                return 2 * (FastMath.asin(FastMath.sqrt(((((q1) * (q1)) + ((q2) * (q2))) + ((q3) * (q3))))));
            }else
                if ((q0) < 0) {
                    return 2 * (FastMath.acos((-(q0))));
                }
            
            return 2 * (FastMath.acos(q0));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    public double[] getAngles(RotationOrder order) throws CardanEulerSingularityException {
        MethodContext _bcornu_methode_context243 = new MethodContext(double[].class, 553, 22490, 33390);
        try {
            CallChecker.varInit(this, "this", 553, 22490, 33390);
            CallChecker.varInit(order, "order", 553, 22490, 33390);
            CallChecker.varInit(this.q3, "q3", 553, 22490, 33390);
            CallChecker.varInit(this.q2, "q2", 553, 22490, 33390);
            CallChecker.varInit(this.q1, "q1", 553, 22490, 33390);
            CallChecker.varInit(this.q0, "q0", 553, 22490, 33390);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 553, 22490, 33390);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 553, 22490, 33390);
            if (order == (RotationOrder.XYZ)) {
                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 563, 24831, 24869);
                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 564, 24877, 24922);
                if (((v2.getZ()) < (-0.9999999999)) || ((v2.getZ()) > 0.9999999999)) {
                    throw new CardanEulerSingularityException(true);
                }
                return new double[]{ FastMath.atan2((-(v1.getY())), v1.getZ()) , FastMath.asin(v2.getZ()) , FastMath.atan2((-(v2.getY())), v2.getX()) };
            }else
                if (order == (RotationOrder.XZY)) {
                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 581, 25576, 25614);
                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 582, 25622, 25667);
                    if (((v2.getY()) < (-0.9999999999)) || ((v2.getY()) > 0.9999999999)) {
                        throw new CardanEulerSingularityException(true);
                    }
                    return new double[]{ FastMath.atan2(v1.getZ(), v1.getY()) , -(FastMath.asin(v2.getY())) , FastMath.atan2(v2.getZ(), v2.getX()) };
                }else
                    if (order == (RotationOrder.YXZ)) {
                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 599, 26315, 26353);
                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 600, 26361, 26406);
                        if (((v2.getZ()) < (-0.9999999999)) || ((v2.getZ()) > 0.9999999999)) {
                            throw new CardanEulerSingularityException(true);
                        }
                        return new double[]{ FastMath.atan2(v1.getX(), v1.getZ()) , -(FastMath.asin(v2.getZ())) , FastMath.atan2(v2.getX(), v2.getY()) };
                    }else
                        if (order == (RotationOrder.YZX)) {
                            Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 617, 27053, 27091);
                            Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 618, 27099, 27144);
                            if (((v2.getX()) < (-0.9999999999)) || ((v2.getX()) > 0.9999999999)) {
                                throw new CardanEulerSingularityException(true);
                            }
                            return new double[]{ FastMath.atan2((-(v1.getZ())), v1.getX()) , FastMath.asin(v2.getX()) , FastMath.atan2((-(v2.getZ())), v2.getY()) };
                        }else
                            if (order == (RotationOrder.ZXY)) {
                                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 635, 27797, 27835);
                                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 636, 27843, 27888);
                                if (((v2.getY()) < (-0.9999999999)) || ((v2.getY()) > 0.9999999999)) {
                                    throw new CardanEulerSingularityException(true);
                                }
                                return new double[]{ FastMath.atan2((-(v1.getX())), v1.getY()) , FastMath.asin(v2.getY()) , FastMath.atan2((-(v2.getX())), v2.getZ()) };
                            }else
                                if (order == (RotationOrder.ZYX)) {
                                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 653, 28552, 28590);
                                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 654, 28598, 28643);
                                    if (((v2.getX()) < (-0.9999999999)) || ((v2.getX()) > 0.9999999999)) {
                                        throw new CardanEulerSingularityException(true);
                                    }
                                    return new double[]{ FastMath.atan2(v1.getY(), v1.getX()) , -(FastMath.asin(v2.getX())) , FastMath.atan2(v2.getY(), v2.getZ()) };
                                }else
                                    if (order == (RotationOrder.XYX)) {
                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 671, 29297, 29335);
                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 672, 29343, 29388);
                                        if (((v2.getX()) < (-0.9999999999)) || ((v2.getX()) > 0.9999999999)) {
                                            throw new CardanEulerSingularityException(false);
                                        }
                                        return new double[]{ FastMath.atan2(v1.getY(), (-(v1.getZ()))) , FastMath.acos(v2.getX()) , FastMath.atan2(v2.getY(), v2.getZ()) };
                                    }else
                                        if (order == (RotationOrder.XZX)) {
                                            Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 689, 30030, 30068);
                                            Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 690, 30076, 30121);
                                            if (((v2.getX()) < (-0.9999999999)) || ((v2.getX()) > 0.9999999999)) {
                                                throw new CardanEulerSingularityException(false);
                                            }
                                            return new double[]{ FastMath.atan2(v1.getZ(), v1.getY()) , FastMath.acos(v2.getX()) , FastMath.atan2(v2.getZ(), (-(v2.getY()))) };
                                        }else
                                            if (order == (RotationOrder.YXY)) {
                                                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 707, 30771, 30809);
                                                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 708, 30817, 30862);
                                                if (((v2.getY()) < (-0.9999999999)) || ((v2.getY()) > 0.9999999999)) {
                                                    throw new CardanEulerSingularityException(false);
                                                }
                                                return new double[]{ FastMath.atan2(v1.getX(), v1.getZ()) , FastMath.acos(v2.getY()) , FastMath.atan2(v2.getX(), (-(v2.getZ()))) };
                                            }else
                                                if (order == (RotationOrder.YZY)) {
                                                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 725, 31512, 31550);
                                                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 726, 31558, 31603);
                                                    if (((v2.getY()) < (-0.9999999999)) || ((v2.getY()) > 0.9999999999)) {
                                                        throw new CardanEulerSingularityException(false);
                                                    }
                                                    return new double[]{ FastMath.atan2(v1.getZ(), (-(v1.getX()))) , FastMath.acos(v2.getY()) , FastMath.atan2(v2.getZ(), v2.getX()) };
                                                }else
                                                    if (order == (RotationOrder.ZXZ)) {
                                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 743, 32245, 32283);
                                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 744, 32291, 32336);
                                                        if (((v2.getZ()) < (-0.9999999999)) || ((v2.getZ()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                        return new double[]{ FastMath.atan2(v1.getX(), (-(v1.getY()))) , FastMath.acos(v2.getZ()) , FastMath.atan2(v2.getX(), v2.getY()) };
                                                    }else {
                                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 761, 32987, 33025);
                                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 762, 33033, 33078);
                                                        if (((v2.getZ()) < (-0.9999999999)) || ((v2.getZ()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                        return new double[]{ FastMath.atan2(v1.getY(), v1.getX()) , FastMath.acos(v2.getZ()) , FastMath.atan2(v2.getY(), (-(v2.getX()))) };
                                                    }
                                                
                                            
                                        
                                    
                                
                            
                        
                    
                
            
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[]) (CallChecker.isToCatch(_bcornu_return_t, double[].class)));
        } finally {
            _bcornu_methode_context243.methodEnd();
        }
    }

    public double[][] getMatrix() {
        MethodContext _bcornu_methode_context244 = new MethodContext(double[][].class, 779, 33395, 34342);
        try {
            CallChecker.varInit(this, "this", 779, 33395, 34342);
            CallChecker.varInit(this.q3, "q3", 779, 33395, 34342);
            CallChecker.varInit(this.q2, "q2", 779, 33395, 34342);
            CallChecker.varInit(this.q1, "q1", 779, 33395, 34342);
            CallChecker.varInit(this.q0, "q0", 779, 33395, 34342);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 779, 33395, 34342);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 779, 33395, 34342);
            double q0q0 = CallChecker.varInit(((double) ((this.q0) * (this.q0))), "q0q0", 782, 33563, 33585);
            double q0q1 = CallChecker.varInit(((double) ((this.q0) * (this.q1))), "q0q1", 783, 33591, 33613);
            double q0q2 = CallChecker.varInit(((double) ((this.q0) * (this.q2))), "q0q2", 784, 33619, 33641);
            double q0q3 = CallChecker.varInit(((double) ((this.q0) * (this.q3))), "q0q3", 785, 33647, 33669);
            double q1q1 = CallChecker.varInit(((double) ((this.q1) * (this.q1))), "q1q1", 786, 33675, 33697);
            double q1q2 = CallChecker.varInit(((double) ((this.q1) * (this.q2))), "q1q2", 787, 33703, 33725);
            double q1q3 = CallChecker.varInit(((double) ((this.q1) * (this.q3))), "q1q3", 788, 33731, 33753);
            double q2q2 = CallChecker.varInit(((double) ((this.q2) * (this.q2))), "q2q2", 789, 33759, 33781);
            double q2q3 = CallChecker.varInit(((double) ((this.q2) * (this.q3))), "q2q3", 790, 33787, 33809);
            double q3q3 = CallChecker.varInit(((double) ((this.q3) * (this.q3))), "q3q3", 791, 33815, 33837);
            double[][] m = CallChecker.varInit(new double[3][], "m", 794, 33869, 33899);
            m[0] = new double[3];
            CallChecker.varAssign(m[0], "m[0]", 795, 33905, 33925);
            m[1] = new double[3];
            CallChecker.varAssign(m[1], "m[1]", 796, 33931, 33951);
            m[2] = new double[3];
            CallChecker.varAssign(m[2], "m[2]", 797, 33957, 33977);
            m[0][0] = (2.0 * (q0q0 + q1q1)) - 1.0;
            CallChecker.varAssign(m[0][0], "m[0][0]", 799, 33984, 34020);
            m[1][0] = 2.0 * (q1q2 - q0q3);
            CallChecker.varAssign(m[1][0], "m[1][0]", 800, 34026, 34056);
            m[2][0] = 2.0 * (q1q3 + q0q2);
            CallChecker.varAssign(m[2][0], "m[2][0]", 801, 34062, 34092);
            m[0][1] = 2.0 * (q1q2 + q0q3);
            CallChecker.varAssign(m[0][1], "m[0][1]", 803, 34099, 34129);
            m[1][1] = (2.0 * (q0q0 + q2q2)) - 1.0;
            CallChecker.varAssign(m[1][1], "m[1][1]", 804, 34135, 34171);
            m[2][1] = 2.0 * (q2q3 - q0q1);
            CallChecker.varAssign(m[2][1], "m[2][1]", 805, 34177, 34207);
            m[0][2] = 2.0 * (q1q3 - q0q2);
            CallChecker.varAssign(m[0][2], "m[0][2]", 807, 34214, 34244);
            m[1][2] = 2.0 * (q2q3 + q0q1);
            CallChecker.varAssign(m[1][2], "m[1][2]", 808, 34250, 34280);
            m[2][2] = (2.0 * (q0q0 + q3q3)) - 1.0;
            CallChecker.varAssign(m[2][2], "m[2][2]", 809, 34286, 34322);
            return m;
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[][]) (CallChecker.isToCatch(_bcornu_return_t, double[][].class)));
        } finally {
            _bcornu_methode_context244.methodEnd();
        }
    }

    public Vector3D applyTo(Vector3D u) {
        MethodContext _bcornu_methode_context245 = new MethodContext(Vector3D.class, 819, 34347, 34898);
        try {
            CallChecker.varInit(this, "this", 819, 34347, 34898);
            CallChecker.varInit(u, "u", 819, 34347, 34898);
            CallChecker.varInit(this.q3, "q3", 819, 34347, 34898);
            CallChecker.varInit(this.q2, "q2", 819, 34347, 34898);
            CallChecker.varInit(this.q1, "q1", 819, 34347, 34898);
            CallChecker.varInit(this.q0, "q0", 819, 34347, 34898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 819, 34347, 34898);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 819, 34347, 34898);
            double x = CallChecker.varInit(((double) (u.getX())), "x", 821, 34546, 34565);
            double y = CallChecker.varInit(((double) (u.getY())), "y", 822, 34571, 34590);
            double z = CallChecker.varInit(((double) (u.getZ())), "z", 823, 34596, 34615);
            double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 825, 34622, 34657);
            return new Vector3D(((2 * (((q0) * ((x * (q0)) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x), ((2 * (((q0) * ((y * (q0)) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y), ((2 * (((q0) * ((z * (q0)) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context245.methodEnd();
        }
    }

    public void applyTo(final double[] in, final double[] out) {
        MethodContext _bcornu_methode_context246 = new MethodContext(void.class, 838, 34903, 35547);
        try {
            CallChecker.varInit(this, "this", 838, 34903, 35547);
            CallChecker.varInit(out, "out", 838, 34903, 35547);
            CallChecker.varInit(in, "in", 838, 34903, 35547);
            CallChecker.varInit(this.q3, "q3", 838, 34903, 35547);
            CallChecker.varInit(this.q2, "q2", 838, 34903, 35547);
            CallChecker.varInit(this.q1, "q1", 838, 34903, 35547);
            CallChecker.varInit(this.q0, "q0", 838, 34903, 35547);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 838, 34903, 35547);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 838, 34903, 35547);
            final double x = CallChecker.varInit(((double) (in[0])), "x", 840, 35202, 35224);
            final double y = CallChecker.varInit(((double) (in[1])), "y", 841, 35232, 35254);
            final double z = CallChecker.varInit(((double) (in[2])), "z", 842, 35262, 35284);
            final double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 844, 35293, 35334);
            out[0] = (2 * (((q0) * ((x * (q0)) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x;
            CallChecker.varAssign(out[0], "out[0]", 846, 35343, 35404);
            out[1] = (2 * (((q0) * ((y * (q0)) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y;
            CallChecker.varAssign(out[1], "out[1]", 847, 35412, 35473);
            out[2] = (2 * (((q0) * ((z * (q0)) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z;
            CallChecker.varAssign(out[2], "out[2]", 848, 35481, 35542);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context246.methodEnd();
        }
    }

    public Vector3D applyInverseTo(Vector3D u) {
        MethodContext _bcornu_methode_context247 = new MethodContext(Vector3D.class, 856, 35552, 36168);
        try {
            CallChecker.varInit(this, "this", 856, 35552, 36168);
            CallChecker.varInit(u, "u", 856, 35552, 36168);
            CallChecker.varInit(this.q3, "q3", 856, 35552, 36168);
            CallChecker.varInit(this.q2, "q2", 856, 35552, 36168);
            CallChecker.varInit(this.q1, "q1", 856, 35552, 36168);
            CallChecker.varInit(this.q0, "q0", 856, 35552, 36168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 856, 35552, 36168);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 856, 35552, 36168);
            double x = CallChecker.varInit(((double) (u.getX())), "x", 858, 35795, 35814);
            double y = CallChecker.varInit(((double) (u.getY())), "y", 859, 35820, 35839);
            double z = CallChecker.varInit(((double) (u.getZ())), "z", 860, 35845, 35864);
            double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 862, 35871, 35906);
            double m0 = CallChecker.varInit(((double) (-(this.q0))), "m0", 863, 35912, 35927);
            return new Vector3D(((2 * ((m0 * ((x * m0) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x), ((2 * ((m0 * ((y * m0) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y), ((2 * ((m0 * ((z * m0) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context247.methodEnd();
        }
    }

    public void applyInverseTo(final double[] in, final double[] out) {
        MethodContext _bcornu_methode_context248 = new MethodContext(void.class, 876, 36173, 36868);
        try {
            CallChecker.varInit(this, "this", 876, 36173, 36868);
            CallChecker.varInit(out, "out", 876, 36173, 36868);
            CallChecker.varInit(in, "in", 876, 36173, 36868);
            CallChecker.varInit(this.q3, "q3", 876, 36173, 36868);
            CallChecker.varInit(this.q2, "q2", 876, 36173, 36868);
            CallChecker.varInit(this.q1, "q1", 876, 36173, 36868);
            CallChecker.varInit(this.q0, "q0", 876, 36173, 36868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 876, 36173, 36868);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 876, 36173, 36868);
            final double x = CallChecker.varInit(((double) (in[0])), "x", 878, 36494, 36516);
            final double y = CallChecker.varInit(((double) (in[1])), "y", 879, 36524, 36546);
            final double z = CallChecker.varInit(((double) (in[2])), "z", 880, 36554, 36576);
            final double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 882, 36585, 36626);
            final double m0 = CallChecker.varInit(((double) (-(this.q0))), "m0", 883, 36634, 36655);
            out[0] = (2 * ((m0 * ((x * m0) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x;
            CallChecker.varAssign(out[0], "out[0]", 885, 36664, 36725);
            out[1] = (2 * ((m0 * ((y * m0) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y;
            CallChecker.varAssign(out[1], "out[1]", 886, 36733, 36794);
            out[2] = (2 * ((m0 * ((z * m0) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z;
            CallChecker.varAssign(out[2], "out[2]", 887, 36802, 36863);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context248.methodEnd();
        }
    }

    public Rotation applyTo(Rotation r) {
        MethodContext _bcornu_methode_context249 = new MethodContext(Rotation.class, 900, 36873, 37729);
        try {
            CallChecker.varInit(this, "this", 900, 36873, 37729);
            CallChecker.varInit(r, "r", 900, 36873, 37729);
            CallChecker.varInit(this.q3, "q3", 900, 36873, 37729);
            CallChecker.varInit(this.q2, "q2", 900, 36873, 37729);
            CallChecker.varInit(this.q1, "q1", 900, 36873, 37729);
            CallChecker.varInit(this.q0, "q0", 900, 36873, 37729);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 900, 36873, 37729);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 900, 36873, 37729);
            return new Rotation((((r.q0) * (q0)) - ((((r.q1) * (q1)) + ((r.q2) * (q2))) + ((r.q3) * (q3)))), ((((r.q1) * (q0)) + ((r.q0) * (q1))) + (((r.q2) * (q3)) - ((r.q3) * (q2)))), ((((r.q2) * (q0)) + ((r.q0) * (q2))) + (((r.q3) * (q1)) - ((r.q1) * (q3)))), ((((r.q3) * (q0)) + ((r.q0) * (q3))) + (((r.q1) * (q2)) - ((r.q2) * (q1)))), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Rotation) (CallChecker.isToCatch(_bcornu_return_t, Rotation.class)));
        } finally {
            _bcornu_methode_context249.methodEnd();
        }
    }

    public Rotation applyInverseTo(Rotation r) {
        MethodContext _bcornu_methode_context250 = new MethodContext(Rotation.class, 919, 37734, 38678);
        try {
            CallChecker.varInit(this, "this", 919, 37734, 38678);
            CallChecker.varInit(r, "r", 919, 37734, 38678);
            CallChecker.varInit(this.q3, "q3", 919, 37734, 38678);
            CallChecker.varInit(this.q2, "q2", 919, 37734, 38678);
            CallChecker.varInit(this.q1, "q1", 919, 37734, 38678);
            CallChecker.varInit(this.q0, "q0", 919, 37734, 38678);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 919, 37734, 38678);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 919, 37734, 38678);
            return new Rotation((((-(r.q0)) * (q0)) - ((((r.q1) * (q1)) + ((r.q2) * (q2))) + ((r.q3) * (q3)))), ((((-(r.q1)) * (q0)) + ((r.q0) * (q1))) + (((r.q2) * (q3)) - ((r.q3) * (q2)))), ((((-(r.q2)) * (q0)) + ((r.q0) * (q2))) + (((r.q3) * (q1)) - ((r.q1) * (q3)))), ((((-(r.q3)) * (q0)) + ((r.q0) * (q3))) + (((r.q1) * (q2)) - ((r.q2) * (q1)))), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Rotation) (CallChecker.isToCatch(_bcornu_return_t, Rotation.class)));
        } finally {
            _bcornu_methode_context250.methodEnd();
        }
    }

    private double[][] orthogonalizeMatrix(double[][] m, double threshold) throws NotARotationMatrixException {
        MethodContext _bcornu_methode_context251 = new MethodContext(double[][].class, 937, 38683, 42215);
        try {
            CallChecker.varInit(this, "this", 937, 38683, 42215);
            CallChecker.varInit(threshold, "threshold", 937, 38683, 42215);
            CallChecker.varInit(m, "m", 937, 38683, 42215);
            CallChecker.varInit(this.q3, "q3", 937, 38683, 42215);
            CallChecker.varInit(this.q2, "q2", 937, 38683, 42215);
            CallChecker.varInit(this.q1, "q1", 937, 38683, 42215);
            CallChecker.varInit(this.q0, "q0", 937, 38683, 42215);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 937, 38683, 42215);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 937, 38683, 42215);
            double[] m0 = CallChecker.varInit(m[0], "m0", 939, 39311, 39329);
            double[] m1 = CallChecker.varInit(m[1], "m1", 940, 39335, 39353);
            double[] m2 = CallChecker.varInit(m[2], "m2", 941, 39359, 39377);
            double x00 = CallChecker.varInit(((double) (m0[0])), "x00", 942, 39383, 39401);
            double x01 = CallChecker.varInit(((double) (m0[1])), "x01", 943, 39407, 39425);
            double x02 = CallChecker.varInit(((double) (m0[2])), "x02", 944, 39431, 39449);
            double x10 = CallChecker.varInit(((double) (m1[0])), "x10", 945, 39455, 39473);
            double x11 = CallChecker.varInit(((double) (m1[1])), "x11", 946, 39479, 39497);
            double x12 = CallChecker.varInit(((double) (m1[2])), "x12", 947, 39503, 39521);
            double x20 = CallChecker.varInit(((double) (m2[0])), "x20", 948, 39527, 39545);
            double x21 = CallChecker.varInit(((double) (m2[1])), "x21", 949, 39551, 39569);
            double x22 = CallChecker.varInit(((double) (m2[2])), "x22", 950, 39575, 39593);
            double fn = CallChecker.varInit(((double) (0)), "fn", 951, 39599, 39612);
            double fn1 = CallChecker.init(double.class);
            double[][] o = CallChecker.varInit(new double[3][3], "o", 954, 39635, 39666);
            double[] o0 = CallChecker.varInit(o[0], "o0", 955, 39672, 39690);
            double[] o1 = CallChecker.varInit(o[1], "o1", 956, 39696, 39714);
            double[] o2 = CallChecker.varInit(o[2], "o2", 957, 39720, 39738);
            int i = CallChecker.varInit(((int) (0)), "i", 960, 39807, 39816);
            while ((++i) < 11) {
                double mx00 = CallChecker.varInit(((double) ((((m0[0]) * x00) + ((m1[0]) * x10)) + ((m2[0]) * x20))), "mx00", 964, 39863, 39916);
                double mx10 = CallChecker.varInit(((double) ((((m0[1]) * x00) + ((m1[1]) * x10)) + ((m2[1]) * x20))), "mx10", 965, 39924, 39977);
                double mx20 = CallChecker.varInit(((double) ((((m0[2]) * x00) + ((m1[2]) * x10)) + ((m2[2]) * x20))), "mx20", 966, 39985, 40038);
                double mx01 = CallChecker.varInit(((double) ((((m0[0]) * x01) + ((m1[0]) * x11)) + ((m2[0]) * x21))), "mx01", 967, 40046, 40099);
                double mx11 = CallChecker.varInit(((double) ((((m0[1]) * x01) + ((m1[1]) * x11)) + ((m2[1]) * x21))), "mx11", 968, 40107, 40160);
                double mx21 = CallChecker.varInit(((double) ((((m0[2]) * x01) + ((m1[2]) * x11)) + ((m2[2]) * x21))), "mx21", 969, 40168, 40221);
                double mx02 = CallChecker.varInit(((double) ((((m0[0]) * x02) + ((m1[0]) * x12)) + ((m2[0]) * x22))), "mx02", 970, 40229, 40282);
                double mx12 = CallChecker.varInit(((double) ((((m0[1]) * x02) + ((m1[1]) * x12)) + ((m2[1]) * x22))), "mx12", 971, 40290, 40343);
                double mx22 = CallChecker.varInit(((double) ((((m0[2]) * x02) + ((m1[2]) * x12)) + ((m2[2]) * x22))), "mx22", 972, 40351, 40404);
                o0[0] = x00 - (0.5 * ((((x00 * mx00) + (x01 * mx10)) + (x02 * mx20)) - (m0[0])));
                CallChecker.varAssign(o0[0], "o0[0]", 975, 40427, 40493);
                o0[1] = x01 - (0.5 * ((((x00 * mx01) + (x01 * mx11)) + (x02 * mx21)) - (m0[1])));
                CallChecker.varAssign(o0[1], "o0[1]", 976, 40501, 40567);
                o0[2] = x02 - (0.5 * ((((x00 * mx02) + (x01 * mx12)) + (x02 * mx22)) - (m0[2])));
                CallChecker.varAssign(o0[2], "o0[2]", 977, 40575, 40641);
                o1[0] = x10 - (0.5 * ((((x10 * mx00) + (x11 * mx10)) + (x12 * mx20)) - (m1[0])));
                CallChecker.varAssign(o1[0], "o1[0]", 978, 40649, 40715);
                o1[1] = x11 - (0.5 * ((((x10 * mx01) + (x11 * mx11)) + (x12 * mx21)) - (m1[1])));
                CallChecker.varAssign(o1[1], "o1[1]", 979, 40723, 40789);
                o1[2] = x12 - (0.5 * ((((x10 * mx02) + (x11 * mx12)) + (x12 * mx22)) - (m1[2])));
                CallChecker.varAssign(o1[2], "o1[2]", 980, 40797, 40863);
                o2[0] = x20 - (0.5 * ((((x20 * mx00) + (x21 * mx10)) + (x22 * mx20)) - (m2[0])));
                CallChecker.varAssign(o2[0], "o2[0]", 981, 40871, 40937);
                o2[1] = x21 - (0.5 * ((((x20 * mx01) + (x21 * mx11)) + (x22 * mx21)) - (m2[1])));
                CallChecker.varAssign(o2[1], "o2[1]", 982, 40945, 41011);
                o2[2] = x22 - (0.5 * ((((x20 * mx02) + (x21 * mx12)) + (x22 * mx22)) - (m2[2])));
                CallChecker.varAssign(o2[2], "o2[2]", 983, 41019, 41085);
                double corr00 = CallChecker.varInit(((double) ((o0[0]) - (m0[0]))), "corr00", 986, 41131, 41160);
                double corr01 = CallChecker.varInit(((double) ((o0[1]) - (m0[1]))), "corr01", 987, 41168, 41197);
                double corr02 = CallChecker.varInit(((double) ((o0[2]) - (m0[2]))), "corr02", 988, 41205, 41234);
                double corr10 = CallChecker.varInit(((double) ((o1[0]) - (m1[0]))), "corr10", 989, 41242, 41271);
                double corr11 = CallChecker.varInit(((double) ((o1[1]) - (m1[1]))), "corr11", 990, 41279, 41308);
                double corr12 = CallChecker.varInit(((double) ((o1[2]) - (m1[2]))), "corr12", 991, 41316, 41345);
                double corr20 = CallChecker.varInit(((double) ((o2[0]) - (m2[0]))), "corr20", 992, 41353, 41382);
                double corr21 = CallChecker.varInit(((double) ((o2[1]) - (m2[1]))), "corr21", 993, 41390, 41419);
                double corr22 = CallChecker.varInit(((double) ((o2[2]) - (m2[2]))), "corr22", 994, 41427, 41456);
                fn1 = ((((((((corr00 * corr00) + (corr01 * corr01)) + (corr02 * corr02)) + (corr10 * corr10)) + (corr11 * corr11)) + (corr12 * corr12)) + (corr20 * corr20)) + (corr21 * corr21)) + (corr22 * corr22);
                CallChecker.varAssign(fn1, "fn1", 997, 41507, 41696);
                if ((FastMath.abs((fn1 - fn))) <= threshold) {
                    return o;
                }
                x00 = o0[0];
                CallChecker.varAssign(x00, "x00", 1007, 41841, 41852);
                x01 = o0[1];
                CallChecker.varAssign(x01, "x01", 1008, 41860, 41871);
                x02 = o0[2];
                CallChecker.varAssign(x02, "x02", 1009, 41879, 41890);
                x10 = o1[0];
                CallChecker.varAssign(x10, "x10", 1010, 41898, 41909);
                x11 = o1[1];
                CallChecker.varAssign(x11, "x11", 1011, 41917, 41928);
                x12 = o1[2];
                CallChecker.varAssign(x12, "x12", 1012, 41936, 41947);
                x20 = o2[0];
                CallChecker.varAssign(x20, "x20", 1013, 41955, 41966);
                x21 = o2[1];
                CallChecker.varAssign(x21, "x21", 1014, 41974, 41985);
                x22 = o2[2];
                CallChecker.varAssign(x22, "x22", 1015, 41993, 42004);
                fn = fn1;
                CallChecker.varAssign(fn, "fn", 1016, 42012, 42021);
            } 
            throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, (i - 1));
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[][]) (CallChecker.isToCatch(_bcornu_return_t, double[][].class)));
        } finally {
            _bcornu_methode_context251.methodEnd();
        }
    }

    public static double distance(Rotation r1, Rotation r2) {
        MethodContext _bcornu_methode_context252 = new MethodContext(double.class, 1050, 42220, 43675);
        try {
            CallChecker.varInit(r2, "r2", 1050, 42220, 43675);
            CallChecker.varInit(r1, "r1", 1050, 42220, 43675);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 1050, 42220, 43675);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 1050, 42220, 43675);
            return r1.applyInverseTo(r2).getAngle();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context252.methodEnd();
        }
    }
}

