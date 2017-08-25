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
import org.apache.commons.math3.util.FastMath;

public class ParetoDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 20130424;

    private final double scale;

    private final double shape;

    private final double solverAbsoluteAccuracy;

    public ParetoDistribution() {
        this(1, 1);
        ConstructorContext _bcornu_methode_context460 = new ConstructorContext(ParetoDistribution.class, 70, 2487, 2645);
        try {
        } finally {
            _bcornu_methode_context460.methodEnd();
        }
    }

    public ParetoDistribution(double scale, double shape) throws NotStrictlyPositiveException {
        this(scale, shape, ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context461 = new ConstructorContext(ParetoDistribution.class, 81, 2652, 3126);
        try {
        } finally {
            _bcornu_methode_context461.methodEnd();
        }
    }

    public ParetoDistribution(double scale, double shape, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), scale, shape, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context462 = new ConstructorContext(ParetoDistribution.class, 95, 3133, 3760);
        try {
        } finally {
            _bcornu_methode_context462.methodEnd();
        }
    }

    public ParetoDistribution(RandomGenerator rng, double scale, double shape, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context463 = new ConstructorContext(ParetoDistribution.class, 109, 3767, 4771);
        try {
            if (scale <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, scale);
            }
            if (shape <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, shape);
            }
            this.scale = scale;
            CallChecker.varAssign(this.scale, "this.scale", 124, 4661, 4679);
            this.shape = shape;
            CallChecker.varAssign(this.shape, "this.shape", 125, 4689, 4707);
            this.solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 126, 4717, 4765);
        } finally {
            _bcornu_methode_context463.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context2020 = new MethodContext(double.class, 134, 4778, 4946);
        try {
            CallChecker.varInit(this, "this", 134, 4778, 4946);
            CallChecker.varInit(this.random, "random", 134, 4778, 4946);
            CallChecker.varInit(this.randomData, "randomData", 134, 4778, 4946);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 134, 4778, 4946);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 134, 4778, 4946);
            CallChecker.varInit(this.shape, "shape", 134, 4778, 4946);
            CallChecker.varInit(this.scale, "scale", 134, 4778, 4946);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 134, 4778, 4946);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 134, 4778, 4946);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2020.methodEnd();
        }
    }

    public double getShape() {
        MethodContext _bcornu_methode_context2021 = new MethodContext(double.class, 143, 4953, 5121);
        try {
            CallChecker.varInit(this, "this", 143, 4953, 5121);
            CallChecker.varInit(this.random, "random", 143, 4953, 5121);
            CallChecker.varInit(this.randomData, "randomData", 143, 4953, 5121);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 143, 4953, 5121);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 143, 4953, 5121);
            CallChecker.varInit(this.shape, "shape", 143, 4953, 5121);
            CallChecker.varInit(this.scale, "scale", 143, 4953, 5121);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 143, 4953, 5121);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 143, 4953, 5121);
            return shape;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2021.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context2022 = new MethodContext(double.class, 157, 5128, 5572);
        try {
            CallChecker.varInit(this, "this", 157, 5128, 5572);
            CallChecker.varInit(x, "x", 157, 5128, 5572);
            CallChecker.varInit(this.random, "random", 157, 5128, 5572);
            CallChecker.varInit(this.randomData, "randomData", 157, 5128, 5572);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 157, 5128, 5572);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 157, 5128, 5572);
            CallChecker.varInit(this.shape, "shape", 157, 5128, 5572);
            CallChecker.varInit(this.scale, "scale", 157, 5128, 5572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 157, 5128, 5572);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 157, 5128, 5572);
            if (x < (scale)) {
                return 0;
            }
            return ((FastMath.pow(scale, shape)) / (FastMath.pow(x, ((shape) + 1)))) * (shape);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2022.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context2023 = new MethodContext(double.class, 173, 5579, 5997);
        try {
            CallChecker.varInit(this, "this", 173, 5579, 5997);
            CallChecker.varInit(x, "x", 173, 5579, 5997);
            CallChecker.varInit(this.random, "random", 173, 5579, 5997);
            CallChecker.varInit(this.randomData, "randomData", 173, 5579, 5997);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 173, 5579, 5997);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 173, 5579, 5997);
            CallChecker.varInit(this.shape, "shape", 173, 5579, 5997);
            CallChecker.varInit(this.scale, "scale", 173, 5579, 5997);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 173, 5579, 5997);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 173, 5579, 5997);
            if (x <= (scale)) {
                return 0;
            }
            return 1 - (FastMath.pow(((scale) / x), shape));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2023.methodEnd();
        }
    }

    @Override
    @Deprecated
    public double cumulativeProbability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context2024 = new MethodContext(double.class, 187, 6004, 6304);
        try {
            CallChecker.varInit(this, "this", 187, 6004, 6304);
            CallChecker.varInit(x1, "x1", 187, 6004, 6304);
            CallChecker.varInit(x0, "x0", 187, 6004, 6304);
            CallChecker.varInit(this.random, "random", 187, 6004, 6304);
            CallChecker.varInit(this.randomData, "randomData", 187, 6004, 6304);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 187, 6004, 6304);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 187, 6004, 6304);
            CallChecker.varInit(this.shape, "shape", 187, 6004, 6304);
            CallChecker.varInit(this.scale, "scale", 187, 6004, 6304);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 187, 6004, 6304);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 187, 6004, 6304);
            return probability(x0, x1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2024.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context2025 = new MethodContext(double.class, 194, 6311, 6440);
        try {
            CallChecker.varInit(this, "this", 194, 6311, 6440);
            CallChecker.varInit(this.random, "random", 194, 6311, 6440);
            CallChecker.varInit(this.randomData, "randomData", 194, 6311, 6440);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 194, 6311, 6440);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 194, 6311, 6440);
            CallChecker.varInit(this.shape, "shape", 194, 6311, 6440);
            CallChecker.varInit(this.scale, "scale", 194, 6311, 6440);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 194, 6311, 6440);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 194, 6311, 6440);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2025.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context2026 = new MethodContext(double.class, 207, 6447, 6849);
        try {
            CallChecker.varInit(this, "this", 207, 6447, 6849);
            CallChecker.varInit(this.random, "random", 207, 6447, 6849);
            CallChecker.varInit(this.randomData, "randomData", 207, 6447, 6849);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 207, 6447, 6849);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 207, 6447, 6849);
            CallChecker.varInit(this.shape, "shape", 207, 6447, 6849);
            CallChecker.varInit(this.scale, "scale", 207, 6447, 6849);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 207, 6447, 6849);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 207, 6447, 6849);
            if ((shape) <= 1) {
                return Double.POSITIVE_INFINITY;
            }
            return ((shape) * (scale)) / ((shape) - 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2026.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context2027 = new MethodContext(double.class, 223, 6856, 7334);
        try {
            CallChecker.varInit(this, "this", 223, 6856, 7334);
            CallChecker.varInit(this.random, "random", 223, 6856, 7334);
            CallChecker.varInit(this.randomData, "randomData", 223, 6856, 7334);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 223, 6856, 7334);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 223, 6856, 7334);
            CallChecker.varInit(this.shape, "shape", 223, 6856, 7334);
            CallChecker.varInit(this.scale, "scale", 223, 6856, 7334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 223, 6856, 7334);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 223, 6856, 7334);
            if ((shape) <= 2) {
                return Double.POSITIVE_INFINITY;
            }
            double s = CallChecker.varInit(((double) ((this.shape) - 1)), "s", 227, 7246, 7266);
            return ((((scale) * (scale)) * (shape)) / (s * s)) / ((shape) - 2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2027.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context2028 = new MethodContext(double.class, 238, 7341, 7584);
        try {
            CallChecker.varInit(this, "this", 238, 7341, 7584);
            CallChecker.varInit(this.random, "random", 238, 7341, 7584);
            CallChecker.varInit(this.randomData, "randomData", 238, 7341, 7584);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 238, 7341, 7584);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 238, 7341, 7584);
            CallChecker.varInit(this.shape, "shape", 238, 7341, 7584);
            CallChecker.varInit(this.scale, "scale", 238, 7341, 7584);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 238, 7341, 7584);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 238, 7341, 7584);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2028.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context2029 = new MethodContext(double.class, 249, 7591, 7906);
        try {
            CallChecker.varInit(this, "this", 249, 7591, 7906);
            CallChecker.varInit(this.random, "random", 249, 7591, 7906);
            CallChecker.varInit(this.randomData, "randomData", 249, 7591, 7906);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 249, 7591, 7906);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 249, 7591, 7906);
            CallChecker.varInit(this.shape, "shape", 249, 7591, 7906);
            CallChecker.varInit(this.scale, "scale", 249, 7591, 7906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 249, 7591, 7906);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 249, 7591, 7906);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2029.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context2030 = new MethodContext(boolean.class, 254, 7913, 8011);
        try {
            CallChecker.varInit(this, "this", 254, 7913, 8011);
            CallChecker.varInit(this.random, "random", 254, 7913, 8011);
            CallChecker.varInit(this.randomData, "randomData", 254, 7913, 8011);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 254, 7913, 8011);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 254, 7913, 8011);
            CallChecker.varInit(this.shape, "shape", 254, 7913, 8011);
            CallChecker.varInit(this.scale, "scale", 254, 7913, 8011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 254, 7913, 8011);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 254, 7913, 8011);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2030.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context2031 = new MethodContext(boolean.class, 259, 8018, 8117);
        try {
            CallChecker.varInit(this, "this", 259, 8018, 8117);
            CallChecker.varInit(this.random, "random", 259, 8018, 8117);
            CallChecker.varInit(this.randomData, "randomData", 259, 8018, 8117);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 259, 8018, 8117);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 259, 8018, 8117);
            CallChecker.varInit(this.shape, "shape", 259, 8018, 8117);
            CallChecker.varInit(this.scale, "scale", 259, 8018, 8117);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 259, 8018, 8117);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 259, 8018, 8117);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2031.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context2032 = new MethodContext(boolean.class, 270, 8124, 8324);
        try {
            CallChecker.varInit(this, "this", 270, 8124, 8324);
            CallChecker.varInit(this.random, "random", 270, 8124, 8324);
            CallChecker.varInit(this.randomData, "randomData", 270, 8124, 8324);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 270, 8124, 8324);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 270, 8124, 8324);
            CallChecker.varInit(this.shape, "shape", 270, 8124, 8324);
            CallChecker.varInit(this.scale, "scale", 270, 8124, 8324);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 270, 8124, 8324);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 270, 8124, 8324);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2032.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context2033 = new MethodContext(double.class, 276, 8331, 8497);
        try {
            CallChecker.varInit(this, "this", 276, 8331, 8497);
            CallChecker.varInit(this.random, "random", 276, 8331, 8497);
            CallChecker.varInit(this.randomData, "randomData", 276, 8331, 8497);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 276, 8331, 8497);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 276, 8331, 8497);
            CallChecker.varInit(this.shape, "shape", 276, 8331, 8497);
            CallChecker.varInit(this.scale, "scale", 276, 8331, 8497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ParetoDistribution.serialVersionUID", 276, 8331, 8497);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ParetoDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 276, 8331, 8497);
            final double n = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 277, 8421, 8426).nextDouble())), "n", 277, 8404, 8440);
            return (scale) / (FastMath.pow(n, (1 / (shape))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2033.methodEnd();
        }
    }
}

