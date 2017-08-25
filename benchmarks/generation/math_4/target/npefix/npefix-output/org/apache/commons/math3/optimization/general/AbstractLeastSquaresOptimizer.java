package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public abstract class AbstractLeastSquaresOptimizer extends BaseAbstractMultivariateVectorOptimizer<DifferentiableMultivariateVectorFunction> implements DifferentiableMultivariateVectorOptimizer {
    @Deprecated
    private static final double DEFAULT_SINGULARITY_THRESHOLD = 1.0E-14;

    @Deprecated
    protected double[][] weightedResidualJacobian;

    @Deprecated
    protected int cols;

    @Deprecated
    protected int rows;

    @Deprecated
    protected double[] point;

    @Deprecated
    protected double[] objective;

    @Deprecated
    protected double[] weightedResiduals;

    @Deprecated
    protected double cost;

    private MultivariateDifferentiableVectorFunction jF;

    private int jacobianEvaluations;

    private RealMatrix weightMatrixSqrt;

    @Deprecated
    protected AbstractLeastSquaresOptimizer() {
        ConstructorContext _bcornu_methode_context601 = new ConstructorContext(AbstractLeastSquaresOptimizer.class, 128, 5245, 5598);
        try {
        } finally {
            _bcornu_methode_context601.methodEnd();
        }
    }

    protected AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context602 = new ConstructorContext(AbstractLeastSquaresOptimizer.class, 133, 5605, 5784);
        try {
        } finally {
            _bcornu_methode_context602.methodEnd();
        }
    }

    public int getJacobianEvaluations() {
        MethodContext _bcornu_methode_context2714 = new MethodContext(int.class, 140, 5791, 5952);
        try {
            CallChecker.varInit(this, "this", 140, 5791, 5952);
            CallChecker.varInit(this.evaluations, "evaluations", 140, 5791, 5952);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 140, 5791, 5952);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 140, 5791, 5952);
            CallChecker.varInit(this.jF, "jF", 140, 5791, 5952);
            CallChecker.varInit(this.cost, "cost", 140, 5791, 5952);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 140, 5791, 5952);
            CallChecker.varInit(this.objective, "objective", 140, 5791, 5952);
            CallChecker.varInit(this.point, "point", 140, 5791, 5952);
            CallChecker.varInit(this.rows, "rows", 140, 5791, 5952);
            CallChecker.varInit(this.cols, "cols", 140, 5791, 5952);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 140, 5791, 5952);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 140, 5791, 5952);
            return jacobianEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2714.methodEnd();
        }
    }

    @Deprecated
    protected void updateJacobian() {
        MethodContext _bcornu_methode_context2715 = new MethodContext(void.class, 153, 5959, 6438);
        try {
            CallChecker.varInit(this, "this", 153, 5959, 6438);
            CallChecker.varInit(this.evaluations, "evaluations", 153, 5959, 6438);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 153, 5959, 6438);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 153, 5959, 6438);
            CallChecker.varInit(this.jF, "jF", 153, 5959, 6438);
            CallChecker.varInit(this.cost, "cost", 153, 5959, 6438);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 153, 5959, 6438);
            CallChecker.varInit(this.objective, "objective", 153, 5959, 6438);
            CallChecker.varInit(this.point, "point", 153, 5959, 6438);
            CallChecker.varInit(this.rows, "rows", 153, 5959, 6438);
            CallChecker.varInit(this.cols, "cols", 153, 5959, 6438);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 153, 5959, 6438);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 153, 5959, 6438);
            final RealMatrix weightedJacobian = CallChecker.varInit(computeWeightedJacobian(point), "weightedJacobian", 154, 6284, 6350);
            if (CallChecker.beforeDeref(weightedJacobian, RealMatrix.class, 155, 6387, 6402)) {
                final RealMatrix npe_invocation_var689 = CallChecker.isCalled(weightedJacobian, RealMatrix.class, 155, 6387, 6402).scalarMultiply((-1));
                if (CallChecker.beforeDeref(npe_invocation_var689, RealMatrix.class, 155, 6387, 6421)) {
                    weightedResidualJacobian = CallChecker.isCalled(npe_invocation_var689, RealMatrix.class, 155, 6387, 6421).getData();
                    CallChecker.varAssign(this.weightedResidualJacobian, "this.weightedResidualJacobian", 155, 6360, 6432);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2715.methodEnd();
        }
    }

    protected RealMatrix computeWeightedJacobian(double[] params) {
        MethodContext _bcornu_methode_context2716 = new MethodContext(RealMatrix.class, 167, 6445, 7762);
        try {
            CallChecker.varInit(this, "this", 167, 6445, 7762);
            CallChecker.varInit(params, "params", 167, 6445, 7762);
            CallChecker.varInit(this.evaluations, "evaluations", 167, 6445, 7762);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 167, 6445, 7762);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 167, 6445, 7762);
            CallChecker.varInit(this.jF, "jF", 167, 6445, 7762);
            CallChecker.varInit(this.cost, "cost", 167, 6445, 7762);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 167, 6445, 7762);
            CallChecker.varInit(this.objective, "objective", 167, 6445, 7762);
            CallChecker.varInit(this.point, "point", 167, 6445, 7762);
            CallChecker.varInit(this.rows, "rows", 167, 6445, 7762);
            CallChecker.varInit(this.cols, "cols", 167, 6445, 7762);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 167, 6445, 7762);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 167, 6445, 7762);
            ++(jacobianEvaluations);
            params = CallChecker.beforeCalled(params, double[].class, 170, 6927, 6932);
            final DerivativeStructure[] dsPoint = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(params, double[].class, 170, 6927, 6932).length], "dsPoint", 170, 6865, 6941);
            params = CallChecker.beforeCalled(params, double[].class, 171, 6966, 6971);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(params, double[].class, 171, 6966, 6971).length)), "nC", 171, 6951, 6979);
            for (int i = 0; i < nC; ++i) {
                if (CallChecker.beforeDeref(dsPoint, DerivativeStructure[].class, 173, 7032, 7038)) {
                    if (CallChecker.beforeDeref(params, double[].class, 173, 7079, 7084)) {
                        params = CallChecker.beforeCalled(params, double[].class, 173, 7079, 7084);
                        CallChecker.isCalled(dsPoint, DerivativeStructure[].class, 173, 7032, 7038)[i] = new DerivativeStructure(nC, 1, i, CallChecker.isCalled(params, double[].class, 173, 7079, 7084)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(dsPoint, DerivativeStructure[].class, 173, 7032, 7038)[i], "CallChecker.isCalled(dsPoint, DerivativeStructure[].class, 173, 7032, 7038)[i]", 173, 7032, 7089);
                    }
                }
            }
            jF = CallChecker.beforeCalled(jF, MultivariateDifferentiableVectorFunction.class, 175, 7147, 7148);
            final DerivativeStructure[] dsValue = CallChecker.varInit(CallChecker.isCalled(jF, MultivariateDifferentiableVectorFunction.class, 175, 7147, 7148).value(dsPoint), "dsValue", 175, 7109, 7164);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(getTarget(), double[].class, 176, 7189, 7199).length)), "nR", 176, 7174, 7207);
            if (CallChecker.beforeDeref(dsValue, DerivativeStructure[].class, 177, 7221, 7227)) {
                if ((CallChecker.isCalled(dsValue, DerivativeStructure[].class, 177, 7221, 7227).length) != nR) {
                    if (CallChecker.beforeDeref(dsValue, DerivativeStructure[].class, 178, 7294, 7300)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(dsValue, DerivativeStructure[].class, 178, 7294, 7300).length, nR);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[][] jacobianData = CallChecker.varInit(new double[nR][nC], "jacobianData", 180, 7333, 7383);
            for (int i = 0; i < nR; ++i) {
                int[] orders = CallChecker.varInit(new int[nC], "orders", 182, 7436, 7462);
                for (int j = 0; j < nC; ++j) {
                    if (CallChecker.beforeDeref(orders, int[].class, 184, 7523, 7528)) {
                        orders = CallChecker.beforeCalled(orders, int[].class, 184, 7523, 7528);
                        CallChecker.isCalled(orders, int[].class, 184, 7523, 7528)[j] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 184, 7523, 7528)[j], "CallChecker.isCalled(orders, int[].class, 184, 7523, 7528)[j]", 184, 7523, 7536);
                    }
                    if (CallChecker.beforeDeref(jacobianData, double[][].class, 185, 7554, 7565)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i], double[].class, 185, 7554, 7568)) {
                            if (CallChecker.beforeDeref(dsValue, DerivativeStructure[].class, 185, 7575, 7581)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dsValue, DerivativeStructure[].class, 185, 7575, 7581)[i], DerivativeStructure.class, 185, 7575, 7584)) {
                                    CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i] = CallChecker.beforeCalled(CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i], double[].class, 185, 7554, 7568);
                                    CallChecker.isCalled(dsValue, DerivativeStructure[].class, 185, 7575, 7581)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dsValue, DerivativeStructure[].class, 185, 7575, 7581)[i], DerivativeStructure.class, 185, 7575, 7584);
                                    CallChecker.isCalled(CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i], double[].class, 185, 7554, 7568)[j] = CallChecker.isCalled(CallChecker.isCalled(dsValue, DerivativeStructure[].class, 185, 7575, 7581)[i], DerivativeStructure.class, 185, 7575, 7584).getPartialDerivative(orders);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i], double[].class, 185, 7554, 7568)[j], "CallChecker.isCalled(CallChecker.isCalled(jacobianData, double[][].class, 185, 7554, 7565)[i], double[].class, 185, 7554, 7568)[j]", 185, 7554, 7614);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(orders, int[].class, 186, 7632, 7637)) {
                        orders = CallChecker.beforeCalled(orders, int[].class, 186, 7632, 7637);
                        CallChecker.isCalled(orders, int[].class, 186, 7632, 7637)[j] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 186, 7632, 7637)[j], "CallChecker.isCalled(orders, int[].class, 186, 7632, 7637)[j]", 186, 7632, 7645);
                    }
                }
            }
            if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 190, 7687, 7702)) {
                weightMatrixSqrt = CallChecker.beforeCalled(weightMatrixSqrt, RealMatrix.class, 190, 7687, 7702);
                return CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 190, 7687, 7702).multiply(MatrixUtils.createRealMatrix(jacobianData));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2716.methodEnd();
        }
    }

    @Deprecated
    protected void updateResidualsAndCost() {
        MethodContext _bcornu_methode_context2717 = new MethodContext(void.class, 204, 7769, 8698);
        try {
            CallChecker.varInit(this, "this", 204, 7769, 8698);
            CallChecker.varInit(this.evaluations, "evaluations", 204, 7769, 8698);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 204, 7769, 8698);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 204, 7769, 8698);
            CallChecker.varInit(this.jF, "jF", 204, 7769, 8698);
            CallChecker.varInit(this.cost, "cost", 204, 7769, 8698);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 204, 7769, 8698);
            CallChecker.varInit(this.objective, "objective", 204, 7769, 8698);
            CallChecker.varInit(this.point, "point", 204, 7769, 8698);
            CallChecker.varInit(this.rows, "rows", 204, 7769, 8698);
            CallChecker.varInit(this.cols, "cols", 204, 7769, 8698);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 204, 7769, 8698);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 204, 7769, 8698);
            objective = computeObjectiveValue(point);
            CallChecker.varAssign(this.objective, "this.objective", 205, 8352, 8392);
            final double[] res = CallChecker.varInit(computeResiduals(objective), "res", 206, 8402, 8450);
            cost = computeCost(res);
            CallChecker.varAssign(this.cost, "this.cost", 209, 8486, 8509);
            final ArrayRealVector residuals = CallChecker.varInit(new ArrayRealVector(res), "residuals", 212, 8520, 8617);
            if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 213, 8647, 8662)) {
                weightMatrixSqrt = CallChecker.beforeCalled(weightMatrixSqrt, RealMatrix.class, 213, 8647, 8662);
                final RealVector npe_invocation_var690 = CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 213, 8647, 8662).operate(residuals);
                if (CallChecker.beforeDeref(npe_invocation_var690, RealVector.class, 213, 8647, 8681)) {
                    weightedResiduals = CallChecker.isCalled(npe_invocation_var690, RealVector.class, 213, 8647, 8681).toArray();
                    CallChecker.varAssign(this.weightedResiduals, "this.weightedResiduals", 213, 8627, 8692);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2717.methodEnd();
        }
    }

    protected double computeCost(double[] residuals) {
        MethodContext _bcornu_methode_context2718 = new MethodContext(double.class, 224, 8705, 9061);
        try {
            CallChecker.varInit(this, "this", 224, 8705, 9061);
            CallChecker.varInit(residuals, "residuals", 224, 8705, 9061);
            CallChecker.varInit(this.evaluations, "evaluations", 224, 8705, 9061);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 224, 8705, 9061);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 224, 8705, 9061);
            CallChecker.varInit(this.jF, "jF", 224, 8705, 9061);
            CallChecker.varInit(this.cost, "cost", 224, 8705, 9061);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 224, 8705, 9061);
            CallChecker.varInit(this.objective, "objective", 224, 8705, 9061);
            CallChecker.varInit(this.point, "point", 224, 8705, 9061);
            CallChecker.varInit(this.rows, "rows", 224, 8705, 9061);
            CallChecker.varInit(this.cols, "cols", 224, 8705, 9061);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 224, 8705, 9061);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 224, 8705, 9061);
            final ArrayRealVector r = CallChecker.varInit(new ArrayRealVector(residuals), "r", 225, 8931, 8987);
            final RealMatrix npe_invocation_var691 = getWeight();
            if (CallChecker.beforeDeref(npe_invocation_var691, RealMatrix.class, 226, 9031, 9041)) {
                if (CallChecker.beforeDeref(r, ArrayRealVector.class, 226, 9018, 9018)) {
                    return FastMath.sqrt(CallChecker.isCalled(r, ArrayRealVector.class, 226, 9018, 9018).dotProduct(CallChecker.isCalled(npe_invocation_var691, RealMatrix.class, 226, 9031, 9041).operate(r)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2718.methodEnd();
        }
    }

    public double getRMS() {
        MethodContext _bcornu_methode_context2719 = new MethodContext(double.class, 239, 9068, 9577);
        try {
            CallChecker.varInit(this, "this", 239, 9068, 9577);
            CallChecker.varInit(this.evaluations, "evaluations", 239, 9068, 9577);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 239, 9068, 9577);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 239, 9068, 9577);
            CallChecker.varInit(this.jF, "jF", 239, 9068, 9577);
            CallChecker.varInit(this.cost, "cost", 239, 9068, 9577);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 239, 9068, 9577);
            CallChecker.varInit(this.objective, "objective", 239, 9068, 9577);
            CallChecker.varInit(this.point, "point", 239, 9068, 9577);
            CallChecker.varInit(this.rows, "rows", 239, 9068, 9577);
            CallChecker.varInit(this.cols, "cols", 239, 9068, 9577);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 239, 9068, 9577);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 239, 9068, 9577);
            return FastMath.sqrt(((getChiSquare()) / (rows)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2719.methodEnd();
        }
    }

    public double getChiSquare() {
        MethodContext _bcornu_methode_context2720 = new MethodContext(double.class, 249, 9584, 9877);
        try {
            CallChecker.varInit(this, "this", 249, 9584, 9877);
            CallChecker.varInit(this.evaluations, "evaluations", 249, 9584, 9877);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 249, 9584, 9877);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 249, 9584, 9877);
            CallChecker.varInit(this.jF, "jF", 249, 9584, 9877);
            CallChecker.varInit(this.cost, "cost", 249, 9584, 9877);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 249, 9584, 9877);
            CallChecker.varInit(this.objective, "objective", 249, 9584, 9877);
            CallChecker.varInit(this.point, "point", 249, 9584, 9877);
            CallChecker.varInit(this.rows, "rows", 249, 9584, 9877);
            CallChecker.varInit(this.cols, "cols", 249, 9584, 9877);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 249, 9584, 9877);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 249, 9584, 9877);
            return (cost) * (cost);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2720.methodEnd();
        }
    }

    public RealMatrix getWeightSquareRoot() {
        MethodContext _bcornu_methode_context2721 = new MethodContext(RealMatrix.class, 259, 9884, 10114);
        try {
            CallChecker.varInit(this, "this", 259, 9884, 10114);
            CallChecker.varInit(this.evaluations, "evaluations", 259, 9884, 10114);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 259, 9884, 10114);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 259, 9884, 10114);
            CallChecker.varInit(this.jF, "jF", 259, 9884, 10114);
            CallChecker.varInit(this.cost, "cost", 259, 9884, 10114);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 259, 9884, 10114);
            CallChecker.varInit(this.objective, "objective", 259, 9884, 10114);
            CallChecker.varInit(this.point, "point", 259, 9884, 10114);
            CallChecker.varInit(this.rows, "rows", 259, 9884, 10114);
            CallChecker.varInit(this.cols, "cols", 259, 9884, 10114);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 259, 9884, 10114);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 259, 9884, 10114);
            if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 260, 10085, 10100)) {
                weightMatrixSqrt = CallChecker.beforeCalled(weightMatrixSqrt, RealMatrix.class, 260, 10085, 10100);
                return CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 260, 10085, 10100).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2721.methodEnd();
        }
    }

    protected void setCost(double cost) {
        MethodContext _bcornu_methode_context2722 = new MethodContext(void.class, 269, 10121, 10283);
        try {
            CallChecker.varInit(this, "this", 269, 10121, 10283);
            CallChecker.varInit(cost, "cost", 269, 10121, 10283);
            CallChecker.varInit(this.evaluations, "evaluations", 269, 10121, 10283);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 269, 10121, 10283);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 269, 10121, 10283);
            CallChecker.varInit(this.jF, "jF", 269, 10121, 10283);
            CallChecker.varInit(this.cost, "cost", 269, 10121, 10283);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 269, 10121, 10283);
            CallChecker.varInit(this.objective, "objective", 269, 10121, 10283);
            CallChecker.varInit(this.point, "point", 269, 10121, 10283);
            CallChecker.varInit(this.rows, "rows", 269, 10121, 10283);
            CallChecker.varInit(this.cols, "cols", 269, 10121, 10283);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 269, 10121, 10283);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 269, 10121, 10283);
            this.cost = cost;
            CallChecker.varAssign(this.cost, "this.cost", 270, 10261, 10277);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2722.methodEnd();
        }
    }

    @Deprecated
    public double[][] getCovariances() {
        MethodContext _bcornu_methode_context2723 = new MethodContext(double[][].class, 284, 10290, 10812);
        try {
            CallChecker.varInit(this, "this", 284, 10290, 10812);
            CallChecker.varInit(this.evaluations, "evaluations", 284, 10290, 10812);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 284, 10290, 10812);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 284, 10290, 10812);
            CallChecker.varInit(this.jF, "jF", 284, 10290, 10812);
            CallChecker.varInit(this.cost, "cost", 284, 10290, 10812);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 284, 10290, 10812);
            CallChecker.varInit(this.objective, "objective", 284, 10290, 10812);
            CallChecker.varInit(this.point, "point", 284, 10290, 10812);
            CallChecker.varInit(this.rows, "rows", 284, 10290, 10812);
            CallChecker.varInit(this.cols, "cols", 284, 10290, 10812);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 284, 10290, 10812);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 284, 10290, 10812);
            return getCovariances(AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2723.methodEnd();
        }
    }

    @Deprecated
    public double[][] getCovariances(double threshold) {
        MethodContext _bcornu_methode_context2724 = new MethodContext(double[][].class, 306, 10819, 11713);
        try {
            CallChecker.varInit(this, "this", 306, 10819, 11713);
            CallChecker.varInit(threshold, "threshold", 306, 10819, 11713);
            CallChecker.varInit(this.evaluations, "evaluations", 306, 10819, 11713);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 306, 10819, 11713);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 306, 10819, 11713);
            CallChecker.varInit(this.jF, "jF", 306, 10819, 11713);
            CallChecker.varInit(this.cost, "cost", 306, 10819, 11713);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 306, 10819, 11713);
            CallChecker.varInit(this.objective, "objective", 306, 10819, 11713);
            CallChecker.varInit(this.point, "point", 306, 10819, 11713);
            CallChecker.varInit(this.rows, "rows", 306, 10819, 11713);
            CallChecker.varInit(this.cols, "cols", 306, 10819, 11713);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 306, 10819, 11713);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 306, 10819, 11713);
            return computeCovariances(point, threshold);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2724.methodEnd();
        }
    }

    public double[][] computeCovariances(double[] params, double threshold) {
        MethodContext _bcornu_methode_context2725 = new MethodContext(double[][].class, 327, 11720, 12943);
        try {
            CallChecker.varInit(this, "this", 327, 11720, 12943);
            CallChecker.varInit(threshold, "threshold", 327, 11720, 12943);
            CallChecker.varInit(params, "params", 327, 11720, 12943);
            CallChecker.varInit(this.evaluations, "evaluations", 327, 11720, 12943);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 327, 11720, 12943);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 327, 11720, 12943);
            CallChecker.varInit(this.jF, "jF", 327, 11720, 12943);
            CallChecker.varInit(this.cost, "cost", 327, 11720, 12943);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 327, 11720, 12943);
            CallChecker.varInit(this.objective, "objective", 327, 11720, 12943);
            CallChecker.varInit(this.point, "point", 327, 11720, 12943);
            CallChecker.varInit(this.rows, "rows", 327, 11720, 12943);
            CallChecker.varInit(this.cols, "cols", 327, 11720, 12943);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 327, 11720, 12943);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 327, 11720, 12943);
            final RealMatrix j = CallChecker.varInit(computeWeightedJacobian(params), "j", 330, 12566, 12650);
            final RealMatrix jTj = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(j, RealMatrix.class, 333, 12718, 12718).transpose(), RealMatrix.class, 333, 12718, 12730).multiply(j), "jTj", 333, 12661, 12743);
            final DecompositionSolver solver = CallChecker.varInit(CallChecker.isCalled(new QRDecomposition(jTj, threshold), QRDecomposition.class, 337, 12844, 12878).getSolver(), "solver", 336, 12754, 12891);
            if (CallChecker.beforeDeref(solver, DecompositionSolver.class, 338, 12908, 12913)) {
                final RealMatrix npe_invocation_var692 = CallChecker.isCalled(solver, DecompositionSolver.class, 338, 12908, 12913).getInverse();
                if (CallChecker.beforeDeref(npe_invocation_var692, RealMatrix.class, 338, 12908, 12926)) {
                    return CallChecker.isCalled(npe_invocation_var692, RealMatrix.class, 338, 12908, 12926).getData();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2725.methodEnd();
        }
    }

    @Deprecated
    public double[] guessParametersErrors() {
        MethodContext _bcornu_methode_context2726 = new MethodContext(double[].class, 371, 12950, 15033);
        try {
            CallChecker.varInit(this, "this", 371, 12950, 15033);
            CallChecker.varInit(this.evaluations, "evaluations", 371, 12950, 15033);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 371, 12950, 15033);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 371, 12950, 15033);
            CallChecker.varInit(this.jF, "jF", 371, 12950, 15033);
            CallChecker.varInit(this.cost, "cost", 371, 12950, 15033);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 371, 12950, 15033);
            CallChecker.varInit(this.objective, "objective", 371, 12950, 15033);
            CallChecker.varInit(this.point, "point", 371, 12950, 15033);
            CallChecker.varInit(this.rows, "rows", 371, 12950, 15033);
            CallChecker.varInit(this.cols, "cols", 371, 12950, 15033);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 371, 12950, 15033);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 371, 12950, 15033);
            if ((rows) <= (cols)) {
                throw new NumberIsTooSmallException(LocalizedFormats.NO_DEGREES_OF_FREEDOM, rows, cols, false);
            }
            double[] errors = CallChecker.varInit(new double[cols], "errors", 376, 14721, 14755);
            final double c = CallChecker.varInit(((double) (FastMath.sqrt(((getChiSquare()) / ((this.rows) - (this.cols)))))), "c", 377, 14765, 14827);
            double[][] covar = CallChecker.varInit(computeCovariances(point, 1.0E-14), "covar", 378, 14837, 14888);
            errors = CallChecker.beforeCalled(errors, double[].class, 379, 14918, 14923);
            for (int i = 0; i < (CallChecker.isCalled(errors, double[].class, 379, 14918, 14923).length); ++i) {
                if (CallChecker.beforeDeref(errors, double[].class, 380, 14952, 14957)) {
                    if (CallChecker.beforeDeref(covar, double[][].class, 380, 14978, 14982)) {
                        covar = CallChecker.beforeCalled(covar, double[][].class, 380, 14978, 14982);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(covar, double[][].class, 380, 14978, 14982)[i], double[].class, 380, 14978, 14985)) {
                            errors = CallChecker.beforeCalled(errors, double[].class, 380, 14952, 14957);
                            covar = CallChecker.beforeCalled(covar, double[][].class, 380, 14978, 14982);
                            CallChecker.isCalled(covar, double[][].class, 380, 14978, 14982)[i] = CallChecker.beforeCalled(CallChecker.isCalled(covar, double[][].class, 380, 14978, 14982)[i], double[].class, 380, 14978, 14985);
                            CallChecker.isCalled(errors, double[].class, 380, 14952, 14957)[i] = (FastMath.sqrt(CallChecker.isCalled(CallChecker.isCalled(covar, double[][].class, 380, 14978, 14982)[i], double[].class, 380, 14978, 14985)[i])) * c;
                            CallChecker.varAssign(CallChecker.isCalled(errors, double[].class, 380, 14952, 14957)[i], "CallChecker.isCalled(errors, double[].class, 380, 14952, 14957)[i]", 380, 14952, 14994);
                        }
                    }
                }
            }
            return errors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2726.methodEnd();
        }
    }

    public double[] computeSigma(double[] params, double covarianceSingularityThreshold) {
        MethodContext _bcornu_methode_context2727 = new MethodContext(double[].class, 400, 15040, 16227);
        try {
            CallChecker.varInit(this, "this", 400, 15040, 16227);
            CallChecker.varInit(covarianceSingularityThreshold, "covarianceSingularityThreshold", 400, 15040, 16227);
            CallChecker.varInit(params, "params", 400, 15040, 16227);
            CallChecker.varInit(this.evaluations, "evaluations", 400, 15040, 16227);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 400, 15040, 16227);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 400, 15040, 16227);
            CallChecker.varInit(this.jF, "jF", 400, 15040, 16227);
            CallChecker.varInit(this.cost, "cost", 400, 15040, 16227);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 400, 15040, 16227);
            CallChecker.varInit(this.objective, "objective", 400, 15040, 16227);
            CallChecker.varInit(this.point, "point", 400, 15040, 16227);
            CallChecker.varInit(this.rows, "rows", 400, 15040, 16227);
            CallChecker.varInit(this.cols, "cols", 400, 15040, 16227);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 400, 15040, 16227);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 400, 15040, 16227);
            params = CallChecker.beforeCalled(params, double[].class, 402, 15956, 15961);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(params, double[].class, 402, 15956, 15961).length)), "nC", 402, 15941, 15969);
            final double[] sig = CallChecker.varInit(new double[nC], "sig", 403, 15979, 16014);
            final double[][] cov = CallChecker.varInit(computeCovariances(params, covarianceSingularityThreshold), "cov", 404, 16024, 16105);
            for (int i = 0; i < nC; ++i) {
                if (CallChecker.beforeDeref(sig, double[].class, 406, 16158, 16160)) {
                    if (CallChecker.beforeDeref(cov, double[][].class, 406, 16181, 16183)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cov, double[][].class, 406, 16181, 16183)[i], double[].class, 406, 16181, 16186)) {
                            CallChecker.isCalled(cov, double[][].class, 406, 16181, 16183)[i] = CallChecker.beforeCalled(CallChecker.isCalled(cov, double[][].class, 406, 16181, 16183)[i], double[].class, 406, 16181, 16186);
                            CallChecker.isCalled(sig, double[].class, 406, 16158, 16160)[i] = FastMath.sqrt(CallChecker.isCalled(CallChecker.isCalled(cov, double[][].class, 406, 16181, 16183)[i], double[].class, 406, 16181, 16186)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(sig, double[].class, 406, 16158, 16160)[i], "CallChecker.isCalled(sig, double[].class, 406, 16158, 16160)[i]", 406, 16158, 16191);
                        }
                    }
                }
            }
            return sig;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2727.methodEnd();
        }
    }

    @Override
    @Deprecated
    public PointVectorValuePair optimize(int maxEval, final DifferentiableMultivariateVectorFunction f, final double[] target, final double[] weights, final double[] startPoint) {
        MethodContext _bcornu_methode_context2728 = new MethodContext(PointVectorValuePair.class, 419, 16234, 17153);
        try {
            CallChecker.varInit(this, "this", 419, 16234, 17153);
            CallChecker.varInit(startPoint, "startPoint", 419, 16234, 17153);
            CallChecker.varInit(weights, "weights", 419, 16234, 17153);
            CallChecker.varInit(target, "target", 419, 16234, 17153);
            CallChecker.varInit(f, "f", 419, 16234, 17153);
            CallChecker.varInit(maxEval, "maxEval", 419, 16234, 17153);
            CallChecker.varInit(this.evaluations, "evaluations", 419, 16234, 17153);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 419, 16234, 17153);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 419, 16234, 17153);
            CallChecker.varInit(this.jF, "jF", 419, 16234, 17153);
            CallChecker.varInit(this.cost, "cost", 419, 16234, 17153);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 419, 16234, 17153);
            CallChecker.varInit(this.objective, "objective", 419, 16234, 17153);
            CallChecker.varInit(this.point, "point", 419, 16234, 17153);
            CallChecker.varInit(this.rows, "rows", 419, 16234, 17153);
            CallChecker.varInit(this.cols, "cols", 419, 16234, 17153);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 419, 16234, 17153);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 419, 16234, 17153);
            return optimizeInternal(maxEval, FunctionUtils.toMultivariateDifferentiableVectorFunction(f), new Target(target), new Weight(weights), new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2728.methodEnd();
        }
    }

    @Deprecated
    public PointVectorValuePair optimize(final int maxEval, final MultivariateDifferentiableVectorFunction f, final double[] target, final double[] weights, final double[] startPoint) {
        MethodContext _bcornu_methode_context2729 = new MethodContext(PointVectorValuePair.class, 455, 17160, 18995);
        try {
            CallChecker.varInit(this, "this", 455, 17160, 18995);
            CallChecker.varInit(startPoint, "startPoint", 455, 17160, 18995);
            CallChecker.varInit(weights, "weights", 455, 17160, 18995);
            CallChecker.varInit(target, "target", 455, 17160, 18995);
            CallChecker.varInit(f, "f", 455, 17160, 18995);
            CallChecker.varInit(maxEval, "maxEval", 455, 17160, 18995);
            CallChecker.varInit(this.evaluations, "evaluations", 455, 17160, 18995);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 455, 17160, 18995);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 455, 17160, 18995);
            CallChecker.varInit(this.jF, "jF", 455, 17160, 18995);
            CallChecker.varInit(this.cost, "cost", 455, 17160, 18995);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 455, 17160, 18995);
            CallChecker.varInit(this.objective, "objective", 455, 17160, 18995);
            CallChecker.varInit(this.point, "point", 455, 17160, 18995);
            CallChecker.varInit(this.rows, "rows", 455, 17160, 18995);
            CallChecker.varInit(this.cols, "cols", 455, 17160, 18995);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 455, 17160, 18995);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 455, 17160, 18995);
            return optimizeInternal(maxEval, f, new Target(target), new Weight(weights), new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2729.methodEnd();
        }
    }

    @Deprecated
    protected PointVectorValuePair optimizeInternal(final int maxEval, final MultivariateDifferentiableVectorFunction f, OptimizationData... optData) {
        MethodContext _bcornu_methode_context2730 = new MethodContext(PointVectorValuePair.class, 491, 19002, 20795);
        try {
            CallChecker.varInit(this, "this", 491, 19002, 20795);
            CallChecker.varInit(optData, "optData", 491, 19002, 20795);
            CallChecker.varInit(f, "f", 491, 19002, 20795);
            CallChecker.varInit(maxEval, "maxEval", 491, 19002, 20795);
            CallChecker.varInit(this.evaluations, "evaluations", 491, 19002, 20795);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 491, 19002, 20795);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 491, 19002, 20795);
            CallChecker.varInit(this.jF, "jF", 491, 19002, 20795);
            CallChecker.varInit(this.cost, "cost", 491, 19002, 20795);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 491, 19002, 20795);
            CallChecker.varInit(this.objective, "objective", 491, 19002, 20795);
            CallChecker.varInit(this.point, "point", 491, 19002, 20795);
            CallChecker.varInit(this.rows, "rows", 491, 19002, 20795);
            CallChecker.varInit(this.cols, "cols", 491, 19002, 20795);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 491, 19002, 20795);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 491, 19002, 20795);
            return super.optimizeInternal(maxEval, FunctionUtils.toDifferentiableMultivariateVectorFunction(f), optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2730.methodEnd();
        }
    }

    @Override
    protected void setUp() {
        MethodContext _bcornu_methode_context2731 = new MethodContext(void.class, 501, 20802, 21761);
        try {
            CallChecker.varInit(this, "this", 501, 20802, 21761);
            CallChecker.varInit(this.evaluations, "evaluations", 501, 20802, 21761);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 501, 20802, 21761);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 501, 20802, 21761);
            CallChecker.varInit(this.jF, "jF", 501, 20802, 21761);
            CallChecker.varInit(this.cost, "cost", 501, 20802, 21761);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 501, 20802, 21761);
            CallChecker.varInit(this.objective, "objective", 501, 20802, 21761);
            CallChecker.varInit(this.point, "point", 501, 20802, 21761);
            CallChecker.varInit(this.rows, "rows", 501, 20802, 21761);
            CallChecker.varInit(this.cols, "cols", 501, 20802, 21761);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 501, 20802, 21761);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 501, 20802, 21761);
            super.setUp();
            jacobianEvaluations = 0;
            CallChecker.varAssign(this.jacobianEvaluations, "this.jacobianEvaluations", 505, 20924, 20947);
            weightMatrixSqrt = squareRoot(getWeight());
            CallChecker.varAssign(this.weightMatrixSqrt, "this.weightMatrixSqrt", 508, 21003, 21045);
            jF = FunctionUtils.toMultivariateDifferentiableVectorFunction(((DifferentiableMultivariateVectorFunction) (getObjectiveFunction())));
            CallChecker.varAssign(this.jF, "this.jF", 516, 21464, 21592);
            point = getStartPoint();
            CallChecker.varAssign(this.point, "this.point", 519, 21668, 21691);
            final double[] npe_invocation_var693 = getTarget();
            if (CallChecker.beforeDeref(npe_invocation_var693, double[].class, 520, 21708, 21718)) {
                rows = CallChecker.isCalled(npe_invocation_var693, double[].class, 520, 21708, 21718).length;
                CallChecker.varAssign(this.rows, "this.rows", 520, 21701, 21726);
            }
            if (CallChecker.beforeDeref(point, double[].class, 521, 21743, 21747)) {
                point = CallChecker.beforeCalled(point, double[].class, 521, 21743, 21747);
                cols = CallChecker.isCalled(point, double[].class, 521, 21743, 21747).length;
                CallChecker.varAssign(this.cols, "this.cols", 521, 21736, 21755);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2731.methodEnd();
        }
    }

    protected double[] computeResiduals(double[] objectiveValue) {
        MethodContext _bcornu_methode_context2732 = new MethodContext(double[].class, 540, 21768, 22932);
        try {
            CallChecker.varInit(this, "this", 540, 21768, 22932);
            CallChecker.varInit(objectiveValue, "objectiveValue", 540, 21768, 22932);
            CallChecker.varInit(this.evaluations, "evaluations", 540, 21768, 22932);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 540, 21768, 22932);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 540, 21768, 22932);
            CallChecker.varInit(this.jF, "jF", 540, 21768, 22932);
            CallChecker.varInit(this.cost, "cost", 540, 21768, 22932);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 540, 21768, 22932);
            CallChecker.varInit(this.objective, "objective", 540, 21768, 22932);
            CallChecker.varInit(this.point, "point", 540, 21768, 22932);
            CallChecker.varInit(this.rows, "rows", 540, 21768, 22932);
            CallChecker.varInit(this.cols, "cols", 540, 21768, 22932);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 540, 21768, 22932);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 540, 21768, 22932);
            final double[] target = CallChecker.varInit(getTarget(), "target", 541, 22482, 22517);
            if (CallChecker.beforeDeref(objectiveValue, double[].class, 542, 22531, 22544)) {
                if (CallChecker.beforeDeref(target, double[].class, 542, 22556, 22561)) {
                    objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 542, 22531, 22544);
                    if ((CallChecker.isCalled(objectiveValue, double[].class, 542, 22531, 22544).length) != (CallChecker.isCalled(target, double[].class, 542, 22556, 22561).length)) {
                        if (CallChecker.beforeDeref(target, double[].class, 543, 22622, 22627)) {
                            if (CallChecker.beforeDeref(objectiveValue, double[].class, 544, 22686, 22699)) {
                                objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 544, 22686, 22699);
                                throw new DimensionMismatchException(CallChecker.isCalled(target, double[].class, 543, 22622, 22627).length, CallChecker.isCalled(objectiveValue, double[].class, 544, 22686, 22699).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] residuals = CallChecker.varInit(new double[CallChecker.isCalled(target, double[].class, 547, 22767, 22772).length], "residuals", 547, 22729, 22781);
            for (int i = 0; i < (CallChecker.isCalled(target, double[].class, 548, 22811, 22816).length); i++) {
                if (CallChecker.beforeDeref(residuals, double[].class, 549, 22845, 22853)) {
                    if (CallChecker.beforeDeref(target, double[].class, 549, 22860, 22865)) {
                        if (CallChecker.beforeDeref(objectiveValue, double[].class, 549, 22872, 22885)) {
                            objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 549, 22872, 22885);
                            CallChecker.isCalled(residuals, double[].class, 549, 22845, 22853)[i] = (CallChecker.isCalled(target, double[].class, 549, 22860, 22865)[i]) - (CallChecker.isCalled(objectiveValue, double[].class, 549, 22872, 22885)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(residuals, double[].class, 549, 22845, 22853)[i], "CallChecker.isCalled(residuals, double[].class, 549, 22845, 22853)[i]", 549, 22845, 22889);
                        }
                    }
                }
            }
            return residuals;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2732.methodEnd();
        }
    }

    private RealMatrix squareRoot(RealMatrix m) {
        MethodContext _bcornu_methode_context2733 = new MethodContext(RealMatrix.class, 561, 22939, 23626);
        try {
            CallChecker.varInit(this, "this", 561, 22939, 23626);
            CallChecker.varInit(m, "m", 561, 22939, 23626);
            CallChecker.varInit(this.evaluations, "evaluations", 561, 22939, 23626);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 561, 22939, 23626);
            CallChecker.varInit(this.jacobianEvaluations, "jacobianEvaluations", 561, 22939, 23626);
            CallChecker.varInit(this.jF, "jF", 561, 22939, 23626);
            CallChecker.varInit(this.cost, "cost", 561, 22939, 23626);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 561, 22939, 23626);
            CallChecker.varInit(this.objective, "objective", 561, 22939, 23626);
            CallChecker.varInit(this.point, "point", 561, 22939, 23626);
            CallChecker.varInit(this.rows, "rows", 561, 22939, 23626);
            CallChecker.varInit(this.cols, "cols", 561, 22939, 23626);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 561, 22939, 23626);
            CallChecker.varInit(DEFAULT_SINGULARITY_THRESHOLD, "org.apache.commons.math3.optimization.general.AbstractLeastSquaresOptimizer.DEFAULT_SINGULARITY_THRESHOLD", 561, 22939, 23626);
            if (m instanceof DiagonalMatrix) {
                m = CallChecker.beforeCalled(m, RealMatrix.class, 563, 23248, 23248);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 563, 23248, 23248).getRowDimension())), "dim", 563, 23232, 23267);
                final RealMatrix sqrtM = CallChecker.varInit(new DiagonalMatrix(dim), "sqrtM", 564, 23281, 23329);
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 566, 23425, 23425)) {
                        if (CallChecker.beforeDeref(sqrtM, RealMatrix.class, 566, 23390, 23394)) {
                            m = CallChecker.beforeCalled(m, RealMatrix.class, 566, 23425, 23425);
                            CallChecker.isCalled(sqrtM, RealMatrix.class, 566, 23390, 23394).setEntry(i, i, FastMath.sqrt(CallChecker.isCalled(m, RealMatrix.class, 566, 23425, 23425).getEntry(i, i)));
                        }
                    }
                }
                return sqrtM;
            }else {
                final EigenDecomposition dec = CallChecker.varInit(new EigenDecomposition(m), "dec", 570, 23514, 23570);
                if (CallChecker.beforeDeref(dec, EigenDecomposition.class, 571, 23591, 23593)) {
                    return CallChecker.isCalled(dec, EigenDecomposition.class, 571, 23591, 23593).getSquareRoot();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2733.methodEnd();
        }
    }
}

