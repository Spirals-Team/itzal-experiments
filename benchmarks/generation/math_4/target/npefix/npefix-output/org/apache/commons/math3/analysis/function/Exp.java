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

public class Exp implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context4214 = new MethodContext(double.class, 35, 1434, 1527);
        try {
            CallChecker.varInit(this, "this", 35, 1434, 1527);
            CallChecker.varInit(x, "x", 35, 1434, 1527);
            return FastMath.exp(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4214.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4215 = new MethodContext(UnivariateFunction.class, 43, 1534, 1787);
        try {
            CallChecker.varInit(this, "this", 43, 1534, 1787);
            final DifferentiableUnivariateFunction npe_invocation_var901 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var901, DifferentiableUnivariateFunction.class, 44, 1714, 1767)) {
                return CallChecker.isCalled(npe_invocation_var901, DifferentiableUnivariateFunction.class, 44, 1714, 1767).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4215.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4216 = new MethodContext(DerivativeStructure.class, 50, 1794, 1934);
        try {
            CallChecker.varInit(this, "this", 50, 1794, 1934);
            CallChecker.varInit(t, "t", 50, 1794, 1934);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1921, 1921)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1921, 1921).exp();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4216.methodEnd();
        }
    }
}

