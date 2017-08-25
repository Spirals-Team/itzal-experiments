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

public class EnumeratedIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130308L;

    protected final EnumeratedDistribution<Integer> innerDistribution;

    public EnumeratedIntegerDistribution(final int[] singletons, final double[] probabilities) throws DimensionMismatchException, MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        this(new Well19937c(), singletons, probabilities);
        ConstructorContext _bcornu_methode_context319 = new ConstructorContext(EnumeratedIntegerDistribution.class, 65, 2122, 3057);
        try {
        } finally {
            _bcornu_methode_context319.methodEnd();
        }
    }

    public EnumeratedIntegerDistribution(final RandomGenerator rng, final int[] singletons, final double[] probabilities) throws DimensionMismatchException, MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context320 = new ConstructorContext(EnumeratedIntegerDistribution.class, 85, 3064, 4605);
        try {
            if (CallChecker.beforeDeref(singletons, int[].class, 90, 4115, 4124)) {
                if (CallChecker.beforeDeref(probabilities, double[].class, 90, 4136, 4148)) {
                    if ((CallChecker.isCalled(singletons, int[].class, 90, 4115, 4124).length) != (CallChecker.isCalled(probabilities, double[].class, 90, 4136, 4148).length)) {
                        if (CallChecker.beforeDeref(probabilities, double[].class, 91, 4209, 4221)) {
                            if (CallChecker.beforeDeref(singletons, int[].class, 91, 4231, 4240)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(probabilities, double[].class, 91, 4209, 4221).length, CallChecker.isCalled(singletons, int[].class, 91, 4231, 4240).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final List<Pair<Integer, Double>> samples = CallChecker.varInit(new ArrayList<Pair<Integer, Double>>(CallChecker.isCalled(singletons, int[].class, 94, 4351, 4360).length), "samples", 94, 4270, 4369);
            for (int i = 0; i < (CallChecker.isCalled(singletons, int[].class, 96, 4400, 4409).length); i++) {
                if (CallChecker.beforeDeref(singletons, int[].class, 97, 4476, 4485)) {
                    if (CallChecker.beforeDeref(probabilities, double[].class, 97, 4491, 4503)) {
                        if (CallChecker.beforeDeref(samples, List.class, 97, 4438, 4444)) {
                            CallChecker.isCalled(samples, List.class, 97, 4438, 4444).add(new Pair<Integer, Double>(CallChecker.isCalled(singletons, int[].class, 97, 4476, 4485)[i], CallChecker.isCalled(probabilities, double[].class, 97, 4491, 4503)[i]));
                        }
                    }
                }
            }
            innerDistribution = new EnumeratedDistribution<Integer>(rng, samples);
            CallChecker.varAssign(this.innerDistribution, "this.innerDistribution", 100, 4530, 4599);
        } finally {
            _bcornu_methode_context320.methodEnd();
        }
    }

    public double probability(final int x) {
        MethodContext _bcornu_methode_context1473 = new MethodContext(double.class, 106, 4612, 4743);
        try {
            CallChecker.varInit(this, "this", 106, 4612, 4743);
            CallChecker.varInit(x, "x", 106, 4612, 4743);
            CallChecker.varInit(this.random, "random", 106, 4612, 4743);
            CallChecker.varInit(this.randomData, "randomData", 106, 4612, 4743);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 106, 4612, 4743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 106, 4612, 4743);
            if (CallChecker.beforeDeref(innerDistribution, EnumeratedDistribution.class, 107, 4705, 4721)) {
                return CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 107, 4705, 4721).probability(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1473.methodEnd();
        }
    }

    public double cumulativeProbability(final int x) {
        MethodContext _bcornu_methode_context1474 = new MethodContext(double.class, 113, 4750, 5098);
        try {
            CallChecker.varInit(this, "this", 113, 4750, 5098);
            CallChecker.varInit(x, "x", 113, 4750, 5098);
            CallChecker.varInit(this.random, "random", 113, 4750, 5098);
            CallChecker.varInit(this.randomData, "randomData", 113, 4750, 5098);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 113, 4750, 5098);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 113, 4750, 5098);
            double probability = CallChecker.varInit(((double) (0)), "probability", 114, 4846, 4868);
            for (final Pair<Integer, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 116, 4921, 4937).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 117, 4967, 4972)) {
                    if ((CallChecker.isCalled(sample, Pair.class, 117, 4967, 4972).getKey()) <= x) {
                        if (CallChecker.beforeDeref(sample, Pair.class, 118, 5022, 5027)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(sample, Pair.class, 118, 5022, 5027).getValue())), double.class, 118, 5022, 5038)) {
                                if (CallChecker.beforeDeref(sample, Pair.class, 118, 5022, 5027)) {
                                    probability += CallChecker.isCalled(((Double) (CallChecker.isCalled(sample, Pair.class, 118, 5022, 5027).getValue())), double.class, 118, 5022, 5038);
                                    CallChecker.varAssign(probability, "probability", 118, 5007, 5039);
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
            _bcornu_methode_context1474.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1475 = new MethodContext(double.class, 130, 5105, 5444);
        try {
            CallChecker.varInit(this, "this", 130, 5105, 5444);
            CallChecker.varInit(this.random, "random", 130, 5105, 5444);
            CallChecker.varInit(this.randomData, "randomData", 130, 5105, 5444);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 130, 5105, 5444);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 130, 5105, 5444);
            double mean = CallChecker.varInit(((double) (0)), "mean", 131, 5253, 5268);
            for (final Pair<Integer, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 133, 5321, 5337).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 134, 5371, 5376)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 134, 5391, 5396)) {
                        mean += (CallChecker.isCalled(sample, Pair.class, 134, 5371, 5376).getValue()) * (CallChecker.isCalled(sample, Pair.class, 134, 5391, 5396).getKey());
                        CallChecker.varAssign(mean, "mean", 134, 5363, 5406);
                    }
                }
            }
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1475.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1476 = new MethodContext(double.class, 145, 5451, 5948);
        try {
            CallChecker.varInit(this, "this", 145, 5451, 5948);
            CallChecker.varInit(this.random, "random", 145, 5451, 5948);
            CallChecker.varInit(this.randomData, "randomData", 145, 5451, 5948);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 145, 5451, 5948);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 145, 5451, 5948);
            double mean = CallChecker.varInit(((double) (0)), "mean", 146, 5616, 5631);
            double meanOfSquares = CallChecker.varInit(((double) (0)), "meanOfSquares", 147, 5641, 5665);
            for (final Pair<Integer, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 149, 5718, 5734).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 150, 5768, 5773)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 150, 5788, 5793)) {
                        mean += (CallChecker.isCalled(sample, Pair.class, 150, 5768, 5773).getValue()) * (CallChecker.isCalled(sample, Pair.class, 150, 5788, 5793).getKey());
                        CallChecker.varAssign(mean, "mean", 150, 5760, 5803);
                    }
                }
                if (CallChecker.beforeDeref(sample, Pair.class, 151, 5834, 5839)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 151, 5854, 5859)) {
                        if (CallChecker.beforeDeref(sample, Pair.class, 151, 5872, 5877)) {
                            meanOfSquares += ((CallChecker.isCalled(sample, Pair.class, 151, 5834, 5839).getValue()) * (CallChecker.isCalled(sample, Pair.class, 151, 5854, 5859).getKey())) * (CallChecker.isCalled(sample, Pair.class, 151, 5872, 5877).getKey());
                            CallChecker.varAssign(meanOfSquares, "meanOfSquares", 151, 5817, 5887);
                        }
                    }
                }
            }
            return meanOfSquares - (mean * mean);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1476.methodEnd();
        }
    }

    public int getSupportLowerBound() {
        MethodContext _bcornu_methode_context1477 = new MethodContext(int.class, 164, 5955, 6431);
        try {
            CallChecker.varInit(this, "this", 164, 5955, 6431);
            CallChecker.varInit(this.random, "random", 164, 5955, 6431);
            CallChecker.varInit(this.randomData, "randomData", 164, 5955, 6431);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 164, 5955, 6431);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 164, 5955, 6431);
            int min = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "min", 165, 6168, 6195);
            for (final Pair<Integer, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 166, 6247, 6263).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 167, 6293, 6298)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 167, 6318, 6323)) {
                        if (((CallChecker.isCalled(sample, Pair.class, 167, 6293, 6298).getKey()) < min) && ((CallChecker.isCalled(sample, Pair.class, 167, 6318, 6323).getValue()) > 0)) {
                            if (CallChecker.beforeDeref(sample, Pair.class, 168, 6365, 6370)) {
                                if (CallChecker.beforeDeref(((Integer) (CallChecker.isCalled(sample, Pair.class, 168, 6365, 6370).getKey())), int.class, 168, 6365, 6379)) {
                                    if (CallChecker.beforeDeref(sample, Pair.class, 168, 6365, 6370)) {
                                        min = CallChecker.isCalled(((Integer) (CallChecker.isCalled(sample, Pair.class, 168, 6365, 6370).getKey())), int.class, 168, 6365, 6379);
                                        CallChecker.varAssign(min, "min", 168, 6359, 6380);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1477.methodEnd();
        }
    }

    public int getSupportUpperBound() {
        MethodContext _bcornu_methode_context1478 = new MethodContext(int.class, 182, 6438, 6916);
        try {
            CallChecker.varInit(this, "this", 182, 6438, 6916);
            CallChecker.varInit(this.random, "random", 182, 6438, 6916);
            CallChecker.varInit(this.randomData, "randomData", 182, 6438, 6916);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 182, 6438, 6916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 182, 6438, 6916);
            int max = CallChecker.varInit(((int) (Integer.MIN_VALUE)), "max", 183, 6653, 6680);
            for (final Pair<Integer, Double> sample : CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 184, 6732, 6748).getPmf()) {
                if (CallChecker.beforeDeref(sample, Pair.class, 185, 6778, 6783)) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 185, 6803, 6808)) {
                        if (((CallChecker.isCalled(sample, Pair.class, 185, 6778, 6783).getKey()) > max) && ((CallChecker.isCalled(sample, Pair.class, 185, 6803, 6808).getValue()) > 0)) {
                            if (CallChecker.beforeDeref(sample, Pair.class, 186, 6850, 6855)) {
                                if (CallChecker.beforeDeref(((Integer) (CallChecker.isCalled(sample, Pair.class, 186, 6850, 6855).getKey())), int.class, 186, 6850, 6864)) {
                                    if (CallChecker.beforeDeref(sample, Pair.class, 186, 6850, 6855)) {
                                        max = CallChecker.isCalled(((Integer) (CallChecker.isCalled(sample, Pair.class, 186, 6850, 6855).getKey())), int.class, 186, 6850, 6864);
                                        CallChecker.varAssign(max, "max", 186, 6844, 6865);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1478.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1479 = new MethodContext(boolean.class, 200, 6923, 7119);
        try {
            CallChecker.varInit(this, "this", 200, 6923, 7119);
            CallChecker.varInit(this.random, "random", 200, 6923, 7119);
            CallChecker.varInit(this.randomData, "randomData", 200, 6923, 7119);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 200, 6923, 7119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 200, 6923, 7119);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1479.methodEnd();
        }
    }

    @Override
    public int sample() {
        MethodContext _bcornu_methode_context1480 = new MethodContext(int.class, 208, 7126, 7246);
        try {
            CallChecker.varInit(this, "this", 208, 7126, 7246);
            CallChecker.varInit(this.random, "random", 208, 7126, 7246);
            CallChecker.varInit(this.randomData, "randomData", 208, 7126, 7246);
            CallChecker.varInit(this.innerDistribution, "innerDistribution", 208, 7126, 7246);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedIntegerDistribution.serialVersionUID", 208, 7126, 7246);
            if (CallChecker.beforeDeref(innerDistribution, EnumeratedDistribution.class, 209, 7214, 7230)) {
                return CallChecker.isCalled(((Integer) (CallChecker.isCalled(innerDistribution, EnumeratedDistribution.class, 209, 7214, 7230).sample())), int.class, 209, 7214, 7239);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1480.methodEnd();
        }
    }
}

