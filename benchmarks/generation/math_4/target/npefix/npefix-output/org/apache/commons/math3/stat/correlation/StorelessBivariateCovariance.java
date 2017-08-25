package org.apache.commons.math3.stat.correlation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

class StorelessBivariateCovariance {
    private double meanX;

    private double meanY;

    private double n;

    private double covarianceNumerator;

    private boolean biasCorrected;

    public StorelessBivariateCovariance() {
        this(true);
        ConstructorContext _bcornu_methode_context1068 = new ConstructorContext(StorelessBivariateCovariance.class, 60, 2106, 2284);
        try {
        } finally {
            _bcornu_methode_context1068.methodEnd();
        }
    }

    public StorelessBivariateCovariance(final boolean biasCorrection) {
        ConstructorContext _bcornu_methode_context1069 = new ConstructorContext(StorelessBivariateCovariance.class, 71, 2291, 2781);
        try {
            meanX = meanY = 0.0;
            CallChecker.varAssign(this.meanX, "this.meanX", 72, 2666, 2685);
            CallChecker.varAssign(this.meanY, "this.meanY", 72, 2674, 2684);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 73, 2695, 2700);
            covarianceNumerator = 0.0;
            CallChecker.varAssign(this.covarianceNumerator, "this.covarianceNumerator", 74, 2710, 2735);
            biasCorrected = biasCorrection;
            CallChecker.varAssign(this.biasCorrected, "this.biasCorrected", 75, 2745, 2775);
        } finally {
            _bcornu_methode_context1069.methodEnd();
        }
    }

    public void increment(final double x, final double y) {
        MethodContext _bcornu_methode_context4764 = new MethodContext(void.class, 84, 2788, 3219);
        try {
            CallChecker.varInit(this, "this", 84, 2788, 3219);
            CallChecker.varInit(y, "y", 84, 2788, 3219);
            CallChecker.varInit(x, "x", 84, 2788, 3219);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 84, 2788, 3219);
            CallChecker.varInit(this.covarianceNumerator, "covarianceNumerator", 84, 2788, 3219);
            CallChecker.varInit(this.n, "n", 84, 2788, 3219);
            CallChecker.varInit(this.meanY, "meanY", 84, 2788, 3219);
            CallChecker.varInit(this.meanX, "meanX", 84, 2788, 3219);
            (n)++;
            final double deltaX = CallChecker.varInit(((double) (x - (this.meanX))), "deltaX", 86, 3017, 3048);
            final double deltaY = CallChecker.varInit(((double) (y - (this.meanY))), "deltaY", 87, 3058, 3089);
            meanX += deltaX / (n);
            CallChecker.varAssign(this.meanX, "this.meanX", 88, 3099, 3118);
            meanY += deltaY / (n);
            CallChecker.varAssign(this.meanY, "this.meanY", 89, 3128, 3147);
            covarianceNumerator += ((((n) - 1.0) / (n)) * deltaX) * deltaY;
            CallChecker.varAssign(this.covarianceNumerator, "this.covarianceNumerator", 90, 3157, 3213);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4764.methodEnd();
        }
    }

    public void append(StorelessBivariateCovariance cov) {
        MethodContext _bcornu_methode_context4765 = new MethodContext(void.class, 101, 3226, 3969);
        try {
            CallChecker.varInit(this, "this", 101, 3226, 3969);
            CallChecker.varInit(cov, "cov", 101, 3226, 3969);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 101, 3226, 3969);
            CallChecker.varInit(this.covarianceNumerator, "covarianceNumerator", 101, 3226, 3969);
            CallChecker.varInit(this.n, "n", 101, 3226, 3969);
            CallChecker.varInit(this.meanY, "meanY", 101, 3226, 3969);
            CallChecker.varInit(this.meanX, "meanX", 101, 3226, 3969);
            double oldN = CallChecker.varInit(((double) (this.n)), "oldN", 102, 3663, 3678);
            if (CallChecker.beforeDeref(cov, StorelessBivariateCovariance.class, 103, 3693, 3695)) {
                cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 103, 3693, 3695);
                n += CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 103, 3693, 3695).n;
                CallChecker.varAssign(this.n, "this.n", 103, 3688, 3698);
            }
            cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 104, 3730, 3732);
            final double deltaX = CallChecker.varInit(((double) ((CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 104, 3730, 3732).meanX) - (this.meanX))), "deltaX", 104, 3708, 3747);
            cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 105, 3779, 3781);
            final double deltaY = CallChecker.varInit(((double) ((CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 105, 3779, 3781).meanY) - (this.meanY))), "deltaY", 105, 3757, 3796);
            if (CallChecker.beforeDeref(cov, StorelessBivariateCovariance.class, 106, 3824, 3826)) {
                cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 106, 3824, 3826);
                meanX += (deltaX * (CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 106, 3824, 3826).n)) / (n);
                CallChecker.varAssign(this.meanX, "this.meanX", 106, 3806, 3833);
            }
            if (CallChecker.beforeDeref(cov, StorelessBivariateCovariance.class, 107, 3861, 3863)) {
                cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 107, 3861, 3863);
                meanY += (deltaY * (CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 107, 3861, 3863).n)) / (n);
                CallChecker.varAssign(this.meanY, "this.meanY", 107, 3843, 3870);
            }
            if (CallChecker.beforeDeref(cov, StorelessBivariateCovariance.class, 108, 3903, 3905)) {
                if (CallChecker.beforeDeref(cov, StorelessBivariateCovariance.class, 108, 3936, 3938)) {
                    cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 108, 3903, 3905);
                    cov = CallChecker.beforeCalled(cov, StorelessBivariateCovariance.class, 108, 3936, 3938);
                    covarianceNumerator += (CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 108, 3903, 3905).covarianceNumerator) + ((((oldN * (CallChecker.isCalled(cov, StorelessBivariateCovariance.class, 108, 3936, 3938).n)) / (n)) * deltaX) * deltaY);
                    CallChecker.varAssign(this.covarianceNumerator, "this.covarianceNumerator", 108, 3880, 3963);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4765.methodEnd();
        }
    }

    public double getN() {
        MethodContext _bcornu_methode_context4766 = new MethodContext(double.class, 116, 3976, 4125);
        try {
            CallChecker.varInit(this, "this", 116, 3976, 4125);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 116, 3976, 4125);
            CallChecker.varInit(this.covarianceNumerator, "covarianceNumerator", 116, 3976, 4125);
            CallChecker.varInit(this.n, "n", 116, 3976, 4125);
            CallChecker.varInit(this.meanY, "meanY", 116, 3976, 4125);
            CallChecker.varInit(this.meanX, "meanX", 116, 3976, 4125);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4766.methodEnd();
        }
    }

    public double getResult() throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context4767 = new MethodContext(double.class, 127, 4132, 4725);
        try {
            CallChecker.varInit(this, "this", 127, 4132, 4725);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 127, 4132, 4725);
            CallChecker.varInit(this.covarianceNumerator, "covarianceNumerator", 127, 4132, 4725);
            CallChecker.varInit(this.n, "n", 127, 4132, 4725);
            CallChecker.varInit(this.meanY, "meanY", 127, 4132, 4725);
            CallChecker.varInit(this.meanX, "meanX", 127, 4132, 4725);
            if ((n) < 2) {
                throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DIMENSION, n, 2, true);
            }
            if (biasCorrected) {
                return (covarianceNumerator) / ((n) - 1.0);
            }else {
                return (covarianceNumerator) / (n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4767.methodEnd();
        }
    }
}

