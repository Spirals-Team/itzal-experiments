package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

public abstract class UnivariateOptimizer extends BaseOptimizer<UnivariatePointValuePair> {
    private UnivariateFunction function;

    private GoalType goal;

    private double start;

    private double min;

    private double max;

    protected UnivariateOptimizer(ConvergenceChecker<UnivariatePointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context104 = new ConstructorContext(UnivariateOptimizer.class, 48, 1701, 1874);
        try {
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    public UnivariatePointValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context377 = new MethodContext(UnivariatePointValuePair.class, 67, 1881, 2612);
        try {
            CallChecker.varInit(this, "this", 67, 1881, 2612);
            CallChecker.varInit(optData, "optData", 67, 1881, 2612);
            CallChecker.varInit(this.iterations, "iterations", 67, 1881, 2612);
            CallChecker.varInit(this.evaluations, "evaluations", 67, 1881, 2612);
            CallChecker.varInit(this.max, "max", 67, 1881, 2612);
            CallChecker.varInit(this.min, "min", 67, 1881, 2612);
            CallChecker.varInit(this.start, "start", 67, 1881, 2612);
            CallChecker.varInit(this.goal, "goal", 67, 1881, 2612);
            CallChecker.varInit(this.function, "function", 67, 1881, 2612);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context377.methodEnd();
        }
    }

    public GoalType getGoalType() {
        MethodContext _bcornu_methode_context378 = new MethodContext(GoalType.class, 76, 2619, 2730);
        try {
            CallChecker.varInit(this, "this", 76, 2619, 2730);
            CallChecker.varInit(this.iterations, "iterations", 76, 2619, 2730);
            CallChecker.varInit(this.evaluations, "evaluations", 76, 2619, 2730);
            CallChecker.varInit(this.max, "max", 76, 2619, 2730);
            CallChecker.varInit(this.min, "min", 76, 2619, 2730);
            CallChecker.varInit(this.start, "start", 76, 2619, 2730);
            CallChecker.varInit(this.goal, "goal", 76, 2619, 2730);
            CallChecker.varInit(this.function, "function", 76, 2619, 2730);
            return goal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GoalType) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context378.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context379 = new MethodContext(void.class, 93, 2737, 4078);
        try {
            CallChecker.varInit(this, "this", 93, 2737, 4078);
            CallChecker.varInit(optData, "optData", 93, 2737, 4078);
            CallChecker.varInit(this.iterations, "iterations", 93, 2737, 4078);
            CallChecker.varInit(this.evaluations, "evaluations", 93, 2737, 4078);
            CallChecker.varInit(this.max, "max", 93, 2737, 4078);
            CallChecker.varInit(this.min, "min", 93, 2737, 4078);
            CallChecker.varInit(this.start, "start", 93, 2737, 4078);
            CallChecker.varInit(this.goal, "goal", 93, 2737, 4078);
            CallChecker.varInit(this.function, "function", 93, 2737, 4078);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 99, 3445, 3451)) {
                for (OptimizationData data : optData) {
                    if (data instanceof SearchInterval) {
                        final SearchInterval interval = CallChecker.varInit(((SearchInterval) (data)), "interval", 101, 3522, 3575);
                        if (CallChecker.beforeDeref(interval, SearchInterval.class, 102, 3599, 3606)) {
                            min = CallChecker.isCalled(interval, SearchInterval.class, 102, 3599, 3606).getMin();
                            CallChecker.varAssign(this.min, "this.min", 102, 3593, 3616);
                        }
                        if (CallChecker.beforeDeref(interval, SearchInterval.class, 103, 3640, 3647)) {
                            max = CallChecker.isCalled(interval, SearchInterval.class, 103, 3640, 3647).getMax();
                            CallChecker.varAssign(this.max, "this.max", 103, 3634, 3657);
                        }
                        if (CallChecker.beforeDeref(interval, SearchInterval.class, 104, 3683, 3690)) {
                            start = CallChecker.isCalled(interval, SearchInterval.class, 104, 3683, 3690).getStartValue();
                            CallChecker.varAssign(this.start, "this.start", 104, 3675, 3707);
                        }
                        continue;
                    }
                    if (data instanceof UnivariateObjectiveFunction) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 108, 3870, 3873)) {
                            function = CallChecker.isCalled(((UnivariateObjectiveFunction) (data)), UnivariateObjectiveFunction.class, 108, 3870, 3873).getObjectiveFunction();
                            CallChecker.varAssign(this.function, "this.function", 108, 3828, 3898);
                        }
                        continue;
                    }
                    if (data instanceof GoalType) {
                        goal = ((GoalType) (data));
                        CallChecker.varAssign(this.goal, "this.goal", 112, 4000, 4022);
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context379.methodEnd();
        }
    }

    public double getStartValue() {
        MethodContext _bcornu_methode_context380 = new MethodContext(double.class, 121, 4085, 4193);
        try {
            CallChecker.varInit(this, "this", 121, 4085, 4193);
            CallChecker.varInit(this.iterations, "iterations", 121, 4085, 4193);
            CallChecker.varInit(this.evaluations, "evaluations", 121, 4085, 4193);
            CallChecker.varInit(this.max, "max", 121, 4085, 4193);
            CallChecker.varInit(this.min, "min", 121, 4085, 4193);
            CallChecker.varInit(this.start, "start", 121, 4085, 4193);
            CallChecker.varInit(this.goal, "goal", 121, 4085, 4193);
            CallChecker.varInit(this.function, "function", 121, 4085, 4193);
            return start;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context380.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context381 = new MethodContext(double.class, 127, 4199, 4297);
        try {
            CallChecker.varInit(this, "this", 127, 4199, 4297);
            CallChecker.varInit(this.iterations, "iterations", 127, 4199, 4297);
            CallChecker.varInit(this.evaluations, "evaluations", 127, 4199, 4297);
            CallChecker.varInit(this.max, "max", 127, 4199, 4297);
            CallChecker.varInit(this.min, "min", 127, 4199, 4297);
            CallChecker.varInit(this.start, "start", 127, 4199, 4297);
            CallChecker.varInit(this.goal, "goal", 127, 4199, 4297);
            CallChecker.varInit(this.function, "function", 127, 4199, 4297);
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context381.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context382 = new MethodContext(double.class, 133, 4303, 4401);
        try {
            CallChecker.varInit(this, "this", 133, 4303, 4401);
            CallChecker.varInit(this.iterations, "iterations", 133, 4303, 4401);
            CallChecker.varInit(this.evaluations, "evaluations", 133, 4303, 4401);
            CallChecker.varInit(this.max, "max", 133, 4303, 4401);
            CallChecker.varInit(this.min, "min", 133, 4303, 4401);
            CallChecker.varInit(this.start, "start", 133, 4303, 4401);
            CallChecker.varInit(this.goal, "goal", 133, 4303, 4401);
            CallChecker.varInit(this.function, "function", 133, 4303, 4401);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context382.methodEnd();
        }
    }

    protected double computeObjectiveValue(double x) {
        MethodContext _bcornu_methode_context383 = new MethodContext(double.class, 147, 4408, 4954);
        try {
            CallChecker.varInit(this, "this", 147, 4408, 4954);
            CallChecker.varInit(x, "x", 147, 4408, 4954);
            CallChecker.varInit(this.iterations, "iterations", 147, 4408, 4954);
            CallChecker.varInit(this.evaluations, "evaluations", 147, 4408, 4954);
            CallChecker.varInit(this.max, "max", 147, 4408, 4954);
            CallChecker.varInit(this.min, "min", 147, 4408, 4954);
            CallChecker.varInit(this.start, "start", 147, 4408, 4954);
            CallChecker.varInit(this.goal, "goal", 147, 4408, 4954);
            CallChecker.varInit(this.function, "function", 147, 4408, 4954);
            super.incrementEvaluationCount();
            if (CallChecker.beforeDeref(function, UnivariateFunction.class, 149, 4931, 4938)) {
                function = CallChecker.beforeCalled(function, UnivariateFunction.class, 149, 4931, 4938);
                return CallChecker.isCalled(function, UnivariateFunction.class, 149, 4931, 4938).value(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context383.methodEnd();
        }
    }
}

