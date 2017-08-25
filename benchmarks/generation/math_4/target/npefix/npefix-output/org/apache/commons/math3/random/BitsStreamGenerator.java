package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

public abstract class BitsStreamGenerator implements Serializable , RandomGenerator {
    private static final long serialVersionUID = 20130104L;

    private double nextGaussian;

    public BitsStreamGenerator() {
        ConstructorContext _bcornu_methode_context154 = new ConstructorContext(BitsStreamGenerator.class, 40, 1377, 1509);
        try {
            nextGaussian = Double.NaN;
            CallChecker.varAssign(this.nextGaussian, "this.nextGaussian", 41, 1478, 1503);
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public abstract void setSeed(int seed);

    public abstract void setSeed(int[] seed);

    public abstract void setSeed(long seed);

    protected abstract int next(int bits);

    public boolean nextBoolean() {
        MethodContext _bcornu_methode_context560 = new MethodContext(boolean.class, 65, 2267, 2356);
        try {
            CallChecker.varInit(this, "this", 65, 2267, 2356);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 65, 2267, 2356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 65, 2267, 2356);
            return (next(1)) != 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context560.methodEnd();
        }
    }

    public void nextBytes(byte[] bytes) {
        MethodContext _bcornu_methode_context561 = new MethodContext(void.class, 70, 2363, 2981);
        try {
            CallChecker.varInit(this, "this", 70, 2363, 2981);
            CallChecker.varInit(bytes, "bytes", 70, 2363, 2981);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 70, 2363, 2981);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 70, 2363, 2981);
            int i = CallChecker.varInit(((int) (0)), "i", 71, 2434, 2443);
            bytes = CallChecker.beforeCalled(bytes, byte[].class, 72, 2470, 2474);
            final int iEnd = CallChecker.varInit(((int) ((CallChecker.isCalled(bytes, byte[].class, 72, 2470, 2474).length) - 3)), "iEnd", 72, 2453, 2486);
            while (i < iEnd) {
                final int random = CallChecker.varInit(((int) (next(32))), "random", 74, 2527, 2554);
                if (CallChecker.beforeDeref(bytes, byte[].class, 75, 2568, 2572)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 75, 2568, 2572);
                    CallChecker.isCalled(bytes, byte[].class, 75, 2568, 2572)[i] = ((byte) (random & 255));
                    CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 75, 2568, 2572)[i], "CallChecker.isCalled(bytes, byte[].class, 75, 2568, 2572)[i]", 75, 2568, 2605);
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 76, 2619, 2623)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 76, 2619, 2623);
                    CallChecker.isCalled(bytes, byte[].class, 76, 2619, 2623)[(i + 1)] = ((byte) ((random >> 8) & 255));
                    CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 76, 2619, 2623)[(i + 1)], "CallChecker.isCalled(bytes, byte[].class, 76, 2619, 2623)[(i + 1)]", 76, 2619, 2664);
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 77, 2678, 2682)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 77, 2678, 2682);
                    CallChecker.isCalled(bytes, byte[].class, 77, 2678, 2682)[(i + 2)] = ((byte) ((random >> 16) & 255));
                    CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 77, 2678, 2682)[(i + 2)], "CallChecker.isCalled(bytes, byte[].class, 77, 2678, 2682)[(i + 2)]", 77, 2678, 2723);
                }
                if (CallChecker.beforeDeref(bytes, byte[].class, 78, 2737, 2741)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 78, 2737, 2741);
                    CallChecker.isCalled(bytes, byte[].class, 78, 2737, 2741)[(i + 3)] = ((byte) ((random >> 24) & 255));
                    CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 78, 2737, 2741)[(i + 3)], "CallChecker.isCalled(bytes, byte[].class, 78, 2737, 2741)[(i + 3)]", 78, 2737, 2782);
                }
                i += 4;
                CallChecker.varAssign(i, "i", 79, 2796, 2802);
            } 
            int random = CallChecker.varInit(((int) (next(32))), "random", 81, 2822, 2843);
            bytes = CallChecker.beforeCalled(bytes, byte[].class, 82, 2864, 2868);
            while (i < (CallChecker.isCalled(bytes, byte[].class, 82, 2864, 2868).length)) {
                if (CallChecker.beforeDeref(bytes, byte[].class, 83, 2892, 2896)) {
                    bytes = CallChecker.beforeCalled(bytes, byte[].class, 83, 2892, 2896);
                    CallChecker.isCalled(bytes, byte[].class, 83, 2892, 2896)[(i++)] = ((byte) (random & 255));
                    CallChecker.varAssign(CallChecker.isCalled(bytes, byte[].class, 83, 2892, 2896)[(i - 1)], "CallChecker.isCalled(bytes, byte[].class, 83, 2892, 2896)[(i - 1)]", 83, 2892, 2927);
                }
                random = random >> 8;
                CallChecker.varAssign(random, "random", 84, 2941, 2965);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context561.methodEnd();
        }
    }

    public double nextDouble() {
        MethodContext _bcornu_methode_context562 = new MethodContext(double.class, 89, 2988, 3175);
        try {
            CallChecker.varInit(this, "this", 89, 2988, 3175);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 89, 2988, 3175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 89, 2988, 3175);
            final long high = CallChecker.varInit(((long) (((long) (next(26))) << 26)), "high", 90, 3050, 3091);
            final int low = CallChecker.varInit(((int) (next(26))), "low", 91, 3101, 3127);
            return (high | low) * 2.220446049250313E-16;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context562.methodEnd();
        }
    }

    public float nextFloat() {
        MethodContext _bcornu_methode_context563 = new MethodContext(float.class, 96, 3182, 3276);
        try {
            CallChecker.varInit(this, "this", 96, 3182, 3276);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 96, 3182, 3276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 96, 3182, 3276);
            return (next(23)) * 1.1920929E-7F;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context563.methodEnd();
        }
    }

    public double nextGaussian() {
        MethodContext _bcornu_methode_context564 = new MethodContext(double.class, 101, 3283, 3979);
        try {
            CallChecker.varInit(this, "this", 101, 3283, 3979);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 101, 3283, 3979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 101, 3283, 3979);
            double random = CallChecker.init(double.class);
            if (Double.isNaN(nextGaussian)) {
                final double x = CallChecker.varInit(((double) (nextDouble())), "x", 106, 3423, 3507);
                final double y = CallChecker.varInit(((double) (nextDouble())), "y", 107, 3521, 3550);
                final double alpha = CallChecker.varInit(((double) ((2 * (FastMath.PI)) * x)), "alpha", 108, 3564, 3604);
                final double r = CallChecker.varInit(((double) (FastMath.sqrt(((-2) * (FastMath.log(y)))))), "r", 109, 3618, 3675);
                random = r * (FastMath.cos(alpha));
                CallChecker.varAssign(random, "random", 110, 3689, 3727);
                nextGaussian = r * (FastMath.sin(alpha));
                CallChecker.varAssign(this.nextGaussian, "this.nextGaussian", 111, 3741, 3779);
            }else {
                random = nextGaussian;
                CallChecker.varAssign(random, "random", 114, 3878, 3899);
                nextGaussian = Double.NaN;
                CallChecker.varAssign(this.nextGaussian, "this.nextGaussian", 115, 3913, 3938);
            }
            return random;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context564.methodEnd();
        }
    }

    public int nextInt() {
        MethodContext _bcornu_methode_context565 = new MethodContext(int.class, 123, 3986, 4063);
        try {
            CallChecker.varInit(this, "this", 123, 3986, 4063);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 123, 3986, 4063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 123, 3986, 4063);
            return next(32);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context565.methodEnd();
        }
    }

    public int nextInt(int n) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context566 = new MethodContext(int.class, 142, 4070, 5178);
        try {
            CallChecker.varInit(this, "this", 142, 4070, 5178);
            CallChecker.varInit(n, "n", 142, 4070, 5178);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 142, 4070, 5178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 142, 4070, 5178);
            if (n > 0) {
                if ((n & (-n)) == n) {
                    return ((int) ((n * ((long) (next(31)))) >> 31));
                }
                int bits = CallChecker.init(int.class);
                int val = CallChecker.init(int.class);
                do {
                    bits = next(31);
                    CallChecker.varAssign(bits, "bits", 150, 4992, 5007);
                    val = bits % n;
                    CallChecker.varAssign(val, "val", 151, 5025, 5039);
                } while (((bits - val) + (n - 1)) < 0 );
                return val;
            }
            throw new NotStrictlyPositiveException(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context566.methodEnd();
        }
    }

    public long nextLong() {
        MethodContext _bcornu_methode_context567 = new MethodContext(long.class, 159, 5185, 5378);
        try {
            CallChecker.varInit(this, "this", 159, 5185, 5378);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 159, 5185, 5378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 159, 5185, 5378);
            final long high = CallChecker.varInit(((long) (((long) (next(32))) << 32)), "high", 160, 5243, 5285);
            final long low = CallChecker.varInit(((long) (((long) (next(32))) & 4294967295L)), "low", 161, 5295, 5345);
            return high | low;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context567.methodEnd();
        }
    }

    public long nextLong(long n) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context568 = new MethodContext(long.class, 176, 5385, 6309);
        try {
            CallChecker.varInit(this, "this", 176, 5385, 6309);
            CallChecker.varInit(n, "n", 176, 5385, 6309);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 176, 5385, 6309);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 176, 5385, 6309);
            if (n > 0) {
                long bits = CallChecker.init(long.class);
                long val = CallChecker.init(long.class);
                do {
                    bits = ((long) (next(31))) << 32;
                    CallChecker.varAssign(bits, "bits", 181, 6042, 6072);
                    bits = bits | (((long) (next(32))) & 4294967295L);
                    CallChecker.varAssign(bits, "bits", 182, 6090, 6137);
                    val = bits % n;
                    CallChecker.varAssign(val, "val", 183, 6155, 6170);
                } while (((bits - val) + (n - 1)) < 0 );
                return val;
            }
            throw new NotStrictlyPositiveException(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context568.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context569 = new MethodContext(void.class, 194, 6316, 6485);
        try {
            CallChecker.varInit(this, "this", 194, 6316, 6485);
            CallChecker.varInit(this.nextGaussian, "nextGaussian", 194, 6316, 6485);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.BitsStreamGenerator.serialVersionUID", 194, 6316, 6485);
            nextGaussian = Double.NaN;
            CallChecker.varAssign(this.nextGaussian, "this.nextGaussian", 195, 6454, 6479);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context569.methodEnd();
        }
    }
}

