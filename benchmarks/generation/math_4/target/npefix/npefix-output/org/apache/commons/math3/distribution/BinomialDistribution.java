package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class BinomialDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 6751309484392813623L;

    private final int numberOfTrials;

    private final double probabilityOfSuccess;

    public BinomialDistribution(int trials, double p) {
        this(new Well19937c(), trials, p);
        ConstructorContext _bcornu_methode_context701 = new ConstructorContext(BinomialDistribution.class, 51, 1887, 2322);
        try {
        } finally {
            _bcornu_methode_context701.methodEnd();
        }
    }

    public BinomialDistribution(RandomGenerator rng, int trials, double p) {
        super(rng);
        ConstructorContext _bcornu_methode_context702 = new ConstructorContext(BinomialDistribution.class, 65, 2329, 3149);
        try {
            if (trials < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_TRIALS, trials);
            }
            if ((p < 0) || (p > 1)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            probabilityOfSuccess = p;
            CallChecker.varAssign(this.probabilityOfSuccess, "this.probabilityOfSuccess", 78, 3086, 3110);
            numberOfTrials = trials;
            CallChecker.varAssign(this.numberOfTrials, "this.numberOfTrials", 79, 3120, 3143);
        } finally {
            _bcornu_methode_context702.methodEnd();
        }
    }

    public int getNumberOfTrials() {
        MethodContext _bcornu_methode_context3076 = new MethodContext(int.class, 87, 3156, 3342);
        try {
            CallChecker.varInit(this, "this", 87, 3156, 3342);
            CallChecker.varInit(this.random, "random", 87, 3156, 3342);
            CallChecker.varInit(this.randomData, "randomData", 87, 3156, 3342);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 87, 3156, 3342);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 87, 3156, 3342);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 87, 3156, 3342);
            return numberOfTrials;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3076.methodEnd();
        }
    }

    public double getProbabilityOfSuccess() {
        MethodContext _bcornu_methode_context3077 = new MethodContext(double.class, 96, 3349, 3562);
        try {
            CallChecker.varInit(this, "this", 96, 3349, 3562);
            CallChecker.varInit(this.random, "random", 96, 3349, 3562);
            CallChecker.varInit(this.randomData, "randomData", 96, 3349, 3562);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 96, 3349, 3562);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 96, 3349, 3562);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 96, 3349, 3562);
            return probabilityOfSuccess;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3077.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context3078 = new MethodContext(double.class, 101, 3569, 3952);
        try {
            CallChecker.varInit(this, "this", 101, 3569, 3952);
            CallChecker.varInit(x, "x", 101, 3569, 3952);
            CallChecker.varInit(this.random, "random", 101, 3569, 3952);
            CallChecker.varInit(this.randomData, "randomData", 101, 3569, 3952);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 101, 3569, 3952);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 101, 3569, 3952);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 101, 3569, 3952);
            double ret = CallChecker.init(double.class);
            if ((x < 0) || (x > (numberOfTrials))) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 104, 3704, 3713);
            }else {
                ret = FastMath.exp(SaddlePointExpansion.logBinomialProbability(x, numberOfTrials, probabilityOfSuccess, (1.0 - (probabilityOfSuccess))));
                CallChecker.varAssign(ret, "ret", 106, 3744, 3916);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3078.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context3079 = new MethodContext(double.class, 114, 3959, 4326);
        try {
            CallChecker.varInit(this, "this", 114, 3959, 4326);
            CallChecker.varInit(x, "x", 114, 3959, 4326);
            CallChecker.varInit(this.random, "random", 114, 3959, 4326);
            CallChecker.varInit(this.randomData, "randomData", 114, 3959, 4326);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 114, 3959, 4326);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 114, 3959, 4326);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 114, 3959, 4326);
            double ret = CallChecker.init(double.class);
            if (x < 0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 117, 4082, 4091);
            }else
                if (x >= (numberOfTrials)) {
                    ret = 1.0;
                    CallChecker.varAssign(ret, "ret", 119, 4147, 4156);
                }else {
                    ret = 1.0 - (org.apache.commons.math3.special.Beta.regularizedBeta(probabilityOfSuccess, (x + 1.0), ((numberOfTrials) - x)));
                    CallChecker.varAssign(ret, "ret", 121, 4187, 4290);
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3079.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context3080 = new MethodContext(double.class, 133, 4333, 4569);
        try {
            CallChecker.varInit(this, "this", 133, 4333, 4569);
            CallChecker.varInit(this.random, "random", 133, 4333, 4569);
            CallChecker.varInit(this.randomData, "randomData", 133, 4333, 4569);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 133, 4333, 4569);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 133, 4333, 4569);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 133, 4333, 4569);
            return (numberOfTrials) * (probabilityOfSuccess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3080.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context3081 = new MethodContext(double.class, 143, 4576, 4868);
        try {
            CallChecker.varInit(this, "this", 143, 4576, 4868);
            CallChecker.varInit(this.random, "random", 143, 4576, 4868);
            CallChecker.varInit(this.randomData, "randomData", 143, 4576, 4868);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 143, 4576, 4868);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 143, 4576, 4868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 143, 4576, 4868);
            final double p = CallChecker.varInit(((double) (this.probabilityOfSuccess)), "p", 144, 4780, 4817);
            return ((numberOfTrials) * p) * (1 - p);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3081.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context3082 = new MethodContext(int.class, 156, 4875, 5209);
        try {
            CallChecker.varInit(this, "this", 156, 4875, 5209);
            CallChecker.varInit(this.random, "random", 156, 4875, 5209);
            CallChecker.varInit(this.randomData, "randomData", 156, 4875, 5209);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 156, 4875, 5209);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 156, 4875, 5209);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 156, 4875, 5209);
            if ((probabilityOfSuccess) < 1.0) {
                return 0;
            }else {
                return numberOfTrials;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3082.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context3083 = new MethodContext(int.class, 168, 5216, 5558);
        try {
            CallChecker.varInit(this, "this", 168, 5216, 5558);
            CallChecker.varInit(this.random, "random", 168, 5216, 5558);
            CallChecker.varInit(this.randomData, "randomData", 168, 5216, 5558);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 168, 5216, 5558);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 168, 5216, 5558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 168, 5216, 5558);
            if ((probabilityOfSuccess) > 0.0) {
                return numberOfTrials;
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3083.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context3084 = new MethodContext(boolean.class, 179, 5565, 5761);
        try {
            CallChecker.varInit(this, "this", 179, 5565, 5761);
            CallChecker.varInit(this.random, "random", 179, 5565, 5761);
            CallChecker.varInit(this.randomData, "randomData", 179, 5565, 5761);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 179, 5565, 5761);
            CallChecker.varInit(this.numberOfTrials, "numberOfTrials", 179, 5565, 5761);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.BinomialDistribution.serialVersionUID", 179, 5565, 5761);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3084.methodEnd();
        }
    }
}

