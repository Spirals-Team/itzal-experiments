package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

public class EnumeratedDistribution<T> implements Serializable {
    private static final long serialVersionUID = 20123308L;

    protected final RandomGenerator random;

    private final List<T> singletons;

    private final double[] probabilities;

    public EnumeratedDistribution(final List<Pair<T, Double>> pmf) throws MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        this(new Well19937c(), pmf);
        ConstructorContext _bcornu_methode_context792 = new ConstructorContext(EnumeratedDistribution.class, 86, 3390, 4132);
        try {
        } finally {
            _bcornu_methode_context792.methodEnd();
        }
    }

    public EnumeratedDistribution(final RandomGenerator rng, final List<Pair<T, Double>> pmf) throws MathArithmeticException, NotANumberException, NotFiniteNumberException, NotPositiveException {
        ConstructorContext _bcornu_methode_context793 = new ConstructorContext(EnumeratedDistribution.class, 103, 4139, 5680);
        try {
            random = rng;
            CallChecker.varAssign(this.random, "this.random", 105, 4946, 4958);
            singletons = new ArrayList<T>(CallChecker.isCalled(pmf, List.class, 107, 4999, 5001).size());
            CallChecker.varAssign(this.singletons, "this.singletons", 107, 4969, 5010);
            final double[] probs = CallChecker.varInit(new double[CallChecker.isCalled(pmf, List.class, 108, 5054, 5056).size()], "probs", 108, 5020, 5065);
            for (int i = 0; i < (CallChecker.isCalled(pmf, List.class, 110, 5096, 5098).size()); i++) {
                final Pair<T, Double> sample = CallChecker.varInit(CallChecker.isCalled(pmf, List.class, 111, 5158, 5160).get(i), "sample", 111, 5127, 5168);
                if (CallChecker.beforeDeref(sample, Pair.class, 112, 5197, 5202)) {
                    if (CallChecker.beforeDeref(singletons, List.class, 112, 5182, 5191)) {
                        CallChecker.isCalled(singletons, List.class, 112, 5182, 5191).add(sample.getKey());
                    }
                }
                double p = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(sample, Pair.class, 113, 5244, 5249)) {
                    if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(sample, Pair.class, 113, 5244, 5249).getValue())), double.class, 113, 5244, 5260)) {
                        if (CallChecker.beforeDeref(sample, Pair.class, 113, 5244, 5249)) {
                            p = CallChecker.isCalled(((Double) (CallChecker.isCalled(sample, Pair.class, 113, 5244, 5249).getValue())), double.class, 113, 5244, 5260);
                            CallChecker.varAssign(p, "p", 113, 5244, 5260);
                        }
                    }
                }
                if (p < 0) {
                    if (CallChecker.beforeDeref(sample, Pair.class, 115, 5335, 5340)) {
                        throw new NotPositiveException(CallChecker.isCalled(sample, Pair.class, 115, 5335, 5340).getValue());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (Double.isInfinite(p)) {
                    throw new NotFiniteNumberException(p);
                }
                if (Double.isNaN(p)) {
                    throw new NotANumberException();
                }
                if (CallChecker.beforeDeref(probs, double[].class, 123, 5588, 5592)) {
                    CallChecker.isCalled(probs, double[].class, 123, 5588, 5592)[i] = p;
                    CallChecker.varAssign(CallChecker.isCalled(probs, double[].class, 123, 5588, 5592)[i], "CallChecker.isCalled(probs, double[].class, 123, 5588, 5592)[i]", 123, 5588, 5600);
                }
            }
            probabilities = MathArrays.normalizeArray(probs, 1.0);
            CallChecker.varAssign(this.probabilities, "this.probabilities", 126, 5621, 5674);
        } finally {
            _bcornu_methode_context793.methodEnd();
        }
    }

    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context3491 = new MethodContext(void.class, 134, 5687, 5884);
        try {
            CallChecker.varInit(this, "this", 134, 5687, 5884);
            CallChecker.varInit(seed, "seed", 134, 5687, 5884);
            CallChecker.varInit(this.probabilities, "probabilities", 134, 5687, 5884);
            CallChecker.varInit(this.singletons, "singletons", 134, 5687, 5884);
            CallChecker.varInit(this.random, "random", 134, 5687, 5884);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 134, 5687, 5884);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 135, 5858, 5863)) {
                CallChecker.isCalled(random, RandomGenerator.class, 135, 5858, 5863).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3491.methodEnd();
        }
    }

    double probability(final T x) {
        MethodContext _bcornu_methode_context3492 = new MethodContext(double.class, 150, 5891, 6818);
        try {
            CallChecker.varInit(this, "this", 150, 5891, 6818);
            CallChecker.varInit(x, "x", 150, 5891, 6818);
            CallChecker.varInit(this.probabilities, "probabilities", 150, 5891, 6818);
            CallChecker.varInit(this.singletons, "singletons", 150, 5891, 6818);
            CallChecker.varInit(this.random, "random", 150, 5891, 6818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 150, 5891, 6818);
            double probability = CallChecker.varInit(((double) (0)), "probability", 151, 6508, 6530);
            for (int i = 0; i < (CallChecker.isCalled(probabilities, double[].class, 153, 6561, 6573).length); i++) {
                if (CallChecker.beforeDeref(singletons, List.class, 154, 6620, 6629)) {
                    if (CallChecker.beforeDeref(singletons, List.class, 155, 6689, 6698)) {
                        if (((x == null) && ((singletons.get(i)) == null)) || ((x != null) && (x.equals(singletons.get(i))))) {
                            if (CallChecker.beforeDeref(probabilities, double[].class, 156, 6743, 6755)) {
                                probability += CallChecker.isCalled(probabilities, double[].class, 156, 6743, 6755)[i];
                                CallChecker.varAssign(probability, "probability", 156, 6728, 6759);
                            }
                        }
                    }
                }
            }
            return probability;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3492.methodEnd();
        }
    }

    public List<Pair<T, Double>> getPmf() {
        MethodContext _bcornu_methode_context3493 = new MethodContext(List.class, 173, 6825, 7653);
        try {
            CallChecker.varInit(this, "this", 173, 6825, 7653);
            CallChecker.varInit(this.probabilities, "probabilities", 173, 6825, 7653);
            CallChecker.varInit(this.singletons, "singletons", 173, 6825, 7653);
            CallChecker.varInit(this.random, "random", 173, 6825, 7653);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 173, 6825, 7653);
            final List<Pair<T, Double>> samples = CallChecker.varInit(new ArrayList<Pair<T, Double>>(CallChecker.isCalled(probabilities, double[].class, 174, 7450, 7462).length), "samples", 174, 7381, 7471);
            for (int i = 0; i < (CallChecker.isCalled(probabilities, double[].class, 176, 7502, 7514).length); i++) {
                if (CallChecker.beforeDeref(singletons, List.class, 177, 7575, 7584)) {
                    if (CallChecker.beforeDeref(probabilities, double[].class, 177, 7594, 7606)) {
                        if (CallChecker.beforeDeref(samples, List.class, 177, 7543, 7549)) {
                            CallChecker.isCalled(samples, List.class, 177, 7543, 7549).add(new Pair<T, Double>(singletons.get(i), CallChecker.isCalled(probabilities, double[].class, 177, 7594, 7606)[i]));
                        }
                    }
                }
            }
            return samples;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Pair<T, Double>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3493.methodEnd();
        }
    }

    public T sample() {
        MethodContext _bcornu_methode_context3494 = new MethodContext(null, 188, 7660, 8333);
        try {
            CallChecker.varInit(this, "this", 188, 7660, 8333);
            CallChecker.varInit(this.probabilities, "probabilities", 188, 7660, 8333);
            CallChecker.varInit(this.singletons, "singletons", 188, 7660, 8333);
            CallChecker.varInit(this.random, "random", 188, 7660, 8333);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 188, 7660, 8333);
            final double randomValue = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 189, 7832, 7837).nextDouble())), "randomValue", 189, 7805, 7851);
            double sum = CallChecker.varInit(((double) (0)), "sum", 190, 7861, 7875);
            for (int i = 0; i < (CallChecker.isCalled(probabilities, double[].class, 192, 7906, 7918).length); i++) {
                if (CallChecker.beforeDeref(probabilities, double[].class, 193, 7954, 7966)) {
                    sum += CallChecker.isCalled(probabilities, double[].class, 193, 7954, 7966)[i];
                    CallChecker.varAssign(sum, "sum", 193, 7947, 7970);
                }
                if (randomValue < sum) {
                    if (CallChecker.beforeDeref(singletons, List.class, 195, 8032, 8041)) {
                        return singletons.get(i);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(singletons, List.class, 202, 8290, 8299)) {
                return singletons.get(((CallChecker.isCalled(singletons, List.class, 202, 8305, 8314).size()) - 1));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3494.methodEnd();
        }
    }

    public Object[] sample(int sampleSize) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3495 = new MethodContext(Object[].class, 213, 8340, 9037);
        try {
            CallChecker.varInit(this, "this", 213, 8340, 9037);
            CallChecker.varInit(sampleSize, "sampleSize", 213, 8340, 9037);
            CallChecker.varInit(this.probabilities, "probabilities", 213, 8340, 9037);
            CallChecker.varInit(this.singletons, "singletons", 213, 8340, 9037);
            CallChecker.varInit(this.random, "random", 213, 8340, 9037);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 213, 8340, 9037);
            if (sampleSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            final Object[] out = CallChecker.varInit(new Object[sampleSize], "out", 219, 8877, 8920);
            for (int i = 0; i < sampleSize; i++) {
                if (CallChecker.beforeDeref(out, Object[].class, 222, 8982, 8984)) {
                    CallChecker.isCalled(out, Object[].class, 222, 8982, 8984)[i] = sample();
                    CallChecker.varAssign(CallChecker.isCalled(out, Object[].class, 222, 8982, 8984)[i], "CallChecker.isCalled(out, Object[].class, 222, 8982, 8984)[i]", 222, 8982, 8999);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3495.methodEnd();
        }
    }

    public T[] sample(int sampleSize, final T[] array) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3496 = new MethodContext(null, 242, 9044, 10436);
        try {
            CallChecker.varInit(this, "this", 242, 9044, 10436);
            CallChecker.varInit(array, "array", 242, 9044, 10436);
            CallChecker.varInit(sampleSize, "sampleSize", 242, 9044, 10436);
            CallChecker.varInit(this.probabilities, "probabilities", 242, 9044, 10436);
            CallChecker.varInit(this.singletons, "singletons", 242, 9044, 10436);
            CallChecker.varInit(this.random, "random", 242, 9044, 10436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.EnumeratedDistribution.serialVersionUID", 242, 9044, 10436);
            if (sampleSize <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, sampleSize);
            }
            if (array == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            T[] out = CallChecker.init(null);
            if ((array.length) < sampleSize) {
                @SuppressWarnings(value = "unchecked")
                final T[] unchecked = CallChecker.varInit(((T[]) (Array.newInstance(CallChecker.isCalled(array.getClass(), Class.class, 254, 10190, 10205).getComponentType(), sampleSize))), "unchecked", 254, 10071, 10238);
                out = unchecked;
                CallChecker.varAssign(out, "out", 255, 10252, 10267);
            }else {
                out = array;
                CallChecker.varAssign(out, "out", 257, 10298, 10309);
            }
            for (int i = 0; i < sampleSize; i++) {
                if (CallChecker.beforeDeref(out, null, 261, 10381, 10383)) {
                    out[i] = sample();
                    CallChecker.varAssign(out[i], "out[i]", 261, 10381, 10398);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3496.methodEnd();
        }
    }
}

