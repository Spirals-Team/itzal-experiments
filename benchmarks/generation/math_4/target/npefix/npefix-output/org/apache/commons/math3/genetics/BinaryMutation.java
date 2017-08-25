package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class BinaryMutation implements MutationPolicy {
    public Chromosome mutate(Chromosome original) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3325 = new MethodContext(Chromosome.class, 40, 1210, 2249);
        try {
            CallChecker.varInit(this, "this", 40, 1210, 2249);
            CallChecker.varInit(original, "original", 40, 1210, 2249);
            if (!(original instanceof BinaryChromosome)) {
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_BINARY_CHROMOSOME);
            }
            BinaryChromosome origChrom = CallChecker.varInit(((BinaryChromosome) (original)), "origChrom", 45, 1754, 1810);
            List<Integer> newRepr = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(origChrom, BinaryChromosome.class, 46, 1867, 1875)) {
                origChrom = CallChecker.beforeCalled(origChrom, BinaryChromosome.class, 46, 1867, 1875);
                newRepr = new ArrayList<Integer>(CallChecker.isCalled(origChrom, BinaryChromosome.class, 46, 1867, 1875).getRepresentation());
                CallChecker.varAssign(newRepr, "newRepr", 46, 1867, 1875);
            }
            int geneIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(origChrom, BinaryChromosome.class, 49, 2004, 2012)) {
                final RandomGenerator npe_invocation_var798 = GeneticAlgorithm.getRandomGenerator();
                if (CallChecker.beforeDeref(npe_invocation_var798, RandomGenerator.class, 49, 1958, 1994)) {
                    origChrom = CallChecker.beforeCalled(origChrom, BinaryChromosome.class, 49, 2004, 2012);
                    geneIndex = CallChecker.isCalled(npe_invocation_var798, RandomGenerator.class, 49, 1958, 1994).nextInt(CallChecker.isCalled(origChrom, BinaryChromosome.class, 49, 2004, 2012).getLength());
                    CallChecker.varAssign(geneIndex, "geneIndex", 49, 2004, 2012);
                }
            }
            if (CallChecker.beforeDeref(origChrom, BinaryChromosome.class, 51, 2084, 2092)) {
                origChrom = CallChecker.beforeCalled(origChrom, BinaryChromosome.class, 51, 2084, 2092);
                final List<Integer> npe_invocation_var799 = CallChecker.isCalled(origChrom, BinaryChromosome.class, 51, 2084, 2092).getRepresentation();
                if (CallChecker.beforeDeref(npe_invocation_var799, List.class, 51, 2084, 2112)) {
                    if ((CallChecker.isCalled(npe_invocation_var799, List.class, 51, 2084, 2112).get(geneIndex)) == 0) {
                        if (CallChecker.beforeDeref(newRepr, List.class, 51, 2061, 2067)) {
                            newRepr = CallChecker.beforeCalled(newRepr, List.class, 51, 2061, 2067);
                            CallChecker.isCalled(newRepr, List.class, 51, 2061, 2067).set(geneIndex, 1);
                        }
                    }else {
                        if (CallChecker.beforeDeref(newRepr, List.class, 51, 2061, 2067)) {
                            newRepr = CallChecker.beforeCalled(newRepr, List.class, 51, 2061, 2067);
                            CallChecker.isCalled(newRepr, List.class, 51, 2061, 2067).set(geneIndex, 0);
                        }
                    }
                }
            }
            Chromosome newChrom = CallChecker.init(Chromosome.class);
            if (CallChecker.beforeDeref(origChrom, BinaryChromosome.class, 53, 2175, 2183)) {
                origChrom = CallChecker.beforeCalled(origChrom, BinaryChromosome.class, 53, 2175, 2183);
                newChrom = CallChecker.isCalled(origChrom, BinaryChromosome.class, 53, 2175, 2183).newFixedLengthChromosome(newRepr);
                CallChecker.varAssign(newChrom, "newChrom", 53, 2175, 2183);
            }
            return newChrom;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3325.methodEnd();
        }
    }
}

