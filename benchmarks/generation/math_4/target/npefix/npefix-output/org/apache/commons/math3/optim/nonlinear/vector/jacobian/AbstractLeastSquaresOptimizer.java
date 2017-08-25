package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.optim.nonlinear.vector.JacobianMultivariateVectorOptimizer;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;
import org.apache.commons.math3.util.FastMath;

public abstract class AbstractLeastSquaresOptimizer extends JacobianMultivariateVectorOptimizer {
    private RealMatrix weightMatrixSqrt;

    private double cost;

    protected AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context603 = new ConstructorContext(AbstractLeastSquaresOptimizer.class, 52, 2204, 2383);
        try {
        } finally {
            _bcornu_methode_context603.methodEnd();
        }
    }

    protected RealMatrix computeWeightedJacobian(double[] params) {
        MethodContext _bcornu_methode_context2734 = new MethodContext(RealMatrix.class, 64, 2390, 2862);
        try {
            CallChecker.varInit(this, "this", 64, 2390, 2862);
            CallChecker.varInit(params, "params", 64, 2390, 2862);
            CallChecker.varInit(this.iterations, "iterations", 64, 2390, 2862);
            CallChecker.varInit(this.evaluations, "evaluations", 64, 2390, 2862);
            CallChecker.varInit(this.cost, "cost", 64, 2390, 2862);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 64, 2390, 2862);
            if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 65, 2776, 2791)) {
                weightMatrixSqrt = CallChecker.beforeCalled(weightMatrixSqrt, RealMatrix.class, 65, 2776, 2791);
                return CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 65, 2776, 2791).multiply(MatrixUtils.createRealMatrix(computeJacobian(params)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2734.methodEnd();
        }
    }

    protected double computeCost(double[] residuals) {
        MethodContext _bcornu_methode_context2735 = new MethodContext(double.class, 75, 2869, 3207);
        try {
            CallChecker.varInit(this, "this", 75, 2869, 3207);
            CallChecker.varInit(residuals, "residuals", 75, 2869, 3207);
            CallChecker.varInit(this.iterations, "iterations", 75, 2869, 3207);
            CallChecker.varInit(this.evaluations, "evaluations", 75, 2869, 3207);
            CallChecker.varInit(this.cost, "cost", 75, 2869, 3207);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 75, 2869, 3207);
            final ArrayRealVector r = CallChecker.varInit(new ArrayRealVector(residuals), "r", 76, 3077, 3133);
            final RealMatrix npe_invocation_var694 = getWeight();
            if (CallChecker.beforeDeref(npe_invocation_var694, RealMatrix.class, 77, 3177, 3187)) {
                if (CallChecker.beforeDeref(r, ArrayRealVector.class, 77, 3164, 3164)) {
                    return FastMath.sqrt(CallChecker.isCalled(r, ArrayRealVector.class, 77, 3164, 3164).dotProduct(CallChecker.isCalled(npe_invocation_var694, RealMatrix.class, 77, 3177, 3187).operate(r)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2735.methodEnd();
        }
    }

    public double getRMS() {
        MethodContext _bcornu_methode_context2736 = new MethodContext(double.class, 91, 3214, 3724);
        try {
            CallChecker.varInit(this, "this", 91, 3214, 3724);
            CallChecker.varInit(this.iterations, "iterations", 91, 3214, 3724);
            CallChecker.varInit(this.evaluations, "evaluations", 91, 3214, 3724);
            CallChecker.varInit(this.cost, "cost", 91, 3214, 3724);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 91, 3214, 3724);
            return FastMath.sqrt(((getChiSquare()) / (getTargetSize())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2736.methodEnd();
        }
    }

    public double getChiSquare() {
        MethodContext _bcornu_methode_context2737 = new MethodContext(double.class, 101, 3731, 4024);
        try {
            CallChecker.varInit(this, "this", 101, 3731, 4024);
            CallChecker.varInit(this.iterations, "iterations", 101, 3731, 4024);
            CallChecker.varInit(this.evaluations, "evaluations", 101, 3731, 4024);
            CallChecker.varInit(this.cost, "cost", 101, 3731, 4024);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 101, 3731, 4024);
            return (cost) * (cost);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2737.methodEnd();
        }
    }

    public RealMatrix getWeightSquareRoot() {
        MethodContext _bcornu_methode_context2738 = new MethodContext(RealMatrix.class, 110, 4031, 4243);
        try {
            CallChecker.varInit(this, "this", 110, 4031, 4243);
            CallChecker.varInit(this.iterations, "iterations", 110, 4031, 4243);
            CallChecker.varInit(this.evaluations, "evaluations", 110, 4031, 4243);
            CallChecker.varInit(this.cost, "cost", 110, 4031, 4243);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 110, 4031, 4243);
            if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 111, 4214, 4229)) {
                weightMatrixSqrt = CallChecker.beforeCalled(weightMatrixSqrt, RealMatrix.class, 111, 4214, 4229);
                return CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 111, 4214, 4229).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2738.methodEnd();
        }
    }

    protected void setCost(double cost) {
        MethodContext _bcornu_methode_context2739 = new MethodContext(void.class, 119, 4250, 4394);
        try {
            CallChecker.varInit(this, "this", 119, 4250, 4394);
            CallChecker.varInit(cost, "cost", 119, 4250, 4394);
            CallChecker.varInit(this.iterations, "iterations", 119, 4250, 4394);
            CallChecker.varInit(this.evaluations, "evaluations", 119, 4250, 4394);
            CallChecker.varInit(this.cost, "cost", 119, 4250, 4394);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 119, 4250, 4394);
            this.cost = cost;
            CallChecker.varAssign(this.cost, "this.cost", 120, 4372, 4388);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2739.methodEnd();
        }
    }

    public double[][] computeCovariances(double[] params, double threshold) {
        MethodContext _bcornu_methode_context2740 = new MethodContext(double[][].class, 139, 4401, 5606);
        try {
            CallChecker.varInit(this, "this", 139, 4401, 5606);
            CallChecker.varInit(threshold, "threshold", 139, 4401, 5606);
            CallChecker.varInit(params, "params", 139, 4401, 5606);
            CallChecker.varInit(this.iterations, "iterations", 139, 4401, 5606);
            CallChecker.varInit(this.evaluations, "evaluations", 139, 4401, 5606);
            CallChecker.varInit(this.cost, "cost", 139, 4401, 5606);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 139, 4401, 5606);
            final RealMatrix j = CallChecker.varInit(computeWeightedJacobian(params), "j", 142, 5229, 5313);
            final RealMatrix jTj = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(j, RealMatrix.class, 145, 5381, 5381).transpose(), RealMatrix.class, 145, 5381, 5393).multiply(j), "jTj", 145, 5324, 5406);
            final DecompositionSolver solver = CallChecker.varInit(CallChecker.isCalled(new QRDecomposition(jTj, threshold), QRDecomposition.class, 149, 5507, 5541).getSolver(), "solver", 148, 5417, 5554);
            if (CallChecker.beforeDeref(solver, DecompositionSolver.class, 150, 5571, 5576)) {
                final RealMatrix npe_invocation_var695 = CallChecker.isCalled(solver, DecompositionSolver.class, 150, 5571, 5576).getInverse();
                if (CallChecker.beforeDeref(npe_invocation_var695, RealMatrix.class, 150, 5571, 5589)) {
                    return CallChecker.isCalled(npe_invocation_var695, RealMatrix.class, 150, 5571, 5589).getData();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2740.methodEnd();
        }
    }

    public double[] computeSigma(double[] params, double covarianceSingularityThreshold) {
        MethodContext _bcornu_methode_context2741 = new MethodContext(double[].class, 167, 5613, 6782);
        try {
            CallChecker.varInit(this, "this", 167, 5613, 6782);
            CallChecker.varInit(covarianceSingularityThreshold, "covarianceSingularityThreshold", 167, 5613, 6782);
            CallChecker.varInit(params, "params", 167, 5613, 6782);
            CallChecker.varInit(this.iterations, "iterations", 167, 5613, 6782);
            CallChecker.varInit(this.evaluations, "evaluations", 167, 5613, 6782);
            CallChecker.varInit(this.cost, "cost", 167, 5613, 6782);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 167, 5613, 6782);
            params = CallChecker.beforeCalled(params, double[].class, 169, 6511, 6516);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(params, double[].class, 169, 6511, 6516).length)), "nC", 169, 6496, 6524);
            final double[] sig = CallChecker.varInit(new double[nC], "sig", 170, 6534, 6569);
            final double[][] cov = CallChecker.varInit(computeCovariances(params, covarianceSingularityThreshold), "cov", 171, 6579, 6660);
            for (int i = 0; i < nC; ++i) {
                if (CallChecker.beforeDeref(sig, double[].class, 173, 6713, 6715)) {
                    if (CallChecker.beforeDeref(cov, double[][].class, 173, 6736, 6738)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cov, double[][].class, 173, 6736, 6738)[i], double[].class, 173, 6736, 6741)) {
                            CallChecker.isCalled(cov, double[][].class, 173, 6736, 6738)[i] = CallChecker.beforeCalled(CallChecker.isCalled(cov, double[][].class, 173, 6736, 6738)[i], double[].class, 173, 6736, 6741);
                            CallChecker.isCalled(sig, double[].class, 173, 6713, 6715)[i] = FastMath.sqrt(CallChecker.isCalled(CallChecker.isCalled(cov, double[][].class, 173, 6736, 6738)[i], double[].class, 173, 6736, 6741)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(sig, double[].class, 173, 6713, 6715)[i], "CallChecker.isCalled(sig, double[].class, 173, 6713, 6715)[i]", 173, 6713, 6746);
                        }
                    }
                }
            }
            return sig;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2741.methodEnd();
        }
    }

    @Override
    public PointVectorValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2742 = new MethodContext(PointVectorValuePair.class, 194, 6789, 7679);
        try {
            CallChecker.varInit(this, "this", 194, 6789, 7679);
            CallChecker.varInit(optData, "optData", 194, 6789, 7679);
            CallChecker.varInit(this.iterations, "iterations", 194, 6789, 7679);
            CallChecker.varInit(this.evaluations, "evaluations", 194, 6789, 7679);
            CallChecker.varInit(this.cost, "cost", 194, 6789, 7679);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 194, 6789, 7679);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2742.methodEnd();
        }
    }

    protected double[] computeResiduals(double[] objectiveValue) {
        MethodContext _bcornu_methode_context2743 = new MethodContext(double[].class, 215, 7686, 8832);
        try {
            CallChecker.varInit(this, "this", 215, 7686, 8832);
            CallChecker.varInit(objectiveValue, "objectiveValue", 215, 7686, 8832);
            CallChecker.varInit(this.iterations, "iterations", 215, 7686, 8832);
            CallChecker.varInit(this.evaluations, "evaluations", 215, 7686, 8832);
            CallChecker.varInit(this.cost, "cost", 215, 7686, 8832);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 215, 7686, 8832);
            final double[] target = CallChecker.varInit(getTarget(), "target", 216, 8382, 8417);
            if (CallChecker.beforeDeref(objectiveValue, double[].class, 217, 8431, 8444)) {
                if (CallChecker.beforeDeref(target, double[].class, 217, 8456, 8461)) {
                    objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 217, 8431, 8444);
                    if ((CallChecker.isCalled(objectiveValue, double[].class, 217, 8431, 8444).length) != (CallChecker.isCalled(target, double[].class, 217, 8456, 8461).length)) {
                        if (CallChecker.beforeDeref(target, double[].class, 218, 8522, 8527)) {
                            if (CallChecker.beforeDeref(objectiveValue, double[].class, 219, 8586, 8599)) {
                                objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 219, 8586, 8599);
                                throw new DimensionMismatchException(CallChecker.isCalled(target, double[].class, 218, 8522, 8527).length, CallChecker.isCalled(objectiveValue, double[].class, 219, 8586, 8599).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] residuals = CallChecker.varInit(new double[CallChecker.isCalled(target, double[].class, 222, 8667, 8672).length], "residuals", 222, 8629, 8681);
            for (int i = 0; i < (CallChecker.isCalled(target, double[].class, 223, 8711, 8716).length); i++) {
                if (CallChecker.beforeDeref(residuals, double[].class, 224, 8745, 8753)) {
                    if (CallChecker.beforeDeref(target, double[].class, 224, 8760, 8765)) {
                        if (CallChecker.beforeDeref(objectiveValue, double[].class, 224, 8772, 8785)) {
                            objectiveValue = CallChecker.beforeCalled(objectiveValue, double[].class, 224, 8772, 8785);
                            CallChecker.isCalled(residuals, double[].class, 224, 8745, 8753)[i] = (CallChecker.isCalled(target, double[].class, 224, 8760, 8765)[i]) - (CallChecker.isCalled(objectiveValue, double[].class, 224, 8772, 8785)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(residuals, double[].class, 224, 8745, 8753)[i], "CallChecker.isCalled(residuals, double[].class, 224, 8745, 8753)[i]", 224, 8745, 8789);
                        }
                    }
                }
            }
            return residuals;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2743.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context2744 = new MethodContext(void.class, 242, 8839, 9840);
        try {
            CallChecker.varInit(this, "this", 242, 8839, 9840);
            CallChecker.varInit(optData, "optData", 242, 8839, 9840);
            CallChecker.varInit(this.iterations, "iterations", 242, 8839, 9840);
            CallChecker.varInit(this.evaluations, "evaluations", 242, 8839, 9840);
            CallChecker.varInit(this.cost, "cost", 242, 8839, 9840);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 242, 8839, 9840);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 248, 9545, 9551)) {
                for (OptimizationData data : optData) {
                    if (data instanceof Weight) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 250, 9654, 9657)) {
                            weightMatrixSqrt = squareRoot(CallChecker.isCalled(((Weight) (data)), Weight.class, 250, 9654, 9657).getWeight());
                            CallChecker.varAssign(this.weightMatrixSqrt, "this.weightMatrixSqrt", 250, 9614, 9672);
                        }
                        break;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2744.methodEnd();
        }
    }

    private RealMatrix squareRoot(RealMatrix m) {
        MethodContext _bcornu_methode_context2745 = new MethodContext(RealMatrix.class, 264, 9847, 10535);
        try {
            CallChecker.varInit(this, "this", 264, 9847, 10535);
            CallChecker.varInit(m, "m", 264, 9847, 10535);
            CallChecker.varInit(this.iterations, "iterations", 264, 9847, 10535);
            CallChecker.varInit(this.evaluations, "evaluations", 264, 9847, 10535);
            CallChecker.varInit(this.cost, "cost", 264, 9847, 10535);
            CallChecker.varInit(this.weightMatrixSqrt, "weightMatrixSqrt", 264, 9847, 10535);
            if (m instanceof DiagonalMatrix) {
                m = CallChecker.beforeCalled(m, RealMatrix.class, 266, 10156, 10156);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 266, 10156, 10156).getRowDimension())), "dim", 266, 10140, 10175);
                final RealMatrix sqrtM = CallChecker.varInit(new DiagonalMatrix(dim), "sqrtM", 267, 10189, 10237);
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 269, 10334, 10334)) {
                        if (CallChecker.beforeDeref(sqrtM, RealMatrix.class, 269, 10299, 10303)) {
                            m = CallChecker.beforeCalled(m, RealMatrix.class, 269, 10334, 10334);
                            CallChecker.isCalled(sqrtM, RealMatrix.class, 269, 10299, 10303).setEntry(i, i, FastMath.sqrt(CallChecker.isCalled(m, RealMatrix.class, 269, 10334, 10334).getEntry(i, i)));
                        }
                    }
                }
                return sqrtM;
            }else {
                final EigenDecomposition dec = CallChecker.varInit(new EigenDecomposition(m), "dec", 273, 10423, 10479);
                if (CallChecker.beforeDeref(dec, EigenDecomposition.class, 274, 10500, 10502)) {
                    return CallChecker.isCalled(dec, EigenDecomposition.class, 274, 10500, 10502).getSquareRoot();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2745.methodEnd();
        }
    }
}

