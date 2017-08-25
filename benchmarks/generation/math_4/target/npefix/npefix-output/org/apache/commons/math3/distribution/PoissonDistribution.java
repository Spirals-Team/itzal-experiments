package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

public class PoissonDistribution extends AbstractIntegerDistribution {
    public static final int DEFAULT_MAX_ITERATIONS = 10000000;

    public static final double DEFAULT_EPSILON = 1.0E-12;

    private static final long serialVersionUID = -3349935121172596109L;

    private final NormalDistribution normal;

    private final ExponentialDistribution exponential;

    private final double mean;

    private final int maxIterations;

    private final double epsilon;

    public PoissonDistribution(double p) throws NotStrictlyPositiveException {
        this(p, PoissonDistribution.DEFAULT_EPSILON, PoissonDistribution.DEFAULT_MAX_ITERATIONS);
        ConstructorContext _bcornu_methode_context967 = new ConstructorContext(PoissonDistribution.class, 73, 2866, 3185);
        try {
        } finally {
            _bcornu_methode_context967.methodEnd();
        }
    }

    public PoissonDistribution(double p, double epsilon, int maxIterations) throws NotStrictlyPositiveException {
        this(new Well19937c(), p, epsilon, maxIterations);
        ConstructorContext _bcornu_methode_context968 = new ConstructorContext(PoissonDistribution.class, 88, 3192, 3801);
        try {
        } finally {
            _bcornu_methode_context968.methodEnd();
        }
    }

