package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optim.OptimizationData;

public class UnivariateObjectiveFunction implements OptimizationData {
    private final UnivariateFunction function;

    public UnivariateObjectiveFunction(UnivariateFunction f) {
        ConstructorContext _bcornu_methode_context941 = new ConstructorContext(UnivariateObjectiveFunction.class, 35, 1211, 1354);
        try {
            function = f;
            CallChecker.varAssign(this.function, "this.function", 36, 1336, 1348);
        } finally {
            _bcornu_methode_context941.methodEnd();
        }
    }

    public UnivariateFunction getObjectiveFunction() {
        MethodContext _bcornu_methode_context4251 = new MethodContext(UnivariateFunction.class, 44, 1361, 1545);
        try {
            CallChecker.varInit(this, "this", 44, 1361, 1545);
            CallChecker.varInit(this.function, "function", 44, 1361, 1545);
            return function;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4251.methodEnd();
        }
    }
}

