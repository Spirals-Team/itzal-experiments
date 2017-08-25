package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
        ConstructorContext _bcornu_methode_context447 = new ConstructorContext(FieldRotation.class, 76, 2120, 3866);
        try {
            if (needsNormalization) {
                final T inv = CallChecker.varInit(q0.multiply(q0).add(q1.multiply(q1)).add(q2.multiply(q2)).add(q3.multiply(q3)).sqrt().reciprocal(), "inv", 80, 3393, 3568);
                this.q0 = inv.multiply(q0);
                CallChecker.varAssign(this.q0, "this.q0", 82, 3582, 3608);
                this.q1 = inv.multiply(q1);
                CallChecker.varAssign(this.q1, "this.q1", 83, 3622, 3648);
                this.q2 = inv.multiply(q2);
                CallChecker.varAssign(this.q2, "this.q2", 84, 3662, 3688);
                this.q3 = inv.multiply(q3);
                CallChecker.varAssign(this.q3, "this.q3", 85, 3702, 3728);
            }else {
                this.q0 = q0;
                CallChecker.varAssign(this.q0, "this.q0", 87, 3759, 3771);
                this.q1 = q1;
                CallChecker.varAssign(this.q1, "this.q1", 88, 3785, 3797);
                this.q2 = q2;
                CallChecker.varAssign(this.q2, "this.q2", 89, 3811, 3823);
                this.q3 = q3;
                CallChecker.varAssign(this.q3, "this.q3", 90, 3837, 3849);
            }
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    public FieldRotation(final FieldVector3D<T> axis, final T angle) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context448 = new ConstructorContext(FieldRotation.class, 116, 3873, 5729);
        try {
            final T norm = CallChecker.varInit(axis.getNorm(), "norm", 119, 5288, 5317);
            if (CallChecker.beforeDeref(norm, null, 120, 5331, 5334)) {
                if ((norm.getReal()) == 0) {
                    throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T halfAngle = CallChecker.varInit(angle.multiply((-0.5)), "halfAngle", 124, 5471, 5511);
            final T coeff = CallChecker.varInit(halfAngle.sin().divide(norm), "coeff", 125, 5521, 5565);
            q0 = halfAngle.cos();
            CallChecker.varAssign(this.q0, "this.q0", 127, 5576, 5596);
            q1 = coeff.multiply(axis.getX());
            CallChecker.varAssign(this.q1, "this.q1", 128, 5606, 5638);
            q2 = coeff.multiply(axis.getY());
            CallChecker.varAssign(this.q2, "this.q2", 129, 5648, 5680);
            q3 = coeff.multiply(axis.getZ());
            CallChecker.varAssign(this.q3, "this.q3", 130, 5690, 5722);
        } finally {
            _bcornu_methode_context448.methodEnd();
        }
    }

    public FieldRotation(final T[][] m, final double threshold) throws NotARotationMatrixException {
        ConstructorContext _bcornu_methode_context449 = new ConstructorContext(FieldRotation.class, 164, 5736, 8711);
        try {
            if (CallChecker.beforeDeref(m, null, 168, 7422, 7422)) {
                if (CallChecker.beforeDeref(m, null, 168, 7441, 7441)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 168, 7441, 7441)[0], null, 168, 7441, 7444)) {
                        if (CallChecker.beforeDeref(m, null, 169, 7479, 7479)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 169, 7479, 7479)[1], null, 169, 7479, 7482)) {
                                if (CallChecker.beforeDeref(m, null, 169, 7501, 7501)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 169, 7501, 7501)[2], null, 169, 7501, 7504)) {
                                        CallChecker.isCalled(m, null, 168, 7441, 7441)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, null, 168, 7441, 7441)[0], null, 168, 7441, 7444);
                                        CallChecker.isCalled(m, null, 169, 7479, 7479)[1] = CallChecker.beforeCalled(CallChecker.isCalled(m, null, 169, 7479, 7479)[1], null, 169, 7479, 7482);
                                        CallChecker.isCalled(m, null, 169, 7501, 7501)[2] = CallChecker.beforeCalled(CallChecker.isCalled(m, null, 169, 7501, 7501)[2], null, 169, 7501, 7504);
                                        if (((((CallChecker.isCalled(m, null, 168, 7422, 7422).length) != 3) || ((CallChecker.isCalled(CallChecker.isCalled(m, null, 168, 7441, 7441)[0], null, 168, 7441, 7444).length) != 3)) || ((CallChecker.isCalled(CallChecker.isCalled(m, null, 169, 7479, 7479)[1], null, 169, 7479, 7482).length) != 3)) || ((CallChecker.isCalled(CallChecker.isCalled(m, null, 169, 7501, 7501)[2], null, 169, 7501, 7504).length) != 3)) {
                                            if (CallChecker.beforeDeref(m, null, 172, 7718, 7718)) {
                                                if (CallChecker.beforeDeref(m, null, 172, 7728, 7728)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 172, 7728, 7728)[0], null, 172, 7728, 7731)) {
                                                        CallChecker.isCalled(m, null, 172, 7728, 7728)[0] = CallChecker.beforeCalled(CallChecker.isCalled(m, null, 172, 7728, 7728)[0], null, 172, 7728, 7731);
                                                        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, CallChecker.isCalled(m, null, 172, 7718, 7718).length, CallChecker.isCalled(CallChecker.isCalled(m, null, 172, 7728, 7728)[0], null, 172, 7728, 7731).length);
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
            
            final T[][] ort = CallChecker.varInit(orthogonalizeMatrix(m, threshold), "ort", 176, 7808, 7859);
            final T d0 = CallChecker.varInit(CallChecker.isCalled(ort, null, 179, 7928, 7930)[1][1].multiply(CallChecker.isCalled(ort, null, 179, 7947, 7949)[2][2]).subtract(CallChecker.isCalled(ort, null, 179, 7967, 7969)[2][1].multiply(CallChecker.isCalled(ort, null, 179, 7986, 7988)[1][2])), "d0", 179, 7870, 7997);
            final T d1 = CallChecker.varInit(CallChecker.isCalled(ort, null, 180, 8020, 8022)[0][1].multiply(CallChecker.isCalled(ort, null, 180, 8039, 8041)[2][2]).subtract(CallChecker.isCalled(ort, null, 180, 8059, 8061)[2][1].multiply(CallChecker.isCalled(ort, null, 180, 8078, 8080)[0][2])), "d1", 180, 8007, 8089);
            final T d2 = CallChecker.varInit(CallChecker.isCalled(ort, null, 181, 8112, 8114)[0][1].multiply(CallChecker.isCalled(ort, null, 181, 8131, 8133)[1][2]).subtract(CallChecker.isCalled(ort, null, 181, 8151, 8153)[1][1].multiply(CallChecker.isCalled(ort, null, 181, 8170, 8172)[0][2])), "d2", 181, 8099, 8181);
            final T det = CallChecker.varInit(CallChecker.isCalled(ort, null, 183, 8221, 8223)[0][0].multiply(d0).subtract(CallChecker.isCalled(ort, null, 183, 8253, 8255)[1][0].multiply(d1)).add(CallChecker.isCalled(ort, null, 183, 8281, 8283)[2][0].multiply(d2)), "det", 182, 8191, 8304);
            if (CallChecker.beforeDeref(det, null, 184, 8318, 8320)) {
                if ((det.getReal()) < 0.0) {
                    throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, det);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] quat = CallChecker.varInit(mat2quat(ort), "quat", 190, 8586, 8616);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 191, 8626, 8638);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 192, 8648, 8660);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 193, 8670, 8682);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 194, 8692, 8704);
        } finally {
            _bcornu_methode_context449.methodEnd();
        }
    }

    public FieldRotation(FieldVector3D<T> u1, FieldVector3D<T> u2, FieldVector3D<T> v1, FieldVector3D<T> v2) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context450 = new ConstructorContext(FieldRotation.class, 217, 8718, 11898);
        try {
            final FieldVector3D<T> u3 = CallChecker.varInit(CallChecker.isCalled(FieldVector3D.crossProduct(u1, u2), FieldVector3D.class, 222, 10045, 10078).normalize(), "u3", 222, 9870, 10091);
            final FieldVector3D<T> npe_invocation_var186 = FieldVector3D.crossProduct(u3, u1);
            if (CallChecker.beforeDeref(npe_invocation_var186, FieldVector3D.class, 223, 10106, 10139)) {
                u2 = CallChecker.isCalled(npe_invocation_var186, FieldVector3D.class, 223, 10106, 10139).normalize();
                CallChecker.varAssign(u2, "u2", 223, 10101, 10152);
            }
            if (CallChecker.beforeDeref(u1, FieldVector3D.class, 224, 10167, 10168)) {
                u1 = CallChecker.beforeCalled(u1, FieldVector3D.class, 224, 10167, 10168);
                u1 = CallChecker.isCalled(u1, FieldVector3D.class, 224, 10167, 10168).normalize();
                CallChecker.varAssign(u1, "u1", 224, 10162, 10181);
            }
            final FieldVector3D<T> v3 = CallChecker.varInit(CallChecker.isCalled(FieldVector3D.crossProduct(v1, v2), FieldVector3D.class, 228, 10370, 10403).normalize(), "v3", 228, 10192, 10416);
            final FieldVector3D<T> npe_invocation_var187 = FieldVector3D.crossProduct(v3, v1);
            if (CallChecker.beforeDeref(npe_invocation_var187, FieldVector3D.class, 229, 10431, 10464)) {
                v2 = CallChecker.isCalled(npe_invocation_var187, FieldVector3D.class, 229, 10431, 10464).normalize();
                CallChecker.varAssign(v2, "v2", 229, 10426, 10477);
            }
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 230, 10492, 10493)) {
                v1 = CallChecker.beforeCalled(v1, FieldVector3D.class, 230, 10492, 10493);
                v1 = CallChecker.isCalled(v1, FieldVector3D.class, 230, 10492, 10493).normalize();
                CallChecker.varAssign(v1, "v1", 230, 10487, 10506);
            }
            final T[][] array = CallChecker.varInit(MathArrays.buildArray(u1.getX().getField(), 3, 3), "array", 233, 10590, 10659);
            if (CallChecker.beforeDeref(array, null, 234, 10669, 10673)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 234, 10669, 10673)[0], null, 234, 10669, 10676)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 234, 10683, 10684)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 234, 10702, 10703)) {
                            final RealFieldElement<T> npe_invocation_var188 = u1.getX();
                            if (CallChecker.beforeDeref(npe_invocation_var188, RealFieldElement.class, 234, 10683, 10691)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 234, 10717, 10718)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 234, 10736, 10737)) {
                                        final RealFieldElement<T> npe_invocation_var189 = u2.getX();
                                        if (CallChecker.beforeDeref(npe_invocation_var189, RealFieldElement.class, 234, 10717, 10725)) {
                                            final RealFieldElement<T> npe_invocation_var190 = npe_invocation_var188.multiply(v1.getX());
                                            if (CallChecker.beforeDeref(npe_invocation_var190, RealFieldElement.class, 234, 10683, 10711)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 234, 10752, 10753)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 234, 10771, 10772)) {
                                                        final RealFieldElement<T> npe_invocation_var191 = u3.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var191, RealFieldElement.class, 234, 10752, 10760)) {
                                                            final RealFieldElement<T> npe_invocation_var192 = npe_invocation_var190.add(npe_invocation_var189.multiply(v2.getX()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var192, RealFieldElement.class, 234, 10683, 10746)) {
                                                                CallChecker.isCalled(array, null, 234, 10669, 10673)[0][0] = npe_invocation_var192.add(npe_invocation_var191.multiply(v3.getX()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 234, 10669, 10673)[0][0], "CallChecker.isCalled(array, null, 234, 10669, 10673)[0][0]", 234, 10669, 10782);
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
            if (CallChecker.beforeDeref(array, null, 235, 10792, 10796)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 235, 10792, 10796)[0], null, 235, 10792, 10799)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 235, 10806, 10807)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 235, 10825, 10826)) {
                            final RealFieldElement<T> npe_invocation_var193 = u1.getY();
                            if (CallChecker.beforeDeref(npe_invocation_var193, RealFieldElement.class, 235, 10806, 10814)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 235, 10840, 10841)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 235, 10859, 10860)) {
                                        final RealFieldElement<T> npe_invocation_var194 = u2.getY();
                                        if (CallChecker.beforeDeref(npe_invocation_var194, RealFieldElement.class, 235, 10840, 10848)) {
                                            final RealFieldElement<T> npe_invocation_var195 = npe_invocation_var193.multiply(v1.getX());
                                            if (CallChecker.beforeDeref(npe_invocation_var195, RealFieldElement.class, 235, 10806, 10834)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 235, 10875, 10876)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 235, 10894, 10895)) {
                                                        final RealFieldElement<T> npe_invocation_var196 = u3.getY();
                                                        if (CallChecker.beforeDeref(npe_invocation_var196, RealFieldElement.class, 235, 10875, 10883)) {
                                                            final RealFieldElement<T> npe_invocation_var197 = npe_invocation_var195.add(npe_invocation_var194.multiply(v2.getX()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var197, RealFieldElement.class, 235, 10806, 10869)) {
                                                                CallChecker.isCalled(array, null, 235, 10792, 10796)[0][1] = npe_invocation_var197.add(npe_invocation_var196.multiply(v3.getX()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 235, 10792, 10796)[0][1], "CallChecker.isCalled(array, null, 235, 10792, 10796)[0][1]", 235, 10792, 10905);
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
            if (CallChecker.beforeDeref(array, null, 236, 10915, 10919)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 236, 10915, 10919)[0], null, 236, 10915, 10922)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 236, 10929, 10930)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 236, 10948, 10949)) {
                            final RealFieldElement<T> npe_invocation_var198 = u1.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var198, RealFieldElement.class, 236, 10929, 10937)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 236, 10963, 10964)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 236, 10982, 10983)) {
                                        final RealFieldElement<T> npe_invocation_var199 = u2.getZ();
                                        if (CallChecker.beforeDeref(npe_invocation_var199, RealFieldElement.class, 236, 10963, 10971)) {
                                            final RealFieldElement<T> npe_invocation_var200 = npe_invocation_var198.multiply(v1.getX());
                                            if (CallChecker.beforeDeref(npe_invocation_var200, RealFieldElement.class, 236, 10929, 10957)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 236, 10998, 10999)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 236, 11017, 11018)) {
                                                        final RealFieldElement<T> npe_invocation_var201 = u3.getZ();
                                                        if (CallChecker.beforeDeref(npe_invocation_var201, RealFieldElement.class, 236, 10998, 11006)) {
                                                            final RealFieldElement<T> npe_invocation_var202 = npe_invocation_var200.add(npe_invocation_var199.multiply(v2.getX()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var202, RealFieldElement.class, 236, 10929, 10992)) {
                                                                CallChecker.isCalled(array, null, 236, 10915, 10919)[0][2] = npe_invocation_var202.add(npe_invocation_var201.multiply(v3.getX()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 236, 10915, 10919)[0][2], "CallChecker.isCalled(array, null, 236, 10915, 10919)[0][2]", 236, 10915, 11028);
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
            if (CallChecker.beforeDeref(array, null, 237, 11038, 11042)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 237, 11038, 11042)[1], null, 237, 11038, 11045)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 237, 11052, 11053)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 237, 11071, 11072)) {
                            final RealFieldElement<T> npe_invocation_var203 = u1.getX();
                            if (CallChecker.beforeDeref(npe_invocation_var203, RealFieldElement.class, 237, 11052, 11060)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 237, 11086, 11087)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 237, 11105, 11106)) {
                                        final RealFieldElement<T> npe_invocation_var204 = u2.getX();
                                        if (CallChecker.beforeDeref(npe_invocation_var204, RealFieldElement.class, 237, 11086, 11094)) {
                                            final RealFieldElement<T> npe_invocation_var205 = npe_invocation_var203.multiply(v1.getY());
                                            if (CallChecker.beforeDeref(npe_invocation_var205, RealFieldElement.class, 237, 11052, 11080)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 237, 11121, 11122)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 237, 11140, 11141)) {
                                                        final RealFieldElement<T> npe_invocation_var206 = u3.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var206, RealFieldElement.class, 237, 11121, 11129)) {
                                                            final RealFieldElement<T> npe_invocation_var207 = npe_invocation_var205.add(npe_invocation_var204.multiply(v2.getY()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var207, RealFieldElement.class, 237, 11052, 11115)) {
                                                                CallChecker.isCalled(array, null, 237, 11038, 11042)[1][0] = npe_invocation_var207.add(npe_invocation_var206.multiply(v3.getY()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 237, 11038, 11042)[1][0], "CallChecker.isCalled(array, null, 237, 11038, 11042)[1][0]", 237, 11038, 11151);
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
            if (CallChecker.beforeDeref(array, null, 238, 11161, 11165)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 238, 11161, 11165)[1], null, 238, 11161, 11168)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 238, 11175, 11176)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 238, 11194, 11195)) {
                            final RealFieldElement<T> npe_invocation_var208 = u1.getY();
                            if (CallChecker.beforeDeref(npe_invocation_var208, RealFieldElement.class, 238, 11175, 11183)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 238, 11209, 11210)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 238, 11228, 11229)) {
                                        final RealFieldElement<T> npe_invocation_var209 = u2.getY();
                                        if (CallChecker.beforeDeref(npe_invocation_var209, RealFieldElement.class, 238, 11209, 11217)) {
                                            final RealFieldElement<T> npe_invocation_var210 = npe_invocation_var208.multiply(v1.getY());
                                            if (CallChecker.beforeDeref(npe_invocation_var210, RealFieldElement.class, 238, 11175, 11203)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 238, 11244, 11245)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 238, 11263, 11264)) {
                                                        final RealFieldElement<T> npe_invocation_var211 = u3.getY();
                                                        if (CallChecker.beforeDeref(npe_invocation_var211, RealFieldElement.class, 238, 11244, 11252)) {
                                                            final RealFieldElement<T> npe_invocation_var212 = npe_invocation_var210.add(npe_invocation_var209.multiply(v2.getY()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var212, RealFieldElement.class, 238, 11175, 11238)) {
                                                                CallChecker.isCalled(array, null, 238, 11161, 11165)[1][1] = npe_invocation_var212.add(npe_invocation_var211.multiply(v3.getY()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 238, 11161, 11165)[1][1], "CallChecker.isCalled(array, null, 238, 11161, 11165)[1][1]", 238, 11161, 11274);
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
            if (CallChecker.beforeDeref(array, null, 239, 11284, 11288)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 239, 11284, 11288)[1], null, 239, 11284, 11291)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 239, 11298, 11299)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 239, 11317, 11318)) {
                            final RealFieldElement<T> npe_invocation_var213 = u1.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var213, RealFieldElement.class, 239, 11298, 11306)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 239, 11332, 11333)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 239, 11351, 11352)) {
                                        final RealFieldElement<T> npe_invocation_var214 = u2.getZ();
                                        if (CallChecker.beforeDeref(npe_invocation_var214, RealFieldElement.class, 239, 11332, 11340)) {
                                            final RealFieldElement<T> npe_invocation_var215 = npe_invocation_var213.multiply(v1.getY());
                                            if (CallChecker.beforeDeref(npe_invocation_var215, RealFieldElement.class, 239, 11298, 11326)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 239, 11367, 11368)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 239, 11386, 11387)) {
                                                        final RealFieldElement<T> npe_invocation_var216 = u3.getZ();
                                                        if (CallChecker.beforeDeref(npe_invocation_var216, RealFieldElement.class, 239, 11367, 11375)) {
                                                            final RealFieldElement<T> npe_invocation_var217 = npe_invocation_var215.add(npe_invocation_var214.multiply(v2.getY()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var217, RealFieldElement.class, 239, 11298, 11361)) {
                                                                CallChecker.isCalled(array, null, 239, 11284, 11288)[1][2] = npe_invocation_var217.add(npe_invocation_var216.multiply(v3.getY()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 239, 11284, 11288)[1][2], "CallChecker.isCalled(array, null, 239, 11284, 11288)[1][2]", 239, 11284, 11397);
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
            if (CallChecker.beforeDeref(array, null, 240, 11407, 11411)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 240, 11407, 11411)[2], null, 240, 11407, 11414)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 240, 11421, 11422)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 240, 11440, 11441)) {
                            final RealFieldElement<T> npe_invocation_var218 = u1.getX();
                            if (CallChecker.beforeDeref(npe_invocation_var218, RealFieldElement.class, 240, 11421, 11429)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 240, 11455, 11456)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 240, 11474, 11475)) {
                                        final RealFieldElement<T> npe_invocation_var219 = u2.getX();
                                        if (CallChecker.beforeDeref(npe_invocation_var219, RealFieldElement.class, 240, 11455, 11463)) {
                                            final RealFieldElement<T> npe_invocation_var220 = npe_invocation_var218.multiply(v1.getZ());
                                            if (CallChecker.beforeDeref(npe_invocation_var220, RealFieldElement.class, 240, 11421, 11449)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 240, 11490, 11491)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 240, 11509, 11510)) {
                                                        final RealFieldElement<T> npe_invocation_var221 = u3.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var221, RealFieldElement.class, 240, 11490, 11498)) {
                                                            final RealFieldElement<T> npe_invocation_var222 = npe_invocation_var220.add(npe_invocation_var219.multiply(v2.getZ()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var222, RealFieldElement.class, 240, 11421, 11484)) {
                                                                CallChecker.isCalled(array, null, 240, 11407, 11411)[2][0] = npe_invocation_var222.add(npe_invocation_var221.multiply(v3.getZ()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 240, 11407, 11411)[2][0], "CallChecker.isCalled(array, null, 240, 11407, 11411)[2][0]", 240, 11407, 11520);
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
            if (CallChecker.beforeDeref(array, null, 241, 11530, 11534)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 241, 11530, 11534)[2], null, 241, 11530, 11537)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 241, 11544, 11545)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 241, 11563, 11564)) {
                            final RealFieldElement<T> npe_invocation_var223 = u1.getY();
                            if (CallChecker.beforeDeref(npe_invocation_var223, RealFieldElement.class, 241, 11544, 11552)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 241, 11578, 11579)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 241, 11597, 11598)) {
                                        final RealFieldElement<T> npe_invocation_var224 = u2.getY();
                                        if (CallChecker.beforeDeref(npe_invocation_var224, RealFieldElement.class, 241, 11578, 11586)) {
                                            final RealFieldElement<T> npe_invocation_var225 = npe_invocation_var223.multiply(v1.getZ());
                                            if (CallChecker.beforeDeref(npe_invocation_var225, RealFieldElement.class, 241, 11544, 11572)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 241, 11613, 11614)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 241, 11632, 11633)) {
                                                        final RealFieldElement<T> npe_invocation_var226 = u3.getY();
                                                        if (CallChecker.beforeDeref(npe_invocation_var226, RealFieldElement.class, 241, 11613, 11621)) {
                                                            final RealFieldElement<T> npe_invocation_var227 = npe_invocation_var225.add(npe_invocation_var224.multiply(v2.getZ()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var227, RealFieldElement.class, 241, 11544, 11607)) {
                                                                CallChecker.isCalled(array, null, 241, 11530, 11534)[2][1] = npe_invocation_var227.add(npe_invocation_var226.multiply(v3.getZ()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 241, 11530, 11534)[2][1], "CallChecker.isCalled(array, null, 241, 11530, 11534)[2][1]", 241, 11530, 11643);
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
            if (CallChecker.beforeDeref(array, null, 242, 11653, 11657)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 242, 11653, 11657)[2], null, 242, 11653, 11660)) {
                    if (CallChecker.beforeDeref(u1, FieldVector3D.class, 242, 11667, 11668)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 242, 11686, 11687)) {
                            final RealFieldElement<T> npe_invocation_var228 = u1.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var228, RealFieldElement.class, 242, 11667, 11675)) {
                                if (CallChecker.beforeDeref(u2, FieldVector3D.class, 242, 11701, 11702)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 242, 11720, 11721)) {
                                        final RealFieldElement<T> npe_invocation_var229 = u2.getZ();
                                        if (CallChecker.beforeDeref(npe_invocation_var229, RealFieldElement.class, 242, 11701, 11709)) {
                                            final RealFieldElement<T> npe_invocation_var230 = npe_invocation_var228.multiply(v1.getZ());
                                            if (CallChecker.beforeDeref(npe_invocation_var230, RealFieldElement.class, 242, 11667, 11695)) {
                                                if (CallChecker.beforeDeref(u3, FieldVector3D.class, 242, 11736, 11737)) {
                                                    if (CallChecker.beforeDeref(v3, FieldVector3D.class, 242, 11755, 11756)) {
                                                        final RealFieldElement<T> npe_invocation_var231 = u3.getZ();
                                                        if (CallChecker.beforeDeref(npe_invocation_var231, RealFieldElement.class, 242, 11736, 11744)) {
                                                            final RealFieldElement<T> npe_invocation_var232 = npe_invocation_var230.add(npe_invocation_var229.multiply(v2.getZ()));
                                                            if (CallChecker.beforeDeref(npe_invocation_var232, RealFieldElement.class, 242, 11667, 11730)) {
                                                                CallChecker.isCalled(array, null, 242, 11653, 11657)[2][2] = npe_invocation_var232.add(npe_invocation_var231.multiply(v3.getZ()));
                                                                CallChecker.varAssign(CallChecker.isCalled(array, null, 242, 11653, 11657)[2][2], "CallChecker.isCalled(array, null, 242, 11653, 11657)[2][2]", 242, 11653, 11766);
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
            T[] quat = CallChecker.varInit(mat2quat(array), "quat", 244, 11777, 11803);
            q0 = quat[0];
            CallChecker.varAssign(this.q0, "this.q0", 245, 11813, 11825);
            q1 = quat[1];
            CallChecker.varAssign(this.q1, "this.q1", 246, 11835, 11847);
            q2 = quat[2];
            CallChecker.varAssign(this.q2, "this.q2", 247, 11857, 11869);
            q3 = quat[3];
            CallChecker.varAssign(this.q3, "this.q3", 248, 11879, 11891);
        } finally {
            _bcornu_methode_context450.methodEnd();
        }
    }

    public FieldRotation(final FieldVector3D<T> u, final FieldVector3D<T> v) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context451 = new ConstructorContext(FieldRotation.class, 265, 11905, 13879);
        try {
            final T normProduct = CallChecker.varInit(u.getNorm().multiply(v.getNorm()), "normProduct", 267, 12672, 12727);
            if (CallChecker.beforeDeref(normProduct, null, 268, 12741, 12751)) {
                if ((normProduct.getReal()) == 0) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(u, v), "dot", 272, 12894, 12938);
            if (CallChecker.beforeDeref(dot, null, 274, 12953, 12955)) {
                if (CallChecker.beforeDeref(normProduct, null, 274, 12988, 12998)) {
                    if ((dot.getReal()) < ((2.0E-15 - 1.0) * (normProduct.getReal()))) {
                        final FieldVector3D<T> w = CallChecker.varInit(CallChecker.isCalled(u, FieldVector3D.class, 277, 13177, 13177).orthogonal(), "w", 277, 13026, 13191);
                        q0 = normProduct.getField().getZero();
                        CallChecker.varAssign(this.q0, "this.q0", 278, 13205, 13242);
                        q1 = w.getX().negate();
                        CallChecker.varAssign(this.q1, "this.q1", 279, 13256, 13278);
                        q2 = w.getY().negate();
                        CallChecker.varAssign(this.q2, "this.q2", 280, 13292, 13314);
                        q3 = w.getZ().negate();
                        CallChecker.varAssign(this.q3, "this.q3", 281, 13328, 13350);
                    }else {
                        q0 = dot.divide(normProduct).add(1.0).multiply(0.5).sqrt();
                        CallChecker.varAssign(this.q0, "this.q0", 285, 13521, 13579);
                        final T coeff = CallChecker.varInit(q0.multiply(normProduct).multiply(2.0).reciprocal(), "coeff", 286, 13593, 13660);
                        final FieldVector3D<T> q = CallChecker.varInit(FieldVector3D.crossProduct(v, u), "q", 287, 13674, 13733);
                        q1 = coeff.multiply(q.getX());
                        CallChecker.varAssign(this.q1, "this.q1", 288, 13747, 13776);
                        q2 = coeff.multiply(q.getY());
                        CallChecker.varAssign(this.q2, "this.q2", 289, 13790, 13819);
                        q3 = coeff.multiply(q.getZ());
                        CallChecker.varAssign(this.q3, "this.q3", 290, 13833, 13862);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context451.methodEnd();
        }
    }

    public FieldRotation(final RotationOrder order, final T alpha1, final T alpha2, final T alpha3) {
        ConstructorContext _bcornu_methode_context452 = new ConstructorContext(FieldRotation.class, 314, 13886, 15607);
        try {
            final T one = CallChecker.varInit(alpha1.getField().getOne(), "one", 315, 15063, 15103);
            final FieldRotation<T> r1 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, CallChecker.isCalled(order, RotationOrder.class, 316, 15188, 15192).getA1()), alpha1), "r1", 316, 15113, 15211);
            final FieldRotation<T> r2 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, CallChecker.isCalled(order, RotationOrder.class, 317, 15296, 15300).getA2()), alpha2), "r2", 317, 15221, 15319);
            final FieldRotation<T> r3 = CallChecker.varInit(new FieldRotation<T>(new FieldVector3D<T>(one, CallChecker.isCalled(order, RotationOrder.class, 318, 15404, 15408).getA3()), alpha3), "r3", 318, 15329, 15427);
            final FieldRotation<T> composed = CallChecker.varInit(CallChecker.isCalled(r1, FieldRotation.class, 319, 15471, 15472).applyTo(CallChecker.isCalled(r2, FieldRotation.class, 319, 15482, 15483).applyTo(r3)), "composed", 319, 15437, 15497);
            q0 = composed.q0;
            CallChecker.varAssign(this.q0, "this.q0", 320, 15507, 15523);
            q1 = composed.q1;
            CallChecker.varAssign(this.q1, "this.q1", 321, 15533, 15549);
            q2 = composed.q2;
            CallChecker.varAssign(this.q2, "this.q2", 322, 15559, 15575);
            q3 = composed.q3;
            CallChecker.varAssign(this.q3, "this.q3", 323, 15585, 15601);
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }

    private T[] mat2quat(final T[][] ort) {
        MethodContext _bcornu_methode_context1900 = new MethodContext(null, 330, 15614, 18739);
        try {
            CallChecker.varInit(this, "this", 330, 15614, 18739);
            CallChecker.varInit(ort, "ort", 330, 15614, 18739);
            CallChecker.varInit(this.q3, "q3", 330, 15614, 18739);
            CallChecker.varInit(this.q2, "q2", 330, 15614, 18739);
            CallChecker.varInit(this.q1, "q1", 330, 15614, 18739);
            CallChecker.varInit(this.q0, "q0", 330, 15614, 18739);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 330, 15614, 18739);
            final T[] quat = CallChecker.varInit(MathArrays.buildArray(CallChecker.isCalled(ort, null, 332, 15872, 15874)[0][0].getField(), 4), "quat", 332, 15833, 15896);
            T s = CallChecker.init(null);
            if (CallChecker.beforeDeref(ort, null, 345, 16690, 16692)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 345, 16690, 16692)[0], null, 345, 16690, 16695)) {
                    if (CallChecker.beforeDeref(ort, null, 345, 16704, 16706)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 345, 16704, 16706)[1], null, 345, 16704, 16709)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 345, 16690, 16692)[0][0], null, 345, 16690, 16698)) {
                                if (CallChecker.beforeDeref(ort, null, 345, 16719, 16721)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 345, 16719, 16721)[2], null, 345, 16719, 16724)) {
                                        final RealFieldElement<T> npe_invocation_var233 = CallChecker.isCalled(ort, null, 345, 16690, 16692)[0][0].add(CallChecker.isCalled(ort, null, 345, 16704, 16706)[1][1]);
                                        if (CallChecker.beforeDeref(npe_invocation_var233, RealFieldElement.class, 345, 16690, 16713)) {
                                            s = npe_invocation_var233.add(CallChecker.isCalled(ort, null, 345, 16719, 16721)[2][2]);
                                            CallChecker.varAssign(s, "s", 345, 16690, 16692);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(s, null, 346, 16743, 16743)) {
                if ((s.getReal()) > (-0.19)) {
                    if (CallChecker.beforeDeref(quat, null, 348, 16829, 16832)) {
                        if (CallChecker.beforeDeref(s, null, 348, 16839, 16839)) {
                            final RealFieldElement<T> npe_invocation_var234 = s.add(1.0);
                            if (CallChecker.beforeDeref(npe_invocation_var234, RealFieldElement.class, 348, 16839, 16848)) {
                                final RealFieldElement<T> npe_invocation_var235 = npe_invocation_var234.sqrt();
                                if (CallChecker.beforeDeref(npe_invocation_var235, RealFieldElement.class, 348, 16839, 16855)) {
                                    quat[0] = npe_invocation_var235.multiply(0.5);
                                    CallChecker.varAssign(quat[0], "quat[0]", 348, 16829, 16870);
                                }
                            }
                        }
                    }
                    T inv = CallChecker.init(null);
                    if (CallChecker.beforeDeref(quat, null, 349, 16892, 16895)) {
                        if (CallChecker.beforeDeref(quat[0], null, 349, 16892, 16898)) {
                            final RealFieldElement<T> npe_invocation_var236 = quat[0].reciprocal();
                            if (CallChecker.beforeDeref(npe_invocation_var236, RealFieldElement.class, 349, 16892, 16911)) {
                                inv = npe_invocation_var236.multiply(0.25);
                                CallChecker.varAssign(inv, "inv", 349, 16892, 16895);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(quat, null, 350, 16941, 16944)) {
                        if (CallChecker.beforeDeref(ort, null, 350, 16964, 16966)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 350, 16964, 16966)[1], null, 350, 16964, 16969)) {
                                if (CallChecker.beforeDeref(ort, null, 350, 16983, 16985)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 350, 16983, 16985)[2], null, 350, 16983, 16988)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 350, 16964, 16966)[1][2], null, 350, 16964, 16972)) {
                                            if (CallChecker.beforeDeref(inv, null, 350, 16951, 16953)) {
                                                quat[1] = inv.multiply(CallChecker.isCalled(ort, null, 350, 16964, 16966)[1][2].subtract(CallChecker.isCalled(ort, null, 350, 16983, 16985)[2][1]));
                                                CallChecker.varAssign(quat[1], "quat[1]", 350, 16941, 16994);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(quat, null, 351, 17008, 17011)) {
                        if (CallChecker.beforeDeref(ort, null, 351, 17031, 17033)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 351, 17031, 17033)[2], null, 351, 17031, 17036)) {
                                if (CallChecker.beforeDeref(ort, null, 351, 17050, 17052)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 351, 17050, 17052)[0], null, 351, 17050, 17055)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 351, 17031, 17033)[2][0], null, 351, 17031, 17039)) {
                                            if (CallChecker.beforeDeref(inv, null, 351, 17018, 17020)) {
                                                quat[2] = inv.multiply(CallChecker.isCalled(ort, null, 351, 17031, 17033)[2][0].subtract(CallChecker.isCalled(ort, null, 351, 17050, 17052)[0][2]));
                                                CallChecker.varAssign(quat[2], "quat[2]", 351, 17008, 17061);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(quat, null, 352, 17075, 17078)) {
                        if (CallChecker.beforeDeref(ort, null, 352, 17098, 17100)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 352, 17098, 17100)[0], null, 352, 17098, 17103)) {
                                if (CallChecker.beforeDeref(ort, null, 352, 17117, 17119)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 352, 17117, 17119)[1], null, 352, 17117, 17122)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 352, 17098, 17100)[0][1], null, 352, 17098, 17106)) {
                                            if (CallChecker.beforeDeref(inv, null, 352, 17085, 17087)) {
                                                quat[3] = inv.multiply(CallChecker.isCalled(ort, null, 352, 17098, 17100)[0][1].subtract(CallChecker.isCalled(ort, null, 352, 17117, 17119)[1][0]));
                                                CallChecker.varAssign(quat[3], "quat[3]", 352, 17075, 17128);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(ort, null, 354, 17163, 17165)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 354, 17163, 17165)[0], null, 354, 17163, 17168)) {
                            if (CallChecker.beforeDeref(ort, null, 354, 17182, 17184)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 354, 17182, 17184)[1], null, 354, 17182, 17187)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 354, 17163, 17165)[0][0], null, 354, 17163, 17171)) {
                                        if (CallChecker.beforeDeref(ort, null, 354, 17202, 17204)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 354, 17202, 17204)[2], null, 354, 17202, 17207)) {
                                                final RealFieldElement<T> npe_invocation_var237 = CallChecker.isCalled(ort, null, 354, 17163, 17165)[0][0].subtract(CallChecker.isCalled(ort, null, 354, 17182, 17184)[1][1]);
                                                if (CallChecker.beforeDeref(npe_invocation_var237, RealFieldElement.class, 354, 17163, 17191)) {
                                                    s = npe_invocation_var237.subtract(CallChecker.isCalled(ort, null, 354, 17202, 17204)[2][2]);
                                                    CallChecker.varAssign(s, "s", 354, 17159, 17212);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(s, null, 355, 17230, 17230)) {
                        if ((s.getReal()) > (-0.19)) {
                            if (CallChecker.beforeDeref(quat, null, 357, 17324, 17327)) {
                                if (CallChecker.beforeDeref(s, null, 357, 17334, 17334)) {
                                    final RealFieldElement<T> npe_invocation_var238 = s.add(1.0);
                                    if (CallChecker.beforeDeref(npe_invocation_var238, RealFieldElement.class, 357, 17334, 17343)) {
                                        final RealFieldElement<T> npe_invocation_var239 = npe_invocation_var238.sqrt();
                                        if (CallChecker.beforeDeref(npe_invocation_var239, RealFieldElement.class, 357, 17334, 17350)) {
                                            quat[1] = npe_invocation_var239.multiply(0.5);
                                            CallChecker.varAssign(quat[1], "quat[1]", 357, 17324, 17365);
                                        }
                                    }
                                }
                            }
                            T inv = CallChecker.init(null);
                            if (CallChecker.beforeDeref(quat, null, 358, 17391, 17394)) {
                                if (CallChecker.beforeDeref(quat[1], null, 358, 17391, 17397)) {
                                    final RealFieldElement<T> npe_invocation_var240 = quat[1].reciprocal();
                                    if (CallChecker.beforeDeref(npe_invocation_var240, RealFieldElement.class, 358, 17391, 17410)) {
                                        inv = npe_invocation_var240.multiply(0.25);
                                        CallChecker.varAssign(inv, "inv", 358, 17391, 17394);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(quat, null, 359, 17444, 17447)) {
                                if (CallChecker.beforeDeref(ort, null, 359, 17467, 17469)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 359, 17467, 17469)[1], null, 359, 17467, 17472)) {
                                        if (CallChecker.beforeDeref(ort, null, 359, 17486, 17488)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 359, 17486, 17488)[2], null, 359, 17486, 17491)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 359, 17467, 17469)[1][2], null, 359, 17467, 17475)) {
                                                    if (CallChecker.beforeDeref(inv, null, 359, 17454, 17456)) {
                                                        quat[0] = inv.multiply(CallChecker.isCalled(ort, null, 359, 17467, 17469)[1][2].subtract(CallChecker.isCalled(ort, null, 359, 17486, 17488)[2][1]));
                                                        CallChecker.varAssign(quat[0], "quat[0]", 359, 17444, 17497);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(quat, null, 360, 17515, 17518)) {
                                if (CallChecker.beforeDeref(ort, null, 360, 17538, 17540)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 360, 17538, 17540)[0], null, 360, 17538, 17543)) {
                                        if (CallChecker.beforeDeref(ort, null, 360, 17552, 17554)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 360, 17552, 17554)[1], null, 360, 17552, 17557)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 360, 17538, 17540)[0][1], null, 360, 17538, 17546)) {
                                                    if (CallChecker.beforeDeref(inv, null, 360, 17525, 17527)) {
                                                        quat[2] = inv.multiply(CallChecker.isCalled(ort, null, 360, 17538, 17540)[0][1].add(CallChecker.isCalled(ort, null, 360, 17552, 17554)[1][0]));
                                                        CallChecker.varAssign(quat[2], "quat[2]", 360, 17515, 17563);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(quat, null, 361, 17581, 17584)) {
                                if (CallChecker.beforeDeref(ort, null, 361, 17604, 17606)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 361, 17604, 17606)[0], null, 361, 17604, 17609)) {
                                        if (CallChecker.beforeDeref(ort, null, 361, 17618, 17620)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 361, 17618, 17620)[2], null, 361, 17618, 17623)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 361, 17604, 17606)[0][2], null, 361, 17604, 17612)) {
                                                    if (CallChecker.beforeDeref(inv, null, 361, 17591, 17593)) {
                                                        quat[3] = inv.multiply(CallChecker.isCalled(ort, null, 361, 17604, 17606)[0][2].add(CallChecker.isCalled(ort, null, 361, 17618, 17620)[2][0]));
                                                        CallChecker.varAssign(quat[3], "quat[3]", 361, 17581, 17629);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(ort, null, 363, 17672, 17674)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 363, 17672, 17674)[1], null, 363, 17672, 17677)) {
                                    if (CallChecker.beforeDeref(ort, null, 363, 17691, 17693)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 363, 17691, 17693)[0], null, 363, 17691, 17696)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 363, 17672, 17674)[1][1], null, 363, 17672, 17680)) {
                                                if (CallChecker.beforeDeref(ort, null, 363, 17711, 17713)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 363, 17711, 17713)[2], null, 363, 17711, 17716)) {
                                                        final RealFieldElement<T> npe_invocation_var241 = CallChecker.isCalled(ort, null, 363, 17672, 17674)[1][1].subtract(CallChecker.isCalled(ort, null, 363, 17691, 17693)[0][0]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var241, RealFieldElement.class, 363, 17672, 17700)) {
                                                            s = npe_invocation_var241.subtract(CallChecker.isCalled(ort, null, 363, 17711, 17713)[2][2]);
                                                            CallChecker.varAssign(s, "s", 363, 17668, 17721);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(s, null, 364, 17743, 17743)) {
                                if ((s.getReal()) > (-0.19)) {
                                    if (CallChecker.beforeDeref(quat, null, 366, 17845, 17848)) {
                                        if (CallChecker.beforeDeref(s, null, 366, 17855, 17855)) {
                                            final RealFieldElement<T> npe_invocation_var242 = s.add(1.0);
                                            if (CallChecker.beforeDeref(npe_invocation_var242, RealFieldElement.class, 366, 17855, 17864)) {
                                                final RealFieldElement<T> npe_invocation_var243 = npe_invocation_var242.sqrt();
                                                if (CallChecker.beforeDeref(npe_invocation_var243, RealFieldElement.class, 366, 17855, 17871)) {
                                                    quat[2] = npe_invocation_var243.multiply(0.5);
                                                    CallChecker.varAssign(quat[2], "quat[2]", 366, 17845, 17886);
                                                }
                                            }
                                        }
                                    }
                                    T inv = CallChecker.init(null);
                                    if (CallChecker.beforeDeref(quat, null, 367, 17916, 17919)) {
                                        if (CallChecker.beforeDeref(quat[2], null, 367, 17916, 17922)) {
                                            final RealFieldElement<T> npe_invocation_var244 = quat[2].reciprocal();
                                            if (CallChecker.beforeDeref(npe_invocation_var244, RealFieldElement.class, 367, 17916, 17935)) {
                                                inv = npe_invocation_var244.multiply(0.25);
                                                CallChecker.varAssign(inv, "inv", 367, 17916, 17919);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 368, 17973, 17976)) {
                                        if (CallChecker.beforeDeref(ort, null, 368, 17996, 17998)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 368, 17996, 17998)[2], null, 368, 17996, 18001)) {
                                                if (CallChecker.beforeDeref(ort, null, 368, 18015, 18017)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 368, 18015, 18017)[0], null, 368, 18015, 18020)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 368, 17996, 17998)[2][0], null, 368, 17996, 18004)) {
                                                            if (CallChecker.beforeDeref(inv, null, 368, 17983, 17985)) {
                                                                quat[0] = inv.multiply(CallChecker.isCalled(ort, null, 368, 17996, 17998)[2][0].subtract(CallChecker.isCalled(ort, null, 368, 18015, 18017)[0][2]));
                                                                CallChecker.varAssign(quat[0], "quat[0]", 368, 17973, 18026);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 369, 18048, 18051)) {
                                        if (CallChecker.beforeDeref(ort, null, 369, 18071, 18073)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 369, 18071, 18073)[0], null, 369, 18071, 18076)) {
                                                if (CallChecker.beforeDeref(ort, null, 369, 18085, 18087)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 369, 18085, 18087)[1], null, 369, 18085, 18090)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 369, 18071, 18073)[0][1], null, 369, 18071, 18079)) {
                                                            if (CallChecker.beforeDeref(inv, null, 369, 18058, 18060)) {
                                                                quat[1] = inv.multiply(CallChecker.isCalled(ort, null, 369, 18071, 18073)[0][1].add(CallChecker.isCalled(ort, null, 369, 18085, 18087)[1][0]));
                                                                CallChecker.varAssign(quat[1], "quat[1]", 369, 18048, 18096);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 370, 18118, 18121)) {
                                        if (CallChecker.beforeDeref(ort, null, 370, 18141, 18143)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 370, 18141, 18143)[2], null, 370, 18141, 18146)) {
                                                if (CallChecker.beforeDeref(ort, null, 370, 18155, 18157)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 370, 18155, 18157)[1], null, 370, 18155, 18160)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 370, 18141, 18143)[2][1], null, 370, 18141, 18149)) {
                                                            if (CallChecker.beforeDeref(inv, null, 370, 18128, 18130)) {
                                                                quat[3] = inv.multiply(CallChecker.isCalled(ort, null, 370, 18141, 18143)[2][1].add(CallChecker.isCalled(ort, null, 370, 18155, 18157)[1][2]));
                                                                CallChecker.varAssign(quat[3], "quat[3]", 370, 18118, 18166);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(ort, null, 373, 18276, 18278)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 373, 18276, 18278)[2], null, 373, 18276, 18281)) {
                                            if (CallChecker.beforeDeref(ort, null, 373, 18295, 18297)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 373, 18295, 18297)[0], null, 373, 18295, 18300)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 373, 18276, 18278)[2][2], null, 373, 18276, 18284)) {
                                                        if (CallChecker.beforeDeref(ort, null, 373, 18315, 18317)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 373, 18315, 18317)[1], null, 373, 18315, 18320)) {
                                                                final RealFieldElement<T> npe_invocation_var245 = CallChecker.isCalled(ort, null, 373, 18276, 18278)[2][2].subtract(CallChecker.isCalled(ort, null, 373, 18295, 18297)[0][0]);
                                                                if (CallChecker.beforeDeref(npe_invocation_var245, RealFieldElement.class, 373, 18276, 18304)) {
                                                                    s = npe_invocation_var245.subtract(CallChecker.isCalled(ort, null, 373, 18315, 18317)[1][1]);
                                                                    CallChecker.varAssign(s, "s", 373, 18272, 18325);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 374, 18347, 18350)) {
                                        if (CallChecker.beforeDeref(s, null, 374, 18357, 18357)) {
                                            final RealFieldElement<T> npe_invocation_var246 = s.add(1.0);
                                            if (CallChecker.beforeDeref(npe_invocation_var246, RealFieldElement.class, 374, 18357, 18366)) {
                                                final RealFieldElement<T> npe_invocation_var247 = npe_invocation_var246.sqrt();
                                                if (CallChecker.beforeDeref(npe_invocation_var247, RealFieldElement.class, 374, 18357, 18373)) {
                                                    quat[3] = npe_invocation_var247.multiply(0.5);
                                                    CallChecker.varAssign(quat[3], "quat[3]", 374, 18347, 18388);
                                                }
                                            }
                                        }
                                    }
                                    T inv = CallChecker.init(null);
                                    if (CallChecker.beforeDeref(quat, null, 375, 18418, 18421)) {
                                        if (CallChecker.beforeDeref(quat[3], null, 375, 18418, 18424)) {
                                            final RealFieldElement<T> npe_invocation_var248 = quat[3].reciprocal();
                                            if (CallChecker.beforeDeref(npe_invocation_var248, RealFieldElement.class, 375, 18418, 18437)) {
                                                inv = npe_invocation_var248.multiply(0.25);
                                                CallChecker.varAssign(inv, "inv", 375, 18418, 18421);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 376, 18475, 18478)) {
                                        if (CallChecker.beforeDeref(ort, null, 376, 18498, 18500)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 376, 18498, 18500)[0], null, 376, 18498, 18503)) {
                                                if (CallChecker.beforeDeref(ort, null, 376, 18517, 18519)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 376, 18517, 18519)[1], null, 376, 18517, 18522)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 376, 18498, 18500)[0][1], null, 376, 18498, 18506)) {
                                                            if (CallChecker.beforeDeref(inv, null, 376, 18485, 18487)) {
                                                                quat[0] = inv.multiply(CallChecker.isCalled(ort, null, 376, 18498, 18500)[0][1].subtract(CallChecker.isCalled(ort, null, 376, 18517, 18519)[1][0]));
                                                                CallChecker.varAssign(quat[0], "quat[0]", 376, 18475, 18528);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 377, 18550, 18553)) {
                                        if (CallChecker.beforeDeref(ort, null, 377, 18573, 18575)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 377, 18573, 18575)[0], null, 377, 18573, 18578)) {
                                                if (CallChecker.beforeDeref(ort, null, 377, 18587, 18589)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 377, 18587, 18589)[2], null, 377, 18587, 18592)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 377, 18573, 18575)[0][2], null, 377, 18573, 18581)) {
                                                            if (CallChecker.beforeDeref(inv, null, 377, 18560, 18562)) {
                                                                quat[1] = inv.multiply(CallChecker.isCalled(ort, null, 377, 18573, 18575)[0][2].add(CallChecker.isCalled(ort, null, 377, 18587, 18589)[2][0]));
                                                                CallChecker.varAssign(quat[1], "quat[1]", 377, 18550, 18598);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(quat, null, 378, 18620, 18623)) {
                                        if (CallChecker.beforeDeref(ort, null, 378, 18643, 18645)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 378, 18643, 18645)[2], null, 378, 18643, 18648)) {
                                                if (CallChecker.beforeDeref(ort, null, 378, 18657, 18659)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 378, 18657, 18659)[1], null, 378, 18657, 18662)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ort, null, 378, 18643, 18645)[2][1], null, 378, 18643, 18651)) {
                                                            if (CallChecker.beforeDeref(inv, null, 378, 18630, 18632)) {
                                                                quat[2] = inv.multiply(CallChecker.isCalled(ort, null, 378, 18643, 18645)[2][1].add(CallChecker.isCalled(ort, null, 378, 18657, 18659)[1][2]));
                                                                CallChecker.varAssign(quat[2], "quat[2]", 378, 18620, 18668);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return quat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1900.methodEnd();
        }
    }

    public FieldRotation<T> revert() {
        MethodContext _bcornu_methode_context1901 = new MethodContext(FieldRotation.class, 394, 18746, 19148);
        try {
            CallChecker.varInit(this, "this", 394, 18746, 19148);
            CallChecker.varInit(this.q3, "q3", 394, 18746, 19148);
            CallChecker.varInit(this.q2, "q2", 394, 18746, 19148);
            CallChecker.varInit(this.q1, "q1", 394, 18746, 19148);
            CallChecker.varInit(this.q0, "q0", 394, 18746, 19148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 394, 18746, 19148);
            if (CallChecker.beforeDeref(q0, null, 395, 19111, 19112)) {
                return new FieldRotation<T>(q0.negate(), q1, q2, q3, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1901.methodEnd();
        }
    }

    public T getQ0() {
        MethodContext _bcornu_methode_context1902 = new MethodContext(null, 401, 19155, 19309);
        try {
            CallChecker.varInit(this, "this", 401, 19155, 19309);
            CallChecker.varInit(this.q3, "q3", 401, 19155, 19309);
            CallChecker.varInit(this.q2, "q2", 401, 19155, 19309);
            CallChecker.varInit(this.q1, "q1", 401, 19155, 19309);
            CallChecker.varInit(this.q0, "q0", 401, 19155, 19309);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 401, 19155, 19309);
            return q0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1902.methodEnd();
        }
    }

    public T getQ1() {
        MethodContext _bcornu_methode_context1903 = new MethodContext(null, 408, 19316, 19512);
        try {
            CallChecker.varInit(this, "this", 408, 19316, 19512);
            CallChecker.varInit(this.q3, "q3", 408, 19316, 19512);
            CallChecker.varInit(this.q2, "q2", 408, 19316, 19512);
            CallChecker.varInit(this.q1, "q1", 408, 19316, 19512);
            CallChecker.varInit(this.q0, "q0", 408, 19316, 19512);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 408, 19316, 19512);
            return q1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1903.methodEnd();
        }
    }

    public T getQ2() {
        MethodContext _bcornu_methode_context1904 = new MethodContext(null, 415, 19519, 19717);
        try {
            CallChecker.varInit(this, "this", 415, 19519, 19717);
            CallChecker.varInit(this.q3, "q3", 415, 19519, 19717);
            CallChecker.varInit(this.q2, "q2", 415, 19519, 19717);
            CallChecker.varInit(this.q1, "q1", 415, 19519, 19717);
            CallChecker.varInit(this.q0, "q0", 415, 19519, 19717);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 415, 19519, 19717);
            return q2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1904.methodEnd();
        }
    }

    public T getQ3() {
        MethodContext _bcornu_methode_context1905 = new MethodContext(null, 422, 19724, 19920);
        try {
            CallChecker.varInit(this, "this", 422, 19724, 19920);
            CallChecker.varInit(this.q3, "q3", 422, 19724, 19920);
            CallChecker.varInit(this.q2, "q2", 422, 19724, 19920);
            CallChecker.varInit(this.q1, "q1", 422, 19724, 19920);
            CallChecker.varInit(this.q0, "q0", 422, 19724, 19920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 422, 19724, 19920);
            return q3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1905.methodEnd();
        }
    }

    public FieldVector3D<T> getAxis() {
        MethodContext _bcornu_methode_context1906 = new MethodContext(FieldVector3D.class, 430, 19927, 20796);
        try {
            CallChecker.varInit(this, "this", 430, 19927, 20796);
            CallChecker.varInit(this.q3, "q3", 430, 19927, 20796);
            CallChecker.varInit(this.q2, "q2", 430, 19927, 20796);
            CallChecker.varInit(this.q1, "q1", 430, 19927, 20796);
            CallChecker.varInit(this.q0, "q0", 430, 19927, 20796);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 430, 19927, 20796);
            final T squaredSine = CallChecker.varInit(q1.multiply(q1).add(q2.multiply(q2)).add(q3.multiply(q3)), "squaredSine", 431, 20135, 20214);
            if (CallChecker.beforeDeref(squaredSine, null, 432, 20228, 20238)) {
                if ((squaredSine.getReal()) == 0) {
                    final Field<T> field = CallChecker.varInit(squaredSine.getField(), "field", 433, 20270, 20315);
                    if (CallChecker.beforeDeref(field, Field.class, 434, 20357, 20361)) {
                        if (CallChecker.beforeDeref(field, Field.class, 434, 20373, 20377)) {
                            if (CallChecker.beforeDeref(field, Field.class, 434, 20390, 20394)) {
                                return new FieldVector3D<T>(field.getOne(), field.getZero(), field.getZero());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (CallChecker.beforeDeref(q0, null, 435, 20427, 20428)) {
                        if ((q0.getReal()) < 0) {
                            T inverse = CallChecker.init(null);
                            if (CallChecker.beforeDeref(squaredSine, null, 436, 20471, 20481)) {
                                final RealFieldElement<T> npe_invocation_var249 = squaredSine.sqrt();
                                if (CallChecker.beforeDeref(npe_invocation_var249, RealFieldElement.class, 436, 20471, 20488)) {
                                    inverse = npe_invocation_var249.reciprocal();
                                    CallChecker.varAssign(inverse, "inverse", 436, 20471, 20481);
                                }
                            }
                            if (CallChecker.beforeDeref(q1, null, 437, 20544, 20545)) {
                                if (CallChecker.beforeDeref(q2, null, 437, 20566, 20567)) {
                                    if (CallChecker.beforeDeref(q3, null, 437, 20588, 20589)) {
                                        return new FieldVector3D<T>(q1.multiply(inverse), q2.multiply(inverse), q3.multiply(inverse));
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
            
            final T inverse = CallChecker.varInit(squaredSine.sqrt().reciprocal().negate(), "inverse", 439, 20629, 20687);
            if (CallChecker.beforeDeref(q1, null, 440, 20725, 20726)) {
                if (CallChecker.beforeDeref(q2, null, 440, 20747, 20748)) {
                    if (CallChecker.beforeDeref(q3, null, 440, 20769, 20770)) {
                        return new FieldVector3D<T>(q1.multiply(inverse), q2.multiply(inverse), q3.multiply(inverse));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1906.methodEnd();
        }
    }

    public T getAngle() {
        MethodContext _bcornu_methode_context1907 = new MethodContext(null, 447, 20803, 21297);
        try {
            CallChecker.varInit(this, "this", 447, 20803, 21297);
            CallChecker.varInit(this.q3, "q3", 447, 20803, 21297);
            CallChecker.varInit(this.q2, "q2", 447, 20803, 21297);
            CallChecker.varInit(this.q1, "q1", 447, 20803, 21297);
            CallChecker.varInit(this.q0, "q0", 447, 20803, 21297);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 447, 20803, 21297);
            if (CallChecker.beforeDeref(q0, null, 448, 21003, 21004)) {
                if (CallChecker.beforeDeref(q0, null, 448, 21028, 21029)) {
                    if (((q0.getReal()) < (-0.1)) || ((q0.getReal()) > 0.1)) {
                        if (CallChecker.beforeDeref(q1, null, 449, 21070, 21071)) {
                            if (CallChecker.beforeDeref(q2, null, 449, 21090, 21091)) {
                                final RealFieldElement<T> npe_invocation_var250 = q1.multiply(q1);
                                if (CallChecker.beforeDeref(npe_invocation_var250, RealFieldElement.class, 449, 21070, 21084)) {
                                    if (CallChecker.beforeDeref(q3, null, 449, 21111, 21112)) {
                                        final RealFieldElement<T> npe_invocation_var251 = npe_invocation_var250.add(q2.multiply(q2));
                                        if (CallChecker.beforeDeref(npe_invocation_var251, RealFieldElement.class, 449, 21070, 21105)) {
                                            final RealFieldElement<T> npe_invocation_var252 = npe_invocation_var251.add(q3.multiply(q3));
                                            if (CallChecker.beforeDeref(npe_invocation_var252, RealFieldElement.class, 449, 21070, 21126)) {
                                                final RealFieldElement<T> npe_invocation_var253 = npe_invocation_var252.sqrt();
                                                if (CallChecker.beforeDeref(npe_invocation_var253, RealFieldElement.class, 449, 21070, 21133)) {
                                                    final RealFieldElement<T> npe_invocation_var254 = npe_invocation_var253.asin();
                                                    if (CallChecker.beforeDeref(npe_invocation_var254, RealFieldElement.class, 449, 21070, 21140)) {
                                                        return npe_invocation_var254.multiply(2);
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(q0, null, 450, 21174, 21175)) {
                            if ((q0.getReal()) < 0) {
                                if (CallChecker.beforeDeref(q0, null, 451, 21213, 21214)) {
                                    final RealFieldElement<T> npe_invocation_var255 = q0.negate();
                                    if (CallChecker.beforeDeref(npe_invocation_var255, RealFieldElement.class, 451, 21213, 21223)) {
                                        final RealFieldElement<T> npe_invocation_var256 = npe_invocation_var255.acos();
                                        if (CallChecker.beforeDeref(npe_invocation_var256, RealFieldElement.class, 451, 21213, 21230)) {
                                            return npe_invocation_var256.multiply(2);
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
            
            if (CallChecker.beforeDeref(q0, null, 453, 21270, 21271)) {
                final RealFieldElement<T> npe_invocation_var257 = q0.acos();
                if (CallChecker.beforeDeref(npe_invocation_var257, RealFieldElement.class, 453, 21270, 21278)) {
                    return npe_invocation_var257.multiply(2);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1907.methodEnd();
        }
    }

    public T[] getAngles(final RotationOrder order) throws CardanEulerSingularityException {
        MethodContext _bcornu_methode_context1908 = new MethodContext(null, 491, 21304, 33506);
        try {
            CallChecker.varInit(this, "this", 491, 21304, 33506);
            CallChecker.varInit(order, "order", 491, 21304, 33506);
            CallChecker.varInit(this.q3, "q3", 491, 21304, 33506);
            CallChecker.varInit(this.q2, "q2", 491, 21304, 33506);
            CallChecker.varInit(this.q1, "q1", 491, 21304, 33506);
            CallChecker.varInit(this.q0, "q0", 491, 21304, 33506);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 491, 21304, 33506);
            if (order == (RotationOrder.XYZ)) {
                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 501, 23419, 23782);
                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 502, 23796, 23855);
                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 503, 23875, 23876)) {
                    final RealFieldElement<T> npe_invocation_var258 = v2.getZ();
                    if (CallChecker.beforeDeref(npe_invocation_var258, RealFieldElement.class, 503, 23875, 23883)) {
                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 503, 23916, 23917)) {
                            final RealFieldElement<T> npe_invocation_var259 = v2.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var259, RealFieldElement.class, 503, 23916, 23924)) {
                                if (((CallChecker.isCalled(npe_invocation_var258, RealFieldElement.class, 503, 23875, 23883).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var259, RealFieldElement.class, 503, 23916, 23924).getReal()) > 0.9999999999)) {
                                    throw new CardanEulerSingularityException(true);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(v1, FieldVector3D.class, 506, 24064, 24065)) {
                    final RealFieldElement<T> npe_invocation_var260 = v1.getY();
                    if (CallChecker.beforeDeref(npe_invocation_var260, RealFieldElement.class, 506, 24064, 24072)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 506, 24089, 24090)) {
                            final RealFieldElement<T> npe_invocation_var261 = npe_invocation_var260.negate();
                            if (CallChecker.beforeDeref(npe_invocation_var261, RealFieldElement.class, 506, 24064, 24081)) {
                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 507, 24131, 24132)) {
                                    final RealFieldElement<T> npe_invocation_var262 = v2.getZ();
                                    if (CallChecker.beforeDeref(npe_invocation_var262, RealFieldElement.class, 507, 24131, 24139)) {
                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 508, 24179, 24180)) {
                                            final RealFieldElement<T> npe_invocation_var263 = v2.getY();
                                            if (CallChecker.beforeDeref(npe_invocation_var263, RealFieldElement.class, 508, 24179, 24187)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 508, 24204, 24205)) {
                                                    final RealFieldElement<T> npe_invocation_var264 = npe_invocation_var263.negate();
                                                    if (CallChecker.beforeDeref(npe_invocation_var264, RealFieldElement.class, 508, 24179, 24196)) {
                                                        return buildArray(npe_invocation_var261.atan2(v1.getZ()), npe_invocation_var262.asin(), npe_invocation_var264.atan2(v2.getX()));
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (order == (RotationOrder.XZY)) {
                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 517, 24280, 24632);
                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 518, 24646, 24705);
                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 519, 24724, 24725)) {
                        final RealFieldElement<T> npe_invocation_var265 = v2.getY();
                        if (CallChecker.beforeDeref(npe_invocation_var265, RealFieldElement.class, 519, 24724, 24732)) {
                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 519, 24765, 24766)) {
                                final RealFieldElement<T> npe_invocation_var266 = v2.getY();
                                if (CallChecker.beforeDeref(npe_invocation_var266, RealFieldElement.class, 519, 24765, 24773)) {
                                    if (((CallChecker.isCalled(npe_invocation_var265, RealFieldElement.class, 519, 24724, 24732).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var266, RealFieldElement.class, 519, 24765, 24773).getReal()) > 0.9999999999)) {
                                        throw new CardanEulerSingularityException(true);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(v1, FieldVector3D.class, 522, 24913, 24914)) {
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 522, 24929, 24930)) {
                            final RealFieldElement<T> npe_invocation_var267 = v1.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var267, RealFieldElement.class, 522, 24913, 24921)) {
                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 523, 24971, 24972)) {
                                    final RealFieldElement<T> npe_invocation_var268 = v2.getY();
                                    if (CallChecker.beforeDeref(npe_invocation_var268, RealFieldElement.class, 523, 24971, 24979)) {
                                        final RealFieldElement<T> npe_invocation_var269 = npe_invocation_var268.asin();
                                        if (CallChecker.beforeDeref(npe_invocation_var269, RealFieldElement.class, 523, 24971, 24986)) {
                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 524, 25028, 25029)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 524, 25044, 25045)) {
                                                    final RealFieldElement<T> npe_invocation_var270 = v2.getZ();
                                                    if (CallChecker.beforeDeref(npe_invocation_var270, RealFieldElement.class, 524, 25028, 25036)) {
                                                        return buildArray(npe_invocation_var267.atan2(v1.getY()), npe_invocation_var269.negate(), npe_invocation_var270.atan2(v2.getX()));
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (order == (RotationOrder.YXZ)) {
                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 533, 25120, 25473);
                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 534, 25487, 25546);
                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 535, 25565, 25566)) {
                            final RealFieldElement<T> npe_invocation_var271 = v2.getZ();
                            if (CallChecker.beforeDeref(npe_invocation_var271, RealFieldElement.class, 535, 25565, 25573)) {
                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 535, 25606, 25607)) {
                                    final RealFieldElement<T> npe_invocation_var272 = v2.getZ();
                                    if (CallChecker.beforeDeref(npe_invocation_var272, RealFieldElement.class, 535, 25606, 25614)) {
                                        if (((CallChecker.isCalled(npe_invocation_var271, RealFieldElement.class, 535, 25565, 25573).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var272, RealFieldElement.class, 535, 25606, 25614).getReal()) > 0.9999999999)) {
                                            throw new CardanEulerSingularityException(true);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 538, 25754, 25755)) {
                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 538, 25770, 25771)) {
                                final RealFieldElement<T> npe_invocation_var273 = v1.getX();
                                if (CallChecker.beforeDeref(npe_invocation_var273, RealFieldElement.class, 538, 25754, 25762)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 539, 25812, 25813)) {
                                        final RealFieldElement<T> npe_invocation_var274 = v2.getZ();
                                        if (CallChecker.beforeDeref(npe_invocation_var274, RealFieldElement.class, 539, 25812, 25820)) {
                                            final RealFieldElement<T> npe_invocation_var275 = npe_invocation_var274.asin();
                                            if (CallChecker.beforeDeref(npe_invocation_var275, RealFieldElement.class, 539, 25812, 25827)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 540, 25869, 25870)) {
                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 540, 25885, 25886)) {
                                                        final RealFieldElement<T> npe_invocation_var276 = v2.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var276, RealFieldElement.class, 540, 25869, 25877)) {
                                                            return buildArray(npe_invocation_var273.atan2(v1.getZ()), npe_invocation_var275.negate(), npe_invocation_var276.atan2(v2.getY()));
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
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (order == (RotationOrder.YZX)) {
                            final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 549, 25961, 26313);
                            final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 550, 26327, 26386);
                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 551, 26405, 26406)) {
                                final RealFieldElement<T> npe_invocation_var277 = v2.getX();
                                if (CallChecker.beforeDeref(npe_invocation_var277, RealFieldElement.class, 551, 26405, 26413)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 551, 26446, 26447)) {
                                        final RealFieldElement<T> npe_invocation_var278 = v2.getX();
                                        if (CallChecker.beforeDeref(npe_invocation_var278, RealFieldElement.class, 551, 26446, 26454)) {
                                            if (((CallChecker.isCalled(npe_invocation_var277, RealFieldElement.class, 551, 26405, 26413).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var278, RealFieldElement.class, 551, 26446, 26454).getReal()) > 0.9999999999)) {
                                                throw new CardanEulerSingularityException(true);
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 554, 26594, 26595)) {
                                final RealFieldElement<T> npe_invocation_var279 = v1.getZ();
                                if (CallChecker.beforeDeref(npe_invocation_var279, RealFieldElement.class, 554, 26594, 26602)) {
                                    if (CallChecker.beforeDeref(v1, FieldVector3D.class, 554, 26619, 26620)) {
                                        final RealFieldElement<T> npe_invocation_var280 = npe_invocation_var279.negate();
                                        if (CallChecker.beforeDeref(npe_invocation_var280, RealFieldElement.class, 554, 26594, 26611)) {
                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 555, 26661, 26662)) {
                                                final RealFieldElement<T> npe_invocation_var281 = v2.getX();
                                                if (CallChecker.beforeDeref(npe_invocation_var281, RealFieldElement.class, 555, 26661, 26669)) {
                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 556, 26709, 26710)) {
                                                        final RealFieldElement<T> npe_invocation_var282 = v2.getZ();
                                                        if (CallChecker.beforeDeref(npe_invocation_var282, RealFieldElement.class, 556, 26709, 26717)) {
                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 556, 26734, 26735)) {
                                                                final RealFieldElement<T> npe_invocation_var283 = npe_invocation_var282.negate();
                                                                if (CallChecker.beforeDeref(npe_invocation_var283, RealFieldElement.class, 556, 26709, 26726)) {
                                                                    return buildArray(npe_invocation_var280.atan2(v1.getX()), npe_invocation_var281.asin(), npe_invocation_var283.atan2(v2.getY()));
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
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            if (order == (RotationOrder.ZXY)) {
                                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 565, 26810, 27162);
                                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 566, 27176, 27235);
                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 567, 27254, 27255)) {
                                    final RealFieldElement<T> npe_invocation_var284 = v2.getY();
                                    if (CallChecker.beforeDeref(npe_invocation_var284, RealFieldElement.class, 567, 27254, 27262)) {
                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 567, 27295, 27296)) {
                                            final RealFieldElement<T> npe_invocation_var285 = v2.getY();
                                            if (CallChecker.beforeDeref(npe_invocation_var285, RealFieldElement.class, 567, 27295, 27303)) {
                                                if (((CallChecker.isCalled(npe_invocation_var284, RealFieldElement.class, 567, 27254, 27262).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var285, RealFieldElement.class, 567, 27295, 27303).getReal()) > 0.9999999999)) {
                                                    throw new CardanEulerSingularityException(true);
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(v1, FieldVector3D.class, 570, 27443, 27444)) {
                                    final RealFieldElement<T> npe_invocation_var286 = v1.getX();
                                    if (CallChecker.beforeDeref(npe_invocation_var286, RealFieldElement.class, 570, 27443, 27451)) {
                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 570, 27468, 27469)) {
                                            final RealFieldElement<T> npe_invocation_var287 = npe_invocation_var286.negate();
                                            if (CallChecker.beforeDeref(npe_invocation_var287, RealFieldElement.class, 570, 27443, 27460)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 571, 27510, 27511)) {
                                                    final RealFieldElement<T> npe_invocation_var288 = v2.getY();
                                                    if (CallChecker.beforeDeref(npe_invocation_var288, RealFieldElement.class, 571, 27510, 27518)) {
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 572, 27558, 27559)) {
                                                            final RealFieldElement<T> npe_invocation_var289 = v2.getX();
                                                            if (CallChecker.beforeDeref(npe_invocation_var289, RealFieldElement.class, 572, 27558, 27566)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 572, 27583, 27584)) {
                                                                    final RealFieldElement<T> npe_invocation_var290 = npe_invocation_var289.negate();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var290, RealFieldElement.class, 572, 27558, 27575)) {
                                                                        return buildArray(npe_invocation_var287.atan2(v1.getY()), npe_invocation_var288.asin(), npe_invocation_var290.atan2(v2.getZ()));
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
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                if (order == (RotationOrder.ZYX)) {
                                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 581, 27659, 28022);
                                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 582, 28036, 28095);
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 583, 28114, 28115)) {
                                        final RealFieldElement<T> npe_invocation_var291 = v2.getX();
                                        if (CallChecker.beforeDeref(npe_invocation_var291, RealFieldElement.class, 583, 28114, 28122)) {
                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 583, 28155, 28156)) {
                                                final RealFieldElement<T> npe_invocation_var292 = v2.getX();
                                                if (CallChecker.beforeDeref(npe_invocation_var292, RealFieldElement.class, 583, 28155, 28163)) {
                                                    if (((CallChecker.isCalled(npe_invocation_var291, RealFieldElement.class, 583, 28114, 28122).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var292, RealFieldElement.class, 583, 28155, 28163).getReal()) > 0.9999999999)) {
                                                        throw new CardanEulerSingularityException(true);
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(v1, FieldVector3D.class, 586, 28303, 28304)) {
                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 586, 28319, 28320)) {
                                            final RealFieldElement<T> npe_invocation_var293 = v1.getY();
                                            if (CallChecker.beforeDeref(npe_invocation_var293, RealFieldElement.class, 586, 28303, 28311)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 587, 28361, 28362)) {
                                                    final RealFieldElement<T> npe_invocation_var294 = v2.getX();
                                                    if (CallChecker.beforeDeref(npe_invocation_var294, RealFieldElement.class, 587, 28361, 28369)) {
                                                        final RealFieldElement<T> npe_invocation_var295 = npe_invocation_var294.asin();
                                                        if (CallChecker.beforeDeref(npe_invocation_var295, RealFieldElement.class, 587, 28361, 28376)) {
                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 588, 28418, 28419)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 588, 28434, 28435)) {
                                                                    final RealFieldElement<T> npe_invocation_var296 = v2.getY();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var296, RealFieldElement.class, 588, 28418, 28426)) {
                                                                        return buildArray(npe_invocation_var293.atan2(v1.getX()), npe_invocation_var295.negate(), npe_invocation_var296.atan2(v2.getZ()));
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
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    if (order == (RotationOrder.XYX)) {
                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 597, 28510, 28869);
                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 598, 28883, 28942);
                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 599, 28961, 28962)) {
                                            final RealFieldElement<T> npe_invocation_var297 = v2.getX();
                                            if (CallChecker.beforeDeref(npe_invocation_var297, RealFieldElement.class, 599, 28961, 28969)) {
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 599, 29002, 29003)) {
                                                    final RealFieldElement<T> npe_invocation_var298 = v2.getX();
                                                    if (CallChecker.beforeDeref(npe_invocation_var298, RealFieldElement.class, 599, 29002, 29010)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var297, RealFieldElement.class, 599, 28961, 28969).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var298, RealFieldElement.class, 599, 29002, 29010).getReal()) > 0.9999999999)) {
                                                            throw new CardanEulerSingularityException(false);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 602, 29151, 29152)) {
                                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 602, 29167, 29168)) {
                                                final RealFieldElement<T> npe_invocation_var299 = v1.getZ();
                                                if (CallChecker.beforeDeref(npe_invocation_var299, RealFieldElement.class, 602, 29167, 29175)) {
                                                    final RealFieldElement<T> npe_invocation_var300 = v1.getY();
                                                    if (CallChecker.beforeDeref(npe_invocation_var300, RealFieldElement.class, 602, 29151, 29159)) {
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 603, 29218, 29219)) {
                                                            final RealFieldElement<T> npe_invocation_var301 = v2.getX();
                                                            if (CallChecker.beforeDeref(npe_invocation_var301, RealFieldElement.class, 603, 29218, 29226)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 604, 29266, 29267)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 604, 29282, 29283)) {
                                                                        final RealFieldElement<T> npe_invocation_var302 = v2.getY();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var302, RealFieldElement.class, 604, 29266, 29274)) {
                                                                            return buildArray(npe_invocation_var300.atan2(npe_invocation_var299.negate()), npe_invocation_var301.acos(), npe_invocation_var302.atan2(v2.getZ()));
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
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        if (order == (RotationOrder.XZX)) {
                                            final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(1, 0, 0)), "v1", 613, 29358, 29703);
                                            final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(1, 0, 0)), "v2", 614, 29717, 29776);
                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 615, 29795, 29796)) {
                                                final RealFieldElement<T> npe_invocation_var303 = v2.getX();
                                                if (CallChecker.beforeDeref(npe_invocation_var303, RealFieldElement.class, 615, 29795, 29803)) {
                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 615, 29836, 29837)) {
                                                        final RealFieldElement<T> npe_invocation_var304 = v2.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var304, RealFieldElement.class, 615, 29836, 29844)) {
                                                            if (((CallChecker.isCalled(npe_invocation_var303, RealFieldElement.class, 615, 29795, 29803).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var304, RealFieldElement.class, 615, 29836, 29844).getReal()) > 0.9999999999)) {
                                                                throw new CardanEulerSingularityException(false);
                                                            }
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 618, 29985, 29986)) {
                                                if (CallChecker.beforeDeref(v1, FieldVector3D.class, 618, 30001, 30002)) {
                                                    final RealFieldElement<T> npe_invocation_var305 = v1.getZ();
                                                    if (CallChecker.beforeDeref(npe_invocation_var305, RealFieldElement.class, 618, 29985, 29993)) {
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 619, 30043, 30044)) {
                                                            final RealFieldElement<T> npe_invocation_var306 = v2.getX();
                                                            if (CallChecker.beforeDeref(npe_invocation_var306, RealFieldElement.class, 619, 30043, 30051)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 620, 30091, 30092)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 620, 30107, 30108)) {
                                                                        final RealFieldElement<T> npe_invocation_var307 = v2.getY();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var307, RealFieldElement.class, 620, 30107, 30115)) {
                                                                            final RealFieldElement<T> npe_invocation_var308 = v2.getZ();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var308, RealFieldElement.class, 620, 30091, 30099)) {
                                                                                return buildArray(npe_invocation_var305.atan2(v1.getY()), npe_invocation_var306.acos(), npe_invocation_var308.atan2(npe_invocation_var307.negate()));
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
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            if (order == (RotationOrder.YXY)) {
                                                final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 629, 30192, 30545);
                                                final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 630, 30559, 30618);
                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 631, 30637, 30638)) {
                                                    final RealFieldElement<T> npe_invocation_var309 = v2.getY();
                                                    if (CallChecker.beforeDeref(npe_invocation_var309, RealFieldElement.class, 631, 30637, 30645)) {
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 631, 30678, 30679)) {
                                                            final RealFieldElement<T> npe_invocation_var310 = v2.getY();
                                                            if (CallChecker.beforeDeref(npe_invocation_var310, RealFieldElement.class, 631, 30678, 30686)) {
                                                                if (((CallChecker.isCalled(npe_invocation_var309, RealFieldElement.class, 631, 30637, 30645).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var310, RealFieldElement.class, 631, 30678, 30686).getReal()) > 0.9999999999)) {
                                                                    throw new CardanEulerSingularityException(false);
                                                                }
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(v1, FieldVector3D.class, 634, 30827, 30828)) {
                                                    if (CallChecker.beforeDeref(v1, FieldVector3D.class, 634, 30843, 30844)) {
                                                        final RealFieldElement<T> npe_invocation_var311 = v1.getX();
                                                        if (CallChecker.beforeDeref(npe_invocation_var311, RealFieldElement.class, 634, 30827, 30835)) {
                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 635, 30885, 30886)) {
                                                                final RealFieldElement<T> npe_invocation_var312 = v2.getY();
                                                                if (CallChecker.beforeDeref(npe_invocation_var312, RealFieldElement.class, 635, 30885, 30893)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 636, 30933, 30934)) {
                                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 636, 30949, 30950)) {
                                                                            final RealFieldElement<T> npe_invocation_var313 = v2.getZ();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var313, RealFieldElement.class, 636, 30949, 30957)) {
                                                                                final RealFieldElement<T> npe_invocation_var314 = v2.getX();
                                                                                if (CallChecker.beforeDeref(npe_invocation_var314, RealFieldElement.class, 636, 30933, 30941)) {
                                                                                    return buildArray(npe_invocation_var311.atan2(v1.getZ()), npe_invocation_var312.acos(), npe_invocation_var314.atan2(npe_invocation_var313.negate()));
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
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                if (order == (RotationOrder.YZY)) {
                                                    final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 1, 0)), "v1", 645, 31034, 31387);
                                                    final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 1, 0)), "v2", 646, 31401, 31460);
                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 647, 31479, 31480)) {
                                                        final RealFieldElement<T> npe_invocation_var315 = v2.getY();
                                                        if (CallChecker.beforeDeref(npe_invocation_var315, RealFieldElement.class, 647, 31479, 31487)) {
                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 647, 31520, 31521)) {
                                                                final RealFieldElement<T> npe_invocation_var316 = v2.getY();
                                                                if (CallChecker.beforeDeref(npe_invocation_var316, RealFieldElement.class, 647, 31520, 31528)) {
                                                                    if (((CallChecker.isCalled(npe_invocation_var315, RealFieldElement.class, 647, 31479, 31487).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var316, RealFieldElement.class, 647, 31520, 31528).getReal()) > 0.9999999999)) {
                                                                        throw new CardanEulerSingularityException(false);
                                                                    }
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                    if (CallChecker.beforeDeref(v1, FieldVector3D.class, 650, 31669, 31670)) {
                                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 650, 31685, 31686)) {
                                                            final RealFieldElement<T> npe_invocation_var317 = v1.getX();
                                                            if (CallChecker.beforeDeref(npe_invocation_var317, RealFieldElement.class, 650, 31685, 31693)) {
                                                                final RealFieldElement<T> npe_invocation_var318 = v1.getZ();
                                                                if (CallChecker.beforeDeref(npe_invocation_var318, RealFieldElement.class, 650, 31669, 31677)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 651, 31736, 31737)) {
                                                                        final RealFieldElement<T> npe_invocation_var319 = v2.getY();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var319, RealFieldElement.class, 651, 31736, 31744)) {
                                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 652, 31784, 31785)) {
                                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 652, 31800, 31801)) {
                                                                                    final RealFieldElement<T> npe_invocation_var320 = v2.getZ();
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var320, RealFieldElement.class, 652, 31784, 31792)) {
                                                                                        return buildArray(npe_invocation_var318.atan2(npe_invocation_var317.negate()), npe_invocation_var319.acos(), npe_invocation_var320.atan2(v2.getX()));
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
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    if (order == (RotationOrder.ZXZ)) {
                                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 661, 31876, 32221);
                                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 662, 32235, 32294);
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 663, 32313, 32314)) {
                                                            final RealFieldElement<T> npe_invocation_var321 = v2.getZ();
                                                            if (CallChecker.beforeDeref(npe_invocation_var321, RealFieldElement.class, 663, 32313, 32321)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 663, 32354, 32355)) {
                                                                    final RealFieldElement<T> npe_invocation_var322 = v2.getZ();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var322, RealFieldElement.class, 663, 32354, 32362)) {
                                                                        if (((CallChecker.isCalled(npe_invocation_var321, RealFieldElement.class, 663, 32313, 32321).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var322, RealFieldElement.class, 663, 32354, 32362).getReal()) > 0.9999999999)) {
                                                                            throw new CardanEulerSingularityException(false);
                                                                        }
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 666, 32503, 32504)) {
                                                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 666, 32519, 32520)) {
                                                                final RealFieldElement<T> npe_invocation_var323 = v1.getY();
                                                                if (CallChecker.beforeDeref(npe_invocation_var323, RealFieldElement.class, 666, 32519, 32527)) {
                                                                    final RealFieldElement<T> npe_invocation_var324 = v1.getX();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var324, RealFieldElement.class, 666, 32503, 32511)) {
                                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 667, 32570, 32571)) {
                                                                            final RealFieldElement<T> npe_invocation_var325 = v2.getZ();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var325, RealFieldElement.class, 667, 32570, 32578)) {
                                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 668, 32618, 32619)) {
                                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 668, 32634, 32635)) {
                                                                                        final RealFieldElement<T> npe_invocation_var326 = v2.getX();
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var326, RealFieldElement.class, 668, 32618, 32626)) {
                                                                                            return buildArray(npe_invocation_var324.atan2(npe_invocation_var323.negate()), npe_invocation_var325.acos(), npe_invocation_var326.atan2(v2.getY()));
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
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else {
                                                        final FieldVector3D<T> v1 = CallChecker.varInit(applyTo(vector(0, 0, 1)), "v1", 677, 32705, 33064);
                                                        final FieldVector3D<T> v2 = CallChecker.varInit(applyInverseTo(vector(0, 0, 1)), "v2", 678, 33078, 33137);
                                                        if (CallChecker.beforeDeref(v2, FieldVector3D.class, 679, 33156, 33157)) {
                                                            final RealFieldElement<T> npe_invocation_var327 = v2.getZ();
                                                            if (CallChecker.beforeDeref(npe_invocation_var327, RealFieldElement.class, 679, 33156, 33164)) {
                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 679, 33197, 33198)) {
                                                                    final RealFieldElement<T> npe_invocation_var328 = v2.getZ();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var328, RealFieldElement.class, 679, 33197, 33205)) {
                                                                        if (((CallChecker.isCalled(npe_invocation_var327, RealFieldElement.class, 679, 33156, 33164).getReal()) < (-0.9999999999)) || ((CallChecker.isCalled(npe_invocation_var328, RealFieldElement.class, 679, 33197, 33205).getReal()) > 0.9999999999)) {
                                                                            throw new CardanEulerSingularityException(false);
                                                                        }
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                        if (CallChecker.beforeDeref(v1, FieldVector3D.class, 682, 33346, 33347)) {
                                                            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 682, 33362, 33363)) {
                                                                final RealFieldElement<T> npe_invocation_var329 = v1.getY();
                                                                if (CallChecker.beforeDeref(npe_invocation_var329, RealFieldElement.class, 682, 33346, 33354)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 683, 33404, 33405)) {
                                                                        final RealFieldElement<T> npe_invocation_var330 = v2.getZ();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var330, RealFieldElement.class, 683, 33404, 33412)) {
                                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 684, 33452, 33453)) {
                                                                                if (CallChecker.beforeDeref(v2, FieldVector3D.class, 684, 33468, 33469)) {
                                                                                    final RealFieldElement<T> npe_invocation_var331 = v2.getX();
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var331, RealFieldElement.class, 684, 33468, 33476)) {
                                                                                        final RealFieldElement<T> npe_invocation_var332 = v2.getY();
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var332, RealFieldElement.class, 684, 33452, 33460)) {
                                                                                            return buildArray(npe_invocation_var329.atan2(v1.getX()), npe_invocation_var330.acos(), npe_invocation_var332.atan2(npe_invocation_var331.negate()));
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
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }
                                                
                                            
                                        
                                    
                                
                            
                        
                    
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1908.methodEnd();
        }
    }

    private T[] buildArray(final T a0, final T a1, final T a2) {
        MethodContext _bcornu_methode_context1909 = new MethodContext(null, 696, 33513, 33917);
        try {
            CallChecker.varInit(this, "this", 696, 33513, 33917);
            CallChecker.varInit(a2, "a2", 696, 33513, 33917);
            CallChecker.varInit(a1, "a1", 696, 33513, 33917);
            CallChecker.varInit(a0, "a0", 696, 33513, 33917);
            CallChecker.varInit(this.q3, "q3", 696, 33513, 33917);
            CallChecker.varInit(this.q2, "q2", 696, 33513, 33917);
            CallChecker.varInit(this.q1, "q1", 696, 33513, 33917);
            CallChecker.varInit(this.q0, "q0", 696, 33513, 33917);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 696, 33513, 33917);
            final T[] array = CallChecker.varInit(MathArrays.buildArray(a0.getField(), 3), "array", 697, 33763, 33820);
            if (CallChecker.beforeDeref(array, null, 698, 33830, 33834)) {
                array[0] = a0;
                CallChecker.varAssign(array[0], "array[0]", 698, 33830, 33843);
            }
            if (CallChecker.beforeDeref(array, null, 699, 33853, 33857)) {
                array[1] = a1;
                CallChecker.varAssign(array[1], "array[1]", 699, 33853, 33866);
            }
            if (CallChecker.beforeDeref(array, null, 700, 33876, 33880)) {
                array[2] = a2;
                CallChecker.varAssign(array[2], "array[2]", 700, 33876, 33889);
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1909.methodEnd();
        }
    }

    private FieldVector3D<T> vector(final double x, final double y, final double z) {
        MethodContext _bcornu_methode_context1910 = new MethodContext(FieldVector3D.class, 710, 33924, 34282);
        try {
            CallChecker.varInit(this, "this", 710, 33924, 34282);
            CallChecker.varInit(z, "z", 710, 33924, 34282);
            CallChecker.varInit(y, "y", 710, 33924, 34282);
            CallChecker.varInit(x, "x", 710, 33924, 34282);
            CallChecker.varInit(this.q3, "q3", 710, 33924, 34282);
            CallChecker.varInit(this.q2, "q2", 710, 33924, 34282);
            CallChecker.varInit(this.q1, "q1", 710, 33924, 34282);
            CallChecker.varInit(this.q0, "q0", 710, 33924, 34282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 710, 33924, 34282);
            final T zero = CallChecker.varInit(q0.getField().getZero(), "zero", 711, 34162, 34200);
            if (CallChecker.beforeDeref(zero, null, 712, 34238, 34241)) {
                if (CallChecker.beforeDeref(zero, null, 712, 34251, 34254)) {
                    if (CallChecker.beforeDeref(zero, null, 712, 34264, 34267)) {
                        return new FieldVector3D<T>(zero.add(x), zero.add(y), zero.add(z));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1910.methodEnd();
        }
    }

    public T[][] getMatrix() {
        MethodContext _bcornu_methode_context1911 = new MethodContext(null, 718, 34289, 35467);
        try {
            CallChecker.varInit(this, "this", 718, 34289, 35467);
            CallChecker.varInit(this.q3, "q3", 718, 34289, 35467);
            CallChecker.varInit(this.q2, "q2", 718, 34289, 35467);
            CallChecker.varInit(this.q1, "q1", 718, 34289, 35467);
            CallChecker.varInit(this.q0, "q0", 718, 34289, 35467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 718, 34289, 35467);
            final T q0q0 = CallChecker.varInit(q0.multiply(q0), "q0q0", 721, 34446, 34497);
            final T q0q1 = CallChecker.varInit(q0.multiply(q1), "q0q1", 722, 34507, 34538);
            final T q0q2 = CallChecker.varInit(q0.multiply(q2), "q0q2", 723, 34548, 34579);
            final T q0q3 = CallChecker.varInit(q0.multiply(q3), "q0q3", 724, 34589, 34620);
            final T q1q1 = CallChecker.varInit(q1.multiply(q1), "q1q1", 725, 34630, 34661);
            final T q1q2 = CallChecker.varInit(q1.multiply(q2), "q1q2", 726, 34671, 34702);
            final T q1q3 = CallChecker.varInit(q1.multiply(q3), "q1q3", 727, 34712, 34743);
            final T q2q2 = CallChecker.varInit(q2.multiply(q2), "q2q2", 728, 34753, 34784);
            final T q2q3 = CallChecker.varInit(q2.multiply(q3), "q2q3", 729, 34794, 34825);
            final T q3q3 = CallChecker.varInit(q3.multiply(q3), "q3q3", 730, 34835, 34866);
            final T[][] m = CallChecker.varInit(MathArrays.buildArray(q0.getField(), 3, 3), "m", 733, 34906, 34964);
            if (CallChecker.beforeDeref(m, null, 735, 34975, 34975)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 735, 34975, 34975)[0], null, 735, 34975, 34979)) {
                    if (CallChecker.beforeDeref(q0q0, null, 735, 34986, 34989)) {
                        final RealFieldElement<T> npe_invocation_var333 = q0q0.add(q1q1);
                        if (CallChecker.beforeDeref(npe_invocation_var333, RealFieldElement.class, 735, 34986, 34999)) {
                            final RealFieldElement<T> npe_invocation_var334 = npe_invocation_var333.multiply(2);
                            if (CallChecker.beforeDeref(npe_invocation_var334, RealFieldElement.class, 735, 34986, 35011)) {
                                CallChecker.isCalled(m, null, 735, 34975, 34975)[0][0] = npe_invocation_var334.subtract(1);
                                CallChecker.varAssign(CallChecker.isCalled(m, null, 735, 34975, 34975)[0][0], "CallChecker.isCalled(m, null, 735, 34975, 34975)[0][0]", 735, 34975, 35024);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 736, 35034, 35034)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 736, 35034, 35034)[1], null, 736, 35034, 35038)) {
                    if (CallChecker.beforeDeref(q1q2, null, 736, 35045, 35048)) {
                        final RealFieldElement<T> npe_invocation_var335 = q1q2.subtract(q0q3);
                        if (CallChecker.beforeDeref(npe_invocation_var335, RealFieldElement.class, 736, 35045, 35063)) {
                            CallChecker.isCalled(m, null, 736, 35034, 35034)[1][0] = npe_invocation_var335.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 736, 35034, 35034)[1][0], "CallChecker.isCalled(m, null, 736, 35034, 35034)[1][0]", 736, 35034, 35076);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 737, 35086, 35086)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 737, 35086, 35086)[2], null, 737, 35086, 35090)) {
                    if (CallChecker.beforeDeref(q1q3, null, 737, 35097, 35100)) {
                        final RealFieldElement<T> npe_invocation_var336 = q1q3.add(q0q2);
                        if (CallChecker.beforeDeref(npe_invocation_var336, RealFieldElement.class, 737, 35097, 35110)) {
                            CallChecker.isCalled(m, null, 737, 35086, 35086)[2][0] = npe_invocation_var336.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 737, 35086, 35086)[2][0], "CallChecker.isCalled(m, null, 737, 35086, 35086)[2][0]", 737, 35086, 35123);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 739, 35134, 35134)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 739, 35134, 35134)[0], null, 739, 35134, 35138)) {
                    if (CallChecker.beforeDeref(q1q2, null, 739, 35145, 35148)) {
                        final RealFieldElement<T> npe_invocation_var337 = q1q2.add(q0q3);
                        if (CallChecker.beforeDeref(npe_invocation_var337, RealFieldElement.class, 739, 35145, 35158)) {
                            CallChecker.isCalled(m, null, 739, 35134, 35134)[0][1] = npe_invocation_var337.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 739, 35134, 35134)[0][1], "CallChecker.isCalled(m, null, 739, 35134, 35134)[0][1]", 739, 35134, 35171);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 740, 35181, 35181)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 740, 35181, 35181)[1], null, 740, 35181, 35185)) {
                    if (CallChecker.beforeDeref(q0q0, null, 740, 35192, 35195)) {
                        final RealFieldElement<T> npe_invocation_var338 = q0q0.add(q2q2);
                        if (CallChecker.beforeDeref(npe_invocation_var338, RealFieldElement.class, 740, 35192, 35205)) {
                            final RealFieldElement<T> npe_invocation_var339 = npe_invocation_var338.multiply(2);
                            if (CallChecker.beforeDeref(npe_invocation_var339, RealFieldElement.class, 740, 35192, 35217)) {
                                CallChecker.isCalled(m, null, 740, 35181, 35181)[1][1] = npe_invocation_var339.subtract(1);
                                CallChecker.varAssign(CallChecker.isCalled(m, null, 740, 35181, 35181)[1][1], "CallChecker.isCalled(m, null, 740, 35181, 35181)[1][1]", 740, 35181, 35230);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 741, 35240, 35240)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 741, 35240, 35240)[2], null, 741, 35240, 35244)) {
                    if (CallChecker.beforeDeref(q2q3, null, 741, 35251, 35254)) {
                        final RealFieldElement<T> npe_invocation_var340 = q2q3.subtract(q0q1);
                        if (CallChecker.beforeDeref(npe_invocation_var340, RealFieldElement.class, 741, 35251, 35269)) {
                            CallChecker.isCalled(m, null, 741, 35240, 35240)[2][1] = npe_invocation_var340.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 741, 35240, 35240)[2][1], "CallChecker.isCalled(m, null, 741, 35240, 35240)[2][1]", 741, 35240, 35282);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 743, 35293, 35293)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 743, 35293, 35293)[0], null, 743, 35293, 35297)) {
                    if (CallChecker.beforeDeref(q1q3, null, 743, 35304, 35307)) {
                        final RealFieldElement<T> npe_invocation_var341 = q1q3.subtract(q0q2);
                        if (CallChecker.beforeDeref(npe_invocation_var341, RealFieldElement.class, 743, 35304, 35322)) {
                            CallChecker.isCalled(m, null, 743, 35293, 35293)[0][2] = npe_invocation_var341.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 743, 35293, 35293)[0][2], "CallChecker.isCalled(m, null, 743, 35293, 35293)[0][2]", 743, 35293, 35335);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 744, 35345, 35345)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 744, 35345, 35345)[1], null, 744, 35345, 35349)) {
                    if (CallChecker.beforeDeref(q2q3, null, 744, 35356, 35359)) {
                        final RealFieldElement<T> npe_invocation_var342 = q2q3.add(q0q1);
                        if (CallChecker.beforeDeref(npe_invocation_var342, RealFieldElement.class, 744, 35356, 35369)) {
                            CallChecker.isCalled(m, null, 744, 35345, 35345)[1][2] = npe_invocation_var342.multiply(2);
                            CallChecker.varAssign(CallChecker.isCalled(m, null, 744, 35345, 35345)[1][2], "CallChecker.isCalled(m, null, 744, 35345, 35345)[1][2]", 744, 35345, 35382);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m, null, 745, 35392, 35392)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 745, 35392, 35392)[2], null, 745, 35392, 35396)) {
                    if (CallChecker.beforeDeref(q0q0, null, 745, 35403, 35406)) {
                        final RealFieldElement<T> npe_invocation_var343 = q0q0.add(q3q3);
                        if (CallChecker.beforeDeref(npe_invocation_var343, RealFieldElement.class, 745, 35403, 35416)) {
                            final RealFieldElement<T> npe_invocation_var344 = npe_invocation_var343.multiply(2);
                            if (CallChecker.beforeDeref(npe_invocation_var344, RealFieldElement.class, 745, 35403, 35428)) {
                                CallChecker.isCalled(m, null, 745, 35392, 35392)[2][2] = npe_invocation_var344.subtract(1);
                                CallChecker.varAssign(CallChecker.isCalled(m, null, 745, 35392, 35392)[2][2], "CallChecker.isCalled(m, null, 745, 35392, 35392)[2][2]", 745, 35392, 35441);
                            }
                        }
                    }
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1911.methodEnd();
        }
    }

    public Rotation toRotation() {
        MethodContext _bcornu_methode_context1912 = new MethodContext(Rotation.class, 754, 35474, 35700);
        try {
            CallChecker.varInit(this, "this", 754, 35474, 35700);
            CallChecker.varInit(this.q3, "q3", 754, 35474, 35700);
            CallChecker.varInit(this.q2, "q2", 754, 35474, 35700);
            CallChecker.varInit(this.q1, "q1", 754, 35474, 35700);
            CallChecker.varInit(this.q0, "q0", 754, 35474, 35700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 754, 35474, 35700);
            if (CallChecker.beforeDeref(q0, null, 755, 35632, 35633)) {
                if (CallChecker.beforeDeref(q1, null, 755, 35646, 35647)) {
                    if (CallChecker.beforeDeref(q2, null, 755, 35660, 35661)) {
                        if (CallChecker.beforeDeref(q3, null, 755, 35674, 35675)) {
                            return new Rotation(q0.getReal(), q1.getReal(), q2.getReal(), q3.getReal(), false);
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
            _bcornu_methode_context1912.methodEnd();
        }
    }

    public FieldVector3D<T> applyTo(final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context1913 = new MethodContext(FieldVector3D.class, 762, 35707, 36583);
        try {
            CallChecker.varInit(this, "this", 762, 35707, 36583);
            CallChecker.varInit(u, "u", 762, 35707, 36583);
            CallChecker.varInit(this.q3, "q3", 762, 35707, 36583);
            CallChecker.varInit(this.q2, "q2", 762, 35707, 36583);
            CallChecker.varInit(this.q1, "q1", 762, 35707, 36583);
            CallChecker.varInit(this.q0, "q0", 762, 35707, 36583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 762, 35707, 36583);
            final T x = CallChecker.varInit(u.getX(), "x", 764, 35940, 35960);
            final T y = CallChecker.varInit(u.getY(), "y", 765, 35970, 35990);
            final T z = CallChecker.varInit(u.getZ(), "z", 766, 36000, 36020);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 768, 36031, 36097);
            if (CallChecker.beforeDeref(x, null, 770, 36148, 36148)) {
                if (CallChecker.beforeDeref(q2, null, 770, 36172, 36173)) {
                    if (CallChecker.beforeDeref(q3, null, 770, 36196, 36197)) {
                        final RealFieldElement<T> npe_invocation_var345 = q2.multiply(z);
                        if (CallChecker.beforeDeref(npe_invocation_var345, RealFieldElement.class, 770, 36172, 36185)) {
                            final RealFieldElement<T> npe_invocation_var346 = x.multiply(q0);
                            if (CallChecker.beforeDeref(npe_invocation_var346, RealFieldElement.class, 770, 36148, 36161)) {
                                if (CallChecker.beforeDeref(q0, null, 770, 36136, 36137)) {
                                    if (CallChecker.beforeDeref(s, null, 770, 36218, 36218)) {
                                        final RealFieldElement<T> npe_invocation_var347 = q0.multiply(npe_invocation_var346.subtract(npe_invocation_var345.subtract(q3.multiply(y))));
                                        if (CallChecker.beforeDeref(npe_invocation_var347, RealFieldElement.class, 770, 36136, 36212)) {
                                            final RealFieldElement<T> npe_invocation_var348 = npe_invocation_var347.add(s.multiply(q1));
                                            if (CallChecker.beforeDeref(npe_invocation_var348, RealFieldElement.class, 770, 36136, 36232)) {
                                                final RealFieldElement<T> npe_invocation_var349 = npe_invocation_var348.multiply(2);
                                                if (CallChecker.beforeDeref(npe_invocation_var349, RealFieldElement.class, 770, 36136, 36244)) {
                                                    if (CallChecker.beforeDeref(y, null, 771, 36307, 36307)) {
                                                        if (CallChecker.beforeDeref(q3, null, 771, 36331, 36332)) {
                                                            if (CallChecker.beforeDeref(q1, null, 771, 36355, 36356)) {
                                                                final RealFieldElement<T> npe_invocation_var350 = q3.multiply(x);
                                                                if (CallChecker.beforeDeref(npe_invocation_var350, RealFieldElement.class, 771, 36331, 36344)) {
                                                                    final RealFieldElement<T> npe_invocation_var351 = y.multiply(q0);
                                                                    if (CallChecker.beforeDeref(npe_invocation_var351, RealFieldElement.class, 771, 36307, 36320)) {
                                                                        if (CallChecker.beforeDeref(q0, null, 771, 36295, 36296)) {
                                                                            if (CallChecker.beforeDeref(s, null, 771, 36377, 36377)) {
                                                                                final RealFieldElement<T> npe_invocation_var352 = q0.multiply(npe_invocation_var351.subtract(npe_invocation_var350.subtract(q1.multiply(z))));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var352, RealFieldElement.class, 771, 36295, 36371)) {
                                                                                    final RealFieldElement<T> npe_invocation_var353 = npe_invocation_var352.add(s.multiply(q2));
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var353, RealFieldElement.class, 771, 36295, 36391)) {
                                                                                        final RealFieldElement<T> npe_invocation_var354 = npe_invocation_var353.multiply(2);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var354, RealFieldElement.class, 771, 36295, 36403)) {
                                                                                            if (CallChecker.beforeDeref(z, null, 772, 36466, 36466)) {
                                                                                                if (CallChecker.beforeDeref(q1, null, 772, 36490, 36491)) {
                                                                                                    if (CallChecker.beforeDeref(q2, null, 772, 36514, 36515)) {
                                                                                                        final RealFieldElement<T> npe_invocation_var355 = q1.multiply(y);
                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var355, RealFieldElement.class, 772, 36490, 36503)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var356 = z.multiply(q0);
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var356, RealFieldElement.class, 772, 36466, 36479)) {
                                                                                                                if (CallChecker.beforeDeref(q0, null, 772, 36454, 36455)) {
                                                                                                                    if (CallChecker.beforeDeref(s, null, 772, 36536, 36536)) {
                                                                                                                        final RealFieldElement<T> npe_invocation_var357 = q0.multiply(npe_invocation_var356.subtract(npe_invocation_var355.subtract(q2.multiply(x))));
                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var357, RealFieldElement.class, 772, 36454, 36530)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var358 = npe_invocation_var357.add(s.multiply(q3));
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var358, RealFieldElement.class, 772, 36454, 36550)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var359 = npe_invocation_var358.multiply(2);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var359, RealFieldElement.class, 772, 36454, 36562)) {
                                                                                                                                    return new FieldVector3D<T>(npe_invocation_var349.subtract(x), npe_invocation_var354.subtract(y), npe_invocation_var359.subtract(z));
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1913.methodEnd();
        }
    }

    public FieldVector3D<T> applyTo(final Vector3D u) {
        MethodContext _bcornu_methode_context1914 = new MethodContext(FieldVector3D.class, 780, 36590, 37473);
        try {
            CallChecker.varInit(this, "this", 780, 36590, 37473);
            CallChecker.varInit(u, "u", 780, 36590, 37473);
            CallChecker.varInit(this.q3, "q3", 780, 36590, 37473);
            CallChecker.varInit(this.q2, "q2", 780, 36590, 37473);
            CallChecker.varInit(this.q1, "q1", 780, 36590, 37473);
            CallChecker.varInit(this.q0, "q0", 780, 36590, 37473);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 780, 36590, 37473);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 782, 36832, 36832).getX())), "x", 782, 36815, 36840);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 783, 36867, 36867).getY())), "y", 783, 36850, 36875);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 784, 36902, 36902).getZ())), "z", 784, 36885, 36910);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 786, 36921, 36987);
            if (CallChecker.beforeDeref(q0, null, 788, 37038, 37039)) {
                if (CallChecker.beforeDeref(q2, null, 788, 37062, 37063)) {
                    if (CallChecker.beforeDeref(q3, null, 788, 37086, 37087)) {
                        final RealFieldElement<T> npe_invocation_var360 = q2.multiply(z);
                        if (CallChecker.beforeDeref(npe_invocation_var360, RealFieldElement.class, 788, 37062, 37075)) {
                            final RealFieldElement<T> npe_invocation_var361 = q0.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var361, RealFieldElement.class, 788, 37038, 37051)) {
                                if (CallChecker.beforeDeref(q0, null, 788, 37026, 37027)) {
                                    if (CallChecker.beforeDeref(s, null, 788, 37108, 37108)) {
                                        final RealFieldElement<T> npe_invocation_var362 = q0.multiply(npe_invocation_var361.subtract(npe_invocation_var360.subtract(q3.multiply(y))));
                                        if (CallChecker.beforeDeref(npe_invocation_var362, RealFieldElement.class, 788, 37026, 37102)) {
                                            final RealFieldElement<T> npe_invocation_var363 = npe_invocation_var362.add(s.multiply(q1));
                                            if (CallChecker.beforeDeref(npe_invocation_var363, RealFieldElement.class, 788, 37026, 37122)) {
                                                final RealFieldElement<T> npe_invocation_var364 = npe_invocation_var363.multiply(2);
                                                if (CallChecker.beforeDeref(npe_invocation_var364, RealFieldElement.class, 788, 37026, 37134)) {
                                                    if (CallChecker.beforeDeref(q0, null, 789, 37197, 37198)) {
                                                        if (CallChecker.beforeDeref(q3, null, 789, 37221, 37222)) {
                                                            if (CallChecker.beforeDeref(q1, null, 789, 37245, 37246)) {
                                                                final RealFieldElement<T> npe_invocation_var365 = q3.multiply(x);
                                                                if (CallChecker.beforeDeref(npe_invocation_var365, RealFieldElement.class, 789, 37221, 37234)) {
                                                                    final RealFieldElement<T> npe_invocation_var366 = q0.multiply(y);
                                                                    if (CallChecker.beforeDeref(npe_invocation_var366, RealFieldElement.class, 789, 37197, 37210)) {
                                                                        if (CallChecker.beforeDeref(q0, null, 789, 37185, 37186)) {
                                                                            if (CallChecker.beforeDeref(s, null, 789, 37267, 37267)) {
                                                                                final RealFieldElement<T> npe_invocation_var367 = q0.multiply(npe_invocation_var366.subtract(npe_invocation_var365.subtract(q1.multiply(z))));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var367, RealFieldElement.class, 789, 37185, 37261)) {
                                                                                    final RealFieldElement<T> npe_invocation_var368 = npe_invocation_var367.add(s.multiply(q2));
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var368, RealFieldElement.class, 789, 37185, 37281)) {
                                                                                        final RealFieldElement<T> npe_invocation_var369 = npe_invocation_var368.multiply(2);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var369, RealFieldElement.class, 789, 37185, 37293)) {
                                                                                            if (CallChecker.beforeDeref(q0, null, 790, 37356, 37357)) {
                                                                                                if (CallChecker.beforeDeref(q1, null, 790, 37380, 37381)) {
                                                                                                    if (CallChecker.beforeDeref(q2, null, 790, 37404, 37405)) {
                                                                                                        final RealFieldElement<T> npe_invocation_var370 = q1.multiply(y);
                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var370, RealFieldElement.class, 790, 37380, 37393)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var371 = q0.multiply(z);
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var371, RealFieldElement.class, 790, 37356, 37369)) {
                                                                                                                if (CallChecker.beforeDeref(q0, null, 790, 37344, 37345)) {
                                                                                                                    if (CallChecker.beforeDeref(s, null, 790, 37426, 37426)) {
                                                                                                                        final RealFieldElement<T> npe_invocation_var372 = q0.multiply(npe_invocation_var371.subtract(npe_invocation_var370.subtract(q2.multiply(x))));
                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var372, RealFieldElement.class, 790, 37344, 37420)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var373 = npe_invocation_var372.add(s.multiply(q3));
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var373, RealFieldElement.class, 790, 37344, 37440)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var374 = npe_invocation_var373.multiply(2);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var374, RealFieldElement.class, 790, 37344, 37452)) {
                                                                                                                                    return new FieldVector3D<T>(npe_invocation_var364.subtract(x), npe_invocation_var369.subtract(y), npe_invocation_var374.subtract(z));
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1914.methodEnd();
        }
    }

    public void applyTo(final T[] in, final T[] out) {
        MethodContext _bcornu_methode_context1915 = new MethodContext(void.class, 799, 37480, 38357);
        try {
            CallChecker.varInit(this, "this", 799, 37480, 38357);
            CallChecker.varInit(out, "out", 799, 37480, 38357);
            CallChecker.varInit(in, "in", 799, 37480, 38357);
            CallChecker.varInit(this.q3, "q3", 799, 37480, 38357);
            CallChecker.varInit(this.q2, "q2", 799, 37480, 38357);
            CallChecker.varInit(this.q1, "q1", 799, 37480, 38357);
            CallChecker.varInit(this.q0, "q0", 799, 37480, 38357);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 799, 37480, 38357);
            final T x = CallChecker.varInit(in[0], "x", 801, 37781, 37798);
            final T y = CallChecker.varInit(in[1], "y", 802, 37808, 37825);
            final T z = CallChecker.varInit(in[2], "z", 803, 37835, 37852);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 805, 37863, 37929);
            if (CallChecker.beforeDeref(out, null, 807, 37940, 37942)) {
                if (CallChecker.beforeDeref(x, null, 807, 37961, 37961)) {
                    if (CallChecker.beforeDeref(q2, null, 807, 37985, 37986)) {
                        if (CallChecker.beforeDeref(q3, null, 807, 38009, 38010)) {
                            final RealFieldElement<T> npe_invocation_var375 = q2.multiply(z);
                            if (CallChecker.beforeDeref(npe_invocation_var375, RealFieldElement.class, 807, 37985, 37998)) {
                                final RealFieldElement<T> npe_invocation_var376 = x.multiply(q0);
                                if (CallChecker.beforeDeref(npe_invocation_var376, RealFieldElement.class, 807, 37961, 37974)) {
                                    if (CallChecker.beforeDeref(q0, null, 807, 37949, 37950)) {
                                        if (CallChecker.beforeDeref(s, null, 807, 38031, 38031)) {
                                            final RealFieldElement<T> npe_invocation_var377 = q0.multiply(npe_invocation_var376.subtract(npe_invocation_var375.subtract(q3.multiply(y))));
                                            if (CallChecker.beforeDeref(npe_invocation_var377, RealFieldElement.class, 807, 37949, 38025)) {
                                                final RealFieldElement<T> npe_invocation_var378 = npe_invocation_var377.add(s.multiply(q1));
                                                if (CallChecker.beforeDeref(npe_invocation_var378, RealFieldElement.class, 807, 37949, 38045)) {
                                                    final RealFieldElement<T> npe_invocation_var379 = npe_invocation_var378.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var379, RealFieldElement.class, 807, 37949, 38057)) {
                                                        out[0] = npe_invocation_var379.subtract(x);
                                                        CallChecker.varAssign(out[0], "out[0]", 807, 37940, 38070);
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
            if (CallChecker.beforeDeref(out, null, 808, 38080, 38082)) {
                if (CallChecker.beforeDeref(y, null, 808, 38101, 38101)) {
                    if (CallChecker.beforeDeref(q3, null, 808, 38125, 38126)) {
                        if (CallChecker.beforeDeref(q1, null, 808, 38149, 38150)) {
                            final RealFieldElement<T> npe_invocation_var380 = q3.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var380, RealFieldElement.class, 808, 38125, 38138)) {
                                final RealFieldElement<T> npe_invocation_var381 = y.multiply(q0);
                                if (CallChecker.beforeDeref(npe_invocation_var381, RealFieldElement.class, 808, 38101, 38114)) {
                                    if (CallChecker.beforeDeref(q0, null, 808, 38089, 38090)) {
                                        if (CallChecker.beforeDeref(s, null, 808, 38171, 38171)) {
                                            final RealFieldElement<T> npe_invocation_var382 = q0.multiply(npe_invocation_var381.subtract(npe_invocation_var380.subtract(q1.multiply(z))));
                                            if (CallChecker.beforeDeref(npe_invocation_var382, RealFieldElement.class, 808, 38089, 38165)) {
                                                final RealFieldElement<T> npe_invocation_var383 = npe_invocation_var382.add(s.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var383, RealFieldElement.class, 808, 38089, 38185)) {
                                                    final RealFieldElement<T> npe_invocation_var384 = npe_invocation_var383.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var384, RealFieldElement.class, 808, 38089, 38197)) {
                                                        out[1] = npe_invocation_var384.subtract(y);
                                                        CallChecker.varAssign(out[1], "out[1]", 808, 38080, 38210);
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
            if (CallChecker.beforeDeref(out, null, 809, 38220, 38222)) {
                if (CallChecker.beforeDeref(z, null, 809, 38241, 38241)) {
                    if (CallChecker.beforeDeref(q1, null, 809, 38265, 38266)) {
                        if (CallChecker.beforeDeref(q2, null, 809, 38289, 38290)) {
                            final RealFieldElement<T> npe_invocation_var385 = q1.multiply(y);
                            if (CallChecker.beforeDeref(npe_invocation_var385, RealFieldElement.class, 809, 38265, 38278)) {
                                final RealFieldElement<T> npe_invocation_var386 = z.multiply(q0);
                                if (CallChecker.beforeDeref(npe_invocation_var386, RealFieldElement.class, 809, 38241, 38254)) {
                                    if (CallChecker.beforeDeref(q0, null, 809, 38229, 38230)) {
                                        if (CallChecker.beforeDeref(s, null, 809, 38311, 38311)) {
                                            final RealFieldElement<T> npe_invocation_var387 = q0.multiply(npe_invocation_var386.subtract(npe_invocation_var385.subtract(q2.multiply(x))));
                                            if (CallChecker.beforeDeref(npe_invocation_var387, RealFieldElement.class, 809, 38229, 38305)) {
                                                final RealFieldElement<T> npe_invocation_var388 = npe_invocation_var387.add(s.multiply(q3));
                                                if (CallChecker.beforeDeref(npe_invocation_var388, RealFieldElement.class, 809, 38229, 38325)) {
                                                    final RealFieldElement<T> npe_invocation_var389 = npe_invocation_var388.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var389, RealFieldElement.class, 809, 38229, 38337)) {
                                                        out[2] = npe_invocation_var389.subtract(z);
                                                        CallChecker.varAssign(out[2], "out[2]", 809, 38220, 38350);
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1915.methodEnd();
        }
    }

    public void applyTo(final double[] in, final T[] out) {
        MethodContext _bcornu_methode_context1916 = new MethodContext(void.class, 817, 38364, 39221);
        try {
            CallChecker.varInit(this, "this", 817, 38364, 39221);
            CallChecker.varInit(out, "out", 817, 38364, 39221);
            CallChecker.varInit(in, "in", 817, 38364, 39221);
            CallChecker.varInit(this.q3, "q3", 817, 38364, 39221);
            CallChecker.varInit(this.q2, "q2", 817, 38364, 39221);
            CallChecker.varInit(this.q1, "q1", 817, 38364, 39221);
            CallChecker.varInit(this.q0, "q0", 817, 38364, 39221);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 817, 38364, 39221);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 819, 38647, 38648)[0])), "x", 819, 38630, 38652);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 820, 38679, 38680)[1])), "y", 820, 38662, 38684);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 821, 38711, 38712)[2])), "z", 821, 38694, 38716);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 823, 38727, 38793);
            if (CallChecker.beforeDeref(out, null, 825, 38804, 38806)) {
                if (CallChecker.beforeDeref(q0, null, 825, 38825, 38826)) {
                    if (CallChecker.beforeDeref(q2, null, 825, 38849, 38850)) {
                        if (CallChecker.beforeDeref(q3, null, 825, 38873, 38874)) {
                            final RealFieldElement<T> npe_invocation_var390 = q2.multiply(z);
                            if (CallChecker.beforeDeref(npe_invocation_var390, RealFieldElement.class, 825, 38849, 38862)) {
                                final RealFieldElement<T> npe_invocation_var391 = q0.multiply(x);
                                if (CallChecker.beforeDeref(npe_invocation_var391, RealFieldElement.class, 825, 38825, 38838)) {
                                    if (CallChecker.beforeDeref(q0, null, 825, 38813, 38814)) {
                                        if (CallChecker.beforeDeref(s, null, 825, 38895, 38895)) {
                                            final RealFieldElement<T> npe_invocation_var392 = q0.multiply(npe_invocation_var391.subtract(npe_invocation_var390.subtract(q3.multiply(y))));
                                            if (CallChecker.beforeDeref(npe_invocation_var392, RealFieldElement.class, 825, 38813, 38889)) {
                                                final RealFieldElement<T> npe_invocation_var393 = npe_invocation_var392.add(s.multiply(q1));
                                                if (CallChecker.beforeDeref(npe_invocation_var393, RealFieldElement.class, 825, 38813, 38909)) {
                                                    final RealFieldElement<T> npe_invocation_var394 = npe_invocation_var393.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var394, RealFieldElement.class, 825, 38813, 38921)) {
                                                        out[0] = npe_invocation_var394.subtract(x);
                                                        CallChecker.varAssign(out[0], "out[0]", 825, 38804, 38934);
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
            if (CallChecker.beforeDeref(out, null, 826, 38944, 38946)) {
                if (CallChecker.beforeDeref(q0, null, 826, 38965, 38966)) {
                    if (CallChecker.beforeDeref(q3, null, 826, 38989, 38990)) {
                        if (CallChecker.beforeDeref(q1, null, 826, 39013, 39014)) {
                            final RealFieldElement<T> npe_invocation_var395 = q3.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var395, RealFieldElement.class, 826, 38989, 39002)) {
                                final RealFieldElement<T> npe_invocation_var396 = q0.multiply(y);
                                if (CallChecker.beforeDeref(npe_invocation_var396, RealFieldElement.class, 826, 38965, 38978)) {
                                    if (CallChecker.beforeDeref(q0, null, 826, 38953, 38954)) {
                                        if (CallChecker.beforeDeref(s, null, 826, 39035, 39035)) {
                                            final RealFieldElement<T> npe_invocation_var397 = q0.multiply(npe_invocation_var396.subtract(npe_invocation_var395.subtract(q1.multiply(z))));
                                            if (CallChecker.beforeDeref(npe_invocation_var397, RealFieldElement.class, 826, 38953, 39029)) {
                                                final RealFieldElement<T> npe_invocation_var398 = npe_invocation_var397.add(s.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var398, RealFieldElement.class, 826, 38953, 39049)) {
                                                    final RealFieldElement<T> npe_invocation_var399 = npe_invocation_var398.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var399, RealFieldElement.class, 826, 38953, 39061)) {
                                                        out[1] = npe_invocation_var399.subtract(y);
                                                        CallChecker.varAssign(out[1], "out[1]", 826, 38944, 39074);
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
            if (CallChecker.beforeDeref(out, null, 827, 39084, 39086)) {
                if (CallChecker.beforeDeref(q0, null, 827, 39105, 39106)) {
                    if (CallChecker.beforeDeref(q1, null, 827, 39129, 39130)) {
                        if (CallChecker.beforeDeref(q2, null, 827, 39153, 39154)) {
                            final RealFieldElement<T> npe_invocation_var400 = q1.multiply(y);
                            if (CallChecker.beforeDeref(npe_invocation_var400, RealFieldElement.class, 827, 39129, 39142)) {
                                final RealFieldElement<T> npe_invocation_var401 = q0.multiply(z);
                                if (CallChecker.beforeDeref(npe_invocation_var401, RealFieldElement.class, 827, 39105, 39118)) {
                                    if (CallChecker.beforeDeref(q0, null, 827, 39093, 39094)) {
                                        if (CallChecker.beforeDeref(s, null, 827, 39175, 39175)) {
                                            final RealFieldElement<T> npe_invocation_var402 = q0.multiply(npe_invocation_var401.subtract(npe_invocation_var400.subtract(q2.multiply(x))));
                                            if (CallChecker.beforeDeref(npe_invocation_var402, RealFieldElement.class, 827, 39093, 39169)) {
                                                final RealFieldElement<T> npe_invocation_var403 = npe_invocation_var402.add(s.multiply(q3));
                                                if (CallChecker.beforeDeref(npe_invocation_var403, RealFieldElement.class, 827, 39093, 39189)) {
                                                    final RealFieldElement<T> npe_invocation_var404 = npe_invocation_var403.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var404, RealFieldElement.class, 827, 39093, 39201)) {
                                                        out[2] = npe_invocation_var404.subtract(z);
                                                        CallChecker.varAssign(out[2], "out[2]", 827, 39084, 39214);
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1916.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyTo(final Rotation r, final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context1917 = new MethodContext(FieldVector3D.class, 837, 39228, 40368);
        try {
            CallChecker.varInit(u, "u", 837, 39228, 40368);
            CallChecker.varInit(r, "r", 837, 39228, 40368);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 837, 39228, 40368);
            final T x = CallChecker.varInit(u.getX(), "x", 839, 39599, 39619);
            final T y = CallChecker.varInit(u.getY(), "y", 840, 39629, 39649);
            final T z = CallChecker.varInit(u.getZ(), "z", 841, 39659, 39679);
            final T s = CallChecker.varInit(x.multiply(CallChecker.isCalled(r, Rotation.class, 843, 39713, 39713).getQ1()).add(y.multiply(CallChecker.isCalled(r, Rotation.class, 843, 39739, 39739).getQ2())).add(z.multiply(CallChecker.isCalled(r, Rotation.class, 843, 39766, 39766).getQ3())), "s", 843, 39690, 39777);
            if (CallChecker.beforeDeref(r, Rotation.class, 845, 39827, 39827)) {
                if (CallChecker.beforeDeref(x, null, 845, 39816, 39816)) {
                    if (CallChecker.beforeDeref(r, Rotation.class, 845, 39858, 39858)) {
                        if (CallChecker.beforeDeref(z, null, 845, 39847, 39847)) {
                            if (CallChecker.beforeDeref(r, Rotation.class, 845, 39889, 39889)) {
                                if (CallChecker.beforeDeref(y, null, 845, 39878, 39878)) {
                                    final RealFieldElement<T> npe_invocation_var405 = z.multiply(CallChecker.isCalled(r, Rotation.class, 845, 39858, 39858).getQ2());
                                    if (CallChecker.beforeDeref(npe_invocation_var405, RealFieldElement.class, 845, 39847, 39867)) {
                                        final RealFieldElement<T> npe_invocation_var406 = x.multiply(CallChecker.isCalled(r, Rotation.class, 845, 39827, 39827).getQ0());
                                        if (CallChecker.beforeDeref(npe_invocation_var406, RealFieldElement.class, 845, 39816, 39836)) {
                                            if (CallChecker.beforeDeref(r, Rotation.class, 845, 39911, 39911)) {
                                                final RealFieldElement<T> npe_invocation_var407 = npe_invocation_var406.subtract(npe_invocation_var405.subtract(y.multiply(CallChecker.isCalled(r, Rotation.class, 845, 39889, 39889).getQ3())));
                                                if (CallChecker.beforeDeref(npe_invocation_var407, RealFieldElement.class, 845, 39816, 39900)) {
                                                    if (CallChecker.beforeDeref(r, Rotation.class, 845, 39937, 39937)) {
                                                        if (CallChecker.beforeDeref(s, null, 845, 39926, 39926)) {
                                                            final RealFieldElement<T> npe_invocation_var408 = npe_invocation_var407.multiply(CallChecker.isCalled(r, Rotation.class, 845, 39911, 39911).getQ0());
                                                            if (CallChecker.beforeDeref(npe_invocation_var408, RealFieldElement.class, 845, 39816, 39920)) {
                                                                final RealFieldElement<T> npe_invocation_var409 = npe_invocation_var408.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 845, 39937, 39937).getQ1()));
                                                                if (CallChecker.beforeDeref(npe_invocation_var409, RealFieldElement.class, 845, 39816, 39947)) {
                                                                    final RealFieldElement<T> npe_invocation_var410 = npe_invocation_var409.multiply(2);
                                                                    if (CallChecker.beforeDeref(npe_invocation_var410, RealFieldElement.class, 845, 39816, 39959)) {
                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 846, 40021, 40021)) {
                                                                            if (CallChecker.beforeDeref(y, null, 846, 40010, 40010)) {
                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 846, 40052, 40052)) {
                                                                                    if (CallChecker.beforeDeref(x, null, 846, 40041, 40041)) {
                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 846, 40083, 40083)) {
                                                                                            if (CallChecker.beforeDeref(z, null, 846, 40072, 40072)) {
                                                                                                final RealFieldElement<T> npe_invocation_var411 = x.multiply(CallChecker.isCalled(r, Rotation.class, 846, 40052, 40052).getQ3());
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var411, RealFieldElement.class, 846, 40041, 40061)) {
                                                                                                    final RealFieldElement<T> npe_invocation_var412 = y.multiply(CallChecker.isCalled(r, Rotation.class, 846, 40021, 40021).getQ0());
                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var412, RealFieldElement.class, 846, 40010, 40030)) {
                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 846, 40105, 40105)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var413 = npe_invocation_var412.subtract(npe_invocation_var411.subtract(z.multiply(CallChecker.isCalled(r, Rotation.class, 846, 40083, 40083).getQ1())));
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var413, RealFieldElement.class, 846, 40010, 40094)) {
                                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 846, 40131, 40131)) {
                                                                                                                    if (CallChecker.beforeDeref(s, null, 846, 40120, 40120)) {
                                                                                                                        final RealFieldElement<T> npe_invocation_var414 = npe_invocation_var413.multiply(CallChecker.isCalled(r, Rotation.class, 846, 40105, 40105).getQ0());
                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var414, RealFieldElement.class, 846, 40010, 40114)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var415 = npe_invocation_var414.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 846, 40131, 40131).getQ2()));
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var415, RealFieldElement.class, 846, 40010, 40141)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var416 = npe_invocation_var415.multiply(2);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var416, RealFieldElement.class, 846, 40010, 40153)) {
                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 847, 40215, 40215)) {
                                                                                                                                        if (CallChecker.beforeDeref(z, null, 847, 40204, 40204)) {
                                                                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 847, 40246, 40246)) {
                                                                                                                                                if (CallChecker.beforeDeref(y, null, 847, 40235, 40235)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 847, 40277, 40277)) {
                                                                                                                                                        if (CallChecker.beforeDeref(x, null, 847, 40266, 40266)) {
                                                                                                                                                            final RealFieldElement<T> npe_invocation_var417 = y.multiply(CallChecker.isCalled(r, Rotation.class, 847, 40246, 40246).getQ1());
                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var417, RealFieldElement.class, 847, 40235, 40255)) {
                                                                                                                                                                final RealFieldElement<T> npe_invocation_var418 = z.multiply(CallChecker.isCalled(r, Rotation.class, 847, 40215, 40215).getQ0());
                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var418, RealFieldElement.class, 847, 40204, 40224)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 847, 40299, 40299)) {
                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var419 = npe_invocation_var418.subtract(npe_invocation_var417.subtract(x.multiply(CallChecker.isCalled(r, Rotation.class, 847, 40277, 40277).getQ2())));
                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var419, RealFieldElement.class, 847, 40204, 40288)) {
                                                                                                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 847, 40325, 40325)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(s, null, 847, 40314, 40314)) {
                                                                                                                                                                                    final RealFieldElement<T> npe_invocation_var420 = npe_invocation_var419.multiply(CallChecker.isCalled(r, Rotation.class, 847, 40299, 40299).getQ0());
                                                                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var420, RealFieldElement.class, 847, 40204, 40308)) {
                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var421 = npe_invocation_var420.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 847, 40325, 40325).getQ3()));
                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var421, RealFieldElement.class, 847, 40204, 40335)) {
                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var422 = npe_invocation_var421.multiply(2);
                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var422, RealFieldElement.class, 847, 40204, 40347)) {
                                                                                                                                                                                                return new FieldVector3D<T>(npe_invocation_var410.subtract(x), npe_invocation_var416.subtract(y), npe_invocation_var422.subtract(z));
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
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1917.methodEnd();
        }
    }

    public FieldVector3D<T> applyInverseTo(final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context1918 = new MethodContext(FieldVector3D.class, 855, 40375, 41330);
        try {
            CallChecker.varInit(this, "this", 855, 40375, 41330);
            CallChecker.varInit(u, "u", 855, 40375, 41330);
            CallChecker.varInit(this.q3, "q3", 855, 40375, 41330);
            CallChecker.varInit(this.q2, "q2", 855, 40375, 41330);
            CallChecker.varInit(this.q1, "q1", 855, 40375, 41330);
            CallChecker.varInit(this.q0, "q0", 855, 40375, 41330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 855, 40375, 41330);
            final T x = CallChecker.varInit(u.getX(), "x", 857, 40652, 40672);
            final T y = CallChecker.varInit(u.getY(), "y", 858, 40682, 40702);
            final T z = CallChecker.varInit(u.getZ(), "z", 859, 40712, 40732);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 861, 40743, 40810);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 862, 40820, 40844);
            if (CallChecker.beforeDeref(x, null, 864, 40895, 40895)) {
                if (CallChecker.beforeDeref(q2, null, 864, 40919, 40920)) {
                    if (CallChecker.beforeDeref(q3, null, 864, 40943, 40944)) {
                        final RealFieldElement<T> npe_invocation_var423 = q2.multiply(z);
                        if (CallChecker.beforeDeref(npe_invocation_var423, RealFieldElement.class, 864, 40919, 40932)) {
                            final RealFieldElement<T> npe_invocation_var424 = x.multiply(m0);
                            if (CallChecker.beforeDeref(npe_invocation_var424, RealFieldElement.class, 864, 40895, 40908)) {
                                if (CallChecker.beforeDeref(m0, null, 864, 40883, 40884)) {
                                    if (CallChecker.beforeDeref(s, null, 864, 40965, 40965)) {
                                        final RealFieldElement<T> npe_invocation_var425 = m0.multiply(npe_invocation_var424.subtract(npe_invocation_var423.subtract(q3.multiply(y))));
                                        if (CallChecker.beforeDeref(npe_invocation_var425, RealFieldElement.class, 864, 40883, 40959)) {
                                            final RealFieldElement<T> npe_invocation_var426 = npe_invocation_var425.add(s.multiply(q1));
                                            if (CallChecker.beforeDeref(npe_invocation_var426, RealFieldElement.class, 864, 40883, 40979)) {
                                                final RealFieldElement<T> npe_invocation_var427 = npe_invocation_var426.multiply(2);
                                                if (CallChecker.beforeDeref(npe_invocation_var427, RealFieldElement.class, 864, 40883, 40991)) {
                                                    if (CallChecker.beforeDeref(y, null, 865, 41054, 41054)) {
                                                        if (CallChecker.beforeDeref(q3, null, 865, 41078, 41079)) {
                                                            if (CallChecker.beforeDeref(q1, null, 865, 41102, 41103)) {
                                                                final RealFieldElement<T> npe_invocation_var428 = q3.multiply(x);
                                                                if (CallChecker.beforeDeref(npe_invocation_var428, RealFieldElement.class, 865, 41078, 41091)) {
                                                                    final RealFieldElement<T> npe_invocation_var429 = y.multiply(m0);
                                                                    if (CallChecker.beforeDeref(npe_invocation_var429, RealFieldElement.class, 865, 41054, 41067)) {
                                                                        if (CallChecker.beforeDeref(m0, null, 865, 41042, 41043)) {
                                                                            if (CallChecker.beforeDeref(s, null, 865, 41124, 41124)) {
                                                                                final RealFieldElement<T> npe_invocation_var430 = m0.multiply(npe_invocation_var429.subtract(npe_invocation_var428.subtract(q1.multiply(z))));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var430, RealFieldElement.class, 865, 41042, 41118)) {
                                                                                    final RealFieldElement<T> npe_invocation_var431 = npe_invocation_var430.add(s.multiply(q2));
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var431, RealFieldElement.class, 865, 41042, 41138)) {
                                                                                        final RealFieldElement<T> npe_invocation_var432 = npe_invocation_var431.multiply(2);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var432, RealFieldElement.class, 865, 41042, 41150)) {
                                                                                            if (CallChecker.beforeDeref(z, null, 866, 41213, 41213)) {
                                                                                                if (CallChecker.beforeDeref(q1, null, 866, 41237, 41238)) {
                                                                                                    if (CallChecker.beforeDeref(q2, null, 866, 41261, 41262)) {
                                                                                                        final RealFieldElement<T> npe_invocation_var433 = q1.multiply(y);
                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var433, RealFieldElement.class, 866, 41237, 41250)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var434 = z.multiply(m0);
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var434, RealFieldElement.class, 866, 41213, 41226)) {
                                                                                                                if (CallChecker.beforeDeref(m0, null, 866, 41201, 41202)) {
                                                                                                                    if (CallChecker.beforeDeref(s, null, 866, 41283, 41283)) {
                                                                                                                        final RealFieldElement<T> npe_invocation_var435 = m0.multiply(npe_invocation_var434.subtract(npe_invocation_var433.subtract(q2.multiply(x))));
                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var435, RealFieldElement.class, 866, 41201, 41277)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var436 = npe_invocation_var435.add(s.multiply(q3));
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var436, RealFieldElement.class, 866, 41201, 41297)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var437 = npe_invocation_var436.multiply(2);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var437, RealFieldElement.class, 866, 41201, 41309)) {
                                                                                                                                    return new FieldVector3D<T>(npe_invocation_var427.subtract(x), npe_invocation_var432.subtract(y), npe_invocation_var437.subtract(z));
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1918.methodEnd();
        }
    }

    public FieldVector3D<T> applyInverseTo(final Vector3D u) {
        MethodContext _bcornu_methode_context1919 = new MethodContext(FieldVector3D.class, 874, 41337, 42299);
        try {
            CallChecker.varInit(this, "this", 874, 41337, 42299);
            CallChecker.varInit(u, "u", 874, 41337, 42299);
            CallChecker.varInit(this.q3, "q3", 874, 41337, 42299);
            CallChecker.varInit(this.q2, "q2", 874, 41337, 42299);
            CallChecker.varInit(this.q1, "q1", 874, 41337, 42299);
            CallChecker.varInit(this.q0, "q0", 874, 41337, 42299);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 874, 41337, 42299);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 876, 41623, 41623).getX())), "x", 876, 41606, 41631);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 877, 41658, 41658).getY())), "y", 877, 41641, 41666);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(u, Vector3D.class, 878, 41693, 41693).getZ())), "z", 878, 41676, 41701);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 880, 41712, 41779);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 881, 41789, 41813);
            if (CallChecker.beforeDeref(m0, null, 883, 41864, 41865)) {
                if (CallChecker.beforeDeref(q2, null, 883, 41888, 41889)) {
                    if (CallChecker.beforeDeref(q3, null, 883, 41912, 41913)) {
                        final RealFieldElement<T> npe_invocation_var438 = q2.multiply(z);
                        if (CallChecker.beforeDeref(npe_invocation_var438, RealFieldElement.class, 883, 41888, 41901)) {
                            final RealFieldElement<T> npe_invocation_var439 = m0.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var439, RealFieldElement.class, 883, 41864, 41877)) {
                                if (CallChecker.beforeDeref(m0, null, 883, 41852, 41853)) {
                                    if (CallChecker.beforeDeref(s, null, 883, 41934, 41934)) {
                                        final RealFieldElement<T> npe_invocation_var440 = m0.multiply(npe_invocation_var439.subtract(npe_invocation_var438.subtract(q3.multiply(y))));
                                        if (CallChecker.beforeDeref(npe_invocation_var440, RealFieldElement.class, 883, 41852, 41928)) {
                                            final RealFieldElement<T> npe_invocation_var441 = npe_invocation_var440.add(s.multiply(q1));
                                            if (CallChecker.beforeDeref(npe_invocation_var441, RealFieldElement.class, 883, 41852, 41948)) {
                                                final RealFieldElement<T> npe_invocation_var442 = npe_invocation_var441.multiply(2);
                                                if (CallChecker.beforeDeref(npe_invocation_var442, RealFieldElement.class, 883, 41852, 41960)) {
                                                    if (CallChecker.beforeDeref(m0, null, 884, 42023, 42024)) {
                                                        if (CallChecker.beforeDeref(q3, null, 884, 42047, 42048)) {
                                                            if (CallChecker.beforeDeref(q1, null, 884, 42071, 42072)) {
                                                                final RealFieldElement<T> npe_invocation_var443 = q3.multiply(x);
                                                                if (CallChecker.beforeDeref(npe_invocation_var443, RealFieldElement.class, 884, 42047, 42060)) {
                                                                    final RealFieldElement<T> npe_invocation_var444 = m0.multiply(y);
                                                                    if (CallChecker.beforeDeref(npe_invocation_var444, RealFieldElement.class, 884, 42023, 42036)) {
                                                                        if (CallChecker.beforeDeref(m0, null, 884, 42011, 42012)) {
                                                                            if (CallChecker.beforeDeref(s, null, 884, 42093, 42093)) {
                                                                                final RealFieldElement<T> npe_invocation_var445 = m0.multiply(npe_invocation_var444.subtract(npe_invocation_var443.subtract(q1.multiply(z))));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var445, RealFieldElement.class, 884, 42011, 42087)) {
                                                                                    final RealFieldElement<T> npe_invocation_var446 = npe_invocation_var445.add(s.multiply(q2));
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var446, RealFieldElement.class, 884, 42011, 42107)) {
                                                                                        final RealFieldElement<T> npe_invocation_var447 = npe_invocation_var446.multiply(2);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var447, RealFieldElement.class, 884, 42011, 42119)) {
                                                                                            if (CallChecker.beforeDeref(m0, null, 885, 42182, 42183)) {
                                                                                                if (CallChecker.beforeDeref(q1, null, 885, 42206, 42207)) {
                                                                                                    if (CallChecker.beforeDeref(q2, null, 885, 42230, 42231)) {
                                                                                                        final RealFieldElement<T> npe_invocation_var448 = q1.multiply(y);
                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var448, RealFieldElement.class, 885, 42206, 42219)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var449 = m0.multiply(z);
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var449, RealFieldElement.class, 885, 42182, 42195)) {
                                                                                                                if (CallChecker.beforeDeref(m0, null, 885, 42170, 42171)) {
                                                                                                                    if (CallChecker.beforeDeref(s, null, 885, 42252, 42252)) {
                                                                                                                        final RealFieldElement<T> npe_invocation_var450 = m0.multiply(npe_invocation_var449.subtract(npe_invocation_var448.subtract(q2.multiply(x))));
                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var450, RealFieldElement.class, 885, 42170, 42246)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var451 = npe_invocation_var450.add(s.multiply(q3));
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var451, RealFieldElement.class, 885, 42170, 42266)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var452 = npe_invocation_var451.multiply(2);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var452, RealFieldElement.class, 885, 42170, 42278)) {
                                                                                                                                    return new FieldVector3D<T>(npe_invocation_var442.subtract(x), npe_invocation_var447.subtract(y), npe_invocation_var452.subtract(z));
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1919.methodEnd();
        }
    }

    public void applyInverseTo(final T[] in, final T[] out) {
        MethodContext _bcornu_methode_context1920 = new MethodContext(void.class, 894, 42306, 43239);
        try {
            CallChecker.varInit(this, "this", 894, 42306, 43239);
            CallChecker.varInit(out, "out", 894, 42306, 43239);
            CallChecker.varInit(in, "in", 894, 42306, 43239);
            CallChecker.varInit(this.q3, "q3", 894, 42306, 43239);
            CallChecker.varInit(this.q2, "q2", 894, 42306, 43239);
            CallChecker.varInit(this.q1, "q1", 894, 42306, 43239);
            CallChecker.varInit(this.q0, "q0", 894, 42306, 43239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 894, 42306, 43239);
            final T x = CallChecker.varInit(in[0], "x", 896, 42629, 42646);
            final T y = CallChecker.varInit(in[1], "y", 897, 42656, 42673);
            final T z = CallChecker.varInit(in[2], "z", 898, 42683, 42700);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 900, 42711, 42777);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 901, 42787, 42811);
            if (CallChecker.beforeDeref(out, null, 903, 42822, 42824)) {
                if (CallChecker.beforeDeref(x, null, 903, 42843, 42843)) {
                    if (CallChecker.beforeDeref(q2, null, 903, 42867, 42868)) {
                        if (CallChecker.beforeDeref(q3, null, 903, 42891, 42892)) {
                            final RealFieldElement<T> npe_invocation_var453 = q2.multiply(z);
                            if (CallChecker.beforeDeref(npe_invocation_var453, RealFieldElement.class, 903, 42867, 42880)) {
                                final RealFieldElement<T> npe_invocation_var454 = x.multiply(m0);
                                if (CallChecker.beforeDeref(npe_invocation_var454, RealFieldElement.class, 903, 42843, 42856)) {
                                    if (CallChecker.beforeDeref(m0, null, 903, 42831, 42832)) {
                                        if (CallChecker.beforeDeref(s, null, 903, 42913, 42913)) {
                                            final RealFieldElement<T> npe_invocation_var455 = m0.multiply(npe_invocation_var454.subtract(npe_invocation_var453.subtract(q3.multiply(y))));
                                            if (CallChecker.beforeDeref(npe_invocation_var455, RealFieldElement.class, 903, 42831, 42907)) {
                                                final RealFieldElement<T> npe_invocation_var456 = npe_invocation_var455.add(s.multiply(q1));
                                                if (CallChecker.beforeDeref(npe_invocation_var456, RealFieldElement.class, 903, 42831, 42927)) {
                                                    final RealFieldElement<T> npe_invocation_var457 = npe_invocation_var456.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var457, RealFieldElement.class, 903, 42831, 42939)) {
                                                        out[0] = npe_invocation_var457.subtract(x);
                                                        CallChecker.varAssign(out[0], "out[0]", 903, 42822, 42952);
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
            if (CallChecker.beforeDeref(out, null, 904, 42962, 42964)) {
                if (CallChecker.beforeDeref(y, null, 904, 42983, 42983)) {
                    if (CallChecker.beforeDeref(q3, null, 904, 43007, 43008)) {
                        if (CallChecker.beforeDeref(q1, null, 904, 43031, 43032)) {
                            final RealFieldElement<T> npe_invocation_var458 = q3.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var458, RealFieldElement.class, 904, 43007, 43020)) {
                                final RealFieldElement<T> npe_invocation_var459 = y.multiply(m0);
                                if (CallChecker.beforeDeref(npe_invocation_var459, RealFieldElement.class, 904, 42983, 42996)) {
                                    if (CallChecker.beforeDeref(m0, null, 904, 42971, 42972)) {
                                        if (CallChecker.beforeDeref(s, null, 904, 43053, 43053)) {
                                            final RealFieldElement<T> npe_invocation_var460 = m0.multiply(npe_invocation_var459.subtract(npe_invocation_var458.subtract(q1.multiply(z))));
                                            if (CallChecker.beforeDeref(npe_invocation_var460, RealFieldElement.class, 904, 42971, 43047)) {
                                                final RealFieldElement<T> npe_invocation_var461 = npe_invocation_var460.add(s.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var461, RealFieldElement.class, 904, 42971, 43067)) {
                                                    final RealFieldElement<T> npe_invocation_var462 = npe_invocation_var461.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var462, RealFieldElement.class, 904, 42971, 43079)) {
                                                        out[1] = npe_invocation_var462.subtract(y);
                                                        CallChecker.varAssign(out[1], "out[1]", 904, 42962, 43092);
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
            if (CallChecker.beforeDeref(out, null, 905, 43102, 43104)) {
                if (CallChecker.beforeDeref(z, null, 905, 43123, 43123)) {
                    if (CallChecker.beforeDeref(q1, null, 905, 43147, 43148)) {
                        if (CallChecker.beforeDeref(q2, null, 905, 43171, 43172)) {
                            final RealFieldElement<T> npe_invocation_var463 = q1.multiply(y);
                            if (CallChecker.beforeDeref(npe_invocation_var463, RealFieldElement.class, 905, 43147, 43160)) {
                                final RealFieldElement<T> npe_invocation_var464 = z.multiply(m0);
                                if (CallChecker.beforeDeref(npe_invocation_var464, RealFieldElement.class, 905, 43123, 43136)) {
                                    if (CallChecker.beforeDeref(m0, null, 905, 43111, 43112)) {
                                        if (CallChecker.beforeDeref(s, null, 905, 43193, 43193)) {
                                            final RealFieldElement<T> npe_invocation_var465 = m0.multiply(npe_invocation_var464.subtract(npe_invocation_var463.subtract(q2.multiply(x))));
                                            if (CallChecker.beforeDeref(npe_invocation_var465, RealFieldElement.class, 905, 43111, 43187)) {
                                                final RealFieldElement<T> npe_invocation_var466 = npe_invocation_var465.add(s.multiply(q3));
                                                if (CallChecker.beforeDeref(npe_invocation_var466, RealFieldElement.class, 905, 43111, 43207)) {
                                                    final RealFieldElement<T> npe_invocation_var467 = npe_invocation_var466.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var467, RealFieldElement.class, 905, 43111, 43219)) {
                                                        out[2] = npe_invocation_var467.subtract(z);
                                                        CallChecker.varAssign(out[2], "out[2]", 905, 43102, 43232);
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1920.methodEnd();
        }
    }

    public void applyInverseTo(final double[] in, final T[] out) {
        MethodContext _bcornu_methode_context1921 = new MethodContext(void.class, 913, 43246, 44159);
        try {
            CallChecker.varInit(this, "this", 913, 43246, 44159);
            CallChecker.varInit(out, "out", 913, 43246, 44159);
            CallChecker.varInit(in, "in", 913, 43246, 44159);
            CallChecker.varInit(this.q3, "q3", 913, 43246, 44159);
            CallChecker.varInit(this.q2, "q2", 913, 43246, 44159);
            CallChecker.varInit(this.q1, "q1", 913, 43246, 44159);
            CallChecker.varInit(this.q0, "q0", 913, 43246, 44159);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 913, 43246, 44159);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 915, 43551, 43552)[0])), "x", 915, 43534, 43556);
            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 916, 43583, 43584)[1])), "y", 916, 43566, 43588);
            final double z = CallChecker.varInit(((double) (CallChecker.isCalled(in, double[].class, 917, 43615, 43616)[2])), "z", 917, 43598, 43620);
            final T s = CallChecker.varInit(q1.multiply(x).add(q2.multiply(y)).add(q3.multiply(z)), "s", 919, 43631, 43697);
            final T m0 = CallChecker.varInit(q0.negate(), "m0", 920, 43707, 43731);
            if (CallChecker.beforeDeref(out, null, 922, 43742, 43744)) {
                if (CallChecker.beforeDeref(m0, null, 922, 43763, 43764)) {
                    if (CallChecker.beforeDeref(q2, null, 922, 43787, 43788)) {
                        if (CallChecker.beforeDeref(q3, null, 922, 43811, 43812)) {
                            final RealFieldElement<T> npe_invocation_var468 = q2.multiply(z);
                            if (CallChecker.beforeDeref(npe_invocation_var468, RealFieldElement.class, 922, 43787, 43800)) {
                                final RealFieldElement<T> npe_invocation_var469 = m0.multiply(x);
                                if (CallChecker.beforeDeref(npe_invocation_var469, RealFieldElement.class, 922, 43763, 43776)) {
                                    if (CallChecker.beforeDeref(m0, null, 922, 43751, 43752)) {
                                        if (CallChecker.beforeDeref(s, null, 922, 43833, 43833)) {
                                            final RealFieldElement<T> npe_invocation_var470 = m0.multiply(npe_invocation_var469.subtract(npe_invocation_var468.subtract(q3.multiply(y))));
                                            if (CallChecker.beforeDeref(npe_invocation_var470, RealFieldElement.class, 922, 43751, 43827)) {
                                                final RealFieldElement<T> npe_invocation_var471 = npe_invocation_var470.add(s.multiply(q1));
                                                if (CallChecker.beforeDeref(npe_invocation_var471, RealFieldElement.class, 922, 43751, 43847)) {
                                                    final RealFieldElement<T> npe_invocation_var472 = npe_invocation_var471.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var472, RealFieldElement.class, 922, 43751, 43859)) {
                                                        out[0] = npe_invocation_var472.subtract(x);
                                                        CallChecker.varAssign(out[0], "out[0]", 922, 43742, 43872);
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
            if (CallChecker.beforeDeref(out, null, 923, 43882, 43884)) {
                if (CallChecker.beforeDeref(m0, null, 923, 43903, 43904)) {
                    if (CallChecker.beforeDeref(q3, null, 923, 43927, 43928)) {
                        if (CallChecker.beforeDeref(q1, null, 923, 43951, 43952)) {
                            final RealFieldElement<T> npe_invocation_var473 = q3.multiply(x);
                            if (CallChecker.beforeDeref(npe_invocation_var473, RealFieldElement.class, 923, 43927, 43940)) {
                                final RealFieldElement<T> npe_invocation_var474 = m0.multiply(y);
                                if (CallChecker.beforeDeref(npe_invocation_var474, RealFieldElement.class, 923, 43903, 43916)) {
                                    if (CallChecker.beforeDeref(m0, null, 923, 43891, 43892)) {
                                        if (CallChecker.beforeDeref(s, null, 923, 43973, 43973)) {
                                            final RealFieldElement<T> npe_invocation_var475 = m0.multiply(npe_invocation_var474.subtract(npe_invocation_var473.subtract(q1.multiply(z))));
                                            if (CallChecker.beforeDeref(npe_invocation_var475, RealFieldElement.class, 923, 43891, 43967)) {
                                                final RealFieldElement<T> npe_invocation_var476 = npe_invocation_var475.add(s.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var476, RealFieldElement.class, 923, 43891, 43987)) {
                                                    final RealFieldElement<T> npe_invocation_var477 = npe_invocation_var476.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var477, RealFieldElement.class, 923, 43891, 43999)) {
                                                        out[1] = npe_invocation_var477.subtract(y);
                                                        CallChecker.varAssign(out[1], "out[1]", 923, 43882, 44012);
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
            if (CallChecker.beforeDeref(out, null, 924, 44022, 44024)) {
                if (CallChecker.beforeDeref(m0, null, 924, 44043, 44044)) {
                    if (CallChecker.beforeDeref(q1, null, 924, 44067, 44068)) {
                        if (CallChecker.beforeDeref(q2, null, 924, 44091, 44092)) {
                            final RealFieldElement<T> npe_invocation_var478 = q1.multiply(y);
                            if (CallChecker.beforeDeref(npe_invocation_var478, RealFieldElement.class, 924, 44067, 44080)) {
                                final RealFieldElement<T> npe_invocation_var479 = m0.multiply(z);
                                if (CallChecker.beforeDeref(npe_invocation_var479, RealFieldElement.class, 924, 44043, 44056)) {
                                    if (CallChecker.beforeDeref(m0, null, 924, 44031, 44032)) {
                                        if (CallChecker.beforeDeref(s, null, 924, 44113, 44113)) {
                                            final RealFieldElement<T> npe_invocation_var480 = m0.multiply(npe_invocation_var479.subtract(npe_invocation_var478.subtract(q2.multiply(x))));
                                            if (CallChecker.beforeDeref(npe_invocation_var480, RealFieldElement.class, 924, 44031, 44107)) {
                                                final RealFieldElement<T> npe_invocation_var481 = npe_invocation_var480.add(s.multiply(q3));
                                                if (CallChecker.beforeDeref(npe_invocation_var481, RealFieldElement.class, 924, 44031, 44127)) {
                                                    final RealFieldElement<T> npe_invocation_var482 = npe_invocation_var481.multiply(2);
                                                    if (CallChecker.beforeDeref(npe_invocation_var482, RealFieldElement.class, 924, 44031, 44139)) {
                                                        out[2] = npe_invocation_var482.subtract(z);
                                                        CallChecker.varAssign(out[2], "out[2]", 924, 44022, 44152);
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1921.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyInverseTo(final Rotation r, final FieldVector3D<T> u) {
        MethodContext _bcornu_methode_context1922 = new MethodContext(FieldVector3D.class, 934, 44166, 45347);
        try {
            CallChecker.varInit(u, "u", 934, 44166, 45347);
            CallChecker.varInit(r, "r", 934, 44166, 45347);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 934, 44166, 45347);
            final T x = CallChecker.varInit(u.getX(), "x", 936, 44581, 44601);
            final T y = CallChecker.varInit(u.getY(), "y", 937, 44611, 44631);
            final T z = CallChecker.varInit(u.getZ(), "z", 938, 44641, 44661);
            final T s = CallChecker.varInit(x.multiply(CallChecker.isCalled(r, Rotation.class, 940, 44696, 44696).getQ1()).add(y.multiply(CallChecker.isCalled(r, Rotation.class, 940, 44722, 44722).getQ2())).add(z.multiply(CallChecker.isCalled(r, Rotation.class, 940, 44749, 44749).getQ3())), "s", 940, 44672, 44760);
            final double m0 = CallChecker.varInit(((double) (-(CallChecker.isCalled(r, Rotation.class, 941, 44789, 44789).getQ0()))), "m0", 941, 44770, 44798);
            if (CallChecker.beforeDeref(x, null, 943, 44837, 44837)) {
                if (CallChecker.beforeDeref(r, Rotation.class, 943, 44872, 44872)) {
                    if (CallChecker.beforeDeref(z, null, 943, 44861, 44861)) {
                        if (CallChecker.beforeDeref(r, Rotation.class, 943, 44903, 44903)) {
                            if (CallChecker.beforeDeref(y, null, 943, 44892, 44892)) {
                                final RealFieldElement<T> npe_invocation_var483 = z.multiply(CallChecker.isCalled(r, Rotation.class, 943, 44872, 44872).getQ2());
                                if (CallChecker.beforeDeref(npe_invocation_var483, RealFieldElement.class, 943, 44861, 44881)) {
                                    final RealFieldElement<T> npe_invocation_var484 = x.multiply(m0);
                                    if (CallChecker.beforeDeref(npe_invocation_var484, RealFieldElement.class, 943, 44837, 44850)) {
                                        final RealFieldElement<T> npe_invocation_var485 = npe_invocation_var484.subtract(npe_invocation_var483.subtract(y.multiply(CallChecker.isCalled(r, Rotation.class, 943, 44903, 44903).getQ3())));
                                        if (CallChecker.beforeDeref(npe_invocation_var485, RealFieldElement.class, 943, 44837, 44914)) {
                                            if (CallChecker.beforeDeref(r, Rotation.class, 943, 44944, 44944)) {
                                                if (CallChecker.beforeDeref(s, null, 943, 44933, 44933)) {
                                                    final RealFieldElement<T> npe_invocation_var486 = npe_invocation_var485.multiply(m0);
                                                    if (CallChecker.beforeDeref(npe_invocation_var486, RealFieldElement.class, 943, 44837, 44927)) {
                                                        final RealFieldElement<T> npe_invocation_var487 = npe_invocation_var486.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 943, 44944, 44944).getQ1()));
                                                        if (CallChecker.beforeDeref(npe_invocation_var487, RealFieldElement.class, 943, 44837, 44954)) {
                                                            final RealFieldElement<T> npe_invocation_var488 = npe_invocation_var487.multiply(2);
                                                            if (CallChecker.beforeDeref(npe_invocation_var488, RealFieldElement.class, 943, 44837, 44966)) {
                                                                if (CallChecker.beforeDeref(y, null, 944, 45017, 45017)) {
                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 944, 45052, 45052)) {
                                                                        if (CallChecker.beforeDeref(x, null, 944, 45041, 45041)) {
                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 944, 45083, 45083)) {
                                                                                if (CallChecker.beforeDeref(z, null, 944, 45072, 45072)) {
                                                                                    final RealFieldElement<T> npe_invocation_var489 = x.multiply(CallChecker.isCalled(r, Rotation.class, 944, 45052, 45052).getQ3());
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var489, RealFieldElement.class, 944, 45041, 45061)) {
                                                                                        final RealFieldElement<T> npe_invocation_var490 = y.multiply(m0);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var490, RealFieldElement.class, 944, 45017, 45030)) {
                                                                                            final RealFieldElement<T> npe_invocation_var491 = npe_invocation_var490.subtract(npe_invocation_var489.subtract(z.multiply(CallChecker.isCalled(r, Rotation.class, 944, 45083, 45083).getQ1())));
                                                                                            if (CallChecker.beforeDeref(npe_invocation_var491, RealFieldElement.class, 944, 45017, 45094)) {
                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 944, 45124, 45124)) {
                                                                                                    if (CallChecker.beforeDeref(s, null, 944, 45113, 45113)) {
                                                                                                        final RealFieldElement<T> npe_invocation_var492 = npe_invocation_var491.multiply(m0);
                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var492, RealFieldElement.class, 944, 45017, 45107)) {
                                                                                                            final RealFieldElement<T> npe_invocation_var493 = npe_invocation_var492.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 944, 45124, 45124).getQ2()));
                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var493, RealFieldElement.class, 944, 45017, 45134)) {
                                                                                                                final RealFieldElement<T> npe_invocation_var494 = npe_invocation_var493.multiply(2);
                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var494, RealFieldElement.class, 944, 45017, 45146)) {
                                                                                                                    if (CallChecker.beforeDeref(z, null, 945, 45197, 45197)) {
                                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 945, 45232, 45232)) {
                                                                                                                            if (CallChecker.beforeDeref(y, null, 945, 45221, 45221)) {
                                                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 945, 45263, 45263)) {
                                                                                                                                    if (CallChecker.beforeDeref(x, null, 945, 45252, 45252)) {
                                                                                                                                        final RealFieldElement<T> npe_invocation_var495 = y.multiply(CallChecker.isCalled(r, Rotation.class, 945, 45232, 45232).getQ1());
                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var495, RealFieldElement.class, 945, 45221, 45241)) {
                                                                                                                                            final RealFieldElement<T> npe_invocation_var496 = z.multiply(m0);
                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var496, RealFieldElement.class, 945, 45197, 45210)) {
                                                                                                                                                final RealFieldElement<T> npe_invocation_var497 = npe_invocation_var496.subtract(npe_invocation_var495.subtract(x.multiply(CallChecker.isCalled(r, Rotation.class, 945, 45263, 45263).getQ2())));
                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var497, RealFieldElement.class, 945, 45197, 45274)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 945, 45304, 45304)) {
                                                                                                                                                        if (CallChecker.beforeDeref(s, null, 945, 45293, 45293)) {
                                                                                                                                                            final RealFieldElement<T> npe_invocation_var498 = npe_invocation_var497.multiply(m0);
                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var498, RealFieldElement.class, 945, 45197, 45287)) {
                                                                                                                                                                final RealFieldElement<T> npe_invocation_var499 = npe_invocation_var498.add(s.multiply(CallChecker.isCalled(r, Rotation.class, 945, 45304, 45304).getQ3()));
                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var499, RealFieldElement.class, 945, 45197, 45314)) {
                                                                                                                                                                    final RealFieldElement<T> npe_invocation_var500 = npe_invocation_var499.multiply(2);
                                                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var500, RealFieldElement.class, 945, 45197, 45326)) {
                                                                                                                                                                        return new FieldVector3D<T>(npe_invocation_var488.subtract(x), npe_invocation_var494.subtract(y), npe_invocation_var500.subtract(z));
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1922.methodEnd();
        }
    }

    public FieldRotation<T> applyTo(final FieldRotation<T> r) {
        MethodContext _bcornu_methode_context1923 = new MethodContext(FieldRotation.class, 958, 45354, 46488);
        try {
            CallChecker.varInit(this, "this", 958, 45354, 46488);
            CallChecker.varInit(r, "r", 958, 45354, 46488);
            CallChecker.varInit(this.q3, "q3", 958, 45354, 46488);
            CallChecker.varInit(this.q2, "q2", 958, 45354, 46488);
            CallChecker.varInit(this.q1, "q1", 958, 45354, 46488);
            CallChecker.varInit(this.q0, "q0", 958, 45354, 46488);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 958, 45354, 46488);
            if (CallChecker.beforeDeref(r, FieldRotation.class, 959, 45960, 45960)) {
                if (CallChecker.beforeDeref(r.q0, null, 959, 45960, 45963)) {
                    if (CallChecker.beforeDeref(r, FieldRotation.class, 959, 45987, 45987)) {
                        if (CallChecker.beforeDeref(r.q1, null, 959, 45987, 45990)) {
                            if (CallChecker.beforeDeref(r, FieldRotation.class, 959, 46009, 46009)) {
                                if (CallChecker.beforeDeref(r.q2, null, 959, 46009, 46012)) {
                                    final RealFieldElement<T> npe_invocation_var501 = r.q1.multiply(q1);
                                    if (CallChecker.beforeDeref(npe_invocation_var501, RealFieldElement.class, 959, 45987, 46003)) {
                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 959, 46032, 46032)) {
                                            if (CallChecker.beforeDeref(r.q3, null, 959, 46032, 46035)) {
                                                final RealFieldElement<T> npe_invocation_var502 = npe_invocation_var501.add(r.q2.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var502, RealFieldElement.class, 959, 45987, 46026)) {
                                                    final RealFieldElement<T> npe_invocation_var503 = r.q0.multiply(q0);
                                                    if (CallChecker.beforeDeref(npe_invocation_var503, RealFieldElement.class, 959, 45960, 45976)) {
                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 960, 46089, 46089)) {
                                                            if (CallChecker.beforeDeref(r.q1, null, 960, 46089, 46092)) {
                                                                if (CallChecker.beforeDeref(r, FieldRotation.class, 960, 46111, 46111)) {
                                                                    if (CallChecker.beforeDeref(r.q0, null, 960, 46111, 46114)) {
                                                                        final RealFieldElement<T> npe_invocation_var504 = r.q1.multiply(q0);
                                                                        if (CallChecker.beforeDeref(npe_invocation_var504, RealFieldElement.class, 960, 46089, 46105)) {
                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 960, 46134, 46134)) {
                                                                                if (CallChecker.beforeDeref(r.q2, null, 960, 46134, 46137)) {
                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 960, 46161, 46161)) {
                                                                                        if (CallChecker.beforeDeref(r.q3, null, 960, 46161, 46164)) {
                                                                                            final RealFieldElement<T> npe_invocation_var505 = r.q2.multiply(q3);
                                                                                            if (CallChecker.beforeDeref(npe_invocation_var505, RealFieldElement.class, 960, 46134, 46150)) {
                                                                                                final RealFieldElement<T> npe_invocation_var506 = npe_invocation_var504.add(r.q0.multiply(q1));
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var506, RealFieldElement.class, 960, 46089, 46128)) {
                                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 961, 46218, 46218)) {
                                                                                                        if (CallChecker.beforeDeref(r.q2, null, 961, 46218, 46221)) {
                                                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 961, 46240, 46240)) {
                                                                                                                if (CallChecker.beforeDeref(r.q0, null, 961, 46240, 46243)) {
                                                                                                                    final RealFieldElement<T> npe_invocation_var507 = r.q2.multiply(q0);
                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var507, RealFieldElement.class, 961, 46218, 46234)) {
                                                                                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 961, 46263, 46263)) {
                                                                                                                            if (CallChecker.beforeDeref(r.q3, null, 961, 46263, 46266)) {
                                                                                                                                if (CallChecker.beforeDeref(r, FieldRotation.class, 961, 46290, 46290)) {
                                                                                                                                    if (CallChecker.beforeDeref(r.q1, null, 961, 46290, 46293)) {
                                                                                                                                        final RealFieldElement<T> npe_invocation_var508 = r.q3.multiply(q1);
                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var508, RealFieldElement.class, 961, 46263, 46279)) {
                                                                                                                                            final RealFieldElement<T> npe_invocation_var509 = npe_invocation_var507.add(r.q0.multiply(q2));
                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var509, RealFieldElement.class, 961, 46218, 46257)) {
                                                                                                                                                if (CallChecker.beforeDeref(r, FieldRotation.class, 962, 46347, 46347)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r.q3, null, 962, 46347, 46350)) {
                                                                                                                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 962, 46369, 46369)) {
                                                                                                                                                            if (CallChecker.beforeDeref(r.q0, null, 962, 46369, 46372)) {
                                                                                                                                                                final RealFieldElement<T> npe_invocation_var510 = r.q3.multiply(q0);
                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var510, RealFieldElement.class, 962, 46347, 46363)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 962, 46392, 46392)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(r.q1, null, 962, 46392, 46395)) {
                                                                                                                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 962, 46419, 46419)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(r.q2, null, 962, 46419, 46422)) {
                                                                                                                                                                                    final RealFieldElement<T> npe_invocation_var511 = r.q1.multiply(q2);
                                                                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var511, RealFieldElement.class, 962, 46392, 46408)) {
                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var512 = npe_invocation_var510.add(r.q0.multiply(q3));
                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var512, RealFieldElement.class, 962, 46347, 46386)) {
                                                                                                                                                                                            return new FieldRotation<T>(npe_invocation_var503.subtract(npe_invocation_var502.add(r.q3.multiply(q3))), npe_invocation_var506.add(npe_invocation_var505.subtract(r.q3.multiply(q2))), npe_invocation_var509.add(npe_invocation_var508.subtract(r.q1.multiply(q3))), npe_invocation_var512.add(npe_invocation_var511.subtract(r.q2.multiply(q1))), false);
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1923.methodEnd();
        }
    }

    public FieldRotation<T> applyTo(final Rotation r) {
        MethodContext _bcornu_methode_context1924 = new MethodContext(FieldRotation.class, 975, 46495, 47701);
        try {
            CallChecker.varInit(this, "this", 975, 46495, 47701);
            CallChecker.varInit(r, "r", 975, 46495, 47701);
            CallChecker.varInit(this.q3, "q3", 975, 46495, 47701);
            CallChecker.varInit(this.q2, "q2", 975, 46495, 47701);
            CallChecker.varInit(this.q1, "q1", 975, 46495, 47701);
            CallChecker.varInit(this.q0, "q0", 975, 46495, 47701);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 975, 46495, 47701);
            if (CallChecker.beforeDeref(r, Rotation.class, 976, 47105, 47105)) {
                if (CallChecker.beforeDeref(q0, null, 976, 47093, 47094)) {
                    if (CallChecker.beforeDeref(r, Rotation.class, 976, 47137, 47137)) {
                        if (CallChecker.beforeDeref(q1, null, 976, 47125, 47126)) {
                            if (CallChecker.beforeDeref(r, Rotation.class, 976, 47164, 47164)) {
                                if (CallChecker.beforeDeref(q2, null, 976, 47152, 47153)) {
                                    final RealFieldElement<T> npe_invocation_var513 = q1.multiply(CallChecker.isCalled(r, Rotation.class, 976, 47137, 47137).getQ1());
                                    if (CallChecker.beforeDeref(npe_invocation_var513, RealFieldElement.class, 976, 47125, 47146)) {
                                        if (CallChecker.beforeDeref(r, Rotation.class, 976, 47192, 47192)) {
                                            if (CallChecker.beforeDeref(q3, null, 976, 47180, 47181)) {
                                                final RealFieldElement<T> npe_invocation_var514 = npe_invocation_var513.add(q2.multiply(CallChecker.isCalled(r, Rotation.class, 976, 47164, 47164).getQ2()));
                                                if (CallChecker.beforeDeref(npe_invocation_var514, RealFieldElement.class, 976, 47125, 47174)) {
                                                    final RealFieldElement<T> npe_invocation_var515 = q0.multiply(CallChecker.isCalled(r, Rotation.class, 976, 47105, 47105).getQ0());
                                                    if (CallChecker.beforeDeref(npe_invocation_var515, RealFieldElement.class, 976, 47093, 47114)) {
                                                        if (CallChecker.beforeDeref(r, Rotation.class, 977, 47254, 47254)) {
                                                            if (CallChecker.beforeDeref(q0, null, 977, 47242, 47243)) {
                                                                if (CallChecker.beforeDeref(r, Rotation.class, 977, 47281, 47281)) {
                                                                    if (CallChecker.beforeDeref(q1, null, 977, 47269, 47270)) {
                                                                        final RealFieldElement<T> npe_invocation_var516 = q0.multiply(CallChecker.isCalled(r, Rotation.class, 977, 47254, 47254).getQ1());
                                                                        if (CallChecker.beforeDeref(npe_invocation_var516, RealFieldElement.class, 977, 47242, 47263)) {
                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 977, 47309, 47309)) {
                                                                                if (CallChecker.beforeDeref(q3, null, 977, 47297, 47298)) {
                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 977, 47341, 47341)) {
                                                                                        if (CallChecker.beforeDeref(q2, null, 977, 47329, 47330)) {
                                                                                            final RealFieldElement<T> npe_invocation_var517 = q3.multiply(CallChecker.isCalled(r, Rotation.class, 977, 47309, 47309).getQ2());
                                                                                            if (CallChecker.beforeDeref(npe_invocation_var517, RealFieldElement.class, 977, 47297, 47318)) {
                                                                                                final RealFieldElement<T> npe_invocation_var518 = npe_invocation_var516.add(q1.multiply(CallChecker.isCalled(r, Rotation.class, 977, 47281, 47281).getQ0()));
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var518, RealFieldElement.class, 977, 47242, 47291)) {
                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 978, 47403, 47403)) {
                                                                                                        if (CallChecker.beforeDeref(q0, null, 978, 47391, 47392)) {
                                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 978, 47430, 47430)) {
                                                                                                                if (CallChecker.beforeDeref(q2, null, 978, 47418, 47419)) {
                                                                                                                    final RealFieldElement<T> npe_invocation_var519 = q0.multiply(CallChecker.isCalled(r, Rotation.class, 978, 47403, 47403).getQ2());
                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var519, RealFieldElement.class, 978, 47391, 47412)) {
                                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 978, 47458, 47458)) {
                                                                                                                            if (CallChecker.beforeDeref(q1, null, 978, 47446, 47447)) {
                                                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 978, 47490, 47490)) {
                                                                                                                                    if (CallChecker.beforeDeref(q3, null, 978, 47478, 47479)) {
                                                                                                                                        final RealFieldElement<T> npe_invocation_var520 = q1.multiply(CallChecker.isCalled(r, Rotation.class, 978, 47458, 47458).getQ3());
                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var520, RealFieldElement.class, 978, 47446, 47467)) {
                                                                                                                                            final RealFieldElement<T> npe_invocation_var521 = npe_invocation_var519.add(q2.multiply(CallChecker.isCalled(r, Rotation.class, 978, 47430, 47430).getQ0()));
                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var521, RealFieldElement.class, 978, 47391, 47440)) {
                                                                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 979, 47552, 47552)) {
                                                                                                                                                    if (CallChecker.beforeDeref(q0, null, 979, 47540, 47541)) {
                                                                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 979, 47579, 47579)) {
                                                                                                                                                            if (CallChecker.beforeDeref(q3, null, 979, 47567, 47568)) {
                                                                                                                                                                final RealFieldElement<T> npe_invocation_var522 = q0.multiply(CallChecker.isCalled(r, Rotation.class, 979, 47552, 47552).getQ3());
                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var522, RealFieldElement.class, 979, 47540, 47561)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 979, 47607, 47607)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(q2, null, 979, 47595, 47596)) {
                                                                                                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 979, 47639, 47639)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(q1, null, 979, 47627, 47628)) {
                                                                                                                                                                                    final RealFieldElement<T> npe_invocation_var523 = q2.multiply(CallChecker.isCalled(r, Rotation.class, 979, 47607, 47607).getQ1());
                                                                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var523, RealFieldElement.class, 979, 47595, 47616)) {
                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var524 = npe_invocation_var522.add(q3.multiply(CallChecker.isCalled(r, Rotation.class, 979, 47579, 47579).getQ0()));
                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var524, RealFieldElement.class, 979, 47540, 47589)) {
                                                                                                                                                                                            return new FieldRotation<T>(npe_invocation_var515.subtract(npe_invocation_var514.add(q3.multiply(CallChecker.isCalled(r, Rotation.class, 976, 47192, 47192).getQ3()))), npe_invocation_var518.add(npe_invocation_var517.subtract(q2.multiply(CallChecker.isCalled(r, Rotation.class, 977, 47341, 47341).getQ3()))), npe_invocation_var521.add(npe_invocation_var520.subtract(q3.multiply(CallChecker.isCalled(r, Rotation.class, 978, 47490, 47490).getQ1()))), npe_invocation_var524.add(npe_invocation_var523.subtract(q1.multiply(CallChecker.isCalled(r, Rotation.class, 979, 47639, 47639).getQ2()))), false);
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1924.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyTo(final Rotation r1, final FieldRotation<T> rInner) {
        MethodContext _bcornu_methode_context1925 = new MethodContext(FieldRotation.class, 994, 47708, 49228);
        try {
            CallChecker.varInit(rInner, "rInner", 994, 47708, 49228);
            CallChecker.varInit(r1, "r1", 994, 47708, 49228);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 994, 47708, 49228);
            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 995, 48492, 48497)) {
                if (CallChecker.beforeDeref(r1, Rotation.class, 995, 48511, 48512)) {
                    if (CallChecker.beforeDeref(rInner.q0, null, 995, 48492, 48500)) {
                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 995, 48532, 48537)) {
                            if (CallChecker.beforeDeref(r1, Rotation.class, 995, 48551, 48552)) {
                                if (CallChecker.beforeDeref(rInner.q1, null, 995, 48532, 48540)) {
                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 995, 48567, 48572)) {
                                        if (CallChecker.beforeDeref(r1, Rotation.class, 995, 48586, 48587)) {
                                            if (CallChecker.beforeDeref(rInner.q2, null, 995, 48567, 48575)) {
                                                final RealFieldElement<T> npe_invocation_var525 = rInner.q1.multiply(CallChecker.isCalled(r1, Rotation.class, 995, 48551, 48552).getQ1());
                                                if (CallChecker.beforeDeref(npe_invocation_var525, RealFieldElement.class, 995, 48532, 48561)) {
                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 995, 48603, 48608)) {
                                                        if (CallChecker.beforeDeref(r1, Rotation.class, 995, 48622, 48623)) {
                                                            if (CallChecker.beforeDeref(rInner.q3, null, 995, 48603, 48611)) {
                                                                final RealFieldElement<T> npe_invocation_var526 = npe_invocation_var525.add(rInner.q2.multiply(CallChecker.isCalled(r1, Rotation.class, 995, 48586, 48587).getQ2()));
                                                                if (CallChecker.beforeDeref(npe_invocation_var526, RealFieldElement.class, 995, 48532, 48597)) {
                                                                    final RealFieldElement<T> npe_invocation_var527 = rInner.q0.multiply(CallChecker.isCalled(r1, Rotation.class, 995, 48511, 48512).getQ0());
                                                                    if (CallChecker.beforeDeref(npe_invocation_var527, RealFieldElement.class, 995, 48492, 48521)) {
                                                                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 996, 48673, 48678)) {
                                                                            if (CallChecker.beforeDeref(r1, Rotation.class, 996, 48692, 48693)) {
                                                                                if (CallChecker.beforeDeref(rInner.q1, null, 996, 48673, 48681)) {
                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 996, 48708, 48713)) {
                                                                                        if (CallChecker.beforeDeref(r1, Rotation.class, 996, 48727, 48728)) {
                                                                                            if (CallChecker.beforeDeref(rInner.q0, null, 996, 48708, 48716)) {
                                                                                                final RealFieldElement<T> npe_invocation_var528 = rInner.q1.multiply(CallChecker.isCalled(r1, Rotation.class, 996, 48692, 48693).getQ0());
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var528, RealFieldElement.class, 996, 48673, 48702)) {
                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 996, 48744, 48749)) {
                                                                                                        if (CallChecker.beforeDeref(r1, Rotation.class, 996, 48763, 48764)) {
                                                                                                            if (CallChecker.beforeDeref(rInner.q2, null, 996, 48744, 48752)) {
                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 996, 48784, 48789)) {
                                                                                                                    if (CallChecker.beforeDeref(r1, Rotation.class, 996, 48803, 48804)) {
                                                                                                                        if (CallChecker.beforeDeref(rInner.q3, null, 996, 48784, 48792)) {
                                                                                                                            final RealFieldElement<T> npe_invocation_var529 = rInner.q2.multiply(CallChecker.isCalled(r1, Rotation.class, 996, 48763, 48764).getQ3());
                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var529, RealFieldElement.class, 996, 48744, 48773)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var530 = npe_invocation_var528.add(rInner.q0.multiply(CallChecker.isCalled(r1, Rotation.class, 996, 48727, 48728).getQ1()));
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var530, RealFieldElement.class, 996, 48673, 48738)) {
                                                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 997, 48854, 48859)) {
                                                                                                                                        if (CallChecker.beforeDeref(r1, Rotation.class, 997, 48873, 48874)) {
                                                                                                                                            if (CallChecker.beforeDeref(rInner.q2, null, 997, 48854, 48862)) {
                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 997, 48889, 48894)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r1, Rotation.class, 997, 48908, 48909)) {
                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q0, null, 997, 48889, 48897)) {
                                                                                                                                                            final RealFieldElement<T> npe_invocation_var531 = rInner.q2.multiply(CallChecker.isCalled(r1, Rotation.class, 997, 48873, 48874).getQ0());
                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var531, RealFieldElement.class, 997, 48854, 48883)) {
                                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 997, 48925, 48930)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r1, Rotation.class, 997, 48944, 48945)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q3, null, 997, 48925, 48933)) {
                                                                                                                                                                            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 997, 48965, 48970)) {
                                                                                                                                                                                if (CallChecker.beforeDeref(r1, Rotation.class, 997, 48984, 48985)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner.q1, null, 997, 48965, 48973)) {
                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var532 = rInner.q3.multiply(CallChecker.isCalled(r1, Rotation.class, 997, 48944, 48945).getQ1());
                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var532, RealFieldElement.class, 997, 48925, 48954)) {
                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var533 = npe_invocation_var531.add(rInner.q0.multiply(CallChecker.isCalled(r1, Rotation.class, 997, 48908, 48909).getQ2()));
                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var533, RealFieldElement.class, 997, 48854, 48919)) {
                                                                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 998, 49035, 49040)) {
                                                                                                                                                                                                    if (CallChecker.beforeDeref(r1, Rotation.class, 998, 49054, 49055)) {
                                                                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q3, null, 998, 49035, 49043)) {
                                                                                                                                                                                                            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 998, 49070, 49075)) {
                                                                                                                                                                                                                if (CallChecker.beforeDeref(r1, Rotation.class, 998, 49089, 49090)) {
                                                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner.q0, null, 998, 49070, 49078)) {
                                                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var534 = rInner.q3.multiply(CallChecker.isCalled(r1, Rotation.class, 998, 49054, 49055).getQ0());
                                                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var534, RealFieldElement.class, 998, 49035, 49064)) {
                                                                                                                                                                                                                            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 998, 49106, 49111)) {
                                                                                                                                                                                                                                if (CallChecker.beforeDeref(r1, Rotation.class, 998, 49125, 49126)) {
                                                                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner.q1, null, 998, 49106, 49114)) {
                                                                                                                                                                                                                                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 998, 49146, 49151)) {
                                                                                                                                                                                                                                            if (CallChecker.beforeDeref(r1, Rotation.class, 998, 49165, 49166)) {
                                                                                                                                                                                                                                                if (CallChecker.beforeDeref(rInner.q2, null, 998, 49146, 49154)) {
                                                                                                                                                                                                                                                    final RealFieldElement<T> npe_invocation_var535 = rInner.q1.multiply(CallChecker.isCalled(r1, Rotation.class, 998, 49125, 49126).getQ2());
                                                                                                                                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var535, RealFieldElement.class, 998, 49106, 49135)) {
                                                                                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var536 = npe_invocation_var534.add(rInner.q0.multiply(CallChecker.isCalled(r1, Rotation.class, 998, 49089, 49090).getQ3()));
                                                                                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var536, RealFieldElement.class, 998, 49035, 49100)) {
                                                                                                                                                                                                                                                            return new FieldRotation<T>(npe_invocation_var527.subtract(npe_invocation_var526.add(rInner.q3.multiply(CallChecker.isCalled(r1, Rotation.class, 995, 48622, 48623).getQ3()))), npe_invocation_var530.add(npe_invocation_var529.subtract(rInner.q3.multiply(CallChecker.isCalled(r1, Rotation.class, 996, 48803, 48804).getQ2()))), npe_invocation_var533.add(npe_invocation_var532.subtract(rInner.q1.multiply(CallChecker.isCalled(r1, Rotation.class, 997, 48984, 48985).getQ3()))), npe_invocation_var536.add(npe_invocation_var535.subtract(rInner.q2.multiply(CallChecker.isCalled(r1, Rotation.class, 998, 49165, 49166).getQ1()))), false);
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1925.methodEnd();
        }
    }

    public FieldRotation<T> applyInverseTo(final FieldRotation<T> r) {
        MethodContext _bcornu_methode_context1926 = new MethodContext(FieldRotation.class, 1013, 49235, 50476);
        try {
            CallChecker.varInit(this, "this", 1013, 49235, 50476);
            CallChecker.varInit(r, "r", 1013, 49235, 50476);
            CallChecker.varInit(this.q3, "q3", 1013, 49235, 50476);
            CallChecker.varInit(this.q2, "q2", 1013, 49235, 50476);
            CallChecker.varInit(this.q1, "q1", 1013, 49235, 50476);
            CallChecker.varInit(this.q0, "q0", 1013, 49235, 50476);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1013, 49235, 50476);
            if (CallChecker.beforeDeref(r, FieldRotation.class, 1014, 49929, 49929)) {
                if (CallChecker.beforeDeref(r.q0, null, 1014, 49929, 49932)) {
                    if (CallChecker.beforeDeref(r, FieldRotation.class, 1014, 49951, 49951)) {
                        if (CallChecker.beforeDeref(r.q1, null, 1014, 49951, 49954)) {
                            if (CallChecker.beforeDeref(r, FieldRotation.class, 1014, 49973, 49973)) {
                                if (CallChecker.beforeDeref(r.q2, null, 1014, 49973, 49976)) {
                                    final RealFieldElement<T> npe_invocation_var537 = r.q1.multiply(q1);
                                    if (CallChecker.beforeDeref(npe_invocation_var537, RealFieldElement.class, 1014, 49951, 49967)) {
                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 1014, 49996, 49996)) {
                                            if (CallChecker.beforeDeref(r.q3, null, 1014, 49996, 49999)) {
                                                final RealFieldElement<T> npe_invocation_var538 = npe_invocation_var537.add(r.q2.multiply(q2));
                                                if (CallChecker.beforeDeref(npe_invocation_var538, RealFieldElement.class, 1014, 49951, 49990)) {
                                                    final RealFieldElement<T> npe_invocation_var539 = r.q0.multiply(q0);
                                                    if (CallChecker.beforeDeref(npe_invocation_var539, RealFieldElement.class, 1014, 49929, 49945)) {
                                                        final RealFieldElement<T> npe_invocation_var540 = npe_invocation_var539.add(npe_invocation_var538.add(r.q3.multiply(q3)));
                                                        if (CallChecker.beforeDeref(npe_invocation_var540, RealFieldElement.class, 1014, 49929, 50014)) {
                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 1015, 50062, 50062)) {
                                                                if (CallChecker.beforeDeref(r.q0, null, 1015, 50062, 50065)) {
                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 1015, 50084, 50084)) {
                                                                        if (CallChecker.beforeDeref(r.q2, null, 1015, 50084, 50087)) {
                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 1015, 50111, 50111)) {
                                                                                if (CallChecker.beforeDeref(r.q3, null, 1015, 50111, 50114)) {
                                                                                    final RealFieldElement<T> npe_invocation_var541 = r.q2.multiply(q3);
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var541, RealFieldElement.class, 1015, 50084, 50100)) {
                                                                                        final RealFieldElement<T> npe_invocation_var542 = r.q0.multiply(q1);
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var542, RealFieldElement.class, 1015, 50062, 50078)) {
                                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 1015, 50140, 50140)) {
                                                                                                if (CallChecker.beforeDeref(r.q1, null, 1015, 50140, 50143)) {
                                                                                                    final RealFieldElement<T> npe_invocation_var543 = npe_invocation_var542.add(npe_invocation_var541.subtract(r.q3.multiply(q2)));
                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var543, RealFieldElement.class, 1015, 50062, 50129)) {
                                                                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 1016, 50196, 50196)) {
                                                                                                            if (CallChecker.beforeDeref(r.q0, null, 1016, 50196, 50199)) {
                                                                                                                if (CallChecker.beforeDeref(r, FieldRotation.class, 1016, 50218, 50218)) {
                                                                                                                    if (CallChecker.beforeDeref(r.q3, null, 1016, 50218, 50221)) {
                                                                                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 1016, 50245, 50245)) {
                                                                                                                            if (CallChecker.beforeDeref(r.q1, null, 1016, 50245, 50248)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var544 = r.q3.multiply(q1);
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var544, RealFieldElement.class, 1016, 50218, 50234)) {
                                                                                                                                    final RealFieldElement<T> npe_invocation_var545 = r.q0.multiply(q2);
                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var545, RealFieldElement.class, 1016, 50196, 50212)) {
                                                                                                                                        if (CallChecker.beforeDeref(r, FieldRotation.class, 1016, 50274, 50274)) {
                                                                                                                                            if (CallChecker.beforeDeref(r.q2, null, 1016, 50274, 50277)) {
                                                                                                                                                final RealFieldElement<T> npe_invocation_var546 = npe_invocation_var545.add(npe_invocation_var544.subtract(r.q1.multiply(q3)));
                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var546, RealFieldElement.class, 1016, 50196, 50263)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 1017, 50330, 50330)) {
                                                                                                                                                        if (CallChecker.beforeDeref(r.q0, null, 1017, 50330, 50333)) {
                                                                                                                                                            if (CallChecker.beforeDeref(r, FieldRotation.class, 1017, 50352, 50352)) {
                                                                                                                                                                if (CallChecker.beforeDeref(r.q1, null, 1017, 50352, 50355)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 1017, 50379, 50379)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(r.q2, null, 1017, 50379, 50382)) {
                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var547 = r.q1.multiply(q2);
                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var547, RealFieldElement.class, 1017, 50352, 50368)) {
                                                                                                                                                                                final RealFieldElement<T> npe_invocation_var548 = r.q0.multiply(q3);
                                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var548, RealFieldElement.class, 1017, 50330, 50346)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(r, FieldRotation.class, 1017, 50408, 50408)) {
                                                                                                                                                                                        if (CallChecker.beforeDeref(r.q3, null, 1017, 50408, 50411)) {
                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var549 = npe_invocation_var548.add(npe_invocation_var547.subtract(r.q2.multiply(q1)));
                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var549, RealFieldElement.class, 1017, 50330, 50397)) {
                                                                                                                                                                                                return new FieldRotation<T>(npe_invocation_var540.negate(), npe_invocation_var543.subtract(r.q1.multiply(q0)), npe_invocation_var546.subtract(r.q2.multiply(q0)), npe_invocation_var549.subtract(r.q3.multiply(q0)), false);
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
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1926.methodEnd();
        }
    }

    public FieldRotation<T> applyInverseTo(final Rotation r) {
        MethodContext _bcornu_methode_context1927 = new MethodContext(FieldRotation.class, 1032, 50483, 51796);
        try {
            CallChecker.varInit(this, "this", 1032, 50483, 51796);
            CallChecker.varInit(r, "r", 1032, 50483, 51796);
            CallChecker.varInit(this.q3, "q3", 1032, 50483, 51796);
            CallChecker.varInit(this.q2, "q2", 1032, 50483, 51796);
            CallChecker.varInit(this.q1, "q1", 1032, 50483, 51796);
            CallChecker.varInit(this.q0, "q0", 1032, 50483, 51796);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1032, 50483, 51796);
            if (CallChecker.beforeDeref(r, Rotation.class, 1033, 51181, 51181)) {
                if (CallChecker.beforeDeref(q0, null, 1033, 51169, 51170)) {
                    if (CallChecker.beforeDeref(r, Rotation.class, 1033, 51208, 51208)) {
                        if (CallChecker.beforeDeref(q1, null, 1033, 51196, 51197)) {
                            if (CallChecker.beforeDeref(r, Rotation.class, 1033, 51235, 51235)) {
                                if (CallChecker.beforeDeref(q2, null, 1033, 51223, 51224)) {
                                    final RealFieldElement<T> npe_invocation_var550 = q1.multiply(CallChecker.isCalled(r, Rotation.class, 1033, 51208, 51208).getQ1());
                                    if (CallChecker.beforeDeref(npe_invocation_var550, RealFieldElement.class, 1033, 51196, 51217)) {
                                        if (CallChecker.beforeDeref(r, Rotation.class, 1033, 51263, 51263)) {
                                            if (CallChecker.beforeDeref(q3, null, 1033, 51251, 51252)) {
                                                final RealFieldElement<T> npe_invocation_var551 = npe_invocation_var550.add(q2.multiply(CallChecker.isCalled(r, Rotation.class, 1033, 51235, 51235).getQ2()));
                                                if (CallChecker.beforeDeref(npe_invocation_var551, RealFieldElement.class, 1033, 51196, 51245)) {
                                                    final RealFieldElement<T> npe_invocation_var552 = q0.multiply(CallChecker.isCalled(r, Rotation.class, 1033, 51181, 51181).getQ0());
                                                    if (CallChecker.beforeDeref(npe_invocation_var552, RealFieldElement.class, 1033, 51169, 51190)) {
                                                        final RealFieldElement<T> npe_invocation_var553 = npe_invocation_var552.add(npe_invocation_var551.add(q3.multiply(CallChecker.isCalled(r, Rotation.class, 1033, 51263, 51263).getQ3())));
                                                        if (CallChecker.beforeDeref(npe_invocation_var553, RealFieldElement.class, 1033, 51169, 51274)) {
                                                            if (CallChecker.beforeDeref(r, Rotation.class, 1034, 51334, 51334)) {
                                                                if (CallChecker.beforeDeref(q1, null, 1034, 51322, 51323)) {
                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 1034, 51361, 51361)) {
                                                                        if (CallChecker.beforeDeref(q3, null, 1034, 51349, 51350)) {
                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 1034, 51393, 51393)) {
                                                                                if (CallChecker.beforeDeref(q2, null, 1034, 51381, 51382)) {
                                                                                    final RealFieldElement<T> npe_invocation_var554 = q3.multiply(CallChecker.isCalled(r, Rotation.class, 1034, 51361, 51361).getQ2());
                                                                                    if (CallChecker.beforeDeref(npe_invocation_var554, RealFieldElement.class, 1034, 51349, 51370)) {
                                                                                        final RealFieldElement<T> npe_invocation_var555 = q1.multiply(CallChecker.isCalled(r, Rotation.class, 1034, 51334, 51334).getQ0());
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var555, RealFieldElement.class, 1034, 51322, 51343)) {
                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 1034, 51427, 51427)) {
                                                                                                if (CallChecker.beforeDeref(q0, null, 1034, 51415, 51416)) {
                                                                                                    final RealFieldElement<T> npe_invocation_var556 = npe_invocation_var555.add(npe_invocation_var554.subtract(q2.multiply(CallChecker.isCalled(r, Rotation.class, 1034, 51393, 51393).getQ3())));
                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var556, RealFieldElement.class, 1034, 51322, 51404)) {
                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 1035, 51488, 51488)) {
                                                                                                            if (CallChecker.beforeDeref(q2, null, 1035, 51476, 51477)) {
                                                                                                                if (CallChecker.beforeDeref(r, Rotation.class, 1035, 51515, 51515)) {
                                                                                                                    if (CallChecker.beforeDeref(q1, null, 1035, 51503, 51504)) {
                                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 1035, 51547, 51547)) {
                                                                                                                            if (CallChecker.beforeDeref(q3, null, 1035, 51535, 51536)) {
                                                                                                                                final RealFieldElement<T> npe_invocation_var557 = q1.multiply(CallChecker.isCalled(r, Rotation.class, 1035, 51515, 51515).getQ3());
                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var557, RealFieldElement.class, 1035, 51503, 51524)) {
                                                                                                                                    final RealFieldElement<T> npe_invocation_var558 = q2.multiply(CallChecker.isCalled(r, Rotation.class, 1035, 51488, 51488).getQ0());
                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var558, RealFieldElement.class, 1035, 51476, 51497)) {
                                                                                                                                        if (CallChecker.beforeDeref(r, Rotation.class, 1035, 51581, 51581)) {
                                                                                                                                            if (CallChecker.beforeDeref(q0, null, 1035, 51569, 51570)) {
                                                                                                                                                final RealFieldElement<T> npe_invocation_var559 = npe_invocation_var558.add(npe_invocation_var557.subtract(q3.multiply(CallChecker.isCalled(r, Rotation.class, 1035, 51547, 51547).getQ1())));
                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var559, RealFieldElement.class, 1035, 51476, 51558)) {
                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 1036, 51642, 51642)) {
                                                                                                                                                        if (CallChecker.beforeDeref(q3, null, 1036, 51630, 51631)) {
                                                                                                                                                            if (CallChecker.beforeDeref(r, Rotation.class, 1036, 51669, 51669)) {
                                                                                                                                                                if (CallChecker.beforeDeref(q2, null, 1036, 51657, 51658)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 1036, 51701, 51701)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(q1, null, 1036, 51689, 51690)) {
                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var560 = q2.multiply(CallChecker.isCalled(r, Rotation.class, 1036, 51669, 51669).getQ1());
                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var560, RealFieldElement.class, 1036, 51657, 51678)) {
                                                                                                                                                                                final RealFieldElement<T> npe_invocation_var561 = q3.multiply(CallChecker.isCalled(r, Rotation.class, 1036, 51642, 51642).getQ0());
                                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var561, RealFieldElement.class, 1036, 51630, 51651)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(r, Rotation.class, 1036, 51735, 51735)) {
                                                                                                                                                                                        if (CallChecker.beforeDeref(q0, null, 1036, 51723, 51724)) {
                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var562 = npe_invocation_var561.add(npe_invocation_var560.subtract(q1.multiply(CallChecker.isCalled(r, Rotation.class, 1036, 51701, 51701).getQ2())));
                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var562, RealFieldElement.class, 1036, 51630, 51712)) {
                                                                                                                                                                                                return new FieldRotation<T>(npe_invocation_var553.negate(), npe_invocation_var556.subtract(q0.multiply(CallChecker.isCalled(r, Rotation.class, 1034, 51427, 51427).getQ1())), npe_invocation_var559.subtract(q0.multiply(CallChecker.isCalled(r, Rotation.class, 1035, 51581, 51581).getQ2())), npe_invocation_var562.subtract(q0.multiply(CallChecker.isCalled(r, Rotation.class, 1036, 51735, 51735).getQ3())), false);
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
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1927.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyInverseTo(final Rotation rOuter, final FieldRotation<T> rInner) {
        MethodContext _bcornu_methode_context1928 = new MethodContext(FieldRotation.class, 1053, 51803, 53518);
        try {
            CallChecker.varInit(rInner, "rInner", 1053, 51803, 53518);
            CallChecker.varInit(rOuter, "rOuter", 1053, 51803, 53518);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1053, 51803, 53518);
            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1054, 52699, 52704)) {
                if (CallChecker.beforeDeref(rOuter, Rotation.class, 1054, 52718, 52723)) {
                    if (CallChecker.beforeDeref(rInner.q0, null, 1054, 52699, 52707)) {
                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1054, 52738, 52743)) {
                            if (CallChecker.beforeDeref(rOuter, Rotation.class, 1054, 52757, 52762)) {
                                if (CallChecker.beforeDeref(rInner.q1, null, 1054, 52738, 52746)) {
                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1054, 52777, 52782)) {
                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1054, 52796, 52801)) {
                                            if (CallChecker.beforeDeref(rInner.q2, null, 1054, 52777, 52785)) {
                                                final RealFieldElement<T> npe_invocation_var563 = rInner.q1.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1054, 52757, 52762).getQ1());
                                                if (CallChecker.beforeDeref(npe_invocation_var563, RealFieldElement.class, 1054, 52738, 52771)) {
                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1054, 52817, 52822)) {
                                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1054, 52836, 52841)) {
                                                            if (CallChecker.beforeDeref(rInner.q3, null, 1054, 52817, 52825)) {
                                                                final RealFieldElement<T> npe_invocation_var564 = npe_invocation_var563.add(rInner.q2.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1054, 52796, 52801).getQ2()));
                                                                if (CallChecker.beforeDeref(npe_invocation_var564, RealFieldElement.class, 1054, 52738, 52811)) {
                                                                    final RealFieldElement<T> npe_invocation_var565 = rInner.q0.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1054, 52718, 52723).getQ0());
                                                                    if (CallChecker.beforeDeref(npe_invocation_var565, RealFieldElement.class, 1054, 52699, 52732)) {
                                                                        final RealFieldElement<T> npe_invocation_var566 = npe_invocation_var565.add(npe_invocation_var564.add(rInner.q3.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1054, 52836, 52841).getQ3())));
                                                                        if (CallChecker.beforeDeref(npe_invocation_var566, RealFieldElement.class, 1054, 52699, 52852)) {
                                                                            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1055, 52900, 52905)) {
                                                                                if (CallChecker.beforeDeref(rOuter, Rotation.class, 1055, 52919, 52924)) {
                                                                                    if (CallChecker.beforeDeref(rInner.q0, null, 1055, 52900, 52908)) {
                                                                                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1055, 52939, 52944)) {
                                                                                            if (CallChecker.beforeDeref(rOuter, Rotation.class, 1055, 52958, 52963)) {
                                                                                                if (CallChecker.beforeDeref(rInner.q2, null, 1055, 52939, 52947)) {
                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1055, 52983, 52988)) {
                                                                                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1055, 53002, 53007)) {
                                                                                                            if (CallChecker.beforeDeref(rInner.q3, null, 1055, 52983, 52991)) {
                                                                                                                final RealFieldElement<T> npe_invocation_var567 = rInner.q2.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1055, 52958, 52963).getQ3());
                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var567, RealFieldElement.class, 1055, 52939, 52972)) {
                                                                                                                    final RealFieldElement<T> npe_invocation_var568 = rInner.q0.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1055, 52919, 52924).getQ1());
                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var568, RealFieldElement.class, 1055, 52900, 52933)) {
                                                                                                                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1055, 53029, 53034)) {
                                                                                                                            if (CallChecker.beforeDeref(rOuter, Rotation.class, 1055, 53048, 53053)) {
                                                                                                                                if (CallChecker.beforeDeref(rInner.q1, null, 1055, 53029, 53037)) {
                                                                                                                                    final RealFieldElement<T> npe_invocation_var569 = npe_invocation_var568.add(npe_invocation_var567.subtract(rInner.q3.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1055, 53002, 53007).getQ2())));
                                                                                                                                    if (CallChecker.beforeDeref(npe_invocation_var569, RealFieldElement.class, 1055, 52900, 53018)) {
                                                                                                                                        if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1056, 53102, 53107)) {
                                                                                                                                            if (CallChecker.beforeDeref(rOuter, Rotation.class, 1056, 53121, 53126)) {
                                                                                                                                                if (CallChecker.beforeDeref(rInner.q0, null, 1056, 53102, 53110)) {
                                                                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1056, 53141, 53146)) {
                                                                                                                                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1056, 53160, 53165)) {
                                                                                                                                                            if (CallChecker.beforeDeref(rInner.q3, null, 1056, 53141, 53149)) {
                                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1056, 53185, 53190)) {
                                                                                                                                                                    if (CallChecker.beforeDeref(rOuter, Rotation.class, 1056, 53204, 53209)) {
                                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q1, null, 1056, 53185, 53193)) {
                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var570 = rInner.q3.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1056, 53160, 53165).getQ1());
                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var570, RealFieldElement.class, 1056, 53141, 53174)) {
                                                                                                                                                                                final RealFieldElement<T> npe_invocation_var571 = rInner.q0.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1056, 53121, 53126).getQ2());
                                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var571, RealFieldElement.class, 1056, 53102, 53135)) {
                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1056, 53231, 53236)) {
                                                                                                                                                                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1056, 53250, 53255)) {
                                                                                                                                                                                            if (CallChecker.beforeDeref(rInner.q2, null, 1056, 53231, 53239)) {
                                                                                                                                                                                                final RealFieldElement<T> npe_invocation_var572 = npe_invocation_var571.add(npe_invocation_var570.subtract(rInner.q1.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1056, 53204, 53209).getQ3())));
                                                                                                                                                                                                if (CallChecker.beforeDeref(npe_invocation_var572, RealFieldElement.class, 1056, 53102, 53220)) {
                                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1057, 53304, 53309)) {
                                                                                                                                                                                                        if (CallChecker.beforeDeref(rOuter, Rotation.class, 1057, 53323, 53328)) {
                                                                                                                                                                                                            if (CallChecker.beforeDeref(rInner.q0, null, 1057, 53304, 53312)) {
                                                                                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1057, 53343, 53348)) {
                                                                                                                                                                                                                    if (CallChecker.beforeDeref(rOuter, Rotation.class, 1057, 53362, 53367)) {
                                                                                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q1, null, 1057, 53343, 53351)) {
                                                                                                                                                                                                                            if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1057, 53387, 53392)) {
                                                                                                                                                                                                                                if (CallChecker.beforeDeref(rOuter, Rotation.class, 1057, 53406, 53411)) {
                                                                                                                                                                                                                                    if (CallChecker.beforeDeref(rInner.q2, null, 1057, 53387, 53395)) {
                                                                                                                                                                                                                                        final RealFieldElement<T> npe_invocation_var573 = rInner.q1.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1057, 53362, 53367).getQ2());
                                                                                                                                                                                                                                        if (CallChecker.beforeDeref(npe_invocation_var573, RealFieldElement.class, 1057, 53343, 53376)) {
                                                                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var574 = rInner.q0.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1057, 53323, 53328).getQ3());
                                                                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var574, RealFieldElement.class, 1057, 53304, 53337)) {
                                                                                                                                                                                                                                                if (CallChecker.beforeDeref(rInner, FieldRotation.class, 1057, 53433, 53438)) {
                                                                                                                                                                                                                                                    if (CallChecker.beforeDeref(rOuter, Rotation.class, 1057, 53452, 53457)) {
                                                                                                                                                                                                                                                        if (CallChecker.beforeDeref(rInner.q3, null, 1057, 53433, 53441)) {
                                                                                                                                                                                                                                                            final RealFieldElement<T> npe_invocation_var575 = npe_invocation_var574.add(npe_invocation_var573.subtract(rInner.q2.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1057, 53406, 53411).getQ1())));
                                                                                                                                                                                                                                                            if (CallChecker.beforeDeref(npe_invocation_var575, RealFieldElement.class, 1057, 53304, 53422)) {
                                                                                                                                                                                                                                                                return new FieldRotation<T>(npe_invocation_var566.negate(), npe_invocation_var569.subtract(rInner.q1.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1055, 53048, 53053).getQ0())), npe_invocation_var572.subtract(rInner.q2.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1056, 53250, 53255).getQ0())), npe_invocation_var575.subtract(rInner.q3.multiply(CallChecker.isCalled(rOuter, Rotation.class, 1057, 53452, 53457).getQ0())), false);
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
            return ((FieldRotation<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1928.methodEnd();
        }
    }

    private T[][] orthogonalizeMatrix(final T[][] m, final double threshold) throws NotARotationMatrixException {
        MethodContext _bcornu_methode_context1929 = new MethodContext(null, 1071, 53525, 58460);
        try {
            CallChecker.varInit(this, "this", 1071, 53525, 58460);
            CallChecker.varInit(threshold, "threshold", 1071, 53525, 58460);
            CallChecker.varInit(m, "m", 1071, 53525, 58460);
            CallChecker.varInit(this.q3, "q3", 1071, 53525, 58460);
            CallChecker.varInit(this.q2, "q2", 1071, 53525, 58460);
            CallChecker.varInit(this.q1, "q1", 1071, 53525, 58460);
            CallChecker.varInit(this.q0, "q0", 1071, 53525, 58460);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1071, 53525, 58460);
            T x00 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1074, 54192, 54192)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1074, 54192, 54192)[0], null, 1074, 54192, 54195)) {
                    x00 = CallChecker.isCalled(m, null, 1074, 54192, 54192)[0][0];
                    CallChecker.varAssign(x00, "x00", 1074, 54192, 54192);
                }
            }
            T x01 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1075, 54217, 54217)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1075, 54217, 54217)[0], null, 1075, 54217, 54220)) {
                    x01 = CallChecker.isCalled(m, null, 1075, 54217, 54217)[0][1];
                    CallChecker.varAssign(x01, "x01", 1075, 54217, 54217);
                }
            }
            T x02 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1076, 54242, 54242)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1076, 54242, 54242)[0], null, 1076, 54242, 54245)) {
                    x02 = CallChecker.isCalled(m, null, 1076, 54242, 54242)[0][2];
                    CallChecker.varAssign(x02, "x02", 1076, 54242, 54242);
                }
            }
            T x10 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1077, 54267, 54267)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1077, 54267, 54267)[1], null, 1077, 54267, 54270)) {
                    x10 = CallChecker.isCalled(m, null, 1077, 54267, 54267)[1][0];
                    CallChecker.varAssign(x10, "x10", 1077, 54267, 54267);
                }
            }
            T x11 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1078, 54292, 54292)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1078, 54292, 54292)[1], null, 1078, 54292, 54295)) {
                    x11 = CallChecker.isCalled(m, null, 1078, 54292, 54292)[1][1];
                    CallChecker.varAssign(x11, "x11", 1078, 54292, 54292);
                }
            }
            T x12 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1079, 54317, 54317)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1079, 54317, 54317)[1], null, 1079, 54317, 54320)) {
                    x12 = CallChecker.isCalled(m, null, 1079, 54317, 54317)[1][2];
                    CallChecker.varAssign(x12, "x12", 1079, 54317, 54317);
                }
            }
            T x20 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1080, 54342, 54342)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1080, 54342, 54342)[2], null, 1080, 54342, 54345)) {
                    x20 = CallChecker.isCalled(m, null, 1080, 54342, 54342)[2][0];
                    CallChecker.varAssign(x20, "x20", 1080, 54342, 54342);
                }
            }
            T x21 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1081, 54367, 54367)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1081, 54367, 54367)[2], null, 1081, 54367, 54370)) {
                    x21 = CallChecker.isCalled(m, null, 1081, 54367, 54367)[2][1];
                    CallChecker.varAssign(x21, "x21", 1081, 54367, 54367);
                }
            }
            T x22 = CallChecker.init(null);
            if (CallChecker.beforeDeref(m, null, 1082, 54392, 54392)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1082, 54392, 54392)[2], null, 1082, 54392, 54395)) {
                    x22 = CallChecker.isCalled(m, null, 1082, 54392, 54392)[2][2];
                    CallChecker.varAssign(x22, "x22", 1082, 54392, 54392);
                }
            }
            double fn = CallChecker.varInit(((double) (0)), "fn", 1083, 54409, 54422);
            double fn1 = CallChecker.init(double.class);
            final T[][] o = CallChecker.varInit(MathArrays.buildArray(CallChecker.isCalled(m, null, 1086, 54491, 54491)[0][0].getField(), 3, 3), "o", 1086, 54453, 54516);
            int i = CallChecker.varInit(((int) (0)), "i", 1089, 54593, 54602);
            while ((++i) < 11) {
                final T mx00 = CallChecker.varInit(CallChecker.isCalled(m, null, 1093, 54680, 54680)[0][0].multiply(x00).add(CallChecker.isCalled(m, null, 1093, 54706, 54706)[1][0].multiply(x10)).add(CallChecker.isCalled(m, null, 1093, 54733, 54733)[2][0].multiply(x20)), "mx00", 1093, 54644, 54755);
                final T mx10 = CallChecker.varInit(CallChecker.isCalled(m, null, 1094, 54784, 54784)[0][1].multiply(x00).add(CallChecker.isCalled(m, null, 1094, 54810, 54810)[1][1].multiply(x10)).add(CallChecker.isCalled(m, null, 1094, 54837, 54837)[2][1].multiply(x20)), "mx10", 1094, 54769, 54859);
                final T mx20 = CallChecker.varInit(CallChecker.isCalled(m, null, 1095, 54888, 54888)[0][2].multiply(x00).add(CallChecker.isCalled(m, null, 1095, 54914, 54914)[1][2].multiply(x10)).add(CallChecker.isCalled(m, null, 1095, 54941, 54941)[2][2].multiply(x20)), "mx20", 1095, 54873, 54963);
                final T mx01 = CallChecker.varInit(CallChecker.isCalled(m, null, 1096, 54992, 54992)[0][0].multiply(x01).add(CallChecker.isCalled(m, null, 1096, 55018, 55018)[1][0].multiply(x11)).add(CallChecker.isCalled(m, null, 1096, 55045, 55045)[2][0].multiply(x21)), "mx01", 1096, 54977, 55067);
                final T mx11 = CallChecker.varInit(CallChecker.isCalled(m, null, 1097, 55096, 55096)[0][1].multiply(x01).add(CallChecker.isCalled(m, null, 1097, 55122, 55122)[1][1].multiply(x11)).add(CallChecker.isCalled(m, null, 1097, 55149, 55149)[2][1].multiply(x21)), "mx11", 1097, 55081, 55171);
                final T mx21 = CallChecker.varInit(CallChecker.isCalled(m, null, 1098, 55200, 55200)[0][2].multiply(x01).add(CallChecker.isCalled(m, null, 1098, 55226, 55226)[1][2].multiply(x11)).add(CallChecker.isCalled(m, null, 1098, 55253, 55253)[2][2].multiply(x21)), "mx21", 1098, 55185, 55275);
                final T mx02 = CallChecker.varInit(CallChecker.isCalled(m, null, 1099, 55304, 55304)[0][0].multiply(x02).add(CallChecker.isCalled(m, null, 1099, 55330, 55330)[1][0].multiply(x12)).add(CallChecker.isCalled(m, null, 1099, 55357, 55357)[2][0].multiply(x22)), "mx02", 1099, 55289, 55379);
                final T mx12 = CallChecker.varInit(CallChecker.isCalled(m, null, 1100, 55408, 55408)[0][1].multiply(x02).add(CallChecker.isCalled(m, null, 1100, 55434, 55434)[1][1].multiply(x12)).add(CallChecker.isCalled(m, null, 1100, 55461, 55461)[2][1].multiply(x22)), "mx12", 1100, 55393, 55483);
                final T mx22 = CallChecker.varInit(CallChecker.isCalled(m, null, 1101, 55512, 55512)[0][2].multiply(x02).add(CallChecker.isCalled(m, null, 1101, 55538, 55538)[1][2].multiply(x12)).add(CallChecker.isCalled(m, null, 1101, 55565, 55565)[2][2].multiply(x22)), "mx22", 1101, 55497, 55587);
                if (CallChecker.beforeDeref(o, null, 1104, 55622, 55622)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1104, 55622, 55622)[0], null, 1104, 55622, 55625)) {
                        if (CallChecker.beforeDeref(x00, null, 1104, 55645, 55647)) {
                            if (CallChecker.beforeDeref(x01, null, 1104, 55668, 55670)) {
                                final RealFieldElement<T> npe_invocation_var576 = x00.multiply(mx00);
                                if (CallChecker.beforeDeref(npe_invocation_var576, RealFieldElement.class, 1104, 55645, 55662)) {
                                    if (CallChecker.beforeDeref(x02, null, 1104, 55692, 55694)) {
                                        final RealFieldElement<T> npe_invocation_var577 = npe_invocation_var576.add(x01.multiply(mx10));
                                        if (CallChecker.beforeDeref(npe_invocation_var577, RealFieldElement.class, 1104, 55645, 55686)) {
                                            if (CallChecker.beforeDeref(m, null, 1104, 55721, 55721)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1104, 55721, 55721)[0], null, 1104, 55721, 55724)) {
                                                    final RealFieldElement<T> npe_invocation_var578 = npe_invocation_var577.add(x02.multiply(mx20));
                                                    if (CallChecker.beforeDeref(npe_invocation_var578, RealFieldElement.class, 1104, 55645, 55710)) {
                                                        final RealFieldElement<T> npe_invocation_var579 = npe_invocation_var578.subtract(CallChecker.isCalled(m, null, 1104, 55721, 55721)[0][0]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var579, RealFieldElement.class, 1104, 55645, 55728)) {
                                                            if (CallChecker.beforeDeref(x00, null, 1104, 55632, 55634)) {
                                                                CallChecker.isCalled(o, null, 1104, 55622, 55622)[0][0] = x00.subtract(npe_invocation_var579.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1104, 55622, 55622)[0][0], "CallChecker.isCalled(o, null, 1104, 55622, 55622)[0][0]", 1104, 55622, 55744);
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
                if (CallChecker.beforeDeref(o, null, 1105, 55758, 55758)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1105, 55758, 55758)[0], null, 1105, 55758, 55761)) {
                        if (CallChecker.beforeDeref(x00, null, 1105, 55781, 55783)) {
                            if (CallChecker.beforeDeref(x01, null, 1105, 55804, 55806)) {
                                final RealFieldElement<T> npe_invocation_var580 = x00.multiply(mx01);
                                if (CallChecker.beforeDeref(npe_invocation_var580, RealFieldElement.class, 1105, 55781, 55798)) {
                                    if (CallChecker.beforeDeref(x02, null, 1105, 55828, 55830)) {
                                        final RealFieldElement<T> npe_invocation_var581 = npe_invocation_var580.add(x01.multiply(mx11));
                                        if (CallChecker.beforeDeref(npe_invocation_var581, RealFieldElement.class, 1105, 55781, 55822)) {
                                            if (CallChecker.beforeDeref(m, null, 1105, 55857, 55857)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1105, 55857, 55857)[0], null, 1105, 55857, 55860)) {
                                                    final RealFieldElement<T> npe_invocation_var582 = npe_invocation_var581.add(x02.multiply(mx21));
                                                    if (CallChecker.beforeDeref(npe_invocation_var582, RealFieldElement.class, 1105, 55781, 55846)) {
                                                        final RealFieldElement<T> npe_invocation_var583 = npe_invocation_var582.subtract(CallChecker.isCalled(m, null, 1105, 55857, 55857)[0][1]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var583, RealFieldElement.class, 1105, 55781, 55864)) {
                                                            if (CallChecker.beforeDeref(x01, null, 1105, 55768, 55770)) {
                                                                CallChecker.isCalled(o, null, 1105, 55758, 55758)[0][1] = x01.subtract(npe_invocation_var583.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1105, 55758, 55758)[0][1], "CallChecker.isCalled(o, null, 1105, 55758, 55758)[0][1]", 1105, 55758, 55880);
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
                if (CallChecker.beforeDeref(o, null, 1106, 55894, 55894)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1106, 55894, 55894)[0], null, 1106, 55894, 55897)) {
                        if (CallChecker.beforeDeref(x00, null, 1106, 55917, 55919)) {
                            if (CallChecker.beforeDeref(x01, null, 1106, 55940, 55942)) {
                                final RealFieldElement<T> npe_invocation_var584 = x00.multiply(mx02);
                                if (CallChecker.beforeDeref(npe_invocation_var584, RealFieldElement.class, 1106, 55917, 55934)) {
                                    if (CallChecker.beforeDeref(x02, null, 1106, 55964, 55966)) {
                                        final RealFieldElement<T> npe_invocation_var585 = npe_invocation_var584.add(x01.multiply(mx12));
                                        if (CallChecker.beforeDeref(npe_invocation_var585, RealFieldElement.class, 1106, 55917, 55958)) {
                                            if (CallChecker.beforeDeref(m, null, 1106, 55993, 55993)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1106, 55993, 55993)[0], null, 1106, 55993, 55996)) {
                                                    final RealFieldElement<T> npe_invocation_var586 = npe_invocation_var585.add(x02.multiply(mx22));
                                                    if (CallChecker.beforeDeref(npe_invocation_var586, RealFieldElement.class, 1106, 55917, 55982)) {
                                                        final RealFieldElement<T> npe_invocation_var587 = npe_invocation_var586.subtract(CallChecker.isCalled(m, null, 1106, 55993, 55993)[0][2]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var587, RealFieldElement.class, 1106, 55917, 56000)) {
                                                            if (CallChecker.beforeDeref(x02, null, 1106, 55904, 55906)) {
                                                                CallChecker.isCalled(o, null, 1106, 55894, 55894)[0][2] = x02.subtract(npe_invocation_var587.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1106, 55894, 55894)[0][2], "CallChecker.isCalled(o, null, 1106, 55894, 55894)[0][2]", 1106, 55894, 56016);
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
                if (CallChecker.beforeDeref(o, null, 1107, 56030, 56030)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1107, 56030, 56030)[1], null, 1107, 56030, 56033)) {
                        if (CallChecker.beforeDeref(x10, null, 1107, 56053, 56055)) {
                            if (CallChecker.beforeDeref(x11, null, 1107, 56076, 56078)) {
                                final RealFieldElement<T> npe_invocation_var588 = x10.multiply(mx00);
                                if (CallChecker.beforeDeref(npe_invocation_var588, RealFieldElement.class, 1107, 56053, 56070)) {
                                    if (CallChecker.beforeDeref(x12, null, 1107, 56100, 56102)) {
                                        final RealFieldElement<T> npe_invocation_var589 = npe_invocation_var588.add(x11.multiply(mx10));
                                        if (CallChecker.beforeDeref(npe_invocation_var589, RealFieldElement.class, 1107, 56053, 56094)) {
                                            if (CallChecker.beforeDeref(m, null, 1107, 56129, 56129)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1107, 56129, 56129)[1], null, 1107, 56129, 56132)) {
                                                    final RealFieldElement<T> npe_invocation_var590 = npe_invocation_var589.add(x12.multiply(mx20));
                                                    if (CallChecker.beforeDeref(npe_invocation_var590, RealFieldElement.class, 1107, 56053, 56118)) {
                                                        final RealFieldElement<T> npe_invocation_var591 = npe_invocation_var590.subtract(CallChecker.isCalled(m, null, 1107, 56129, 56129)[1][0]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var591, RealFieldElement.class, 1107, 56053, 56136)) {
                                                            if (CallChecker.beforeDeref(x10, null, 1107, 56040, 56042)) {
                                                                CallChecker.isCalled(o, null, 1107, 56030, 56030)[1][0] = x10.subtract(npe_invocation_var591.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1107, 56030, 56030)[1][0], "CallChecker.isCalled(o, null, 1107, 56030, 56030)[1][0]", 1107, 56030, 56152);
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
                if (CallChecker.beforeDeref(o, null, 1108, 56166, 56166)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1108, 56166, 56166)[1], null, 1108, 56166, 56169)) {
                        if (CallChecker.beforeDeref(x10, null, 1108, 56189, 56191)) {
                            if (CallChecker.beforeDeref(x11, null, 1108, 56212, 56214)) {
                                final RealFieldElement<T> npe_invocation_var592 = x10.multiply(mx01);
                                if (CallChecker.beforeDeref(npe_invocation_var592, RealFieldElement.class, 1108, 56189, 56206)) {
                                    if (CallChecker.beforeDeref(x12, null, 1108, 56236, 56238)) {
                                        final RealFieldElement<T> npe_invocation_var593 = npe_invocation_var592.add(x11.multiply(mx11));
                                        if (CallChecker.beforeDeref(npe_invocation_var593, RealFieldElement.class, 1108, 56189, 56230)) {
                                            if (CallChecker.beforeDeref(m, null, 1108, 56265, 56265)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1108, 56265, 56265)[1], null, 1108, 56265, 56268)) {
                                                    final RealFieldElement<T> npe_invocation_var594 = npe_invocation_var593.add(x12.multiply(mx21));
                                                    if (CallChecker.beforeDeref(npe_invocation_var594, RealFieldElement.class, 1108, 56189, 56254)) {
                                                        final RealFieldElement<T> npe_invocation_var595 = npe_invocation_var594.subtract(CallChecker.isCalled(m, null, 1108, 56265, 56265)[1][1]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var595, RealFieldElement.class, 1108, 56189, 56272)) {
                                                            if (CallChecker.beforeDeref(x11, null, 1108, 56176, 56178)) {
                                                                CallChecker.isCalled(o, null, 1108, 56166, 56166)[1][1] = x11.subtract(npe_invocation_var595.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1108, 56166, 56166)[1][1], "CallChecker.isCalled(o, null, 1108, 56166, 56166)[1][1]", 1108, 56166, 56288);
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
                if (CallChecker.beforeDeref(o, null, 1109, 56302, 56302)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1109, 56302, 56302)[1], null, 1109, 56302, 56305)) {
                        if (CallChecker.beforeDeref(x10, null, 1109, 56325, 56327)) {
                            if (CallChecker.beforeDeref(x11, null, 1109, 56348, 56350)) {
                                final RealFieldElement<T> npe_invocation_var596 = x10.multiply(mx02);
                                if (CallChecker.beforeDeref(npe_invocation_var596, RealFieldElement.class, 1109, 56325, 56342)) {
                                    if (CallChecker.beforeDeref(x12, null, 1109, 56372, 56374)) {
                                        final RealFieldElement<T> npe_invocation_var597 = npe_invocation_var596.add(x11.multiply(mx12));
                                        if (CallChecker.beforeDeref(npe_invocation_var597, RealFieldElement.class, 1109, 56325, 56366)) {
                                            if (CallChecker.beforeDeref(m, null, 1109, 56401, 56401)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1109, 56401, 56401)[1], null, 1109, 56401, 56404)) {
                                                    final RealFieldElement<T> npe_invocation_var598 = npe_invocation_var597.add(x12.multiply(mx22));
                                                    if (CallChecker.beforeDeref(npe_invocation_var598, RealFieldElement.class, 1109, 56325, 56390)) {
                                                        final RealFieldElement<T> npe_invocation_var599 = npe_invocation_var598.subtract(CallChecker.isCalled(m, null, 1109, 56401, 56401)[1][2]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var599, RealFieldElement.class, 1109, 56325, 56408)) {
                                                            if (CallChecker.beforeDeref(x12, null, 1109, 56312, 56314)) {
                                                                CallChecker.isCalled(o, null, 1109, 56302, 56302)[1][2] = x12.subtract(npe_invocation_var599.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1109, 56302, 56302)[1][2], "CallChecker.isCalled(o, null, 1109, 56302, 56302)[1][2]", 1109, 56302, 56424);
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
                if (CallChecker.beforeDeref(o, null, 1110, 56438, 56438)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1110, 56438, 56438)[2], null, 1110, 56438, 56441)) {
                        if (CallChecker.beforeDeref(x20, null, 1110, 56461, 56463)) {
                            if (CallChecker.beforeDeref(x21, null, 1110, 56484, 56486)) {
                                final RealFieldElement<T> npe_invocation_var600 = x20.multiply(mx00);
                                if (CallChecker.beforeDeref(npe_invocation_var600, RealFieldElement.class, 1110, 56461, 56478)) {
                                    if (CallChecker.beforeDeref(x22, null, 1110, 56508, 56510)) {
                                        final RealFieldElement<T> npe_invocation_var601 = npe_invocation_var600.add(x21.multiply(mx10));
                                        if (CallChecker.beforeDeref(npe_invocation_var601, RealFieldElement.class, 1110, 56461, 56502)) {
                                            if (CallChecker.beforeDeref(m, null, 1110, 56537, 56537)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1110, 56537, 56537)[2], null, 1110, 56537, 56540)) {
                                                    final RealFieldElement<T> npe_invocation_var602 = npe_invocation_var601.add(x22.multiply(mx20));
                                                    if (CallChecker.beforeDeref(npe_invocation_var602, RealFieldElement.class, 1110, 56461, 56526)) {
                                                        final RealFieldElement<T> npe_invocation_var603 = npe_invocation_var602.subtract(CallChecker.isCalled(m, null, 1110, 56537, 56537)[2][0]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var603, RealFieldElement.class, 1110, 56461, 56544)) {
                                                            if (CallChecker.beforeDeref(x20, null, 1110, 56448, 56450)) {
                                                                CallChecker.isCalled(o, null, 1110, 56438, 56438)[2][0] = x20.subtract(npe_invocation_var603.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1110, 56438, 56438)[2][0], "CallChecker.isCalled(o, null, 1110, 56438, 56438)[2][0]", 1110, 56438, 56560);
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
                if (CallChecker.beforeDeref(o, null, 1111, 56574, 56574)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1111, 56574, 56574)[2], null, 1111, 56574, 56577)) {
                        if (CallChecker.beforeDeref(x20, null, 1111, 56597, 56599)) {
                            if (CallChecker.beforeDeref(x21, null, 1111, 56620, 56622)) {
                                final RealFieldElement<T> npe_invocation_var604 = x20.multiply(mx01);
                                if (CallChecker.beforeDeref(npe_invocation_var604, RealFieldElement.class, 1111, 56597, 56614)) {
                                    if (CallChecker.beforeDeref(x22, null, 1111, 56644, 56646)) {
                                        final RealFieldElement<T> npe_invocation_var605 = npe_invocation_var604.add(x21.multiply(mx11));
                                        if (CallChecker.beforeDeref(npe_invocation_var605, RealFieldElement.class, 1111, 56597, 56638)) {
                                            if (CallChecker.beforeDeref(m, null, 1111, 56673, 56673)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1111, 56673, 56673)[2], null, 1111, 56673, 56676)) {
                                                    final RealFieldElement<T> npe_invocation_var606 = npe_invocation_var605.add(x22.multiply(mx21));
                                                    if (CallChecker.beforeDeref(npe_invocation_var606, RealFieldElement.class, 1111, 56597, 56662)) {
                                                        final RealFieldElement<T> npe_invocation_var607 = npe_invocation_var606.subtract(CallChecker.isCalled(m, null, 1111, 56673, 56673)[2][1]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var607, RealFieldElement.class, 1111, 56597, 56680)) {
                                                            if (CallChecker.beforeDeref(x21, null, 1111, 56584, 56586)) {
                                                                CallChecker.isCalled(o, null, 1111, 56574, 56574)[2][1] = x21.subtract(npe_invocation_var607.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1111, 56574, 56574)[2][1], "CallChecker.isCalled(o, null, 1111, 56574, 56574)[2][1]", 1111, 56574, 56696);
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
                if (CallChecker.beforeDeref(o, null, 1112, 56710, 56710)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1112, 56710, 56710)[2], null, 1112, 56710, 56713)) {
                        if (CallChecker.beforeDeref(x20, null, 1112, 56733, 56735)) {
                            if (CallChecker.beforeDeref(x21, null, 1112, 56756, 56758)) {
                                final RealFieldElement<T> npe_invocation_var608 = x20.multiply(mx02);
                                if (CallChecker.beforeDeref(npe_invocation_var608, RealFieldElement.class, 1112, 56733, 56750)) {
                                    if (CallChecker.beforeDeref(x22, null, 1112, 56780, 56782)) {
                                        final RealFieldElement<T> npe_invocation_var609 = npe_invocation_var608.add(x21.multiply(mx12));
                                        if (CallChecker.beforeDeref(npe_invocation_var609, RealFieldElement.class, 1112, 56733, 56774)) {
                                            if (CallChecker.beforeDeref(m, null, 1112, 56809, 56809)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, null, 1112, 56809, 56809)[2], null, 1112, 56809, 56812)) {
                                                    final RealFieldElement<T> npe_invocation_var610 = npe_invocation_var609.add(x22.multiply(mx22));
                                                    if (CallChecker.beforeDeref(npe_invocation_var610, RealFieldElement.class, 1112, 56733, 56798)) {
                                                        final RealFieldElement<T> npe_invocation_var611 = npe_invocation_var610.subtract(CallChecker.isCalled(m, null, 1112, 56809, 56809)[2][2]);
                                                        if (CallChecker.beforeDeref(npe_invocation_var611, RealFieldElement.class, 1112, 56733, 56816)) {
                                                            if (CallChecker.beforeDeref(x22, null, 1112, 56720, 56722)) {
                                                                CallChecker.isCalled(o, null, 1112, 56710, 56710)[2][2] = x22.subtract(npe_invocation_var611.multiply(0.5));
                                                                CallChecker.varAssign(CallChecker.isCalled(o, null, 1112, 56710, 56710)[2][2], "CallChecker.isCalled(o, null, 1112, 56710, 56710)[2][2]", 1112, 56710, 56832);
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
                final double corr00 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1115, 56912, 56912)[0][0].getReal()) - (CallChecker.isCalled(m, null, 1115, 56932, 56932)[0][0].getReal()))), "corr00", 1115, 56847, 56949);
                final double corr01 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1116, 56985, 56985)[0][1].getReal()) - (CallChecker.isCalled(m, null, 1116, 57005, 57005)[0][1].getReal()))), "corr01", 1116, 56963, 57022);
                final double corr02 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1117, 57058, 57058)[0][2].getReal()) - (CallChecker.isCalled(m, null, 1117, 57078, 57078)[0][2].getReal()))), "corr02", 1117, 57036, 57095);
                final double corr10 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1118, 57131, 57131)[1][0].getReal()) - (CallChecker.isCalled(m, null, 1118, 57151, 57151)[1][0].getReal()))), "corr10", 1118, 57109, 57168);
                final double corr11 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1119, 57204, 57204)[1][1].getReal()) - (CallChecker.isCalled(m, null, 1119, 57224, 57224)[1][1].getReal()))), "corr11", 1119, 57182, 57241);
                final double corr12 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1120, 57277, 57277)[1][2].getReal()) - (CallChecker.isCalled(m, null, 1120, 57297, 57297)[1][2].getReal()))), "corr12", 1120, 57255, 57314);
                final double corr20 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1121, 57350, 57350)[2][0].getReal()) - (CallChecker.isCalled(m, null, 1121, 57370, 57370)[2][0].getReal()))), "corr20", 1121, 57328, 57387);
                final double corr21 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1122, 57423, 57423)[2][1].getReal()) - (CallChecker.isCalled(m, null, 1122, 57443, 57443)[2][1].getReal()))), "corr21", 1122, 57401, 57460);
                final double corr22 = CallChecker.varInit(((double) ((CallChecker.isCalled(o, null, 1123, 57496, 57496)[2][2].getReal()) - (CallChecker.isCalled(m, null, 1123, 57516, 57516)[2][2].getReal()))), "corr22", 1123, 57474, 57533);
                fn1 = ((((((((corr00 * corr00) + (corr01 * corr01)) + (corr02 * corr02)) + (corr10 * corr10)) + (corr11 * corr11)) + (corr12 * corr12)) + (corr20 * corr20)) + (corr21 * corr21)) + (corr22 * corr22);
                CallChecker.varAssign(fn1, "fn1", 1126, 57596, 57797);
                if ((FastMath.abs((fn1 - fn))) <= threshold) {
                    return o;
                }
                if (CallChecker.beforeDeref(o, null, 1136, 57984, 57984)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1136, 57984, 57984)[0], null, 1136, 57984, 57987)) {
                        x00 = CallChecker.isCalled(o, null, 1136, 57984, 57984)[0][0];
                        CallChecker.varAssign(x00, "x00", 1136, 57978, 57991);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1137, 58011, 58011)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1137, 58011, 58011)[0], null, 1137, 58011, 58014)) {
                        x01 = CallChecker.isCalled(o, null, 1137, 58011, 58011)[0][1];
                        CallChecker.varAssign(x01, "x01", 1137, 58005, 58018);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1138, 58038, 58038)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1138, 58038, 58038)[0], null, 1138, 58038, 58041)) {
                        x02 = CallChecker.isCalled(o, null, 1138, 58038, 58038)[0][2];
                        CallChecker.varAssign(x02, "x02", 1138, 58032, 58045);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1139, 58065, 58065)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1139, 58065, 58065)[1], null, 1139, 58065, 58068)) {
                        x10 = CallChecker.isCalled(o, null, 1139, 58065, 58065)[1][0];
                        CallChecker.varAssign(x10, "x10", 1139, 58059, 58072);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1140, 58092, 58092)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1140, 58092, 58092)[1], null, 1140, 58092, 58095)) {
                        x11 = CallChecker.isCalled(o, null, 1140, 58092, 58092)[1][1];
                        CallChecker.varAssign(x11, "x11", 1140, 58086, 58099);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1141, 58119, 58119)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1141, 58119, 58119)[1], null, 1141, 58119, 58122)) {
                        x12 = CallChecker.isCalled(o, null, 1141, 58119, 58119)[1][2];
                        CallChecker.varAssign(x12, "x12", 1141, 58113, 58126);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1142, 58146, 58146)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1142, 58146, 58146)[2], null, 1142, 58146, 58149)) {
                        x20 = CallChecker.isCalled(o, null, 1142, 58146, 58146)[2][0];
                        CallChecker.varAssign(x20, "x20", 1142, 58140, 58153);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1143, 58173, 58173)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1143, 58173, 58173)[2], null, 1143, 58173, 58176)) {
                        x21 = CallChecker.isCalled(o, null, 1143, 58173, 58173)[2][1];
                        CallChecker.varAssign(x21, "x21", 1143, 58167, 58180);
                    }
                }
                if (CallChecker.beforeDeref(o, null, 1144, 58200, 58200)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(o, null, 1144, 58200, 58200)[2], null, 1144, 58200, 58203)) {
                        x22 = CallChecker.isCalled(o, null, 1144, 58200, 58200)[2][2];
                        CallChecker.varAssign(x22, "x22", 1144, 58194, 58207);
                    }
                }
                fn = fn1;
                CallChecker.varAssign(fn, "fn", 1145, 58221, 58230);
            } 
            throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, (i - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1929.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldRotation<T> r1, final FieldRotation<T> r2) {
        MethodContext _bcornu_methode_context1930 = new MethodContext(null, 1180, 58467, 60078);
        try {
            CallChecker.varInit(r2, "r2", 1180, 58467, 60078);
            CallChecker.varInit(r1, "r1", 1180, 58467, 60078);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldRotation.serialVersionUID", 1180, 58467, 60078);
            if (CallChecker.beforeDeref(r1, FieldRotation.class, 1181, 60040, 60041)) {
                final FieldRotation<T> npe_invocation_var612 = CallChecker.isCalled(r1, FieldRotation.class, 1181, 60040, 60041).applyInverseTo(r2);
                if (CallChecker.beforeDeref(npe_invocation_var612, FieldRotation.class, 1181, 60040, 60060)) {
                    return npe_invocation_var612.getAngle();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1930.methodEnd();
        }
    }
}

