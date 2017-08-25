package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.MathArrays;

public class CMAESOptimizer extends MultivariateOptimizer {
    public static class Sigma implements OptimizationData {
        private final double[] sigma;

        public Sigma(double[] s) throws NotPositiveException {
            ConstructorContext _bcornu_methode_context649 = new ConstructorContext(CMAESOptimizer.Sigma.class, 289, 11792, 12229);
            try {
                s = CallChecker.beforeCalled(s, double[].class, 291, 12050, 12050);
                for (int i = 0; i < (CallChecker.isCalled(s, double[].class, 291, 12050, 12050).length); i++) {
                    if (CallChecker.beforeDeref(s, double[].class, 292, 12087, 12087)) {
                        s = CallChecker.beforeCalled(s, double[].class, 292, 12087, 12087);
                        if ((CallChecker.isCalled(s, double[].class, 292, 12087, 12087)[i]) < 0) {
                            if (CallChecker.beforeDeref(s, double[].class, 293, 12150, 12150)) {
                                s = CallChecker.beforeCalled(s, double[].class, 293, 12150, 12150);
                                throw new NotPositiveException(CallChecker.isCalled(s, double[].class, 293, 12150, 12150)[i]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                s = CallChecker.beforeCalled(s, double[].class, 297, 12210, 12210);
                sigma = CallChecker.isCalled(s, double[].class, 297, 12210, 12210).clone();
                CallChecker.varAssign(this.sigma, "this.sigma", 297, 12202, 12219);
            } finally {
                _bcornu_methode_context649.methodEnd();
            }
        }

        public double[] getSigma() {
            MethodContext _bcornu_methode_context2852 = new MethodContext(double[].class, 303, 12240, 12372);
            try {
                CallChecker.varInit(this, "this", 303, 12240, 12372);
                CallChecker.varInit(this.sigma, "sigma", 303, 12240, 12372);
                if (CallChecker.beforeDeref(sigma, double[].class, 304, 12349, 12353)) {
                    return CallChecker.isCalled(sigma, double[].class, 304, 12349, 12353).clone();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2852.methodEnd();
            }
        }
    }

    public static class PopulationSize implements OptimizationData {
        private final int lambda;

        public PopulationSize(int size) throws NotStrictlyPositiveException {
            ConstructorContext _bcornu_methode_context650 = new ConstructorContext(CMAESOptimizer.PopulationSize.class, 326, 12993, 13349);
            try {
                if (size <= 0) {
                    throw new NotStrictlyPositiveException(size);
                }
                lambda = size;
                CallChecker.varAssign(this.lambda, "this.lambda", 331, 13326, 13339);
            } finally {
                _bcornu_methode_context650.methodEnd();
            }
        }

        public int getPopulationSize() {
            MethodContext _bcornu_methode_context2853 = new MethodContext(int.class, 337, 13360, 13492);
            try {
                CallChecker.varInit(this, "this", 337, 13360, 13492);
                CallChecker.varInit(this.lambda, "lambda", 337, 13360, 13492);
                return lambda;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2853.methodEnd();
            }
        }
    }

    private static class DoubleIndex implements Comparable<CMAESOptimizer.DoubleIndex> {
        private final double value;

        private final int index;

        DoubleIndex(double value, int index) {
            ConstructorContext _bcornu_methode_context651 = new ConstructorContext(CMAESOptimizer.DoubleIndex.class, 840, 35223, 35449);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 841, 35389, 35407);
                this.index = index;
                CallChecker.varAssign(this.index, "this.index", 842, 35421, 35439);
            } finally {
                _bcornu_methode_context651.methodEnd();
            }
        }

        public int compareTo(CMAESOptimizer.DoubleIndex o) {
            MethodContext _bcornu_methode_context2854 = new MethodContext(int.class, 846, 35460, 35586);
            try {
                CallChecker.varInit(this, "this", 846, 35460, 35586);
                CallChecker.varInit(o, "o", 846, 35460, 35586);
                CallChecker.varInit(this.index, "index", 846, 35460, 35586);
                CallChecker.varInit(this.value, "value", 846, 35460, 35586);
                if (CallChecker.beforeDeref(o, CMAESOptimizer.DoubleIndex.class, 847, 35568, 35568)) {
                    o = CallChecker.beforeCalled(o, CMAESOptimizer.DoubleIndex.class, 847, 35568, 35568);
                    return Double.compare(value, CallChecker.isCalled(o, CMAESOptimizer.DoubleIndex.class, 847, 35568, 35568).value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2854.methodEnd();
            }
        }

        @Override
        public boolean equals(Object other) {
            MethodContext _bcornu_methode_context2855 = new MethodContext(boolean.class, 852, 35597, 35937);
            try {
                CallChecker.varInit(this, "this", 852, 35597, 35937);
                CallChecker.varInit(other, "other", 852, 35597, 35937);
                CallChecker.varInit(this.index, "index", 852, 35597, 35937);
                CallChecker.varInit(this.value, "value", 852, 35597, 35937);
                if ((this) == other) {
                    return true;
                }
                if (other instanceof CMAESOptimizer.DoubleIndex) {
                    if (CallChecker.beforeDeref(other, Object.class, 859, 35868, 35872)) {
                        other = CallChecker.beforeCalled(other, CMAESOptimizer.DoubleIndex.class, 859, 35868, 35872);
                        return (Double.compare(value, CallChecker.isCalled(((CMAESOptimizer.DoubleIndex) (other)), CMAESOptimizer.DoubleIndex.class, 859, 35868, 35872).value)) == 0;
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2855.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2856 = new MethodContext(int.class, 867, 35948, 36157);
            try {
                CallChecker.varInit(this, "this", 867, 35948, 36157);
                CallChecker.varInit(this.index, "index", 867, 35948, 36157);
                CallChecker.varInit(this.value, "value", 867, 35948, 36157);
                long bits = CallChecker.varInit(((long) (Double.doubleToLongBits(this.value))), "bits", 868, 36031, 36073);
                return ((int) (((1438542 ^ (bits >>> 32)) ^ bits) & -1));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2856.methodEnd();
            }
        }
    }

    private class FitnessFunction {
        private double valueRange;

        private final boolean isRepairMode;

        public FitnessFunction() {
            ConstructorContext _bcornu_methode_context652 = new ConstructorContext(CMAESOptimizer.FitnessFunction.class, 889, 36674, 36814);
            try {
                valueRange = 1;
                CallChecker.varAssign(this.valueRange, "this.valueRange", 890, 36757, 36771);
                isRepairMode = true;
                CallChecker.varAssign(this.isRepairMode, "this.isRepairMode", 891, 36785, 36804);
            } finally {
                _bcornu_methode_context652.methodEnd();
            }
        }

        public double value(final double[] point) {
            MethodContext _bcornu_methode_context2857 = new MethodContext(double.class, 898, 36825, 37417);
            try {
                CallChecker.varInit(this, "this", 898, 36825, 37417);
                CallChecker.varInit(point, "point", 898, 36825, 37417);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 898, 36825, 37417);
                CallChecker.varInit(this.valueRange, "valueRange", 898, 36825, 37417);
                double value = CallChecker.init(double.class);
                if (isRepairMode) {
                    double[] repaired = CallChecker.varInit(repair(point), "repaired", 901, 37093, 37126);
                    value = (CMAESOptimizer.this.computeObjectiveValue(repaired)) + (penalty(point, repaired));
                    CallChecker.varAssign(value, "value", 902, 37144, 37250);
                }else {
                    value = CMAESOptimizer.this.computeObjectiveValue(point);
                    CallChecker.varAssign(value, "value", 905, 37289, 37345);
                }
                if (isMinimize) {
                    return value;
                }else {
                    return -value;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2857.methodEnd();
            }
        }

        public boolean isFeasible(final double[] x) {
            MethodContext _bcornu_methode_context2858 = new MethodContext(boolean.class, 914, 37428, 38007);
            try {
                CallChecker.varInit(this, "this", 914, 37428, 38007);
                CallChecker.varInit(x, "x", 914, 37428, 38007);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 914, 37428, 38007);
                CallChecker.varInit(this.valueRange, "valueRange", 914, 37428, 38007);
                final double[] lB = CallChecker.varInit(CMAESOptimizer.this.getLowerBound(), "lB", 915, 37608, 37663);
                final double[] uB = CallChecker.varInit(CMAESOptimizer.this.getUpperBound(), "uB", 916, 37677, 37732);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 918, 37767, 37767).length); i++) {
                    if (CallChecker.beforeDeref(x, double[].class, 919, 37804, 37804)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 919, 37811, 37812)) {
                            if ((CallChecker.isCalled(x, double[].class, 919, 37804, 37804)[i]) < (CallChecker.isCalled(lB, double[].class, 919, 37811, 37812)[i])) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, double[].class, 922, 37892, 37892)) {
                        if (CallChecker.beforeDeref(uB, double[].class, 922, 37899, 37900)) {
                            if ((CallChecker.isCalled(x, double[].class, 922, 37892, 37892)[i]) > (CallChecker.isCalled(uB, double[].class, 922, 37899, 37900)[i])) {
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
                _bcornu_methode_context2858.methodEnd();
            }
        }

        public void setValueRange(double valueRange) {
            MethodContext _bcornu_methode_context2859 = new MethodContext(void.class, 932, 38018, 38201);
            try {
                CallChecker.varInit(this, "this", 932, 38018, 38201);
                CallChecker.varInit(valueRange, "valueRange", 932, 38018, 38201);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 932, 38018, 38201);
                CallChecker.varInit(this.valueRange, "valueRange", 932, 38018, 38201);
                this.valueRange = valueRange;
                CallChecker.varAssign(this.valueRange, "this.valueRange", 933, 38163, 38191);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2859.methodEnd();
            }
        }

        private double[] repair(final double[] x) {
            MethodContext _bcornu_methode_context2860 = new MethodContext(double[].class, 940, 38212, 38949);
            try {
                CallChecker.varInit(this, "this", 940, 38212, 38949);
                CallChecker.varInit(x, "x", 940, 38212, 38949);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 940, 38212, 38949);
                CallChecker.varInit(this.valueRange, "valueRange", 940, 38212, 38949);
                final double[] lB = CallChecker.varInit(CMAESOptimizer.this.getLowerBound(), "lB", 941, 38418, 38473);
                final double[] uB = CallChecker.varInit(CMAESOptimizer.this.getUpperBound(), "uB", 942, 38487, 38542);
                final double[] repaired = CallChecker.varInit(new double[CallChecker.isCalled(x, double[].class, 944, 38594, 38594).length], "repaired", 944, 38557, 38603);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 945, 38637, 38637).length); i++) {
                    if (CallChecker.beforeDeref(x, double[].class, 946, 38674, 38674)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 946, 38681, 38682)) {
                            if ((CallChecker.isCalled(x, double[].class, 946, 38674, 38674)[i]) < (CallChecker.isCalled(lB, double[].class, 946, 38681, 38682)[i])) {
                                if (CallChecker.beforeDeref(repaired, double[].class, 947, 38710, 38717)) {
                                    if (CallChecker.beforeDeref(lB, double[].class, 947, 38724, 38725)) {
                                        CallChecker.isCalled(repaired, double[].class, 947, 38710, 38717)[i] = CallChecker.isCalled(lB, double[].class, 947, 38724, 38725)[i];
                                        CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 947, 38710, 38717)[i], "CallChecker.isCalled(repaired, double[].class, 947, 38710, 38717)[i]", 947, 38710, 38729);
                                    }
                                }
                            }else
                                if (CallChecker.beforeDeref(x, double[].class, 948, 38758, 38758)) {
                                    if (CallChecker.beforeDeref(uB, double[].class, 948, 38765, 38766)) {
                                        if ((CallChecker.isCalled(x, double[].class, 948, 38758, 38758)[i]) > (CallChecker.isCalled(uB, double[].class, 948, 38765, 38766)[i])) {
                                            if (CallChecker.beforeDeref(repaired, double[].class, 949, 38794, 38801)) {
                                                if (CallChecker.beforeDeref(uB, double[].class, 949, 38808, 38809)) {
                                                    CallChecker.isCalled(repaired, double[].class, 949, 38794, 38801)[i] = CallChecker.isCalled(uB, double[].class, 949, 38808, 38809)[i];
                                                    CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 949, 38794, 38801)[i], "CallChecker.isCalled(repaired, double[].class, 949, 38794, 38801)[i]", 949, 38794, 38813);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(repaired, double[].class, 951, 38860, 38867)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 951, 38874, 38874)) {
                                                    CallChecker.isCalled(repaired, double[].class, 951, 38860, 38867)[i] = CallChecker.isCalled(x, double[].class, 951, 38874, 38874)[i];
                                                    CallChecker.varAssign(CallChecker.isCalled(repaired, double[].class, 951, 38860, 38867)[i], "CallChecker.isCalled(repaired, double[].class, 951, 38860, 38867)[i]", 951, 38860, 38878);
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
                _bcornu_methode_context2860.methodEnd();
            }
        }

        private double penalty(final double[] x, final double[] repaired) {
            MethodContext _bcornu_methode_context2861 = new MethodContext(double.class, 962, 38960, 39497);
            try {
                CallChecker.varInit(this, "this", 962, 38960, 39497);
                CallChecker.varInit(repaired, "repaired", 962, 38960, 39497);
                CallChecker.varInit(x, "x", 962, 38960, 39497);
                CallChecker.varInit(this.isRepairMode, "isRepairMode", 962, 38960, 39497);
                CallChecker.varInit(this.valueRange, "valueRange", 962, 38960, 39497);
                double penalty = CallChecker.varInit(((double) (0)), "penalty", 963, 39248, 39266);
                for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 964, 39300, 39300).length); i++) {
                    double diff = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(x, double[].class, 965, 39356, 39356)) {
                        if (CallChecker.beforeDeref(repaired, double[].class, 965, 39363, 39370)) {
                            diff = Math.abs(((CallChecker.isCalled(x, double[].class, 965, 39356, 39356)[i]) - (CallChecker.isCalled(repaired, double[].class, 965, 39363, 39370)[i])));
                            CallChecker.varAssign(diff, "diff", 965, 39356, 39356);
                        }
                    }
                    penalty += diff * (valueRange);
                    CallChecker.varAssign(penalty, "penalty", 966, 39393, 39421);
                }
                if (isMinimize) {
                    return penalty;
                }else {
                    return -penalty;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2861.methodEnd();
            }
        }
    }

    private int lambda;

    private final boolean isActiveCMA;

    private final int checkFeasableCount;

    private double[] inputSigma;

    private int dimension;

    private int diagonalOnly;

    private boolean isMinimize = true;

    private final boolean generateStatistics;

    private final int maxIterations;

    private final double stopFitness;

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

    private final RandomGenerator random;

    private final List<Double> statisticsSigmaHistory = new ArrayList<Double>();

    private final List<RealMatrix> statisticsMeanHistory = new ArrayList<RealMatrix>();

    private final List<Double> statisticsFitnessHistory = new ArrayList<Double>();

    private final List<RealMatrix> statisticsDHistory = new ArrayList<RealMatrix>();

