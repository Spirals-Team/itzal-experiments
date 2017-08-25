package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public abstract class Chromosome implements Comparable<Chromosome> , Fitness {
    private static final double NO_FITNESS = Double.NEGATIVE_INFINITY;

    private double fitness = Chromosome.NO_FITNESS;

    public double getFitness() {
        MethodContext _bcornu_methode_context3042 = new MethodContext(double.class, 42, 1403, 1859);
        try {
            CallChecker.varInit(this, "this", 42, 1403, 1859);
            CallChecker.varInit(this.fitness, "fitness", 42, 1403, 1859);
            CallChecker.varInit(NO_FITNESS, "org.apache.commons.math3.genetics.Chromosome.NO_FITNESS", 42, 1403, 1859);
            if ((this.fitness) == (Chromosome.NO_FITNESS)) {
                this.fitness = fitness();
                CallChecker.varAssign(this.fitness, "this.fitness", 45, 1790, 1814);
            }
            return this.fitness;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3042.methodEnd();
        }
    }

    public int compareTo(final Chromosome another) {
        MethodContext _bcornu_methode_context3043 = new MethodContext(int.class, 61, 1866, 2436);
        try {
            CallChecker.varInit(this, "this", 61, 1866, 2436);
            CallChecker.varInit(another, "another", 61, 1866, 2436);
            CallChecker.varInit(this.fitness, "fitness", 61, 1866, 2436);
            CallChecker.varInit(NO_FITNESS, "org.apache.commons.math3.genetics.Chromosome.NO_FITNESS", 61, 1866, 2436);
            if (CallChecker.beforeDeref(another, Chromosome.class, 62, 2409, 2415)) {
                final Double npe_invocation_var783 = ((Double) (this.getFitness()));
                if (CallChecker.beforeDeref(npe_invocation_var783, Double.class, 62, 2380, 2396)) {
                    return CallChecker.isCalled(npe_invocation_var783, Double.class, 62, 2380, 2396).compareTo(CallChecker.isCalled(another, Chromosome.class, 62, 2409, 2415).getFitness());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3043.methodEnd();
        }
    }

    protected boolean isSame(final Chromosome another) {
        MethodContext _bcornu_methode_context3044 = new MethodContext(boolean.class, 72, 2443, 2874);
        try {
            CallChecker.varInit(this, "this", 72, 2443, 2874);
            CallChecker.varInit(another, "another", 72, 2443, 2874);
            CallChecker.varInit(this.fitness, "fitness", 72, 2443, 2874);
            CallChecker.varInit(NO_FITNESS, "org.apache.commons.math3.genetics.Chromosome.NO_FITNESS", 72, 2443, 2874);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3044.methodEnd();
        }
    }

    protected Chromosome findSameChromosome(final Population population) {
        MethodContext _bcornu_methode_context3045 = new MethodContext(Chromosome.class, 83, 2881, 3512);
        try {
            CallChecker.varInit(this, "this", 83, 2881, 3512);
            CallChecker.varInit(population, "population", 83, 2881, 3512);
            CallChecker.varInit(this.fitness, "fitness", 83, 2881, 3512);
            CallChecker.varInit(NO_FITNESS, "org.apache.commons.math3.genetics.Chromosome.NO_FITNESS", 83, 2881, 3512);
            if (CallChecker.beforeDeref(population, Chromosome.class, 84, 3371, 3380)) {
                for (Chromosome anotherChr : population) {
                    if (this.isSame(anotherChr)) {
                        return anotherChr;
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3045.methodEnd();
        }
    }

    public void searchForFitnessUpdate(final Population population) {
        MethodContext _bcornu_methode_context3046 = new MethodContext(void.class, 98, 3519, 3967);
        try {
            CallChecker.varInit(this, "this", 98, 3519, 3967);
            CallChecker.varInit(population, "population", 98, 3519, 3967);
            CallChecker.varInit(this.fitness, "fitness", 98, 3519, 3967);
            CallChecker.varInit(NO_FITNESS, "org.apache.commons.math3.genetics.Chromosome.NO_FITNESS", 98, 3519, 3967);
            Chromosome sameChromosome = CallChecker.varInit(findSameChromosome(population), "sameChromosome", 99, 3804, 3862);
            if (sameChromosome != null) {
                fitness = sameChromosome.getFitness();
                CallChecker.varAssign(this.fitness, "this.fitness", 101, 3914, 3951);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3046.methodEnd();
        }
    }
}

