package org.apache.commons.math3.analysis.polynomials;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class PolynomialFunction implements Serializable , DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double[] gradient(double x, double... parameters) {
            MethodContext _bcornu_methode_context4453 = new MethodContext(double[].class, 397, 14152, 14507);
            try {
                CallChecker.varInit(this, "this", 397, 14152, 14507);
                CallChecker.varInit(parameters, "parameters", 397, 14152, 14507);
                CallChecker.varInit(x, "x", 397, 14152, 14507);
                parameters = CallChecker.beforeCalled(parameters, double[].class, 398, 14290, 14299);
                final double[] gradient = CallChecker.varInit(new double[CallChecker.isCalled(parameters, double[].class, 398, 14290, 14299).length], "gradient", 398, 14253, 14308);
                double xn = CallChecker.varInit(((double) (1.0)), "xn", 399, 14322, 14337);
                parameters = CallChecker.beforeCalled(parameters, double[].class, 400, 14371, 14380);
                for (int i = 0; i < (CallChecker.isCalled(parameters, double[].class, 400, 14371, 14380).length); ++i) {
                    if (CallChecker.beforeDeref(gradient, double[].class, 401, 14413, 14420)) {
                        CallChecker.isCalled(gradient, double[].class, 401, 14413, 14420)[i] = xn;
                        CallChecker.varAssign(CallChecker.isCalled(gradient, double[].class, 401, 14413, 14420)[i], "CallChecker.isCalled(gradient, double[].class, 401, 14413, 14420)[i]", 401, 14413, 14429);
                    }
                    xn *= x;
                    CallChecker.varAssign(xn, "xn", 402, 14447, 14454);
                }
                return gradient;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4453.methodEnd();
            }
        }

        public double value(final double x, final double... parameters) throws NoDataException {
            MethodContext _bcornu_methode_context4454 = new MethodContext(double.class, 408, 14518, 14720);
            try {
                CallChecker.varInit(this, "this", 408, 14518, 14720);
                CallChecker.varInit(parameters, "parameters", 408, 14518, 14720);
                CallChecker.varInit(x, "x", 408, 14518, 14720);
                return PolynomialFunction.evaluate(parameters, x);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4454.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = -7726511984200295583L;

    private final double[] coefficients;

    public PolynomialFunction(double[] c) throws NoDataException, NullArgumentException {
        super();
        ConstructorContext _bcornu_methode_context1004 = new ConstructorContext(PolynomialFunction.class, 67, 2330, 3446);
        try {
            MathUtils.checkNotNull(c);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(c, double[].class, 71, 3134, 3134)) {
                c = CallChecker.beforeCalled(c, double[].class, 71, 3134, 3134);
                n = CallChecker.isCalled(c, double[].class, 71, 3134, 3134).length;
                CallChecker.varAssign(n, "n", 71, 3134, 3134);
            }
            if (n == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
            }
            c = CallChecker.beforeCalled(c, double[].class, 75, 3297, 3297);
            while ((n > 1) && ((CallChecker.isCalled(c, double[].class, 75, 3297, 3297)[(n - 1)]) == 0)) {
                --n;
            } 
            this.coefficients = new double[n];
            CallChecker.varAssign(this.coefficients, "this.coefficients", 78, 3350, 3383);
            System.arraycopy(c, 0, this.coefficients, 0, n);
        } finally {
            _bcornu_methode_context1004.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context4455 = new MethodContext(double.class, 93, 3453, 3949);
        try {
            CallChecker.varInit(this, "this", 93, 3453, 3949);
            CallChecker.varInit(x, "x", 93, 3453, 3949);
            CallChecker.varInit(this.coefficients, "coefficients", 93, 3453, 3949);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 93, 3453, 3949);
            return PolynomialFunction.evaluate(coefficients, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4455.methodEnd();
        }
    }

    public int degree() {
        MethodContext _bcornu_methode_context4456 = new MethodContext(int.class, 102, 3956, 4135);
        try {
            CallChecker.varInit(this, "this", 102, 3956, 4135);
            CallChecker.varInit(this.coefficients, "coefficients", 102, 3956, 4135);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 102, 3956, 4135);
            return (CallChecker.isCalled(coefficients, double[].class, 103, 4106, 4117).length) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4456.methodEnd();
        }
    }

    public double[] getCoefficients() {
        MethodContext _bcornu_methode_context4457 = new MethodContext(double[].class, 114, 4142, 4461);
        try {
            CallChecker.varInit(this, "this", 114, 4142, 4461);
            CallChecker.varInit(this.coefficients, "coefficients", 114, 4142, 4461);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 114, 4142, 4461);
            if (CallChecker.beforeDeref(coefficients, double[].class, 115, 4435, 4446)) {
                return CallChecker.isCalled(coefficients, double[].class, 115, 4435, 4446).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4457.methodEnd();
        }
    }

    protected static double evaluate(double[] coefficients, double argument) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context4458 = new MethodContext(double.class, 128, 4468, 5413);
        try {
            CallChecker.varInit(argument, "argument", 128, 4468, 5413);
            CallChecker.varInit(coefficients, "coefficients", 128, 4468, 5413);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 128, 4468, 5413);
            MathUtils.checkNotNull(coefficients);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 131, 5083, 5094)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 131, 5083, 5094);
                n = CallChecker.isCalled(coefficients, double[].class, 131, 5083, 5094).length;
                CallChecker.varAssign(n, "n", 131, 5083, 5094);
            }
            if (n == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
            }
            double result = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 135, 5254, 5265)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 135, 5254, 5265);
                result = CallChecker.isCalled(coefficients, double[].class, 135, 5254, 5265)[(n - 1)];
                CallChecker.varAssign(result, "result", 135, 5254, 5265);
            }
            for (int j = n - 2; j >= 0; j--) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 137, 5359, 5370)) {
                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 137, 5359, 5370);
                    result = (argument * result) + (CallChecker.isCalled(coefficients, double[].class, 137, 5359, 5370)[j]);
                    CallChecker.varAssign(result, "result", 137, 5330, 5374);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4458.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context4459 = new MethodContext(DerivativeStructure.class, 148, 5421, 6217);
        try {
            CallChecker.varInit(this, "this", 148, 5421, 6217);
            CallChecker.varInit(t, "t", 148, 5421, 6217);
            CallChecker.varInit(this.coefficients, "coefficients", 148, 5421, 6217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 148, 5421, 6217);
            MathUtils.checkNotNull(coefficients);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 151, 5792, 5803)) {
                n = CallChecker.isCalled(coefficients, double[].class, 151, 5792, 5803).length;
                CallChecker.varAssign(n, "n", 151, 5792, 5803);
            }
            if (n == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
            }
            DerivativeStructure result = CallChecker.init(DerivativeStructure.class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 156, 6016, 6016)) {
                if (CallChecker.beforeDeref(t, DerivativeStructure.class, 156, 6039, 6039)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 156, 6053, 6064)) {
                        result = new DerivativeStructure(CallChecker.isCalled(t, DerivativeStructure.class, 156, 6016, 6016).getFreeParameters(), CallChecker.isCalled(t, DerivativeStructure.class, 156, 6039, 6039).getOrder(), CallChecker.isCalled(coefficients, double[].class, 156, 6053, 6064)[(n - 1)]);
                        CallChecker.varAssign(result, "result", 156, 6016, 6016);
                    }
                }
            }
            for (int j = n - 2; j >= 0; j--) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 158, 6139, 6144)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 158, 6162, 6173)) {
                        result = CallChecker.beforeCalled(result, DerivativeStructure.class, 158, 6139, 6144);
                        final DerivativeStructure npe_invocation_var933 = CallChecker.isCalled(result, DerivativeStructure.class, 158, 6139, 6144).multiply(t);
                        if (CallChecker.beforeDeref(npe_invocation_var933, DerivativeStructure.class, 158, 6139, 6156)) {
                            result = CallChecker.isCalled(npe_invocation_var933, DerivativeStructure.class, 158, 6139, 6156).add(CallChecker.isCalled(coefficients, double[].class, 158, 6162, 6173)[j]);
                            CallChecker.varAssign(result, "result", 158, 6130, 6178);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4459.methodEnd();
        }
    }

    public PolynomialFunction add(final PolynomialFunction p) {
        MethodContext _bcornu_methode_context4460 = new MethodContext(PolynomialFunction.class, 169, 6224, 7245);
        try {
            CallChecker.varInit(this, "this", 169, 6224, 7245);
            CallChecker.varInit(p, "p", 169, 6224, 7245);
            CallChecker.varInit(this.coefficients, "coefficients", 169, 6224, 7245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 169, 6224, 7245);
            final int lowLength = CallChecker.varInit(((int) (FastMath.min(CallChecker.isCalled(this.coefficients, double[].class, 171, 6556, 6567).length, CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 171, 6577, 6577).coefficients, double[].class, 171, 6577, 6590).length))), "lowLength", 171, 6471, 6599);
            final int highLength = CallChecker.varInit(((int) (FastMath.max(CallChecker.isCalled(this.coefficients, double[].class, 172, 6645, 6656).length, CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 172, 6666, 6666).coefficients, double[].class, 172, 6666, 6679).length))), "highLength", 172, 6609, 6688);
            double[] newCoefficients = CallChecker.varInit(new double[highLength], "newCoefficients", 175, 6739, 6788);
            for (int i = 0; i < lowLength; ++i) {
                if (CallChecker.beforeDeref(newCoefficients, double[].class, 177, 6848, 6862)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 177, 6869, 6880)) {
                        if (CallChecker.beforeDeref(p, PolynomialFunction.class, 177, 6887, 6887)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 177, 6887, 6887).coefficients, double[].class, 177, 6887, 6900)) {
                                newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 177, 6848, 6862);
                                CallChecker.isCalled(newCoefficients, double[].class, 177, 6848, 6862)[i] = (CallChecker.isCalled(coefficients, double[].class, 177, 6869, 6880)[i]) + (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 177, 6887, 6887).coefficients, double[].class, 177, 6887, 6900)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 177, 6848, 6862)[i], "CallChecker.isCalled(newCoefficients, double[].class, 177, 6848, 6862)[i]", 177, 6848, 6904);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(coefficients, double[].class, 179, 6942, 6953)) {
                if (CallChecker.beforeDeref(p, PolynomialFunction.class, 179, 6964, 6964)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 179, 6964, 6964).coefficients, double[].class, 179, 6964, 6977)) {
                        if ((CallChecker.isCalled(coefficients, double[].class, 179, 6942, 6953).length) < (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 179, 6964, 6964).coefficients, double[].class, 179, 6964, 6977).length)) {
                            System.arraycopy(CallChecker.isCalled(p, PolynomialFunction.class, 180, 7014, 7014).coefficients, lowLength, newCoefficients, lowLength, (highLength - lowLength));
                        }else {
                            System.arraycopy(coefficients, lowLength, newCoefficients, lowLength, (highLength - lowLength));
                        }
                    }
                }
            }
            return new PolynomialFunction(newCoefficients);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4460.methodEnd();
        }
    }

    public PolynomialFunction subtract(final PolynomialFunction p) {
        MethodContext _bcornu_methode_context4461 = new MethodContext(PolynomialFunction.class, 194, 7252, 8368);
        try {
            CallChecker.varInit(this, "this", 194, 7252, 8368);
            CallChecker.varInit(p, "p", 194, 7252, 8368);
            CallChecker.varInit(this.coefficients, "coefficients", 194, 7252, 8368);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 194, 7252, 8368);
            int lowLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 196, 7601, 7612)) {
                if (CallChecker.beforeDeref(p, PolynomialFunction.class, 196, 7622, 7622)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 196, 7622, 7622).coefficients, double[].class, 196, 7622, 7635)) {
                        lowLength = FastMath.min(CallChecker.isCalled(coefficients, double[].class, 196, 7601, 7612).length, CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 196, 7622, 7622).coefficients, double[].class, 196, 7622, 7635).length);
                        CallChecker.varAssign(lowLength, "lowLength", 196, 7601, 7612);
                    }
                }
            }
            int highLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 197, 7684, 7695)) {
                if (CallChecker.beforeDeref(p, PolynomialFunction.class, 197, 7705, 7705)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 197, 7705, 7705).coefficients, double[].class, 197, 7705, 7718)) {
                        highLength = FastMath.max(CallChecker.isCalled(coefficients, double[].class, 197, 7684, 7695).length, CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 197, 7705, 7705).coefficients, double[].class, 197, 7705, 7718).length);
                        CallChecker.varAssign(highLength, "highLength", 197, 7684, 7695);
                    }
                }
            }
            double[] newCoefficients = CallChecker.varInit(new double[highLength], "newCoefficients", 200, 7778, 7827);
            for (int i = 0; i < lowLength; ++i) {
                if (CallChecker.beforeDeref(newCoefficients, double[].class, 202, 7887, 7901)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 202, 7908, 7919)) {
                        if (CallChecker.beforeDeref(p, PolynomialFunction.class, 202, 7926, 7926)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 202, 7926, 7926).coefficients, double[].class, 202, 7926, 7939)) {
                                newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 202, 7887, 7901);
                                CallChecker.isCalled(newCoefficients, double[].class, 202, 7887, 7901)[i] = (CallChecker.isCalled(coefficients, double[].class, 202, 7908, 7919)[i]) - (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 202, 7926, 7926).coefficients, double[].class, 202, 7926, 7939)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 202, 7887, 7901)[i], "CallChecker.isCalled(newCoefficients, double[].class, 202, 7887, 7901)[i]", 202, 7887, 7943);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(coefficients, double[].class, 204, 7967, 7978)) {
                if (CallChecker.beforeDeref(p, PolynomialFunction.class, 204, 7989, 7989)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 204, 7989, 7989).coefficients, double[].class, 204, 7989, 8002)) {
                        if ((CallChecker.isCalled(coefficients, double[].class, 204, 7967, 7978).length) < (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 204, 7989, 7989).coefficients, double[].class, 204, 7989, 8002).length)) {
                            for (int i = lowLength; i < highLength; ++i) {
                                if (CallChecker.beforeDeref(newCoefficients, double[].class, 206, 8089, 8103)) {
                                    if (CallChecker.beforeDeref(p, PolynomialFunction.class, 206, 8111, 8111)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 206, 8111, 8111).coefficients, double[].class, 206, 8111, 8124)) {
                                            newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 206, 8089, 8103);
                                            CallChecker.isCalled(newCoefficients, double[].class, 206, 8089, 8103)[i] = -(CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 206, 8111, 8111).coefficients, double[].class, 206, 8111, 8124)[i]);
                                            CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 206, 8089, 8103)[i], "CallChecker.isCalled(newCoefficients, double[].class, 206, 8089, 8103)[i]", 206, 8089, 8128);
                                        }
                                    }
                                }
                            }
                        }else {
                            System.arraycopy(coefficients, lowLength, newCoefficients, lowLength, (highLength - lowLength));
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return new PolynomialFunction(newCoefficients);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4461.methodEnd();
        }
    }

    public PolynomialFunction negate() {
        MethodContext _bcornu_methode_context4462 = new MethodContext(PolynomialFunction.class, 221, 8375, 8741);
        try {
            CallChecker.varInit(this, "this", 221, 8375, 8741);
            CallChecker.varInit(this.coefficients, "coefficients", 221, 8375, 8741);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 221, 8375, 8741);
            double[] newCoefficients = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 222, 8542, 8553)) {
                newCoefficients = new double[CallChecker.isCalled(coefficients, double[].class, 222, 8542, 8553).length];
                CallChecker.varAssign(newCoefficients, "newCoefficients", 222, 8542, 8553);
            }
            for (int i = 0; i < (CallChecker.isCalled(coefficients, double[].class, 223, 8592, 8603).length); ++i) {
                if (CallChecker.beforeDeref(newCoefficients, double[].class, 224, 8632, 8646)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 224, 8654, 8665)) {
                        newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 224, 8632, 8646);
                        CallChecker.isCalled(newCoefficients, double[].class, 224, 8632, 8646)[i] = -(CallChecker.isCalled(coefficients, double[].class, 224, 8654, 8665)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 224, 8632, 8646)[i], "CallChecker.isCalled(newCoefficients, double[].class, 224, 8632, 8646)[i]", 224, 8632, 8669);
                    }
                }
            }
            return new PolynomialFunction(newCoefficients);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4462.methodEnd();
        }
    }

    public PolynomialFunction multiply(final PolynomialFunction p) {
        MethodContext _bcornu_methode_context4463 = new MethodContext(PolynomialFunction.class, 235, 8748, 9474);
        try {
            CallChecker.varInit(this, "this", 235, 8748, 9474);
            CallChecker.varInit(p, "p", 235, 8748, 9474);
            CallChecker.varInit(this.coefficients, "coefficients", 235, 8748, 9474);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 235, 8748, 9474);
            double[] newCoefficients = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 236, 9004, 9015)) {
                if (CallChecker.beforeDeref(p, PolynomialFunction.class, 236, 9026, 9026)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 236, 9026, 9026).coefficients, double[].class, 236, 9026, 9039)) {
                        newCoefficients = new double[((CallChecker.isCalled(coefficients, double[].class, 236, 9004, 9015).length) + (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 236, 9026, 9026).coefficients, double[].class, 236, 9026, 9039).length)) - 1];
                        CallChecker.varAssign(newCoefficients, "newCoefficients", 236, 9004, 9015);
                    }
                }
            }
            newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 238, 9083, 9097);
            for (int i = 0; i < (CallChecker.isCalled(newCoefficients, double[].class, 238, 9083, 9097).length); ++i) {
                if (CallChecker.beforeDeref(newCoefficients, double[].class, 239, 9126, 9140)) {
                    newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 239, 9126, 9140);
                    CallChecker.isCalled(newCoefficients, double[].class, 239, 9126, 9140)[i] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 239, 9126, 9140)[i], "CallChecker.isCalled(newCoefficients, double[].class, 239, 9126, 9140)[i]", 239, 9126, 9150);
                }
                for (int j = FastMath.max(0, ((i + 1) - (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 240, 9201, 9201).coefficients, double[].class, 240, 9201, 9214).length))); j < (FastMath.min(CallChecker.isCalled(coefficients, double[].class, 241, 9259, 9270).length, (i + 1))); ++j) {
                    if (CallChecker.beforeDeref(newCoefficients, double[].class, 243, 9328, 9342)) {
                        if (CallChecker.beforeDeref(coefficients, double[].class, 243, 9350, 9361)) {
                            if (CallChecker.beforeDeref(p, PolynomialFunction.class, 243, 9368, 9368)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(p, PolynomialFunction.class, 243, 9368, 9368).coefficients, double[].class, 243, 9368, 9381)) {
                                    newCoefficients = CallChecker.beforeCalled(newCoefficients, double[].class, 243, 9328, 9342);
                                    CallChecker.isCalled(newCoefficients, double[].class, 243, 9328, 9342)[i] += (CallChecker.isCalled(coefficients, double[].class, 243, 9350, 9361)[j]) * (CallChecker.isCalled(CallChecker.isCalled(p, PolynomialFunction.class, 243, 9368, 9368).coefficients, double[].class, 243, 9368, 9381)[(i - j)]);
                                    CallChecker.varAssign(CallChecker.isCalled(newCoefficients, double[].class, 243, 9328, 9342)[i], "CallChecker.isCalled(newCoefficients, double[].class, 243, 9328, 9342)[i]", 243, 9328, 9387);
                                }
                            }
                        }
                    }
                }
            }
            return new PolynomialFunction(newCoefficients);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4463.methodEnd();
        }
    }

    protected static double[] differentiate(double[] coefficients) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context4464 = new MethodContext(double[].class, 258, 9481, 10485);
        try {
            CallChecker.varInit(coefficients, "coefficients", 258, 9481, 10485);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 258, 9481, 10485);
            MathUtils.checkNotNull(coefficients);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(coefficients, double[].class, 261, 10097, 10108)) {
                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 261, 10097, 10108);
                n = CallChecker.isCalled(coefficients, double[].class, 261, 10097, 10108).length;
                CallChecker.varAssign(n, "n", 261, 10097, 10108);
            }
            if (n == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
            }
            if (n == 1) {
                return new double[]{ 0 };
            }
            double[] result = CallChecker.varInit(new double[n - 1], "result", 268, 10320, 10355);
            for (int i = n - 1; i > 0; i--) {
                if (CallChecker.beforeDeref(result, double[].class, 270, 10411, 10416)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 270, 10431, 10442)) {
                        result = CallChecker.beforeCalled(result, double[].class, 270, 10411, 10416);
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 270, 10431, 10442);
                        CallChecker.isCalled(result, double[].class, 270, 10411, 10416)[(i - 1)] = i * (CallChecker.isCalled(coefficients, double[].class, 270, 10431, 10442)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 270, 10411, 10416)[(i - 1)], "CallChecker.isCalled(result, double[].class, 270, 10411, 10416)[(i - 1)]", 270, 10411, 10446);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4464.methodEnd();
        }
    }

    public PolynomialFunction polynomialDerivative() {
        MethodContext _bcornu_methode_context4465 = new MethodContext(PolynomialFunction.class, 280, 10492, 10743);
        try {
            CallChecker.varInit(this, "this", 280, 10492, 10743);
            CallChecker.varInit(this.coefficients, "coefficients", 280, 10492, 10743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 280, 10492, 10743);
            return new PolynomialFunction(PolynomialFunction.differentiate(coefficients));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4465.methodEnd();
        }
    }

    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4466 = new MethodContext(UnivariateFunction.class, 289, 10750, 10960);
        try {
            CallChecker.varInit(this, "this", 289, 10750, 10960);
            CallChecker.varInit(this.coefficients, "coefficients", 289, 10750, 10960);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 289, 10750, 10960);
            return polynomialDerivative();
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4466.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4467 = new MethodContext(String.class, 309, 10967, 12916);
        try {
            CallChecker.varInit(this, "this", 309, 10967, 12916);
            CallChecker.varInit(this.coefficients, "coefficients", 309, 10967, 12916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 309, 10967, 12916);
            StringBuilder s = CallChecker.varInit(new StringBuilder(), "s", 310, 11785, 11822);
            if (CallChecker.beforeDeref(coefficients, double[].class, 311, 11836, 11847)) {
                if ((CallChecker.isCalled(coefficients, double[].class, 311, 11836, 11847)[0]) == 0.0) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 312, 11878, 11889)) {
                        if ((CallChecker.isCalled(coefficients, double[].class, 312, 11878, 11889).length) == 1) {
                            return "0";
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 316, 11995, 12006)) {
                        if (CallChecker.beforeDeref(s, StringBuilder.class, 316, 11977, 11977)) {
                            s = CallChecker.beforeCalled(s, StringBuilder.class, 316, 11977, 11977);
                            CallChecker.isCalled(s, StringBuilder.class, 316, 11977, 11977).append(PolynomialFunction.toString(CallChecker.isCalled(coefficients, double[].class, 316, 11995, 12006)[0]));
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 1; i < (CallChecker.isCalled(coefficients, double[].class, 319, 12053, 12064).length); ++i) {
                if (CallChecker.beforeDeref(coefficients, double[].class, 320, 12097, 12108)) {
                    if ((CallChecker.isCalled(coefficients, double[].class, 320, 12097, 12108)[i]) != 0) {
                        if (CallChecker.beforeDeref(s, StringBuilder.class, 321, 12141, 12141)) {
                            s = CallChecker.beforeCalled(s, StringBuilder.class, 321, 12141, 12141);
                            if ((CallChecker.isCalled(s, StringBuilder.class, 321, 12141, 12141).length()) > 0) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 322, 12183, 12194)) {
                                    if ((CallChecker.isCalled(coefficients, double[].class, 322, 12183, 12194)[i]) < 0) {
                                        if (CallChecker.beforeDeref(s, StringBuilder.class, 323, 12230, 12230)) {
                                            s = CallChecker.beforeCalled(s, StringBuilder.class, 323, 12230, 12230);
                                            CallChecker.isCalled(s, StringBuilder.class, 323, 12230, 12230).append(" - ");
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(s, StringBuilder.class, 325, 12300, 12300)) {
                                            s = CallChecker.beforeCalled(s, StringBuilder.class, 325, 12300, 12300);
                                            CallChecker.isCalled(s, StringBuilder.class, 325, 12300, 12300).append(" + ");
                                        }
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 328, 12388, 12399)) {
                                    if ((CallChecker.isCalled(coefficients, double[].class, 328, 12388, 12399)[i]) < 0) {
                                        if (CallChecker.beforeDeref(s, StringBuilder.class, 329, 12435, 12435)) {
                                            s = CallChecker.beforeCalled(s, StringBuilder.class, 329, 12435, 12435);
                                            CallChecker.isCalled(s, StringBuilder.class, 329, 12435, 12435).append("-");
                                        }
                                    }
                                }
                            }
                        }
                        double absAi = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(coefficients, double[].class, 333, 12535, 12546)) {
                            absAi = FastMath.abs(CallChecker.isCalled(coefficients, double[].class, 333, 12535, 12546)[i]);
                            CallChecker.varAssign(absAi, "absAi", 333, 12535, 12546);
                        }
                        if ((absAi - 1) != 0) {
                            if (CallChecker.beforeDeref(s, StringBuilder.class, 335, 12613, 12613)) {
                                s = CallChecker.beforeCalled(s, StringBuilder.class, 335, 12613, 12613);
                                CallChecker.isCalled(s, StringBuilder.class, 335, 12613, 12613).append(PolynomialFunction.toString(absAi));
                            }
                            if (CallChecker.beforeDeref(s, StringBuilder.class, 336, 12660, 12660)) {
                                s = CallChecker.beforeCalled(s, StringBuilder.class, 336, 12660, 12660);
                                CallChecker.isCalled(s, StringBuilder.class, 336, 12660, 12660).append(' ');
                            }
                        }
                        if (CallChecker.beforeDeref(s, StringBuilder.class, 339, 12710, 12710)) {
                            s = CallChecker.beforeCalled(s, StringBuilder.class, 339, 12710, 12710);
                            CallChecker.isCalled(s, StringBuilder.class, 339, 12710, 12710).append("x");
                        }
                        if (i > 1) {
                            if (CallChecker.beforeDeref(s, StringBuilder.class, 341, 12774, 12774)) {
                                s = CallChecker.beforeCalled(s, StringBuilder.class, 341, 12774, 12774);
                                CallChecker.isCalled(s, StringBuilder.class, 341, 12774, 12774).append('^');
                            }
                            if (CallChecker.beforeDeref(s, StringBuilder.class, 342, 12809, 12809)) {
                                s = CallChecker.beforeCalled(s, StringBuilder.class, 342, 12809, 12809);
                                CallChecker.isCalled(s, StringBuilder.class, 342, 12809, 12809).append(Integer.toString(i));
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(s, StringBuilder.class, 347, 12898, 12898)) {
                s = CallChecker.beforeCalled(s, StringBuilder.class, 347, 12898, 12898);
                return CallChecker.isCalled(s, StringBuilder.class, 347, 12898, 12898).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4467.methodEnd();
        }
    }

    private static String toString(double coeff) {
        MethodContext _bcornu_methode_context4468 = new MethodContext(String.class, 356, 12923, 13343);
        try {
            CallChecker.varInit(coeff, "coeff", 356, 12923, 13343);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 356, 12923, 13343);
            final String c = CallChecker.varInit(Double.toString(coeff), "c", 357, 13166, 13205);
            if (CallChecker.beforeDeref(c, String.class, 358, 13219, 13219)) {
                if (CallChecker.isCalled(c, String.class, 358, 13219, 13219).endsWith(".0")) {
                    if (CallChecker.beforeDeref(c, String.class, 359, 13258, 13258)) {
                        return CallChecker.isCalled(c, String.class, 359, 13258, 13258).substring(0, ((CallChecker.isCalled(c, String.class, 359, 13273, 13273).length()) - 2));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    return c;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4468.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4469 = new MethodContext(int.class, 367, 13350, 13559);
        try {
            CallChecker.varInit(this, "this", 367, 13350, 13559);
            CallChecker.varInit(this.coefficients, "coefficients", 367, 13350, 13559);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 367, 13350, 13559);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 368, 13421, 13441);
            int result = CallChecker.varInit(((int) (1)), "result", 369, 13451, 13465);
            result = (prime * result) + (Arrays.hashCode(coefficients));
            CallChecker.varAssign(result, "result", 370, 13475, 13530);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4469.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context4470 = new MethodContext(boolean.class, 376, 13566, 13977);
        try {
            CallChecker.varInit(this, "this", 376, 13566, 13977);
            CallChecker.varInit(obj, "obj", 376, 13566, 13977);
            CallChecker.varInit(this.coefficients, "coefficients", 376, 13566, 13977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.polynomials.PolynomialFunction.serialVersionUID", 376, 13566, 13977);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof PolynomialFunction)) {
                return false;
            }
            PolynomialFunction other = CallChecker.varInit(((PolynomialFunction) (obj)), "other", 383, 13799, 13850);
            if (CallChecker.beforeDeref(other, PolynomialFunction.class, 384, 13893, 13897)) {
                other = CallChecker.beforeCalled(other, PolynomialFunction.class, 384, 13893, 13897);
                if (!(Arrays.equals(coefficients, CallChecker.isCalled(other, PolynomialFunction.class, 384, 13893, 13897).coefficients))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4470.methodEnd();
        }
    }
}

