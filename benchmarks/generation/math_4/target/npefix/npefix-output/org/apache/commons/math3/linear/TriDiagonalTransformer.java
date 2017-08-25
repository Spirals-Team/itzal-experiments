package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

class TriDiagonalTransformer {
    private final double[][] householderVectors;

    private final double[] main;

    private final double[] secondary;

    private RealMatrix cachedQ;

    private RealMatrix cachedQt;

    private RealMatrix cachedT;

    public TriDiagonalTransformer(RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context440 = new ConstructorContext(TriDiagonalTransformer.class, 62, 2250, 3165);
        try {
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 63, 2682, 2687)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 63, 2682, 2687);
                if (!(CallChecker.isCalled(matrix, RealMatrix.class, 63, 2682, 2687).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 64, 2750, 2755)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 65, 2823, 2828)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 64, 2750, 2755);
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 65, 2823, 2828);
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, RealMatrix.class, 64, 2750, 2755).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 65, 2823, 2828).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 68, 2886, 2891);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 68, 2886, 2891).getRowDimension())), "m", 68, 2872, 2910);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 69, 2941, 2946);
            householderVectors = CallChecker.isCalled(matrix, RealMatrix.class, 69, 2941, 2946).getData();
            CallChecker.varAssign(this.householderVectors, "this.householderVectors", 69, 2920, 2957);
            main = new double[m];
            CallChecker.varAssign(this.main, "this.main", 70, 2967, 2992);
            secondary = new double[m - 1];
            CallChecker.varAssign(this.secondary, "this.secondary", 71, 3002, 3031);
            cachedQ = null;
            CallChecker.varAssign(this.cachedQ, "this.cachedQ", 72, 3041, 3057);
            cachedQt = null;
            CallChecker.varAssign(this.cachedQt, "this.cachedQt", 73, 3067, 3083);
            cachedT = null;
            CallChecker.varAssign(this.cachedT, "this.cachedT", 74, 3093, 3109);
            transform();
        } finally {
            _bcornu_methode_context440.methodEnd();
        }
    }

    public RealMatrix getQ() {
        MethodContext _bcornu_methode_context1872 = new MethodContext(RealMatrix.class, 85, 3172, 3482);
        try {
            CallChecker.varInit(this, "this", 85, 3172, 3482);
            CallChecker.varInit(this.cachedT, "cachedT", 85, 3172, 3482);
            CallChecker.varInit(this.cachedQt, "cachedQt", 85, 3172, 3482);
            CallChecker.varInit(this.cachedQ, "cachedQ", 85, 3172, 3482);
            CallChecker.varInit(this.secondary, "secondary", 85, 3172, 3482);
            CallChecker.varInit(this.main, "main", 85, 3172, 3482);
            CallChecker.varInit(this.householderVectors, "householderVectors", 85, 3172, 3482);
            if ((cachedQ) == null) {
                final RealMatrix npe_invocation_var185 = getQT();
                if (CallChecker.beforeDeref(npe_invocation_var185, RealMatrix.class, 87, 3423, 3429)) {
                    cachedQ = CallChecker.isCalled(npe_invocation_var185, RealMatrix.class, 87, 3423, 3429).transpose();
                    CallChecker.varAssign(this.cachedQ, "this.cachedQ", 87, 3413, 3442);
                }
            }
            return cachedQ;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1872.methodEnd();
        }
    }

    public RealMatrix getQT() {
        MethodContext _bcornu_methode_context1873 = new MethodContext(RealMatrix.class, 97, 3489, 5074);
        try {
            CallChecker.varInit(this, "this", 97, 3489, 5074);
            CallChecker.varInit(this.cachedT, "cachedT", 97, 3489, 5074);
            CallChecker.varInit(this.cachedQt, "cachedQt", 97, 3489, 5074);
            CallChecker.varInit(this.cachedQ, "cachedQ", 97, 3489, 5074);
            CallChecker.varInit(this.secondary, "secondary", 97, 3489, 5074);
            CallChecker.varInit(this.main, "main", 97, 3489, 5074);
            CallChecker.varInit(this.householderVectors, "householderVectors", 97, 3489, 5074);
            if ((cachedQt) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 99, 3763, 3780).length)), "m", 99, 3749, 3788);
                double[][] qta = CallChecker.varInit(new double[m][m], "qta", 100, 3802, 3835);
                for (int k = m - 1; k >= 1; --k) {
                    final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 104, 4005, 4022)[(k - 1)], "hK", 104, 3985, 4030);
                    if (CallChecker.beforeDeref(qta, double[][].class, 105, 4048, 4050)) {
                        qta = CallChecker.beforeCalled(qta, double[][].class, 105, 4048, 4050);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k], double[].class, 105, 4048, 4053)) {
                            qta = CallChecker.beforeCalled(qta, double[][].class, 105, 4048, 4050);
                            CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k], double[].class, 105, 4048, 4053);
                            CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k], double[].class, 105, 4048, 4053)[k] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k], double[].class, 105, 4048, 4053)[k], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 105, 4048, 4050)[k], double[].class, 105, 4048, 4053)[k]", 105, 4048, 4061);
                        }
                    }
                    if (CallChecker.beforeDeref(hK, double[].class, 106, 4083, 4084)) {
                        if ((CallChecker.isCalled(hK, double[].class, 106, 4083, 4084)[k]) != 0.0) {
                            final double inv = CallChecker.varInit(((double) (1.0 / ((CallChecker.isCalled(this.secondary, double[].class, 107, 4145, 4153)[(k - 1)]) * (CallChecker.isCalled(hK, double[].class, 107, 4164, 4165)[k])))), "inv", 107, 4119, 4170);
                            double beta = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(secondary, double[].class, 108, 4212, 4220)) {
                                beta = 1.0 / (CallChecker.isCalled(secondary, double[].class, 108, 4212, 4220)[(k - 1)]);
                                CallChecker.varAssign(beta, "beta", 108, 4212, 4220);
                            }
                            if (CallChecker.beforeDeref(qta, double[][].class, 109, 4250, 4252)) {
                                qta = CallChecker.beforeCalled(qta, double[][].class, 109, 4250, 4252);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k], double[].class, 109, 4250, 4255)) {
                                    if (CallChecker.beforeDeref(hK, double[].class, 109, 4273, 4274)) {
                                        qta = CallChecker.beforeCalled(qta, double[][].class, 109, 4250, 4252);
                                        CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k], double[].class, 109, 4250, 4255);
                                        CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k], double[].class, 109, 4250, 4255)[k] = 1 + (beta * (CallChecker.isCalled(hK, double[].class, 109, 4273, 4274)[k]));
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k], double[].class, 109, 4250, 4255)[k], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 109, 4250, 4252)[k], double[].class, 109, 4250, 4255)[k]", 109, 4250, 4278);
                                    }
                                }
                            }
                            for (int i = k + 1; i < m; ++i) {
                                if (CallChecker.beforeDeref(qta, double[][].class, 111, 4358, 4360)) {
                                    qta = CallChecker.beforeCalled(qta, double[][].class, 111, 4358, 4360);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k], double[].class, 111, 4358, 4363)) {
                                        if (CallChecker.beforeDeref(hK, double[].class, 111, 4377, 4378)) {
                                            qta = CallChecker.beforeCalled(qta, double[][].class, 111, 4358, 4360);
                                            CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k], double[].class, 111, 4358, 4363);
                                            CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k], double[].class, 111, 4358, 4363)[i] = beta * (CallChecker.isCalled(hK, double[].class, 111, 4377, 4378)[i]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k], double[].class, 111, 4358, 4363)[i], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 111, 4358, 4360)[k], double[].class, 111, 4358, 4363)[i]", 111, 4358, 4382);
                                        }
                                    }
                                }
                            }
                            for (int j = k + 1; j < m; ++j) {
                                beta = 0;
                                CallChecker.varAssign(beta, "beta", 114, 4484, 4492);
                                for (int i = k + 1; i < m; ++i) {
                                    if (CallChecker.beforeDeref(qta, double[][].class, 116, 4588, 4590)) {
                                        qta = CallChecker.beforeCalled(qta, double[][].class, 116, 4588, 4590);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 116, 4588, 4590)[j], double[].class, 116, 4588, 4593)) {
                                            if (CallChecker.beforeDeref(hK, double[].class, 116, 4600, 4601)) {
                                                qta = CallChecker.beforeCalled(qta, double[][].class, 116, 4588, 4590);
                                                CallChecker.isCalled(qta, double[][].class, 116, 4588, 4590)[j] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 116, 4588, 4590)[j], double[].class, 116, 4588, 4593);
                                                beta += (CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 116, 4588, 4590)[j], double[].class, 116, 4588, 4593)[i]) * (CallChecker.isCalled(hK, double[].class, 116, 4600, 4601)[i]);
                                                CallChecker.varAssign(beta, "beta", 116, 4580, 4605);
                                            }
                                        }
                                    }
                                }
                                beta *= inv;
                                CallChecker.varAssign(beta, "beta", 118, 4657, 4668);
                                if (CallChecker.beforeDeref(qta, double[][].class, 119, 4694, 4696)) {
                                    qta = CallChecker.beforeCalled(qta, double[][].class, 119, 4694, 4696);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j], double[].class, 119, 4694, 4699)) {
                                        if (CallChecker.beforeDeref(hK, double[].class, 119, 4713, 4714)) {
                                            qta = CallChecker.beforeCalled(qta, double[][].class, 119, 4694, 4696);
                                            CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j], double[].class, 119, 4694, 4699);
                                            CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j], double[].class, 119, 4694, 4699)[k] = beta * (CallChecker.isCalled(hK, double[].class, 119, 4713, 4714)[k]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j], double[].class, 119, 4694, 4699)[k], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 119, 4694, 4696)[j], double[].class, 119, 4694, 4699)[k]", 119, 4694, 4718);
                                        }
                                    }
                                }
                                for (int i = k + 1; i < m; ++i) {
                                    if (CallChecker.beforeDeref(qta, double[][].class, 121, 4806, 4808)) {
                                        qta = CallChecker.beforeCalled(qta, double[][].class, 121, 4806, 4808);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j], double[].class, 121, 4806, 4811)) {
                                            if (CallChecker.beforeDeref(hK, double[].class, 121, 4826, 4827)) {
                                                qta = CallChecker.beforeCalled(qta, double[][].class, 121, 4806, 4808);
                                                CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j], double[].class, 121, 4806, 4811);
                                                CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j], double[].class, 121, 4806, 4811)[i] += beta * (CallChecker.isCalled(hK, double[].class, 121, 4826, 4827)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j], double[].class, 121, 4806, 4811)[i], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 121, 4806, 4808)[j], double[].class, 121, 4806, 4811)[i]", 121, 4806, 4831);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(qta, double[][].class, 126, 4925, 4927)) {
                    qta = CallChecker.beforeCalled(qta, double[][].class, 126, 4925, 4927);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0], double[].class, 126, 4925, 4930)) {
                        qta = CallChecker.beforeCalled(qta, double[][].class, 126, 4925, 4927);
                        CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0], double[].class, 126, 4925, 4930);
                        CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0], double[].class, 126, 4925, 4930)[0] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0], double[].class, 126, 4925, 4930)[0], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 126, 4925, 4927)[0], double[].class, 126, 4925, 4930)[0]", 126, 4925, 4938);
                    }
                }
                cachedQt = MatrixUtils.createRealMatrix(qta);
                CallChecker.varAssign(this.cachedQt, "this.cachedQt", 127, 4952, 4996);
            }
            return cachedQt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1873.methodEnd();
        }
    }

    public RealMatrix getT() {
        MethodContext _bcornu_methode_context1874 = new MethodContext(RealMatrix.class, 138, 5081, 5759);
        try {
            CallChecker.varInit(this, "this", 138, 5081, 5759);
            CallChecker.varInit(this.cachedT, "cachedT", 138, 5081, 5759);
            CallChecker.varInit(this.cachedQt, "cachedQt", 138, 5081, 5759);
            CallChecker.varInit(this.cachedQ, "cachedQ", 138, 5081, 5759);
            CallChecker.varInit(this.secondary, "secondary", 138, 5081, 5759);
            CallChecker.varInit(this.main, "main", 138, 5081, 5759);
            CallChecker.varInit(this.householderVectors, "householderVectors", 138, 5081, 5759);
            if ((cachedT) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.main, double[].class, 140, 5267, 5270).length)), "m", 140, 5253, 5278);
                double[][] ta = CallChecker.varInit(new double[m][m], "ta", 141, 5292, 5324);
                for (int i = 0; i < m; ++i) {
                    if (CallChecker.beforeDeref(ta, double[][].class, 143, 5384, 5385)) {
                        ta = CallChecker.beforeCalled(ta, double[][].class, 143, 5384, 5385);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i], double[].class, 143, 5384, 5388)) {
                            if (CallChecker.beforeDeref(main, double[].class, 143, 5395, 5398)) {
                                ta = CallChecker.beforeCalled(ta, double[][].class, 143, 5384, 5385);
                                CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i], double[].class, 143, 5384, 5388);
                                CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i], double[].class, 143, 5384, 5388)[i] = CallChecker.isCalled(main, double[].class, 143, 5395, 5398)[i];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i], double[].class, 143, 5384, 5388)[i], "CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 143, 5384, 5385)[i], double[].class, 143, 5384, 5388)[i]", 143, 5384, 5402);
                            }
                        }
                    }
                    if (i > 0) {
                        if (CallChecker.beforeDeref(ta, double[][].class, 145, 5453, 5454)) {
                            ta = CallChecker.beforeCalled(ta, double[][].class, 145, 5453, 5454);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i], double[].class, 145, 5453, 5457)) {
                                if (CallChecker.beforeDeref(secondary, double[].class, 145, 5468, 5476)) {
                                    ta = CallChecker.beforeCalled(ta, double[][].class, 145, 5453, 5454);
                                    CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i], double[].class, 145, 5453, 5457);
                                    CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i], double[].class, 145, 5453, 5457)[(i - 1)] = CallChecker.isCalled(secondary, double[].class, 145, 5468, 5476)[(i - 1)];
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i], double[].class, 145, 5453, 5457)[(i - 1)], "CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 145, 5453, 5454)[i], double[].class, 145, 5453, 5457)[(i - 1)]", 145, 5453, 5484);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(main, double[].class, 147, 5528, 5531)) {
                        if (i < ((CallChecker.isCalled(main, double[].class, 147, 5528, 5531).length) - 1)) {
                            if (CallChecker.beforeDeref(ta, double[][].class, 148, 5567, 5568)) {
                                ta = CallChecker.beforeCalled(ta, double[][].class, 148, 5567, 5568);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i], double[].class, 148, 5567, 5571)) {
                                    if (CallChecker.beforeDeref(secondary, double[].class, 148, 5582, 5590)) {
                                        ta = CallChecker.beforeCalled(ta, double[][].class, 148, 5567, 5568);
                                        CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i], double[].class, 148, 5567, 5571);
                                        CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i], double[].class, 148, 5567, 5571)[(i + 1)] = CallChecker.isCalled(secondary, double[].class, 148, 5582, 5590)[i];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i], double[].class, 148, 5567, 5571)[(i + 1)], "CallChecker.isCalled(CallChecker.isCalled(ta, double[][].class, 148, 5567, 5568)[i], double[].class, 148, 5567, 5571)[(i + 1)]", 148, 5567, 5594);
                                    }
                                }
                            }
                        }
                    }
                }
                cachedT = MatrixUtils.createRealMatrix(ta);
                CallChecker.varAssign(this.cachedT, "this.cachedT", 151, 5640, 5682);
            }
            return cachedT;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1874.methodEnd();
        }
    }

    double[][] getHouseholderVectorsRef() {
        MethodContext _bcornu_methode_context1875 = new MethodContext(double[][].class, 164, 5766, 6123);
        try {
            CallChecker.varInit(this, "this", 164, 5766, 6123);
            CallChecker.varInit(this.cachedT, "cachedT", 164, 5766, 6123);
            CallChecker.varInit(this.cachedQt, "cachedQt", 164, 5766, 6123);
            CallChecker.varInit(this.cachedQ, "cachedQ", 164, 5766, 6123);
            CallChecker.varInit(this.secondary, "secondary", 164, 5766, 6123);
            CallChecker.varInit(this.main, "main", 164, 5766, 6123);
            CallChecker.varInit(this.householderVectors, "householderVectors", 164, 5766, 6123);
            return householderVectors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1875.methodEnd();
        }
    }

    double[] getMainDiagonalRef() {
        MethodContext _bcornu_methode_context1876 = new MethodContext(double[].class, 174, 6130, 6484);
        try {
            CallChecker.varInit(this, "this", 174, 6130, 6484);
            CallChecker.varInit(this.cachedT, "cachedT", 174, 6130, 6484);
            CallChecker.varInit(this.cachedQt, "cachedQt", 174, 6130, 6484);
            CallChecker.varInit(this.cachedQ, "cachedQ", 174, 6130, 6484);
            CallChecker.varInit(this.secondary, "secondary", 174, 6130, 6484);
            CallChecker.varInit(this.main, "main", 174, 6130, 6484);
            CallChecker.varInit(this.householderVectors, "householderVectors", 174, 6130, 6484);
            return main;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1876.methodEnd();
        }
    }

    double[] getSecondaryDiagonalRef() {
        MethodContext _bcornu_methode_context1877 = new MethodContext(double[].class, 184, 6491, 6865);
        try {
            CallChecker.varInit(this, "this", 184, 6491, 6865);
            CallChecker.varInit(this.cachedT, "cachedT", 184, 6491, 6865);
            CallChecker.varInit(this.cachedQt, "cachedQt", 184, 6491, 6865);
            CallChecker.varInit(this.cachedQ, "cachedQ", 184, 6491, 6865);
            CallChecker.varInit(this.secondary, "secondary", 184, 6491, 6865);
            CallChecker.varInit(this.main, "main", 184, 6491, 6865);
            CallChecker.varInit(this.householderVectors, "householderVectors", 184, 6491, 6865);
            return secondary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1877.methodEnd();
        }
    }

    private void transform() {
        MethodContext _bcornu_methode_context1878 = new MethodContext(void.class, 192, 6872, 9489);
        try {
            CallChecker.varInit(this, "this", 192, 6872, 9489);
            CallChecker.varInit(this.cachedT, "cachedT", 192, 6872, 9489);
            CallChecker.varInit(this.cachedQt, "cachedQt", 192, 6872, 9489);
            CallChecker.varInit(this.cachedQ, "cachedQ", 192, 6872, 9489);
            CallChecker.varInit(this.secondary, "secondary", 192, 6872, 9489);
            CallChecker.varInit(this.main, "main", 192, 6872, 9489);
            CallChecker.varInit(this.householderVectors, "householderVectors", 192, 6872, 9489);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 193, 7058, 7075).length)), "m", 193, 7044, 7083);
            final double[] z = CallChecker.varInit(new double[m], "z", 194, 7093, 7125);
            for (int k = 0; k < (m - 1); k++) {
                final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 198, 7259, 7276)[k], "hK", 198, 7239, 7280);
                if (CallChecker.beforeDeref(main, double[].class, 199, 7294, 7297)) {
                    if (CallChecker.beforeDeref(hK, double[].class, 199, 7304, 7305)) {
                        CallChecker.isCalled(main, double[].class, 199, 7294, 7297)[k] = CallChecker.isCalled(hK, double[].class, 199, 7304, 7305)[k];
                        CallChecker.varAssign(CallChecker.isCalled(this.main, double[].class, 199, 7294, 7297)[k], "CallChecker.isCalled(this.main, double[].class, 199, 7294, 7297)[k]", 199, 7294, 7309);
                    }
                }
                double xNormSqr = CallChecker.varInit(((double) (0)), "xNormSqr", 200, 7323, 7342);
                for (int j = k + 1; j < m; ++j) {
                    final double c = CallChecker.varInit(((double) (CallChecker.isCalled(hK, double[].class, 202, 7423, 7424)[j])), "c", 202, 7406, 7428);
                    xNormSqr += c * c;
                    CallChecker.varAssign(xNormSqr, "xNormSqr", 203, 7446, 7463);
                }
                double a = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hK, double[].class, 205, 7509, 7510)) {
                    if ((CallChecker.isCalled(hK, double[].class, 205, 7509, 7510)[(k + 1)]) > 0) {
                        a = -(FastMath.sqrt(xNormSqr));
                        CallChecker.varAssign(a, "a", 205, 7508, 7575);
                    }else {
                        a = FastMath.sqrt(xNormSqr);
                        CallChecker.varAssign(a, "a", 205, 7508, 7575);
                    }
                }
                if (CallChecker.beforeDeref(secondary, double[].class, 206, 7590, 7598)) {
                    CallChecker.isCalled(secondary, double[].class, 206, 7590, 7598)[k] = a;
                    CallChecker.varAssign(CallChecker.isCalled(this.secondary, double[].class, 206, 7590, 7598)[k], "CallChecker.isCalled(this.secondary, double[].class, 206, 7590, 7598)[k]", 206, 7590, 7606);
                }
                if (a != 0.0) {
                    if (CallChecker.beforeDeref(hK, double[].class, 210, 7735, 7736)) {
                        CallChecker.isCalled(hK, double[].class, 210, 7735, 7736)[(k + 1)] -= a;
                        CallChecker.varAssign(CallChecker.isCalled(hK, double[].class, 210, 7735, 7736)[(k + 1)], "CallChecker.isCalled(hK, double[].class, 210, 7735, 7736)[(k + 1)]", 210, 7735, 7749);
                    }
                    final double beta = CallChecker.varInit(((double) ((-1) / (a * (CallChecker.isCalled(hK, double[].class, 211, 7797, 7798)[(k + 1)])))), "beta", 211, 7767, 7807);
                    Arrays.fill(z, (k + 1), m, 0);
                    for (int i = k + 1; i < m; ++i) {
                        final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 219, 8232, 8249)[i], "hI", 219, 8212, 8253);
                        final double hKI = CallChecker.varInit(((double) (CallChecker.isCalled(hK, double[].class, 220, 8294, 8295)[i])), "hKI", 220, 8275, 8299);
                        double zI = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(hI, double[].class, 221, 8333, 8334)) {
                            zI = (CallChecker.isCalled(hI, double[].class, 221, 8333, 8334)[i]) * hKI;
                            CallChecker.varAssign(zI, "zI", 221, 8333, 8334);
                        }
                        for (int j = i + 1; j < m; ++j) {
                            final double hIJ = CallChecker.varInit(((double) (CallChecker.isCalled(hI, double[].class, 223, 8443, 8444)[j])), "hIJ", 223, 8424, 8448);
                            if (CallChecker.beforeDeref(hK, double[].class, 224, 8488, 8489)) {
                                zI += hIJ * (CallChecker.isCalled(hK, double[].class, 224, 8488, 8489)[j]);
                                CallChecker.varAssign(zI, "zI", 224, 8474, 8493);
                            }
                            if (CallChecker.beforeDeref(z, double[].class, 225, 8519, 8519)) {
                                CallChecker.isCalled(z, double[].class, 225, 8519, 8519)[j] += hIJ * hKI;
                                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 225, 8519, 8519)[j], "CallChecker.isCalled(z, double[].class, 225, 8519, 8519)[j]", 225, 8519, 8536);
                            }
                        }
                        if (CallChecker.beforeDeref(z, double[].class, 227, 8580, 8580)) {
                            if (CallChecker.beforeDeref(z, double[].class, 227, 8595, 8595)) {
                                CallChecker.isCalled(z, double[].class, 227, 8580, 8580)[i] = beta * ((CallChecker.isCalled(z, double[].class, 227, 8595, 8595)[i]) + zI);
                                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 227, 8580, 8580)[i], "CallChecker.isCalled(z, double[].class, 227, 8580, 8580)[i]", 227, 8580, 8605);
                            }
                        }
                    }
                    double gamma = CallChecker.varInit(((double) (0)), "gamma", 231, 8691, 8707);
                    for (int i = k + 1; i < m; ++i) {
                        if (CallChecker.beforeDeref(z, double[].class, 233, 8788, 8788)) {
                            if (CallChecker.beforeDeref(hK, double[].class, 233, 8795, 8796)) {
                                gamma += (CallChecker.isCalled(z, double[].class, 233, 8788, 8788)[i]) * (CallChecker.isCalled(hK, double[].class, 233, 8795, 8796)[i]);
                                CallChecker.varAssign(gamma, "gamma", 233, 8779, 8800);
                            }
                        }
                    }
                    gamma *= beta / 2;
                    CallChecker.varAssign(gamma, "gamma", 235, 8836, 8853);
                    for (int i = k + 1; i < m; ++i) {
                        if (CallChecker.beforeDeref(z, double[].class, 239, 8969, 8969)) {
                            if (CallChecker.beforeDeref(hK, double[].class, 239, 8985, 8986)) {
                                CallChecker.isCalled(z, double[].class, 239, 8969, 8969)[i] -= gamma * (CallChecker.isCalled(hK, double[].class, 239, 8985, 8986)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 239, 8969, 8969)[i], "CallChecker.isCalled(z, double[].class, 239, 8969, 8969)[i]", 239, 8969, 8990);
                            }
                        }
                    }
                    for (int i = k + 1; i < m; ++i) {
                        final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 245, 9230, 9247)[i], "hI", 245, 9210, 9251);
                        for (int j = i; j < m; ++j) {
                            if (CallChecker.beforeDeref(hI, double[].class, 247, 9327, 9328)) {
                                if (CallChecker.beforeDeref(hK, double[].class, 247, 9336, 9337)) {
                                    if (CallChecker.beforeDeref(z, double[].class, 247, 9344, 9344)) {
                                        if (CallChecker.beforeDeref(z, double[].class, 247, 9351, 9351)) {
                                            if (CallChecker.beforeDeref(hK, double[].class, 247, 9358, 9359)) {
                                                CallChecker.isCalled(hI, double[].class, 247, 9327, 9328)[j] -= ((CallChecker.isCalled(hK, double[].class, 247, 9336, 9337)[i]) * (CallChecker.isCalled(z, double[].class, 247, 9344, 9344)[j])) + ((CallChecker.isCalled(z, double[].class, 247, 9351, 9351)[i]) * (CallChecker.isCalled(hK, double[].class, 247, 9358, 9359)[j]));
                                                CallChecker.varAssign(CallChecker.isCalled(hI, double[].class, 247, 9327, 9328)[j], "CallChecker.isCalled(hI, double[].class, 247, 9327, 9328)[j]", 247, 9327, 9363);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(main, double[].class, 252, 9437, 9440)) {
                if (CallChecker.beforeDeref(householderVectors, double[][].class, 252, 9451, 9468)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 252, 9451, 9468)[(m - 1)], double[].class, 252, 9451, 9475)) {
                        CallChecker.isCalled(householderVectors, double[][].class, 252, 9451, 9468)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 252, 9451, 9468)[(m - 1)], double[].class, 252, 9451, 9475);
                        CallChecker.isCalled(main, double[].class, 252, 9437, 9440)[(m - 1)] = CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 252, 9451, 9468)[(m - 1)], double[].class, 252, 9451, 9475)[(m - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(this.main, double[].class, 252, 9437, 9440)[(m - 1)], "CallChecker.isCalled(this.main, double[].class, 252, 9437, 9440)[(m - 1)]", 252, 9437, 9483);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1878.methodEnd();
        }
    }
}

