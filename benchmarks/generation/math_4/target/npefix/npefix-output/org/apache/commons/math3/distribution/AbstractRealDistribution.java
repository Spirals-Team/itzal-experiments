package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomDataImpl;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

public abstract class AbstractRealDistribution implements Serializable , RealDistribution {
    public static final double SOLVER_DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    private static final long serialVersionUID = -38038050983108802L;

    @Deprecated
    protected RandomDataImpl randomData = new RandomDataImpl();

    protected final RandomGenerator random;

    private double solverAbsoluteAccuracy = AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY;

    @Deprecated
    protected AbstractRealDistribution() {
        ConstructorContext _bcornu_methode_context44 = new ConstructorContext(AbstractRealDistribution.class, 67, 2561, 2929);
        try {
            random = null;
            CallChecker.varAssign(this.random, "this.random", 70, 2910, 2923);
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    protected AbstractRealDistribution(RandomGenerator rng) {
        ConstructorContext _bcornu_methode_context45 = new ConstructorContext(AbstractRealDistribution.class, 76, 2935, 3096);
        try {
            random = rng;
            CallChecker.varAssign(this.random, "this.random", 77, 3078, 3090);
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    @Deprecated
    public double cumulativeProbability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context128 = new MethodContext(double.class, 90, 3103, 3535);
        try {
            CallChecker.varInit(this, "this", 90, 3103, 3535);
            CallChecker.varInit(x1, "x1", 90, 3103, 3535);
            CallChecker.varInit(x0, "x0", 90, 3103, 3535);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 90, 3103, 3535);
            CallChecker.varInit(this.random, "random", 90, 3103, 3535);
            CallChecker.varInit(this.randomData, "randomData", 90, 3103, 3535);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 90, 3103, 3535);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 90, 3103, 3535);
            return probability(x0, x1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public double probability(double x0, double x1) {
        MethodContext _bcornu_methode_context129 = new MethodContext(double.class, 110, 3542, 4547);
        try {
            CallChecker.varInit(this, "this", 110, 3542, 4547);
            CallChecker.varInit(x1, "x1", 110, 3542, 4547);
            CallChecker.varInit(x0, "x0", 110, 3542, 4547);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 110, 3542, 4547);
            CallChecker.varInit(this.random, "random", 110, 3542, 4547);
            CallChecker.varInit(this.randomData, "randomData", 110, 3542, 4547);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 110, 3542, 4547);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 110, 3542, 4547);
            if (x0 > x1) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, x0, x1, true);
            }
            return (cumulativeProbability(x1)) - (cumulativeProbability(x0));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public double inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context131 = new MethodContext(double.class, 128, 4554, 8737);
        try {
            CallChecker.varInit(this, "this", 128, 4554, 8737);
            CallChecker.varInit(p, "p", 128, 4554, 8737);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 128, 4554, 8737);
            CallChecker.varInit(this.random, "random", 128, 4554, 8737);
            CallChecker.varInit(this.randomData, "randomData", 128, 4554, 8737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 128, 4554, 8737);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 128, 4554, 8737);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            double lowerBound = CallChecker.varInit(((double) (getSupportLowerBound())), "lowerBound", 161, 6194, 6236);
            if (p == 0.0) {
                return lowerBound;
            }
            double upperBound = CallChecker.varInit(((double) (getSupportUpperBound())), "upperBound", 166, 6312, 6354);
            if (p == 1.0) {
                return upperBound;
            }
            final double mu = CallChecker.varInit(((double) (getNumericalMean())), "mu", 171, 6430, 6466);
            final double sig = CallChecker.varInit(((double) (FastMath.sqrt(getNumericalVariance()))), "sig", 172, 6476, 6532);
            boolean chebyshevApplies = CallChecker.init(boolean.class);
            chebyshevApplies = !((((Double.isInfinite(mu)) || (Double.isNaN(mu))) || (Double.isInfinite(sig))) || (Double.isNaN(sig)));
            CallChecker.varAssign(chebyshevApplies, "chebyshevApplies", 174, 6582, 6721);
            if (lowerBound == (Double.NEGATIVE_INFINITY)) {
                if (chebyshevApplies) {
                    lowerBound = mu - (sig * (FastMath.sqrt(((1.0 - p) / p))));
                    CallChecker.varAssign(lowerBound, "lowerBound", 179, 6830, 6881);
                }else {
                    lowerBound = -1.0;
                    CallChecker.varAssign(lowerBound, "lowerBound", 181, 6920, 6937);
                    while ((cumulativeProbability(lowerBound)) >= p) {
                        lowerBound *= 2.0;
                        CallChecker.varAssign(lowerBound, "lowerBound", 183, 7024, 7041);
                    } 
                }
            }
            if (upperBound == (Double.POSITIVE_INFINITY)) {
                if (chebyshevApplies) {
                    upperBound = mu + (sig * (FastMath.sqrt((p / (1.0 - p)))));
                    CallChecker.varAssign(upperBound, "upperBound", 190, 7192, 7243);
                }else {
                    upperBound = 1.0;
                    CallChecker.varAssign(upperBound, "upperBound", 192, 7282, 7298);
                    while ((cumulativeProbability(upperBound)) < p) {
                        upperBound *= 2.0;
                        CallChecker.varAssign(upperBound, "upperBound", 194, 7384, 7401);
                    } 
                }
            }
            final UnivariateFunction toSolve = new UnivariateFunction() {
                public double value(final double x) {
                    MethodContext _bcornu_methode_context130 = new MethodContext(double.class, 201, 7529, 7632);
                    try {
                        CallChecker.varInit(this, "this", 201, 7529, 7632);
                        CallChecker.varInit(x, "x", 201, 7529, 7632);
                        return (cumulativeProbability(x)) - p;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context130.methodEnd();
                    }
                }
            };
            double x = CallChecker.varInit(((double) (UnivariateSolverUtils.solve(toSolve, lowerBound, upperBound, getSolverAbsoluteAccuracy()))), "x", 206, 7654, 7907);
            if (!(isSupportConnected())) {
                final double dx = CallChecker.varInit(((double) (getSolverAbsoluteAccuracy())), "dx", 213, 7959, 8040);
                if ((x - dx) >= (getSupportLowerBound())) {
                    double px = CallChecker.varInit(((double) (cumulativeProbability(x))), "px", 215, 8110, 8146);
                    if ((cumulativeProbability((x - dx))) == px) {
                        upperBound = x;
                        CallChecker.varAssign(upperBound, "upperBound", 217, 8227, 8241);
                        while ((upperBound - lowerBound) > dx) {
                            final double midPoint = CallChecker.varInit(((double) (0.5 * (lowerBound + upperBound))), "midPoint", 219, 8326, 8381);
                            if ((cumulativeProbability(midPoint)) < px) {
                                lowerBound = midPoint;
                                CallChecker.varAssign(lowerBound, "lowerBound", 221, 8479, 8500);
                            }else {
                                upperBound = midPoint;
                                CallChecker.varAssign(upperBound, "upperBound", 223, 8563, 8584);
                            }
                        } 
                        return upperBound;
                    }
                }
            }
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context132 = new MethodContext(double.class, 240, 8744, 9151);
        try {
            CallChecker.varInit(this, "this", 240, 8744, 9151);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 240, 8744, 9151);
            CallChecker.varInit(this.random, "random", 240, 8744, 9151);
            CallChecker.varInit(this.randomData, "randomData", 240, 8744, 9151);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 240, 8744, 9151);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 240, 8744, 9151);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context133 = new MethodContext(void.class, 245, 9158, 9297);
        try {
            CallChecker.varInit(this, "this", 245, 9158, 9297);
            CallChecker.varInit(seed, "seed", 245, 9158, 9297);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 245, 9158, 9297);
            CallChecker.varInit(this.random, "random", 245, 9158, 9297);
            CallChecker.varInit(this.randomData, "randomData", 245, 9158, 9297);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 245, 9158, 9297);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 245, 9158, 9297);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 246, 9238, 9243)) {
                CallChecker.isCalled(random, RandomGenerator.class, 246, 9238, 9243).setSeed(seed);
            }
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 247, 9268, 9277)) {
                randomData = CallChecker.beforeCalled(randomData, RandomDataImpl.class, 247, 9268, 9277);
                CallChecker.isCalled(randomData, RandomDataImpl.class, 247, 9268, 9277).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    public double sample() {
        MethodContext _bcornu_methode_context134 = new MethodContext(double.class, 258, 9304, 9597);
        try {
            CallChecker.varInit(this, "this", 258, 9304, 9597);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 258, 9304, 9597);
            CallChecker.varInit(this.random, "random", 258, 9304, 9597);
            CallChecker.varInit(this.randomData, "randomData", 258, 9304, 9597);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 258, 9304, 9597);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 258, 9304, 9597);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 259, 9571, 9576)) {
                return inverseCumulativeProbability(CallChecker.isCalled(random, RandomGenerator.class, 259, 9571, 9576).nextDouble());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    public double[] sample(int sampleSize) {
        MethodContext _bcornu_methode_context135 = new MethodContext(double[].class, 268, 9604, 10111);
        try {
            CallChecker.varInit(this, "this", 268, 9604, 10111);
            CallChecker.varInit(sampleSize, "sampleSize", 268, 9604, 10111);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 268, 9604, 10111);
            CallChecker.varInit(this.random, "random", 268, 9604, 10111);
            CallChecker.varInit(this.randomData, "randomData", 268, 9604, 10111);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 268, 9604, 10111);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 268, 9604, 10111);
            if (sampleSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            double[] out = CallChecker.varInit(new double[sampleSize], "out", 273, 9960, 9997);
            for (int i = 0; i < sampleSize; i++) {
                if (CallChecker.beforeDeref(out, double[].class, 275, 10058, 10060)) {
                    out = CallChecker.beforeCalled(out, double[].class, 275, 10058, 10060);
                    CallChecker.isCalled(out, double[].class, 275, 10058, 10060)[i] = sample();
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 275, 10058, 10060)[i], "CallChecker.isCalled(out, double[].class, 275, 10058, 10060)[i]", 275, 10058, 10075);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public double probability(double x) {
        MethodContext _bcornu_methode_context136 = new MethodContext(double.class, 286, 10118, 10262);
        try {
            CallChecker.varInit(this, "this", 286, 10118, 10262);
            CallChecker.varInit(x, "x", 286, 10118, 10262);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 286, 10118, 10262);
            CallChecker.varInit(this.random, "random", 286, 10118, 10262);
            CallChecker.varInit(this.randomData, "randomData", 286, 10118, 10262);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.AbstractRealDistribution.serialVersionUID", 286, 10118, 10262);
            CallChecker.varInit(SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 286, 10118, 10262);
            return 0.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }
}

