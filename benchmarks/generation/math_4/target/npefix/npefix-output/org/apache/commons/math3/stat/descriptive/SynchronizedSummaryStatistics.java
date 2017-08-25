package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

public class SynchronizedSummaryStatistics extends SummaryStatistics {
    private static final long serialVersionUID = 1909861009042253704L;

    public SynchronizedSummaryStatistics() {
        super();
        ConstructorContext _bcornu_methode_context218 = new ConstructorContext(SynchronizedSummaryStatistics.class, 44, 1793, 1929);
        try {
        } finally {
            _bcornu_methode_context218.methodEnd();
        }
    }

    public SynchronizedSummaryStatistics(SynchronizedSummaryStatistics original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context219 = new ConstructorContext(SynchronizedSummaryStatistics.class, 54, 1936, 2316);
        try {
            SynchronizedSummaryStatistics.copy(original, this);
        } finally {
            _bcornu_methode_context219.methodEnd();
        }
    }

    @Override
    public synchronized StatisticalSummary getSummary() {
        MethodContext _bcornu_methode_context854 = new MethodContext(StatisticalSummary.class, 63, 2323, 2467);
        try {
            CallChecker.varInit(this, "this", 63, 2323, 2467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 63, 2323, 2467);
            return super.getSummary();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatisticalSummary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context854.methodEnd();
        }
    }

    @Override
    public synchronized void addValue(double value) {
        MethodContext _bcornu_methode_context855 = new MethodContext(void.class, 71, 2474, 2610);
        try {
            CallChecker.varInit(this, "this", 71, 2474, 2610);
            CallChecker.varInit(value, "value", 71, 2474, 2610);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 71, 2474, 2610);
            super.addValue(value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context855.methodEnd();
        }
    }

    @Override
    public synchronized long getN() {
        MethodContext _bcornu_methode_context856 = new MethodContext(long.class, 79, 2617, 2735);
        try {
            CallChecker.varInit(this, "this", 79, 2617, 2735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 79, 2617, 2735);
            return super.getN();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context856.methodEnd();
        }
    }

    @Override
    public synchronized double getSum() {
        MethodContext _bcornu_methode_context857 = new MethodContext(double.class, 87, 2742, 2866);
        try {
            CallChecker.varInit(this, "this", 87, 2742, 2866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 87, 2742, 2866);
            return super.getSum();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context857.methodEnd();
        }
    }

