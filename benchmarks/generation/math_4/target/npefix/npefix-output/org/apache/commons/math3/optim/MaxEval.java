package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

public class MaxEval implements OptimizationData {
    private final int maxEval;

    public MaxEval(int max) {
        ConstructorContext _bcornu_methode_context1267 = new ConstructorContext(MaxEval.class, 35, 1155, 1431);
        try {
            if (max <= 0) {
                throw new NotStrictlyPositiveException(max);
            }
            maxEval = max;
            CallChecker.varAssign(this.maxEval, "this.maxEval", 40, 1412, 1425);
        } finally {
            _bcornu_methode_context1267.methodEnd();
        }
    }

    public int getMaxEval() {
        MethodContext _bcornu_methode_context5660 = new MethodContext(int.class, 48, 1438, 1612);
        try {
            CallChecker.varInit(this, "this", 48, 1438, 1612);
            CallChecker.varInit(this.maxEval, "maxEval", 48, 1438, 1612);
            return maxEval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5660.methodEnd();
        }
    }

    public static MaxEval unlimited() {
        MethodContext _bcornu_methode_context5661 = new MethodContext(MaxEval.class, 59, 1619, 1953);
        try {
            return new MaxEval(Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MaxEval) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5661.methodEnd();
        }
    }
}

