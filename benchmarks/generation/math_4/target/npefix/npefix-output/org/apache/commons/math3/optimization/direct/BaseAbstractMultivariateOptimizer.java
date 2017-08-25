package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.util.Incrementor;

@Deprecated
public abstract class BaseAbstractMultivariateOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    protected final Incrementor evaluations = new Incrementor();

    private ConvergenceChecker<PointValuePair> checker;

    private GoalType goal;

    private double[] start;

    private double[] lowerBound;

    private double[] upperBound;

    private MultivariateFunction function;

    @Deprecated
    protected BaseAbstractMultivariateOptimizer() {
        this(new SimpleValueChecker());
        ConstructorContext _bcornu_methode_context512 = new ConstructorContext(BaseAbstractMultivariateOptimizer.class, 71, 2847, 3160);
        try {
        } finally {
            _bcornu_methode_context512.methodEnd();
        }
    }

    protected BaseAbstractMultivariateOptimizer(ConvergenceChecker<PointValuePair> checker) {
        ConstructorContext _bcornu_methode_context513 = new ConstructorContext(BaseAbstractMultivariateOptimizer.class, 77, 3166, 3351);
        try {
            this.checker = checker;
            CallChecker.varAssign(this.checker, "this.checker", 78, 3323, 3345);
        } finally {
            _bcornu_methode_context513.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context2389 = new MethodContext(int.class, 82, 3358, 3466);
        try {
            CallChecker.varInit(this, "this", 82, 3358, 3466);
            CallChecker.varInit(this.function, "function", 82, 3358, 3466);
            CallChecker.varInit(this.upperBound, "upperBound", 82, 3358, 3466);
            CallChecker.varInit(this.lowerBound, "lowerBound", 82, 3358, 3466);
            CallChecker.varInit(this.start, "start", 82, 3358, 3466);
            CallChecker.varInit(this.goal, "goal", 82, 3358, 3466);
            CallChecker.varInit(this.checker, "checker", 82, 3358, 3466);
            CallChecker.varInit(this.evaluations, "evaluations", 82, 3358, 3466);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 83, 3431, 3441)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 83, 3431, 3441).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2389.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context2390 = new MethodContext(int.class, 87, 3473, 3571);
        try {
            CallChecker.varInit(this, "this", 87, 3473, 3571);
            CallChecker.varInit(this.function, "function", 87, 3473, 3571);
            CallChecker.varInit(this.upperBound, "upperBound", 87, 3473, 3571);
            CallChecker.varInit(this.lowerBound, "lowerBound", 87, 3473, 3571);
            CallChecker.varInit(this.start, "start", 87, 3473, 3571);
            CallChecker.varInit(this.goal, "goal", 87, 3473, 3571);
            CallChecker.varInit(this.checker, "checker", 87, 3473, 3571);
            CallChecker.varInit(this.evaluations, "evaluations", 87, 3473, 3571);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 88, 3543, 3553)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 88, 3543, 3553).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2390.methodEnd();
        }
    }

    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context2391 = new MethodContext(ConvergenceChecker.class, 92, 3578, 3699);
        try {
            CallChecker.varInit(this, "this", 92, 3578, 3699);
            CallChecker.varInit(this.function, "function", 92, 3578, 3699);
            CallChecker.varInit(this.upperBound, "upperBound", 92, 3578, 3699);
            CallChecker.varInit(this.lowerBound, "lowerBound", 92, 3578, 3699);
            CallChecker.varInit(this.start, "start", 92, 3578, 3699);
            CallChecker.varInit(this.goal, "goal", 92, 3578, 3699);
            CallChecker.varInit(this.checker, "checker", 92, 3578, 3699);
            CallChecker.varInit(this.evaluations, "evaluations", 92, 3578, 3699);
            return checker;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<PointValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2391.methodEnd();
        }
    }

    protected double computeObjectiveValue(double[] point) {
        MethodContext _bcornu_methode_context2392 = new MethodContext(double.class, 104, 3706, 4295);
        try {
            CallChecker.varInit(this, "this", 104, 3706, 4295);
            CallChecker.varInit(point, "point", 104, 3706, 4295);
            CallChecker.varInit(this.function, "function", 104, 3706, 4295);
            CallChecker.varInit(this.upperBound, "upperBound", 104, 3706, 4295);
            CallChecker.varInit(this.lowerBound, "lowerBound", 104, 3706, 4295);
            CallChecker.varInit(this.start, "start", 104, 3706, 4295);
            CallChecker.varInit(this.goal, "goal", 104, 3706, 4295);
            CallChecker.varInit(this.checker, "checker", 104, 3706, 4295);
            CallChecker.varInit(this.evaluations, "evaluations", 104, 3706, 4295);
            TryContext _bcornu_try_context_41 = new TryContext(41, BaseAbstractMultivariateOptimizer.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 106, 4102, 4112)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 106, 4102, 4112).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_41.catchStart(41);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_41.finallyStart(41);
            }
            if (CallChecker.beforeDeref(function, MultivariateFunction.class, 110, 4268, 4275)) {
                function = CallChecker.beforeCalled(function, MultivariateFunction.class, 110, 4268, 4275);
                return CallChecker.isCalled(function, MultivariateFunction.class, 110, 4268, 4275).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2392.methodEnd();
        }
    }

    @Deprecated
    public PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double[] startPoint) {
        MethodContext _bcornu_methode_context2393 = new MethodContext(PointValuePair.class, 121, 4302, 4716);
        try {
            CallChecker.varInit(this, "this", 121, 4302, 4716);
            CallChecker.varInit(startPoint, "startPoint", 121, 4302, 4716);
            CallChecker.varInit(goalType, "goalType", 121, 4302, 4716);
            CallChecker.varInit(f, "f", 121, 4302, 4716);
            CallChecker.varInit(maxEval, "maxEval", 121, 4302, 4716);
            CallChecker.varInit(this.function, "function", 121, 4302, 4716);
            CallChecker.varInit(this.upperBound, "upperBound", 121, 4302, 4716);
            CallChecker.varInit(this.lowerBound, "lowerBound", 121, 4302, 4716);
            CallChecker.varInit(this.start, "start", 121, 4302, 4716);
            CallChecker.varInit(this.goal, "goal", 121, 4302, 4716);
            CallChecker.varInit(this.checker, "checker", 121, 4302, 4716);
            CallChecker.varInit(this.evaluations, "evaluations", 121, 4302, 4716);
            return optimizeInternal(maxEval, f, goalType, new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2393.methodEnd();
        }
    }

    public PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, OptimizationData... optData) {
        MethodContext _bcornu_methode_context2394 = new MethodContext(PointValuePair.class, 141, 4723, 5511);
        try {
            CallChecker.varInit(this, "this", 141, 4723, 5511);
            CallChecker.varInit(optData, "optData", 141, 4723, 5511);
            CallChecker.varInit(goalType, "goalType", 141, 4723, 5511);
            CallChecker.varInit(f, "f", 141, 4723, 5511);
            CallChecker.varInit(maxEval, "maxEval", 141, 4723, 5511);
            CallChecker.varInit(this.function, "function", 141, 4723, 5511);
            CallChecker.varInit(this.upperBound, "upperBound", 141, 4723, 5511);
            CallChecker.varInit(this.lowerBound, "lowerBound", 141, 4723, 5511);
            CallChecker.varInit(this.start, "start", 141, 4723, 5511);
            CallChecker.varInit(this.goal, "goal", 141, 4723, 5511);
            CallChecker.varInit(this.checker, "checker", 141, 4723, 5511);
            CallChecker.varInit(this.evaluations, "evaluations", 141, 4723, 5511);
            return optimizeInternal(maxEval, f, goalType, optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2394.methodEnd();
        }
    }

    @Deprecated
    protected PointValuePair optimizeInternal(int maxEval, FUNC f, GoalType goalType, double[] startPoint) {
        MethodContext _bcornu_methode_context2395 = new MethodContext(PointValuePair.class, 169, 5518, 6707);
        try {
            CallChecker.varInit(this, "this", 169, 5518, 6707);
            CallChecker.varInit(startPoint, "startPoint", 169, 5518, 6707);
            CallChecker.varInit(goalType, "goalType", 169, 5518, 6707);
            CallChecker.varInit(f, "f", 169, 5518, 6707);
            CallChecker.varInit(maxEval, "maxEval", 169, 5518, 6707);
            CallChecker.varInit(this.function, "function", 169, 5518, 6707);
            CallChecker.varInit(this.upperBound, "upperBound", 169, 5518, 6707);
            CallChecker.varInit(this.lowerBound, "lowerBound", 169, 5518, 6707);
            CallChecker.varInit(this.start, "start", 169, 5518, 6707);
            CallChecker.varInit(this.goal, "goal", 169, 5518, 6707);
            CallChecker.varInit(this.checker, "checker", 169, 5518, 6707);
            CallChecker.varInit(this.evaluations, "evaluations", 169, 5518, 6707);
            return optimizeInternal(maxEval, f, goalType, new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2395.methodEnd();
        }
    }

    protected PointValuePair optimizeInternal(int maxEval, FUNC f, GoalType goalType, OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2396 = new MethodContext(PointValuePair.class, 191, 6714, 7983);
        try {
            CallChecker.varInit(this, "this", 191, 6714, 7983);
            CallChecker.varInit(optData, "optData", 191, 6714, 7983);
            CallChecker.varInit(goalType, "goalType", 191, 6714, 7983);
            CallChecker.varInit(f, "f", 191, 6714, 7983);
            CallChecker.varInit(maxEval, "maxEval", 191, 6714, 7983);
            CallChecker.varInit(this.function, "function", 191, 6714, 7983);
            CallChecker.varInit(this.upperBound, "upperBound", 191, 6714, 7983);
            CallChecker.varInit(this.lowerBound, "lowerBound", 191, 6714, 7983);
            CallChecker.varInit(this.start, "start", 191, 6714, 7983);
            CallChecker.varInit(this.goal, "goal", 191, 6714, 7983);
            CallChecker.varInit(this.checker, "checker", 191, 6714, 7983);
            CallChecker.varInit(this.evaluations, "evaluations", 191, 6714, 7983);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 197, 7660, 7670)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 197, 7660, 7670).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 198, 7706, 7716)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 198, 7706, 7716).resetCount();
            }
            function = f;
            CallChecker.varAssign(this.function, "this.function", 199, 7740, 7752);
            goal = goalType;
            CallChecker.varAssign(this.goal, "this.goal", 200, 7762, 7777);
            parseOptimizationData(optData);
            checkParameters();
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2396.methodEnd();
        }
    }

    private void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context2397 = new MethodContext(void.class, 219, 7990, 8950);
        try {
            CallChecker.varInit(this, "this", 219, 7990, 8950);
            CallChecker.varInit(optData, "optData", 219, 7990, 8950);
            CallChecker.varInit(this.function, "function", 219, 7990, 8950);
            CallChecker.varInit(this.upperBound, "upperBound", 219, 7990, 8950);
            CallChecker.varInit(this.lowerBound, "lowerBound", 219, 7990, 8950);
            CallChecker.varInit(this.start, "start", 219, 7990, 8950);
            CallChecker.varInit(this.goal, "goal", 219, 7990, 8950);
            CallChecker.varInit(this.checker, "checker", 219, 7990, 8950);
            CallChecker.varInit(this.evaluations, "evaluations", 219, 7990, 8950);
            if (CallChecker.beforeDeref(optData, void.class, 222, 8523, 8529)) {
                for (OptimizationData data : optData) {
                    if (data instanceof InitialGuess) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 224, 8622, 8625)) {
                            start = CallChecker.isCalled(((InitialGuess) (data)), InitialGuess.class, 224, 8622, 8625).getInitialGuess();
                            CallChecker.varAssign(this.start, "this.start", 224, 8598, 8645);
                        }
                        continue;
                    }
                    if (data instanceof SimpleBounds) {
                        final SimpleBounds bounds = CallChecker.varInit(((SimpleBounds) (data)), "bounds", 228, 8751, 8798);
                        if (CallChecker.beforeDeref(bounds, SimpleBounds.class, 229, 8829, 8834)) {
                            lowerBound = CallChecker.isCalled(bounds, SimpleBounds.class, 229, 8829, 8834).getLower();
                            CallChecker.varAssign(this.lowerBound, "this.lowerBound", 229, 8816, 8846);
                        }
                        if (CallChecker.beforeDeref(bounds, SimpleBounds.class, 230, 8877, 8882)) {
                            upperBound = CallChecker.isCalled(bounds, SimpleBounds.class, 230, 8877, 8882).getUpper();
                            CallChecker.varAssign(this.upperBound, "this.upperBound", 230, 8864, 8894);
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2397.methodEnd();
        }
    }

    public GoalType getGoalType() {
        MethodContext _bcornu_methode_context2398 = new MethodContext(GoalType.class, 239, 8957, 9068);
        try {
            CallChecker.varInit(this, "this", 239, 8957, 9068);
            CallChecker.varInit(this.function, "function", 239, 8957, 9068);
            CallChecker.varInit(this.upperBound, "upperBound", 239, 8957, 9068);
            CallChecker.varInit(this.lowerBound, "lowerBound", 239, 8957, 9068);
            CallChecker.varInit(this.start, "start", 239, 8957, 9068);
            CallChecker.varInit(this.goal, "goal", 239, 8957, 9068);
            CallChecker.varInit(this.checker, "checker", 239, 8957, 9068);
            CallChecker.varInit(this.evaluations, "evaluations", 239, 8957, 9068);
            return goal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GoalType) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2398.methodEnd();
        }
    }

    public double[] getStartPoint() {
        MethodContext _bcornu_methode_context2399 = new MethodContext(double[].class, 246, 9075, 9216);
        try {
            CallChecker.varInit(this, "this", 246, 9075, 9216);
            CallChecker.varInit(this.function, "function", 246, 9075, 9216);
            CallChecker.varInit(this.upperBound, "upperBound", 246, 9075, 9216);
            CallChecker.varInit(this.lowerBound, "lowerBound", 246, 9075, 9216);
            CallChecker.varInit(this.start, "start", 246, 9075, 9216);
            CallChecker.varInit(this.goal, "goal", 246, 9075, 9216);
            CallChecker.varInit(this.checker, "checker", 246, 9075, 9216);
            CallChecker.varInit(this.evaluations, "evaluations", 246, 9075, 9216);
            if ((start) == null) {
                return null;
            }else {
                return start.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2399.methodEnd();
        }
    }

    public double[] getLowerBound() {
        MethodContext _bcornu_methode_context2400 = new MethodContext(double[].class, 253, 9222, 9390);
        try {
            CallChecker.varInit(this, "this", 253, 9222, 9390);
            CallChecker.varInit(this.function, "function", 253, 9222, 9390);
            CallChecker.varInit(this.upperBound, "upperBound", 253, 9222, 9390);
            CallChecker.varInit(this.lowerBound, "lowerBound", 253, 9222, 9390);
            CallChecker.varInit(this.start, "start", 253, 9222, 9390);
            CallChecker.varInit(this.goal, "goal", 253, 9222, 9390);
            CallChecker.varInit(this.checker, "checker", 253, 9222, 9390);
            CallChecker.varInit(this.evaluations, "evaluations", 253, 9222, 9390);
            if ((lowerBound) == null) {
                return null;
            }else {
                return lowerBound.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2400.methodEnd();
        }
    }

    public double[] getUpperBound() {
        MethodContext _bcornu_methode_context2401 = new MethodContext(double[].class, 260, 9396, 9564);
        try {
            CallChecker.varInit(this, "this", 260, 9396, 9564);
            CallChecker.varInit(this.function, "function", 260, 9396, 9564);
            CallChecker.varInit(this.upperBound, "upperBound", 260, 9396, 9564);
            CallChecker.varInit(this.lowerBound, "lowerBound", 260, 9396, 9564);
            CallChecker.varInit(this.start, "start", 260, 9396, 9564);
            CallChecker.varInit(this.goal, "goal", 260, 9396, 9564);
            CallChecker.varInit(this.checker, "checker", 260, 9396, 9564);
            CallChecker.varInit(this.evaluations, "evaluations", 260, 9396, 9564);
            if ((upperBound) == null) {
                return null;
            }else {
                return upperBound.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2401.methodEnd();
        }
    }

    protected abstract PointValuePair doOptimize();

    private void checkParameters() {
        MethodContext _bcornu_methode_context2403 = new MethodContext(void.class, 275, 9797, 11529);
        try {
            CallChecker.varInit(this, "this", 275, 9797, 11529);
            CallChecker.varInit(this.function, "function", 275, 9797, 11529);
            CallChecker.varInit(this.upperBound, "upperBound", 275, 9797, 11529);
            CallChecker.varInit(this.lowerBound, "lowerBound", 275, 9797, 11529);
            CallChecker.varInit(this.start, "start", 275, 9797, 11529);
            CallChecker.varInit(this.goal, "goal", 275, 9797, 11529);
            CallChecker.varInit(this.checker, "checker", 275, 9797, 11529);
            CallChecker.varInit(this.evaluations, "evaluations", 275, 9797, 11529);
            if ((start) != null) {
                start = CallChecker.beforeCalled(start, double[].class, 277, 9940, 9944);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(this.start, double[].class, 277, 9940, 9944).length)), "dim", 277, 9924, 9952);
                if ((lowerBound) != null) {
                    if (CallChecker.beforeDeref(lowerBound, double[].class, 279, 10012, 10021)) {
                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 279, 10012, 10021);
                        if ((CallChecker.isCalled(lowerBound, double[].class, 279, 10012, 10021).length) != dim) {
                            if (CallChecker.beforeDeref(lowerBound, double[].class, 280, 10097, 10106)) {
                                lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 280, 10097, 10106);
                                throw new DimensionMismatchException(CallChecker.isCalled(lowerBound, double[].class, 280, 10097, 10106).length, dim);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        final double v = CallChecker.varInit(((double) (this.start[i])), "v", 283, 10208, 10233);
                        final double lo = CallChecker.varInit(((double) (this.lowerBound[i])), "lo", 284, 10255, 10286);
                        if (v < lo) {
                            throw new NumberIsTooSmallException(v, lo, true);
                        }
                    }
                }
                if ((upperBound) != null) {
                    if (CallChecker.beforeDeref(upperBound, double[].class, 291, 10508, 10517)) {
                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 291, 10508, 10517);
                        if ((CallChecker.isCalled(upperBound, double[].class, 291, 10508, 10517).length) != dim) {
                            if (CallChecker.beforeDeref(upperBound, double[].class, 292, 10593, 10602)) {
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 292, 10593, 10602);
                                throw new DimensionMismatchException(CallChecker.isCalled(upperBound, double[].class, 292, 10593, 10602).length, dim);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        final double v = CallChecker.varInit(((double) (this.start[i])), "v", 295, 10704, 10729);
                        final double hi = CallChecker.varInit(((double) (this.upperBound[i])), "hi", 296, 10751, 10782);
                        if (v > hi) {
                            throw new NumberIsTooLargeException(v, hi, true);
                        }
                    }
                }
                if ((lowerBound) == null) {
                    lowerBound = new double[dim];
                    CallChecker.varAssign(this.lowerBound, "this.lowerBound", 306, 11117, 11145);
                    for (int i = 0; i < dim; i++) {
                        if (CallChecker.beforeDeref(lowerBound, double[].class, 308, 11215, 11224)) {
                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 308, 11215, 11224);
                            CallChecker.isCalled(lowerBound, double[].class, 308, 11215, 11224)[i] = Double.NEGATIVE_INFINITY;
                            CallChecker.varAssign(CallChecker.isCalled(this.lowerBound, double[].class, 308, 11215, 11224)[i], "CallChecker.isCalled(this.lowerBound, double[].class, 308, 11215, 11224)[i]", 308, 11215, 11255);
                        }
                    }
                }
                if ((upperBound) == null) {
                    upperBound = new double[dim];
                    CallChecker.varAssign(this.upperBound, "this.upperBound", 312, 11343, 11371);
                    for (int i = 0; i < dim; i++) {
                        if (CallChecker.beforeDeref(upperBound, double[].class, 314, 11441, 11450)) {
                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 314, 11441, 11450);
                            CallChecker.isCalled(upperBound, double[].class, 314, 11441, 11450)[i] = Double.POSITIVE_INFINITY;
                            CallChecker.varAssign(CallChecker.isCalled(this.upperBound, double[].class, 314, 11441, 11450)[i], "CallChecker.isCalled(this.upperBound, double[].class, 314, 11441, 11450)[i]", 314, 11441, 11481);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2403.methodEnd();
        }
    }
}

