package org.apache.commons.math3.analysis.polynomials;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

public class PolynomialFunctionNewtonForm implements UnivariateDifferentiableFunction {
    private double[] coefficients;

    private final double[] c;

    private final double[] a;

    private boolean coefficientsComputed;

    public PolynomialFunctionNewtonForm(double[] a, double[] c) throws DimensionMismatchException, NoDataException, NullArgumentException {
        ConstructorContext _bcornu_methode_context234 = new ConstructorContext(PolynomialFunctionNewtonForm.class, 79, 2495, 3557);
        try {
            PolynomialFunctionNewtonForm.verifyInputArray(a, c);
            a = CallChecker.beforeCalled(a, double[].class, 83, 3359, 3359);
            this.a = new double[CallChecker.isCalled(a, double[].class, 83, 3359, 3359).length];
            CallChecker.varAssign(this.a, "this.a", 83, 3339, 3368);
            c = CallChecker.beforeCalled(c, double[].class, 84, 3398, 3398);
            this.c = new double[CallChecker.isCalled(c, double[].class, 84, 3398, 3398).length];
            CallChecker.varAssign(this.c, "this.c", 84, 3378, 3407);
            if (CallChecker.beforeDeref(a, double[].class, 85, 3451, 3451)) {
                a = CallChecker.beforeCalled(a, double[].class, 85, 3451, 3451);
                System.arraycopy(a, 0, this.a, 0, CallChecker.isCalled(a, double[].class, 85, 3451, 3451).length);
            }
            if (CallChecker.beforeDeref(c, double[].class, 86, 3504, 3504)) {
                c = CallChecker.beforeCalled(c, double[].class, 86, 3504, 3504);
                System.arraycopy(c, 0, this.c, 0, CallChecker.isCalled(c, double[].class, 86, 3504, 3504).length);
            }
            coefficientsComputed = false;
            CallChecker.varAssign(this.coefficientsComputed, "this.coefficientsComputed", 87, 3523, 3551);
        } finally {
            _bcornu_methode_context234.methodEnd();
        }
    }

