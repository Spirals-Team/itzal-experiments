package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

public class LogNormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 20120112;

    private static final double SQRT2PI = FastMath.sqrt((2 * (FastMath.PI)));

    private static final double SQRT2 = FastMath.sqrt(2.0);

    private final double scale;

    private final double shape;

    private final double solverAbsoluteAccuracy;

    public LogNormalDistribution() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context952 = new ConstructorContext(LogNormalDistribution.class, 85, 3011, 3434);
        try {
        } finally {
            _bcornu_methode_context952.methodEnd();
        }
    }

    public LogNormalDistribution(double scale, double shape) throws NotStrictlyPositiveException {
        this(scale, shape, LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context953 = new ConstructorContext(LogNormalDistribution.class, 96, 3441, 3900);
        try {
        } finally {
            _bcornu_methode_context953.methodEnd();
        }
    }

    public LogNormalDistribution(double scale, double shape, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), scale, shape, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context954 = new ConstructorContext(LogNormalDistribution.class, 110, 3907, 4519);
        try {
        } finally {
            _bcornu_methode_context954.methodEnd();
        }
    }

    public LogNormalDistribution(RandomGenerator rng, double scale, double shape, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context955 = new ConstructorContext(LogNormalDistribution.class, 125, 4526, 5418);
        try {
            if (shape <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, shape);
            }
            this.scale = scale;
            CallChecker.varAssign(this.scale, "this.scale", 136, 5308, 5326);
            this.shape = shape;
            CallChecker.varAssign(this.shape, "this.shape", 137, 5336, 5354);
            this.solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 138, 5364, 5412);
        } finally {
            _bcornu_methode_context955.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context4286 = new MethodContext(double.class, 146, 5425, 5593);
        try {
            CallChecker.varInit(this, "this", 146, 5425, 5593);
            CallChecker.varInit(this.random, "random", 146, 5425, 5593);
            CallChecker.varInit(this.randomData, "randomData", 146, 5425, 5593);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 146, 5425, 5593);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 146, 5425, 5593);
            CallChecker.varInit(this.shape, "shape", 146, 5425, 5593);
            CallChecker.varInit(this.scale, "scale", 146, 5425, 5593);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 146, 5425, 5593);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 146, 5425, 5593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 146, 5425, 5593);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 146, 5425, 5593);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4286.methodEnd();
        }
    }

    public double getShape() {
        MethodContext _bcornu_methode_context4287 = new MethodContext(double.class, 155, 5600, 5768);
        try {
            CallChecker.varInit(this, "this", 155, 5600, 5768);
            CallChecker.varInit(this.random, "random", 155, 5600, 5768);
            CallChecker.varInit(this.randomData, "randomData", 155, 5600, 5768);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 155, 5600, 5768);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 155, 5600, 5768);
            CallChecker.varInit(this.shape, "shape", 155, 5600, 5768);
            CallChecker.varInit(this.scale, "scale", 155, 5600, 5768);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 155, 5600, 5768);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 155, 5600, 5768);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 155, 5600, 5768);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 155, 5600, 5768);
            return shape;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4287.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context4288 = new MethodContext(double.class, 170, 5775, 6335);
        try {
            CallChecker.varInit(this, "this", 170, 5775, 6335);
            CallChecker.varInit(x, "x", 170, 5775, 6335);
            CallChecker.varInit(this.random, "random", 170, 5775, 6335);
            CallChecker.varInit(this.randomData, "randomData", 170, 5775, 6335);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 170, 5775, 6335);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 170, 5775, 6335);
            CallChecker.varInit(this.shape, "shape", 170, 5775, 6335);
            CallChecker.varInit(this.scale, "scale", 170, 5775, 6335);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 170, 5775, 6335);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 170, 5775, 6335);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 170, 5775, 6335);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 170, 5775, 6335);
            if (x <= 0) {
                return 0;
            }
            final double x0 = CallChecker.varInit(((double) ((FastMath.log(x)) - (this.scale))), "x0", 174, 6181, 6222);
            final double x1 = CallChecker.varInit(((double) (x0 / (this.shape))), "x1", 175, 6232, 6260);
            return (FastMath.exp((((-0.5) * x1) * x1))) / (((shape) * (LogNormalDistribution.SQRT2PI)) * x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4288.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context4289 = new MethodContext(double.class, 194, 6342, 7283);
        try {
            CallChecker.varInit(this, "this", 194, 6342, 7283);
            CallChecker.varInit(x, "x", 194, 6342, 7283);
            CallChecker.varInit(this.random, "random", 194, 6342, 7283);
            CallChecker.varInit(this.randomData, "randomData", 194, 6342, 7283);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 194, 6342, 7283);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 194, 6342, 7283);
            CallChecker.varInit(this.shape, "shape", 194, 6342, 7283);
            CallChecker.varInit(this.scale, "scale", 194, 6342, 7283);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 194, 6342, 7283);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 194, 6342, 7283);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 194, 6342, 7283);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 194, 6342, 7283);
            if (x <= 0) {
                return 0;
            }
            final double dev = CallChecker.varInit(((double) ((FastMath.log(x)) - (this.scale))), "dev", 198, 7078, 7120);
            if ((FastMath.abs(dev)) > (40 * (shape))) {
                if (dev < 0) {
                    return 0.0;
                }else {
                    return 1.0;
                }
            }
            return 0.5 + (0.5 * (Erf.erf((dev / ((shape) * (LogNormalDistribution.SQRT2))))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4289.methodEnd();
        }
    }

    @Override
    @Deprecated
    public double cumulativeProbability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4290 = new MethodContext(double.class, 211, 7290, 7585);
        try {
            CallChecker.varInit(this, "this", 211, 7290, 7585);
            CallChecker.varInit(x1, "x1", 211, 7290, 7585);
            CallChecker.varInit(x0, "x0", 211, 7290, 7585);
            CallChecker.varInit(this.random, "random", 211, 7290, 7585);
            CallChecker.varInit(this.randomData, "randomData", 211, 7290, 7585);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 211, 7290, 7585);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 211, 7290, 7585);
            CallChecker.varInit(this.shape, "shape", 211, 7290, 7585);
            CallChecker.varInit(this.scale, "scale", 211, 7290, 7585);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 211, 7290, 7585);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 211, 7290, 7585);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 211, 7290, 7585);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 211, 7290, 7585);
            return probability(x0, x1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4290.methodEnd();
        }
    }

    @Override
    public double probability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4291 = new MethodContext(double.class, 218, 7592, 8250);
        try {
            CallChecker.varInit(this, "this", 218, 7592, 8250);
            CallChecker.varInit(x1, "x1", 218, 7592, 8250);
            CallChecker.varInit(x0, "x0", 218, 7592, 8250);
            CallChecker.varInit(this.random, "random", 218, 7592, 8250);
            CallChecker.varInit(this.randomData, "randomData", 218, 7592, 8250);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 218, 7592, 8250);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 218, 7592, 8250);
            CallChecker.varInit(this.shape, "shape", 218, 7592, 8250);
            CallChecker.varInit(this.scale, "scale", 218, 7592, 8250);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 218, 7592, 8250);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 218, 7592, 8250);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 218, 7592, 8250);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 218, 7592, 8250);
            if (x0 > x1) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, x0, x1, true);
            }
            if ((x0 <= 0) || (x1 <= 0)) {
                return super.probability(x0, x1);
            }
            final double denom = CallChecker.varInit(((double) ((this.shape) * (LogNormalDistribution.SQRT2))), "denom", 228, 8048, 8082);
            final double v0 = CallChecker.varInit(((double) (((FastMath.log(x0)) - (this.scale)) / denom)), "v0", 229, 8092, 8144);
            final double v1 = CallChecker.varInit(((double) (((FastMath.log(x1)) - (this.scale)) / denom)), "v1", 230, 8154, 8206);
            return 0.5 * (Erf.erf(v0, v1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4291.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context4292 = new MethodContext(double.class, 236, 8257, 8386);
        try {
            CallChecker.varInit(this, "this", 236, 8257, 8386);
            CallChecker.varInit(this.random, "random", 236, 8257, 8386);
            CallChecker.varInit(this.randomData, "randomData", 236, 8257, 8386);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 236, 8257, 8386);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 236, 8257, 8386);
            CallChecker.varInit(this.shape, "shape", 236, 8257, 8386);
            CallChecker.varInit(this.scale, "scale", 236, 8257, 8386);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 236, 8257, 8386);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 236, 8257, 8386);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 236, 8257, 8386);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 236, 8257, 8386);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4292.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context4293 = new MethodContext(double.class, 246, 8393, 8645);
        try {
            CallChecker.varInit(this, "this", 246, 8393, 8645);
            CallChecker.varInit(this.random, "random", 246, 8393, 8645);
            CallChecker.varInit(this.randomData, "randomData", 246, 8393, 8645);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 246, 8393, 8645);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 246, 8393, 8645);
            CallChecker.varInit(this.shape, "shape", 246, 8393, 8645);
            CallChecker.varInit(this.scale, "scale", 246, 8393, 8645);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 246, 8393, 8645);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 246, 8393, 8645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 246, 8393, 8645);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 246, 8393, 8645);
            double s = CallChecker.varInit(((double) (this.shape)), "s", 247, 8573, 8589);
            return FastMath.exp(((scale) + ((s * s) / 2)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4293.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context4294 = new MethodContext(double.class, 257, 8652, 8988);
        try {
            CallChecker.varInit(this, "this", 257, 8652, 8988);
            CallChecker.varInit(this.random, "random", 257, 8652, 8988);
            CallChecker.varInit(this.randomData, "randomData", 257, 8652, 8988);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 257, 8652, 8988);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 257, 8652, 8988);
            CallChecker.varInit(this.shape, "shape", 257, 8652, 8988);
            CallChecker.varInit(this.scale, "scale", 257, 8652, 8988);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 257, 8652, 8988);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 257, 8652, 8988);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 257, 8652, 8988);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 257, 8652, 8988);
            final double s = CallChecker.varInit(((double) (this.shape)), "s", 258, 8857, 8879);
            final double ss = CallChecker.varInit(((double) (s * s)), "ss", 259, 8889, 8912);
            return ((FastMath.exp(ss)) - 1) * (FastMath.exp(((2 * (scale)) + ss)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4294.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context4295 = new MethodContext(double.class, 270, 8995, 9236);
        try {
            CallChecker.varInit(this, "this", 270, 8995, 9236);
            CallChecker.varInit(this.random, "random", 270, 8995, 9236);
            CallChecker.varInit(this.randomData, "randomData", 270, 8995, 9236);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 270, 8995, 9236);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 270, 8995, 9236);
            CallChecker.varInit(this.shape, "shape", 270, 8995, 9236);
            CallChecker.varInit(this.scale, "scale", 270, 8995, 9236);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 270, 8995, 9236);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 270, 8995, 9236);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 270, 8995, 9236);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 270, 8995, 9236);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4295.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context4296 = new MethodContext(double.class, 283, 9243, 9568);
        try {
            CallChecker.varInit(this, "this", 283, 9243, 9568);
            CallChecker.varInit(this.random, "random", 283, 9243, 9568);
            CallChecker.varInit(this.randomData, "randomData", 283, 9243, 9568);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 283, 9243, 9568);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 283, 9243, 9568);
            CallChecker.varInit(this.shape, "shape", 283, 9243, 9568);
            CallChecker.varInit(this.scale, "scale", 283, 9243, 9568);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 283, 9243, 9568);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 283, 9243, 9568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 283, 9243, 9568);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 283, 9243, 9568);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4296.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context4297 = new MethodContext(boolean.class, 288, 9575, 9673);
        try {
            CallChecker.varInit(this, "this", 288, 9575, 9673);
            CallChecker.varInit(this.random, "random", 288, 9575, 9673);
            CallChecker.varInit(this.randomData, "randomData", 288, 9575, 9673);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 288, 9575, 9673);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 288, 9575, 9673);
            CallChecker.varInit(this.shape, "shape", 288, 9575, 9673);
            CallChecker.varInit(this.scale, "scale", 288, 9575, 9673);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 288, 9575, 9673);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 288, 9575, 9673);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 288, 9575, 9673);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 288, 9575, 9673);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4297.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context4298 = new MethodContext(boolean.class, 293, 9680, 9779);
        try {
            CallChecker.varInit(this, "this", 293, 9680, 9779);
            CallChecker.varInit(this.random, "random", 293, 9680, 9779);
            CallChecker.varInit(this.randomData, "randomData", 293, 9680, 9779);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 293, 9680, 9779);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 293, 9680, 9779);
            CallChecker.varInit(this.shape, "shape", 293, 9680, 9779);
            CallChecker.varInit(this.scale, "scale", 293, 9680, 9779);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 293, 9680, 9779);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 293, 9680, 9779);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 293, 9680, 9779);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 293, 9680, 9779);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4298.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context4299 = new MethodContext(boolean.class, 304, 9786, 9982);
        try {
            CallChecker.varInit(this, "this", 304, 9786, 9982);
            CallChecker.varInit(this.random, "random", 304, 9786, 9982);
            CallChecker.varInit(this.randomData, "randomData", 304, 9786, 9982);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 304, 9786, 9982);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 304, 9786, 9982);
            CallChecker.varInit(this.shape, "shape", 304, 9786, 9982);
            CallChecker.varInit(this.scale, "scale", 304, 9786, 9982);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 304, 9786, 9982);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 304, 9786, 9982);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 304, 9786, 9982);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 304, 9786, 9982);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4299.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context4300 = new MethodContext(double.class, 310, 9989, 10154);
        try {
            CallChecker.varInit(this, "this", 310, 9989, 10154);
            CallChecker.varInit(this.random, "random", 310, 9989, 10154);
            CallChecker.varInit(this.randomData, "randomData", 310, 9989, 10154);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 310, 9989, 10154);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 310, 9989, 10154);
            CallChecker.varInit(this.shape, "shape", 310, 9989, 10154);
            CallChecker.varInit(this.scale, "scale", 310, 9989, 10154);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2", 310, 9989, 10154);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.LogNormalDistribution.SQRT2PI", 310, 9989, 10154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.LogNormalDistribution.serialVersionUID", 310, 9989, 10154);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.LogNormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 310, 9989, 10154);
            final double n = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 311, 10079, 10084).nextGaussian())), "n", 311, 10062, 10100);
            return FastMath.exp(((scale) + ((shape) * n)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4300.methodEnd();
        }
    }
}

