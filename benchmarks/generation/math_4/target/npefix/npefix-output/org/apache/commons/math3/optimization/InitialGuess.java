package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

@Deprecated
public class InitialGuess implements OptimizationData {
    private final double[] init;

    public InitialGuess(double[] startPoint) {
        ConstructorContext _bcornu_methode_context627 = new ConstructorContext(InitialGuess.class, 37, 1167, 1305);
        try {
            startPoint = CallChecker.beforeCalled(startPoint, double[].class, 38, 1281, 1290);
            init = CallChecker.isCalled(startPoint, double[].class, 38, 1281, 1290).clone();
            CallChecker.varAssign(this.init, "this.init", 38, 1274, 1299);
        } finally {
            _bcornu_methode_context627.methodEnd();
        }
    }

    public double[] getInitialGuess() {
        MethodContext _bcornu_methode_context2796 = new MethodContext(double[].class, 46, 1312, 1469);
        try {
            CallChecker.varInit(this, "this", 46, 1312, 1469);
            CallChecker.varInit(this.init, "init", 46, 1312, 1469);
            if (CallChecker.beforeDeref(init, double[].class, 47, 1451, 1454)) {
                return CallChecker.isCalled(init, double[].class, 47, 1451, 1454).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2796.methodEnd();
        }
    }
}

