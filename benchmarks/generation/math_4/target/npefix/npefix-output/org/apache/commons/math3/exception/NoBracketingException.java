package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NoBracketingException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -3629324471511904459L;

    private final double lo;

    private final double hi;

    private final double fLo;

    private final double fHi;

    public NoBracketingException(double lo, double hi, double fLo, double fHi) {
        this(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, lo, hi, fLo, fHi);
        ConstructorContext _bcornu_methode_context1078 = new ConstructorContext(NoBracketingException.class, 49, 1591, 2031);
        try {
        } finally {
            _bcornu_methode_context1078.methodEnd();
        }
    }

    public NoBracketingException(Localizable specific, double lo, double hi, double fLo, double fHi, Object... args) {
        super(specific, lo, hi, fLo, fHi, args);
        ConstructorContext _bcornu_methode_context1079 = new ConstructorContext(NoBracketingException.class, 64, 2038, 2792);
        try {
            this.lo = lo;
            CallChecker.varAssign(this.lo, "this.lo", 69, 2704, 2716);
            this.hi = hi;
            CallChecker.varAssign(this.hi, "this.hi", 70, 2726, 2738);
            this.fLo = fLo;
            CallChecker.varAssign(this.fLo, "this.fLo", 71, 2748, 2762);
            this.fHi = fHi;
            CallChecker.varAssign(this.fHi, "this.fHi", 72, 2772, 2786);
        } finally {
            _bcornu_methode_context1079.methodEnd();
        }
    }

    public double getLo() {
        MethodContext _bcornu_methode_context4810 = new MethodContext(double.class, 80, 2799, 2941);
        try {
            CallChecker.varInit(this, "this", 80, 2799, 2941);
            CallChecker.varInit(this.fHi, "fHi", 80, 2799, 2941);
            CallChecker.varInit(this.fLo, "fLo", 80, 2799, 2941);
            CallChecker.varInit(this.hi, "hi", 80, 2799, 2941);
            CallChecker.varInit(this.lo, "lo", 80, 2799, 2941);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NoBracketingException.serialVersionUID", 80, 2799, 2941);
            return lo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4810.methodEnd();
        }
    }

    public double getHi() {
        MethodContext _bcornu_methode_context4811 = new MethodContext(double.class, 88, 2947, 3091);
        try {
            CallChecker.varInit(this, "this", 88, 2947, 3091);
            CallChecker.varInit(this.fHi, "fHi", 88, 2947, 3091);
            CallChecker.varInit(this.fLo, "fLo", 88, 2947, 3091);
            CallChecker.varInit(this.hi, "hi", 88, 2947, 3091);
            CallChecker.varInit(this.lo, "lo", 88, 2947, 3091);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NoBracketingException.serialVersionUID", 88, 2947, 3091);
            return hi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4811.methodEnd();
        }
    }

    public double getFLo() {
        MethodContext _bcornu_methode_context4812 = new MethodContext(double.class, 96, 3097, 3267);
        try {
            CallChecker.varInit(this, "this", 96, 3097, 3267);
            CallChecker.varInit(this.fHi, "fHi", 96, 3097, 3267);
            CallChecker.varInit(this.fLo, "fLo", 96, 3097, 3267);
            CallChecker.varInit(this.hi, "hi", 96, 3097, 3267);
            CallChecker.varInit(this.lo, "lo", 96, 3097, 3267);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NoBracketingException.serialVersionUID", 96, 3097, 3267);
            return fLo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4812.methodEnd();
        }
    }

    public double getFHi() {
        MethodContext _bcornu_methode_context4813 = new MethodContext(double.class, 104, 3273, 3445);
        try {
            CallChecker.varInit(this, "this", 104, 3273, 3445);
            CallChecker.varInit(this.fHi, "fHi", 104, 3273, 3445);
            CallChecker.varInit(this.fLo, "fLo", 104, 3273, 3445);
            CallChecker.varInit(this.hi, "hi", 104, 3273, 3445);
            CallChecker.varInit(this.lo, "lo", 104, 3273, 3445);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.NoBracketingException.serialVersionUID", 104, 3273, 3445);
            return fHi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4813.methodEnd();
        }
    }
}

