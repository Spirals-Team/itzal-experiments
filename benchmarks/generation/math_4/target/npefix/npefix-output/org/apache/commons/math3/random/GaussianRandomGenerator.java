package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class GaussianRandomGenerator implements NormalizedRandomGenerator {
    private final RandomGenerator generator;

    public GaussianRandomGenerator(final RandomGenerator generator) {
        ConstructorContext _bcornu_methode_context531 = new ConstructorContext(GaussianRandomGenerator.class, 36, 1215, 1420);
        try {
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 37, 1388, 1414);
        } finally {
            _bcornu_methode_context531.methodEnd();
        }
    }

    public double nextNormalizedDouble() {
        MethodContext _bcornu_methode_context2495 = new MethodContext(double.class, 43, 1427, 1670);
        try {
            CallChecker.varInit(this, "this", 43, 1427, 1670);
            CallChecker.varInit(this.generator, "generator", 43, 1427, 1670);
            if (CallChecker.beforeDeref(generator, RandomGenerator.class, 44, 1640, 1648)) {
                return CallChecker.isCalled(generator, RandomGenerator.class, 44, 1640, 1648).nextGaussian();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2495.methodEnd();
        }
    }
}

