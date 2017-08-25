package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class ZipfDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -140627372283420404L;

    private final int numberOfElements;

    private final double exponent;

    private double numericalMean = Double.NaN;

    private boolean numericalMeanIsCalculated = false;

    private double numericalVariance = Double.NaN;

    private boolean numericalVarianceIsCalculated = false;

    public ZipfDistribution(final int numberOfElements, final double exponent) {
        this(new Well19937c(), numberOfElements, exponent);
        ConstructorContext _bcornu_methode_context397 = new ConstructorContext(ZipfDistribution.class, 57, 2080, 2534);
        try {
        } finally {
            _bcornu_methode_context397.methodEnd();
        }
    }

    public ZipfDistribution(RandomGenerator rng, int numberOfElements, double exponent) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context398 = new ConstructorContext(ZipfDistribution.class, 71, 2541, 3529);
        try {
            if (numberOfElements <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, numberOfElements);
            }
            if (exponent <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.EXPONENT, exponent);
            }
            this.numberOfElements = numberOfElements;
            CallChecker.varAssign(this.numberOfElements, "this.numberOfElements", 86, 3449, 3489);
            this.exponent = exponent;
            CallChecker.varAssign(this.exponent, "this.exponent", 87, 3499, 3523);
        } finally {
            _bcornu_methode_context398.methodEnd();
        }
    }

    public int getNumberOfElements() {
        MethodContext _bcornu_methode_context1724 = new MethodContext(int.class, 95, 3536, 3744);
        try {
            CallChecker.varInit(this, "this", 95, 3536, 3744);
            CallChecker.varInit(this.random, "random", 95, 3536, 3744);
            CallChecker.varInit(this.randomData, "randomData", 95, 3536, 3744);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 95, 3536, 3744);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 95, 3536, 3744);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 95, 3536, 3744);
            CallChecker.varInit(this.numericalMean, "numericalMean", 95, 3536, 3744);
            CallChecker.varInit(this.exponent, "exponent", 95, 3536, 3744);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 95, 3536, 3744);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 95, 3536, 3744);
            return numberOfElements;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1724.methodEnd();
        }
    }

    public double getExponent() {
        MethodContext _bcornu_methode_context1725 = new MethodContext(double.class, 104, 3751, 3918);
        try {
            CallChecker.varInit(this, "this", 104, 3751, 3918);
            CallChecker.varInit(this.random, "random", 104, 3751, 3918);
            CallChecker.varInit(this.randomData, "randomData", 104, 3751, 3918);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 104, 3751, 3918);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 104, 3751, 3918);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 104, 3751, 3918);
            CallChecker.varInit(this.numericalMean, "numericalMean", 104, 3751, 3918);
            CallChecker.varInit(this.exponent, "exponent", 104, 3751, 3918);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 104, 3751, 3918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 104, 3751, 3918);
            return exponent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1725.methodEnd();
        }
    }

    public double probability(final int x) {
        MethodContext _bcornu_methode_context1726 = new MethodContext(double.class, 109, 3925, 4176);
        try {
            CallChecker.varInit(this, "this", 109, 3925, 4176);
            CallChecker.varInit(x, "x", 109, 3925, 4176);
            CallChecker.varInit(this.random, "random", 109, 3925, 4176);
            CallChecker.varInit(this.randomData, "randomData", 109, 3925, 4176);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 109, 3925, 4176);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 109, 3925, 4176);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 109, 3925, 4176);
            CallChecker.varInit(this.numericalMean, "numericalMean", 109, 3925, 4176);
            CallChecker.varInit(this.exponent, "exponent", 109, 3925, 4176);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 109, 3925, 4176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 109, 3925, 4176);
            if ((x <= 0) || (x > (numberOfElements))) {
                return 0.0;
            }
            return (1.0 / (FastMath.pow(x, exponent))) / (generalizedHarmonic(numberOfElements, exponent));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1726.methodEnd();
        }
    }

    public double cumulativeProbability(final int x) {
        MethodContext _bcornu_methode_context1727 = new MethodContext(double.class, 118, 4183, 4487);
        try {
            CallChecker.varInit(this, "this", 118, 4183, 4487);
            CallChecker.varInit(x, "x", 118, 4183, 4487);
            CallChecker.varInit(this.random, "random", 118, 4183, 4487);
            CallChecker.varInit(this.randomData, "randomData", 118, 4183, 4487);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 118, 4183, 4487);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 118, 4183, 4487);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 118, 4183, 4487);
            CallChecker.varInit(this.numericalMean, "numericalMean", 118, 4183, 4487);
            CallChecker.varInit(this.exponent, "exponent", 118, 4183, 4487);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 118, 4183, 4487);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 118, 4183, 4487);
            if (x <= 0) {
                return 0.0;
            }else
                if (x >= (numberOfElements)) {
                    return 1.0;
                }
            
            return (generalizedHarmonic(x, exponent)) / (generalizedHarmonic(numberOfElements, exponent));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1727.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1728 = new MethodContext(double.class, 138, 4494, 5010);
        try {
            CallChecker.varInit(this, "this", 138, 4494, 5010);
            CallChecker.varInit(this.random, "random", 138, 4494, 5010);
            CallChecker.varInit(this.randomData, "randomData", 138, 4494, 5010);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 138, 4494, 5010);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 138, 4494, 5010);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 138, 4494, 5010);
            CallChecker.varInit(this.numericalMean, "numericalMean", 138, 4494, 5010);
            CallChecker.varInit(this.exponent, "exponent", 138, 4494, 5010);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 138, 4494, 5010);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 138, 4494, 5010);
            if (!(numericalMeanIsCalculated)) {
                numericalMean = calculateNumericalMean();
                CallChecker.varAssign(this.numericalMean, "this.numericalMean", 140, 4878, 4918);
                numericalMeanIsCalculated = true;
                CallChecker.varAssign(this.numericalMeanIsCalculated, "this.numericalMeanIsCalculated", 141, 4932, 4964);
            }
            return numericalMean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1728.methodEnd();
        }
    }

    protected double calculateNumericalMean() {
        MethodContext _bcornu_methode_context1729 = new MethodContext(double.class, 151, 5017, 5400);
        try {
            CallChecker.varInit(this, "this", 151, 5017, 5400);
            CallChecker.varInit(this.random, "random", 151, 5017, 5400);
            CallChecker.varInit(this.randomData, "randomData", 151, 5017, 5400);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 151, 5017, 5400);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 151, 5017, 5400);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 151, 5017, 5400);
            CallChecker.varInit(this.numericalMean, "numericalMean", 151, 5017, 5400);
            CallChecker.varInit(this.exponent, "exponent", 151, 5017, 5400);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 151, 5017, 5400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 151, 5017, 5400);
            final int N = CallChecker.varInit(((int) (getNumberOfElements())), "N", 152, 5181, 5216);
            final double s = CallChecker.varInit(((double) (getExponent())), "s", 153, 5226, 5256);
            final double Hs1 = CallChecker.varInit(((double) (generalizedHarmonic(N, (s - 1)))), "Hs1", 155, 5267, 5315);
            final double Hs = CallChecker.varInit(((double) (generalizedHarmonic(N, s))), "Hs", 156, 5325, 5368);
            return Hs1 / Hs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1729.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1730 = new MethodContext(double.class, 172, 5407, 6028);
        try {
            CallChecker.varInit(this, "this", 172, 5407, 6028);
            CallChecker.varInit(this.random, "random", 172, 5407, 6028);
            CallChecker.varInit(this.randomData, "randomData", 172, 5407, 6028);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 172, 5407, 6028);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 172, 5407, 6028);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 172, 5407, 6028);
            CallChecker.varInit(this.numericalMean, "numericalMean", 172, 5407, 6028);
            CallChecker.varInit(this.exponent, "exponent", 172, 5407, 6028);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 172, 5407, 6028);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 172, 5407, 6028);
            if (!(numericalVarianceIsCalculated)) {
                numericalVariance = calculateNumericalVariance();
                CallChecker.varAssign(this.numericalVariance, "this.numericalVariance", 174, 5880, 5928);
                numericalVarianceIsCalculated = true;
                CallChecker.varAssign(this.numericalVarianceIsCalculated, "this.numericalVarianceIsCalculated", 175, 5942, 5978);
            }
            return numericalVariance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1730.methodEnd();
        }
    }

    protected double calculateNumericalVariance() {
        MethodContext _bcornu_methode_context1731 = new MethodContext(double.class, 185, 6035, 6518);
        try {
            CallChecker.varInit(this, "this", 185, 6035, 6518);
            CallChecker.varInit(this.random, "random", 185, 6035, 6518);
            CallChecker.varInit(this.randomData, "randomData", 185, 6035, 6518);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 185, 6035, 6518);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 185, 6035, 6518);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 185, 6035, 6518);
            CallChecker.varInit(this.numericalMean, "numericalMean", 185, 6035, 6518);
            CallChecker.varInit(this.exponent, "exponent", 185, 6035, 6518);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 185, 6035, 6518);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 185, 6035, 6518);
            final int N = CallChecker.varInit(((int) (getNumberOfElements())), "N", 186, 6211, 6246);
            final double s = CallChecker.varInit(((double) (getExponent())), "s", 187, 6256, 6286);
            final double Hs2 = CallChecker.varInit(((double) (generalizedHarmonic(N, (s - 2)))), "Hs2", 189, 6297, 6345);
            final double Hs1 = CallChecker.varInit(((double) (generalizedHarmonic(N, (s - 1)))), "Hs1", 190, 6355, 6403);
            final double Hs = CallChecker.varInit(((double) (generalizedHarmonic(N, s))), "Hs", 191, 6413, 6456);
            return (Hs2 / Hs) - ((Hs1 * Hs1) / (Hs * Hs));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1731.methodEnd();
        }
    }

    private double generalizedHarmonic(final int n, final double m) {
        MethodContext _bcornu_methode_context1732 = new MethodContext(double.class, 205, 6525, 7127);
        try {
            CallChecker.varInit(this, "this", 205, 6525, 7127);
            CallChecker.varInit(m, "m", 205, 6525, 7127);
            CallChecker.varInit(n, "n", 205, 6525, 7127);
            CallChecker.varInit(this.random, "random", 205, 6525, 7127);
            CallChecker.varInit(this.randomData, "randomData", 205, 6525, 7127);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 205, 6525, 7127);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 205, 6525, 7127);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 205, 6525, 7127);
            CallChecker.varInit(this.numericalMean, "numericalMean", 205, 6525, 7127);
            CallChecker.varInit(this.exponent, "exponent", 205, 6525, 7127);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 205, 6525, 7127);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 205, 6525, 7127);
            double value = CallChecker.varInit(((double) (0)), "value", 206, 6988, 7004);
            for (int k = n; k > 0; --k) {
                value += 1.0 / (FastMath.pow(k, m));
                CallChecker.varAssign(value, "value", 208, 7056, 7089);
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1732.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context1733 = new MethodContext(int.class, 220, 7134, 7372);
        try {
            CallChecker.varInit(this, "this", 220, 7134, 7372);
            CallChecker.varInit(this.random, "random", 220, 7134, 7372);
            CallChecker.varInit(this.randomData, "randomData", 220, 7134, 7372);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 220, 7134, 7372);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 220, 7134, 7372);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 220, 7134, 7372);
            CallChecker.varInit(this.numericalMean, "numericalMean", 220, 7134, 7372);
            CallChecker.varInit(this.exponent, "exponent", 220, 7134, 7372);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 220, 7134, 7372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 220, 7134, 7372);
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1733.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context1734 = new MethodContext(int.class, 231, 7379, 7615);
        try {
            CallChecker.varInit(this, "this", 231, 7379, 7615);
            CallChecker.varInit(this.random, "random", 231, 7379, 7615);
            CallChecker.varInit(this.randomData, "randomData", 231, 7379, 7615);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 231, 7379, 7615);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 231, 7379, 7615);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 231, 7379, 7615);
            CallChecker.varInit(this.numericalMean, "numericalMean", 231, 7379, 7615);
            CallChecker.varInit(this.exponent, "exponent", 231, 7379, 7615);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 231, 7379, 7615);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 231, 7379, 7615);
            return getNumberOfElements();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1734.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1735 = new MethodContext(boolean.class, 242, 7622, 7818);
        try {
            CallChecker.varInit(this, "this", 242, 7622, 7818);
            CallChecker.varInit(this.random, "random", 242, 7622, 7818);
            CallChecker.varInit(this.randomData, "randomData", 242, 7622, 7818);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 242, 7622, 7818);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 242, 7622, 7818);
            CallChecker.varInit(this.numericalMeanIsCalculated, "numericalMeanIsCalculated", 242, 7622, 7818);
            CallChecker.varInit(this.numericalMean, "numericalMean", 242, 7622, 7818);
            CallChecker.varInit(this.exponent, "exponent", 242, 7622, 7818);
            CallChecker.varInit(this.numberOfElements, "numberOfElements", 242, 7622, 7818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ZipfDistribution.serialVersionUID", 242, 7622, 7818);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1735.methodEnd();
        }
    }
}

