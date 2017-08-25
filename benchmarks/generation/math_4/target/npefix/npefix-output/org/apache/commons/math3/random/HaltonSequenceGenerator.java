package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathUtils;

public class HaltonSequenceGenerator implements RandomVectorGenerator {
    private static final int[] PRIMES = new int[]{ 2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 , 67 , 71 , 73 , 79 , 83 , 89 , 97 , 101 , 103 , 107 , 109 , 113 , 127 , 131 , 137 , 139 , 149 , 151 , 157 , 163 , 167 , 173 };

    private static final int[] WEIGHTS = new int[]{ 1 , 2 , 3 , 3 , 8 , 11 , 12 , 14 , 7 , 18 , 12 , 13 , 17 , 18 , 29 , 14 , 18 , 43 , 41 , 44 , 40 , 30 , 47 , 65 , 71 , 28 , 40 , 60 , 79 , 89 , 56 , 50 , 52 , 61 , 108 , 56 , 66 , 63 , 60 , 66 };

    private final int dimension;

    private int count = 0;

    private final int[] base;

    private final int[] weight;

    public HaltonSequenceGenerator(final int dimension) throws OutOfRangeException {
        this(dimension, HaltonSequenceGenerator.PRIMES, HaltonSequenceGenerator.WEIGHTS);
        ConstructorContext _bcornu_methode_context241 = new ConstructorContext(HaltonSequenceGenerator.class, 89, 3461, 3833);
        try {
        } finally {
            _bcornu_methode_context241.methodEnd();
        }
    }

