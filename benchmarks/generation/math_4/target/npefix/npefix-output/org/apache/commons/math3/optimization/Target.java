package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

@Deprecated
public class Target implements OptimizationData {
    private final double[] target;

    public Target(double[] observations) {
        ConstructorContext _bcornu_methode_context1092 = new ConstructorContext(Target.class, 39, 1307, 1447);
        try {
            observations = CallChecker.beforeCalled(observations, double[].class, 40, 1421, 1432);
            target = CallChecker.isCalled(observations, double[].class, 40, 1421, 1432).clone();
            CallChecker.varAssign(this.target, "this.target", 40, 1412, 1441);
        } finally {
            _bcornu_methode_context1092.methodEnd();
        }
    }

    public double[] getTarget() {
        MethodContext _bcornu_methode_context4882 = new MethodContext(double[].class, 48, 1454, 1607);
        try {
            CallChecker.varInit(this, "this", 48, 1454, 1607);
            CallChecker.varInit(this.target, "target", 48, 1454, 1607);
            if (CallChecker.beforeDeref(target, double[].class, 49, 1587, 1592)) {
                return CallChecker.isCalled(target, double[].class, 49, 1587, 1592).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4882.methodEnd();
        }
    }
}

