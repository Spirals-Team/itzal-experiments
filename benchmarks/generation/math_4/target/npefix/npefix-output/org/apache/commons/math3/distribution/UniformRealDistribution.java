package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

public class UniformRealDistribution extends AbstractRealDistribution {
    @Deprecated
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 20120109L;

    private final double lower;

    private final double upper;

    public UniformRealDistribution() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context535 = new ConstructorContext(UniformRealDistribution.class, 52, 1974, 2192);
        try {
        } finally {
            _bcornu_methode_context535.methodEnd();
        }
    }

    public UniformRealDistribution(double lower, double upper) throws NumberIsTooLargeException {
        this(new Well19937c(), lower, upper);
        ConstructorContext _bcornu_methode_context536 = new ConstructorContext(UniformRealDistribution.class, 64, 2199, 2663);
        try {
        } finally {
            _bcornu_methode_context536.methodEnd();
        }
    }

    @Deprecated
    public UniformRealDistribution(double lower, double upper, double inverseCumAccuracy) throws NumberIsTooLargeException {
        this(new Well19937c(), lower, upper);
        ConstructorContext _bcornu_methode_context537 = new ConstructorContext(UniformRealDistribution.class, 80, 2670, 3355);
        try {
        } finally {
            _bcornu_methode_context537.methodEnd();
        }
    }

    @Deprecated
    public UniformRealDistribution(RandomGenerator rng, double lower, double upper, double inverseCumAccuracy) {
        this(rng, lower, upper);
        ConstructorContext _bcornu_methode_context538 = new ConstructorContext(UniformRealDistribution.class, 99, 3362, 4216);
        try {
        } finally {
            _bcornu_methode_context538.methodEnd();
        }
    }

    public UniformRealDistribution(RandomGenerator rng, double lower, double upper) throws NumberIsTooLargeException {
        super(rng);
        ConstructorContext _bcornu_methode_context539 = new ConstructorContext(UniformRealDistribution.class, 115, 4223, 5039);
        try {
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            this.lower = lower;
            CallChecker.varAssign(this.lower, "this.lower", 126, 4987, 5005);
            this.upper = upper;
            CallChecker.varAssign(this.upper, "this.upper", 127, 5015, 5033);
        } finally {
            _bcornu_methode_context539.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context2508 = new MethodContext(double.class, 131, 5046, 5217);
        try {
            CallChecker.varInit(this, "this", 131, 5046, 5217);
            CallChecker.varInit(x, "x", 131, 5046, 5217);
            CallChecker.varInit(this.random, "random", 131, 5046, 5217);
            CallChecker.varInit(this.randomData, "randomData", 131, 5046, 5217);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 131, 5046, 5217);
            CallChecker.varInit(this.upper, "upper", 131, 5046, 5217);
            CallChecker.varInit(this.lower, "lower", 131, 5046, 5217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 131, 5046, 5217);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 131, 5046, 5217);
            if ((x < (lower)) || (x > (upper))) {
                return 0.0;
            }
            return 1 / ((upper) - (lower));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2508.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context2509 = new MethodContext(double.class, 139, 5224, 5464);
        try {
            CallChecker.varInit(this, "this", 139, 5224, 5464);
            CallChecker.varInit(x, "x", 139, 5224, 5464);
            CallChecker.varInit(this.random, "random", 139, 5224, 5464);
            CallChecker.varInit(this.randomData, "randomData", 139, 5224, 5464);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 139, 5224, 5464);
            CallChecker.varInit(this.upper, "upper", 139, 5224, 5464);
            CallChecker.varInit(this.lower, "lower", 139, 5224, 5464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 139, 5224, 5464);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 139, 5224, 5464);
            if (x <= (lower)) {
                return 0;
            }
            if (x >= (upper)) {
                return 1;
            }
            return (x - (lower)) / ((upper) - (lower));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2509.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2510 = new MethodContext(double.class, 150, 5471, 5729);
        try {
            CallChecker.varInit(this, "this", 150, 5471, 5729);
            CallChecker.varInit(p, "p", 150, 5471, 5729);
            CallChecker.varInit(this.random, "random", 150, 5471, 5729);
            CallChecker.varInit(this.randomData, "randomData", 150, 5471, 5729);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 150, 5471, 5729);
            CallChecker.varInit(this.upper, "upper", 150, 5471, 5729);
            CallChecker.varInit(this.lower, "lower", 150, 5471, 5729);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 150, 5471, 5729);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 150, 5471, 5729);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            return (p * ((upper) - (lower))) + (lower);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2510.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context2511 = new MethodContext(double.class, 164, 5736, 5975);
        try {
            CallChecker.varInit(this, "this", 164, 5736, 5975);
            CallChecker.varInit(this.random, "random", 164, 5736, 5975);
            CallChecker.varInit(this.randomData, "randomData", 164, 5736, 5975);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 164, 5736, 5975);
            CallChecker.varInit(this.upper, "upper", 164, 5736, 5975);
            CallChecker.varInit(this.lower, "lower", 164, 5736, 5975);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 164, 5736, 5975);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 164, 5736, 5975);
            return 0.5 * ((lower) + (upper));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2511.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context2512 = new MethodContext(double.class, 174, 5982, 6256);
        try {
            CallChecker.varInit(this, "this", 174, 5982, 6256);
            CallChecker.varInit(this.random, "random", 174, 5982, 6256);
            CallChecker.varInit(this.randomData, "randomData", 174, 5982, 6256);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 174, 5982, 6256);
            CallChecker.varInit(this.upper, "upper", 174, 5982, 6256);
            CallChecker.varInit(this.lower, "lower", 174, 5982, 6256);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 174, 5982, 6256);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 174, 5982, 6256);
            double ul = CallChecker.varInit(((double) ((this.upper) - (this.lower))), "ul", 175, 6196, 6221);
            return (ul * ul) / 12;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2512.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context2513 = new MethodContext(double.class, 187, 6263, 6525);
        try {
            CallChecker.varInit(this, "this", 187, 6263, 6525);
            CallChecker.varInit(this.random, "random", 187, 6263, 6525);
            CallChecker.varInit(this.randomData, "randomData", 187, 6263, 6525);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 187, 6263, 6525);
            CallChecker.varInit(this.upper, "upper", 187, 6263, 6525);
            CallChecker.varInit(this.lower, "lower", 187, 6263, 6525);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 187, 6263, 6525);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 187, 6263, 6525);
            return lower;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2513.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context2514 = new MethodContext(double.class, 199, 6532, 6794);
        try {
            CallChecker.varInit(this, "this", 199, 6532, 6794);
            CallChecker.varInit(this.random, "random", 199, 6532, 6794);
            CallChecker.varInit(this.randomData, "randomData", 199, 6532, 6794);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 199, 6532, 6794);
            CallChecker.varInit(this.upper, "upper", 199, 6532, 6794);
            CallChecker.varInit(this.lower, "lower", 199, 6532, 6794);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 199, 6532, 6794);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 199, 6532, 6794);
            return upper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2514.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context2515 = new MethodContext(boolean.class, 204, 6801, 6899);
        try {
            CallChecker.varInit(this, "this", 204, 6801, 6899);
            CallChecker.varInit(this.random, "random", 204, 6801, 6899);
            CallChecker.varInit(this.randomData, "randomData", 204, 6801, 6899);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 204, 6801, 6899);
            CallChecker.varInit(this.upper, "upper", 204, 6801, 6899);
            CallChecker.varInit(this.lower, "lower", 204, 6801, 6899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 204, 6801, 6899);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 204, 6801, 6899);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2515.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context2516 = new MethodContext(boolean.class, 209, 6906, 7004);
        try {
            CallChecker.varInit(this, "this", 209, 6906, 7004);
            CallChecker.varInit(this.random, "random", 209, 6906, 7004);
            CallChecker.varInit(this.randomData, "randomData", 209, 6906, 7004);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 209, 6906, 7004);
            CallChecker.varInit(this.upper, "upper", 209, 6906, 7004);
            CallChecker.varInit(this.lower, "lower", 209, 6906, 7004);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 209, 6906, 7004);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 209, 6906, 7004);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2516.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context2517 = new MethodContext(boolean.class, 220, 7011, 7207);
        try {
            CallChecker.varInit(this, "this", 220, 7011, 7207);
            CallChecker.varInit(this.random, "random", 220, 7011, 7207);
            CallChecker.varInit(this.randomData, "randomData", 220, 7011, 7207);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 220, 7011, 7207);
            CallChecker.varInit(this.upper, "upper", 220, 7011, 7207);
            CallChecker.varInit(this.lower, "lower", 220, 7011, 7207);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 220, 7011, 7207);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 220, 7011, 7207);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2517.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context2518 = new MethodContext(double.class, 226, 7214, 7373);
        try {
            CallChecker.varInit(this, "this", 226, 7214, 7373);
            CallChecker.varInit(this.random, "random", 226, 7214, 7373);
            CallChecker.varInit(this.randomData, "randomData", 226, 7214, 7373);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 226, 7214, 7373);
            CallChecker.varInit(this.upper, "upper", 226, 7214, 7373);
            CallChecker.varInit(this.lower, "lower", 226, 7214, 7373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.UniformRealDistribution.serialVersionUID", 226, 7214, 7373);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.UniformRealDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 226, 7214, 7373);
            final double u = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 227, 7304, 7309).nextDouble())), "u", 227, 7287, 7323);
            return (u * (upper)) + ((1 - u) * (lower));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2518.methodEnd();
        }
    }
}

