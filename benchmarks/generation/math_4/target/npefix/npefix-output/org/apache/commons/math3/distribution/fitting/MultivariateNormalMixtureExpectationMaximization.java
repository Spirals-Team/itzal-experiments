package org.apache.commons.math3.distribution.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.distribution.MixtureMultivariateNormalDistribution;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

public class MultivariateNormalMixtureExpectationMaximization {
    private static class DataRow implements Comparable<MultivariateNormalMixtureExpectationMaximization.DataRow> {
        private final double[] row;

        private Double mean;

        DataRow(final double[] data) {
            ConstructorContext _bcornu_methode_context693 = new ConstructorContext(MultivariateNormalMixtureExpectationMaximization.DataRow.class, 403, 17104, 17484);
            try {
                row = data;
                CallChecker.varAssign(this.row, "this.row", 405, 17280, 17290);
                mean = 0.0;
                CallChecker.varAssign(this.mean, "this.mean", 407, 17333, 17342);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 408, 17376, 17379).length); i++) {
                    if (CallChecker.beforeDeref(data, double[].class, 409, 17420, 17423)) {
                        mean += CallChecker.isCalled(data, double[].class, 409, 17420, 17423)[i];
                        CallChecker.varAssign(this.mean, "this.mean", 409, 17412, 17427);
                    }
                }
                if (CallChecker.beforeDeref(data, double[].class, 411, 17463, 17466)) {
                    mean /= CallChecker.isCalled(data, double[].class, 411, 17463, 17466).length;
                    CallChecker.varAssign(this.mean, "this.mean", 411, 17455, 17474);
                }
            } finally {
                _bcornu_methode_context693.methodEnd();
            }
        }

        public int compareTo(final MultivariateNormalMixtureExpectationMaximization.DataRow other) {
            MethodContext _bcornu_methode_context3047 = new MethodContext(int.class, 419, 17495, 17725);
            try {
                CallChecker.varInit(this, "this", 419, 17495, 17725);
                CallChecker.varInit(other, "other", 419, 17495, 17725);
                CallChecker.varInit(this.mean, "mean", 419, 17495, 17725);
                CallChecker.varInit(this.row, "row", 419, 17495, 17725);
                if (CallChecker.beforeDeref(other, MultivariateNormalMixtureExpectationMaximization.DataRow.class, 420, 17704, 17708)) {
                    if (CallChecker.beforeDeref(mean, Double.class, 420, 17689, 17692)) {
                        mean = CallChecker.beforeCalled(mean, Double.class, 420, 17689, 17692);
                        return CallChecker.isCalled(mean, Double.class, 420, 17689, 17692).compareTo(CallChecker.isCalled(other, MultivariateNormalMixtureExpectationMaximization.DataRow.class, 420, 17704, 17708).mean);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3047.methodEnd();
            }
        }

        @Override
        public boolean equals(Object other) {
            MethodContext _bcornu_methode_context3048 = new MethodContext(boolean.class, 425, 17736, 18063);
            try {
                CallChecker.varInit(this, "this", 425, 17736, 18063);
                CallChecker.varInit(other, "other", 425, 17736, 18063);
                CallChecker.varInit(this.mean, "mean", 425, 17736, 18063);
                CallChecker.varInit(this.row, "row", 425, 17736, 18063);
                if ((this) == other) {
                    return true;
                }
                if (other instanceof MultivariateNormalMixtureExpectationMaximization.DataRow) {
                    if (CallChecker.beforeDeref(other, Object.class, 432, 18000, 18004)) {
                        other = CallChecker.beforeCalled(other, MultivariateNormalMixtureExpectationMaximization.DataRow.class, 432, 18000, 18004);
                        return MathArrays.equals(row, CallChecker.isCalled(((MultivariateNormalMixtureExpectationMaximization.DataRow) (other)), MultivariateNormalMixtureExpectationMaximization.DataRow.class, 432, 18000, 18004).row);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3048.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context3049 = new MethodContext(int.class, 441, 18074, 18194);
            try {
                CallChecker.varInit(this, "this", 441, 18074, 18194);
                CallChecker.varInit(this.mean, "mean", 441, 18074, 18194);
                CallChecker.varInit(this.row, "row", 441, 18074, 18194);
                return Arrays.hashCode(row);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3049.methodEnd();
            }
        }

        public double[] getRow() {
            MethodContext _bcornu_methode_context3050 = new MethodContext(double[].class, 448, 18204, 18348);
            try {
                CallChecker.varInit(this, "this", 448, 18204, 18348);
                CallChecker.varInit(this.mean, "mean", 448, 18204, 18348);
                CallChecker.varInit(this.row, "row", 448, 18204, 18348);
                return row;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3050.methodEnd();
            }
        }
    }

    private static final int DEFAULT_MAX_ITERATIONS = 1000;

    private static final double DEFAULT_THRESHOLD = 1.0E-5;

    private final double[][] data;

    private MixtureMultivariateNormalDistribution fittedModel;

    private double logLikelihood = 0.0;

    public MultivariateNormalMixtureExpectationMaximization(double[][] data) throws DimensionMismatchException, NotStrictlyPositiveException, NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context694 = new ConstructorContext(MultivariateNormalMixtureExpectationMaximization.class, 85, 3370, 4782);
        try {
            if (CallChecker.beforeDeref(data, double[][].class, 89, 4025, 4028)) {
                data = CallChecker.beforeCalled(data, double[][].class, 89, 4025, 4028);
                if ((CallChecker.isCalled(data, double[][].class, 89, 4025, 4028).length) < 1) {
                    if (CallChecker.beforeDeref(data, double[][].class, 90, 4095, 4098)) {
                        data = CallChecker.beforeCalled(data, double[][].class, 90, 4095, 4098);
                        throw new NotStrictlyPositiveException(CallChecker.isCalled(data, double[][].class, 90, 4095, 4098).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            data = CallChecker.beforeCalled(data, double[][].class, 93, 4151, 4154);
            data = CallChecker.beforeCalled(data, double[][].class, 93, 4164, 4167);
            CallChecker.isCalled(data, double[][].class, 93, 4164, 4167)[0] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 93, 4164, 4167)[0], double[].class, 93, 4164, 4170);
            this.data = new double[CallChecker.isCalled(data, double[][].class, 93, 4151, 4154).length][CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 93, 4164, 4167)[0], double[].class, 93, 4164, 4170).length];
            CallChecker.varAssign(this.data, "this.data", 93, 4128, 4179);
            data = CallChecker.beforeCalled(data, double[][].class, 95, 4210, 4213);
            for (int i = 0; i < (CallChecker.isCalled(data, double[][].class, 95, 4210, 4213).length); i++) {
                if (CallChecker.beforeDeref(data, double[][].class, 96, 4246, 4249)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 96, 4246, 4249);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 96, 4246, 4249)[i], double[].class, 96, 4246, 4252)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 96, 4264, 4267)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 96, 4264, 4267);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 96, 4264, 4267)[0], double[].class, 96, 4264, 4270)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 96, 4246, 4249);
                                CallChecker.isCalled(data, double[][].class, 96, 4246, 4249)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 96, 4246, 4249)[i], double[].class, 96, 4246, 4252);
                                data = CallChecker.beforeCalled(data, double[][].class, 96, 4264, 4267);
                                CallChecker.isCalled(data, double[][].class, 96, 4264, 4267)[0] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 96, 4264, 4267)[0], double[].class, 96, 4264, 4270);
                                if ((CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 96, 4246, 4249)[i], double[].class, 96, 4246, 4252).length) != (CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 96, 4264, 4267)[0], double[].class, 96, 4264, 4270).length)) {
                                    if (CallChecker.beforeDeref(data, double[][].class, 98, 4380, 4383)) {
                                        data = CallChecker.beforeCalled(data, double[][].class, 98, 4380, 4383);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 98, 4380, 4383)[i], double[].class, 98, 4380, 4386)) {
                                            if (CallChecker.beforeDeref(data, double[][].class, 99, 4449, 4452)) {
                                                data = CallChecker.beforeCalled(data, double[][].class, 99, 4449, 4452);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 99, 4449, 4452)[0], double[].class, 99, 4449, 4455)) {
                                                    data = CallChecker.beforeCalled(data, double[][].class, 98, 4380, 4383);
                                                    CallChecker.isCalled(data, double[][].class, 98, 4380, 4383)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 98, 4380, 4383)[i], double[].class, 98, 4380, 4386);
                                                    data = CallChecker.beforeCalled(data, double[][].class, 99, 4449, 4452);
                                                    CallChecker.isCalled(data, double[][].class, 99, 4449, 4452)[0] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 99, 4449, 4452)[0], double[].class, 99, 4449, 4455);
                                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 98, 4380, 4383)[i], double[].class, 98, 4380, 4386).length, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 99, 4449, 4452)[0], double[].class, 99, 4449, 4455).length);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(data, double[][].class, 101, 4496, 4499)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 101, 4496, 4499);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 101, 4496, 4499)[i], double[].class, 101, 4496, 4502)) {
                        data = CallChecker.beforeCalled(data, double[][].class, 101, 4496, 4499);
                        CallChecker.isCalled(data, double[][].class, 101, 4496, 4499)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 101, 4496, 4499)[i], double[].class, 101, 4496, 4502);
                        if ((CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 101, 4496, 4499)[i], double[].class, 101, 4496, 4502).length) < 2) {
                            if (CallChecker.beforeDeref(data, double[][].class, 103, 4657, 4660)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 103, 4657, 4660);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 103, 4657, 4660)[i], double[].class, 103, 4657, 4663)) {
                                    data = CallChecker.beforeCalled(data, double[][].class, 103, 4657, 4660);
                                    CallChecker.isCalled(data, double[][].class, 103, 4657, 4660)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 103, 4657, 4660)[i], double[].class, 103, 4657, 4663);
                                    throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 103, 4657, 4660)[i], double[].class, 103, 4657, 4663).length, 2, true);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(this.data, double[][].class, 105, 4709, 4717)) {
                    if (CallChecker.beforeDeref(data, double[][].class, 105, 4742, 4745)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 105, 4751, 4754)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 105, 4751, 4754);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 105, 4751, 4754)[i], double[].class, 105, 4751, 4757)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 105, 4742, 4745);
                                data = CallChecker.beforeCalled(data, double[][].class, 105, 4751, 4754);
                                CallChecker.isCalled(data, double[][].class, 105, 4751, 4754)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 105, 4751, 4754)[i], double[].class, 105, 4751, 4757);
                                CallChecker.isCalled(this.data, double[][].class, 105, 4709, 4717)[i] = MathArrays.copyOf(CallChecker.isCalled(data, double[][].class, 105, 4742, 4745)[i], CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 105, 4751, 4754)[i], double[].class, 105, 4751, 4757).length);
                                CallChecker.varAssign(CallChecker.isCalled(this.data, double[][].class, 105, 4709, 4717)[i], "CallChecker.isCalled(this.data, double[][].class, 105, 4709, 4717)[i]", 105, 4709, 4766);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context694.methodEnd();
        }
    }

    public void fit(final MixtureMultivariateNormalDistribution initialMixture, final int maxIterations, final double threshold) throws DimensionMismatchException, NotStrictlyPositiveException, SingularMatrixException {
        MethodContext _bcornu_methode_context3051 = new MethodContext(void.class, 131, 4789, 11261);
        try {
            CallChecker.varInit(this, "this", 131, 4789, 11261);
            CallChecker.varInit(threshold, "threshold", 131, 4789, 11261);
            CallChecker.varInit(maxIterations, "maxIterations", 131, 4789, 11261);
            CallChecker.varInit(initialMixture, "initialMixture", 131, 4789, 11261);
            CallChecker.varInit(this.logLikelihood, "logLikelihood", 131, 4789, 11261);
            CallChecker.varInit(this.fittedModel, "fittedModel", 131, 4789, 11261);
            CallChecker.varInit(this.data, "data", 131, 4789, 11261);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD", 131, 4789, 11261);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS", 131, 4789, 11261);
            if (maxIterations < 1) {
                throw new NotStrictlyPositiveException(maxIterations);
            }
            if (threshold < (Double.MIN_VALUE)) {
                throw new NotStrictlyPositiveException(threshold);
            }
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.data, double[][].class, 145, 6584, 6587).length)), "n", 145, 6570, 6595);
            CallChecker.isCalled(data, double[][].class, 149, 6769, 6772)[0] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 149, 6769, 6772)[0], double[].class, 149, 6769, 6775);
            final int numCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 149, 6769, 6772)[0], double[].class, 149, 6769, 6775).length)), "numCols", 149, 6606, 6783);
            final int k = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(initialMixture, MixtureMultivariateNormalDistribution.class, 150, 6807, 6820).getComponents(), List.class, 150, 6807, 6836).size())), "k", 150, 6793, 6844);
            final int numMeanColumns = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(initialMixture, MixtureMultivariateNormalDistribution.class, 153, 6894, 6907).getComponents(), List.class, 153, 6894, 6923).get(0), Pair.class, 153, 6894, 6930).getSecond(), MultivariateNormalDistribution.class, 153, 6894, 6942).getMeans(), double[].class, 153, 6894, 6953).length)), "numMeanColumns", 152, 6855, 6961);
            if (numMeanColumns != numCols) {
                throw new DimensionMismatchException(numMeanColumns, numCols);
            }
            int numIterations = CallChecker.varInit(((int) (0)), "numIterations", 159, 7099, 7120);
            double previousLogLikelihood = CallChecker.varInit(((double) (0.0)), "previousLogLikelihood", 160, 7130, 7163);
            logLikelihood = Double.NEGATIVE_INFINITY;
            CallChecker.varAssign(this.logLikelihood, "this.logLikelihood", 162, 7174, 7214);
            if (CallChecker.beforeDeref(initialMixture, MixtureMultivariateNormalDistribution.class, 165, 7336, 7349)) {
                fittedModel = new MixtureMultivariateNormalDistribution(CallChecker.isCalled(initialMixture, MixtureMultivariateNormalDistribution.class, 165, 7336, 7349).getComponents());
                CallChecker.varAssign(this.fittedModel, "this.fittedModel", 165, 7280, 7367);
            }
            while (((numIterations++) <= maxIterations) && ((Math.abs((previousLogLikelihood - (logLikelihood)))) > threshold)) {
                previousLogLikelihood = logLikelihood;
                CallChecker.varAssign(previousLogLikelihood, "previousLogLikelihood", 169, 7511, 7548);
                double sumLogLikelihood = CallChecker.varInit(((double) (0.0)), "sumLogLikelihood", 170, 7562, 7590);
                fittedModel = CallChecker.beforeCalled(fittedModel, MixtureMultivariateNormalDistribution.class, 174, 7725, 7735);
                final List<Pair<Double, MultivariateNormalDistribution>> components = CallChecker.varInit(CallChecker.isCalled(fittedModel, MixtureMultivariateNormalDistribution.class, 174, 7725, 7735).getComponents(), "components", 173, 7605, 7752);
                final double[] weights = CallChecker.varInit(new double[k], "weights", 177, 7824, 7862);
                final MultivariateNormalDistribution[] mvns = CallChecker.varInit(new MultivariateNormalDistribution[k], "mvns", 179, 7877, 7960);
                for (int j = 0; j < k; j++) {
                    if (CallChecker.beforeDeref(components, List.class, 182, 8034, 8043)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 182, 8034, 8043).get(j), Pair.class, 182, 8034, 8050)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(CallChecker.isCalled(components, List.class, 182, 8034, 8043).get(j), Pair.class, 182, 8034, 8050).getFirst())), double.class, 182, 8034, 8061)) {
                                if (CallChecker.beforeDeref(weights, double[].class, 182, 8021, 8027)) {
                                    if (CallChecker.beforeDeref(components, List.class, 182, 8034, 8043)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 182, 8034, 8043).get(j), Pair.class, 182, 8034, 8050)) {
                                            CallChecker.isCalled(weights, double[].class, 182, 8021, 8027)[j] = CallChecker.isCalled(((Double) (CallChecker.isCalled(CallChecker.isCalled(components, List.class, 182, 8034, 8043).get(j), Pair.class, 182, 8034, 8050).getFirst())), double.class, 182, 8034, 8061);
                                            CallChecker.varAssign(CallChecker.isCalled(weights, double[].class, 182, 8021, 8027)[j], "CallChecker.isCalled(weights, double[].class, 182, 8021, 8027)[j]", 182, 8021, 8062);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(mvns, MultivariateNormalDistribution[].class, 183, 8080, 8083)) {
                        if (CallChecker.beforeDeref(components, List.class, 183, 8090, 8099)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 183, 8090, 8099).get(j), Pair.class, 183, 8090, 8106)) {
                                CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 183, 8080, 8083)[j] = CallChecker.isCalled(CallChecker.isCalled(components, List.class, 183, 8090, 8099).get(j), Pair.class, 183, 8090, 8106).getSecond();
                                CallChecker.varAssign(CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 183, 8080, 8083)[j], "CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 183, 8080, 8083)[j]", 183, 8080, 8119);
                            }
                        }
                    }
                }
                final double[][] gamma = CallChecker.varInit(new double[n][k], "gamma", 190, 8351, 8392);
                final double[] gammaSums = CallChecker.varInit(new double[k], "gammaSums", 193, 8454, 8494);
                final double[][] gammaDataProdSums = CallChecker.varInit(new double[k][numCols], "gammaDataProdSums", 196, 8575, 8634);
                for (int i = 0; i < n; i++) {
                    fittedModel = CallChecker.beforeCalled(fittedModel, MixtureMultivariateNormalDistribution.class, 199, 8721, 8731);
                    final double rowDensity = CallChecker.varInit(((double) (CallChecker.isCalled(this.fittedModel, MixtureMultivariateNormalDistribution.class, 199, 8721, 8731).density(CallChecker.isCalled(this.data, double[][].class, 199, 8741, 8744)[i]))), "rowDensity", 199, 8695, 8749);
                    sumLogLikelihood += Math.log(rowDensity);
                    CallChecker.varAssign(sumLogLikelihood, "sumLogLikelihood", 200, 8767, 8807);
                    for (int j = 0; j < k; j++) {
                        if (CallChecker.beforeDeref(gamma, double[][].class, 203, 8876, 8880)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i], double[].class, 203, 8876, 8883)) {
                                if (CallChecker.beforeDeref(weights, double[].class, 203, 8890, 8896)) {
                                    if (CallChecker.beforeDeref(mvns, MultivariateNormalDistribution[].class, 203, 8903, 8906)) {
                                        if (CallChecker.beforeDeref(data, double[][].class, 203, 8919, 8922)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 203, 8903, 8906)[j], MultivariateNormalDistribution.class, 203, 8903, 8909)) {
                                                CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i] = CallChecker.beforeCalled(CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i], double[].class, 203, 8876, 8883);
                                                CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 203, 8903, 8906)[j] = CallChecker.beforeCalled(CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 203, 8903, 8906)[j], MultivariateNormalDistribution.class, 203, 8903, 8909);
                                                CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i], double[].class, 203, 8876, 8883)[j] = ((CallChecker.isCalled(weights, double[].class, 203, 8890, 8896)[j]) * (CallChecker.isCalled(CallChecker.isCalled(mvns, MultivariateNormalDistribution[].class, 203, 8903, 8906)[j], MultivariateNormalDistribution.class, 203, 8903, 8909).density(CallChecker.isCalled(data, double[][].class, 203, 8919, 8922)[i]))) / rowDensity;
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i], double[].class, 203, 8876, 8883)[j], "CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 203, 8876, 8880)[i], double[].class, 203, 8876, 8883)[j]", 203, 8876, 8940);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(gammaSums, double[].class, 204, 8962, 8970)) {
                            if (CallChecker.beforeDeref(gamma, double[][].class, 204, 8978, 8982)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(gamma, double[][].class, 204, 8978, 8982)[i], double[].class, 204, 8978, 8985)) {
                                    CallChecker.isCalled(gamma, double[][].class, 204, 8978, 8982)[i] = CallChecker.beforeCalled(CallChecker.isCalled(gamma, double[][].class, 204, 8978, 8982)[i], double[].class, 204, 8978, 8985);
                                    CallChecker.isCalled(gammaSums, double[].class, 204, 8962, 8970)[j] += CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 204, 8978, 8982)[i], double[].class, 204, 8978, 8985)[j];
                                    CallChecker.varAssign(CallChecker.isCalled(gammaSums, double[].class, 204, 8962, 8970)[j], "CallChecker.isCalled(gammaSums, double[].class, 204, 8962, 8970)[j]", 204, 8962, 8989);
                                }
                            }
                        }
                        for (int col = 0; col < numCols; col++) {
                            if (CallChecker.beforeDeref(gammaDataProdSums, double[][].class, 207, 9078, 9094)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j], double[].class, 207, 9078, 9097)) {
                                    if (CallChecker.beforeDeref(gamma, double[][].class, 207, 9107, 9111)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(gamma, double[][].class, 207, 9107, 9111)[i], double[].class, 207, 9107, 9114)) {
                                            if (CallChecker.beforeDeref(data, double[][].class, 207, 9121, 9124)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 207, 9121, 9124)[i], double[].class, 207, 9121, 9127)) {
                                                    CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j] = CallChecker.beforeCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j], double[].class, 207, 9078, 9097);
                                                    CallChecker.isCalled(gamma, double[][].class, 207, 9107, 9111)[i] = CallChecker.beforeCalled(CallChecker.isCalled(gamma, double[][].class, 207, 9107, 9111)[i], double[].class, 207, 9107, 9114);
                                                    CallChecker.isCalled(data, double[][].class, 207, 9121, 9124)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 207, 9121, 9124)[i], double[].class, 207, 9121, 9127);
                                                    CallChecker.isCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j], double[].class, 207, 9078, 9097)[col] += (CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 207, 9107, 9111)[i], double[].class, 207, 9107, 9114)[j]) * (CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 207, 9121, 9124)[i], double[].class, 207, 9121, 9127)[col]);
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j], double[].class, 207, 9078, 9097)[col], "CallChecker.isCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 207, 9078, 9094)[j], double[].class, 207, 9078, 9097)[col]", 207, 9078, 9133);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                logLikelihood = sumLogLikelihood / n;
                CallChecker.varAssign(this.logLikelihood, "this.logLikelihood", 212, 9202, 9238);
                final double[] newWeights = CallChecker.varInit(new double[k], "newWeights", 216, 9353, 9394);
                final double[][] newMeans = CallChecker.varInit(new double[k][numCols], "newMeans", 217, 9408, 9458);
                for (int j = 0; j < k; j++) {
                    if (CallChecker.beforeDeref(newWeights, double[].class, 220, 9519, 9528)) {
                        if (CallChecker.beforeDeref(gammaSums, double[].class, 220, 9535, 9543)) {
                            CallChecker.isCalled(newWeights, double[].class, 220, 9519, 9528)[j] = (CallChecker.isCalled(gammaSums, double[].class, 220, 9535, 9543)[j]) / n;
                            CallChecker.varAssign(CallChecker.isCalled(newWeights, double[].class, 220, 9519, 9528)[j], "CallChecker.isCalled(newWeights, double[].class, 220, 9519, 9528)[j]", 220, 9519, 9551);
                        }
                    }
                    for (int col = 0; col < numCols; col++) {
                        if (CallChecker.beforeDeref(newMeans, double[][].class, 222, 9631, 9638)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j], double[].class, 222, 9631, 9641)) {
                                if (CallChecker.beforeDeref(gammaDataProdSums, double[][].class, 222, 9650, 9666)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(gammaDataProdSums, double[][].class, 222, 9650, 9666)[j], double[].class, 222, 9650, 9669)) {
                                        if (CallChecker.beforeDeref(gammaSums, double[].class, 222, 9678, 9686)) {
                                            CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j] = CallChecker.beforeCalled(CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j], double[].class, 222, 9631, 9641);
                                            CallChecker.isCalled(gammaDataProdSums, double[][].class, 222, 9650, 9666)[j] = CallChecker.beforeCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 222, 9650, 9666)[j], double[].class, 222, 9650, 9669);
                                            CallChecker.isCalled(CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j], double[].class, 222, 9631, 9641)[col] = (CallChecker.isCalled(CallChecker.isCalled(gammaDataProdSums, double[][].class, 222, 9650, 9666)[j], double[].class, 222, 9650, 9669)[col]) / (CallChecker.isCalled(gammaSums, double[].class, 222, 9678, 9686)[j]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j], double[].class, 222, 9631, 9641)[col], "CallChecker.isCalled(CallChecker.isCalled(newMeans, double[][].class, 222, 9631, 9638)[j], double[].class, 222, 9631, 9641)[col]", 222, 9631, 9690);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                final RealMatrix[] newCovMats = CallChecker.varInit(new RealMatrix[k], "newCovMats", 227, 9784, 9833);
                for (int j = 0; j < k; j++) {
                    if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 229, 9893, 9902)) {
                        CallChecker.isCalled(newCovMats, RealMatrix[].class, 229, 9893, 9902)[j] = new Array2DRowRealMatrix(numCols, numCols);
                        CallChecker.varAssign(CallChecker.isCalled(newCovMats, RealMatrix[].class, 229, 9893, 9902)[j], "CallChecker.isCalled(newCovMats, RealMatrix[].class, 229, 9893, 9902)[j]", 229, 9893, 9951);
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < k; j++) {
                        final RealMatrix vec = CallChecker.varInit(new Array2DRowRealMatrix(MathArrays.ebeSubtract(CallChecker.isCalled(data, double[][].class, 234, 10170, 10173)[i], CallChecker.isCalled(newMeans, double[][].class, 234, 10179, 10186)[j])), "vec", 233, 10075, 10192);
                        CallChecker.isCalled(gamma, double[][].class, 236, 10310, 10314)[i] = CallChecker.beforeCalled(CallChecker.isCalled(gamma, double[][].class, 236, 10310, 10314)[i], double[].class, 236, 10310, 10317);
                        final RealMatrix dataCov = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(vec, RealMatrix.class, 236, 10265, 10267).multiply(CallChecker.isCalled(vec, RealMatrix.class, 236, 10278, 10280).transpose()), RealMatrix.class, 236, 10265, 10293).scalarMultiply(CallChecker.isCalled(CallChecker.isCalled(gamma, double[][].class, 236, 10310, 10314)[i], double[].class, 236, 10310, 10317)[j]), "dataCov", 235, 10214, 10322);
                        if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 237, 10344, 10353)) {
                            if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 237, 10360, 10369)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10360, 10369)[j], RealMatrix.class, 237, 10360, 10372)) {
                                    CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10360, 10369)[j] = CallChecker.beforeCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10360, 10369)[j], RealMatrix.class, 237, 10360, 10372);
                                    CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10344, 10353)[j] = CallChecker.isCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10360, 10369)[j], RealMatrix.class, 237, 10360, 10372).add(dataCov);
                                    CallChecker.varAssign(CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10344, 10353)[j], "CallChecker.isCalled(newCovMats, RealMatrix[].class, 237, 10344, 10353)[j]", 237, 10344, 10386);
                                }
                            }
                        }
                    }
                }
                final double[][][] newCovMatArrays = CallChecker.varInit(new double[k][numCols][numCols], "newCovMatArrays", 242, 10493, 10561);
                for (int j = 0; j < k; j++) {
                    if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 244, 10621, 10630)) {
                        if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 244, 10637, 10646)) {
                            if (CallChecker.beforeDeref(gammaSums, double[].class, 244, 10671, 10679)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10637, 10646)[j], RealMatrix.class, 244, 10637, 10649)) {
                                    CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10637, 10646)[j] = CallChecker.beforeCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10637, 10646)[j], RealMatrix.class, 244, 10637, 10649);
                                    CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10621, 10630)[j] = CallChecker.isCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10637, 10646)[j], RealMatrix.class, 244, 10637, 10649).scalarMultiply((1.0 / (CallChecker.isCalled(gammaSums, double[].class, 244, 10671, 10679)[j])));
                                    CallChecker.varAssign(CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10621, 10630)[j], "CallChecker.isCalled(newCovMats, RealMatrix[].class, 244, 10621, 10630)[j]", 244, 10621, 10684);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(newCovMatArrays, double[][][].class, 245, 10702, 10716)) {
                        if (CallChecker.beforeDeref(newCovMats, RealMatrix[].class, 245, 10723, 10732)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(newCovMats, RealMatrix[].class, 245, 10723, 10732)[j], RealMatrix.class, 245, 10723, 10735)) {
                                CallChecker.isCalled(newCovMats, RealMatrix[].class, 245, 10723, 10732)[j] = CallChecker.beforeCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 245, 10723, 10732)[j], RealMatrix.class, 245, 10723, 10735);
                                CallChecker.isCalled(newCovMatArrays, double[][][].class, 245, 10702, 10716)[j] = CallChecker.isCalled(CallChecker.isCalled(newCovMats, RealMatrix[].class, 245, 10723, 10732)[j], RealMatrix.class, 245, 10723, 10735).getData();
                                CallChecker.varAssign(CallChecker.isCalled(newCovMatArrays, double[][][].class, 245, 10702, 10716)[j], "CallChecker.isCalled(newCovMatArrays, double[][][].class, 245, 10702, 10716)[j]", 245, 10702, 10746);
                            }
                        }
                    }
                }
                fittedModel = new MixtureMultivariateNormalDistribution(newWeights, newMeans, newCovMatArrays);
                CallChecker.varAssign(this.fittedModel, "this.fittedModel", 249, 10811, 11041);
            } 
            if ((Math.abs((previousLogLikelihood - (logLikelihood)))) > threshold) {
                throw new ConvergenceException();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3051.methodEnd();
        }
    }

    public void fit(MixtureMultivariateNormalDistribution initialMixture) throws NotStrictlyPositiveException, SingularMatrixException {
        MethodContext _bcornu_methode_context3052 = new MethodContext(void.class, 277, 11268, 12407);
        try {
            CallChecker.varInit(this, "this", 277, 11268, 12407);
            CallChecker.varInit(initialMixture, "initialMixture", 277, 11268, 12407);
            CallChecker.varInit(this.logLikelihood, "logLikelihood", 277, 11268, 12407);
            CallChecker.varInit(this.fittedModel, "fittedModel", 277, 11268, 12407);
            CallChecker.varInit(this.data, "data", 277, 11268, 12407);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD", 277, 11268, 12407);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS", 277, 11268, 12407);
            fit(initialMixture, MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS, MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3052.methodEnd();
        }
    }

    public static MixtureMultivariateNormalDistribution estimate(final double[][] data, final int numComponents) throws DimensionMismatchException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3053 = new MethodContext(MixtureMultivariateNormalDistribution.class, 301, 12414, 16300);
        try {
            CallChecker.varInit(numComponents, "numComponents", 301, 12414, 16300);
            CallChecker.varInit(data, "data", 301, 12414, 16300);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD", 301, 12414, 16300);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS", 301, 12414, 16300);
            if (CallChecker.beforeDeref(data, double[][].class, 305, 13681, 13684)) {
                if ((CallChecker.isCalled(data, double[][].class, 305, 13681, 13684).length) < 2) {
                    if (CallChecker.beforeDeref(data, double[][].class, 306, 13751, 13754)) {
                        throw new NotStrictlyPositiveException(CallChecker.isCalled(data, double[][].class, 306, 13751, 13754).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (numComponents < 2) {
                throw new NumberIsTooSmallException(numComponents, 2, true);
            }
            if (CallChecker.beforeDeref(data, double[][].class, 311, 13919, 13922)) {
                if (numComponents > (CallChecker.isCalled(data, double[][].class, 311, 13919, 13922).length)) {
                    if (CallChecker.beforeDeref(data, double[][].class, 312, 13997, 14000)) {
                        throw new NumberIsTooLargeException(numComponents, CallChecker.isCalled(data, double[][].class, 312, 13997, 14000).length, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final int numRows = CallChecker.varInit(((int) (CallChecker.isCalled(data, double[][].class, 315, 14056, 14059).length)), "numRows", 315, 14036, 14067);
            CallChecker.isCalled(data, double[][].class, 316, 14097, 14100)[0] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 316, 14097, 14100)[0], double[].class, 316, 14097, 14103);
            final int numCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 316, 14097, 14100)[0], double[].class, 316, 14097, 14103).length)), "numCols", 316, 14077, 14111);
            final MultivariateNormalMixtureExpectationMaximization.DataRow[] sortedData = CallChecker.varInit(new MultivariateNormalMixtureExpectationMaximization.DataRow[numRows], "sortedData", 319, 14147, 14196);
            for (int i = 0; i < numRows; i++) {
                if (CallChecker.beforeDeref(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 321, 14254, 14263)) {
                    if (CallChecker.beforeDeref(data, double[][].class, 321, 14282, 14285)) {
                        CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 321, 14254, 14263)[i] = new MultivariateNormalMixtureExpectationMaximization.DataRow(CallChecker.isCalled(data, double[][].class, 321, 14282, 14285)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 321, 14254, 14263)[i], "CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 321, 14254, 14263)[i]", 321, 14254, 14290);
                    }
                }
            }
            Arrays.sort(sortedData);
            final double weight = CallChecker.varInit(((double) (1.0 / numComponents)), "weight", 326, 14344, 14423);
            final List<Pair<Double, MultivariateNormalDistribution>> components = CallChecker.varInit(new ArrayList<Pair<Double, MultivariateNormalDistribution>>(), "components", 329, 14434, 14634);
            for (int binIndex = 0; binIndex < numComponents; binIndex++) {
                final int minIndex = CallChecker.varInit(((int) ((binIndex * numRows) / numComponents)), "minIndex", 335, 14776, 14904);
                final int maxIndex = CallChecker.varInit(((int) (((binIndex + 1) * numRows) / numComponents)), "maxIndex", 338, 14919, 15053);
                final int numBinRows = CallChecker.varInit(((int) (maxIndex - minIndex)), "numBinRows", 341, 15068, 15173);
                final double[][] binData = CallChecker.varInit(new double[numBinRows][numCols], "binData", 344, 15221, 15279);
                final double[] columnMeans = CallChecker.varInit(new double[numCols], "columnMeans", 347, 15358, 15406);
                for (int i = minIndex, iBin = 0; i < maxIndex; i++ , iBin++) {
                    for (int j = 0; j < numCols; j++) {
                        CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 352, 15623, 15632)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 352, 15623, 15632)[i], MultivariateNormalMixtureExpectationMaximization.DataRow.class, 352, 15623, 15635);
                        final double val = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(sortedData, MultivariateNormalMixtureExpectationMaximization.DataRow[].class, 352, 15623, 15632)[i], MultivariateNormalMixtureExpectationMaximization.DataRow.class, 352, 15623, 15635).getRow(), double[].class, 352, 15623, 15644)[j])), "val", 352, 15604, 15648);
                        if (CallChecker.beforeDeref(columnMeans, double[].class, 353, 15670, 15680)) {
                            CallChecker.isCalled(columnMeans, double[].class, 353, 15670, 15680)[j] += val;
                            CallChecker.varAssign(CallChecker.isCalled(columnMeans, double[].class, 353, 15670, 15680)[j], "CallChecker.isCalled(columnMeans, double[].class, 353, 15670, 15680)[j]", 353, 15670, 15691);
                        }
                        if (CallChecker.beforeDeref(binData, double[][].class, 354, 15713, 15719)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin], double[].class, 354, 15713, 15725)) {
                                CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin] = CallChecker.beforeCalled(CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin], double[].class, 354, 15713, 15725);
                                CallChecker.isCalled(CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin], double[].class, 354, 15713, 15725)[j] = val;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin], double[].class, 354, 15713, 15725)[j], "CallChecker.isCalled(CallChecker.isCalled(binData, double[][].class, 354, 15713, 15719)[iBin], double[].class, 354, 15713, 15725)[j]", 354, 15713, 15735);
                            }
                        }
                    }
                }
                MathArrays.scaleInPlace((1.0 / numBinRows), columnMeans);
                final double[][] covMat = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(new Covariance(binData), Covariance.class, 362, 15938, 15960).getCovarianceMatrix(), RealMatrix.class, 362, 15938, 15982).getData(), "covMat", 361, 15896, 15993);
                final MultivariateNormalDistribution mvn = CallChecker.varInit(new MultivariateNormalDistribution(columnMeans, covMat), "mvn", 363, 16007, 16121);
                if (CallChecker.beforeDeref(components, List.class, 366, 16136, 16145)) {
                    CallChecker.isCalled(components, List.class, 366, 16136, 16145).add(new Pair<Double, MultivariateNormalDistribution>(weight, mvn));
                }
            }
            return new MixtureMultivariateNormalDistribution(components);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MixtureMultivariateNormalDistribution) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3053.methodEnd();
        }
    }

    public double getLogLikelihood() {
        MethodContext _bcornu_methode_context3054 = new MethodContext(double.class, 377, 16307, 16536);
        try {
            CallChecker.varInit(this, "this", 377, 16307, 16536);
            CallChecker.varInit(this.logLikelihood, "logLikelihood", 377, 16307, 16536);
            CallChecker.varInit(this.fittedModel, "fittedModel", 377, 16307, 16536);
            CallChecker.varInit(this.data, "data", 377, 16307, 16536);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD", 377, 16307, 16536);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS", 377, 16307, 16536);
            return logLikelihood;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3054.methodEnd();
        }
    }

    public MixtureMultivariateNormalDistribution getFittedModel() {
        MethodContext _bcornu_methode_context3055 = new MethodContext(MixtureMultivariateNormalDistribution.class, 386, 16543, 16829);
        try {
            CallChecker.varInit(this, "this", 386, 16543, 16829);
            CallChecker.varInit(this.logLikelihood, "logLikelihood", 386, 16543, 16829);
            CallChecker.varInit(this.fittedModel, "fittedModel", 386, 16543, 16829);
            CallChecker.varInit(this.data, "data", 386, 16543, 16829);
            CallChecker.varInit(DEFAULT_THRESHOLD, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_THRESHOLD", 386, 16543, 16829);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.distribution.fitting.MultivariateNormalMixtureExpectationMaximization.DEFAULT_MAX_ITERATIONS", 386, 16543, 16829);
            if (CallChecker.beforeDeref(fittedModel, MixtureMultivariateNormalDistribution.class, 387, 16795, 16805)) {
                fittedModel = CallChecker.beforeCalled(fittedModel, MixtureMultivariateNormalDistribution.class, 387, 16795, 16805);
                return new MixtureMultivariateNormalDistribution(CallChecker.isCalled(fittedModel, MixtureMultivariateNormalDistribution.class, 387, 16795, 16805).getComponents());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((MixtureMultivariateNormalDistribution) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3055.methodEnd();
        }
    }
}

