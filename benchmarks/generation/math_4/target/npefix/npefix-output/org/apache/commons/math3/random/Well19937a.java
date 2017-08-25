package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well19937a extends AbstractWell {
    private static final long serialVersionUID = -7462102162223815419L;

    private static final int K = 19937;

    private static final int M1 = 70;

    private static final int M2 = 179;

    private static final int M3 = 449;

    public Well19937a() {
        super(Well19937a.K, Well19937a.M1, Well19937a.M2, Well19937a.M3);
        ConstructorContext _bcornu_methode_context230 = new ConstructorContext(Well19937a.class, 56, 2101, 2297);
        try {
        } finally {
            _bcornu_methode_context230.methodEnd();
        }
    }

    public Well19937a(int seed) {
        super(Well19937a.K, Well19937a.M1, Well19937a.M2, Well19937a.M3, seed);
        ConstructorContext _bcornu_methode_context231 = new ConstructorContext(Well19937a.class, 63, 2304, 2507);
        try {
        } finally {
            _bcornu_methode_context231.methodEnd();
        }
    }

    public Well19937a(int[] seed) {
        super(Well19937a.K, Well19937a.M1, Well19937a.M2, Well19937a.M3, seed);
        ConstructorContext _bcornu_methode_context232 = new ConstructorContext(Well19937a.class, 71, 2514, 2804);
        try {
        } finally {
            _bcornu_methode_context232.methodEnd();
        }
    }

    public Well19937a(long seed) {
        super(Well19937a.K, Well19937a.M1, Well19937a.M2, Well19937a.M3, seed);
        ConstructorContext _bcornu_methode_context233 = new ConstructorContext(Well19937a.class, 78, 2811, 3016);
        try {
        } finally {
            _bcornu_methode_context233.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context966 = new MethodContext(int.class, 84, 3023, 3846);
        try {
            CallChecker.varInit(this, "this", 84, 3023, 3846);
            CallChecker.varInit(bits, "bits", 84, 3023, 3846);
            CallChecker.varInit(this.i3, "i3", 84, 3023, 3846);
            CallChecker.varInit(this.i2, "i2", 84, 3023, 3846);
            CallChecker.varInit(this.i1, "i1", 84, 3023, 3846);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3023, 3846);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3023, 3846);
            CallChecker.varInit(this.v, "v", 84, 3023, 3846);
            CallChecker.varInit(this.index, "index", 84, 3023, 3846);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well19937a.M3", 84, 3023, 3846);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well19937a.M2", 84, 3023, 3846);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well19937a.M1", 84, 3023, 3846);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well19937a.K", 84, 3023, 3846);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well19937a.serialVersionUID", 84, 3023, 3846);
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
            final int z4 = CallChecker.varInit(((int) (((z0 ^ (z1 ^ (z1 << 9))) ^ (z2 ^ (z2 << 21))) ^ (z3 ^ (z3 >>> 21)))), "z4", 98, 3603, 3680);
            if (CallChecker.beforeDeref(v, int[].class, 100, 3691, 3691)) {
                CallChecker.isCalled(v, int[].class, 100, 3691, 3691)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 100, 3691, 3691)[this.index], "CallChecker.isCalled(this.v, int[].class, 100, 3691, 3691)[this.index]", 100, 3691, 3708);
            }
            if (CallChecker.beforeDeref(v, int[].class, 101, 3718, 3718)) {
                CallChecker.isCalled(v, int[].class, 101, 3718, 3718)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 101, 3718, 3718)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 101, 3718, 3718)[indexRm1]", 101, 3718, 3735);
            }
            if (CallChecker.beforeDeref(v, int[].class, 102, 3745, 3745)) {
                CallChecker.isCalled(v, int[].class, 102, 3745, 3745)[indexRm2] &= -2147483648;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 102, 3745, 3745)[indexRm2], "CallChecker.isCalled(this.v, int[].class, 102, 3745, 3745)[indexRm2]", 102, 3745, 3770);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 103, 3780, 3803);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context966.methodEnd();
        }
    }
}

