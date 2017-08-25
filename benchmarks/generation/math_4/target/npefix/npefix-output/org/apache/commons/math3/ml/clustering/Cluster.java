package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cluster<T extends Clusterable> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;

    private final List<T> points;

    public Cluster() {
        ConstructorContext _bcornu_methode_context1023 = new ConstructorContext(Cluster.class, 41, 1360, 1490);
        try {
            points = new ArrayList<T>();
            CallChecker.varAssign(this.points, "this.points", 42, 1457, 1484);
        } finally {
            _bcornu_methode_context1023.methodEnd();
        }
    }

    public void addPoint(final T point) {
        MethodContext _bcornu_methode_context4561 = new MethodContext(void.class, 49, 1497, 1651);
        try {
            CallChecker.varInit(this, "this", 49, 1497, 1651);
            CallChecker.varInit(point, "point", 49, 1497, 1651);
            CallChecker.varInit(this.points, "points", 49, 1497, 1651);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.Cluster.serialVersionUID", 49, 1497, 1651);
            if (CallChecker.beforeDeref(points, List.class, 50, 1628, 1633)) {
                CallChecker.isCalled(points, List.class, 50, 1628, 1633).add(point);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4561.methodEnd();
        }
    }

    public List<T> getPoints() {
        MethodContext _bcornu_methode_context4562 = new MethodContext(List.class, 57, 1658, 1825);
        try {
            CallChecker.varInit(this, "this", 57, 1658, 1825);
            CallChecker.varInit(this.points, "points", 57, 1658, 1825);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.Cluster.serialVersionUID", 57, 1658, 1825);
            return points;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4562.methodEnd();
        }
    }
}

