package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointVectorValuePair;

public abstract class JacobianMultivariateVectorOptimizer extends MultivariateVectorOptimizer {
    private MultivariateMatrixFunction jacobian;

    protected JacobianMultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context9 = new ConstructorContext(JacobianMultivariateVectorOptimizer.class, 49, 2003, 2188);
        try {
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    protected double[][] computeJacobian(final double[] params) {
        MethodContext _bcornu_methode_context50 = new MethodContext(double[][].class, 59, 2195, 2480);
        try {
            CallChecker.varInit(this, "this", 59, 2195, 2480);
            CallChecker.varInit(params, "params", 59, 2195, 2480);
            CallChecker.varInit(this.iterations, "iterations", 59, 2195, 2480);
            CallChecker.varInit(this.evaluations, "evaluations", 59, 2195, 2480);
            CallChecker.varInit(this.jacobian, "jacobian", 59, 2195, 2480);
            if (CallChecker.beforeDeref(jacobian, MultivariateMatrixFunction.class, 60, 2452, 2459)) {
                jacobian = CallChecker.beforeCalled(jacobian, MultivariateMatrixFunction.class, 60, 2452, 2459);
                return CallChecker.isCalled(jacobian, MultivariateMatrixFunction.class, 60, 2452, 2459).value(params);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    @Override
    public PointVectorValuePair optimize(OptimizationData... optData) throws DimensionMismatchException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context51 = new MethodContext(PointVectorValuePair.class, 79, 2487, 3354);
        try {
            CallChecker.varInit(this, "this", 79, 2487, 3354);
            CallChecker.varInit(optData, "optData", 79, 2487, 3354);
            CallChecker.varInit(this.iterations, "iterations", 79, 2487, 3354);
            CallChecker.varInit(this.evaluations, "evaluations", 79, 2487, 3354);
            CallChecker.varInit(this.jacobian, "jacobian", 79, 2487, 3354);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context52 = new MethodContext(void.class, 97, 3361, 4309);
        try {
            CallChecker.varInit(this, "this", 97, 3361, 4309);
            CallChecker.varInit(optData, "optData", 97, 3361, 4309);
            CallChecker.varInit(this.iterations, "iterations", 97, 3361, 4309);
            CallChecker.varInit(this.evaluations, "evaluations", 97, 3361, 4309);
            CallChecker.varInit(this.jacobian, "jacobian", 97, 3361, 4309);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 103, 3989, 3995)) {
                for (OptimizationData data : optData) {
                    if (data instanceof ModelFunctionJacobian) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 105, 4109, 4112)) {
                            jacobian = CallChecker.isCalled(((ModelFunctionJacobian) (data)), ModelFunctionJacobian.class, 105, 4109, 4112).getModelFunctionJacobian();
                            CallChecker.varAssign(this.jacobian, "this.jacobian", 105, 4073, 4141);
                        }
                        break;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }
}

