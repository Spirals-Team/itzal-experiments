package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

public class PascalDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 6751309484392813623L;

    private final int numberOfSuccesses;

    private final double probabilityOfSuccess;

    public PascalDistribution(int r, double p) throws NotStrictlyPositiveException, OutOfRangeException {
        this(new Well19937c(), r, p);
        ConstructorContext _bcornu_methode_context360 = new ConstructorContext(PascalDistribution.class, 82, 3411, 3964);
        try {
        } finally {
            _bcornu_methode_context360.methodEnd();
        }
    }

    public PascalDistribution(RandomGenerator rng, int r, double p) throws NotStrictlyPositiveException, OutOfRangeException {
        super(rng);
        ConstructorContext _bcornu_methode_context361 = new ConstructorContext(PascalDistribution.class, 99, 3971, 4983);
        try {
            if (r <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, r);
            }
            if ((p < 0) || (p > 1)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            numberOfSuccesses = r;
            CallChecker.varAssign(this.numberOfSuccesses, "this.numberOfSuccesses", 113, 4922, 4943);
            probabilityOfSuccess = p;
            CallChecker.varAssign(this.probabilityOfSuccess, "this.probabilityOfSuccess", 114, 4953, 4977);
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }

    public int getNumberOfSuccesses() {
        MethodContext _bcornu_methode_context1600 = new MethodContext(int.class, 122, 4990, 5188);
        try {
            CallChecker.varInit(this, "this", 122, 4990, 5188);
            CallChecker.varInit(this.random, "random", 122, 4990, 5188);
            CallChecker.varInit(this.randomData, "randomData", 122, 4990, 5188);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 122, 4990, 5188);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 122, 4990, 5188);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 122, 4990, 5188);
            return numberOfSuccesses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1600.methodEnd();
        }
    }

    public double getProbabilityOfSuccess() {
        MethodContext _bcornu_methode_context1601 = new MethodContext(double.class, 131, 5195, 5408);
        try {
            CallChecker.varInit(this, "this", 131, 5195, 5408);
            CallChecker.varInit(this.random, "random", 131, 5195, 5408);
            CallChecker.varInit(this.randomData, "randomData", 131, 5195, 5408);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 131, 5195, 5408);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 131, 5195, 5408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 131, 5195, 5408);
            return probabilityOfSuccess;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1601.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context1602 = new MethodContext(double.class, 136, 5415, 5857);
        try {
            CallChecker.varInit(this, "this", 136, 5415, 5857);
            CallChecker.varInit(x, "x", 136, 5415, 5857);
            CallChecker.varInit(this.random, "random", 136, 5415, 5857);
            CallChecker.varInit(this.randomData, "randomData", 136, 5415, 5857);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 136, 5415, 5857);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 136, 5415, 5857);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 136, 5415, 5857);
            double ret = CallChecker.init(double.class);
            if (x < 0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 139, 5528, 5537);
            }else {
                ret = ((ArithmeticUtils.binomialCoefficientDouble(((x + (numberOfSuccesses)) - 1), ((numberOfSuccesses) - 1))) * (FastMath.pow(probabilityOfSuccess, numberOfSuccesses))) * (FastMath.pow((1.0 - (probabilityOfSuccess)), x));
                CallChecker.varAssign(ret, "ret", 141, 5568, 5821);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1602.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context1603 = new MethodContext(double.class, 150, 5864, 6159);
        try {
            CallChecker.varInit(this, "this", 150, 5864, 6159);
            CallChecker.varInit(x, "x", 150, 5864, 6159);
            CallChecker.varInit(this.random, "random", 150, 5864, 6159);
            CallChecker.varInit(this.randomData, "randomData", 150, 5864, 6159);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 150, 5864, 6159);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 150, 5864, 6159);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 150, 5864, 6159);
            double ret = CallChecker.init(double.class);
            if (x < 0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 153, 5987, 5996);
            }else {
                ret = Beta.regularizedBeta(probabilityOfSuccess, numberOfSuccesses, (x + 1.0));
                CallChecker.varAssign(ret, "ret", 155, 6027, 6123);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1603.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1604 = new MethodContext(double.class, 167, 6166, 6507);
        try {
            CallChecker.varInit(this, "this", 167, 6166, 6507);
            CallChecker.varInit(this.random, "random", 167, 6166, 6507);
            CallChecker.varInit(this.randomData, "randomData", 167, 6166, 6507);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 167, 6166, 6507);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 167, 6166, 6507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 167, 6166, 6507);
            final double p = CallChecker.varInit(((double) (getProbabilityOfSuccess())), "p", 168, 6376, 6418);
            final double r = CallChecker.varInit(((double) (getNumberOfSuccesses())), "r", 169, 6428, 6467);
            return (r * (1 - p)) / p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1604.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1605 = new MethodContext(double.class, 179, 6514, 6869);
        try {
            CallChecker.varInit(this, "this", 179, 6514, 6869);
            CallChecker.varInit(this.random, "random", 179, 6514, 6869);
            CallChecker.varInit(this.randomData, "randomData", 179, 6514, 6869);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 179, 6514, 6869);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 179, 6514, 6869);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 179, 6514, 6869);
            final double p = CallChecker.varInit(((double) (getProbabilityOfSuccess())), "p", 180, 6734, 6776);
            final double r = CallChecker.varInit(((double) (getNumberOfSuccesses())), "r", 181, 6786, 6825);
            return (r * (1 - p)) / (p * p);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1605.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context1606 = new MethodContext(int.class, 192, 6876, 7114);
        try {
            CallChecker.varInit(this, "this", 192, 6876, 7114);
            CallChecker.varInit(this.random, "random", 192, 6876, 7114);
            CallChecker.varInit(this.randomData, "randomData", 192, 6876, 7114);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 192, 6876, 7114);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 192, 6876, 7114);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 192, 6876, 7114);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1606.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context1607 = new MethodContext(int.class, 205, 7121, 7513);
        try {
            CallChecker.varInit(this, "this", 205, 7121, 7513);
            CallChecker.varInit(this.random, "random", 205, 7121, 7513);
            CallChecker.varInit(this.randomData, "randomData", 205, 7121, 7513);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 205, 7121, 7513);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 205, 7121, 7513);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 205, 7121, 7513);
            return Integer.MAX_VALUE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1607.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1608 = new MethodContext(boolean.class, 216, 7520, 7716);
        try {
            CallChecker.varInit(this, "this", 216, 7520, 7716);
            CallChecker.varInit(this.random, "random", 216, 7520, 7716);
            CallChecker.varInit(this.randomData, "randomData", 216, 7520, 7716);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 216, 7520, 7716);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 216, 7520, 7716);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.PascalDistribution.serialVersionUID", 216, 7520, 7716);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1608.methodEnd();
        }
    }
}

