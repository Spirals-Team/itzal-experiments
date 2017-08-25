package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class UnknownParameterException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 20120902L;

    private final String name;

    public UnknownParameterException(final String name) {
        super(LocalizedFormats.UNKNOWN_PARAMETER);
        ConstructorContext _bcornu_methode_context14 = new ConstructorContext(UnknownParameterException.class, 41, 1316, 1567);
        try {
            this.name = name;
            CallChecker.varAssign(this.name, "this.name", 43, 1545, 1561);
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public String getName() {
        MethodContext _bcornu_methode_context65 = new MethodContext(String.class, 49, 1574, 1691);
        try {
            CallChecker.varInit(this, "this", 49, 1574, 1691);
            CallChecker.varInit(this.name, "name", 49, 1574, 1691);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.UnknownParameterException.serialVersionUID", 49, 1574, 1691);
            return name;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }
}

