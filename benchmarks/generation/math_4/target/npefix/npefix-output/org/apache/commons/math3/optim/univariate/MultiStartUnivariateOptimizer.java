package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

public class MultiStartUnivariateOptimizer extends UnivariateOptimizer {
    private final UnivariateOptimizer optimizer;

    private int totalEvaluations;

    private int starts;

    private RandomGenerator generator;

    private UnivariatePointValuePair[] optima;

    private OptimizationData[] optimData;

    private int maxEvalIndex = -1;

    private int searchIntervalIndex = -1;

    public MultiStartUnivariateOptimizer(final UnivariateOptimizer optimizer, final int starts, final RandomGenerator generator) {
        super(CallChecker.isCalled(optimizer, UnivariateOptimizer.class, 79, 3260, 3268).getConvergenceChecker());
        ConstructorContext _bcornu_methode_context333 = new ConstructorContext(MultiStartUnivariateOptimizer.class, 76, 2585, 3500);
        try {
            if (starts < 1) {
                throw new NotStrictlyPositiveException(starts);
            }
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 85, 3402, 3428);
            this.starts = starts;
            CallChecker.varAssign(this.starts, "this.starts", 86, 3438, 3458);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 87, 3468, 3494);
        } finally {
            _bcornu_methode_context333.methodEnd();
        }
    }

    @Override
    public int getEvaluations() {
        MethodContext _bcornu_methode_context1544 = new MethodContext(int.class, 92, 3507, 3613);
        try {
            CallChecker.varInit(this, "this", 92, 3507, 3613);
            CallChecker.varInit(this.iterations, "iterations", 92, 3507, 3613);
            CallChecker.varInit(this.evaluations, "evaluations", 92, 3507, 3613);
            CallChecker.varInit(this.searchIntervalIndex, "searchIntervalIndex", 92, 3507, 3613);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 92, 3507, 3613);
            CallChecker.varInit(this.optimData, "optimData", 92, 3507, 3613);
            CallChecker.varInit(this.optima, "optima", 92, 3507, 3613);
            CallChecker.varInit(this.generator, "generator", 92, 3507, 3613);
            CallChecker.varInit(this.starts, "starts", 92, 3507, 3613);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 92, 3507, 3613);
            CallChecker.varInit(this.optimizer, "optimizer", 92, 3507, 3613);
            return totalEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1544.methodEnd();
        }
    }

    public UnivariatePointValuePair[] getOptima() {
        MethodContext _bcornu_methode_context1545 = new MethodContext(UnivariatePointValuePair[].class, 118, 3620, 5038);
        try {
            CallChecker.varInit(this, "this", 118, 3620, 5038);
            CallChecker.varInit(this.iterations, "iterations", 118, 3620, 5038);
            CallChecker.varInit(this.evaluations, "evaluations", 118, 3620, 5038);
            CallChecker.varInit(this.searchIntervalIndex, "searchIntervalIndex", 118, 3620, 5038);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 118, 3620, 5038);
            CallChecker.varInit(this.optimData, "optimData", 118, 3620, 5038);
            CallChecker.varInit(this.optima, "optima", 118, 3620, 5038);
            CallChecker.varInit(this.generator, "generator", 118, 3620, 5038);
            CallChecker.varInit(this.starts, "starts", 118, 3620, 5038);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 118, 3620, 5038);
            CallChecker.varInit(this.optimizer, "optimizer", 118, 3620, 5038);
            if ((optima) == null) {
                throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET);
            }
            return optima.clone();
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1545.methodEnd();
        }
    }

    @Override
    public UnivariatePointValuePair optimize(OptimizationData... optData) {
        MethodContext _bcornu_methode_context1546 = new MethodContext(UnivariatePointValuePair.class, 132, 5045, 5520);
        try {
            CallChecker.varInit(this, "this", 132, 5045, 5520);
            CallChecker.varInit(optData, "optData", 132, 5045, 5520);
            CallChecker.varInit(this.iterations, "iterations", 132, 5045, 5520);
            CallChecker.varInit(this.evaluations, "evaluations", 132, 5045, 5520);
            CallChecker.varInit(this.searchIntervalIndex, "searchIntervalIndex", 132, 5045, 5520);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 132, 5045, 5520);
            CallChecker.varInit(this.optimData, "optimData", 132, 5045, 5520);
            CallChecker.varInit(this.optima, "optima", 132, 5045, 5520);
            CallChecker.varInit(this.generator, "generator", 132, 5045, 5520);
            CallChecker.varInit(this.starts, "starts", 132, 5045, 5520);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 132, 5045, 5520);
            CallChecker.varInit(this.optimizer, "optimizer", 132, 5045, 5520);
            optimData = optData;
            CallChecker.varAssign(this.optimData, "this.optimData", 134, 5400, 5419);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1546.methodEnd();
        }
    }

    @Override
    protected UnivariatePointValuePair doOptimize() {
        MethodContext _bcornu_methode_context1547 = new MethodContext(UnivariatePointValuePair.class, 141, 5527, 7992);
        try {
            CallChecker.varInit(this, "this", 141, 5527, 7992);
            CallChecker.varInit(this.iterations, "iterations", 141, 5527, 7992);
            CallChecker.varInit(this.evaluations, "evaluations", 141, 5527, 7992);
            CallChecker.varInit(this.searchIntervalIndex, "searchIntervalIndex", 141, 5527, 7992);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 141, 5527, 7992);
            CallChecker.varInit(this.optimData, "optimData", 141, 5527, 7992);
            CallChecker.varInit(this.optima, "optima", 141, 5527, 7992);
            CallChecker.varInit(this.generator, "generator", 141, 5527, 7992);
            CallChecker.varInit(this.starts, "starts", 141, 5527, 7992);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 141, 5527, 7992);
            CallChecker.varInit(this.optimizer, "optimizer", 141, 5527, 7992);
            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 147, 5996, 6004);
            for (int i = 0; i < (CallChecker.isCalled(optimData, OptimizationData[].class, 147, 5996, 6004).length); i++) {
                if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 148, 6037, 6045)) {
                    optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 148, 6037, 6045);
                    if ((CallChecker.isCalled(optimData, OptimizationData[].class, 148, 6037, 6045)[i]) instanceof MaxEval) {
                        if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 149, 6088, 6096)) {
                            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 149, 6088, 6096);
                            CallChecker.isCalled(optimData, OptimizationData[].class, 149, 6088, 6096)[i] = null;
                            CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 149, 6088, 6096)[i], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 149, 6088, 6096)[i]", 149, 6088, 6107);
                        }
                        maxEvalIndex = i;
                        CallChecker.varAssign(this.maxEvalIndex, "this.maxEvalIndex", 150, 6125, 6141);
                        continue;
                    }
                }
                if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 153, 6199, 6207)) {
                    optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 153, 6199, 6207);
                    if ((CallChecker.isCalled(optimData, OptimizationData[].class, 153, 6199, 6207)[i]) instanceof SearchInterval) {
                        if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 154, 6257, 6265)) {
                            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 154, 6257, 6265);
                            CallChecker.isCalled(optimData, OptimizationData[].class, 154, 6257, 6265)[i] = null;
                            CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 154, 6257, 6265)[i], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 154, 6257, 6265)[i]", 154, 6257, 6276);
                        }
                        searchIntervalIndex = i;
                        CallChecker.varAssign(this.searchIntervalIndex, "this.searchIntervalIndex", 155, 6294, 6317);
                        continue;
                    }
                }
            }
            if ((maxEvalIndex) == (-1)) {
                throw new MathIllegalStateException();
            }
            if ((searchIntervalIndex) == (-1)) {
                throw new MathIllegalStateException();
            }
            RuntimeException lastException = CallChecker.varInit(null, "lastException", 166, 6575, 6612);
            optima = new UnivariatePointValuePair[starts];
            CallChecker.varAssign(this.optima, "this.optima", 167, 6622, 6667);
            totalEvaluations = 0;
            CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 168, 6677, 6697);
            final int maxEval = CallChecker.varInit(((int) (getMaxEvaluations())), "maxEval", 170, 6708, 6747);
            final double min = CallChecker.varInit(((double) (getMin())), "min", 171, 6757, 6784);
            final double max = CallChecker.varInit(((double) (getMax())), "max", 172, 6794, 6821);
            final double startValue = CallChecker.varInit(((double) (getStartValue())), "startValue", 173, 6831, 6872);
            for (int i = 0; i < (starts); i++) {
                TryContext _bcornu_try_context_25 = new TryContext(25, MultiStartUnivariateOptimizer.class, "java.lang.RuntimeException");
                try {
                    if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 180, 7085, 7093)) {
                        optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 180, 7085, 7093);
                        CallChecker.isCalled(optimData, OptimizationData[].class, 180, 7085, 7093)[maxEvalIndex] = new MaxEval((maxEval - (totalEvaluations)));
                        CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 180, 7085, 7093)[this.maxEvalIndex], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 180, 7085, 7093)[this.maxEvalIndex]", 180, 7085, 7150);
                    }
                    double s = CallChecker.init(double.class);
                    if (i == 0) {
                        s = startValue;
                        CallChecker.varAssign(s, "s", 182, 7221, 7326);
                    }else {
                        if (CallChecker.beforeDeref(generator, RandomGenerator.class, 184, 7291, 7299)) {
                            generator = CallChecker.beforeCalled(generator, RandomGenerator.class, 184, 7291, 7299);
                            s = min + ((CallChecker.isCalled(generator, RandomGenerator.class, 184, 7291, 7299).nextDouble()) * (max - min));
                            CallChecker.varAssign(s, "s", 182, 7221, 7326);
                        }
                    }
                    if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 185, 7345, 7353)) {
                        optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 185, 7345, 7353);
                        CallChecker.isCalled(optimData, OptimizationData[].class, 185, 7345, 7353)[searchIntervalIndex] = new SearchInterval(min, max, s);
                        CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 185, 7345, 7353)[this.searchIntervalIndex], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 185, 7345, 7353)[this.searchIntervalIndex]", 185, 7345, 7409);
                    }
                    if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 187, 7456, 7461)) {
                        if (CallChecker.beforeDeref(optimizer, UnivariateOptimizer.class, 187, 7468, 7476)) {
                            optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 187, 7456, 7461);
                            CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 187, 7456, 7461)[i] = CallChecker.isCalled(optimizer, UnivariateOptimizer.class, 187, 7468, 7476).optimize(optimData);
                            CallChecker.varAssign(CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 187, 7456, 7461)[i], "CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 187, 7456, 7461)[i]", 187, 7456, 7497);
                        }
                    }
                } catch (RuntimeException mue) {
                    _bcornu_try_context_25.catchStart(25);
                    lastException = mue;
                    CallChecker.varAssign(lastException, "lastException", 189, 7560, 7579);
                    if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 190, 7597, 7602)) {
                        optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 190, 7597, 7602);
                        CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 190, 7597, 7602)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 190, 7597, 7602)[i], "CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 190, 7597, 7602)[i]", 190, 7597, 7613);
                    }
                } finally {
                    _bcornu_try_context_25.finallyStart(25);
                }
                if (CallChecker.beforeDeref(optimizer, UnivariateOptimizer.class, 194, 7709, 7717)) {
                    totalEvaluations += CallChecker.isCalled(optimizer, UnivariateOptimizer.class, 194, 7709, 7717).getEvaluations();
                    CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 194, 7689, 7735);
                }
            }
            sortPairs(getGoalType());
            if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 199, 7795, 7800)) {
                optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 199, 7795, 7800);
                if ((CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 199, 7795, 7800)[0]) == null) {
                    throw lastException;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 204, 7977, 7982)) {
                optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 204, 7977, 7982);
                return CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 204, 7977, 7982)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1547.methodEnd();
        }
    }

    private void sortPairs(final GoalType goal) {
        MethodContext _bcornu_methode_context1549 = new MethodContext(void.class, 212, 7999, 8858);
        try {
            CallChecker.varInit(this, "this", 212, 7999, 8858);
            CallChecker.varInit(goal, "goal", 212, 7999, 8858);
            CallChecker.varInit(this.iterations, "iterations", 212, 7999, 8858);
            CallChecker.varInit(this.evaluations, "evaluations", 212, 7999, 8858);
            CallChecker.varInit(this.searchIntervalIndex, "searchIntervalIndex", 212, 7999, 8858);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 212, 7999, 8858);
            CallChecker.varInit(this.optimData, "optimData", 212, 7999, 8858);
            CallChecker.varInit(this.optima, "optima", 212, 7999, 8858);
            CallChecker.varInit(this.generator, "generator", 212, 7999, 8858);
            CallChecker.varInit(this.starts, "starts", 212, 7999, 8858);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 212, 7999, 8858);
            CallChecker.varInit(this.optimizer, "optimizer", 212, 7999, 8858);
            Arrays.sort(optima, new Comparator<UnivariatePointValuePair>() {
                public int compare(final UnivariatePointValuePair o1, final UnivariatePointValuePair o2) {
                    MethodContext _bcornu_methode_context1548 = new MethodContext(int.class, 214, 8265, 8836);
                    try {
                        CallChecker.varInit(this, "this", 214, 8265, 8836);
                        CallChecker.varInit(o2, "o2", 214, 8265, 8836);
                        CallChecker.varInit(o1, "o1", 214, 8265, 8836);
                        if (o1 == null) {
                            if (o2 == null) {
                                return 0;
                            }else {
                                return 1;
                            }
                        }else
                            if (o2 == null) {
                                return -1;
                            }
                        
                        final double v1 = CallChecker.varInit(((double) (CallChecker.isCalled(o1, UnivariatePointValuePair.class, 221, 8622, 8623).getValue())), "v1", 221, 8604, 8635);
                        final double v2 = CallChecker.varInit(((double) (CallChecker.isCalled(o2, UnivariatePointValuePair.class, 222, 8675, 8676).getValue())), "v2", 222, 8657, 8688);
                        if (goal == (GoalType.MINIMIZE)) {
                            return Double.compare(v1, v2);
                        }else {
                            return Double.compare(v2, v1);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1548.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1549.methodEnd();
        }
    }
}

