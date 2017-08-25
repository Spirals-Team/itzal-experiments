package org.apache.commons.math3.stat.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Cluster<T extends Clusterable<T>> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;

    private final List<T> points;

    private final T center;

    public Cluster(final T center) {
        ConstructorContext _bcornu_methode_context1022 = new ConstructorContext(Cluster.class, 48, 1559, 1806);
        try {
            this.center = center;
            CallChecker.varAssign(this.center, "this.center", 49, 1743, 1763);
            points = new ArrayList<T>();
            CallChecker.varAssign(this.points, "this.points", 50, 1773, 1800);
        } finally {
            _bcornu_methode_context1022.methodEnd();
        }
    }

    public void addPoint(final T point) {
        MethodContext _bcornu_methode_context4558 = new MethodContext(void.class, 57, 1813, 1967);
        try {
            CallChecker.varInit(this, "this", 57, 1813, 1967);
            CallChecker.varInit(point, "point", 57, 1813, 1967);
            CallChecker.varInit(this.center, "center", 57, 1813, 1967);
            CallChecker.varInit(this.points, "points", 57, 1813, 1967);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.Cluster.serialVersionUID", 57, 1813, 1967);
            if (CallChecker.beforeDeref(points, List.class, 58, 1944, 1949)) {
                CallChecker.isCalled(points, List.class, 58, 1944, 1949).add(point);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4558.methodEnd();
        }
    }

    public List<T> getPoints() {
        MethodContext _bcornu_methode_context4559 = new MethodContext(List.class, 65, 1974, 2141);
        try {
            CallChecker.varInit(this, "this", 65, 1974, 2141);
            CallChecker.varInit(this.center, "center", 65, 1974, 2141);
            CallChecker.varInit(this.points, "points", 65, 1974, 2141);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.Cluster.serialVersionUID", 65, 1974, 2141);
            return points;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4559.methodEnd();
        }
    }

    public T getCenter() {
        MethodContext _bcornu_methode_context4560 = new MethodContext(null, 73, 2148, 2313);
        try {
            CallChecker.varInit(this, "this", 73, 2148, 2313);
            CallChecker.varInit(this.center, "center", 73, 2148, 2313);
            CallChecker.varInit(this.points, "points", 73, 2148, 2313);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.clustering.Cluster.serialVersionUID", 73, 2148, 2313);
            return center;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4560.methodEnd();
        }
    }
}

