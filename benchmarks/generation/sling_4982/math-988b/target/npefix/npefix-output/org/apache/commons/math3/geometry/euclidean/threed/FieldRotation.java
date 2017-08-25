package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class FieldRotation<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224L;

    private final T q0;

    private final T q1;

    private final T q2;

    private final T q3;

    public FieldRotation(final T q0, final T q1, final T q2, final T q3, final boolean needsNormalization) {
        ConstructorContext _bcornu_methode_context20 = new ConstructorContext(FieldRotation.class, 76, 2174, 3920);
        try {
            if (needsNormalization) {
                final T inv = CallChecker.varInit(q0.multiply(q0).add(q1.multiply(q1)).add(q2.multiply(q2)).add(q3.multiply(q3)).sqrt().reciprocal(), "inv", 80, 3447, 3622);
                this.q0 = inv.multiply(q0);
                CallChecker.varAssign(this.q0, "this.q0", 82, 3636, 3662);
                this.q1 = inv.multiply(q1);
                CallChecker.varAssign(this.q1, "this.q1", 83, 3676, 3702);
                this.q2 = inv.multiply(q2);
                CallChecker.varAssign(this.q2, "this.q2", 84, 3716, 3742);
                this.q3 = inv.multiply(q3);
                CallChecker.varAssign(this.q3, "this.q3", 85, 3756, 3782);
            }else {
                this.q0 = q0;
                CallChecker.varAssign(this.q0, "this.q0", 87, 3813, 3825);
                this.q1 = q1;
                CallChecker.varAssign(this.q1, "this.q1", 88, 3839, 3851);
                this.q2 = q2;
                CallChecker.varAssign(this.q2, "this.q2", 89, 3865, 3877);
                this.q3 = q3;
                CallChecker.varAssign(this.q3, "this.q3", 90, 3891, 3903);
            }
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public FieldRotation(final FieldVector3D<T> axis, final T angle) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context21 = new ConstructorContext(FieldRotation.class, 116, 3927, 5783);
        try {
            final T norm = CallChecker.varInit(axis.getNorm(), "norm", 119, 5342, 5371);
            if ((norm.getReal()) == 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS);
            }
            final T halfAngle = CallChecker.varInit(angle.multiply((-0.5)), "halfAngle", 124, 5525, 5565);
            final T coeff = CallChecker.varInit(halfAngle.sin().divide(norm), "coeff", 125, 5575, 5619);
            q0 = halfAngle.cos();
            CallChecker.varAssign(this.q0, "this.q0", 127, 5630, 5650);
            q1 = coeff.multiply(axis.getX());
            CallChecker.varAssign(this.q1, "this.q1", 128, 5660, 5692);
            q2 = coeff.multiply(axis.getY());
            CallChecker.varAssign(this.q2, "this.q2", 129, 5702, 5734);
            q3 = coeff.multiply(axis.getZ());
            CallChecker.varAssign(this.q3, "this.q3", 130, 5744, 5776);
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public FieldRotation(final T[][] m, final double threshold) throws NotARotationMatrixException {
        ConstructorContext _bcornu_methode_context22 = new ConstructorContext(FieldRotation.class, 164, 5790, 8765);
        try {
            if (((((m.length) != 3) || ((m[0].length) != 3)) || ((m[1].length) != 3)) || ((m[2].length) != 3)) {
                throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, m.length, m[0].length);
            }
            final T[][] ort = CallChecker.varInit(orthogonalizeMatrix(m, threshold), "ort", 176, 7862, 7913);
            final T d0 = CallChecker.varInit(ort[1][1].multiply(ort[2][2]).subtract(ort[2][1].multiply(ort[1][2])), "d0", 179, 7924, 8051);
            final T d1 = CallChecker.varInit(ort[0][1].multiply(ort[2][2]).subtract(ort[2][1].multiply(ort[0][2])), "d1", 180, 8061, 8143);
            final T d2 = CallChecker.varInit(ort[0][1].multiply(ort[1][2]).subtract(ort[1][1].multiply(ort[0][2])), "d2", 181, 8153, 8235);
            final T det = CallChecker.varInit(ort[0][0].multiply(d0).subtract(ort[1][0].multiply(d1)).add(ort[2][0].multiply(d2)), "det", 182, 8245, 8358);
            if ((det.getReal()) < 0.0) {
                throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, det);
            }
            final T[] quat = CallChecker.varInit(mat2quat(ort), "quat", 190, 8640, 8670);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 191, 8680, 8692);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 192, 8702, 8714);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 193, 8724, 8736);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 194, 8746, 8758);
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public FieldRotation(FieldVector3D<T> u1, FieldVector3D<T> u2, FieldVector3D<T> v1, FieldVector3D<T> v2) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context23 = new ConstructorContext(FieldRotation.class, 217, 8772, 11952);
        try {
            final FieldVector3D<T> u3 = CallChecker.varInit(FieldVector3D.crossProduct(u1, u2).normalize(), "u3", 222, 9924, 10145);
            u2 = FieldVector3D.crossProduct(u3, u1).normalize();
            CallChecker.varAssign(u2, "u2", 223, 10155, 10206);
            u1 = u1.normalize();
            CallChecker.varAssign(u1, "u1", 224, 10216, 10235);
            final FieldVector3D<T> v3 = CallChecker.varInit(FieldVector3D.crossProduct(v1, v2).normalize(), "v3", 228, 10246, 10470);
            v2 = FieldVector3D.crossProduct(v3, v1).normalize();
            CallChecker.varAssign(v2, "v2", 229, 10480, 10531);
            v1 = v1.normalize();
            CallChecker.varAssign(v1, "v1", 230, 10541, 10560);
            final T[][] array = CallChecker.varInit(MathArrays.buildArray(u1.getX().getField(), 3, 3), "array", 233, 10644, 10713);
            array[0][0] = u1.getX().multiply(v1.getX()).add(u2.getX().multiply(v2.getX())).add(u3.getX().multiply(v3.getX()));
            CallChecker.varAssign(array[0][0], "array[0][0]", 234, 10723, 10836);
            array[0][1] = u1.getY().multiply(v1.getX()).add(u2.getY().multiply(v2.getX())).add(u3.getY().multiply(v3.getX()));
            CallChecker.varAssign(array[0][1], "array[0][1]", 235, 10846, 10959);
            array[0][2] = u1.getZ().multiply(v1.getX()).add(u2.getZ().multiply(v2.getX())).add(u3.getZ().multiply(v3.getX()));
            CallChecker.varAssign(array[0][2], "array[0][2]", 236, 10969, 11082);
            array[1][0] = u1.getX().multiply(v1.getY()).add(u2.getX().multiply(v2.getY())).add(u3.getX().multiply(v3.getY()));
            CallChecker.varAssign(array[1][0], "array[1][0]", 237, 11092, 11205);
            array[1][1] = u1.getY().multiply(v1.getY()).add(u2.getY().multiply(v2.getY())).add(u3.getY().multiply(v3.getY()));
            CallChecker.varAssign(array[1][1], "array[1][1]", 238, 11215, 11328);
            array[1][2] = u1.getZ().multiply(v1.getY()).add(u2.getZ().multiply(v2.getY())).add(u3.getZ().multiply(v3.getY()));
            CallChecker.varAssign(array[1][2], "array[1][2]", 239, 11338, 11451);
            array[2][0] = u1.getX().multiply(v1.getZ()).add(u2.getX().multiply(v2.getZ())).add(u3.getX().multiply(v3.getZ()));
            CallChecker.varAssign(array[2][0], "array[2][0]", 240, 11461, 11574);
            array[2][1] = u1.getY().multiply(v1.getZ()).add(u2.getY().multiply(v2.getZ())).add(u3.getY().multiply(v3.getZ()));
            CallChecker.varAssign(array[2][1], "array[2][1]", 241, 11584, 11697);
            array[2][2] = u1.getZ().multiply(v1.getZ()).add(u2.getZ().multiply(v2.getZ())).add(u3.getZ().multiply(v3.getZ()));
            CallChecker.varAssign(array[2][2], "array[2][2]", 242, 11707, 11820);
            T[] quat = CallChecker.varInit(mat2quat(array), "quat", 244, 11831, 11857);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 245, 11867, 11879);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 246, 11889, 11901);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 247, 11911, 11923);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 248, 11933, 11945);
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public FieldRotation(final FieldVector3D<T> u, final FieldVector3D<T> v) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context24 = new ConstructorContext(FieldRotation.class, 265, 11959, 13933);
        try {
            final T normProduct = CallChecker.varInit(u.getNorm().multiply(v.getNorm()), "normProduct", 267, 12726, 12781);
            if ((normProduct.getReal()) == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR);
            }
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(u, v), "dot", 272, 12948, 12992);
            if ((dot.getReal()) < ((2.0E-15 - 1.0) * (normProduct.getReal()))) {
                final FieldVector3D<T> w = CallChecker.varInit(u.orthogonal(), "w", 277, 13080, 13245);
                q0 = normProduct.getField().getZero();
                CallChecker.varAssign(this.q0, "this.q0", 278, 13259, 13296);
                q1 = w.getX().negate();
                CallChecker.varAssign(this.q1, "this.q1", 279, 13310, 13332);
                q2 = w.getY().negate();
                CallChecker.varAssign(this.q2, "this.q2", 280, 13346, 13368);
                q3 = w.getZ().negate();
                CallChecker.varAssign(this.q3, "this.q3", 281, 13382, 13404);
            }else {
                q0 = dot.divide(normProduct).add(1.0).multiply(0.5).sqrt();
                CallChecker.varAssign(this.q0, "this.q0", 285, 13575, 13633);
                final T coeff = CallChecker.varInit(q0.multiply(normProduct).multiply(2.0).reciprocal(), "coeff", 286, 13647, 13714);
                final FieldVector3D<T> q = CallChecker.varInit(FieldVector3D.crossProduct(v, u), "q", 287, 13728, 13787);
                q1 = coeff.multiply(q.getX());
                CallChecker.varAssign(this.q1, "this.q1", 288, 13801, 13830);
                q2 = coeff.multiply(q.getY());
                CallChecker.varAssign(this.q2, "this.q2", 289, 13844, 13873);
                q3 = coeff.multiply(q.getZ());
                CallChecker.varAssign(this.q3, "this.q3", 290, 13887, 13916);
            }
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public FieldRotation(final RotationOrder order, final T alpha1, final T alpha2, final T alpha3) {
        ConstructorContext _bcornu_methode_context25 = new ConstructorContext(FieldRotation.class, 314, 13940, 15661);
        try {
            final T one = CallChecker.varInit(alpha1.getField().getOne(), "one", 315, 15117, 15157);
            final FieldRotation<T> r1 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, order.getA1()), alpha1), "r1", 316, 15167, 15265);
            final FieldRotation<T> r2 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, order.getA2()), alpha2), "r2", 317, 15275, 15373);
            final FieldRotation<T> r3 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, order.getA3()), alpha3), "r3", 318, 15383, 15481);
            final FieldRotation<T> composed = CallChecker.varInit(r1.applyTo(r2.applyTo(r3)), "composed", 319, 15491, 15551);
            q0 = composed.q0;
            CallChecker.varAssign(this.q0, "this.q0", 320, 15561, 15577);
            q1 = composed.q1;
            CallChecker.varAssign(this.q1, "this.q1", 321, 15587, 15603);
            q2 = composed.q2;
            CallChecker.varAssign(this.q2, "this.q2", 322, 15613, 15629);
            q3 = composed.q3;
            CallChecker.varAssign(this.q3, "this.q3", 323, 15639, 15655);
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    private T[] mat2quat(final T[][] ort) {
        MethodContext _bcornu_methode_context69 = new MethodContext(null, 330, 15668, 18793);
        try {
            CallChecker.varInit(this, "this", 330, 15668, 18793);
            CallChecker.varInit(ort, "ort", 330, 15668, 18793);
            CallChecker.varInit(this.q3, "q3", 330, 15668, 18793);
            CallChecker.varInit(this.q2, "q2", 330, 15668, 18793);
            CallChecker.varInit(this.q1, "q1", 330, 15668, 18793);
            CallChecker.varInit(this.q0, "q0", 330, 15668, 18793);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 330, 15668, 18793);
            final T[] quat = CallChecker.varInit(MathArrays.buildArray(ort[0][0].getField(), 4), "quat", 332, 15887, 15950);
            T s = CallChecker.varInit(ort[0][0].add(ort[1][1]).add(ort[2][2]), "s", 345, 16738, 16783);
            if ((s.getReal()) > (-0.19)) {
                quat[0] = s.add(1.0).sqrt().multiply(0.5);
                CallChecker.varAssign(quat[0], "quat[0]", 348, 16883, 16924);
                T inv = CallChecker.varInit(quat[0].reciprocal().multiply(0.25), "inv", 349, 16938, 16981);
                quat[1] = inv.multiply(ort[1][2].subtract(ort[2][1]));
                CallChecker.varAssign(quat[1], "quat[1]", 350, 16995, 17048);
                quat[2] = inv.multiply(ort[2][0].subtract(ort[0][2]));
                CallChecker.varAssign(quat[2], "quat[2]", 351, 17062, 17115);
                quat[3] = inv.multiply(ort[0][1].subtract(ort[1][0]));
                CallChecker.varAssign(quat[3], "quat[3]", 352, 17129, 17182);
            }else {
                s = ort[0][0].subtract(ort[1][1]).subtract(ort[2][2]);
                CallChecker.varAssign(s, "s", 354, 17213, 17266);
                if ((s.getReal()) > (-0.19)) {
                    quat[1] = s.add(1.0).sqrt().multiply(0.5);
                    CallChecker.varAssign(quat[1], "quat[1]", 357, 17378, 17419);
                    T inv = CallChecker.varInit(quat[1].reciprocal().multiply(0.25), "inv", 358, 17437, 17480);
                    quat[0] = inv.multiply(ort[1][2].subtract(ort[2][1]));
                    CallChecker.varAssign(quat[0], "quat[0]", 359, 17498, 17551);
                    quat[2] = inv.multiply(ort[0][1].add(ort[1][0]));
                    CallChecker.varAssign(quat[2], "quat[2]", 360, 17569, 17617);
                    quat[3] = inv.multiply(ort[0][2].add(ort[2][0]));
                    CallChecker.varAssign(quat[3], "quat[3]", 361, 17635, 17683);
                }else {
                    s = ort[1][1].subtract(ort[0][0]).subtract(ort[2][2]);
                    CallChecker.varAssign(s, "s", 363, 17722, 17775);
                    if ((s.getReal()) > (-0.19)) {
                        quat[2] = s.add(1.0).sqrt().multiply(0.5);
                        CallChecker.varAssign(quat[2], "quat[2]", 366, 17899, 17940);
                        T inv = CallChecker.varInit(quat[2].reciprocal().multiply(0.25), "inv", 367, 17962, 18005);
                        quat[0] = inv.multiply(ort[2][0].subtract(ort[0][2]));
                        CallChecker.varAssign(quat[0], "quat[0]", 368, 18027, 18080);
                        quat[1] = inv.multiply(ort[0][1].add(ort[1][0]));
                        CallChecker.varAssign(quat[1], "quat[1]", 369, 18102, 18150);
                        quat[3] = inv.multiply(ort[2][1].add(ort[1][2]));
                        CallChecker.varAssign(quat[3], "quat[3]", 370, 18172, 18220);
                    }else {
                        s = ort[2][2].subtract(ort[0][0]).subtract(ort[1][1]);
                        CallChecker.varAssign(s, "s", 373, 18326, 18379);
                        quat[3] = s.add(1.0).sqrt().multiply(0.5);
                        CallChecker.varAssign(quat[3], "quat[3]", 374, 18401, 18442);
                        T inv = CallChecker.varInit(quat[3].reciprocal().multiply(0.25), "inv", 375, 18464, 18507);
                        quat[0] = inv.multiply(ort[0][1].subtract(ort[1][0]));
                        CallChecker.varAssign(quat[0], "quat[0]", 376, 18529, 18582);
                        quat[1] = inv.multiply(ort[0][2].add(ort[2][0]));
                        CallChecker.varAssign(quat[1], "quat[1]", 377, 18604, 18652);
                        quat[2] = inv.multiply(ort[2][1].add(ort[1][2]));
                        CallChecker.varAssign(quat[2], "quat[2]", 378, 18674, 18722);
                    }
                }
            }
            return quat;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public FieldRotation<T> revert() {
        MethodContext _bcornu_methode_context70 = new MethodContext(FieldRotation.class, 394, 18800, 19202);
        try {
            CallChecker.varInit(this, "this", 394, 18800, 19202);
            CallChecker.varInit(this.q3, "q3", 394, 18800, 19202);
            CallChecker.varInit(this.q2, "q2", 394, 18800, 19202);
            CallChecker.varInit(this.q1, "q1", 394, 18800, 19202);
            CallChecker.varInit(this.q0, "q0", 394, 18800, 19202);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 394, 18800, 19202);
            return new FieldRotation<T>(q0.negate(), q1, q2, q3, false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public T getQ0() {
        MethodContext _bcornu_methode_context71 = new MethodContext(null, 401, 19209, 19363);
        try {
            CallChecker.varInit(this, "this", 401, 19209, 19363);
            CallChecker.varInit(this.q3, "q3", 401, 19209, 19363);
            CallChecker.varInit(this.q2, "q2", 401, 19209, 19363);
            CallChecker.varInit(this.q1, "q1", 401, 19209, 19363);
            CallChecker.varInit(this.q0, "q0", 401, 19209, 19363);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 401, 19209, 19363);
            return q0;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    public T getQ1() {
        MethodContext _bcornu_methode_context72 = new MethodContext(null, 408, 19370, 19566);
        try {
            CallChecker.varInit(this, "this", 408, 19370, 19566);
            CallChecker.varInit(this.q3, "q3", 408, 19370, 19566);
            CallChecker.varInit(this.q2, "q2", 408, 19370, 19566);
            CallChecker.varInit(this.q1, "q1", 408, 19370, 19566);
            CallChecker.varInit(this.q0, "q0", 408, 19370, 19566);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 408, 19370, 19566);
            return q1;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    public T getQ2() {
        MethodContext _bcornu_methode_context73 = new MethodContext(null, 415, 19573, 19771);
        try {
            CallChecker.varInit(this, "this", 415, 19573, 19771);
            CallChecker.varInit(this.q3, "q3", 415, 19573, 19771);
            CallChecker.varInit(this.q2, "q2", 415, 19573, 19771);
            CallChecker.varInit(this.q1, "q1", 415, 19573, 19771);
            CallChecker.varInit(this.q0, "q0", 415, 19573, 19771);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 415, 19573, 19771);
            return q2;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public T getQ3() {
        MethodContext _bcornu_methode_context74 = new MethodContext(null, 422, 19778, 19974);
        try {
            CallChecker.varInit(this, "this", 422, 19778, 19974);
            CallChecker.varInit(this.q3, "q3", 422, 19778, 19974);
            CallChecker.varInit(this.q2, "q2", 422, 19778, 19974);
            CallChecker.varInit(this.q1, "q1", 422, 19778, 19974);
            CallChecker.varInit(this.q0, "q0", 422, 19778, 19974);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 422, 19778, 19974);
            return q3;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    public FieldVector3D<T> getAxis() {
        MethodContext _bcornu_methode_context75 = new MethodContext(FieldVector3D.class, 430, 19981, 20850);
        try {
            CallChecker.varInit(this, "this", 430, 19981, 20850);
            CallChecker.varInit(this.q3, "q3", 430, 19981, 20850);
            CallChecker.varInit(this.q2, "q2", 430, 19981, 20850);
            CallChecker.varInit(this.q1, "q1", 430, 19981, 20850);
            CallChecker.varInit(this.q0, "q0", 430, 19981, 20850);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 430, 19981, 20850);
            final T squaredSine = CallChecker.varInit(q1.multiply(q1).add(q2.multiply(q2)).add(q3.multiply(q3)), "squaredSine", 431, 20189, 20268);
            if ((squaredSine.getReal()) == 0) {
                final Field<T> field = CallChecker.varInit(squaredSine.getField(), "field", 433, 20324, 20369);
                return new FieldVector3D<T>(field.getOne(), field.getZero(), field.getZero());
            }else
                if ((q0.getReal()) < 0) {
                    T inverse = CallChecker.varInit(squaredSine.sqrt().reciprocal(), "inverse", 436, 20513, 20556);
                    return new FieldVector3D<T>(q1.multiply(inverse), q2.multiply(inverse), q3.multiply(inverse));
                }
            
            final T inverse = CallChecker.varInit(squaredSine.sqrt().reciprocal().negate(), "inverse", 439, 20683, 20741);
            return new FieldVector3D<T>(q1.multiply(inverse), q2.multiply(inverse), q3.multiply(inverse));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public T getAngle() {
        MethodContext _bcornu_methode_context76 = new MethodContext(null, 447, 20857, 21351);
        try {
            CallChecker.varInit(this, "this", 447, 20857, 21351);
            CallChecker.varInit(this.q3, "q3", 447, 20857, 21351);
            CallChecker.varInit(this.q2, "q2", 447, 20857, 21351);
            CallChecker.varInit(this.q1, "q1", 447, 20857, 21351);
            CallChecker.varInit(this.q0, "q0", 447, 20857, 21351);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 447, 20857, 21351);
            if (((q0.getReal()) < (-0.1)) || ((q0.getReal()) > 0.1)) {
                return q1.multiply(q1).add(q2.multiply(q2)).add(q3.multiply(q3)).sqrt().asin().multiply(2);
            }else
                if ((q0.getReal()) < 0) {
                    return q0.negate().acos().multiply(2);
                }
            
            return q0.acos().multiply(2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public T[] getAngles(final RotationOrder order) throws CardanEulerSingularityException {
        MethodContext _bcornu_methode_context77 = new MethodContext(null, 491, 21358, 33560);
        try {
            CallChecker.varInit(this, "this", 491, 21358, 33560);
            CallChecker.varInit(order, "order", 491, 21358, 33560);
            CallChecker.varInit(this.q3, "q3", 491, 21358, 33560);
            CallChecker.varInit(this.q2, "q2", 491, 21358, 33560);
            CallChecker.varInit(this.q1, "q1", 491, 21358, 33560);
            CallChecker.varInit(this.q0, "q0", 491, 21358, 33560);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 491, 21358, 33560);
            if (order == (RotationOrder.XYZ)) {
                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 501, 23473, 23836);
                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 502, 23850, 23909);
                if (((v2.getZ().getReal()) < (-0.9999999999)) || ((v2.getZ().getReal()) > 0.9999999999)) {
                    throw new CardanEulerSingularityException(true);
                }
                return buildArray(v1.getY().negate().atan2(v1.getZ()), v2.getZ().asin(), v2.getY().negate().atan2(v2.getX()));
            }else
                if (order == (RotationOrder.XZY)) {
                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 517, 24334, 24686);
                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 518, 24700, 24759);
                    if (((v2.getY().getReal()) < (-0.9999999999)) || ((v2.getY().getReal()) > 0.9999999999)) {
                        throw new CardanEulerSingularityException(true);
                    }
                    return buildArray(v1.getZ().atan2(v1.getY()), v2.getY().asin().negate(), v2.getZ().atan2(v2.getX()));
                }else
                    if (order == (RotationOrder.YXZ)) {
                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 533, 25174, 25527);
                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 534, 25541, 25600);
                        if (((v2.getZ().getReal()) < (-0.9999999999)) || ((v2.getZ().getReal()) > 0.9999999999)) {
                            throw new CardanEulerSingularityException(true);
                        }
                        return buildArray(v1.getX().atan2(v1.getZ()), v2.getZ().asin().negate(), v2.getX().atan2(v2.getY()));
                    }else
                        if (order == (RotationOrder.YZX)) {
                            final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 549, 26015, 26367);
                            final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 550, 26381, 26440);
                            if (((v2.getX().getReal()) < (-0.9999999999)) || ((v2.getX().getReal()) > 0.9999999999)) {
                                throw new CardanEulerSingularityException(true);
                            }
                            return buildArray(v1.getZ().negate().atan2(v1.getX()), v2.getX().asin(), v2.getZ().negate().atan2(v2.getY()));
                        }else
                            if (order == (RotationOrder.ZXY)) {
                                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 565, 26864, 27216);
                                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 566, 27230, 27289);
                                if (((v2.getY().getReal()) < (-0.9999999999)) || ((v2.getY().getReal()) > 0.9999999999)) {
                                    throw new CardanEulerSingularityException(true);
                                }
                                return buildArray(v1.getX().negate().atan2(v1.getY()), v2.getY().asin(), v2.getX().negate().atan2(v2.getZ()));
                            }else
                                if (order == (RotationOrder.ZYX)) {
                                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 581, 27713, 28076);
                                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 582, 28090, 28149);
                                    if (((v2.getX().getReal()) < (-0.9999999999)) || ((v2.getX().getReal()) > 0.9999999999)) {
                                        throw new CardanEulerSingularityException(true);
                                    }
                                    return buildArray(v1.getY().atan2(v1.getX()), v2.getX().asin().negate(), v2.getY().atan2(v2.getZ()));
                                }else
                                    if (order == (RotationOrder.XYX)) {
                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 597, 28564, 28923);
                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 598, 28937, 28996);
                                        if (((v2.getX().getReal()) < (-0.9999999999)) || ((v2.getX().getReal()) > 0.9999999999)) {
                                            throw new CardanEulerSingularityException(false);
                                        }
                                        return buildArray(v1.getY().atan2(v1.getZ().negate()), v2.getX().acos(), v2.getY().atan2(v2.getZ()));
                                    }else
                                        if (order == (RotationOrder.XZX)) {
                                            final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 613, 29412, 29757);
                                            final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 614, 29771, 29830);
                                            if (((v2.getX().getReal()) < (-0.9999999999)) || ((v2.getX().getReal()) > 0.9999999999)) {
                                                throw new CardanEulerSingularityException(false);
                                            }
                                            return buildArray(v1.getZ().atan2(v1.getY()), v2.getX().acos(), v2.getZ().atan2(v2.getY().negate()));
                                        }else
                                            if (order == (RotationOrder.YXY)) {
                                                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 629, 30246, 30599);
                                                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 630, 30613, 30672);
                                                if (((v2.getY().getReal()) < (-0.9999999999)) || ((v2.getY().getReal()) > 0.9999999999)) {
                                                    throw new CardanEulerSingularityException(false);
                                                }
                                                return buildArray(v1.getX().atan2(v1.getZ()), v2.getY().acos(), v2.getX().atan2(v2.getZ().negate()));
                                            }else
                                                if (order == (RotationOrder.YZY)) {
                                                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 645, 31088, 31441);
                                                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 646, 31455, 31514);
                                                    if (((v2.getY().getReal()) < (-0.9999999999)) || ((v2.getY().getReal()) > 0.9999999999)) {
                                                        throw new CardanEulerSingularityException(false);
                                                    }
                                                    return buildArray(v1.getZ().atan2(v1.getX().negate()), v2.getY().acos(), v2.getZ().atan2(v2.getX()));
                                                }else
                                                    if (order == (RotationOrder.ZXZ)) {
                                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 661, 31930, 32275);
                                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 662, 32289, 32348);
                                                        if (((v2.getZ().getReal()) < (-0.9999999999)) || ((v2.getZ().getReal()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                        return buildArray(v1.getX().atan2(v1.getY().negate()), v2.getZ().acos(), v2.getX().atan2(v2.getY()));
                                                    }else {
                                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 677, 32759, 33118);
                                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 678, 33132, 33191);
                                                        if (((v2.getZ().getReal()) < (-0.9999999999)) || ((v2.getZ().getReal()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                        return buildArray(v1.getY().atan2(v1.getX()), v2.getZ().acos(), v2.getY().atan2(v2.getX().negate()));
                                                    }
                                                
                                            
                                        
                                    
                                
                            
                        
                    
                
            
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    private T[] buildArray(final T a0, final T a1, final T a2) {
        MethodContext _bcornu_methode_context78 = new MethodContext(null, 696, 33567, 33971);
        try {
            CallChecker.varInit(this, "this", 696, 33567, 33971);
            CallChecker.varInit(a2, "a2", 696, 33567, 33971);
            CallChecker.varInit(a1, "a1", 696, 33567, 33971);
            CallChecker.varInit(a0, "a0", 696, 33567, 33971);
            CallChecker.varInit(this.q3, "q3", 696, 33567, 33971);
            CallChecker.varInit(this.q2, "q2", 696, 33567, 33971);
            CallChecker.varInit(this.q1, "q1", 696, 33567, 33971);
            CallChecker.varInit(this.q0, "q0", 696, 33567, 33971);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 696, 33567, 33971);
            final T[] array = CallChecker.varInit(MathArrays.buildArray(a0.getField(), 3), "array", 697, 33817, 33874);
            array[0] = a0;
            CallChecker.varAssign(array[0], "array[0]", 698, 33884, 33897);
            array[1] = a1;
            CallChecker.varAssign(array[1], "array[1]", 699, 33907, 33920);
            array[2] = a2;
            CallChecker.varAssign(array[2], "array[2]", 700, 33930, 33943);
            return array;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    private FieldVector3D<T> vector(final double x, final double y, final double z) {
        MethodContext _bcornu_methode_context79 = new MethodContext(FieldVector3D.class, 710, 33978, 34336);
        try {
            CallChecker.varInit(this, "this", 710, 33978, 34336);
            CallChecker.varInit(z, "z", 710, 33978, 34336);
            CallChecker.varInit(y, "y", 710, 33978, 34336);
            CallChecker.varInit(x, "x", 710, 33978, 34336);
            CallChecker.varInit(this.q3, "q3", 710, 33978, 34336);
            CallChecker.varInit(this.q2, "q2", 710, 33978, 34336);
            CallChecker.varInit(this.q1, "q1", 710, 33978, 34336);
            CallChecker.varInit(this.q0, "q0", 710, 33978, 34336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 710, 33978, 34336);
            final T zero = CallChecker.varInit(q0.getField().getZero(), "zero", 711, 34216, 34254);
            return new FieldVector3D<T>(zero.add(x), zero.add(y), zero.add(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public T[][] getMatrix() {
        MethodContext _bcornu_methode_context80 = new MethodContext(null, 718, 34343, 35521);
        try {
            CallChecker.varInit(this, "this", 718, 34343, 35521);
            CallChecker.varInit(this.q3, "q3", 718, 34343, 35521);
            CallChecker.varInit(this.q2, "q2", 718, 34343, 35521);
            CallChecker.varInit(this.q1, "q1", 718, 34343, 35521);
            CallChecker.varInit(this.q0, "q0", 718, 34343, 35521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 718, 34343, 35521);
            final T q0q0 = CallChecker.varInit(q0.multiply(q0), "q0q0", 721, 34500, 34551);
            final T q0q1 = CallChecker.varInit(q0.multiply(q1), "q0q1", 722, 34561, 34592);
            final T q0q2 = CallChecker.varInit(q0.multiply(q2), "q0q2", 723, 34602, 34633);
            final T q0q3 = CallChecker.varInit(q0.multiply(q3), "q0q3", 724, 34643, 34674);
            final T q1q1 = CallChecker.varInit(q1.multiply(q1), "q1q1", 725, 34684, 34715);
            final T q1q2 = CallChecker.varInit(q1.multiply(q2), "q1q2", 726, 34725, 34756);
            final T q1q3 = CallChecker.varInit(q1.multiply(q3), "q1q3", 727, 34766, 34797);
            final T q2q2 = CallChecker.varInit(q2.multiply(q2), "q2q2", 728, 34807, 34838);
            final T q2q3 = CallChecker.varInit(q2.multiply(q3), "q2q3", 729, 34848, 34879);
            final T q3q3 = CallChecker.varInit(q3.multiply(q3), "q3q3", 730, 34889, 34920);
            final T[][] m = CallChecker.varInit(MathArrays.buildArray(q0.getField(), 3, 3), "m", 733, 34960, 35018);
            m[0][0] = q0q0.add(q1q1).multiply(2).subtract(1);
            CallChecker.varAssign(m[0][0], "m[0][0]", 735, 35029, 35078);
            m[1][0] = q1q2.subtract(q0q3).multiply(2);
            CallChecker.varAssign(m[1][0], "m[1][0]", 736, 35088, 35130);
            m[2][0] = q1q3.add(q0q2).multiply(2);
            CallChecker.varAssign(m[2][0], "m[2][0]", 737, 35140, 35177);
            m[0][1] = q1q2.add(q0q3).multiply(2);
            CallChecker.varAssign(m[0][1], "m[0][1]", 739, 35188, 35225);
            m[1][1] = q0q0.add(q2q2).multiply(2).subtract(1);
            CallChecker.varAssign(m[1][1], "m[1][1]", 740, 35235, 35284);
            m[2][1] = q2q3.subtract(q0q1).multiply(2);
            CallChecker.varAssign(m[2][1], "m[2][1]", 741, 35294, 35336);
            m[0][2] = q1q3.subtract(q0q2).multiply(2);
            CallChecker.varAssign(m[0][2], "m[0][2]", 743, 35347, 35389);
            m[1][2] = q2q3.add(q0q1).multiply(2);
            CallChecker.varAssign(m[1][2], "m[1][2]", 744, 35399, 35436);
            m[2][2] = q0q0.add(q3q3).multiply(2).subtract(1);
            CallChecker.varAssign(m[2][2], "m[2][2]", 745, 35446, 35495);
            return m;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[][]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public Rotation toRotation() {
        MethodContext _bcornu_methode_context81 = new MethodContext(Rotation.class, 754, 35528, 35754);
        try {
            CallChecker.varInit(this, "this", 754, 35528, 35754);
            CallChecker.varInit(this.q3, "q3", 754, 35528, 35754);
            CallChecker.varInit(this.q2, "q2", 754, 35528, 35754);
            CallChecker.varInit(this.q1, "q1", 754, 35528, 35754);
            CallChecker.varInit(this.q0, "q0", 754, 35528, 35754);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 754, 35528, 35754);
            return new Rotation(q0.getReal(), q1.getReal(), q2.getReal(), q3.getReal(), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Rotation) (CallChecker.isToCatch(_bcornu_return_t, Rotation.class)));
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    public FieldVector3D<T> applyTo(final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context82 = new MethodContext(FieldVector3D.class, 762, 35761, 36637);
        try {
            CallChecker.varInit(this, "this", 762, 35761, 36637);
            CallChecker.varInit(u, "u", 762, 35761, 36637);
            CallChecker.varInit(this.q3, "q3", 762, 35761, 36637);
            CallChecker.varInit(this.q2, "q2", 762, 35761, 36637);
            CallChecker.varInit(this.q1, "q1", 762, 35761, 36637);
            CallChecker.varInit(this.q0, "q0", 762, 35761, 36637);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 762, 35761, 36637);
            final T x = CallChecker.varInit(u.getX(), "x", 764, 35994, 36014);
            final T y = CallChecker.varInit(u.getY(), "y", 765, 36024, 36044);
            final T z = CallChecker.varInit(u.getZ(), "z", 766, 36054, 36074);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 768, 36085, 36151);
            return new FieldVector3D<T>(q0.multiply(x.multiply(q0).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x), q0.multiply(y.multiply(q0).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y), q0.multiply(z.multiply(q0).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public FieldVector3D<T> applyTo(final Vector3D u) {
        MethodContext _bcornu_methode_context83 = new MethodContext(FieldVector3D.class, 780, 36644, 37527);
        try {
            CallChecker.varInit(this, "this", 780, 36644, 37527);
            CallChecker.varInit(u, "u", 780, 36644, 37527);
            CallChecker.varInit(this.q3, "q3", 780, 36644, 37527);
            CallChecker.varInit(this.q2, "q2", 780, 36644, 37527);
            CallChecker.varInit(this.q1, "q1", 780, 36644, 37527);
            CallChecker.varInit(this.q0, "q0", 780, 36644, 37527);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 780, 36644, 37527);
            final double x = CallChecker.varInit(((double) (u.getX())), "x", 782, 36869, 36894);
            final double y = CallChecker.varInit(((double) (u.getY())), "y", 783, 36904, 36929);
            final double z = CallChecker.varInit(((double) (u.getZ())), "z", 784, 36939, 36964);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 786, 36975, 37041);
            return new FieldVector3D<T>(q0.multiply(q0.multiply(x).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x), q0.multiply(q0.multiply(y).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y), q0.multiply(q0.multiply(z).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context83.methodEnd();
        }
    }

    public void applyTo(final T[] in, final T[] out) {
        MethodContext _bcornu_methode_context84 = new MethodContext(void.class, 799, 37534, 38411);
        try {
            CallChecker.varInit(this, "this", 799, 37534, 38411);
            CallChecker.varInit(out, "out", 799, 37534, 38411);
            CallChecker.varInit(in, "in", 799, 37534, 38411);
            CallChecker.varInit(this.q3, "q3", 799, 37534, 38411);
            CallChecker.varInit(this.q2, "q2", 799, 37534, 38411);
            CallChecker.varInit(this.q1, "q1", 799, 37534, 38411);
            CallChecker.varInit(this.q0, "q0", 799, 37534, 38411);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 799, 37534, 38411);
            final T x = CallChecker.varInit(in[0], "x", 801, 37835, 37852);
            final T y = CallChecker.varInit(in[1], "y", 802, 37862, 37879);
            final T z = CallChecker.varInit(in[2], "z", 803, 37889, 37906);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 805, 37917, 37983);
            out[0] = q0.multiply(x.multiply(q0).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x);
            CallChecker.varAssign(out[0], "out[0]", 807, 37994, 38124);
            out[1] = q0.multiply(y.multiply(q0).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y);
            CallChecker.varAssign(out[1], "out[1]", 808, 38134, 38264);
            out[2] = q0.multiply(z.multiply(q0).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z);
            CallChecker.varAssign(out[2], "out[2]", 809, 38274, 38404);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public void applyTo(final double[] in, final T[] out) {
        MethodContext _bcornu_methode_context85 = new MethodContext(void.class, 817, 38418, 39275);
        try {
            CallChecker.varInit(this, "this", 817, 38418, 39275);
            CallChecker.varInit(out, "out", 817, 38418, 39275);
            CallChecker.varInit(in, "in", 817, 38418, 39275);
            CallChecker.varInit(this.q3, "q3", 817, 38418, 39275);
            CallChecker.varInit(this.q2, "q2", 817, 38418, 39275);
            CallChecker.varInit(this.q1, "q1", 817, 38418, 39275);
            CallChecker.varInit(this.q0, "q0", 817, 38418, 39275);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 817, 38418, 39275);
            final double x = CallChecker.varInit(((double) (in[0])), "x", 819, 38684, 38706);
            final double y = CallChecker.varInit(((double) (in[1])), "y", 820, 38716, 38738);
            final double z = CallChecker.varInit(((double) (in[2])), "z", 821, 38748, 38770);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 823, 38781, 38847);
            out[0] = q0.multiply(q0.multiply(x).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x);
            CallChecker.varAssign(out[0], "out[0]", 825, 38858, 38988);
            out[1] = q0.multiply(q0.multiply(y).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y);
            CallChecker.varAssign(out[1], "out[1]", 826, 38998, 39128);
            out[2] = q0.multiply(q0.multiply(z).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z);
            CallChecker.varAssign(out[2], "out[2]", 827, 39138, 39268);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyTo(final Rotation r, final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context86 = new MethodContext(FieldVector3D.class, 837, 39282, 40422);
        try {
            CallChecker.varInit(u, "u", 837, 39282, 40422);
            CallChecker.varInit(r, "r", 837, 39282, 40422);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 837, 39282, 40422);
            final T x = CallChecker.varInit(u.getX(), "x", 839, 39653, 39673);
            final T y = CallChecker.varInit(u.getY(), "y", 840, 39683, 39703);
            final T z = CallChecker.varInit(u.getZ(), "z", 841, 39713, 39733);
            final T s = CallChecker.varInit(x.multiply(r.getQ1()).add(y.multiply(r.getQ2())).add(z.multiply(r.getQ3())), "s", 843, 39744, 39831);
            return new FieldVector3D<T>(x.multiply(r.getQ0()).subtract(z.multiply(r.getQ2()).subtract(y.multiply(r.getQ3()))).multiply(r.getQ0()).add(s.multiply(r.getQ1())).multiply(2).subtract(x), y.multiply(r.getQ0()).subtract(x.multiply(r.getQ3()).subtract(z.multiply(r.getQ1()))).multiply(r.getQ0()).add(s.multiply(r.getQ2())).multiply(2).subtract(y), z.multiply(r.getQ0()).subtract(y.multiply(r.getQ1()).subtract(x.multiply(r.getQ2()))).multiply(r.getQ0()).add(s.multiply(r.getQ3())).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    public FieldVector3D<T> applyInverseTo(final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context87 = new MethodContext(FieldVector3D.class, 855, 40429, 41384);
        try {
            CallChecker.varInit(this, "this", 855, 40429, 41384);
            CallChecker.varInit(u, "u", 855, 40429, 41384);
            CallChecker.varInit(this.q3, "q3", 855, 40429, 41384);
            CallChecker.varInit(this.q2, "q2", 855, 40429, 41384);
            CallChecker.varInit(this.q1, "q1", 855, 40429, 41384);
            CallChecker.varInit(this.q0, "q0", 855, 40429, 41384);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 855, 40429, 41384);
            final T x = CallChecker.varInit(u.getX(), "x", 857, 40706, 40726);
            final T y = CallChecker.varInit(u.getY(), "y", 858, 40736, 40756);
            final T z = CallChecker.varInit(u.getZ(), "z", 859, 40766, 40786);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 861, 40797, 40864);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 862, 40874, 40898);
            return new FieldVector3D<T>(m0.multiply(x.multiply(m0).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x), m0.multiply(y.multiply(m0).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y), m0.multiply(z.multiply(m0).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public FieldVector3D<T> applyInverseTo(final Vector3D u) {
        MethodContext _bcornu_methode_context88 = new MethodContext(FieldVector3D.class, 874, 41391, 42353);
        try {
            CallChecker.varInit(this, "this", 874, 41391, 42353);
            CallChecker.varInit(u, "u", 874, 41391, 42353);
            CallChecker.varInit(this.q3, "q3", 874, 41391, 42353);
            CallChecker.varInit(this.q2, "q2", 874, 41391, 42353);
            CallChecker.varInit(this.q1, "q1", 874, 41391, 42353);
            CallChecker.varInit(this.q0, "q0", 874, 41391, 42353);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 874, 41391, 42353);
            final double x = CallChecker.varInit(((double) (u.getX())), "x", 876, 41660, 41685);
            final double y = CallChecker.varInit(((double) (u.getY())), "y", 877, 41695, 41720);
            final double z = CallChecker.varInit(((double) (u.getZ())), "z", 878, 41730, 41755);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 880, 41766, 41833);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 881, 41843, 41867);
            return new FieldVector3D<T>(m0.multiply(m0.multiply(x).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x), m0.multiply(m0.multiply(y).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y), m0.multiply(m0.multiply(z).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public void applyInverseTo(final T[] in, final T[] out) {
        MethodContext _bcornu_methode_context89 = new MethodContext(void.class, 894, 42360, 43293);
        try {
            CallChecker.varInit(this, "this", 894, 42360, 43293);
            CallChecker.varInit(out, "out", 894, 42360, 43293);
            CallChecker.varInit(in, "in", 894, 42360, 43293);
            CallChecker.varInit(this.q3, "q3", 894, 42360, 43293);
            CallChecker.varInit(this.q2, "q2", 894, 42360, 43293);
            CallChecker.varInit(this.q1, "q1", 894, 42360, 43293);
            CallChecker.varInit(this.q0, "q0", 894, 42360, 43293);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 894, 42360, 43293);
            final T x = CallChecker.varInit(in[0], "x", 896, 42683, 42700);
            final T y = CallChecker.varInit(in[1], "y", 897, 42710, 42727);
            final T z = CallChecker.varInit(in[2], "z", 898, 42737, 42754);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 900, 42765, 42831);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 901, 42841, 42865);
            out[0] = m0.multiply(x.multiply(m0).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x);
            CallChecker.varAssign(out[0], "out[0]", 903, 42876, 43006);
            out[1] = m0.multiply(y.multiply(m0).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y);
            CallChecker.varAssign(out[1], "out[1]", 904, 43016, 43146);
            out[2] = m0.multiply(z.multiply(m0).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z);
            CallChecker.varAssign(out[2], "out[2]", 905, 43156, 43286);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public void applyInverseTo(final double[] in, final T[] out) {
        MethodContext _bcornu_methode_context90 = new MethodContext(void.class, 913, 43300, 44213);
        try {
            CallChecker.varInit(this, "this", 913, 43300, 44213);
            CallChecker.varInit(out, "out", 913, 43300, 44213);
            CallChecker.varInit(in, "in", 913, 43300, 44213);
            CallChecker.varInit(this.q3, "q3", 913, 43300, 44213);
            CallChecker.varInit(this.q2, "q2", 913, 43300, 44213);
            CallChecker.varInit(this.q1, "q1", 913, 43300, 44213);
            CallChecker.varInit(this.q0, "q0", 913, 43300, 44213);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 913, 43300, 44213);
            final double x = CallChecker.varInit(((double) (in[0])), "x", 915, 43588, 43610);
            final double y = CallChecker.varInit(((double) (in[1])), "y", 916, 43620, 43642);
            final double z = CallChecker.varInit(((double) (in[2])), "z", 917, 43652, 43674);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 919, 43685, 43751);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 920, 43761, 43785);
            out[0] = m0.multiply(m0.multiply(x).subtract(q2.multiply(z).subtract(q3.multiply(y)))).add(s.multiply(q1)).multiply(2).subtract(x);
            CallChecker.varAssign(out[0], "out[0]", 922, 43796, 43926);
            out[1] = m0.multiply(m0.multiply(y).subtract(q3.multiply(x).subtract(q1.multiply(z)))).add(s.multiply(q2)).multiply(2).subtract(y);
            CallChecker.varAssign(out[1], "out[1]", 923, 43936, 44066);
            out[2] = m0.multiply(m0.multiply(z).subtract(q1.multiply(y).subtract(q2.multiply(x)))).add(s.multiply(q3)).multiply(2).subtract(z);
            CallChecker.varAssign(out[2], "out[2]", 924, 44076, 44206);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyInverseTo(final Rotation r, final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context91 = new MethodContext(FieldVector3D.class, 934, 44220, 45401);
        try {
            CallChecker.varInit(u, "u", 934, 44220, 45401);
            CallChecker.varInit(r, "r", 934, 44220, 45401);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 934, 44220, 45401);
            final T x = CallChecker.varInit(u.getX(), "x", 936, 44635, 44655);
            final T y = CallChecker.varInit(u.getY(), "y", 937, 44665, 44685);
            final T z = CallChecker.varInit(u.getZ(), "z", 938, 44695, 44715);
            final T s = CallChecker.varInit(x.multiply(r.getQ1()).add(y.multiply(r.getQ2())).add(z.multiply(r.getQ3())), "s", 940, 44726, 44814);
            final double m0 = CallChecker.varInit(((double) (-(r.getQ0()))), "m0", 941, 44824, 44852);
            return new FieldVector3D<T>(x.multiply(m0).subtract(z.multiply(r.getQ2()).subtract(y.multiply(r.getQ3()))).multiply(m0).add(s.multiply(r.getQ1())).multiply(2).subtract(x), y.multiply(m0).subtract(x.multiply(r.getQ3()).subtract(z.multiply(r.getQ1()))).multiply(m0).add(s.multiply(r.getQ2())).multiply(2).subtract(y), z.multiply(m0).subtract(y.multiply(r.getQ1()).subtract(x.multiply(r.getQ2()))).multiply(m0).add(s.multiply(r.getQ3())).multiply(2).subtract(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public FieldRotation<T> applyTo(final FieldRotation<T> r) {
        MethodContext _bcornu_methode_context92 = new MethodContext(FieldRotation.class, 958, 45408, 46542);
        try {
            CallChecker.varInit(this, "this", 958, 45408, 46542);
            CallChecker.varInit(r, "r", 958, 45408, 46542);
            CallChecker.varInit(this.q3, "q3", 958, 45408, 46542);
            CallChecker.varInit(this.q2, "q2", 958, 45408, 46542);
            CallChecker.varInit(this.q1, "q1", 958, 45408, 46542);
            CallChecker.varInit(this.q0, "q0", 958, 45408, 46542);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 958, 45408, 46542);
            return new FieldRotation<T>(r.q0.multiply(q0).subtract(r.q1.multiply(q1).add(r.q2.multiply(q2)).add(r.q3.multiply(q3))), r.q1.multiply(q0).add(r.q0.multiply(q1)).add(r.q2.multiply(q3).subtract(r.q3.multiply(q2))), r.q2.multiply(q0).add(r.q0.multiply(q2)).add(r.q3.multiply(q1).subtract(r.q1.multiply(q3))), r.q3.multiply(q0).add(r.q0.multiply(q3)).add(r.q1.multiply(q2).subtract(r.q2.multiply(q1))), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public FieldRotation<T> applyTo(final Rotation r) {
        MethodContext _bcornu_methode_context93 = new MethodContext(FieldRotation.class, 975, 46549, 47755);
        try {
            CallChecker.varInit(this, "this", 975, 46549, 47755);
            CallChecker.varInit(r, "r", 975, 46549, 47755);
            CallChecker.varInit(this.q3, "q3", 975, 46549, 47755);
            CallChecker.varInit(this.q2, "q2", 975, 46549, 47755);
            CallChecker.varInit(this.q1, "q1", 975, 46549, 47755);
            CallChecker.varInit(this.q0, "q0", 975, 46549, 47755);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 975, 46549, 47755);
            return new FieldRotation<T>(q0.multiply(r.getQ0()).subtract(q1.multiply(r.getQ1()).add(q2.multiply(r.getQ2())).add(q3.multiply(r.getQ3()))), q0.multiply(r.getQ1()).add(q1.multiply(r.getQ0())).add(q3.multiply(r.getQ2()).subtract(q2.multiply(r.getQ3()))), q0.multiply(r.getQ2()).add(q2.multiply(r.getQ0())).add(q1.multiply(r.getQ3()).subtract(q3.multiply(r.getQ1()))), q0.multiply(r.getQ3()).add(q3.multiply(r.getQ0())).add(q2.multiply(r.getQ1()).subtract(q1.multiply(r.getQ2()))), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyTo(final Rotation r1, final FieldRotation<T> rInner) {
        MethodContext _bcornu_methode_context94 = new MethodContext(FieldRotation.class, 994, 47762, 49282);
        try {
            CallChecker.varInit(rInner, "rInner", 994, 47762, 49282);
            CallChecker.varInit(r1, "r1", 994, 47762, 49282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 994, 47762, 49282);
            return new FieldRotation<T>(rInner.q0.multiply(r1.getQ0()).subtract(rInner.q1.multiply(r1.getQ1()).add(rInner.q2.multiply(r1.getQ2())).add(rInner.q3.multiply(r1.getQ3()))), rInner.q1.multiply(r1.getQ0()).add(rInner.q0.multiply(r1.getQ1())).add(rInner.q2.multiply(r1.getQ3()).subtract(rInner.q3.multiply(r1.getQ2()))), rInner.q2.multiply(r1.getQ0()).add(rInner.q0.multiply(r1.getQ2())).add(rInner.q3.multiply(r1.getQ1()).subtract(rInner.q1.multiply(r1.getQ3()))), rInner.q3.multiply(r1.getQ0()).add(rInner.q0.multiply(r1.getQ3())).add(rInner.q1.multiply(r1.getQ2()).subtract(rInner.q2.multiply(r1.getQ1()))), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public FieldRotation<T> applyInverseTo(final FieldRotation<T> r) {
        MethodContext _bcornu_methode_context95 = new MethodContext(FieldRotation.class, 1013, 49289, 50530);
        try {
            CallChecker.varInit(this, "this", 1013, 49289, 50530);
            CallChecker.varInit(r, "r", 1013, 49289, 50530);
            CallChecker.varInit(this.q3, "q3", 1013, 49289, 50530);
            CallChecker.varInit(this.q2, "q2", 1013, 49289, 50530);
            CallChecker.varInit(this.q1, "q1", 1013, 49289, 50530);
            CallChecker.varInit(this.q0, "q0", 1013, 49289, 50530);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1013, 49289, 50530);
            return new FieldRotation<T>(r.q0.multiply(q0).add(r.q1.multiply(q1).add(r.q2.multiply(q2)).add(r.q3.multiply(q3))).negate(), r.q0.multiply(q1).add(r.q2.multiply(q3).subtract(r.q3.multiply(q2))).subtract(r.q1.multiply(q0)), r.q0.multiply(q2).add(r.q3.multiply(q1).subtract(r.q1.multiply(q3))).subtract(r.q2.multiply(q0)), r.q0.multiply(q3).add(r.q1.multiply(q2).subtract(r.q2.multiply(q1))).subtract(r.q3.multiply(q0)), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    public FieldRotation<T> applyInverseTo(final Rotation r) {
        MethodContext _bcornu_methode_context96 = new MethodContext(FieldRotation.class, 1032, 50537, 51850);
        try {
            CallChecker.varInit(this, "this", 1032, 50537, 51850);
            CallChecker.varInit(r, "r", 1032, 50537, 51850);
            CallChecker.varInit(this.q3, "q3", 1032, 50537, 51850);
            CallChecker.varInit(this.q2, "q2", 1032, 50537, 51850);
            CallChecker.varInit(this.q1, "q1", 1032, 50537, 51850);
            CallChecker.varInit(this.q0, "q0", 1032, 50537, 51850);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1032, 50537, 51850);
            return new FieldRotation<T>(q0.multiply(r.getQ0()).add(q1.multiply(r.getQ1()).add(q2.multiply(r.getQ2())).add(q3.multiply(r.getQ3()))).negate(), q1.multiply(r.getQ0()).add(q3.multiply(r.getQ2()).subtract(q2.multiply(r.getQ3()))).subtract(q0.multiply(r.getQ1())), q2.multiply(r.getQ0()).add(q1.multiply(r.getQ3()).subtract(q3.multiply(r.getQ1()))).subtract(q0.multiply(r.getQ2())), q3.multiply(r.getQ0()).add(q2.multiply(r.getQ1()).subtract(q1.multiply(r.getQ2()))).subtract(q0.multiply(r.getQ3())), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyInverseTo(final Rotation rOuter, final FieldRotation<T> rInner) {
        MethodContext _bcornu_methode_context97 = new MethodContext(FieldRotation.class, 1053, 51857, 53572);
        try {
            CallChecker.varInit(rInner, "rInner", 1053, 51857, 53572);
            CallChecker.varInit(rOuter, "rOuter", 1053, 51857, 53572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1053, 51857, 53572);
            return new FieldRotation<T>(rInner.q0.multiply(rOuter.getQ0()).add(rInner.q1.multiply(rOuter.getQ1()).add(rInner.q2.multiply(rOuter.getQ2())).add(rInner.q3.multiply(rOuter.getQ3()))).negate(), rInner.q0.multiply(rOuter.getQ1()).add(rInner.q2.multiply(rOuter.getQ3()).subtract(rInner.q3.multiply(rOuter.getQ2()))).subtract(rInner.q1.multiply(rOuter.getQ0())), rInner.q0.multiply(rOuter.getQ2()).add(rInner.q3.multiply(rOuter.getQ1()).subtract(rInner.q1.multiply(rOuter.getQ3()))).subtract(rInner.q2.multiply(rOuter.getQ0())), rInner.q0.multiply(rOuter.getQ3()).add(rInner.q1.multiply(rOuter.getQ2()).subtract(rInner.q2.multiply(rOuter.getQ1()))).subtract(rInner.q3.multiply(rOuter.getQ0())), false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldRotation<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldRotation.class)));
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    private T[][] orthogonalizeMatrix(final T[][] m, final double threshold) throws NotARotationMatrixException {
        MethodContext _bcornu_methode_context98 = new MethodContext(null, 1071, 53579, 58514);
        try {
            CallChecker.varInit(this, "this", 1071, 53579, 58514);
            CallChecker.varInit(threshold, "threshold", 1071, 53579, 58514);
            CallChecker.varInit(m, "m", 1071, 53579, 58514);
            CallChecker.varInit(this.q3, "q3", 1071, 53579, 58514);
            CallChecker.varInit(this.q2, "q2", 1071, 53579, 58514);
            CallChecker.varInit(this.q1, "q1", 1071, 53579, 58514);
            CallChecker.varInit(this.q0, "q0", 1071, 53579, 58514);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1071, 53579, 58514);
            T x00 = CallChecker.varInit(m[0][0], "x00", 1074, 54238, 54253);
            T x01 = CallChecker.varInit(m[0][1], "x01", 1075, 54263, 54278);
            T x02 = CallChecker.varInit(m[0][2], "x02", 1076, 54288, 54303);
            T x10 = CallChecker.varInit(m[1][0], "x10", 1077, 54313, 54328);
            T x11 = CallChecker.varInit(m[1][1], "x11", 1078, 54338, 54353);
            T x12 = CallChecker.varInit(m[1][2], "x12", 1079, 54363, 54378);
            T x20 = CallChecker.varInit(m[2][0], "x20", 1080, 54388, 54403);
            T x21 = CallChecker.varInit(m[2][1], "x21", 1081, 54413, 54428);
            T x22 = CallChecker.varInit(m[2][2], "x22", 1082, 54438, 54453);
            double fn = CallChecker.varInit(((double) (0)), "fn", 1083, 54463, 54476);
            double fn1 = CallChecker.init(double.class);
            final T[][] o = CallChecker.varInit(MathArrays.buildArray(m[0][0].getField(), 3, 3), "o", 1086, 54507, 54570);
            int i = CallChecker.varInit(((int) (0)), "i", 1089, 54647, 54656);
            while ((++i) < 11) {
                final T mx00 = CallChecker.varInit(m[0][0].multiply(x00).add(m[1][0].multiply(x10)).add(m[2][0].multiply(x20)), "mx00", 1093, 54698, 54809);
                final T mx10 = CallChecker.varInit(m[0][1].multiply(x00).add(m[1][1].multiply(x10)).add(m[2][1].multiply(x20)), "mx10", 1094, 54823, 54913);
                final T mx20 = CallChecker.varInit(m[0][2].multiply(x00).add(m[1][2].multiply(x10)).add(m[2][2].multiply(x20)), "mx20", 1095, 54927, 55017);
                final T mx01 = CallChecker.varInit(m[0][0].multiply(x01).add(m[1][0].multiply(x11)).add(m[2][0].multiply(x21)), "mx01", 1096, 55031, 55121);
                final T mx11 = CallChecker.varInit(m[0][1].multiply(x01).add(m[1][1].multiply(x11)).add(m[2][1].multiply(x21)), "mx11", 1097, 55135, 55225);
                final T mx21 = CallChecker.varInit(m[0][2].multiply(x01).add(m[1][2].multiply(x11)).add(m[2][2].multiply(x21)), "mx21", 1098, 55239, 55329);
                final T mx02 = CallChecker.varInit(m[0][0].multiply(x02).add(m[1][0].multiply(x12)).add(m[2][0].multiply(x22)), "mx02", 1099, 55343, 55433);
                final T mx12 = CallChecker.varInit(m[0][1].multiply(x02).add(m[1][1].multiply(x12)).add(m[2][1].multiply(x22)), "mx12", 1100, 55447, 55537);
                final T mx22 = CallChecker.varInit(m[0][2].multiply(x02).add(m[1][2].multiply(x12)).add(m[2][2].multiply(x22)), "mx22", 1101, 55551, 55641);
                o[0][0] = x00.subtract(x00.multiply(mx00).add(x01.multiply(mx10)).add(x02.multiply(mx20)).subtract(m[0][0]).multiply(0.5));
                CallChecker.varAssign(o[0][0], "o[0][0]", 1104, 55676, 55798);
                o[0][1] = x01.subtract(x00.multiply(mx01).add(x01.multiply(mx11)).add(x02.multiply(mx21)).subtract(m[0][1]).multiply(0.5));
                CallChecker.varAssign(o[0][1], "o[0][1]", 1105, 55812, 55934);
                o[0][2] = x02.subtract(x00.multiply(mx02).add(x01.multiply(mx12)).add(x02.multiply(mx22)).subtract(m[0][2]).multiply(0.5));
                CallChecker.varAssign(o[0][2], "o[0][2]", 1106, 55948, 56070);
                o[1][0] = x10.subtract(x10.multiply(mx00).add(x11.multiply(mx10)).add(x12.multiply(mx20)).subtract(m[1][0]).multiply(0.5));
                CallChecker.varAssign(o[1][0], "o[1][0]", 1107, 56084, 56206);
                o[1][1] = x11.subtract(x10.multiply(mx01).add(x11.multiply(mx11)).add(x12.multiply(mx21)).subtract(m[1][1]).multiply(0.5));
                CallChecker.varAssign(o[1][1], "o[1][1]", 1108, 56220, 56342);
                o[1][2] = x12.subtract(x10.multiply(mx02).add(x11.multiply(mx12)).add(x12.multiply(mx22)).subtract(m[1][2]).multiply(0.5));
                CallChecker.varAssign(o[1][2], "o[1][2]", 1109, 56356, 56478);
                o[2][0] = x20.subtract(x20.multiply(mx00).add(x21.multiply(mx10)).add(x22.multiply(mx20)).subtract(m[2][0]).multiply(0.5));
                CallChecker.varAssign(o[2][0], "o[2][0]", 1110, 56492, 56614);
                o[2][1] = x21.subtract(x20.multiply(mx01).add(x21.multiply(mx11)).add(x22.multiply(mx21)).subtract(m[2][1]).multiply(0.5));
                CallChecker.varAssign(o[2][1], "o[2][1]", 1111, 56628, 56750);
                o[2][2] = x22.subtract(x20.multiply(mx02).add(x21.multiply(mx12)).add(x22.multiply(mx22)).subtract(m[2][2]).multiply(0.5));
                CallChecker.varAssign(o[2][2], "o[2][2]", 1112, 56764, 56886);
                final double corr00 = CallChecker.varInit(((double) ((o[0][0].getReal()) - (m[0][0].getReal()))), "corr00", 1115, 56901, 57003);
                final double corr01 = CallChecker.varInit(((double) ((o[0][1].getReal()) - (m[0][1].getReal()))), "corr01", 1116, 57017, 57076);
                final double corr02 = CallChecker.varInit(((double) ((o[0][2].getReal()) - (m[0][2].getReal()))), "corr02", 1117, 57090, 57149);
                final double corr10 = CallChecker.varInit(((double) ((o[1][0].getReal()) - (m[1][0].getReal()))), "corr10", 1118, 57163, 57222);
                final double corr11 = CallChecker.varInit(((double) ((o[1][1].getReal()) - (m[1][1].getReal()))), "corr11", 1119, 57236, 57295);
                final double corr12 = CallChecker.varInit(((double) ((o[1][2].getReal()) - (m[1][2].getReal()))), "corr12", 1120, 57309, 57368);
                final double corr20 = CallChecker.varInit(((double) ((o[2][0].getReal()) - (m[2][0].getReal()))), "corr20", 1121, 57382, 57441);
                final double corr21 = CallChecker.varInit(((double) ((o[2][1].getReal()) - (m[2][1].getReal()))), "corr21", 1122, 57455, 57514);
                final double corr22 = CallChecker.varInit(((double) ((o[2][2].getReal()) - (m[2][2].getReal()))), "corr22", 1123, 57528, 57587);
                fn1 = ((((((((corr00 * corr00) + (corr01 * corr01)) + (corr02 * corr02)) + (corr10 * corr10)) + (corr11 * corr11)) + (corr12 * corr12)) + (corr20 * corr20)) + (corr21 * corr21)) + (corr22 * corr22);
                CallChecker.varAssign(fn1, "fn1", 1126, 57650, 57851);
                if ((FastMath.abs((fn1 - fn))) <= threshold) {
                    return o;
                }
                x00 = o[0][0];
                CallChecker.varAssign(x00, "x00", 1136, 58032, 58045);
                x01 = o[0][1];
                CallChecker.varAssign(x01, "x01", 1137, 58059, 58072);
                x02 = o[0][2];
                CallChecker.varAssign(x02, "x02", 1138, 58086, 58099);
                x10 = o[1][0];
                CallChecker.varAssign(x10, "x10", 1139, 58113, 58126);
                x11 = o[1][1];
                CallChecker.varAssign(x11, "x11", 1140, 58140, 58153);
                x12 = o[1][2];
                CallChecker.varAssign(x12, "x12", 1141, 58167, 58180);
                x20 = o[2][0];
                CallChecker.varAssign(x20, "x20", 1142, 58194, 58207);
                x21 = o[2][1];
                CallChecker.varAssign(x21, "x21", 1143, 58221, 58234);
                x22 = o[2][2];
                CallChecker.varAssign(x22, "x22", 1144, 58248, 58261);
                fn = fn1;
                CallChecker.varAssign(fn, "fn", 1145, 58275, 58284);
            } 
            throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, (i - 1));
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[][]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldRotation<T> r1, final FieldRotation<T> r2) {
        MethodContext _bcornu_methode_context99 = new MethodContext(null, 1180, 58521, 60132);
        try {
            CallChecker.varInit(r2, "r2", 1180, 58521, 60132);
            CallChecker.varInit(r1, "r1", 1180, 58521, 60132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1180, 58521, 60132);
            return r1.applyInverseTo(r2).getAngle();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }
}

