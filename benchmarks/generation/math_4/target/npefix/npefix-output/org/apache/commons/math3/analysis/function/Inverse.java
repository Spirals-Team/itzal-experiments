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

public class Inverse implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3322 = new MethodContext(double.class, 34, 1387, 1470);
        try {
            CallChecker.varInit(this, "this", 34, 1387, 1470);
            CallChecker.varInit(x, "x", 34, 1387, 1470);
            return 1 / x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3322.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3323 = new MethodContext(UnivariateFunction.class, 42, 1477, 1730);
        try {
            CallChecker.varInit(this, "this", 42, 1477, 1730);
            final DifferentiableUnivariateFunction npe_invocation_var797 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var797, DifferentiableUnivariateFunction.class, 43, 1657, 1710)) {
                return CallChecker.isCalled(npe_invocation_var797, DifferentiableUnivariateFunction.class, 43, 1657, 1710).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3323.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context3324 = new MethodContext(DerivativeStructure.class, 49, 1737, 1884);
        try {
            CallChecker.varInit(this, "this", 49, 1737, 1884);
            CallChecker.varInit(t, "t", 49, 1737, 1884);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 50, 1864, 1864)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 50, 1864, 1864).reciprocal();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3324.methodEnd();
        }
    }
}

