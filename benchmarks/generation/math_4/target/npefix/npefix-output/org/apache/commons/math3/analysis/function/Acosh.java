package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

public class Acosh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context4694 = new MethodContext(double.class, 35, 1446, 1541);
        try {
            CallChecker.varInit(this, "this", 35, 1446, 1541);
            CallChecker.varInit(x, "x", 35, 1446, 1541);
            return FastMath.acosh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4694.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4695 = new MethodContext(UnivariateFunction.class, 43, 1548, 1801);
        try {
            CallChecker.varInit(this, "this", 43, 1548, 1801);
            final DifferentiableUnivariateFunction npe_invocation_var950 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var950, DifferentiableUnivariateFunction.class, 44, 1728, 1781)) {
                return CallChecker.isCalled(npe_invocation_var950, DifferentiableUnivariateFunction.class, 44, 1728, 1781).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4695.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4696 = new MethodContext(DerivativeStructure.class, 50, 1808, 1950);
        try {
            CallChecker.varInit(this, "this", 50, 1808, 1950);
            CallChecker.varInit(t, "t", 50, 1808, 1950);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1935, 1935)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1935, 1935).acosh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4696.methodEnd();
        }
    }
}

