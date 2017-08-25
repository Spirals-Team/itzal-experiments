package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

public class OrderedCrossover<T> implements CrossoverPolicy {
    @SuppressWarnings(value = "unchecked")
    public ChromosomePair crossover(final Chromosome first, final Chromosome second) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context5315 = new MethodContext(ChromosomePair.class, 71, 2639, 3415);
        try {
            CallChecker.varInit(this, "this", 71, 2639, 3415);
            CallChecker.varInit(second, "second", 71, 2639, 3415);
            CallChecker.varInit(first, "first", 71, 2639, 3415);
            if (!((first instanceof AbstractListChromosome<?>) && (second instanceof AbstractListChromosome<?>))) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME);
            }
            return mate(((AbstractListChromosome<T>) (first)), ((AbstractListChromosome<T>) (second)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5315.methodEnd();
        }
    }

    protected ChromosomePair mate(final AbstractListChromosome<T> first, final AbstractListChromosome<T> second) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5316 = new MethodContext(ChromosomePair.class, 88, 3422, 6326);
        try {
            CallChecker.varInit(this, "this", 88, 3422, 6326);
            CallChecker.varInit(second, "second", 88, 3422, 6326);
            CallChecker.varInit(first, "first", 88, 3422, 6326);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(first, AbstractListChromosome.class, 91, 3971, 3975).getLength())), "length", 91, 3952, 3988);
            if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 92, 4012, 4017)) {
                if (length != (CallChecker.isCalled(second, AbstractListChromosome.class, 92, 4012, 4017).getLength())) {
                    if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 93, 4083, 4088)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(second, AbstractListChromosome.class, 93, 4083, 4088).getLength(), length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final List<T> parent1Rep = CallChecker.varInit(CallChecker.isCalled(first, AbstractListChromosome.class, 97, 4206, 4210).getRepresentation(), "parent1Rep", 97, 4131, 4231);
            final List<T> parent2Rep = CallChecker.varInit(CallChecker.isCalled(second, AbstractListChromosome.class, 98, 4268, 4273).getRepresentation(), "parent2Rep", 98, 4241, 4294);
            final List<T> child1 = CallChecker.varInit(new ArrayList<T>(length), "child1", 100, 4304, 4382);
            final List<T> child2 = CallChecker.varInit(new ArrayList<T>(length), "child2", 101, 4392, 4439);
            final Set<T> child1Set = CallChecker.varInit(new HashSet<T>(length), "child1Set", 103, 4449, 4555);
            final Set<T> child2Set = CallChecker.varInit(new HashSet<T>(length), "child2Set", 104, 4565, 4612);
            final RandomGenerator random = CallChecker.varInit(GeneticAlgorithm.getRandomGenerator(), "random", 106, 4623, 4691);
            int a = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(random, RandomGenerator.class, 108, 4768, 4773)) {
                a = CallChecker.isCalled(random, RandomGenerator.class, 108, 4768, 4773).nextInt(length);
                CallChecker.varAssign(a, "a", 108, 4768, 4773);
            }
            int b = CallChecker.init(int.class);
            do {
                if (CallChecker.beforeDeref(random, RandomGenerator.class, 111, 4836, 4841)) {
                    b = CallChecker.isCalled(random, RandomGenerator.class, 111, 4836, 4841).nextInt(length);
                    CallChecker.varAssign(b, "b", 111, 4832, 4858);
                }
            } while (a == b );
            final int lb = CallChecker.varInit(((int) (FastMath.min(a, b))), "lb", 114, 4894, 4975);
            final int ub = CallChecker.varInit(((int) (FastMath.max(a, b))), "ub", 115, 4985, 5018);
            if (CallChecker.beforeDeref(parent1Rep, List.class, 118, 5098, 5107)) {
                if (CallChecker.beforeDeref(child1, List.class, 118, 5084, 5089)) {
                    CallChecker.isCalled(child1, List.class, 118, 5084, 5089).addAll(CallChecker.isCalled(parent1Rep, List.class, 118, 5098, 5107).subList(lb, (ub + 1)));
                }
            }
            if (CallChecker.beforeDeref(child1Set, Set.class, 119, 5139, 5147)) {
                CallChecker.isCalled(child1Set, Set.class, 119, 5139, 5147).addAll(child1);
            }
            if (CallChecker.beforeDeref(parent2Rep, List.class, 120, 5187, 5196)) {
                if (CallChecker.beforeDeref(child2, List.class, 120, 5173, 5178)) {
                    CallChecker.isCalled(child2, List.class, 120, 5173, 5178).addAll(CallChecker.isCalled(parent2Rep, List.class, 120, 5187, 5196).subList(lb, (ub + 1)));
                }
            }
            if (CallChecker.beforeDeref(child2Set, Set.class, 121, 5228, 5236)) {
                CallChecker.isCalled(child2Set, Set.class, 121, 5228, 5236).addAll(child2);
            }
            for (int i = 1; i <= length; i++) {
                final int idx = CallChecker.varInit(((int) ((ub + i) % length)), "idx", 125, 5361, 5394);
                final T item1 = CallChecker.varInit(parent1Rep.get(idx), "item1", 128, 5409, 5500);
                final T item2 = CallChecker.varInit(parent2Rep.get(idx), "item2", 129, 5514, 5549);
                if (CallChecker.beforeDeref(child1Set, Set.class, 132, 5657, 5665)) {
                    if (!(CallChecker.isCalled(child1Set, Set.class, 132, 5657, 5665).contains(item2))) {
                        if (CallChecker.beforeDeref(child1, List.class, 133, 5702, 5707)) {
                            CallChecker.isCalled(child1, List.class, 133, 5702, 5707).add(item2);
                        }
                        if (CallChecker.beforeDeref(child1Set, Set.class, 134, 5737, 5745)) {
                            CallChecker.isCalled(child1Set, Set.class, 134, 5737, 5745).add(item2);
                        }
                    }
                }
                if (CallChecker.beforeDeref(child2Set, Set.class, 138, 5879, 5887)) {
                    if (!(CallChecker.isCalled(child2Set, Set.class, 138, 5879, 5887).contains(item1))) {
                        if (CallChecker.beforeDeref(child2, List.class, 139, 5924, 5929)) {
                            CallChecker.isCalled(child2, List.class, 139, 5924, 5929).add(item1);
                        }
                        if (CallChecker.beforeDeref(child2Set, Set.class, 140, 5959, 5967)) {
                            CallChecker.isCalled(child2Set, Set.class, 140, 5959, 5967).add(item1);
                        }
                    }
                }
            }
            Collections.rotate(child1, lb);
            Collections.rotate(child2, lb);
            if (CallChecker.beforeDeref(first, AbstractListChromosome.class, 148, 6206, 6210)) {
                if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 149, 6280, 6285)) {
                    return new ChromosomePair(CallChecker.isCalled(first, AbstractListChromosome.class, 148, 6206, 6210).newFixedLengthChromosome(child1), CallChecker.isCalled(second, AbstractListChromosome.class, 149, 6280, 6285).newFixedLengthChromosome(child2));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5316.methodEnd();
        }
    }
}