    public CMAESOptimizer(int maxIterations, double stopFitness, boolean isActiveCMA, int diagonalOnly, int checkFeasableCount, RandomGenerator random, boolean generateStatistics, ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context653 = new ConstructorContext(CMAESOptimizer.class, 223, 9101, 10521);
        try {
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 232, 10221, 10255);
            this.stopFitness = stopFitness;
            CallChecker.varAssign(this.stopFitness, "this.stopFitness", 233, 10265, 10295);
            this.isActiveCMA = isActiveCMA;
            CallChecker.varAssign(this.isActiveCMA, "this.isActiveCMA", 234, 10305, 10335);
            this.diagonalOnly = diagonalOnly;
            CallChecker.varAssign(this.diagonalOnly, "this.diagonalOnly", 235, 10345, 10377);
            this.checkFeasableCount = checkFeasableCount;
            CallChecker.varAssign(this.checkFeasableCount, "this.checkFeasableCount", 236, 10387, 10431);
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 237, 10441, 10461);
            this.generateStatistics = generateStatistics;
            CallChecker.varAssign(this.generateStatistics, "this.generateStatistics", 238, 10471, 10515);
        } finally {
            _bcornu_methode_context653.methodEnd();
        }
    }

    public List<Double> getStatisticsSigmaHistory() {
        MethodContext _bcornu_methode_context2862 = new MethodContext(List.class, 244, 10528, 10677);
        try {
            CallChecker.varInit(this, "this", 244, 10528, 10677);
            CallChecker.varInit(this.iterations, "iterations", 244, 10528, 10677);
            CallChecker.varInit(this.evaluations, "evaluations", 244, 10528, 10677);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 244, 10528, 10677);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 244, 10528, 10677);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 244, 10528, 10677);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 244, 10528, 10677);
            CallChecker.varInit(this.random, "random", 244, 10528, 10677);
            CallChecker.varInit(this.historySize, "historySize", 244, 10528, 10677);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 244, 10528, 10677);
            CallChecker.varInit(this.iterations, "iterations", 244, 10528, 10677);
            CallChecker.varInit(this.diagC, "diagC", 244, 10528, 10677);
            CallChecker.varInit(this.C, "C", 244, 10528, 10677);
            CallChecker.varInit(this.diagD, "diagD", 244, 10528, 10677);
            CallChecker.varInit(this.BD, "BD", 244, 10528, 10677);
            CallChecker.varInit(this.D, "D", 244, 10528, 10677);
            CallChecker.varInit(this.B, "B", 244, 10528, 10677);
            CallChecker.varInit(this.normps, "normps", 244, 10528, 10677);
            CallChecker.varInit(this.ps, "ps", 244, 10528, 10677);
            CallChecker.varInit(this.pc, "pc", 244, 10528, 10677);
            CallChecker.varInit(this.xmean, "xmean", 244, 10528, 10677);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 244, 10528, 10677);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 244, 10528, 10677);
            CallChecker.varInit(this.chiN, "chiN", 244, 10528, 10677);
            CallChecker.varInit(this.ccovmu, "ccovmu", 244, 10528, 10677);
            CallChecker.varInit(this.ccov1, "ccov1", 244, 10528, 10677);
            CallChecker.varInit(this.damps, "damps", 244, 10528, 10677);
            CallChecker.varInit(this.cs, "cs", 244, 10528, 10677);
            CallChecker.varInit(this.cc, "cc", 244, 10528, 10677);
            CallChecker.varInit(this.sigma, "sigma", 244, 10528, 10677);
            CallChecker.varInit(this.mueff, "mueff", 244, 10528, 10677);
            CallChecker.varInit(this.weights, "weights", 244, 10528, 10677);
            CallChecker.varInit(this.logMu2, "logMu2", 244, 10528, 10677);
            CallChecker.varInit(this.mu, "mu", 244, 10528, 10677);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 244, 10528, 10677);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 244, 10528, 10677);
            CallChecker.varInit(this.stopTolX, "stopTolX", 244, 10528, 10677);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 244, 10528, 10677);
            CallChecker.varInit(this.stopFitness, "stopFitness", 244, 10528, 10677);
            CallChecker.varInit(this.maxIterations, "maxIterations", 244, 10528, 10677);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 244, 10528, 10677);
            CallChecker.varInit(this.isMinimize, "isMinimize", 244, 10528, 10677);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 244, 10528, 10677);
            CallChecker.varInit(this.dimension, "dimension", 244, 10528, 10677);
            CallChecker.varInit(this.inputSigma, "inputSigma", 244, 10528, 10677);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 244, 10528, 10677);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 244, 10528, 10677);
            CallChecker.varInit(this.lambda, "lambda", 244, 10528, 10677);
            return statisticsSigmaHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2862.methodEnd();
        }
    }

    public List<RealMatrix> getStatisticsMeanHistory() {
        MethodContext _bcornu_methode_context2863 = new MethodContext(List.class, 251, 10684, 10834);
        try {
            CallChecker.varInit(this, "this", 251, 10684, 10834);
            CallChecker.varInit(this.iterations, "iterations", 251, 10684, 10834);
            CallChecker.varInit(this.evaluations, "evaluations", 251, 10684, 10834);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 251, 10684, 10834);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 251, 10684, 10834);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 251, 10684, 10834);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 251, 10684, 10834);
            CallChecker.varInit(this.random, "random", 251, 10684, 10834);
            CallChecker.varInit(this.historySize, "historySize", 251, 10684, 10834);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 251, 10684, 10834);
            CallChecker.varInit(this.iterations, "iterations", 251, 10684, 10834);
            CallChecker.varInit(this.diagC, "diagC", 251, 10684, 10834);
            CallChecker.varInit(this.C, "C", 251, 10684, 10834);
            CallChecker.varInit(this.diagD, "diagD", 251, 10684, 10834);
            CallChecker.varInit(this.BD, "BD", 251, 10684, 10834);
            CallChecker.varInit(this.D, "D", 251, 10684, 10834);
            CallChecker.varInit(this.B, "B", 251, 10684, 10834);
            CallChecker.varInit(this.normps, "normps", 251, 10684, 10834);
            CallChecker.varInit(this.ps, "ps", 251, 10684, 10834);
            CallChecker.varInit(this.pc, "pc", 251, 10684, 10834);
            CallChecker.varInit(this.xmean, "xmean", 251, 10684, 10834);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 251, 10684, 10834);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 251, 10684, 10834);
            CallChecker.varInit(this.chiN, "chiN", 251, 10684, 10834);
            CallChecker.varInit(this.ccovmu, "ccovmu", 251, 10684, 10834);
            CallChecker.varInit(this.ccov1, "ccov1", 251, 10684, 10834);
            CallChecker.varInit(this.damps, "damps", 251, 10684, 10834);
            CallChecker.varInit(this.cs, "cs", 251, 10684, 10834);
            CallChecker.varInit(this.cc, "cc", 251, 10684, 10834);
            CallChecker.varInit(this.sigma, "sigma", 251, 10684, 10834);
            CallChecker.varInit(this.mueff, "mueff", 251, 10684, 10834);
            CallChecker.varInit(this.weights, "weights", 251, 10684, 10834);
            CallChecker.varInit(this.logMu2, "logMu2", 251, 10684, 10834);
            CallChecker.varInit(this.mu, "mu", 251, 10684, 10834);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 251, 10684, 10834);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 251, 10684, 10834);
            CallChecker.varInit(this.stopTolX, "stopTolX", 251, 10684, 10834);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 251, 10684, 10834);
            CallChecker.varInit(this.stopFitness, "stopFitness", 251, 10684, 10834);
            CallChecker.varInit(this.maxIterations, "maxIterations", 251, 10684, 10834);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 251, 10684, 10834);
            CallChecker.varInit(this.isMinimize, "isMinimize", 251, 10684, 10834);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 251, 10684, 10834);
            CallChecker.varInit(this.dimension, "dimension", 251, 10684, 10834);
            CallChecker.varInit(this.inputSigma, "inputSigma", 251, 10684, 10834);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 251, 10684, 10834);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 251, 10684, 10834);
            CallChecker.varInit(this.lambda, "lambda", 251, 10684, 10834);
            return statisticsMeanHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<RealMatrix>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2863.methodEnd();
        }
    }

    public List<Double> getStatisticsFitnessHistory() {
        MethodContext _bcornu_methode_context2864 = new MethodContext(List.class, 258, 10841, 10996);
        try {
            CallChecker.varInit(this, "this", 258, 10841, 10996);
            CallChecker.varInit(this.iterations, "iterations", 258, 10841, 10996);
            CallChecker.varInit(this.evaluations, "evaluations", 258, 10841, 10996);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 258, 10841, 10996);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 258, 10841, 10996);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 258, 10841, 10996);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 258, 10841, 10996);
            CallChecker.varInit(this.random, "random", 258, 10841, 10996);
            CallChecker.varInit(this.historySize, "historySize", 258, 10841, 10996);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 258, 10841, 10996);
            CallChecker.varInit(this.iterations, "iterations", 258, 10841, 10996);
            CallChecker.varInit(this.diagC, "diagC", 258, 10841, 10996);
            CallChecker.varInit(this.C, "C", 258, 10841, 10996);
            CallChecker.varInit(this.diagD, "diagD", 258, 10841, 10996);
            CallChecker.varInit(this.BD, "BD", 258, 10841, 10996);
            CallChecker.varInit(this.D, "D", 258, 10841, 10996);
            CallChecker.varInit(this.B, "B", 258, 10841, 10996);
            CallChecker.varInit(this.normps, "normps", 258, 10841, 10996);
            CallChecker.varInit(this.ps, "ps", 258, 10841, 10996);
            CallChecker.varInit(this.pc, "pc", 258, 10841, 10996);
            CallChecker.varInit(this.xmean, "xmean", 258, 10841, 10996);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 258, 10841, 10996);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 258, 10841, 10996);
            CallChecker.varInit(this.chiN, "chiN", 258, 10841, 10996);
            CallChecker.varInit(this.ccovmu, "ccovmu", 258, 10841, 10996);
            CallChecker.varInit(this.ccov1, "ccov1", 258, 10841, 10996);
            CallChecker.varInit(this.damps, "damps", 258, 10841, 10996);
            CallChecker.varInit(this.cs, "cs", 258, 10841, 10996);
            CallChecker.varInit(this.cc, "cc", 258, 10841, 10996);
            CallChecker.varInit(this.sigma, "sigma", 258, 10841, 10996);
            CallChecker.varInit(this.mueff, "mueff", 258, 10841, 10996);
            CallChecker.varInit(this.weights, "weights", 258, 10841, 10996);
            CallChecker.varInit(this.logMu2, "logMu2", 258, 10841, 10996);
            CallChecker.varInit(this.mu, "mu", 258, 10841, 10996);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 258, 10841, 10996);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 258, 10841, 10996);
            CallChecker.varInit(this.stopTolX, "stopTolX", 258, 10841, 10996);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 258, 10841, 10996);
            CallChecker.varInit(this.stopFitness, "stopFitness", 258, 10841, 10996);
            CallChecker.varInit(this.maxIterations, "maxIterations", 258, 10841, 10996);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 258, 10841, 10996);
            CallChecker.varInit(this.isMinimize, "isMinimize", 258, 10841, 10996);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 258, 10841, 10996);
            CallChecker.varInit(this.dimension, "dimension", 258, 10841, 10996);
            CallChecker.varInit(this.inputSigma, "inputSigma", 258, 10841, 10996);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 258, 10841, 10996);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 258, 10841, 10996);
            CallChecker.varInit(this.lambda, "lambda", 258, 10841, 10996);
            return statisticsFitnessHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Double>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2864.methodEnd();
        }
    }

    public List<RealMatrix> getStatisticsDHistory() {
        MethodContext _bcornu_methode_context2865 = new MethodContext(List.class, 265, 11003, 11144);
        try {
            CallChecker.varInit(this, "this", 265, 11003, 11144);
            CallChecker.varInit(this.iterations, "iterations", 265, 11003, 11144);
            CallChecker.varInit(this.evaluations, "evaluations", 265, 11003, 11144);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 265, 11003, 11144);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 265, 11003, 11144);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 265, 11003, 11144);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 265, 11003, 11144);
            CallChecker.varInit(this.random, "random", 265, 11003, 11144);
            CallChecker.varInit(this.historySize, "historySize", 265, 11003, 11144);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 265, 11003, 11144);
            CallChecker.varInit(this.iterations, "iterations", 265, 11003, 11144);
            CallChecker.varInit(this.diagC, "diagC", 265, 11003, 11144);
            CallChecker.varInit(this.C, "C", 265, 11003, 11144);
            CallChecker.varInit(this.diagD, "diagD", 265, 11003, 11144);
            CallChecker.varInit(this.BD, "BD", 265, 11003, 11144);
            CallChecker.varInit(this.D, "D", 265, 11003, 11144);
            CallChecker.varInit(this.B, "B", 265, 11003, 11144);
            CallChecker.varInit(this.normps, "normps", 265, 11003, 11144);
            CallChecker.varInit(this.ps, "ps", 265, 11003, 11144);
            CallChecker.varInit(this.pc, "pc", 265, 11003, 11144);
            CallChecker.varInit(this.xmean, "xmean", 265, 11003, 11144);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 265, 11003, 11144);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 265, 11003, 11144);
            CallChecker.varInit(this.chiN, "chiN", 265, 11003, 11144);
            CallChecker.varInit(this.ccovmu, "ccovmu", 265, 11003, 11144);
            CallChecker.varInit(this.ccov1, "ccov1", 265, 11003, 11144);
            CallChecker.varInit(this.damps, "damps", 265, 11003, 11144);
            CallChecker.varInit(this.cs, "cs", 265, 11003, 11144);
            CallChecker.varInit(this.cc, "cc", 265, 11003, 11144);
            CallChecker.varInit(this.sigma, "sigma", 265, 11003, 11144);
            CallChecker.varInit(this.mueff, "mueff", 265, 11003, 11144);
            CallChecker.varInit(this.weights, "weights", 265, 11003, 11144);
            CallChecker.varInit(this.logMu2, "logMu2", 265, 11003, 11144);
            CallChecker.varInit(this.mu, "mu", 265, 11003, 11144);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 265, 11003, 11144);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 265, 11003, 11144);
            CallChecker.varInit(this.stopTolX, "stopTolX", 265, 11003, 11144);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 265, 11003, 11144);
            CallChecker.varInit(this.stopFitness, "stopFitness", 265, 11003, 11144);
            CallChecker.varInit(this.maxIterations, "maxIterations", 265, 11003, 11144);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 265, 11003, 11144);
            CallChecker.varInit(this.isMinimize, "isMinimize", 265, 11003, 11144);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 265, 11003, 11144);
            CallChecker.varInit(this.dimension, "dimension", 265, 11003, 11144);
            CallChecker.varInit(this.inputSigma, "inputSigma", 265, 11003, 11144);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 265, 11003, 11144);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 265, 11003, 11144);
            CallChecker.varInit(this.lambda, "lambda", 265, 11003, 11144);
            return statisticsDHistory;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<RealMatrix>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2865.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) throws DimensionMismatchException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2866 = new MethodContext(PointValuePair.class, 359, 13505, 14395);
        try {
            CallChecker.varInit(this, "this", 359, 13505, 14395);
            CallChecker.varInit(optData, "optData", 359, 13505, 14395);
            CallChecker.varInit(this.iterations, "iterations", 359, 13505, 14395);
            CallChecker.varInit(this.evaluations, "evaluations", 359, 13505, 14395);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 359, 13505, 14395);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 359, 13505, 14395);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 359, 13505, 14395);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 359, 13505, 14395);
            CallChecker.varInit(this.random, "random", 359, 13505, 14395);
            CallChecker.varInit(this.historySize, "historySize", 359, 13505, 14395);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 359, 13505, 14395);
            CallChecker.varInit(this.iterations, "iterations", 359, 13505, 14395);
            CallChecker.varInit(this.diagC, "diagC", 359, 13505, 14395);
            CallChecker.varInit(this.C, "C", 359, 13505, 14395);
            CallChecker.varInit(this.diagD, "diagD", 359, 13505, 14395);
            CallChecker.varInit(this.BD, "BD", 359, 13505, 14395);
            CallChecker.varInit(this.D, "D", 359, 13505, 14395);
            CallChecker.varInit(this.B, "B", 359, 13505, 14395);
            CallChecker.varInit(this.normps, "normps", 359, 13505, 14395);
            CallChecker.varInit(this.ps, "ps", 359, 13505, 14395);
            CallChecker.varInit(this.pc, "pc", 359, 13505, 14395);
            CallChecker.varInit(this.xmean, "xmean", 359, 13505, 14395);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 359, 13505, 14395);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 359, 13505, 14395);
            CallChecker.varInit(this.chiN, "chiN", 359, 13505, 14395);
            CallChecker.varInit(this.ccovmu, "ccovmu", 359, 13505, 14395);
            CallChecker.varInit(this.ccov1, "ccov1", 359, 13505, 14395);
            CallChecker.varInit(this.damps, "damps", 359, 13505, 14395);
            CallChecker.varInit(this.cs, "cs", 359, 13505, 14395);
            CallChecker.varInit(this.cc, "cc", 359, 13505, 14395);
            CallChecker.varInit(this.sigma, "sigma", 359, 13505, 14395);
            CallChecker.varInit(this.mueff, "mueff", 359, 13505, 14395);
            CallChecker.varInit(this.weights, "weights", 359, 13505, 14395);
            CallChecker.varInit(this.logMu2, "logMu2", 359, 13505, 14395);
            CallChecker.varInit(this.mu, "mu", 359, 13505, 14395);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 359, 13505, 14395);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 359, 13505, 14395);
            CallChecker.varInit(this.stopTolX, "stopTolX", 359, 13505, 14395);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 359, 13505, 14395);
            CallChecker.varInit(this.stopFitness, "stopFitness", 359, 13505, 14395);
            CallChecker.varInit(this.maxIterations, "maxIterations", 359, 13505, 14395);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 359, 13505, 14395);
            CallChecker.varInit(this.isMinimize, "isMinimize", 359, 13505, 14395);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 359, 13505, 14395);
            CallChecker.varInit(this.dimension, "dimension", 359, 13505, 14395);
            CallChecker.varInit(this.inputSigma, "inputSigma", 359, 13505, 14395);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 359, 13505, 14395);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 359, 13505, 14395);
            CallChecker.varInit(this.lambda, "lambda", 359, 13505, 14395);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2866.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context2867 = new MethodContext(PointValuePair.class, 368, 14402, 21382);
        try {
            CallChecker.varInit(this, "this", 368, 14402, 21382);
            CallChecker.varInit(this.iterations, "iterations", 368, 14402, 21382);
            CallChecker.varInit(this.evaluations, "evaluations", 368, 14402, 21382);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 368, 14402, 21382);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 368, 14402, 21382);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 368, 14402, 21382);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 368, 14402, 21382);
            CallChecker.varInit(this.random, "random", 368, 14402, 21382);
            CallChecker.varInit(this.historySize, "historySize", 368, 14402, 21382);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 368, 14402, 21382);
            CallChecker.varInit(this.iterations, "iterations", 368, 14402, 21382);
            CallChecker.varInit(this.diagC, "diagC", 368, 14402, 21382);
            CallChecker.varInit(this.C, "C", 368, 14402, 21382);
            CallChecker.varInit(this.diagD, "diagD", 368, 14402, 21382);
            CallChecker.varInit(this.BD, "BD", 368, 14402, 21382);
            CallChecker.varInit(this.D, "D", 368, 14402, 21382);
            CallChecker.varInit(this.B, "B", 368, 14402, 21382);
            CallChecker.varInit(this.normps, "normps", 368, 14402, 21382);
            CallChecker.varInit(this.ps, "ps", 368, 14402, 21382);
            CallChecker.varInit(this.pc, "pc", 368, 14402, 21382);
            CallChecker.varInit(this.xmean, "xmean", 368, 14402, 21382);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 368, 14402, 21382);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 368, 14402, 21382);
            CallChecker.varInit(this.chiN, "chiN", 368, 14402, 21382);
            CallChecker.varInit(this.ccovmu, "ccovmu", 368, 14402, 21382);
            CallChecker.varInit(this.ccov1, "ccov1", 368, 14402, 21382);
            CallChecker.varInit(this.damps, "damps", 368, 14402, 21382);
            CallChecker.varInit(this.cs, "cs", 368, 14402, 21382);
            CallChecker.varInit(this.cc, "cc", 368, 14402, 21382);
            CallChecker.varInit(this.sigma, "sigma", 368, 14402, 21382);
            CallChecker.varInit(this.mueff, "mueff", 368, 14402, 21382);
            CallChecker.varInit(this.weights, "weights", 368, 14402, 21382);
            CallChecker.varInit(this.logMu2, "logMu2", 368, 14402, 21382);
            CallChecker.varInit(this.mu, "mu", 368, 14402, 21382);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 368, 14402, 21382);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 368, 14402, 21382);
            CallChecker.varInit(this.stopTolX, "stopTolX", 368, 14402, 21382);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 368, 14402, 21382);
            CallChecker.varInit(this.stopFitness, "stopFitness", 368, 14402, 21382);
            CallChecker.varInit(this.maxIterations, "maxIterations", 368, 14402, 21382);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 368, 14402, 21382);
            CallChecker.varInit(this.isMinimize, "isMinimize", 368, 14402, 21382);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 368, 14402, 21382);
            CallChecker.varInit(this.dimension, "dimension", 368, 14402, 21382);
            CallChecker.varInit(this.inputSigma, "inputSigma", 368, 14402, 21382);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 368, 14402, 21382);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 368, 14402, 21382);
            CallChecker.varInit(this.lambda, "lambda", 368, 14402, 21382);
            final GoalType npe_invocation_var736 = getGoalType();
            if (CallChecker.beforeDeref(npe_invocation_var736, GoalType.class, 370, 14583, 14595)) {
                isMinimize = CallChecker.isCalled(npe_invocation_var736, GoalType.class, 370, 14583, 14595).equals(GoalType.MINIMIZE);
                CallChecker.varAssign(this.isMinimize, "this.isMinimize", 370, 14570, 14622);
            }
            final CMAESOptimizer.FitnessFunction fitfun = CallChecker.varInit(new CMAESOptimizer.FitnessFunction(), "fitfun", 371, 14632, 14684);
            final double[] guess = CallChecker.varInit(getStartPoint(), "guess", 372, 14694, 14732);
            if (CallChecker.beforeDeref(guess, double[].class, 374, 14813, 14817)) {
                dimension = CallChecker.isCalled(guess, double[].class, 374, 14813, 14817).length;
                CallChecker.varAssign(this.dimension, "this.dimension", 374, 14801, 14825);
            }
            initializeCMA(guess);
            iterations = 0;
            CallChecker.varAssign(this.iterations, "this.iterations", 376, 14865, 14879);
            double bestValue = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 377, 14908, 14913)) {
                bestValue = CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 377, 14908, 14913).value(guess);
                CallChecker.varAssign(bestValue, "bestValue", 377, 14908, 14913);
            }
            CMAESOptimizer.push(fitnessHistory, bestValue);
            PointValuePair optimum = CallChecker.varInit(new PointValuePair(getStartPoint(), (isMinimize ? bestValue : -bestValue)), "optimum", 379, 14978, 15120);
            PointValuePair lastResult = CallChecker.varInit(null, "lastResult", 382, 15130, 15162);
            generationLoop : for (iterations = 1; (iterations) <= (maxIterations); (iterations)++) {
                CallChecker.varAssign(this.iterations, "this.iterations", 387, 15284, 15297);
                incrementIterationCount();
                final RealMatrix arz = CallChecker.varInit(randn1(dimension, lambda), "arz", 391, 15397, 15499);
                final RealMatrix arx = CallChecker.varInit(CMAESOptimizer.zeros(dimension, lambda), "arx", 392, 15513, 15560);
                final double[] fitness = CallChecker.varInit(new double[lambda], "fitness", 393, 15574, 15617);
                for (int k = 0; k < (lambda); k++) {
                    RealMatrix arxk = CallChecker.varInit(null, "arxk", 396, 15723, 15745);
                    for (int i = 0; i < ((checkFeasableCount) + 1); i++) {
                        if ((diagonalOnly) <= 0) {
                            if (CallChecker.beforeDeref(arz, RealMatrix.class, 399, 15912, 15914)) {
                                if (CallChecker.beforeDeref(BD, RealMatrix.class, 399, 15900, 15901)) {
                                    BD = CallChecker.beforeCalled(BD, RealMatrix.class, 399, 15900, 15901);
                                    final RealMatrix npe_invocation_var737 = CallChecker.isCalled(BD, RealMatrix.class, 399, 15900, 15901).multiply(CallChecker.isCalled(arz, RealMatrix.class, 399, 15912, 15914).getColumnMatrix(k));
                                    if (CallChecker.beforeDeref(npe_invocation_var737, RealMatrix.class, 399, 15900, 15934)) {
                                        if (CallChecker.beforeDeref(xmean, RealMatrix.class, 399, 15890, 15894)) {
                                            xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 399, 15890, 15894);
                                            arxk = CallChecker.isCalled(xmean, RealMatrix.class, 399, 15890, 15894).add(CallChecker.isCalled(npe_invocation_var737, RealMatrix.class, 399, 15900, 15934).scalarMultiply(sigma));
                                            CallChecker.varAssign(arxk, "arxk", 399, 15883, 16000);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(arz, RealMatrix.class, 402, 16109, 16111)) {
                                final RealMatrix npe_invocation_var738 = CMAESOptimizer.times(diagD, CallChecker.isCalled(arz, RealMatrix.class, 402, 16109, 16111).getColumnMatrix(k));
                                if (CallChecker.beforeDeref(npe_invocation_var738, RealMatrix.class, 402, 16097, 16131)) {
                                    if (CallChecker.beforeDeref(xmean, RealMatrix.class, 402, 16087, 16091)) {
                                        xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 402, 16087, 16091);
                                        arxk = CallChecker.isCalled(xmean, RealMatrix.class, 402, 16087, 16091).add(CallChecker.isCalled(npe_invocation_var738, RealMatrix.class, 402, 16097, 16131).scalarMultiply(sigma));
                                        CallChecker.varAssign(arxk, "arxk", 402, 16080, 16197);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(arxk, RealMatrix.class, 406, 16314, 16317)) {
                            if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 406, 16296, 16301)) {
                                arxk = CallChecker.beforeCalled(arxk, RealMatrix.class, 406, 16314, 16317);
                                if ((i >= (checkFeasableCount)) || (CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 406, 16296, 16301).isFeasible(CallChecker.isCalled(arxk, RealMatrix.class, 406, 16314, 16317).getColumn(0)))) {
                                    break;
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(arz, RealMatrix.class, 410, 16468, 16470)) {
                            CallChecker.isCalled(arz, RealMatrix.class, 410, 16468, 16470).setColumn(k, randn(dimension));
                        }
                    }
                    CMAESOptimizer.copyColumn(arxk, 0, arx, k);
                    TryContext _bcornu_try_context_63 = new TryContext(63, CMAESOptimizer.class, "org.apache.commons.math3.exception.TooManyEvaluationsException");
                    try {
                        if (CallChecker.beforeDeref(fitness, double[].class, 414, 16609, 16615)) {
                            if (CallChecker.beforeDeref(arx, RealMatrix.class, 414, 16635, 16637)) {
                                if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 414, 16622, 16627)) {
                                    CallChecker.isCalled(fitness, double[].class, 414, 16609, 16615)[k] = CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 414, 16622, 16627).value(CallChecker.isCalled(arx, RealMatrix.class, 414, 16635, 16637).getColumn(k));
                                    CallChecker.varAssign(CallChecker.isCalled(fitness, double[].class, 414, 16609, 16615)[k], "CallChecker.isCalled(fitness, double[].class, 414, 16609, 16615)[k]", 414, 16609, 16652);
                                }
                            }
                        }
                    } catch (TooManyEvaluationsException e) {
                        _bcornu_try_context_63.catchStart(63);
                        break generationLoop;
                    } finally {
                        _bcornu_try_context_63.finallyStart(63);
                    }
                }
                final int[] arindex = CallChecker.varInit(sortedIndices(fitness), "arindex", 420, 16885, 16929);
                final RealMatrix xold = CallChecker.varInit(xmean, "xold", 422, 16943, 17044);
                final RealMatrix bestArx = CallChecker.varInit(CMAESOptimizer.selectColumns(arx, MathArrays.copyOf(arindex, mu)), "bestArx", 423, 17093, 17170);
                if (CallChecker.beforeDeref(bestArx, RealMatrix.class, 424, 17192, 17198)) {
                    xmean = CallChecker.isCalled(bestArx, RealMatrix.class, 424, 17192, 17198).multiply(weights);
                    CallChecker.varAssign(this.xmean, "this.xmean", 424, 17184, 17217);
                }
                final RealMatrix bestArz = CallChecker.varInit(CMAESOptimizer.selectColumns(arz, MathArrays.copyOf(arindex, mu)), "bestArz", 425, 17231, 17308);
                final RealMatrix zmean = CallChecker.varInit(CallChecker.isCalled(bestArz, RealMatrix.class, 426, 17347, 17353).multiply(weights), "zmean", 426, 17322, 17372);
                final boolean hsig = CallChecker.varInit(((boolean) (updateEvolutionPaths(zmean, xold))), "hsig", 427, 17386, 17440);
                if ((diagonalOnly) <= 0) {
                    updateCovariance(hsig, bestArx, arz, arindex, xold);
                }else {
                    updateCovarianceDiagonalOnly(hsig, bestArz);
                }
                sigma *= Math.exp(Math.min(1, (((((normps) / (chiN)) - 1) * (cs)) / (damps))));
                CallChecker.varAssign(this.sigma, "this.sigma", 434, 17703, 17765);
                final double bestFitness = CallChecker.varInit(((double) (CallChecker.isCalled(fitness, double[].class, 435, 17806, 17812)[CallChecker.isCalled(arindex, int[].class, 435, 17814, 17820)[0]])), "bestFitness", 435, 17779, 17825);
                final double worstFitness = CallChecker.varInit(((double) (CallChecker.isCalled(fitness, double[].class, 436, 17867, 17873)[CallChecker.isCalled(arindex, int[].class, 436, 17875, 17881)[((CallChecker.isCalled(arindex, int[].class, 436, 17883, 17889).length) - 1)]])), "worstFitness", 436, 17839, 17903);
                if (bestValue > bestFitness) {
                    bestValue = bestFitness;
                    CallChecker.varAssign(bestValue, "bestValue", 438, 17964, 17987);
                    lastResult = optimum;
                    CallChecker.varAssign(lastResult, "lastResult", 439, 18005, 18025);
                    if (CallChecker.beforeDeref(bestArx, RealMatrix.class, 440, 18086, 18092)) {
                        if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 440, 18072, 18077)) {
                            optimum = new PointValuePair(CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 440, 18072, 18077).repair(CallChecker.isCalled(bestArx, RealMatrix.class, 440, 18086, 18092).getColumn(0)), (isMinimize ? bestFitness : -bestFitness));
                            CallChecker.varAssign(optimum, "optimum", 440, 18043, 18194);
                        }
                    }
                    if ((((getConvergenceChecker()) != null) && (lastResult != null)) && (getConvergenceChecker().converged(iterations, optimum, lastResult))) {
                        break generationLoop;
                    }
                }
                if (((stopFitness) != 0) && (bestFitness < (isMinimize ? stopFitness : -(stopFitness)))) {
                    break generationLoop;
                }
                final double[] sqrtDiagC = CallChecker.varInit(CallChecker.isCalled(CMAESOptimizer.sqrt(diagC), RealMatrix.class, 452, 18714, 18724).getColumn(0), "sqrtDiagC", 452, 18687, 18738);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 453, 18775, 18776);
                final double[] pcCol = CallChecker.varInit(CallChecker.isCalled(pc, RealMatrix.class, 453, 18775, 18776).getColumn(0), "pcCol", 453, 18752, 18790);
                for (int i = 0; i < (dimension); i++) {
                    if (CallChecker.beforeDeref(pcCol, double[].class, 455, 18888, 18892)) {
                        if (CallChecker.beforeDeref(sqrtDiagC, double[].class, 455, 18899, 18907)) {
                            if (((sigma) * (Math.max(Math.abs(CallChecker.isCalled(pcCol, double[].class, 455, 18888, 18892)[i]), CallChecker.isCalled(sqrtDiagC, double[].class, 455, 18899, 18907)[i]))) > (stopTolX)) {
                                break;
                            }
                        }
                    }
                    if (i >= ((dimension) - 1)) {
                        break generationLoop;
                    }
                }
                for (int i = 0; i < (dimension); i++) {
                    if (CallChecker.beforeDeref(sqrtDiagC, double[].class, 463, 19166, 19174)) {
                        if (((sigma) * (CallChecker.isCalled(sqrtDiagC, double[].class, 463, 19166, 19174)[i])) > (stopTolUpX)) {
                            break generationLoop;
                        }
                    }
                }
                final double historyBest = CallChecker.varInit(((double) (CMAESOptimizer.min(this.fitnessHistory))), "historyBest", 467, 19281, 19327);
                final double historyWorst = CallChecker.varInit(((double) (CMAESOptimizer.max(this.fitnessHistory))), "historyWorst", 468, 19341, 19388);
                if (((iterations) > 2) && (((Math.max(historyWorst, worstFitness)) - (Math.min(historyBest, bestFitness))) < (stopTolFun))) {
                    break generationLoop;
                }
                if (CallChecker.beforeDeref(fitnessHistory, double[].class, 474, 19627, 19640)) {
                    fitnessHistory = CallChecker.beforeCalled(fitnessHistory, double[].class, 474, 19627, 19640);
                    if (((iterations) > (CallChecker.isCalled(fitnessHistory, double[].class, 474, 19627, 19640).length)) && ((historyWorst - historyBest) < (stopTolHistFun))) {
                        break generationLoop;
                    }
                }
                if (((CMAESOptimizer.max(diagD)) / (CMAESOptimizer.min(diagD))) > 1.0E7) {
                    break generationLoop;
                }
                if ((getConvergenceChecker()) != null) {
                    final PointValuePair current = CallChecker.varInit(new PointValuePair(CallChecker.isCalled(bestArx, RealMatrix.class, 485, 20115, 20121).getColumn(0), (isMinimize ? bestFitness : -bestFitness)), "current", 484, 20045, 20218);
                    if ((lastResult != null) && (getConvergenceChecker().converged(iterations, current, lastResult))) {
                        break generationLoop;
                    }
                    lastResult = current;
                    CallChecker.varAssign(lastResult, "lastResult", 491, 20432, 20452);
                }
                if (CallChecker.beforeDeref(arindex, int[].class, 494, 20585, 20591)) {
                    if (CallChecker.beforeDeref(fitness, double[].class, 494, 20577, 20583)) {
                        if (bestValue == (CallChecker.isCalled(fitness, double[].class, 494, 20577, 20583)[CallChecker.isCalled(arindex, int[].class, 494, 20585, 20591)[((int) (0.1 + ((lambda) / 4.0)))]])) {
                            sigma = (sigma) * (Math.exp((0.2 + ((cs) / (damps)))));
                            CallChecker.varAssign(this.sigma, "this.sigma", 495, 20635, 20677);
                        }
                    }
                }
                if (((iterations) > 2) && (((Math.max(historyWorst, bestFitness)) - (Math.min(historyBest, bestFitness))) == 0)) {
                    sigma = (sigma) * (Math.exp((0.2 + ((cs) / (damps)))));
                    CallChecker.varAssign(this.sigma, "this.sigma", 499, 20840, 20882);
                }
                CMAESOptimizer.push(fitnessHistory, bestFitness);
                if (CallChecker.beforeDeref(fitfun, CMAESOptimizer.FitnessFunction.class, 503, 20993, 20998)) {
                    CallChecker.isCalled(fitfun, CMAESOptimizer.FitnessFunction.class, 503, 20993, 20998).setValueRange((worstFitness - bestFitness));
                }
                if (generateStatistics) {
                    if (CallChecker.beforeDeref(statisticsSigmaHistory, List.class, 505, 21095, 21116)) {
                        CallChecker.isCalled(statisticsSigmaHistory, List.class, 505, 21095, 21116).add(sigma);
                    }
                    if (CallChecker.beforeDeref(statisticsFitnessHistory, List.class, 506, 21146, 21169)) {
                        CallChecker.isCalled(statisticsFitnessHistory, List.class, 506, 21146, 21169).add(bestFitness);
                    }
                    if (CallChecker.beforeDeref(xmean, RealMatrix.class, 507, 21231, 21235)) {
                        if (CallChecker.beforeDeref(statisticsMeanHistory, List.class, 507, 21205, 21225)) {
                            xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 507, 21231, 21235);
                            CallChecker.isCalled(statisticsMeanHistory, List.class, 507, 21205, 21225).add(CallChecker.isCalled(xmean, RealMatrix.class, 507, 21231, 21235).transpose());
                        }
                    }
                    if (CallChecker.beforeDeref(diagD, RealMatrix.class, 508, 21290, 21294)) {
                        diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 508, 21290, 21294);
                        final RealMatrix npe_invocation_var739 = CallChecker.isCalled(diagD, RealMatrix.class, 508, 21290, 21294).transpose();
                        if (CallChecker.beforeDeref(npe_invocation_var739, RealMatrix.class, 508, 21290, 21306)) {
                            if (CallChecker.beforeDeref(statisticsDHistory, List.class, 508, 21267, 21284)) {
                                CallChecker.isCalled(statisticsDHistory, List.class, 508, 21267, 21284).add(CallChecker.isCalled(npe_invocation_var739, RealMatrix.class, 508, 21290, 21306).scalarMultiply(100000.0));
                            }
                        }
                    }
                }
            }
            return optimum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2867.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context2868 = new MethodContext(void.class, 525, 21389, 22384);
        try {
            CallChecker.varInit(this, "this", 525, 21389, 22384);
            CallChecker.varInit(optData, "optData", 525, 21389, 22384);
            CallChecker.varInit(this.iterations, "iterations", 525, 21389, 22384);
            CallChecker.varInit(this.evaluations, "evaluations", 525, 21389, 22384);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 525, 21389, 22384);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 525, 21389, 22384);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 525, 21389, 22384);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 525, 21389, 22384);
            CallChecker.varInit(this.random, "random", 525, 21389, 22384);
            CallChecker.varInit(this.historySize, "historySize", 525, 21389, 22384);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 525, 21389, 22384);
            CallChecker.varInit(this.iterations, "iterations", 525, 21389, 22384);
            CallChecker.varInit(this.diagC, "diagC", 525, 21389, 22384);
            CallChecker.varInit(this.C, "C", 525, 21389, 22384);
            CallChecker.varInit(this.diagD, "diagD", 525, 21389, 22384);
            CallChecker.varInit(this.BD, "BD", 525, 21389, 22384);
            CallChecker.varInit(this.D, "D", 525, 21389, 22384);
            CallChecker.varInit(this.B, "B", 525, 21389, 22384);
            CallChecker.varInit(this.normps, "normps", 525, 21389, 22384);
            CallChecker.varInit(this.ps, "ps", 525, 21389, 22384);
            CallChecker.varInit(this.pc, "pc", 525, 21389, 22384);
            CallChecker.varInit(this.xmean, "xmean", 525, 21389, 22384);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 525, 21389, 22384);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 525, 21389, 22384);
            CallChecker.varInit(this.chiN, "chiN", 525, 21389, 22384);
            CallChecker.varInit(this.ccovmu, "ccovmu", 525, 21389, 22384);
            CallChecker.varInit(this.ccov1, "ccov1", 525, 21389, 22384);
            CallChecker.varInit(this.damps, "damps", 525, 21389, 22384);
            CallChecker.varInit(this.cs, "cs", 525, 21389, 22384);
            CallChecker.varInit(this.cc, "cc", 525, 21389, 22384);
            CallChecker.varInit(this.sigma, "sigma", 525, 21389, 22384);
            CallChecker.varInit(this.mueff, "mueff", 525, 21389, 22384);
            CallChecker.varInit(this.weights, "weights", 525, 21389, 22384);
            CallChecker.varInit(this.logMu2, "logMu2", 525, 21389, 22384);
            CallChecker.varInit(this.mu, "mu", 525, 21389, 22384);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 525, 21389, 22384);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 525, 21389, 22384);
            CallChecker.varInit(this.stopTolX, "stopTolX", 525, 21389, 22384);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 525, 21389, 22384);
            CallChecker.varInit(this.stopFitness, "stopFitness", 525, 21389, 22384);
            CallChecker.varInit(this.maxIterations, "maxIterations", 525, 21389, 22384);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 525, 21389, 22384);
            CallChecker.varInit(this.isMinimize, "isMinimize", 525, 21389, 22384);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 525, 21389, 22384);
            CallChecker.varInit(this.dimension, "dimension", 525, 21389, 22384);
            CallChecker.varInit(this.inputSigma, "inputSigma", 525, 21389, 22384);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 525, 21389, 22384);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 525, 21389, 22384);
            CallChecker.varInit(this.lambda, "lambda", 525, 21389, 22384);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 531, 22034, 22040)) {
                for (OptimizationData data : optData) {
                    if (data instanceof CMAESOptimizer.Sigma) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 533, 22124, 22127)) {
                            inputSigma = CallChecker.isCalled(((CMAESOptimizer.Sigma) (data)), CMAESOptimizer.Sigma.class, 533, 22124, 22127).getSigma();
                            CallChecker.varAssign(this.inputSigma, "this.inputSigma", 533, 22102, 22140);
                        }
                        continue;
                    }
                    if (data instanceof CMAESOptimizer.PopulationSize) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 537, 22275, 22278)) {
                            lambda = CallChecker.isCalled(((CMAESOptimizer.PopulationSize) (data)), CMAESOptimizer.PopulationSize.class, 537, 22275, 22278).getPopulationSize();
                            CallChecker.varAssign(this.lambda, "this.lambda", 537, 22248, 22300);
                        }
                        continue;
                    }
                }
            }
            checkParameters();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2868.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context2869 = new MethodContext(void.class, 548, 22391, 23076);
        try {
            CallChecker.varInit(this, "this", 548, 22391, 23076);
            CallChecker.varInit(this.iterations, "iterations", 548, 22391, 23076);
            CallChecker.varInit(this.evaluations, "evaluations", 548, 22391, 23076);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 548, 22391, 23076);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 548, 22391, 23076);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 548, 22391, 23076);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 548, 22391, 23076);
            CallChecker.varInit(this.random, "random", 548, 22391, 23076);
            CallChecker.varInit(this.historySize, "historySize", 548, 22391, 23076);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 548, 22391, 23076);
            CallChecker.varInit(this.iterations, "iterations", 548, 22391, 23076);
            CallChecker.varInit(this.diagC, "diagC", 548, 22391, 23076);
            CallChecker.varInit(this.C, "C", 548, 22391, 23076);
            CallChecker.varInit(this.diagD, "diagD", 548, 22391, 23076);
            CallChecker.varInit(this.BD, "BD", 548, 22391, 23076);
            CallChecker.varInit(this.D, "D", 548, 22391, 23076);
            CallChecker.varInit(this.B, "B", 548, 22391, 23076);
            CallChecker.varInit(this.normps, "normps", 548, 22391, 23076);
            CallChecker.varInit(this.ps, "ps", 548, 22391, 23076);
            CallChecker.varInit(this.pc, "pc", 548, 22391, 23076);
            CallChecker.varInit(this.xmean, "xmean", 548, 22391, 23076);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 548, 22391, 23076);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 548, 22391, 23076);
            CallChecker.varInit(this.chiN, "chiN", 548, 22391, 23076);
            CallChecker.varInit(this.ccovmu, "ccovmu", 548, 22391, 23076);
            CallChecker.varInit(this.ccov1, "ccov1", 548, 22391, 23076);
            CallChecker.varInit(this.damps, "damps", 548, 22391, 23076);
            CallChecker.varInit(this.cs, "cs", 548, 22391, 23076);
            CallChecker.varInit(this.cc, "cc", 548, 22391, 23076);
            CallChecker.varInit(this.sigma, "sigma", 548, 22391, 23076);
            CallChecker.varInit(this.mueff, "mueff", 548, 22391, 23076);
            CallChecker.varInit(this.weights, "weights", 548, 22391, 23076);
            CallChecker.varInit(this.logMu2, "logMu2", 548, 22391, 23076);
            CallChecker.varInit(this.mu, "mu", 548, 22391, 23076);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 548, 22391, 23076);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 548, 22391, 23076);
            CallChecker.varInit(this.stopTolX, "stopTolX", 548, 22391, 23076);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 548, 22391, 23076);
            CallChecker.varInit(this.stopFitness, "stopFitness", 548, 22391, 23076);
            CallChecker.varInit(this.maxIterations, "maxIterations", 548, 22391, 23076);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 548, 22391, 23076);
            CallChecker.varInit(this.isMinimize, "isMinimize", 548, 22391, 23076);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 548, 22391, 23076);
            CallChecker.varInit(this.dimension, "dimension", 548, 22391, 23076);
            CallChecker.varInit(this.inputSigma, "inputSigma", 548, 22391, 23076);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 548, 22391, 23076);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 548, 22391, 23076);
            CallChecker.varInit(this.lambda, "lambda", 548, 22391, 23076);
            final double[] init = CallChecker.varInit(getStartPoint(), "init", 549, 22525, 22562);
            final double[] lB = CallChecker.varInit(getLowerBound(), "lB", 550, 22572, 22607);
            final double[] uB = CallChecker.varInit(getUpperBound(), "uB", 551, 22617, 22652);
            if ((inputSigma) != null) {
                if (CallChecker.beforeDeref(init, double[].class, 554, 22726, 22729)) {
                    if ((inputSigma.length) != (CallChecker.isCalled(init, double[].class, 554, 22726, 22729).length)) {
                        if (CallChecker.beforeDeref(init, double[].class, 555, 22813, 22816)) {
                            throw new DimensionMismatchException(inputSigma.length, CallChecker.isCalled(init, double[].class, 555, 22813, 22816).length);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                for (int i = 0; i < (CallChecker.isCalled(init, double[].class, 557, 22873, 22876).length); i++) {
                    if (CallChecker.beforeDeref(uB, double[].class, 558, 22929, 22930)) {
                        if (CallChecker.beforeDeref(lB, double[].class, 558, 22937, 22938)) {
                            if ((inputSigma[i]) > ((CallChecker.isCalled(uB, double[].class, 558, 22929, 22930)[i]) - (CallChecker.isCalled(lB, double[].class, 558, 22937, 22938)[i]))) {
                                if (CallChecker.beforeDeref(uB, double[].class, 559, 23014, 23015)) {
                                    if (CallChecker.beforeDeref(lB, double[].class, 559, 23022, 23023)) {
                                        throw new OutOfRangeException(inputSigma[i], 0, ((CallChecker.isCalled(uB, double[].class, 559, 23014, 23015)[i]) - (CallChecker.isCalled(lB, double[].class, 559, 23022, 23023)[i])));
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
            _bcornu_methode_context2869.methodEnd();
        }
    }

    private void initializeCMA(double[] guess) {
        MethodContext _bcornu_methode_context2870 = new MethodContext(void.class, 570, 23083, 26330);
        try {
            CallChecker.varInit(this, "this", 570, 23083, 26330);
            CallChecker.varInit(guess, "guess", 570, 23083, 26330);
            CallChecker.varInit(this.iterations, "iterations", 570, 23083, 26330);
            CallChecker.varInit(this.evaluations, "evaluations", 570, 23083, 26330);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 570, 23083, 26330);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 570, 23083, 26330);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 570, 23083, 26330);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 570, 23083, 26330);
            CallChecker.varInit(this.random, "random", 570, 23083, 26330);
            CallChecker.varInit(this.historySize, "historySize", 570, 23083, 26330);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 570, 23083, 26330);
            CallChecker.varInit(this.iterations, "iterations", 570, 23083, 26330);
            CallChecker.varInit(this.diagC, "diagC", 570, 23083, 26330);
            CallChecker.varInit(this.C, "C", 570, 23083, 26330);
            CallChecker.varInit(this.diagD, "diagD", 570, 23083, 26330);
            CallChecker.varInit(this.BD, "BD", 570, 23083, 26330);
            CallChecker.varInit(this.D, "D", 570, 23083, 26330);
            CallChecker.varInit(this.B, "B", 570, 23083, 26330);
            CallChecker.varInit(this.normps, "normps", 570, 23083, 26330);
            CallChecker.varInit(this.ps, "ps", 570, 23083, 26330);
            CallChecker.varInit(this.pc, "pc", 570, 23083, 26330);
            CallChecker.varInit(this.xmean, "xmean", 570, 23083, 26330);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 570, 23083, 26330);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 570, 23083, 26330);
            CallChecker.varInit(this.chiN, "chiN", 570, 23083, 26330);
            CallChecker.varInit(this.ccovmu, "ccovmu", 570, 23083, 26330);
            CallChecker.varInit(this.ccov1, "ccov1", 570, 23083, 26330);
            CallChecker.varInit(this.damps, "damps", 570, 23083, 26330);
            CallChecker.varInit(this.cs, "cs", 570, 23083, 26330);
            CallChecker.varInit(this.cc, "cc", 570, 23083, 26330);
            CallChecker.varInit(this.sigma, "sigma", 570, 23083, 26330);
            CallChecker.varInit(this.mueff, "mueff", 570, 23083, 26330);
            CallChecker.varInit(this.weights, "weights", 570, 23083, 26330);
            CallChecker.varInit(this.logMu2, "logMu2", 570, 23083, 26330);
            CallChecker.varInit(this.mu, "mu", 570, 23083, 26330);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 570, 23083, 26330);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 570, 23083, 26330);
            CallChecker.varInit(this.stopTolX, "stopTolX", 570, 23083, 26330);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 570, 23083, 26330);
            CallChecker.varInit(this.stopFitness, "stopFitness", 570, 23083, 26330);
            CallChecker.varInit(this.maxIterations, "maxIterations", 570, 23083, 26330);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 570, 23083, 26330);
            CallChecker.varInit(this.isMinimize, "isMinimize", 570, 23083, 26330);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 570, 23083, 26330);
            CallChecker.varInit(this.dimension, "dimension", 570, 23083, 26330);
            CallChecker.varInit(this.inputSigma, "inputSigma", 570, 23083, 26330);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 570, 23083, 26330);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 570, 23083, 26330);
            CallChecker.varInit(this.lambda, "lambda", 570, 23083, 26330);
            if ((lambda) <= 0) {
                throw new NotStrictlyPositiveException(lambda);
            }
            guess = CallChecker.beforeCalled(guess, double[].class, 575, 23457, 23461);
            final double[][] sigmaArray = CallChecker.varInit(new double[CallChecker.isCalled(guess, double[].class, 575, 23457, 23461).length][1], "sigmaArray", 575, 23416, 23473);
            guess = CallChecker.beforeCalled(guess, double[].class, 576, 23503, 23507);
            for (int i = 0; i < (CallChecker.isCalled(guess, double[].class, 576, 23503, 23507).length); i++) {
                if (CallChecker.beforeDeref(sigmaArray, double[][].class, 577, 23536, 23545)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i], double[].class, 577, 23536, 23548)) {
                        if (CallChecker.beforeDeref(inputSigma, double[].class, 577, 23555, 23564)) {
                            CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i], double[].class, 577, 23536, 23548);
                            inputSigma = CallChecker.beforeCalled(inputSigma, double[].class, 577, 23555, 23564);
                            CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i], double[].class, 577, 23536, 23548)[0] = CallChecker.isCalled(inputSigma, double[].class, 577, 23555, 23564)[i];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i], double[].class, 577, 23536, 23548)[0], "CallChecker.isCalled(CallChecker.isCalled(sigmaArray, double[][].class, 577, 23536, 23545)[i], double[].class, 577, 23536, 23548)[0]", 577, 23536, 23568);
                        }
                    }
                }
            }
            final RealMatrix insigma = CallChecker.varInit(new Array2DRowRealMatrix(sigmaArray, false), "insigma", 579, 23588, 23658);
            sigma = CMAESOptimizer.max(insigma);
            CallChecker.varAssign(this.sigma, "this.sigma", 580, 23668, 23688);
            stopTolUpX = 1000.0 * (CMAESOptimizer.max(insigma));
            CallChecker.varAssign(this.stopTolUpX, "this.stopTolUpX", 583, 23772, 23803);
            stopTolX = 1.0E-11 * (CMAESOptimizer.max(insigma));
            CallChecker.varAssign(this.stopTolX, "this.stopTolX", 584, 23813, 23844);
            stopTolFun = 1.0E-12;
            CallChecker.varAssign(this.stopTolFun, "this.stopTolFun", 585, 23854, 23872);
            stopTolHistFun = 1.0E-13;
            CallChecker.varAssign(this.stopTolHistFun, "this.stopTolHistFun", 586, 23882, 23904);
            mu = (lambda) / 2;
            CallChecker.varAssign(this.mu, "this.mu", 589, 23967, 23982);
            logMu2 = Math.log(((mu) + 0.5));
            CallChecker.varAssign(this.logMu2, "this.logMu2", 590, 24038, 24065);
            final RealMatrix npe_invocation_var740 = CMAESOptimizer.log(CMAESOptimizer.sequence(1, mu, 1));
            if (CallChecker.beforeDeref(npe_invocation_var740, RealMatrix.class, 591, 24085, 24107)) {
                final RealMatrix npe_invocation_var741 = CallChecker.isCalled(npe_invocation_var740, RealMatrix.class, 591, 24085, 24107).scalarMultiply((-1));
                if (CallChecker.beforeDeref(npe_invocation_var741, RealMatrix.class, 591, 24085, 24126)) {
                    weights = CallChecker.isCalled(npe_invocation_var741, RealMatrix.class, 591, 24085, 24126).scalarAdd(logMu2);
                    CallChecker.varAssign(this.weights, "this.weights", 591, 24075, 24145);
                }
            }
            double sumw = CallChecker.varInit(((double) (0)), "sumw", 592, 24155, 24170);
            double sumwq = CallChecker.varInit(((double) (0)), "sumwq", 593, 24180, 24196);
            for (int i = 0; i < (mu); i++) {
                double w = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(weights, RealMatrix.class, 595, 24260, 24266)) {
                    weights = CallChecker.beforeCalled(weights, RealMatrix.class, 595, 24260, 24266);
                    w = CallChecker.isCalled(weights, RealMatrix.class, 595, 24260, 24266).getEntry(i, 0);
                    CallChecker.varAssign(w, "w", 595, 24260, 24266);
                }
                sumw += w;
                CallChecker.varAssign(sumw, "sumw", 596, 24296, 24305);
                sumwq += w * w;
                CallChecker.varAssign(sumwq, "sumwq", 597, 24319, 24333);
            }
            if (CallChecker.beforeDeref(weights, RealMatrix.class, 599, 24363, 24369)) {
                weights = CallChecker.beforeCalled(weights, RealMatrix.class, 599, 24363, 24369);
                weights = CallChecker.isCalled(weights, RealMatrix.class, 599, 24363, 24369).scalarMultiply((1 / sumw));
                CallChecker.varAssign(this.weights, "this.weights", 599, 24353, 24395);
            }
            mueff = (sumw * sumw) / sumwq;
            CallChecker.varAssign(this.mueff, "this.mueff", 600, 24405, 24432);
            cc = (4 + ((mueff) / (dimension))) / (((dimension) + 4) + ((2 * (mueff)) / (dimension)));
            CallChecker.varAssign(this.cc, "this.cc", 603, 24548, 24634);
            cs = ((mueff) + 2) / (((dimension) + (mueff)) + 3.0);
            CallChecker.varAssign(this.cs, "this.cs", 605, 24644, 24687);
            damps = ((1 + (2 * (Math.max(0, ((Math.sqrt((((mueff) - 1) / ((dimension) + 1)))) - 1))))) * (Math.max(0.3, (1 - ((dimension) / (1.0E-6 + (maxIterations))))))) + (cs);
            CallChecker.varAssign(this.damps, "this.damps", 606, 24697, 24913);
            ccov1 = 2 / ((((dimension) + 1.3) * ((dimension) + 1.3)) + (mueff));
            CallChecker.varAssign(this.ccov1, "this.ccov1", 610, 24942, 25001);
            ccovmu = Math.min((1 - (ccov1)), ((2 * (((mueff) - 2) + (1 / (mueff)))) / ((((dimension) + 2) * ((dimension) + 2)) + (mueff))));
            CallChecker.varAssign(this.ccovmu, "this.ccovmu", 611, 25011, 25140);
            ccov1Sep = Math.min(1, (((ccov1) * ((dimension) + 1.5)) / 3));
            CallChecker.varAssign(this.ccov1Sep, "this.ccov1Sep", 613, 25150, 25203);
            ccovmuSep = Math.min((1 - (ccov1)), (((ccovmu) * ((dimension) + 1.5)) / 3));
            CallChecker.varAssign(this.ccovmuSep, "this.ccovmuSep", 614, 25213, 25276);
            chiN = (Math.sqrt(dimension)) * ((1 - (1 / (((double) (4)) * (dimension)))) + (1 / ((((double) (21)) * (dimension)) * (dimension))));
            CallChecker.varAssign(this.chiN, "this.chiN", 615, 25286, 25406);
            xmean = MatrixUtils.createColumnRealMatrix(guess);
            CallChecker.varAssign(this.xmean, "this.xmean", 618, 25483, 25532);
            if (CallChecker.beforeDeref(insigma, RealMatrix.class, 619, 25573, 25579)) {
                diagD = CallChecker.isCalled(insigma, RealMatrix.class, 619, 25573, 25579).scalarMultiply((1 / (sigma)));
                CallChecker.varAssign(this.diagD, "this.diagD", 619, 25565, 25606);
            }
            diagC = CMAESOptimizer.square(diagD);
            CallChecker.varAssign(this.diagC, "this.diagC", 620, 25616, 25637);
            pc = CMAESOptimizer.zeros(dimension, 1);
            CallChecker.varAssign(this.pc, "this.pc", 621, 25647, 25671);
            ps = CMAESOptimizer.zeros(dimension, 1);
            CallChecker.varAssign(this.ps, "this.ps", 622, 25716, 25740);
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 623, 25794, 25795)) {
                ps = CallChecker.beforeCalled(ps, RealMatrix.class, 623, 25794, 25795);
                normps = CallChecker.isCalled(ps, RealMatrix.class, 623, 25794, 25795).getFrobeniusNorm();
                CallChecker.varAssign(this.normps, "this.normps", 623, 25785, 25815);
            }
            B = CMAESOptimizer.eye(dimension, dimension);
            CallChecker.varAssign(this.B, "this.B", 625, 25826, 25855);
            D = CMAESOptimizer.ones(dimension, 1);
            CallChecker.varAssign(this.D, "this.D", 626, 25865, 25887);
            if (CallChecker.beforeDeref(diagD, RealMatrix.class, 627, 25952, 25956)) {
                diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 627, 25952, 25956);
                BD = CMAESOptimizer.times(B, CMAESOptimizer.repmat(CallChecker.isCalled(diagD, RealMatrix.class, 627, 25952, 25956).transpose(), dimension, 1));
                CallChecker.varAssign(this.BD, "this.BD", 627, 25931, 25985);
            }
            if (CallChecker.beforeDeref(B, RealMatrix.class, 628, 26035, 26035)) {
                final RealMatrix npe_invocation_var742 = CMAESOptimizer.diag(CMAESOptimizer.square(D));
                if (CallChecker.beforeDeref(npe_invocation_var742, RealMatrix.class, 628, 26010, 26024)) {
                    if (CallChecker.beforeDeref(B, RealMatrix.class, 628, 25999, 25999)) {
                        B = CallChecker.beforeCalled(B, RealMatrix.class, 628, 26035, 26035);
                        B = CallChecker.beforeCalled(B, RealMatrix.class, 628, 25999, 25999);
                        C = CallChecker.isCalled(B, RealMatrix.class, 628, 25999, 25999).multiply(CallChecker.isCalled(npe_invocation_var742, RealMatrix.class, 628, 26010, 26024).multiply(CallChecker.isCalled(B, RealMatrix.class, 628, 26035, 26035).transpose()));
                        CallChecker.varAssign(this.C, "this.C", 628, 25995, 26050);
                    }
                }
            }
            historySize = 10 + ((int) (((3 * 10) * (dimension)) / ((double) (lambda))));
            CallChecker.varAssign(this.historySize, "this.historySize", 629, 26074, 26137);
            fitnessHistory = new double[historySize];
            CallChecker.varAssign(this.fitnessHistory, "this.fitnessHistory", 630, 26147, 26187);
            for (int i = 0; i < (historySize); i++) {
                if (CallChecker.beforeDeref(fitnessHistory, double[].class, 632, 26278, 26291)) {
                    fitnessHistory = CallChecker.beforeCalled(fitnessHistory, double[].class, 632, 26278, 26291);
                    CallChecker.isCalled(fitnessHistory, double[].class, 632, 26278, 26291)[i] = Double.MAX_VALUE;
                    CallChecker.varAssign(CallChecker.isCalled(this.fitnessHistory, double[].class, 632, 26278, 26291)[i], "CallChecker.isCalled(this.fitnessHistory, double[].class, 632, 26278, 26291)[i]", 632, 26278, 26314);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2870.methodEnd();
        }
    }

    private boolean updateEvolutionPaths(RealMatrix zmean, RealMatrix xold) {
        MethodContext _bcornu_methode_context2871 = new MethodContext(boolean.class, 644, 26337, 27258);
        try {
            CallChecker.varInit(this, "this", 644, 26337, 27258);
            CallChecker.varInit(xold, "xold", 644, 26337, 27258);
            CallChecker.varInit(zmean, "zmean", 644, 26337, 27258);
            CallChecker.varInit(this.iterations, "iterations", 644, 26337, 27258);
            CallChecker.varInit(this.evaluations, "evaluations", 644, 26337, 27258);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 644, 26337, 27258);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 644, 26337, 27258);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 644, 26337, 27258);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 644, 26337, 27258);
            CallChecker.varInit(this.random, "random", 644, 26337, 27258);
            CallChecker.varInit(this.historySize, "historySize", 644, 26337, 27258);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 644, 26337, 27258);
            CallChecker.varInit(this.iterations, "iterations", 644, 26337, 27258);
            CallChecker.varInit(this.diagC, "diagC", 644, 26337, 27258);
            CallChecker.varInit(this.C, "C", 644, 26337, 27258);
            CallChecker.varInit(this.diagD, "diagD", 644, 26337, 27258);
            CallChecker.varInit(this.BD, "BD", 644, 26337, 27258);
            CallChecker.varInit(this.D, "D", 644, 26337, 27258);
            CallChecker.varInit(this.B, "B", 644, 26337, 27258);
            CallChecker.varInit(this.normps, "normps", 644, 26337, 27258);
            CallChecker.varInit(this.ps, "ps", 644, 26337, 27258);
            CallChecker.varInit(this.pc, "pc", 644, 26337, 27258);
            CallChecker.varInit(this.xmean, "xmean", 644, 26337, 27258);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 644, 26337, 27258);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 644, 26337, 27258);
            CallChecker.varInit(this.chiN, "chiN", 644, 26337, 27258);
            CallChecker.varInit(this.ccovmu, "ccovmu", 644, 26337, 27258);
            CallChecker.varInit(this.ccov1, "ccov1", 644, 26337, 27258);
            CallChecker.varInit(this.damps, "damps", 644, 26337, 27258);
            CallChecker.varInit(this.cs, "cs", 644, 26337, 27258);
            CallChecker.varInit(this.cc, "cc", 644, 26337, 27258);
            CallChecker.varInit(this.sigma, "sigma", 644, 26337, 27258);
            CallChecker.varInit(this.mueff, "mueff", 644, 26337, 27258);
            CallChecker.varInit(this.weights, "weights", 644, 26337, 27258);
            CallChecker.varInit(this.logMu2, "logMu2", 644, 26337, 27258);
            CallChecker.varInit(this.mu, "mu", 644, 26337, 27258);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 644, 26337, 27258);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 644, 26337, 27258);
            CallChecker.varInit(this.stopTolX, "stopTolX", 644, 26337, 27258);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 644, 26337, 27258);
            CallChecker.varInit(this.stopFitness, "stopFitness", 644, 26337, 27258);
            CallChecker.varInit(this.maxIterations, "maxIterations", 644, 26337, 27258);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 644, 26337, 27258);
            CallChecker.varInit(this.isMinimize, "isMinimize", 644, 26337, 27258);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 644, 26337, 27258);
            CallChecker.varInit(this.dimension, "dimension", 644, 26337, 27258);
            CallChecker.varInit(this.inputSigma, "inputSigma", 644, 26337, 27258);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 644, 26337, 27258);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 644, 26337, 27258);
            CallChecker.varInit(this.lambda, "lambda", 644, 26337, 27258);
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 645, 26723, 26724)) {
                if (CallChecker.beforeDeref(B, RealMatrix.class, 646, 26770, 26770)) {
                    B = CallChecker.beforeCalled(B, RealMatrix.class, 646, 26770, 26770);
                    final RealMatrix npe_invocation_var743 = CallChecker.isCalled(B, RealMatrix.class, 646, 26770, 26770).multiply(zmean);
                    if (CallChecker.beforeDeref(npe_invocation_var743, RealMatrix.class, 646, 26770, 26786)) {
                        ps = CallChecker.beforeCalled(ps, RealMatrix.class, 645, 26723, 26724);
                        final RealMatrix npe_invocation_var744 = CallChecker.isCalled(ps, RealMatrix.class, 645, 26723, 26724).scalarMultiply((1 - (cs)));
                        if (CallChecker.beforeDeref(npe_invocation_var744, RealMatrix.class, 645, 26723, 26747)) {
                            ps = CallChecker.isCalled(npe_invocation_var744, RealMatrix.class, 645, 26723, 26747).add(CallChecker.isCalled(npe_invocation_var743, RealMatrix.class, 646, 26770, 26786).scalarMultiply(Math.sqrt((((cs) * (2 - (cs))) * (mueff)))));
                            CallChecker.varAssign(this.ps, "this.ps", 645, 26718, 26862);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(ps, RealMatrix.class, 648, 26881, 26882)) {
                ps = CallChecker.beforeCalled(ps, RealMatrix.class, 648, 26881, 26882);
                normps = CallChecker.isCalled(ps, RealMatrix.class, 648, 26881, 26882).getFrobeniusNorm();
                CallChecker.varAssign(this.normps, "this.normps", 648, 26872, 26902);
            }
            final boolean hsig = CallChecker.varInit(((boolean) ((((this.normps) / (Math.sqrt((1 - (Math.pow((1 - (this.cs)), (2 * (this.iterations)))))))) / (this.chiN)) < (1.4 + (2 / (((double) (this.dimension)) + 1))))), "hsig", 649, 26912, 27057);
            if (CallChecker.beforeDeref(pc, RealMatrix.class, 652, 27072, 27073)) {
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 652, 27072, 27073);
                pc = CallChecker.isCalled(pc, RealMatrix.class, 652, 27072, 27073).scalarMultiply((1 - (cc)));
                CallChecker.varAssign(this.pc, "this.pc", 652, 27067, 27097);
            }
            if (hsig) {
                if (CallChecker.beforeDeref(xmean, RealMatrix.class, 654, 27143, 27147)) {
                    xmean = CallChecker.beforeCalled(xmean, RealMatrix.class, 654, 27143, 27147);
                    final RealMatrix npe_invocation_var745 = CallChecker.isCalled(xmean, RealMatrix.class, 654, 27143, 27147).subtract(xold);
                    if (CallChecker.beforeDeref(npe_invocation_var745, RealMatrix.class, 654, 27143, 27162)) {
                        if (CallChecker.beforeDeref(pc, RealMatrix.class, 654, 27136, 27137)) {
                            pc = CallChecker.beforeCalled(pc, RealMatrix.class, 654, 27136, 27137);
                            pc = CallChecker.isCalled(pc, RealMatrix.class, 654, 27136, 27137).add(CallChecker.isCalled(npe_invocation_var745, RealMatrix.class, 654, 27143, 27162).scalarMultiply(((Math.sqrt((((cc) * (2 - (cc))) * (mueff)))) / (sigma))));
                            CallChecker.varAssign(this.pc, "this.pc", 654, 27131, 27221);
                        }
                    }
                }
            }
            return hsig;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2871.methodEnd();
        }
    }

    private void updateCovarianceDiagonalOnly(boolean hsig, final RealMatrix bestArz) {
        MethodContext _bcornu_methode_context2872 = new MethodContext(void.class, 666, 27265, 28387);
        try {
            CallChecker.varInit(this, "this", 666, 27265, 28387);
            CallChecker.varInit(bestArz, "bestArz", 666, 27265, 28387);
            CallChecker.varInit(hsig, "hsig", 666, 27265, 28387);
            CallChecker.varInit(this.iterations, "iterations", 666, 27265, 28387);
            CallChecker.varInit(this.evaluations, "evaluations", 666, 27265, 28387);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 666, 27265, 28387);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 666, 27265, 28387);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 666, 27265, 28387);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 666, 27265, 28387);
            CallChecker.varInit(this.random, "random", 666, 27265, 28387);
            CallChecker.varInit(this.historySize, "historySize", 666, 27265, 28387);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 666, 27265, 28387);
            CallChecker.varInit(this.iterations, "iterations", 666, 27265, 28387);
            CallChecker.varInit(this.diagC, "diagC", 666, 27265, 28387);
            CallChecker.varInit(this.C, "C", 666, 27265, 28387);
            CallChecker.varInit(this.diagD, "diagD", 666, 27265, 28387);
            CallChecker.varInit(this.BD, "BD", 666, 27265, 28387);
            CallChecker.varInit(this.D, "D", 666, 27265, 28387);
            CallChecker.varInit(this.B, "B", 666, 27265, 28387);
            CallChecker.varInit(this.normps, "normps", 666, 27265, 28387);
            CallChecker.varInit(this.ps, "ps", 666, 27265, 28387);
            CallChecker.varInit(this.pc, "pc", 666, 27265, 28387);
            CallChecker.varInit(this.xmean, "xmean", 666, 27265, 28387);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 666, 27265, 28387);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 666, 27265, 28387);
            CallChecker.varInit(this.chiN, "chiN", 666, 27265, 28387);
            CallChecker.varInit(this.ccovmu, "ccovmu", 666, 27265, 28387);
            CallChecker.varInit(this.ccov1, "ccov1", 666, 27265, 28387);
            CallChecker.varInit(this.damps, "damps", 666, 27265, 28387);
            CallChecker.varInit(this.cs, "cs", 666, 27265, 28387);
            CallChecker.varInit(this.cc, "cc", 666, 27265, 28387);
            CallChecker.varInit(this.sigma, "sigma", 666, 27265, 28387);
            CallChecker.varInit(this.mueff, "mueff", 666, 27265, 28387);
            CallChecker.varInit(this.weights, "weights", 666, 27265, 28387);
            CallChecker.varInit(this.logMu2, "logMu2", 666, 27265, 28387);
            CallChecker.varInit(this.mu, "mu", 666, 27265, 28387);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 666, 27265, 28387);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 666, 27265, 28387);
            CallChecker.varInit(this.stopTolX, "stopTolX", 666, 27265, 28387);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 666, 27265, 28387);
            CallChecker.varInit(this.stopFitness, "stopFitness", 666, 27265, 28387);
            CallChecker.varInit(this.maxIterations, "maxIterations", 666, 27265, 28387);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 666, 27265, 28387);
            CallChecker.varInit(this.isMinimize, "isMinimize", 666, 27265, 28387);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 666, 27265, 28387);
            CallChecker.varInit(this.dimension, "dimension", 666, 27265, 28387);
            CallChecker.varInit(this.inputSigma, "inputSigma", 666, 27265, 28387);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 666, 27265, 28387);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 666, 27265, 28387);
            CallChecker.varInit(this.lambda, "lambda", 666, 27265, 28387);
            double oldFac = CallChecker.init(double.class);
            if (hsig) {
                oldFac = 0;
                CallChecker.varAssign(oldFac, "oldFac", 669, 27709, 27743);
            }else {
                oldFac = ((ccov1Sep) * (cc)) * (2 - (cc));
                CallChecker.varAssign(oldFac, "oldFac", 669, 27709, 27743);
            }
            oldFac += (1 - (ccov1Sep)) - (ccovmuSep);
            CallChecker.varAssign(oldFac, "oldFac", 670, 27754, 27788);
            if (CallChecker.beforeDeref(diagC, RealMatrix.class, 671, 27806, 27810)) {
                final RealMatrix npe_invocation_var746 = CMAESOptimizer.square(pc);
                if (CallChecker.beforeDeref(npe_invocation_var746, RealMatrix.class, 672, 27873, 27882)) {
                    diagC = CallChecker.beforeCalled(diagC, RealMatrix.class, 671, 27806, 27810);
                    final RealMatrix npe_invocation_var747 = CallChecker.isCalled(diagC, RealMatrix.class, 671, 27806, 27810).scalarMultiply(oldFac);
                    if (CallChecker.beforeDeref(npe_invocation_var747, RealMatrix.class, 671, 27806, 27833)) {
                        final RealMatrix npe_invocation_var748 = CMAESOptimizer.square(bestArz);
                        if (CallChecker.beforeDeref(npe_invocation_var748, RealMatrix.class, 673, 27965, 27979)) {
                            final RealMatrix npe_invocation_var749 = CMAESOptimizer.times(diagC, CallChecker.isCalled(npe_invocation_var748, RealMatrix.class, 673, 27965, 27979).multiply(weights));
                            if (CallChecker.beforeDeref(npe_invocation_var749, RealMatrix.class, 673, 27951, 27999)) {
                                final RealMatrix npe_invocation_var750 = CallChecker.isCalled(npe_invocation_var747, RealMatrix.class, 671, 27806, 27833).add(CallChecker.isCalled(npe_invocation_var746, RealMatrix.class, 672, 27873, 27882).scalarMultiply(ccov1Sep));
                                if (CallChecker.beforeDeref(npe_invocation_var750, RealMatrix.class, 671, 27806, 27908)) {
                                    diagC = CallChecker.isCalled(npe_invocation_var750, RealMatrix.class, 671, 27806, 27908).add(CallChecker.isCalled(npe_invocation_var749, RealMatrix.class, 673, 27951, 27999).scalarMultiply(ccovmuSep));
                                    CallChecker.varAssign(this.diagC, "this.diagC", 671, 27798, 28068);
                                }
                            }
                        }
                    }
                }
            }
            diagD = CMAESOptimizer.sqrt(diagC);
            CallChecker.varAssign(this.diagD, "this.diagD", 675, 28078, 28097);
            if (((diagonalOnly) > 1) && ((iterations) > (diagonalOnly))) {
                diagonalOnly = 0;
                CallChecker.varAssign(this.diagonalOnly, "this.diagonalOnly", 679, 28253, 28269);
                B = CMAESOptimizer.eye(dimension, dimension);
                CallChecker.varAssign(this.B, "this.B", 680, 28283, 28312);
                BD = CMAESOptimizer.diag(diagD);
                CallChecker.varAssign(this.BD, "this.BD", 681, 28326, 28342);
                C = CMAESOptimizer.diag(diagC);
                CallChecker.varAssign(this.C, "this.C", 682, 28356, 28371);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2872.methodEnd();
        }
    }

    private void updateCovariance(boolean hsig, final RealMatrix bestArx, final RealMatrix arz, final int[] arindex, final RealMatrix xold) {
        MethodContext _bcornu_methode_context2873 = new MethodContext(void.class, 697, 28394, 32365);
        try {
            CallChecker.varInit(this, "this", 697, 28394, 32365);
            CallChecker.varInit(xold, "xold", 697, 28394, 32365);
            CallChecker.varInit(arindex, "arindex", 697, 28394, 32365);
            CallChecker.varInit(arz, "arz", 697, 28394, 32365);
            CallChecker.varInit(bestArx, "bestArx", 697, 28394, 32365);
            CallChecker.varInit(hsig, "hsig", 697, 28394, 32365);
            CallChecker.varInit(this.iterations, "iterations", 697, 28394, 32365);
            CallChecker.varInit(this.evaluations, "evaluations", 697, 28394, 32365);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 697, 28394, 32365);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 697, 28394, 32365);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 697, 28394, 32365);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 697, 28394, 32365);
            CallChecker.varInit(this.random, "random", 697, 28394, 32365);
            CallChecker.varInit(this.historySize, "historySize", 697, 28394, 32365);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 697, 28394, 32365);
            CallChecker.varInit(this.iterations, "iterations", 697, 28394, 32365);
            CallChecker.varInit(this.diagC, "diagC", 697, 28394, 32365);
            CallChecker.varInit(this.C, "C", 697, 28394, 32365);
            CallChecker.varInit(this.diagD, "diagD", 697, 28394, 32365);
            CallChecker.varInit(this.BD, "BD", 697, 28394, 32365);
            CallChecker.varInit(this.D, "D", 697, 28394, 32365);
            CallChecker.varInit(this.B, "B", 697, 28394, 32365);
            CallChecker.varInit(this.normps, "normps", 697, 28394, 32365);
            CallChecker.varInit(this.ps, "ps", 697, 28394, 32365);
            CallChecker.varInit(this.pc, "pc", 697, 28394, 32365);
            CallChecker.varInit(this.xmean, "xmean", 697, 28394, 32365);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 697, 28394, 32365);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 697, 28394, 32365);
            CallChecker.varInit(this.chiN, "chiN", 697, 28394, 32365);
            CallChecker.varInit(this.ccovmu, "ccovmu", 697, 28394, 32365);
            CallChecker.varInit(this.ccov1, "ccov1", 697, 28394, 32365);
            CallChecker.varInit(this.damps, "damps", 697, 28394, 32365);
            CallChecker.varInit(this.cs, "cs", 697, 28394, 32365);
            CallChecker.varInit(this.cc, "cc", 697, 28394, 32365);
            CallChecker.varInit(this.sigma, "sigma", 697, 28394, 32365);
            CallChecker.varInit(this.mueff, "mueff", 697, 28394, 32365);
            CallChecker.varInit(this.weights, "weights", 697, 28394, 32365);
            CallChecker.varInit(this.logMu2, "logMu2", 697, 28394, 32365);
            CallChecker.varInit(this.mu, "mu", 697, 28394, 32365);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 697, 28394, 32365);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 697, 28394, 32365);
            CallChecker.varInit(this.stopTolX, "stopTolX", 697, 28394, 32365);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 697, 28394, 32365);
            CallChecker.varInit(this.stopFitness, "stopFitness", 697, 28394, 32365);
            CallChecker.varInit(this.maxIterations, "maxIterations", 697, 28394, 32365);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 697, 28394, 32365);
            CallChecker.varInit(this.isMinimize, "isMinimize", 697, 28394, 32365);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 697, 28394, 32365);
            CallChecker.varInit(this.dimension, "dimension", 697, 28394, 32365);
            CallChecker.varInit(this.inputSigma, "inputSigma", 697, 28394, 32365);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 697, 28394, 32365);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 697, 28394, 32365);
            CallChecker.varInit(this.lambda, "lambda", 697, 28394, 32365);
            double negccov = CallChecker.varInit(((double) (0)), "negccov", 700, 29086, 29104);
            if (((ccov1) + (ccovmu)) > 0) {
                final RealMatrix arpos = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(bestArx, RealMatrix.class, 702, 29177, 29183).subtract(CMAESOptimizer.repmat(xold, 1, mu)), RealMatrix.class, 702, 29177, 29213).scalarMultiply((1 / (sigma))), "arpos", 702, 29152, 29257);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 704, 29333, 29334);
                pc = CallChecker.beforeCalled(pc, RealMatrix.class, 704, 29321, 29322);
                final RealMatrix roneu = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(pc, RealMatrix.class, 704, 29321, 29322).multiply(CallChecker.isCalled(pc, RealMatrix.class, 704, 29333, 29334).transpose()), RealMatrix.class, 704, 29321, 29347).scalarMultiply(ccov1), "roneu", 704, 29296, 29387);
                double oldFac = CallChecker.init(double.class);
                if (hsig) {
                    oldFac = 0;
                    CallChecker.varAssign(oldFac, "oldFac", 707, 29483, 29514);
                }else {
                    oldFac = ((ccov1) * (cc)) * (2 - (cc));
                    CallChecker.varAssign(oldFac, "oldFac", 707, 29483, 29514);
                }
                oldFac += (1 - (ccov1)) - (ccovmu);
                CallChecker.varAssign(oldFac, "oldFac", 708, 29529, 29557);
                if (isActiveCMA) {
                    negccov = (((1 - (ccovmu)) * 0.25) * (mueff)) / ((Math.pow(((dimension) + 2), 1.5)) + (2 * (mueff)));
                    CallChecker.varAssign(negccov, "negccov", 711, 29662, 29764);
                    final double negminresidualvariance = CallChecker.varInit(((double) (0.66)), "negminresidualvariance", 715, 29782, 29932);
                    final double negalphaold = CallChecker.varInit(((double) (0.5)), "negalphaold", 717, 29950, 30038);
                    final int[] arReverseIndex = CallChecker.varInit(CMAESOptimizer.reverse(arindex), "arReverseIndex", 719, 30130, 30175);
                    RealMatrix arzneg = CallChecker.varInit(CMAESOptimizer.selectColumns(arz, MathArrays.copyOf(arReverseIndex, mu)), "arzneg", 720, 30193, 30270);
                    RealMatrix arnorms = CallChecker.varInit(CMAESOptimizer.sqrt(CMAESOptimizer.sumRows(CMAESOptimizer.square(arzneg))), "arnorms", 721, 30288, 30338);
                    arnorms = CallChecker.beforeCalled(arnorms, RealMatrix.class, 722, 30393, 30399);
                    final int[] idxnorms = CallChecker.varInit(sortedIndices(CallChecker.isCalled(arnorms, RealMatrix.class, 722, 30393, 30399).getRow(0)), "idxnorms", 722, 30356, 30411);
                    final RealMatrix arnormsSorted = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxnorms), "arnormsSorted", 723, 30429, 30494);
                    final int[] idxReverse = CallChecker.varInit(CMAESOptimizer.reverse(idxnorms), "idxReverse", 724, 30512, 30554);
                    final RealMatrix arnormsReverse = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxReverse), "arnormsReverse", 725, 30572, 30640);
                    arnorms = CMAESOptimizer.divide(arnormsReverse, arnormsSorted);
                    CallChecker.varAssign(arnorms, "arnorms", 726, 30658, 30705);
                    final int[] idxInv = CallChecker.varInit(CMAESOptimizer.inverse(idxnorms), "idxInv", 727, 30723, 30761);
                    final RealMatrix arnormsInv = CallChecker.varInit(CMAESOptimizer.selectColumns(arnorms, idxInv), "arnormsInv", 728, 30779, 30839);
                    final double negcovMax = CallChecker.varInit(((double) ((1 - negminresidualvariance) / (CallChecker.isCalled(CallChecker.isCalled(CMAESOptimizer.square(arnormsInv), RealMatrix.class, 731, 30988, 31005).multiply(this.weights), RealMatrix.class, 731, 30988, 31023).getEntry(0, 0)))), "negcovMax", 730, 30857, 31039);
                    if (negccov > negcovMax) {
                        negccov = negcovMax;
                        CallChecker.varAssign(negccov, "negccov", 733, 31104, 31123);
                    }
                    arzneg = CMAESOptimizer.times(arzneg, CMAESOptimizer.repmat(arnormsInv, dimension, 1));
                    CallChecker.varAssign(arzneg, "arzneg", 735, 31159, 31215);
                    BD = CallChecker.beforeCalled(BD, RealMatrix.class, 736, 31258, 31259);
                    final RealMatrix artmp = CallChecker.varInit(CallChecker.isCalled(BD, RealMatrix.class, 736, 31258, 31259).multiply(arzneg), "artmp", 736, 31233, 31277);
                    final RealMatrix Cneg = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(artmp, RealMatrix.class, 737, 31319, 31323).multiply(CMAESOptimizer.diag(weights)), RealMatrix.class, 737, 31319, 31347).multiply(CallChecker.isCalled(artmp, RealMatrix.class, 737, 31358, 31362).transpose()), "Cneg", 737, 31295, 31376);
                    oldFac += negalphaold * negccov;
                    CallChecker.varAssign(oldFac, "oldFac", 738, 31394, 31425);
                    if (CallChecker.beforeDeref(C, RealMatrix.class, 739, 31447, 31447)) {
                        C = CallChecker.beforeCalled(C, RealMatrix.class, 739, 31447, 31447);
                        final RealMatrix npe_invocation_var751 = CallChecker.isCalled(C, RealMatrix.class, 739, 31447, 31447).scalarMultiply(oldFac);
                        if (CallChecker.beforeDeref(npe_invocation_var751, RealMatrix.class, 739, 31447, 31470)) {
                            if (CallChecker.beforeDeref(arpos, RealMatrix.class, 741, 31550, 31554)) {
                                if (CallChecker.beforeDeref(arpos, RealMatrix.class, 744, 31816, 31820)) {
                                    final RealMatrix npe_invocation_var752 = CallChecker.isCalled(arpos, RealMatrix.class, 741, 31550, 31554).scalarMultiply(((ccovmu) + ((1 - negalphaold) * negccov)));
                                    if (CallChecker.beforeDeref(npe_invocation_var752, RealMatrix.class, 741, 31550, 31678)) {
                                        final RealMatrix npe_invocation_var753 = CallChecker.isCalled(npe_invocation_var751, RealMatrix.class, 739, 31447, 31470).add(roneu);
                                        if (CallChecker.beforeDeref(npe_invocation_var753, RealMatrix.class, 739, 31447, 31502)) {
                                            if (CallChecker.beforeDeref(Cneg, RealMatrix.class, 745, 31867, 31870)) {
                                                final RealMatrix npe_invocation_var754 = CallChecker.isCalled(npe_invocation_var753, RealMatrix.class, 739, 31447, 31502).add(CallChecker.isCalled(npe_invocation_var752, RealMatrix.class, 741, 31550, 31678).multiply(CMAESOptimizer.times(CMAESOptimizer.repmat(weights, 1, dimension), CallChecker.isCalled(arpos, RealMatrix.class, 744, 31816, 31820).transpose())));
                                                if (CallChecker.beforeDeref(npe_invocation_var754, RealMatrix.class, 739, 31447, 31835)) {
                                                    C = CallChecker.isCalled(npe_invocation_var754, RealMatrix.class, 739, 31447, 31835).subtract(CallChecker.isCalled(Cneg, RealMatrix.class, 745, 31867, 31870).scalarMultiply(negccov));
                                                    CallChecker.varAssign(this.C, "this.C", 739, 31443, 31896);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(C, RealMatrix.class, 748, 31996, 31996)) {
                        C = CallChecker.beforeCalled(C, RealMatrix.class, 748, 31996, 31996);
                        final RealMatrix npe_invocation_var755 = CallChecker.isCalled(C, RealMatrix.class, 748, 31996, 31996).scalarMultiply(oldFac);
                        if (CallChecker.beforeDeref(npe_invocation_var755, RealMatrix.class, 748, 31996, 32019)) {
                            if (CallChecker.beforeDeref(arpos, RealMatrix.class, 750, 32123, 32127)) {
                                if (CallChecker.beforeDeref(arpos, RealMatrix.class, 752, 32288, 32292)) {
                                    final RealMatrix npe_invocation_var756 = CallChecker.isCalled(arpos, RealMatrix.class, 750, 32123, 32127).scalarMultiply(ccovmu);
                                    if (CallChecker.beforeDeref(npe_invocation_var756, RealMatrix.class, 750, 32123, 32150)) {
                                        final RealMatrix npe_invocation_var757 = CallChecker.isCalled(npe_invocation_var755, RealMatrix.class, 748, 31996, 32019).add(roneu);
                                        if (CallChecker.beforeDeref(npe_invocation_var757, RealMatrix.class, 748, 31996, 32072)) {
                                            C = CallChecker.isCalled(npe_invocation_var757, RealMatrix.class, 748, 31996, 32072).add(CallChecker.isCalled(npe_invocation_var756, RealMatrix.class, 750, 32123, 32150).multiply(CMAESOptimizer.times(CMAESOptimizer.repmat(weights, 1, dimension), CallChecker.isCalled(arpos, RealMatrix.class, 752, 32288, 32292).transpose())));
                                            CallChecker.varAssign(this.C, "this.C", 748, 31992, 32308);
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
            _bcornu_methode_context2873.methodEnd();
        }
    }

    private void updateBD(double negccov) {
        MethodContext _bcornu_methode_context2874 = new MethodContext(void.class, 763, 32372, 33922);
        try {
            CallChecker.varInit(this, "this", 763, 32372, 33922);
            CallChecker.varInit(negccov, "negccov", 763, 32372, 33922);
            CallChecker.varInit(this.iterations, "iterations", 763, 32372, 33922);
            CallChecker.varInit(this.evaluations, "evaluations", 763, 32372, 33922);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 763, 32372, 33922);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 763, 32372, 33922);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 763, 32372, 33922);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 763, 32372, 33922);
            CallChecker.varInit(this.random, "random", 763, 32372, 33922);
            CallChecker.varInit(this.historySize, "historySize", 763, 32372, 33922);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 763, 32372, 33922);
            CallChecker.varInit(this.iterations, "iterations", 763, 32372, 33922);
            CallChecker.varInit(this.diagC, "diagC", 763, 32372, 33922);
            CallChecker.varInit(this.C, "C", 763, 32372, 33922);
            CallChecker.varInit(this.diagD, "diagD", 763, 32372, 33922);
            CallChecker.varInit(this.BD, "BD", 763, 32372, 33922);
            CallChecker.varInit(this.D, "D", 763, 32372, 33922);
            CallChecker.varInit(this.B, "B", 763, 32372, 33922);
            CallChecker.varInit(this.normps, "normps", 763, 32372, 33922);
            CallChecker.varInit(this.ps, "ps", 763, 32372, 33922);
            CallChecker.varInit(this.pc, "pc", 763, 32372, 33922);
            CallChecker.varInit(this.xmean, "xmean", 763, 32372, 33922);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 763, 32372, 33922);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 763, 32372, 33922);
            CallChecker.varInit(this.chiN, "chiN", 763, 32372, 33922);
            CallChecker.varInit(this.ccovmu, "ccovmu", 763, 32372, 33922);
            CallChecker.varInit(this.ccov1, "ccov1", 763, 32372, 33922);
            CallChecker.varInit(this.damps, "damps", 763, 32372, 33922);
            CallChecker.varInit(this.cs, "cs", 763, 32372, 33922);
            CallChecker.varInit(this.cc, "cc", 763, 32372, 33922);
            CallChecker.varInit(this.sigma, "sigma", 763, 32372, 33922);
            CallChecker.varInit(this.mueff, "mueff", 763, 32372, 33922);
            CallChecker.varInit(this.weights, "weights", 763, 32372, 33922);
            CallChecker.varInit(this.logMu2, "logMu2", 763, 32372, 33922);
            CallChecker.varInit(this.mu, "mu", 763, 32372, 33922);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 763, 32372, 33922);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 763, 32372, 33922);
            CallChecker.varInit(this.stopTolX, "stopTolX", 763, 32372, 33922);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 763, 32372, 33922);
            CallChecker.varInit(this.stopFitness, "stopFitness", 763, 32372, 33922);
            CallChecker.varInit(this.maxIterations, "maxIterations", 763, 32372, 33922);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 763, 32372, 33922);
            CallChecker.varInit(this.isMinimize, "isMinimize", 763, 32372, 33922);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 763, 32372, 33922);
            CallChecker.varInit(this.dimension, "dimension", 763, 32372, 33922);
            CallChecker.varInit(this.inputSigma, "inputSigma", 763, 32372, 33922);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 763, 32372, 33922);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 763, 32372, 33922);
            CallChecker.varInit(this.lambda, "lambda", 763, 32372, 33922);
            if (((((ccov1) + (ccovmu)) + negccov) > 0) && ((((((iterations) % 1.0) / (((ccov1) + (ccovmu)) + negccov)) / (dimension)) / 10.0) < 1)) {
                final RealMatrix npe_invocation_var758 = CMAESOptimizer.triu(C, 1);
                if (CallChecker.beforeDeref(npe_invocation_var758, RealMatrix.class, 767, 32707, 32716)) {
                    final RealMatrix npe_invocation_var759 = CMAESOptimizer.triu(C, 0);
                    if (CallChecker.beforeDeref(npe_invocation_var759, RealMatrix.class, 767, 32692, 32701)) {
                        C = CallChecker.isCalled(npe_invocation_var759, RealMatrix.class, 767, 32692, 32701).add(CallChecker.isCalled(npe_invocation_var758, RealMatrix.class, 767, 32707, 32716).transpose());
                        CallChecker.varAssign(this.C, "this.C", 767, 32688, 32730);
                    }
                }
                final EigenDecomposition eig = CallChecker.varInit(new EigenDecomposition(C), "eig", 769, 32744, 32859);
                if (CallChecker.beforeDeref(eig, EigenDecomposition.class, 770, 32877, 32879)) {
                    B = CallChecker.isCalled(eig, EigenDecomposition.class, 770, 32877, 32879).getV();
                    CallChecker.varAssign(this.B, "this.B", 770, 32873, 32887);
                }
                if (CallChecker.beforeDeref(eig, EigenDecomposition.class, 771, 32956, 32958)) {
                    D = CallChecker.isCalled(eig, EigenDecomposition.class, 771, 32956, 32958).getD();
                    CallChecker.varAssign(this.D, "this.D", 771, 32952, 32966);
                }
                diagD = CMAESOptimizer.diag(D);
                CallChecker.varAssign(this.diagD, "this.diagD", 772, 32980, 32995);
                if ((CMAESOptimizer.min(diagD)) <= 0) {
                    for (int i = 0; i < (dimension); i++) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 775, 33110, 33114)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 775, 33110, 33114);
                            if ((CallChecker.isCalled(diagD, RealMatrix.class, 775, 33110, 33114).getEntry(i, 0)) < 0) {
                                if (CallChecker.beforeDeref(diagD, RealMatrix.class, 776, 33162, 33166)) {
                                    diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 776, 33162, 33166);
                                    CallChecker.isCalled(diagD, RealMatrix.class, 776, 33162, 33166).setEntry(i, 0, 0);
                                }
                            }
                        }
                    }
                    final double tfac = CallChecker.varInit(((double) ((CMAESOptimizer.max(this.diagD)) / 1.0E14)), "tfac", 779, 33243, 33280);
                    final RealMatrix npe_invocation_var760 = CMAESOptimizer.eye(dimension, dimension);
                    if (CallChecker.beforeDeref(npe_invocation_var760, RealMatrix.class, 780, 33308, 33332)) {
                        if (CallChecker.beforeDeref(C, RealMatrix.class, 780, 33302, 33302)) {
                            C = CallChecker.beforeCalled(C, RealMatrix.class, 780, 33302, 33302);
                            C = CallChecker.isCalled(C, RealMatrix.class, 780, 33302, 33302).add(CallChecker.isCalled(npe_invocation_var760, RealMatrix.class, 780, 33308, 33332).scalarMultiply(tfac));
                            CallChecker.varAssign(this.C, "this.C", 780, 33298, 33355);
                        }
                    }
                    final RealMatrix npe_invocation_var761 = CMAESOptimizer.ones(dimension, 1);
                    if (CallChecker.beforeDeref(npe_invocation_var761, RealMatrix.class, 781, 33391, 33408)) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 781, 33381, 33385)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 781, 33381, 33385);
                            diagD = CallChecker.isCalled(diagD, RealMatrix.class, 781, 33381, 33385).add(CallChecker.isCalled(npe_invocation_var761, RealMatrix.class, 781, 33391, 33408).scalarMultiply(tfac));
                            CallChecker.varAssign(this.diagD, "this.diagD", 781, 33373, 33431);
                        }
                    }
                }
                if ((CMAESOptimizer.max(diagD)) > (1.0E14 * (CMAESOptimizer.min(diagD)))) {
                    final double tfac = CallChecker.varInit(((double) (((CMAESOptimizer.max(this.diagD)) / 1.0E14) - (CMAESOptimizer.min(this.diagD)))), "tfac", 784, 33513, 33563);
                    final RealMatrix npe_invocation_var762 = CMAESOptimizer.eye(dimension, dimension);
                    if (CallChecker.beforeDeref(npe_invocation_var762, RealMatrix.class, 785, 33591, 33615)) {
                        if (CallChecker.beforeDeref(C, RealMatrix.class, 785, 33585, 33585)) {
                            C = CallChecker.beforeCalled(C, RealMatrix.class, 785, 33585, 33585);
                            C = CallChecker.isCalled(C, RealMatrix.class, 785, 33585, 33585).add(CallChecker.isCalled(npe_invocation_var762, RealMatrix.class, 785, 33591, 33615).scalarMultiply(tfac));
                            CallChecker.varAssign(this.C, "this.C", 785, 33581, 33638);
                        }
                    }
                    final RealMatrix npe_invocation_var763 = CMAESOptimizer.ones(dimension, 1);
                    if (CallChecker.beforeDeref(npe_invocation_var763, RealMatrix.class, 786, 33674, 33691)) {
                        if (CallChecker.beforeDeref(diagD, RealMatrix.class, 786, 33664, 33668)) {
                            diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 786, 33664, 33668);
                            diagD = CallChecker.isCalled(diagD, RealMatrix.class, 786, 33664, 33668).add(CallChecker.isCalled(npe_invocation_var763, RealMatrix.class, 786, 33674, 33691).scalarMultiply(tfac));
                            CallChecker.varAssign(this.diagD, "this.diagD", 786, 33656, 33714);
                        }
                    }
                }
                diagC = CMAESOptimizer.diag(C);
                CallChecker.varAssign(this.diagC, "this.diagC", 788, 33742, 33757);
                diagD = CMAESOptimizer.sqrt(diagD);
                CallChecker.varAssign(this.diagD, "this.diagD", 789, 33771, 33790);
                if (CallChecker.beforeDeref(diagD, RealMatrix.class, 790, 33863, 33867)) {
                    diagD = CallChecker.beforeCalled(diagD, RealMatrix.class, 790, 33863, 33867);
                    BD = CMAESOptimizer.times(B, CMAESOptimizer.repmat(CallChecker.isCalled(diagD, RealMatrix.class, 790, 33863, 33867).transpose(), dimension, 1));
                    CallChecker.varAssign(this.BD, "this.BD", 790, 33842, 33896);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2874.methodEnd();
        }
    }

    private static void push(double[] vals, double val) {
        MethodContext _bcornu_methode_context2875 = new MethodContext(void.class, 800, 33929, 34271);
        try {
            CallChecker.varInit(val, "val", 800, 33929, 34271);
            CallChecker.varInit(vals, "vals", 800, 33929, 34271);
            vals = CallChecker.beforeCalled(vals, double[].class, 801, 34172, 34175);
            for (int i = (CallChecker.isCalled(vals, double[].class, 801, 34172, 34175).length) - 1; i > 0; i--) {
                if (CallChecker.beforeDeref(vals, double[].class, 802, 34213, 34216)) {
                    if (CallChecker.beforeDeref(vals, double[].class, 802, 34223, 34226)) {
                        vals = CallChecker.beforeCalled(vals, double[].class, 802, 34213, 34216);
                        vals = CallChecker.beforeCalled(vals, double[].class, 802, 34223, 34226);
                        CallChecker.isCalled(vals, double[].class, 802, 34213, 34216)[i] = CallChecker.isCalled(vals, double[].class, 802, 34223, 34226)[(i - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(vals, double[].class, 802, 34213, 34216)[i], "CallChecker.isCalled(vals, double[].class, 802, 34213, 34216)[i]", 802, 34213, 34232);
                    }
                }
            }
            if (CallChecker.beforeDeref(vals, double[].class, 804, 34252, 34255)) {
                vals = CallChecker.beforeCalled(vals, double[].class, 804, 34252, 34255);
                CallChecker.isCalled(vals, double[].class, 804, 34252, 34255)[0] = val;
                CallChecker.varAssign(CallChecker.isCalled(vals, double[].class, 804, 34252, 34255)[0], "CallChecker.isCalled(vals, double[].class, 804, 34252, 34255)[0]", 804, 34252, 34265);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2875.methodEnd();
        }
    }

    private int[] sortedIndices(final double[] doubles) {
        MethodContext _bcornu_methode_context2876 = new MethodContext(int[].class, 813, 34278, 34890);
        try {
            CallChecker.varInit(this, "this", 813, 34278, 34890);
            CallChecker.varInit(doubles, "doubles", 813, 34278, 34890);
            CallChecker.varInit(this.iterations, "iterations", 813, 34278, 34890);
            CallChecker.varInit(this.evaluations, "evaluations", 813, 34278, 34890);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 813, 34278, 34890);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 813, 34278, 34890);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 813, 34278, 34890);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 813, 34278, 34890);
            CallChecker.varInit(this.random, "random", 813, 34278, 34890);
            CallChecker.varInit(this.historySize, "historySize", 813, 34278, 34890);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 813, 34278, 34890);
            CallChecker.varInit(this.iterations, "iterations", 813, 34278, 34890);
            CallChecker.varInit(this.diagC, "diagC", 813, 34278, 34890);
            CallChecker.varInit(this.C, "C", 813, 34278, 34890);
            CallChecker.varInit(this.diagD, "diagD", 813, 34278, 34890);
            CallChecker.varInit(this.BD, "BD", 813, 34278, 34890);
            CallChecker.varInit(this.D, "D", 813, 34278, 34890);
            CallChecker.varInit(this.B, "B", 813, 34278, 34890);
            CallChecker.varInit(this.normps, "normps", 813, 34278, 34890);
            CallChecker.varInit(this.ps, "ps", 813, 34278, 34890);
            CallChecker.varInit(this.pc, "pc", 813, 34278, 34890);
            CallChecker.varInit(this.xmean, "xmean", 813, 34278, 34890);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 813, 34278, 34890);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 813, 34278, 34890);
            CallChecker.varInit(this.chiN, "chiN", 813, 34278, 34890);
            CallChecker.varInit(this.ccovmu, "ccovmu", 813, 34278, 34890);
            CallChecker.varInit(this.ccov1, "ccov1", 813, 34278, 34890);
            CallChecker.varInit(this.damps, "damps", 813, 34278, 34890);
            CallChecker.varInit(this.cs, "cs", 813, 34278, 34890);
            CallChecker.varInit(this.cc, "cc", 813, 34278, 34890);
            CallChecker.varInit(this.sigma, "sigma", 813, 34278, 34890);
            CallChecker.varInit(this.mueff, "mueff", 813, 34278, 34890);
            CallChecker.varInit(this.weights, "weights", 813, 34278, 34890);
            CallChecker.varInit(this.logMu2, "logMu2", 813, 34278, 34890);
            CallChecker.varInit(this.mu, "mu", 813, 34278, 34890);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 813, 34278, 34890);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 813, 34278, 34890);
            CallChecker.varInit(this.stopTolX, "stopTolX", 813, 34278, 34890);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 813, 34278, 34890);
            CallChecker.varInit(this.stopFitness, "stopFitness", 813, 34278, 34890);
            CallChecker.varInit(this.maxIterations, "maxIterations", 813, 34278, 34890);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 813, 34278, 34890);
            CallChecker.varInit(this.isMinimize, "isMinimize", 813, 34278, 34890);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 813, 34278, 34890);
            CallChecker.varInit(this.dimension, "dimension", 813, 34278, 34890);
            CallChecker.varInit(this.inputSigma, "inputSigma", 813, 34278, 34890);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 813, 34278, 34890);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 813, 34278, 34890);
            CallChecker.varInit(this.lambda, "lambda", 813, 34278, 34890);
            final CMAESOptimizer.DoubleIndex[] dis = CallChecker.varInit(new CMAESOptimizer.DoubleIndex[CallChecker.isCalled(doubles, double[].class, 814, 34550, 34556).length], "dis", 814, 34508, 34565);
            for (int i = 0; i < (CallChecker.isCalled(doubles, double[].class, 815, 34595, 34601).length); i++) {
                if (CallChecker.beforeDeref(dis, CMAESOptimizer.DoubleIndex[].class, 816, 34630, 34632)) {
                    if (CallChecker.beforeDeref(doubles, double[].class, 816, 34655, 34661)) {
                        CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 816, 34630, 34632)[i] = new CMAESOptimizer.DoubleIndex(CallChecker.isCalled(doubles, double[].class, 816, 34655, 34661)[i], i);
                        CallChecker.varAssign(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 816, 34630, 34632)[i], "CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 816, 34630, 34632)[i]", 816, 34630, 34669);
                    }
                }
            }
            Arrays.sort(dis);
            final int[] indices = CallChecker.varInit(new int[CallChecker.isCalled(doubles, double[].class, 819, 34745, 34751).length], "indices", 819, 34715, 34760);
            for (int i = 0; i < (CallChecker.isCalled(doubles, double[].class, 820, 34790, 34796).length); i++) {
                if (CallChecker.beforeDeref(indices, int[].class, 821, 34825, 34831)) {
                    if (CallChecker.beforeDeref(dis, CMAESOptimizer.DoubleIndex[].class, 821, 34838, 34840)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 821, 34838, 34840)[i], CMAESOptimizer.DoubleIndex.class, 821, 34838, 34843)) {
                            CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 821, 34838, 34840)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 821, 34838, 34840)[i], CMAESOptimizer.DoubleIndex.class, 821, 34838, 34843);
                            CallChecker.isCalled(indices, int[].class, 821, 34825, 34831)[i] = CallChecker.isCalled(CallChecker.isCalled(dis, CMAESOptimizer.DoubleIndex[].class, 821, 34838, 34840)[i], CMAESOptimizer.DoubleIndex.class, 821, 34838, 34843).index;
                            CallChecker.varAssign(CallChecker.isCalled(indices, int[].class, 821, 34825, 34831)[i], "CallChecker.isCalled(indices, int[].class, 821, 34825, 34831)[i]", 821, 34825, 34850);
                        }
                    }
                }
            }
            return indices;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2876.methodEnd();
        }
    }

    private static RealMatrix log(final RealMatrix m) {
        MethodContext _bcornu_methode_context2877 = new MethodContext(RealMatrix.class, 978, 39510, 40098);
        try {
            CallChecker.varInit(m, "m", 978, 39510, 40098);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 979, 39800, 39800).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 979, 39821, 39821).getColumnDimension()], "d", 979, 39768, 39844);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 980, 39874, 39874).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 981, 39934, 39934).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 982, 39981, 39981)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r], double[].class, 982, 39981, 39984)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 982, 40000, 40000)) {
                                CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r], double[].class, 982, 39981, 39984);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r], double[].class, 982, 39981, 39984)[c] = Math.log(CallChecker.isCalled(m, RealMatrix.class, 982, 40000, 40000).getEntry(r, c));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r], double[].class, 982, 39981, 39984)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 982, 39981, 39981)[r], double[].class, 982, 39981, 39984)[c]", 982, 39981, 40017);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2877.methodEnd();
        }
    }

    private static RealMatrix sqrt(final RealMatrix m) {
        MethodContext _bcornu_methode_context2878 = new MethodContext(RealMatrix.class, 992, 40105, 40613);
        try {
            CallChecker.varInit(m, "m", 992, 40105, 40613);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 993, 40314, 40314).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 993, 40335, 40335).getColumnDimension()], "d", 993, 40282, 40358);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 994, 40388, 40388).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 995, 40448, 40448).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 996, 40495, 40495)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r], double[].class, 996, 40495, 40498)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 996, 40515, 40515)) {
                                CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r], double[].class, 996, 40495, 40498);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r], double[].class, 996, 40495, 40498)[c] = Math.sqrt(CallChecker.isCalled(m, RealMatrix.class, 996, 40515, 40515).getEntry(r, c));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r], double[].class, 996, 40495, 40498)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 996, 40495, 40495)[r], double[].class, 996, 40495, 40498)[c]", 996, 40495, 40532);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2878.methodEnd();
        }
    }

    private static RealMatrix square(final RealMatrix m) {
        MethodContext _bcornu_methode_context2879 = new MethodContext(RealMatrix.class, 1006, 40620, 41148);
        try {
            CallChecker.varInit(m, "m", 1006, 40620, 41148);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1007, 40826, 40826).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1007, 40847, 40847).getColumnDimension()], "d", 1007, 40794, 40870);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1008, 40900, 40900).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1009, 40960, 40960).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1010, 41018, 41018)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1010, 41018, 41018).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1010, 41018, 41018);
                    }
                    if (CallChecker.beforeDeref(d, double[][].class, 1011, 41052, 41052)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r], double[].class, 1011, 41052, 41055)) {
                            CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r], double[].class, 1011, 41052, 41055);
                            CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r], double[].class, 1011, 41052, 41055)[c] = e * e;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r], double[].class, 1011, 41052, 41055)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1011, 41052, 41052)[r], double[].class, 1011, 41052, 41055)[c]", 1011, 41052, 41067);
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2879.methodEnd();
        }
    }

    private static RealMatrix times(final RealMatrix m, final RealMatrix n) {
        MethodContext _bcornu_methode_context2880 = new MethodContext(RealMatrix.class, 1022, 41155, 41741);
        try {
            CallChecker.varInit(n, "n", 1022, 41155, 41741);
            CallChecker.varInit(m, "m", 1022, 41155, 41741);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1023, 41434, 41434).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1023, 41455, 41455).getColumnDimension()], "d", 1023, 41402, 41478);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1024, 41508, 41508).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1025, 41568, 41568).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1026, 41615, 41615)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r], double[].class, 1026, 41615, 41618)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1026, 41625, 41625)) {
                                if (CallChecker.beforeDeref(n, RealMatrix.class, 1026, 41644, 41644)) {
                                    CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r], double[].class, 1026, 41615, 41618);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r], double[].class, 1026, 41615, 41618)[c] = (CallChecker.isCalled(m, RealMatrix.class, 1026, 41625, 41625).getEntry(r, c)) * (CallChecker.isCalled(n, RealMatrix.class, 1026, 41644, 41644).getEntry(r, c));
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r], double[].class, 1026, 41615, 41618)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1026, 41615, 41615)[r], double[].class, 1026, 41615, 41618)[c]", 1026, 41615, 41660);
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
            _bcornu_methode_context2880.methodEnd();
        }
    }

    private static RealMatrix divide(final RealMatrix m, final RealMatrix n) {
        MethodContext _bcornu_methode_context2881 = new MethodContext(RealMatrix.class, 1037, 41748, 42328);
        try {
            CallChecker.varInit(n, "n", 1037, 41748, 42328);
            CallChecker.varInit(m, "m", 1037, 41748, 42328);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1038, 42021, 42021).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1038, 42042, 42042).getColumnDimension()], "d", 1038, 41989, 42065);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1039, 42095, 42095).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1040, 42155, 42155).getColumnDimension()); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1041, 42202, 42202)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r], double[].class, 1041, 42202, 42205)) {
                            if (CallChecker.beforeDeref(m, RealMatrix.class, 1041, 42212, 42212)) {
                                if (CallChecker.beforeDeref(n, RealMatrix.class, 1041, 42231, 42231)) {
                                    CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r], double[].class, 1041, 42202, 42205);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r], double[].class, 1041, 42202, 42205)[c] = (CallChecker.isCalled(m, RealMatrix.class, 1041, 42212, 42212).getEntry(r, c)) / (CallChecker.isCalled(n, RealMatrix.class, 1041, 42231, 42231).getEntry(r, c));
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r], double[].class, 1041, 42202, 42205)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1041, 42202, 42202)[r], double[].class, 1041, 42202, 42205)[c]", 1041, 42202, 42247);
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
            _bcornu_methode_context2881.methodEnd();
        }
    }

    private static RealMatrix selectColumns(final RealMatrix m, final int[] cols) {
        MethodContext _bcornu_methode_context2882 = new MethodContext(RealMatrix.class, 1052, 42335, 42868);
        try {
            CallChecker.varInit(cols, "cols", 1052, 42335, 42868);
            CallChecker.varInit(m, "m", 1052, 42335, 42868);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1053, 42596, 42596).getRowDimension()][CallChecker.isCalled(cols, int[].class, 1053, 42617, 42620).length], "d", 1053, 42564, 42629);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1054, 42659, 42659).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(cols, int[].class, 1055, 42719, 42722).length); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1056, 42755, 42755)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r], double[].class, 1056, 42755, 42758)) {
                            if (CallChecker.beforeDeref(cols, int[].class, 1056, 42779, 42782)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1056, 42765, 42765)) {
                                    CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r], double[].class, 1056, 42755, 42758);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r], double[].class, 1056, 42755, 42758)[c] = CallChecker.isCalled(m, RealMatrix.class, 1056, 42765, 42765).getEntry(r, CallChecker.isCalled(cols, int[].class, 1056, 42779, 42782)[c]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r], double[].class, 1056, 42755, 42758)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1056, 42755, 42755)[r], double[].class, 1056, 42755, 42758)[c]", 1056, 42755, 42787);
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
            _bcornu_methode_context2882.methodEnd();
        }
    }

    private static RealMatrix triu(final RealMatrix m, int k) {
        MethodContext _bcornu_methode_context2883 = new MethodContext(RealMatrix.class, 1067, 42875, 43409);
        try {
            CallChecker.varInit(k, "k", 1067, 42875, 43409);
            CallChecker.varInit(m, "m", 1067, 42875, 43409);
            final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1068, 43104, 43104).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1068, 43125, 43125).getColumnDimension()], "d", 1068, 43072, 43148);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1069, 43178, 43178).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1070, 43238, 43238).getColumnDimension()); c++) {
                    if (r <= (c - k)) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1071, 43285, 43285)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1071, 43308, 43308)) {
                                    CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c] = CallChecker.isCalled(m, RealMatrix.class, 1071, 43308, 43308).getEntry(r, c);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c]", 1071, 43285, 43328);
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(d, double[][].class, 1071, 43285, 43285)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)) {
                                CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1071, 43285, 43285)[r], double[].class, 1071, 43285, 43288)[c]", 1071, 43285, 43328);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2883.methodEnd();
        }
    }

    private static RealMatrix sumRows(final RealMatrix m) {
        MethodContext _bcornu_methode_context2884 = new MethodContext(RealMatrix.class, 1081, 43416, 43941);
        try {
            CallChecker.varInit(m, "m", 1081, 43416, 43941);
            final double[][] d = CallChecker.varInit(new double[1][CallChecker.isCalled(m, RealMatrix.class, 1082, 43622, 43622).getColumnDimension()], "d", 1082, 43587, 43645);
            for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1083, 43675, 43675).getColumnDimension()); c++) {
                double sum = CallChecker.varInit(((double) (0)), "sum", 1084, 43718, 43732);
                for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1085, 43766, 43766).getRowDimension()); r++) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1086, 43817, 43817)) {
                        sum += CallChecker.isCalled(m, RealMatrix.class, 1086, 43817, 43817).getEntry(r, c);
                        CallChecker.varAssign(sum, "sum", 1086, 43810, 43833);
                    }
                }
                if (CallChecker.beforeDeref(d, double[][].class, 1088, 43861, 43861)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0], double[].class, 1088, 43861, 43864)) {
                        CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0], double[].class, 1088, 43861, 43864);
                        CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0], double[].class, 1088, 43861, 43864)[c] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0], double[].class, 1088, 43861, 43864)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1088, 43861, 43861)[0], double[].class, 1088, 43861, 43864)[c]", 1088, 43861, 43874);
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2884.methodEnd();
        }
    }

    private static RealMatrix diag(final RealMatrix m) {
        MethodContext _bcornu_methode_context2885 = new MethodContext(RealMatrix.class, 1098, 43948, 44771);
        try {
            CallChecker.varInit(m, "m", 1098, 43948, 44771);
            if (CallChecker.beforeDeref(m, RealMatrix.class, 1099, 44204, 44204)) {
                if ((CallChecker.isCalled(m, RealMatrix.class, 1099, 44204, 44204).getColumnDimension()) == 1) {
                    final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1100, 44279, 44279).getRowDimension()][CallChecker.isCalled(m, RealMatrix.class, 1100, 44300, 44300).getRowDimension()], "d", 1100, 44247, 44320);
                    for (int i = 0; i < (CallChecker.isCalled(m, RealMatrix.class, 1101, 44354, 44354).getRowDimension()); i++) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1102, 44398, 44398)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i], double[].class, 1102, 44398, 44401)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1102, 44408, 44408)) {
                                    CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i], double[].class, 1102, 44398, 44401);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i], double[].class, 1102, 44398, 44401)[i] = CallChecker.isCalled(m, RealMatrix.class, 1102, 44408, 44408).getEntry(i, 0);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i], double[].class, 1102, 44398, 44401)[i], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1102, 44398, 44398)[i], double[].class, 1102, 44398, 44401)[i]", 1102, 44398, 44424);
                                }
                            }
                        }
                    }
                    return new Array2DRowRealMatrix(d, false);
                }else {
                    final double[][] d = CallChecker.varInit(new double[CallChecker.isCalled(m, RealMatrix.class, 1106, 44556, 44556).getRowDimension()][1], "d", 1106, 44524, 44579);
                    for (int i = 0; i < (CallChecker.isCalled(m, RealMatrix.class, 1107, 44613, 44613).getColumnDimension()); i++) {
                        if (CallChecker.beforeDeref(d, double[][].class, 1108, 44660, 44660)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i], double[].class, 1108, 44660, 44663)) {
                                if (CallChecker.beforeDeref(m, RealMatrix.class, 1108, 44670, 44670)) {
                                    CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i], double[].class, 1108, 44660, 44663);
                                    CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i], double[].class, 1108, 44660, 44663)[0] = CallChecker.isCalled(m, RealMatrix.class, 1108, 44670, 44670).getEntry(i, i);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i], double[].class, 1108, 44660, 44663)[0], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1108, 44660, 44660)[i], double[].class, 1108, 44660, 44663)[0]", 1108, 44660, 44686);
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
            _bcornu_methode_context2885.methodEnd();
        }
    }

    private static void copyColumn(final RealMatrix m1, int col1, RealMatrix m2, int col2) {
        MethodContext _bcornu_methode_context2886 = new MethodContext(void.class, 1122, 44778, 45222);
        try {
            CallChecker.varInit(col2, "col2", 1122, 44778, 45222);
            CallChecker.varInit(m2, "m2", 1122, 44778, 45222);
            CallChecker.varInit(col1, "col1", 1122, 44778, 45222);
            CallChecker.varInit(m1, "m1", 1122, 44778, 45222);
            for (int i = 0; i < (CallChecker.isCalled(m1, RealMatrix.class, 1124, 45123, 45124).getRowDimension()); i++) {
                if (CallChecker.beforeDeref(m1, RealMatrix.class, 1125, 45185, 45186)) {
                    if (CallChecker.beforeDeref(m2, RealMatrix.class, 1125, 45164, 45165)) {
                        m2 = CallChecker.beforeCalled(m2, RealMatrix.class, 1125, 45164, 45165);
                        CallChecker.isCalled(m2, RealMatrix.class, 1125, 45164, 45165).setEntry(i, col2, CallChecker.isCalled(m1, RealMatrix.class, 1125, 45185, 45186).getEntry(i, col1));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2886.methodEnd();
        }
    }

    private static RealMatrix ones(int n, int m) {
        MethodContext _bcornu_methode_context2887 = new MethodContext(RealMatrix.class, 1134, 45229, 45587);
        try {
            CallChecker.varInit(m, "m", 1134, 45229, 45587);
            CallChecker.varInit(n, "n", 1134, 45229, 45587);
            final double[][] d = CallChecker.varInit(new double[n][m], "d", 1135, 45411, 45448);
            for (int r = 0; r < n; r++) {
                if (CallChecker.beforeDeref(d, double[][].class, 1137, 45512, 45512)) {
                    Arrays.fill(CallChecker.isCalled(d, double[][].class, 1137, 45512, 45512)[r], 1);
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2887.methodEnd();
        }
    }

    private static RealMatrix eye(int n, int m) {
        MethodContext _bcornu_methode_context2888 = new MethodContext(RealMatrix.class, 1148, 45594, 46036);
        try {
            CallChecker.varInit(m, "m", 1148, 45594, 46036);
            CallChecker.varInit(n, "n", 1148, 45594, 46036);
            final double[][] d = CallChecker.varInit(new double[n][m], "d", 1149, 45826, 45863);
            for (int r = 0; r < n; r++) {
                if (r < m) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1152, 45944, 45944)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r], double[].class, 1152, 45944, 45947)) {
                            CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r], double[].class, 1152, 45944, 45947);
                            CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r], double[].class, 1152, 45944, 45947)[r] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r], double[].class, 1152, 45944, 45947)[r], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1152, 45944, 45944)[r], double[].class, 1152, 45944, 45947)[r]", 1152, 45944, 45955);
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2888.methodEnd();
        }
    }

    private static RealMatrix zeros(int n, int m) {
        MethodContext _bcornu_methode_context2889 = new MethodContext(RealMatrix.class, 1163, 46043, 46270);
        try {
            CallChecker.varInit(m, "m", 1163, 46043, 46270);
            CallChecker.varInit(n, "n", 1163, 46043, 46270);
            return new Array2DRowRealMatrix(n, m);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2889.methodEnd();
        }
    }

    private static RealMatrix repmat(final RealMatrix mat, int n, int m) {
        MethodContext _bcornu_methode_context2890 = new MethodContext(RealMatrix.class, 1173, 46277, 46938);
        try {
            CallChecker.varInit(m, "m", 1173, 46277, 46938);
            CallChecker.varInit(n, "n", 1173, 46277, 46938);
            CallChecker.varInit(mat, "mat", 1173, 46277, 46938);
            final int rd = CallChecker.varInit(((int) (CallChecker.isCalled(mat, RealMatrix.class, 1174, 46584, 46586).getRowDimension())), "rd", 1174, 46569, 46605);
            final int cd = CallChecker.varInit(((int) (CallChecker.isCalled(mat, RealMatrix.class, 1175, 46630, 46632).getColumnDimension())), "cd", 1175, 46615, 46654);
            final double[][] d = CallChecker.varInit(new double[n * rd][m * cd], "d", 1176, 46664, 46711);
            for (int r = 0; r < (n * rd); r++) {
                for (int c = 0; c < (m * cd); c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1179, 46819, 46819)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r], double[].class, 1179, 46819, 46822)) {
                            if (CallChecker.beforeDeref(mat, RealMatrix.class, 1179, 46829, 46831)) {
                                CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r], double[].class, 1179, 46819, 46822);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r], double[].class, 1179, 46819, 46822)[c] = CallChecker.isCalled(mat, RealMatrix.class, 1179, 46829, 46831).getEntry((r % rd), (c % cd));
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r], double[].class, 1179, 46819, 46822)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1179, 46819, 46819)[r], double[].class, 1179, 46819, 46822)[c]", 1179, 46819, 46857);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2890.methodEnd();
        }
    }

    private static RealMatrix sequence(double start, double end, double step) {
        MethodContext _bcornu_methode_context2891 = new MethodContext(RealMatrix.class, 1191, 46945, 47474);
        try {
            CallChecker.varInit(step, "step", 1191, 46945, 47474);
            CallChecker.varInit(end, "end", 1191, 46945, 47474);
            CallChecker.varInit(start, "start", 1191, 46945, 47474);
            final int size = CallChecker.varInit(((int) ((int) (((end - start) / step) + 1))), "size", 1192, 47181, 47230);
            final double[][] d = CallChecker.varInit(new double[size][1], "d", 1193, 47240, 47280);
            double value = CallChecker.varInit(((double) (start)), "value", 1194, 47290, 47310);
            for (int r = 0; r < size; r++) {
                if (CallChecker.beforeDeref(d, double[][].class, 1196, 47365, 47365)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r], double[].class, 1196, 47365, 47368)) {
                        CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r], double[].class, 1196, 47365, 47368);
                        CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r], double[].class, 1196, 47365, 47368)[0] = value;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r], double[].class, 1196, 47365, 47368)[0], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1196, 47365, 47365)[r], double[].class, 1196, 47365, 47368)[0]", 1196, 47365, 47380);
                    }
                }
                value += step;
                CallChecker.varAssign(value, "value", 1197, 47394, 47407);
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2891.methodEnd();
        }
    }

    private static double max(final RealMatrix m) {
        MethodContext _bcornu_methode_context2892 = new MethodContext(double.class, 1206, 47481, 47962);
        try {
            CallChecker.varInit(m, "m", 1206, 47481, 47962);
            double max = CallChecker.varInit(((double) (-(Double.MAX_VALUE))), "max", 1207, 47640, 47670);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1208, 47700, 47700).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1209, 47760, 47760).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1210, 47818, 47818)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1210, 47818, 47818).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1210, 47818, 47818);
                    }
                    if (max < e) {
                        max = e;
                        CallChecker.varAssign(max, "max", 1212, 47887, 47894);
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2892.methodEnd();
        }
    }

    private static double min(final RealMatrix m) {
        MethodContext _bcornu_methode_context2893 = new MethodContext(double.class, 1223, 47969, 48449);
        try {
            CallChecker.varInit(m, "m", 1223, 47969, 48449);
            double min = CallChecker.varInit(((double) (Double.MAX_VALUE)), "min", 1224, 48128, 48157);
            for (int r = 0; r < (CallChecker.isCalled(m, RealMatrix.class, 1225, 48187, 48187).getRowDimension()); r++) {
                for (int c = 0; c < (CallChecker.isCalled(m, RealMatrix.class, 1226, 48247, 48247).getColumnDimension()); c++) {
                    double e = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1227, 48305, 48305)) {
                        e = CallChecker.isCalled(m, RealMatrix.class, 1227, 48305, 48305).getEntry(r, c);
                        CallChecker.varAssign(e, "e", 1227, 48305, 48305);
                    }
                    if (min > e) {
                        min = e;
                        CallChecker.varAssign(min, "min", 1229, 48374, 48381);
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2893.methodEnd();
        }
    }

    private static double max(final double[] m) {
        MethodContext _bcornu_methode_context2894 = new MethodContext(double.class, 1240, 48456, 48786);
        try {
            CallChecker.varInit(m, "m", 1240, 48456, 48786);
            double max = CallChecker.varInit(((double) (-(Double.MAX_VALUE))), "max", 1241, 48603, 48633);
            for (int r = 0; r < (CallChecker.isCalled(m, double[].class, 1242, 48663, 48663).length); r++) {
                if (CallChecker.beforeDeref(m, double[].class, 1243, 48702, 48702)) {
                    if (max < (CallChecker.isCalled(m, double[].class, 1243, 48702, 48702)[r])) {
                        if (CallChecker.beforeDeref(m, double[].class, 1244, 48732, 48732)) {
                            max = CallChecker.isCalled(m, double[].class, 1244, 48732, 48732)[r];
                            CallChecker.varAssign(max, "max", 1244, 48726, 48736);
                        }
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2894.methodEnd();
        }
    }

    private static double min(final double[] m) {
        MethodContext _bcornu_methode_context2895 = new MethodContext(double.class, 1254, 48793, 49122);
        try {
            CallChecker.varInit(m, "m", 1254, 48793, 49122);
            double min = CallChecker.varInit(((double) (Double.MAX_VALUE)), "min", 1255, 48940, 48969);
            for (int r = 0; r < (CallChecker.isCalled(m, double[].class, 1256, 48999, 48999).length); r++) {
                if (CallChecker.beforeDeref(m, double[].class, 1257, 49038, 49038)) {
                    if (min > (CallChecker.isCalled(m, double[].class, 1257, 49038, 49038)[r])) {
                        if (CallChecker.beforeDeref(m, double[].class, 1258, 49068, 49068)) {
                            min = CallChecker.isCalled(m, double[].class, 1258, 49068, 49068)[r];
                            CallChecker.varAssign(min, "min", 1258, 49062, 49072);
                        }
                    }
                }
            }
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2895.methodEnd();
        }
    }

    private static int[] inverse(final int[] indices) {
        MethodContext _bcornu_methode_context2896 = new MethodContext(int[].class, 1268, 49129, 49481);
        try {
            CallChecker.varInit(indices, "indices", 1268, 49129, 49481);
            final int[] inverse = CallChecker.varInit(new int[CallChecker.isCalled(indices, int[].class, 1269, 49338, 49344).length], "inverse", 1269, 49308, 49353);
            for (int i = 0; i < (CallChecker.isCalled(indices, int[].class, 1270, 49383, 49389).length); i++) {
                if (CallChecker.beforeDeref(indices, int[].class, 1271, 49426, 49432)) {
                    if (CallChecker.beforeDeref(inverse, int[].class, 1271, 49418, 49424)) {
                        CallChecker.isCalled(inverse, int[].class, 1271, 49418, 49424)[CallChecker.isCalled(indices, int[].class, 1271, 49426, 49432)[i]] = i;
                        CallChecker.varAssign(CallChecker.isCalled(inverse, int[].class, 1271, 49418, 49424)[CallChecker.isCalled(indices, int[].class, 1271, 49426, 49432)[i]], "CallChecker.isCalled(inverse, int[].class, 1271, 49418, 49424)[CallChecker.isCalled(indices, int[].class, 1271, 49426, 49432)[i]]", 1271, 49418, 49441);
                    }
                }
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2896.methodEnd();
        }
    }

    private static int[] reverse(final int[] indices) {
        MethodContext _bcornu_methode_context2897 = new MethodContext(int[].class, 1280, 49488, 49860);
        try {
            CallChecker.varInit(indices, "indices", 1280, 49488, 49860);
            final int[] reverse = CallChecker.varInit(new int[CallChecker.isCalled(indices, int[].class, 1281, 49696, 49702).length], "reverse", 1281, 49666, 49711);
            for (int i = 0; i < (CallChecker.isCalled(indices, int[].class, 1282, 49741, 49747).length); i++) {
                if (CallChecker.beforeDeref(reverse, int[].class, 1283, 49776, 49782)) {
                    if (CallChecker.beforeDeref(indices, int[].class, 1283, 49797, 49803)) {
                        if (CallChecker.beforeDeref(indices, int[].class, 1283, 49789, 49795)) {
                            CallChecker.isCalled(reverse, int[].class, 1283, 49776, 49782)[i] = CallChecker.isCalled(indices, int[].class, 1283, 49789, 49795)[(((CallChecker.isCalled(indices, int[].class, 1283, 49797, 49803).length) - i) - 1)];
                            CallChecker.varAssign(CallChecker.isCalled(reverse, int[].class, 1283, 49776, 49782)[i], "CallChecker.isCalled(reverse, int[].class, 1283, 49776, 49782)[i]", 1283, 49776, 49820);
                        }
                    }
                }
            }
            return reverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2897.methodEnd();
        }
    }

    private double[] randn(int size) {
        MethodContext _bcornu_methode_context2898 = new MethodContext(double[].class, 1292, 49867, 50185);
        try {
            CallChecker.varInit(this, "this", 1292, 49867, 50185);
            CallChecker.varInit(size, "size", 1292, 49867, 50185);
            CallChecker.varInit(this.iterations, "iterations", 1292, 49867, 50185);
            CallChecker.varInit(this.evaluations, "evaluations", 1292, 49867, 50185);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 1292, 49867, 50185);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 1292, 49867, 50185);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 1292, 49867, 50185);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 1292, 49867, 50185);
            CallChecker.varInit(this.random, "random", 1292, 49867, 50185);
            CallChecker.varInit(this.historySize, "historySize", 1292, 49867, 50185);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 1292, 49867, 50185);
            CallChecker.varInit(this.iterations, "iterations", 1292, 49867, 50185);
            CallChecker.varInit(this.diagC, "diagC", 1292, 49867, 50185);
            CallChecker.varInit(this.C, "C", 1292, 49867, 50185);
            CallChecker.varInit(this.diagD, "diagD", 1292, 49867, 50185);
            CallChecker.varInit(this.BD, "BD", 1292, 49867, 50185);
            CallChecker.varInit(this.D, "D", 1292, 49867, 50185);
            CallChecker.varInit(this.B, "B", 1292, 49867, 50185);
            CallChecker.varInit(this.normps, "normps", 1292, 49867, 50185);
            CallChecker.varInit(this.ps, "ps", 1292, 49867, 50185);
            CallChecker.varInit(this.pc, "pc", 1292, 49867, 50185);
            CallChecker.varInit(this.xmean, "xmean", 1292, 49867, 50185);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 1292, 49867, 50185);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 1292, 49867, 50185);
            CallChecker.varInit(this.chiN, "chiN", 1292, 49867, 50185);
            CallChecker.varInit(this.ccovmu, "ccovmu", 1292, 49867, 50185);
            CallChecker.varInit(this.ccov1, "ccov1", 1292, 49867, 50185);
            CallChecker.varInit(this.damps, "damps", 1292, 49867, 50185);
            CallChecker.varInit(this.cs, "cs", 1292, 49867, 50185);
            CallChecker.varInit(this.cc, "cc", 1292, 49867, 50185);
            CallChecker.varInit(this.sigma, "sigma", 1292, 49867, 50185);
            CallChecker.varInit(this.mueff, "mueff", 1292, 49867, 50185);
            CallChecker.varInit(this.weights, "weights", 1292, 49867, 50185);
            CallChecker.varInit(this.logMu2, "logMu2", 1292, 49867, 50185);
            CallChecker.varInit(this.mu, "mu", 1292, 49867, 50185);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 1292, 49867, 50185);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 1292, 49867, 50185);
            CallChecker.varInit(this.stopTolX, "stopTolX", 1292, 49867, 50185);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 1292, 49867, 50185);
            CallChecker.varInit(this.stopFitness, "stopFitness", 1292, 49867, 50185);
            CallChecker.varInit(this.maxIterations, "maxIterations", 1292, 49867, 50185);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 1292, 49867, 50185);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1292, 49867, 50185);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 1292, 49867, 50185);
            CallChecker.varInit(this.dimension, "dimension", 1292, 49867, 50185);
            CallChecker.varInit(this.inputSigma, "inputSigma", 1292, 49867, 50185);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 1292, 49867, 50185);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 1292, 49867, 50185);
            CallChecker.varInit(this.lambda, "lambda", 1292, 49867, 50185);
            final double[] randn = CallChecker.varInit(new double[size], "randn", 1293, 50021, 50060);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(randn, double[].class, 1295, 50115, 50119)) {
                    if (CallChecker.beforeDeref(random, RandomGenerator.class, 1295, 50126, 50131)) {
                        CallChecker.isCalled(randn, double[].class, 1295, 50115, 50119)[i] = CallChecker.isCalled(random, RandomGenerator.class, 1295, 50126, 50131).nextGaussian();
                        CallChecker.varAssign(CallChecker.isCalled(randn, double[].class, 1295, 50115, 50119)[i], "CallChecker.isCalled(randn, double[].class, 1295, 50115, 50119)[i]", 1295, 50115, 50147);
                    }
                }
            }
            return randn;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2898.methodEnd();
        }
    }

    private RealMatrix randn1(int size, int popSize) {
        MethodContext _bcornu_methode_context2899 = new MethodContext(RealMatrix.class, 1305, 50192, 50672);
        try {
            CallChecker.varInit(this, "this", 1305, 50192, 50672);
            CallChecker.varInit(popSize, "popSize", 1305, 50192, 50672);
            CallChecker.varInit(size, "size", 1305, 50192, 50672);
            CallChecker.varInit(this.iterations, "iterations", 1305, 50192, 50672);
            CallChecker.varInit(this.evaluations, "evaluations", 1305, 50192, 50672);
            CallChecker.varInit(this.statisticsDHistory, "statisticsDHistory", 1305, 50192, 50672);
            CallChecker.varInit(this.statisticsFitnessHistory, "statisticsFitnessHistory", 1305, 50192, 50672);
            CallChecker.varInit(this.statisticsMeanHistory, "statisticsMeanHistory", 1305, 50192, 50672);
            CallChecker.varInit(this.statisticsSigmaHistory, "statisticsSigmaHistory", 1305, 50192, 50672);
            CallChecker.varInit(this.random, "random", 1305, 50192, 50672);
            CallChecker.varInit(this.historySize, "historySize", 1305, 50192, 50672);
            CallChecker.varInit(this.fitnessHistory, "fitnessHistory", 1305, 50192, 50672);
            CallChecker.varInit(this.iterations, "iterations", 1305, 50192, 50672);
            CallChecker.varInit(this.diagC, "diagC", 1305, 50192, 50672);
            CallChecker.varInit(this.C, "C", 1305, 50192, 50672);
            CallChecker.varInit(this.diagD, "diagD", 1305, 50192, 50672);
            CallChecker.varInit(this.BD, "BD", 1305, 50192, 50672);
            CallChecker.varInit(this.D, "D", 1305, 50192, 50672);
            CallChecker.varInit(this.B, "B", 1305, 50192, 50672);
            CallChecker.varInit(this.normps, "normps", 1305, 50192, 50672);
            CallChecker.varInit(this.ps, "ps", 1305, 50192, 50672);
            CallChecker.varInit(this.pc, "pc", 1305, 50192, 50672);
            CallChecker.varInit(this.xmean, "xmean", 1305, 50192, 50672);
            CallChecker.varInit(this.ccovmuSep, "ccovmuSep", 1305, 50192, 50672);
            CallChecker.varInit(this.ccov1Sep, "ccov1Sep", 1305, 50192, 50672);
            CallChecker.varInit(this.chiN, "chiN", 1305, 50192, 50672);
            CallChecker.varInit(this.ccovmu, "ccovmu", 1305, 50192, 50672);
            CallChecker.varInit(this.ccov1, "ccov1", 1305, 50192, 50672);
            CallChecker.varInit(this.damps, "damps", 1305, 50192, 50672);
            CallChecker.varInit(this.cs, "cs", 1305, 50192, 50672);
            CallChecker.varInit(this.cc, "cc", 1305, 50192, 50672);
            CallChecker.varInit(this.sigma, "sigma", 1305, 50192, 50672);
            CallChecker.varInit(this.mueff, "mueff", 1305, 50192, 50672);
            CallChecker.varInit(this.weights, "weights", 1305, 50192, 50672);
            CallChecker.varInit(this.logMu2, "logMu2", 1305, 50192, 50672);
            CallChecker.varInit(this.mu, "mu", 1305, 50192, 50672);
            CallChecker.varInit(this.stopTolHistFun, "stopTolHistFun", 1305, 50192, 50672);
            CallChecker.varInit(this.stopTolFun, "stopTolFun", 1305, 50192, 50672);
            CallChecker.varInit(this.stopTolX, "stopTolX", 1305, 50192, 50672);
            CallChecker.varInit(this.stopTolUpX, "stopTolUpX", 1305, 50192, 50672);
            CallChecker.varInit(this.stopFitness, "stopFitness", 1305, 50192, 50672);
            CallChecker.varInit(this.maxIterations, "maxIterations", 1305, 50192, 50672);
            CallChecker.varInit(this.generateStatistics, "generateStatistics", 1305, 50192, 50672);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1305, 50192, 50672);
            CallChecker.varInit(this.diagonalOnly, "diagonalOnly", 1305, 50192, 50672);
            CallChecker.varInit(this.dimension, "dimension", 1305, 50192, 50672);
            CallChecker.varInit(this.inputSigma, "inputSigma", 1305, 50192, 50672);
            CallChecker.varInit(this.checkFeasableCount, "checkFeasableCount", 1305, 50192, 50672);
            CallChecker.varInit(this.isActiveCMA, "isActiveCMA", 1305, 50192, 50672);
            CallChecker.varInit(this.lambda, "lambda", 1305, 50192, 50672);
            final double[][] d = CallChecker.varInit(new double[size][popSize], "d", 1306, 50407, 50453);
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < popSize; c++) {
                    if (CallChecker.beforeDeref(d, double[][].class, 1309, 50560, 50560)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r], double[].class, 1309, 50560, 50563)) {
                            if (CallChecker.beforeDeref(random, RandomGenerator.class, 1309, 50570, 50575)) {
                                CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r], double[].class, 1309, 50560, 50563);
                                CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r], double[].class, 1309, 50560, 50563)[c] = CallChecker.isCalled(random, RandomGenerator.class, 1309, 50570, 50575).nextGaussian();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r], double[].class, 1309, 50560, 50563)[c], "CallChecker.isCalled(CallChecker.isCalled(d, double[][].class, 1309, 50560, 50560)[r], double[].class, 1309, 50560, 50563)[c]", 1309, 50560, 50591);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2899.methodEnd();
        }
    }
}

