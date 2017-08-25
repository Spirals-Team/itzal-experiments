package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public class RandomKeyMutation implements MutationPolicy {
    public Chromosome mutate(final Chromosome original) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3428 = new MethodContext(Chromosome.class, 39, 1303, 2198);
        try {
            CallChecker.varInit(this, "this", 39, 1303, 2198);
            CallChecker.varInit(original, "original", 39, 1303, 2198);
            if (!(original instanceof RandomKey<?>)) {
                if (CallChecker.beforeDeref(original, Chromosome.class, 42, 1744, 1751)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(original, Chromosome.class, 42, 1744, 1751).getClass(), Class.class, 42, 1744, 1762)) {
                        throw new MathIllegalArgumentException(LocalizedFormats.RANDOMKEY_MUTATION_WRONG_CLASS, CallChecker.isCalled(CallChecker.isCalled(original, Chromosome.class, 42, 1744, 1751).getClass(), Class.class, 42, 1744, 1762).getSimpleName());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            RandomKey<?> originalRk = CallChecker.varInit(((RandomKey<?>) (original)), "originalRk", 45, 1801, 1850);
            List<Double> repr = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(originalRk, RandomKey.class, 46, 1880, 1889)) {
                originalRk = CallChecker.beforeCalled(originalRk, RandomKey.class, 46, 1880, 1889);
                repr = CallChecker.isCalled(originalRk, RandomKey.class, 46, 1880, 1889).getRepresentation();
                CallChecker.varAssign(repr, "repr", 46, 1880, 1889);
            }
            int rInd = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(repr, List.class, 47, 1977, 1980)) {
                final RandomGenerator npe_invocation_var809 = GeneticAlgorithm.getRandomGenerator();
                if (CallChecker.beforeDeref(npe_invocation_var809, RandomGenerator.class, 47, 1931, 1967)) {
                    repr = CallChecker.beforeCalled(repr, List.class, 47, 1977, 1980);
                    rInd = CallChecker.isCalled(npe_invocation_var809, RandomGenerator.class, 47, 1931, 1967).nextInt(CallChecker.isCalled(repr, List.class, 47, 1977, 1980).size());
                    CallChecker.varAssign(rInd, "rInd", 47, 1977, 1980);
                }
            }
            List<Double> newRepr = CallChecker.varInit(new ArrayList<Double>(repr), "newRepr", 49, 2000, 2051);
            final RandomGenerator npe_invocation_var810 = GeneticAlgorithm.getRandomGenerator();
            if (CallChecker.beforeDeref(npe_invocation_var810, RandomGenerator.class, 50, 2079, 2115)) {
                if (CallChecker.beforeDeref(newRepr, List.class, 50, 2061, 2067)) {
                    newRepr = CallChecker.beforeCalled(newRepr, List.class, 50, 2061, 2067);
                    CallChecker.isCalled(newRepr, List.class, 50, 2061, 2067).set(rInd, CallChecker.isCalled(npe_invocation_var810, RandomGenerator.class, 50, 2079, 2115).nextDouble());
                }
            }
            if (CallChecker.beforeDeref(originalRk, RandomKey.class, 52, 2148, 2157)) {
                originalRk = CallChecker.beforeCalled(originalRk, RandomKey.class, 52, 2148, 2157);
                return CallChecker.isCalled(originalRk, RandomKey.class, 52, 2148, 2157).newFixedLengthChromosome(newRepr);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3428.methodEnd();
        }
    }
}

