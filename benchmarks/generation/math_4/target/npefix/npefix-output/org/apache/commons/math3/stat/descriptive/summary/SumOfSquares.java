package org.apache.commons.math3.stat.descriptive.summary;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

public class SumOfSquares extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 1460986908574398008L;

    private long n;

    private double value;

    public SumOfSquares() {
        ConstructorContext _bcornu_methode_context1265 = new ConstructorContext(SumOfSquares.class, 56, 2032, 2148);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 57, 2118, 2123);
            value = 0;
            CallChecker.varAssign(this.value, "this.value", 58, 2133, 2142);
        } finally {
            _bcornu_methode_context1265.methodEnd();
        }
    }

    public SumOfSquares(SumOfSquares original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context1266 = new ConstructorContext(SumOfSquares.class, 68, 2155, 2509);
        try {
            SumOfSquares.copy(original, this);
        } finally {
            _bcornu_methode_context1266.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context5653 = new MethodContext(void.class, 76, 2516, 2648);
        try {
            CallChecker.varInit(this, "this", 76, 2516, 2648);
            CallChecker.varInit(d, "d", 76, 2516, 2648);
            CallChecker.varInit(this.value, "value", 76, 2516, 2648);
            CallChecker.varInit(this.n, "n", 76, 2516, 2648);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 76, 2516, 2648);
            value += d * d;
            CallChecker.varAssign(this.value, "this.value", 77, 2615, 2629);
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5653.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context5654 = new MethodContext(double.class, 85, 2655, 2760);
        try {
            CallChecker.varInit(this, "this", 85, 2655, 2760);
            CallChecker.varInit(this.value, "value", 85, 2655, 2760);
            CallChecker.varInit(this.n, "n", 85, 2655, 2760);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 85, 2655, 2760);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5654.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context5655 = new MethodContext(long.class, 92, 2767, 2847);
        try {
            CallChecker.varInit(this, "this", 92, 2767, 2847);
            CallChecker.varInit(this.value, "value", 92, 2767, 2847);
            CallChecker.varInit(this.n, "n", 92, 2767, 2847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 92, 2767, 2847);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5655.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context5656 = new MethodContext(void.class, 100, 2854, 2965);
        try {
            CallChecker.varInit(this, "this", 100, 2854, 2965);
            CallChecker.varInit(this.value, "value", 100, 2854, 2965);
            CallChecker.varInit(this.n, "n", 100, 2854, 2965);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 100, 2854, 2965);
            value = 0;
            CallChecker.varAssign(this.value, "this.value", 101, 2935, 2944);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 102, 2954, 2959);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5656.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context5657 = new MethodContext(double.class, 120, 2972, 4010);
        try {
            CallChecker.varInit(this, "this", 120, 2972, 4010);
            CallChecker.varInit(length, "length", 120, 2972, 4010);
            CallChecker.varInit(begin, "begin", 120, 2972, 4010);
            CallChecker.varInit(values, "values", 120, 2972, 4010);
            CallChecker.varInit(this.value, "value", 120, 2972, 4010);
            CallChecker.varInit(this.n, "n", 120, 2972, 4010);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 120, 2972, 4010);
            double sumSq = CallChecker.varInit(((double) (Double.NaN)), "sumSq", 122, 3752, 3777);
            if (test(values, begin, length, true)) {
                sumSq = 0.0;
                CallChecker.varAssign(sumSq, "sumSq", 124, 3840, 3851);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 126, 3937, 3942)) {
                        if (CallChecker.beforeDeref(values, double[].class, 126, 3949, 3954)) {
                            sumSq += (CallChecker.isCalled(values, double[].class, 126, 3937, 3942)[i]) * (CallChecker.isCalled(values, double[].class, 126, 3949, 3954)[i]);
                            CallChecker.varAssign(sumSq, "sumSq", 126, 3928, 3958);
                        }
                    }
                }
            }
            return sumSq;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5657.methodEnd();
        }
    }

    @Override
    public SumOfSquares copy() {
        MethodContext _bcornu_methode_context5658 = new MethodContext(SumOfSquares.class, 136, 4017, 4278);
        try {
            CallChecker.varInit(this, "this", 136, 4017, 4278);
            CallChecker.varInit(this.value, "value", 136, 4017, 4278);
            CallChecker.varInit(this.n, "n", 136, 4017, 4278);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 136, 4017, 4278);
            SumOfSquares result = CallChecker.varInit(new SumOfSquares(), "result", 137, 4105, 4145);
            SumOfSquares.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SumOfSquares) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5658.methodEnd();
        }
    }

    public static void copy(SumOfSquares source, SumOfSquares dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context5659 = new MethodContext(void.class, 151, 4285, 4834);
        try {
            CallChecker.varInit(dest, "dest", 151, 4285, 4834);
            CallChecker.varInit(source, "source", 151, 4285, 4834);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfSquares.serialVersionUID", 151, 4285, 4834);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, SumOfSquares.class, 155, 4746, 4751)) {
                if (CallChecker.beforeDeref(dest, SumOfSquares.class, 155, 4733, 4736)) {
                    source = CallChecker.beforeCalled(source, SumOfSquares.class, 155, 4746, 4751);
                    dest = CallChecker.beforeCalled(dest, SumOfSquares.class, 155, 4733, 4736);
                    CallChecker.isCalled(dest, SumOfSquares.class, 155, 4733, 4736).setData(CallChecker.isCalled(source, SumOfSquares.class, 155, 4746, 4751).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, SumOfSquares.class, 156, 4776, 4779)) {
                if (CallChecker.beforeDeref(source, SumOfSquares.class, 156, 4785, 4790)) {
                    dest = CallChecker.beforeCalled(dest, SumOfSquares.class, 156, 4776, 4779);
                    source = CallChecker.beforeCalled(source, SumOfSquares.class, 156, 4785, 4790);
                    CallChecker.isCalled(dest, SumOfSquares.class, 156, 4776, 4779).n = CallChecker.isCalled(source, SumOfSquares.class, 156, 4785, 4790).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SumOfSquares.class, 156, 4776, 4779).n, "CallChecker.isCalled(dest, SumOfSquares.class, 156, 4776, 4779).n", 156, 4776, 4793);
                }
            }
            if (CallChecker.beforeDeref(dest, SumOfSquares.class, 157, 4803, 4806)) {
                if (CallChecker.beforeDeref(source, SumOfSquares.class, 157, 4816, 4821)) {
                    dest = CallChecker.beforeCalled(dest, SumOfSquares.class, 157, 4803, 4806);
                    source = CallChecker.beforeCalled(source, SumOfSquares.class, 157, 4816, 4821);
                    CallChecker.isCalled(dest, SumOfSquares.class, 157, 4803, 4806).value = CallChecker.isCalled(source, SumOfSquares.class, 157, 4816, 4821).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SumOfSquares.class, 157, 4803, 4806).value, "CallChecker.isCalled(dest, SumOfSquares.class, 157, 4803, 4806).value", 157, 4803, 4828);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5659.methodEnd();
        }
    }
}

