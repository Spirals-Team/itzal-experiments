package org.apache.commons.math3.analysis.polynomials;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

public class PolynomialsUtils {
    private static class JacobiKey {
        private final int v;

        private final int w;

        public JacobiKey(final int v, final int w) {
            ConstructorContext _bcornu_methode_context732 = new ConstructorContext(PolynomialsUtils.JacobiKey.class, 268, 10141, 10357);
            try {
                this.v = v;
                CallChecker.varAssign(this.v, "this.v", 269, 10313, 10323);
                this.w = w;
                CallChecker.varAssign(this.w, "this.w", 270, 10337, 10347);
            } finally {
                _bcornu_methode_context732.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context3293 = new MethodContext(int.class, 277, 10368, 10520);
            try {
                CallChecker.varInit(this, "this", 277, 10368, 10520);
                CallChecker.varInit(this.w, "w", 277, 10368, 10520);
                CallChecker.varInit(this.v, "v", 277, 10368, 10520);
                return ((v) << 16) ^ (w);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3293.methodEnd();
            }
        }

        @Override
        public boolean equals(final Object key) {
            MethodContext _bcornu_methode_context3294 = new MethodContext(boolean.class, 286, 10531, 11028);
            try {
                CallChecker.varInit(this, "this", 286, 10531, 11028);
                CallChecker.varInit(key, "key", 286, 10531, 11028);
                CallChecker.varInit(this.w, "w", 286, 10531, 11028);
                CallChecker.varInit(this.v, "v", 286, 10531, 11028);
                if ((key == null) || (!(key instanceof PolynomialsUtils.JacobiKey))) {
                    return false;
                }
                final PolynomialsUtils.JacobiKey otherK = CallChecker.varInit(((PolynomialsUtils.JacobiKey) (key)), "otherK", 292, 10922, 10962);
                return ((v) == (CallChecker.isCalled(otherK, PolynomialsUtils.JacobiKey.class, 293, 10989, 10994).v)) && ((w) == (CallChecker.isCalled(otherK, PolynomialsUtils.JacobiKey.class, 293, 11008, 11013).w));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3294.methodEnd();
            }
        }
    }

    private interface RecurrenceCoefficientsGenerator {
        BigFraction[] generate(int k);
    }

    private static final List<BigFraction> CHEBYSHEV_COEFFICIENTS;

    private static final List<BigFraction> HERMITE_COEFFICIENTS;

    private static final List<BigFraction> LAGUERRE_COEFFICIENTS;

    private static final List<BigFraction> LEGENDRE_COEFFICIENTS;

    private static final Map<PolynomialsUtils.JacobiKey, List<BigFraction>> JACOBI_COEFFICIENTS;

