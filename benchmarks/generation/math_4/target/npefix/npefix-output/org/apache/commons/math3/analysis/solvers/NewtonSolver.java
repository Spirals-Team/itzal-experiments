package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class NewtonSolver extends AbstractDifferentiableUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public NewtonSolver() {
        this(NewtonSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context1199 = new ConstructorContext(NewtonSolver.class, 41, 1560, 1672);
        try {
        } finally {
            _bcornu_methode_context1199.methodEnd();
        }
    }

    public NewtonSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1200 = new ConstructorContext(NewtonSolver.class, 49, 1678, 1862);
        try {
        } finally {
            _bcornu_methode_context1200.methodEnd();
        }
    }

    @Override
    public double solve(int maxEval, final DifferentiableUnivariateFunction f, final double min, final double max) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5382 = new MethodContext(double.class, 67, 1869, 2714);
        try {
            CallChecker.varInit(this, "this", 67, 1869, 2714);
            CallChecker.varInit(max, "max", 67, 1869, 2714);
            CallChecker.varInit(min, "min", 67, 1869, 2714);
            CallChecker.varInit(f, "f", 67, 1869, 2714);
            CallChecker.varInit(maxEval, "maxEval", 67, 1869, 2714);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.NewtonSolver.DEFAULT_ABSOLUTE_ACCURACY", 67, 1869, 2714);
            return super.solve(maxEval, f, UnivariateSolverUtils.midpoint(min, max));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5382.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5383 = new MethodContext(double.class, 77, 2721, 3260);
        try {
            CallChecker.varInit(this, "this", 77, 2721, 3260);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.NewtonSolver.DEFAULT_ABSOLUTE_ACCURACY", 77, 2721, 3260);
            final double startValue = CallChecker.varInit(((double) (getStartValue())), "startValue", 79, 2852, 2893);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 80, 2903, 2956);
            double x0 = CallChecker.varInit(((double) (startValue)), "x0", 82, 2967, 2989);
            double x1 = CallChecker.init(double.class);
            while (true) {
                x1 = x0 - ((computeObjectiveValue(x0)) / (computeDerivativeObjectiveValue(x0)));
                CallChecker.varAssign(x1, "x1", 85, 3045, 3120);
                if ((FastMath.abs((x1 - x0))) <= absoluteAccuracy) {
                    return x1;
                }
                x0 = x1;
                CallChecker.varAssign(x0, "x0", 90, 3237, 3244);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5383.methodEnd();
        }
    }
}

