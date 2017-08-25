package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

public abstract class AbstractIntegerDistribution implements Serializable , IntegerDistribution {
    private static final long serialVersionUID = -1146319659338487221L;

    @Deprecated
    protected final RandomDataImpl randomData = new RandomDataImpl();

    protected final RandomGenerator random;

    @Deprecated
    protected AbstractIntegerDistribution() {
        ConstructorContext _bcornu_methode_context262 = new ConstructorContext(AbstractIntegerDistribution.class, 61, 2235, 2609);
        try {
            random = null;
            CallChecker.varAssign(this.random, "this.random", 64, 2590, 2603);
        } finally {
            _bcornu_methode_context262.methodEnd();
        }
    }

    protected AbstractIntegerDistribution(RandomGenerator rng) {
        ConstructorContext _bcornu_methode_context263 = new ConstructorContext(AbstractIntegerDistribution.class, 71, 2616, 2780);
        try {
            random = rng;
            CallChecker.varAssign(this.random, "this.random", 72, 2762, 2774);
        } finally {
            _bcornu_methode_context263.methodEnd();
        }
    }

    public double cumulativeProbability(int x0, int x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context1145 = new MethodContext(double.class, 81, 2787, 3278);
        try {
            CallChecker.varInit(this, "this", 81, 2787, 3278);
            CallChecker.varInit(x1, "x1", 81, 2787, 3278);
            CallChecker.varInit(x0, "x0", 81, 2787, 3278);
            CallChecker.varInit(this.random, "random", 81, 2787, 3278);
            CallChecker.varInit(this.randomData, "randomData", 81, 2787, 3278);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 81, 2787, 3278);
            if (x1 < x0) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, x0, x1, true);
            }
            return (cumulativeProbability(x1)) - (cumulativeProbability(x0));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1145.methodEnd();
        }
    }

    public int inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1146 = new MethodContext(int.class, 100, 3285, 5245);
        try {
            CallChecker.varInit(this, "this", 100, 3285, 5245);
            CallChecker.varInit(p, "p", 100, 3285, 5245);
            CallChecker.varInit(this.random, "random", 100, 3285, 5245);
            CallChecker.varInit(this.randomData, "randomData", 100, 3285, 5245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 100, 3285, 5245);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            int lower = CallChecker.varInit(((int) (getSupportLowerBound())), "lower", 105, 3835, 3869);
            if (p == 0.0) {
                return lower;
            }
            if (lower == (Integer.MIN_VALUE)) {
                if ((checkedCumulativeProbability(lower)) >= p) {
                    return lower;
                }
            }else {
                lower -= 1;
                CallChecker.varAssign(lower, "lower", 114, 4106, 4116);
            }
            int upper = CallChecker.varInit(((int) (getSupportUpperBound())), "upper", 118, 4254, 4288);
            if (p == 1.0) {
                return upper;
            }
            final double mu = CallChecker.varInit(((double) (getNumericalMean())), "mu", 125, 4359, 4544);
            final double sigma = CallChecker.varInit(((double) (FastMath.sqrt(getNumericalVariance()))), "sigma", 126, 4554, 4612);
            final boolean chebyshevApplies = CallChecker.varInit(((boolean) (!(((((Double.isInfinite(mu)) || (Double.isNaN(mu))) || (Double.isInfinite(sigma))) || (Double.isNaN(sigma))) || (sigma == 0.0)))), "chebyshevApplies", 127, 4622, 4782);
            if (chebyshevApplies) {
                double k = CallChecker.varInit(((double) (FastMath.sqrt(((1.0 - p) / p)))), "k", 130, 4828, 4867);
                double tmp = CallChecker.varInit(((double) (mu - (k * sigma))), "tmp", 131, 4881, 4908);
                if (tmp > lower) {
                    lower = ((int) (Math.ceil(tmp))) - 1;
                    CallChecker.varAssign(lower, "lower", 133, 4957, 4991);
                }
                k = 1.0 / k;
                CallChecker.varAssign(k, "k", 135, 5019, 5030);
                tmp = mu + (k * sigma);
                CallChecker.varAssign(tmp, "tmp", 136, 5044, 5064);
                if (tmp < upper) {
                    upper = ((int) (Math.ceil(tmp))) - 1;
                    CallChecker.varAssign(upper, "upper", 138, 5113, 5147);
                }
            }
            return solveInverseCumulativeProbability(p, lower, upper);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1146.methodEnd();
        }
    }

    protected int solveInverseCumulativeProbability(final double p, int lower, int upper) {
        MethodContext _bcornu_methode_context1147 = new MethodContext(int.class, 157, 5252, 6580);
        try {
            CallChecker.varInit(this, "this", 157, 5252, 6580);
            CallChecker.varInit(upper, "upper", 157, 5252, 6580);
            CallChecker.varInit(lower, "lower", 157, 5252, 6580);
            CallChecker.varInit(p, "p", 157, 5252, 6580);
            CallChecker.varInit(this.random, "random", 157, 5252, 6580);
            CallChecker.varInit(this.randomData, "randomData", 157, 5252, 6580);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 157, 5252, 6580);
            while ((lower + 1) < upper) {
                int xm = CallChecker.varInit(((int) ((lower + upper) / 2)), "xm", 159, 6039, 6067);
                if ((xm < lower) || (xm > upper)) {
                    xm = lower + ((upper - lower) / 2);
                    CallChecker.varAssign(xm, "xm", 166, 6319, 6351);
                }
                double pm = CallChecker.varInit(((double) (checkedCumulativeProbability(xm))), "pm", 169, 6380, 6424);
                if (pm >= p) {
                    upper = xm;
                    CallChecker.varAssign(upper, "upper", 171, 6469, 6479);
                }else {
                    lower = xm;
                    CallChecker.varAssign(lower, "lower", 173, 6518, 6528);
                }
            } 
            return upper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1147.methodEnd();
        }
    }

    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context1148 = new MethodContext(void.class, 180, 6587, 6726);
        try {
            CallChecker.varInit(this, "this", 180, 6587, 6726);
            CallChecker.varInit(seed, "seed", 180, 6587, 6726);
            CallChecker.varInit(this.random, "random", 180, 6587, 6726);
            CallChecker.varInit(this.randomData, "randomData", 180, 6587, 6726);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 180, 6587, 6726);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 181, 6667, 6672)) {
                CallChecker.isCalled(random, RandomGenerator.class, 181, 6667, 6672).setSeed(seed);
            }
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 182, 6697, 6706)) {
                CallChecker.isCalled(randomData, RandomDataImpl.class, 182, 6697, 6706).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1148.methodEnd();
        }
    }

    public int sample() {
        MethodContext _bcornu_methode_context1149 = new MethodContext(int.class, 192, 6733, 7015);
        try {
            CallChecker.varInit(this, "this", 192, 6733, 7015);
            CallChecker.varInit(this.random, "random", 192, 6733, 7015);
            CallChecker.varInit(this.randomData, "randomData", 192, 6733, 7015);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 192, 6733, 7015);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 193, 6989, 6994)) {
                return inverseCumulativeProbability(CallChecker.isCalled(random, RandomGenerator.class, 193, 6989, 6994).nextDouble());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1149.methodEnd();
        }
    }

    public int[] sample(int sampleSize) {
        MethodContext _bcornu_methode_context1150 = new MethodContext(int[].class, 202, 7022, 7521);
        try {
            CallChecker.varInit(this, "this", 202, 7022, 7521);
            CallChecker.varInit(sampleSize, "sampleSize", 202, 7022, 7521);
            CallChecker.varInit(this.random, "random", 202, 7022, 7521);
            CallChecker.varInit(this.randomData, "randomData", 202, 7022, 7521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 202, 7022, 7521);
            if (sampleSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            int[] out = CallChecker.varInit(new int[sampleSize], "out", 207, 7376, 7407);
            for (int i = 0; i < sampleSize; i++) {
                if (CallChecker.beforeDeref(out, int[].class, 209, 7468, 7470)) {
                    out = CallChecker.beforeCalled(out, int[].class, 209, 7468, 7470);
                    CallChecker.isCalled(out, int[].class, 209, 7468, 7470)[i] = sample();
                    CallChecker.varAssign(CallChecker.isCalled(out, int[].class, 209, 7468, 7470)[i], "CallChecker.isCalled(out, int[].class, 209, 7468, 7470)[i]", 209, 7468, 7485);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1150.methodEnd();
        }
    }

    private double checkedCumulativeProbability(int argument) throws MathInternalError {
        MethodContext _bcornu_methode_context1151 = new MethodContext(double.class, 225, 7528, 8455);
        try {
            CallChecker.varInit(this, "this", 225, 7528, 8455);
            CallChecker.varInit(argument, "argument", 225, 7528, 8455);
            CallChecker.varInit(this.random, "random", 225, 7528, 8455);
            CallChecker.varInit(this.randomData, "randomData", 225, 7528, 8455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractIntegerDistribution.serialVersionUID", 225, 7528, 8455);
            double result = CallChecker.varInit(((double) (Double.NaN)), "result", 227, 8169, 8195);
            result = cumulativeProbability(argument);
            CallChecker.varAssign(result, "result", 228, 8205, 8245);
            if (Double.isNaN(result)) {
                throw new MathInternalError(LocalizedFormats.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN, argument);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1151.methodEnd();
        }
    }
}

