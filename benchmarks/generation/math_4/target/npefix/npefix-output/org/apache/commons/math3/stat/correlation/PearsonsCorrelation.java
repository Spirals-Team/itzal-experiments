package org.apache.commons.math3.stat.correlation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.FastMath;

public class PearsonsCorrelation {
    private final RealMatrix correlationMatrix;

    private final int nObs;

    public PearsonsCorrelation() {
        super();
        ConstructorContext _bcornu_methode_context1024 = new ConstructorContext(PearsonsCorrelation.class, 55, 2259, 2437);
        try {
            correlationMatrix = null;
            CallChecker.varAssign(this.correlationMatrix, "this.correlationMatrix", 57, 2389, 2413);
            nObs = 0;
            CallChecker.varAssign(this.nObs, "this.nObs", 58, 2423, 2431);
        } finally {
            _bcornu_methode_context1024.methodEnd();
        }
    }

    public PearsonsCorrelation(double[][] data) {
        this(new BlockRealMatrix(data));
        ConstructorContext _bcornu_methode_context1025 = new ConstructorContext(PearsonsCorrelation.class, 69, 2444, 2891);
        try {
        } finally {
            _bcornu_methode_context1025.methodEnd();
        }
    }

    public PearsonsCorrelation(RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context1026 = new ConstructorContext(PearsonsCorrelation.class, 79, 2898, 3303);
        try {
            checkSufficientData(matrix);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 81, 3211, 3216);
            nObs = CallChecker.isCalled(matrix, RealMatrix.class, 81, 3211, 3216).getRowDimension();
            CallChecker.varAssign(this.nObs, "this.nObs", 81, 3204, 3235);
            correlationMatrix = computeCorrelationMatrix(matrix);
            CallChecker.varAssign(this.correlationMatrix, "this.correlationMatrix", 82, 3245, 3297);
        } finally {
            _bcornu_methode_context1026.methodEnd();
        }
    }

    public PearsonsCorrelation(Covariance covariance) {
        ConstructorContext _bcornu_methode_context1027 = new ConstructorContext(PearsonsCorrelation.class, 93, 3310, 4018);
        try {
            RealMatrix covarianceMatrix = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(covariance, Covariance.class, 94, 3744, 3753)) {
                covariance = CallChecker.beforeCalled(covariance, Covariance.class, 94, 3744, 3753);
                covarianceMatrix = CallChecker.isCalled(covariance, Covariance.class, 94, 3744, 3753).getCovarianceMatrix();
                CallChecker.varAssign(covarianceMatrix, "covarianceMatrix", 94, 3744, 3753);
            }
            if (covarianceMatrix == null) {
                throw new NullArgumentException(LocalizedFormats.COVARIANCE_MATRIX);
            }
            covariance = CallChecker.beforeCalled(covariance, Covariance.class, 98, 3924, 3933);
            nObs = CallChecker.isCalled(covariance, Covariance.class, 98, 3924, 3933).getN();
            CallChecker.varAssign(this.nObs, "this.nObs", 98, 3917, 3941);
            correlationMatrix = covarianceToCorrelation(covarianceMatrix);
            CallChecker.varAssign(this.correlationMatrix, "this.correlationMatrix", 99, 3951, 4012);
        } finally {
            _bcornu_methode_context1027.methodEnd();
        }
    }

    public PearsonsCorrelation(RealMatrix covarianceMatrix, int numberOfObservations) {
        ConstructorContext _bcornu_methode_context1028 = new ConstructorContext(PearsonsCorrelation.class, 110, 4025, 4555);
        try {
            nObs = numberOfObservations;
            CallChecker.varAssign(this.nObs, "this.nObs", 111, 4450, 4477);
            correlationMatrix = covarianceToCorrelation(covarianceMatrix);
            CallChecker.varAssign(this.correlationMatrix, "this.correlationMatrix", 112, 4487, 4548);
        } finally {
            _bcornu_methode_context1028.methodEnd();
        }
    }

    public RealMatrix getCorrelationMatrix() {
        MethodContext _bcornu_methode_context4563 = new MethodContext(RealMatrix.class, 121, 4562, 4738);
        try {
            CallChecker.varInit(this, "this", 121, 4562, 4738);
            CallChecker.varInit(this.nObs, "nObs", 121, 4562, 4738);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 121, 4562, 4738);
            return correlationMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4563.methodEnd();
        }
    }

    public RealMatrix getCorrelationStandardErrors() {
        MethodContext _bcornu_methode_context4564 = new MethodContext(RealMatrix.class, 137, 4745, 5840);
        try {
            CallChecker.varInit(this, "this", 137, 4745, 5840);
            CallChecker.varInit(this.nObs, "nObs", 137, 4745, 5840);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 137, 4745, 5840);
            int nVars = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(correlationMatrix, RealMatrix.class, 138, 5463, 5479)) {
                nVars = CallChecker.isCalled(correlationMatrix, RealMatrix.class, 138, 5463, 5479).getColumnDimension();
                CallChecker.varAssign(nVars, "nVars", 138, 5463, 5479);
            }
            double[][] out = CallChecker.varInit(new double[nVars][nVars], "out", 139, 5511, 5552);
            for (int i = 0; i < nVars; i++) {
                for (int j = 0; j < nVars; j++) {
                    double r = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(correlationMatrix, RealMatrix.class, 142, 5669, 5685)) {
                        r = CallChecker.isCalled(correlationMatrix, RealMatrix.class, 142, 5669, 5685).getEntry(i, j);
                        CallChecker.varAssign(r, "r", 142, 5669, 5685);
                    }
                    if (CallChecker.beforeDeref(out, double[][].class, 143, 5719, 5721)) {
                        out = CallChecker.beforeCalled(out, double[][].class, 143, 5719, 5721);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i], double[].class, 143, 5719, 5724)) {
                            out = CallChecker.beforeCalled(out, double[][].class, 143, 5719, 5721);
                            CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i] = CallChecker.beforeCalled(CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i], double[].class, 143, 5719, 5724);
                            CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i], double[].class, 143, 5719, 5724)[j] = FastMath.sqrt(((1 - (r * r)) / ((nObs) - 2)));
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i], double[].class, 143, 5719, 5724)[j], "CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 143, 5719, 5721)[i], double[].class, 143, 5719, 5724)[j]", 143, 5719, 5769);
                        }
                    }
                }
            }
            return new BlockRealMatrix(out);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4564.methodEnd();
        }
    }

    public RealMatrix getCorrelationPValues() {
        MethodContext _bcornu_methode_context4565 = new MethodContext(RealMatrix.class, 163, 5847, 7340);
        try {
            CallChecker.varInit(this, "this", 163, 5847, 7340);
            CallChecker.varInit(this.nObs, "nObs", 163, 5847, 7340);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 163, 5847, 7340);
            TDistribution tDistribution = CallChecker.varInit(new TDistribution(((nObs) - 2)), "tDistribution", 164, 6674, 6731);
            int nVars = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(correlationMatrix, RealMatrix.class, 165, 6753, 6769)) {
                nVars = CallChecker.isCalled(correlationMatrix, RealMatrix.class, 165, 6753, 6769).getColumnDimension();
                CallChecker.varAssign(nVars, "nVars", 165, 6753, 6769);
            }
            double[][] out = CallChecker.varInit(new double[nVars][nVars], "out", 166, 6801, 6842);
            for (int i = 0; i < nVars; i++) {
                for (int j = 0; j < nVars; j++) {
                    if (i == j) {
                        if (CallChecker.beforeDeref(out, double[][].class, 170, 6982, 6984)) {
                            out = CallChecker.beforeCalled(out, double[][].class, 170, 6982, 6984);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i], double[].class, 170, 6982, 6987)) {
                                out = CallChecker.beforeCalled(out, double[][].class, 170, 6982, 6984);
                                CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i] = CallChecker.beforeCalled(CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i], double[].class, 170, 6982, 6987);
                                CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i], double[].class, 170, 6982, 6987)[j] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i], double[].class, 170, 6982, 6987)[j], "CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 170, 6982, 6984)[i], double[].class, 170, 6982, 6987)[j]", 170, 6982, 6996);
                            }
                        }
                    }else {
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(correlationMatrix, RealMatrix.class, 172, 7054, 7070)) {
                            r = CallChecker.isCalled(correlationMatrix, RealMatrix.class, 172, 7054, 7070).getEntry(i, j);
                            CallChecker.varAssign(r, "r", 172, 7054, 7070);
                        }
                        double t = CallChecker.varInit(((double) (FastMath.abs((r * (FastMath.sqrt((((this.nObs) - 2) / (1 - (r * r))))))))), "t", 173, 7108, 7174);
                        if (CallChecker.beforeDeref(out, double[][].class, 174, 7196, 7198)) {
                            out = CallChecker.beforeCalled(out, double[][].class, 174, 7196, 7198);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i], double[].class, 174, 7196, 7201)) {
                                if (CallChecker.beforeDeref(tDistribution, TDistribution.class, 174, 7212, 7224)) {
                                    out = CallChecker.beforeCalled(out, double[][].class, 174, 7196, 7198);
                                    CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i] = CallChecker.beforeCalled(CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i], double[].class, 174, 7196, 7201);
                                    tDistribution = CallChecker.beforeCalled(tDistribution, TDistribution.class, 174, 7212, 7224);
                                    CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i], double[].class, 174, 7196, 7201)[j] = 2 * (CallChecker.isCalled(tDistribution, TDistribution.class, 174, 7212, 7224).cumulativeProbability((-t)));
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i], double[].class, 174, 7196, 7201)[j], "CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 174, 7196, 7198)[i], double[].class, 174, 7196, 7201)[j]", 174, 7196, 7251);
                                }
                            }
                        }
                    }
                }
            }
            return new BlockRealMatrix(out);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4565.methodEnd();
        }
    }

    public RealMatrix computeCorrelationMatrix(RealMatrix matrix) {
        MethodContext _bcornu_methode_context4566 = new MethodContext(RealMatrix.class, 189, 7348, 8099);
        try {
            CallChecker.varInit(this, "this", 189, 7348, 8099);
            CallChecker.varInit(matrix, "matrix", 189, 7348, 8099);
            CallChecker.varInit(this.nObs, "nObs", 189, 7348, 8099);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 189, 7348, 8099);
            int nVars = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 190, 7649, 7654)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 190, 7649, 7654);
                nVars = CallChecker.isCalled(matrix, RealMatrix.class, 190, 7649, 7654).getColumnDimension();
                CallChecker.varAssign(nVars, "nVars", 190, 7649, 7654);
            }
            RealMatrix outMatrix = CallChecker.varInit(new BlockRealMatrix(nVars, nVars), "outMatrix", 191, 7686, 7742);
            for (int i = 0; i < nVars; i++) {
                for (int j = 0; j < i; j++) {
                    double corr = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 194, 7868, 7873)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 194, 7889, 7894)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 194, 7868, 7873);
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 194, 7889, 7894);
                            corr = correlation(CallChecker.isCalled(matrix, RealMatrix.class, 194, 7868, 7873).getColumn(i), CallChecker.isCalled(matrix, RealMatrix.class, 194, 7889, 7894).getColumn(j));
                            CallChecker.varAssign(corr, "corr", 194, 7868, 7873);
                        }
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 195, 7925, 7933)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 195, 7925, 7933);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 195, 7925, 7933).setEntry(i, j, corr);
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 196, 7971, 7979)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 196, 7971, 7979);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 196, 7971, 7979).setEntry(j, i, corr);
                    }
                }
                if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 198, 8029, 8037)) {
                    outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 198, 8029, 8037);
                    CallChecker.isCalled(outMatrix, RealMatrix.class, 198, 8029, 8037).setEntry(i, i, 1.0);
                }
            }
            return outMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4566.methodEnd();
        }
    }

    public RealMatrix computeCorrelationMatrix(double[][] data) {
        MethodContext _bcornu_methode_context4567 = new MethodContext(RealMatrix.class, 211, 8106, 8545);
        try {
            CallChecker.varInit(this, "this", 211, 8106, 8545);
            CallChecker.varInit(data, "data", 211, 8106, 8545);
            CallChecker.varInit(this.nObs, "nObs", 211, 8106, 8545);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 211, 8106, 8545);
            return computeCorrelationMatrix(new BlockRealMatrix(data));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4567.methodEnd();
        }
    }

    public double correlation(final double[] xArray, final double[] yArray) {
        MethodContext _bcornu_methode_context4568 = new MethodContext(double.class, 227, 8552, 9767);
        try {
            CallChecker.varInit(this, "this", 227, 8552, 9767);
            CallChecker.varInit(yArray, "yArray", 227, 8552, 9767);
            CallChecker.varInit(xArray, "xArray", 227, 8552, 9767);
            CallChecker.varInit(this.nObs, "nObs", 227, 8552, 9767);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 227, 8552, 9767);
            SimpleRegression regression = CallChecker.varInit(new SimpleRegression(), "regression", 228, 9195, 9247);
            if (CallChecker.beforeDeref(xArray, double[].class, 229, 9261, 9266)) {
                if (CallChecker.beforeDeref(yArray, double[].class, 229, 9278, 9283)) {
                    if ((CallChecker.isCalled(xArray, double[].class, 229, 9261, 9266).length) != (CallChecker.isCalled(yArray, double[].class, 229, 9278, 9283).length)) {
                        if (CallChecker.beforeDeref(xArray, double[].class, 230, 9344, 9349)) {
                            if (CallChecker.beforeDeref(yArray, double[].class, 230, 9359, 9364)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xArray, double[].class, 230, 9344, 9349).length, CallChecker.isCalled(yArray, double[].class, 230, 9359, 9364).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(xArray, double[].class, 231, 9394, 9399)) {
                            if ((CallChecker.isCalled(xArray, double[].class, 231, 9394, 9399).length) < 2) {
                                if (CallChecker.beforeDeref(xArray, double[].class, 233, 9558, 9563)) {
                                    throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_DIMENSION, CallChecker.isCalled(xArray, double[].class, 233, 9558, 9563).length, 2);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                for (int i = 0; i < (CallChecker.isCalled(xArray, double[].class, 235, 9621, 9626).length); i++) {
                                    if (CallChecker.beforeDeref(xArray, double[].class, 236, 9678, 9683)) {
                                        if (CallChecker.beforeDeref(yArray, double[].class, 236, 9689, 9694)) {
                                            if (CallChecker.beforeDeref(regression, SimpleRegression.class, 236, 9659, 9668)) {
                                                regression = CallChecker.beforeCalled(regression, SimpleRegression.class, 236, 9659, 9668);
                                                CallChecker.isCalled(regression, SimpleRegression.class, 236, 9659, 9668).addData(CallChecker.isCalled(xArray, double[].class, 236, 9678, 9683)[i], CallChecker.isCalled(yArray, double[].class, 236, 9689, 9694)[i]);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(regression, SimpleRegression.class, 238, 9734, 9743)) {
                                    regression = CallChecker.beforeCalled(regression, SimpleRegression.class, 238, 9734, 9743);
                                    return CallChecker.isCalled(regression, SimpleRegression.class, 238, 9734, 9743).getR();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4568.methodEnd();
        }
    }

    public RealMatrix covarianceToCorrelation(RealMatrix covarianceMatrix) {
        MethodContext _bcornu_methode_context4569 = new MethodContext(RealMatrix.class, 253, 9774, 10873);
        try {
            CallChecker.varInit(this, "this", 253, 9774, 10873);
            CallChecker.varInit(covarianceMatrix, "covarianceMatrix", 253, 9774, 10873);
            CallChecker.varInit(this.nObs, "nObs", 253, 9774, 10873);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 253, 9774, 10873);
            int nVars = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(covarianceMatrix, RealMatrix.class, 254, 10269, 10284)) {
                covarianceMatrix = CallChecker.beforeCalled(covarianceMatrix, RealMatrix.class, 254, 10269, 10284);
                nVars = CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 254, 10269, 10284).getColumnDimension();
                CallChecker.varAssign(nVars, "nVars", 254, 10269, 10284);
            }
            RealMatrix outMatrix = CallChecker.varInit(new BlockRealMatrix(nVars, nVars), "outMatrix", 255, 10316, 10372);
            for (int i = 0; i < nVars; i++) {
                double sigma = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(covarianceMatrix, RealMatrix.class, 257, 10457, 10472)) {
                    covarianceMatrix = CallChecker.beforeCalled(covarianceMatrix, RealMatrix.class, 257, 10457, 10472);
                    sigma = FastMath.sqrt(CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 257, 10457, 10472).getEntry(i, i));
                    CallChecker.varAssign(sigma, "sigma", 257, 10457, 10472);
                }
                if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 258, 10503, 10511)) {
                    outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 258, 10503, 10511);
                    CallChecker.isCalled(outMatrix, RealMatrix.class, 258, 10503, 10511).setEntry(i, i, 1.0);
                }
                for (int j = 0; j < i; j++) {
                    double entry = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(covarianceMatrix, RealMatrix.class, 260, 10606, 10621)) {
                        if (CallChecker.beforeDeref(covarianceMatrix, RealMatrix.class, 261, 10686, 10701)) {
                            covarianceMatrix = CallChecker.beforeCalled(covarianceMatrix, RealMatrix.class, 260, 10606, 10621);
                            covarianceMatrix = CallChecker.beforeCalled(covarianceMatrix, RealMatrix.class, 261, 10686, 10701);
                            entry = (CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 260, 10606, 10621).getEntry(i, j)) / (sigma * (FastMath.sqrt(CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 261, 10686, 10701).getEntry(j, j))));
                            CallChecker.varAssign(entry, "entry", 260, 10606, 10621);
                        }
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 262, 10737, 10745)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 262, 10737, 10745);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 262, 10737, 10745).setEntry(i, j, entry);
                    }
                    if (CallChecker.beforeDeref(outMatrix, RealMatrix.class, 263, 10786, 10794)) {
                        outMatrix = CallChecker.beforeCalled(outMatrix, RealMatrix.class, 263, 10786, 10794);
                        CallChecker.isCalled(outMatrix, RealMatrix.class, 263, 10786, 10794).setEntry(j, i, entry);
                    }
                }
            }
            return outMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4569.methodEnd();
        }
    }

    private void checkSufficientData(final RealMatrix matrix) {
        MethodContext _bcornu_methode_context4570 = new MethodContext(void.class, 276, 10880, 11510);
        try {
            CallChecker.varInit(this, "this", 276, 10880, 11510);
            CallChecker.varInit(matrix, "matrix", 276, 10880, 11510);
            CallChecker.varInit(this.nObs, "nObs", 276, 10880, 11510);
            CallChecker.varInit(this.correlationMatrix, "correlationMatrix", 276, 10880, 11510);
            int nRows = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 277, 11218, 11223)) {
                nRows = CallChecker.isCalled(matrix, RealMatrix.class, 277, 11218, 11223).getRowDimension();
                CallChecker.varAssign(nRows, "nRows", 277, 11218, 11223);
            }
            int nCols = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 278, 11264, 11269)) {
                nCols = CallChecker.isCalled(matrix, RealMatrix.class, 278, 11264, 11269).getColumnDimension();
                CallChecker.varAssign(nCols, "nCols", 278, 11264, 11269);
            }
            if ((nRows < 2) || (nCols < 2)) {
                throw new MathIllegalArgumentException(LocalizedFormats.INSUFFICIENT_ROWS_AND_COLUMNS, nRows, nCols);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4570.methodEnd();
        }
    }
}

