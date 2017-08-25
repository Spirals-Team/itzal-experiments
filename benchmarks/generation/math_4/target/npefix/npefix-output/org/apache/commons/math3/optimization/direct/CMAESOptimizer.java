package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.MathArrays;

@Deprecated
public class CMAESOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    public static class Sigma implements OptimizationData {
        private final double[] sigma;

        public Sigma(double[] s) throws NotPositiveException {
            ConstructorContext _bcornu_methode_context639 = new ConstructorContext(CMAESOptimizer.Sigma.class, 413, 17637, 18074);
            try {
                s = CallChecker.beforeCalled(s, double[].class, 415, 17895, 17895);
                for (int i = 0; i < (CallChecker.isCalled(s, double[].class, 415, 17895, 17895).length); i++) {
                    if (CallChecker.beforeDeref(s, double[].class, 416, 17932, 17932)) {
                        s = CallChecker.beforeCalled(s, double[].class, 416, 17932, 17932);
                        if ((CallChecker.isCalled(s, double[].class, 416, 17932, 17932)[i]) < 0) {
                            if (CallChecker.beforeDeref(s, double[].class, 417, 17995, 17995)) {
                                s = CallChecker.beforeCalled(s, double[].class, 417, 17995, 17995);
                                throw new NotPositiveException(CallChecker.isCalled(s, double[].class, 417, 17995, 17995)[i]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                s = CallChecker.beforeCalled(s, double[].class, 421, 18055, 18055);
                sigma = CallChecker.isCalled(s, double[].class, 421, 18055, 18055).clone();
                CallChecker.varAssign(this.sigma, "this.sigma", 421, 18047, 18064);
            } finally {
                _bcornu_methode_context639.methodEnd();
            }
        }

        public double[] getSigma() {
            MethodContext _bcornu_methode_context2804 = new MethodContext(double[].class, 427, 18085, 18217);
            try {
                CallChecker.varInit(this, "this", 427, 18085, 18217);
                CallChecker.varInit(this.sigma, "sigma", 427, 18085, 18217);
                if (CallChecker.beforeDeref(sigma, double[].class, 428, 18194, 18198)) {
                    return CallChecker.isCalled(sigma, double[].class, 428, 18194, 18198).clone();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2804.methodEnd();
            }
        }
    }

    public static class PopulationSize implements OptimizationData {
        private final int lambda;

        public PopulationSize(int size) throws NotStrictlyPositiveException {
            ConstructorContext _bcornu_methode_context640 = new ConstructorContext(CMAESOptimizer.PopulationSize.class, 451, 18856, 19212);
            try {
                if (size <= 0) {
                    throw new NotStrictlyPositiveException(size);
                }
                lambda = size;
                CallChecker.varAssign(this.lambda, "this.lambda", 456, 19189, 19202);
            } finally {
                _bcornu_methode_context640.methodEnd();
            }
        }

        public int getPopulationSize() {
            MethodContext _bcornu_methode_context2805 = new MethodContext(int.class, 462, 19223, 19355);
            try {
                CallChecker.varInit(this, "this", 462, 19223, 19355);
                CallChecker.varInit(this.lambda, "lambda", 462, 19223, 19355);
                return lambda;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2805.methodEnd();
            }
        }
    }

    private static class DoubleIndex implements Comparable<CMAESOptimizer.DoubleIndex> {
        private final double value;

        private final int index;

        DoubleIndex(double value, int index) {
            ConstructorContext _bcornu_methode_context641 = new ConstructorContext(CMAESOptimizer.DoubleIndex.class, 968, 41618, 41844);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 969, 41784, 41802);
                this.index = index;
                CallChecker.varAssign(this.index, "this.index", 970, 41816, 41834);
            } finally {
                _bcornu_methode_context641.methodEnd();
            }
        }

        public int compareTo(CMAESOptimizer.DoubleIndex o) {
            MethodContext _bcornu_methode_context2806 = new MethodContext(int.class, 974, 41855, 41981);
            try {
                CallChecker.varInit(this, "this", 974, 41855, 41981);
                CallChecker.varInit(o, "o", 974, 41855, 41981);
                CallChecker.varInit(this.index, "index", 974, 41855, 41981);
                CallChecker.varInit(this.value, "value", 974, 41855, 41981);
                if (CallChecker.beforeDeref(o, CMAESOptimizer.DoubleIndex.class, 975, 41963, 41963)) {
                    o = CallChecker.beforeCalled(o, CMAESOptimizer.DoubleIndex.class, 975, 41963, 41963);
                    return Double.compare(value, CallChecker.isCalled(o, CMAESOptimizer.DoubleIndex.class, 975, 41963, 41963).value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2806.methodEnd();
            }
        }

        @Override
        public boolean equals(Object other) {
            MethodContext _bcornu_methode_context2807 = new MethodContext(boolean.class, 980, 41992, 42332);
            try {
                CallChecker.varInit(this, "this", 980, 41992, 42332);
                CallChecker.varInit(other, "other", 980, 41992, 42332);
                CallChecker.varInit(this.index, "index", 980, 41992, 42332);
                CallChecker.varInit(this.value, "value", 980, 41992, 42332);
                if ((this) == other) {
                    return true;
                }
                if (other instanceof CMAESOptimizer.DoubleIndex) {
                    if (CallChecker.beforeDeref(other, Object.class, 987, 42263, 42267)) {
                        other = CallChecker.beforeCalled(other, CMAESOptimizer.DoubleIndex.class, 987, 42263, 42267);
                        return (Double.compare(value, CallChecker.isCalled(((CMAESOptimizer.DoubleIndex) (other)), CMAESOptimizer.DoubleIndex.class, 987, 42263, 42267).value)) == 0;
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2807.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2808 = new MethodContext(int.class, 995, 42343, 42552);
            try {
                CallChecker.varInit(this, "this", 995, 42343, 42552);
                CallChecker.varInit(this.index, "index", 995, 42343, 42552);
                CallChecker.varInit(this.value, "value", 995, 42343, 42552);
                long bits = CallChecker.varInit(((long) (Double.doubleToLongBits(this.value))), "bits", 996, 42426, 42468);
                return ((int) (((1438542 ^ (bits >>> 32)) ^ bits) & -1));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2808.methodEnd();
            }
        }
    }

    private class FitnessFunction {
        private double valueRange;

        private final boolean isRepairMode;

        public FitnessFunction() {
            ConstructorContext _bcornu_methode_context642 = new ConstructorContext(CMAESOptimizer.FitnessFunction.class, 1017, 43069, 43209);
            try {
                valueRange = 1;
                CallChecker.varAssign(this.valueRange, "this.valueRange", 1018, 43152, 43166);
                isRepairMode = true;
                CallChecker.varAssign(this.isRepairMode, "this.isRepairMode", 1019, 43180, 43199);
            } finally {
                _bcornu_methode_context642.methodEnd();
            }
        }

        public double value(final double[] point) {
            MethodContext _bcornu_methode_context2809 = new MethodContext(double.class, 1026, 43220, 43812);
            try {
                CallChecker.varInit(this, "this", 1026, 43220, 43812);
                CallChecker.varInit(point, "point", 1026, 43220, 43812);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 1026, 43220, 43812);
                CallChecker.varInit(this.valueRange, "valueRange", 1026, 43220, 43812);
                double value = CallChecker.init(double.class);
                if (isRepairMode) {
                    double[] repaired = CallChecker.varInit(repair(point), "repaired", 1029, 43488, 43521);
                    value = (CMAESOptimizer.this.computeObjectiveValue(repaired)) + (penalty(point, repaired));
                    CallChecker.varAssign(value, "value", 1030, 43539, 43645);
                }else {
                    value = CMAESOptimizer.this.computeObjectiveValue(point);
                    CallChecker.varAssign(value, "value", 1033, 43684, 43740);
                }
                if (isMinimize) {
                    return value;
                }else {
                    return -value;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2809.methodEnd();
            }
        }

        public boolean isFeasible(final double[] x) {
            MethodContext _bcornu_methode_context2810 = new MethodContext(boolean.class, 1042, 43823, 44402);
            try {
                CallChecker.varInit(this, "this", 1042, 43823, 44402);
                CallChecker.varInit(x, "x", 1042, 43823, 44402);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 1042, 43823, 44402);
                CallChecker.varInit(this.valueRange, "valueRange", 1042, 43823, 44402);
                final double[] lB = CallChecker.varInit(CMAESOptimizer.this.getLowerBound(), "lB", 1043, 44003, 44058);
                final double[] uB = CallChecker.varInit(CMAESOptimizer.this.getUpperBound(), "uB", 1044, 44072, 44127);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 1046, 44162, 44162).length); i++) {
                    if (CallChecker.beforeDeref(x, double[].class, 1047, 44199, 44199)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 1047, 44206, 44207)) {
                            if ((CallChecker.isCalled(x, double[].class, 1047, 44199, 44199)[i]) < (CallChecker.isCalled(lB, double[].class, 1047, 44206, 44207)[i])) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, double[].class, 1050, 44287, 44287)) {
                        if (CallChecker.beforeDeref(uB, double[].class, 1050, 44294, 44295)) {
                            if ((CallChecker.isCalled(x, double[].class, 1050, 44287, 44287)[i]) > (CallChecker.isCalled(uB, double[].class, 1050, 44294, 44295)[i])) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2810.methodEnd();
            }
        }

        public void setValueRange(double valueRange) {
            MethodContext _bcornu_methode_context2811 = new MethodContext(void.class, 1060, 44413, 44596);
            try {
                CallChecker.varInit(this, "this", 1060, 44413, 44596);
                CallChecker.varInit(valueRange, "valueRange", 1060, 44413, 44596);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 1060, 44413, 44596);
                CallChecker.varInit(this.valueRange, "valueRange", 1060, 44413, 44596);
                this.valueRange = valueRange;
                CallChecker.varAssign(this.valueRange, "this.valueRange", 1061, 44558, 44586);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2811.methodEnd();
            }
        }

        private double[] repair(final double[] x) {
            MethodContext _bcornu_methode_context2812 = new MethodContext(double[].class, 1068, 44607, 45344);
            try {
                CallChecker.varInit(this, "this", 1068, 44607, 45344);
                CallChecker.varInit(x, "x", 1068, 44607, 45344);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 1068, 44607, 45344);
                CallChecker.varInit(this.valueRange, "valueRange", 1068, 44607, 45344);
                final double[] lB = CallChecker.varInit(CMAESOptimizer.this.getLowerBound(), "lB", 1069, 44813, 44868);
                final double[] uB = CallChecker.varInit(CMAESOptimizer.this.getUpperBound(), "uB", 1070, 44882, 44937);
                final double[] repaired = CallChecker.varInit(new double[CallChecker.isCalled(x, double[].class, 1072, 44989, 44989).length], "repaired", 1072, 44952, 44998);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 1073, 45032, 45032).length); i++) {
                    if (CallChecker.beforeDeref(x, double[].class, 1074, 45069, 45069)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 1074, 45076, 45077)) {
                            if ((CallChecker.isCalled(x, double[].class, 1074, 45069, 45069)[i]) < (CallChecker.isCalled(lB, double[].class, 1074, 45076, 45077)[i])) {
                                if (CallChecker.beforeDeref(repaired, double[].class, 1075, 45105, 45112)) {
                                    if (CallChecker.beforeDeref(lB, double[].class, 1075, 45119, 45120)) {
                                        CallChecker.isCalled(repaired, double[].class, 1075, 45105, 45112)[i] = CallChecker.isCalled(lB, double[].class, 1075, 45119, 45120)[i];
                                        CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 1075, 45105, 45112)[i], "CallChecker.isCalled(repaired, double[].class, 1075, 45105, 45112)[i]", 1075, 45105, 45124);
                                    }
                                }
                            }else
                                if (CallChecker.beforeDeref(x, double[].class, 1076, 45153, 45153)) {
                                    if (CallChecker.beforeDeref(uB, double[].class, 1076, 45160, 45161)) {
                                        if ((CallChecker.isCalled(x, double[].class, 1076, 45153, 45153)[i]) > (CallChecker.isCalled(uB, double[].class, 1076, 45160, 45161)[i])) {
                                            if (CallChecker.beforeDeref(repaired, double[].class, 1077, 45189, 45196)) {
                                                if (CallChecker.beforeDeref(uB, double[].class, 1077, 45203, 45204)) {
                                                    CallChecker.isCalled(repaired, double[].class, 1077, 45189, 45196)[i] = CallChecker.isCalled(uB, double[].class, 1077, 45203, 45204)[i];
                                                    CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 1077, 45189, 45196)[i], "CallChecker.isCalled(repaired, double[].class, 1077, 45189, 45196)[i]", 1077, 45189, 45208);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(repaired, double[].class, 1079, 45255, 45262)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 1079, 45269, 45269)) {
                                                    CallChecker.isCalled(repaired, double[].class, 1079, 45255, 45262)[i] = CallChecker.isCalled(x, double[].class, 1079, 45269, 45269)[i];
                                                    CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 1079, 45255, 45262)[i], "CallChecker.isCalled(repaired, double[].class, 1079, 45255, 45262)[i]", 1079, 45255, 45273);
                                                }
                                            }
                                        }
                                    }
                                }
                            
                        }
                    }
                }
                return repaired;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2812.methodEnd();
            }
        }

        private double penalty(final double[] x, final double[] repaired) {
            MethodContext _bcornu_methode_context2813 = new MethodContext(double.class, 1090, 45355, 45892);
            try {
                CallChecker.varInit(this, "this", 1090, 45355, 45892);
                CallChecker.varInit(repaired, "repaired", 1090, 45355, 45892);
                CallChecker.varInit(x, "x", 1090, 45355, 45892);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 1090, 45355, 45892);
                CallChecker.varInit(this.valueRange, "valueRange", 1090, 45355, 45892);
                double penalty = CallChecker.varInit(((double) (0)), "penalty", 1091, 45643, 45661);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 1092, 45695, 45695).length); i++) {
                    double diff = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(x, double[].class, 1093, 45751, 45751)) {
                        if (CallChecker.beforeDeref(repaired, double[].class, 1093, 45758, 45765)) {
                            diff = Math.abs(((CallChecker.isCalled(x, double[].class, 1093, 45751, 45751)[i]) - (CallChecker.isCalled(repaired, double[].class, 1093, 45758, 45765)[i])));
                            CallChecker.varAssign(diff, "diff", 1093, 45751, 45751);
                        }
                    }
                    penalty += diff * (valueRange);
                    CallChecker.varAssign(penalty, "penalty", 1094, 45788, 45816);
                }
                if (isMinimize) {
                    return penalty;
                }else {
                    return -penalty;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2813.methodEnd();
            }
        }
    }

    public static final int DEFAULT_CHECKFEASABLECOUNT = 0;

    public static final double DEFAULT_STOPFITNESS = 0;

    public static final boolean DEFAULT_ISACTIVECMA = true;

    public static final int DEFAULT_MAXITERATIONS = 30000;

    public static final int DEFAULT_DIAGONALONLY = 0;

    public static final RandomGenerator DEFAULT_RANDOMGENERATOR = new MersenneTwister();

    private int lambda;

    private boolean isActiveCMA;

    private int checkFeasableCount;

    private double[] inputSigma;

    private int dimension;

    private int diagonalOnly = 0;

    private boolean isMinimize = true;

    private boolean generateStatistics = false;

    private int maxIterations;

    private double stopFitness;

    private double stopTolUpX;

    private double stopTolX;

    private double stopTolFun;

    private double stopTolHistFun;

    private int mu;

    private double logMu2;

    private RealMatrix weights;

    private double mueff;

    private double sigma;

    private double cc;

    private double cs;

    private double damps;

    private double ccov1;

    private double ccovmu;

    private double chiN;

    private double ccov1Sep;

    private double ccovmuSep;

    private RealMatrix xmean;

    private RealMatrix pc;

    private RealMatrix ps;

    private double normps;

    private RealMatrix B;

    private RealMatrix D;

    private RealMatrix BD;

    private RealMatrix diagD;

    private RealMatrix C;

    private RealMatrix diagC;

    private int iterations;

    private double[] fitnessHistory;

    private int historySize;

    private RandomGenerator random;

    private List<Double> statisticsSigmaHistory = new ArrayList<Double>();

    private List<RealMatrix> statisticsMeanHistory = new ArrayList<RealMatrix>();

    private List<Double> statisticsFitnessHistory = new ArrayList<Double>();

    private List<RealMatrix> statisticsDHistory = new ArrayList<RealMatrix>();

    public CMAESOptimizer() {
        this(0);
        ConstructorContext _bcornu_methode_context643 = new ConstructorContext(CMAESOptimizer.class, 236, 10113, 10491);
        try {
        } finally {
            _bcornu_methode_context643.methodEnd();
        }
    }

    public CMAESOptimizer(int lambda) {
        this(lambda, null, CMAESOptimizer.DEFAULT_MAXITERATIONS, CMAESOptimizer.DEFAULT_STOPFITNESS, CMAESOptimizer.DEFAULT_ISACTIVECMA, CMAESOptimizer.DEFAULT_DIAGONALONLY, CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT, CMAESOptimizer.DEFAULT_RANDOMGENERATOR, false, null);
        ConstructorContext _bcornu_methode_context644 = new ConstructorContext(CMAESOptimizer.class, 246, 10498, 11069);
        try {
        } finally {
            _bcornu_methode_context644.methodEnd();
        }
    }

    @Deprecated
    public CMAESOptimizer(int lambda, double[] inputSigma) {
        this(lambda, inputSigma, CMAESOptimizer.DEFAULT_MAXITERATIONS, CMAESOptimizer.DEFAULT_STOPFITNESS, CMAESOptimizer.DEFAULT_ISACTIVECMA, CMAESOptimizer.DEFAULT_DIAGONALONLY, CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT, CMAESOptimizer.DEFAULT_RANDOMGENERATOR, false);
        ConstructorContext _bcornu_methode_context645 = new ConstructorContext(CMAESOptimizer.class, 262, 11076, 11736);
        try {
        } finally {
            _bcornu_methode_context645.methodEnd();
        }
    }

    @Deprecated
    public CMAESOptimizer(int lambda, double[] inputSigma, int maxIterations, double stopFitness, boolean isActiveCMA, int diagonalOnly, int checkFeasableCount, RandomGenerator random, boolean generateStatistics) {
        this(lambda, inputSigma, maxIterations, stopFitness, isActiveCMA, diagonalOnly, checkFeasableCount, random, generateStatistics, new SimpleValueChecker());
        ConstructorContext _bcornu_methode_context646 = new ConstructorContext(CMAESOptimizer.class, 285, 11743, 13073);
        try {
        } finally {
            _bcornu_methode_context646.methodEnd();
        }
    }

    @Deprecated
    public CMAESOptimizer(int lambda, double[] inputSigma, int maxIterations, double stopFitness, boolean isActiveCMA, int diagonalOnly, int checkFeasableCount, RandomGenerator random, boolean generateStatistics, ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context647 = new ConstructorContext(CMAESOptimizer.class, 314, 13080, 14921);
        try {
            this.lambda = lambda;
            CallChecker.varAssign(this.lambda, "this.lambda", 320, 14506, 14526);
            if (inputSigma == null) {
                this.inputSigma = null;
                CallChecker.varAssign(this.inputSigma, "this.inputSigma", 321, 14536, 14611);
            }else {
                this.inputSigma = ((double[]) (inputSigma.clone()));
                CallChecker.varAssign(this.inputSigma, "this.inputSigma", 321, 14536, 14611);
            }
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 322, 14621, 14655);
            this.stopFitness = stopFitness;
            CallChecker.varAssign(this.stopFitness, "this.stopFitness", 323, 14665, 14695);
            this.isActiveCMA = isActiveCMA;
            CallChecker.varAssign(this.isActiveCMA, "this.isActiveCMA", 324, 14705, 14735);
            this.diagonalOnly = diagonalOnly;
            CallChecker.varAssign(this.diagonalOnly, "this.diagonalOnly", 325, 14745, 14777);
            this.checkFeasableCount = checkFeasableCount;
            CallChecker.varAssign(this.checkFeasableCount, "this.checkFeasableCount", 326, 14787, 14831);
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 327, 14841, 14861);
            this.generateStatistics = generateStatistics;
            CallChecker.varAssign(this.generateStatistics, "this.generateStatistics", 328, 14871, 14915);
        } finally {
            _bcornu_methode_context647.methodEnd();
        }
    }

    public CMAESOptimizer(int maxIterations, double stopFitness, boolean isActiveCMA, int diagonalOnly, int checkFeasableCount, RandomGenerator random, boolean generateStatistics, ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context648 = new ConstructorContext(CMAESOptimizer.class, 346, 14928, 16348);
        try {
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 355, 16048, 16082);
            this.stopFitness = stopFitness;
            CallChecker.varAssign(this.stopFitness, "this.stopFitness", 356, 16092, 16122);
            this.isActiveCMA = isActiveCMA;
            CallChecker.varAssign(this.isActiveCMA, "this.isActiveCMA", 357, 16132, 16162);
            this.diagonalOnly = diagonalOnly;
            CallChecker.varAssign(this.diagonalOnly, "this.diagonalOnly", 358, 16172, 16204);
            this.checkFeasableCount = checkFeasableCount;
            CallChecker.varAssign(this.checkFeasableCount, "this.checkFeasableCount", 359, 16214, 16258);
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 360, 16268, 16288);
            this.generateStatistics = generateStatistics;
            CallChecker.varAssign(this.generateStatistics, "this.generateStatistics", 361, 16298, 16342);
        } finally {
            _bcornu_methode_context648.methodEnd();
        }
    }

    public List<Double> getStatisticsSigmaHistory() {
        MethodContext _bcornu_methode_context2814 = new MethodContext(List.class, 367, 16355, 16504);
        try {
            CallChecker.varInit(this, "this", 367, 16355, 16504);
            CallChecker.varInit(this.evaluations, "evaluations", 367, 16355, 16504);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 367, 16355, 16504);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 367, 16355, 16504);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 367, 16355, 16504);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 367, 16355, 16504);
            CallChecker.varInit(this.random, "random", 367, 16355, 16504);
            CallChecker.varInit(this.historySize, "historySize", 367, 16355, 16504);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 367, 16355, 16504);
            CallChecker.varInit(this.iterations, "iterations", 367, 16355, 16504);
            CallChecker.varInit(this.diagC, "diagC", 367, 16355, 16504);
            CallChecker.varInit(this.C, "C", 367, 16355, 16504);
            CallChecker.varInit(this.diagD, "diagD", 367, 16355, 16504);
            CallChecker.varInit(this.BD, "BD", 367, 16355, 16504);
            CallChecker.varInit(this.D, "D", 367, 16355, 16504);
            CallChecker.varInit(this.B, "B", 367, 16355, 16504);
            CallChecker.varInit(this.normps, "normps", 367, 16355, 16504);
            CallChecker.varInit(this.ps, "ps", 367, 16355, 16504);
            CallChecker.varInit(this.pc, "pc", 367, 16355, 16504);
            CallChecker.varInit(this.xmean, "xmean", 367, 16355, 16504);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 367, 16355, 16504);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 367, 16355, 16504);
            CallChecker.varInit(this.chiN, "chiN", 367, 16355, 16504);
            CallChecker.varInit(this.ccovmu, "ccovmu", 367, 16355, 16504);
            CallChecker.varInit(this.ccov1, "ccov1", 367, 16355, 16504);
            CallChecker.varInit(this.damps, "damps", 367, 16355, 16504);
            CallChecker.varInit(this.cs, "cs", 367, 16355, 16504);
            CallChecker.varInit(this.cc, "cc", 367, 16355, 16504);
            CallChecker.varInit(this.sigma, "sigma", 367, 16355, 16504);
            CallChecker.varInit(this.mueff, "mueff", 367, 16355, 16504);
            CallChecker.varInit(this.weights, "weights", 367, 16355, 16504);
            CallChecker.varInit(this.logMu2, "logMu2", 367, 16355, 16504);
            CallChecker.varInit(this.mu, "mu", 367, 16355, 16504);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 367, 16355, 16504);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 367, 16355, 16504);
            CallChecker.varInit(this.stopTolX, "stopTolX", 367, 16355, 16504);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 367, 16355, 16504);
            CallChecker.varInit(this.stopFitness, "stopFitness", 367, 16355, 16504);
            CallChecker.varInit(this.maxIterations, "maxIterations", 367, 16355, 16504);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 367, 16355, 16504);
            CallChecker.varInit(this.isMinimize, "isMinimize", 367, 16355, 16504);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 367, 16355, 16504);
            CallChecker.varInit(this.dimension, "dimension", 367, 16355, 16504);
            CallChecker.varInit(this.inputSigma, "inputSigma", 367, 16355, 16504);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 367, 16355, 16504);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 367, 16355, 16504);
            CallChecker.varInit(this.lambda, "lambda", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 367, 16355, 16504);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 367, 16355, 16504);
            return statisticsSigmaHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2814.methodEnd();
        }
    }

    public List<RealMatrix> getStatisticsMeanHistory() {
        MethodContext _bcornu_methode_context2815 = new MethodContext(List.class, 374, 16511, 16661);
        try {
            CallChecker.varInit(this, "this", 374, 16511, 16661);
            CallChecker.varInit(this.evaluations, "evaluations", 374, 16511, 16661);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 374, 16511, 16661);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 374, 16511, 16661);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 374, 16511, 16661);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 374, 16511, 16661);
            CallChecker.varInit(this.random, "random", 374, 16511, 16661);
            CallChecker.varInit(this.historySize, "historySize", 374, 16511, 16661);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 374, 16511, 16661);
            CallChecker.varInit(this.iterations, "iterations", 374, 16511, 16661);
            CallChecker.varInit(this.diagC, "diagC", 374, 16511, 16661);
            CallChecker.varInit(this.C, "C", 374, 16511, 16661);
            CallChecker.varInit(this.diagD, "diagD", 374, 16511, 16661);
            CallChecker.varInit(this.BD, "BD", 374, 16511, 16661);
            CallChecker.varInit(this.D, "D", 374, 16511, 16661);
            CallChecker.varInit(this.B, "B", 374, 16511, 16661);
            CallChecker.varInit(this.normps, "normps", 374, 16511, 16661);
            CallChecker.varInit(this.ps, "ps", 374, 16511, 16661);
            CallChecker.varInit(this.pc, "pc", 374, 16511, 16661);
            CallChecker.varInit(this.xmean, "xmean", 374, 16511, 16661);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 374, 16511, 16661);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 374, 16511, 16661);
            CallChecker.varInit(this.chiN, "chiN", 374, 16511, 16661);
            CallChecker.varInit(this.ccovmu, "ccovmu", 374, 16511, 16661);
            CallChecker.varInit(this.ccov1, "ccov1", 374, 16511, 16661);
            CallChecker.varInit(this.damps, "damps", 374, 16511, 16661);
            CallChecker.varInit(this.cs, "cs", 374, 16511, 16661);
            CallChecker.varInit(this.cc, "cc", 374, 16511, 16661);
            CallChecker.varInit(this.sigma, "sigma", 374, 16511, 16661);
            CallChecker.varInit(this.mueff, "mueff", 374, 16511, 16661);
            CallChecker.varInit(this.weights, "weights", 374, 16511, 16661);
            CallChecker.varInit(this.logMu2, "logMu2", 374, 16511, 16661);
            CallChecker.varInit(this.mu, "mu", 374, 16511, 16661);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 374, 16511, 16661);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 374, 16511, 16661);
            CallChecker.varInit(this.stopTolX, "stopTolX", 374, 16511, 16661);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 374, 16511, 16661);
            CallChecker.varInit(this.stopFitness, "stopFitness", 374, 16511, 16661);
            CallChecker.varInit(this.maxIterations, "maxIterations", 374, 16511, 16661);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 374, 16511, 16661);
            CallChecker.varInit(this.isMinimize, "isMinimize", 374, 16511, 16661);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 374, 16511, 16661);
            CallChecker.varInit(this.dimension, "dimension", 374, 16511, 16661);
            CallChecker.varInit(this.inputSigma, "inputSigma", 374, 16511, 16661);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 374, 16511, 16661);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 374, 16511, 16661);
            CallChecker.varInit(this.lambda, "lambda", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 374, 16511, 16661);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 374, 16511, 16661);
            return statisticsMeanHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<RealMatrix>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2815.methodEnd();
        }
    }

    public List<Double> getStatisticsFitnessHistory() {
        MethodContext _bcornu_methode_context2816 = new MethodContext(List.class, 381, 16668, 16823);
        try {
            CallChecker.varInit(this, "this", 381, 16668, 16823);
            CallChecker.varInit(this.evaluations, "evaluations", 381, 16668, 16823);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 381, 16668, 16823);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 381, 16668, 16823);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 381, 16668, 16823);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 381, 16668, 16823);
            CallChecker.varInit(this.random, "random", 381, 16668, 16823);
            CallChecker.varInit(this.historySize, "historySize", 381, 16668, 16823);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 381, 16668, 16823);
            CallChecker.varInit(this.iterations, "iterations", 381, 16668, 16823);
            CallChecker.varInit(this.diagC, "diagC", 381, 16668, 16823);
            CallChecker.varInit(this.C, "C", 381, 16668, 16823);
            CallChecker.varInit(this.diagD, "diagD", 381, 16668, 16823);
            CallChecker.varInit(this.BD, "BD", 381, 16668, 16823);
            CallChecker.varInit(this.D, "D", 381, 16668, 16823);
            CallChecker.varInit(this.B, "B", 381, 16668, 16823);
            CallChecker.varInit(this.normps, "normps", 381, 16668, 16823);
            CallChecker.varInit(this.ps, "ps", 381, 16668, 16823);
            CallChecker.varInit(this.pc, "pc", 381, 16668, 16823);
            CallChecker.varInit(this.xmean, "xmean", 381, 16668, 16823);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 381, 16668, 16823);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 381, 16668, 16823);
            CallChecker.varInit(this.chiN, "chiN", 381, 16668, 16823);
            CallChecker.varInit(this.ccovmu, "ccovmu", 381, 16668, 16823);
            CallChecker.varInit(this.ccov1, "ccov1", 381, 16668, 16823);
            CallChecker.varInit(this.damps, "damps", 381, 16668, 16823);
            CallChecker.varInit(this.cs, "cs", 381, 16668, 16823);
            CallChecker.varInit(this.cc, "cc", 381, 16668, 16823);
            CallChecker.varInit(this.sigma, "sigma", 381, 16668, 16823);
            CallChecker.varInit(this.mueff, "mueff", 381, 16668, 16823);
            CallChecker.varInit(this.weights, "weights", 381, 16668, 16823);
            CallChecker.varInit(this.logMu2, "logMu2", 381, 16668, 16823);
            CallChecker.varInit(this.mu, "mu", 381, 16668, 16823);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 381, 16668, 16823);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 381, 16668, 16823);
            CallChecker.varInit(this.stopTolX, "stopTolX", 381, 16668, 16823);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 381, 16668, 16823);
            CallChecker.varInit(this.stopFitness, "stopFitness", 381, 16668, 16823);
            CallChecker.varInit(this.maxIterations, "maxIterations", 381, 16668, 16823);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 381, 16668, 16823);
            CallChecker.varInit(this.isMinimize, "isMinimize", 381, 16668, 16823);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 381, 16668, 16823);
            CallChecker.varInit(this.dimension, "dimension", 381, 16668, 16823);
            CallChecker.varInit(this.inputSigma, "inputSigma", 381, 16668, 16823);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 381, 16668, 16823);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 381, 16668, 16823);
            CallChecker.varInit(this.lambda, "lambda", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 381, 16668, 16823);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 381, 16668, 16823);
            return statisticsFitnessHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2816.methodEnd();
        }
    }

    public List<RealMatrix> getStatisticsDHistory() {
        MethodContext _bcornu_methode_context2817 = new MethodContext(List.class, 388, 16830, 16971);
        try {
            CallChecker.varInit(this, "this", 388, 16830, 16971);
            CallChecker.varInit(this.evaluations, "evaluations", 388, 16830, 16971);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 388, 16830, 16971);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 388, 16830, 16971);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 388, 16830, 16971);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 388, 16830, 16971);
            CallChecker.varInit(this.random, "random", 388, 16830, 16971);
            CallChecker.varInit(this.historySize, "historySize", 388, 16830, 16971);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 388, 16830, 16971);
            CallChecker.varInit(this.iterations, "iterations", 388, 16830, 16971);
            CallChecker.varInit(this.diagC, "diagC", 388, 16830, 16971);
            CallChecker.varInit(this.C, "C", 388, 16830, 16971);
            CallChecker.varInit(this.diagD, "diagD", 388, 16830, 16971);
            CallChecker.varInit(this.BD, "BD", 388, 16830, 16971);
            CallChecker.varInit(this.D, "D", 388, 16830, 16971);
            CallChecker.varInit(this.B, "B", 388, 16830, 16971);
            CallChecker.varInit(this.normps, "normps", 388, 16830, 16971);
            CallChecker.varInit(this.ps, "ps", 388, 16830, 16971);
            CallChecker.varInit(this.pc, "pc", 388, 16830, 16971);
            CallChecker.varInit(this.xmean, "xmean", 388, 16830, 16971);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 388, 16830, 16971);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 388, 16830, 16971);
            CallChecker.varInit(this.chiN, "chiN", 388, 16830, 16971);
            CallChecker.varInit(this.ccovmu, "ccovmu", 388, 16830, 16971);
            CallChecker.varInit(this.ccov1, "ccov1", 388, 16830, 16971);
            CallChecker.varInit(this.damps, "damps", 388, 16830, 16971);
            CallChecker.varInit(this.cs, "cs", 388, 16830, 16971);
            CallChecker.varInit(this.cc, "cc", 388, 16830, 16971);
            CallChecker.varInit(this.sigma, "sigma", 388, 16830, 16971);
            CallChecker.varInit(this.mueff, "mueff", 388, 16830, 16971);
            CallChecker.varInit(this.weights, "weights", 388, 16830, 16971);
            CallChecker.varInit(this.logMu2, "logMu2", 388, 16830, 16971);
            CallChecker.varInit(this.mu, "mu", 388, 16830, 16971);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 388, 16830, 16971);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 388, 16830, 16971);
            CallChecker.varInit(this.stopTolX, "stopTolX", 388, 16830, 16971);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 388, 16830, 16971);
            CallChecker.varInit(this.stopFitness, "stopFitness", 388, 16830, 16971);
            CallChecker.varInit(this.maxIterations, "maxIterations", 388, 16830, 16971);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 388, 16830, 16971);
            CallChecker.varInit(this.isMinimize, "isMinimize", 388, 16830, 16971);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 388, 16830, 16971);
            CallChecker.varInit(this.dimension, "dimension", 388, 16830, 16971);
            CallChecker.varInit(this.inputSigma, "inputSigma", 388, 16830, 16971);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 388, 16830, 16971);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 388, 16830, 16971);
            CallChecker.varInit(this.lambda, "lambda", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 388, 16830, 16971);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 388, 16830, 16971);
            return statisticsDHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<RealMatrix>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2817.methodEnd();
        }
    }

    @Override
    protected PointValuePair optimizeInternal(int maxEval, MultivariateFunction f, GoalType goalType, OptimizationData... optData) {
        MethodContext _bcornu_methode_context2818 = new MethodContext(PointValuePair.class, 483, 19368, 20478);
        try {
            CallChecker.varInit(this, "this", 483, 19368, 20478);
            CallChecker.varInit(optData, "optData", 483, 19368, 20478);
            CallChecker.varInit(goalType, "goalType", 483, 19368, 20478);
            CallChecker.varInit(f, "f", 483, 19368, 20478);
            CallChecker.varInit(maxEval, "maxEval", 483, 19368, 20478);
            CallChecker.varInit(this.evaluations, "evaluations", 483, 19368, 20478);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 483, 19368, 20478);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 483, 19368, 20478);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 483, 19368, 20478);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 483, 19368, 20478);
            CallChecker.varInit(this.random, "random", 483, 19368, 20478);
            CallChecker.varInit(this.historySize, "historySize", 483, 19368, 20478);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 483, 19368, 20478);
            CallChecker.varInit(this.iterations, "iterations", 483, 19368, 20478);
            CallChecker.varInit(this.diagC, "diagC", 483, 19368, 20478);
            CallChecker.varInit(this.C, "C", 483, 19368, 20478);
            CallChecker.varInit(this.diagD, "diagD", 483, 19368, 20478);
            CallChecker.varInit(this.BD, "BD", 483, 19368, 20478);
            CallChecker.varInit(this.D, "D", 483, 19368, 20478);
            CallChecker.varInit(this.B, "B", 483, 19368, 20478);
            CallChecker.varInit(this.normps, "normps", 483, 19368, 20478);
            CallChecker.varInit(this.ps, "ps", 483, 19368, 20478);
            CallChecker.varInit(this.pc, "pc", 483, 19368, 20478);
            CallChecker.varInit(this.xmean, "xmean", 483, 19368, 20478);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 483, 19368, 20478);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 483, 19368, 20478);
            CallChecker.varInit(this.chiN, "chiN", 483, 19368, 20478);
            CallChecker.varInit(this.ccovmu, "ccovmu", 483, 19368, 20478);
            CallChecker.varInit(this.ccov1, "ccov1", 483, 19368, 20478);
            CallChecker.varInit(this.damps, "damps", 483, 19368, 20478);
            CallChecker.varInit(this.cs, "cs", 483, 19368, 20478);
            CallChecker.varInit(this.cc, "cc", 483, 19368, 20478);
            CallChecker.varInit(this.sigma, "sigma", 483, 19368, 20478);
            CallChecker.varInit(this.mueff, "mueff", 483, 19368, 20478);
            CallChecker.varInit(this.weights, "weights", 483, 19368, 20478);
            CallChecker.varInit(this.logMu2, "logMu2", 483, 19368, 20478);
            CallChecker.varInit(this.mu, "mu", 483, 19368, 20478);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 483, 19368, 20478);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 483, 19368, 20478);
            CallChecker.varInit(this.stopTolX, "stopTolX", 483, 19368, 20478);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 483, 19368, 20478);
            CallChecker.varInit(this.stopFitness, "stopFitness", 483, 19368, 20478);
            CallChecker.varInit(this.maxIterations, "maxIterations", 483, 19368, 20478);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 483, 19368, 20478);
            CallChecker.varInit(this.isMinimize, "isMinimize", 483, 19368, 20478);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 483, 19368, 20478);
            CallChecker.varInit(this.dimension, "dimension", 483, 19368, 20478);
            CallChecker.varInit(this.inputSigma, "inputSigma", 483, 19368, 20478);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 483, 19368, 20478);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 483, 19368, 20478);
            CallChecker.varInit(this.lambda, "lambda", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 483, 19368, 20478);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 483, 19368, 20478);
            parseOptimizationData(optData);
            return super.optimizeInternal(maxEval, f, goalType, optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2818.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context2819 = new MethodContext(PointValuePair.class, 496, 20485, 27419);
        try {
            CallChecker.varInit(this, "this", 496, 20485, 27419);
            CallChecker.varInit(this.evaluations, "evaluations", 496, 20485, 27419);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 496, 20485, 27419);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 496, 20485, 27419);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 496, 20485, 27419);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 496, 20485, 27419);
            CallChecker.varInit(this.random, "random", 496, 20485, 27419);
            CallChecker.varInit(this.historySize, "historySize", 496, 20485, 27419);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 496, 20485, 27419);
            CallChecker.varInit(this.iterations, "iterations", 496, 20485, 27419);
            CallChecker.varInit(this.diagC, "diagC", 496, 20485, 27419);
            CallChecker.varInit(this.C, "C", 496, 20485, 27419);
            CallChecker.varInit(this.diagD, "diagD", 496, 20485, 27419);
            CallChecker.varInit(this.BD, "BD", 496, 20485, 27419);
            CallChecker.varInit(this.D, "D", 496, 20485, 27419);
            CallChecker.varInit(this.B, "B", 496, 20485, 27419);
            CallChecker.varInit(this.normps, "normps", 496, 20485, 27419);
            CallChecker.varInit(this.ps, "ps", 496, 20485, 27419);
            CallChecker.varInit(this.pc, "pc", 496, 20485, 27419);
            CallChecker.varInit(this.xmean, "xmean", 496, 20485, 27419);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 496, 20485, 27419);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 496, 20485, 27419);
            CallChecker.varInit(this.chiN, "chiN", 496, 20485, 27419);
            CallChecker.varInit(this.ccovmu, "ccovmu", 496, 20485, 27419);
            CallChecker.varInit(this.ccov1, "ccov1", 496, 20485, 27419);
            CallChecker.varInit(this.damps, "damps", 496, 20485, 27419);
            CallChecker.varInit(this.cs, "cs", 496, 20485, 27419);
            CallChecker.varInit(this.cc, "cc", 496, 20485, 27419);
            CallChecker.varInit(this.sigma, "sigma", 496, 20485, 27419);
            CallChecker.varInit(this.mueff, "mueff", 496, 20485, 27419);
            CallChecker.varInit(this.weights, "weights", 496, 20485, 27419);
            CallChecker.varInit(this.logMu2, "logMu2", 496, 20485, 27419);
            CallChecker.varInit(this.mu, "mu", 496, 20485, 27419);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 496, 20485, 27419);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 496, 20485, 27419);
            CallChecker.varInit(this.stopTolX, "stopTolX", 496, 20485, 27419);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 496, 20485, 27419);
            CallChecker.varInit(this.stopFitness, "stopFitness", 496, 20485, 27419);
            CallChecker.varInit(this.maxIterations, "maxIterations", 496, 20485, 27419);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 496, 20485, 27419);
            CallChecker.varInit(this.isMinimize, "isMinimize", 496, 20485, 27419);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 496, 20485, 27419);
            CallChecker.varInit(this.dimension, "dimension", 496, 20485, 27419);
            CallChecker.varInit(this.inputSigma, "inputSigma", 496, 20485, 27419);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 496, 20485, 27419);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 496, 20485, 27419);
            CallChecker.varInit(this.lambda, "lambda", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 496, 20485, 27419);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 496, 20485, 27419);
            checkParameters();
            final GoalType npe_invocation_var708 = getGoalType();
            if (CallChecker.beforeDeref(npe_invocation_var708, GoalType.class, 499, 20693, 20705)) {
                isMinimize = CallChecker.isCalled(npe_invocation_var708, GoalType.class, 499, 20693, 20705).equals(GoalType.MINIMIZE);
                CallChecker.varAssign(this.isMinimize, "this.isMinimize", 499, 20680, 20732);
            }
            final CMAESOptimizer.FitnessFunction fitfun = CallChecker.varInit(new CMAESOptimizer.FitnessFunction(), "fitfun", 500, 20742, 20794);
            final double[] guess = CallChecker.varInit(getStartPoint(), "guess", 501, 20804, 20842);
            if (CallChecker.beforeDeref(guess, double[].class, 503, 20923, 20927)) {
                dimension = CallChecker.isCalled(guess, double[].class, 503, 20923, 20927).length;
                CallChecker.varAssign(this.dimension, "this.dimension", 503, 20911, 20935);
            }
            initializeCMA(guess);
            iterations = 0;
            CallChecker.varAssign(this.iterations, "this.iterations", 505, 20975, 20989);
            double bestValue = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 506, 21018, 21023)) {
                bestValue = CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 506, 21018, 21023).value(guess);
                CallChecker.varAssign(bestValue, "bestValue", 506, 21018, 21023);
            }
            CMAESOptimizer.push(fitnessHistory, bestValue);
            PointValuePair optimum = CallChecker.varInit(new PointValuePair(getStartPoint(), (isMinimize ? bestValue : -bestValue)), "optimum", 508, 21088, 21201);
            PointValuePair lastResult = CallChecker.varInit(null, "lastResult", 510, 21211, 21243);
            generationLoop : for (iterations = 1; (iterations) <= (maxIterations); (iterations)++) {
                CallChecker.varAssign(this.iterations, "this.iterations", 515, 21365, 21378);
                final RealMatrix arz = CallChecker.varInit(randn1(dimension, lambda), "arz", 517, 21438, 21540);
                final RealMatrix arx = CallChecker.varInit(CMAESOptimizer.zeros(dimension, lambda), "arx", 518, 21554, 21601);
                final double[] fitness = CallChecker.varInit(new double[lambda], "fitness", 519, 21615, 21658);
                for (int k = 0; k < (lambda); k++) {
                    RealMatrix arxk = CallChecker.varInit(null, "arxk", 522, 21764, 21786);
                    for (int i = 0; i < ((checkFeasableCount) + 1); i++) {
                        if ((diagonalOnly) <= 0) {
                            if (CallChecker.beforeDeref(arz, RealMatrix.class, 525, 21953, 21955)) {
                                if (CallChecker.beforeDeref(BD, RealMatrix.class, 525, 21941, 21942)) {
                                    BD = CallChecker.beforeCalled(BD, RealMatrix.class, 525, 21941, 21942);
                                    final RealMatrix npe_invocation_var709 = CallChecker.isCalled(BD, RealMatrix.class, 525, 21941, 21942).multiply(CallChecker.isCalled(arz, RealMatrix.class, 525, 21953, 21955).getColumnMatrix(k));
                                    if (CallChecker.beforeDeref(npe_invocation_var709, RealMatrix.class, 525, 21941, 21975)) {
                                        if (CallChecker.beforeDeref(xmean, RealMatrix.class, 525, 21931, 21935)) {
                                            xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 525, 21931, 21935);
                                            arxk = CallChecker.isCalled(xmean, RealMatrix.class, 525, 21931, 21935).add(CallChecker.isCalled(npe_invocation_var709, RealMatrix.class, 525, 21941, 21975).scalarMultiply(sigma));
                                            CallChecker.varAssign(arxk, "arxk", 525, 21924, 22041);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(arz, RealMatrix.class, 528, 22150, 22152)) {
                                final RealMatrix npe_invocation_var710 = CMAESOptimizer.times(diagD, CallChecker.isCalled(arz, RealMatrix.class, 528, 22150, 22152).getColumnMatrix(k));
                                if (CallChecker.beforeDeref(npe_invocation_var710, RealMatrix.class, 528, 22138, 22172)) {
                                    if (CallChecker.beforeDeref(xmean, RealMatrix.class, 528, 22128, 22132)) {
                                        xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 528, 22128, 22132);
                                        arxk = CallChecker.isCalled(xmean, RealMatrix.class, 528, 22128, 22132).add(CallChecker.isCalled(npe_invocation_var710, RealMatrix.class, 528, 22138, 22172).scalarMultiply(sigma));
                                        CallChecker.varAssign(arxk, "arxk", 528, 22121, 22238);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(arxk, RealMatrix.class, 532, 22355, 22358)) {
                            if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 532, 22337, 22342)) {
                                arxk = CallChecker.beforeCalled(arxk, RealMatrix.class, 532, 22355, 22358);
                                if ((i >= (checkFeasableCount)) || (CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 532, 22337, 22342).isFeasible(CallChecker.isCalled(arxk, RealMatrix.class, 532, 22355, 22358).getColumn(0)))) {
                                    break;
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(arz, RealMatrix.class, 536, 22509, 22511)) {
                            CallChecker.isCalled(arz, RealMatrix.class, 536, 22509, 22511).setColumn(k, randn(dimension));
                        }
                    }
                    CMAESOptimizer.copyColumn(arxk, 0, arx, k);
                    TryContext _bcornu_try_context_62 = new TryContext(62, CMAESOptimizer.class, "org.apache.commons.math3.exception.TooManyEvaluationsException");
                    try {
                        if (CallChecker.beforeDeref(fitness, double[].class, 540, 22650, 22656)) {
                            if (CallChecker.beforeDeref(arx, RealMatrix.class, 540, 22676, 22678)) {
                                if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 540, 22663, 22668)) {
                                    CallChecker.isCalled(fitness, double[].class, 540, 22650, 22656)[k] = CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 540, 22663, 22668).value(CallChecker.isCalled(arx, RealMatrix.class, 540, 22676, 22678).getColumn(k));
                                    CallChecker.varAssign(CallChecker.isCalled(fitness, double[].class, 540, 22650, 22656)[k], "CallChecker.isCalled(fitness, double[].class, 540, 22650, 22656)[k]", 540, 22650, 22693);
                                }
                            }
                        }
                    } catch (TooManyEvaluationsException e) {
                        _bcornu_try_context_62.catchStart(62);
                        break generationLoop;
                    } finally {
                        _bcornu_try_context_62.finallyStart(62);
                    }
                }
                final int[] arindex = CallChecker.varInit(sortedIndices(fitness), "arindex", 546, 22926, 22970);
                final RealMatrix xold = CallChecker.varInit(xmean, "xold", 548, 22984, 23085);
                final RealMatrix bestArx = CallChecker.varInit(CMAESOptimizer.selectColumns(arx, MathArrays.copyOf(arindex, mu)), "bestArx", 549, 23134, 23211);
                if (CallChecker.beforeDeref(bestArx, RealMatrix.class, 550, 23233, 23239)) {
                    xmean = CallChecker.isCalled(bestArx, RealMatrix.class, 550, 23233, 23239).multiply(weights);
                    CallChecker.varAssign(this.xmean, "this.xmean", 550, 23225, 23258);
                }
                final RealMatrix bestArz = CallChecker.varInit(CMAESOptimizer.selectColumns(arz, MathArrays.copyOf(arindex, mu)), "bestArz", 551, 23272, 23349);
                final RealMatrix zmean = CallChecker.varInit(CallChecker.isCalled(bestArz, RealMatrix.class, 552, 23388, 23394).multiply(weights), "zmean", 552, 23363, 23413);
                final boolean hsig = CallChecker.varInit(((boolean) (updateEvolutionPaths(zmean, xold))), "hsig", 553, 23427, 23481);
                if ((diagonalOnly) <= 0) {
                    updateCovariance(hsig, bestArx, arz, arindex, xold);
                }else {
                    updateCovarianceDiagonalOnly(hsig, bestArz);
                }
                sigma *= Math.exp(Math.min(1, (((((normps) / (chiN)) - 1) * (cs)) / (damps))));
                CallChecker.varAssign(this.sigma, "this.sigma", 560, 23744, 23806);
                final double bestFitness = CallChecker.varInit(((double) (CallChecker.isCalled(fitness, double[].class, 561, 23847, 23853)[CallChecker.isCalled(arindex, int[].class, 561, 23855, 23861)[0]])), "bestFitness", 561, 23820, 23866);
                final double worstFitness = CallChecker.varInit(((double) (CallChecker.isCalled(fitness, double[].class, 562, 23908, 23914)[CallChecker.isCalled(arindex, int[].class, 562, 23916, 23922)[((CallChecker.isCalled(arindex, int[].class, 562, 23924, 23930).length) - 1)]])), "worstFitness", 562, 23880, 23944);
                if (bestValue > bestFitness) {
                    bestValue = bestFitness;
                    CallChecker.varAssign(bestValue, "bestValue", 564, 24005, 24028);
                    lastResult = optimum;
                    CallChecker.varAssign(lastResult, "lastResult", 565, 24046, 24066);
                    if (CallChecker.beforeDeref(bestArx, RealMatrix.class, 566, 24127, 24133)) {
                        if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 566, 24113, 24118)) {
                            optimum = new PointValuePair(CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 566, 24113, 24118).repair(CallChecker.isCalled(bestArx, RealMatrix.class, 566, 24127, 24133).getColumn(0)), (isMinimize ? bestFitness : -bestFitness));
                            CallChecker.varAssign(optimum, "optimum", 566, 24084, 24235);
                        }
                    }
                    if ((((getConvergenceChecker()) != null) && (lastResult != null)) && (getConvergenceChecker().converged(iterations, optimum, lastResult))) {
                        break generationLoop;
                    }
                }
                if (((stopFitness) != 0) && (bestFitness < (isMinimize ? stopFitness : -(stopFitness)))) {
                    break generationLoop;
                }
                final double[] sqrtDiagC = CallChecker.varInit(CallChecker.isCalled(CMAESOptimizer.sqrt(diagC), RealMatrix.class, 578, 24755, 24765).getColumn(0), "sqrtDiagC", 578, 24728, 24779);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 579, 24816, 24817);
                final double[] pcCol = CallChecker.varInit(CallChecker.isCalled(pc, RealMatrix.class, 579, 24816, 24817).getColumn(0), "pcCol", 579, 24793, 24831);
                for (int i = 0; i < (dimension); i++) {
                    if (CallChecker.beforeDeref(pcCol, double[].class, 581, 24929, 24933)) {
                        if (CallChecker.beforeDeref(sqrtDiagC, double[].class, 581, 24940, 24948)) {
                            if (((sigma) * (Math.max(Math.abs(CallChecker.isCalled(pcCol, double[].class, 581, 24929, 24933)[i]), CallChecker.isCalled(sqrtDiagC, double[].class, 581, 24940, 24948)[i]))) > (stopTolX)) {
                                break;
                            }
                        }
                    }
                    if (i >= ((dimension) - 1)) {
                        break generationLoop;
                    }
                }
                for (int i = 0; i < (dimension); i++) {
                    if (CallChecker.beforeDeref(sqrtDiagC, double[].class, 589, 25207, 25215)) {
                        if (((sigma) * (CallChecker.isCalled(sqrtDiagC, double[].class, 589, 25207, 25215)[i])) > (stopTolUpX)) {
                            break generationLoop;
                        }
                    }
                }
                final double historyBest = CallChecker.varInit(((double) (CMAESOptimizer.min(this.fitnessHistory))), "historyBest", 593, 25322, 25368);
                final double historyWorst = CallChecker.varInit(((double) (CMAESOptimizer.max(this.fitnessHistory))), "historyWorst", 594, 25382, 25429);
                if (((iterations) > 2) && (((Math.max(historyWorst, worstFitness)) - (Math.min(historyBest, bestFitness))) < (stopTolFun))) {
                    break generationLoop;
                }
                if (CallChecker.beforeDeref(fitnessHistory, double[].class, 600, 25668, 25681)) {
                    fitnessHistory = CallChecker.beforeCalled(fitnessHistory, double[].class, 600, 25668, 25681);
                    if (((iterations) > (CallChecker.isCalled(fitnessHistory, double[].class, 600, 25668, 25681).length)) && ((historyWorst - historyBest) < (stopTolHistFun))) {
                        break generationLoop;
                    }
                }
                if (((CMAESOptimizer.max(diagD)) / (CMAESOptimizer.min(diagD))) > 1.0E7) {
                    break generationLoop;
                }
                if ((getConvergenceChecker()) != null) {
                    final PointValuePair current = CallChecker.varInit(new PointValuePair(CallChecker.isCalled(bestArx, RealMatrix.class, 611, 26152, 26158).getColumn(0), (isMinimize ? bestFitness : -bestFitness)), "current", 610, 26082, 26255);
                    if ((lastResult != null) && (getConvergenceChecker().converged(iterations, current, lastResult))) {
                        break generationLoop;
                    }
                    lastResult = current;
                    CallChecker.varAssign(lastResult, "lastResult", 617, 26469, 26489);
                }
                if (CallChecker.beforeDeref(arindex, int[].class, 620, 26622, 26628)) {
                    if (CallChecker.beforeDeref(fitness, double[].class, 620, 26614, 26620)) {
                        if (bestValue == (CallChecker.isCalled(fitness, double[].class, 620, 26614, 26620)[CallChecker.isCalled(arindex, int[].class, 620, 26622, 26628)[((int) (0.1 + ((lambda) / 4.0)))]])) {
                            sigma = (sigma) * (Math.exp((0.2 + ((cs) / (damps)))));
                            CallChecker.varAssign(this.sigma, "this.sigma", 621, 26672, 26714);
                        }
                    }
                }
                if (((iterations) > 2) && (((Math.max(historyWorst, bestFitness)) - (Math.min(historyBest, bestFitness))) == 0)) {
                    sigma = (sigma) * (Math.exp((0.2 + ((cs) / (damps)))));
                    CallChecker.varAssign(this.sigma, "this.sigma", 625, 26877, 26919);
                }
                CMAESOptimizer.push(fitnessHistory, bestFitness);
                if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 629, 27030, 27035)) {
                    CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 629, 27030, 27035).setValueRange((worstFitness - bestFitness));
                }
                if (generateStatistics) {
                    if (CallChecker.beforeDeref(statisticsSigmaHistory, List.class, 631, 27132, 27153)) {
                        statisticsSigmaHistory = CallChecker.beforeCalled(statisticsSigmaHistory, List.class, 631, 27132, 27153);
                        CallChecker.isCalled(statisticsSigmaHistory, List.class, 631, 27132, 27153).add(sigma);
                    }
                    if (CallChecker.beforeDeref(statisticsFitnessHistory, List.class, 632, 27183, 27206)) {
                        statisticsFitnessHistory = CallChecker.beforeCalled(statisticsFitnessHistory, List.class, 632, 27183, 27206);
                        CallChecker.isCalled(statisticsFitnessHistory, List.class, 632, 27183, 27206).add(bestFitness);
                    }
                    if (CallChecker.beforeDeref(xmean, RealMatrix.class, 633, 27268, 27272)) {
                        if (CallChecker.beforeDeref(statisticsMeanHistory, List.class, 633, 27242, 27262)) {
                            xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 633, 27268, 27272);
                            statisticsMeanHistory = CallChecker.beforeCalled(statisticsMeanHistory, List.class, 633, 27242, 27262);
                            CallChecker.isCalled(statisticsMeanHistory, List.class, 633, 27242, 27262).add(CallChecker.isCalled(xmean, RealMatrix.class, 633, 27268, 27272).transpose());
                        }
                    }
                    if (CallChecker.beforeDeref(diagD, RealMatrix.class, 634, 27327, 27331)) {
                        diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 634, 27327, 27331);
                        final RealMatrix npe_invocation_var711 = CallChecker.isCalled(diagD, RealMatrix.class, 634, 27327, 27331).transpose();
                        if (CallChecker.beforeDeref(npe_invocation_var711, RealMatrix.class, 634, 27327, 27343)) {
                            if (CallChecker.beforeDeref(statisticsDHistory, List.class, 634, 27304, 27321)) {
                                statisticsDHistory = CallChecker.beforeCalled(statisticsDHistory, List.class, 634, 27304, 27321);
                                CallChecker.isCalled(statisticsDHistory, List.class, 634, 27304, 27321).add(CallChecker.isCalled(npe_invocation_var711, RealMatrix.class, 634, 27327, 27343).scalarMultiply(100000.0));
                            }
                        }
                    }
                }
            }
            return optimum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2819.methodEnd();
        }
    }

    private void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context2820 = new MethodContext(void.class, 650, 27426, 28276);
        try {
            CallChecker.varInit(this, "this", 650, 27426, 28276);
            CallChecker.varInit(optData, "optData", 650, 27426, 28276);
            CallChecker.varInit(this.evaluations, "evaluations", 650, 27426, 28276);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 650, 27426, 28276);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 650, 27426, 28276);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 650, 27426, 28276);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 650, 27426, 28276);
            CallChecker.varInit(this.random, "random", 650, 27426, 28276);
            CallChecker.varInit(this.historySize, "historySize", 650, 27426, 28276);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 650, 27426, 28276);
            CallChecker.varInit(this.iterations, "iterations", 650, 27426, 28276);
            CallChecker.varInit(this.diagC, "diagC", 650, 27426, 28276);
            CallChecker.varInit(this.C, "C", 650, 27426, 28276);
            CallChecker.varInit(this.diagD, "diagD", 650, 27426, 28276);
            CallChecker.varInit(this.BD, "BD", 650, 27426, 28276);
            CallChecker.varInit(this.D, "D", 650, 27426, 28276);
            CallChecker.varInit(this.B, "B", 650, 27426, 28276);
            CallChecker.varInit(this.normps, "normps", 650, 27426, 28276);
            CallChecker.varInit(this.ps, "ps", 650, 27426, 28276);
            CallChecker.varInit(this.pc, "pc", 650, 27426, 28276);
            CallChecker.varInit(this.xmean, "xmean", 650, 27426, 28276);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 650, 27426, 28276);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 650, 27426, 28276);
            CallChecker.varInit(this.chiN, "chiN", 650, 27426, 28276);
            CallChecker.varInit(this.ccovmu, "ccovmu", 650, 27426, 28276);
            CallChecker.varInit(this.ccov1, "ccov1", 650, 27426, 28276);
            CallChecker.varInit(this.damps, "damps", 650, 27426, 28276);
            CallChecker.varInit(this.cs, "cs", 650, 27426, 28276);
            CallChecker.varInit(this.cc, "cc", 650, 27426, 28276);
            CallChecker.varInit(this.sigma, "sigma", 650, 27426, 28276);
            CallChecker.varInit(this.mueff, "mueff", 650, 27426, 28276);
            CallChecker.varInit(this.weights, "weights", 650, 27426, 28276);
            CallChecker.varInit(this.logMu2, "logMu2", 650, 27426, 28276);
            CallChecker.varInit(this.mu, "mu", 650, 27426, 28276);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 650, 27426, 28276);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 650, 27426, 28276);
            CallChecker.varInit(this.stopTolX, "stopTolX", 650, 27426, 28276);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 650, 27426, 28276);
            CallChecker.varInit(this.stopFitness, "stopFitness", 650, 27426, 28276);
            CallChecker.varInit(this.maxIterations, "maxIterations", 650, 27426, 28276);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 650, 27426, 28276);
            CallChecker.varInit(this.isMinimize, "isMinimize", 650, 27426, 28276);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 650, 27426, 28276);
            CallChecker.varInit(this.dimension, "dimension", 650, 27426, 28276);
            CallChecker.varInit(this.inputSigma, "inputSigma", 650, 27426, 28276);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 650, 27426, 28276);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 650, 27426, 28276);
            CallChecker.varInit(this.lambda, "lambda", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 650, 27426, 28276);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 650, 27426, 28276);
            if (CallChecker.beforeDeref(optData, void.class, 653, 27954, 27960)) {
                for (OptimizationData data : optData) {
                    if (data instanceof CMAESOptimizer.Sigma) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 655, 28044, 28047)) {
                            inputSigma = CallChecker.isCalled(((CMAESOptimizer.Sigma) (data)), CMAESOptimizer.Sigma.class, 655, 28044, 28047).getSigma();
                            CallChecker.varAssign(this.inputSigma, "this.inputSigma", 655, 28022, 28060);
                        }
                        continue;
                    }
                    if (data instanceof CMAESOptimizer.PopulationSize) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 659, 28195, 28198)) {
                            lambda = CallChecker.isCalled(((CMAESOptimizer.PopulationSize) (data)), CMAESOptimizer.PopulationSize.class, 659, 28195, 28198).getPopulationSize();
                            CallChecker.varAssign(this.lambda, "this.lambda", 659, 28168, 28220);
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2820.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context2821 = new MethodContext(void.class, 668, 28283, 29182);
        try {
            CallChecker.varInit(this, "this", 668, 28283, 29182);
            CallChecker.varInit(this.evaluations, "evaluations", 668, 28283, 29182);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 668, 28283, 29182);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 668, 28283, 29182);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 668, 28283, 29182);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 668, 28283, 29182);
            CallChecker.varInit(this.random, "random", 668, 28283, 29182);
            CallChecker.varInit(this.historySize, "historySize", 668, 28283, 29182);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 668, 28283, 29182);
            CallChecker.varInit(this.iterations, "iterations", 668, 28283, 29182);
            CallChecker.varInit(this.diagC, "diagC", 668, 28283, 29182);
            CallChecker.varInit(this.C, "C", 668, 28283, 29182);
            CallChecker.varInit(this.diagD, "diagD", 668, 28283, 29182);
            CallChecker.varInit(this.BD, "BD", 668, 28283, 29182);
            CallChecker.varInit(this.D, "D", 668, 28283, 29182);
            CallChecker.varInit(this.B, "B", 668, 28283, 29182);
            CallChecker.varInit(this.normps, "normps", 668, 28283, 29182);
            CallChecker.varInit(this.ps, "ps", 668, 28283, 29182);
            CallChecker.varInit(this.pc, "pc", 668, 28283, 29182);
            CallChecker.varInit(this.xmean, "xmean", 668, 28283, 29182);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 668, 28283, 29182);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 668, 28283, 29182);
            CallChecker.varInit(this.chiN, "chiN", 668, 28283, 29182);
            CallChecker.varInit(this.ccovmu, "ccovmu", 668, 28283, 29182);
            CallChecker.varInit(this.ccov1, "ccov1", 668, 28283, 29182);
            CallChecker.varInit(this.damps, "damps", 668, 28283, 29182);
            CallChecker.varInit(this.cs, "cs", 668, 28283, 29182);
            CallChecker.varInit(this.cc, "cc", 668, 28283, 29182);
            CallChecker.varInit(this.sigma, "sigma", 668, 28283, 29182);
            CallChecker.varInit(this.mueff, "mueff", 668, 28283, 29182);
            CallChecker.varInit(this.weights, "weights", 668, 28283, 29182);
            CallChecker.varInit(this.logMu2, "logMu2", 668, 28283, 29182);
            CallChecker.varInit(this.mu, "mu", 668, 28283, 29182);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 668, 28283, 29182);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 668, 28283, 29182);
            CallChecker.varInit(this.stopTolX, "stopTolX", 668, 28283, 29182);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 668, 28283, 29182);
            CallChecker.varInit(this.stopFitness, "stopFitness", 668, 28283, 29182);
            CallChecker.varInit(this.maxIterations, "maxIterations", 668, 28283, 29182);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 668, 28283, 29182);
            CallChecker.varInit(this.isMinimize, "isMinimize", 668, 28283, 29182);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 668, 28283, 29182);
            CallChecker.varInit(this.dimension, "dimension", 668, 28283, 29182);
            CallChecker.varInit(this.inputSigma, "inputSigma", 668, 28283, 29182);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 668, 28283, 29182);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 668, 28283, 29182);
            CallChecker.varInit(this.lambda, "lambda", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 668, 28283, 29182);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 668, 28283, 29182);
            final double[] init = CallChecker.varInit(getStartPoint(), "init", 669, 28417, 28454);
            final double[] lB = CallChecker.varInit(getLowerBound(), "lB", 670, 28464, 28499);
            final double[] uB = CallChecker.varInit(getUpperBound(), "uB", 671, 28509, 28544);
            if ((inputSigma) != null) {
                if (CallChecker.beforeDeref(init, double[].class, 674, 28618, 28621)) {
                    if ((inputSigma.length) != (CallChecker.isCalled(init, double[].class, 674, 28618, 28621).length)) {
                        if (CallChecker.beforeDeref(init, double[].class, 675, 28705, 28708)) {
                            throw new DimensionMismatchException(inputSigma.length, CallChecker.isCalled(init, double[].class, 675, 28705, 28708).length);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                for (int i = 0; i < (CallChecker.isCalled(init, double[].class, 677, 28765, 28768).length); i++) {
                    if ((inputSigma[i]) < 0) {
                        throw new NotPositiveException(inputSigma[i]);
                    }
                    if (CallChecker.beforeDeref(uB, double[].class, 682, 29035, 29036)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 682, 29043, 29044)) {
                            if ((inputSigma[i]) > ((CallChecker.isCalled(uB, double[].class, 682, 29035, 29036)[i]) - (CallChecker.isCalled(lB, double[].class, 682, 29043, 29044)[i]))) {
                                if (CallChecker.beforeDeref(uB, double[].class, 683, 29120, 29121)) {
                                    if (CallChecker.beforeDeref(lB, double[].class, 683, 29128, 29129)) {
                                        throw new OutOfRangeException(inputSigma[i], 0, ((CallChecker.isCalled(uB, double[].class, 683, 29120, 29121)[i]) - (CallChecker.isCalled(lB, double[].class, 683, 29128, 29129)[i])));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2821.methodEnd();
        }
    }

    private void initializeCMA(double[] guess) {
        MethodContext _bcornu_methode_context2822 = new MethodContext(void.class, 694, 29189, 32725);
        try {
            CallChecker.varInit(this, "this", 694, 29189, 32725);
            CallChecker.varInit(guess, "guess", 694, 29189, 32725);
            CallChecker.varInit(this.evaluations, "evaluations", 694, 29189, 32725);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 694, 29189, 32725);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 694, 29189, 32725);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 694, 29189, 32725);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 694, 29189, 32725);
            CallChecker.varInit(this.random, "random", 694, 29189, 32725);
            CallChecker.varInit(this.historySize, "historySize", 694, 29189, 32725);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 694, 29189, 32725);
            CallChecker.varInit(this.iterations, "iterations", 694, 29189, 32725);
            CallChecker.varInit(this.diagC, "diagC", 694, 29189, 32725);
            CallChecker.varInit(this.C, "C", 694, 29189, 32725);
            CallChecker.varInit(this.diagD, "diagD", 694, 29189, 32725);
            CallChecker.varInit(this.BD, "BD", 694, 29189, 32725);
            CallChecker.varInit(this.D, "D", 694, 29189, 32725);
            CallChecker.varInit(this.B, "B", 694, 29189, 32725);
            CallChecker.varInit(this.normps, "normps", 694, 29189, 32725);
            CallChecker.varInit(this.ps, "ps", 694, 29189, 32725);
            CallChecker.varInit(this.pc, "pc", 694, 29189, 32725);
            CallChecker.varInit(this.xmean, "xmean", 694, 29189, 32725);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 694, 29189, 32725);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 694, 29189, 32725);
            CallChecker.varInit(this.chiN, "chiN", 694, 29189, 32725);
            CallChecker.varInit(this.ccovmu, "ccovmu", 694, 29189, 32725);
            CallChecker.varInit(this.ccov1, "ccov1", 694, 29189, 32725);
            CallChecker.varInit(this.damps, "damps", 694, 29189, 32725);
            CallChecker.varInit(this.cs, "cs", 694, 29189, 32725);
            CallChecker.varInit(this.cc, "cc", 694, 29189, 32725);
            CallChecker.varInit(this.sigma, "sigma", 694, 29189, 32725);
            CallChecker.varInit(this.mueff, "mueff", 694, 29189, 32725);
            CallChecker.varInit(this.weights, "weights", 694, 29189, 32725);
            CallChecker.varInit(this.logMu2, "logMu2", 694, 29189, 32725);
            CallChecker.varInit(this.mu, "mu", 694, 29189, 32725);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 694, 29189, 32725);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 694, 29189, 32725);
            CallChecker.varInit(this.stopTolX, "stopTolX", 694, 29189, 32725);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 694, 29189, 32725);
            CallChecker.varInit(this.stopFitness, "stopFitness", 694, 29189, 32725);
            CallChecker.varInit(this.maxIterations, "maxIterations", 694, 29189, 32725);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 694, 29189, 32725);
            CallChecker.varInit(this.isMinimize, "isMinimize", 694, 29189, 32725);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 694, 29189, 32725);
            CallChecker.varInit(this.dimension, "dimension", 694, 29189, 32725);
            CallChecker.varInit(this.inputSigma, "inputSigma", 694, 29189, 32725);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 694, 29189, 32725);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 694, 29189, 32725);
            CallChecker.varInit(this.lambda, "lambda", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 694, 29189, 32725);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 694, 29189, 32725);
            if ((lambda) <= 0) {
                lambda = 4 + ((int) (3 * (Math.log(dimension))));
                CallChecker.varAssign(this.lambda, "this.lambda", 698, 29567, 29611);
            }
            guess = CallChecker.beforeCalled(guess, double[].class, 701, 29700, 29704);
            final double[][] sigmaArray = CallChecker.varInit(new double[CallChecker.isCalled(guess, double[].class, 701, 29700, 29704).length][1], "sigmaArray", 701, 29659, 29716);
            guess = CallChecker.beforeCalled(guess, double[].class, 702, 29746, 29750);
            for (int i = 0; i < (CallChecker.isCalled(guess, double[].class, 702, 29746, 29750).length); i++) {
                if ((inputSigma) == null) {
                    if (CallChecker.beforeDeref(sigmaArray, double[][].class, 705, 29904, 29913)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)) {
                            CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916);
                            CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0] = 0.3;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0], "CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0]", 705, 29904, 29963);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(sigmaArray, double[][].class, 705, 29904, 29913)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)) {
                            CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916);
                            CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0] = inputSigma[i];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0], "CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 705, 29904, 29913)[i], double[].class, 705, 29904, 29916)[0]", 705, 29904, 29963);
                        }
                    }
                }
            }
            final RealMatrix insigma = CallChecker.varInit(new Array2DRowRealMatrix(sigmaArray, false), "insigma", 707, 29983, 30053);
            sigma = CMAESOptimizer.max(insigma);
            CallChecker.varAssign(this.sigma, "this.sigma", 708, 30063, 30083);
            stopTolUpX = 1000.0 * (CMAESOptimizer.max(insigma));
            CallChecker.varAssign(this.stopTolUpX, "this.stopTolUpX", 711, 30167, 30198);
            stopTolX = 1.0E-11 * (CMAESOptimizer.max(insigma));
            CallChecker.varAssign(this.stopTolX, "this.stopTolX", 712, 30208, 30239);
            stopTolFun = 1.0E-12;
            CallChecker.varAssign(this.stopTolFun, "this.stopTolFun", 713, 30249, 30267);
            stopTolHistFun = 1.0E-13;
            CallChecker.varAssign(this.stopTolHistFun, "this.stopTolHistFun", 714, 30277, 30299);
            mu = (lambda) / 2;
            CallChecker.varAssign(this.mu, "this.mu", 717, 30362, 30377);
            logMu2 = Math.log(((mu) + 0.5));
            CallChecker.varAssign(this.logMu2, "this.logMu2", 718, 30433, 30460);
            final RealMatrix npe_invocation_var712 = CMAESOptimizer.log(CMAESOptimizer.sequence(1, mu, 1));
            if (CallChecker.beforeDeref(npe_invocation_var712, RealMatrix.class, 719, 30480, 30502)) {
                final RealMatrix npe_invocation_var713 = CallChecker.isCalled(npe_invocation_var712, RealMatrix.class, 719, 30480, 30502).scalarMultiply((-1));
                if (CallChecker.beforeDeref(npe_invocation_var713, RealMatrix.class, 719, 30480, 30521)) {
                    weights = CallChecker.isCalled(npe_invocation_var713, RealMatrix.class, 719, 30480, 30521).scalarAdd(logMu2);
                    CallChecker.varAssign(this.weights, "this.weights", 719, 30470, 30540);
                }
            }
            double sumw = CallChecker.varInit(((double) (0)), "sumw", 720, 30550, 30565);
            double sumwq = CallChecker.varInit(((double) (0)), "sumwq", 721, 30575, 30591);
            for (int i = 0; i < (mu); i++) {
                double w = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(weights, RealMatrix.class, 723, 30655, 30661)) {
                    weights = CallChecker.beforeCalled(weights, RealMatrix.class, 723, 30655, 30661);
                    w = CallChecker.isCalled(weights, RealMatrix.class, 723, 30655, 30661).getEntry(i, 0);
                    CallChecker.varAssign(w, "w", 723, 30655, 30661);
                }
                sumw += w;
                CallChecker.varAssign(sumw, "sumw", 724, 30691, 30700);
                sumwq += w * w;
                CallChecker.varAssign(sumwq, "sumwq", 725, 30714, 30728);
            }
            if (CallChecker.beforeDeref(weights, RealMatrix.class, 727, 30758, 30764)) {
                weights = CallChecker.beforeCalled(weights, RealMatrix.class, 727, 30758, 30764);
                weights = CallChecker.isCalled(weights, RealMatrix.class, 727, 30758, 30764).scalarMultiply((1 / sumw));
                CallChecker.varAssign(this.weights, "this.weights", 727, 30748, 30790);
            }
            mueff = (sumw * sumw) / sumwq;
            CallChecker.varAssign(this.mueff, "this.mueff", 728, 30800, 30827);
            cc = (4 + ((mueff) / (dimension))) / (((dimension) + 4) + ((2 * (mueff)) / (dimension)));
            CallChecker.varAssign(this.cc, "this.cc", 731, 30943, 31029);
            cs = ((mueff) + 2) / (((dimension) + (mueff)) + 3.0);
            CallChecker.varAssign(this.cs, "this.cs", 733, 31039, 31082);
            damps = ((1 + (2 * (Math.max(0, ((Math.sqrt((((mueff) - 1) / ((dimension) + 1)))) - 1))))) * (Math.max(0.3, (1 - ((dimension) / (1.0E-6 + (maxIterations))))))) + (cs);
            CallChecker.varAssign(this.damps, "this.damps", 734, 31092, 31308);
            ccov1 = 2 / ((((dimension) + 1.3) * ((dimension) + 1.3)) + (mueff));
            CallChecker.varAssign(this.ccov1, "this.ccov1", 738, 31337, 31396);
            ccovmu = Math.min((1 - (ccov1)), ((2 * (((mueff) - 2) + (1 / (mueff)))) / ((((dimension) + 2) * ((dimension) + 2)) + (mueff))));
            CallChecker.varAssign(this.ccovmu, "this.ccovmu", 739, 31406, 31535);
            ccov1Sep = Math.min(1, (((ccov1) * ((dimension) + 1.5)) / 3));
            CallChecker.varAssign(this.ccov1Sep, "this.ccov1Sep", 741, 31545, 31598);
            ccovmuSep = Math.min((1 - (ccov1)), (((ccovmu) * ((dimension) + 1.5)) / 3));
            CallChecker.varAssign(this.ccovmuSep, "this.ccovmuSep", 742, 31608, 31671);
            chiN = (Math.sqrt(dimension)) * ((1 - (1 / (((double) (4)) * (dimension)))) + (1 / ((((double) (21)) * (dimension)) * (dimension))));
            CallChecker.varAssign(this.chiN, "this.chiN", 743, 31681, 31801);
            xmean = MatrixUtils.createColumnRealMatrix(guess);
            CallChecker.varAssign(this.xmean, "this.xmean", 746, 31878, 31927);
            if (CallChecker.beforeDeref(insigma, RealMatrix.class, 747, 31968, 31974)) {
                diagD = CallChecker.isCalled(insigma, RealMatrix.class, 747, 31968, 31974).scalarMultiply((1 / (sigma)));
                CallChecker.varAssign(this.diagD, "this.diagD", 747, 31960, 32001);
            }
            diagC = CMAESOptimizer.square(diagD);
            CallChecker.varAssign(this.diagC, "this.diagC", 748, 32011, 32032);
            pc = CMAESOptimizer.zeros(dimension, 1);
            CallChecker.varAssign(this.pc, "this.pc", 749, 32042, 32066);
            ps = CMAESOptimizer.zeros(dimension, 1);
            CallChecker.varAssign(this.ps, "this.ps", 750, 32111, 32135);
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 751, 32189, 32190)) {
                ps = CallChecker.beforeCalled(ps, RealMatrix.class, 751, 32189, 32190);
                normps = CallChecker.isCalled(ps, RealMatrix.class, 751, 32189, 32190).getFrobeniusNorm();
                CallChecker.varAssign(this.normps, "this.normps", 751, 32180, 32210);
            }
            B = CMAESOptimizer.eye(dimension, dimension);
            CallChecker.varAssign(this.B, "this.B", 753, 32221, 32250);
            D = CMAESOptimizer.ones(dimension, 1);
            CallChecker.varAssign(this.D, "this.D", 754, 32260, 32282);
            if (CallChecker.beforeDeref(diagD, RealMatrix.class, 755, 32347, 32351)) {
                diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 755, 32347, 32351);
                BD = CMAESOptimizer.times(B, CMAESOptimizer.repmat(CallChecker.isCalled(diagD, RealMatrix.class, 755, 32347, 32351).transpose(), dimension, 1));
                CallChecker.varAssign(this.BD, "this.BD", 755, 32326, 32380);
            }
            if (CallChecker.beforeDeref(B, RealMatrix.class, 756, 32430, 32430)) {
                final RealMatrix npe_invocation_var714 = CMAESOptimizer.diag(CMAESOptimizer.square(D));
                if (CallChecker.beforeDeref(npe_invocation_var714, RealMatrix.class, 756, 32405, 32419)) {
                    if (CallChecker.beforeDeref(B, RealMatrix.class, 756, 32394, 32394)) {
                        B = CallChecker.beforeCalled(B, RealMatrix.class, 756, 32430, 32430);
                        B = CallChecker.beforeCalled(B, RealMatrix.class, 756, 32394, 32394);
                        C = CallChecker.isCalled(B, RealMatrix.class, 756, 32394, 32394).multiply(CallChecker.isCalled(npe_invocation_var714, RealMatrix.class, 756, 32405, 32419).multiply(CallChecker.isCalled(B, RealMatrix.class, 756, 32430, 32430).transpose()));
                        CallChecker.varAssign(this.C, "this.C", 756, 32390, 32445);
                    }
                }
            }
            historySize = 10 + ((int) (((3 * 10) * (dimension)) / ((double) (lambda))));
            CallChecker.varAssign(this.historySize, "this.historySize", 757, 32469, 32532);
            fitnessHistory = new double[historySize];
            CallChecker.varAssign(this.fitnessHistory, "this.fitnessHistory", 758, 32542, 32582);
            for (int i = 0; i < (historySize); i++) {
                if (CallChecker.beforeDeref(fitnessHistory, double[].class, 760, 32673, 32686)) {
                    fitnessHistory = CallChecker.beforeCalled(fitnessHistory, double[].class, 760, 32673, 32686);
                    CallChecker.isCalled(fitnessHistory, double[].class, 760, 32673, 32686)[i] = Double.MAX_VALUE;
                    CallChecker.varAssign(CallChecker.isCalled(this.fitnessHistory, double[].class, 760, 32673, 32686)[i], "CallChecker.isCalled(this.fitnessHistory, double[].class, 760, 32673, 32686)[i]", 760, 32673, 32709);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2822.methodEnd();
        }
    }

    private boolean updateEvolutionPaths(RealMatrix zmean, RealMatrix xold) {
        MethodContext _bcornu_methode_context2823 = new MethodContext(boolean.class, 772, 32732, 33653);
        try {
            CallChecker.varInit(this, "this", 772, 32732, 33653);
            CallChecker.varInit(xold, "xold", 772, 32732, 33653);
            CallChecker.varInit(zmean, "zmean", 772, 32732, 33653);
            CallChecker.varInit(this.evaluations, "evaluations", 772, 32732, 33653);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 772, 32732, 33653);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 772, 32732, 33653);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 772, 32732, 33653);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 772, 32732, 33653);
            CallChecker.varInit(this.random, "random", 772, 32732, 33653);
            CallChecker.varInit(this.historySize, "historySize", 772, 32732, 33653);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 772, 32732, 33653);
            CallChecker.varInit(this.iterations, "iterations", 772, 32732, 33653);
            CallChecker.varInit(this.diagC, "diagC", 772, 32732, 33653);
            CallChecker.varInit(this.C, "C", 772, 32732, 33653);
            CallChecker.varInit(this.diagD, "diagD", 772, 32732, 33653);
            CallChecker.varInit(this.BD, "BD", 772, 32732, 33653);
            CallChecker.varInit(this.D, "D", 772, 32732, 33653);
            CallChecker.varInit(this.B, "B", 772, 32732, 33653);
            CallChecker.varInit(this.normps, "normps", 772, 32732, 33653);
            CallChecker.varInit(this.ps, "ps", 772, 32732, 33653);
            CallChecker.varInit(this.pc, "pc", 772, 32732, 33653);
            CallChecker.varInit(this.xmean, "xmean", 772, 32732, 33653);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 772, 32732, 33653);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 772, 32732, 33653);
            CallChecker.varInit(this.chiN, "chiN", 772, 32732, 33653);
            CallChecker.varInit(this.ccovmu, "ccovmu", 772, 32732, 33653);
            CallChecker.varInit(this.ccov1, "ccov1", 772, 32732, 33653);
            CallChecker.varInit(this.damps, "damps", 772, 32732, 33653);
            CallChecker.varInit(this.cs, "cs", 772, 32732, 33653);
            CallChecker.varInit(this.cc, "cc", 772, 32732, 33653);
            CallChecker.varInit(this.sigma, "sigma", 772, 32732, 33653);
            CallChecker.varInit(this.mueff, "mueff", 772, 32732, 33653);
            CallChecker.varInit(this.weights, "weights", 772, 32732, 33653);
            CallChecker.varInit(this.logMu2, "logMu2", 772, 32732, 33653);
            CallChecker.varInit(this.mu, "mu", 772, 32732, 33653);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 772, 32732, 33653);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 772, 32732, 33653);
            CallChecker.varInit(this.stopTolX, "stopTolX", 772, 32732, 33653);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 772, 32732, 33653);
            CallChecker.varInit(this.stopFitness, "stopFitness", 772, 32732, 33653);
            CallChecker.varInit(this.maxIterations, "maxIterations", 772, 32732, 33653);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 772, 32732, 33653);
            CallChecker.varInit(this.isMinimize, "isMinimize", 772, 32732, 33653);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 772, 32732, 33653);
            CallChecker.varInit(this.dimension, "dimension", 772, 32732, 33653);
            CallChecker.varInit(this.inputSigma, "inputSigma", 772, 32732, 33653);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 772, 32732, 33653);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 772, 32732, 33653);
            CallChecker.varInit(this.lambda, "lambda", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 772, 32732, 33653);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 772, 32732, 33653);
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 773, 33118, 33119)) {
                if (CallChecker.beforeDeref(B, RealMatrix.class, 774, 33165, 33165)) {
                    B = CallChecker.beforeCalled(B, RealMatrix.class, 774, 33165, 33165);
                    final RealMatrix npe_invocation_var715 = CallChecker.isCalled(B, RealMatrix.class, 774, 33165, 33165).multiply(zmean);
                    if (CallChecker.beforeDeref(npe_invocation_var715, RealMatrix.class, 774, 33165, 33181)) {
                        ps = CallChecker.beforeCalled(ps, RealMatrix.class, 773, 33118, 33119);
                        final RealMatrix npe_invocation_var716 = CallChecker.isCalled(ps, RealMatrix.class, 773, 33118, 33119).scalarMultiply((1 - (cs)));
                        if (CallChecker.beforeDeref(npe_invocation_var716, RealMatrix.class, 773, 33118, 33142)) {
                            ps = CallChecker.isCalled(npe_invocation_var716, RealMatrix.class, 773, 33118, 33142).add(CallChecker.isCalled(npe_invocation_var715, RealMatrix.class, 774, 33165, 33181).scalarMultiply(Math.sqrt((((cs) * (2 - (cs))) * (mueff)))));
                            CallChecker.varAssign(this.ps, "this.ps", 773, 33113, 33257);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 776, 33276, 33277)) {
                ps = CallChecker.beforeCalled(ps, RealMatrix.class, 776, 33276, 33277);
                normps = CallChecker.isCalled(ps, RealMatrix.class, 776, 33276, 33277).getFrobeniusNorm();
                CallChecker.varAssign(this.normps, "this.normps", 776, 33267, 33297);
            }
            final boolean hsig = CallChecker.varInit(((boolean) ((((this.normps) / (Math.sqrt((1 - (Math.pow((1 - (this.cs)), (2 * (this.iterations)))))))) / (this.chiN)) < (1.4 + (2 / (((double) (this.dimension)) + 1))))), "hsig", 777, 33307, 33452);
            if (CallChecker.beforeDeref(pc, RealMatrix.class, 780, 33467, 33468)) {
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 780, 33467, 33468);
                pc = CallChecker.isCalled(pc, RealMatrix.class, 780, 33467, 33468).scalarMultiply((1 - (cc)));
                CallChecker.varAssign(this.pc, "this.pc", 780, 33462, 33492);
            }
            if (hsig) {
                if (CallChecker.beforeDeref(xmean, RealMatrix.class, 782, 33538, 33542)) {
                    xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 782, 33538, 33542);
                    final RealMatrix npe_invocation_var717 = CallChecker.isCalled(xmean, RealMatrix.class, 782, 33538, 33542).subtract(xold);
                    if (CallChecker.beforeDeref(npe_invocation_var717, RealMatrix.class, 782, 33538, 33557)) {
                        if (CallChecker.beforeDeref(pc, RealMatrix.class, 782, 33531, 33532)) {
                            pc = CallChecker.beforeCalled(pc, RealMatrix.class, 782, 33531, 33532);
                            pc = CallChecker.isCalled(pc, RealMatrix.class, 782, 33531, 33532).add(CallChecker.isCalled(npe_invocation_var717, RealMatrix.class, 782, 33538, 33557).scalarMultiply(((Math.sqrt((((cc) * (2 - (cc))) * (mueff)))) / (sigma))));
                            CallChecker.varAssign(this.pc, "this.pc", 782, 33526, 33616);
                        }
                    }
                }
            }
            return hsig;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2823.methodEnd();
        }
    }

    private void updateCovarianceDiagonalOnly(boolean hsig, final RealMatrix bestArz) {
        MethodContext _bcornu_methode_context2824 = new MethodContext(void.class, 794, 33660, 34782);
        try {
            CallChecker.varInit(this, "this", 794, 33660, 34782);
            CallChecker.varInit(bestArz, "bestArz", 794, 33660, 34782);
            CallChecker.varInit(hsig, "hsig", 794, 33660, 34782);
            CallChecker.varInit(this.evaluations, "evaluations", 794, 33660, 34782);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 794, 33660, 34782);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 794, 33660, 34782);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 794, 33660, 34782);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 794, 33660, 34782);
            CallChecker.varInit(this.random, "random", 794, 33660, 34782);
            CallChecker.varInit(this.historySize, "historySize", 794, 33660, 34782);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 794, 33660, 34782);
            CallChecker.varInit(this.iterations, "iterations", 794, 33660, 34782);
            CallChecker.varInit(this.diagC, "diagC", 794, 33660, 34782);
            CallChecker.varInit(this.C, "C", 794, 33660, 34782);
            CallChecker.varInit(this.diagD, "diagD", 794, 33660, 34782);
            CallChecker.varInit(this.BD, "BD", 794, 33660, 34782);
            CallChecker.varInit(this.D, "D", 794, 33660, 34782);
            CallChecker.varInit(this.B, "B", 794, 33660, 34782);
            CallChecker.varInit(this.normps, "normps", 794, 33660, 34782);
            CallChecker.varInit(this.ps, "ps", 794, 33660, 34782);
            CallChecker.varInit(this.pc, "pc", 794, 33660, 34782);
            CallChecker.varInit(this.xmean, "xmean", 794, 33660, 34782);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 794, 33660, 34782);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 794, 33660, 34782);
            CallChecker.varInit(this.chiN, "chiN", 794, 33660, 34782);
            CallChecker.varInit(this.ccovmu, "ccovmu", 794, 33660, 34782);
            CallChecker.varInit(this.ccov1, "ccov1", 794, 33660, 34782);
            CallChecker.varInit(this.damps, "damps", 794, 33660, 34782);
            CallChecker.varInit(this.cs, "cs", 794, 33660, 34782);
            CallChecker.varInit(this.cc, "cc", 794, 33660, 34782);
            CallChecker.varInit(this.sigma, "sigma", 794, 33660, 34782);
            CallChecker.varInit(this.mueff, "mueff", 794, 33660, 34782);
            CallChecker.varInit(this.weights, "weights", 794, 33660, 34782);
            CallChecker.varInit(this.logMu2, "logMu2", 794, 33660, 34782);
            CallChecker.varInit(this.mu, "mu", 794, 33660, 34782);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 794, 33660, 34782);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 794, 33660, 34782);
            CallChecker.varInit(this.stopTolX, "stopTolX", 794, 33660, 34782);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 794, 33660, 34782);
            CallChecker.varInit(this.stopFitness, "stopFitness", 794, 33660, 34782);
            CallChecker.varInit(this.maxIterations, "maxIterations", 794, 33660, 34782);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 794, 33660, 34782);
            CallChecker.varInit(this.isMinimize, "isMinimize", 794, 33660, 34782);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 794, 33660, 34782);
            CallChecker.varInit(this.dimension, "dimension", 794, 33660, 34782);
            CallChecker.varInit(this.inputSigma, "inputSigma", 794, 33660, 34782);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 794, 33660, 34782);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 794, 33660, 34782);
            CallChecker.varInit(this.lambda, "lambda", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 794, 33660, 34782);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 794, 33660, 34782);
            double oldFac = CallChecker.init(double.class);
            if (hsig) {
                oldFac = 0;
                CallChecker.varAssign(oldFac, "oldFac", 797, 34104, 34138);
            }else {
                oldFac = ((ccov1Sep) * (cc)) * (2 - (cc));
                CallChecker.varAssign(oldFac, "oldFac", 797, 34104, 34138);
            }
            oldFac += (1 - (ccov1Sep)) - (ccovmuSep);
            CallChecker.varAssign(oldFac, "oldFac", 798, 34149, 34183);
            if (CallChecker.beforeDeref(diagC, RealMatrix.class, 799, 34201, 34205)) {
                final RealMatrix npe_invocation_var718 = CMAESOptimizer.square(pc);
                if (CallChecker.beforeDeref(npe_invocation_var718, RealMatrix.class, 800, 34268, 34277)) {
                    diagC = CallChecker.beforeCalled(diagC, RealMatrix.class, 799, 34201, 34205);
                    final RealMatrix npe_invocation_var719 = CallChecker.isCalled(diagC, RealMatrix.class, 799, 34201, 34205).scalarMultiply(oldFac);
                    if (CallChecker.beforeDeref(npe_invocation_var719, RealMatrix.class, 799, 34201, 34228)) {
                        final RealMatrix npe_invocation_var720 = CMAESOptimizer.square(bestArz);
                        if (CallChecker.beforeDeref(npe_invocation_var720, RealMatrix.class, 801, 34360, 34374)) {
                            final RealMatrix npe_invocation_var721 = CMAESOptimizer.times(diagC, CallChecker.isCalled(npe_invocation_var720, RealMatrix.class, 801, 34360, 34374).multiply(weights));
                            if (CallChecker.beforeDeref(npe_invocation_var721, RealMatrix.class, 801, 34346, 34394)) {
                                final RealMatrix npe_invocation_var722 = CallChecker.isCalled(npe_invocation_var719, RealMatrix.class, 799, 34201, 34228).add(CallChecker.isCalled(npe_invocation_var718, RealMatrix.class, 800, 34268, 34277).scalarMultiply(ccov1Sep));
                                if (CallChecker.beforeDeref(npe_invocation_var722, RealMatrix.class, 799, 34201, 34303)) {
                                    diagC = CallChecker.isCalled(npe_invocation_var722, RealMatrix.class, 799, 34201, 34303).add(CallChecker.isCalled(npe_invocation_var721, RealMatrix.class, 801, 34346, 34394).scalarMultiply(ccovmuSep));
                                    CallChecker.varAssign(this.diagC, "this.diagC", 799, 34193, 34463);
                                }
                            }
                        }
                    }
                }
            }
            diagD = CMAESOptimizer.sqrt(diagC);
            CallChecker.varAssign(this.diagD, "this.diagD", 803, 34473, 34492);
            if (((diagonalOnly) > 1) && ((iterations) > (diagonalOnly))) {
                diagonalOnly = 0;
                CallChecker.varAssign(this.diagonalOnly, "this.diagonalOnly", 807, 34648, 34664);
                B = CMAESOptimizer.eye(dimension, dimension);
                CallChecker.varAssign(this.B, "this.B", 808, 34678, 34707);
                BD = CMAESOptimizer.diag(diagD);
                CallChecker.varAssign(this.BD, "this.BD", 809, 34721, 34737);
                C = CMAESOptimizer.diag(diagC);
                CallChecker.varAssign(this.C, "this.C", 810, 34751, 34766);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2824.methodEnd();
        }
    }

    private void updateCovariance(boolean hsig, final RealMatrix bestArx, final RealMatrix arz, final int[] arindex, final RealMatrix xold) {
        MethodContext _bcornu_methode_context2825 = new MethodContext(void.class, 825, 34789, 38760);
        try {
            CallChecker.varInit(this, "this", 825, 34789, 38760);
            CallChecker.varInit(xold, "xold", 825, 34789, 38760);
            CallChecker.varInit(arindex, "arindex", 825, 34789, 38760);
            CallChecker.varInit(arz, "arz", 825, 34789, 38760);
            CallChecker.varInit(bestArx, "bestArx", 825, 34789, 38760);
            CallChecker.varInit(hsig, "hsig", 825, 34789, 38760);
            CallChecker.varInit(this.evaluations, "evaluations", 825, 34789, 38760);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 825, 34789, 38760);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 825, 34789, 38760);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 825, 34789, 38760);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 825, 34789, 38760);
            CallChecker.varInit(this.random, "random", 825, 34789, 38760);
            CallChecker.varInit(this.historySize, "historySize", 825, 34789, 38760);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 825, 34789, 38760);
            CallChecker.varInit(this.iterations, "iterations", 825, 34789, 38760);
            CallChecker.varInit(this.diagC, "diagC", 825, 34789, 38760);
            CallChecker.varInit(this.C, "C", 825, 34789, 38760);
            CallChecker.varInit(this.diagD, "diagD", 825, 34789, 38760);
            CallChecker.varInit(this.BD, "BD", 825, 34789, 38760);
            CallChecker.varInit(this.D, "D", 825, 34789, 38760);
            CallChecker.varInit(this.B, "B", 825, 34789, 38760);
            CallChecker.varInit(this.normps, "normps", 825, 34789, 38760);
            CallChecker.varInit(this.ps, "ps", 825, 34789, 38760);
            CallChecker.varInit(this.pc, "pc", 825, 34789, 38760);
            CallChecker.varInit(this.xmean, "xmean", 825, 34789, 38760);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 825, 34789, 38760);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 825, 34789, 38760);
            CallChecker.varInit(this.chiN, "chiN", 825, 34789, 38760);
            CallChecker.varInit(this.ccovmu, "ccovmu", 825, 34789, 38760);
            CallChecker.varInit(this.ccov1, "ccov1", 825, 34789, 38760);
            CallChecker.varInit(this.damps, "damps", 825, 34789, 38760);
            CallChecker.varInit(this.cs, "cs", 825, 34789, 38760);
            CallChecker.varInit(this.cc, "cc", 825, 34789, 38760);
            CallChecker.varInit(this.sigma, "sigma", 825, 34789, 38760);
            CallChecker.varInit(this.mueff, "mueff", 825, 34789, 38760);
            CallChecker.varInit(this.weights, "weights", 825, 34789, 38760);
            CallChecker.varInit(this.logMu2, "logMu2", 825, 34789, 38760);
            CallChecker.varInit(this.mu, "mu", 825, 34789, 38760);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 825, 34789, 38760);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 825, 34789, 38760);
            CallChecker.varInit(this.stopTolX, "stopTolX", 825, 34789, 38760);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 825, 34789, 38760);
            CallChecker.varInit(this.stopFitness, "stopFitness", 825, 34789, 38760);
            CallChecker.varInit(this.maxIterations, "maxIterations", 825, 34789, 38760);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 825, 34789, 38760);
            CallChecker.varInit(this.isMinimize, "isMinimize", 825, 34789, 38760);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 825, 34789, 38760);
            CallChecker.varInit(this.dimension, "dimension", 825, 34789, 38760);
            CallChecker.varInit(this.inputSigma, "inputSigma", 825, 34789, 38760);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 825, 34789, 38760);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 825, 34789, 38760);
            CallChecker.varInit(this.lambda, "lambda", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 825, 34789, 38760);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 825, 34789, 38760);
            double negccov = CallChecker.varInit(((double) (0)), "negccov", 828, 35481, 35499);
            if (((ccov1) + (ccovmu)) > 0) {
                final RealMatrix arpos = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(bestArx, RealMatrix.class, 830, 35572, 35578).subtract(CMAESOptimizer.repmat(xold, 1, mu)), RealMatrix.class, 830, 35572, 35608).scalarMultiply((1 / (sigma))), "arpos", 830, 35547, 35652);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 832, 35728, 35729);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 832, 35716, 35717);
                final RealMatrix roneu = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(pc, RealMatrix.class, 832, 35716, 35717).multiply(CallChecker.isCalled(pc, RealMatrix.class, 832, 35728, 35729).transpose()), RealMatrix.class, 832, 35716, 35742).scalarMultiply(ccov1), "roneu", 832, 35691, 35782);
                double oldFac = CallChecker.init(double.class);
                if (hsig) {
                    oldFac = 0;
                    CallChecker.varAssign(oldFac, "oldFac", 835, 35878, 35909);
                }else {
                    oldFac = ((ccov1) * (cc)) * (2 - (cc));
                    CallChecker.varAssign(oldFac, "oldFac", 835, 35878, 35909);
                }
                oldFac += (1 - (ccov1)) - (ccovmu);
                CallChecker.varAssign(oldFac, "oldFac", 836, 35924, 35952);
                if (isActiveCMA) {
                    negccov = (((1 - (ccovmu)) * 0.25) * (mueff)) / ((Math.pow(((dimension) + 2), 1.5)) + (2 * (mueff)));
                    CallChecker.varAssign(negccov, "negccov", 839, 36057, 36159);
                    final double negminresidualvariance = CallChecker.varInit(((double) (0.66)), "negminresidualvariance", 843, 36177, 36327);
                    final double negalphaold = CallChecker.varInit(((double) (0.5)), "negalphaold", 845, 36345, 36433);
                    final int[] arReverseIndex = CallChecker.varInit(CMAESOptimizer.reverse(arindex), "arReverseIndex", 847, 36525, 36570);
                    RealMatrix arzneg = CallChecker.varInit(CMAESOptimizer.selectColumns(arz, MathArrays.copyOf(arReverseIndex, mu)), "arzneg", 848, 36588, 36665);
                    RealMatrix arnorms = CallChecker.varInit(CMAESOptimizer.sqrt(CMAESOptimizer.sumRows(CMAESOptimizer.square(arzneg))), "arnorms", 849, 36683, 36733);
                    arnorms = CallChecker.beforeCalled(arnorms, RealMatrix.class, 850, 36788, 36794);
                    final int[] idxnorms = CallChecker.varInit(sortedIndices(CallChecker.isCalled(arnorms, RealMatrix.class, 850, 36788, 36794).getRow(0)), "idxnorms", 850, 36751, 36806);
                    final RealMatrix arnormsSorted = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxnorms), "arnormsSorted", 851, 36824, 36889);
                    final int[] idxReverse = CallChecker.varInit(CMAESOptimizer.reverse(idxnorms), "idxReverse", 852, 36907, 36949);
                    final RealMatrix arnormsReverse = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxReverse), "arnormsReverse", 853, 36967, 37035);
                    arnorms = CMAESOptimizer.divide(arnormsReverse, arnormsSorted);
                    CallChecker.varAssign(arnorms, "arnorms", 854, 37053, 37100);
                    final int[] idxInv = CallChecker.varInit(CMAESOptimizer.inverse(idxnorms), "idxInv", 855, 37118, 37156);
                    final RealMatrix arnormsInv = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxInv), "arnormsInv", 856, 37174, 37234);
                    final double negcovMax = CallChecker.varInit(((double) ((1 - negminresidualvariance) / (CallChecker.isCalled(CallChecker.isCalled(CMAESOptimizer.square(arnormsInv), RealMatrix.class, 859, 37383, 37400).multiply(this.weights), RealMatrix.class, 859, 37383, 37418).getEntry(0, 0)))), "negcovMax", 858, 37252, 37434);
                    if (negccov > negcovMax) {
                        negccov = negcovMax;
                        CallChecker.varAssign(negccov, "negccov", 861, 37499, 37518);
                    }
                    arzneg = CMAESOptimizer.times(arzneg, CMAESOptimizer.repmat(arnormsInv, dimension, 1));
                    CallChecker.varAssign(arzneg, "arzneg", 863, 37554, 37610);
                    BD = CallChecker.beforeCalled(BD, RealMatrix.class, 864, 37653, 37654);
                    final RealMatrix artmp = CallChecker.varInit(CallChecker.isCalled(BD, RealMatrix.class, 864, 37653, 37654).multiply(arzneg), "artmp", 864, 37628, 37672);
                    final RealMatrix Cneg = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(artmp, RealMatrix.class, 865, 37714, 37718).multiply(CMAESOptimizer.diag(weights)), RealMatrix.class, 865, 37714, 37742).multiply(CallChecker.isCalled(artmp, RealMatrix.class, 865, 37753, 37757).transpose()), "Cneg", 865, 37690, 37771);
                    oldFac += negalphaold * negccov;
                    CallChecker.varAssign(oldFac, "oldFac", 866, 37789, 37820);
                    if (CallChecker.beforeDeref(C, RealMatrix.class, 867, 37842, 37842)) {
                        C = CallChecker.beforeCalled(C, RealMatrix.class, 867, 37842, 37842);
                        final RealMatrix npe_invocation_var723 = CallChecker.isCalled(C, RealMatrix.class, 867, 37842, 37842).scalarMultiply(oldFac);
                        if (CallChecker.beforeDeref(npe_invocation_var723, RealMatrix.class, 867, 37842, 37865)) {
                            if (CallChecker.beforeDeref(arpos, RealMatrix.class, 869, 37945, 37949)) {
                                if (CallChecker.beforeDeref(arpos, RealMatrix.class, 872, 38211, 38215)) {
                                    final RealMatrix npe_invocation_var724 = CallChecker.isCalled(arpos, RealMatrix.class, 869, 37945, 37949).scalarMultiply(((ccovmu) + ((1 - negalphaold) * negccov)));
                                    if (CallChecker.beforeDeref(npe_invocation_var724, RealMatrix.class, 869, 37945, 38073)) {
                                        final RealMatrix npe_invocation_var725 = CallChecker.isCalled(npe_invocation_var723, RealMatrix.class, 867, 37842, 37865).add(roneu);
                                        if (CallChecker.beforeDeref(npe_invocation_var725, RealMatrix.class, 867, 37842, 37897)) {
                                            if (CallChecker.beforeDeref(Cneg, RealMatrix.class, 873, 38262, 38265)) {
                                                final RealMatrix npe_invocation_var726 = CallChecker.isCalled(npe_invocation_var725, RealMatrix.class, 867, 37842, 37897).add(CallChecker.isCalled(npe_invocation_var724, RealMatrix.class, 869, 37945, 38073).multiply(CMAESOptimizer.times(CMAESOptimizer.repmat(weights, 1, dimension), CallChecker.isCalled(arpos, RealMatrix.class, 872, 38211, 38215).transpose())));
                                                if (CallChecker.beforeDeref(npe_invocation_var726, RealMatrix.class, 867, 37842, 38230)) {
                                                    C = CallChecker.isCalled(npe_invocation_var726, RealMatrix.class, 867, 37842, 38230).subtract(CallChecker.isCalled(Cneg, RealMatrix.class, 873, 38262, 38265).scalarMultiply(negccov));
                                                    CallChecker.varAssign(this.C, "this.C", 867, 37838, 38291);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(C, RealMatrix.class, 876, 38391, 38391)) {
                        C = CallChecker.beforeCalled(C, RealMatrix.class, 876, 38391, 38391);
                        final RealMatrix npe_invocation_var727 = CallChecker.isCalled(C, RealMatrix.class, 876, 38391, 38391).scalarMultiply(oldFac);
                        if (CallChecker.beforeDeref(npe_invocation_var727, RealMatrix.class, 876, 38391, 38414)) {
                            if (CallChecker.beforeDeref(arpos, RealMatrix.class, 878, 38518, 38522)) {
                                if (CallChecker.beforeDeref(arpos, RealMatrix.class, 880, 38683, 38687)) {
                                    final RealMatrix npe_invocation_var728 = CallChecker.isCalled(arpos, RealMatrix.class, 878, 38518, 38522).scalarMultiply(ccovmu);
                                    if (CallChecker.beforeDeref(npe_invocation_var728, RealMatrix.class, 878, 38518, 38545)) {
                                        final RealMatrix npe_invocation_var729 = CallChecker.isCalled(npe_invocation_var727, RealMatrix.class, 876, 38391, 38414).add(roneu);
                                        if (CallChecker.beforeDeref(npe_invocation_var729, RealMatrix.class, 876, 38391, 38467)) {
                                            C = CallChecker.isCalled(npe_invocation_var729, RealMatrix.class, 876, 38391, 38467).add(CallChecker.isCalled(npe_invocation_var728, RealMatrix.class, 878, 38518, 38545).multiply(CMAESOptimizer.times(CMAESOptimizer.repmat(weights, 1, dimension), CallChecker.isCalled(arpos, RealMatrix.class, 880, 38683, 38687).transpose())));
                                            CallChecker.varAssign(this.C, "this.C", 876, 38387, 38703);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            updateBD(negccov);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2825.methodEnd();
        }
    }

    private void updateBD(double negccov) {
        MethodContext _bcornu_methode_context2826 = new MethodContext(void.class, 891, 38767, 40317);
        try {
            CallChecker.varInit(this, "this", 891, 38767, 40317);
            CallChecker.varInit(negccov, "negccov", 891, 38767, 40317);
            CallChecker.varInit(this.evaluations, "evaluations", 891, 38767, 40317);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 891, 38767, 40317);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 891, 38767, 40317);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 891, 38767, 40317);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 891, 38767, 40317);
            CallChecker.varInit(this.random, "random", 891, 38767, 40317);
            CallChecker.varInit(this.historySize, "historySize", 891, 38767, 40317);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 891, 38767, 40317);
            CallChecker.varInit(this.iterations, "iterations", 891, 38767, 40317);
            CallChecker.varInit(this.diagC, "diagC", 891, 38767, 40317);
            CallChecker.varInit(this.C, "C", 891, 38767, 40317);
            CallChecker.varInit(this.diagD, "diagD", 891, 38767, 40317);
            CallChecker.varInit(this.BD, "BD", 891, 38767, 40317);
            CallChecker.varInit(this.D, "D", 891, 38767, 40317);
            CallChecker.varInit(this.B, "B", 891, 38767, 40317);
            CallChecker.varInit(this.normps, "normps", 891, 38767, 40317);
            CallChecker.varInit(this.ps, "ps", 891, 38767, 40317);
            CallChecker.varInit(this.pc, "pc", 891, 38767, 40317);
            CallChecker.varInit(this.xmean, "xmean", 891, 38767, 40317);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 891, 38767, 40317);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 891, 38767, 40317);
            CallChecker.varInit(this.chiN, "chiN", 891, 38767, 40317);
            CallChecker.varInit(this.ccovmu, "ccovmu", 891, 38767, 40317);
            CallChecker.varInit(this.ccov1, "ccov1", 891, 38767, 40317);
            CallChecker.varInit(this.damps, "damps", 891, 38767, 40317);
            CallChecker.varInit(this.cs, "cs", 891, 38767, 40317);
            CallChecker.varInit(this.cc, "cc", 891, 38767, 40317);
            CallChecker.varInit(this.sigma, "sigma", 891, 38767, 40317);
            CallChecker.varInit(this.mueff, "mueff", 891, 38767, 40317);
            CallChecker.varInit(this.weights, "weights", 891, 38767, 40317);
            CallChecker.varInit(this.logMu2, "logMu2", 891, 38767, 40317);
            CallChecker.varInit(this.mu, "mu", 891, 38767, 40317);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 891, 38767, 40317);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 891, 38767, 40317);
            CallChecker.varInit(this.stopTolX, "stopTolX", 891, 38767, 40317);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 891, 38767, 40317);
            CallChecker.varInit(this.stopFitness, "stopFitness", 891, 38767, 40317);
            CallChecker.varInit(this.maxIterations, "maxIterations", 891, 38767, 40317);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 891, 38767, 40317);
            CallChecker.varInit(this.isMinimize, "isMinimize", 891, 38767, 40317);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 891, 38767, 40317);
            CallChecker.varInit(this.dimension, "dimension", 891, 38767, 40317);
            CallChecker.varInit(this.inputSigma, "inputSigma", 891, 38767, 40317);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 891, 38767, 40317);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 891, 38767, 40317);
            CallChecker.varInit(this.lambda, "lambda", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 891, 38767, 40317);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 891, 38767, 40317);
            if (((((ccov1) + (ccovmu)) + negccov) > 0) && ((((((iterations) % 1.0) / (((ccov1) + (ccovmu)) + negccov)) / (dimension)) / 10.0) < 1)) {
                final RealMatrix npe_invocation_var730 = CMAESOptimizer.triu(C, 1);
                if (CallChecker.beforeDeref(npe_invocation_var730, RealMatrix.class, 895, 39102, 39111)) {
                    final RealMatrix npe_invocation_var731 = CMAESOptimizer.triu(C, 0);
                    if (CallChecker.beforeDeref(npe_invocation_var731, RealMatrix.class, 895, 39087, 39096)) {
                        C = CallChecker.isCalled(npe_invocation_var731, RealMatrix.class, 895, 39087, 39096).add(CallChecker.isCalled(npe_invocation_var730, RealMatrix.class, 895, 39102, 39111).transpose());
                        CallChecker.varAssign(this.C, "this.C", 895, 39083, 39125);
                    }
                }
                final EigenDecomposition eig = CallChecker.varInit(new EigenDecomposition(C), "eig", 897, 39139, 39254);
                if (CallChecker.beforeDeref(eig, EigenDecomposition.class, 898, 39272, 39274)) {
                    B = CallChecker.isCalled(eig, EigenDecomposition.class, 898, 39272, 39274).getV();
                    CallChecker.varAssign(this.B, "this.B", 898, 39268, 39282);
                }
                if (CallChecker.beforeDeref(eig, EigenDecomposition.class, 899, 39351, 39353)) {
                    D = CallChecker.isCalled(eig, EigenDecomposition.class, 899, 39351, 39353).getD();
                    CallChecker.varAssign(this.D, "this.D", 899, 39347, 39361);
                }
                diagD = CMAESOptimizer.diag(D);
                CallChecker.varAssign(this.diagD, "this.diagD", 900, 39375, 39390);
                if ((CMAESOptimizer.min(diagD)) <= 0) {
                    for (int i = 0; i < (dimension); i++) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 903, 39505, 39509)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 903, 39505, 39509);
                            if ((CallChecker.isCalled(diagD, RealMatrix.class, 903, 39505, 39509).getEntry(i, 0)) < 0) {
                                if (CallChecker.beforeDeref(diagD, RealMatrix.class, 904, 39557, 39561)) {
                                    diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 904, 39557, 39561);
                                    CallChecker.isCalled(diagD, RealMatrix.class, 904, 39557, 39561).setEntry(i, 0, 0);
                                }
                            }
                        }
                    }
                    final double tfac = CallChecker.varInit(((double) ((CMAESOptimizer.max(this.diagD)) / 1.0E14)), "tfac", 907, 39638, 39675);
                    final RealMatrix npe_invocation_var732 = CMAESOptimizer.eye(dimension, dimension);
                    if (CallChecker.beforeDeref(npe_invocation_var732, RealMatrix.class, 908, 39703, 39727)) {
                        if (CallChecker.beforeDeref(C, RealMatrix.class, 908, 39697, 39697)) {
                            C = CallChecker.beforeCalled(C, RealMatrix.class, 908, 39697, 39697);
                            C = CallChecker.isCalled(C, RealMatrix.class, 908, 39697, 39697).add(CallChecker.isCalled(npe_invocation_var732, RealMatrix.class, 908, 39703, 39727).scalarMultiply(tfac));
                            CallChecker.varAssign(this.C, "this.C", 908, 39693, 39750);
                        }
                    }
                    final RealMatrix npe_invocation_var733 = CMAESOptimizer.ones(dimension, 1);
                    if (CallChecker.beforeDeref(npe_invocation_var733, RealMatrix.class, 909, 39786, 39803)) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 909, 39776, 39780)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 909, 39776, 39780);
                            diagD = CallChecker.isCalled(diagD, RealMatrix.class, 909, 39776, 39780).add(CallChecker.isCalled(npe_invocation_var733, RealMatrix.class, 909, 39786, 39803).scalarMultiply(tfac));
                            CallChecker.varAssign(this.diagD, "this.diagD", 909, 39768, 39826);
                        }
                    }
                }
                if ((CMAESOptimizer.max(diagD)) > (1.0E14 * (CMAESOptimizer.min(diagD)))) {
                    final double tfac = CallChecker.varInit(((double) (((CMAESOptimizer.max(this.diagD)) / 1.0E14) - (CMAESOptimizer.min(this.diagD)))), "tfac", 912, 39908, 39958);
                    final RealMatrix npe_invocation_var734 = CMAESOptimizer.eye(dimension, dimension);
                    if (CallChecker.beforeDeref(npe_invocation_var734, RealMatrix.class, 913, 39986, 40010)) {
                        if (CallChecker.beforeDeref(C, RealMatrix.class, 913, 39980, 39980)) {
                            C = CallChecker.beforeCalled(C, RealMatrix.class, 913, 39980, 39980);
                            C = CallChecker.isCalled(C, RealMatrix.class, 913, 39980, 39980).add(CallChecker.isCalled(npe_invocation_var734, RealMatrix.class, 913, 39986, 40010).scalarMultiply(tfac));
                            CallChecker.varAssign(this.C, "this.C", 913, 39976, 40033);
                        }
                    }
                    final RealMatrix npe_invocation_var735 = CMAESOptimizer.ones(dimension, 1);
                    if (CallChecker.beforeDeref(npe_invocation_var735, RealMatrix.class, 914, 40069, 40086)) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 914, 40059, 40063)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 914, 40059, 40063);
                            diagD = CallChecker.isCalled(diagD, RealMatrix.class, 914, 40059, 40063).add(CallChecker.isCalled(npe_invocation_var735, RealMatrix.class, 914, 40069, 40086).scalarMultiply(tfac));
                            CallChecker.varAssign(this.diagD, "this.diagD", 914, 40051, 40109);
                        }
                    }
                }
                diagC = CMAESOptimizer.diag(C);
                CallChecker.varAssign(this.diagC, "this.diagC", 916, 40137, 40152);
                diagD = CMAESOptimizer.sqrt(diagD);
                CallChecker.varAssign(this.diagD, "this.diagD", 917, 40166, 40185);
                if (CallChecker.beforeDeref(diagD, RealMatrix.class, 918, 40258, 40262)) {
                    diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 918, 40258, 40262);
                    BD = CMAESOptimizer.times(B, CMAESOptimizer.repmat(CallChecker.isCalled(diagD, RealMatrix.class, 918, 40258, 40262).transpose(), dimension, 1));
                    CallChecker.varAssign(this.BD, "this.BD", 918, 40237, 40291);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2826.methodEnd();
        }
    }

    private static void push(double[] vals, double val) {
        MethodContext _bcornu_methode_context2827 = new MethodContext(void.class, 928, 40324, 40666);
        try {
            CallChecker.varInit(val, "val", 928, 40324, 40666);
            CallChecker.varInit(vals, "vals", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 928, 40324, 40666);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 928, 40324, 40666);
            vals = CallChecker.beforeCalled(vals, double[].class, 929, 40567, 40570);
            for (int i = (CallChecker.isCalled(vals, double[].class, 929, 40567, 40570).length) - 1; i > 0; i--) {
                if (CallChecker.beforeDeref(vals, double[].class, 930, 40608, 40611)) {
                    if (CallChecker.beforeDeref(vals, double[].class, 930, 40618, 40621)) {
                        vals = CallChecker.beforeCalled(vals, double[].class, 930, 40608, 40611);
                        vals = CallChecker.beforeCalled(vals, double[].class, 930, 40618, 40621);
                        CallChecker.isCalled(vals, double[].class, 930, 40608, 40611)[i] = CallChecker.isCalled(vals, double[].class, 930, 40618, 40621)[(i - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(vals, double[].class, 930, 40608, 40611)[i], "CallChecker.isCalled(vals, double[].class, 930, 40608, 40611)[i]", 930, 40608, 40627);
                    }
                }
            }
            if (CallChecker.beforeDeref(vals, double[].class, 932, 40647, 40650)) {
                vals = CallChecker.beforeCalled(vals, double[].class, 932, 40647, 40650);
                CallChecker.isCalled(vals, double[].class, 932, 40647, 40650)[0] = val;
                CallChecker.varAssign(CallChecker.isCalled(vals, double[].class, 932, 40647, 40650)[0], "CallChecker.isCalled(vals, double[].class, 932, 40647, 40650)[0]", 932, 40647, 40660);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2827.methodEnd();
        }
    }

    private int[] sortedIndices(final double[] doubles) {
        MethodContext _bcornu_methode_context2828 = new MethodContext(int[].class, 941, 40673, 41285);
        try {
            CallChecker.varInit(this, "this", 941, 40673, 41285);
            CallChecker.varInit(doubles, "doubles", 941, 40673, 41285);
            CallChecker.varInit(this.evaluations, "evaluations", 941, 40673, 41285);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 941, 40673, 41285);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 941, 40673, 41285);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 941, 40673, 41285);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 941, 40673, 41285);
            CallChecker.varInit(this.random, "random", 941, 40673, 41285);
            CallChecker.varInit(this.historySize, "historySize", 941, 40673, 41285);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 941, 40673, 41285);
            CallChecker.varInit(this.iterations, "iterations", 941, 40673, 41285);
            CallChecker.varInit(this.diagC, "diagC", 941, 40673, 41285);
            CallChecker.varInit(this.C, "C", 941, 40673, 41285);
            CallChecker.varInit(this.diagD, "diagD", 941, 40673, 41285);
            CallChecker.varInit(this.BD, "BD", 941, 40673, 41285);
            CallChecker.varInit(this.D, "D", 941, 40673, 41285);
            CallChecker.varInit(this.B, "B", 941, 40673, 41285);
            CallChecker.varInit(this.normps, "normps", 941, 40673, 41285);
            CallChecker.varInit(this.ps, "ps", 941, 40673, 41285);
            CallChecker.varInit(this.pc, "pc", 941, 40673, 41285);
            CallChecker.varInit(this.xmean, "xmean", 941, 40673, 41285);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 941, 40673, 41285);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 941, 40673, 41285);
            CallChecker.varInit(this.chiN, "chiN", 941, 40673, 41285);
            CallChecker.varInit(this.ccovmu, "ccovmu", 941, 40673, 41285);
            CallChecker.varInit(this.ccov1, "ccov1", 941, 40673, 41285);
            CallChecker.varInit(this.damps, "damps", 941, 40673, 41285);
            CallChecker.varInit(this.cs, "cs", 941, 40673, 41285);
            CallChecker.varInit(this.cc, "cc", 941, 40673, 41285);
            CallChecker.varInit(this.sigma, "sigma", 941, 40673, 41285);
            CallChecker.varInit(this.mueff, "mueff", 941, 40673, 41285);
            CallChecker.varInit(this.weights, "weights", 941, 40673, 41285);
            CallChecker.varInit(this.logMu2, "logMu2", 941, 40673, 41285);
            CallChecker.varInit(this.mu, "mu", 941, 40673, 41285);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 941, 40673, 41285);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 941, 40673, 41285);
            CallChecker.varInit(this.stopTolX, "stopTolX", 941, 40673, 41285);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 941, 40673, 41285);
            CallChecker.varInit(this.stopFitness, "stopFitness", 941, 40673, 41285);
            CallChecker.varInit(this.maxIterations, "maxIterations", 941, 40673, 41285);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 941, 40673, 41285);
            CallChecker.varInit(this.isMinimize, "isMinimize", 941, 40673, 41285);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 941, 40673, 41285);
            CallChecker.varInit(this.dimension, "dimension", 941, 40673, 41285);
            CallChecker.varInit(this.inputSigma, "inputSigma", 941, 40673, 41285);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 941, 40673, 41285);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 941, 40673, 41285);
            CallChecker.varInit(this.lambda, "lambda", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 941, 40673, 41285);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 941, 40673, 41285);
            final CMAESOptimizer.DoubleIndex[] dis = CallChecker.varInit(new CMAESOptimizer.DoubleIndex[CallChecker.isCalled(doubles, double[].class, 942, 40945, 40951).length], "dis", 942, 40903, 40960);
            for (int i = 0; i < (CallChecker.isCalled(doubles, double[].class, 943, 40990, 40996).length); i++) {
                if (CallChecker.beforeDeref(dis, CMAESOptimizer.DoubleIndex[].class, 944, 41025, 41027)) {
                    if (CallChecker.beforeDeref(doubles, double[].class, 944, 41050, 41056)) {
                        CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 944, 41025, 41027)[i] = new CMAESOptimizer.DoubleIndex(CallChecker.isCalled(doubles, double[].class, 944, 41050, 41056)[i], i);
                        CallChecker.varAssign(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 944, 41025, 41027)[i], "CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 944, 41025, 41027)[i]", 944, 41025, 41064);
                    }
                }
            }
            Arrays.sort(dis);
            final int[] indices = CallChecker.varInit(new int[CallChecker.isCalled(doubles, double[].class, 947, 41140, 41146).length], "indices", 947, 41110, 41155);
            for (int i = 0; i < (CallChecker.isCalled(doubles, double[].class, 948, 41185, 41191).length); i++) {
                if (CallChecker.beforeDeref(indices, int[].class, 949, 41220, 41226)) {
                    if (CallChecker.beforeDeref(dis, CMAESOptimizer.DoubleIndex[].class, 949, 41233, 41235)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 949, 41233, 41235)[i], CMAESOptimizer.DoubleIndex.class, 949, 41233, 41238)) {
                            CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 949, 41233, 41235)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 949, 41233, 41235)[i], CMAESOptimizer.DoubleIndex.class, 949, 41233, 41238);
                            CallChecker.isCalled(indices, int[].class, 949, 41220, 41226)[i] = CallChecker.isCalled(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 949, 41233, 41235)[i], CMAESOptimizer.DoubleIndex.class, 949, 41233, 41238).index;
                            CallChecker.varAssign(CallChecker.isCalled(indices, int[].class, 949, 41220, 41226)[i], "CallChecker.isCalled(indices, int[].class, 949, 41220, 41226)[i]", 949, 41220, 41245);
                        }
                    }
                }
            }
            return indices;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2828.methodEnd();
        }
    }

    private static RealMatrix log(final RealMatrix m) {
        MethodContext _bcornu_methode_context2829 = new MethodContext(RealMatrix.class, 1106, 45905, 46493);
        try {
            CallChecker.varInit(m, "m", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1106, 45905, 46493);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1106, 45905, 46493);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1107, 46195, 46195).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1107, 46216, 46216).getColumnDimension()], "d", 1107, 46163, 46239);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1108, 46269, 46269).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1109, 46329, 46329).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1110, 46376, 46376)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r], double[].class, 1110, 46376, 46379)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1110, 46395, 46395)) {
                                CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r], double[].class, 1110, 46376, 46379);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r], double[].class, 1110, 46376, 46379)[c] = Math.log(CallChecker.isCalled(m, RealMatrix.class, 1110, 46395, 46395).getEntry(r, c));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r], double[].class, 1110, 46376, 46379)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1110, 46376, 46376)[r], double[].class, 1110, 46376, 46379)[c]", 1110, 46376, 46412);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2829.methodEnd();
        }
    }

    private static RealMatrix sqrt(final RealMatrix m) {
        MethodContext _bcornu_methode_context2830 = new MethodContext(RealMatrix.class, 1120, 46500, 47008);
        try {
            CallChecker.varInit(m, "m", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1120, 46500, 47008);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1120, 46500, 47008);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1121, 46709, 46709).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1121, 46730, 46730).getColumnDimension()], "d", 1121, 46677, 46753);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1122, 46783, 46783).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1123, 46843, 46843).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1124, 46890, 46890)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r], double[].class, 1124, 46890, 46893)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1124, 46910, 46910)) {
                                CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r], double[].class, 1124, 46890, 46893);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r], double[].class, 1124, 46890, 46893)[c] = Math.sqrt(CallChecker.isCalled(m, RealMatrix.class, 1124, 46910, 46910).getEntry(r, c));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r], double[].class, 1124, 46890, 46893)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1124, 46890, 46890)[r], double[].class, 1124, 46890, 46893)[c]", 1124, 46890, 46927);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2830.methodEnd();
        }
    }

    private static RealMatrix square(final RealMatrix m) {
        MethodContext _bcornu_methode_context2831 = new MethodContext(RealMatrix.class, 1134, 47015, 47543);
        try {
            CallChecker.varInit(m, "m", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1134, 47015, 47543);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1134, 47015, 47543);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1135, 47221, 47221).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1135, 47242, 47242).getColumnDimension()], "d", 1135, 47189, 47265);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1136, 47295, 47295).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1137, 47355, 47355).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1138, 47413, 47413)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1138, 47413, 47413).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1138, 47413, 47413);
                    }
                    if (CallChecker.beforeDeref(d, double[][].class, 1139, 47447, 47447)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r], double[].class, 1139, 47447, 47450)) {
                            CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r], double[].class, 1139, 47447, 47450);
                            CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r], double[].class, 1139, 47447, 47450)[c] = e * e;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r], double[].class, 1139, 47447, 47450)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1139, 47447, 47447)[r], double[].class, 1139, 47447, 47450)[c]", 1139, 47447, 47462);
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2831.methodEnd();
        }
    }

    private static RealMatrix times(final RealMatrix m, final RealMatrix n) {
        MethodContext _bcornu_methode_context2832 = new MethodContext(RealMatrix.class, 1150, 47550, 48136);
        try {
            CallChecker.varInit(n, "n", 1150, 47550, 48136);
            CallChecker.varInit(m, "m", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1150, 47550, 48136);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1150, 47550, 48136);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1151, 47829, 47829).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1151, 47850, 47850).getColumnDimension()], "d", 1151, 47797, 47873);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1152, 47903, 47903).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1153, 47963, 47963).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1154, 48010, 48010)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r], double[].class, 1154, 48010, 48013)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1154, 48020, 48020)) {
                                if (CallChecker.beforeDeref(n, RealMatrix.class, 1154, 48039, 48039)) {
                                    CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r], double[].class, 1154, 48010, 48013);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r], double[].class, 1154, 48010, 48013)[c] = (CallChecker.isCalled(m, RealMatrix.class, 1154, 48020, 48020).getEntry(r, c)) * (CallChecker.isCalled(n, RealMatrix.class, 1154, 48039, 48039).getEntry(r, c));
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r], double[].class, 1154, 48010, 48013)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1154, 48010, 48010)[r], double[].class, 1154, 48010, 48013)[c]", 1154, 48010, 48055);
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2832.methodEnd();
        }
    }

    private static RealMatrix divide(final RealMatrix m, final RealMatrix n) {
        MethodContext _bcornu_methode_context2833 = new MethodContext(RealMatrix.class, 1165, 48143, 48723);
        try {
            CallChecker.varInit(n, "n", 1165, 48143, 48723);
            CallChecker.varInit(m, "m", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1165, 48143, 48723);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1165, 48143, 48723);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1166, 48416, 48416).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1166, 48437, 48437).getColumnDimension()], "d", 1166, 48384, 48460);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1167, 48490, 48490).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1168, 48550, 48550).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1169, 48597, 48597)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r], double[].class, 1169, 48597, 48600)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1169, 48607, 48607)) {
                                if (CallChecker.beforeDeref(n, RealMatrix.class, 1169, 48626, 48626)) {
                                    CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r], double[].class, 1169, 48597, 48600);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r], double[].class, 1169, 48597, 48600)[c] = (CallChecker.isCalled(m, RealMatrix.class, 1169, 48607, 48607).getEntry(r, c)) / (CallChecker.isCalled(n, RealMatrix.class, 1169, 48626, 48626).getEntry(r, c));
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r], double[].class, 1169, 48597, 48600)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1169, 48597, 48597)[r], double[].class, 1169, 48597, 48600)[c]", 1169, 48597, 48642);
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2833.methodEnd();
        }
    }

    private static RealMatrix selectColumns(final RealMatrix m, final int[] cols) {
        MethodContext _bcornu_methode_context2834 = new MethodContext(RealMatrix.class, 1180, 48730, 49263);
        try {
            CallChecker.varInit(cols, "cols", 1180, 48730, 49263);
            CallChecker.varInit(m, "m", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1180, 48730, 49263);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1180, 48730, 49263);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1181, 48991, 48991).getRowDimension()][CallChecker.isCalled(cols, int[].class, 1181, 49012, 49015).length], "d", 1181, 48959, 49024);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1182, 49054, 49054).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(cols, int[].class, 1183, 49114, 49117).length); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1184, 49150, 49150)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r], double[].class, 1184, 49150, 49153)) {
                            if (CallChecker.beforeDeref(cols, int[].class, 1184, 49174, 49177)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1184, 49160, 49160)) {
                                    CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r], double[].class, 1184, 49150, 49153);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r], double[].class, 1184, 49150, 49153)[c] = CallChecker.isCalled(m, RealMatrix.class, 1184, 49160, 49160).getEntry(r, CallChecker.isCalled(cols, int[].class, 1184, 49174, 49177)[c]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r], double[].class, 1184, 49150, 49153)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1184, 49150, 49150)[r], double[].class, 1184, 49150, 49153)[c]", 1184, 49150, 49182);
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2834.methodEnd();
        }
    }

    private static RealMatrix triu(final RealMatrix m, int k) {
        MethodContext _bcornu_methode_context2835 = new MethodContext(RealMatrix.class, 1195, 49270, 49804);
        try {
            CallChecker.varInit(k, "k", 1195, 49270, 49804);
            CallChecker.varInit(m, "m", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1195, 49270, 49804);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1195, 49270, 49804);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1196, 49499, 49499).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1196, 49520, 49520).getColumnDimension()], "d", 1196, 49467, 49543);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1197, 49573, 49573).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1198, 49633, 49633).getColumnDimension()); c++) {
                    if (r <= (c - k)) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1199, 49680, 49680)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1199, 49703, 49703)) {
                                    CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c] = CallChecker.isCalled(m, RealMatrix.class, 1199, 49703, 49703).getEntry(r, c);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c]", 1199, 49680, 49723);
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(d, double[][].class, 1199, 49680, 49680)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)) {
                                CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1199, 49680, 49680)[r], double[].class, 1199, 49680, 49683)[c]", 1199, 49680, 49723);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2835.methodEnd();
        }
    }

    private static RealMatrix sumRows(final RealMatrix m) {
        MethodContext _bcornu_methode_context2836 = new MethodContext(RealMatrix.class, 1209, 49811, 50336);
        try {
            CallChecker.varInit(m, "m", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1209, 49811, 50336);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1209, 49811, 50336);
            final double[][] d = CallChecker.varInit(new double[1][CallChecker.isCalled(m, RealMatrix.class, 1210, 50017, 50017).getColumnDimension()], "d", 1210, 49982, 50040);
            for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1211, 50070, 50070).getColumnDimension()); c++) {
                double sum = CallChecker.varInit(((double) (0)), "sum", 1212, 50113, 50127);
                for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1213, 50161, 50161).getRowDimension()); r++) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1214, 50212, 50212)) {
                        sum += CallChecker.isCalled(m, RealMatrix.class, 1214, 50212, 50212).getEntry(r, c);
                        CallChecker.varAssign(sum, "sum", 1214, 50205, 50228);
                    }
                }
                if (CallChecker.beforeDeref(d, double[][].class, 1216, 50256, 50256)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0], double[].class, 1216, 50256, 50259)) {
                        CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0], double[].class, 1216, 50256, 50259);
                        CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0], double[].class, 1216, 50256, 50259)[c] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0], double[].class, 1216, 50256, 50259)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1216, 50256, 50256)[0], double[].class, 1216, 50256, 50259)[c]", 1216, 50256, 50269);
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2836.methodEnd();
        }
    }

    private static RealMatrix diag(final RealMatrix m) {
        MethodContext _bcornu_methode_context2837 = new MethodContext(RealMatrix.class, 1226, 50343, 51166);
        try {
            CallChecker.varInit(m, "m", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1226, 50343, 51166);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1226, 50343, 51166);
            if (CallChecker.beforeDeref(m, RealMatrix.class, 1227, 50599, 50599)) {
                if ((CallChecker.isCalled(m, RealMatrix.class, 1227, 50599, 50599).getColumnDimension()) == 1) {
                    final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1228, 50674, 50674).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1228, 50695, 50695).getRowDimension()], "d", 1228, 50642, 50715);
                    for (int i = 0; i < (CallChecker.isCalled(m, RealMatrix.class, 1229, 50749, 50749).getRowDimension()); i++) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1230, 50793, 50793)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i], double[].class, 1230, 50793, 50796)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1230, 50803, 50803)) {
                                    CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i], double[].class, 1230, 50793, 50796);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i], double[].class, 1230, 50793, 50796)[i] = CallChecker.isCalled(m, RealMatrix.class, 1230, 50803, 50803).getEntry(i, 0);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i], double[].class, 1230, 50793, 50796)[i], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1230, 50793, 50793)[i], double[].class, 1230, 50793, 50796)[i]", 1230, 50793, 50819);
                                }
                            }
                        }
                    }
                    return new Array2DRowRealMatrix(d, false);
                }else {
                    final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1234, 50951, 50951).getRowDimension()][1], "d", 1234, 50919, 50974);
                    for (int i = 0; i < (CallChecker.isCalled(m, RealMatrix.class, 1235, 51008, 51008).getColumnDimension()); i++) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1236, 51055, 51055)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i], double[].class, 1236, 51055, 51058)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1236, 51065, 51065)) {
                                    CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i], double[].class, 1236, 51055, 51058);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i], double[].class, 1236, 51055, 51058)[0] = CallChecker.isCalled(m, RealMatrix.class, 1236, 51065, 51065).getEntry(i, i);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i], double[].class, 1236, 51055, 51058)[0], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1236, 51055, 51055)[i], double[].class, 1236, 51055, 51058)[0]", 1236, 51055, 51081);
                                }
                            }
                        }
                    }
                    return new Array2DRowRealMatrix(d, false);
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2837.methodEnd();
        }
    }

    private static void copyColumn(final RealMatrix m1, int col1, RealMatrix m2, int col2) {
        MethodContext _bcornu_methode_context2838 = new MethodContext(void.class, 1250, 51173, 51617);
        try {
            CallChecker.varInit(col2, "col2", 1250, 51173, 51617);
            CallChecker.varInit(m2, "m2", 1250, 51173, 51617);
            CallChecker.varInit(col1, "col1", 1250, 51173, 51617);
            CallChecker.varInit(m1, "m1", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1250, 51173, 51617);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1250, 51173, 51617);
            for (int i = 0; i < (CallChecker.isCalled(m1, RealMatrix.class, 1252, 51518, 51519).getRowDimension()); i++) {
                if (CallChecker.beforeDeref(m1, RealMatrix.class, 1253, 51580, 51581)) {
                    if (CallChecker.beforeDeref(m2, RealMatrix.class, 1253, 51559, 51560)) {
                        m2 = CallChecker.beforeCalled(m2, RealMatrix.class, 1253, 51559, 51560);
                        CallChecker.isCalled(m2, RealMatrix.class, 1253, 51559, 51560).setEntry(i, col2, CallChecker.isCalled(m1, RealMatrix.class, 1253, 51580, 51581).getEntry(i, col1));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2838.methodEnd();
        }
    }

    private static RealMatrix ones(int n, int m) {
        MethodContext _bcornu_methode_context2839 = new MethodContext(RealMatrix.class, 1262, 51624, 51982);
        try {
            CallChecker.varInit(m, "m", 1262, 51624, 51982);
            CallChecker.varInit(n, "n", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1262, 51624, 51982);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1262, 51624, 51982);
            final double[][] d = CallChecker.varInit(new double[n][m], "d", 1263, 51806, 51843);
            for (int r = 0; r < n; r++) {
                if (CallChecker.beforeDeref(d, double[][].class, 1265, 51907, 51907)) {
                    Arrays.fill(CallChecker.isCalled(d, double[][].class, 1265, 51907, 51907)[r], 1);
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2839.methodEnd();
        }
    }

    private static RealMatrix eye(int n, int m) {
        MethodContext _bcornu_methode_context2840 = new MethodContext(RealMatrix.class, 1276, 51989, 52431);
        try {
            CallChecker.varInit(m, "m", 1276, 51989, 52431);
            CallChecker.varInit(n, "n", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1276, 51989, 52431);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1276, 51989, 52431);
            final double[][] d = CallChecker.varInit(new double[n][m], "d", 1277, 52221, 52258);
            for (int r = 0; r < n; r++) {
                if (r < m) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1280, 52339, 52339)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r], double[].class, 1280, 52339, 52342)) {
                            CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r], double[].class, 1280, 52339, 52342);
                            CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r], double[].class, 1280, 52339, 52342)[r] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r], double[].class, 1280, 52339, 52342)[r], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1280, 52339, 52339)[r], double[].class, 1280, 52339, 52342)[r]", 1280, 52339, 52350);
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2840.methodEnd();
        }
    }

    private static RealMatrix zeros(int n, int m) {
        MethodContext _bcornu_methode_context2841 = new MethodContext(RealMatrix.class, 1291, 52438, 52665);
        try {
            CallChecker.varInit(m, "m", 1291, 52438, 52665);
            CallChecker.varInit(n, "n", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1291, 52438, 52665);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1291, 52438, 52665);
            return new Array2DRowRealMatrix(n, m);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2841.methodEnd();
        }
    }

    private static RealMatrix repmat(final RealMatrix mat, int n, int m) {
        MethodContext _bcornu_methode_context2842 = new MethodContext(RealMatrix.class, 1301, 52672, 53333);
        try {
            CallChecker.varInit(m, "m", 1301, 52672, 53333);
            CallChecker.varInit(n, "n", 1301, 52672, 53333);
            CallChecker.varInit(mat, "mat", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1301, 52672, 53333);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1301, 52672, 53333);
            final int rd = CallChecker.varInit(((int) (CallChecker.isCalled(mat, RealMatrix.class, 1302, 52979, 52981).getRowDimension())), "rd", 1302, 52964, 53000);
            final int cd = CallChecker.varInit(((int) (CallChecker.isCalled(mat, RealMatrix.class, 1303, 53025, 53027).getColumnDimension())), "cd", 1303, 53010, 53049);
            final double[][] d = CallChecker.varInit(new double[n * rd][m * cd], "d", 1304, 53059, 53106);
            for (int r = 0; r < (n * rd); r++) {
                for (int c = 0; c < (m * cd); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1307, 53214, 53214)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r], double[].class, 1307, 53214, 53217)) {
                            if (CallChecker.beforeDeref(mat, RealMatrix.class, 1307, 53224, 53226)) {
                                CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r], double[].class, 1307, 53214, 53217);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r], double[].class, 1307, 53214, 53217)[c] = CallChecker.isCalled(mat, RealMatrix.class, 1307, 53224, 53226).getEntry((r % rd), (c % cd));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r], double[].class, 1307, 53214, 53217)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1307, 53214, 53214)[r], double[].class, 1307, 53214, 53217)[c]", 1307, 53214, 53252);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2842.methodEnd();
        }
    }

    private static RealMatrix sequence(double start, double end, double step) {
        MethodContext _bcornu_methode_context2843 = new MethodContext(RealMatrix.class, 1319, 53340, 53869);
        try {
            CallChecker.varInit(step, "step", 1319, 53340, 53869);
            CallChecker.varInit(end, "end", 1319, 53340, 53869);
            CallChecker.varInit(start, "start", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1319, 53340, 53869);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1319, 53340, 53869);
            final int size = CallChecker.varInit(((int) ((int) (((end - start) / step) + 1))), "size", 1320, 53576, 53625);
            final double[][] d = CallChecker.varInit(new double[size][1], "d", 1321, 53635, 53675);
            double value = CallChecker.varInit(((double) (start)), "value", 1322, 53685, 53705);
            for (int r = 0; r < size; r++) {
                if (CallChecker.beforeDeref(d, double[][].class, 1324, 53760, 53760)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r], double[].class, 1324, 53760, 53763)) {
                        CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r], double[].class, 1324, 53760, 53763);
                        CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r], double[].class, 1324, 53760, 53763)[0] = value;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r], double[].class, 1324, 53760, 53763)[0], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1324, 53760, 53760)[r], double[].class, 1324, 53760, 53763)[0]", 1324, 53760, 53775);
                    }
                }
                value += step;
                CallChecker.varAssign(value, "value", 1325, 53789, 53802);
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2843.methodEnd();
        }
    }

    private static double max(final RealMatrix m) {
        MethodContext _bcornu_methode_context2844 = new MethodContext(double.class, 1334, 53876, 54357);
        try {
            CallChecker.varInit(m, "m", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1334, 53876, 54357);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1334, 53876, 54357);
            double max = CallChecker.varInit(((double) (-(Double.MAX_VALUE))), "max", 1335, 54035, 54065);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1336, 54095, 54095).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1337, 54155, 54155).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1338, 54213, 54213)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1338, 54213, 54213).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1338, 54213, 54213);
                    }
                    if (max < e) {
                        max = e;
                        CallChecker.varAssign(max, "max", 1340, 54282, 54289);
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2844.methodEnd();
        }
    }

    private static double min(final RealMatrix m) {
        MethodContext _bcornu_methode_context2845 = new MethodContext(double.class, 1351, 54364, 54844);
        try {
            CallChecker.varInit(m, "m", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1351, 54364, 54844);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1351, 54364, 54844);
            double min = CallChecker.varInit(((double) (Double.MAX_VALUE)), "min", 1352, 54523, 54552);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1353, 54582, 54582).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1354, 54642, 54642).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1355, 54700, 54700)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1355, 54700, 54700).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1355, 54700, 54700);
                    }
                    if (min > e) {
                        min = e;
                        CallChecker.varAssign(min, "min", 1357, 54769, 54776);
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2845.methodEnd();
        }
    }

    private static double max(final double[] m) {
        MethodContext _bcornu_methode_context2846 = new MethodContext(double.class, 1368, 54851, 55181);
        try {
            CallChecker.varInit(m, "m", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1368, 54851, 55181);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1368, 54851, 55181);
            double max = CallChecker.varInit(((double) (-(Double.MAX_VALUE))), "max", 1369, 54998, 55028);
            for (int r = 0; r < (CallChecker.isCalled(m, double[].class, 1370, 55058, 55058).length); r++) {
                if (CallChecker.beforeDeref(m, double[].class, 1371, 55097, 55097)) {
                    if (max < (CallChecker.isCalled(m, double[].class, 1371, 55097, 55097)[r])) {
                        if (CallChecker.beforeDeref(m, double[].class, 1372, 55127, 55127)) {
                            max = CallChecker.isCalled(m, double[].class, 1372, 55127, 55127)[r];
                            CallChecker.varAssign(max, "max", 1372, 55121, 55131);
                        }
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2846.methodEnd();
        }
    }

    private static double min(final double[] m) {
        MethodContext _bcornu_methode_context2847 = new MethodContext(double.class, 1382, 55188, 55517);
        try {
            CallChecker.varInit(m, "m", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1382, 55188, 55517);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1382, 55188, 55517);
            double min = CallChecker.varInit(((double) (Double.MAX_VALUE)), "min", 1383, 55335, 55364);
            for (int r = 0; r < (CallChecker.isCalled(m, double[].class, 1384, 55394, 55394).length); r++) {
                if (CallChecker.beforeDeref(m, double[].class, 1385, 55433, 55433)) {
                    if (min > (CallChecker.isCalled(m, double[].class, 1385, 55433, 55433)[r])) {
                        if (CallChecker.beforeDeref(m, double[].class, 1386, 55463, 55463)) {
                            min = CallChecker.isCalled(m, double[].class, 1386, 55463, 55463)[r];
                            CallChecker.varAssign(min, "min", 1386, 55457, 55467);
                        }
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2847.methodEnd();
        }
    }

    private static int[] inverse(final int[] indices) {
        MethodContext _bcornu_methode_context2848 = new MethodContext(int[].class, 1396, 55524, 55876);
        try {
            CallChecker.varInit(indices, "indices", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1396, 55524, 55876);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1396, 55524, 55876);
            final int[] inverse = CallChecker.varInit(new int[CallChecker.isCalled(indices, int[].class, 1397, 55733, 55739).length], "inverse", 1397, 55703, 55748);
            for (int i = 0; i < (CallChecker.isCalled(indices, int[].class, 1398, 55778, 55784).length); i++) {
                if (CallChecker.beforeDeref(indices, int[].class, 1399, 55821, 55827)) {
                    if (CallChecker.beforeDeref(inverse, int[].class, 1399, 55813, 55819)) {
                        CallChecker.isCalled(inverse, int[].class, 1399, 55813, 55819)[CallChecker.isCalled(indices, int[].class, 1399, 55821, 55827)[i]] = i;
                        CallChecker.varAssign(CallChecker.isCalled(inverse, int[].class, 1399, 55813, 55819)[CallChecker.isCalled(indices, int[].class, 1399, 55821, 55827)[i]], "CallChecker.isCalled(inverse, int[].class, 1399, 55813, 55819)[CallChecker.isCalled(indices, int[].class, 1399, 55821, 55827)[i]]", 1399, 55813, 55836);
                    }
                }
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2848.methodEnd();
        }
    }

    private static int[] reverse(final int[] indices) {
        MethodContext _bcornu_methode_context2849 = new MethodContext(int[].class, 1408, 55883, 56255);
        try {
            CallChecker.varInit(indices, "indices", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1408, 55883, 56255);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1408, 55883, 56255);
            final int[] reverse = CallChecker.varInit(new int[CallChecker.isCalled(indices, int[].class, 1409, 56091, 56097).length], "reverse", 1409, 56061, 56106);
            for (int i = 0; i < (CallChecker.isCalled(indices, int[].class, 1410, 56136, 56142).length); i++) {
                if (CallChecker.beforeDeref(reverse, int[].class, 1411, 56171, 56177)) {
                    if (CallChecker.beforeDeref(indices, int[].class, 1411, 56192, 56198)) {
                        if (CallChecker.beforeDeref(indices, int[].class, 1411, 56184, 56190)) {
                            CallChecker.isCalled(reverse, int[].class, 1411, 56171, 56177)[i] = CallChecker.isCalled(indices, int[].class, 1411, 56184, 56190)[(((CallChecker.isCalled(indices, int[].class, 1411, 56192, 56198).length) - i) - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(reverse, int[].class, 1411, 56171, 56177)[i], "CallChecker.isCalled(reverse, int[].class, 1411, 56171, 56177)[i]", 1411, 56171, 56215);
                        }
                    }
                }
            }
            return reverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2849.methodEnd();
        }
    }

    private double[] randn(int size) {
        MethodContext _bcornu_methode_context2850 = new MethodContext(double[].class, 1420, 56262, 56580);
        try {
            CallChecker.varInit(this, "this", 1420, 56262, 56580);
            CallChecker.varInit(size, "size", 1420, 56262, 56580);
            CallChecker.varInit(this.evaluations, "evaluations", 1420, 56262, 56580);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 1420, 56262, 56580);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 1420, 56262, 56580);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 1420, 56262, 56580);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 1420, 56262, 56580);
            CallChecker.varInit(this.random, "random", 1420, 56262, 56580);
            CallChecker.varInit(this.historySize, "historySize", 1420, 56262, 56580);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 1420, 56262, 56580);
            CallChecker.varInit(this.iterations, "iterations", 1420, 56262, 56580);
            CallChecker.varInit(this.diagC, "diagC", 1420, 56262, 56580);
            CallChecker.varInit(this.C, "C", 1420, 56262, 56580);
            CallChecker.varInit(this.diagD, "diagD", 1420, 56262, 56580);
            CallChecker.varInit(this.BD, "BD", 1420, 56262, 56580);
            CallChecker.varInit(this.D, "D", 1420, 56262, 56580);
            CallChecker.varInit(this.B, "B", 1420, 56262, 56580);
            CallChecker.varInit(this.normps, "normps", 1420, 56262, 56580);
            CallChecker.varInit(this.ps, "ps", 1420, 56262, 56580);
            CallChecker.varInit(this.pc, "pc", 1420, 56262, 56580);
            CallChecker.varInit(this.xmean, "xmean", 1420, 56262, 56580);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 1420, 56262, 56580);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 1420, 56262, 56580);
            CallChecker.varInit(this.chiN, "chiN", 1420, 56262, 56580);
            CallChecker.varInit(this.ccovmu, "ccovmu", 1420, 56262, 56580);
            CallChecker.varInit(this.ccov1, "ccov1", 1420, 56262, 56580);
            CallChecker.varInit(this.damps, "damps", 1420, 56262, 56580);
            CallChecker.varInit(this.cs, "cs", 1420, 56262, 56580);
            CallChecker.varInit(this.cc, "cc", 1420, 56262, 56580);
            CallChecker.varInit(this.sigma, "sigma", 1420, 56262, 56580);
            CallChecker.varInit(this.mueff, "mueff", 1420, 56262, 56580);
            CallChecker.varInit(this.weights, "weights", 1420, 56262, 56580);
            CallChecker.varInit(this.logMu2, "logMu2", 1420, 56262, 56580);
            CallChecker.varInit(this.mu, "mu", 1420, 56262, 56580);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 1420, 56262, 56580);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 1420, 56262, 56580);
            CallChecker.varInit(this.stopTolX, "stopTolX", 1420, 56262, 56580);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 1420, 56262, 56580);
            CallChecker.varInit(this.stopFitness, "stopFitness", 1420, 56262, 56580);
            CallChecker.varInit(this.maxIterations, "maxIterations", 1420, 56262, 56580);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 1420, 56262, 56580);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1420, 56262, 56580);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 1420, 56262, 56580);
            CallChecker.varInit(this.dimension, "dimension", 1420, 56262, 56580);
            CallChecker.varInit(this.inputSigma, "inputSigma", 1420, 56262, 56580);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 1420, 56262, 56580);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 1420, 56262, 56580);
            CallChecker.varInit(this.lambda, "lambda", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1420, 56262, 56580);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1420, 56262, 56580);
            final double[] randn = CallChecker.varInit(new double[size], "randn", 1421, 56416, 56455);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(randn, double[].class, 1423, 56510, 56514)) {
                    if (CallChecker.beforeDeref(random, RandomGenerator.class, 1423, 56521, 56526)) {
                        random = CallChecker.beforeCalled(random, RandomGenerator.class, 1423, 56521, 56526);
                        CallChecker.isCalled(randn, double[].class, 1423, 56510, 56514)[i] = CallChecker.isCalled(random, RandomGenerator.class, 1423, 56521, 56526).nextGaussian();
                        CallChecker.varAssign(CallChecker.isCalled(randn, double[].class, 1423, 56510, 56514)[i], "CallChecker.isCalled(randn, double[].class, 1423, 56510, 56514)[i]", 1423, 56510, 56542);
                    }
                }
            }
            return randn;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2850.methodEnd();
        }
    }

    private RealMatrix randn1(int size, int popSize) {
        MethodContext _bcornu_methode_context2851 = new MethodContext(RealMatrix.class, 1433, 56587, 57067);
        try {
            CallChecker.varInit(this, "this", 1433, 56587, 57067);
            CallChecker.varInit(popSize, "popSize", 1433, 56587, 57067);
            CallChecker.varInit(size, "size", 1433, 56587, 57067);
            CallChecker.varInit(this.evaluations, "evaluations", 1433, 56587, 57067);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 1433, 56587, 57067);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 1433, 56587, 57067);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 1433, 56587, 57067);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 1433, 56587, 57067);
            CallChecker.varInit(this.random, "random", 1433, 56587, 57067);
            CallChecker.varInit(this.historySize, "historySize", 1433, 56587, 57067);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 1433, 56587, 57067);
            CallChecker.varInit(this.iterations, "iterations", 1433, 56587, 57067);
            CallChecker.varInit(this.diagC, "diagC", 1433, 56587, 57067);
            CallChecker.varInit(this.C, "C", 1433, 56587, 57067);
            CallChecker.varInit(this.diagD, "diagD", 1433, 56587, 57067);
            CallChecker.varInit(this.BD, "BD", 1433, 56587, 57067);
            CallChecker.varInit(this.D, "D", 1433, 56587, 57067);
            CallChecker.varInit(this.B, "B", 1433, 56587, 57067);
            CallChecker.varInit(this.normps, "normps", 1433, 56587, 57067);
            CallChecker.varInit(this.ps, "ps", 1433, 56587, 57067);
            CallChecker.varInit(this.pc, "pc", 1433, 56587, 57067);
            CallChecker.varInit(this.xmean, "xmean", 1433, 56587, 57067);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 1433, 56587, 57067);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 1433, 56587, 57067);
            CallChecker.varInit(this.chiN, "chiN", 1433, 56587, 57067);
            CallChecker.varInit(this.ccovmu, "ccovmu", 1433, 56587, 57067);
            CallChecker.varInit(this.ccov1, "ccov1", 1433, 56587, 57067);
            CallChecker.varInit(this.damps, "damps", 1433, 56587, 57067);
            CallChecker.varInit(this.cs, "cs", 1433, 56587, 57067);
            CallChecker.varInit(this.cc, "cc", 1433, 56587, 57067);
            CallChecker.varInit(this.sigma, "sigma", 1433, 56587, 57067);
            CallChecker.varInit(this.mueff, "mueff", 1433, 56587, 57067);
            CallChecker.varInit(this.weights, "weights", 1433, 56587, 57067);
            CallChecker.varInit(this.logMu2, "logMu2", 1433, 56587, 57067);
            CallChecker.varInit(this.mu, "mu", 1433, 56587, 57067);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 1433, 56587, 57067);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 1433, 56587, 57067);
            CallChecker.varInit(this.stopTolX, "stopTolX", 1433, 56587, 57067);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 1433, 56587, 57067);
            CallChecker.varInit(this.stopFitness, "stopFitness", 1433, 56587, 57067);
            CallChecker.varInit(this.maxIterations, "maxIterations", 1433, 56587, 57067);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 1433, 56587, 57067);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1433, 56587, 57067);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 1433, 56587, 57067);
            CallChecker.varInit(this.dimension, "dimension", 1433, 56587, 57067);
            CallChecker.varInit(this.inputSigma, "inputSigma", 1433, 56587, 57067);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 1433, 56587, 57067);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 1433, 56587, 57067);
            CallChecker.varInit(this.lambda, "lambda", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_RANDOMGENERATOR, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_RANDOMGENERATOR", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_DIAGONALONLY, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_DIAGONALONLY", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_MAXITERATIONS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_MAXITERATIONS", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_ISACTIVECMA, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_ISACTIVECMA", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_STOPFITNESS, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_STOPFITNESS", 1433, 56587, 57067);
            CallChecker.varInit(DEFAULT_CHECKFEASABLECOUNT, "org.apache.commons.math3.optimization.direct.CMAESOptimizer.DEFAULT_CHECKFEASABLECOUNT", 1433, 56587, 57067);
            final double[][] d = CallChecker.varInit(new double[size][popSize], "d", 1434, 56802, 56848);
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < popSize; c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1437, 56955, 56955)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r], double[].class, 1437, 56955, 56958)) {
                            if (CallChecker.beforeDeref(random, RandomGenerator.class, 1437, 56965, 56970)) {
                                CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r], double[].class, 1437, 56955, 56958);
                                random = CallChecker.beforeCalled(random, RandomGenerator.class, 1437, 56965, 56970);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r], double[].class, 1437, 56955, 56958)[c] = CallChecker.isCalled(random, RandomGenerator.class, 1437, 56965, 56970).nextGaussian();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r], double[].class, 1437, 56955, 56958)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1437, 56955, 56955)[r], double[].class, 1437, 56955, 56958)[c]", 1437, 56955, 56986);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2851.methodEnd();
        }
    }
}

