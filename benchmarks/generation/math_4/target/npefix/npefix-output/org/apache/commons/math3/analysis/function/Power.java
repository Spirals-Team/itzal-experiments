package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

public class Power implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    private final double p;

    public Power(double p) {
        ConstructorContext _bcornu_methode_context1202 = new ConstructorContext(Power.class, 40, 1477, 1565);
        try {
            this.p = p;
            CallChecker.varAssign(this.p, "this.p", 41, 1549, 1559);
        } finally {
            _bcornu_methode_context1202.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context5394 = new MethodContext(double.class, 45, 1572, 1668);
        try {
            CallChecker.varInit(this, "this", 45, 1572, 1668);
            CallChecker.varInit(x, "x", 45, 1572, 1668);
            CallChecker.varInit(this.p, "p", 45, 1572, 1668);
            return FastMath.pow(x, p);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5394.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5395 = new MethodContext(UnivariateFunction.class, 53, 1675, 1928);
        try {
            CallChecker.varInit(this, "this", 53, 1675, 1928);
            CallChecker.varInit(this.p, "p", 53, 1675, 1928);
            final DifferentiableUnivariateFunction npe_invocation_var1003 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var1003, DifferentiableUnivariateFunction.class, 54, 1855, 1908)) {
                return CallChecker.isCalled(npe_invocation_var1003, DifferentiableUnivariateFunction.class, 54, 1855, 1908).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5395.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5396 = new MethodContext(DerivativeStructure.class, 60, 1935, 2076);
        try {
            CallChecker.varInit(this, "this", 60, 1935, 2076);
            CallChecker.varInit(t, "t", 60, 1935, 2076);
            CallChecker.varInit(this.p, "p", 60, 1935, 2076);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 61, 2062, 2062)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 61, 2062, 2062).pow(p);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5396.methodEnd();
        }
    }
}

