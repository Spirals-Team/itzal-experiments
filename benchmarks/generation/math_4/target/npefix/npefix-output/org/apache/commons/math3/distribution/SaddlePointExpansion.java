package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

final class SaddlePointExpansion {
    private static final double HALF_LOG_2_PI = 0.5 * (FastMath.log(MathUtils.TWO_PI));

    private static final double[] EXACT_STIRLING_ERRORS = new double[]{ 0.0 , 0.15342640972002736 , 0.08106146679532726 , 0.05481412105191765 , 0.0413406959554093 , 0.03316287351993629 , 0.02767792568499834 , 0.023746163656297496 , 0.020790672103765093 , 0.018488450532673187 , 0.016644691189821193 , 0.015134973221917378 , 0.013876128823070748 , 0.012810465242920227 , 0.01189670994589177 , 0.011104559758206917 , 0.010411265261972096 , 0.009799416126158804 , 0.009255462182712733 , 0.008768700134139386 , 0.00833056343336287 , 0.00793411456431402 , 0.007573675487951841 , 0.007244554301320383 , 0.00694284010720953 , 0.006665247032707682 , 0.006408994188004207 , 0.006171712263039458 , 0.0059513701127588475 , 0.0057462165130101155 , 0.005554733551962801 };

    private SaddlePointExpansion() {
        super();
        ConstructorContext _bcornu_methode_context888 = new ConstructorContext(SaddlePointExpansion.class, 88, 3325, 3423);
        try {
        } finally {
            _bcornu_methode_context888.methodEnd();
        }
    }

