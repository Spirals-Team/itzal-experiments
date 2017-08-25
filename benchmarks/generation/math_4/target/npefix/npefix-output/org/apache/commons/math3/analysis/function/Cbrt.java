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

public class Cbrt implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3359 = new MethodContext(double.class, 35, 1433, 1527);
        try {
            CallChecker.varInit(this, "this", 35, 1433, 1527);
            CallChecker.varInit(x, "x", 35, 1433, 1527);
            return FastMath.cbrt(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3359.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3360 = new MethodContext(UnivariateFunction.class, 43, 1534, 1787);
        try {
            CallChecker.varInit(this, "this", 43, 1534, 1787);
            final DifferentiableUnivariateFunction npe_invocation_var801 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var801, DifferentiableUnivariateFunction.class, 44, 1714, 1767)) {
                return CallChecker.isCalled(npe_invocation_var801, DifferentiableUnivariateFunction.class, 44, 1714, 1767).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3360.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context3361 = new MethodContext(DerivativeStructure.class, 50, 1794, 1935);
        try {
            CallChecker.varInit(this, "this", 50, 1794, 1935);
            CallChecker.varInit(t, "t", 50, 1794, 1935);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1921, 1921)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1921, 1921).cbrt();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3361.methodEnd();
        }
    }
}

