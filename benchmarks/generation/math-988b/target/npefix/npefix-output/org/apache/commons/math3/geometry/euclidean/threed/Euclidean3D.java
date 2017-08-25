package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;

public class Euclidean3D implements Serializable , Space {
    private static class LazyHolder {
        private static final Euclidean3D INSTANCE = new Euclidean3D();
    }

    private static final long serialVersionUID = 6249091865814886817L;

    private Euclidean3D() {
        ConstructorContext _bcornu_methode_context19 = new ConstructorContext(Euclidean3D.class, 37, 1334, 1417);
        try {
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public static Euclidean3D getInstance() {
        MethodContext _bcornu_methode_context65 = new MethodContext(Euclidean3D.class, 43, 1424, 1582);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 43, 1424, 1582);
            return Euclidean3D.LazyHolder.INSTANCE;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Euclidean3D) (CallChecker.isToCatch(_bcornu_return_t, Euclidean3D.class)));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context66 = new MethodContext(int.class, 48, 1589, 1664);
        try {
            CallChecker.varInit(this, "this", 48, 1589, 1664);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 48, 1589, 1664);
            return 3;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Integer) (CallChecker.isToCatch(_bcornu_return_t, int.class)));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public Euclidean2D getSubSpace() {
        MethodContext _bcornu_methode_context67 = new MethodContext(Euclidean2D.class, 53, 1671, 1777);
        try {
            CallChecker.varInit(this, "this", 53, 1671, 1777);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 53, 1671, 1777);
            return Euclidean2D.getInstance();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Euclidean2D) (CallChecker.isToCatch(_bcornu_return_t, Euclidean2D.class)));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context68 = new MethodContext(Object.class, 70, 2099, 2361);
        try {
            CallChecker.varInit(this, "this", 70, 2099, 2361);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.Euclidean3D.serialVersionUID", 70, 2099, 2361);
            return Euclidean3D.LazyHolder.INSTANCE;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Object) (CallChecker.isToCatch(_bcornu_return_t, Object.class)));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }
}

