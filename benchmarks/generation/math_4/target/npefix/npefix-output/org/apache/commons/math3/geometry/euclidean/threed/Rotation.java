package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
        ConstructorContext _bcornu_methode_context65 = new ConstructorContext(Rotation.class, 135, 5956, 7446);
        try {
            if (needsNormalization) {
                double inv = CallChecker.varInit(((double) (1.0 / (FastMath.sqrt(((((q0 * q0) + (q1 * q1)) + (q2 * q2)) + (q3 * q3)))))), "inv", 140, 7223, 7294);
                q0 *= inv;
                CallChecker.varAssign(q0, "q0", 141, 7302, 7311);
                q1 *= inv;
                CallChecker.varAssign(q1, "q1", 142, 7319, 7328);
                q2 *= inv;
                CallChecker.varAssign(q2, "q2", 143, 7336, 7345);
                q3 *= inv;
                CallChecker.varAssign(q3, "q3", 144, 7353, 7362);
            }
            this.q0 = q0;
            CallChecker.varAssign(this.q0, "this.q0", 147, 7375, 7387);
            this.q1 = q1;
            CallChecker.varAssign(this.q1, "this.q1", 148, 7393, 7405);
            this.q2 = q2;
            CallChecker.varAssign(this.q2, "this.q2", 149, 7411, 7423);
            this.q3 = q3;
            CallChecker.varAssign(this.q3, "this.q3", 150, 7429, 7441);
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public Rotation(Vector3D axis, double angle) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context66 = new ConstructorContext(Rotation.class, 175, 7451, 9154);
        try {
            double norm = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(axis, Vector3D.class, 177, 8801, 8804)) {
                axis = CallChecker.beforeCalled(axis, Vector3D.class, 177, 8801, 8804);
                norm = CallChecker.isCalled(axis, Vector3D.class, 177, 8801, 8804).getNorm();
                CallChecker.varAssign(norm, "norm", 177, 8801, 8804);
            }
            if (norm == 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS);
            }
            double halfAngle = CallChecker.varInit(((double) ((-0.5) * angle)), "halfAngle", 182, 8941, 8972);
            double coeff = CallChecker.varInit(((double) ((FastMath.sin(halfAngle)) / norm)), "coeff", 183, 8978, 9023);
            q0 = FastMath.cos(halfAngle);
            CallChecker.varAssign(this.q0, "this.q0", 185, 9030, 9059);
            axis = CallChecker.beforeCalled(axis, Vector3D.class, 186, 9078, 9081);
            q1 = coeff * (CallChecker.isCalled(axis, Vector3D.class, 186, 9078, 9081).getX());
            CallChecker.varAssign(this.q1, "this.q1", 186, 9065, 9089);
            axis = CallChecker.beforeCalled(axis, Vector3D.class, 187, 9108, 9111);
            q2 = coeff * (CallChecker.isCalled(axis, Vector3D.class, 187, 9108, 9111).getY());
            CallChecker.varAssign(this.q2, "this.q2", 187, 9095, 9119);
            axis = CallChecker.beforeCalled(axis, Vector3D.class, 188, 9138, 9141);
            q3 = coeff * (CallChecker.isCalled(axis, Vector3D.class, 188, 9138, 9141).getZ());
            CallChecker.varAssign(this.q3, "this.q3", 188, 9125, 9149);
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public Rotation(double[][] m, double threshold) throws NotARotationMatrixException {
        ConstructorContext _bcornu_methode_context67 = new ConstructorContext(Rotation.class, 222, 9159, 11675);
        try {
            if (CallChecker.beforeDeref(m, double[][].class, 226, 10771, 10771)) {
                if (CallChecker.beforeDeref(m, double[][].class, 226, 10790, 10790)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 226, 10790, 10790);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 226, 10790, 10790)[0], double[].class, 226, 10790, 10793)) {
                        if (CallChecker.beforeDeref(m, double[][].class, 227, 10820, 10820)) {
                            m = CallChecker.beforeCalled(m, double[][].class, 227, 10820, 10820);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 227, 10820, 10820)[1], double[].class, 227, 10820, 10823)) {
                                if (CallChecker.beforeDeref(m, double[][].class, 227, 10842, 10842)) {
                                    m = CallChecker.beforeCalled(m, double[][].class, 227, 10842, 10842);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 227, 10842, 10842)[2], double[].class, 227, 10842, 10845)) {
                                        m = CallChecker.beforeCalled(m, double[][].class, 226, 10771, 10771);
                                        m = CallChecker.beforeCalled(m, double[][].class, 226, 10790, 10790);
                                        CallChecker.isCalled(m, double[][].class, 226, 10790, 10790)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 226, 10790, 10790)[0], double[].class, 226, 10790, 10793);
                                        m = CallChecker.beforeCalled(m, double[][].class, 227, 10820, 10820);
                                        CallChecker.isCalled(m, double[][].class, 227, 10820, 10820)[1] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 227, 10820, 10820)[1], double[].class, 227, 10820, 10823);
                                        m = CallChecker.beforeCalled(m, double[][].class, 227, 10842, 10842);
                                        CallChecker.isCalled(m, double[][].class, 227, 10842, 10842)[2] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 227, 10842, 10842)[2], double[].class, 227, 10842, 10845);
                                        if (((((CallChecker.isCalled(m, double[][].class, 226, 10771, 10771).length) != 3) || ((CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 226, 10790, 10790)[0], double[].class, 226, 10790, 10793).length) != 3)) || ((CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 227, 10820, 10820)[1], double[].class, 227, 10820, 10823).length) != 3)) || ((CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 227, 10842, 10842)[2], double[].class, 227, 10842, 10845).length) != 3)) {
                                            if (CallChecker.beforeDeref(m, double[][].class, 230, 10981, 10981)) {
                                                if (CallChecker.beforeDeref(m, double[][].class, 230, 10991, 10991)) {
                                                    m = CallChecker.beforeCalled(m, double[][].class, 230, 10991, 10991);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 230, 10991, 10991)[0], double[].class, 230, 10991, 10994)) {
                                                        m = CallChecker.beforeCalled(m, double[][].class, 230, 10981, 10981);
                                                        m = CallChecker.beforeCalled(m, double[][].class, 230, 10991, 10991);
                                                        CallChecker.isCalled(m, double[][].class, 230, 10991, 10991)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 230, 10991, 10991)[0], double[].class, 230, 10991, 10994);
                                                        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, CallChecker.isCalled(m, double[][].class, 230, 10981, 10981).length, CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 230, 10991, 10991)[0], double[].class, 230, 10991, 10994).length);
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
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
                
            }else
                throw new AbnormalExecutionError();
            
            double[][] ort = CallChecker.varInit(orthogonalizeMatrix(m, threshold), "ort", 234, 11059, 11109);
            double det = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(ort, double[][].class, 237, 11170, 11172)) {
                ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11170, 11172);
                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 237, 11170, 11172)[0], double[].class, 237, 11170, 11175)) {
                    if (CallChecker.beforeDeref(ort, double[][].class, 237, 11183, 11185)) {
                        ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11183, 11185);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 237, 11183, 11185)[1], double[].class, 237, 11183, 11188)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 237, 11195, 11197)) {
                                ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11195, 11197);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 237, 11195, 11197)[2], double[].class, 237, 11195, 11200)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 237, 11207, 11209)) {
                                        ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11207, 11209);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 237, 11207, 11209)[2], double[].class, 237, 11207, 11212)) {
                                            if (CallChecker.beforeDeref(ort, double[][].class, 237, 11219, 11221)) {
                                                ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11219, 11221);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 237, 11219, 11221)[1], double[].class, 237, 11219, 11224)) {
                                                    if (CallChecker.beforeDeref(ort, double[][].class, 238, 11249, 11251)) {
                                                        ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11249, 11251);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 238, 11249, 11251)[1], double[].class, 238, 11249, 11254)) {
                                                            if (CallChecker.beforeDeref(ort, double[][].class, 238, 11262, 11264)) {
                                                                ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11262, 11264);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 238, 11262, 11264)[0], double[].class, 238, 11262, 11267)) {
                                                                    if (CallChecker.beforeDeref(ort, double[][].class, 238, 11274, 11276)) {
                                                                        ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11274, 11276);
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 238, 11274, 11276)[2], double[].class, 238, 11274, 11279)) {
                                                                            if (CallChecker.beforeDeref(ort, double[][].class, 238, 11286, 11288)) {
                                                                                ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11286, 11288);
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 238, 11286, 11288)[2], double[].class, 238, 11286, 11291)) {
                                                                                    if (CallChecker.beforeDeref(ort, double[][].class, 238, 11298, 11300)) {
                                                                                        ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11298, 11300);
                                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 238, 11298, 11300)[0], double[].class, 238, 11298, 11303)) {
                                                                                            if (CallChecker.beforeDeref(ort, double[][].class, 239, 11328, 11330)) {
                                                                                                ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11328, 11330);
                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 239, 11328, 11330)[2], double[].class, 239, 11328, 11333)) {
                                                                                                    if (CallChecker.beforeDeref(ort, double[][].class, 239, 11341, 11343)) {
                                                                                                        ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11341, 11343);
                                                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 239, 11341, 11343)[0], double[].class, 239, 11341, 11346)) {
                                                                                                            if (CallChecker.beforeDeref(ort, double[][].class, 239, 11353, 11355)) {
                                                                                                                ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11353, 11355);
                                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 239, 11353, 11355)[1], double[].class, 239, 11353, 11358)) {
                                                                                                                    if (CallChecker.beforeDeref(ort, double[][].class, 239, 11365, 11367)) {
                                                                                                                        ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11365, 11367);
                                                                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 239, 11365, 11367)[1], double[].class, 239, 11365, 11370)) {
                                                                                                                            if (CallChecker.beforeDeref(ort, double[][].class, 239, 11377, 11379)) {
                                                                                                                                ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11377, 11379);
                                                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 239, 11377, 11379)[0], double[].class, 239, 11377, 11382)) {
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11170, 11172);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 237, 11170, 11172)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 237, 11170, 11172)[0], double[].class, 237, 11170, 11175);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11183, 11185);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 237, 11183, 11185)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 237, 11183, 11185)[1], double[].class, 237, 11183, 11188);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11195, 11197);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 237, 11195, 11197)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 237, 11195, 11197)[2], double[].class, 237, 11195, 11200);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11207, 11209);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 237, 11207, 11209)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 237, 11207, 11209)[2], double[].class, 237, 11207, 11212);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 237, 11219, 11221);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 237, 11219, 11221)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 237, 11219, 11221)[1], double[].class, 237, 11219, 11224);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11249, 11251);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 238, 11249, 11251)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 238, 11249, 11251)[1], double[].class, 238, 11249, 11254);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11262, 11264);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 238, 11262, 11264)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 238, 11262, 11264)[0], double[].class, 238, 11262, 11267);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11274, 11276);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 238, 11274, 11276)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 238, 11274, 11276)[2], double[].class, 238, 11274, 11279);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11286, 11288);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 238, 11286, 11288)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 238, 11286, 11288)[2], double[].class, 238, 11286, 11291);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 238, 11298, 11300);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 238, 11298, 11300)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 238, 11298, 11300)[0], double[].class, 238, 11298, 11303);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11328, 11330);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 239, 11328, 11330)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 239, 11328, 11330)[2], double[].class, 239, 11328, 11333);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11341, 11343);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 239, 11341, 11343)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 239, 11341, 11343)[0], double[].class, 239, 11341, 11346);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11353, 11355);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 239, 11353, 11355)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 239, 11353, 11355)[1], double[].class, 239, 11353, 11358);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11365, 11367);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 239, 11365, 11367)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 239, 11365, 11367)[1], double[].class, 239, 11365, 11370);
                                                                                                                                    ort = CallChecker.beforeCalled(ort, double[][].class, 239, 11377, 11379);
                                                                                                                                    CallChecker.isCalled(ort, double[][].class, 239, 11377, 11379)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 239, 11377, 11379)[0], double[].class, 239, 11377, 11382);
                                                                                                                                    det = (((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 237, 11170, 11172)[0], double[].class, 237, 11170, 11175)[0]) * (((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 237, 11183, 11185)[1], double[].class, 237, 11183, 11188)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 237, 11195, 11197)[2], double[].class, 237, 11195, 11200)[2])) - ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 237, 11207, 11209)[2], double[].class, 237, 11207, 11212)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 237, 11219, 11221)[1], double[].class, 237, 11219, 11224)[2])))) - ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 238, 11249, 11251)[1], double[].class, 238, 11249, 11254)[0]) * (((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 238, 11262, 11264)[0], double[].class, 238, 11262, 11267)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 238, 11274, 11276)[2], double[].class, 238, 11274, 11279)[2])) - ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 238, 11286, 11288)[2], double[].class, 238, 11286, 11291)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 238, 11298, 11300)[0], double[].class, 238, 11298, 11303)[2]))))) + ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 239, 11328, 11330)[2], double[].class, 239, 11328, 11333)[0]) * (((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 239, 11341, 11343)[0], double[].class, 239, 11341, 11346)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 239, 11353, 11355)[1], double[].class, 239, 11353, 11358)[2])) - ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 239, 11365, 11367)[1], double[].class, 239, 11365, 11370)[1]) * (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 239, 11377, 11379)[0], double[].class, 239, 11377, 11382)[2]))));
                                                                                                                                    CallChecker.varAssign(det, "det", 237, 11170, 11172);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (det < 0.0) {
                throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, det);
            }
            double[] quat = CallChecker.varInit(Rotation.mat2quat(ort), "quat", 246, 11569, 11598);
            quat = CallChecker.beforeCalled(quat, double[].class, 247, 11609, 11612);
            q0 = CallChecker.isCalled(quat, double[].class, 247, 11609, 11612)[0];
            CallChecker.varAssign(this.q0, "this.q0", 247, 11604, 11616);
            quat = CallChecker.beforeCalled(quat, double[].class, 248, 11627, 11630);
            q1 = CallChecker.isCalled(quat, double[].class, 248, 11627, 11630)[1];
            CallChecker.varAssign(this.q1, "this.q1", 248, 11622, 11634);
            quat = CallChecker.beforeCalled(quat, double[].class, 249, 11645, 11648);
            q2 = CallChecker.isCalled(quat, double[].class, 249, 11645, 11648)[2];
            CallChecker.varAssign(this.q2, "this.q2", 249, 11640, 11652);
            quat = CallChecker.beforeCalled(quat, double[].class, 250, 11663, 11666);
            q3 = CallChecker.isCalled(quat, double[].class, 250, 11663, 11666)[3];
            CallChecker.varAssign(this.q3, "this.q3", 250, 11658, 11670);
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    public Rotation(Vector3D u1, Vector3D u2, Vector3D v1, Vector3D v2) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context68 = new ConstructorContext(Rotation.class, 273, 11680, 14608);
        try {
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 278, 12922, 12923);
            final Vector3D u3 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(u1, Vector3D.class, 278, 12922, 12923).crossProduct(u2), Vector3D.class, 278, 12922, 12940).normalize(), "u3", 278, 12759, 12953);
            if (CallChecker.beforeDeref(u3, Vector3D.class, 279, 12966, 12967)) {
                final Vector3D npe_invocation_var30 = CallChecker.isCalled(u3, Vector3D.class, 279, 12966, 12967).crossProduct(u1);
                if (CallChecker.beforeDeref(npe_invocation_var30, Vector3D.class, 279, 12966, 12984)) {
                    u2 = CallChecker.isCalled(npe_invocation_var30, Vector3D.class, 279, 12966, 12984).normalize();
                    CallChecker.varAssign(u2, "u2", 279, 12961, 12997);
                }
            }
            if (CallChecker.beforeDeref(u1, Vector3D.class, 280, 13010, 13011)) {
                u1 = CallChecker.beforeCalled(u1, Vector3D.class, 280, 13010, 13011);
                u1 = CallChecker.isCalled(u1, Vector3D.class, 280, 13010, 13011).normalize();
                CallChecker.varAssign(u1, "u1", 280, 13005, 13024);
            }
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 284, 13199, 13200);
            final Vector3D v3 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(v1, Vector3D.class, 284, 13199, 13200).crossProduct(v2), Vector3D.class, 284, 13199, 13217).normalize(), "v3", 284, 13033, 13230);
            if (CallChecker.beforeDeref(v3, Vector3D.class, 285, 13243, 13244)) {
                final Vector3D npe_invocation_var31 = CallChecker.isCalled(v3, Vector3D.class, 285, 13243, 13244).crossProduct(v1);
                if (CallChecker.beforeDeref(npe_invocation_var31, Vector3D.class, 285, 13243, 13261)) {
                    v2 = CallChecker.isCalled(npe_invocation_var31, Vector3D.class, 285, 13243, 13261).normalize();
                    CallChecker.varAssign(v2, "v2", 285, 13238, 13274);
                }
            }
            if (CallChecker.beforeDeref(v1, Vector3D.class, 286, 13287, 13288)) {
                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 286, 13287, 13288);
                v1 = CallChecker.isCalled(v1, Vector3D.class, 286, 13287, 13288).normalize();
                CallChecker.varAssign(v1, "v1", 286, 13282, 13301);
            }
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 291, 13474, 13475);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 291, 13485, 13486);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 291, 13496, 13497);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 291, 13507, 13508);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 292, 13584, 13585);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 292, 13595, 13596);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 292, 13606, 13607);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 292, 13617, 13618);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 293, 13694, 13695);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 293, 13705, 13706);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 293, 13716, 13717);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 293, 13727, 13728);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 296, 13828, 13829);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 296, 13839, 13840);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 296, 13850, 13851);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 296, 13861, 13862);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 297, 13938, 13939);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 297, 13949, 13950);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 297, 13960, 13961);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 297, 13971, 13972);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 298, 14048, 14049);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 298, 14059, 14060);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 298, 14070, 14071);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 298, 14081, 14082);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 301, 14182, 14183);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 301, 14193, 14194);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 301, 14204, 14205);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 301, 14215, 14216);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 302, 14292, 14293);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 302, 14303, 14304);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 302, 14314, 14315);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 302, 14325, 14326);
            u1 = CallChecker.beforeCalled(u1, Vector3D.class, 303, 14402, 14403);
            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 303, 14413, 14414);
            u2 = CallChecker.beforeCalled(u2, Vector3D.class, 303, 14424, 14425);
            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 303, 14435, 14436);
            final double[][] m = CallChecker.varInit(new double[][]{ new double[]{ MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 291, 13474, 13475).getX(), CallChecker.isCalled(v1, Vector3D.class, 291, 13485, 13486).getX(), CallChecker.isCalled(u2, Vector3D.class, 291, 13496, 13497).getX(), CallChecker.isCalled(v2, Vector3D.class, 291, 13507, 13508).getX(), CallChecker.isCalled(u3, Vector3D.class, 291, 13518, 13519).getX(), CallChecker.isCalled(v3, Vector3D.class, 291, 13529, 13530).getX()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 292, 13584, 13585).getY(), CallChecker.isCalled(v1, Vector3D.class, 292, 13595, 13596).getX(), CallChecker.isCalled(u2, Vector3D.class, 292, 13606, 13607).getY(), CallChecker.isCalled(v2, Vector3D.class, 292, 13617, 13618).getX(), CallChecker.isCalled(u3, Vector3D.class, 292, 13628, 13629).getY(), CallChecker.isCalled(v3, Vector3D.class, 292, 13639, 13640).getX()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 293, 13694, 13695).getZ(), CallChecker.isCalled(v1, Vector3D.class, 293, 13705, 13706).getX(), CallChecker.isCalled(u2, Vector3D.class, 293, 13716, 13717).getZ(), CallChecker.isCalled(v2, Vector3D.class, 293, 13727, 13728).getX(), CallChecker.isCalled(u3, Vector3D.class, 293, 13738, 13739).getZ(), CallChecker.isCalled(v3, Vector3D.class, 293, 13749, 13750).getX()) } , new double[]{ MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 296, 13828, 13829).getX(), CallChecker.isCalled(v1, Vector3D.class, 296, 13839, 13840).getY(), CallChecker.isCalled(u2, Vector3D.class, 296, 13850, 13851).getX(), CallChecker.isCalled(v2, Vector3D.class, 296, 13861, 13862).getY(), CallChecker.isCalled(u3, Vector3D.class, 296, 13872, 13873).getX(), CallChecker.isCalled(v3, Vector3D.class, 296, 13883, 13884).getY()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 297, 13938, 13939).getY(), CallChecker.isCalled(v1, Vector3D.class, 297, 13949, 13950).getY(), CallChecker.isCalled(u2, Vector3D.class, 297, 13960, 13961).getY(), CallChecker.isCalled(v2, Vector3D.class, 297, 13971, 13972).getY(), CallChecker.isCalled(u3, Vector3D.class, 297, 13982, 13983).getY(), CallChecker.isCalled(v3, Vector3D.class, 297, 13993, 13994).getY()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 298, 14048, 14049).getZ(), CallChecker.isCalled(v1, Vector3D.class, 298, 14059, 14060).getY(), CallChecker.isCalled(u2, Vector3D.class, 298, 14070, 14071).getZ(), CallChecker.isCalled(v2, Vector3D.class, 298, 14081, 14082).getY(), CallChecker.isCalled(u3, Vector3D.class, 298, 14092, 14093).getZ(), CallChecker.isCalled(v3, Vector3D.class, 298, 14103, 14104).getY()) } , new double[]{ MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 301, 14182, 14183).getX(), CallChecker.isCalled(v1, Vector3D.class, 301, 14193, 14194).getZ(), CallChecker.isCalled(u2, Vector3D.class, 301, 14204, 14205).getX(), CallChecker.isCalled(v2, Vector3D.class, 301, 14215, 14216).getZ(), CallChecker.isCalled(u3, Vector3D.class, 301, 14226, 14227).getX(), CallChecker.isCalled(v3, Vector3D.class, 301, 14237, 14238).getZ()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 302, 14292, 14293).getY(), CallChecker.isCalled(v1, Vector3D.class, 302, 14303, 14304).getZ(), CallChecker.isCalled(u2, Vector3D.class, 302, 14314, 14315).getY(), CallChecker.isCalled(v2, Vector3D.class, 302, 14325, 14326).getZ(), CallChecker.isCalled(u3, Vector3D.class, 302, 14336, 14337).getY(), CallChecker.isCalled(v3, Vector3D.class, 302, 14347, 14348).getZ()) , MathArrays.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 303, 14402, 14403).getZ(), CallChecker.isCalled(v1, Vector3D.class, 303, 14413, 14414).getZ(), CallChecker.isCalled(u2, Vector3D.class, 303, 14424, 14425).getZ(), CallChecker.isCalled(v2, Vector3D.class, 303, 14435, 14436).getZ(), CallChecker.isCalled(u3, Vector3D.class, 303, 14446, 14447).getZ(), CallChecker.isCalled(v3, Vector3D.class, 303, 14457, 14458).getZ()) } }, "m", 289, 13381, 14487);
            double[] quat = CallChecker.varInit(Rotation.mat2quat(m), "quat", 307, 14496, 14523);
            quat = CallChecker.beforeCalled(quat, double[].class, 308, 14536, 14539);
            q0 = CallChecker.isCalled(quat, double[].class, 308, 14536, 14539)[0];
            CallChecker.varAssign(this.q0, "this.q0", 308, 14531, 14543);
            quat = CallChecker.beforeCalled(quat, double[].class, 309, 14556, 14559);
            q1 = CallChecker.isCalled(quat, double[].class, 309, 14556, 14559)[1];
            CallChecker.varAssign(this.q1, "this.q1", 309, 14551, 14563);
            quat = CallChecker.beforeCalled(quat, double[].class, 310, 14576, 14579);
            q2 = CallChecker.isCalled(quat, double[].class, 310, 14576, 14579)[2];
            CallChecker.varAssign(this.q2, "this.q2", 310, 14571, 14583);
            quat = CallChecker.beforeCalled(quat, double[].class, 311, 14596, 14599);
            q3 = CallChecker.isCalled(quat, double[].class, 311, 14596, 14599)[3];
            CallChecker.varAssign(this.q3, "this.q3", 311, 14591, 14603);
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public Rotation(Vector3D u, Vector3D v) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context69 = new ConstructorContext(Rotation.class, 328, 14613, 16204);
        try {
            double normProduct = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 330, 15342, 15342)) {
                if (CallChecker.beforeDeref(v, Vector3D.class, 330, 15356, 15356)) {
                    u = CallChecker.beforeCalled(u, Vector3D.class, 330, 15342, 15342);
                    v = CallChecker.beforeCalled(v, Vector3D.class, 330, 15356, 15356);
                    normProduct = (CallChecker.isCalled(u, Vector3D.class, 330, 15342, 15342).getNorm()) * (CallChecker.isCalled(v, Vector3D.class, 330, 15356, 15356).getNorm());
                    CallChecker.varAssign(normProduct, "normProduct", 330, 15342, 15342);
                }
            }
            if (normProduct == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR);
            }
            double dot = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 335, 15521, 15521)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 335, 15521, 15521);
                dot = CallChecker.isCalled(u, Vector3D.class, 335, 15521, 15521).dotProduct(v);
                CallChecker.varAssign(dot, "dot", 335, 15521, 15521);
            }
            if (dot < ((2.0E-15 - 1.0) * normProduct)) {
                Vector3D w = CallChecker.init(Vector3D.class);
                if (CallChecker.beforeDeref(u, Vector3D.class, 340, 15719, 15719)) {
                    u = CallChecker.beforeCalled(u, Vector3D.class, 340, 15719, 15719);
                    w = CallChecker.isCalled(u, Vector3D.class, 340, 15719, 15719).orthogonal();
                    CallChecker.varAssign(w, "w", 340, 15719, 15719);
                }
                q0 = 0.0;
                CallChecker.varAssign(this.q0, "this.q0", 341, 15741, 15749);
                w = CallChecker.beforeCalled(w, Vector3D.class, 342, 15763, 15763);
                q1 = -(CallChecker.isCalled(w, Vector3D.class, 342, 15763, 15763).getX());
                CallChecker.varAssign(this.q1, "this.q1", 342, 15757, 15771);
                w = CallChecker.beforeCalled(w, Vector3D.class, 343, 15785, 15785);
                q2 = -(CallChecker.isCalled(w, Vector3D.class, 343, 15785, 15785).getY());
                CallChecker.varAssign(this.q2, "this.q2", 343, 15779, 15793);
                w = CallChecker.beforeCalled(w, Vector3D.class, 344, 15807, 15807);
                q3 = -(CallChecker.isCalled(w, Vector3D.class, 344, 15807, 15807).getZ());
                CallChecker.varAssign(this.q3, "this.q3", 344, 15801, 15815);
            }else {
                q0 = FastMath.sqrt((0.5 * (1.0 + (dot / normProduct))));
                CallChecker.varAssign(this.q0, "this.q0", 348, 15964, 16015);
                double coeff = CallChecker.varInit(((double) (1.0 / ((2.0 * (this.q0)) * normProduct))), "coeff", 349, 16023, 16068);
                Vector3D q = CallChecker.init(Vector3D.class);
                if (CallChecker.beforeDeref(v, Vector3D.class, 350, 16089, 16089)) {
                    v = CallChecker.beforeCalled(v, Vector3D.class, 350, 16089, 16089);
                    q = CallChecker.isCalled(v, Vector3D.class, 350, 16089, 16089).crossProduct(u);
                    CallChecker.varAssign(q, "q", 350, 16089, 16089);
                }
                q = CallChecker.beforeCalled(q, Vector3D.class, 351, 16127, 16127);
                q1 = coeff * (CallChecker.isCalled(q, Vector3D.class, 351, 16127, 16127).getX());
                CallChecker.varAssign(this.q1, "this.q1", 351, 16114, 16135);
                q = CallChecker.beforeCalled(q, Vector3D.class, 352, 16156, 16156);
                q2 = coeff * (CallChecker.isCalled(q, Vector3D.class, 352, 16156, 16156).getY());
                CallChecker.varAssign(this.q2, "this.q2", 352, 16143, 16164);
                q = CallChecker.beforeCalled(q, Vector3D.class, 353, 16185, 16185);
                q3 = coeff * (CallChecker.isCalled(q, Vector3D.class, 353, 16185, 16185).getZ());
                CallChecker.varAssign(this.q3, "this.q3", 353, 16172, 16193);
            }
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public Rotation(RotationOrder order, double alpha1, double alpha2, double alpha3) {
        ConstructorContext _bcornu_methode_context70 = new ConstructorContext(Rotation.class, 377, 16209, 17671);
        try {
            Rotation r1 = CallChecker.init(Rotation.class);
            if (CallChecker.beforeDeref(order, RotationOrder.class, 379, 17381, 17385)) {
                order = CallChecker.beforeCalled(order, RotationOrder.class, 379, 17381, 17385);
                r1 = new Rotation(CallChecker.isCalled(order, RotationOrder.class, 379, 17381, 17385).getA1(), alpha1);
                CallChecker.varAssign(r1, "r1", 379, 17381, 17385);
            }
            Rotation r2 = CallChecker.init(Rotation.class);
            if (CallChecker.beforeDeref(order, RotationOrder.class, 380, 17438, 17442)) {
                order = CallChecker.beforeCalled(order, RotationOrder.class, 380, 17438, 17442);
                r2 = new Rotation(CallChecker.isCalled(order, RotationOrder.class, 380, 17438, 17442).getA2(), alpha2);
                CallChecker.varAssign(r2, "r2", 380, 17438, 17442);
            }
            Rotation r3 = CallChecker.init(Rotation.class);
            if (CallChecker.beforeDeref(order, RotationOrder.class, 381, 17495, 17499)) {
                order = CallChecker.beforeCalled(order, RotationOrder.class, 381, 17495, 17499);
                r3 = new Rotation(CallChecker.isCalled(order, RotationOrder.class, 381, 17495, 17499).getA3(), alpha3);
                CallChecker.varAssign(r3, "r3", 381, 17495, 17499);
            }
            Rotation composed = CallChecker.init(Rotation.class);
            if (CallChecker.beforeDeref(r2, Rotation.class, 382, 17556, 17557)) {
                if (CallChecker.beforeDeref(r1, Rotation.class, 382, 17545, 17546)) {
                    r2 = CallChecker.beforeCalled(r2, Rotation.class, 382, 17556, 17557);
                    r1 = CallChecker.beforeCalled(r1, Rotation.class, 382, 17545, 17546);
                    composed = CallChecker.isCalled(r1, Rotation.class, 382, 17545, 17546).applyTo(CallChecker.isCalled(r2, Rotation.class, 382, 17556, 17557).applyTo(r3));
                    CallChecker.varAssign(composed, "composed", 382, 17556, 17557);
                }
            }
            composed = CallChecker.beforeCalled(composed, Rotation.class, 383, 17584, 17591);
            q0 = CallChecker.isCalled(composed, Rotation.class, 383, 17584, 17591).q0;
            CallChecker.varAssign(this.q0, "this.q0", 383, 17579, 17595);
            composed = CallChecker.beforeCalled(composed, Rotation.class, 384, 17608, 17615);
            q1 = CallChecker.isCalled(composed, Rotation.class, 384, 17608, 17615).q1;
            CallChecker.varAssign(this.q1, "this.q1", 384, 17603, 17619);
            composed = CallChecker.beforeCalled(composed, Rotation.class, 385, 17632, 17639);
            q2 = CallChecker.isCalled(composed, Rotation.class, 385, 17632, 17639).q2;
            CallChecker.varAssign(this.q2, "this.q2", 385, 17627, 17643);
            composed = CallChecker.beforeCalled(composed, Rotation.class, 386, 17656, 17663);
            q3 = CallChecker.isCalled(composed, Rotation.class, 386, 17656, 17663).q3;
            CallChecker.varAssign(this.q3, "this.q3", 386, 17651, 17667);
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    private static double[] mat2quat(final double[][] ort) {
        MethodContext _bcornu_methode_context265 = new MethodContext(double[].class, 393, 17676, 20387);
        try {
            CallChecker.varInit(ort, "ort", 393, 17676, 20387);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 393, 17676, 20387);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 393, 17676, 20387);
            final double[] quat = CallChecker.varInit(new double[4], "quat", 395, 17902, 17937);
            double s = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(ort, double[][].class, 408, 18712, 18714)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 408, 18712, 18714)[0], double[].class, 408, 18712, 18717)) {
                    if (CallChecker.beforeDeref(ort, double[][].class, 408, 18724, 18726)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 408, 18724, 18726)[1], double[].class, 408, 18724, 18729)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 408, 18736, 18738)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 408, 18736, 18738)[2], double[].class, 408, 18736, 18741)) {
                                    CallChecker.isCalled(ort, double[][].class, 408, 18712, 18714)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 408, 18712, 18714)[0], double[].class, 408, 18712, 18717);
                                    CallChecker.isCalled(ort, double[][].class, 408, 18724, 18726)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 408, 18724, 18726)[1], double[].class, 408, 18724, 18729);
                                    CallChecker.isCalled(ort, double[][].class, 408, 18736, 18738)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 408, 18736, 18738)[2], double[].class, 408, 18736, 18741);
                                    s = ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 408, 18712, 18714)[0], double[].class, 408, 18712, 18717)[0]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 408, 18724, 18726)[1], double[].class, 408, 18724, 18729)[1])) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 408, 18736, 18738)[2], double[].class, 408, 18736, 18741)[2]);
                                    CallChecker.varAssign(s, "s", 408, 18712, 18714);
                                }
                            }
                        }
                    }
                }
            }
            if (s > (-0.19)) {
                if (CallChecker.beforeDeref(quat, double[].class, 411, 18829, 18832)) {
                    CallChecker.isCalled(quat, double[].class, 411, 18829, 18832)[0] = 0.5 * (FastMath.sqrt((s + 1.0)));
                    CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 411, 18829, 18832)[0], "CallChecker.isCalled(quat, double[].class, 411, 18829, 18832)[0]", 411, 18829, 18867);
                }
                double inv = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(quat, double[].class, 412, 18899, 18902)) {
                    inv = 0.25 / (CallChecker.isCalled(quat, double[].class, 412, 18899, 18902)[0]);
                    CallChecker.varAssign(inv, "inv", 412, 18899, 18902);
                }
                if (CallChecker.beforeDeref(quat, double[].class, 413, 18918, 18921)) {
                    if (CallChecker.beforeDeref(ort, double[][].class, 413, 18935, 18937)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 413, 18935, 18937)[1], double[].class, 413, 18935, 18940)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 413, 18947, 18949)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 413, 18947, 18949)[2], double[].class, 413, 18947, 18952)) {
                                    CallChecker.isCalled(ort, double[][].class, 413, 18935, 18937)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 413, 18935, 18937)[1], double[].class, 413, 18935, 18940);
                                    CallChecker.isCalled(ort, double[][].class, 413, 18947, 18949)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 413, 18947, 18949)[2], double[].class, 413, 18947, 18952);
                                    CallChecker.isCalled(quat, double[].class, 413, 18918, 18921)[1] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 413, 18935, 18937)[1], double[].class, 413, 18935, 18940)[2]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 413, 18947, 18949)[2], double[].class, 413, 18947, 18952)[1]));
                                    CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 413, 18918, 18921)[1], "CallChecker.isCalled(quat, double[].class, 413, 18918, 18921)[1]", 413, 18918, 18957);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(quat, double[].class, 414, 18969, 18972)) {
                    if (CallChecker.beforeDeref(ort, double[][].class, 414, 18986, 18988)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 414, 18986, 18988)[2], double[].class, 414, 18986, 18991)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 414, 18998, 19000)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 414, 18998, 19000)[0], double[].class, 414, 18998, 19003)) {
                                    CallChecker.isCalled(ort, double[][].class, 414, 18986, 18988)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 414, 18986, 18988)[2], double[].class, 414, 18986, 18991);
                                    CallChecker.isCalled(ort, double[][].class, 414, 18998, 19000)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 414, 18998, 19000)[0], double[].class, 414, 18998, 19003);
                                    CallChecker.isCalled(quat, double[].class, 414, 18969, 18972)[2] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 414, 18986, 18988)[2], double[].class, 414, 18986, 18991)[0]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 414, 18998, 19000)[0], double[].class, 414, 18998, 19003)[2]));
                                    CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 414, 18969, 18972)[2], "CallChecker.isCalled(quat, double[].class, 414, 18969, 18972)[2]", 414, 18969, 19008);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(quat, double[].class, 415, 19020, 19023)) {
                    if (CallChecker.beforeDeref(ort, double[][].class, 415, 19037, 19039)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 415, 19037, 19039)[0], double[].class, 415, 19037, 19042)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 415, 19049, 19051)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 415, 19049, 19051)[1], double[].class, 415, 19049, 19054)) {
                                    CallChecker.isCalled(ort, double[][].class, 415, 19037, 19039)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 415, 19037, 19039)[0], double[].class, 415, 19037, 19042);
                                    CallChecker.isCalled(ort, double[][].class, 415, 19049, 19051)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 415, 19049, 19051)[1], double[].class, 415, 19049, 19054);
                                    CallChecker.isCalled(quat, double[].class, 415, 19020, 19023)[3] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 415, 19037, 19039)[0], double[].class, 415, 19037, 19042)[1]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 415, 19049, 19051)[1], double[].class, 415, 19049, 19054)[0]));
                                    CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 415, 19020, 19023)[3], "CallChecker.isCalled(quat, double[].class, 415, 19020, 19023)[3]", 415, 19020, 19059);
                                }
                            }
                        }
                    }
                }
            }else {
                if (CallChecker.beforeDeref(ort, double[][].class, 417, 19090, 19092)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 417, 19090, 19092)[0], double[].class, 417, 19090, 19095)) {
                        if (CallChecker.beforeDeref(ort, double[][].class, 417, 19102, 19104)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 417, 19102, 19104)[1], double[].class, 417, 19102, 19107)) {
                                if (CallChecker.beforeDeref(ort, double[][].class, 417, 19114, 19116)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 417, 19114, 19116)[2], double[].class, 417, 19114, 19119)) {
                                        CallChecker.isCalled(ort, double[][].class, 417, 19090, 19092)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 417, 19090, 19092)[0], double[].class, 417, 19090, 19095);
                                        CallChecker.isCalled(ort, double[][].class, 417, 19102, 19104)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 417, 19102, 19104)[1], double[].class, 417, 19102, 19107);
                                        CallChecker.isCalled(ort, double[][].class, 417, 19114, 19116)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 417, 19114, 19116)[2], double[].class, 417, 19114, 19119);
                                        s = ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 417, 19090, 19092)[0], double[].class, 417, 19090, 19095)[0]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 417, 19102, 19104)[1], double[].class, 417, 19102, 19107)[1])) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 417, 19114, 19116)[2], double[].class, 417, 19114, 19119)[2]);
                                        CallChecker.varAssign(s, "s", 417, 19086, 19123);
                                    }
                                }
                            }
                        }
                    }
                }
                if (s > (-0.19)) {
                    if (CallChecker.beforeDeref(quat, double[].class, 420, 19219, 19222)) {
                        CallChecker.isCalled(quat, double[].class, 420, 19219, 19222)[1] = 0.5 * (FastMath.sqrt((s + 1.0)));
                        CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 420, 19219, 19222)[1], "CallChecker.isCalled(quat, double[].class, 420, 19219, 19222)[1]", 420, 19219, 19257);
                    }
                    double inv = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(quat, double[].class, 421, 19293, 19296)) {
                        inv = 0.25 / (CallChecker.isCalled(quat, double[].class, 421, 19293, 19296)[1]);
                        CallChecker.varAssign(inv, "inv", 421, 19293, 19296);
                    }
                    if (CallChecker.beforeDeref(quat, double[].class, 422, 19316, 19319)) {
                        if (CallChecker.beforeDeref(ort, double[][].class, 422, 19333, 19335)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 422, 19333, 19335)[1], double[].class, 422, 19333, 19338)) {
                                if (CallChecker.beforeDeref(ort, double[][].class, 422, 19345, 19347)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 422, 19345, 19347)[2], double[].class, 422, 19345, 19350)) {
                                        CallChecker.isCalled(ort, double[][].class, 422, 19333, 19335)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 422, 19333, 19335)[1], double[].class, 422, 19333, 19338);
                                        CallChecker.isCalled(ort, double[][].class, 422, 19345, 19347)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 422, 19345, 19347)[2], double[].class, 422, 19345, 19350);
                                        CallChecker.isCalled(quat, double[].class, 422, 19316, 19319)[0] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 422, 19333, 19335)[1], double[].class, 422, 19333, 19338)[2]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 422, 19345, 19347)[2], double[].class, 422, 19345, 19350)[1]));
                                        CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 422, 19316, 19319)[0], "CallChecker.isCalled(quat, double[].class, 422, 19316, 19319)[0]", 422, 19316, 19355);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(quat, double[].class, 423, 19371, 19374)) {
                        if (CallChecker.beforeDeref(ort, double[][].class, 423, 19388, 19390)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 423, 19388, 19390)[0], double[].class, 423, 19388, 19393)) {
                                if (CallChecker.beforeDeref(ort, double[][].class, 423, 19400, 19402)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 423, 19400, 19402)[1], double[].class, 423, 19400, 19405)) {
                                        CallChecker.isCalled(ort, double[][].class, 423, 19388, 19390)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 423, 19388, 19390)[0], double[].class, 423, 19388, 19393);
                                        CallChecker.isCalled(ort, double[][].class, 423, 19400, 19402)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 423, 19400, 19402)[1], double[].class, 423, 19400, 19405);
                                        CallChecker.isCalled(quat, double[].class, 423, 19371, 19374)[2] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 423, 19388, 19390)[0], double[].class, 423, 19388, 19393)[1]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 423, 19400, 19402)[1], double[].class, 423, 19400, 19405)[0]));
                                        CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 423, 19371, 19374)[2], "CallChecker.isCalled(quat, double[].class, 423, 19371, 19374)[2]", 423, 19371, 19410);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(quat, double[].class, 424, 19426, 19429)) {
                        if (CallChecker.beforeDeref(ort, double[][].class, 424, 19443, 19445)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 424, 19443, 19445)[0], double[].class, 424, 19443, 19448)) {
                                if (CallChecker.beforeDeref(ort, double[][].class, 424, 19455, 19457)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 424, 19455, 19457)[2], double[].class, 424, 19455, 19460)) {
                                        CallChecker.isCalled(ort, double[][].class, 424, 19443, 19445)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 424, 19443, 19445)[0], double[].class, 424, 19443, 19448);
                                        CallChecker.isCalled(ort, double[][].class, 424, 19455, 19457)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 424, 19455, 19457)[2], double[].class, 424, 19455, 19460);
                                        CallChecker.isCalled(quat, double[].class, 424, 19426, 19429)[3] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 424, 19443, 19445)[0], double[].class, 424, 19443, 19448)[2]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 424, 19455, 19457)[2], double[].class, 424, 19455, 19460)[0]));
                                        CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 424, 19426, 19429)[3], "CallChecker.isCalled(quat, double[].class, 424, 19426, 19429)[3]", 424, 19426, 19465);
                                    }
                                }
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(ort, double[][].class, 426, 19504, 19506)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 426, 19504, 19506)[1], double[].class, 426, 19504, 19509)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 426, 19516, 19518)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 426, 19516, 19518)[0], double[].class, 426, 19516, 19521)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 426, 19528, 19530)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 426, 19528, 19530)[2], double[].class, 426, 19528, 19533)) {
                                            CallChecker.isCalled(ort, double[][].class, 426, 19504, 19506)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 426, 19504, 19506)[1], double[].class, 426, 19504, 19509);
                                            CallChecker.isCalled(ort, double[][].class, 426, 19516, 19518)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 426, 19516, 19518)[0], double[].class, 426, 19516, 19521);
                                            CallChecker.isCalled(ort, double[][].class, 426, 19528, 19530)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 426, 19528, 19530)[2], double[].class, 426, 19528, 19533);
                                            s = ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 426, 19504, 19506)[1], double[].class, 426, 19504, 19509)[1]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 426, 19516, 19518)[0], double[].class, 426, 19516, 19521)[0])) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 426, 19528, 19530)[2], double[].class, 426, 19528, 19533)[2]);
                                            CallChecker.varAssign(s, "s", 426, 19500, 19537);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (s > (-0.19)) {
                        if (CallChecker.beforeDeref(quat, double[].class, 429, 19645, 19648)) {
                            CallChecker.isCalled(quat, double[].class, 429, 19645, 19648)[2] = 0.5 * (FastMath.sqrt((s + 1.0)));
                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 429, 19645, 19648)[2], "CallChecker.isCalled(quat, double[].class, 429, 19645, 19648)[2]", 429, 19645, 19683);
                        }
                        double inv = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(quat, double[].class, 430, 19723, 19726)) {
                            inv = 0.25 / (CallChecker.isCalled(quat, double[].class, 430, 19723, 19726)[2]);
                            CallChecker.varAssign(inv, "inv", 430, 19723, 19726);
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 431, 19750, 19753)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 431, 19767, 19769)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 431, 19767, 19769)[2], double[].class, 431, 19767, 19772)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 431, 19779, 19781)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 431, 19779, 19781)[0], double[].class, 431, 19779, 19784)) {
                                            CallChecker.isCalled(ort, double[][].class, 431, 19767, 19769)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 431, 19767, 19769)[2], double[].class, 431, 19767, 19772);
                                            CallChecker.isCalled(ort, double[][].class, 431, 19779, 19781)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 431, 19779, 19781)[0], double[].class, 431, 19779, 19784);
                                            CallChecker.isCalled(quat, double[].class, 431, 19750, 19753)[0] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 431, 19767, 19769)[2], double[].class, 431, 19767, 19772)[0]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 431, 19779, 19781)[0], double[].class, 431, 19779, 19784)[2]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 431, 19750, 19753)[0], "CallChecker.isCalled(quat, double[].class, 431, 19750, 19753)[0]", 431, 19750, 19789);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 432, 19809, 19812)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 432, 19826, 19828)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 432, 19826, 19828)[0], double[].class, 432, 19826, 19831)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 432, 19838, 19840)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 432, 19838, 19840)[1], double[].class, 432, 19838, 19843)) {
                                            CallChecker.isCalled(ort, double[][].class, 432, 19826, 19828)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 432, 19826, 19828)[0], double[].class, 432, 19826, 19831);
                                            CallChecker.isCalled(ort, double[][].class, 432, 19838, 19840)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 432, 19838, 19840)[1], double[].class, 432, 19838, 19843);
                                            CallChecker.isCalled(quat, double[].class, 432, 19809, 19812)[1] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 432, 19826, 19828)[0], double[].class, 432, 19826, 19831)[1]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 432, 19838, 19840)[1], double[].class, 432, 19838, 19843)[0]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 432, 19809, 19812)[1], "CallChecker.isCalled(quat, double[].class, 432, 19809, 19812)[1]", 432, 19809, 19848);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 433, 19868, 19871)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 433, 19885, 19887)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 433, 19885, 19887)[2], double[].class, 433, 19885, 19890)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 433, 19897, 19899)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 433, 19897, 19899)[1], double[].class, 433, 19897, 19902)) {
                                            CallChecker.isCalled(ort, double[][].class, 433, 19885, 19887)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 433, 19885, 19887)[2], double[].class, 433, 19885, 19890);
                                            CallChecker.isCalled(ort, double[][].class, 433, 19897, 19899)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 433, 19897, 19899)[1], double[].class, 433, 19897, 19902);
                                            CallChecker.isCalled(quat, double[].class, 433, 19868, 19871)[3] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 433, 19885, 19887)[2], double[].class, 433, 19885, 19890)[1]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 433, 19897, 19899)[1], double[].class, 433, 19897, 19902)[2]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 433, 19868, 19871)[3], "CallChecker.isCalled(quat, double[].class, 433, 19868, 19871)[3]", 433, 19868, 19907);
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(ort, double[][].class, 436, 20011, 20013)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 436, 20011, 20013)[2], double[].class, 436, 20011, 20016)) {
                                if (CallChecker.beforeDeref(ort, double[][].class, 436, 20023, 20025)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 436, 20023, 20025)[0], double[].class, 436, 20023, 20028)) {
                                        if (CallChecker.beforeDeref(ort, double[][].class, 436, 20035, 20037)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 436, 20035, 20037)[1], double[].class, 436, 20035, 20040)) {
                                                CallChecker.isCalled(ort, double[][].class, 436, 20011, 20013)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 436, 20011, 20013)[2], double[].class, 436, 20011, 20016);
                                                CallChecker.isCalled(ort, double[][].class, 436, 20023, 20025)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 436, 20023, 20025)[0], double[].class, 436, 20023, 20028);
                                                CallChecker.isCalled(ort, double[][].class, 436, 20035, 20037)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 436, 20035, 20037)[1], double[].class, 436, 20035, 20040);
                                                s = ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 436, 20011, 20013)[2], double[].class, 436, 20011, 20016)[2]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 436, 20023, 20025)[0], double[].class, 436, 20023, 20028)[0])) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 436, 20035, 20037)[1], double[].class, 436, 20035, 20040)[1]);
                                                CallChecker.varAssign(s, "s", 436, 20007, 20044);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 437, 20064, 20067)) {
                            CallChecker.isCalled(quat, double[].class, 437, 20064, 20067)[3] = 0.5 * (FastMath.sqrt((s + 1.0)));
                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 437, 20064, 20067)[3], "CallChecker.isCalled(quat, double[].class, 437, 20064, 20067)[3]", 437, 20064, 20102);
                        }
                        double inv = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(quat, double[].class, 438, 20142, 20145)) {
                            inv = 0.25 / (CallChecker.isCalled(quat, double[].class, 438, 20142, 20145)[3]);
                            CallChecker.varAssign(inv, "inv", 438, 20142, 20145);
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 439, 20169, 20172)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 439, 20186, 20188)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 439, 20186, 20188)[0], double[].class, 439, 20186, 20191)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 439, 20198, 20200)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 439, 20198, 20200)[1], double[].class, 439, 20198, 20203)) {
                                            CallChecker.isCalled(ort, double[][].class, 439, 20186, 20188)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 439, 20186, 20188)[0], double[].class, 439, 20186, 20191);
                                            CallChecker.isCalled(ort, double[][].class, 439, 20198, 20200)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 439, 20198, 20200)[1], double[].class, 439, 20198, 20203);
                                            CallChecker.isCalled(quat, double[].class, 439, 20169, 20172)[0] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 439, 20186, 20188)[0], double[].class, 439, 20186, 20191)[1]) - (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 439, 20198, 20200)[1], double[].class, 439, 20198, 20203)[0]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 439, 20169, 20172)[0], "CallChecker.isCalled(quat, double[].class, 439, 20169, 20172)[0]", 439, 20169, 20208);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 440, 20228, 20231)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 440, 20245, 20247)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 440, 20245, 20247)[0], double[].class, 440, 20245, 20250)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 440, 20257, 20259)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 440, 20257, 20259)[2], double[].class, 440, 20257, 20262)) {
                                            CallChecker.isCalled(ort, double[][].class, 440, 20245, 20247)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 440, 20245, 20247)[0], double[].class, 440, 20245, 20250);
                                            CallChecker.isCalled(ort, double[][].class, 440, 20257, 20259)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 440, 20257, 20259)[2], double[].class, 440, 20257, 20262);
                                            CallChecker.isCalled(quat, double[].class, 440, 20228, 20231)[1] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 440, 20245, 20247)[0], double[].class, 440, 20245, 20250)[2]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 440, 20257, 20259)[2], double[].class, 440, 20257, 20262)[0]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 440, 20228, 20231)[1], "CallChecker.isCalled(quat, double[].class, 440, 20228, 20231)[1]", 440, 20228, 20267);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(quat, double[].class, 441, 20287, 20290)) {
                            if (CallChecker.beforeDeref(ort, double[][].class, 441, 20304, 20306)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 441, 20304, 20306)[2], double[].class, 441, 20304, 20309)) {
                                    if (CallChecker.beforeDeref(ort, double[][].class, 441, 20316, 20318)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, double[][].class, 441, 20316, 20318)[1], double[].class, 441, 20316, 20321)) {
                                            CallChecker.isCalled(ort, double[][].class, 441, 20304, 20306)[2] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 441, 20304, 20306)[2], double[].class, 441, 20304, 20309);
                                            CallChecker.isCalled(ort, double[][].class, 441, 20316, 20318)[1] = CallChecker.beforeCalled(CallChecker.isCalled(ort, double[][].class, 441, 20316, 20318)[1], double[].class, 441, 20316, 20321);
                                            CallChecker.isCalled(quat, double[].class, 441, 20287, 20290)[2] = inv * ((CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 441, 20304, 20306)[2], double[].class, 441, 20304, 20309)[1]) + (CallChecker.isCalled(CallChecker.isCalled(ort, double[][].class, 441, 20316, 20318)[1], double[].class, 441, 20316, 20321)[2]));
                                            CallChecker.varAssign(CallChecker.isCalled(quat, double[].class, 441, 20287, 20290)[2], "CallChecker.isCalled(quat, double[].class, 441, 20287, 20290)[2]", 441, 20287, 20326);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return quat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context265.methodEnd();
        }
    }

    public Rotation revert() {
        MethodContext _bcornu_methode_context266 = new MethodContext(Rotation.class, 457, 20392, 20750);
        try {
            CallChecker.varInit(this, "this", 457, 20392, 20750);
            CallChecker.varInit(this.q3, "q3", 457, 20392, 20750);
            CallChecker.varInit(this.q2, "q2", 457, 20392, 20750);
            CallChecker.varInit(this.q1, "q1", 457, 20392, 20750);
            CallChecker.varInit(this.q0, "q0", 457, 20392, 20750);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 457, 20392, 20750);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 457, 20392, 20750);
            return new Rotation((-(q0)), q1, q2, q3, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Rotation) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context266.methodEnd();
        }
    }

    public double getQ0() {
        MethodContext _bcornu_methode_context267 = new MethodContext(double.class, 464, 20755, 20902);
        try {
            CallChecker.varInit(this, "this", 464, 20755, 20902);
            CallChecker.varInit(this.q3, "q3", 464, 20755, 20902);
            CallChecker.varInit(this.q2, "q2", 464, 20755, 20902);
            CallChecker.varInit(this.q1, "q1", 464, 20755, 20902);
            CallChecker.varInit(this.q0, "q0", 464, 20755, 20902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 464, 20755, 20902);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 464, 20755, 20902);
            return q0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context267.methodEnd();
        }
    }

    public double getQ1() {
        MethodContext _bcornu_methode_context268 = new MethodContext(double.class, 471, 20907, 21096);
        try {
            CallChecker.varInit(this, "this", 471, 20907, 21096);
            CallChecker.varInit(this.q3, "q3", 471, 20907, 21096);
            CallChecker.varInit(this.q2, "q2", 471, 20907, 21096);
            CallChecker.varInit(this.q1, "q1", 471, 20907, 21096);
            CallChecker.varInit(this.q0, "q0", 471, 20907, 21096);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 471, 20907, 21096);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 471, 20907, 21096);
            return q1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context268.methodEnd();
        }
    }

    public double getQ2() {
        MethodContext _bcornu_methode_context269 = new MethodContext(double.class, 478, 21101, 21292);
        try {
            CallChecker.varInit(this, "this", 478, 21101, 21292);
            CallChecker.varInit(this.q3, "q3", 478, 21101, 21292);
            CallChecker.varInit(this.q2, "q2", 478, 21101, 21292);
            CallChecker.varInit(this.q1, "q1", 478, 21101, 21292);
            CallChecker.varInit(this.q0, "q0", 478, 21101, 21292);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 478, 21101, 21292);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 478, 21101, 21292);
            return q2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context269.methodEnd();
        }
    }

    public double getQ3() {
        MethodContext _bcornu_methode_context270 = new MethodContext(double.class, 485, 21297, 21486);
        try {
            CallChecker.varInit(this, "this", 485, 21297, 21486);
            CallChecker.varInit(this.q3, "q3", 485, 21297, 21486);
            CallChecker.varInit(this.q2, "q2", 485, 21297, 21486);
            CallChecker.varInit(this.q1, "q1", 485, 21297, 21486);
            CallChecker.varInit(this.q0, "q0", 485, 21297, 21486);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 485, 21297, 21486);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 485, 21297, 21486);
            return q3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context270.methodEnd();
        }
    }

    public Vector3D getAxis() {
        MethodContext _bcornu_methode_context271 = new MethodContext(Vector3D.class, 493, 21491, 22051);
        try {
            CallChecker.varInit(this, "this", 493, 21491, 22051);
            CallChecker.varInit(this.q3, "q3", 493, 21491, 22051);
            CallChecker.varInit(this.q2, "q2", 493, 21491, 22051);
            CallChecker.varInit(this.q1, "q1", 493, 21491, 22051);
            CallChecker.varInit(this.q0, "q0", 493, 21491, 22051);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 493, 21491, 22051);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 493, 21491, 22051);
            double squaredSine = CallChecker.varInit(((double) ((((this.q1) * (this.q1)) + ((this.q2) * (this.q2))) + ((this.q3) * (this.q3)))), "squaredSine", 494, 21659, 21707);
            if (squaredSine == 0) {
                return new Vector3D(1, 0, 0);
            }else
                if ((q0) < 0) {
                    double inverse = CallChecker.varInit(((double) (1 / (FastMath.sqrt(squaredSine)))), "inverse", 498, 21804, 21851);
                    return new Vector3D(((q1) * inverse), ((q2) * inverse), ((q3) * inverse));
                }
            
            double inverse = CallChecker.varInit(((double) ((-1) / (FastMath.sqrt(squaredSine)))), "inverse", 501, 21932, 21980);
            return new Vector3D(((q1) * inverse), ((q2) * inverse), ((q3) * inverse));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context271.methodEnd();
        }
    }

    public double getAngle() {
        MethodContext _bcornu_methode_context272 = new MethodContext(double.class, 509, 22056, 22437);
        try {
            CallChecker.varInit(this, "this", 509, 22056, 22437);
            CallChecker.varInit(this.q3, "q3", 509, 22056, 22437);
            CallChecker.varInit(this.q2, "q2", 509, 22056, 22437);
            CallChecker.varInit(this.q1, "q1", 509, 22056, 22437);
            CallChecker.varInit(this.q0, "q0", 509, 22056, 22437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 509, 22056, 22437);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 509, 22056, 22437);
            if (((q0) < (-0.1)) || ((q0) > 0.1)) {
                return 2 * (FastMath.asin(FastMath.sqrt(((((q1) * (q1)) + ((q2) * (q2))) + ((q3) * (q3))))));
            }else
                if ((q0) < 0) {
                    return 2 * (FastMath.acos((-(q0))));
                }
            
            return 2 * (FastMath.acos(q0));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context272.methodEnd();
        }
    }

    public double[] getAngles(RotationOrder order) throws CardanEulerSingularityException {
        MethodContext _bcornu_methode_context273 = new MethodContext(double[].class, 553, 22442, 33342);
        try {
            CallChecker.varInit(this, "this", 553, 22442, 33342);
            CallChecker.varInit(order, "order", 553, 22442, 33342);
            CallChecker.varInit(this.q3, "q3", 553, 22442, 33342);
            CallChecker.varInit(this.q2, "q2", 553, 22442, 33342);
            CallChecker.varInit(this.q1, "q1", 553, 22442, 33342);
            CallChecker.varInit(this.q0, "q0", 553, 22442, 33342);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 553, 22442, 33342);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 553, 22442, 33342);
            if (order == (RotationOrder.XYZ)) {
                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 563, 24783, 24821);
                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 564, 24829, 24874);
                if (CallChecker.beforeDeref(v2, Vector3D.class, 565, 24888, 24889)) {
                    if (CallChecker.beforeDeref(v2, Vector3D.class, 565, 24919, 24920)) {
                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 565, 24888, 24889);
                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 565, 24919, 24920);
                        if (((CallChecker.isCalled(v2, Vector3D.class, 565, 24888, 24889).getZ()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 565, 24919, 24920).getZ()) > 0.9999999999)) {
                            throw new CardanEulerSingularityException(true);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(v1, Vector3D.class, 569, 25066, 25067)) {
                    if (CallChecker.beforeDeref(v1, Vector3D.class, 569, 25078, 25079)) {
                        if (CallChecker.beforeDeref(v2, Vector3D.class, 570, 25112, 25113)) {
                            if (CallChecker.beforeDeref(v2, Vector3D.class, 571, 25149, 25150)) {
                                if (CallChecker.beforeDeref(v2, Vector3D.class, 571, 25161, 25162)) {
                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 569, 25066, 25067);
                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 569, 25078, 25079);
                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 570, 25112, 25113);
                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 571, 25149, 25150);
                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 571, 25161, 25162);
                                    return new double[]{ FastMath.atan2((-(CallChecker.isCalled(v1, Vector3D.class, 569, 25066, 25067).getY())), CallChecker.isCalled(v1, Vector3D.class, 569, 25078, 25079).getZ()) , FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 570, 25112, 25113).getZ()) , FastMath.atan2((-(CallChecker.isCalled(v2, Vector3D.class, 571, 25149, 25150).getY())), CallChecker.isCalled(v2, Vector3D.class, 571, 25161, 25162).getX()) };
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
                if (order == (RotationOrder.XZY)) {
                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 581, 25528, 25566);
                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 582, 25574, 25619);
                    if (CallChecker.beforeDeref(v2, Vector3D.class, 583, 25632, 25633)) {
                        if (CallChecker.beforeDeref(v2, Vector3D.class, 583, 25663, 25664)) {
                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 583, 25632, 25633);
                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 583, 25663, 25664);
                            if (((CallChecker.isCalled(v2, Vector3D.class, 583, 25632, 25633).getY()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 583, 25663, 25664).getY()) > 0.9999999999)) {
                                throw new CardanEulerSingularityException(true);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(v1, Vector3D.class, 587, 25808, 25809)) {
                        if (CallChecker.beforeDeref(v1, Vector3D.class, 587, 25819, 25820)) {
                            if (CallChecker.beforeDeref(v2, Vector3D.class, 588, 25853, 25854)) {
                                if (CallChecker.beforeDeref(v2, Vector3D.class, 589, 25888, 25889)) {
                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 589, 25899, 25900)) {
                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 587, 25808, 25809);
                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 587, 25819, 25820);
                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 588, 25853, 25854);
                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 589, 25888, 25889);
                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 589, 25899, 25900);
                                        return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 587, 25808, 25809).getZ(), CallChecker.isCalled(v1, Vector3D.class, 587, 25819, 25820).getY()) , -(FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 588, 25853, 25854).getY())) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 589, 25888, 25889).getZ(), CallChecker.isCalled(v2, Vector3D.class, 589, 25899, 25900).getX()) };
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
                    if (order == (RotationOrder.YXZ)) {
                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 599, 26267, 26305);
                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 600, 26313, 26358);
                        if (CallChecker.beforeDeref(v2, Vector3D.class, 601, 26371, 26372)) {
                            if (CallChecker.beforeDeref(v2, Vector3D.class, 601, 26402, 26403)) {
                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 601, 26371, 26372);
                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 601, 26402, 26403);
                                if (((CallChecker.isCalled(v2, Vector3D.class, 601, 26371, 26372).getZ()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 601, 26402, 26403).getZ()) > 0.9999999999)) {
                                    throw new CardanEulerSingularityException(true);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(v1, Vector3D.class, 605, 26547, 26548)) {
                            if (CallChecker.beforeDeref(v1, Vector3D.class, 605, 26558, 26559)) {
                                if (CallChecker.beforeDeref(v2, Vector3D.class, 606, 26592, 26593)) {
                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 607, 26627, 26628)) {
                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 607, 26638, 26639)) {
                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 605, 26547, 26548);
                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 605, 26558, 26559);
                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 606, 26592, 26593);
                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 607, 26627, 26628);
                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 607, 26638, 26639);
                                            return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 605, 26547, 26548).getX(), CallChecker.isCalled(v1, Vector3D.class, 605, 26558, 26559).getZ()) , -(FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 606, 26592, 26593).getZ())) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 607, 26627, 26628).getX(), CallChecker.isCalled(v2, Vector3D.class, 607, 26638, 26639).getY()) };
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
                        if (order == (RotationOrder.YZX)) {
                            Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 617, 27005, 27043);
                            Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 618, 27051, 27096);
                            if (CallChecker.beforeDeref(v2, Vector3D.class, 619, 27109, 27110)) {
                                if (CallChecker.beforeDeref(v2, Vector3D.class, 619, 27140, 27141)) {
                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 619, 27109, 27110);
                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 619, 27140, 27141);
                                    if (((CallChecker.isCalled(v2, Vector3D.class, 619, 27109, 27110).getX()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 619, 27140, 27141).getX()) > 0.9999999999)) {
                                        throw new CardanEulerSingularityException(true);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(v1, Vector3D.class, 623, 27287, 27288)) {
                                if (CallChecker.beforeDeref(v1, Vector3D.class, 623, 27299, 27300)) {
                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 624, 27333, 27334)) {
                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 625, 27370, 27371)) {
                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 625, 27382, 27383)) {
                                                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 623, 27287, 27288);
                                                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 623, 27299, 27300);
                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 624, 27333, 27334);
                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 625, 27370, 27371);
                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 625, 27382, 27383);
                                                return new double[]{ FastMath.atan2((-(CallChecker.isCalled(v1, Vector3D.class, 623, 27287, 27288).getZ())), CallChecker.isCalled(v1, Vector3D.class, 623, 27299, 27300).getX()) , FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 624, 27333, 27334).getX()) , FastMath.atan2((-(CallChecker.isCalled(v2, Vector3D.class, 625, 27370, 27371).getZ())), CallChecker.isCalled(v2, Vector3D.class, 625, 27382, 27383).getY()) };
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
                            if (order == (RotationOrder.ZXY)) {
                                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 635, 27749, 27787);
                                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 636, 27795, 27840);
                                if (CallChecker.beforeDeref(v2, Vector3D.class, 637, 27853, 27854)) {
                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 637, 27884, 27885)) {
                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 637, 27853, 27854);
                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 637, 27884, 27885);
                                        if (((CallChecker.isCalled(v2, Vector3D.class, 637, 27853, 27854).getY()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 637, 27884, 27885).getY()) > 0.9999999999)) {
                                            throw new CardanEulerSingularityException(true);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(v1, Vector3D.class, 641, 28031, 28032)) {
                                    if (CallChecker.beforeDeref(v1, Vector3D.class, 641, 28043, 28044)) {
                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 642, 28077, 28078)) {
                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 643, 28114, 28115)) {
                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 643, 28126, 28127)) {
                                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 641, 28031, 28032);
                                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 641, 28043, 28044);
                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 642, 28077, 28078);
                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 643, 28114, 28115);
                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 643, 28126, 28127);
                                                    return new double[]{ FastMath.atan2((-(CallChecker.isCalled(v1, Vector3D.class, 641, 28031, 28032).getX())), CallChecker.isCalled(v1, Vector3D.class, 641, 28043, 28044).getY()) , FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 642, 28077, 28078).getY()) , FastMath.atan2((-(CallChecker.isCalled(v2, Vector3D.class, 643, 28114, 28115).getX())), CallChecker.isCalled(v2, Vector3D.class, 643, 28126, 28127).getZ()) };
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
                                if (order == (RotationOrder.ZYX)) {
                                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 653, 28504, 28542);
                                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 654, 28550, 28595);
                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 655, 28608, 28609)) {
                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 655, 28639, 28640)) {
                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 655, 28608, 28609);
                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 655, 28639, 28640);
                                            if (((CallChecker.isCalled(v2, Vector3D.class, 655, 28608, 28609).getX()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 655, 28639, 28640).getX()) > 0.9999999999)) {
                                                throw new CardanEulerSingularityException(true);
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(v1, Vector3D.class, 659, 28784, 28785)) {
                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 659, 28795, 28796)) {
                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 660, 28829, 28830)) {
                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 661, 28864, 28865)) {
                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 661, 28875, 28876)) {
                                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 659, 28784, 28785);
                                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 659, 28795, 28796);
                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 660, 28829, 28830);
                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 661, 28864, 28865);
                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 661, 28875, 28876);
                                                        return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 659, 28784, 28785).getY(), CallChecker.isCalled(v1, Vector3D.class, 659, 28795, 28796).getX()) , -(FastMath.asin(CallChecker.isCalled(v2, Vector3D.class, 660, 28829, 28830).getX())) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 661, 28864, 28865).getY(), CallChecker.isCalled(v2, Vector3D.class, 661, 28875, 28876).getZ()) };
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
                                    if (order == (RotationOrder.XYX)) {
                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 671, 29249, 29287);
                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 672, 29295, 29340);
                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 673, 29353, 29354)) {
                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 673, 29384, 29385)) {
                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 673, 29353, 29354);
                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 673, 29384, 29385);
                                                if (((CallChecker.isCalled(v2, Vector3D.class, 673, 29353, 29354).getX()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 673, 29384, 29385).getX()) > 0.9999999999)) {
                                                    throw new CardanEulerSingularityException(false);
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 677, 29530, 29531)) {
                                            if (CallChecker.beforeDeref(v1, Vector3D.class, 677, 29542, 29543)) {
                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 678, 29576, 29577)) {
                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 679, 29611, 29612)) {
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 679, 29622, 29623)) {
                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 677, 29530, 29531);
                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 677, 29542, 29543);
                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 678, 29576, 29577);
                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 679, 29611, 29612);
                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 679, 29622, 29623);
                                                            return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 677, 29530, 29531).getY(), (-(CallChecker.isCalled(v1, Vector3D.class, 677, 29542, 29543).getZ()))) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 678, 29576, 29577).getX()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 679, 29611, 29612).getY(), CallChecker.isCalled(v2, Vector3D.class, 679, 29622, 29623).getZ()) };
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
                                        if (order == (RotationOrder.XZX)) {
                                            Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_I), "v1", 689, 29982, 30020);
                                            Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_I), "v2", 690, 30028, 30073);
                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 691, 30086, 30087)) {
                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 691, 30117, 30118)) {
                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 691, 30086, 30087);
                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 691, 30117, 30118);
                                                    if (((CallChecker.isCalled(v2, Vector3D.class, 691, 30086, 30087).getX()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 691, 30117, 30118).getX()) > 0.9999999999)) {
                                                        throw new CardanEulerSingularityException(false);
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                            if (CallChecker.beforeDeref(v1, Vector3D.class, 695, 30263, 30264)) {
                                                if (CallChecker.beforeDeref(v1, Vector3D.class, 695, 30274, 30275)) {
                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 696, 30308, 30309)) {
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 697, 30343, 30344)) {
                                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 697, 30355, 30356)) {
                                                                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 695, 30263, 30264);
                                                                v1 = CallChecker.beforeCalled(v1, Vector3D.class, 695, 30274, 30275);
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 696, 30308, 30309);
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 697, 30343, 30344);
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 697, 30355, 30356);
                                                                return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 695, 30263, 30264).getZ(), CallChecker.isCalled(v1, Vector3D.class, 695, 30274, 30275).getY()) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 696, 30308, 30309).getX()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 697, 30343, 30344).getZ(), (-(CallChecker.isCalled(v2, Vector3D.class, 697, 30355, 30356).getY()))) };
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
                                            if (order == (RotationOrder.YXY)) {
                                                Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 707, 30723, 30761);
                                                Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 708, 30769, 30814);
                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 709, 30827, 30828)) {
                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 709, 30858, 30859)) {
                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 709, 30827, 30828);
                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 709, 30858, 30859);
                                                        if (((CallChecker.isCalled(v2, Vector3D.class, 709, 30827, 30828).getY()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 709, 30858, 30859).getY()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(v1, Vector3D.class, 713, 31004, 31005)) {
                                                    if (CallChecker.beforeDeref(v1, Vector3D.class, 713, 31015, 31016)) {
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 714, 31049, 31050)) {
                                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 715, 31084, 31085)) {
                                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 715, 31096, 31097)) {
                                                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 713, 31004, 31005);
                                                                    v1 = CallChecker.beforeCalled(v1, Vector3D.class, 713, 31015, 31016);
                                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 714, 31049, 31050);
                                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 715, 31084, 31085);
                                                                    v2 = CallChecker.beforeCalled(v2, Vector3D.class, 715, 31096, 31097);
                                                                    return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 713, 31004, 31005).getX(), CallChecker.isCalled(v1, Vector3D.class, 713, 31015, 31016).getZ()) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 714, 31049, 31050).getY()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 715, 31084, 31085).getX(), (-(CallChecker.isCalled(v2, Vector3D.class, 715, 31096, 31097).getZ()))) };
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
                                                if (order == (RotationOrder.YZY)) {
                                                    Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_J), "v1", 725, 31464, 31502);
                                                    Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_J), "v2", 726, 31510, 31555);
                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 727, 31568, 31569)) {
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 727, 31599, 31600)) {
                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 727, 31568, 31569);
                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 727, 31599, 31600);
                                                            if (((CallChecker.isCalled(v2, Vector3D.class, 727, 31568, 31569).getY()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 727, 31599, 31600).getY()) > 0.9999999999)) {
                                                                throw new CardanEulerSingularityException(false);
                                                            }
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                    if (CallChecker.beforeDeref(v1, Vector3D.class, 731, 31745, 31746)) {
                                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 731, 31757, 31758)) {
                                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 732, 31791, 31792)) {
                                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 733, 31826, 31827)) {
                                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 733, 31837, 31838)) {
                                                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 731, 31745, 31746);
                                                                        v1 = CallChecker.beforeCalled(v1, Vector3D.class, 731, 31757, 31758);
                                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 732, 31791, 31792);
                                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 733, 31826, 31827);
                                                                        v2 = CallChecker.beforeCalled(v2, Vector3D.class, 733, 31837, 31838);
                                                                        return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 731, 31745, 31746).getZ(), (-(CallChecker.isCalled(v1, Vector3D.class, 731, 31757, 31758).getX()))) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 732, 31791, 31792).getY()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 733, 31826, 31827).getZ(), CallChecker.isCalled(v2, Vector3D.class, 733, 31837, 31838).getX()) };
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
                                                    if (order == (RotationOrder.ZXZ)) {
                                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 743, 32197, 32235);
                                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 744, 32243, 32288);
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 745, 32301, 32302)) {
                                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 745, 32332, 32333)) {
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 745, 32301, 32302);
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 745, 32332, 32333);
                                                                if (((CallChecker.isCalled(v2, Vector3D.class, 745, 32301, 32302).getZ()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 745, 32332, 32333).getZ()) > 0.9999999999)) {
                                                                    throw new CardanEulerSingularityException(false);
                                                                }
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 749, 32478, 32479)) {
                                                            if (CallChecker.beforeDeref(v1, Vector3D.class, 749, 32490, 32491)) {
                                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 750, 32524, 32525)) {
                                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 751, 32559, 32560)) {
                                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 751, 32570, 32571)) {
                                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 749, 32478, 32479);
                                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 749, 32490, 32491);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 750, 32524, 32525);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 751, 32559, 32560);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 751, 32570, 32571);
                                                                            return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 749, 32478, 32479).getX(), (-(CallChecker.isCalled(v1, Vector3D.class, 749, 32490, 32491).getY()))) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 750, 32524, 32525).getZ()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 751, 32559, 32560).getX(), CallChecker.isCalled(v2, Vector3D.class, 751, 32570, 32571).getY()) };
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
                                                        
                                                    }else {
                                                        Vector3D v1 = CallChecker.varInit(applyTo(Vector3D.PLUS_K), "v1", 761, 32939, 32977);
                                                        Vector3D v2 = CallChecker.varInit(applyInverseTo(Vector3D.PLUS_K), "v2", 762, 32985, 33030);
                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 763, 33043, 33044)) {
                                                            if (CallChecker.beforeDeref(v2, Vector3D.class, 763, 33074, 33075)) {
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 763, 33043, 33044);
                                                                v2 = CallChecker.beforeCalled(v2, Vector3D.class, 763, 33074, 33075);
                                                                if (((CallChecker.isCalled(v2, Vector3D.class, 763, 33043, 33044).getZ()) < (-0.9999999999)) || ((CallChecker.isCalled(v2, Vector3D.class, 763, 33074, 33075).getZ()) > 0.9999999999)) {
                                                                    throw new CardanEulerSingularityException(false);
                                                                }
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 767, 33220, 33221)) {
                                                            if (CallChecker.beforeDeref(v1, Vector3D.class, 767, 33231, 33232)) {
                                                                if (CallChecker.beforeDeref(v2, Vector3D.class, 768, 33265, 33266)) {
                                                                    if (CallChecker.beforeDeref(v2, Vector3D.class, 769, 33300, 33301)) {
                                                                        if (CallChecker.beforeDeref(v2, Vector3D.class, 769, 33312, 33313)) {
                                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 767, 33220, 33221);
                                                                            v1 = CallChecker.beforeCalled(v1, Vector3D.class, 767, 33231, 33232);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 768, 33265, 33266);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 769, 33300, 33301);
                                                                            v2 = CallChecker.beforeCalled(v2, Vector3D.class, 769, 33312, 33313);
                                                                            return new double[]{ FastMath.atan2(CallChecker.isCalled(v1, Vector3D.class, 767, 33220, 33221).getY(), CallChecker.isCalled(v1, Vector3D.class, 767, 33231, 33232).getX()) , FastMath.acos(CallChecker.isCalled(v2, Vector3D.class, 768, 33265, 33266).getZ()) , FastMath.atan2(CallChecker.isCalled(v2, Vector3D.class, 769, 33300, 33301).getY(), (-(CallChecker.isCalled(v2, Vector3D.class, 769, 33312, 33313).getX()))) };
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
                                                        
                                                    }
                                                
                                            
                                        
                                    
                                
                            
                        
                    
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context273.methodEnd();
        }
    }

    public double[][] getMatrix() {
        MethodContext _bcornu_methode_context274 = new MethodContext(double[][].class, 779, 33347, 34294);
        try {
            CallChecker.varInit(this, "this", 779, 33347, 34294);
            CallChecker.varInit(this.q3, "q3", 779, 33347, 34294);
            CallChecker.varInit(this.q2, "q2", 779, 33347, 34294);
            CallChecker.varInit(this.q1, "q1", 779, 33347, 34294);
            CallChecker.varInit(this.q0, "q0", 779, 33347, 34294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 779, 33347, 34294);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 779, 33347, 34294);
            double q0q0 = CallChecker.varInit(((double) ((this.q0) * (this.q0))), "q0q0", 782, 33515, 33537);
            double q0q1 = CallChecker.varInit(((double) ((this.q0) * (this.q1))), "q0q1", 783, 33543, 33565);
            double q0q2 = CallChecker.varInit(((double) ((this.q0) * (this.q2))), "q0q2", 784, 33571, 33593);
            double q0q3 = CallChecker.varInit(((double) ((this.q0) * (this.q3))), "q0q3", 785, 33599, 33621);
            double q1q1 = CallChecker.varInit(((double) ((this.q1) * (this.q1))), "q1q1", 786, 33627, 33649);
            double q1q2 = CallChecker.varInit(((double) ((this.q1) * (this.q2))), "q1q2", 787, 33655, 33677);
            double q1q3 = CallChecker.varInit(((double) ((this.q1) * (this.q3))), "q1q3", 788, 33683, 33705);
            double q2q2 = CallChecker.varInit(((double) ((this.q2) * (this.q2))), "q2q2", 789, 33711, 33733);
            double q2q3 = CallChecker.varInit(((double) ((this.q2) * (this.q3))), "q2q3", 790, 33739, 33761);
            double q3q3 = CallChecker.varInit(((double) ((this.q3) * (this.q3))), "q3q3", 791, 33767, 33789);
            double[][] m = CallChecker.varInit(new double[3][], "m", 794, 33821, 33851);
            if (CallChecker.beforeDeref(m, double[][].class, 795, 33857, 33857)) {
                m = CallChecker.beforeCalled(m, double[][].class, 795, 33857, 33857);
                CallChecker.isCalled(m, double[][].class, 795, 33857, 33857)[0] = new double[3];
                CallChecker.varAssign(CallChecker.isCalled(m, double[][].class, 795, 33857, 33857)[0], "CallChecker.isCalled(m, double[][].class, 795, 33857, 33857)[0]", 795, 33857, 33877);
            }
            if (CallChecker.beforeDeref(m, double[][].class, 796, 33883, 33883)) {
                m = CallChecker.beforeCalled(m, double[][].class, 796, 33883, 33883);
                CallChecker.isCalled(m, double[][].class, 796, 33883, 33883)[1] = new double[3];
                CallChecker.varAssign(CallChecker.isCalled(m, double[][].class, 796, 33883, 33883)[1], "CallChecker.isCalled(m, double[][].class, 796, 33883, 33883)[1]", 796, 33883, 33903);
            }
            if (CallChecker.beforeDeref(m, double[][].class, 797, 33909, 33909)) {
                m = CallChecker.beforeCalled(m, double[][].class, 797, 33909, 33909);
                CallChecker.isCalled(m, double[][].class, 797, 33909, 33909)[2] = new double[3];
                CallChecker.varAssign(CallChecker.isCalled(m, double[][].class, 797, 33909, 33909)[2], "CallChecker.isCalled(m, double[][].class, 797, 33909, 33909)[2]", 797, 33909, 33929);
            }
            if (CallChecker.beforeDeref(m, double[][].class, 799, 33936, 33936)) {
                m = CallChecker.beforeCalled(m, double[][].class, 799, 33936, 33936);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0], double[].class, 799, 33936, 33940)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 799, 33936, 33936);
                    CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0], double[].class, 799, 33936, 33940);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0], double[].class, 799, 33936, 33940)[0] = (2.0 * (q0q0 + q1q1)) - 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0], double[].class, 799, 33936, 33940)[0], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 799, 33936, 33936)[0], double[].class, 799, 33936, 33940)[0]", 799, 33936, 33972);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 800, 33978, 33978)) {
                m = CallChecker.beforeCalled(m, double[][].class, 800, 33978, 33978);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1], double[].class, 800, 33978, 33982)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 800, 33978, 33978);
                    CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1], double[].class, 800, 33978, 33982);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1], double[].class, 800, 33978, 33982)[0] = 2.0 * (q1q2 - q0q3);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1], double[].class, 800, 33978, 33982)[0], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 800, 33978, 33978)[1], double[].class, 800, 33978, 33982)[0]", 800, 33978, 34008);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 801, 34014, 34014)) {
                m = CallChecker.beforeCalled(m, double[][].class, 801, 34014, 34014);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2], double[].class, 801, 34014, 34018)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 801, 34014, 34014);
                    CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2], double[].class, 801, 34014, 34018);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2], double[].class, 801, 34014, 34018)[0] = 2.0 * (q1q3 + q0q2);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2], double[].class, 801, 34014, 34018)[0], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 801, 34014, 34014)[2], double[].class, 801, 34014, 34018)[0]", 801, 34014, 34044);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 803, 34051, 34051)) {
                m = CallChecker.beforeCalled(m, double[][].class, 803, 34051, 34051);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0], double[].class, 803, 34051, 34055)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 803, 34051, 34051);
                    CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0], double[].class, 803, 34051, 34055);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0], double[].class, 803, 34051, 34055)[1] = 2.0 * (q1q2 + q0q3);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0], double[].class, 803, 34051, 34055)[1], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 803, 34051, 34051)[0], double[].class, 803, 34051, 34055)[1]", 803, 34051, 34081);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 804, 34087, 34087)) {
                m = CallChecker.beforeCalled(m, double[][].class, 804, 34087, 34087);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1], double[].class, 804, 34087, 34091)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 804, 34087, 34087);
                    CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1], double[].class, 804, 34087, 34091);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1], double[].class, 804, 34087, 34091)[1] = (2.0 * (q0q0 + q2q2)) - 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1], double[].class, 804, 34087, 34091)[1], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 804, 34087, 34087)[1], double[].class, 804, 34087, 34091)[1]", 804, 34087, 34123);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 805, 34129, 34129)) {
                m = CallChecker.beforeCalled(m, double[][].class, 805, 34129, 34129);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2], double[].class, 805, 34129, 34133)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 805, 34129, 34129);
                    CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2], double[].class, 805, 34129, 34133);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2], double[].class, 805, 34129, 34133)[1] = 2.0 * (q2q3 - q0q1);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2], double[].class, 805, 34129, 34133)[1], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 805, 34129, 34129)[2], double[].class, 805, 34129, 34133)[1]", 805, 34129, 34159);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 807, 34166, 34166)) {
                m = CallChecker.beforeCalled(m, double[][].class, 807, 34166, 34166);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0], double[].class, 807, 34166, 34170)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 807, 34166, 34166);
                    CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0], double[].class, 807, 34166, 34170);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0], double[].class, 807, 34166, 34170)[2] = 2.0 * (q1q3 - q0q2);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0], double[].class, 807, 34166, 34170)[2], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 807, 34166, 34166)[0], double[].class, 807, 34166, 34170)[2]", 807, 34166, 34196);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 808, 34202, 34202)) {
                m = CallChecker.beforeCalled(m, double[][].class, 808, 34202, 34202);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1], double[].class, 808, 34202, 34206)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 808, 34202, 34202);
                    CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1], double[].class, 808, 34202, 34206);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1], double[].class, 808, 34202, 34206)[2] = 2.0 * (q2q3 + q0q1);
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1], double[].class, 808, 34202, 34206)[2], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 808, 34202, 34202)[1], double[].class, 808, 34202, 34206)[2]", 808, 34202, 34232);
                }
            }
            if (CallChecker.beforeDeref(m, double[][].class, 809, 34238, 34238)) {
                m = CallChecker.beforeCalled(m, double[][].class, 809, 34238, 34238);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2], double[].class, 809, 34238, 34242)) {
                    m = CallChecker.beforeCalled(m, double[][].class, 809, 34238, 34238);
                    CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2] = CallChecker.beforeCalled(CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2], double[].class, 809, 34238, 34242);
                    CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2], double[].class, 809, 34238, 34242)[2] = (2.0 * (q0q0 + q3q3)) - 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2], double[].class, 809, 34238, 34242)[2], "CallChecker.isCalled(CallChecker.isCalled(m, double[][].class, 809, 34238, 34238)[2], double[].class, 809, 34238, 34242)[2]", 809, 34238, 34274);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context274.methodEnd();
        }
    }

    public Vector3D applyTo(Vector3D u) {
        MethodContext _bcornu_methode_context275 = new MethodContext(Vector3D.class, 819, 34299, 34850);
        try {
            CallChecker.varInit(this, "this", 819, 34299, 34850);
            CallChecker.varInit(u, "u", 819, 34299, 34850);
            CallChecker.varInit(this.q3, "q3", 819, 34299, 34850);
            CallChecker.varInit(this.q2, "q2", 819, 34299, 34850);
            CallChecker.varInit(this.q1, "q1", 819, 34299, 34850);
            CallChecker.varInit(this.q0, "q0", 819, 34299, 34850);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 819, 34299, 34850);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 819, 34299, 34850);
            double x = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 821, 34509, 34509)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 821, 34509, 34509);
                x = CallChecker.isCalled(u, Vector3D.class, 821, 34509, 34509).getX();
                CallChecker.varAssign(x, "x", 821, 34509, 34509);
            }
            double y = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 822, 34534, 34534)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 822, 34534, 34534);
                y = CallChecker.isCalled(u, Vector3D.class, 822, 34534, 34534).getY();
                CallChecker.varAssign(y, "y", 822, 34534, 34534);
            }
            double z = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 823, 34559, 34559)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 823, 34559, 34559);
                z = CallChecker.isCalled(u, Vector3D.class, 823, 34559, 34559).getZ();
                CallChecker.varAssign(z, "z", 823, 34559, 34559);
            }
            double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 825, 34574, 34609);
            return new Vector3D(((2 * (((q0) * ((x * (q0)) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x), ((2 * (((q0) * ((y * (q0)) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y), ((2 * (((q0) * ((z * (q0)) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context275.methodEnd();
        }
    }

    public void applyTo(final double[] in, final double[] out) {
        MethodContext _bcornu_methode_context276 = new MethodContext(void.class, 838, 34855, 35499);
        try {
            CallChecker.varInit(this, "this", 838, 34855, 35499);
            CallChecker.varInit(out, "out", 838, 34855, 35499);
            CallChecker.varInit(in, "in", 838, 34855, 35499);
            CallChecker.varInit(this.q3, "q3", 838, 34855, 35499);
            CallChecker.varInit(this.q2, "q2", 838, 34855, 35499);
            CallChecker.varInit(this.q1, "q1", 838, 34855, 35499);
            CallChecker.varInit(this.q0, "q0", 838, 34855, 35499);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 838, 34855, 35499);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 838, 34855, 35499);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 840, 35171, 35172)[0])), "x", 840, 35154, 35176);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 841, 35201, 35202)[1])), "y", 841, 35184, 35206);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 842, 35231, 35232)[2])), "z", 842, 35214, 35236);
            final double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 844, 35245, 35286);
            if (CallChecker.beforeDeref(out, double[].class, 846, 35295, 35297)) {
                CallChecker.isCalled(out, double[].class, 846, 35295, 35297)[0] = (2 * (((q0) * ((x * (q0)) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 846, 35295, 35297)[0], "CallChecker.isCalled(out, double[].class, 846, 35295, 35297)[0]", 846, 35295, 35356);
            }
            if (CallChecker.beforeDeref(out, double[].class, 847, 35364, 35366)) {
                CallChecker.isCalled(out, double[].class, 847, 35364, 35366)[1] = (2 * (((q0) * ((y * (q0)) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 847, 35364, 35366)[1], "CallChecker.isCalled(out, double[].class, 847, 35364, 35366)[1]", 847, 35364, 35425);
            }
            if (CallChecker.beforeDeref(out, double[].class, 848, 35433, 35435)) {
                CallChecker.isCalled(out, double[].class, 848, 35433, 35435)[2] = (2 * (((q0) * ((z * (q0)) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 848, 35433, 35435)[2], "CallChecker.isCalled(out, double[].class, 848, 35433, 35435)[2]", 848, 35433, 35494);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context276.methodEnd();
        }
    }

    public Vector3D applyInverseTo(Vector3D u) {
        MethodContext _bcornu_methode_context277 = new MethodContext(Vector3D.class, 856, 35504, 36120);
        try {
            CallChecker.varInit(this, "this", 856, 35504, 36120);
            CallChecker.varInit(u, "u", 856, 35504, 36120);
            CallChecker.varInit(this.q3, "q3", 856, 35504, 36120);
            CallChecker.varInit(this.q2, "q2", 856, 35504, 36120);
            CallChecker.varInit(this.q1, "q1", 856, 35504, 36120);
            CallChecker.varInit(this.q0, "q0", 856, 35504, 36120);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 856, 35504, 36120);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 856, 35504, 36120);
            double x = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 858, 35758, 35758)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 858, 35758, 35758);
                x = CallChecker.isCalled(u, Vector3D.class, 858, 35758, 35758).getX();
                CallChecker.varAssign(x, "x", 858, 35758, 35758);
            }
            double y = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 859, 35783, 35783)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 859, 35783, 35783);
                y = CallChecker.isCalled(u, Vector3D.class, 859, 35783, 35783).getY();
                CallChecker.varAssign(y, "y", 859, 35783, 35783);
            }
            double z = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(u, Vector3D.class, 860, 35808, 35808)) {
                u = CallChecker.beforeCalled(u, Vector3D.class, 860, 35808, 35808);
                z = CallChecker.isCalled(u, Vector3D.class, 860, 35808, 35808).getZ();
                CallChecker.varAssign(z, "z", 860, 35808, 35808);
            }
            double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 862, 35823, 35858);
            double m0 = CallChecker.varInit(((double) (-(this.q0))), "m0", 863, 35864, 35879);
            return new Vector3D(((2 * ((m0 * ((x * m0) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x), ((2 * ((m0 * ((y * m0) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y), ((2 * ((m0 * ((z * m0) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context277.methodEnd();
        }
    }

    public void applyInverseTo(final double[] in, final double[] out) {
        MethodContext _bcornu_methode_context278 = new MethodContext(void.class, 876, 36125, 36820);
        try {
            CallChecker.varInit(this, "this", 876, 36125, 36820);
            CallChecker.varInit(out, "out", 876, 36125, 36820);
            CallChecker.varInit(in, "in", 876, 36125, 36820);
            CallChecker.varInit(this.q3, "q3", 876, 36125, 36820);
            CallChecker.varInit(this.q2, "q2", 876, 36125, 36820);
            CallChecker.varInit(this.q1, "q1", 876, 36125, 36820);
            CallChecker.varInit(this.q0, "q0", 876, 36125, 36820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 876, 36125, 36820);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 876, 36125, 36820);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 878, 36463, 36464)[0])), "x", 878, 36446, 36468);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 879, 36493, 36494)[1])), "y", 879, 36476, 36498);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 880, 36523, 36524)[2])), "z", 880, 36506, 36528);
            final double s = CallChecker.varInit(((double) ((((this.q1) * x) + ((this.q2) * y)) + ((this.q3) * z))), "s", 882, 36537, 36578);
            final double m0 = CallChecker.varInit(((double) (-(this.q0))), "m0", 883, 36586, 36607);
            if (CallChecker.beforeDeref(out, double[].class, 885, 36616, 36618)) {
                CallChecker.isCalled(out, double[].class, 885, 36616, 36618)[0] = (2 * ((m0 * ((x * m0) - (((q2) * z) - ((q3) * y)))) + (s * (q1)))) - x;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 885, 36616, 36618)[0], "CallChecker.isCalled(out, double[].class, 885, 36616, 36618)[0]", 885, 36616, 36677);
            }
            if (CallChecker.beforeDeref(out, double[].class, 886, 36685, 36687)) {
                CallChecker.isCalled(out, double[].class, 886, 36685, 36687)[1] = (2 * ((m0 * ((y * m0) - (((q3) * x) - ((q1) * z)))) + (s * (q2)))) - y;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 886, 36685, 36687)[1], "CallChecker.isCalled(out, double[].class, 886, 36685, 36687)[1]", 886, 36685, 36746);
            }
            if (CallChecker.beforeDeref(out, double[].class, 887, 36754, 36756)) {
                CallChecker.isCalled(out, double[].class, 887, 36754, 36756)[2] = (2 * ((m0 * ((z * m0) - (((q1) * y) - ((q2) * x)))) + (s * (q3)))) - z;
                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 887, 36754, 36756)[2], "CallChecker.isCalled(out, double[].class, 887, 36754, 36756)[2]", 887, 36754, 36815);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context278.methodEnd();
        }
    }

    public Rotation applyTo(Rotation r) {
        MethodContext _bcornu_methode_context279 = new MethodContext(Rotation.class, 900, 36825, 37681);
        try {
            CallChecker.varInit(this, "this", 900, 36825, 37681);
            CallChecker.varInit(r, "r", 900, 36825, 37681);
            CallChecker.varInit(this.q3, "q3", 900, 36825, 37681);
            CallChecker.varInit(this.q2, "q2", 900, 36825, 37681);
            CallChecker.varInit(this.q1, "q1", 900, 36825, 37681);
            CallChecker.varInit(this.q0, "q0", 900, 36825, 37681);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 900, 36825, 37681);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 900, 36825, 37681);
            r = CallChecker.beforeCalled(r, Rotation.class, 901, 37379, 37379);
            r = CallChecker.beforeCalled(r, Rotation.class, 901, 37392, 37392);
            r = CallChecker.beforeCalled(r, Rotation.class, 901, 37404, 37404);
            r = CallChecker.beforeCalled(r, Rotation.class, 901, 37416, 37416);
            r = CallChecker.beforeCalled(r, Rotation.class, 902, 37452, 37452);
            r = CallChecker.beforeCalled(r, Rotation.class, 902, 37464, 37464);
            r = CallChecker.beforeCalled(r, Rotation.class, 902, 37477, 37477);
            r = CallChecker.beforeCalled(r, Rotation.class, 902, 37489, 37489);
            r = CallChecker.beforeCalled(r, Rotation.class, 903, 37525, 37525);
            r = CallChecker.beforeCalled(r, Rotation.class, 903, 37537, 37537);
            r = CallChecker.beforeCalled(r, Rotation.class, 903, 37550, 37550);
            r = CallChecker.beforeCalled(r, Rotation.class, 903, 37562, 37562);
            r = CallChecker.beforeCalled(r, Rotation.class, 904, 37598, 37598);
            r = CallChecker.beforeCalled(r, Rotation.class, 904, 37610, 37610);
            r = CallChecker.beforeCalled(r, Rotation.class, 904, 37623, 37623);
            r = CallChecker.beforeCalled(r, Rotation.class, 904, 37635, 37635);
            return new Rotation((((CallChecker.isCalled(r, Rotation.class, 901, 37379, 37379).q0) * (q0)) - ((((CallChecker.isCalled(r, Rotation.class, 901, 37392, 37392).q1) * (q1)) + ((CallChecker.isCalled(r, Rotation.class, 901, 37404, 37404).q2) * (q2))) + ((CallChecker.isCalled(r, Rotation.class, 901, 37416, 37416).q3) * (q3)))), ((((CallChecker.isCalled(r, Rotation.class, 902, 37452, 37452).q1) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 902, 37464, 37464).q0) * (q1))) + (((CallChecker.isCalled(r, Rotation.class, 902, 37477, 37477).q2) * (q3)) - ((CallChecker.isCalled(r, Rotation.class, 902, 37489, 37489).q3) * (q2)))), ((((CallChecker.isCalled(r, Rotation.class, 903, 37525, 37525).q2) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 903, 37537, 37537).q0) * (q2))) + (((CallChecker.isCalled(r, Rotation.class, 903, 37550, 37550).q3) * (q1)) - ((CallChecker.isCalled(r, Rotation.class, 903, 37562, 37562).q1) * (q3)))), ((((CallChecker.isCalled(r, Rotation.class, 904, 37598, 37598).q3) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 904, 37610, 37610).q0) * (q3))) + (((CallChecker.isCalled(r, Rotation.class, 904, 37623, 37623).q1) * (q2)) - ((CallChecker.isCalled(r, Rotation.class, 904, 37635, 37635).q2) * (q1)))), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Rotation) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context279.methodEnd();
        }
    }

    public Rotation applyInverseTo(Rotation r) {
        MethodContext _bcornu_methode_context280 = new MethodContext(Rotation.class, 919, 37686, 38630);
        try {
            CallChecker.varInit(this, "this", 919, 37686, 38630);
            CallChecker.varInit(r, "r", 919, 37686, 38630);
            CallChecker.varInit(this.q3, "q3", 919, 37686, 38630);
            CallChecker.varInit(this.q2, "q2", 919, 37686, 38630);
            CallChecker.varInit(this.q1, "q1", 919, 37686, 38630);
            CallChecker.varInit(this.q0, "q0", 919, 37686, 38630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 919, 37686, 38630);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 919, 37686, 38630);
            if (CallChecker.beforeDeref(r, Rotation.class, 920, 38325, 38325)) {
                if (CallChecker.beforeDeref(r, Rotation.class, 921, 38399, 38399)) {
                    if (CallChecker.beforeDeref(r, Rotation.class, 922, 38473, 38473)) {
                        if (CallChecker.beforeDeref(r, Rotation.class, 923, 38547, 38547)) {
                            r = CallChecker.beforeCalled(r, Rotation.class, 920, 38325, 38325);
                            r = CallChecker.beforeCalled(r, Rotation.class, 920, 38338, 38338);
                            r = CallChecker.beforeCalled(r, Rotation.class, 920, 38350, 38350);
                            r = CallChecker.beforeCalled(r, Rotation.class, 920, 38362, 38362);
                            r = CallChecker.beforeCalled(r, Rotation.class, 921, 38399, 38399);
                            r = CallChecker.beforeCalled(r, Rotation.class, 921, 38411, 38411);
                            r = CallChecker.beforeCalled(r, Rotation.class, 921, 38424, 38424);
                            r = CallChecker.beforeCalled(r, Rotation.class, 921, 38436, 38436);
                            r = CallChecker.beforeCalled(r, Rotation.class, 922, 38473, 38473);
                            r = CallChecker.beforeCalled(r, Rotation.class, 922, 38485, 38485);
                            r = CallChecker.beforeCalled(r, Rotation.class, 922, 38498, 38498);
                            r = CallChecker.beforeCalled(r, Rotation.class, 922, 38510, 38510);
                            r = CallChecker.beforeCalled(r, Rotation.class, 923, 38547, 38547);
                            r = CallChecker.beforeCalled(r, Rotation.class, 923, 38559, 38559);
                            r = CallChecker.beforeCalled(r, Rotation.class, 923, 38572, 38572);
                            r = CallChecker.beforeCalled(r, Rotation.class, 923, 38584, 38584);
                            return new Rotation((((-(CallChecker.isCalled(r, Rotation.class, 920, 38325, 38325).q0)) * (q0)) - ((((CallChecker.isCalled(r, Rotation.class, 920, 38338, 38338).q1) * (q1)) + ((CallChecker.isCalled(r, Rotation.class, 920, 38350, 38350).q2) * (q2))) + ((CallChecker.isCalled(r, Rotation.class, 920, 38362, 38362).q3) * (q3)))), ((((-(CallChecker.isCalled(r, Rotation.class, 921, 38399, 38399).q1)) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 921, 38411, 38411).q0) * (q1))) + (((CallChecker.isCalled(r, Rotation.class, 921, 38424, 38424).q2) * (q3)) - ((CallChecker.isCalled(r, Rotation.class, 921, 38436, 38436).q3) * (q2)))), ((((-(CallChecker.isCalled(r, Rotation.class, 922, 38473, 38473).q2)) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 922, 38485, 38485).q0) * (q2))) + (((CallChecker.isCalled(r, Rotation.class, 922, 38498, 38498).q3) * (q1)) - ((CallChecker.isCalled(r, Rotation.class, 922, 38510, 38510).q1) * (q3)))), ((((-(CallChecker.isCalled(r, Rotation.class, 923, 38547, 38547).q3)) * (q0)) + ((CallChecker.isCalled(r, Rotation.class, 923, 38559, 38559).q0) * (q3))) + (((CallChecker.isCalled(r, Rotation.class, 923, 38572, 38572).q1) * (q2)) - ((CallChecker.isCalled(r, Rotation.class, 923, 38584, 38584).q2) * (q1)))), false);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Rotation) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context280.methodEnd();
        }
    }

    private double[][] orthogonalizeMatrix(double[][] m, double threshold) throws NotARotationMatrixException {
        MethodContext _bcornu_methode_context281 = new MethodContext(double[][].class, 937, 38635, 42167);
        try {
            CallChecker.varInit(this, "this", 937, 38635, 42167);
            CallChecker.varInit(threshold, "threshold", 937, 38635, 42167);
            CallChecker.varInit(m, "m", 937, 38635, 42167);
            CallChecker.varInit(this.q3, "q3", 937, 38635, 42167);
            CallChecker.varInit(this.q2, "q2", 937, 38635, 42167);
            CallChecker.varInit(this.q1, "q1", 937, 38635, 42167);
            CallChecker.varInit(this.q0, "q0", 937, 38635, 42167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 937, 38635, 42167);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 937, 38635, 42167);
            double[] m0 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(m, double[][].class, 939, 39277, 39277)) {
                m = CallChecker.beforeCalled(m, double[][].class, 939, 39277, 39277);
                m0 = CallChecker.isCalled(m, double[][].class, 939, 39277, 39277)[0];
                CallChecker.varAssign(m0, "m0", 939, 39277, 39277);
            }
            double[] m1 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(m, double[][].class, 940, 39301, 39301)) {
                m = CallChecker.beforeCalled(m, double[][].class, 940, 39301, 39301);
                m1 = CallChecker.isCalled(m, double[][].class, 940, 39301, 39301)[1];
                CallChecker.varAssign(m1, "m1", 940, 39301, 39301);
            }
            double[] m2 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(m, double[][].class, 941, 39325, 39325)) {
                m = CallChecker.beforeCalled(m, double[][].class, 941, 39325, 39325);
                m2 = CallChecker.isCalled(m, double[][].class, 941, 39325, 39325)[2];
                CallChecker.varAssign(m2, "m2", 941, 39325, 39325);
            }
            double x00 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m0, double[].class, 942, 39348, 39349)) {
                m0 = CallChecker.beforeCalled(m0, double[].class, 942, 39348, 39349);
                x00 = CallChecker.isCalled(m0, double[].class, 942, 39348, 39349)[0];
                CallChecker.varAssign(x00, "x00", 942, 39348, 39349);
            }
            double x01 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m0, double[].class, 943, 39372, 39373)) {
                m0 = CallChecker.beforeCalled(m0, double[].class, 943, 39372, 39373);
                x01 = CallChecker.isCalled(m0, double[].class, 943, 39372, 39373)[1];
                CallChecker.varAssign(x01, "x01", 943, 39372, 39373);
            }
            double x02 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m0, double[].class, 944, 39396, 39397)) {
                m0 = CallChecker.beforeCalled(m0, double[].class, 944, 39396, 39397);
                x02 = CallChecker.isCalled(m0, double[].class, 944, 39396, 39397)[2];
                CallChecker.varAssign(x02, "x02", 944, 39396, 39397);
            }
            double x10 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m1, double[].class, 945, 39420, 39421)) {
                m1 = CallChecker.beforeCalled(m1, double[].class, 945, 39420, 39421);
                x10 = CallChecker.isCalled(m1, double[].class, 945, 39420, 39421)[0];
                CallChecker.varAssign(x10, "x10", 945, 39420, 39421);
            }
            double x11 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m1, double[].class, 946, 39444, 39445)) {
                m1 = CallChecker.beforeCalled(m1, double[].class, 946, 39444, 39445);
                x11 = CallChecker.isCalled(m1, double[].class, 946, 39444, 39445)[1];
                CallChecker.varAssign(x11, "x11", 946, 39444, 39445);
            }
            double x12 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m1, double[].class, 947, 39468, 39469)) {
                m1 = CallChecker.beforeCalled(m1, double[].class, 947, 39468, 39469);
                x12 = CallChecker.isCalled(m1, double[].class, 947, 39468, 39469)[2];
                CallChecker.varAssign(x12, "x12", 947, 39468, 39469);
            }
            double x20 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m2, double[].class, 948, 39492, 39493)) {
                m2 = CallChecker.beforeCalled(m2, double[].class, 948, 39492, 39493);
                x20 = CallChecker.isCalled(m2, double[].class, 948, 39492, 39493)[0];
                CallChecker.varAssign(x20, "x20", 948, 39492, 39493);
            }
            double x21 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m2, double[].class, 949, 39516, 39517)) {
                m2 = CallChecker.beforeCalled(m2, double[].class, 949, 39516, 39517);
                x21 = CallChecker.isCalled(m2, double[].class, 949, 39516, 39517)[1];
                CallChecker.varAssign(x21, "x21", 949, 39516, 39517);
            }
            double x22 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(m2, double[].class, 950, 39540, 39541)) {
                m2 = CallChecker.beforeCalled(m2, double[].class, 950, 39540, 39541);
                x22 = CallChecker.isCalled(m2, double[].class, 950, 39540, 39541)[2];
                CallChecker.varAssign(x22, "x22", 950, 39540, 39541);
            }
            double fn = CallChecker.varInit(((double) (0)), "fn", 951, 39551, 39564);
            double fn1 = CallChecker.init(double.class);
            double[][] o = CallChecker.varInit(new double[3][3], "o", 954, 39587, 39618);
            double[] o0 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(o, double[][].class, 955, 39638, 39638)) {
                o = CallChecker.beforeCalled(o, double[][].class, 955, 39638, 39638);
                o0 = CallChecker.isCalled(o, double[][].class, 955, 39638, 39638)[0];
                CallChecker.varAssign(o0, "o0", 955, 39638, 39638);
            }
            double[] o1 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(o, double[][].class, 956, 39662, 39662)) {
                o = CallChecker.beforeCalled(o, double[][].class, 956, 39662, 39662);
                o1 = CallChecker.isCalled(o, double[][].class, 956, 39662, 39662)[1];
                CallChecker.varAssign(o1, "o1", 956, 39662, 39662);
            }
            double[] o2 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(o, double[][].class, 957, 39686, 39686)) {
                o = CallChecker.beforeCalled(o, double[][].class, 957, 39686, 39686);
                o2 = CallChecker.isCalled(o, double[][].class, 957, 39686, 39686)[2];
                CallChecker.varAssign(o2, "o2", 957, 39686, 39686);
            }
            int i = CallChecker.varInit(((int) (0)), "i", 960, 39759, 39768);
            while ((++i) < 11) {
                double mx00 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 964, 39829, 39830)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 964, 39843, 39844)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 964, 39857, 39858)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 964, 39829, 39830);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 964, 39843, 39844);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 964, 39857, 39858);
                            mx00 = (((CallChecker.isCalled(m0, double[].class, 964, 39829, 39830)[0]) * x00) + ((CallChecker.isCalled(m1, double[].class, 964, 39843, 39844)[0]) * x10)) + ((CallChecker.isCalled(m2, double[].class, 964, 39857, 39858)[0]) * x20);
                            CallChecker.varAssign(mx00, "mx00", 964, 39829, 39830);
                        }
                    }
                }
                double mx10 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 965, 39890, 39891)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 965, 39904, 39905)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 965, 39918, 39919)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 965, 39890, 39891);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 965, 39904, 39905);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 965, 39918, 39919);
                            mx10 = (((CallChecker.isCalled(m0, double[].class, 965, 39890, 39891)[1]) * x00) + ((CallChecker.isCalled(m1, double[].class, 965, 39904, 39905)[1]) * x10)) + ((CallChecker.isCalled(m2, double[].class, 965, 39918, 39919)[1]) * x20);
                            CallChecker.varAssign(mx10, "mx10", 965, 39890, 39891);
                        }
                    }
                }
                double mx20 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 966, 39951, 39952)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 966, 39965, 39966)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 966, 39979, 39980)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 966, 39951, 39952);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 966, 39965, 39966);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 966, 39979, 39980);
                            mx20 = (((CallChecker.isCalled(m0, double[].class, 966, 39951, 39952)[2]) * x00) + ((CallChecker.isCalled(m1, double[].class, 966, 39965, 39966)[2]) * x10)) + ((CallChecker.isCalled(m2, double[].class, 966, 39979, 39980)[2]) * x20);
                            CallChecker.varAssign(mx20, "mx20", 966, 39951, 39952);
                        }
                    }
                }
                double mx01 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 967, 40012, 40013)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 967, 40026, 40027)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 967, 40040, 40041)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 967, 40012, 40013);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 967, 40026, 40027);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 967, 40040, 40041);
                            mx01 = (((CallChecker.isCalled(m0, double[].class, 967, 40012, 40013)[0]) * x01) + ((CallChecker.isCalled(m1, double[].class, 967, 40026, 40027)[0]) * x11)) + ((CallChecker.isCalled(m2, double[].class, 967, 40040, 40041)[0]) * x21);
                            CallChecker.varAssign(mx01, "mx01", 967, 40012, 40013);
                        }
                    }
                }
                double mx11 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 968, 40073, 40074)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 968, 40087, 40088)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 968, 40101, 40102)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 968, 40073, 40074);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 968, 40087, 40088);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 968, 40101, 40102);
                            mx11 = (((CallChecker.isCalled(m0, double[].class, 968, 40073, 40074)[1]) * x01) + ((CallChecker.isCalled(m1, double[].class, 968, 40087, 40088)[1]) * x11)) + ((CallChecker.isCalled(m2, double[].class, 968, 40101, 40102)[1]) * x21);
                            CallChecker.varAssign(mx11, "mx11", 968, 40073, 40074);
                        }
                    }
                }
                double mx21 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 969, 40134, 40135)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 969, 40148, 40149)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 969, 40162, 40163)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 969, 40134, 40135);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 969, 40148, 40149);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 969, 40162, 40163);
                            mx21 = (((CallChecker.isCalled(m0, double[].class, 969, 40134, 40135)[2]) * x01) + ((CallChecker.isCalled(m1, double[].class, 969, 40148, 40149)[2]) * x11)) + ((CallChecker.isCalled(m2, double[].class, 969, 40162, 40163)[2]) * x21);
                            CallChecker.varAssign(mx21, "mx21", 969, 40134, 40135);
                        }
                    }
                }
                double mx02 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 970, 40195, 40196)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 970, 40209, 40210)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 970, 40223, 40224)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 970, 40195, 40196);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 970, 40209, 40210);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 970, 40223, 40224);
                            mx02 = (((CallChecker.isCalled(m0, double[].class, 970, 40195, 40196)[0]) * x02) + ((CallChecker.isCalled(m1, double[].class, 970, 40209, 40210)[0]) * x12)) + ((CallChecker.isCalled(m2, double[].class, 970, 40223, 40224)[0]) * x22);
                            CallChecker.varAssign(mx02, "mx02", 970, 40195, 40196);
                        }
                    }
                }
                double mx12 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 971, 40256, 40257)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 971, 40270, 40271)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 971, 40284, 40285)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 971, 40256, 40257);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 971, 40270, 40271);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 971, 40284, 40285);
                            mx12 = (((CallChecker.isCalled(m0, double[].class, 971, 40256, 40257)[1]) * x02) + ((CallChecker.isCalled(m1, double[].class, 971, 40270, 40271)[1]) * x12)) + ((CallChecker.isCalled(m2, double[].class, 971, 40284, 40285)[1]) * x22);
                            CallChecker.varAssign(mx12, "mx12", 971, 40256, 40257);
                        }
                    }
                }
                double mx22 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(m0, double[].class, 972, 40317, 40318)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 972, 40331, 40332)) {
                        if (CallChecker.beforeDeref(m2, double[].class, 972, 40345, 40346)) {
                            m0 = CallChecker.beforeCalled(m0, double[].class, 972, 40317, 40318);
                            m1 = CallChecker.beforeCalled(m1, double[].class, 972, 40331, 40332);
                            m2 = CallChecker.beforeCalled(m2, double[].class, 972, 40345, 40346);
                            mx22 = (((CallChecker.isCalled(m0, double[].class, 972, 40317, 40318)[2]) * x02) + ((CallChecker.isCalled(m1, double[].class, 972, 40331, 40332)[2]) * x12)) + ((CallChecker.isCalled(m2, double[].class, 972, 40345, 40346)[2]) * x22);
                            CallChecker.varAssign(mx22, "mx22", 972, 40317, 40318);
                        }
                    }
                }
                if (CallChecker.beforeDeref(o0, double[].class, 975, 40379, 40380)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 975, 40439, 40440)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 975, 40379, 40380);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 975, 40439, 40440);
                        CallChecker.isCalled(o0, double[].class, 975, 40379, 40380)[0] = x00 - (0.5 * ((((x00 * mx00) + (x01 * mx10)) + (x02 * mx20)) - (CallChecker.isCalled(m0, double[].class, 975, 40439, 40440)[0])));
                        CallChecker.varAssign(CallChecker.isCalled(o0, double[].class, 975, 40379, 40380)[0], "CallChecker.isCalled(o0, double[].class, 975, 40379, 40380)[0]", 975, 40379, 40445);
                    }
                }
                if (CallChecker.beforeDeref(o0, double[].class, 976, 40453, 40454)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 976, 40513, 40514)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 976, 40453, 40454);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 976, 40513, 40514);
                        CallChecker.isCalled(o0, double[].class, 976, 40453, 40454)[1] = x01 - (0.5 * ((((x00 * mx01) + (x01 * mx11)) + (x02 * mx21)) - (CallChecker.isCalled(m0, double[].class, 976, 40513, 40514)[1])));
                        CallChecker.varAssign(CallChecker.isCalled(o0, double[].class, 976, 40453, 40454)[1], "CallChecker.isCalled(o0, double[].class, 976, 40453, 40454)[1]", 976, 40453, 40519);
                    }
                }
                if (CallChecker.beforeDeref(o0, double[].class, 977, 40527, 40528)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 977, 40587, 40588)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 977, 40527, 40528);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 977, 40587, 40588);
                        CallChecker.isCalled(o0, double[].class, 977, 40527, 40528)[2] = x02 - (0.5 * ((((x00 * mx02) + (x01 * mx12)) + (x02 * mx22)) - (CallChecker.isCalled(m0, double[].class, 977, 40587, 40588)[2])));
                        CallChecker.varAssign(CallChecker.isCalled(o0, double[].class, 977, 40527, 40528)[2], "CallChecker.isCalled(o0, double[].class, 977, 40527, 40528)[2]", 977, 40527, 40593);
                    }
                }
                if (CallChecker.beforeDeref(o1, double[].class, 978, 40601, 40602)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 978, 40661, 40662)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 978, 40601, 40602);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 978, 40661, 40662);
                        CallChecker.isCalled(o1, double[].class, 978, 40601, 40602)[0] = x10 - (0.5 * ((((x10 * mx00) + (x11 * mx10)) + (x12 * mx20)) - (CallChecker.isCalled(m1, double[].class, 978, 40661, 40662)[0])));
                        CallChecker.varAssign(CallChecker.isCalled(o1, double[].class, 978, 40601, 40602)[0], "CallChecker.isCalled(o1, double[].class, 978, 40601, 40602)[0]", 978, 40601, 40667);
                    }
                }
                if (CallChecker.beforeDeref(o1, double[].class, 979, 40675, 40676)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 979, 40735, 40736)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 979, 40675, 40676);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 979, 40735, 40736);
                        CallChecker.isCalled(o1, double[].class, 979, 40675, 40676)[1] = x11 - (0.5 * ((((x10 * mx01) + (x11 * mx11)) + (x12 * mx21)) - (CallChecker.isCalled(m1, double[].class, 979, 40735, 40736)[1])));
                        CallChecker.varAssign(CallChecker.isCalled(o1, double[].class, 979, 40675, 40676)[1], "CallChecker.isCalled(o1, double[].class, 979, 40675, 40676)[1]", 979, 40675, 40741);
                    }
                }
                if (CallChecker.beforeDeref(o1, double[].class, 980, 40749, 40750)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 980, 40809, 40810)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 980, 40749, 40750);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 980, 40809, 40810);
                        CallChecker.isCalled(o1, double[].class, 980, 40749, 40750)[2] = x12 - (0.5 * ((((x10 * mx02) + (x11 * mx12)) + (x12 * mx22)) - (CallChecker.isCalled(m1, double[].class, 980, 40809, 40810)[2])));
                        CallChecker.varAssign(CallChecker.isCalled(o1, double[].class, 980, 40749, 40750)[2], "CallChecker.isCalled(o1, double[].class, 980, 40749, 40750)[2]", 980, 40749, 40815);
                    }
                }
                if (CallChecker.beforeDeref(o2, double[].class, 981, 40823, 40824)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 981, 40883, 40884)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 981, 40823, 40824);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 981, 40883, 40884);
                        CallChecker.isCalled(o2, double[].class, 981, 40823, 40824)[0] = x20 - (0.5 * ((((x20 * mx00) + (x21 * mx10)) + (x22 * mx20)) - (CallChecker.isCalled(m2, double[].class, 981, 40883, 40884)[0])));
                        CallChecker.varAssign(CallChecker.isCalled(o2, double[].class, 981, 40823, 40824)[0], "CallChecker.isCalled(o2, double[].class, 981, 40823, 40824)[0]", 981, 40823, 40889);
                    }
                }
                if (CallChecker.beforeDeref(o2, double[].class, 982, 40897, 40898)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 982, 40957, 40958)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 982, 40897, 40898);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 982, 40957, 40958);
                        CallChecker.isCalled(o2, double[].class, 982, 40897, 40898)[1] = x21 - (0.5 * ((((x20 * mx01) + (x21 * mx11)) + (x22 * mx21)) - (CallChecker.isCalled(m2, double[].class, 982, 40957, 40958)[1])));
                        CallChecker.varAssign(CallChecker.isCalled(o2, double[].class, 982, 40897, 40898)[1], "CallChecker.isCalled(o2, double[].class, 982, 40897, 40898)[1]", 982, 40897, 40963);
                    }
                }
                if (CallChecker.beforeDeref(o2, double[].class, 983, 40971, 40972)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 983, 41031, 41032)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 983, 40971, 40972);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 983, 41031, 41032);
                        CallChecker.isCalled(o2, double[].class, 983, 40971, 40972)[2] = x22 - (0.5 * ((((x20 * mx02) + (x21 * mx12)) + (x22 * mx22)) - (CallChecker.isCalled(m2, double[].class, 983, 41031, 41032)[2])));
                        CallChecker.varAssign(CallChecker.isCalled(o2, double[].class, 983, 40971, 40972)[2], "CallChecker.isCalled(o2, double[].class, 983, 40971, 40972)[2]", 983, 40971, 41037);
                    }
                }
                double corr00 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o0, double[].class, 986, 41099, 41100)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 986, 41107, 41108)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 986, 41099, 41100);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 986, 41107, 41108);
                        corr00 = (CallChecker.isCalled(o0, double[].class, 986, 41099, 41100)[0]) - (CallChecker.isCalled(m0, double[].class, 986, 41107, 41108)[0]);
                        CallChecker.varAssign(corr00, "corr00", 986, 41099, 41100);
                    }
                }
                double corr01 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o0, double[].class, 987, 41136, 41137)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 987, 41144, 41145)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 987, 41136, 41137);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 987, 41144, 41145);
                        corr01 = (CallChecker.isCalled(o0, double[].class, 987, 41136, 41137)[1]) - (CallChecker.isCalled(m0, double[].class, 987, 41144, 41145)[1]);
                        CallChecker.varAssign(corr01, "corr01", 987, 41136, 41137);
                    }
                }
                double corr02 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o0, double[].class, 988, 41173, 41174)) {
                    if (CallChecker.beforeDeref(m0, double[].class, 988, 41181, 41182)) {
                        o0 = CallChecker.beforeCalled(o0, double[].class, 988, 41173, 41174);
                        m0 = CallChecker.beforeCalled(m0, double[].class, 988, 41181, 41182);
                        corr02 = (CallChecker.isCalled(o0, double[].class, 988, 41173, 41174)[2]) - (CallChecker.isCalled(m0, double[].class, 988, 41181, 41182)[2]);
                        CallChecker.varAssign(corr02, "corr02", 988, 41173, 41174);
                    }
                }
                double corr10 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o1, double[].class, 989, 41210, 41211)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 989, 41218, 41219)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 989, 41210, 41211);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 989, 41218, 41219);
                        corr10 = (CallChecker.isCalled(o1, double[].class, 989, 41210, 41211)[0]) - (CallChecker.isCalled(m1, double[].class, 989, 41218, 41219)[0]);
                        CallChecker.varAssign(corr10, "corr10", 989, 41210, 41211);
                    }
                }
                double corr11 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o1, double[].class, 990, 41247, 41248)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 990, 41255, 41256)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 990, 41247, 41248);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 990, 41255, 41256);
                        corr11 = (CallChecker.isCalled(o1, double[].class, 990, 41247, 41248)[1]) - (CallChecker.isCalled(m1, double[].class, 990, 41255, 41256)[1]);
                        CallChecker.varAssign(corr11, "corr11", 990, 41247, 41248);
                    }
                }
                double corr12 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o1, double[].class, 991, 41284, 41285)) {
                    if (CallChecker.beforeDeref(m1, double[].class, 991, 41292, 41293)) {
                        o1 = CallChecker.beforeCalled(o1, double[].class, 991, 41284, 41285);
                        m1 = CallChecker.beforeCalled(m1, double[].class, 991, 41292, 41293);
                        corr12 = (CallChecker.isCalled(o1, double[].class, 991, 41284, 41285)[2]) - (CallChecker.isCalled(m1, double[].class, 991, 41292, 41293)[2]);
                        CallChecker.varAssign(corr12, "corr12", 991, 41284, 41285);
                    }
                }
                double corr20 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o2, double[].class, 992, 41321, 41322)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 992, 41329, 41330)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 992, 41321, 41322);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 992, 41329, 41330);
                        corr20 = (CallChecker.isCalled(o2, double[].class, 992, 41321, 41322)[0]) - (CallChecker.isCalled(m2, double[].class, 992, 41329, 41330)[0]);
                        CallChecker.varAssign(corr20, "corr20", 992, 41321, 41322);
                    }
                }
                double corr21 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o2, double[].class, 993, 41358, 41359)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 993, 41366, 41367)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 993, 41358, 41359);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 993, 41366, 41367);
                        corr21 = (CallChecker.isCalled(o2, double[].class, 993, 41358, 41359)[1]) - (CallChecker.isCalled(m2, double[].class, 993, 41366, 41367)[1]);
                        CallChecker.varAssign(corr21, "corr21", 993, 41358, 41359);
                    }
                }
                double corr22 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(o2, double[].class, 994, 41395, 41396)) {
                    if (CallChecker.beforeDeref(m2, double[].class, 994, 41403, 41404)) {
                        o2 = CallChecker.beforeCalled(o2, double[].class, 994, 41395, 41396);
                        m2 = CallChecker.beforeCalled(m2, double[].class, 994, 41403, 41404);
                        corr22 = (CallChecker.isCalled(o2, double[].class, 994, 41395, 41396)[2]) - (CallChecker.isCalled(m2, double[].class, 994, 41403, 41404)[2]);
                        CallChecker.varAssign(corr22, "corr22", 994, 41395, 41396);
                    }
                }
                fn1 = ((((((((corr00 * corr00) + (corr01 * corr01)) + (corr02 * corr02)) + (corr10 * corr10)) + (corr11 * corr11)) + (corr12 * corr12)) + (corr20 * corr20)) + (corr21 * corr21)) + (corr22 * corr22);
                CallChecker.varAssign(fn1, "fn1", 997, 41459, 41648);
                if ((FastMath.abs((fn1 - fn))) <= threshold) {
                    return o;
                }
                if (CallChecker.beforeDeref(o0, double[].class, 1007, 41799, 41800)) {
                    o0 = CallChecker.beforeCalled(o0, double[].class, 1007, 41799, 41800);
                    x00 = CallChecker.isCalled(o0, double[].class, 1007, 41799, 41800)[0];
                    CallChecker.varAssign(x00, "x00", 1007, 41793, 41804);
                }
                if (CallChecker.beforeDeref(o0, double[].class, 1008, 41818, 41819)) {
                    o0 = CallChecker.beforeCalled(o0, double[].class, 1008, 41818, 41819);
                    x01 = CallChecker.isCalled(o0, double[].class, 1008, 41818, 41819)[1];
                    CallChecker.varAssign(x01, "x01", 1008, 41812, 41823);
                }
                if (CallChecker.beforeDeref(o0, double[].class, 1009, 41837, 41838)) {
                    o0 = CallChecker.beforeCalled(o0, double[].class, 1009, 41837, 41838);
                    x02 = CallChecker.isCalled(o0, double[].class, 1009, 41837, 41838)[2];
                    CallChecker.varAssign(x02, "x02", 1009, 41831, 41842);
                }
                if (CallChecker.beforeDeref(o1, double[].class, 1010, 41856, 41857)) {
                    o1 = CallChecker.beforeCalled(o1, double[].class, 1010, 41856, 41857);
                    x10 = CallChecker.isCalled(o1, double[].class, 1010, 41856, 41857)[0];
                    CallChecker.varAssign(x10, "x10", 1010, 41850, 41861);
                }
                if (CallChecker.beforeDeref(o1, double[].class, 1011, 41875, 41876)) {
                    o1 = CallChecker.beforeCalled(o1, double[].class, 1011, 41875, 41876);
                    x11 = CallChecker.isCalled(o1, double[].class, 1011, 41875, 41876)[1];
                    CallChecker.varAssign(x11, "x11", 1011, 41869, 41880);
                }
                if (CallChecker.beforeDeref(o1, double[].class, 1012, 41894, 41895)) {
                    o1 = CallChecker.beforeCalled(o1, double[].class, 1012, 41894, 41895);
                    x12 = CallChecker.isCalled(o1, double[].class, 1012, 41894, 41895)[2];
                    CallChecker.varAssign(x12, "x12", 1012, 41888, 41899);
                }
                if (CallChecker.beforeDeref(o2, double[].class, 1013, 41913, 41914)) {
                    o2 = CallChecker.beforeCalled(o2, double[].class, 1013, 41913, 41914);
                    x20 = CallChecker.isCalled(o2, double[].class, 1013, 41913, 41914)[0];
                    CallChecker.varAssign(x20, "x20", 1013, 41907, 41918);
                }
                if (CallChecker.beforeDeref(o2, double[].class, 1014, 41932, 41933)) {
                    o2 = CallChecker.beforeCalled(o2, double[].class, 1014, 41932, 41933);
                    x21 = CallChecker.isCalled(o2, double[].class, 1014, 41932, 41933)[1];
                    CallChecker.varAssign(x21, "x21", 1014, 41926, 41937);
                }
                if (CallChecker.beforeDeref(o2, double[].class, 1015, 41951, 41952)) {
                    o2 = CallChecker.beforeCalled(o2, double[].class, 1015, 41951, 41952);
                    x22 = CallChecker.isCalled(o2, double[].class, 1015, 41951, 41952)[2];
                    CallChecker.varAssign(x22, "x22", 1015, 41945, 41956);
                }
                fn = fn1;
                CallChecker.varAssign(fn, "fn", 1016, 41964, 41973);
            } 
            throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, (i - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context281.methodEnd();
        }
    }

    public static double distance(Rotation r1, Rotation r2) {
        MethodContext _bcornu_methode_context282 = new MethodContext(double.class, 1050, 42172, 43627);
        try {
            CallChecker.varInit(r2, "r2", 1050, 42172, 43627);
            CallChecker.varInit(r1, "r1", 1050, 42172, 43627);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.serialVersionUID", 1050, 42172, 43627);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.geometry.euclidean.threed.Rotation.IDENTITY", 1050, 42172, 43627);
            if (CallChecker.beforeDeref(r1, Rotation.class, 1051, 43591, 43592)) {
                r1 = CallChecker.beforeCalled(r1, Rotation.class, 1051, 43591, 43592);
                final Rotation npe_invocation_var32 = CallChecker.isCalled(r1, Rotation.class, 1051, 43591, 43592).applyInverseTo(r2);
                if (CallChecker.beforeDeref(npe_invocation_var32, Rotation.class, 1051, 43591, 43611)) {
                    return CallChecker.isCalled(npe_invocation_var32, Rotation.class, 1051, 43591, 43611).getAngle();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }
}

