package org.apache.commons.math3.special;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

public class Beta {
    private static final double DEFAULT_EPSILON = 1.0E-14;

    private static final double HALF_LOG_TWO_PI = 0.9189385332046727;

    private static final double[] DELTA = new double[]{ 0.08333333333333333 , -2.777777777777778E-5 , 7.936507936507937E-8 , -5.952380952380953E-10 , 8.417508417508329E-12 , -1.917526917518546E-13 , 6.410256405103255E-15 , -2.955065141253382E-16 , 1.7964371635940225E-17 , -1.3922896466162779E-18 , 1.338028550140209E-19 , -1.542460098679661E-20 , 1.9770199298095743E-21 , -2.3406566479399704E-22 , 1.713480149663986E-23 };

    private Beta() {
        ConstructorContext _bcornu_methode_context72 = new ConstructorContext(Beta.class, 102, 3980, 4065);
        try {
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    public static double regularizedBeta(double x, double a, double b) {
        MethodContext _bcornu_methode_context289 = new MethodContext(double.class, 116, 4072, 4662);
        try {
            CallChecker.varInit(b, "b", 116, 4072, 4662);
            CallChecker.varInit(a, "a", 116, 4072, 4662);
            CallChecker.varInit(x, "x", 116, 4072, 4662);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 116, 4072, 4662);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 116, 4072, 4662);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 116, 4072, 4662);
            return Beta.regularizedBeta(x, a, b, Beta.DEFAULT_EPSILON, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context289.methodEnd();
        }
    }

