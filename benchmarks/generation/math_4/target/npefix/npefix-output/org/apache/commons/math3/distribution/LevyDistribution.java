package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

public class LevyDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130314L;

    private final double mu;

    private final double c;

    private final double halfC;

    public LevyDistribution(final RandomGenerator rng, final double mu, final double c) {
        super(rng);
        ConstructorContext _bcornu_methode_context703 = new ConstructorContext(LevyDistribution.class, 51, 1629, 1986);
        try {
            this.mu = mu;
            CallChecker.varAssign(this.mu, "this.mu", 53, 1911, 1926);
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 54, 1936, 1950);
            this.halfC = 0.5 * c;
            CallChecker.varAssign(this.halfC, "this.halfC", 55, 1960, 1980);
        } finally {
            _bcornu_methode_context703.methodEnd();
        }
    }

    public double density(final double x) {
        MethodContext _bcornu_methode_context3085 = new MethodContext(double.class, 72, 1993, 2787);
        try {
            CallChecker.varInit(this, "this", 72, 1993, 2787);
            CallChecker.varInit(x, "x", 72, 1993, 2787);
            CallChecker.varInit(this.random, "random", 72, 1993, 2787);
            CallChecker.varInit(this.randomData, "randomData", 72, 1993, 2787);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 72, 1993, 2787);
            CallChecker.varInit(this.halfC, "halfC", 72, 1993, 2787);
            CallChecker.varInit(this.c, "c", 72, 1993, 2787);
            CallChecker.varInit(this.mu, "mu", 72, 1993, 2787);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 72, 1993, 2787);
            if (x < (mu)) {
                return Double.NaN;
            }
            final double delta = CallChecker.varInit(((double) (x - (this.mu))), "delta", 77, 2637, 2664);
            final double f = CallChecker.varInit(((double) ((this.halfC) / delta)), "f", 78, 2674, 2708);
            return ((FastMath.sqrt((f / (FastMath.PI)))) * (FastMath.exp((-f)))) / delta;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3085.methodEnd();
        }
    }

    public double cumulativeProbability(final double x) {
        MethodContext _bcornu_methode_context3086 = new MethodContext(double.class, 90, 2794, 3168);
        try {
            CallChecker.varInit(this, "this", 90, 2794, 3168);
            CallChecker.varInit(x, "x", 90, 2794, 3168);
            CallChecker.varInit(this.random, "random", 90, 2794, 3168);
            CallChecker.varInit(this.randomData, "randomData", 90, 2794, 3168);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 90, 2794, 3168);
            CallChecker.varInit(this.halfC, "halfC", 90, 2794, 3168);
            CallChecker.varInit(this.c, "c", 90, 2794, 3168);
            CallChecker.varInit(this.mu, "mu", 90, 2794, 3168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 90, 2794, 3168);
            if (x < (mu)) {
                return Double.NaN;
            }
            return Erf.erfc(FastMath.sqrt(((halfC) / (x - (mu)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3086.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3087 = new MethodContext(double.class, 99, 3175, 3480);
        try {
            CallChecker.varInit(this, "this", 99, 3175, 3480);
            CallChecker.varInit(p, "p", 99, 3175, 3480);
            CallChecker.varInit(this.random, "random", 99, 3175, 3480);
            CallChecker.varInit(this.randomData, "randomData", 99, 3175, 3480);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 99, 3175, 3480);
            CallChecker.varInit(this.halfC, "halfC", 99, 3175, 3480);
            CallChecker.varInit(this.c, "c", 99, 3175, 3480);
            CallChecker.varInit(this.mu, "mu", 99, 3175, 3480);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 99, 3175, 3480);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            final double t = CallChecker.varInit(((double) (Erf.erfcInv(p))), "t", 103, 3406, 3437);
            return (mu) + ((halfC) / (t * t));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3087.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context3088 = new MethodContext(double.class, 110, 3487, 3648);
        try {
            CallChecker.varInit(this, "this", 110, 3487, 3648);
            CallChecker.varInit(this.random, "random", 110, 3487, 3648);
            CallChecker.varInit(this.randomData, "randomData", 110, 3487, 3648);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 110, 3487, 3648);
            CallChecker.varInit(this.halfC, "halfC", 110, 3487, 3648);
            CallChecker.varInit(this.c, "c", 110, 3487, 3648);
            CallChecker.varInit(this.mu, "mu", 110, 3487, 3648);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 110, 3487, 3648);
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3088.methodEnd();
        }
    }

    public double getLocation() {
        MethodContext _bcornu_methode_context3089 = new MethodContext(double.class, 117, 3655, 3826);
        try {
            CallChecker.varInit(this, "this", 117, 3655, 3826);
            CallChecker.varInit(this.random, "random", 117, 3655, 3826);
            CallChecker.varInit(this.randomData, "randomData", 117, 3655, 3826);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 117, 3655, 3826);
            CallChecker.varInit(this.halfC, "halfC", 117, 3655, 3826);
            CallChecker.varInit(this.c, "c", 117, 3655, 3826);
            CallChecker.varInit(this.mu, "mu", 117, 3655, 3826);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 117, 3655, 3826);
            return mu;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3089.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context3090 = new MethodContext(double.class, 122, 3833, 3938);
        try {
            CallChecker.varInit(this, "this", 122, 3833, 3938);
            CallChecker.varInit(this.random, "random", 122, 3833, 3938);
            CallChecker.varInit(this.randomData, "randomData", 122, 3833, 3938);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 122, 3833, 3938);
            CallChecker.varInit(this.halfC, "halfC", 122, 3833, 3938);
            CallChecker.varInit(this.c, "c", 122, 3833, 3938);
            CallChecker.varInit(this.mu, "mu", 122, 3833, 3938);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 122, 3833, 3938);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3090.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context3091 = new MethodContext(double.class, 127, 3945, 4054);
        try {
            CallChecker.varInit(this, "this", 127, 3945, 4054);
            CallChecker.varInit(this.random, "random", 127, 3945, 4054);
            CallChecker.varInit(this.randomData, "randomData", 127, 3945, 4054);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 127, 3945, 4054);
            CallChecker.varInit(this.halfC, "halfC", 127, 3945, 4054);
            CallChecker.varInit(this.c, "c", 127, 3945, 4054);
            CallChecker.varInit(this.mu, "mu", 127, 3945, 4054);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 127, 3945, 4054);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3091.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context3092 = new MethodContext(double.class, 132, 4061, 4148);
        try {
            CallChecker.varInit(this, "this", 132, 4061, 4148);
            CallChecker.varInit(this.random, "random", 132, 4061, 4148);
            CallChecker.varInit(this.randomData, "randomData", 132, 4061, 4148);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 132, 4061, 4148);
            CallChecker.varInit(this.halfC, "halfC", 132, 4061, 4148);
            CallChecker.varInit(this.c, "c", 132, 4061, 4148);
            CallChecker.varInit(this.mu, "mu", 132, 4061, 4148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 132, 4061, 4148);
            return mu;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3092.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context3093 = new MethodContext(double.class, 137, 4155, 4264);
        try {
            CallChecker.varInit(this, "this", 137, 4155, 4264);
            CallChecker.varInit(this.random, "random", 137, 4155, 4264);
            CallChecker.varInit(this.randomData, "randomData", 137, 4155, 4264);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 137, 4155, 4264);
            CallChecker.varInit(this.halfC, "halfC", 137, 4155, 4264);
            CallChecker.varInit(this.c, "c", 137, 4155, 4264);
            CallChecker.varInit(this.mu, "mu", 137, 4155, 4264);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 137, 4155, 4264);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3093.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context3094 = new MethodContext(boolean.class, 142, 4271, 4504);
        try {
            CallChecker.varInit(this, "this", 142, 4271, 4504);
            CallChecker.varInit(this.random, "random", 142, 4271, 4504);
            CallChecker.varInit(this.randomData, "randomData", 142, 4271, 4504);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 142, 4271, 4504);
            CallChecker.varInit(this.halfC, "halfC", 142, 4271, 4504);
            CallChecker.varInit(this.c, "c", 142, 4271, 4504);
            CallChecker.varInit(this.mu, "mu", 142, 4271, 4504);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 142, 4271, 4504);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3094.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context3095 = new MethodContext(boolean.class, 149, 4511, 4669);
        try {
            CallChecker.varInit(this, "this", 149, 4511, 4669);
            CallChecker.varInit(this.random, "random", 149, 4511, 4669);
            CallChecker.varInit(this.randomData, "randomData", 149, 4511, 4669);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 149, 4511, 4669);
            CallChecker.varInit(this.halfC, "halfC", 149, 4511, 4669);
            CallChecker.varInit(this.c, "c", 149, 4511, 4669);
            CallChecker.varInit(this.mu, "mu", 149, 4511, 4669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 149, 4511, 4669);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3095.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context3096 = new MethodContext(boolean.class, 155, 4676, 4764);
        try {
            CallChecker.varInit(this, "this", 155, 4676, 4764);
            CallChecker.varInit(this.random, "random", 155, 4676, 4764);
            CallChecker.varInit(this.randomData, "randomData", 155, 4676, 4764);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 155, 4676, 4764);
            CallChecker.varInit(this.halfC, "halfC", 155, 4676, 4764);
            CallChecker.varInit(this.c, "c", 155, 4676, 4764);
            CallChecker.varInit(this.mu, "mu", 155, 4676, 4764);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LevyDistribution.serialVersionUID", 155, 4676, 4764);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3096.methodEnd();
        }
    }
}

