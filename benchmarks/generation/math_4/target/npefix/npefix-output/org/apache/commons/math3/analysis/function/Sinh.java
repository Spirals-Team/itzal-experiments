package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

public class Sinh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context4963 = new MethodContext(double.class, 33, 1322, 1416);
        try {
            CallChecker.varInit(this, "this", 33, 1322, 1416);
            CallChecker.varInit(x, "x", 33, 1322, 1416);
            return FastMath.sinh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4963.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4964 = new MethodContext(DifferentiableUnivariateFunction.class, 41, 1423, 1633);
        try {
            CallChecker.varInit(this, "this", 41, 1423, 1633);
            return new Cosh();
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4964.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4965 = new MethodContext(DerivativeStructure.class, 48, 1640, 1781);
        try {
            CallChecker.varInit(this, "this", 48, 1640, 1781);
            CallChecker.varInit(t, "t", 48, 1640, 1781);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 49, 1767, 1767)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 49, 1767, 1767).sinh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4965.methodEnd();
        }
    }
}

