package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.util.Incrementor;

public abstract class BaseOptimizer<PAIR> {
    private static class MaxEvalCallback implements Incrementor.MaxCountExceededCallback {
        public void trigger(int max) {
            MethodContext _bcornu_methode_context5569 = new MethodContext(void.class, 212, 6965, 7157);
            try {
                CallChecker.varInit(this, "this", 212, 6965, 7157);
                CallChecker.varInit(max, "max", 212, 6965, 7157);
                throw new TooManyEvaluationsException(max);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5569.methodEnd();
            }
        }
    }

    private static class MaxIterCallback implements Incrementor.MaxCountExceededCallback {
        public void trigger(int max) {
            MethodContext _bcornu_methode_context5570 = new MethodContext(void.class, 227, 7382, 7572);
            try {
                CallChecker.varInit(this, "this", 227, 7382, 7572);
                CallChecker.varInit(max, "max", 227, 7382, 7572);
                throw new TooManyIterationsException(max);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5570.methodEnd();
            }
        }
    }

    protected final Incrementor evaluations;

    protected final Incrementor iterations;

    private ConvergenceChecker<PAIR> checker;

    protected BaseOptimizer(ConvergenceChecker<PAIR> checker) {
        ConstructorContext _bcornu_methode_context1241 = new ConstructorContext(BaseOptimizer.class, 47, 1722, 2023);
        try {
            this.checker = checker;
            CallChecker.varAssign(this.checker, "this.checker", 48, 1849, 1871);
            evaluations = new Incrementor(0, new BaseOptimizer.MaxEvalCallback());
            CallChecker.varAssign(this.evaluations, "this.evaluations", 50, 1882, 1937);
            iterations = new Incrementor(Integer.MAX_VALUE, new BaseOptimizer.MaxIterCallback());
            CallChecker.varAssign(this.iterations, "this.iterations", 51, 1947, 2017);
        } finally {
            _bcornu_methode_context1241.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context5571 = new MethodContext(int.class, 59, 2030, 2251);
        try {
            CallChecker.varInit(this, "this", 59, 2030, 2251);
            CallChecker.varInit(this.checker, "checker", 59, 2030, 2251);
            CallChecker.varInit(this.iterations, "iterations", 59, 2030, 2251);
            CallChecker.varInit(this.evaluations, "evaluations", 59, 2030, 2251);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 60, 2216, 2226)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 60, 2216, 2226).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5571.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context5572 = new MethodContext(int.class, 71, 2258, 2642);
        try {
            CallChecker.varInit(this, "this", 71, 2258, 2642);
            CallChecker.varInit(this.checker, "checker", 71, 2258, 2642);
            CallChecker.varInit(this.iterations, "iterations", 71, 2258, 2642);
            CallChecker.varInit(this.evaluations, "evaluations", 71, 2258, 2642);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 72, 2614, 2624)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 72, 2614, 2624).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5572.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context5573 = new MethodContext(int.class, 80, 2649, 2848);
        try {
            CallChecker.varInit(this, "this", 80, 2649, 2848);
            CallChecker.varInit(this.checker, "checker", 80, 2649, 2848);
            CallChecker.varInit(this.iterations, "iterations", 80, 2649, 2848);
            CallChecker.varInit(this.evaluations, "evaluations", 80, 2649, 2848);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 81, 2814, 2823)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 81, 2814, 2823).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5573.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context5574 = new MethodContext(int.class, 92, 2855, 3233);
        try {
            CallChecker.varInit(this, "this", 92, 2855, 3233);
            CallChecker.varInit(this.checker, "checker", 92, 2855, 3233);
            CallChecker.varInit(this.iterations, "iterations", 92, 2855, 3233);
            CallChecker.varInit(this.evaluations, "evaluations", 92, 2855, 3233);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 93, 3206, 3215)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 93, 3206, 3215).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5574.methodEnd();
        }
    }

    public ConvergenceChecker<PAIR> getConvergenceChecker() {
        MethodContext _bcornu_methode_context5575 = new MethodContext(ConvergenceChecker.class, 101, 3240, 3443);
        try {
            CallChecker.varInit(this, "this", 101, 3240, 3443);
            CallChecker.varInit(this.checker, "checker", 101, 3240, 3443);
            CallChecker.varInit(this.iterations, "iterations", 101, 3240, 3443);
            CallChecker.varInit(this.evaluations, "evaluations", 101, 3240, 3443);
            return checker;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<PAIR>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5575.methodEnd();
        }
    }

    public PAIR optimize(OptimizationData... optData) throws TooManyEvaluationsException, TooManyIterationsException {
        MethodContext _bcornu_methode_context5576 = new MethodContext(null, 133, 3450, 5061);
        try {
            CallChecker.varInit(this, "this", 133, 3450, 5061);
            CallChecker.varInit(optData, "optData", 133, 3450, 5061);
            CallChecker.varInit(this.checker, "checker", 133, 3450, 5061);
            CallChecker.varInit(this.iterations, "iterations", 133, 3450, 5061);
            CallChecker.varInit(this.evaluations, "evaluations", 133, 3450, 5061);
            parseOptimizationData(optData);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 140, 4936, 4946)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 140, 4936, 4946).resetCount();
            }
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 141, 4970, 4979)) {
                CallChecker.isCalled(iterations, Incrementor.class, 141, 4970, 4979).resetCount();
            }
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PAIR) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5576.methodEnd();
        }
    }

    protected abstract PAIR doOptimize();

    protected void incrementEvaluationCount() throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5578 = new MethodContext(void.class, 160, 5285, 5574);
        try {
            CallChecker.varInit(this, "this", 160, 5285, 5574);
            CallChecker.varInit(this.checker, "checker", 160, 5285, 5574);
            CallChecker.varInit(this.iterations, "iterations", 160, 5285, 5574);
            CallChecker.varInit(this.evaluations, "evaluations", 160, 5285, 5574);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 162, 5540, 5550)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 162, 5540, 5550).incrementCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5578.methodEnd();
        }
    }

    protected void incrementIterationCount() throws TooManyIterationsException {
        MethodContext _bcornu_methode_context5579 = new MethodContext(void.class, 171, 5581, 5864);
        try {
            CallChecker.varInit(this, "this", 171, 5581, 5864);
            CallChecker.varInit(this.checker, "checker", 171, 5581, 5864);
            CallChecker.varInit(this.iterations, "iterations", 171, 5581, 5864);
            CallChecker.varInit(this.evaluations, "evaluations", 171, 5581, 5864);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 173, 5831, 5840)) {
                CallChecker.isCalled(iterations, Incrementor.class, 173, 5831, 5840).incrementCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5579.methodEnd();
        }
    }

    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context5580 = new MethodContext(void.class, 187, 5871, 6745);
        try {
            CallChecker.varInit(this, "this", 187, 5871, 6745);
            CallChecker.varInit(optData, "optData", 187, 5871, 6745);
            CallChecker.varInit(this.checker, "checker", 187, 5871, 6745);
            CallChecker.varInit(this.iterations, "iterations", 187, 5871, 6745);
            CallChecker.varInit(this.evaluations, "evaluations", 187, 5871, 6745);
            if (CallChecker.beforeDeref(optData, void.class, 190, 6403, 6409)) {
                for (OptimizationData data : optData) {
                    if (data instanceof MaxEval) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 192, 6512, 6515)) {
                            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 192, 6473, 6483)) {
                                CallChecker.isCalled(evaluations, Incrementor.class, 192, 6473, 6483).setMaximalCount(CallChecker.isCalled(((MaxEval) (data)), MaxEval.class, 192, 6512, 6515).getMaxEval());
                            }
                        }
                        continue;
                    }
                    if (data instanceof MaxIter) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 196, 6670, 6673)) {
                            if (CallChecker.beforeDeref(iterations, Incrementor.class, 196, 6632, 6641)) {
                                CallChecker.isCalled(iterations, Incrementor.class, 196, 6632, 6641).setMaximalCount(CallChecker.isCalled(((MaxIter) (data)), MaxIter.class, 196, 6670, 6673).getMaxIter());
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5580.methodEnd();
        }
    }
}

