package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

public abstract class BinaryChromosome extends AbstractListChromosome<Integer> {
    public BinaryChromosome(List<Integer> representation) throws InvalidRepresentationException {
        super(representation);
        ConstructorContext _bcornu_methode_context38 = new ConstructorContext(BinaryChromosome.class, 37, 1145, 1507);
        try {
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public BinaryChromosome(Integer[] representation) throws InvalidRepresentationException {
        super(representation);
        ConstructorContext _bcornu_methode_context39 = new ConstructorContext(BinaryChromosome.class, 46, 1514, 1873);
        try {
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    @Override
    protected void checkValidity(List<Integer> chromosomeRepresentation) throws InvalidRepresentationException {
        MethodContext _bcornu_methode_context125 = new MethodContext(void.class, 54, 1880, 2307);
        try {
            CallChecker.varInit(this, "this", 54, 1880, 2307);
            CallChecker.varInit(chromosomeRepresentation, "chromosomeRepresentation", 54, 1880, 2307);
            if (CallChecker.beforeDeref(chromosomeRepresentation, void.class, 55, 2061, 2084)) {
                for (int i : chromosomeRepresentation) {
                    if ((i < 0) || (i > 1)) {
                        throw new InvalidRepresentationException(LocalizedFormats.INVALID_BINARY_DIGIT, i);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public static List<Integer> randomBinaryRepresentation(int length) {
        MethodContext _bcornu_methode_context126 = new MethodContext(List.class, 68, 2314, 2835);
        try {
            CallChecker.varInit(length, "length", 68, 2314, 2835);
            List<Integer> rList = CallChecker.varInit(new ArrayList<Integer>(length), "rList", 70, 2633, 2685);
            for (int j = 0; j < length; j++) {
                final RandomGenerator npe_invocation_var5 = GeneticAlgorithm.getRandomGenerator();
                if (CallChecker.beforeDeref(npe_invocation_var5, RandomGenerator.class, 72, 2748, 2784)) {
                    if (CallChecker.beforeDeref(rList, List.class, 72, 2738, 2742)) {
                        rList = CallChecker.beforeCalled(rList, List.class, 72, 2738, 2742);
                        CallChecker.isCalled(rList, List.class, 72, 2738, 2742).add(CallChecker.isCalled(npe_invocation_var5, RandomGenerator.class, 72, 2748, 2784).nextInt(2));
                    }
                }
            }
            return rList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    @Override
    protected boolean isSame(Chromosome another) {
        MethodContext _bcornu_methode_context127 = new MethodContext(boolean.class, 78, 2842, 3446);
        try {
            CallChecker.varInit(this, "this", 78, 2842, 3446);
            CallChecker.varInit(another, "another", 78, 2842, 3446);
            if (!(another instanceof BinaryChromosome)) {
                return false;
            }
            BinaryChromosome anotherBc = CallChecker.varInit(((BinaryChromosome) (another)), "anotherBc", 83, 3024, 3079);
            if (CallChecker.beforeDeref(anotherBc, BinaryChromosome.class, 85, 3130, 3138)) {
                anotherBc = CallChecker.beforeCalled(anotherBc, BinaryChromosome.class, 85, 3130, 3138);
                if ((getLength()) != (CallChecker.isCalled(anotherBc, BinaryChromosome.class, 85, 3130, 3138).getLength())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(getRepresentation(), List.class, 89, 3217, 3235).size()); i++) {
                final List<Integer> npe_invocation_var6 = getRepresentation();
                if (CallChecker.beforeDeref(npe_invocation_var6, List.class, 90, 3270, 3288)) {
                    if (CallChecker.beforeDeref(anotherBc, BinaryChromosome.class, 90, 3304, 3312)) {
                        anotherBc = CallChecker.beforeCalled(anotherBc, BinaryChromosome.class, 90, 3304, 3312);
                        final List<Integer> npe_invocation_var7 = CallChecker.isCalled(anotherBc, BinaryChromosome.class, 90, 3304, 3312).getRepresentation();
                        if (CallChecker.beforeDeref(npe_invocation_var7, List.class, 90, 3304, 3332)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var6, List.class, 90, 3270, 3288).get(i), Integer.class, 90, 3270, 3295)) {
                                if (!(CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var6, List.class, 90, 3270, 3288).get(i), Integer.class, 90, 3270, 3295).equals(CallChecker.isCalled(npe_invocation_var7, List.class, 90, 3304, 3332).get(i)))) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }
}

