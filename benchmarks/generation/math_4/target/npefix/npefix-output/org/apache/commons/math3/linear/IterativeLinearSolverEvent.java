package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.util.IterationEvent;

public abstract class IterativeLinearSolverEvent extends IterationEvent {
    private static final long serialVersionUID = 20120129L;

    public IterativeLinearSolverEvent(final Object source, final int iterations) {
        super(source, iterations);
        ConstructorContext _bcornu_methode_context1209 = new ConstructorContext(IterativeLinearSolverEvent.class, 42, 1309, 1694);
        try {
        } finally {
            _bcornu_methode_context1209.methodEnd();
        }
    }

    public abstract RealVector getRightHandSideVector();

    public abstract double getNormOfResidual();

    public RealVector getResidual() {
        MethodContext _bcornu_methode_context5480 = new MethodContext(RealVector.class, 92, 3070, 3829);
        try {
            CallChecker.varInit(this, "this", 92, 3070, 3829);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.IterativeLinearSolverEvent.serialVersionUID", 92, 3070, 3829);
            throw new MathUnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5480.methodEnd();
        }
    }

    public abstract RealVector getSolution();

    public boolean providesResidual() {
        MethodContext _bcornu_methode_context5482 = new MethodContext(boolean.class, 113, 4234, 4557);
        try {
            CallChecker.varInit(this, "this", 113, 4234, 4557);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.IterativeLinearSolverEvent.serialVersionUID", 113, 4234, 4557);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5482.methodEnd();
        }
    }
}

