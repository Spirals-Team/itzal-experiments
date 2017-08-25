package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

public abstract class AbstractRandomGenerator implements RandomGenerator {
    private double cachedNormalDeviate = Double.NaN;

    public AbstractRandomGenerator() {
        super();
        ConstructorContext _bcornu_methode_context264 = new ConstructorContext(AbstractRandomGenerator.class, 50, 2009, 2118);
        try {
        } finally {
            _bcornu_methode_context264.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1153 = new MethodContext(void.class, 61, 2125, 2475);
        try {
            CallChecker.varInit(this, "this", 61, 2125, 2475);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 61, 2125, 2475);
            cachedNormalDeviate = Double.NaN;
            CallChecker.varAssign(this.cachedNormalDeviate, "this.cachedNormalDeviate", 62, 2437, 2469);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1153.methodEnd();
        }
    }

    public void setSeed(int seed) {
        MethodContext _bcornu_methode_context1154 = new MethodContext(void.class, 66, 2482, 2573);
        try {
            CallChecker.varInit(this, "this", 66, 2482, 2573);
            CallChecker.varInit(seed, "seed", 66, 2482, 2573);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 66, 2482, 2573);
            setSeed(((long) (seed)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1154.methodEnd();
        }
    }

    public void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context1155 = new MethodContext(void.class, 71, 2580, 2914);
        try {
            CallChecker.varInit(this, "this", 71, 2580, 2914);
            CallChecker.varInit(seed, "seed", 71, 2580, 2914);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 71, 2580, 2914);
            final long prime = CallChecker.varInit(((long) (4294967291L)), "prime", 73, 2647, 2768);
            long combined = CallChecker.varInit(((long) (0L)), "combined", 75, 2779, 2797);
            if (CallChecker.beforeDeref(seed, void.class, 76, 2820, 2823)) {
                for (int s : seed) {
                    combined = (combined * prime) + s;
                    CallChecker.varAssign(combined, "combined", 77, 2840, 2871);
                }
            }
            setSeed(combined);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1155.methodEnd();
        }
    }

    public abstract void setSeed(long seed);

    public void nextBytes(byte[] bytes) {
        MethodContext _bcornu_methode_context1157 = new MethodContext(void.class, 106, 3411, 4269);
        try {
            CallChecker.varInit(this, "this", 106, 3411, 4269);
            CallChecker.varInit(bytes, "bytes", 106, 3411, 4269);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 106, 3411, 4269);
            int bytesOut = CallChecker.varInit(((int) (0)), "bytesOut", 107, 3884, 3900);
            bytes = CallChecker.beforeCalled(bytes, byte[].class, 108, 3928, 3932);
            while (bytesOut < (CallChecker.isCalled(bytes, byte[].class, 108, 3928, 3932).length)) {
                int randInt = CallChecker.varInit(((int) (nextInt())), "randInt", 109, 3954, 3977);
                for (int i = 0; i < 3; i++) {
                    if (i > 0) {
                        randInt = randInt >> 8;
                        CallChecker.varAssign(randInt, "randInt", 112, 4065, 4087);
                    }
                    if (CallChecker.beforeDeref(bytes, byte[].class, 114, 4119, 4123)) {
                        bytes = CallChecker.beforeCalled(bytes, byte[].class, 114, 4119, 4123);
                        CallChecker.isCalled(bytes, byte[].class, 114, 4119, 4123)[(bytesOut++)] = ((byte) (randInt));
                        CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 114, 4119, 4123)[(bytesOut - 1)], "CallChecker.isCalled(bytes, byte[].class, 114, 4119, 4123)[(bytesOut - 1)]", 114, 4119, 4153);
                    }
                    if (CallChecker.beforeDeref(bytes, byte[].class, 115, 4185, 4189)) {
                        bytes = CallChecker.beforeCalled(bytes, byte[].class, 115, 4185, 4189);
                        if (bytesOut == (CallChecker.isCalled(bytes, byte[].class, 115, 4185, 4189).length)) {
                            return ;
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1157.methodEnd();
        }
    }

    public int nextInt() {
        MethodContext _bcornu_methode_context1158 = new MethodContext(int.class, 136, 4277, 4961);
        try {
            CallChecker.varInit(this, "this", 136, 4277, 4961);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 136, 4277, 4961);
            return ((int) (((2.0 * (nextDouble())) - 1.0) * (Integer.MAX_VALUE)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1158.methodEnd();
        }
    }

    public int nextInt(int n) {
        MethodContext _bcornu_methode_context1159 = new MethodContext(int.class, 156, 4968, 5798);
        try {
            CallChecker.varInit(this, "this", 156, 4968, 5798);
            CallChecker.varInit(n, "n", 156, 4968, 5798);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 156, 4968, 5798);
            if (n <= 0) {
                throw new NotStrictlyPositiveException(n);
            }
            int result = CallChecker.varInit(((int) ((int) ((nextDouble()) * n))), "result", 160, 5711, 5748);
            if (result < n) {
                return result;
            }else {
                return n - 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1159.methodEnd();
        }
    }

    public long nextLong() {
        MethodContext _bcornu_methode_context1160 = new MethodContext(long.class, 178, 5806, 6476);
        try {
            CallChecker.varInit(this, "this", 178, 5806, 6476);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 178, 5806, 6476);
            return ((long) (((2.0 * (nextDouble())) - 1.0) * (Long.MAX_VALUE)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1160.methodEnd();
        }
    }

    public boolean nextBoolean() {
        MethodContext _bcornu_methode_context1161 = new MethodContext(boolean.class, 196, 6483, 6985);
        try {
            CallChecker.varInit(this, "this", 196, 6483, 6985);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 196, 6483, 6985);
            return (nextDouble()) <= 0.5;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1161.methodEnd();
        }
    }

    public float nextFloat() {
        MethodContext _bcornu_methode_context1162 = new MethodContext(float.class, 214, 6993, 7562);
        try {
            CallChecker.varInit(this, "this", 214, 6993, 7562);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 214, 6993, 7562);
            return ((float) (nextDouble()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1162.methodEnd();
        }
    }

    public abstract double nextDouble();

    public double nextGaussian() {
        MethodContext _bcornu_methode_context1164 = new MethodContext(double.class, 252, 8104, 9718);
        try {
            CallChecker.varInit(this, "this", 252, 8104, 9718);
            CallChecker.varInit(this.cachedNormalDeviate, "cachedNormalDeviate", 252, 8104, 9718);
            if (!(Double.isNaN(cachedNormalDeviate))) {
                double dev = CallChecker.varInit(((double) (this.cachedNormalDeviate)), "dev", 254, 9234, 9266);
                cachedNormalDeviate = Double.NaN;
                CallChecker.varAssign(this.cachedNormalDeviate, "this.cachedNormalDeviate", 255, 9280, 9312);
                return dev;
            }
            double v1 = CallChecker.varInit(((double) (0)), "v1", 258, 9356, 9369);
            double v2 = CallChecker.varInit(((double) (0)), "v2", 259, 9379, 9392);
            double s = CallChecker.varInit(((double) (1)), "s", 260, 9402, 9414);
            while (s >= 1) {
                v1 = (2 * (nextDouble())) - 1;
                CallChecker.varAssign(v1, "v1", 262, 9453, 9478);
                v2 = (2 * (nextDouble())) - 1;
                CallChecker.varAssign(v2, "v2", 263, 9492, 9517);
                s = (v1 * v1) + (v2 * v2);
                CallChecker.varAssign(s, "s", 264, 9531, 9552);
            } 
            if (s != 0) {
                s = FastMath.sqrt((((-2) * (FastMath.log(s))) / s));
                CallChecker.varAssign(s, "s", 267, 9598, 9641);
            }
            cachedNormalDeviate = v2 * s;
            CallChecker.varAssign(this.cachedNormalDeviate, "this.cachedNormalDeviate", 269, 9661, 9689);
            return v1 * s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1164.methodEnd();
        }
    }
}

