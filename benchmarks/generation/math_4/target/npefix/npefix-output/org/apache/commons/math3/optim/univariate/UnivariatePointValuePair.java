package org.apache.commons.math3.optim.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

public class UnivariatePointValuePair implements Serializable {
    private static final long serialVersionUID = 1003888396256744753L;

    private final double point;

    private final double value;

    public UnivariatePointValuePair(final double point, final double value) {
        ConstructorContext _bcornu_methode_context768 = new ConstructorContext(UnivariatePointValuePair.class, 44, 1377, 1713);
        try {
            this.point = point;
            CallChecker.varAssign(this.point, "this.point", 46, 1661, 1679);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 47, 1689, 1707);
        } finally {
            _bcornu_methode_context768.methodEnd();
        }
    }

    public double getPoint() {
        MethodContext _bcornu_methode_context3446 = new MethodContext(double.class, 55, 1720, 1844);
        try {
            CallChecker.varInit(this, "this", 55, 1720, 1844);
            CallChecker.varInit(this.value, "value", 55, 1720, 1844);
            CallChecker.varInit(this.point, "point", 55, 1720, 1844);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.univariate.UnivariatePointValuePair.serialVersionUID", 55, 1720, 1844);
            return point;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3446.methodEnd();
        }
    }

    public double getValue() {
        MethodContext _bcornu_methode_context3447 = new MethodContext(double.class, 64, 1851, 2034);
        try {
            CallChecker.varInit(this, "this", 64, 1851, 2034);
            CallChecker.varInit(this.value, "value", 64, 1851, 2034);
            CallChecker.varInit(this.point, "point", 64, 1851, 2034);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.univariate.UnivariatePointValuePair.serialVersionUID", 64, 1851, 2034);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3447.methodEnd();
        }
    }
}

