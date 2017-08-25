package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.ResizableDoubleArray;

public class DescriptiveStatistics implements Serializable , StatisticalSummary {
    public static final int INFINITE_WINDOW = -1;

    private static final long serialVersionUID = 4133067267405273064L;

    private static final String SET_QUANTILE_METHOD_NAME = "setQuantile";

    protected int windowSize = DescriptiveStatistics.INFINITE_WINDOW;

    private ResizableDoubleArray eDA = new ResizableDoubleArray();

    private UnivariateStatistic meanImpl = new Mean();

    private UnivariateStatistic geometricMeanImpl = new GeometricMean();

    private UnivariateStatistic kurtosisImpl = new Kurtosis();

    private UnivariateStatistic maxImpl = new Max();

    private UnivariateStatistic minImpl = new Min();

    private UnivariateStatistic percentileImpl = new Percentile();

    private UnivariateStatistic skewnessImpl = new Skewness();

    private UnivariateStatistic varianceImpl = new Variance();

    private UnivariateStatistic sumsqImpl = new SumOfSquares();

    private UnivariateStatistic sumImpl = new Sum();

    public DescriptiveStatistics() {
        ConstructorContext _bcornu_methode_context962 = new ConstructorContext(DescriptiveStatistics.class, 117, 5096, 5223);
        try {
        } finally {
            _bcornu_methode_context962.methodEnd();
        }
    }

