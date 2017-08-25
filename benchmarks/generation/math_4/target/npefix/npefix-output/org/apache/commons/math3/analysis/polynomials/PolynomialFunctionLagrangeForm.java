package org.apache.commons.math3.analysis.polynomials;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import static org.apache.commons.math3.util.MathArrays.OrderDirection.INCREASING;

public class PolynomialFunctionLagrangeForm implements UnivariateFunction {
    private double[] coefficients;

    private final double[] x;

    private final double[] y;

    private boolean coefficientsComputed;

    public PolynomialFunctionLagrangeForm(double[] x, double[] y) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context15 = new ConstructorContext(PolynomialFunctionLagrangeForm.class, 72, 2381, 3610);
        try {
            x = CallChecker.beforeCalled(x, double[].class, 74, 3170, 3170);
            this.x = new double[CallChecker.isCalled(x, double[].class, 74, 3170, 3170).length];
            CallChecker.varAssign(this.x, "this.x", 74, 3150, 3179);
            y = CallChecker.beforeCalled(y, double[].class, 75, 3209, 3209);
            this.y = new double[CallChecker.isCalled(y, double[].class, 75, 3209, 3209).length];
            CallChecker.varAssign(this.y, "this.y", 75, 3189, 3218);
            if (CallChecker.beforeDeref(x, double[].class, 76, 3262, 3262)) {
                x = CallChecker.beforeCalled(x, double[].class, 76, 3262, 3262);
                System.arraycopy(x, 0, this.x, 0, CallChecker.isCalled(x, double[].class, 76, 3262, 3262).length);
            }
            if (CallChecker.beforeDeref(y, double[].class, 77, 3315, 3315)) {
                y = CallChecker.beforeCalled(y, double[].class, 77, 3315, 3315);
                System.arraycopy(y, 0, this.y, 0, CallChecker.isCalled(y, double[].class, 77, 3315, 3315).length);
            }
            coefficientsComputed = false;
            CallChecker.varAssign(this.coefficientsComputed, "this.coefficientsComputed", 78, 3334, 3362);
            if (!(PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y, false))) {
                MathArrays.sortInPlace(this.x, this.y);
                PolynomialFunctionLagrangeForm.verifyInterpolationArray(this.x, this.y, true);
            }
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public double value(double z) {
        MethodContext _bcornu_methode_context66 = new MethodContext(double.class, 99, 3617, 4211);
        try {
            CallChecker.varInit(this, "this", 99, 3617, 4211);
            CallChecker.varInit(z, "z", 99, 3617, 4211);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 99, 3617, 4211);
            CallChecker.varInit(this.y, "y", 99, 3617, 4211);
            CallChecker.varInit(this.x, "x", 99, 3617, 4211);
            CallChecker.varInit(this.coefficients, "coefficients", 99, 3617, 4211);
            return PolynomialFunctionLagrangeForm.evaluateInternal(x, y, z);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public int degree() {
        MethodContext _bcornu_methode_context67 = new MethodContext(int.class, 108, 4218, 4385);
        try {
            CallChecker.varInit(this, "this", 108, 4218, 4385);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 108, 4218, 4385);
            CallChecker.varInit(this.y, "y", 108, 4218, 4385);
            CallChecker.varInit(this.x, "x", 108, 4218, 4385);
            CallChecker.varInit(this.coefficients, "coefficients", 108, 4218, 4385);
            return (CallChecker.isCalled(x, double[].class, 109, 4367, 4367).length) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    public double[] getInterpolatingPoints() {
        MethodContext _bcornu_methode_context68 = new MethodContext(double[].class, 119, 4392, 4784);
        try {
            CallChecker.varInit(this, "this", 119, 4392, 4784);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 119, 4392, 4784);
            CallChecker.varInit(this.y, "y", 119, 4392, 4784);
            CallChecker.varInit(this.x, "x", 119, 4392, 4784);
            CallChecker.varInit(this.coefficients, "coefficients", 119, 4392, 4784);
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(x, double[].class, 120, 4699, 4699)) {
                out = new double[CallChecker.isCalled(x, double[].class, 120, 4699, 4699).length];
                CallChecker.varAssign(out, "out", 120, 4699, 4699);
            }
            if (CallChecker.beforeDeref(x, double[].class, 121, 4749, 4749)) {
                System.arraycopy(x, 0, out, 0, CallChecker.isCalled(x, double[].class, 121, 4749, 4749).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public double[] getInterpolatingValues() {
        MethodContext _bcornu_methode_context69 = new MethodContext(double[].class, 132, 4791, 5183);
        try {
            CallChecker.varInit(this, "this", 132, 4791, 5183);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 132, 4791, 5183);
            CallChecker.varInit(this.y, "y", 132, 4791, 5183);
            CallChecker.varInit(this.x, "x", 132, 4791, 5183);
            CallChecker.varInit(this.coefficients, "coefficients", 132, 4791, 5183);
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(y, double[].class, 133, 5098, 5098)) {
                out = new double[CallChecker.isCalled(y, double[].class, 133, 5098, 5098).length];
                CallChecker.varAssign(out, "out", 133, 5098, 5098);
            }
            if (CallChecker.beforeDeref(y, double[].class, 134, 5148, 5148)) {
                System.arraycopy(y, 0, out, 0, CallChecker.isCalled(y, double[].class, 134, 5148, 5148).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public double[] getCoefficients() {
        MethodContext _bcornu_methode_context70 = new MethodContext(double[].class, 148, 5190, 5810);
        try {
            CallChecker.varInit(this, "this", 148, 5190, 5810);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 148, 5190, 5810);
            CallChecker.varInit(this.y, "y", 148, 5190, 5810);
            CallChecker.varInit(this.x, "x", 148, 5190, 5810);
            CallChecker.varInit(this.coefficients, "coefficients", 148, 5190, 5810);
            if (!(coefficientsComputed)) {
                computeCoefficients();
            }
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 152, 5692, 5703)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 152, 5692, 5703);
                out = new double[CallChecker.isCalled(coefficients, double[].class, 152, 5692, 5703).length];
                CallChecker.varAssign(out, "out", 152, 5692, 5703);
            }
            if (CallChecker.beforeDeref(coefficients, double[].class, 153, 5764, 5775)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 153, 5764, 5775);
                System.arraycopy(coefficients, 0, out, 0, CallChecker.isCalled(coefficients, double[].class, 153, 5764, 5775).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public static double evaluate(double[] x, double[] y, double z) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context71 = new MethodContext(double.class, 173, 5817, 7224);
        try {
            CallChecker.varInit(z, "z", 173, 5817, 7224);
            CallChecker.varInit(y, "y", 173, 5817, 7224);
            CallChecker.varInit(x, "x", 173, 5817, 7224);
            if (PolynomialFunctionLagrangeForm.verifyInterpolationArray(x, y, false)) {
                return PolynomialFunctionLagrangeForm.evaluateInternal(x, y, z);
            }
            x = CallChecker.beforeCalled(x, double[].class, 180, 6849, 6849);
            final double[] xNew = CallChecker.varInit(new double[CallChecker.isCalled(x, double[].class, 180, 6849, 6849).length], "xNew", 180, 6816, 6858);
            y = CallChecker.beforeCalled(y, double[].class, 181, 6901, 6901);
            final double[] yNew = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 181, 6901, 6901).length], "yNew", 181, 6868, 6910);
            if (CallChecker.beforeDeref(x, double[].class, 182, 6952, 6952)) {
                x = CallChecker.beforeCalled(x, double[].class, 182, 6952, 6952);
                System.arraycopy(x, 0, xNew, 0, CallChecker.isCalled(x, double[].class, 182, 6952, 6952).length);
            }
            if (CallChecker.beforeDeref(y, double[].class, 183, 7003, 7003)) {
                y = CallChecker.beforeCalled(y, double[].class, 183, 7003, 7003);
                System.arraycopy(y, 0, yNew, 0, CallChecker.isCalled(y, double[].class, 183, 7003, 7003).length);
            }
            MathArrays.sortInPlace(xNew, yNew);
            PolynomialFunctionLagrangeForm.verifyInterpolationArray(xNew, yNew, true);
            return PolynomialFunctionLagrangeForm.evaluateInternal(xNew, yNew, z);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    private static double evaluateInternal(double[] x, double[] y, double z) {
        MethodContext _bcornu_methode_context72 = new MethodContext(double.class, 207, 7231, 9397);
        try {
            CallChecker.varInit(z, "z", 207, 7231, 9397);
            CallChecker.varInit(y, "y", 207, 7231, 9397);
            CallChecker.varInit(x, "x", 207, 7231, 9397);
            int nearest = CallChecker.varInit(((int) (0)), "nearest", 208, 8032, 8047);
            x = CallChecker.beforeCalled(x, double[].class, 209, 8071, 8071);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 209, 8071, 8071).length)), "n", 209, 8057, 8079);
            final double[] c = CallChecker.varInit(new double[n], "c", 210, 8089, 8121);
            final double[] d = CallChecker.varInit(new double[n], "d", 211, 8131, 8163);
            double min_dist = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "min_dist", 212, 8173, 8215);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(c, double[].class, 215, 8315, 8315)) {
                    if (CallChecker.beforeDeref(y, double[].class, 215, 8322, 8322)) {
                        y = CallChecker.beforeCalled(y, double[].class, 215, 8322, 8322);
                        CallChecker.isCalled(c, double[].class, 215, 8315, 8315)[i] = CallChecker.isCalled(y, double[].class, 215, 8322, 8322)[i];
                        CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 215, 8315, 8315)[i], "CallChecker.isCalled(c, double[].class, 215, 8315, 8315)[i]", 215, 8315, 8326);
                    }
                }
                if (CallChecker.beforeDeref(d, double[].class, 216, 8340, 8340)) {
                    if (CallChecker.beforeDeref(y, double[].class, 216, 8347, 8347)) {
                        y = CallChecker.beforeCalled(y, double[].class, 216, 8347, 8347);
                        CallChecker.isCalled(d, double[].class, 216, 8340, 8340)[i] = CallChecker.isCalled(y, double[].class, 216, 8347, 8347)[i];
                        CallChecker.varAssign(CallChecker.isCalled(d, double[].class, 216, 8340, 8340)[i], "CallChecker.isCalled(d, double[].class, 216, 8340, 8340)[i]", 216, 8340, 8351);
                    }
                }
                x = CallChecker.beforeCalled(x, double[].class, 218, 8452, 8452);
                final double dist = CallChecker.varInit(((double) (FastMath.abs((z - (CallChecker.isCalled(x, double[].class, 218, 8452, 8452)[i]))))), "dist", 218, 8365, 8457);
                if (dist < min_dist) {
                    nearest = i;
                    CallChecker.varAssign(nearest, "nearest", 220, 8510, 8521);
                    min_dist = dist;
                    CallChecker.varAssign(min_dist, "min_dist", 221, 8539, 8554);
                }
            }
            double value = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(y, double[].class, 226, 8664, 8664)) {
                y = CallChecker.beforeCalled(y, double[].class, 226, 8664, 8664);
                value = CallChecker.isCalled(y, double[].class, 226, 8664, 8664)[nearest];
                CallChecker.varAssign(value, "value", 226, 8664, 8664);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < (n - i); j++) {
                    x = CallChecker.beforeCalled(x, double[].class, 230, 8793, 8793);
                    final double tc = CallChecker.varInit(((double) ((CallChecker.isCalled(x, double[].class, 230, 8793, 8793)[j]) - z)), "tc", 230, 8775, 8801);
                    x = CallChecker.beforeCalled(x, double[].class, 231, 8837, 8837);
                    final double td = CallChecker.varInit(((double) ((CallChecker.isCalled(x, double[].class, 231, 8837, 8837)[(i + j)]) - z)), "td", 231, 8819, 8847);
                    x = CallChecker.beforeCalled(x, double[].class, 232, 8888, 8888);
                    x = CallChecker.beforeCalled(x, double[].class, 232, 8895, 8895);
                    final double divider = CallChecker.varInit(((double) ((CallChecker.isCalled(x, double[].class, 232, 8888, 8888)[j]) - (CallChecker.isCalled(x, double[].class, 232, 8895, 8895)[(i + j)]))), "divider", 232, 8865, 8901);
                    final double w = CallChecker.varInit(((double) (((CallChecker.isCalled(c, double[].class, 234, 8985, 8985)[(j + 1)]) - (CallChecker.isCalled(d, double[].class, 234, 8994, 8994)[j])) / divider)), "w", 234, 8919, 9009);
                    if (CallChecker.beforeDeref(c, double[].class, 235, 9027, 9027)) {
                        CallChecker.isCalled(c, double[].class, 235, 9027, 9027)[j] = tc * w;
                        CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 235, 9027, 9027)[j], "CallChecker.isCalled(c, double[].class, 235, 9027, 9027)[j]", 235, 9027, 9040);
                    }
                    if (CallChecker.beforeDeref(d, double[].class, 236, 9058, 9058)) {
                        CallChecker.isCalled(d, double[].class, 236, 9058, 9058)[j] = td * w;
                        CallChecker.varAssign(CallChecker.isCalled(d, double[].class, 236, 9058, 9058)[j], "CallChecker.isCalled(d, double[].class, 236, 9058, 9058)[j]", 236, 9058, 9071);
                    }
                }
                if (nearest < (0.5 * ((n - i) + 1))) {
                    if (CallChecker.beforeDeref(c, double[].class, 240, 9219, 9219)) {
                        value += CallChecker.isCalled(c, double[].class, 240, 9219, 9219)[nearest];
                        CallChecker.varAssign(value, "value", 240, 9210, 9229);
                    }
                }else {
                    nearest--;
                    if (CallChecker.beforeDeref(d, double[].class, 243, 9320, 9320)) {
                        value += CallChecker.isCalled(d, double[].class, 243, 9320, 9320)[nearest];
                        CallChecker.varAssign(value, "value", 243, 9311, 9330);
                    }
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    protected void computeCoefficients() {
        MethodContext _bcornu_methode_context73 = new MethodContext(void.class, 256, 9404, 11090);
        try {
            CallChecker.varInit(this, "this", 256, 9404, 11090);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 256, 9404, 11090);
            CallChecker.varInit(this.y, "y", 256, 9404, 11090);
            CallChecker.varInit(this.x, "x", 256, 9404, 11090);
            CallChecker.varInit(this.coefficients, "coefficients", 256, 9404, 11090);
            final int n = CallChecker.varInit(((int) ((degree()) + 1)), "n", 257, 9695, 9721);
            coefficients = new double[n];
            CallChecker.varAssign(this.coefficients, "this.coefficients", 258, 9731, 9759);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 260, 9811, 9822)) {
                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 260, 9811, 9822);
                    CallChecker.isCalled(coefficients, double[].class, 260, 9811, 9822)[i] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 260, 9811, 9822)[i], "CallChecker.isCalled(this.coefficients, double[].class, 260, 9811, 9822)[i]", 260, 9811, 9832);
                }
            }
            final double[] c = CallChecker.varInit(new double[n + 1], "c", 264, 9929, 9963);
            if (CallChecker.beforeDeref(c, double[].class, 265, 9973, 9973)) {
                CallChecker.isCalled(c, double[].class, 265, 9973, 9973)[0] = 1.0;
                CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 265, 9973, 9973)[0], "CallChecker.isCalled(c, double[].class, 265, 9973, 9973)[0]", 265, 9973, 9983);
            }
            for (int i = 0; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (CallChecker.beforeDeref(c, double[].class, 268, 10081, 10081)) {
                        if (CallChecker.beforeDeref(c, double[].class, 268, 10088, 10088)) {
                            if (CallChecker.beforeDeref(c, double[].class, 268, 10097, 10097)) {
                                if (CallChecker.beforeDeref(x, double[].class, 268, 10104, 10104)) {
                                    CallChecker.isCalled(c, double[].class, 268, 10081, 10081)[j] = (CallChecker.isCalled(c, double[].class, 268, 10088, 10088)[(j - 1)]) - ((CallChecker.isCalled(c, double[].class, 268, 10097, 10097)[j]) * (CallChecker.isCalled(x, double[].class, 268, 10104, 10104)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 268, 10081, 10081)[j], "CallChecker.isCalled(c, double[].class, 268, 10081, 10081)[j]", 268, 10081, 10108);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(c, double[].class, 270, 10136, 10136)) {
                    if (CallChecker.beforeDeref(x, double[].class, 270, 10145, 10145)) {
                        CallChecker.isCalled(c, double[].class, 270, 10136, 10136)[0] *= -(CallChecker.isCalled(x, double[].class, 270, 10145, 10145)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 270, 10136, 10136)[0], "CallChecker.isCalled(c, double[].class, 270, 10136, 10136)[0]", 270, 10136, 10149);
                    }
                }
                if (CallChecker.beforeDeref(c, double[].class, 271, 10163, 10163)) {
                    CallChecker.isCalled(c, double[].class, 271, 10163, 10163)[(i + 1)] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(c, double[].class, 271, 10163, 10163)[(i + 1)], "CallChecker.isCalled(c, double[].class, 271, 10163, 10163)[(i + 1)]", 271, 10163, 10173);
                }
            }
            final double[] tc = CallChecker.varInit(new double[n], "tc", 274, 10194, 10227);
            for (int i = 0; i < n; i++) {
                double d = CallChecker.varInit(((double) (1)), "d", 277, 10355, 10367);
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (CallChecker.beforeDeref(x, double[].class, 280, 10466, 10466)) {
                            if (CallChecker.beforeDeref(x, double[].class, 280, 10473, 10473)) {
                                d *= (CallChecker.isCalled(x, double[].class, 280, 10466, 10466)[i]) - (CallChecker.isCalled(x, double[].class, 280, 10473, 10473)[j]);
                                CallChecker.varAssign(d, "d", 280, 10461, 10477);
                            }
                        }
                    }
                }
                final double t = CallChecker.varInit(((double) ((CallChecker.isCalled(this.y, double[].class, 283, 10540, 10540)[i]) / d)), "t", 283, 10523, 10548);
                if (CallChecker.beforeDeref(tc, double[].class, 287, 10797, 10798)) {
                    if (CallChecker.beforeDeref(c, double[].class, 287, 10807, 10807)) {
                        CallChecker.isCalled(tc, double[].class, 287, 10797, 10798)[(n - 1)] = CallChecker.isCalled(c, double[].class, 287, 10807, 10807)[n];
                        CallChecker.varAssign(CallChecker.isCalled(tc, double[].class, 287, 10797, 10798)[(n - 1)], "CallChecker.isCalled(tc, double[].class, 287, 10797, 10798)[(n - 1)]", 287, 10797, 10811);
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 288, 10850, 10861)) {
                    if (CallChecker.beforeDeref(tc, double[].class, 288, 10875, 10876)) {
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 288, 10850, 10861);
                        CallChecker.isCalled(coefficients, double[].class, 288, 10850, 10861)[(n - 1)] += t * (CallChecker.isCalled(tc, double[].class, 288, 10875, 10876)[(n - 1)]);
                        CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 288, 10850, 10861)[(n - 1)], "CallChecker.isCalled(this.coefficients, double[].class, 288, 10850, 10861)[(n - 1)]", 288, 10850, 10882);
                    }
                }
                for (int j = n - 2; j >= 0; j--) {
                    if (CallChecker.beforeDeref(tc, double[].class, 290, 10945, 10946)) {
                        if (CallChecker.beforeDeref(c, double[].class, 290, 10953, 10953)) {
                            if (CallChecker.beforeDeref(tc, double[].class, 290, 10962, 10963)) {
                                if (CallChecker.beforeDeref(x, double[].class, 290, 10972, 10972)) {
                                    CallChecker.isCalled(tc, double[].class, 290, 10945, 10946)[j] = (CallChecker.isCalled(c, double[].class, 290, 10953, 10953)[(j + 1)]) + ((CallChecker.isCalled(tc, double[].class, 290, 10962, 10963)[(j + 1)]) * (CallChecker.isCalled(x, double[].class, 290, 10972, 10972)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(tc, double[].class, 290, 10945, 10946)[j], "CallChecker.isCalled(tc, double[].class, 290, 10945, 10946)[j]", 290, 10945, 10976);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(coefficients, double[].class, 291, 10994, 11005)) {
                        if (CallChecker.beforeDeref(tc, double[].class, 291, 11017, 11018)) {
                            coefficients = CallChecker.beforeCalled(coefficients, double[].class, 291, 10994, 11005);
                            CallChecker.isCalled(coefficients, double[].class, 291, 10994, 11005)[j] += t * (CallChecker.isCalled(tc, double[].class, 291, 11017, 11018)[j]);
                            CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 291, 10994, 11005)[j], "CallChecker.isCalled(this.coefficients, double[].class, 291, 10994, 11005)[j]", 291, 10994, 11022);
                        }
                    }
                }
            }
            coefficientsComputed = true;
            CallChecker.varAssign(this.coefficientsComputed, "this.coefficientsComputed", 295, 11057, 11084);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public static boolean verifyInterpolationArray(double[] x, double[] y, boolean abort) throws DimensionMismatchException, NonMonotonicSequenceException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context74 = new MethodContext(boolean.class, 316, 11097, 12559);
        try {
            CallChecker.varInit(abort, "abort", 316, 11097, 12559);
            CallChecker.varInit(y, "y", 316, 11097, 12559);
            CallChecker.varInit(x, "x", 316, 11097, 12559);
            if (CallChecker.beforeDeref(x, double[].class, 318, 12211, 12211)) {
                if (CallChecker.beforeDeref(y, double[].class, 318, 12223, 12223)) {
                    x = CallChecker.beforeCalled(x, double[].class, 318, 12211, 12211);
                    y = CallChecker.beforeCalled(y, double[].class, 318, 12223, 12223);
                    if ((CallChecker.isCalled(x, double[].class, 318, 12211, 12211).length) != (CallChecker.isCalled(y, double[].class, 318, 12223, 12223).length)) {
                        if (CallChecker.beforeDeref(x, double[].class, 319, 12284, 12284)) {
                            if (CallChecker.beforeDeref(y, double[].class, 319, 12294, 12294)) {
                                x = CallChecker.beforeCalled(x, double[].class, 319, 12284, 12284);
                                y = CallChecker.beforeCalled(y, double[].class, 319, 12294, 12294);
                                throw new DimensionMismatchException(CallChecker.isCalled(x, double[].class, 319, 12284, 12284).length, CallChecker.isCalled(y, double[].class, 319, 12294, 12294).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, double[].class, 321, 12327, 12327)) {
                x = CallChecker.beforeCalled(x, double[].class, 321, 12327, 12327);
                if ((CallChecker.isCalled(x, double[].class, 321, 12327, 12327).length) < 2) {
                    if (CallChecker.beforeDeref(x, double[].class, 322, 12435, 12435)) {
                        x = CallChecker.beforeCalled(x, double[].class, 322, 12435, 12435);
                        throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 2, CallChecker.isCalled(x, double[].class, 322, 12435, 12435).length, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return MathArrays.checkOrder(x, INCREASING, true, abort);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }
}

