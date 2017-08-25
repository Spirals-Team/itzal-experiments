package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;

public class MathIllegalNumberException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7447085893598031110L;

    private final Number argument;

    protected MathIllegalNumberException(Localizable pattern, Number wrong, Object... arguments) {
        super(pattern, wrong, arguments);
        ConstructorContext _bcornu_methode_context315 = new ConstructorContext(MathIllegalNumberException.class, 43, 1457, 1873);
        try {
            argument = wrong;
            CallChecker.varAssign(this.argument, "this.argument", 47, 1851, 1867);
        } finally {
            _bcornu_methode_context315.methodEnd();
        }
    }

    public Number getArgument() {
        MethodContext _bcornu_methode_context1467 = new MethodContext(Number.class, 53, 1880, 1991);
        try {
            CallChecker.varInit(this, "this", 53, 1880, 1991);
            CallChecker.varInit(this.argument, "argument", 53, 1880, 1991);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MathIllegalNumberException.serialVersionUID", 53, 1880, 1991);
            return argument;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1467.methodEnd();
        }
    }
}

