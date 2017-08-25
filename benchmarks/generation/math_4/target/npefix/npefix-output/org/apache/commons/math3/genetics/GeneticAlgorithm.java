package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

public class GeneticAlgorithm {
    private static RandomGenerator randomGenerator = new JDKRandomGenerator();

    private final CrossoverPolicy crossoverPolicy;

    private final double crossoverRate;

    private final MutationPolicy mutationPolicy;

    private final double mutationRate;

    private final SelectionPolicy selectionPolicy;

    private int generationsEvolved = 0;

    public GeneticAlgorithm(final CrossoverPolicy crossoverPolicy, final double crossoverRate, final MutationPolicy mutationPolicy, final double mutationRate, final SelectionPolicy selectionPolicy) throws OutOfRangeException {
        ConstructorContext _bcornu_methode_context1070 = new ConstructorContext(GeneticAlgorithm.class, 68, 2328, 3778);
        try {
            if ((crossoverRate < 0) || (crossoverRate > 1)) {
                throw new OutOfRangeException(LocalizedFormats.CROSSOVER_RATE, crossoverRate, 0, 1);
            }
            if ((mutationRate < 0) || (mutationRate > 1)) {
                throw new OutOfRangeException(LocalizedFormats.MUTATION_RATE, mutationRate, 0, 1);
            }
            this.crossoverPolicy = crossoverPolicy;
            CallChecker.varAssign(this.crossoverPolicy, "this.crossoverPolicy", 82, 3554, 3592);
            this.crossoverRate = crossoverRate;
            CallChecker.varAssign(this.crossoverRate, "this.crossoverRate", 83, 3602, 3636);
            this.mutationPolicy = mutationPolicy;
            CallChecker.varAssign(this.mutationPolicy, "this.mutationPolicy", 84, 3646, 3682);
            this.mutationRate = mutationRate;
            CallChecker.varAssign(this.mutationRate, "this.mutationRate", 85, 3692, 3724);
            this.selectionPolicy = selectionPolicy;
            CallChecker.varAssign(this.selectionPolicy, "this.selectionPolicy", 86, 3734, 3772);
        } finally {
            _bcornu_methode_context1070.methodEnd();
        }
    }

