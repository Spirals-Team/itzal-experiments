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

public class Expm1 implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context891 = new MethodContext(double.class, 35, 1453, 1548);
        try {
            CallChecker.varInit(this, "this", 35, 1453, 1548);
            CallChecker.varInit(x, "x", 35, 1453, 1548);
            return FastMath.expm1(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context891.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context892 = new MethodContext(UnivariateFunction.class, 43, 1555, 1808);
        try {
            CallChecker.varInit(this, "this", 43, 1555, 1808);
            final DifferentiableUnivariateFunction npe_invocation_var96 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var96, DifferentiableUnivariateFunction.class, 44, 1735, 1788)) {
                return CallChecker.isCalled(npe_invocation_var96, DifferentiableUnivariateFunction.class, 44, 1735, 1788).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context892.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context893 = new MethodContext(DerivativeStructure.class, 50, 1815, 1957);
        try {
            CallChecker.varInit(this, "this", 50, 1815, 1957);
            CallChecker.varInit(t, "t", 50, 1815, 1957);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 51, 1942, 1942)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 51, 1942, 1942).expm1();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context893.methodEnd();
        }
    }
}

