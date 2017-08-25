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

public class Tanh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3701 = new MethodContext(double.class, 35, 1442, 1536);
        try {
            CallChecker.varInit(this, "this", 35, 1442, 1536);
            CallChecker.varInit(x, "x", 35, 1442, 1536);
            return FastMath.tanh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3701.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3702 = new MethodContext(UnivariateFunction.class, 43, 1543, 1796);
        try {
            CallChecker.varInit(this, "this", 43, 1543, 1796);
            final DifferentiableUnivariateFunction npe_invocation_var823 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var823, DifferentiableUnivariateFunction.class, 44, 1723, 1776)) {
                return CallChecker.isCalled(npe_invocation_var823, DifferentiableUnivariateFunction.class, 44, 1723, 1776).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3702.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context3703 = new MethodContext(DerivativeStructure.class, 50, 1803, 1944);
        try {
            CallChecker.varInit(this, "this", 50, 1803, 1944);
            CallChecker.varInit(t, "t", 50, 1803, 1944);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1930, 1930)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1930, 1930).tanh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3703.methodEnd();
        }
    }
}

