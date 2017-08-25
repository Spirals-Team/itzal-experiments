package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.Field;
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
        ConstructorContext _bcornu_methode_context163 = new ConstructorContext(FieldVector3D.class, 60, 1840, 2172);
        try {
            this.x = x;
            CallChecker.varAssign(this.x, "this.x", 61, 2116, 2126);
            this.y = y;
            CallChecker.varAssign(this.y, "this.y", 62, 2136, 2146);
            this.z = z;
            CallChecker.varAssign(this.z, "this.z", 63, 2156, 2166);
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    public FieldVector3D(final T[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context164 = new ConstructorContext(FieldVector3D.class, 72, 2179, 2639);
        try {
            if (CallChecker.beforeDeref(v, null, 73, 2476, 2476)) {
                if ((CallChecker.isCalled(v, null, 73, 2476, 2476).length) != 3) {
                    if (CallChecker.beforeDeref(v, null, 74, 2542, 2542)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 74, 2542, 2542).length, 3);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            this.x = v[0];
            CallChecker.varAssign(this.x, "this.x", 76, 2574, 2587);
            this.y = v[1];
            CallChecker.varAssign(this.y, "this.y", 77, 2597, 2610);
            this.z = v[2];
            CallChecker.varAssign(this.z, "this.z", 78, 2620, 2633);
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    public FieldVector3D(final T alpha, final T delta) {
        ConstructorContext _bcornu_methode_context165 = new ConstructorContext(FieldVector3D.class, 89, 2646, 3205);
        try {
            T cosDelta = CallChecker.init(null);
            if (CallChecker.beforeDeref(delta, null, 90, 3060, 3064)) {
                cosDelta = delta.cos();
                CallChecker.varAssign(cosDelta, "cosDelta", 90, 3060, 3064);
            }
            this.x = alpha.cos().multiply(cosDelta);
            CallChecker.varAssign(this.x, "this.x", 91, 3081, 3120);
            this.y = alpha.sin().multiply(cosDelta);
            CallChecker.varAssign(this.y, "this.y", 92, 3130, 3169);
            this.z = delta.sin();
            CallChecker.varAssign(this.z, "this.z", 93, 3179, 3199);
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    public FieldVector3D(final T a, final FieldVector3D<T> u) {
        ConstructorContext _bcornu_methode_context166 = new ConstructorContext(FieldVector3D.class, 102, 3212, 3585);
        try {
            this.x = a.multiply(u.x);
            CallChecker.varAssign(this.x, "this.x", 103, 3487, 3511);
            this.y = a.multiply(u.y);
            CallChecker.varAssign(this.y, "this.y", 104, 3521, 3545);
            this.z = a.multiply(u.z);
            CallChecker.varAssign(this.z, "this.z", 105, 3555, 3579);
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }

    public FieldVector3D(final T a, final Vector3D u) {
        ConstructorContext _bcornu_methode_context167 = new ConstructorContext(FieldVector3D.class, 114, 3592, 3973);
        try {
            this.x = a.multiply(CallChecker.isCalled(u, Vector3D.class, 115, 3880, 3880).getX());
            CallChecker.varAssign(this.x, "this.x", 115, 3860, 3889);
            this.y = a.multiply(CallChecker.isCalled(u, Vector3D.class, 116, 3919, 3919).getY());
            CallChecker.varAssign(this.y, "this.y", 116, 3899, 3928);
            this.z = a.multiply(CallChecker.isCalled(u, Vector3D.class, 117, 3958, 3958).getZ());
            CallChecker.varAssign(this.z, "this.z", 117, 3938, 3967);
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    public FieldVector3D(final double a, final FieldVector3D<T> u) {
        ConstructorContext _bcornu_methode_context168 = new ConstructorContext(FieldVector3D.class, 126, 3980, 4359);
        try {
            this.x = u.x.multiply(a);
            CallChecker.varAssign(this.x, "this.x", 127, 4261, 4285);
            this.y = u.y.multiply(a);
            CallChecker.varAssign(this.y, "this.y", 128, 4295, 4319);
            this.z = u.z.multiply(a);
            CallChecker.varAssign(this.z, "this.z", 129, 4329, 4353);
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2) {
        ConstructorContext _bcornu_methode_context169 = new ConstructorContext(FieldVector3D.class, 140, 4366, 5082);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 142, 4826, 4848);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX());
            CallChecker.varAssign(this.x, "this.x", 143, 4858, 4924);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY());
            CallChecker.varAssign(this.y, "this.y", 144, 4934, 5000);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ());
            CallChecker.varAssign(this.z, "this.z", 145, 5010, 5076);
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2) {
        ConstructorContext _bcornu_methode_context170 = new ConstructorContext(FieldVector3D.class, 156, 5089, 5789);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 158, 5533, 5555);
            this.x = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 159, 5602, 5603).getX(), a1, CallChecker.isCalled(u2, Vector3D.class, 159, 5617, 5618).getX(), a2);
            CallChecker.varAssign(this.x, "this.x", 159, 5565, 5631);
            this.y = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 160, 5678, 5679).getY(), a1, CallChecker.isCalled(u2, Vector3D.class, 160, 5693, 5694).getY(), a2);
            CallChecker.varAssign(this.y, "this.y", 160, 5641, 5707);
            this.z = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 161, 5754, 5755).getZ(), a1, CallChecker.isCalled(u2, Vector3D.class, 161, 5769, 5770).getZ(), a2);
            CallChecker.varAssign(this.z, "this.z", 161, 5717, 5783);
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2) {
        ConstructorContext _bcornu_methode_context171 = new ConstructorContext(FieldVector3D.class, 172, 5796, 6529);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 174, 6266, 6295);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX());
            CallChecker.varAssign(this.x, "this.x", 175, 6305, 6371);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY());
            CallChecker.varAssign(this.y, "this.y", 176, 6381, 6447);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ());
            CallChecker.varAssign(this.z, "this.z", 177, 6457, 6523);
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2, final T a3, final FieldVector3D<T> u3) {
        ConstructorContext _bcornu_methode_context172 = new ConstructorContext(FieldVector3D.class, 190, 6536, 7455);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 193, 7154, 7176);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX());
            CallChecker.varAssign(this.x, "this.x", 194, 7186, 7267);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY());
            CallChecker.varAssign(this.y, "this.y", 195, 7277, 7358);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ());
            CallChecker.varAssign(this.z, "this.z", 196, 7368, 7449);
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2, final T a3, final Vector3D u3) {
        ConstructorContext _bcornu_methode_context173 = new ConstructorContext(FieldVector3D.class, 209, 7462, 8357);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 212, 8056, 8078);
            this.x = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 213, 8125, 8126).getX(), a1, CallChecker.isCalled(u2, Vector3D.class, 213, 8140, 8141).getX(), a2, CallChecker.isCalled(u3, Vector3D.class, 213, 8155, 8156).getX(), a3);
            CallChecker.varAssign(this.x, "this.x", 213, 8088, 8169);
            this.y = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 214, 8216, 8217).getY(), a1, CallChecker.isCalled(u2, Vector3D.class, 214, 8231, 8232).getY(), a2, CallChecker.isCalled(u3, Vector3D.class, 214, 8246, 8247).getY(), a3);
            CallChecker.varAssign(this.y, "this.y", 214, 8179, 8260);
            this.z = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 215, 8307, 8308).getZ(), a1, CallChecker.isCalled(u2, Vector3D.class, 215, 8322, 8323).getZ(), a2, CallChecker.isCalled(u3, Vector3D.class, 215, 8337, 8338).getZ(), a3);
            CallChecker.varAssign(this.z, "this.z", 215, 8270, 8351);
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2, final double a3, final FieldVector3D<T> u3) {
        ConstructorContext _bcornu_methode_context174 = new ConstructorContext(FieldVector3D.class, 228, 8364, 9305);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 231, 8997, 9026);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX());
            CallChecker.varAssign(this.x, "this.x", 232, 9036, 9117);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY());
            CallChecker.varAssign(this.y, "this.y", 233, 9127, 9208);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ());
            CallChecker.varAssign(this.z, "this.z", 234, 9218, 9299);
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final FieldVector3D<T> u1, final T a2, final FieldVector3D<T> u2, final T a3, final FieldVector3D<T> u3, final T a4, final FieldVector3D<T> u4) {
        ConstructorContext _bcornu_methode_context175 = new ConstructorContext(FieldVector3D.class, 249, 9312, 10433);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 253, 10087, 10109);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX(), a4, u4.getX());
            CallChecker.varAssign(this.x, "this.x", 254, 10119, 10215);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY(), a4, u4.getY());
            CallChecker.varAssign(this.y, "this.y", 255, 10225, 10321);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ(), a4, u4.getZ());
            CallChecker.varAssign(this.z, "this.z", 256, 10331, 10427);
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    public FieldVector3D(final T a1, final Vector3D u1, final T a2, final Vector3D u2, final T a3, final Vector3D u3, final T a4, final Vector3D u4) {
        ConstructorContext _bcornu_methode_context176 = new ConstructorContext(FieldVector3D.class, 271, 10440, 11529);
        try {
            final T prototype = CallChecker.varInit(a1, "prototype", 275, 11183, 11205);
            this.x = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 276, 11252, 11253).getX(), a1, CallChecker.isCalled(u2, Vector3D.class, 276, 11267, 11268).getX(), a2, CallChecker.isCalled(u3, Vector3D.class, 276, 11282, 11283).getX(), a3, CallChecker.isCalled(u4, Vector3D.class, 276, 11297, 11298).getX(), a4);
            CallChecker.varAssign(this.x, "this.x", 276, 11215, 11311);
            this.y = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 277, 11358, 11359).getY(), a1, CallChecker.isCalled(u2, Vector3D.class, 277, 11373, 11374).getY(), a2, CallChecker.isCalled(u3, Vector3D.class, 277, 11388, 11389).getY(), a3, CallChecker.isCalled(u4, Vector3D.class, 277, 11403, 11404).getY(), a4);
            CallChecker.varAssign(this.y, "this.y", 277, 11321, 11417);
            this.z = prototype.linearCombination(CallChecker.isCalled(u1, Vector3D.class, 278, 11464, 11465).getZ(), a1, CallChecker.isCalled(u2, Vector3D.class, 278, 11479, 11480).getZ(), a2, CallChecker.isCalled(u3, Vector3D.class, 278, 11494, 11495).getZ(), a3, CallChecker.isCalled(u4, Vector3D.class, 278, 11509, 11510).getZ(), a4);
            CallChecker.varAssign(this.z, "this.z", 278, 11427, 11523);
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    public FieldVector3D(final double a1, final FieldVector3D<T> u1, final double a2, final FieldVector3D<T> u2, final double a3, final FieldVector3D<T> u3, final double a4, final FieldVector3D<T> u4) {
        ConstructorContext _bcornu_methode_context177 = new ConstructorContext(FieldVector3D.class, 293, 11536, 12684);
        try {
            final T prototype = CallChecker.varInit(u1.getX(), "prototype", 297, 12331, 12360);
            this.x = prototype.linearCombination(a1, u1.getX(), a2, u2.getX(), a3, u3.getX(), a4, u4.getX());
            CallChecker.varAssign(this.x, "this.x", 298, 12370, 12466);
            this.y = prototype.linearCombination(a1, u1.getY(), a2, u2.getY(), a3, u3.getY(), a4, u4.getY());
            CallChecker.varAssign(this.y, "this.y", 299, 12476, 12572);
            this.z = prototype.linearCombination(a1, u1.getZ(), a2, u2.getZ(), a3, u3.getZ(), a4, u4.getZ());
            CallChecker.varAssign(this.z, "this.z", 300, 12582, 12678);
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    public T getX() {
        MethodContext _bcornu_methode_context575 = new MethodContext(null, 307, 12691, 12898);
        try {
            CallChecker.varInit(this, "this", 307, 12691, 12898);
            CallChecker.varInit(this.z, "z", 307, 12691, 12898);
            CallChecker.varInit(this.y, "y", 307, 12691, 12898);
            CallChecker.varInit(this.x, "x", 307, 12691, 12898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 307, 12691, 12898);
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context575.methodEnd();
        }
    }

    public T getY() {
        MethodContext _bcornu_methode_context576 = new MethodContext(null, 315, 12905, 13112);
        try {
            CallChecker.varInit(this, "this", 315, 12905, 13112);
            CallChecker.varInit(this.z, "z", 315, 12905, 13112);
            CallChecker.varInit(this.y, "y", 315, 12905, 13112);
            CallChecker.varInit(this.x, "x", 315, 12905, 13112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 315, 12905, 13112);
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context576.methodEnd();
        }
    }

    public T getZ() {
        MethodContext _bcornu_methode_context577 = new MethodContext(null, 323, 13119, 13322);
        try {
            CallChecker.varInit(this, "this", 323, 13119, 13322);
            CallChecker.varInit(this.z, "z", 323, 13119, 13322);
            CallChecker.varInit(this.y, "y", 323, 13119, 13322);
            CallChecker.varInit(this.x, "x", 323, 13119, 13322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 323, 13119, 13322);
            return z;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context577.methodEnd();
        }
    }

    public T[] toArray() {
        MethodContext _bcornu_methode_context578 = new MethodContext(null, 331, 13329, 13658);
        try {
            CallChecker.varInit(this, "this", 331, 13329, 13658);
            CallChecker.varInit(this.z, "z", 331, 13329, 13658);
            CallChecker.varInit(this.y, "y", 331, 13329, 13658);
            CallChecker.varInit(this.x, "x", 331, 13329, 13658);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 331, 13329, 13658);
            final T[] array = CallChecker.varInit(MathArrays.buildArray(x.getField(), 3), "array", 332, 13508, 13564);
            if (CallChecker.beforeDeref(array, null, 333, 13574, 13578)) {
                array[0] = x;
                CallChecker.varAssign(array[0], "array[0]", 333, 13574, 13586);
            }
            if (CallChecker.beforeDeref(array, null, 334, 13596, 13600)) {
                array[1] = y;
                CallChecker.varAssign(array[1], "array[1]", 334, 13596, 13608);
            }
            if (CallChecker.beforeDeref(array, null, 335, 13618, 13622)) {
                array[2] = z;
                CallChecker.varAssign(array[2], "array[2]", 335, 13618, 13630);
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context578.methodEnd();
        }
    }

    public Vector3D toVector3D() {
        MethodContext _bcornu_methode_context579 = new MethodContext(Vector3D.class, 342, 13665, 13867);
        try {
            CallChecker.varInit(this, "this", 342, 13665, 13867);
            CallChecker.varInit(this.z, "z", 342, 13665, 13867);
            CallChecker.varInit(this.y, "y", 342, 13665, 13867);
            CallChecker.varInit(this.x, "x", 342, 13665, 13867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 342, 13665, 13867);
            if (CallChecker.beforeDeref(x, null, 343, 13823, 13823)) {
                if (CallChecker.beforeDeref(y, null, 343, 13836, 13836)) {
                    if (CallChecker.beforeDeref(z, null, 343, 13849, 13849)) {
                        return new Vector3D(x.getReal(), y.getReal(), z.getReal());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context579.methodEnd();
        }
    }

    public T getNorm1() {
        MethodContext _bcornu_methode_context580 = new MethodContext(null, 349, 13874, 14058);
        try {
            CallChecker.varInit(this, "this", 349, 13874, 14058);
            CallChecker.varInit(this.z, "z", 349, 13874, 14058);
            CallChecker.varInit(this.y, "y", 349, 13874, 14058);
            CallChecker.varInit(this.x, "x", 349, 13874, 14058);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 349, 13874, 14058);
            if (CallChecker.beforeDeref(x, null, 350, 14019, 14019)) {
                if (CallChecker.beforeDeref(y, null, 350, 14031, 14031)) {
                    final RealFieldElement<T> npe_invocation_var50 = x.abs();
                    if (CallChecker.beforeDeref(npe_invocation_var50, RealFieldElement.class, 350, 14019, 14025)) {
                        if (CallChecker.beforeDeref(z, null, 350, 14044, 14044)) {
                            final RealFieldElement<T> npe_invocation_var51 = npe_invocation_var50.add(y.abs());
                            if (CallChecker.beforeDeref(npe_invocation_var51, RealFieldElement.class, 350, 14019, 14038)) {
                                return npe_invocation_var51.add(z.abs());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context580.methodEnd();
        }
    }

    public T getNorm() {
        MethodContext _bcornu_methode_context581 = new MethodContext(null, 356, 14065, 14359);
        try {
            CallChecker.varInit(this, "this", 356, 14065, 14359);
            CallChecker.varInit(this.z, "z", 356, 14065, 14359);
            CallChecker.varInit(this.y, "y", 356, 14065, 14359);
            CallChecker.varInit(this.x, "x", 356, 14065, 14359);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 356, 14065, 14359);
            if (CallChecker.beforeDeref(x, null, 358, 14295, 14295)) {
                if (CallChecker.beforeDeref(y, null, 358, 14313, 14313)) {
                    final RealFieldElement<T> npe_invocation_var52 = x.multiply(x);
                    if (CallChecker.beforeDeref(npe_invocation_var52, RealFieldElement.class, 358, 14295, 14307)) {
                        if (CallChecker.beforeDeref(z, null, 358, 14332, 14332)) {
                            final RealFieldElement<T> npe_invocation_var53 = npe_invocation_var52.add(y.multiply(y));
                            if (CallChecker.beforeDeref(npe_invocation_var53, RealFieldElement.class, 358, 14295, 14326)) {
                                final RealFieldElement<T> npe_invocation_var54 = npe_invocation_var53.add(z.multiply(z));
                                if (CallChecker.beforeDeref(npe_invocation_var54, RealFieldElement.class, 358, 14295, 14345)) {
                                    return npe_invocation_var54.sqrt();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context581.methodEnd();
        }
    }

    public T getNormSq() {
        MethodContext _bcornu_methode_context582 = new MethodContext(null, 364, 14366, 14669);
        try {
            CallChecker.varInit(this, "this", 364, 14366, 14669);
            CallChecker.varInit(this.z, "z", 364, 14366, 14669);
            CallChecker.varInit(this.y, "y", 364, 14366, 14669);
            CallChecker.varInit(this.x, "x", 364, 14366, 14669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 364, 14366, 14669);
            if (CallChecker.beforeDeref(x, null, 366, 14612, 14612)) {
                if (CallChecker.beforeDeref(y, null, 366, 14630, 14630)) {
                    final RealFieldElement<T> npe_invocation_var55 = x.multiply(x);
                    if (CallChecker.beforeDeref(npe_invocation_var55, RealFieldElement.class, 366, 14612, 14624)) {
                        if (CallChecker.beforeDeref(z, null, 366, 14649, 14649)) {
                            final RealFieldElement<T> npe_invocation_var56 = npe_invocation_var55.add(y.multiply(y));
                            if (CallChecker.beforeDeref(npe_invocation_var56, RealFieldElement.class, 366, 14612, 14643)) {
                                return npe_invocation_var56.add(z.multiply(z));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context582.methodEnd();
        }
    }

    public T getNormInf() {
        MethodContext _bcornu_methode_context583 = new MethodContext(null, 372, 14676, 15285);
        try {
            CallChecker.varInit(this, "this", 372, 14676, 15285);
            CallChecker.varInit(this.z, "z", 372, 14676, 15285);
            CallChecker.varInit(this.y, "y", 372, 14676, 15285);
            CallChecker.varInit(this.x, "x", 372, 14676, 15285);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 372, 14676, 15285);
            final T xAbs = CallChecker.varInit(x.abs(), "xAbs", 373, 14828, 14850);
            final T yAbs = CallChecker.varInit(y.abs(), "yAbs", 374, 14860, 14882);
            final T zAbs = CallChecker.varInit(z.abs(), "zAbs", 375, 14892, 14914);
            if (CallChecker.beforeDeref(xAbs, null, 376, 14928, 14931)) {
                if (CallChecker.beforeDeref(yAbs, null, 376, 14946, 14949)) {
                    if ((xAbs.getReal()) <= (yAbs.getReal())) {
                        if (CallChecker.beforeDeref(yAbs, null, 377, 14980, 14983)) {
                            if (CallChecker.beforeDeref(zAbs, null, 377, 14998, 15001)) {
                                if ((yAbs.getReal()) <= (zAbs.getReal())) {
                                    return zAbs;
                                }else {
                                    return yAbs;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(xAbs, null, 383, 15142, 15145)) {
                            if (CallChecker.beforeDeref(zAbs, null, 383, 15160, 15163)) {
                                if ((xAbs.getReal()) <= (zAbs.getReal())) {
                                    return zAbs;
                                }else {
                                    return xAbs;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context583.methodEnd();
        }
    }

    public T getAlpha() {
        MethodContext _bcornu_methode_context584 = new MethodContext(null, 395, 15292, 15527);
        try {
            CallChecker.varInit(this, "this", 395, 15292, 15527);
            CallChecker.varInit(this.z, "z", 395, 15292, 15527);
            CallChecker.varInit(this.y, "y", 395, 15292, 15527);
            CallChecker.varInit(this.x, "x", 395, 15292, 15527);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 395, 15292, 15527);
            if (CallChecker.beforeDeref(y, null, 396, 15511, 15511)) {
                return y.atan2(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context584.methodEnd();
        }
    }

    public T getDelta() {
        MethodContext _bcornu_methode_context585 = new MethodContext(null, 403, 15534, 15793);
        try {
            CallChecker.varInit(this, "this", 403, 15534, 15793);
            CallChecker.varInit(this.z, "z", 403, 15534, 15793);
            CallChecker.varInit(this.y, "y", 403, 15534, 15793);
            CallChecker.varInit(this.x, "x", 403, 15534, 15793);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 403, 15534, 15793);
            if (CallChecker.beforeDeref(z, null, 404, 15761, 15761)) {
                final RealFieldElement<T> npe_invocation_var57 = z.divide(getNorm());
                if (CallChecker.beforeDeref(npe_invocation_var57, RealFieldElement.class, 404, 15761, 15779)) {
                    return npe_invocation_var57.asin();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context585.methodEnd();
        }
    }

    public FieldVector3D<T> add(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context586 = new MethodContext(FieldVector3D.class, 411, 15800, 16037);
        try {
            CallChecker.varInit(this, "this", 411, 15800, 16037);
            CallChecker.varInit(v, "v", 411, 15800, 16037);
            CallChecker.varInit(this.z, "z", 411, 15800, 16037);
            CallChecker.varInit(this.y, "y", 411, 15800, 16037);
            CallChecker.varInit(this.x, "x", 411, 15800, 16037);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 411, 15800, 16037);
            if (CallChecker.beforeDeref(v, FieldVector3D.class, 412, 16002, 16002)) {
                if (CallChecker.beforeDeref(x, null, 412, 15996, 15996)) {
                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 412, 16014, 16014)) {
                        if (CallChecker.beforeDeref(y, null, 412, 16008, 16008)) {
                            if (CallChecker.beforeDeref(v, FieldVector3D.class, 412, 16026, 16026)) {
                                if (CallChecker.beforeDeref(z, null, 412, 16020, 16020)) {
                                    return new FieldVector3D<T>(x.add(v.x), y.add(v.y), z.add(v.z));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context586.methodEnd();
        }
    }

    public FieldVector3D<T> add(final Vector3D v) {
        MethodContext _bcornu_methode_context587 = new MethodContext(FieldVector3D.class, 419, 16044, 16288);
        try {
            CallChecker.varInit(this, "this", 419, 16044, 16288);
            CallChecker.varInit(v, "v", 419, 16044, 16288);
            CallChecker.varInit(this.z, "z", 419, 16044, 16288);
            CallChecker.varInit(this.y, "y", 419, 16044, 16288);
            CallChecker.varInit(this.x, "x", 419, 16044, 16288);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 419, 16044, 16288);
            if (CallChecker.beforeDeref(v, Vector3D.class, 420, 16238, 16238)) {
                if (CallChecker.beforeDeref(x, null, 420, 16232, 16232)) {
                    if (CallChecker.beforeDeref(v, Vector3D.class, 420, 16255, 16255)) {
                        if (CallChecker.beforeDeref(y, null, 420, 16249, 16249)) {
                            if (CallChecker.beforeDeref(v, Vector3D.class, 420, 16272, 16272)) {
                                if (CallChecker.beforeDeref(z, null, 420, 16266, 16266)) {
                                    return new FieldVector3D<T>(x.add(CallChecker.isCalled(v, Vector3D.class, 420, 16238, 16238).getX()), y.add(CallChecker.isCalled(v, Vector3D.class, 420, 16255, 16255).getY()), z.add(CallChecker.isCalled(v, Vector3D.class, 420, 16272, 16272).getZ()));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context587.methodEnd();
        }
    }

    public FieldVector3D<T> add(final T factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context588 = new MethodContext(FieldVector3D.class, 428, 16295, 16624);
        try {
            CallChecker.varInit(this, "this", 428, 16295, 16624);
            CallChecker.varInit(v, "v", 428, 16295, 16624);
            CallChecker.varInit(factor, "factor", 428, 16295, 16624);
            CallChecker.varInit(this.z, "z", 428, 16295, 16624);
            CallChecker.varInit(this.y, "y", 428, 16295, 16624);
            CallChecker.varInit(this.x, "x", 428, 16295, 16624);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 428, 16295, 16624);
            if (CallChecker.beforeDeref(x, null, 429, 16579, 16579)) {
                final Field<T> npe_invocation_var58 = x.getField();
                if (CallChecker.beforeDeref(npe_invocation_var58, Field.class, 429, 16579, 16590)) {
                    return new FieldVector3D<T>(npe_invocation_var58.getOne(), this, factor, v);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context588.methodEnd();
        }
    }

    public FieldVector3D<T> add(final T factor, final Vector3D v) {
        MethodContext _bcornu_methode_context589 = new MethodContext(FieldVector3D.class, 437, 16631, 17086);
        try {
            CallChecker.varInit(this, "this", 437, 16631, 17086);
            CallChecker.varInit(v, "v", 437, 16631, 17086);
            CallChecker.varInit(factor, "factor", 437, 16631, 17086);
            CallChecker.varInit(this.z, "z", 437, 16631, 17086);
            CallChecker.varInit(this.y, "y", 437, 16631, 17086);
            CallChecker.varInit(this.x, "x", 437, 16631, 17086);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 437, 16631, 17086);
            if (CallChecker.beforeDeref(v, Vector3D.class, 438, 16929, 16929)) {
                if (CallChecker.beforeDeref(factor, null, 438, 16913, 16918)) {
                    if (CallChecker.beforeDeref(x, null, 438, 16907, 16907)) {
                        if (CallChecker.beforeDeref(v, Vector3D.class, 439, 16999, 16999)) {
                            if (CallChecker.beforeDeref(factor, null, 439, 16983, 16988)) {
                                if (CallChecker.beforeDeref(y, null, 439, 16977, 16977)) {
                                    if (CallChecker.beforeDeref(v, Vector3D.class, 440, 17069, 17069)) {
                                        if (CallChecker.beforeDeref(factor, null, 440, 17053, 17058)) {
                                            if (CallChecker.beforeDeref(z, null, 440, 17047, 17047)) {
                                                return new FieldVector3D<T>(x.add(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 438, 16929, 16929).getX())), y.add(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 439, 16999, 16999).getY())), z.add(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 440, 17069, 17069).getZ())));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context589.methodEnd();
        }
    }

    public FieldVector3D<T> add(final double factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context590 = new MethodContext(FieldVector3D.class, 448, 17093, 17409);
        try {
            CallChecker.varInit(this, "this", 448, 17093, 17409);
            CallChecker.varInit(v, "v", 448, 17093, 17409);
            CallChecker.varInit(factor, "factor", 448, 17093, 17409);
            CallChecker.varInit(this.z, "z", 448, 17093, 17409);
            CallChecker.varInit(this.y, "y", 448, 17093, 17409);
            CallChecker.varInit(this.x, "x", 448, 17093, 17409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 448, 17093, 17409);
            return new FieldVector3D<T>(1.0, this, factor, v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context590.methodEnd();
        }
    }

    public FieldVector3D<T> add(final double factor, final Vector3D v) {
        MethodContext _bcornu_methode_context591 = new MethodContext(FieldVector3D.class, 457, 17416, 17852);
        try {
            CallChecker.varInit(this, "this", 457, 17416, 17852);
            CallChecker.varInit(v, "v", 457, 17416, 17852);
            CallChecker.varInit(factor, "factor", 457, 17416, 17852);
            CallChecker.varInit(this.z, "z", 457, 17416, 17852);
            CallChecker.varInit(this.y, "y", 457, 17416, 17852);
            CallChecker.varInit(this.x, "x", 457, 17416, 17852);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 457, 17416, 17852);
            if (CallChecker.beforeDeref(x, null, 458, 17697, 17697)) {
                if (CallChecker.beforeDeref(y, null, 459, 17759, 17759)) {
                    if (CallChecker.beforeDeref(z, null, 460, 17821, 17821)) {
                        return new FieldVector3D<T>(x.add((factor * (CallChecker.isCalled(v, Vector3D.class, 458, 17712, 17712).getX()))), y.add((factor * (CallChecker.isCalled(v, Vector3D.class, 459, 17774, 17774).getY()))), z.add((factor * (CallChecker.isCalled(v, Vector3D.class, 460, 17836, 17836).getZ()))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context591.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context592 = new MethodContext(FieldVector3D.class, 467, 17859, 18128);
        try {
            CallChecker.varInit(this, "this", 467, 17859, 18128);
            CallChecker.varInit(v, "v", 467, 17859, 18128);
            CallChecker.varInit(this.z, "z", 467, 17859, 18128);
            CallChecker.varInit(this.y, "y", 467, 17859, 18128);
            CallChecker.varInit(this.x, "x", 467, 17859, 18128);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 467, 17859, 18128);
            if (CallChecker.beforeDeref(v, FieldVector3D.class, 468, 18083, 18083)) {
                if (CallChecker.beforeDeref(x, null, 468, 18072, 18072)) {
                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 468, 18100, 18100)) {
                        if (CallChecker.beforeDeref(y, null, 468, 18089, 18089)) {
                            if (CallChecker.beforeDeref(v, FieldVector3D.class, 468, 18117, 18117)) {
                                if (CallChecker.beforeDeref(z, null, 468, 18106, 18106)) {
                                    return new FieldVector3D<T>(x.subtract(v.x), y.subtract(v.y), z.subtract(v.z));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context592.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final Vector3D v) {
        MethodContext _bcornu_methode_context593 = new MethodContext(FieldVector3D.class, 475, 18135, 18411);
        try {
            CallChecker.varInit(this, "this", 475, 18135, 18411);
            CallChecker.varInit(v, "v", 475, 18135, 18411);
            CallChecker.varInit(this.z, "z", 475, 18135, 18411);
            CallChecker.varInit(this.y, "y", 475, 18135, 18411);
            CallChecker.varInit(this.x, "x", 475, 18135, 18411);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 475, 18135, 18411);
            if (CallChecker.beforeDeref(v, Vector3D.class, 476, 18351, 18351)) {
                if (CallChecker.beforeDeref(x, null, 476, 18340, 18340)) {
                    if (CallChecker.beforeDeref(v, Vector3D.class, 476, 18373, 18373)) {
                        if (CallChecker.beforeDeref(y, null, 476, 18362, 18362)) {
                            if (CallChecker.beforeDeref(v, Vector3D.class, 476, 18395, 18395)) {
                                if (CallChecker.beforeDeref(z, null, 476, 18384, 18384)) {
                                    return new FieldVector3D<T>(x.subtract(CallChecker.isCalled(v, Vector3D.class, 476, 18351, 18351).getX()), y.subtract(CallChecker.isCalled(v, Vector3D.class, 476, 18373, 18373).getY()), z.subtract(CallChecker.isCalled(v, Vector3D.class, 476, 18395, 18395).getZ()));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context593.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final T factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context594 = new MethodContext(FieldVector3D.class, 484, 18418, 18778);
        try {
            CallChecker.varInit(this, "this", 484, 18418, 18778);
            CallChecker.varInit(v, "v", 484, 18418, 18778);
            CallChecker.varInit(factor, "factor", 484, 18418, 18778);
            CallChecker.varInit(this.z, "z", 484, 18418, 18778);
            CallChecker.varInit(this.y, "y", 484, 18418, 18778);
            CallChecker.varInit(this.x, "x", 484, 18418, 18778);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 484, 18418, 18778);
            if (CallChecker.beforeDeref(x, null, 485, 18724, 18724)) {
                final Field<T> npe_invocation_var59 = x.getField();
                if (CallChecker.beforeDeref(npe_invocation_var59, Field.class, 485, 18724, 18735)) {
                    if (CallChecker.beforeDeref(factor, null, 485, 18753, 18758)) {
                        return new FieldVector3D<T>(npe_invocation_var59.getOne(), this, factor.negate(), v);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context594.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final T factor, final Vector3D v) {
        MethodContext _bcornu_methode_context595 = new MethodContext(FieldVector3D.class, 493, 18785, 19277);
        try {
            CallChecker.varInit(this, "this", 493, 18785, 19277);
            CallChecker.varInit(v, "v", 493, 18785, 19277);
            CallChecker.varInit(factor, "factor", 493, 18785, 19277);
            CallChecker.varInit(this.z, "z", 493, 18785, 19277);
            CallChecker.varInit(this.y, "y", 493, 18785, 19277);
            CallChecker.varInit(this.x, "x", 493, 18785, 19277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 493, 18785, 19277);
            if (CallChecker.beforeDeref(v, Vector3D.class, 494, 19110, 19110)) {
                if (CallChecker.beforeDeref(factor, null, 494, 19094, 19099)) {
                    if (CallChecker.beforeDeref(x, null, 494, 19083, 19083)) {
                        if (CallChecker.beforeDeref(v, Vector3D.class, 495, 19185, 19185)) {
                            if (CallChecker.beforeDeref(factor, null, 495, 19169, 19174)) {
                                if (CallChecker.beforeDeref(y, null, 495, 19158, 19158)) {
                                    if (CallChecker.beforeDeref(v, Vector3D.class, 496, 19260, 19260)) {
                                        if (CallChecker.beforeDeref(factor, null, 496, 19244, 19249)) {
                                            if (CallChecker.beforeDeref(z, null, 496, 19233, 19233)) {
                                                return new FieldVector3D<T>(x.subtract(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 494, 19110, 19110).getX())), y.subtract(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 495, 19185, 19185).getY())), z.subtract(factor.multiply(CallChecker.isCalled(v, Vector3D.class, 496, 19260, 19260).getZ())));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context595.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final double factor, final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context596 = new MethodContext(FieldVector3D.class, 504, 19284, 19623);
        try {
            CallChecker.varInit(this, "this", 504, 19284, 19623);
            CallChecker.varInit(v, "v", 504, 19284, 19623);
            CallChecker.varInit(factor, "factor", 504, 19284, 19623);
            CallChecker.varInit(this.z, "z", 504, 19284, 19623);
            CallChecker.varInit(this.y, "y", 504, 19284, 19623);
            CallChecker.varInit(this.x, "x", 504, 19284, 19623);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 504, 19284, 19623);
            return new FieldVector3D<T>(1.0, this, (-factor), v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context596.methodEnd();
        }
    }

    public FieldVector3D<T> subtract(final double factor, final Vector3D v) {
        MethodContext _bcornu_methode_context597 = new MethodContext(FieldVector3D.class, 513, 19630, 20103);
        try {
            CallChecker.varInit(this, "this", 513, 19630, 20103);
            CallChecker.varInit(v, "v", 513, 19630, 20103);
            CallChecker.varInit(factor, "factor", 513, 19630, 20103);
            CallChecker.varInit(this.z, "z", 513, 19630, 20103);
            CallChecker.varInit(this.y, "y", 513, 19630, 20103);
            CallChecker.varInit(this.x, "x", 513, 19630, 20103);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 513, 19630, 20103);
            if (CallChecker.beforeDeref(x, null, 514, 19933, 19933)) {
                if (CallChecker.beforeDeref(y, null, 515, 20000, 20000)) {
                    if (CallChecker.beforeDeref(z, null, 516, 20067, 20067)) {
                        return new FieldVector3D<T>(x.subtract((factor * (CallChecker.isCalled(v, Vector3D.class, 514, 19953, 19953).getX()))), y.subtract((factor * (CallChecker.isCalled(v, Vector3D.class, 515, 20020, 20020).getY()))), z.subtract((factor * (CallChecker.isCalled(v, Vector3D.class, 516, 20087, 20087).getZ()))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context597.methodEnd();
        }
    }

    public FieldVector3D<T> normalize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context598 = new MethodContext(FieldVector3D.class, 523, 20110, 20572);
        try {
            CallChecker.varInit(this, "this", 523, 20110, 20572);
            CallChecker.varInit(this.z, "z", 523, 20110, 20572);
            CallChecker.varInit(this.y, "y", 523, 20110, 20572);
            CallChecker.varInit(this.x, "x", 523, 20110, 20572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 523, 20110, 20572);
            final T s = CallChecker.varInit(getNorm(), "s", 524, 20355, 20376);
            if (CallChecker.beforeDeref(s, null, 525, 20390, 20390)) {
                if ((s.getReal()) == 0) {
                    throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(s, null, 528, 20551, 20551)) {
                return scalarMultiply(s.reciprocal());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context598.methodEnd();
        }
    }

    public FieldVector3D<T> orthogonal() throws MathArithmeticException {
        MethodContext _bcornu_methode_context599 = new MethodContext(FieldVector3D.class, 546, 20579, 22348);
        try {
            CallChecker.varInit(this, "this", 546, 20579, 22348);
            CallChecker.varInit(this.z, "z", 546, 20579, 22348);
            CallChecker.varInit(this.y, "y", 546, 20579, 22348);
            CallChecker.varInit(this.x, "x", 546, 20579, 22348);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 546, 20579, 22348);
            final double threshold = CallChecker.varInit(((double) (0.6 * (getNorm().getReal()))), "threshold", 548, 21412, 21462);
            if (threshold == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            if (CallChecker.beforeDeref(x, null, 553, 21605, 21605)) {
                if ((FastMath.abs(x.getReal())) <= threshold) {
                    final T inverse = CallChecker.varInit(y.multiply(y).add(z.multiply(z)).sqrt().reciprocal(), "inverse", 554, 21646, 21717);
                    if (CallChecker.beforeDeref(inverse, null, 555, 21759, 21765)) {
                        final Field<T> npe_invocation_var60 = inverse.getField();
                        if (CallChecker.beforeDeref(npe_invocation_var60, Field.class, 555, 21759, 21776)) {
                            if (CallChecker.beforeDeref(inverse, null, 555, 21789, 21795)) {
                                if (CallChecker.beforeDeref(inverse, null, 555, 21810, 21816)) {
                                    final RealFieldElement<T> npe_invocation_var61 = inverse.multiply(y);
                                    if (CallChecker.beforeDeref(npe_invocation_var61, RealFieldElement.class, 555, 21810, 21828)) {
                                        return new FieldVector3D<T>(npe_invocation_var60.getZero(), inverse.multiply(z), npe_invocation_var61.negate());
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (CallChecker.beforeDeref(y, null, 556, 21873, 21873)) {
                        if ((FastMath.abs(y.getReal())) <= threshold) {
                            final T inverse = CallChecker.varInit(x.multiply(x).add(z.multiply(z)).sqrt().reciprocal(), "inverse", 557, 21914, 21985);
                            if (CallChecker.beforeDeref(inverse, null, 558, 22027, 22033)) {
                                final RealFieldElement<T> npe_invocation_var62 = inverse.multiply(z);
                                if (CallChecker.beforeDeref(npe_invocation_var62, RealFieldElement.class, 558, 22027, 22045)) {
                                    if (CallChecker.beforeDeref(inverse, null, 558, 22057, 22063)) {
                                        final Field<T> npe_invocation_var63 = inverse.getField();
                                        if (CallChecker.beforeDeref(npe_invocation_var63, Field.class, 558, 22057, 22074)) {
                                            if (CallChecker.beforeDeref(inverse, null, 558, 22087, 22093)) {
                                                return new FieldVector3D<T>(npe_invocation_var62.negate(), npe_invocation_var63.getZero(), inverse.multiply(x));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            final T inverse = CallChecker.varInit(x.multiply(x).add(y.multiply(y)).sqrt().reciprocal(), "inverse", 560, 22138, 22209);
                            if (CallChecker.beforeDeref(inverse, null, 561, 22251, 22257)) {
                                if (CallChecker.beforeDeref(inverse, null, 561, 22272, 22278)) {
                                    final RealFieldElement<T> npe_invocation_var64 = inverse.multiply(x);
                                    if (CallChecker.beforeDeref(npe_invocation_var64, RealFieldElement.class, 561, 22272, 22290)) {
                                        if (CallChecker.beforeDeref(inverse, null, 561, 22302, 22308)) {
                                            final Field<T> npe_invocation_var65 = inverse.getField();
                                            if (CallChecker.beforeDeref(npe_invocation_var65, Field.class, 561, 22302, 22319)) {
                                                return new FieldVector3D<T>(inverse.multiply(y), npe_invocation_var64.negate(), npe_invocation_var65.getZero());
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context599.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final FieldVector3D<T> v1, final FieldVector3D<T> v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context600 = new MethodContext(null, 578, 22355, 23949);
        try {
            CallChecker.varInit(v2, "v2", 578, 22355, 23949);
            CallChecker.varInit(v1, "v1", 578, 22355, 23949);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 578, 22355, 23949);
            final T normProduct = CallChecker.varInit(v1.getNorm().multiply(v2.getNorm()), "normProduct", 581, 23116, 23173);
            if (CallChecker.beforeDeref(normProduct, null, 582, 23187, 23197)) {
                if ((normProduct.getReal()) == 0) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(v1, v2), "dot", 586, 23311, 23343);
            final double threshold = CallChecker.varInit(((double) ((normProduct.getReal()) * 0.9999)), "threshold", 587, 23353, 23408);
            if (CallChecker.beforeDeref(dot, null, 588, 23423, 23425)) {
                if (CallChecker.beforeDeref(dot, null, 588, 23455, 23457)) {
                    if (((dot.getReal()) < (-threshold)) || ((dot.getReal()) > threshold)) {
                        FieldVector3D<T> v3 = CallChecker.varInit(FieldVector3D.crossProduct(v1, v2), "v3", 590, 23567, 23609);
                        if (CallChecker.beforeDeref(dot, null, 591, 23627, 23629)) {
                            if ((dot.getReal()) >= 0) {
                                if (CallChecker.beforeDeref(v3, FieldVector3D.class, 592, 23672, 23673)) {
                                    final RealFieldElement<T> npe_invocation_var66 = v3.getNorm();
                                    if (CallChecker.beforeDeref(npe_invocation_var66, RealFieldElement.class, 592, 23672, 23683)) {
                                        final RealFieldElement<T> npe_invocation_var67 = npe_invocation_var66.divide(normProduct);
                                        if (CallChecker.beforeDeref(npe_invocation_var67, RealFieldElement.class, 592, 23672, 23703)) {
                                            return npe_invocation_var67.asin();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(v3, FieldVector3D.class, 594, 23746, 23747)) {
                            final RealFieldElement<T> npe_invocation_var68 = v3.getNorm();
                            if (CallChecker.beforeDeref(npe_invocation_var68, RealFieldElement.class, 594, 23746, 23757)) {
                                final RealFieldElement<T> npe_invocation_var69 = npe_invocation_var68.divide(normProduct);
                                if (CallChecker.beforeDeref(npe_invocation_var69, RealFieldElement.class, 594, 23746, 23777)) {
                                    final RealFieldElement<T> npe_invocation_var70 = npe_invocation_var69.asin();
                                    if (CallChecker.beforeDeref(npe_invocation_var70, RealFieldElement.class, 594, 23746, 23784)) {
                                        final RealFieldElement<T> npe_invocation_var71 = npe_invocation_var70.subtract(FastMath.PI);
                                        if (CallChecker.beforeDeref(npe_invocation_var71, RealFieldElement.class, 594, 23746, 23806)) {
                                            return npe_invocation_var71.negate();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(dot, null, 598, 23912, 23914)) {
                final RealFieldElement<T> npe_invocation_var72 = dot.divide(normProduct);
                if (CallChecker.beforeDeref(npe_invocation_var72, RealFieldElement.class, 598, 23912, 23934)) {
                    return npe_invocation_var72.acos();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context600.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final FieldVector3D<T> v1, final Vector3D v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context601 = new MethodContext(null, 614, 23956, 25542);
        try {
            CallChecker.varInit(v2, "v2", 614, 23956, 25542);
            CallChecker.varInit(v1, "v1", 614, 23956, 25542);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 614, 23956, 25542);
            final T normProduct = CallChecker.varInit(v1.getNorm().multiply(CallChecker.isCalled(v2, Vector3D.class, 617, 24753, 24754).getNorm()), "normProduct", 617, 24709, 24766);
            if (CallChecker.beforeDeref(normProduct, null, 618, 24780, 24790)) {
                if ((normProduct.getReal()) == 0) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T dot = CallChecker.varInit(FieldVector3D.dotProduct(v1, v2), "dot", 622, 24904, 24936);
            final double threshold = CallChecker.varInit(((double) ((normProduct.getReal()) * 0.9999)), "threshold", 623, 24946, 25001);
            if (CallChecker.beforeDeref(dot, null, 624, 25016, 25018)) {
                if (CallChecker.beforeDeref(dot, null, 624, 25048, 25050)) {
                    if (((dot.getReal()) < (-threshold)) || ((dot.getReal()) > threshold)) {
                        FieldVector3D<T> v3 = CallChecker.varInit(FieldVector3D.crossProduct(v1, v2), "v3", 626, 25160, 25202);
                        if (CallChecker.beforeDeref(dot, null, 627, 25220, 25222)) {
                            if ((dot.getReal()) >= 0) {
                                if (CallChecker.beforeDeref(v3, FieldVector3D.class, 628, 25265, 25266)) {
                                    final RealFieldElement<T> npe_invocation_var73 = v3.getNorm();
                                    if (CallChecker.beforeDeref(npe_invocation_var73, RealFieldElement.class, 628, 25265, 25276)) {
                                        final RealFieldElement<T> npe_invocation_var74 = npe_invocation_var73.divide(normProduct);
                                        if (CallChecker.beforeDeref(npe_invocation_var74, RealFieldElement.class, 628, 25265, 25296)) {
                                            return npe_invocation_var74.asin();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(v3, FieldVector3D.class, 630, 25339, 25340)) {
                            final RealFieldElement<T> npe_invocation_var75 = v3.getNorm();
                            if (CallChecker.beforeDeref(npe_invocation_var75, RealFieldElement.class, 630, 25339, 25350)) {
                                final RealFieldElement<T> npe_invocation_var76 = npe_invocation_var75.divide(normProduct);
                                if (CallChecker.beforeDeref(npe_invocation_var76, RealFieldElement.class, 630, 25339, 25370)) {
                                    final RealFieldElement<T> npe_invocation_var77 = npe_invocation_var76.asin();
                                    if (CallChecker.beforeDeref(npe_invocation_var77, RealFieldElement.class, 630, 25339, 25377)) {
                                        final RealFieldElement<T> npe_invocation_var78 = npe_invocation_var77.subtract(FastMath.PI);
                                        if (CallChecker.beforeDeref(npe_invocation_var78, RealFieldElement.class, 630, 25339, 25399)) {
                                            return npe_invocation_var78.negate();
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(dot, null, 634, 25505, 25507)) {
                final RealFieldElement<T> npe_invocation_var79 = dot.divide(normProduct);
                if (CallChecker.beforeDeref(npe_invocation_var79, RealFieldElement.class, 634, 25505, 25527)) {
                    return npe_invocation_var79.acos();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context601.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T angle(final Vector3D v1, final FieldVector3D<T> v2) throws MathArithmeticException {
        MethodContext _bcornu_methode_context602 = new MethodContext(null, 650, 25549, 26327);
        try {
            CallChecker.varInit(v2, "v2", 650, 25549, 26327);
            CallChecker.varInit(v1, "v1", 650, 25549, 26327);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 650, 25549, 26327);
            return FieldVector3D.angle(v2, v1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context602.methodEnd();
        }
    }

    public FieldVector3D<T> negate() {
        MethodContext _bcornu_methode_context603 = new MethodContext(FieldVector3D.class, 658, 26334, 26558);
        try {
            CallChecker.varInit(this, "this", 658, 26334, 26558);
            CallChecker.varInit(this.z, "z", 658, 26334, 26558);
            CallChecker.varInit(this.y, "y", 658, 26334, 26558);
            CallChecker.varInit(this.x, "x", 658, 26334, 26558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 658, 26334, 26558);
            if (CallChecker.beforeDeref(x, null, 659, 26517, 26517)) {
                if (CallChecker.beforeDeref(y, null, 659, 26529, 26529)) {
                    if (CallChecker.beforeDeref(z, null, 659, 26541, 26541)) {
                        return new FieldVector3D<T>(x.negate(), y.negate(), z.negate());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context603.methodEnd();
        }
    }

    public FieldVector3D<T> scalarMultiply(final T a) {
        MethodContext _bcornu_methode_context604 = new MethodContext(FieldVector3D.class, 666, 26565, 26805);
        try {
            CallChecker.varInit(this, "this", 666, 26565, 26805);
            CallChecker.varInit(a, "a", 666, 26565, 26805);
            CallChecker.varInit(this.z, "z", 666, 26565, 26805);
            CallChecker.varInit(this.y, "y", 666, 26565, 26805);
            CallChecker.varInit(this.x, "x", 666, 26565, 26805);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 666, 26565, 26805);
            if (CallChecker.beforeDeref(x, null, 667, 26755, 26755)) {
                if (CallChecker.beforeDeref(y, null, 667, 26770, 26770)) {
                    if (CallChecker.beforeDeref(z, null, 667, 26785, 26785)) {
                        return new FieldVector3D<T>(x.multiply(a), y.multiply(a), z.multiply(a));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context604.methodEnd();
        }
    }

    public FieldVector3D<T> scalarMultiply(final double a) {
        MethodContext _bcornu_methode_context605 = new MethodContext(FieldVector3D.class, 674, 26812, 27057);
        try {
            CallChecker.varInit(this, "this", 674, 26812, 27057);
            CallChecker.varInit(a, "a", 674, 26812, 27057);
            CallChecker.varInit(this.z, "z", 674, 26812, 27057);
            CallChecker.varInit(this.y, "y", 674, 26812, 27057);
            CallChecker.varInit(this.x, "x", 674, 26812, 27057);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 674, 26812, 27057);
            if (CallChecker.beforeDeref(x, null, 675, 27007, 27007)) {
                if (CallChecker.beforeDeref(y, null, 675, 27022, 27022)) {
                    if (CallChecker.beforeDeref(z, null, 675, 27037, 27037)) {
                        return new FieldVector3D<T>(x.multiply(a), y.multiply(a), z.multiply(a));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context605.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context606 = new MethodContext(boolean.class, 682, 27064, 27364);
        try {
            CallChecker.varInit(this, "this", 682, 27064, 27364);
            CallChecker.varInit(this.z, "z", 682, 27064, 27364);
            CallChecker.varInit(this.y, "y", 682, 27064, 27364);
            CallChecker.varInit(this.x, "x", 682, 27064, 27364);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 682, 27064, 27364);
            if (CallChecker.beforeDeref(x, null, 683, 27288, 27288)) {
                if (CallChecker.beforeDeref(y, null, 683, 27317, 27317)) {
                    if (CallChecker.beforeDeref(z, null, 683, 27346, 27346)) {
                        return ((Double.isNaN(x.getReal())) || (Double.isNaN(y.getReal()))) || (Double.isNaN(z.getReal()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context606.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context607 = new MethodContext(boolean.class, 692, 27371, 27763);
        try {
            CallChecker.varInit(this, "this", 692, 27371, 27763);
            CallChecker.varInit(this.z, "z", 692, 27371, 27763);
            CallChecker.varInit(this.y, "y", 692, 27371, 27763);
            CallChecker.varInit(this.x, "x", 692, 27371, 27763);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 692, 27371, 27763);
            if (CallChecker.beforeDeref(x, null, 693, 27676, 27676)) {
                if (CallChecker.beforeDeref(y, null, 693, 27710, 27710)) {
                    if (CallChecker.beforeDeref(z, null, 693, 27744, 27744)) {
                        return (!(isNaN())) && (((Double.isInfinite(x.getReal())) || (Double.isInfinite(y.getReal()))) || (Double.isInfinite(z.getReal())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context607.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context608 = new MethodContext(boolean.class, 716, 27770, 29061);
        try {
            CallChecker.varInit(this, "this", 716, 27770, 29061);
            CallChecker.varInit(other, "other", 716, 27770, 29061);
            CallChecker.varInit(this.z, "z", 716, 27770, 29061);
            CallChecker.varInit(this.y, "y", 716, 27770, 29061);
            CallChecker.varInit(this.x, "x", 716, 27770, 29061);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 716, 27770, 29061);
            if ((this) == other) {
                return true;
            }
            if (other instanceof FieldVector3D) {
                @SuppressWarnings(value = "unchecked")
                final FieldVector3D<T> rhs = CallChecker.varInit(((FieldVector3D<T>) (other)), "rhs", 724, 28769, 28865);
                if (CallChecker.beforeDeref(rhs, FieldVector3D.class, 725, 28883, 28885)) {
                    if (CallChecker.isCalled(rhs, FieldVector3D.class, 725, 28883, 28885).isNaN()) {
                        return this.isNaN();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(rhs, FieldVector3D.class, 729, 28978, 28980)) {
                    if (CallChecker.beforeDeref(rhs, FieldVector3D.class, 729, 28997, 28999)) {
                        if (CallChecker.beforeDeref(rhs, FieldVector3D.class, 729, 29016, 29018)) {
                            return ((x.equals(rhs.x)) && (y.equals(rhs.y))) && (z.equals(rhs.z));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context608.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context609 = new MethodContext(int.class, 743, 29068, 29421);
        try {
            CallChecker.varInit(this, "this", 743, 29068, 29421);
            CallChecker.varInit(this.z, "z", 743, 29068, 29421);
            CallChecker.varInit(this.y, "y", 743, 29068, 29421);
            CallChecker.varInit(this.x, "x", 743, 29068, 29421);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 743, 29068, 29421);
            if (isNaN()) {
                return 409;
            }
            return 311 * (((107 * (x.hashCode())) + (83 * (y.hashCode()))) + (z.hashCode()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context609.methodEnd();
        }
    }

    public T dotProduct(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context610 = new MethodContext(null, 760, 29428, 30006);
        try {
            CallChecker.varInit(this, "this", 760, 29428, 30006);
            CallChecker.varInit(v, "v", 760, 29428, 30006);
            CallChecker.varInit(this.z, "z", 760, 29428, 30006);
            CallChecker.varInit(this.y, "y", 760, 29428, 30006);
            CallChecker.varInit(this.x, "x", 760, 29428, 30006);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 760, 29428, 30006);
            if (CallChecker.beforeDeref(v, FieldVector3D.class, 761, 29980, 29980)) {
                if (CallChecker.beforeDeref(v, FieldVector3D.class, 761, 29988, 29988)) {
                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 761, 29996, 29996)) {
                        if (CallChecker.beforeDeref(x, null, 761, 29957, 29957)) {
                            return x.linearCombination(x, v.x, y, v.y, z, v.z);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context610.methodEnd();
        }
    }

    public T dotProduct(final Vector3D v) {
        MethodContext _bcornu_methode_context611 = new MethodContext(null, 774, 30013, 30598);
        try {
            CallChecker.varInit(this, "this", 774, 30013, 30598);
            CallChecker.varInit(v, "v", 774, 30013, 30598);
            CallChecker.varInit(this.z, "z", 774, 30013, 30598);
            CallChecker.varInit(this.y, "y", 774, 30013, 30598);
            CallChecker.varInit(this.x, "x", 774, 30013, 30598);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 774, 30013, 30598);
            if (CallChecker.beforeDeref(v, Vector3D.class, 775, 30554, 30554)) {
                if (CallChecker.beforeDeref(v, Vector3D.class, 775, 30567, 30567)) {
                    if (CallChecker.beforeDeref(v, Vector3D.class, 775, 30580, 30580)) {
                        if (CallChecker.beforeDeref(x, null, 775, 30534, 30534)) {
                            return x.linearCombination(CallChecker.isCalled(v, Vector3D.class, 775, 30554, 30554).getX(), x, CallChecker.isCalled(v, Vector3D.class, 775, 30567, 30567).getY(), y, CallChecker.isCalled(v, Vector3D.class, 775, 30580, 30580).getZ(), z);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context611.methodEnd();
        }
    }

    public FieldVector3D<T> crossProduct(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context612 = new MethodContext(FieldVector3D.class, 782, 30605, 31089);
        try {
            CallChecker.varInit(this, "this", 782, 30605, 31089);
            CallChecker.varInit(v, "v", 782, 30605, 31089);
            CallChecker.varInit(this.z, "z", 782, 30605, 31089);
            CallChecker.varInit(this.y, "y", 782, 30605, 31089);
            CallChecker.varInit(this.x, "x", 782, 30605, 31089);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 782, 30605, 31089);
            if (CallChecker.beforeDeref(v, FieldVector3D.class, 783, 30897, 30897)) {
                if (CallChecker.beforeDeref(z, null, 783, 30902, 30902)) {
                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 783, 30914, 30914)) {
                        if (CallChecker.beforeDeref(x, null, 783, 30874, 30874)) {
                            if (CallChecker.beforeDeref(v, FieldVector3D.class, 784, 30979, 30979)) {
                                if (CallChecker.beforeDeref(x, null, 784, 30984, 30984)) {
                                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 784, 30996, 30996)) {
                                        if (CallChecker.beforeDeref(y, null, 784, 30956, 30956)) {
                                            if (CallChecker.beforeDeref(v, FieldVector3D.class, 785, 31061, 31061)) {
                                                if (CallChecker.beforeDeref(y, null, 785, 31066, 31066)) {
                                                    if (CallChecker.beforeDeref(v, FieldVector3D.class, 785, 31078, 31078)) {
                                                        if (CallChecker.beforeDeref(z, null, 785, 31038, 31038)) {
                                                            return new FieldVector3D<T>(x.linearCombination(y, v.z, z.negate(), v.y), y.linearCombination(z, v.x, x.negate(), v.z), z.linearCombination(x, v.y, y.negate(), v.x));
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context612.methodEnd();
        }
    }

    public FieldVector3D<T> crossProduct(final Vector3D v) {
        MethodContext _bcornu_methode_context613 = new MethodContext(FieldVector3D.class, 792, 31096, 31578);
        try {
            CallChecker.varInit(this, "this", 792, 31096, 31578);
            CallChecker.varInit(v, "v", 792, 31096, 31578);
            CallChecker.varInit(this.z, "z", 792, 31096, 31578);
            CallChecker.varInit(this.y, "y", 792, 31096, 31578);
            CallChecker.varInit(this.x, "x", 792, 31096, 31578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 792, 31096, 31578);
            if (CallChecker.beforeDeref(v, Vector3D.class, 793, 31377, 31377)) {
                if (CallChecker.beforeDeref(v, Vector3D.class, 793, 31391, 31391)) {
                    if (CallChecker.beforeDeref(x, null, 793, 31357, 31357)) {
                        if (CallChecker.beforeDeref(v, Vector3D.class, 794, 31461, 31461)) {
                            if (CallChecker.beforeDeref(v, Vector3D.class, 794, 31475, 31475)) {
                                if (CallChecker.beforeDeref(y, null, 794, 31441, 31441)) {
                                    if (CallChecker.beforeDeref(v, Vector3D.class, 795, 31545, 31545)) {
                                        if (CallChecker.beforeDeref(v, Vector3D.class, 795, 31559, 31559)) {
                                            if (CallChecker.beforeDeref(z, null, 795, 31525, 31525)) {
                                                return new FieldVector3D<T>(x.linearCombination(CallChecker.isCalled(v, Vector3D.class, 793, 31377, 31377).getZ(), y, (-(CallChecker.isCalled(v, Vector3D.class, 793, 31391, 31391).getY())), z), y.linearCombination(CallChecker.isCalled(v, Vector3D.class, 794, 31461, 31461).getX(), z, (-(CallChecker.isCalled(v, Vector3D.class, 794, 31475, 31475).getZ())), x), z.linearCombination(CallChecker.isCalled(v, Vector3D.class, 795, 31545, 31545).getY(), x, (-(CallChecker.isCalled(v, Vector3D.class, 795, 31559, 31559).getX())), y));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context613.methodEnd();
        }
    }

    public T distance1(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context614 = new MethodContext(null, 805, 31585, 32194);
        try {
            CallChecker.varInit(this, "this", 805, 31585, 32194);
            CallChecker.varInit(v, "v", 805, 31585, 32194);
            CallChecker.varInit(this.z, "z", 805, 31585, 32194);
            CallChecker.varInit(this.y, "y", 805, 31585, 32194);
            CallChecker.varInit(this.x, "x", 805, 31585, 32194);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 805, 31585, 32194);
            final T dx = CallChecker.varInit(v.x.subtract(x).abs(), "dx", 806, 32031, 32065);
            final T dy = CallChecker.varInit(v.y.subtract(y).abs(), "dy", 807, 32075, 32109);
            final T dz = CallChecker.varInit(v.z.subtract(z).abs(), "dz", 808, 32119, 32153);
            if (CallChecker.beforeDeref(dx, null, 809, 32170, 32171)) {
                final RealFieldElement<T> npe_invocation_var80 = dx.add(dy);
                if (CallChecker.beforeDeref(npe_invocation_var80, RealFieldElement.class, 809, 32170, 32179)) {
                    return npe_invocation_var80.add(dz);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context614.methodEnd();
        }
    }

    public T distance1(final Vector3D v) {
        MethodContext _bcornu_methode_context615 = new MethodContext(null, 819, 32201, 32817);
        try {
            CallChecker.varInit(this, "this", 819, 32201, 32817);
            CallChecker.varInit(v, "v", 819, 32201, 32817);
            CallChecker.varInit(this.z, "z", 819, 32201, 32817);
            CallChecker.varInit(this.y, "y", 819, 32201, 32817);
            CallChecker.varInit(this.x, "x", 819, 32201, 32817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 819, 32201, 32817);
            final T dx = CallChecker.varInit(x.subtract(CallChecker.isCalled(v, Vector3D.class, 820, 32663, 32663).getX()).abs(), "dx", 820, 32639, 32678);
            final T dy = CallChecker.varInit(y.subtract(CallChecker.isCalled(v, Vector3D.class, 821, 32712, 32712).getY()).abs(), "dy", 821, 32688, 32727);
            final T dz = CallChecker.varInit(z.subtract(CallChecker.isCalled(v, Vector3D.class, 822, 32761, 32761).getZ()).abs(), "dz", 822, 32737, 32776);
            if (CallChecker.beforeDeref(dx, null, 823, 32793, 32794)) {
                final RealFieldElement<T> npe_invocation_var81 = dx.add(dy);
                if (CallChecker.beforeDeref(npe_invocation_var81, RealFieldElement.class, 823, 32793, 32802)) {
                    return npe_invocation_var81.add(dz);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context615.methodEnd();
        }
    }

    public T distance(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context616 = new MethodContext(null, 833, 32824, 33459);
        try {
            CallChecker.varInit(this, "this", 833, 32824, 33459);
            CallChecker.varInit(v, "v", 833, 32824, 33459);
            CallChecker.varInit(this.z, "z", 833, 32824, 33459);
            CallChecker.varInit(this.y, "y", 833, 32824, 33459);
            CallChecker.varInit(this.x, "x", 833, 32824, 33459);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 833, 32824, 33459);
            final T dx = CallChecker.varInit(v.x.subtract(x), "dx", 834, 33268, 33296);
            final T dy = CallChecker.varInit(v.y.subtract(y), "dy", 835, 33306, 33334);
            final T dz = CallChecker.varInit(v.z.subtract(z), "dz", 836, 33344, 33372);
            if (CallChecker.beforeDeref(dx, null, 837, 33389, 33390)) {
                if (CallChecker.beforeDeref(dy, null, 837, 33409, 33410)) {
                    final RealFieldElement<T> npe_invocation_var82 = dx.multiply(dx);
                    if (CallChecker.beforeDeref(npe_invocation_var82, RealFieldElement.class, 837, 33389, 33403)) {
                        if (CallChecker.beforeDeref(dz, null, 837, 33430, 33431)) {
                            final RealFieldElement<T> npe_invocation_var83 = npe_invocation_var82.add(dy.multiply(dy));
                            if (CallChecker.beforeDeref(npe_invocation_var83, RealFieldElement.class, 837, 33389, 33424)) {
                                final RealFieldElement<T> npe_invocation_var84 = npe_invocation_var83.add(dz.multiply(dz));
                                if (CallChecker.beforeDeref(npe_invocation_var84, RealFieldElement.class, 837, 33389, 33445)) {
                                    return npe_invocation_var84.sqrt();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context616.methodEnd();
        }
    }

    public T distance(final Vector3D v) {
        MethodContext _bcornu_methode_context617 = new MethodContext(null, 847, 33466, 34108);
        try {
            CallChecker.varInit(this, "this", 847, 33466, 34108);
            CallChecker.varInit(v, "v", 847, 33466, 34108);
            CallChecker.varInit(this.z, "z", 847, 33466, 34108);
            CallChecker.varInit(this.y, "y", 847, 33466, 34108);
            CallChecker.varInit(this.x, "x", 847, 33466, 34108);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 847, 33466, 34108);
            final T dx = CallChecker.varInit(x.subtract(CallChecker.isCalled(v, Vector3D.class, 848, 33926, 33926).getX()), "dx", 848, 33902, 33935);
            final T dy = CallChecker.varInit(y.subtract(CallChecker.isCalled(v, Vector3D.class, 849, 33969, 33969).getY()), "dy", 849, 33945, 33978);
            final T dz = CallChecker.varInit(z.subtract(CallChecker.isCalled(v, Vector3D.class, 850, 34012, 34012).getZ()), "dz", 850, 33988, 34021);
            if (CallChecker.beforeDeref(dx, null, 851, 34038, 34039)) {
                if (CallChecker.beforeDeref(dy, null, 851, 34058, 34059)) {
                    final RealFieldElement<T> npe_invocation_var85 = dx.multiply(dx);
                    if (CallChecker.beforeDeref(npe_invocation_var85, RealFieldElement.class, 851, 34038, 34052)) {
                        if (CallChecker.beforeDeref(dz, null, 851, 34079, 34080)) {
                            final RealFieldElement<T> npe_invocation_var86 = npe_invocation_var85.add(dy.multiply(dy));
                            if (CallChecker.beforeDeref(npe_invocation_var86, RealFieldElement.class, 851, 34038, 34073)) {
                                final RealFieldElement<T> npe_invocation_var87 = npe_invocation_var86.add(dz.multiply(dz));
                                if (CallChecker.beforeDeref(npe_invocation_var87, RealFieldElement.class, 851, 34038, 34094)) {
                                    return npe_invocation_var87.sqrt();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context617.methodEnd();
        }
    }

    public T distanceInf(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context618 = new MethodContext(null, 861, 34115, 35050);
        try {
            CallChecker.varInit(this, "this", 861, 34115, 35050);
            CallChecker.varInit(v, "v", 861, 34115, 35050);
            CallChecker.varInit(this.z, "z", 861, 34115, 35050);
            CallChecker.varInit(this.y, "y", 861, 34115, 35050);
            CallChecker.varInit(this.x, "x", 861, 34115, 35050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 861, 34115, 35050);
            final T dx = CallChecker.varInit(v.x.subtract(x).abs(), "dx", 862, 34577, 34611);
            final T dy = CallChecker.varInit(v.y.subtract(y).abs(), "dy", 863, 34621, 34655);
            final T dz = CallChecker.varInit(v.z.subtract(z).abs(), "dz", 864, 34665, 34699);
            if (CallChecker.beforeDeref(dx, null, 865, 34713, 34714)) {
                if (CallChecker.beforeDeref(dy, null, 865, 34729, 34730)) {
                    if ((dx.getReal()) <= (dy.getReal())) {
                        if (CallChecker.beforeDeref(dy, null, 866, 34761, 34762)) {
                            if (CallChecker.beforeDeref(dz, null, 866, 34777, 34778)) {
                                if ((dy.getReal()) <= (dz.getReal())) {
                                    return dz;
                                }else {
                                    return dy;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(dx, null, 872, 34915, 34916)) {
                            if (CallChecker.beforeDeref(dz, null, 872, 34931, 34932)) {
                                if ((dx.getReal()) <= (dz.getReal())) {
                                    return dz;
                                }else {
                                    return dx;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context618.methodEnd();
        }
    }

    public T distanceInf(final Vector3D v) {
        MethodContext _bcornu_methode_context619 = new MethodContext(null, 887, 35057, 35999);
        try {
            CallChecker.varInit(this, "this", 887, 35057, 35999);
            CallChecker.varInit(v, "v", 887, 35057, 35999);
            CallChecker.varInit(this.z, "z", 887, 35057, 35999);
            CallChecker.varInit(this.y, "y", 887, 35057, 35999);
            CallChecker.varInit(this.x, "x", 887, 35057, 35999);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 887, 35057, 35999);
            final T dx = CallChecker.varInit(x.subtract(CallChecker.isCalled(v, Vector3D.class, 888, 35535, 35535).getX()).abs(), "dx", 888, 35511, 35550);
            final T dy = CallChecker.varInit(y.subtract(CallChecker.isCalled(v, Vector3D.class, 889, 35584, 35584).getY()).abs(), "dy", 889, 35560, 35599);
            final T dz = CallChecker.varInit(z.subtract(CallChecker.isCalled(v, Vector3D.class, 890, 35633, 35633).getZ()).abs(), "dz", 890, 35609, 35648);
            if (CallChecker.beforeDeref(dx, null, 891, 35662, 35663)) {
                if (CallChecker.beforeDeref(dy, null, 891, 35678, 35679)) {
                    if ((dx.getReal()) <= (dy.getReal())) {
                        if (CallChecker.beforeDeref(dy, null, 892, 35710, 35711)) {
                            if (CallChecker.beforeDeref(dz, null, 892, 35726, 35727)) {
                                if ((dy.getReal()) <= (dz.getReal())) {
                                    return dz;
                                }else {
                                    return dy;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        if (CallChecker.beforeDeref(dx, null, 898, 35864, 35865)) {
                            if (CallChecker.beforeDeref(dz, null, 898, 35880, 35881)) {
                                if ((dx.getReal()) <= (dz.getReal())) {
                                    return dz;
                                }else {
                                    return dx;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context619.methodEnd();
        }
    }

    public T distanceSq(final FieldVector3D<T> v) {
        MethodContext _bcornu_methode_context620 = new MethodContext(null, 913, 36006, 36594);
        try {
            CallChecker.varInit(this, "this", 913, 36006, 36594);
            CallChecker.varInit(v, "v", 913, 36006, 36594);
            CallChecker.varInit(this.z, "z", 913, 36006, 36594);
            CallChecker.varInit(this.y, "y", 913, 36006, 36594);
            CallChecker.varInit(this.x, "x", 913, 36006, 36594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 913, 36006, 36594);
            final T dx = CallChecker.varInit(v.x.subtract(x), "dx", 914, 36410, 36438);
            final T dy = CallChecker.varInit(v.y.subtract(y), "dy", 915, 36448, 36476);
            final T dz = CallChecker.varInit(v.z.subtract(z), "dz", 916, 36486, 36514);
            if (CallChecker.beforeDeref(dx, null, 917, 36531, 36532)) {
                if (CallChecker.beforeDeref(dy, null, 917, 36551, 36552)) {
                    final RealFieldElement<T> npe_invocation_var88 = dx.multiply(dx);
                    if (CallChecker.beforeDeref(npe_invocation_var88, RealFieldElement.class, 917, 36531, 36545)) {
                        if (CallChecker.beforeDeref(dz, null, 917, 36572, 36573)) {
                            final RealFieldElement<T> npe_invocation_var89 = npe_invocation_var88.add(dy.multiply(dy));
                            if (CallChecker.beforeDeref(npe_invocation_var89, RealFieldElement.class, 917, 36531, 36566)) {
                                return npe_invocation_var89.add(dz.multiply(dz));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context620.methodEnd();
        }
    }

    public T distanceSq(final Vector3D v) {
        MethodContext _bcornu_methode_context621 = new MethodContext(null, 927, 36601, 37196);
        try {
            CallChecker.varInit(this, "this", 927, 36601, 37196);
            CallChecker.varInit(v, "v", 927, 36601, 37196);
            CallChecker.varInit(this.z, "z", 927, 36601, 37196);
            CallChecker.varInit(this.y, "y", 927, 36601, 37196);
            CallChecker.varInit(this.x, "x", 927, 36601, 37196);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 927, 36601, 37196);
            final T dx = CallChecker.varInit(x.subtract(CallChecker.isCalled(v, Vector3D.class, 928, 37021, 37021).getX()), "dx", 928, 36997, 37030);
            final T dy = CallChecker.varInit(y.subtract(CallChecker.isCalled(v, Vector3D.class, 929, 37064, 37064).getY()), "dy", 929, 37040, 37073);
            final T dz = CallChecker.varInit(z.subtract(CallChecker.isCalled(v, Vector3D.class, 930, 37107, 37107).getZ()), "dz", 930, 37083, 37116);
            if (CallChecker.beforeDeref(dx, null, 931, 37133, 37134)) {
                if (CallChecker.beforeDeref(dy, null, 931, 37153, 37154)) {
                    final RealFieldElement<T> npe_invocation_var90 = dx.multiply(dx);
                    if (CallChecker.beforeDeref(npe_invocation_var90, RealFieldElement.class, 931, 37133, 37147)) {
                        if (CallChecker.beforeDeref(dz, null, 931, 37174, 37175)) {
                            final RealFieldElement<T> npe_invocation_var91 = npe_invocation_var90.add(dy.multiply(dy));
                            if (CallChecker.beforeDeref(npe_invocation_var91, RealFieldElement.class, 931, 37133, 37168)) {
                                return npe_invocation_var91.add(dz.multiply(dz));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context621.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context622 = new MethodContext(null, 940, 37203, 37626);
        try {
            CallChecker.varInit(v2, "v2", 940, 37203, 37626);
            CallChecker.varInit(v1, "v1", 940, 37203, 37626);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 940, 37203, 37626);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 942, 37603, 37604)) {
                return v1.dotProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context622.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context623 = new MethodContext(null, 951, 37633, 38048);
        try {
            CallChecker.varInit(v2, "v2", 951, 37633, 38048);
            CallChecker.varInit(v1, "v1", 951, 37633, 38048);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 951, 37633, 38048);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 953, 38025, 38026)) {
                return v1.dotProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context623.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T dotProduct(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context624 = new MethodContext(null, 962, 38055, 38470);
        try {
            CallChecker.varInit(v2, "v2", 962, 38055, 38470);
            CallChecker.varInit(v1, "v1", 962, 38055, 38470);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 962, 38055, 38470);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 964, 38447, 38448)) {
                return v2.dotProduct(v1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context624.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context625 = new MethodContext(FieldVector3D.class, 973, 38477, 38958);
        try {
            CallChecker.varInit(v2, "v2", 973, 38477, 38958);
            CallChecker.varInit(v1, "v1", 973, 38477, 38958);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 973, 38477, 38958);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 975, 38933, 38934)) {
                return CallChecker.isCalled(v1, FieldVector3D.class, 975, 38933, 38934).crossProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context625.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context626 = new MethodContext(FieldVector3D.class, 984, 38965, 39438);
        try {
            CallChecker.varInit(v2, "v2", 984, 38965, 39438);
            CallChecker.varInit(v1, "v1", 984, 38965, 39438);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 984, 38965, 39438);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 986, 39413, 39414)) {
                return CallChecker.isCalled(v1, FieldVector3D.class, 986, 39413, 39414).crossProduct(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context626.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context627 = new MethodContext(FieldVector3D.class, 995, 39445, 40168);
        try {
            CallChecker.varInit(v2, "v2", 995, 39445, 40168);
            CallChecker.varInit(v1, "v1", 995, 39445, 40168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 995, 39445, 40168);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 997, 39914, 39915)) {
                if (CallChecker.beforeDeref(v1, Vector3D.class, 997, 39937, 39938)) {
                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 997, 39948, 39949)) {
                        if (CallChecker.beforeDeref(v1, Vector3D.class, 997, 39955, 39956)) {
                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 997, 39966, 39967)) {
                                if (CallChecker.beforeDeref(v2.x, null, 997, 39914, 39917)) {
                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 998, 40009, 40010)) {
                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 998, 40032, 40033)) {
                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 998, 40043, 40044)) {
                                                if (CallChecker.beforeDeref(v1, Vector3D.class, 998, 40050, 40051)) {
                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 998, 40061, 40062)) {
                                                        if (CallChecker.beforeDeref(v2.y, null, 998, 40009, 40012)) {
                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 999, 40104, 40105)) {
                                                                if (CallChecker.beforeDeref(v1, Vector3D.class, 999, 40127, 40128)) {
                                                                    if (CallChecker.beforeDeref(v2, FieldVector3D.class, 999, 40138, 40139)) {
                                                                        if (CallChecker.beforeDeref(v1, Vector3D.class, 999, 40145, 40146)) {
                                                                            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 999, 40156, 40157)) {
                                                                                if (CallChecker.beforeDeref(v2.z, null, 999, 40104, 40107)) {
                                                                                    return new FieldVector3D<T>(v2.x.linearCombination(CallChecker.isCalled(v1, Vector3D.class, 997, 39937, 39938).getY(), v2.z, (-(CallChecker.isCalled(v1, Vector3D.class, 997, 39955, 39956).getZ())), v2.y), v2.y.linearCombination(CallChecker.isCalled(v1, Vector3D.class, 998, 40032, 40033).getZ(), v2.x, (-(CallChecker.isCalled(v1, Vector3D.class, 998, 40050, 40051).getX())), v2.z), v2.z.linearCombination(CallChecker.isCalled(v1, Vector3D.class, 999, 40127, 40128).getX(), v2.y, (-(CallChecker.isCalled(v1, Vector3D.class, 999, 40145, 40146).getY())), v2.x));
                                                                                }else
                                                                                    throw new AbnormalExecutionError();
                                                                                
                                                                            }else
                                                                                throw new AbnormalExecutionError();
                                                                            
                                                                        }else
                                                                            throw new AbnormalExecutionError();
                                                                        
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector3D<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context627.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context628 = new MethodContext(null, 1011, 40175, 40836);
        try {
            CallChecker.varInit(v2, "v2", 1011, 40175, 40836);
            CallChecker.varInit(v1, "v1", 1011, 40175, 40836);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1011, 40175, 40836);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1013, 40814, 40815)) {
                return v1.distance1(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context628.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context629 = new MethodContext(null, 1025, 40843, 41496);
        try {
            CallChecker.varInit(v2, "v2", 1025, 40843, 41496);
            CallChecker.varInit(v1, "v1", 1025, 40843, 41496);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1025, 40843, 41496);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1027, 41474, 41475)) {
                return v1.distance1(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context629.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance1(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context630 = new MethodContext(null, 1039, 41503, 42156);
        try {
            CallChecker.varInit(v2, "v2", 1039, 41503, 42156);
            CallChecker.varInit(v1, "v1", 1039, 41503, 42156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1039, 41503, 42156);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 1041, 42134, 42135)) {
                return v2.distance1(v1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context630.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context631 = new MethodContext(null, 1053, 42163, 42820);
        try {
            CallChecker.varInit(v2, "v2", 1053, 42163, 42820);
            CallChecker.varInit(v1, "v1", 1053, 42163, 42820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1053, 42163, 42820);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1055, 42799, 42800)) {
                return v1.distance(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context631.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context632 = new MethodContext(null, 1067, 42827, 43476);
        try {
            CallChecker.varInit(v2, "v2", 1067, 42827, 43476);
            CallChecker.varInit(v1, "v1", 1067, 42827, 43476);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1067, 42827, 43476);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1069, 43455, 43456)) {
                return v1.distance(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context632.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distance(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context633 = new MethodContext(null, 1081, 43483, 44132);
        try {
            CallChecker.varInit(v2, "v2", 1081, 43483, 44132);
            CallChecker.varInit(v1, "v1", 1081, 43483, 44132);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1081, 43483, 44132);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 1083, 44111, 44112)) {
                return v2.distance(v1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context633.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context634 = new MethodContext(null, 1095, 44139, 44820);
        try {
            CallChecker.varInit(v2, "v2", 1095, 44139, 44820);
            CallChecker.varInit(v1, "v1", 1095, 44139, 44820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1095, 44139, 44820);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1097, 44796, 44797)) {
                return v1.distanceInf(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context634.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context635 = new MethodContext(null, 1109, 44827, 45500);
        try {
            CallChecker.varInit(v2, "v2", 1109, 44827, 45500);
            CallChecker.varInit(v1, "v1", 1109, 44827, 45500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1109, 44827, 45500);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1111, 45476, 45477)) {
                return v1.distanceInf(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context635.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceInf(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context636 = new MethodContext(null, 1123, 45507, 46180);
        try {
            CallChecker.varInit(v2, "v2", 1123, 45507, 46180);
            CallChecker.varInit(v1, "v1", 1123, 45507, 46180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1123, 45507, 46180);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 1125, 46156, 46157)) {
                return v2.distanceInf(v1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context636.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final FieldVector3D<T> v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context637 = new MethodContext(null, 1137, 46187, 46808);
        try {
            CallChecker.varInit(v2, "v2", 1137, 46187, 46808);
            CallChecker.varInit(v1, "v1", 1137, 46187, 46808);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1137, 46187, 46808);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1139, 46785, 46786)) {
                return v1.distanceSq(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context637.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final FieldVector3D<T> v1, final Vector3D v2) {
        MethodContext _bcornu_methode_context638 = new MethodContext(null, 1151, 46815, 47428);
        try {
            CallChecker.varInit(v2, "v2", 1151, 46815, 47428);
            CallChecker.varInit(v1, "v1", 1151, 46815, 47428);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1151, 46815, 47428);
            if (CallChecker.beforeDeref(v1, FieldVector3D.class, 1153, 47405, 47406)) {
                return v1.distanceSq(v2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context638.methodEnd();
        }
    }

    public static <T extends RealFieldElement<T>> T distanceSq(final Vector3D v1, final FieldVector3D<T> v2) {
        MethodContext _bcornu_methode_context639 = new MethodContext(null, 1165, 47435, 48048);
        try {
            CallChecker.varInit(v2, "v2", 1165, 47435, 48048);
            CallChecker.varInit(v1, "v1", 1165, 47435, 48048);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1165, 47435, 48048);
            if (CallChecker.beforeDeref(v2, FieldVector3D.class, 1167, 48025, 48026)) {
                return v2.distanceSq(v1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context639.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context640 = new MethodContext(String.class, 1174, 48055, 48280);
        try {
            CallChecker.varInit(this, "this", 1174, 48055, 48280);
            CallChecker.varInit(this.z, "z", 1174, 48055, 48280);
            CallChecker.varInit(this.y, "y", 1174, 48055, 48280);
            CallChecker.varInit(this.x, "x", 1174, 48055, 48280);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1174, 48055, 48280);
            final Vector3DFormat npe_invocation_var92 = Vector3DFormat.getInstance();
            if (CallChecker.beforeDeref(npe_invocation_var92, Vector3DFormat.class, 1175, 48225, 48252)) {
                return CallChecker.isCalled(npe_invocation_var92, Vector3DFormat.class, 1175, 48225, 48252).format(toVector3D());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context640.methodEnd();
        }
    }

    public String toString(final NumberFormat format) {
        MethodContext _bcornu_methode_context641 = new MethodContext(String.class, 1182, 48287, 48575);
        try {
            CallChecker.varInit(this, "this", 1182, 48287, 48575);
            CallChecker.varInit(format, "format", 1182, 48287, 48575);
            CallChecker.varInit(this.z, "z", 1182, 48287, 48575);
            CallChecker.varInit(this.y, "y", 1182, 48287, 48575);
            CallChecker.varInit(this.x, "x", 1182, 48287, 48575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.FieldVector3D.serialVersionUID", 1182, 48287, 48575);
            if (CallChecker.beforeDeref(new Vector3DFormat(format), Vector3DFormat.class, 1183, 48522, 48547)) {
                return CallChecker.isCalled(new Vector3DFormat(format), Vector3DFormat.class, 1183, 48522, 48547).format(toVector3D());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context641.methodEnd();
        }
    }
}

