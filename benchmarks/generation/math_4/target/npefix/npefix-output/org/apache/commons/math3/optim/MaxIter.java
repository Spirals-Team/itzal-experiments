package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

public class MaxIter implements OptimizationData {
    private final int maxIter;

    public MaxIter(int max) {
        ConstructorContext _bcornu_methode_context890 = new ConstructorContext(MaxIter.class, 35, 1160, 1434);
        try {
            if (max <= 0) {
                throw new NotStrictlyPositiveException(max);
            }
            maxIter = max;
            CallChecker.varAssign(this.maxIter, "this.maxIter", 40, 1415, 1428);
        } finally {
            _bcornu_methode_context890.methodEnd();
        }
    }

    public int getMaxIter() {
        MethodContext _bcornu_methode_context3970 = new MethodContext(int.class, 48, 1441, 1615);
        try {
            CallChecker.varInit(this, "this", 48, 1441, 1615);
            CallChecker.varInit(this.maxIter, "maxIter", 48, 1441, 1615);
            return maxIter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3970.methodEnd();
        }
    }

    public static MaxIter unlimited() {
        MethodContext _bcornu_methode_context3971 = new MethodContext(MaxIter.class, 59, 1622, 1955);
        try {
            return new MaxIter(Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MaxIter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3971.methodEnd();
        }
    }
}

