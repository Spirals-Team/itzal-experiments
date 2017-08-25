package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class BaseMultivariateMultiStartOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    private final BaseMultivariateOptimizer<FUNC> optimizer;

    private int maxEvaluations;

    private int totalEvaluations;

    private int starts;

    private RandomVectorGenerator generator;

    private PointValuePair[] optima;

    protected BaseMultivariateMultiStartOptimizer(final BaseMultivariateOptimizer<FUNC> optimizer, final int starts, final RandomVectorGenerator generator) {
        ConstructorContext _bcornu_methode_context412 = new ConstructorContext(BaseMultivariateMultiStartOptimizer.class, 72, 2429, 3625);
        try {
            if ((optimizer == null) || (generator == null)) {
                throw new NullArgumentException();
            }
            if (starts < 1) {
                throw new NotStrictlyPositiveException(starts);
            }
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 83, 3527, 3553);
            this.starts = starts;
            CallChecker.varAssign(this.starts, "this.starts", 84, 3563, 3583);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 85, 3593, 3619);
        } finally {
            _bcornu_methode_context412.methodEnd();
        }
    }

    public PointValuePair[] getOptima() {
        MethodContext _bcornu_methode_context1774 = new MethodContext(PointValuePair[].class, 114, 3632, 5295);
        try {
            CallChecker.varInit(this, "this", 114, 3632, 5295);
            CallChecker.varInit(this.optima, "optima", 114, 3632, 5295);
            CallChecker.varInit(this.generator, "generator", 114, 3632, 5295);
            CallChecker.varInit(this.starts, "starts", 114, 3632, 5295);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 114, 3632, 5295);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 114, 3632, 5295);
            CallChecker.varInit(this.optimizer, "optimizer", 114, 3632, 5295);
            if ((optima) == null) {
                throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET);
            }
            return optima.clone();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1774.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context1775 = new MethodContext(int.class, 122, 5302, 5395);
        try {
            CallChecker.varInit(this, "this", 122, 5302, 5395);
            CallChecker.varInit(this.optima, "optima", 122, 5302, 5395);
            CallChecker.varInit(this.generator, "generator", 122, 5302, 5395);
            CallChecker.varInit(this.starts, "starts", 122, 5302, 5395);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 122, 5302, 5395);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 122, 5302, 5395);
            CallChecker.varInit(this.optimizer, "optimizer", 122, 5302, 5395);
            return maxEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1775.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context1776 = new MethodContext(int.class, 127, 5402, 5494);
        try {
            CallChecker.varInit(this, "this", 127, 5402, 5494);
            CallChecker.varInit(this.optima, "optima", 127, 5402, 5494);
            CallChecker.varInit(this.generator, "generator", 127, 5402, 5494);
            CallChecker.varInit(this.starts, "starts", 127, 5402, 5494);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 127, 5402, 5494);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 127, 5402, 5494);
            CallChecker.varInit(this.optimizer, "optimizer", 127, 5402, 5494);
            return totalEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1776.methodEnd();
        }
    }

    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context1777 = new MethodContext(ConvergenceChecker.class, 132, 5501, 5648);
        try {
            CallChecker.varInit(this, "this", 132, 5501, 5648);
            CallChecker.varInit(this.optima, "optima", 132, 5501, 5648);
            CallChecker.varInit(this.generator, "generator", 132, 5501, 5648);
            CallChecker.varInit(this.starts, "starts", 132, 5501, 5648);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 132, 5501, 5648);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 132, 5501, 5648);
            CallChecker.varInit(this.optimizer, "optimizer", 132, 5501, 5648);
            if (CallChecker.beforeDeref(optimizer, BaseMultivariateOptimizer.class, 133, 5609, 5617)) {
                return CallChecker.isCalled(optimizer, BaseMultivariateOptimizer.class, 133, 5609, 5617).getConvergenceChecker();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<PointValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1777.methodEnd();
        }
    }

    public PointValuePair optimize(int maxEval, final FUNC f, final GoalType goal, double[] startPoint) {
        MethodContext _bcornu_methode_context1778 = new MethodContext(PointValuePair.class, 139, 5655, 6831);
        try {
            CallChecker.varInit(this, "this", 139, 5655, 6831);
            CallChecker.varInit(startPoint, "startPoint", 139, 5655, 6831);
            CallChecker.varInit(goal, "goal", 139, 5655, 6831);
            CallChecker.varInit(f, "f", 139, 5655, 6831);
            CallChecker.varInit(maxEval, "maxEval", 139, 5655, 6831);
            CallChecker.varInit(this.optima, "optima", 139, 5655, 6831);
            CallChecker.varInit(this.generator, "generator", 139, 5655, 6831);
            CallChecker.varInit(this.starts, "starts", 139, 5655, 6831);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 139, 5655, 6831);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 139, 5655, 6831);
            CallChecker.varInit(this.optimizer, "optimizer", 139, 5655, 6831);
            maxEvaluations = maxEval;
            CallChecker.varAssign(this.maxEvaluations, "this.maxEvaluations", 142, 5880, 5904);
            RuntimeException lastException = CallChecker.varInit(null, "lastException", 143, 5914, 5951);
            optima = new PointValuePair[starts];
            CallChecker.varAssign(this.optima, "this.optima", 144, 5961, 5996);
            totalEvaluations = 0;
            CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 145, 6006, 6026);
            for (int i = 0; i < (starts); ++i) {
                TryContext _bcornu_try_context_28 = new TryContext(28, BaseMultivariateMultiStartOptimizer.class, "java.lang.RuntimeException");
                try {
                    if (CallChecker.beforeDeref(optima, PointValuePair[].class, 151, 6180, 6185)) {
                        if ((i == 0) || (CallChecker.beforeDeref(generator, RandomVectorGenerator.class, 152, 6317, 6325))) {
                            if (CallChecker.beforeDeref(optimizer, BaseMultivariateOptimizer.class, 151, 6192, 6200)) {
                                optima = CallChecker.beforeCalled(optima, PointValuePair[].class, 151, 6180, 6185);
                                generator = CallChecker.beforeCalled(generator, RandomVectorGenerator.class, 152, 6317, 6325);
                                CallChecker.isCalled(optima, PointValuePair[].class, 151, 6180, 6185)[i] = CallChecker.isCalled(optimizer, BaseMultivariateOptimizer.class, 151, 6192, 6200).optimize((maxEval - (totalEvaluations)), f, goal, ((i == 0) ? startPoint : CallChecker.isCalled(generator, RandomVectorGenerator.class, 152, 6317, 6325).nextVector()));
                                CallChecker.varAssign(CallChecker.isCalled(this.optima, PointValuePair[].class, 151, 6180, 6185)[i], "CallChecker.isCalled(this.optima, PointValuePair[].class, 151, 6180, 6185)[i]", 151, 6180, 6340);
                            }
                        }
                    }
                } catch (RuntimeException mue) {
                    _bcornu_try_context_28.catchStart(28);
                    lastException = mue;
                    CallChecker.varAssign(lastException, "lastException", 154, 6403, 6422);
                    if (CallChecker.beforeDeref(optima, PointValuePair[].class, 155, 6440, 6445)) {
                        optima = CallChecker.beforeCalled(optima, PointValuePair[].class, 155, 6440, 6445);
                        CallChecker.isCalled(optima, PointValuePair[].class, 155, 6440, 6445)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.optima, PointValuePair[].class, 155, 6440, 6445)[i], "CallChecker.isCalled(this.optima, PointValuePair[].class, 155, 6440, 6445)[i]", 155, 6440, 6456);
                    }
                } finally {
                    _bcornu_try_context_28.finallyStart(28);
                }
                if (CallChecker.beforeDeref(optimizer, BaseMultivariateOptimizer.class, 159, 6552, 6560)) {
                    totalEvaluations += CallChecker.isCalled(optimizer, BaseMultivariateOptimizer.class, 159, 6552, 6560).getEvaluations();
                    CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 159, 6532, 6578);
                }
            }
            sortPairs(goal);
            if (CallChecker.beforeDeref(optima, PointValuePair[].class, 164, 6629, 6634)) {
                optima = CallChecker.beforeCalled(optima, PointValuePair[].class, 164, 6629, 6634);
                if ((CallChecker.isCalled(optima, PointValuePair[].class, 164, 6629, 6634)[0]) == null) {
                    throw lastException;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(optima, PointValuePair[].class, 169, 6816, 6821)) {
                optima = CallChecker.beforeCalled(optima, PointValuePair[].class, 169, 6816, 6821);
                return CallChecker.isCalled(optima, PointValuePair[].class, 169, 6816, 6821)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1778.methodEnd();
        }
    }

    private void sortPairs(final GoalType goal) {
        MethodContext _bcornu_methode_context1780 = new MethodContext(void.class, 177, 6838, 7667);
        try {
            CallChecker.varInit(this, "this", 177, 6838, 7667);
            CallChecker.varInit(goal, "goal", 177, 6838, 7667);
            CallChecker.varInit(this.optima, "optima", 177, 6838, 7667);
            CallChecker.varInit(this.generator, "generator", 177, 6838, 7667);
            CallChecker.varInit(this.starts, "starts", 177, 6838, 7667);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 177, 6838, 7667);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 177, 6838, 7667);
            CallChecker.varInit(this.optimizer, "optimizer", 177, 6838, 7667);
            Arrays.sort(optima, new Comparator<PointValuePair>() {
                public int compare(final PointValuePair o1, final PointValuePair o2) {
                    MethodContext _bcornu_methode_context1779 = new MethodContext(int.class, 179, 7094, 7645);
                    try {
                        CallChecker.varInit(this, "this", 179, 7094, 7645);
                        CallChecker.varInit(o2, "o2", 179, 7094, 7645);
                        CallChecker.varInit(o1, "o1", 179, 7094, 7645);
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
                        
                        double v1 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o1, PointValuePair.class, 186, 7431, 7432)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 186, 7431, 7432).getValue())), double.class, 186, 7431, 7443)) {
                                if (CallChecker.beforeDeref(o1, PointValuePair.class, 186, 7431, 7432)) {
                                    v1 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 186, 7431, 7432).getValue())), double.class, 186, 7431, 7443);
                                    CallChecker.varAssign(v1, "v1", 186, 7431, 7443);
                                }
                            }
                        }
                        double v2 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o2, PointValuePair.class, 187, 7484, 7485)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 187, 7484, 7485).getValue())), double.class, 187, 7484, 7496)) {
                                if (CallChecker.beforeDeref(o2, PointValuePair.class, 187, 7484, 7485)) {
                                    v2 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 187, 7484, 7485).getValue())), double.class, 187, 7484, 7496);
                                    CallChecker.varAssign(v2, "v2", 187, 7484, 7496);
                                }
                            }
                        }
                        if (goal == (GoalType.MINIMIZE)) {
                            return Double.compare(v1, v2);
                        }else {
                            return Double.compare(v2, v1);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1779.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1780.methodEnd();
        }
    }
}

