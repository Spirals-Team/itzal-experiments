package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class NPointCrossover<T> implements CrossoverPolicy {
    private final int crossoverPoints;

    public NPointCrossover(final int crossoverPoints) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context1063 = new ConstructorContext(NPointCrossover.class, 67, 2521, 3271);
        try {
            if (crossoverPoints <= 0) {
                throw new NotStrictlyPositiveException(crossoverPoints);
            }
            this.crossoverPoints = crossoverPoints;
            CallChecker.varAssign(this.crossoverPoints, "this.crossoverPoints", 71, 3227, 3265);
        } finally {
            _bcornu_methode_context1063.methodEnd();
        }
    }

    public int getCrossoverPoints() {
        MethodContext _bcornu_methode_context4726 = new MethodContext(int.class, 79, 3278, 3501);
        try {
            CallChecker.varInit(this, "this", 79, 3278, 3501);
            CallChecker.varInit(this.crossoverPoints, "crossoverPoints", 79, 3278, 3501);
            return crossoverPoints;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4726.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public ChromosomePair crossover(final Chromosome first, final Chromosome second) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4727 = new MethodContext(ChromosomePair.class, 108, 3508, 5304);
        try {
            CallChecker.varInit(this, "this", 108, 3508, 5304);
            CallChecker.varInit(second, "second", 108, 3508, 5304);
            CallChecker.varInit(first, "first", 108, 3508, 5304);
            CallChecker.varInit(this.crossoverPoints, "crossoverPoints", 108, 3508, 5304);
            if (!((first instanceof AbstractListChromosome<?>) && (second instanceof AbstractListChromosome<?>))) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME);
            }
            return mate(((AbstractListChromosome<T>) (first)), ((AbstractListChromosome<T>) (second)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4727.methodEnd();
        }
    }

    private ChromosomePair mate(final AbstractListChromosome<T> first, final AbstractListChromosome<T> second) throws DimensionMismatchException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4728 = new MethodContext(ChromosomePair.class, 126, 5311, 7860);
        try {
            CallChecker.varInit(this, "this", 126, 5311, 7860);
            CallChecker.varInit(second, "second", 126, 5311, 7860);
            CallChecker.varInit(first, "first", 126, 5311, 7860);
            CallChecker.varInit(this.crossoverPoints, "crossoverPoints", 126, 5311, 7860);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(first, AbstractListChromosome.class, 130, 6031, 6035).getLength())), "length", 130, 6012, 6048);
            if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 131, 6072, 6077)) {
                if (length != (CallChecker.isCalled(second, AbstractListChromosome.class, 131, 6072, 6077).getLength())) {
                    if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 132, 6143, 6148)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(second, AbstractListChromosome.class, 132, 6143, 6148).getLength(), length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((crossoverPoints) >= length) {
                throw new NumberIsTooLargeException(crossoverPoints, length, false);
            }
            final List<T> parent1Rep = CallChecker.varInit(CallChecker.isCalled(first, AbstractListChromosome.class, 139, 6398, 6402).getRepresentation(), "parent1Rep", 139, 6323, 6423);
            final List<T> parent2Rep = CallChecker.varInit(CallChecker.isCalled(second, AbstractListChromosome.class, 140, 6460, 6465).getRepresentation(), "parent2Rep", 140, 6433, 6486);
            final ArrayList<T> child1Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(first, AbstractListChromosome.class, 142, 6575, 6579).getLength()), "child1Rep", 142, 6496, 6593);
            final ArrayList<T> child2Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(second, AbstractListChromosome.class, 143, 6651, 6656).getLength()), "child2Rep", 143, 6603, 6670);
            final RandomGenerator random = CallChecker.varInit(GeneticAlgorithm.getRandomGenerator(), "random", 145, 6681, 6749);
            ArrayList<T> c1 = CallChecker.varInit(child1Rep, "c1", 147, 6760, 6787);
            ArrayList<T> c2 = CallChecker.varInit(child2Rep, "c2", 148, 6797, 6824);
            int remainingPoints = CallChecker.varInit(((int) (this.crossoverPoints)), "remainingPoints", 150, 6835, 6872);
            int lastIndex = CallChecker.varInit(((int) (0)), "lastIndex", 151, 6882, 6899);
            for (int i = 0; i < (crossoverPoints); i++ , remainingPoints--) {
                final int crossoverIndex = CallChecker.varInit(((int) ((1 + lastIndex) + (CallChecker.isCalled(random, RandomGenerator.class, 154, 7084, 7089).nextInt(((length - lastIndex) - remainingPoints))))), "crossoverIndex", 154, 6984, 7136);
                for (int j = lastIndex; j < crossoverIndex; j++) {
                    if (CallChecker.beforeDeref(parent1Rep, List.class, 158, 7265, 7274)) {
                        if (CallChecker.beforeDeref(c1, ArrayList.class, 158, 7258, 7259)) {
                            c1 = CallChecker.beforeCalled(c1, ArrayList.class, 158, 7258, 7259);
                            CallChecker.isCalled(c1, ArrayList.class, 158, 7258, 7259).add(parent1Rep.get(j));
                        }
                    }
                    if (CallChecker.beforeDeref(parent2Rep, List.class, 159, 7308, 7317)) {
                        if (CallChecker.beforeDeref(c2, ArrayList.class, 159, 7301, 7302)) {
                            c2 = CallChecker.beforeCalled(c2, ArrayList.class, 159, 7301, 7302);
                            CallChecker.isCalled(c2, ArrayList.class, 159, 7301, 7302).add(parent2Rep.get(j));
                        }
                    }
                }
                ArrayList<T> tmp = CallChecker.varInit(c1, "tmp", 163, 7409, 7430);
                c1 = c2;
                CallChecker.varAssign(c1, "c1", 164, 7444, 7451);
                c2 = tmp;
                CallChecker.varAssign(c2, "c2", 165, 7465, 7473);
                lastIndex = crossoverIndex;
                CallChecker.varAssign(lastIndex, "lastIndex", 167, 7488, 7514);
            }
            for (int j = lastIndex; j < length; j++) {
                if (CallChecker.beforeDeref(parent1Rep, List.class, 172, 7630, 7639)) {
                    if (CallChecker.beforeDeref(c1, ArrayList.class, 172, 7623, 7624)) {
                        c1 = CallChecker.beforeCalled(c1, ArrayList.class, 172, 7623, 7624);
                        CallChecker.isCalled(c1, ArrayList.class, 172, 7623, 7624).add(parent1Rep.get(j));
                    }
                }
                if (CallChecker.beforeDeref(parent2Rep, List.class, 173, 7669, 7678)) {
                    if (CallChecker.beforeDeref(c2, ArrayList.class, 173, 7662, 7663)) {
                        c2 = CallChecker.beforeCalled(c2, ArrayList.class, 173, 7662, 7663);
                        CallChecker.isCalled(c2, ArrayList.class, 173, 7662, 7663).add(parent2Rep.get(j));
                    }
                }
            }
            if (CallChecker.beforeDeref(first, AbstractListChromosome.class, 176, 7734, 7738)) {
                if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 177, 7811, 7816)) {
                    return new ChromosomePair(CallChecker.isCalled(first, AbstractListChromosome.class, 176, 7734, 7738).newFixedLengthChromosome(child1Rep), CallChecker.isCalled(second, AbstractListChromosome.class, 177, 7811, 7816).newFixedLengthChromosome(child2Rep));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4728.methodEnd();
        }
    }
}

