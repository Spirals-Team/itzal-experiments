package org.apache.commons.math3.transform;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

public class FastSineTransformer implements Serializable , RealTransformer {
    static final long serialVersionUID = 20120211L;

    private final DstNormalization normalization;

    public FastSineTransformer(final DstNormalization normalization) {
        ConstructorContext _bcornu_methode_context1011 = new ConstructorContext(FastSineTransformer.class, 84, 3692, 4007);
        try {
            this.normalization = normalization;
            CallChecker.varAssign(this.normalization, "this.normalization", 85, 3967, 4001);
        } finally {
            _bcornu_methode_context1011.methodEnd();
        }
    }

    public double[] transform(final double[] f, final TransformType type) {
        MethodContext _bcornu_methode_context4526 = new MethodContext(double[].class, 96, 4014, 4749);
        try {
            CallChecker.varInit(this, "this", 96, 4014, 4749);
            CallChecker.varInit(type, "type", 96, 4014, 4749);
            CallChecker.varInit(f, "f", 96, 4014, 4749);
            CallChecker.varInit(this.normalization, "normalization", 96, 4014, 4749);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastSineTransformer.serialVersionUID", 96, 4014, 4749);
            if ((normalization) == (DstNormalization.ORTHOGONAL_DST_I)) {
                final double s = CallChecker.varInit(((double) (FastMath.sqrt((2.0 / (CallChecker.isCalled(f, double[].class, 98, 4491, 4491).length))))), "s", 98, 4454, 4500);
                return TransformUtils.scaleArray(fst(f), s);
            }
            if (type == (TransformType.FORWARD)) {
                return fst(f);
            }
            final double s = CallChecker.varInit(((double) (2.0 / (CallChecker.isCalled(f, double[].class, 104, 4682, 4682).length))), "s", 104, 4659, 4690);
            return TransformUtils.scaleArray(fst(f), s);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4526.methodEnd();
        }
    }

    public double[] transform(final UnivariateFunction f, final double min, final double max, final int n, final TransformType type) {
        MethodContext _bcornu_methode_context4527 = new MethodContext(double[].class, 119, 4756, 5544);
        try {
            CallChecker.varInit(this, "this", 119, 4756, 5544);
            CallChecker.varInit(type, "type", 119, 4756, 5544);
            CallChecker.varInit(n, "n", 119, 4756, 5544);
            CallChecker.varInit(max, "max", 119, 4756, 5544);
            CallChecker.varInit(min, "min", 119, 4756, 5544);
            CallChecker.varInit(f, "f", 119, 4756, 5544);
            CallChecker.varInit(this.normalization, "normalization", 119, 4756, 5544);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastSineTransformer.serialVersionUID", 119, 4756, 5544);
            final double[] data = CallChecker.varInit(FunctionUtils.sample(f, min, max, n), "data", 123, 5419, 5477);
            if (CallChecker.beforeDeref(data, double[].class, 124, 5487, 5490)) {
                CallChecker.isCalled(data, double[].class, 124, 5487, 5490)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(data, double[].class, 124, 5487, 5490)[0], "CallChecker.isCalled(data, double[].class, 124, 5487, 5490)[0]", 124, 5487, 5500);
            }
            return transform(data, type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4527.methodEnd();
        }
    }

