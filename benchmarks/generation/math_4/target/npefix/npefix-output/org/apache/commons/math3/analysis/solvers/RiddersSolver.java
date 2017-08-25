package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class RiddersSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public RiddersSolver() {
        this(RiddersSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context938 = new ConstructorContext(RiddersSolver.class, 42, 1663, 1805);
        try {
        } finally {
            _bcornu_methode_context938.methodEnd();
        }
    }

    public RiddersSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context939 = new ConstructorContext(RiddersSolver.class, 50, 1811, 1996);
        try {
        } finally {
            _bcornu_methode_context939.methodEnd();
        }
    }

    public RiddersSolver(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context940 = new ConstructorContext(RiddersSolver.class, 59, 2002, 2305);
        try {
        } finally {
            _bcornu_methode_context940.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws NoBracketingException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4239 = new MethodContext(double.class, 68, 2312, 5180);
        try {
            CallChecker.varInit(this, "this", 68, 2312, 5180);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.RiddersSolver.DEFAULT_ABSOLUTE_ACCURACY", 68, 2312, 5180);
            double min = CallChecker.varInit(((double) (getMin())), "min", 71, 2481, 2502);
            double max = CallChecker.varInit(((double) (getMax())), "max", 72, 2512, 2533);
            double x1 = CallChecker.varInit(((double) (min)), "x1", 76, 2729, 2744);
            double y1 = CallChecker.varInit(((double) (computeObjectiveValue(x1))), "y1", 77, 2754, 2791);
            double x2 = CallChecker.varInit(((double) (max)), "x2", 78, 2801, 2816);
            double y2 = CallChecker.varInit(((double) (computeObjectiveValue(x2))), "y2", 79, 2826, 2863);
            if (y1 == 0) {
                return min;
            }
            if (y2 == 0) {
                return max;
            }
            verifyBracketing(min, max);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 90, 3080, 3133);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 91, 3143, 3206);
            final double relativeAccuracy = CallChecker.varInit(((double) (getRelativeAccuracy())), "relativeAccuracy", 92, 3216, 3269);
            double oldx = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "oldx", 94, 3280, 3318);
            while (true) {
                final double x3 = CallChecker.varInit(((double) (0.5 * (x1 + x2))), "x3", 97, 3355, 3440);
                final double y3 = CallChecker.varInit(((double) (computeObjectiveValue(x3))), "y3", 98, 3454, 3497);
                if ((FastMath.abs(y3)) <= functionValueAccuracy) {
                    return x3;
                }
                final double delta = CallChecker.varInit(((double) (1 - ((y1 * y2) / (y3 * y3)))), "delta", 102, 3613, 3659);
                final double correction = CallChecker.varInit(((double) ((((FastMath.signum(y2)) * (FastMath.signum(y3))) * (x3 - x1)) / (FastMath.sqrt(delta)))), "correction", 103, 3705, 3847);
                final double x = CallChecker.varInit(((double) (x3 - correction)), "x", 105, 3861, 3893);
                final double y = CallChecker.varInit(((double) (computeObjectiveValue(x))), "y", 106, 3941, 3982);
                final double tolerance = CallChecker.varInit(((double) (FastMath.max((relativeAccuracy * (FastMath.abs(x))), absoluteAccuracy))), "tolerance", 109, 3997, 4125);
                if ((FastMath.abs((x - oldx))) <= tolerance) {
                    return x;
                }
                if ((FastMath.abs(y)) <= functionValueAccuracy) {
                    return x;
                }
                if (correction > 0.0) {
                    if (((FastMath.signum(y1)) + (FastMath.signum(y))) == 0.0) {
                        x2 = x;
                        CallChecker.varAssign(x2, "x2", 121, 4590, 4596);
                        y2 = y;
                        CallChecker.varAssign(y2, "y2", 122, 4618, 4624);
                    }else {
                        x1 = x;
                        CallChecker.varAssign(x1, "x1", 124, 4671, 4677);
                        x2 = x3;
                        CallChecker.varAssign(x2, "x2", 125, 4699, 4706);
                        y1 = y;
                        CallChecker.varAssign(y1, "y1", 126, 4728, 4734);
                        y2 = y3;
                        CallChecker.varAssign(y2, "y2", 127, 4756, 4763);
                    }
                }else {
                    if (((FastMath.signum(y2)) + (FastMath.signum(y))) == 0.0) {
                        x1 = x;
                        CallChecker.varAssign(x1, "x1", 131, 4937, 4943);
                        y1 = y;
                        CallChecker.varAssign(y1, "y1", 132, 4965, 4971);
                    }else {
                        x1 = x3;
                        CallChecker.varAssign(x1, "x1", 134, 5018, 5025);
                        x2 = x;
                        CallChecker.varAssign(x2, "x2", 135, 5047, 5053);
                        y1 = y3;
                        CallChecker.varAssign(y1, "y1", 136, 5075, 5082);
                        y2 = y;
                        CallChecker.varAssign(y2, "y2", 137, 5104, 5110);
                    }
                }
                oldx = x;
                CallChecker.varAssign(oldx, "oldx", 140, 5156, 5164);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4239.methodEnd();
        }
    }
}

