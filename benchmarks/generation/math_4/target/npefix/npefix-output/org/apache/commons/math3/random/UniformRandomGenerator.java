package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class UniformRandomGenerator implements NormalizedRandomGenerator {
    private static final double SQRT3 = FastMath.sqrt(3.0);

    private final RandomGenerator generator;

    public UniformRandomGenerator(RandomGenerator generator) {
        ConstructorContext _bcornu_methode_context837 = new ConstructorContext(UniformRandomGenerator.class, 45, 1486, 1684);
        try {
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 46, 1652, 1678);
        } finally {
            _bcornu_methode_context837.methodEnd();
        }
    }

    public double nextNormalizedDouble() {
        MethodContext _bcornu_methode_context3647 = new MethodContext(double.class, 54, 1691, 2054);
        try {
            CallChecker.varInit(this, "this", 54, 1691, 2054);
            CallChecker.varInit(this.generator, "generator", 54, 1691, 2054);
            CallChecker.varInit(SQRT3, "org.apache.commons.math3.random.UniformRandomGenerator.SQRT3", 54, 1691, 2054);
            return (UniformRandomGenerator.SQRT3) * ((2 * (CallChecker.isCalled(generator, RandomGenerator.class, 55, 2019, 2027).nextDouble())) - 1.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3647.methodEnd();
        }
    }
}

