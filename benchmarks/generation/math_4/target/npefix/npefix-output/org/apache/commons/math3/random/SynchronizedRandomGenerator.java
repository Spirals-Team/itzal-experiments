package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class SynchronizedRandomGenerator implements RandomGenerator {
    private final RandomGenerator wrapped;

    public SynchronizedRandomGenerator(RandomGenerator rng) {
        ConstructorContext _bcornu_methode_context709 = new ConstructorContext(SynchronizedRandomGenerator.class, 42, 1328, 1751);
        try {
            wrapped = rng;
            CallChecker.varAssign(this.wrapped, "this.wrapped", 43, 1732, 1745);
        } finally {
            _bcornu_methode_context709.methodEnd();
        }
    }

    public synchronized void setSeed(int seed) {
        MethodContext _bcornu_methode_context3119 = new MethodContext(void.class, 49, 1758, 1875);
        try {
            CallChecker.varInit(this, "this", 49, 1758, 1875);
            CallChecker.varInit(seed, "seed", 49, 1758, 1875);
            CallChecker.varInit(this.wrapped, "wrapped", 49, 1758, 1875);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 50, 1848, 1854)) {
                CallChecker.isCalled(wrapped, RandomGenerator.class, 50, 1848, 1854).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3119.methodEnd();
        }
    }

    public synchronized void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context3120 = new MethodContext(void.class, 56, 1882, 2001);
        try {
            CallChecker.varInit(this, "this", 56, 1882, 2001);
            CallChecker.varInit(seed, "seed", 56, 1882, 2001);
            CallChecker.varInit(this.wrapped, "wrapped", 56, 1882, 2001);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 57, 1974, 1980)) {
                CallChecker.isCalled(wrapped, RandomGenerator.class, 57, 1974, 1980).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3120.methodEnd();
        }
    }

    public synchronized void setSeed(long seed) {
        MethodContext _bcornu_methode_context3121 = new MethodContext(void.class, 63, 2008, 2126);
        try {
            CallChecker.varInit(this, "this", 63, 2008, 2126);
            CallChecker.varInit(seed, "seed", 63, 2008, 2126);
            CallChecker.varInit(this.wrapped, "wrapped", 63, 2008, 2126);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 64, 2099, 2105)) {
                CallChecker.isCalled(wrapped, RandomGenerator.class, 64, 2099, 2105).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3121.methodEnd();
        }
    }

    public synchronized void nextBytes(byte[] bytes) {
        MethodContext _bcornu_methode_context3122 = new MethodContext(void.class, 70, 2133, 2259);
        try {
            CallChecker.varInit(this, "this", 70, 2133, 2259);
            CallChecker.varInit(bytes, "bytes", 70, 2133, 2259);
            CallChecker.varInit(this.wrapped, "wrapped", 70, 2133, 2259);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 71, 2229, 2235)) {
                CallChecker.isCalled(wrapped, RandomGenerator.class, 71, 2229, 2235).nextBytes(bytes);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3122.methodEnd();
        }
    }

    public synchronized int nextInt() {
        MethodContext _bcornu_methode_context3123 = new MethodContext(int.class, 77, 2266, 2377);
        try {
            CallChecker.varInit(this, "this", 77, 2266, 2377);
            CallChecker.varInit(this.wrapped, "wrapped", 77, 2266, 2377);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 78, 2354, 2360)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 78, 2354, 2360).nextInt();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3123.methodEnd();
        }
    }

    public synchronized int nextInt(int n) {
        MethodContext _bcornu_methode_context3124 = new MethodContext(int.class, 84, 2384, 2501);
        try {
            CallChecker.varInit(this, "this", 84, 2384, 2501);
            CallChecker.varInit(n, "n", 84, 2384, 2501);
            CallChecker.varInit(this.wrapped, "wrapped", 84, 2384, 2501);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 85, 2477, 2483)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 85, 2477, 2483).nextInt(n);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3124.methodEnd();
        }
    }

    public synchronized long nextLong() {
        MethodContext _bcornu_methode_context3125 = new MethodContext(long.class, 91, 2508, 2622);
        try {
            CallChecker.varInit(this, "this", 91, 2508, 2622);
            CallChecker.varInit(this.wrapped, "wrapped", 91, 2508, 2622);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 92, 2598, 2604)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 92, 2598, 2604).nextLong();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3125.methodEnd();
        }
    }

    public synchronized boolean nextBoolean() {
        MethodContext _bcornu_methode_context3126 = new MethodContext(boolean.class, 98, 2629, 2752);
        try {
            CallChecker.varInit(this, "this", 98, 2629, 2752);
            CallChecker.varInit(this.wrapped, "wrapped", 98, 2629, 2752);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 99, 2725, 2731)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 99, 2725, 2731).nextBoolean();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3126.methodEnd();
        }
    }

    public synchronized float nextFloat() {
        MethodContext _bcornu_methode_context3127 = new MethodContext(float.class, 105, 2759, 2876);
        try {
            CallChecker.varInit(this, "this", 105, 2759, 2876);
            CallChecker.varInit(this.wrapped, "wrapped", 105, 2759, 2876);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 106, 2851, 2857)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 106, 2851, 2857).nextFloat();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3127.methodEnd();
        }
    }

    public synchronized double nextDouble() {
        MethodContext _bcornu_methode_context3128 = new MethodContext(double.class, 112, 2883, 3003);
        try {
            CallChecker.varInit(this, "this", 112, 2883, 3003);
            CallChecker.varInit(this.wrapped, "wrapped", 112, 2883, 3003);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 113, 2977, 2983)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 113, 2977, 2983).nextDouble();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3128.methodEnd();
        }
    }

    public synchronized double nextGaussian() {
        MethodContext _bcornu_methode_context3129 = new MethodContext(double.class, 119, 3010, 3134);
        try {
            CallChecker.varInit(this, "this", 119, 3010, 3134);
            CallChecker.varInit(this.wrapped, "wrapped", 119, 3010, 3134);
            if (CallChecker.beforeDeref(wrapped, RandomGenerator.class, 120, 3106, 3112)) {
                return CallChecker.isCalled(wrapped, RandomGenerator.class, 120, 3106, 3112).nextGaussian();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3129.methodEnd();
        }
    }
}

