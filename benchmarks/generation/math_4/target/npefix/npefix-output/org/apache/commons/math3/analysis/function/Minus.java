package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Minus implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context1831 = new MethodContext(double.class, 32, 1266, 1346);
        try {
            CallChecker.varInit(this, "this", 32, 1266, 1346);
            CallChecker.varInit(x, "x", 32, 1266, 1346);
            return -x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1831.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context1832 = new MethodContext(DifferentiableUnivariateFunction.class, 40, 1353, 1569);
        try {
            CallChecker.varInit(this, "this", 40, 1353, 1569);
            return new Constant((-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1832.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context1833 = new MethodContext(DerivativeStructure.class, 47, 1576, 1719);
        try {
            CallChecker.varInit(this, "this", 47, 1576, 1719);
            CallChecker.varInit(t, "t", 47, 1576, 1719);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 48, 1703, 1703)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 48, 1703, 1703).negate();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1833.methodEnd();
        }
    }
}

