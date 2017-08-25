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
import org.apache.commons.math3.util.FastMath;

public class CauchyDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 8589540077390120676L;

    private final double median;

    private final double scale;

    private final double solverAbsoluteAccuracy;

    public CauchyDistribution() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context597 = new ConstructorContext(CauchyDistribution.class, 53, 2140, 2308);
        try {
        } finally {
            _bcornu_methode_context597.methodEnd();
        }
    }

    public CauchyDistribution(double median, double scale) {
        this(median, scale, CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context598 = new ConstructorContext(CauchyDistribution.class, 63, 2315, 2644);
        try {
        } finally {
            _bcornu_methode_context598.methodEnd();
        }
    }

    public CauchyDistribution(double median, double scale, double inverseCumAccuracy) {
        this(new Well19937c(), median, scale, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context599 = new ConstructorContext(CauchyDistribution.class, 78, 2651, 3297);
        try {
        } finally {
            _bcornu_methode_context599.methodEnd();
        }
    }

    public CauchyDistribution(RandomGenerator rng, double median, double scale, double inverseCumAccuracy) {
        super(rng);
        ConstructorContext _bcornu_methode_context600 = new ConstructorContext(CauchyDistribution.class, 95, 3304, 4224);
        try {
            if (scale <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, scale);
            }
            this.scale = scale;
            CallChecker.varAssign(this.scale, "this.scale", 103, 4117, 4135);
            this.median = median;
            CallChecker.varAssign(this.median, "this.median", 104, 4145, 4165);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 105, 4175, 4218);
        } finally {
            _bcornu_methode_context600.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context2701 = new MethodContext(double.class, 109, 4231, 4382);
        try {
            CallChecker.varInit(this, "this", 109, 4231, 4382);
            CallChecker.varInit(x, "x", 109, 4231, 4382);
            CallChecker.varInit(this.random, "random", 109, 4231, 4382);
            CallChecker.varInit(this.randomData, "randomData", 109, 4231, 4382);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 109, 4231, 4382);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 109, 4231, 4382);
            CallChecker.varInit(this.scale, "scale", 109, 4231, 4382);
            CallChecker.varInit(this.median, "median", 109, 4231, 4382);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 109, 4231, 4382);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 109, 4231, 4382);
            return 0.5 + ((FastMath.atan(((x - (median)) / (scale)))) / (FastMath.PI));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2701.methodEnd();
        }
    }

    public double getMedian() {
        MethodContext _bcornu_methode_context2702 = new MethodContext(double.class, 118, 4389, 4542);
        try {
            CallChecker.varInit(this, "this", 118, 4389, 4542);
            CallChecker.varInit(this.random, "random", 118, 4389, 4542);
            CallChecker.varInit(this.randomData, "randomData", 118, 4389, 4542);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 118, 4389, 4542);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 118, 4389, 4542);
            CallChecker.varInit(this.scale, "scale", 118, 4389, 4542);
            CallChecker.varInit(this.median, "median", 118, 4389, 4542);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 118, 4389, 4542);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 118, 4389, 4542);
            return median;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2702.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context2703 = new MethodContext(double.class, 127, 4549, 4718);
        try {
            CallChecker.varInit(this, "this", 127, 4549, 4718);
            CallChecker.varInit(this.random, "random", 127, 4549, 4718);
            CallChecker.varInit(this.randomData, "randomData", 127, 4549, 4718);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 127, 4549, 4718);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 127, 4549, 4718);
            CallChecker.varInit(this.scale, "scale", 127, 4549, 4718);
            CallChecker.varInit(this.median, "median", 127, 4549, 4718);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 127, 4549, 4718);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 127, 4549, 4718);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2703.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context2704 = new MethodContext(double.class, 132, 4725, 4901);
        try {
            CallChecker.varInit(this, "this", 132, 4725, 4901);
            CallChecker.varInit(x, "x", 132, 4725, 4901);
            CallChecker.varInit(this.random, "random", 132, 4725, 4901);
            CallChecker.varInit(this.randomData, "randomData", 132, 4725, 4901);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 132, 4725, 4901);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 132, 4725, 4901);
            CallChecker.varInit(this.scale, "scale", 132, 4725, 4901);
            CallChecker.varInit(this.median, "median", 132, 4725, 4901);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 132, 4725, 4901);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 132, 4725, 4901);
            final double dev = CallChecker.varInit(((double) (x - (this.median))), "dev", 133, 4792, 4821);
            return (1 / (FastMath.PI)) * ((scale) / ((dev * dev) + ((scale) * (scale))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2704.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2705 = new MethodContext(double.class, 144, 4908, 5554);
        try {
            CallChecker.varInit(this, "this", 144, 4908, 5554);
            CallChecker.varInit(p, "p", 144, 4908, 5554);
            CallChecker.varInit(this.random, "random", 144, 4908, 5554);
            CallChecker.varInit(this.randomData, "randomData", 144, 4908, 5554);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 144, 4908, 5554);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 144, 4908, 5554);
            CallChecker.varInit(this.scale, "scale", 144, 4908, 5554);
            CallChecker.varInit(this.median, "median", 144, 4908, 5554);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 144, 4908, 5554);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 144, 4908, 5554);
            double ret = CallChecker.init(double.class);
            if ((p < 0) || (p > 1)) {
                throw new OutOfRangeException(p, 0, 1);
            }else
                if (p == 0) {
                    ret = Double.NEGATIVE_INFINITY;
                    CallChecker.varAssign(ret, "ret", 149, 5324, 5354);
                }else
                    if (p == 1) {
                        ret = Double.POSITIVE_INFINITY;
                        CallChecker.varAssign(ret, "ret", 151, 5398, 5428);
                    }else {
                        ret = (median) + ((scale) * (FastMath.tan(((FastMath.PI) * (p - 0.5)))));
                        CallChecker.varAssign(ret, "ret", 153, 5459, 5518);
                    }
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2705.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context2706 = new MethodContext(double.class, 160, 5561, 5690);
        try {
            CallChecker.varInit(this, "this", 160, 5561, 5690);
            CallChecker.varInit(this.random, "random", 160, 5561, 5690);
            CallChecker.varInit(this.randomData, "randomData", 160, 5561, 5690);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 160, 5561, 5690);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 160, 5561, 5690);
            CallChecker.varInit(this.scale, "scale", 160, 5561, 5690);
            CallChecker.varInit(this.median, "median", 160, 5561, 5690);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 160, 5561, 5690);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 160, 5561, 5690);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2706.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context2707 = new MethodContext(double.class, 171, 5697, 5916);
        try {
            CallChecker.varInit(this, "this", 171, 5697, 5916);
            CallChecker.varInit(this.random, "random", 171, 5697, 5916);
            CallChecker.varInit(this.randomData, "randomData", 171, 5697, 5916);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 171, 5697, 5916);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 171, 5697, 5916);
            CallChecker.varInit(this.scale, "scale", 171, 5697, 5916);
            CallChecker.varInit(this.median, "median", 171, 5697, 5916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 171, 5697, 5916);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 171, 5697, 5916);
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2707.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context2708 = new MethodContext(double.class, 182, 5923, 6154);
        try {
            CallChecker.varInit(this, "this", 182, 5923, 6154);
            CallChecker.varInit(this.random, "random", 182, 5923, 6154);
            CallChecker.varInit(this.randomData, "randomData", 182, 5923, 6154);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 182, 5923, 6154);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 182, 5923, 6154);
            CallChecker.varInit(this.scale, "scale", 182, 5923, 6154);
            CallChecker.varInit(this.median, "median", 182, 5923, 6154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 182, 5923, 6154);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 182, 5923, 6154);
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2708.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context2709 = new MethodContext(double.class, 194, 6161, 6471);
        try {
            CallChecker.varInit(this, "this", 194, 6161, 6471);
            CallChecker.varInit(this.random, "random", 194, 6161, 6471);
            CallChecker.varInit(this.randomData, "randomData", 194, 6161, 6471);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 194, 6161, 6471);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 194, 6161, 6471);
            CallChecker.varInit(this.scale, "scale", 194, 6161, 6471);
            CallChecker.varInit(this.median, "median", 194, 6161, 6471);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 194, 6161, 6471);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 194, 6161, 6471);
            return Double.NEGATIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2709.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context2710 = new MethodContext(double.class, 206, 6478, 6788);
        try {
            CallChecker.varInit(this, "this", 206, 6478, 6788);
            CallChecker.varInit(this.random, "random", 206, 6478, 6788);
            CallChecker.varInit(this.randomData, "randomData", 206, 6478, 6788);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 206, 6478, 6788);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 206, 6478, 6788);
            CallChecker.varInit(this.scale, "scale", 206, 6478, 6788);
            CallChecker.varInit(this.median, "median", 206, 6478, 6788);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 206, 6478, 6788);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 206, 6478, 6788);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2710.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context2711 = new MethodContext(boolean.class, 211, 6795, 6894);
        try {
            CallChecker.varInit(this, "this", 211, 6795, 6894);
            CallChecker.varInit(this.random, "random", 211, 6795, 6894);
            CallChecker.varInit(this.randomData, "randomData", 211, 6795, 6894);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 211, 6795, 6894);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 211, 6795, 6894);
            CallChecker.varInit(this.scale, "scale", 211, 6795, 6894);
            CallChecker.varInit(this.median, "median", 211, 6795, 6894);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 211, 6795, 6894);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 211, 6795, 6894);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2711.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context2712 = new MethodContext(boolean.class, 216, 6901, 7000);
        try {
            CallChecker.varInit(this, "this", 216, 6901, 7000);
            CallChecker.varInit(this.random, "random", 216, 6901, 7000);
            CallChecker.varInit(this.randomData, "randomData", 216, 6901, 7000);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 216, 6901, 7000);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 216, 6901, 7000);
            CallChecker.varInit(this.scale, "scale", 216, 6901, 7000);
            CallChecker.varInit(this.median, "median", 216, 6901, 7000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 216, 6901, 7000);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 216, 6901, 7000);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2712.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context2713 = new MethodContext(boolean.class, 227, 7007, 7203);
        try {
            CallChecker.varInit(this, "this", 227, 7007, 7203);
            CallChecker.varInit(this.random, "random", 227, 7007, 7203);
            CallChecker.varInit(this.randomData, "randomData", 227, 7007, 7203);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 227, 7007, 7203);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 227, 7007, 7203);
            CallChecker.varInit(this.scale, "scale", 227, 7007, 7203);
            CallChecker.varInit(this.median, "median", 227, 7007, 7203);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.CauchyDistribution.serialVersionUID", 227, 7007, 7203);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 227, 7007, 7203);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2713.methodEnd();
        }
    }
}

