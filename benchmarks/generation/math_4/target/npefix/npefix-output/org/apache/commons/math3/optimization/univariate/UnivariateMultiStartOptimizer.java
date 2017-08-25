package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

@Deprecated
public class UnivariateMultiStartOptimizer<FUNC extends UnivariateFunction> implements BaseUnivariateOptimizer<FUNC> {
    private final BaseUnivariateOptimizer<FUNC> optimizer;

    private int maxEvaluations;

    private int totalEvaluations;

    private int starts;

    private RandomGenerator generator;

    private UnivariatePointValuePair[] optima;

    public UnivariateMultiStartOptimizer(final BaseUnivariateOptimizer<FUNC> optimizer, final int starts, final RandomGenerator generator) {
        ConstructorContext _bcornu_methode_context1085 = new ConstructorContext(UnivariateMultiStartOptimizer.class, 74, 2553, 3669);
        try {
            if ((optimizer == null) || (generator == null)) {
                throw new NullArgumentException();
            }
            if (starts < 1) {
                throw new NotStrictlyPositiveException(starts);
            }
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 85, 3571, 3597);
            this.starts = starts;
            CallChecker.varAssign(this.starts, "this.starts", 86, 3607, 3627);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 87, 3637, 3663);
        } finally {
            _bcornu_methode_context1085.methodEnd();
        }
    }

    public ConvergenceChecker<UnivariatePointValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context4838 = new MethodContext(ConvergenceChecker.class, 93, 3676, 3845);
        try {
            CallChecker.varInit(this, "this", 93, 3676, 3845);
            CallChecker.varInit(this.optima, "optima", 93, 3676, 3845);
            CallChecker.varInit(this.generator, "generator", 93, 3676, 3845);
            CallChecker.varInit(this.starts, "starts", 93, 3676, 3845);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 93, 3676, 3845);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 93, 3676, 3845);
            CallChecker.varInit(this.optimizer, "optimizer", 93, 3676, 3845);
            if (CallChecker.beforeDeref(optimizer, BaseUnivariateOptimizer.class, 94, 3806, 3814)) {
                return CallChecker.isCalled(optimizer, BaseUnivariateOptimizer.class, 94, 3806, 3814).getConvergenceChecker();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<UnivariatePointValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4838.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context4839 = new MethodContext(int.class, 98, 3852, 3945);
        try {
            CallChecker.varInit(this, "this", 98, 3852, 3945);
            CallChecker.varInit(this.optima, "optima", 98, 3852, 3945);
            CallChecker.varInit(this.generator, "generator", 98, 3852, 3945);
            CallChecker.varInit(this.starts, "starts", 98, 3852, 3945);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 98, 3852, 3945);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 98, 3852, 3945);
            CallChecker.varInit(this.optimizer, "optimizer", 98, 3852, 3945);
            return maxEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4839.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context4840 = new MethodContext(int.class, 103, 3952, 4044);
        try {
            CallChecker.varInit(this, "this", 103, 3952, 4044);
            CallChecker.varInit(this.optima, "optima", 103, 3952, 4044);
            CallChecker.varInit(this.generator, "generator", 103, 3952, 4044);
            CallChecker.varInit(this.starts, "starts", 103, 3952, 4044);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 103, 3952, 4044);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 103, 3952, 4044);
            CallChecker.varInit(this.optimizer, "optimizer", 103, 3952, 4044);
            return totalEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4840.methodEnd();
        }
    }

    public UnivariatePointValuePair[] getOptima() {
        MethodContext _bcornu_methode_context4841 = new MethodContext(UnivariatePointValuePair[].class, 134, 4051, 5758);
        try {
            CallChecker.varInit(this, "this", 134, 4051, 5758);
            CallChecker.varInit(this.optima, "optima", 134, 4051, 5758);
            CallChecker.varInit(this.generator, "generator", 134, 4051, 5758);
            CallChecker.varInit(this.starts, "starts", 134, 4051, 5758);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 134, 4051, 5758);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 134, 4051, 5758);
            CallChecker.varInit(this.optimizer, "optimizer", 134, 4051, 5758);
            if ((optima) == null) {
                throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET);
            }
            return optima.clone();
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4841.methodEnd();
        }
    }

    public UnivariatePointValuePair optimize(int maxEval, final FUNC f, final GoalType goal, final double min, final double max) {
        MethodContext _bcornu_methode_context4842 = new MethodContext(UnivariatePointValuePair.class, 142, 5765, 6097);
        try {
            CallChecker.varInit(this, "this", 142, 5765, 6097);
            CallChecker.varInit(max, "max", 142, 5765, 6097);
            CallChecker.varInit(min, "min", 142, 5765, 6097);
            CallChecker.varInit(goal, "goal", 142, 5765, 6097);
            CallChecker.varInit(f, "f", 142, 5765, 6097);
            CallChecker.varInit(maxEval, "maxEval", 142, 5765, 6097);
            CallChecker.varInit(this.optima, "optima", 142, 5765, 6097);
            CallChecker.varInit(this.generator, "generator", 142, 5765, 6097);
            CallChecker.varInit(this.starts, "starts", 142, 5765, 6097);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 142, 5765, 6097);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 142, 5765, 6097);
            CallChecker.varInit(this.optimizer, "optimizer", 142, 5765, 6097);
            return optimize(maxEval, f, goal, min, max, (min + (0.5 * (max - min))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4842.methodEnd();
        }
    }

    public UnivariatePointValuePair optimize(int maxEval, final FUNC f, final GoalType goal, final double min, final double max, final double startValue) {
        MethodContext _bcornu_methode_context4843 = new MethodContext(UnivariatePointValuePair.class, 149, 6104, 7377);
        try {
            CallChecker.varInit(this, "this", 149, 6104, 7377);
            CallChecker.varInit(startValue, "startValue", 149, 6104, 7377);
            CallChecker.varInit(max, "max", 149, 6104, 7377);
            CallChecker.varInit(min, "min", 149, 6104, 7377);
            CallChecker.varInit(goal, "goal", 149, 6104, 7377);
            CallChecker.varInit(f, "f", 149, 6104, 7377);
            CallChecker.varInit(maxEval, "maxEval", 149, 6104, 7377);
            CallChecker.varInit(this.optima, "optima", 149, 6104, 7377);
            CallChecker.varInit(this.generator, "generator", 149, 6104, 7377);
            CallChecker.varInit(this.starts, "starts", 149, 6104, 7377);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 149, 6104, 7377);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 149, 6104, 7377);
            CallChecker.varInit(this.optimizer, "optimizer", 149, 6104, 7377);
            RuntimeException lastException = CallChecker.varInit(null, "lastException", 153, 6436, 6473);
            optima = new UnivariatePointValuePair[starts];
            CallChecker.varAssign(this.optima, "this.optima", 154, 6483, 6528);
            totalEvaluations = 0;
            CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 155, 6538, 6558);
            for (int i = 0; i < (starts); ++i) {
                TryContext _bcornu_try_context_98 = new TryContext(98, UnivariateMultiStartOptimizer.class, "java.lang.RuntimeException");
                try {
                    double s = CallChecker.init(double.class);
                    if (i == 0) {
                        s = startValue;
                        CallChecker.varAssign(s, "s", 161, 6729, 6794);
                    }else {
                        if (CallChecker.beforeDeref(generator, RandomGenerator.class, 161, 6759, 6767)) {
                            generator = CallChecker.beforeCalled(generator, RandomGenerator.class, 161, 6759, 6767);
                            s = min + ((CallChecker.isCalled(generator, RandomGenerator.class, 161, 6759, 6767).nextDouble()) * (max - min));
                            CallChecker.varAssign(s, "s", 161, 6729, 6794);
                        }
                    }
                    if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 162, 6813, 6818)) {
                        if (CallChecker.beforeDeref(optimizer, BaseUnivariateOptimizer.class, 162, 6825, 6833)) {
                            optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 162, 6813, 6818);
                            CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 162, 6813, 6818)[i] = CallChecker.isCalled(optimizer, BaseUnivariateOptimizer.class, 162, 6825, 6833).optimize((maxEval - (totalEvaluations)), f, goal, min, max, s);
                            CallChecker.varAssign(CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 162, 6813, 6818)[i], "CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 162, 6813, 6818)[i]", 162, 6813, 6893);
                        }
                    }
                } catch (RuntimeException mue) {
                    _bcornu_try_context_98.catchStart(98);
                    lastException = mue;
                    CallChecker.varAssign(lastException, "lastException", 164, 6956, 6975);
                    if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 165, 6993, 6998)) {
                        optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 165, 6993, 6998);
                        CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 165, 6993, 6998)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 165, 6993, 6998)[i], "CallChecker.isCalled(this.optima, UnivariatePointValuePair[].class, 165, 6993, 6998)[i]", 165, 6993, 7009);
                    }
                } finally {
                    _bcornu_try_context_98.finallyStart(98);
                }
                if (CallChecker.beforeDeref(optimizer, BaseUnivariateOptimizer.class, 169, 7105, 7113)) {
                    totalEvaluations += CallChecker.isCalled(optimizer, BaseUnivariateOptimizer.class, 169, 7105, 7113).getEvaluations();
                    CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 169, 7085, 7131);
                }
            }
            sortPairs(goal);
            if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 174, 7182, 7187)) {
                optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 174, 7182, 7187);
                if ((CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 174, 7182, 7187)[0]) == null) {
                    throw lastException;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(optima, UnivariatePointValuePair[].class, 179, 7362, 7367)) {
                optima = CallChecker.beforeCalled(optima, UnivariatePointValuePair[].class, 179, 7362, 7367);
                return CallChecker.isCalled(optima, UnivariatePointValuePair[].class, 179, 7362, 7367)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4843.methodEnd();
        }
    }

    private void sortPairs(final GoalType goal) {
        MethodContext _bcornu_methode_context4845 = new MethodContext(void.class, 187, 7384, 8243);
        try {
            CallChecker.varInit(this, "this", 187, 7384, 8243);
            CallChecker.varInit(goal, "goal", 187, 7384, 8243);
            CallChecker.varInit(this.optima, "optima", 187, 7384, 8243);
            CallChecker.varInit(this.generator, "generator", 187, 7384, 8243);
            CallChecker.varInit(this.starts, "starts", 187, 7384, 8243);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 187, 7384, 8243);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 187, 7384, 8243);
            CallChecker.varInit(this.optimizer, "optimizer", 187, 7384, 8243);
            Arrays.sort(optima, new Comparator<UnivariatePointValuePair>() {
                public int compare(final UnivariatePointValuePair o1, final UnivariatePointValuePair o2) {
                    MethodContext _bcornu_methode_context4844 = new MethodContext(int.class, 189, 7650, 8221);
                    try {
                        CallChecker.varInit(this, "this", 189, 7650, 8221);
                        CallChecker.varInit(o2, "o2", 189, 7650, 8221);
                        CallChecker.varInit(o1, "o1", 189, 7650, 8221);
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
                        
                        final double v1 = CallChecker.varInit(((double) (CallChecker.isCalled(o1, UnivariatePointValuePair.class, 196, 8007, 8008).getValue())), "v1", 196, 7989, 8020);
                        final double v2 = CallChecker.varInit(((double) (CallChecker.isCalled(o2, UnivariatePointValuePair.class, 197, 8060, 8061).getValue())), "v2", 197, 8042, 8073);
                        if (goal == (GoalType.MINIMIZE)) {
                            return Double.compare(v1, v2);
                        }else {
                            return Double.compare(v2, v1);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context4844.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4845.methodEnd();
        }
    }
}

