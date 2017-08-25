package org.apache.commons.math3.optim.nonlinear.scalar;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.OptimizationData;

public class ObjectiveFunctionGradient implements OptimizationData {
    private final MultivariateVectorFunction gradient;

    public ObjectiveFunctionGradient(MultivariateVectorFunction g) {
        ConstructorContext _bcornu_methode_context1208 = new ConstructorContext(ObjectiveFunctionGradient.class, 35, 1247, 1412);
        try {
            gradient = g;
            CallChecker.varAssign(this.gradient, "this.gradient", 36, 1394, 1406);
        } finally {
            _bcornu_methode_context1208.methodEnd();
        }
    }

    public MultivariateVectorFunction getObjectiveFunctionGradient() {
        MethodContext _bcornu_methode_context5477 = new MethodContext(MultivariateVectorFunction.class, 44, 1419, 1644);
        try {
            CallChecker.varInit(this, "this", 44, 1419, 1644);
            CallChecker.varInit(this.gradient, "gradient", 44, 1419, 1644);
            return gradient;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateVectorFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5477.methodEnd();
        }
    }
}