    public double value(double z) {
        MethodContext _bcornu_methode_context967 = new MethodContext(double.class, 96, 3564, 3816);
        try {
            CallChecker.varInit(this, "this", 96, 3564, 3816);
            CallChecker.varInit(z, "z", 96, 3564, 3816);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 96, 3564, 3816);
            CallChecker.varInit(this.a, "a", 96, 3564, 3816);
            CallChecker.varInit(this.c, "c", 96, 3564, 3816);
            CallChecker.varInit(this.coefficients, "coefficients", 96, 3564, 3816);
            return PolynomialFunctionNewtonForm.evaluate(a, c, z);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context967.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context968 = new MethodContext(DerivativeStructure.class, 104, 3823, 4256);
        try {
            CallChecker.varInit(this, "this", 104, 3823, 4256);
            CallChecker.varInit(t, "t", 104, 3823, 4256);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 104, 3823, 4256);
            CallChecker.varInit(this.a, "a", 104, 3823, 4256);
            CallChecker.varInit(this.c, "c", 104, 3823, 4256);
            CallChecker.varInit(this.coefficients, "coefficients", 104, 3823, 4256);
            PolynomialFunctionNewtonForm.verifyInputArray(a, c);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.c, double[].class, 107, 3997, 3997).length)), "n", 107, 3983, 4005);
            DerivativeStructure value = CallChecker.init(DerivativeStructure.class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 108, 4067, 4067)) {
                if (CallChecker.beforeDeref(t, DerivativeStructure.class, 108, 4090, 4090)) {
                    if (CallChecker.beforeDeref(a, double[].class, 108, 4104, 4104)) {
                        value = new DerivativeStructure(CallChecker.isCalled(t, DerivativeStructure.class, 108, 4067, 4067).getFreeParameters(), CallChecker.isCalled(t, DerivativeStructure.class, 108, 4090, 4090).getOrder(), CallChecker.isCalled(a, double[].class, 108, 4104, 4104)[n]);
                        CallChecker.varAssign(value, "value", 108, 4067, 4067);
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(c, double[].class, 110, 4185, 4185)) {
                    if (CallChecker.beforeDeref(t, DerivativeStructure.class, 110, 4174, 4174)) {
                        final DerivativeStructure npe_invocation_var98 = CallChecker.isCalled(t, DerivativeStructure.class, 110, 4174, 4174).subtract(CallChecker.isCalled(c, double[].class, 110, 4185, 4185)[i]);
                        if (CallChecker.beforeDeref(npe_invocation_var98, DerivativeStructure.class, 110, 4174, 4189)) {
                            if (CallChecker.beforeDeref(a, double[].class, 110, 4211, 4211)) {
                                final DerivativeStructure npe_invocation_var99 = CallChecker.isCalled(npe_invocation_var98, DerivativeStructure.class, 110, 4174, 4189).multiply(value);
                                if (CallChecker.beforeDeref(npe_invocation_var99, DerivativeStructure.class, 110, 4174, 4205)) {
                                    value = CallChecker.isCalled(npe_invocation_var99, DerivativeStructure.class, 110, 4174, 4205).add(CallChecker.isCalled(a, double[].class, 110, 4211, 4211)[i]);
                                    CallChecker.varAssign(value, "value", 110, 4166, 4216);
                                }
                            }
                        }
                    }
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context968.methodEnd();
        }
    }

    public int degree() {
        MethodContext _bcornu_methode_context969 = new MethodContext(int.class, 122, 4263, 4426);
        try {
            CallChecker.varInit(this, "this", 122, 4263, 4426);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 122, 4263, 4426);
            CallChecker.varInit(this.a, "a", 122, 4263, 4426);
            CallChecker.varInit(this.c, "c", 122, 4263, 4426);
            CallChecker.varInit(this.coefficients, "coefficients", 122, 4263, 4426);
            if (CallChecker.beforeDeref(c, double[].class, 123, 4412, 4412)) {
                return CallChecker.isCalled(c, double[].class, 123, 4412, 4412).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context969.methodEnd();
        }
    }

    public double[] getNewtonCoefficients() {
        MethodContext _bcornu_methode_context970 = new MethodContext(double[].class, 133, 4433, 4834);
        try {
            CallChecker.varInit(this, "this", 133, 4433, 4834);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 133, 4433, 4834);
            CallChecker.varInit(this.a, "a", 133, 4433, 4834);
            CallChecker.varInit(this.c, "c", 133, 4433, 4834);
            CallChecker.varInit(this.coefficients, "coefficients", 133, 4433, 4834);
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(a, double[].class, 134, 4749, 4749)) {
                out = new double[CallChecker.isCalled(a, double[].class, 134, 4749, 4749).length];
                CallChecker.varAssign(out, "out", 134, 4749, 4749);
            }
            if (CallChecker.beforeDeref(a, double[].class, 135, 4799, 4799)) {
                System.arraycopy(a, 0, out, 0, CallChecker.isCalled(a, double[].class, 135, 4799, 4799).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context970.methodEnd();
        }
    }

    public double[] getCenters() {
        MethodContext _bcornu_methode_context971 = new MethodContext(double[].class, 146, 4841, 5196);
        try {
            CallChecker.varInit(this, "this", 146, 4841, 5196);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 146, 4841, 5196);
            CallChecker.varInit(this.a, "a", 146, 4841, 5196);
            CallChecker.varInit(this.c, "c", 146, 4841, 5196);
            CallChecker.varInit(this.coefficients, "coefficients", 146, 4841, 5196);
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(c, double[].class, 147, 5111, 5111)) {
                out = new double[CallChecker.isCalled(c, double[].class, 147, 5111, 5111).length];
                CallChecker.varAssign(out, "out", 147, 5111, 5111);
            }
            if (CallChecker.beforeDeref(c, double[].class, 148, 5161, 5161)) {
                System.arraycopy(c, 0, out, 0, CallChecker.isCalled(c, double[].class, 148, 5161, 5161).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context971.methodEnd();
        }
    }

    public double[] getCoefficients() {
        MethodContext _bcornu_methode_context972 = new MethodContext(double[].class, 159, 5203, 5688);
        try {
            CallChecker.varInit(this, "this", 159, 5203, 5688);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 159, 5203, 5688);
            CallChecker.varInit(this.a, "a", 159, 5203, 5688);
            CallChecker.varInit(this.c, "c", 159, 5203, 5688);
            CallChecker.varInit(this.coefficients, "coefficients", 159, 5203, 5688);
            if (!(coefficientsComputed)) {
                computeCoefficients();
            }
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 163, 5570, 5581)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 163, 5570, 5581);
                out = new double[CallChecker.isCalled(coefficients, double[].class, 163, 5570, 5581).length];
                CallChecker.varAssign(out, "out", 163, 5570, 5581);
            }
            if (CallChecker.beforeDeref(coefficients, double[].class, 164, 5642, 5653)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 164, 5642, 5653);
                System.arraycopy(coefficients, 0, out, 0, CallChecker.isCalled(coefficients, double[].class, 164, 5642, 5653).length);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context972.methodEnd();
        }
    }

    public static double evaluate(double[] a, double[] c, double z) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context973 = new MethodContext(double.class, 182, 5695, 6718);
        try {
            CallChecker.varInit(z, "z", 182, 5695, 6718);
            CallChecker.varInit(c, "c", 182, 5695, 6718);
            CallChecker.varInit(a, "a", 182, 5695, 6718);
            PolynomialFunctionNewtonForm.verifyInputArray(a, c);
            c = CallChecker.beforeCalled(c, double[].class, 186, 6552, 6552);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(c, double[].class, 186, 6552, 6552).length)), "n", 186, 6538, 6560);
            double value = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(a, double[].class, 187, 6585, 6585)) {
                a = CallChecker.beforeCalled(a, double[].class, 187, 6585, 6585);
                value = CallChecker.isCalled(a, double[].class, 187, 6585, 6585)[n];
                CallChecker.varAssign(value, "value", 187, 6585, 6585);
            }
            for (int i = n - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(a, double[].class, 189, 6654, 6654)) {
                    if (CallChecker.beforeDeref(c, double[].class, 189, 6666, 6666)) {
                        a = CallChecker.beforeCalled(a, double[].class, 189, 6654, 6654);
                        c = CallChecker.beforeCalled(c, double[].class, 189, 6666, 6666);
                        value = (CallChecker.isCalled(a, double[].class, 189, 6654, 6654)[i]) + ((z - (CallChecker.isCalled(c, double[].class, 189, 6666, 6666)[i])) * value);
                        CallChecker.varAssign(value, "value", 189, 6646, 6679);
                    }
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context973.methodEnd();
        }
    }

    protected void computeCoefficients() {
        MethodContext _bcornu_methode_context974 = new MethodContext(void.class, 199, 6725, 7400);
        try {
            CallChecker.varInit(this, "this", 199, 6725, 7400);
            CallChecker.varInit(this.coefficientsComputed, "coefficientsComputed", 199, 6725, 7400);
            CallChecker.varInit(this.a, "a", 199, 6725, 7400);
            CallChecker.varInit(this.c, "c", 199, 6725, 7400);
            CallChecker.varInit(this.coefficients, "coefficients", 199, 6725, 7400);
            final int n = CallChecker.varInit(((int) (degree())), "n", 200, 6928, 6950);
            coefficients = new double[n + 1];
            CallChecker.varAssign(this.coefficients, "this.coefficients", 202, 6961, 6991);
            for (int i = 0; i <= n; i++) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 204, 7044, 7055)) {
                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 204, 7044, 7055);
                    CallChecker.isCalled(coefficients, double[].class, 204, 7044, 7055)[i] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 204, 7044, 7055)[i], "CallChecker.isCalled(this.coefficients, double[].class, 204, 7044, 7055)[i]", 204, 7044, 7065);
                }
            }
            if (CallChecker.beforeDeref(coefficients, double[].class, 207, 7086, 7097)) {
                if (CallChecker.beforeDeref(a, double[].class, 207, 7104, 7104)) {
                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 207, 7086, 7097);
                    CallChecker.isCalled(coefficients, double[].class, 207, 7086, 7097)[0] = CallChecker.isCalled(a, double[].class, 207, 7104, 7104)[n];
                    CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 207, 7086, 7097)[0], "CallChecker.isCalled(this.coefficients, double[].class, 207, 7086, 7097)[0]", 207, 7086, 7108);
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - i; j > 0; j--) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 210, 7211, 7222)) {
                        if (CallChecker.beforeDeref(coefficients, double[].class, 210, 7229, 7240)) {
                            if (CallChecker.beforeDeref(c, double[].class, 210, 7249, 7249)) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 210, 7256, 7267)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 210, 7211, 7222);
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 210, 7229, 7240);
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 210, 7256, 7267);
                                    CallChecker.isCalled(coefficients, double[].class, 210, 7211, 7222)[j] = (CallChecker.isCalled(coefficients, double[].class, 210, 7229, 7240)[(j - 1)]) - ((CallChecker.isCalled(c, double[].class, 210, 7249, 7249)[i]) * (CallChecker.isCalled(coefficients, double[].class, 210, 7256, 7267)[j]));
                                    CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 210, 7211, 7222)[j], "CallChecker.isCalled(this.coefficients, double[].class, 210, 7211, 7222)[j]", 210, 7211, 7271);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(coefficients, double[].class, 212, 7299, 7310)) {
                    if (CallChecker.beforeDeref(a, double[].class, 212, 7317, 7317)) {
                        if (CallChecker.beforeDeref(c, double[].class, 212, 7324, 7324)) {
                            if (CallChecker.beforeDeref(coefficients, double[].class, 212, 7331, 7342)) {
                                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 212, 7299, 7310);
                                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 212, 7331, 7342);
                                CallChecker.isCalled(coefficients, double[].class, 212, 7299, 7310)[0] = (CallChecker.isCalled(a, double[].class, 212, 7317, 7317)[i]) - ((CallChecker.isCalled(c, double[].class, 212, 7324, 7324)[i]) * (CallChecker.isCalled(coefficients, double[].class, 212, 7331, 7342)[0]));
                                CallChecker.varAssign(CallChecker.isCalled(this.coefficients, double[].class, 212, 7299, 7310)[0], "CallChecker.isCalled(this.coefficients, double[].class, 212, 7299, 7310)[0]", 212, 7299, 7346);
                            }
                        }
                    }
                }
            }
            coefficientsComputed = true;
            CallChecker.varAssign(this.coefficientsComputed, "this.coefficientsComputed", 215, 7367, 7394);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context974.methodEnd();
        }
    }

    protected static void verifyInputArray(double[] a, double[] c) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context975 = new MethodContext(void.class, 233, 7407, 8695);
        try {
            CallChecker.varInit(c, "c", 233, 7407, 8695);
            CallChecker.varInit(a, "a", 233, 7407, 8695);
            MathUtils.checkNotNull(a);
            MathUtils.checkNotNull(c);
            if (CallChecker.beforeDeref(a, double[].class, 237, 8329, 8329)) {
                if (CallChecker.beforeDeref(c, double[].class, 237, 8346, 8346)) {
                    a = CallChecker.beforeCalled(a, double[].class, 237, 8329, 8329);
                    c = CallChecker.beforeCalled(c, double[].class, 237, 8346, 8346);
                    if (((CallChecker.isCalled(a, double[].class, 237, 8329, 8329).length) == 0) || ((CallChecker.isCalled(c, double[].class, 237, 8346, 8346).length) == 0)) {
                        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
                    }
                }
            }
            if (CallChecker.beforeDeref(a, double[].class, 240, 8479, 8479)) {
                if (CallChecker.beforeDeref(c, double[].class, 240, 8491, 8491)) {
                    a = CallChecker.beforeCalled(a, double[].class, 240, 8479, 8479);
                    c = CallChecker.beforeCalled(c, double[].class, 240, 8491, 8491);
                    if ((CallChecker.isCalled(a, double[].class, 240, 8479, 8479).length) != ((CallChecker.isCalled(c, double[].class, 240, 8491, 8491).length) + 1)) {
                        if (CallChecker.beforeDeref(a, double[].class, 242, 8660, 8660)) {
                            if (CallChecker.beforeDeref(c, double[].class, 242, 8670, 8670)) {
                                a = CallChecker.beforeCalled(a, double[].class, 242, 8660, 8660);
                                c = CallChecker.beforeCalled(c, double[].class, 242, 8670, 8670);
                                throw new DimensionMismatchException(LocalizedFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, CallChecker.isCalled(a, double[].class, 242, 8660, 8660).length, CallChecker.isCalled(c, double[].class, 242, 8670, 8670).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context975.methodEnd();
        }
    }
}

