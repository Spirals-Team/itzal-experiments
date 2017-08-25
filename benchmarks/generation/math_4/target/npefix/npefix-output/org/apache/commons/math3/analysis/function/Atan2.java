package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.util.FastMath;

public class Atan2 implements BivariateFunction {
    public double value(double x, double y) {
        MethodContext _bcornu_methode_context2572 = new MethodContext(double.class, 31, 1086, 1194);
        try {
            CallChecker.varInit(this, "this", 31, 1086, 1194);
            CallChecker.varInit(y, "y", 31, 1086, 1194);
            CallChecker.varInit(x, "x", 31, 1086, 1194);
            return FastMath.atan2(x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2572.methodEnd();
        }
    }
}

