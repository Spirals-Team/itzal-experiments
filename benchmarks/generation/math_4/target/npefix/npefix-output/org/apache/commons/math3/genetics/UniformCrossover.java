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
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class UniformCrossover<T> implements CrossoverPolicy {
    private final double ratio;

    public UniformCrossover(final double ratio) throws OutOfRangeException {
        ConstructorContext _bcornu_methode_context1018 = new ConstructorContext(UniformCrossover.class, 63, 2788, 3268);
        try {
            if ((ratio < 0.0) || (ratio > 1.0)) {
                throw new OutOfRangeException(LocalizedFormats.CROSSOVER_RATE, ratio, 0.0, 1.0);
            }
            this.ratio = ratio;
            CallChecker.varAssign(this.ratio, "this.ratio", 67, 3244, 3262);
        } finally {
            _bcornu_methode_context1018.methodEnd();
        }
    }

    public double getRatio() {
        MethodContext _bcornu_methode_context4554 = new MethodContext(double.class, 75, 3275, 3453);
        try {
            CallChecker.varInit(this, "this", 75, 3275, 3453);
            CallChecker.varInit(this.ratio, "ratio", 75, 3275, 3453);
            return ratio;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4554.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public ChromosomePair crossover(final Chromosome first, final Chromosome second) throws DimensionMismatchException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4555 = new MethodContext(ChromosomePair.class, 87, 3460, 4236);
        try {
            CallChecker.varInit(this, "this", 87, 3460, 4236);
            CallChecker.varInit(second, "second", 87, 3460, 4236);
            CallChecker.varInit(first, "first", 87, 3460, 4236);
            CallChecker.varInit(this.ratio, "ratio", 87, 3460, 4236);
            if (!((first instanceof AbstractListChromosome<?>) && (second instanceof AbstractListChromosome<?>))) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME);
            }
            return mate(((AbstractListChromosome<T>) (first)), ((AbstractListChromosome<T>) (second)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4555.methodEnd();
        }
    }

    private ChromosomePair mate(final AbstractListChromosome<T> first, final AbstractListChromosome<T> second) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4556 = new MethodContext(ChromosomePair.class, 104, 4243, 5971);
        try {
            CallChecker.varInit(this, "this", 104, 4243, 5971);
            CallChecker.varInit(second, "second", 104, 4243, 5971);
            CallChecker.varInit(first, "first", 104, 4243, 5971);
            CallChecker.varInit(this.ratio, "ratio", 104, 4243, 5971);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(first, AbstractListChromosome.class, 106, 4813, 4817).getLength())), "length", 106, 4794, 4830);
            if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 107, 4854, 4859)) {
                if (length != (CallChecker.isCalled(second, AbstractListChromosome.class, 107, 4854, 4859).getLength())) {
                    if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 108, 4925, 4930)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(second, AbstractListChromosome.class, 108, 4925, 4930).getLength(), length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final List<T> parent1Rep = CallChecker.varInit(CallChecker.isCalled(first, AbstractListChromosome.class, 112, 5048, 5052).getRepresentation(), "parent1Rep", 112, 4973, 5073);
            final List<T> parent2Rep = CallChecker.varInit(CallChecker.isCalled(second, AbstractListChromosome.class, 113, 5110, 5115).getRepresentation(), "parent2Rep", 113, 5083, 5136);
            final List<T> child1Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(first, AbstractListChromosome.class, 115, 5220, 5224).getLength()), "child1Rep", 115, 5146, 5238);
            final List<T> child2Rep = CallChecker.varInit(new ArrayList<T>(CallChecker.isCalled(second, AbstractListChromosome.class, 116, 5291, 5296).getLength()), "child2Rep", 116, 5248, 5310);
            final RandomGenerator random = CallChecker.varInit(GeneticAlgorithm.getRandomGenerator(), "random", 118, 5321, 5389);
            for (int index = 0; index < length; index++) {
                if (CallChecker.beforeDeref(random, RandomGenerator.class, 122, 5464, 5469)) {
                    if ((CallChecker.isCalled(random, RandomGenerator.class, 122, 5464, 5469).nextDouble()) < (ratio)) {
                        if (CallChecker.beforeDeref(parent2Rep, List.class, 124, 5579, 5588)) {
                            if (CallChecker.beforeDeref(child1Rep, List.class, 124, 5565, 5573)) {
                                CallChecker.isCalled(child1Rep, List.class, 124, 5565, 5573).add(parent2Rep.get(index));
                            }
                        }
                        if (CallChecker.beforeDeref(parent1Rep, List.class, 125, 5633, 5642)) {
                            if (CallChecker.beforeDeref(child2Rep, List.class, 125, 5619, 5627)) {
                                CallChecker.isCalled(child2Rep, List.class, 125, 5619, 5627).add(parent1Rep.get(index));
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(parent1Rep, List.class, 127, 5708, 5717)) {
                            if (CallChecker.beforeDeref(child1Rep, List.class, 127, 5694, 5702)) {
                                CallChecker.isCalled(child1Rep, List.class, 127, 5694, 5702).add(parent1Rep.get(index));
                            }
                        }
                        if (CallChecker.beforeDeref(parent2Rep, List.class, 128, 5762, 5771)) {
                            if (CallChecker.beforeDeref(child2Rep, List.class, 128, 5748, 5756)) {
                                CallChecker.isCalled(child2Rep, List.class, 128, 5748, 5756).add(parent2Rep.get(index));
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(first, AbstractListChromosome.class, 132, 5845, 5849)) {
                if (CallChecker.beforeDeref(second, AbstractListChromosome.class, 133, 5922, 5927)) {
                    return new ChromosomePair(CallChecker.isCalled(first, AbstractListChromosome.class, 132, 5845, 5849).newFixedLengthChromosome(child1Rep), CallChecker.isCalled(second, AbstractListChromosome.class, 133, 5922, 5927).newFixedLengthChromosome(child2Rep));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4556.methodEnd();
        }
    }
}

