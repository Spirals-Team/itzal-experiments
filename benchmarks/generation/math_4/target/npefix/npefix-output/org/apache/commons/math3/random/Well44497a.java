package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well44497a extends AbstractWell {
    private static final long serialVersionUID = -3859207588353972099L;

    private static final int K = 44497;

    private static final int M1 = 23;

    private static final int M2 = 481;

    private static final int M3 = 229;

    public Well44497a() {
        super(Well44497a.K, Well44497a.M1, Well44497a.M2, Well44497a.M3);
        ConstructorContext _bcornu_methode_context349 = new ConstructorContext(Well44497a.class, 56, 2101, 2297);
        try {
        } finally {
            _bcornu_methode_context349.methodEnd();
        }
    }

    public Well44497a(int seed) {
        super(Well44497a.K, Well44497a.M1, Well44497a.M2, Well44497a.M3, seed);
        ConstructorContext _bcornu_methode_context350 = new ConstructorContext(Well44497a.class, 63, 2304, 2507);
        try {
        } finally {
            _bcornu_methode_context350.methodEnd();
        }
    }

    public Well44497a(int[] seed) {
        super(Well44497a.K, Well44497a.M1, Well44497a.M2, Well44497a.M3, seed);
        ConstructorContext _bcornu_methode_context351 = new ConstructorContext(Well44497a.class, 71, 2514, 2804);
        try {
        } finally {
            _bcornu_methode_context351.methodEnd();
        }
    }

    public Well44497a(long seed) {
        super(Well44497a.K, Well44497a.M1, Well44497a.M2, Well44497a.M3, seed);
        ConstructorContext _bcornu_methode_context352 = new ConstructorContext(Well44497a.class, 78, 2811, 3016);
        try {
        } finally {
            _bcornu_methode_context352.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context1589 = new MethodContext(int.class, 84, 3023, 4083);
        try {
            CallChecker.varInit(this, "this", 84, 3023, 4083);
            CallChecker.varInit(bits, "bits", 84, 3023, 4083);
            CallChecker.varInit(this.i3, "i3", 84, 3023, 4083);
            CallChecker.varInit(this.i2, "i2", 84, 3023, 4083);
            CallChecker.varInit(this.i1, "i1", 84, 3023, 4083);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3023, 4083);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3023, 4083);
            CallChecker.varInit(this.v, "v", 84, 3023, 4083);
            CallChecker.varInit(this.index, "index", 84, 3023, 4083);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well44497a.M3", 84, 3023, 4083);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well44497a.M2", 84, 3023, 4083);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well44497a.M1", 84, 3023, 4083);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well44497a.K", 84, 3023, 4083);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well44497a.serialVersionUID", 84, 3023, 4083);
            final int indexRm1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm1, int[].class, 86, 3129, 3132)[this.index])), "indexRm1", 86, 3108, 3140);
            final int indexRm2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm2, int[].class, 87, 3171, 3174)[this.index])), "indexRm2", 87, 3150, 3182);
            final int v0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 89, 3214, 3214)[this.index])), "v0", 89, 3193, 3222);
            final int vM1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 90, 3253, 3253)[CallChecker.isCalled(this.i1, int[].class, 90, 3255, 3256)[this.index]])), "vM1", 90, 3232, 3265);
            final int vM2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 91, 3296, 3296)[CallChecker.isCalled(this.i2, int[].class, 91, 3298, 3299)[this.index]])), "vM2", 91, 3275, 3308);
            final int vM3 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 92, 3339, 3339)[CallChecker.isCalled(this.i3, int[].class, 92, 3341, 3342)[this.index]])), "vM3", 92, 3318, 3351);
            final int z0 = CallChecker.varInit(((int) ((-32768 & (CallChecker.isCalled(this.v, int[].class, 95, 3468, 3468)[indexRm1])) ^ (32767 & (CallChecker.isCalled(this.v, int[].class, 95, 3497, 3497)[indexRm2])))), "z0", 95, 3362, 3509);
            final int z1 = CallChecker.varInit(((int) ((v0 ^ (v0 << 24)) ^ (vM1 ^ (vM1 >>> 30)))), "z1", 96, 3519, 3581);
            final int z2 = CallChecker.varInit(((int) ((vM2 ^ (vM2 << 10)) ^ (vM3 << 26))), "z2", 97, 3591, 3645);
            final int z3 = CallChecker.varInit(((int) (z1 ^ z2)), "z3", 98, 3655, 3688);
            final int z2Prime = CallChecker.varInit(((int) (((z2 << 9) ^ (z2 >>> 23)) & -67108865)), "z2Prime", 99, 3698, 3757);
            int z2Second = CallChecker.init(int.class);
            if ((z2 & 131072) != 0) {
                z2Second = z2Prime ^ -1221985044;
                CallChecker.varAssign(z2Second, "z2Second", 100, 3788, 3846);
            }else {
                z2Second = z2Prime;
                CallChecker.varAssign(z2Second, "z2Second", 100, 3788, 3846);
            }
            final int z4 = CallChecker.varInit(((int) (((z0 ^ (z1 ^ (z1 >>> 20))) ^ z2Second) ^ z3)), "z4", 101, 3857, 3917);
            if (CallChecker.beforeDeref(v, int[].class, 103, 3928, 3928)) {
                CallChecker.isCalled(v, int[].class, 103, 3928, 3928)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 103, 3928, 3928)[this.index], "CallChecker.isCalled(this.v, int[].class, 103, 3928, 3928)[this.index]", 103, 3928, 3945);
            }
            if (CallChecker.beforeDeref(v, int[].class, 104, 3955, 3955)) {
                CallChecker.isCalled(v, int[].class, 104, 3955, 3955)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 104, 3955, 3955)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 104, 3955, 3955)[indexRm1]", 104, 3955, 3972);
            }
            if (CallChecker.beforeDeref(v, int[].class, 105, 3982, 3982)) {
                CallChecker.isCalled(v, int[].class, 105, 3982, 3982)[indexRm2] &= -32768;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 105, 3982, 3982)[indexRm2], "CallChecker.isCalled(this.v, int[].class, 105, 3982, 3982)[indexRm2]", 105, 3982, 4007);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 106, 4017, 4040);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1589.methodEnd();
        }
    }
}

