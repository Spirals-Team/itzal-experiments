package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

public class NormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 8589540077390120676L;

    private static final double SQRT2PI = FastMath.sqrt((2 * (FastMath.PI)));

    private static final double SQRT2 = FastMath.sqrt(2.0);

    private final double mean;

    private final double standardDeviation;

    private final double solverAbsoluteAccuracy;

    public NormalDistribution() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context253 = new ConstructorContext(NormalDistribution.class, 59, 2415, 2589);
        try {
        } finally {
            _bcornu_methode_context253.methodEnd();
        }
    }

    public NormalDistribution(double mean, double sd) throws NotStrictlyPositiveException {
        this(mean, sd, NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context254 = new ConstructorContext(NormalDistribution.class, 70, 2596, 3029);
        try {
        } finally {
            _bcornu_methode_context254.methodEnd();
        }
    }

    public NormalDistribution(double mean, double sd, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), mean, sd, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context255 = new ConstructorContext(NormalDistribution.class, 85, 3036, 3640);
        try {
        } finally {
            _bcornu_methode_context255.methodEnd();
        }
    }

    public NormalDistribution(RandomGenerator rng, double mean, double sd, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context256 = new ConstructorContext(NormalDistribution.class, 100, 3647, 4510);
        try {
            if (sd <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, sd);
            }
            this.mean = mean;
            CallChecker.varAssign(this.mean, "this.mean", 111, 4403, 4419);
            standardDeviation = sd;
            CallChecker.varAssign(this.standardDeviation, "this.standardDeviation", 112, 4429, 4451);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 113, 4461, 4504);
        } finally {
            _bcornu_methode_context256.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context1066 = new MethodContext(double.class, 121, 4517, 4662);
        try {
            CallChecker.varInit(this, "this", 121, 4517, 4662);
            CallChecker.varInit(this.random, "random", 121, 4517, 4662);
            CallChecker.varInit(this.randomData, "randomData", 121, 4517, 4662);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 121, 4517, 4662);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 121, 4517, 4662);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 121, 4517, 4662);
            CallChecker.varInit(this.mean, "mean", 121, 4517, 4662);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 121, 4517, 4662);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 121, 4517, 4662);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 121, 4517, 4662);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 121, 4517, 4662);
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1066.methodEnd();
        }
    }

    public double getStandardDeviation() {
        MethodContext _bcornu_methode_context1067 = new MethodContext(double.class, 130, 4669, 4868);
        try {
            CallChecker.varInit(this, "this", 130, 4669, 4868);
            CallChecker.varInit(this.random, "random", 130, 4669, 4868);
            CallChecker.varInit(this.randomData, "randomData", 130, 4669, 4868);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 130, 4669, 4868);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 130, 4669, 4868);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 130, 4669, 4868);
            CallChecker.varInit(this.mean, "mean", 130, 4669, 4868);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 130, 4669, 4868);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 130, 4669, 4868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 130, 4669, 4868);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 130, 4669, 4868);
            return standardDeviation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1067.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context1068 = new MethodContext(double.class, 135, 4875, 5101);
        try {
            CallChecker.varInit(this, "this", 135, 4875, 5101);
            CallChecker.varInit(x, "x", 135, 4875, 5101);
            CallChecker.varInit(this.random, "random", 135, 4875, 5101);
            CallChecker.varInit(this.randomData, "randomData", 135, 4875, 5101);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 135, 4875, 5101);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 135, 4875, 5101);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 135, 4875, 5101);
            CallChecker.varInit(this.mean, "mean", 135, 4875, 5101);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 135, 4875, 5101);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 135, 4875, 5101);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 135, 4875, 5101);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 135, 4875, 5101);
            final double x0 = CallChecker.varInit(((double) (x - (this.mean))), "x0", 136, 4942, 4968);
            final double x1 = CallChecker.varInit(((double) (x0 / (this.standardDeviation))), "x1", 137, 4978, 5018);
            return (FastMath.exp((((-0.5) * x1) * x1))) / ((standardDeviation) * (NormalDistribution.SQRT2PI));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1068.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context1069 = new MethodContext(double.class, 148, 5108, 5609);
        try {
            CallChecker.varInit(this, "this", 148, 5108, 5609);
            CallChecker.varInit(x, "x", 148, 5108, 5609);
            CallChecker.varInit(this.random, "random", 148, 5108, 5609);
            CallChecker.varInit(this.randomData, "randomData", 148, 5108, 5609);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 148, 5108, 5609);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 148, 5108, 5609);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 148, 5108, 5609);
            CallChecker.varInit(this.mean, "mean", 148, 5108, 5609);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 148, 5108, 5609);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 148, 5108, 5609);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 148, 5108, 5609);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 148, 5108, 5609);
            final double dev = CallChecker.varInit(((double) (x - (this.mean))), "dev", 149, 5395, 5422);
            if ((FastMath.abs(dev)) > (40 * (standardDeviation))) {
                if (dev < 0) {
                    return 0.0;
                }else {
                    return 1.0;
                }
            }
            return 0.5 * (1 + (Erf.erf((dev / ((standardDeviation) * (NormalDistribution.SQRT2))))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1069.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(final double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1070 = new MethodContext(double.class, 160, 5616, 5939);
        try {
            CallChecker.varInit(this, "this", 160, 5616, 5939);
            CallChecker.varInit(p, "p", 160, 5616, 5939);
            CallChecker.varInit(this.random, "random", 160, 5616, 5939);
            CallChecker.varInit(this.randomData, "randomData", 160, 5616, 5939);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 160, 5616, 5939);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 160, 5616, 5939);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 160, 5616, 5939);
            CallChecker.varInit(this.mean, "mean", 160, 5616, 5939);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 160, 5616, 5939);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 160, 5616, 5939);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 160, 5616, 5939);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 160, 5616, 5939);
            if ((p < 0.0) || (p > 1.0)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            return (mean) + (((standardDeviation) * (NormalDistribution.SQRT2)) * (Erf.erfInv(((2 * p) - 1))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1070.methodEnd();
        }
    }

    @Override
    @Deprecated
    public double cumulativeProbability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context1071 = new MethodContext(double.class, 173, 5946, 6241);
        try {
            CallChecker.varInit(this, "this", 173, 5946, 6241);
            CallChecker.varInit(x1, "x1", 173, 5946, 6241);
            CallChecker.varInit(x0, "x0", 173, 5946, 6241);
            CallChecker.varInit(this.random, "random", 173, 5946, 6241);
            CallChecker.varInit(this.randomData, "randomData", 173, 5946, 6241);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 173, 5946, 6241);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 173, 5946, 6241);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 173, 5946, 6241);
            CallChecker.varInit(this.mean, "mean", 173, 5946, 6241);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 173, 5946, 6241);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 173, 5946, 6241);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 173, 5946, 6241);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 173, 5946, 6241);
            return probability(x0, x1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1071.methodEnd();
        }
    }

    @Override
    public double probability(double x0, double x1) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context1072 = new MethodContext(double.class, 180, 6248, 6798);
        try {
            CallChecker.varInit(this, "this", 180, 6248, 6798);
            CallChecker.varInit(x1, "x1", 180, 6248, 6798);
            CallChecker.varInit(x0, "x0", 180, 6248, 6798);
            CallChecker.varInit(this.random, "random", 180, 6248, 6798);
            CallChecker.varInit(this.randomData, "randomData", 180, 6248, 6798);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 180, 6248, 6798);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 180, 6248, 6798);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 180, 6248, 6798);
            CallChecker.varInit(this.mean, "mean", 180, 6248, 6798);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 180, 6248, 6798);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 180, 6248, 6798);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 180, 6248, 6798);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 180, 6248, 6798);
            if (x0 > x1) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, x0, x1, true);
            }
            final double denom = CallChecker.varInit(((double) ((this.standardDeviation) * (NormalDistribution.SQRT2))), "denom", 187, 6614, 6660);
            final double v0 = CallChecker.varInit(((double) ((x0 - (this.mean)) / denom)), "v0", 188, 6670, 6707);
            final double v1 = CallChecker.varInit(((double) ((x1 - (this.mean)) / denom)), "v1", 189, 6717, 6754);
            return 0.5 * (Erf.erf(v0, v1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1072.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context1073 = new MethodContext(double.class, 195, 6805, 6934);
        try {
            CallChecker.varInit(this, "this", 195, 6805, 6934);
            CallChecker.varInit(this.random, "random", 195, 6805, 6934);
            CallChecker.varInit(this.randomData, "randomData", 195, 6805, 6934);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 195, 6805, 6934);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 195, 6805, 6934);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 195, 6805, 6934);
            CallChecker.varInit(this.mean, "mean", 195, 6805, 6934);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 195, 6805, 6934);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 195, 6805, 6934);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 195, 6805, 6934);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 195, 6805, 6934);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1073.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1074 = new MethodContext(double.class, 204, 6941, 7112);
        try {
            CallChecker.varInit(this, "this", 204, 6941, 7112);
            CallChecker.varInit(this.random, "random", 204, 6941, 7112);
            CallChecker.varInit(this.randomData, "randomData", 204, 6941, 7112);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 204, 6941, 7112);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 204, 6941, 7112);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 204, 6941, 7112);
            CallChecker.varInit(this.mean, "mean", 204, 6941, 7112);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 204, 6941, 7112);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 204, 6941, 7112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 204, 6941, 7112);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 204, 6941, 7112);
            return getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1074.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1075 = new MethodContext(double.class, 213, 7119, 7357);
        try {
            CallChecker.varInit(this, "this", 213, 7119, 7357);
            CallChecker.varInit(this.random, "random", 213, 7119, 7357);
            CallChecker.varInit(this.randomData, "randomData", 213, 7119, 7357);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 213, 7119, 7357);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 213, 7119, 7357);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 213, 7119, 7357);
            CallChecker.varInit(this.mean, "mean", 213, 7119, 7357);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 213, 7119, 7357);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 213, 7119, 7357);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 213, 7119, 7357);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 213, 7119, 7357);
            final double s = CallChecker.varInit(((double) (getStandardDeviation())), "s", 214, 7290, 7329);
            return s * s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1075.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context1076 = new MethodContext(double.class, 227, 7364, 7689);
        try {
            CallChecker.varInit(this, "this", 227, 7364, 7689);
            CallChecker.varInit(this.random, "random", 227, 7364, 7689);
            CallChecker.varInit(this.randomData, "randomData", 227, 7364, 7689);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 227, 7364, 7689);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 227, 7364, 7689);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 227, 7364, 7689);
            CallChecker.varInit(this.mean, "mean", 227, 7364, 7689);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 227, 7364, 7689);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 227, 7364, 7689);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 227, 7364, 7689);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 227, 7364, 7689);
            return Double.NEGATIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1076.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context1077 = new MethodContext(double.class, 240, 7696, 8021);
        try {
            CallChecker.varInit(this, "this", 240, 7696, 8021);
            CallChecker.varInit(this.random, "random", 240, 7696, 8021);
            CallChecker.varInit(this.randomData, "randomData", 240, 7696, 8021);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 240, 7696, 8021);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 240, 7696, 8021);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 240, 7696, 8021);
            CallChecker.varInit(this.mean, "mean", 240, 7696, 8021);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 240, 7696, 8021);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 240, 7696, 8021);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 240, 7696, 8021);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 240, 7696, 8021);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1077.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context1078 = new MethodContext(boolean.class, 245, 8028, 8127);
        try {
            CallChecker.varInit(this, "this", 245, 8028, 8127);
            CallChecker.varInit(this.random, "random", 245, 8028, 8127);
            CallChecker.varInit(this.randomData, "randomData", 245, 8028, 8127);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 245, 8028, 8127);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 245, 8028, 8127);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 245, 8028, 8127);
            CallChecker.varInit(this.mean, "mean", 245, 8028, 8127);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 245, 8028, 8127);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 245, 8028, 8127);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 245, 8028, 8127);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 245, 8028, 8127);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1078.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context1079 = new MethodContext(boolean.class, 250, 8134, 8233);
        try {
            CallChecker.varInit(this, "this", 250, 8134, 8233);
            CallChecker.varInit(this.random, "random", 250, 8134, 8233);
            CallChecker.varInit(this.randomData, "randomData", 250, 8134, 8233);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 250, 8134, 8233);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 250, 8134, 8233);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 250, 8134, 8233);
            CallChecker.varInit(this.mean, "mean", 250, 8134, 8233);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 250, 8134, 8233);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 250, 8134, 8233);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 250, 8134, 8233);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 250, 8134, 8233);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1079.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1080 = new MethodContext(boolean.class, 261, 8240, 8436);
        try {
            CallChecker.varInit(this, "this", 261, 8240, 8436);
            CallChecker.varInit(this.random, "random", 261, 8240, 8436);
            CallChecker.varInit(this.randomData, "randomData", 261, 8240, 8436);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 261, 8240, 8436);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 261, 8240, 8436);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 261, 8240, 8436);
            CallChecker.varInit(this.mean, "mean", 261, 8240, 8436);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 261, 8240, 8436);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 261, 8240, 8436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 261, 8240, 8436);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 261, 8240, 8436);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1080.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context1081 = new MethodContext(double.class, 267, 8443, 8577);
        try {
            CallChecker.varInit(this, "this", 267, 8443, 8577);
            CallChecker.varInit(this.random, "random", 267, 8443, 8577);
            CallChecker.varInit(this.randomData, "randomData", 267, 8443, 8577);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 267, 8443, 8577);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 267, 8443, 8577);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 267, 8443, 8577);
            CallChecker.varInit(this.mean, "mean", 267, 8443, 8577);
            CallChecker.varInit(SQRT2, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2", 267, 8443, 8577);
            CallChecker.varInit(SQRT2PI, "org.apache.commons.math3.distribution.NormalDistribution.SQRT2PI", 267, 8443, 8577);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.NormalDistribution.serialVersionUID", 267, 8443, 8577);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.NormalDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 267, 8443, 8577);
            return ((standardDeviation) * (CallChecker.isCalled(random, RandomGenerator.class, 268, 8543, 8548).nextGaussian())) + (mean);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1081.methodEnd();
        }
    }
}