    protected double[] fst(double[] f) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4528 = new MethodContext(double[].class, 137, 5551, 7633);
        try {
            CallChecker.varInit(this, "this", 137, 5551, 7633);
            CallChecker.varInit(f, "f", 137, 5551, 7633);
            CallChecker.varInit(this.normalization, "normalization", 137, 5551, 7633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastSineTransformer.serialVersionUID", 137, 5551, 7633);
            f = CallChecker.beforeCalled(f, double[].class, 139, 6075, 6075);
            final double[] transformed = CallChecker.varInit(new double[CallChecker.isCalled(f, double[].class, 139, 6075, 6075).length], "transformed", 139, 6035, 6084);
            if (CallChecker.beforeDeref(f, double[].class, 141, 6129, 6129)) {
                f = CallChecker.beforeCalled(f, double[].class, 141, 6129, 6129);
                if (!(ArithmeticUtils.isPowerOfTwo(CallChecker.isCalled(f, double[].class, 141, 6129, 6129).length))) {
                    if (CallChecker.beforeDeref(f, double[].class, 144, 6302, 6302)) {
                        f = CallChecker.beforeCalled(f, double[].class, 144, 6302, 6302);
                        throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, Integer.valueOf(CallChecker.isCalled(f, double[].class, 144, 6302, 6302).length));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(f, double[].class, 146, 6336, 6336)) {
                f = CallChecker.beforeCalled(f, double[].class, 146, 6336, 6336);
                if ((CallChecker.isCalled(f, double[].class, 146, 6336, 6336)[0]) != 0.0) {
                    if (CallChecker.beforeDeref(f, double[].class, 149, 6499, 6499)) {
                        f = CallChecker.beforeCalled(f, double[].class, 149, 6499, 6499);
                        throw new MathIllegalArgumentException(LocalizedFormats.FIRST_ELEMENT_NOT_ZERO, Double.valueOf(CallChecker.isCalled(f, double[].class, 149, 6499, 6499)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            f = CallChecker.beforeCalled(f, double[].class, 151, 6539, 6539);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(f, double[].class, 151, 6539, 6539).length)), "n", 151, 6525, 6547);
            if (n == 1) {
                if (CallChecker.beforeDeref(transformed, double[].class, 153, 6605, 6615)) {
                    CallChecker.isCalled(transformed, double[].class, 153, 6605, 6615)[0] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 153, 6605, 6615)[0], "CallChecker.isCalled(transformed, double[].class, 153, 6605, 6615)[0]", 153, 6605, 6625);
                }
                return transformed;
            }
            final double[] x = CallChecker.varInit(new double[n], "x", 158, 6733, 6765);
            if (CallChecker.beforeDeref(x, double[].class, 159, 6775, 6775)) {
                CallChecker.isCalled(x, double[].class, 159, 6775, 6775)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 159, 6775, 6775)[0], "CallChecker.isCalled(x, double[].class, 159, 6775, 6775)[0]", 159, 6775, 6785);
            }
            if (CallChecker.beforeDeref(x, double[].class, 160, 6795, 6795)) {
                if (CallChecker.beforeDeref(f, double[].class, 160, 6813, 6813)) {
                    f = CallChecker.beforeCalled(f, double[].class, 160, 6813, 6813);
                    CallChecker.isCalled(x, double[].class, 160, 6795, 6795)[(n >> 1)] = 2.0 * (CallChecker.isCalled(f, double[].class, 160, 6813, 6813)[(n >> 1)]);
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 160, 6795, 6795)[(n >> 1)], "CallChecker.isCalled(x, double[].class, 160, 6795, 6795)[(n >> 1)]", 160, 6795, 6822);
                }
            }
            for (int i = 1; i < (n >> 1); i++) {
                f = CallChecker.beforeCalled(f, double[].class, 162, 6935, 6935);
                f = CallChecker.beforeCalled(f, double[].class, 162, 6942, 6942);
                final double a = CallChecker.varInit(((double) ((FastMath.sin(((i * (FastMath.PI)) / n))) * ((CallChecker.isCalled(f, double[].class, 162, 6935, 6935)[i]) + (CallChecker.isCalled(f, double[].class, 162, 6942, 6942)[(n - i)])))), "a", 162, 6881, 6951);
                f = CallChecker.beforeCalled(f, double[].class, 163, 6989, 6989);
                f = CallChecker.beforeCalled(f, double[].class, 163, 6996, 6996);
                final double b = CallChecker.varInit(((double) (0.5 * ((CallChecker.isCalled(f, double[].class, 163, 6989, 6989)[i]) - (CallChecker.isCalled(f, double[].class, 163, 6996, 6996)[(n - i)])))), "b", 163, 6965, 7005);
                if (CallChecker.beforeDeref(x, double[].class, 164, 7019, 7019)) {
                    CallChecker.isCalled(x, double[].class, 164, 7019, 7019)[i] = a + b;
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 164, 7019, 7019)[i], "CallChecker.isCalled(x, double[].class, 164, 7019, 7019)[i]", 164, 7019, 7035);
                }
                if (CallChecker.beforeDeref(x, double[].class, 165, 7049, 7049)) {
                    CallChecker.isCalled(x, double[].class, 165, 7049, 7049)[(n - i)] = a - b;
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 165, 7049, 7049)[(n - i)], "CallChecker.isCalled(x, double[].class, 165, 7049, 7049)[(n - i)]", 165, 7049, 7065);
                }
            }
            FastFourierTransformer transformer = CallChecker.init(FastFourierTransformer.class);
            transformer = new FastFourierTransformer(DftNormalization.STANDARD);
            CallChecker.varAssign(transformer, "transformer", 168, 7129, 7196);
            Complex[] y = CallChecker.init(Complex[].class);
            if (CallChecker.beforeDeref(transformer, FastFourierTransformer.class, 169, 7220, 7230)) {
                transformer = CallChecker.beforeCalled(transformer, FastFourierTransformer.class, 169, 7220, 7230);
                y = CallChecker.isCalled(transformer, FastFourierTransformer.class, 169, 7220, 7230).transform(x, TransformType.FORWARD);
                CallChecker.varAssign(y, "y", 169, 7220, 7230);
            }
            if (CallChecker.beforeDeref(transformed, double[].class, 172, 7339, 7349)) {
                CallChecker.isCalled(transformed, double[].class, 172, 7339, 7349)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 172, 7339, 7349)[0], "CallChecker.isCalled(transformed, double[].class, 172, 7339, 7349)[0]", 172, 7339, 7359);
            }
            if (CallChecker.beforeDeref(transformed, double[].class, 173, 7369, 7379)) {
                if (CallChecker.beforeDeref(y, Complex[].class, 173, 7392, 7392)) {
                    y = CallChecker.beforeCalled(y, Complex[].class, 173, 7392, 7392);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 173, 7392, 7392)[0], Complex.class, 173, 7392, 7395)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 173, 7392, 7392);
                        CallChecker.isCalled(y, Complex[].class, 173, 7392, 7392)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 173, 7392, 7392)[0], Complex.class, 173, 7392, 7395);
                        CallChecker.isCalled(transformed, double[].class, 173, 7369, 7379)[1] = 0.5 * (CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 173, 7392, 7392)[0], Complex.class, 173, 7392, 7395).getReal());
                        CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 173, 7369, 7379)[1], "CallChecker.isCalled(transformed, double[].class, 173, 7369, 7379)[1]", 173, 7369, 7406);
                    }
                }
            }
            for (int i = 1; i < (n >> 1); i++) {
                if (CallChecker.beforeDeref(transformed, double[].class, 175, 7465, 7475)) {
                    if (CallChecker.beforeDeref(y, Complex[].class, 175, 7491, 7491)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 175, 7491, 7491);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 175, 7491, 7491)[i], Complex.class, 175, 7491, 7494)) {
                            y = CallChecker.beforeCalled(y, Complex[].class, 175, 7491, 7491);
                            CallChecker.isCalled(y, Complex[].class, 175, 7491, 7491)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 175, 7491, 7491)[i], Complex.class, 175, 7491, 7494);
                            CallChecker.isCalled(transformed, double[].class, 175, 7465, 7475)[(2 * i)] = -(CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 175, 7491, 7491)[i], Complex.class, 175, 7491, 7494).getImaginary());
                            CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 175, 7465, 7475)[(2 * i)], "CallChecker.isCalled(transformed, double[].class, 175, 7465, 7475)[(2 * i)]", 175, 7465, 7510);
                        }
                    }
                }
                if (CallChecker.beforeDeref(transformed, double[].class, 176, 7524, 7534)) {
                    if (CallChecker.beforeDeref(y, Complex[].class, 176, 7549, 7549)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 176, 7549, 7549);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 176, 7549, 7549)[i], Complex.class, 176, 7549, 7552)) {
                            if (CallChecker.beforeDeref(transformed, double[].class, 176, 7566, 7576)) {
                                y = CallChecker.beforeCalled(y, Complex[].class, 176, 7549, 7549);
                                CallChecker.isCalled(y, Complex[].class, 176, 7549, 7549)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 176, 7549, 7549)[i], Complex.class, 176, 7549, 7552);
                                CallChecker.isCalled(transformed, double[].class, 176, 7524, 7534)[((2 * i) + 1)] = (CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 176, 7549, 7549)[i], Complex.class, 176, 7549, 7552).getReal()) + (CallChecker.isCalled(transformed, double[].class, 176, 7566, 7576)[((2 * i) - 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 176, 7524, 7534)[((2 * i) + 1)], "CallChecker.isCalled(transformed, double[].class, 176, 7524, 7534)[((2 * i) + 1)]", 176, 7524, 7588);
                            }
                        }
                    }
                }
            }
            return transformed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4528.methodEnd();
        }
    }
}

