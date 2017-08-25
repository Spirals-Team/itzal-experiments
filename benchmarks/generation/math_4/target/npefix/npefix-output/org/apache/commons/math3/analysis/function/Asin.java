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

public class Asin implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context4581 = new MethodContext(double.class, 35, 1432, 1526);
        try {
            CallChecker.varInit(this, "this", 35, 1432, 1526);
            CallChecker.varInit(x, "x", 35, 1432, 1526);
            return FastMath.asin(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4581.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4582 = new MethodContext(UnivariateFunction.class, 43, 1533, 1786);
        try {
            CallChecker.varInit(this, "this", 43, 1533, 1786);
            final DifferentiableUnivariateFunction npe_invocation_var936 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var936, DifferentiableUnivariateFunction.class, 44, 1713, 1766)) {
                return CallChecker.isCalled(npe_invocation_var936, DifferentiableUnivariateFunction.class, 44, 1713, 1766).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4582.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4583 = new MethodContext(DerivativeStructure.class, 50, 1793, 1934);
        try {
            CallChecker.varInit(this, "this", 50, 1793, 1934);
            CallChecker.varInit(t, "t", 50, 1793, 1934);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1920, 1920)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1920, 1920).asin();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4583.methodEnd();
        }
    }
}

