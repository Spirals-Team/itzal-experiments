package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class GeometricMean extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -8178734905303459453L;

    private StorelessUnivariateStatistic sumOfLogs;

    public GeometricMean() {
        ConstructorContext _bcornu_methode_context1129 = new ConstructorContext(GeometricMean.class, 66, 2798, 2919);
        try {
            sumOfLogs = new SumOfLogs();
            CallChecker.varAssign(this.sumOfLogs, "this.sumOfLogs", 67, 2886, 2913);
        } finally {
            _bcornu_methode_context1129.methodEnd();
        }
    }

    public GeometricMean(GeometricMean original) throws NullArgumentException {
        super();
        ConstructorContext _bcornu_methode_context1130 = new ConstructorContext(GeometricMean.class, 77, 2926, 3301);
        try {
            GeometricMean.copy(original, this);
        } finally {
            _bcornu_methode_context1130.methodEnd();
        }
    }

    public GeometricMean(SumOfLogs sumOfLogs) {
        ConstructorContext _bcornu_methode_context1131 = new ConstructorContext(GeometricMean.class, 86, 3308, 3550);
        try {
            this.sumOfLogs = sumOfLogs;
            CallChecker.varAssign(this.sumOfLogs, "this.sumOfLogs", 87, 3518, 3544);
        } finally {
            _bcornu_methode_context1131.methodEnd();
        }
    }

    @Override
    public GeometricMean copy() {
        MethodContext _bcornu_methode_context5069 = new MethodContext(GeometricMean.class, 94, 3557, 3826);
        try {
            CallChecker.varInit(this, "this", 94, 3557, 3826);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 94, 3557, 3826);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 94, 3557, 3826);
            GeometricMean result = CallChecker.varInit(new GeometricMean(), "result", 95, 3646, 3688);
            GeometricMean.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GeometricMean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5069.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context5070 = new MethodContext(void.class, 105, 3833, 3960);
        try {
            CallChecker.varInit(this, "this", 105, 3833, 3960);
            CallChecker.varInit(d, "d", 105, 3833, 3960);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 105, 3833, 3960);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 105, 3833, 3960);
            if (CallChecker.beforeDeref(sumOfLogs, StorelessUnivariateStatistic.class, 106, 3932, 3940)) {
                sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 106, 3932, 3940);
                CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 106, 3932, 3940).increment(d);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5070.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context5071 = new MethodContext(double.class, 113, 3967, 4219);
        try {
            CallChecker.varInit(this, "this", 113, 3967, 4219);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 113, 3967, 4219);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 113, 3967, 4219);
            if (CallChecker.beforeDeref(sumOfLogs, StorelessUnivariateStatistic.class, 114, 4058, 4066)) {
                sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 114, 4058, 4066);
                if ((CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 114, 4058, 4066).getN()) > 0) {
                    sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 115, 4114, 4122);
                    sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 115, 4138, 4146);
                    return FastMath.exp(((CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 115, 4114, 4122).getResult()) / (CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 115, 4138, 4146).getN())));
                }else {
                    return Double.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5071.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context5072 = new MethodContext(void.class, 125, 4226, 4330);
        try {
            CallChecker.varInit(this, "this", 125, 4226, 4330);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 125, 4226, 4330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 125, 4226, 4330);
            if (CallChecker.beforeDeref(sumOfLogs, StorelessUnivariateStatistic.class, 126, 4307, 4315)) {
                sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 126, 4307, 4315);
                CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 126, 4307, 4315).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5072.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context5073 = new MethodContext(double.class, 146, 4337, 5268);
        try {
            CallChecker.varInit(this, "this", 146, 4337, 5268);
            CallChecker.varInit(length, "length", 146, 4337, 5268);
            CallChecker.varInit(begin, "begin", 146, 4337, 5268);
            CallChecker.varInit(values, "values", 146, 4337, 5268);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 146, 4337, 5268);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 146, 4337, 5268);
            sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 150, 5211, 5219);
            return FastMath.exp(((CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 150, 5211, 5219).evaluate(values, begin, length)) / length));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5073.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context5074 = new MethodContext(long.class, 156, 5275, 5370);
        try {
            CallChecker.varInit(this, "this", 156, 5275, 5370);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 156, 5275, 5370);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 156, 5275, 5370);
            if (CallChecker.beforeDeref(sumOfLogs, StorelessUnivariateStatistic.class, 157, 5348, 5356)) {
                sumOfLogs = CallChecker.beforeCalled(sumOfLogs, StorelessUnivariateStatistic.class, 157, 5348, 5356);
                return CallChecker.isCalled(sumOfLogs, StorelessUnivariateStatistic.class, 157, 5348, 5356).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5074.methodEnd();
        }
    }

    public void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context5075 = new MethodContext(void.class, 171, 5377, 6049);
        try {
            CallChecker.varInit(this, "this", 171, 5377, 6049);
            CallChecker.varInit(sumLogImpl, "sumLogImpl", 171, 5377, 6049);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 171, 5377, 6049);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 171, 5377, 6049);
            checkEmpty();
            this.sumOfLogs = sumLogImpl;
            CallChecker.varAssign(this.sumOfLogs, "this.sumOfLogs", 174, 6016, 6043);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5075.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        MethodContext _bcornu_methode_context5076 = new MethodContext(StorelessUnivariateStatistic.class, 182, 6056, 6303);
        try {
            CallChecker.varInit(this, "this", 182, 6056, 6303);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 182, 6056, 6303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 182, 6056, 6303);
            return sumOfLogs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5076.methodEnd();
        }
    }

    public static void copy(GeometricMean source, GeometricMean dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context5077 = new MethodContext(void.class, 194, 6310, 6851);
        try {
            CallChecker.varInit(dest, "dest", 194, 6310, 6851);
            CallChecker.varInit(source, "source", 194, 6310, 6851);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 194, 6310, 6851);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, GeometricMean.class, 198, 6775, 6780)) {
                if (CallChecker.beforeDeref(dest, GeometricMean.class, 198, 6762, 6765)) {
                    source = CallChecker.beforeCalled(source, GeometricMean.class, 198, 6775, 6780);
                    dest = CallChecker.beforeCalled(dest, GeometricMean.class, 198, 6762, 6765);
                    CallChecker.isCalled(dest, GeometricMean.class, 198, 6762, 6765).setData(CallChecker.isCalled(source, GeometricMean.class, 198, 6775, 6780).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, GeometricMean.class, 199, 6805, 6808)) {
                if (CallChecker.beforeDeref(source, GeometricMean.class, 199, 6822, 6827)) {
                    source = CallChecker.beforeCalled(source, GeometricMean.class, 199, 6822, 6827);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, GeometricMean.class, 199, 6822, 6827).sumOfLogs, StorelessUnivariateStatistic.class, 199, 6822, 6837)) {
                        dest = CallChecker.beforeCalled(dest, GeometricMean.class, 199, 6805, 6808);
                        source = CallChecker.beforeCalled(source, GeometricMean.class, 199, 6822, 6827);
                        CallChecker.isCalled(source, GeometricMean.class, 199, 6822, 6827).sumOfLogs = CallChecker.beforeCalled(CallChecker.isCalled(source, GeometricMean.class, 199, 6822, 6827).sumOfLogs, StorelessUnivariateStatistic.class, 199, 6822, 6837);
                        CallChecker.isCalled(dest, GeometricMean.class, 199, 6805, 6808).sumOfLogs = CallChecker.isCalled(CallChecker.isCalled(source, GeometricMean.class, 199, 6822, 6827).sumOfLogs, StorelessUnivariateStatistic.class, 199, 6822, 6837).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, GeometricMean.class, 199, 6805, 6808).sumOfLogs, "CallChecker.isCalled(dest, GeometricMean.class, 199, 6805, 6808).sumOfLogs", 199, 6805, 6845);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5077.methodEnd();
        }
    }

    private void checkEmpty() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context5078 = new MethodContext(void.class, 207, 6859, 7266);
        try {
            CallChecker.varInit(this, "this", 207, 6859, 7266);
            CallChecker.varInit(this.sumOfLogs, "sumOfLogs", 207, 6859, 7266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.GeometricMean.serialVersionUID", 207, 6859, 7266);
            if ((getN()) > 0) {
                throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, getN());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5078.methodEnd();
        }
    }
}

