package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

@Deprecated
public class UnivariatePointValuePair implements Serializable {
    private static final long serialVersionUID = 1003888396256744753L;

    private final double point;

    private final double value;

    public UnivariatePointValuePair(final double point, final double value) {
        ConstructorContext _bcornu_methode_context767 = new ConstructorContext(UnivariatePointValuePair.class, 46, 1445, 1781);
        try {
            this.point = point;
            CallChecker.varAssign(this.point, "this.point", 48, 1729, 1747);
            this.value = value;
            CallChecker.varAssign(this.value, "this.value", 49, 1757, 1775);
        } finally {
            _bcornu_methode_context767.methodEnd();
        }
    }

    public double getPoint() {
        MethodContext _bcornu_methode_context3444 = new MethodContext(double.class, 57, 1788, 1912);
        try {
            CallChecker.varInit(this, "this", 57, 1788, 1912);
            CallChecker.varInit(this.value, "value", 57, 1788, 1912);
            CallChecker.varInit(this.point, "point", 57, 1788, 1912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.univariate.UnivariatePointValuePair.serialVersionUID", 57, 1788, 1912);
            return point;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3444.methodEnd();
        }
    }

    public double getValue() {
        MethodContext _bcornu_methode_context3445 = new MethodContext(double.class, 66, 1919, 2102);
        try {
            CallChecker.varInit(this, "this", 66, 1919, 2102);
            CallChecker.varInit(this.value, "value", 66, 1919, 2102);
            CallChecker.varInit(this.point, "point", 66, 1919, 2102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.univariate.UnivariatePointValuePair.serialVersionUID", 66, 1919, 2102);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3445.methodEnd();
        }
    }
}

