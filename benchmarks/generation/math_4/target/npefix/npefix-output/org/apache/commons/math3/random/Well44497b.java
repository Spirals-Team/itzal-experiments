package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well44497b extends AbstractWell {
    private static final long serialVersionUID = 4032007538246675492L;

    private static final int K = 44497;

    private static final int M1 = 23;

    private static final int M2 = 481;

    private static final int M3 = 229;

    public Well44497b() {
        super(Well44497b.K, Well44497b.M1, Well44497b.M2, Well44497b.M3);
        ConstructorContext _bcornu_methode_context345 = new ConstructorContext(Well44497b.class, 56, 2100, 2296);
        try {
        } finally {
            _bcornu_methode_context345.methodEnd();
        }
    }

    public Well44497b(int seed) {
        super(Well44497b.K, Well44497b.M1, Well44497b.M2, Well44497b.M3, seed);
        ConstructorContext _bcornu_methode_context346 = new ConstructorContext(Well44497b.class, 63, 2303, 2506);
        try {
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }

    public Well44497b(int[] seed) {
        super(Well44497b.K, Well44497b.M1, Well44497b.M2, Well44497b.M3, seed);
        ConstructorContext _bcornu_methode_context347 = new ConstructorContext(Well44497b.class, 71, 2513, 2803);
        try {
        } finally {
            _bcornu_methode_context347.methodEnd();
        }
    }

    public Well44497b(long seed) {
        super(Well44497b.K, Well44497b.M1, Well44497b.M2, Well44497b.M3, seed);
        ConstructorContext _bcornu_methode_context348 = new ConstructorContext(Well44497b.class, 78, 2810, 3015);
        try {
        } finally {
            _bcornu_methode_context348.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context1588 = new MethodContext(int.class, 84, 3022, 4380);
        try {
            CallChecker.varInit(this, "this", 84, 3022, 4380);
            CallChecker.varInit(bits, "bits", 84, 3022, 4380);
            CallChecker.varInit(this.i3, "i3", 84, 3022, 4380);
            CallChecker.varInit(this.i2, "i2", 84, 3022, 4380);
            CallChecker.varInit(this.i1, "i1", 84, 3022, 4380);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3022, 4380);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3022, 4380);
            CallChecker.varInit(this.v, "v", 84, 3022, 4380);
            CallChecker.varInit(this.index, "index", 84, 3022, 4380);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well44497b.M3", 84, 3022, 4380);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well44497b.M2", 84, 3022, 4380);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well44497b.M1", 84, 3022, 4380);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well44497b.K", 84, 3022, 4380);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well44497b.serialVersionUID", 84, 3022, 4380);
            final int indexRm1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm1, int[].class, 88, 3237, 3240)[this.index])), "indexRm1", 88, 3107, 3248);
            final int indexRm2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm2, int[].class, 89, 3279, 3282)[this.index])), "indexRm2", 89, 3258, 3290);
            final int v0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 91, 3322, 3322)[this.index])), "v0", 91, 3301, 3330);
            final int vM1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 92, 3361, 3361)[CallChecker.isCalled(this.i1, int[].class, 92, 3363, 3364)[this.index]])), "vM1", 92, 3340, 3373);
            final int vM2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 93, 3404, 3404)[CallChecker.isCalled(this.i2, int[].class, 93, 3406, 3407)[this.index]])), "vM2", 93, 3383, 3416);
            final int vM3 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 94, 3447, 3447)[CallChecker.isCalled(this.i3, int[].class, 94, 3449, 3450)[this.index]])), "vM3", 94, 3426, 3459);
            final int z0 = CallChecker.varInit(((int) ((-32768 & (CallChecker.isCalled(this.v, int[].class, 97, 3576, 3576)[indexRm1])) ^ (32767 & (CallChecker.isCalled(this.v, int[].class, 97, 3605, 3605)[indexRm2])))), "z0", 97, 3470, 3617);
            final int z1 = CallChecker.varInit(((int) ((v0 ^ (v0 << 24)) ^ (vM1 ^ (vM1 >>> 30)))), "z1", 98, 3627, 3689);
            final int z2 = CallChecker.varInit(((int) ((vM2 ^ (vM2 << 10)) ^ (vM3 << 26))), "z2", 99, 3699, 3753);
            final int z3 = CallChecker.varInit(((int) (z1 ^ z2)), "z3", 100, 3763, 3796);
            final int z2Prime = CallChecker.varInit(((int) (((z2 << 9) ^ (z2 >>> 23)) & -67108865)), "z2Prime", 101, 3806, 3865);
            int z2Second = CallChecker.init(int.class);
            if ((z2 & 131072) != 0) {
                z2Second = z2Prime ^ -1221985044;
                CallChecker.varAssign(z2Second, "z2Second", 102, 3896, 3954);
            }else {
                z2Second = z2Prime;
                CallChecker.varAssign(z2Second, "z2Second", 102, 3896, 3954);
            }
            int z4 = CallChecker.varInit(((int) (((z0 ^ (z1 ^ (z1 >>> 20))) ^ z2Second) ^ z3)), "z4", 103, 3965, 4025);
            if (CallChecker.beforeDeref(v, int[].class, 105, 4036, 4036)) {
                CallChecker.isCalled(v, int[].class, 105, 4036, 4036)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 105, 4036, 4036)[this.index], "CallChecker.isCalled(this.v, int[].class, 105, 4036, 4036)[this.index]", 105, 4036, 4053);
            }
            if (CallChecker.beforeDeref(v, int[].class, 106, 4063, 4063)) {
                CallChecker.isCalled(v, int[].class, 106, 4063, 4063)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 106, 4063, 4063)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 106, 4063, 4063)[indexRm1]", 106, 4063, 4080);
            }
            if (CallChecker.beforeDeref(v, int[].class, 107, 4090, 4090)) {
                CallChecker.isCalled(v, int[].class, 107, 4090, 4090)[indexRm2] &= -32768;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 107, 4090, 4090)[indexRm2], "CallChecker.isCalled(this.v, int[].class, 107, 4090, 4090)[indexRm2]", 107, 4090, 4115);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 108, 4125, 4148);
            z4 = z4 ^ ((z4 << 7) & -1814227968);
            CallChecker.varAssign(z4, "z4", 112, 4257, 4292);
            z4 = z4 ^ ((z4 << 15) & -99516416);
            CallChecker.varAssign(z4, "z4", 113, 4302, 4337);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1588.methodEnd();
        }
    }
}