    public static synchronized void setRandomGenerator(final RandomGenerator random) {
        MethodContext _bcornu_methode_context4770 = new MethodContext(void.class, 94, 3785, 4009);
        try {
            CallChecker.varInit(random, "random", 94, 3785, 4009);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 94, 3785, 4009);
            GeneticAlgorithm.randomGenerator = random;
            CallChecker.varAssign(GeneticAlgorithm.randomGenerator, "GeneticAlgorithm.randomGenerator", 95, 3979, 4003);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4770.methodEnd();
        }
    }

    public static synchronized RandomGenerator getRandomGenerator() {
        MethodContext _bcornu_methode_context4771 = new MethodContext(RandomGenerator.class, 103, 4016, 4266);
        try {
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 103, 4016, 4266);
            return GeneticAlgorithm.randomGenerator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RandomGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4771.methodEnd();
        }
    }

    public Population evolve(final Population initial, final StoppingCondition condition) {
        MethodContext _bcornu_methode_context4772 = new MethodContext(Population.class, 117, 4273, 5085);
        try {
            CallChecker.varInit(this, "this", 117, 4273, 5085);
            CallChecker.varInit(condition, "condition", 117, 4273, 5085);
            CallChecker.varInit(initial, "initial", 117, 4273, 5085);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 117, 4273, 5085);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 117, 4273, 5085);
            CallChecker.varInit(this.mutationRate, "mutationRate", 117, 4273, 5085);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 117, 4273, 5085);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 117, 4273, 5085);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 117, 4273, 5085);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 117, 4273, 5085);
            Population current = CallChecker.varInit(initial, "current", 118, 4854, 4882);
            generationsEvolved = 0;
            CallChecker.varAssign(this.generationsEvolved, "this.generationsEvolved", 119, 4892, 4914);
            while (!(CallChecker.isCalled(condition, StoppingCondition.class, 120, 4932, 4940).isSatisfied(current))) {
                current = nextGeneration(current);
                CallChecker.varAssign(current, "current", 121, 4978, 5011);
                (generationsEvolved)++;
            } 
            return current;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Population) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4772.methodEnd();
        }
    }

    public Population nextGeneration(final Population current) {
        MethodContext _bcornu_methode_context4773 = new MethodContext(Population.class, 149, 5092, 7507);
        try {
            CallChecker.varInit(this, "this", 149, 5092, 7507);
            CallChecker.varInit(current, "current", 149, 5092, 7507);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 149, 5092, 7507);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 149, 5092, 7507);
            CallChecker.varInit(this.mutationRate, "mutationRate", 149, 5092, 7507);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 149, 5092, 7507);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 149, 5092, 7507);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 149, 5092, 7507);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 149, 5092, 7507);
            Population nextGeneration = CallChecker.init(Population.class);
            if (CallChecker.beforeDeref(current, Population.class, 150, 6164, 6170)) {
                nextGeneration = CallChecker.isCalled(current, Population.class, 150, 6164, 6170).nextGeneration();
                CallChecker.varAssign(nextGeneration, "nextGeneration", 150, 6164, 6170);
            }
            RandomGenerator randGen = CallChecker.varInit(GeneticAlgorithm.getRandomGenerator(), "randGen", 152, 6199, 6245);
            nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 154, 6263, 6276);
            nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 154, 6300, 6313);
            while ((CallChecker.isCalled(nextGeneration, Population.class, 154, 6263, 6276).getPopulationSize()) < (CallChecker.isCalled(nextGeneration, Population.class, 154, 6300, 6313).getPopulationLimit())) {
                final SelectionPolicy npe_invocation_var952 = getSelectionPolicy();
                ChromosomePair pair = CallChecker.init(ChromosomePair.class);
                if (CallChecker.beforeDeref(npe_invocation_var952, SelectionPolicy.class, 156, 6414, 6433)) {
                    pair = CallChecker.isCalled(npe_invocation_var952, SelectionPolicy.class, 156, 6414, 6433).select(current);
                    CallChecker.varAssign(pair, "pair", 156, 6414, 6433);
                }
                if (CallChecker.beforeDeref(randGen, RandomGenerator.class, 159, 6495, 6501)) {
                    randGen = CallChecker.beforeCalled(randGen, RandomGenerator.class, 159, 6495, 6501);
                    if ((CallChecker.isCalled(randGen, RandomGenerator.class, 159, 6495, 6501).nextDouble()) < (getCrossoverRate())) {
                        if (CallChecker.beforeDeref(pair, ChromosomePair.class, 161, 6660, 6663)) {
                            if (CallChecker.beforeDeref(pair, ChromosomePair.class, 161, 6677, 6680)) {
                                final CrossoverPolicy npe_invocation_var953 = getCrossoverPolicy();
                                if (CallChecker.beforeDeref(npe_invocation_var953, CrossoverPolicy.class, 161, 6629, 6648)) {
                                    pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 161, 6660, 6663);
                                    pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 161, 6677, 6680);
                                    pair = CallChecker.isCalled(npe_invocation_var953, CrossoverPolicy.class, 161, 6629, 6648).crossover(CallChecker.isCalled(pair, ChromosomePair.class, 161, 6660, 6663).getFirst(), CallChecker.isCalled(pair, ChromosomePair.class, 161, 6677, 6680).getSecond());
                                    CallChecker.varAssign(pair, "pair", 161, 6622, 6694);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(randGen, RandomGenerator.class, 165, 6752, 6758)) {
                    randGen = CallChecker.beforeCalled(randGen, RandomGenerator.class, 165, 6752, 6758);
                    if ((CallChecker.isCalled(randGen, RandomGenerator.class, 165, 6752, 6758).nextDouble()) < (getMutationRate())) {
                        if (CallChecker.beforeDeref(pair, ChromosomePair.class, 168, 6946, 6949)) {
                            final MutationPolicy npe_invocation_var954 = getMutationPolicy();
                            if (CallChecker.beforeDeref(npe_invocation_var954, MutationPolicy.class, 168, 6919, 6937)) {
                                if (CallChecker.beforeDeref(pair, ChromosomePair.class, 169, 7011, 7014)) {
                                    final MutationPolicy npe_invocation_var955 = getMutationPolicy();
                                    if (CallChecker.beforeDeref(npe_invocation_var955, MutationPolicy.class, 169, 6984, 7002)) {
                                        pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 168, 6946, 6949);
                                        pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 169, 7011, 7014);
                                        pair = new ChromosomePair(CallChecker.isCalled(npe_invocation_var954, MutationPolicy.class, 168, 6919, 6937).mutate(CallChecker.isCalled(pair, ChromosomePair.class, 168, 6946, 6949).getFirst()), CallChecker.isCalled(npe_invocation_var955, MutationPolicy.class, 169, 6984, 7002).mutate(CallChecker.isCalled(pair, ChromosomePair.class, 169, 7011, 7014).getSecond()));
                                        CallChecker.varAssign(pair, "pair", 167, 6872, 7029);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(pair, ChromosomePair.class, 173, 7145, 7148)) {
                    if (CallChecker.beforeDeref(nextGeneration, Population.class, 173, 7116, 7129)) {
                        pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 173, 7145, 7148);
                        nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 173, 7116, 7129);
                        CallChecker.isCalled(nextGeneration, Population.class, 173, 7116, 7129).addChromosome(CallChecker.isCalled(pair, ChromosomePair.class, 173, 7145, 7148).getFirst());
                    }
                }
                if (CallChecker.beforeDeref(nextGeneration, Population.class, 175, 7244, 7257)) {
                    if (CallChecker.beforeDeref(nextGeneration, Population.class, 175, 7281, 7294)) {
                        nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 175, 7244, 7257);
                        nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 175, 7281, 7294);
                        if ((CallChecker.isCalled(nextGeneration, Population.class, 175, 7244, 7257).getPopulationSize()) < (CallChecker.isCalled(nextGeneration, Population.class, 175, 7281, 7294).getPopulationLimit())) {
                            if (CallChecker.beforeDeref(pair, ChromosomePair.class, 177, 7428, 7431)) {
                                if (CallChecker.beforeDeref(nextGeneration, Population.class, 177, 7399, 7412)) {
                                    pair = CallChecker.beforeCalled(pair, ChromosomePair.class, 177, 7428, 7431);
                                    nextGeneration = CallChecker.beforeCalled(nextGeneration, Population.class, 177, 7399, 7412);
                                    CallChecker.isCalled(nextGeneration, Population.class, 177, 7399, 7412).addChromosome(CallChecker.isCalled(pair, ChromosomePair.class, 177, 7428, 7431).getSecond());
                                }
                            }
                        }
                    }
                }
            } 
            return nextGeneration;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Population) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4773.methodEnd();
        }
    }

    public CrossoverPolicy getCrossoverPolicy() {
        MethodContext _bcornu_methode_context4774 = new MethodContext(CrossoverPolicy.class, 188, 7514, 7681);
        try {
            CallChecker.varInit(this, "this", 188, 7514, 7681);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 188, 7514, 7681);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 188, 7514, 7681);
            CallChecker.varInit(this.mutationRate, "mutationRate", 188, 7514, 7681);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 188, 7514, 7681);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 188, 7514, 7681);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 188, 7514, 7681);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 188, 7514, 7681);
            return crossoverPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((CrossoverPolicy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4774.methodEnd();
        }
    }

    public double getCrossoverRate() {
        MethodContext _bcornu_methode_context4775 = new MethodContext(double.class, 196, 7688, 7838);
        try {
            CallChecker.varInit(this, "this", 196, 7688, 7838);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 196, 7688, 7838);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 196, 7688, 7838);
            CallChecker.varInit(this.mutationRate, "mutationRate", 196, 7688, 7838);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 196, 7688, 7838);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 196, 7688, 7838);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 196, 7688, 7838);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 196, 7688, 7838);
            return crossoverRate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4775.methodEnd();
        }
    }

    public MutationPolicy getMutationPolicy() {
        MethodContext _bcornu_methode_context4776 = new MethodContext(MutationPolicy.class, 204, 7845, 8007);
        try {
            CallChecker.varInit(this, "this", 204, 7845, 8007);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 204, 7845, 8007);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 204, 7845, 8007);
            CallChecker.varInit(this.mutationRate, "mutationRate", 204, 7845, 8007);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 204, 7845, 8007);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 204, 7845, 8007);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 204, 7845, 8007);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 204, 7845, 8007);
            return mutationPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MutationPolicy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4776.methodEnd();
        }
    }

    public double getMutationRate() {
        MethodContext _bcornu_methode_context4777 = new MethodContext(double.class, 212, 8014, 8160);
        try {
            CallChecker.varInit(this, "this", 212, 8014, 8160);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 212, 8014, 8160);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 212, 8014, 8160);
            CallChecker.varInit(this.mutationRate, "mutationRate", 212, 8014, 8160);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 212, 8014, 8160);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 212, 8014, 8160);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 212, 8014, 8160);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 212, 8014, 8160);
            return mutationRate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4777.methodEnd();
        }
    }

    public SelectionPolicy getSelectionPolicy() {
        MethodContext _bcornu_methode_context4778 = new MethodContext(SelectionPolicy.class, 220, 8167, 8334);
        try {
            CallChecker.varInit(this, "this", 220, 8167, 8334);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 220, 8167, 8334);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 220, 8167, 8334);
            CallChecker.varInit(this.mutationRate, "mutationRate", 220, 8167, 8334);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 220, 8167, 8334);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 220, 8167, 8334);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 220, 8167, 8334);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 220, 8167, 8334);
            return selectionPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SelectionPolicy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4778.methodEnd();
        }
    }

    public int getGenerationsEvolved() {
        MethodContext _bcornu_methode_context4779 = new MethodContext(int.class, 230, 8341, 8604);
        try {
            CallChecker.varInit(this, "this", 230, 8341, 8604);
            CallChecker.varInit(this.generationsEvolved, "generationsEvolved", 230, 8341, 8604);
            CallChecker.varInit(this.selectionPolicy, "selectionPolicy", 230, 8341, 8604);
            CallChecker.varInit(this.mutationRate, "mutationRate", 230, 8341, 8604);
            CallChecker.varInit(this.mutationPolicy, "mutationPolicy", 230, 8341, 8604);
            CallChecker.varInit(this.crossoverRate, "crossoverRate", 230, 8341, 8604);
            CallChecker.varInit(this.crossoverPolicy, "crossoverPolicy", 230, 8341, 8604);
            CallChecker.varInit(GeneticAlgorithm.randomGenerator, "org.apache.commons.math3.genetics.GeneticAlgorithm.randomGenerator", 230, 8341, 8604);
            return generationsEvolved;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4779.methodEnd();
        }
    }
}

