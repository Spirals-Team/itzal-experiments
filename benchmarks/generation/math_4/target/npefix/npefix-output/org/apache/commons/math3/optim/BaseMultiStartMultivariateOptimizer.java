package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.random.RandomVectorGenerator;

public abstract class BaseMultiStartMultivariateOptimizer<PAIR> extends BaseMultivariateOptimizer<PAIR> {
    private final BaseMultivariateOptimizer<PAIR> optimizer;

    private int totalEvaluations;

    private int starts;

    private RandomVectorGenerator generator;

    private OptimizationData[] optimData;

    private int maxEvalIndex = -1;

    private int initialGuessIndex = -1;

    public BaseMultiStartMultivariateOptimizer(final BaseMultivariateOptimizer<PAIR> optimizer, final int starts, final RandomVectorGenerator generator) {
        super(CallChecker.isCalled(optimizer, BaseMultivariateOptimizer.class, 82, 3765, 3773).getConvergenceChecker());
        ConstructorContext _bcornu_methode_context966 = new ConstructorContext(BaseMultiStartMultivariateOptimizer.class, 79, 2407, 4005);
        try {
            if (starts < 1) {
                throw new NotStrictlyPositiveException(starts);
            }
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 88, 3907, 3933);
            this.starts = starts;
            CallChecker.varAssign(this.starts, "this.starts", 89, 3943, 3963);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 90, 3973, 3999);
        } finally {
            _bcornu_methode_context966.methodEnd();
        }
    }

    @Override
    public int getEvaluations() {
        MethodContext _bcornu_methode_context4353 = new MethodContext(int.class, 95, 4012, 4118);
        try {
            CallChecker.varInit(this, "this", 95, 4012, 4118);
            CallChecker.varInit(this.iterations, "iterations", 95, 4012, 4118);
            CallChecker.varInit(this.evaluations, "evaluations", 95, 4012, 4118);
            CallChecker.varInit(this.initialGuessIndex, "initialGuessIndex", 95, 4012, 4118);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 95, 4012, 4118);
            CallChecker.varInit(this.optimData, "optimData", 95, 4012, 4118);
            CallChecker.varInit(this.generator, "generator", 95, 4012, 4118);
            CallChecker.varInit(this.starts, "starts", 95, 4012, 4118);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 95, 4012, 4118);
            CallChecker.varInit(this.optimizer, "optimizer", 95, 4012, 4118);
            return totalEvaluations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4353.methodEnd();
        }
    }

    public abstract PAIR[] getOptima();

    @Override
    public PAIR optimize(OptimizationData... optData) {
        MethodContext _bcornu_methode_context4355 = new MethodContext(null, 131, 5432, 5885);
        try {
            CallChecker.varInit(this, "this", 131, 5432, 5885);
            CallChecker.varInit(optData, "optData", 131, 5432, 5885);
            CallChecker.varInit(this.iterations, "iterations", 131, 5432, 5885);
            CallChecker.varInit(this.evaluations, "evaluations", 131, 5432, 5885);
            CallChecker.varInit(this.initialGuessIndex, "initialGuessIndex", 131, 5432, 5885);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 131, 5432, 5885);
            CallChecker.varInit(this.optimData, "optimData", 131, 5432, 5885);
            CallChecker.varInit(this.generator, "generator", 131, 5432, 5885);
            CallChecker.varInit(this.starts, "starts", 131, 5432, 5885);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 131, 5432, 5885);
            CallChecker.varInit(this.optimizer, "optimizer", 131, 5432, 5885);
            optimData = optData;
            CallChecker.varAssign(this.optimData, "this.optimData", 133, 5765, 5784);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PAIR) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4355.methodEnd();
        }
    }

    @Override
    protected PAIR doOptimize() {
        MethodContext _bcornu_methode_context4356 = new MethodContext(null, 140, 5892, 8944);
        try {
            CallChecker.varInit(this, "this", 140, 5892, 8944);
            CallChecker.varInit(this.iterations, "iterations", 140, 5892, 8944);
            CallChecker.varInit(this.evaluations, "evaluations", 140, 5892, 8944);
            CallChecker.varInit(this.initialGuessIndex, "initialGuessIndex", 140, 5892, 8944);
            CallChecker.varInit(this.maxEvalIndex, "maxEvalIndex", 140, 5892, 8944);
            CallChecker.varInit(this.optimData, "optimData", 140, 5892, 8944);
            CallChecker.varInit(this.generator, "generator", 140, 5892, 8944);
            CallChecker.varInit(this.starts, "starts", 140, 5892, 8944);
            CallChecker.varInit(this.totalEvaluations, "totalEvaluations", 140, 5892, 8944);
            CallChecker.varInit(this.optimizer, "optimizer", 140, 5892, 8944);
            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 146, 6339, 6347);
            for (int i = 0; i < (CallChecker.isCalled(optimData, OptimizationData[].class, 146, 6339, 6347).length); i++) {
                if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 147, 6380, 6388)) {
                    optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 147, 6380, 6388);
                    if ((CallChecker.isCalled(optimData, OptimizationData[].class, 147, 6380, 6388)[i]) instanceof MaxEval) {
                        if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 148, 6431, 6439)) {
                            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 148, 6431, 6439);
                            CallChecker.isCalled(optimData, OptimizationData[].class, 148, 6431, 6439)[i] = null;
                            CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 148, 6431, 6439)[i], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 148, 6431, 6439)[i]", 148, 6431, 6450);
                        }
                        maxEvalIndex = i;
                        CallChecker.varAssign(this.maxEvalIndex, "this.maxEvalIndex", 149, 6468, 6484);
                    }
                }
                if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 151, 6516, 6524)) {
                    optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 151, 6516, 6524);
                    if ((CallChecker.isCalled(optimData, OptimizationData[].class, 151, 6516, 6524)[i]) instanceof InitialGuess) {
                        if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 152, 6572, 6580)) {
                            optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 152, 6572, 6580);
                            CallChecker.isCalled(optimData, OptimizationData[].class, 152, 6572, 6580)[i] = null;
                            CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 152, 6572, 6580)[i], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 152, 6572, 6580)[i]", 152, 6572, 6591);
                        }
                        initialGuessIndex = i;
                        CallChecker.varAssign(this.initialGuessIndex, "this.initialGuessIndex", 153, 6609, 6630);
                        continue;
                    }
                }
            }
            if ((maxEvalIndex) == (-1)) {
                throw new MathIllegalStateException();
            }
            if ((initialGuessIndex) == (-1)) {
                throw new MathIllegalStateException();
            }
            RuntimeException lastException = CallChecker.varInit(null, "lastException", 164, 6886, 6923);
            totalEvaluations = 0;
            CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 165, 6933, 6953);
            clear();
            final int maxEval = CallChecker.varInit(((int) (getMaxEvaluations())), "maxEval", 168, 6981, 7020);
            final double[] min = CallChecker.varInit(getLowerBound(), "min", 169, 7030, 7066);
            final double[] max = CallChecker.varInit(getUpperBound(), "max", 170, 7076, 7112);
            final double[] startPoint = CallChecker.varInit(getStartPoint(), "startPoint", 171, 7122, 7165);
            for (int i = 0; i < (starts); i++) {
                TryContext _bcornu_try_context_93 = new TryContext(93, BaseMultiStartMultivariateOptimizer.class, "java.lang.RuntimeException");
                try {
                    if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 178, 7378, 7386)) {
                        optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 178, 7378, 7386);
                        CallChecker.isCalled(optimData, OptimizationData[].class, 178, 7378, 7386)[maxEvalIndex] = new MaxEval((maxEval - (totalEvaluations)));
                        CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 178, 7378, 7386)[this.maxEvalIndex], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 178, 7378, 7386)[this.maxEvalIndex]", 178, 7378, 7443);
                    }
                    double[] s = CallChecker.varInit(null, "s", 180, 7497, 7514);
                    if (i == 0) {
                        s = startPoint;
                        CallChecker.varAssign(s, "s", 182, 7566, 7580);
                    }else {
                        int attempts = CallChecker.varInit(((int) (0)), "attempts", 184, 7627, 7643);
                        while (s == null) {
                            if ((attempts++) >= (getMaxEvaluations())) {
                                throw new TooManyEvaluationsException(getMaxEvaluations());
                            }
                            if (CallChecker.beforeDeref(generator, RandomVectorGenerator.class, 189, 7892, 7900)) {
                                generator = CallChecker.beforeCalled(generator, RandomVectorGenerator.class, 189, 7892, 7900);
                                s = CallChecker.isCalled(generator, RandomVectorGenerator.class, 189, 7892, 7900).nextVector();
                                CallChecker.varAssign(s, "s", 189, 7888, 7914);
                            }
                            s = CallChecker.beforeCalled(s, double[].class, 190, 7973, 7973);
                            for (int k = 0; (s != null) && (k < (CallChecker.isCalled(s, double[].class, 190, 7973, 7973).length)); ++k) {
                                if (((min != null) && ((s[k]) < (min[k]))) || ((max != null) && ((s[k]) > (max[k])))) {
                                    s = null;
                                    CallChecker.varAssign(s, "s", 193, 8175, 8183);
                                }
                            }
                        } 
                    }
                    if (CallChecker.beforeDeref(optimData, OptimizationData[].class, 198, 8297, 8305)) {
                        optimData = CallChecker.beforeCalled(optimData, OptimizationData[].class, 198, 8297, 8305);
                        CallChecker.isCalled(optimData, OptimizationData[].class, 198, 8297, 8305)[initialGuessIndex] = new InitialGuess(s);
                        CallChecker.varAssign(CallChecker.isCalled(this.optimData, OptimizationData[].class, 198, 8297, 8305)[this.initialGuessIndex], "CallChecker.isCalled(this.optimData, OptimizationData[].class, 198, 8297, 8305)[this.initialGuessIndex]", 198, 8297, 8347);
                    }
                    final PAIR result = CallChecker.varInit(optimizer.optimize(optimData), "result", 200, 8365, 8443);
                    store(result);
                } catch (RuntimeException mue) {
                    _bcornu_try_context_93.catchStart(93);
                    lastException = mue;
                    CallChecker.varAssign(lastException, "lastException", 203, 8537, 8556);
                } finally {
                    _bcornu_try_context_93.finallyStart(93);
                }
                if (CallChecker.beforeDeref(optimizer, BaseMultivariateOptimizer.class, 207, 8652, 8660)) {
                    totalEvaluations += CallChecker.isCalled(optimizer, BaseMultivariateOptimizer.class, 207, 8652, 8660).getEvaluations();
                    CallChecker.varAssign(this.totalEvaluations, "this.totalEvaluations", 207, 8632, 8678);
                }
            }
            final PAIR[] optima = CallChecker.varInit(getOptima(), "optima", 210, 8699, 8732);
            if (CallChecker.beforeDeref(optima, null, 211, 8746, 8751)) {
                if ((CallChecker.isCalled(optima, null, 211, 8746, 8751).length) == 0) {
                    throw lastException;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(optima, null, 217, 8929, 8934)) {
                return optima[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PAIR) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4356.methodEnd();
        }
    }

    protected abstract void store(PAIR optimum);

    protected abstract void clear();
}

