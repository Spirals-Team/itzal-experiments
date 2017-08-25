package org.apache.commons.math3.stat.descriptive.rank;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

public class Min extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -2941995784909003131L;

    private long n;

    private double value;

    public Min() {
        ConstructorContext _bcornu_methode_context859 = new ConstructorContext(Min.class, 57, 2202, 2309);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 58, 2270, 2275);
            value = Double.NaN;
            CallChecker.varAssign(this.value, "this.value", 59, 2285, 2303);
        } finally {
            _bcornu_methode_context859.methodEnd();
        }
    }

    public Min(Min original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context860 = new ConstructorContext(Min.class, 69, 2316, 2634);
        try {
            Min.copy(original, this);
        } finally {
            _bcornu_methode_context860.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context3792 = new MethodContext(void.class, 77, 2641, 2830);
        try {
            CallChecker.varInit(this, "this", 77, 2641, 2830);
            CallChecker.varInit(d, "d", 77, 2641, 2830);
            CallChecker.varInit(this.value, "value", 77, 2641, 2830);
            CallChecker.varInit(this.n, "n", 77, 2641, 2830);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 77, 2641, 2830);
            if ((d < (value)) || (Double.isNaN(value))) {
                value = d;
                CallChecker.varAssign(this.value, "this.value", 79, 2792, 2801);
            }
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3792.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context3793 = new MethodContext(void.class, 88, 2837, 2957);
        try {
            CallChecker.varInit(this, "this", 88, 2837, 2957);
            CallChecker.varInit(this.value, "value", 88, 2837, 2957);
            CallChecker.varInit(this.n, "n", 88, 2837, 2957);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 88, 2837, 2957);
            value = Double.NaN;
            CallChecker.varAssign(this.value, "this.value", 89, 2918, 2936);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 90, 2946, 2951);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3793.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context3794 = new MethodContext(double.class, 97, 2964, 3069);
        try {
            CallChecker.varInit(this, "this", 97, 2964, 3069);
            CallChecker.varInit(this.value, "value", 97, 2964, 3069);
            CallChecker.varInit(this.n, "n", 97, 2964, 3069);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 97, 2964, 3069);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3794.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context3795 = new MethodContext(long.class, 104, 3076, 3156);
        try {
            CallChecker.varInit(this, "this", 104, 3076, 3156);
            CallChecker.varInit(this.value, "value", 104, 3076, 3156);
            CallChecker.varInit(this.n, "n", 104, 3076, 3156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 104, 3076, 3156);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3795.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3796 = new MethodContext(double.class, 131, 3163, 4669);
        try {
            CallChecker.varInit(this, "this", 131, 3163, 4669);
            CallChecker.varInit(length, "length", 131, 3163, 4669);
            CallChecker.varInit(begin, "begin", 131, 3163, 4669);
            CallChecker.varInit(values, "values", 131, 3163, 4669);
            CallChecker.varInit(this.value, "value", 131, 3163, 4669);
            CallChecker.varInit(this.n, "n", 131, 3163, 4669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 131, 3163, 4669);
            double min = CallChecker.varInit(((double) (Double.NaN)), "min", 133, 4332, 4355);
            if (test(values, begin, length)) {
                if (CallChecker.beforeDeref(values, double[].class, 135, 4418, 4423)) {
                    min = CallChecker.isCalled(values, double[].class, 135, 4418, 4423)[begin];
                    CallChecker.varAssign(min, "min", 135, 4412, 4431);
                }
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 137, 4526, 4531)) {
                        if (!(Double.isNaN(CallChecker.isCalled(values, double[].class, 137, 4526, 4531)[i]))) {
                            if (CallChecker.beforeDeref(values, double[].class, 138, 4573, 4578)) {
                                if (min < (CallChecker.isCalled(values, double[].class, 138, 4573, 4578)[i])) {
                                    min = min;
                                    CallChecker.varAssign(min, "min", 138, 4560, 4601);
                                }else {
                                    if (CallChecker.beforeDeref(values, double[].class, 138, 4592, 4597)) {
                                        min = CallChecker.isCalled(values, double[].class, 138, 4592, 4597)[i];
                                        CallChecker.varAssign(min, "min", 138, 4560, 4601);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3796.methodEnd();
        }
    }

    @Override
    public Min copy() {
        MethodContext _bcornu_methode_context3797 = new MethodContext(Min.class, 149, 4676, 4902);
        try {
            CallChecker.varInit(this, "this", 149, 4676, 4902);
            CallChecker.varInit(this.value, "value", 149, 4676, 4902);
            CallChecker.varInit(this.n, "n", 149, 4676, 4902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 149, 4676, 4902);
            Min result = CallChecker.varInit(new Min(), "result", 150, 4755, 4777);
            Min.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Min) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3797.methodEnd();
        }
    }

    public static void copy(Min source, Min dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context3798 = new MethodContext(void.class, 164, 4909, 5422);
        try {
            CallChecker.varInit(dest, "dest", 164, 4909, 5422);
            CallChecker.varInit(source, "source", 164, 4909, 5422);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Min.serialVersionUID", 164, 4909, 5422);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Min.class, 168, 5334, 5339)) {
                if (CallChecker.beforeDeref(dest, Min.class, 168, 5321, 5324)) {
                    source = CallChecker.beforeCalled(source, Min.class, 168, 5334, 5339);
                    dest = CallChecker.beforeCalled(dest, Min.class, 168, 5321, 5324);
                    CallChecker.isCalled(dest, Min.class, 168, 5321, 5324).setData(CallChecker.isCalled(source, Min.class, 168, 5334, 5339).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Min.class, 169, 5364, 5367)) {
                if (CallChecker.beforeDeref(source, Min.class, 169, 5373, 5378)) {
                    dest = CallChecker.beforeCalled(dest, Min.class, 169, 5364, 5367);
                    source = CallChecker.beforeCalled(source, Min.class, 169, 5373, 5378);
                    CallChecker.isCalled(dest, Min.class, 169, 5364, 5367).n = CallChecker.isCalled(source, Min.class, 169, 5373, 5378).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Min.class, 169, 5364, 5367).n, "CallChecker.isCalled(dest, Min.class, 169, 5364, 5367).n", 169, 5364, 5381);
                }
            }
            if (CallChecker.beforeDeref(dest, Min.class, 170, 5391, 5394)) {
                if (CallChecker.beforeDeref(source, Min.class, 170, 5404, 5409)) {
                    dest = CallChecker.beforeCalled(dest, Min.class, 170, 5391, 5394);
                    source = CallChecker.beforeCalled(source, Min.class, 170, 5404, 5409);
                    CallChecker.isCalled(dest, Min.class, 170, 5391, 5394).value = CallChecker.isCalled(source, Min.class, 170, 5404, 5409).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Min.class, 170, 5391, 5394).value, "CallChecker.isCalled(dest, Min.class, 170, 5391, 5394).value", 170, 5391, 5416);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3798.methodEnd();
        }
    }
}

