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

public class Log10 implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context832 = new MethodContext(double.class, 36, 1443, 1538);
        try {
            CallChecker.varInit(this, "this", 36, 1443, 1538);
            CallChecker.varInit(x, "x", 36, 1443, 1538);
            return FastMath.log10(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context832.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context833 = new MethodContext(UnivariateFunction.class, 44, 1545, 1798);
        try {
            CallChecker.varInit(this, "this", 44, 1545, 1798);
            final DifferentiableUnivariateFunction npe_invocation_var94 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var94, DifferentiableUnivariateFunction.class, 45, 1725, 1778)) {
                return CallChecker.isCalled(npe_invocation_var94, DifferentiableUnivariateFunction.class, 45, 1725, 1778).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context833.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context834 = new MethodContext(DerivativeStructure.class, 51, 1805, 1947);
        try {
            CallChecker.varInit(this, "this", 51, 1805, 1947);
            CallChecker.varInit(t, "t", 51, 1805, 1947);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 52, 1932, 1932)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 52, 1932, 1932).log10();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context834.methodEnd();
        }
    }
}

