package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class OutOfRangeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 111601815794403609L;

    private final Number lo;

    private final Number hi;

    public OutOfRangeException(Number wrong, Number lo, Number hi) {
        this(LocalizedFormats.OUT_OF_RANGE_SIMPLE, wrong, lo, hi);
        ConstructorContext _bcornu_methode_context1162 = new ConstructorContext(OutOfRangeException.class, 43, 1366, 1747);
        try {
        } finally {
            _bcornu_methode_context1162.methodEnd();
        }
    }

    public OutOfRangeException(Localizable specific, Number wrong, Number lo, Number hi) {
        super(specific, wrong, lo, hi);
        ConstructorContext _bcornu_methode_context1163 = new ConstructorContext(OutOfRangeException.class, 58, 1754, 2292);
        try {
            this.lo = lo;
            CallChecker.varAssign(this.lo, "this.lo", 63, 2252, 2264);
            this.hi = hi;
            CallChecker.varAssign(this.hi, "this.hi", 64, 2274, 2286);
        } finally {
            _bcornu_methode_context1163.methodEnd();
        }
    }

    public Number getLo() {
        MethodContext _bcornu_methode_context5249 = new MethodContext(Number.class, 70, 2299, 2394);
        try {
            CallChecker.varInit(this, "this", 70, 2299, 2394);
            CallChecker.varInit(this.hi, "hi", 70, 2299, 2394);
            CallChecker.varInit(this.lo, "lo", 70, 2299, 2394);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.OutOfRangeException.serialVersionUID", 70, 2299, 2394);
            return lo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5249.methodEnd();
        }
    }

    public Number getHi() {
        MethodContext _bcornu_methode_context5250 = new MethodContext(Number.class, 76, 2400, 2496);
        try {
            CallChecker.varInit(this, "this", 76, 2400, 2496);
            CallChecker.varInit(this.hi, "hi", 76, 2400, 2496);
            CallChecker.varInit(this.lo, "lo", 76, 2400, 2496);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.OutOfRangeException.serialVersionUID", 76, 2400, 2496);
            return hi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5250.methodEnd();
        }
    }
}

