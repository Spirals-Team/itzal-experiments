package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class GLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private RealMatrix Omega;

    private RealMatrix OmegaInverse;

    public void newSampleData(double[] y, double[][] x, double[][] covariance) {
        MethodContext _bcornu_methode_context5079 = new MethodContext(void.class, 56, 1654, 2122);
        try {
            CallChecker.varInit(this, "this", 56, 1654, 2122);
            CallChecker.varInit(covariance, "covariance", 56, 1654, 2122);
            CallChecker.varInit(x, "x", 56, 1654, 2122);
            CallChecker.varInit(y, "y", 56, 1654, 2122);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 56, 1654, 2122);
            CallChecker.varInit(this.Omega, "Omega", 56, 1654, 2122);
            validateSampleData(x, y);
            newYSampleData(y);
            newXSampleData(x);
            validateCovarianceData(x, covariance);
            newCovarianceData(covariance);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5079.methodEnd();
        }
    }

    protected void newCovarianceData(double[][] omega) {
        MethodContext _bcornu_methode_context5080 = new MethodContext(void.class, 69, 2129, 2392);
        try {
            CallChecker.varInit(this, "this", 69, 2129, 2392);
            CallChecker.varInit(omega, "omega", 69, 2129, 2392);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 69, 2129, 2392);
            CallChecker.varInit(this.Omega, "Omega", 69, 2129, 2392);
            this.Omega = new Array2DRowRealMatrix(omega);
            CallChecker.varAssign(this.Omega, "this.Omega", 70, 2308, 2352);
            this.OmegaInverse = null;
            CallChecker.varAssign(this.OmegaInverse, "this.OmegaInverse", 71, 2362, 2386);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5080.methodEnd();
        }
    }

    protected RealMatrix getOmegaInverse() {
        MethodContext _bcornu_methode_context5081 = new MethodContext(RealMatrix.class, 79, 2399, 2781);
        try {
            CallChecker.varInit(this, "this", 79, 2399, 2781);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 79, 2399, 2781);
            CallChecker.varInit(this.Omega, "Omega", 79, 2399, 2781);
            if ((OmegaInverse) == null) {
                if (CallChecker.beforeDeref(new LUDecomposition(Omega), LUDecomposition.class, 81, 2685, 2710)) {
                    final DecompositionSolver npe_invocation_var981 = CallChecker.isCalled(new LUDecomposition(Omega), LUDecomposition.class, 81, 2685, 2710).getSolver();
                    if (CallChecker.beforeDeref(npe_invocation_var981, DecompositionSolver.class, 81, 2685, 2722)) {
                        OmegaInverse = CallChecker.isCalled(npe_invocation_var981, DecompositionSolver.class, 81, 2685, 2722).getInverse();
                        CallChecker.varAssign(this.OmegaInverse, "this.OmegaInverse", 81, 2670, 2736);
                    }
                }
            }
            return OmegaInverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5081.methodEnd();
        }
    }

    @Override
    protected RealVector calculateBeta() {
        MethodContext _bcornu_methode_context5082 = new MethodContext(RealVector.class, 94, 2788, 3276);
        try {
            CallChecker.varInit(this, "this", 94, 2788, 3276);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 94, 2788, 3276);
            CallChecker.varInit(this.Omega, "Omega", 94, 2788, 3276);
            RealMatrix OI = CallChecker.varInit(getOmegaInverse(), "OI", 95, 2984, 3017);
            final RealMatrix npe_invocation_var982 = getX();
            RealMatrix XT = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(npe_invocation_var982, RealMatrix.class, 96, 3043, 3048)) {
                XT = CallChecker.isCalled(npe_invocation_var982, RealMatrix.class, 96, 3043, 3048).transpose();
                CallChecker.varAssign(XT, "XT", 96, 3043, 3048);
            }
            RealMatrix XTOIX = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(XT, RealMatrix.class, 97, 3090, 3091)) {
                XT = CallChecker.beforeCalled(XT, RealMatrix.class, 97, 3090, 3091);
                final RealMatrix npe_invocation_var983 = CallChecker.isCalled(XT, RealMatrix.class, 97, 3090, 3091).multiply(OI);
                if (CallChecker.beforeDeref(npe_invocation_var983, RealMatrix.class, 97, 3090, 3104)) {
                    XTOIX = CallChecker.isCalled(npe_invocation_var983, RealMatrix.class, 97, 3090, 3104).multiply(getX());
                    CallChecker.varAssign(XTOIX, "XTOIX", 97, 3090, 3091);
                }
            }
            RealMatrix inverse = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(new LUDecomposition(XTOIX), LUDecomposition.class, 98, 3153, 3178)) {
                final DecompositionSolver npe_invocation_var984 = CallChecker.isCalled(new LUDecomposition(XTOIX), LUDecomposition.class, 98, 3153, 3178).getSolver();
                if (CallChecker.beforeDeref(npe_invocation_var984, DecompositionSolver.class, 98, 3153, 3190)) {
                    inverse = CallChecker.isCalled(npe_invocation_var984, DecompositionSolver.class, 98, 3153, 3190).getInverse();
                    CallChecker.varAssign(inverse, "inverse", 98, 3153, 3178);
                }
            }
            if (CallChecker.beforeDeref(inverse, RealMatrix.class, 99, 3221, 3227)) {
                inverse = CallChecker.beforeCalled(inverse, RealMatrix.class, 99, 3221, 3227);
                final RealMatrix npe_invocation_var985 = CallChecker.isCalled(inverse, RealMatrix.class, 99, 3221, 3227).multiply(XT);
                if (CallChecker.beforeDeref(npe_invocation_var985, RealMatrix.class, 99, 3221, 3240)) {
                    final RealMatrix npe_invocation_var986 = CallChecker.isCalled(npe_invocation_var985, RealMatrix.class, 99, 3221, 3240).multiply(OI);
                    if (CallChecker.beforeDeref(npe_invocation_var986, RealMatrix.class, 99, 3221, 3253)) {
                        return CallChecker.isCalled(npe_invocation_var986, RealMatrix.class, 99, 3221, 3253).operate(getY());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5082.methodEnd();
        }
    }

    @Override
    protected RealMatrix calculateBetaVariance() {
        MethodContext _bcornu_methode_context5083 = new MethodContext(RealMatrix.class, 110, 3283, 3697);
        try {
            CallChecker.varInit(this, "this", 110, 3283, 3697);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 110, 3283, 3697);
            CallChecker.varInit(this.Omega, "Omega", 110, 3283, 3697);
            RealMatrix OI = CallChecker.varInit(getOmegaInverse(), "OI", 111, 3513, 3546);
            final RealMatrix npe_invocation_var987 = getX();
            RealMatrix XTOIX = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(npe_invocation_var987, RealMatrix.class, 112, 3575, 3580)) {
                final RealMatrix npe_invocation_var988 = CallChecker.isCalled(npe_invocation_var987, RealMatrix.class, 112, 3575, 3580).transpose();
                if (CallChecker.beforeDeref(npe_invocation_var988, RealMatrix.class, 112, 3575, 3592)) {
                    final RealMatrix npe_invocation_var989 = CallChecker.isCalled(npe_invocation_var988, RealMatrix.class, 112, 3575, 3592).multiply(OI);
                    if (CallChecker.beforeDeref(npe_invocation_var989, RealMatrix.class, 112, 3575, 3605)) {
                        XTOIX = CallChecker.isCalled(npe_invocation_var989, RealMatrix.class, 112, 3575, 3605).multiply(getX());
                        CallChecker.varAssign(XTOIX, "XTOIX", 112, 3575, 3580);
                    }
                }
            }
            if (CallChecker.beforeDeref(new LUDecomposition(XTOIX), LUDecomposition.class, 113, 3640, 3665)) {
                final DecompositionSolver npe_invocation_var990 = CallChecker.isCalled(new LUDecomposition(XTOIX), LUDecomposition.class, 113, 3640, 3665).getSolver();
                if (CallChecker.beforeDeref(npe_invocation_var990, DecompositionSolver.class, 113, 3640, 3677)) {
                    return CallChecker.isCalled(npe_invocation_var990, DecompositionSolver.class, 113, 3640, 3677).getInverse();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5083.methodEnd();
        }
    }

    @Override
    protected double calculateErrorVariance() {
        MethodContext _bcornu_methode_context5084 = new MethodContext(double.class, 129, 3705, 4279);
        try {
            CallChecker.varInit(this, "this", 129, 3705, 4279);
            CallChecker.varInit(this.OmegaInverse, "OmegaInverse", 129, 3705, 4279);
            CallChecker.varInit(this.Omega, "Omega", 129, 3705, 4279);
            RealVector residuals = CallChecker.varInit(calculateResiduals(), "residuals", 130, 4073, 4116);
            final RealMatrix npe_invocation_var991 = getOmegaInverse();
            double t = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(npe_invocation_var991, RealMatrix.class, 131, 4158, 4174)) {
                if (CallChecker.beforeDeref(residuals, RealVector.class, 131, 4137, 4145)) {
                    residuals = CallChecker.beforeCalled(residuals, RealVector.class, 131, 4137, 4145);
                    t = CallChecker.isCalled(residuals, RealVector.class, 131, 4137, 4145).dotProduct(CallChecker.isCalled(npe_invocation_var991, RealMatrix.class, 131, 4158, 4174).operate(residuals));
                    CallChecker.varAssign(t, "t", 131, 4158, 4174);
                }
            }
            return t / ((CallChecker.isCalled(getX(), RealMatrix.class, 132, 4217, 4222).getRowDimension()) - (CallChecker.isCalled(getX(), RealMatrix.class, 132, 4244, 4249).getColumnDimension()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5084.methodEnd();
        }
    }
}

