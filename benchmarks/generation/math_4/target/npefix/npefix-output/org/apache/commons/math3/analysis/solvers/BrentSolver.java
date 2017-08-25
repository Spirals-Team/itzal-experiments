package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class BrentSolver extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public BrentSolver() {
        this(BrentSolver.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context957 = new ConstructorContext(BrentSolver.class, 46, 1878, 2018);
        try {
        } finally {
            _bcornu_methode_context957.methodEnd();
        }
    }

    public BrentSolver(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context958 = new ConstructorContext(BrentSolver.class, 54, 2024, 2207);
        try {
        } finally {
            _bcornu_methode_context958.methodEnd();
        }
    }

    public BrentSolver(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context959 = new ConstructorContext(BrentSolver.class, 63, 2213, 2512);
        try {
        } finally {
            _bcornu_methode_context959.methodEnd();
        }
    }

    public BrentSolver(double relativeAccuracy, double absoluteAccuracy, double functionValueAccuracy) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context960 = new ConstructorContext(BrentSolver.class, 74, 2518, 2954);
        try {
        } finally {
            _bcornu_methode_context960.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4305 = new MethodContext(double.class, 84, 2961, 4416);
        try {
            CallChecker.varInit(this, "this", 84, 2961, 4416);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 84, 2961, 4416);
            double min = CallChecker.varInit(((double) (getMin())), "min", 88, 3172, 3193);
            double max = CallChecker.varInit(((double) (getMax())), "max", 89, 3203, 3224);
            final double initial = CallChecker.varInit(((double) (getStartValue())), "initial", 90, 3234, 3272);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 91, 3282, 3345);
            verifySequence(min, initial, max);
            double yInitial = CallChecker.varInit(((double) (computeObjectiveValue(initial))), "yInitial", 96, 3458, 3506);
            if ((FastMath.abs(yInitial)) <= functionValueAccuracy) {
                return initial;
            }
            double yMin = CallChecker.varInit(((double) (computeObjectiveValue(min))), "yMin", 102, 3677, 3717);
            if ((FastMath.abs(yMin)) <= functionValueAccuracy) {
                return min;
            }
            if ((yInitial * yMin) < 0) {
                return brent(min, initial, yMin, yInitial);
            }
            double yMax = CallChecker.varInit(((double) (computeObjectiveValue(max))), "yMax", 113, 4047, 4087);
            if ((FastMath.abs(yMax)) <= functionValueAccuracy) {
                return max;
            }
            if ((yInitial * yMax) < 0) {
                return brent(initial, max, yInitial, yMax);
            }
            throw new NoBracketingException(min, max, yMin, yMax);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4305.methodEnd();
        }
    }

    private double brent(double lo, double hi, double fLo, double fHi) {
        MethodContext _bcornu_methode_context4306 = new MethodContext(double.class, 142, 4423, 7929);
        try {
            CallChecker.varInit(this, "this", 142, 4423, 7929);
            CallChecker.varInit(fHi, "fHi", 142, 4423, 7929);
            CallChecker.varInit(fLo, "fLo", 142, 4423, 7929);
            CallChecker.varInit(hi, "hi", 142, 4423, 7929);
            CallChecker.varInit(lo, "lo", 142, 4423, 7929);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 142, 4423, 7929);
            double a = CallChecker.varInit(((double) (lo)), "a", 144, 5165, 5178);
            double fa = CallChecker.varInit(((double) (fLo)), "fa", 145, 5188, 5203);
            double b = CallChecker.varInit(((double) (hi)), "b", 146, 5213, 5226);
            double fb = CallChecker.varInit(((double) (fHi)), "fb", 147, 5236, 5251);
            double c = CallChecker.varInit(((double) (a)), "c", 148, 5261, 5273);
            double fc = CallChecker.varInit(((double) (fa)), "fc", 149, 5283, 5297);
            double d = CallChecker.varInit(((double) (b - a)), "d", 150, 5307, 5323);
            double e = CallChecker.varInit(((double) (d)), "e", 151, 5333, 5345);
            final double t = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "t", 153, 5356, 5394);
            final double eps = CallChecker.varInit(((double) (getRelativeAccuracy())), "eps", 154, 5404, 5444);
            while (true) {
                if ((FastMath.abs(fc)) < (FastMath.abs(fb))) {
                    a = b;
                    CallChecker.varAssign(a, "a", 158, 5541, 5546);
                    b = c;
                    CallChecker.varAssign(b, "b", 159, 5564, 5569);
                    c = a;
                    CallChecker.varAssign(c, "c", 160, 5587, 5592);
                    fa = fb;
                    CallChecker.varAssign(fa, "fa", 161, 5610, 5617);
                    fb = fc;
                    CallChecker.varAssign(fb, "fb", 162, 5635, 5642);
                    fc = fa;
                    CallChecker.varAssign(fc, "fc", 163, 5660, 5667);
                }
                final double tol = CallChecker.varInit(((double) (((2 * eps) * (FastMath.abs(b))) + t)), "tol", 166, 5696, 5744);
                final double m = CallChecker.varInit(((double) (0.5 * (c - b))), "m", 167, 5758, 5788);
                if (((FastMath.abs(m)) <= tol) || (Precision.equals(fb, 0))) {
                    return b;
                }
                if (((FastMath.abs(e)) < tol) || ((FastMath.abs(fa)) <= (FastMath.abs(fb)))) {
                    d = m;
                    CallChecker.varAssign(d, "d", 176, 6066, 6071);
                    e = d;
                    CallChecker.varAssign(e, "e", 177, 6089, 6094);
                }else {
                    double s = CallChecker.varInit(((double) (fb / fa)), "s", 179, 6133, 6151);
                    double p = CallChecker.init(double.class);
                    double q = CallChecker.init(double.class);
                    if (a == c) {
                        p = (2 * m) * s;
                        CallChecker.varAssign(p, "p", 187, 6491, 6504);
                        q = 1 - s;
                        CallChecker.varAssign(q, "q", 188, 6526, 6535);
                    }else {
                        q = fa / fc;
                        CallChecker.varAssign(q, "q", 191, 6638, 6649);
                        final double r = CallChecker.varInit(((double) (fb / fc)), "r", 192, 6671, 6695);
                        p = s * ((((2 * m) * q) * (q - r)) - ((b - a) * (r - 1)));
                        CallChecker.varAssign(p, "p", 193, 6717, 6766);
                        q = ((q - 1) * (r - 1)) * (s - 1);
                        CallChecker.varAssign(q, "q", 194, 6788, 6819);
                    }
                    if (p > 0) {
                        q = -q;
                        CallChecker.varAssign(q, "q", 197, 6888, 6894);
                    }else {
                        p = -p;
                        CallChecker.varAssign(p, "p", 199, 6941, 6947);
                    }
                    s = e;
                    CallChecker.varAssign(s, "s", 201, 6983, 6988);
                    e = d;
                    CallChecker.varAssign(e, "e", 202, 7006, 7011);
                    if ((p >= (((1.5 * m) * q) - (FastMath.abs((tol * q))))) || (p >= (FastMath.abs(((0.5 * s) * q))))) {
                        d = m;
                        CallChecker.varAssign(d, "d", 208, 7335, 7340);
                        e = d;
                        CallChecker.varAssign(e, "e", 209, 7362, 7367);
                    }else {
                        d = p / q;
                        CallChecker.varAssign(d, "d", 211, 7414, 7423);
                    }
                }
                a = b;
                CallChecker.varAssign(a, "a", 214, 7469, 7474);
                fa = fb;
                CallChecker.varAssign(fa, "fa", 215, 7488, 7495);
                if ((FastMath.abs(d)) > tol) {
                    b += d;
                    CallChecker.varAssign(b, "b", 218, 7555, 7561);
                }else
                    if (m > 0) {
                        b += tol;
                        CallChecker.varAssign(b, "b", 220, 7611, 7619);
                    }else {
                        b -= tol;
                        CallChecker.varAssign(b, "b", 222, 7658, 7666);
                    }
                
                fb = computeObjectiveValue(b);
                CallChecker.varAssign(fb, "fb", 224, 7694, 7723);
                if (((fb > 0) && (fc > 0)) || ((fb <= 0) && (fc <= 0))) {
                    c = a;
                    CallChecker.varAssign(c, "c", 227, 7819, 7824);
                    fc = fa;
                    CallChecker.varAssign(fc, "fc", 228, 7842, 7849);
                    d = b - a;
                    CallChecker.varAssign(d, "d", 229, 7867, 7876);
                    e = d;
                    CallChecker.varAssign(e, "e", 230, 7894, 7899);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4306.methodEnd();
        }
    }
}

