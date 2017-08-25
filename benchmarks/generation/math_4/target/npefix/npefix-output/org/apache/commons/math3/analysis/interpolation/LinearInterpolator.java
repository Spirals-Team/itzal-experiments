package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

public class LinearInterpolator implements UnivariateInterpolator {
    public PolynomialSplineFunction interpolate(double[] x, double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context4723 = new MethodContext(PolynomialSplineFunction.class, 46, 1520, 3306);
        try {
            CallChecker.varInit(this, "this", 46, 1520, 3306);
            CallChecker.varInit(y, "y", 46, 1520, 3306);
            CallChecker.varInit(x, "x", 46, 1520, 3306);
            if (CallChecker.beforeDeref(x, double[].class, 50, 2291, 2291)) {
                if (CallChecker.beforeDeref(y, double[].class, 50, 2303, 2303)) {
                    x = CallChecker.beforeCalled(x, double[].class, 50, 2291, 2291);
                    y = CallChecker.beforeCalled(y, double[].class, 50, 2303, 2303);
                    if ((CallChecker.isCalled(x, double[].class, 50, 2291, 2291).length) != (CallChecker.isCalled(y, double[].class, 50, 2303, 2303).length)) {
                        if (CallChecker.beforeDeref(x, double[].class, 51, 2364, 2364)) {
                            if (CallChecker.beforeDeref(y, double[].class, 51, 2374, 2374)) {
                                x = CallChecker.beforeCalled(x, double[].class, 51, 2364, 2364);
                                y = CallChecker.beforeCalled(y, double[].class, 51, 2374, 2374);
                                throw new DimensionMismatchException(CallChecker.isCalled(x, double[].class, 51, 2364, 2364).length, CallChecker.isCalled(y, double[].class, 51, 2374, 2374).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, double[].class, 54, 2408, 2408)) {
                x = CallChecker.beforeCalled(x, double[].class, 54, 2408, 2408);
                if ((CallChecker.isCalled(x, double[].class, 54, 2408, 2408).length) < 2) {
                    if (CallChecker.beforeDeref(x, double[].class, 56, 2555, 2555)) {
                        x = CallChecker.beforeCalled(x, double[].class, 56, 2555, 2555);
                        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, CallChecker.isCalled(x, double[].class, 56, 2555, 2555).length, 2, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(x, double[].class, 60, 2671, 2671)) {
                x = CallChecker.beforeCalled(x, double[].class, 60, 2671, 2671);
                n = (CallChecker.isCalled(x, double[].class, 60, 2671, 2671).length) - 1;
                CallChecker.varAssign(n, "n", 60, 2671, 2671);
            }
            MathArrays.checkOrder(x);
            final double[] m = CallChecker.varInit(new double[n], "m", 65, 2729, 2815);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(m, double[].class, 67, 2867, 2867)) {
                    if (CallChecker.beforeDeref(y, double[].class, 67, 2875, 2875)) {
                        if (CallChecker.beforeDeref(y, double[].class, 67, 2886, 2886)) {
                            if (CallChecker.beforeDeref(x, double[].class, 67, 2895, 2895)) {
                                if (CallChecker.beforeDeref(x, double[].class, 67, 2906, 2906)) {
                                    y = CallChecker.beforeCalled(y, double[].class, 67, 2875, 2875);
                                    y = CallChecker.beforeCalled(y, double[].class, 67, 2886, 2886);
                                    x = CallChecker.beforeCalled(x, double[].class, 67, 2895, 2895);
                                    x = CallChecker.beforeCalled(x, double[].class, 67, 2906, 2906);
                                    CallChecker.isCalled(m, double[].class, 67, 2867, 2867)[i] = ((CallChecker.isCalled(y, double[].class, 67, 2875, 2875)[(i + 1)]) - (CallChecker.isCalled(y, double[].class, 67, 2886, 2886)[i])) / ((CallChecker.isCalled(x, double[].class, 67, 2895, 2895)[(i + 1)]) - (CallChecker.isCalled(x, double[].class, 67, 2906, 2906)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(m, double[].class, 67, 2867, 2867)[i], "CallChecker.isCalled(m, double[].class, 67, 2867, 2867)[i]", 67, 2867, 2911);
                                }
                            }
                        }
                    }
                }
            }
            final PolynomialFunction[] polynomials = CallChecker.varInit(new PolynomialFunction[n], "polynomials", 70, 2932, 2998);
            final double[] coefficients = CallChecker.varInit(new double[2], "coefficients", 71, 3008, 3051);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 73, 3103, 3114)) {
                    if (CallChecker.beforeDeref(y, double[].class, 73, 3121, 3121)) {
                        y = CallChecker.beforeCalled(y, double[].class, 73, 3121, 3121);
                        CallChecker.isCalled(coefficients, double[].class, 73, 3103, 3114)[0] = CallChecker.isCalled(y, double[].class, 73, 3121, 3121)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 73, 3103, 3114)[0], "CallChecker.isCalled(coefficients, double[].class, 73, 3103, 3114)[0]", 73, 3103, 3125);
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 74, 3139, 3150)) {
                    if (CallChecker.beforeDeref(m, double[].class, 74, 3157, 3157)) {
                        CallChecker.isCalled(coefficients, double[].class, 74, 3139, 3150)[1] = CallChecker.isCalled(m, double[].class, 74, 3157, 3157)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 74, 3139, 3150)[1], "CallChecker.isCalled(coefficients, double[].class, 74, 3139, 3150)[1]", 74, 3139, 3161);
                    }
                }
                if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 75, 3175, 3185)) {
                    CallChecker.isCalled(polynomials, PolynomialFunction[].class, 75, 3175, 3185)[i] = new PolynomialFunction(coefficients);
                    CallChecker.varAssign(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 75, 3175, 3185)[i], "CallChecker.isCalled(polynomials, PolynomialFunction[].class, 75, 3175, 3185)[i]", 75, 3175, 3228);
                }
            }
            return new PolynomialSplineFunction(x, polynomials);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialSplineFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4723.methodEnd();
        }
    }
}

