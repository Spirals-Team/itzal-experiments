package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class ElitisticListPopulation extends ListPopulation {
    private double elitismRate = 0.9;

    public ElitisticListPopulation(final List<Chromosome> chromosomes, final int populationLimit, final double elitismRate) throws NotPositiveException, NullArgumentException, NumberIsTooLargeException, OutOfRangeException {
        super(chromosomes, populationLimit);
        ConstructorContext _bcornu_methode_context1166 = new ConstructorContext(ElitisticListPopulation.class, 52, 1629, 2657);
        try {
            setElitismRate(elitismRate);
        } finally {
            _bcornu_methode_context1166.methodEnd();
        }
    }

    public ElitisticListPopulation(final int populationLimit, final double elitismRate) throws NotPositiveException, OutOfRangeException {
        super(populationLimit);
        ConstructorContext _bcornu_methode_context1167 = new ConstructorContext(ElitisticListPopulation.class, 69, 2664, 3359);
        try {
            setElitismRate(elitismRate);
        } finally {
            _bcornu_methode_context1167.methodEnd();
        }
    }

    public Population nextGeneration() {
        MethodContext _bcornu_methode_context5263 = new MethodContext(Population.class, 83, 3366, 4297);
        try {
            CallChecker.varInit(this, "this", 83, 3366, 4297);
            CallChecker.varInit(this.elitismRate, "elitismRate", 83, 3366, 4297);
            ElitisticListPopulation nextGeneration = CallChecker.varInit(new ElitisticListPopulation(getPopulationLimit(), getElitismRate()), "nextGeneration", 85, 3727, 3851);
            final List<Chromosome> oldChromosomes = CallChecker.varInit(getChromosomeList(), "oldChromosomes", 88, 3862, 3921);
            Collections.sort(oldChromosomes);
            int boundIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(oldChromosomes, List.class, 92, 4096, 4109)) {
                boundIndex = ((int) (FastMath.ceil(((1.0 - (getElitismRate())) * (CallChecker.isCalled(oldChromosomes, List.class, 92, 4096, 4109).size())))));
                CallChecker.varAssign(boundIndex, "boundIndex", 92, 4096, 4109);
            }
            for (int i = boundIndex; i < (CallChecker.isCalled(oldChromosomes, List.class, 93, 4157, 4170).size()); i++) {
                if (CallChecker.beforeDeref(oldChromosomes, List.class, 94, 4228, 4241)) {
                    if (CallChecker.beforeDeref(nextGeneration, ElitisticListPopulation.class, 94, 4199, 4212)) {
                        nextGeneration = CallChecker.beforeCalled(nextGeneration, ElitisticListPopulation.class, 94, 4199, 4212);
                        CallChecker.isCalled(nextGeneration, ElitisticListPopulation.class, 94, 4199, 4212).addChromosome(CallChecker.isCalled(oldChromosomes, List.class, 94, 4228, 4241).get(i));
                    }
                }
            }
            return nextGeneration;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Population) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5263.methodEnd();
        }
    }

    public void setElitismRate(final double elitismRate) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5264 = new MethodContext(void.class, 105, 4304, 4921);
        try {
            CallChecker.varInit(this, "this", 105, 4304, 4921);
            CallChecker.varInit(elitismRate, "elitismRate", 105, 4304, 4921);
            CallChecker.varInit(this.elitismRate, "elitismRate", 105, 4304, 4921);
            if ((elitismRate < 0) || (elitismRate > 1)) {
                throw new OutOfRangeException(LocalizedFormats.ELITISM_RATE, elitismRate, 0, 1);
            }
            this.elitismRate = elitismRate;
            CallChecker.varAssign(this.elitismRate, "this.elitismRate", 109, 4885, 4915);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5264.methodEnd();
        }
    }

    public double getElitismRate() {
        MethodContext _bcornu_methode_context5265 = new MethodContext(double.class, 116, 4928, 5078);
        try {
            CallChecker.varInit(this, "this", 116, 4928, 5078);
            CallChecker.varInit(this.elitismRate, "elitismRate", 116, 4928, 5078);
            return this.elitismRate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5265.methodEnd();
        }
    }
}

