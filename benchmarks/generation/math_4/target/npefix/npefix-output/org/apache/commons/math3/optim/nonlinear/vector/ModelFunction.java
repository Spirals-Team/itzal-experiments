package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.OptimizationData;

public class ModelFunction implements OptimizationData {
    private final MultivariateVectorFunction model;

    public ModelFunction(MultivariateVectorFunction m) {
        ConstructorContext _bcornu_methode_context305 = new ConstructorContext(ModelFunction.class, 35, 1224, 1364);
        try {
            model = m;
            CallChecker.varAssign(this.model, "this.model", 36, 1349, 1358);
        } finally {
            _bcornu_methode_context305.methodEnd();
        }
    }

    public MultivariateVectorFunction getModelFunction() {
        MethodContext _bcornu_methode_context1361 = new MethodContext(MultivariateVectorFunction.class, 44, 1371, 1558);
        try {
            CallChecker.varInit(this, "this", 44, 1371, 1558);
            CallChecker.varInit(this.model, "model", 44, 1371, 1558);
            return model;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateVectorFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1361.methodEnd();
        }
    }
}

