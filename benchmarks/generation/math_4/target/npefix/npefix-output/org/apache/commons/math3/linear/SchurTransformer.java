package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

class SchurTransformer {
    private static class ShiftInfo {
        double x;

        double y;

        double w;

        double exShift;
    }

    private static final int MAX_ITERATIONS = 100;

    private final double[][] matrixP;

    private final double[][] matrixT;

    private RealMatrix cachedP;

    private RealMatrix cachedT;

    private RealMatrix cachedPt;

    private final double epsilon = Precision.EPSILON;

    public SchurTransformer(final RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context863 = new ConstructorContext(SchurTransformer.class, 69, 2893, 3645);
        try {
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 70, 3161, 3166)) {
                if (!(CallChecker.isCalled(matrix, RealMatrix.class, 70, 3161, 3166).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 71, 3229, 3234)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 72, 3302, 3307)) {
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, RealMatrix.class, 71, 3229, 3234).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 72, 3302, 3307).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            HessenbergTransformer transformer = CallChecker.varInit(new HessenbergTransformer(matrix), "transformer", 75, 3351, 3420);
            transformer = CallChecker.beforeCalled(transformer, HessenbergTransformer.class, 76, 3440, 3450);
            matrixT = CallChecker.isCalled(CallChecker.isCalled(transformer, HessenbergTransformer.class, 76, 3440, 3450).getH(), RealMatrix.class, 76, 3440, 3457).getData();
            CallChecker.varAssign(this.matrixT, "this.matrixT", 76, 3430, 3468);
            transformer = CallChecker.beforeCalled(transformer, HessenbergTransformer.class, 77, 3488, 3498);
            matrixP = CallChecker.isCalled(CallChecker.isCalled(transformer, HessenbergTransformer.class, 77, 3488, 3498).getP(), RealMatrix.class, 77, 3488, 3505).getData();
            CallChecker.varAssign(this.matrixP, "this.matrixP", 77, 3478, 3516);
            cachedT = null;
            CallChecker.varAssign(this.cachedT, "this.cachedT", 78, 3526, 3540);
            cachedP = null;
            CallChecker.varAssign(this.cachedP, "this.cachedP", 79, 3550, 3564);
            cachedPt = null;
            CallChecker.varAssign(this.cachedPt, "this.cachedPt", 80, 3574, 3589);
            transform();
        } finally {
            _bcornu_methode_context863.methodEnd();
        }
    }

    public RealMatrix getP() {
        MethodContext _bcornu_methode_context3817 = new MethodContext(RealMatrix.class, 92, 3652, 3987);
        try {
            CallChecker.varInit(this, "this", 92, 3652, 3987);
            CallChecker.varInit(this.epsilon, "epsilon", 92, 3652, 3987);
            CallChecker.varInit(this.cachedPt, "cachedPt", 92, 3652, 3987);
            CallChecker.varInit(this.cachedT, "cachedT", 92, 3652, 3987);
            CallChecker.varInit(this.cachedP, "cachedP", 92, 3652, 3987);
            CallChecker.varInit(this.matrixT, "matrixT", 92, 3652, 3987);
            CallChecker.varInit(this.matrixP, "matrixP", 92, 3652, 3987);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 92, 3652, 3987);
            if ((cachedP) == null) {
                cachedP = MatrixUtils.createRealMatrix(matrixP);
                CallChecker.varAssign(this.cachedP, "this.cachedP", 94, 3900, 3947);
            }
            return cachedP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3817.methodEnd();
        }
    }

    public RealMatrix getPT() {
        MethodContext _bcornu_methode_context3818 = new MethodContext(RealMatrix.class, 105, 3994, 4385);
        try {
            CallChecker.varInit(this, "this", 105, 3994, 4385);
            CallChecker.varInit(this.epsilon, "epsilon", 105, 3994, 4385);
            CallChecker.varInit(this.cachedPt, "cachedPt", 105, 3994, 4385);
            CallChecker.varInit(this.cachedT, "cachedT", 105, 3994, 4385);
            CallChecker.varInit(this.cachedP, "cachedP", 105, 3994, 4385);
            CallChecker.varInit(this.matrixT, "matrixT", 105, 3994, 4385);
            CallChecker.varInit(this.matrixP, "matrixP", 105, 3994, 4385);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 105, 3994, 4385);
            if ((cachedPt) == null) {
                final RealMatrix npe_invocation_var827 = getP();
                if (CallChecker.beforeDeref(npe_invocation_var827, RealMatrix.class, 107, 4289, 4294)) {
                    cachedPt = CallChecker.isCalled(npe_invocation_var827, RealMatrix.class, 107, 4289, 4294).transpose();
                    CallChecker.varAssign(this.cachedPt, "this.cachedPt", 107, 4278, 4307);
                }
            }
            return cachedPt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3818.methodEnd();
        }
    }

    public RealMatrix getT() {
        MethodContext _bcornu_methode_context3819 = new MethodContext(RealMatrix.class, 119, 4392, 4706);
        try {
            CallChecker.varInit(this, "this", 119, 4392, 4706);
            CallChecker.varInit(this.epsilon, "epsilon", 119, 4392, 4706);
            CallChecker.varInit(this.cachedPt, "cachedPt", 119, 4392, 4706);
            CallChecker.varInit(this.cachedT, "cachedT", 119, 4392, 4706);
            CallChecker.varInit(this.cachedP, "cachedP", 119, 4392, 4706);
            CallChecker.varInit(this.matrixT, "matrixT", 119, 4392, 4706);
            CallChecker.varInit(this.matrixP, "matrixP", 119, 4392, 4706);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 119, 4392, 4706);
            if ((cachedT) == null) {
                cachedT = MatrixUtils.createRealMatrix(matrixT);
                CallChecker.varAssign(this.cachedT, "this.cachedT", 121, 4582, 4629);
            }
            return cachedT;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3819.methodEnd();
        }
    }

    private void transform() {
        MethodContext _bcornu_methode_context3820 = new MethodContext(void.class, 132, 4713, 8148);
        try {
            CallChecker.varInit(this, "this", 132, 4713, 8148);
            CallChecker.varInit(this.epsilon, "epsilon", 132, 4713, 8148);
            CallChecker.varInit(this.cachedPt, "cachedPt", 132, 4713, 8148);
            CallChecker.varInit(this.cachedT, "cachedT", 132, 4713, 8148);
            CallChecker.varInit(this.cachedP, "cachedP", 132, 4713, 8148);
            CallChecker.varInit(this.matrixT, "matrixT", 132, 4713, 8148);
            CallChecker.varInit(this.matrixP, "matrixP", 132, 4713, 8148);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 132, 4713, 8148);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.matrixT, double[][].class, 133, 4907, 4913).length)), "n", 133, 4893, 4921);
            final double norm = CallChecker.varInit(((double) (getNorm())), "norm", 136, 4932, 4992);
            final SchurTransformer.ShiftInfo shift = CallChecker.varInit(new SchurTransformer.ShiftInfo(), "shift", 139, 5003, 5071);
            int iteration = CallChecker.varInit(((int) (0)), "iteration", 142, 5126, 5143);
            int iu = CallChecker.varInit(((int) (n - 1)), "iu", 143, 5153, 5167);
            while (iu >= 0) {
                final int il = CallChecker.varInit(((int) (findSmallSubDiagonalElement(iu, norm))), "il", 147, 5208, 5318);
                if (il == iu) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 152, 5436, 5442)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 152, 5436, 5442)[iu], double[].class, 152, 5436, 5446)) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 152, 5454, 5460)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 152, 5454, 5460)[iu], double[].class, 152, 5454, 5464)) {
                                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 152, 5472, 5476)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 152, 5436, 5442)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 152, 5436, 5442)[iu], double[].class, 152, 5436, 5446);
                                        CallChecker.isCalled(matrixT, double[][].class, 152, 5454, 5460)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 152, 5454, 5460)[iu], double[].class, 152, 5454, 5464);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 152, 5436, 5442)[iu], double[].class, 152, 5436, 5446)[iu] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 152, 5454, 5460)[iu], double[].class, 152, 5454, 5464)[iu]) + (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 152, 5472, 5476).exShift);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 152, 5436, 5442)[iu], double[].class, 152, 5436, 5446)[iu], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 152, 5436, 5442)[iu], double[].class, 152, 5436, 5446)[iu]", 152, 5436, 5485);
                                    }
                                }
                            }
                        }
                    }
                    iu--;
                    iteration = 0;
                    CallChecker.varAssign(iteration, "iteration", 154, 5525, 5538);
                }else
                    if (il == (iu - 1)) {
                        double p = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 157, 5642, 5648)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 157, 5642, 5648)[(iu - 1)], double[].class, 157, 5642, 5656)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 157, 5668, 5674)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 157, 5668, 5674)[iu], double[].class, 157, 5668, 5678)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 157, 5642, 5648)[(iu - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 157, 5642, 5648)[(iu - 1)], double[].class, 157, 5642, 5656);
                                        CallChecker.isCalled(matrixT, double[][].class, 157, 5668, 5674)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 157, 5668, 5674)[iu], double[].class, 157, 5668, 5678);
                                        p = ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 157, 5642, 5648)[(iu - 1)], double[].class, 157, 5642, 5656)[(iu - 1)]) - (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 157, 5668, 5674)[iu], double[].class, 157, 5668, 5678)[iu])) / 2.0;
                                        CallChecker.varAssign(p, "p", 157, 5642, 5648);
                                    }
                                }
                            }
                        }
                        double q = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 158, 5727, 5733)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 158, 5727, 5733)[iu], double[].class, 158, 5727, 5737)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 158, 5749, 5755)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 158, 5749, 5755)[(iu - 1)], double[].class, 158, 5749, 5763)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 158, 5727, 5733)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 158, 5727, 5733)[iu], double[].class, 158, 5727, 5737);
                                        CallChecker.isCalled(matrixT, double[][].class, 158, 5749, 5755)[(iu - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 158, 5749, 5755)[(iu - 1)], double[].class, 158, 5749, 5763);
                                        q = (p * p) + ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 158, 5727, 5733)[iu], double[].class, 158, 5727, 5737)[(iu - 1)]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 158, 5749, 5755)[(iu - 1)], double[].class, 158, 5749, 5763)[iu]));
                                        CallChecker.varAssign(q, "q", 158, 5727, 5733);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 159, 5786, 5792)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 159, 5786, 5792)[iu], double[].class, 159, 5786, 5796)) {
                                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 159, 5805, 5809)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 159, 5786, 5792)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 159, 5786, 5792)[iu], double[].class, 159, 5786, 5796);
                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 159, 5786, 5792)[iu], double[].class, 159, 5786, 5796)[iu] += CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 159, 5805, 5809).exShift;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 159, 5786, 5792)[iu], double[].class, 159, 5786, 5796)[iu], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 159, 5786, 5792)[iu], double[].class, 159, 5786, 5796)[iu]", 159, 5786, 5818);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 160, 5836, 5842)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)], double[].class, 160, 5836, 5850)) {
                                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 160, 5863, 5867)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)], double[].class, 160, 5836, 5850);
                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)], double[].class, 160, 5836, 5850)[(iu - 1)] += CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 160, 5863, 5867).exShift;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)], double[].class, 160, 5836, 5850)[(iu - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 160, 5836, 5842)[(iu - 1)], double[].class, 160, 5836, 5850)[(iu - 1)]", 160, 5836, 5876);
                                }
                            }
                        }
                        if (q >= 0) {
                            double z = CallChecker.varInit(((double) (FastMath.sqrt(FastMath.abs(q)))), "z", 163, 5929, 5970);
                            if (p >= 0) {
                                z = p + z;
                                CallChecker.varAssign(z, "z", 165, 6030, 6039);
                            }else {
                                z = p - z;
                                CallChecker.varAssign(z, "z", 167, 6094, 6103);
                            }
                            CallChecker.isCalled(matrixT, double[][].class, 169, 6164, 6170)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 169, 6164, 6170)[iu], double[].class, 169, 6164, 6174);
                            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 169, 6164, 6170)[iu], double[].class, 169, 6164, 6174)[(iu - 1)])), "x", 169, 6147, 6183);
                            final double s = CallChecker.varInit(((double) ((FastMath.abs(x)) + (FastMath.abs(z)))), "s", 170, 6205, 6255);
                            p = x / s;
                            CallChecker.varAssign(p, "p", 171, 6277, 6286);
                            q = z / s;
                            CallChecker.varAssign(q, "q", 172, 6308, 6317);
                            final double r = CallChecker.varInit(((double) (FastMath.sqrt(((p * p) + (q * q))))), "r", 173, 6339, 6384);
                            p = p / r;
                            CallChecker.varAssign(p, "p", 174, 6406, 6415);
                            q = q / r;
                            CallChecker.varAssign(q, "q", 175, 6437, 6446);
                            for (int j = iu - 1; j < n; j++) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 179, 6572, 6578)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 179, 6572, 6578)[(iu - 1)], double[].class, 179, 6572, 6586)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 179, 6572, 6578)[(iu - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 179, 6572, 6578)[(iu - 1)], double[].class, 179, 6572, 6586);
                                        z = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 179, 6572, 6578)[(iu - 1)], double[].class, 179, 6572, 6586)[j];
                                        CallChecker.varAssign(z, "z", 179, 6568, 6590);
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 180, 6616, 6622)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)], double[].class, 180, 6616, 6630)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 180, 6649, 6655)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 180, 6649, 6655)[iu], double[].class, 180, 6649, 6659)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)], double[].class, 180, 6616, 6630);
                                                CallChecker.isCalled(matrixT, double[][].class, 180, 6649, 6655)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 180, 6649, 6655)[iu], double[].class, 180, 6649, 6659);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)], double[].class, 180, 6616, 6630)[j] = (q * z) + (p * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 180, 6649, 6655)[iu], double[].class, 180, 6649, 6659)[j]));
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)], double[].class, 180, 6616, 6630)[j], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 180, 6616, 6622)[(iu - 1)], double[].class, 180, 6616, 6630)[j]", 180, 6616, 6663);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 181, 6689, 6695)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 181, 6689, 6695)[iu], double[].class, 181, 6689, 6699)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 181, 6710, 6716)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 181, 6710, 6716)[iu], double[].class, 181, 6710, 6720)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 181, 6689, 6695)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 181, 6689, 6695)[iu], double[].class, 181, 6689, 6699);
                                                CallChecker.isCalled(matrixT, double[][].class, 181, 6710, 6716)[iu] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 181, 6710, 6716)[iu], double[].class, 181, 6710, 6720);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 181, 6689, 6695)[iu], double[].class, 181, 6689, 6699)[j] = (q * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 181, 6710, 6716)[iu], double[].class, 181, 6710, 6720)[j])) - (p * z);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 181, 6689, 6695)[iu], double[].class, 181, 6689, 6699)[j], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 181, 6689, 6695)[iu], double[].class, 181, 6689, 6699)[j]", 181, 6689, 6732);
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i <= iu; i++) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 186, 6880, 6886)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 186, 6880, 6886)[i], double[].class, 186, 6880, 6889)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 186, 6880, 6886)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 186, 6880, 6886)[i], double[].class, 186, 6880, 6889);
                                        z = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 186, 6880, 6886)[i], double[].class, 186, 6880, 6889)[(iu - 1)];
                                        CallChecker.varAssign(z, "z", 186, 6876, 6898);
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 187, 6924, 6930)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 187, 6924, 6930)[i], double[].class, 187, 6924, 6933)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 187, 6957, 6963)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 187, 6957, 6963)[i], double[].class, 187, 6957, 6966)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 187, 6924, 6930)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 187, 6924, 6930)[i], double[].class, 187, 6924, 6933);
                                                CallChecker.isCalled(matrixT, double[][].class, 187, 6957, 6963)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 187, 6957, 6963)[i], double[].class, 187, 6957, 6966);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 187, 6924, 6930)[i], double[].class, 187, 6924, 6933)[(iu - 1)] = (q * z) + (p * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 187, 6957, 6963)[i], double[].class, 187, 6957, 6966)[iu]));
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 187, 6924, 6930)[i], double[].class, 187, 6924, 6933)[(iu - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 187, 6924, 6930)[i], double[].class, 187, 6924, 6933)[(iu - 1)]", 187, 6924, 6971);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 188, 6997, 7003)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 188, 6997, 7003)[i], double[].class, 188, 6997, 7006)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 188, 7018, 7024)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 188, 7018, 7024)[i], double[].class, 188, 7018, 7027)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 188, 6997, 7003)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 188, 6997, 7003)[i], double[].class, 188, 6997, 7006);
                                                CallChecker.isCalled(matrixT, double[][].class, 188, 7018, 7024)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 188, 7018, 7024)[i], double[].class, 188, 7018, 7027);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 188, 6997, 7003)[i], double[].class, 188, 6997, 7006)[iu] = (q * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 188, 7018, 7024)[i], double[].class, 188, 7018, 7027)[iu])) - (p * z);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 188, 6997, 7003)[i], double[].class, 188, 6997, 7006)[iu], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 188, 6997, 7003)[i], double[].class, 188, 6997, 7006)[iu]", 188, 6997, 7040);
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i <= (n - 1); i++) {
                                if (CallChecker.beforeDeref(matrixP, double[][].class, 193, 7198, 7204)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 193, 7198, 7204)[i], double[].class, 193, 7198, 7207)) {
                                        CallChecker.isCalled(matrixP, double[][].class, 193, 7198, 7204)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 193, 7198, 7204)[i], double[].class, 193, 7198, 7207);
                                        z = CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 193, 7198, 7204)[i], double[].class, 193, 7198, 7207)[(iu - 1)];
                                        CallChecker.varAssign(z, "z", 193, 7194, 7216);
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixP, double[][].class, 194, 7242, 7248)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 194, 7242, 7248)[i], double[].class, 194, 7242, 7251)) {
                                        if (CallChecker.beforeDeref(matrixP, double[][].class, 194, 7275, 7281)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 194, 7275, 7281)[i], double[].class, 194, 7275, 7284)) {
                                                CallChecker.isCalled(matrixP, double[][].class, 194, 7242, 7248)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 194, 7242, 7248)[i], double[].class, 194, 7242, 7251);
                                                CallChecker.isCalled(matrixP, double[][].class, 194, 7275, 7281)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 194, 7275, 7281)[i], double[].class, 194, 7275, 7284);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 194, 7242, 7248)[i], double[].class, 194, 7242, 7251)[(iu - 1)] = (q * z) + (p * (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 194, 7275, 7281)[i], double[].class, 194, 7275, 7284)[iu]));
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 194, 7242, 7248)[i], double[].class, 194, 7242, 7251)[(iu - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 194, 7242, 7248)[i], double[].class, 194, 7242, 7251)[(iu - 1)]", 194, 7242, 7289);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixP, double[][].class, 195, 7315, 7321)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 195, 7315, 7321)[i], double[].class, 195, 7315, 7324)) {
                                        if (CallChecker.beforeDeref(matrixP, double[][].class, 195, 7336, 7342)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 195, 7336, 7342)[i], double[].class, 195, 7336, 7345)) {
                                                CallChecker.isCalled(matrixP, double[][].class, 195, 7315, 7321)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 195, 7315, 7321)[i], double[].class, 195, 7315, 7324);
                                                CallChecker.isCalled(matrixP, double[][].class, 195, 7336, 7342)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 195, 7336, 7342)[i], double[].class, 195, 7336, 7345);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 195, 7315, 7321)[i], double[].class, 195, 7315, 7324)[iu] = (q * (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 195, 7336, 7342)[i], double[].class, 195, 7336, 7345)[iu])) - (p * z);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 195, 7315, 7321)[i], double[].class, 195, 7315, 7324)[iu], "CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 195, 7315, 7321)[i], double[].class, 195, 7315, 7324)[iu]", 195, 7315, 7358);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        iu -= 2;
                        CallChecker.varAssign(iu, "iu", 198, 7416, 7423);
                        iteration = 0;
                        CallChecker.varAssign(iteration, "iteration", 199, 7441, 7454);
                    }else {
                        computeShift(il, iu, iteration, shift);
                        if ((++iteration) > (SchurTransformer.MAX_ITERATIONS)) {
                            throw new org.apache.commons.math3.exception.MaxCountExceededException(org.apache.commons.math3.exception.util.LocalizedFormats.CONVERGENCE_FAILED, SchurTransformer.MAX_ITERATIONS);
                        }
                        final double[] hVec = CallChecker.varInit(new double[3], "hVec", 211, 7956, 7991);
                        final int im = CallChecker.varInit(((int) (initQRStep(il, iu, shift, hVec))), "im", 213, 8010, 8056);
                        performDoubleQRStep(il, im, iu, shift, hVec);
                    }
                
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3820.methodEnd();
        }
    }

    private double getNorm() {
        MethodContext _bcornu_methode_context3821 = new MethodContext(double.class, 224, 8155, 8662);
        try {
            CallChecker.varInit(this, "this", 224, 8155, 8662);
            CallChecker.varInit(this.epsilon, "epsilon", 224, 8155, 8662);
            CallChecker.varInit(this.cachedPt, "cachedPt", 224, 8155, 8662);
            CallChecker.varInit(this.cachedT, "cachedT", 224, 8155, 8662);
            CallChecker.varInit(this.cachedP, "cachedP", 224, 8155, 8662);
            CallChecker.varInit(this.matrixT, "matrixT", 224, 8155, 8662);
            CallChecker.varInit(this.matrixP, "matrixP", 224, 8155, 8662);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 224, 8155, 8662);
            double norm = CallChecker.varInit(((double) (0.0)), "norm", 225, 8316, 8333);
            for (int i = 0; i < (CallChecker.isCalled(matrixT, double[][].class, 226, 8363, 8369).length); i++) {
                for (int j = FastMath.max((i - 1), 0); j < (CallChecker.isCalled(matrixT, double[][].class, 228, 8537, 8543).length); j++) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 229, 8597, 8603)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 229, 8597, 8603)[i], double[].class, 229, 8597, 8606)) {
                            CallChecker.isCalled(matrixT, double[][].class, 229, 8597, 8603)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 229, 8597, 8603)[i], double[].class, 229, 8597, 8606);
                            norm += FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 229, 8597, 8603)[i], double[].class, 229, 8597, 8606)[j]);
                            CallChecker.varAssign(norm, "norm", 229, 8576, 8611);
                        }
                    }
                }
            }
            return norm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3821.methodEnd();
        }
    }

    private int findSmallSubDiagonalElement(final int startIdx, final double norm) {
        MethodContext _bcornu_methode_context3822 = new MethodContext(int.class, 242, 8669, 9371);
        try {
            CallChecker.varInit(this, "this", 242, 8669, 9371);
            CallChecker.varInit(norm, "norm", 242, 8669, 9371);
            CallChecker.varInit(startIdx, "startIdx", 242, 8669, 9371);
            CallChecker.varInit(this.epsilon, "epsilon", 242, 8669, 9371);
            CallChecker.varInit(this.cachedPt, "cachedPt", 242, 8669, 9371);
            CallChecker.varInit(this.cachedT, "cachedT", 242, 8669, 9371);
            CallChecker.varInit(this.cachedP, "cachedP", 242, 8669, 9371);
            CallChecker.varInit(this.matrixT, "matrixT", 242, 8669, 9371);
            CallChecker.varInit(this.matrixP, "matrixP", 242, 8669, 9371);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 242, 8669, 9371);
            int l = CallChecker.varInit(((int) (startIdx)), "l", 243, 9020, 9036);
            while (l > 0) {
                double s = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(matrixT, double[][].class, 245, 9098, 9104)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 245, 9098, 9104)[(l - 1)], double[].class, 245, 9098, 9111)) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 245, 9136, 9142)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 245, 9136, 9142)[l], double[].class, 245, 9136, 9145)) {
                                CallChecker.isCalled(matrixT, double[][].class, 245, 9098, 9104)[(l - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 245, 9098, 9104)[(l - 1)], double[].class, 245, 9098, 9111);
                                CallChecker.isCalled(matrixT, double[][].class, 245, 9136, 9142)[l] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 245, 9136, 9142)[l], double[].class, 245, 9136, 9145);
                                s = (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 245, 9098, 9104)[(l - 1)], double[].class, 245, 9098, 9111)[(l - 1)])) + (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 245, 9136, 9142)[l], double[].class, 245, 9136, 9145)[l]));
                                CallChecker.varAssign(s, "s", 245, 9098, 9104);
                            }
                        }
                    }
                }
                if (s == 0.0) {
                    s = norm;
                    CallChecker.varAssign(s, "s", 247, 9196, 9204);
                }
                if (CallChecker.beforeDeref(matrixT, double[][].class, 249, 9249, 9255)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 249, 9249, 9255)[l], double[].class, 249, 9249, 9258)) {
                        CallChecker.isCalled(matrixT, double[][].class, 249, 9249, 9255)[l] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 249, 9249, 9255)[l], double[].class, 249, 9249, 9258);
                        if ((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 249, 9249, 9255)[l], double[].class, 249, 9249, 9258)[(l - 1)])) < ((epsilon) * s)) {
                            break;
                        }
                    }
                }
                l--;
            } 
            return l;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3822.methodEnd();
        }
    }

    private void computeShift(final int l, final int idx, final int iteration, final SchurTransformer.ShiftInfo shift) {
        MethodContext _bcornu_methode_context3823 = new MethodContext(void.class, 265, 9378, 11036);
        try {
            CallChecker.varInit(this, "this", 265, 9378, 11036);
            CallChecker.varInit(shift, "shift", 265, 9378, 11036);
            CallChecker.varInit(iteration, "iteration", 265, 9378, 11036);
            CallChecker.varInit(idx, "idx", 265, 9378, 11036);
            CallChecker.varInit(l, "l", 265, 9378, 11036);
            CallChecker.varInit(this.epsilon, "epsilon", 265, 9378, 11036);
            CallChecker.varInit(this.cachedPt, "cachedPt", 265, 9378, 11036);
            CallChecker.varInit(this.cachedT, "cachedT", 265, 9378, 11036);
            CallChecker.varInit(this.cachedP, "cachedP", 265, 9378, 11036);
            CallChecker.varInit(this.matrixT, "matrixT", 265, 9378, 11036);
            CallChecker.varInit(this.matrixP, "matrixP", 265, 9378, 11036);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 265, 9378, 11036);
            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 267, 9785, 9789)) {
                if (CallChecker.beforeDeref(matrixT, double[][].class, 267, 9795, 9801)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 267, 9795, 9801)[idx], double[].class, 267, 9795, 9806)) {
                        CallChecker.isCalled(matrixT, double[][].class, 267, 9795, 9801)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 267, 9795, 9801)[idx], double[].class, 267, 9795, 9806);
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 267, 9785, 9789).x = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 267, 9795, 9801)[idx], double[].class, 267, 9795, 9806)[idx];
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 267, 9785, 9789).x, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 267, 9785, 9789).x", 267, 9785, 9812);
                    }
                }
            }
            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 268, 9822, 9826)) {
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 268, 9832, 9836)) {
                    CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9822, 9826).y = CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9832, 9836).w = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9822, 9826).y, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9822, 9826).y", 268, 9822, 9845);
                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9832, 9836).w, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 268, 9832, 9836).w", 268, 9832, 9844);
                }
            }
            if (l < idx) {
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 270, 9882, 9886)) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 270, 9892, 9898)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 270, 9892, 9898)[(idx - 1)], double[].class, 270, 9892, 9907)) {
                            CallChecker.isCalled(matrixT, double[][].class, 270, 9892, 9898)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 270, 9892, 9898)[(idx - 1)], double[].class, 270, 9892, 9907);
                            CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 270, 9882, 9886).y = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 270, 9892, 9898)[(idx - 1)], double[].class, 270, 9892, 9907)[(idx - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 270, 9882, 9886).y, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 270, 9882, 9886).y", 270, 9882, 9917);
                        }
                    }
                }
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 271, 9931, 9935)) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 271, 9941, 9947)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 271, 9941, 9947)[idx], double[].class, 271, 9941, 9952)) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 271, 9965, 9971)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 271, 9965, 9971)[(idx - 1)], double[].class, 271, 9965, 9980)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 271, 9941, 9947)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 271, 9941, 9947)[idx], double[].class, 271, 9941, 9952);
                                    CallChecker.isCalled(matrixT, double[][].class, 271, 9965, 9971)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 271, 9965, 9971)[(idx - 1)], double[].class, 271, 9965, 9980);
                                    CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 271, 9931, 9935).w = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 271, 9941, 9947)[idx], double[].class, 271, 9941, 9952)[(idx - 1)]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 271, 9965, 9971)[(idx - 1)], double[].class, 271, 9965, 9980)[idx]);
                                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 271, 9931, 9935).w, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 271, 9931, 9935).w", 271, 9931, 9986);
                                }
                            }
                        }
                    }
                }
            }
            if (iteration == 10) {
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 276, 10087, 10091)) {
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 276, 10104, 10108)) {
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 276, 10087, 10091).exShift += CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 276, 10104, 10108).x;
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 276, 10087, 10091).exShift, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 276, 10087, 10091).exShift", 276, 10087, 10111);
                    }
                }
                for (int i = 0; i <= idx; i++) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 278, 10174, 10180)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 278, 10174, 10180)[i], double[].class, 278, 10174, 10183)) {
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 278, 10191, 10195)) {
                                CallChecker.isCalled(matrixT, double[][].class, 278, 10174, 10180)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 278, 10174, 10180)[i], double[].class, 278, 10174, 10183);
                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 278, 10174, 10180)[i], double[].class, 278, 10174, 10183)[i] -= CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 278, 10191, 10195).x;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 278, 10174, 10180)[i], double[].class, 278, 10174, 10183)[i], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 278, 10174, 10180)[i], double[].class, 278, 10174, 10183)[i]", 278, 10174, 10198);
                            }
                        }
                    }
                }
                CallChecker.isCalled(matrixT, double[][].class, 280, 10256, 10262)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 280, 10256, 10262)[idx], double[].class, 280, 10256, 10267);
                CallChecker.isCalled(matrixT, double[][].class, 280, 10294, 10300)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 280, 10294, 10300)[(idx - 1)], double[].class, 280, 10294, 10309);
                final double s = CallChecker.varInit(((double) ((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 280, 10256, 10262)[idx], double[].class, 280, 10256, 10267)[(idx - 1)])) + (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 280, 10294, 10300)[(idx - 1)], double[].class, 280, 10294, 10309)[(idx - 2)])))), "s", 280, 10226, 10320);
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 281, 10334, 10338)) {
                    CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 281, 10334, 10338).x = 0.75 * s;
                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 281, 10334, 10338).x, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 281, 10334, 10338).x", 281, 10334, 10352);
                }
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 282, 10366, 10370)) {
                    CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 282, 10366, 10370).y = 0.75 * s;
                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 282, 10366, 10370).y, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 282, 10366, 10370).y", 282, 10366, 10384);
                }
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 283, 10398, 10402)) {
                    CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 283, 10398, 10402).w = ((-0.4375) * s) * s;
                    CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 283, 10398, 10402).w, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 283, 10398, 10402).w", 283, 10398, 10423);
                }
            }
            if (iteration == 30) {
                double s = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 288, 10528, 10532)) {
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 288, 10538, 10542)) {
                        s = ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 288, 10528, 10532).y) - (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 288, 10538, 10542).x)) / 2.0;
                        CallChecker.varAssign(s, "s", 288, 10528, 10532);
                    }
                }
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 289, 10578, 10582)) {
                    s = (s * s) + (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 289, 10578, 10582).w);
                    CallChecker.varAssign(s, "s", 289, 10566, 10585);
                }
                if (s > 0.0) {
                    s = FastMath.sqrt(s);
                    CallChecker.varAssign(s, "s", 291, 10630, 10650);
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 292, 10672, 10676)) {
                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 292, 10682, 10686)) {
                            if ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 292, 10672, 10676).y) < (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 292, 10682, 10686).x)) {
                                s = -s;
                                CallChecker.varAssign(s, "s", 293, 10713, 10719);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 295, 10759, 10763)) {
                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 295, 10769, 10773)) {
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 295, 10781, 10785)) {
                                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 295, 10791, 10795)) {
                                    s = (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 295, 10759, 10763).x) - ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 295, 10769, 10773).w) / ((((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 295, 10781, 10785).y) - (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 295, 10791, 10795).x)) / 2.0) + s));
                                    CallChecker.varAssign(s, "s", 295, 10755, 10810);
                                }
                            }
                        }
                    }
                    for (int i = 0; i <= idx; i++) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 297, 10881, 10887)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 297, 10881, 10887)[i], double[].class, 297, 10881, 10890)) {
                                CallChecker.isCalled(matrixT, double[][].class, 297, 10881, 10887)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 297, 10881, 10887)[i], double[].class, 297, 10881, 10890);
                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 297, 10881, 10887)[i], double[].class, 297, 10881, 10890)[i] -= s;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 297, 10881, 10887)[i], double[].class, 297, 10881, 10890)[i], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 297, 10881, 10887)[i], double[].class, 297, 10881, 10890)[i]", 297, 10881, 10899);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 299, 10935, 10939)) {
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 299, 10935, 10939).exShift += s;
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 299, 10935, 10939).exShift, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 299, 10935, 10939).exShift", 299, 10935, 10953);
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 300, 10971, 10975)) {
                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 300, 10981, 10985)) {
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 300, 10991, 10995)) {
                                CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10971, 10975).x = CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10981, 10985).y = CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10991, 10995).w = 0.964;
                                CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10971, 10975).x, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10971, 10975).x", 300, 10971, 11006);
                                CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10981, 10985).y, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10981, 10985).y", 300, 10981, 11005);
                                CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10991, 10995).w, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 300, 10991, 10995).w", 300, 10991, 11005);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3823.methodEnd();
        }
    }

    private int initQRStep(int il, final int iu, final SchurTransformer.ShiftInfo shift, double[] hVec) {
        MethodContext _bcornu_methode_context3824 = new MethodContext(int.class, 314, 11043, 12468);
        try {
            CallChecker.varInit(this, "this", 314, 11043, 12468);
            CallChecker.varInit(hVec, "hVec", 314, 11043, 12468);
            CallChecker.varInit(shift, "shift", 314, 11043, 12468);
            CallChecker.varInit(iu, "iu", 314, 11043, 12468);
            CallChecker.varInit(il, "il", 314, 11043, 12468);
            CallChecker.varInit(this.epsilon, "epsilon", 314, 11043, 12468);
            CallChecker.varInit(this.cachedPt, "cachedPt", 314, 11043, 12468);
            CallChecker.varInit(this.cachedT, "cachedT", 314, 11043, 12468);
            CallChecker.varInit(this.cachedP, "cachedP", 314, 11043, 12468);
            CallChecker.varInit(this.matrixT, "matrixT", 314, 11043, 12468);
            CallChecker.varInit(this.matrixP, "matrixP", 314, 11043, 12468);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 314, 11043, 12468);
            int im = CallChecker.varInit(((int) (iu - 2)), "im", 316, 11531, 11546);
            while (im >= il) {
                CallChecker.isCalled(matrixT, double[][].class, 318, 11604, 11610)[im] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 318, 11604, 11610)[im], double[].class, 318, 11604, 11614);
                final double z = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 318, 11604, 11610)[im], double[].class, 318, 11604, 11614)[im])), "z", 318, 11587, 11619);
                final double r = CallChecker.varInit(((double) ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 319, 11650, 11654).x) - z)), "r", 319, 11633, 11661);
                double s = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 320, 11686, 11690)) {
                    s = (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 320, 11686, 11690).y) - z;
                    CallChecker.varAssign(s, "s", 320, 11686, 11690);
                }
                if (CallChecker.beforeDeref(hVec, double[].class, 321, 11711, 11714)) {
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 321, 11730, 11734)) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 321, 11741, 11747)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 321, 11741, 11747)[(im + 1)], double[].class, 321, 11741, 11755)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 321, 11763, 11769)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 321, 11763, 11769)[im], double[].class, 321, 11763, 11773)) {
                                        hVec = CallChecker.beforeCalled(hVec, double[].class, 321, 11711, 11714);
                                        CallChecker.isCalled(matrixT, double[][].class, 321, 11741, 11747)[(im + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 321, 11741, 11747)[(im + 1)], double[].class, 321, 11741, 11755);
                                        CallChecker.isCalled(matrixT, double[][].class, 321, 11763, 11769)[im] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 321, 11763, 11769)[im], double[].class, 321, 11763, 11773);
                                        CallChecker.isCalled(hVec, double[].class, 321, 11711, 11714)[0] = (((r * s) - (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 321, 11730, 11734).w)) / (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 321, 11741, 11747)[(im + 1)], double[].class, 321, 11741, 11755)[im])) + (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 321, 11763, 11769)[im], double[].class, 321, 11763, 11773)[(im + 1)]);
                                        CallChecker.varAssign(CallChecker.isCalled(hVec, double[].class, 321, 11711, 11714)[0], "CallChecker.isCalled(hVec, double[].class, 321, 11711, 11714)[0]", 321, 11711, 11782);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(hVec, double[].class, 322, 11796, 11799)) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 322, 11806, 11812)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 322, 11806, 11812)[(im + 1)], double[].class, 322, 11806, 11820)) {
                            hVec = CallChecker.beforeCalled(hVec, double[].class, 322, 11796, 11799);
                            CallChecker.isCalled(matrixT, double[][].class, 322, 11806, 11812)[(im + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 322, 11806, 11812)[(im + 1)], double[].class, 322, 11806, 11820);
                            CallChecker.isCalled(hVec, double[].class, 322, 11796, 11799)[1] = (((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 322, 11806, 11812)[(im + 1)], double[].class, 322, 11806, 11820)[(im + 1)]) - z) - r) - s;
                            CallChecker.varAssign(CallChecker.isCalled(hVec, double[].class, 322, 11796, 11799)[1], "CallChecker.isCalled(hVec, double[].class, 322, 11796, 11799)[1]", 322, 11796, 11841);
                        }
                    }
                }
                if (CallChecker.beforeDeref(hVec, double[].class, 323, 11855, 11858)) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 323, 11865, 11871)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 323, 11865, 11871)[(im + 2)], double[].class, 323, 11865, 11879)) {
                            hVec = CallChecker.beforeCalled(hVec, double[].class, 323, 11855, 11858);
                            CallChecker.isCalled(matrixT, double[][].class, 323, 11865, 11871)[(im + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 323, 11865, 11871)[(im + 2)], double[].class, 323, 11865, 11879);
                            CallChecker.isCalled(hVec, double[].class, 323, 11855, 11858)[2] = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 323, 11865, 11871)[(im + 2)], double[].class, 323, 11865, 11879)[(im + 1)];
                            CallChecker.varAssign(CallChecker.isCalled(hVec, double[].class, 323, 11855, 11858)[2], "CallChecker.isCalled(hVec, double[].class, 323, 11855, 11858)[2]", 323, 11855, 11888);
                        }
                    }
                }
                if (im == il) {
                    break;
                }
                CallChecker.isCalled(matrixT, double[][].class, 329, 12001, 12007)[im] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 329, 12001, 12007)[im], double[].class, 329, 12001, 12011);
                hVec = CallChecker.beforeCalled(hVec, double[].class, 329, 12038, 12041);
                hVec = CallChecker.beforeCalled(hVec, double[].class, 329, 12062, 12065);
                final double lhs = CallChecker.varInit(((double) ((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 329, 12001, 12007)[im], double[].class, 329, 12001, 12011)[(im - 1)])) * ((FastMath.abs(CallChecker.isCalled(hVec, double[].class, 329, 12038, 12041)[1])) + (FastMath.abs(CallChecker.isCalled(hVec, double[].class, 329, 12062, 12065)[2]))))), "lhs", 329, 11969, 12071);
                hVec = CallChecker.beforeCalled(hVec, double[].class, 330, 12117, 12120);
                CallChecker.isCalled(matrixT, double[][].class, 330, 12142, 12148)[(im - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 330, 12142, 12148)[(im - 1)], double[].class, 330, 12142, 12156);
                CallChecker.isCalled(matrixT, double[][].class, 332, 12312, 12318)[(im + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 332, 12312, 12318)[(im + 1)], double[].class, 332, 12312, 12326);
                final double rhs = CallChecker.varInit(((double) ((FastMath.abs(CallChecker.isCalled(hVec, double[].class, 330, 12117, 12120)[0])) * (((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 330, 12142, 12148)[(im - 1)], double[].class, 330, 12142, 12156)[(im - 1)])) + (FastMath.abs(z))) + (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 332, 12312, 12318)[(im + 1)], double[].class, 332, 12312, 12326)[(im + 1)]))))), "rhs", 330, 12085, 12337);
                if (lhs < ((epsilon) * rhs)) {
                    break;
                }
                im--;
            } 
            return im;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3824.methodEnd();
        }
    }

    private void performDoubleQRStep(final int il, final int im, final int iu, final SchurTransformer.ShiftInfo shift, final double[] hVec) {
        MethodContext _bcornu_methode_context3825 = new MethodContext(void.class, 352, 12475, 16080);
        try {
            CallChecker.varInit(this, "this", 352, 12475, 16080);
            CallChecker.varInit(hVec, "hVec", 352, 12475, 16080);
            CallChecker.varInit(shift, "shift", 352, 12475, 16080);
            CallChecker.varInit(iu, "iu", 352, 12475, 16080);
            CallChecker.varInit(im, "im", 352, 12475, 16080);
            CallChecker.varInit(il, "il", 352, 12475, 16080);
            CallChecker.varInit(this.epsilon, "epsilon", 352, 12475, 16080);
            CallChecker.varInit(this.cachedPt, "cachedPt", 352, 12475, 16080);
            CallChecker.varInit(this.cachedT, "cachedT", 352, 12475, 16080);
            CallChecker.varInit(this.cachedP, "cachedP", 352, 12475, 16080);
            CallChecker.varInit(this.matrixT, "matrixT", 352, 12475, 16080);
            CallChecker.varInit(this.matrixP, "matrixP", 352, 12475, 16080);
            CallChecker.varInit(MAX_ITERATIONS, "org.apache.commons.math3.linear.SchurTransformer.MAX_ITERATIONS", 352, 12475, 16080);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.matrixT, double[][].class, 355, 12999, 13005).length)), "n", 355, 12985, 13013);
            double p = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(hVec, double[].class, 356, 13034, 13037)) {
                p = CallChecker.isCalled(hVec, double[].class, 356, 13034, 13037)[0];
                CallChecker.varAssign(p, "p", 356, 13034, 13037);
            }
            double q = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(hVec, double[].class, 357, 13062, 13065)) {
                q = CallChecker.isCalled(hVec, double[].class, 357, 13062, 13065)[1];
                CallChecker.varAssign(q, "q", 357, 13062, 13065);
            }
            double r = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(hVec, double[].class, 358, 13090, 13093)) {
                r = CallChecker.isCalled(hVec, double[].class, 358, 13090, 13093)[2];
                CallChecker.varAssign(r, "r", 358, 13090, 13093);
            }
            for (int k = im; k <= (iu - 1); k++) {
                boolean notlast = CallChecker.varInit(((boolean) (k != (iu - 1))), "notlast", 361, 13157, 13188);
                if (k != im) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 363, 13237, 13243)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 363, 13237, 13243)[k], double[].class, 363, 13237, 13246)) {
                            CallChecker.isCalled(matrixT, double[][].class, 363, 13237, 13243)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 363, 13237, 13243)[k], double[].class, 363, 13237, 13246);
                            p = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 363, 13237, 13243)[k], double[].class, 363, 13237, 13246)[(k - 1)];
                            CallChecker.varAssign(p, "p", 363, 13233, 13254);
                        }
                    }
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 364, 13276, 13282)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 364, 13276, 13282)[(k + 1)], double[].class, 364, 13276, 13289)) {
                            CallChecker.isCalled(matrixT, double[][].class, 364, 13276, 13282)[(k + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 364, 13276, 13282)[(k + 1)], double[].class, 364, 13276, 13289);
                            q = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 364, 13276, 13282)[(k + 1)], double[].class, 364, 13276, 13289)[(k - 1)];
                            CallChecker.varAssign(q, "q", 364, 13272, 13297);
                        }
                    }
                    if (notlast) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 365, 13329, 13335)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 365, 13329, 13335)[(k + 2)], double[].class, 365, 13329, 13342)) {
                                CallChecker.isCalled(matrixT, double[][].class, 365, 13329, 13335)[(k + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 365, 13329, 13335)[(k + 2)], double[].class, 365, 13329, 13342);
                                r = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 365, 13329, 13335)[(k + 2)], double[].class, 365, 13329, 13342)[(k - 1)];
                                CallChecker.varAssign(r, "r", 365, 13315, 13356);
                            }
                        }
                    }else {
                        r = 0.0;
                        CallChecker.varAssign(r, "r", 365, 13315, 13356);
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 366, 13374, 13378)) {
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 366, 13374, 13378).x = ((FastMath.abs(p)) + (FastMath.abs(q))) + (FastMath.abs(r));
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 366, 13374, 13378).x, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 366, 13374, 13378).x", 366, 13374, 13435);
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 367, 13475, 13479)) {
                        if (!(Precision.equals(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 367, 13475, 13479).x, 0.0, epsilon))) {
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 368, 13529, 13533)) {
                                p = p / (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 368, 13529, 13533).x);
                                CallChecker.varAssign(p, "p", 368, 13521, 13536);
                            }
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 369, 13566, 13570)) {
                                q = q / (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 369, 13566, 13570).x);
                                CallChecker.varAssign(q, "q", 369, 13558, 13573);
                            }
                            if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 370, 13603, 13607)) {
                                r = r / (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 370, 13603, 13607).x);
                                CallChecker.varAssign(r, "r", 370, 13595, 13610);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 373, 13660, 13664)) {
                    if ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 373, 13660, 13664).x) == 0.0) {
                        break;
                    }
                }
                double s = CallChecker.varInit(((double) (FastMath.sqrt((((p * p) + (q * q)) + (r * r))))), "s", 376, 13727, 13774);
                if (p < 0.0) {
                    s = -s;
                    CallChecker.varAssign(s, "s", 378, 13819, 13825);
                }
                if (s != 0.0) {
                    if (k != im) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 382, 13920, 13926)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 382, 13920, 13926)[k], double[].class, 382, 13920, 13929)) {
                                if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 382, 13945, 13949)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 382, 13920, 13926)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 382, 13920, 13926)[k], double[].class, 382, 13920, 13929);
                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 382, 13920, 13926)[k], double[].class, 382, 13920, 13929)[(k - 1)] = (-s) * (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 382, 13945, 13949).x);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 382, 13920, 13926)[k], double[].class, 382, 13920, 13929)[(k - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 382, 13920, 13926)[k], double[].class, 382, 13920, 13929)[(k - 1)]", 382, 13920, 13952);
                                }
                            }
                        }
                    }else
                        if (il != im) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 384, 14013, 14019)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 384, 14013, 14019)[k], double[].class, 384, 14013, 14022)) {
                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 384, 14034, 14040)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 384, 14034, 14040)[k], double[].class, 384, 14034, 14043)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 384, 14013, 14019)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 384, 14013, 14019)[k], double[].class, 384, 14013, 14022);
                                            CallChecker.isCalled(matrixT, double[][].class, 384, 14034, 14040)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 384, 14034, 14040)[k], double[].class, 384, 14034, 14043);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 384, 14013, 14019)[k], double[].class, 384, 14013, 14022)[(k - 1)] = -(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 384, 14034, 14040)[k], double[].class, 384, 14034, 14043)[(k - 1)]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 384, 14013, 14019)[k], double[].class, 384, 14013, 14022)[(k - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 384, 14013, 14019)[k], double[].class, 384, 14013, 14022)[(k - 1)]", 384, 14013, 14051);
                                        }
                                    }
                                }
                            }
                        }
                    
                    p = p + s;
                    CallChecker.varAssign(p, "p", 386, 14087, 14096);
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 387, 14114, 14118)) {
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 387, 14114, 14118).x = p / s;
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 387, 14114, 14118).x, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 387, 14114, 14118).x", 387, 14114, 14129);
                    }
                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 388, 14147, 14151)) {
                        CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 388, 14147, 14151).y = q / s;
                        CallChecker.varAssign(CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 388, 14147, 14151).y, "CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 388, 14147, 14151).y", 388, 14147, 14162);
                    }
                    double z = CallChecker.varInit(((double) (r / s)), "z", 389, 14180, 14196);
                    q = q / p;
                    CallChecker.varAssign(q, "q", 390, 14214, 14223);
                    r = r / p;
                    CallChecker.varAssign(r, "r", 391, 14241, 14250);
                    for (int j = k; j < n; j++) {
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 395, 14359, 14365)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 395, 14359, 14365)[k], double[].class, 395, 14359, 14368)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 395, 14379, 14385)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 395, 14379, 14385)[(k + 1)], double[].class, 395, 14379, 14392)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 395, 14359, 14365)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 395, 14359, 14365)[k], double[].class, 395, 14359, 14368);
                                        CallChecker.isCalled(matrixT, double[][].class, 395, 14379, 14385)[(k + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 395, 14379, 14385)[(k + 1)], double[].class, 395, 14379, 14392);
                                        p = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 395, 14359, 14365)[k], double[].class, 395, 14359, 14368)[j]) + (q * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 395, 14379, 14385)[(k + 1)], double[].class, 395, 14379, 14392)[j]));
                                        CallChecker.varAssign(p, "p", 395, 14355, 14396);
                                    }
                                }
                            }
                        }
                        if (notlast) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 397, 14469, 14475)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 397, 14469, 14475)[(k + 2)], double[].class, 397, 14469, 14482)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 397, 14469, 14475)[(k + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 397, 14469, 14475)[(k + 2)], double[].class, 397, 14469, 14482);
                                    p = p + (r * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 397, 14469, 14475)[(k + 2)], double[].class, 397, 14469, 14482)[j]));
                                    CallChecker.varAssign(p, "p", 397, 14457, 14486);
                                }
                            }
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 398, 14512, 14518)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 398, 14512, 14518)[(k + 2)], double[].class, 398, 14512, 14525)) {
                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 398, 14532, 14538)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 398, 14532, 14538)[(k + 2)], double[].class, 398, 14532, 14545)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 398, 14512, 14518)[(k + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 398, 14512, 14518)[(k + 2)], double[].class, 398, 14512, 14525);
                                            CallChecker.isCalled(matrixT, double[][].class, 398, 14532, 14538)[(k + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 398, 14532, 14538)[(k + 2)], double[].class, 398, 14532, 14545);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 398, 14512, 14518)[(k + 2)], double[].class, 398, 14512, 14525)[j] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 398, 14532, 14538)[(k + 2)], double[].class, 398, 14532, 14545)[j]) - (p * z);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 398, 14512, 14518)[(k + 2)], double[].class, 398, 14512, 14525)[j], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 398, 14512, 14518)[(k + 2)], double[].class, 398, 14512, 14525)[j]", 398, 14512, 14557);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 400, 14601, 14607)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 400, 14601, 14607)[k], double[].class, 400, 14601, 14610)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 400, 14617, 14623)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 400, 14617, 14623)[k], double[].class, 400, 14617, 14626)) {
                                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 400, 14637, 14641)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 400, 14601, 14607)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 400, 14601, 14607)[k], double[].class, 400, 14601, 14610);
                                            CallChecker.isCalled(matrixT, double[][].class, 400, 14617, 14623)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 400, 14617, 14623)[k], double[].class, 400, 14617, 14626);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 400, 14601, 14607)[k], double[].class, 400, 14601, 14610)[j] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 400, 14617, 14623)[k], double[].class, 400, 14617, 14626)[j]) - (p * (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 400, 14637, 14641).x));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 400, 14601, 14607)[k], double[].class, 400, 14601, 14610)[j], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 400, 14601, 14607)[k], double[].class, 400, 14601, 14610)[j]", 400, 14601, 14644);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 401, 14666, 14672)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 401, 14666, 14672)[(k + 1)], double[].class, 401, 14666, 14679)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 401, 14686, 14692)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 401, 14686, 14692)[(k + 1)], double[].class, 401, 14686, 14699)) {
                                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 401, 14710, 14714)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 401, 14666, 14672)[(k + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 401, 14666, 14672)[(k + 1)], double[].class, 401, 14666, 14679);
                                            CallChecker.isCalled(matrixT, double[][].class, 401, 14686, 14692)[(k + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 401, 14686, 14692)[(k + 1)], double[].class, 401, 14686, 14699);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 401, 14666, 14672)[(k + 1)], double[].class, 401, 14666, 14679)[j] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 401, 14686, 14692)[(k + 1)], double[].class, 401, 14686, 14699)[j]) - (p * (CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 401, 14710, 14714).y));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 401, 14666, 14672)[(k + 1)], double[].class, 401, 14666, 14679)[j], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 401, 14666, 14672)[(k + 1)], double[].class, 401, 14666, 14679)[j]", 401, 14666, 14717);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i <= (FastMath.min(iu, (k + 3))); i++) {
                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 406, 14870, 14874)) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 406, 14880, 14886)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 406, 14880, 14886)[i], double[].class, 406, 14880, 14889)) {
                                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 406, 14896, 14900)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 406, 14906, 14912)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 406, 14906, 14912)[i], double[].class, 406, 14906, 14915)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 406, 14880, 14886)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 406, 14880, 14886)[i], double[].class, 406, 14880, 14889);
                                                CallChecker.isCalled(matrixT, double[][].class, 406, 14906, 14912)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 406, 14906, 14912)[i], double[].class, 406, 14906, 14915);
                                                p = ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 406, 14870, 14874).x) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 406, 14880, 14886)[i], double[].class, 406, 14880, 14889)[k])) + ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 406, 14896, 14900).y) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 406, 14906, 14912)[i], double[].class, 406, 14906, 14915)[(k + 1)]));
                                                CallChecker.varAssign(p, "p", 406, 14866, 14923);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (notlast) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 408, 14996, 15002)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 408, 14996, 15002)[i], double[].class, 408, 14996, 15005)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 408, 14996, 15002)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 408, 14996, 15002)[i], double[].class, 408, 14996, 15005);
                                    p = p + (z * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 408, 14996, 15002)[i], double[].class, 408, 14996, 15005)[(k + 2)]));
                                    CallChecker.varAssign(p, "p", 408, 14984, 15013);
                                }
                            }
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 409, 15039, 15045)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 409, 15039, 15045)[i], double[].class, 409, 15039, 15048)) {
                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 409, 15059, 15065)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 409, 15059, 15065)[i], double[].class, 409, 15059, 15068)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 409, 15039, 15045)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 409, 15039, 15045)[i], double[].class, 409, 15039, 15048);
                                            CallChecker.isCalled(matrixT, double[][].class, 409, 15059, 15065)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 409, 15059, 15065)[i], double[].class, 409, 15059, 15068);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 409, 15039, 15045)[i], double[].class, 409, 15039, 15048)[(k + 2)] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 409, 15059, 15065)[i], double[].class, 409, 15059, 15068)[(k + 2)]) - (p * r);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 409, 15039, 15045)[i], double[].class, 409, 15039, 15048)[(k + 2)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 409, 15039, 15045)[i], double[].class, 409, 15039, 15048)[(k + 2)]", 409, 15039, 15084);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 411, 15128, 15134)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 411, 15128, 15134)[i], double[].class, 411, 15128, 15137)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 411, 15144, 15150)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 411, 15144, 15150)[i], double[].class, 411, 15144, 15153)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 411, 15128, 15134)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 411, 15128, 15134)[i], double[].class, 411, 15128, 15137);
                                        CallChecker.isCalled(matrixT, double[][].class, 411, 15144, 15150)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 411, 15144, 15150)[i], double[].class, 411, 15144, 15153);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 411, 15128, 15134)[i], double[].class, 411, 15128, 15137)[k] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 411, 15144, 15150)[i], double[].class, 411, 15144, 15153)[k]) - p;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 411, 15128, 15134)[i], double[].class, 411, 15128, 15137)[k], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 411, 15128, 15134)[i], double[].class, 411, 15128, 15137)[k]", 411, 15128, 15161);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 412, 15183, 15189)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 412, 15183, 15189)[i], double[].class, 412, 15183, 15192)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 412, 15203, 15209)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 412, 15203, 15209)[i], double[].class, 412, 15203, 15212)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 412, 15183, 15189)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 412, 15183, 15189)[i], double[].class, 412, 15183, 15192);
                                        CallChecker.isCalled(matrixT, double[][].class, 412, 15203, 15209)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 412, 15203, 15209)[i], double[].class, 412, 15203, 15212);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 412, 15183, 15189)[i], double[].class, 412, 15183, 15192)[(k + 1)] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 412, 15203, 15209)[i], double[].class, 412, 15203, 15212)[(k + 1)]) - (p * q);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 412, 15183, 15189)[i], double[].class, 412, 15183, 15192)[(k + 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 412, 15183, 15189)[i], double[].class, 412, 15183, 15192)[(k + 1)]", 412, 15183, 15228);
                                    }
                                }
                            }
                        }
                    }
                    final int high = CallChecker.varInit(((int) ((CallChecker.isCalled(this.matrixT, double[][].class, 416, 15328, 15334).length) - 1)), "high", 416, 15265, 15346);
                    for (int i = 0; i <= high; i++) {
                        if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 418, 15422, 15426)) {
                            if (CallChecker.beforeDeref(matrixP, double[][].class, 418, 15432, 15438)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 418, 15432, 15438)[i], double[].class, 418, 15432, 15441)) {
                                    if (CallChecker.beforeDeref(shift, SchurTransformer.ShiftInfo.class, 418, 15448, 15452)) {
                                        if (CallChecker.beforeDeref(matrixP, double[][].class, 418, 15458, 15464)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 418, 15458, 15464)[i], double[].class, 418, 15458, 15467)) {
                                                CallChecker.isCalled(matrixP, double[][].class, 418, 15432, 15438)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 418, 15432, 15438)[i], double[].class, 418, 15432, 15441);
                                                CallChecker.isCalled(matrixP, double[][].class, 418, 15458, 15464)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 418, 15458, 15464)[i], double[].class, 418, 15458, 15467);
                                                p = ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 418, 15422, 15426).x) * (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 418, 15432, 15438)[i], double[].class, 418, 15432, 15441)[k])) + ((CallChecker.isCalled(shift, SchurTransformer.ShiftInfo.class, 418, 15448, 15452).y) * (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 418, 15458, 15464)[i], double[].class, 418, 15458, 15467)[(k + 1)]));
                                                CallChecker.varAssign(p, "p", 418, 15418, 15475);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (notlast) {
                            if (CallChecker.beforeDeref(matrixP, double[][].class, 420, 15548, 15554)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 420, 15548, 15554)[i], double[].class, 420, 15548, 15557)) {
                                    CallChecker.isCalled(matrixP, double[][].class, 420, 15548, 15554)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 420, 15548, 15554)[i], double[].class, 420, 15548, 15557);
                                    p = p + (z * (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 420, 15548, 15554)[i], double[].class, 420, 15548, 15557)[(k + 2)]));
                                    CallChecker.varAssign(p, "p", 420, 15536, 15565);
                                }
                            }
                            if (CallChecker.beforeDeref(matrixP, double[][].class, 421, 15591, 15597)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 421, 15591, 15597)[i], double[].class, 421, 15591, 15600)) {
                                    if (CallChecker.beforeDeref(matrixP, double[][].class, 421, 15611, 15617)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 421, 15611, 15617)[i], double[].class, 421, 15611, 15620)) {
                                            CallChecker.isCalled(matrixP, double[][].class, 421, 15591, 15597)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 421, 15591, 15597)[i], double[].class, 421, 15591, 15600);
                                            CallChecker.isCalled(matrixP, double[][].class, 421, 15611, 15617)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 421, 15611, 15617)[i], double[].class, 421, 15611, 15620);
                                            CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 421, 15591, 15597)[i], double[].class, 421, 15591, 15600)[(k + 2)] = (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 421, 15611, 15617)[i], double[].class, 421, 15611, 15620)[(k + 2)]) - (p * r);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 421, 15591, 15597)[i], double[].class, 421, 15591, 15600)[(k + 2)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 421, 15591, 15597)[i], double[].class, 421, 15591, 15600)[(k + 2)]", 421, 15591, 15636);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixP, double[][].class, 423, 15680, 15686)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 423, 15680, 15686)[i], double[].class, 423, 15680, 15689)) {
                                if (CallChecker.beforeDeref(matrixP, double[][].class, 423, 15696, 15702)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 423, 15696, 15702)[i], double[].class, 423, 15696, 15705)) {
                                        CallChecker.isCalled(matrixP, double[][].class, 423, 15680, 15686)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 423, 15680, 15686)[i], double[].class, 423, 15680, 15689);
                                        CallChecker.isCalled(matrixP, double[][].class, 423, 15696, 15702)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 423, 15696, 15702)[i], double[].class, 423, 15696, 15705);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 423, 15680, 15686)[i], double[].class, 423, 15680, 15689)[k] = (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 423, 15696, 15702)[i], double[].class, 423, 15696, 15705)[k]) - p;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 423, 15680, 15686)[i], double[].class, 423, 15680, 15689)[k], "CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 423, 15680, 15686)[i], double[].class, 423, 15680, 15689)[k]", 423, 15680, 15713);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixP, double[][].class, 424, 15735, 15741)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 424, 15735, 15741)[i], double[].class, 424, 15735, 15744)) {
                                if (CallChecker.beforeDeref(matrixP, double[][].class, 424, 15755, 15761)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 424, 15755, 15761)[i], double[].class, 424, 15755, 15764)) {
                                        CallChecker.isCalled(matrixP, double[][].class, 424, 15735, 15741)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 424, 15735, 15741)[i], double[].class, 424, 15735, 15744);
                                        CallChecker.isCalled(matrixP, double[][].class, 424, 15755, 15761)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 424, 15755, 15761)[i], double[].class, 424, 15755, 15764);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 424, 15735, 15741)[i], double[].class, 424, 15735, 15744)[(k + 1)] = (CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 424, 15755, 15761)[i], double[].class, 424, 15755, 15764)[(k + 1)]) - (p * q);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 424, 15735, 15741)[i], double[].class, 424, 15735, 15744)[(k + 1)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixP, double[][].class, 424, 15735, 15741)[i], double[].class, 424, 15735, 15744)[(k + 1)]", 424, 15735, 15780);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = im + 2; i <= iu; i++) {
                if (CallChecker.beforeDeref(matrixT, double[][].class, 431, 15960, 15966)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 431, 15960, 15966)[i], double[].class, 431, 15960, 15969)) {
                        CallChecker.isCalled(matrixT, double[][].class, 431, 15960, 15966)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 431, 15960, 15966)[i], double[].class, 431, 15960, 15969);
                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 431, 15960, 15966)[i], double[].class, 431, 15960, 15969)[(i - 2)] = 0.0;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 431, 15960, 15966)[i], double[].class, 431, 15960, 15969)[(i - 2)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 431, 15960, 15966)[i], double[].class, 431, 15960, 15969)[(i - 2)]", 431, 15960, 15981);
                    }
                }
                if (i > (im + 2)) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 433, 16029, 16035)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 433, 16029, 16035)[i], double[].class, 433, 16029, 16038)) {
                            CallChecker.isCalled(matrixT, double[][].class, 433, 16029, 16035)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 433, 16029, 16035)[i], double[].class, 433, 16029, 16038);
                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 433, 16029, 16035)[i], double[].class, 433, 16029, 16038)[(i - 3)] = 0.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 433, 16029, 16035)[i], double[].class, 433, 16029, 16038)[(i - 3)], "CallChecker.isCalled(CallChecker.isCalled(this.matrixT, double[][].class, 433, 16029, 16035)[i], double[].class, 433, 16029, 16038)[(i - 3)]", 433, 16029, 16050);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3825.methodEnd();
        }
    }
}

