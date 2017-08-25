package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

@Deprecated
public class BrentOptimizer extends BaseAbstractUnivariateOptimizer {
    private static final double GOLDEN_SECTION = 0.5 * (3 - (FastMath.sqrt(5)));

    private static final double MIN_RELATIVE_TOLERANCE = 2 * (FastMath.ulp(1.0));

    private final double relativeThreshold;

    private final double absoluteThreshold;

    public BrentOptimizer(double rel, double abs, ConvergenceChecker<UnivariatePointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context196 = new ConstructorContext(BrentOptimizer.class, 80, 2464, 3685);
        try {
            if (rel < (BrentOptimizer.MIN_RELATIVE_TOLERANCE)) {
                throw new NumberIsTooSmallException(rel, BrentOptimizer.MIN_RELATIVE_TOLERANCE, true);
            }
            if (abs <= 0) {
                throw new NotStrictlyPositiveException(abs);
            }
            relativeThreshold = rel;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 92, 3623, 3646);
            absoluteThreshold = abs;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 93, 3656, 3679);
        } finally {
            _bcornu_methode_context196.methodEnd();
        }
    }

    public BrentOptimizer(double rel, double abs) {
        this(rel, abs, null);
        ConstructorContext _bcornu_methode_context197 = new ConstructorContext(BrentOptimizer.class, 110, 3692, 4462);
        try {
        } finally {
            _bcornu_methode_context197.methodEnd();
        }
    }

    @Override
    protected UnivariatePointValuePair doOptimize() {
        MethodContext _bcornu_methode_context775 = new MethodContext(UnivariatePointValuePair.class, 117, 4469, 10108);
        try {
            CallChecker.varInit(this, "this", 117, 4469, 10108);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 117, 4469, 10108);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 117, 4469, 10108);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optimization.univariate.BrentOptimizer.MIN_RELATIVE_TOLERANCE", 117, 4469, 10108);
            CallChecker.varInit(GOLDEN_SECTION, "org.apache.commons.math3.optimization.univariate.BrentOptimizer.GOLDEN_SECTION", 117, 4469, 10108);
            final boolean isMinim = CallChecker.varInit(((boolean) ((getGoalType()) == (GoalType.MINIMIZE))), "isMinim", 118, 4566, 4624);
            final double lo = CallChecker.varInit(((double) (getMin())), "lo", 119, 4634, 4660);
            final double mid = CallChecker.varInit(((double) (getStartValue())), "mid", 120, 4670, 4704);
            final double hi = CallChecker.varInit(((double) (getMax())), "hi", 121, 4714, 4740);
            final ConvergenceChecker<UnivariatePointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 124, 4751, 4900);
            double a = CallChecker.init(double.class);
            double b = CallChecker.init(double.class);
            if (lo < hi) {
                a = lo;
                CallChecker.varAssign(a, "a", 130, 4974, 4980);
                b = hi;
                CallChecker.varAssign(b, "b", 131, 4994, 5000);
            }else {
                a = hi;
                CallChecker.varAssign(a, "a", 133, 5031, 5037);
                b = lo;
                CallChecker.varAssign(b, "b", 134, 5051, 5057);
            }
            double x = CallChecker.varInit(((double) (mid)), "x", 137, 5078, 5092);
            double v = CallChecker.varInit(((double) (x)), "v", 138, 5102, 5114);
            double w = CallChecker.varInit(((double) (x)), "w", 139, 5124, 5136);
            double d = CallChecker.varInit(((double) (0)), "d", 140, 5146, 5158);
            double e = CallChecker.varInit(((double) (0)), "e", 141, 5168, 5180);
            double fx = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fx", 142, 5190, 5226);
            if (!isMinim) {
                fx = -fx;
                CallChecker.varAssign(fx, "fx", 144, 5264, 5272);
            }
            double fv = CallChecker.varInit(((double) (fx)), "fv", 146, 5292, 5306);
            double fw = CallChecker.varInit(((double) (fx)), "fw", 147, 5316, 5330);
            UnivariatePointValuePair previous = CallChecker.varInit(null, "previous", 149, 5341, 5381);
            UnivariatePointValuePair current = CallChecker.varInit(new UnivariatePointValuePair(x, (isMinim ? fx : -fx)), "current", 150, 5391, 5489);
            UnivariatePointValuePair best = CallChecker.varInit(current, "best", 153, 5570, 5609);
            int iter = CallChecker.varInit(((int) (0)), "iter", 155, 5620, 5632);
            while (true) {
                final double m = CallChecker.varInit(((double) (0.5 * (a + b))), "m", 157, 5669, 5699);
                final double tol1 = CallChecker.varInit(((double) (((this.relativeThreshold) * (FastMath.abs(x))) + (this.absoluteThreshold))), "tol1", 158, 5713, 5788);
                final double tol2 = CallChecker.varInit(((double) (2 * tol1)), "tol2", 159, 5802, 5830);
                final boolean stop = CallChecker.varInit(((boolean) ((FastMath.abs((x - m))) <= (tol2 - (0.5 * (b - a))))), "stop", 162, 5845, 5952);
                if (!stop) {
                    double p = CallChecker.varInit(((double) (0)), "p", 164, 5995, 6007);
                    double q = CallChecker.varInit(((double) (0)), "q", 165, 6025, 6037);
                    double r = CallChecker.varInit(((double) (0)), "r", 166, 6055, 6067);
                    double u = CallChecker.varInit(((double) (0)), "u", 167, 6085, 6097);
                    if ((FastMath.abs(e)) > tol1) {
                        r = (x - w) * (fx - fv);
                        CallChecker.varAssign(r, "r", 170, 6183, 6206);
                        q = (x - v) * (fx - fw);
                        CallChecker.varAssign(q, "q", 171, 6228, 6251);
                        p = ((x - v) * q) - ((x - w) * r);
                        CallChecker.varAssign(p, "p", 172, 6273, 6302);
                        q = 2 * (q - r);
                        CallChecker.varAssign(q, "q", 173, 6324, 6339);
                        if (q > 0) {
                            p = -p;
                            CallChecker.varAssign(p, "p", 176, 6399, 6405);
                        }else {
                            q = -q;
                            CallChecker.varAssign(q, "q", 178, 6460, 6466);
                        }
                        r = e;
                        CallChecker.varAssign(r, "r", 181, 6511, 6516);
                        e = d;
                        CallChecker.varAssign(e, "e", 182, 6538, 6543);
                        if (((p > (q * (a - x))) && (p < (q * (b - x)))) && ((FastMath.abs(p)) < (FastMath.abs(((0.5 * q) * r))))) {
                            d = p / q;
                            CallChecker.varAssign(d, "d", 188, 6784, 6793);
                            u = x + d;
                            CallChecker.varAssign(u, "u", 189, 6819, 6828);
                            if (((u - a) < tol2) || ((b - u) < tol2)) {
                                if (x <= m) {
                                    d = tol1;
                                    CallChecker.varAssign(d, "d", 194, 7037, 7045);
                                }else {
                                    d = -tol1;
                                    CallChecker.varAssign(d, "d", 196, 7116, 7125);
                                }
                            }
                        }else {
                            if (x < m) {
                                e = b - x;
                                CallChecker.varAssign(e, "e", 202, 7325, 7334);
                            }else {
                                e = a - x;
                                CallChecker.varAssign(e, "e", 204, 7397, 7406);
                            }
                            d = (BrentOptimizer.GOLDEN_SECTION) * e;
                            CallChecker.varAssign(d, "d", 206, 7458, 7480);
                        }
                    }else {
                        if (x < m) {
                            e = b - x;
                            CallChecker.varAssign(e, "e", 211, 7630, 7639);
                        }else {
                            e = a - x;
                            CallChecker.varAssign(e, "e", 213, 7694, 7703);
                        }
                        d = (BrentOptimizer.GOLDEN_SECTION) * e;
                        CallChecker.varAssign(d, "d", 215, 7747, 7769);
                    }
                    if ((FastMath.abs(d)) < tol1) {
                        if (d >= 0) {
                            u = x + tol1;
                            CallChecker.varAssign(u, "u", 221, 7940, 7952);
                        }else {
                            u = x - tol1;
                            CallChecker.varAssign(u, "u", 223, 8007, 8019);
                        }
                    }else {
                        u = x + d;
                        CallChecker.varAssign(u, "u", 226, 8088, 8097);
                    }
                    double fu = CallChecker.varInit(((double) (computeObjectiveValue(u))), "fu", 229, 8134, 8170);
                    if (!isMinim) {
                        fu = -fu;
                        CallChecker.varAssign(fu, "fu", 231, 8224, 8232);
                    }
                    previous = current;
                    CallChecker.varAssign(previous, "previous", 235, 8322, 8340);
                    current = new UnivariatePointValuePair(u, (isMinim ? fu : -fu));
                    CallChecker.varAssign(current, "current", 236, 8358, 8419);
                    best = best(best, best(previous, current, isMinim), isMinim);
                    CallChecker.varAssign(best, "best", 237, 8437, 8619);
                    if ((checker != null) && (checker.converged(iter, previous, current))) {
                        return best;
                    }
                    if (fu <= fx) {
                        if (u < x) {
                            b = x;
                            CallChecker.varAssign(b, "b", 250, 8892, 8897);
                        }else {
                            a = x;
                            CallChecker.varAssign(a, "a", 252, 8952, 8957);
                        }
                        v = w;
                        CallChecker.varAssign(v, "v", 254, 9001, 9006);
                        fv = fw;
                        CallChecker.varAssign(fv, "fv", 255, 9028, 9035);
                        w = x;
                        CallChecker.varAssign(w, "w", 256, 9057, 9062);
                        fw = fx;
                        CallChecker.varAssign(fw, "fw", 257, 9084, 9091);
                        x = u;
                        CallChecker.varAssign(x, "x", 258, 9113, 9118);
                        fx = fu;
                        CallChecker.varAssign(fx, "fx", 259, 9140, 9147);
                    }else {
                        if (u < x) {
                            a = u;
                            CallChecker.varAssign(a, "a", 262, 9231, 9236);
                        }else {
                            b = u;
                            CallChecker.varAssign(b, "b", 264, 9291, 9296);
                        }
                        if ((fu <= fw) || (Precision.equals(w, x))) {
                            v = w;
                            CallChecker.varAssign(v, "v", 268, 9430, 9435);
                            fv = fw;
                            CallChecker.varAssign(fv, "fv", 269, 9461, 9468);
                            w = u;
                            CallChecker.varAssign(w, "w", 270, 9494, 9499);
                            fw = fu;
                            CallChecker.varAssign(fw, "fw", 271, 9525, 9532);
                        }else
                            if (((fu <= fv) || (Precision.equals(v, x))) || (Precision.equals(v, w))) {
                                v = u;
                                CallChecker.varAssign(v, "v", 275, 9715, 9720);
                                fv = fu;
                                CallChecker.varAssign(fv, "fv", 276, 9746, 9753);
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
            _bcornu_methode_context775.methodEnd();
        }
    }

    private UnivariatePointValuePair best(UnivariatePointValuePair a, UnivariatePointValuePair b, boolean isMinim) {
        MethodContext _bcornu_methode_context776 = new MethodContext(UnivariatePointValuePair.class, 301, 10115, 11019);
        try {
            CallChecker.varInit(this, "this", 301, 10115, 11019);
            CallChecker.varInit(isMinim, "isMinim", 301, 10115, 11019);
            CallChecker.varInit(b, "b", 301, 10115, 11019);
            CallChecker.varInit(a, "a", 301, 10115, 11019);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 301, 10115, 11019);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 301, 10115, 11019);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optimization.univariate.BrentOptimizer.MIN_RELATIVE_TOLERANCE", 301, 10115, 11019);
            CallChecker.varInit(GOLDEN_SECTION, "org.apache.commons.math3.optimization.univariate.BrentOptimizer.GOLDEN_SECTION", 301, 10115, 11019);
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
            _bcornu_methode_context776.methodEnd();
        }
    }
}

