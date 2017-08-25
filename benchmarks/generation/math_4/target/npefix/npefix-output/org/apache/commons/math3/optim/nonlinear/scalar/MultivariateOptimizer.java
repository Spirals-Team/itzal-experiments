package org.apache.commons.math3.optim.nonlinear.scalar;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.BaseMultivariateOptimizer;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

public abstract class MultivariateOptimizer extends BaseMultivariateOptimizer<PointValuePair> {
    private MultivariateFunction function;

    private GoalType goal;

    protected MultivariateOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context861 = new ConstructorContext(MultivariateOptimizer.class, 42, 1570, 1735);
        try {
        } finally {
            _bcornu_methode_context861.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context3799 = new MethodContext(PointValuePair.class, 61, 1742, 2473);
        try {
            CallChecker.varInit(this, "this", 61, 1742, 2473);
            CallChecker.varInit(optData, "optData", 61, 1742, 2473);
            CallChecker.varInit(this.iterations, "iterations", 61, 1742, 2473);
            CallChecker.varInit(this.evaluations, "evaluations", 61, 1742, 2473);
            CallChecker.varInit(this.goal, "goal", 61, 1742, 2473);
            CallChecker.varInit(this.function, "function", 61, 1742, 2473);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3799.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context3800 = new MethodContext(void.class, 79, 2480, 3458);
        try {
            CallChecker.varInit(this, "this", 79, 2480, 3458);
            CallChecker.varInit(optData, "optData", 79, 2480, 3458);
            CallChecker.varInit(this.iterations, "iterations", 79, 2480, 3458);
            CallChecker.varInit(this.evaluations, "evaluations", 79, 2480, 3458);
            CallChecker.varInit(this.goal, "goal", 79, 2480, 3458);
            CallChecker.varInit(this.function, "function", 79, 2480, 3458);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 85, 3138, 3144)) {
                for (OptimizationData data : optData) {
                    if (data instanceof GoalType) {
                        goal = ((GoalType) (data));
                        CallChecker.varAssign(this.goal, "this.goal", 87, 3209, 3231);
                        continue;
                    }
                    if (data instanceof ObjectiveFunction) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 91, 3374, 3377)) {
                            function = CallChecker.isCalled(((ObjectiveFunction) (data)), ObjectiveFunction.class, 91, 3374, 3377).getObjectiveFunction();
                            CallChecker.varAssign(this.function, "this.function", 91, 3342, 3402);
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3800.methodEnd();
        }
    }

    public GoalType getGoalType() {
        MethodContext _bcornu_methode_context3801 = new MethodContext(GoalType.class, 100, 3465, 3576);
        try {
            CallChecker.varInit(this, "this", 100, 3465, 3576);
            CallChecker.varInit(this.iterations, "iterations", 100, 3465, 3576);
            CallChecker.varInit(this.evaluations, "evaluations", 100, 3465, 3576);
            CallChecker.varInit(this.goal, "goal", 100, 3465, 3576);
            CallChecker.varInit(this.function, "function", 100, 3465, 3576);
            return goal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GoalType) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3801.methodEnd();
        }
    }

    protected double computeObjectiveValue(double[] params) {
        MethodContext _bcornu_methode_context3802 = new MethodContext(double.class, 114, 3583, 4146);
        try {
            CallChecker.varInit(this, "this", 114, 3583, 4146);
            CallChecker.varInit(params, "params", 114, 3583, 4146);
            CallChecker.varInit(this.iterations, "iterations", 114, 3583, 4146);
            CallChecker.varInit(this.evaluations, "evaluations", 114, 3583, 4146);
            CallChecker.varInit(this.goal, "goal", 114, 3583, 4146);
            CallChecker.varInit(this.function, "function", 114, 3583, 4146);
            super.incrementEvaluationCount();
            if (CallChecker.beforeDeref(function, MultivariateFunction.class, 116, 4118, 4125)) {
                function = CallChecker.beforeCalled(function, MultivariateFunction.class, 116, 4118, 4125);
                return CallChecker.isCalled(function, MultivariateFunction.class, 116, 4118, 4125).value(params);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3802.methodEnd();
        }
    }
}

