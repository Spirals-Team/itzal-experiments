package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NumberIsTooLargeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 4330003017885151975L;

    private final Number max;

    private final boolean boundIsAllowed;

    public NumberIsTooLargeException(Number wrong, Number max, boolean boundIsAllowed) {
        this((boundIsAllowed ? LocalizedFormats.NUMBER_TOO_LARGE : LocalizedFormats.NUMBER_TOO_LARGE_BOUND_EXCLUDED), wrong, max, boundIsAllowed);
        ConstructorContext _bcornu_methode_context276 = new ConstructorContext(NumberIsTooLargeException.class, 47, 1444, 2015);
        try {
        } finally {
            _bcornu_methode_context276.methodEnd();
        }
    }

    public NumberIsTooLargeException(Localizable specific, Number wrong, Number max, boolean boundIsAllowed) {
        super(specific, wrong, max);
        ConstructorContext _bcornu_methode_context277 = new ConstructorContext(NumberIsTooLargeException.class, 63, 2021, 2648);
        try {
            this.max = max;
            CallChecker.varAssign(this.max, "this.max", 69, 2582, 2596);
            this.boundIsAllowed = boundIsAllowed;
            CallChecker.varAssign(this.boundIsAllowed, "this.boundIsAllowed", 70, 2606, 2642);
        } finally {
            _bcornu_methode_context277.methodEnd();
        }
    }

    public boolean getBoundIsAllowed() {
        MethodContext _bcornu_methode_context1215 = new MethodContext(boolean.class, 76, 2655, 2820);
        try {
            CallChecker.varInit(this, "this", 76, 2655, 2820);
            CallChecker.varInit(this.boundIsAllowed, "boundIsAllowed", 76, 2655, 2820);
            CallChecker.varInit(this.max, "max", 76, 2655, 2820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NumberIsTooLargeException.serialVersionUID", 76, 2655, 2820);
            return boundIsAllowed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1215.methodEnd();
        }
    }

    public Number getMax() {
        MethodContext _bcornu_methode_context1216 = new MethodContext(Number.class, 83, 2827, 2920);
        try {
            CallChecker.varInit(this, "this", 83, 2827, 2920);
            CallChecker.varInit(this.boundIsAllowed, "boundIsAllowed", 83, 2827, 2920);
            CallChecker.varInit(this.max, "max", 83, 2827, 2920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NumberIsTooLargeException.serialVersionUID", 83, 2827, 2920);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1216.methodEnd();
        }
    }
}

