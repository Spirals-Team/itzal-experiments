package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well1024a extends AbstractWell {
    private static final long serialVersionUID = 5680173464174485492L;

    private static final int K = 1024;

    private static final int M1 = 3;

    private static final int M2 = 24;

    private static final int M3 = 10;

    public Well1024a() {
        super(Well1024a.K, Well1024a.M1, Well1024a.M2, Well1024a.M3);
        ConstructorContext _bcornu_methode_context806 = new ConstructorContext(Well1024a.class, 56, 2094, 2289);
        try {
        } finally {
            _bcornu_methode_context806.methodEnd();
        }
    }

    public Well1024a(int seed) {
        super(Well1024a.K, Well1024a.M1, Well1024a.M2, Well1024a.M3, seed);
        ConstructorContext _bcornu_methode_context807 = new ConstructorContext(Well1024a.class, 63, 2296, 2498);
        try {
        } finally {
            _bcornu_methode_context807.methodEnd();
        }
    }

    public Well1024a(int[] seed) {
        super(Well1024a.K, Well1024a.M1, Well1024a.M2, Well1024a.M3, seed);
        ConstructorContext _bcornu_methode_context808 = new ConstructorContext(Well1024a.class, 71, 2505, 2794);
        try {
        } finally {
            _bcornu_methode_context808.methodEnd();
        }
    }

    public Well1024a(long seed) {
        super(Well1024a.K, Well1024a.M1, Well1024a.M2, Well1024a.M3, seed);
        ConstructorContext _bcornu_methode_context809 = new ConstructorContext(Well1024a.class, 78, 2801, 3005);
        try {
        } finally {
            _bcornu_methode_context809.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context3567 = new MethodContext(int.class, 84, 3012, 3700);
        try {
            CallChecker.varInit(this, "this", 84, 3012, 3700);
            CallChecker.varInit(bits, "bits", 84, 3012, 3700);
            CallChecker.varInit(this.i3, "i3", 84, 3012, 3700);
            CallChecker.varInit(this.i2, "i2", 84, 3012, 3700);
            CallChecker.varInit(this.i1, "i1", 84, 3012, 3700);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3012, 3700);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3012, 3700);
            CallChecker.varInit(this.v, "v", 84, 3012, 3700);
            CallChecker.varInit(this.index, "index", 84, 3012, 3700);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well1024a.M3", 84, 3012, 3700);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well1024a.M2", 84, 3012, 3700);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well1024a.M1", 84, 3012, 3700);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well1024a.K", 84, 3012, 3700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well1024a.serialVersionUID", 84, 3012, 3700);
            final int indexRm1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm1, int[].class, 86, 3118, 3121)[this.index])), "indexRm1", 86, 3097, 3129);
            final int v0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 88, 3161, 3161)[this.index])), "v0", 88, 3140, 3169);
            final int vM1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 89, 3200, 3200)[CallChecker.isCalled(this.i1, int[].class, 89, 3202, 3203)[this.index]])), "vM1", 89, 3179, 3212);
            final int vM2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 90, 3243, 3243)[CallChecker.isCalled(this.i2, int[].class, 90, 3245, 3246)[this.index]])), "vM2", 90, 3222, 3255);
            final int vM3 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 91, 3286, 3286)[CallChecker.isCalled(this.i3, int[].class, 91, 3288, 3289)[this.index]])), "vM3", 91, 3265, 3298);
            final int z0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 93, 3324, 3324)[indexRm1])), "z0", 93, 3309, 3335);
            final int z1 = CallChecker.varInit(((int) (v0 ^ (vM1 ^ (vM1 >>> 8)))), "z1", 94, 3345, 3385);
            final int z2 = CallChecker.varInit(((int) ((vM2 ^ (vM2 << 19)) ^ (vM3 ^ (vM3 << 14)))), "z2", 95, 3395, 3451);
            final int z3 = CallChecker.varInit(((int) (z1 ^ z2)), "z3", 96, 3461, 3488);
            final int z4 = CallChecker.varInit(((int) (((z0 ^ (z0 << 11)) ^ (z1 ^ (z1 << 7))) ^ (z2 ^ (z2 << 13)))), "z4", 97, 3498, 3569);
            if (CallChecker.beforeDeref(v, int[].class, 99, 3580, 3580)) {
                CallChecker.isCalled(v, int[].class, 99, 3580, 3580)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 99, 3580, 3580)[this.index], "CallChecker.isCalled(this.v, int[].class, 99, 3580, 3580)[this.index]", 99, 3580, 3597);
            }
            if (CallChecker.beforeDeref(v, int[].class, 100, 3607, 3607)) {
                CallChecker.isCalled(v, int[].class, 100, 3607, 3607)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 100, 3607, 3607)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 100, 3607, 3607)[indexRm1]", 100, 3607, 3624);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 101, 3634, 3657);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3567.methodEnd();
        }
    }
}

