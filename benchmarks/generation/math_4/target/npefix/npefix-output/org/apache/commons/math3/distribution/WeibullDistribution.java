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
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

public class WeibullDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 8589540077390120676L;

    private final double shape;

    private final double scale;

    private final double solverAbsoluteAccuracy;

    private double numericalMean = Double.NaN;

    private boolean numericalMeanIsCalculated = false;

    private double numericalVariance = Double.NaN;

    private boolean numericalVarianceIsCalculated = false;

    public WeibullDistribution(double alpha, double beta) throws NotStrictlyPositiveException {
        this(alpha, beta, WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context444 = new ConstructorContext(WeibullDistribution.class, 71, 2790, 3252);
        try {
        } finally {
            _bcornu_methode_context444.methodEnd();
        }
    }

    public WeibullDistribution(double alpha, double beta, double inverseCumAccuracy) {
        this(new Well19937c(), alpha, beta, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context445 = new ConstructorContext(WeibullDistribution.class, 89, 3259, 3969);
        try {
        } finally {
            _bcornu_methode_context445.methodEnd();
        }
    }

    public WeibullDistribution(RandomGenerator rng, double alpha, double beta, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context446 = new ConstructorContext(WeibullDistribution.class, 107, 3976, 5141);
        try {
            if (alpha <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, alpha);
            }
            if (beta <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, beta);
            }
            scale = beta;
            CallChecker.varAssign(this.scale, "this.scale", 122, 5047, 5059);
            shape = alpha;
            CallChecker.varAssign(this.shape, "this.shape", 123, 5069, 5082);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 124, 5092, 5135);
        } finally {
            _bcornu_methode_context446.methodEnd();
        }
    }

    public double getShape() {
        MethodContext _bcornu_methode_context1885 = new MethodContext(double.class, 132, 5148, 5325);
        try {
            CallChecker.varInit(this, "this", 132, 5148, 5325);
            CallChecker.varInit(this.random, "random", 132, 5148, 5325);
            CallChecker.varInit(this.randomData, "randomData", 132, 5148, 5325);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 132, 5148, 5325);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 132, 5148, 5325);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 132, 5148, 5325);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 132, 5148, 5325);
            CallChecker.varInit(this.numericalMean, "numericalMean", 132, 5148, 5325);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 132, 5148, 5325);
            CallChecker.varInit(this.scale, "scale", 132, 5148, 5325);
            CallChecker.varInit(this.shape, "shape", 132, 5148, 5325);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 132, 5148, 5325);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 132, 5148, 5325);
            return shape;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1885.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context1886 = new MethodContext(double.class, 141, 5332, 5507);
        try {
            CallChecker.varInit(this, "this", 141, 5332, 5507);
            CallChecker.varInit(this.random, "random", 141, 5332, 5507);
            CallChecker.varInit(this.randomData, "randomData", 141, 5332, 5507);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 141, 5332, 5507);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 141, 5332, 5507);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 141, 5332, 5507);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 141, 5332, 5507);
            CallChecker.varInit(this.numericalMean, "numericalMean", 141, 5332, 5507);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 141, 5332, 5507);
            CallChecker.varInit(this.scale, "scale", 141, 5332, 5507);
            CallChecker.varInit(this.shape, "shape", 141, 5332, 5507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 141, 5332, 5507);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 141, 5332, 5507);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1886.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context1887 = new MethodContext(double.class, 146, 5514, 6034);
        try {
            CallChecker.varInit(this, "this", 146, 5514, 6034);
            CallChecker.varInit(x, "x", 146, 5514, 6034);
            CallChecker.varInit(this.random, "random", 146, 5514, 6034);
            CallChecker.varInit(this.randomData, "randomData", 146, 5514, 6034);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 146, 5514, 6034);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 146, 5514, 6034);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 146, 5514, 6034);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 146, 5514, 6034);
            CallChecker.varInit(this.numericalMean, "numericalMean", 146, 5514, 6034);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 146, 5514, 6034);
            CallChecker.varInit(this.scale, "scale", 146, 5514, 6034);
            CallChecker.varInit(this.shape, "shape", 146, 5514, 6034);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 146, 5514, 6034);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 146, 5514, 6034);
            if (x < 0) {
                return 0;
            }
            final double xscale = CallChecker.varInit(((double) (x / (this.scale))), "xscale", 151, 5635, 5666);
            final double xscalepow = CallChecker.varInit(((double) (FastMath.pow(xscale, ((this.shape) - 1)))), "xscalepow", 152, 5676, 5732);
            final double xscalepowshape = CallChecker.varInit(((double) (xscalepow * xscale)), "xscalepowshape", 159, 5743, 5951);
            return (((shape) / (scale)) * xscalepow) * (FastMath.exp((-xscalepowshape)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1887.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context1888 = new MethodContext(double.class, 165, 6041, 6303);
        try {
            CallChecker.varInit(this, "this", 165, 6041, 6303);
            CallChecker.varInit(x, "x", 165, 6041, 6303);
            CallChecker.varInit(this.random, "random", 165, 6041, 6303);
            CallChecker.varInit(this.randomData, "randomData", 165, 6041, 6303);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 165, 6041, 6303);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 165, 6041, 6303);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 165, 6041, 6303);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 165, 6041, 6303);
            CallChecker.varInit(this.numericalMean, "numericalMean", 165, 6041, 6303);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 165, 6041, 6303);
            CallChecker.varInit(this.scale, "scale", 165, 6041, 6303);
            CallChecker.varInit(this.shape, "shape", 165, 6041, 6303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 165, 6041, 6303);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 165, 6041, 6303);
            double ret = CallChecker.init(double.class);
            if (x <= 0.0) {
                ret = 0.0;
                CallChecker.varAssign(ret, "ret", 168, 6170, 6179);
            }else {
                ret = 1.0 - (FastMath.exp((-(FastMath.pow((x / (scale)), shape)))));
                CallChecker.varAssign(ret, "ret", 170, 6210, 6267);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1888.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(double p) {
        MethodContext _bcornu_methode_context1889 = new MethodContext(double.class, 182, 6310, 6897);
        try {
            CallChecker.varInit(this, "this", 182, 6310, 6897);
            CallChecker.varInit(p, "p", 182, 6310, 6897);
            CallChecker.varInit(this.random, "random", 182, 6310, 6897);
            CallChecker.varInit(this.randomData, "randomData", 182, 6310, 6897);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 182, 6310, 6897);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 182, 6310, 6897);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 182, 6310, 6897);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 182, 6310, 6897);
            CallChecker.varInit(this.numericalMean, "numericalMean", 182, 6310, 6897);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 182, 6310, 6897);
            CallChecker.varInit(this.scale, "scale", 182, 6310, 6897);
            CallChecker.varInit(this.shape, "shape", 182, 6310, 6897);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 182, 6310, 6897);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 182, 6310, 6897);
            double ret = CallChecker.init(double.class);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0.0, 1.0);
            }else
                if (p == 0) {
                    ret = 0.0;
                    CallChecker.varAssign(ret, "ret", 187, 6684, 6693);
                }else
                    if (p == 1) {
                        ret = Double.POSITIVE_INFINITY;
                        CallChecker.varAssign(ret, "ret", 189, 6737, 6767);
                    }else {
                        ret = (scale) * (FastMath.pow((-(FastMath.log((1.0 - p)))), (1.0 / (shape))));
                        CallChecker.varAssign(ret, "ret", 191, 6798, 6861);
                    }
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1889.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context1890 = new MethodContext(double.class, 204, 6904, 7210);
        try {
            CallChecker.varInit(this, "this", 204, 6904, 7210);
            CallChecker.varInit(this.random, "random", 204, 6904, 7210);
            CallChecker.varInit(this.randomData, "randomData", 204, 6904, 7210);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 204, 6904, 7210);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 204, 6904, 7210);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 204, 6904, 7210);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 204, 6904, 7210);
            CallChecker.varInit(this.numericalMean, "numericalMean", 204, 6904, 7210);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 204, 6904, 7210);
            CallChecker.varInit(this.scale, "scale", 204, 6904, 7210);
            CallChecker.varInit(this.shape, "shape", 204, 6904, 7210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 204, 6904, 7210);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 204, 6904, 7210);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1890.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1891 = new MethodContext(double.class, 214, 7217, 7593);
        try {
            CallChecker.varInit(this, "this", 214, 7217, 7593);
            CallChecker.varInit(this.random, "random", 214, 7217, 7593);
            CallChecker.varInit(this.randomData, "randomData", 214, 7217, 7593);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 214, 7217, 7593);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 214, 7217, 7593);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 214, 7217, 7593);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 214, 7217, 7593);
            CallChecker.varInit(this.numericalMean, "numericalMean", 214, 7217, 7593);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 214, 7217, 7593);
            CallChecker.varInit(this.scale, "scale", 214, 7217, 7593);
            CallChecker.varInit(this.shape, "shape", 214, 7217, 7593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 214, 7217, 7593);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 214, 7217, 7593);
            if (!(numericalMeanIsCalculated)) {
                numericalMean = calculateNumericalMean();
                CallChecker.varAssign(this.numericalMean, "this.numericalMean", 216, 7461, 7501);
                numericalMeanIsCalculated = true;
                CallChecker.varAssign(this.numericalMeanIsCalculated, "this.numericalMeanIsCalculated", 217, 7515, 7547);
            }
            return numericalMean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1891.methodEnd();
        }
    }

    protected double calculateNumericalMean() {
        MethodContext _bcornu_methode_context1892 = new MethodContext(double.class, 227, 7600, 7900);
        try {
            CallChecker.varInit(this, "this", 227, 7600, 7900);
            CallChecker.varInit(this.random, "random", 227, 7600, 7900);
            CallChecker.varInit(this.randomData, "randomData", 227, 7600, 7900);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 227, 7600, 7900);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 227, 7600, 7900);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 227, 7600, 7900);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 227, 7600, 7900);
            CallChecker.varInit(this.numericalMean, "numericalMean", 227, 7600, 7900);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 227, 7600, 7900);
            CallChecker.varInit(this.scale, "scale", 227, 7600, 7900);
            CallChecker.varInit(this.shape, "shape", 227, 7600, 7900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 227, 7600, 7900);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 227, 7600, 7900);
            final double sh = CallChecker.varInit(((double) (getShape())), "sh", 228, 7763, 7791);
            final double sc = CallChecker.varInit(((double) (getScale())), "sc", 229, 7801, 7829);
            return sc * (FastMath.exp(Gamma.logGamma((1 + (1 / sh)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1892.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1893 = new MethodContext(double.class, 240, 7907, 8321);
        try {
            CallChecker.varInit(this, "this", 240, 7907, 8321);
            CallChecker.varInit(this.random, "random", 240, 7907, 8321);
            CallChecker.varInit(this.randomData, "randomData", 240, 7907, 8321);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 240, 7907, 8321);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 240, 7907, 8321);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 240, 7907, 8321);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 240, 7907, 8321);
            CallChecker.varInit(this.numericalMean, "numericalMean", 240, 7907, 8321);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 240, 7907, 8321);
            CallChecker.varInit(this.scale, "scale", 240, 7907, 8321);
            CallChecker.varInit(this.shape, "shape", 240, 7907, 8321);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 240, 7907, 8321);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 240, 7907, 8321);
            if (!(numericalVarianceIsCalculated)) {
                numericalVariance = calculateNumericalVariance();
                CallChecker.varAssign(this.numericalVariance, "this.numericalVariance", 242, 8173, 8221);
                numericalVarianceIsCalculated = true;
                CallChecker.varAssign(this.numericalVarianceIsCalculated, "this.numericalVarianceIsCalculated", 243, 8235, 8271);
            }
            return numericalVariance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1893.methodEnd();
        }
    }

    protected double calculateNumericalVariance() {
        MethodContext _bcornu_methode_context1894 = new MethodContext(double.class, 253, 8328, 8720);
        try {
            CallChecker.varInit(this, "this", 253, 8328, 8720);
            CallChecker.varInit(this.random, "random", 253, 8328, 8720);
            CallChecker.varInit(this.randomData, "randomData", 253, 8328, 8720);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 253, 8328, 8720);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 253, 8328, 8720);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 253, 8328, 8720);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 253, 8328, 8720);
            CallChecker.varInit(this.numericalMean, "numericalMean", 253, 8328, 8720);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 253, 8328, 8720);
            CallChecker.varInit(this.scale, "scale", 253, 8328, 8720);
            CallChecker.varInit(this.shape, "shape", 253, 8328, 8720);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 253, 8328, 8720);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 253, 8328, 8720);
            final double sh = CallChecker.varInit(((double) (getShape())), "sh", 254, 8503, 8531);
            final double sc = CallChecker.varInit(((double) (getScale())), "sc", 255, 8541, 8569);
            final double mn = CallChecker.varInit(((double) (getNumericalMean())), "mn", 256, 8579, 8615);
            return ((sc * sc) * (FastMath.exp(Gamma.logGamma((1 + (2 / sh)))))) - (mn * mn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1894.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context1895 = new MethodContext(double.class, 269, 8727, 8968);
        try {
            CallChecker.varInit(this, "this", 269, 8727, 8968);
            CallChecker.varInit(this.random, "random", 269, 8727, 8968);
            CallChecker.varInit(this.randomData, "randomData", 269, 8727, 8968);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 269, 8727, 8968);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 269, 8727, 8968);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 269, 8727, 8968);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 269, 8727, 8968);
            CallChecker.varInit(this.numericalMean, "numericalMean", 269, 8727, 8968);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 269, 8727, 8968);
            CallChecker.varInit(this.scale, "scale", 269, 8727, 8968);
            CallChecker.varInit(this.shape, "shape", 269, 8727, 8968);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 269, 8727, 8968);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 269, 8727, 8968);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1895.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context1896 = new MethodContext(double.class, 282, 8975, 9300);
        try {
            CallChecker.varInit(this, "this", 282, 8975, 9300);
            CallChecker.varInit(this.random, "random", 282, 8975, 9300);
            CallChecker.varInit(this.randomData, "randomData", 282, 8975, 9300);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 282, 8975, 9300);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 282, 8975, 9300);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 282, 8975, 9300);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 282, 8975, 9300);
            CallChecker.varInit(this.numericalMean, "numericalMean", 282, 8975, 9300);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 282, 8975, 9300);
            CallChecker.varInit(this.scale, "scale", 282, 8975, 9300);
            CallChecker.varInit(this.shape, "shape", 282, 8975, 9300);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 282, 8975, 9300);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 282, 8975, 9300);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1896.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context1897 = new MethodContext(boolean.class, 287, 9307, 9405);
        try {
            CallChecker.varInit(this, "this", 287, 9307, 9405);
            CallChecker.varInit(this.random, "random", 287, 9307, 9405);
            CallChecker.varInit(this.randomData, "randomData", 287, 9307, 9405);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 287, 9307, 9405);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 287, 9307, 9405);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 287, 9307, 9405);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 287, 9307, 9405);
            CallChecker.varInit(this.numericalMean, "numericalMean", 287, 9307, 9405);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 287, 9307, 9405);
            CallChecker.varInit(this.scale, "scale", 287, 9307, 9405);
            CallChecker.varInit(this.shape, "shape", 287, 9307, 9405);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 287, 9307, 9405);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 287, 9307, 9405);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1897.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context1898 = new MethodContext(boolean.class, 292, 9412, 9511);
        try {
            CallChecker.varInit(this, "this", 292, 9412, 9511);
            CallChecker.varInit(this.random, "random", 292, 9412, 9511);
            CallChecker.varInit(this.randomData, "randomData", 292, 9412, 9511);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 292, 9412, 9511);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 292, 9412, 9511);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 292, 9412, 9511);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 292, 9412, 9511);
            CallChecker.varInit(this.numericalMean, "numericalMean", 292, 9412, 9511);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 292, 9412, 9511);
            CallChecker.varInit(this.scale, "scale", 292, 9412, 9511);
            CallChecker.varInit(this.shape, "shape", 292, 9412, 9511);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 292, 9412, 9511);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 292, 9412, 9511);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1898.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1899 = new MethodContext(boolean.class, 303, 9518, 9714);
        try {
            CallChecker.varInit(this, "this", 303, 9518, 9714);
            CallChecker.varInit(this.random, "random", 303, 9518, 9714);
            CallChecker.varInit(this.randomData, "randomData", 303, 9518, 9714);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 303, 9518, 9714);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 303, 9518, 9714);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 303, 9518, 9714);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 303, 9518, 9714);
            CallChecker.varInit(this.numericalMean, "numericalMean", 303, 9518, 9714);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 303, 9518, 9714);
            CallChecker.varInit(this.scale, "scale", 303, 9518, 9714);
            CallChecker.varInit(this.shape, "shape", 303, 9518, 9714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.WeibullDistribution.serialVersionUID", 303, 9518, 9714);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 303, 9518, 9714);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1899.methodEnd();
        }
    }
}