    public DescriptiveStatistics(int window) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context963 = new ConstructorContext(DescriptiveStatistics.class, 127, 5230, 5604);
        try {
            setWindowSize(window);
        } finally {
            _bcornu_methode_context963.methodEnd();
        }
    }

    public DescriptiveStatistics(double[] initialDoubleArray) {
        ConstructorContext _bcornu_methode_context964 = new ConstructorContext(DescriptiveStatistics.class, 139, 5611, 6116);
        try {
            if (initialDoubleArray != null) {
                eDA = new ResizableDoubleArray(initialDoubleArray);
                CallChecker.varAssign(this.eDA, "this.eDA", 141, 6050, 6100);
            }
        } finally {
            _bcornu_methode_context964.methodEnd();
        }
    }

    public DescriptiveStatistics(DescriptiveStatistics original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context965 = new ConstructorContext(DescriptiveStatistics.class, 152, 6123, 6499);
        try {
            DescriptiveStatistics.copy(original, this);
        } finally {
            _bcornu_methode_context965.methodEnd();
        }
    }

    public void addValue(double v) {
        MethodContext _bcornu_methode_context4307 = new MethodContext(void.class, 164, 6506, 7150);
        try {
            CallChecker.varInit(this, "this", 164, 6506, 7150);
            CallChecker.varInit(v, "v", 164, 6506, 7150);
            CallChecker.varInit(this.sumImpl, "sumImpl", 164, 6506, 7150);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 164, 6506, 7150);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 164, 6506, 7150);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 164, 6506, 7150);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 164, 6506, 7150);
            CallChecker.varInit(this.minImpl, "minImpl", 164, 6506, 7150);
            CallChecker.varInit(this.maxImpl, "maxImpl", 164, 6506, 7150);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 164, 6506, 7150);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 164, 6506, 7150);
            CallChecker.varInit(this.meanImpl, "meanImpl", 164, 6506, 7150);
            CallChecker.varInit(this.eDA, "eDA", 164, 6506, 7150);
            CallChecker.varInit(this.windowSize, "windowSize", 164, 6506, 7150);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 164, 6506, 7150);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 164, 6506, 7150);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 164, 6506, 7150);
            if ((windowSize) != (DescriptiveStatistics.INFINITE_WINDOW)) {
                if ((getN()) == (windowSize)) {
                    if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 167, 6967, 6969)) {
                        eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 167, 6967, 6969);
                        CallChecker.isCalled(eDA, ResizableDoubleArray.class, 167, 6967, 6969).addElementRolling(v);
                    }
                }else
                    if ((getN()) < (windowSize)) {
                        if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 169, 7055, 7057)) {
                            eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 169, 7055, 7057);
                            CallChecker.isCalled(eDA, ResizableDoubleArray.class, 169, 7055, 7057).addElement(v);
                        }
                    }
                
            }else {
                if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 172, 7117, 7119)) {
                    eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 172, 7117, 7119);
                    CallChecker.isCalled(eDA, ResizableDoubleArray.class, 172, 7117, 7119).addElement(v);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4307.methodEnd();
        }
    }

    public void removeMostRecentValue() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context4308 = new MethodContext(void.class, 181, 7157, 7580);
        try {
            CallChecker.varInit(this, "this", 181, 7157, 7580);
            CallChecker.varInit(this.sumImpl, "sumImpl", 181, 7157, 7580);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 181, 7157, 7580);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 181, 7157, 7580);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 181, 7157, 7580);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 181, 7157, 7580);
            CallChecker.varInit(this.minImpl, "minImpl", 181, 7157, 7580);
            CallChecker.varInit(this.maxImpl, "maxImpl", 181, 7157, 7580);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 181, 7157, 7580);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 181, 7157, 7580);
            CallChecker.varInit(this.meanImpl, "meanImpl", 181, 7157, 7580);
            CallChecker.varInit(this.eDA, "eDA", 181, 7157, 7580);
            CallChecker.varInit(this.windowSize, "windowSize", 181, 7157, 7580);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 181, 7157, 7580);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 181, 7157, 7580);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 181, 7157, 7580);
            TryContext _bcornu_try_context_89 = new TryContext(89, DescriptiveStatistics.class, "org.apache.commons.math3.exception.MathIllegalArgumentException");
            try {
                if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 183, 7405, 7407)) {
                    eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 183, 7405, 7407);
                    CallChecker.isCalled(eDA, ResizableDoubleArray.class, 183, 7405, 7407).discardMostRecentElements(1);
                }
            } catch (MathIllegalArgumentException ex) {
                _bcornu_try_context_89.catchStart(89);
                throw new MathIllegalStateException(LocalizedFormats.NO_DATA);
            } finally {
                _bcornu_try_context_89.finallyStart(89);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4308.methodEnd();
        }
    }

    public double replaceMostRecentValue(double v) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context4309 = new MethodContext(double.class, 197, 7587, 8055);
        try {
            CallChecker.varInit(this, "this", 197, 7587, 8055);
            CallChecker.varInit(v, "v", 197, 7587, 8055);
            CallChecker.varInit(this.sumImpl, "sumImpl", 197, 7587, 8055);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 197, 7587, 8055);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 197, 7587, 8055);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 197, 7587, 8055);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 197, 7587, 8055);
            CallChecker.varInit(this.minImpl, "minImpl", 197, 7587, 8055);
            CallChecker.varInit(this.maxImpl, "maxImpl", 197, 7587, 8055);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 197, 7587, 8055);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 197, 7587, 8055);
            CallChecker.varInit(this.meanImpl, "meanImpl", 197, 7587, 8055);
            CallChecker.varInit(this.eDA, "eDA", 197, 7587, 8055);
            CallChecker.varInit(this.windowSize, "windowSize", 197, 7587, 8055);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 197, 7587, 8055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 197, 7587, 8055);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 197, 7587, 8055);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 198, 8015, 8017)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 198, 8015, 8017);
                return CallChecker.isCalled(eDA, ResizableDoubleArray.class, 198, 8015, 8017).substituteMostRecentElement(v);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4309.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context4310 = new MethodContext(double.class, 206, 8062, 8332);
        try {
            CallChecker.varInit(this, "this", 206, 8062, 8332);
            CallChecker.varInit(this.sumImpl, "sumImpl", 206, 8062, 8332);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 206, 8062, 8332);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 206, 8062, 8332);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 206, 8062, 8332);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 206, 8062, 8332);
            CallChecker.varInit(this.minImpl, "minImpl", 206, 8062, 8332);
            CallChecker.varInit(this.maxImpl, "maxImpl", 206, 8062, 8332);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 206, 8062, 8332);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 206, 8062, 8332);
            CallChecker.varInit(this.meanImpl, "meanImpl", 206, 8062, 8332);
            CallChecker.varInit(this.eDA, "eDA", 206, 8062, 8332);
            CallChecker.varInit(this.windowSize, "windowSize", 206, 8062, 8332);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 206, 8062, 8332);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 206, 8062, 8332);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 206, 8062, 8332);
            return apply(meanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4310.methodEnd();
        }
    }

    public double getGeometricMean() {
        MethodContext _bcornu_methode_context4311 = new MethodContext(double.class, 216, 8339, 8709);
        try {
            CallChecker.varInit(this, "this", 216, 8339, 8709);
            CallChecker.varInit(this.sumImpl, "sumImpl", 216, 8339, 8709);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 216, 8339, 8709);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 216, 8339, 8709);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 216, 8339, 8709);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 216, 8339, 8709);
            CallChecker.varInit(this.minImpl, "minImpl", 216, 8339, 8709);
            CallChecker.varInit(this.maxImpl, "maxImpl", 216, 8339, 8709);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 216, 8339, 8709);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 216, 8339, 8709);
            CallChecker.varInit(this.meanImpl, "meanImpl", 216, 8339, 8709);
            CallChecker.varInit(this.eDA, "eDA", 216, 8339, 8709);
            CallChecker.varInit(this.windowSize, "windowSize", 216, 8339, 8709);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 216, 8339, 8709);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 216, 8339, 8709);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 216, 8339, 8709);
            return apply(geometricMeanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4311.methodEnd();
        }
    }

    public double getVariance() {
        MethodContext _bcornu_methode_context4312 = new MethodContext(double.class, 230, 8716, 9196);
        try {
            CallChecker.varInit(this, "this", 230, 8716, 9196);
            CallChecker.varInit(this.sumImpl, "sumImpl", 230, 8716, 9196);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 230, 8716, 9196);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 230, 8716, 9196);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 230, 8716, 9196);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 230, 8716, 9196);
            CallChecker.varInit(this.minImpl, "minImpl", 230, 8716, 9196);
            CallChecker.varInit(this.maxImpl, "maxImpl", 230, 8716, 9196);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 230, 8716, 9196);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 230, 8716, 9196);
            CallChecker.varInit(this.meanImpl, "meanImpl", 230, 8716, 9196);
            CallChecker.varInit(this.eDA, "eDA", 230, 8716, 9196);
            CallChecker.varInit(this.windowSize, "windowSize", 230, 8716, 9196);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 230, 8716, 9196);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 230, 8716, 9196);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 230, 8716, 9196);
            return apply(varianceImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4312.methodEnd();
        }
    }

    public double getPopulationVariance() {
        MethodContext _bcornu_methode_context4313 = new MethodContext(double.class, 241, 9203, 9575);
        try {
            CallChecker.varInit(this, "this", 241, 9203, 9575);
            CallChecker.varInit(this.sumImpl, "sumImpl", 241, 9203, 9575);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 241, 9203, 9575);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 241, 9203, 9575);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 241, 9203, 9575);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 241, 9203, 9575);
            CallChecker.varInit(this.minImpl, "minImpl", 241, 9203, 9575);
            CallChecker.varInit(this.maxImpl, "maxImpl", 241, 9203, 9575);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 241, 9203, 9575);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 241, 9203, 9575);
            CallChecker.varInit(this.meanImpl, "meanImpl", 241, 9203, 9575);
            CallChecker.varInit(this.eDA, "eDA", 241, 9203, 9575);
            CallChecker.varInit(this.windowSize, "windowSize", 241, 9203, 9575);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 241, 9203, 9575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 241, 9203, 9575);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 241, 9203, 9575);
            return apply(new Variance(false));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4313.methodEnd();
        }
    }

    public double getStandardDeviation() {
        MethodContext _bcornu_methode_context4314 = new MethodContext(double.class, 250, 9582, 10066);
        try {
            CallChecker.varInit(this, "this", 250, 9582, 10066);
            CallChecker.varInit(this.sumImpl, "sumImpl", 250, 9582, 10066);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 250, 9582, 10066);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 250, 9582, 10066);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 250, 9582, 10066);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 250, 9582, 10066);
            CallChecker.varInit(this.minImpl, "minImpl", 250, 9582, 10066);
            CallChecker.varInit(this.maxImpl, "maxImpl", 250, 9582, 10066);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 250, 9582, 10066);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 250, 9582, 10066);
            CallChecker.varInit(this.meanImpl, "meanImpl", 250, 9582, 10066);
            CallChecker.varInit(this.eDA, "eDA", 250, 9582, 10066);
            CallChecker.varInit(this.windowSize, "windowSize", 250, 9582, 10066);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 250, 9582, 10066);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 250, 9582, 10066);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 250, 9582, 10066);
            double stdDev = CallChecker.varInit(((double) (Double.NaN)), "stdDev", 251, 9825, 9851);
            if ((getN()) > 0) {
                if ((getN()) > 1) {
                    stdDev = FastMath.sqrt(getVariance());
                    CallChecker.varAssign(stdDev, "stdDev", 254, 9925, 9962);
                }else {
                    stdDev = 0.0;
                    CallChecker.varAssign(stdDev, "stdDev", 256, 10001, 10013);
                }
            }
            return stdDev;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4314.methodEnd();
        }
    }

    public double getSkewness() {
        MethodContext _bcornu_methode_context4315 = new MethodContext(double.class, 268, 10073, 10390);
        try {
            CallChecker.varInit(this, "this", 268, 10073, 10390);
            CallChecker.varInit(this.sumImpl, "sumImpl", 268, 10073, 10390);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 268, 10073, 10390);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 268, 10073, 10390);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 268, 10073, 10390);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 268, 10073, 10390);
            CallChecker.varInit(this.minImpl, "minImpl", 268, 10073, 10390);
            CallChecker.varInit(this.maxImpl, "maxImpl", 268, 10073, 10390);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 268, 10073, 10390);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 268, 10073, 10390);
            CallChecker.varInit(this.meanImpl, "meanImpl", 268, 10073, 10390);
            CallChecker.varInit(this.eDA, "eDA", 268, 10073, 10390);
            CallChecker.varInit(this.windowSize, "windowSize", 268, 10073, 10390);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 268, 10073, 10390);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 268, 10073, 10390);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 268, 10073, 10390);
            return apply(skewnessImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4315.methodEnd();
        }
    }

    public double getKurtosis() {
        MethodContext _bcornu_methode_context4316 = new MethodContext(double.class, 278, 10397, 10711);
        try {
            CallChecker.varInit(this, "this", 278, 10397, 10711);
            CallChecker.varInit(this.sumImpl, "sumImpl", 278, 10397, 10711);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 278, 10397, 10711);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 278, 10397, 10711);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 278, 10397, 10711);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 278, 10397, 10711);
            CallChecker.varInit(this.minImpl, "minImpl", 278, 10397, 10711);
            CallChecker.varInit(this.maxImpl, "maxImpl", 278, 10397, 10711);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 278, 10397, 10711);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 278, 10397, 10711);
            CallChecker.varInit(this.meanImpl, "meanImpl", 278, 10397, 10711);
            CallChecker.varInit(this.eDA, "eDA", 278, 10397, 10711);
            CallChecker.varInit(this.windowSize, "windowSize", 278, 10397, 10711);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 278, 10397, 10711);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 278, 10397, 10711);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 278, 10397, 10711);
            return apply(kurtosisImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4316.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context4317 = new MethodContext(double.class, 286, 10718, 10912);
        try {
            CallChecker.varInit(this, "this", 286, 10718, 10912);
            CallChecker.varInit(this.sumImpl, "sumImpl", 286, 10718, 10912);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 286, 10718, 10912);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 286, 10718, 10912);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 286, 10718, 10912);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 286, 10718, 10912);
            CallChecker.varInit(this.minImpl, "minImpl", 286, 10718, 10912);
            CallChecker.varInit(this.maxImpl, "maxImpl", 286, 10718, 10912);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 286, 10718, 10912);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 286, 10718, 10912);
            CallChecker.varInit(this.meanImpl, "meanImpl", 286, 10718, 10912);
            CallChecker.varInit(this.eDA, "eDA", 286, 10718, 10912);
            CallChecker.varInit(this.windowSize, "windowSize", 286, 10718, 10912);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 286, 10718, 10912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 286, 10718, 10912);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 286, 10718, 10912);
            return apply(maxImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4317.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context4318 = new MethodContext(double.class, 294, 10919, 11110);
        try {
            CallChecker.varInit(this, "this", 294, 10919, 11110);
            CallChecker.varInit(this.sumImpl, "sumImpl", 294, 10919, 11110);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 294, 10919, 11110);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 294, 10919, 11110);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 294, 10919, 11110);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 294, 10919, 11110);
            CallChecker.varInit(this.minImpl, "minImpl", 294, 10919, 11110);
            CallChecker.varInit(this.maxImpl, "maxImpl", 294, 10919, 11110);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 294, 10919, 11110);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 294, 10919, 11110);
            CallChecker.varInit(this.meanImpl, "meanImpl", 294, 10919, 11110);
            CallChecker.varInit(this.eDA, "eDA", 294, 10919, 11110);
            CallChecker.varInit(this.windowSize, "windowSize", 294, 10919, 11110);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 294, 10919, 11110);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 294, 10919, 11110);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 294, 10919, 11110);
            return apply(minImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4318.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context4319 = new MethodContext(long.class, 302, 11117, 11287);
        try {
            CallChecker.varInit(this, "this", 302, 11117, 11287);
            CallChecker.varInit(this.sumImpl, "sumImpl", 302, 11117, 11287);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 302, 11117, 11287);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 302, 11117, 11287);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 302, 11117, 11287);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 302, 11117, 11287);
            CallChecker.varInit(this.minImpl, "minImpl", 302, 11117, 11287);
            CallChecker.varInit(this.maxImpl, "maxImpl", 302, 11117, 11287);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 302, 11117, 11287);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 302, 11117, 11287);
            CallChecker.varInit(this.meanImpl, "meanImpl", 302, 11117, 11287);
            CallChecker.varInit(this.eDA, "eDA", 302, 11117, 11287);
            CallChecker.varInit(this.windowSize, "windowSize", 302, 11117, 11287);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 302, 11117, 11287);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 302, 11117, 11287);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 302, 11117, 11287);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 303, 11261, 11263)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 303, 11261, 11263);
                return CallChecker.isCalled(eDA, ResizableDoubleArray.class, 303, 11261, 11263).getNumElements();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4319.methodEnd();
        }
    }

    public double getSum() {
        MethodContext _bcornu_methode_context4320 = new MethodContext(double.class, 310, 11294, 11509);
        try {
            CallChecker.varInit(this, "this", 310, 11294, 11509);
            CallChecker.varInit(this.sumImpl, "sumImpl", 310, 11294, 11509);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 310, 11294, 11509);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 310, 11294, 11509);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 310, 11294, 11509);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 310, 11294, 11509);
            CallChecker.varInit(this.minImpl, "minImpl", 310, 11294, 11509);
            CallChecker.varInit(this.maxImpl, "maxImpl", 310, 11294, 11509);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 310, 11294, 11509);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 310, 11294, 11509);
            CallChecker.varInit(this.meanImpl, "meanImpl", 310, 11294, 11509);
            CallChecker.varInit(this.eDA, "eDA", 310, 11294, 11509);
            CallChecker.varInit(this.windowSize, "windowSize", 310, 11294, 11509);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 310, 11294, 11509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 310, 11294, 11509);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 310, 11294, 11509);
            return apply(sumImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4320.methodEnd();
        }
    }

    public double getSumsq() {
        MethodContext _bcornu_methode_context4321 = new MethodContext(double.class, 319, 11516, 11748);
        try {
            CallChecker.varInit(this, "this", 319, 11516, 11748);
            CallChecker.varInit(this.sumImpl, "sumImpl", 319, 11516, 11748);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 319, 11516, 11748);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 319, 11516, 11748);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 319, 11516, 11748);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 319, 11516, 11748);
            CallChecker.varInit(this.minImpl, "minImpl", 319, 11516, 11748);
            CallChecker.varInit(this.maxImpl, "maxImpl", 319, 11516, 11748);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 319, 11516, 11748);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 319, 11516, 11748);
            CallChecker.varInit(this.meanImpl, "meanImpl", 319, 11516, 11748);
            CallChecker.varInit(this.eDA, "eDA", 319, 11516, 11748);
            CallChecker.varInit(this.windowSize, "windowSize", 319, 11516, 11748);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 319, 11516, 11748);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 319, 11516, 11748);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 319, 11516, 11748);
            return apply(sumsqImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4321.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context4322 = new MethodContext(void.class, 326, 11755, 11859);
        try {
            CallChecker.varInit(this, "this", 326, 11755, 11859);
            CallChecker.varInit(this.sumImpl, "sumImpl", 326, 11755, 11859);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 326, 11755, 11859);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 326, 11755, 11859);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 326, 11755, 11859);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 326, 11755, 11859);
            CallChecker.varInit(this.minImpl, "minImpl", 326, 11755, 11859);
            CallChecker.varInit(this.maxImpl, "maxImpl", 326, 11755, 11859);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 326, 11755, 11859);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 326, 11755, 11859);
            CallChecker.varInit(this.meanImpl, "meanImpl", 326, 11755, 11859);
            CallChecker.varInit(this.eDA, "eDA", 326, 11755, 11859);
            CallChecker.varInit(this.windowSize, "windowSize", 326, 11755, 11859);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 326, 11755, 11859);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 326, 11755, 11859);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 326, 11755, 11859);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 327, 11842, 11844)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 327, 11842, 11844);
                CallChecker.isCalled(eDA, ResizableDoubleArray.class, 327, 11842, 11844).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4322.methodEnd();
        }
    }

    public int getWindowSize() {
        MethodContext _bcornu_methode_context4323 = new MethodContext(int.class, 337, 11867, 12144);
        try {
            CallChecker.varInit(this, "this", 337, 11867, 12144);
            CallChecker.varInit(this.sumImpl, "sumImpl", 337, 11867, 12144);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 337, 11867, 12144);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 337, 11867, 12144);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 337, 11867, 12144);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 337, 11867, 12144);
            CallChecker.varInit(this.minImpl, "minImpl", 337, 11867, 12144);
            CallChecker.varInit(this.maxImpl, "maxImpl", 337, 11867, 12144);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 337, 11867, 12144);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 337, 11867, 12144);
            CallChecker.varInit(this.meanImpl, "meanImpl", 337, 11867, 12144);
            CallChecker.varInit(this.eDA, "eDA", 337, 11867, 12144);
            CallChecker.varInit(this.windowSize, "windowSize", 337, 11867, 12144);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 337, 11867, 12144);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 337, 11867, 12144);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 337, 11867, 12144);
            return windowSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4323.methodEnd();
        }
    }

    public void setWindowSize(int windowSize) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4324 = new MethodContext(void.class, 355, 12151, 13619);
        try {
            CallChecker.varInit(this, "this", 355, 12151, 13619);
            CallChecker.varInit(windowSize, "windowSize", 355, 12151, 13619);
            CallChecker.varInit(this.sumImpl, "sumImpl", 355, 12151, 13619);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 355, 12151, 13619);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 355, 12151, 13619);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 355, 12151, 13619);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 355, 12151, 13619);
            CallChecker.varInit(this.minImpl, "minImpl", 355, 12151, 13619);
            CallChecker.varInit(this.maxImpl, "maxImpl", 355, 12151, 13619);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 355, 12151, 13619);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 355, 12151, 13619);
            CallChecker.varInit(this.meanImpl, "meanImpl", 355, 12151, 13619);
            CallChecker.varInit(this.eDA, "eDA", 355, 12151, 13619);
            CallChecker.varInit(this.windowSize, "windowSize", 355, 12151, 13619);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 355, 12151, 13619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 355, 12151, 13619);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 355, 12151, 13619);
            if ((windowSize < 1) && (windowSize != (DescriptiveStatistics.INFINITE_WINDOW))) {
                throw new MathIllegalArgumentException(LocalizedFormats.NOT_POSITIVE_WINDOW_SIZE, windowSize);
            }
            this.windowSize = windowSize;
            CallChecker.varAssign(this.windowSize, "this.windowSize", 361, 13238, 13266);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 366, 13508, 13510)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 366, 13508, 13510);
                if ((windowSize != (DescriptiveStatistics.INFINITE_WINDOW)) && (windowSize < (CallChecker.isCalled(eDA, ResizableDoubleArray.class, 366, 13508, 13510).getNumElements()))) {
                    if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 367, 13569, 13571)) {
                        if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 367, 13544, 13546)) {
                            eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 367, 13569, 13571);
                            eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 367, 13544, 13546);
                            CallChecker.isCalled(eDA, ResizableDoubleArray.class, 367, 13544, 13546).discardFrontElements(((CallChecker.isCalled(eDA, ResizableDoubleArray.class, 367, 13569, 13571).getNumElements()) - windowSize));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4324.methodEnd();
        }
    }

    public double[] getValues() {
        MethodContext _bcornu_methode_context4325 = new MethodContext(double[].class, 380, 13626, 14074);
        try {
            CallChecker.varInit(this, "this", 380, 13626, 14074);
            CallChecker.varInit(this.sumImpl, "sumImpl", 380, 13626, 14074);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 380, 13626, 14074);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 380, 13626, 14074);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 380, 13626, 14074);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 380, 13626, 14074);
            CallChecker.varInit(this.minImpl, "minImpl", 380, 13626, 14074);
            CallChecker.varInit(this.maxImpl, "maxImpl", 380, 13626, 14074);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 380, 13626, 14074);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 380, 13626, 14074);
            CallChecker.varInit(this.meanImpl, "meanImpl", 380, 13626, 14074);
            CallChecker.varInit(this.eDA, "eDA", 380, 13626, 14074);
            CallChecker.varInit(this.windowSize, "windowSize", 380, 13626, 14074);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 380, 13626, 14074);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 380, 13626, 14074);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 380, 13626, 14074);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 381, 14051, 14053)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 381, 14051, 14053);
                return CallChecker.isCalled(eDA, ResizableDoubleArray.class, 381, 14051, 14053).getElements();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4325.methodEnd();
        }
    }

    public double[] getSortedValues() {
        MethodContext _bcornu_methode_context4326 = new MethodContext(double[].class, 392, 14081, 14538);
        try {
            CallChecker.varInit(this, "this", 392, 14081, 14538);
            CallChecker.varInit(this.sumImpl, "sumImpl", 392, 14081, 14538);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 392, 14081, 14538);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 392, 14081, 14538);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 392, 14081, 14538);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 392, 14081, 14538);
            CallChecker.varInit(this.minImpl, "minImpl", 392, 14081, 14538);
            CallChecker.varInit(this.maxImpl, "maxImpl", 392, 14081, 14538);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 392, 14081, 14538);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 392, 14081, 14538);
            CallChecker.varInit(this.meanImpl, "meanImpl", 392, 14081, 14538);
            CallChecker.varInit(this.eDA, "eDA", 392, 14081, 14538);
            CallChecker.varInit(this.windowSize, "windowSize", 392, 14081, 14538);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 392, 14081, 14538);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 392, 14081, 14538);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 392, 14081, 14538);
            double[] sort = CallChecker.varInit(getValues(), "sort", 393, 14457, 14484);
            Arrays.sort(sort);
            return sort;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4326.methodEnd();
        }
    }

    public double getElement(int index) {
        MethodContext _bcornu_methode_context4327 = new MethodContext(double.class, 403, 14545, 14793);
        try {
            CallChecker.varInit(this, "this", 403, 14545, 14793);
            CallChecker.varInit(index, "index", 403, 14545, 14793);
            CallChecker.varInit(this.sumImpl, "sumImpl", 403, 14545, 14793);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 403, 14545, 14793);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 403, 14545, 14793);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 403, 14545, 14793);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 403, 14545, 14793);
            CallChecker.varInit(this.minImpl, "minImpl", 403, 14545, 14793);
            CallChecker.varInit(this.maxImpl, "maxImpl", 403, 14545, 14793);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 403, 14545, 14793);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 403, 14545, 14793);
            CallChecker.varInit(this.meanImpl, "meanImpl", 403, 14545, 14793);
            CallChecker.varInit(this.eDA, "eDA", 403, 14545, 14793);
            CallChecker.varInit(this.windowSize, "windowSize", 403, 14545, 14793);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 403, 14545, 14793);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 403, 14545, 14793);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 403, 14545, 14793);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 404, 14766, 14768)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 404, 14766, 14768);
                return CallChecker.isCalled(eDA, ResizableDoubleArray.class, 404, 14766, 14768).getElement(index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4327.methodEnd();
        }
    }

    public double getPercentile(double p) throws MathIllegalArgumentException, MathIllegalStateException {
        MethodContext _bcornu_methode_context4328 = new MethodContext(double.class, 426, 14800, 16982);
        try {
            CallChecker.varInit(this, "this", 426, 14800, 16982);
            CallChecker.varInit(p, "p", 426, 14800, 16982);
            CallChecker.varInit(this.sumImpl, "sumImpl", 426, 14800, 16982);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 426, 14800, 16982);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 426, 14800, 16982);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 426, 14800, 16982);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 426, 14800, 16982);
            CallChecker.varInit(this.minImpl, "minImpl", 426, 14800, 16982);
            CallChecker.varInit(this.maxImpl, "maxImpl", 426, 14800, 16982);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 426, 14800, 16982);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 426, 14800, 16982);
            CallChecker.varInit(this.meanImpl, "meanImpl", 426, 14800, 16982);
            CallChecker.varInit(this.eDA, "eDA", 426, 14800, 16982);
            CallChecker.varInit(this.windowSize, "windowSize", 426, 14800, 16982);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 426, 14800, 16982);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 426, 14800, 16982);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 426, 14800, 16982);
            if ((percentileImpl) instanceof Percentile) {
                if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 428, 15933, 15946)) {
                    percentileImpl = CallChecker.beforeCalled(percentileImpl, Percentile.class, 428, 15933, 15946);
                    CallChecker.isCalled(((Percentile) (percentileImpl)), Percentile.class, 428, 15933, 15946).setQuantile(p);
                }
            }else {
                TryContext _bcornu_try_context_90 = new TryContext(90, DescriptiveStatistics.class, "java.lang.NoSuchMethodException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
                try {
                    if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029).getClass(), Class.class, 431, 16016, 16040)) {
                            percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029).getClass(), Class.class, 431, 16016, 16040).getMethod(DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, new Class[]{ Double.TYPE }), Method.class, 431, 16016, 16127)) {
                                percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 431, 16016, 16029).getClass(), Class.class, 431, 16016, 16040).getMethod(DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, new Class[]{ Double.TYPE }), Method.class, 431, 16016, 16127).invoke(percentileImpl, new Object[]{ Double.valueOf(p) });
                            }
                        }
                    }
                } catch (NoSuchMethodException e1) {
                    _bcornu_try_context_90.catchStart(90);
                    if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 437, 16459, 16472)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 437, 16459, 16472);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 437, 16459, 16472).getClass(), Class.class, 437, 16459, 16483)) {
                            percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 437, 16459, 16472);
                            throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 437, 16459, 16472).getClass(), Class.class, 437, 16459, 16483).getName(), DescriptiveStatistics.SET_QUANTILE_METHOD_NAME);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (IllegalAccessException e2) {
                    _bcornu_try_context_90.catchStart(90);
                    if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 441, 16761, 16774)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 441, 16761, 16774);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 441, 16761, 16774).getClass(), Class.class, 441, 16761, 16785)) {
                            percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 441, 16761, 16774);
                            throw new MathIllegalStateException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 441, 16761, 16774).getClass(), Class.class, 441, 16761, 16785).getName());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (InvocationTargetException e3) {
                    _bcornu_try_context_90.catchStart(90);
                    throw new IllegalStateException(e3.getCause());
                } finally {
                    _bcornu_try_context_90.finallyStart(90);
                }
            }
            return apply(percentileImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4328.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4329 = new MethodContext(String.class, 457, 16989, 18260);
        try {
            CallChecker.varInit(this, "this", 457, 16989, 18260);
            CallChecker.varInit(this.sumImpl, "sumImpl", 457, 16989, 18260);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 457, 16989, 18260);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 457, 16989, 18260);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 457, 16989, 18260);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 457, 16989, 18260);
            CallChecker.varInit(this.minImpl, "minImpl", 457, 16989, 18260);
            CallChecker.varInit(this.maxImpl, "maxImpl", 457, 16989, 18260);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 457, 16989, 18260);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 457, 16989, 18260);
            CallChecker.varInit(this.meanImpl, "meanImpl", 457, 16989, 18260);
            CallChecker.varInit(this.eDA, "eDA", 457, 16989, 18260);
            CallChecker.varInit(this.windowSize, "windowSize", 457, 16989, 18260);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 457, 16989, 18260);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 457, 16989, 18260);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 457, 16989, 18260);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 458, 17282, 17327);
            String endl = CallChecker.varInit("\n", "endl", 459, 17337, 17355);
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 460, 17365, 17373)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 460, 17365, 17373);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 460, 17365, 17373).append("DescriptiveStatistics:"), StringBuilder.class, 460, 17365, 17406)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 460, 17365, 17373);
                    CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 460, 17365, 17373).append("DescriptiveStatistics:"), StringBuilder.class, 460, 17365, 17406).append(endl);
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 461, 17430, 17438)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 461, 17430, 17438);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 461, 17430, 17438).append("n: "), StringBuilder.class, 461, 17430, 17452)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 461, 17430, 17438);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 461, 17430, 17438).append("n: "), StringBuilder.class, 461, 17430, 17452).append(getN()), StringBuilder.class, 461, 17430, 17467)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 461, 17430, 17438);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 461, 17430, 17438).append("n: "), StringBuilder.class, 461, 17430, 17452).append(getN()), StringBuilder.class, 461, 17430, 17467).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 462, 17491, 17499)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 462, 17491, 17499);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 462, 17491, 17499).append("min: "), StringBuilder.class, 462, 17491, 17515)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 462, 17491, 17499);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 462, 17491, 17499).append("min: "), StringBuilder.class, 462, 17491, 17515).append(getMin()), StringBuilder.class, 462, 17491, 17532)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 462, 17491, 17499);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 462, 17491, 17499).append("min: "), StringBuilder.class, 462, 17491, 17515).append(getMin()), StringBuilder.class, 462, 17491, 17532).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 463, 17556, 17564)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 463, 17556, 17564);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 463, 17556, 17564).append("max: "), StringBuilder.class, 463, 17556, 17580)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 463, 17556, 17564);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 463, 17556, 17564).append("max: "), StringBuilder.class, 463, 17556, 17580).append(getMax()), StringBuilder.class, 463, 17556, 17597)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 463, 17556, 17564);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 463, 17556, 17564).append("max: "), StringBuilder.class, 463, 17556, 17580).append(getMax()), StringBuilder.class, 463, 17556, 17597).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 464, 17621, 17629)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 464, 17621, 17629);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 464, 17621, 17629).append("mean: "), StringBuilder.class, 464, 17621, 17646)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 464, 17621, 17629);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 464, 17621, 17629).append("mean: "), StringBuilder.class, 464, 17621, 17646).append(getMean()), StringBuilder.class, 464, 17621, 17664)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 464, 17621, 17629);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 464, 17621, 17629).append("mean: "), StringBuilder.class, 464, 17621, 17646).append(getMean()), StringBuilder.class, 464, 17621, 17664).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 465, 17688, 17696)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 465, 17688, 17696);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 465, 17688, 17696).append("std dev: "), StringBuilder.class, 465, 17688, 17716)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 465, 17688, 17696);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 465, 17688, 17696).append("std dev: "), StringBuilder.class, 465, 17688, 17716).append(getStandardDeviation()), StringBuilder.class, 465, 17688, 17747)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 465, 17688, 17696);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 465, 17688, 17696).append("std dev: "), StringBuilder.class, 465, 17688, 17716).append(getStandardDeviation()), StringBuilder.class, 465, 17688, 17747).append(endl);
                    }
                }
            }
            TryContext _bcornu_try_context_91 = new TryContext(91, DescriptiveStatistics.class, "org.apache.commons.math3.exception.MathIllegalStateException");
            try {
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 469, 17875, 17883)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 469, 17875, 17883);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 469, 17875, 17883).append("median: "), StringBuilder.class, 469, 17875, 17902)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 469, 17875, 17883);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 469, 17875, 17883).append("median: "), StringBuilder.class, 469, 17875, 17902).append(getPercentile(50)), StringBuilder.class, 469, 17875, 17928)) {
                            outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 469, 17875, 17883);
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 469, 17875, 17883).append("median: "), StringBuilder.class, 469, 17875, 17902).append(getPercentile(50)), StringBuilder.class, 469, 17875, 17928).append(endl);
                        }
                    }
                }
            } catch (MathIllegalStateException ex) {
                _bcornu_try_context_91.catchStart(91);
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 471, 18005, 18013)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 471, 18005, 18013);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 471, 18005, 18013).append("median: unavailable"), StringBuilder.class, 471, 18005, 18043)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 471, 18005, 18013);
                        CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 471, 18005, 18013).append("median: unavailable"), StringBuilder.class, 471, 18005, 18043).append(endl);
                    }
                }
            } finally {
                _bcornu_try_context_91.finallyStart(91);
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 473, 18077, 18085)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 473, 18077, 18085);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 473, 18077, 18085).append("skewness: "), StringBuilder.class, 473, 18077, 18106)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 473, 18077, 18085);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 473, 18077, 18085).append("skewness: "), StringBuilder.class, 473, 18077, 18106).append(getSkewness()), StringBuilder.class, 473, 18077, 18128)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 473, 18077, 18085);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 473, 18077, 18085).append("skewness: "), StringBuilder.class, 473, 18077, 18106).append(getSkewness()), StringBuilder.class, 473, 18077, 18128).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 474, 18152, 18160)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 474, 18152, 18160);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 474, 18152, 18160).append("kurtosis: "), StringBuilder.class, 474, 18152, 18181)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 474, 18152, 18160);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 474, 18152, 18160).append("kurtosis: "), StringBuilder.class, 474, 18152, 18181).append(getKurtosis()), StringBuilder.class, 474, 18152, 18203)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 474, 18152, 18160);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 474, 18152, 18160).append("kurtosis: "), StringBuilder.class, 474, 18152, 18181).append(getKurtosis()), StringBuilder.class, 474, 18152, 18203).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 475, 18234, 18242)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 475, 18234, 18242);
                return CallChecker.isCalled(outBuffer, StringBuilder.class, 475, 18234, 18242).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4329.methodEnd();
        }
    }

    public double apply(UnivariateStatistic stat) {
        MethodContext _bcornu_methode_context4330 = new MethodContext(double.class, 483, 18267, 18640);
        try {
            CallChecker.varInit(this, "this", 483, 18267, 18640);
            CallChecker.varInit(stat, "stat", 483, 18267, 18640);
            CallChecker.varInit(this.sumImpl, "sumImpl", 483, 18267, 18640);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 483, 18267, 18640);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 483, 18267, 18640);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 483, 18267, 18640);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 483, 18267, 18640);
            CallChecker.varInit(this.minImpl, "minImpl", 483, 18267, 18640);
            CallChecker.varInit(this.maxImpl, "maxImpl", 483, 18267, 18640);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 483, 18267, 18640);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 483, 18267, 18640);
            CallChecker.varInit(this.meanImpl, "meanImpl", 483, 18267, 18640);
            CallChecker.varInit(this.eDA, "eDA", 483, 18267, 18640);
            CallChecker.varInit(this.windowSize, "windowSize", 483, 18267, 18640);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 483, 18267, 18640);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 483, 18267, 18640);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 483, 18267, 18640);
            if (CallChecker.beforeDeref(eDA, ResizableDoubleArray.class, 485, 18617, 18619)) {
                eDA = CallChecker.beforeCalled(eDA, ResizableDoubleArray.class, 485, 18617, 18619);
                return CallChecker.isCalled(eDA, ResizableDoubleArray.class, 485, 18617, 18619).compute(stat);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4330.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getMeanImpl() {
        MethodContext _bcornu_methode_context4331 = new MethodContext(UnivariateStatistic.class, 496, 18647, 18937);
        try {
            CallChecker.varInit(this, "this", 496, 18647, 18937);
            CallChecker.varInit(this.sumImpl, "sumImpl", 496, 18647, 18937);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 496, 18647, 18937);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 496, 18647, 18937);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 496, 18647, 18937);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 496, 18647, 18937);
            CallChecker.varInit(this.minImpl, "minImpl", 496, 18647, 18937);
            CallChecker.varInit(this.maxImpl, "maxImpl", 496, 18647, 18937);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 496, 18647, 18937);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 496, 18647, 18937);
            CallChecker.varInit(this.meanImpl, "meanImpl", 496, 18647, 18937);
            CallChecker.varInit(this.eDA, "eDA", 496, 18647, 18937);
            CallChecker.varInit(this.windowSize, "windowSize", 496, 18647, 18937);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 496, 18647, 18937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 496, 18647, 18937);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 496, 18647, 18937);
            return meanImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4331.methodEnd();
        }
    }

    public synchronized void setMeanImpl(UnivariateStatistic meanImpl) {
        MethodContext _bcornu_methode_context4332 = new MethodContext(void.class, 507, 18944, 19237);
        try {
            CallChecker.varInit(this, "this", 507, 18944, 19237);
            CallChecker.varInit(meanImpl, "meanImpl", 507, 18944, 19237);
            CallChecker.varInit(this.sumImpl, "sumImpl", 507, 18944, 19237);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 507, 18944, 19237);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 507, 18944, 19237);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 507, 18944, 19237);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 507, 18944, 19237);
            CallChecker.varInit(this.minImpl, "minImpl", 507, 18944, 19237);
            CallChecker.varInit(this.maxImpl, "maxImpl", 507, 18944, 19237);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 507, 18944, 19237);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 507, 18944, 19237);
            CallChecker.varInit(this.meanImpl, "meanImpl", 507, 18944, 19237);
            CallChecker.varInit(this.eDA, "eDA", 507, 18944, 19237);
            CallChecker.varInit(this.windowSize, "windowSize", 507, 18944, 19237);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 507, 18944, 19237);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 507, 18944, 19237);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 507, 18944, 19237);
            this.meanImpl = meanImpl;
            CallChecker.varAssign(this.meanImpl, "this.meanImpl", 508, 19207, 19231);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4332.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getGeometricMeanImpl() {
        MethodContext _bcornu_methode_context4333 = new MethodContext(UnivariateStatistic.class, 517, 19244, 19530);
        try {
            CallChecker.varInit(this, "this", 517, 19244, 19530);
            CallChecker.varInit(this.sumImpl, "sumImpl", 517, 19244, 19530);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 517, 19244, 19530);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 517, 19244, 19530);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 517, 19244, 19530);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 517, 19244, 19530);
            CallChecker.varInit(this.minImpl, "minImpl", 517, 19244, 19530);
            CallChecker.varInit(this.maxImpl, "maxImpl", 517, 19244, 19530);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 517, 19244, 19530);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 517, 19244, 19530);
            CallChecker.varInit(this.meanImpl, "meanImpl", 517, 19244, 19530);
            CallChecker.varInit(this.eDA, "eDA", 517, 19244, 19530);
            CallChecker.varInit(this.windowSize, "windowSize", 517, 19244, 19530);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 517, 19244, 19530);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 517, 19244, 19530);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 517, 19244, 19530);
            return geometricMeanImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4333.methodEnd();
        }
    }

    public synchronized void setGeometricMeanImpl(UnivariateStatistic geometricMeanImpl) {
        MethodContext _bcornu_methode_context4334 = new MethodContext(void.class, 528, 19537, 19908);
        try {
            CallChecker.varInit(this, "this", 528, 19537, 19908);
            CallChecker.varInit(geometricMeanImpl, "geometricMeanImpl", 528, 19537, 19908);
            CallChecker.varInit(this.sumImpl, "sumImpl", 528, 19537, 19908);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 528, 19537, 19908);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 528, 19537, 19908);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 528, 19537, 19908);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 528, 19537, 19908);
            CallChecker.varInit(this.minImpl, "minImpl", 528, 19537, 19908);
            CallChecker.varInit(this.maxImpl, "maxImpl", 528, 19537, 19908);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 528, 19537, 19908);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 528, 19537, 19908);
            CallChecker.varInit(this.meanImpl, "meanImpl", 528, 19537, 19908);
            CallChecker.varInit(this.eDA, "eDA", 528, 19537, 19908);
            CallChecker.varInit(this.windowSize, "windowSize", 528, 19537, 19908);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 528, 19537, 19908);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 528, 19537, 19908);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 528, 19537, 19908);
            this.geometricMeanImpl = geometricMeanImpl;
            CallChecker.varAssign(this.geometricMeanImpl, "this.geometricMeanImpl", 530, 19860, 19902);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4334.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getKurtosisImpl() {
        MethodContext _bcornu_methode_context4335 = new MethodContext(UnivariateStatistic.class, 539, 19915, 20179);
        try {
            CallChecker.varInit(this, "this", 539, 19915, 20179);
            CallChecker.varInit(this.sumImpl, "sumImpl", 539, 19915, 20179);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 539, 19915, 20179);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 539, 19915, 20179);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 539, 19915, 20179);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 539, 19915, 20179);
            CallChecker.varInit(this.minImpl, "minImpl", 539, 19915, 20179);
            CallChecker.varInit(this.maxImpl, "maxImpl", 539, 19915, 20179);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 539, 19915, 20179);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 539, 19915, 20179);
            CallChecker.varInit(this.meanImpl, "meanImpl", 539, 19915, 20179);
            CallChecker.varInit(this.eDA, "eDA", 539, 19915, 20179);
            CallChecker.varInit(this.windowSize, "windowSize", 539, 19915, 20179);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 539, 19915, 20179);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 539, 19915, 20179);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 539, 19915, 20179);
            return kurtosisImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4335.methodEnd();
        }
    }

    public synchronized void setKurtosisImpl(UnivariateStatistic kurtosisImpl) {
        MethodContext _bcornu_methode_context4336 = new MethodContext(void.class, 550, 20186, 20507);
        try {
            CallChecker.varInit(this, "this", 550, 20186, 20507);
            CallChecker.varInit(kurtosisImpl, "kurtosisImpl", 550, 20186, 20507);
            CallChecker.varInit(this.sumImpl, "sumImpl", 550, 20186, 20507);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 550, 20186, 20507);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 550, 20186, 20507);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 550, 20186, 20507);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 550, 20186, 20507);
            CallChecker.varInit(this.minImpl, "minImpl", 550, 20186, 20507);
            CallChecker.varInit(this.maxImpl, "maxImpl", 550, 20186, 20507);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 550, 20186, 20507);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 550, 20186, 20507);
            CallChecker.varInit(this.meanImpl, "meanImpl", 550, 20186, 20507);
            CallChecker.varInit(this.eDA, "eDA", 550, 20186, 20507);
            CallChecker.varInit(this.windowSize, "windowSize", 550, 20186, 20507);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 550, 20186, 20507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 550, 20186, 20507);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 550, 20186, 20507);
            this.kurtosisImpl = kurtosisImpl;
            CallChecker.varAssign(this.kurtosisImpl, "this.kurtosisImpl", 551, 20469, 20501);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4336.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getMaxImpl() {
        MethodContext _bcornu_methode_context4337 = new MethodContext(UnivariateStatistic.class, 560, 20514, 20766);
        try {
            CallChecker.varInit(this, "this", 560, 20514, 20766);
            CallChecker.varInit(this.sumImpl, "sumImpl", 560, 20514, 20766);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 560, 20514, 20766);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 560, 20514, 20766);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 560, 20514, 20766);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 560, 20514, 20766);
            CallChecker.varInit(this.minImpl, "minImpl", 560, 20514, 20766);
            CallChecker.varInit(this.maxImpl, "maxImpl", 560, 20514, 20766);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 560, 20514, 20766);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 560, 20514, 20766);
            CallChecker.varInit(this.meanImpl, "meanImpl", 560, 20514, 20766);
            CallChecker.varInit(this.eDA, "eDA", 560, 20514, 20766);
            CallChecker.varInit(this.windowSize, "windowSize", 560, 20514, 20766);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 560, 20514, 20766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 560, 20514, 20766);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 560, 20514, 20766);
            return maxImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4337.methodEnd();
        }
    }

    public synchronized void setMaxImpl(UnivariateStatistic maxImpl) {
        MethodContext _bcornu_methode_context4338 = new MethodContext(void.class, 571, 20773, 21067);
        try {
            CallChecker.varInit(this, "this", 571, 20773, 21067);
            CallChecker.varInit(maxImpl, "maxImpl", 571, 20773, 21067);
            CallChecker.varInit(this.sumImpl, "sumImpl", 571, 20773, 21067);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 571, 20773, 21067);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 571, 20773, 21067);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 571, 20773, 21067);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 571, 20773, 21067);
            CallChecker.varInit(this.minImpl, "minImpl", 571, 20773, 21067);
            CallChecker.varInit(this.maxImpl, "maxImpl", 571, 20773, 21067);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 571, 20773, 21067);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 571, 20773, 21067);
            CallChecker.varInit(this.meanImpl, "meanImpl", 571, 20773, 21067);
            CallChecker.varInit(this.eDA, "eDA", 571, 20773, 21067);
            CallChecker.varInit(this.windowSize, "windowSize", 571, 20773, 21067);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 571, 20773, 21067);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 571, 20773, 21067);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 571, 20773, 21067);
            this.maxImpl = maxImpl;
            CallChecker.varAssign(this.maxImpl, "this.maxImpl", 572, 21039, 21061);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4338.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getMinImpl() {
        MethodContext _bcornu_methode_context4339 = new MethodContext(UnivariateStatistic.class, 581, 21074, 21326);
        try {
            CallChecker.varInit(this, "this", 581, 21074, 21326);
            CallChecker.varInit(this.sumImpl, "sumImpl", 581, 21074, 21326);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 581, 21074, 21326);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 581, 21074, 21326);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 581, 21074, 21326);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 581, 21074, 21326);
            CallChecker.varInit(this.minImpl, "minImpl", 581, 21074, 21326);
            CallChecker.varInit(this.maxImpl, "maxImpl", 581, 21074, 21326);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 581, 21074, 21326);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 581, 21074, 21326);
            CallChecker.varInit(this.meanImpl, "meanImpl", 581, 21074, 21326);
            CallChecker.varInit(this.eDA, "eDA", 581, 21074, 21326);
            CallChecker.varInit(this.windowSize, "windowSize", 581, 21074, 21326);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 581, 21074, 21326);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 581, 21074, 21326);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 581, 21074, 21326);
            return minImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4339.methodEnd();
        }
    }

    public synchronized void setMinImpl(UnivariateStatistic minImpl) {
        MethodContext _bcornu_methode_context4340 = new MethodContext(void.class, 592, 21333, 21627);
        try {
            CallChecker.varInit(this, "this", 592, 21333, 21627);
            CallChecker.varInit(minImpl, "minImpl", 592, 21333, 21627);
            CallChecker.varInit(this.sumImpl, "sumImpl", 592, 21333, 21627);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 592, 21333, 21627);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 592, 21333, 21627);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 592, 21333, 21627);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 592, 21333, 21627);
            CallChecker.varInit(this.minImpl, "minImpl", 592, 21333, 21627);
            CallChecker.varInit(this.maxImpl, "maxImpl", 592, 21333, 21627);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 592, 21333, 21627);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 592, 21333, 21627);
            CallChecker.varInit(this.meanImpl, "meanImpl", 592, 21333, 21627);
            CallChecker.varInit(this.eDA, "eDA", 592, 21333, 21627);
            CallChecker.varInit(this.windowSize, "windowSize", 592, 21333, 21627);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 592, 21333, 21627);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 592, 21333, 21627);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 592, 21333, 21627);
            this.minImpl = minImpl;
            CallChecker.varAssign(this.minImpl, "this.minImpl", 593, 21599, 21621);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4340.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getPercentileImpl() {
        MethodContext _bcornu_methode_context4341 = new MethodContext(UnivariateStatistic.class, 602, 21634, 21906);
        try {
            CallChecker.varInit(this, "this", 602, 21634, 21906);
            CallChecker.varInit(this.sumImpl, "sumImpl", 602, 21634, 21906);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 602, 21634, 21906);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 602, 21634, 21906);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 602, 21634, 21906);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 602, 21634, 21906);
            CallChecker.varInit(this.minImpl, "minImpl", 602, 21634, 21906);
            CallChecker.varInit(this.maxImpl, "maxImpl", 602, 21634, 21906);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 602, 21634, 21906);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 602, 21634, 21906);
            CallChecker.varInit(this.meanImpl, "meanImpl", 602, 21634, 21906);
            CallChecker.varInit(this.eDA, "eDA", 602, 21634, 21906);
            CallChecker.varInit(this.windowSize, "windowSize", 602, 21634, 21906);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 602, 21634, 21906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 602, 21634, 21906);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 602, 21634, 21906);
            return percentileImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4341.methodEnd();
        }
    }

    public synchronized void setPercentileImpl(UnivariateStatistic percentileImpl) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4342 = new MethodContext(void.class, 617, 21913, 23443);
        try {
            CallChecker.varInit(this, "this", 617, 21913, 23443);
            CallChecker.varInit(percentileImpl, "percentileImpl", 617, 21913, 23443);
            CallChecker.varInit(this.sumImpl, "sumImpl", 617, 21913, 23443);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 617, 21913, 23443);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 617, 21913, 23443);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 617, 21913, 23443);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 617, 21913, 23443);
            CallChecker.varInit(this.minImpl, "minImpl", 617, 21913, 23443);
            CallChecker.varInit(this.maxImpl, "maxImpl", 617, 21913, 23443);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 617, 21913, 23443);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 617, 21913, 23443);
            CallChecker.varInit(this.meanImpl, "meanImpl", 617, 21913, 23443);
            CallChecker.varInit(this.eDA, "eDA", 617, 21913, 23443);
            CallChecker.varInit(this.windowSize, "windowSize", 617, 21913, 23443);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 617, 21913, 23443);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 617, 21913, 23443);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 617, 21913, 23443);
            TryContext _bcornu_try_context_92 = new TryContext(92, DescriptiveStatistics.class, "java.lang.NoSuchMethodException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException");
            try {
                if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562)) {
                    percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562).getClass(), Class.class, 620, 22549, 22573)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562).getClass(), Class.class, 620, 22549, 22573).getMethod(DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, new Class[]{ Double.TYPE }), Method.class, 620, 22549, 22656)) {
                            percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562);
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 620, 22549, 22562).getClass(), Class.class, 620, 22549, 22573).getMethod(DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, new Class[]{ Double.TYPE }), Method.class, 620, 22549, 22656).invoke(percentileImpl, new Object[]{ Double.valueOf(50.0) });
                        }
                    }
                }
            } catch (NoSuchMethodException e1) {
                _bcornu_try_context_92.catchStart(92);
                if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 626, 22944, 22957)) {
                    percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 626, 22944, 22957);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 626, 22944, 22957).getClass(), Class.class, 626, 22944, 22968)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 626, 22944, 22957);
                        throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD, CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 626, 22944, 22957).getClass(), Class.class, 626, 22944, 22968).getName(), DescriptiveStatistics.SET_QUANTILE_METHOD_NAME);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IllegalAccessException e2) {
                _bcornu_try_context_92.catchStart(92);
                if (CallChecker.beforeDeref(percentileImpl, UnivariateStatistic.class, 630, 23233, 23246)) {
                    percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 630, 23233, 23246);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 630, 23233, 23246).getClass(), Class.class, 630, 23233, 23257)) {
                        percentileImpl = CallChecker.beforeCalled(percentileImpl, UnivariateStatistic.class, 630, 23233, 23246);
                        throw new MathIllegalArgumentException(LocalizedFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD, DescriptiveStatistics.SET_QUANTILE_METHOD_NAME, CallChecker.isCalled(CallChecker.isCalled(percentileImpl, UnivariateStatistic.class, 630, 23233, 23246).getClass(), Class.class, 630, 23233, 23257).getName());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (InvocationTargetException e3) {
                _bcornu_try_context_92.catchStart(92);
                throw new IllegalArgumentException(e3.getCause());
            } finally {
                _bcornu_try_context_92.finallyStart(92);
            }
            this.percentileImpl = percentileImpl;
            CallChecker.varAssign(this.percentileImpl, "this.percentileImpl", 634, 23401, 23437);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4342.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getSkewnessImpl() {
        MethodContext _bcornu_methode_context4343 = new MethodContext(UnivariateStatistic.class, 643, 23450, 23714);
        try {
            CallChecker.varInit(this, "this", 643, 23450, 23714);
            CallChecker.varInit(this.sumImpl, "sumImpl", 643, 23450, 23714);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 643, 23450, 23714);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 643, 23450, 23714);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 643, 23450, 23714);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 643, 23450, 23714);
            CallChecker.varInit(this.minImpl, "minImpl", 643, 23450, 23714);
            CallChecker.varInit(this.maxImpl, "maxImpl", 643, 23450, 23714);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 643, 23450, 23714);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 643, 23450, 23714);
            CallChecker.varInit(this.meanImpl, "meanImpl", 643, 23450, 23714);
            CallChecker.varInit(this.eDA, "eDA", 643, 23450, 23714);
            CallChecker.varInit(this.windowSize, "windowSize", 643, 23450, 23714);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 643, 23450, 23714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 643, 23450, 23714);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 643, 23450, 23714);
            return skewnessImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4343.methodEnd();
        }
    }

    public synchronized void setSkewnessImpl(UnivariateStatistic skewnessImpl) {
        MethodContext _bcornu_methode_context4344 = new MethodContext(void.class, 654, 23721, 24055);
        try {
            CallChecker.varInit(this, "this", 654, 23721, 24055);
            CallChecker.varInit(skewnessImpl, "skewnessImpl", 654, 23721, 24055);
            CallChecker.varInit(this.sumImpl, "sumImpl", 654, 23721, 24055);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 654, 23721, 24055);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 654, 23721, 24055);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 654, 23721, 24055);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 654, 23721, 24055);
            CallChecker.varInit(this.minImpl, "minImpl", 654, 23721, 24055);
            CallChecker.varInit(this.maxImpl, "maxImpl", 654, 23721, 24055);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 654, 23721, 24055);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 654, 23721, 24055);
            CallChecker.varInit(this.meanImpl, "meanImpl", 654, 23721, 24055);
            CallChecker.varInit(this.eDA, "eDA", 654, 23721, 24055);
            CallChecker.varInit(this.windowSize, "windowSize", 654, 23721, 24055);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 654, 23721, 24055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 654, 23721, 24055);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 654, 23721, 24055);
            this.skewnessImpl = skewnessImpl;
            CallChecker.varAssign(this.skewnessImpl, "this.skewnessImpl", 656, 24017, 24049);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4344.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getVarianceImpl() {
        MethodContext _bcornu_methode_context4345 = new MethodContext(UnivariateStatistic.class, 665, 24062, 24326);
        try {
            CallChecker.varInit(this, "this", 665, 24062, 24326);
            CallChecker.varInit(this.sumImpl, "sumImpl", 665, 24062, 24326);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 665, 24062, 24326);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 665, 24062, 24326);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 665, 24062, 24326);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 665, 24062, 24326);
            CallChecker.varInit(this.minImpl, "minImpl", 665, 24062, 24326);
            CallChecker.varInit(this.maxImpl, "maxImpl", 665, 24062, 24326);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 665, 24062, 24326);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 665, 24062, 24326);
            CallChecker.varInit(this.meanImpl, "meanImpl", 665, 24062, 24326);
            CallChecker.varInit(this.eDA, "eDA", 665, 24062, 24326);
            CallChecker.varInit(this.windowSize, "windowSize", 665, 24062, 24326);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 665, 24062, 24326);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 665, 24062, 24326);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 665, 24062, 24326);
            return varianceImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4345.methodEnd();
        }
    }

    public synchronized void setVarianceImpl(UnivariateStatistic varianceImpl) {
        MethodContext _bcornu_methode_context4346 = new MethodContext(void.class, 676, 24333, 24667);
        try {
            CallChecker.varInit(this, "this", 676, 24333, 24667);
            CallChecker.varInit(varianceImpl, "varianceImpl", 676, 24333, 24667);
            CallChecker.varInit(this.sumImpl, "sumImpl", 676, 24333, 24667);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 676, 24333, 24667);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 676, 24333, 24667);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 676, 24333, 24667);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 676, 24333, 24667);
            CallChecker.varInit(this.minImpl, "minImpl", 676, 24333, 24667);
            CallChecker.varInit(this.maxImpl, "maxImpl", 676, 24333, 24667);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 676, 24333, 24667);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 676, 24333, 24667);
            CallChecker.varInit(this.meanImpl, "meanImpl", 676, 24333, 24667);
            CallChecker.varInit(this.eDA, "eDA", 676, 24333, 24667);
            CallChecker.varInit(this.windowSize, "windowSize", 676, 24333, 24667);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 676, 24333, 24667);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 676, 24333, 24667);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 676, 24333, 24667);
            this.varianceImpl = varianceImpl;
            CallChecker.varAssign(this.varianceImpl, "this.varianceImpl", 678, 24629, 24661);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4346.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getSumsqImpl() {
        MethodContext _bcornu_methode_context4347 = new MethodContext(UnivariateStatistic.class, 687, 24674, 24944);
        try {
            CallChecker.varInit(this, "this", 687, 24674, 24944);
            CallChecker.varInit(this.sumImpl, "sumImpl", 687, 24674, 24944);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 687, 24674, 24944);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 687, 24674, 24944);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 687, 24674, 24944);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 687, 24674, 24944);
            CallChecker.varInit(this.minImpl, "minImpl", 687, 24674, 24944);
            CallChecker.varInit(this.maxImpl, "maxImpl", 687, 24674, 24944);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 687, 24674, 24944);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 687, 24674, 24944);
            CallChecker.varInit(this.meanImpl, "meanImpl", 687, 24674, 24944);
            CallChecker.varInit(this.eDA, "eDA", 687, 24674, 24944);
            CallChecker.varInit(this.windowSize, "windowSize", 687, 24674, 24944);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 687, 24674, 24944);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 687, 24674, 24944);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 687, 24674, 24944);
            return sumsqImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4347.methodEnd();
        }
    }

    public synchronized void setSumsqImpl(UnivariateStatistic sumsqImpl) {
        MethodContext _bcornu_methode_context4348 = new MethodContext(void.class, 698, 24951, 25269);
        try {
            CallChecker.varInit(this, "this", 698, 24951, 25269);
            CallChecker.varInit(sumsqImpl, "sumsqImpl", 698, 24951, 25269);
            CallChecker.varInit(this.sumImpl, "sumImpl", 698, 24951, 25269);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 698, 24951, 25269);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 698, 24951, 25269);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 698, 24951, 25269);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 698, 24951, 25269);
            CallChecker.varInit(this.minImpl, "minImpl", 698, 24951, 25269);
            CallChecker.varInit(this.maxImpl, "maxImpl", 698, 24951, 25269);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 698, 24951, 25269);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 698, 24951, 25269);
            CallChecker.varInit(this.meanImpl, "meanImpl", 698, 24951, 25269);
            CallChecker.varInit(this.eDA, "eDA", 698, 24951, 25269);
            CallChecker.varInit(this.windowSize, "windowSize", 698, 24951, 25269);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 698, 24951, 25269);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 698, 24951, 25269);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 698, 24951, 25269);
            this.sumsqImpl = sumsqImpl;
            CallChecker.varAssign(this.sumsqImpl, "this.sumsqImpl", 699, 25237, 25263);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4348.methodEnd();
        }
    }

    public synchronized UnivariateStatistic getSumImpl() {
        MethodContext _bcornu_methode_context4349 = new MethodContext(UnivariateStatistic.class, 708, 25276, 25520);
        try {
            CallChecker.varInit(this, "this", 708, 25276, 25520);
            CallChecker.varInit(this.sumImpl, "sumImpl", 708, 25276, 25520);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 708, 25276, 25520);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 708, 25276, 25520);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 708, 25276, 25520);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 708, 25276, 25520);
            CallChecker.varInit(this.minImpl, "minImpl", 708, 25276, 25520);
            CallChecker.varInit(this.maxImpl, "maxImpl", 708, 25276, 25520);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 708, 25276, 25520);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 708, 25276, 25520);
            CallChecker.varInit(this.meanImpl, "meanImpl", 708, 25276, 25520);
            CallChecker.varInit(this.eDA, "eDA", 708, 25276, 25520);
            CallChecker.varInit(this.windowSize, "windowSize", 708, 25276, 25520);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 708, 25276, 25520);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 708, 25276, 25520);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 708, 25276, 25520);
            return sumImpl;
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4349.methodEnd();
        }
    }

    public synchronized void setSumImpl(UnivariateStatistic sumImpl) {
        MethodContext _bcornu_methode_context4350 = new MethodContext(void.class, 719, 25527, 25813);
        try {
            CallChecker.varInit(this, "this", 719, 25527, 25813);
            CallChecker.varInit(sumImpl, "sumImpl", 719, 25527, 25813);
            CallChecker.varInit(this.sumImpl, "sumImpl", 719, 25527, 25813);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 719, 25527, 25813);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 719, 25527, 25813);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 719, 25527, 25813);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 719, 25527, 25813);
            CallChecker.varInit(this.minImpl, "minImpl", 719, 25527, 25813);
            CallChecker.varInit(this.maxImpl, "maxImpl", 719, 25527, 25813);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 719, 25527, 25813);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 719, 25527, 25813);
            CallChecker.varInit(this.meanImpl, "meanImpl", 719, 25527, 25813);
            CallChecker.varInit(this.eDA, "eDA", 719, 25527, 25813);
            CallChecker.varInit(this.windowSize, "windowSize", 719, 25527, 25813);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 719, 25527, 25813);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 719, 25527, 25813);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 719, 25527, 25813);
            this.sumImpl = sumImpl;
            CallChecker.varAssign(this.sumImpl, "this.sumImpl", 720, 25785, 25807);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4350.methodEnd();
        }
    }

    public DescriptiveStatistics copy() {
        MethodContext _bcornu_methode_context4351 = new MethodContext(DescriptiveStatistics.class, 728, 25820, 26208);
        try {
            CallChecker.varInit(this, "this", 728, 25820, 26208);
            CallChecker.varInit(this.sumImpl, "sumImpl", 728, 25820, 26208);
            CallChecker.varInit(this.sumsqImpl, "sumsqImpl", 728, 25820, 26208);
            CallChecker.varInit(this.varianceImpl, "varianceImpl", 728, 25820, 26208);
            CallChecker.varInit(this.skewnessImpl, "skewnessImpl", 728, 25820, 26208);
            CallChecker.varInit(this.percentileImpl, "percentileImpl", 728, 25820, 26208);
            CallChecker.varInit(this.minImpl, "minImpl", 728, 25820, 26208);
            CallChecker.varInit(this.maxImpl, "maxImpl", 728, 25820, 26208);
            CallChecker.varInit(this.kurtosisImpl, "kurtosisImpl", 728, 25820, 26208);
            CallChecker.varInit(this.geometricMeanImpl, "geometricMeanImpl", 728, 25820, 26208);
            CallChecker.varInit(this.meanImpl, "meanImpl", 728, 25820, 26208);
            CallChecker.varInit(this.eDA, "eDA", 728, 25820, 26208);
            CallChecker.varInit(this.windowSize, "windowSize", 728, 25820, 26208);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 728, 25820, 26208);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 728, 25820, 26208);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 728, 25820, 26208);
            DescriptiveStatistics result = CallChecker.varInit(new DescriptiveStatistics(), "result", 729, 26010, 26068);
            DescriptiveStatistics.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DescriptiveStatistics) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4351.methodEnd();
        }
    }

    public static void copy(DescriptiveStatistics source, DescriptiveStatistics dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context4352 = new MethodContext(void.class, 743, 26215, 27357);
        try {
            CallChecker.varInit(dest, "dest", 743, 26215, 27357);
            CallChecker.varInit(source, "source", 743, 26215, 27357);
            CallChecker.varInit(SET_QUANTILE_METHOD_NAME, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.SET_QUANTILE_METHOD_NAME", 743, 26215, 27357);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.serialVersionUID", 743, 26215, 27357);
            CallChecker.varInit(INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 743, 26215, 27357);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 748, 26736, 26739)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 748, 26747, 26752)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 748, 26747, 26752);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 748, 26747, 26752).eDA, ResizableDoubleArray.class, 748, 26747, 26756)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 748, 26736, 26739);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 748, 26747, 26752);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 748, 26747, 26752).eDA = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 748, 26747, 26752).eDA, ResizableDoubleArray.class, 748, 26747, 26756);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 748, 26736, 26739).eDA = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 748, 26747, 26752).eDA, ResizableDoubleArray.class, 748, 26747, 26756).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 748, 26736, 26739).eDA, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 748, 26736, 26739).eDA", 748, 26736, 26764);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 749, 26774, 26777)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 749, 26792, 26797)) {
                    dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 749, 26774, 26777);
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 749, 26792, 26797);
                    CallChecker.isCalled(dest, DescriptiveStatistics.class, 749, 26774, 26777).windowSize = CallChecker.isCalled(source, DescriptiveStatistics.class, 749, 26792, 26797).windowSize;
                    CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 749, 26774, 26777).windowSize, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 749, 26774, 26777).windowSize", 749, 26774, 26809);
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 752, 26852, 26855)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 752, 26867, 26872)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 752, 26867, 26872);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 752, 26867, 26872).maxImpl, UnivariateStatistic.class, 752, 26867, 26880)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 752, 26852, 26855);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 752, 26867, 26872);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 752, 26867, 26872).maxImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 752, 26867, 26872).maxImpl, UnivariateStatistic.class, 752, 26867, 26880);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 752, 26852, 26855).maxImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 752, 26867, 26872).maxImpl, UnivariateStatistic.class, 752, 26867, 26880).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 752, 26852, 26855).maxImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 752, 26852, 26855).maxImpl", 752, 26852, 26888);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 753, 26898, 26901)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 753, 26914, 26919)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 753, 26914, 26919);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 753, 26914, 26919).meanImpl, UnivariateStatistic.class, 753, 26914, 26928)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 753, 26898, 26901);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 753, 26914, 26919);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 753, 26914, 26919).meanImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 753, 26914, 26919).meanImpl, UnivariateStatistic.class, 753, 26914, 26928);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 753, 26898, 26901).meanImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 753, 26914, 26919).meanImpl, UnivariateStatistic.class, 753, 26914, 26928).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 753, 26898, 26901).meanImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 753, 26898, 26901).meanImpl", 753, 26898, 26936);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 754, 26946, 26949)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 754, 26961, 26966)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 754, 26961, 26966);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 754, 26961, 26966).minImpl, UnivariateStatistic.class, 754, 26961, 26974)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 754, 26946, 26949);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 754, 26961, 26966);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 754, 26961, 26966).minImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 754, 26961, 26966).minImpl, UnivariateStatistic.class, 754, 26961, 26974);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 754, 26946, 26949).minImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 754, 26961, 26966).minImpl, UnivariateStatistic.class, 754, 26961, 26974).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 754, 26946, 26949).minImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 754, 26946, 26949).minImpl", 754, 26946, 26982);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 755, 26992, 26995)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 755, 27007, 27012)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 755, 27007, 27012);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 755, 27007, 27012).sumImpl, UnivariateStatistic.class, 755, 27007, 27020)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 755, 26992, 26995);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 755, 27007, 27012);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 755, 27007, 27012).sumImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 755, 27007, 27012).sumImpl, UnivariateStatistic.class, 755, 27007, 27020);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 755, 26992, 26995).sumImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 755, 27007, 27012).sumImpl, UnivariateStatistic.class, 755, 27007, 27020).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 755, 26992, 26995).sumImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 755, 26992, 26995).sumImpl", 755, 26992, 27028);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 756, 27038, 27041)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 756, 27058, 27063)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 756, 27058, 27063);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 756, 27058, 27063).varianceImpl, UnivariateStatistic.class, 756, 27058, 27076)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 756, 27038, 27041);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 756, 27058, 27063);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 756, 27058, 27063).varianceImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 756, 27058, 27063).varianceImpl, UnivariateStatistic.class, 756, 27058, 27076);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 756, 27038, 27041).varianceImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 756, 27058, 27063).varianceImpl, UnivariateStatistic.class, 756, 27058, 27076).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 756, 27038, 27041).varianceImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 756, 27038, 27041).varianceImpl", 756, 27038, 27084);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 757, 27094, 27097)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 757, 27111, 27116)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 757, 27111, 27116);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 757, 27111, 27116).sumsqImpl, UnivariateStatistic.class, 757, 27111, 27126)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 757, 27094, 27097);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 757, 27111, 27116);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 757, 27111, 27116).sumsqImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 757, 27111, 27116).sumsqImpl, UnivariateStatistic.class, 757, 27111, 27126);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 757, 27094, 27097).sumsqImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 757, 27111, 27116).sumsqImpl, UnivariateStatistic.class, 757, 27111, 27126).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 757, 27094, 27097).sumsqImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 757, 27094, 27097).sumsqImpl", 757, 27094, 27134);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 758, 27144, 27147)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 758, 27169, 27174)) {
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 758, 27169, 27174);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, DescriptiveStatistics.class, 758, 27169, 27174).geometricMeanImpl, UnivariateStatistic.class, 758, 27169, 27192)) {
                        dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 758, 27144, 27147);
                        source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 758, 27169, 27174);
                        CallChecker.isCalled(source, DescriptiveStatistics.class, 758, 27169, 27174).geometricMeanImpl = CallChecker.beforeCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 758, 27169, 27174).geometricMeanImpl, UnivariateStatistic.class, 758, 27169, 27192);
                        CallChecker.isCalled(dest, DescriptiveStatistics.class, 758, 27144, 27147).geometricMeanImpl = CallChecker.isCalled(CallChecker.isCalled(source, DescriptiveStatistics.class, 758, 27169, 27174).geometricMeanImpl, UnivariateStatistic.class, 758, 27169, 27192).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 758, 27144, 27147).geometricMeanImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 758, 27144, 27147).geometricMeanImpl", 758, 27144, 27200);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 759, 27210, 27213)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 759, 27230, 27235)) {
                    dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 759, 27210, 27213);
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 759, 27230, 27235);
                    CallChecker.isCalled(dest, DescriptiveStatistics.class, 759, 27210, 27213).kurtosisImpl = CallChecker.isCalled(source, DescriptiveStatistics.class, 759, 27230, 27235).kurtosisImpl;
                    CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 759, 27210, 27213).kurtosisImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 759, 27210, 27213).kurtosisImpl", 759, 27210, 27249);
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 760, 27259, 27262)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 760, 27279, 27284)) {
                    dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 760, 27259, 27262);
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 760, 27279, 27284);
                    CallChecker.isCalled(dest, DescriptiveStatistics.class, 760, 27259, 27262).skewnessImpl = CallChecker.isCalled(source, DescriptiveStatistics.class, 760, 27279, 27284).skewnessImpl;
                    CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 760, 27259, 27262).skewnessImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 760, 27259, 27262).skewnessImpl", 760, 27259, 27298);
                }
            }
            if (CallChecker.beforeDeref(dest, DescriptiveStatistics.class, 761, 27308, 27311)) {
                if (CallChecker.beforeDeref(source, DescriptiveStatistics.class, 761, 27330, 27335)) {
                    dest = CallChecker.beforeCalled(dest, DescriptiveStatistics.class, 761, 27308, 27311);
                    source = CallChecker.beforeCalled(source, DescriptiveStatistics.class, 761, 27330, 27335);
                    CallChecker.isCalled(dest, DescriptiveStatistics.class, 761, 27308, 27311).percentileImpl = CallChecker.isCalled(source, DescriptiveStatistics.class, 761, 27330, 27335).percentileImpl;
                    CallChecker.varAssign(CallChecker.isCalled(dest, DescriptiveStatistics.class, 761, 27308, 27311).percentileImpl, "CallChecker.isCalled(dest, DescriptiveStatistics.class, 761, 27308, 27311).percentileImpl", 761, 27308, 27351);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4352.methodEnd();
        }
    }
}

