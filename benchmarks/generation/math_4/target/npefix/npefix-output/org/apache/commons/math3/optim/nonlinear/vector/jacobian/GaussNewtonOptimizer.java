package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;

public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        this(true, checker);
        ConstructorContext _bcornu_methode_context161 = new ConstructorContext(GaussNewtonOptimizer.class, 62, 2474, 2769);
        try {
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    public GaussNewtonOptimizer(final boolean useLU, ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context162 = new ConstructorContext(GaussNewtonOptimizer.class, 72, 2776, 3189);
        try {
            this.useLU = useLU;
            CallChecker.varAssign(this.useLU, "this.useLU", 75, 3165, 3183);
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    @Override
    public PointVectorValuePair doOptimize() {
        MethodContext _bcornu_methode_context573 = new MethodContext(PointVectorValuePair.class, 80, 3196, 6837);
        try {
            CallChecker.varInit(this, "this", 80, 3196, 6837);
            CallChecker.varInit(this.iterations, "iterations", 80, 3196, 6837);
            CallChecker.varInit(this.evaluations, "evaluations", 80, 3196, 6837);
            CallChecker.varInit(this.useLU, "useLU", 80, 3196, 6837);
            checkParameters();
            final ConvergenceChecker<PointVectorValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 83, 3314, 3406);
            if (checker == null) {
                throw new NullArgumentException();
            }
            final double[] targetValues = CallChecker.varInit(getTarget(), "targetValues", 91, 3581, 3622);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(targetValues, double[].class, 92, 3647, 3658).length)), "nR", 92, 3632, 3666);
            final RealMatrix weightMatrix = CallChecker.varInit(getWeight(), "weightMatrix", 94, 3705, 3748);
            final double[] residualsWeights = CallChecker.varInit(new double[nR], "residualsWeights", 96, 3800, 3848);
            for (int i = 0; i < nR; i++) {
                if (CallChecker.beforeDeref(residualsWeights, double[].class, 98, 3901, 3916)) {
                    if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 98, 3923, 3934)) {
                        CallChecker.isCalled(residualsWeights, double[].class, 98, 3901, 3916)[i] = CallChecker.isCalled(weightMatrix, RealMatrix.class, 98, 3923, 3934).getEntry(i, i);
                        CallChecker.varAssign(CallChecker.isCalled(residualsWeights, double[].class, 98, 3901, 3916)[i], "CallChecker.isCalled(residualsWeights, double[].class, 98, 3901, 3916)[i]", 98, 3901, 3950);
                    }
                }
            }
            final double[] currentPoint = CallChecker.varInit(getStartPoint(), "currentPoint", 101, 3971, 4016);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(currentPoint, double[].class, 102, 4041, 4052).length)), "nC", 102, 4026, 4060);
            PointVectorValuePair current = CallChecker.varInit(null, "current", 105, 4119, 4154);
            for (boolean converged = false; !converged;) {
                incrementIterationCount();
                PointVectorValuePair previous = CallChecker.varInit(current, "previous", 110, 4327, 4366);
                final double[] currentObjective = CallChecker.varInit(computeObjectiveValue(currentPoint), "currentObjective", 112, 4446, 4515);
                final double[] currentResiduals = CallChecker.varInit(computeResiduals(currentObjective), "currentResiduals", 113, 4529, 4597);
                final RealMatrix weightedJacobian = CallChecker.varInit(computeWeightedJacobian(currentPoint), "weightedJacobian", 114, 4611, 4684);
                current = new PointVectorValuePair(currentPoint, currentObjective);
                CallChecker.varAssign(current, "current", 115, 4698, 4764);
                final double[] b = CallChecker.varInit(new double[nC], "b", 118, 4819, 4854);
                final double[][] a = CallChecker.varInit(new double[nC][nC], "a", 119, 4868, 4907);
                for (int i = 0; i < nR; ++i) {
                    final double[] grad = CallChecker.varInit(CallChecker.isCalled(weightedJacobian, RealMatrix.class, 122, 4993, 5008).getRow(i), "grad", 122, 4969, 5019);
                    final double weight = CallChecker.varInit(((double) (CallChecker.isCalled(residualsWeights, double[].class, 123, 5061, 5076)[i])), "weight", 123, 5037, 5080);
                    final double residual = CallChecker.varInit(((double) (CallChecker.isCalled(currentResiduals, double[].class, 124, 5122, 5137)[i])), "residual", 124, 5098, 5141);
                    final double wr = CallChecker.varInit(((double) (weight * residual)), "wr", 127, 5160, 5242);
                    for (int j = 0; j < nC; ++j) {
                        if (CallChecker.beforeDeref(b, double[].class, 129, 5311, 5311)) {
                            if (CallChecker.beforeDeref(grad, double[].class, 129, 5324, 5327)) {
                                CallChecker.isCalled(b, double[].class, 129, 5311, 5311)[j] += wr * (CallChecker.isCalled(grad, double[].class, 129, 5324, 5327)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(b, double[].class, 129, 5311, 5311)[j], "CallChecker.isCalled(b, double[].class, 129, 5311, 5311)[j]", 129, 5311, 5331);
                            }
                        }
                    }
                    for (int k = 0; k < nC; ++k) {
                        double[] ak = CallChecker.init(double[].class);
                        if (CallChecker.beforeDeref(a, double[][].class, 134, 5500, 5500)) {
                            ak = CallChecker.isCalled(a, double[][].class, 134, 5500, 5500)[k];
                            CallChecker.varAssign(ak, "ak", 134, 5500, 5500);
                        }
                        double wgk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(grad, double[].class, 135, 5548, 5551)) {
                            wgk = weight * (CallChecker.isCalled(grad, double[].class, 135, 5548, 5551)[k]);
                            CallChecker.varAssign(wgk, "wgk", 135, 5548, 5551);
                        }
                        for (int l = 0; l < nC; ++l) {
                            if (CallChecker.beforeDeref(ak, double[].class, 137, 5632, 5633)) {
                                if (CallChecker.beforeDeref(grad, double[].class, 137, 5647, 5650)) {
                                    ak = CallChecker.beforeCalled(ak, double[].class, 137, 5632, 5633);
                                    CallChecker.isCalled(ak, double[].class, 137, 5632, 5633)[l] += wgk * (CallChecker.isCalled(grad, double[].class, 137, 5647, 5650)[l]);
                                    CallChecker.varAssign(CallChecker.isCalled(ak, double[].class, 137, 5632, 5633)[l], "CallChecker.isCalled(ak, double[].class, 137, 5632, 5633)[l]", 137, 5632, 5654);
                                }
                            }
                        }
                    }
                }
                TryContext _bcornu_try_context_11 = new TryContext(11, GaussNewtonOptimizer.class, "org.apache.commons.math3.linear.SingularMatrixException");
                try {
                    RealMatrix mA = CallChecker.varInit(new BlockRealMatrix(a), "mA", 144, 5807, 5845);
                    DecompositionSolver solver = CallChecker.init(DecompositionSolver.class);
                    if (useLU) {
                        if (CallChecker.beforeDeref(new LUDecomposition(mA), LUDecomposition.class, 146, 5924, 5946)) {
                            solver = CallChecker.isCalled(new LUDecomposition(mA), LUDecomposition.class, 146, 5924, 5946).getSolver();
                            CallChecker.varAssign(solver, "solver", 145, 5892, 6020);
                        }
                    }else {
                        if (CallChecker.beforeDeref(new QRDecomposition(mA), QRDecomposition.class, 147, 5986, 6008)) {
                            solver = CallChecker.isCalled(new QRDecomposition(mA), QRDecomposition.class, 147, 5986, 6008).getSolver();
                            CallChecker.varAssign(solver, "solver", 145, 5892, 6020);
                        }
                    }
                    solver = CallChecker.beforeCalled(solver, DecompositionSolver.class, 148, 6059, 6064);
                    final double[] dX = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(solver, DecompositionSolver.class, 148, 6059, 6064).solve(new ArrayRealVector(b, false)), RealVector.class, 148, 6059, 6101).toArray(), "dX", 148, 6039, 6112);
                    for (int i = 0; i < nC; ++i) {
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 151, 6232, 6243)) {
                            if (CallChecker.beforeDeref(dX, double[].class, 151, 6251, 6252)) {
                                CallChecker.isCalled(currentPoint, double[].class, 151, 6232, 6243)[i] += CallChecker.isCalled(dX, double[].class, 151, 6251, 6252)[i];
                                CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 151, 6232, 6243)[i], "CallChecker.isCalled(currentPoint, double[].class, 151, 6232, 6243)[i]", 151, 6232, 6256);
                            }
                        }
                    }
                } catch (SingularMatrixException e) {
                    _bcornu_try_context_11.catchStart(11);
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM);
                } finally {
                    _bcornu_try_context_11.finallyStart(11);
                }
                if (previous != null) {
                    converged = checker.converged(getIterations(), previous, current);
                    CallChecker.varAssign(converged, "converged", 159, 6526, 6591);
                    if (converged) {
                        setCost(computeCost(currentResiduals));
                        return current;
                    }
                }
            }
            throw new MathInternalError();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context573.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context574 = new MethodContext(void.class, 174, 6844, 7211);
        try {
            CallChecker.varInit(this, "this", 174, 6844, 7211);
            CallChecker.varInit(this.iterations, "iterations", 174, 6844, 7211);
            CallChecker.varInit(this.evaluations, "evaluations", 174, 6844, 7211);
            CallChecker.varInit(this.useLU, "useLU", 174, 6844, 7211);
            if (((getLowerBound()) != null) || ((getUpperBound()) != null)) {
                throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context574.methodEnd();
        }
    }
}

