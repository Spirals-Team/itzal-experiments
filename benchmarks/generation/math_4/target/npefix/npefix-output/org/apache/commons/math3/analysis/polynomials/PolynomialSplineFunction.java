package org.apache.commons.math3.analysis.polynomials;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

public class PolynomialSplineFunction implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    private final double[] knots;

    private final PolynomialFunction[] polynomials;

    private final int n;

    public PolynomialSplineFunction(double[] knots, PolynomialFunction[] polynomials) throws DimensionMismatchException, NonMonotonicSequenceException, NullArgumentException, NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context656 = new ConstructorContext(PolynomialSplineFunction.class, 102, 4107, 5865);
        try {
            if ((knots == null) || (polynomials == null)) {
                throw new NullArgumentException();
            }
            if ((knots.length) < 2) {
                throw new NumberIsTooSmallException(LocalizedFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, 2, knots.length, false);
            }
            if (((knots.length) - 1) != (polynomials.length)) {
                throw new DimensionMismatchException(polynomials.length, knots.length);
            }
            MathArrays.checkOrder(knots);
            this.n = (knots.length) - 1;
            CallChecker.varAssign(this.n, "this.n", 118, 5617, 5641);
            this.knots = new double[(n) + 1];
            CallChecker.varAssign(this.knots, "this.knots", 119, 5651, 5681);
            System.arraycopy(knots, 0, this.knots, 0, ((n) + 1));
            this.polynomials = new PolynomialFunction[n];
            CallChecker.varAssign(this.polynomials, "this.polynomials", 121, 5749, 5793);
            System.arraycopy(polynomials, 0, this.polynomials, 0, n);
        } finally {
            _bcornu_methode_context656.methodEnd();
        }
    }

    public double value(double v) {
        MethodContext _bcornu_methode_context2903 = new MethodContext(double.class, 136, 5872, 6929);
        try {
            CallChecker.varInit(this, "this", 136, 5872, 6929);
            CallChecker.varInit(v, "v", 136, 5872, 6929);
            CallChecker.varInit(this.n, "n", 136, 5872, 6929);
            CallChecker.varInit(this.polynomials, "polynomials", 136, 5872, 6929);
            CallChecker.varInit(this.knots, "knots", 136, 5872, 6929);
            if (CallChecker.beforeDeref(knots, double[].class, 137, 6392, 6396)) {
                if (CallChecker.beforeDeref(knots, double[].class, 137, 6408, 6412)) {
                    if ((v < (CallChecker.isCalled(knots, double[].class, 137, 6392, 6396)[0])) || (v > (CallChecker.isCalled(knots, double[].class, 137, 6408, 6412)[n]))) {
                        if (CallChecker.beforeDeref(knots, double[].class, 138, 6465, 6469)) {
                            if (CallChecker.beforeDeref(knots, double[].class, 138, 6475, 6479)) {
                                throw new OutOfRangeException(v, CallChecker.isCalled(knots, double[].class, 138, 6465, 6469)[0], CallChecker.isCalled(knots, double[].class, 138, 6475, 6479)[n]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int i = CallChecker.varInit(((int) (Arrays.binarySearch(this.knots, v))), "i", 140, 6504, 6541);
            if (i < 0) {
                i = (-i) - 2;
                CallChecker.varAssign(i, "i", 142, 6576, 6586);
            }
            if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 147, 6824, 6834)) {
                if (i >= (CallChecker.isCalled(polynomials, PolynomialFunction[].class, 147, 6824, 6834).length)) {
                    i--;
                }
            }
            if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 150, 6889, 6899)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 150, 6889, 6899)[i], PolynomialFunction.class, 150, 6889, 6902)) {
                    CallChecker.isCalled(polynomials, PolynomialFunction[].class, 150, 6889, 6899)[i] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 150, 6889, 6899)[i], PolynomialFunction.class, 150, 6889, 6902);
                    return CallChecker.isCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 150, 6889, 6899)[i], PolynomialFunction.class, 150, 6889, 6902).value((v - (CallChecker.isCalled(knots, double[].class, 150, 6914, 6918)[i])));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2903.methodEnd();
        }
    }

    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context2904 = new MethodContext(UnivariateFunction.class, 158, 6936, 7150);
        try {
            CallChecker.varInit(this, "this", 158, 6936, 7150);
            CallChecker.varInit(this.n, "n", 158, 6936, 7150);
            CallChecker.varInit(this.polynomials, "polynomials", 158, 6936, 7150);
            CallChecker.varInit(this.knots, "knots", 158, 6936, 7150);
            return polynomialSplineDerivative();
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2904.methodEnd();
        }
    }

    public PolynomialSplineFunction polynomialSplineDerivative() {
        MethodContext _bcornu_methode_context2905 = new MethodContext(PolynomialSplineFunction.class, 167, 7157, 7629);
        try {
            CallChecker.varInit(this, "this", 167, 7157, 7629);
            CallChecker.varInit(this.n, "n", 167, 7157, 7629);
            CallChecker.varInit(this.polynomials, "polynomials", 167, 7157, 7629);
            CallChecker.varInit(this.knots, "knots", 167, 7157, 7629);
            PolynomialFunction[] derivativePolynomials = CallChecker.varInit(new PolynomialFunction[n], "derivativePolynomials", 168, 7352, 7422);
            for (int i = 0; i < (n); i++) {
                if (CallChecker.beforeDeref(derivativePolynomials, PolynomialFunction[].class, 170, 7474, 7494)) {
                    if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 170, 7501, 7511)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 170, 7501, 7511)[i], PolynomialFunction.class, 170, 7501, 7514)) {
                            derivativePolynomials = CallChecker.beforeCalled(derivativePolynomials, PolynomialFunction[].class, 170, 7474, 7494);
                            CallChecker.isCalled(polynomials, PolynomialFunction[].class, 170, 7501, 7511)[i] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 170, 7501, 7511)[i], PolynomialFunction.class, 170, 7501, 7514);
                            CallChecker.isCalled(derivativePolynomials, PolynomialFunction[].class, 170, 7474, 7494)[i] = CallChecker.isCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 170, 7501, 7511)[i], PolynomialFunction.class, 170, 7501, 7514).polynomialDerivative();
                            CallChecker.varAssign(CallChecker.isCalled(derivativePolynomials, PolynomialFunction[].class, 170, 7474, 7494)[i], "CallChecker.isCalled(derivativePolynomials, PolynomialFunction[].class, 170, 7474, 7494)[i]", 170, 7474, 7538);
                        }
                    }
                }
            }
            return new PolynomialSplineFunction(knots, derivativePolynomials);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialSplineFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2905.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context2906 = new MethodContext(DerivativeStructure.class, 179, 7637, 8354);
        try {
            CallChecker.varInit(this, "this", 179, 7637, 8354);
            CallChecker.varInit(t, "t", 179, 7637, 8354);
            CallChecker.varInit(this.n, "n", 179, 7637, 8354);
            CallChecker.varInit(this.polynomials, "polynomials", 179, 7637, 8354);
            CallChecker.varInit(this.knots, "knots", 179, 7637, 8354);
            final double t0 = CallChecker.varInit(((double) (CallChecker.isCalled(t, DerivativeStructure.class, 180, 7775, 7775).getValue())), "t0", 180, 7757, 7787);
            if (CallChecker.beforeDeref(knots, double[].class, 181, 7806, 7810)) {
                if (CallChecker.beforeDeref(knots, double[].class, 181, 7823, 7827)) {
                    if ((t0 < (CallChecker.isCalled(knots, double[].class, 181, 7806, 7810)[0])) || (t0 > (CallChecker.isCalled(knots, double[].class, 181, 7823, 7827)[n]))) {
                        if (CallChecker.beforeDeref(knots, double[].class, 182, 7881, 7885)) {
                            if (CallChecker.beforeDeref(knots, double[].class, 182, 7891, 7895)) {
                                throw new OutOfRangeException(t0, CallChecker.isCalled(knots, double[].class, 182, 7881, 7885)[0], CallChecker.isCalled(knots, double[].class, 182, 7891, 7895)[n]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int i = CallChecker.varInit(((int) (Arrays.binarySearch(this.knots, t0))), "i", 184, 7920, 7958);
            if (i < 0) {
                i = (-i) - 2;
                CallChecker.varAssign(i, "i", 186, 7993, 8003);
            }
            if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 191, 8241, 8251)) {
                if (i >= (CallChecker.isCalled(polynomials, PolynomialFunction[].class, 191, 8241, 8251).length)) {
                    i--;
                }
            }
            if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 194, 8306, 8316)) {
                if (CallChecker.beforeDeref(knots, double[].class, 194, 8338, 8342)) {
                    if (CallChecker.beforeDeref(t, DerivativeStructure.class, 194, 8327, 8327)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 194, 8306, 8316)[i], PolynomialFunction.class, 194, 8306, 8319)) {
                            CallChecker.isCalled(polynomials, PolynomialFunction[].class, 194, 8306, 8316)[i] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 194, 8306, 8316)[i], PolynomialFunction.class, 194, 8306, 8319);
                            return CallChecker.isCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 194, 8306, 8316)[i], PolynomialFunction.class, 194, 8306, 8319).value(CallChecker.isCalled(t, DerivativeStructure.class, 194, 8327, 8327).subtract(CallChecker.isCalled(knots, double[].class, 194, 8338, 8342)[i]));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2906.methodEnd();
        }
    }

    public int getN() {
        MethodContext _bcornu_methode_context2907 = new MethodContext(int.class, 203, 8361, 8593);
        try {
            CallChecker.varInit(this, "this", 203, 8361, 8593);
            CallChecker.varInit(this.n, "n", 203, 8361, 8593);
            CallChecker.varInit(this.polynomials, "polynomials", 203, 8361, 8593);
            CallChecker.varInit(this.knots, "knots", 203, 8361, 8593);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2907.methodEnd();
        }
    }

    public PolynomialFunction[] getPolynomials() {
        MethodContext _bcornu_methode_context2908 = new MethodContext(PolynomialFunction[].class, 214, 8600, 9026);
        try {
            CallChecker.varInit(this, "this", 214, 8600, 9026);
            CallChecker.varInit(this.n, "n", 214, 8600, 9026);
            CallChecker.varInit(this.polynomials, "polynomials", 214, 8600, 9026);
            CallChecker.varInit(this.knots, "knots", 214, 8600, 9026);
            PolynomialFunction[] p = CallChecker.varInit(new PolynomialFunction[n], "p", 215, 8901, 8951);
            System.arraycopy(polynomials, 0, p, 0, n);
            return p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2908.methodEnd();
        }
    }

    public double[] getKnots() {
        MethodContext _bcornu_methode_context2909 = new MethodContext(double[].class, 227, 9033, 9392);
        try {
            CallChecker.varInit(this, "this", 227, 9033, 9392);
            CallChecker.varInit(this.n, "n", 227, 9033, 9392);
            CallChecker.varInit(this.polynomials, "polynomials", 227, 9033, 9392);
            CallChecker.varInit(this.knots, "knots", 227, 9033, 9392);
            double[] out = CallChecker.varInit(new double[(n) + 1], "out", 228, 9283, 9315);
            System.arraycopy(knots, 0, out, 0, ((n) + 1));
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2909.methodEnd();
        }
    }
}