    public HaltonSequenceGenerator(final int dimension, final int[] bases, final int[] weights) throws DimensionMismatchException, NullArgumentException, OutOfRangeException {
        ConstructorContext _bcornu_methode_context242 = new ConstructorContext(HaltonSequenceGenerator.class, 105, 3840, 5322);
        try {
            MathUtils.checkNotNull(bases);
            if (CallChecker.beforeDeref(bases, int[].class, 110, 4909, 4913)) {
                if ((dimension < 1) || (dimension > (CallChecker.isCalled(bases, int[].class, 110, 4909, 4913).length))) {
                    if (CallChecker.beforeDeref(HaltonSequenceGenerator.PRIMES, int[].class, 111, 4981, 4986)) {
                        throw new OutOfRangeException(dimension, 1, CallChecker.isCalled(HaltonSequenceGenerator.PRIMES, int[].class, 111, 4981, 4986).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(bases, int[].class, 114, 5057, 5061)) {
                if ((weights != null) && ((weights.length) != (CallChecker.isCalled(bases, int[].class, 114, 5057, 5061).length))) {
                    if (CallChecker.beforeDeref(bases, int[].class, 115, 5138, 5142)) {
                        throw new DimensionMismatchException(weights.length, CallChecker.isCalled(bases, int[].class, 115, 5138, 5142).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            this.dimension = dimension;
            CallChecker.varAssign(this.dimension, "this.dimension", 118, 5172, 5198);
            this.base = CallChecker.isCalled(bases, int[].class, 119, 5220, 5224).clone();
            CallChecker.varAssign(this.base, "this.base", 119, 5208, 5233);
            if (weights == null) {
                this.weight = null;
                CallChecker.varAssign(this.weight, "this.weight", 120, 5243, 5297);
            }else {
                this.weight = weights.clone();
                CallChecker.varAssign(this.weight, "this.weight", 120, 5243, 5297);
            }
            count = 0;
            CallChecker.varAssign(this.count, "this.count", 121, 5307, 5316);
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    public double[] nextVector() {
        MethodContext _bcornu_methode_context983 = new MethodContext(double[].class, 125, 5329, 5869);
        try {
            CallChecker.varInit(this, "this", 125, 5329, 5869);
            CallChecker.varInit(this.weight, "weight", 125, 5329, 5869);
            CallChecker.varInit(this.base, "base", 125, 5329, 5869);
            CallChecker.varInit(this.count, "count", 125, 5329, 5869);
            CallChecker.varInit(this.dimension, "dimension", 125, 5329, 5869);
            CallChecker.varInit(WEIGHTS, "org.apache.commons.math3.random.HaltonSequenceGenerator.WEIGHTS", 125, 5329, 5869);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.random.HaltonSequenceGenerator.PRIMES", 125, 5329, 5869);
            final double[] v = CallChecker.varInit(new double[dimension], "v", 126, 5393, 5433);
            for (int i = 0; i < (dimension); i++) {
                int index = CallChecker.varInit(((int) (this.count)), "index", 128, 5493, 5510);
                double f = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(base, int[].class, 129, 5541, 5544)) {
                    f = 1.0 / (CallChecker.isCalled(base, int[].class, 129, 5541, 5544)[i]);
                    CallChecker.varAssign(f, "f", 129, 5541, 5544);
                }
                int j = CallChecker.varInit(((int) (0)), "j", 131, 5563, 5572);
                while (index > 0) {
                    final int digit = CallChecker.varInit(((int) (scramble(i, j, CallChecker.isCalled(this.base, int[].class, 133, 5655, 5658)[i], (index % (CallChecker.isCalled(this.base, int[].class, 133, 5672, 5675)[i]))))), "digit", 133, 5622, 5680);
                    if (CallChecker.beforeDeref(v, double[].class, 134, 5698, 5698)) {
                        CallChecker.isCalled(v, double[].class, 134, 5698, 5698)[i] += f * digit;
                        CallChecker.varAssign(CallChecker.isCalled(v, double[].class, 134, 5698, 5698)[i], "CallChecker.isCalled(v, double[].class, 134, 5698, 5698)[i]", 134, 5698, 5715);
                    }
                    if (CallChecker.beforeDeref(base, int[].class, 135, 5742, 5745)) {
                        index /= CallChecker.isCalled(base, int[].class, 135, 5742, 5745)[i];
                        CallChecker.varAssign(index, "index", 135, 5733, 5749);
                    }
                    if (CallChecker.beforeDeref(base, int[].class, 136, 5797, 5800)) {
                        f /= CallChecker.isCalled(base, int[].class, 136, 5797, 5800)[i];
                        CallChecker.varAssign(f, "f", 136, 5792, 5804);
                    }
                } 
            }
            (count)++;
            return v;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context983.methodEnd();
        }
    }

    protected int scramble(final int i, final int j, final int b, final int digit) {
        MethodContext _bcornu_methode_context984 = new MethodContext(int.class, 156, 5876, 6447);
        try {
            CallChecker.varInit(this, "this", 156, 5876, 6447);
            CallChecker.varInit(digit, "digit", 156, 5876, 6447);
            CallChecker.varInit(b, "b", 156, 5876, 6447);
            CallChecker.varInit(j, "j", 156, 5876, 6447);
            CallChecker.varInit(i, "i", 156, 5876, 6447);
            CallChecker.varInit(this.weight, "weight", 156, 5876, 6447);
            CallChecker.varInit(this.base, "base", 156, 5876, 6447);
            CallChecker.varInit(this.count, "count", 156, 5876, 6447);
            CallChecker.varInit(this.dimension, "dimension", 156, 5876, 6447);
            CallChecker.varInit(WEIGHTS, "org.apache.commons.math3.random.HaltonSequenceGenerator.WEIGHTS", 156, 5876, 6447);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.random.HaltonSequenceGenerator.PRIMES", 156, 5876, 6447);
            if ((weight) != null) {
                return ((weight[i]) * digit) % b;
            }else {
                return digit;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context984.methodEnd();
        }
    }

    public double[] skipTo(final int index) throws NotPositiveException {
        MethodContext _bcornu_methode_context985 = new MethodContext(double[].class, 169, 6454, 6878);
        try {
            CallChecker.varInit(this, "this", 169, 6454, 6878);
            CallChecker.varInit(index, "index", 169, 6454, 6878);
            CallChecker.varInit(this.weight, "weight", 169, 6454, 6878);
            CallChecker.varInit(this.base, "base", 169, 6454, 6878);
            CallChecker.varInit(this.count, "count", 169, 6454, 6878);
            CallChecker.varInit(this.dimension, "dimension", 169, 6454, 6878);
            CallChecker.varInit(WEIGHTS, "org.apache.commons.math3.random.HaltonSequenceGenerator.WEIGHTS", 169, 6454, 6878);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.random.HaltonSequenceGenerator.PRIMES", 169, 6454, 6878);
            count = index;
            CallChecker.varAssign(this.count, "this.count", 170, 6830, 6843);
            return nextVector();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context985.methodEnd();
        }
    }

    public int getNextIndex() {
        MethodContext _bcornu_methode_context986 = new MethodContext(int.class, 180, 6885, 7136);
        try {
            CallChecker.varInit(this, "this", 180, 6885, 7136);
            CallChecker.varInit(this.weight, "weight", 180, 6885, 7136);
            CallChecker.varInit(this.base, "base", 180, 6885, 7136);
            CallChecker.varInit(this.count, "count", 180, 6885, 7136);
            CallChecker.varInit(this.dimension, "dimension", 180, 6885, 7136);
            CallChecker.varInit(WEIGHTS, "org.apache.commons.math3.random.HaltonSequenceGenerator.WEIGHTS", 180, 6885, 7136);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.random.HaltonSequenceGenerator.PRIMES", 180, 6885, 7136);
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context986.methodEnd();
        }
    }
}

