package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.TrivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

class TricubicSplineFunction implements TrivariateFunction {
    private static final short N = 4;

    private final double[][][] a = new double[TricubicSplineFunction.N][TricubicSplineFunction.N][TricubicSplineFunction.N];

    public TricubicSplineFunction(double[] aV) {
        ConstructorContext _bcornu_methode_context854 = new ConstructorContext(TricubicSplineFunction.class, 429, 24128, 24465);
        try {
            for (int i = 0; i < (TricubicSplineFunction.N); i++) {
                for (int j = 0; j < (TricubicSplineFunction.N); j++) {
                    for (int k = 0; k < (TricubicSplineFunction.N); k++) {
                        if (CallChecker.beforeDeref(a, double[][][].class, 433, 24381, 24381)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)) {
                                CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j], double[].class, 433, 24381, 24387)) {
                                    if (CallChecker.beforeDeref(aV, double[].class, 433, 24394, 24395)) {
                                        CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384);
                                        CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j], double[].class, 433, 24381, 24387);
                                        aV = CallChecker.beforeCalled(aV, double[].class, 433, 24394, 24395);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j], double[].class, 433, 24381, 24387)[k] = CallChecker.isCalled(aV, double[].class, 433, 24394, 24395)[(i + ((TricubicSplineFunction.N) * (j + ((TricubicSplineFunction.N) * k))))];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j], double[].class, 433, 24381, 24387)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.a, double[][][].class, 433, 24381, 24381)[i], double[][].class, 433, 24381, 24384)[j], double[].class, 433, 24381, 24387)[k]", 433, 24381, 24417);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context854.methodEnd();
        }
    }

    public double value(double x, double y, double z) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3732 = new MethodContext(double.class, 447, 24472, 25812);
        try {
            CallChecker.varInit(this, "this", 447, 24472, 25812);
            CallChecker.varInit(z, "z", 447, 24472, 25812);
            CallChecker.varInit(y, "y", 447, 24472, 25812);
            CallChecker.varInit(x, "x", 447, 24472, 25812);
            CallChecker.varInit(this.a, "a", 447, 24472, 25812);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.TricubicSplineFunction.N", 447, 24472, 25812);
            if ((x < 0) || (x > 1)) {
                throw new OutOfRangeException(x, 0, 1);
            }
            if ((y < 0) || (y > 1)) {
                throw new OutOfRangeException(y, 0, 1);
            }
            if ((z < 0) || (z > 1)) {
                throw new OutOfRangeException(z, 0, 1);
            }
            final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 459, 25189, 25212);
            final double x3 = CallChecker.varInit(((double) (x2 * x)), "x3", 460, 25222, 25246);
            final double[] pX = CallChecker.varInit(new double[]{ 1 , x , x2 , x3 }, "pX", 461, 25256, 25292);
            final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 463, 25303, 25326);
            final double y3 = CallChecker.varInit(((double) (y2 * y)), "y3", 464, 25336, 25360);
            final double[] pY = CallChecker.varInit(new double[]{ 1 , y , y2 , y3 }, "pY", 465, 25370, 25406);
            final double z2 = CallChecker.varInit(((double) (z * z)), "z2", 467, 25417, 25440);
            final double z3 = CallChecker.varInit(((double) (z2 * z)), "z3", 468, 25450, 25474);
            final double[] pZ = CallChecker.varInit(new double[]{ 1 , z , z2 , z3 }, "pZ", 469, 25484, 25520);
            double result = CallChecker.varInit(((double) (0)), "result", 471, 25531, 25548);
            for (int i = 0; i < (TricubicSplineFunction.N); i++) {
                for (int j = 0; j < (TricubicSplineFunction.N); j++) {
                    for (int k = 0; k < (TricubicSplineFunction.N); k++) {
                        if (CallChecker.beforeDeref(a, double[][][].class, 475, 25706, 25706)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709)) {
                                CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709)[j], double[].class, 475, 25706, 25712)) {
                                    if (CallChecker.beforeDeref(pX, double[].class, 475, 25719, 25720)) {
                                        if (CallChecker.beforeDeref(pY, double[].class, 475, 25727, 25728)) {
                                            if (CallChecker.beforeDeref(pZ, double[].class, 475, 25735, 25736)) {
                                                CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709);
                                                CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709)[j], double[].class, 475, 25706, 25712);
                                                result += (((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(a, double[][][].class, 475, 25706, 25706)[i], double[][].class, 475, 25706, 25709)[j], double[].class, 475, 25706, 25712)[k]) * (CallChecker.isCalled(pX, double[].class, 475, 25719, 25720)[i])) * (CallChecker.isCalled(pY, double[].class, 475, 25727, 25728)[j])) * (CallChecker.isCalled(pZ, double[].class, 475, 25735, 25736)[k]);
                                                CallChecker.varAssign(result, "result", 475, 25696, 25740);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3732.methodEnd();
        }
    }
}

