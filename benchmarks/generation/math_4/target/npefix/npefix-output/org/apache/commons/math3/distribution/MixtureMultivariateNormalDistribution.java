package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.Pair;

public class MixtureMultivariateNormalDistribution extends MixtureMultivariateRealDistribution<MultivariateNormalDistribution> {
    public MixtureMultivariateNormalDistribution(double[] weights, double[][] means, double[][][] covariances) {
        super(MixtureMultivariateNormalDistribution.createComponents(weights, means, covariances));
        ConstructorContext _bcornu_methode_context612 = new ConstructorContext(MixtureMultivariateNormalDistribution.class, 44, 1446, 1966);
        try {
        } finally {
            _bcornu_methode_context612.methodEnd();
        }
    }

    public MixtureMultivariateNormalDistribution(List<Pair<Double, MultivariateNormalDistribution>> components) {
        super(components);
        ConstructorContext _bcornu_methode_context613 = new ConstructorContext(MixtureMultivariateNormalDistribution.class, 56, 1973, 2318);
        try {
        } finally {
            _bcornu_methode_context613.methodEnd();
        }
    }

    public MixtureMultivariateNormalDistribution(RandomGenerator rng, List<Pair<Double, MultivariateNormalDistribution>> components) throws DimensionMismatchException, NotPositiveException {
        super(rng, components);
        ConstructorContext _bcornu_methode_context614 = new ConstructorContext(MixtureMultivariateNormalDistribution.class, 70, 2325, 3006);
        try {
        } finally {
            _bcornu_methode_context614.methodEnd();
        }
    }

    private static List<Pair<Double, MultivariateNormalDistribution>> createComponents(double[] weights, double[][] means, double[][][] covariances) {
        MethodContext _bcornu_methode_context2768 = new MethodContext(List.class, 82, 3013, 4014);
        try {
            CallChecker.varInit(covariances, "covariances", 82, 3013, 4014);
            CallChecker.varInit(means, "means", 82, 3013, 4014);
            CallChecker.varInit(weights, "weights", 82, 3013, 4014);
            final List<Pair<Double, MultivariateNormalDistribution>> mvns = CallChecker.varInit(new ArrayList<Pair<Double, MultivariateNormalDistribution>>(), "mvns", 85, 3562, 3699);
            weights = CallChecker.beforeCalled(weights, double[].class, 88, 3730, 3736);
            for (int i = 0; i < (CallChecker.isCalled(weights, double[].class, 88, 3730, 3736).length); i++) {
                means = CallChecker.beforeCalled(means, double[][].class, 90, 3860, 3864);
                covariances = CallChecker.beforeCalled(covariances, double[][][].class, 90, 3870, 3880);
                final MultivariateNormalDistribution dist = CallChecker.varInit(new MultivariateNormalDistribution(CallChecker.isCalled(means, double[][].class, 90, 3860, 3864)[i], CallChecker.isCalled(covariances, double[][][].class, 90, 3870, 3880)[i]), "dist", 89, 3765, 3885);
                if (CallChecker.beforeDeref(weights, double[].class, 92, 3958, 3964)) {
                    if (CallChecker.beforeDeref(mvns, List.class, 92, 3900, 3903)) {
                        weights = CallChecker.beforeCalled(weights, double[].class, 92, 3958, 3964);
                        CallChecker.isCalled(mvns, List.class, 92, 3900, 3903).add(new Pair<Double, MultivariateNormalDistribution>(CallChecker.isCalled(weights, double[].class, 92, 3958, 3964)[i], dist));
                    }
                }
            }
            return mvns;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Pair<Double, MultivariateNormalDistribution>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2768.methodEnd();
        }
    }
}

