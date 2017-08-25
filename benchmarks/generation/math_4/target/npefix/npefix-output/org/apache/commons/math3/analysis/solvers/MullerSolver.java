package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class MullerSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public MullerSolver() {
        this(MullerSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context633 = new ConstructorContext(MullerSolver.class, 58, 2459, 2600);
        try {
        } finally {
            _bcornu_methode_context633.methodEnd();
        }
    }

    public MullerSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context634 = new ConstructorContext(MullerSolver.class, 66, 2606, 2790);
        try {
        } finally {
            _bcornu_methode_context634.methodEnd();
        }
    }

    public MullerSolver(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context635 = new ConstructorContext(MullerSolver.class, 75, 2796, 3097);
        try {
        } finally {
            _bcornu_methode_context635.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2798 = new MethodContext(double.class, 84, 3104, 4287);
        try {
            CallChecker.varInit(this, "this", 84, 3104, 4287);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.MullerSolver.DEFAULT_ABSOLUTE_ACCURACY", 84, 3104, 4287);
            final double min = CallChecker.varInit(((double) (getMin())), "min", 88, 3315, 3342);
            final double max = CallChecker.varInit(((double) (getMax())), "max", 89, 3352, 3379);
            final double initial = CallChecker.varInit(((double) (getStartValue())), "initial", 90, 3389, 3427);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 92, 3438, 3501);
            verifySequence(min, initial, max);
            final double fMin = CallChecker.varInit(((double) (computeObjectiveValue(min))), "fMin", 97, 3556, 3657);
            if ((FastMath.abs(fMin)) < functionValueAccuracy) {
                return min;
            }
            final double fMax = CallChecker.varInit(((double) (computeObjectiveValue(max))), "fMax", 101, 3759, 3805);
            if ((FastMath.abs(fMax)) < functionValueAccuracy) {
                return max;
            }
            final double fInitial = CallChecker.varInit(((double) (computeObjectiveValue(initial))), "fInitial", 105, 3907, 3961);
            if ((FastMath.abs(fInitial)) < functionValueAccuracy) {
                return initial;
            }
            verifyBracketing(min, max);
            if (isBracketing(min, initial)) {
                return solve(min, initial, fMin, fInitial);
            }else {
                return solve(initial, max, fInitial, fMax);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2798.methodEnd();
        }
    }

    private double solve(double min, double max, double fMin, double fMax) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2799 = new MethodContext(double.class, 130, 4294, 8134);
        try {
            CallChecker.varInit(this, "this", 130, 4294, 8134);
            CallChecker.varInit(fMax, "fMax", 130, 4294, 8134);
            CallChecker.varInit(fMin, "fMin", 130, 4294, 8134);
            CallChecker.varInit(max, "max", 130, 4294, 8134);
            CallChecker.varInit(min, "min", 130, 4294, 8134);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.MullerSolver.DEFAULT_ABSOLUTE_ACCURACY", 130, 4294, 8134);
            final double relativeAccuracy = CallChecker.varInit(((double) (getRelativeAccuracy())), "relativeAccuracy", 133, 4909, 4962);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 134, 4972, 5025);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 135, 5035, 5098);
            double x0 = CallChecker.varInit(((double) (min)), "x0", 142, 5373, 5388);
            double y0 = CallChecker.varInit(((double) (fMin)), "y0", 143, 5398, 5414);
            double x2 = CallChecker.varInit(((double) (max)), "x2", 144, 5424, 5439);
            double y2 = CallChecker.varInit(((double) (fMax)), "y2", 145, 5449, 5465);
            double x1 = CallChecker.varInit(((double) (0.5 * (x0 + x2))), "x1", 146, 5475, 5502);
            double y1 = CallChecker.varInit(((double) (computeObjectiveValue(x1))), "y1", 147, 5512, 5549);
            double oldx = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "oldx", 149, 5560, 5598);
            while (true) {
                final double d01 = CallChecker.varInit(((double) ((y1 - y0) / (x1 - x0))), "d01", 155, 5635, 5958);
                final double d12 = CallChecker.varInit(((double) ((y2 - y1) / (x2 - x1))), "d12", 156, 5972, 6012);
                final double d012 = CallChecker.varInit(((double) ((d12 - d01) / (x2 - x0))), "d012", 157, 6026, 6069);
                final double c1 = CallChecker.varInit(((double) (d01 + ((x1 - x0) * d012))), "c1", 158, 6083, 6123);
                final double delta = CallChecker.varInit(((double) ((c1 * c1) - ((4 * y1) * d012))), "delta", 159, 6137, 6181);
                final double xplus = CallChecker.varInit(((double) (x1 + (((-2.0) * y1) / (c1 + (FastMath.sqrt(delta)))))), "xplus", 160, 6195, 6262);
                final double xminus = CallChecker.varInit(((double) (x1 + (((-2.0) * y1) / (c1 - (FastMath.sqrt(delta)))))), "xminus", 161, 6276, 6344);
                double x = CallChecker.init(double.class);
                if (isSequence(x0, xplus, x2)) {
                    x = xplus;
                    CallChecker.varAssign(x, "x", 164, 6496, 6537);
                }else {
                    x = xminus;
                    CallChecker.varAssign(x, "x", 164, 6496, 6537);
                }
                final double y = CallChecker.varInit(((double) (computeObjectiveValue(x))), "y", 165, 6552, 6593);
                final double tolerance = CallChecker.varInit(((double) (FastMath.max((relativeAccuracy * (FastMath.abs(x))), absoluteAccuracy))), "tolerance", 168, 6608, 6736);
                if (((FastMath.abs((x - oldx))) <= tolerance) || ((FastMath.abs(y)) <= functionValueAccuracy)) {
                    return x;
                }
                boolean bisect = CallChecker.varInit(((boolean) ((((x < x1) && ((x1 - x0) > (0.95 * (x2 - x0)))) || ((x > x1) && ((x2 - x1) > (0.95 * (x2 - x0))))) || (x == x1))), "bisect", 178, 7174, 7346);
                if (!bisect) {
                    if (x < x1) {
                        x0 = x0;
                        CallChecker.varAssign(x0, "x0", 183, 7461, 7482);
                    }else {
                        x0 = x1;
                        CallChecker.varAssign(x0, "x0", 183, 7461, 7482);
                    }
                    if (x < x1) {
                        y0 = y0;
                        CallChecker.varAssign(y0, "y0", 184, 7500, 7521);
                    }else {
                        y0 = y1;
                        CallChecker.varAssign(y0, "y0", 184, 7500, 7521);
                    }
                    if (x > x1) {
                        x2 = x2;
                        CallChecker.varAssign(x2, "x2", 185, 7539, 7560);
                    }else {
                        x2 = x1;
                        CallChecker.varAssign(x2, "x2", 185, 7539, 7560);
                    }
                    if (x > x1) {
                        y2 = y2;
                        CallChecker.varAssign(y2, "y2", 186, 7578, 7599);
                    }else {
                        y2 = y1;
                        CallChecker.varAssign(y2, "y2", 186, 7578, 7599);
                    }
                    x1 = x;
                    CallChecker.varAssign(x1, "x1", 187, 7617, 7623);
                    y1 = y;
                    CallChecker.varAssign(y1, "y1", 187, 7625, 7631);
                    oldx = x;
                    CallChecker.varAssign(oldx, "oldx", 188, 7649, 7657);
                }else {
                    double xm = CallChecker.varInit(((double) (0.5 * (x0 + x2))), "xm", 190, 7696, 7723);
                    double ym = CallChecker.varInit(((double) (computeObjectiveValue(xm))), "ym", 191, 7741, 7778);
                    if (((FastMath.signum(y0)) + (FastMath.signum(ym))) == 0.0) {
                        x2 = xm;
                        CallChecker.varAssign(x2, "x2", 193, 7872, 7879);
                        y2 = ym;
                        CallChecker.varAssign(y2, "y2", 193, 7881, 7888);
                    }else {
                        x0 = xm;
                        CallChecker.varAssign(x0, "x0", 195, 7935, 7942);
                        y0 = ym;
                        CallChecker.varAssign(y0, "y0", 195, 7944, 7951);
                    }
                    x1 = 0.5 * (x0 + x2);
                    CallChecker.varAssign(x1, "x1", 197, 7987, 8007);
                    y1 = computeObjectiveValue(x1);
                    CallChecker.varAssign(y1, "y1", 198, 8025, 8055);
                    oldx = Double.POSITIVE_INFINITY;
                    CallChecker.varAssign(oldx, "oldx", 199, 8073, 8104);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2799.methodEnd();
        }
    }
}

