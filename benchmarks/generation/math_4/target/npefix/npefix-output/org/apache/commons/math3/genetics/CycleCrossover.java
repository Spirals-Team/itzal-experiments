package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class CycleCrossover<T> implements CrossoverPolicy {
    private final boolean randomStart;

    public CycleCrossover() {
        this(false);
        ConstructorContext _bcornu_methode_context202 = new ConstructorContext(CycleCrossover.class, 74, 2831, 2950);
        try {
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }

    public CycleCrossover(final boolean randomStart) {
        ConstructorContext _bcornu_methode_context203 = new ConstructorContext(CycleCrossover.class, 83, 2957, 3262);
        try {
            this.randomStart = randomStart;
            CallChecker.varAssign(this.randomStart, "this.randomStart", 84, 3226, 3256);
        } finally {
            _bcornu_methode_context203.methodEnd();
        }
    }

    public boolean isRandomStart() {
        MethodContext _bcornu_methode_context816 = new MethodContext(boolean.class, 92, 3269, 3528);
        try {
            CallChecker.varInit(this, "this", 92, 3269, 3528);
            CallChecker.varInit(this.randomStart, "randomStart", 92, 3269, 3528);
            return randomStart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context816.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public ChromosomePair crossover(final Chromosome first, final Chromosome second) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context817 = new MethodContext(ChromosomePair.class, 103, 3535, 4295);
        try {
            CallChecker.varInit(this, "this", 103, 3535, 4295);
            CallChecker.varInit(second, "second", 103, 3535, 4295);
            CallChecker.varInit(first, "first", 103, 3535, 4295);
            CallChecker.varInit(this.randomStart, "randomStart", 103, 3535, 4295);
            if (!((first instanceof AbstractListChromosome<?>) && (second instanceof AbstractListChromosome<?>))) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME);
            }
            return mate(((AbstractListChromosome<T>) (first)), ((AbstractListChromosome<T>) (second)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context817.methodEnd();
        }
    }

    protected ChromosomePair mate(final AbstractListChromosome<T> first, final AbstractListChromosome<T> second) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context818 = new MethodContext(ChromosomePair.class, 120, 4302, 7285);
        try {
            CallChecker.varInit(this, "this", 120, 4302, 7285);
            CallChecker.varInit(second, "second", 120, 4302, 7285);
            CallChecker.varInit(first, "first", 120, 4302, 7285);
            CallChecker.varInit(this.randomStart, "randomStart", 120, 4302, 7285);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(first, AbstractListChromosome.class, 123, 4851, 4855).getLength())), "length", 123, 4832, 4868);
            if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 124, 4892, 4897)) {
                if (length != (CallChecker.isCalled(second, AbstractListChromosome.class, 124, 4892, 4897).getLength())) {
                    if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 125, 4963, 4968)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(second, AbstractListChromosome.class, 125, 4963, 4968).getLength(), length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final List<T> parent1Rep = CallChecker.varInit(CallChecker.isCalled(first, AbstractListChromosome.class, 129, 5086, 5090).getRepresentation(), "parent1Rep", 129, 5011, 5111);
            final List<T> parent2Rep = CallChecker.varInit(CallChecker.isCalled(second, AbstractListChromosome.class, 130, 5148, 5153).getRepresentation(), "parent2Rep", 130, 5121, 5174);
            final List<T> child1Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(second, AbstractListChromosome.class, 132, 5312, 5317).getRepresentation()), "child1Rep", 132, 5184, 5339);
            final List<T> child2Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(first, AbstractListChromosome.class, 133, 5392, 5396).getRepresentation()), "child2Rep", 133, 5349, 5418);
            final Set<Integer> visitedIndices = CallChecker.varInit(new HashSet<Integer>(length), "visitedIndices", 136, 5429, 5542);
            final List<Integer> indices = CallChecker.varInit(new ArrayList<Integer>(length), "indices", 138, 5552, 5656);
            int idx = CallChecker.init(int.class);
            if (randomStart) {
                final RandomGenerator npe_invocation_var93 = GeneticAlgorithm.getRandomGenerator();
                if (CallChecker.beforeDeref(npe_invocation_var93, RandomGenerator.class, 141, 5731, 5767)) {
                    idx = CallChecker.isCalled(npe_invocation_var93, RandomGenerator.class, 141, 5731, 5767).nextInt(length);
                    CallChecker.varAssign(idx, "idx", 141, 5717, 5787);
                }
            }else {
                idx = 0;
                CallChecker.varAssign(idx, "idx", 141, 5717, 5787);
            }
            int cycle = CallChecker.varInit(((int) (1)), "cycle", 142, 5798, 5811);
            while ((CallChecker.isCalled(visitedIndices, Set.class, 144, 5829, 5842).size()) < length) {
                if (CallChecker.beforeDeref(indices, List.class, 145, 5875, 5881)) {
                    CallChecker.isCalled(indices, List.class, 145, 5875, 5881).add(idx);
                }
                T item = CallChecker.init(null);
                if (CallChecker.beforeDeref(parent2Rep, List.class, 147, 5915, 5924)) {
                    item = parent2Rep.get(idx);
                    CallChecker.varAssign(item, "item", 147, 5915, 5924);
                }
                if (CallChecker.beforeDeref(parent1Rep, List.class, 148, 5954, 5963)) {
                    idx = CallChecker.isCalled(parent1Rep, List.class, 148, 5954, 5963).indexOf(item);
                    CallChecker.varAssign(idx, "idx", 148, 5948, 5978);
                }
                while (idx != (CallChecker.isCalled(indices, List.class, 150, 6007, 6013).get(0))) {
                    if (CallChecker.beforeDeref(indices, List.class, 152, 6096, 6102)) {
                        CallChecker.isCalled(indices, List.class, 152, 6096, 6102).add(idx);
                    }
                    if (CallChecker.beforeDeref(parent2Rep, List.class, 154, 6204, 6213)) {
                        item = parent2Rep.get(idx);
                        CallChecker.varAssign(item, "item", 154, 6197, 6223);
                    }
                    if (CallChecker.beforeDeref(parent1Rep, List.class, 156, 6313, 6322)) {
                        idx = CallChecker.isCalled(parent1Rep, List.class, 156, 6313, 6322).indexOf(item);
                        CallChecker.varAssign(idx, "idx", 156, 6307, 6337);
                    }
                } 
                if (((cycle++) % 2) != 0) {
                    if (CallChecker.beforeDeref(indices, ChromosomePair.class, 161, 6510, 6516)) {
                        for (int i : indices) {
                            T tmp = CallChecker.init(null);
                            if (CallChecker.beforeDeref(child1Rep, List.class, 162, 6549, 6557)) {
                                tmp = child1Rep.get(i);
                                CallChecker.varAssign(tmp, "tmp", 162, 6549, 6557);
                            }
                            if (CallChecker.beforeDeref(child2Rep, List.class, 163, 6604, 6612)) {
                                if (CallChecker.beforeDeref(child1Rep, List.class, 163, 6587, 6595)) {
                                    child1Rep.set(i, child2Rep.get(i));
                                }
                            }
                            if (CallChecker.beforeDeref(child2Rep, List.class, 164, 6643, 6651)) {
                                child2Rep.set(i, tmp);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(visitedIndices, Set.class, 168, 6711, 6724)) {
                    CallChecker.isCalled(visitedIndices, Set.class, 168, 6711, 6724).addAll(indices);
                }
                if (CallChecker.beforeDeref(indices, List.class, 170, 6849, 6855)) {
                    idx = ((CallChecker.isCalled(indices, List.class, 170, 6849, 6855).get(0)) + 1) % length;
                    CallChecker.varAssign(idx, "idx", 170, 6842, 6877);
                }
                while ((CallChecker.isCalled(visitedIndices, Set.class, 171, 6898, 6911).contains(idx)) && ((CallChecker.isCalled(visitedIndices, Set.class, 171, 6930, 6943).size()) < length)) {
                    idx++;
                    if (idx >= length) {
                        idx = 0;
                        CallChecker.varAssign(idx, "idx", 174, 7044, 7051);
                    }
                } 
                if (CallChecker.beforeDeref(indices, List.class, 177, 7097, 7103)) {
                    CallChecker.isCalled(indices, List.class, 177, 7097, 7103).clear();
                }
            } 
            if (CallChecker.beforeDeref(first, AbstractListChromosome.class, 180, 7159, 7163)) {
                if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 181, 7236, 7241)) {
                    return new ChromosomePair(CallChecker.isCalled(first, AbstractListChromosome.class, 180, 7159, 7163).newFixedLengthChromosome(child1Rep), CallChecker.isCalled(second, AbstractListChromosome.class, 181, 7236, 7241).newFixedLengthChromosome(child2Rep));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context818.methodEnd();
        }
    }
}

