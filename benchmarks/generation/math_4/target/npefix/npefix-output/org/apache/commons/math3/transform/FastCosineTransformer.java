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

public class FastCosineTransformer implements Serializable , RealTransformer {
    static final long serialVersionUID = 20120212L;

    private final DctNormalization normalization;

    public FastCosineTransformer(final DctNormalization normalization) {
        ConstructorContext _bcornu_methode_context220 = new ConstructorContext(FastCosineTransformer.class, 81, 3303, 3634);
        try {
            this.normalization = normalization;
            CallChecker.varAssign(this.normalization, "this.normalization", 82, 3594, 3628);
        } finally {
            _bcornu_methode_context220.methodEnd();
        }
    }

    public double[] transform(final double[] f, final TransformType type) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context888 = new MethodContext(double[].class, 91, 3641, 4491);
        try {
            CallChecker.varInit(this, "this", 91, 3641, 4491);
            CallChecker.varInit(type, "type", 91, 3641, 4491);
            CallChecker.varInit(f, "f", 91, 3641, 4491);
            CallChecker.varInit(this.normalization, "normalization", 91, 3641, 4491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastCosineTransformer.serialVersionUID", 91, 3641, 4491);
            if (type == (TransformType.FORWARD)) {
                if ((normalization) == (DctNormalization.ORTHOGONAL_DCT_I)) {
                    final double s = CallChecker.varInit(((double) (FastMath.sqrt((2.0 / ((CallChecker.isCalled(f, double[].class, 95, 4082, 4082).length) - 1))))), "s", 95, 4044, 4096);
                    return TransformUtils.scaleArray(fct(f), s);
                }
                return fct(f);
            }
            final double s2 = CallChecker.varInit(((double) (2.0 / ((CallChecker.isCalled(f, double[].class, 100, 4243, 4243).length) - 1))), "s2", 100, 4218, 4256);
            double s1 = CallChecker.init(double.class);
            if ((normalization) == (DctNormalization.ORTHOGONAL_DCT_I)) {
                s1 = FastMath.sqrt(s2);
                CallChecker.varAssign(s1, "s1", 103, 4361, 4383);
            }else {
                s1 = s2;
                CallChecker.varAssign(s1, "s1", 105, 4414, 4421);
            }
            return TransformUtils.scaleArray(fct(f), s1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context888.methodEnd();
        }
    }

    public double[] transform(final UnivariateFunction f, final double min, final double max, final int n, final TransformType type) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context889 = new MethodContext(double[].class, 120, 4498, 5229);
        try {
            CallChecker.varInit(this, "this", 120, 4498, 5229);
            CallChecker.varInit(type, "type", 120, 4498, 5229);
            CallChecker.varInit(n, "n", 120, 4498, 5229);
            CallChecker.varInit(max, "max", 120, 4498, 5229);
            CallChecker.varInit(min, "min", 120, 4498, 5229);
            CallChecker.varInit(f, "f", 120, 4498, 5229);
            CallChecker.varInit(this.normalization, "normalization", 120, 4498, 5229);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastCosineTransformer.serialVersionUID", 120, 4498, 5229);
            final double[] data = CallChecker.varInit(FunctionUtils.sample(f, min, max, n), "data", 124, 5127, 5185);
            return transform(data, type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context889.methodEnd();
        }
    }

    protected double[] fct(double[] f) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context890 = new MethodContext(double[].class, 136, 5236, 7304);
        try {
            CallChecker.varInit(this, "this", 136, 5236, 7304);
            CallChecker.varInit(f, "f", 136, 5236, 7304);
            CallChecker.varInit(this.normalization, "normalization", 136, 5236, 7304);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastCosineTransformer.serialVersionUID", 136, 5236, 7304);
            f = CallChecker.beforeCalled(f, double[].class, 139, 5653, 5653);
            final double[] transformed = CallChecker.varInit(new double[CallChecker.isCalled(f, double[].class, 139, 5653, 5653).length], "transformed", 139, 5613, 5662);
            f = CallChecker.beforeCalled(f, double[].class, 141, 5687, 5687);
            final int n = CallChecker.varInit(((int) ((CallChecker.isCalled(f, double[].class, 141, 5687, 5687).length) - 1)), "n", 141, 5673, 5699);
            if (!(ArithmeticUtils.isPowerOfTwo(n))) {
                if (CallChecker.beforeDeref(f, double[].class, 145, 5893, 5893)) {
                    f = CallChecker.beforeCalled(f, double[].class, 145, 5893, 5893);
                    throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_PLUS_ONE, Integer.valueOf(CallChecker.isCalled(f, double[].class, 145, 5893, 5893).length));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (n == 1) {
                if (CallChecker.beforeDeref(transformed, double[].class, 148, 5971, 5981)) {
                    if (CallChecker.beforeDeref(f, double[].class, 148, 5995, 5995)) {
                        if (CallChecker.beforeDeref(f, double[].class, 148, 6002, 6002)) {
                            f = CallChecker.beforeCalled(f, double[].class, 148, 5995, 5995);
                            f = CallChecker.beforeCalled(f, double[].class, 148, 6002, 6002);
                            CallChecker.isCalled(transformed, double[].class, 148, 5971, 5981)[0] = 0.5 * ((CallChecker.isCalled(f, double[].class, 148, 5995, 5995)[0]) + (CallChecker.isCalled(f, double[].class, 148, 6002, 6002)[1]));
                            CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 148, 5971, 5981)[0], "CallChecker.isCalled(transformed, double[].class, 148, 5971, 5981)[0]", 148, 5971, 6007);
                        }
                    }
                }
                if (CallChecker.beforeDeref(transformed, double[].class, 149, 6021, 6031)) {
                    if (CallChecker.beforeDeref(f, double[].class, 149, 6045, 6045)) {
                        if (CallChecker.beforeDeref(f, double[].class, 149, 6052, 6052)) {
                            f = CallChecker.beforeCalled(f, double[].class, 149, 6045, 6045);
                            f = CallChecker.beforeCalled(f, double[].class, 149, 6052, 6052);
                            CallChecker.isCalled(transformed, double[].class, 149, 6021, 6031)[1] = 0.5 * ((CallChecker.isCalled(f, double[].class, 149, 6045, 6045)[0]) - (CallChecker.isCalled(f, double[].class, 149, 6052, 6052)[1]));
                            CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 149, 6021, 6031)[1], "CallChecker.isCalled(transformed, double[].class, 149, 6021, 6031)[1]", 149, 6021, 6057);
                        }
                    }
                }
                return transformed;
            }
            final double[] x = CallChecker.varInit(new double[n], "x", 154, 6165, 6197);
            if (CallChecker.beforeDeref(x, double[].class, 155, 6207, 6207)) {
                if (CallChecker.beforeDeref(f, double[].class, 155, 6221, 6221)) {
                    if (CallChecker.beforeDeref(f, double[].class, 155, 6228, 6228)) {
                        f = CallChecker.beforeCalled(f, double[].class, 155, 6221, 6221);
                        f = CallChecker.beforeCalled(f, double[].class, 155, 6228, 6228);
                        CallChecker.isCalled(x, double[].class, 155, 6207, 6207)[0] = 0.5 * ((CallChecker.isCalled(f, double[].class, 155, 6221, 6221)[0]) + (CallChecker.isCalled(f, double[].class, 155, 6228, 6228)[n]));
                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 155, 6207, 6207)[0], "CallChecker.isCalled(x, double[].class, 155, 6207, 6207)[0]", 155, 6207, 6233);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, double[].class, 156, 6243, 6243)) {
                if (CallChecker.beforeDeref(f, double[].class, 156, 6255, 6255)) {
                    f = CallChecker.beforeCalled(f, double[].class, 156, 6255, 6255);
                    CallChecker.isCalled(x, double[].class, 156, 6243, 6243)[(n >> 1)] = CallChecker.isCalled(f, double[].class, 156, 6255, 6255)[(n >> 1)];
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 156, 6243, 6243)[(n >> 1)], "CallChecker.isCalled(x, double[].class, 156, 6243, 6243)[(n >> 1)]", 156, 6243, 6264);
                }
            }
            double t1 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(f, double[].class, 158, 6342, 6342)) {
                if (CallChecker.beforeDeref(f, double[].class, 158, 6349, 6349)) {
                    f = CallChecker.beforeCalled(f, double[].class, 158, 6342, 6342);
                    f = CallChecker.beforeCalled(f, double[].class, 158, 6349, 6349);
                    t1 = 0.5 * ((CallChecker.isCalled(f, double[].class, 158, 6342, 6342)[0]) - (CallChecker.isCalled(f, double[].class, 158, 6349, 6349)[n]));
                    CallChecker.varAssign(t1, "t1", 158, 6342, 6342);
                }
            }
            for (int i = 1; i < (n >> 1); i++) {
                f = CallChecker.beforeCalled(f, double[].class, 160, 6437, 6437);
                f = CallChecker.beforeCalled(f, double[].class, 160, 6444, 6444);
                final double a = CallChecker.varInit(((double) (0.5 * ((CallChecker.isCalled(f, double[].class, 160, 6437, 6437)[i]) + (CallChecker.isCalled(f, double[].class, 160, 6444, 6444)[(n - i)])))), "a", 160, 6413, 6453);
                f = CallChecker.beforeCalled(f, double[].class, 161, 6521, 6521);
                f = CallChecker.beforeCalled(f, double[].class, 161, 6528, 6528);
                final double b = CallChecker.varInit(((double) ((FastMath.sin(((i * (FastMath.PI)) / n))) * ((CallChecker.isCalled(f, double[].class, 161, 6521, 6521)[i]) - (CallChecker.isCalled(f, double[].class, 161, 6528, 6528)[(n - i)])))), "b", 161, 6467, 6537);
                f = CallChecker.beforeCalled(f, double[].class, 162, 6605, 6605);
                f = CallChecker.beforeCalled(f, double[].class, 162, 6612, 6612);
                final double c = CallChecker.varInit(((double) ((FastMath.cos(((i * (FastMath.PI)) / n))) * ((CallChecker.isCalled(f, double[].class, 162, 6605, 6605)[i]) - (CallChecker.isCalled(f, double[].class, 162, 6612, 6612)[(n - i)])))), "c", 162, 6551, 6621);
                if (CallChecker.beforeDeref(x, double[].class, 163, 6635, 6635)) {
                    CallChecker.isCalled(x, double[].class, 163, 6635, 6635)[i] = a - b;
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 163, 6635, 6635)[i], "CallChecker.isCalled(x, double[].class, 163, 6635, 6635)[i]", 163, 6635, 6647);
                }
                if (CallChecker.beforeDeref(x, double[].class, 164, 6661, 6661)) {
                    CallChecker.isCalled(x, double[].class, 164, 6661, 6661)[(n - i)] = a + b;
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 164, 6661, 6661)[(n - i)], "CallChecker.isCalled(x, double[].class, 164, 6661, 6661)[(n - i)]", 164, 6661, 6677);
                }
                t1 += c;
                CallChecker.varAssign(t1, "t1", 165, 6691, 6698);
            }
            FastFourierTransformer transformer = CallChecker.init(FastFourierTransformer.class);
            transformer = new FastFourierTransformer(DftNormalization.STANDARD);
            CallChecker.varAssign(transformer, "transformer", 168, 6762, 6829);
            Complex[] y = CallChecker.init(Complex[].class);
            if (CallChecker.beforeDeref(transformer, FastFourierTransformer.class, 169, 6853, 6863)) {
                transformer = CallChecker.beforeCalled(transformer, FastFourierTransformer.class, 169, 6853, 6863);
                y = CallChecker.isCalled(transformer, FastFourierTransformer.class, 169, 6853, 6863).transform(x, TransformType.FORWARD);
                CallChecker.varAssign(y, "y", 169, 6853, 6863);
            }
            if (CallChecker.beforeDeref(transformed, double[].class, 172, 6972, 6982)) {
                if (CallChecker.beforeDeref(y, Complex[].class, 172, 6989, 6989)) {
                    y = CallChecker.beforeCalled(y, Complex[].class, 172, 6989, 6989);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 172, 6989, 6989)[0], Complex.class, 172, 6989, 6992)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 172, 6989, 6989);
                        CallChecker.isCalled(y, Complex[].class, 172, 6989, 6989)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 172, 6989, 6989)[0], Complex.class, 172, 6989, 6992);
                        CallChecker.isCalled(transformed, double[].class, 172, 6972, 6982)[0] = CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 172, 6989, 6989)[0], Complex.class, 172, 6989, 6992).getReal();
                        CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 172, 6972, 6982)[0], "CallChecker.isCalled(transformed, double[].class, 172, 6972, 6982)[0]", 172, 6972, 7003);
                    }
                }
            }
            if (CallChecker.beforeDeref(transformed, double[].class, 173, 7013, 7023)) {
                CallChecker.isCalled(transformed, double[].class, 173, 7013, 7023)[1] = t1;
                CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 173, 7013, 7023)[1], "CallChecker.isCalled(transformed, double[].class, 173, 7013, 7023)[1]", 173, 7013, 7032);
            }
            for (int i = 1; i < (n >> 1); i++) {
                if (CallChecker.beforeDeref(transformed, double[].class, 175, 7091, 7101)) {
                    if (CallChecker.beforeDeref(y, Complex[].class, 175, 7116, 7116)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 175, 7116, 7116);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 175, 7116, 7116)[i], Complex.class, 175, 7116, 7119)) {
                            y = CallChecker.beforeCalled(y, Complex[].class, 175, 7116, 7116);
                            CallChecker.isCalled(y, Complex[].class, 175, 7116, 7116)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 175, 7116, 7116)[i], Complex.class, 175, 7116, 7119);
                            CallChecker.isCalled(transformed, double[].class, 175, 7091, 7101)[(2 * i)] = CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 175, 7116, 7116)[i], Complex.class, 175, 7116, 7119).getReal();
                            CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 175, 7091, 7101)[(2 * i)], "CallChecker.isCalled(transformed, double[].class, 175, 7091, 7101)[(2 * i)]", 175, 7091, 7130);
                        }
                    }
                }
                if (CallChecker.beforeDeref(transformed, double[].class, 176, 7144, 7154)) {
                    if (CallChecker.beforeDeref(transformed, double[].class, 176, 7169, 7179)) {
                        if (CallChecker.beforeDeref(y, Complex[].class, 176, 7194, 7194)) {
                            y = CallChecker.beforeCalled(y, Complex[].class, 176, 7194, 7194);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 176, 7194, 7194)[i], Complex.class, 176, 7194, 7197)) {
                                y = CallChecker.beforeCalled(y, Complex[].class, 176, 7194, 7194);
                                CallChecker.isCalled(y, Complex[].class, 176, 7194, 7194)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 176, 7194, 7194)[i], Complex.class, 176, 7194, 7197);
                                CallChecker.isCalled(transformed, double[].class, 176, 7144, 7154)[((2 * i) + 1)] = (CallChecker.isCalled(transformed, double[].class, 176, 7169, 7179)[((2 * i) - 1)]) - (CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 176, 7194, 7194)[i], Complex.class, 176, 7194, 7197).getImaginary());
                                CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 176, 7144, 7154)[((2 * i) + 1)], "CallChecker.isCalled(transformed, double[].class, 176, 7144, 7154)[((2 * i) + 1)]", 176, 7144, 7213);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(transformed, double[].class, 178, 7233, 7243)) {
                if (CallChecker.beforeDeref(y, Complex[].class, 178, 7250, 7250)) {
                    y = CallChecker.beforeCalled(y, Complex[].class, 178, 7250, 7250);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, Complex[].class, 178, 7250, 7250)[(n >> 1)], Complex.class, 178, 7250, 7258)) {
                        y = CallChecker.beforeCalled(y, Complex[].class, 178, 7250, 7250);
                        CallChecker.isCalled(y, Complex[].class, 178, 7250, 7250)[(n >> 1)] = CallChecker.beforeCalled(CallChecker.isCalled(y, Complex[].class, 178, 7250, 7250)[(n >> 1)], Complex.class, 178, 7250, 7258);
                        CallChecker.isCalled(transformed, double[].class, 178, 7233, 7243)[n] = CallChecker.isCalled(CallChecker.isCalled(y, Complex[].class, 178, 7250, 7250)[(n >> 1)], Complex.class, 178, 7250, 7258).getReal();
                        CallChecker.varAssign(CallChecker.isCalled(transformed, double[].class, 178, 7233, 7243)[n], "CallChecker.isCalled(transformed, double[].class, 178, 7233, 7243)[n]", 178, 7233, 7269);
                    }
                }
            }
            return transformed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context890.methodEnd();
        }
    }
}

