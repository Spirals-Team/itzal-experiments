package org.apache.commons.math3.ode.sampling;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public enum StepNormalizerBounds {
NEITHER(false,false), FIRST(true,false), LAST(false,true), BOTH(true,true);
    private final boolean first;

    private final boolean last;

    private StepNormalizerBounds(final boolean first, final boolean last) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(StepNormalizerBounds.class, 60, 1930, 2333);
        try {
            this.first = first;
            CallChecker.varAssign(this.first, "this.first", 61, 2283, 2301);
            this.last = last;
            CallChecker.varAssign(this.last, "this.last", 62, 2311, 2327);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public boolean firstIncluded() {
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class, 71, 2340, 2673);
        try {
            CallChecker.varInit(this, "this", 71, 2340, 2673);
            return first;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public boolean lastIncluded() {
        MethodContext _bcornu_methode_context5 = new MethodContext(boolean.class, 81, 2680, 3009);
        try {
            CallChecker.varInit(this, "this", 81, 2680, 3009);
            return last;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }
}

