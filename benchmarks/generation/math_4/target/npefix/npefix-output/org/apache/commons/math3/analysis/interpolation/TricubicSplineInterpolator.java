package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

public class TricubicSplineInterpolator implements TrivariateGridInterpolator {
    public TricubicSplineInterpolatingFunction interpolate(final double[] xval, final double[] yval, final double[] zval, final double[][][] fval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context4408 = new MethodContext(TricubicSplineInterpolatingFunction.class, 36, 1360, 7654);
        try {
            CallChecker.varInit(this, "this", 36, 1360, 7654);
            CallChecker.varInit(fval, "fval", 36, 1360, 7654);
            CallChecker.varInit(zval, "zval", 36, 1360, 7654);
            CallChecker.varInit(yval, "yval", 36, 1360, 7654);
            CallChecker.varInit(xval, "xval", 36, 1360, 7654);
            if (CallChecker.beforeDeref(xval, double[].class, 42, 1863, 1866)) {
                if (CallChecker.beforeDeref(yval, double[].class, 42, 1883, 1886)) {
                    if (CallChecker.beforeDeref(zval, double[].class, 42, 1903, 1906)) {
                        if (CallChecker.beforeDeref(fval, double[][][].class, 42, 1923, 1926)) {
                            if (((((CallChecker.isCalled(xval, double[].class, 42, 1863, 1866).length) == 0) || ((CallChecker.isCalled(yval, double[].class, 42, 1883, 1886).length) == 0)) || ((CallChecker.isCalled(zval, double[].class, 42, 1903, 1906).length) == 0)) || ((CallChecker.isCalled(fval, double[][][].class, 42, 1923, 1926).length) == 0)) {
                                throw new NoDataException();
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(xval, double[].class, 45, 2006, 2009)) {
                if (CallChecker.beforeDeref(fval, double[][][].class, 45, 2021, 2024)) {
                    if ((CallChecker.isCalled(xval, double[].class, 45, 2006, 2009).length) != (CallChecker.isCalled(fval, double[][][].class, 45, 2021, 2024).length)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 46, 2085, 2088)) {
                            if (CallChecker.beforeDeref(fval, double[][][].class, 46, 2098, 2101)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xval, double[].class, 46, 2085, 2088).length, CallChecker.isCalled(fval, double[][][].class, 46, 2098, 2101).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            MathArrays.checkOrder(xval);
            MathArrays.checkOrder(yval);
            MathArrays.checkOrder(zval);
            final int xLen = CallChecker.varInit(((int) (CallChecker.isCalled(xval, double[].class, 53, 2260, 2263).length)), "xLen", 53, 2243, 2271);
            final int yLen = CallChecker.varInit(((int) (CallChecker.isCalled(yval, double[].class, 54, 2298, 2301).length)), "yLen", 54, 2281, 2309);
            final int zLen = CallChecker.varInit(((int) (CallChecker.isCalled(zval, double[].class, 55, 2336, 2339).length)), "zLen", 55, 2319, 2347);
            final double[][][] fvalXY = CallChecker.varInit(new double[zLen][xLen][yLen], "fvalXY", 60, 2540, 2596);
            final double[][][] fvalZX = CallChecker.varInit(new double[yLen][zLen][xLen], "fvalZX", 61, 2606, 2662);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(fval, double[][][].class, 63, 2721, 2724)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 63, 2721, 2724)[i], double[][].class, 63, 2721, 2727)) {
                        CallChecker.isCalled(fval, double[][][].class, 63, 2721, 2724)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 63, 2721, 2724)[i], double[][].class, 63, 2721, 2727);
                        if ((CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 63, 2721, 2724)[i], double[][].class, 63, 2721, 2727).length) != yLen) {
                            if (CallChecker.beforeDeref(fval, double[][][].class, 64, 2800, 2803)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 64, 2800, 2803)[i], double[][].class, 64, 2800, 2806)) {
                                    CallChecker.isCalled(fval, double[][][].class, 64, 2800, 2803)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 64, 2800, 2803)[i], double[][].class, 64, 2800, 2806);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 64, 2800, 2803)[i], double[][].class, 64, 2800, 2806).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                for (int j = 0; j < yLen; j++) {
                    if (CallChecker.beforeDeref(fval, double[][][].class, 68, 2903, 2906)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909)) {
                            CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909)[j], double[].class, 68, 2903, 2912)) {
                                CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909);
                                CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909)[j], double[].class, 68, 2903, 2912);
                                if ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 68, 2903, 2906)[i], double[][].class, 68, 2903, 2909)[j], double[].class, 68, 2903, 2912).length) != zLen) {
                                    if (CallChecker.beforeDeref(fval, double[][][].class, 69, 2989, 2992)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995)) {
                                            CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995)[j], double[].class, 69, 2989, 2998)) {
                                                CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995);
                                                CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995)[j], double[].class, 69, 2989, 2998);
                                                throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 69, 2989, 2992)[i], double[][].class, 69, 2989, 2995)[j], double[].class, 69, 2989, 2998).length, zLen);
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
                    
                    for (int k = 0; k < zLen; k++) {
                        CallChecker.isCalled(fval, double[][][].class, 73, 3120, 3123)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 73, 3120, 3123)[i], double[][].class, 73, 3120, 3126);
                        CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 73, 3120, 3123)[i], double[][].class, 73, 3120, 3126)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 73, 3120, 3123)[i], double[][].class, 73, 3120, 3126)[j], double[].class, 73, 3120, 3129);
                        final double v = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 73, 3120, 3123)[i], double[][].class, 73, 3120, 3126)[j], double[].class, 73, 3120, 3129)[k])), "v", 73, 3103, 3133);
                        if (CallChecker.beforeDeref(fvalXY, double[][][].class, 74, 3155, 3160)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)) {
                                CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k] = CallChecker.beforeCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i], double[].class, 74, 3155, 3166)) {
                                    CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k] = CallChecker.beforeCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163);
                                    CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i], double[].class, 74, 3155, 3166);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i], double[].class, 74, 3155, 3166)[j] = v;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i], double[].class, 74, 3155, 3166)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalXY, double[][][].class, 74, 3155, 3160)[k], double[][].class, 74, 3155, 3163)[i], double[].class, 74, 3155, 3166)[j]", 74, 3155, 3174);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(fvalZX, double[][][].class, 75, 3196, 3201)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)) {
                                CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k], double[].class, 75, 3196, 3207)) {
                                    CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204);
                                    CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k], double[].class, 75, 3196, 3207);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k], double[].class, 75, 3196, 3207)[i] = v;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k], double[].class, 75, 3196, 3207)[i], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fvalZX, double[][][].class, 75, 3196, 3201)[j], double[][].class, 75, 3196, 3204)[k], double[].class, 75, 3196, 3207)[i]", 75, 3196, 3215);
                                }
                            }
                        }
                    }
                }
            }
            final BicubicSplineInterpolator bsi = CallChecker.varInit(new BicubicSplineInterpolator(), "bsi", 80, 3268, 3337);
            final BicubicSplineInterpolatingFunction[] xSplineYZ = CallChecker.varInit(new BicubicSplineInterpolatingFunction[xLen], "xSplineYZ", 83, 3428, 3539);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(xSplineYZ, BicubicSplineInterpolatingFunction[].class, 86, 3594, 3602)) {
                    if (CallChecker.beforeDeref(fval, double[][][].class, 86, 3637, 3640)) {
                        if (CallChecker.beforeDeref(bsi, BicubicSplineInterpolator.class, 86, 3609, 3611)) {
                            CallChecker.isCalled(xSplineYZ, BicubicSplineInterpolatingFunction[].class, 86, 3594, 3602)[i] = CallChecker.isCalled(bsi, BicubicSplineInterpolator.class, 86, 3609, 3611).interpolate(yval, zval, CallChecker.isCalled(fval, double[][][].class, 86, 3637, 3640)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(xSplineYZ, BicubicSplineInterpolatingFunction[].class, 86, 3594, 3602)[i], "CallChecker.isCalled(xSplineYZ, BicubicSplineInterpolatingFunction[].class, 86, 3594, 3602)[i]", 86, 3594, 3645);
                        }
                    }
                }
            }
            final BicubicSplineInterpolatingFunction[] ySplineZX = CallChecker.varInit(new BicubicSplineInterpolatingFunction[yLen], "ySplineZX", 90, 3746, 3857);
            for (int j = 0; j < yLen; j++) {
                if (CallChecker.beforeDeref(ySplineZX, BicubicSplineInterpolatingFunction[].class, 93, 3912, 3920)) {
                    if (CallChecker.beforeDeref(fvalZX, double[][][].class, 93, 3955, 3960)) {
                        if (CallChecker.beforeDeref(bsi, BicubicSplineInterpolator.class, 93, 3927, 3929)) {
                            CallChecker.isCalled(ySplineZX, BicubicSplineInterpolatingFunction[].class, 93, 3912, 3920)[j] = CallChecker.isCalled(bsi, BicubicSplineInterpolator.class, 93, 3927, 3929).interpolate(zval, xval, CallChecker.isCalled(fvalZX, double[][][].class, 93, 3955, 3960)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(ySplineZX, BicubicSplineInterpolatingFunction[].class, 93, 3912, 3920)[j], "CallChecker.isCalled(ySplineZX, BicubicSplineInterpolatingFunction[].class, 93, 3912, 3920)[j]", 93, 3912, 3965);
                        }
                    }
                }
            }
            final BicubicSplineInterpolatingFunction[] zSplineXY = CallChecker.varInit(new BicubicSplineInterpolatingFunction[zLen], "zSplineXY", 97, 4066, 4177);
            for (int k = 0; k < zLen; k++) {
                if (CallChecker.beforeDeref(zSplineXY, BicubicSplineInterpolatingFunction[].class, 100, 4232, 4240)) {
                    if (CallChecker.beforeDeref(fvalXY, double[][][].class, 100, 4275, 4280)) {
                        if (CallChecker.beforeDeref(bsi, BicubicSplineInterpolator.class, 100, 4247, 4249)) {
                            CallChecker.isCalled(zSplineXY, BicubicSplineInterpolatingFunction[].class, 100, 4232, 4240)[k] = CallChecker.isCalled(bsi, BicubicSplineInterpolator.class, 100, 4247, 4249).interpolate(xval, yval, CallChecker.isCalled(fvalXY, double[][][].class, 100, 4275, 4280)[k]);
                            CallChecker.varAssign(CallChecker.isCalled(zSplineXY, BicubicSplineInterpolatingFunction[].class, 100, 4232, 4240)[k], "CallChecker.isCalled(zSplineXY, BicubicSplineInterpolatingFunction[].class, 100, 4232, 4240)[k]", 100, 4232, 4285);
                        }
                    }
                }
            }
            final double[][][] dFdX = CallChecker.varInit(new double[xLen][yLen][zLen], "dFdX", 104, 4353, 4407);
            final double[][][] dFdY = CallChecker.varInit(new double[xLen][yLen][zLen], "dFdY", 105, 4417, 4471);
            final double[][][] d2FdXdY = CallChecker.varInit(new double[xLen][yLen][zLen], "d2FdXdY", 106, 4481, 4538);
            for (int k = 0; k < zLen; k++) {
                final BicubicSplineInterpolatingFunction f = CallChecker.varInit(CallChecker.isCalled(zSplineXY, BicubicSplineInterpolatingFunction[].class, 108, 4638, 4646)[k], "f", 108, 4593, 4650);
                for (int i = 0; i < xLen; i++) {
                    final double x = CallChecker.varInit(((double) (CallChecker.isCalled(xval, double[].class, 110, 4730, 4733)[i])), "x", 110, 4713, 4737);
                    for (int j = 0; j < yLen; j++) {
                        final double y = CallChecker.varInit(((double) (CallChecker.isCalled(yval, double[].class, 112, 4825, 4828)[j])), "y", 112, 4808, 4832);
                        if (CallChecker.beforeDeref(dFdX, double[][][].class, 113, 4854, 4857)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)) {
                                CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j], double[].class, 113, 4854, 4863)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 113, 4870, 4870)) {
                                        CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860);
                                        CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j], double[].class, 113, 4854, 4863);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j], double[].class, 113, 4854, 4863)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 113, 4870, 4870).partialDerivativeX(x, y);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j], double[].class, 113, 4854, 4863)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][][].class, 113, 4854, 4857)[i], double[][].class, 113, 4854, 4860)[j], double[].class, 113, 4854, 4863)[k]", 113, 4854, 4896);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(dFdY, double[][][].class, 114, 4918, 4921)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)) {
                                CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j], double[].class, 114, 4918, 4927)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 114, 4934, 4934)) {
                                        CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924);
                                        CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j], double[].class, 114, 4918, 4927);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j], double[].class, 114, 4918, 4927)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 114, 4934, 4934).partialDerivativeY(x, y);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j], double[].class, 114, 4918, 4927)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][][].class, 114, 4918, 4921)[i], double[][].class, 114, 4918, 4924)[j], double[].class, 114, 4918, 4927)[k]", 114, 4918, 4960);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(d2FdXdY, double[][][].class, 115, 4982, 4988)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)) {
                                CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j], double[].class, 115, 4982, 4994)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 115, 5001, 5001)) {
                                        CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991);
                                        CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j], double[].class, 115, 4982, 4994);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j], double[].class, 115, 4982, 4994)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 115, 5001, 5001).partialDerivativeXY(x, y);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j], double[].class, 115, 4982, 4994)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][][].class, 115, 4982, 4988)[i], double[][].class, 115, 4982, 4991)[j], double[].class, 115, 4982, 4994)[k]", 115, 4982, 5028);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final double[][][] dFdZ = CallChecker.varInit(new double[xLen][yLen][zLen], "dFdZ", 121, 5128, 5182);
            final double[][][] d2FdYdZ = CallChecker.varInit(new double[xLen][yLen][zLen], "d2FdYdZ", 122, 5192, 5249);
            for (int i = 0; i < xLen; i++) {
                final BicubicSplineInterpolatingFunction f = CallChecker.varInit(CallChecker.isCalled(xSplineYZ, BicubicSplineInterpolatingFunction[].class, 124, 5349, 5357)[i], "f", 124, 5304, 5361);
                for (int j = 0; j < yLen; j++) {
                    final double y = CallChecker.varInit(((double) (CallChecker.isCalled(yval, double[].class, 126, 5441, 5444)[j])), "y", 126, 5424, 5448);
                    for (int k = 0; k < zLen; k++) {
                        final double z = CallChecker.varInit(((double) (CallChecker.isCalled(zval, double[].class, 128, 5536, 5539)[k])), "z", 128, 5519, 5543);
                        if (CallChecker.beforeDeref(dFdZ, double[][][].class, 129, 5565, 5568)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)) {
                                CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j], double[].class, 129, 5565, 5574)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 129, 5581, 5581)) {
                                        CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571);
                                        CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j], double[].class, 129, 5565, 5574);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j], double[].class, 129, 5565, 5574)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 129, 5581, 5581).partialDerivativeY(y, z);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j], double[].class, 129, 5565, 5574)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dFdZ, double[][][].class, 129, 5565, 5568)[i], double[][].class, 129, 5565, 5571)[j], double[].class, 129, 5565, 5574)[k]", 129, 5565, 5607);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(d2FdYdZ, double[][][].class, 130, 5629, 5635)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)) {
                                CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j], double[].class, 130, 5629, 5641)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 130, 5648, 5648)) {
                                        CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638);
                                        CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j], double[].class, 130, 5629, 5641);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j], double[].class, 130, 5629, 5641)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 130, 5648, 5648).partialDerivativeXY(y, z);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j], double[].class, 130, 5629, 5641)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdYdZ, double[][][].class, 130, 5629, 5635)[i], double[][].class, 130, 5629, 5638)[j], double[].class, 130, 5629, 5641)[k]", 130, 5629, 5675);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final double[][][] d2FdZdX = CallChecker.varInit(new double[xLen][yLen][zLen], "d2FdZdX", 136, 5775, 5832);
            for (int j = 0; j < yLen; j++) {
                final BicubicSplineInterpolatingFunction f = CallChecker.varInit(CallChecker.isCalled(ySplineZX, BicubicSplineInterpolatingFunction[].class, 138, 5932, 5940)[j], "f", 138, 5887, 5944);
                for (int k = 0; k < zLen; k++) {
                    final double z = CallChecker.varInit(((double) (CallChecker.isCalled(zval, double[].class, 140, 6024, 6027)[k])), "z", 140, 6007, 6031);
                    for (int i = 0; i < xLen; i++) {
                        final double x = CallChecker.varInit(((double) (CallChecker.isCalled(xval, double[].class, 142, 6119, 6122)[i])), "x", 142, 6102, 6126);
                        if (CallChecker.beforeDeref(d2FdZdX, double[][][].class, 143, 6148, 6154)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)) {
                                CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j], double[].class, 143, 6148, 6160)) {
                                    if (CallChecker.beforeDeref(f, BicubicSplineInterpolatingFunction.class, 143, 6167, 6167)) {
                                        CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157);
                                        CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j], double[].class, 143, 6148, 6160);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j], double[].class, 143, 6148, 6160)[k] = CallChecker.isCalled(f, BicubicSplineInterpolatingFunction.class, 143, 6167, 6167).partialDerivativeXY(z, x);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j], double[].class, 143, 6148, 6160)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d2FdZdX, double[][][].class, 143, 6148, 6154)[i], double[][].class, 143, 6148, 6157)[j], double[].class, 143, 6148, 6160)[k]", 143, 6148, 6194);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final double[][][] d3FdXdYdZ = CallChecker.varInit(new double[xLen][yLen][zLen], "d3FdXdYdZ", 149, 6290, 6349);
            for (int i = 0; i < xLen; i++) {
                final int nI = CallChecker.varInit(((int) (nextIndex(i, xLen))), "nI", 151, 6405, 6438);
                final int pI = CallChecker.varInit(((int) (previousIndex(i))), "pI", 152, 6452, 6483);
                for (int j = 0; j < yLen; j++) {
                    final int nJ = CallChecker.varInit(((int) (nextIndex(j, yLen))), "nJ", 154, 6546, 6579);
                    final int pJ = CallChecker.varInit(((int) (previousIndex(j))), "pJ", 155, 6597, 6628);
                    for (int k = 0; k < zLen; k++) {
                        final int nK = CallChecker.varInit(((int) (nextIndex(k, zLen))), "nK", 157, 6699, 6732);
                        final int pK = CallChecker.varInit(((int) (previousIndex(k))), "pK", 158, 6754, 6785);
                        if (CallChecker.beforeDeref(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)) {
                                CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j], double[].class, 161, 6863, 6877)) {
                                    if (CallChecker.beforeDeref(fval, double[][][].class, 161, 6885, 6888)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892)) {
                                            CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892)[nJ], double[].class, 161, 6885, 6896)) {
                                                if (CallChecker.beforeDeref(fval, double[][][].class, 161, 6904, 6907)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911)) {
                                                        CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911)[pJ], double[].class, 161, 6904, 6915)) {
                                                            if (CallChecker.beforeDeref(fval, double[][][].class, 162, 6965, 6968)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972)) {
                                                                    CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972);
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972)[nJ], double[].class, 162, 6965, 6976)) {
                                                                        if (CallChecker.beforeDeref(fval, double[][][].class, 162, 6984, 6987)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991)) {
                                                                                CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991);
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991)[pJ], double[].class, 162, 6984, 6995)) {
                                                                                    if (CallChecker.beforeDeref(fval, double[][][].class, 163, 7045, 7048)) {
                                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052)) {
                                                                                            CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052);
                                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052)[nJ], double[].class, 163, 7045, 7056)) {
                                                                                                if (CallChecker.beforeDeref(fval, double[][][].class, 163, 7064, 7067)) {
                                                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071)) {
                                                                                                        CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071);
                                                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071)[pJ], double[].class, 163, 7064, 7075)) {
                                                                                                            if (CallChecker.beforeDeref(fval, double[][][].class, 164, 7125, 7128)) {
                                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132)) {
                                                                                                                    CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132);
                                                                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132)[nJ], double[].class, 164, 7125, 7136)) {
                                                                                                                        if (CallChecker.beforeDeref(fval, double[][][].class, 164, 7144, 7147)) {
                                                                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151)) {
                                                                                                                                CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151);
                                                                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151)[pJ], double[].class, 164, 7144, 7155)) {
                                                                                                                                    if (CallChecker.beforeDeref(xval, double[].class, 165, 7190, 7193)) {
                                                                                                                                        if (CallChecker.beforeDeref(xval, double[].class, 165, 7201, 7204)) {
                                                                                                                                            if (CallChecker.beforeDeref(yval, double[].class, 165, 7214, 7217)) {
                                                                                                                                                if (CallChecker.beforeDeref(yval, double[].class, 165, 7225, 7228)) {
                                                                                                                                                    if (CallChecker.beforeDeref(zval, double[].class, 165, 7238, 7241)) {
                                                                                                                                                        if (CallChecker.beforeDeref(zval, double[].class, 165, 7249, 7252)) {
                                                                                                                                                            CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j], double[].class, 161, 6863, 6877);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892)[nJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892)[nJ], double[].class, 161, 6885, 6896);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911)[pJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911)[pJ], double[].class, 161, 6904, 6915);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972)[nJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972)[nJ], double[].class, 162, 6965, 6976);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991)[pJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991)[pJ], double[].class, 162, 6984, 6995);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052)[nJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052)[nJ], double[].class, 163, 7045, 7056);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071)[pJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071)[pJ], double[].class, 163, 7064, 7075);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132)[nJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132)[nJ], double[].class, 164, 7125, 7136);
                                                                                                                                                            CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151)[pJ] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151)[pJ], double[].class, 164, 7144, 7155);
                                                                                                                                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j], double[].class, 161, 6863, 6877)[k] = ((((((((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6885, 6888)[nI], double[][].class, 161, 6885, 6892)[nJ], double[].class, 161, 6885, 6896)[nK]) - (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 161, 6904, 6907)[nI], double[][].class, 161, 6904, 6911)[pJ], double[].class, 161, 6904, 6915)[nK])) - (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6965, 6968)[pI], double[][].class, 162, 6965, 6972)[nJ], double[].class, 162, 6965, 6976)[nK])) + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 162, 6984, 6987)[pI], double[][].class, 162, 6984, 6991)[pJ], double[].class, 162, 6984, 6995)[nK])) - (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7045, 7048)[nI], double[][].class, 163, 7045, 7052)[nJ], double[].class, 163, 7045, 7056)[pK])) + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 163, 7064, 7067)[nI], double[][].class, 163, 7064, 7071)[pJ], double[].class, 163, 7064, 7075)[pK])) + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7125, 7128)[pI], double[][].class, 164, 7125, 7132)[nJ], double[].class, 164, 7125, 7136)[pK])) - (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fval, double[][][].class, 164, 7144, 7147)[pI], double[][].class, 164, 7144, 7151)[pJ], double[].class, 164, 7144, 7155)[pK])) / ((((CallChecker.isCalled(xval, double[].class, 165, 7190, 7193)[nI]) - (CallChecker.isCalled(xval, double[].class, 165, 7201, 7204)[pI])) * ((CallChecker.isCalled(yval, double[].class, 165, 7214, 7217)[nJ]) - (CallChecker.isCalled(yval, double[].class, 165, 7225, 7228)[pJ]))) * ((CallChecker.isCalled(zval, double[].class, 165, 7238, 7241)[nK]) - (CallChecker.isCalled(zval, double[].class, 165, 7249, 7252)[pK])));
                                                                                                                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j], double[].class, 161, 6863, 6877)[k], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(d3FdXdYdZ, double[][][].class, 161, 6863, 6871)[i], double[][].class, 161, 6863, 6874)[j], double[].class, 161, 6863, 6877)[k]", 161, 6863, 7260);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new TricubicSplineInterpolatingFunction(xval, yval, zval, fval, dFdX, dFdY, dFdZ, d2FdXdY, d2FdZdX, d2FdYdZ, d3FdXdYdZ);
        } catch (ForceReturn _bcornu_return_t) {
            return ((TricubicSplineInterpolatingFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4408.methodEnd();
        }
    }

    private int nextIndex(int i, int max) {
        MethodContext _bcornu_methode_context4409 = new MethodContext(int.class, 185, 7661, 8055);
        try {
            CallChecker.varInit(this, "this", 185, 7661, 8055);
            CallChecker.varInit(max, "max", 185, 7661, 8055);
            CallChecker.varInit(i, "i", 185, 7661, 8055);
            final int index = CallChecker.varInit(((int) (i + 1)), "index", 186, 7978, 8001);
            if (index < max) {
                return index;
            }else {
                return index - 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4409.methodEnd();
        }
    }

    private int previousIndex(int i) {
        MethodContext _bcornu_methode_context4410 = new MethodContext(int.class, 196, 8061, 8414);
        try {
            CallChecker.varInit(this, "this", 196, 8061, 8414);
            CallChecker.varInit(i, "i", 196, 8061, 8414);
            final int index = CallChecker.varInit(((int) (i - 1)), "index", 197, 8346, 8369);
            if (index >= 0) {
                return index;
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4410.methodEnd();
        }
    }
}

