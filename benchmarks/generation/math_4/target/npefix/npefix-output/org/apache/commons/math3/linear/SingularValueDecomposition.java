package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class SingularValueDecomposition {
    private static class Solver implements DecompositionSolver {
        private final RealMatrix pseudoInverse;

        private boolean nonSingular;

        private Solver(final double[] singularValues, final RealMatrix uT, final RealMatrix v, final boolean nonSingular, final double tol) {
            ConstructorContext _bcornu_methode_context704 = new ConstructorContext(SingularValueDecomposition.Solver.class, 676, 26103, 27220);
            try {
                final double[][] suT = CallChecker.varInit(CallChecker.isCalled(uT, RealMatrix.class, 678, 26650, 26651).getData(), "suT", 678, 26627, 26662);
                for (int i = 0; i < (CallChecker.isCalled(singularValues, double[].class, 679, 26696, 26709).length); ++i) {
                    double a = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(singularValues, double[].class, 681, 26778, 26791)) {
                        if ((CallChecker.isCalled(singularValues, double[].class, 681, 26778, 26791)[i]) > tol) {
                            if (CallChecker.beforeDeref(singularValues, double[].class, 682, 26833, 26846)) {
                                a = 1 / (CallChecker.isCalled(singularValues, double[].class, 682, 26833, 26846)[i]);
                                CallChecker.varAssign(a, "a", 682, 26825, 26850);
                            }
                        }else {
                            a = 0;
                            CallChecker.varAssign(a, "a", 684, 26897, 26902);
                        }
                    }
                    final double[] suTi = CallChecker.varInit(CallChecker.isCalled(suT, double[][].class, 686, 26960, 26962)[i], "suTi", 686, 26938, 26966);
                    for (int j = 0; j < (CallChecker.isCalled(suTi, double[].class, 687, 27004, 27007).length); ++j) {
                        if (CallChecker.beforeDeref(suTi, double[].class, 688, 27044, 27047)) {
                            CallChecker.isCalled(suTi, double[].class, 688, 27044, 27047)[j] *= a;
                            CallChecker.varAssign(CallChecker.isCalled(suTi, double[].class, 688, 27044, 27047)[j], "CallChecker.isCalled(suTi, double[].class, 688, 27044, 27047)[j]", 688, 27044, 27056);
                        }
                    }
                }
                pseudoInverse = CallChecker.isCalled(v, RealMatrix.class, 691, 27118, 27118).multiply(new Array2DRowRealMatrix(suT, false));
                CallChecker.varAssign(this.pseudoInverse, "this.pseudoInverse", 691, 27102, 27166);
                this.nonSingular = nonSingular;
                CallChecker.varAssign(this.nonSingular, "this.nonSingular", 692, 27180, 27210);
            } finally {
                _bcornu_methode_context704.methodEnd();
            }
        }

        public RealVector solve(final RealVector b) {
            MethodContext _bcornu_methode_context3097 = new MethodContext(RealVector.class, 706, 27231, 27863);
            try {
                CallChecker.varInit(this, "this", 706, 27231, 27863);
                CallChecker.varInit(b, "b", 706, 27231, 27863);
                CallChecker.varInit(this.nonSingular, "nonSingular", 706, 27231, 27863);
                CallChecker.varInit(this.pseudoInverse, "pseudoInverse", 706, 27231, 27863);
                if (CallChecker.beforeDeref(pseudoInverse, RealMatrix.class, 707, 27829, 27841)) {
                    return CallChecker.isCalled(pseudoInverse, RealMatrix.class, 707, 27829, 27841).operate(b);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3097.methodEnd();
            }
        }

        public RealMatrix solve(final RealMatrix b) {
            MethodContext _bcornu_methode_context3098 = new MethodContext(RealMatrix.class, 722, 27874, 28518);
            try {
                CallChecker.varInit(this, "this", 722, 27874, 28518);
                CallChecker.varInit(b, "b", 722, 27874, 28518);
                CallChecker.varInit(this.nonSingular, "nonSingular", 722, 27874, 28518);
                CallChecker.varInit(this.pseudoInverse, "pseudoInverse", 722, 27874, 28518);
                if (CallChecker.beforeDeref(pseudoInverse, RealMatrix.class, 723, 28483, 28495)) {
                    return CallChecker.isCalled(pseudoInverse, RealMatrix.class, 723, 28483, 28495).multiply(b);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3098.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context3099 = new MethodContext(boolean.class, 731, 28529, 28770);
            try {
                CallChecker.varInit(this, "this", 731, 28529, 28770);
                CallChecker.varInit(this.nonSingular, "nonSingular", 731, 28529, 28770);
                CallChecker.varInit(this.pseudoInverse, "pseudoInverse", 731, 28529, 28770);
                return nonSingular;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3099.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context3100 = new MethodContext(RealMatrix.class, 740, 28781, 28990);
            try {
                CallChecker.varInit(this, "this", 740, 28781, 28990);
                CallChecker.varInit(this.nonSingular, "nonSingular", 740, 28781, 28990);
                CallChecker.varInit(this.pseudoInverse, "pseudoInverse", 740, 28781, 28990);
                return pseudoInverse;
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3100.methodEnd();
            }
        }
    }

    private static final double EPS = 2.220446049250313E-16;

    private static final double TINY = 1.6033346880071782E-291;

    private final double[] singularValues;

    private final int m;

    private final int n;

    private final boolean transposed;

    private final RealMatrix cachedU;

    private RealMatrix cachedUt;

    private RealMatrix cachedS;

    private final RealMatrix cachedV;

    private RealMatrix cachedVt;

    private final double tol;

    public SingularValueDecomposition(final RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context705 = new ConstructorContext(SingularValueDecomposition.class, 88, 3723, 19998);
        try {
            double[][] A = CallChecker.init(double[][].class);
            if ((CallChecker.isCalled(matrix, RealMatrix.class, 92, 4019, 4024).getRowDimension()) < (CallChecker.isCalled(matrix, RealMatrix.class, 92, 4046, 4051).getColumnDimension())) {
                transposed = true;
                CallChecker.varAssign(this.transposed, "this.transposed", 93, 4089, 4106);
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 94, 4124, 4129)) {
                    final RealMatrix npe_invocation_var784 = CallChecker.isCalled(matrix, RealMatrix.class, 94, 4124, 4129).transpose();
                    if (CallChecker.beforeDeref(npe_invocation_var784, RealMatrix.class, 94, 4124, 4141)) {
                        A = CallChecker.isCalled(npe_invocation_var784, RealMatrix.class, 94, 4124, 4141).getData();
                        CallChecker.varAssign(A, "A", 94, 4120, 4152);
                    }
                }
                m = CallChecker.isCalled(matrix, RealMatrix.class, 95, 4170, 4175).getColumnDimension();
                CallChecker.varAssign(this.m, "this.m", 95, 4166, 4197);
                n = CallChecker.isCalled(matrix, RealMatrix.class, 96, 4215, 4220).getRowDimension();
                CallChecker.varAssign(this.n, "this.n", 96, 4211, 4239);
            }else {
                transposed = false;
                CallChecker.varAssign(this.transposed, "this.transposed", 98, 4270, 4288);
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 99, 4306, 4311)) {
                    A = CallChecker.isCalled(matrix, RealMatrix.class, 99, 4306, 4311).getData();
                    CallChecker.varAssign(A, "A", 99, 4302, 4322);
                }
                m = CallChecker.isCalled(matrix, RealMatrix.class, 100, 4340, 4345).getRowDimension();
                CallChecker.varAssign(this.m, "this.m", 100, 4336, 4364);
                n = CallChecker.isCalled(matrix, RealMatrix.class, 101, 4382, 4387).getColumnDimension();
                CallChecker.varAssign(this.n, "this.n", 101, 4378, 4409);
            }
            singularValues = new double[n];
            CallChecker.varAssign(this.singularValues, "this.singularValues", 104, 4430, 4460);
            final double[][] U = CallChecker.varInit(new double[m][n], "U", 105, 4470, 4507);
            final double[][] V = CallChecker.varInit(new double[n][n], "V", 106, 4517, 4554);
            final double[] e = CallChecker.varInit(new double[n], "e", 107, 4564, 4596);
            final double[] work = CallChecker.varInit(new double[m], "work", 108, 4606, 4641);
            final int nct = CallChecker.varInit(((int) (FastMath.min(((this.m) - 1), this.n))), "nct", 111, 4651, 4813);
            final int nrt = CallChecker.varInit(((int) (FastMath.max(0, ((this.n) - 2)))), "nrt", 112, 4823, 4861);
            for (int k = 0; k < (FastMath.max(nct, nrt)); k++) {
                if (k < nct) {
                    if (CallChecker.beforeDeref(singularValues, double[].class, 118, 5160, 5173)) {
                        CallChecker.isCalled(singularValues, double[].class, 118, 5160, 5173)[k] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 118, 5160, 5173)[k], "CallChecker.isCalled(this.singularValues, double[].class, 118, 5160, 5173)[k]", 118, 5160, 5181);
                    }
                    for (int i = k; i < (m); i++) {
                        if (CallChecker.beforeDeref(singularValues, double[].class, 120, 5249, 5262)) {
                            if (CallChecker.beforeDeref(singularValues, double[].class, 120, 5284, 5297)) {
                                if (CallChecker.beforeDeref(A, double[][].class, 120, 5303, 5303)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 120, 5303, 5303);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 120, 5303, 5303)[i], double[].class, 120, 5303, 5306)) {
                                        A = CallChecker.beforeCalled(A, double[][].class, 120, 5303, 5303);
                                        CallChecker.isCalled(A, double[][].class, 120, 5303, 5303)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 120, 5303, 5303)[i], double[].class, 120, 5303, 5306);
                                        CallChecker.isCalled(singularValues, double[].class, 120, 5249, 5262)[k] = FastMath.hypot(CallChecker.isCalled(singularValues, double[].class, 120, 5284, 5297)[k], CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 120, 5303, 5303)[i], double[].class, 120, 5303, 5306)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 120, 5249, 5262)[k], "CallChecker.isCalled(this.singularValues, double[].class, 120, 5249, 5262)[k]", 120, 5249, 5311);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(singularValues, double[].class, 122, 5351, 5364)) {
                        if ((CallChecker.isCalled(singularValues, double[].class, 122, 5351, 5364)[k]) != 0) {
                            if (CallChecker.beforeDeref(A, double[][].class, 123, 5401, 5401)) {
                                A = CallChecker.beforeCalled(A, double[][].class, 123, 5401, 5401);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 123, 5401, 5401)[k], double[].class, 123, 5401, 5404)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 123, 5401, 5401);
                                    CallChecker.isCalled(A, double[][].class, 123, 5401, 5401)[k] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 123, 5401, 5401)[k], double[].class, 123, 5401, 5404);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 123, 5401, 5401)[k], double[].class, 123, 5401, 5404)[k]) < 0) {
                                        if (CallChecker.beforeDeref(singularValues, double[].class, 124, 5440, 5453)) {
                                            if (CallChecker.beforeDeref(singularValues, double[].class, 124, 5461, 5474)) {
                                                CallChecker.isCalled(singularValues, double[].class, 124, 5440, 5453)[k] = -(CallChecker.isCalled(singularValues, double[].class, 124, 5461, 5474)[k]);
                                                CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 124, 5440, 5453)[k], "CallChecker.isCalled(this.singularValues, double[].class, 124, 5440, 5453)[k]", 124, 5440, 5478);
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = k; i < (m); i++) {
                                if (CallChecker.beforeDeref(A, double[][].class, 127, 5576, 5576)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 127, 5576, 5576);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i], double[].class, 127, 5576, 5579)) {
                                        if (CallChecker.beforeDeref(singularValues, double[].class, 127, 5587, 5600)) {
                                            A = CallChecker.beforeCalled(A, double[][].class, 127, 5576, 5576);
                                            CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i], double[].class, 127, 5576, 5579);
                                            CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i], double[].class, 127, 5576, 5579)[k] /= CallChecker.isCalled(singularValues, double[].class, 127, 5587, 5600)[k];
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i], double[].class, 127, 5576, 5579)[k], "CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 127, 5576, 5576)[i], double[].class, 127, 5576, 5579)[k]", 127, 5576, 5604);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(A, double[][].class, 129, 5648, 5648)) {
                                A = CallChecker.beforeCalled(A, double[][].class, 129, 5648, 5648);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k], double[].class, 129, 5648, 5651)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 129, 5648, 5648);
                                    CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k], double[].class, 129, 5648, 5651);
                                    CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k], double[].class, 129, 5648, 5651)[k] += 1;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k], double[].class, 129, 5648, 5651)[k], "CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 129, 5648, 5648)[k], double[].class, 129, 5648, 5651)[k]", 129, 5648, 5660);
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(singularValues, double[].class, 131, 5696, 5709)) {
                        if (CallChecker.beforeDeref(singularValues, double[].class, 131, 5717, 5730)) {
                            CallChecker.isCalled(singularValues, double[].class, 131, 5696, 5709)[k] = -(CallChecker.isCalled(singularValues, double[].class, 131, 5717, 5730)[k]);
                            CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 131, 5696, 5709)[k], "CallChecker.isCalled(this.singularValues, double[].class, 131, 5696, 5709)[k]", 131, 5696, 5734);
                        }
                    }
                }
                for (int j = k + 1; j < (n); j++) {
                    if (CallChecker.beforeDeref(singularValues, double[].class, 135, 5847, 5860)) {
                        if ((k < nct) && ((CallChecker.isCalled(singularValues, double[].class, 135, 5847, 5860)[k]) != 0)) {
                            double t = CallChecker.varInit(((double) (0)), "t", 137, 5942, 5954);
                            for (int i = k; i < (m); i++) {
                                if (CallChecker.beforeDeref(A, double[][].class, 139, 6035, 6035)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 139, 6035, 6035);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 139, 6035, 6035)[i], double[].class, 139, 6035, 6038)) {
                                        if (CallChecker.beforeDeref(A, double[][].class, 139, 6045, 6045)) {
                                            A = CallChecker.beforeCalled(A, double[][].class, 139, 6045, 6045);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 139, 6045, 6045)[i], double[].class, 139, 6045, 6048)) {
                                                A = CallChecker.beforeCalled(A, double[][].class, 139, 6035, 6035);
                                                CallChecker.isCalled(A, double[][].class, 139, 6035, 6035)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 139, 6035, 6035)[i], double[].class, 139, 6035, 6038);
                                                A = CallChecker.beforeCalled(A, double[][].class, 139, 6045, 6045);
                                                CallChecker.isCalled(A, double[][].class, 139, 6045, 6045)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 139, 6045, 6045)[i], double[].class, 139, 6045, 6048);
                                                t += (CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 139, 6035, 6035)[i], double[].class, 139, 6035, 6038)[k]) * (CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 139, 6045, 6045)[i], double[].class, 139, 6045, 6048)[j]);
                                                CallChecker.varAssign(t, "t", 139, 6030, 6052);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(A, double[][].class, 141, 6105, 6105)) {
                                A = CallChecker.beforeCalled(A, double[][].class, 141, 6105, 6105);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 141, 6105, 6105)[k], double[].class, 141, 6105, 6108)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 141, 6105, 6105);
                                    CallChecker.isCalled(A, double[][].class, 141, 6105, 6105)[k] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 141, 6105, 6105)[k], double[].class, 141, 6105, 6108);
                                    t = (-t) / (CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 141, 6105, 6105)[k], double[].class, 141, 6105, 6108)[k]);
                                    CallChecker.varAssign(t, "t", 141, 6096, 6112);
                                }
                            }
                            for (int i = k; i < (m); i++) {
                                if (CallChecker.beforeDeref(A, double[][].class, 143, 6188, 6188)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 143, 6188, 6188);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i], double[].class, 143, 6188, 6191)) {
                                        if (CallChecker.beforeDeref(A, double[][].class, 143, 6203, 6203)) {
                                            A = CallChecker.beforeCalled(A, double[][].class, 143, 6203, 6203);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 143, 6203, 6203)[i], double[].class, 143, 6203, 6206)) {
                                                A = CallChecker.beforeCalled(A, double[][].class, 143, 6188, 6188);
                                                CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i], double[].class, 143, 6188, 6191);
                                                A = CallChecker.beforeCalled(A, double[][].class, 143, 6203, 6203);
                                                CallChecker.isCalled(A, double[][].class, 143, 6203, 6203)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 143, 6203, 6203)[i], double[].class, 143, 6203, 6206);
                                                CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i], double[].class, 143, 6188, 6191)[j] += t * (CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 143, 6203, 6203)[i], double[].class, 143, 6203, 6206)[k]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i], double[].class, 143, 6188, 6191)[j], "CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 143, 6188, 6188)[i], double[].class, 143, 6188, 6191)[j]", 143, 6188, 6210);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(e, double[].class, 148, 6395, 6395)) {
                        if (CallChecker.beforeDeref(A, double[][].class, 148, 6402, 6402)) {
                            A = CallChecker.beforeCalled(A, double[][].class, 148, 6402, 6402);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 148, 6402, 6402)[k], double[].class, 148, 6402, 6405)) {
                                A = CallChecker.beforeCalled(A, double[][].class, 148, 6402, 6402);
                                CallChecker.isCalled(A, double[][].class, 148, 6402, 6402)[k] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 148, 6402, 6402)[k], double[].class, 148, 6402, 6405);
                                CallChecker.isCalled(e, double[].class, 148, 6395, 6395)[j] = CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 148, 6402, 6402)[k], double[].class, 148, 6402, 6405)[j];
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 148, 6395, 6395)[j], "CallChecker.isCalled(e, double[].class, 148, 6395, 6395)[j]", 148, 6395, 6409);
                            }
                        }
                    }
                }
                if (k < nct) {
                    for (int i = k; i < (m); i++) {
                        if (CallChecker.beforeDeref(U, double[][].class, 154, 6622, 6622)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i], double[].class, 154, 6622, 6625)) {
                                if (CallChecker.beforeDeref(A, double[][].class, 154, 6632, 6632)) {
                                    A = CallChecker.beforeCalled(A, double[][].class, 154, 6632, 6632);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 154, 6632, 6632)[i], double[].class, 154, 6632, 6635)) {
                                        CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i], double[].class, 154, 6622, 6625);
                                        A = CallChecker.beforeCalled(A, double[][].class, 154, 6632, 6632);
                                        CallChecker.isCalled(A, double[][].class, 154, 6632, 6632)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 154, 6632, 6632)[i], double[].class, 154, 6632, 6635);
                                        CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i], double[].class, 154, 6622, 6625)[k] = CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 154, 6632, 6632)[i], double[].class, 154, 6632, 6635)[k];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i], double[].class, 154, 6622, 6625)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 154, 6622, 6622)[i], double[].class, 154, 6622, 6625)[k]", 154, 6622, 6639);
                                    }
                                }
                            }
                        }
                    }
                }
                if (k < nrt) {
                    if (CallChecker.beforeDeref(e, double[].class, 161, 6891, 6891)) {
                        CallChecker.isCalled(e, double[].class, 161, 6891, 6891)[k] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 161, 6891, 6891)[k], "CallChecker.isCalled(e, double[].class, 161, 6891, 6891)[k]", 161, 6891, 6899);
                    }
                    for (int i = k + 1; i < (n); i++) {
                        if (CallChecker.beforeDeref(e, double[].class, 163, 6971, 6971)) {
                            if (CallChecker.beforeDeref(e, double[].class, 163, 6993, 6993)) {
                                if (CallChecker.beforeDeref(e, double[].class, 163, 6999, 6999)) {
                                    CallChecker.isCalled(e, double[].class, 163, 6971, 6971)[k] = FastMath.hypot(CallChecker.isCalled(e, double[].class, 163, 6993, 6993)[k], CallChecker.isCalled(e, double[].class, 163, 6999, 6999)[i]);
                                    CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 163, 6971, 6971)[k], "CallChecker.isCalled(e, double[].class, 163, 6971, 6971)[k]", 163, 6971, 7004);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(e, double[].class, 165, 7044, 7044)) {
                        if ((CallChecker.isCalled(e, double[].class, 165, 7044, 7044)[k]) != 0) {
                            if (CallChecker.beforeDeref(e, double[].class, 166, 7081, 7081)) {
                                if ((CallChecker.isCalled(e, double[].class, 166, 7081, 7081)[(k + 1)]) < 0) {
                                    if (CallChecker.beforeDeref(e, double[].class, 167, 7121, 7121)) {
                                        if (CallChecker.beforeDeref(e, double[].class, 167, 7129, 7129)) {
                                            CallChecker.isCalled(e, double[].class, 167, 7121, 7121)[k] = -(CallChecker.isCalled(e, double[].class, 167, 7129, 7129)[k]);
                                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 167, 7121, 7121)[k], "CallChecker.isCalled(e, double[].class, 167, 7121, 7121)[k]", 167, 7121, 7133);
                                        }
                                    }
                                }
                            }
                            for (int i = k + 1; i < (n); i++) {
                                if (CallChecker.beforeDeref(e, double[].class, 170, 7235, 7235)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 170, 7243, 7243)) {
                                        CallChecker.isCalled(e, double[].class, 170, 7235, 7235)[i] /= CallChecker.isCalled(e, double[].class, 170, 7243, 7243)[k];
                                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 170, 7235, 7235)[i], "CallChecker.isCalled(e, double[].class, 170, 7235, 7235)[i]", 170, 7235, 7247);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(e, double[].class, 172, 7291, 7291)) {
                                CallChecker.isCalled(e, double[].class, 172, 7291, 7291)[(k + 1)] += 1;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 172, 7291, 7291)[(k + 1)], "CallChecker.isCalled(e, double[].class, 172, 7291, 7291)[(k + 1)]", 172, 7291, 7304);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(e, double[].class, 174, 7340, 7340)) {
                        if (CallChecker.beforeDeref(e, double[].class, 174, 7348, 7348)) {
                            CallChecker.isCalled(e, double[].class, 174, 7340, 7340)[k] = -(CallChecker.isCalled(e, double[].class, 174, 7348, 7348)[k]);
                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 174, 7340, 7340)[k], "CallChecker.isCalled(e, double[].class, 174, 7340, 7340)[k]", 174, 7340, 7352);
                        }
                    }
                    if (CallChecker.beforeDeref(e, double[].class, 176, 7407, 7407)) {
                        if (((k + 1) < (m)) && ((CallChecker.isCalled(e, double[].class, 176, 7407, 7407)[k]) != 0)) {
                            for (int i = k + 1; i < (m); i++) {
                                if (CallChecker.beforeDeref(work, double[].class, 179, 7547, 7550)) {
                                    CallChecker.isCalled(work, double[].class, 179, 7547, 7550)[i] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 179, 7547, 7550)[i], "CallChecker.isCalled(work, double[].class, 179, 7547, 7550)[i]", 179, 7547, 7558);
                                }
                            }
                            for (int j = k + 1; j < (n); j++) {
                                for (int i = k + 1; i < (m); i++) {
                                    if (CallChecker.beforeDeref(work, double[].class, 183, 7722, 7725)) {
                                        if (CallChecker.beforeDeref(e, double[].class, 183, 7733, 7733)) {
                                            if (CallChecker.beforeDeref(A, double[][].class, 183, 7740, 7740)) {
                                                A = CallChecker.beforeCalled(A, double[][].class, 183, 7740, 7740);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 183, 7740, 7740)[i], double[].class, 183, 7740, 7743)) {
                                                    A = CallChecker.beforeCalled(A, double[][].class, 183, 7740, 7740);
                                                    CallChecker.isCalled(A, double[][].class, 183, 7740, 7740)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 183, 7740, 7740)[i], double[].class, 183, 7740, 7743);
                                                    CallChecker.isCalled(work, double[].class, 183, 7722, 7725)[i] += (CallChecker.isCalled(e, double[].class, 183, 7733, 7733)[j]) * (CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 183, 7740, 7740)[i], double[].class, 183, 7740, 7743)[j]);
                                                    CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 183, 7722, 7725)[i], "CallChecker.isCalled(work, double[].class, 183, 7722, 7725)[i]", 183, 7722, 7747);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            for (int j = k + 1; j < (n); j++) {
                                final double t = CallChecker.varInit(((double) ((-(CallChecker.isCalled(e, double[].class, 187, 7893, 7893)[j])) / (CallChecker.isCalled(e, double[].class, 187, 7900, 7900)[(k + 1)]))), "t", 187, 7875, 7908);
                                for (int i = k + 1; i < (m); i++) {
                                    if (CallChecker.beforeDeref(A, double[][].class, 189, 7996, 7996)) {
                                        A = CallChecker.beforeCalled(A, double[][].class, 189, 7996, 7996);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i], double[].class, 189, 7996, 7999)) {
                                            if (CallChecker.beforeDeref(work, double[].class, 189, 8011, 8014)) {
                                                A = CallChecker.beforeCalled(A, double[][].class, 189, 7996, 7996);
                                                CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i], double[].class, 189, 7996, 7999);
                                                CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i], double[].class, 189, 7996, 7999)[j] += t * (CallChecker.isCalled(work, double[].class, 189, 8011, 8014)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i], double[].class, 189, 7996, 7999)[j], "CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 189, 7996, 7996)[i], double[].class, 189, 7996, 7999)[j]", 189, 7996, 8018);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    for (int i = k + 1; i < (n); i++) {
                        if (CallChecker.beforeDeref(V, double[][].class, 197, 8261, 8261)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i], double[].class, 197, 8261, 8264)) {
                                if (CallChecker.beforeDeref(e, double[].class, 197, 8271, 8271)) {
                                    CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i], double[].class, 197, 8261, 8264);
                                    CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i], double[].class, 197, 8261, 8264)[k] = CallChecker.isCalled(e, double[].class, 197, 8271, 8271)[i];
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i], double[].class, 197, 8261, 8264)[k], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 197, 8261, 8261)[i], double[].class, 197, 8261, 8264)[k]", 197, 8261, 8275);
                                }
                            }
                        }
                    }
                }
            }
            int p = CallChecker.varInit(((int) (this.n)), "p", 202, 8385, 8394);
            if (nct < (n)) {
                if (CallChecker.beforeDeref(singularValues, double[].class, 204, 8431, 8444)) {
                    if (CallChecker.beforeDeref(A, double[][].class, 204, 8453, 8453)) {
                        A = CallChecker.beforeCalled(A, double[][].class, 204, 8453, 8453);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 204, 8453, 8453)[nct], double[].class, 204, 8453, 8458)) {
                            A = CallChecker.beforeCalled(A, double[][].class, 204, 8453, 8453);
                            CallChecker.isCalled(A, double[][].class, 204, 8453, 8453)[nct] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 204, 8453, 8453)[nct], double[].class, 204, 8453, 8458);
                            CallChecker.isCalled(singularValues, double[].class, 204, 8431, 8444)[nct] = CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 204, 8453, 8453)[nct], double[].class, 204, 8453, 8458)[nct];
                            CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 204, 8431, 8444)[nct], "CallChecker.isCalled(this.singularValues, double[].class, 204, 8431, 8444)[nct]", 204, 8431, 8464);
                        }
                    }
                }
            }
            if ((m) < p) {
                if (CallChecker.beforeDeref(singularValues, double[].class, 207, 8509, 8522)) {
                    CallChecker.isCalled(singularValues, double[].class, 207, 8509, 8522)[(p - 1)] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 207, 8509, 8522)[(p - 1)], "CallChecker.isCalled(this.singularValues, double[].class, 207, 8509, 8522)[(p - 1)]", 207, 8509, 8534);
                }
            }
            if ((nrt + 1) < p) {
                if (CallChecker.beforeDeref(e, double[].class, 210, 8585, 8585)) {
                    if (CallChecker.beforeDeref(A, double[][].class, 210, 8594, 8594)) {
                        A = CallChecker.beforeCalled(A, double[][].class, 210, 8594, 8594);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(A, double[][].class, 210, 8594, 8594)[nrt], double[].class, 210, 8594, 8599)) {
                            A = CallChecker.beforeCalled(A, double[][].class, 210, 8594, 8594);
                            CallChecker.isCalled(A, double[][].class, 210, 8594, 8594)[nrt] = CallChecker.beforeCalled(CallChecker.isCalled(A, double[][].class, 210, 8594, 8594)[nrt], double[].class, 210, 8594, 8599);
                            CallChecker.isCalled(e, double[].class, 210, 8585, 8585)[nrt] = CallChecker.isCalled(CallChecker.isCalled(A, double[][].class, 210, 8594, 8594)[nrt], double[].class, 210, 8594, 8599)[(p - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 210, 8585, 8585)[nrt], "CallChecker.isCalled(e, double[].class, 210, 8585, 8585)[nrt]", 210, 8585, 8607);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(e, double[].class, 212, 8627, 8627)) {
                CallChecker.isCalled(e, double[].class, 212, 8627, 8627)[(p - 1)] = 0;
                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 212, 8627, 8627)[(p - 1)], "CallChecker.isCalled(e, double[].class, 212, 8627, 8627)[(p - 1)]", 212, 8627, 8639);
            }
            for (int j = nct; j < (n); j++) {
                for (int i = 0; i < (m); i++) {
                    if (CallChecker.beforeDeref(U, double[][].class, 217, 8763, 8763)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i], double[].class, 217, 8763, 8766)) {
                            CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i], double[].class, 217, 8763, 8766);
                            CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i], double[].class, 217, 8763, 8766)[j] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i], double[].class, 217, 8763, 8766)[j], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 217, 8763, 8763)[i], double[].class, 217, 8763, 8766)[j]", 217, 8763, 8774);
                        }
                    }
                }
                if (CallChecker.beforeDeref(U, double[][].class, 219, 8802, 8802)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j], double[].class, 219, 8802, 8805)) {
                        CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j], double[].class, 219, 8802, 8805);
                        CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j], double[].class, 219, 8802, 8805)[j] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j], double[].class, 219, 8802, 8805)[j], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 219, 8802, 8802)[j], double[].class, 219, 8802, 8805)[j]", 219, 8802, 8813);
                    }
                }
            }
            for (int k = nct - 1; k >= 0; k--) {
                if (CallChecker.beforeDeref(singularValues, double[].class, 222, 8886, 8899)) {
                    if ((CallChecker.isCalled(singularValues, double[].class, 222, 8886, 8899)[k]) != 0) {
                        for (int j = k + 1; j < (n); j++) {
                            double t = CallChecker.varInit(((double) (0)), "t", 224, 8982, 8994);
                            for (int i = k; i < (m); i++) {
                                if (CallChecker.beforeDeref(U, double[][].class, 226, 9075, 9075)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 226, 9075, 9075)[i], double[].class, 226, 9075, 9078)) {
                                        if (CallChecker.beforeDeref(U, double[][].class, 226, 9085, 9085)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 226, 9085, 9085)[i], double[].class, 226, 9085, 9088)) {
                                                CallChecker.isCalled(U, double[][].class, 226, 9075, 9075)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 226, 9075, 9075)[i], double[].class, 226, 9075, 9078);
                                                CallChecker.isCalled(U, double[][].class, 226, 9085, 9085)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 226, 9085, 9085)[i], double[].class, 226, 9085, 9088);
                                                t += (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 226, 9075, 9075)[i], double[].class, 226, 9075, 9078)[k]) * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 226, 9085, 9085)[i], double[].class, 226, 9085, 9088)[j]);
                                                CallChecker.varAssign(t, "t", 226, 9070, 9092);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(U, double[][].class, 228, 9145, 9145)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 228, 9145, 9145)[k], double[].class, 228, 9145, 9148)) {
                                    CallChecker.isCalled(U, double[][].class, 228, 9145, 9145)[k] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 228, 9145, 9145)[k], double[].class, 228, 9145, 9148);
                                    t = (-t) / (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 228, 9145, 9145)[k], double[].class, 228, 9145, 9148)[k]);
                                    CallChecker.varAssign(t, "t", 228, 9136, 9152);
                                }
                            }
                            for (int i = k; i < (m); i++) {
                                if (CallChecker.beforeDeref(U, double[][].class, 230, 9228, 9228)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i], double[].class, 230, 9228, 9231)) {
                                        if (CallChecker.beforeDeref(U, double[][].class, 230, 9243, 9243)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 230, 9243, 9243)[i], double[].class, 230, 9243, 9246)) {
                                                CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i], double[].class, 230, 9228, 9231);
                                                CallChecker.isCalled(U, double[][].class, 230, 9243, 9243)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 230, 9243, 9243)[i], double[].class, 230, 9243, 9246);
                                                CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i], double[].class, 230, 9228, 9231)[j] += t * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 230, 9243, 9243)[i], double[].class, 230, 9243, 9246)[k]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i], double[].class, 230, 9228, 9231)[j], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 230, 9228, 9228)[i], double[].class, 230, 9228, 9231)[j]", 230, 9228, 9250);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (int i = k; i < (m); i++) {
                            if (CallChecker.beforeDeref(U, double[][].class, 234, 9358, 9358)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i], double[].class, 234, 9358, 9361)) {
                                    if (CallChecker.beforeDeref(U, double[][].class, 234, 9369, 9369)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 234, 9369, 9369)[i], double[].class, 234, 9369, 9372)) {
                                            CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i], double[].class, 234, 9358, 9361);
                                            CallChecker.isCalled(U, double[][].class, 234, 9369, 9369)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 234, 9369, 9369)[i], double[].class, 234, 9369, 9372);
                                            CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i], double[].class, 234, 9358, 9361)[k] = -(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 234, 9369, 9369)[i], double[].class, 234, 9369, 9372)[k]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i], double[].class, 234, 9358, 9361)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 234, 9358, 9358)[i], double[].class, 234, 9358, 9361)[k]", 234, 9358, 9376);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(U, double[][].class, 236, 9412, 9412)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k], double[].class, 236, 9412, 9415)) {
                                if (CallChecker.beforeDeref(U, double[][].class, 236, 9426, 9426)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 236, 9426, 9426)[k], double[].class, 236, 9426, 9429)) {
                                        CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k], double[].class, 236, 9412, 9415);
                                        CallChecker.isCalled(U, double[][].class, 236, 9426, 9426)[k] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 236, 9426, 9426)[k], double[].class, 236, 9426, 9429);
                                        CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k], double[].class, 236, 9412, 9415)[k] = 1 + (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 236, 9426, 9426)[k], double[].class, 236, 9426, 9429)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k], double[].class, 236, 9412, 9415)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 236, 9412, 9412)[k], double[].class, 236, 9412, 9415)[k]", 236, 9412, 9433);
                                    }
                                }
                            }
                        }
                        for (int i = 0; i < (k - 1); i++) {
                            if (CallChecker.beforeDeref(U, double[][].class, 238, 9505, 9505)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i], double[].class, 238, 9505, 9508)) {
                                    CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i], double[].class, 238, 9505, 9508);
                                    CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i], double[].class, 238, 9505, 9508)[k] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i], double[].class, 238, 9505, 9508)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 238, 9505, 9505)[i], double[].class, 238, 9505, 9508)[k]", 238, 9505, 9516);
                                }
                            }
                        }
                    }else {
                        for (int i = 0; i < (m); i++) {
                            if (CallChecker.beforeDeref(U, double[][].class, 242, 9623, 9623)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i], double[].class, 242, 9623, 9626)) {
                                    CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i], double[].class, 242, 9623, 9626);
                                    CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i], double[].class, 242, 9623, 9626)[k] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i], double[].class, 242, 9623, 9626)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 242, 9623, 9623)[i], double[].class, 242, 9623, 9626)[k]", 242, 9623, 9634);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(U, double[][].class, 244, 9670, 9670)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k], double[].class, 244, 9670, 9673)) {
                                CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k], double[].class, 244, 9670, 9673);
                                CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k], double[].class, 244, 9670, 9673)[k] = 1;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k], double[].class, 244, 9670, 9673)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 244, 9670, 9670)[k], double[].class, 244, 9670, 9673)[k]", 244, 9670, 9681);
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            for (int k = (n) - 1; k >= 0; k--) {
                if (CallChecker.beforeDeref(e, double[].class, 251, 9817, 9817)) {
                    if ((k < nrt) && ((CallChecker.isCalled(e, double[].class, 251, 9817, 9817)[k]) != 0)) {
                        for (int j = k + 1; j < (n); j++) {
                            double t = CallChecker.varInit(((double) (0)), "t", 253, 9900, 9912);
                            for (int i = k + 1; i < (n); i++) {
                                if (CallChecker.beforeDeref(V, double[][].class, 255, 9997, 9997)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 255, 9997, 9997)[i], double[].class, 255, 9997, 10000)) {
                                        if (CallChecker.beforeDeref(V, double[][].class, 255, 10007, 10007)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 255, 10007, 10007)[i], double[].class, 255, 10007, 10010)) {
                                                CallChecker.isCalled(V, double[][].class, 255, 9997, 9997)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 255, 9997, 9997)[i], double[].class, 255, 9997, 10000);
                                                CallChecker.isCalled(V, double[][].class, 255, 10007, 10007)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 255, 10007, 10007)[i], double[].class, 255, 10007, 10010);
                                                t += (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 255, 9997, 9997)[i], double[].class, 255, 9997, 10000)[k]) * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 255, 10007, 10007)[i], double[].class, 255, 10007, 10010)[j]);
                                                CallChecker.varAssign(t, "t", 255, 9992, 10014);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(V, double[][].class, 257, 10067, 10067)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 257, 10067, 10067)[(k + 1)], double[].class, 257, 10067, 10074)) {
                                    CallChecker.isCalled(V, double[][].class, 257, 10067, 10067)[(k + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 257, 10067, 10067)[(k + 1)], double[].class, 257, 10067, 10074);
                                    t = (-t) / (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 257, 10067, 10067)[(k + 1)], double[].class, 257, 10067, 10074)[k]);
                                    CallChecker.varAssign(t, "t", 257, 10058, 10078);
                                }
                            }
                            for (int i = k + 1; i < (n); i++) {
                                if (CallChecker.beforeDeref(V, double[][].class, 259, 10158, 10158)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i], double[].class, 259, 10158, 10161)) {
                                        if (CallChecker.beforeDeref(V, double[][].class, 259, 10173, 10173)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 259, 10173, 10173)[i], double[].class, 259, 10173, 10176)) {
                                                CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i], double[].class, 259, 10158, 10161);
                                                CallChecker.isCalled(V, double[][].class, 259, 10173, 10173)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 259, 10173, 10173)[i], double[].class, 259, 10173, 10176);
                                                CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i], double[].class, 259, 10158, 10161)[j] += t * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 259, 10173, 10173)[i], double[].class, 259, 10173, 10176)[k]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i], double[].class, 259, 10158, 10161)[j], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 259, 10158, 10158)[i], double[].class, 259, 10158, 10161)[j]", 259, 10158, 10180);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                for (int i = 0; i < (n); i++) {
                    if (CallChecker.beforeDeref(V, double[][].class, 264, 10294, 10294)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i], double[].class, 264, 10294, 10297)) {
                            CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i], double[].class, 264, 10294, 10297);
                            CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i], double[].class, 264, 10294, 10297)[k] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i], double[].class, 264, 10294, 10297)[k], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 264, 10294, 10294)[i], double[].class, 264, 10294, 10297)[k]", 264, 10294, 10305);
                        }
                    }
                }
                if (CallChecker.beforeDeref(V, double[][].class, 266, 10333, 10333)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k], double[].class, 266, 10333, 10336)) {
                        CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k], double[].class, 266, 10333, 10336);
                        CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k], double[].class, 266, 10333, 10336)[k] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k], double[].class, 266, 10333, 10336)[k], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 266, 10333, 10333)[k], double[].class, 266, 10333, 10336)[k]", 266, 10333, 10344);
                    }
                }
            }
            final int pp = CallChecker.varInit(((int) (p - 1)), "pp", 270, 10365, 10441);
            int iter = CallChecker.varInit(((int) (0)), "iter", 271, 10451, 10463);
            while (p > 0) {
                int k = CallChecker.init(int.class);
                int kase = CallChecker.init(int.class);
                for (k = p - 2; k >= 0; k--) {
                    CallChecker.varAssign(k, "k", 284, 11137, 11145);
                    final double threshold = CallChecker.varInit(((double) ((SingularValueDecomposition.TINY) + ((SingularValueDecomposition.EPS) * ((FastMath.abs(CallChecker.isCalled(this.singularValues, double[].class, 286, 11251, 11264)[k])) + (FastMath.abs(CallChecker.isCalled(this.singularValues, double[].class, 287, 11321, 11334)[(k + 1)])))))), "threshold", 285, 11179, 11344);
                    if (CallChecker.beforeDeref(e, double[].class, 295, 11781, 11781)) {
                        if (!((FastMath.abs(CallChecker.isCalled(e, double[].class, 295, 11781, 11781)[k])) > threshold)) {
                            if (CallChecker.beforeDeref(e, double[].class, 296, 11823, 11823)) {
                                CallChecker.isCalled(e, double[].class, 296, 11823, 11823)[k] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 296, 11823, 11823)[k], "CallChecker.isCalled(e, double[].class, 296, 11823, 11823)[k]", 296, 11823, 11831);
                            }
                            break;
                        }
                    }
                }
                if (k == (p - 2)) {
                    kase = 4;
                    CallChecker.varAssign(kase, "kase", 303, 11940, 11948);
                }else {
                    int ks = CallChecker.init(int.class);
                    for (ks = p - 1; ks >= k; ks--) {
                        CallChecker.varAssign(ks, "ks", 306, 12016, 12025);
                        if (ks == k) {
                            break;
                        }
                        final double t = CallChecker.varInit(((double) ((ks != p ? FastMath.abs(CallChecker.isCalled(e, double[].class, 310, 12194, 12194)[ks]) : 0) + (ks != (k + 1) ? FastMath.abs(CallChecker.isCalled(e, double[].class, 311, 12260, 12260)[(ks - 1)]) : 0))), "t", 310, 12153, 12275);
                        if (CallChecker.beforeDeref(singularValues, double[].class, 312, 12314, 12327)) {
                            if ((FastMath.abs(CallChecker.isCalled(singularValues, double[].class, 312, 12314, 12327)[ks])) <= ((SingularValueDecomposition.TINY) + ((SingularValueDecomposition.EPS) * t))) {
                                if (CallChecker.beforeDeref(singularValues, double[].class, 313, 12379, 12392)) {
                                    CallChecker.isCalled(singularValues, double[].class, 313, 12379, 12392)[ks] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 313, 12379, 12392)[ks], "CallChecker.isCalled(this.singularValues, double[].class, 313, 12379, 12392)[ks]", 313, 12379, 12401);
                                }
                                break;
                            }
                        }
                    }
                    if (ks == k) {
                        kase = 3;
                        CallChecker.varAssign(kase, "kase", 318, 12525, 12533);
                    }else
                        if (ks == (p - 1)) {
                            kase = 1;
                            CallChecker.varAssign(kase, "kase", 320, 12597, 12605);
                        }else {
                            kase = 2;
                            CallChecker.varAssign(kase, "kase", 322, 12652, 12660);
                            k = ks;
                            CallChecker.varAssign(k, "k", 323, 12682, 12688);
                        }
                    
                }
                k++;
                switch (kase) {
                    case 1 :
                        {
                            double f = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(e, double[].class, 331, 12919, 12919)) {
                                f = CallChecker.isCalled(e, double[].class, 331, 12919, 12919)[(p - 2)];
                                CallChecker.varAssign(f, "f", 331, 12919, 12919);
                            }
                            if (CallChecker.beforeDeref(e, double[].class, 332, 12949, 12949)) {
                                CallChecker.isCalled(e, double[].class, 332, 12949, 12949)[(p - 2)] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 332, 12949, 12949)[(p - 2)], "CallChecker.isCalled(e, double[].class, 332, 12949, 12949)[(p - 2)]", 332, 12949, 12961);
                            }
                            for (int j = p - 2; j >= k; j--) {
                                double t = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 334, 13068, 13081)) {
                                    t = FastMath.hypot(CallChecker.isCalled(singularValues, double[].class, 334, 13068, 13081)[j], f);
                                    CallChecker.varAssign(t, "t", 334, 13068, 13081);
                                }
                                final double cs = CallChecker.varInit(((double) ((CallChecker.isCalled(this.singularValues, double[].class, 335, 13133, 13146)[j]) / t)), "cs", 335, 13115, 13154);
                                final double sn = CallChecker.varInit(((double) (f / t)), "sn", 336, 13180, 13203);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 337, 13229, 13242)) {
                                    CallChecker.isCalled(singularValues, double[].class, 337, 13229, 13242)[j] = t;
                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 337, 13229, 13242)[j], "CallChecker.isCalled(this.singularValues, double[].class, 337, 13229, 13242)[j]", 337, 13229, 13250);
                                }
                                if (j != k) {
                                    if (CallChecker.beforeDeref(e, double[].class, 339, 13328, 13328)) {
                                        f = (-sn) * (CallChecker.isCalled(e, double[].class, 339, 13328, 13328)[(j - 1)]);
                                        CallChecker.varAssign(f, "f", 339, 13318, 13336);
                                    }
                                    if (CallChecker.beforeDeref(e, double[].class, 340, 13366, 13366)) {
                                        if (CallChecker.beforeDeref(e, double[].class, 340, 13382, 13382)) {
                                            CallChecker.isCalled(e, double[].class, 340, 13366, 13366)[(j - 1)] = cs * (CallChecker.isCalled(e, double[].class, 340, 13382, 13382)[(j - 1)]);
                                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 340, 13366, 13366)[(j - 1)], "CallChecker.isCalled(e, double[].class, 340, 13366, 13366)[(j - 1)]", 340, 13366, 13390);
                                        }
                                    }
                                }
                                for (int i = 0; i < (n); i++) {
                                    if (CallChecker.beforeDeref(V, double[][].class, 344, 13510, 13510)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 344, 13510, 13510)[i], double[].class, 344, 13510, 13513)) {
                                            if (CallChecker.beforeDeref(V, double[][].class, 344, 13525, 13525)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 344, 13525, 13525)[i], double[].class, 344, 13525, 13528)) {
                                                    CallChecker.isCalled(V, double[][].class, 344, 13510, 13510)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 344, 13510, 13510)[i], double[].class, 344, 13510, 13513);
                                                    CallChecker.isCalled(V, double[][].class, 344, 13525, 13525)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 344, 13525, 13525)[i], double[].class, 344, 13525, 13528);
                                                    t = (cs * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 344, 13510, 13510)[i], double[].class, 344, 13510, 13513)[j])) + (sn * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 344, 13525, 13525)[i], double[].class, 344, 13525, 13528)[(p - 1)]));
                                                    CallChecker.varAssign(t, "t", 344, 13501, 13536);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(V, double[][].class, 345, 13566, 13566)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i], double[].class, 345, 13566, 13569)) {
                                            if (CallChecker.beforeDeref(V, double[][].class, 345, 13586, 13586)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 345, 13586, 13586)[i], double[].class, 345, 13586, 13589)) {
                                                    if (CallChecker.beforeDeref(V, double[][].class, 345, 13601, 13601)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 345, 13601, 13601)[i], double[].class, 345, 13601, 13604)) {
                                                            CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i], double[].class, 345, 13566, 13569);
                                                            CallChecker.isCalled(V, double[][].class, 345, 13586, 13586)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 345, 13586, 13586)[i], double[].class, 345, 13586, 13589);
                                                            CallChecker.isCalled(V, double[][].class, 345, 13601, 13601)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 345, 13601, 13601)[i], double[].class, 345, 13601, 13604);
                                                            CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i], double[].class, 345, 13566, 13569)[(p - 1)] = ((-sn) * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 345, 13586, 13586)[i], double[].class, 345, 13586, 13589)[j])) + (cs * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 345, 13601, 13601)[i], double[].class, 345, 13601, 13604)[(p - 1)]));
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i], double[].class, 345, 13566, 13569)[(p - 1)], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 345, 13566, 13566)[i], double[].class, 345, 13566, 13569)[(p - 1)]", 345, 13566, 13612);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(V, double[][].class, 346, 13642, 13642)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i], double[].class, 346, 13642, 13645)) {
                                            CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i], double[].class, 346, 13642, 13645);
                                            CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i], double[].class, 346, 13642, 13645)[j] = t;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i], double[].class, 346, 13642, 13645)[j], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 346, 13642, 13642)[i], double[].class, 346, 13642, 13645)[j]", 346, 13642, 13653);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2 :
                        {
                            double f = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(e, double[].class, 353, 13846, 13846)) {
                                f = CallChecker.isCalled(e, double[].class, 353, 13846, 13846)[(k - 1)];
                                CallChecker.varAssign(f, "f", 353, 13846, 13846);
                            }
                            if (CallChecker.beforeDeref(e, double[].class, 354, 13876, 13876)) {
                                CallChecker.isCalled(e, double[].class, 354, 13876, 13876)[(k - 1)] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 354, 13876, 13876)[(k - 1)], "CallChecker.isCalled(e, double[].class, 354, 13876, 13876)[(k - 1)]", 354, 13876, 13888);
                            }
                            for (int j = k; j < p; j++) {
                                double t = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 356, 13990, 14003)) {
                                    t = FastMath.hypot(CallChecker.isCalled(singularValues, double[].class, 356, 13990, 14003)[j], f);
                                    CallChecker.varAssign(t, "t", 356, 13990, 14003);
                                }
                                final double cs = CallChecker.varInit(((double) ((CallChecker.isCalled(this.singularValues, double[].class, 357, 14055, 14068)[j]) / t)), "cs", 357, 14037, 14076);
                                final double sn = CallChecker.varInit(((double) (f / t)), "sn", 358, 14102, 14125);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 359, 14151, 14164)) {
                                    CallChecker.isCalled(singularValues, double[].class, 359, 14151, 14164)[j] = t;
                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 359, 14151, 14164)[j], "CallChecker.isCalled(this.singularValues, double[].class, 359, 14151, 14164)[j]", 359, 14151, 14172);
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 360, 14208, 14208)) {
                                    f = (-sn) * (CallChecker.isCalled(e, double[].class, 360, 14208, 14208)[j]);
                                    CallChecker.varAssign(f, "f", 360, 14198, 14212);
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 361, 14238, 14238)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 361, 14250, 14250)) {
                                        CallChecker.isCalled(e, double[].class, 361, 14238, 14238)[j] = cs * (CallChecker.isCalled(e, double[].class, 361, 14250, 14250)[j]);
                                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 361, 14238, 14238)[j], "CallChecker.isCalled(e, double[].class, 361, 14238, 14238)[j]", 361, 14238, 14254);
                                    }
                                }
                                for (int i = 0; i < (m); i++) {
                                    if (CallChecker.beforeDeref(U, double[][].class, 364, 14348, 14348)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 364, 14348, 14348)[i], double[].class, 364, 14348, 14351)) {
                                            if (CallChecker.beforeDeref(U, double[][].class, 364, 14363, 14363)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 364, 14363, 14363)[i], double[].class, 364, 14363, 14366)) {
                                                    CallChecker.isCalled(U, double[][].class, 364, 14348, 14348)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 364, 14348, 14348)[i], double[].class, 364, 14348, 14351);
                                                    CallChecker.isCalled(U, double[][].class, 364, 14363, 14363)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 364, 14363, 14363)[i], double[].class, 364, 14363, 14366);
                                                    t = (cs * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 364, 14348, 14348)[i], double[].class, 364, 14348, 14351)[j])) + (sn * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 364, 14363, 14363)[i], double[].class, 364, 14363, 14366)[(k - 1)]));
                                                    CallChecker.varAssign(t, "t", 364, 14339, 14374);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(U, double[][].class, 365, 14404, 14404)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i], double[].class, 365, 14404, 14407)) {
                                            if (CallChecker.beforeDeref(U, double[][].class, 365, 14424, 14424)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 365, 14424, 14424)[i], double[].class, 365, 14424, 14427)) {
                                                    if (CallChecker.beforeDeref(U, double[][].class, 365, 14439, 14439)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 365, 14439, 14439)[i], double[].class, 365, 14439, 14442)) {
                                                            CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i], double[].class, 365, 14404, 14407);
                                                            CallChecker.isCalled(U, double[][].class, 365, 14424, 14424)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 365, 14424, 14424)[i], double[].class, 365, 14424, 14427);
                                                            CallChecker.isCalled(U, double[][].class, 365, 14439, 14439)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 365, 14439, 14439)[i], double[].class, 365, 14439, 14442);
                                                            CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i], double[].class, 365, 14404, 14407)[(k - 1)] = ((-sn) * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 365, 14424, 14424)[i], double[].class, 365, 14424, 14427)[j])) + (cs * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 365, 14439, 14439)[i], double[].class, 365, 14439, 14442)[(k - 1)]));
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i], double[].class, 365, 14404, 14407)[(k - 1)], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 365, 14404, 14404)[i], double[].class, 365, 14404, 14407)[(k - 1)]", 365, 14404, 14450);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(U, double[][].class, 366, 14480, 14480)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i], double[].class, 366, 14480, 14483)) {
                                            CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i], double[].class, 366, 14480, 14483);
                                            CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i], double[].class, 366, 14480, 14483)[j] = t;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i], double[].class, 366, 14480, 14483)[j], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 366, 14480, 14480)[i], double[].class, 366, 14480, 14483)[j]", 366, 14480, 14491);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 3 :
                        {
                            final double maxPm1Pm2 = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(this.singularValues, double[].class, 374, 14763, 14776)[(p - 1)]), FastMath.abs(CallChecker.isCalled(this.singularValues, double[].class, 375, 14858, 14871)[(p - 2)])))), "maxPm1Pm2", 374, 14668, 14881);
                            final double scale = CallChecker.varInit(((double) (FastMath.max(FastMath.max(FastMath.max(maxPm1Pm2, FastMath.abs(CallChecker.isCalled(e, double[].class, 377, 15067, 15067)[(p - 2)])), FastMath.abs(CallChecker.isCalled(this.singularValues, double[].class, 378, 15159, 15172)[k])), FastMath.abs(CallChecker.isCalled(e, double[].class, 379, 15247, 15247)[k])))), "scale", 376, 14903, 15253);
                            final double sp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.singularValues, double[].class, 380, 15293, 15306)[(p - 1)]) / scale)), "sp", 380, 15275, 15322);
                            final double spm1 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.singularValues, double[].class, 381, 15364, 15377)[(p - 2)]) / scale)), "spm1", 381, 15344, 15393);
                            final double epm1 = CallChecker.varInit(((double) ((CallChecker.isCalled(e, double[].class, 382, 15435, 15435)[(p - 2)]) / scale)), "epm1", 382, 15415, 15451);
                            final double sk = CallChecker.varInit(((double) ((CallChecker.isCalled(this.singularValues, double[].class, 383, 15491, 15504)[k]) / scale)), "sk", 383, 15473, 15516);
                            final double ek = CallChecker.varInit(((double) ((CallChecker.isCalled(e, double[].class, 384, 15556, 15556)[k]) / scale)), "ek", 384, 15538, 15568);
                            final double b = CallChecker.varInit(((double) ((((spm1 + sp) * (spm1 - sp)) + (epm1 * epm1)) / 2.0)), "b", 385, 15590, 15654);
                            final double c = CallChecker.varInit(((double) ((sp * epm1) * (sp * epm1))), "c", 386, 15676, 15718);
                            double shift = CallChecker.varInit(((double) (0)), "shift", 387, 15740, 15756);
                            if ((b != 0) || (c != 0)) {
                                shift = FastMath.sqrt(((b * b) + c));
                                CallChecker.varAssign(shift, "shift", 390, 15850, 15882);
                                if (b < 0) {
                                    shift = -shift;
                                    CallChecker.varAssign(shift, "shift", 392, 15949, 15963);
                                }
                                shift = c / (b + shift);
                                CallChecker.varAssign(shift, "shift", 394, 16015, 16038);
                            }
                            double f = CallChecker.varInit(((double) (((sk + sp) * (sk - sp)) + shift)), "f", 396, 16082, 16122);
                            double g = CallChecker.varInit(((double) (sk * ek)), "g", 397, 16144, 16162);
                            for (int j = k; j < (p - 1); j++) {
                                double t = CallChecker.varInit(((double) (FastMath.hypot(f, g))), "t", 400, 16278, 16309);
                                double cs = CallChecker.varInit(((double) (f / t)), "cs", 401, 16335, 16352);
                                double sn = CallChecker.varInit(((double) (g / t)), "sn", 402, 16378, 16395);
                                if (j != k) {
                                    if (CallChecker.beforeDeref(e, double[].class, 404, 16463, 16463)) {
                                        CallChecker.isCalled(e, double[].class, 404, 16463, 16463)[(j - 1)] = t;
                                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 404, 16463, 16463)[(j - 1)], "CallChecker.isCalled(e, double[].class, 404, 16463, 16463)[(j - 1)]", 404, 16463, 16475);
                                    }
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 406, 16536, 16549)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 406, 16561, 16561)) {
                                        f = (cs * (CallChecker.isCalled(singularValues, double[].class, 406, 16536, 16549)[j])) + (sn * (CallChecker.isCalled(e, double[].class, 406, 16561, 16561)[j]));
                                        CallChecker.varAssign(f, "f", 406, 16527, 16565);
                                    }
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 407, 16591, 16591)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 407, 16603, 16603)) {
                                        if (CallChecker.beforeDeref(singularValues, double[].class, 407, 16615, 16628)) {
                                            CallChecker.isCalled(e, double[].class, 407, 16591, 16591)[j] = (cs * (CallChecker.isCalled(e, double[].class, 407, 16603, 16603)[j])) - (sn * (CallChecker.isCalled(singularValues, double[].class, 407, 16615, 16628)[j]));
                                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 407, 16591, 16591)[j], "CallChecker.isCalled(e, double[].class, 407, 16591, 16591)[j]", 407, 16591, 16632);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 408, 16667, 16680)) {
                                    g = sn * (CallChecker.isCalled(singularValues, double[].class, 408, 16667, 16680)[(j + 1)]);
                                    CallChecker.varAssign(g, "g", 408, 16658, 16688);
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 409, 16714, 16727)) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 409, 16743, 16756)) {
                                        CallChecker.isCalled(singularValues, double[].class, 409, 16714, 16727)[(j + 1)] = cs * (CallChecker.isCalled(singularValues, double[].class, 409, 16743, 16756)[(j + 1)]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 409, 16714, 16727)[(j + 1)], "CallChecker.isCalled(this.singularValues, double[].class, 409, 16714, 16727)[(j + 1)]", 409, 16714, 16764);
                                    }
                                }
                                for (int i = 0; i < (n); i++) {
                                    if (CallChecker.beforeDeref(V, double[][].class, 412, 16858, 16858)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 412, 16858, 16858)[i], double[].class, 412, 16858, 16861)) {
                                            if (CallChecker.beforeDeref(V, double[][].class, 412, 16873, 16873)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 412, 16873, 16873)[i], double[].class, 412, 16873, 16876)) {
                                                    CallChecker.isCalled(V, double[][].class, 412, 16858, 16858)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 412, 16858, 16858)[i], double[].class, 412, 16858, 16861);
                                                    CallChecker.isCalled(V, double[][].class, 412, 16873, 16873)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 412, 16873, 16873)[i], double[].class, 412, 16873, 16876);
                                                    t = (cs * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 412, 16858, 16858)[i], double[].class, 412, 16858, 16861)[j])) + (sn * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 412, 16873, 16873)[i], double[].class, 412, 16873, 16876)[(j + 1)]));
                                                    CallChecker.varAssign(t, "t", 412, 16849, 16884);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(V, double[][].class, 413, 16914, 16914)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i], double[].class, 413, 16914, 16917)) {
                                            if (CallChecker.beforeDeref(V, double[][].class, 413, 16934, 16934)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 413, 16934, 16934)[i], double[].class, 413, 16934, 16937)) {
                                                    if (CallChecker.beforeDeref(V, double[][].class, 413, 16949, 16949)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 413, 16949, 16949)[i], double[].class, 413, 16949, 16952)) {
                                                            CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i], double[].class, 413, 16914, 16917);
                                                            CallChecker.isCalled(V, double[][].class, 413, 16934, 16934)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 413, 16934, 16934)[i], double[].class, 413, 16934, 16937);
                                                            CallChecker.isCalled(V, double[][].class, 413, 16949, 16949)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 413, 16949, 16949)[i], double[].class, 413, 16949, 16952);
                                                            CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i], double[].class, 413, 16914, 16917)[(j + 1)] = ((-sn) * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 413, 16934, 16934)[i], double[].class, 413, 16934, 16937)[j])) + (cs * (CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 413, 16949, 16949)[i], double[].class, 413, 16949, 16952)[(j + 1)]));
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i], double[].class, 413, 16914, 16917)[(j + 1)], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 413, 16914, 16914)[i], double[].class, 413, 16914, 16917)[(j + 1)]", 413, 16914, 16960);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(V, double[][].class, 414, 16990, 16990)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i], double[].class, 414, 16990, 16993)) {
                                            CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i], double[].class, 414, 16990, 16993);
                                            CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i], double[].class, 414, 16990, 16993)[j] = t;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i], double[].class, 414, 16990, 16993)[j], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 414, 16990, 16990)[i], double[].class, 414, 16990, 16993)[j]", 414, 16990, 17001);
                                        }
                                    }
                                }
                                t = FastMath.hypot(f, g);
                                CallChecker.varAssign(t, "t", 416, 17053, 17077);
                                cs = f / t;
                                CallChecker.varAssign(cs, "cs", 417, 17103, 17113);
                                sn = g / t;
                                CallChecker.varAssign(sn, "sn", 418, 17139, 17149);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 419, 17175, 17188)) {
                                    CallChecker.isCalled(singularValues, double[].class, 419, 17175, 17188)[j] = t;
                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 419, 17175, 17188)[j], "CallChecker.isCalled(this.singularValues, double[].class, 419, 17175, 17188)[j]", 419, 17175, 17196);
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 420, 17231, 17231)) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 420, 17243, 17256)) {
                                        f = (cs * (CallChecker.isCalled(e, double[].class, 420, 17231, 17231)[j])) + (sn * (CallChecker.isCalled(singularValues, double[].class, 420, 17243, 17256)[(j + 1)]));
                                        CallChecker.varAssign(f, "f", 420, 17222, 17264);
                                    }
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 421, 17290, 17303)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 421, 17320, 17320)) {
                                        if (CallChecker.beforeDeref(singularValues, double[].class, 421, 17332, 17345)) {
                                            CallChecker.isCalled(singularValues, double[].class, 421, 17290, 17303)[(j + 1)] = ((-sn) * (CallChecker.isCalled(e, double[].class, 421, 17320, 17320)[j])) + (cs * (CallChecker.isCalled(singularValues, double[].class, 421, 17332, 17345)[(j + 1)]));
                                            CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 421, 17290, 17303)[(j + 1)], "CallChecker.isCalled(this.singularValues, double[].class, 421, 17290, 17303)[(j + 1)]", 421, 17290, 17353);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 422, 17388, 17388)) {
                                    g = sn * (CallChecker.isCalled(e, double[].class, 422, 17388, 17388)[(j + 1)]);
                                    CallChecker.varAssign(g, "g", 422, 17379, 17396);
                                }
                                if (CallChecker.beforeDeref(e, double[].class, 423, 17422, 17422)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 423, 17438, 17438)) {
                                        CallChecker.isCalled(e, double[].class, 423, 17422, 17422)[(j + 1)] = cs * (CallChecker.isCalled(e, double[].class, 423, 17438, 17438)[(j + 1)]);
                                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 423, 17422, 17422)[(j + 1)], "CallChecker.isCalled(e, double[].class, 423, 17422, 17422)[(j + 1)]", 423, 17422, 17446);
                                    }
                                }
                                if (j < ((m) - 1)) {
                                    for (int i = 0; i < (m); i++) {
                                        if (CallChecker.beforeDeref(U, double[][].class, 426, 17588, 17588)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 426, 17588, 17588)[i], double[].class, 426, 17588, 17591)) {
                                                if (CallChecker.beforeDeref(U, double[][].class, 426, 17603, 17603)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 426, 17603, 17603)[i], double[].class, 426, 17603, 17606)) {
                                                        CallChecker.isCalled(U, double[][].class, 426, 17588, 17588)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 426, 17588, 17588)[i], double[].class, 426, 17588, 17591);
                                                        CallChecker.isCalled(U, double[][].class, 426, 17603, 17603)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 426, 17603, 17603)[i], double[].class, 426, 17603, 17606);
                                                        t = (cs * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 426, 17588, 17588)[i], double[].class, 426, 17588, 17591)[j])) + (sn * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 426, 17603, 17603)[i], double[].class, 426, 17603, 17606)[(j + 1)]));
                                                        CallChecker.varAssign(t, "t", 426, 17579, 17614);
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(U, double[][].class, 427, 17648, 17648)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i], double[].class, 427, 17648, 17651)) {
                                                if (CallChecker.beforeDeref(U, double[][].class, 427, 17668, 17668)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 427, 17668, 17668)[i], double[].class, 427, 17668, 17671)) {
                                                        if (CallChecker.beforeDeref(U, double[][].class, 427, 17683, 17683)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 427, 17683, 17683)[i], double[].class, 427, 17683, 17686)) {
                                                                CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i], double[].class, 427, 17648, 17651);
                                                                CallChecker.isCalled(U, double[][].class, 427, 17668, 17668)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 427, 17668, 17668)[i], double[].class, 427, 17668, 17671);
                                                                CallChecker.isCalled(U, double[][].class, 427, 17683, 17683)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 427, 17683, 17683)[i], double[].class, 427, 17683, 17686);
                                                                CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i], double[].class, 427, 17648, 17651)[(j + 1)] = ((-sn) * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 427, 17668, 17668)[i], double[].class, 427, 17668, 17671)[j])) + (cs * (CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 427, 17683, 17683)[i], double[].class, 427, 17683, 17686)[(j + 1)]));
                                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i], double[].class, 427, 17648, 17651)[(j + 1)], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 427, 17648, 17648)[i], double[].class, 427, 17648, 17651)[(j + 1)]", 427, 17648, 17694);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(U, double[][].class, 428, 17728, 17728)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i], double[].class, 428, 17728, 17731)) {
                                                CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i], double[].class, 428, 17728, 17731);
                                                CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i], double[].class, 428, 17728, 17731)[j] = t;
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i], double[].class, 428, 17728, 17731)[j], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 428, 17728, 17728)[i], double[].class, 428, 17728, 17731)[j]", 428, 17728, 17739);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(e, double[].class, 432, 17839, 17839)) {
                                CallChecker.isCalled(e, double[].class, 432, 17839, 17839)[(p - 2)] = f;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 432, 17839, 17839)[(p - 2)], "CallChecker.isCalled(e, double[].class, 432, 17839, 17839)[(p - 2)]", 432, 17839, 17851);
                            }
                            iter = iter + 1;
                            CallChecker.varAssign(iter, "iter", 433, 17873, 17888);
                        }
                        break;
                    default :
                        {
                            if (CallChecker.beforeDeref(singularValues, double[].class, 439, 18072, 18085)) {
                                if ((CallChecker.isCalled(singularValues, double[].class, 439, 18072, 18085)[k]) <= 0) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 440, 18142, 18155)) {
                                        if ((CallChecker.isCalled(singularValues, double[].class, 440, 18142, 18155)[k]) < 0) {
                                            if (CallChecker.beforeDeref(singularValues, double[].class, 440, 18122, 18135)) {
                                                if (CallChecker.beforeDeref(singularValues, double[].class, 440, 18167, 18180)) {
                                                    CallChecker.isCalled(singularValues, double[].class, 440, 18122, 18135)[k] = -(CallChecker.isCalled(singularValues, double[].class, 440, 18167, 18180)[k]);
                                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 440, 18122, 18135)[k], "CallChecker.isCalled(this.singularValues, double[].class, 440, 18122, 18135)[k]", 440, 18122, 18188);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(singularValues, double[].class, 440, 18122, 18135)) {
                                                CallChecker.isCalled(singularValues, double[].class, 440, 18122, 18135)[k] = 0;
                                                CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 440, 18122, 18135)[k], "CallChecker.isCalled(this.singularValues, double[].class, 440, 18122, 18135)[k]", 440, 18122, 18188);
                                            }
                                        }
                                    }
                                    for (int i = 0; i <= pp; i++) {
                                        if (CallChecker.beforeDeref(V, double[][].class, 443, 18275, 18275)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i], double[].class, 443, 18275, 18278)) {
                                                if (CallChecker.beforeDeref(V, double[][].class, 443, 18286, 18286)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 443, 18286, 18286)[i], double[].class, 443, 18286, 18289)) {
                                                        CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i], double[].class, 443, 18275, 18278);
                                                        CallChecker.isCalled(V, double[][].class, 443, 18286, 18286)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 443, 18286, 18286)[i], double[].class, 443, 18286, 18289);
                                                        CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i], double[].class, 443, 18275, 18278)[k] = -(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 443, 18286, 18286)[i], double[].class, 443, 18286, 18289)[k]);
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i], double[].class, 443, 18275, 18278)[k], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 443, 18275, 18275)[i], double[].class, 443, 18275, 18278)[k]", 443, 18275, 18293);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            while (k < pp) {
                                if (CallChecker.beforeDeref(singularValues, double[].class, 448, 18458, 18471)) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 448, 18479, 18492)) {
                                        if ((CallChecker.isCalled(singularValues, double[].class, 448, 18458, 18471)[k]) >= (CallChecker.isCalled(singularValues, double[].class, 448, 18479, 18492)[(k + 1)])) {
                                            break;
                                        }
                                    }
                                }
                                double t = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(singularValues, double[].class, 451, 18600, 18613)) {
                                    t = CallChecker.isCalled(singularValues, double[].class, 451, 18600, 18613)[k];
                                    CallChecker.varAssign(t, "t", 451, 18600, 18613);
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 452, 18643, 18656)) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 452, 18663, 18676)) {
                                        CallChecker.isCalled(singularValues, double[].class, 452, 18643, 18656)[k] = CallChecker.isCalled(singularValues, double[].class, 452, 18663, 18676)[(k + 1)];
                                        CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 452, 18643, 18656)[k], "CallChecker.isCalled(this.singularValues, double[].class, 452, 18643, 18656)[k]", 452, 18643, 18684);
                                    }
                                }
                                if (CallChecker.beforeDeref(singularValues, double[].class, 453, 18710, 18723)) {
                                    CallChecker.isCalled(singularValues, double[].class, 453, 18710, 18723)[(k + 1)] = t;
                                    CallChecker.varAssign(CallChecker.isCalled(this.singularValues, double[].class, 453, 18710, 18723)[(k + 1)], "CallChecker.isCalled(this.singularValues, double[].class, 453, 18710, 18723)[(k + 1)]", 453, 18710, 18735);
                                }
                                if (k < ((n) - 1)) {
                                    for (int i = 0; i < (n); i++) {
                                        if (CallChecker.beforeDeref(V, double[][].class, 456, 18872, 18872)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 456, 18872, 18872)[i], double[].class, 456, 18872, 18875)) {
                                                CallChecker.isCalled(V, double[][].class, 456, 18872, 18872)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 456, 18872, 18872)[i], double[].class, 456, 18872, 18875);
                                                t = CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 456, 18872, 18872)[i], double[].class, 456, 18872, 18875)[(k + 1)];
                                                CallChecker.varAssign(t, "t", 456, 18868, 18883);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(V, double[][].class, 457, 18917, 18917)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i], double[].class, 457, 18917, 18920)) {
                                                if (CallChecker.beforeDeref(V, double[][].class, 457, 18931, 18931)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 457, 18931, 18931)[i], double[].class, 457, 18931, 18934)) {
                                                        CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i], double[].class, 457, 18917, 18920);
                                                        CallChecker.isCalled(V, double[][].class, 457, 18931, 18931)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 457, 18931, 18931)[i], double[].class, 457, 18931, 18934);
                                                        CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i], double[].class, 457, 18917, 18920)[(k + 1)] = CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 457, 18931, 18931)[i], double[].class, 457, 18931, 18934)[k];
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i], double[].class, 457, 18917, 18920)[(k + 1)], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 457, 18917, 18917)[i], double[].class, 457, 18917, 18920)[(k + 1)]", 457, 18917, 18938);
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(V, double[][].class, 458, 18972, 18972)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i], double[].class, 458, 18972, 18975)) {
                                                CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i] = CallChecker.beforeCalled(CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i], double[].class, 458, 18972, 18975);
                                                CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i], double[].class, 458, 18972, 18975)[k] = t;
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i], double[].class, 458, 18972, 18975)[k], "CallChecker.isCalled(CallChecker.isCalled(V, double[][].class, 458, 18972, 18972)[i], double[].class, 458, 18972, 18975)[k]", 458, 18972, 18983);
                                            }
                                        }
                                    }
                                }
                                if (k < ((m) - 1)) {
                                    for (int i = 0; i < (m); i++) {
                                        if (CallChecker.beforeDeref(U, double[][].class, 463, 19176, 19176)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 463, 19176, 19176)[i], double[].class, 463, 19176, 19179)) {
                                                CallChecker.isCalled(U, double[][].class, 463, 19176, 19176)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 463, 19176, 19176)[i], double[].class, 463, 19176, 19179);
                                                t = CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 463, 19176, 19176)[i], double[].class, 463, 19176, 19179)[(k + 1)];
                                                CallChecker.varAssign(t, "t", 463, 19172, 19187);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(U, double[][].class, 464, 19221, 19221)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i], double[].class, 464, 19221, 19224)) {
                                                if (CallChecker.beforeDeref(U, double[][].class, 464, 19235, 19235)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 464, 19235, 19235)[i], double[].class, 464, 19235, 19238)) {
                                                        CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i], double[].class, 464, 19221, 19224);
                                                        CallChecker.isCalled(U, double[][].class, 464, 19235, 19235)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 464, 19235, 19235)[i], double[].class, 464, 19235, 19238);
                                                        CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i], double[].class, 464, 19221, 19224)[(k + 1)] = CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 464, 19235, 19235)[i], double[].class, 464, 19235, 19238)[k];
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i], double[].class, 464, 19221, 19224)[(k + 1)], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 464, 19221, 19221)[i], double[].class, 464, 19221, 19224)[(k + 1)]", 464, 19221, 19242);
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(U, double[][].class, 465, 19276, 19276)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i], double[].class, 465, 19276, 19279)) {
                                                CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i] = CallChecker.beforeCalled(CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i], double[].class, 465, 19276, 19279);
                                                CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i], double[].class, 465, 19276, 19279)[k] = t;
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i], double[].class, 465, 19276, 19279)[k], "CallChecker.isCalled(CallChecker.isCalled(U, double[][].class, 465, 19276, 19276)[i], double[].class, 465, 19276, 19279)[k]", 465, 19276, 19287);
                                            }
                                        }
                                    }
                                }
                                k++;
                            } 
                            iter = 0;
                            CallChecker.varAssign(iter, "iter", 470, 19416, 19424);
                            p--;
                        }
                        break;
                }
            } 
            tol = FastMath.max((((m) * (CallChecker.isCalled(singularValues, double[].class, 478, 19631, 19644)[0])) * (SingularValueDecomposition.EPS)), FastMath.sqrt(Precision.SAFE_MIN));
            CallChecker.varAssign(this.tol, "this.tol", 478, 19608, 19717);
            if (!(transposed)) {
                cachedU = MatrixUtils.createRealMatrix(U);
                CallChecker.varAssign(this.cachedU, "this.cachedU", 482, 19759, 19800);
                cachedV = MatrixUtils.createRealMatrix(V);
                CallChecker.varAssign(this.cachedV, "this.cachedV", 483, 19814, 19855);
            }else {
                cachedU = MatrixUtils.createRealMatrix(V);
                CallChecker.varAssign(this.cachedU, "this.cachedU", 485, 19886, 19927);
                cachedV = MatrixUtils.createRealMatrix(U);
                CallChecker.varAssign(this.cachedV, "this.cachedV", 486, 19941, 19982);
            }
        } finally {
            _bcornu_methode_context705.methodEnd();
        }
    }

    public RealMatrix getU() {
        MethodContext _bcornu_methode_context3101 = new MethodContext(RealMatrix.class, 496, 20005, 20293);
        try {
            CallChecker.varInit(this, "this", 496, 20005, 20293);
            CallChecker.varInit(this.tol, "tol", 496, 20005, 20293);
            CallChecker.varInit(this.cachedVt, "cachedVt", 496, 20005, 20293);
            CallChecker.varInit(this.cachedV, "cachedV", 496, 20005, 20293);
            CallChecker.varInit(this.cachedS, "cachedS", 496, 20005, 20293);
            CallChecker.varInit(this.cachedUt, "cachedUt", 496, 20005, 20293);
            CallChecker.varInit(this.cachedU, "cachedU", 496, 20005, 20293);
            CallChecker.varInit(this.transposed, "transposed", 496, 20005, 20293);
            CallChecker.varInit(this.n, "n", 496, 20005, 20293);
            CallChecker.varInit(this.m, "m", 496, 20005, 20293);
            CallChecker.varInit(this.singularValues, "singularValues", 496, 20005, 20293);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 496, 20005, 20293);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 496, 20005, 20293);
            return cachedU;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3101.methodEnd();
        }
    }

    public RealMatrix getUT() {
        MethodContext _bcornu_methode_context3102 = new MethodContext(RealMatrix.class, 508, 20300, 20733);
        try {
            CallChecker.varInit(this, "this", 508, 20300, 20733);
            CallChecker.varInit(this.tol, "tol", 508, 20300, 20733);
            CallChecker.varInit(this.cachedVt, "cachedVt", 508, 20300, 20733);
            CallChecker.varInit(this.cachedV, "cachedV", 508, 20300, 20733);
            CallChecker.varInit(this.cachedS, "cachedS", 508, 20300, 20733);
            CallChecker.varInit(this.cachedUt, "cachedUt", 508, 20300, 20733);
            CallChecker.varInit(this.cachedU, "cachedU", 508, 20300, 20733);
            CallChecker.varInit(this.transposed, "transposed", 508, 20300, 20733);
            CallChecker.varInit(this.n, "n", 508, 20300, 20733);
            CallChecker.varInit(this.m, "m", 508, 20300, 20733);
            CallChecker.varInit(this.singularValues, "singularValues", 508, 20300, 20733);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 508, 20300, 20733);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 508, 20300, 20733);
            if ((cachedUt) == null) {
                final RealMatrix npe_invocation_var785 = getU();
                if (CallChecker.beforeDeref(npe_invocation_var785, RealMatrix.class, 510, 20638, 20643)) {
                    cachedUt = CallChecker.isCalled(npe_invocation_var785, RealMatrix.class, 510, 20638, 20643).transpose();
                    CallChecker.varAssign(this.cachedUt, "this.cachedUt", 510, 20627, 20656);
                }
            }
            return cachedUt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3102.methodEnd();
        }
    }

    public RealMatrix getS() {
        MethodContext _bcornu_methode_context3103 = new MethodContext(RealMatrix.class, 522, 20740, 21218);
        try {
            CallChecker.varInit(this, "this", 522, 20740, 21218);
            CallChecker.varInit(this.tol, "tol", 522, 20740, 21218);
            CallChecker.varInit(this.cachedVt, "cachedVt", 522, 20740, 21218);
            CallChecker.varInit(this.cachedV, "cachedV", 522, 20740, 21218);
            CallChecker.varInit(this.cachedS, "cachedS", 522, 20740, 21218);
            CallChecker.varInit(this.cachedUt, "cachedUt", 522, 20740, 21218);
            CallChecker.varInit(this.cachedU, "cachedU", 522, 20740, 21218);
            CallChecker.varInit(this.transposed, "transposed", 522, 20740, 21218);
            CallChecker.varInit(this.n, "n", 522, 20740, 21218);
            CallChecker.varInit(this.m, "m", 522, 20740, 21218);
            CallChecker.varInit(this.singularValues, "singularValues", 522, 20740, 21218);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 522, 20740, 21218);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 522, 20740, 21218);
            if ((cachedS) == null) {
                cachedS = MatrixUtils.createRealDiagonalMatrix(singularValues);
                CallChecker.varAssign(this.cachedS, "this.cachedS", 525, 21116, 21178);
            }
            return cachedS;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3103.methodEnd();
        }
    }

    public double[] getSingularValues() {
        MethodContext _bcornu_methode_context3104 = new MethodContext(double[].class, 536, 21225, 21570);
        try {
            CallChecker.varInit(this, "this", 536, 21225, 21570);
            CallChecker.varInit(this.tol, "tol", 536, 21225, 21570);
            CallChecker.varInit(this.cachedVt, "cachedVt", 536, 21225, 21570);
            CallChecker.varInit(this.cachedV, "cachedV", 536, 21225, 21570);
            CallChecker.varInit(this.cachedS, "cachedS", 536, 21225, 21570);
            CallChecker.varInit(this.cachedUt, "cachedUt", 536, 21225, 21570);
            CallChecker.varInit(this.cachedU, "cachedU", 536, 21225, 21570);
            CallChecker.varInit(this.transposed, "transposed", 536, 21225, 21570);
            CallChecker.varInit(this.n, "n", 536, 21225, 21570);
            CallChecker.varInit(this.m, "m", 536, 21225, 21570);
            CallChecker.varInit(this.singularValues, "singularValues", 536, 21225, 21570);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 536, 21225, 21570);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 536, 21225, 21570);
            if (CallChecker.beforeDeref(singularValues, double[].class, 537, 21542, 21555)) {
                return CallChecker.isCalled(singularValues, double[].class, 537, 21542, 21555).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3104.methodEnd();
        }
    }

    public RealMatrix getV() {
        MethodContext _bcornu_methode_context3105 = new MethodContext(RealMatrix.class, 546, 21577, 21907);
        try {
            CallChecker.varInit(this, "this", 546, 21577, 21907);
            CallChecker.varInit(this.tol, "tol", 546, 21577, 21907);
            CallChecker.varInit(this.cachedVt, "cachedVt", 546, 21577, 21907);
            CallChecker.varInit(this.cachedV, "cachedV", 546, 21577, 21907);
            CallChecker.varInit(this.cachedS, "cachedS", 546, 21577, 21907);
            CallChecker.varInit(this.cachedUt, "cachedUt", 546, 21577, 21907);
            CallChecker.varInit(this.cachedU, "cachedU", 546, 21577, 21907);
            CallChecker.varInit(this.transposed, "transposed", 546, 21577, 21907);
            CallChecker.varInit(this.n, "n", 546, 21577, 21907);
            CallChecker.varInit(this.m, "m", 546, 21577, 21907);
            CallChecker.varInit(this.singularValues, "singularValues", 546, 21577, 21907);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 546, 21577, 21907);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 546, 21577, 21907);
            return cachedV;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3105.methodEnd();
        }
    }

    public RealMatrix getVT() {
        MethodContext _bcornu_methode_context3106 = new MethodContext(RealMatrix.class, 557, 21914, 22347);
        try {
            CallChecker.varInit(this, "this", 557, 21914, 22347);
            CallChecker.varInit(this.tol, "tol", 557, 21914, 22347);
            CallChecker.varInit(this.cachedVt, "cachedVt", 557, 21914, 22347);
            CallChecker.varInit(this.cachedV, "cachedV", 557, 21914, 22347);
            CallChecker.varInit(this.cachedS, "cachedS", 557, 21914, 22347);
            CallChecker.varInit(this.cachedUt, "cachedUt", 557, 21914, 22347);
            CallChecker.varInit(this.cachedU, "cachedU", 557, 21914, 22347);
            CallChecker.varInit(this.transposed, "transposed", 557, 21914, 22347);
            CallChecker.varInit(this.n, "n", 557, 21914, 22347);
            CallChecker.varInit(this.m, "m", 557, 21914, 22347);
            CallChecker.varInit(this.singularValues, "singularValues", 557, 21914, 22347);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 557, 21914, 22347);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 557, 21914, 22347);
            if ((cachedVt) == null) {
                final RealMatrix npe_invocation_var786 = getV();
                if (CallChecker.beforeDeref(npe_invocation_var786, RealMatrix.class, 559, 22252, 22257)) {
                    cachedVt = CallChecker.isCalled(npe_invocation_var786, RealMatrix.class, 559, 22252, 22257).transpose();
                    CallChecker.varAssign(this.cachedVt, "this.cachedVt", 559, 22241, 22270);
                }
            }
            return cachedVt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3106.methodEnd();
        }
    }

    public RealMatrix getCovariance(final double minSingularValue) {
        MethodContext _bcornu_methode_context3108 = new MethodContext(RealMatrix.class, 576, 22354, 24012);
        try {
            CallChecker.varInit(this, "this", 576, 22354, 24012);
            CallChecker.varInit(minSingularValue, "minSingularValue", 576, 22354, 24012);
            CallChecker.varInit(this.tol, "tol", 576, 22354, 24012);
            CallChecker.varInit(this.cachedVt, "cachedVt", 576, 22354, 24012);
            CallChecker.varInit(this.cachedV, "cachedV", 576, 22354, 24012);
            CallChecker.varInit(this.cachedS, "cachedS", 576, 22354, 24012);
            CallChecker.varInit(this.cachedUt, "cachedUt", 576, 22354, 24012);
            CallChecker.varInit(this.cachedU, "cachedU", 576, 22354, 24012);
            CallChecker.varInit(this.transposed, "transposed", 576, 22354, 24012);
            CallChecker.varInit(this.n, "n", 576, 22354, 24012);
            CallChecker.varInit(this.m, "m", 576, 22354, 24012);
            CallChecker.varInit(this.singularValues, "singularValues", 576, 22354, 24012);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 576, 22354, 24012);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 576, 22354, 24012);
            final int p = CallChecker.varInit(((int) (CallChecker.isCalled(this.singularValues, double[].class, 578, 23070, 23083).length)), "p", 578, 22999, 23091);
            int dimension = CallChecker.varInit(((int) (0)), "dimension", 579, 23101, 23118);
            while ((dimension < p) && ((CallChecker.isCalled(singularValues, double[].class, 581, 23167, 23180)[dimension]) >= minSingularValue)) {
                ++dimension;
            } 
            if (dimension == 0) {
                if (CallChecker.beforeDeref(singularValues, double[].class, 587, 23446, 23459)) {
                    throw new NumberIsTooLargeException(LocalizedFormats.TOO_LARGE_CUTOFF_SINGULAR_VALUE, minSingularValue, CallChecker.isCalled(singularValues, double[].class, 587, 23446, 23459)[0], true);
                }else
                    throw new AbnormalExecutionError();
                
            }
            final double[][] data = CallChecker.varInit(new double[dimension][p], "data", 590, 23491, 23539);
            final RealMatrix npe_invocation_var787 = getVT();
            if (CallChecker.beforeDeref(npe_invocation_var787, RealMatrix.class, 591, 23549, 23555)) {
                CallChecker.isCalled(npe_invocation_var787, RealMatrix.class, 591, 23549, 23555).walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() {
                    @Override
                    public void visit(final int row, final int column, final double value) {
                        MethodContext _bcornu_methode_context3107 = new MethodContext(void.class, 594, 23633, 23858);
                        try {
                            CallChecker.varInit(this, "this", 594, 23633, 23858);
                            CallChecker.varInit(value, "value", 594, 23633, 23858);
                            CallChecker.varInit(column, "column", 594, 23633, 23858);
                            CallChecker.varInit(row, "row", 594, 23633, 23858);
                            if (CallChecker.beforeDeref(data, double[][].class, 596, 23797, 23800)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row], double[].class, 596, 23797, 23805)) {
                                    if (CallChecker.beforeDeref(singularValues, double[].class, 596, 23825, 23838)) {
                                        CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row], double[].class, 596, 23797, 23805);
                                        CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row], double[].class, 596, 23797, 23805)[column] = value / (CallChecker.isCalled(singularValues, double[].class, 596, 23825, 23838)[row]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row], double[].class, 596, 23797, 23805)[column], "CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 596, 23797, 23800)[row], double[].class, 596, 23797, 23805)[column]", 596, 23797, 23844);
                                    }
                                }
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context3107.methodEnd();
                        }
                    }
                }, 0, (dimension - 1), 0, (p - 1));
            }
            RealMatrix jv = CallChecker.varInit(new Array2DRowRealMatrix(data, false), "jv", 600, 23909, 23962);
            if (CallChecker.beforeDeref(jv, RealMatrix.class, 601, 23979, 23980)) {
                jv = CallChecker.beforeCalled(jv, RealMatrix.class, 601, 23979, 23980);
                final RealMatrix npe_invocation_var788 = CallChecker.isCalled(jv, RealMatrix.class, 601, 23979, 23980).transpose();
                if (CallChecker.beforeDeref(npe_invocation_var788, RealMatrix.class, 601, 23979, 23992)) {
                    return CallChecker.isCalled(npe_invocation_var788, RealMatrix.class, 601, 23979, 23992).multiply(jv);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3108.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context3109 = new MethodContext(double.class, 611, 24019, 24366);
        try {
            CallChecker.varInit(this, "this", 611, 24019, 24366);
            CallChecker.varInit(this.tol, "tol", 611, 24019, 24366);
            CallChecker.varInit(this.cachedVt, "cachedVt", 611, 24019, 24366);
            CallChecker.varInit(this.cachedV, "cachedV", 611, 24019, 24366);
            CallChecker.varInit(this.cachedS, "cachedS", 611, 24019, 24366);
            CallChecker.varInit(this.cachedUt, "cachedUt", 611, 24019, 24366);
            CallChecker.varInit(this.cachedU, "cachedU", 611, 24019, 24366);
            CallChecker.varInit(this.transposed, "transposed", 611, 24019, 24366);
            CallChecker.varInit(this.n, "n", 611, 24019, 24366);
            CallChecker.varInit(this.m, "m", 611, 24019, 24366);
            CallChecker.varInit(this.singularValues, "singularValues", 611, 24019, 24366);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 611, 24019, 24366);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 611, 24019, 24366);
            if (CallChecker.beforeDeref(singularValues, double[].class, 612, 24343, 24356)) {
                return CallChecker.isCalled(singularValues, double[].class, 612, 24343, 24356)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3109.methodEnd();
        }
    }

    public double getConditionNumber() {
        MethodContext _bcornu_methode_context3110 = new MethodContext(double.class, 619, 24373, 24584);
        try {
            CallChecker.varInit(this, "this", 619, 24373, 24584);
            CallChecker.varInit(this.tol, "tol", 619, 24373, 24584);
            CallChecker.varInit(this.cachedVt, "cachedVt", 619, 24373, 24584);
            CallChecker.varInit(this.cachedV, "cachedV", 619, 24373, 24584);
            CallChecker.varInit(this.cachedS, "cachedS", 619, 24373, 24584);
            CallChecker.varInit(this.cachedUt, "cachedUt", 619, 24373, 24584);
            CallChecker.varInit(this.cachedU, "cachedU", 619, 24373, 24584);
            CallChecker.varInit(this.transposed, "transposed", 619, 24373, 24584);
            CallChecker.varInit(this.n, "n", 619, 24373, 24584);
            CallChecker.varInit(this.m, "m", 619, 24373, 24584);
            CallChecker.varInit(this.singularValues, "singularValues", 619, 24373, 24584);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 619, 24373, 24584);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 619, 24373, 24584);
            return (CallChecker.isCalled(singularValues, double[].class, 620, 24537, 24550)[0]) / (CallChecker.isCalled(singularValues, double[].class, 620, 24557, 24570)[((n) - 1)]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3110.methodEnd();
        }
    }

    public double getInverseConditionNumber() {
        MethodContext _bcornu_methode_context3111 = new MethodContext(double.class, 630, 24591, 24942);
        try {
            CallChecker.varInit(this, "this", 630, 24591, 24942);
            CallChecker.varInit(this.tol, "tol", 630, 24591, 24942);
            CallChecker.varInit(this.cachedVt, "cachedVt", 630, 24591, 24942);
            CallChecker.varInit(this.cachedV, "cachedV", 630, 24591, 24942);
            CallChecker.varInit(this.cachedS, "cachedS", 630, 24591, 24942);
            CallChecker.varInit(this.cachedUt, "cachedUt", 630, 24591, 24942);
            CallChecker.varInit(this.cachedU, "cachedU", 630, 24591, 24942);
            CallChecker.varInit(this.transposed, "transposed", 630, 24591, 24942);
            CallChecker.varInit(this.n, "n", 630, 24591, 24942);
            CallChecker.varInit(this.m, "m", 630, 24591, 24942);
            CallChecker.varInit(this.singularValues, "singularValues", 630, 24591, 24942);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 630, 24591, 24942);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 630, 24591, 24942);
            return (CallChecker.isCalled(singularValues, double[].class, 631, 24895, 24908)[((n) - 1)]) / (CallChecker.isCalled(singularValues, double[].class, 631, 24919, 24932)[0]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3111.methodEnd();
        }
    }

    public int getRank() {
        MethodContext _bcornu_methode_context3112 = new MethodContext(int.class, 642, 24949, 25562);
        try {
            CallChecker.varInit(this, "this", 642, 24949, 25562);
            CallChecker.varInit(this.tol, "tol", 642, 24949, 25562);
            CallChecker.varInit(this.cachedVt, "cachedVt", 642, 24949, 25562);
            CallChecker.varInit(this.cachedV, "cachedV", 642, 24949, 25562);
            CallChecker.varInit(this.cachedS, "cachedS", 642, 24949, 25562);
            CallChecker.varInit(this.cachedUt, "cachedUt", 642, 24949, 25562);
            CallChecker.varInit(this.cachedU, "cachedU", 642, 24949, 25562);
            CallChecker.varInit(this.transposed, "transposed", 642, 24949, 25562);
            CallChecker.varInit(this.n, "n", 642, 24949, 25562);
            CallChecker.varInit(this.m, "m", 642, 24949, 25562);
            CallChecker.varInit(this.singularValues, "singularValues", 642, 24949, 25562);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 642, 24949, 25562);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 642, 24949, 25562);
            int r = CallChecker.varInit(((int) (0)), "r", 643, 25383, 25392);
            for (int i = 0; i < (CallChecker.isCalled(singularValues, double[].class, 644, 25422, 25435).length); i++) {
                if (CallChecker.beforeDeref(singularValues, double[].class, 645, 25468, 25481)) {
                    if ((CallChecker.isCalled(singularValues, double[].class, 645, 25468, 25481)[i]) > (tol)) {
                        r++;
                    }
                }
            }
            return r;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3112.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context3113 = new MethodContext(DecompositionSolver.class, 656, 25569, 25819);
        try {
            CallChecker.varInit(this, "this", 656, 25569, 25819);
            CallChecker.varInit(this.tol, "tol", 656, 25569, 25819);
            CallChecker.varInit(this.cachedVt, "cachedVt", 656, 25569, 25819);
            CallChecker.varInit(this.cachedV, "cachedV", 656, 25569, 25819);
            CallChecker.varInit(this.cachedS, "cachedS", 656, 25569, 25819);
            CallChecker.varInit(this.cachedUt, "cachedUt", 656, 25569, 25819);
            CallChecker.varInit(this.cachedU, "cachedU", 656, 25569, 25819);
            CallChecker.varInit(this.transposed, "transposed", 656, 25569, 25819);
            CallChecker.varInit(this.n, "n", 656, 25569, 25819);
            CallChecker.varInit(this.m, "m", 656, 25569, 25819);
            CallChecker.varInit(this.singularValues, "singularValues", 656, 25569, 25819);
            CallChecker.varInit(TINY, "org.apache.commons.math3.linear.SingularValueDecomposition.TINY", 656, 25569, 25819);
            CallChecker.varInit(EPS, "org.apache.commons.math3.linear.SingularValueDecomposition.EPS", 656, 25569, 25819);
            return new SingularValueDecomposition.Solver(singularValues, getUT(), getV(), ((getRank()) == (m)), tol);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3113.methodEnd();
        }
    }
}

