package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;

public class BetaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = -1221965979403477668L;

    private final double alpha;

    private final double beta;

    private double z;

    private final double solverAbsoluteAccuracy;

    public BetaDistribution(double alpha, double beta) {
        this(alpha, beta, BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context193 = new ConstructorContext(BetaDistribution.class, 59, 2154, 2449);
        try {
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    public BetaDistribution(double alpha, double beta, double inverseCumAccuracy) {
        this(new Well19937c(), alpha, beta, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context194 = new ConstructorContext(BetaDistribution.class, 73, 2456, 2971);
        try {
        } finally {
            _bcornu_methode_context194.methodEnd();
        }
    }

    public BetaDistribution(RandomGenerator rng, double alpha, double beta, double inverseCumAccuracy) {
        super(rng);
        ConstructorContext _bcornu_methode_context195 = new ConstructorContext(BetaDistribution.class, 88, 2978, 3737);
        try {
            this.alpha = alpha;
            CallChecker.varAssign(this.alpha, "this.alpha", 94, 3610, 3628);
            this.beta = beta;
            CallChecker.varAssign(this.beta, "this.beta", 95, 3638, 3654);
            z = Double.NaN;
            CallChecker.varAssign(this.z, "this.z", 96, 3664, 3678);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 97, 3688, 3731);
        } finally {
            _bcornu_methode_context195.methodEnd();
        }
    }

    public double getAlpha() {
        MethodContext _bcornu_methode_context752 = new MethodContext(double.class, 105, 3744, 3918);
        try {
            CallChecker.varInit(this, "this", 105, 3744, 3918);
            CallChecker.varInit(this.random, "random", 105, 3744, 3918);
            CallChecker.varInit(this.randomData, "randomData", 105, 3744, 3918);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 105, 3744, 3918);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 105, 3744, 3918);
            CallChecker.varInit(this.z, "z", 105, 3744, 3918);
            CallChecker.varInit(this.beta, "beta", 105, 3744, 3918);
            CallChecker.varInit(this.alpha, "alpha", 105, 3744, 3918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 105, 3744, 3918);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 105, 3744, 3918);
            return alpha;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context752.methodEnd();
        }
    }

    public double getBeta() {
        MethodContext _bcornu_methode_context753 = new MethodContext(double.class, 114, 3925, 4098);
        try {
            CallChecker.varInit(this, "this", 114, 3925, 4098);
            CallChecker.varInit(this.random, "random", 114, 3925, 4098);
            CallChecker.varInit(this.randomData, "randomData", 114, 3925, 4098);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 114, 3925, 4098);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 114, 3925, 4098);
            CallChecker.varInit(this.z, "z", 114, 3925, 4098);
            CallChecker.varInit(this.beta, "beta", 114, 3925, 4098);
            CallChecker.varInit(this.alpha, "alpha", 114, 3925, 4098);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 114, 3925, 4098);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 114, 3925, 4098);
            return beta;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context753.methodEnd();
        }
    }

    private void recomputeZ() {
        MethodContext _bcornu_methode_context754 = new MethodContext(void.class, 119, 4105, 4318);
        try {
            CallChecker.varInit(this, "this", 119, 4105, 4318);
            CallChecker.varInit(this.random, "random", 119, 4105, 4318);
            CallChecker.varInit(this.randomData, "randomData", 119, 4105, 4318);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 119, 4105, 4318);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 119, 4105, 4318);
            CallChecker.varInit(this.z, "z", 119, 4105, 4318);
            CallChecker.varInit(this.beta, "beta", 119, 4105, 4318);
            CallChecker.varInit(this.alpha, "alpha", 119, 4105, 4318);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 119, 4105, 4318);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 119, 4105, 4318);
            if (Double.isNaN(z)) {
                z = ((Gamma.logGamma(alpha)) + (Gamma.logGamma(beta))) - (Gamma.logGamma(((alpha) + (beta))));
                CallChecker.varAssign(this.z, "this.z", 121, 4223, 4302);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context754.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context755 = new MethodContext(double.class, 126, 4325, 5116);
        try {
            CallChecker.varInit(this, "this", 126, 4325, 5116);
            CallChecker.varInit(x, "x", 126, 4325, 5116);
            CallChecker.varInit(this.random, "random", 126, 4325, 5116);
            CallChecker.varInit(this.randomData, "randomData", 126, 4325, 5116);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 126, 4325, 5116);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 126, 4325, 5116);
            CallChecker.varInit(this.z, "z", 126, 4325, 5116);
            CallChecker.varInit(this.beta, "beta", 126, 4325, 5116);
            CallChecker.varInit(this.alpha, "alpha", 126, 4325, 5116);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 126, 4325, 5116);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 126, 4325, 5116);
            recomputeZ();
            if ((x < 0) || (x > 1)) {
                return 0;
            }else
                if (x == 0) {
                    if ((alpha) < 1) {
                        throw new org.apache.commons.math3.exception.NumberIsTooSmallException(org.apache.commons.math3.exception.util.LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA, alpha, 1, false);
                    }
                    return 0;
                }else
                    if (x == 1) {
                        if ((beta) < 1) {
                            throw new org.apache.commons.math3.exception.NumberIsTooSmallException(org.apache.commons.math3.exception.util.LocalizedFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA, beta, 1, false);
                        }
                        return 0;
                    }else {
                        double logX = CallChecker.varInit(((double) (org.apache.commons.math3.util.FastMath.log(x))), "logX", 141, 4944, 4973);
                        double log1mX = CallChecker.varInit(((double) (org.apache.commons.math3.util.FastMath.log1p((-x)))), "log1mX", 142, 4987, 5021);
                        return org.apache.commons.math3.util.FastMath.exp((((((alpha) - 1) * logX) + (((beta) - 1) * log1mX)) - (z)));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context755.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context756 = new MethodContext(double.class, 148, 5123, 5380);
        try {
            CallChecker.varInit(this, "this", 148, 5123, 5380);
            CallChecker.varInit(x, "x", 148, 5123, 5380);
            CallChecker.varInit(this.random, "random", 148, 5123, 5380);
            CallChecker.varInit(this.randomData, "randomData", 148, 5123, 5380);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 148, 5123, 5380);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 148, 5123, 5380);
            CallChecker.varInit(this.z, "z", 148, 5123, 5380);
            CallChecker.varInit(this.beta, "beta", 148, 5123, 5380);
            CallChecker.varInit(this.alpha, "alpha", 148, 5123, 5380);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 148, 5123, 5380);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 148, 5123, 5380);
            if (x <= 0) {
                return 0;
            }else
                if (x >= 1) {
                    return 1;
                }else {
                    return org.apache.commons.math3.special.Beta.regularizedBeta(x, alpha, beta);
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context756.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context757 = new MethodContext(double.class, 166, 5387, 5693);
        try {
            CallChecker.varInit(this, "this", 166, 5387, 5693);
            CallChecker.varInit(this.random, "random", 166, 5387, 5693);
            CallChecker.varInit(this.randomData, "randomData", 166, 5387, 5693);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 166, 5387, 5693);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 166, 5387, 5693);
            CallChecker.varInit(this.z, "z", 166, 5387, 5693);
            CallChecker.varInit(this.beta, "beta", 166, 5387, 5693);
            CallChecker.varInit(this.alpha, "alpha", 166, 5387, 5693);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 166, 5387, 5693);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 166, 5387, 5693);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context757.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context758 = new MethodContext(double.class, 176, 5700, 5995);
        try {
            CallChecker.varInit(this, "this", 176, 5700, 5995);
            CallChecker.varInit(this.random, "random", 176, 5700, 5995);
            CallChecker.varInit(this.randomData, "randomData", 176, 5700, 5995);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 176, 5700, 5995);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 176, 5700, 5995);
            CallChecker.varInit(this.z, "z", 176, 5700, 5995);
            CallChecker.varInit(this.beta, "beta", 176, 5700, 5995);
            CallChecker.varInit(this.alpha, "alpha", 176, 5700, 5995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 176, 5700, 5995);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 176, 5700, 5995);
            final double a = CallChecker.varInit(((double) (getAlpha())), "a", 177, 5926, 5953);
            return a / (a + (getBeta()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context758.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context759 = new MethodContext(double.class, 188, 6002, 6468);
        try {
            CallChecker.varInit(this, "this", 188, 6002, 6468);
            CallChecker.varInit(this.random, "random", 188, 6002, 6468);
            CallChecker.varInit(this.randomData, "randomData", 188, 6002, 6468);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 188, 6002, 6468);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 188, 6002, 6468);
            CallChecker.varInit(this.z, "z", 188, 6002, 6468);
            CallChecker.varInit(this.beta, "beta", 188, 6002, 6468);
            CallChecker.varInit(this.alpha, "alpha", 188, 6002, 6468);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 188, 6002, 6468);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 188, 6002, 6468);
            final double a = CallChecker.varInit(((double) (getAlpha())), "a", 189, 6277, 6304);
            final double b = CallChecker.varInit(((double) (getBeta())), "b", 190, 6314, 6340);
            final double alphabetasum = CallChecker.varInit(((double) (a + b)), "alphabetasum", 191, 6350, 6383);
            return (a * b) / ((alphabetasum * alphabetasum) * (alphabetasum + 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context759.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context760 = new MethodContext(double.class, 202, 6475, 6716);
        try {
            CallChecker.varInit(this, "this", 202, 6475, 6716);
            CallChecker.varInit(this.random, "random", 202, 6475, 6716);
            CallChecker.varInit(this.randomData, "randomData", 202, 6475, 6716);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 202, 6475, 6716);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 202, 6475, 6716);
            CallChecker.varInit(this.z, "z", 202, 6475, 6716);
            CallChecker.varInit(this.beta, "beta", 202, 6475, 6716);
            CallChecker.varInit(this.alpha, "alpha", 202, 6475, 6716);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 202, 6475, 6716);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 202, 6475, 6716);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context760.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context761 = new MethodContext(double.class, 213, 6723, 6964);
        try {
            CallChecker.varInit(this, "this", 213, 6723, 6964);
            CallChecker.varInit(this.random, "random", 213, 6723, 6964);
            CallChecker.varInit(this.randomData, "randomData", 213, 6723, 6964);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 213, 6723, 6964);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 213, 6723, 6964);
            CallChecker.varInit(this.z, "z", 213, 6723, 6964);
            CallChecker.varInit(this.beta, "beta", 213, 6723, 6964);
            CallChecker.varInit(this.alpha, "alpha", 213, 6723, 6964);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 213, 6723, 6964);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 213, 6723, 6964);
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context761.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context762 = new MethodContext(boolean.class, 218, 6971, 7070);
        try {
            CallChecker.varInit(this, "this", 218, 6971, 7070);
            CallChecker.varInit(this.random, "random", 218, 6971, 7070);
            CallChecker.varInit(this.randomData, "randomData", 218, 6971, 7070);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 218, 6971, 7070);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 218, 6971, 7070);
            CallChecker.varInit(this.z, "z", 218, 6971, 7070);
            CallChecker.varInit(this.beta, "beta", 218, 6971, 7070);
            CallChecker.varInit(this.alpha, "alpha", 218, 6971, 7070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 218, 6971, 7070);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 218, 6971, 7070);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context762.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context763 = new MethodContext(boolean.class, 223, 7077, 7176);
        try {
            CallChecker.varInit(this, "this", 223, 7077, 7176);
            CallChecker.varInit(this.random, "random", 223, 7077, 7176);
            CallChecker.varInit(this.randomData, "randomData", 223, 7077, 7176);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 223, 7077, 7176);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 223, 7077, 7176);
            CallChecker.varInit(this.z, "z", 223, 7077, 7176);
            CallChecker.varInit(this.beta, "beta", 223, 7077, 7176);
            CallChecker.varInit(this.alpha, "alpha", 223, 7077, 7176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 223, 7077, 7176);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 223, 7077, 7176);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context763.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context764 = new MethodContext(boolean.class, 234, 7183, 7379);
        try {
            CallChecker.varInit(this, "this", 234, 7183, 7379);
            CallChecker.varInit(this.random, "random", 234, 7183, 7379);
            CallChecker.varInit(this.randomData, "randomData", 234, 7183, 7379);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 234, 7183, 7379);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 234, 7183, 7379);
            CallChecker.varInit(this.z, "z", 234, 7183, 7379);
            CallChecker.varInit(this.beta, "beta", 234, 7183, 7379);
            CallChecker.varInit(this.alpha, "alpha", 234, 7183, 7379);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BetaDistribution.serialVersionUID", 234, 7183, 7379);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 234, 7183, 7379);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context764.methodEnd();
        }
    }
}

