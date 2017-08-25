package org.apache.commons.math3.stat.correlation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class Covariance {
    private final RealMatrix covarianceMatrix;

    private final int n;

    public Covariance() {
        super();
        ConstructorContext _bcornu_methode_context307 = new ConstructorContext(Covariance.class, 61, 2378, 2525);
        try {
            covarianceMatrix = null;
            CallChecker.varAssign(this.covarianceMatrix, "this.covarianceMatrix", 63, 2481, 2504);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 64, 2514, 2519);
        } finally {
            _bcornu_methode_context307.methodEnd();
        }
    }

    public Covariance(double[][] data, boolean biasCorrected) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        this(new BlockRealMatrix(data), biasCorrected);
        ConstructorContext _bcornu_methode_context308 = new ConstructorContext(Covariance.class, 84, 2532, 3495);
        try {
        } finally {
            _bcornu_methode_context308.methodEnd();
        }
    }

    public Covariance(double[][] data) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        this(data, true);
        ConstructorContext _bcornu_methode_context309 = new ConstructorContext(Covariance.class, 102, 3502, 4205);
        try {
        } finally {
            _bcornu_methode_context309.methodEnd();
        }
    }

    public Covariance(RealMatrix matrix, boolean biasCorrected) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context310 = new ConstructorContext(Covariance.class, 121, 4212, 5043);
        try {
            checkSufficientData(matrix);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 124, 4939, 4944);
            n = CallChecker.isCalled(matrix, RealMatrix.class, 124, 4939, 4944).getRowDimension();
            CallChecker.varAssign(this.n, "this.n", 124, 4935, 4963);
            covarianceMatrix = computeCovarianceMatrix(matrix, biasCorrected);
            CallChecker.varAssign(this.covarianceMatrix, "this.covarianceMatrix", 125, 4972, 5037);
        } finally {
            _bcornu_methode_context310.methodEnd();
        }
    }

    public Covariance(RealMatrix matrix) throws MathIllegalArgumentException {
        this(matrix, true);
        ConstructorContext _bcornu_methode_context311 = new ConstructorContext(Covariance.class, 138, 5050, 5529);
        try {
        } finally {
            _bcornu_methode_context311.methodEnd();
        }
    }

    public RealMatrix getCovarianceMatrix() {
        MethodContext _bcornu_methode_context1378 = new MethodContext(RealMatrix.class, 147, 5536, 5708);
        try {
            CallChecker.varInit(this, "this", 147, 5536, 5708);
            CallChecker.varInit(this.n, "n", 147, 5536, 5708);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 147, 5536, 5708);
            return covarianceMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1378.methodEnd();
        }
    }

    public int getN() {
        MethodContext _bcornu_methode_context1379 = new MethodContext(int.class, 156, 5715, 5890);
        try {
            CallChecker.varInit(this, "this", 156, 5715, 5890);
            CallChecker.varInit(this.n, "n", 156, 5715, 5890);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 156, 5715, 5890);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1379.methodEnd();
        }
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix matrix, boolean biasCorrected) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1380 = new MethodContext(RealMatrix.class, 168, 5897, 7021);
        try {
            CallChecker.varInit(this, "this", 168, 5897, 7021);
            CallChecker.varInit(biasCorrected, "biasCorrected", 168, 5897, 7021);
            CallChecker.varInit(matrix, "matrix", 168, 5897, 7021);
            CallChecker.varInit(this.n, "n", 168, 5897, 7021);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 168, 5897, 7021);
            int dimension = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 170, 6455, 6460)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 170, 6455, 6460);
                dimension = CallChecker.isCalled(matrix, RealMatrix.class, 170, 6455, 6460).getColumnDimension();
                CallChecker.varAssign(dimension, "dimension", 170, 6455, 6460);
            }
            Variance variance = CallChecker.varInit(new Variance(biasCorrected), "variance", 171, 6492, 6539);
            RealMatrix outMatrix = CallChecker.varInit(new BlockRealMatrix(dimension, dimension), "outMatrix", 172, 6549, 6613);
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < i; j++) {
                    double cov = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 175, 6741, 6746)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 175, 6762, 6767)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 175, 6741, 6746);
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 175, 6762, 6767);
                            cov = covariance(CallChecker.isCalled(matrix, RealMatrix.class, 175, 6741, 6746).getColumn(i), CallChecker.isCalled(matrix, RealMatrix.class, 175, 6762, 6767).getColumn(j), biasCorrected);
                            CallChecker.varAssign(cov, "cov", 175, 6741, 6746);
                        }
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 176, 6813, 6821)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 176, 6813, 6821);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 176, 6813, 6821).setEntry(i, j, cov);
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 177, 6858, 6866)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 177, 6858, 6866);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 177, 6858, 6866).setEntry(j, i, cov);
                    }
                }
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 179, 6958, 6963)) {
                    if (CallChecker.beforeDeref(variance, Variance.class, 179, 6940, 6947)) {
                        if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 179, 6915, 6923)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 179, 6958, 6963);
                            variance = CallChecker.beforeCalled(variance, Variance.class, 179, 6940, 6947);
                            outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 179, 6915, 6923);
                            CallChecker.isCalled(outMatrix, RealMatrix.class, 179, 6915, 6923).setEntry(i, i, CallChecker.isCalled(variance, Variance.class, 179, 6940, 6947).evaluate(CallChecker.isCalled(matrix, RealMatrix.class, 179, 6958, 6963).getColumn(i)));
                        }
                    }
                }
            }
            return outMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1380.methodEnd();
        }
    }

    protected RealMatrix computeCovarianceMatrix(RealMatrix matrix) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1381 = new MethodContext(RealMatrix.class, 192, 7028, 7581);
        try {
            CallChecker.varInit(this, "this", 192, 7028, 7581);
            CallChecker.varInit(matrix, "matrix", 192, 7028, 7581);
            CallChecker.varInit(this.n, "n", 192, 7028, 7581);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 192, 7028, 7581);
            return computeCovarianceMatrix(matrix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1381.methodEnd();
        }
    }

    protected RealMatrix computeCovarianceMatrix(double[][] data, boolean biasCorrected) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context1382 = new MethodContext(RealMatrix.class, 208, 7588, 8387);
        try {
            CallChecker.varInit(this, "this", 208, 7588, 8387);
            CallChecker.varInit(biasCorrected, "biasCorrected", 208, 7588, 8387);
            CallChecker.varInit(data, "data", 208, 7588, 8387);
            CallChecker.varInit(this.n, "n", 208, 7588, 8387);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 208, 7588, 8387);
            return computeCovarianceMatrix(new BlockRealMatrix(data), biasCorrected);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1382.methodEnd();
        }
    }

    protected RealMatrix computeCovarianceMatrix(double[][] data) throws MathIllegalArgumentException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context1383 = new MethodContext(RealMatrix.class, 223, 8394, 9121);
        try {
            CallChecker.varInit(this, "this", 223, 8394, 9121);
            CallChecker.varInit(data, "data", 223, 8394, 9121);
            CallChecker.varInit(this.n, "n", 223, 8394, 9121);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 223, 8394, 9121);
            return computeCovarianceMatrix(data, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1383.methodEnd();
        }
    }

    public double covariance(final double[] xArray, final double[] yArray, boolean biasCorrected) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1384 = new MethodContext(double.class, 240, 9128, 10647);
        try {
            CallChecker.varInit(this, "this", 240, 9128, 10647);
            CallChecker.varInit(biasCorrected, "biasCorrected", 240, 9128, 10647);
            CallChecker.varInit(yArray, "yArray", 240, 9128, 10647);
            CallChecker.varInit(xArray, "xArray", 240, 9128, 10647);
            CallChecker.varInit(this.n, "n", 240, 9128, 10647);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 240, 9128, 10647);
            Mean mean = CallChecker.varInit(new Mean(), "mean", 242, 9768, 9790);
            double result = CallChecker.varInit(((double) (0.0)), "result", 243, 9800, 9818);
            int length = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(xArray, double[].class, 244, 9841, 9846)) {
                length = CallChecker.isCalled(xArray, double[].class, 244, 9841, 9846).length;
                CallChecker.varAssign(length, "length", 244, 9841, 9846);
            }
            if (CallChecker.beforeDeref(yArray, double[].class, 245, 9878, 9883)) {
                if (length != (CallChecker.isCalled(yArray, double[].class, 245, 9878, 9883).length)) {
                    if (CallChecker.beforeDeref(yArray, double[].class, 247, 10018, 10023)) {
                        throw new MathIllegalArgumentException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, length, CallChecker.isCalled(yArray, double[].class, 247, 10018, 10023).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (length < 2) {
                        throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, length, 2);
                    }else {
                        double xMean = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(mean, Mean.class, 252, 10250, 10253)) {
                            mean = CallChecker.beforeCalled(mean, Mean.class, 252, 10250, 10253);
                            xMean = CallChecker.isCalled(mean, Mean.class, 252, 10250, 10253).evaluate(xArray);
                            CallChecker.varAssign(xMean, "xMean", 252, 10250, 10253);
                        }
                        double yMean = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(mean, Mean.class, 253, 10300, 10303)) {
                            mean = CallChecker.beforeCalled(mean, Mean.class, 253, 10300, 10303);
                            yMean = CallChecker.isCalled(mean, Mean.class, 253, 10300, 10303).evaluate(yArray);
                            CallChecker.varAssign(yMean, "yMean", 253, 10300, 10303);
                        }
                        for (int i = 0; i < length; i++) {
                            double xDev = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(xArray, double[].class, 255, 10400, 10405)) {
                                xDev = (CallChecker.isCalled(xArray, double[].class, 255, 10400, 10405)[i]) - xMean;
                                CallChecker.varAssign(xDev, "xDev", 255, 10400, 10405);
                            }
                            double yDev = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(yArray, double[].class, 256, 10449, 10454)) {
                                yDev = (CallChecker.isCalled(yArray, double[].class, 256, 10449, 10454)[i]) - yMean;
                                CallChecker.varAssign(yDev, "yDev", 256, 10449, 10454);
                            }
                            result += ((xDev * yDev) - result) / (i + 1);
                            CallChecker.varAssign(result, "result", 257, 10484, 10526);
                        }
                    }
                
            }else
                throw new AbnormalExecutionError();
            
            if (biasCorrected) {
                return result * (((double) (length)) / ((double) (length - 1)));
            }else {
                return result;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1384.methodEnd();
        }
    }

    public double covariance(final double[] xArray, final double[] yArray) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1385 = new MethodContext(double.class, 275, 10654, 11282);
        try {
            CallChecker.varInit(this, "this", 275, 10654, 11282);
            CallChecker.varInit(yArray, "yArray", 275, 10654, 11282);
            CallChecker.varInit(xArray, "xArray", 275, 10654, 11282);
            CallChecker.varInit(this.n, "n", 275, 10654, 11282);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 275, 10654, 11282);
            return covariance(xArray, yArray, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1385.methodEnd();
        }
    }

    private void checkSufficientData(final RealMatrix matrix) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1386 = new MethodContext(void.class, 287, 11289, 11972);
        try {
            CallChecker.varInit(this, "this", 287, 11289, 11972);
            CallChecker.varInit(matrix, "matrix", 287, 11289, 11972);
            CallChecker.varInit(this.n, "n", 287, 11289, 11972);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 287, 11289, 11972);
            int nRows = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 288, 11690, 11695)) {
                nRows = CallChecker.isCalled(matrix, RealMatrix.class, 288, 11690, 11695).getRowDimension();
                CallChecker.varAssign(nRows, "nRows", 288, 11690, 11695);
            }
            int nCols = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 289, 11736, 11741)) {
                nCols = CallChecker.isCalled(matrix, RealMatrix.class, 289, 11736, 11741).getColumnDimension();
                CallChecker.varAssign(nCols, "nCols", 289, 11736, 11741);
            }
            if ((nRows < 2) || (nCols < 1)) {
                throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, nRows, nCols);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1386.methodEnd();
        }
    }
}

