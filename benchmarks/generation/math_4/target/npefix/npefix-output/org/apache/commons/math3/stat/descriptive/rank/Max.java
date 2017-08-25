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

public class Max extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -5593383832225844641L;

    private long n;

    private double value;

    public Max() {
        ConstructorContext _bcornu_methode_context617 = new ConstructorContext(Max.class, 57, 2203, 2310);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 58, 2271, 2276);
            value = Double.NaN;
            CallChecker.varAssign(this.value, "this.value", 59, 2286, 2304);
        } finally {
            _bcornu_methode_context617.methodEnd();
        }
    }

    public Max(Max original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context618 = new ConstructorContext(Max.class, 69, 2317, 2635);
        try {
            Max.copy(original, this);
        } finally {
            _bcornu_methode_context618.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context2776 = new MethodContext(void.class, 77, 2642, 2831);
        try {
            CallChecker.varInit(this, "this", 77, 2642, 2831);
            CallChecker.varInit(d, "d", 77, 2642, 2831);
            CallChecker.varInit(this.value, "value", 77, 2642, 2831);
            CallChecker.varInit(this.n, "n", 77, 2642, 2831);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 77, 2642, 2831);
            if ((d > (value)) || (Double.isNaN(value))) {
                value = d;
                CallChecker.varAssign(this.value, "this.value", 79, 2793, 2802);
            }
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2776.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2777 = new MethodContext(void.class, 88, 2838, 2958);
        try {
            CallChecker.varInit(this, "this", 88, 2838, 2958);
            CallChecker.varInit(this.value, "value", 88, 2838, 2958);
            CallChecker.varInit(this.n, "n", 88, 2838, 2958);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 88, 2838, 2958);
            value = Double.NaN;
            CallChecker.varAssign(this.value, "this.value", 89, 2919, 2937);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 90, 2947, 2952);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2777.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context2778 = new MethodContext(double.class, 97, 2965, 3070);
        try {
            CallChecker.varInit(this, "this", 97, 2965, 3070);
            CallChecker.varInit(this.value, "value", 97, 2965, 3070);
            CallChecker.varInit(this.n, "n", 97, 2965, 3070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 97, 2965, 3070);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2778.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context2779 = new MethodContext(long.class, 104, 3077, 3157);
        try {
            CallChecker.varInit(this, "this", 104, 3077, 3157);
            CallChecker.varInit(this.value, "value", 104, 3077, 3157);
            CallChecker.varInit(this.n, "n", 104, 3077, 3157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 104, 3077, 3157);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2779.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2780 = new MethodContext(double.class, 131, 3164, 4670);
        try {
            CallChecker.varInit(this, "this", 131, 3164, 4670);
            CallChecker.varInit(length, "length", 131, 3164, 4670);
            CallChecker.varInit(begin, "begin", 131, 3164, 4670);
            CallChecker.varInit(values, "values", 131, 3164, 4670);
            CallChecker.varInit(this.value, "value", 131, 3164, 4670);
            CallChecker.varInit(this.n, "n", 131, 3164, 4670);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 131, 3164, 4670);
            double max = CallChecker.varInit(((double) (Double.NaN)), "max", 133, 4333, 4356);
            if (test(values, begin, length)) {
                if (CallChecker.beforeDeref(values, double[].class, 135, 4419, 4424)) {
                    max = CallChecker.isCalled(values, double[].class, 135, 4419, 4424)[begin];
                    CallChecker.varAssign(max, "max", 135, 4413, 4432);
                }
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 137, 4527, 4532)) {
                        if (!(Double.isNaN(CallChecker.isCalled(values, double[].class, 137, 4527, 4532)[i]))) {
                            if (CallChecker.beforeDeref(values, double[].class, 138, 4574, 4579)) {
                                if (max > (CallChecker.isCalled(values, double[].class, 138, 4574, 4579)[i])) {
                                    max = max;
                                    CallChecker.varAssign(max, "max", 138, 4561, 4602);
                                }else {
                                    if (CallChecker.beforeDeref(values, double[].class, 138, 4593, 4598)) {
                                        max = CallChecker.isCalled(values, double[].class, 138, 4593, 4598)[i];
                                        CallChecker.varAssign(max, "max", 138, 4561, 4602);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2780.methodEnd();
        }
    }

    @Override
    public Max copy() {
        MethodContext _bcornu_methode_context2781 = new MethodContext(Max.class, 149, 4677, 4909);
        try {
            CallChecker.varInit(this, "this", 149, 4677, 4909);
            CallChecker.varInit(this.value, "value", 149, 4677, 4909);
            CallChecker.varInit(this.n, "n", 149, 4677, 4909);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 149, 4677, 4909);
            Max result = CallChecker.varInit(new Max(), "result", 150, 4756, 4778);
            Max.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Max) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2781.methodEnd();
        }
    }

    public static void copy(Max source, Max dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context2782 = new MethodContext(void.class, 164, 4916, 5429);
        try {
            CallChecker.varInit(dest, "dest", 164, 4916, 5429);
            CallChecker.varInit(source, "source", 164, 4916, 5429);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Max.serialVersionUID", 164, 4916, 5429);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Max.class, 168, 5341, 5346)) {
                if (CallChecker.beforeDeref(dest, Max.class, 168, 5328, 5331)) {
                    source = CallChecker.beforeCalled(source, Max.class, 168, 5341, 5346);
                    dest = CallChecker.beforeCalled(dest, Max.class, 168, 5328, 5331);
                    CallChecker.isCalled(dest, Max.class, 168, 5328, 5331).setData(CallChecker.isCalled(source, Max.class, 168, 5341, 5346).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Max.class, 169, 5371, 5374)) {
                if (CallChecker.beforeDeref(source, Max.class, 169, 5380, 5385)) {
                    dest = CallChecker.beforeCalled(dest, Max.class, 169, 5371, 5374);
                    source = CallChecker.beforeCalled(source, Max.class, 169, 5380, 5385);
                    CallChecker.isCalled(dest, Max.class, 169, 5371, 5374).n = CallChecker.isCalled(source, Max.class, 169, 5380, 5385).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Max.class, 169, 5371, 5374).n, "CallChecker.isCalled(dest, Max.class, 169, 5371, 5374).n", 169, 5371, 5388);
                }
            }
            if (CallChecker.beforeDeref(dest, Max.class, 170, 5398, 5401)) {
                if (CallChecker.beforeDeref(source, Max.class, 170, 5411, 5416)) {
                    dest = CallChecker.beforeCalled(dest, Max.class, 170, 5398, 5401);
                    source = CallChecker.beforeCalled(source, Max.class, 170, 5411, 5416);
                    CallChecker.isCalled(dest, Max.class, 170, 5398, 5401).value = CallChecker.isCalled(source, Max.class, 170, 5411, 5416).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Max.class, 170, 5398, 5401).value, "CallChecker.isCalled(dest, Max.class, 170, 5398, 5401).value", 170, 5398, 5423);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2782.methodEnd();
        }
    }
}

