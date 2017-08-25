package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Random;

public class JDKRandomGenerator extends Random implements RandomGenerator {
    private static final long serialVersionUID = -7745277476784028798L;

    public void setSeed(int seed) {
        MethodContext _bcornu_methode_context2933 = new MethodContext(void.class, 34, 1198, 1289);
        try {
            CallChecker.varInit(this, "this", 34, 1198, 1289);
            CallChecker.varInit(seed, "seed", 34, 1198, 1289);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.JDKRandomGenerator.serialVersionUID", 34, 1198, 1289);
            setSeed(((long) (seed)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2933.methodEnd();
        }
    }

    public void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context2934 = new MethodContext(void.class, 39, 1296, 1630);
        try {
            CallChecker.varInit(this, "this", 39, 1296, 1630);
            CallChecker.varInit(seed, "seed", 39, 1296, 1630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.JDKRandomGenerator.serialVersionUID", 39, 1296, 1630);
            final long prime = CallChecker.varInit(((long) (4294967291L)), "prime", 41, 1363, 1484);
            long combined = CallChecker.varInit(((long) (0L)), "combined", 43, 1495, 1513);
            if (CallChecker.beforeDeref(seed, void.class, 44, 1536, 1539)) {
                for (int s : seed) {
                    combined = (combined * prime) + s;
                    CallChecker.varAssign(combined, "combined", 45, 1556, 1587);
                }
            }
            setSeed(combined);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2934.methodEnd();
        }
    }
}

