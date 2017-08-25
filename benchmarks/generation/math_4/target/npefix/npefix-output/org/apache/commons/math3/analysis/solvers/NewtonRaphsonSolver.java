package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class NewtonRaphsonSolver extends AbstractUnivariateDifferentiableSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public NewtonRaphsonSolver() {
        this(NewtonRaphsonSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context490 = new ConstructorContext(NewtonRaphsonSolver.class, 40, 1539, 1658);
        try {
        } finally {
            _bcornu_methode_context490.methodEnd();
        }
    }

    public NewtonRaphsonSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context491 = new ConstructorContext(NewtonRaphsonSolver.class, 48, 1664, 1855);
        try {
        } finally {
            _bcornu_methode_context491.methodEnd();
        }
    }

    @Override
    public double solve(int maxEval, final UnivariateDifferentiableFunction f, final double min, final double max) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2245 = new MethodContext(double.class, 66, 1862, 2707);
        try {
            CallChecker.varInit(this, "this", 66, 1862, 2707);
            CallChecker.varInit(max, "max", 66, 1862, 2707);
            CallChecker.varInit(min, "min", 66, 1862, 2707);
            CallChecker.varInit(f, "f", 66, 1862, 2707);
            CallChecker.varInit(maxEval, "maxEval", 66, 1862, 2707);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver.DEFAULT_ABSOLUTE_ACCURACY", 66, 1862, 2707);
            return super.solve(maxEval, f, UnivariateSolverUtils.midpoint(min, max));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2245.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2246 = new MethodContext(double.class, 76, 2714, 3315);
        try {
            CallChecker.varInit(this, "this", 76, 2714, 3315);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver.DEFAULT_ABSOLUTE_ACCURACY", 76, 2714, 3315);
            final double startValue = CallChecker.varInit(((double) (getStartValue())), "startValue", 78, 2845, 2886);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 79, 2896, 2949);
            double x0 = CallChecker.varInit(((double) (startValue)), "x0", 81, 2960, 2982);
            double x1 = CallChecker.init(double.class);
            while (true) {
                final DerivativeStructure y0 = CallChecker.varInit(computeObjectiveValueAndDerivative(x0), "y0", 84, 3038, 3107);
                if (CallChecker.beforeDeref(y0, DerivativeStructure.class, 85, 3132, 3133)) {
                    if (CallChecker.beforeDeref(y0, DerivativeStructure.class, 85, 3148, 3149)) {
                        x1 = x0 - ((CallChecker.isCalled(y0, DerivativeStructure.class, 85, 3132, 3133).getValue()) / (CallChecker.isCalled(y0, DerivativeStructure.class, 85, 3148, 3149).getPartialDerivative(1)));
                        CallChecker.varAssign(x1, "x1", 85, 3121, 3175);
                    }
                }
                if ((FastMath.abs((x1 - x0))) <= absoluteAccuracy) {
                    return x1;
                }
                x0 = x1;
                CallChecker.varAssign(x0, "x0", 90, 3292, 3299);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2246.methodEnd();
        }
    }
}

