package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class CentroidCluster<T extends Clusterable> extends Cluster<T> {
    private static final long serialVersionUID = -3075288519071812288L;

    private final Clusterable center;

    public CentroidCluster(final Clusterable center) {
        super();
        ConstructorContext _bcornu_methode_context1101 = new ConstructorContext(CentroidCluster.class, 41, 1392, 1637);
        try {
            this.center = center;
            CallChecker.varAssign(this.center, "this.center", 43, 1611, 1631);
        } finally {
            _bcornu_methode_context1101.methodEnd();
        }
    }

    public Clusterable getCenter() {
        MethodContext _bcornu_methode_context4911 = new MethodContext(Clusterable.class, 50, 1644, 1819);
        try {
            CallChecker.varInit(this, "this", 50, 1644, 1819);
            CallChecker.varInit(this.center, "center", 50, 1644, 1819);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ml.clustering.CentroidCluster.serialVersionUID", 50, 1644, 1819);
            return center;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Clusterable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4911.methodEnd();
        }
    }
}

