package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public final class Quaternion implements Serializable {
    public static final Quaternion IDENTITY = new Quaternion(1, 0, 0, 0);

    public static final Quaternion ZERO = new Quaternion(0, 0, 0, 0);

    public static final Quaternion I = new Quaternion(0, 1, 0, 0);

    public static final Quaternion J = new Quaternion(0, 0, 1, 0);

    public static final Quaternion K = new Quaternion(0, 0, 0, 1);

    private static final long serialVersionUID = 20092012L;

    private final double q0;

    private final double q1;

    private final double q2;

    private final double q3;

    public Quaternion(final double a, final double b, final double c, final double d) {
        ConstructorContext _bcornu_methode_context1064 = new ConstructorContext(Quaternion.class, 69, 2372, 2836);
        try {
            this.q0 = a;
            CallChecker.varAssign(this.q0, "this.q0", 73, 2756, 2767);
            this.q1 = b;
            CallChecker.varAssign(this.q1, "this.q1", 74, 2777, 2788);
            this.q2 = c;
            CallChecker.varAssign(this.q2, "this.q2", 75, 2798, 2809);
            this.q3 = d;
            CallChecker.varAssign(this.q3, "this.q3", 76, 2819, 2830);
        } finally {
            _bcornu_methode_context1064.methodEnd();
        }
    }

    public Quaternion(final double scalar, final double[] v) throws DimensionMismatchException {
        ConstructorContext _bcornu_methode_context1065 = new ConstructorContext(Quaternion.class, 87, 2843, 3446);
        try {
            if (CallChecker.beforeDeref(v, double[].class, 90, 3254, 3254)) {
                if ((CallChecker.isCalled(v, double[].class, 90, 3254, 3254).length) != 3) {
                    if (CallChecker.beforeDeref(v, double[].class, 91, 3320, 3320)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 91, 3320, 3320).length, 3);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            this.q0 = scalar;
            CallChecker.varAssign(this.q0, "this.q0", 93, 3352, 3368);
            this.q1 = CallChecker.isCalled(v, double[].class, 94, 3388, 3388)[0];
            CallChecker.varAssign(this.q1, "this.q1", 94, 3378, 3392);
            this.q2 = CallChecker.isCalled(v, double[].class, 95, 3412, 3412)[1];
            CallChecker.varAssign(this.q2, "this.q2", 95, 3402, 3416);
            this.q3 = CallChecker.isCalled(v, double[].class, 96, 3436, 3436)[2];
            CallChecker.varAssign(this.q3, "this.q3", 96, 3426, 3440);
        } finally {
            _bcornu_methode_context1065.methodEnd();
        }
    }

    public Quaternion(final double[] v) {
        this(0, v);
        ConstructorContext _bcornu_methode_context1066 = new ConstructorContext(Quaternion.class, 105, 3453, 3702);
        try {
        } finally {
            _bcornu_methode_context1066.methodEnd();
        }
    }

    public Quaternion getConjugate() {
        MethodContext _bcornu_methode_context4729 = new MethodContext(Quaternion.class, 114, 3709, 3918);
        try {
            CallChecker.varInit(this, "this", 114, 3709, 3918);
            CallChecker.varInit(this.q3, "q3", 114, 3709, 3918);
            CallChecker.varInit(this.q2, "q2", 114, 3709, 3918);
            CallChecker.varInit(this.q1, "q1", 114, 3709, 3918);
            CallChecker.varInit(this.q0, "q0", 114, 3709, 3918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 114, 3709, 3918);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 114, 3709, 3918);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 114, 3709, 3918);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 114, 3709, 3918);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 114, 3709, 3918);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 114, 3709, 3918);
            return new Quaternion(q0, (-(q1)), (-(q2)), (-(q3)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4729.methodEnd();
        }
    }

    public static Quaternion multiply(final Quaternion q1, final Quaternion q2) {
        MethodContext _bcornu_methode_context4730 = new MethodContext(Quaternion.class, 125, 3925, 5005);
        try {
            CallChecker.varInit(q2, "q2", 125, 3925, 5005);
            CallChecker.varInit(q1, "q1", 125, 3925, 5005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 125, 3925, 5005);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 125, 3925, 5005);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 125, 3925, 5005);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 125, 3925, 5005);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 125, 3925, 5005);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 125, 3925, 5005);
            final double q1a = CallChecker.varInit(((double) (CallChecker.isCalled(q1, Quaternion.class, 127, 4296, 4297).getQ0())), "q1a", 127, 4230, 4306);
            final double q1b = CallChecker.varInit(((double) (CallChecker.isCalled(q1, Quaternion.class, 128, 4335, 4336).getQ1())), "q1b", 128, 4316, 4345);
            final double q1c = CallChecker.varInit(((double) (CallChecker.isCalled(q1, Quaternion.class, 129, 4374, 4375).getQ2())), "q1c", 129, 4355, 4384);
            final double q1d = CallChecker.varInit(((double) (CallChecker.isCalled(q1, Quaternion.class, 130, 4413, 4414).getQ3())), "q1d", 130, 4394, 4423);
            final double q2a = CallChecker.varInit(((double) (CallChecker.isCalled(q2, Quaternion.class, 133, 4501, 4502).getQ0())), "q2a", 133, 4434, 4511);
            final double q2b = CallChecker.varInit(((double) (CallChecker.isCalled(q2, Quaternion.class, 134, 4540, 4541).getQ1())), "q2b", 134, 4521, 4550);
            final double q2c = CallChecker.varInit(((double) (CallChecker.isCalled(q2, Quaternion.class, 135, 4579, 4580).getQ2())), "q2c", 135, 4560, 4589);
            final double q2d = CallChecker.varInit(((double) (CallChecker.isCalled(q2, Quaternion.class, 136, 4618, 4619).getQ3())), "q2d", 136, 4599, 4628);
            final double w = CallChecker.varInit(((double) ((((q1a * q2a) - (q1b * q2b)) - (q1c * q2c)) - (q1d * q2d))), "w", 139, 4639, 4739);
            final double x = CallChecker.varInit(((double) ((((q1a * q2b) + (q1b * q2a)) + (q1c * q2d)) - (q1d * q2c))), "x", 140, 4749, 4811);
            final double y = CallChecker.varInit(((double) ((((q1a * q2c) - (q1b * q2d)) + (q1c * q2a)) + (q1d * q2b))), "y", 141, 4821, 4883);
            final double z = CallChecker.varInit(((double) ((((q1a * q2d) + (q1b * q2c)) - (q1c * q2b)) + (q1d * q2a))), "z", 142, 4893, 4955);
            return new Quaternion(w, x, y, z);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4730.methodEnd();
        }
    }

    public Quaternion multiply(final Quaternion q) {
        MethodContext _bcornu_methode_context4731 = new MethodContext(Quaternion.class, 153, 5012, 5294);
        try {
            CallChecker.varInit(this, "this", 153, 5012, 5294);
            CallChecker.varInit(q, "q", 153, 5012, 5294);
            CallChecker.varInit(this.q3, "q3", 153, 5012, 5294);
            CallChecker.varInit(this.q2, "q2", 153, 5012, 5294);
            CallChecker.varInit(this.q1, "q1", 153, 5012, 5294);
            CallChecker.varInit(this.q0, "q0", 153, 5012, 5294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 153, 5012, 5294);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 153, 5012, 5294);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 153, 5012, 5294);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 153, 5012, 5294);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 153, 5012, 5294);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 153, 5012, 5294);
            return Quaternion.multiply(this, q);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4731.methodEnd();
        }
    }

    public static Quaternion add(final Quaternion q1, final Quaternion q2) {
        MethodContext _bcornu_methode_context4732 = new MethodContext(Quaternion.class, 164, 5301, 5810);
        try {
            CallChecker.varInit(q2, "q2", 164, 5301, 5810);
            CallChecker.varInit(q1, "q1", 164, 5301, 5810);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 164, 5301, 5810);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 164, 5301, 5810);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 164, 5301, 5810);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 164, 5301, 5810);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 164, 5301, 5810);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 164, 5301, 5810);
            return new Quaternion(((CallChecker.isCalled(q1, Quaternion.class, 166, 5615, 5616).getQ0()) + (CallChecker.isCalled(q2, Quaternion.class, 166, 5628, 5629).getQ0())), ((CallChecker.isCalled(q1, Quaternion.class, 167, 5670, 5671).getQ1()) + (CallChecker.isCalled(q2, Quaternion.class, 167, 5683, 5684).getQ1())), ((CallChecker.isCalled(q1, Quaternion.class, 168, 5725, 5726).getQ2()) + (CallChecker.isCalled(q2, Quaternion.class, 168, 5738, 5739).getQ2())), ((CallChecker.isCalled(q1, Quaternion.class, 169, 5780, 5781).getQ3()) + (CallChecker.isCalled(q2, Quaternion.class, 169, 5793, 5794).getQ3())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4732.methodEnd();
        }
    }

    public Quaternion add(final Quaternion q) {
        MethodContext _bcornu_methode_context4733 = new MethodContext(Quaternion.class, 178, 5817, 6063);
        try {
            CallChecker.varInit(this, "this", 178, 5817, 6063);
            CallChecker.varInit(q, "q", 178, 5817, 6063);
            CallChecker.varInit(this.q3, "q3", 178, 5817, 6063);
            CallChecker.varInit(this.q2, "q2", 178, 5817, 6063);
            CallChecker.varInit(this.q1, "q1", 178, 5817, 6063);
            CallChecker.varInit(this.q0, "q0", 178, 5817, 6063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 178, 5817, 6063);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 178, 5817, 6063);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 178, 5817, 6063);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 178, 5817, 6063);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 178, 5817, 6063);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 178, 5817, 6063);
            return Quaternion.add(this, q);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4733.methodEnd();
        }
    }

    public static Quaternion subtract(final Quaternion q1, final Quaternion q2) {
        MethodContext _bcornu_methode_context4734 = new MethodContext(Quaternion.class, 189, 6070, 6604);
        try {
            CallChecker.varInit(q2, "q2", 189, 6070, 6604);
            CallChecker.varInit(q1, "q1", 189, 6070, 6604);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 189, 6070, 6604);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 189, 6070, 6604);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 189, 6070, 6604);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 189, 6070, 6604);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 189, 6070, 6604);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 189, 6070, 6604);
            return new Quaternion(((CallChecker.isCalled(q1, Quaternion.class, 191, 6409, 6410).getQ0()) - (CallChecker.isCalled(q2, Quaternion.class, 191, 6422, 6423).getQ0())), ((CallChecker.isCalled(q1, Quaternion.class, 192, 6464, 6465).getQ1()) - (CallChecker.isCalled(q2, Quaternion.class, 192, 6477, 6478).getQ1())), ((CallChecker.isCalled(q1, Quaternion.class, 193, 6519, 6520).getQ2()) - (CallChecker.isCalled(q2, Quaternion.class, 193, 6532, 6533).getQ2())), ((CallChecker.isCalled(q1, Quaternion.class, 194, 6574, 6575).getQ3()) - (CallChecker.isCalled(q2, Quaternion.class, 194, 6587, 6588).getQ3())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4734.methodEnd();
        }
    }

    public Quaternion subtract(final Quaternion q) {
        MethodContext _bcornu_methode_context4735 = new MethodContext(Quaternion.class, 203, 6611, 6865);
        try {
            CallChecker.varInit(this, "this", 203, 6611, 6865);
            CallChecker.varInit(q, "q", 203, 6611, 6865);
            CallChecker.varInit(this.q3, "q3", 203, 6611, 6865);
            CallChecker.varInit(this.q2, "q2", 203, 6611, 6865);
            CallChecker.varInit(this.q1, "q1", 203, 6611, 6865);
            CallChecker.varInit(this.q0, "q0", 203, 6611, 6865);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 203, 6611, 6865);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 203, 6611, 6865);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 203, 6611, 6865);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 203, 6611, 6865);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 203, 6611, 6865);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 203, 6611, 6865);
            return Quaternion.subtract(this, q);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4735.methodEnd();
        }
    }

    public static double dotProduct(final Quaternion q1, final Quaternion q2) {
        MethodContext _bcornu_methode_context4736 = new MethodContext(double.class, 214, 6872, 7336);
        try {
            CallChecker.varInit(q2, "q2", 214, 6872, 7336);
            CallChecker.varInit(q1, "q1", 214, 6872, 7336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 214, 6872, 7336);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 214, 6872, 7336);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 214, 6872, 7336);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 214, 6872, 7336);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 214, 6872, 7336);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 214, 6872, 7336);
            return ((((CallChecker.isCalled(q1, Quaternion.class, 216, 7193, 7194).getQ0()) * (CallChecker.isCalled(q2, Quaternion.class, 216, 7206, 7207).getQ0())) + ((CallChecker.isCalled(q1, Quaternion.class, 217, 7231, 7232).getQ1()) * (CallChecker.isCalled(q2, Quaternion.class, 217, 7244, 7245).getQ1()))) + ((CallChecker.isCalled(q1, Quaternion.class, 218, 7269, 7270).getQ2()) * (CallChecker.isCalled(q2, Quaternion.class, 218, 7282, 7283).getQ2()))) + ((CallChecker.isCalled(q1, Quaternion.class, 219, 7307, 7308).getQ3()) * (CallChecker.isCalled(q2, Quaternion.class, 219, 7320, 7321).getQ3()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4736.methodEnd();
        }
    }

    public double dotProduct(final Quaternion q) {
        MethodContext _bcornu_methode_context4737 = new MethodContext(double.class, 228, 7343, 7609);
        try {
            CallChecker.varInit(this, "this", 228, 7343, 7609);
            CallChecker.varInit(q, "q", 228, 7343, 7609);
            CallChecker.varInit(this.q3, "q3", 228, 7343, 7609);
            CallChecker.varInit(this.q2, "q2", 228, 7343, 7609);
            CallChecker.varInit(this.q1, "q1", 228, 7343, 7609);
            CallChecker.varInit(this.q0, "q0", 228, 7343, 7609);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 228, 7343, 7609);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 228, 7343, 7609);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 228, 7343, 7609);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 228, 7343, 7609);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 228, 7343, 7609);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 228, 7343, 7609);
            return Quaternion.dotProduct(this, q);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4737.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context4738 = new MethodContext(double.class, 237, 7616, 7894);
        try {
            CallChecker.varInit(this, "this", 237, 7616, 7894);
            CallChecker.varInit(this.q3, "q3", 237, 7616, 7894);
            CallChecker.varInit(this.q2, "q2", 237, 7616, 7894);
            CallChecker.varInit(this.q1, "q1", 237, 7616, 7894);
            CallChecker.varInit(this.q0, "q0", 237, 7616, 7894);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 237, 7616, 7894);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 237, 7616, 7894);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 237, 7616, 7894);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 237, 7616, 7894);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 237, 7616, 7894);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 237, 7616, 7894);
            return FastMath.sqrt((((((q0) * (q0)) + ((q1) * (q1))) + ((q2) * (q2))) + ((q3) * (q3))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4738.methodEnd();
        }
    }

    public Quaternion normalize() {
        MethodContext _bcornu_methode_context4739 = new MethodContext(Quaternion.class, 251, 7901, 8515);
        try {
            CallChecker.varInit(this, "this", 251, 7901, 8515);
            CallChecker.varInit(this.q3, "q3", 251, 7901, 8515);
            CallChecker.varInit(this.q2, "q2", 251, 7901, 8515);
            CallChecker.varInit(this.q1, "q1", 251, 7901, 8515);
            CallChecker.varInit(this.q0, "q0", 251, 7901, 8515);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 251, 7901, 8515);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 251, 7901, 8515);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 251, 7901, 8515);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 251, 7901, 8515);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 251, 7901, 8515);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 251, 7901, 8515);
            final double norm = CallChecker.varInit(((double) (getNorm())), "norm", 252, 8196, 8225);
            if (norm < (Precision.SAFE_MIN)) {
                throw new ZeroException(LocalizedFormats.NORM, norm);
            }
            return new Quaternion(((q0) / norm), ((q1) / norm), ((q2) / norm), ((q3) / norm));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4739.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context4740 = new MethodContext(boolean.class, 268, 8522, 8949);
        try {
            CallChecker.varInit(this, "this", 268, 8522, 8949);
            CallChecker.varInit(other, "other", 268, 8522, 8949);
            CallChecker.varInit(this.q3, "q3", 268, 8522, 8949);
            CallChecker.varInit(this.q2, "q2", 268, 8522, 8949);
            CallChecker.varInit(this.q1, "q1", 268, 8522, 8949);
            CallChecker.varInit(this.q0, "q0", 268, 8522, 8949);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 268, 8522, 8949);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 268, 8522, 8949);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 268, 8522, 8949);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 268, 8522, 8949);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 268, 8522, 8949);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 268, 8522, 8949);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Quaternion) {
                final Quaternion q = CallChecker.varInit(((Quaternion) (other)), "q", 273, 8730, 8769);
                return ((((q0) == (CallChecker.isCalled(q, Quaternion.class, 274, 8796, 8796).getQ0())) && ((q1) == (CallChecker.isCalled(q, Quaternion.class, 275, 8831, 8831).getQ1()))) && ((q2) == (CallChecker.isCalled(q, Quaternion.class, 276, 8866, 8866).getQ2()))) && ((q3) == (CallChecker.isCalled(q, Quaternion.class, 277, 8901, 8901).getQ3()));
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4740.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4741 = new MethodContext(int.class, 287, 8956, 9294);
        try {
            CallChecker.varInit(this, "this", 287, 8956, 9294);
            CallChecker.varInit(this.q3, "q3", 287, 8956, 9294);
            CallChecker.varInit(this.q2, "q2", 287, 8956, 9294);
            CallChecker.varInit(this.q1, "q1", 287, 8956, 9294);
            CallChecker.varInit(this.q0, "q0", 287, 8956, 9294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 287, 8956, 9294);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 287, 8956, 9294);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 287, 8956, 9294);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 287, 8956, 9294);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 287, 8956, 9294);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 287, 8956, 9294);
            int result = CallChecker.varInit(((int) (17)), "result", 289, 9092, 9107);
            for (double comp : new double[]{ q0 , q1 , q2 , q3 }) {
                final int c = CallChecker.varInit(((int) (MathUtils.hash(comp))), "c", 291, 9183, 9217);
                result = (31 * result) + c;
                CallChecker.varAssign(result, "result", 292, 9231, 9255);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4741.methodEnd();
        }
    }

    public boolean equals(final Quaternion q, final double eps) {
        MethodContext _bcornu_methode_context4742 = new MethodContext(boolean.class, 306, 9301, 9937);
        try {
            CallChecker.varInit(this, "this", 306, 9301, 9937);
            CallChecker.varInit(eps, "eps", 306, 9301, 9937);
            CallChecker.varInit(q, "q", 306, 9301, 9937);
            CallChecker.varInit(this.q3, "q3", 306, 9301, 9937);
            CallChecker.varInit(this.q2, "q2", 306, 9301, 9937);
            CallChecker.varInit(this.q1, "q1", 306, 9301, 9937);
            CallChecker.varInit(this.q0, "q0", 306, 9301, 9937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 306, 9301, 9937);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 306, 9301, 9937);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 306, 9301, 9937);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 306, 9301, 9937);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 306, 9301, 9937);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 306, 9301, 9937);
            if (CallChecker.beforeDeref(q, Quaternion.class, 308, 9760, 9760)) {
                if (CallChecker.beforeDeref(q, Quaternion.class, 309, 9812, 9812)) {
                    if (CallChecker.beforeDeref(q, Quaternion.class, 310, 9864, 9864)) {
                        if (CallChecker.beforeDeref(q, Quaternion.class, 311, 9916, 9916)) {
                            return (((Precision.equals(q0, CallChecker.isCalled(q, Quaternion.class, 308, 9760, 9760).getQ0(), eps)) && (Precision.equals(q1, CallChecker.isCalled(q, Quaternion.class, 309, 9812, 9812).getQ1(), eps))) && (Precision.equals(q2, CallChecker.isCalled(q, Quaternion.class, 310, 9864, 9864).getQ2(), eps))) && (Precision.equals(q3, CallChecker.isCalled(q, Quaternion.class, 311, 9916, 9916).getQ3(), eps));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4742.methodEnd();
        }
    }

    public boolean isUnitQuaternion(double eps) {
        MethodContext _bcornu_methode_context4743 = new MethodContext(boolean.class, 322, 9944, 10309);
        try {
            CallChecker.varInit(this, "this", 322, 9944, 10309);
            CallChecker.varInit(eps, "eps", 322, 9944, 10309);
            CallChecker.varInit(this.q3, "q3", 322, 9944, 10309);
            CallChecker.varInit(this.q2, "q2", 322, 9944, 10309);
            CallChecker.varInit(this.q1, "q1", 322, 9944, 10309);
            CallChecker.varInit(this.q0, "q0", 322, 9944, 10309);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 322, 9944, 10309);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 322, 9944, 10309);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 322, 9944, 10309);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 322, 9944, 10309);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 322, 9944, 10309);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 322, 9944, 10309);
            return Precision.equals(getNorm(), 1.0, eps);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4743.methodEnd();
        }
    }

    public boolean isPureQuaternion(double eps) {
        MethodContext _bcornu_methode_context4744 = new MethodContext(boolean.class, 333, 10316, 10643);
        try {
            CallChecker.varInit(this, "this", 333, 10316, 10643);
            CallChecker.varInit(eps, "eps", 333, 10316, 10643);
            CallChecker.varInit(this.q3, "q3", 333, 10316, 10643);
            CallChecker.varInit(this.q2, "q2", 333, 10316, 10643);
            CallChecker.varInit(this.q1, "q1", 333, 10316, 10643);
            CallChecker.varInit(this.q0, "q0", 333, 10316, 10643);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 333, 10316, 10643);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 333, 10316, 10643);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 333, 10316, 10643);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 333, 10316, 10643);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 333, 10316, 10643);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 333, 10316, 10643);
            return (FastMath.abs(getQ0())) <= eps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4744.methodEnd();
        }
    }

    public Quaternion getPositivePolarForm() {
        MethodContext _bcornu_methode_context4745 = new MethodContext(Quaternion.class, 342, 10650, 11314);
        try {
            CallChecker.varInit(this, "this", 342, 10650, 11314);
            CallChecker.varInit(this.q3, "q3", 342, 10650, 11314);
            CallChecker.varInit(this.q2, "q2", 342, 10650, 11314);
            CallChecker.varInit(this.q1, "q1", 342, 10650, 11314);
            CallChecker.varInit(this.q0, "q0", 342, 10650, 11314);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 342, 10650, 11314);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 342, 10650, 11314);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 342, 10650, 11314);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 342, 10650, 11314);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 342, 10650, 11314);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 342, 10650, 11314);
            if ((getQ0()) < 0) {
                final Quaternion unitQ = CallChecker.varInit(normalize(), "unitQ", 344, 10866, 10902);
                if (CallChecker.beforeDeref(unitQ, Quaternion.class, 347, 11080, 11084)) {
                    if (CallChecker.beforeDeref(unitQ, Quaternion.class, 348, 11130, 11134)) {
                        if (CallChecker.beforeDeref(unitQ, Quaternion.class, 349, 11180, 11184)) {
                            if (CallChecker.beforeDeref(unitQ, Quaternion.class, 350, 11230, 11234)) {
                                return new Quaternion((-(CallChecker.isCalled(unitQ, Quaternion.class, 347, 11080, 11084).getQ0())), (-(CallChecker.isCalled(unitQ, Quaternion.class, 348, 11130, 11134).getQ1())), (-(CallChecker.isCalled(unitQ, Quaternion.class, 349, 11180, 11184).getQ2())), (-(CallChecker.isCalled(unitQ, Quaternion.class, 350, 11230, 11234).getQ3())));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return this.normalize();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4745.methodEnd();
        }
    }

    public Quaternion getInverse() {
        MethodContext _bcornu_methode_context4746 = new MethodContext(Quaternion.class, 363, 11321, 11979);
        try {
            CallChecker.varInit(this, "this", 363, 11321, 11979);
            CallChecker.varInit(this.q3, "q3", 363, 11321, 11979);
            CallChecker.varInit(this.q2, "q2", 363, 11321, 11979);
            CallChecker.varInit(this.q1, "q1", 363, 11321, 11979);
            CallChecker.varInit(this.q0, "q0", 363, 11321, 11979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 363, 11321, 11979);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 363, 11321, 11979);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 363, 11321, 11979);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 363, 11321, 11979);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 363, 11321, 11979);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 363, 11321, 11979);
            final double squareNorm = CallChecker.varInit(((double) (((((this.q0) * (this.q0)) + ((this.q1) * (this.q1))) + ((this.q2) * (this.q2))) + ((this.q3) * (this.q3)))), "squareNorm", 364, 11588, 11651);
            if (squareNorm < (Precision.SAFE_MIN)) {
                throw new ZeroException(LocalizedFormats.NORM, squareNorm);
            }
            return new Quaternion(((q0) / squareNorm), ((-(q1)) / squareNorm), ((-(q2)) / squareNorm), ((-(q3)) / squareNorm));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4746.methodEnd();
        }
    }

    public double getQ0() {
        MethodContext _bcornu_methode_context4747 = new MethodContext(double.class, 380, 11986, 12153);
        try {
            CallChecker.varInit(this, "this", 380, 11986, 12153);
            CallChecker.varInit(this.q3, "q3", 380, 11986, 12153);
            CallChecker.varInit(this.q2, "q2", 380, 11986, 12153);
            CallChecker.varInit(this.q1, "q1", 380, 11986, 12153);
            CallChecker.varInit(this.q0, "q0", 380, 11986, 12153);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 380, 11986, 12153);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 380, 11986, 12153);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 380, 11986, 12153);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 380, 11986, 12153);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 380, 11986, 12153);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 380, 11986, 12153);
            return q0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4747.methodEnd();
        }
    }

    public double getQ1() {
        MethodContext _bcornu_methode_context4748 = new MethodContext(double.class, 390, 12160, 12381);
        try {
            CallChecker.varInit(this, "this", 390, 12160, 12381);
            CallChecker.varInit(this.q3, "q3", 390, 12160, 12381);
            CallChecker.varInit(this.q2, "q2", 390, 12160, 12381);
            CallChecker.varInit(this.q1, "q1", 390, 12160, 12381);
            CallChecker.varInit(this.q0, "q0", 390, 12160, 12381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 390, 12160, 12381);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 390, 12160, 12381);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 390, 12160, 12381);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 390, 12160, 12381);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 390, 12160, 12381);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 390, 12160, 12381);
            return q1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4748.methodEnd();
        }
    }

    public double getQ2() {
        MethodContext _bcornu_methode_context4749 = new MethodContext(double.class, 400, 12388, 12610);
        try {
            CallChecker.varInit(this, "this", 400, 12388, 12610);
            CallChecker.varInit(this.q3, "q3", 400, 12388, 12610);
            CallChecker.varInit(this.q2, "q2", 400, 12388, 12610);
            CallChecker.varInit(this.q1, "q1", 400, 12388, 12610);
            CallChecker.varInit(this.q0, "q0", 400, 12388, 12610);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 400, 12388, 12610);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 400, 12388, 12610);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 400, 12388, 12610);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 400, 12388, 12610);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 400, 12388, 12610);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 400, 12388, 12610);
            return q2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4749.methodEnd();
        }
    }

    public double getQ3() {
        MethodContext _bcornu_methode_context4750 = new MethodContext(double.class, 410, 12617, 12838);
        try {
            CallChecker.varInit(this, "this", 410, 12617, 12838);
            CallChecker.varInit(this.q3, "q3", 410, 12617, 12838);
            CallChecker.varInit(this.q2, "q2", 410, 12617, 12838);
            CallChecker.varInit(this.q1, "q1", 410, 12617, 12838);
            CallChecker.varInit(this.q0, "q0", 410, 12617, 12838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 410, 12617, 12838);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 410, 12617, 12838);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 410, 12617, 12838);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 410, 12617, 12838);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 410, 12617, 12838);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 410, 12617, 12838);
            return q3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4750.methodEnd();
        }
    }

    public double getScalarPart() {
        MethodContext _bcornu_methode_context4751 = new MethodContext(double.class, 420, 12845, 13028);
        try {
            CallChecker.varInit(this, "this", 420, 12845, 13028);
            CallChecker.varInit(this.q3, "q3", 420, 12845, 13028);
            CallChecker.varInit(this.q2, "q2", 420, 12845, 13028);
            CallChecker.varInit(this.q1, "q1", 420, 12845, 13028);
            CallChecker.varInit(this.q0, "q0", 420, 12845, 13028);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 420, 12845, 13028);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 420, 12845, 13028);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 420, 12845, 13028);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 420, 12845, 13028);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 420, 12845, 13028);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 420, 12845, 13028);
            return getQ0();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4751.methodEnd();
        }
    }

    public double[] getVectorPart() {
        MethodContext _bcornu_methode_context4752 = new MethodContext(double[].class, 432, 13035, 13321);
        try {
            CallChecker.varInit(this, "this", 432, 13035, 13321);
            CallChecker.varInit(this.q3, "q3", 432, 13035, 13321);
            CallChecker.varInit(this.q2, "q2", 432, 13035, 13321);
            CallChecker.varInit(this.q1, "q1", 432, 13035, 13321);
            CallChecker.varInit(this.q0, "q0", 432, 13035, 13321);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 432, 13035, 13321);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 432, 13035, 13321);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 432, 13035, 13321);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 432, 13035, 13321);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 432, 13035, 13321);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 432, 13035, 13321);
            return new double[]{ getQ1() , getQ2() , getQ3() };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4752.methodEnd();
        }
    }

    public Quaternion multiply(final double alpha) {
        MethodContext _bcornu_methode_context4753 = new MethodContext(Quaternion.class, 442, 13328, 13688);
        try {
            CallChecker.varInit(this, "this", 442, 13328, 13688);
            CallChecker.varInit(alpha, "alpha", 442, 13328, 13688);
            CallChecker.varInit(this.q3, "q3", 442, 13328, 13688);
            CallChecker.varInit(this.q2, "q2", 442, 13328, 13688);
            CallChecker.varInit(this.q1, "q1", 442, 13328, 13688);
            CallChecker.varInit(this.q0, "q0", 442, 13328, 13688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 442, 13328, 13688);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 442, 13328, 13688);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 442, 13328, 13688);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 442, 13328, 13688);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 442, 13328, 13688);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 442, 13328, 13688);
            return new Quaternion((alpha * (q0)), (alpha * (q1)), (alpha * (q2)), (alpha * (q3)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Quaternion) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4753.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4754 = new MethodContext(String.class, 453, 13695, 14068);
        try {
            CallChecker.varInit(this, "this", 453, 13695, 14068);
            CallChecker.varInit(this.q3, "q3", 453, 13695, 14068);
            CallChecker.varInit(this.q2, "q2", 453, 13695, 14068);
            CallChecker.varInit(this.q1, "q1", 453, 13695, 14068);
            CallChecker.varInit(this.q0, "q0", 453, 13695, 14068);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.Quaternion.serialVersionUID", 453, 13695, 14068);
            CallChecker.varInit(K, "org.apache.commons.math3.complex.Quaternion.K", 453, 13695, 14068);
            CallChecker.varInit(J, "org.apache.commons.math3.complex.Quaternion.J", 453, 13695, 14068);
            CallChecker.varInit(I, "org.apache.commons.math3.complex.Quaternion.I", 453, 13695, 14068);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.complex.Quaternion.ZERO", 453, 13695, 14068);
            CallChecker.varInit(IDENTITY, "org.apache.commons.math3.complex.Quaternion.IDENTITY", 453, 13695, 14068);
            final String sp = CallChecker.varInit(" ", "sp", 454, 13781, 13802);
            final StringBuilder s = CallChecker.varInit(new StringBuilder(), "s", 455, 13812, 13855);
            if (CallChecker.beforeDeref(s, StringBuilder.class, 456, 13865, 13865)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936).append(sp), StringBuilder.class, 456, 13865, 13947)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936).append(sp), StringBuilder.class, 456, 13865, 13947).append(q2), StringBuilder.class, 456, 13865, 13971)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936).append(sp), StringBuilder.class, 456, 13865, 13947).append(q2), StringBuilder.class, 456, 13865, 13971).append(sp), StringBuilder.class, 456, 13865, 13982)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936).append(sp), StringBuilder.class, 456, 13865, 13947).append(q2), StringBuilder.class, 456, 13865, 13971).append(sp), StringBuilder.class, 456, 13865, 13982).append(q3), StringBuilder.class, 456, 13865, 14006)) {
                                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(s, StringBuilder.class, 456, 13865, 13865).append("["), StringBuilder.class, 456, 13865, 13877).append(q0), StringBuilder.class, 456, 13865, 13901).append(sp), StringBuilder.class, 456, 13865, 13912).append(q1), StringBuilder.class, 456, 13865, 13936).append(sp), StringBuilder.class, 456, 13865, 13947).append(q2), StringBuilder.class, 456, 13865, 13971).append(sp), StringBuilder.class, 456, 13865, 13982).append(q3), StringBuilder.class, 456, 13865, 14006).append("]");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(s, StringBuilder.class, 463, 14050, 14050)) {
                return CallChecker.isCalled(s, StringBuilder.class, 463, 14050, 14050).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4754.methodEnd();
        }
    }
}

