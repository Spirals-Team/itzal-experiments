package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.Incrementor;

@Deprecated
public abstract class BaseAbstractUnivariateOptimizer implements UnivariateOptimizer {
    private final ConvergenceChecker<UnivariatePointValuePair> checker;

    private final Incrementor evaluations = new Incrementor();

    private GoalType goal;

    private double searchMin;

    private double searchMax;

    private double searchStart;

    private UnivariateFunction function;

    protected BaseAbstractUnivariateOptimizer(ConvergenceChecker<UnivariatePointValuePair> checker) {
        ConstructorContext _bcornu_methode_context1003 = new ConstructorContext(BaseAbstractUnivariateOptimizer.class, 57, 2121, 2325);
        try {
            this.checker = checker;
            CallChecker.varAssign(this.checker, "this.checker", 58, 2297, 2319);
        } finally {
            _bcornu_methode_context1003.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context4442 = new MethodContext(int.class, 62, 2332, 2440);
        try {
            CallChecker.varInit(this, "this", 62, 2332, 2440);
            CallChecker.varInit(this.function, "function", 62, 2332, 2440);
            CallChecker.varInit(this.searchStart, "searchStart", 62, 2332, 2440);
            CallChecker.varInit(this.searchMax, "searchMax", 62, 2332, 2440);
            CallChecker.varInit(this.searchMin, "searchMin", 62, 2332, 2440);
            CallChecker.varInit(this.goal, "goal", 62, 2332, 2440);
            CallChecker.varInit(this.evaluations, "evaluations", 62, 2332, 2440);
            CallChecker.varInit(this.checker, "checker", 62, 2332, 2440);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 63, 2405, 2415)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 63, 2405, 2415).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4442.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context4443 = new MethodContext(int.class, 67, 2447, 2545);
        try {
            CallChecker.varInit(this, "this", 67, 2447, 2545);
            CallChecker.varInit(this.function, "function", 67, 2447, 2545);
            CallChecker.varInit(this.searchStart, "searchStart", 67, 2447, 2545);
            CallChecker.varInit(this.searchMax, "searchMax", 67, 2447, 2545);
            CallChecker.varInit(this.searchMin, "searchMin", 67, 2447, 2545);
            CallChecker.varInit(this.goal, "goal", 67, 2447, 2545);
            CallChecker.varInit(this.evaluations, "evaluations", 67, 2447, 2545);
            CallChecker.varInit(this.checker, "checker", 67, 2447, 2545);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 68, 2517, 2527)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 68, 2517, 2527).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4443.methodEnd();
        }
    }

    public GoalType getGoalType() {
        MethodContext _bcornu_methode_context4444 = new MethodContext(GoalType.class, 74, 2552, 2663);
        try {
            CallChecker.varInit(this, "this", 74, 2552, 2663);
            CallChecker.varInit(this.function, "function", 74, 2552, 2663);
            CallChecker.varInit(this.searchStart, "searchStart", 74, 2552, 2663);
            CallChecker.varInit(this.searchMax, "searchMax", 74, 2552, 2663);
            CallChecker.varInit(this.searchMin, "searchMin", 74, 2552, 2663);
            CallChecker.varInit(this.goal, "goal", 74, 2552, 2663);
            CallChecker.varInit(this.evaluations, "evaluations", 74, 2552, 2663);
            CallChecker.varInit(this.checker, "checker", 74, 2552, 2663);
            return goal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GoalType) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4444.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context4445 = new MethodContext(double.class, 80, 2669, 2793);
        try {
            CallChecker.varInit(this, "this", 80, 2669, 2793);
            CallChecker.varInit(this.function, "function", 80, 2669, 2793);
            CallChecker.varInit(this.searchStart, "searchStart", 80, 2669, 2793);
            CallChecker.varInit(this.searchMax, "searchMax", 80, 2669, 2793);
            CallChecker.varInit(this.searchMin, "searchMin", 80, 2669, 2793);
            CallChecker.varInit(this.goal, "goal", 80, 2669, 2793);
            CallChecker.varInit(this.evaluations, "evaluations", 80, 2669, 2793);
            CallChecker.varInit(this.checker, "checker", 80, 2669, 2793);
            return searchMin;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4445.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context4446 = new MethodContext(double.class, 86, 2799, 2924);
        try {
            CallChecker.varInit(this, "this", 86, 2799, 2924);
            CallChecker.varInit(this.function, "function", 86, 2799, 2924);
            CallChecker.varInit(this.searchStart, "searchStart", 86, 2799, 2924);
            CallChecker.varInit(this.searchMax, "searchMax", 86, 2799, 2924);
            CallChecker.varInit(this.searchMin, "searchMin", 86, 2799, 2924);
            CallChecker.varInit(this.goal, "goal", 86, 2799, 2924);
            CallChecker.varInit(this.evaluations, "evaluations", 86, 2799, 2924);
            CallChecker.varInit(this.checker, "checker", 86, 2799, 2924);
            return searchMax;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4446.methodEnd();
        }
    }

    public double getStartValue() {
        MethodContext _bcornu_methode_context4447 = new MethodContext(double.class, 92, 2930, 3044);
        try {
            CallChecker.varInit(this, "this", 92, 2930, 3044);
            CallChecker.varInit(this.function, "function", 92, 2930, 3044);
            CallChecker.varInit(this.searchStart, "searchStart", 92, 2930, 3044);
            CallChecker.varInit(this.searchMax, "searchMax", 92, 2930, 3044);
            CallChecker.varInit(this.searchMin, "searchMin", 92, 2930, 3044);
            CallChecker.varInit(this.goal, "goal", 92, 2930, 3044);
            CallChecker.varInit(this.evaluations, "evaluations", 92, 2930, 3044);
            CallChecker.varInit(this.checker, "checker", 92, 2930, 3044);
            return searchStart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4447.methodEnd();
        }
    }

    protected double computeObjectiveValue(double point) {
        MethodContext _bcornu_methode_context4448 = new MethodContext(double.class, 104, 3051, 3634);
        try {
            CallChecker.varInit(this, "this", 104, 3051, 3634);
            CallChecker.varInit(point, "point", 104, 3051, 3634);
            CallChecker.varInit(this.function, "function", 104, 3051, 3634);
            CallChecker.varInit(this.searchStart, "searchStart", 104, 3051, 3634);
            CallChecker.varInit(this.searchMax, "searchMax", 104, 3051, 3634);
            CallChecker.varInit(this.searchMin, "searchMin", 104, 3051, 3634);
            CallChecker.varInit(this.goal, "goal", 104, 3051, 3634);
            CallChecker.varInit(this.evaluations, "evaluations", 104, 3051, 3634);
            CallChecker.varInit(this.checker, "checker", 104, 3051, 3634);
            TryContext _bcornu_try_context_94 = new TryContext(94, BaseAbstractUnivariateOptimizer.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 106, 3441, 3451)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 106, 3441, 3451).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_94.catchStart(94);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_94.finallyStart(94);
            }
            if (CallChecker.beforeDeref(function, UnivariateFunction.class, 110, 3607, 3614)) {
                function = CallChecker.beforeCalled(function, UnivariateFunction.class, 110, 3607, 3614);
                return CallChecker.isCalled(function, UnivariateFunction.class, 110, 3607, 3614).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4448.methodEnd();
        }
    }

    public UnivariatePointValuePair optimize(int maxEval, UnivariateFunction f, GoalType goalType, double min, double max, double startValue) {
        MethodContext _bcornu_methode_context4449 = new MethodContext(UnivariatePointValuePair.class, 114, 3641, 4427);
        try {
            CallChecker.varInit(this, "this", 114, 3641, 4427);
            CallChecker.varInit(startValue, "startValue", 114, 3641, 4427);
            CallChecker.varInit(max, "max", 114, 3641, 4427);
            CallChecker.varInit(min, "min", 114, 3641, 4427);
            CallChecker.varInit(goalType, "goalType", 114, 3641, 4427);
            CallChecker.varInit(f, "f", 114, 3641, 4427);
            CallChecker.varInit(maxEval, "maxEval", 114, 3641, 4427);
            CallChecker.varInit(this.function, "function", 114, 3641, 4427);
            CallChecker.varInit(this.searchStart, "searchStart", 114, 3641, 4427);
            CallChecker.varInit(this.searchMax, "searchMax", 114, 3641, 4427);
            CallChecker.varInit(this.searchMin, "searchMin", 114, 3641, 4427);
            CallChecker.varInit(this.goal, "goal", 114, 3641, 4427);
            CallChecker.varInit(this.evaluations, "evaluations", 114, 3641, 4427);
            CallChecker.varInit(this.checker, "checker", 114, 3641, 4427);
            if (f == null) {
                throw new NullArgumentException();
            }
            if (goalType == null) {
                throw new NullArgumentException();
            }
            searchMin = min;
            CallChecker.varAssign(this.searchMin, "this.searchMin", 127, 4158, 4173);
            searchMax = max;
            CallChecker.varAssign(this.searchMax, "this.searchMax", 128, 4183, 4198);
            searchStart = startValue;
            CallChecker.varAssign(this.searchStart, "this.searchStart", 129, 4208, 4232);
            goal = goalType;
            CallChecker.varAssign(this.goal, "this.goal", 130, 4242, 4257);
            function = f;
            CallChecker.varAssign(this.function, "this.function", 131, 4267, 4279);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 132, 4289, 4299)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 132, 4289, 4299).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 133, 4335, 4345)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 133, 4335, 4345).resetCount();
            }
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4449.methodEnd();
        }
    }

    public UnivariatePointValuePair optimize(int maxEval, UnivariateFunction f, GoalType goalType, double min, double max) {
        MethodContext _bcornu_methode_context4450 = new MethodContext(UnivariatePointValuePair.class, 140, 4434, 4800);
        try {
            CallChecker.varInit(this, "this", 140, 4434, 4800);
            CallChecker.varInit(max, "max", 140, 4434, 4800);
            CallChecker.varInit(min, "min", 140, 4434, 4800);
            CallChecker.varInit(goalType, "goalType", 140, 4434, 4800);
            CallChecker.varInit(f, "f", 140, 4434, 4800);
            CallChecker.varInit(maxEval, "maxEval", 140, 4434, 4800);
            CallChecker.varInit(this.function, "function", 140, 4434, 4800);
            CallChecker.varInit(this.searchStart, "searchStart", 140, 4434, 4800);
            CallChecker.varInit(this.searchMax, "searchMax", 140, 4434, 4800);
            CallChecker.varInit(this.searchMin, "searchMin", 140, 4434, 4800);
            CallChecker.varInit(this.goal, "goal", 140, 4434, 4800);
            CallChecker.varInit(this.evaluations, "evaluations", 140, 4434, 4800);
            CallChecker.varInit(this.checker, "checker", 140, 4434, 4800);
            return optimize(maxEval, f, goalType, min, max, (min + (0.5 * (max - min))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4450.methodEnd();
        }
    }

    public ConvergenceChecker<UnivariatePointValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context4451 = new MethodContext(ConvergenceChecker.class, 150, 4807, 4950);
        try {
            CallChecker.varInit(this, "this", 150, 4807, 4950);
            CallChecker.varInit(this.function, "function", 150, 4807, 4950);
            CallChecker.varInit(this.searchStart, "searchStart", 150, 4807, 4950);
            CallChecker.varInit(this.searchMax, "searchMax", 150, 4807, 4950);
            CallChecker.varInit(this.searchMin, "searchMin", 150, 4807, 4950);
            CallChecker.varInit(this.goal, "goal", 150, 4807, 4950);
            CallChecker.varInit(this.evaluations, "evaluations", 150, 4807, 4950);
            CallChecker.varInit(this.checker, "checker", 150, 4807, 4950);
            return checker;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<UnivariatePointValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4451.methodEnd();
        }
    }

    protected abstract UnivariatePointValuePair doOptimize();
}

