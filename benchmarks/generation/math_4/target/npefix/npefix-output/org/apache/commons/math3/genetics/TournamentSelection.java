package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class TournamentSelection implements SelectionPolicy {
    private int arity;

    public TournamentSelection(final int arity) {
        ConstructorContext _bcornu_methode_context1059 = new ConstructorContext(TournamentSelection.class, 44, 1513, 1738);
        try {
            this.arity = arity;
            CallChecker.varAssign(this.arity, "this.arity", 45, 1714, 1732);
        } finally {
            _bcornu_methode_context1059.methodEnd();
        }
    }

    public ChromosomePair select(final Population population) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4697 = new MethodContext(ChromosomePair.class, 58, 1745, 2545);
        try {
            CallChecker.varInit(this, "this", 58, 1745, 2545);
            CallChecker.varInit(population, "population", 58, 1745, 2545);
            CallChecker.varInit(this.arity, "arity", 58, 1745, 2545);
            return new ChromosomePair(tournament(((ListPopulation) (population))), tournament(((ListPopulation) (population))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((ChromosomePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4697.methodEnd();
        }
    }

    private Chromosome tournament(final ListPopulation population) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4699 = new MethodContext(Chromosome.class, 71, 2552, 4194);
        try {
            CallChecker.varInit(this, "this", 71, 2552, 4194);
            CallChecker.varInit(population, "population", 71, 2552, 4194);
            CallChecker.varInit(this.arity, "arity", 71, 2552, 4194);
            if (CallChecker.beforeDeref(population, ListPopulation.class, 72, 3096, 3105)) {
                if ((CallChecker.isCalled(population, ListPopulation.class, 72, 3096, 3105).getPopulationSize()) < (this.arity)) {
                    if (CallChecker.beforeDeref(population, ListPopulation.class, 74, 3297, 3306)) {
                        throw new MathIllegalArgumentException(LocalizedFormats.TOO_LARGE_TOURNAMENT_ARITY, arity, CallChecker.isCalled(population, ListPopulation.class, 74, 3297, 3306).getPopulationSize());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            ListPopulation tournamentPopulation = new ListPopulation(this.arity) {
                public Population nextGeneration() {
                    MethodContext _bcornu_methode_context4698 = new MethodContext(Population.class, 78, 3463, 3576);
                    try {
                        CallChecker.varInit(this, "this", 78, 3463, 3576);
                        return null;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Population) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context4698.methodEnd();
                    }
                }
            };
            List<Chromosome> chromosomes = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(population, ListPopulation.class, 85, 3704, 3713)) {
                chromosomes = new ArrayList<Chromosome>(CallChecker.isCalled(population, ListPopulation.class, 85, 3704, 3713).getChromosomes());
                CallChecker.varAssign(chromosomes, "chromosomes", 85, 3704, 3713);
            }
            for (int i = 0; i < (this.arity); i++) {
                int rind = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(chromosomes, List.class, 88, 3917, 3927)) {
                    final RandomGenerator npe_invocation_var951 = GeneticAlgorithm.getRandomGenerator();
                    if (CallChecker.beforeDeref(npe_invocation_var951, RandomGenerator.class, 88, 3871, 3907)) {
                        chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 88, 3917, 3927);
                        rind = CallChecker.isCalled(npe_invocation_var951, RandomGenerator.class, 88, 3871, 3907).nextInt(CallChecker.isCalled(chromosomes, List.class, 88, 3917, 3927).size());
                        CallChecker.varAssign(rind, "rind", 88, 3917, 3927);
                    }
                }
                if (CallChecker.beforeDeref(chromosomes, List.class, 89, 3985, 3995)) {
                    if (CallChecker.beforeDeref(tournamentPopulation, ListPopulation.class, 89, 3950, 3969)) {
                        chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 89, 3985, 3995);
                        tournamentPopulation = CallChecker.beforeCalled(tournamentPopulation, ListPopulation.class, 89, 3950, 3969);
                        CallChecker.isCalled(tournamentPopulation, ListPopulation.class, 89, 3950, 3969).addChromosome(CallChecker.isCalled(chromosomes, List.class, 89, 3985, 3995).get(rind));
                    }
                }
                if (CallChecker.beforeDeref(chromosomes, List.class, 91, 4059, 4069)) {
                    chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 91, 4059, 4069);
                    CallChecker.isCalled(chromosomes, List.class, 91, 4059, 4069).remove(rind);
                }
            }
            if (CallChecker.beforeDeref(tournamentPopulation, ListPopulation.class, 94, 4145, 4164)) {
                tournamentPopulation = CallChecker.beforeCalled(tournamentPopulation, ListPopulation.class, 94, 4145, 4164);
                return CallChecker.isCalled(tournamentPopulation, ListPopulation.class, 94, 4145, 4164).getFittestChromosome();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4699.methodEnd();
        }
    }

    public int getArity() {
        MethodContext _bcornu_methode_context4700 = new MethodContext(int.class, 102, 4201, 4384);
        try {
            CallChecker.varInit(this, "this", 102, 4201, 4384);
            CallChecker.varInit(this.arity, "arity", 102, 4201, 4384);
            return arity;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4700.methodEnd();
        }
    }

    public void setArity(final int arity) {
        MethodContext _bcornu_methode_context4701 = new MethodContext(void.class, 111, 4391, 4601);
        try {
            CallChecker.varInit(this, "this", 111, 4391, 4601);
            CallChecker.varInit(arity, "arity", 111, 4391, 4601);
            CallChecker.varInit(this.arity, "arity", 111, 4391, 4601);
            this.arity = arity;
            CallChecker.varAssign(this.arity, "this.arity", 112, 4577, 4595);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4701.methodEnd();
        }
    }
}

