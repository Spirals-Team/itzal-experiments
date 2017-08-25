package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.optim.OptimizationData;

public class Target implements OptimizationData {
    private final double[] target;

    public Target(double[] observations) {
        ConstructorContext _bcornu_methode_context1093 = new ConstructorContext(Target.class, 38, 1312, 1452);
        try {
            observations = CallChecker.beforeCalled(observations, double[].class, 39, 1426, 1437);
            target = CallChecker.isCalled(observations, double[].class, 39, 1426, 1437).clone();
            CallChecker.varAssign(this.target, "this.target", 39, 1417, 1446);
        } finally {
            _bcornu_methode_context1093.methodEnd();
        }
    }

    public double[] getTarget() {
        MethodContext _bcornu_methode_context4883 = new MethodContext(double[].class, 47, 1459, 1612);
        try {
            CallChecker.varInit(this, "this", 47, 1459, 1612);
            CallChecker.varInit(this.target, "target", 47, 1459, 1612);
            if (CallChecker.beforeDeref(target, double[].class, 48, 1592, 1597)) {
                return CallChecker.isCalled(target, double[].class, 48, 1592, 1597).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4883.methodEnd();
        }
    }
}

