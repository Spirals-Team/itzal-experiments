package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

public class TDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = -5852615386664158222L;

    private final double degreesOfFreedom;

    private final double solverAbsoluteAccuracy;

    public TDistribution(double degreesOfFreedom) throws NotStrictlyPositiveException {
        this(degreesOfFreedom, TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context1137 = new ConstructorContext(TDistribution.class, 53, 2073, 2454);
        try {
        } finally {
            _bcornu_methode_context1137.methodEnd();
        }
    }

    public TDistribution(double degreesOfFreedom, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), degreesOfFreedom, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context1138 = new ConstructorContext(TDistribution.class, 69, 2461, 3140);
        try {
        } finally {
            _bcornu_methode_context1138.methodEnd();
        }
    }

    public TDistribution(RandomGenerator rng, double degreesOfFreedom, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context1139 = new ConstructorContext(TDistribution.class, 85, 3147, 4091);
        try {
            if (degreesOfFreedom <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, degreesOfFreedom);
            }
            this.degreesOfFreedom = degreesOfFreedom;
            CallChecker.varAssign(this.degreesOfFreedom, "this.degreesOfFreedom", 95, 3992, 4032);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 96, 4042, 4085);
        } finally {
            _bcornu_methode_context1139.methodEnd();
        }
    }

    public double getDegreesOfFreedom() {
        MethodContext _bcornu_methode_context5140 = new MethodContext(double.class, 104, 4098, 4273);
        try {
            CallChecker.varInit(this, "this", 104, 4098, 4273);
            CallChecker.varInit(this.random, "random", 104, 4098, 4273);
            CallChecker.varInit(this.randomData, "randomData", 104, 4098, 4273);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 104, 4098, 4273);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 104, 4098, 4273);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 104, 4098, 4273);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 104, 4098, 4273);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 104, 4098, 4273);
            return degreesOfFreedom;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5140.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context5141 = new MethodContext(double.class, 109, 4280, 4733);
        try {
            CallChecker.varInit(this, "this", 109, 4280, 4733);
            CallChecker.varInit(x, "x", 109, 4280, 4733);
            CallChecker.varInit(this.random, "random", 109, 4280, 4733);
            CallChecker.varInit(this.randomData, "randomData", 109, 4280, 4733);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 109, 4280, 4733);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 109, 4280, 4733);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 109, 4280, 4733);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 109, 4280, 4733);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 109, 4280, 4733);
            final double n = CallChecker.varInit(((double) (this.degreesOfFreedom)), "n", 110, 4347, 4380);
            final double nPlus1Over2 = CallChecker.varInit(((double) ((n + 1) / 2)), "nPlus1Over2", 111, 4390, 4428);
            return FastMath.exp(((((Gamma.logGamma(nPlus1Over2)) - (0.5 * ((FastMath.log(FastMath.PI)) + (FastMath.log(n))))) - (Gamma.logGamma((n / 2)))) - (nPlus1Over2 * (FastMath.log((1 + ((x * x) / n)))))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5141.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context5142 = new MethodContext(double.class, 120, 4740, 5260);
        try {
            CallChecker.varInit(this, "this", 120, 4740, 5260);
            CallChecker.varInit(x, "x", 120, 4740, 5260);
            CallChecker.varInit(this.random, "random", 120, 4740, 5260);
            CallChecker.varInit(this.randomData, "randomData", 120, 4740, 5260);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 120, 4740, 5260);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 120, 4740, 5260);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 120, 4740, 5260);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 120, 4740, 5260);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 120, 4740, 5260);
            double ret = CallChecker.init(double.class);
            if (x == 0) {
                ret = 0.5;
                CallChecker.varAssign(ret, "ret", 123, 4867, 4876);
            }else {
                double t = CallChecker.varInit(((double) (Beta.regularizedBeta(((this.degreesOfFreedom) / ((this.degreesOfFreedom) + (x * x))), (0.5 * (this.degreesOfFreedom)), 0.5))), "t", 125, 4907, 5093);
                if (x < 0.0) {
                    ret = 0.5 * t;
                    CallChecker.varAssign(ret, "ret", 131, 5138, 5151);
                }else {
                    ret = 1.0 - (0.5 * t);
                    CallChecker.varAssign(ret, "ret", 133, 5190, 5209);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5142.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context5143 = new MethodContext(double.class, 142, 5267, 5396);
        try {
            CallChecker.varInit(this, "this", 142, 5267, 5396);
            CallChecker.varInit(this.random, "random", 142, 5267, 5396);
            CallChecker.varInit(this.randomData, "randomData", 142, 5267, 5396);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 142, 5267, 5396);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 142, 5267, 5396);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 142, 5267, 5396);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 142, 5267, 5396);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 142, 5267, 5396);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5143.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context5144 = new MethodContext(double.class, 155, 5403, 5811);
        try {
            CallChecker.varInit(this, "this", 155, 5403, 5811);
            CallChecker.varInit(this.random, "random", 155, 5403, 5811);
            CallChecker.varInit(this.randomData, "randomData", 155, 5403, 5811);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 155, 5403, 5811);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 155, 5403, 5811);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 155, 5403, 5811);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 155, 5403, 5811);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 155, 5403, 5811);
            final double df = CallChecker.varInit(((double) (getDegreesOfFreedom())), "df", 156, 5683, 5722);
            if (df > 1) {
                return 0;
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5144.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context5145 = new MethodContext(double.class, 176, 5818, 6455);
        try {
            CallChecker.varInit(this, "this", 176, 5818, 6455);
            CallChecker.varInit(this.random, "random", 176, 5818, 6455);
            CallChecker.varInit(this.randomData, "randomData", 176, 5818, 6455);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 176, 5818, 6455);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 176, 5818, 6455);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 176, 5818, 6455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 176, 5818, 6455);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 176, 5818, 6455);
            final double df = CallChecker.varInit(((double) (getDegreesOfFreedom())), "df", 177, 6226, 6265);
            if (df > 2) {
                return df / (df - 2);
            }
            if ((df > 1) && (df <= 2)) {
                return Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5145.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context5146 = new MethodContext(double.class, 199, 6462, 6787);
        try {
            CallChecker.varInit(this, "this", 199, 6462, 6787);
            CallChecker.varInit(this.random, "random", 199, 6462, 6787);
            CallChecker.varInit(this.randomData, "randomData", 199, 6462, 6787);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 199, 6462, 6787);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 199, 6462, 6787);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 199, 6462, 6787);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 199, 6462, 6787);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 199, 6462, 6787);
            return Double.NEGATIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5146.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context5147 = new MethodContext(double.class, 212, 6794, 7119);
        try {
            CallChecker.varInit(this, "this", 212, 6794, 7119);
            CallChecker.varInit(this.random, "random", 212, 6794, 7119);
            CallChecker.varInit(this.randomData, "randomData", 212, 6794, 7119);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 212, 6794, 7119);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 212, 6794, 7119);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 212, 6794, 7119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 212, 6794, 7119);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 212, 6794, 7119);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5147.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context5148 = new MethodContext(boolean.class, 217, 7126, 7225);
        try {
            CallChecker.varInit(this, "this", 217, 7126, 7225);
            CallChecker.varInit(this.random, "random", 217, 7126, 7225);
            CallChecker.varInit(this.randomData, "randomData", 217, 7126, 7225);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 217, 7126, 7225);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 217, 7126, 7225);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 217, 7126, 7225);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 217, 7126, 7225);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 217, 7126, 7225);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5148.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context5149 = new MethodContext(boolean.class, 222, 7232, 7331);
        try {
            CallChecker.varInit(this, "this", 222, 7232, 7331);
            CallChecker.varInit(this.random, "random", 222, 7232, 7331);
            CallChecker.varInit(this.randomData, "randomData", 222, 7232, 7331);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 222, 7232, 7331);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 222, 7232, 7331);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 222, 7232, 7331);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 222, 7232, 7331);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 222, 7232, 7331);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5149.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context5150 = new MethodContext(boolean.class, 233, 7338, 7534);
        try {
            CallChecker.varInit(this, "this", 233, 7338, 7534);
            CallChecker.varInit(this.random, "random", 233, 7338, 7534);
            CallChecker.varInit(this.randomData, "randomData", 233, 7338, 7534);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 233, 7338, 7534);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 233, 7338, 7534);
            CallChecker.varInit(this.degreesOfFreedom, "degreesOfFreedom", 233, 7338, 7534);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TDistribution.serialVersionUID", 233, 7338, 7534);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 233, 7338, 7534);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5150.methodEnd();
        }
    }
}

