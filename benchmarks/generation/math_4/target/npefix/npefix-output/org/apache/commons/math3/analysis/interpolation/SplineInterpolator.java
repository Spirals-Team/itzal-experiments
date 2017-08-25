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

public class SplineInterpolator implements UnivariateInterpolator {
    public PolynomialSplineFunction interpolate(double[] x, double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context5397 = new MethodContext(PolynomialSplineFunction.class, 66, 2842, 5624);
        try {
            CallChecker.varInit(this, "this", 66, 2842, 5624);
            CallChecker.varInit(y, "y", 66, 2842, 5624);
            CallChecker.varInit(x, "x", 66, 2842, 5624);
            if (CallChecker.beforeDeref(x, double[].class, 70, 3600, 3600)) {
                if (CallChecker.beforeDeref(y, double[].class, 70, 3612, 3612)) {
                    x = CallChecker.beforeCalled(x, double[].class, 70, 3600, 3600);
                    y = CallChecker.beforeCalled(y, double[].class, 70, 3612, 3612);
                    if ((CallChecker.isCalled(x, double[].class, 70, 3600, 3600).length) != (CallChecker.isCalled(y, double[].class, 70, 3612, 3612).length)) {
                        if (CallChecker.beforeDeref(x, double[].class, 71, 3673, 3673)) {
                            if (CallChecker.beforeDeref(y, double[].class, 71, 3683, 3683)) {
                                x = CallChecker.beforeCalled(x, double[].class, 71, 3673, 3673);
                                y = CallChecker.beforeCalled(y, double[].class, 71, 3683, 3683);
                                throw new DimensionMismatchException(CallChecker.isCalled(x, double[].class, 71, 3673, 3673).length, CallChecker.isCalled(y, double[].class, 71, 3683, 3683).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, double[].class, 74, 3717, 3717)) {
                x = CallChecker.beforeCalled(x, double[].class, 74, 3717, 3717);
                if ((CallChecker.isCalled(x, double[].class, 74, 3717, 3717).length) < 3) {
                    if (CallChecker.beforeDeref(x, double[].class, 76, 3864, 3864)) {
                        x = CallChecker.beforeCalled(x, double[].class, 76, 3864, 3864);
                        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, CallChecker.isCalled(x, double[].class, 76, 3864, 3864).length, 3, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            x = CallChecker.beforeCalled(x, double[].class, 80, 3986, 3986);
            final int n = CallChecker.varInit(((int) ((CallChecker.isCalled(x, double[].class, 80, 3986, 3986).length) - 1)), "n", 80, 3903, 3998);
            MathArrays.checkOrder(x);
            final double[] h = CallChecker.varInit(new double[n], "h", 85, 4044, 4119);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(h, double[].class, 87, 4171, 4171)) {
                    if (CallChecker.beforeDeref(x, double[].class, 87, 4178, 4178)) {
                        if (CallChecker.beforeDeref(x, double[].class, 87, 4189, 4189)) {
                            x = CallChecker.beforeCalled(x, double[].class, 87, 4178, 4178);
                            x = CallChecker.beforeCalled(x, double[].class, 87, 4189, 4189);
                            CallChecker.isCalled(h, double[].class, 87, 4171, 4171)[i] = (CallChecker.isCalled(x, double[].class, 87, 4178, 4178)[(i + 1)]) - (CallChecker.isCalled(x, double[].class, 87, 4189, 4189)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(h, double[].class, 87, 4171, 4171)[i], "CallChecker.isCalled(h, double[].class, 87, 4171, 4171)[i]", 87, 4171, 4193);
                        }
                    }
                }
            }
            final double[] mu = CallChecker.varInit(new double[n], "mu", 90, 4214, 4247);
            final double[] z = CallChecker.varInit(new double[n + 1], "z", 91, 4257, 4293);
            if (CallChecker.beforeDeref(mu, double[].class, 92, 4303, 4304)) {
                CallChecker.isCalled(mu, double[].class, 92, 4303, 4304)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(mu, double[].class, 92, 4303, 4304)[0], "CallChecker.isCalled(mu, double[].class, 92, 4303, 4304)[0]", 92, 4303, 4313);
            }
            if (CallChecker.beforeDeref(z, double[].class, 93, 4323, 4323)) {
                CallChecker.isCalled(z, double[].class, 93, 4323, 4323)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 93, 4323, 4323)[0], "CallChecker.isCalled(z, double[].class, 93, 4323, 4323)[0]", 93, 4323, 4332);
            }
            double g = CallChecker.varInit(((double) (0)), "g", 94, 4342, 4354);
            for (int i = 1; i < n; i++) {
                if (CallChecker.beforeDeref(x, double[].class, 96, 4416, 4416)) {
                    if (CallChecker.beforeDeref(x, double[].class, 96, 4426, 4426)) {
                        if (CallChecker.beforeDeref(h, double[].class, 96, 4438, 4438)) {
                            if (CallChecker.beforeDeref(mu, double[].class, 96, 4449, 4450)) {
                                x = CallChecker.beforeCalled(x, double[].class, 96, 4416, 4416);
                                x = CallChecker.beforeCalled(x, double[].class, 96, 4426, 4426);
                                g = (2.0 * ((CallChecker.isCalled(x, double[].class, 96, 4416, 4416)[(i + 1)]) - (CallChecker.isCalled(x, double[].class, 96, 4426, 4426)[(i - 1)]))) - ((CallChecker.isCalled(h, double[].class, 96, 4438, 4438)[(i - 1)]) * (CallChecker.isCalled(mu, double[].class, 96, 4449, 4450)[(i - 1)]));
                                CallChecker.varAssign(g, "g", 96, 4406, 4457);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(mu, double[].class, 97, 4471, 4472)) {
                    if (CallChecker.beforeDeref(h, double[].class, 97, 4479, 4479)) {
                        CallChecker.isCalled(mu, double[].class, 97, 4471, 4472)[i] = (CallChecker.isCalled(h, double[].class, 97, 4479, 4479)[i]) / g;
                        CallChecker.varAssign(CallChecker.isCalled(mu, double[].class, 97, 4471, 4472)[i], "CallChecker.isCalled(mu, double[].class, 97, 4471, 4472)[i]", 97, 4471, 4487);
                    }
                }
                if (CallChecker.beforeDeref(z, double[].class, 98, 4501, 4501)) {
                    if (CallChecker.beforeDeref(y, double[].class, 98, 4515, 4515)) {
                        if (CallChecker.beforeDeref(h, double[].class, 98, 4526, 4526)) {
                            if (CallChecker.beforeDeref(y, double[].class, 98, 4537, 4537)) {
                                if (CallChecker.beforeDeref(x, double[].class, 98, 4545, 4545)) {
                                    if (CallChecker.beforeDeref(x, double[].class, 98, 4556, 4556)) {
                                        if (CallChecker.beforeDeref(y, double[].class, 98, 4567, 4567)) {
                                            if (CallChecker.beforeDeref(h, double[].class, 98, 4578, 4578)) {
                                                if (CallChecker.beforeDeref(h, double[].class, 99, 4607, 4607)) {
                                                    if (CallChecker.beforeDeref(h, double[].class, 99, 4618, 4618)) {
                                                        if (CallChecker.beforeDeref(h, double[].class, 99, 4626, 4626)) {
                                                            if (CallChecker.beforeDeref(z, double[].class, 99, 4637, 4637)) {
                                                                y = CallChecker.beforeCalled(y, double[].class, 98, 4515, 4515);
                                                                y = CallChecker.beforeCalled(y, double[].class, 98, 4537, 4537);
                                                                x = CallChecker.beforeCalled(x, double[].class, 98, 4545, 4545);
                                                                x = CallChecker.beforeCalled(x, double[].class, 98, 4556, 4556);
                                                                y = CallChecker.beforeCalled(y, double[].class, 98, 4567, 4567);
                                                                CallChecker.isCalled(z, double[].class, 98, 4501, 4501)[i] = (((3.0 * ((((CallChecker.isCalled(y, double[].class, 98, 4515, 4515)[(i + 1)]) * (CallChecker.isCalled(h, double[].class, 98, 4526, 4526)[(i - 1)])) - ((CallChecker.isCalled(y, double[].class, 98, 4537, 4537)[i]) * ((CallChecker.isCalled(x, double[].class, 98, 4545, 4545)[(i + 1)]) - (CallChecker.isCalled(x, double[].class, 98, 4556, 4556)[(i - 1)])))) + ((CallChecker.isCalled(y, double[].class, 98, 4567, 4567)[(i - 1)]) * (CallChecker.isCalled(h, double[].class, 98, 4578, 4578)[i])))) / ((CallChecker.isCalled(h, double[].class, 99, 4607, 4607)[(i - 1)]) * (CallChecker.isCalled(h, double[].class, 99, 4618, 4618)[i]))) - ((CallChecker.isCalled(h, double[].class, 99, 4626, 4626)[(i - 1)]) * (CallChecker.isCalled(z, double[].class, 99, 4637, 4637)[(i - 1)]))) / g;
                                                                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 98, 4501, 4501)[i], "CallChecker.isCalled(z, double[].class, 98, 4501, 4501)[i]", 98, 4501, 4650);
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
            final double[] b = CallChecker.varInit(new double[n], "b", 103, 4671, 4810);
            final double[] c = CallChecker.varInit(new double[n + 1], "c", 104, 4820, 4856);
            final double[] d = CallChecker.varInit(new double[n], "d", 105, 4866, 4898);
            if (CallChecker.beforeDeref(z, double[].class, 107, 4909, 4909)) {
                CallChecker.isCalled(z, double[].class, 107, 4909, 4909)[n] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(z, double[].class, 107, 4909, 4909)[n], "CallChecker.isCalled(z, double[].class, 107, 4909, 4909)[n]", 107, 4909, 4918);
            }
            if (CallChecker.beforeDeref(c, double[].class, 108, 4928, 4928)) {
                CallChecker.isCalled(c, double[].class, 108, 4928, 4928)[n] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 108, 4928, 4928)[n], "CallChecker.isCalled(c, double[].class, 108, 4928, 4928)[n]", 108, 4928, 4937);
            }
            for (int j = n - 1; j >= 0; j--) {
                if (CallChecker.beforeDeref(c, double[].class, 111, 4993, 4993)) {
                    if (CallChecker.beforeDeref(z, double[].class, 111, 5000, 5000)) {
                        if (CallChecker.beforeDeref(mu, double[].class, 111, 5007, 5008)) {
                            if (CallChecker.beforeDeref(c, double[].class, 111, 5015, 5015)) {
                                CallChecker.isCalled(c, double[].class, 111, 4993, 4993)[j] = (CallChecker.isCalled(z, double[].class, 111, 5000, 5000)[j]) - ((CallChecker.isCalled(mu, double[].class, 111, 5007, 5008)[j]) * (CallChecker.isCalled(c, double[].class, 111, 5015, 5015)[(j + 1)]));
                                CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 111, 4993, 4993)[j], "CallChecker.isCalled(c, double[].class, 111, 4993, 4993)[j]", 111, 4993, 5023);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(b, double[].class, 112, 5037, 5037)) {
                    if (CallChecker.beforeDeref(y, double[].class, 112, 5045, 5045)) {
                        if (CallChecker.beforeDeref(y, double[].class, 112, 5056, 5056)) {
                            if (CallChecker.beforeDeref(h, double[].class, 112, 5064, 5064)) {
                                if (CallChecker.beforeDeref(h, double[].class, 112, 5071, 5071)) {
                                    if (CallChecker.beforeDeref(c, double[].class, 112, 5079, 5079)) {
                                        if (CallChecker.beforeDeref(c, double[].class, 112, 5095, 5095)) {
                                            y = CallChecker.beforeCalled(y, double[].class, 112, 5045, 5045);
                                            y = CallChecker.beforeCalled(y, double[].class, 112, 5056, 5056);
                                            CallChecker.isCalled(b, double[].class, 112, 5037, 5037)[j] = (((CallChecker.isCalled(y, double[].class, 112, 5045, 5045)[(j + 1)]) - (CallChecker.isCalled(y, double[].class, 112, 5056, 5056)[j])) / (CallChecker.isCalled(h, double[].class, 112, 5064, 5064)[j])) - (((CallChecker.isCalled(h, double[].class, 112, 5071, 5071)[j]) * ((CallChecker.isCalled(c, double[].class, 112, 5079, 5079)[(j + 1)]) + (2.0 * (CallChecker.isCalled(c, double[].class, 112, 5095, 5095)[j])))) / 3.0);
                                            CallChecker.varAssign(CallChecker.isCalled(b, double[].class, 112, 5037, 5037)[j], "CallChecker.isCalled(b, double[].class, 112, 5037, 5037)[j]", 112, 5037, 5105);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(d, double[].class, 113, 5119, 5119)) {
                    if (CallChecker.beforeDeref(c, double[].class, 113, 5127, 5127)) {
                        if (CallChecker.beforeDeref(c, double[].class, 113, 5138, 5138)) {
                            if (CallChecker.beforeDeref(h, double[].class, 113, 5152, 5152)) {
                                CallChecker.isCalled(d, double[].class, 113, 5119, 5119)[j] = ((CallChecker.isCalled(c, double[].class, 113, 5127, 5127)[(j + 1)]) - (CallChecker.isCalled(c, double[].class, 113, 5138, 5138)[j])) / (3.0 * (CallChecker.isCalled(h, double[].class, 113, 5152, 5152)[j]));
                                CallChecker.varAssign(CallChecker.isCalled(d, double[].class, 113, 5119, 5119)[j], "CallChecker.isCalled(d, double[].class, 113, 5119, 5119)[j]", 113, 5119, 5157);
                            }
                        }
                    }
                }
            }
            final PolynomialFunction[] polynomials = CallChecker.varInit(new PolynomialFunction[n], "polynomials", 116, 5178, 5244);
            final double[] coefficients = CallChecker.varInit(new double[4], "coefficients", 117, 5254, 5297);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 119, 5349, 5360)) {
                    if (CallChecker.beforeDeref(y, double[].class, 119, 5367, 5367)) {
                        y = CallChecker.beforeCalled(y, double[].class, 119, 5367, 5367);
                        CallChecker.isCalled(coefficients, double[].class, 119, 5349, 5360)[0] = CallChecker.isCalled(y, double[].class, 119, 5367, 5367)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 119, 5349, 5360)[0], "CallChecker.isCalled(coefficients, double[].class, 119, 5349, 5360)[0]", 119, 5349, 5371);
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 120, 5385, 5396)) {
                    if (CallChecker.beforeDeref(b, double[].class, 120, 5403, 5403)) {
                        CallChecker.isCalled(coefficients, double[].class, 120, 5385, 5396)[1] = CallChecker.isCalled(b, double[].class, 120, 5403, 5403)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 120, 5385, 5396)[1], "CallChecker.isCalled(coefficients, double[].class, 120, 5385, 5396)[1]", 120, 5385, 5407);
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 121, 5421, 5432)) {
                    if (CallChecker.beforeDeref(c, double[].class, 121, 5439, 5439)) {
                        CallChecker.isCalled(coefficients, double[].class, 121, 5421, 5432)[2] = CallChecker.isCalled(c, double[].class, 121, 5439, 5439)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 121, 5421, 5432)[2], "CallChecker.isCalled(coefficients, double[].class, 121, 5421, 5432)[2]", 121, 5421, 5443);
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 122, 5457, 5468)) {
                    if (CallChecker.beforeDeref(d, double[].class, 122, 5475, 5475)) {
                        CallChecker.isCalled(coefficients, double[].class, 122, 5457, 5468)[3] = CallChecker.isCalled(d, double[].class, 122, 5475, 5475)[i];
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 122, 5457, 5468)[3], "CallChecker.isCalled(coefficients, double[].class, 122, 5457, 5468)[3]", 122, 5457, 5479);
                    }
                }
                if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 123, 5493, 5503)) {
                    CallChecker.isCalled(polynomials, PolynomialFunction[].class, 123, 5493, 5503)[i] = new PolynomialFunction(coefficients);
                    CallChecker.varAssign(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 123, 5493, 5503)[i], "CallChecker.isCalled(polynomials, PolynomialFunction[].class, 123, 5493, 5503)[i]", 123, 5493, 5546);
                }
            }
            return new PolynomialSplineFunction(x, polynomials);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialSplineFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5397.methodEnd();
        }
    }
}

