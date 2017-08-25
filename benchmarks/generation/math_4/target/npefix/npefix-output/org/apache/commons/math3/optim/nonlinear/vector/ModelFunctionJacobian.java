package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.optim.OptimizationData;

public class ModelFunctionJacobian implements OptimizationData {
    private final MultivariateMatrixFunction jacobian;

    public ModelFunctionJacobian(MultivariateMatrixFunction j) {
        ConstructorContext _bcornu_methode_context455 = new ConstructorContext(ModelFunctionJacobian.class, 35, 1251, 1418);
        try {
            jacobian = j;
            CallChecker.varAssign(this.jacobian, "this.jacobian", 36, 1400, 1412);
        } finally {
            _bcornu_methode_context455.methodEnd();
        }
    }

    public MultivariateMatrixFunction getModelFunctionJacobian() {
        MethodContext _bcornu_methode_context1939 = new MethodContext(MultivariateMatrixFunction.class, 44, 1425, 1648);
        try {
            CallChecker.varInit(this, "this", 44, 1425, 1648);
            CallChecker.varInit(this.jacobian, "jacobian", 44, 1425, 1648);
            return jacobian;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateMatrixFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1939.methodEnd();
        }
    }
}

