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

public class Tan implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context1828 = new MethodContext(double.class, 35, 1430, 1523);
        try {
            CallChecker.varInit(this, "this", 35, 1430, 1523);
            CallChecker.varInit(x, "x", 35, 1430, 1523);
            return FastMath.tan(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1828.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context1829 = new MethodContext(UnivariateFunction.class, 43, 1530, 1783);
        try {
            CallChecker.varInit(this, "this", 43, 1530, 1783);
            final DifferentiableUnivariateFunction npe_invocation_var179 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var179, DifferentiableUnivariateFunction.class, 44, 1710, 1763)) {
                return CallChecker.isCalled(npe_invocation_var179, DifferentiableUnivariateFunction.class, 44, 1710, 1763).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1829.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context1830 = new MethodContext(DerivativeStructure.class, 50, 1790, 1930);
        try {
            CallChecker.varInit(this, "this", 50, 1790, 1930);
            CallChecker.varInit(t, "t", 50, 1790, 1930);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1917, 1917)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1917, 1917).tan();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1830.methodEnd();
        }
    }
}

