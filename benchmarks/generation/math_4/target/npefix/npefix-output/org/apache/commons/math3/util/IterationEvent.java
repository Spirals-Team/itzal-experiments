package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.EventObject;

public class IterationEvent extends EventObject {
    private static final long serialVersionUID = 20120128L;

    private final int iterations;

    public IterationEvent(final Object source, final int iterations) {
        super(source);
        ConstructorContext _bcornu_methode_context1232 = new ConstructorContext(IterationEvent.class, 42, 1231, 1630);
        try {
            this.iterations = iterations;
            CallChecker.varAssign(this.iterations, "this.iterations", 44, 1596, 1624);
        } finally {
            _bcornu_methode_context1232.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context5545 = new MethodContext(int.class, 53, 1637, 1870);
        try {
            CallChecker.varInit(this, "this", 53, 1637, 1870);
            CallChecker.varInit(this.iterations, "iterations", 53, 1637, 1870);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.IterationEvent.serialVersionUID", 53, 1637, 1870);
            return iterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5545.methodEnd();
        }
    }
}

