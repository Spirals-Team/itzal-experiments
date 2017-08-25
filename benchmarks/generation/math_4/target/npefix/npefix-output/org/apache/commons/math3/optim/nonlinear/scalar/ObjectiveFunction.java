package org.apache.commons.math3.optim.nonlinear.scalar;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.OptimizationData;

public class ObjectiveFunction implements OptimizationData {
    private final MultivariateFunction function;

    public ObjectiveFunction(MultivariateFunction f) {
        ConstructorContext _bcornu_methode_context265 = new ConstructorContext(ObjectiveFunction.class, 35, 1211, 1346);
        try {
            function = f;
            CallChecker.varAssign(this.function, "this.function", 36, 1328, 1340);
        } finally {
            _bcornu_methode_context265.methodEnd();
        }
    }

    public MultivariateFunction getObjectiveFunction() {
        MethodContext _bcornu_methode_context1165 = new MethodContext(MultivariateFunction.class, 44, 1353, 1539);
        try {
            CallChecker.varInit(this, "this", 44, 1353, 1539);
            CallChecker.varInit(this.function, "function", 44, 1353, 1539);
            return function;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1165.methodEnd();
        }
    }
}

