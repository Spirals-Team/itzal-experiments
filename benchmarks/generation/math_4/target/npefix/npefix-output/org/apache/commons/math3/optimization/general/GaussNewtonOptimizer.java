package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
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
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;

@Deprecated
public class GaussNewtonOptimizer extends AbstractLeastSquaresOptimizer {
    private final boolean useLU;

    @Deprecated
    public GaussNewtonOptimizer() {
        this(true);
        ConstructorContext _bcornu_methode_context157 = new ConstructorContext(GaussNewtonOptimizer.class, 62, 2341, 2737);
        try {
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    public GaussNewtonOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        this(true, checker);
        ConstructorContext _bcornu_methode_context158 = new ConstructorContext(GaussNewtonOptimizer.class, 72, 2744, 3039);
        try {
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    @Deprecated
    public GaussNewtonOptimizer(final boolean useLU) {
        this(useLU, new SimpleVectorValueChecker());
        ConstructorContext _bcornu_methode_context159 = new ConstructorContext(GaussNewtonOptimizer.class, 87, 3046, 3596);
        try {
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public GaussNewtonOptimizer(final boolean useLU, ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context160 = new ConstructorContext(GaussNewtonOptimizer.class, 97, 3603, 4016);
        try {
            this.useLU = useLU;
            CallChecker.varAssign(this.useLU, "this.useLU", 100, 3992, 4010);
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    @Override
    public PointVectorValuePair doOptimize() {
        MethodContext _bcornu_methode_context572 = new MethodContext(PointVectorValuePair.class, 105, 4023, 7732);
        try {
            CallChecker.varInit(this, "this", 105, 4023, 7732);
            CallChecker.varInit(this.evaluations, "evaluations", 105, 4023, 7732);
            CallChecker.varInit(this.cost, "cost", 105, 4023, 7732);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 105, 4023, 7732);
            CallChecker.varInit(this.objective, "objective", 105, 4023, 7732);
            CallChecker.varInit(this.point, "point", 105, 4023, 7732);
            CallChecker.varInit(this.rows, "rows", 105, 4023, 7732);
            CallChecker.varInit(this.cols, "cols", 105, 4023, 7732);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 105, 4023, 7732);
            CallChecker.varInit(this.useLU, "useLU", 105, 4023, 7732);
            final ConvergenceChecker<PointVectorValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 106, 4113, 4205);
            if (checker == null) {
                throw new NullArgumentException();
            }
            final double[] targetValues = CallChecker.varInit(getTarget(), "targetValues", 114, 4380, 4421);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(targetValues, double[].class, 115, 4446, 4457).length)), "nR", 115, 4431, 4465);
            final RealMatrix weightMatrix = CallChecker.varInit(getWeight(), "weightMatrix", 117, 4504, 4547);
            final double[] residualsWeights = CallChecker.varInit(new double[nR], "residualsWeights", 119, 4599, 4647);
            for (int i = 0; i < nR; i++) {
                if (CallChecker.beforeDeref(residualsWeights, double[].class, 121, 4700, 4715)) {
                    if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 121, 4722, 4733)) {
                        CallChecker.isCalled(residualsWeights, double[].class, 121, 4700, 4715)[i] = CallChecker.isCalled(weightMatrix, RealMatrix.class, 121, 4722, 4733).getEntry(i, i);
                        CallChecker.varAssign(CallChecker.isCalled(residualsWeights, double[].class, 121, 4700, 4715)[i], "CallChecker.isCalled(residualsWeights, double[].class, 121, 4700, 4715)[i]", 121, 4700, 4749);
                    }
                }
            }
            final double[] currentPoint = CallChecker.varInit(getStartPoint(), "currentPoint", 124, 4770, 4815);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(currentPoint, double[].class, 125, 4840, 4851).length)), "nC", 125, 4825, 4859);
            PointVectorValuePair current = CallChecker.varInit(null, "current", 128, 4918, 4953);
            int iter = CallChecker.varInit(((int) (0)), "iter", 129, 4963, 4975);
            for (boolean converged = false; !converged;) {
                ++iter;
                PointVectorValuePair previous = CallChecker.varInit(current, "previous", 134, 5129, 5168);
                final double[] currentObjective = CallChecker.varInit(computeObjectiveValue(currentPoint), "currentObjective", 136, 5248, 5317);
                final double[] currentResiduals = CallChecker.varInit(computeResiduals(currentObjective), "currentResiduals", 137, 5331, 5399);
                final RealMatrix weightedJacobian = CallChecker.varInit(computeWeightedJacobian(currentPoint), "weightedJacobian", 138, 5413, 5486);
                current = new PointVectorValuePair(currentPoint, currentObjective);
                CallChecker.varAssign(current, "current", 139, 5500, 5566);
                final double[] b = CallChecker.varInit(new double[nC], "b", 142, 5621, 5656);
                final double[][] a = CallChecker.varInit(new double[nC][nC], "a", 143, 5670, 5709);
                for (int i = 0; i < nR; ++i) {
                    final double[] grad = CallChecker.varInit(CallChecker.isCalled(weightedJacobian, RealMatrix.class, 146, 5795, 5810).getRow(i), "grad", 146, 5771, 5821);
                    final double weight = CallChecker.varInit(((double) (CallChecker.isCalled(residualsWeights, double[].class, 147, 5863, 5878)[i])), "weight", 147, 5839, 5882);
                    final double residual = CallChecker.varInit(((double) (CallChecker.isCalled(currentResiduals, double[].class, 148, 5924, 5939)[i])), "residual", 148, 5900, 5943);
                    final double wr = CallChecker.varInit(((double) (weight * residual)), "wr", 151, 5962, 6044);
                    for (int j = 0; j < nC; ++j) {
                        if (CallChecker.beforeDeref(b, double[].class, 153, 6113, 6113)) {
                            if (CallChecker.beforeDeref(grad, double[].class, 153, 6126, 6129)) {
                                CallChecker.isCalled(b, double[].class, 153, 6113, 6113)[j] += wr * (CallChecker.isCalled(grad, double[].class, 153, 6126, 6129)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(b, double[].class, 153, 6113, 6113)[j], "CallChecker.isCalled(b, double[].class, 153, 6113, 6113)[j]", 153, 6113, 6133);
                            }
                        }
                    }
                    for (int k = 0; k < nC; ++k) {
                        double[] ak = CallChecker.init(double[].class);
                        if (CallChecker.beforeDeref(a, double[][].class, 158, 6302, 6302)) {
                            ak = CallChecker.isCalled(a, double[][].class, 158, 6302, 6302)[k];
                            CallChecker.varAssign(ak, "ak", 158, 6302, 6302);
                        }
                        double wgk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(grad, double[].class, 159, 6350, 6353)) {
                            wgk = weight * (CallChecker.isCalled(grad, double[].class, 159, 6350, 6353)[k]);
                            CallChecker.varAssign(wgk, "wgk", 159, 6350, 6353);
                        }
                        for (int l = 0; l < nC; ++l) {
                            if (CallChecker.beforeDeref(ak, double[].class, 161, 6434, 6435)) {
                                if (CallChecker.beforeDeref(grad, double[].class, 161, 6449, 6452)) {
                                    ak = CallChecker.beforeCalled(ak, double[].class, 161, 6434, 6435);
                                    CallChecker.isCalled(ak, double[].class, 161, 6434, 6435)[l] += wgk * (CallChecker.isCalled(grad, double[].class, 161, 6449, 6452)[l]);
                                    CallChecker.varAssign(CallChecker.isCalled(ak, double[].class, 161, 6434, 6435)[l], "CallChecker.isCalled(ak, double[].class, 161, 6434, 6435)[l]", 161, 6434, 6456);
                                }
                            }
                        }
                    }
                }
                TryContext _bcornu_try_context_10 = new TryContext(10, GaussNewtonOptimizer.class, "org.apache.commons.math3.linear.SingularMatrixException");
                try {
                    RealMatrix mA = CallChecker.varInit(new BlockRealMatrix(a), "mA", 168, 6609, 6647);
                    DecompositionSolver solver = CallChecker.init(DecompositionSolver.class);
                    if (useLU) {
                        if (CallChecker.beforeDeref(new LUDecomposition(mA), LUDecomposition.class, 170, 6726, 6748)) {
                            solver = CallChecker.isCalled(new LUDecomposition(mA), LUDecomposition.class, 170, 6726, 6748).getSolver();
                            CallChecker.varAssign(solver, "solver", 169, 6694, 6822);
                        }
                    }else {
                        if (CallChecker.beforeDeref(new QRDecomposition(mA), QRDecomposition.class, 171, 6788, 6810)) {
                            solver = CallChecker.isCalled(new QRDecomposition(mA), QRDecomposition.class, 171, 6788, 6810).getSolver();
                            CallChecker.varAssign(solver, "solver", 169, 6694, 6822);
                        }
                    }
                    solver = CallChecker.beforeCalled(solver, DecompositionSolver.class, 172, 6861, 6866);
                    final double[] dX = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(solver, DecompositionSolver.class, 172, 6861, 6866).solve(new ArrayRealVector(b, false)), RealVector.class, 172, 6861, 6903).toArray(), "dX", 172, 6841, 6914);
                    for (int i = 0; i < nC; ++i) {
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 175, 7034, 7045)) {
                            if (CallChecker.beforeDeref(dX, double[].class, 175, 7053, 7054)) {
                                CallChecker.isCalled(currentPoint, double[].class, 175, 7034, 7045)[i] += CallChecker.isCalled(dX, double[].class, 175, 7053, 7054)[i];
                                CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 175, 7034, 7045)[i], "CallChecker.isCalled(currentPoint, double[].class, 175, 7034, 7045)[i]", 175, 7034, 7058);
                            }
                        }
                    }
                } catch (SingularMatrixException e) {
                    _bcornu_try_context_10.catchStart(10);
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_SOLVE_SINGULAR_PROBLEM);
                } finally {
                    _bcornu_try_context_10.finallyStart(10);
                }
                if (previous != null) {
                    converged = checker.converged(iter, previous, current);
                    CallChecker.varAssign(converged, "converged", 183, 7328, 7382);
                    if (converged) {
                        cost = computeCost(currentResiduals);
                        CallChecker.varAssign(this.cost, "this.cost", 185, 7437, 7473);
                        if (CallChecker.beforeDeref(current, PointVectorValuePair.class, 187, 7561, 7567)) {
                            current = CallChecker.beforeCalled(current, PointVectorValuePair.class, 187, 7561, 7567);
                            point = CallChecker.isCalled(current, PointVectorValuePair.class, 187, 7561, 7567).getPoint();
                            CallChecker.varAssign(this.point, "this.point", 187, 7553, 7579);
                        }
                        return current;
                    }
                }
            }
            throw new MathInternalError();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context572.methodEnd();
        }
    }
}

