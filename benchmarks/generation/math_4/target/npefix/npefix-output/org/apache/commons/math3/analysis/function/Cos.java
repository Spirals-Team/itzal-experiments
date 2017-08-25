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

public class Cos implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context5733 = new MethodContext(double.class, 35, 1429, 1522);
        try {
            CallChecker.varInit(this, "this", 35, 1429, 1522);
            CallChecker.varInit(x, "x", 35, 1429, 1522);
            return FastMath.cos(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5733.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5734 = new MethodContext(UnivariateFunction.class, 43, 1529, 1782);
        try {
            CallChecker.varInit(this, "this", 43, 1529, 1782);
            final DifferentiableUnivariateFunction npe_invocation_var1028 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var1028, DifferentiableUnivariateFunction.class, 44, 1709, 1762)) {
                return CallChecker.isCalled(npe_invocation_var1028, DifferentiableUnivariateFunction.class, 44, 1709, 1762).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5734.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5735 = new MethodContext(DerivativeStructure.class, 50, 1789, 1929);
        try {
            CallChecker.varInit(this, "this", 50, 1789, 1929);
            CallChecker.varInit(t, "t", 50, 1789, 1929);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1916, 1916)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1916, 1916).cos();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5735.methodEnd();
        }
    }
}

