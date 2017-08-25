package org.apache.commons.math3.optim;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class InitialGuess implements OptimizationData {
    private final double[] init;

    public InitialGuess(double[] startPoint) {
        ConstructorContext _bcornu_methode_context628 = new ConstructorContext(InitialGuess.class, 35, 1099, 1237);
        try {
            startPoint = CallChecker.beforeCalled(startPoint, double[].class, 36, 1213, 1222);
            init = CallChecker.isCalled(startPoint, double[].class, 36, 1213, 1222).clone();
            CallChecker.varAssign(this.init, "this.init", 36, 1206, 1231);
        } finally {
            _bcornu_methode_context628.methodEnd();
        }
    }

    public double[] getInitialGuess() {
        MethodContext _bcornu_methode_context2797 = new MethodContext(double[].class, 44, 1244, 1401);
        try {
            CallChecker.varInit(this, "this", 44, 1244, 1401);
            CallChecker.varInit(this.init, "init", 44, 1244, 1401);
            if (CallChecker.beforeDeref(init, double[].class, 45, 1383, 1386)) {
                return CallChecker.isCalled(init, double[].class, 45, 1383, 1386).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2797.methodEnd();
        }
    }
}

