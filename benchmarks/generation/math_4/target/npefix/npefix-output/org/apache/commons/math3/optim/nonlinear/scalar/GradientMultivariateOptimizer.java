package org.apache.commons.math3.optim.nonlinear.scalar;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

public abstract class GradientMultivariateOptimizer extends MultivariateOptimizer {
    private MultivariateVectorFunction gradient;

    protected GradientMultivariateOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context942 = new ConstructorContext(GradientMultivariateOptimizer.class, 43, 1579, 1752);
        try {
        } finally {
            _bcornu_methode_context942.methodEnd();
        }
    }

    protected double[] computeObjectiveGradient(final double[] params) {
        MethodContext _bcornu_methode_context4252 = new MethodContext(double[].class, 53, 1759, 2050);
        try {
            CallChecker.varInit(this, "this", 53, 1759, 2050);
            CallChecker.varInit(params, "params", 53, 1759, 2050);
            CallChecker.varInit(this.iterations, "iterations", 53, 1759, 2050);
            CallChecker.varInit(this.evaluations, "evaluations", 53, 1759, 2050);
            CallChecker.varInit(this.gradient, "gradient", 53, 1759, 2050);
            if (CallChecker.beforeDeref(gradient, MultivariateVectorFunction.class, 54, 2022, 2029)) {
                gradient = CallChecker.beforeCalled(gradient, MultivariateVectorFunction.class, 54, 2022, 2029);
                return CallChecker.isCalled(gradient, MultivariateVectorFunction.class, 54, 2022, 2029).value(params);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4252.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4253 = new MethodContext(PointValuePair.class, 71, 2057, 2782);
        try {
            CallChecker.varInit(this, "this", 71, 2057, 2782);
            CallChecker.varInit(optData, "optData", 71, 2057, 2782);
            CallChecker.varInit(this.iterations, "iterations", 71, 2057, 2782);
            CallChecker.varInit(this.evaluations, "evaluations", 71, 2057, 2782);
            CallChecker.varInit(this.gradient, "gradient", 71, 2057, 2782);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4253.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context4254 = new MethodContext(void.class, 88, 2789, 3754);
        try {
            CallChecker.varInit(this, "this", 88, 2789, 3754);
            CallChecker.varInit(optData, "optData", 88, 2789, 3754);
            CallChecker.varInit(this.iterations, "iterations", 88, 2789, 3754);
            CallChecker.varInit(this.evaluations, "evaluations", 88, 2789, 3754);
            CallChecker.varInit(this.gradient, "gradient", 88, 2789, 3754);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 94, 3421, 3427)) {
                for (OptimizationData data : optData) {
                    if (data instanceof ObjectiveFunctionGradient) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 96, 3550, 3553)) {
                            gradient = CallChecker.isCalled(((ObjectiveFunctionGradient) (data)), ObjectiveFunctionGradient.class, 96, 3550, 3553).getObjectiveFunctionGradient();
                            CallChecker.varAssign(this.gradient, "this.gradient", 96, 3510, 3586);
                        }
                        break;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4254.methodEnd();
        }
    }
}

