package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;

public class Euclidean3D implements Serializable , Space {
    private static class LazyHolder {
        private static final Euclidean3D INSTANCE = new Euclidean3D();
    }

    private static final long serialVersionUID = 6249091865814886817L;

    private Euclidean3D() {
        ConstructorContext _bcornu_methode_context511 = new ConstructorContext(Euclidean3D.class, 37, 1283, 1366);
        try {
        } finally {
            _bcornu_methode_context511.methodEnd();
        }
    }

    public static Euclidean3D getInstance() {
        MethodContext _bcornu_methode_context2385 = new MethodContext(Euclidean3D.class, 43, 1373, 1531);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 43, 1373, 1531);
            return Euclidean3D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Euclidean3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2385.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2386 = new MethodContext(int.class, 48, 1538, 1613);
        try {
            CallChecker.varInit(this, "this", 48, 1538, 1613);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 48, 1538, 1613);
            return 3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2386.methodEnd();
        }
    }

    public Euclidean2D getSubSpace() {
        MethodContext _bcornu_methode_context2387 = new MethodContext(Euclidean2D.class, 53, 1620, 1726);
        try {
            CallChecker.varInit(this, "this", 53, 1620, 1726);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 53, 1620, 1726);
            return Euclidean2D.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Euclidean2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2387.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context2388 = new MethodContext(Object.class, 70, 2048, 2310);
        try {
            CallChecker.varInit(this, "this", 70, 2048, 2310);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 70, 2048, 2310);
            return Euclidean3D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2388.methodEnd();
        }
    }
}