    @Override
    public synchronized double getSumsq() {
        MethodContext _bcornu_methode_context858 = new MethodContext(double.class, 95, 2873, 3001);
        try {
            CallChecker.varInit(this, "this", 95, 2873, 3001);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 95, 2873, 3001);
            return super.getSumsq();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context858.methodEnd();
        }
    }

    @Override
    public synchronized double getMean() {
        MethodContext _bcornu_methode_context859 = new MethodContext(double.class, 103, 3008, 3134);
        try {
            CallChecker.varInit(this, "this", 103, 3008, 3134);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 103, 3008, 3134);
            return super.getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context859.methodEnd();
        }
    }

    @Override
    public synchronized double getStandardDeviation() {
        MethodContext _bcornu_methode_context860 = new MethodContext(double.class, 111, 3141, 3293);
        try {
            CallChecker.varInit(this, "this", 111, 3141, 3293);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 111, 3141, 3293);
            return super.getStandardDeviation();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context860.methodEnd();
        }
    }

    @Override
    public synchronized double getVariance() {
        MethodContext _bcornu_methode_context861 = new MethodContext(double.class, 119, 3300, 3434);
        try {
            CallChecker.varInit(this, "this", 119, 3300, 3434);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 119, 3300, 3434);
            return super.getVariance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context861.methodEnd();
        }
    }

    @Override
    public synchronized double getPopulationVariance() {
        MethodContext _bcornu_methode_context862 = new MethodContext(double.class, 127, 3441, 3595);
        try {
            CallChecker.varInit(this, "this", 127, 3441, 3595);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 127, 3441, 3595);
            return super.getPopulationVariance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context862.methodEnd();
        }
    }

    @Override
    public synchronized double getMax() {
        MethodContext _bcornu_methode_context863 = new MethodContext(double.class, 135, 3602, 3726);
        try {
            CallChecker.varInit(this, "this", 135, 3602, 3726);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 135, 3602, 3726);
            return super.getMax();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context863.methodEnd();
        }
    }

    @Override
    public synchronized double getMin() {
        MethodContext _bcornu_methode_context864 = new MethodContext(double.class, 143, 3733, 3857);
        try {
            CallChecker.varInit(this, "this", 143, 3733, 3857);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 143, 3733, 3857);
            return super.getMin();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context864.methodEnd();
        }
    }

    @Override
    public synchronized double getGeometricMean() {
        MethodContext _bcornu_methode_context865 = new MethodContext(double.class, 151, 3864, 4008);
        try {
            CallChecker.varInit(this, "this", 151, 3864, 4008);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 151, 3864, 4008);
            return super.getGeometricMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context865.methodEnd();
        }
    }

    @Override
    public synchronized String toString() {
        MethodContext _bcornu_methode_context866 = new MethodContext(String.class, 159, 4015, 4143);
        try {
            CallChecker.varInit(this, "this", 159, 4015, 4143);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 159, 4015, 4143);
            return super.toString();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context866.methodEnd();
        }
    }

    @Override
    public synchronized void clear() {
        MethodContext _bcornu_methode_context867 = new MethodContext(void.class, 167, 4150, 4263);
        try {
            CallChecker.varInit(this, "this", 167, 4150, 4263);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 167, 4150, 4263);
            super.clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context867.methodEnd();
        }
    }

    @Override
    public synchronized boolean equals(Object object) {
        MethodContext _bcornu_methode_context868 = new MethodContext(boolean.class, 175, 4270, 4414);
        try {
            CallChecker.varInit(this, "this", 175, 4270, 4414);
            CallChecker.varInit(object, "object", 175, 4270, 4414);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 175, 4270, 4414);
            return super.equals(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context868.methodEnd();
        }
    }

    @Override
    public synchronized int hashCode() {
        MethodContext _bcornu_methode_context869 = new MethodContext(int.class, 183, 4421, 4546);
        try {
            CallChecker.varInit(this, "this", 183, 4421, 4546);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 183, 4421, 4546);
            return super.hashCode();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context869.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getSumImpl() {
        MethodContext _bcornu_methode_context870 = new MethodContext(StorelessUnivariateStatistic.class, 191, 4553, 4707);
        try {
            CallChecker.varInit(this, "this", 191, 4553, 4707);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 191, 4553, 4707);
            return super.getSumImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context870.methodEnd();
        }
    }

    @Override
    public synchronized void setSumImpl(StorelessUnivariateStatistic sumImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context871 = new MethodContext(void.class, 199, 4714, 4917);
        try {
            CallChecker.varInit(this, "this", 199, 4714, 4917);
            CallChecker.varInit(sumImpl, "sumImpl", 199, 4714, 4917);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 199, 4714, 4917);
            super.setSumImpl(sumImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context871.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getSumsqImpl() {
        MethodContext _bcornu_methode_context872 = new MethodContext(StorelessUnivariateStatistic.class, 208, 4924, 5082);
        try {
            CallChecker.varInit(this, "this", 208, 4924, 5082);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 208, 4924, 5082);
            return super.getSumsqImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context872.methodEnd();
        }
    }

    @Override
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic sumsqImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context873 = new MethodContext(void.class, 216, 5089, 5300);
        try {
            CallChecker.varInit(this, "this", 216, 5089, 5300);
            CallChecker.varInit(sumsqImpl, "sumsqImpl", 216, 5089, 5300);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 216, 5089, 5300);
            super.setSumsqImpl(sumsqImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context873.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getMinImpl() {
        MethodContext _bcornu_methode_context874 = new MethodContext(StorelessUnivariateStatistic.class, 225, 5307, 5461);
        try {
            CallChecker.varInit(this, "this", 225, 5307, 5461);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 225, 5307, 5461);
            return super.getMinImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context874.methodEnd();
        }
    }

    @Override
    public synchronized void setMinImpl(StorelessUnivariateStatistic minImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context875 = new MethodContext(void.class, 233, 5468, 5671);
        try {
            CallChecker.varInit(this, "this", 233, 5468, 5671);
            CallChecker.varInit(minImpl, "minImpl", 233, 5468, 5671);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 233, 5468, 5671);
            super.setMinImpl(minImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context875.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getMaxImpl() {
        MethodContext _bcornu_methode_context876 = new MethodContext(StorelessUnivariateStatistic.class, 242, 5678, 5832);
        try {
            CallChecker.varInit(this, "this", 242, 5678, 5832);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 242, 5678, 5832);
            return super.getMaxImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context876.methodEnd();
        }
    }

    @Override
    public synchronized void setMaxImpl(StorelessUnivariateStatistic maxImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context877 = new MethodContext(void.class, 250, 5839, 6042);
        try {
            CallChecker.varInit(this, "this", 250, 5839, 6042);
            CallChecker.varInit(maxImpl, "maxImpl", 250, 5839, 6042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 250, 5839, 6042);
            super.setMaxImpl(maxImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context877.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getSumLogImpl() {
        MethodContext _bcornu_methode_context878 = new MethodContext(StorelessUnivariateStatistic.class, 259, 6049, 6209);
        try {
            CallChecker.varInit(this, "this", 259, 6049, 6209);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 259, 6049, 6209);
            return super.getSumLogImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context878.methodEnd();
        }
    }

    @Override
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic sumLogImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context879 = new MethodContext(void.class, 267, 6216, 6431);
        try {
            CallChecker.varInit(this, "this", 267, 6216, 6431);
            CallChecker.varInit(sumLogImpl, "sumLogImpl", 267, 6216, 6431);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 267, 6216, 6431);
            super.setSumLogImpl(sumLogImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context879.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getGeoMeanImpl() {
        MethodContext _bcornu_methode_context880 = new MethodContext(StorelessUnivariateStatistic.class, 276, 6438, 6600);
        try {
            CallChecker.varInit(this, "this", 276, 6438, 6600);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 276, 6438, 6600);
            return super.getGeoMeanImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context880.methodEnd();
        }
    }

    @Override
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic geoMeanImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context881 = new MethodContext(void.class, 284, 6607, 6826);
        try {
            CallChecker.varInit(this, "this", 284, 6607, 6826);
            CallChecker.varInit(geoMeanImpl, "geoMeanImpl", 284, 6607, 6826);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 284, 6607, 6826);
            super.setGeoMeanImpl(geoMeanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context881.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getMeanImpl() {
        MethodContext _bcornu_methode_context882 = new MethodContext(StorelessUnivariateStatistic.class, 293, 6833, 6989);
        try {
            CallChecker.varInit(this, "this", 293, 6833, 6989);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 293, 6833, 6989);
            return super.getMeanImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context882.methodEnd();
        }
    }

    @Override
    public synchronized void setMeanImpl(StorelessUnivariateStatistic meanImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context883 = new MethodContext(void.class, 301, 6996, 7203);
        try {
            CallChecker.varInit(this, "this", 301, 6996, 7203);
            CallChecker.varInit(meanImpl, "meanImpl", 301, 6996, 7203);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 301, 6996, 7203);
            super.setMeanImpl(meanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context883.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic getVarianceImpl() {
        MethodContext _bcornu_methode_context884 = new MethodContext(StorelessUnivariateStatistic.class, 310, 7210, 7374);
        try {
            CallChecker.varInit(this, "this", 310, 7210, 7374);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 310, 7210, 7374);
            return super.getVarianceImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context884.methodEnd();
        }
    }

    @Override
    public synchronized void setVarianceImpl(StorelessUnivariateStatistic varianceImpl) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context885 = new MethodContext(void.class, 318, 7381, 7604);
        try {
            CallChecker.varInit(this, "this", 318, 7381, 7604);
            CallChecker.varInit(varianceImpl, "varianceImpl", 318, 7381, 7604);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 318, 7381, 7604);
            super.setVarianceImpl(varianceImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context885.methodEnd();
        }
    }

    @Override
    public synchronized SynchronizedSummaryStatistics copy() {
        MethodContext _bcornu_methode_context886 = new MethodContext(SynchronizedSummaryStatistics.class, 330, 7611, 8084);
        try {
            CallChecker.varInit(this, "this", 330, 7611, 8084);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 330, 7611, 8084);
            SynchronizedSummaryStatistics result = CallChecker.varInit(new SynchronizedSummaryStatistics(), "result", 331, 7851, 7937);
            SynchronizedSummaryStatistics.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SynchronizedSummaryStatistics) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context886.methodEnd();
        }
    }

    public static void copy(SynchronizedSummaryStatistics source, SynchronizedSummaryStatistics dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context887 = new MethodContext(void.class, 347, 8091, 8856);
        try {
            CallChecker.varInit(dest, "dest", 347, 8091, 8856);
            CallChecker.varInit(source, "source", 347, 8091, 8856);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedSummaryStatistics.serialVersionUID", 347, 8091, 8856);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            synchronized(source) {
                synchronized(dest) {
                    SummaryStatistics.copy(source, dest);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context887.methodEnd();
        }
    }
}

