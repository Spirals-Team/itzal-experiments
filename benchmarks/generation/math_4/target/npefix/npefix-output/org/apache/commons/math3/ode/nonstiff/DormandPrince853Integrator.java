package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.util.FastMath;

public class DormandPrince853Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Dormand-Prince 8 (5, 3)";

    private static final double[] STATIC_C = new double[]{ (12.0 - (2.0 * (FastMath.sqrt(6.0)))) / 135.0 , (6.0 - (FastMath.sqrt(6.0))) / 45.0 , (6.0 - (FastMath.sqrt(6.0))) / 30.0 , (6.0 + (FastMath.sqrt(6.0))) / 30.0 , 1.0 / 3.0 , 1.0 / 4.0 , 4.0 / 13.0 , 127.0 / 195.0 , 3.0 / 5.0 , 6.0 / 7.0 , 1.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ (12.0 - (2.0 * (FastMath.sqrt(6.0)))) / 135.0 } , new double[]{ (6.0 - (FastMath.sqrt(6.0))) / 180.0 , (6.0 - (FastMath.sqrt(6.0))) / 60.0 } , new double[]{ (6.0 - (FastMath.sqrt(6.0))) / 120.0 , 0.0 , (6.0 - (FastMath.sqrt(6.0))) / 40.0 } , new double[]{ (462.0 + (107.0 * (FastMath.sqrt(6.0)))) / 3000.0 , 0.0 , ((-402.0) - (197.0 * (FastMath.sqrt(6.0)))) / 1000.0 , (168.0 + (73.0 * (FastMath.sqrt(6.0)))) / 375.0 } , new double[]{ 1.0 / 27.0 , 0.0 , 0.0 , (16.0 + (FastMath.sqrt(6.0))) / 108.0 , (16.0 - (FastMath.sqrt(6.0))) / 108.0 } , new double[]{ 19.0 / 512.0 , 0.0 , 0.0 , (118.0 + (23.0 * (FastMath.sqrt(6.0)))) / 1024.0 , (118.0 - (23.0 * (FastMath.sqrt(6.0)))) / 1024.0 , (-9.0) / 512.0 } , new double[]{ 13772.0 / 371293.0 , 0.0 , 0.0 , (51544.0 + (4784.0 * (FastMath.sqrt(6.0)))) / 371293.0 , (51544.0 - (4784.0 * (FastMath.sqrt(6.0)))) / 371293.0 , (-5688.0) / 371293.0 , 3072.0 / 371293.0 } , new double[]{ 5.8656157643E10 / 9.3983540625E10 , 0.0 , 0.0 , ((-1.324889724104E12) - (3.18801444819E11 * (FastMath.sqrt(6.0)))) / 6.265569375E11 , ((-1.324889724104E12) + (3.18801444819E11 * (FastMath.sqrt(6.0)))) / 6.265569375E11 , 9.6044563816E10 / 3.480871875E9 , 5.682451879168E12 / 2.81950621875E11 , (-1.65125654E8) / 3796875.0 } , new double[]{ 8909899.0 / 1.8653125E7 , 0.0 , 0.0 , ((-4521408.0) - (1137963.0 * (FastMath.sqrt(6.0)))) / 2937500.0 , ((-4521408.0) + (1137963.0 * (FastMath.sqrt(6.0)))) / 2937500.0 , 9.6663078E7 / 4553125.0 , 2.107245056E9 / 1.37915625E8 , (-4.913652016E9) / 1.47609375E8 , (-7.889427E7) / 3.880452869E9 } , new double[]{ (-2.0401265806E10) / 2.1769653311E10 , 0.0 , 0.0 , (354216.0 + (94326.0 * (FastMath.sqrt(6.0)))) / 112847.0 , (354216.0 - (94326.0 * (FastMath.sqrt(6.0)))) / 112847.0 , (-4.3306765128E10) / 5.313852383E9 , (-2.0866708358144E13) / 1.126708119789E12 , 1.488600343802E13 / 6.54632330667E11 , 3.5290686222309376E16 / 1.4152473387134412E16 , (-1.477884375E9) / 4.85066827E8 } , new double[]{ 3.9815761E7 / 1.7514443E7 , 0.0 , 0.0 , ((-3457480.0) - (960905.0 * (FastMath.sqrt(6.0)))) / 551636.0 , ((-3457480.0) + (960905.0 * (FastMath.sqrt(6.0)))) / 551636.0 , (-8.44554132E8) / 4.7026969E7 , 8.444996352E9 / 3.02158619E8 , (-2.509602342E9) / 8.77790785E8 , (-2.8388795297996248E16) / 3.199510091356783E15 , 2.2671625E8 / 1.8341897E7 , 1.371316744E9 / 2.131383595E9 } , new double[]{ 104257.0 / 1920240.0 , 0.0 , 0.0 , 0.0 , 0.0 , 3399327.0 / 763840.0 , 6.6578432E7 / 3.5198415E7 , (-1.674902723E9) / 2.887164E8 , 5.4980371265625E13 / 1.76692375811392E14 , (-734375.0) / 4826304.0 , 1.71414593E8 / 8.512614E8 , 137909.0 / 3084480.0 } };

    private static final double[] STATIC_B = new double[]{ 104257.0 / 1920240.0 , 0.0 , 0.0 , 0.0 , 0.0 , 3399327.0 / 763840.0 , 6.6578432E7 / 3.5198415E7 , (-1.674902723E9) / 2.887164E8 , 5.4980371265625E13 / 1.76692375811392E14 , (-734375.0) / 4826304.0 , 1.71414593E8 / 8.512614E8 , 137909.0 / 3084480.0 , 0.0 };

    private static final double E1_01 = 1.16092271E8 / 8.84846592E9;

    private static final double E1_06 = (-1871647.0) / 1527680.0;

    private static final double E1_07 = (-6.9799717E7) / 1.4079366E8;

    private static final double E1_08 = 1.230164450203E12 / 7.39113984E11;

    private static final double E1_09 = (-1.980813971228885E15) / 5.654156025964544E15;

    private static final double E1_10 = 4.64500805E8 / 1.389975552E9;

    private static final double E1_11 = 1.606764981773E12 / 1.9613062656E13;

    private static final double E1_12 = (-137909.0) / 6168960.0;

    private static final double E2_01 = (-364463.0) / 1920240.0;

    private static final double E2_06 = 3399327.0 / 763840.0;

    private static final double E2_07 = 6.6578432E7 / 3.5198415E7;

    private static final double E2_08 = (-1.674902723E9) / 2.887164E8;

    private static final double E2_09 = (-7.4684743568175E13) / 1.76692375811392E14;

    private static final double E2_10 = (-734375.0) / 4826304.0;

    private static final double E2_11 = 1.71414593E8 / 8.512614E8;

    private static final double E2_12 = 69869.0 / 3084480.0;

    public DormandPrince853Integrator(final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(DormandPrince853Integrator.METHOD_NAME, true, DormandPrince853Integrator.STATIC_C, DormandPrince853Integrator.STATIC_A, DormandPrince853Integrator.STATIC_B, new DormandPrince853StepInterpolator(), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context405 = new ConstructorContext(DormandPrince853Integrator.class, 217, 8351, 9311);
        try {
        } finally {
            _bcornu_methode_context405.methodEnd();
        }
    }

    public DormandPrince853Integrator(final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(DormandPrince853Integrator.METHOD_NAME, true, DormandPrince853Integrator.STATIC_C, DormandPrince853Integrator.STATIC_A, DormandPrince853Integrator.STATIC_B, new DormandPrince853StepInterpolator(), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context406 = new ConstructorContext(DormandPrince853Integrator.class, 236, 9316, 10274);
        try {
        } finally {
            _bcornu_methode_context406.methodEnd();
        }
    }

    @Override
    public int getOrder() {
        MethodContext _bcornu_methode_context1763 = new MethodContext(int.class, 246, 10279, 10354);
        try {
            CallChecker.varInit(this, "this", 246, 10279, 10354);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 246, 10279, 10354);
            CallChecker.varInit(this.isLastStep, "isLastStep", 246, 10279, 10354);
            CallChecker.varInit(this.stepSize, "stepSize", 246, 10279, 10354);
            CallChecker.varInit(this.stepStart, "stepStart", 246, 10279, 10354);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 246, 10279, 10354);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 246, 10279, 10354);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 246, 10279, 10354);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 246, 10279, 10354);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 246, 10279, 10354);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 246, 10279, 10354);
            CallChecker.varInit(E2_12, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_12", 246, 10279, 10354);
            CallChecker.varInit(E2_11, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_11", 246, 10279, 10354);
            CallChecker.varInit(E2_10, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_10", 246, 10279, 10354);
            CallChecker.varInit(E2_09, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_09", 246, 10279, 10354);
            CallChecker.varInit(E2_08, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_08", 246, 10279, 10354);
            CallChecker.varInit(E2_07, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_07", 246, 10279, 10354);
            CallChecker.varInit(E2_06, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_06", 246, 10279, 10354);
            CallChecker.varInit(E2_01, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_01", 246, 10279, 10354);
            CallChecker.varInit(E1_12, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_12", 246, 10279, 10354);
            CallChecker.varInit(E1_11, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_11", 246, 10279, 10354);
            CallChecker.varInit(E1_10, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_10", 246, 10279, 10354);
            CallChecker.varInit(E1_09, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_09", 246, 10279, 10354);
            CallChecker.varInit(E1_08, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_08", 246, 10279, 10354);
            CallChecker.varInit(E1_07, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_07", 246, 10279, 10354);
            CallChecker.varInit(E1_06, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_06", 246, 10279, 10354);
            CallChecker.varInit(E1_01, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_01", 246, 10279, 10354);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_B", 246, 10279, 10354);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_A", 246, 10279, 10354);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_C", 246, 10279, 10354);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.METHOD_NAME", 246, 10279, 10354);
            return 8;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1763.methodEnd();
        }
    }

    @Override
    protected double estimateError(final double[][] yDotK, final double[] y0, final double[] y1, final double h) {
        MethodContext _bcornu_methode_context1764 = new MethodContext(double.class, 252, 10359, 11915);
        try {
            CallChecker.varInit(this, "this", 252, 10359, 11915);
            CallChecker.varInit(h, "h", 252, 10359, 11915);
            CallChecker.varInit(y1, "y1", 252, 10359, 11915);
            CallChecker.varInit(y0, "y0", 252, 10359, 11915);
            CallChecker.varInit(yDotK, "yDotK", 252, 10359, 11915);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 252, 10359, 11915);
            CallChecker.varInit(this.isLastStep, "isLastStep", 252, 10359, 11915);
            CallChecker.varInit(this.stepSize, "stepSize", 252, 10359, 11915);
            CallChecker.varInit(this.stepStart, "stepStart", 252, 10359, 11915);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 252, 10359, 11915);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 252, 10359, 11915);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 252, 10359, 11915);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 252, 10359, 11915);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 252, 10359, 11915);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 252, 10359, 11915);
            CallChecker.varInit(E2_12, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_12", 252, 10359, 11915);
            CallChecker.varInit(E2_11, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_11", 252, 10359, 11915);
            CallChecker.varInit(E2_10, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_10", 252, 10359, 11915);
            CallChecker.varInit(E2_09, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_09", 252, 10359, 11915);
            CallChecker.varInit(E2_08, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_08", 252, 10359, 11915);
            CallChecker.varInit(E2_07, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_07", 252, 10359, 11915);
            CallChecker.varInit(E2_06, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_06", 252, 10359, 11915);
            CallChecker.varInit(E2_01, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E2_01", 252, 10359, 11915);
            CallChecker.varInit(E1_12, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_12", 252, 10359, 11915);
            CallChecker.varInit(E1_11, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_11", 252, 10359, 11915);
            CallChecker.varInit(E1_10, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_10", 252, 10359, 11915);
            CallChecker.varInit(E1_09, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_09", 252, 10359, 11915);
            CallChecker.varInit(E1_08, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_08", 252, 10359, 11915);
            CallChecker.varInit(E1_07, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_07", 252, 10359, 11915);
            CallChecker.varInit(E1_06, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_06", 252, 10359, 11915);
            CallChecker.varInit(E1_01, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.E1_01", 252, 10359, 11915);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_B", 252, 10359, 11915);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_A", 252, 10359, 11915);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.STATIC_C", 252, 10359, 11915);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator.METHOD_NAME", 252, 10359, 11915);
            double error1 = CallChecker.varInit(((double) (0)), "error1", 255, 10575, 10592);
            double error2 = CallChecker.varInit(((double) (0)), "error2", 256, 10598, 10615);
            for (int j = 0; j < (mainSetDimension); ++j) {
                CallChecker.isCalled(yDotK, double[][].class, 259, 10704, 10708)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 259, 10704, 10708)[0], double[].class, 259, 10704, 10711);
                CallChecker.isCalled(yDotK, double[][].class, 259, 10727, 10731)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 259, 10727, 10731)[5], double[].class, 259, 10727, 10734);
                CallChecker.isCalled(yDotK, double[][].class, 260, 10778, 10782)[6] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 260, 10778, 10782)[6], double[].class, 260, 10778, 10785);
                CallChecker.isCalled(yDotK, double[][].class, 260, 10801, 10805)[7] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 260, 10801, 10805)[7], double[].class, 260, 10801, 10808);
                CallChecker.isCalled(yDotK, double[][].class, 261, 10852, 10856)[8] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 261, 10852, 10856)[8], double[].class, 261, 10852, 10859);
                CallChecker.isCalled(yDotK, double[][].class, 261, 10875, 10879)[9] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 261, 10875, 10879)[9], double[].class, 261, 10875, 10882);
                CallChecker.isCalled(yDotK, double[][].class, 262, 10926, 10930)[10] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 262, 10926, 10930)[10], double[].class, 262, 10926, 10934);
                CallChecker.isCalled(yDotK, double[][].class, 262, 10949, 10953)[11] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 262, 10949, 10953)[11], double[].class, 262, 10949, 10957);
                final double errSum1 = CallChecker.varInit(((double) (((((((((DormandPrince853Integrator.E1_01) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 259, 10704, 10708)[0], double[].class, 259, 10704, 10711)[j])) + ((DormandPrince853Integrator.E1_06) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 259, 10727, 10731)[5], double[].class, 259, 10727, 10734)[j]))) + ((DormandPrince853Integrator.E1_07) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 260, 10778, 10782)[6], double[].class, 260, 10778, 10785)[j]))) + ((DormandPrince853Integrator.E1_08) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 260, 10801, 10805)[7], double[].class, 260, 10801, 10808)[j]))) + ((DormandPrince853Integrator.E1_09) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 261, 10852, 10856)[8], double[].class, 261, 10852, 10859)[j]))) + ((DormandPrince853Integrator.E1_10) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 261, 10875, 10879)[9], double[].class, 261, 10875, 10882)[j]))) + ((DormandPrince853Integrator.E1_11) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 262, 10926, 10930)[10], double[].class, 262, 10926, 10934)[j]))) + ((DormandPrince853Integrator.E1_12) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 262, 10949, 10953)[11], double[].class, 262, 10949, 10957)[j])))), "errSum1", 259, 10673, 10961);
                CallChecker.isCalled(yDotK, double[][].class, 263, 11000, 11004)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 263, 11000, 11004)[0], double[].class, 263, 11000, 11007);
                CallChecker.isCalled(yDotK, double[][].class, 263, 11023, 11027)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 263, 11023, 11027)[5], double[].class, 263, 11023, 11030);
                CallChecker.isCalled(yDotK, double[][].class, 264, 11074, 11078)[6] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 264, 11074, 11078)[6], double[].class, 264, 11074, 11081);
                CallChecker.isCalled(yDotK, double[][].class, 264, 11097, 11101)[7] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 264, 11097, 11101)[7], double[].class, 264, 11097, 11104);
                CallChecker.isCalled(yDotK, double[][].class, 265, 11148, 11152)[8] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 265, 11148, 11152)[8], double[].class, 265, 11148, 11155);
                CallChecker.isCalled(yDotK, double[][].class, 265, 11171, 11175)[9] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 265, 11171, 11175)[9], double[].class, 265, 11171, 11178);
                CallChecker.isCalled(yDotK, double[][].class, 266, 11222, 11226)[10] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 266, 11222, 11226)[10], double[].class, 266, 11222, 11230);
                CallChecker.isCalled(yDotK, double[][].class, 266, 11245, 11249)[11] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 266, 11245, 11249)[11], double[].class, 266, 11245, 11253);
                final double errSum2 = CallChecker.varInit(((double) (((((((((DormandPrince853Integrator.E2_01) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 263, 11000, 11004)[0], double[].class, 263, 11000, 11007)[j])) + ((DormandPrince853Integrator.E2_06) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 263, 11023, 11027)[5], double[].class, 263, 11023, 11030)[j]))) + ((DormandPrince853Integrator.E2_07) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 264, 11074, 11078)[6], double[].class, 264, 11074, 11081)[j]))) + ((DormandPrince853Integrator.E2_08) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 264, 11097, 11101)[7], double[].class, 264, 11097, 11104)[j]))) + ((DormandPrince853Integrator.E2_09) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 265, 11148, 11152)[8], double[].class, 265, 11148, 11155)[j]))) + ((DormandPrince853Integrator.E2_10) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 265, 11171, 11175)[9], double[].class, 265, 11171, 11178)[j]))) + ((DormandPrince853Integrator.E2_11) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 266, 11222, 11226)[10], double[].class, 266, 11222, 11230)[j]))) + ((DormandPrince853Integrator.E2_12) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 266, 11245, 11249)[11], double[].class, 266, 11245, 11253)[j])))), "errSum2", 263, 10969, 11257);
                final double yScale = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(y0, double[].class, 268, 11314, 11315)[j]), FastMath.abs(CallChecker.isCalled(y1, double[].class, 268, 11335, 11336)[j])))), "yScale", 268, 11266, 11342);
                double tol = CallChecker.init(double.class);
                if ((vecAbsoluteTolerance) == null) {
                    tol = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yScale);
                    CallChecker.varAssign(tol, "tol", 269, 11369, 11570);
                }else {
                    if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 271, 11538, 11557)) {
                        vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 271, 11538, 11557);
                        tol = (vecAbsoluteTolerance[j]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 271, 11538, 11557)[j]) * yScale);
                        CallChecker.varAssign(tol, "tol", 269, 11369, 11570);
                    }
                }
                final double ratio1 = CallChecker.varInit(((double) (errSum1 / tol)), "ratio1", 272, 11579, 11615);
                error1 += ratio1 * ratio1;
                CallChecker.varAssign(error1, "error1", 273, 11623, 11655);
                final double ratio2 = CallChecker.varInit(((double) (errSum2 / tol)), "ratio2", 274, 11663, 11699);
                error2 += ratio2 * ratio2;
                CallChecker.varAssign(error2, "error2", 275, 11707, 11739);
            }
            double den = CallChecker.varInit(((double) (error1 + (0.01 * error2))), "den", 278, 11752, 11787);
            if (den <= 0.0) {
                den = 1.0;
                CallChecker.varAssign(den, "den", 280, 11817, 11826);
            }
            return ((FastMath.abs(h)) * error1) / (FastMath.sqrt(((mainSetDimension) * den)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1764.methodEnd();
        }
    }
}

