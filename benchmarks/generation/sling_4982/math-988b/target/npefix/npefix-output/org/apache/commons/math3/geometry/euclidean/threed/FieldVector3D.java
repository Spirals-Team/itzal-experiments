package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class FieldVector3D<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224L;

    private final T x;

    private final T y;

    private final T z;

    public FieldVector3D(final T x, final T y, final T z) {
        ConstructorContext _bcornu_methode_context26 = new ConstructorContext(FieldVector3D.class, 60, 1894, 2226);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 61, 2170, 2180);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 62, 2190, 2200);
            this.z = z;
            CallChecker.varAssign(this.z, "this.z", 63, 2210, 2220);
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public FieldVector3D(final T[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context27 = new ConstructorContext(FieldVector3D.class, 72, 2233, 2693);
        try {
            if ((v.length) != 3) {
                throw new DimensionMismatchException(v.length, 3);
            }
            this.x = v[0];
            CallChecker.varAssign(this.x, "this.x", 76, 2628, 2641);
            this.y = v[1];
            CallChecker.varAssign(this.y, "this.y", 77, 2651, 2664);
            this.z = v[2];
            CallChecker.varAssign(this.z, "this.z", 78, 2674, 2687);
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public FieldVector3D(final T alpha, final T delta) {
        ConstructorContext _bcornu_methode_context28 = new ConstructorContext(FieldVector3D.class, 89, 2700, 3259);
        try {
            T cosDelta = CallChecker.varInit(delta.cos(), "cosDelta", 90, 3101, 3125);
            this.x = alpha.cos().multiply(cosDelta);
            CallChecker.varAssign(this.x, "this.x", 91, 3135, 3174);
            this.y = alpha.sin().multiply(cosDelta);
            CallChecker.varAssign(this.y, "this.y", 92, 3184, 3223);
            this.z = delta.sin();
            CallChecker.varAssign(this.z, "this.z", 93, 3233, 3253);
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public FieldVector3D(final T a, final FieldVector3D<T> u) {
        ConstructorContext _bcornu_methode_context29 = new ConstructorContext(FieldVector3D.class, 102, 3266, 3639);
        try {
            this.x = a.multiply(u.x);
            CallChecker.varAssign(this.x, "this.x", 103, 3541, 3565);
            this.y = a.multiply(u.y);
            CallChecker.varAssign(this.y, "this.y", 104, 3575, 3599);
            this.z = a.multiply(u.z);
            CallChecker.varAssign(this.z, "this.z", 105, 3609, 3633);
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public FieldVector3D(final T a, final Vector3D u) {
        ConstructorContext _bcornu_methode_context30 = new ConstructorContext(FieldVector3D.class, 114, 3646, 4027);
        try {
            this.x = a.multiply(u.getX());
            CallChecker.varAssign(this.x, "this.x", 115, 3914, 3943);
            this.y = a.multiply(u.getY());
            CallChecker.varAssign(this.y, "this.y", 116, 3953, 3982);
            this.z = a.multiply(u.getZ());
            CallChecker.varAssign(this.z, "this.z", 117, 3992, 4021);
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public FieldVector3D(final double a, final FieldVector3D<T> u) {
        ConstructorContext _bcornu_methode_context31 = new ConstructorContext(FieldVector3D.class, 126, 4034, 4413);
        try {
            this.x = u.x.multiply(a);
            CallChecker.varAssign(this.x, "this.x", 127, 4315, 4339);
            this.y = u.y.multiply(a);
            CallChecker.varAssign(this.y, "this.y", 128, 4349, 4373);
            this.z = u.z.multiply(a);
            CallChecker.varAssign(this.z, "this.z", 129, 4383, 4407);
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2) {
        ConstructorContext _bcornu_methode_context32 = new ConstructorContext(FieldVector3D.class, 140, 4420, 5136);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 142, 4880, 4902);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX());
            CallChecker.varAssign(this.x, "this.x", 143, 4912, 4978);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY());
            CallChecker.varAssign(this.y, "this.y", 144, 4988, 5054);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ());
            CallChecker.varAssign(this.z, "this.z", 145, 5064, 5130);
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2) {
        ConstructorContext _bcornu_methode_context33 = new ConstructorContext(FieldVector3D.class, 156, 5143, 5843);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 158, 5587, 5609);
            this.x = prototype.linearCombination(u1.getX(), a1, u2.getX(), a2);
            CallChecker.varAssign(this.x, "this.x", 159, 5619, 5685);
            this.y = prototype.linearCombination(u1.getY(), a1, u2.getY(), a2);
            CallChecker.varAssign(this.y, "this.y", 160, 5695, 5761);
            this.z = prototype.linearCombination(u1.getZ(), a1, u2.getZ(), a2);
            CallChecker.varAssign(this.z, "this.z", 161, 5771, 5837);
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2) {
        ConstructorContext _bcornu_methode_context34 = new ConstructorContext(FieldVector3D.class, 172, 5850, 6583);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 174, 6320, 6349);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX());
            CallChecker.varAssign(this.x, "this.x", 175, 6359, 6425);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY());
            CallChecker.varAssign(this.y, "this.y", 176, 6435, 6501);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ());
            CallChecker.varAssign(this.z, "this.z", 177, 6511, 6577);
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2, final T a3, final FieldVector3D<T> u3) {
        ConstructorContext _bcornu_methode_context35 = new ConstructorContext(FieldVector3D.class, 190, 6590, 7509);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 193, 7208, 7230);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX());
            CallChecker.varAssign(this.x, "this.x", 194, 7240, 7321);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY());
            CallChecker.varAssign(this.y, "this.y", 195, 7331, 7412);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ());
            CallChecker.varAssign(this.z, "this.z", 196, 7422, 7503);
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2, final T a3, final Vector3D u3) {
        ConstructorContext _bcornu_methode_context36 = new ConstructorContext(FieldVector3D.class, 209, 7516, 8411);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 212, 8110, 8132);
            this.x = prototype.linearCombination(u1.getX(), a1, u2.getX(), a2, u3.getX(), a3);
            CallChecker.varAssign(this.x, "this.x", 213, 8142, 8223);
            this.y = prototype.linearCombination(u1.getY(), a1, u2.getY(), a2, u3.getY(), a3);
            CallChecker.varAssign(this.y, "this.y", 214, 8233, 8314);
            this.z = prototype.linearCombination(u1.getZ(), a1, u2.getZ(), a2, u3.getZ(), a3);
            CallChecker.varAssign(this.z, "this.z", 215, 8324, 8405);
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2, final double a3, final FieldVector3D<T> u3) {
        ConstructorContext _bcornu_methode_context37 = new ConstructorContext(FieldVector3D.class, 228, 8418, 9359);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 231, 9051, 9080);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX());
            CallChecker.varAssign(this.x, "this.x", 232, 9090, 9171);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY());
            CallChecker.varAssign(this.y, "this.y", 233, 9181, 9262);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ());
            CallChecker.varAssign(this.z, "this.z", 234, 9272, 9353);
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2, final T a3, final FieldVector3D<T> u3, final T a4, final FieldVector3D<T> u4) {
        ConstructorContext _bcornu_methode_context38 = new ConstructorContext(FieldVector3D.class, 249, 9366, 10487);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 253, 10141, 10163);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX(), a4, u4.getX());
            CallChecker.varAssign(this.x, "this.x", 254, 10173, 10269);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY(), a4, u4.getY());
            CallChecker.varAssign(this.y, "this.y", 255, 10279, 10375);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ(), a4, u4.getZ());
            CallChecker.varAssign(this.z, "this.z", 256, 10385, 10481);
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2, final T a3, final Vector3D u3, final T a4, final Vector3D u4) {
        ConstructorContext _bcornu_methode_context39 = new ConstructorContext(FieldVector3D.class, 271, 10494, 11583);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 275, 11237, 11259);
            this.x = prototype.linearCombination(u1.getX(), a1, u2.getX(), a2, u3.getX(), a3, u4.getX(), a4);
            CallChecker.varAssign(this.x, "this.x", 276, 11269, 11365);
            this.y = prototype.linearCombination(u1.getY(), a1, u2.getY(), a2, u3.getY(), a3, u4.getY(), a4);
            CallChecker.varAssign(this.y, "this.y", 277, 11375, 11471);
            this.z = prototype.linearCombination(u1.getZ(), a1, u2.getZ(), a2, u3.getZ(), a3, u4.getZ(), a4);
            CallChecker.varAssign(this.z, "this.z", 278, 11481, 11577);
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2, final double a3, final FieldVector3D<T> u3, final double a4, final FieldVector3D<T> u4) {
        ConstructorContext _bcornu_methode_context40 = new ConstructorContext(FieldVector3D.class, 293, 11590, 12738);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 297, 12385, 12414);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX(), a4, u4.getX());
            CallChecker.varAssign(this.x, "this.x", 298, 12424, 12520);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY(), a4, u4.getY());
            CallChecker.varAssign(this.y, "this.y", 299, 12530, 12626);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ(), a4, u4.getZ());
            CallChecker.varAssign(this.z, "this.z", 300, 12636, 12732);
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public T getX() {
        MethodContext _bcornu_methode_context100 = new MethodContext(null, 307, 12745, 12952);
        try {
            CallChecker.varInit(this, "this", 307, 12745, 12952);
            CallChecker.varInit(this.z, "z", 307, 12745, 12952);
            CallChecker.varInit(this.y, "y", 307, 12745, 12952);
            CallChecker.varInit(this.x, "x", 307, 12745, 12952);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 307, 12745, 12952);
            return x;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public T getY() {
        MethodContext _bcornu_methode_context101 = new MethodContext(null, 315, 12959, 13166);
        try {
            CallChecker.varInit(this, "this", 315, 12959, 13166);
            CallChecker.varInit(this.z, "z", 315, 12959, 13166);
            CallChecker.varInit(this.y, "y", 315, 12959, 13166);
            CallChecker.varInit(this.x, "x", 315, 12959, 13166);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 315, 12959, 13166);
            return y;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    public T getZ() {
        MethodContext _bcornu_methode_context102 = new MethodContext(null, 323, 13173, 13376);
        try {
            CallChecker.varInit(this, "this", 323, 13173, 13376);
            CallChecker.varInit(this.z, "z", 323, 13173, 13376);
            CallChecker.varInit(this.y, "y", 323, 13173, 13376);
            CallChecker.varInit(this.x, "x", 323, 13173, 13376);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 323, 13173, 13376);
            return z;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    public T[] toArray() {
        MethodContext _bcornu_methode_context103 = new MethodContext(null, 331, 13383, 13712);
        try {
            CallChecker.varInit(this, "this", 331, 13383, 13712);
            CallChecker.varInit(this.z, "z", 331, 13383, 13712);
            CallChecker.varInit(this.y, "y", 331, 13383, 13712);
            CallChecker.varInit(this.x, "x", 331, 13383, 13712);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 331, 13383, 13712);
            final T[] array = CallChecker.varInit(MathArrays.buildArray(x.getField(), 3), "array", 332, 13562, 13618);
            array[0] = x;
            CallChecker.varAssign(array[0], "array[0]", 333, 13628, 13640);
            array[1] = y;
            CallChecker.varAssign(array[1], "array[1]", 334, 13650, 13662);
            array[2] = z;
            CallChecker.varAssign(array[2], "array[2]", 335, 13672, 13684);
            return array;
        } catch (RuntimeException _bcornu_return_t) {
            return ((T[]) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public Vector3D toVector3D() {
        MethodContext _bcornu_methode_context104 = new MethodContext(Vector3D.class, 342, 13719, 13921);
        try {
            CallChecker.varInit(this, "this", 342, 13719, 13921);
            CallChecker.varInit(this.z, "z", 342, 13719, 13921);
            CallChecker.varInit(this.y, "y", 342, 13719, 13921);
            CallChecker.varInit(this.x, "x", 342, 13719, 13921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 342, 13719, 13921);
            return new Vector3D(x.getReal(), y.getReal(), z.getReal());
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    public T getNorm1() {
        MethodContext _bcornu_methode_context105 = new MethodContext(null, 349, 13928, 14112);
        try {
            CallChecker.varInit(this, "this", 349, 13928, 14112);
            CallChecker.varInit(this.z, "z", 349, 13928, 14112);
            CallChecker.varInit(this.y, "y", 349, 13928, 14112);
            CallChecker.varInit(this.x, "x", 349, 13928, 14112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 349, 13928, 14112);
            return x.abs().add(y.abs()).add(z.abs());
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public T getNorm() {
        MethodContext _bcornu_methode_context106 = new MethodContext(null, 356, 14119, 14413);
        try {
            CallChecker.varInit(this, "this", 356, 14119, 14413);
            CallChecker.varInit(this.z, "z", 356, 14119, 14413);
            CallChecker.varInit(this.y, "y", 356, 14119, 14413);
            CallChecker.varInit(this.x, "x", 356, 14119, 14413);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 356, 14119, 14413);
            return x.multiply(x).add(y.multiply(y)).add(z.multiply(z)).sqrt();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public T getNormSq() {
        MethodContext _bcornu_methode_context107 = new MethodContext(null, 364, 14420, 14723);
        try {
            CallChecker.varInit(this, "this", 364, 14420, 14723);
            CallChecker.varInit(this.z, "z", 364, 14420, 14723);
            CallChecker.varInit(this.y, "y", 364, 14420, 14723);
            CallChecker.varInit(this.x, "x", 364, 14420, 14723);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 364, 14420, 14723);
            return x.multiply(x).add(y.multiply(y)).add(z.multiply(z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public T getNormInf() {
        MethodContext _bcornu_methode_context108 = new MethodContext(null, 372, 14730, 15339);
        try {
            CallChecker.varInit(this, "this", 372, 14730, 15339);
            CallChecker.varInit(this.z, "z", 372, 14730, 15339);
            CallChecker.varInit(this.y, "y", 372, 14730, 15339);
            CallChecker.varInit(this.x, "x", 372, 14730, 15339);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 372, 14730, 15339);
            final T xAbs = CallChecker.varInit(x.abs(), "xAbs", 373, 14882, 14904);
            final T yAbs = CallChecker.varInit(y.abs(), "yAbs", 374, 14914, 14936);
            final T zAbs = CallChecker.varInit(z.abs(), "zAbs", 375, 14946, 14968);
            if ((xAbs.getReal()) <= (yAbs.getReal())) {
                if ((yAbs.getReal()) <= (zAbs.getReal())) {
                    return zAbs;
                }else {
                    return yAbs;
                }
            }else {
                if ((xAbs.getReal()) <= (zAbs.getReal())) {
                    return zAbs;
                }else {
                    return xAbs;
                }
            }
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public T getAlpha() {
        MethodContext _bcornu_methode_context109 = new MethodContext(null, 395, 15346, 15581);
        try {
            CallChecker.varInit(this, "this", 395, 15346, 15581);
            CallChecker.varInit(this.z, "z", 395, 15346, 15581);
            CallChecker.varInit(this.y, "y", 395, 15346, 15581);
            CallChecker.varInit(this.x, "x", 395, 15346, 15581);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 395, 15346, 15581);
            return y.atan2(x);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context109.methodEnd();
        }
    }

    public T getDelta() {
        MethodContext _bcornu_methode_context110 = new MethodContext(null, 403, 15588, 15847);
        try {
            CallChecker.varInit(this, "this", 403, 15588, 15847);
            CallChecker.varInit(this.z, "z", 403, 15588, 15847);
            CallChecker.varInit(this.y, "y", 403, 15588, 15847);
            CallChecker.varInit(this.x, "x", 403, 15588, 15847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 403, 15588, 15847);
            return z.divide(getNorm()).asin();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public FieldVector3D<T> add(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context111 = new MethodContext(FieldVector3D.class, 411, 15854, 16091);
        try {
            CallChecker.varInit(this, "this", 411, 15854, 16091);
            CallChecker.varInit(v, "v", 411, 15854, 16091);
            CallChecker.varInit(this.z, "z", 411, 15854, 16091);
            CallChecker.varInit(this.y, "y", 411, 15854, 16091);
            CallChecker.varInit(this.x, "x", 411, 15854, 16091);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 411, 15854, 16091);
            return new FieldVector3D<T>(x.add(v.x), y.add(v.y), z.add(v.z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public FieldVector3D<T> add(final Vector3D v) {
        MethodContext _bcornu_methode_context112 = new MethodContext(FieldVector3D.class, 419, 16098, 16342);
        try {
            CallChecker.varInit(this, "this", 419, 16098, 16342);
            CallChecker.varInit(v, "v", 419, 16098, 16342);
            CallChecker.varInit(this.z, "z", 419, 16098, 16342);
            CallChecker.varInit(this.y, "y", 419, 16098, 16342);
            CallChecker.varInit(this.x, "x", 419, 16098, 16342);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 419, 16098, 16342);
            return new FieldVector3D<T>(x.add(v.getX()), y.add(v.getY()), z.add(v.getZ()));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public FieldVector3D<T> add(final T factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context113 = new MethodContext(FieldVector3D.class, 428, 16349, 16678);
        try {
            CallChecker.varInit(this, "this", 428, 16349, 16678);
            CallChecker.varInit(v, "v", 428, 16349, 16678);
            CallChecker.varInit(factor, "factor", 428, 16349, 16678);
            CallChecker.varInit(this.z, "z", 428, 16349, 16678);
            CallChecker.varInit(this.y, "y", 428, 16349, 16678);
            CallChecker.varInit(this.x, "x", 428, 16349, 16678);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 428, 16349, 16678);
            return new FieldVector3D<T>(x.getField().getOne(), this, factor, v);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public FieldVector3D<T> add(final T factor, final Vector3D v) {
        MethodContext _bcornu_methode_context114 = new MethodContext(FieldVector3D.class, 437, 16685, 17140);
        try {
            CallChecker.varInit(this, "this", 437, 16685, 17140);
            CallChecker.varInit(v, "v", 437, 16685, 17140);
            CallChecker.varInit(factor, "factor", 437, 16685, 17140);
            CallChecker.varInit(this.z, "z", 437, 16685, 17140);
            CallChecker.varInit(this.y, "y", 437, 16685, 17140);
            CallChecker.varInit(this.x, "x", 437, 16685, 17140);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 437, 16685, 17140);
            return new FieldVector3D<T>(x.add(factor.multiply(v.getX())), y.add(factor.multiply(v.getY())), z.add(factor.multiply(v.getZ())));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    public FieldVector3D<T> add(final double factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context115 = new MethodContext(FieldVector3D.class, 448, 17147, 17463);
        try {
            CallChecker.varInit(this, "this", 448, 17147, 17463);
            CallChecker.varInit(v, "v", 448, 17147, 17463);
            CallChecker.varInit(factor, "factor", 448, 17147, 17463);
            CallChecker.varInit(this.z, "z", 448, 17147, 17463);
            CallChecker.varInit(this.y, "y", 448, 17147, 17463);
            CallChecker.varInit(this.x, "x", 448, 17147, 17463);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 448, 17147, 17463);
            return new FieldVector3D<T>(1.0, this, factor, v);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public FieldVector3D<T> add(final double factor, final Vector3D v) {
        MethodContext _bcornu_methode_context116 = new MethodContext(FieldVector3D.class, 457, 17470, 17906);
        try {
            CallChecker.varInit(this, "this", 457, 17470, 17906);
            CallChecker.varInit(v, "v", 457, 17470, 17906);
            CallChecker.varInit(factor, "factor", 457, 17470, 17906);
            CallChecker.varInit(this.z, "z", 457, 17470, 17906);
            CallChecker.varInit(this.y, "y", 457, 17470, 17906);
            CallChecker.varInit(this.x, "x", 457, 17470, 17906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 457, 17470, 17906);
            return new FieldVector3D<T>(x.add((factor * (v.getX()))), y.add((factor * (v.getY()))), z.add((factor * (v.getZ()))));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context117 = new MethodContext(FieldVector3D.class, 467, 17913, 18182);
        try {
            CallChecker.varInit(this, "this", 467, 17913, 18182);
            CallChecker.varInit(v, "v", 467, 17913, 18182);
            CallChecker.varInit(this.z, "z", 467, 17913, 18182);
            CallChecker.varInit(this.y, "y", 467, 17913, 18182);
            CallChecker.varInit(this.x, "x", 467, 17913, 18182);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 467, 17913, 18182);
            return new FieldVector3D<T>(x.subtract(v.x), y.subtract(v.y), z.subtract(v.z));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final Vector3D v) {
        MethodContext _bcornu_methode_context118 = new MethodContext(FieldVector3D.class, 475, 18189, 18465);
        try {
            CallChecker.varInit(this, "this", 475, 18189, 18465);
            CallChecker.varInit(v, "v", 475, 18189, 18465);
            CallChecker.varInit(this.z, "z", 475, 18189, 18465);
            CallChecker.varInit(this.y, "y", 475, 18189, 18465);
            CallChecker.varInit(this.x, "x", 475, 18189, 18465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 475, 18189, 18465);
            return new FieldVector3D<T>(x.subtract(v.getX()), y.subtract(v.getY()), z.subtract(v.getZ()));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final T factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context119 = new MethodContext(FieldVector3D.class, 484, 18472, 18832);
        try {
            CallChecker.varInit(this, "this", 484, 18472, 18832);
            CallChecker.varInit(v, "v", 484, 18472, 18832);
            CallChecker.varInit(factor, "factor", 484, 18472, 18832);
            CallChecker.varInit(this.z, "z", 484, 18472, 18832);
            CallChecker.varInit(this.y, "y", 484, 18472, 18832);
            CallChecker.varInit(this.x, "x", 484, 18472, 18832);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 484, 18472, 18832);
            return new FieldVector3D<T>(x.getField().getOne(), this, factor.negate(), v);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final T factor, final Vector3D v) {
        MethodContext _bcornu_methode_context120 = new MethodContext(FieldVector3D.class, 493, 18839, 19331);
        try {
            CallChecker.varInit(this, "this", 493, 18839, 19331);
            CallChecker.varInit(v, "v", 493, 18839, 19331);
            CallChecker.varInit(factor, "factor", 493, 18839, 19331);
            CallChecker.varInit(this.z, "z", 493, 18839, 19331);
            CallChecker.varInit(this.y, "y", 493, 18839, 19331);
            CallChecker.varInit(this.x, "x", 493, 18839, 19331);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 493, 18839, 19331);
            return new FieldVector3D<T>(x.subtract(factor.multiply(v.getX())), y.subtract(factor.multiply(v.getY())), z.subtract(factor.multiply(v.getZ())));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final double factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context121 = new MethodContext(FieldVector3D.class, 504, 19338, 19677);
        try {
            CallChecker.varInit(this, "this", 504, 19338, 19677);
            CallChecker.varInit(v, "v", 504, 19338, 19677);
            CallChecker.varInit(factor, "factor", 504, 19338, 19677);
            CallChecker.varInit(this.z, "z", 504, 19338, 19677);
            CallChecker.varInit(this.y, "y", 504, 19338, 19677);
            CallChecker.varInit(this.x, "x", 504, 19338, 19677);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 504, 19338, 19677);
            return new FieldVector3D<T>(1.0, this, (-factor), v);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final double factor, final Vector3D v) {
        MethodContext _bcornu_methode_context122 = new MethodContext(FieldVector3D.class, 513, 19684, 20157);
        try {
            CallChecker.varInit(this, "this", 513, 19684, 20157);
            CallChecker.varInit(v, "v", 513, 19684, 20157);
            CallChecker.varInit(factor, "factor", 513, 19684, 20157);
            CallChecker.varInit(this.z, "z", 513, 19684, 20157);
            CallChecker.varInit(this.y, "y", 513, 19684, 20157);
            CallChecker.varInit(this.x, "x", 513, 19684, 20157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 513, 19684, 20157);
            return new FieldVector3D<T>(x.subtract((factor * (v.getX()))), y.subtract((factor * (v.getY()))), z.subtract((factor * (v.getZ()))));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public FieldVector3D<T> normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context123 = new MethodContext(FieldVector3D.class, 523, 20164, 20626);
        try {
            CallChecker.varInit(this, "this", 523, 20164, 20626);
            CallChecker.varInit(this.z, "z", 523, 20164, 20626);
            CallChecker.varInit(this.y, "y", 523, 20164, 20626);
            CallChecker.varInit(this.x, "x", 523, 20164, 20626);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 523, 20164, 20626);
            final T s = CallChecker.varInit(getNorm(), "s", 524, 20409, 20430);
            if ((s.getReal()) == 0) {
                throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
            }
            return scalarMultiply(s.reciprocal());
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    public FieldVector3D<T> orthogonal() throws MathArithmeticException {
        MethodContext _bcornu_methode_context124 = new MethodContext(FieldVector3D.class, 546, 20633, 22402);
        try {
            CallChecker.varInit(this, "this", 546, 20633, 22402);
            CallChecker.varInit(this.z, "z", 546, 20633, 22402);
            CallChecker.varInit(this.y, "y", 546, 20633, 22402);
            CallChecker.varInit(this.x, "x", 546, 20633, 22402);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 546, 20633, 22402);
            final double threshold = CallChecker.varInit(((double) (0.6 * (getNorm().getReal()))), "threshold", 548, 21466, 21516);
            if (threshold == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            if ((FastMath.abs(x.getReal())) <= threshold) {
                final T inverse = CallChecker.varInit(y.multiply(y).add(z.multiply(z)).sqrt().reciprocal(), "inverse", 554, 21700, 21771);
                return new FieldVector3D<T>(inverse.getField().getZero(), inverse.multiply(z), inverse.multiply(y).negate());
            }else
                if ((FastMath.abs(y.getReal())) <= threshold) {
                    final T inverse = CallChecker.varInit(x.multiply(x).add(z.multiply(z)).sqrt().reciprocal(), "inverse", 557, 21968, 22039);
                    return new FieldVector3D<T>(inverse.multiply(z).negate(), inverse.getField().getZero(), inverse.multiply(x));
                }else {
                    final T inverse = CallChecker.varInit(x.multiply(x).add(y.multiply(y)).sqrt().reciprocal(), "inverse", 560, 22192, 22263);
                    return new FieldVector3D<T>(inverse.multiply(y), inverse.multiply(x).negate(), inverse.getField().getZero());
                }
            
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final FieldVector3D<T> v1, final FieldVector3D<T> v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context125 = new MethodContext(null, 578, 22409, 24003);
        try {
            CallChecker.varInit(v2, "v2", 578, 22409, 24003);
            CallChecker.varInit(v1, "v1", 578, 22409, 24003);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 578, 22409, 24003);
            final T normProduct = CallChecker.varInit(v1.getNorm().multiply(v2.getNorm()), "normProduct", 581, 23170, 23227);
            if ((normProduct.getReal()) == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(v1, v2), "dot", 586, 23365, 23397);
            final double threshold = CallChecker.varInit(((double) ((normProduct.getReal()) * 0.9999)), "threshold", 587, 23407, 23462);
            if (((dot.getReal()) < (-threshold)) || ((dot.getReal()) > threshold)) {
                FieldVector3D<T> v3 = CallChecker.varInit(FieldVector3D.crossProduct(v1, v2), "v3", 590, 23621, 23663);
                if ((dot.getReal()) >= 0) {
                    return v3.getNorm().divide(normProduct).asin();
                }
                return v3.getNorm().divide(normProduct).asin().subtract(FastMath.PI).negate();
            }
            return dot.divide(normProduct).acos();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final FieldVector3D<T> v1, final Vector3D v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context126 = new MethodContext(null, 614, 24010, 25596);
        try {
            CallChecker.varInit(v2, "v2", 614, 24010, 25596);
            CallChecker.varInit(v1, "v1", 614, 24010, 25596);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 614, 24010, 25596);
            final T normProduct = CallChecker.varInit(v1.getNorm().multiply(v2.getNorm()), "normProduct", 617, 24763, 24820);
            if ((normProduct.getReal()) == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(v1, v2), "dot", 622, 24958, 24990);
            final double threshold = CallChecker.varInit(((double) ((normProduct.getReal()) * 0.9999)), "threshold", 623, 25000, 25055);
            if (((dot.getReal()) < (-threshold)) || ((dot.getReal()) > threshold)) {
                FieldVector3D<T> v3 = CallChecker.varInit(FieldVector3D.crossProduct(v1, v2), "v3", 626, 25214, 25256);
                if ((dot.getReal()) >= 0) {
                    return v3.getNorm().divide(normProduct).asin();
                }
                return v3.getNorm().divide(normProduct).asin().subtract(FastMath.PI).negate();
            }
            return dot.divide(normProduct).acos();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final Vector3D v1, final FieldVector3D<T> v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context127 = new MethodContext(null, 650, 25603, 26381);
        try {
            CallChecker.varInit(v2, "v2", 650, 25603, 26381);
            CallChecker.varInit(v1, "v1", 650, 25603, 26381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 650, 25603, 26381);
            return FieldVector3D.angle(v2, v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public FieldVector3D<T> negate() {
        MethodContext _bcornu_methode_context128 = new MethodContext(FieldVector3D.class, 658, 26388, 26612);
        try {
            CallChecker.varInit(this, "this", 658, 26388, 26612);
            CallChecker.varInit(this.z, "z", 658, 26388, 26612);
            CallChecker.varInit(this.y, "y", 658, 26388, 26612);
            CallChecker.varInit(this.x, "x", 658, 26388, 26612);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 658, 26388, 26612);
            return new FieldVector3D<T>(x.negate(), y.negate(), z.negate());
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public FieldVector3D<T> scalarMultiply(final T a) {
        MethodContext _bcornu_methode_context129 = new MethodContext(FieldVector3D.class, 666, 26619, 26859);
        try {
            CallChecker.varInit(this, "this", 666, 26619, 26859);
            CallChecker.varInit(a, "a", 666, 26619, 26859);
            CallChecker.varInit(this.z, "z", 666, 26619, 26859);
            CallChecker.varInit(this.y, "y", 666, 26619, 26859);
            CallChecker.varInit(this.x, "x", 666, 26619, 26859);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 666, 26619, 26859);
            return new FieldVector3D<T>(x.multiply(a), y.multiply(a), z.multiply(a));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public FieldVector3D<T> scalarMultiply(final double a) {
        MethodContext _bcornu_methode_context130 = new MethodContext(FieldVector3D.class, 674, 26866, 27111);
        try {
            CallChecker.varInit(this, "this", 674, 26866, 27111);
            CallChecker.varInit(a, "a", 674, 26866, 27111);
            CallChecker.varInit(this.z, "z", 674, 26866, 27111);
            CallChecker.varInit(this.y, "y", 674, 26866, 27111);
            CallChecker.varInit(this.x, "x", 674, 26866, 27111);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 674, 26866, 27111);
            return new FieldVector3D<T>(x.multiply(a), y.multiply(a), z.multiply(a));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context131 = new MethodContext(boolean.class, 682, 27118, 27418);
        try {
            CallChecker.varInit(this, "this", 682, 27118, 27418);
            CallChecker.varInit(this.z, "z", 682, 27118, 27418);
            CallChecker.varInit(this.y, "y", 682, 27118, 27418);
            CallChecker.varInit(this.x, "x", 682, 27118, 27418);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 682, 27118, 27418);
            return ((Double.isNaN(x.getReal())) || (Double.isNaN(y.getReal()))) || (Double.isNaN(z.getReal()));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context132 = new MethodContext(boolean.class, 692, 27425, 27817);
        try {
            CallChecker.varInit(this, "this", 692, 27425, 27817);
            CallChecker.varInit(this.z, "z", 692, 27425, 27817);
            CallChecker.varInit(this.y, "y", 692, 27425, 27817);
            CallChecker.varInit(this.x, "x", 692, 27425, 27817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 692, 27425, 27817);
            return (!(isNaN())) && (((Double.isInfinite(x.getReal())) || (Double.isInfinite(y.getReal()))) || (Double.isInfinite(z.getReal())));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context133 = new MethodContext(boolean.class, 716, 27824, 29115);
        try {
            CallChecker.varInit(this, "this", 716, 27824, 29115);
            CallChecker.varInit(other, "other", 716, 27824, 29115);
            CallChecker.varInit(this.z, "z", 716, 27824, 29115);
            CallChecker.varInit(this.y, "y", 716, 27824, 29115);
            CallChecker.varInit(this.x, "x", 716, 27824, 29115);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 716, 27824, 29115);
            if ((this) == other) {
                return true;
            }
            if (other instanceof FieldVector3D) {
                @SuppressWarnings(value = "unchecked")
                final FieldVector3D<T> rhs = CallChecker.varInit(((FieldVector3D<T>) (other)), "rhs", 724, 28823, 28919);
                if (rhs.isNaN()) {
                    return this.isNaN();
                }
                return ((x.equals(rhs.x)) && (y.equals(rhs.y))) && (z.equals(rhs.z));
            }
            return false;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context134 = new MethodContext(int.class, 743, 29122, 29475);
        try {
            CallChecker.varInit(this, "this", 743, 29122, 29475);
            CallChecker.varInit(this.z, "z", 743, 29122, 29475);
            CallChecker.varInit(this.y, "y", 743, 29122, 29475);
            CallChecker.varInit(this.x, "x", 743, 29122, 29475);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 743, 29122, 29475);
            if (isNaN()) {
                return 409;
            }
            return 311 * (((107 * (x.hashCode())) + (83 * (y.hashCode()))) + (z.hashCode()));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Integer) (CallChecker.isToCatch(_bcornu_return_t, int.class)));
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    public T dotProduct(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context135 = new MethodContext(null, 760, 29482, 30060);
        try {
            CallChecker.varInit(this, "this", 760, 29482, 30060);
            CallChecker.varInit(v, "v", 760, 29482, 30060);
            CallChecker.varInit(this.z, "z", 760, 29482, 30060);
            CallChecker.varInit(this.y, "y", 760, 29482, 30060);
            CallChecker.varInit(this.x, "x", 760, 29482, 30060);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 760, 29482, 30060);
            return x.linearCombination(x, v.x, y, v.y, z, v.z);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public T dotProduct(final Vector3D v) {
        MethodContext _bcornu_methode_context136 = new MethodContext(null, 774, 30067, 30652);
        try {
            CallChecker.varInit(this, "this", 774, 30067, 30652);
            CallChecker.varInit(v, "v", 774, 30067, 30652);
            CallChecker.varInit(this.z, "z", 774, 30067, 30652);
            CallChecker.varInit(this.y, "y", 774, 30067, 30652);
            CallChecker.varInit(this.x, "x", 774, 30067, 30652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 774, 30067, 30652);
            return x.linearCombination(v.getX(), x, v.getY(), y, v.getZ(), z);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }

    public FieldVector3D<T> crossProduct(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context137 = new MethodContext(FieldVector3D.class, 782, 30659, 31143);
        try {
            CallChecker.varInit(this, "this", 782, 30659, 31143);
            CallChecker.varInit(v, "v", 782, 30659, 31143);
            CallChecker.varInit(this.z, "z", 782, 30659, 31143);
            CallChecker.varInit(this.y, "y", 782, 30659, 31143);
            CallChecker.varInit(this.x, "x", 782, 30659, 31143);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 782, 30659, 31143);
            return new FieldVector3D<T>(x.linearCombination(y, v.z, z.negate(), v.y), y.linearCombination(z, v.x, x.negate(), v.z), z.linearCombination(x, v.y, y.negate(), v.x));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    public FieldVector3D<T> crossProduct(final Vector3D v) {
        MethodContext _bcornu_methode_context138 = new MethodContext(FieldVector3D.class, 792, 31150, 31632);
        try {
            CallChecker.varInit(this, "this", 792, 31150, 31632);
            CallChecker.varInit(v, "v", 792, 31150, 31632);
            CallChecker.varInit(this.z, "z", 792, 31150, 31632);
            CallChecker.varInit(this.y, "y", 792, 31150, 31632);
            CallChecker.varInit(this.x, "x", 792, 31150, 31632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 792, 31150, 31632);
            return new FieldVector3D<T>(x.linearCombination(v.getZ(), y, (-(v.getY())), z), y.linearCombination(v.getX(), z, (-(v.getZ())), x), z.linearCombination(v.getY(), x, (-(v.getX())), y));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    public T distance1(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context139 = new MethodContext(null, 805, 31639, 32248);
        try {
            CallChecker.varInit(this, "this", 805, 31639, 32248);
            CallChecker.varInit(v, "v", 805, 31639, 32248);
            CallChecker.varInit(this.z, "z", 805, 31639, 32248);
            CallChecker.varInit(this.y, "y", 805, 31639, 32248);
            CallChecker.varInit(this.x, "x", 805, 31639, 32248);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 805, 31639, 32248);
            final T dx = CallChecker.varInit(v.x.subtract(x).abs(), "dx", 806, 32085, 32119);
            final T dy = CallChecker.varInit(v.y.subtract(y).abs(), "dy", 807, 32129, 32163);
            final T dz = CallChecker.varInit(v.z.subtract(z).abs(), "dz", 808, 32173, 32207);
            return dx.add(dy).add(dz);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public T distance1(final Vector3D v) {
        MethodContext _bcornu_methode_context140 = new MethodContext(null, 819, 32255, 32871);
        try {
            CallChecker.varInit(this, "this", 819, 32255, 32871);
            CallChecker.varInit(v, "v", 819, 32255, 32871);
            CallChecker.varInit(this.z, "z", 819, 32255, 32871);
            CallChecker.varInit(this.y, "y", 819, 32255, 32871);
            CallChecker.varInit(this.x, "x", 819, 32255, 32871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 819, 32255, 32871);
            final T dx = CallChecker.varInit(x.subtract(v.getX()).abs(), "dx", 820, 32693, 32732);
            final T dy = CallChecker.varInit(y.subtract(v.getY()).abs(), "dy", 821, 32742, 32781);
            final T dz = CallChecker.varInit(z.subtract(v.getZ()).abs(), "dz", 822, 32791, 32830);
            return dx.add(dy).add(dz);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    public T distance(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context141 = new MethodContext(null, 833, 32878, 33513);
        try {
            CallChecker.varInit(this, "this", 833, 32878, 33513);
            CallChecker.varInit(v, "v", 833, 32878, 33513);
            CallChecker.varInit(this.z, "z", 833, 32878, 33513);
            CallChecker.varInit(this.y, "y", 833, 32878, 33513);
            CallChecker.varInit(this.x, "x", 833, 32878, 33513);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 833, 32878, 33513);
            final T dx = CallChecker.varInit(v.x.subtract(x), "dx", 834, 33322, 33350);
            final T dy = CallChecker.varInit(v.y.subtract(y), "dy", 835, 33360, 33388);
            final T dz = CallChecker.varInit(v.z.subtract(z), "dz", 836, 33398, 33426);
            return dx.multiply(dx).add(dy.multiply(dy)).add(dz.multiply(dz)).sqrt();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    public T distance(final Vector3D v) {
        MethodContext _bcornu_methode_context142 = new MethodContext(null, 847, 33520, 34162);
        try {
            CallChecker.varInit(this, "this", 847, 33520, 34162);
            CallChecker.varInit(v, "v", 847, 33520, 34162);
            CallChecker.varInit(this.z, "z", 847, 33520, 34162);
            CallChecker.varInit(this.y, "y", 847, 33520, 34162);
            CallChecker.varInit(this.x, "x", 847, 33520, 34162);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 847, 33520, 34162);
            final T dx = CallChecker.varInit(x.subtract(v.getX()), "dx", 848, 33956, 33989);
            final T dy = CallChecker.varInit(y.subtract(v.getY()), "dy", 849, 33999, 34032);
            final T dz = CallChecker.varInit(z.subtract(v.getZ()), "dz", 850, 34042, 34075);
            return dx.multiply(dx).add(dy.multiply(dy)).add(dz.multiply(dz)).sqrt();
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    public T distanceInf(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context143 = new MethodContext(null, 861, 34169, 35104);
        try {
            CallChecker.varInit(this, "this", 861, 34169, 35104);
            CallChecker.varInit(v, "v", 861, 34169, 35104);
            CallChecker.varInit(this.z, "z", 861, 34169, 35104);
            CallChecker.varInit(this.y, "y", 861, 34169, 35104);
            CallChecker.varInit(this.x, "x", 861, 34169, 35104);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 861, 34169, 35104);
            final T dx = CallChecker.varInit(v.x.subtract(x).abs(), "dx", 862, 34631, 34665);
            final T dy = CallChecker.varInit(v.y.subtract(y).abs(), "dy", 863, 34675, 34709);
            final T dz = CallChecker.varInit(v.z.subtract(z).abs(), "dz", 864, 34719, 34753);
            if ((dx.getReal()) <= (dy.getReal())) {
                if ((dy.getReal()) <= (dz.getReal())) {
                    return dz;
                }else {
                    return dy;
                }
            }else {
                if ((dx.getReal()) <= (dz.getReal())) {
                    return dz;
                }else {
                    return dx;
                }
            }
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public T distanceInf(final Vector3D v) {
        MethodContext _bcornu_methode_context144 = new MethodContext(null, 887, 35111, 36053);
        try {
            CallChecker.varInit(this, "this", 887, 35111, 36053);
            CallChecker.varInit(v, "v", 887, 35111, 36053);
            CallChecker.varInit(this.z, "z", 887, 35111, 36053);
            CallChecker.varInit(this.y, "y", 887, 35111, 36053);
            CallChecker.varInit(this.x, "x", 887, 35111, 36053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 887, 35111, 36053);
            final T dx = CallChecker.varInit(x.subtract(v.getX()).abs(), "dx", 888, 35565, 35604);
            final T dy = CallChecker.varInit(y.subtract(v.getY()).abs(), "dy", 889, 35614, 35653);
            final T dz = CallChecker.varInit(z.subtract(v.getZ()).abs(), "dz", 890, 35663, 35702);
            if ((dx.getReal()) <= (dy.getReal())) {
                if ((dy.getReal()) <= (dz.getReal())) {
                    return dz;
                }else {
                    return dy;
                }
            }else {
                if ((dx.getReal()) <= (dz.getReal())) {
                    return dz;
                }else {
                    return dx;
                }
            }
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public T distanceSq(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context145 = new MethodContext(null, 913, 36060, 36648);
        try {
            CallChecker.varInit(this, "this", 913, 36060, 36648);
            CallChecker.varInit(v, "v", 913, 36060, 36648);
            CallChecker.varInit(this.z, "z", 913, 36060, 36648);
            CallChecker.varInit(this.y, "y", 913, 36060, 36648);
            CallChecker.varInit(this.x, "x", 913, 36060, 36648);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 913, 36060, 36648);
            final T dx = CallChecker.varInit(v.x.subtract(x), "dx", 914, 36464, 36492);
            final T dy = CallChecker.varInit(v.y.subtract(y), "dy", 915, 36502, 36530);
            final T dz = CallChecker.varInit(v.z.subtract(z), "dz", 916, 36540, 36568);
            return dx.multiply(dx).add(dy.multiply(dy)).add(dz.multiply(dz));
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    public T distanceSq(final Vector3D v) {
        MethodContext _bcornu_methode_context146 = new MethodContext(null, 927, 36655, 37250);
        try {
            CallChecker.varInit(this, "this", 927, 36655, 37250);
            CallChecker.varInit(v, "v", 927, 36655, 37250);
            CallChecker.varInit(this.z, "z", 927, 36655, 37250);
            CallChecker.varInit(this.y, "y", 927, 36655, 37250);
            CallChecker.varInit(this.x, "x", 927, 36655, 37250);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 927, 36655, 37250);
            final T dx = CallChecker.varInit(x.subtract(v.getX()), "dx", 928, 37051, 37084);
            final T dy = CallChecker.varInit(y.subtract(v.getY()), "dy", 929, 37094, 37127);
            final T dz = CallChecker.varInit(z.subtract(v.getZ()), "dz", 930, 37137, 37170);
            return dx.multiply(dx).add(dy.multiply(dy)).add(dz.multiply(dz));
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context147 = new MethodContext(null, 940, 37257, 37680);
        try {
            CallChecker.varInit(v2, "v2", 940, 37257, 37680);
            CallChecker.varInit(v1, "v1", 940, 37257, 37680);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 940, 37257, 37680);
            return v1.dotProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context148 = new MethodContext(null, 951, 37687, 38102);
        try {
            CallChecker.varInit(v2, "v2", 951, 37687, 38102);
            CallChecker.varInit(v1, "v1", 951, 37687, 38102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 951, 37687, 38102);
            return v1.dotProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context149 = new MethodContext(null, 962, 38109, 38524);
        try {
            CallChecker.varInit(v2, "v2", 962, 38109, 38524);
            CallChecker.varInit(v1, "v1", 962, 38109, 38524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 962, 38109, 38524);
            return v2.dotProduct(v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context150 = new MethodContext(FieldVector3D.class, 973, 38531, 39012);
        try {
            CallChecker.varInit(v2, "v2", 973, 38531, 39012);
            CallChecker.varInit(v1, "v1", 973, 38531, 39012);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 973, 38531, 39012);
            return v1.crossProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context151 = new MethodContext(FieldVector3D.class, 984, 39019, 39492);
        try {
            CallChecker.varInit(v2, "v2", 984, 39019, 39492);
            CallChecker.varInit(v1, "v1", 984, 39019, 39492);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 984, 39019, 39492);
            return v1.crossProduct(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context151.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context152 = new MethodContext(FieldVector3D.class, 995, 39499, 40222);
        try {
            CallChecker.varInit(v2, "v2", 995, 39499, 40222);
            CallChecker.varInit(v1, "v1", 995, 39499, 40222);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 995, 39499, 40222);
            return new FieldVector3D<T>(v2.x.linearCombination(v1.getY(), v2.z, (-(v1.getZ())), v2.y), v2.y.linearCombination(v1.getZ(), v2.x, (-(v1.getX())), v2.z), v2.z.linearCombination(v1.getX(), v2.y, (-(v1.getY())), v2.x));
        } catch (RuntimeException _bcornu_return_t) {
            return ((FieldVector3D<T>) (CallChecker.isToCatch(_bcornu_return_t, FieldVector3D.class)));
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context153 = new MethodContext(null, 1011, 40229, 40890);
        try {
            CallChecker.varInit(v2, "v2", 1011, 40229, 40890);
            CallChecker.varInit(v1, "v1", 1011, 40229, 40890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1011, 40229, 40890);
            return v1.distance1(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context154 = new MethodContext(null, 1025, 40897, 41550);
        try {
            CallChecker.varInit(v2, "v2", 1025, 40897, 41550);
            CallChecker.varInit(v1, "v1", 1025, 40897, 41550);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1025, 40897, 41550);
            return v1.distance1(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context155 = new MethodContext(null, 1039, 41557, 42210);
        try {
            CallChecker.varInit(v2, "v2", 1039, 41557, 42210);
            CallChecker.varInit(v1, "v1", 1039, 41557, 42210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1039, 41557, 42210);
            return v2.distance1(v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context156 = new MethodContext(null, 1053, 42217, 42874);
        try {
            CallChecker.varInit(v2, "v2", 1053, 42217, 42874);
            CallChecker.varInit(v1, "v1", 1053, 42217, 42874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1053, 42217, 42874);
            return v1.distance(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context157 = new MethodContext(null, 1067, 42881, 43530);
        try {
            CallChecker.varInit(v2, "v2", 1067, 42881, 43530);
            CallChecker.varInit(v1, "v1", 1067, 42881, 43530);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1067, 42881, 43530);
            return v1.distance(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context158 = new MethodContext(null, 1081, 43537, 44186);
        try {
            CallChecker.varInit(v2, "v2", 1081, 43537, 44186);
            CallChecker.varInit(v1, "v1", 1081, 43537, 44186);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1081, 43537, 44186);
            return v2.distance(v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context159 = new MethodContext(null, 1095, 44193, 44874);
        try {
            CallChecker.varInit(v2, "v2", 1095, 44193, 44874);
            CallChecker.varInit(v1, "v1", 1095, 44193, 44874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1095, 44193, 44874);
            return v1.distanceInf(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context160 = new MethodContext(null, 1109, 44881, 45554);
        try {
            CallChecker.varInit(v2, "v2", 1109, 44881, 45554);
            CallChecker.varInit(v1, "v1", 1109, 44881, 45554);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1109, 44881, 45554);
            return v1.distanceInf(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context161 = new MethodContext(null, 1123, 45561, 46234);
        try {
            CallChecker.varInit(v2, "v2", 1123, 45561, 46234);
            CallChecker.varInit(v1, "v1", 1123, 45561, 46234);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1123, 45561, 46234);
            return v2.distanceInf(v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context162 = new MethodContext(null, 1137, 46241, 46862);
        try {
            CallChecker.varInit(v2, "v2", 1137, 46241, 46862);
            CallChecker.varInit(v1, "v1", 1137, 46241, 46862);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1137, 46241, 46862);
            return v1.distanceSq(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context163 = new MethodContext(null, 1151, 46869, 47482);
        try {
            CallChecker.varInit(v2, "v2", 1151, 46869, 47482);
            CallChecker.varInit(v1, "v1", 1151, 46869, 47482);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1151, 46869, 47482);
            return v1.distanceSq(v2);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context164 = new MethodContext(null, 1165, 47489, 48102);
        try {
            CallChecker.varInit(v2, "v2", 1165, 47489, 48102);
            CallChecker.varInit(v1, "v1", 1165, 47489, 48102);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1165, 47489, 48102);
            return v2.distanceSq(v1);
        } catch (RuntimeException _bcornu_return_t) {
            return ((T) (CallChecker.isToCatch(_bcornu_return_t, null)));
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context165 = new MethodContext(String.class, 1174, 48109, 48334);
        try {
            CallChecker.varInit(this, "this", 1174, 48109, 48334);
            CallChecker.varInit(this.z, "z", 1174, 48109, 48334);
            CallChecker.varInit(this.y, "y", 1174, 48109, 48334);
            CallChecker.varInit(this.x, "x", 1174, 48109, 48334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1174, 48109, 48334);
            return Vector3DFormat.getInstance().format(toVector3D());
        } catch (RuntimeException _bcornu_return_t) {
            return ((String) (CallChecker.isToCatch(_bcornu_return_t, String.class)));
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context166 = new MethodContext(String.class, 1182, 48341, 48629);
        try {
            CallChecker.varInit(this, "this", 1182, 48341, 48629);
            CallChecker.varInit(format, "format", 1182, 48341, 48629);
            CallChecker.varInit(this.z, "z", 1182, 48341, 48629);
            CallChecker.varInit(this.y, "y", 1182, 48341, 48629);
            CallChecker.varInit(this.x, "x", 1182, 48341, 48629);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1182, 48341, 48629);
            return new Vector3DFormat(format).format(toVector3D());
        } catch (RuntimeException _bcornu_return_t) {
            return ((String) (CallChecker.isToCatch(_bcornu_return_t, String.class)));
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }
}

