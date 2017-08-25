package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class BrentOptimizer extends UnivariateOptimizer {
    private static final double GOLDEN_SECTION = 0.5 * (3 - (FastMath.sqrt(5)));

    private static final double MIN_RELATIVE_TOLERANCE = 2 * (FastMath.ulp(1.0));

    private final double relativeThreshold;

    private final double absoluteThreshold;

    public BrentOptimizer(double rel, double abs, ConvergenceChecker<UnivariatePointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context198 = new ConstructorContext(BrentOptimizer.class, 78, 2387, 3608);
        try {
            if (rel < (BrentOptimizer.MIN_RELATIVE_TOLERANCE)) {
                throw new NumberIsTooSmallException(rel, BrentOptimizer.MIN_RELATIVE_TOLERANCE, true);
            }
            if (abs <= 0) {
                throw new NotStrictlyPositiveException(abs);
            }
            relativeThreshold = rel;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 90, 3546, 3569);
            absoluteThreshold = abs;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 91, 3579, 3602);
        } finally {
            _bcornu_methode_context198.methodEnd();
        }
    }

    public BrentOptimizer(double rel, double abs) {
        this(rel, abs, null);
        ConstructorContext _bcornu_methode_context199 = new ConstructorContext(BrentOptimizer.class, 108, 3615, 4385);
        try {
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    @Override
    protected UnivariatePointValuePair doOptimize() {
        MethodContext _bcornu_methode_context777 = new MethodContext(UnivariatePointValuePair.class, 115, 4392, 10031);
        try {
            CallChecker.varInit(this, "this", 115, 4392, 10031);
            CallChecker.varInit(this.iterations, "iterations", 115, 4392, 10031);
            CallChecker.varInit(this.evaluations, "evaluations", 115, 4392, 10031);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 115, 4392, 10031);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 115, 4392, 10031);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optim.univariate.BrentOptimizer.MIN_RELATIVE_TOLERANCE", 115, 4392, 10031);
            CallChecker.varInit(GOLDEN_SECTION, "org.apache.commons.math3.optim.univariate.BrentOptimizer.GOLDEN_SECTION", 115, 4392, 10031);
            final boolean isMinim = CallChecker.varInit(((boolean) ((getGoalType()) == (GoalType.MINIMIZE))), "isMinim", 116, 4489, 4547);
            final double lo = CallChecker.varInit(((double) (getMin())), "lo", 117, 4557, 4583);
            final double mid = CallChecker.varInit(((double) (getStartValue())), "mid", 118, 4593, 4627);
            final double hi = CallChecker.varInit(((double) (getMax())), "hi", 119, 4637, 4663);
            final ConvergenceChecker<UnivariatePointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 122, 4674, 4823);
            double a = CallChecker.init(double.class);
            double b = CallChecker.init(double.class);
            if (lo < hi) {
                a = lo;
                CallChecker.varAssign(a, "a", 128, 4897, 4903);
                b = hi;
                CallChecker.varAssign(b, "b", 129, 4917, 4923);
            }else {
                a = hi;
                CallChecker.varAssign(a, "a", 131, 4954, 4960);
                b = lo;
                CallChecker.varAssign(b, "b", 132, 4974, 4980);
            }
            double x = CallChecker.varInit(((double) (mid)), "x", 135, 5001, 5015);
            double v = CallChecker.varInit(((double) (x)), "v", 136, 5025, 5037);
            double w = CallChecker.varInit(((double) (x)), "w", 137, 5047, 5059);
            double d = CallChecker.varInit(((double) (0)), "d", 138, 5069, 5081);
            double e = CallChecker.varInit(((double) (0)), "e", 139, 5091, 5103);
            double fx = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fx", 140, 5113, 5149);
            if (!isMinim) {
                fx = -fx;
                CallChecker.varAssign(fx, "fx", 142, 5187, 5195);
            }
            double fv = CallChecker.varInit(((double) (fx)), "fv", 144, 5215, 5229);
            double fw = CallChecker.varInit(((double) (fx)), "fw", 145, 5239, 5253);
            UnivariatePointValuePair previous = CallChecker.varInit(null, "previous", 147, 5264, 5304);
            UnivariatePointValuePair current = CallChecker.varInit(new UnivariatePointValuePair(x, (isMinim ? fx : -fx)), "current", 148, 5314, 5412);
            UnivariatePointValuePair best = CallChecker.varInit(current, "best", 151, 5493, 5532);
            int iter = CallChecker.varInit(((int) (0)), "iter", 153, 5543, 5555);
            while (true) {
                final double m = CallChecker.varInit(((double) (0.5 * (a + b))), "m", 155, 5592, 5622);
                final double tol1 = CallChecker.varInit(((double) (((this.relativeThreshold) * (FastMath.abs(x))) + (this.absoluteThreshold))), "tol1", 156, 5636, 5711);
                final double tol2 = CallChecker.varInit(((double) (2 * tol1)), "tol2", 157, 5725, 5753);
                final boolean stop = CallChecker.varInit(((boolean) ((FastMath.abs((x - m))) <= (tol2 - (0.5 * (b - a))))), "stop", 160, 5768, 5875);
                if (!stop) {
                    double p = CallChecker.varInit(((double) (0)), "p", 162, 5918, 5930);
                    double q = CallChecker.varInit(((double) (0)), "q", 163, 5948, 5960);
                    double r = CallChecker.varInit(((double) (0)), "r", 164, 5978, 5990);
                    double u = CallChecker.varInit(((double) (0)), "u", 165, 6008, 6020);
                    if ((FastMath.abs(e)) > tol1) {
                        r = (x - w) * (fx - fv);
                        CallChecker.varAssign(r, "r", 168, 6106, 6129);
                        q = (x - v) * (fx - fw);
                        CallChecker.varAssign(q, "q", 169, 6151, 6174);
                        p = ((x - v) * q) - ((x - w) * r);
                        CallChecker.varAssign(p, "p", 170, 6196, 6225);
                        q = 2 * (q - r);
                        CallChecker.varAssign(q, "q", 171, 6247, 6262);
                        if (q > 0) {
                            p = -p;
                            CallChecker.varAssign(p, "p", 174, 6322, 6328);
                        }else {
                            q = -q;
                            CallChecker.varAssign(q, "q", 176, 6383, 6389);
                        }
                        r = e;
                        CallChecker.varAssign(r, "r", 179, 6434, 6439);
                        e = d;
                        CallChecker.varAssign(e, "e", 180, 6461, 6466);
                        if (((p > (q * (a - x))) && (p < (q * (b - x)))) && ((FastMath.abs(p)) < (FastMath.abs(((0.5 * q) * r))))) {
                            d = p / q;
                            CallChecker.varAssign(d, "d", 186, 6707, 6716);
                            u = x + d;
                            CallChecker.varAssign(u, "u", 187, 6742, 6751);
                            if (((u - a) < tol2) || ((b - u) < tol2)) {
                                if (x <= m) {
                                    d = tol1;
                                    CallChecker.varAssign(d, "d", 192, 6960, 6968);
                                }else {
                                    d = -tol1;
                                    CallChecker.varAssign(d, "d", 194, 7039, 7048);
                                }
                            }
                        }else {
                            if (x < m) {
                                e = b - x;
                                CallChecker.varAssign(e, "e", 200, 7248, 7257);
                            }else {
                                e = a - x;
                                CallChecker.varAssign(e, "e", 202, 7320, 7329);
                            }
                            d = (BrentOptimizer.GOLDEN_SECTION) * e;
                            CallChecker.varAssign(d, "d", 204, 7381, 7403);
                        }
                    }else {
                        if (x < m) {
                            e = b - x;
                            CallChecker.varAssign(e, "e", 209, 7553, 7562);
                        }else {
                            e = a - x;
                            CallChecker.varAssign(e, "e", 211, 7617, 7626);
                        }
                        d = (BrentOptimizer.GOLDEN_SECTION) * e;
                        CallChecker.varAssign(d, "d", 213, 7670, 7692);
                    }
                    if ((FastMath.abs(d)) < tol1) {
                        if (d >= 0) {
                            u = x + tol1;
                            CallChecker.varAssign(u, "u", 219, 7863, 7875);
                        }else {
                            u = x - tol1;
                            CallChecker.varAssign(u, "u", 221, 7930, 7942);
                        }
                    }else {
                        u = x + d;
                        CallChecker.varAssign(u, "u", 224, 8011, 8020);
                    }
                    double fu = CallChecker.varInit(((double) (computeObjectiveValue(u))), "fu", 227, 8057, 8093);
                    if (!isMinim) {
                        fu = -fu;
                        CallChecker.varAssign(fu, "fu", 229, 8147, 8155);
                    }
                    previous = current;
                    CallChecker.varAssign(previous, "previous", 233, 8245, 8263);
                    current = new UnivariatePointValuePair(u, (isMinim ? fu : -fu));
                    CallChecker.varAssign(current, "current", 234, 8281, 8342);
                    best = best(best, best(previous, current, isMinim), isMinim);
                    CallChecker.varAssign(best, "best", 235, 8360, 8542);
                    if ((checker != null) && (checker.converged(iter, previous, current))) {
                        return best;
                    }
                    if (fu <= fx) {
                        if (u < x) {
                            b = x;
                            CallChecker.varAssign(b, "b", 248, 8815, 8820);
                        }else {
                            a = x;
                            CallChecker.varAssign(a, "a", 250, 8875, 8880);
                        }
                        v = w;
                        CallChecker.varAssign(v, "v", 252, 8924, 8929);
                        fv = fw;
                        CallChecker.varAssign(fv, "fv", 253, 8951, 8958);
                        w = x;
                        CallChecker.varAssign(w, "w", 254, 8980, 8985);
                        fw = fx;
                        CallChecker.varAssign(fw, "fw", 255, 9007, 9014);
                        x = u;
                        CallChecker.varAssign(x, "x", 256, 9036, 9041);
                        fx = fu;
                        CallChecker.varAssign(fx, "fx", 257, 9063, 9070);
                    }else {
                        if (u < x) {
                            a = u;
                            CallChecker.varAssign(a, "a", 260, 9154, 9159);
                        }else {
                            b = u;
                            CallChecker.varAssign(b, "b", 262, 9214, 9219);
                        }
                        if ((fu <= fw) || (Precision.equals(w, x))) {
                            v = w;
                            CallChecker.varAssign(v, "v", 266, 9353, 9358);
                            fv = fw;
                            CallChecker.varAssign(fv, "fv", 267, 9384, 9391);
                            w = u;
                            CallChecker.varAssign(w, "w", 268, 9417, 9422);
                            fw = fu;
                            CallChecker.varAssign(fw, "fw", 269, 9448, 9455);
                        }else
                            if (((fu <= fv) || (Precision.equals(v, x))) || (Precision.equals(v, w))) {
                                v = u;
                                CallChecker.varAssign(v, "v", 273, 9638, 9643);
                                fv = fu;
                                CallChecker.varAssign(fv, "fv", 274, 9669, 9676);
                            }
                        
                    }
                }else {
                    return best(best, best(previous, current, isMinim), isMinim);
                }
                ++iter;
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context777.methodEnd();
        }
    }

    private UnivariatePointValuePair best(UnivariatePointValuePair a, UnivariatePointValuePair b, boolean isMinim) {
        MethodContext _bcornu_methode_context778 = new MethodContext(UnivariatePointValuePair.class, 299, 10038, 10942);
        try {
            CallChecker.varInit(this, "this", 299, 10038, 10942);
            CallChecker.varInit(isMinim, "isMinim", 299, 10038, 10942);
            CallChecker.varInit(b, "b", 299, 10038, 10942);
            CallChecker.varInit(a, "a", 299, 10038, 10942);
            CallChecker.varInit(this.iterations, "iterations", 299, 10038, 10942);
            CallChecker.varInit(this.evaluations, "evaluations", 299, 10038, 10942);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 299, 10038, 10942);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 299, 10038, 10942);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optim.univariate.BrentOptimizer.MIN_RELATIVE_TOLERANCE", 299, 10038, 10942);
            CallChecker.varInit(GOLDEN_SECTION, "org.apache.commons.math3.optim.univariate.BrentOptimizer.GOLDEN_SECTION", 299, 10038, 10942);
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            if (isMinim) {
                if ((a.getValue()) <= (b.getValue())) {
                    return a;
                }else {
                    return b;
                }
            }else {
                if ((a.getValue()) >= (b.getValue())) {
                    return a;
                }else {
                    return b;
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context778.methodEnd();
        }
    }
}

