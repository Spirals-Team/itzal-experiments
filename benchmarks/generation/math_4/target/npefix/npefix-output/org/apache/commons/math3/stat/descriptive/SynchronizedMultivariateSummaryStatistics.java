package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.linear.RealMatrix;

public class SynchronizedMultivariateSummaryStatistics extends MultivariateSummaryStatistics {
    private static final long serialVersionUID = 7099834153347155363L;

    public SynchronizedMultivariateSummaryStatistics(int k, boolean isCovarianceBiasCorrected) {
        super(k, isCovarianceBiasCorrected);
        ConstructorContext _bcornu_methode_context803 = new ConstructorContext(SynchronizedMultivariateSummaryStatistics.class, 48, 1838, 2266);
        try {
        } finally {
            _bcornu_methode_context803.methodEnd();
        }
    }

    @Override
    public synchronized void addValue(double[] value) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3529 = new MethodContext(void.class, 56, 2273, 2443);
        try {
            CallChecker.varInit(this, "this", 56, 2273, 2443);
            CallChecker.varInit(value, "value", 56, 2273, 2443);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 56, 2273, 2443);
            super.addValue(value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3529.methodEnd();
        }
    }

    @Override
    public synchronized int getDimension() {
        MethodContext _bcornu_methode_context3530 = new MethodContext(int.class, 64, 2450, 2583);
        try {
            CallChecker.varInit(this, "this", 64, 2450, 2583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 64, 2450, 2583);
            return super.getDimension();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3530.methodEnd();
        }
    }

    @Override
    public synchronized long getN() {
        MethodContext _bcornu_methode_context3531 = new MethodContext(long.class, 72, 2590, 2708);
        try {
            CallChecker.varInit(this, "this", 72, 2590, 2708);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 72, 2590, 2708);
            return super.getN();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3531.methodEnd();
        }
    }

    @Override
    public synchronized double[] getSum() {
        MethodContext _bcornu_methode_context3532 = new MethodContext(double[].class, 80, 2715, 2841);
        try {
            CallChecker.varInit(this, "this", 80, 2715, 2841);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 80, 2715, 2841);
            return super.getSum();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3532.methodEnd();
        }
    }

    @Override
    public synchronized double[] getSumSq() {
        MethodContext _bcornu_methode_context3533 = new MethodContext(double[].class, 88, 2848, 2978);
        try {
            CallChecker.varInit(this, "this", 88, 2848, 2978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 88, 2848, 2978);
            return super.getSumSq();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3533.methodEnd();
        }
    }

    @Override
    public synchronized double[] getSumLog() {
        MethodContext _bcornu_methode_context3534 = new MethodContext(double[].class, 96, 2985, 3117);
        try {
            CallChecker.varInit(this, "this", 96, 2985, 3117);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 96, 2985, 3117);
            return super.getSumLog();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3534.methodEnd();
        }
    }

    @Override
    public synchronized double[] getMean() {
        MethodContext _bcornu_methode_context3535 = new MethodContext(double[].class, 104, 3124, 3252);
        try {
            CallChecker.varInit(this, "this", 104, 3124, 3252);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 104, 3124, 3252);
            return super.getMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3535.methodEnd();
        }
    }

    @Override
    public synchronized double[] getStandardDeviation() {
        MethodContext _bcornu_methode_context3536 = new MethodContext(double[].class, 112, 3259, 3413);
        try {
            CallChecker.varInit(this, "this", 112, 3259, 3413);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 112, 3259, 3413);
            return super.getStandardDeviation();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3536.methodEnd();
        }
    }

    @Override
    public synchronized RealMatrix getCovariance() {
        MethodContext _bcornu_methode_context3537 = new MethodContext(RealMatrix.class, 120, 3420, 3562);
        try {
            CallChecker.varInit(this, "this", 120, 3420, 3562);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 120, 3420, 3562);
            return super.getCovariance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3537.methodEnd();
        }
    }

    @Override
    public synchronized double[] getMax() {
        MethodContext _bcornu_methode_context3538 = new MethodContext(double[].class, 128, 3569, 3695);
        try {
            CallChecker.varInit(this, "this", 128, 3569, 3695);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 128, 3569, 3695);
            return super.getMax();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3538.methodEnd();
        }
    }

    @Override
    public synchronized double[] getMin() {
        MethodContext _bcornu_methode_context3539 = new MethodContext(double[].class, 136, 3702, 3828);
        try {
            CallChecker.varInit(this, "this", 136, 3702, 3828);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 136, 3702, 3828);
            return super.getMin();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3539.methodEnd();
        }
    }

    @Override
    public synchronized double[] getGeometricMean() {
        MethodContext _bcornu_methode_context3540 = new MethodContext(double[].class, 144, 3835, 3981);
        try {
            CallChecker.varInit(this, "this", 144, 3835, 3981);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 144, 3835, 3981);
            return super.getGeometricMean();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3540.methodEnd();
        }
    }

    @Override
    public synchronized String toString() {
        MethodContext _bcornu_methode_context3541 = new MethodContext(String.class, 152, 3988, 4116);
        try {
            CallChecker.varInit(this, "this", 152, 3988, 4116);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 152, 3988, 4116);
            return super.toString();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3541.methodEnd();
        }
    }

    @Override
    public synchronized void clear() {
        MethodContext _bcornu_methode_context3542 = new MethodContext(void.class, 160, 4123, 4236);
        try {
            CallChecker.varInit(this, "this", 160, 4123, 4236);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 160, 4123, 4236);
            super.clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3542.methodEnd();
        }
    }

    @Override
    public synchronized boolean equals(Object object) {
        MethodContext _bcornu_methode_context3543 = new MethodContext(boolean.class, 168, 4243, 4387);
        try {
            CallChecker.varInit(this, "this", 168, 4243, 4387);
            CallChecker.varInit(object, "object", 168, 4243, 4387);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 168, 4243, 4387);
            return super.equals(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3543.methodEnd();
        }
    }

    @Override
    public synchronized int hashCode() {
        MethodContext _bcornu_methode_context3544 = new MethodContext(int.class, 176, 4394, 4519);
        try {
            CallChecker.varInit(this, "this", 176, 4394, 4519);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 176, 4394, 4519);
            return super.hashCode();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3544.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getSumImpl() {
        MethodContext _bcornu_methode_context3545 = new MethodContext(StorelessUnivariateStatistic[].class, 184, 4526, 4682);
        try {
            CallChecker.varInit(this, "this", 184, 4526, 4682);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 184, 4526, 4682);
            return super.getSumImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3545.methodEnd();
        }
    }

    @Override
    public synchronized void setSumImpl(StorelessUnivariateStatistic[] sumImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3546 = new MethodContext(void.class, 192, 4689, 4922);
        try {
            CallChecker.varInit(this, "this", 192, 4689, 4922);
            CallChecker.varInit(sumImpl, "sumImpl", 192, 4689, 4922);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 192, 4689, 4922);
            super.setSumImpl(sumImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3546.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getSumsqImpl() {
        MethodContext _bcornu_methode_context3547 = new MethodContext(StorelessUnivariateStatistic[].class, 201, 4929, 5089);
        try {
            CallChecker.varInit(this, "this", 201, 4929, 5089);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 201, 4929, 5089);
            return super.getSumsqImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3547.methodEnd();
        }
    }

    @Override
    public synchronized void setSumsqImpl(StorelessUnivariateStatistic[] sumsqImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3548 = new MethodContext(void.class, 209, 5096, 5337);
        try {
            CallChecker.varInit(this, "this", 209, 5096, 5337);
            CallChecker.varInit(sumsqImpl, "sumsqImpl", 209, 5096, 5337);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 209, 5096, 5337);
            super.setSumsqImpl(sumsqImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3548.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getMinImpl() {
        MethodContext _bcornu_methode_context3549 = new MethodContext(StorelessUnivariateStatistic[].class, 218, 5344, 5500);
        try {
            CallChecker.varInit(this, "this", 218, 5344, 5500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 218, 5344, 5500);
            return super.getMinImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3549.methodEnd();
        }
    }

    @Override
    public synchronized void setMinImpl(StorelessUnivariateStatistic[] minImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3550 = new MethodContext(void.class, 226, 5507, 5740);
        try {
            CallChecker.varInit(this, "this", 226, 5507, 5740);
            CallChecker.varInit(minImpl, "minImpl", 226, 5507, 5740);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 226, 5507, 5740);
            super.setMinImpl(minImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3550.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getMaxImpl() {
        MethodContext _bcornu_methode_context3551 = new MethodContext(StorelessUnivariateStatistic[].class, 235, 5747, 5903);
        try {
            CallChecker.varInit(this, "this", 235, 5747, 5903);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 235, 5747, 5903);
            return super.getMaxImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3551.methodEnd();
        }
    }

    @Override
    public synchronized void setMaxImpl(StorelessUnivariateStatistic[] maxImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3552 = new MethodContext(void.class, 243, 5910, 6142);
        try {
            CallChecker.varInit(this, "this", 243, 5910, 6142);
            CallChecker.varInit(maxImpl, "maxImpl", 243, 5910, 6142);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 243, 5910, 6142);
            super.setMaxImpl(maxImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3552.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getSumLogImpl() {
        MethodContext _bcornu_methode_context3553 = new MethodContext(StorelessUnivariateStatistic[].class, 252, 6149, 6311);
        try {
            CallChecker.varInit(this, "this", 252, 6149, 6311);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 252, 6149, 6311);
            return super.getSumLogImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3553.methodEnd();
        }
    }

    @Override
    public synchronized void setSumLogImpl(StorelessUnivariateStatistic[] sumLogImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3554 = new MethodContext(void.class, 260, 6318, 6563);
        try {
            CallChecker.varInit(this, "this", 260, 6318, 6563);
            CallChecker.varInit(sumLogImpl, "sumLogImpl", 260, 6318, 6563);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 260, 6318, 6563);
            super.setSumLogImpl(sumLogImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3554.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getGeoMeanImpl() {
        MethodContext _bcornu_methode_context3555 = new MethodContext(StorelessUnivariateStatistic[].class, 269, 6570, 6734);
        try {
            CallChecker.varInit(this, "this", 269, 6570, 6734);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 269, 6570, 6734);
            return super.getGeoMeanImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3555.methodEnd();
        }
    }

    @Override
    public synchronized void setGeoMeanImpl(StorelessUnivariateStatistic[] geoMeanImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3556 = new MethodContext(void.class, 277, 6741, 6990);
        try {
            CallChecker.varInit(this, "this", 277, 6741, 6990);
            CallChecker.varInit(geoMeanImpl, "geoMeanImpl", 277, 6741, 6990);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 277, 6741, 6990);
            super.setGeoMeanImpl(geoMeanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3556.methodEnd();
        }
    }

    @Override
    public synchronized StorelessUnivariateStatistic[] getMeanImpl() {
        MethodContext _bcornu_methode_context3557 = new MethodContext(StorelessUnivariateStatistic[].class, 286, 6997, 7155);
        try {
            CallChecker.varInit(this, "this", 286, 6997, 7155);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 286, 6997, 7155);
            return super.getMeanImpl();
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessUnivariateStatistic[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3557.methodEnd();
        }
    }

    @Override
    public synchronized void setMeanImpl(StorelessUnivariateStatistic[] meanImpl) throws DimensionMismatchException, MathIllegalStateException {
        MethodContext _bcornu_methode_context3558 = new MethodContext(void.class, 294, 7162, 7399);
        try {
            CallChecker.varInit(this, "this", 294, 7162, 7399);
            CallChecker.varInit(meanImpl, "meanImpl", 294, 7162, 7399);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedMultivariateSummaryStatistics.serialVersionUID", 294, 7162, 7399);
            super.setMeanImpl(meanImpl);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3558.methodEnd();
        }
    }
}

