package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;

public class HermiteInterpolator implements UnivariateDifferentiableVectorFunction {
    private final List<Double> abscissae;

    private final List<double[]> topDiagonal;

    private final List<double[]> bottomDiagonal;

    public HermiteInterpolator() {
        ConstructorContext _bcornu_methode_context46 = new ConstructorContext(HermiteInterpolator.class, 62, 2745, 2995);
        try {
            this.abscissae = new ArrayList<Double>();
            CallChecker.varAssign(this.abscissae, "this.abscissae", 63, 2830, 2875);
            this.topDiagonal = new ArrayList<double[]>();
            CallChecker.varAssign(this.topDiagonal, "this.topDiagonal", 64, 2885, 2932);
            this.bottomDiagonal = new ArrayList<double[]>();
            CallChecker.varAssign(this.bottomDiagonal, "this.bottomDiagonal", 65, 2942, 2989);
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public void addSamplePoint(final double x, final double[]... value) throws MathArithmeticException, ZeroException {
        MethodContext _bcornu_methode_context139 = new MethodContext(void.class, 87, 3002, 5266);
        try {
            CallChecker.varInit(this, "this", 87, 3002, 5266);
            CallChecker.varInit(value, "value", 87, 3002, 5266);
            CallChecker.varInit(x, "x", 87, 3002, 5266);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 87, 3002, 5266);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 87, 3002, 5266);
            CallChecker.varInit(this.abscissae, "abscissae", 87, 3002, 5266);
            for (int i = 0; i < (CallChecker.isCalled(value, double[][].class, 90, 4039, 4043).length); ++i) {
                CallChecker.isCalled(value, double[][].class, 92, 4092, 4096)[i] = CallChecker.beforeCalled(CallChecker.isCalled(value, double[][].class, 92, 4092, 4096)[i], double[].class, 92, 4092, 4099);
                final double[] y = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(value, double[][].class, 92, 4092, 4096)[i], double[].class, 92, 4092, 4099).clone(), "y", 92, 4073, 4108);
                if (i > 1) {
                    double inv = CallChecker.varInit(((double) (1.0 / (ArithmeticUtils.factorial(i)))), "inv", 94, 4151, 4198);
                    for (int j = 0; j < (CallChecker.isCalled(y, double[].class, 95, 4236, 4236).length); ++j) {
                        if (CallChecker.beforeDeref(y, double[].class, 96, 4273, 4273)) {
                            CallChecker.isCalled(y, double[].class, 96, 4273, 4273)[j] *= inv;
                            CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 96, 4273, 4273)[j], "CallChecker.isCalled(y, double[].class, 96, 4273, 4273)[j]", 96, 4273, 4284);
                        }
                    }
                }
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.abscissae, List.class, 101, 4420, 4428).size())), "n", 101, 4331, 4436);
                if (CallChecker.beforeDeref(bottomDiagonal, List.class, 102, 4450, 4463)) {
                    CallChecker.isCalled(bottomDiagonal, List.class, 102, 4450, 4463).add((n - i), y);
                }
                double[] bottom0 = CallChecker.varInit(y, "bottom0", 103, 4492, 4512);
                for (int j = i; j < n; ++j) {
                    final double[] bottom1 = CallChecker.varInit(CallChecker.isCalled(bottomDiagonal, List.class, 105, 4597, 4610).get((n - (j + 1))), "bottom1", 105, 4572, 4628);
                    final double inv = CallChecker.varInit(((double) (1.0 / (x - (CallChecker.isCalled(this.abscissae, List.class, 106, 4676, 4684).get((n - (j + 1))))))), "inv", 106, 4646, 4703);
                    if (Double.isInfinite(inv)) {
                        throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, x);
                    }
                    for (int k = 0; k < (CallChecker.isCalled(y, double[].class, 110, 4908, 4908).length); ++k) {
                        if (CallChecker.beforeDeref(bottom1, double[].class, 111, 4945, 4951)) {
                            if (CallChecker.beforeDeref(bottom0, double[].class, 111, 4965, 4971)) {
                                if (CallChecker.beforeDeref(bottom1, double[].class, 111, 4978, 4984)) {
                                    bottom0 = CallChecker.beforeCalled(bottom0, double[].class, 111, 4965, 4971);
                                    CallChecker.isCalled(bottom1, double[].class, 111, 4945, 4951)[k] = inv * ((CallChecker.isCalled(bottom0, double[].class, 111, 4965, 4971)[k]) - (CallChecker.isCalled(bottom1, double[].class, 111, 4978, 4984)[k]));
                                    CallChecker.varAssign(CallChecker.isCalled(bottom1, double[].class, 111, 4945, 4951)[k], "CallChecker.isCalled(bottom1, double[].class, 111, 4945, 4951)[k]", 111, 4945, 4989);
                                }
                            }
                        }
                    }
                    bottom0 = bottom1;
                    CallChecker.varAssign(bottom0, "bottom0", 113, 5025, 5042);
                }
                if (CallChecker.beforeDeref(bottom0, double[].class, 117, 5159, 5165)) {
                    if (CallChecker.beforeDeref(topDiagonal, List.class, 117, 5143, 5153)) {
                        bottom0 = CallChecker.beforeCalled(bottom0, double[].class, 117, 5159, 5165);
                        CallChecker.isCalled(topDiagonal, List.class, 117, 5143, 5153).add(CallChecker.isCalled(bottom0, double[].class, 117, 5159, 5165).clone());
                    }
                }
                if (CallChecker.beforeDeref(abscissae, List.class, 120, 5232, 5240)) {
                    CallChecker.isCalled(abscissae, List.class, 120, 5232, 5240).add(x);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public PolynomialFunction[] getPolynomials() throws NoDataException {
        MethodContext _bcornu_methode_context140 = new MethodContext(PolynomialFunction[].class, 130, 5273, 6377);
        try {
            CallChecker.varInit(this, "this", 130, 5273, 6377);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 130, 5273, 6377);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 130, 5273, 6377);
            CallChecker.varInit(this.abscissae, "abscissae", 130, 5273, 6377);
            checkInterpolation();
            final PolynomialFunction zero = CallChecker.varInit(polynomial(0), "zero", 137, 5570, 5651);
            PolynomialFunction[] polynomials = CallChecker.init(PolynomialFunction[].class);
            if (CallChecker.beforeDeref(topDiagonal, List.class, 138, 5719, 5729)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(topDiagonal, List.class, 138, 5719, 5729).get(0), double[].class, 138, 5719, 5736)) {
                    polynomials = new PolynomialFunction[CallChecker.isCalled(CallChecker.isCalled(topDiagonal, List.class, 138, 5719, 5729).get(0), double[].class, 138, 5719, 5736).length];
                    CallChecker.varAssign(polynomials, "polynomials", 138, 5719, 5729);
                }
            }
            polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 139, 5775, 5785);
            for (int i = 0; i < (CallChecker.isCalled(polynomials, PolynomialFunction[].class, 139, 5775, 5785).length); ++i) {
                if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 140, 5814, 5824)) {
                    polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 140, 5814, 5824);
                    CallChecker.isCalled(polynomials, PolynomialFunction[].class, 140, 5814, 5824)[i] = zero;
                    CallChecker.varAssign(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 140, 5814, 5824)[i], "CallChecker.isCalled(polynomials, PolynomialFunction[].class, 140, 5814, 5824)[i]", 140, 5814, 5835);
                }
            }
            PolynomialFunction coeff = CallChecker.varInit(polynomial(1), "coeff", 142, 5855, 5895);
            for (int i = 0; i < (CallChecker.isCalled(topDiagonal, List.class, 145, 6025, 6035).size()); ++i) {
                double[] tdi = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(topDiagonal, List.class, 146, 6079, 6089)) {
                    tdi = CallChecker.isCalled(topDiagonal, List.class, 146, 6079, 6089).get(i);
                    CallChecker.varAssign(tdi, "tdi", 146, 6079, 6089);
                }
                polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 147, 6131, 6141);
                for (int k = 0; k < (CallChecker.isCalled(polynomials, PolynomialFunction[].class, 147, 6131, 6141).length); ++k) {
                    if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 148, 6174, 6184)) {
                        if (CallChecker.beforeDeref(polynomials, PolynomialFunction[].class, 148, 6191, 6201)) {
                            if (CallChecker.beforeDeref(tdi, double[].class, 148, 6236, 6238)) {
                                if (CallChecker.beforeDeref(coeff, PolynomialFunction.class, 148, 6210, 6214)) {
                                    polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201)[k], PolynomialFunction.class, 148, 6191, 6204)) {
                                        polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 148, 6174, 6184);
                                        polynomials = CallChecker.beforeCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201);
                                        tdi = CallChecker.beforeCalled(tdi, double[].class, 148, 6236, 6238);
                                        coeff = CallChecker.beforeCalled(coeff, PolynomialFunction.class, 148, 6210, 6214);
                                        CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201)[k] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201)[k], PolynomialFunction.class, 148, 6191, 6204);
                                        CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6174, 6184)[k] = CallChecker.isCalled(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6191, 6201)[k], PolynomialFunction.class, 148, 6191, 6204).add(CallChecker.isCalled(coeff, PolynomialFunction.class, 148, 6210, 6214).multiply(polynomial(CallChecker.isCalled(tdi, double[].class, 148, 6236, 6238)[k])));
                                        CallChecker.varAssign(CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6174, 6184)[k], "CallChecker.isCalled(polynomials, PolynomialFunction[].class, 148, 6174, 6184)[k]", 148, 6174, 6245);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(abscissae, List.class, 150, 6308, 6316)) {
                    if (CallChecker.beforeDeref(coeff, PolynomialFunction.class, 150, 6281, 6285)) {
                        coeff = CallChecker.beforeCalled(coeff, PolynomialFunction.class, 150, 6281, 6285);
                        coeff = CallChecker.isCalled(coeff, PolynomialFunction.class, 150, 6281, 6285).multiply(polynomial((-(CallChecker.isCalled(abscissae, List.class, 150, 6308, 6316).get(i))), 1.0));
                        CallChecker.varAssign(coeff, "coeff", 150, 6273, 6331);
                    }
                }
            }
            return polynomials;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    public double[] value(double x) throws NoDataException {
        MethodContext _bcornu_methode_context141 = new MethodContext(double[].class, 168, 6384, 7499);
        try {
            CallChecker.varInit(this, "this", 168, 6384, 7499);
            CallChecker.varInit(x, "x", 168, 6384, 7499);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 168, 6384, 7499);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 168, 6384, 7499);
            CallChecker.varInit(this.abscissae, "abscissae", 168, 6384, 7499);
            checkInterpolation();
            final double[] value = CallChecker.varInit(new double[CallChecker.isCalled(CallChecker.isCalled(topDiagonal, List.class, 174, 7066, 7076).get(0), double[].class, 174, 7066, 7083).length], "value", 174, 7032, 7092);
            double valueCoeff = CallChecker.varInit(((double) (1)), "valueCoeff", 175, 7102, 7123);
            for (int i = 0; i < (CallChecker.isCalled(topDiagonal, List.class, 176, 7153, 7163).size()); ++i) {
                double[] dividedDifference = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(topDiagonal, List.class, 177, 7221, 7231)) {
                    dividedDifference = CallChecker.isCalled(topDiagonal, List.class, 177, 7221, 7231).get(i);
                    CallChecker.varAssign(dividedDifference, "dividedDifference", 177, 7221, 7231);
                }
                for (int k = 0; k < (CallChecker.isCalled(value, double[].class, 178, 7273, 7277).length); ++k) {
                    if (CallChecker.beforeDeref(value, double[].class, 179, 7310, 7314)) {
                        if (CallChecker.beforeDeref(dividedDifference, double[].class, 179, 7322, 7338)) {
                            dividedDifference = CallChecker.beforeCalled(dividedDifference, double[].class, 179, 7322, 7338);
                            CallChecker.isCalled(value, double[].class, 179, 7310, 7314)[k] += (CallChecker.isCalled(dividedDifference, double[].class, 179, 7322, 7338)[k]) * valueCoeff;
                            CallChecker.varAssign(CallChecker.isCalled(value, double[].class, 179, 7310, 7314)[k], "CallChecker.isCalled(value, double[].class, 179, 7310, 7314)[k]", 179, 7310, 7355);
                        }
                    }
                }
                final double deltaX = CallChecker.varInit(((double) (x - (CallChecker.isCalled(this.abscissae, List.class, 181, 7409, 7417).get(i)))), "deltaX", 181, 7383, 7425);
                valueCoeff *= deltaX;
                CallChecker.varAssign(valueCoeff, "valueCoeff", 182, 7439, 7459);
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    public DerivativeStructure[] value(final DerivativeStructure x) throws NoDataException {
        MethodContext _bcornu_methode_context142 = new MethodContext(DerivativeStructure[].class, 200, 7506, 8839);
        try {
            CallChecker.varInit(this, "this", 200, 7506, 8839);
            CallChecker.varInit(x, "x", 200, 7506, 8839);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 200, 7506, 8839);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 200, 7506, 8839);
            CallChecker.varInit(this.abscissae, "abscissae", 200, 7506, 8839);
            checkInterpolation();
            final DerivativeStructure[] value = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(CallChecker.isCalled(topDiagonal, List.class, 206, 8259, 8269).get(0), double[].class, 206, 8259, 8276).length], "value", 206, 8199, 8285);
            if (CallChecker.beforeDeref(x, DerivativeStructure.class, 207, 8314, 8314)) {
                final Field<DerivativeStructure> npe_invocation_var8 = CallChecker.isCalled(x, DerivativeStructure.class, 207, 8314, 8314).getField();
                if (CallChecker.beforeDeref(npe_invocation_var8, Field.class, 207, 8314, 8325)) {
                    Arrays.fill(value, CallChecker.isCalled(npe_invocation_var8, Field.class, 207, 8314, 8325).getZero());
                }
            }
            DerivativeStructure valueCoeff = CallChecker.init(DerivativeStructure.class);
            if (CallChecker.beforeDeref(x, DerivativeStructure.class, 208, 8380, 8380)) {
                final Field<DerivativeStructure> npe_invocation_var9 = CallChecker.isCalled(x, DerivativeStructure.class, 208, 8380, 8380).getField();
                if (CallChecker.beforeDeref(npe_invocation_var9, Field.class, 208, 8380, 8391)) {
                    valueCoeff = CallChecker.isCalled(npe_invocation_var9, Field.class, 208, 8380, 8391).getOne();
                    CallChecker.varAssign(valueCoeff, "valueCoeff", 208, 8380, 8380);
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(topDiagonal, List.class, 209, 8431, 8441).size()); ++i) {
                double[] dividedDifference = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(topDiagonal, List.class, 210, 8499, 8509)) {
                    dividedDifference = CallChecker.isCalled(topDiagonal, List.class, 210, 8499, 8509).get(i);
                    CallChecker.varAssign(dividedDifference, "dividedDifference", 210, 8499, 8509);
                }
                for (int k = 0; k < (CallChecker.isCalled(value, DerivativeStructure[].class, 211, 8551, 8555).length); ++k) {
                    if (CallChecker.beforeDeref(value, DerivativeStructure[].class, 212, 8588, 8592)) {
                        if (CallChecker.beforeDeref(value, DerivativeStructure[].class, 212, 8599, 8603)) {
                            if (CallChecker.beforeDeref(dividedDifference, double[].class, 212, 8632, 8648)) {
                                if (CallChecker.beforeDeref(valueCoeff, DerivativeStructure.class, 212, 8612, 8621)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8599, 8603)[k], DerivativeStructure.class, 212, 8599, 8606)) {
                                        dividedDifference = CallChecker.beforeCalled(dividedDifference, double[].class, 212, 8632, 8648);
                                        valueCoeff = CallChecker.beforeCalled(valueCoeff, DerivativeStructure.class, 212, 8612, 8621);
                                        CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8599, 8603)[k] = CallChecker.beforeCalled(CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8599, 8603)[k], DerivativeStructure.class, 212, 8599, 8606);
                                        CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8588, 8592)[k] = CallChecker.isCalled(CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8599, 8603)[k], DerivativeStructure.class, 212, 8599, 8606).add(CallChecker.isCalled(valueCoeff, DerivativeStructure.class, 212, 8612, 8621).multiply(CallChecker.isCalled(dividedDifference, double[].class, 212, 8632, 8648)[k]));
                                        CallChecker.varAssign(CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8588, 8592)[k], "CallChecker.isCalled(value, DerivativeStructure[].class, 212, 8588, 8592)[k]", 212, 8588, 8654);
                                    }
                                }
                            }
                        }
                    }
                }
                final DerivativeStructure deltaX = CallChecker.varInit(CallChecker.isCalled(x, DerivativeStructure.class, 214, 8717, 8717).subtract(CallChecker.isCalled(abscissae, List.class, 214, 8728, 8736).get(i)), "deltaX", 214, 8682, 8745);
                if (CallChecker.beforeDeref(valueCoeff, DerivativeStructure.class, 215, 8772, 8781)) {
                    valueCoeff = CallChecker.beforeCalled(valueCoeff, DerivativeStructure.class, 215, 8772, 8781);
                    valueCoeff = CallChecker.isCalled(valueCoeff, DerivativeStructure.class, 215, 8772, 8781).multiply(deltaX);
                    CallChecker.varAssign(valueCoeff, "valueCoeff", 215, 8759, 8799);
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    private void checkInterpolation() throws NoDataException {
        MethodContext _bcornu_methode_context143 = new MethodContext(void.class, 226, 8846, 9194);
        try {
            CallChecker.varInit(this, "this", 226, 8846, 9194);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 226, 8846, 9194);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 226, 8846, 9194);
            CallChecker.varInit(this.abscissae, "abscissae", 226, 8846, 9194);
            if (CallChecker.beforeDeref(abscissae, List.class, 227, 9073, 9081)) {
                if (CallChecker.isCalled(abscissae, List.class, 227, 9073, 9081).isEmpty()) {
                    throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    private PolynomialFunction polynomial(double... c) {
        MethodContext _bcornu_methode_context144 = new MethodContext(PolynomialFunction.class, 236, 9201, 9427);
        try {
            CallChecker.varInit(this, "this", 236, 9201, 9427);
            CallChecker.varInit(c, "c", 236, 9201, 9427);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 236, 9201, 9427);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 236, 9201, 9427);
            CallChecker.varInit(this.abscissae, "abscissae", 236, 9201, 9427);
            return new PolynomialFunction(c);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }
}

