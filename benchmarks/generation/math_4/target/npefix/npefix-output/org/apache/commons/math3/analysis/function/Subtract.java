package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.BivariateFunction;

public class Subtract implements BivariateFunction {
    public double value(double x, double y) {
        MethodContext _bcornu_methode_context4155 = new MethodContext(double.class, 30, 1064, 1157);
        try {
            CallChecker.varInit(this, "this", 30, 1064, 1157);
            CallChecker.varInit(y, "y", 30, 1064, 1157);
            CallChecker.varInit(x, "x", 30, 1064, 1157);
            return x - y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4155.methodEnd();
        }
    }
}

