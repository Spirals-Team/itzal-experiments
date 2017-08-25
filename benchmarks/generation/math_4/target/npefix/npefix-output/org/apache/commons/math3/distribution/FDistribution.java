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
import org.apache.commons.math3.util.FastMath;

public class FDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = -8516354193418641566L;

    private final double numeratorDegreesOfFreedom;

    private final double denominatorDegreesOfFreedom;

    private final double solverAbsoluteAccuracy;

    private double numericalVariance = Double.NaN;

    private boolean numericalVarianceIsCalculated = false;

    public FDistribution(double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom) throws NotStrictlyPositiveException {
        this(numeratorDegreesOfFreedom, denominatorDegreesOfFreedom, FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context698 = new ConstructorContext(FDistribution.class, 62, 2309, 2974);
        try {
        } finally {
            _bcornu_methode_context698.methodEnd();
        }
    }

    public FDistribution(double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), numeratorDegreesOfFreedom, denominatorDegreesOfFreedom, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context699 = new ConstructorContext(FDistribution.class, 82, 2981, 3882);
        try {
        } finally {
            _bcornu_methode_context699.methodEnd();
        }
    }

    public FDistribution(RandomGenerator rng, double numeratorDegreesOfFreedom, double denominatorDegreesOfFreedom, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context700 = new ConstructorContext(FDistribution.class, 103, 3889, 5336);
        try {
            if (numeratorDegreesOfFreedom <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, numeratorDegreesOfFreedom);
            }
            if (denominatorDegreesOfFreedom <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, denominatorDegreesOfFreedom);
            }
            this.numeratorDegreesOfFreedom = numeratorDegreesOfFreedom;
            CallChecker.varAssign(this.numeratorDegreesOfFreedom, "this.numeratorDegreesOfFreedom", 118, 5147, 5205);
            this.denominatorDegreesOfFreedom = denominatorDegreesOfFreedom;
            CallChecker.varAssign(this.denominatorDegreesOfFreedom, "this.denominatorDegreesOfFreedom", 119, 5215, 5277);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 120, 5287, 5330);
        } finally {
            _bcornu_methode_context700.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context3063 = new MethodContext(double.class, 128, 5343, 6097);
        try {
            CallChecker.varInit(this, "this", 128, 5343, 6097);
            CallChecker.varInit(x, "x", 128, 5343, 6097);
            CallChecker.varInit(this.random, "random", 128, 5343, 6097);
            CallChecker.varInit(this.randomData, "randomData", 128, 5343, 6097);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 128, 5343, 6097);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 128, 5343, 6097);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 128, 5343, 6097);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 128, 5343, 6097);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 128, 5343, 6097);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 128, 5343, 6097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 128, 5343, 6097);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 128, 5343, 6097);
            final double nhalf = CallChecker.varInit(((double) ((this.numeratorDegreesOfFreedom) / 2)), "nhalf", 129, 5447, 5497);
            final double mhalf = CallChecker.varInit(((double) ((this.denominatorDegreesOfFreedom) / 2)), "mhalf", 130, 5507, 5559);
            final double logx = CallChecker.varInit(((double) (FastMath.log(x))), "logx", 131, 5569, 5604);
            final double logn = CallChecker.varInit(((double) (FastMath.log(this.numeratorDegreesOfFreedom))), "logn", 132, 5614, 5673);
            final double logm = CallChecker.varInit(((double) (FastMath.log(this.denominatorDegreesOfFreedom))), "logm", 133, 5683, 5744);
            final double lognxm = CallChecker.varInit(((double) (FastMath.log((((this.numeratorDegreesOfFreedom) * x) + (this.denominatorDegreesOfFreedom))))), "lognxm", 134, 5754, 5892);
            return FastMath.exp((((((((nhalf * logn) + (nhalf * logx)) - logx) + (mhalf * logm)) - (nhalf * lognxm)) - (mhalf * lognxm)) - (Beta.logBeta(nhalf, mhalf))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3063.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context3064 = new MethodContext(double.class, 152, 6104, 6744);
        try {
            CallChecker.varInit(this, "this", 152, 6104, 6744);
            CallChecker.varInit(x, "x", 152, 6104, 6744);
            CallChecker.varInit(this.random, "random", 152, 6104, 6744);
            CallChecker.varInit(this.randomData, "randomData", 152, 6104, 6744);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 152, 6104, 6744);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 152, 6104, 6744);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 152, 6104, 6744);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 152, 6104, 6744);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 152, 6104, 6744);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 152, 6104, 6744);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 152, 6104, 6744);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 152, 6104, 6744);
            double ret = CallChecker.init(double.class);
            if (x <= 0) {
                ret = 0;
                CallChecker.varAssign(ret, "ret", 155, 6468, 6475);
            }else {
                double n = CallChecker.varInit(((double) (this.numeratorDegreesOfFreedom)), "n", 157, 6506, 6542);
                double m = CallChecker.varInit(((double) (this.denominatorDegreesOfFreedom)), "m", 158, 6556, 6594);
                ret = Beta.regularizedBeta(((n * x) / (m + (n * x))), (0.5 * n), (0.5 * m));
                CallChecker.varAssign(ret, "ret", 160, 6609, 6708);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3064.methodEnd();
        }
    }

    public double getNumeratorDegreesOfFreedom() {
        MethodContext _bcornu_methode_context3065 = new MethodContext(double.class, 172, 6751, 6964);
        try {
            CallChecker.varInit(this, "this", 172, 6751, 6964);
            CallChecker.varInit(this.random, "random", 172, 6751, 6964);
            CallChecker.varInit(this.randomData, "randomData", 172, 6751, 6964);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 172, 6751, 6964);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 172, 6751, 6964);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 172, 6751, 6964);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 172, 6751, 6964);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 172, 6751, 6964);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 172, 6751, 6964);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 172, 6751, 6964);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 172, 6751, 6964);
            return numeratorDegreesOfFreedom;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3065.methodEnd();
        }
    }

    public double getDenominatorDegreesOfFreedom() {
        MethodContext _bcornu_methode_context3066 = new MethodContext(double.class, 181, 6971, 7192);
        try {
            CallChecker.varInit(this, "this", 181, 6971, 7192);
            CallChecker.varInit(this.random, "random", 181, 6971, 7192);
            CallChecker.varInit(this.randomData, "randomData", 181, 6971, 7192);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 181, 6971, 7192);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 181, 6971, 7192);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 181, 6971, 7192);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 181, 6971, 7192);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 181, 6971, 7192);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 181, 6971, 7192);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 181, 6971, 7192);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 181, 6971, 7192);
            return denominatorDegreesOfFreedom;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3066.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context3067 = new MethodContext(double.class, 187, 7199, 7328);
        try {
            CallChecker.varInit(this, "this", 187, 7199, 7328);
            CallChecker.varInit(this.random, "random", 187, 7199, 7328);
            CallChecker.varInit(this.randomData, "randomData", 187, 7199, 7328);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 187, 7199, 7328);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 187, 7199, 7328);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 187, 7199, 7328);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 187, 7199, 7328);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 187, 7199, 7328);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 187, 7199, 7328);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 187, 7199, 7328);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 187, 7199, 7328);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3067.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context3068 = new MethodContext(double.class, 200, 7335, 7826);
        try {
            CallChecker.varInit(this, "this", 200, 7335, 7826);
            CallChecker.varInit(this.random, "random", 200, 7335, 7826);
            CallChecker.varInit(this.randomData, "randomData", 200, 7335, 7826);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 200, 7335, 7826);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 200, 7335, 7826);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 200, 7335, 7826);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 200, 7335, 7826);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 200, 7335, 7826);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 200, 7335, 7826);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 200, 7335, 7826);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 200, 7335, 7826);
            final double denominatorDF = CallChecker.varInit(((double) (getDenominatorDegreesOfFreedom())), "denominatorDF", 201, 7631, 7692);
            if (denominatorDF > 2) {
                return denominatorDF / (denominatorDF - 2);
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3068.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context3069 = new MethodContext(double.class, 223, 7833, 8465);
        try {
            CallChecker.varInit(this, "this", 223, 7833, 8465);
            CallChecker.varInit(this.random, "random", 223, 7833, 8465);
            CallChecker.varInit(this.randomData, "randomData", 223, 7833, 8465);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 223, 7833, 8465);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 223, 7833, 8465);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 223, 7833, 8465);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 223, 7833, 8465);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 223, 7833, 8465);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 223, 7833, 8465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 223, 7833, 8465);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 223, 7833, 8465);
            if (!(numericalVarianceIsCalculated)) {
                numericalVariance = calculateNumericalVariance();
                CallChecker.varAssign(this.numericalVariance, "this.numericalVariance", 225, 8317, 8365);
                numericalVarianceIsCalculated = true;
                CallChecker.varAssign(this.numericalVarianceIsCalculated, "this.numericalVarianceIsCalculated", 226, 8379, 8415);
            }
            return numericalVariance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3069.methodEnd();
        }
    }

    protected double calculateNumericalVariance() {
        MethodContext _bcornu_methode_context3070 = new MethodContext(double.class, 236, 8472, 9115);
        try {
            CallChecker.varInit(this, "this", 236, 8472, 9115);
            CallChecker.varInit(this.random, "random", 236, 8472, 9115);
            CallChecker.varInit(this.randomData, "randomData", 236, 8472, 9115);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 236, 8472, 9115);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 236, 8472, 9115);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 236, 8472, 9115);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 236, 8472, 9115);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 236, 8472, 9115);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 236, 8472, 9115);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 236, 8472, 9115);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 236, 8472, 9115);
            final double denominatorDF = CallChecker.varInit(((double) (getDenominatorDegreesOfFreedom())), "denominatorDF", 237, 8647, 8708);
            if (denominatorDF > 4) {
                final double numeratorDF = CallChecker.varInit(((double) (getNumeratorDegreesOfFreedom())), "numeratorDF", 240, 8756, 8813);
                final double denomDFMinusTwo = CallChecker.varInit(((double) (denominatorDF - 2)), "denomDFMinusTwo", 241, 8827, 8875);
                return ((2 * (denominatorDF * denominatorDF)) * ((numeratorDF + denominatorDF) - 2)) / ((numeratorDF * (denomDFMinusTwo * denomDFMinusTwo)) * (denominatorDF - 4));
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3070.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context3071 = new MethodContext(double.class, 257, 9122, 9363);
        try {
            CallChecker.varInit(this, "this", 257, 9122, 9363);
            CallChecker.varInit(this.random, "random", 257, 9122, 9363);
            CallChecker.varInit(this.randomData, "randomData", 257, 9122, 9363);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 257, 9122, 9363);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 257, 9122, 9363);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 257, 9122, 9363);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 257, 9122, 9363);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 257, 9122, 9363);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 257, 9122, 9363);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 257, 9122, 9363);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 257, 9122, 9363);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3071.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context3072 = new MethodContext(double.class, 269, 9370, 9680);
        try {
            CallChecker.varInit(this, "this", 269, 9370, 9680);
            CallChecker.varInit(this.random, "random", 269, 9370, 9680);
            CallChecker.varInit(this.randomData, "randomData", 269, 9370, 9680);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 269, 9370, 9680);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 269, 9370, 9680);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 269, 9370, 9680);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 269, 9370, 9680);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 269, 9370, 9680);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 269, 9370, 9680);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 269, 9370, 9680);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 269, 9370, 9680);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3072.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context3073 = new MethodContext(boolean.class, 274, 9687, 9786);
        try {
            CallChecker.varInit(this, "this", 274, 9687, 9786);
            CallChecker.varInit(this.random, "random", 274, 9687, 9786);
            CallChecker.varInit(this.randomData, "randomData", 274, 9687, 9786);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 274, 9687, 9786);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 274, 9687, 9786);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 274, 9687, 9786);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 274, 9687, 9786);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 274, 9687, 9786);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 274, 9687, 9786);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 274, 9687, 9786);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 274, 9687, 9786);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3073.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context3074 = new MethodContext(boolean.class, 279, 9793, 9892);
        try {
            CallChecker.varInit(this, "this", 279, 9793, 9892);
            CallChecker.varInit(this.random, "random", 279, 9793, 9892);
            CallChecker.varInit(this.randomData, "randomData", 279, 9793, 9892);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 279, 9793, 9892);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 279, 9793, 9892);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 279, 9793, 9892);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 279, 9793, 9892);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 279, 9793, 9892);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 279, 9793, 9892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 279, 9793, 9892);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 279, 9793, 9892);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3074.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context3075 = new MethodContext(boolean.class, 290, 9899, 10095);
        try {
            CallChecker.varInit(this, "this", 290, 9899, 10095);
            CallChecker.varInit(this.random, "random", 290, 9899, 10095);
            CallChecker.varInit(this.randomData, "randomData", 290, 9899, 10095);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 290, 9899, 10095);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 290, 9899, 10095);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 290, 9899, 10095);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 290, 9899, 10095);
            CallChecker.varInit(this.denominatorDegreesOfFreedom, "denominatorDegreesOfFreedom", 290, 9899, 10095);
            CallChecker.varInit(this.numeratorDegreesOfFreedom, "numeratorDegreesOfFreedom", 290, 9899, 10095);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.FDistribution.serialVersionUID", 290, 9899, 10095);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 290, 9899, 10095);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3075.methodEnd();
        }
    }
}

