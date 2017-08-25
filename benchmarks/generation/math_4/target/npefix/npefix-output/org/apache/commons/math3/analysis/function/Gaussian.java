package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class Gaussian implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double value(double x, double... param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context301 = new MethodContext(double.class, 127, 4020, 4950);
            try {
                CallChecker.varInit(this, "this", 127, 4020, 4950);
                CallChecker.varInit(param, "param", 127, 4020, 4950);
                CallChecker.varInit(x, "x", 127, 4020, 4950);
                validateParameters(param);
                param = CallChecker.beforeCalled(param, double[].class, 133, 4812, 4816);
                final double diff = CallChecker.varInit(((double) (x - (CallChecker.isCalled(param, double[].class, 133, 4812, 4816)[1]))), "diff", 133, 4788, 4820);
                param = CallChecker.beforeCalled(param, double[].class, 134, 4863, 4867);
                param = CallChecker.beforeCalled(param, double[].class, 134, 4874, 4878);
                final double i2s2 = CallChecker.varInit(((double) (1 / ((2 * (CallChecker.isCalled(param, double[].class, 134, 4863, 4867)[2])) * (CallChecker.isCalled(param, double[].class, 134, 4874, 4878)[2])))), "i2s2", 134, 4834, 4883);
                if (CallChecker.beforeDeref(param, double[].class, 135, 4925, 4929)) {
                    param = CallChecker.beforeCalled(param, double[].class, 135, 4925, 4929);
                    return Gaussian.value(diff, CallChecker.isCalled(param, double[].class, 135, 4925, 4929)[0], i2s2);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context301.methodEnd();
            }
        }

        public double[] gradient(double x, double... param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context302 = new MethodContext(double[].class, 152, 4961, 6335);
            try {
                CallChecker.varInit(this, "this", 152, 4961, 6335);
                CallChecker.varInit(param, "param", 152, 4961, 6335);
                CallChecker.varInit(x, "x", 152, 4961, 6335);
                validateParameters(param);
                param = CallChecker.beforeCalled(param, double[].class, 158, 5960, 5964);
                final double norm = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 158, 5960, 5964)[0])), "norm", 158, 5940, 5968);
                param = CallChecker.beforeCalled(param, double[].class, 159, 6006, 6010);
                final double diff = CallChecker.varInit(((double) (x - (CallChecker.isCalled(param, double[].class, 159, 6006, 6010)[1]))), "diff", 159, 5982, 6014);
                param = CallChecker.beforeCalled(param, double[].class, 160, 6049, 6053);
                final double sigma = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 160, 6049, 6053)[2])), "sigma", 160, 6028, 6057);
                final double i2s2 = CallChecker.varInit(((double) (1 / ((2 * sigma) * sigma))), "i2s2", 161, 6071, 6114);
                final double n = CallChecker.varInit(((double) (Gaussian.value(diff, 1, i2s2))), "n", 163, 6129, 6175);
                final double m = CallChecker.varInit(((double) ((((norm * n) * 2) * i2s2) * diff)), "m", 164, 6189, 6232);
                final double s = CallChecker.varInit(((double) ((m * diff) / sigma)), "s", 165, 6246, 6279);
                return new double[]{ n , m , s };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context302.methodEnd();
            }
        }

        private void validateParameters(double[] param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context303 = new MethodContext(void.class, 181, 6346, 7421);
            try {
                CallChecker.varInit(this, "this", 181, 6346, 7421);
                CallChecker.varInit(param, "param", 181, 6346, 7421);
                if (param == null) {
                    throw new NullArgumentException();
                }
                if ((param.length) != 3) {
                    throw new DimensionMismatchException(param.length, 3);
                }
                if ((param[2]) <= 0) {
                    throw new NotStrictlyPositiveException(param[2]);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context303.methodEnd();
            }
        }
    }

    private final double mean;

    private final double is;

    private final double i2s2;

    private final double norm;

    public Gaussian(double norm, double mean, double sigma) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context73 = new ConstructorContext(Gaussian.class, 59, 2139, 2773);
        try {
            if (sigma <= 0) {
                throw new NotStrictlyPositiveException(sigma);
            }
            this.norm = norm;
            CallChecker.varAssign(this.norm, "this.norm", 67, 2659, 2675);
            this.mean = mean;
            CallChecker.varAssign(this.mean, "this.mean", 68, 2685, 2701);
            this.is = 1 / sigma;
            CallChecker.varAssign(this.is, "this.is", 69, 2711, 2732);
            this.i2s2 = (0.5 * (is)) * (is);
            CallChecker.varAssign(this.i2s2, "this.i2s2", 70, 2742, 2767);
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public Gaussian(double mean, double sigma) throws NotStrictlyPositiveException {
        this((1 / (sigma * (FastMath.sqrt((2 * (Math.PI)))))), mean, sigma);
        ConstructorContext _bcornu_methode_context74 = new ConstructorContext(Gaussian.class, 80, 2780, 3184);
        try {
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    public Gaussian() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context75 = new ConstructorContext(Gaussian.class, 89, 3191, 3322);
        try {
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context304 = new MethodContext(double.class, 94, 3329, 3434);
        try {
            CallChecker.varInit(this, "this", 94, 3329, 3434);
            CallChecker.varInit(x, "x", 94, 3329, 3434);
            CallChecker.varInit(this.norm, "norm", 94, 3329, 3434);
            CallChecker.varInit(this.i2s2, "i2s2", 94, 3329, 3434);
            CallChecker.varInit(this.is, "is", 94, 3329, 3434);
            CallChecker.varInit(this.mean, "mean", 94, 3329, 3434);
            return Gaussian.value((x - (mean)), norm, i2s2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context304.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context305 = new MethodContext(UnivariateFunction.class, 102, 3441, 3694);
        try {
            CallChecker.varInit(this, "this", 102, 3441, 3694);
            CallChecker.varInit(this.norm, "norm", 102, 3441, 3694);
            CallChecker.varInit(this.i2s2, "i2s2", 102, 3441, 3694);
            CallChecker.varInit(this.is, "is", 102, 3441, 3694);
            CallChecker.varInit(this.mean, "mean", 102, 3441, 3694);
            final DifferentiableUnivariateFunction npe_invocation_var33 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var33, DifferentiableUnivariateFunction.class, 103, 3621, 3674)) {
                return CallChecker.isCalled(npe_invocation_var33, DifferentiableUnivariateFunction.class, 103, 3621, 3674).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context305.methodEnd();
        }
    }

    private static double value(double xMinusMean, double norm, double i2s2) {
        MethodContext _bcornu_methode_context306 = new MethodContext(double.class, 203, 7434, 7875);
        try {
            CallChecker.varInit(i2s2, "i2s2", 203, 7434, 7875);
            CallChecker.varInit(norm, "norm", 203, 7434, 7875);
            CallChecker.varInit(xMinusMean, "xMinusMean", 203, 7434, 7875);
            return norm * (FastMath.exp((((-xMinusMean) * xMinusMean) * i2s2)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context306.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context307 = new MethodContext(DerivativeStructure.class, 212, 7882, 9594);
        try {
            CallChecker.varInit(this, "this", 212, 7882, 9594);
            CallChecker.varInit(t, "t", 212, 7882, 9594);
            CallChecker.varInit(this.norm, "norm", 212, 7882, 9594);
            CallChecker.varInit(this.i2s2, "i2s2", 212, 7882, 9594);
            CallChecker.varInit(this.is, "is", 212, 7882, 9594);
            CallChecker.varInit(this.mean, "mean", 212, 7882, 9594);
            final double u = CallChecker.varInit(((double) ((this.is) * ((CallChecker.isCalled(t, DerivativeStructure.class, 215, 8068, 8068).getValue()) - (this.mean)))), "u", 215, 8045, 8088);
            double[] f = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 216, 8122, 8122)) {
                f = new double[(CallChecker.isCalled(t, DerivativeStructure.class, 216, 8122, 8122).getOrder()) + 1];
                CallChecker.varAssign(f, "f", 216, 8122, 8122);
            }
            f = CallChecker.beforeCalled(f, double[].class, 225, 8673, 8673);
            final double[] p = CallChecker.varInit(new double[CallChecker.isCalled(f, double[].class, 225, 8673, 8673).length], "p", 225, 8643, 8682);
            if (CallChecker.beforeDeref(p, double[].class, 226, 8692, 8692)) {
                CallChecker.isCalled(p, double[].class, 226, 8692, 8692)[0] = 1;
                CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 226, 8692, 8692)[0], "CallChecker.isCalled(p, double[].class, 226, 8692, 8692)[0]", 226, 8692, 8700);
            }
            final double u2 = CallChecker.varInit(((double) (u * u)), "u2", 227, 8710, 8733);
            double coeff = CallChecker.varInit(((double) ((this.norm) * (FastMath.exp(((-0.5) * u2))))), "coeff", 228, 8743, 8788);
            if (coeff <= (Precision.SAFE_MIN)) {
                Arrays.fill(f, 0.0);
            }else {
                if (CallChecker.beforeDeref(f, double[].class, 232, 8895, 8895)) {
                    f = CallChecker.beforeCalled(f, double[].class, 232, 8895, 8895);
                    CallChecker.isCalled(f, double[].class, 232, 8895, 8895)[0] = coeff;
                    CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 232, 8895, 8895)[0], "CallChecker.isCalled(f, double[].class, 232, 8895, 8895)[0]", 232, 8895, 8907);
                }
                f = CallChecker.beforeCalled(f, double[].class, 233, 8941, 8941);
                for (int n = 1; n < (CallChecker.isCalled(f, double[].class, 233, 8941, 8941).length); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 236, 9032, 9044);
                    if (CallChecker.beforeDeref(p, double[].class, 237, 9062, 9062)) {
                        if (CallChecker.beforeDeref(p, double[].class, 237, 9070, 9070)) {
                            CallChecker.isCalled(p, double[].class, 237, 9062, 9062)[n] = -(CallChecker.isCalled(p, double[].class, 237, 9070, 9070)[(n - 1)]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 237, 9062, 9062)[n], "CallChecker.isCalled(p, double[].class, 237, 9062, 9062)[n]", 237, 9062, 9078);
                        }
                    }
                    for (int k = n; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 238, 9120, 9125);
                        if (CallChecker.beforeDeref(p, double[].class, 239, 9163, 9163)) {
                            v = (v * u2) + (CallChecker.isCalled(p, double[].class, 239, 9163, 9163)[k]);
                            CallChecker.varAssign(v, "v", 239, 9150, 9167);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 241, 9226, 9226)) {
                                if (CallChecker.beforeDeref(p, double[].class, 241, 9247, 9247)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 241, 9258, 9258)) {
                                        CallChecker.isCalled(p, double[].class, 241, 9226, 9226)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 241, 9247, 9247)[(k - 1)])) - (CallChecker.isCalled(p, double[].class, 241, 9258, 9258)[(k - 3)]);
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 241, 9226, 9226)[(k - 2)], "CallChecker.isCalled(p, double[].class, 241, 9226, 9226)[(k - 2)]", 241, 9226, 9266);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 243, 9333, 9333)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 243, 9340, 9340)) {
                                        CallChecker.isCalled(p, double[].class, 243, 9333, 9333)[0] = CallChecker.isCalled(p, double[].class, 243, 9340, 9340)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 243, 9333, 9333)[0], "CallChecker.isCalled(p, double[].class, 243, 9333, 9333)[0]", 243, 9333, 9344);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 1) {
                        v *= u;
                        CallChecker.varAssign(v, "v", 247, 9444, 9450);
                    }
                    coeff *= is;
                    CallChecker.varAssign(coeff, "coeff", 250, 9487, 9498);
                    if (CallChecker.beforeDeref(f, double[].class, 251, 9516, 9516)) {
                        f = CallChecker.beforeCalled(f, double[].class, 251, 9516, 9516);
                        CallChecker.isCalled(f, double[].class, 251, 9516, 9516)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 251, 9516, 9516)[n], "CallChecker.isCalled(f, double[].class, 251, 9516, 9516)[n]", 251, 9516, 9532);
                    }
                }
            }
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 256, 9575, 9575)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 256, 9575, 9575).compose(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context307.methodEnd();
        }
    }
}

