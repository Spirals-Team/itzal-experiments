package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well19937c extends AbstractWell {
    private static final long serialVersionUID = -7203498180754925124L;

    private static final int K = 19937;

    private static final int M1 = 70;

    private static final int M2 = 179;

    private static final int M3 = 449;

    public Well19937c() {
        super(Well19937c.K, Well19937c.M1, Well19937c.M2, Well19937c.M3);
        ConstructorContext _bcornu_methode_context235 = new ConstructorContext(Well19937c.class, 56, 2101, 2297);
        try {
        } finally {
            _bcornu_methode_context235.methodEnd();
        }
    }

    public Well19937c(int seed) {
        super(Well19937c.K, Well19937c.M1, Well19937c.M2, Well19937c.M3, seed);
        ConstructorContext _bcornu_methode_context236 = new ConstructorContext(Well19937c.class, 63, 2304, 2507);
        try {
        } finally {
            _bcornu_methode_context236.methodEnd();
        }
    }

    public Well19937c(int[] seed) {
        super(Well19937c.K, Well19937c.M1, Well19937c.M2, Well19937c.M3, seed);
        ConstructorContext _bcornu_methode_context237 = new ConstructorContext(Well19937c.class, 71, 2514, 2804);
        try {
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    public Well19937c(long seed) {
        super(Well19937c.K, Well19937c.M1, Well19937c.M2, Well19937c.M3, seed);
        ConstructorContext _bcornu_methode_context238 = new ConstructorContext(Well19937c.class, 78, 2811, 3016);
        try {
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context976 = new MethodContext(int.class, 84, 3023, 4030);
        try {
            CallChecker.varInit(this, "this", 84, 3023, 4030);
            CallChecker.varInit(bits, "bits", 84, 3023, 4030);
            CallChecker.varInit(this.i3, "i3", 84, 3023, 4030);
            CallChecker.varInit(this.i2, "i2", 84, 3023, 4030);
            CallChecker.varInit(this.i1, "i1", 84, 3023, 4030);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3023, 4030);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3023, 4030);
            CallChecker.varInit(this.v, "v", 84, 3023, 4030);
            CallChecker.varInit(this.index, "index", 84, 3023, 4030);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well19937c.M3", 84, 3023, 4030);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well19937c.M2", 84, 3023, 4030);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well19937c.M1", 84, 3023, 4030);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well19937c.K", 84, 3023, 4030);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well19937c.serialVersionUID", 84, 3023, 4030);
            final int indexRm1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm1, int[].class, 86, 3129, 3132)[this.index])), "indexRm1", 86, 3108, 3140);
            final int indexRm2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm2, int[].class, 87, 3171, 3174)[this.index])), "indexRm2", 87, 3150, 3182);
            final int v0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 89, 3214, 3214)[this.index])), "v0", 89, 3193, 3222);
            final int vM1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 90, 3253, 3253)[CallChecker.isCalled(this.i1, int[].class, 90, 3255, 3256)[this.index]])), "vM1", 90, 3232, 3265);
            final int vM2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 91, 3296, 3296)[CallChecker.isCalled(this.i2, int[].class, 91, 3298, 3299)[this.index]])), "vM2", 91, 3275, 3308);
            final int vM3 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 92, 3339, 3339)[CallChecker.isCalled(this.i3, int[].class, 92, 3341, 3342)[this.index]])), "vM3", 92, 3318, 3351);
            final int z0 = CallChecker.varInit(((int) ((-2147483648 & (CallChecker.isCalled(this.v, int[].class, 94, 3391, 3391)[indexRm1])) ^ (2147483647 & (CallChecker.isCalled(this.v, int[].class, 94, 3420, 3420)[indexRm2])))), "z0", 94, 3362, 3432);
            final int z1 = CallChecker.varInit(((int) ((v0 ^ (v0 << 25)) ^ (vM1 ^ (vM1 >>> 27)))), "z1", 95, 3442, 3498);
            final int z2 = CallChecker.varInit(((int) ((vM2 >>> 9) ^ (vM3 ^ (vM3 >>> 1)))), "z2", 96, 3508, 3556);
            final int z3 = CallChecker.varInit(((int) (z1 ^ z2)), "z3", 97, 3566, 3593);
            int z4 = CallChecker.varInit(((int) (((z0 ^ (z1 ^ (z1 << 9))) ^ (z2 ^ (z2 << 21))) ^ (z3 ^ (z3 >>> 21)))), "z4", 98, 3603, 3674);
            if (CallChecker.beforeDeref(v, int[].class, 100, 3685, 3685)) {
                CallChecker.isCalled(v, int[].class, 100, 3685, 3685)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 100, 3685, 3685)[this.index], "CallChecker.isCalled(this.v, int[].class, 100, 3685, 3685)[this.index]", 100, 3685, 3702);
            }
            if (CallChecker.beforeDeref(v, int[].class, 101, 3712, 3712)) {
                CallChecker.isCalled(v, int[].class, 101, 3712, 3712)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 101, 3712, 3712)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 101, 3712, 3712)[indexRm1]", 101, 3712, 3729);
            }
            if (CallChecker.beforeDeref(v, int[].class, 102, 3739, 3739)) {
                CallChecker.isCalled(v, int[].class, 102, 3739, 3739)[indexRm2] &= -2147483648;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 102, 3739, 3739)[indexRm2], "CallChecker.isCalled(this.v, int[].class, 102, 3739, 3739)[indexRm2]", 102, 3739, 3764);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 103, 3774, 3797);
            z4 = z4 ^ ((z4 << 7) & -462547200);
            CallChecker.varAssign(z4, "z4", 108, 3907, 3942);
            z4 = z4 ^ ((z4 << 15) & -1685684224);
            CallChecker.varAssign(z4, "z4", 109, 3952, 3987);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context976.methodEnd();
        }
    }
}

