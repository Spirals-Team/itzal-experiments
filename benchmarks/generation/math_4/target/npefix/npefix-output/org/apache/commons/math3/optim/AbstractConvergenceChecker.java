package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public abstract class AbstractConvergenceChecker<PAIR> implements ConvergenceChecker<PAIR> {
    private final double relativeThreshold;

    private final double absoluteThreshold;

    public AbstractConvergenceChecker(final double relativeThreshold, final double absoluteThreshold) {
        ConstructorContext _bcornu_methode_context923 = new ConstructorContext(AbstractConvergenceChecker.class, 44, 1290, 1735);
        try {
            this.relativeThreshold = relativeThreshold;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 46, 1635, 1677);
            this.absoluteThreshold = absoluteThreshold;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 47, 1687, 1729);
        } finally {
            _bcornu_methode_context923.methodEnd();
        }
    }

    public double getRelativeThreshold() {
        MethodContext _bcornu_methode_context4211 = new MethodContext(double.class, 53, 1742, 1874);
        try {
            CallChecker.varInit(this, "this", 53, 1742, 1874);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 53, 1742, 1874);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 53, 1742, 1874);
            return relativeThreshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4211.methodEnd();
        }
    }

    public double getAbsoluteThreshold() {
        MethodContext _bcornu_methode_context4212 = new MethodContext(double.class, 60, 1881, 2013);
        try {
            CallChecker.varInit(this, "this", 60, 1881, 2013);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 60, 1881, 2013);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 60, 1881, 2013);
            return absoluteThreshold;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4212.methodEnd();
        }
    }

    public abstract boolean converged(int iteration, PAIR previous, PAIR current);
}

