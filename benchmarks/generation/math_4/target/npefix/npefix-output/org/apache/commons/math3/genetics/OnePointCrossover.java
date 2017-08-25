package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class OnePointCrossover<T> implements CrossoverPolicy {
    @SuppressWarnings(value = "unchecked")
    public ChromosomePair crossover(final Chromosome first, final Chromosome second) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4724 = new MethodContext(ChromosomePair.class, 79, 2176, 3874);
        try {
            CallChecker.varInit(this, "this", 79, 2176, 3874);
            CallChecker.varInit(second, "second", 79, 2176, 3874);
            CallChecker.varInit(first, "first", 79, 2176, 3874);
            if (!((first instanceof AbstractListChromosome<?>) && (second instanceof AbstractListChromosome<?>))) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME);
            }
            return crossover(((AbstractListChromosome<T>) (first)), ((AbstractListChromosome<T>) (second)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4724.methodEnd();
        }
    }

    private ChromosomePair crossover(final AbstractListChromosome<T> first, final AbstractListChromosome<T> second) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4725 = new MethodContext(ChromosomePair.class, 97, 3882, 5693);
        try {
            CallChecker.varInit(this, "this", 97, 3882, 5693);
            CallChecker.varInit(second, "second", 97, 3882, 5693);
            CallChecker.varInit(first, "first", 97, 3882, 5693);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(first, AbstractListChromosome.class, 99, 4465, 4469).getLength())), "length", 99, 4446, 4482);
            if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 100, 4506, 4511)) {
                if (length != (CallChecker.isCalled(second, AbstractListChromosome.class, 100, 4506, 4511).getLength())) {
                    if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 101, 4577, 4582)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(second, AbstractListChromosome.class, 101, 4577, 4582).getLength(), length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final List<T> parent1Rep = CallChecker.varInit(CallChecker.isCalled(first, AbstractListChromosome.class, 105, 4700, 4704).getRepresentation(), "parent1Rep", 105, 4625, 4725);
            final List<T> parent2Rep = CallChecker.varInit(CallChecker.isCalled(second, AbstractListChromosome.class, 106, 4762, 4767).getRepresentation(), "parent2Rep", 106, 4735, 4788);
            final ArrayList<T> child1Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(first, AbstractListChromosome.class, 108, 4878, 4882).getLength()), "child1Rep", 108, 4798, 4896);
            final ArrayList<T> child2Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(second, AbstractListChromosome.class, 109, 4955, 4960).getLength()), "child2Rep", 109, 4906, 4974);
            final int crossoverIndex = CallChecker.varInit(((int) (1 + (CallChecker.isCalled(GeneticAlgorithm.getRandomGenerator(), RandomGenerator.class, 112, 5093, 5129).nextInt((length - 2))))), "crossoverIndex", 112, 4985, 5149);
            for (int i = 0; i < crossoverIndex; i++) {
                if (CallChecker.beforeDeref(parent1Rep, List.class, 116, 5260, 5269)) {
                    if (CallChecker.beforeDeref(child1Rep, ArrayList.class, 116, 5246, 5254)) {
                        CallChecker.isCalled(child1Rep, ArrayList.class, 116, 5246, 5254).add(parent1Rep.get(i));
                    }
                }
                if (CallChecker.beforeDeref(parent2Rep, List.class, 117, 5306, 5315)) {
                    if (CallChecker.beforeDeref(child2Rep, ArrayList.class, 117, 5292, 5300)) {
                        CallChecker.isCalled(child2Rep, ArrayList.class, 117, 5292, 5300).add(parent2Rep.get(i));
                    }
                }
            }
            for (int i = crossoverIndex; i < length; i++) {
                if (CallChecker.beforeDeref(parent2Rep, List.class, 121, 5456, 5465)) {
                    if (CallChecker.beforeDeref(child1Rep, ArrayList.class, 121, 5442, 5450)) {
                        CallChecker.isCalled(child1Rep, ArrayList.class, 121, 5442, 5450).add(parent2Rep.get(i));
                    }
                }
                if (CallChecker.beforeDeref(parent1Rep, List.class, 122, 5502, 5511)) {
                    if (CallChecker.beforeDeref(child2Rep, ArrayList.class, 122, 5488, 5496)) {
                        CallChecker.isCalled(child2Rep, ArrayList.class, 122, 5488, 5496).add(parent1Rep.get(i));
                    }
                }
            }
            if (CallChecker.beforeDeref(first, AbstractListChromosome.class, 125, 5567, 5571)) {
                if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 126, 5644, 5649)) {
                    return new ChromosomePair(CallChecker.isCalled(first, AbstractListChromosome.class, 125, 5567, 5571).newFixedLengthChromosome(child1Rep), CallChecker.isCalled(second, AbstractListChromosome.class, 126, 5644, 5649).newFixedLengthChromosome(child2Rep));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4725.methodEnd();
        }
    }
}

