package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

public class ISAACRandom extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = 7288197941165002400L;

    private static final int SIZE_L = 8;

    private static final int SIZE = 1 << (ISAACRandom.SIZE_L);

    private static final int H_SIZE = (ISAACRandom.SIZE) >> 1;

    private static final int MASK = ((ISAACRandom.SIZE) - 1) << 2;

    private static final int GLD_RATIO = -1640531527;

    private final int[] rsl = new int[ISAACRandom.SIZE];

    private final int[] mem = new int[ISAACRandom.SIZE];

    private int count;

    private int isaacA;

    private int isaacB;

    private int isaacC;

    private final int[] arr = new int[8];

    private int isaacX;

    private int isaacI;

    private int isaacJ;

    public ISAACRandom() {
        ConstructorContext _bcornu_methode_context1056 = new ConstructorContext(ISAACRandom.class, 83, 2862, 3179);
        try {
            setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
        } finally {
            _bcornu_methode_context1056.methodEnd();
        }
    }

    public ISAACRandom(long seed) {
        ConstructorContext _bcornu_methode_context1057 = new ConstructorContext(ISAACRandom.class, 92, 3186, 3378);
        try {
            setSeed(seed);
        } finally {
            _bcornu_methode_context1057.methodEnd();
        }
    }

    public ISAACRandom(int[] seed) {
        ConstructorContext _bcornu_methode_context1058 = new ConstructorContext(ISAACRandom.class, 102, 3385, 3647);
        try {
            setSeed(seed);
        } finally {
            _bcornu_methode_context1058.methodEnd();
        }
    }

    @Override
    public void setSeed(int seed) {
        MethodContext _bcornu_methode_context4684 = new MethodContext(void.class, 108, 3654, 3763);
        try {
            CallChecker.varInit(this, "this", 108, 3654, 3763);
            CallChecker.varInit(seed, "seed", 108, 3654, 3763);
            CallChecker.varInit(this.isaacJ, "isaacJ", 108, 3654, 3763);
            CallChecker.varInit(this.isaacI, "isaacI", 108, 3654, 3763);
            CallChecker.varInit(this.isaacX, "isaacX", 108, 3654, 3763);
            CallChecker.varInit(this.arr, "arr", 108, 3654, 3763);
            CallChecker.varInit(this.isaacC, "isaacC", 108, 3654, 3763);
            CallChecker.varInit(this.isaacB, "isaacB", 108, 3654, 3763);
            CallChecker.varInit(this.isaacA, "isaacA", 108, 3654, 3763);
            CallChecker.varInit(this.count, "count", 108, 3654, 3763);
            CallChecker.varInit(this.mem, "mem", 108, 3654, 3763);
            CallChecker.varInit(this.rsl, "rsl", 108, 3654, 3763);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 108, 3654, 3763);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 108, 3654, 3763);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 108, 3654, 3763);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 108, 3654, 3763);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 108, 3654, 3763);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 108, 3654, 3763);
            setSeed(new int[]{ seed });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4684.methodEnd();
        }
    }

    @Override
    public void setSeed(long seed) {
        MethodContext _bcornu_methode_context4685 = new MethodContext(void.class, 114, 3770, 3923);
        try {
            CallChecker.varInit(this, "this", 114, 3770, 3923);
            CallChecker.varInit(seed, "seed", 114, 3770, 3923);
            CallChecker.varInit(this.isaacJ, "isaacJ", 114, 3770, 3923);
            CallChecker.varInit(this.isaacI, "isaacI", 114, 3770, 3923);
            CallChecker.varInit(this.isaacX, "isaacX", 114, 3770, 3923);
            CallChecker.varInit(this.arr, "arr", 114, 3770, 3923);
            CallChecker.varInit(this.isaacC, "isaacC", 114, 3770, 3923);
            CallChecker.varInit(this.isaacB, "isaacB", 114, 3770, 3923);
            CallChecker.varInit(this.isaacA, "isaacA", 114, 3770, 3923);
            CallChecker.varInit(this.count, "count", 114, 3770, 3923);
            CallChecker.varInit(this.mem, "mem", 114, 3770, 3923);
            CallChecker.varInit(this.rsl, "rsl", 114, 3770, 3923);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 114, 3770, 3923);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 114, 3770, 3923);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 114, 3770, 3923);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 114, 3770, 3923);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 114, 3770, 3923);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 114, 3770, 3923);
            setSeed(new int[]{ ((int) (seed >>> 32)) , ((int) (seed & 4294967295L)) });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4685.methodEnd();
        }
    }

    @Override
    public void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context4686 = new MethodContext(void.class, 120, 3930, 4549);
        try {
            CallChecker.varInit(this, "this", 120, 3930, 4549);
            CallChecker.varInit(seed, "seed", 120, 3930, 4549);
            CallChecker.varInit(this.isaacJ, "isaacJ", 120, 3930, 4549);
            CallChecker.varInit(this.isaacI, "isaacI", 120, 3930, 4549);
            CallChecker.varInit(this.isaacX, "isaacX", 120, 3930, 4549);
            CallChecker.varInit(this.arr, "arr", 120, 3930, 4549);
            CallChecker.varInit(this.isaacC, "isaacC", 120, 3930, 4549);
            CallChecker.varInit(this.isaacB, "isaacB", 120, 3930, 4549);
            CallChecker.varInit(this.isaacA, "isaacA", 120, 3930, 4549);
            CallChecker.varInit(this.count, "count", 120, 3930, 4549);
            CallChecker.varInit(this.mem, "mem", 120, 3930, 4549);
            CallChecker.varInit(this.rsl, "rsl", 120, 3930, 4549);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 120, 3930, 4549);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 120, 3930, 4549);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 120, 3930, 4549);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 120, 3930, 4549);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 120, 3930, 4549);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 120, 3930, 4549);
            if (seed == null) {
                setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
                return ;
            }
            final int seedLen = CallChecker.varInit(((int) (seed.length)), "seedLen", 125, 4150, 4181);
            final int rslLen = CallChecker.varInit(((int) (CallChecker.isCalled(this.rsl, int[].class, 126, 4210, 4212).length)), "rslLen", 126, 4191, 4220);
            System.arraycopy(seed, 0, rsl, 0, Math.min(seedLen, rslLen));
            if (seedLen < rslLen) {
                for (int j = seedLen; j < rslLen; j++) {
                    long k = CallChecker.init(long.class);
                    if (CallChecker.beforeDeref(rsl, int[].class, 130, 4402, 4404)) {
                        k = CallChecker.isCalled(rsl, int[].class, 130, 4402, 4404)[(j - seedLen)];
                        CallChecker.varAssign(k, "k", 130, 4402, 4404);
                    }
                    if (CallChecker.beforeDeref(rsl, int[].class, 131, 4436, 4438)) {
                        CallChecker.isCalled(rsl, int[].class, 131, 4436, 4438)[j] = ((int) (((1812433253L * (k ^ (k >> 30))) + j) & 4294967295L));
                        CallChecker.varAssign(CallChecker.isCalled(this.rsl, int[].class, 131, 4436, 4438)[j], "CallChecker.isCalled(this.rsl, int[].class, 131, 4436, 4438)[j]", 131, 4436, 4498);
                    }
                }
            }
            initState();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4686.methodEnd();
        }
    }

    @Override
    protected int next(int bits) {
        MethodContext _bcornu_methode_context4687 = new MethodContext(int.class, 139, 4556, 4759);
        try {
            CallChecker.varInit(this, "this", 139, 4556, 4759);
            CallChecker.varInit(bits, "bits", 139, 4556, 4759);
            CallChecker.varInit(this.isaacJ, "isaacJ", 139, 4556, 4759);
            CallChecker.varInit(this.isaacI, "isaacI", 139, 4556, 4759);
            CallChecker.varInit(this.isaacX, "isaacX", 139, 4556, 4759);
            CallChecker.varInit(this.arr, "arr", 139, 4556, 4759);
            CallChecker.varInit(this.isaacC, "isaacC", 139, 4556, 4759);
            CallChecker.varInit(this.isaacB, "isaacB", 139, 4556, 4759);
            CallChecker.varInit(this.isaacA, "isaacA", 139, 4556, 4759);
            CallChecker.varInit(this.count, "count", 139, 4556, 4759);
            CallChecker.varInit(this.mem, "mem", 139, 4556, 4759);
            CallChecker.varInit(this.rsl, "rsl", 139, 4556, 4759);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 139, 4556, 4759);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 139, 4556, 4759);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 139, 4556, 4759);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 139, 4556, 4759);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 139, 4556, 4759);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 139, 4556, 4759);
            if ((count) < 0) {
                isaac();
                count = (ISAACRandom.SIZE) - 1;
                CallChecker.varAssign(this.count, "this.count", 142, 4684, 4700);
            }
            return (CallChecker.isCalled(rsl, int[].class, 144, 4727, 4729)[((count)--)]) >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4687.methodEnd();
        }
    }

    private void isaac() {
        MethodContext _bcornu_methode_context4688 = new MethodContext(void.class, 148, 4766, 5050);
        try {
            CallChecker.varInit(this, "this", 148, 4766, 5050);
            CallChecker.varInit(this.isaacJ, "isaacJ", 148, 4766, 5050);
            CallChecker.varInit(this.isaacI, "isaacI", 148, 4766, 5050);
            CallChecker.varInit(this.isaacX, "isaacX", 148, 4766, 5050);
            CallChecker.varInit(this.arr, "arr", 148, 4766, 5050);
            CallChecker.varInit(this.isaacC, "isaacC", 148, 4766, 5050);
            CallChecker.varInit(this.isaacB, "isaacB", 148, 4766, 5050);
            CallChecker.varInit(this.isaacA, "isaacA", 148, 4766, 5050);
            CallChecker.varInit(this.count, "count", 148, 4766, 5050);
            CallChecker.varInit(this.mem, "mem", 148, 4766, 5050);
            CallChecker.varInit(this.rsl, "rsl", 148, 4766, 5050);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 148, 4766, 5050);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 148, 4766, 5050);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 148, 4766, 5050);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 148, 4766, 5050);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 148, 4766, 5050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 148, 4766, 5050);
            isaacI = 0;
            CallChecker.varAssign(this.isaacI, "this.isaacI", 149, 4829, 4839);
            isaacJ = ISAACRandom.H_SIZE;
            CallChecker.varAssign(this.isaacJ, "this.isaacJ", 150, 4849, 4864);
            isaacB += ++(isaacC);
            CallChecker.varAssign(this.isaacB, "this.isaacB", 151, 4874, 4892);
            while ((isaacI) < (ISAACRandom.H_SIZE)) {
                isaac2();
            } 
            isaacJ = 0;
            CallChecker.varAssign(this.isaacJ, "this.isaacJ", 155, 4968, 4978);
            while ((isaacJ) < (ISAACRandom.H_SIZE)) {
                isaac2();
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4688.methodEnd();
        }
    }

    private void isaac2() {
        MethodContext _bcornu_methode_context4689 = new MethodContext(void.class, 162, 5057, 5576);
        try {
            CallChecker.varInit(this, "this", 162, 5057, 5576);
            CallChecker.varInit(this.isaacJ, "isaacJ", 162, 5057, 5576);
            CallChecker.varInit(this.isaacI, "isaacI", 162, 5057, 5576);
            CallChecker.varInit(this.isaacX, "isaacX", 162, 5057, 5576);
            CallChecker.varInit(this.arr, "arr", 162, 5057, 5576);
            CallChecker.varInit(this.isaacC, "isaacC", 162, 5057, 5576);
            CallChecker.varInit(this.isaacB, "isaacB", 162, 5057, 5576);
            CallChecker.varInit(this.isaacA, "isaacA", 162, 5057, 5576);
            CallChecker.varInit(this.count, "count", 162, 5057, 5576);
            CallChecker.varInit(this.mem, "mem", 162, 5057, 5576);
            CallChecker.varInit(this.rsl, "rsl", 162, 5057, 5576);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 162, 5057, 5576);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 162, 5057, 5576);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 162, 5057, 5576);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 162, 5057, 5576);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 162, 5057, 5576);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 162, 5057, 5576);
            if (CallChecker.beforeDeref(mem, int[].class, 163, 5137, 5139)) {
                isaacX = CallChecker.isCalled(mem, int[].class, 163, 5137, 5139)[isaacI];
                CallChecker.varAssign(this.isaacX, "this.isaacX", 163, 5128, 5148);
            }
            isaacA ^= (isaacA) << 13;
            CallChecker.varAssign(this.isaacA, "this.isaacA", 164, 5158, 5180);
            if (CallChecker.beforeDeref(mem, int[].class, 165, 5200, 5202)) {
                isaacA += CallChecker.isCalled(mem, int[].class, 165, 5200, 5202)[((isaacJ)++)];
                CallChecker.varAssign(this.isaacA, "this.isaacA", 165, 5190, 5213);
            }
            isaac3();
            if (CallChecker.beforeDeref(mem, int[].class, 167, 5250, 5252)) {
                isaacX = CallChecker.isCalled(mem, int[].class, 167, 5250, 5252)[isaacI];
                CallChecker.varAssign(this.isaacX, "this.isaacX", 167, 5241, 5261);
            }
            isaacA ^= (isaacA) >>> 6;
            CallChecker.varAssign(this.isaacA, "this.isaacA", 168, 5271, 5293);
            if (CallChecker.beforeDeref(mem, int[].class, 169, 5313, 5315)) {
                isaacA += CallChecker.isCalled(mem, int[].class, 169, 5313, 5315)[((isaacJ)++)];
                CallChecker.varAssign(this.isaacA, "this.isaacA", 169, 5303, 5326);
            }
            isaac3();
            if (CallChecker.beforeDeref(mem, int[].class, 171, 5363, 5365)) {
                isaacX = CallChecker.isCalled(mem, int[].class, 171, 5363, 5365)[isaacI];
                CallChecker.varAssign(this.isaacX, "this.isaacX", 171, 5354, 5374);
            }
            isaacA ^= (isaacA) << 2;
            CallChecker.varAssign(this.isaacA, "this.isaacA", 172, 5384, 5405);
            if (CallChecker.beforeDeref(mem, int[].class, 173, 5425, 5427)) {
                isaacA += CallChecker.isCalled(mem, int[].class, 173, 5425, 5427)[((isaacJ)++)];
                CallChecker.varAssign(this.isaacA, "this.isaacA", 173, 5415, 5438);
            }
            isaac3();
            if (CallChecker.beforeDeref(mem, int[].class, 175, 5475, 5477)) {
                isaacX = CallChecker.isCalled(mem, int[].class, 175, 5475, 5477)[isaacI];
                CallChecker.varAssign(this.isaacX, "this.isaacX", 175, 5466, 5486);
            }
            isaacA ^= (isaacA) >>> 16;
            CallChecker.varAssign(this.isaacA, "this.isaacA", 176, 5496, 5519);
            if (CallChecker.beforeDeref(mem, int[].class, 177, 5539, 5541)) {
                isaacA += CallChecker.isCalled(mem, int[].class, 177, 5539, 5541)[((isaacJ)++)];
                CallChecker.varAssign(this.isaacA, "this.isaacA", 177, 5529, 5552);
            }
            isaac3();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4689.methodEnd();
        }
    }

    private void isaac3() {
        MethodContext _bcornu_methode_context4690 = new MethodContext(void.class, 182, 5583, 5817);
        try {
            CallChecker.varInit(this, "this", 182, 5583, 5817);
            CallChecker.varInit(this.isaacJ, "isaacJ", 182, 5583, 5817);
            CallChecker.varInit(this.isaacI, "isaacI", 182, 5583, 5817);
            CallChecker.varInit(this.isaacX, "isaacX", 182, 5583, 5817);
            CallChecker.varInit(this.arr, "arr", 182, 5583, 5817);
            CallChecker.varInit(this.isaacC, "isaacC", 182, 5583, 5817);
            CallChecker.varInit(this.isaacB, "isaacB", 182, 5583, 5817);
            CallChecker.varInit(this.isaacA, "isaacA", 182, 5583, 5817);
            CallChecker.varInit(this.count, "count", 182, 5583, 5817);
            CallChecker.varInit(this.mem, "mem", 182, 5583, 5817);
            CallChecker.varInit(this.rsl, "rsl", 182, 5583, 5817);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 182, 5583, 5817);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 182, 5583, 5817);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 182, 5583, 5817);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 182, 5583, 5817);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 182, 5583, 5817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 182, 5583, 5817);
            if (CallChecker.beforeDeref(mem, int[].class, 183, 5654, 5656)) {
                if (CallChecker.beforeDeref(mem, int[].class, 183, 5668, 5670)) {
                    CallChecker.isCalled(mem, int[].class, 183, 5654, 5656)[isaacI] = ((CallChecker.isCalled(mem, int[].class, 183, 5668, 5670)[(((isaacX) & (ISAACRandom.MASK)) >> 2)]) + (isaacA)) + (isaacB);
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 183, 5654, 5656)[this.isaacI], "CallChecker.isCalled(this.mem, int[].class, 183, 5654, 5656)[this.isaacI]", 183, 5654, 5711);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 184, 5735, 5737)) {
                if (CallChecker.beforeDeref(mem, int[].class, 184, 5730, 5732)) {
                    isaacB = (CallChecker.isCalled(mem, int[].class, 184, 5730, 5732)[((((CallChecker.isCalled(mem, int[].class, 184, 5735, 5737)[isaacI]) >> (ISAACRandom.SIZE_L)) & (ISAACRandom.MASK)) >> 2)]) + (isaacX);
                    CallChecker.varAssign(this.isaacB, "this.isaacB", 184, 5721, 5779);
                }
            }
            if (CallChecker.beforeDeref(rsl, int[].class, 185, 5789, 5791)) {
                CallChecker.isCalled(rsl, int[].class, 185, 5789, 5791)[((isaacI)++)] = isaacB;
                CallChecker.varAssign(CallChecker.isCalled(this.rsl, int[].class, 185, 5789, 5791)[((this.isaacI) - 1)], "CallChecker.isCalled(this.rsl, int[].class, 185, 5789, 5791)[((this.isaacI) - 1)]", 185, 5789, 5811);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4690.methodEnd();
        }
    }

    private void initState() {
        MethodContext _bcornu_methode_context4691 = new MethodContext(void.class, 189, 5824, 7039);
        try {
            CallChecker.varInit(this, "this", 189, 5824, 7039);
            CallChecker.varInit(this.isaacJ, "isaacJ", 189, 5824, 7039);
            CallChecker.varInit(this.isaacI, "isaacI", 189, 5824, 7039);
            CallChecker.varInit(this.isaacX, "isaacX", 189, 5824, 7039);
            CallChecker.varInit(this.arr, "arr", 189, 5824, 7039);
            CallChecker.varInit(this.isaacC, "isaacC", 189, 5824, 7039);
            CallChecker.varInit(this.isaacB, "isaacB", 189, 5824, 7039);
            CallChecker.varInit(this.isaacA, "isaacA", 189, 5824, 7039);
            CallChecker.varInit(this.count, "count", 189, 5824, 7039);
            CallChecker.varInit(this.mem, "mem", 189, 5824, 7039);
            CallChecker.varInit(this.rsl, "rsl", 189, 5824, 7039);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 189, 5824, 7039);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 189, 5824, 7039);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 189, 5824, 7039);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 189, 5824, 7039);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 189, 5824, 7039);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 189, 5824, 7039);
            isaacA = 0;
            CallChecker.varAssign(this.isaacA, "this.isaacA", 190, 5922, 5932);
            isaacB = 0;
            CallChecker.varAssign(this.isaacB, "this.isaacB", 191, 5942, 5952);
            isaacC = 0;
            CallChecker.varAssign(this.isaacC, "this.isaacC", 192, 5962, 5972);
            for (int j = 0; j < (CallChecker.isCalled(arr, int[].class, 193, 6002, 6004).length); j++) {
                if (CallChecker.beforeDeref(arr, int[].class, 194, 6033, 6035)) {
                    CallChecker.isCalled(arr, int[].class, 194, 6033, 6035)[j] = ISAACRandom.GLD_RATIO;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 194, 6033, 6035)[j], "CallChecker.isCalled(this.arr, int[].class, 194, 6033, 6035)[j]", 194, 6033, 6051);
                }
            }
            for (int j = 0; j < 4; j++) {
                shuffle();
            }
            for (int j = 0; j < (ISAACRandom.SIZE); j += 8) {
                CallChecker.varAssign(j, "j", 200, 6210, 6215);
                if (CallChecker.beforeDeref(arr, int[].class, 201, 6232, 6234)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 201, 6242, 6244)) {
                        CallChecker.isCalled(arr, int[].class, 201, 6232, 6234)[0] += CallChecker.isCalled(rsl, int[].class, 201, 6242, 6244)[j];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 201, 6232, 6234)[0], "CallChecker.isCalled(this.arr, int[].class, 201, 6232, 6234)[0]", 201, 6232, 6248);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 202, 6262, 6264)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 202, 6272, 6274)) {
                        CallChecker.isCalled(arr, int[].class, 202, 6262, 6264)[1] += CallChecker.isCalled(rsl, int[].class, 202, 6272, 6274)[(j + 1)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 202, 6262, 6264)[1], "CallChecker.isCalled(this.arr, int[].class, 202, 6262, 6264)[1]", 202, 6262, 6282);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 203, 6296, 6298)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 203, 6306, 6308)) {
                        CallChecker.isCalled(arr, int[].class, 203, 6296, 6298)[2] += CallChecker.isCalled(rsl, int[].class, 203, 6306, 6308)[(j + 2)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 203, 6296, 6298)[2], "CallChecker.isCalled(this.arr, int[].class, 203, 6296, 6298)[2]", 203, 6296, 6316);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 204, 6330, 6332)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 204, 6340, 6342)) {
                        CallChecker.isCalled(arr, int[].class, 204, 6330, 6332)[3] += CallChecker.isCalled(rsl, int[].class, 204, 6340, 6342)[(j + 3)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 204, 6330, 6332)[3], "CallChecker.isCalled(this.arr, int[].class, 204, 6330, 6332)[3]", 204, 6330, 6350);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 205, 6364, 6366)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 205, 6374, 6376)) {
                        CallChecker.isCalled(arr, int[].class, 205, 6364, 6366)[4] += CallChecker.isCalled(rsl, int[].class, 205, 6374, 6376)[(j + 4)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 205, 6364, 6366)[4], "CallChecker.isCalled(this.arr, int[].class, 205, 6364, 6366)[4]", 205, 6364, 6384);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 206, 6398, 6400)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 206, 6408, 6410)) {
                        CallChecker.isCalled(arr, int[].class, 206, 6398, 6400)[5] += CallChecker.isCalled(rsl, int[].class, 206, 6408, 6410)[(j + 5)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 206, 6398, 6400)[5], "CallChecker.isCalled(this.arr, int[].class, 206, 6398, 6400)[5]", 206, 6398, 6418);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 207, 6432, 6434)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 207, 6442, 6444)) {
                        CallChecker.isCalled(arr, int[].class, 207, 6432, 6434)[6] += CallChecker.isCalled(rsl, int[].class, 207, 6442, 6444)[(j + 6)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 207, 6432, 6434)[6], "CallChecker.isCalled(this.arr, int[].class, 207, 6432, 6434)[6]", 207, 6432, 6452);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 208, 6466, 6468)) {
                    if (CallChecker.beforeDeref(rsl, int[].class, 208, 6476, 6478)) {
                        CallChecker.isCalled(arr, int[].class, 208, 6466, 6468)[7] += CallChecker.isCalled(rsl, int[].class, 208, 6476, 6478)[(j + 7)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 208, 6466, 6468)[7], "CallChecker.isCalled(this.arr, int[].class, 208, 6466, 6468)[7]", 208, 6466, 6486);
                    }
                }
                shuffle();
                setState(j);
            }
            for (int j = 0; j < (ISAACRandom.SIZE); j += 8) {
                CallChecker.varAssign(j, "j", 213, 6639, 6644);
                if (CallChecker.beforeDeref(arr, int[].class, 214, 6661, 6663)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 214, 6671, 6673)) {
                        CallChecker.isCalled(arr, int[].class, 214, 6661, 6663)[0] += CallChecker.isCalled(mem, int[].class, 214, 6671, 6673)[j];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 214, 6661, 6663)[0], "CallChecker.isCalled(this.arr, int[].class, 214, 6661, 6663)[0]", 214, 6661, 6677);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 215, 6691, 6693)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 215, 6701, 6703)) {
                        CallChecker.isCalled(arr, int[].class, 215, 6691, 6693)[1] += CallChecker.isCalled(mem, int[].class, 215, 6701, 6703)[(j + 1)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 215, 6691, 6693)[1], "CallChecker.isCalled(this.arr, int[].class, 215, 6691, 6693)[1]", 215, 6691, 6711);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 216, 6725, 6727)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 216, 6735, 6737)) {
                        CallChecker.isCalled(arr, int[].class, 216, 6725, 6727)[2] += CallChecker.isCalled(mem, int[].class, 216, 6735, 6737)[(j + 2)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 216, 6725, 6727)[2], "CallChecker.isCalled(this.arr, int[].class, 216, 6725, 6727)[2]", 216, 6725, 6745);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 217, 6759, 6761)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 217, 6769, 6771)) {
                        CallChecker.isCalled(arr, int[].class, 217, 6759, 6761)[3] += CallChecker.isCalled(mem, int[].class, 217, 6769, 6771)[(j + 3)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 217, 6759, 6761)[3], "CallChecker.isCalled(this.arr, int[].class, 217, 6759, 6761)[3]", 217, 6759, 6779);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 218, 6793, 6795)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 218, 6803, 6805)) {
                        CallChecker.isCalled(arr, int[].class, 218, 6793, 6795)[4] += CallChecker.isCalled(mem, int[].class, 218, 6803, 6805)[(j + 4)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 218, 6793, 6795)[4], "CallChecker.isCalled(this.arr, int[].class, 218, 6793, 6795)[4]", 218, 6793, 6813);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 219, 6827, 6829)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 219, 6837, 6839)) {
                        CallChecker.isCalled(arr, int[].class, 219, 6827, 6829)[5] += CallChecker.isCalled(mem, int[].class, 219, 6837, 6839)[(j + 5)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 219, 6827, 6829)[5], "CallChecker.isCalled(this.arr, int[].class, 219, 6827, 6829)[5]", 219, 6827, 6847);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 220, 6861, 6863)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 220, 6871, 6873)) {
                        CallChecker.isCalled(arr, int[].class, 220, 6861, 6863)[6] += CallChecker.isCalled(mem, int[].class, 220, 6871, 6873)[(j + 6)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 220, 6861, 6863)[6], "CallChecker.isCalled(this.arr, int[].class, 220, 6861, 6863)[6]", 220, 6861, 6881);
                    }
                }
                if (CallChecker.beforeDeref(arr, int[].class, 221, 6895, 6897)) {
                    if (CallChecker.beforeDeref(mem, int[].class, 221, 6905, 6907)) {
                        CallChecker.isCalled(arr, int[].class, 221, 6895, 6897)[7] += CallChecker.isCalled(mem, int[].class, 221, 6905, 6907)[(j + 7)];
                        CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 221, 6895, 6897)[7], "CallChecker.isCalled(this.arr, int[].class, 221, 6895, 6897)[7]", 221, 6895, 6915);
                    }
                }
                shuffle();
                setState(j);
            }
            isaac();
            count = (ISAACRandom.SIZE) - 1;
            CallChecker.varAssign(this.count, "this.count", 226, 7000, 7016);
            clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4691.methodEnd();
        }
    }

    private void shuffle() {
        MethodContext _bcornu_methode_context4692 = new MethodContext(void.class, 231, 7046, 7772);
        try {
            CallChecker.varInit(this, "this", 231, 7046, 7772);
            CallChecker.varInit(this.isaacJ, "isaacJ", 231, 7046, 7772);
            CallChecker.varInit(this.isaacI, "isaacI", 231, 7046, 7772);
            CallChecker.varInit(this.isaacX, "isaacX", 231, 7046, 7772);
            CallChecker.varInit(this.arr, "arr", 231, 7046, 7772);
            CallChecker.varInit(this.isaacC, "isaacC", 231, 7046, 7772);
            CallChecker.varInit(this.isaacB, "isaacB", 231, 7046, 7772);
            CallChecker.varInit(this.isaacA, "isaacA", 231, 7046, 7772);
            CallChecker.varInit(this.count, "count", 231, 7046, 7772);
            CallChecker.varInit(this.mem, "mem", 231, 7046, 7772);
            CallChecker.varInit(this.rsl, "rsl", 231, 7046, 7772);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 231, 7046, 7772);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 231, 7046, 7772);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 231, 7046, 7772);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 231, 7046, 7772);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 231, 7046, 7772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 231, 7046, 7772);
            if (CallChecker.beforeDeref(arr, int[].class, 232, 7105, 7107)) {
                if (CallChecker.beforeDeref(arr, int[].class, 232, 7115, 7117)) {
                    CallChecker.isCalled(arr, int[].class, 232, 7105, 7107)[0] ^= (CallChecker.isCalled(arr, int[].class, 232, 7115, 7117)[1]) << 11;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 232, 7105, 7107)[0], "CallChecker.isCalled(this.arr, int[].class, 232, 7105, 7107)[0]", 232, 7105, 7127);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 233, 7137, 7139)) {
                if (CallChecker.beforeDeref(arr, int[].class, 233, 7147, 7149)) {
                    CallChecker.isCalled(arr, int[].class, 233, 7137, 7139)[3] += CallChecker.isCalled(arr, int[].class, 233, 7147, 7149)[0];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 233, 7137, 7139)[3], "CallChecker.isCalled(this.arr, int[].class, 233, 7137, 7139)[3]", 233, 7137, 7153);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 234, 7163, 7165)) {
                if (CallChecker.beforeDeref(arr, int[].class, 234, 7173, 7175)) {
                    CallChecker.isCalled(arr, int[].class, 234, 7163, 7165)[1] += CallChecker.isCalled(arr, int[].class, 234, 7173, 7175)[2];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 234, 7163, 7165)[1], "CallChecker.isCalled(this.arr, int[].class, 234, 7163, 7165)[1]", 234, 7163, 7179);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 235, 7189, 7191)) {
                if (CallChecker.beforeDeref(arr, int[].class, 235, 7199, 7201)) {
                    CallChecker.isCalled(arr, int[].class, 235, 7189, 7191)[1] ^= (CallChecker.isCalled(arr, int[].class, 235, 7199, 7201)[2]) >>> 2;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 235, 7189, 7191)[1], "CallChecker.isCalled(this.arr, int[].class, 235, 7189, 7191)[1]", 235, 7189, 7211);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 236, 7221, 7223)) {
                if (CallChecker.beforeDeref(arr, int[].class, 236, 7231, 7233)) {
                    CallChecker.isCalled(arr, int[].class, 236, 7221, 7223)[4] += CallChecker.isCalled(arr, int[].class, 236, 7231, 7233)[1];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 236, 7221, 7223)[4], "CallChecker.isCalled(this.arr, int[].class, 236, 7221, 7223)[4]", 236, 7221, 7237);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 237, 7247, 7249)) {
                if (CallChecker.beforeDeref(arr, int[].class, 237, 7257, 7259)) {
                    CallChecker.isCalled(arr, int[].class, 237, 7247, 7249)[2] += CallChecker.isCalled(arr, int[].class, 237, 7257, 7259)[3];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 237, 7247, 7249)[2], "CallChecker.isCalled(this.arr, int[].class, 237, 7247, 7249)[2]", 237, 7247, 7263);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 238, 7273, 7275)) {
                if (CallChecker.beforeDeref(arr, int[].class, 238, 7283, 7285)) {
                    CallChecker.isCalled(arr, int[].class, 238, 7273, 7275)[2] ^= (CallChecker.isCalled(arr, int[].class, 238, 7283, 7285)[3]) << 8;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 238, 7273, 7275)[2], "CallChecker.isCalled(this.arr, int[].class, 238, 7273, 7275)[2]", 238, 7273, 7294);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 239, 7304, 7306)) {
                if (CallChecker.beforeDeref(arr, int[].class, 239, 7314, 7316)) {
                    CallChecker.isCalled(arr, int[].class, 239, 7304, 7306)[5] += CallChecker.isCalled(arr, int[].class, 239, 7314, 7316)[2];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 239, 7304, 7306)[5], "CallChecker.isCalled(this.arr, int[].class, 239, 7304, 7306)[5]", 239, 7304, 7320);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 240, 7330, 7332)) {
                if (CallChecker.beforeDeref(arr, int[].class, 240, 7340, 7342)) {
                    CallChecker.isCalled(arr, int[].class, 240, 7330, 7332)[3] += CallChecker.isCalled(arr, int[].class, 240, 7340, 7342)[4];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 240, 7330, 7332)[3], "CallChecker.isCalled(this.arr, int[].class, 240, 7330, 7332)[3]", 240, 7330, 7346);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 241, 7356, 7358)) {
                if (CallChecker.beforeDeref(arr, int[].class, 241, 7366, 7368)) {
                    CallChecker.isCalled(arr, int[].class, 241, 7356, 7358)[3] ^= (CallChecker.isCalled(arr, int[].class, 241, 7366, 7368)[4]) >>> 16;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 241, 7356, 7358)[3], "CallChecker.isCalled(this.arr, int[].class, 241, 7356, 7358)[3]", 241, 7356, 7379);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 242, 7389, 7391)) {
                if (CallChecker.beforeDeref(arr, int[].class, 242, 7399, 7401)) {
                    CallChecker.isCalled(arr, int[].class, 242, 7389, 7391)[6] += CallChecker.isCalled(arr, int[].class, 242, 7399, 7401)[3];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 242, 7389, 7391)[6], "CallChecker.isCalled(this.arr, int[].class, 242, 7389, 7391)[6]", 242, 7389, 7405);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 243, 7415, 7417)) {
                if (CallChecker.beforeDeref(arr, int[].class, 243, 7425, 7427)) {
                    CallChecker.isCalled(arr, int[].class, 243, 7415, 7417)[4] += CallChecker.isCalled(arr, int[].class, 243, 7425, 7427)[5];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 243, 7415, 7417)[4], "CallChecker.isCalled(this.arr, int[].class, 243, 7415, 7417)[4]", 243, 7415, 7431);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 244, 7441, 7443)) {
                if (CallChecker.beforeDeref(arr, int[].class, 244, 7451, 7453)) {
                    CallChecker.isCalled(arr, int[].class, 244, 7441, 7443)[4] ^= (CallChecker.isCalled(arr, int[].class, 244, 7451, 7453)[5]) << 10;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 244, 7441, 7443)[4], "CallChecker.isCalled(this.arr, int[].class, 244, 7441, 7443)[4]", 244, 7441, 7463);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 245, 7473, 7475)) {
                if (CallChecker.beforeDeref(arr, int[].class, 245, 7483, 7485)) {
                    CallChecker.isCalled(arr, int[].class, 245, 7473, 7475)[7] += CallChecker.isCalled(arr, int[].class, 245, 7483, 7485)[4];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 245, 7473, 7475)[7], "CallChecker.isCalled(this.arr, int[].class, 245, 7473, 7475)[7]", 245, 7473, 7489);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 246, 7499, 7501)) {
                if (CallChecker.beforeDeref(arr, int[].class, 246, 7509, 7511)) {
                    CallChecker.isCalled(arr, int[].class, 246, 7499, 7501)[5] += CallChecker.isCalled(arr, int[].class, 246, 7509, 7511)[6];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 246, 7499, 7501)[5], "CallChecker.isCalled(this.arr, int[].class, 246, 7499, 7501)[5]", 246, 7499, 7515);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 247, 7525, 7527)) {
                if (CallChecker.beforeDeref(arr, int[].class, 247, 7535, 7537)) {
                    CallChecker.isCalled(arr, int[].class, 247, 7525, 7527)[5] ^= (CallChecker.isCalled(arr, int[].class, 247, 7535, 7537)[6]) >>> 4;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 247, 7525, 7527)[5], "CallChecker.isCalled(this.arr, int[].class, 247, 7525, 7527)[5]", 247, 7525, 7547);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 248, 7557, 7559)) {
                if (CallChecker.beforeDeref(arr, int[].class, 248, 7567, 7569)) {
                    CallChecker.isCalled(arr, int[].class, 248, 7557, 7559)[0] += CallChecker.isCalled(arr, int[].class, 248, 7567, 7569)[5];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 248, 7557, 7559)[0], "CallChecker.isCalled(this.arr, int[].class, 248, 7557, 7559)[0]", 248, 7557, 7573);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 249, 7583, 7585)) {
                if (CallChecker.beforeDeref(arr, int[].class, 249, 7593, 7595)) {
                    CallChecker.isCalled(arr, int[].class, 249, 7583, 7585)[6] += CallChecker.isCalled(arr, int[].class, 249, 7593, 7595)[7];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 249, 7583, 7585)[6], "CallChecker.isCalled(this.arr, int[].class, 249, 7583, 7585)[6]", 249, 7583, 7599);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 250, 7609, 7611)) {
                if (CallChecker.beforeDeref(arr, int[].class, 250, 7619, 7621)) {
                    CallChecker.isCalled(arr, int[].class, 250, 7609, 7611)[6] ^= (CallChecker.isCalled(arr, int[].class, 250, 7619, 7621)[7]) << 8;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 250, 7609, 7611)[6], "CallChecker.isCalled(this.arr, int[].class, 250, 7609, 7611)[6]", 250, 7609, 7630);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 251, 7640, 7642)) {
                if (CallChecker.beforeDeref(arr, int[].class, 251, 7650, 7652)) {
                    CallChecker.isCalled(arr, int[].class, 251, 7640, 7642)[1] += CallChecker.isCalled(arr, int[].class, 251, 7650, 7652)[6];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 251, 7640, 7642)[1], "CallChecker.isCalled(this.arr, int[].class, 251, 7640, 7642)[1]", 251, 7640, 7656);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 252, 7666, 7668)) {
                if (CallChecker.beforeDeref(arr, int[].class, 252, 7676, 7678)) {
                    CallChecker.isCalled(arr, int[].class, 252, 7666, 7668)[7] += CallChecker.isCalled(arr, int[].class, 252, 7676, 7678)[0];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 252, 7666, 7668)[7], "CallChecker.isCalled(this.arr, int[].class, 252, 7666, 7668)[7]", 252, 7666, 7682);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 253, 7692, 7694)) {
                if (CallChecker.beforeDeref(arr, int[].class, 253, 7702, 7704)) {
                    CallChecker.isCalled(arr, int[].class, 253, 7692, 7694)[7] ^= (CallChecker.isCalled(arr, int[].class, 253, 7702, 7704)[0]) >>> 9;
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 253, 7692, 7694)[7], "CallChecker.isCalled(this.arr, int[].class, 253, 7692, 7694)[7]", 253, 7692, 7714);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 254, 7724, 7726)) {
                if (CallChecker.beforeDeref(arr, int[].class, 254, 7734, 7736)) {
                    CallChecker.isCalled(arr, int[].class, 254, 7724, 7726)[2] += CallChecker.isCalled(arr, int[].class, 254, 7734, 7736)[7];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 254, 7724, 7726)[2], "CallChecker.isCalled(this.arr, int[].class, 254, 7724, 7726)[2]", 254, 7724, 7740);
                }
            }
            if (CallChecker.beforeDeref(arr, int[].class, 255, 7750, 7752)) {
                if (CallChecker.beforeDeref(arr, int[].class, 255, 7760, 7762)) {
                    CallChecker.isCalled(arr, int[].class, 255, 7750, 7752)[0] += CallChecker.isCalled(arr, int[].class, 255, 7760, 7762)[1];
                    CallChecker.varAssign(CallChecker.isCalled(this.arr, int[].class, 255, 7750, 7752)[0], "CallChecker.isCalled(this.arr, int[].class, 255, 7750, 7752)[0]", 255, 7750, 7766);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4692.methodEnd();
        }
    }

    private void setState(int start) {
        MethodContext _bcornu_methode_context4693 = new MethodContext(void.class, 262, 7779, 8204);
        try {
            CallChecker.varInit(this, "this", 262, 7779, 8204);
            CallChecker.varInit(start, "start", 262, 7779, 8204);
            CallChecker.varInit(this.isaacJ, "isaacJ", 262, 7779, 8204);
            CallChecker.varInit(this.isaacI, "isaacI", 262, 7779, 8204);
            CallChecker.varInit(this.isaacX, "isaacX", 262, 7779, 8204);
            CallChecker.varInit(this.arr, "arr", 262, 7779, 8204);
            CallChecker.varInit(this.isaacC, "isaacC", 262, 7779, 8204);
            CallChecker.varInit(this.isaacB, "isaacB", 262, 7779, 8204);
            CallChecker.varInit(this.isaacA, "isaacA", 262, 7779, 8204);
            CallChecker.varInit(this.count, "count", 262, 7779, 8204);
            CallChecker.varInit(this.mem, "mem", 262, 7779, 8204);
            CallChecker.varInit(this.rsl, "rsl", 262, 7779, 8204);
            CallChecker.varInit(GLD_RATIO, "org.apache.commons.math3.random.ISAACRandom.GLD_RATIO", 262, 7779, 8204);
            CallChecker.varInit(MASK, "org.apache.commons.math3.random.ISAACRandom.MASK", 262, 7779, 8204);
            CallChecker.varInit(H_SIZE, "org.apache.commons.math3.random.ISAACRandom.H_SIZE", 262, 7779, 8204);
            CallChecker.varInit(SIZE, "org.apache.commons.math3.random.ISAACRandom.SIZE", 262, 7779, 8204);
            CallChecker.varInit(SIZE_L, "org.apache.commons.math3.random.ISAACRandom.SIZE_L", 262, 7779, 8204);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.ISAACRandom.serialVersionUID", 262, 7779, 8204);
            if (CallChecker.beforeDeref(mem, int[].class, 263, 7948, 7950)) {
                if (CallChecker.beforeDeref(arr, int[].class, 263, 7961, 7963)) {
                    CallChecker.isCalled(mem, int[].class, 263, 7948, 7950)[start] = CallChecker.isCalled(arr, int[].class, 263, 7961, 7963)[0];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 263, 7948, 7950)[start], "CallChecker.isCalled(this.mem, int[].class, 263, 7948, 7950)[start]", 263, 7948, 7967);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 264, 7977, 7979)) {
                if (CallChecker.beforeDeref(arr, int[].class, 264, 7994, 7996)) {
                    CallChecker.isCalled(mem, int[].class, 264, 7977, 7979)[(start + 1)] = CallChecker.isCalled(arr, int[].class, 264, 7994, 7996)[1];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 264, 7977, 7979)[(start + 1)], "CallChecker.isCalled(this.mem, int[].class, 264, 7977, 7979)[(start + 1)]", 264, 7977, 8000);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 265, 8010, 8012)) {
                if (CallChecker.beforeDeref(arr, int[].class, 265, 8027, 8029)) {
                    CallChecker.isCalled(mem, int[].class, 265, 8010, 8012)[(start + 2)] = CallChecker.isCalled(arr, int[].class, 265, 8027, 8029)[2];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 265, 8010, 8012)[(start + 2)], "CallChecker.isCalled(this.mem, int[].class, 265, 8010, 8012)[(start + 2)]", 265, 8010, 8033);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 266, 8043, 8045)) {
                if (CallChecker.beforeDeref(arr, int[].class, 266, 8060, 8062)) {
                    CallChecker.isCalled(mem, int[].class, 266, 8043, 8045)[(start + 3)] = CallChecker.isCalled(arr, int[].class, 266, 8060, 8062)[3];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 266, 8043, 8045)[(start + 3)], "CallChecker.isCalled(this.mem, int[].class, 266, 8043, 8045)[(start + 3)]", 266, 8043, 8066);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 267, 8076, 8078)) {
                if (CallChecker.beforeDeref(arr, int[].class, 267, 8093, 8095)) {
                    CallChecker.isCalled(mem, int[].class, 267, 8076, 8078)[(start + 4)] = CallChecker.isCalled(arr, int[].class, 267, 8093, 8095)[4];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 267, 8076, 8078)[(start + 4)], "CallChecker.isCalled(this.mem, int[].class, 267, 8076, 8078)[(start + 4)]", 267, 8076, 8099);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 268, 8109, 8111)) {
                if (CallChecker.beforeDeref(arr, int[].class, 268, 8126, 8128)) {
                    CallChecker.isCalled(mem, int[].class, 268, 8109, 8111)[(start + 5)] = CallChecker.isCalled(arr, int[].class, 268, 8126, 8128)[5];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 268, 8109, 8111)[(start + 5)], "CallChecker.isCalled(this.mem, int[].class, 268, 8109, 8111)[(start + 5)]", 268, 8109, 8132);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 269, 8142, 8144)) {
                if (CallChecker.beforeDeref(arr, int[].class, 269, 8159, 8161)) {
                    CallChecker.isCalled(mem, int[].class, 269, 8142, 8144)[(start + 6)] = CallChecker.isCalled(arr, int[].class, 269, 8159, 8161)[6];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 269, 8142, 8144)[(start + 6)], "CallChecker.isCalled(this.mem, int[].class, 269, 8142, 8144)[(start + 6)]", 269, 8142, 8165);
                }
            }
            if (CallChecker.beforeDeref(mem, int[].class, 270, 8175, 8177)) {
                if (CallChecker.beforeDeref(arr, int[].class, 270, 8192, 8194)) {
                    CallChecker.isCalled(mem, int[].class, 270, 8175, 8177)[(start + 7)] = CallChecker.isCalled(arr, int[].class, 270, 8192, 8194)[7];
                    CallChecker.varAssign(CallChecker.isCalled(this.mem, int[].class, 270, 8175, 8177)[(start + 7)], "CallChecker.isCalled(this.mem, int[].class, 270, 8175, 8177)[(start + 7)]", 270, 8175, 8198);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4693.methodEnd();
        }
    }
}

