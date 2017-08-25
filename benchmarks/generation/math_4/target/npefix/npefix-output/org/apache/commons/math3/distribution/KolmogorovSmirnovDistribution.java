package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.fraction.FractionConversionException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class KolmogorovSmirnovDistribution implements Serializable {
    private static final long serialVersionUID = -4670676796862967187L;

    private int n;

    public KolmogorovSmirnovDistribution(int n) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context379 = new ConstructorContext(KolmogorovSmirnovDistribution.class, 84, 3243, 3611);
        try {
            if (n <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, n);
            }
            this.n = n;
            CallChecker.varAssign(this.n, "this.n", 90, 3595, 3605);
        } finally {
            _bcornu_methode_context379.methodEnd();
        }
    }

    public double cdf(double d) throws MathArithmeticException {
        MethodContext _bcornu_methode_context1651 = new MethodContext(double.class, 108, 3618, 4456);
        try {
            CallChecker.varInit(this, "this", 108, 3618, 4456);
            CallChecker.varInit(d, "d", 108, 3618, 4456);
            CallChecker.varInit(this.n, "n", 108, 3618, 4456);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 108, 3618, 4456);
            return this.cdf(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1651.methodEnd();
        }
    }

    public double cdfExact(double d) throws MathArithmeticException {
        MethodContext _bcornu_methode_context1652 = new MethodContext(double.class, 128, 4463, 5428);
        try {
            CallChecker.varInit(this, "this", 128, 4463, 5428);
            CallChecker.varInit(d, "d", 128, 4463, 5428);
            CallChecker.varInit(this.n, "n", 128, 4463, 5428);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 128, 4463, 5428);
            return this.cdf(d, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1652.methodEnd();
        }
    }

    public double cdf(double d, boolean exact) throws MathArithmeticException {
        MethodContext _bcornu_methode_context1653 = new MethodContext(double.class, 149, 5435, 7077);
        try {
            CallChecker.varInit(this, "this", 149, 5435, 7077);
            CallChecker.varInit(exact, "exact", 149, 5435, 7077);
            CallChecker.varInit(d, "d", 149, 5435, 7077);
            CallChecker.varInit(this.n, "n", 149, 5435, 7077);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 149, 5435, 7077);
            final double ninv = CallChecker.varInit(((double) (1 / ((double) (this.n)))), "ninv", 151, 6454, 6490);
            final double ninvhalf = CallChecker.varInit(((double) (0.5 * ninv)), "ninvhalf", 152, 6500, 6534);
            if (d <= ninvhalf) {
                return 0;
            }else
                if ((ninvhalf < d) && (d <= ninv)) {
                    double res = CallChecker.varInit(((double) (1)), "res", 160, 6651, 6665);
                    double f = CallChecker.varInit(((double) ((2 * d) - ninv)), "f", 161, 6679, 6702);
                    for (int i = 1; i <= (n); ++i) {
                        res *= i * f;
                        CallChecker.varAssign(res, "res", 165, 6814, 6826);
                    }
                    return res;
                }else
                    if (((1 - ninv) <= d) && (d < 1)) {
                        return 1 - (2 * (Math.pow((1 - d), n)));
                    }else
                        if (1 <= d) {
                            return 1;
                        }
                    
                
            
            if (exact) {
                return exactK(d);
            }else {
                return roundedK(d);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1653.methodEnd();
        }
    }

    private double exactK(double d) throws MathArithmeticException {
        MethodContext _bcornu_methode_context1654 = new MethodContext(double.class, 194, 7084, 8338);
        try {
            CallChecker.varInit(this, "this", 194, 7084, 8338);
            CallChecker.varInit(d, "d", 194, 7084, 8338);
            CallChecker.varInit(this.n, "n", 194, 7084, 8338);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 194, 7084, 8338);
            final int k = CallChecker.varInit(((int) ((int) (Math.ceil(((this.n) * d))))), "k", 196, 7696, 7732);
            final FieldMatrix<BigFraction> H = CallChecker.varInit(this.createH(d), "H", 198, 7743, 7793);
            final FieldMatrix<BigFraction> Hpower = CallChecker.varInit(CallChecker.isCalled(H, FieldMatrix.class, 199, 7843, 7843).power(n), "Hpower", 199, 7803, 7853);
            BigFraction pFrac = CallChecker.init(BigFraction.class);
            if (CallChecker.beforeDeref(Hpower, FieldMatrix.class, 201, 7884, 7889)) {
                pFrac = CallChecker.isCalled(Hpower, FieldMatrix.class, 201, 7884, 7889).getEntry((k - 1), (k - 1));
                CallChecker.varAssign(pFrac, "pFrac", 201, 7884, 7889);
            }
            for (int i = 1; i <= (n); ++i) {
                if (CallChecker.beforeDeref(pFrac, BigFraction.class, 204, 7975, 7979)) {
                    pFrac = CallChecker.beforeCalled(pFrac, BigFraction.class, 204, 7975, 7979);
                    final BigFraction npe_invocation_var151 = CallChecker.isCalled(pFrac, BigFraction.class, 204, 7975, 7979).multiply(i);
                    if (CallChecker.beforeDeref(npe_invocation_var151, BigFraction.class, 204, 7975, 7991)) {
                        pFrac = CallChecker.isCalled(npe_invocation_var151, BigFraction.class, 204, 7975, 7991).divide(n);
                        CallChecker.varAssign(pFrac, "pFrac", 204, 7967, 8002);
                    }
                }
            }
            if (CallChecker.beforeDeref(pFrac, BigFraction.class, 212, 8267, 8271)) {
                pFrac = CallChecker.beforeCalled(pFrac, BigFraction.class, 212, 8267, 8271);
                final BigDecimal npe_invocation_var152 = CallChecker.isCalled(pFrac, BigFraction.class, 212, 8267, 8271).bigDecimalValue(20, BigDecimal.ROUND_HALF_UP);
                if (CallChecker.beforeDeref(npe_invocation_var152, BigDecimal.class, 212, 8267, 8317)) {
                    return CallChecker.isCalled(npe_invocation_var152, BigDecimal.class, 212, 8267, 8317).doubleValue();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1654.methodEnd();
        }
    }

    private double roundedK(double d) throws MathArithmeticException {
        MethodContext _bcornu_methode_context1655 = new MethodContext(double.class, 226, 8345, 9655);
        try {
            CallChecker.varInit(this, "this", 226, 8345, 9655);
            CallChecker.varInit(d, "d", 226, 8345, 9655);
            CallChecker.varInit(this.n, "n", 226, 8345, 9655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 226, 8345, 9655);
            final int k = CallChecker.varInit(((int) ((int) (Math.ceil(((this.n) * d))))), "k", 228, 8887, 8923);
            final FieldMatrix<BigFraction> HBigFraction = CallChecker.varInit(this.createH(d), "HBigFraction", 229, 8933, 8994);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(HBigFraction, FieldMatrix.class, 230, 9018, 9029).getRowDimension())), "m", 230, 9004, 9048);
            final RealMatrix H = CallChecker.varInit(new Array2DRowRealMatrix(m, m), "H", 236, 9059, 9246);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (CallChecker.beforeDeref(HBigFraction, FieldMatrix.class, 240, 9362, 9373)) {
                        final BigFraction npe_invocation_var153 = CallChecker.isCalled(HBigFraction, FieldMatrix.class, 240, 9362, 9373).getEntry(i, j);
                        if (CallChecker.beforeDeref(npe_invocation_var153, BigFraction.class, 240, 9362, 9388)) {
                            if (CallChecker.beforeDeref(H, RealMatrix.class, 240, 9345, 9345)) {
                                CallChecker.isCalled(H, RealMatrix.class, 240, 9345, 9345).setEntry(i, j, CallChecker.isCalled(npe_invocation_var153, BigFraction.class, 240, 9362, 9388).doubleValue());
                            }
                        }
                    }
                }
            }
            final RealMatrix Hpower = CallChecker.varInit(CallChecker.isCalled(H, RealMatrix.class, 244, 9465, 9465).power(n), "Hpower", 244, 9439, 9475);
            double pFrac = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(Hpower, RealMatrix.class, 246, 9501, 9506)) {
                pFrac = CallChecker.isCalled(Hpower, RealMatrix.class, 246, 9501, 9506).getEntry((k - 1), (k - 1));
                CallChecker.varAssign(pFrac, "pFrac", 246, 9501, 9506);
            }
            for (int i = 1; i <= (n); ++i) {
                pFrac *= ((double) (i)) / ((double) (n));
                CallChecker.varAssign(pFrac, "pFrac", 249, 9584, 9616);
            }
            return pFrac;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1655.methodEnd();
        }
    }

    private FieldMatrix<BigFraction> createH(double d) throws NumberIsTooLargeException, FractionConversionException {
        MethodContext _bcornu_methode_context1656 = new MethodContext(FieldMatrix.class, 266, 9662, 13282);
        try {
            CallChecker.varInit(this, "this", 266, 9662, 13282);
            CallChecker.varInit(d, "d", 266, 9662, 13282);
            CallChecker.varInit(this.n, "n", 266, 9662, 13282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution.serialVersionUID", 266, 9662, 13282);
            int k = CallChecker.varInit(((int) ((int) (Math.ceil(((this.n) * d))))), "k", 269, 10289, 10319);
            int m = CallChecker.varInit(((int) ((2 * k) - 1)), "m", 271, 10330, 10347);
            double hDouble = CallChecker.varInit(((double) (k - ((this.n) * d))), "hDouble", 272, 10357, 10383);
            if (hDouble >= 1) {
                throw new NumberIsTooLargeException(hDouble, 1.0, false);
            }
            BigFraction h = CallChecker.varInit(null, "h", 278, 10503, 10523);
            TryContext _bcornu_try_context_27 = new TryContext(27, KolmogorovSmirnovDistribution.class, "org.apache.commons.math3.fraction.FractionConversionException");
            try {
                h = new BigFraction(hDouble, 1.0E-20, 10000);
                CallChecker.varAssign(h, "h", 281, 10552, 10596);
            } catch (FractionConversionException e1) {
                _bcornu_try_context_27.catchStart(27);
                TryContext _bcornu_try_context_26 = new TryContext(26, KolmogorovSmirnovDistribution.class, "org.apache.commons.math3.fraction.FractionConversionException");
                try {
                    h = new BigFraction(hDouble, 1.0E-10, 10000);
                    CallChecker.varAssign(h, "h", 284, 10683, 10727);
                } catch (FractionConversionException e2) {
                    _bcornu_try_context_26.catchStart(26);
                    h = new BigFraction(hDouble, 1.0E-5, 10000);
                    CallChecker.varAssign(h, "h", 286, 10800, 10843);
                } finally {
                    _bcornu_try_context_26.finallyStart(26);
                }
            } finally {
                _bcornu_try_context_27.finallyStart(27);
            }
            final BigFraction[][] Hdata = CallChecker.varInit(new BigFraction[m][m], "Hdata", 290, 10878, 10929);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (((i - j) + 1) < 0) {
                        if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 298, 11151, 11155)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i], BigFraction[].class, 298, 11151, 11158)) {
                                CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i], BigFraction[].class, 298, 11151, 11158);
                                CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i], BigFraction[].class, 298, 11151, 11158)[j] = BigFraction.ZERO;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i], BigFraction[].class, 298, 11151, 11158)[j], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 298, 11151, 11155)[i], BigFraction[].class, 298, 11151, 11158)[j]", 298, 11151, 11181);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 300, 11228, 11232)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i], BigFraction[].class, 300, 11228, 11235)) {
                                CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i], BigFraction[].class, 300, 11228, 11235);
                                CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i], BigFraction[].class, 300, 11228, 11235)[j] = BigFraction.ONE;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i], BigFraction[].class, 300, 11228, 11235)[j], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 300, 11228, 11232)[i], BigFraction[].class, 300, 11228, 11235)[j]", 300, 11228, 11257);
                            }
                        }
                    }
                }
            }
            final BigFraction[] hPowers = CallChecker.varInit(new BigFraction[m], "hPowers", 309, 11461, 11509);
            if (CallChecker.beforeDeref(hPowers, BigFraction[].class, 310, 11519, 11525)) {
                CallChecker.isCalled(hPowers, BigFraction[].class, 310, 11519, 11525)[0] = h;
                CallChecker.varAssign(CallChecker.isCalled(hPowers, BigFraction[].class, 310, 11519, 11525)[0], "CallChecker.isCalled(hPowers, BigFraction[].class, 310, 11519, 11525)[0]", 310, 11519, 11533);
            }
            for (int i = 1; i < m; ++i) {
                if (CallChecker.beforeDeref(hPowers, BigFraction[].class, 312, 11585, 11591)) {
                    if (CallChecker.beforeDeref(hPowers, BigFraction[].class, 312, 11609, 11615)) {
                        if (CallChecker.beforeDeref(h, BigFraction.class, 312, 11598, 11598)) {
                            h = CallChecker.beforeCalled(h, BigFraction.class, 312, 11598, 11598);
                            CallChecker.isCalled(hPowers, BigFraction[].class, 312, 11585, 11591)[i] = CallChecker.isCalled(h, BigFraction.class, 312, 11598, 11598).multiply(CallChecker.isCalled(hPowers, BigFraction[].class, 312, 11609, 11615)[(i - 1)]);
                            CallChecker.varAssign(CallChecker.isCalled(hPowers, BigFraction[].class, 312, 11585, 11591)[i], "CallChecker.isCalled(hPowers, BigFraction[].class, 312, 11585, 11591)[i]", 312, 11585, 11624);
                        }
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 319, 11789, 11793)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i], BigFraction[].class, 319, 11789, 11796)) {
                        if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 319, 11803, 11807)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810)) {
                                if (CallChecker.beforeDeref(hPowers, BigFraction[].class, 319, 11824, 11830)) {
                                    CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810)[0], BigFraction.class, 319, 11803, 11813)) {
                                        CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i], BigFraction[].class, 319, 11789, 11796);
                                        CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810);
                                        CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810)[0] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810)[0], BigFraction.class, 319, 11803, 11813);
                                        CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i], BigFraction[].class, 319, 11789, 11796)[0] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11803, 11807)[i], BigFraction[].class, 319, 11803, 11810)[0], BigFraction.class, 319, 11803, 11813).subtract(CallChecker.isCalled(hPowers, BigFraction[].class, 319, 11824, 11830)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i], BigFraction[].class, 319, 11789, 11796)[0], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 319, 11789, 11793)[i], BigFraction[].class, 319, 11789, 11796)[0]", 319, 11789, 11835);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 320, 11849, 11853)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)], BigFraction[].class, 320, 11849, 11860)) {
                        if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 320, 11867, 11871)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878)) {
                                if (CallChecker.beforeDeref(hPowers, BigFraction[].class, 320, 11892, 11898)) {
                                    CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878)[i], BigFraction.class, 320, 11867, 11881)) {
                                        CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)], BigFraction[].class, 320, 11849, 11860);
                                        CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878);
                                        CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878)[i], BigFraction.class, 320, 11867, 11881);
                                        CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)], BigFraction[].class, 320, 11849, 11860)[i] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11867, 11871)[(m - 1)], BigFraction[].class, 320, 11867, 11878)[i], BigFraction.class, 320, 11867, 11881).subtract(CallChecker.isCalled(hPowers, BigFraction[].class, 320, 11892, 11898)[((m - i) - 1)]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)], BigFraction[].class, 320, 11849, 11860)[i], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 320, 11849, 11853)[(m - 1)], BigFraction[].class, 320, 11849, 11860)[i]", 320, 11849, 11911);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(h, BigFraction.class, 328, 12157, 12157)) {
                h = CallChecker.beforeCalled(h, BigFraction.class, 328, 12157, 12157);
                if ((CallChecker.isCalled(h, BigFraction.class, 328, 12157, 12157).compareTo(BigFraction.ONE_HALF)) == 1) {
                    if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 329, 12211, 12215)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)], BigFraction[].class, 329, 12211, 12222)) {
                            if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 329, 12229, 12233)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240)) {
                                    if (CallChecker.beforeDeref(h, BigFraction.class, 329, 12249, 12249)) {
                                        h = CallChecker.beforeCalled(h, BigFraction.class, 329, 12249, 12249);
                                        final BigFraction npe_invocation_var154 = CallChecker.isCalled(h, BigFraction.class, 329, 12249, 12249).multiply(2);
                                        if (CallChecker.beforeDeref(npe_invocation_var154, BigFraction.class, 329, 12249, 12261)) {
                                            final BigFraction npe_invocation_var155 = CallChecker.isCalled(npe_invocation_var154, BigFraction.class, 329, 12249, 12261).subtract(1);
                                            if (CallChecker.beforeDeref(npe_invocation_var155, BigFraction.class, 329, 12249, 12273)) {
                                                CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240)[0], BigFraction.class, 329, 12229, 12243)) {
                                                    CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)], BigFraction[].class, 329, 12211, 12222);
                                                    CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240);
                                                    CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240)[0] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240)[0], BigFraction.class, 329, 12229, 12243);
                                                    CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)], BigFraction[].class, 329, 12211, 12222)[0] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12229, 12233)[(m - 1)], BigFraction[].class, 329, 12229, 12240)[0], BigFraction.class, 329, 12229, 12243).add(CallChecker.isCalled(npe_invocation_var155, BigFraction.class, 329, 12249, 12273).pow(m));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)], BigFraction[].class, 329, 12211, 12222)[0], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 329, 12211, 12215)[(m - 1)], BigFraction[].class, 329, 12211, 12222)[0]", 329, 12211, 12282);
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
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < (i + 1); ++j) {
                    if (((i - j) + 1) > 0) {
                        for (int g = 2; g <= ((i - j) + 1); ++g) {
                            if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 347, 13082, 13086)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i], BigFraction[].class, 347, 13082, 13089)) {
                                    if (CallChecker.beforeDeref(Hdata, BigFraction[][].class, 347, 13096, 13100)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103)) {
                                            CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103)[j], BigFraction.class, 347, 13096, 13106)) {
                                                CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i], BigFraction[].class, 347, 13082, 13089);
                                                CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i] = CallChecker.beforeCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103);
                                                CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103)[j], BigFraction.class, 347, 13096, 13106);
                                                CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i], BigFraction[].class, 347, 13082, 13089)[j] = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13096, 13100)[i], BigFraction[].class, 347, 13096, 13103)[j], BigFraction.class, 347, 13096, 13106).divide(g);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i], BigFraction[].class, 347, 13082, 13089)[j], "CallChecker.isCalled(CallChecker.isCalled(Hdata, BigFraction[][].class, 347, 13082, 13086)[i], BigFraction[].class, 347, 13082, 13089)[j]", 347, 13082, 13117);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowFieldMatrix<BigFraction>(BigFractionField.getInstance(), Hdata);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<BigFraction>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1656.methodEnd();
        }
    }
}

