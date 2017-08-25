package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NumberIsTooSmallException extends MathIllegalNumberException {
    private static final long serialVersionUID = -6100997100383932834L;

    private final Number min;

    private final boolean boundIsAllowed;

    public NumberIsTooSmallException(Number wrong, Number min, boolean boundIsAllowed) {
        this((boundIsAllowed ? LocalizedFormats.NUMBER_TOO_SMALL : LocalizedFormats.NUMBER_TOO_SMALL_BOUND_EXCLUDED), wrong, min, boundIsAllowed);
        ConstructorContext _bcornu_methode_context1110 = new ConstructorContext(NumberIsTooSmallException.class, 47, 1445, 2017);
        try {
        } finally {
            _bcornu_methode_context1110.methodEnd();
        }
    }

    public NumberIsTooSmallException(Localizable specific, Number wrong, Number min, boolean boundIsAllowed) {
        super(specific, wrong, min);
        ConstructorContext _bcornu_methode_context1111 = new ConstructorContext(NumberIsTooSmallException.class, 64, 2024, 2652);
        try {
            this.min = min;
            CallChecker.varAssign(this.min, "this.min", 70, 2586, 2600);
            this.boundIsAllowed = boundIsAllowed;
            CallChecker.varAssign(this.boundIsAllowed, "this.boundIsAllowed", 71, 2610, 2646);
        } finally {
            _bcornu_methode_context1111.methodEnd();
        }
    }

    public boolean getBoundIsAllowed() {
        MethodContext _bcornu_methode_context4942 = new MethodContext(boolean.class, 77, 2659, 2824);
        try {
            CallChecker.varInit(this, "this", 77, 2659, 2824);
            CallChecker.varInit(this.boundIsAllowed, "boundIsAllowed", 77, 2659, 2824);
            CallChecker.varInit(this.min, "min", 77, 2659, 2824);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NumberIsTooSmallException.serialVersionUID", 77, 2659, 2824);
            return boundIsAllowed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4942.methodEnd();
        }
    }

    public Number getMin() {
        MethodContext _bcornu_methode_context4943 = new MethodContext(Number.class, 84, 2831, 2924);
        try {
            CallChecker.varInit(this, "this", 84, 2831, 2924);
            CallChecker.varInit(this.boundIsAllowed, "boundIsAllowed", 84, 2831, 2924);
            CallChecker.varInit(this.min, "min", 84, 2831, 2924);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NumberIsTooSmallException.serialVersionUID", 84, 2831, 2924);
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4943.methodEnd();
        }
    }
}

