package org.apache.commons.math3.stat.descriptive.summary;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

public class Sum extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -8231831954703408316L;

    private long n;

    private double value;

    public Sum() {
        ConstructorContext _bcornu_methode_context251 = new ConstructorContext(Sum.class, 57, 2010, 2108);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 58, 2078, 2083);
            value = 0;
            CallChecker.varAssign(this.value, "this.value", 59, 2093, 2102);
        } finally {
            _bcornu_methode_context251.methodEnd();
        }
    }

    public Sum(Sum original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context252 = new ConstructorContext(Sum.class, 69, 2115, 2433);
        try {
            Sum.copy(original, this);
        } finally {
            _bcornu_methode_context252.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context1056 = new MethodContext(void.class, 77, 2440, 2568);
        try {
            CallChecker.varInit(this, "this", 77, 2440, 2568);
            CallChecker.varInit(d, "d", 77, 2440, 2568);
            CallChecker.varInit(this.value, "value", 77, 2440, 2568);
            CallChecker.varInit(this.n, "n", 77, 2440, 2568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 77, 2440, 2568);
            value += d;
            CallChecker.varAssign(this.value, "this.value", 78, 2539, 2549);
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1056.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context1057 = new MethodContext(double.class, 86, 2575, 2680);
        try {
            CallChecker.varInit(this, "this", 86, 2575, 2680);
            CallChecker.varInit(this.value, "value", 86, 2575, 2680);
            CallChecker.varInit(this.n, "n", 86, 2575, 2680);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 86, 2575, 2680);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1057.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context1058 = new MethodContext(long.class, 93, 2687, 2767);
        try {
            CallChecker.varInit(this, "this", 93, 2687, 2767);
            CallChecker.varInit(this.value, "value", 93, 2687, 2767);
            CallChecker.varInit(this.n, "n", 93, 2687, 2767);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 93, 2687, 2767);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1058.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1059 = new MethodContext(void.class, 101, 2774, 2885);
        try {
            CallChecker.varInit(this, "this", 101, 2774, 2885);
            CallChecker.varInit(this.value, "value", 101, 2774, 2885);
            CallChecker.varInit(this.n, "n", 101, 2774, 2885);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 101, 2774, 2885);
            value = 0;
            CallChecker.varAssign(this.value, "this.value", 102, 2855, 2864);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 103, 2874, 2879);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1059.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1060 = new MethodContext(double.class, 121, 2892, 3851);
        try {
            CallChecker.varInit(this, "this", 121, 2892, 3851);
            CallChecker.varInit(length, "length", 121, 2892, 3851);
            CallChecker.varInit(begin, "begin", 121, 2892, 3851);
            CallChecker.varInit(values, "values", 121, 2892, 3851);
            CallChecker.varInit(this.value, "value", 121, 2892, 3851);
            CallChecker.varInit(this.n, "n", 121, 2892, 3851);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 121, 2892, 3851);
            double sum = CallChecker.varInit(((double) (Double.NaN)), "sum", 123, 3613, 3636);
            if (test(values, begin, length, true)) {
                sum = 0.0;
                CallChecker.varAssign(sum, "sum", 125, 3699, 3708);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 127, 3792, 3797)) {
                        sum += CallChecker.isCalled(values, double[].class, 127, 3792, 3797)[i];
                        CallChecker.varAssign(sum, "sum", 127, 3785, 3801);
                    }
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1060.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1061 = new MethodContext(double.class, 160, 3858, 5490);
        try {
            CallChecker.varInit(this, "this", 160, 3858, 5490);
            CallChecker.varInit(length, "length", 160, 3858, 5490);
            CallChecker.varInit(begin, "begin", 160, 3858, 5490);
            CallChecker.varInit(weights, "weights", 160, 3858, 5490);
            CallChecker.varInit(values, "values", 160, 3858, 5490);
            CallChecker.varInit(this.value, "value", 160, 3858, 5490);
            CallChecker.varInit(this.n, "n", 160, 3858, 5490);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 160, 3858, 5490);
            double sum = CallChecker.varInit(((double) (Double.NaN)), "sum", 162, 5230, 5253);
            if (test(values, weights, begin, length, true)) {
                sum = 0.0;
                CallChecker.varAssign(sum, "sum", 164, 5325, 5334);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 166, 5418, 5423)) {
                        if (CallChecker.beforeDeref(weights, double[].class, 166, 5430, 5436)) {
                            sum += (CallChecker.isCalled(values, double[].class, 166, 5418, 5423)[i]) * (CallChecker.isCalled(weights, double[].class, 166, 5430, 5436)[i]);
                            CallChecker.varAssign(sum, "sum", 166, 5411, 5440);
                        }
                    }
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1061.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1062 = new MethodContext(double.class, 194, 5497, 6617);
        try {
            CallChecker.varInit(this, "this", 194, 5497, 6617);
            CallChecker.varInit(weights, "weights", 194, 5497, 6617);
            CallChecker.varInit(values, "values", 194, 5497, 6617);
            CallChecker.varInit(this.value, "value", 194, 5497, 6617);
            CallChecker.varInit(this.n, "n", 194, 5497, 6617);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 194, 5497, 6617);
            if (CallChecker.beforeDeref(values, double[].class, 196, 6597, 6602)) {
                return evaluate(values, weights, 0, CallChecker.isCalled(values, double[].class, 196, 6597, 6602).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1062.methodEnd();
        }
    }

    @Override
    public Sum copy() {
        MethodContext _bcornu_methode_context1063 = new MethodContext(Sum.class, 203, 6624, 6853);
        try {
            CallChecker.varInit(this, "this", 203, 6624, 6853);
            CallChecker.varInit(this.value, "value", 203, 6624, 6853);
            CallChecker.varInit(this.n, "n", 203, 6624, 6853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 203, 6624, 6853);
            Sum result = CallChecker.varInit(new Sum(), "result", 204, 6703, 6725);
            Sum.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Sum) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1063.methodEnd();
        }
    }

    public static void copy(Sum source, Sum dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context1064 = new MethodContext(void.class, 218, 6860, 7373);
        try {
            CallChecker.varInit(dest, "dest", 218, 6860, 7373);
            CallChecker.varInit(source, "source", 218, 6860, 7373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Sum.serialVersionUID", 218, 6860, 7373);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Sum.class, 222, 7285, 7290)) {
                if (CallChecker.beforeDeref(dest, Sum.class, 222, 7272, 7275)) {
                    source = CallChecker.beforeCalled(source, Sum.class, 222, 7285, 7290);
                    dest = CallChecker.beforeCalled(dest, Sum.class, 222, 7272, 7275);
                    CallChecker.isCalled(dest, Sum.class, 222, 7272, 7275).setData(CallChecker.isCalled(source, Sum.class, 222, 7285, 7290).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Sum.class, 223, 7315, 7318)) {
                if (CallChecker.beforeDeref(source, Sum.class, 223, 7324, 7329)) {
                    dest = CallChecker.beforeCalled(dest, Sum.class, 223, 7315, 7318);
                    source = CallChecker.beforeCalled(source, Sum.class, 223, 7324, 7329);
                    CallChecker.isCalled(dest, Sum.class, 223, 7315, 7318).n = CallChecker.isCalled(source, Sum.class, 223, 7324, 7329).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Sum.class, 223, 7315, 7318).n, "CallChecker.isCalled(dest, Sum.class, 223, 7315, 7318).n", 223, 7315, 7332);
                }
            }
            if (CallChecker.beforeDeref(dest, Sum.class, 224, 7342, 7345)) {
                if (CallChecker.beforeDeref(source, Sum.class, 224, 7355, 7360)) {
                    dest = CallChecker.beforeCalled(dest, Sum.class, 224, 7342, 7345);
                    source = CallChecker.beforeCalled(source, Sum.class, 224, 7355, 7360);
                    CallChecker.isCalled(dest, Sum.class, 224, 7342, 7345).value = CallChecker.isCalled(source, Sum.class, 224, 7355, 7360).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Sum.class, 224, 7342, 7345).value, "CallChecker.isCalled(dest, Sum.class, 224, 7342, 7345).value", 224, 7342, 7367);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1064.methodEnd();
        }
    }
}

