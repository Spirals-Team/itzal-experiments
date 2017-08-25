package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

public class Sinc implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    private static final double SHORTCUT = 0.006;

    private final boolean normalized;

    public Sinc() {
        this(false);
        ConstructorContext _bcornu_methode_context1135 = new ConstructorContext(Sinc.class, 71, 2934, 3037);
        try {
        } finally {
            _bcornu_methode_context1135.methodEnd();
        }
    }

    public Sinc(boolean normalized) {
        ConstructorContext _bcornu_methode_context1136 = new ConstructorContext(Sinc.class, 81, 3044, 3311);
        try {
            this.normalized = normalized;
            CallChecker.varAssign(this.normalized, "this.normalized", 82, 3277, 3305);
        } finally {
            _bcornu_methode_context1136.methodEnd();
        }
    }

    public double value(final double x) {
        MethodContext _bcornu_methode_context5137 = new MethodContext(double.class, 86, 3318, 3768);
        try {
            CallChecker.varInit(this, "this", 86, 3318, 3768);
            CallChecker.varInit(x, "x", 86, 3318, 3768);
            CallChecker.varInit(this.normalized, "normalized", 86, 3318, 3768);
            CallChecker.varInit(SHORTCUT, "org.apache.commons.math3.analysis.function.Sinc.SHORTCUT", 86, 3318, 3768);
            double scaledX = CallChecker.init(double.class);
            if (normalized) {
                scaledX = (FastMath.PI) * x;
                CallChecker.varAssign(scaledX, "scaledX", 87, 3412, 3443);
            }else {
                scaledX = x;
                CallChecker.varAssign(scaledX, "scaledX", 87, 3412, 3443);
            }
            if ((FastMath.abs(scaledX)) <= (Sinc.SHORTCUT)) {
                final double scaledX2 = CallChecker.varInit(((double) (scaledX * scaledX)), "scaledX2", 90, 3507, 3581);
                return (((scaledX2 - 20) * scaledX2) + 120) / 120;
            }else {
                return (FastMath.sin(scaledX)) / scaledX;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5137.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5138 = new MethodContext(UnivariateFunction.class, 102, 3775, 4028);
        try {
            CallChecker.varInit(this, "this", 102, 3775, 4028);
            CallChecker.varInit(this.normalized, "normalized", 102, 3775, 4028);
            CallChecker.varInit(SHORTCUT, "org.apache.commons.math3.analysis.function.Sinc.SHORTCUT", 102, 3775, 4028);
            final DifferentiableUnivariateFunction npe_invocation_var992 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var992, DifferentiableUnivariateFunction.class, 103, 3955, 4008)) {
                return CallChecker.isCalled(npe_invocation_var992, DifferentiableUnivariateFunction.class, 103, 3955, 4008).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5138.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5139 = new MethodContext(DerivativeStructure.class, 109, 4035, 7621);
        try {
            CallChecker.varInit(this, "this", 109, 4035, 7621);
            CallChecker.varInit(t, "t", 109, 4035, 7621);
            CallChecker.varInit(this.normalized, "normalized", 109, 4035, 7621);
            CallChecker.varInit(SHORTCUT, "org.apache.commons.math3.analysis.function.Sinc.SHORTCUT", 109, 4035, 7621);
            final double scaledX = CallChecker.varInit(((double) ((this.normalized ? FastMath.PI : 1) * (CallChecker.isCalled(t, DerivativeStructure.class, 112, 4255, 4255).getValue()))), "scaledX", 112, 4198, 4267);
            final double scaledX2 = CallChecker.varInit(((double) (scaledX * scaledX)), "scaledX2", 113, 4277, 4318);
            double[] f = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 115, 4353, 4353)) {
                f = new double[(CallChecker.isCalled(t, DerivativeStructure.class, 115, 4353, 4353).getOrder()) + 1];
                CallChecker.varAssign(f, "f", 115, 4353, 4353);
            }
            if ((FastMath.abs(scaledX)) <= (Sinc.SHORTCUT)) {
                f = CallChecker.beforeCalled(f, double[].class, 119, 4455, 4455);
                for (int i = 0; i < (CallChecker.isCalled(f, double[].class, 119, 4455, 4455).length); ++i) {
                    final int k = CallChecker.varInit(((int) (i / 2)), "k", 120, 4488, 4507);
                    if ((i & 1) == 0) {
                        if ((k & 1) == 0) {
                            if (CallChecker.beforeDeref(f, double[].class, 123, 4612, 4612)) {
                                f = CallChecker.beforeCalled(f, double[].class, 123, 4612, 4612);
                                CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i] = 1 * ((1.0 / (i + 1)) - (scaledX2 * ((1.0 / ((2 * i) + 6)) - (scaledX2 / ((24 * i) + 120)))));
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i], "CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i]", 123, 4612, 4752);
                            }
                        }else {
                            if (CallChecker.beforeDeref(f, double[].class, 123, 4612, 4612)) {
                                f = CallChecker.beforeCalled(f, double[].class, 123, 4612, 4612);
                                CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i] = (-1) * ((1.0 / (i + 1)) - (scaledX2 * ((1.0 / ((2 * i) + 6)) - (scaledX2 / ((24 * i) + 120)))));
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i], "CallChecker.isCalled(f, double[].class, 123, 4612, 4612)[i]", 123, 4612, 4752);
                            }
                        }
                    }else {
                        if ((k & 1) == 0) {
                            if (CallChecker.beforeDeref(f, double[].class, 127, 4843, 4843)) {
                                f = CallChecker.beforeCalled(f, double[].class, 127, 4843, 4843);
                                CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i] = (-scaledX) * ((1.0 / (i + 2)) - (scaledX2 * ((1.0 / ((6 * i) + 24)) - (scaledX2 / ((120 * i) + 720)))));
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i], "CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i]", 127, 4843, 4997);
                            }
                        }else {
                            if (CallChecker.beforeDeref(f, double[].class, 127, 4843, 4843)) {
                                f = CallChecker.beforeCalled(f, double[].class, 127, 4843, 4843);
                                CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i] = scaledX * ((1.0 / (i + 2)) - (scaledX2 * ((1.0 / ((6 * i) + 24)) - (scaledX2 / ((120 * i) + 720)))));
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i], "CallChecker.isCalled(f, double[].class, 127, 4843, 4843)[i]", 127, 4843, 4997);
                            }
                        }
                    }
                }
            }else {
                final double inv = CallChecker.varInit(((double) (1 / scaledX)), "inv", 134, 5062, 5092);
                final double cos = CallChecker.varInit(((double) (FastMath.cos(scaledX))), "cos", 135, 5106, 5146);
                final double sin = CallChecker.varInit(((double) (FastMath.sin(scaledX))), "sin", 136, 5160, 5200);
                if (CallChecker.beforeDeref(f, double[].class, 138, 5215, 5215)) {
                    f = CallChecker.beforeCalled(f, double[].class, 138, 5215, 5215);
                    CallChecker.isCalled(f, double[].class, 138, 5215, 5215)[0] = inv * sin;
                    CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 138, 5215, 5215)[0], "CallChecker.isCalled(f, double[].class, 138, 5215, 5215)[0]", 138, 5215, 5231);
                }
                f = CallChecker.beforeCalled(f, double[].class, 150, 6046, 6046);
                final double[] sc = CallChecker.varInit(new double[CallChecker.isCalled(f, double[].class, 150, 6046, 6046).length], "sc", 150, 6015, 6055);
                if (CallChecker.beforeDeref(sc, double[].class, 151, 6069, 6070)) {
                    CallChecker.isCalled(sc, double[].class, 151, 6069, 6070)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 151, 6069, 6070)[0], "CallChecker.isCalled(sc, double[].class, 151, 6069, 6070)[0]", 151, 6069, 6078);
                }
                double coeff = CallChecker.varInit(((double) (inv)), "coeff", 153, 6093, 6111);
                f = CallChecker.beforeCalled(f, double[].class, 154, 6145, 6145);
                for (int n = 1; n < (CallChecker.isCalled(f, double[].class, 154, 6145, 6145).length); ++n) {
                    double s = CallChecker.varInit(((double) (0)), "s", 156, 6179, 6191);
                    double c = CallChecker.varInit(((double) (0)), "c", 157, 6209, 6221);
                    int kStart = CallChecker.init(int.class);
                    if ((n & 1) == 0) {
                        if (CallChecker.beforeDeref(sc, double[].class, 163, 6469, 6470)) {
                            CallChecker.isCalled(sc, double[].class, 163, 6469, 6470)[n] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 163, 6469, 6470)[n], "CallChecker.isCalled(sc, double[].class, 163, 6469, 6470)[n]", 163, 6469, 6478);
                        }
                        kStart = n;
                        CallChecker.varAssign(kStart, "kStart", 164, 6500, 6510);
                    }else {
                        if (CallChecker.beforeDeref(sc, double[].class, 167, 6640, 6641)) {
                            if (CallChecker.beforeDeref(sc, double[].class, 167, 6648, 6649)) {
                                CallChecker.isCalled(sc, double[].class, 167, 6640, 6641)[n] = CallChecker.isCalled(sc, double[].class, 167, 6648, 6649)[(n - 1)];
                                CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 167, 6640, 6641)[n], "CallChecker.isCalled(sc, double[].class, 167, 6640, 6641)[n]", 167, 6640, 6657);
                            }
                        }
                        if (CallChecker.beforeDeref(sc, double[].class, 168, 6683, 6684)) {
                            c = CallChecker.isCalled(sc, double[].class, 168, 6683, 6684)[n];
                            CallChecker.varAssign(c, "c", 168, 6679, 6688);
                        }
                        kStart = n - 1;
                        CallChecker.varAssign(kStart, "kStart", 169, 6710, 6724);
                    }
                    for (int k = kStart; k > 1; k -= 2) {
                        CallChecker.varAssign(k, "k", 173, 6839, 6844);
                        if (CallChecker.beforeDeref(sc, double[].class, 176, 6903, 6904)) {
                            if (CallChecker.beforeDeref(sc, double[].class, 176, 6925, 6926)) {
                                if (CallChecker.beforeDeref(sc, double[].class, 176, 6933, 6934)) {
                                    CallChecker.isCalled(sc, double[].class, 176, 6903, 6904)[k] = ((k - n) * (CallChecker.isCalled(sc, double[].class, 176, 6925, 6926)[k])) - (CallChecker.isCalled(sc, double[].class, 176, 6933, 6934)[(k - 1)]);
                                    CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 176, 6903, 6904)[k], "CallChecker.isCalled(sc, double[].class, 176, 6903, 6904)[k]", 176, 6903, 6942);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sc, double[].class, 177, 6991, 6992)) {
                            s = (s * scaledX2) + (CallChecker.isCalled(sc, double[].class, 177, 6991, 6992)[k]);
                            CallChecker.varAssign(s, "s", 177, 6964, 6996);
                        }
                        if (CallChecker.beforeDeref(sc, double[].class, 180, 7054, 7055)) {
                            if (CallChecker.beforeDeref(sc, double[].class, 180, 7080, 7081)) {
                                if (CallChecker.beforeDeref(sc, double[].class, 180, 7092, 7093)) {
                                    CallChecker.isCalled(sc, double[].class, 180, 7054, 7055)[(k - 1)] = (((k - 1) - n) * (CallChecker.isCalled(sc, double[].class, 180, 7080, 7081)[(k - 1)])) + (CallChecker.isCalled(sc, double[].class, 180, 7092, 7093)[(k - 2)]);
                                    CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 180, 7054, 7055)[(k - 1)], "CallChecker.isCalled(sc, double[].class, 180, 7054, 7055)[(k - 1)]", 180, 7054, 7100);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sc, double[].class, 181, 7149, 7150)) {
                            c = (c * scaledX2) + (CallChecker.isCalled(sc, double[].class, 181, 7149, 7150)[(k - 1)]);
                            CallChecker.varAssign(c, "c", 181, 7122, 7158);
                        }
                    }
                    if (CallChecker.beforeDeref(sc, double[].class, 184, 7195, 7196)) {
                        CallChecker.isCalled(sc, double[].class, 184, 7195, 7196)[0] *= -n;
                        CallChecker.varAssign(CallChecker.isCalled(sc, double[].class, 184, 7195, 7196)[0], "CallChecker.isCalled(sc, double[].class, 184, 7195, 7196)[0]", 184, 7195, 7206);
                    }
                    if (CallChecker.beforeDeref(sc, double[].class, 185, 7248, 7249)) {
                        s = (s * scaledX2) + (CallChecker.isCalled(sc, double[].class, 185, 7248, 7249)[0]);
                        CallChecker.varAssign(s, "s", 185, 7224, 7253);
                    }
                    coeff *= inv;
                    CallChecker.varAssign(coeff, "coeff", 187, 7272, 7284);
                    if (CallChecker.beforeDeref(f, double[].class, 188, 7302, 7302)) {
                        f = CallChecker.beforeCalled(f, double[].class, 188, 7302, 7302);
                        CallChecker.isCalled(f, double[].class, 188, 7302, 7302)[n] = coeff * ((s * sin) + ((c * scaledX) * cos));
                        CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 188, 7302, 7302)[n], "CallChecker.isCalled(f, double[].class, 188, 7302, 7302)[n]", 188, 7302, 7348);
                    }
                }
            }
            if (normalized) {
                double scale = CallChecker.varInit(((double) (FastMath.PI)), "scale", 195, 7415, 7441);
                f = CallChecker.beforeCalled(f, double[].class, 196, 7475, 7475);
                for (int i = 1; i < (CallChecker.isCalled(f, double[].class, 196, 7475, 7475).length); ++i) {
                    if (CallChecker.beforeDeref(f, double[].class, 197, 7508, 7508)) {
                        f = CallChecker.beforeCalled(f, double[].class, 197, 7508, 7508);
                        CallChecker.isCalled(f, double[].class, 197, 7508, 7508)[i] *= scale;
                        CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 197, 7508, 7508)[i], "CallChecker.isCalled(f, double[].class, 197, 7508, 7508)[i]", 197, 7508, 7522);
                    }
                    scale *= FastMath.PI;
                    CallChecker.varAssign(scale, "scale", 198, 7540, 7560);
                }
            }
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 202, 7602, 7602)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 202, 7602, 7602).compose(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5139.methodEnd();
        }
    }
}

