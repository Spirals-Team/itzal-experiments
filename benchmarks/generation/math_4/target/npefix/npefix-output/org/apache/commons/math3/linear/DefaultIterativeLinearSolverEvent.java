package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;

public class DefaultIterativeLinearSolverEvent extends IterativeLinearSolverEvent {
    private static final long serialVersionUID = 20120129L;

    private final RealVector b;

    private final RealVector r;

    private final double rnorm;

    private final RealVector x;

    public DefaultIterativeLinearSolverEvent(final Object source, final int iterations, final RealVector x, final RealVector b, final RealVector r, final double rnorm) {
        super(source, iterations);
        ConstructorContext _bcornu_methode_context1039 = new ConstructorContext(DefaultIterativeLinearSolverEvent.class, 63, 1540, 2907);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 67, 2823, 2833);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 68, 2843, 2853);
            this.r = r;
            CallChecker.varAssign(this.r, "this.r", 69, 2863, 2873);
            this.rnorm = rnorm;
            CallChecker.varAssign(this.rnorm, "this.rnorm", 70, 2883, 2901);
        } finally {
            _bcornu_methode_context1039.methodEnd();
        }
    }

    public DefaultIterativeLinearSolverEvent(final Object source, final int iterations, final RealVector x, final RealVector b, final double rnorm) {
        super(source, iterations);
        ConstructorContext _bcornu_methode_context1040 = new ConstructorContext(DefaultIterativeLinearSolverEvent.class, 91, 2914, 4168);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 94, 4081, 4091);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 95, 4101, 4111);
            this.r = null;
            CallChecker.varAssign(this.r, "this.r", 96, 4121, 4134);
            this.rnorm = rnorm;
            CallChecker.varAssign(this.rnorm, "this.rnorm", 97, 4144, 4162);
        } finally {
            _bcornu_methode_context1040.methodEnd();
        }
    }

    @Override
    public double getNormOfResidual() {
        MethodContext _bcornu_methode_context4608 = new MethodContext(double.class, 102, 4175, 4276);
        try {
            CallChecker.varInit(this, "this", 102, 4175, 4276);
            CallChecker.varInit(this.x, "x", 102, 4175, 4276);
            CallChecker.varInit(this.rnorm, "rnorm", 102, 4175, 4276);
            CallChecker.varInit(this.r, "r", 102, 4175, 4276);
            CallChecker.varInit(this.b, "b", 102, 4175, 4276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DefaultIterativeLinearSolverEvent.serialVersionUID", 102, 4175, 4276);
            return rnorm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4608.methodEnd();
        }
    }

    @Override
    public RealVector getResidual() {
        MethodContext _bcornu_methode_context4609 = new MethodContext(RealVector.class, 113, 4283, 4644);
        try {
            CallChecker.varInit(this, "this", 113, 4283, 4644);
            CallChecker.varInit(this.x, "x", 113, 4283, 4644);
            CallChecker.varInit(this.rnorm, "rnorm", 113, 4283, 4644);
            CallChecker.varInit(this.r, "r", 113, 4283, 4644);
            CallChecker.varInit(this.b, "b", 113, 4283, 4644);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DefaultIterativeLinearSolverEvent.serialVersionUID", 113, 4283, 4644);
            if ((r) != null) {
                return r;
            }
            throw new MathUnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4609.methodEnd();
        }
    }

    @Override
    public RealVector getRightHandSideVector() {
        MethodContext _bcornu_methode_context4610 = new MethodContext(RealVector.class, 122, 4651, 4757);
        try {
            CallChecker.varInit(this, "this", 122, 4651, 4757);
            CallChecker.varInit(this.x, "x", 122, 4651, 4757);
            CallChecker.varInit(this.rnorm, "rnorm", 122, 4651, 4757);
            CallChecker.varInit(this.r, "r", 122, 4651, 4757);
            CallChecker.varInit(this.b, "b", 122, 4651, 4757);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DefaultIterativeLinearSolverEvent.serialVersionUID", 122, 4651, 4757);
            return b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4610.methodEnd();
        }
    }

    @Override
    public RealVector getSolution() {
        MethodContext _bcornu_methode_context4611 = new MethodContext(RealVector.class, 128, 4764, 4859);
        try {
            CallChecker.varInit(this, "this", 128, 4764, 4859);
            CallChecker.varInit(this.x, "x", 128, 4764, 4859);
            CallChecker.varInit(this.rnorm, "rnorm", 128, 4764, 4859);
            CallChecker.varInit(this.r, "r", 128, 4764, 4859);
            CallChecker.varInit(this.b, "b", 128, 4764, 4859);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DefaultIterativeLinearSolverEvent.serialVersionUID", 128, 4764, 4859);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4611.methodEnd();
        }
    }

    @Override
    public boolean providesResidual() {
        MethodContext _bcornu_methode_context4612 = new MethodContext(boolean.class, 141, 4866, 5199);
        try {
            CallChecker.varInit(this, "this", 141, 4866, 5199);
            CallChecker.varInit(this.x, "x", 141, 4866, 5199);
            CallChecker.varInit(this.rnorm, "rnorm", 141, 4866, 5199);
            CallChecker.varInit(this.r, "r", 141, 4866, 5199);
            CallChecker.varInit(this.b, "b", 141, 4866, 5199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DefaultIterativeLinearSolverEvent.serialVersionUID", 141, 4866, 5199);
            return (r) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4612.methodEnd();
        }
    }
}

