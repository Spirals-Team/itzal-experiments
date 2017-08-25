package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.util.FastMath;

public class HighamHall54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Higham-Hall 5(4)";

    private static final double[] STATIC_C = new double[]{ 2.0 / 9.0 , 1.0 / 3.0 , 1.0 / 2.0 , 3.0 / 5.0 , 1.0 , 1.0 };

    private static final double[][] STATIC_A = new double[][]{ new double[]{ 2.0 / 9.0 } , new double[]{ 1.0 / 12.0 , 1.0 / 4.0 } , new double[]{ 1.0 / 8.0 , 0.0 , 3.0 / 8.0 } , new double[]{ 91.0 / 500.0 , (-27.0) / 100.0 , 78.0 / 125.0 , 8.0 / 125.0 } , new double[]{ (-11.0) / 20.0 , 27.0 / 20.0 , 12.0 / 5.0 , (-36.0) / 5.0 , 5.0 } , new double[]{ 1.0 / 12.0 , 0.0 , 27.0 / 32.0 , (-4.0) / 3.0 , 125.0 / 96.0 , 5.0 / 48.0 } };

    private static final double[] STATIC_B = new double[]{ 1.0 / 12.0 , 0.0 , 27.0 / 32.0 , (-4.0) / 3.0 , 125.0 / 96.0 , 5.0 / 48.0 , 0.0 };

    private static final double[] STATIC_E = new double[]{ (-1.0) / 20.0 , 0.0 , 81.0 / 160.0 , (-6.0) / 5.0 , 25.0 / 32.0 , 1.0 / 16.0 , (-1.0) / 10.0 };

    public HighamHall54Integrator(final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(HighamHall54Integrator.METHOD_NAME, false, HighamHall54Integrator.STATIC_C, HighamHall54Integrator.STATIC_A, HighamHall54Integrator.STATIC_B, new HighamHall54StepInterpolator(), minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context1045 = new ConstructorContext(HighamHall54Integrator.class, 78, 2333, 3267);
        try {
        } finally {
            _bcornu_methode_context1045.methodEnd();
        }
    }

    public HighamHall54Integrator(final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(HighamHall54Integrator.METHOD_NAME, false, HighamHall54Integrator.STATIC_C, HighamHall54Integrator.STATIC_A, HighamHall54Integrator.STATIC_B, new HighamHall54StepInterpolator(), minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context1046 = new ConstructorContext(HighamHall54Integrator.class, 96, 3272, 4204);
        try {
        } finally {
            _bcornu_methode_context1046.methodEnd();
        }
    }

    @Override
    public int getOrder() {
        MethodContext _bcornu_methode_context4615 = new MethodContext(int.class, 105, 4209, 4284);
        try {
            CallChecker.varInit(this, "this", 105, 4209, 4284);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 105, 4209, 4284);
            CallChecker.varInit(this.isLastStep, "isLastStep", 105, 4209, 4284);
            CallChecker.varInit(this.stepSize, "stepSize", 105, 4209, 4284);
            CallChecker.varInit(this.stepStart, "stepStart", 105, 4209, 4284);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 105, 4209, 4284);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 105, 4209, 4284);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 105, 4209, 4284);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 105, 4209, 4284);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 105, 4209, 4284);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 105, 4209, 4284);
            CallChecker.varInit(STATIC_E, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_E", 105, 4209, 4284);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_B", 105, 4209, 4284);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_A", 105, 4209, 4284);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_C", 105, 4209, 4284);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.METHOD_NAME", 105, 4209, 4284);
            return 5;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4615.methodEnd();
        }
    }

    @Override
    protected double estimateError(final double[][] yDotK, final double[] y0, final double[] y1, final double h) {
        MethodContext _bcornu_methode_context4616 = new MethodContext(double.class, 111, 4289, 5179);
        try {
            CallChecker.varInit(this, "this", 111, 4289, 5179);
            CallChecker.varInit(h, "h", 111, 4289, 5179);
            CallChecker.varInit(y1, "y1", 111, 4289, 5179);
            CallChecker.varInit(y0, "y0", 111, 4289, 5179);
            CallChecker.varInit(yDotK, "yDotK", 111, 4289, 5179);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 111, 4289, 5179);
            CallChecker.varInit(this.isLastStep, "isLastStep", 111, 4289, 5179);
            CallChecker.varInit(this.stepSize, "stepSize", 111, 4289, 5179);
            CallChecker.varInit(this.stepStart, "stepStart", 111, 4289, 5179);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 111, 4289, 5179);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 111, 4289, 5179);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 111, 4289, 5179);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 111, 4289, 5179);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 111, 4289, 5179);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 111, 4289, 5179);
            CallChecker.varInit(STATIC_E, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_E", 111, 4289, 5179);
            CallChecker.varInit(STATIC_B, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_B", 111, 4289, 5179);
            CallChecker.varInit(STATIC_A, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_A", 111, 4289, 5179);
            CallChecker.varInit(STATIC_C, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.STATIC_C", 111, 4289, 5179);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.HighamHall54Integrator.METHOD_NAME", 111, 4289, 5179);
            double error = CallChecker.varInit(((double) (0)), "error", 115, 4506, 4522);
            for (int j = 0; j < (mainSetDimension); ++j) {
                double errSum = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(HighamHall54Integrator.STATIC_E, double[].class, 118, 4596, 4603)) {
                    if (CallChecker.beforeDeref(yDotK, double[][].class, 118, 4610, 4614)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 118, 4610, 4614)[0], double[].class, 118, 4610, 4617)) {
                            CallChecker.isCalled(yDotK, double[][].class, 118, 4610, 4614)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 118, 4610, 4614)[0], double[].class, 118, 4610, 4617);
                            errSum = (CallChecker.isCalled(HighamHall54Integrator.STATIC_E, double[].class, 118, 4596, 4603)[0]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 118, 4610, 4614)[0], double[].class, 118, 4610, 4617)[j]);
                            CallChecker.varAssign(errSum, "errSum", 118, 4596, 4603);
                        }
                    }
                }
                for (int l = 1; l < (CallChecker.isCalled(HighamHall54Integrator.STATIC_E, double[].class, 119, 4649, 4656).length); ++l) {
                    if (CallChecker.beforeDeref(HighamHall54Integrator.STATIC_E, double[].class, 120, 4691, 4698)) {
                        if (CallChecker.beforeDeref(yDotK, double[][].class, 120, 4705, 4709)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(yDotK, double[][].class, 120, 4705, 4709)[l], double[].class, 120, 4705, 4712)) {
                                CallChecker.isCalled(yDotK, double[][].class, 120, 4705, 4709)[l] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 120, 4705, 4709)[l], double[].class, 120, 4705, 4712);
                                errSum += (CallChecker.isCalled(HighamHall54Integrator.STATIC_E, double[].class, 120, 4691, 4698)[l]) * (CallChecker.isCalled(CallChecker.isCalled(yDotK, double[][].class, 120, 4705, 4709)[l], double[].class, 120, 4705, 4712)[j]);
                                CallChecker.varAssign(errSum, "errSum", 120, 4681, 4716);
                            }
                        }
                    }
                }
                final double yScale = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(y0, double[].class, 123, 4781, 4782)[j]), FastMath.abs(CallChecker.isCalled(y1, double[].class, 123, 4802, 4803)[j])))), "yScale", 123, 4733, 4809);
                double tol = CallChecker.init(double.class);
                if ((vecAbsoluteTolerance) == null) {
                    tol = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yScale);
                    CallChecker.varAssign(tol, "tol", 124, 4836, 5037);
                }else {
                    if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 126, 5005, 5024)) {
                        vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 126, 5005, 5024);
                        tol = (vecAbsoluteTolerance[j]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 126, 5005, 5024)[j]) * yScale);
                        CallChecker.varAssign(tol, "tol", 124, 4836, 5037);
                    }
                }
                final double ratio = CallChecker.varInit(((double) ((h * errSum) / tol)), "ratio", 127, 5046, 5084);
                error += ratio * ratio;
                CallChecker.varAssign(error, "error", 128, 5092, 5114);
            }
            return FastMath.sqrt((error / (mainSetDimension)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4616.methodEnd();
        }
    }
}

