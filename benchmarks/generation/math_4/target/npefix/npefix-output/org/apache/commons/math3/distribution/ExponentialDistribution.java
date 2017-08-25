package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.ResizableDoubleArray;

public class ExponentialDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 2401296428283614780L;

    private static final double[] EXPONENTIAL_SA_QI;

    private final double mean;

    private final double solverAbsoluteAccuracy;

    static {
        final double LN2 = CallChecker.varInit(((double) (FastMath.log(2))), "LN2", 70, 2787, 2945);
        double qi = CallChecker.varInit(((double) (0)), "qi", 71, 2955, 2968);
        int i = CallChecker.varInit(((int) (1)), "i", 72, 2978, 2987);
        final ResizableDoubleArray ra = CallChecker.varInit(new ResizableDoubleArray(20), "ra", 80, 2998, 3348);
        while (qi < 1) {
            qi += (FastMath.pow(LN2, i)) / (ArithmeticUtils.factorial(i));
            CallChecker.varAssign(qi, "qi", 83, 3388, 3445);
            if (CallChecker.beforeDeref(ra, ResizableDoubleArray.class, 84, 3459, 3460)) {
                CallChecker.isCalled(ra, ResizableDoubleArray.class, 84, 3459, 3460).addElement(qi);
            }
            ++i;
        } 
        EXPONENTIAL_SA_QI = CallChecker.isCalled(ra, ResizableDoubleArray.class, 88, 3534, 3535).getElements();
        CallChecker.varAssign(EXPONENTIAL_SA_QI, "ExponentialDistribution.EXPONENTIAL_SA_QI", 88, 3514, 3550);
    }

    public ExponentialDistribution(double mean) {
        this(mean, ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context495 = new ConstructorContext(ExponentialDistribution.class, 95, 3563, 3793);
        try {
        } finally {
            _bcornu_methode_context495.methodEnd();
        }
    }

    public ExponentialDistribution(double mean, double inverseCumAccuracy) {
        this(new Well19937c(), mean, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context496 = new ConstructorContext(ExponentialDistribution.class, 109, 3800, 4323);
        try {
        } finally {
            _bcornu_methode_context496.methodEnd();
        }
    }

    public ExponentialDistribution(RandomGenerator rng, double mean, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context497 = new ConstructorContext(ExponentialDistribution.class, 124, 4330, 5170);
        try {
            if (mean <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.MEAN, mean);
            }
            this.mean = mean;
            CallChecker.varAssign(this.mean, "this.mean", 133, 5095, 5111);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 134, 5121, 5164);
        } finally {
            _bcornu_methode_context497.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context2253 = new MethodContext(double.class, 142, 5177, 5300);
        try {
            CallChecker.varInit(this, "this", 142, 5177, 5300);
            CallChecker.varInit(this.random, "random", 142, 5177, 5300);
            CallChecker.varInit(this.randomData, "randomData", 142, 5177, 5300);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 142, 5177, 5300);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 142, 5177, 5300);
            CallChecker.varInit(this.mean, "mean", 142, 5177, 5300);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 142, 5177, 5300);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 142, 5177, 5300);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 142, 5177, 5300);
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2253.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context2254 = new MethodContext(double.class, 147, 5307, 5470);
        try {
            CallChecker.varInit(this, "this", 147, 5307, 5470);
            CallChecker.varInit(x, "x", 147, 5307, 5470);
            CallChecker.varInit(this.random, "random", 147, 5307, 5470);
            CallChecker.varInit(this.randomData, "randomData", 147, 5307, 5470);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 147, 5307, 5470);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 147, 5307, 5470);
            CallChecker.varInit(this.mean, "mean", 147, 5307, 5470);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 147, 5307, 5470);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 147, 5307, 5470);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 147, 5307, 5470);
            if (x < 0) {
                return 0;
            }
            return (FastMath.exp(((-x) / (mean)))) / (mean);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2254.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context2255 = new MethodContext(double.class, 164, 5477, 5960);
        try {
            CallChecker.varInit(this, "this", 164, 5477, 5960);
            CallChecker.varInit(x, "x", 164, 5477, 5960);
            CallChecker.varInit(this.random, "random", 164, 5477, 5960);
            CallChecker.varInit(this.randomData, "randomData", 164, 5477, 5960);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 164, 5477, 5960);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 164, 5477, 5960);
            CallChecker.varInit(this.mean, "mean", 164, 5477, 5960);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 164, 5477, 5960);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 164, 5477, 5960);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 164, 5477, 5960);
            double ret = CallChecker.init(double.class);
            if (x <= 0.0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 167, 5849, 5858);
            }else {
                ret = 1.0 - (FastMath.exp(((-x) / (mean))));
                CallChecker.varAssign(ret, "ret", 169, 5889, 5924);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2255.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2256 = new MethodContext(double.class, 181, 5967, 6504);
        try {
            CallChecker.varInit(this, "this", 181, 5967, 6504);
            CallChecker.varInit(p, "p", 181, 5967, 6504);
            CallChecker.varInit(this.random, "random", 181, 5967, 6504);
            CallChecker.varInit(this.randomData, "randomData", 181, 5967, 6504);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 181, 5967, 6504);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 181, 5967, 6504);
            CallChecker.varInit(this.mean, "mean", 181, 5967, 6504);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 181, 5967, 6504);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 181, 5967, 6504);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 181, 5967, 6504);
            double ret = CallChecker.init(double.class);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0.0, 1.0);
            }else
                if (p == 1.0) {
                    ret = Double.POSITIVE_INFINITY;
                    CallChecker.varAssign(ret, "ret", 187, 6371, 6401);
                }else {
                    ret = (-(mean)) * (FastMath.log((1.0 - p)));
                    CallChecker.varAssign(ret, "ret", 189, 6432, 6467);
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2256.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context2257 = new MethodContext(double.class, 207, 6511, 7790);
        try {
            CallChecker.varInit(this, "this", 207, 6511, 7790);
            CallChecker.varInit(this.random, "random", 207, 6511, 7790);
            CallChecker.varInit(this.randomData, "randomData", 207, 6511, 7790);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 207, 6511, 7790);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 207, 6511, 7790);
            CallChecker.varInit(this.mean, "mean", 207, 6511, 7790);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 207, 6511, 7790);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 207, 6511, 7790);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 207, 6511, 7790);
            double a = CallChecker.varInit(((double) (0)), "a", 209, 6944, 6956);
            double u = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 210, 6977, 6982)) {
                u = CallChecker.isCalled(random, RandomGenerator.class, 210, 6977, 6982).nextDouble();
                CallChecker.varAssign(u, "u", 210, 6977, 6982);
            }
            while (u < 0.5) {
                if (CallChecker.beforeDeref(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 214, 7067, 7083)) {
                    a += CallChecker.isCalled(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 214, 7067, 7083)[0];
                    CallChecker.varAssign(a, "a", 214, 7062, 7087);
                }
                u *= 2;
                CallChecker.varAssign(u, "u", 215, 7101, 7107);
            } 
            u += u - 1;
            CallChecker.varAssign(u, "u", 219, 7162, 7172);
            if (CallChecker.beforeDeref(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 222, 7211, 7227)) {
                if (u <= (CallChecker.isCalled(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 222, 7211, 7227)[0])) {
                    return (mean) * (a + u);
                }
            }else
                throw new AbnormalExecutionError();
            
            int i = CallChecker.varInit(((int) (0)), "i", 227, 7308, 7317);
            double u2 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 228, 7396, 7401)) {
                u2 = CallChecker.isCalled(random, RandomGenerator.class, 228, 7396, 7401).nextDouble();
                CallChecker.varAssign(u2, "u2", 228, 7396, 7401);
            }
            double umin = CallChecker.varInit(((double) (u2)), "umin", 229, 7425, 7441);
            do {
                ++i;
                if (CallChecker.beforeDeref(random, RandomGenerator.class, 234, 7516, 7521)) {
                    u2 = CallChecker.isCalled(random, RandomGenerator.class, 234, 7516, 7521).nextDouble();
                    CallChecker.varAssign(u2, "u2", 234, 7511, 7535);
                }
                if (u2 < umin) {
                    umin = u2;
                    CallChecker.varAssign(umin, "umin", 237, 7583, 7592);
                }
            } while (u > (CallChecker.isCalled(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 241, 7653, 7669)[i]) );
            return (mean) * (a + (umin * (CallChecker.isCalled(ExponentialDistribution.EXPONENTIAL_SA_QI, double[].class, 243, 7763, 7779)[0])));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2257.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context2258 = new MethodContext(double.class, 248, 7797, 7926);
        try {
            CallChecker.varInit(this, "this", 248, 7797, 7926);
            CallChecker.varInit(this.random, "random", 248, 7797, 7926);
            CallChecker.varInit(this.randomData, "randomData", 248, 7797, 7926);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 248, 7797, 7926);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 248, 7797, 7926);
            CallChecker.varInit(this.mean, "mean", 248, 7797, 7926);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 248, 7797, 7926);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 248, 7797, 7926);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 248, 7797, 7926);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2258.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context2259 = new MethodContext(double.class, 257, 7933, 8102);
        try {
            CallChecker.varInit(this, "this", 257, 7933, 8102);
            CallChecker.varInit(this.random, "random", 257, 7933, 8102);
            CallChecker.varInit(this.randomData, "randomData", 257, 7933, 8102);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 257, 7933, 8102);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 257, 7933, 8102);
            CallChecker.varInit(this.mean, "mean", 257, 7933, 8102);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 257, 7933, 8102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 257, 7933, 8102);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 257, 7933, 8102);
            return getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2259.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context2260 = new MethodContext(double.class, 266, 8109, 8320);
        try {
            CallChecker.varInit(this, "this", 266, 8109, 8320);
            CallChecker.varInit(this.random, "random", 266, 8109, 8320);
            CallChecker.varInit(this.randomData, "randomData", 266, 8109, 8320);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 266, 8109, 8320);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 266, 8109, 8320);
            CallChecker.varInit(this.mean, "mean", 266, 8109, 8320);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 266, 8109, 8320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 266, 8109, 8320);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 266, 8109, 8320);
            final double m = CallChecker.varInit(((double) (getMean())), "m", 267, 8266, 8292);
            return m * m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2260.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context2261 = new MethodContext(double.class, 278, 8327, 8572);
        try {
            CallChecker.varInit(this, "this", 278, 8327, 8572);
            CallChecker.varInit(this.random, "random", 278, 8327, 8572);
            CallChecker.varInit(this.randomData, "randomData", 278, 8327, 8572);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 278, 8327, 8572);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 278, 8327, 8572);
            CallChecker.varInit(this.mean, "mean", 278, 8327, 8572);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 278, 8327, 8572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 278, 8327, 8572);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 278, 8327, 8572);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2261.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context2262 = new MethodContext(double.class, 290, 8579, 8893);
        try {
            CallChecker.varInit(this, "this", 290, 8579, 8893);
            CallChecker.varInit(this.random, "random", 290, 8579, 8893);
            CallChecker.varInit(this.randomData, "randomData", 290, 8579, 8893);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 290, 8579, 8893);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 290, 8579, 8893);
            CallChecker.varInit(this.mean, "mean", 290, 8579, 8893);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 290, 8579, 8893);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 290, 8579, 8893);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 290, 8579, 8893);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2262.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context2263 = new MethodContext(boolean.class, 295, 8900, 8998);
        try {
            CallChecker.varInit(this, "this", 295, 8900, 8998);
            CallChecker.varInit(this.random, "random", 295, 8900, 8998);
            CallChecker.varInit(this.randomData, "randomData", 295, 8900, 8998);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 295, 8900, 8998);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 295, 8900, 8998);
            CallChecker.varInit(this.mean, "mean", 295, 8900, 8998);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 295, 8900, 8998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 295, 8900, 8998);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 295, 8900, 8998);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2263.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context2264 = new MethodContext(boolean.class, 300, 9005, 9104);
        try {
            CallChecker.varInit(this, "this", 300, 9005, 9104);
            CallChecker.varInit(this.random, "random", 300, 9005, 9104);
            CallChecker.varInit(this.randomData, "randomData", 300, 9005, 9104);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 300, 9005, 9104);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 300, 9005, 9104);
            CallChecker.varInit(this.mean, "mean", 300, 9005, 9104);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 300, 9005, 9104);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 300, 9005, 9104);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 300, 9005, 9104);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2264.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context2265 = new MethodContext(boolean.class, 311, 9111, 9307);
        try {
            CallChecker.varInit(this, "this", 311, 9111, 9307);
            CallChecker.varInit(this.random, "random", 311, 9111, 9307);
            CallChecker.varInit(this.randomData, "randomData", 311, 9111, 9307);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 311, 9111, 9307);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 311, 9111, 9307);
            CallChecker.varInit(this.mean, "mean", 311, 9111, 9307);
            CallChecker.varInit(EXPONENTIAL_SA_QI, "org.apache.commons.math3.distribution.ExponentialDistribution.EXPONENTIAL_SA_QI", 311, 9111, 9307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ExponentialDistribution.serialVersionUID", 311, 9111, 9307);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 311, 9111, 9307);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2265.methodEnd();
        }
    }
}

