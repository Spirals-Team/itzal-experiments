package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public abstract class AbstractStorelessUnivariateStatistic extends AbstractUnivariateStatistic implements StorelessUnivariateStatistic {
    @Override
    public double evaluate(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context765 = new MethodContext(double.class, 60, 1617, 2839);
        try {
            CallChecker.varInit(this, "this", 60, 1617, 2839);
            CallChecker.varInit(values, "values", 60, 1617, 2839);
            if (values == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            return evaluate(values, 0, values.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context765.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context766 = new MethodContext(double.class, 90, 2846, 4351);
        try {
            CallChecker.varInit(this, "this", 90, 2846, 4351);
            CallChecker.varInit(length, "length", 90, 2846, 4351);
            CallChecker.varInit(begin, "begin", 90, 2846, 4351);
            CallChecker.varInit(values, "values", 90, 2846, 4351);
            if (test(values, begin, length)) {
                clear();
                incrementAll(values, begin, length);
            }
            return getResult();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context766.methodEnd();
        }
    }

    @Override
    public abstract StorelessUnivariateStatistic copy();

    public abstract void clear();

    public abstract double getResult();

    public abstract void increment(final double d);

    public void incrementAll(double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context771 = new MethodContext(void.class, 130, 4707, 5373);
        try {
            CallChecker.varInit(this, "this", 130, 4707, 5373);
            CallChecker.varInit(values, "values", 130, 4707, 5373);
            if (values == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            incrementAll(values, 0, values.length);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context771.methodEnd();
        }
    }

    public void incrementAll(double[] values, int begin, int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context772 = new MethodContext(void.class, 149, 5380, 6259);
        try {
            CallChecker.varInit(this, "this", 149, 5380, 6259);
            CallChecker.varInit(length, "length", 149, 5380, 6259);
            CallChecker.varInit(begin, "begin", 149, 5380, 6259);
            CallChecker.varInit(values, "values", 149, 5380, 6259);
            if (test(values, begin, length)) {
                int k = CallChecker.varInit(((int) (begin + length)), "k", 151, 6123, 6145);
                for (int i = begin; i < k; i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 153, 6219, 6224)) {
                        values = CallChecker.beforeCalled(values, double[].class, 153, 6219, 6224);
                        increment(CallChecker.isCalled(values, double[].class, 153, 6219, 6224)[i]);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context772.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context773 = new MethodContext(boolean.class, 166, 6266, 7088);
        try {
            CallChecker.varInit(this, "this", 166, 6266, 7088);
            CallChecker.varInit(object, "object", 166, 6266, 7088);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof AbstractStorelessUnivariateStatistic) == false) {
                return false;
            }
            AbstractStorelessUnivariateStatistic stat = CallChecker.varInit(((AbstractStorelessUnivariateStatistic) (object)), "stat", 173, 6839, 6928);
            if (CallChecker.beforeDeref(stat, AbstractStorelessUnivariateStatistic.class, 174, 6974, 6977)) {
                if (CallChecker.beforeDeref(stat, AbstractStorelessUnivariateStatistic.class, 175, 7057, 7060)) {
                    stat = CallChecker.beforeCalled(stat, AbstractStorelessUnivariateStatistic.class, 174, 6974, 6977);
                    stat = CallChecker.beforeCalled(stat, AbstractStorelessUnivariateStatistic.class, 175, 7057, 7060);
                    return (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, AbstractStorelessUnivariateStatistic.class, 174, 6974, 6977).getResult(), this.getResult())) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, AbstractStorelessUnivariateStatistic.class, 175, 7057, 7060).getN(), this.getN()));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context773.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context774 = new MethodContext(int.class, 184, 7095, 7322);
        try {
            CallChecker.varInit(this, "this", 184, 7095, 7322);
            return (31 * (31 + (MathUtils.hash(getResult())))) + (MathUtils.hash(getN()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context774.methodEnd();
        }
    }
}

