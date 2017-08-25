package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class BaseMultivariateVectorMultiStartOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    private final BaseMultivariateVectorOptimizer<FUNC> optimizer;

    private int maxEvaluations;

    private int totalEvaluations;

    private int starts;

    private RandomVectorGenerator generator;

    private PointVectorValuePair[] optima;

    protected BaseMultivariateVectorMultiStartOptimizer(final BaseMultivariateVectorOptimizer<FUNC> optimizer, final int starts, final RandomVectorGenerator generator) {
        ConstructorContext _bcornu_methode_context105 = new ConstructorContext(BaseMultivariateVectorMultiStartOptimizer.class, 72, 2486, 3719);
        try {
            if ((optimizer == null) || (generator == null)) {
                throw new NullArgumentException();
            }
            if (starts < 1) {
                throw new NotStrictlyPositiveException(starts);
            }
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 83, 3621, 3647);
            this.starts = starts;
            CallChecker.varAssign(this.starts, "this.starts", 84, 3657, 3677);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 85, 3687, 3713);
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public PointVectorValuePair[] getOptima() {
        MethodContext _bcornu_methode_context385 = new MethodContext(PointVectorValuePair[].class, 115, 3726, 5493);
        try {
            CallChecker.varInit(this, "this", 115, 3726, 5493);
            CallChecker.varInit(this.optima, "optima", 115, 3726, 5493);
            CallChecker.varInit(this.generator, "generator", 115, 3726, 5493);
            CallChecker.varInit(this.starts, "starts", 115, 3726, 5493);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 115, 3726, 5493);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 115, 3726, 5493);
            CallChecker.varInit(this.optimizer, "optimizer", 115, 3726, 5493);
            if ((optima) == null) {
                throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET);
            }
            return optima.clone();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context385.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context386 = new MethodContext(int.class, 123, 5500, 5593);
        try {
            CallChecker.varInit(this, "this", 123, 5500, 5593);
            CallChecker.varInit(this.optima, "optima", 123, 5500, 5593);
            CallChecker.varInit(this.generator, "generator", 123, 5500, 5593);
            CallChecker.varInit(this.starts, "starts", 123, 5500, 5593);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 123, 5500, 5593);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 123, 5500, 5593);
            CallChecker.varInit(this.optimizer, "optimizer", 123, 5500, 5593);
            return maxEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context386.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context387 = new MethodContext(int.class, 128, 5600, 5692);
        try {
            CallChecker.varInit(this, "this", 128, 5600, 5692);
            CallChecker.varInit(this.optima, "optima", 128, 5600, 5692);
            CallChecker.varInit(this.generator, "generator", 128, 5600, 5692);
            CallChecker.varInit(this.starts, "starts", 128, 5600, 5692);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 128, 5600, 5692);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 128, 5600, 5692);
            CallChecker.varInit(this.optimizer, "optimizer", 128, 5600, 5692);
            return totalEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context387.methodEnd();
        }
    }

    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context388 = new MethodContext(ConvergenceChecker.class, 133, 5699, 5852);
        try {
            CallChecker.varInit(this, "this", 133, 5699, 5852);
            CallChecker.varInit(this.optima, "optima", 133, 5699, 5852);
            CallChecker.varInit(this.generator, "generator", 133, 5699, 5852);
            CallChecker.varInit(this.starts, "starts", 133, 5699, 5852);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 133, 5699, 5852);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 133, 5699, 5852);
            CallChecker.varInit(this.optimizer, "optimizer", 133, 5699, 5852);
            if (CallChecker.beforeDeref(optimizer, BaseMultivariateVectorOptimizer.class, 134, 5813, 5821)) {
                return CallChecker.isCalled(optimizer, BaseMultivariateVectorOptimizer.class, 134, 5813, 5821).getConvergenceChecker();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<PointVectorValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context388.methodEnd();
        }
    }

    public PointVectorValuePair optimize(int maxEval, final FUNC f, double[] target, double[] weights, double[] startPoint) {
        MethodContext _bcornu_methode_context389 = new MethodContext(PointVectorValuePair.class, 140, 5859, 7176);
        try {
            CallChecker.varInit(this, "this", 140, 5859, 7176);
            CallChecker.varInit(startPoint, "startPoint", 140, 5859, 7176);
            CallChecker.varInit(weights, "weights", 140, 5859, 7176);
            CallChecker.varInit(target, "target", 140, 5859, 7176);
            CallChecker.varInit(f, "f", 140, 5859, 7176);
            CallChecker.varInit(maxEval, "maxEval", 140, 5859, 7176);
            CallChecker.varInit(this.optima, "optima", 140, 5859, 7176);
            CallChecker.varInit(this.generator, "generator", 140, 5859, 7176);
            CallChecker.varInit(this.starts, "starts", 140, 5859, 7176);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 140, 5859, 7176);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 140, 5859, 7176);
            CallChecker.varInit(this.optimizer, "optimizer", 140, 5859, 7176);
            maxEvaluations = maxEval;
            CallChecker.varAssign(this.maxEvaluations, "this.maxEvaluations", 143, 6114, 6138);
            RuntimeException lastException = CallChecker.varInit(null, "lastException", 144, 6148, 6185);
            optima = new PointVectorValuePair[starts];
            CallChecker.varAssign(this.optima, "this.optima", 145, 6195, 6236);
            totalEvaluations = 0;
            CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 146, 6246, 6266);
            for (int i = 0; i < (starts); ++i) {
                TryContext _bcornu_try_context_7 = new TryContext(7, BaseMultivariateVectorMultiStartOptimizer.class, "org.apache.commons.math3.exception.ConvergenceException", "java.lang.RuntimeException");
                try {
                    if (CallChecker.beforeDeref(optima, PointVectorValuePair[].class, 153, 6421, 6426)) {
                        if ((i == 0) || (CallChecker.beforeDeref(generator, RandomVectorGenerator.class, 154, 6569, 6577))) {
                            if (CallChecker.beforeDeref(optimizer, BaseMultivariateVectorOptimizer.class, 153, 6433, 6441)) {
                                optima = CallChecker.beforeCalled(optima, PointVectorValuePair[].class, 153, 6421, 6426);
                                generator = CallChecker.beforeCalled(generator, RandomVectorGenerator.class, 154, 6569, 6577);
                                CallChecker.isCalled(optima, PointVectorValuePair[].class, 153, 6421, 6426)[i] = CallChecker.isCalled(optimizer, BaseMultivariateVectorOptimizer.class, 153, 6433, 6441).optimize((maxEval - (totalEvaluations)), f, target, weights, ((i == 0) ? startPoint : CallChecker.isCalled(generator, RandomVectorGenerator.class, 154, 6569, 6577).nextVector()));
                                CallChecker.varAssign(CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 153, 6421, 6426)[i], "CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 153, 6421, 6426)[i]", 153, 6421, 6592);
                            }
                        }
                    }
                } catch (ConvergenceException oe) {
                    _bcornu_try_context_7.catchStart(7);
                    if (CallChecker.beforeDeref(optima, PointVectorValuePair[].class, 156, 6658, 6663)) {
                        optima = CallChecker.beforeCalled(optima, PointVectorValuePair[].class, 156, 6658, 6663);
                        CallChecker.isCalled(optima, PointVectorValuePair[].class, 156, 6658, 6663)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 156, 6658, 6663)[i], "CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 156, 6658, 6663)[i]", 156, 6658, 6674);
                    }
                } catch (RuntimeException mue) {
                    _bcornu_try_context_7.catchStart(7);
                    lastException = mue;
                    CallChecker.varAssign(lastException, "lastException", 158, 6737, 6756);
                    if (CallChecker.beforeDeref(optima, PointVectorValuePair[].class, 159, 6774, 6779)) {
                        optima = CallChecker.beforeCalled(optima, PointVectorValuePair[].class, 159, 6774, 6779);
                        CallChecker.isCalled(optima, PointVectorValuePair[].class, 159, 6774, 6779)[i] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 159, 6774, 6779)[i], "CallChecker.isCalled(this.optima, PointVectorValuePair[].class, 159, 6774, 6779)[i]", 159, 6774, 6790);
                    }
                } finally {
                    _bcornu_try_context_7.finallyStart(7);
                }
                if (CallChecker.beforeDeref(optimizer, BaseMultivariateVectorOptimizer.class, 163, 6886, 6894)) {
                    totalEvaluations += CallChecker.isCalled(optimizer, BaseMultivariateVectorOptimizer.class, 163, 6886, 6894).getEvaluations();
                    CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 163, 6866, 6912);
                }
            }
            sortPairs(target, weights);
            if (CallChecker.beforeDeref(optima, PointVectorValuePair[].class, 168, 6974, 6979)) {
                optima = CallChecker.beforeCalled(optima, PointVectorValuePair[].class, 168, 6974, 6979);
                if ((CallChecker.isCalled(optima, PointVectorValuePair[].class, 168, 6974, 6979)[0]) == null) {
                    throw lastException;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(optima, PointVectorValuePair[].class, 173, 7161, 7166)) {
                optima = CallChecker.beforeCalled(optima, PointVectorValuePair[].class, 173, 7161, 7166);
                return CallChecker.isCalled(optima, PointVectorValuePair[].class, 173, 7161, 7166)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context389.methodEnd();
        }
    }

    private void sortPairs(final double[] target, final double[] weights) {
        MethodContext _bcornu_methode_context392 = new MethodContext(void.class, 182, 7183, 8476);
        try {
            CallChecker.varInit(this, "this", 182, 7183, 8476);
            CallChecker.varInit(weights, "weights", 182, 7183, 8476);
            CallChecker.varInit(target, "target", 182, 7183, 8476);
            CallChecker.varInit(this.optima, "optima", 182, 7183, 8476);
            CallChecker.varInit(this.generator, "generator", 182, 7183, 8476);
            CallChecker.varInit(this.starts, "starts", 182, 7183, 8476);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 182, 7183, 8476);
            CallChecker.varInit(this.maxEvaluations, "maxEvaluations", 182, 7183, 8476);
            CallChecker.varInit(this.optimizer, "optimizer", 182, 7183, 8476);
            Arrays.sort(optima, new Comparator<PointVectorValuePair>() {
                public int compare(final PointVectorValuePair o1, final PointVectorValuePair o2) {
                    MethodContext _bcornu_methode_context390 = new MethodContext(int.class, 185, 7612, 8026);
                    try {
                        CallChecker.varInit(this, "this", 185, 7612, 8026);
                        CallChecker.varInit(o2, "o2", 185, 7612, 8026);
                        CallChecker.varInit(o1, "o1", 185, 7612, 8026);
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
                        
                        return Double.compare(weightedResidual(o1), weightedResidual(o2));
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context390.methodEnd();
                    }
                }

                private double weightedResidual(final PointVectorValuePair pv) {
                    MethodContext _bcornu_methode_context391 = new MethodContext(double.class, 194, 8044, 8454);
                    try {
                        CallChecker.varInit(this, "this", 194, 8044, 8454);
                        CallChecker.varInit(pv, "pv", 194, 8044, 8454);
                        final double[] value = CallChecker.varInit(CallChecker.isCalled(pv, PointVectorValuePair.class, 195, 8152, 8153).getValueRef(), "value", 195, 8129, 8168);
                        double sum = CallChecker.varInit(((double) (0)), "sum", 196, 8190, 8204);
                        for (int i = 0; i < (CallChecker.isCalled(value, double[].class, 197, 8246, 8250).length); ++i) {
                            final double ri = CallChecker.varInit(((double) ((CallChecker.isCalled(value, double[].class, 198, 8309, 8313)[i]) - (CallChecker.isCalled(target, double[].class, 198, 8320, 8325)[i]))), "ri", 198, 8291, 8329);
                            if (CallChecker.beforeDeref(weights, double[].class, 199, 8362, 8368)) {
                                sum += ((CallChecker.isCalled(weights, double[].class, 199, 8362, 8368)[i]) * ri) * ri;
                                CallChecker.varAssign(sum, "sum", 199, 8355, 8382);
                            }
                        }
                        return sum;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context391.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context392.methodEnd();
        }
    }
}

