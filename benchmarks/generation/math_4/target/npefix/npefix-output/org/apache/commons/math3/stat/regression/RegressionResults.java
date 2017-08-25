package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class RegressionResults implements Serializable {
    private static final int SSE_IDX = 0;

    private static final int SST_IDX = 1;

    private static final int RSQ_IDX = 2;

    private static final int MSE_IDX = 3;

    private static final int ADJRSQ_IDX = 4;

    private static final long serialVersionUID = 1L;

    private final double[] parameters;

    private final double[][] varCovData;

    private final boolean isSymmetricVCD;

    @SuppressWarnings(value = "unused")
    private final int rank;

    private final long nobs;

    private final boolean containsConstant;

    private final double[] globalFitInfo;

    @SuppressWarnings(value = "unused")
    private RegressionResults() {
        ConstructorContext _bcornu_methode_context508 = new ConstructorContext(RegressionResults.class, 66, 2410, 2814);
        try {
            this.parameters = null;
            CallChecker.varAssign(this.parameters, "this.parameters", 67, 2595, 2617);
            this.varCovData = null;
            CallChecker.varAssign(this.varCovData, "this.varCovData", 68, 2627, 2649);
            this.rank = -1;
            CallChecker.varAssign(this.rank, "this.rank", 69, 2659, 2673);
            this.nobs = -1;
            CallChecker.varAssign(this.nobs, "this.nobs", 70, 2683, 2697);
            this.containsConstant = false;
            CallChecker.varAssign(this.containsConstant, "this.containsConstant", 71, 2707, 2736);
            this.isSymmetricVCD = false;
            CallChecker.varAssign(this.isSymmetricVCD, "this.isSymmetricVCD", 72, 2746, 2773);
            this.globalFitInfo = null;
            CallChecker.varAssign(this.globalFitInfo, "this.globalFitInfo", 73, 2783, 2808);
        } finally {
            _bcornu_methode_context508.methodEnd();
        }
    }

    public RegressionResults(final double[] parameters, final double[][] varcov, final boolean isSymmetricCompressed, final long nobs, final int rank, final double sumy, final double sumysq, final double sse, final boolean containsConstant, final boolean copyData) {
        ConstructorContext _bcornu_methode_context509 = new ConstructorContext(RegressionResults.class, 93, 2821, 5546);
        try {
            if (copyData) {
                this.parameters = MathArrays.copyOf(parameters);
                CallChecker.varAssign(this.parameters, "this.parameters", 101, 4135, 4182);
                this.varCovData = new double[CallChecker.isCalled(varcov, double[][].class, 102, 4225, 4230).length][];
                CallChecker.varAssign(this.varCovData, "this.varCovData", 102, 4196, 4241);
                for (int i = 0; i < (CallChecker.isCalled(varcov, double[][].class, 103, 4275, 4280).length); i++) {
                    if (CallChecker.beforeDeref(this.varCovData, double[][].class, 104, 4313, 4327)) {
                        if (CallChecker.beforeDeref(varcov, double[][].class, 104, 4352, 4357)) {
                            CallChecker.isCalled(this.varCovData, double[][].class, 104, 4313, 4327)[i] = MathArrays.copyOf(CallChecker.isCalled(varcov, double[][].class, 104, 4352, 4357)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.varCovData, double[][].class, 104, 4313, 4327)[i], "CallChecker.isCalled(this.varCovData, double[][].class, 104, 4313, 4327)[i]", 104, 4313, 4362);
                        }
                    }
                }
            }else {
                this.parameters = parameters;
                CallChecker.varAssign(this.parameters, "this.parameters", 107, 4407, 4435);
                this.varCovData = varcov;
                CallChecker.varAssign(this.varCovData, "this.varCovData", 108, 4449, 4473);
            }
            this.isSymmetricVCD = isSymmetricCompressed;
            CallChecker.varAssign(this.isSymmetricVCD, "this.isSymmetricVCD", 110, 4493, 4536);
            this.nobs = nobs;
            CallChecker.varAssign(this.nobs, "this.nobs", 111, 4546, 4562);
            this.rank = rank;
            CallChecker.varAssign(this.rank, "this.rank", 112, 4572, 4588);
            this.containsConstant = containsConstant;
            CallChecker.varAssign(this.containsConstant, "this.containsConstant", 113, 4598, 4638);
            this.globalFitInfo = new double[5];
            CallChecker.varAssign(this.globalFitInfo, "this.globalFitInfo", 114, 4648, 4682);
            Arrays.fill(this.globalFitInfo, Double.NaN);
            if (rank > 0) {
                if (containsConstant) {
                    if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 118, 4774, 4791)) {
                        CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX] = sumysq - ((sumy * sumy) / nobs);
                        CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX]", 118, 4774, 4881);
                    }
                }else {
                    if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 118, 4774, 4791)) {
                        CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX] = sumysq;
                        CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 118, 4774, 4791)[RegressionResults.SST_IDX]", 118, 4774, 4881);
                    }
                }
            }
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 122, 4902, 4919)) {
                CallChecker.isCalled(this.globalFitInfo, double[].class, 122, 4902, 4919)[RegressionResults.SSE_IDX] = sse;
                CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 122, 4902, 4919)[RegressionResults.SSE_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 122, 4902, 4919)[RegressionResults.SSE_IDX]", 122, 4902, 4935);
            }
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 123, 4945, 4962)) {
                if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 123, 4975, 4992)) {
                    CallChecker.isCalled(this.globalFitInfo, double[].class, 123, 4945, 4962)[RegressionResults.MSE_IDX] = (CallChecker.isCalled(this.globalFitInfo, double[].class, 123, 4975, 4992)[RegressionResults.SSE_IDX]) / (nobs - rank);
                    CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 123, 4945, 4962)[RegressionResults.MSE_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 123, 4945, 4962)[RegressionResults.MSE_IDX]", 123, 4945, 5034);
                }
            }
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 125, 5044, 5061)) {
                if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 126, 5096, 5113)) {
                    if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 127, 5142, 5159)) {
                        CallChecker.isCalled(this.globalFitInfo, double[].class, 125, 5044, 5061)[RegressionResults.RSQ_IDX] = 1.0 - ((CallChecker.isCalled(this.globalFitInfo, double[].class, 126, 5096, 5113)[RegressionResults.SSE_IDX]) / (CallChecker.isCalled(this.globalFitInfo, double[].class, 127, 5142, 5159)[RegressionResults.SST_IDX]));
                        CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 125, 5044, 5061)[RegressionResults.RSQ_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 125, 5044, 5061)[RegressionResults.RSQ_IDX]", 125, 5044, 5169);
                    }
                }
            }
            if (!containsConstant) {
                if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 130, 5217, 5234)) {
                    if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 131, 5282, 5299)) {
                        CallChecker.isCalled(this.globalFitInfo, double[].class, 130, 5217, 5234)[RegressionResults.ADJRSQ_IDX] = 1.0 - ((1.0 - (CallChecker.isCalled(this.globalFitInfo, double[].class, 131, 5282, 5299)[RegressionResults.RSQ_IDX])) * (((double) (nobs)) / ((double) (nobs - rank))));
                        CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 130, 5217, 5234)[RegressionResults.ADJRSQ_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 130, 5217, 5234)[RegressionResults.ADJRSQ_IDX]", 130, 5217, 5377);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 134, 5408, 5425)) {
                    if (CallChecker.beforeDeref(globalFitInfo, double[].class, 135, 5491, 5503)) {
                        CallChecker.isCalled(this.globalFitInfo, double[].class, 134, 5408, 5425)[RegressionResults.ADJRSQ_IDX] = 1.0 - ((sse * (nobs - 1.0)) / ((CallChecker.isCalled(globalFitInfo, double[].class, 135, 5491, 5503)[RegressionResults.SST_IDX]) * (nobs - rank)));
                        CallChecker.varAssign(CallChecker.isCalled(this.globalFitInfo, double[].class, 134, 5408, 5425)[RegressionResults.ADJRSQ_IDX], "CallChecker.isCalled(this.globalFitInfo, double[].class, 134, 5408, 5425)[RegressionResults.ADJRSQ_IDX]", 134, 5408, 5530);
                    }
                }
            }
        } finally {
            _bcornu_methode_context509.methodEnd();
        }
    }

    public double getParameterEstimate(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2359 = new MethodContext(double.class, 150, 5553, 6359);
        try {
            CallChecker.varInit(this, "this", 150, 5553, 6359);
            CallChecker.varInit(index, "index", 150, 5553, 6359);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 150, 5553, 6359);
            CallChecker.varInit(this.containsConstant, "containsConstant", 150, 5553, 6359);
            CallChecker.varInit(this.nobs, "nobs", 150, 5553, 6359);
            CallChecker.varInit(this.rank, "rank", 150, 5553, 6359);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 150, 5553, 6359);
            CallChecker.varInit(this.varCovData, "varCovData", 150, 5553, 6359);
            CallChecker.varInit(this.parameters, "parameters", 150, 5553, 6359);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 150, 5553, 6359);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 150, 5553, 6359);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 150, 5553, 6359);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 150, 5553, 6359);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 150, 5553, 6359);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 150, 5553, 6359);
            if ((parameters) == null) {
                return Double.NaN;
            }
            if ((index < 0) || (index >= (this.parameters.length))) {
                throw new OutOfRangeException(index, 0, ((this.parameters.length) - 1));
            }
            return this.parameters[index];
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2359.methodEnd();
        }
    }

    public double[] getParameterEstimates() {
        MethodContext _bcornu_methode_context2360 = new MethodContext(double[].class, 170, 6366, 6936);
        try {
            CallChecker.varInit(this, "this", 170, 6366, 6936);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 170, 6366, 6936);
            CallChecker.varInit(this.containsConstant, "containsConstant", 170, 6366, 6936);
            CallChecker.varInit(this.nobs, "nobs", 170, 6366, 6936);
            CallChecker.varInit(this.rank, "rank", 170, 6366, 6936);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 170, 6366, 6936);
            CallChecker.varInit(this.varCovData, "varCovData", 170, 6366, 6936);
            CallChecker.varInit(this.parameters, "parameters", 170, 6366, 6936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 170, 6366, 6936);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 170, 6366, 6936);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 170, 6366, 6936);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 170, 6366, 6936);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 170, 6366, 6936);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 170, 6366, 6936);
            if ((this.parameters) == null) {
                return null;
            }
            return MathArrays.copyOf(parameters);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2360.methodEnd();
        }
    }

    public double getStdErrorOfEstimate(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2361 = new MethodContext(double.class, 187, 6943, 7866);
        try {
            CallChecker.varInit(this, "this", 187, 6943, 7866);
            CallChecker.varInit(index, "index", 187, 6943, 7866);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 187, 6943, 7866);
            CallChecker.varInit(this.containsConstant, "containsConstant", 187, 6943, 7866);
            CallChecker.varInit(this.nobs, "nobs", 187, 6943, 7866);
            CallChecker.varInit(this.rank, "rank", 187, 6943, 7866);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 187, 6943, 7866);
            CallChecker.varInit(this.varCovData, "varCovData", 187, 6943, 7866);
            CallChecker.varInit(this.parameters, "parameters", 187, 6943, 7866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 187, 6943, 7866);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 187, 6943, 7866);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 187, 6943, 7866);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 187, 6943, 7866);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 187, 6943, 7866);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 187, 6943, 7866);
            if ((parameters) == null) {
                return Double.NaN;
            }
            if ((index < 0) || (index >= (this.parameters.length))) {
                throw new OutOfRangeException(index, 0, ((this.parameters.length) - 1));
            }
            double var = CallChecker.varInit(((double) (this.getVcvElement(index, index))), "var", 194, 7679, 7724);
            if ((!(Double.isNaN(var))) && (var > (Double.MIN_VALUE))) {
                return FastMath.sqrt(var);
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2361.methodEnd();
        }
    }

    public double[] getStdErrorOfEstimates() {
        MethodContext _bcornu_methode_context2362 = new MethodContext(double[].class, 212, 7873, 8847);
        try {
            CallChecker.varInit(this, "this", 212, 7873, 8847);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 212, 7873, 8847);
            CallChecker.varInit(this.containsConstant, "containsConstant", 212, 7873, 8847);
            CallChecker.varInit(this.nobs, "nobs", 212, 7873, 8847);
            CallChecker.varInit(this.rank, "rank", 212, 7873, 8847);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 212, 7873, 8847);
            CallChecker.varInit(this.varCovData, "varCovData", 212, 7873, 8847);
            CallChecker.varInit(this.parameters, "parameters", 212, 7873, 8847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 212, 7873, 8847);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 212, 7873, 8847);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 212, 7873, 8847);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 212, 7873, 8847);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 212, 7873, 8847);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 212, 7873, 8847);
            if ((parameters) == null) {
                return null;
            }
            double[] se = CallChecker.varInit(new double[this.parameters.length], "se", 216, 8474, 8522);
            for (int i = 0; i < (this.parameters.length); i++) {
                double var = CallChecker.varInit(((double) (this.getVcvElement(i, i))), "var", 218, 8595, 8632);
                if ((!(Double.isNaN(var))) && (var > (Double.MIN_VALUE))) {
                    if (CallChecker.beforeDeref(se, double[].class, 220, 8714, 8715)) {
                        se = CallChecker.beforeCalled(se, double[].class, 220, 8714, 8715);
                        CallChecker.isCalled(se, double[].class, 220, 8714, 8715)[i] = FastMath.sqrt(var);
                        CallChecker.varAssign(CallChecker.isCalled(se, double[].class, 220, 8714, 8715)[i], "CallChecker.isCalled(se, double[].class, 220, 8714, 8715)[i]", 220, 8714, 8740);
                    }
                    continue;
                }
                if (CallChecker.beforeDeref(se, double[].class, 223, 8794, 8795)) {
                    se = CallChecker.beforeCalled(se, double[].class, 223, 8794, 8795);
                    CallChecker.isCalled(se, double[].class, 223, 8794, 8795)[i] = Double.NaN;
                    CallChecker.varAssign(CallChecker.isCalled(se, double[].class, 223, 8794, 8795)[i], "CallChecker.isCalled(se, double[].class, 223, 8794, 8795)[i]", 223, 8794, 8812);
                }
            }
            return se;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2362.methodEnd();
        }
    }

    public double getCovarianceOfParameters(int i, int j) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2363 = new MethodContext(double.class, 240, 8854, 9897);
        try {
            CallChecker.varInit(this, "this", 240, 8854, 9897);
            CallChecker.varInit(j, "j", 240, 8854, 9897);
            CallChecker.varInit(i, "i", 240, 8854, 9897);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 240, 8854, 9897);
            CallChecker.varInit(this.containsConstant, "containsConstant", 240, 8854, 9897);
            CallChecker.varInit(this.nobs, "nobs", 240, 8854, 9897);
            CallChecker.varInit(this.rank, "rank", 240, 8854, 9897);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 240, 8854, 9897);
            CallChecker.varInit(this.varCovData, "varCovData", 240, 8854, 9897);
            CallChecker.varInit(this.parameters, "parameters", 240, 8854, 9897);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 240, 8854, 9897);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 240, 8854, 9897);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 240, 8854, 9897);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 240, 8854, 9897);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 240, 8854, 9897);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 240, 8854, 9897);
            if ((parameters) == null) {
                return Double.NaN;
            }
            if ((i < 0) || (i >= (this.parameters.length))) {
                throw new OutOfRangeException(i, 0, ((this.parameters.length) - 1));
            }
            if ((j < 0) || (j >= (this.parameters.length))) {
                throw new OutOfRangeException(j, 0, ((this.parameters.length) - 1));
            }
            return this.getVcvElement(i, j);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2363.methodEnd();
        }
    }

    public int getNumberOfParameters() {
        MethodContext _bcornu_methode_context2364 = new MethodContext(int.class, 261, 9904, 10323);
        try {
            CallChecker.varInit(this, "this", 261, 9904, 10323);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 261, 9904, 10323);
            CallChecker.varInit(this.containsConstant, "containsConstant", 261, 9904, 10323);
            CallChecker.varInit(this.nobs, "nobs", 261, 9904, 10323);
            CallChecker.varInit(this.rank, "rank", 261, 9904, 10323);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 261, 9904, 10323);
            CallChecker.varInit(this.varCovData, "varCovData", 261, 9904, 10323);
            CallChecker.varInit(this.parameters, "parameters", 261, 9904, 10323);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 261, 9904, 10323);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 261, 9904, 10323);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 261, 9904, 10323);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 261, 9904, 10323);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 261, 9904, 10323);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 261, 9904, 10323);
            if ((this.parameters) == null) {
                return -1;
            }
            return this.parameters.length;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2364.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context2365 = new MethodContext(long.class, 273, 10330, 10561);
        try {
            CallChecker.varInit(this, "this", 273, 10330, 10561);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 273, 10330, 10561);
            CallChecker.varInit(this.containsConstant, "containsConstant", 273, 10330, 10561);
            CallChecker.varInit(this.nobs, "nobs", 273, 10330, 10561);
            CallChecker.varInit(this.rank, "rank", 273, 10330, 10561);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 273, 10330, 10561);
            CallChecker.varInit(this.varCovData, "varCovData", 273, 10330, 10561);
            CallChecker.varInit(this.parameters, "parameters", 273, 10330, 10561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 273, 10330, 10561);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 273, 10330, 10561);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 273, 10330, 10561);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 273, 10330, 10561);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 273, 10330, 10561);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 273, 10330, 10561);
            return this.nobs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2365.methodEnd();
        }
    }

    public double getTotalSumSquares() {
        MethodContext _bcornu_methode_context2366 = new MethodContext(double.class, 287, 10568, 10998);
        try {
            CallChecker.varInit(this, "this", 287, 10568, 10998);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 287, 10568, 10998);
            CallChecker.varInit(this.containsConstant, "containsConstant", 287, 10568, 10998);
            CallChecker.varInit(this.nobs, "nobs", 287, 10568, 10998);
            CallChecker.varInit(this.rank, "rank", 287, 10568, 10998);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 287, 10568, 10998);
            CallChecker.varInit(this.varCovData, "varCovData", 287, 10568, 10998);
            CallChecker.varInit(this.parameters, "parameters", 287, 10568, 10998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 287, 10568, 10998);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 287, 10568, 10998);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 287, 10568, 10998);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 287, 10568, 10998);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 287, 10568, 10998);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 287, 10568, 10998);
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 288, 10965, 10982)) {
                return CallChecker.isCalled(this.globalFitInfo, double[].class, 288, 10965, 10982)[RegressionResults.SST_IDX];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2366.methodEnd();
        }
    }

    public double getRegressionSumSquares() {
        MethodContext _bcornu_methode_context2367 = new MethodContext(double.class, 307, 11005, 11810);
        try {
            CallChecker.varInit(this, "this", 307, 11005, 11810);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 307, 11005, 11810);
            CallChecker.varInit(this.containsConstant, "containsConstant", 307, 11005, 11810);
            CallChecker.varInit(this.nobs, "nobs", 307, 11005, 11810);
            CallChecker.varInit(this.rank, "rank", 307, 11005, 11810);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 307, 11005, 11810);
            CallChecker.varInit(this.varCovData, "varCovData", 307, 11005, 11810);
            CallChecker.varInit(this.parameters, "parameters", 307, 11005, 11810);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 307, 11005, 11810);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 307, 11005, 11810);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 307, 11005, 11810);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 307, 11005, 11810);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 307, 11005, 11810);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 307, 11005, 11810);
            return (CallChecker.isCalled(this.globalFitInfo, double[].class, 308, 11747, 11764)[RegressionResults.SST_IDX]) - (CallChecker.isCalled(this.globalFitInfo, double[].class, 308, 11777, 11794)[RegressionResults.SSE_IDX]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2367.methodEnd();
        }
    }

    public double getErrorSumSquares() {
        MethodContext _bcornu_methode_context2368 = new MethodContext(double.class, 329, 11817, 12632);
        try {
            CallChecker.varInit(this, "this", 329, 11817, 12632);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 329, 11817, 12632);
            CallChecker.varInit(this.containsConstant, "containsConstant", 329, 11817, 12632);
            CallChecker.varInit(this.nobs, "nobs", 329, 11817, 12632);
            CallChecker.varInit(this.rank, "rank", 329, 11817, 12632);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 329, 11817, 12632);
            CallChecker.varInit(this.varCovData, "varCovData", 329, 11817, 12632);
            CallChecker.varInit(this.parameters, "parameters", 329, 11817, 12632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 329, 11817, 12632);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 329, 11817, 12632);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 329, 11817, 12632);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 329, 11817, 12632);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 329, 11817, 12632);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 329, 11817, 12632);
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 330, 12598, 12615)) {
                return CallChecker.isCalled(this.globalFitInfo, double[].class, 330, 12598, 12615)[RegressionResults.SSE_IDX];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2368.methodEnd();
        }
    }

    public double getMeanSquareError() {
        MethodContext _bcornu_methode_context2369 = new MethodContext(double.class, 343, 12639, 13125);
        try {
            CallChecker.varInit(this, "this", 343, 12639, 13125);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 343, 12639, 13125);
            CallChecker.varInit(this.containsConstant, "containsConstant", 343, 12639, 13125);
            CallChecker.varInit(this.nobs, "nobs", 343, 12639, 13125);
            CallChecker.varInit(this.rank, "rank", 343, 12639, 13125);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 343, 12639, 13125);
            CallChecker.varInit(this.varCovData, "varCovData", 343, 12639, 13125);
            CallChecker.varInit(this.parameters, "parameters", 343, 12639, 13125);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 343, 12639, 13125);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 343, 12639, 13125);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 343, 12639, 13125);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 343, 12639, 13125);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 343, 12639, 13125);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 343, 12639, 13125);
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 344, 13091, 13108)) {
                return CallChecker.isCalled(this.globalFitInfo, double[].class, 344, 13091, 13108)[RegressionResults.MSE_IDX];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2369.methodEnd();
        }
    }

    public double getRSquared() {
        MethodContext _bcornu_methode_context2370 = new MethodContext(double.class, 361, 13132, 13794);
        try {
            CallChecker.varInit(this, "this", 361, 13132, 13794);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 361, 13132, 13794);
            CallChecker.varInit(this.containsConstant, "containsConstant", 361, 13132, 13794);
            CallChecker.varInit(this.nobs, "nobs", 361, 13132, 13794);
            CallChecker.varInit(this.rank, "rank", 361, 13132, 13794);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 361, 13132, 13794);
            CallChecker.varInit(this.varCovData, "varCovData", 361, 13132, 13794);
            CallChecker.varInit(this.parameters, "parameters", 361, 13132, 13794);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 361, 13132, 13794);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 361, 13132, 13794);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 361, 13132, 13794);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 361, 13132, 13794);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 361, 13132, 13794);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 361, 13132, 13794);
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 362, 13760, 13777)) {
                return CallChecker.isCalled(this.globalFitInfo, double[].class, 362, 13760, 13777)[RegressionResults.RSQ_IDX];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2370.methodEnd();
        }
    }

    public double getAdjustedRSquared() {
        MethodContext _bcornu_methode_context2371 = new MethodContext(double.class, 379, 13801, 14523);
        try {
            CallChecker.varInit(this, "this", 379, 13801, 14523);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 379, 13801, 14523);
            CallChecker.varInit(this.containsConstant, "containsConstant", 379, 13801, 14523);
            CallChecker.varInit(this.nobs, "nobs", 379, 13801, 14523);
            CallChecker.varInit(this.rank, "rank", 379, 13801, 14523);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 379, 13801, 14523);
            CallChecker.varInit(this.varCovData, "varCovData", 379, 13801, 14523);
            CallChecker.varInit(this.parameters, "parameters", 379, 13801, 14523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 379, 13801, 14523);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 379, 13801, 14523);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 379, 13801, 14523);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 379, 13801, 14523);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 379, 13801, 14523);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 379, 13801, 14523);
            if (CallChecker.beforeDeref(this.globalFitInfo, double[].class, 380, 14486, 14503)) {
                return CallChecker.isCalled(this.globalFitInfo, double[].class, 380, 14486, 14503)[RegressionResults.ADJRSQ_IDX];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2371.methodEnd();
        }
    }

    public boolean hasIntercept() {
        MethodContext _bcornu_methode_context2372 = new MethodContext(boolean.class, 389, 14530, 14904);
        try {
            CallChecker.varInit(this, "this", 389, 14530, 14904);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 389, 14530, 14904);
            CallChecker.varInit(this.containsConstant, "containsConstant", 389, 14530, 14904);
            CallChecker.varInit(this.nobs, "nobs", 389, 14530, 14904);
            CallChecker.varInit(this.rank, "rank", 389, 14530, 14904);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 389, 14530, 14904);
            CallChecker.varInit(this.varCovData, "varCovData", 389, 14530, 14904);
            CallChecker.varInit(this.parameters, "parameters", 389, 14530, 14904);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 389, 14530, 14904);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 389, 14530, 14904);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 389, 14530, 14904);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 389, 14530, 14904);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 389, 14530, 14904);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 389, 14530, 14904);
            return this.containsConstant;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2372.methodEnd();
        }
    }

    private double getVcvElement(int i, int j) {
        MethodContext _bcornu_methode_context2373 = new MethodContext(double.class, 400, 14911, 15921);
        try {
            CallChecker.varInit(this, "this", 400, 14911, 15921);
            CallChecker.varInit(j, "j", 400, 14911, 15921);
            CallChecker.varInit(i, "i", 400, 14911, 15921);
            CallChecker.varInit(this.globalFitInfo, "globalFitInfo", 400, 14911, 15921);
            CallChecker.varInit(this.containsConstant, "containsConstant", 400, 14911, 15921);
            CallChecker.varInit(this.nobs, "nobs", 400, 14911, 15921);
            CallChecker.varInit(this.rank, "rank", 400, 14911, 15921);
            CallChecker.varInit(this.isSymmetricVCD, "isSymmetricVCD", 400, 14911, 15921);
            CallChecker.varInit(this.varCovData, "varCovData", 400, 14911, 15921);
            CallChecker.varInit(this.parameters, "parameters", 400, 14911, 15921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.RegressionResults.serialVersionUID", 400, 14911, 15921);
            CallChecker.varInit(ADJRSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.ADJRSQ_IDX", 400, 14911, 15921);
            CallChecker.varInit(MSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.MSE_IDX", 400, 14911, 15921);
            CallChecker.varInit(RSQ_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.RSQ_IDX", 400, 14911, 15921);
            CallChecker.varInit(SST_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SST_IDX", 400, 14911, 15921);
            CallChecker.varInit(SSE_IDX, "org.apache.commons.math3.stat.regression.RegressionResults.SSE_IDX", 400, 14911, 15921);
            if (this.isSymmetricVCD) {
                if (CallChecker.beforeDeref(this.varCovData, double[][].class, 402, 15232, 15246)) {
                    if ((CallChecker.isCalled(this.varCovData, double[][].class, 402, 15232, 15246).length) > 1) {
                        if (i == j) {
                            if (CallChecker.beforeDeref(varCovData, double[][].class, 405, 15382, 15391)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 405, 15382, 15391)[i], double[].class, 405, 15382, 15394)) {
                                    CallChecker.isCalled(varCovData, double[][].class, 405, 15382, 15391)[i] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 405, 15382, 15391)[i], double[].class, 405, 15382, 15394);
                                    return CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 405, 15382, 15391)[i], double[].class, 405, 15382, 15394)[i];
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            if (CallChecker.beforeDeref(varCovData, double[][].class, 406, 15432, 15441)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 406, 15432, 15441)[j], double[].class, 406, 15432, 15444)) {
                                    CallChecker.isCalled(varCovData, double[][].class, 406, 15432, 15441)[j] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 406, 15432, 15441)[j], double[].class, 406, 15432, 15444);
                                    if (i >= (CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 406, 15432, 15441)[j], double[].class, 406, 15432, 15444).length)) {
                                        if (CallChecker.beforeDeref(varCovData, double[][].class, 407, 15483, 15492)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 407, 15483, 15492)[i], double[].class, 407, 15483, 15495)) {
                                                CallChecker.isCalled(varCovData, double[][].class, 407, 15483, 15492)[i] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 407, 15483, 15492)[i], double[].class, 407, 15483, 15495);
                                                return CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 407, 15483, 15492)[i], double[].class, 407, 15483, 15495)[j];
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else {
                                        if (CallChecker.beforeDeref(varCovData, double[][].class, 409, 15553, 15562)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 409, 15553, 15562)[j], double[].class, 409, 15553, 15565)) {
                                                CallChecker.isCalled(varCovData, double[][].class, 409, 15553, 15562)[j] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 409, 15553, 15562)[j], double[].class, 409, 15553, 15565);
                                                return CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 409, 15553, 15562)[j], double[].class, 409, 15553, 15565)[i];
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else {
                        if (i > j) {
                            if (CallChecker.beforeDeref(varCovData, double[][].class, 413, 15692, 15701)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 413, 15692, 15701)[0], double[].class, 413, 15692, 15704)) {
                                    CallChecker.isCalled(varCovData, double[][].class, 413, 15692, 15701)[0] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 413, 15692, 15701)[0], double[].class, 413, 15692, 15704);
                                    return CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 413, 15692, 15701)[0], double[].class, 413, 15692, 15704)[((((i + 1) * i) / 2) + j)];
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            if (CallChecker.beforeDeref(varCovData, double[][].class, 415, 15780, 15789)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(varCovData, double[][].class, 415, 15780, 15789)[0], double[].class, 415, 15780, 15792)) {
                                    CallChecker.isCalled(varCovData, double[][].class, 415, 15780, 15789)[0] = CallChecker.beforeCalled(CallChecker.isCalled(varCovData, double[][].class, 415, 15780, 15789)[0], double[].class, 415, 15780, 15792);
                                    return CallChecker.isCalled(CallChecker.isCalled(varCovData, double[][].class, 415, 15780, 15789)[0], double[].class, 415, 15780, 15792)[((((j + 1) * j) / 2) + i)];
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(this.varCovData, double[][].class, 419, 15884, 15898)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.varCovData, double[][].class, 419, 15884, 15898)[i], double[].class, 419, 15884, 15901)) {
                        CallChecker.isCalled(this.varCovData, double[][].class, 419, 15884, 15898)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.varCovData, double[][].class, 419, 15884, 15898)[i], double[].class, 419, 15884, 15901);
                        return CallChecker.isCalled(CallChecker.isCalled(this.varCovData, double[][].class, 419, 15884, 15898)[i], double[].class, 419, 15884, 15901)[j];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2373.methodEnd();
        }
    }
}

