package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Random;

public class RandomAdaptor extends Random implements RandomGenerator {
    private static final long serialVersionUID = 2306581345647615033L;

    private final RandomGenerator randomGenerator;

    @SuppressWarnings(value = "unused")
    private RandomAdaptor() {
        ConstructorContext _bcornu_methode_context1052 = new ConstructorContext(RandomAdaptor.class, 40, 1286, 1442);
        try {
            randomGenerator = null;
            CallChecker.varAssign(this.randomGenerator, "this.randomGenerator", 40, 1418, 1440);
        } finally {
            _bcornu_methode_context1052.methodEnd();
        }
    }

    public RandomAdaptor(RandomGenerator randomGenerator) {
        ConstructorContext _bcornu_methode_context1053 = new ConstructorContext(RandomAdaptor.class, 47, 1449, 1705);
        try {
            this.randomGenerator = randomGenerator;
            CallChecker.varAssign(this.randomGenerator, "this.randomGenerator", 48, 1661, 1699);
        } finally {
            _bcornu_methode_context1053.methodEnd();
        }
    }

    public static Random createAdaptor(RandomGenerator randomGenerator) {
        MethodContext _bcornu_methode_context4634 = new MethodContext(Random.class, 58, 1712, 2096);
        try {
            CallChecker.varInit(randomGenerator, "randomGenerator", 58, 1712, 2096);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 58, 1712, 2096);
            return new RandomAdaptor(randomGenerator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Random) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4634.methodEnd();
        }
    }

    @Override
    public boolean nextBoolean() {
        MethodContext _bcornu_methode_context4635 = new MethodContext(boolean.class, 72, 2103, 2515);
        try {
            CallChecker.varInit(this, "this", 72, 2103, 2515);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 72, 2103, 2515);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 72, 2103, 2515);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 73, 2480, 2494)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 73, 2480, 2494).nextBoolean();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4635.methodEnd();
        }
    }

    @Override
    public void nextBytes(byte[] bytes) {
        MethodContext _bcornu_methode_context4636 = new MethodContext(void.class, 85, 2523, 2900);
        try {
            CallChecker.varInit(this, "this", 85, 2523, 2900);
            CallChecker.varInit(bytes, "bytes", 85, 2523, 2900);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 85, 2523, 2900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 85, 2523, 2900);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 86, 2862, 2876)) {
                CallChecker.isCalled(randomGenerator, RandomGenerator.class, 86, 2862, 2876).nextBytes(bytes);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4636.methodEnd();
        }
    }

    @Override
    public double nextDouble() {
        MethodContext _bcornu_methode_context4637 = new MethodContext(double.class, 99, 2908, 3409);
        try {
            CallChecker.varInit(this, "this", 99, 2908, 3409);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 99, 2908, 3409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 99, 2908, 3409);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 100, 3375, 3389)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 100, 3375, 3389).nextDouble();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4637.methodEnd();
        }
    }

    @Override
    public float nextFloat() {
        MethodContext _bcornu_methode_context4638 = new MethodContext(float.class, 113, 3416, 3910);
        try {
            CallChecker.varInit(this, "this", 113, 3416, 3910);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 113, 3416, 3910);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 113, 3416, 3910);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 114, 3877, 3891)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 114, 3877, 3891).nextFloat();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4638.methodEnd();
        }
    }

    @Override
    public double nextGaussian() {
        MethodContext _bcornu_methode_context4639 = new MethodContext(double.class, 128, 3917, 4494);
        try {
            CallChecker.varInit(this, "this", 128, 3917, 4494);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 128, 3917, 4494);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 128, 3917, 4494);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 129, 4458, 4472)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 129, 4458, 4472).nextGaussian();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4639.methodEnd();
        }
    }

    @Override
    public int nextInt() {
        MethodContext _bcornu_methode_context4640 = new MethodContext(int.class, 142, 4502, 5025);
        try {
            CallChecker.varInit(this, "this", 142, 4502, 5025);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 142, 4502, 5025);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 142, 4502, 5025);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 143, 4994, 5008)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 143, 4994, 5008).nextInt();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4640.methodEnd();
        }
    }

    @Override
    public int nextInt(int n) {
        MethodContext _bcornu_methode_context4641 = new MethodContext(int.class, 158, 5032, 5614);
        try {
            CallChecker.varInit(this, "this", 158, 5032, 5614);
            CallChecker.varInit(n, "n", 158, 5032, 5614);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 158, 5032, 5614);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 158, 5032, 5614);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 159, 5582, 5596)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 159, 5582, 5596).nextInt(n);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4641.methodEnd();
        }
    }

    @Override
    public long nextLong() {
        MethodContext _bcornu_methode_context4642 = new MethodContext(long.class, 172, 5621, 6149);
        try {
            CallChecker.varInit(this, "this", 172, 5621, 6149);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 172, 5621, 6149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 172, 5621, 6149);
            if (CallChecker.beforeDeref(randomGenerator, RandomGenerator.class, 173, 6117, 6131)) {
                return CallChecker.isCalled(randomGenerator, RandomGenerator.class, 173, 6117, 6131).nextLong();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4642.methodEnd();
        }
    }

    public void setSeed(int seed) {
        MethodContext _bcornu_methode_context4643 = new MethodContext(void.class, 177, 6156, 6350);
        try {
            CallChecker.varInit(this, "this", 177, 6156, 6350);
            CallChecker.varInit(seed, "seed", 177, 6156, 6350);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 177, 6156, 6350);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 177, 6156, 6350);
            if ((randomGenerator) != null) {
                randomGenerator.setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4643.methodEnd();
        }
    }

    public void setSeed(int[] seed) {
        MethodContext _bcornu_methode_context4644 = new MethodContext(void.class, 184, 6357, 6553);
        try {
            CallChecker.varInit(this, "this", 184, 6357, 6553);
            CallChecker.varInit(seed, "seed", 184, 6357, 6553);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 184, 6357, 6553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 184, 6357, 6553);
            if ((randomGenerator) != null) {
                randomGenerator.setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4644.methodEnd();
        }
    }

    @Override
    public void setSeed(long seed) {
        MethodContext _bcornu_methode_context4645 = new MethodContext(void.class, 192, 6560, 6769);
        try {
            CallChecker.varInit(this, "this", 192, 6560, 6769);
            CallChecker.varInit(seed, "seed", 192, 6560, 6769);
            CallChecker.varInit(this.randomGenerator, "randomGenerator", 192, 6560, 6769);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomAdaptor.serialVersionUID", 192, 6560, 6769);
            if ((randomGenerator) != null) {
                randomGenerator.setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4645.methodEnd();
        }
    }
}

