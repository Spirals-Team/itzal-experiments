package org.apache.commons.math.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math.ConvergingAlgorithmImpl;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.analysis.UnivariateRealFunction;

public class BisectionSolver extends UnivariateRealSolverImpl {
    @Deprecated
    public BisectionSolver(UnivariateRealFunction f) {
        super(f, 100, 1.0E-6);
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(BisectionSolver.class, 43, 1435, 1900);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public BisectionSolver() {
        super(100, 1.0E-6);
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(BisectionSolver.class, 51, 1907, 2014);
        try {
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    @Deprecated
    public double solve(double min, double max, double initial) throws FunctionEvaluationException, MaxIterationsExceededException {
        MethodContext _bcornu_methode_context1 = new MethodContext(double.class, 57, 2021, 2238);
        try {
            CallChecker.varInit(this, "this", 57, 2021, 2238);
            CallChecker.varInit(initial, "initial", 57, 2021, 2238);
            CallChecker.varInit(max, "max", 57, 2021, 2238);
            CallChecker.varInit(min, "min", 57, 2021, 2238);
            return solve(f, min, max);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    @Deprecated
    public double solve(double min, double max) throws FunctionEvaluationException, MaxIterationsExceededException {
        MethodContext _bcornu_methode_context2 = new MethodContext(double.class, 64, 2245, 2446);
        try {
            CallChecker.varInit(this, "this", 64, 2245, 2446);
            CallChecker.varInit(max, "max", 64, 2245, 2446);
            CallChecker.varInit(min, "min", 64, 2245, 2446);
            return solve(f, min, max);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public double solve(final UnivariateRealFunction f, double min, double max, double initial) throws FunctionEvaluationException, MaxIterationsExceededException {
        MethodContext _bcornu_methode_context3 = new MethodContext(double.class, 70, 2453, 2683);
        try {
            CallChecker.varInit(this, "this", 70, 2453, 2683);
            CallChecker.varInit(initial, "initial", 70, 2453, 2683);
            CallChecker.varInit(max, "max", 70, 2453, 2683);
            CallChecker.varInit(min, "min", 70, 2453, 2683);
            CallChecker.varInit(f, "f", 70, 2453, 2683);
            return solve(min, max);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public double solve(final UnivariateRealFunction f, double min, double max) throws FunctionEvaluationException, MaxIterationsExceededException {
        MethodContext _bcornu_methode_context4 = new MethodContext(double.class, 76, 2690, 3688);
        try {
            CallChecker.varInit(this, "this", 76, 2690, 3688);
            CallChecker.varInit(max, "max", 76, 2690, 3688);
            CallChecker.varInit(min, "min", 76, 2690, 3688);
            CallChecker.varInit(f, "f", 76, 2690, 3688);
            clearResult();
            verifyInterval(min, max);
            double m = CallChecker.init(double.class);
            double fm = CallChecker.init(double.class);
            double fmin = CallChecker.init(double.class);
            int i = CallChecker.varInit(((int) (0)), "i", 85, 2992, 3001);
            while (i < (maximalIterationCount)) {
                m = UnivariateRealSolverUtils.midpoint(min, max);
                CallChecker.varAssign(m, "m", 87, 3059, 3107);
                if (CallChecker.beforeDeref(f, UnivariateRealFunction.class, 88, 3127, 3127)) {
                    fmin = CallChecker.isCalled(f, UnivariateRealFunction.class, 88, 3127, 3127).value(min);
                    CallChecker.varAssign(fmin, "fmin", 88, 3120, 3139);
                }
                if (CallChecker.beforeDeref(f, UnivariateRealFunction.class, 89, 3157, 3157)) {
                    fm = CallChecker.isCalled(f, UnivariateRealFunction.class, 89, 3157, 3157).value(m);
                    CallChecker.varAssign(fm, "fm", 89, 3152, 3167);
                }
                if ((fm * fmin) > 0.0) {
                    min = m;
                    CallChecker.varAssign(min, "min", 93, 3268, 3275);
                }else {
                    max = m;
                    CallChecker.varAssign(max, "max", 96, 3361, 3368);
                }
                if ((Math.abs((max - min))) <= (absoluteAccuracy)) {
                    m = UnivariateRealSolverUtils.midpoint(min, max);
                    CallChecker.varAssign(m, "m", 100, 3460, 3508);
                    setResult(m, i);
                    return m;
                }
                ++i;
            } 
            throw new MaxIterationsExceededException(maximalIterationCount);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }
}

