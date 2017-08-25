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

public class Atanh implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context1468 = new MethodContext(double.class, 35, 1447, 1542);
        try {
            CallChecker.varInit(this, "this", 35, 1447, 1542);
            CallChecker.varInit(x, "x", 35, 1447, 1542);
            return FastMath.atanh(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1468.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context1469 = new MethodContext(UnivariateFunction.class, 43, 1549, 1802);
        try {
            CallChecker.varInit(this, "this", 43, 1549, 1802);
            final DifferentiableUnivariateFunction npe_invocation_var135 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var135, DifferentiableUnivariateFunction.class, 44, 1729, 1782)) {
                return CallChecker.isCalled(npe_invocation_var135, DifferentiableUnivariateFunction.class, 44, 1729, 1782).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1469.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context1470 = new MethodContext(DerivativeStructure.class, 50, 1809, 1951);
        try {
            CallChecker.varInit(this, "this", 50, 1809, 1951);
            CallChecker.varInit(t, "t", 50, 1809, 1951);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1936, 1936)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1936, 1936).atanh();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1470.methodEnd();
        }
    }
}

