package org.apache.commons.math3.ode.sampling;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class DummyStepHandler implements StepHandler {
    private static class LazyHolder {
        private static final DummyStepHandler INSTANCE = new DummyStepHandler();
    }

    private DummyStepHandler() {
        ConstructorContext _bcornu_methode_context1203 = new ConstructorContext(DummyStepHandler.class, 43, 1495, 1675);
        try {
        } finally {
            _bcornu_methode_context1203.methodEnd();
        }
    }

    public static DummyStepHandler getInstance() {
        MethodContext _bcornu_methode_context5399 = new MethodContext(DummyStepHandler.class, 49, 1682, 1841);
        try {
            return DummyStepHandler.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DummyStepHandler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5399.methodEnd();
        }
    }

    public void init(double t0, double[] y0, double t) {
        MethodContext _bcornu_methode_context5400 = new MethodContext(void.class, 54, 1848, 1930);
        try {
            CallChecker.varInit(this, "this", 54, 1848, 1930);
            CallChecker.varInit(t, "t", 54, 1848, 1930);
            CallChecker.varInit(y0, "y0", 54, 1848, 1930);
            CallChecker.varInit(t0, "t0", 54, 1848, 1930);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5400.methodEnd();
        }
    }

    public void handleStep(final StepInterpolator interpolator, final boolean isLast) {
        MethodContext _bcornu_methode_context5401 = new MethodContext(void.class, 69, 1937, 2615);
        try {
            CallChecker.varInit(this, "this", 69, 1937, 2615);
            CallChecker.varInit(isLast, "isLast", 69, 1937, 2615);
            CallChecker.varInit(interpolator, "interpolator", 69, 1937, 2615);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5401.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context5402 = new MethodContext(Object.class, 85, 2947, 3209);
        try {
            CallChecker.varInit(this, "this", 85, 2947, 3209);
            return DummyStepHandler.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5402.methodEnd();
        }
    }
}