    public static double regularizedBeta(double x, double a, double b, double epsilon) {
        MethodContext _bcornu_methode_context290 = new MethodContext(double.class, 135, 4669, 5529);
        try {
            CallChecker.varInit(epsilon, "epsilon", 135, 4669, 5529);
            CallChecker.varInit(b, "b", 135, 4669, 5529);
            CallChecker.varInit(a, "a", 135, 4669, 5529);
            CallChecker.varInit(x, "x", 135, 4669, 5529);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 135, 4669, 5529);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 135, 4669, 5529);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 135, 4669, 5529);
            return Beta.regularizedBeta(x, a, b, epsilon, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context290.methodEnd();
        }
    }

    public static double regularizedBeta(double x, double a, double b, int maxIterations) {
        MethodContext _bcornu_methode_context291 = new MethodContext(double.class, 152, 5536, 6211);
        try {
            CallChecker.varInit(maxIterations, "maxIterations", 152, 5536, 6211);
            CallChecker.varInit(b, "b", 152, 5536, 6211);
            CallChecker.varInit(a, "a", 152, 5536, 6211);
            CallChecker.varInit(x, "x", 152, 5536, 6211);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 152, 5536, 6211);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 152, 5536, 6211);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 152, 5536, 6211);
            return Beta.regularizedBeta(x, a, b, Beta.DEFAULT_EPSILON, maxIterations);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context291.methodEnd();
        }
    }

    public static double regularizedBeta(double x, final double a, final double b, double epsilon, int maxIterations) {
        MethodContext _bcornu_methode_context294 = new MethodContext(double.class, 182, 6218, 8821);
        try {
            CallChecker.varInit(maxIterations, "maxIterations", 182, 6218, 8821);
            CallChecker.varInit(epsilon, "epsilon", 182, 6218, 8821);
            CallChecker.varInit(b, "b", 182, 6218, 8821);
            CallChecker.varInit(a, "a", 182, 6218, 8821);
            CallChecker.varInit(x, "x", 182, 6218, 8821);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 182, 6218, 8821);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 182, 6218, 8821);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 182, 6218, 8821);
            double ret = CallChecker.init(double.class);
            if (((((((Double.isNaN(x)) || (Double.isNaN(a))) || (Double.isNaN(b))) || (x < 0)) || (x > 1)) || (a <= 0.0)) || (b <= 0.0)) {
                ret = Double.NaN;
                CallChecker.varAssign(ret, "ret", 194, 7577, 7593);
            }else
                if (x > ((a + 1.0) / ((a + b) + 2.0))) {
                    ret = 1.0 - (Beta.regularizedBeta((1.0 - x), b, a, epsilon, maxIterations));
                    CallChecker.varAssign(ret, "ret", 196, 7659, 7725);
                }else {
                    org.apache.commons.math3.util.ContinuedFraction fraction = new org.apache.commons.math3.util.ContinuedFraction() {
                        @Override
                        protected double getB(int n, double x) {
                            MethodContext _bcornu_methode_context292 = new MethodContext(double.class, 201, 7828, 8431);
                            try {
                                CallChecker.varInit(this, "this", 201, 7828, 8431);
                                CallChecker.varInit(x, "x", 201, 7828, 8431);
                                CallChecker.varInit(n, "n", 201, 7828, 8431);
                                double ret = CallChecker.init(double.class);
                                double m = CallChecker.init(double.class);
                                if ((n % 2) == 0) {
                                    m = n / 2.0;
                                    CallChecker.varAssign(m, "m", 205, 8027, 8038);
                                    ret = ((m * (b - m)) * x) / (((a + (2 * m)) - 1) * (a + (2 * m)));
                                    CallChecker.varAssign(ret, "ret", 206, 8064, 8153);
                                }else {
                                    m = (n - 1.0) / 2.0;
                                    CallChecker.varAssign(m, "m", 209, 8208, 8227);
                                    ret = (-(((a + m) * ((a + b) + m)) * x)) / ((a + (2 * m)) * ((a + (2 * m)) + 1.0));
                                    CallChecker.varAssign(ret, "ret", 210, 8253, 8359);
                                }
                                return ret;
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((Double) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context292.methodEnd();
                            }
                        }

                        @Override
                        protected double getA(int n, double x) {
                            MethodContext _bcornu_methode_context293 = new MethodContext(double.class, 217, 8450, 8565);
                            try {
                                CallChecker.varInit(this, "this", 217, 8450, 8565);
                                CallChecker.varInit(x, "x", 217, 8450, 8565);
                                CallChecker.varInit(n, "n", 217, 8450, 8565);
                                return 1.0;
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((Double) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context293.methodEnd();
                            }
                        }
                    };
                    if (CallChecker.beforeDeref(fraction, org.apache.commons.math3.util.ContinuedFraction.class, 223, 8740, 8747)) {
                        fraction = CallChecker.beforeCalled(fraction, org.apache.commons.math3.util.ContinuedFraction.class, 223, 8740, 8747);
                        ret = ((FastMath.exp(((((a * (FastMath.log(x))) + (b * (FastMath.log((1.0 - x))))) - (FastMath.log(a))) - (Beta.logBeta(a, b))))) * 1.0) / (CallChecker.isCalled(fraction, org.apache.commons.math3.util.ContinuedFraction.class, 223, 8740, 8747).evaluate(x, epsilon, maxIterations));
                        CallChecker.varAssign(ret, "ret", 221, 8594, 8784);
                    }
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context294.methodEnd();
        }
    }

    @Deprecated
    public static double logBeta(double a, double b, double epsilon, int maxIterations) {
        MethodContext _bcornu_methode_context295 = new MethodContext(double.class, 249, 8828, 9801);
        try {
            CallChecker.varInit(maxIterations, "maxIterations", 249, 8828, 9801);
            CallChecker.varInit(epsilon, "epsilon", 249, 8828, 9801);
            CallChecker.varInit(b, "b", 249, 8828, 9801);
            CallChecker.varInit(a, "a", 249, 8828, 9801);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 249, 8828, 9801);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 249, 8828, 9801);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 249, 8828, 9801);
            return Beta.logBeta(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context295.methodEnd();
        }
    }

    private static double logGammaSum(final double a, final double b) throws OutOfRangeException {
        MethodContext _bcornu_methode_context296 = new MethodContext(double.class, 269, 9809, 10986);
        try {
            CallChecker.varInit(b, "b", 269, 9809, 10986);
            CallChecker.varInit(a, "a", 269, 9809, 10986);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 269, 9809, 10986);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 269, 9809, 10986);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 269, 9809, 10986);
            if ((a < 1.0) || (a > 2.0)) {
                throw new OutOfRangeException(a, 1.0, 2.0);
            }
            if ((b < 1.0) || (b > 2.0)) {
                throw new OutOfRangeException(b, 1.0, 2.0);
            }
            final double x = CallChecker.varInit(((double) ((a - 1.0) + (b - 1.0))), "x", 279, 10678, 10716);
            if (x <= 0.5) {
                return Gamma.logGamma1p((1.0 + x));
            }else
                if (x <= 1.5) {
                    return (Gamma.logGamma1p(x)) + (FastMath.log1p(x));
                }else {
                    return (Gamma.logGamma1p((x - 1.0))) + (FastMath.log((x * (1.0 + x))));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context296.methodEnd();
        }
    }

    private static double logGammaMinusLogGammaSum(final double a, final double b) throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context297 = new MethodContext(double.class, 301, 10993, 12367);
        try {
            CallChecker.varInit(b, "b", 301, 10993, 12367);
            CallChecker.varInit(a, "a", 301, 10993, 12367);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 301, 10993, 12367);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 301, 10993, 12367);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 301, 10993, 12367);
            if (a < 0.0) {
                throw new NumberIsTooSmallException(a, 0.0, true);
            }
            if (b < 10.0) {
                throw new NumberIsTooSmallException(b, 10.0, true);
            }
            double d = CallChecker.init(double.class);
            double w = CallChecker.init(double.class);
            if (a <= b) {
                d = b + (a - 0.5);
                CallChecker.varAssign(d, "d", 318, 12043, 12060);
                w = Beta.deltaMinusDeltaSum(a, b);
                CallChecker.varAssign(w, "w", 319, 12074, 12102);
            }else {
                d = a + (b - 0.5);
                CallChecker.varAssign(d, "d", 321, 12133, 12150);
                w = Beta.deltaMinusDeltaSum(b, a);
                CallChecker.varAssign(w, "w", 322, 12164, 12192);
            }
            final double u = CallChecker.varInit(((double) (d * (FastMath.log1p((a / b))))), "u", 325, 12213, 12255);
            final double v = CallChecker.varInit(((double) (a * ((FastMath.log(b)) - 1.0))), "v", 326, 12265, 12309);
            if (u <= v) {
                return (w - u) - v;
            }else {
                return (w - v) - u;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }

    private static double deltaMinusDeltaSum(final double a, final double b) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context298 = new MethodContext(double.class, 341, 12374, 13898);
        try {
            CallChecker.varInit(b, "b", 341, 12374, 13898);
            CallChecker.varInit(a, "a", 341, 12374, 13898);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 341, 12374, 13898);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 341, 12374, 13898);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 341, 12374, 13898);
            if ((a < 0) || (a > b)) {
                throw new OutOfRangeException(a, 0, b);
            }
            if (b < 10) {
                throw new NumberIsTooSmallException(b, 10, true);
            }
            final double h = CallChecker.varInit(((double) (a / b)), "h", 352, 13181, 13203);
            final double p = CallChecker.varInit(((double) (h / (1.0 + h))), "p", 353, 13213, 13243);
            final double q = CallChecker.varInit(((double) (1.0 / (1.0 + h))), "q", 354, 13253, 13285);
            final double q2 = CallChecker.varInit(((double) (q * q)), "q2", 355, 13295, 13318);
            final double[] s = CallChecker.varInit(new double[CallChecker.isCalled(Beta.DELTA, double[].class, 359, 13424, 13428).length], "s", 359, 13394, 13437);
            if (CallChecker.beforeDeref(s, double[].class, 360, 13447, 13447)) {
                CallChecker.isCalled(s, double[].class, 360, 13447, 13447)[0] = 1.0;
                CallChecker.varAssign(CallChecker.isCalled(s, double[].class, 360, 13447, 13447)[0], "CallChecker.isCalled(s, double[].class, 360, 13447, 13447)[0]", 360, 13447, 13457);
            }
            for (int i = 1; i < (CallChecker.isCalled(s, double[].class, 361, 13487, 13487).length); i++) {
                if (CallChecker.beforeDeref(s, double[].class, 362, 13516, 13516)) {
                    if (CallChecker.beforeDeref(s, double[].class, 362, 13539, 13539)) {
                        CallChecker.isCalled(s, double[].class, 362, 13516, 13516)[i] = 1.0 + (q + (q2 * (CallChecker.isCalled(s, double[].class, 362, 13539, 13539)[(i - 1)])));
                        CallChecker.varAssign(CallChecker.isCalled(s, double[].class, 362, 13516, 13516)[i], "CallChecker.isCalled(s, double[].class, 362, 13516, 13516)[i]", 362, 13516, 13548);
                    }
                }
            }
            final double sqrtT = CallChecker.varInit(((double) (10.0 / b)), "sqrtT", 367, 13568, 13659);
            final double t = CallChecker.varInit(((double) (sqrtT * sqrtT)), "t", 368, 13669, 13699);
            double w = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 369, 13726, 13730)) {
                if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 369, 13720, 13724)) {
                    if (CallChecker.beforeDeref(s, double[].class, 369, 13748, 13748)) {
                        if (CallChecker.beforeDeref(s, double[].class, 369, 13746, 13746)) {
                            w = (CallChecker.isCalled(Beta.DELTA, double[].class, 369, 13720, 13724)[((CallChecker.isCalled(Beta.DELTA, double[].class, 369, 13726, 13730).length) - 1)]) * (CallChecker.isCalled(s, double[].class, 369, 13746, 13746)[((CallChecker.isCalled(s, double[].class, 369, 13748, 13748).length) - 1)]);
                            CallChecker.varAssign(w, "w", 369, 13726, 13730);
                        }
                    }
                }
            }
            for (int i = (CallChecker.isCalled(Beta.DELTA, double[].class, 370, 13784, 13788).length) - 2; i >= 0; i--) {
                if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 371, 13841, 13845)) {
                    if (CallChecker.beforeDeref(s, double[].class, 371, 13852, 13852)) {
                        w = (t * w) + ((CallChecker.isCalled(Beta.DELTA, double[].class, 371, 13841, 13845)[i]) * (CallChecker.isCalled(s, double[].class, 371, 13852, 13852)[i]));
                        CallChecker.varAssign(w, "w", 371, 13829, 13856);
                    }
                }
            }
            return (w * p) / b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    private static double sumDeltaMinusDeltaSum(final double p, final double q) {
        MethodContext _bcornu_methode_context299 = new MethodContext(double.class, 388, 13905, 15143);
        try {
            CallChecker.varInit(q, "q", 388, 13905, 15143);
            CallChecker.varInit(p, "p", 388, 13905, 15143);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 388, 13905, 15143);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 388, 13905, 15143);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 388, 13905, 15143);
            if (p < 10.0) {
                throw new NumberIsTooSmallException(p, 10.0, true);
            }
            if (q < 10.0) {
                throw new NumberIsTooSmallException(q, 10.0, true);
            }
            final double a = CallChecker.varInit(((double) (FastMath.min(p, q))), "a", 398, 14787, 14822);
            final double b = CallChecker.varInit(((double) (FastMath.max(p, q))), "b", 399, 14832, 14867);
            final double sqrtT = CallChecker.varInit(((double) (10.0 / a)), "sqrtT", 400, 14877, 14906);
            final double t = CallChecker.varInit(((double) (sqrtT * sqrtT)), "t", 401, 14916, 14946);
            double z = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 402, 14973, 14977)) {
                if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 402, 14967, 14971)) {
                    z = CallChecker.isCalled(Beta.DELTA, double[].class, 402, 14967, 14971)[((CallChecker.isCalled(Beta.DELTA, double[].class, 402, 14973, 14977).length) - 1)];
                    CallChecker.varAssign(z, "z", 402, 14973, 14977);
                }
            }
            for (int i = (CallChecker.isCalled(Beta.DELTA, double[].class, 403, 15013, 15017).length) - 2; i >= 0; i--) {
                if (CallChecker.beforeDeref(Beta.DELTA, double[].class, 404, 15070, 15074)) {
                    z = (t * z) + (CallChecker.isCalled(Beta.DELTA, double[].class, 404, 15070, 15074)[i]);
                    CallChecker.varAssign(z, "z", 404, 15058, 15078);
                }
            }
            return (z / a) + (Beta.deltaMinusDeltaSum(a, b));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    public static double logBeta(final double p, final double q) {
        MethodContext _bcornu_methode_context300 = new MethodContext(double.class, 419, 15150, 19229);
        try {
            CallChecker.varInit(q, "q", 419, 15150, 19229);
            CallChecker.varInit(p, "p", 419, 15150, 19229);
            CallChecker.varInit(DELTA, "org.apache.commons.math3.special.Beta.DELTA", 419, 15150, 19229);
            CallChecker.varInit(HALF_LOG_TWO_PI, "org.apache.commons.math3.special.Beta.HALF_LOG_TWO_PI", 419, 15150, 19229);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Beta.DEFAULT_EPSILON", 419, 15150, 19229);
            if ((((Double.isNaN(p)) || (Double.isNaN(q))) || (p <= 0.0)) || (q <= 0.0)) {
                return Double.NaN;
            }
            final double a = CallChecker.varInit(((double) (FastMath.min(p, q))), "a", 424, 15714, 15749);
            final double b = CallChecker.varInit(((double) (FastMath.max(p, q))), "b", 425, 15759, 15794);
            if (a >= 10.0) {
                final double w = CallChecker.varInit(((double) (Beta.sumDeltaMinusDeltaSum(a, b))), "w", 427, 15833, 15877);
                final double h = CallChecker.varInit(((double) (a / b)), "h", 428, 15891, 15913);
                final double c = CallChecker.varInit(((double) (h / (1.0 + h))), "c", 429, 15927, 15957);
                final double u = CallChecker.varInit(((double) ((-(a - 0.5)) * (FastMath.log(c)))), "u", 430, 15971, 16016);
                final double v = CallChecker.varInit(((double) (b * (FastMath.log1p(h)))), "v", 431, 16030, 16068);
                if (u <= v) {
                    return (((((-0.5) * (FastMath.log(b))) + (Beta.HALF_LOG_TWO_PI)) + w) - u) - v;
                }else {
                    return (((((-0.5) * (FastMath.log(b))) + (Beta.HALF_LOG_TWO_PI)) + w) - v) - u;
                }
            }else
                if (a > 2.0) {
                    if (b > 1000.0) {
                        final int n = CallChecker.varInit(((int) ((int) (FastMath.floor((a - 1.0))))), "n", 439, 16373, 16416);
                        double prod = CallChecker.varInit(((double) (1.0)), "prod", 440, 16434, 16451);
                        double ared = CallChecker.varInit(((double) (a)), "ared", 441, 16469, 16484);
                        for (int i = 0; i < n; i++) {
                            ared -= 1.0;
                            CallChecker.varAssign(ared, "ared", 443, 16552, 16563);
                            prod *= ared / (1.0 + (ared / b));
                            CallChecker.varAssign(prod, "prod", 444, 16585, 16616);
                        }
                        return ((FastMath.log(prod)) - (n * (FastMath.log(b)))) + ((Gamma.logGamma(ared)) + (Beta.logGammaMinusLogGammaSum(ared, b)));
                    }else {
                        double prod1 = CallChecker.varInit(((double) (1.0)), "prod1", 450, 16850, 16868);
                        double ared = CallChecker.varInit(((double) (a)), "ared", 451, 16886, 16901);
                        while (ared > 2.0) {
                            ared -= 1.0;
                            CallChecker.varAssign(ared, "ared", 453, 16960, 16971);
                            final double h = CallChecker.varInit(((double) (ared / b)), "h", 454, 16993, 17018);
                            prod1 *= h / (1.0 + h);
                            CallChecker.varAssign(prod1, "prod1", 455, 17040, 17062);
                        } 
                        if (b < 10.0) {
                            double prod2 = CallChecker.varInit(((double) (1.0)), "prod2", 458, 17134, 17152);
                            double bred = CallChecker.varInit(((double) (b)), "bred", 459, 17174, 17189);
                            while (bred > 2.0) {
                                bred -= 1.0;
                                CallChecker.varAssign(bred, "bred", 461, 17256, 17267);
                                prod2 *= bred / (ared + bred);
                                CallChecker.varAssign(prod2, "prod2", 462, 17293, 17322);
                            } 
                            return ((FastMath.log(prod1)) + (FastMath.log(prod2))) + ((Gamma.logGamma(ared)) + ((Gamma.logGamma(bred)) - (Beta.logGammaSum(ared, bred))));
                        }else {
                            return ((FastMath.log(prod1)) + (Gamma.logGamma(ared))) + (Beta.logGammaMinusLogGammaSum(ared, b));
                        }
                    }
                }else
                    if (a >= 1.0) {
                        if (b > 2.0) {
                            if (b < 10.0) {
                                double prod = CallChecker.varInit(((double) (1.0)), "prod", 478, 17929, 17946);
                                double bred = CallChecker.varInit(((double) (b)), "bred", 479, 17968, 17983);
                                while (bred > 2.0) {
                                    bred -= 1.0;
                                    CallChecker.varAssign(bred, "bred", 481, 18050, 18061);
                                    prod *= bred / (a + bred);
                                    CallChecker.varAssign(prod, "prod", 482, 18087, 18112);
                                } 
                                return (FastMath.log(prod)) + ((Gamma.logGamma(a)) + ((Gamma.logGamma(bred)) - (Beta.logGammaSum(a, bred))));
                            }else {
                                return (Gamma.logGamma(a)) + (Beta.logGammaMinusLogGammaSum(a, b));
                            }
                        }else {
                            return ((Gamma.logGamma(a)) + (Gamma.logGamma(b))) - (Beta.logGammaSum(a, b));
                        }
                    }else {
                        if (b >= 10.0) {
                            return (Gamma.logGamma(a)) + (Beta.logGammaMinusLogGammaSum(a, b));
                        }else {
                            return FastMath.log((((Gamma.gamma(a)) * (Gamma.gamma(b))) / (Gamma.gamma((a + b)))));
                        }
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }
}

