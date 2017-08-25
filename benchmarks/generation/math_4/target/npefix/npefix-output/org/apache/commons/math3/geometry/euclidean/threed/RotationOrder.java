package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public final class RotationOrder {
    public static final RotationOrder XYZ = new RotationOrder("XYZ", Vector3D.PLUS_I, Vector3D.PLUS_J, Vector3D.PLUS_K);

    public static final RotationOrder XZY = new RotationOrder("XZY", Vector3D.PLUS_I, Vector3D.PLUS_K, Vector3D.PLUS_J);

    public static final RotationOrder YXZ = new RotationOrder("YXZ", Vector3D.PLUS_J, Vector3D.PLUS_I, Vector3D.PLUS_K);

    public static final RotationOrder YZX = new RotationOrder("YZX", Vector3D.PLUS_J, Vector3D.PLUS_K, Vector3D.PLUS_I);

    public static final RotationOrder ZXY = new RotationOrder("ZXY", Vector3D.PLUS_K, Vector3D.PLUS_I, Vector3D.PLUS_J);

    public static final RotationOrder ZYX = new RotationOrder("ZYX", Vector3D.PLUS_K, Vector3D.PLUS_J, Vector3D.PLUS_I);

    public static final RotationOrder XYX = new RotationOrder("XYX", Vector3D.PLUS_I, Vector3D.PLUS_J, Vector3D.PLUS_I);

    public static final RotationOrder XZX = new RotationOrder("XZX", Vector3D.PLUS_I, Vector3D.PLUS_K, Vector3D.PLUS_I);

    public static final RotationOrder YXY = new RotationOrder("YXY", Vector3D.PLUS_J, Vector3D.PLUS_I, Vector3D.PLUS_J);

    public static final RotationOrder YZY = new RotationOrder("YZY", Vector3D.PLUS_J, Vector3D.PLUS_K, Vector3D.PLUS_J);

    public static final RotationOrder ZXZ = new RotationOrder("ZXZ", Vector3D.PLUS_K, Vector3D.PLUS_I, Vector3D.PLUS_K);

    public static final RotationOrder ZYZ = new RotationOrder("ZYZ", Vector3D.PLUS_K, Vector3D.PLUS_J, Vector3D.PLUS_K);

    private final String name;

    private final Vector3D a1;

    private final Vector3D a2;

    private final Vector3D a3;

    private RotationOrder(final String name, final Vector3D a1, final Vector3D a2, final Vector3D a3) {
        ConstructorContext _bcornu_methode_context1108 = new ConstructorContext(RotationOrder.class, 138, 4636, 5195);
        try {
            this.name = name;
            CallChecker.varAssign(this.name, "this.name", 140, 5101, 5117);
            this.a1 = a1;
            CallChecker.varAssign(this.a1, "this.a1", 141, 5127, 5141);
            this.a2 = a2;
            CallChecker.varAssign(this.a2, "this.a2", 142, 5151, 5165);
            this.a3 = a3;
            CallChecker.varAssign(this.a3, "this.a3", 143, 5175, 5189);
        } finally {
            _bcornu_methode_context1108.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4922 = new MethodContext(String.class, 150, 5202, 5404);
        try {
            CallChecker.varInit(this, "this", 150, 5202, 5404);
            CallChecker.varInit(this.a3, "a3", 150, 5202, 5404);
            CallChecker.varInit(this.a2, "a2", 150, 5202, 5404);
            CallChecker.varInit(this.a1, "a1", 150, 5202, 5404);
            CallChecker.varInit(this.name, "name", 150, 5202, 5404);
            CallChecker.varInit(ZYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYZ", 150, 5202, 5404);
            CallChecker.varInit(ZXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXZ", 150, 5202, 5404);
            CallChecker.varInit(YZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZY", 150, 5202, 5404);
            CallChecker.varInit(YXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXY", 150, 5202, 5404);
            CallChecker.varInit(XZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZX", 150, 5202, 5404);
            CallChecker.varInit(XYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYX", 150, 5202, 5404);
            CallChecker.varInit(ZYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYX", 150, 5202, 5404);
            CallChecker.varInit(ZXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXY", 150, 5202, 5404);
            CallChecker.varInit(YZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZX", 150, 5202, 5404);
            CallChecker.varInit(YXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXZ", 150, 5202, 5404);
            CallChecker.varInit(XZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZY", 150, 5202, 5404);
            CallChecker.varInit(XYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYZ", 150, 5202, 5404);
            return name;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4922.methodEnd();
        }
    }

    public Vector3D getA1() {
        MethodContext _bcornu_methode_context4923 = new MethodContext(Vector3D.class, 157, 5411, 5554);
        try {
            CallChecker.varInit(this, "this", 157, 5411, 5554);
            CallChecker.varInit(this.a3, "a3", 157, 5411, 5554);
            CallChecker.varInit(this.a2, "a2", 157, 5411, 5554);
            CallChecker.varInit(this.a1, "a1", 157, 5411, 5554);
            CallChecker.varInit(this.name, "name", 157, 5411, 5554);
            CallChecker.varInit(ZYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYZ", 157, 5411, 5554);
            CallChecker.varInit(ZXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXZ", 157, 5411, 5554);
            CallChecker.varInit(YZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZY", 157, 5411, 5554);
            CallChecker.varInit(YXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXY", 157, 5411, 5554);
            CallChecker.varInit(XZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZX", 157, 5411, 5554);
            CallChecker.varInit(XYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYX", 157, 5411, 5554);
            CallChecker.varInit(ZYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYX", 157, 5411, 5554);
            CallChecker.varInit(ZXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXY", 157, 5411, 5554);
            CallChecker.varInit(YZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZX", 157, 5411, 5554);
            CallChecker.varInit(YXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXZ", 157, 5411, 5554);
            CallChecker.varInit(XZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZY", 157, 5411, 5554);
            CallChecker.varInit(XYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYZ", 157, 5411, 5554);
            return a1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4923.methodEnd();
        }
    }

    public Vector3D getA2() {
        MethodContext _bcornu_methode_context4924 = new MethodContext(Vector3D.class, 164, 5561, 5706);
        try {
            CallChecker.varInit(this, "this", 164, 5561, 5706);
            CallChecker.varInit(this.a3, "a3", 164, 5561, 5706);
            CallChecker.varInit(this.a2, "a2", 164, 5561, 5706);
            CallChecker.varInit(this.a1, "a1", 164, 5561, 5706);
            CallChecker.varInit(this.name, "name", 164, 5561, 5706);
            CallChecker.varInit(ZYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYZ", 164, 5561, 5706);
            CallChecker.varInit(ZXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXZ", 164, 5561, 5706);
            CallChecker.varInit(YZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZY", 164, 5561, 5706);
            CallChecker.varInit(YXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXY", 164, 5561, 5706);
            CallChecker.varInit(XZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZX", 164, 5561, 5706);
            CallChecker.varInit(XYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYX", 164, 5561, 5706);
            CallChecker.varInit(ZYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYX", 164, 5561, 5706);
            CallChecker.varInit(ZXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXY", 164, 5561, 5706);
            CallChecker.varInit(YZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZX", 164, 5561, 5706);
            CallChecker.varInit(YXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXZ", 164, 5561, 5706);
            CallChecker.varInit(XZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZY", 164, 5561, 5706);
            CallChecker.varInit(XYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYZ", 164, 5561, 5706);
            return a2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4924.methodEnd();
        }
    }

    public Vector3D getA3() {
        MethodContext _bcornu_methode_context4925 = new MethodContext(Vector3D.class, 171, 5713, 5858);
        try {
            CallChecker.varInit(this, "this", 171, 5713, 5858);
            CallChecker.varInit(this.a3, "a3", 171, 5713, 5858);
            CallChecker.varInit(this.a2, "a2", 171, 5713, 5858);
            CallChecker.varInit(this.a1, "a1", 171, 5713, 5858);
            CallChecker.varInit(this.name, "name", 171, 5713, 5858);
            CallChecker.varInit(ZYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYZ", 171, 5713, 5858);
            CallChecker.varInit(ZXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXZ", 171, 5713, 5858);
            CallChecker.varInit(YZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZY", 171, 5713, 5858);
            CallChecker.varInit(YXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXY", 171, 5713, 5858);
            CallChecker.varInit(XZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZX", 171, 5713, 5858);
            CallChecker.varInit(XYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYX", 171, 5713, 5858);
            CallChecker.varInit(ZYX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZYX", 171, 5713, 5858);
            CallChecker.varInit(ZXY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.ZXY", 171, 5713, 5858);
            CallChecker.varInit(YZX, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YZX", 171, 5713, 5858);
            CallChecker.varInit(YXZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.YXZ", 171, 5713, 5858);
            CallChecker.varInit(XZY, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XZY", 171, 5713, 5858);
            CallChecker.varInit(XYZ, "org.apache.commons.math3.geometry.euclidean.threed.RotationOrder.XYZ", 171, 5713, 5858);
            return a3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4925.methodEnd();
        }
    }
}

