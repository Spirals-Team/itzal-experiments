package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooSmallException;

public class FixedGenerationCount implements StoppingCondition {
    private int numGenerations = 0;

    private final int maxGenerations;

    public FixedGenerationCount(final int maxGenerations) throws NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context1140 = new ConstructorContext(FixedGenerationCount.class, 42, 1481, 1954);
        try {
            if (maxGenerations <= 0) {
                throw new NumberIsTooSmallException(maxGenerations, 1, true);
            }
            this.maxGenerations = maxGenerations;
            CallChecker.varAssign(this.maxGenerations, "this.maxGenerations", 46, 1912, 1948);
        } finally {
            _bcornu_methode_context1140.methodEnd();
        }
    }

    public boolean isSatisfied(final Population population) {
        MethodContext _bcornu_methode_context5153 = new MethodContext(boolean.class, 56, 1961, 2500);
        try {
            CallChecker.varInit(this, "this", 56, 1961, 2500);
            CallChecker.varInit(population, "population", 56, 1961, 2500);
            CallChecker.varInit(this.maxGenerations, "maxGenerations", 56, 1961, 2500);
            CallChecker.varInit(this.numGenerations, "numGenerations", 56, 1961, 2500);
            if ((this.numGenerations) < (this.maxGenerations)) {
                (numGenerations)++;
                return false;
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5153.methodEnd();
        }
    }

    public int getNumGenerations() {
        MethodContext _bcornu_methode_context5154 = new MethodContext(int.class, 68, 2507, 2716);
        try {
            CallChecker.varInit(this, "this", 68, 2507, 2716);
            CallChecker.varInit(this.maxGenerations, "maxGenerations", 68, 2507, 2716);
            CallChecker.varInit(this.numGenerations, "numGenerations", 68, 2507, 2716);
            return numGenerations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5154.methodEnd();
        }
    }
}

