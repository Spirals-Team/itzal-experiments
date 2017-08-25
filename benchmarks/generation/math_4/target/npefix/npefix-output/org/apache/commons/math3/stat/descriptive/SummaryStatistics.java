package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public class SummaryStatistics implements Serializable , StatisticalSummary {
    private static final long serialVersionUID = -2021321786743555871L;

    private long n = 0;

    private SecondMoment secondMoment = new SecondMoment();

    private Sum sum = new Sum();

    private SumOfSquares sumsq = new SumOfSquares();

    private Min min = new Min();

    private Max max = new Max();

    private SumOfLogs sumLog = new SumOfLogs();

    private GeometricMean geoMean = new GeometricMean(sumLog);

    private Mean mean = new Mean(secondMoment);

    private Variance variance = new Variance(secondMoment);

    private StorelessUnivariateStatistic sumImpl = sum;

    private StorelessUnivariateStatistic sumsqImpl = sumsq;

    private StorelessUnivariateStatistic minImpl = min;

    private StorelessUnivariateStatistic maxImpl = max;

    private StorelessUnivariateStatistic sumLogImpl = sumLog;

    private StorelessUnivariateStatistic geoMeanImpl = geoMean;

    private StorelessUnivariateStatistic meanImpl = mean;

    private StorelessUnivariateStatistic varianceImpl = variance;

    public SummaryStatistics() {
        ConstructorContext _bcornu_methode_context200 = new ConstructorContext(SummaryStatistics.class, 123, 5060, 5155);
        try {
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    public SummaryStatistics(SummaryStatistics original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context201 = new ConstructorContext(SummaryStatistics.class, 132, 5162, 5502);
        try {
            SummaryStatistics.copy(original, this);
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    public StatisticalSummary getSummary() {
        MethodContext _bcornu_methode_context779 = new MethodContext(StatisticalSummary.class, 141, 5509, 5834);
        try {
            CallChecker.varInit(this, "this", 141, 5509, 5834);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 141, 5509, 5834);
            CallChecker.varInit(this.meanImpl, "meanImpl", 141, 5509, 5834);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 141, 5509, 5834);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 141, 5509, 5834);
            CallChecker.varInit(this.maxImpl, "maxImpl", 141, 5509, 5834);
            CallChecker.varInit(this.minImpl, "minImpl", 141, 5509, 5834);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 141, 5509, 5834);
            CallChecker.varInit(this.sumImpl, "sumImpl", 141, 5509, 5834);
            CallChecker.varInit(this.variance, "variance", 141, 5509, 5834);
            CallChecker.varInit(this.mean, "mean", 141, 5509, 5834);
            CallChecker.varInit(this.geoMean, "geoMean", 141, 5509, 5834);
            CallChecker.varInit(this.sumLog, "sumLog", 141, 5509, 5834);
            CallChecker.varInit(this.max, "max", 141, 5509, 5834);
            CallChecker.varInit(this.min, "min", 141, 5509, 5834);
            CallChecker.varInit(this.sumsq, "sumsq", 141, 5509, 5834);
            CallChecker.varInit(this.sum, "sum", 141, 5509, 5834);
            CallChecker.varInit(this.secondMoment, "secondMoment", 141, 5509, 5834);
            CallChecker.varInit(this.n, "n", 141, 5509, 5834);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 141, 5509, 5834);
            return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatisticalSummary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context779.methodEnd();
        }
    }

    public void addValue(double value) {
        MethodContext _bcornu_methode_context780 = new MethodContext(void.class, 150, 5841, 6554);
        try {
            CallChecker.varInit(this, "this", 150, 5841, 6554);
            CallChecker.varInit(value, "value", 150, 5841, 6554);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 150, 5841, 6554);
            CallChecker.varInit(this.meanImpl, "meanImpl", 150, 5841, 6554);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 150, 5841, 6554);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 150, 5841, 6554);
            CallChecker.varInit(this.maxImpl, "maxImpl", 150, 5841, 6554);
            CallChecker.varInit(this.minImpl, "minImpl", 150, 5841, 6554);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 150, 5841, 6554);
            CallChecker.varInit(this.sumImpl, "sumImpl", 150, 5841, 6554);
            CallChecker.varInit(this.variance, "variance", 150, 5841, 6554);
            CallChecker.varInit(this.mean, "mean", 150, 5841, 6554);
            CallChecker.varInit(this.geoMean, "geoMean", 150, 5841, 6554);
            CallChecker.varInit(this.sumLog, "sumLog", 150, 5841, 6554);
            CallChecker.varInit(this.max, "max", 150, 5841, 6554);
            CallChecker.varInit(this.min, "min", 150, 5841, 6554);
            CallChecker.varInit(this.sumsq, "sumsq", 150, 5841, 6554);
            CallChecker.varInit(this.sum, "sum", 150, 5841, 6554);
            CallChecker.varInit(this.secondMoment, "secondMoment", 150, 5841, 6554);
            CallChecker.varInit(this.n, "n", 150, 5841, 6554);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 150, 5841, 6554);
            if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic.class, 151, 5970, 5976)) {
                sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic.class, 151, 5970, 5976);
                CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic.class, 151, 5970, 5976).increment(value);
            }
            if (CallChecker.beforeDeref(sumsqImpl, StorelessUnivariateStatistic.class, 152, 6004, 6012)) {
                sumsqImpl = CallChecker.beforeCalled(sumsqImpl, StorelessUnivariateStatistic.class, 152, 6004, 6012);
                CallChecker.isCalled(sumsqImpl, StorelessUnivariateStatistic.class, 152, 6004, 6012).increment(value);
            }
            if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic.class, 153, 6040, 6046)) {
                minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic.class, 153, 6040, 6046);
                CallChecker.isCalled(minImpl, StorelessUnivariateStatistic.class, 153, 6040, 6046).increment(value);
            }
            if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic.class, 154, 6074, 6080)) {
                maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic.class, 154, 6074, 6080);
                CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic.class, 154, 6074, 6080).increment(value);
            }
            if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic.class, 155, 6108, 6117)) {
                sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic.class, 155, 6108, 6117);
                CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic.class, 155, 6108, 6117).increment(value);
            }
            if (CallChecker.beforeDeref(secondMoment, SecondMoment.class, 156, 6145, 6156)) {
                secondMoment = CallChecker.beforeCalled(secondMoment, SecondMoment.class, 156, 6145, 6156);
                CallChecker.isCalled(secondMoment, SecondMoment.class, 156, 6145, 6156).increment(value);
            }
            if ((meanImpl) != (mean)) {
                if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic.class, 160, 6317, 6324)) {
                    meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic.class, 160, 6317, 6324);
                    CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic.class, 160, 6317, 6324).increment(value);
                }
            }
            if ((varianceImpl) != (variance)) {
                if (CallChecker.beforeDeref(varianceImpl, StorelessUnivariateStatistic.class, 163, 6406, 6417)) {
                    varianceImpl = CallChecker.beforeCalled(varianceImpl, StorelessUnivariateStatistic.class, 163, 6406, 6417);
                    CallChecker.isCalled(varianceImpl, StorelessUnivariateStatistic.class, 163, 6406, 6417).increment(value);
                }
            }
            if ((geoMeanImpl) != (geoMean)) {
                if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic.class, 166, 6497, 6507)) {
                    geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 166, 6497, 6507);
                    CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 166, 6497, 6507).increment(value);
                }
            }
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context780.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context781 = new MethodContext(long.class, 175, 6561, 6712);
        try {
            CallChecker.varInit(this, "this", 175, 6561, 6712);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 175, 6561, 6712);
            CallChecker.varInit(this.meanImpl, "meanImpl", 175, 6561, 6712);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 175, 6561, 6712);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 175, 6561, 6712);
            CallChecker.varInit(this.maxImpl, "maxImpl", 175, 6561, 6712);
            CallChecker.varInit(this.minImpl, "minImpl", 175, 6561, 6712);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 175, 6561, 6712);
            CallChecker.varInit(this.sumImpl, "sumImpl", 175, 6561, 6712);
            CallChecker.varInit(this.variance, "variance", 175, 6561, 6712);
            CallChecker.varInit(this.mean, "mean", 175, 6561, 6712);
            CallChecker.varInit(this.geoMean, "geoMean", 175, 6561, 6712);
            CallChecker.varInit(this.sumLog, "sumLog", 175, 6561, 6712);
            CallChecker.varInit(this.max, "max", 175, 6561, 6712);
            CallChecker.varInit(this.min, "min", 175, 6561, 6712);
            CallChecker.varInit(this.sumsq, "sumsq", 175, 6561, 6712);
            CallChecker.varInit(this.sum, "sum", 175, 6561, 6712);
            CallChecker.varInit(this.secondMoment, "secondMoment", 175, 6561, 6712);
            CallChecker.varInit(this.n, "n", 175, 6561, 6712);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 175, 6561, 6712);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context781.methodEnd();
        }
    }

    public double getSum() {
        MethodContext _bcornu_methode_context782 = new MethodContext(double.class, 183, 6719, 6937);
        try {
            CallChecker.varInit(this, "this", 183, 6719, 6937);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 183, 6719, 6937);
            CallChecker.varInit(this.meanImpl, "meanImpl", 183, 6719, 6937);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 183, 6719, 6937);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 183, 6719, 6937);
            CallChecker.varInit(this.maxImpl, "maxImpl", 183, 6719, 6937);
            CallChecker.varInit(this.minImpl, "minImpl", 183, 6719, 6937);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 183, 6719, 6937);
            CallChecker.varInit(this.sumImpl, "sumImpl", 183, 6719, 6937);
            CallChecker.varInit(this.variance, "variance", 183, 6719, 6937);
            CallChecker.varInit(this.mean, "mean", 183, 6719, 6937);
            CallChecker.varInit(this.geoMean, "geoMean", 183, 6719, 6937);
            CallChecker.varInit(this.sumLog, "sumLog", 183, 6719, 6937);
            CallChecker.varInit(this.max, "max", 183, 6719, 6937);
            CallChecker.varInit(this.min, "min", 183, 6719, 6937);
            CallChecker.varInit(this.sumsq, "sumsq", 183, 6719, 6937);
            CallChecker.varInit(this.sum, "sum", 183, 6719, 6937);
            CallChecker.varInit(this.secondMoment, "secondMoment", 183, 6719, 6937);
            CallChecker.varInit(this.n, "n", 183, 6719, 6937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 183, 6719, 6937);
            if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic.class, 184, 6912, 6918)) {
                sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic.class, 184, 6912, 6918);
                return CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic.class, 184, 6912, 6918).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context782.methodEnd();
        }
    }

    public double getSumsq() {
        MethodContext _bcornu_methode_context783 = new MethodContext(double.class, 194, 6944, 7220);
        try {
            CallChecker.varInit(this, "this", 194, 6944, 7220);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 194, 6944, 7220);
            CallChecker.varInit(this.meanImpl, "meanImpl", 194, 6944, 7220);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 194, 6944, 7220);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 194, 6944, 7220);
            CallChecker.varInit(this.maxImpl, "maxImpl", 194, 6944, 7220);
            CallChecker.varInit(this.minImpl, "minImpl", 194, 6944, 7220);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 194, 6944, 7220);
            CallChecker.varInit(this.sumImpl, "sumImpl", 194, 6944, 7220);
            CallChecker.varInit(this.variance, "variance", 194, 6944, 7220);
            CallChecker.varInit(this.mean, "mean", 194, 6944, 7220);
            CallChecker.varInit(this.geoMean, "geoMean", 194, 6944, 7220);
            CallChecker.varInit(this.sumLog, "sumLog", 194, 6944, 7220);
            CallChecker.varInit(this.max, "max", 194, 6944, 7220);
            CallChecker.varInit(this.min, "min", 194, 6944, 7220);
            CallChecker.varInit(this.sumsq, "sumsq", 194, 6944, 7220);
            CallChecker.varInit(this.sum, "sum", 194, 6944, 7220);
            CallChecker.varInit(this.secondMoment, "secondMoment", 194, 6944, 7220);
            CallChecker.varInit(this.n, "n", 194, 6944, 7220);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 194, 6944, 7220);
            if (CallChecker.beforeDeref(sumsqImpl, StorelessUnivariateStatistic.class, 195, 7193, 7201)) {
                sumsqImpl = CallChecker.beforeCalled(sumsqImpl, StorelessUnivariateStatistic.class, 195, 7193, 7201);
                return CallChecker.isCalled(sumsqImpl, StorelessUnivariateStatistic.class, 195, 7193, 7201).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context783.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context784 = new MethodContext(double.class, 205, 7227, 7477);
        try {
            CallChecker.varInit(this, "this", 205, 7227, 7477);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 205, 7227, 7477);
            CallChecker.varInit(this.meanImpl, "meanImpl", 205, 7227, 7477);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 205, 7227, 7477);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 205, 7227, 7477);
            CallChecker.varInit(this.maxImpl, "maxImpl", 205, 7227, 7477);
            CallChecker.varInit(this.minImpl, "minImpl", 205, 7227, 7477);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 205, 7227, 7477);
            CallChecker.varInit(this.sumImpl, "sumImpl", 205, 7227, 7477);
            CallChecker.varInit(this.variance, "variance", 205, 7227, 7477);
            CallChecker.varInit(this.mean, "mean", 205, 7227, 7477);
            CallChecker.varInit(this.geoMean, "geoMean", 205, 7227, 7477);
            CallChecker.varInit(this.sumLog, "sumLog", 205, 7227, 7477);
            CallChecker.varInit(this.max, "max", 205, 7227, 7477);
            CallChecker.varInit(this.min, "min", 205, 7227, 7477);
            CallChecker.varInit(this.sumsq, "sumsq", 205, 7227, 7477);
            CallChecker.varInit(this.sum, "sum", 205, 7227, 7477);
            CallChecker.varInit(this.secondMoment, "secondMoment", 205, 7227, 7477);
            CallChecker.varInit(this.n, "n", 205, 7227, 7477);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 205, 7227, 7477);
            if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic.class, 206, 7451, 7458)) {
                meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic.class, 206, 7451, 7458);
                return CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic.class, 206, 7451, 7458).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context784.methodEnd();
        }
    }

    public double getStandardDeviation() {
        MethodContext _bcornu_methode_context785 = new MethodContext(double.class, 216, 7484, 7983);
        try {
            CallChecker.varInit(this, "this", 216, 7484, 7983);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 216, 7484, 7983);
            CallChecker.varInit(this.meanImpl, "meanImpl", 216, 7484, 7983);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 216, 7484, 7983);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 216, 7484, 7983);
            CallChecker.varInit(this.maxImpl, "maxImpl", 216, 7484, 7983);
            CallChecker.varInit(this.minImpl, "minImpl", 216, 7484, 7983);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 216, 7484, 7983);
            CallChecker.varInit(this.sumImpl, "sumImpl", 216, 7484, 7983);
            CallChecker.varInit(this.variance, "variance", 216, 7484, 7983);
            CallChecker.varInit(this.mean, "mean", 216, 7484, 7983);
            CallChecker.varInit(this.geoMean, "geoMean", 216, 7484, 7983);
            CallChecker.varInit(this.sumLog, "sumLog", 216, 7484, 7983);
            CallChecker.varInit(this.max, "max", 216, 7484, 7983);
            CallChecker.varInit(this.min, "min", 216, 7484, 7983);
            CallChecker.varInit(this.sumsq, "sumsq", 216, 7484, 7983);
            CallChecker.varInit(this.sum, "sum", 216, 7484, 7983);
            CallChecker.varInit(this.secondMoment, "secondMoment", 216, 7484, 7983);
            CallChecker.varInit(this.n, "n", 216, 7484, 7983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 216, 7484, 7983);
            double stdDev = CallChecker.varInit(((double) (Double.NaN)), "stdDev", 217, 7742, 7768);
            if ((getN()) > 0) {
                if ((getN()) > 1) {
                    stdDev = FastMath.sqrt(getVariance());
                    CallChecker.varAssign(stdDev, "stdDev", 220, 7842, 7879);
                }else {
                    stdDev = 0.0;
                    CallChecker.varAssign(stdDev, "stdDev", 222, 7918, 7930);
                }
            }
            return stdDev;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context785.methodEnd();
        }
    }

    public double getVariance() {
        MethodContext _bcornu_methode_context786 = new MethodContext(double.class, 239, 7990, 8470);
        try {
            CallChecker.varInit(this, "this", 239, 7990, 8470);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 239, 7990, 8470);
            CallChecker.varInit(this.meanImpl, "meanImpl", 239, 7990, 8470);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 239, 7990, 8470);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 239, 7990, 8470);
            CallChecker.varInit(this.maxImpl, "maxImpl", 239, 7990, 8470);
            CallChecker.varInit(this.minImpl, "minImpl", 239, 7990, 8470);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 239, 7990, 8470);
            CallChecker.varInit(this.sumImpl, "sumImpl", 239, 7990, 8470);
            CallChecker.varInit(this.variance, "variance", 239, 7990, 8470);
            CallChecker.varInit(this.mean, "mean", 239, 7990, 8470);
            CallChecker.varInit(this.geoMean, "geoMean", 239, 7990, 8470);
            CallChecker.varInit(this.sumLog, "sumLog", 239, 7990, 8470);
            CallChecker.varInit(this.max, "max", 239, 7990, 8470);
            CallChecker.varInit(this.min, "min", 239, 7990, 8470);
            CallChecker.varInit(this.sumsq, "sumsq", 239, 7990, 8470);
            CallChecker.varInit(this.sum, "sum", 239, 7990, 8470);
            CallChecker.varInit(this.secondMoment, "secondMoment", 239, 7990, 8470);
            CallChecker.varInit(this.n, "n", 239, 7990, 8470);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 239, 7990, 8470);
            if (CallChecker.beforeDeref(varianceImpl, StorelessUnivariateStatistic.class, 240, 8440, 8451)) {
                varianceImpl = CallChecker.beforeCalled(varianceImpl, StorelessUnivariateStatistic.class, 240, 8440, 8451);
                return CallChecker.isCalled(varianceImpl, StorelessUnivariateStatistic.class, 240, 8440, 8451).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context786.methodEnd();
        }
    }

    public double getPopulationVariance() {
        MethodContext _bcornu_methode_context787 = new MethodContext(double.class, 251, 8477, 8976);
        try {
            CallChecker.varInit(this, "this", 251, 8477, 8976);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 251, 8477, 8976);
            CallChecker.varInit(this.meanImpl, "meanImpl", 251, 8477, 8976);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 251, 8477, 8976);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 251, 8477, 8976);
            CallChecker.varInit(this.maxImpl, "maxImpl", 251, 8477, 8976);
            CallChecker.varInit(this.minImpl, "minImpl", 251, 8477, 8976);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 251, 8477, 8976);
            CallChecker.varInit(this.sumImpl, "sumImpl", 251, 8477, 8976);
            CallChecker.varInit(this.variance, "variance", 251, 8477, 8976);
            CallChecker.varInit(this.mean, "mean", 251, 8477, 8976);
            CallChecker.varInit(this.geoMean, "geoMean", 251, 8477, 8976);
            CallChecker.varInit(this.sumLog, "sumLog", 251, 8477, 8976);
            CallChecker.varInit(this.max, "max", 251, 8477, 8976);
            CallChecker.varInit(this.min, "min", 251, 8477, 8976);
            CallChecker.varInit(this.sumsq, "sumsq", 251, 8477, 8976);
            CallChecker.varInit(this.sum, "sum", 251, 8477, 8976);
            CallChecker.varInit(this.secondMoment, "secondMoment", 251, 8477, 8976);
            CallChecker.varInit(this.n, "n", 251, 8477, 8976);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 251, 8477, 8976);
            Variance populationVariance = CallChecker.varInit(new Variance(secondMoment), "populationVariance", 252, 8815, 8871);
            if (CallChecker.beforeDeref(populationVariance, Variance.class, 253, 8881, 8898)) {
                populationVariance = CallChecker.beforeCalled(populationVariance, Variance.class, 253, 8881, 8898);
                CallChecker.isCalled(populationVariance, Variance.class, 253, 8881, 8898).setBiasCorrected(false);
            }
            if (CallChecker.beforeDeref(populationVariance, Variance.class, 254, 8940, 8957)) {
                populationVariance = CallChecker.beforeCalled(populationVariance, Variance.class, 254, 8940, 8957);
                return CallChecker.isCalled(populationVariance, Variance.class, 254, 8940, 8957).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context787.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context788 = new MethodContext(double.class, 264, 8983, 9237);
        try {
            CallChecker.varInit(this, "this", 264, 8983, 9237);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 264, 8983, 9237);
            CallChecker.varInit(this.meanImpl, "meanImpl", 264, 8983, 9237);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 264, 8983, 9237);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 264, 8983, 9237);
            CallChecker.varInit(this.maxImpl, "maxImpl", 264, 8983, 9237);
            CallChecker.varInit(this.minImpl, "minImpl", 264, 8983, 9237);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 264, 8983, 9237);
            CallChecker.varInit(this.sumImpl, "sumImpl", 264, 8983, 9237);
            CallChecker.varInit(this.variance, "variance", 264, 8983, 9237);
            CallChecker.varInit(this.mean, "mean", 264, 8983, 9237);
            CallChecker.varInit(this.geoMean, "geoMean", 264, 8983, 9237);
            CallChecker.varInit(this.sumLog, "sumLog", 264, 8983, 9237);
            CallChecker.varInit(this.max, "max", 264, 8983, 9237);
            CallChecker.varInit(this.min, "min", 264, 8983, 9237);
            CallChecker.varInit(this.sumsq, "sumsq", 264, 8983, 9237);
            CallChecker.varInit(this.sum, "sum", 264, 8983, 9237);
            CallChecker.varInit(this.secondMoment, "secondMoment", 264, 8983, 9237);
            CallChecker.varInit(this.n, "n", 264, 8983, 9237);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 264, 8983, 9237);
            if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic.class, 265, 9212, 9218)) {
                maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic.class, 265, 9212, 9218);
                return CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic.class, 265, 9212, 9218).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context788.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context789 = new MethodContext(double.class, 275, 9244, 9498);
        try {
            CallChecker.varInit(this, "this", 275, 9244, 9498);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 275, 9244, 9498);
            CallChecker.varInit(this.meanImpl, "meanImpl", 275, 9244, 9498);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 275, 9244, 9498);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 275, 9244, 9498);
            CallChecker.varInit(this.maxImpl, "maxImpl", 275, 9244, 9498);
            CallChecker.varInit(this.minImpl, "minImpl", 275, 9244, 9498);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 275, 9244, 9498);
            CallChecker.varInit(this.sumImpl, "sumImpl", 275, 9244, 9498);
            CallChecker.varInit(this.variance, "variance", 275, 9244, 9498);
            CallChecker.varInit(this.mean, "mean", 275, 9244, 9498);
            CallChecker.varInit(this.geoMean, "geoMean", 275, 9244, 9498);
            CallChecker.varInit(this.sumLog, "sumLog", 275, 9244, 9498);
            CallChecker.varInit(this.max, "max", 275, 9244, 9498);
            CallChecker.varInit(this.min, "min", 275, 9244, 9498);
            CallChecker.varInit(this.sumsq, "sumsq", 275, 9244, 9498);
            CallChecker.varInit(this.sum, "sum", 275, 9244, 9498);
            CallChecker.varInit(this.secondMoment, "secondMoment", 275, 9244, 9498);
            CallChecker.varInit(this.n, "n", 275, 9244, 9498);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 275, 9244, 9498);
            if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic.class, 276, 9473, 9479)) {
                minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic.class, 276, 9473, 9479);
                return CallChecker.isCalled(minImpl, StorelessUnivariateStatistic.class, 276, 9473, 9479).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context789.methodEnd();
        }
    }

    public double getGeometricMean() {
        MethodContext _bcornu_methode_context790 = new MethodContext(double.class, 286, 9505, 9787);
        try {
            CallChecker.varInit(this, "this", 286, 9505, 9787);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 286, 9505, 9787);
            CallChecker.varInit(this.meanImpl, "meanImpl", 286, 9505, 9787);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 286, 9505, 9787);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 286, 9505, 9787);
            CallChecker.varInit(this.maxImpl, "maxImpl", 286, 9505, 9787);
            CallChecker.varInit(this.minImpl, "minImpl", 286, 9505, 9787);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 286, 9505, 9787);
            CallChecker.varInit(this.sumImpl, "sumImpl", 286, 9505, 9787);
            CallChecker.varInit(this.variance, "variance", 286, 9505, 9787);
            CallChecker.varInit(this.mean, "mean", 286, 9505, 9787);
            CallChecker.varInit(this.geoMean, "geoMean", 286, 9505, 9787);
            CallChecker.varInit(this.sumLog, "sumLog", 286, 9505, 9787);
            CallChecker.varInit(this.max, "max", 286, 9505, 9787);
            CallChecker.varInit(this.min, "min", 286, 9505, 9787);
            CallChecker.varInit(this.sumsq, "sumsq", 286, 9505, 9787);
            CallChecker.varInit(this.sum, "sum", 286, 9505, 9787);
            CallChecker.varInit(this.secondMoment, "secondMoment", 286, 9505, 9787);
            CallChecker.varInit(this.n, "n", 286, 9505, 9787);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 286, 9505, 9787);
            if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic.class, 287, 9758, 9768)) {
                geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 287, 9758, 9768);
                return CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 287, 9758, 9768).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context790.methodEnd();
        }
    }

    public double getSumOfLogs() {
        MethodContext _bcornu_methode_context791 = new MethodContext(double.class, 298, 9794, 10087);
        try {
            CallChecker.varInit(this, "this", 298, 9794, 10087);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 298, 9794, 10087);
            CallChecker.varInit(this.meanImpl, "meanImpl", 298, 9794, 10087);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 298, 9794, 10087);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 298, 9794, 10087);
            CallChecker.varInit(this.maxImpl, "maxImpl", 298, 9794, 10087);
            CallChecker.varInit(this.minImpl, "minImpl", 298, 9794, 10087);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 298, 9794, 10087);
            CallChecker.varInit(this.sumImpl, "sumImpl", 298, 9794, 10087);
            CallChecker.varInit(this.variance, "variance", 298, 9794, 10087);
            CallChecker.varInit(this.mean, "mean", 298, 9794, 10087);
            CallChecker.varInit(this.geoMean, "geoMean", 298, 9794, 10087);
            CallChecker.varInit(this.sumLog, "sumLog", 298, 9794, 10087);
            CallChecker.varInit(this.max, "max", 298, 9794, 10087);
            CallChecker.varInit(this.min, "min", 298, 9794, 10087);
            CallChecker.varInit(this.sumsq, "sumsq", 298, 9794, 10087);
            CallChecker.varInit(this.sum, "sum", 298, 9794, 10087);
            CallChecker.varInit(this.secondMoment, "secondMoment", 298, 9794, 10087);
            CallChecker.varInit(this.n, "n", 298, 9794, 10087);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 298, 9794, 10087);
            if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic.class, 299, 10059, 10068)) {
                sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic.class, 299, 10059, 10068);
                return CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic.class, 299, 10059, 10068).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context791.methodEnd();
        }
    }

    public double getSecondMoment() {
        MethodContext _bcornu_methode_context792 = new MethodContext(double.class, 313, 10094, 10635);
        try {
            CallChecker.varInit(this, "this", 313, 10094, 10635);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 313, 10094, 10635);
            CallChecker.varInit(this.meanImpl, "meanImpl", 313, 10094, 10635);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 313, 10094, 10635);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 313, 10094, 10635);
            CallChecker.varInit(this.maxImpl, "maxImpl", 313, 10094, 10635);
            CallChecker.varInit(this.minImpl, "minImpl", 313, 10094, 10635);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 313, 10094, 10635);
            CallChecker.varInit(this.sumImpl, "sumImpl", 313, 10094, 10635);
            CallChecker.varInit(this.variance, "variance", 313, 10094, 10635);
            CallChecker.varInit(this.mean, "mean", 313, 10094, 10635);
            CallChecker.varInit(this.geoMean, "geoMean", 313, 10094, 10635);
            CallChecker.varInit(this.sumLog, "sumLog", 313, 10094, 10635);
            CallChecker.varInit(this.max, "max", 313, 10094, 10635);
            CallChecker.varInit(this.min, "min", 313, 10094, 10635);
            CallChecker.varInit(this.sumsq, "sumsq", 313, 10094, 10635);
            CallChecker.varInit(this.sum, "sum", 313, 10094, 10635);
            CallChecker.varInit(this.secondMoment, "secondMoment", 313, 10094, 10635);
            CallChecker.varInit(this.n, "n", 313, 10094, 10635);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 313, 10094, 10635);
            if (CallChecker.beforeDeref(secondMoment, SecondMoment.class, 314, 10605, 10616)) {
                secondMoment = CallChecker.beforeCalled(secondMoment, SecondMoment.class, 314, 10605, 10616);
                return CallChecker.isCalled(secondMoment, SecondMoment.class, 314, 10605, 10616).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context792.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context793 = new MethodContext(String.class, 324, 10642, 11760);
        try {
            CallChecker.varInit(this, "this", 324, 10642, 11760);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 324, 10642, 11760);
            CallChecker.varInit(this.meanImpl, "meanImpl", 324, 10642, 11760);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 324, 10642, 11760);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 324, 10642, 11760);
            CallChecker.varInit(this.maxImpl, "maxImpl", 324, 10642, 11760);
            CallChecker.varInit(this.minImpl, "minImpl", 324, 10642, 11760);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 324, 10642, 11760);
            CallChecker.varInit(this.sumImpl, "sumImpl", 324, 10642, 11760);
            CallChecker.varInit(this.variance, "variance", 324, 10642, 11760);
            CallChecker.varInit(this.mean, "mean", 324, 10642, 11760);
            CallChecker.varInit(this.geoMean, "geoMean", 324, 10642, 11760);
            CallChecker.varInit(this.sumLog, "sumLog", 324, 10642, 11760);
            CallChecker.varInit(this.max, "max", 324, 10642, 11760);
            CallChecker.varInit(this.min, "min", 324, 10642, 11760);
            CallChecker.varInit(this.sumsq, "sumsq", 324, 10642, 11760);
            CallChecker.varInit(this.sum, "sum", 324, 10642, 11760);
            CallChecker.varInit(this.secondMoment, "secondMoment", 324, 10642, 11760);
            CallChecker.varInit(this.n, "n", 324, 10642, 11760);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 324, 10642, 11760);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 325, 10887, 10932);
            String endl = CallChecker.varInit("\n", "endl", 326, 10942, 10960);
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 327, 10970, 10978)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 327, 10970, 10978);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 327, 10970, 10978).append("SummaryStatistics:"), StringBuilder.class, 327, 10970, 11007)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 327, 10970, 10978);
                    CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 327, 10970, 10978).append("SummaryStatistics:"), StringBuilder.class, 327, 10970, 11007).append(endl);
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 328, 11031, 11039)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 328, 11031, 11039);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 328, 11031, 11039).append("n: "), StringBuilder.class, 328, 11031, 11053)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 328, 11031, 11039);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 328, 11031, 11039).append("n: "), StringBuilder.class, 328, 11031, 11053).append(getN()), StringBuilder.class, 328, 11031, 11068)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 328, 11031, 11039);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 328, 11031, 11039).append("n: "), StringBuilder.class, 328, 11031, 11053).append(getN()), StringBuilder.class, 328, 11031, 11068).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 329, 11092, 11100)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 329, 11092, 11100);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 329, 11092, 11100).append("min: "), StringBuilder.class, 329, 11092, 11116)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 329, 11092, 11100);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 329, 11092, 11100).append("min: "), StringBuilder.class, 329, 11092, 11116).append(getMin()), StringBuilder.class, 329, 11092, 11133)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 329, 11092, 11100);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 329, 11092, 11100).append("min: "), StringBuilder.class, 329, 11092, 11116).append(getMin()), StringBuilder.class, 329, 11092, 11133).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 330, 11157, 11165)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 330, 11157, 11165);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 330, 11157, 11165).append("max: "), StringBuilder.class, 330, 11157, 11181)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 330, 11157, 11165);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 330, 11157, 11165).append("max: "), StringBuilder.class, 330, 11157, 11181).append(getMax()), StringBuilder.class, 330, 11157, 11198)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 330, 11157, 11165);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 330, 11157, 11165).append("max: "), StringBuilder.class, 330, 11157, 11181).append(getMax()), StringBuilder.class, 330, 11157, 11198).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 331, 11222, 11230)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 331, 11222, 11230);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 331, 11222, 11230).append("mean: "), StringBuilder.class, 331, 11222, 11247)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 331, 11222, 11230);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 331, 11222, 11230).append("mean: "), StringBuilder.class, 331, 11222, 11247).append(getMean()), StringBuilder.class, 331, 11222, 11265)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 331, 11222, 11230);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 331, 11222, 11230).append("mean: "), StringBuilder.class, 331, 11222, 11247).append(getMean()), StringBuilder.class, 331, 11222, 11265).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 332, 11289, 11297)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 332, 11289, 11297);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 332, 11289, 11297).append("geometric mean: "), StringBuilder.class, 332, 11289, 11324)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 332, 11289, 11297);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 332, 11289, 11297).append("geometric mean: "), StringBuilder.class, 332, 11289, 11324).append(getGeometricMean()), StringBuilder.class, 332, 11289, 11351)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 332, 11289, 11297);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 332, 11289, 11297).append("geometric mean: "), StringBuilder.class, 332, 11289, 11324).append(getGeometricMean()), StringBuilder.class, 332, 11289, 11351).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 334, 11388, 11396)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 334, 11388, 11396);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 334, 11388, 11396).append("variance: "), StringBuilder.class, 334, 11388, 11417)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 334, 11388, 11396);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 334, 11388, 11396).append("variance: "), StringBuilder.class, 334, 11388, 11417).append(getVariance()), StringBuilder.class, 334, 11388, 11439)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 334, 11388, 11396);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 334, 11388, 11396).append("variance: "), StringBuilder.class, 334, 11388, 11417).append(getVariance()), StringBuilder.class, 334, 11388, 11439).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 335, 11463, 11471)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 335, 11463, 11471);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 335, 11463, 11471).append("sum of squares: "), StringBuilder.class, 335, 11463, 11498)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 335, 11463, 11471);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 335, 11463, 11471).append("sum of squares: "), StringBuilder.class, 335, 11463, 11498).append(getSumsq()), StringBuilder.class, 335, 11463, 11517)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 335, 11463, 11471);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 335, 11463, 11471).append("sum of squares: "), StringBuilder.class, 335, 11463, 11498).append(getSumsq()), StringBuilder.class, 335, 11463, 11517).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 336, 11541, 11549)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 336, 11541, 11549);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 336, 11541, 11549).append("standard deviation: "), StringBuilder.class, 336, 11541, 11580)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 336, 11541, 11549);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 336, 11541, 11549).append("standard deviation: "), StringBuilder.class, 336, 11541, 11580).append(getStandardDeviation()), StringBuilder.class, 336, 11541, 11611)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 336, 11541, 11549);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 336, 11541, 11549).append("standard deviation: "), StringBuilder.class, 336, 11541, 11580).append(getStandardDeviation()), StringBuilder.class, 336, 11541, 11611).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 338, 11648, 11656)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 338, 11648, 11656);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 338, 11648, 11656).append("sum of logs: "), StringBuilder.class, 338, 11648, 11680)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 338, 11648, 11656);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 338, 11648, 11656).append("sum of logs: "), StringBuilder.class, 338, 11648, 11680).append(getSumOfLogs()), StringBuilder.class, 338, 11648, 11703)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 338, 11648, 11656);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 338, 11648, 11656).append("sum of logs: "), StringBuilder.class, 338, 11648, 11680).append(getSumOfLogs()), StringBuilder.class, 338, 11648, 11703).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 339, 11734, 11742)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 339, 11734, 11742);
                return CallChecker.isCalled(outBuffer, StringBuilder.class, 339, 11734, 11742).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context793.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context794 = new MethodContext(void.class, 345, 11767, 12215);
        try {
            CallChecker.varInit(this, "this", 345, 11767, 12215);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 345, 11767, 12215);
            CallChecker.varInit(this.meanImpl, "meanImpl", 345, 11767, 12215);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 345, 11767, 12215);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 345, 11767, 12215);
            CallChecker.varInit(this.maxImpl, "maxImpl", 345, 11767, 12215);
            CallChecker.varInit(this.minImpl, "minImpl", 345, 11767, 12215);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 345, 11767, 12215);
            CallChecker.varInit(this.sumImpl, "sumImpl", 345, 11767, 12215);
            CallChecker.varInit(this.variance, "variance", 345, 11767, 12215);
            CallChecker.varInit(this.mean, "mean", 345, 11767, 12215);
            CallChecker.varInit(this.geoMean, "geoMean", 345, 11767, 12215);
            CallChecker.varInit(this.sumLog, "sumLog", 345, 11767, 12215);
            CallChecker.varInit(this.max, "max", 345, 11767, 12215);
            CallChecker.varInit(this.min, "min", 345, 11767, 12215);
            CallChecker.varInit(this.sumsq, "sumsq", 345, 11767, 12215);
            CallChecker.varInit(this.sum, "sum", 345, 11767, 12215);
            CallChecker.varInit(this.secondMoment, "secondMoment", 345, 11767, 12215);
            CallChecker.varInit(this.n, "n", 345, 11767, 12215);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 345, 11767, 12215);
            this.n = 0;
            CallChecker.varAssign(this.n, "this.n", 346, 11854, 11864);
            if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic.class, 347, 11874, 11880)) {
                minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic.class, 347, 11874, 11880);
                CallChecker.isCalled(minImpl, StorelessUnivariateStatistic.class, 347, 11874, 11880).clear();
            }
            if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic.class, 348, 11899, 11905)) {
                maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic.class, 348, 11899, 11905);
                CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic.class, 348, 11899, 11905).clear();
            }
            if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic.class, 349, 11924, 11930)) {
                sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic.class, 349, 11924, 11930);
                CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic.class, 349, 11924, 11930).clear();
            }
            if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic.class, 350, 11949, 11958)) {
                sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic.class, 350, 11949, 11958);
                CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic.class, 350, 11949, 11958).clear();
            }
            if (CallChecker.beforeDeref(sumsqImpl, StorelessUnivariateStatistic.class, 351, 11977, 11985)) {
                sumsqImpl = CallChecker.beforeCalled(sumsqImpl, StorelessUnivariateStatistic.class, 351, 11977, 11985);
                CallChecker.isCalled(sumsqImpl, StorelessUnivariateStatistic.class, 351, 11977, 11985).clear();
            }
            if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic.class, 352, 12004, 12014)) {
                geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 352, 12004, 12014);
                CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic.class, 352, 12004, 12014).clear();
            }
            if (CallChecker.beforeDeref(secondMoment, SecondMoment.class, 353, 12033, 12044)) {
                secondMoment = CallChecker.beforeCalled(secondMoment, SecondMoment.class, 353, 12033, 12044);
                CallChecker.isCalled(secondMoment, SecondMoment.class, 353, 12033, 12044).clear();
            }
            if ((meanImpl) != (mean)) {
                if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic.class, 355, 12099, 12106)) {
                    meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic.class, 355, 12099, 12106);
                    CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic.class, 355, 12099, 12106).clear();
                }
            }
            if ((varianceImpl) != (variance)) {
                if (CallChecker.beforeDeref(varianceImpl, StorelessUnivariateStatistic.class, 358, 12179, 12190)) {
                    varianceImpl = CallChecker.beforeCalled(varianceImpl, StorelessUnivariateStatistic.class, 358, 12179, 12190);
                    CallChecker.isCalled(varianceImpl, StorelessUnivariateStatistic.class, 358, 12179, 12190).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context794.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context795 = new MethodContext(boolean.class, 370, 12222, 13497);
        try {
            CallChecker.varInit(this, "this", 370, 12222, 13497);
            CallChecker.varInit(object, "object", 370, 12222, 13497);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 370, 12222, 13497);
            CallChecker.varInit(this.meanImpl, "meanImpl", 370, 12222, 13497);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 370, 12222, 13497);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 370, 12222, 13497);
            CallChecker.varInit(this.maxImpl, "maxImpl", 370, 12222, 13497);
            CallChecker.varInit(this.minImpl, "minImpl", 370, 12222, 13497);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 370, 12222, 13497);
            CallChecker.varInit(this.sumImpl, "sumImpl", 370, 12222, 13497);
            CallChecker.varInit(this.variance, "variance", 370, 12222, 13497);
            CallChecker.varInit(this.mean, "mean", 370, 12222, 13497);
            CallChecker.varInit(this.geoMean, "geoMean", 370, 12222, 13497);
            CallChecker.varInit(this.sumLog, "sumLog", 370, 12222, 13497);
            CallChecker.varInit(this.max, "max", 370, 12222, 13497);
            CallChecker.varInit(this.min, "min", 370, 12222, 13497);
            CallChecker.varInit(this.sumsq, "sumsq", 370, 12222, 13497);
            CallChecker.varInit(this.sum, "sum", 370, 12222, 13497);
            CallChecker.varInit(this.secondMoment, "secondMoment", 370, 12222, 13497);
            CallChecker.varInit(this.n, "n", 370, 12222, 13497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 370, 12222, 13497);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof SummaryStatistics) == false) {
                return false;
            }
            SummaryStatistics stat = CallChecker.varInit(((SummaryStatistics) (object)), "stat", 377, 12712, 12762);
            if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 378, 12808, 12811)) {
                if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 379, 12900, 12903)) {
                    if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 380, 12992, 12995)) {
                        if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 381, 13084, 13087)) {
                            if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 382, 13176, 13179)) {
                                if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 383, 13268, 13271)) {
                                    if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 384, 13360, 13363)) {
                                        if (CallChecker.beforeDeref(stat, SummaryStatistics.class, 385, 13452, 13455)) {
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 378, 12808, 12811);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 379, 12900, 12903);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 380, 12992, 12995);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 381, 13084, 13087);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 382, 13176, 13179);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 383, 13268, 13271);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 384, 13360, 13363);
                                            stat = CallChecker.beforeCalled(stat, SummaryStatistics.class, 385, 13452, 13455);
                                            return (((((((Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 378, 12808, 12811).getGeometricMean(), getGeometricMean())) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 379, 12900, 12903).getMax(), getMax()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 380, 12992, 12995).getMean(), getMean()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 381, 13084, 13087).getMin(), getMin()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 382, 13176, 13179).getN(), getN()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 383, 13268, 13271).getSum(), getSum()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 384, 13360, 13363).getSumsq(), getSumsq()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, SummaryStatistics.class, 385, 13452, 13455).getVariance(), getVariance()));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context795.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context796 = new MethodContext(int.class, 393, 13504, 14199);
        try {
            CallChecker.varInit(this, "this", 393, 13504, 14199);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 393, 13504, 14199);
            CallChecker.varInit(this.meanImpl, "meanImpl", 393, 13504, 14199);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 393, 13504, 14199);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 393, 13504, 14199);
            CallChecker.varInit(this.maxImpl, "maxImpl", 393, 13504, 14199);
            CallChecker.varInit(this.minImpl, "minImpl", 393, 13504, 14199);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 393, 13504, 14199);
            CallChecker.varInit(this.sumImpl, "sumImpl", 393, 13504, 14199);
            CallChecker.varInit(this.variance, "variance", 393, 13504, 14199);
            CallChecker.varInit(this.mean, "mean", 393, 13504, 14199);
            CallChecker.varInit(this.geoMean, "geoMean", 393, 13504, 14199);
            CallChecker.varInit(this.sumLog, "sumLog", 393, 13504, 14199);
            CallChecker.varInit(this.max, "max", 393, 13504, 14199);
            CallChecker.varInit(this.min, "min", 393, 13504, 14199);
            CallChecker.varInit(this.sumsq, "sumsq", 393, 13504, 14199);
            CallChecker.varInit(this.sum, "sum", 393, 13504, 14199);
            CallChecker.varInit(this.secondMoment, "secondMoment", 393, 13504, 14199);
            CallChecker.varInit(this.n, "n", 393, 13504, 14199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 393, 13504, 14199);
            int result = CallChecker.varInit(((int) (31 + (MathUtils.hash(getGeometricMean())))), "result", 394, 13646, 13698);
            result = (result * 31) + (MathUtils.hash(getGeometricMean()));
            CallChecker.varAssign(result, "result", 395, 13708, 13765);
            result = (result * 31) + (MathUtils.hash(getMax()));
            CallChecker.varAssign(result, "result", 396, 13775, 13822);
            result = (result * 31) + (MathUtils.hash(getMean()));
            CallChecker.varAssign(result, "result", 397, 13832, 13880);
            result = (result * 31) + (MathUtils.hash(getMin()));
            CallChecker.varAssign(result, "result", 398, 13890, 13937);
            result = (result * 31) + (MathUtils.hash(getN()));
            CallChecker.varAssign(result, "result", 399, 13947, 13992);
            result = (result * 31) + (MathUtils.hash(getSum()));
            CallChecker.varAssign(result, "result", 400, 14002, 14049);
            result = (result * 31) + (MathUtils.hash(getSumsq()));
            CallChecker.varAssign(result, "result", 401, 14059, 14108);
            result = (result * 31) + (MathUtils.hash(getVariance()));
            CallChecker.varAssign(result, "result", 402, 14118, 14170);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context796.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getSumImpl() {
        MethodContext _bcornu_methode_context797 = new MethodContext(StorelessUnivariateStatistic.class, 412, 14206, 14505);
        try {
            CallChecker.varInit(this, "this", 412, 14206, 14505);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 412, 14206, 14505);
            CallChecker.varInit(this.meanImpl, "meanImpl", 412, 14206, 14505);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 412, 14206, 14505);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 412, 14206, 14505);
            CallChecker.varInit(this.maxImpl, "maxImpl", 412, 14206, 14505);
            CallChecker.varInit(this.minImpl, "minImpl", 412, 14206, 14505);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 412, 14206, 14505);
            CallChecker.varInit(this.sumImpl, "sumImpl", 412, 14206, 14505);
            CallChecker.varInit(this.variance, "variance", 412, 14206, 14505);
            CallChecker.varInit(this.mean, "mean", 412, 14206, 14505);
            CallChecker.varInit(this.geoMean, "geoMean", 412, 14206, 14505);
            CallChecker.varInit(this.sumLog, "sumLog", 412, 14206, 14505);
            CallChecker.varInit(this.max, "max", 412, 14206, 14505);
            CallChecker.varInit(this.min, "min", 412, 14206, 14505);
            CallChecker.varInit(this.sumsq, "sumsq", 412, 14206, 14505);
            CallChecker.varInit(this.sum, "sum", 412, 14206, 14505);
            CallChecker.varInit(this.secondMoment, "secondMoment", 412, 14206, 14505);
            CallChecker.varInit(this.n, "n", 412, 14206, 14505);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 412, 14206, 14505);
            return sumImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context797.methodEnd();
        }
    }

    public void setSumImpl(StorelessUnivariateStatistic sumImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context798 = new MethodContext(void.class, 430, 14512, 15197);
        try {
            CallChecker.varInit(this, "this", 430, 14512, 15197);
            CallChecker.varInit(sumImpl, "sumImpl", 430, 14512, 15197);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 430, 14512, 15197);
            CallChecker.varInit(this.meanImpl, "meanImpl", 430, 14512, 15197);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 430, 14512, 15197);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 430, 14512, 15197);
            CallChecker.varInit(this.maxImpl, "maxImpl", 430, 14512, 15197);
            CallChecker.varInit(this.minImpl, "minImpl", 430, 14512, 15197);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 430, 14512, 15197);
            CallChecker.varInit(this.sumImpl, "sumImpl", 430, 14512, 15197);
            CallChecker.varInit(this.variance, "variance", 430, 14512, 15197);
            CallChecker.varInit(this.mean, "mean", 430, 14512, 15197);
            CallChecker.varInit(this.geoMean, "geoMean", 430, 14512, 15197);
            CallChecker.varInit(this.sumLog, "sumLog", 430, 14512, 15197);
            CallChecker.varInit(this.max, "max", 430, 14512, 15197);
            CallChecker.varInit(this.min, "min", 430, 14512, 15197);
            CallChecker.varInit(this.sumsq, "sumsq", 430, 14512, 15197);
            CallChecker.varInit(this.sum, "sum", 430, 14512, 15197);
            CallChecker.varInit(this.secondMoment, "secondMoment", 430, 14512, 15197);
            CallChecker.varInit(this.n, "n", 430, 14512, 15197);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 430, 14512, 15197);
            checkEmpty();
            this.sumImpl = sumImpl;
            CallChecker.varAssign(this.sumImpl, "this.sumImpl", 433, 15169, 15191);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context798.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getSumsqImpl() {
        MethodContext _bcornu_methode_context799 = new MethodContext(StorelessUnivariateStatistic.class, 441, 15204, 15471);
        try {
            CallChecker.varInit(this, "this", 441, 15204, 15471);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 441, 15204, 15471);
            CallChecker.varInit(this.meanImpl, "meanImpl", 441, 15204, 15471);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 441, 15204, 15471);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 441, 15204, 15471);
            CallChecker.varInit(this.maxImpl, "maxImpl", 441, 15204, 15471);
            CallChecker.varInit(this.minImpl, "minImpl", 441, 15204, 15471);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 441, 15204, 15471);
            CallChecker.varInit(this.sumImpl, "sumImpl", 441, 15204, 15471);
            CallChecker.varInit(this.variance, "variance", 441, 15204, 15471);
            CallChecker.varInit(this.mean, "mean", 441, 15204, 15471);
            CallChecker.varInit(this.geoMean, "geoMean", 441, 15204, 15471);
            CallChecker.varInit(this.sumLog, "sumLog", 441, 15204, 15471);
            CallChecker.varInit(this.max, "max", 441, 15204, 15471);
            CallChecker.varInit(this.min, "min", 441, 15204, 15471);
            CallChecker.varInit(this.sumsq, "sumsq", 441, 15204, 15471);
            CallChecker.varInit(this.sum, "sum", 441, 15204, 15471);
            CallChecker.varInit(this.secondMoment, "secondMoment", 441, 15204, 15471);
            CallChecker.varInit(this.n, "n", 441, 15204, 15471);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 441, 15204, 15471);
            return sumsqImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context799.methodEnd();
        }
    }

    public void setSumsqImpl(StorelessUnivariateStatistic sumsqImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context800 = new MethodContext(void.class, 459, 15478, 16196);
        try {
            CallChecker.varInit(this, "this", 459, 15478, 16196);
            CallChecker.varInit(sumsqImpl, "sumsqImpl", 459, 15478, 16196);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 459, 15478, 16196);
            CallChecker.varInit(this.meanImpl, "meanImpl", 459, 15478, 16196);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 459, 15478, 16196);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 459, 15478, 16196);
            CallChecker.varInit(this.maxImpl, "maxImpl", 459, 15478, 16196);
            CallChecker.varInit(this.minImpl, "minImpl", 459, 15478, 16196);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 459, 15478, 16196);
            CallChecker.varInit(this.sumImpl, "sumImpl", 459, 15478, 16196);
            CallChecker.varInit(this.variance, "variance", 459, 15478, 16196);
            CallChecker.varInit(this.mean, "mean", 459, 15478, 16196);
            CallChecker.varInit(this.geoMean, "geoMean", 459, 15478, 16196);
            CallChecker.varInit(this.sumLog, "sumLog", 459, 15478, 16196);
            CallChecker.varInit(this.max, "max", 459, 15478, 16196);
            CallChecker.varInit(this.min, "min", 459, 15478, 16196);
            CallChecker.varInit(this.sumsq, "sumsq", 459, 15478, 16196);
            CallChecker.varInit(this.sum, "sum", 459, 15478, 16196);
            CallChecker.varInit(this.secondMoment, "secondMoment", 459, 15478, 16196);
            CallChecker.varInit(this.n, "n", 459, 15478, 16196);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 459, 15478, 16196);
            checkEmpty();
            this.sumsqImpl = sumsqImpl;
            CallChecker.varAssign(this.sumsqImpl, "this.sumsqImpl", 462, 16164, 16190);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context800.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getMinImpl() {
        MethodContext _bcornu_methode_context801 = new MethodContext(StorelessUnivariateStatistic.class, 470, 16203, 16452);
        try {
            CallChecker.varInit(this, "this", 470, 16203, 16452);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 470, 16203, 16452);
            CallChecker.varInit(this.meanImpl, "meanImpl", 470, 16203, 16452);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 470, 16203, 16452);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 470, 16203, 16452);
            CallChecker.varInit(this.maxImpl, "maxImpl", 470, 16203, 16452);
            CallChecker.varInit(this.minImpl, "minImpl", 470, 16203, 16452);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 470, 16203, 16452);
            CallChecker.varInit(this.sumImpl, "sumImpl", 470, 16203, 16452);
            CallChecker.varInit(this.variance, "variance", 470, 16203, 16452);
            CallChecker.varInit(this.mean, "mean", 470, 16203, 16452);
            CallChecker.varInit(this.geoMean, "geoMean", 470, 16203, 16452);
            CallChecker.varInit(this.sumLog, "sumLog", 470, 16203, 16452);
            CallChecker.varInit(this.max, "max", 470, 16203, 16452);
            CallChecker.varInit(this.min, "min", 470, 16203, 16452);
            CallChecker.varInit(this.sumsq, "sumsq", 470, 16203, 16452);
            CallChecker.varInit(this.sum, "sum", 470, 16203, 16452);
            CallChecker.varInit(this.secondMoment, "secondMoment", 470, 16203, 16452);
            CallChecker.varInit(this.n, "n", 470, 16203, 16452);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 470, 16203, 16452);
            return minImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context801.methodEnd();
        }
    }

    public void setMinImpl(StorelessUnivariateStatistic minImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context802 = new MethodContext(void.class, 488, 16459, 17153);
        try {
            CallChecker.varInit(this, "this", 488, 16459, 17153);
            CallChecker.varInit(minImpl, "minImpl", 488, 16459, 17153);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 488, 16459, 17153);
            CallChecker.varInit(this.meanImpl, "meanImpl", 488, 16459, 17153);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 488, 16459, 17153);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 488, 16459, 17153);
            CallChecker.varInit(this.maxImpl, "maxImpl", 488, 16459, 17153);
            CallChecker.varInit(this.minImpl, "minImpl", 488, 16459, 17153);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 488, 16459, 17153);
            CallChecker.varInit(this.sumImpl, "sumImpl", 488, 16459, 17153);
            CallChecker.varInit(this.variance, "variance", 488, 16459, 17153);
            CallChecker.varInit(this.mean, "mean", 488, 16459, 17153);
            CallChecker.varInit(this.geoMean, "geoMean", 488, 16459, 17153);
            CallChecker.varInit(this.sumLog, "sumLog", 488, 16459, 17153);
            CallChecker.varInit(this.max, "max", 488, 16459, 17153);
            CallChecker.varInit(this.min, "min", 488, 16459, 17153);
            CallChecker.varInit(this.sumsq, "sumsq", 488, 16459, 17153);
            CallChecker.varInit(this.sum, "sum", 488, 16459, 17153);
            CallChecker.varInit(this.secondMoment, "secondMoment", 488, 16459, 17153);
            CallChecker.varInit(this.n, "n", 488, 16459, 17153);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 488, 16459, 17153);
            checkEmpty();
            this.minImpl = minImpl;
            CallChecker.varAssign(this.minImpl, "this.minImpl", 491, 17125, 17147);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context802.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getMaxImpl() {
        MethodContext _bcornu_methode_context803 = new MethodContext(StorelessUnivariateStatistic.class, 499, 17160, 17409);
        try {
            CallChecker.varInit(this, "this", 499, 17160, 17409);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 499, 17160, 17409);
            CallChecker.varInit(this.meanImpl, "meanImpl", 499, 17160, 17409);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 499, 17160, 17409);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 499, 17160, 17409);
            CallChecker.varInit(this.maxImpl, "maxImpl", 499, 17160, 17409);
            CallChecker.varInit(this.minImpl, "minImpl", 499, 17160, 17409);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 499, 17160, 17409);
            CallChecker.varInit(this.sumImpl, "sumImpl", 499, 17160, 17409);
            CallChecker.varInit(this.variance, "variance", 499, 17160, 17409);
            CallChecker.varInit(this.mean, "mean", 499, 17160, 17409);
            CallChecker.varInit(this.geoMean, "geoMean", 499, 17160, 17409);
            CallChecker.varInit(this.sumLog, "sumLog", 499, 17160, 17409);
            CallChecker.varInit(this.max, "max", 499, 17160, 17409);
            CallChecker.varInit(this.min, "min", 499, 17160, 17409);
            CallChecker.varInit(this.sumsq, "sumsq", 499, 17160, 17409);
            CallChecker.varInit(this.sum, "sum", 499, 17160, 17409);
            CallChecker.varInit(this.secondMoment, "secondMoment", 499, 17160, 17409);
            CallChecker.varInit(this.n, "n", 499, 17160, 17409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 499, 17160, 17409);
            return maxImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context803.methodEnd();
        }
    }

    public void setMaxImpl(StorelessUnivariateStatistic maxImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context804 = new MethodContext(void.class, 517, 17416, 18110);
        try {
            CallChecker.varInit(this, "this", 517, 17416, 18110);
            CallChecker.varInit(maxImpl, "maxImpl", 517, 17416, 18110);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 517, 17416, 18110);
            CallChecker.varInit(this.meanImpl, "meanImpl", 517, 17416, 18110);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 517, 17416, 18110);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 517, 17416, 18110);
            CallChecker.varInit(this.maxImpl, "maxImpl", 517, 17416, 18110);
            CallChecker.varInit(this.minImpl, "minImpl", 517, 17416, 18110);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 517, 17416, 18110);
            CallChecker.varInit(this.sumImpl, "sumImpl", 517, 17416, 18110);
            CallChecker.varInit(this.variance, "variance", 517, 17416, 18110);
            CallChecker.varInit(this.mean, "mean", 517, 17416, 18110);
            CallChecker.varInit(this.geoMean, "geoMean", 517, 17416, 18110);
            CallChecker.varInit(this.sumLog, "sumLog", 517, 17416, 18110);
            CallChecker.varInit(this.max, "max", 517, 17416, 18110);
            CallChecker.varInit(this.min, "min", 517, 17416, 18110);
            CallChecker.varInit(this.sumsq, "sumsq", 517, 17416, 18110);
            CallChecker.varInit(this.sum, "sum", 517, 17416, 18110);
            CallChecker.varInit(this.secondMoment, "secondMoment", 517, 17416, 18110);
            CallChecker.varInit(this.n, "n", 517, 17416, 18110);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 517, 17416, 18110);
            checkEmpty();
            this.maxImpl = maxImpl;
            CallChecker.varAssign(this.maxImpl, "this.maxImpl", 520, 18082, 18104);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context804.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getSumLogImpl() {
        MethodContext _bcornu_methode_context805 = new MethodContext(StorelessUnivariateStatistic.class, 528, 18117, 18376);
        try {
            CallChecker.varInit(this, "this", 528, 18117, 18376);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 528, 18117, 18376);
            CallChecker.varInit(this.meanImpl, "meanImpl", 528, 18117, 18376);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 528, 18117, 18376);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 528, 18117, 18376);
            CallChecker.varInit(this.maxImpl, "maxImpl", 528, 18117, 18376);
            CallChecker.varInit(this.minImpl, "minImpl", 528, 18117, 18376);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 528, 18117, 18376);
            CallChecker.varInit(this.sumImpl, "sumImpl", 528, 18117, 18376);
            CallChecker.varInit(this.variance, "variance", 528, 18117, 18376);
            CallChecker.varInit(this.mean, "mean", 528, 18117, 18376);
            CallChecker.varInit(this.geoMean, "geoMean", 528, 18117, 18376);
            CallChecker.varInit(this.sumLog, "sumLog", 528, 18117, 18376);
            CallChecker.varInit(this.max, "max", 528, 18117, 18376);
            CallChecker.varInit(this.min, "min", 528, 18117, 18376);
            CallChecker.varInit(this.sumsq, "sumsq", 528, 18117, 18376);
            CallChecker.varInit(this.sum, "sum", 528, 18117, 18376);
            CallChecker.varInit(this.secondMoment, "secondMoment", 528, 18117, 18376);
            CallChecker.varInit(this.n, "n", 528, 18117, 18376);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 528, 18117, 18376);
            return sumLogImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context805.methodEnd();
        }
    }

    public void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context806 = new MethodContext(void.class, 546, 18383, 19139);
        try {
            CallChecker.varInit(this, "this", 546, 18383, 19139);
            CallChecker.varInit(sumLogImpl, "sumLogImpl", 546, 18383, 19139);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 546, 18383, 19139);
            CallChecker.varInit(this.meanImpl, "meanImpl", 546, 18383, 19139);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 546, 18383, 19139);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 546, 18383, 19139);
            CallChecker.varInit(this.maxImpl, "maxImpl", 546, 18383, 19139);
            CallChecker.varInit(this.minImpl, "minImpl", 546, 18383, 19139);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 546, 18383, 19139);
            CallChecker.varInit(this.sumImpl, "sumImpl", 546, 18383, 19139);
            CallChecker.varInit(this.variance, "variance", 546, 18383, 19139);
            CallChecker.varInit(this.mean, "mean", 546, 18383, 19139);
            CallChecker.varInit(this.geoMean, "geoMean", 546, 18383, 19139);
            CallChecker.varInit(this.sumLog, "sumLog", 546, 18383, 19139);
            CallChecker.varInit(this.max, "max", 546, 18383, 19139);
            CallChecker.varInit(this.min, "min", 546, 18383, 19139);
            CallChecker.varInit(this.sumsq, "sumsq", 546, 18383, 19139);
            CallChecker.varInit(this.sum, "sum", 546, 18383, 19139);
            CallChecker.varInit(this.secondMoment, "secondMoment", 546, 18383, 19139);
            CallChecker.varInit(this.n, "n", 546, 18383, 19139);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 546, 18383, 19139);
            checkEmpty();
            this.sumLogImpl = sumLogImpl;
            CallChecker.varAssign(this.sumLogImpl, "this.sumLogImpl", 549, 19062, 19090);
            if (CallChecker.beforeDeref(geoMean, GeometricMean.class, 550, 19100, 19106)) {
                geoMean = CallChecker.beforeCalled(geoMean, GeometricMean.class, 550, 19100, 19106);
                CallChecker.isCalled(geoMean, GeometricMean.class, 550, 19100, 19106).setSumLogImpl(sumLogImpl);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context806.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getGeoMeanImpl() {
        MethodContext _bcornu_methode_context807 = new MethodContext(StorelessUnivariateStatistic.class, 558, 19146, 19417);
        try {
            CallChecker.varInit(this, "this", 558, 19146, 19417);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 558, 19146, 19417);
            CallChecker.varInit(this.meanImpl, "meanImpl", 558, 19146, 19417);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 558, 19146, 19417);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 558, 19146, 19417);
            CallChecker.varInit(this.maxImpl, "maxImpl", 558, 19146, 19417);
            CallChecker.varInit(this.minImpl, "minImpl", 558, 19146, 19417);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 558, 19146, 19417);
            CallChecker.varInit(this.sumImpl, "sumImpl", 558, 19146, 19417);
            CallChecker.varInit(this.variance, "variance", 558, 19146, 19417);
            CallChecker.varInit(this.mean, "mean", 558, 19146, 19417);
            CallChecker.varInit(this.geoMean, "geoMean", 558, 19146, 19417);
            CallChecker.varInit(this.sumLog, "sumLog", 558, 19146, 19417);
            CallChecker.varInit(this.max, "max", 558, 19146, 19417);
            CallChecker.varInit(this.min, "min", 558, 19146, 19417);
            CallChecker.varInit(this.sumsq, "sumsq", 558, 19146, 19417);
            CallChecker.varInit(this.sum, "sum", 558, 19146, 19417);
            CallChecker.varInit(this.secondMoment, "secondMoment", 558, 19146, 19417);
            CallChecker.varInit(this.n, "n", 558, 19146, 19417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 558, 19146, 19417);
            return geoMeanImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context807.methodEnd();
        }
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic geoMeanImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context808 = new MethodContext(void.class, 576, 19424, 20152);
        try {
            CallChecker.varInit(this, "this", 576, 19424, 20152);
            CallChecker.varInit(geoMeanImpl, "geoMeanImpl", 576, 19424, 20152);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 576, 19424, 20152);
            CallChecker.varInit(this.meanImpl, "meanImpl", 576, 19424, 20152);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 576, 19424, 20152);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 576, 19424, 20152);
            CallChecker.varInit(this.maxImpl, "maxImpl", 576, 19424, 20152);
            CallChecker.varInit(this.minImpl, "minImpl", 576, 19424, 20152);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 576, 19424, 20152);
            CallChecker.varInit(this.sumImpl, "sumImpl", 576, 19424, 20152);
            CallChecker.varInit(this.variance, "variance", 576, 19424, 20152);
            CallChecker.varInit(this.mean, "mean", 576, 19424, 20152);
            CallChecker.varInit(this.geoMean, "geoMean", 576, 19424, 20152);
            CallChecker.varInit(this.sumLog, "sumLog", 576, 19424, 20152);
            CallChecker.varInit(this.max, "max", 576, 19424, 20152);
            CallChecker.varInit(this.min, "min", 576, 19424, 20152);
            CallChecker.varInit(this.sumsq, "sumsq", 576, 19424, 20152);
            CallChecker.varInit(this.sum, "sum", 576, 19424, 20152);
            CallChecker.varInit(this.secondMoment, "secondMoment", 576, 19424, 20152);
            CallChecker.varInit(this.n, "n", 576, 19424, 20152);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 576, 19424, 20152);
            checkEmpty();
            this.geoMeanImpl = geoMeanImpl;
            CallChecker.varAssign(this.geoMeanImpl, "this.geoMeanImpl", 579, 20116, 20146);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context808.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getMeanImpl() {
        MethodContext _bcornu_methode_context809 = new MethodContext(StorelessUnivariateStatistic.class, 587, 20159, 20404);
        try {
            CallChecker.varInit(this, "this", 587, 20159, 20404);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 587, 20159, 20404);
            CallChecker.varInit(this.meanImpl, "meanImpl", 587, 20159, 20404);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 587, 20159, 20404);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 587, 20159, 20404);
            CallChecker.varInit(this.maxImpl, "maxImpl", 587, 20159, 20404);
            CallChecker.varInit(this.minImpl, "minImpl", 587, 20159, 20404);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 587, 20159, 20404);
            CallChecker.varInit(this.sumImpl, "sumImpl", 587, 20159, 20404);
            CallChecker.varInit(this.variance, "variance", 587, 20159, 20404);
            CallChecker.varInit(this.mean, "mean", 587, 20159, 20404);
            CallChecker.varInit(this.geoMean, "geoMean", 587, 20159, 20404);
            CallChecker.varInit(this.sumLog, "sumLog", 587, 20159, 20404);
            CallChecker.varInit(this.max, "max", 587, 20159, 20404);
            CallChecker.varInit(this.min, "min", 587, 20159, 20404);
            CallChecker.varInit(this.sumsq, "sumsq", 587, 20159, 20404);
            CallChecker.varInit(this.sum, "sum", 587, 20159, 20404);
            CallChecker.varInit(this.secondMoment, "secondMoment", 587, 20159, 20404);
            CallChecker.varInit(this.n, "n", 587, 20159, 20404);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 587, 20159, 20404);
            return meanImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context809.methodEnd();
        }
    }

    public void setMeanImpl(StorelessUnivariateStatistic meanImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context810 = new MethodContext(void.class, 605, 20411, 21104);
        try {
            CallChecker.varInit(this, "this", 605, 20411, 21104);
            CallChecker.varInit(meanImpl, "meanImpl", 605, 20411, 21104);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 605, 20411, 21104);
            CallChecker.varInit(this.meanImpl, "meanImpl", 605, 20411, 21104);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 605, 20411, 21104);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 605, 20411, 21104);
            CallChecker.varInit(this.maxImpl, "maxImpl", 605, 20411, 21104);
            CallChecker.varInit(this.minImpl, "minImpl", 605, 20411, 21104);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 605, 20411, 21104);
            CallChecker.varInit(this.sumImpl, "sumImpl", 605, 20411, 21104);
            CallChecker.varInit(this.variance, "variance", 605, 20411, 21104);
            CallChecker.varInit(this.mean, "mean", 605, 20411, 21104);
            CallChecker.varInit(this.geoMean, "geoMean", 605, 20411, 21104);
            CallChecker.varInit(this.sumLog, "sumLog", 605, 20411, 21104);
            CallChecker.varInit(this.max, "max", 605, 20411, 21104);
            CallChecker.varInit(this.min, "min", 605, 20411, 21104);
            CallChecker.varInit(this.sumsq, "sumsq", 605, 20411, 21104);
            CallChecker.varInit(this.sum, "sum", 605, 20411, 21104);
            CallChecker.varInit(this.secondMoment, "secondMoment", 605, 20411, 21104);
            CallChecker.varInit(this.n, "n", 605, 20411, 21104);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 605, 20411, 21104);
            checkEmpty();
            this.meanImpl = meanImpl;
            CallChecker.varAssign(this.meanImpl, "this.meanImpl", 608, 21074, 21098);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context810.methodEnd();
        }
    }

    public StorelessUnivariateStatistic getVarianceImpl() {
        MethodContext _bcornu_methode_context811 = new MethodContext(StorelessUnivariateStatistic.class, 616, 21111, 21372);
        try {
            CallChecker.varInit(this, "this", 616, 21111, 21372);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 616, 21111, 21372);
            CallChecker.varInit(this.meanImpl, "meanImpl", 616, 21111, 21372);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 616, 21111, 21372);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 616, 21111, 21372);
            CallChecker.varInit(this.maxImpl, "maxImpl", 616, 21111, 21372);
            CallChecker.varInit(this.minImpl, "minImpl", 616, 21111, 21372);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 616, 21111, 21372);
            CallChecker.varInit(this.sumImpl, "sumImpl", 616, 21111, 21372);
            CallChecker.varInit(this.variance, "variance", 616, 21111, 21372);
            CallChecker.varInit(this.mean, "mean", 616, 21111, 21372);
            CallChecker.varInit(this.geoMean, "geoMean", 616, 21111, 21372);
            CallChecker.varInit(this.sumLog, "sumLog", 616, 21111, 21372);
            CallChecker.varInit(this.max, "max", 616, 21111, 21372);
            CallChecker.varInit(this.min, "min", 616, 21111, 21372);
            CallChecker.varInit(this.sumsq, "sumsq", 616, 21111, 21372);
            CallChecker.varInit(this.sum, "sum", 616, 21111, 21372);
            CallChecker.varInit(this.secondMoment, "secondMoment", 616, 21111, 21372);
            CallChecker.varInit(this.n, "n", 616, 21111, 21372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 616, 21111, 21372);
            return varianceImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context811.methodEnd();
        }
    }

    public void setVarianceImpl(StorelessUnivariateStatistic varianceImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context812 = new MethodContext(void.class, 634, 21379, 22100);
        try {
            CallChecker.varInit(this, "this", 634, 21379, 22100);
            CallChecker.varInit(varianceImpl, "varianceImpl", 634, 21379, 22100);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 634, 21379, 22100);
            CallChecker.varInit(this.meanImpl, "meanImpl", 634, 21379, 22100);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 634, 21379, 22100);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 634, 21379, 22100);
            CallChecker.varInit(this.maxImpl, "maxImpl", 634, 21379, 22100);
            CallChecker.varInit(this.minImpl, "minImpl", 634, 21379, 22100);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 634, 21379, 22100);
            CallChecker.varInit(this.sumImpl, "sumImpl", 634, 21379, 22100);
            CallChecker.varInit(this.variance, "variance", 634, 21379, 22100);
            CallChecker.varInit(this.mean, "mean", 634, 21379, 22100);
            CallChecker.varInit(this.geoMean, "geoMean", 634, 21379, 22100);
            CallChecker.varInit(this.sumLog, "sumLog", 634, 21379, 22100);
            CallChecker.varInit(this.max, "max", 634, 21379, 22100);
            CallChecker.varInit(this.min, "min", 634, 21379, 22100);
            CallChecker.varInit(this.sumsq, "sumsq", 634, 21379, 22100);
            CallChecker.varInit(this.sum, "sum", 634, 21379, 22100);
            CallChecker.varInit(this.secondMoment, "secondMoment", 634, 21379, 22100);
            CallChecker.varInit(this.n, "n", 634, 21379, 22100);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 634, 21379, 22100);
            checkEmpty();
            this.varianceImpl = varianceImpl;
            CallChecker.varAssign(this.varianceImpl, "this.varianceImpl", 637, 22062, 22094);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context812.methodEnd();
        }
    }

    private void checkEmpty() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context813 = new MethodContext(void.class, 644, 22107, 22458);
        try {
            CallChecker.varInit(this, "this", 644, 22107, 22458);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 644, 22107, 22458);
            CallChecker.varInit(this.meanImpl, "meanImpl", 644, 22107, 22458);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 644, 22107, 22458);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 644, 22107, 22458);
            CallChecker.varInit(this.maxImpl, "maxImpl", 644, 22107, 22458);
            CallChecker.varInit(this.minImpl, "minImpl", 644, 22107, 22458);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 644, 22107, 22458);
            CallChecker.varInit(this.sumImpl, "sumImpl", 644, 22107, 22458);
            CallChecker.varInit(this.variance, "variance", 644, 22107, 22458);
            CallChecker.varInit(this.mean, "mean", 644, 22107, 22458);
            CallChecker.varInit(this.geoMean, "geoMean", 644, 22107, 22458);
            CallChecker.varInit(this.sumLog, "sumLog", 644, 22107, 22458);
            CallChecker.varInit(this.max, "max", 644, 22107, 22458);
            CallChecker.varInit(this.min, "min", 644, 22107, 22458);
            CallChecker.varInit(this.sumsq, "sumsq", 644, 22107, 22458);
            CallChecker.varInit(this.sum, "sum", 644, 22107, 22458);
            CallChecker.varInit(this.secondMoment, "secondMoment", 644, 22107, 22458);
            CallChecker.varInit(this.n, "n", 644, 22107, 22458);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 644, 22107, 22458);
            if ((n) > 0) {
                throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context813.methodEnd();
        }
    }

    public SummaryStatistics copy() {
        MethodContext _bcornu_methode_context814 = new MethodContext(SummaryStatistics.class, 656, 22465, 22844);
        try {
            CallChecker.varInit(this, "this", 656, 22465, 22844);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 656, 22465, 22844);
            CallChecker.varInit(this.meanImpl, "meanImpl", 656, 22465, 22844);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 656, 22465, 22844);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 656, 22465, 22844);
            CallChecker.varInit(this.maxImpl, "maxImpl", 656, 22465, 22844);
            CallChecker.varInit(this.minImpl, "minImpl", 656, 22465, 22844);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 656, 22465, 22844);
            CallChecker.varInit(this.sumImpl, "sumImpl", 656, 22465, 22844);
            CallChecker.varInit(this.variance, "variance", 656, 22465, 22844);
            CallChecker.varInit(this.mean, "mean", 656, 22465, 22844);
            CallChecker.varInit(this.geoMean, "geoMean", 656, 22465, 22844);
            CallChecker.varInit(this.sumLog, "sumLog", 656, 22465, 22844);
            CallChecker.varInit(this.max, "max", 656, 22465, 22844);
            CallChecker.varInit(this.min, "min", 656, 22465, 22844);
            CallChecker.varInit(this.sumsq, "sumsq", 656, 22465, 22844);
            CallChecker.varInit(this.sum, "sum", 656, 22465, 22844);
            CallChecker.varInit(this.secondMoment, "secondMoment", 656, 22465, 22844);
            CallChecker.varInit(this.n, "n", 656, 22465, 22844);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 656, 22465, 22844);
            SummaryStatistics result = CallChecker.varInit(new SummaryStatistics(), "result", 657, 22647, 22697);
            SummaryStatistics.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SummaryStatistics) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context814.methodEnd();
        }
    }

    public static void copy(SummaryStatistics source, SummaryStatistics dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context815 = new MethodContext(void.class, 671, 22851, 25867);
        try {
            CallChecker.varInit(dest, "dest", 671, 22851, 25867);
            CallChecker.varInit(source, "source", 671, 22851, 25867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SummaryStatistics.serialVersionUID", 671, 22851, 25867);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 675, 23319, 23322)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 675, 23334, 23339)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 675, 23334, 23339);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 675, 23334, 23339).maxImpl, StorelessUnivariateStatistic.class, 675, 23334, 23347)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 675, 23319, 23322);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 675, 23334, 23339);
                        CallChecker.isCalled(source, SummaryStatistics.class, 675, 23334, 23339).maxImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 675, 23334, 23339).maxImpl, StorelessUnivariateStatistic.class, 675, 23334, 23347);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 675, 23319, 23322).maxImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 675, 23334, 23339).maxImpl, StorelessUnivariateStatistic.class, 675, 23334, 23347).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 675, 23319, 23322).maxImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 675, 23319, 23322).maxImpl", 675, 23319, 23355);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 676, 23365, 23368)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 676, 23380, 23385)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 676, 23380, 23385);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 676, 23380, 23385).minImpl, StorelessUnivariateStatistic.class, 676, 23380, 23393)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 676, 23365, 23368);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 676, 23380, 23385);
                        CallChecker.isCalled(source, SummaryStatistics.class, 676, 23380, 23385).minImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 676, 23380, 23385).minImpl, StorelessUnivariateStatistic.class, 676, 23380, 23393);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 676, 23365, 23368).minImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 676, 23380, 23385).minImpl, StorelessUnivariateStatistic.class, 676, 23380, 23393).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 676, 23365, 23368).minImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 676, 23365, 23368).minImpl", 676, 23365, 23401);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 677, 23411, 23414)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 677, 23426, 23431)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 677, 23426, 23431);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 677, 23426, 23431).sumImpl, StorelessUnivariateStatistic.class, 677, 23426, 23439)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 677, 23411, 23414);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 677, 23426, 23431);
                        CallChecker.isCalled(source, SummaryStatistics.class, 677, 23426, 23431).sumImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 677, 23426, 23431).sumImpl, StorelessUnivariateStatistic.class, 677, 23426, 23439);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 677, 23411, 23414).sumImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 677, 23426, 23431).sumImpl, StorelessUnivariateStatistic.class, 677, 23426, 23439).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 677, 23411, 23414).sumImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 677, 23411, 23414).sumImpl", 677, 23411, 23447);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 678, 23457, 23460)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 678, 23475, 23480)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 678, 23475, 23480);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 678, 23475, 23480).sumLogImpl, StorelessUnivariateStatistic.class, 678, 23475, 23491)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 678, 23457, 23460);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 678, 23475, 23480);
                        CallChecker.isCalled(source, SummaryStatistics.class, 678, 23475, 23480).sumLogImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 678, 23475, 23480).sumLogImpl, StorelessUnivariateStatistic.class, 678, 23475, 23491);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 678, 23457, 23460).sumLogImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 678, 23475, 23480).sumLogImpl, StorelessUnivariateStatistic.class, 678, 23475, 23491).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 678, 23457, 23460).sumLogImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 678, 23457, 23460).sumLogImpl", 678, 23457, 23499);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 679, 23509, 23512)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 679, 23526, 23531)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 679, 23526, 23531);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 679, 23526, 23531).sumsqImpl, StorelessUnivariateStatistic.class, 679, 23526, 23541)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 679, 23509, 23512);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 679, 23526, 23531);
                        CallChecker.isCalled(source, SummaryStatistics.class, 679, 23526, 23531).sumsqImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 679, 23526, 23531).sumsqImpl, StorelessUnivariateStatistic.class, 679, 23526, 23541);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 679, 23509, 23512).sumsqImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 679, 23526, 23531).sumsqImpl, StorelessUnivariateStatistic.class, 679, 23526, 23541).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 679, 23509, 23512).sumsqImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 679, 23509, 23512).sumsqImpl", 679, 23509, 23549);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 680, 23559, 23562)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 680, 23579, 23584)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 680, 23579, 23584);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 680, 23579, 23584).secondMoment, SecondMoment.class, 680, 23579, 23597)) {
                        dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 680, 23559, 23562);
                        source = CallChecker.beforeCalled(source, SummaryStatistics.class, 680, 23579, 23584);
                        CallChecker.isCalled(source, SummaryStatistics.class, 680, 23579, 23584).secondMoment = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 680, 23579, 23584).secondMoment, SecondMoment.class, 680, 23579, 23597);
                        CallChecker.isCalled(dest, SummaryStatistics.class, 680, 23559, 23562).secondMoment = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 680, 23579, 23584).secondMoment, SecondMoment.class, 680, 23579, 23597).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 680, 23559, 23562).secondMoment, "CallChecker.isCalled(dest, SummaryStatistics.class, 680, 23559, 23562).secondMoment", 680, 23559, 23605);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 681, 23615, 23618)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 681, 23624, 23629)) {
                    dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 681, 23615, 23618);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 681, 23624, 23629);
                    CallChecker.isCalled(dest, SummaryStatistics.class, 681, 23615, 23618).n = CallChecker.isCalled(source, SummaryStatistics.class, 681, 23624, 23629).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 681, 23615, 23618).n, "CallChecker.isCalled(dest, SummaryStatistics.class, 681, 23615, 23618).n", 681, 23615, 23632);
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 684, 23727, 23732)) {
                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 684, 23727, 23732);
                if ((CallChecker.isCalled(source, SummaryStatistics.class, 684, 23727, 23732).getVarianceImpl()) instanceof Variance) {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 685, 23787, 23790)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 685, 23820, 23823)) {
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 685, 23787, 23790);
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 685, 23820, 23823);
                            CallChecker.isCalled(dest, SummaryStatistics.class, 685, 23787, 23790).varianceImpl = new Variance(CallChecker.isCalled(dest, SummaryStatistics.class, 685, 23820, 23823).secondMoment);
                            CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 685, 23787, 23790).varianceImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 685, 23787, 23790).varianceImpl", 685, 23787, 23838);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 687, 23869, 23872)) {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 687, 23889, 23894)) {
                            source = CallChecker.beforeCalled(source, SummaryStatistics.class, 687, 23889, 23894);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 687, 23889, 23894).varianceImpl, StorelessUnivariateStatistic.class, 687, 23889, 23907)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 687, 23869, 23872);
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 687, 23889, 23894);
                                CallChecker.isCalled(source, SummaryStatistics.class, 687, 23889, 23894).varianceImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 687, 23889, 23894).varianceImpl, StorelessUnivariateStatistic.class, 687, 23889, 23907);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 687, 23869, 23872).varianceImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 687, 23889, 23894).varianceImpl, StorelessUnivariateStatistic.class, 687, 23889, 23907).copy();
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 687, 23869, 23872).varianceImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 687, 23869, 23872).varianceImpl", 687, 23869, 23915);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 689, 23939, 23944)) {
                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 689, 23939, 23944);
                if ((CallChecker.isCalled(source, SummaryStatistics.class, 689, 23939, 23944).meanImpl) instanceof Mean) {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 690, 23986, 23989)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 690, 24011, 24014)) {
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 690, 23986, 23989);
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 690, 24011, 24014);
                            CallChecker.isCalled(dest, SummaryStatistics.class, 690, 23986, 23989).meanImpl = new Mean(CallChecker.isCalled(dest, SummaryStatistics.class, 690, 24011, 24014).secondMoment);
                            CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 690, 23986, 23989).meanImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 690, 23986, 23989).meanImpl", 690, 23986, 24029);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 692, 24060, 24063)) {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 692, 24076, 24081)) {
                            source = CallChecker.beforeCalled(source, SummaryStatistics.class, 692, 24076, 24081);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 692, 24076, 24081).meanImpl, StorelessUnivariateStatistic.class, 692, 24076, 24090)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 692, 24060, 24063);
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 692, 24076, 24081);
                                CallChecker.isCalled(source, SummaryStatistics.class, 692, 24076, 24081).meanImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 692, 24076, 24081).meanImpl, StorelessUnivariateStatistic.class, 692, 24076, 24090);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 692, 24060, 24063).meanImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 692, 24076, 24081).meanImpl, StorelessUnivariateStatistic.class, 692, 24076, 24090).copy();
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 692, 24060, 24063).meanImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 692, 24060, 24063).meanImpl", 692, 24060, 24098);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 694, 24122, 24127)) {
                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 694, 24122, 24127);
                if ((CallChecker.isCalled(source, SummaryStatistics.class, 694, 24122, 24127).getGeoMeanImpl()) instanceof GeometricMean) {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 695, 24186, 24189)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 695, 24235, 24238)) {
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 695, 24186, 24189);
                            dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 695, 24235, 24238);
                            CallChecker.isCalled(dest, SummaryStatistics.class, 695, 24186, 24189).geoMeanImpl = new GeometricMean(((SumOfLogs) (CallChecker.isCalled(dest, SummaryStatistics.class, 695, 24235, 24238).sumLogImpl)));
                            CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 695, 24186, 24189).geoMeanImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 695, 24186, 24189).geoMeanImpl", 695, 24186, 24251);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 697, 24282, 24285)) {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 697, 24301, 24306)) {
                            source = CallChecker.beforeCalled(source, SummaryStatistics.class, 697, 24301, 24306);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(source, SummaryStatistics.class, 697, 24301, 24306).geoMeanImpl, StorelessUnivariateStatistic.class, 697, 24301, 24318)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 697, 24282, 24285);
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 697, 24301, 24306);
                                CallChecker.isCalled(source, SummaryStatistics.class, 697, 24301, 24306).geoMeanImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, SummaryStatistics.class, 697, 24301, 24306).geoMeanImpl, StorelessUnivariateStatistic.class, 697, 24301, 24318);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 697, 24282, 24285).geoMeanImpl = CallChecker.isCalled(CallChecker.isCalled(source, SummaryStatistics.class, 697, 24301, 24306).geoMeanImpl, StorelessUnivariateStatistic.class, 697, 24301, 24318).copy();
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 697, 24282, 24285).geoMeanImpl, "CallChecker.isCalled(dest, SummaryStatistics.class, 697, 24282, 24285).geoMeanImpl", 697, 24282, 24326);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 702, 24459, 24464)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 702, 24477, 24482)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 702, 24459, 24464);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 702, 24477, 24482);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 702, 24459, 24464).geoMean) == (CallChecker.isCalled(source, SummaryStatistics.class, 702, 24477, 24482).geoMeanImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 703, 24511, 24514)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 703, 24542, 24545)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 703, 24511, 24514);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 703, 24542, 24545);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 703, 24511, 24514).geoMean = ((GeometricMean) (CallChecker.isCalled(dest, SummaryStatistics.class, 703, 24542, 24545).geoMeanImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 703, 24511, 24514).geoMean, "CallChecker.isCalled(dest, SummaryStatistics.class, 703, 24511, 24514).geoMean", 703, 24511, 24558);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 705, 24608, 24613)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 705, 24624, 24627)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 705, 24608, 24613);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 705, 24624, 24627);
                                GeometricMean.copy(CallChecker.isCalled(source, SummaryStatistics.class, 705, 24608, 24613).geoMean, CallChecker.isCalled(dest, SummaryStatistics.class, 705, 24624, 24627).geoMean);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 707, 24661, 24666)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 707, 24675, 24680)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 707, 24661, 24666);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 707, 24675, 24680);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 707, 24661, 24666).max) == (CallChecker.isCalled(source, SummaryStatistics.class, 707, 24675, 24680).maxImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 708, 24705, 24708)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 708, 24722, 24725)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 708, 24705, 24708);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 708, 24722, 24725);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 708, 24705, 24708).max = ((Max) (CallChecker.isCalled(dest, SummaryStatistics.class, 708, 24722, 24725).maxImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 708, 24705, 24708).max, "CallChecker.isCalled(dest, SummaryStatistics.class, 708, 24705, 24708).max", 708, 24705, 24734);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 710, 24774, 24779)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 710, 24786, 24789)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 710, 24774, 24779);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 710, 24786, 24789);
                                Max.copy(CallChecker.isCalled(source, SummaryStatistics.class, 710, 24774, 24779).max, CallChecker.isCalled(dest, SummaryStatistics.class, 710, 24786, 24789).max);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 712, 24819, 24824)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 712, 24834, 24839)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 712, 24819, 24824);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 712, 24834, 24839);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 712, 24819, 24824).mean) == (CallChecker.isCalled(source, SummaryStatistics.class, 712, 24834, 24839).meanImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 713, 24865, 24868)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 713, 24884, 24887)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 713, 24865, 24868);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 713, 24884, 24887);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 713, 24865, 24868).mean = ((Mean) (CallChecker.isCalled(dest, SummaryStatistics.class, 713, 24884, 24887).meanImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 713, 24865, 24868).mean, "CallChecker.isCalled(dest, SummaryStatistics.class, 713, 24865, 24868).mean", 713, 24865, 24897);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 715, 24938, 24943)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 715, 24951, 24954)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 715, 24938, 24943);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 715, 24951, 24954);
                                Mean.copy(CallChecker.isCalled(source, SummaryStatistics.class, 715, 24938, 24943).mean, CallChecker.isCalled(dest, SummaryStatistics.class, 715, 24951, 24954).mean);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 717, 24985, 24990)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 717, 24999, 25004)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 717, 24985, 24990);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 717, 24999, 25004);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 717, 24985, 24990).min) == (CallChecker.isCalled(source, SummaryStatistics.class, 717, 24999, 25004).minImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 718, 25029, 25032)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 718, 25046, 25049)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 718, 25029, 25032);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 718, 25046, 25049);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 718, 25029, 25032).min = ((Min) (CallChecker.isCalled(dest, SummaryStatistics.class, 718, 25046, 25049).minImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 718, 25029, 25032).min, "CallChecker.isCalled(dest, SummaryStatistics.class, 718, 25029, 25032).min", 718, 25029, 25058);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 720, 25098, 25103)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 720, 25110, 25113)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 720, 25098, 25103);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 720, 25110, 25113);
                                Min.copy(CallChecker.isCalled(source, SummaryStatistics.class, 720, 25098, 25103).min, CallChecker.isCalled(dest, SummaryStatistics.class, 720, 25110, 25113).min);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 722, 25143, 25148)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 722, 25157, 25162)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 722, 25143, 25148);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 722, 25157, 25162);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 722, 25143, 25148).sum) == (CallChecker.isCalled(source, SummaryStatistics.class, 722, 25157, 25162).sumImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 723, 25187, 25190)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 723, 25204, 25207)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 723, 25187, 25190);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 723, 25204, 25207);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 723, 25187, 25190).sum = ((Sum) (CallChecker.isCalled(dest, SummaryStatistics.class, 723, 25204, 25207).sumImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 723, 25187, 25190).sum, "CallChecker.isCalled(dest, SummaryStatistics.class, 723, 25187, 25190).sum", 723, 25187, 25216);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 725, 25256, 25261)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 725, 25268, 25271)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 725, 25256, 25261);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 725, 25268, 25271);
                                Sum.copy(CallChecker.isCalled(source, SummaryStatistics.class, 725, 25256, 25261).sum, CallChecker.isCalled(dest, SummaryStatistics.class, 725, 25268, 25271).sum);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 727, 25301, 25306)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 727, 25320, 25325)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 727, 25301, 25306);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 727, 25320, 25325);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 727, 25301, 25306).variance) == (CallChecker.isCalled(source, SummaryStatistics.class, 727, 25320, 25325).varianceImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 728, 25355, 25358)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 728, 25382, 25385)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 728, 25355, 25358);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 728, 25382, 25385);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 728, 25355, 25358).variance = ((Variance) (CallChecker.isCalled(dest, SummaryStatistics.class, 728, 25382, 25385).varianceImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 728, 25355, 25358).variance, "CallChecker.isCalled(dest, SummaryStatistics.class, 728, 25355, 25358).variance", 728, 25355, 25399);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 730, 25444, 25449)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 730, 25461, 25464)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 730, 25444, 25449);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 730, 25461, 25464);
                                Variance.copy(CallChecker.isCalled(source, SummaryStatistics.class, 730, 25444, 25449).variance, CallChecker.isCalled(dest, SummaryStatistics.class, 730, 25461, 25464).variance);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 732, 25499, 25504)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 732, 25516, 25521)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 732, 25499, 25504);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 732, 25516, 25521);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 732, 25499, 25504).sumLog) == (CallChecker.isCalled(source, SummaryStatistics.class, 732, 25516, 25521).sumLogImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 733, 25549, 25552)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 733, 25575, 25578)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 733, 25549, 25552);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 733, 25575, 25578);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 733, 25549, 25552).sumLog = ((SumOfLogs) (CallChecker.isCalled(dest, SummaryStatistics.class, 733, 25575, 25578).sumLogImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 733, 25549, 25552).sumLog, "CallChecker.isCalled(dest, SummaryStatistics.class, 733, 25549, 25552).sumLog", 733, 25549, 25590);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 735, 25636, 25641)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 735, 25651, 25654)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 735, 25636, 25641);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 735, 25651, 25654);
                                SumOfLogs.copy(CallChecker.isCalled(source, SummaryStatistics.class, 735, 25636, 25641).sumLog, CallChecker.isCalled(dest, SummaryStatistics.class, 735, 25651, 25654).sumLog);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(source, SummaryStatistics.class, 737, 25687, 25692)) {
                if (CallChecker.beforeDeref(source, SummaryStatistics.class, 737, 25703, 25708)) {
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 737, 25687, 25692);
                    source = CallChecker.beforeCalled(source, SummaryStatistics.class, 737, 25703, 25708);
                    if ((CallChecker.isCalled(source, SummaryStatistics.class, 737, 25687, 25692).sumsq) == (CallChecker.isCalled(source, SummaryStatistics.class, 737, 25703, 25708).sumsqImpl)) {
                        if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 738, 25735, 25738)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 738, 25763, 25766)) {
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 738, 25735, 25738);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 738, 25763, 25766);
                                CallChecker.isCalled(dest, SummaryStatistics.class, 738, 25735, 25738).sumsq = ((SumOfSquares) (CallChecker.isCalled(dest, SummaryStatistics.class, 738, 25763, 25766).sumsqImpl));
                                CallChecker.varAssign(CallChecker.isCalled(dest, SummaryStatistics.class, 738, 25735, 25738).sumsq, "CallChecker.isCalled(dest, SummaryStatistics.class, 738, 25735, 25738).sumsq", 738, 25735, 25777);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(source, SummaryStatistics.class, 740, 25826, 25831)) {
                            if (CallChecker.beforeDeref(dest, SummaryStatistics.class, 740, 25840, 25843)) {
                                source = CallChecker.beforeCalled(source, SummaryStatistics.class, 740, 25826, 25831);
                                dest = CallChecker.beforeCalled(dest, SummaryStatistics.class, 740, 25840, 25843);
                                SumOfSquares.copy(CallChecker.isCalled(source, SummaryStatistics.class, 740, 25826, 25831).sumsq, CallChecker.isCalled(dest, SummaryStatistics.class, 740, 25840, 25843).sumsq);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context815.methodEnd();
        }
    }
}

