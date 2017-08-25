package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

public class Sin implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3573 = new MethodContext(double.class, 33, 1310, 1403);
        try {
            CallChecker.varInit(this, "this", 33, 1310, 1403);
            CallChecker.varInit(x, "x", 33, 1310, 1403);
            return FastMath.sin(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3573.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3574 = new MethodContext(DifferentiableUnivariateFunction.class, 41, 1410, 1619);
        try {
            CallChecker.varInit(this, "this", 41, 1410, 1619);
            return new Cos();
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3574.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context3575 = new MethodContext(DerivativeStructure.class, 48, 1626, 1766);
        try {
            CallChecker.varInit(this, "this", 48, 1626, 1766);
            CallChecker.varInit(t, "t", 48, 1626, 1766);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 49, 1753, 1753)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 49, 1753, 1753).sin();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3575.methodEnd();
        }
    }
}

