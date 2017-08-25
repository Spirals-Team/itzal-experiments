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

public class Sqrt implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context4234 = new MethodContext(double.class, 35, 1435, 1529);
        try {
            CallChecker.varInit(this, "this", 35, 1435, 1529);
            CallChecker.varInit(x, "x", 35, 1435, 1529);
            return FastMath.sqrt(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4234.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4235 = new MethodContext(UnivariateFunction.class, 43, 1536, 1789);
        try {
            CallChecker.varInit(this, "this", 43, 1536, 1789);
            final DifferentiableUnivariateFunction npe_invocation_var904 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var904, DifferentiableUnivariateFunction.class, 44, 1716, 1769)) {
                return CallChecker.isCalled(npe_invocation_var904, DifferentiableUnivariateFunction.class, 44, 1716, 1769).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4235.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4236 = new MethodContext(DerivativeStructure.class, 50, 1796, 1937);
        try {
            CallChecker.varInit(this, "this", 50, 1796, 1937);
            CallChecker.varInit(t, "t", 50, 1796, 1937);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1923, 1923)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1923, 1923).sqrt();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4236.methodEnd();
        }
    }
}

