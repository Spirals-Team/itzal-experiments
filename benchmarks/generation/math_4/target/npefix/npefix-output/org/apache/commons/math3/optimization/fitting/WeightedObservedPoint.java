package org.apache.commons.math3.optimization.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

@Deprecated
public class WeightedObservedPoint implements Serializable {
    private static final long serialVersionUID = 5306874947404636157L;

    private final double weight;

    private final double x;

    private final double y;

    public WeightedObservedPoint(final double weight, final double x, final double y) {
        ConstructorContext _bcornu_methode_context127 = new ConstructorContext(WeightedObservedPoint.class, 49, 1567, 1929);
        try {
            this.weight = weight;
            CallChecker.varAssign(this.weight, "this.weight", 50, 1853, 1873);
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 51, 1883, 1898);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 52, 1908, 1923);
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public double getWeight() {
        MethodContext _bcornu_methode_context463 = new MethodContext(double.class, 58, 1936, 2129);
        try {
            CallChecker.varInit(this, "this", 58, 1936, 2129);
            CallChecker.varInit(this.y, "y", 58, 1936, 2129);
            CallChecker.varInit(this.x, "x", 58, 1936, 2129);
            CallChecker.varInit(this.weight, "weight", 58, 1936, 2129);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.fitting.WeightedObservedPoint.serialVersionUID", 58, 1936, 2129);
            return weight;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context463.methodEnd();
        }
    }

    public double getX() {
        MethodContext _bcornu_methode_context464 = new MethodContext(double.class, 65, 2136, 2265);
        try {
            CallChecker.varInit(this, "this", 65, 2136, 2265);
            CallChecker.varInit(this.y, "y", 65, 2136, 2265);
            CallChecker.varInit(this.x, "x", 65, 2136, 2265);
            CallChecker.varInit(this.weight, "weight", 65, 2136, 2265);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.fitting.WeightedObservedPoint.serialVersionUID", 65, 2136, 2265);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context464.methodEnd();
        }
    }

    public double getY() {
        MethodContext _bcornu_methode_context465 = new MethodContext(double.class, 72, 2272, 2429);
        try {
            CallChecker.varInit(this, "this", 72, 2272, 2429);
            CallChecker.varInit(this.y, "y", 72, 2272, 2429);
            CallChecker.varInit(this.x, "x", 72, 2272, 2429);
            CallChecker.varInit(this.weight, "weight", 72, 2272, 2429);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.fitting.WeightedObservedPoint.serialVersionUID", 72, 2272, 2429);
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context465.methodEnd();
        }
    }
}

