package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class ListPopulation implements Population {
    private List<Chromosome> chromosomes;

    private int populationLimit;

    public ListPopulation(final int populationLimit) throws NotPositiveException {
        this(Collections.<Chromosome>emptyList(), populationLimit);
        ConstructorContext _bcornu_methode_context106 = new ConstructorContext(ListPopulation.class, 51, 1636, 2054);
        try {
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public ListPopulation(final List<Chromosome> chromosomes, final int populationLimit) throws NotPositiveException, NullArgumentException, NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context107 = new ConstructorContext(ListPopulation.class, 66, 2061, 3488);
        try {
            if (chromosomes == null) {
                throw new NullArgumentException();
            }
            if (populationLimit <= 0) {
                throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, populationLimit);
            }
            if ((chromosomes.size()) > populationLimit) {
                throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, chromosomes.size(), populationLimit, false);
            }
            this.populationLimit = populationLimit;
            CallChecker.varAssign(this.populationLimit, "this.populationLimit", 79, 3327, 3365);
            this.chromosomes = new ArrayList<Chromosome>(populationLimit);
            CallChecker.varAssign(this.chromosomes, "this.chromosomes", 80, 3375, 3436);
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 81, 3446, 3461)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 81, 3446, 3461);
                CallChecker.isCalled(this.chromosomes, List.class, 81, 3446, 3461).addAll(chromosomes);
            }
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    @Deprecated
    public void setChromosomes(final List<Chromosome> chromosomes) throws NullArgumentException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context393 = new MethodContext(void.class, 96, 3495, 4600);
        try {
            CallChecker.varInit(this, "this", 96, 3495, 4600);
            CallChecker.varInit(chromosomes, "chromosomes", 96, 3495, 4600);
            CallChecker.varInit(this.populationLimit, "populationLimit", 96, 3495, 4600);
            CallChecker.varInit(this.chromosomes, "chromosomes", 96, 3495, 4600);
            if (chromosomes == null) {
                throw new NullArgumentException();
            }
            if ((chromosomes.size()) > (populationLimit)) {
                throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, chromosomes.size(), populationLimit, false);
            }
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 106, 4524, 4539)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 106, 4524, 4539);
                CallChecker.isCalled(this.chromosomes, List.class, 106, 4524, 4539).clear();
            }
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 107, 4558, 4573)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 107, 4558, 4573);
                CallChecker.isCalled(this.chromosomes, List.class, 107, 4558, 4573).addAll(chromosomes);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context393.methodEnd();
        }
    }

    public void addChromosomes(final Collection<Chromosome> chromosomeColl) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context394 = new MethodContext(void.class, 117, 4607, 5362);
        try {
            CallChecker.varInit(this, "this", 117, 4607, 5362);
            CallChecker.varInit(chromosomeColl, "chromosomeColl", 117, 4607, 5362);
            CallChecker.varInit(this.populationLimit, "populationLimit", 117, 4607, 5362);
            CallChecker.varInit(this.chromosomes, "chromosomes", 117, 4607, 5362);
            if (CallChecker.beforeDeref(chromosomes, List.class, 118, 5028, 5038)) {
                if (CallChecker.beforeDeref(chromosomeColl, Collection.class, 118, 5049, 5062)) {
                    chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 118, 5028, 5038);
                    if (((CallChecker.isCalled(chromosomes, List.class, 118, 5028, 5038).size()) + (CallChecker.isCalled(chromosomeColl, Collection.class, 118, 5049, 5062).size())) > (populationLimit)) {
                        if (CallChecker.beforeDeref(chromosomes, List.class, 120, 5254, 5264)) {
                            chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 120, 5254, 5264);
                            throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, CallChecker.isCalled(chromosomes, List.class, 120, 5254, 5264).size(), populationLimit, false);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 122, 5317, 5332)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 122, 5317, 5332);
                CallChecker.isCalled(this.chromosomes, List.class, 122, 5317, 5332).addAll(chromosomeColl);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context394.methodEnd();
        }
    }

    public List<Chromosome> getChromosomes() {
        MethodContext _bcornu_methode_context395 = new MethodContext(List.class, 129, 5369, 5617);
        try {
            CallChecker.varInit(this, "this", 129, 5369, 5617);
            CallChecker.varInit(this.populationLimit, "populationLimit", 129, 5369, 5617);
            CallChecker.varInit(this.chromosomes, "chromosomes", 129, 5369, 5617);
            return Collections.unmodifiableList(chromosomes);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Chromosome>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context395.methodEnd();
        }
    }

    protected List<Chromosome> getChromosomeList() {
        MethodContext _bcornu_methode_context396 = new MethodContext(List.class, 138, 5624, 5817);
        try {
            CallChecker.varInit(this, "this", 138, 5624, 5817);
            CallChecker.varInit(this.populationLimit, "populationLimit", 138, 5624, 5817);
            CallChecker.varInit(this.chromosomes, "chromosomes", 138, 5624, 5817);
            return chromosomes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Chromosome>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context396.methodEnd();
        }
    }

    public void addChromosome(final Chromosome chromosome) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context397 = new MethodContext(void.class, 149, 5824, 6490);
        try {
            CallChecker.varInit(this, "this", 149, 5824, 6490);
            CallChecker.varInit(chromosome, "chromosome", 149, 5824, 6490);
            CallChecker.varInit(this.populationLimit, "populationLimit", 149, 5824, 6490);
            CallChecker.varInit(this.chromosomes, "chromosomes", 149, 5824, 6490);
            if (CallChecker.beforeDeref(chromosomes, List.class, 150, 6186, 6196)) {
                chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 150, 6186, 6196);
                if ((CallChecker.isCalled(chromosomes, List.class, 150, 6186, 6196).size()) >= (populationLimit)) {
                    if (CallChecker.beforeDeref(chromosomes, List.class, 152, 6389, 6399)) {
                        chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 152, 6389, 6399);
                        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, CallChecker.isCalled(chromosomes, List.class, 152, 6389, 6399).size(), populationLimit, false);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 154, 6452, 6467)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 154, 6452, 6467);
                CallChecker.isCalled(this.chromosomes, List.class, 154, 6452, 6467).add(chromosome);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context397.methodEnd();
        }
    }

    public Chromosome getFittestChromosome() {
        MethodContext _bcornu_methode_context398 = new MethodContext(Chromosome.class, 161, 6497, 7000);
        try {
            CallChecker.varInit(this, "this", 161, 6497, 7000);
            CallChecker.varInit(this.populationLimit, "populationLimit", 161, 6497, 7000);
            CallChecker.varInit(this.chromosomes, "chromosomes", 161, 6497, 7000);
            Chromosome bestChromosome = CallChecker.init(Chromosome.class);
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 163, 6711, 6726)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 163, 6711, 6726);
                bestChromosome = CallChecker.isCalled(this.chromosomes, List.class, 163, 6711, 6726).get(0);
                CallChecker.varAssign(bestChromosome, "bestChromosome", 163, 6711, 6726);
            }
            if (CallChecker.beforeDeref(this.chromosomes, Chromosome.class, 164, 6773, 6788)) {
                for (Chromosome chromosome : this.chromosomes) {
                    if (CallChecker.beforeDeref(chromosome, Chromosome.class, 165, 6809, 6818)) {
                        if ((CallChecker.isCalled(chromosome, Chromosome.class, 165, 6809, 6818).compareTo(bestChromosome)) > 0) {
                            bestChromosome = chromosome;
                            CallChecker.varAssign(bestChromosome, "bestChromosome", 167, 6912, 6939);
                        }
                    }
                }
            }
            return bestChromosome;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context398.methodEnd();
        }
    }

    public int getPopulationLimit() {
        MethodContext _bcornu_methode_context399 = new MethodContext(int.class, 177, 7007, 7185);
        try {
            CallChecker.varInit(this, "this", 177, 7007, 7185);
            CallChecker.varInit(this.populationLimit, "populationLimit", 177, 7007, 7185);
            CallChecker.varInit(this.chromosomes, "chromosomes", 177, 7007, 7185);
            return this.populationLimit;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context399.methodEnd();
        }
    }

    public void setPopulationLimit(final int populationLimit) throws NotPositiveException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context400 = new MethodContext(void.class, 188, 7192, 8019);
        try {
            CallChecker.varInit(this, "this", 188, 7192, 8019);
            CallChecker.varInit(populationLimit, "populationLimit", 188, 7192, 8019);
            CallChecker.varInit(this.populationLimit, "populationLimit", 188, 7192, 8019);
            CallChecker.varInit(this.chromosomes, "chromosomes", 188, 7192, 8019);
            if (populationLimit <= 0) {
                throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, populationLimit);
            }
            if (CallChecker.beforeDeref(chromosomes, List.class, 192, 7843, 7853)) {
                chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 192, 7843, 7853);
                if (populationLimit < (CallChecker.isCalled(chromosomes, List.class, 192, 7843, 7853).size())) {
                    if (CallChecker.beforeDeref(chromosomes, List.class, 193, 7930, 7940)) {
                        chromosomes = CallChecker.beforeCalled(chromosomes, List.class, 193, 7930, 7940);
                        throw new NumberIsTooSmallException(populationLimit, CallChecker.isCalled(chromosomes, List.class, 193, 7930, 7940).size(), true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            this.populationLimit = populationLimit;
            CallChecker.varAssign(this.populationLimit, "this.populationLimit", 195, 7975, 8013);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context400.methodEnd();
        }
    }

    public int getPopulationSize() {
        MethodContext _bcornu_methode_context401 = new MethodContext(int.class, 202, 8026, 8206);
        try {
            CallChecker.varInit(this, "this", 202, 8026, 8206);
            CallChecker.varInit(this.populationLimit, "populationLimit", 202, 8026, 8206);
            CallChecker.varInit(this.chromosomes, "chromosomes", 202, 8026, 8206);
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 203, 8177, 8192)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 203, 8177, 8192);
                return CallChecker.isCalled(this.chromosomes, List.class, 203, 8177, 8192).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context401.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context402 = new MethodContext(String.class, 210, 8213, 8339);
        try {
            CallChecker.varInit(this, "this", 210, 8213, 8339);
            CallChecker.varInit(this.populationLimit, "populationLimit", 210, 8213, 8339);
            CallChecker.varInit(this.chromosomes, "chromosomes", 210, 8213, 8339);
            if (CallChecker.beforeDeref(this.chromosomes, List.class, 211, 8306, 8321)) {
                this.chromosomes = CallChecker.beforeCalled(this.chromosomes, List.class, 211, 8306, 8321);
                return CallChecker.isCalled(this.chromosomes, List.class, 211, 8306, 8321).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context402.methodEnd();
        }
    }

    public Iterator<Chromosome> iterator() {
        MethodContext _bcornu_methode_context403 = new MethodContext(Iterator.class, 220, 8346, 8671);
        try {
            CallChecker.varInit(this, "this", 220, 8346, 8671);
            CallChecker.varInit(this.populationLimit, "populationLimit", 220, 8346, 8671);
            CallChecker.varInit(this.chromosomes, "chromosomes", 220, 8346, 8671);
            final List<Chromosome> npe_invocation_var46 = getChromosomes();
            if (CallChecker.beforeDeref(npe_invocation_var46, List.class, 221, 8638, 8653)) {
                return CallChecker.isCalled(npe_invocation_var46, List.class, 221, 8638, 8653).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Chromosome>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context403.methodEnd();
        }
    }
}

