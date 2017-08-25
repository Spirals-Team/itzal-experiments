package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.fitting.PolynomialFitter;
import org.apache.commons.math3.optim.SimpleVectorValueChecker;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.GaussNewtonOptimizer;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

public class SmoothingPolynomialBicubicSplineInterpolator extends BicubicSplineInterpolator {
    private final PolynomialFitter xFitter;

    private final int xDegree;

    private final PolynomialFitter yFitter;

    private final int yDegree;

    public SmoothingPolynomialBicubicSplineInterpolator() {
        this(3);
        ConstructorContext _bcornu_methode_context1082 = new ConstructorContext(SmoothingPolynomialBicubicSplineInterpolator.class, 53, 2155, 2327);
        try {
        } finally {
            _bcornu_methode_context1082.methodEnd();
        }
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int degree) throws NotPositiveException {
        this(degree, degree);
        ConstructorContext _bcornu_methode_context1083 = new ConstructorContext(SmoothingPolynomialBicubicSplineInterpolator.class, 61, 2334, 2616);
        try {
        } finally {
            _bcornu_methode_context1083.methodEnd();
        }
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int xDegree, int yDegree) throws NotPositiveException {
        ConstructorContext _bcornu_methode_context1084 = new ConstructorContext(SmoothingPolynomialBicubicSplineInterpolator.class, 73, 2623, 3663);
        try {
            if (xDegree < 0) {
                throw new NotPositiveException(xDegree);
            }
            if (yDegree < 0) {
                throw new NotPositiveException(yDegree);
            }
            this.xDegree = xDegree;
            CallChecker.varAssign(this.xDegree, "this.xDegree", 81, 3200, 3222);
            this.yDegree = yDegree;
            CallChecker.varAssign(this.yDegree, "this.yDegree", 82, 3232, 3254);
            final double safeFactor = CallChecker.varInit(((double) (100.0)), "safeFactor", 84, 3265, 3294);
            final SimpleVectorValueChecker checker = CallChecker.varInit(new SimpleVectorValueChecker((safeFactor * (Precision.EPSILON)), (safeFactor * (Precision.SAFE_MIN))), "checker", 85, 3304, 3493);
            xFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, checker));
            CallChecker.varAssign(this.xFitter, "this.xFitter", 88, 3503, 3575);
            yFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, checker));
            CallChecker.varAssign(this.yFitter, "this.yFitter", 89, 3585, 3657);
        } finally {
            _bcornu_methode_context1084.methodEnd();
        }
    }

    @Override
    public BicubicSplineInterpolatingFunction interpolate(final double[] xval, final double[] yval, final double[][] fval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NullArgumentException {
        MethodContext _bcornu_methode_context4831 = new MethodContext(BicubicSplineInterpolatingFunction.class, 96, 3670, 6752);
        try {
            CallChecker.varInit(this, "this", 96, 3670, 6752);
            CallChecker.varInit(fval, "fval", 96, 3670, 6752);
            CallChecker.varInit(yval, "yval", 96, 3670, 6752);
            CallChecker.varInit(xval, "xval", 96, 3670, 6752);
            CallChecker.varInit(this.yDegree, "yDegree", 96, 3670, 6752);
            CallChecker.varInit(this.yFitter, "yFitter", 96, 3670, 6752);
            CallChecker.varInit(this.xDegree, "xDegree", 96, 3670, 6752);
            CallChecker.varInit(this.xFitter, "xFitter", 96, 3670, 6752);
            if (CallChecker.beforeDeref(xval, double[].class, 101, 4098, 4101)) {
                if (CallChecker.beforeDeref(yval, double[].class, 101, 4118, 4121)) {
                    if (CallChecker.beforeDeref(fval, double[][].class, 101, 4138, 4141)) {
                        if ((((CallChecker.isCalled(xval, double[].class, 101, 4098, 4101).length) == 0) || ((CallChecker.isCalled(yval, double[].class, 101, 4118, 4121).length) == 0)) || ((CallChecker.isCalled(fval, double[][].class, 101, 4138, 4141).length) == 0)) {
                            throw new NoDataException();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(xval, double[].class, 104, 4221, 4224)) {
                if (CallChecker.beforeDeref(fval, double[][].class, 104, 4236, 4239)) {
                    if ((CallChecker.isCalled(xval, double[].class, 104, 4221, 4224).length) != (CallChecker.isCalled(fval, double[][].class, 104, 4236, 4239).length)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 105, 4300, 4303)) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 105, 4313, 4316)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xval, double[].class, 105, 4300, 4303).length, CallChecker.isCalled(fval, double[][].class, 105, 4313, 4316).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final int xLen = CallChecker.varInit(((int) (CallChecker.isCalled(xval, double[].class, 108, 4363, 4366).length)), "xLen", 108, 4346, 4374);
            final int yLen = CallChecker.varInit(((int) (CallChecker.isCalled(yval, double[].class, 109, 4401, 4404).length)), "yLen", 109, 4384, 4412);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(fval, double[][].class, 112, 4472, 4475)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 112, 4472, 4475)[i], double[].class, 112, 4472, 4478)) {
                        CallChecker.isCalled(fval, double[][].class, 112, 4472, 4475)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 112, 4472, 4475)[i], double[].class, 112, 4472, 4478);
                        if ((CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 112, 4472, 4475)[i], double[].class, 112, 4472, 4478).length) != yLen) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 113, 4551, 4554)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 113, 4551, 4554)[i], double[].class, 113, 4551, 4557)) {
                                    CallChecker.isCalled(fval, double[][].class, 113, 4551, 4554)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 113, 4551, 4554)[i], double[].class, 113, 4551, 4557);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 113, 4551, 4554)[i], double[].class, 113, 4551, 4557).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            MathArrays.checkOrder(xval);
            MathArrays.checkOrder(yval);
            final PolynomialFunction[] yPolyX = CallChecker.varInit(new PolynomialFunction[yLen], "yPolyX", 122, 4816, 4880);
            for (int j = 0; j < yLen; j++) {
                if (CallChecker.beforeDeref(xFitter, PolynomialFitter.class, 124, 4935, 4941)) {
                    CallChecker.isCalled(xFitter, PolynomialFitter.class, 124, 4935, 4941).clearObservations();
                }
                for (int i = 0; i < xLen; i++) {
                    if (CallChecker.beforeDeref(xval, double[].class, 126, 5053, 5056)) {
                        if (CallChecker.beforeDeref(fval, double[][].class, 126, 5062, 5065)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 126, 5062, 5065)[i], double[].class, 126, 5062, 5068)) {
                                if (CallChecker.beforeDeref(xFitter, PolynomialFitter.class, 126, 5025, 5031)) {
                                    CallChecker.isCalled(fval, double[][].class, 126, 5062, 5065)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 126, 5062, 5065)[i], double[].class, 126, 5062, 5068);
                                    CallChecker.isCalled(xFitter, PolynomialFitter.class, 126, 5025, 5031).addObservedPoint(1, CallChecker.isCalled(xval, double[].class, 126, 5053, 5056)[i], CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 126, 5062, 5065)[i], double[].class, 126, 5062, 5068)[j]);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(yPolyX, PolynomialFunction[].class, 131, 5224, 5229)) {
                    if (CallChecker.beforeDeref(xFitter, PolynomialFitter.class, 131, 5259, 5265)) {
                        CallChecker.isCalled(yPolyX, PolynomialFunction[].class, 131, 5224, 5229)[j] = new PolynomialFunction(CallChecker.isCalled(xFitter, PolynomialFitter.class, 131, 5259, 5265).fit(new double[(xDegree) + 1]));
                        CallChecker.varAssign(CallChecker.isCalled(yPolyX, PolynomialFunction[].class, 131, 5224, 5229)[j], "CallChecker.isCalled(yPolyX, PolynomialFunction[].class, 131, 5224, 5229)[j]", 131, 5224, 5296);
                    }
                }
            }
            final double[][] fval_1 = CallChecker.varInit(new double[xLen][yLen], "fval_1", 136, 5420, 5468);
            for (int j = 0; j < yLen; j++) {
                final PolynomialFunction f = CallChecker.varInit(CallChecker.isCalled(yPolyX, PolynomialFunction[].class, 138, 5552, 5557)[j], "f", 138, 5523, 5561);
                for (int i = 0; i < xLen; i++) {
                    if (CallChecker.beforeDeref(fval_1, double[][].class, 140, 5624, 5629)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i], double[].class, 140, 5624, 5632)) {
                            if (CallChecker.beforeDeref(xval, double[].class, 140, 5647, 5650)) {
                                if (CallChecker.beforeDeref(f, PolynomialFunction.class, 140, 5639, 5639)) {
                                    CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i], double[].class, 140, 5624, 5632);
                                    CallChecker.isCalled(CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i], double[].class, 140, 5624, 5632)[j] = CallChecker.isCalled(f, PolynomialFunction.class, 140, 5639, 5639).value(CallChecker.isCalled(xval, double[].class, 140, 5647, 5650)[i]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i], double[].class, 140, 5624, 5632)[j], "CallChecker.isCalled(CallChecker.isCalled(fval_1, double[][].class, 140, 5624, 5629)[i], double[].class, 140, 5624, 5632)[j]", 140, 5624, 5655);
                                }
                            }
                        }
                    }
                }
            }
            final PolynomialFunction[] xPolyY = CallChecker.varInit(new PolynomialFunction[xLen], "xPolyY", 146, 5826, 5890);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(yFitter, PolynomialFitter.class, 148, 5945, 5951)) {
                    CallChecker.isCalled(yFitter, PolynomialFitter.class, 148, 5945, 5951).clearObservations();
                }
                for (int j = 0; j < yLen; j++) {
                    if (CallChecker.beforeDeref(yval, double[].class, 150, 6063, 6066)) {
                        if (CallChecker.beforeDeref(fval_1, double[][].class, 150, 6072, 6077)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fval_1, double[][].class, 150, 6072, 6077)[i], double[].class, 150, 6072, 6080)) {
                                if (CallChecker.beforeDeref(yFitter, PolynomialFitter.class, 150, 6035, 6041)) {
                                    CallChecker.isCalled(fval_1, double[][].class, 150, 6072, 6077)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval_1, double[][].class, 150, 6072, 6077)[i], double[].class, 150, 6072, 6080);
                                    CallChecker.isCalled(yFitter, PolynomialFitter.class, 150, 6035, 6041).addObservedPoint(1, CallChecker.isCalled(yval, double[].class, 150, 6063, 6066)[j], CallChecker.isCalled(CallChecker.isCalled(fval_1, double[][].class, 150, 6072, 6077)[i], double[].class, 150, 6072, 6080)[j]);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(xPolyY, PolynomialFunction[].class, 155, 6236, 6241)) {
                    if (CallChecker.beforeDeref(yFitter, PolynomialFitter.class, 155, 6271, 6277)) {
                        CallChecker.isCalled(xPolyY, PolynomialFunction[].class, 155, 6236, 6241)[i] = new PolynomialFunction(CallChecker.isCalled(yFitter, PolynomialFitter.class, 155, 6271, 6277).fit(new double[(yDegree) + 1]));
                        CallChecker.varAssign(CallChecker.isCalled(xPolyY, PolynomialFunction[].class, 155, 6236, 6241)[i], "CallChecker.isCalled(xPolyY, PolynomialFunction[].class, 155, 6236, 6241)[i]", 155, 6236, 6308);
                    }
                }
            }
            final double[][] fval_2 = CallChecker.varInit(new double[xLen][yLen], "fval_2", 160, 6432, 6480);
            for (int i = 0; i < xLen; i++) {
                final PolynomialFunction f = CallChecker.varInit(CallChecker.isCalled(xPolyY, PolynomialFunction[].class, 162, 6564, 6569)[i], "f", 162, 6535, 6573);
                for (int j = 0; j < yLen; j++) {
                    if (CallChecker.beforeDeref(fval_2, double[][].class, 164, 6636, 6641)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i], double[].class, 164, 6636, 6644)) {
                            if (CallChecker.beforeDeref(yval, double[].class, 164, 6659, 6662)) {
                                if (CallChecker.beforeDeref(f, PolynomialFunction.class, 164, 6651, 6651)) {
                                    CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i], double[].class, 164, 6636, 6644);
                                    CallChecker.isCalled(CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i], double[].class, 164, 6636, 6644)[j] = CallChecker.isCalled(f, PolynomialFunction.class, 164, 6651, 6651).value(CallChecker.isCalled(yval, double[].class, 164, 6659, 6662)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i], double[].class, 164, 6636, 6644)[j], "CallChecker.isCalled(CallChecker.isCalled(fval_2, double[][].class, 164, 6636, 6641)[i], double[].class, 164, 6636, 6644)[j]", 164, 6636, 6667);
                                }
                            }
                        }
                    }
                }
            }
            return super.interpolate(xval, yval, fval_2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BicubicSplineInterpolatingFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4831.methodEnd();
        }
    }
}

