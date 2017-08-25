package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.util.FastMath;

public class Floor implements UnivariateFunction {
    public double value(double x) {
        MethodContext _bcornu_methode_context3840 = new MethodContext(double.class, 31, 1090, 1185);
        try {
            CallChecker.varInit(this, "this", 31, 1090, 1185);
            CallChecker.varInit(x, "x", 31, 1090, 1185);
            return FastMath.floor(x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3840.methodEnd();
        }
    }
}

