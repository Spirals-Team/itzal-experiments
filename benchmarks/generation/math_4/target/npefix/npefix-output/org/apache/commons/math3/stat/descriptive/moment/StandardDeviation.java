package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class StandardDeviation extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 5728716329662425188L;

    private Variance variance = null;

    public StandardDeviation() {
        ConstructorContext _bcornu_methode_context92 = new ConstructorContext(StandardDeviation.class, 57, 2400, 2626);
        try {
            variance = new Variance();
            CallChecker.varAssign(this.variance, "this.variance", 58, 2595, 2620);
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public StandardDeviation(final SecondMoment m2) {
        ConstructorContext _bcornu_methode_context93 = new ConstructorContext(StandardDeviation.class, 66, 2633, 2854);
        try {
            variance = new Variance(m2);
            CallChecker.varAssign(this.variance, "this.variance", 67, 2821, 2848);
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    public StandardDeviation(StandardDeviation original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context94 = new ConstructorContext(StandardDeviation.class, 77, 2861, 3235);
        try {
            StandardDeviation.copy(original, this);
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public StandardDeviation(boolean isBiasCorrected) {
        ConstructorContext _bcornu_methode_context95 = new ConstructorContext(StandardDeviation.class, 91, 3242, 3801);
        try {
            variance = new Variance(isBiasCorrected);
            CallChecker.varAssign(this.variance, "this.variance", 92, 3755, 3795);
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    public StandardDeviation(boolean isBiasCorrected, SecondMoment m2) {
        ConstructorContext _bcornu_methode_context96 = new ConstructorContext(StandardDeviation.class, 106, 3808, 4473);
        try {
            variance = new Variance(isBiasCorrected, m2);
            CallChecker.varAssign(this.variance, "this.variance", 107, 4423, 4467);
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context353 = new MethodContext(void.class, 114, 4480, 4606);
        try {
            CallChecker.varInit(this, "this", 114, 4480, 4606);
            CallChecker.varInit(d, "d", 114, 4480, 4606);
            CallChecker.varInit(this.variance, "variance", 114, 4480, 4606);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 114, 4480, 4606);
            if (CallChecker.beforeDeref(variance, Variance.class, 115, 4579, 4586)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 115, 4579, 4586);
                CallChecker.isCalled(variance, Variance.class, 115, 4579, 4586).increment(d);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context353.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context354 = new MethodContext(long.class, 121, 4613, 4707);
        try {
            CallChecker.varInit(this, "this", 121, 4613, 4707);
            CallChecker.varInit(this.variance, "variance", 121, 4613, 4707);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 121, 4613, 4707);
            if (CallChecker.beforeDeref(variance, Variance.class, 122, 4686, 4693)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 122, 4686, 4693);
                return CallChecker.isCalled(variance, Variance.class, 122, 4686, 4693).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context354.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context355 = new MethodContext(double.class, 129, 4714, 4849);
        try {
            CallChecker.varInit(this, "this", 129, 4714, 4849);
            CallChecker.varInit(this.variance, "variance", 129, 4714, 4849);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 129, 4714, 4849);
            if (CallChecker.beforeDeref(variance, Variance.class, 130, 4822, 4829)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 130, 4822, 4829);
                return FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 130, 4822, 4829).getResult());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context355.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context356 = new MethodContext(void.class, 137, 4856, 4959);
        try {
            CallChecker.varInit(this, "this", 137, 4856, 4959);
            CallChecker.varInit(this.variance, "variance", 137, 4856, 4959);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 137, 4856, 4959);
            if (CallChecker.beforeDeref(variance, Variance.class, 138, 4937, 4944)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 138, 4937, 4944);
                CallChecker.isCalled(variance, Variance.class, 138, 4937, 4944).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context356.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context357 = new MethodContext(double.class, 156, 4966, 5706);
        try {
            CallChecker.varInit(this, "this", 156, 4966, 5706);
            CallChecker.varInit(values, "values", 156, 4966, 5706);
            CallChecker.varInit(this.variance, "variance", 156, 4966, 5706);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 156, 4966, 5706);
            if (CallChecker.beforeDeref(variance, Variance.class, 157, 5674, 5681)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 157, 5674, 5681);
                return FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 157, 5674, 5681).evaluate(values));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context357.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context358 = new MethodContext(double.class, 179, 5713, 6724);
        try {
            CallChecker.varInit(this, "this", 179, 5713, 6724);
            CallChecker.varInit(length, "length", 179, 5713, 6724);
            CallChecker.varInit(begin, "begin", 179, 5713, 6724);
            CallChecker.varInit(values, "values", 179, 5713, 6724);
            CallChecker.varInit(this.variance, "variance", 179, 5713, 6724);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 179, 5713, 6724);
            if (CallChecker.beforeDeref(variance, Variance.class, 181, 6677, 6684)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 181, 6677, 6684);
                return FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 181, 6677, 6684).evaluate(values, begin, length));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context358.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double mean, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context359 = new MethodContext(double.class, 208, 6731, 8108);
        try {
            CallChecker.varInit(this, "this", 208, 6731, 8108);
            CallChecker.varInit(length, "length", 208, 6731, 8108);
            CallChecker.varInit(begin, "begin", 208, 6731, 8108);
            CallChecker.varInit(mean, "mean", 208, 6731, 8108);
            CallChecker.varInit(values, "values", 208, 6731, 8108);
            CallChecker.varInit(this.variance, "variance", 208, 6731, 8108);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 208, 6731, 8108);
            if (CallChecker.beforeDeref(variance, Variance.class, 210, 8055, 8062)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 210, 8055, 8062);
                return FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 210, 8055, 8062).evaluate(values, mean, begin, length));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context359.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double mean) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context360 = new MethodContext(double.class, 234, 8115, 9242);
        try {
            CallChecker.varInit(this, "this", 234, 8115, 9242);
            CallChecker.varInit(mean, "mean", 234, 8115, 9242);
            CallChecker.varInit(values, "values", 234, 8115, 9242);
            CallChecker.varInit(this.variance, "variance", 234, 8115, 9242);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 234, 8115, 9242);
            if (CallChecker.beforeDeref(variance, Variance.class, 236, 9204, 9211)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 236, 9204, 9211);
                return FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 236, 9204, 9211).evaluate(values, mean));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context360.methodEnd();
        }
    }

    public boolean isBiasCorrected() {
        MethodContext _bcornu_methode_context361 = new MethodContext(boolean.class, 242, 9249, 9391);
        try {
            CallChecker.varInit(this, "this", 242, 9249, 9391);
            CallChecker.varInit(this.variance, "variance", 242, 9249, 9391);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 242, 9249, 9391);
            if (CallChecker.beforeDeref(variance, Variance.class, 243, 9359, 9366)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 243, 9359, 9366);
                return CallChecker.isCalled(variance, Variance.class, 243, 9359, 9366).isBiasCorrected();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }

    public void setBiasCorrected(boolean isBiasCorrected) {
        MethodContext _bcornu_methode_context362 = new MethodContext(void.class, 249, 9398, 9584);
        try {
            CallChecker.varInit(this, "this", 249, 9398, 9584);
            CallChecker.varInit(isBiasCorrected, "isBiasCorrected", 249, 9398, 9584);
            CallChecker.varInit(this.variance, "variance", 249, 9398, 9584);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 249, 9398, 9584);
            if (CallChecker.beforeDeref(variance, Variance.class, 250, 9536, 9543)) {
                variance = CallChecker.beforeCalled(variance, Variance.class, 250, 9536, 9543);
                CallChecker.isCalled(variance, Variance.class, 250, 9536, 9543).setBiasCorrected(isBiasCorrected);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context362.methodEnd();
        }
    }

    @Override
    public StandardDeviation copy() {
        MethodContext _bcornu_methode_context363 = new MethodContext(StandardDeviation.class, 257, 9591, 9876);
        try {
            CallChecker.varInit(this, "this", 257, 9591, 9876);
            CallChecker.varInit(this.variance, "variance", 257, 9591, 9876);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 257, 9591, 9876);
            StandardDeviation result = CallChecker.varInit(new StandardDeviation(), "result", 258, 9684, 9734);
            StandardDeviation.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StandardDeviation) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context363.methodEnd();
        }
    }

    public static void copy(StandardDeviation source, StandardDeviation dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context364 = new MethodContext(void.class, 273, 9884, 10439);
        try {
            CallChecker.varInit(dest, "dest", 273, 9884, 10439);
            CallChecker.varInit(source, "source", 273, 9884, 10439);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.StandardDeviation.serialVersionUID", 273, 9884, 10439);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, StandardDeviation.class, 277, 10365, 10370)) {
                if (CallChecker.beforeDeref(dest, StandardDeviation.class, 277, 10352, 10355)) {
                    source = CallChecker.beforeCalled(source, StandardDeviation.class, 277, 10365, 10370);
                    dest = CallChecker.beforeCalled(dest, StandardDeviation.class, 277, 10352, 10355);
                    CallChecker.isCalled(dest, StandardDeviation.class, 277, 10352, 10355).setData(CallChecker.isCalled(source, StandardDeviation.class, 277, 10365, 10370).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, StandardDeviation.class, 278, 10395, 10398)) {
                if (CallChecker.beforeDeref(source, StandardDeviation.class, 278, 10411, 10416)) {
                    source = CallChecker.beforeCalled(source, StandardDeviation.class, 278, 10411, 10416);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, StandardDeviation.class, 278, 10411, 10416).variance, Variance.class, 278, 10411, 10425)) {
                        dest = CallChecker.beforeCalled(dest, StandardDeviation.class, 278, 10395, 10398);
                        source = CallChecker.beforeCalled(source, StandardDeviation.class, 278, 10411, 10416);
                        CallChecker.isCalled(source, StandardDeviation.class, 278, 10411, 10416).variance = CallChecker.beforeCalled(CallChecker.isCalled(source, StandardDeviation.class, 278, 10411, 10416).variance, Variance.class, 278, 10411, 10425);
                        CallChecker.isCalled(dest, StandardDeviation.class, 278, 10395, 10398).variance = CallChecker.isCalled(CallChecker.isCalled(source, StandardDeviation.class, 278, 10411, 10416).variance, Variance.class, 278, 10411, 10425).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, StandardDeviation.class, 278, 10395, 10398).variance, "CallChecker.isCalled(dest, StandardDeviation.class, 278, 10395, 10398).variance", 278, 10395, 10433);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context364.methodEnd();
        }
    }
}

