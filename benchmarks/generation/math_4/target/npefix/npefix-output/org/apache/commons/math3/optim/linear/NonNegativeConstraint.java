package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.optim.OptimizationData;

public class NonNegativeConstraint implements OptimizationData {
    private final boolean isRestricted;

    public NonNegativeConstraint(boolean restricted) {
        ConstructorContext _bcornu_methode_context777 = new ConstructorContext(NonNegativeConstraint.class, 35, 1240, 1424);
        try {
            isRestricted = restricted;
            CallChecker.varAssign(this.isRestricted, "this.isRestricted", 36, 1393, 1418);
        } finally {
            _bcornu_methode_context777.methodEnd();
        }
    }

    public boolean isRestrictedToNonNegative() {
        MethodContext _bcornu_methode_context3477 = new MethodContext(boolean.class, 45, 1431, 1692);
        try {
            CallChecker.varInit(this, "this", 45, 1431, 1692);
            CallChecker.varInit(this.isRestricted, "isRestricted", 45, 1431, 1692);
            return isRestricted;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3477.methodEnd();
        }
    }
}

