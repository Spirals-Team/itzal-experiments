package org.apache.commons.math3.stat.descriptive.summary;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class SumOfLogs extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -370076995648386763L;

    private int n;

    private double value;

    public SumOfLogs() {
        ConstructorContext _bcornu_methode_context615 = new ConstructorContext(SumOfLogs.class, 65, 2514, 2623);
        try {
            value = 0.0;
            CallChecker.varAssign(this.value, "this.value", 66, 2593, 2603);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 67, 2612, 2617);
        } finally {
            _bcornu_methode_context615.methodEnd();
        }
    }

    public SumOfLogs(SumOfLogs original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context616 = new ConstructorContext(SumOfLogs.class, 77, 2630, 2972);
        try {
            SumOfLogs.copy(original, this);
        } finally {
            _bcornu_methode_context616.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context2769 = new MethodContext(void.class, 85, 2979, 3121);
        try {
            CallChecker.varInit(this, "this", 85, 2979, 3121);
            CallChecker.varInit(d, "d", 85, 2979, 3121);
            CallChecker.varInit(this.value, "value", 85, 2979, 3121);
            CallChecker.varInit(this.n, "n", 85, 2979, 3121);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 85, 2979, 3121);
            value += FastMath.log(d);
            CallChecker.varAssign(this.value, "this.value", 86, 3078, 3102);
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2769.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context2770 = new MethodContext(double.class, 94, 3128, 3233);
        try {
            CallChecker.varInit(this, "this", 94, 3128, 3233);
            CallChecker.varInit(this.value, "value", 94, 3128, 3233);
            CallChecker.varInit(this.n, "n", 94, 3128, 3233);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 94, 3128, 3233);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2770.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context2771 = new MethodContext(long.class, 101, 3240, 3320);
        try {
            CallChecker.varInit(this, "this", 101, 3240, 3320);
            CallChecker.varInit(this.value, "value", 101, 3240, 3320);
            CallChecker.varInit(this.n, "n", 101, 3240, 3320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 101, 3240, 3320);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2771.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2772 = new MethodContext(void.class, 109, 3327, 3439);
        try {
            CallChecker.varInit(this, "this", 109, 3327, 3439);
            CallChecker.varInit(this.value, "value", 109, 3327, 3439);
            CallChecker.varInit(this.n, "n", 109, 3327, 3439);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 109, 3327, 3439);
            value = 0.0;
            CallChecker.varAssign(this.value, "this.value", 110, 3408, 3418);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 111, 3428, 3433);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2772.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2773 = new MethodContext(double.class, 132, 3446, 4553);
        try {
            CallChecker.varInit(this, "this", 132, 3446, 4553);
            CallChecker.varInit(length, "length", 132, 3446, 4553);
            CallChecker.varInit(begin, "begin", 132, 3446, 4553);
            CallChecker.varInit(values, "values", 132, 3446, 4553);
            CallChecker.varInit(this.value, "value", 132, 3446, 4553);
            CallChecker.varInit(this.n, "n", 132, 3446, 4553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 132, 3446, 4553);
            double sumLog = CallChecker.varInit(((double) (Double.NaN)), "sumLog", 134, 4289, 4315);
            if (test(values, begin, length, true)) {
                sumLog = 0.0;
                CallChecker.varAssign(sumLog, "sumLog", 136, 4378, 4390);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 138, 4490, 4495)) {
                        sumLog += FastMath.log(CallChecker.isCalled(values, double[].class, 138, 4490, 4495)[i]);
                        CallChecker.varAssign(sumLog, "sumLog", 138, 4467, 4500);
                    }
                }
            }
            return sumLog;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2773.methodEnd();
        }
    }

    @Override
    public SumOfLogs copy() {
        MethodContext _bcornu_methode_context2774 = new MethodContext(SumOfLogs.class, 148, 4560, 4812);
        try {
            CallChecker.varInit(this, "this", 148, 4560, 4812);
            CallChecker.varInit(this.value, "value", 148, 4560, 4812);
            CallChecker.varInit(this.n, "n", 148, 4560, 4812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 148, 4560, 4812);
            SumOfLogs result = CallChecker.varInit(new SumOfLogs(), "result", 149, 4645, 4679);
            SumOfLogs.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SumOfLogs) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2774.methodEnd();
        }
    }

    public static void copy(SumOfLogs source, SumOfLogs dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context2775 = new MethodContext(void.class, 163, 4819, 5356);
        try {
            CallChecker.varInit(dest, "dest", 163, 4819, 5356);
            CallChecker.varInit(source, "source", 163, 4819, 5356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.SumOfLogs.serialVersionUID", 163, 4819, 5356);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, SumOfLogs.class, 167, 5268, 5273)) {
                if (CallChecker.beforeDeref(dest, SumOfLogs.class, 167, 5255, 5258)) {
                    source = CallChecker.beforeCalled(source, SumOfLogs.class, 167, 5268, 5273);
                    dest = CallChecker.beforeCalled(dest, SumOfLogs.class, 167, 5255, 5258);
                    CallChecker.isCalled(dest, SumOfLogs.class, 167, 5255, 5258).setData(CallChecker.isCalled(source, SumOfLogs.class, 167, 5268, 5273).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, SumOfLogs.class, 168, 5298, 5301)) {
                if (CallChecker.beforeDeref(source, SumOfLogs.class, 168, 5307, 5312)) {
                    dest = CallChecker.beforeCalled(dest, SumOfLogs.class, 168, 5298, 5301);
                    source = CallChecker.beforeCalled(source, SumOfLogs.class, 168, 5307, 5312);
                    CallChecker.isCalled(dest, SumOfLogs.class, 168, 5298, 5301).n = CallChecker.isCalled(source, SumOfLogs.class, 168, 5307, 5312).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SumOfLogs.class, 168, 5298, 5301).n, "CallChecker.isCalled(dest, SumOfLogs.class, 168, 5298, 5301).n", 168, 5298, 5315);
                }
            }
            if (CallChecker.beforeDeref(dest, SumOfLogs.class, 169, 5325, 5328)) {
                if (CallChecker.beforeDeref(source, SumOfLogs.class, 169, 5338, 5343)) {
                    dest = CallChecker.beforeCalled(dest, SumOfLogs.class, 169, 5325, 5328);
                    source = CallChecker.beforeCalled(source, SumOfLogs.class, 169, 5338, 5343);
                    CallChecker.isCalled(dest, SumOfLogs.class, 169, 5325, 5328).value = CallChecker.isCalled(source, SumOfLogs.class, 169, 5338, 5343).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SumOfLogs.class, 169, 5325, 5328).value, "CallChecker.isCalled(dest, SumOfLogs.class, 169, 5325, 5328).value", 169, 5325, 5350);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2775.methodEnd();
        }
    }
}

