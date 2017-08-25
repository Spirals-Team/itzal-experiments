package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class GeometricDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130507L;

    private final double probabilityOfSuccess;

    public GeometricDistribution(double p) {
        this(new Well19937c(), p);
        ConstructorContext _bcornu_methode_context892 = new ConstructorContext(GeometricDistribution.class, 46, 1716, 2008);
        try {
        } finally {
            _bcornu_methode_context892.methodEnd();
        }
    }

    public GeometricDistribution(RandomGenerator rng, double p) {
        super(rng);
        ConstructorContext _bcornu_methode_context893 = new ConstructorContext(GeometricDistribution.class, 57, 2015, 2484);
        try {
            if ((p <= 0) || (p > 1)) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, p, 0, 1);
            }
            probabilityOfSuccess = p;
            CallChecker.varAssign(this.probabilityOfSuccess, "this.probabilityOfSuccess", 64, 2454, 2478);
        } finally {
            _bcornu_methode_context893.methodEnd();
        }
    }

    public double getProbabilityOfSuccess() {
        MethodContext _bcornu_methode_context3981 = new MethodContext(double.class, 72, 2491, 2704);
        try {
            CallChecker.varInit(this, "this", 72, 2491, 2704);
            CallChecker.varInit(this.random, "random", 72, 2491, 2704);
            CallChecker.varInit(this.randomData, "randomData", 72, 2491, 2704);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 72, 2491, 2704);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 72, 2491, 2704);
            return probabilityOfSuccess;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3981.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context3982 = new MethodContext(double.class, 77, 2711, 2983);
        try {
            CallChecker.varInit(this, "this", 77, 2711, 2983);
            CallChecker.varInit(x, "x", 77, 2711, 2983);
            CallChecker.varInit(this.random, "random", 77, 2711, 2983);
            CallChecker.varInit(this.randomData, "randomData", 77, 2711, 2983);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 77, 2711, 2983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 77, 2711, 2983);
            double ret = CallChecker.init(double.class);
            if (x < 0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 80, 2824, 2833);
            }else {
                final double p = CallChecker.varInit(((double) (this.probabilityOfSuccess)), "p", 82, 2864, 2901);
                ret = (FastMath.pow((1 - p), x)) * p;
                CallChecker.varAssign(ret, "ret", 83, 2915, 2947);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3982.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context3983 = new MethodContext(double.class, 89, 2990, 3278);
        try {
            CallChecker.varInit(this, "this", 89, 2990, 3278);
            CallChecker.varInit(x, "x", 89, 2990, 3278);
            CallChecker.varInit(this.random, "random", 89, 2990, 3278);
            CallChecker.varInit(this.randomData, "randomData", 89, 2990, 3278);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 89, 2990, 3278);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 89, 2990, 3278);
            double ret = CallChecker.init(double.class);
            if (x < 0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 92, 3113, 3122);
            }else {
                final double p = CallChecker.varInit(((double) (this.probabilityOfSuccess)), "p", 94, 3153, 3190);
                ret = 1.0 - (FastMath.pow((1 - p), (x + 1)));
                CallChecker.varAssign(ret, "ret", 95, 3204, 3242);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3983.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context3984 = new MethodContext(double.class, 105, 3285, 3520);
        try {
            CallChecker.varInit(this, "this", 105, 3285, 3520);
            CallChecker.varInit(this.random, "random", 105, 3285, 3520);
            CallChecker.varInit(this.randomData, "randomData", 105, 3285, 3520);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 105, 3285, 3520);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 105, 3285, 3520);
            final double p = CallChecker.varInit(((double) (this.probabilityOfSuccess)), "p", 106, 3449, 3486);
            return (1 - p) / p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3984.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context3985 = new MethodContext(double.class, 116, 3527, 3789);
        try {
            CallChecker.varInit(this, "this", 116, 3527, 3789);
            CallChecker.varInit(this.random, "random", 116, 3527, 3789);
            CallChecker.varInit(this.randomData, "randomData", 116, 3527, 3789);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 116, 3527, 3789);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 116, 3527, 3789);
            final double p = CallChecker.varInit(((double) (this.probabilityOfSuccess)), "p", 117, 3712, 3749);
            return (1 - p) / (p * p);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3985.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context3986 = new MethodContext(int.class, 128, 3796, 4009);
        try {
            CallChecker.varInit(this, "this", 128, 3796, 4009);
            CallChecker.varInit(this.random, "random", 128, 3796, 4009);
            CallChecker.varInit(this.randomData, "randomData", 128, 3796, 4009);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 128, 3796, 4009);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 128, 3796, 4009);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3986.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context3987 = new MethodContext(int.class, 140, 4016, 4320);
        try {
            CallChecker.varInit(this, "this", 140, 4016, 4320);
            CallChecker.varInit(this.random, "random", 140, 4016, 4320);
            CallChecker.varInit(this.randomData, "randomData", 140, 4016, 4320);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 140, 4016, 4320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 140, 4016, 4320);
            return Integer.MAX_VALUE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3987.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context3988 = new MethodContext(boolean.class, 151, 4327, 4523);
        try {
            CallChecker.varInit(this, "this", 151, 4327, 4523);
            CallChecker.varInit(this.random, "random", 151, 4327, 4523);
            CallChecker.varInit(this.randomData, "randomData", 151, 4327, 4523);
            CallChecker.varInit(this.probabilityOfSuccess, "probabilityOfSuccess", 151, 4327, 4523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GeometricDistribution.serialVersionUID", 151, 4327, 4523);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3988.methodEnd();
        }
    }
}

