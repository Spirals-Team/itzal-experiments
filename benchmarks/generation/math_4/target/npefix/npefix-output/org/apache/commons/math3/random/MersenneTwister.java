package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

public class MersenneTwister extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = 8661194735290153518L;

    private static final int N = 624;

    private static final int M = 397;

    private static final int[] MAG01 = new int[]{ 0 , -1727483681 };

    private int[] mt;

    private int mti;

    public MersenneTwister() {
        ConstructorContext _bcornu_methode_context110 = new ConstructorContext(MersenneTwister.class, 106, 4370, 4695);
        try {
            mt = new int[MersenneTwister.N];
            CallChecker.varAssign(this.mt, "this.mt", 107, 4597, 4612);
            setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public MersenneTwister(int seed) {
        ConstructorContext _bcornu_methode_context111 = new ConstructorContext(MersenneTwister.class, 114, 4702, 4922);
        try {
            mt = new int[MersenneTwister.N];
            CallChecker.varAssign(this.mt, "this.mt", 115, 4878, 4893);
            setSeed(seed);
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public MersenneTwister(int[] seed) {
        ConstructorContext _bcornu_methode_context112 = new ConstructorContext(MersenneTwister.class, 123, 4929, 5236);
        try {
            mt = new int[MersenneTwister.N];
            CallChecker.varAssign(this.mt, "this.mt", 124, 5192, 5207);
            setSeed(seed);
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public MersenneTwister(long seed) {
        ConstructorContext _bcornu_methode_context113 = new ConstructorContext(MersenneTwister.class, 131, 5243, 5465);
        try {
            mt = new int[MersenneTwister.N];
            CallChecker.varAssign(this.mt, "this.mt", 132, 5421, 5436);
            setSeed(seed);
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    @Override
    public void setSeed(int seed) {
        MethodContext _bcornu_methode_context425 = new MethodContext(void.class, 142, 5472, 6378);
        try {
            CallChecker.varInit(this, "this", 142, 5472, 6378);
            CallChecker.varInit(seed, "seed", 142, 5472, 6378);
            CallChecker.varInit(this.mti, "mti", 142, 5472, 6378);
            CallChecker.varInit(this.mt, "mt", 142, 5472, 6378);
            CallChecker.varInit(MAG01, "org.apache.commons.math3.random.MersenneTwister.MAG01", 142, 5472, 6378);
            CallChecker.varInit(M, "org.apache.commons.math3.random.MersenneTwister.M", 142, 5472, 6378);
            CallChecker.varInit(N, "org.apache.commons.math3.random.MersenneTwister.N", 142, 5472, 6378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.MersenneTwister.serialVersionUID", 142, 5472, 6378);
            long longMT = CallChecker.varInit(((long) (seed)), "longMT", 144, 5852, 5870);
            if (CallChecker.beforeDeref(mt, int[].class, 146, 5992, 5993)) {
                mt = CallChecker.beforeCalled(mt, int[].class, 146, 5992, 5993);
                CallChecker.isCalled(mt, int[].class, 146, 5992, 5993)[0] = ((int) (longMT));
                CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 146, 5992, 5993)[0], "CallChecker.isCalled(this.mt, int[].class, 146, 5992, 5993)[0]", 146, 5992, 6011);
            }
            for (mti = 1; (mti) < (MersenneTwister.N); ++(mti)) {
                CallChecker.varAssign(this.mti, "this.mti", 147, 6026, 6032);
                longMT = ((1812433253L * (longMT ^ (longMT >> 30))) + (mti)) & 4294967295L;
                CallChecker.varAssign(longMT, "longMT", 150, 6209, 6279);
                if (CallChecker.beforeDeref(mt, int[].class, 151, 6293, 6294)) {
                    mt = CallChecker.beforeCalled(mt, int[].class, 151, 6293, 6294);
                    CallChecker.isCalled(mt, int[].class, 151, 6293, 6294)[mti] = ((int) (longMT));
                    CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 151, 6293, 6294)[this.mti], "CallChecker.isCalled(this.mt, int[].class, 151, 6293, 6294)[this.mti]", 151, 6293, 6314);
                }
            }
            clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context425.methodEnd();
        }
    }

    @Override
    public void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context426 = new MethodContext(void.class, 165, 6385, 8212);
        try {
            CallChecker.varInit(this, "this", 165, 6385, 8212);
            CallChecker.varInit(seed, "seed", 165, 6385, 8212);
            CallChecker.varInit(this.mti, "mti", 165, 6385, 8212);
            CallChecker.varInit(this.mt, "mt", 165, 6385, 8212);
            CallChecker.varInit(MAG01, "org.apache.commons.math3.random.MersenneTwister.MAG01", 165, 6385, 8212);
            CallChecker.varInit(M, "org.apache.commons.math3.random.MersenneTwister.M", 165, 6385, 8212);
            CallChecker.varInit(N, "org.apache.commons.math3.random.MersenneTwister.N", 165, 6385, 8212);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.MersenneTwister.serialVersionUID", 165, 6385, 8212);
            if (seed == null) {
                setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
                return ;
            }
            setSeed(19650218);
            int i = CallChecker.varInit(((int) (1)), "i", 173, 7007, 7016);
            int j = CallChecker.varInit(((int) (0)), "j", 174, 7026, 7035);
            for (int k = FastMath.max(MersenneTwister.N, seed.length); k != 0; k--) {
                long l0 = CallChecker.init(long.class);
                if (CallChecker.beforeDeref(mt, int[].class, 177, 7127, 7128)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 177, 7154, 7155)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 177, 7127, 7128);
                        mt = CallChecker.beforeCalled(mt, int[].class, 177, 7154, 7155);
                        l0 = ((CallChecker.isCalled(mt, int[].class, 177, 7127, 7128)[i]) & 2147483647L) | ((CallChecker.isCalled(mt, int[].class, 177, 7154, 7155)[i]) < 0 ? 2147483648L : 0L);
                        CallChecker.varAssign(l0, "l0", 177, 7127, 7128);
                    }
                }
                long l1 = CallChecker.init(long.class);
                if (CallChecker.beforeDeref(mt, int[].class, 178, 7213, 7214)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 178, 7240, 7241)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 178, 7213, 7214);
                        mt = CallChecker.beforeCalled(mt, int[].class, 178, 7240, 7241);
                        l1 = ((CallChecker.isCalled(mt, int[].class, 178, 7213, 7214)[(i - 1)]) & 2147483647L) | ((CallChecker.isCalled(mt, int[].class, 178, 7240, 7241)[(i - 1)]) < 0 ? 2147483648L : 0L);
                        CallChecker.varAssign(l1, "l1", 178, 7213, 7214);
                    }
                }
                long l = CallChecker.varInit(((long) (((l0 ^ ((l1 ^ (l1 >> 30)) * 1664525L)) + (seed[j])) + j)), "l", 179, 7288, 7349);
                if (CallChecker.beforeDeref(mt, int[].class, 180, 7377, 7378)) {
                    mt = CallChecker.beforeCalled(mt, int[].class, 180, 7377, 7378);
                    CallChecker.isCalled(mt, int[].class, 180, 7377, 7378)[i] = ((int) (l & 4294967295L));
                    CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 180, 7377, 7378)[i], "CallChecker.isCalled(this.mt, int[].class, 180, 7377, 7378)[i]", 180, 7377, 7410);
                }
                i++;
                j++;
                if (i >= (MersenneTwister.N)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 183, 7476, 7477)) {
                        if (CallChecker.beforeDeref(mt, int[].class, 183, 7484, 7485)) {
                            mt = CallChecker.beforeCalled(mt, int[].class, 183, 7476, 7477);
                            mt = CallChecker.beforeCalled(mt, int[].class, 183, 7484, 7485);
                            CallChecker.isCalled(mt, int[].class, 183, 7476, 7477)[0] = CallChecker.isCalled(mt, int[].class, 183, 7484, 7485)[((MersenneTwister.N) - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 183, 7476, 7477)[0], "CallChecker.isCalled(this.mt, int[].class, 183, 7476, 7477)[0]", 183, 7476, 7493);
                        }
                    }
                    i = 1;
                    CallChecker.varAssign(i, "i", 184, 7511, 7516);
                }
                if (j >= (seed.length)) {
                    j = 0;
                    CallChecker.varAssign(j, "j", 187, 7584, 7589);
                }
            }
            for (int k = (MersenneTwister.N) - 1; k != 0; k--) {
                long l0 = CallChecker.init(long.class);
                if (CallChecker.beforeDeref(mt, int[].class, 192, 7682, 7683)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 192, 7709, 7710)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 192, 7682, 7683);
                        mt = CallChecker.beforeCalled(mt, int[].class, 192, 7709, 7710);
                        l0 = ((CallChecker.isCalled(mt, int[].class, 192, 7682, 7683)[i]) & 2147483647L) | ((CallChecker.isCalled(mt, int[].class, 192, 7709, 7710)[i]) < 0 ? 2147483648L : 0L);
                        CallChecker.varAssign(l0, "l0", 192, 7682, 7683);
                    }
                }
                long l1 = CallChecker.init(long.class);
                if (CallChecker.beforeDeref(mt, int[].class, 193, 7768, 7769)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 193, 7795, 7796)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 193, 7768, 7769);
                        mt = CallChecker.beforeCalled(mt, int[].class, 193, 7795, 7796);
                        l1 = ((CallChecker.isCalled(mt, int[].class, 193, 7768, 7769)[(i - 1)]) & 2147483647L) | ((CallChecker.isCalled(mt, int[].class, 193, 7795, 7796)[(i - 1)]) < 0 ? 2147483648L : 0L);
                        CallChecker.varAssign(l1, "l1", 193, 7768, 7769);
                    }
                }
                long l = CallChecker.varInit(((long) ((l0 ^ ((l1 ^ (l1 >> 30)) * 1566083941L)) - i)), "l", 194, 7843, 7897);
                if (CallChecker.beforeDeref(mt, int[].class, 195, 7925, 7926)) {
                    mt = CallChecker.beforeCalled(mt, int[].class, 195, 7925, 7926);
                    CallChecker.isCalled(mt, int[].class, 195, 7925, 7926)[i] = ((int) (l & 4294967295L));
                    CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 195, 7925, 7926)[i], "CallChecker.isCalled(this.mt, int[].class, 195, 7925, 7926)[i]", 195, 7925, 7958);
                }
                i++;
                if (i >= (MersenneTwister.N)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 198, 8019, 8020)) {
                        if (CallChecker.beforeDeref(mt, int[].class, 198, 8027, 8028)) {
                            mt = CallChecker.beforeCalled(mt, int[].class, 198, 8019, 8020);
                            mt = CallChecker.beforeCalled(mt, int[].class, 198, 8027, 8028);
                            CallChecker.isCalled(mt, int[].class, 198, 8019, 8020)[0] = CallChecker.isCalled(mt, int[].class, 198, 8027, 8028)[((MersenneTwister.N) - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 198, 8019, 8020)[0], "CallChecker.isCalled(this.mt, int[].class, 198, 8019, 8020)[0]", 198, 8019, 8036);
                        }
                    }
                    i = 1;
                    CallChecker.varAssign(i, "i", 199, 8054, 8059);
                }
            }
            if (CallChecker.beforeDeref(mt, int[].class, 203, 8094, 8095)) {
                mt = CallChecker.beforeCalled(mt, int[].class, 203, 8094, 8095);
                CallChecker.isCalled(mt, int[].class, 203, 8094, 8095)[0] = -2147483648;
                CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 203, 8094, 8095)[0], "CallChecker.isCalled(this.mt, int[].class, 203, 8094, 8095)[0]", 203, 8094, 8112);
            }
            clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context426.methodEnd();
        }
    }

    @Override
    public void setSeed(long seed) {
        MethodContext _bcornu_methode_context427 = new MethodContext(void.class, 215, 8219, 8603);
        try {
            CallChecker.varInit(this, "this", 215, 8219, 8603);
            CallChecker.varInit(seed, "seed", 215, 8219, 8603);
            CallChecker.varInit(this.mti, "mti", 215, 8219, 8603);
            CallChecker.varInit(this.mt, "mt", 215, 8219, 8603);
            CallChecker.varInit(MAG01, "org.apache.commons.math3.random.MersenneTwister.MAG01", 215, 8219, 8603);
            CallChecker.varInit(M, "org.apache.commons.math3.random.MersenneTwister.M", 215, 8219, 8603);
            CallChecker.varInit(N, "org.apache.commons.math3.random.MersenneTwister.N", 215, 8219, 8603);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.MersenneTwister.serialVersionUID", 215, 8219, 8603);
            setSeed(new int[]{ ((int) (seed >>> 32)) , ((int) (seed & 4294967295L)) });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context427.methodEnd();
        }
    }

    @Override
    protected int next(int bits) {
        MethodContext _bcornu_methode_context428 = new MethodContext(int.class, 229, 8610, 10160);
        try {
            CallChecker.varInit(this, "this", 229, 8610, 10160);
            CallChecker.varInit(bits, "bits", 229, 8610, 10160);
            CallChecker.varInit(this.mti, "mti", 229, 8610, 10160);
            CallChecker.varInit(this.mt, "mt", 229, 8610, 10160);
            CallChecker.varInit(MAG01, "org.apache.commons.math3.random.MersenneTwister.MAG01", 229, 8610, 10160);
            CallChecker.varInit(M, "org.apache.commons.math3.random.MersenneTwister.M", 229, 8610, 10160);
            CallChecker.varInit(N, "org.apache.commons.math3.random.MersenneTwister.N", 229, 8610, 10160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.MersenneTwister.serialVersionUID", 229, 8610, 10160);
            int y = CallChecker.init(int.class);
            if ((mti) >= (MersenneTwister.N)) {
                int mtNext = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(mt, int[].class, 234, 9247, 9248)) {
                    mt = CallChecker.beforeCalled(mt, int[].class, 234, 9247, 9248);
                    mtNext = CallChecker.isCalled(mt, int[].class, 234, 9247, 9248)[0];
                    CallChecker.varAssign(mtNext, "mtNext", 234, 9247, 9248);
                }
                for (int k = 0; k < ((MersenneTwister.N) - (MersenneTwister.M)); ++k) {
                    int mtCurr = CallChecker.varInit(((int) (mtNext)), "mtCurr", 236, 9316, 9335);
                    if (CallChecker.beforeDeref(mt, int[].class, 237, 9362, 9363)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 237, 9362, 9363);
                        mtNext = CallChecker.isCalled(mt, int[].class, 237, 9362, 9363)[(k + 1)];
                        CallChecker.varAssign(mtNext, "mtNext", 237, 9353, 9371);
                    }
                    y = (mtCurr & -2147483648) | (mtNext & 2147483647);
                    CallChecker.varAssign(y, "y", 238, 9389, 9438);
                    if (CallChecker.beforeDeref(mt, int[].class, 239, 9456, 9457)) {
                        if (CallChecker.beforeDeref(mt, int[].class, 239, 9464, 9465)) {
                            if (CallChecker.beforeDeref(MersenneTwister.MAG01, int[].class, 239, 9488, 9492)) {
                                mt = CallChecker.beforeCalled(mt, int[].class, 239, 9456, 9457);
                                mt = CallChecker.beforeCalled(mt, int[].class, 239, 9464, 9465);
                                CallChecker.isCalled(mt, int[].class, 239, 9456, 9457)[k] = ((CallChecker.isCalled(mt, int[].class, 239, 9464, 9465)[(k + (MersenneTwister.M))]) ^ (y >>> 1)) ^ (CallChecker.isCalled(MersenneTwister.MAG01, int[].class, 239, 9488, 9492)[(y & 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 239, 9456, 9457)[k], "CallChecker.isCalled(this.mt, int[].class, 239, 9456, 9457)[k]", 239, 9456, 9502);
                            }
                        }
                    }
                }
                for (int k = (MersenneTwister.N) - (MersenneTwister.M); k < ((MersenneTwister.N) - 1); ++k) {
                    int mtCurr = CallChecker.varInit(((int) (mtNext)), "mtCurr", 242, 9584, 9603);
                    if (CallChecker.beforeDeref(mt, int[].class, 243, 9630, 9631)) {
                        mt = CallChecker.beforeCalled(mt, int[].class, 243, 9630, 9631);
                        mtNext = CallChecker.isCalled(mt, int[].class, 243, 9630, 9631)[(k + 1)];
                        CallChecker.varAssign(mtNext, "mtNext", 243, 9621, 9639);
                    }
                    y = (mtCurr & -2147483648) | (mtNext & 2147483647);
                    CallChecker.varAssign(y, "y", 244, 9657, 9706);
                    if (CallChecker.beforeDeref(mt, int[].class, 245, 9724, 9725)) {
                        if (CallChecker.beforeDeref(mt, int[].class, 245, 9732, 9733)) {
                            if (CallChecker.beforeDeref(MersenneTwister.MAG01, int[].class, 245, 9762, 9766)) {
                                mt = CallChecker.beforeCalled(mt, int[].class, 245, 9724, 9725);
                                mt = CallChecker.beforeCalled(mt, int[].class, 245, 9732, 9733);
                                CallChecker.isCalled(mt, int[].class, 245, 9724, 9725)[k] = ((CallChecker.isCalled(mt, int[].class, 245, 9732, 9733)[(k + ((MersenneTwister.M) - (MersenneTwister.N)))]) ^ (y >>> 1)) ^ (CallChecker.isCalled(MersenneTwister.MAG01, int[].class, 245, 9762, 9766)[(y & 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 245, 9724, 9725)[k], "CallChecker.isCalled(this.mt, int[].class, 245, 9724, 9725)[k]", 245, 9724, 9776);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(mt, int[].class, 247, 9833, 9834)) {
                    mt = CallChecker.beforeCalled(mt, int[].class, 247, 9833, 9834);
                    y = (mtNext & -2147483648) | ((CallChecker.isCalled(mt, int[].class, 247, 9833, 9834)[0]) & 2147483647);
                    CallChecker.varAssign(y, "y", 247, 9804, 9852);
                }
                if (CallChecker.beforeDeref(mt, int[].class, 248, 9866, 9867)) {
                    if (CallChecker.beforeDeref(mt, int[].class, 248, 9878, 9879)) {
                        if (CallChecker.beforeDeref(MersenneTwister.MAG01, int[].class, 248, 9902, 9906)) {
                            mt = CallChecker.beforeCalled(mt, int[].class, 248, 9866, 9867);
                            mt = CallChecker.beforeCalled(mt, int[].class, 248, 9878, 9879);
                            CallChecker.isCalled(mt, int[].class, 248, 9866, 9867)[((MersenneTwister.N) - 1)] = ((CallChecker.isCalled(mt, int[].class, 248, 9878, 9879)[((MersenneTwister.M) - 1)]) ^ (y >>> 1)) ^ (CallChecker.isCalled(MersenneTwister.MAG01, int[].class, 248, 9902, 9906)[(y & 1)]);
                            CallChecker.varAssign(CallChecker.isCalled(this.mt, int[].class, 248, 9866, 9867)[((MersenneTwister.N) - 1)], "CallChecker.isCalled(this.mt, int[].class, 248, 9866, 9867)[((MersenneTwister.N) - 1)]", 248, 9866, 9916);
                        }
                    }
                }
                mti = 0;
                CallChecker.varAssign(this.mti, "this.mti", 250, 9931, 9938);
            }
            if (CallChecker.beforeDeref(mt, int[].class, 253, 9963, 9964)) {
                mt = CallChecker.beforeCalled(mt, int[].class, 253, 9963, 9964);
                y = CallChecker.isCalled(mt, int[].class, 253, 9963, 9964)[((mti)++)];
                CallChecker.varAssign(y, "y", 253, 9959, 9972);
            }
            y ^= y >>> 11;
            CallChecker.varAssign(y, "y", 256, 10004, 10018);
            y ^= (y << 7) & -1658038656;
            CallChecker.varAssign(y, "y", 257, 10028, 10056);
            y ^= (y << 15) & -272236544;
            CallChecker.varAssign(y, "y", 258, 10066, 10094);
            y ^= y >>> 18;
            CallChecker.varAssign(y, "y", 259, 10104, 10118);
            return y >>> (32 - bits);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context428.methodEnd();
        }
    }
}

