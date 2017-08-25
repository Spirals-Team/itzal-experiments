package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class SecantSolver extends AbstractUnivariateSolver {
    protected static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public SecantSolver() {
        super(SecantSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context1019 = new ConstructorContext(SecantSolver.class, 49, 2091, 2221);
        try {
        } finally {
            _bcornu_methode_context1019.methodEnd();
        }
    }

    public SecantSolver(final double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1020 = new ConstructorContext(SecantSolver.class, 58, 2228, 2417);
        try {
        } finally {
            _bcornu_methode_context1020.methodEnd();
        }
    }

    public SecantSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context1021 = new ConstructorContext(SecantSolver.class, 68, 2424, 2735);
        try {
        } finally {
            _bcornu_methode_context1021.methodEnd();
        }
    }

    @Override
    protected final double doSolve() throws NoBracketingException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4557 = new MethodContext(double.class, 75, 2742, 4918);
        try {
            CallChecker.varInit(this, "this", 75, 2742, 4918);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.SecantSolver.DEFAULT_ABSOLUTE_ACCURACY", 75, 2742, 4918);
            double x0 = CallChecker.varInit(((double) (getMin())), "x0", 79, 2937, 2957);
            double x1 = CallChecker.varInit(((double) (getMax())), "x1", 80, 2967, 2987);
            double f0 = CallChecker.varInit(((double) (computeObjectiveValue(x0))), "f0", 81, 2997, 3034);
            double f1 = CallChecker.varInit(((double) (computeObjectiveValue(x1))), "f1", 82, 3044, 3081);
            if (f0 == 0.0) {
                return x0;
            }
            if (f1 == 0.0) {
                return x1;
            }
            verifyBracketing(x0, x1);
            final double ftol = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "ftol", 98, 3499, 3572);
            final double atol = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "atol", 99, 3582, 3623);
            final double rtol = CallChecker.varInit(((double) (getRelativeAccuracy())), "rtol", 100, 3633, 3674);
            while (true) {
                final double x = CallChecker.varInit(((double) (x1 - ((f1 * (x1 - x0)) / (f1 - f0)))), "x", 105, 3759, 3860);
                final double fx = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fx", 106, 3874, 3916);
                if (fx == 0.0) {
                    return x;
                }
                x0 = x1;
                CallChecker.varAssign(x0, "x0", 116, 4283, 4290);
                f0 = f1;
                CallChecker.varAssign(f0, "f0", 117, 4304, 4311);
                x1 = x;
                CallChecker.varAssign(x1, "x1", 118, 4325, 4331);
                f1 = fx;
                CallChecker.varAssign(f1, "f1", 119, 4345, 4352);
                if ((FastMath.abs(f1)) <= ftol) {
                    return x1;
                }
                if ((FastMath.abs((x1 - x0))) < (FastMath.max((rtol * (FastMath.abs(x1))), atol))) {
                    return x1;
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4557.methodEnd();
        }
    }
}

