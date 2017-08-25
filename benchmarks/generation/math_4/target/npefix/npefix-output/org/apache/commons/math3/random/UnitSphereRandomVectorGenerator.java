package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class UnitSphereRandomVectorGenerator implements RandomVectorGenerator {
    private final RandomGenerator rand;

    private final int dimension;

    public UnitSphereRandomVectorGenerator(final int dimension, final RandomGenerator rand) {
        ConstructorContext _bcornu_methode_context917 = new ConstructorContext(UnitSphereRandomVectorGenerator.class, 45, 1306, 1631);
        try {
            this.dimension = dimension;
            CallChecker.varAssign(this.dimension, "this.dimension", 47, 1573, 1599);
            this.rand = rand;
            CallChecker.varAssign(this.rand, "this.rand", 48, 1609, 1625);
        } finally {
            _bcornu_methode_context917.methodEnd();
        }
    }

    public UnitSphereRandomVectorGenerator(final int dimension) {
        this(dimension, new MersenneTwister());
        ConstructorContext _bcornu_methode_context918 = new ConstructorContext(UnitSphereRandomVectorGenerator.class, 56, 1637, 1949);
        try {
        } finally {
            _bcornu_methode_context918.methodEnd();
        }
    }

    public double[] nextVector() {
        MethodContext _bcornu_methode_context4171 = new MethodContext(double[].class, 61, 1956, 2617);
        try {
            CallChecker.varInit(this, "this", 61, 1956, 2617);
            CallChecker.varInit(this.dimension, "dimension", 61, 1956, 2617);
            CallChecker.varInit(this.rand, "rand", 61, 1956, 2617);
            final double[] v = CallChecker.varInit(new double[dimension], "v", 62, 2020, 2060);
            double normSq = CallChecker.varInit(((double) (0)), "normSq", 67, 2274, 2291);
            for (int i = 0; i < (dimension); i++) {
                final double comp = CallChecker.varInit(((double) (CallChecker.isCalled(this.rand, RandomGenerator.class, 69, 2371, 2374).nextGaussian())), "comp", 69, 2351, 2390);
                if (CallChecker.beforeDeref(v, double[].class, 70, 2404, 2404)) {
                    CallChecker.isCalled(v, double[].class, 70, 2404, 2404)[i] = comp;
                    CallChecker.varAssign(CallChecker.isCalled(v, double[].class, 70, 2404, 2404)[i], "CallChecker.isCalled(v, double[].class, 70, 2404, 2404)[i]", 70, 2404, 2415);
                }
                normSq += comp * comp;
                CallChecker.varAssign(normSq, "normSq", 71, 2429, 2450);
            }
            final double f = CallChecker.varInit(((double) (1 / (FastMath.sqrt(normSq)))), "f", 74, 2471, 2513);
            for (int i = 0; i < (dimension); i++) {
                if (CallChecker.beforeDeref(v, double[].class, 76, 2573, 2573)) {
                    CallChecker.isCalled(v, double[].class, 76, 2573, 2573)[i] *= f;
                    CallChecker.varAssign(CallChecker.isCalled(v, double[].class, 76, 2573, 2573)[i], "CallChecker.isCalled(v, double[].class, 76, 2573, 2573)[i]", 76, 2573, 2582);
                }
            }
            return v;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4171.methodEnd();
        }
    }
}

