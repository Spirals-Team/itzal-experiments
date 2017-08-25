package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Space;

public class BoundaryAttribute<S extends Space> {
    private final SubHyperplane<S> plusOutside;

    private final SubHyperplane<S> plusInside;

    public BoundaryAttribute(final SubHyperplane<S> plusOutside, final SubHyperplane<S> plusInside) {
        ConstructorContext _bcornu_methode_context776 = new ConstructorContext(BoundaryAttribute.class, 56, 1917, 2559);
        try {
            this.plusOutside = plusOutside;
            CallChecker.varAssign(this.plusOutside, "this.plusOutside", 58, 2484, 2514);
            this.plusInside = plusInside;
            CallChecker.varAssign(this.plusInside, "this.plusInside", 59, 2524, 2553);
        } finally {
            _bcornu_methode_context776.methodEnd();
        }
    }

    public SubHyperplane<S> getPlusOutside() {
        MethodContext _bcornu_methode_context3475 = new MethodContext(SubHyperplane.class, 69, 2566, 2999);
        try {
            CallChecker.varInit(this, "this", 69, 2566, 2999);
            CallChecker.varInit(this.plusInside, "plusInside", 69, 2566, 2999);
            CallChecker.varInit(this.plusOutside, "plusOutside", 69, 2566, 2999);
            return plusOutside;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3475.methodEnd();
        }
    }

    public SubHyperplane<S> getPlusInside() {
        MethodContext _bcornu_methode_context3476 = new MethodContext(SubHyperplane.class, 80, 3006, 3435);
        try {
            CallChecker.varInit(this, "this", 80, 3006, 3435);
            CallChecker.varInit(this.plusInside, "plusInside", 80, 3006, 3435);
            CallChecker.varInit(this.plusOutside, "plusOutside", 80, 3006, 3435);
            return plusInside;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3476.methodEnd();
        }
    }
}

