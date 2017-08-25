package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public abstract class RandomKey<T> extends AbstractListChromosome<Double> implements PermutationChromosome<T> {
    private final List<Double> sortedRepresentation;

    private final List<Integer> baseSeqPermutation;

    public RandomKey(final List<Double> representation) throws InvalidRepresentationException {
        super(representation);
        ConstructorContext _bcornu_methode_context7 = new ConstructorContext(RandomKey.class, 73, 2802, 3660);
        try {
            List<Double> sortedRepr = CallChecker.varInit(new ArrayList<Double>(getRepresentation()), "sortedRepr", 76, 3217, 3286);
            Collections.sort(sortedRepr);
            sortedRepresentation = Collections.unmodifiableList(sortedRepr);
            CallChecker.varAssign(this.sortedRepresentation, "this.sortedRepresentation", 78, 3334, 3397);
            baseSeqPermutation = Collections.unmodifiableList(RandomKey.decodeGeneric(RandomKey.baseSequence(getLength()), getRepresentation(), sortedRepresentation));
            CallChecker.varAssign(this.baseSeqPermutation, "this.baseSeqPermutation", 80, 3498, 3654);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public RandomKey(final Double[] representation) throws InvalidRepresentationException {
        this(Arrays.asList(representation));
        ConstructorContext _bcornu_methode_context8 = new ConstructorContext(RandomKey.class, 91, 3667, 4046);
        try {
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public List<T> decode(final List<T> sequence) {
        MethodContext _bcornu_methode_context40 = new MethodContext(List.class, 98, 4053, 4225);
        try {
            CallChecker.varInit(this, "this", 98, 4053, 4225);
            CallChecker.varInit(sequence, "sequence", 98, 4053, 4225);
            CallChecker.varInit(this.baseSeqPermutation, "baseSeqPermutation", 98, 4053, 4225);
            CallChecker.varInit(this.sortedRepresentation, "sortedRepresentation", 98, 4053, 4225);
            return RandomKey.decodeGeneric(sequence, getRepresentation(), sortedRepresentation);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    private static <S> List<S> decodeGeneric(final List<S> sequence, List<Double> representation, final List<Double> sortedRepr) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context41 = new MethodContext(List.class, 114, 4232, 5896);
        try {
            CallChecker.varInit(sortedRepr, "sortedRepr", 114, 4232, 5896);
            CallChecker.varInit(representation, "representation", 114, 4232, 5896);
            CallChecker.varInit(sequence, "sequence", 114, 4232, 5896);
            int l = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(sequence, List.class, 118, 5116, 5123)) {
                l = CallChecker.isCalled(sequence, List.class, 118, 5116, 5123).size();
                CallChecker.varAssign(l, "l", 118, 5116, 5123);
            }
            if (CallChecker.beforeDeref(representation, List.class, 121, 5199, 5212)) {
                representation = CallChecker.beforeCalled(representation, List.class, 121, 5199, 5212);
                if ((CallChecker.isCalled(representation, List.class, 121, 5199, 5212).size()) != l) {
                    if (CallChecker.beforeDeref(representation, List.class, 122, 5278, 5291)) {
                        representation = CallChecker.beforeCalled(representation, List.class, 122, 5278, 5291);
                        throw new DimensionMismatchException(CallChecker.isCalled(representation, List.class, 122, 5278, 5291).size(), l);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(sortedRepr, List.class, 124, 5327, 5336)) {
                if ((CallChecker.isCalled(sortedRepr, List.class, 124, 5327, 5336).size()) != l) {
                    if (CallChecker.beforeDeref(sortedRepr, List.class, 125, 5402, 5411)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(sortedRepr, List.class, 125, 5402, 5411).size(), l);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            List<Double> reprCopy = CallChecker.varInit(new ArrayList<Double>(representation), "reprCopy", 129, 5497, 5559);
            List<S> res = CallChecker.varInit(new ArrayList<S>(l), "res", 132, 5650, 5684);
            for (int i = 0; i < l; i++) {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(sortedRepr, List.class, 134, 5761, 5770)) {
                    if (CallChecker.beforeDeref(reprCopy, List.class, 134, 5744, 5751)) {
                        reprCopy = CallChecker.beforeCalled(reprCopy, List.class, 134, 5744, 5751);
                        index = CallChecker.isCalled(reprCopy, List.class, 134, 5744, 5751).indexOf(CallChecker.isCalled(sortedRepr, List.class, 134, 5761, 5770).get(i));
                        CallChecker.varAssign(index, "index", 134, 5761, 5770);
                    }
                }
                if (CallChecker.beforeDeref(sequence, List.class, 135, 5801, 5808)) {
                    if (CallChecker.beforeDeref(res, List.class, 135, 5793, 5795)) {
                        res = CallChecker.beforeCalled(res, List.class, 135, 5793, 5795);
                        CallChecker.isCalled(res, List.class, 135, 5793, 5795).add(sequence.get(index));
                    }
                }
                if (CallChecker.beforeDeref(reprCopy, List.class, 136, 5835, 5842)) {
                    reprCopy = CallChecker.beforeCalled(reprCopy, List.class, 136, 5835, 5842);
                    CallChecker.isCalled(reprCopy, List.class, 136, 5835, 5842).set(index, null);
                }
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    @Override
    protected boolean isSame(final Chromosome another) {
        MethodContext _bcornu_methode_context42 = new MethodContext(boolean.class, 149, 5903, 6956);
        try {
            CallChecker.varInit(this, "this", 149, 5903, 6956);
            CallChecker.varInit(another, "another", 149, 5903, 6956);
            CallChecker.varInit(this.baseSeqPermutation, "baseSeqPermutation", 149, 5903, 6956);
            CallChecker.varInit(this.sortedRepresentation, "sortedRepresentation", 149, 5903, 6956);
            if (!(another instanceof RandomKey<?>)) {
                return false;
            }
            RandomKey<?> anotherRk = CallChecker.varInit(((RandomKey<?>) (another)), "anotherRk", 154, 6332, 6379);
            if (CallChecker.beforeDeref(anotherRk, RandomKey.class, 156, 6430, 6438)) {
                anotherRk = CallChecker.beforeCalled(anotherRk, RandomKey.class, 156, 6430, 6438);
                if ((getLength()) != (CallChecker.isCalled(anotherRk, RandomKey.class, 156, 6430, 6438).getLength())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            List<Integer> thisPerm = CallChecker.varInit(this.baseSeqPermutation, "thisPerm", 162, 6618, 6666);
            List<Integer> anotherPerm = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(anotherRk, RandomKey.class, 163, 6704, 6712)) {
                anotherRk = CallChecker.beforeCalled(anotherRk, RandomKey.class, 163, 6704, 6712);
                anotherPerm = CallChecker.isCalled(anotherRk, RandomKey.class, 163, 6704, 6712).baseSeqPermutation;
                CallChecker.varAssign(anotherPerm, "anotherPerm", 163, 6704, 6712);
            }
            for (int i = 0; i < (getLength()); i++) {
                if (CallChecker.beforeDeref(thisPerm, List.class, 166, 6795, 6802)) {
                    if (CallChecker.beforeDeref(anotherPerm, List.class, 166, 6814, 6824)) {
                        thisPerm = CallChecker.beforeCalled(thisPerm, List.class, 166, 6795, 6802);
                        anotherPerm = CallChecker.beforeCalled(anotherPerm, List.class, 166, 6814, 6824);
                        if ((CallChecker.isCalled(thisPerm, List.class, 166, 6795, 6802).get(i)) != (CallChecker.isCalled(anotherPerm, List.class, 166, 6814, 6824).get(i))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    @Override
    protected void checkValidity(final List<Double> chromosomeRepresentation) throws InvalidRepresentationException {
        MethodContext _bcornu_methode_context43 = new MethodContext(void.class, 178, 6963, 7421);
        try {
            CallChecker.varInit(this, "this", 178, 6963, 7421);
            CallChecker.varInit(chromosomeRepresentation, "chromosomeRepresentation", 178, 6963, 7421);
            CallChecker.varInit(this.baseSeqPermutation, "baseSeqPermutation", 178, 6963, 7421);
            CallChecker.varInit(this.sortedRepresentation, "sortedRepresentation", 178, 6963, 7421);
            if (CallChecker.beforeDeref(chromosomeRepresentation, void.class, 181, 7163, 7186)) {
                for (double val : chromosomeRepresentation) {
                    if ((val < 0) || (val > 1)) {
                        throw new InvalidRepresentationException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, val, 0, 1);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public static final List<Double> randomPermutation(final int l) {
        MethodContext _bcornu_methode_context44 = new MethodContext(List.class, 197, 7429, 7952);
        try {
            CallChecker.varInit(l, "l", 197, 7429, 7952);
            List<Double> repr = CallChecker.varInit(new ArrayList<Double>(l), "repr", 198, 7763, 7807);
            for (int i = 0; i < l; i++) {
                final RandomGenerator npe_invocation_var4 = GeneticAlgorithm.getRandomGenerator();
                if (CallChecker.beforeDeref(npe_invocation_var4, RandomGenerator.class, 200, 7864, 7900)) {
                    if (CallChecker.beforeDeref(repr, List.class, 200, 7855, 7858)) {
                        repr = CallChecker.beforeCalled(repr, List.class, 200, 7855, 7858);
                        CallChecker.isCalled(repr, List.class, 200, 7855, 7858).add(CallChecker.isCalled(npe_invocation_var4, RandomGenerator.class, 200, 7864, 7900).nextDouble());
                    }
                }
            }
            return repr;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public static final List<Double> identityPermutation(final int l) {
        MethodContext _bcornu_methode_context45 = new MethodContext(List.class, 212, 7959, 8451);
        try {
            CallChecker.varInit(l, "l", 212, 7959, 8451);
            List<Double> repr = CallChecker.varInit(new ArrayList<Double>(l), "repr", 213, 8301, 8345);
            for (int i = 0; i < l; i++) {
                if (CallChecker.beforeDeref(repr, List.class, 215, 8393, 8396)) {
                    repr = CallChecker.beforeCalled(repr, List.class, 215, 8393, 8396);
                    CallChecker.isCalled(repr, List.class, 215, 8393, 8396).add((((double) (i)) / l));
                }
            }
            return repr;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public static <S> List<Double> comparatorPermutation(final List<S> data, final Comparator<S> comparator) {
        MethodContext _bcornu_methode_context46 = new MethodContext(List.class, 233, 8458, 9336);
        try {
            CallChecker.varInit(comparator, "comparator", 233, 8458, 9336);
            CallChecker.varInit(data, "data", 233, 8458, 9336);
            List<S> sortedData = CallChecker.varInit(new ArrayList<S>(data), "sortedData", 235, 9183, 9226);
            Collections.sort(sortedData, comparator);
            return RandomKey.inducedPermutation(data, sortedData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public static <S> List<Double> inducedPermutation(final List<S> originalData, final List<S> permutedData) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context47 = new MethodContext(List.class, 258, 9343, 11114);
        try {
            CallChecker.varInit(permutedData, "permutedData", 258, 9343, 11114);
            CallChecker.varInit(originalData, "originalData", 258, 9343, 11114);
            if (CallChecker.beforeDeref(originalData, List.class, 262, 10439, 10450)) {
                if (CallChecker.beforeDeref(permutedData, List.class, 262, 10462, 10473)) {
                    if ((CallChecker.isCalled(originalData, List.class, 262, 10439, 10450).size()) != (CallChecker.isCalled(permutedData, List.class, 262, 10462, 10473).size())) {
                        if (CallChecker.beforeDeref(permutedData, List.class, 263, 10534, 10545)) {
                            if (CallChecker.beforeDeref(originalData, List.class, 263, 10555, 10566)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(permutedData, List.class, 263, 10534, 10545).size(), CallChecker.isCalled(originalData, List.class, 263, 10555, 10566).size());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int l = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(originalData, List.class, 265, 10603, 10614)) {
                l = CallChecker.isCalled(originalData, List.class, 265, 10603, 10614).size();
                CallChecker.varAssign(l, "l", 265, 10603, 10614);
            }
            List<S> origDataCopy = CallChecker.varInit(new ArrayList<S>(originalData), "origDataCopy", 267, 10633, 10687);
            Double[] res = CallChecker.varInit(new Double[l], "res", 269, 10698, 10726);
            for (int i = 0; i < l; i++) {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutedData, List.class, 271, 10807, 10818)) {
                    if (CallChecker.beforeDeref(origDataCopy, List.class, 271, 10786, 10797)) {
                        origDataCopy = CallChecker.beforeCalled(origDataCopy, List.class, 271, 10786, 10797);
                        index = CallChecker.isCalled(origDataCopy, List.class, 271, 10786, 10797).indexOf(permutedData.get(i));
                        CallChecker.varAssign(index, "index", 271, 10807, 10818);
                    }
                }
                if (index == (-1)) {
                    throw new MathIllegalArgumentException(LocalizedFormats.DIFFERENT_ORIG_AND_PERMUTED_DATA);
                }
                if (CallChecker.beforeDeref(res, Double[].class, 275, 10993, 10995)) {
                    res = CallChecker.beforeCalled(res, Double[].class, 275, 10993, 10995);
                    CallChecker.isCalled(res, Double[].class, 275, 10993, 10995)[index] = ((double) (i)) / l;
                    CallChecker.varAssign(CallChecker.isCalled(res, Double[].class, 275, 10993, 10995)[index], "CallChecker.isCalled(res, Double[].class, 275, 10993, 10995)[index]", 275, 10993, 11020);
                }
                if (CallChecker.beforeDeref(origDataCopy, List.class, 276, 11034, 11045)) {
                    origDataCopy.set(index, null);
                }
            }
            return Arrays.asList(res);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context48 = new MethodContext(String.class, 282, 11121, 11248);
        try {
            CallChecker.varInit(this, "this", 282, 11121, 11248);
            CallChecker.varInit(this.baseSeqPermutation, "baseSeqPermutation", 282, 11121, 11248);
            CallChecker.varInit(this.sortedRepresentation, "sortedRepresentation", 282, 11121, 11248);
            return String.format("(f=%s pi=(%s))", getFitness(), baseSeqPermutation);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    private static List<Integer> baseSequence(final int l) {
        MethodContext _bcornu_methode_context49 = new MethodContext(List.class, 292, 11255, 11681);
        try {
            CallChecker.varInit(l, "l", 292, 11255, 11681);
            List<Integer> baseSequence = CallChecker.varInit(new ArrayList<Integer>(l), "baseSequence", 293, 11514, 11569);
            for (int i = 0; i < l; i++) {
                if (CallChecker.beforeDeref(baseSequence, List.class, 295, 11617, 11628)) {
                    baseSequence = CallChecker.beforeCalled(baseSequence, List.class, 295, 11617, 11628);
                    CallChecker.isCalled(baseSequence, List.class, 295, 11617, 11628).add(i);
                }
            }
            return baseSequence;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }
}