    public PoissonDistribution(RandomGenerator rng, double p, double epsilon, int maxIterations) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context969 = new ConstructorContext(PoissonDistribution.class, 105, 3808, 5128);
        try {
            if (p <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, p);
            }
            mean = p;
            CallChecker.varAssign(this.mean, "this.mean", 115, 4650, 4658);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 116, 4668, 4690);
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 117, 4700, 4734);
            normal = new NormalDistribution(rng, p, FastMath.sqrt(p), NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
            CallChecker.varAssign(this.normal, "this.normal", 120, 4803, 4954);
            exponential = new ExponentialDistribution(rng, 1, ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
            CallChecker.varAssign(this.exponential, "this.exponential", 122, 4964, 5122);
        } finally {
            _bcornu_methode_context969.methodEnd();
        }
    }

    public PoissonDistribution(double p, double epsilon) throws NotStrictlyPositiveException {
        this(p, epsilon, PoissonDistribution.DEFAULT_MAX_ITERATIONS);
        ConstructorContext _bcornu_methode_context970 = new ConstructorContext(PoissonDistribution.class, 135, 5135, 5592);
        try {
        } finally {
            _bcornu_methode_context970.methodEnd();
        }
    }

    public PoissonDistribution(double p, int maxIterations) {
        this(p, PoissonDistribution.DEFAULT_EPSILON, maxIterations);
        ConstructorContext _bcornu_methode_context971 = new ConstructorContext(PoissonDistribution.class, 149, 5599, 5982);
        try {
        } finally {
            _bcornu_methode_context971.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context4359 = new MethodContext(double.class, 158, 5989, 6151);
        try {
            CallChecker.varInit(this, "this", 158, 5989, 6151);
            CallChecker.varInit(this.random, "random", 158, 5989, 6151);
            CallChecker.varInit(this.randomData, "randomData", 158, 5989, 6151);
            CallChecker.varInit(this.epsilon, "epsilon", 158, 5989, 6151);
            CallChecker.varInit(this.maxIterations, "maxIterations", 158, 5989, 6151);
            CallChecker.varInit(this.mean, "mean", 158, 5989, 6151);
            CallChecker.varInit(this.exponential, "exponential", 158, 5989, 6151);
            CallChecker.varInit(this.normal, "normal", 158, 5989, 6151);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 158, 5989, 6151);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 158, 5989, 6151);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 158, 5989, 6151);
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4359.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context4360 = new MethodContext(double.class, 163, 6158, 6624);
        try {
            CallChecker.varInit(this, "this", 163, 6158, 6624);
            CallChecker.varInit(x, "x", 163, 6158, 6624);
            CallChecker.varInit(this.random, "random", 163, 6158, 6624);
            CallChecker.varInit(this.randomData, "randomData", 163, 6158, 6624);
            CallChecker.varInit(this.epsilon, "epsilon", 163, 6158, 6624);
            CallChecker.varInit(this.maxIterations, "maxIterations", 163, 6158, 6624);
            CallChecker.varInit(this.mean, "mean", 163, 6158, 6624);
            CallChecker.varInit(this.exponential, "exponential", 163, 6158, 6624);
            CallChecker.varInit(this.normal, "normal", 163, 6158, 6624);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 163, 6158, 6624);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 163, 6158, 6624);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 163, 6158, 6624);
            double ret = CallChecker.init(double.class);
            if ((x < 0) || (x == (Integer.MAX_VALUE))) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 166, 6297, 6306);
            }else
                if (x == 0) {
                    ret = FastMath.exp((-(mean)));
                    CallChecker.varAssign(ret, "ret", 168, 6349, 6374);
                }else {
                    ret = (FastMath.exp(((-(SaddlePointExpansion.getStirlingError(x))) - (SaddlePointExpansion.getDeviancePart(x, mean))))) / (FastMath.sqrt(((org.apache.commons.math3.util.MathUtils.TWO_PI) * x)));
                    CallChecker.varAssign(ret, "ret", 170, 6405, 6588);
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4360.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context4361 = new MethodContext(double.class, 178, 6631, 6953);
        try {
            CallChecker.varInit(this, "this", 178, 6631, 6953);
            CallChecker.varInit(x, "x", 178, 6631, 6953);
            CallChecker.varInit(this.random, "random", 178, 6631, 6953);
            CallChecker.varInit(this.randomData, "randomData", 178, 6631, 6953);
            CallChecker.varInit(this.epsilon, "epsilon", 178, 6631, 6953);
            CallChecker.varInit(this.maxIterations, "maxIterations", 178, 6631, 6953);
            CallChecker.varInit(this.mean, "mean", 178, 6631, 6953);
            CallChecker.varInit(this.exponential, "exponential", 178, 6631, 6953);
            CallChecker.varInit(this.normal, "normal", 178, 6631, 6953);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 178, 6631, 6953);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 178, 6631, 6953);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 178, 6631, 6953);
            if (x < 0) {
                return 0;
            }
            if (x == (Integer.MAX_VALUE)) {
                return 1;
            }
            return Gamma.regularizedGammaQ((((double) (x)) + 1), mean, epsilon, maxIterations);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4361.methodEnd();
        }
    }

    public double normalApproximateProbability(int x) {
        MethodContext _bcornu_methode_context4362 = new MethodContext(double.class, 200, 6960, 7597);
        try {
            CallChecker.varInit(this, "this", 200, 6960, 7597);
            CallChecker.varInit(x, "x", 200, 6960, 7597);
            CallChecker.varInit(this.random, "random", 200, 6960, 7597);
            CallChecker.varInit(this.randomData, "randomData", 200, 6960, 7597);
            CallChecker.varInit(this.epsilon, "epsilon", 200, 6960, 7597);
            CallChecker.varInit(this.maxIterations, "maxIterations", 200, 6960, 7597);
            CallChecker.varInit(this.mean, "mean", 200, 6960, 7597);
            CallChecker.varInit(this.exponential, "exponential", 200, 6960, 7597);
            CallChecker.varInit(this.normal, "normal", 200, 6960, 7597);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 200, 6960, 7597);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 200, 6960, 7597);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 200, 6960, 7597);
            if (CallChecker.beforeDeref(normal, NormalDistribution.class, 202, 7554, 7559)) {
                return CallChecker.isCalled(normal, NormalDistribution.class, 202, 7554, 7559).cumulativeProbability((x + 0.5));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4362.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context4363 = new MethodContext(double.class, 210, 7604, 7773);
        try {
            CallChecker.varInit(this, "this", 210, 7604, 7773);
            CallChecker.varInit(this.random, "random", 210, 7604, 7773);
            CallChecker.varInit(this.randomData, "randomData", 210, 7604, 7773);
            CallChecker.varInit(this.epsilon, "epsilon", 210, 7604, 7773);
            CallChecker.varInit(this.maxIterations, "maxIterations", 210, 7604, 7773);
            CallChecker.varInit(this.mean, "mean", 210, 7604, 7773);
            CallChecker.varInit(this.exponential, "exponential", 210, 7604, 7773);
            CallChecker.varInit(this.normal, "normal", 210, 7604, 7773);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 210, 7604, 7773);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 210, 7604, 7773);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 210, 7604, 7773);
            return getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4363.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context4364 = new MethodContext(double.class, 219, 7780, 7957);
        try {
            CallChecker.varInit(this, "this", 219, 7780, 7957);
            CallChecker.varInit(this.random, "random", 219, 7780, 7957);
            CallChecker.varInit(this.randomData, "randomData", 219, 7780, 7957);
            CallChecker.varInit(this.epsilon, "epsilon", 219, 7780, 7957);
            CallChecker.varInit(this.maxIterations, "maxIterations", 219, 7780, 7957);
            CallChecker.varInit(this.mean, "mean", 219, 7780, 7957);
            CallChecker.varInit(this.exponential, "exponential", 219, 7780, 7957);
            CallChecker.varInit(this.normal, "normal", 219, 7780, 7957);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 219, 7780, 7957);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 219, 7780, 7957);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 219, 7780, 7957);
            return getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4364.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context4365 = new MethodContext(int.class, 230, 7964, 8206);
        try {
            CallChecker.varInit(this, "this", 230, 7964, 8206);
            CallChecker.varInit(this.random, "random", 230, 7964, 8206);
            CallChecker.varInit(this.randomData, "randomData", 230, 7964, 8206);
            CallChecker.varInit(this.epsilon, "epsilon", 230, 7964, 8206);
            CallChecker.varInit(this.maxIterations, "maxIterations", 230, 7964, 8206);
            CallChecker.varInit(this.mean, "mean", 230, 7964, 8206);
            CallChecker.varInit(this.exponential, "exponential", 230, 7964, 8206);
            CallChecker.varInit(this.normal, "normal", 230, 7964, 8206);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 230, 7964, 8206);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 230, 7964, 8206);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 230, 7964, 8206);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4365.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context4366 = new MethodContext(int.class, 244, 8213, 8634);
        try {
            CallChecker.varInit(this, "this", 244, 8213, 8634);
            CallChecker.varInit(this.random, "random", 244, 8213, 8634);
            CallChecker.varInit(this.randomData, "randomData", 244, 8213, 8634);
            CallChecker.varInit(this.epsilon, "epsilon", 244, 8213, 8634);
            CallChecker.varInit(this.maxIterations, "maxIterations", 244, 8213, 8634);
            CallChecker.varInit(this.mean, "mean", 244, 8213, 8634);
            CallChecker.varInit(this.exponential, "exponential", 244, 8213, 8634);
            CallChecker.varInit(this.normal, "normal", 244, 8213, 8634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 244, 8213, 8634);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 244, 8213, 8634);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 244, 8213, 8634);
            return Integer.MAX_VALUE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4366.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context4367 = new MethodContext(boolean.class, 255, 8641, 8837);
        try {
            CallChecker.varInit(this, "this", 255, 8641, 8837);
            CallChecker.varInit(this.random, "random", 255, 8641, 8837);
            CallChecker.varInit(this.randomData, "randomData", 255, 8641, 8837);
            CallChecker.varInit(this.epsilon, "epsilon", 255, 8641, 8837);
            CallChecker.varInit(this.maxIterations, "maxIterations", 255, 8641, 8837);
            CallChecker.varInit(this.mean, "mean", 255, 8641, 8837);
            CallChecker.varInit(this.exponential, "exponential", 255, 8641, 8837);
            CallChecker.varInit(this.normal, "normal", 255, 8641, 8837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 255, 8641, 8837);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 255, 8641, 8837);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 255, 8641, 8837);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4367.methodEnd();
        }
    }

    @Override
    public int sample() {
        MethodContext _bcornu_methode_context4368 = new MethodContext(int.class, 282, 8844, 9703);
        try {
            CallChecker.varInit(this, "this", 282, 8844, 9703);
            CallChecker.varInit(this.random, "random", 282, 8844, 9703);
            CallChecker.varInit(this.randomData, "randomData", 282, 8844, 9703);
            CallChecker.varInit(this.epsilon, "epsilon", 282, 8844, 9703);
            CallChecker.varInit(this.maxIterations, "maxIterations", 282, 8844, 9703);
            CallChecker.varInit(this.mean, "mean", 282, 8844, 9703);
            CallChecker.varInit(this.exponential, "exponential", 282, 8844, 9703);
            CallChecker.varInit(this.normal, "normal", 282, 8844, 9703);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 282, 8844, 9703);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 282, 8844, 9703);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 282, 8844, 9703);
            return ((int) (FastMath.min(nextPoisson(mean), Integer.MAX_VALUE)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4368.methodEnd();
        }
    }

    private long nextPoisson(double meanPoisson) {
        MethodContext _bcornu_methode_context4369 = new MethodContext(long.class, 290, 9710, 13199);
        try {
            CallChecker.varInit(this, "this", 290, 9710, 13199);
            CallChecker.varInit(meanPoisson, "meanPoisson", 290, 9710, 13199);
            CallChecker.varInit(this.random, "random", 290, 9710, 13199);
            CallChecker.varInit(this.randomData, "randomData", 290, 9710, 13199);
            CallChecker.varInit(this.epsilon, "epsilon", 290, 9710, 13199);
            CallChecker.varInit(this.maxIterations, "maxIterations", 290, 9710, 13199);
            CallChecker.varInit(this.mean, "mean", 290, 9710, 13199);
            CallChecker.varInit(this.exponential, "exponential", 290, 9710, 13199);
            CallChecker.varInit(this.normal, "normal", 290, 9710, 13199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PoissonDistribution.serialVersionUID", 290, 9710, 13199);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON", 290, 9710, 13199);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS", 290, 9710, 13199);
            final double pivot = CallChecker.varInit(((double) (40.0)), "pivot", 291, 9873, 9899);
            if (meanPoisson < pivot) {
                double p = CallChecker.varInit(((double) (FastMath.exp((-meanPoisson)))), "p", 293, 9948, 9985);
                long n = CallChecker.varInit(((long) (0)), "n", 294, 9999, 10009);
                double r = CallChecker.varInit(((double) (1.0)), "r", 295, 10023, 10038);
                double rnd = CallChecker.varInit(((double) (1.0)), "rnd", 296, 10052, 10069);
                while (n < (1000 * meanPoisson)) {
                    if (CallChecker.beforeDeref(random, RandomGenerator.class, 299, 10139, 10144)) {
                        rnd = CallChecker.isCalled(random, RandomGenerator.class, 299, 10139, 10144).nextDouble();
                        CallChecker.varAssign(rnd, "rnd", 299, 10133, 10158);
                    }
                    r = r * rnd;
                    CallChecker.varAssign(r, "r", 300, 10176, 10187);
                    if (r >= p) {
                        n++;
                    }else {
                        return n;
                    }
                } 
                return n;
            }else {
                final double lambda = CallChecker.varInit(((double) (FastMath.floor(meanPoisson))), "lambda", 309, 10382, 10431);
                final double lambdaFractional = CallChecker.varInit(((double) (meanPoisson - lambda)), "lambdaFractional", 310, 10445, 10497);
                final double logLambda = CallChecker.varInit(((double) (FastMath.log(lambda))), "logLambda", 311, 10511, 10556);
                final double logLambdaFactorial = CallChecker.varInit(((double) (ArithmeticUtils.factorialLog(((int) (lambda))))), "logLambdaFactorial", 312, 10570, 10646);
                long y2 = CallChecker.init(long.class);
                if (lambdaFractional < (Double.MIN_VALUE)) {
                    y2 = 0;
                    CallChecker.varAssign(y2, "y2", 313, 10676, 10746);
                }else {
                    y2 = nextPoisson(lambdaFractional);
                    CallChecker.varAssign(y2, "y2", 313, 10676, 10746);
                }
                final double delta = CallChecker.varInit(((double) (FastMath.sqrt((lambda * (FastMath.log((((32 * lambda) / (FastMath.PI)) + 1))))))), "delta", 314, 10761, 10849);
                final double halfDelta = CallChecker.varInit(((double) (delta / 2)), "halfDelta", 315, 10863, 10897);
                final double twolpd = CallChecker.varInit(((double) ((2 * lambda) + delta)), "twolpd", 316, 10911, 10951);
                final double a1 = CallChecker.varInit(((double) ((FastMath.sqrt(((FastMath.PI) * twolpd))) * (FastMath.exp(((1 / 8) * lambda))))), "a1", 317, 10965, 11049);
                final double a2 = CallChecker.varInit(((double) ((twolpd / delta) * (FastMath.exp((((-delta) * (1 + delta)) / twolpd))))), "a2", 318, 11063, 11143);
                final double aSum = CallChecker.varInit(((double) ((a1 + a2) + 1)), "aSum", 319, 11157, 11188);
                final double p1 = CallChecker.varInit(((double) (a1 / aSum)), "p1", 320, 11202, 11229);
                final double p2 = CallChecker.varInit(((double) (a2 / aSum)), "p2", 321, 11243, 11270);
                final double c1 = CallChecker.varInit(((double) (1 / (8 * lambda))), "c1", 322, 11284, 11318);
                double x = CallChecker.varInit(((double) (0)), "x", 324, 11333, 11345);
                double y = CallChecker.varInit(((double) (0)), "y", 325, 11359, 11371);
                double v = CallChecker.varInit(((double) (0)), "v", 326, 11385, 11397);
                int a = CallChecker.varInit(((int) (0)), "a", 327, 11411, 11420);
                double t = CallChecker.varInit(((double) (0)), "t", 328, 11434, 11446);
                double qr = CallChecker.varInit(((double) (0)), "qr", 329, 11460, 11473);
                double qa = CallChecker.varInit(((double) (0)), "qa", 330, 11487, 11500);
                for (; ;) {
                    final double u = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 332, 11558, 11563).nextDouble())), "u", 332, 11541, 11577);
                    if (u <= p1) {
                        final double n = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 334, 11647, 11652).nextGaussian())), "n", 334, 11630, 11668);
                        x = (n * (FastMath.sqrt((lambda + halfDelta)))) - 0.5;
                        CallChecker.varAssign(x, "x", 335, 11690, 11738);
                        if ((x > delta) || (x < (-lambda))) {
                            continue;
                        }
                        if (x < 0) {
                            y = FastMath.floor(x);
                            CallChecker.varAssign(y, "y", 339, 11868, 11916);
                        }else {
                            y = FastMath.ceil(x);
                            CallChecker.varAssign(y, "y", 339, 11868, 11916);
                        }
                        final double e = CallChecker.varInit(((double) (CallChecker.isCalled(this.exponential, ExponentialDistribution.class, 340, 11955, 11965).sample())), "e", 340, 11938, 11975);
                        v = ((-e) - ((n * n) / 2)) + c1;
                        CallChecker.varAssign(v, "v", 341, 11997, 12022);
                    }else {
                        if (u > (p1 + p2)) {
                            y = lambda;
                            CallChecker.varAssign(y, "y", 344, 12112, 12122);
                            break;
                        }else {
                            if (CallChecker.beforeDeref(exponential, ExponentialDistribution.class, 347, 12239, 12249)) {
                                x = delta + ((twolpd / delta) * (CallChecker.isCalled(exponential, ExponentialDistribution.class, 347, 12239, 12249).sample()));
                                CallChecker.varAssign(x, "x", 347, 12208, 12259);
                            }
                            y = FastMath.ceil(x);
                            CallChecker.varAssign(y, "y", 348, 12285, 12305);
                            if (CallChecker.beforeDeref(exponential, ExponentialDistribution.class, 349, 12336, 12346)) {
                                v = (-(CallChecker.isCalled(exponential, ExponentialDistribution.class, 349, 12336, 12346).sample())) - ((delta * (x + 1)) / twolpd);
                                CallChecker.varAssign(v, "v", 349, 12331, 12383);
                            }
                        }
                    }
                    if (x < 0) {
                        a = 1;
                        CallChecker.varAssign(a, "a", 352, 12441, 12458);
                    }else {
                        a = 0;
                        CallChecker.varAssign(a, "a", 352, 12441, 12458);
                    }
                    t = (y * (y + 1)) / (2 * lambda);
                    CallChecker.varAssign(t, "t", 353, 12476, 12506);
                    if ((v < (-t)) && (a == 0)) {
                        y = lambda + y;
                        CallChecker.varAssign(y, "y", 355, 12568, 12582);
                        break;
                    }
                    qr = t * ((((2 * y) + 1) / (6 * lambda)) - 1);
                    CallChecker.varAssign(qr, "qr", 358, 12645, 12686);
                    qa = qr - ((t * t) / (3 * (lambda + (a * (y + 1)))));
                    CallChecker.varAssign(qa, "qa", 359, 12704, 12752);
                    if (v < qa) {
                        y = lambda + y;
                        CallChecker.varAssign(y, "y", 361, 12804, 12818);
                        break;
                    }
                    if (v > qr) {
                        continue;
                    }
                    if (v < (((y * logLambda) - (ArithmeticUtils.factorialLog(((int) (y + lambda))))) + logLambdaFactorial)) {
                        y = lambda + y;
                        CallChecker.varAssign(y, "y", 368, 13076, 13090);
                        break;
                    }
                }
                return y2 + ((long) (y));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4369.methodEnd();
        }
    }
}

