package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Well512a extends AbstractWell {
    private static final long serialVersionUID = -6104179812103820574L;

    private static final int K = 512;

    private static final int M1 = 13;

    private static final int M2 = 9;

    private static final int M3 = 5;

    public Well512a() {
        super(Well512a.K, Well512a.M1, Well512a.M2, Well512a.M3);
        ConstructorContext _bcornu_methode_context943 = new ConstructorContext(Well512a.class, 56, 2091, 2285);
        try {
        } finally {
            _bcornu_methode_context943.methodEnd();
        }
    }

    public Well512a(int seed) {
        super(Well512a.K, Well512a.M1, Well512a.M2, Well512a.M3, seed);
        ConstructorContext _bcornu_methode_context944 = new ConstructorContext(Well512a.class, 63, 2292, 2493);
        try {
        } finally {
            _bcornu_methode_context944.methodEnd();
        }
    }

    public Well512a(int[] seed) {
        super(Well512a.K, Well512a.M1, Well512a.M2, Well512a.M3, seed);
        ConstructorContext _bcornu_methode_context945 = new ConstructorContext(Well512a.class, 71, 2500, 2788);
        try {
        } finally {
            _bcornu_methode_context945.methodEnd();
        }
    }

    public Well512a(long seed) {
        super(Well512a.K, Well512a.M1, Well512a.M2, Well512a.M3, seed);
        ConstructorContext _bcornu_methode_context946 = new ConstructorContext(Well512a.class, 78, 2795, 2998);
        try {
        } finally {
            _bcornu_methode_context946.methodEnd();
        }
    }

    @Override
    protected int next(final int bits) {
        MethodContext _bcornu_methode_context4255 = new MethodContext(int.class, 84, 3005, 3712);
        try {
            CallChecker.varInit(this, "this", 84, 3005, 3712);
            CallChecker.varInit(bits, "bits", 84, 3005, 3712);
            CallChecker.varInit(this.i3, "i3", 84, 3005, 3712);
            CallChecker.varInit(this.i2, "i2", 84, 3005, 3712);
            CallChecker.varInit(this.i1, "i1", 84, 3005, 3712);
            CallChecker.varInit(this.iRm2, "iRm2", 84, 3005, 3712);
            CallChecker.varInit(this.iRm1, "iRm1", 84, 3005, 3712);
            CallChecker.varInit(this.v, "v", 84, 3005, 3712);
            CallChecker.varInit(this.index, "index", 84, 3005, 3712);
            CallChecker.varInit(M3, "org.apache.commons.math3.random.Well512a.M3", 84, 3005, 3712);
            CallChecker.varInit(M2, "org.apache.commons.math3.random.Well512a.M2", 84, 3005, 3712);
            CallChecker.varInit(M1, "org.apache.commons.math3.random.Well512a.M1", 84, 3005, 3712);
            CallChecker.varInit(K, "org.apache.commons.math3.random.Well512a.K", 84, 3005, 3712);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.Well512a.serialVersionUID", 84, 3005, 3712);
            final int indexRm1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.iRm1, int[].class, 86, 3111, 3114)[this.index])), "indexRm1", 86, 3090, 3122);
            final int vi = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 88, 3148, 3148)[this.index])), "vi", 88, 3133, 3156);
            final int vi1 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 89, 3182, 3182)[CallChecker.isCalled(this.i1, int[].class, 89, 3184, 3185)[this.index]])), "vi1", 89, 3166, 3194);
            final int vi2 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 90, 3220, 3220)[CallChecker.isCalled(this.i2, int[].class, 90, 3222, 3223)[this.index]])), "vi2", 90, 3204, 3232);
            final int z0 = CallChecker.varInit(((int) (CallChecker.isCalled(this.v, int[].class, 91, 3257, 3257)[indexRm1])), "z0", 91, 3242, 3268);
            final int z1 = CallChecker.varInit(((int) ((vi ^ (vi << 16)) ^ (vi1 ^ (vi1 << 15)))), "z1", 94, 3279, 3406);
            final int z2 = CallChecker.varInit(((int) (vi2 ^ (vi2 >>> 11))), "z2", 95, 3416, 3449);
            final int z3 = CallChecker.varInit(((int) (z1 ^ z2)), "z3", 96, 3459, 3481);
            final int z4 = CallChecker.varInit(((int) ((((z0 ^ (z0 << 2)) ^ (z1 ^ (z1 << 18))) ^ (z2 << 28)) ^ (z3 ^ ((z3 << 5) & -633066204)))), "z4", 97, 3491, 3589);
            if (CallChecker.beforeDeref(v, int[].class, 99, 3600, 3600)) {
                CallChecker.isCalled(v, int[].class, 99, 3600, 3600)[index] = z3;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 99, 3600, 3600)[this.index], "CallChecker.isCalled(this.v, int[].class, 99, 3600, 3600)[this.index]", 99, 3600, 3613);
            }
            if (CallChecker.beforeDeref(v, int[].class, 100, 3623, 3623)) {
                CallChecker.isCalled(v, int[].class, 100, 3623, 3623)[indexRm1] = z4;
                CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 100, 3623, 3623)[indexRm1], "CallChecker.isCalled(this.v, int[].class, 100, 3623, 3623)[indexRm1]", 100, 3623, 3640);
            }
            index = indexRm1;
            CallChecker.varAssign(this.index, "this.index", 101, 3650, 3669);
            return z4 >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4255.methodEnd();
        }
    }
}

