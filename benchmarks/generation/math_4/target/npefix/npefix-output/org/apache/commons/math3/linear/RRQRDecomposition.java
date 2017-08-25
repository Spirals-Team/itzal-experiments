package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class RRQRDecomposition extends QRDecomposition {
    private static class Solver implements DecompositionSolver {
        private final DecompositionSolver upper;

        private RealMatrix p;

        private Solver(final DecompositionSolver upper, final RealMatrix p) {
            ConstructorContext _bcornu_methode_context663 = new ConstructorContext(RRQRDecomposition.Solver.class, 206, 7249, 7555);
            try {
                this.upper = upper;
                CallChecker.varAssign(this.upper, "this.upper", 207, 7499, 7517);
                this.p = p;
                CallChecker.varAssign(this.p, "this.p", 208, 7531, 7545);
            } finally {
                _bcornu_methode_context663.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context2937 = new MethodContext(boolean.class, 212, 7566, 7678);
            try {
                CallChecker.varInit(this, "this", 212, 7566, 7678);
                CallChecker.varInit(this.p, "p", 212, 7566, 7678);
                CallChecker.varInit(this.upper, "upper", 212, 7566, 7678);
                if (CallChecker.beforeDeref(upper, DecompositionSolver.class, 213, 7647, 7651)) {
                    return CallChecker.isCalled(upper, DecompositionSolver.class, 213, 7647, 7651).isNonSingular();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2937.methodEnd();
            }
        }

        public RealVector solve(RealVector b) {
            MethodContext _bcornu_methode_context2938 = new MethodContext(RealVector.class, 217, 7689, 7812);
            try {
                CallChecker.varInit(this, "this", 217, 7689, 7812);
                CallChecker.varInit(b, "b", 217, 7689, 7812);
                CallChecker.varInit(this.p, "p", 217, 7689, 7812);
                CallChecker.varInit(this.upper, "upper", 217, 7689, 7812);
                if (CallChecker.beforeDeref(upper, DecompositionSolver.class, 218, 7787, 7791)) {
                    if (CallChecker.beforeDeref(p, RealMatrix.class, 218, 7777, 7777)) {
                        p = CallChecker.beforeCalled(p, RealMatrix.class, 218, 7777, 7777);
                        return CallChecker.isCalled(p, RealMatrix.class, 218, 7777, 7777).operate(CallChecker.isCalled(upper, DecompositionSolver.class, 218, 7787, 7791).solve(b));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2938.methodEnd();
            }
        }

        public RealMatrix solve(RealMatrix b) {
            MethodContext _bcornu_methode_context2939 = new MethodContext(RealMatrix.class, 222, 7823, 7947);
            try {
                CallChecker.varInit(this, "this", 222, 7823, 7947);
                CallChecker.varInit(b, "b", 222, 7823, 7947);
                CallChecker.varInit(this.p, "p", 222, 7823, 7947);
                CallChecker.varInit(this.upper, "upper", 222, 7823, 7947);
                if (CallChecker.beforeDeref(upper, DecompositionSolver.class, 223, 7922, 7926)) {
                    if (CallChecker.beforeDeref(p, RealMatrix.class, 223, 7911, 7911)) {
                        p = CallChecker.beforeCalled(p, RealMatrix.class, 223, 7911, 7911);
                        return CallChecker.isCalled(p, RealMatrix.class, 223, 7911, 7911).multiply(CallChecker.isCalled(upper, DecompositionSolver.class, 223, 7922, 7926).solve(b));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2939.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context2940 = new MethodContext(RealMatrix.class, 227, 7958, 8113);
            try {
                CallChecker.varInit(this, "this", 227, 7958, 8113);
                CallChecker.varInit(this.p, "p", 227, 7958, 8113);
                CallChecker.varInit(this.upper, "upper", 227, 7958, 8113);
                if (CallChecker.beforeDeref(p, RealMatrix.class, 228, 8082, 8082)) {
                    p = CallChecker.beforeCalled(p, RealMatrix.class, 228, 8082, 8082);
                    return solve(MatrixUtils.createRealIdentityMatrix(CallChecker.isCalled(p, RealMatrix.class, 228, 8082, 8082).getRowDimension()));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2940.methodEnd();
            }
        }
    }

    private int[] p;

    private RealMatrix cachedP;

    public RRQRDecomposition(RealMatrix matrix) {
        this(matrix, 0.0);
        ConstructorContext _bcornu_methode_context664 = new ConstructorContext(RRQRDecomposition.class, 68, 2583, 2897);
        try {
        } finally {
            _bcornu_methode_context664.methodEnd();
        }
    }

    public RRQRDecomposition(RealMatrix matrix, double threshold) {
        super(matrix, threshold);
        ConstructorContext _bcornu_methode_context665 = new ConstructorContext(RRQRDecomposition.class, 79, 2903, 3225);
        try {
        } finally {
            _bcornu_methode_context665.methodEnd();
        }
    }

    protected void decompose(double[][] qrt) {
        MethodContext _bcornu_methode_context2941 = new MethodContext(void.class, 86, 3232, 3489);
        try {
            CallChecker.varInit(this, "this", 86, 3232, 3489);
            CallChecker.varInit(qrt, "qrt", 86, 3232, 3489);
            CallChecker.varInit(this.cachedP, "cachedP", 86, 3232, 3489);
            CallChecker.varInit(this.p, "p", 86, 3232, 3489);
            if (CallChecker.beforeDeref(qrt, double[][].class, 87, 3365, 3367)) {
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 87, 3365, 3367);
                p = new int[CallChecker.isCalled(qrt, double[][].class, 87, 3365, 3367).length];
                CallChecker.varAssign(this.p, "this.p", 87, 3353, 3376);
            }
            p = CallChecker.beforeCalled(p, int[].class, 88, 3406, 3406);
            for (int i = 0; i < (CallChecker.isCalled(p, int[].class, 88, 3406, 3406).length); i++) {
                if (CallChecker.beforeDeref(p, int[].class, 89, 3435, 3435)) {
                    p = CallChecker.beforeCalled(p, int[].class, 89, 3435, 3435);
                    CallChecker.isCalled(p, int[].class, 89, 3435, 3435)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(this.p, int[].class, 89, 3435, 3435)[i], "CallChecker.isCalled(this.p, int[].class, 89, 3435, 3435)[i]", 89, 3435, 3443);
                }
            }
            super.decompose(qrt);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2941.methodEnd();
        }
    }

    protected void performHouseholderReflection(int minor, double[][] qrt) {
        MethodContext _bcornu_methode_context2942 = new MethodContext(void.class, 98, 3496, 4715);
        try {
            CallChecker.varInit(this, "this", 98, 3496, 4715);
            CallChecker.varInit(qrt, "qrt", 98, 3496, 4715);
            CallChecker.varInit(minor, "minor", 98, 3496, 4715);
            CallChecker.varInit(this.cachedP, "cachedP", 98, 3496, 4715);
            CallChecker.varInit(this.p, "p", 98, 3496, 4715);
            double l2NormSquaredMax = CallChecker.varInit(((double) (0)), "l2NormSquaredMax", 100, 3727, 3754);
            int l2NormSquaredMaxIndex = CallChecker.varInit(((int) (minor)), "l2NormSquaredMaxIndex", 102, 3827, 3860);
            qrt = CallChecker.beforeCalled(qrt, double[][].class, 103, 3894, 3896);
            for (int i = minor; i < (CallChecker.isCalled(qrt, double[][].class, 103, 3894, 3896).length); i++) {
                double l2NormSquared = CallChecker.varInit(((double) (0)), "l2NormSquared", 104, 3925, 3949);
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 105, 3983, 3985);
                CallChecker.isCalled(qrt, double[][].class, 105, 3983, 3985)[i] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 105, 3983, 3985)[i], double[].class, 105, 3983, 3988);
                for (int j = 0; j < (CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 105, 3983, 3985)[i], double[].class, 105, 3983, 3988).length); j++) {
                    if (CallChecker.beforeDeref(qrt, double[][].class, 106, 4038, 4040)) {
                        qrt = CallChecker.beforeCalled(qrt, double[][].class, 106, 4038, 4040);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(qrt, double[][].class, 106, 4038, 4040)[i], double[].class, 106, 4038, 4043)) {
                            if (CallChecker.beforeDeref(qrt, double[][].class, 106, 4050, 4052)) {
                                qrt = CallChecker.beforeCalled(qrt, double[][].class, 106, 4050, 4052);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(qrt, double[][].class, 106, 4050, 4052)[i], double[].class, 106, 4050, 4055)) {
                                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 106, 4038, 4040);
                                    CallChecker.isCalled(qrt, double[][].class, 106, 4038, 4040)[i] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 106, 4038, 4040)[i], double[].class, 106, 4038, 4043);
                                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 106, 4050, 4052);
                                    CallChecker.isCalled(qrt, double[][].class, 106, 4050, 4052)[i] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 106, 4050, 4052)[i], double[].class, 106, 4050, 4055);
                                    l2NormSquared += (CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 106, 4038, 4040)[i], double[].class, 106, 4038, 4043)[j]) * (CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 106, 4050, 4052)[i], double[].class, 106, 4050, 4055)[j]);
                                    CallChecker.varAssign(l2NormSquared, "l2NormSquared", 106, 4021, 4059);
                                }
                            }
                        }
                    }
                }
                if (l2NormSquared > l2NormSquaredMax) {
                    l2NormSquaredMax = l2NormSquared;
                    CallChecker.varAssign(l2NormSquaredMax, "l2NormSquaredMax", 109, 4143, 4175);
                    l2NormSquaredMaxIndex = i;
                    CallChecker.varAssign(l2NormSquaredMaxIndex, "l2NormSquaredMaxIndex", 110, 4193, 4218);
                }
            }
            if (l2NormSquaredMaxIndex != minor) {
                double[] tmp1 = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(qrt, double[][].class, 115, 4404, 4406)) {
                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 115, 4404, 4406);
                    tmp1 = CallChecker.isCalled(qrt, double[][].class, 115, 4404, 4406)[minor];
                    CallChecker.varAssign(tmp1, "tmp1", 115, 4404, 4406);
                }
                if (CallChecker.beforeDeref(qrt, double[][].class, 116, 4428, 4430)) {
                    if (CallChecker.beforeDeref(qrt, double[][].class, 116, 4441, 4443)) {
                        qrt = CallChecker.beforeCalled(qrt, double[][].class, 116, 4428, 4430);
                        qrt = CallChecker.beforeCalled(qrt, double[][].class, 116, 4441, 4443);
                        CallChecker.isCalled(qrt, double[][].class, 116, 4428, 4430)[minor] = CallChecker.isCalled(qrt, double[][].class, 116, 4441, 4443)[l2NormSquaredMaxIndex];
                        CallChecker.varAssign(CallChecker.isCalled(qrt, double[][].class, 116, 4428, 4430)[minor], "CallChecker.isCalled(qrt, double[][].class, 116, 4428, 4430)[minor]", 116, 4428, 4467);
                    }
                }
                if (CallChecker.beforeDeref(qrt, double[][].class, 117, 4481, 4483)) {
                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 117, 4481, 4483);
                    CallChecker.isCalled(qrt, double[][].class, 117, 4481, 4483)[l2NormSquaredMaxIndex] = tmp1;
                    CallChecker.varAssign(CallChecker.isCalled(qrt, double[][].class, 117, 4481, 4483)[l2NormSquaredMaxIndex], "CallChecker.isCalled(qrt, double[][].class, 117, 4481, 4483)[l2NormSquaredMaxIndex]", 117, 4481, 4514);
                }
                int tmp2 = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(p, int[].class, 118, 4539, 4539)) {
                    p = CallChecker.beforeCalled(p, int[].class, 118, 4539, 4539);
                    tmp2 = CallChecker.isCalled(p, int[].class, 118, 4539, 4539)[minor];
                    CallChecker.varAssign(tmp2, "tmp2", 118, 4539, 4539);
                }
                if (CallChecker.beforeDeref(p, int[].class, 119, 4561, 4561)) {
                    if (CallChecker.beforeDeref(p, int[].class, 119, 4572, 4572)) {
                        p = CallChecker.beforeCalled(p, int[].class, 119, 4561, 4561);
                        p = CallChecker.beforeCalled(p, int[].class, 119, 4572, 4572);
                        CallChecker.isCalled(p, int[].class, 119, 4561, 4561)[minor] = CallChecker.isCalled(p, int[].class, 119, 4572, 4572)[l2NormSquaredMaxIndex];
                        CallChecker.varAssign(CallChecker.isCalled(this.p, int[].class, 119, 4561, 4561)[minor], "CallChecker.isCalled(this.p, int[].class, 119, 4561, 4561)[minor]", 119, 4561, 4596);
                    }
                }
                if (CallChecker.beforeDeref(p, int[].class, 120, 4610, 4610)) {
                    p = CallChecker.beforeCalled(p, int[].class, 120, 4610, 4610);
                    CallChecker.isCalled(p, int[].class, 120, 4610, 4610)[l2NormSquaredMaxIndex] = tmp2;
                    CallChecker.varAssign(CallChecker.isCalled(this.p, int[].class, 120, 4610, 4610)[l2NormSquaredMaxIndex], "CallChecker.isCalled(this.p, int[].class, 120, 4610, 4610)[l2NormSquaredMaxIndex]", 120, 4610, 4641);
                }
            }
            super.performHouseholderReflection(minor, qrt);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2942.methodEnd();
        }
    }

    public RealMatrix getP() {
        MethodContext _bcornu_methode_context2943 = new MethodContext(RealMatrix.class, 135, 4723, 5264);
        try {
            CallChecker.varInit(this, "this", 135, 4723, 5264);
            CallChecker.varInit(this.cachedP, "cachedP", 135, 4723, 5264);
            CallChecker.varInit(this.p, "p", 135, 4723, 5264);
            if ((cachedP) == null) {
                int n = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(p, int[].class, 137, 5056, 5056)) {
                    p = CallChecker.beforeCalled(p, int[].class, 137, 5056, 5056);
                    n = CallChecker.isCalled(p, int[].class, 137, 5056, 5056).length;
                    CallChecker.varAssign(n, "n", 137, 5056, 5056);
                }
                cachedP = MatrixUtils.createRealMatrix(n, n);
                CallChecker.varAssign(this.cachedP, "this.cachedP", 138, 5078, 5121);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(p, int[].class, 140, 5198, 5198)) {
                        if (CallChecker.beforeDeref(cachedP, RealMatrix.class, 140, 5181, 5187)) {
                            p = CallChecker.beforeCalled(p, int[].class, 140, 5198, 5198);
                            cachedP = CallChecker.beforeCalled(cachedP, RealMatrix.class, 140, 5181, 5187);
                            CallChecker.isCalled(cachedP, RealMatrix.class, 140, 5181, 5187).setEntry(CallChecker.isCalled(p, int[].class, 140, 5198, 5198)[i], i, 1);
                        }
                    }
                }
            }
            return cachedP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2943.methodEnd();
        }
    }

    public int getRank(final double dropThreshold) {
        MethodContext _bcornu_methode_context2944 = new MethodContext(int.class, 165, 5271, 6710);
        try {
            CallChecker.varInit(this, "this", 165, 5271, 6710);
            CallChecker.varInit(dropThreshold, "dropThreshold", 165, 5271, 6710);
            CallChecker.varInit(this.cachedP, "cachedP", 165, 5271, 6710);
            CallChecker.varInit(this.p, "p", 165, 5271, 6710);
            RealMatrix r = CallChecker.varInit(getR(), "r", 166, 6114, 6138);
            int rows = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(r, RealMatrix.class, 167, 6166, 6166)) {
                r = CallChecker.beforeCalled(r, RealMatrix.class, 167, 6166, 6166);
                rows = CallChecker.isCalled(r, RealMatrix.class, 167, 6166, 6166).getRowDimension();
                CallChecker.varAssign(rows, "rows", 167, 6166, 6166);
            }
            int columns = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(r, RealMatrix.class, 168, 6213, 6213)) {
                r = CallChecker.beforeCalled(r, RealMatrix.class, 168, 6213, 6213);
                columns = CallChecker.isCalled(r, RealMatrix.class, 168, 6213, 6213).getColumnDimension();
                CallChecker.varAssign(columns, "columns", 168, 6213, 6213);
            }
            int rank = CallChecker.varInit(((int) (1)), "rank", 169, 6245, 6264);
            double lastNorm = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(r, RealMatrix.class, 170, 6292, 6292)) {
                r = CallChecker.beforeCalled(r, RealMatrix.class, 170, 6292, 6292);
                lastNorm = CallChecker.isCalled(r, RealMatrix.class, 170, 6292, 6292).getFrobeniusNorm();
                CallChecker.varAssign(lastNorm, "lastNorm", 170, 6292, 6292);
            }
            double rNorm = CallChecker.varInit(((double) (lastNorm)), "rNorm", 171, 6322, 6348);
            while (rank < (FastMath.min(rows, columns))) {
                double thisNorm = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(r, RealMatrix.class, 173, 6433, 6433)) {
                    r = CallChecker.beforeCalled(r, RealMatrix.class, 173, 6433, 6433);
                    final RealMatrix npe_invocation_var770 = CallChecker.isCalled(r, RealMatrix.class, 173, 6433, 6433).getSubMatrix(rank, (rows - 1), rank, (columns - 1));
                    if (CallChecker.beforeDeref(npe_invocation_var770, RealMatrix.class, 173, 6433, 6481)) {
                        thisNorm = CallChecker.isCalled(npe_invocation_var770, RealMatrix.class, 173, 6433, 6481).getFrobeniusNorm();
                        CallChecker.varAssign(thisNorm, "thisNorm", 173, 6433, 6433);
                    }
                }
                if ((thisNorm == 0) || (((thisNorm / lastNorm) * rNorm) < dropThreshold)) {
                    break;
                }
                lastNorm = thisNorm;
                CallChecker.varAssign(lastNorm, "lastNorm", 177, 6634, 6653);
                rank++;
            } 
            return rank;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2944.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context2945 = new MethodContext(DecompositionSolver.class, 187, 6717, 6945);
        try {
            CallChecker.varInit(this, "this", 187, 6717, 6945);
            CallChecker.varInit(this.cachedP, "cachedP", 187, 6717, 6945);
            CallChecker.varInit(this.p, "p", 187, 6717, 6945);
            return new RRQRDecomposition.Solver(super.getSolver(), this.getP());
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2945.methodEnd();
        }
    }
}

