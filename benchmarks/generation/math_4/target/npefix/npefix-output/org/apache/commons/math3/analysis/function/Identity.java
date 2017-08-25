package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Identity implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context5726 = new MethodContext(double.class, 32, 1272, 1351);
        try {
            CallChecker.varInit(this, "this", 32, 1272, 1351);
            CallChecker.varInit(x, "x", 32, 1272, 1351);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5726.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5727 = new MethodContext(DifferentiableUnivariateFunction.class, 40, 1358, 1573);
        try {
            CallChecker.varInit(this, "this", 40, 1358, 1573);
            return new Constant(1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5727.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5728 = new MethodContext(DerivativeStructure.class, 47, 1580, 1714);
        try {
            CallChecker.varInit(this, "this", 47, 1580, 1714);
            CallChecker.varInit(t, "t", 47, 1580, 1714);
            return t;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5728.methodEnd();
        }
    }
}