    static double getStirlingError(double z) {
        MethodContext _bcornu_methode_context3957 = new MethodContext(double.class, 107, 3430, 4731);
        try {
            CallChecker.varInit(z, "z", 107, 3430, 4731);
            CallChecker.varInit(EXACT_STIRLING_ERRORS, "org.apache.commons.math3.distribution.SaddlePointExpansion.EXACT_STIRLING_ERRORS", 107, 3430, 4731);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.distribution.SaddlePointExpansion.HALF_LOG_2_PI", 107, 3430, 4731);
            double ret = CallChecker.init(double.class);
            if (z < 15.0) {
                double z2 = CallChecker.varInit(((double) (2.0 * z)), "z2", 110, 4004, 4023);
                if ((FastMath.floor(z2)) == z2) {
                    if (CallChecker.beforeDeref(SaddlePointExpansion.EXACT_STIRLING_ERRORS, double[].class, 112, 4091, 4111)) {
                        ret = CallChecker.isCalled(SaddlePointExpansion.EXACT_STIRLING_ERRORS, double[].class, 112, 4091, 4111)[((int) (z2))];
                        CallChecker.varAssign(ret, "ret", 112, 4085, 4122);
                    }
                }else {
                    ret = (((Gamma.logGamma((z + 1.0))) - ((z + 0.5) * (FastMath.log(z)))) + z) - (SaddlePointExpansion.HALF_LOG_2_PI);
                    CallChecker.varAssign(ret, "ret", 114, 4161, 4262);
                }
            }else {
                double z2 = CallChecker.varInit(((double) (z * z)), "z2", 118, 4307, 4324);
                ret = (0.08333333333333333 - ((0.002777777777777778 - ((7.936507936507937E-4 - ((5.952380952380953E-4 - (8.417508417508417E-4 / z2)) / z2)) / z2)) / z2)) / z;
                CallChecker.varAssign(ret, "ret", 119, 4338, 4695);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3957.methodEnd();
        }
    }

    static double getDeviancePart(double x, double mu) {
        MethodContext _bcornu_methode_context3958 = new MethodContext(double.class, 145, 4738, 5870);
        try {
            CallChecker.varInit(mu, "mu", 145, 4738, 5870);
            CallChecker.varInit(x, "x", 145, 4738, 5870);
            CallChecker.varInit(EXACT_STIRLING_ERRORS, "org.apache.commons.math3.distribution.SaddlePointExpansion.EXACT_STIRLING_ERRORS", 145, 4738, 5870);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.distribution.SaddlePointExpansion.HALF_LOG_2_PI", 145, 4738, 5870);
            double ret = CallChecker.init(double.class);
            if ((FastMath.abs((x - mu))) < (0.1 * (x + mu))) {
                double d = CallChecker.varInit(((double) (x - mu)), "d", 148, 5380, 5397);
                double v = CallChecker.varInit(((double) (d / (x + mu))), "v", 149, 5411, 5434);
                double s1 = CallChecker.varInit(((double) (v * d)), "s1", 150, 5448, 5465);
                double s = CallChecker.varInit(((double) (Double.NaN)), "s", 151, 5479, 5500);
                double ej = CallChecker.varInit(((double) ((2.0 * x) * v)), "ej", 152, 5514, 5537);
                v = v * v;
                CallChecker.varAssign(v, "v", 153, 5551, 5560);
                int j = CallChecker.varInit(((int) (1)), "j", 154, 5574, 5583);
                while (s1 != s) {
                    s = s1;
                    CallChecker.varAssign(s, "s", 156, 5631, 5637);
                    ej *= v;
                    CallChecker.varAssign(ej, "ej", 157, 5655, 5662);
                    s1 = s + (ej / ((j * 2) + 1));
                    CallChecker.varAssign(s1, "s1", 158, 5680, 5707);
                    ++j;
                } 
                ret = s1;
                CallChecker.varAssign(ret, "ret", 161, 5756, 5764);
            }else {
                ret = ((x * (FastMath.log((x / mu)))) + mu) - x;
                CallChecker.varAssign(ret, "ret", 163, 5795, 5834);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3958.methodEnd();
        }
    }

    static double logBinomialProbability(int x, int n, double p, double q) {
        MethodContext _bcornu_methode_context3959 = new MethodContext(double.class, 178, 5877, 7047);
        try {
            CallChecker.varInit(q, "q", 178, 5877, 7047);
            CallChecker.varInit(p, "p", 178, 5877, 7047);
            CallChecker.varInit(n, "n", 178, 5877, 7047);
            CallChecker.varInit(x, "x", 178, 5877, 7047);
            CallChecker.varInit(EXACT_STIRLING_ERRORS, "org.apache.commons.math3.distribution.SaddlePointExpansion.EXACT_STIRLING_ERRORS", 178, 5877, 7047);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.distribution.SaddlePointExpansion.HALF_LOG_2_PI", 178, 5877, 7047);
            double ret = CallChecker.init(double.class);
            if (x == 0) {
                if (p < 0.1) {
                    ret = (-(SaddlePointExpansion.getDeviancePart(n, (n * q)))) - (n * p);
                    CallChecker.varAssign(ret, "ret", 182, 6392, 6432);
                }else {
                    ret = n * (FastMath.log(q));
                    CallChecker.varAssign(ret, "ret", 184, 6471, 6496);
                }
            }else
                if (x == n) {
                    if (q < 0.1) {
                        ret = (-(SaddlePointExpansion.getDeviancePart(n, (n * p)))) - (n * q);
                        CallChecker.varAssign(ret, "ret", 188, 6584, 6624);
                    }else {
                        ret = n * (FastMath.log(p));
                        CallChecker.varAssign(ret, "ret", 190, 6663, 6688);
                    }
                }else {
                    ret = ((((SaddlePointExpansion.getStirlingError(n)) - (SaddlePointExpansion.getStirlingError(x))) - (SaddlePointExpansion.getStirlingError((n - x)))) - (SaddlePointExpansion.getDeviancePart(x, (n * p)))) - (SaddlePointExpansion.getDeviancePart((n - x), (n * q)));
                    CallChecker.varAssign(ret, "ret", 193, 6733, 6902);
                    double f = CallChecker.varInit(((double) ((((MathUtils.TWO_PI) * x) * (n - x)) / n)), "f", 196, 6916, 6963);
                    ret = ((-0.5) * (FastMath.log(f))) + ret;
                    CallChecker.varAssign(ret, "ret", 197, 6977, 7011);
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3959.methodEnd();
        }
    }
}

