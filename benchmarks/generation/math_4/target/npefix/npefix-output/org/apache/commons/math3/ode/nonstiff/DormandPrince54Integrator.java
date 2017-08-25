package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.util.FastMath;

public class DormandPrince54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";

    private static final double[] STATIC_C = new double[]{ 1.0 / 5.0 , 3.0 / 10.0 , 4.0 / 5.0 , 8.0 / 9.0 , 1.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 1.0 / 5.0 } , new double[]{ 3.0 / 40.0 , 9.0 / 40.0 } , new double[]{ 44.0 / 45.0 , (-56.0) / 15.0 , 32.0 / 9.0 } , new double[]{ 19372.0 / 6561.0 , (-25360.0) / 2187.0 , 64448.0 / 6561.0 , (-212.0) / 729.0 } , new double[]{ 9017.0 / 3168.0 , (-355.0) / 33.0 , 46732.0 / 5247.0 , 49.0 / 176.0 , (-5103.0) / 18656.0 } , new double[]{ 35.0 / 384.0 , 0.0 , 500.0 / 1113.0 , 125.0 / 192.0 , (-2187.0) / 6784.0 , 11.0 / 84.0 } };

    private static final double[] STATIC_B = new double[]{ 35.0 / 384.0 , 0.0 , 500.0 / 1113.0 , 125.0 / 192.0 , (-2187.0) / 6784.0 , 11.0 / 84.0 , 0.0 };

    private static final double E1 = 71.0 / 57600.0;

    private static final double E3 = (-71.0) / 16695.0;

    private static final double E4 = 71.0 / 1920.0;

    private static final double E5 = (-17253.0) / 339200.0;

    private static final double E6 = 22.0 / 525.0;

    private static final double E7 = (-1.0) / 40.0;

    public DormandPrince54Integrator(final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(DormandPrince54Integrator.METHOD_NAME, true, DormandPrince54Integrator.STATIC_C, DormandPrince54Integrator.STATIC_A, DormandPrince54Integrator.STATIC_B, new DormandPrince54StepInterpolator(), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context317 = new ConstructorContext(DormandPrince54Integrator.class, 105, 3385, 4329);
        try {
        } finally {
            _bcornu_methode_context317.methodEnd();
        }
    }

    public DormandPrince54Integrator(final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(DormandPrince54Integrator.METHOD_NAME, true, DormandPrince54Integrator.STATIC_C, DormandPrince54Integrator.STATIC_A, DormandPrince54Integrator.STATIC_B, new DormandPrince54StepInterpolator(), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context318 = new ConstructorContext(DormandPrince54Integrator.class, 123, 4334, 5276);
        try {
        } finally {
            _bcornu_methode_context318.methodEnd();
        }
    }

    @Override
    public int getOrder() {
        MethodContext _bcornu_methode_context1471 = new MethodContext(int.class, 132, 5281, 5356);
        try {
            CallChecker.varInit(this, "this", 132, 5281, 5356);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 132, 5281, 5356);
            CallChecker.varInit(this.isLastStep, "isLastStep", 132, 5281, 5356);
            CallChecker.varInit(this.stepSize, "stepSize", 132, 5281, 5356);
            CallChecker.varInit(this.stepStart, "stepStart", 132, 5281, 5356);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 132, 5281, 5356);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 132, 5281, 5356);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 132, 5281, 5356);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 132, 5281, 5356);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 132, 5281, 5356);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 132, 5281, 5356);
            CallChecker.varInit(E7, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E7", 132, 5281, 5356);
            CallChecker.varInit(E6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E6", 132, 5281, 5356);
            CallChecker.varInit(E5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E5", 132, 5281, 5356);
            CallChecker.varInit(E4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E4", 132, 5281, 5356);
            CallChecker.varInit(E3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E3", 132, 5281, 5356);
            CallChecker.varInit(E1, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E1", 132, 5281, 5356);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_B", 132, 5281, 5356);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_A", 132, 5281, 5356);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_C", 132, 5281, 5356);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.METHOD_NAME", 132, 5281, 5356);
            return 5;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1471.methodEnd();
        }
    }

    @Override
    protected double estimateError(final double[][] yDotK, final double[] y0, final double[] y1, final double h) {
        MethodContext _bcornu_methode_context1472 = new MethodContext(double.class, 138, 5361, 6321);
        try {
            CallChecker.varInit(this, "this", 138, 5361, 6321);
            CallChecker.varInit(h, "h", 138, 5361, 6321);
            CallChecker.varInit(y1, "y1", 138, 5361, 6321);
            CallChecker.varInit(y0, "y0", 138, 5361, 6321);
            CallChecker.varInit(yDotK, "yDotK", 138, 5361, 6321);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 138, 5361, 6321);
            CallChecker.varInit(this.isLastStep, "isLastStep", 138, 5361, 6321);
            CallChecker.varInit(this.stepSize, "stepSize", 138, 5361, 6321);
            CallChecker.varInit(this.stepStart, "stepStart", 138, 5361, 6321);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 138, 5361, 6321);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 138, 5361, 6321);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 138, 5361, 6321);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 138, 5361, 6321);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 138, 5361, 6321);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 138, 5361, 6321);
            CallChecker.varInit(E7, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E7", 138, 5361, 6321);
            CallChecker.varInit(E6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E6", 138, 5361, 6321);
            CallChecker.varInit(E5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E5", 138, 5361, 6321);
            CallChecker.varInit(E4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E4", 138, 5361, 6321);
            CallChecker.varInit(E3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E3", 138, 5361, 6321);
            CallChecker.varInit(E1, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.E1", 138, 5361, 6321);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_B", 138, 5361, 6321);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_A", 138, 5361, 6321);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.STATIC_C", 138, 5361, 6321);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.DormandPrince54Integrator.METHOD_NAME", 138, 5361, 6321);
            double error = CallChecker.varInit(((double) (0)), "error", 142, 5578, 5594);
            for (int j = 0; j < (mainSetDimension); ++j) {
                CallChecker.isCalled(yDotK, double[][].class, 145, 5681, 5685)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 145, 5681, 5685)[0], double[].class, 145, 5681, 5688);
                CallChecker.isCalled(yDotK, double[][].class, 145, 5701, 5705)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 145, 5701, 5705)[2], double[].class, 145, 5701, 5708);
                CallChecker.isCalled(yDotK, double[][].class, 146, 5750, 5754)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 146, 5750, 5754)[3], double[].class, 146, 5750, 5757);
                CallChecker.isCalled(yDotK, double[][].class, 146, 5770, 5774)[4] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 146, 5770, 5774)[4], double[].class, 146, 5770, 5777);
                CallChecker.isCalled(yDotK, double[][].class, 147, 5819, 5823)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 147, 5819, 5823)[5], double[].class, 147, 5819, 5826);
                CallChecker.isCalled(yDotK, double[][].class, 147, 5839, 5843)[6] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 147, 5839, 5843)[6], double[].class, 147, 5839, 5846);
                final double errSum = CallChecker.varInit(((double) (((((((DormandPrince54Integrator.E1) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 145, 5681, 5685)[0], double[].class, 145, 5681, 5688)[j])) + ((DormandPrince54Integrator.E3) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 145, 5701, 5705)[2], double[].class, 145, 5701, 5708)[j]))) + ((DormandPrince54Integrator.E4) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 146, 5750, 5754)[3], double[].class, 146, 5750, 5757)[j]))) + ((DormandPrince54Integrator.E5) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 146, 5770, 5774)[4], double[].class, 146, 5770, 5777)[j]))) + ((DormandPrince54Integrator.E6) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 147, 5819, 5823)[5], double[].class, 147, 5819, 5826)[j]))) + ((DormandPrince54Integrator.E7) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 147, 5839, 5843)[6], double[].class, 147, 5839, 5846)[j])))), "errSum", 145, 5654, 5850);
                final double yScale = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(y0, double[].class, 149, 5909, 5910)[j]), FastMath.abs(CallChecker.isCalled(y1, double[].class, 149, 5930, 5931)[j])))), "yScale", 149, 5861, 5937);
                double tol = CallChecker.init(double.class);
                if ((vecAbsoluteTolerance) == null) {
                    tol = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yScale);
                    CallChecker.varAssign(tol, "tol", 150, 5966, 6175);
                }else {
                    if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 152, 6143, 6162)) {
                        vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 152, 6143, 6162);
                        tol = (vecAbsoluteTolerance[j]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 152, 6143, 6162)[j]) * yScale);
                        CallChecker.varAssign(tol, "tol", 150, 5966, 6175);
                    }
                }
                final double ratio = CallChecker.varInit(((double) ((h * errSum) / tol)), "ratio", 153, 6186, 6224);
                error += ratio * ratio;
                CallChecker.varAssign(error, "error", 154, 6234, 6256);
            }
            return FastMath.sqrt((error / (mainSetDimension)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1472.methodEnd();
        }
    }
}

