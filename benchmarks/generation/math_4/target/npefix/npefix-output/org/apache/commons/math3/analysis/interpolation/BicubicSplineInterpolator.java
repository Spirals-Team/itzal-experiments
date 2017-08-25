package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;

public class BicubicSplineInterpolator implements BivariateGridInterpolator {
    public BicubicSplineInterpolatingFunction interpolate(final double[] xval, final double[] yval, final double[][] fval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5473 = new MethodContext(BicubicSplineInterpolatingFunction.class, 38, 1497, 5050);
        try {
            CallChecker.varInit(this, "this", 38, 1497, 5050);
            CallChecker.varInit(fval, "fval", 38, 1497, 5050);
            CallChecker.varInit(yval, "yval", 38, 1497, 5050);
            CallChecker.varInit(xval, "xval", 38, 1497, 5050);
            if (CallChecker.beforeDeref(xval, double[].class, 43, 1915, 1918)) {
                if (CallChecker.beforeDeref(yval, double[].class, 43, 1935, 1938)) {
                    if (CallChecker.beforeDeref(fval, double[][].class, 43, 1955, 1958)) {
                        if ((((CallChecker.isCalled(xval, double[].class, 43, 1915, 1918).length) == 0) || ((CallChecker.isCalled(yval, double[].class, 43, 1935, 1938).length) == 0)) || ((CallChecker.isCalled(fval, double[][].class, 43, 1955, 1958).length) == 0)) {
                            throw new NoDataException();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(xval, double[].class, 46, 2038, 2041)) {
                if (CallChecker.beforeDeref(fval, double[][].class, 46, 2053, 2056)) {
                    if ((CallChecker.isCalled(xval, double[].class, 46, 2038, 2041).length) != (CallChecker.isCalled(fval, double[][].class, 46, 2053, 2056).length)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 47, 2117, 2120)) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 47, 2130, 2133)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xval, double[].class, 47, 2117, 2120).length, CallChecker.isCalled(fval, double[][].class, 47, 2130, 2133).length);
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
            final int xLen = CallChecker.varInit(((int) (CallChecker.isCalled(xval, double[].class, 53, 2255, 2258).length)), "xLen", 53, 2238, 2266);
            final int yLen = CallChecker.varInit(((int) (CallChecker.isCalled(yval, double[].class, 54, 2293, 2296).length)), "yLen", 54, 2276, 2304);
            final double[][] fX = CallChecker.varInit(new double[yLen][xLen], "fX", 60, 2499, 2543);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(fval, double[][].class, 62, 2602, 2605)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 62, 2602, 2605)[i], double[].class, 62, 2602, 2608)) {
                        CallChecker.isCalled(fval, double[][].class, 62, 2602, 2605)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 62, 2602, 2605)[i], double[].class, 62, 2602, 2608);
                        if ((CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 62, 2602, 2605)[i], double[].class, 62, 2602, 2608).length) != yLen) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 63, 2681, 2684)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 63, 2681, 2684)[i], double[].class, 63, 2681, 2687)) {
                                    CallChecker.isCalled(fval, double[][].class, 63, 2681, 2684)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 63, 2681, 2684)[i], double[].class, 63, 2681, 2687);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 63, 2681, 2684)[i], double[].class, 63, 2681, 2687).length, yLen);
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
                    if (CallChecker.beforeDeref(fX, double[][].class, 67, 2780, 2781)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j], double[].class, 67, 2780, 2784)) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 67, 2791, 2794)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 67, 2791, 2794)[i], double[].class, 67, 2791, 2797)) {
                                    CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j], double[].class, 67, 2780, 2784);
                                    CallChecker.isCalled(fval, double[][].class, 67, 2791, 2794)[i] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 67, 2791, 2794)[i], double[].class, 67, 2791, 2797);
                                    CallChecker.isCalled(CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j], double[].class, 67, 2780, 2784)[i] = CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 67, 2791, 2794)[i], double[].class, 67, 2791, 2797)[j];
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j], double[].class, 67, 2780, 2784)[i], "CallChecker.isCalled(CallChecker.isCalled(fX, double[][].class, 67, 2780, 2781)[j], double[].class, 67, 2780, 2784)[i]", 67, 2780, 2801);
                                }
                            }
                        }
                    }
                }
            }
            final SplineInterpolator spInterpolator = CallChecker.varInit(new SplineInterpolator(), "spInterpolator", 71, 2836, 2902);
            final PolynomialSplineFunction[] ySplineX = CallChecker.varInit(new PolynomialSplineFunction[yLen], "ySplineX", 75, 3020, 3098);
            for (int j = 0; j < yLen; j++) {
                if (CallChecker.beforeDeref(ySplineX, PolynomialSplineFunction[].class, 77, 3153, 3160)) {
                    if (CallChecker.beforeDeref(fX, double[][].class, 77, 3200, 3201)) {
                        if (CallChecker.beforeDeref(spInterpolator, SplineInterpolator.class, 77, 3167, 3180)) {
                            CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 77, 3153, 3160)[j] = CallChecker.isCalled(spInterpolator, SplineInterpolator.class, 77, 3167, 3180).interpolate(xval, CallChecker.isCalled(fX, double[][].class, 77, 3200, 3201)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 77, 3153, 3160)[j], "CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 77, 3153, 3160)[j]", 77, 3153, 3206);
                        }
                    }
                }
            }
            final PolynomialSplineFunction[] xSplineY = CallChecker.varInit(new PolynomialSplineFunction[xLen], "xSplineY", 82, 3361, 3439);
            for (int i = 0; i < xLen; i++) {
                if (CallChecker.beforeDeref(xSplineY, PolynomialSplineFunction[].class, 84, 3494, 3501)) {
                    if (CallChecker.beforeDeref(fval, double[][].class, 84, 3541, 3544)) {
                        if (CallChecker.beforeDeref(spInterpolator, SplineInterpolator.class, 84, 3508, 3521)) {
                            CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 84, 3494, 3501)[i] = CallChecker.isCalled(spInterpolator, SplineInterpolator.class, 84, 3508, 3521).interpolate(yval, CallChecker.isCalled(fval, double[][].class, 84, 3541, 3544)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 84, 3494, 3501)[i], "CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 84, 3494, 3501)[i]", 84, 3494, 3549);
                        }
                    }
                }
            }
            final double[][] dFdX = CallChecker.varInit(new double[xLen][yLen], "dFdX", 88, 3637, 3683);
            for (int j = 0; j < yLen; j++) {
                CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 90, 3767, 3774)[j] = CallChecker.beforeCalled(CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 90, 3767, 3774)[j], PolynomialSplineFunction.class, 90, 3767, 3777);
                final UnivariateFunction f = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(ySplineX, PolynomialSplineFunction[].class, 90, 3767, 3774)[j], PolynomialSplineFunction.class, 90, 3767, 3777).derivative(), "f", 90, 3738, 3791);
                for (int i = 0; i < xLen; i++) {
                    if (CallChecker.beforeDeref(dFdX, double[][].class, 92, 3854, 3857)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i], double[].class, 92, 3854, 3860)) {
                            if (CallChecker.beforeDeref(xval, double[].class, 92, 3875, 3878)) {
                                if (CallChecker.beforeDeref(f, UnivariateFunction.class, 92, 3867, 3867)) {
                                    CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i], double[].class, 92, 3854, 3860);
                                    CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i], double[].class, 92, 3854, 3860)[j] = CallChecker.isCalled(f, UnivariateFunction.class, 92, 3867, 3867).value(CallChecker.isCalled(xval, double[].class, 92, 3875, 3878)[i]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i], double[].class, 92, 3854, 3860)[j], "CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 92, 3854, 3857)[i], double[].class, 92, 3854, 3860)[j]", 92, 3854, 3883);
                                }
                            }
                        }
                    }
                }
            }
            final double[][] dFdY = CallChecker.varInit(new double[xLen][yLen], "dFdY", 97, 3985, 4031);
            for (int i = 0; i < xLen; i++) {
                CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 99, 4115, 4122)[i] = CallChecker.beforeCalled(CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 99, 4115, 4122)[i], PolynomialSplineFunction.class, 99, 4115, 4125);
                final UnivariateFunction f = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(xSplineY, PolynomialSplineFunction[].class, 99, 4115, 4122)[i], PolynomialSplineFunction.class, 99, 4115, 4125).derivative(), "f", 99, 4086, 4139);
                for (int j = 0; j < yLen; j++) {
                    if (CallChecker.beforeDeref(dFdY, double[][].class, 101, 4202, 4205)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i], double[].class, 101, 4202, 4208)) {
                            if (CallChecker.beforeDeref(yval, double[].class, 101, 4223, 4226)) {
                                if (CallChecker.beforeDeref(f, UnivariateFunction.class, 101, 4215, 4215)) {
                                    CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i], double[].class, 101, 4202, 4208);
                                    CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i], double[].class, 101, 4202, 4208)[j] = CallChecker.isCalled(f, UnivariateFunction.class, 101, 4215, 4215).value(CallChecker.isCalled(yval, double[].class, 101, 4223, 4226)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i], double[].class, 101, 4202, 4208)[j], "CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 101, 4202, 4205)[i], double[].class, 101, 4202, 4208)[j]", 101, 4202, 4231);
                                }
                            }
                        }
                    }
                }
            }
            final double[][] d2FdXdY = CallChecker.varInit(new double[xLen][yLen], "d2FdXdY", 106, 4303, 4352);
            for (int i = 0; i < xLen; i++) {
                final int nI = CallChecker.varInit(((int) (nextIndex(i, xLen))), "nI", 108, 4408, 4441);
                final int pI = CallChecker.varInit(((int) (previousIndex(i))), "pI", 109, 4455, 4486);
                for (int j = 0; j < yLen; j++) {
                    final int nJ = CallChecker.varInit(((int) (nextIndex(j, yLen))), "nJ", 111, 4549, 4582);
                    final int pJ = CallChecker.varInit(((int) (previousIndex(j))), "pJ", 112, 4600, 4631);
                    if (CallChecker.beforeDeref(d2FdXdY, double[][].class, 113, 4649, 4655)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i], double[].class, 113, 4649, 4658)) {
                            if (CallChecker.beforeDeref(fval, double[][].class, 113, 4666, 4669)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 113, 4666, 4669)[nI], double[].class, 113, 4666, 4673)) {
                                    if (CallChecker.beforeDeref(fval, double[][].class, 113, 4681, 4684)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 113, 4681, 4684)[nI], double[].class, 113, 4681, 4688)) {
                                            if (CallChecker.beforeDeref(fval, double[][].class, 114, 4729, 4732)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 114, 4729, 4732)[pI], double[].class, 114, 4729, 4736)) {
                                                    if (CallChecker.beforeDeref(fval, double[][].class, 114, 4744, 4747)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fval, double[][].class, 114, 4744, 4747)[pI], double[].class, 114, 4744, 4751)) {
                                                            if (CallChecker.beforeDeref(xval, double[].class, 115, 4782, 4785)) {
                                                                if (CallChecker.beforeDeref(xval, double[].class, 115, 4793, 4796)) {
                                                                    if (CallChecker.beforeDeref(yval, double[].class, 115, 4806, 4809)) {
                                                                        if (CallChecker.beforeDeref(yval, double[].class, 115, 4817, 4820)) {
                                                                            CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i], double[].class, 113, 4649, 4658);
                                                                            CallChecker.isCalled(fval, double[][].class, 113, 4666, 4669)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 113, 4666, 4669)[nI], double[].class, 113, 4666, 4673);
                                                                            CallChecker.isCalled(fval, double[][].class, 113, 4681, 4684)[nI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 113, 4681, 4684)[nI], double[].class, 113, 4681, 4688);
                                                                            CallChecker.isCalled(fval, double[][].class, 114, 4729, 4732)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 114, 4729, 4732)[pI], double[].class, 114, 4729, 4736);
                                                                            CallChecker.isCalled(fval, double[][].class, 114, 4744, 4747)[pI] = CallChecker.beforeCalled(CallChecker.isCalled(fval, double[][].class, 114, 4744, 4747)[pI], double[].class, 114, 4744, 4751);
                                                                            CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i], double[].class, 113, 4649, 4658)[j] = ((((CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 113, 4666, 4669)[nI], double[].class, 113, 4666, 4673)[nJ]) - (CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 113, 4681, 4684)[nI], double[].class, 113, 4681, 4688)[pJ])) - (CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 114, 4729, 4732)[pI], double[].class, 114, 4729, 4736)[nJ])) + (CallChecker.isCalled(CallChecker.isCalled(fval, double[][].class, 114, 4744, 4747)[pI], double[].class, 114, 4744, 4751)[pJ])) / (((CallChecker.isCalled(xval, double[].class, 115, 4782, 4785)[nI]) - (CallChecker.isCalled(xval, double[].class, 115, 4793, 4796)[pI])) * ((CallChecker.isCalled(yval, double[].class, 115, 4806, 4809)[nJ]) - (CallChecker.isCalled(yval, double[].class, 115, 4817, 4820)[pJ])));
                                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i], double[].class, 113, 4649, 4658)[j], "CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 113, 4649, 4655)[i], double[].class, 113, 4649, 4658)[j]", 113, 4649, 4827);
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
            return new BicubicSplineInterpolatingFunction(xval, yval, fval, dFdX, dFdY, d2FdXdY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BicubicSplineInterpolatingFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5473.methodEnd();
        }
    }

    private int nextIndex(int i, int max) {
        MethodContext _bcornu_methode_context5474 = new MethodContext(int.class, 132, 5057, 5430);
        try {
            CallChecker.varInit(this, "this", 132, 5057, 5430);
            CallChecker.varInit(max, "max", 132, 5057, 5430);
            CallChecker.varInit(i, "i", 132, 5057, 5430);
            final int index = CallChecker.varInit(((int) (i + 1)), "index", 133, 5353, 5376);
            if (index < max) {
                return index;
            }else {
                return index - 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5474.methodEnd();
        }
    }

    private int previousIndex(int i) {
        MethodContext _bcornu_methode_context5475 = new MethodContext(int.class, 144, 5436, 5799);
        try {
            CallChecker.varInit(this, "this", 144, 5436, 5799);
            CallChecker.varInit(i, "i", 144, 5436, 5799);
            final int index = CallChecker.varInit(((int) (i - 1)), "index", 145, 5731, 5754);
            if (index >= 0) {
                return index;
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5475.methodEnd();
        }
    }
}

