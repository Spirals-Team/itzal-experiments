package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;

public class Euclidean2D implements Serializable , Space {
    private static class LazyHolder {
        private static final Euclidean2D INSTANCE = new Euclidean2D();
    }

    private static final long serialVersionUID = 4793432849757649566L;

    private Euclidean2D() {
        ConstructorContext _bcornu_methode_context492 = new ConstructorContext(Euclidean2D.class, 37, 1281, 1364);
        try {
        } finally {
            _bcornu_methode_context492.methodEnd();
        }
    }

    public static Euclidean2D getInstance() {
        MethodContext _bcornu_methode_context2247 = new MethodContext(Euclidean2D.class, 43, 1371, 1529);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D.serialVersionUID", 43, 1371, 1529);
            return Euclidean2D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Euclidean2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2247.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2248 = new MethodContext(int.class, 48, 1536, 1611);
        try {
            CallChecker.varInit(this, "this", 48, 1536, 1611);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D.serialVersionUID", 48, 1536, 1611);
            return 2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2248.methodEnd();
        }
    }

    public Euclidean1D getSubSpace() {
        MethodContext _bcornu_methode_context2249 = new MethodContext(Euclidean1D.class, 53, 1618, 1724);
        try {
            CallChecker.varInit(this, "this", 53, 1618, 1724);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D.serialVersionUID", 53, 1618, 1724);
            return Euclidean1D.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Euclidean1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2249.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2250 = new MethodContext(Object.class, 70, 2046, 2308);
        try {
            CallChecker.varInit(this, "this", 70, 2046, 2308);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D.serialVersionUID", 70, 2046, 2308);
            return Euclidean2D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2250.methodEnd();
        }
    }
}

