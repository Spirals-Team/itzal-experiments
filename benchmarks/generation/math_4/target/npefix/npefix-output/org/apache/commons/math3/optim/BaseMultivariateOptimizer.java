package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public abstract class BaseMultivariateOptimizer<PAIR> extends BaseOptimizer<PAIR> {
    private double[] start;

    private double[] lowerBound;

    private double[] upperBound;

    protected BaseMultivariateOptimizer(ConvergenceChecker<PAIR> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context710 = new ConstructorContext(BaseMultivariateOptimizer.class, 47, 1643, 1802);
        try {
        } finally {
            _bcornu_methode_context710.methodEnd();
        }
    }

    @Override
    public PAIR optimize(OptimizationData... optData) {
        MethodContext _bcornu_methode_context3131 = new MethodContext(null, 64, 1809, 2341);
        try {
            CallChecker.varInit(this, "this", 64, 1809, 2341);
            CallChecker.varInit(optData, "optData", 64, 1809, 2341);
            CallChecker.varInit(this.iterations, "iterations", 64, 1809, 2341);
            CallChecker.varInit(this.evaluations, "evaluations", 64, 1809, 2341);
            CallChecker.varInit(this.upperBound, "upperBound", 64, 1809, 2341);
            CallChecker.varInit(this.lowerBound, "lowerBound", 64, 1809, 2341);
            CallChecker.varInit(this.start, "start", 64, 1809, 2341);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PAIR) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3131.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context3132 = new MethodContext(void.class, 80, 2348, 3489);
        try {
            CallChecker.varInit(this, "this", 80, 2348, 3489);
            CallChecker.varInit(optData, "optData", 80, 2348, 3489);
            CallChecker.varInit(this.iterations, "iterations", 80, 2348, 3489);
            CallChecker.varInit(this.evaluations, "evaluations", 80, 2348, 3489);
            CallChecker.varInit(this.upperBound, "upperBound", 80, 2348, 3489);
            CallChecker.varInit(this.lowerBound, "lowerBound", 80, 2348, 3489);
            CallChecker.varInit(this.start, "start", 80, 2348, 3489);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 86, 2998, 3004)) {
                for (OptimizationData data : optData) {
                    if (data instanceof InitialGuess) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 88, 3097, 3100)) {
                            start = CallChecker.isCalled(((InitialGuess) (data)), InitialGuess.class, 88, 3097, 3100).getInitialGuess();
                            CallChecker.varAssign(this.start, "this.start", 88, 3073, 3120);
                        }
                        continue;
                    }
                    if (data instanceof SimpleBounds) {
                        final SimpleBounds bounds = CallChecker.varInit(((SimpleBounds) (data)), "bounds", 92, 3226, 3273);
                        if (CallChecker.beforeDeref(bounds, SimpleBounds.class, 93, 3304, 3309)) {
                            lowerBound = CallChecker.isCalled(bounds, SimpleBounds.class, 93, 3304, 3309).getLower();
                            CallChecker.varAssign(this.lowerBound, "this.lowerBound", 93, 3291, 3321);
                        }
                        if (CallChecker.beforeDeref(bounds, SimpleBounds.class, 94, 3352, 3357)) {
                            upperBound = CallChecker.isCalled(bounds, SimpleBounds.class, 94, 3352, 3357).getUpper();
                            CallChecker.varAssign(this.upperBound, "this.upperBound", 94, 3339, 3369);
                        }
                        continue;
                    }
                }
            }
            checkParameters();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3132.methodEnd();
        }
    }

    public double[] getStartPoint() {
        MethodContext _bcornu_methode_context3133 = new MethodContext(double[].class, 108, 3496, 3703);
        try {
            CallChecker.varInit(this, "this", 108, 3496, 3703);
            CallChecker.varInit(this.iterations, "iterations", 108, 3496, 3703);
            CallChecker.varInit(this.evaluations, "evaluations", 108, 3496, 3703);
            CallChecker.varInit(this.upperBound, "upperBound", 108, 3496, 3703);
            CallChecker.varInit(this.lowerBound, "lowerBound", 108, 3496, 3703);
            CallChecker.varInit(this.start, "start", 108, 3496, 3703);
            if ((start) == null) {
                return null;
            }else {
                return start.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3133.methodEnd();
        }
    }

    public double[] getLowerBound() {
        MethodContext _bcornu_methode_context3134 = new MethodContext(double[].class, 114, 3709, 3887);
        try {
            CallChecker.varInit(this, "this", 114, 3709, 3887);
            CallChecker.varInit(this.iterations, "iterations", 114, 3709, 3887);
            CallChecker.varInit(this.evaluations, "evaluations", 114, 3709, 3887);
            CallChecker.varInit(this.upperBound, "upperBound", 114, 3709, 3887);
            CallChecker.varInit(this.lowerBound, "lowerBound", 114, 3709, 3887);
            CallChecker.varInit(this.start, "start", 114, 3709, 3887);
            if ((lowerBound) == null) {
                return null;
            }else {
                return lowerBound.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3134.methodEnd();
        }
    }

    public double[] getUpperBound() {
        MethodContext _bcornu_methode_context3135 = new MethodContext(double[].class, 120, 3893, 4071);
        try {
            CallChecker.varInit(this, "this", 120, 3893, 4071);
            CallChecker.varInit(this.iterations, "iterations", 120, 3893, 4071);
            CallChecker.varInit(this.evaluations, "evaluations", 120, 3893, 4071);
            CallChecker.varInit(this.upperBound, "upperBound", 120, 3893, 4071);
            CallChecker.varInit(this.lowerBound, "lowerBound", 120, 3893, 4071);
            CallChecker.varInit(this.start, "start", 120, 3893, 4071);
            if ((upperBound) == null) {
                return null;
            }else {
                return upperBound.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3135.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context3136 = new MethodContext(void.class, 127, 4078, 5241);
        try {
            CallChecker.varInit(this, "this", 127, 4078, 5241);
            CallChecker.varInit(this.iterations, "iterations", 127, 4078, 5241);
            CallChecker.varInit(this.evaluations, "evaluations", 127, 4078, 5241);
            CallChecker.varInit(this.upperBound, "upperBound", 127, 4078, 5241);
            CallChecker.varInit(this.lowerBound, "lowerBound", 127, 4078, 5241);
            CallChecker.varInit(this.start, "start", 127, 4078, 5241);
            if ((start) != null) {
                start = CallChecker.beforeCalled(start, double[].class, 129, 4221, 4225);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(this.start, double[].class, 129, 4221, 4225).length)), "dim", 129, 4205, 4233);
                if ((lowerBound) != null) {
                    if (CallChecker.beforeDeref(lowerBound, double[].class, 131, 4293, 4302)) {
                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 131, 4293, 4302);
                        if ((CallChecker.isCalled(lowerBound, double[].class, 131, 4293, 4302).length) != dim) {
                            if (CallChecker.beforeDeref(lowerBound, double[].class, 132, 4378, 4387)) {
                                lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 132, 4378, 4387);
                                throw new DimensionMismatchException(CallChecker.isCalled(lowerBound, double[].class, 132, 4378, 4387).length, dim);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        final double v = CallChecker.varInit(((double) (this.start[i])), "v", 135, 4489, 4514);
                        final double lo = CallChecker.varInit(((double) (this.lowerBound[i])), "lo", 136, 4536, 4567);
                        if (v < lo) {
                            throw new NumberIsTooSmallException(v, lo, true);
                        }
                    }
                }
                if ((upperBound) != null) {
                    if (CallChecker.beforeDeref(upperBound, double[].class, 143, 4789, 4798)) {
                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 143, 4789, 4798);
                        if ((CallChecker.isCalled(upperBound, double[].class, 143, 4789, 4798).length) != dim) {
                            if (CallChecker.beforeDeref(upperBound, double[].class, 144, 4874, 4883)) {
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 144, 4874, 4883);
                                throw new DimensionMismatchException(CallChecker.isCalled(upperBound, double[].class, 144, 4874, 4883).length, dim);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        final double v = CallChecker.varInit(((double) (this.start[i])), "v", 147, 4985, 5010);
                        final double hi = CallChecker.varInit(((double) (this.upperBound[i])), "hi", 148, 5032, 5063);
                        if (v > hi) {
                            throw new NumberIsTooLargeException(v, hi, true);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3136.methodEnd();
        }
    }
}

