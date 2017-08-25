package org.apache.commons.math3.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

public class WeightedObservedPoint implements Serializable {
    private static final long serialVersionUID = 5306874947404636157L;

    private final double weight;

    private final double x;

    private final double y;

    public WeightedObservedPoint(final double weight, final double x, final double y) {
        ConstructorContext _bcornu_methode_context128 = new ConstructorContext(WeightedObservedPoint.class, 45, 1552, 1931);
        try {
            this.weight = weight;
            CallChecker.varAssign(this.weight, "this.weight", 46, 1855, 1875);
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 47, 1885, 1900);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 48, 1910, 1925);
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public double getWeight() {
        MethodContext _bcornu_methode_context466 = new MethodContext(double.class, 56, 1938, 2151);
        try {
            CallChecker.varInit(this, "this", 56, 1938, 2151);
            CallChecker.varInit(this.y, "y", 56, 1938, 2151);
            CallChecker.varInit(this.x, "x", 56, 1938, 2151);
            CallChecker.varInit(this.weight, "weight", 56, 1938, 2151);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fitting.WeightedObservedPoint.serialVersionUID", 56, 1938, 2151);
            return weight;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context466.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context467 = new MethodContext(double.class, 65, 2158, 2307);
        try {
            CallChecker.varInit(this, "this", 65, 2158, 2307);
            CallChecker.varInit(this.y, "y", 65, 2158, 2307);
            CallChecker.varInit(this.x, "x", 65, 2158, 2307);
            CallChecker.varInit(this.weight, "weight", 65, 2158, 2307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fitting.WeightedObservedPoint.serialVersionUID", 65, 2158, 2307);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context467.methodEnd();
        }
    }

    public double getY() {
        MethodContext _bcornu_methode_context468 = new MethodContext(double.class, 74, 2314, 2491);
        try {
            CallChecker.varInit(this, "this", 74, 2314, 2491);
            CallChecker.varInit(this.y, "y", 74, 2314, 2491);
            CallChecker.varInit(this.x, "x", 74, 2314, 2491);
            CallChecker.varInit(this.weight, "weight", 74, 2314, 2491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fitting.WeightedObservedPoint.serialVersionUID", 74, 2314, 2491);
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context468.methodEnd();
        }
    }
}

