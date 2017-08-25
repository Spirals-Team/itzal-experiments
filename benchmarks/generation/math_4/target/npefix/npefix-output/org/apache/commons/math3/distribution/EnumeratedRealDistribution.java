package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

public class EnumeratedRealDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130308L;

    protected final EnumeratedDistribution<Double> innerDistribution;

    public EnumeratedRealDistribution(final double[] singletons, final double[] probabilities) throws DimensionMismatchException, MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        this(new Well19937c(), singletons, probabilities);
        ConstructorContext _bcornu_methode_context299 = new ConstructorContext(EnumeratedRealDistribution.class, 65, 2097, 3034);
        try {
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    public EnumeratedRealDistribution(final RandomGenerator rng, final double[] singletons, final double[] probabilities) throws DimensionMismatchException, MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context300 = new ConstructorContext(EnumeratedRealDistribution.class, 85, 3041, 4569);
        try {
            if (CallChecker.beforeDeref(singletons, double[].class, 90, 4089, 4098)) {
                if (CallChecker.beforeDeref(probabilities, double[].class, 90, 4110, 4122)) {
                    if ((CallChecker.isCalled(singletons, double[].class, 90, 4089, 4098).length) != (CallChecker.isCalled(probabilities, double[].class, 90, 4110, 4122).length)) {
                        if (CallChecker.beforeDeref(probabilities, double[].class, 91, 4183, 4195)) {
                            if (CallChecker.beforeDeref(singletons, double[].class, 91, 4205, 4214)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(probabilities, double[].class, 91, 4183, 4195).length, CallChecker.isCalled(singletons, double[].class, 91, 4205, 4214).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            List<Pair<Double, Double>> samples = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(singletons, double[].class, 94, 4317, 4326)) {
                samples = new ArrayList<Pair<Double, Double>>(CallChecker.isCalled(singletons, double[].class, 94, 4317, 4326).length);
                CallChecker.varAssign(samples, "samples", 94, 4317, 4326);
            }
            for (int i = 0; i < (CallChecker.isCalled(singletons, double[].class, 96, 4366, 4375).length); i++) {
                if (CallChecker.beforeDeref(singletons, double[].class, 97, 4441, 4450)) {
                    if (CallChecker.beforeDeref(probabilities, double[].class, 97, 4456, 4468)) {
                        if (CallChecker.beforeDeref(samples, List.class, 97, 4404, 4410)) {
                            samples = CallChecker.beforeCalled(samples, List.class, 97, 4404, 4410);
                            CallChecker.isCalled(samples, List.class, 97, 4404, 4410).add(new Pair<Double, Double>(CallChecker.isCalled(singletons, double[].class, 97, 4441, 4450)[i], CallChecker.isCalled(probabilities, double[].class, 97, 4456, 4468)[i]));
                        }
                    }
                }
            }
            innerDistribution = new EnumeratedDistribution<Double>(rng, samples);
            CallChecker.varAssign(this.innerDistribution, "this.innerDistribution", 100, 4495, 4563);
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }

    @Override
    public double probability(final double x) {
        MethodContext _bcornu_methode_context1333 = new MethodContext(double.class, 107, 4576, 4724);
        try {
            CallChecker.varInit(this, "this", 107, 4576, 4724);
            CallChecker.varInit(x, "x", 107, 4576, 4724);
            CallChecker.varInit(this.random, "random", 107, 4576, 4724);
            CallChecker.varInit(this.randomData, "randomData", 107, 4576, 4724);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 107, 4576, 4724);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 107, 4576, 4724);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 107, 4576, 4724);
            if (CallChecker.beforeDeref(innerDistribution, EnumeratedDistribution.class, 108, 4686, 4702)) {
                return CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 108, 4686, 4702).probability(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1333.methodEnd();
        }
    }

    public double density(final double x) {
        MethodContext _bcornu_methode_context1334 = new MethodContext(double.class, 120, 4731, 5218);
        try {
            CallChecker.varInit(this, "this", 120, 4731, 5218);
            CallChecker.varInit(x, "x", 120, 4731, 5218);
            CallChecker.varInit(this.random, "random", 120, 4731, 5218);
            CallChecker.varInit(this.randomData, "randomData", 120, 4731, 5218);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 120, 4731, 5218);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 120, 4731, 5218);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 120, 4731, 5218);
            return probability(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1334.methodEnd();
        }
    }

    public double cumulativeProbability(final double x) {
        MethodContext _bcornu_methode_context1335 = new MethodContext(double.class, 127, 5225, 5575);
        try {
            CallChecker.varInit(this, "this", 127, 5225, 5575);
            CallChecker.varInit(x, "x", 127, 5225, 5575);
            CallChecker.varInit(this.random, "random", 127, 5225, 5575);
            CallChecker.varInit(this.randomData, "randomData", 127, 5225, 5575);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 127, 5225, 5575);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 127, 5225, 5575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 127, 5225, 5575);
            double probability = CallChecker.varInit(((double) (0)), "probability", 128, 5324, 5346);
            for (final Pair<Double, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 130, 5398, 5414).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 131, 5444, 5449)) {
                    if ((CallChecker.isCalled(sample, Pair.class, 131, 5444, 5449).getKey()) <= x) {
                        if (CallChecker.beforeDeref(sample, Pair.class, 132, 5499, 5504)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(sample, Pair.class, 132, 5499, 5504).getValue())), double.class, 132, 5499, 5515)) {
                                if (CallChecker.beforeDeref(sample, Pair.class, 132, 5499, 5504)) {
                                    probability += CallChecker.isCalled(((Double) (CallChecker.isCalled(sample, Pair.class, 132, 5499, 5504).getValue())), double.class, 132, 5499, 5515);
                                    CallChecker.varAssign(probability, "probability", 132, 5484, 5516);
                                }
                            }
                        }
                    }
                }
            }
            return probability;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1335.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1336 = new MethodContext(double.class, 144, 5582, 5920);
        try {
            CallChecker.varInit(this, "this", 144, 5582, 5920);
            CallChecker.varInit(this.random, "random", 144, 5582, 5920);
            CallChecker.varInit(this.randomData, "randomData", 144, 5582, 5920);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 144, 5582, 5920);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 144, 5582, 5920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 144, 5582, 5920);
            double mean = CallChecker.varInit(((double) (0)), "mean", 145, 5730, 5745);
            for (final Pair<Double, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 147, 5797, 5813).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 148, 5847, 5852)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 148, 5867, 5872)) {
                        mean += (CallChecker.isCalled(sample, Pair.class, 148, 5847, 5852).getValue()) * (CallChecker.isCalled(sample, Pair.class, 148, 5867, 5872).getKey());
                        CallChecker.varAssign(mean, "mean", 148, 5839, 5882);
                    }
                }
            }
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1336.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1337 = new MethodContext(double.class, 159, 5927, 6423);
        try {
            CallChecker.varInit(this, "this", 159, 5927, 6423);
            CallChecker.varInit(this.random, "random", 159, 5927, 6423);
            CallChecker.varInit(this.randomData, "randomData", 159, 5927, 6423);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 159, 5927, 6423);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 159, 5927, 6423);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 159, 5927, 6423);
            double mean = CallChecker.varInit(((double) (0)), "mean", 160, 6092, 6107);
            double meanOfSquares = CallChecker.varInit(((double) (0)), "meanOfSquares", 161, 6117, 6141);
            for (final Pair<Double, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 163, 6193, 6209).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 164, 6243, 6248)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 164, 6263, 6268)) {
                        mean += (CallChecker.isCalled(sample, Pair.class, 164, 6243, 6248).getValue()) * (CallChecker.isCalled(sample, Pair.class, 164, 6263, 6268).getKey());
                        CallChecker.varAssign(mean, "mean", 164, 6235, 6278);
                    }
                }
                if (CallChecker.beforeDeref(sample, Pair.class, 165, 6309, 6314)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 165, 6329, 6334)) {
                        if (CallChecker.beforeDeref(sample, Pair.class, 165, 6347, 6352)) {
                            meanOfSquares += ((CallChecker.isCalled(sample, Pair.class, 165, 6309, 6314).getValue()) * (CallChecker.isCalled(sample, Pair.class, 165, 6329, 6334).getKey())) * (CallChecker.isCalled(sample, Pair.class, 165, 6347, 6352).getKey());
                            CallChecker.varAssign(meanOfSquares, "meanOfSquares", 165, 6292, 6362);
                        }
                    }
                }
            }
            return meanOfSquares - (mean * mean);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1337.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context1338 = new MethodContext(double.class, 178, 6430, 6918);
        try {
            CallChecker.varInit(this, "this", 178, 6430, 6918);
            CallChecker.varInit(this.random, "random", 178, 6430, 6918);
            CallChecker.varInit(this.randomData, "randomData", 178, 6430, 6918);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 178, 6430, 6918);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 178, 6430, 6918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 178, 6430, 6918);
            double min = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "min", 179, 6646, 6683);
            for (final Pair<Double, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 180, 6734, 6750).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 181, 6780, 6785)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 181, 6805, 6810)) {
                        if (((CallChecker.isCalled(sample, Pair.class, 181, 6780, 6785).getKey()) < min) && ((CallChecker.isCalled(sample, Pair.class, 181, 6805, 6810).getValue()) > 0)) {
                            if (CallChecker.beforeDeref(sample, Pair.class, 182, 6852, 6857)) {
                                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(sample, Pair.class, 182, 6852, 6857).getKey())), double.class, 182, 6852, 6866)) {
                                    if (CallChecker.beforeDeref(sample, Pair.class, 182, 6852, 6857)) {
                                        min = CallChecker.isCalled(((Double) (CallChecker.isCalled(sample, Pair.class, 182, 6852, 6857).getKey())), double.class, 182, 6852, 6866);
                                        CallChecker.varAssign(min, "min", 182, 6846, 6867);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1338.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context1339 = new MethodContext(double.class, 196, 6925, 7415);
        try {
            CallChecker.varInit(this, "this", 196, 6925, 7415);
            CallChecker.varInit(this.random, "random", 196, 6925, 7415);
            CallChecker.varInit(this.randomData, "randomData", 196, 6925, 7415);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 196, 6925, 7415);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 196, 6925, 7415);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 196, 6925, 7415);
            double max = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "max", 197, 7143, 7180);
            for (final Pair<Double, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 198, 7231, 7247).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 199, 7277, 7282)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 199, 7302, 7307)) {
                        if (((CallChecker.isCalled(sample, Pair.class, 199, 7277, 7282).getKey()) > max) && ((CallChecker.isCalled(sample, Pair.class, 199, 7302, 7307).getValue()) > 0)) {
                            if (CallChecker.beforeDeref(sample, Pair.class, 200, 7349, 7354)) {
                                if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(sample, Pair.class, 200, 7349, 7354).getKey())), double.class, 200, 7349, 7363)) {
                                    if (CallChecker.beforeDeref(sample, Pair.class, 200, 7349, 7354)) {
                                        max = CallChecker.isCalled(((Double) (CallChecker.isCalled(sample, Pair.class, 200, 7349, 7354).getKey())), double.class, 200, 7349, 7363);
                                        CallChecker.varAssign(max, "max", 200, 7343, 7364);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1339.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context1340 = new MethodContext(boolean.class, 214, 7422, 7640);
        try {
            CallChecker.varInit(this, "this", 214, 7422, 7640);
            CallChecker.varInit(this.random, "random", 214, 7422, 7640);
            CallChecker.varInit(this.randomData, "randomData", 214, 7422, 7640);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 214, 7422, 7640);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 214, 7422, 7640);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 214, 7422, 7640);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1340.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context1341 = new MethodContext(boolean.class, 225, 7647, 7865);
        try {
            CallChecker.varInit(this, "this", 225, 7647, 7865);
            CallChecker.varInit(this.random, "random", 225, 7647, 7865);
            CallChecker.varInit(this.randomData, "randomData", 225, 7647, 7865);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 225, 7647, 7865);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 225, 7647, 7865);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 225, 7647, 7865);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1341.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1342 = new MethodContext(boolean.class, 236, 7872, 8068);
        try {
            CallChecker.varInit(this, "this", 236, 7872, 8068);
            CallChecker.varInit(this.random, "random", 236, 7872, 8068);
            CallChecker.varInit(this.randomData, "randomData", 236, 7872, 8068);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 236, 7872, 8068);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 236, 7872, 8068);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 236, 7872, 8068);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1342.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context1343 = new MethodContext(double.class, 244, 8075, 8198);
        try {
            CallChecker.varInit(this, "this", 244, 8075, 8198);
            CallChecker.varInit(this.random, "random", 244, 8075, 8198);
            CallChecker.varInit(this.randomData, "randomData", 244, 8075, 8198);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 244, 8075, 8198);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 244, 8075, 8198);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedRealDistribution.serialVersionUID", 244, 8075, 8198);
            if (CallChecker.beforeDeref(innerDistribution, EnumeratedDistribution.class, 245, 8166, 8182)) {
                return CallChecker.isCalled(((Double) (CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 245, 8166, 8182).sample())), double.class, 245, 8166, 8191);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1343.methodEnd();
        }
    }
}

