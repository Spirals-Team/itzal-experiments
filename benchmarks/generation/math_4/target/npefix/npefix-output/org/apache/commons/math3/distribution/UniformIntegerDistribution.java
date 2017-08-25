package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class UniformIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20120109L;

    private final int lower;

    private final int upper;

    public UniformIntegerDistribution(int lower, int upper) throws NumberIsTooLargeException {
        this(new Well19937c(), lower, upper);
        ConstructorContext _bcornu_methode_context1250 = new ConstructorContext(UniformIntegerDistribution.class, 51, 1733, 2219);
        try {
        } finally {
            _bcornu_methode_context1250.methodEnd();
        }
    }

    public UniformIntegerDistribution(RandomGenerator rng, int lower, int upper) throws NumberIsTooLargeException {
        super(rng);
        ConstructorContext _bcornu_methode_context1251 = new ConstructorContext(UniformIntegerDistribution.class, 66, 2226, 3120);
        try {
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            this.lower = lower;
            CallChecker.varAssign(this.lower, "this.lower", 77, 3068, 3086);
            this.upper = upper;
            CallChecker.varAssign(this.upper, "this.upper", 78, 3096, 3114);
        } finally {
            _bcornu_methode_context1251.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context5613 = new MethodContext(double.class, 82, 3127, 3303);
        try {
            CallChecker.varInit(this, "this", 82, 3127, 3303);
            CallChecker.varInit(x, "x", 82, 3127, 3303);
            CallChecker.varInit(this.random, "random", 82, 3127, 3303);
            CallChecker.varInit(this.randomData, "randomData", 82, 3127, 3303);
            CallChecker.varInit(this.upper, "upper", 82, 3127, 3303);
            CallChecker.varInit(this.lower, "lower", 82, 3127, 3303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 82, 3127, 3303);
            if ((x < (lower)) || (x > (upper))) {
                return 0;
            }
            return 1.0 / (((upper) - (lower)) + 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5613.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context5614 = new MethodContext(double.class, 90, 3310, 3556);
        try {
            CallChecker.varInit(this, "this", 90, 3310, 3556);
            CallChecker.varInit(x, "x", 90, 3310, 3556);
            CallChecker.varInit(this.random, "random", 90, 3310, 3556);
            CallChecker.varInit(this.randomData, "randomData", 90, 3310, 3556);
            CallChecker.varInit(this.upper, "upper", 90, 3310, 3556);
            CallChecker.varInit(this.lower, "lower", 90, 3310, 3556);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 90, 3310, 3556);
            if (x < (lower)) {
                return 0;
            }
            if (x > (upper)) {
                return 1;
            }
            return ((x - (lower)) + 1.0) / (((upper) - (lower)) + 1.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5614.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context5615 = new MethodContext(double.class, 106, 3563, 3802);
        try {
            CallChecker.varInit(this, "this", 106, 3563, 3802);
            CallChecker.varInit(this.random, "random", 106, 3563, 3802);
            CallChecker.varInit(this.randomData, "randomData", 106, 3563, 3802);
            CallChecker.varInit(this.upper, "upper", 106, 3563, 3802);
            CallChecker.varInit(this.lower, "lower", 106, 3563, 3802);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 106, 3563, 3802);
            return 0.5 * ((lower) + (upper));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5615.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context5616 = new MethodContext(double.class, 116, 3809, 4119);
        try {
            CallChecker.varInit(this, "this", 116, 3809, 4119);
            CallChecker.varInit(this.random, "random", 116, 3809, 4119);
            CallChecker.varInit(this.randomData, "randomData", 116, 3809, 4119);
            CallChecker.varInit(this.upper, "upper", 116, 3809, 4119);
            CallChecker.varInit(this.lower, "lower", 116, 3809, 4119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 116, 3809, 4119);
            double n = CallChecker.varInit(((double) (((this.upper) - (this.lower)) + 1)), "n", 117, 4050, 4078);
            return ((n * n) - 1) / 12.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5616.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context5617 = new MethodContext(int.class, 129, 4126, 4385);
        try {
            CallChecker.varInit(this, "this", 129, 4126, 4385);
            CallChecker.varInit(this.random, "random", 129, 4126, 4385);
            CallChecker.varInit(this.randomData, "randomData", 129, 4126, 4385);
            CallChecker.varInit(this.upper, "upper", 129, 4126, 4385);
            CallChecker.varInit(this.lower, "lower", 129, 4126, 4385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 129, 4126, 4385);
            return lower;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5617.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context5618 = new MethodContext(int.class, 141, 4392, 4651);
        try {
            CallChecker.varInit(this, "this", 141, 4392, 4651);
            CallChecker.varInit(this.random, "random", 141, 4392, 4651);
            CallChecker.varInit(this.randomData, "randomData", 141, 4392, 4651);
            CallChecker.varInit(this.upper, "upper", 141, 4392, 4651);
            CallChecker.varInit(this.lower, "lower", 141, 4392, 4651);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 141, 4392, 4651);
            return upper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5618.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context5619 = new MethodContext(boolean.class, 152, 4658, 4854);
        try {
            CallChecker.varInit(this, "this", 152, 4658, 4854);
            CallChecker.varInit(this.random, "random", 152, 4658, 4854);
            CallChecker.varInit(this.randomData, "randomData", 152, 4658, 4854);
            CallChecker.varInit(this.upper, "upper", 152, 4658, 4854);
            CallChecker.varInit(this.lower, "lower", 152, 4658, 4854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 152, 4658, 4854);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5619.methodEnd();
        }
    }

    @Override
    public int sample() {
        MethodContext _bcornu_methode_context5620 = new MethodContext(int.class, 158, 4861, 5080);
        try {
            CallChecker.varInit(this, "this", 158, 4861, 5080);
            CallChecker.varInit(this.random, "random", 158, 4861, 5080);
            CallChecker.varInit(this.randomData, "randomData", 158, 4861, 5080);
            CallChecker.varInit(this.upper, "upper", 158, 4861, 5080);
            CallChecker.varInit(this.lower, "lower", 158, 4861, 5080);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformIntegerDistribution.serialVersionUID", 158, 4861, 5080);
            final double r = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 159, 4947, 4952).nextDouble())), "r", 159, 4930, 4966);
            final double scaled = CallChecker.varInit(((double) (((r * (this.upper)) + ((1 - r) * (this.lower))) + r)), "scaled", 160, 4976, 5029);
            return ((int) (FastMath.floor(scaled)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5620.methodEnd();
        }
    }
}

