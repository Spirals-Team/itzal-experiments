package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

public class Cosh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context5500 = new MethodContext(double.class, 33, 1324, 1418);
        try {
            CallChecker.varInit(this, "this", 33, 1324, 1418);
            CallChecker.varInit(x, "x", 33, 1324, 1418);
            return FastMath.cosh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5500.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5501 = new MethodContext(DifferentiableUnivariateFunction.class, 41, 1425, 1635);
        try {
            CallChecker.varInit(this, "this", 41, 1425, 1635);
            return new Sinh();
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5501.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5502 = new MethodContext(DerivativeStructure.class, 48, 1642, 1783);
        try {
            CallChecker.varInit(this, "this", 48, 1642, 1783);
            CallChecker.varInit(t, "t", 48, 1642, 1783);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 49, 1769, 1769)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 49, 1769, 1769).cosh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5502.methodEnd();
        }
    }
}