    static {
        CHEBYSHEV_COEFFICIENTS = new ArrayList<BigFraction>();
        CallChecker.varAssign(CHEBYSHEV_COEFFICIENTS, "PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 55, 1981, 2034);
        if (CallChecker.beforeDeref(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 56, 2044, 2065)) {
            CallChecker.isCalled(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 56, 2044, 2065).add(BigFraction.ONE);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 57, 2097, 2118)) {
            CallChecker.isCalled(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 57, 2097, 2118).add(BigFraction.ZERO);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 58, 2151, 2172)) {
            CallChecker.isCalled(PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, List.class, 58, 2151, 2172).add(BigFraction.ONE);
        }
        HERMITE_COEFFICIENTS = new ArrayList<BigFraction>();
        CallChecker.varAssign(HERMITE_COEFFICIENTS, "PolynomialsUtils.HERMITE_COEFFICIENTS", 62, 2302, 2353);
        if (CallChecker.beforeDeref(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 63, 2363, 2382)) {
            CallChecker.isCalled(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 63, 2363, 2382).add(BigFraction.ONE);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 64, 2414, 2433)) {
            CallChecker.isCalled(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 64, 2414, 2433).add(BigFraction.ZERO);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 65, 2466, 2485)) {
            CallChecker.isCalled(PolynomialsUtils.HERMITE_COEFFICIENTS, List.class, 65, 2466, 2485).add(BigFraction.TWO);
        }
        LAGUERRE_COEFFICIENTS = new ArrayList<BigFraction>();
        CallChecker.varAssign(LAGUERRE_COEFFICIENTS, "PolynomialsUtils.LAGUERRE_COEFFICIENTS", 69, 2616, 2668);
        if (CallChecker.beforeDeref(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 70, 2678, 2698)) {
            CallChecker.isCalled(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 70, 2678, 2698).add(BigFraction.ONE);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 71, 2730, 2750)) {
            CallChecker.isCalled(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 71, 2730, 2750).add(BigFraction.ONE);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 72, 2782, 2802)) {
            CallChecker.isCalled(PolynomialsUtils.LAGUERRE_COEFFICIENTS, List.class, 72, 2782, 2802).add(BigFraction.MINUS_ONE);
        }
        LEGENDRE_COEFFICIENTS = new ArrayList<BigFraction>();
        CallChecker.varAssign(LEGENDRE_COEFFICIENTS, "PolynomialsUtils.LEGENDRE_COEFFICIENTS", 76, 2939, 2991);
        if (CallChecker.beforeDeref(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 77, 3001, 3021)) {
            CallChecker.isCalled(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 77, 3001, 3021).add(BigFraction.ONE);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 78, 3053, 3073)) {
            CallChecker.isCalled(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 78, 3053, 3073).add(BigFraction.ZERO);
        }
        if (CallChecker.beforeDeref(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 79, 3106, 3126)) {
            CallChecker.isCalled(PolynomialsUtils.LEGENDRE_COEFFICIENTS, List.class, 79, 3106, 3126).add(BigFraction.ONE);
        }
        JACOBI_COEFFICIENTS = new HashMap<PolynomialsUtils.JacobiKey, List<BigFraction>>();
        CallChecker.varAssign(JACOBI_COEFFICIENTS, "PolynomialsUtils.JACOBI_COEFFICIENTS", 82, 3208, 3273);
    }

    private PolynomialsUtils() {
        ConstructorContext _bcornu_methode_context733 = new ConstructorContext(PolynomialsUtils.class, 89, 3287, 3390);
        try {
        } finally {
            _bcornu_methode_context733.methodEnd();
        }
    }

    public static PolynomialFunction createChebyshevPolynomial(final int degree) {
        MethodContext _bcornu_methode_context3297 = new MethodContext(PolynomialFunction.class, 105, 3397, 4415);
        try {
            CallChecker.varInit(degree, "degree", 105, 3397, 4415);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 105, 3397, 4415);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 105, 3397, 4415);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 105, 3397, 4415);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 105, 3397, 4415);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 105, 3397, 4415);
            return PolynomialsUtils.buildPolynomial(degree, PolynomialsUtils.CHEBYSHEV_COEFFICIENTS, new PolynomialsUtils.RecurrenceCoefficientsGenerator() {
                private final BigFraction[] coeffs = new BigFraction[]{ BigFraction.ZERO , BigFraction.TWO , BigFraction.ONE };

                public BigFraction[] generate(int k) {
                    MethodContext _bcornu_methode_context3296 = new MethodContext(BigFraction[].class, 110, 4282, 4397);
                    try {
                        CallChecker.varInit(this, "this", 110, 4282, 4397);
                        CallChecker.varInit(k, "k", 110, 4282, 4397);
                        return coeffs;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((BigFraction[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3296.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3297.methodEnd();
        }
    }

    public static PolynomialFunction createHermitePolynomial(final int degree) {
        MethodContext _bcornu_methode_context3299 = new MethodContext(PolynomialFunction.class, 130, 4422, 5422);
        try {
            CallChecker.varInit(degree, "degree", 130, 4422, 5422);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 130, 4422, 5422);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 130, 4422, 5422);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 130, 4422, 5422);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 130, 4422, 5422);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 130, 4422, 5422);
            return PolynomialsUtils.buildPolynomial(degree, PolynomialsUtils.HERMITE_COEFFICIENTS, new PolynomialsUtils.RecurrenceCoefficientsGenerator() {
                public BigFraction[] generate(int k) {
                    MethodContext _bcornu_methode_context3298 = new MethodContext(BigFraction[].class, 134, 5145, 5404);
                    try {
                        CallChecker.varInit(this, "this", 134, 5145, 5404);
                        CallChecker.varInit(k, "k", 134, 5145, 5404);
                        return new BigFraction[]{ BigFraction.ZERO , BigFraction.TWO , new BigFraction((2 * k)) };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((BigFraction[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3298.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3299.methodEnd();
        }
    }

    public static PolynomialFunction createLaguerrePolynomial(final int degree) {
        MethodContext _bcornu_methode_context3301 = new MethodContext(PolynomialFunction.class, 156, 5429, 6528);
        try {
            CallChecker.varInit(degree, "degree", 156, 5429, 6528);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 156, 5429, 6528);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 156, 5429, 6528);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 156, 5429, 6528);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 156, 5429, 6528);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 156, 5429, 6528);
            return PolynomialsUtils.buildPolynomial(degree, PolynomialsUtils.LAGUERRE_COEFFICIENTS, new PolynomialsUtils.RecurrenceCoefficientsGenerator() {
                public BigFraction[] generate(int k) {
                    MethodContext _bcornu_methode_context3300 = new MethodContext(BigFraction[].class, 160, 6187, 6510);
                    try {
                        CallChecker.varInit(this, "this", 160, 6187, 6510);
                        CallChecker.varInit(k, "k", 160, 6187, 6510);
                        final int kP1 = CallChecker.varInit(((int) (k + 1)), "kP1", 161, 6275, 6296);
                        return new BigFraction[]{ new BigFraction(((2 * k) + 1), kP1) , new BigFraction((-1), kP1) , new BigFraction(k, kP1) };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((BigFraction[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3300.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3301.methodEnd();
        }
    }

    public static PolynomialFunction createLegendrePolynomial(final int degree) {
        MethodContext _bcornu_methode_context3303 = new MethodContext(PolynomialFunction.class, 183, 6535, 7631);
        try {
            CallChecker.varInit(degree, "degree", 183, 6535, 7631);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 183, 6535, 7631);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 183, 6535, 7631);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 183, 6535, 7631);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 183, 6535, 7631);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 183, 6535, 7631);
            return PolynomialsUtils.buildPolynomial(degree, PolynomialsUtils.LEGENDRE_COEFFICIENTS, new PolynomialsUtils.RecurrenceCoefficientsGenerator() {
                public BigFraction[] generate(int k) {
                    MethodContext _bcornu_methode_context3302 = new MethodContext(BigFraction[].class, 187, 7300, 7613);
                    try {
                        CallChecker.varInit(this, "this", 187, 7300, 7613);
                        CallChecker.varInit(k, "k", 187, 7300, 7613);
                        final int kP1 = CallChecker.varInit(((int) (k + 1)), "kP1", 188, 7388, 7409);
                        return new BigFraction[]{ BigFraction.ZERO , new BigFraction((k + kP1), kP1) , new BigFraction(k, kP1) };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((BigFraction[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3302.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3303.methodEnd();
        }
    }

    public static PolynomialFunction createJacobiPolynomial(final int degree, final int v, final int w) {
        MethodContext _bcornu_methode_context3305 = new MethodContext(PolynomialFunction.class, 214, 7638, 9917);
        try {
            CallChecker.varInit(w, "w", 214, 7638, 9917);
            CallChecker.varInit(v, "v", 214, 7638, 9917);
            CallChecker.varInit(degree, "degree", 214, 7638, 9917);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 214, 7638, 9917);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 214, 7638, 9917);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 214, 7638, 9917);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 214, 7638, 9917);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 214, 7638, 9917);
            final PolynomialsUtils.JacobiKey key = CallChecker.varInit(new PolynomialsUtils.JacobiKey(v, w), "key", 217, 8557, 8637);
            if (CallChecker.beforeDeref(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 219, 8653, 8671)) {
                if (!(CallChecker.isCalled(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 219, 8653, 8671).containsKey(key))) {
                    final List<BigFraction> list = CallChecker.varInit(new ArrayList<BigFraction>(), "list", 222, 8706, 8809);
                    if (CallChecker.beforeDeref(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 223, 8823, 8841)) {
                        CallChecker.isCalled(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 223, 8823, 8841).put(key, list);
                    }
                    if (CallChecker.beforeDeref(list, List.class, 226, 8902, 8905)) {
                        CallChecker.isCalled(list, List.class, 226, 8902, 8905).add(BigFraction.ONE);
                    }
                    if (CallChecker.beforeDeref(list, List.class, 229, 8999, 9002)) {
                        CallChecker.isCalled(list, List.class, 229, 8999, 9002).add(new BigFraction((v - w), 2));
                    }
                    if (CallChecker.beforeDeref(list, List.class, 230, 9048, 9051)) {
                        CallChecker.isCalled(list, List.class, 230, 9048, 9051).add(new BigFraction(((2 + v) + w), 2));
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 234, 9140, 9158)) {
                return PolynomialsUtils.buildPolynomial(degree, CallChecker.isCalled(PolynomialsUtils.JACOBI_COEFFICIENTS, Map.class, 234, 9140, 9158).get(key), new PolynomialsUtils.RecurrenceCoefficientsGenerator() {
                    public BigFraction[] generate(int k) {
                        MethodContext _bcornu_methode_context3304 = new MethodContext(BigFraction[].class, 237, 9253, 9898);
                        try {
                            CallChecker.varInit(this, "this", 237, 9253, 9898);
                            CallChecker.varInit(k, "k", 237, 9253, 9898);
                            k++;
                            final int kvw = CallChecker.varInit(((int) ((k + v) + w)), "kvw", 239, 9362, 9392);
                            final int twoKvw = CallChecker.varInit(((int) (kvw + k)), "twoKvw", 240, 9410, 9438);
                            final int twoKvwM1 = CallChecker.varInit(((int) (twoKvw - 1)), "twoKvwM1", 241, 9456, 9487);
                            final int twoKvwM2 = CallChecker.varInit(((int) (twoKvw - 2)), "twoKvwM2", 242, 9505, 9536);
                            final int den = CallChecker.varInit(((int) (((2 * k) * kvw) * twoKvwM2)), "den", 243, 9554, 9598);
                            return new BigFraction[]{ new BigFraction((twoKvwM1 * ((v * v) - (w * w))), den) , new BigFraction(((twoKvwM1 * twoKvw) * twoKvwM2), den) , new BigFraction((((2 * ((k + v) - 1)) * ((k + w) - 1)) * twoKvw), den) };
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((BigFraction[]) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context3304.methodEnd();
                        }
                    }
                });
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3305.methodEnd();
        }
    }

    public static double[] shift(final double[] coefficients, final double shift) {
        MethodContext _bcornu_methode_context3306 = new MethodContext(double[].class, 322, 11041, 12913);
        try {
            CallChecker.varInit(shift, "shift", 322, 11041, 12913);
            CallChecker.varInit(coefficients, "coefficients", 322, 11041, 12913);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 322, 11041, 12913);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 322, 11041, 12913);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 322, 11041, 12913);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 322, 11041, 12913);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 322, 11041, 12913);
            final int dp1 = CallChecker.varInit(((int) (CallChecker.isCalled(coefficients, double[].class, 324, 12073, 12084).length)), "dp1", 324, 12057, 12092);
            final double[] newCoefficients = CallChecker.varInit(new double[dp1], "newCoefficients", 325, 12102, 12150);
            final int[][] coeff = CallChecker.varInit(new int[dp1][dp1], "coeff", 328, 12189, 12228);
            for (int i = 0; i < dp1; i++) {
                for (int j = 0; j <= i; j++) {
                    if (CallChecker.beforeDeref(coeff, int[][].class, 331, 12326, 12330)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i], int[].class, 331, 12326, 12333)) {
                            CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i], int[].class, 331, 12326, 12333);
                            CallChecker.isCalled(CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i], int[].class, 331, 12326, 12333)[j] = ((int) (ArithmeticUtils.binomialCoefficient(i, j)));
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i], int[].class, 331, 12326, 12333)[j], "CallChecker.isCalled(CallChecker.isCalled(coeff, int[][].class, 331, 12326, 12330)[i], int[].class, 331, 12326, 12333)[j]", 331, 12326, 12387);
                        }
                    }
                }
            }
            for (int i = 0; i < dp1; i++) {
                if (CallChecker.beforeDeref(newCoefficients, double[].class, 337, 12506, 12520)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 337, 12528, 12539)) {
                        CallChecker.isCalled(newCoefficients, double[].class, 337, 12506, 12520)[0] += (CallChecker.isCalled(coefficients, double[].class, 337, 12528, 12539)[i]) * (FastMath.pow(shift, i));
                        CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 337, 12506, 12520)[0], "CallChecker.isCalled(newCoefficients, double[].class, 337, 12506, 12520)[0]", 337, 12506, 12568);
                    }
                }
            }
            final int d = CallChecker.varInit(((int) (dp1 - 1)), "d", 341, 12589, 12637);
            for (int i = 0; i < d; i++) {
                for (int j = i; j < d; j++) {
                    if (CallChecker.beforeDeref(newCoefficients, double[].class, 344, 12734, 12748)) {
                        if (CallChecker.beforeDeref(coeff, int[][].class, 344, 12760, 12764)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, int[][].class, 344, 12760, 12764)[(j + 1)], int[].class, 344, 12760, 12771)) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 345, 12802, 12813)) {
                                    CallChecker.isCalled(coeff, int[][].class, 344, 12760, 12764)[(j + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, int[][].class, 344, 12760, 12764)[(j + 1)], int[].class, 344, 12760, 12771);
                                    CallChecker.isCalled(newCoefficients, double[].class, 344, 12734, 12748)[(i + 1)] += ((CallChecker.isCalled(CallChecker.isCalled(coeff, int[][].class, 344, 12760, 12764)[(j + 1)], int[].class, 344, 12760, 12771)[(j - i)]) * (CallChecker.isCalled(coefficients, double[].class, 345, 12802, 12813)[(j + 1)])) * (FastMath.pow(shift, (j - i)));
                                    CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 344, 12734, 12748)[(i + 1)], "CallChecker.isCalled(newCoefficients, double[].class, 344, 12734, 12748)[(i + 1)]", 344, 12734, 12850);
                                }
                            }
                        }
                    }
                }
            }
            return newCoefficients;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3306.methodEnd();
        }
    }

    private static PolynomialFunction buildPolynomial(final int degree, final List<BigFraction> coefficients, final PolynomialsUtils.RecurrenceCoefficientsGenerator generator) {
        MethodContext _bcornu_methode_context3307 = new MethodContext(PolynomialFunction.class, 359, 12921, 14590);
        try {
            CallChecker.varInit(generator, "generator", 359, 12921, 14590);
            CallChecker.varInit(coefficients, "coefficients", 359, 12921, 14590);
            CallChecker.varInit(degree, "degree", 359, 12921, 14590);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 359, 12921, 14590);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 359, 12921, 14590);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 359, 12921, 14590);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 359, 12921, 14590);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 359, 12921, 14590);
            final int maxDegree = CallChecker.varInit(((int) (((int) (FastMath.floor(FastMath.sqrt((2 * (CallChecker.isCalled(coefficients, List.class, 363, 13532, 13543).size())))))) - 1)), "maxDegree", 363, 13471, 13557);
            synchronized(PolynomialsUtils.class) {
                if (degree > maxDegree) {
                    PolynomialsUtils.computeUpToDegree(degree, maxDegree, generator, coefficients);
                }
            }
            final int start = CallChecker.varInit(((int) ((degree * (degree + 1)) / 2)), "start", 378, 13757, 14340);
            final double[] a = CallChecker.varInit(new double[degree + 1], "a", 380, 14351, 14392);
            for (int i = 0; i <= degree; ++i) {
                if (CallChecker.beforeDeref(a, double[].class, 382, 14450, 14450)) {
                    if (CallChecker.beforeDeref(coefficients, List.class, 382, 14457, 14468)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(coefficients, List.class, 382, 14457, 14468).get((start + i)), BigFraction.class, 382, 14457, 14483)) {
                            CallChecker.isCalled(a, double[].class, 382, 14450, 14450)[i] = CallChecker.isCalled(CallChecker.isCalled(coefficients, List.class, 382, 14457, 14468).get((start + i)), BigFraction.class, 382, 14457, 14483).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 382, 14450, 14450)[i], "CallChecker.isCalled(a, double[].class, 382, 14450, 14450)[i]", 382, 14450, 14498);
                        }
                    }
                }
            }
            return new PolynomialFunction(a);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3307.methodEnd();
        }
    }

    private static void computeUpToDegree(final int degree, final int maxDegree, final PolynomialsUtils.RecurrenceCoefficientsGenerator generator, final List<BigFraction> coefficients) {
        MethodContext _bcornu_methode_context3308 = new MethodContext(void.class, 396, 14597, 16429);
        try {
            CallChecker.varInit(coefficients, "coefficients", 396, 14597, 16429);
            CallChecker.varInit(generator, "generator", 396, 14597, 16429);
            CallChecker.varInit(maxDegree, "maxDegree", 396, 14597, 16429);
            CallChecker.varInit(degree, "degree", 396, 14597, 16429);
            CallChecker.varInit(JACOBI_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.JACOBI_COEFFICIENTS", 396, 14597, 16429);
            CallChecker.varInit(LEGENDRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LEGENDRE_COEFFICIENTS", 396, 14597, 16429);
            CallChecker.varInit(LAGUERRE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.LAGUERRE_COEFFICIENTS", 396, 14597, 16429);
            CallChecker.varInit(HERMITE_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.HERMITE_COEFFICIENTS", 396, 14597, 16429);
            CallChecker.varInit(CHEBYSHEV_COEFFICIENTS, "org.apache.commons.math3.analysis.polynomials.PolynomialsUtils.CHEBYSHEV_COEFFICIENTS", 396, 14597, 16429);
            int startK = CallChecker.varInit(((int) (((maxDegree - 1) * maxDegree) / 2)), "startK", 400, 15150, 15194);
            for (int k = maxDegree; k < degree; ++k) {
                int startKm1 = CallChecker.varInit(((int) (startK)), "startKm1", 404, 15335, 15356);
                startK += k;
                CallChecker.varAssign(startK, "startK", 405, 15370, 15381);
                BigFraction[] ai = CallChecker.init(BigFraction[].class);
                if (CallChecker.beforeDeref(generator, PolynomialsUtils.RecurrenceCoefficientsGenerator.class, 408, 15477, 15485)) {
                    ai = CallChecker.isCalled(generator, PolynomialsUtils.RecurrenceCoefficientsGenerator.class, 408, 15477, 15485).generate(k);
                    CallChecker.varAssign(ai, "ai", 408, 15477, 15485);
                }
                BigFraction ck = CallChecker.init(BigFraction.class);
                if (CallChecker.beforeDeref(coefficients, List.class, 410, 15534, 15545)) {
                    ck = CallChecker.isCalled(coefficients, List.class, 410, 15534, 15545).get(startK);
                    CallChecker.varAssign(ck, "ck", 410, 15534, 15545);
                }
                BigFraction ckm1 = CallChecker.init(BigFraction.class);
                if (CallChecker.beforeDeref(coefficients, List.class, 411, 15593, 15604)) {
                    ckm1 = CallChecker.isCalled(coefficients, List.class, 411, 15593, 15604).get(startKm1);
                    CallChecker.varAssign(ckm1, "ckm1", 411, 15593, 15604);
                }
                if (CallChecker.beforeDeref(ai, BigFraction[].class, 414, 15699, 15700)) {
                    if (CallChecker.beforeDeref(ck, BigFraction.class, 414, 15687, 15688)) {
                        if (CallChecker.beforeDeref(ai, BigFraction[].class, 414, 15729, 15730)) {
                            if (CallChecker.beforeDeref(ckm1, BigFraction.class, 414, 15715, 15718)) {
                                ai = CallChecker.beforeCalled(ai, BigFraction[].class, 414, 15699, 15700);
                                ck = CallChecker.beforeCalled(ck, BigFraction.class, 414, 15687, 15688);
                                final BigFraction npe_invocation_var793 = CallChecker.isCalled(ck, BigFraction.class, 414, 15687, 15688).multiply(CallChecker.isCalled(ai, BigFraction[].class, 414, 15699, 15700)[0]);
                                if (CallChecker.beforeDeref(npe_invocation_var793, BigFraction.class, 414, 15687, 15704)) {
                                    if (CallChecker.beforeDeref(coefficients, List.class, 414, 15670, 15681)) {
                                        ai = CallChecker.beforeCalled(ai, BigFraction[].class, 414, 15729, 15730);
                                        ckm1 = CallChecker.beforeCalled(ckm1, BigFraction.class, 414, 15715, 15718);
                                        CallChecker.isCalled(coefficients, List.class, 414, 15670, 15681).add(CallChecker.isCalled(npe_invocation_var793, BigFraction.class, 414, 15687, 15704).subtract(CallChecker.isCalled(ckm1, BigFraction.class, 414, 15715, 15718).multiply(CallChecker.isCalled(ai, BigFraction[].class, 414, 15729, 15730)[2])));
                                    }
                                }
                            }
                        }
                    }
                }
                for (int i = 1; i < k; ++i) {
                    final BigFraction ckPrev = CallChecker.varInit(ck, "ckPrev", 418, 15849, 15878);
                    if (CallChecker.beforeDeref(coefficients, List.class, 419, 15905, 15916)) {
                        ck = CallChecker.isCalled(coefficients, List.class, 419, 15905, 15916).get((startK + i));
                        CallChecker.varAssign(ck, "ck", 419, 15896, 15933);
                    }
                    if (CallChecker.beforeDeref(coefficients, List.class, 420, 15960, 15971)) {
                        ckm1 = CallChecker.isCalled(coefficients, List.class, 420, 15960, 15971).get((startKm1 + i));
                        CallChecker.varAssign(ckm1, "ckm1", 420, 15951, 15990);
                    }
                    if (CallChecker.beforeDeref(ai, BigFraction[].class, 421, 16037, 16038)) {
                        if (CallChecker.beforeDeref(ck, BigFraction.class, 421, 16025, 16026)) {
                            if (CallChecker.beforeDeref(ai, BigFraction[].class, 421, 16064, 16065)) {
                                if (CallChecker.beforeDeref(ckPrev, BigFraction.class, 421, 16048, 16053)) {
                                    ai = CallChecker.beforeCalled(ai, BigFraction[].class, 421, 16037, 16038);
                                    ck = CallChecker.beforeCalled(ck, BigFraction.class, 421, 16025, 16026);
                                    final BigFraction npe_invocation_var794 = CallChecker.isCalled(ck, BigFraction.class, 421, 16025, 16026).multiply(CallChecker.isCalled(ai, BigFraction[].class, 421, 16037, 16038)[0]);
                                    if (CallChecker.beforeDeref(npe_invocation_var794, BigFraction.class, 421, 16025, 16042)) {
                                        if (CallChecker.beforeDeref(ai, BigFraction[].class, 421, 16095, 16096)) {
                                            if (CallChecker.beforeDeref(ckm1, BigFraction.class, 421, 16081, 16084)) {
                                                ai = CallChecker.beforeCalled(ai, BigFraction[].class, 421, 16064, 16065);
                                                final BigFraction npe_invocation_var795 = CallChecker.isCalled(npe_invocation_var794, BigFraction.class, 421, 16025, 16042).add(CallChecker.isCalled(ckPrev, BigFraction.class, 421, 16048, 16053).multiply(CallChecker.isCalled(ai, BigFraction[].class, 421, 16064, 16065)[1]));
                                                if (CallChecker.beforeDeref(npe_invocation_var795, BigFraction.class, 421, 16025, 16070)) {
                                                    if (CallChecker.beforeDeref(coefficients, List.class, 421, 16008, 16019)) {
                                                        ai = CallChecker.beforeCalled(ai, BigFraction[].class, 421, 16095, 16096);
                                                        ckm1 = CallChecker.beforeCalled(ckm1, BigFraction.class, 421, 16081, 16084);
                                                        CallChecker.isCalled(coefficients, List.class, 421, 16008, 16019).add(CallChecker.isCalled(npe_invocation_var795, BigFraction.class, 421, 16025, 16070).subtract(CallChecker.isCalled(ckm1, BigFraction.class, 421, 16081, 16084).multiply(CallChecker.isCalled(ai, BigFraction[].class, 421, 16095, 16096)[2])));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                final BigFraction ckPrev = CallChecker.varInit(ck, "ckPrev", 425, 16132, 16197);
                if (CallChecker.beforeDeref(coefficients, List.class, 426, 16216, 16227)) {
                    ck = CallChecker.isCalled(coefficients, List.class, 426, 16216, 16227).get((startK + k));
                    CallChecker.varAssign(ck, "ck", 426, 16211, 16244);
                }
                if (CallChecker.beforeDeref(ai, BigFraction[].class, 427, 16287, 16288)) {
                    if (CallChecker.beforeDeref(ck, BigFraction.class, 427, 16275, 16276)) {
                        if (CallChecker.beforeDeref(ai, BigFraction[].class, 427, 16314, 16315)) {
                            if (CallChecker.beforeDeref(ckPrev, BigFraction.class, 427, 16298, 16303)) {
                                ai = CallChecker.beforeCalled(ai, BigFraction[].class, 427, 16287, 16288);
                                ck = CallChecker.beforeCalled(ck, BigFraction.class, 427, 16275, 16276);
                                final BigFraction npe_invocation_var796 = CallChecker.isCalled(ck, BigFraction.class, 427, 16275, 16276).multiply(CallChecker.isCalled(ai, BigFraction[].class, 427, 16287, 16288)[0]);
                                if (CallChecker.beforeDeref(npe_invocation_var796, BigFraction.class, 427, 16275, 16292)) {
                                    if (CallChecker.beforeDeref(coefficients, List.class, 427, 16258, 16269)) {
                                        ai = CallChecker.beforeCalled(ai, BigFraction[].class, 427, 16314, 16315);
                                        CallChecker.isCalled(coefficients, List.class, 427, 16258, 16269).add(CallChecker.isCalled(npe_invocation_var796, BigFraction.class, 427, 16275, 16292).add(CallChecker.isCalled(ckPrev, BigFraction.class, 427, 16298, 16303).multiply(CallChecker.isCalled(ai, BigFraction[].class, 427, 16314, 16315)[1])));
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(ai, BigFraction[].class, 430, 16404, 16405)) {
                    if (CallChecker.beforeDeref(ck, BigFraction.class, 430, 16392, 16393)) {
                        if (CallChecker.beforeDeref(coefficients, List.class, 430, 16375, 16386)) {
                            ai = CallChecker.beforeCalled(ai, BigFraction[].class, 430, 16404, 16405);
                            ck = CallChecker.beforeCalled(ck, BigFraction.class, 430, 16392, 16393);
                            CallChecker.isCalled(coefficients, List.class, 430, 16375, 16386).add(CallChecker.isCalled(ck, BigFraction.class, 430, 16392, 16393).multiply(CallChecker.isCalled(ai, BigFraction[].class, 430, 16404, 16405)[1]));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3308.methodEnd();
        }
    }
}

