package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public class MultivariateSummaryStatistics implements Serializable , StatisticalMultivariateSummary {
    private static final long serialVersionUID = 2271900808994826718L;

    private int k;

    private long n = 0;

    private StorelessUnivariateStatistic[] sumImpl;

    private StorelessUnivariateStatistic[] sumSqImpl;

    private StorelessUnivariateStatistic[] minImpl;

    private StorelessUnivariateStatistic[] maxImpl;

    private StorelessUnivariateStatistic[] sumLogImpl;

    private StorelessUnivariateStatistic[] geoMeanImpl;

    private StorelessUnivariateStatistic[] meanImpl;

    private VectorialCovariance covarianceImpl;

    public MultivariateSummaryStatistics(int k, boolean isCovarianceBiasCorrected) {
        ConstructorContext _bcornu_methode_context1187 = new ConstructorContext(MultivariateSummaryStatistics.class, 115, 4968, 6210);
        try {
            this.k = k;
            CallChecker.varAssign(this.k, "this.k", 116, 5331, 5341);
            sumImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.sumImpl, "this.sumImpl", 118, 5352, 5401);
            sumSqImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.sumSqImpl, "this.sumSqImpl", 119, 5411, 5460);
            minImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.minImpl, "this.minImpl", 120, 5470, 5519);
            maxImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.maxImpl, "this.maxImpl", 121, 5529, 5578);
            sumLogImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.sumLogImpl, "this.sumLogImpl", 122, 5588, 5637);
            geoMeanImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.geoMeanImpl, "this.geoMeanImpl", 123, 5647, 5696);
            meanImpl = new StorelessUnivariateStatistic[k];
            CallChecker.varAssign(this.meanImpl, "this.meanImpl", 124, 5706, 5755);
            for (int i = 0; i < k; ++i) {
                if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic[].class, 127, 5808, 5814)) {
                    sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 127, 5808, 5814);
                    CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 127, 5808, 5814)[i] = new Sum();
                    CallChecker.varAssign(CallChecker.isCalled(this.sumImpl, StorelessUnivariateStatistic[].class, 127, 5808, 5814)[i], "CallChecker.isCalled(this.sumImpl, StorelessUnivariateStatistic[].class, 127, 5808, 5814)[i]", 127, 5808, 5834);
                }
                if (CallChecker.beforeDeref(sumSqImpl, StorelessUnivariateStatistic[].class, 128, 5848, 5856)) {
                    sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 128, 5848, 5856);
                    CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 128, 5848, 5856)[i] = new SumOfSquares();
                    CallChecker.varAssign(CallChecker.isCalled(this.sumSqImpl, StorelessUnivariateStatistic[].class, 128, 5848, 5856)[i], "CallChecker.isCalled(this.sumSqImpl, StorelessUnivariateStatistic[].class, 128, 5848, 5856)[i]", 128, 5848, 5883);
                }
                if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic[].class, 129, 5897, 5903)) {
                    minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 129, 5897, 5903);
                    CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 129, 5897, 5903)[i] = new Min();
                    CallChecker.varAssign(CallChecker.isCalled(this.minImpl, StorelessUnivariateStatistic[].class, 129, 5897, 5903)[i], "CallChecker.isCalled(this.minImpl, StorelessUnivariateStatistic[].class, 129, 5897, 5903)[i]", 129, 5897, 5923);
                }
                if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic[].class, 130, 5937, 5943)) {
                    maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 130, 5937, 5943);
                    CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 130, 5937, 5943)[i] = new Max();
                    CallChecker.varAssign(CallChecker.isCalled(this.maxImpl, StorelessUnivariateStatistic[].class, 130, 5937, 5943)[i], "CallChecker.isCalled(this.maxImpl, StorelessUnivariateStatistic[].class, 130, 5937, 5943)[i]", 130, 5937, 5963);
                }
                if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic[].class, 131, 5977, 5986)) {
                    sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 131, 5977, 5986);
                    CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 131, 5977, 5986)[i] = new SumOfLogs();
                    CallChecker.varAssign(CallChecker.isCalled(this.sumLogImpl, StorelessUnivariateStatistic[].class, 131, 5977, 5986)[i], "CallChecker.isCalled(this.sumLogImpl, StorelessUnivariateStatistic[].class, 131, 5977, 5986)[i]", 131, 5977, 6009);
                }
                if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic[].class, 132, 6023, 6033)) {
                    geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 132, 6023, 6033);
                    CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 132, 6023, 6033)[i] = new GeometricMean();
                    CallChecker.varAssign(CallChecker.isCalled(this.geoMeanImpl, StorelessUnivariateStatistic[].class, 132, 6023, 6033)[i], "CallChecker.isCalled(this.geoMeanImpl, StorelessUnivariateStatistic[].class, 132, 6023, 6033)[i]", 132, 6023, 6059);
                }
                if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic[].class, 133, 6073, 6080)) {
                    meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 133, 6073, 6080);
                    CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 133, 6073, 6080)[i] = new Mean();
                    CallChecker.varAssign(CallChecker.isCalled(this.meanImpl, StorelessUnivariateStatistic[].class, 133, 6073, 6080)[i], "CallChecker.isCalled(this.meanImpl, StorelessUnivariateStatistic[].class, 133, 6073, 6080)[i]", 133, 6073, 6100);
                }
            }
            covarianceImpl = new VectorialCovariance(k, isCovarianceBiasCorrected);
            CallChecker.varAssign(this.covarianceImpl, "this.covarianceImpl", 136, 6121, 6203);
        } finally {
            _bcornu_methode_context1187.methodEnd();
        }
    }

    public void addValue(double[] value) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5317 = new MethodContext(void.class, 148, 6217, 6953);
        try {
            CallChecker.varInit(this, "this", 148, 6217, 6953);
            CallChecker.varInit(value, "value", 148, 6217, 6953);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 148, 6217, 6953);
            CallChecker.varInit(this.meanImpl, "meanImpl", 148, 6217, 6953);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 148, 6217, 6953);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 148, 6217, 6953);
            CallChecker.varInit(this.maxImpl, "maxImpl", 148, 6217, 6953);
            CallChecker.varInit(this.minImpl, "minImpl", 148, 6217, 6953);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 148, 6217, 6953);
            CallChecker.varInit(this.sumImpl, "sumImpl", 148, 6217, 6953);
            CallChecker.varInit(this.n, "n", 148, 6217, 6953);
            CallChecker.varInit(this.k, "k", 148, 6217, 6953);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 148, 6217, 6953);
            if (CallChecker.beforeDeref(value, double[].class, 149, 6530, 6534)) {
                value = CallChecker.beforeCalled(value, double[].class, 149, 6530, 6534);
                checkDimension(CallChecker.isCalled(value, double[].class, 149, 6530, 6534).length);
            }
            for (int i = 0; i < (k); ++i) {
                double v = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(value, double[].class, 151, 6606, 6610)) {
                    value = CallChecker.beforeCalled(value, double[].class, 151, 6606, 6610);
                    v = CallChecker.isCalled(value, double[].class, 151, 6606, 6610)[i];
                    CallChecker.varAssign(v, "v", 151, 6606, 6610);
                }
                if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634)) {
                    sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634)[i], StorelessUnivariateStatistic.class, 152, 6628, 6637)) {
                        sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634);
                        CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634)[i], StorelessUnivariateStatistic.class, 152, 6628, 6637);
                        CallChecker.isCalled(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 152, 6628, 6634)[i], StorelessUnivariateStatistic.class, 152, 6628, 6637).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673)) {
                    sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673)[i], StorelessUnivariateStatistic.class, 153, 6665, 6676)) {
                        sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673);
                        CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673)[i], StorelessUnivariateStatistic.class, 153, 6665, 6676);
                        CallChecker.isCalled(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 153, 6665, 6673)[i], StorelessUnivariateStatistic.class, 153, 6665, 6676).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710)) {
                    minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710)[i], StorelessUnivariateStatistic.class, 154, 6704, 6713)) {
                        minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710);
                        CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710)[i] = CallChecker.beforeCalled(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710)[i], StorelessUnivariateStatistic.class, 154, 6704, 6713);
                        CallChecker.isCalled(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 154, 6704, 6710)[i], StorelessUnivariateStatistic.class, 154, 6704, 6713).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747)) {
                    maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747)[i], StorelessUnivariateStatistic.class, 155, 6741, 6750)) {
                        maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747);
                        CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747)[i] = CallChecker.beforeCalled(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747)[i], StorelessUnivariateStatistic.class, 155, 6741, 6750);
                        CallChecker.isCalled(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 155, 6741, 6747)[i], StorelessUnivariateStatistic.class, 155, 6741, 6750).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787)) {
                    sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787)[i], StorelessUnivariateStatistic.class, 156, 6778, 6790)) {
                        sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787);
                        CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787)[i], StorelessUnivariateStatistic.class, 156, 6778, 6790);
                        CallChecker.isCalled(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 156, 6778, 6787)[i], StorelessUnivariateStatistic.class, 156, 6778, 6790).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828)) {
                    geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828)[i], StorelessUnivariateStatistic.class, 157, 6818, 6831)) {
                        geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828);
                        CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828)[i] = CallChecker.beforeCalled(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828)[i], StorelessUnivariateStatistic.class, 157, 6818, 6831);
                        CallChecker.isCalled(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 157, 6818, 6828)[i], StorelessUnivariateStatistic.class, 157, 6818, 6831).increment(v);
                    }
                }
                if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866)) {
                    meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866)[i], StorelessUnivariateStatistic.class, 158, 6859, 6869)) {
                        meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866);
                        CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866)[i] = CallChecker.beforeCalled(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866)[i], StorelessUnivariateStatistic.class, 158, 6859, 6869);
                        CallChecker.isCalled(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 158, 6859, 6866)[i], StorelessUnivariateStatistic.class, 158, 6859, 6869).increment(v);
                    }
                }
            }
            if (CallChecker.beforeDeref(covarianceImpl, VectorialCovariance.class, 160, 6903, 6916)) {
                covarianceImpl = CallChecker.beforeCalled(covarianceImpl, VectorialCovariance.class, 160, 6903, 6916);
                CallChecker.isCalled(covarianceImpl, VectorialCovariance.class, 160, 6903, 6916).increment(value);
            }
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5317.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context5318 = new MethodContext(int.class, 168, 6960, 7108);
        try {
            CallChecker.varInit(this, "this", 168, 6960, 7108);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 168, 6960, 7108);
            CallChecker.varInit(this.meanImpl, "meanImpl", 168, 6960, 7108);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 168, 6960, 7108);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 168, 6960, 7108);
            CallChecker.varInit(this.maxImpl, "maxImpl", 168, 6960, 7108);
            CallChecker.varInit(this.minImpl, "minImpl", 168, 6960, 7108);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 168, 6960, 7108);
            CallChecker.varInit(this.sumImpl, "sumImpl", 168, 6960, 7108);
            CallChecker.varInit(this.n, "n", 168, 6960, 7108);
            CallChecker.varInit(this.k, "k", 168, 6960, 7108);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 168, 6960, 7108);
            return k;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5318.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context5319 = new MethodContext(long.class, 176, 7115, 7266);
        try {
            CallChecker.varInit(this, "this", 176, 7115, 7266);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 176, 7115, 7266);
            CallChecker.varInit(this.meanImpl, "meanImpl", 176, 7115, 7266);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 176, 7115, 7266);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 176, 7115, 7266);
            CallChecker.varInit(this.maxImpl, "maxImpl", 176, 7115, 7266);
            CallChecker.varInit(this.minImpl, "minImpl", 176, 7115, 7266);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 176, 7115, 7266);
            CallChecker.varInit(this.sumImpl, "sumImpl", 176, 7115, 7266);
            CallChecker.varInit(this.n, "n", 176, 7115, 7266);
            CallChecker.varInit(this.k, "k", 176, 7115, 7266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 176, 7115, 7266);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5319.methodEnd();
        }
    }

    private double[] getResults(StorelessUnivariateStatistic[] stats) {
        MethodContext _bcornu_methode_context5320 = new MethodContext(double[].class, 185, 7273, 7677);
        try {
            CallChecker.varInit(this, "this", 185, 7273, 7677);
            CallChecker.varInit(stats, "stats", 185, 7273, 7677);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 185, 7273, 7677);
            CallChecker.varInit(this.meanImpl, "meanImpl", 185, 7273, 7677);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 185, 7273, 7677);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 185, 7273, 7677);
            CallChecker.varInit(this.maxImpl, "maxImpl", 185, 7273, 7677);
            CallChecker.varInit(this.minImpl, "minImpl", 185, 7273, 7677);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 185, 7273, 7677);
            CallChecker.varInit(this.sumImpl, "sumImpl", 185, 7273, 7677);
            CallChecker.varInit(this.n, "n", 185, 7273, 7677);
            CallChecker.varInit(this.k, "k", 185, 7273, 7677);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 185, 7273, 7677);
            double[] results = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(stats, StorelessUnivariateStatistic[].class, 186, 7526, 7530)) {
                stats = CallChecker.beforeCalled(stats, StorelessUnivariateStatistic[].class, 186, 7526, 7530);
                results = new double[CallChecker.isCalled(stats, StorelessUnivariateStatistic[].class, 186, 7526, 7530).length];
                CallChecker.varAssign(results, "results", 186, 7526, 7530);
            }
            results = CallChecker.beforeCalled(results, double[].class, 187, 7569, 7575);
            for (int i = 0; i < (CallChecker.isCalled(results, double[].class, 187, 7569, 7575).length); ++i) {
                if (CallChecker.beforeDeref(results, double[].class, 188, 7604, 7610)) {
                    if (CallChecker.beforeDeref(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621)) {
                        stats = CallChecker.beforeCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621)[i], StorelessUnivariateStatistic.class, 188, 7617, 7624)) {
                            results = CallChecker.beforeCalled(results, double[].class, 188, 7604, 7610);
                            stats = CallChecker.beforeCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621);
                            CallChecker.isCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621)[i], StorelessUnivariateStatistic.class, 188, 7617, 7624);
                            CallChecker.isCalled(results, double[].class, 188, 7604, 7610)[i] = CallChecker.isCalled(CallChecker.isCalled(stats, StorelessUnivariateStatistic[].class, 188, 7617, 7621)[i], StorelessUnivariateStatistic.class, 188, 7617, 7624).getResult();
                            CallChecker.varAssign(CallChecker.isCalled(results, double[].class, 188, 7604, 7610)[i], "CallChecker.isCalled(results, double[].class, 188, 7604, 7610)[i]", 188, 7604, 7637);
                        }
                    }
                }
            }
            return results;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5320.methodEnd();
        }
    }

    public double[] getSum() {
        MethodContext _bcornu_methode_context5321 = new MethodContext(double[].class, 200, 7684, 7992);
        try {
            CallChecker.varInit(this, "this", 200, 7684, 7992);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 200, 7684, 7992);
            CallChecker.varInit(this.meanImpl, "meanImpl", 200, 7684, 7992);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 200, 7684, 7992);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 200, 7684, 7992);
            CallChecker.varInit(this.maxImpl, "maxImpl", 200, 7684, 7992);
            CallChecker.varInit(this.minImpl, "minImpl", 200, 7684, 7992);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 200, 7684, 7992);
            CallChecker.varInit(this.sumImpl, "sumImpl", 200, 7684, 7992);
            CallChecker.varInit(this.n, "n", 200, 7684, 7992);
            CallChecker.varInit(this.k, "k", 200, 7684, 7992);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 200, 7684, 7992);
            return getResults(sumImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5321.methodEnd();
        }
    }

    public double[] getSumSq() {
        MethodContext _bcornu_methode_context5322 = new MethodContext(double[].class, 211, 7999, 8333);
        try {
            CallChecker.varInit(this, "this", 211, 7999, 8333);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 211, 7999, 8333);
            CallChecker.varInit(this.meanImpl, "meanImpl", 211, 7999, 8333);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 211, 7999, 8333);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 211, 7999, 8333);
            CallChecker.varInit(this.maxImpl, "maxImpl", 211, 7999, 8333);
            CallChecker.varInit(this.minImpl, "minImpl", 211, 7999, 8333);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 211, 7999, 8333);
            CallChecker.varInit(this.sumImpl, "sumImpl", 211, 7999, 8333);
            CallChecker.varInit(this.n, "n", 211, 7999, 8333);
            CallChecker.varInit(this.k, "k", 211, 7999, 8333);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 211, 7999, 8333);
            return getResults(sumSqImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5322.methodEnd();
        }
    }

    public double[] getSumLog() {
        MethodContext _bcornu_methode_context5323 = new MethodContext(double[].class, 222, 8340, 8666);
        try {
            CallChecker.varInit(this, "this", 222, 8340, 8666);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 222, 8340, 8666);
            CallChecker.varInit(this.meanImpl, "meanImpl", 222, 8340, 8666);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 222, 8340, 8666);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 222, 8340, 8666);
            CallChecker.varInit(this.maxImpl, "maxImpl", 222, 8340, 8666);
            CallChecker.varInit(this.minImpl, "minImpl", 222, 8340, 8666);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 222, 8340, 8666);
            CallChecker.varInit(this.sumImpl, "sumImpl", 222, 8340, 8666);
            CallChecker.varInit(this.n, "n", 222, 8340, 8666);
            CallChecker.varInit(this.k, "k", 222, 8340, 8666);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 222, 8340, 8666);
            return getResults(sumLogImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5323.methodEnd();
        }
    }

    public double[] getMean() {
        MethodContext _bcornu_methode_context5324 = new MethodContext(double[].class, 233, 8673, 8985);
        try {
            CallChecker.varInit(this, "this", 233, 8673, 8985);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 233, 8673, 8985);
            CallChecker.varInit(this.meanImpl, "meanImpl", 233, 8673, 8985);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 233, 8673, 8985);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 233, 8673, 8985);
            CallChecker.varInit(this.maxImpl, "maxImpl", 233, 8673, 8985);
            CallChecker.varInit(this.minImpl, "minImpl", 233, 8673, 8985);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 233, 8673, 8985);
            CallChecker.varInit(this.sumImpl, "sumImpl", 233, 8673, 8985);
            CallChecker.varInit(this.n, "n", 233, 8673, 8985);
            CallChecker.varInit(this.k, "k", 233, 8673, 8985);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 233, 8673, 8985);
            return getResults(meanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5324.methodEnd();
        }
    }

    public double[] getStandardDeviation() {
        MethodContext _bcornu_methode_context5325 = new MethodContext(double[].class, 244, 8992, 9723);
        try {
            CallChecker.varInit(this, "this", 244, 8992, 9723);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 244, 8992, 9723);
            CallChecker.varInit(this.meanImpl, "meanImpl", 244, 8992, 9723);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 244, 8992, 9723);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 244, 8992, 9723);
            CallChecker.varInit(this.maxImpl, "maxImpl", 244, 8992, 9723);
            CallChecker.varInit(this.minImpl, "minImpl", 244, 8992, 9723);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 244, 8992, 9723);
            CallChecker.varInit(this.sumImpl, "sumImpl", 244, 8992, 9723);
            CallChecker.varInit(this.n, "n", 244, 8992, 9723);
            CallChecker.varInit(this.k, "k", 244, 8992, 9723);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 244, 8992, 9723);
            double[] stdDev = CallChecker.varInit(new double[k], "stdDev", 245, 9312, 9343);
            if ((getN()) < 1) {
                Arrays.fill(stdDev, Double.NaN);
            }else
                if ((getN()) < 2) {
                    Arrays.fill(stdDev, 0.0);
                }else {
                    RealMatrix matrix = CallChecker.init(RealMatrix.class);
                    if (CallChecker.beforeDeref(covarianceImpl, VectorialCovariance.class, 251, 9536, 9549)) {
                        covarianceImpl = CallChecker.beforeCalled(covarianceImpl, VectorialCovariance.class, 251, 9536, 9549);
                        matrix = CallChecker.isCalled(covarianceImpl, VectorialCovariance.class, 251, 9536, 9549).getResult();
                        CallChecker.varAssign(matrix, "matrix", 251, 9536, 9549);
                    }
                    for (int i = 0; i < (k); ++i) {
                        if (CallChecker.beforeDeref(stdDev, double[].class, 253, 9622, 9627)) {
                            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 253, 9648, 9653)) {
                                stdDev = CallChecker.beforeCalled(stdDev, double[].class, 253, 9622, 9627);
                                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 253, 9648, 9653);
                                CallChecker.isCalled(stdDev, double[].class, 253, 9622, 9627)[i] = org.apache.commons.math3.util.FastMath.sqrt(CallChecker.isCalled(matrix, RealMatrix.class, 253, 9648, 9653).getEntry(i, i));
                                CallChecker.varAssign(CallChecker.isCalled(stdDev, double[].class, 253, 9622, 9627)[i], "CallChecker.isCalled(stdDev, double[].class, 253, 9622, 9627)[i]", 253, 9622, 9670);
                            }
                        }
                    }
                }
            
            return stdDev;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5325.methodEnd();
        }
    }

    public RealMatrix getCovariance() {
        MethodContext _bcornu_methode_context5326 = new MethodContext(RealMatrix.class, 264, 9730, 9946);
        try {
            CallChecker.varInit(this, "this", 264, 9730, 9946);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 264, 9730, 9946);
            CallChecker.varInit(this.meanImpl, "meanImpl", 264, 9730, 9946);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 264, 9730, 9946);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 264, 9730, 9946);
            CallChecker.varInit(this.maxImpl, "maxImpl", 264, 9730, 9946);
            CallChecker.varInit(this.minImpl, "minImpl", 264, 9730, 9946);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 264, 9730, 9946);
            CallChecker.varInit(this.sumImpl, "sumImpl", 264, 9730, 9946);
            CallChecker.varInit(this.n, "n", 264, 9730, 9946);
            CallChecker.varInit(this.k, "k", 264, 9730, 9946);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 264, 9730, 9946);
            if (CallChecker.beforeDeref(covarianceImpl, VectorialCovariance.class, 265, 9914, 9927)) {
                covarianceImpl = CallChecker.beforeCalled(covarianceImpl, VectorialCovariance.class, 265, 9914, 9927);
                return CallChecker.isCalled(covarianceImpl, VectorialCovariance.class, 265, 9914, 9927).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5326.methodEnd();
        }
    }

    public double[] getMax() {
        MethodContext _bcornu_methode_context5327 = new MethodContext(double[].class, 275, 9953, 10267);
        try {
            CallChecker.varInit(this, "this", 275, 9953, 10267);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 275, 9953, 10267);
            CallChecker.varInit(this.meanImpl, "meanImpl", 275, 9953, 10267);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 275, 9953, 10267);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 275, 9953, 10267);
            CallChecker.varInit(this.maxImpl, "maxImpl", 275, 9953, 10267);
            CallChecker.varInit(this.minImpl, "minImpl", 275, 9953, 10267);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 275, 9953, 10267);
            CallChecker.varInit(this.sumImpl, "sumImpl", 275, 9953, 10267);
            CallChecker.varInit(this.n, "n", 275, 9953, 10267);
            CallChecker.varInit(this.k, "k", 275, 9953, 10267);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 275, 9953, 10267);
            return getResults(maxImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5327.methodEnd();
        }
    }

    public double[] getMin() {
        MethodContext _bcornu_methode_context5328 = new MethodContext(double[].class, 286, 10274, 10588);
        try {
            CallChecker.varInit(this, "this", 286, 10274, 10588);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 286, 10274, 10588);
            CallChecker.varInit(this.meanImpl, "meanImpl", 286, 10274, 10588);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 286, 10274, 10588);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 286, 10274, 10588);
            CallChecker.varInit(this.maxImpl, "maxImpl", 286, 10274, 10588);
            CallChecker.varInit(this.minImpl, "minImpl", 286, 10274, 10588);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 286, 10274, 10588);
            CallChecker.varInit(this.sumImpl, "sumImpl", 286, 10274, 10588);
            CallChecker.varInit(this.n, "n", 286, 10274, 10588);
            CallChecker.varInit(this.k, "k", 286, 10274, 10588);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 286, 10274, 10588);
            return getResults(minImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5328.methodEnd();
        }
    }

    public double[] getGeometricMean() {
        MethodContext _bcornu_methode_context5329 = new MethodContext(double[].class, 297, 10595, 10939);
        try {
            CallChecker.varInit(this, "this", 297, 10595, 10939);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 297, 10595, 10939);
            CallChecker.varInit(this.meanImpl, "meanImpl", 297, 10595, 10939);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 297, 10595, 10939);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 297, 10595, 10939);
            CallChecker.varInit(this.maxImpl, "maxImpl", 297, 10595, 10939);
            CallChecker.varInit(this.minImpl, "minImpl", 297, 10595, 10939);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 297, 10595, 10939);
            CallChecker.varInit(this.sumImpl, "sumImpl", 297, 10595, 10939);
            CallChecker.varInit(this.n, "n", 297, 10595, 10939);
            CallChecker.varInit(this.k, "k", 297, 10595, 10939);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 297, 10595, 10939);
            return getResults(geoMeanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5329.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context5330 = new MethodContext(String.class, 308, 10946, 12112);
        try {
            CallChecker.varInit(this, "this", 308, 10946, 12112);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 308, 10946, 12112);
            CallChecker.varInit(this.meanImpl, "meanImpl", 308, 10946, 12112);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 308, 10946, 12112);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 308, 10946, 12112);
            CallChecker.varInit(this.maxImpl, "maxImpl", 308, 10946, 12112);
            CallChecker.varInit(this.minImpl, "minImpl", 308, 10946, 12112);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 308, 10946, 12112);
            CallChecker.varInit(this.sumImpl, "sumImpl", 308, 10946, 12112);
            CallChecker.varInit(this.n, "n", 308, 10946, 12112);
            CallChecker.varInit(this.k, "k", 308, 10946, 12112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 308, 10946, 12112);
            final String separator = CallChecker.varInit(", ", "separator", 309, 11180, 11209);
            final String suffix = CallChecker.varInit(System.getProperty("line.separator"), "suffix", 310, 11219, 11277);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 311, 11287, 11332);
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 312, 11342, 11350)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 312, 11342, 11350);
                CallChecker.isCalled(outBuffer, StringBuilder.class, 312, 11342, 11350).append(("MultivariateSummaryStatistics:" + suffix));
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 313, 11411, 11419)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 313, 11411, 11419);
                CallChecker.isCalled(outBuffer, StringBuilder.class, 313, 11411, 11419).append((("n: " + (getN())) + suffix));
            }
            append(outBuffer, getMin(), "min: ", separator, suffix);
            append(outBuffer, getMax(), "max: ", separator, suffix);
            append(outBuffer, getMean(), "mean: ", separator, suffix);
            append(outBuffer, getGeometricMean(), "geometric mean: ", separator, suffix);
            append(outBuffer, getSumSq(), "sum of squares: ", separator, suffix);
            append(outBuffer, getSumLog(), "sum of logarithms: ", separator, suffix);
            append(outBuffer, getStandardDeviation(), "standard deviation: ", separator, suffix);
            final RealMatrix npe_invocation_var1000 = getCovariance();
            if (CallChecker.beforeDeref(npe_invocation_var1000, RealMatrix.class, 321, 12033, 12047)) {
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 321, 11999, 12007)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 321, 11999, 12007);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 321, 11999, 12007).append((("covariance: " + (CallChecker.isCalled(npe_invocation_var1000, RealMatrix.class, 321, 12033, 12047).toString())) + suffix));
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 322, 12086, 12094)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 322, 12086, 12094);
                return CallChecker.isCalled(outBuffer, StringBuilder.class, 322, 12086, 12094).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5330.methodEnd();
        }
    }

    private void append(StringBuilder buffer, double[] data, String prefix, String separator, String suffix) {
        MethodContext _bcornu_methode_context5331 = new MethodContext(void.class, 333, 12119, 12743);
        try {
            CallChecker.varInit(this, "this", 333, 12119, 12743);
            CallChecker.varInit(suffix, "suffix", 333, 12119, 12743);
            CallChecker.varInit(separator, "separator", 333, 12119, 12743);
            CallChecker.varInit(prefix, "prefix", 333, 12119, 12743);
            CallChecker.varInit(data, "data", 333, 12119, 12743);
            CallChecker.varInit(buffer, "buffer", 333, 12119, 12743);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 333, 12119, 12743);
            CallChecker.varInit(this.meanImpl, "meanImpl", 333, 12119, 12743);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 333, 12119, 12743);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 333, 12119, 12743);
            CallChecker.varInit(this.maxImpl, "maxImpl", 333, 12119, 12743);
            CallChecker.varInit(this.minImpl, "minImpl", 333, 12119, 12743);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 333, 12119, 12743);
            CallChecker.varInit(this.sumImpl, "sumImpl", 333, 12119, 12743);
            CallChecker.varInit(this.n, "n", 333, 12119, 12743);
            CallChecker.varInit(this.k, "k", 333, 12119, 12743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 333, 12119, 12743);
            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 335, 12510, 12515)) {
                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 335, 12510, 12515);
                CallChecker.isCalled(buffer, StringBuilder.class, 335, 12510, 12515).append(prefix);
            }
            data = CallChecker.beforeCalled(data, double[].class, 336, 12561, 12564);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 336, 12561, 12564).length); ++i) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(buffer, StringBuilder.class, 338, 12622, 12627)) {
                        buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 338, 12622, 12627);
                        CallChecker.isCalled(buffer, StringBuilder.class, 338, 12622, 12627).append(separator);
                    }
                }
                if (CallChecker.beforeDeref(data, double[].class, 340, 12688, 12691)) {
                    if (CallChecker.beforeDeref(buffer, StringBuilder.class, 340, 12674, 12679)) {
                        data = CallChecker.beforeCalled(data, double[].class, 340, 12688, 12691);
                        buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 340, 12674, 12679);
                        CallChecker.isCalled(buffer, StringBuilder.class, 340, 12674, 12679).append(CallChecker.isCalled(data, double[].class, 340, 12688, 12691)[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 342, 12716, 12721)) {
                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 342, 12716, 12721);
                CallChecker.isCalled(buffer, StringBuilder.class, 342, 12716, 12721).append(suffix);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5331.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context5332 = new MethodContext(void.class, 348, 12750, 13167);
        try {
            CallChecker.varInit(this, "this", 348, 12750, 13167);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 348, 12750, 13167);
            CallChecker.varInit(this.meanImpl, "meanImpl", 348, 12750, 13167);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 348, 12750, 13167);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 348, 12750, 13167);
            CallChecker.varInit(this.maxImpl, "maxImpl", 348, 12750, 13167);
            CallChecker.varInit(this.minImpl, "minImpl", 348, 12750, 13167);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 348, 12750, 13167);
            CallChecker.varInit(this.sumImpl, "sumImpl", 348, 12750, 13167);
            CallChecker.varInit(this.n, "n", 348, 12750, 13167);
            CallChecker.varInit(this.k, "k", 348, 12750, 13167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 348, 12750, 13167);
            this.n = 0;
            CallChecker.varAssign(this.n, "this.n", 349, 12837, 12847);
            for (int i = 0; i < (k); ++i) {
                if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905)) {
                    minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905)[i], StorelessUnivariateStatistic.class, 351, 12899, 12908)) {
                        minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905);
                        CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905)[i] = CallChecker.beforeCalled(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905)[i], StorelessUnivariateStatistic.class, 351, 12899, 12908);
                        CallChecker.isCalled(CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 351, 12899, 12905)[i], StorelessUnivariateStatistic.class, 351, 12899, 12908).clear();
                    }
                }
                if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937)) {
                    maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937)[i], StorelessUnivariateStatistic.class, 352, 12931, 12940)) {
                        maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937);
                        CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937)[i] = CallChecker.beforeCalled(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937)[i], StorelessUnivariateStatistic.class, 352, 12931, 12940);
                        CallChecker.isCalled(CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 352, 12931, 12937)[i], StorelessUnivariateStatistic.class, 352, 12931, 12940).clear();
                    }
                }
                if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969)) {
                    sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969)[i], StorelessUnivariateStatistic.class, 353, 12963, 12972)) {
                        sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969);
                        CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969)[i], StorelessUnivariateStatistic.class, 353, 12963, 12972);
                        CallChecker.isCalled(CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 353, 12963, 12969)[i], StorelessUnivariateStatistic.class, 353, 12963, 12972).clear();
                    }
                }
                if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004)) {
                    sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004)[i], StorelessUnivariateStatistic.class, 354, 12995, 13007)) {
                        sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004);
                        CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004)[i], StorelessUnivariateStatistic.class, 354, 12995, 13007);
                        CallChecker.isCalled(CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 354, 12995, 13004)[i], StorelessUnivariateStatistic.class, 354, 12995, 13007).clear();
                    }
                }
                if (CallChecker.beforeDeref(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038)) {
                    sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038)[i], StorelessUnivariateStatistic.class, 355, 13030, 13041)) {
                        sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038);
                        CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038)[i], StorelessUnivariateStatistic.class, 355, 13030, 13041);
                        CallChecker.isCalled(CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 355, 13030, 13038)[i], StorelessUnivariateStatistic.class, 355, 13030, 13041).clear();
                    }
                }
                if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074)) {
                    geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074)[i], StorelessUnivariateStatistic.class, 356, 13064, 13077)) {
                        geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074);
                        CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074)[i] = CallChecker.beforeCalled(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074)[i], StorelessUnivariateStatistic.class, 356, 13064, 13077);
                        CallChecker.isCalled(CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 356, 13064, 13074)[i], StorelessUnivariateStatistic.class, 356, 13064, 13077).clear();
                    }
                }
                if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107)) {
                    meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107)[i], StorelessUnivariateStatistic.class, 357, 13100, 13110)) {
                        meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107);
                        CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107)[i] = CallChecker.beforeCalled(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107)[i], StorelessUnivariateStatistic.class, 357, 13100, 13110);
                        CallChecker.isCalled(CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 357, 13100, 13107)[i], StorelessUnivariateStatistic.class, 357, 13100, 13110).clear();
                    }
                }
            }
            if (CallChecker.beforeDeref(covarianceImpl, VectorialCovariance.class, 359, 13139, 13152)) {
                covarianceImpl = CallChecker.beforeCalled(covarianceImpl, VectorialCovariance.class, 359, 13139, 13152);
                CallChecker.isCalled(covarianceImpl, VectorialCovariance.class, 359, 13139, 13152).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5332.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context5333 = new MethodContext(boolean.class, 369, 13174, 14568);
        try {
            CallChecker.varInit(this, "this", 369, 13174, 14568);
            CallChecker.varInit(object, "object", 369, 13174, 14568);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 369, 13174, 14568);
            CallChecker.varInit(this.meanImpl, "meanImpl", 369, 13174, 14568);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 369, 13174, 14568);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 369, 13174, 14568);
            CallChecker.varInit(this.maxImpl, "maxImpl", 369, 13174, 14568);
            CallChecker.varInit(this.minImpl, "minImpl", 369, 13174, 14568);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 369, 13174, 14568);
            CallChecker.varInit(this.sumImpl, "sumImpl", 369, 13174, 14568);
            CallChecker.varInit(this.n, "n", 369, 13174, 14568);
            CallChecker.varInit(this.k, "k", 369, 13174, 14568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 369, 13174, 14568);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof MultivariateSummaryStatistics) == false) {
                return false;
            }
            MultivariateSummaryStatistics stat = CallChecker.varInit(((MultivariateSummaryStatistics) (object)), "stat", 376, 13682, 13757);
            if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 377, 13804, 13807)) {
                if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 378, 13897, 13900)) {
                    if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 379, 13990, 13993)) {
                        if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 380, 14083, 14086)) {
                            if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 381, 14175, 14178)) {
                                if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 382, 14268, 14271)) {
                                    if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 383, 14361, 14364)) {
                                        if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 384, 14454, 14457)) {
                                            if (CallChecker.beforeDeref(stat, MultivariateSummaryStatistics.class, 385, 14517, 14520)) {
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 377, 13804, 13807);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 378, 13897, 13900);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 379, 13990, 13993);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 380, 14083, 14086);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 381, 14175, 14178);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 382, 14268, 14271);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 383, 14361, 14364);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 384, 14454, 14457);
                                                stat = CallChecker.beforeCalled(stat, MultivariateSummaryStatistics.class, 385, 14517, 14520);
                                                return ((((((((MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 377, 13804, 13807).getGeometricMean(), getGeometricMean())) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 378, 13897, 13900).getMax(), getMax()))) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 379, 13990, 13993).getMean(), getMean()))) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 380, 14083, 14086).getMin(), getMin()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 381, 14175, 14178).getN(), getN()))) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 382, 14268, 14271).getSum(), getSum()))) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 383, 14361, 14364).getSumSq(), getSumSq()))) && (MathArrays.equalsIncludingNaN(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 384, 14454, 14457).getSumLog(), getSumLog()))) && (CallChecker.isCalled(CallChecker.isCalled(stat, MultivariateSummaryStatistics.class, 385, 14517, 14520).getCovariance(), RealMatrix.class, 385, 14517, 14536).equals(getCovariance()));
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
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5333.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5334 = new MethodContext(int.class, 394, 14575, 15334);
        try {
            CallChecker.varInit(this, "this", 394, 14575, 15334);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 394, 14575, 15334);
            CallChecker.varInit(this.meanImpl, "meanImpl", 394, 14575, 15334);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 394, 14575, 15334);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 394, 14575, 15334);
            CallChecker.varInit(this.maxImpl, "maxImpl", 394, 14575, 15334);
            CallChecker.varInit(this.minImpl, "minImpl", 394, 14575, 15334);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 394, 14575, 15334);
            CallChecker.varInit(this.sumImpl, "sumImpl", 394, 14575, 15334);
            CallChecker.varInit(this.n, "n", 394, 14575, 15334);
            CallChecker.varInit(this.k, "k", 394, 14575, 15334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 394, 14575, 15334);
            int result = CallChecker.varInit(((int) (31 + (MathUtils.hash(getGeometricMean())))), "result", 395, 14724, 14776);
            result = (result * 31) + (MathUtils.hash(getGeometricMean()));
            CallChecker.varAssign(result, "result", 396, 14786, 14843);
            result = (result * 31) + (MathUtils.hash(getMax()));
            CallChecker.varAssign(result, "result", 397, 14853, 14900);
            result = (result * 31) + (MathUtils.hash(getMean()));
            CallChecker.varAssign(result, "result", 398, 14910, 14958);
            result = (result * 31) + (MathUtils.hash(getMin()));
            CallChecker.varAssign(result, "result", 399, 14968, 15015);
            result = (result * 31) + (MathUtils.hash(getN()));
            CallChecker.varAssign(result, "result", 400, 15025, 15070);
            result = (result * 31) + (MathUtils.hash(getSum()));
            CallChecker.varAssign(result, "result", 401, 15080, 15127);
            result = (result * 31) + (MathUtils.hash(getSumSq()));
            CallChecker.varAssign(result, "result", 402, 15137, 15186);
            result = (result * 31) + (MathUtils.hash(getSumLog()));
            CallChecker.varAssign(result, "result", 403, 15196, 15246);
            final RealMatrix npe_invocation_var1001 = getCovariance();
            if (CallChecker.beforeDeref(npe_invocation_var1001, RealMatrix.class, 404, 15279, 15293)) {
                result = (result * 31) + (CallChecker.isCalled(npe_invocation_var1001, RealMatrix.class, 404, 15279, 15293).hashCode());
                CallChecker.varAssign(result, "result", 404, 15256, 15305);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5334.methodEnd();
        }
    }

    private void setImpl(StorelessUnivariateStatistic[] newImpl, StorelessUnivariateStatistic[] oldImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5335 = new MethodContext(void.class, 418, 15341, 16126);
        try {
            CallChecker.varInit(this, "this", 418, 15341, 16126);
            CallChecker.varInit(oldImpl, "oldImpl", 418, 15341, 16126);
            CallChecker.varInit(newImpl, "newImpl", 418, 15341, 16126);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 418, 15341, 16126);
            CallChecker.varInit(this.meanImpl, "meanImpl", 418, 15341, 16126);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 418, 15341, 16126);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 418, 15341, 16126);
            CallChecker.varInit(this.maxImpl, "maxImpl", 418, 15341, 16126);
            CallChecker.varInit(this.minImpl, "minImpl", 418, 15341, 16126);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 418, 15341, 16126);
            CallChecker.varInit(this.sumImpl, "sumImpl", 418, 15341, 16126);
            CallChecker.varInit(this.n, "n", 418, 15341, 16126);
            CallChecker.varInit(this.k, "k", 418, 15341, 16126);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 418, 15341, 16126);
            checkEmpty();
            if (CallChecker.beforeDeref(newImpl, StorelessUnivariateStatistic[].class, 422, 16039, 16045)) {
                newImpl = CallChecker.beforeCalled(newImpl, StorelessUnivariateStatistic[].class, 422, 16039, 16045);
                checkDimension(CallChecker.isCalled(newImpl, StorelessUnivariateStatistic[].class, 422, 16039, 16045).length);
            }
            if (CallChecker.beforeDeref(newImpl, StorelessUnivariateStatistic[].class, 423, 16105, 16111)) {
                newImpl = CallChecker.beforeCalled(newImpl, StorelessUnivariateStatistic[].class, 423, 16105, 16111);
                System.arraycopy(newImpl, 0, oldImpl, 0, CallChecker.isCalled(newImpl, StorelessUnivariateStatistic[].class, 423, 16105, 16111).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5335.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getSumImpl() {
        MethodContext _bcornu_methode_context5336 = new MethodContext(StorelessUnivariateStatistic[].class, 431, 16133, 16373);
        try {
            CallChecker.varInit(this, "this", 431, 16133, 16373);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 431, 16133, 16373);
            CallChecker.varInit(this.meanImpl, "meanImpl", 431, 16133, 16373);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 431, 16133, 16373);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 431, 16133, 16373);
            CallChecker.varInit(this.maxImpl, "maxImpl", 431, 16133, 16373);
            CallChecker.varInit(this.minImpl, "minImpl", 431, 16133, 16373);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 431, 16133, 16373);
            CallChecker.varInit(this.sumImpl, "sumImpl", 431, 16133, 16373);
            CallChecker.varInit(this.n, "n", 431, 16133, 16373);
            CallChecker.varInit(this.k, "k", 431, 16133, 16373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 431, 16133, 16373);
            if (CallChecker.beforeDeref(sumImpl, StorelessUnivariateStatistic[].class, 432, 16352, 16358)) {
                sumImpl = CallChecker.beforeCalled(sumImpl, StorelessUnivariateStatistic[].class, 432, 16352, 16358);
                return CallChecker.isCalled(sumImpl, StorelessUnivariateStatistic[].class, 432, 16352, 16358).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5336.methodEnd();
        }
    }

    public void setSumImpl(StorelessUnivariateStatistic[] sumImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5337 = new MethodContext(void.class, 448, 16380, 17158);
        try {
            CallChecker.varInit(this, "this", 448, 16380, 17158);
            CallChecker.varInit(sumImpl, "sumImpl", 448, 16380, 17158);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 448, 16380, 17158);
            CallChecker.varInit(this.meanImpl, "meanImpl", 448, 16380, 17158);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 448, 16380, 17158);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 448, 16380, 17158);
            CallChecker.varInit(this.maxImpl, "maxImpl", 448, 16380, 17158);
            CallChecker.varInit(this.minImpl, "minImpl", 448, 16380, 17158);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 448, 16380, 17158);
            CallChecker.varInit(this.sumImpl, "sumImpl", 448, 16380, 17158);
            CallChecker.varInit(this.n, "n", 448, 16380, 17158);
            CallChecker.varInit(this.k, "k", 448, 16380, 17158);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 448, 16380, 17158);
            setImpl(sumImpl, this.sumImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5337.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getSumsqImpl() {
        MethodContext _bcornu_methode_context5338 = new MethodContext(StorelessUnivariateStatistic[].class, 458, 17165, 17431);
        try {
            CallChecker.varInit(this, "this", 458, 17165, 17431);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 458, 17165, 17431);
            CallChecker.varInit(this.meanImpl, "meanImpl", 458, 17165, 17431);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 458, 17165, 17431);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 458, 17165, 17431);
            CallChecker.varInit(this.maxImpl, "maxImpl", 458, 17165, 17431);
            CallChecker.varInit(this.minImpl, "minImpl", 458, 17165, 17431);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 458, 17165, 17431);
            CallChecker.varInit(this.sumImpl, "sumImpl", 458, 17165, 17431);
            CallChecker.varInit(this.n, "n", 458, 17165, 17431);
            CallChecker.varInit(this.k, "k", 458, 17165, 17431);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 458, 17165, 17431);
            if (CallChecker.beforeDeref(sumSqImpl, StorelessUnivariateStatistic[].class, 459, 17408, 17416)) {
                sumSqImpl = CallChecker.beforeCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 459, 17408, 17416);
                return CallChecker.isCalled(sumSqImpl, StorelessUnivariateStatistic[].class, 459, 17408, 17416).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5338.methodEnd();
        }
    }

    public void setSumsqImpl(StorelessUnivariateStatistic[] sumsqImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5339 = new MethodContext(void.class, 475, 17438, 18248);
        try {
            CallChecker.varInit(this, "this", 475, 17438, 18248);
            CallChecker.varInit(sumsqImpl, "sumsqImpl", 475, 17438, 18248);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 475, 17438, 18248);
            CallChecker.varInit(this.meanImpl, "meanImpl", 475, 17438, 18248);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 475, 17438, 18248);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 475, 17438, 18248);
            CallChecker.varInit(this.maxImpl, "maxImpl", 475, 17438, 18248);
            CallChecker.varInit(this.minImpl, "minImpl", 475, 17438, 18248);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 475, 17438, 18248);
            CallChecker.varInit(this.sumImpl, "sumImpl", 475, 17438, 18248);
            CallChecker.varInit(this.n, "n", 475, 17438, 18248);
            CallChecker.varInit(this.k, "k", 475, 17438, 18248);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 475, 17438, 18248);
            setImpl(sumsqImpl, this.sumSqImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5339.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getMinImpl() {
        MethodContext _bcornu_methode_context5340 = new MethodContext(StorelessUnivariateStatistic[].class, 485, 18255, 18503);
        try {
            CallChecker.varInit(this, "this", 485, 18255, 18503);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 485, 18255, 18503);
            CallChecker.varInit(this.meanImpl, "meanImpl", 485, 18255, 18503);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 485, 18255, 18503);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 485, 18255, 18503);
            CallChecker.varInit(this.maxImpl, "maxImpl", 485, 18255, 18503);
            CallChecker.varInit(this.minImpl, "minImpl", 485, 18255, 18503);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 485, 18255, 18503);
            CallChecker.varInit(this.sumImpl, "sumImpl", 485, 18255, 18503);
            CallChecker.varInit(this.n, "n", 485, 18255, 18503);
            CallChecker.varInit(this.k, "k", 485, 18255, 18503);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 485, 18255, 18503);
            if (CallChecker.beforeDeref(minImpl, StorelessUnivariateStatistic[].class, 486, 18482, 18488)) {
                minImpl = CallChecker.beforeCalled(minImpl, StorelessUnivariateStatistic[].class, 486, 18482, 18488);
                return CallChecker.isCalled(minImpl, StorelessUnivariateStatistic[].class, 486, 18482, 18488).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5340.methodEnd();
        }
    }

    public void setMinImpl(StorelessUnivariateStatistic[] minImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5341 = new MethodContext(void.class, 502, 18510, 19296);
        try {
            CallChecker.varInit(this, "this", 502, 18510, 19296);
            CallChecker.varInit(minImpl, "minImpl", 502, 18510, 19296);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 502, 18510, 19296);
            CallChecker.varInit(this.meanImpl, "meanImpl", 502, 18510, 19296);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 502, 18510, 19296);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 502, 18510, 19296);
            CallChecker.varInit(this.maxImpl, "maxImpl", 502, 18510, 19296);
            CallChecker.varInit(this.minImpl, "minImpl", 502, 18510, 19296);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 502, 18510, 19296);
            CallChecker.varInit(this.sumImpl, "sumImpl", 502, 18510, 19296);
            CallChecker.varInit(this.n, "n", 502, 18510, 19296);
            CallChecker.varInit(this.k, "k", 502, 18510, 19296);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 502, 18510, 19296);
            setImpl(minImpl, this.minImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5341.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getMaxImpl() {
        MethodContext _bcornu_methode_context5342 = new MethodContext(StorelessUnivariateStatistic[].class, 512, 19303, 19551);
        try {
            CallChecker.varInit(this, "this", 512, 19303, 19551);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 512, 19303, 19551);
            CallChecker.varInit(this.meanImpl, "meanImpl", 512, 19303, 19551);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 512, 19303, 19551);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 512, 19303, 19551);
            CallChecker.varInit(this.maxImpl, "maxImpl", 512, 19303, 19551);
            CallChecker.varInit(this.minImpl, "minImpl", 512, 19303, 19551);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 512, 19303, 19551);
            CallChecker.varInit(this.sumImpl, "sumImpl", 512, 19303, 19551);
            CallChecker.varInit(this.n, "n", 512, 19303, 19551);
            CallChecker.varInit(this.k, "k", 512, 19303, 19551);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 512, 19303, 19551);
            if (CallChecker.beforeDeref(maxImpl, StorelessUnivariateStatistic[].class, 513, 19530, 19536)) {
                maxImpl = CallChecker.beforeCalled(maxImpl, StorelessUnivariateStatistic[].class, 513, 19530, 19536);
                return CallChecker.isCalled(maxImpl, StorelessUnivariateStatistic[].class, 513, 19530, 19536).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5342.methodEnd();
        }
    }

    public void setMaxImpl(StorelessUnivariateStatistic[] maxImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5343 = new MethodContext(void.class, 529, 19558, 20343);
        try {
            CallChecker.varInit(this, "this", 529, 19558, 20343);
            CallChecker.varInit(maxImpl, "maxImpl", 529, 19558, 20343);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 529, 19558, 20343);
            CallChecker.varInit(this.meanImpl, "meanImpl", 529, 19558, 20343);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 529, 19558, 20343);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 529, 19558, 20343);
            CallChecker.varInit(this.maxImpl, "maxImpl", 529, 19558, 20343);
            CallChecker.varInit(this.minImpl, "minImpl", 529, 19558, 20343);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 529, 19558, 20343);
            CallChecker.varInit(this.sumImpl, "sumImpl", 529, 19558, 20343);
            CallChecker.varInit(this.n, "n", 529, 19558, 20343);
            CallChecker.varInit(this.k, "k", 529, 19558, 20343);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 529, 19558, 20343);
            setImpl(maxImpl, this.maxImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5343.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getSumLogImpl() {
        MethodContext _bcornu_methode_context5344 = new MethodContext(StorelessUnivariateStatistic[].class, 539, 20350, 20608);
        try {
            CallChecker.varInit(this, "this", 539, 20350, 20608);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 539, 20350, 20608);
            CallChecker.varInit(this.meanImpl, "meanImpl", 539, 20350, 20608);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 539, 20350, 20608);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 539, 20350, 20608);
            CallChecker.varInit(this.maxImpl, "maxImpl", 539, 20350, 20608);
            CallChecker.varInit(this.minImpl, "minImpl", 539, 20350, 20608);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 539, 20350, 20608);
            CallChecker.varInit(this.sumImpl, "sumImpl", 539, 20350, 20608);
            CallChecker.varInit(this.n, "n", 539, 20350, 20608);
            CallChecker.varInit(this.k, "k", 539, 20350, 20608);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 539, 20350, 20608);
            if (CallChecker.beforeDeref(sumLogImpl, StorelessUnivariateStatistic[].class, 540, 20584, 20593)) {
                sumLogImpl = CallChecker.beforeCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 540, 20584, 20593);
                return CallChecker.isCalled(sumLogImpl, StorelessUnivariateStatistic[].class, 540, 20584, 20593).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5344.methodEnd();
        }
    }

    public void setSumLogImpl(StorelessUnivariateStatistic[] sumLogImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5345 = new MethodContext(void.class, 556, 20615, 21419);
        try {
            CallChecker.varInit(this, "this", 556, 20615, 21419);
            CallChecker.varInit(sumLogImpl, "sumLogImpl", 556, 20615, 21419);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 556, 20615, 21419);
            CallChecker.varInit(this.meanImpl, "meanImpl", 556, 20615, 21419);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 556, 20615, 21419);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 556, 20615, 21419);
            CallChecker.varInit(this.maxImpl, "maxImpl", 556, 20615, 21419);
            CallChecker.varInit(this.minImpl, "minImpl", 556, 20615, 21419);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 556, 20615, 21419);
            CallChecker.varInit(this.sumImpl, "sumImpl", 556, 20615, 21419);
            CallChecker.varInit(this.n, "n", 556, 20615, 21419);
            CallChecker.varInit(this.k, "k", 556, 20615, 21419);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 556, 20615, 21419);
            setImpl(sumLogImpl, this.sumLogImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5345.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getGeoMeanImpl() {
        MethodContext _bcornu_methode_context5346 = new MethodContext(StorelessUnivariateStatistic[].class, 566, 21426, 21696);
        try {
            CallChecker.varInit(this, "this", 566, 21426, 21696);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 566, 21426, 21696);
            CallChecker.varInit(this.meanImpl, "meanImpl", 566, 21426, 21696);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 566, 21426, 21696);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 566, 21426, 21696);
            CallChecker.varInit(this.maxImpl, "maxImpl", 566, 21426, 21696);
            CallChecker.varInit(this.minImpl, "minImpl", 566, 21426, 21696);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 566, 21426, 21696);
            CallChecker.varInit(this.sumImpl, "sumImpl", 566, 21426, 21696);
            CallChecker.varInit(this.n, "n", 566, 21426, 21696);
            CallChecker.varInit(this.k, "k", 566, 21426, 21696);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 566, 21426, 21696);
            if (CallChecker.beforeDeref(geoMeanImpl, StorelessUnivariateStatistic[].class, 567, 21671, 21681)) {
                geoMeanImpl = CallChecker.beforeCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 567, 21671, 21681);
                return CallChecker.isCalled(geoMeanImpl, StorelessUnivariateStatistic[].class, 567, 21671, 21681).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5346.methodEnd();
        }
    }

    public void setGeoMeanImpl(StorelessUnivariateStatistic[] geoMeanImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5347 = new MethodContext(void.class, 583, 21703, 22523);
        try {
            CallChecker.varInit(this, "this", 583, 21703, 22523);
            CallChecker.varInit(geoMeanImpl, "geoMeanImpl", 583, 21703, 22523);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 583, 21703, 22523);
            CallChecker.varInit(this.meanImpl, "meanImpl", 583, 21703, 22523);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 583, 21703, 22523);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 583, 21703, 22523);
            CallChecker.varInit(this.maxImpl, "maxImpl", 583, 21703, 22523);
            CallChecker.varInit(this.minImpl, "minImpl", 583, 21703, 22523);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 583, 21703, 22523);
            CallChecker.varInit(this.sumImpl, "sumImpl", 583, 21703, 22523);
            CallChecker.varInit(this.n, "n", 583, 21703, 22523);
            CallChecker.varInit(this.k, "k", 583, 21703, 22523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 583, 21703, 22523);
            setImpl(geoMeanImpl, this.geoMeanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5347.methodEnd();
        }
    }

    public StorelessUnivariateStatistic[] getMeanImpl() {
        MethodContext _bcornu_methode_context5348 = new MethodContext(StorelessUnivariateStatistic[].class, 593, 22530, 22774);
        try {
            CallChecker.varInit(this, "this", 593, 22530, 22774);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 593, 22530, 22774);
            CallChecker.varInit(this.meanImpl, "meanImpl", 593, 22530, 22774);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 593, 22530, 22774);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 593, 22530, 22774);
            CallChecker.varInit(this.maxImpl, "maxImpl", 593, 22530, 22774);
            CallChecker.varInit(this.minImpl, "minImpl", 593, 22530, 22774);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 593, 22530, 22774);
            CallChecker.varInit(this.sumImpl, "sumImpl", 593, 22530, 22774);
            CallChecker.varInit(this.n, "n", 593, 22530, 22774);
            CallChecker.varInit(this.k, "k", 593, 22530, 22774);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 593, 22530, 22774);
            if (CallChecker.beforeDeref(meanImpl, StorelessUnivariateStatistic[].class, 594, 22752, 22759)) {
                meanImpl = CallChecker.beforeCalled(meanImpl, StorelessUnivariateStatistic[].class, 594, 22752, 22759);
                return CallChecker.isCalled(meanImpl, StorelessUnivariateStatistic[].class, 594, 22752, 22759).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5348.methodEnd();
        }
    }

    public void setMeanImpl(StorelessUnivariateStatistic[] meanImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context5349 = new MethodContext(void.class, 610, 22781, 23565);
        try {
            CallChecker.varInit(this, "this", 610, 22781, 23565);
            CallChecker.varInit(meanImpl, "meanImpl", 610, 22781, 23565);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 610, 22781, 23565);
            CallChecker.varInit(this.meanImpl, "meanImpl", 610, 22781, 23565);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 610, 22781, 23565);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 610, 22781, 23565);
            CallChecker.varInit(this.maxImpl, "maxImpl", 610, 22781, 23565);
            CallChecker.varInit(this.minImpl, "minImpl", 610, 22781, 23565);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 610, 22781, 23565);
            CallChecker.varInit(this.sumImpl, "sumImpl", 610, 22781, 23565);
            CallChecker.varInit(this.n, "n", 610, 22781, 23565);
            CallChecker.varInit(this.k, "k", 610, 22781, 23565);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 610, 22781, 23565);
            setImpl(meanImpl, this.meanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5349.methodEnd();
        }
    }

    private void checkEmpty() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context5350 = new MethodContext(void.class, 619, 23572, 23939);
        try {
            CallChecker.varInit(this, "this", 619, 23572, 23939);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 619, 23572, 23939);
            CallChecker.varInit(this.meanImpl, "meanImpl", 619, 23572, 23939);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 619, 23572, 23939);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 619, 23572, 23939);
            CallChecker.varInit(this.maxImpl, "maxImpl", 619, 23572, 23939);
            CallChecker.varInit(this.minImpl, "minImpl", 619, 23572, 23939);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 619, 23572, 23939);
            CallChecker.varInit(this.sumImpl, "sumImpl", 619, 23572, 23939);
            CallChecker.varInit(this.n, "n", 619, 23572, 23939);
            CallChecker.varInit(this.k, "k", 619, 23572, 23939);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 619, 23572, 23939);
            if ((n) > 0) {
                throw new MathIllegalStateException(LocalizedFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC, n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5350.methodEnd();
        }
    }

    private void checkDimension(int dimension) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5351 = new MethodContext(void.class, 631, 23946, 24312);
        try {
            CallChecker.varInit(this, "this", 631, 23946, 24312);
            CallChecker.varInit(dimension, "dimension", 631, 23946, 24312);
            CallChecker.varInit(this.covarianceImpl, "covarianceImpl", 631, 23946, 24312);
            CallChecker.varInit(this.meanImpl, "meanImpl", 631, 23946, 24312);
            CallChecker.varInit(this.geoMeanImpl, "geoMeanImpl", 631, 23946, 24312);
            CallChecker.varInit(this.sumLogImpl, "sumLogImpl", 631, 23946, 24312);
            CallChecker.varInit(this.maxImpl, "maxImpl", 631, 23946, 24312);
            CallChecker.varInit(this.minImpl, "minImpl", 631, 23946, 24312);
            CallChecker.varInit(this.sumSqImpl, "sumSqImpl", 631, 23946, 24312);
            CallChecker.varInit(this.sumImpl, "sumImpl", 631, 23946, 24312);
            CallChecker.varInit(this.n, "n", 631, 23946, 24312);
            CallChecker.varInit(this.k, "k", 631, 23946, 24312);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.MultivariateSummaryStatistics.serialVersionUID", 631, 23946, 24312);
            if (dimension != (k)) {
                throw new DimensionMismatchException(dimension, k);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5351.methodEnd();
        }
    }
}

