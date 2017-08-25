package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public abstract class AbstractMultivariateRealDistribution implements MultivariateRealDistribution {
    protected final RandomGenerator random;

    private final int dimension;

    protected AbstractMultivariateRealDistribution(RandomGenerator rng, int n) {
        ConstructorContext _bcornu_methode_context956 = new ConstructorContext(AbstractMultivariateRealDistribution.class, 40, 1485, 1759);
        try {
            random = rng;
            CallChecker.varAssign(this.random, "this.random", 42, 1718, 1730);
            dimension = n;
            CallChecker.varAssign(this.dimension, "this.dimension", 43, 1740, 1753);
        } finally {
            _bcornu_methode_context956.methodEnd();
        }
    }

    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context4301 = new MethodContext(void.class, 47, 1766, 1872);
        try {
            CallChecker.varInit(this, "this", 47, 1766, 1872);
            CallChecker.varInit(seed, "seed", 47, 1766, 1872);
            CallChecker.varInit(this.dimension, "dimension", 47, 1766, 1872);
            CallChecker.varInit(this.random, "random", 47, 1766, 1872);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 48, 1846, 1851)) {
                CallChecker.isCalled(random, RandomGenerator.class, 48, 1846, 1851).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4301.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context4302 = new MethodContext(int.class, 52, 1879, 1962);
        try {
            CallChecker.varInit(this, "this", 52, 1879, 1962);
            CallChecker.varInit(this.dimension, "dimension", 52, 1879, 1962);
            CallChecker.varInit(this.random, "random", 52, 1879, 1962);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4302.methodEnd();
        }
    }

    public abstract double[] sample();

    public double[][] sample(final int sampleSize) {
        MethodContext _bcornu_methode_context4304 = new MethodContext(double[][].class, 60, 2034, 2478);
        try {
            CallChecker.varInit(this, "this", 60, 2034, 2478);
            CallChecker.varInit(sampleSize, "sampleSize", 60, 2034, 2478);
            CallChecker.varInit(this.dimension, "dimension", 60, 2034, 2478);
            CallChecker.varInit(this.random, "random", 60, 2034, 2478);
            if (sampleSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            final double[][] out = CallChecker.varInit(new double[sampleSize][dimension], "out", 65, 2308, 2364);
            for (int i = 0; i < sampleSize; i++) {
                if (CallChecker.beforeDeref(out, double[][].class, 67, 2425, 2427)) {
                    CallChecker.isCalled(out, double[][].class, 67, 2425, 2427)[i] = sample();
                    CallChecker.varAssign(CallChecker.isCalled(out, double[][].class, 67, 2425, 2427)[i], "CallChecker.isCalled(out, double[][].class, 67, 2425, 2427)[i]", 67, 2425, 2442);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4304.methodEnd();
        }
    }
}

