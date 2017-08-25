package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class HypergeometricDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = -436928820673516179L;

    private final int numberOfSuccesses;

    private final int populationSize;

    private final int sampleSize;

    private double numericalVariance = Double.NaN;

    private boolean numericalVarianceIsCalculated = false;

    public HypergeometricDistribution(int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        this(new Well19937c(), populationSize, numberOfSuccesses, sampleSize);
        ConstructorContext _bcornu_methode_context947 = new ConstructorContext(HypergeometricDistribution.class, 61, 2242, 3118);
        try {
        } finally {
            _bcornu_methode_context947.methodEnd();
        }
    }

    public HypergeometricDistribution(RandomGenerator rng, int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        super(rng);
        ConstructorContext _bcornu_methode_context948 = new ConstructorContext(HypergeometricDistribution.class, 79, 3125, 5245);
        try {
            if (populationSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.POPULATION_SIZE, populationSize);
            }
            if (numberOfSuccesses < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, numberOfSuccesses);
            }
            if (sampleSize < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            if (numberOfSuccesses > populationSize) {
                throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE, numberOfSuccesses, populationSize, true);
            }
            if (sampleSize > populationSize) {
                throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE, sampleSize, populationSize, true);
            }
            this.numberOfSuccesses = numberOfSuccesses;
            CallChecker.varAssign(this.numberOfSuccesses, "this.numberOfSuccesses", 108, 5113, 5155);
            this.populationSize = populationSize;
            CallChecker.varAssign(this.populationSize, "this.populationSize", 109, 5165, 5201);
            this.sampleSize = sampleSize;
            CallChecker.varAssign(this.sampleSize, "this.sampleSize", 110, 5211, 5239);
        } finally {
            _bcornu_methode_context948.methodEnd();
        }
    }

    public double cumulativeProbability(int x) {
        MethodContext _bcornu_methode_context4256 = new MethodContext(double.class, 114, 5252, 5651);
        try {
            CallChecker.varInit(this, "this", 114, 5252, 5651);
            CallChecker.varInit(x, "x", 114, 5252, 5651);
            CallChecker.varInit(this.random, "random", 114, 5252, 5651);
            CallChecker.varInit(this.randomData, "randomData", 114, 5252, 5651);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 114, 5252, 5651);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 114, 5252, 5651);
            CallChecker.varInit(this.sampleSize, "sampleSize", 114, 5252, 5651);
            CallChecker.varInit(this.populationSize, "populationSize", 114, 5252, 5651);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 114, 5252, 5651);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 114, 5252, 5651);
            double ret = CallChecker.init(double.class);
            int[] domain = CallChecker.varInit(getDomain(populationSize, numberOfSuccesses, sampleSize), "domain", 117, 5351, 5422);
            if (CallChecker.beforeDeref(domain, int[].class, 118, 5440, 5445)) {
                domain = CallChecker.beforeCalled(domain, int[].class, 118, 5440, 5445);
                if (x < (CallChecker.isCalled(domain, int[].class, 118, 5440, 5445)[0])) {
                    ret = 0.0;
                    CallChecker.varAssign(ret, "ret", 119, 5465, 5474);
                }else
                    if (CallChecker.beforeDeref(domain, int[].class, 120, 5500, 5505)) {
                        domain = CallChecker.beforeCalled(domain, int[].class, 120, 5500, 5505);
                        if (x >= (CallChecker.isCalled(domain, int[].class, 120, 5500, 5505)[1])) {
                            ret = 1.0;
                            CallChecker.varAssign(ret, "ret", 121, 5525, 5534);
                        }else {
                            if (CallChecker.beforeDeref(domain, int[].class, 123, 5598, 5603)) {
                                domain = CallChecker.beforeCalled(domain, int[].class, 123, 5598, 5603);
                                ret = innerCumulativeProbability(CallChecker.isCalled(domain, int[].class, 123, 5598, 5603)[0], x, 1);
                                CallChecker.varAssign(ret, "ret", 123, 5565, 5614);
                            }
                        }
                    }
                
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4256.methodEnd();
        }
    }

    private int[] getDomain(int n, int m, int k) {
        MethodContext _bcornu_methode_context4257 = new MethodContext(int[].class, 138, 5658, 6120);
        try {
            CallChecker.varInit(this, "this", 138, 5658, 6120);
            CallChecker.varInit(k, "k", 138, 5658, 6120);
            CallChecker.varInit(m, "m", 138, 5658, 6120);
            CallChecker.varInit(n, "n", 138, 5658, 6120);
            CallChecker.varInit(this.random, "random", 138, 5658, 6120);
            CallChecker.varInit(this.randomData, "randomData", 138, 5658, 6120);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 138, 5658, 6120);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 138, 5658, 6120);
            CallChecker.varInit(this.sampleSize, "sampleSize", 138, 5658, 6120);
            CallChecker.varInit(this.populationSize, "populationSize", 138, 5658, 6120);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 138, 5658, 6120);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 138, 5658, 6120);
            return new int[]{ getLowerDomain(n, m, k) , getUpperDomain(m, k) };
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4257.methodEnd();
        }
    }

    private int getLowerDomain(int n, int m, int k) {
        MethodContext _bcornu_methode_context4258 = new MethodContext(int.class, 151, 6127, 6540);
        try {
            CallChecker.varInit(this, "this", 151, 6127, 6540);
            CallChecker.varInit(k, "k", 151, 6127, 6540);
            CallChecker.varInit(m, "m", 151, 6127, 6540);
            CallChecker.varInit(n, "n", 151, 6127, 6540);
            CallChecker.varInit(this.random, "random", 151, 6127, 6540);
            CallChecker.varInit(this.randomData, "randomData", 151, 6127, 6540);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 151, 6127, 6540);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 151, 6127, 6540);
            CallChecker.varInit(this.sampleSize, "sampleSize", 151, 6127, 6540);
            CallChecker.varInit(this.populationSize, "populationSize", 151, 6127, 6540);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 151, 6127, 6540);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 151, 6127, 6540);
            return FastMath.max(0, (m - (n - k)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4258.methodEnd();
        }
    }

    public int getNumberOfSuccesses() {
        MethodContext _bcornu_methode_context4259 = new MethodContext(int.class, 160, 6547, 6723);
        try {
            CallChecker.varInit(this, "this", 160, 6547, 6723);
            CallChecker.varInit(this.random, "random", 160, 6547, 6723);
            CallChecker.varInit(this.randomData, "randomData", 160, 6547, 6723);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 160, 6547, 6723);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 160, 6547, 6723);
            CallChecker.varInit(this.sampleSize, "sampleSize", 160, 6547, 6723);
            CallChecker.varInit(this.populationSize, "populationSize", 160, 6547, 6723);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 160, 6547, 6723);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 160, 6547, 6723);
            return numberOfSuccesses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4259.methodEnd();
        }
    }

    public int getPopulationSize() {
        MethodContext _bcornu_methode_context4260 = new MethodContext(int.class, 169, 6730, 6892);
        try {
            CallChecker.varInit(this, "this", 169, 6730, 6892);
            CallChecker.varInit(this.random, "random", 169, 6730, 6892);
            CallChecker.varInit(this.randomData, "randomData", 169, 6730, 6892);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 169, 6730, 6892);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 169, 6730, 6892);
            CallChecker.varInit(this.sampleSize, "sampleSize", 169, 6730, 6892);
            CallChecker.varInit(this.populationSize, "populationSize", 169, 6730, 6892);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 169, 6730, 6892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 169, 6730, 6892);
            return populationSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4260.methodEnd();
        }
    }

    public int getSampleSize() {
        MethodContext _bcornu_methode_context4261 = new MethodContext(int.class, 178, 6899, 7045);
        try {
            CallChecker.varInit(this, "this", 178, 6899, 7045);
            CallChecker.varInit(this.random, "random", 178, 6899, 7045);
            CallChecker.varInit(this.randomData, "randomData", 178, 6899, 7045);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 178, 6899, 7045);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 178, 6899, 7045);
            CallChecker.varInit(this.sampleSize, "sampleSize", 178, 6899, 7045);
            CallChecker.varInit(this.populationSize, "populationSize", 178, 6899, 7045);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 178, 6899, 7045);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 178, 6899, 7045);
            return sampleSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4261.methodEnd();
        }
    }

    private int getUpperDomain(int m, int k) {
        MethodContext _bcornu_methode_context4262 = new MethodContext(int.class, 190, 7052, 7417);
        try {
            CallChecker.varInit(this, "this", 190, 7052, 7417);
            CallChecker.varInit(k, "k", 190, 7052, 7417);
            CallChecker.varInit(m, "m", 190, 7052, 7417);
            CallChecker.varInit(this.random, "random", 190, 7052, 7417);
            CallChecker.varInit(this.randomData, "randomData", 190, 7052, 7417);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 190, 7052, 7417);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 190, 7052, 7417);
            CallChecker.varInit(this.sampleSize, "sampleSize", 190, 7052, 7417);
            CallChecker.varInit(this.populationSize, "populationSize", 190, 7052, 7417);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 190, 7052, 7417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 190, 7052, 7417);
            return FastMath.min(k, m);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4262.methodEnd();
        }
    }

    public double probability(int x) {
        MethodContext _bcornu_methode_context4263 = new MethodContext(double.class, 195, 7424, 8311);
        try {
            CallChecker.varInit(this, "this", 195, 7424, 8311);
            CallChecker.varInit(x, "x", 195, 7424, 8311);
            CallChecker.varInit(this.random, "random", 195, 7424, 8311);
            CallChecker.varInit(this.randomData, "randomData", 195, 7424, 8311);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 195, 7424, 8311);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 195, 7424, 8311);
            CallChecker.varInit(this.sampleSize, "sampleSize", 195, 7424, 8311);
            CallChecker.varInit(this.populationSize, "populationSize", 195, 7424, 8311);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 195, 7424, 8311);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 195, 7424, 8311);
            double ret = CallChecker.init(double.class);
            int[] domain = CallChecker.varInit(getDomain(populationSize, numberOfSuccesses, sampleSize), "domain", 198, 7513, 7584);
            if (CallChecker.beforeDeref(domain, int[].class, 199, 7602, 7607)) {
                if (CallChecker.beforeDeref(domain, int[].class, 199, 7619, 7624)) {
                    domain = CallChecker.beforeCalled(domain, int[].class, 199, 7602, 7607);
                    domain = CallChecker.beforeCalled(domain, int[].class, 199, 7619, 7624);
                    if ((x < (CallChecker.isCalled(domain, int[].class, 199, 7602, 7607)[0])) || (x > (CallChecker.isCalled(domain, int[].class, 199, 7619, 7624)[1]))) {
                        ret = 0.0;
                        CallChecker.varAssign(ret, "ret", 200, 7644, 7653);
                    }else {
                        double p = CallChecker.varInit(((double) (((double) (this.sampleSize)) / ((double) (this.populationSize)))), "p", 202, 7684, 7740);
                        double q = CallChecker.varInit(((double) (((double) ((this.populationSize) - (this.sampleSize))) / ((double) (this.populationSize)))), "q", 203, 7754, 7829);
                        double p1 = CallChecker.varInit(((double) (SaddlePointExpansion.logBinomialProbability(x, this.numberOfSuccesses, p, q))), "p1", 204, 7843, 7946);
                        double p2 = CallChecker.varInit(((double) (SaddlePointExpansion.logBinomialProbability(((this.sampleSize) - x), ((this.populationSize) - (this.numberOfSuccesses)), p, q))), "p2", 206, 7960, 8109);
                        double p3 = CallChecker.varInit(((double) (SaddlePointExpansion.logBinomialProbability(this.sampleSize, this.populationSize, p, q))), "p3", 209, 8123, 8228);
                        ret = FastMath.exp(((p1 + p2) - p3));
                        CallChecker.varAssign(ret, "ret", 211, 8242, 8274);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4263.methodEnd();
        }
    }

    public double upperCumulativeProbability(int x) {
        MethodContext _bcornu_methode_context4264 = new MethodContext(double.class, 224, 8318, 8935);
        try {
            CallChecker.varInit(this, "this", 224, 8318, 8935);
            CallChecker.varInit(x, "x", 224, 8318, 8935);
            CallChecker.varInit(this.random, "random", 224, 8318, 8935);
            CallChecker.varInit(this.randomData, "randomData", 224, 8318, 8935);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 224, 8318, 8935);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 224, 8318, 8935);
            CallChecker.varInit(this.sampleSize, "sampleSize", 224, 8318, 8935);
            CallChecker.varInit(this.populationSize, "populationSize", 224, 8318, 8935);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 224, 8318, 8935);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 224, 8318, 8935);
            double ret = CallChecker.init(double.class);
            final int[] domain = CallChecker.varInit(getDomain(populationSize, numberOfSuccesses, sampleSize), "domain", 227, 8628, 8705);
            if (CallChecker.beforeDeref(domain, int[].class, 228, 8724, 8729)) {
                if (x <= (CallChecker.isCalled(domain, int[].class, 228, 8724, 8729)[0])) {
                    ret = 1.0;
                    CallChecker.varAssign(ret, "ret", 229, 8749, 8758);
                }else
                    if (CallChecker.beforeDeref(domain, int[].class, 230, 8783, 8788)) {
                        if (x > (CallChecker.isCalled(domain, int[].class, 230, 8783, 8788)[1])) {
                            ret = 0.0;
                            CallChecker.varAssign(ret, "ret", 231, 8808, 8817);
                        }else {
                            if (CallChecker.beforeDeref(domain, int[].class, 233, 8881, 8886)) {
                                ret = innerCumulativeProbability(CallChecker.isCalled(domain, int[].class, 233, 8881, 8886)[1], x, (-1));
                                CallChecker.varAssign(ret, "ret", 233, 8848, 8898);
                            }
                        }
                    }
                
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4264.methodEnd();
        }
    }

    private double innerCumulativeProbability(int x0, int x1, int dx) {
        MethodContext _bcornu_methode_context4265 = new MethodContext(double.class, 252, 8942, 9702);
        try {
            CallChecker.varInit(this, "this", 252, 8942, 9702);
            CallChecker.varInit(dx, "dx", 252, 8942, 9702);
            CallChecker.varInit(x1, "x1", 252, 8942, 9702);
            CallChecker.varInit(x0, "x0", 252, 8942, 9702);
            CallChecker.varInit(this.random, "random", 252, 8942, 9702);
            CallChecker.varInit(this.randomData, "randomData", 252, 8942, 9702);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 252, 8942, 9702);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 252, 8942, 9702);
            CallChecker.varInit(this.sampleSize, "sampleSize", 252, 8942, 9702);
            CallChecker.varInit(this.populationSize, "populationSize", 252, 8942, 9702);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 252, 8942, 9702);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 252, 8942, 9702);
            double ret = CallChecker.varInit(((double) (probability(x0))), "ret", 253, 9553, 9581);
            while (x0 != x1) {
                x0 += dx;
                CallChecker.varAssign(x0, "x0", 255, 9622, 9630);
                ret += probability(x0);
                CallChecker.varAssign(ret, "ret", 256, 9644, 9666);
            } 
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4265.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context4266 = new MethodContext(double.class, 267, 9709, 10025);
        try {
            CallChecker.varInit(this, "this", 267, 9709, 10025);
            CallChecker.varInit(this.random, "random", 267, 9709, 10025);
            CallChecker.varInit(this.randomData, "randomData", 267, 9709, 10025);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 267, 9709, 10025);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 267, 9709, 10025);
            CallChecker.varInit(this.sampleSize, "sampleSize", 267, 9709, 10025);
            CallChecker.varInit(this.populationSize, "populationSize", 267, 9709, 10025);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 267, 9709, 10025);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 267, 9709, 10025);
            return ((double) ((getSampleSize()) * (getNumberOfSuccesses()))) / ((double) (getPopulationSize()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4266.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context4267 = new MethodContext(double.class, 278, 10032, 10502);
        try {
            CallChecker.varInit(this, "this", 278, 10032, 10502);
            CallChecker.varInit(this.random, "random", 278, 10032, 10502);
            CallChecker.varInit(this.randomData, "randomData", 278, 10032, 10502);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 278, 10032, 10502);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 278, 10032, 10502);
            CallChecker.varInit(this.sampleSize, "sampleSize", 278, 10032, 10502);
            CallChecker.varInit(this.populationSize, "populationSize", 278, 10032, 10502);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 278, 10032, 10502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 278, 10032, 10502);
            if (!(numericalVarianceIsCalculated)) {
                numericalVariance = calculateNumericalVariance();
                CallChecker.varAssign(this.numericalVariance, "this.numericalVariance", 280, 10354, 10402);
                numericalVarianceIsCalculated = true;
                CallChecker.varAssign(this.numericalVarianceIsCalculated, "this.numericalVarianceIsCalculated", 281, 10416, 10452);
            }
            return numericalVariance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4267.methodEnd();
        }
    }

    protected double calculateNumericalVariance() {
        MethodContext _bcornu_methode_context4268 = new MethodContext(double.class, 291, 10509, 10882);
        try {
            CallChecker.varInit(this, "this", 291, 10509, 10882);
            CallChecker.varInit(this.random, "random", 291, 10509, 10882);
            CallChecker.varInit(this.randomData, "randomData", 291, 10509, 10882);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 291, 10509, 10882);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 291, 10509, 10882);
            CallChecker.varInit(this.sampleSize, "sampleSize", 291, 10509, 10882);
            CallChecker.varInit(this.populationSize, "populationSize", 291, 10509, 10882);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 291, 10509, 10882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 291, 10509, 10882);
            final double N = CallChecker.varInit(((double) (getPopulationSize())), "N", 292, 10685, 10721);
            final double m = CallChecker.varInit(((double) (getNumberOfSuccesses())), "m", 293, 10731, 10770);
            final double n = CallChecker.varInit(((double) (getSampleSize())), "n", 294, 10780, 10812);
            return (((n * m) * (N - n)) * (N - m)) / ((N * N) * (N - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4268.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context4269 = new MethodContext(int.class, 307, 10889, 11317);
        try {
            CallChecker.varInit(this, "this", 307, 10889, 11317);
            CallChecker.varInit(this.random, "random", 307, 10889, 11317);
            CallChecker.varInit(this.randomData, "randomData", 307, 10889, 11317);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 307, 10889, 11317);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 307, 10889, 11317);
            CallChecker.varInit(this.sampleSize, "sampleSize", 307, 10889, 11317);
            CallChecker.varInit(this.populationSize, "populationSize", 307, 10889, 11317);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 307, 10889, 11317);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 307, 10889, 11317);
            return FastMath.max(0, (((getSampleSize()) + (getNumberOfSuccesses())) - (getPopulationSize())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4269.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context4270 = new MethodContext(int.class, 320, 11324, 11655);
        try {
            CallChecker.varInit(this, "this", 320, 11324, 11655);
            CallChecker.varInit(this.random, "random", 320, 11324, 11655);
            CallChecker.varInit(this.randomData, "randomData", 320, 11324, 11655);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 320, 11324, 11655);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 320, 11324, 11655);
            CallChecker.varInit(this.sampleSize, "sampleSize", 320, 11324, 11655);
            CallChecker.varInit(this.populationSize, "populationSize", 320, 11324, 11655);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 320, 11324, 11655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 320, 11324, 11655);
            return FastMath.min(getNumberOfSuccesses(), getSampleSize());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4270.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context4271 = new MethodContext(boolean.class, 331, 11662, 11858);
        try {
            CallChecker.varInit(this, "this", 331, 11662, 11858);
            CallChecker.varInit(this.random, "random", 331, 11662, 11858);
            CallChecker.varInit(this.randomData, "randomData", 331, 11662, 11858);
            CallChecker.varInit(this.numericalVarianceIsCalculated, "numericalVarianceIsCalculated", 331, 11662, 11858);
            CallChecker.varInit(this.numericalVariance, "numericalVariance", 331, 11662, 11858);
            CallChecker.varInit(this.sampleSize, "sampleSize", 331, 11662, 11858);
            CallChecker.varInit(this.populationSize, "populationSize", 331, 11662, 11858);
            CallChecker.varInit(this.numberOfSuccesses, "numberOfSuccesses", 331, 11662, 11858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.HypergeometricDistribution.serialVersionUID", 331, 11662, 11858);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4271.methodEnd();
        }
    }
}

