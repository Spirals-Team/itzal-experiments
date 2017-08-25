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

public class Asinh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context5255 = new MethodContext(double.class, 35, 1444, 1539);
        try {
            CallChecker.varInit(this, "this", 35, 1444, 1539);
            CallChecker.varInit(x, "x", 35, 1444, 1539);
            return FastMath.asinh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5255.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5256 = new MethodContext(UnivariateFunction.class, 43, 1546, 1799);
        try {
            CallChecker.varInit(this, "this", 43, 1546, 1799);
            final DifferentiableUnivariateFunction npe_invocation_var999 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var999, DifferentiableUnivariateFunction.class, 44, 1726, 1779)) {
                return CallChecker.isCalled(npe_invocation_var999, DifferentiableUnivariateFunction.class, 44, 1726, 1779).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5256.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5257 = new MethodContext(DerivativeStructure.class, 50, 1806, 1948);
        try {
            CallChecker.varInit(this, "this", 50, 1806, 1948);
            CallChecker.varInit(t, "t", 50, 1806, 1948);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1933, 1933)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1933, 1933).asinh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5257.methodEnd();
        }
    }
}

