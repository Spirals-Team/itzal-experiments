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

public class Acos implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3695 = new MethodContext(double.class, 35, 1434, 1528);
        try {
            CallChecker.varInit(this, "this", 35, 1434, 1528);
            CallChecker.varInit(x, "x", 35, 1434, 1528);
            return FastMath.acos(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3695.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3696 = new MethodContext(UnivariateFunction.class, 43, 1535, 1788);
        try {
            CallChecker.varInit(this, "this", 43, 1535, 1788);
            final DifferentiableUnivariateFunction npe_invocation_var822 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var822, DifferentiableUnivariateFunction.class, 44, 1715, 1768)) {
                return CallChecker.isCalled(npe_invocation_var822, DifferentiableUnivariateFunction.class, 44, 1715, 1768).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3696.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context3697 = new MethodContext(DerivativeStructure.class, 50, 1795, 1936);
        try {
            CallChecker.varInit(this, "this", 50, 1795, 1936);
            CallChecker.varInit(t, "t", 50, 1795, 1936);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1922, 1922)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1922, 1922).acos();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3697.methodEnd();
        }
    }
}

