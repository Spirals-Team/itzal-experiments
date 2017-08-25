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
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

public class Sigmoid implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double value(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3683 = new MethodContext(double.class, 100, 3077, 3769);
            try {
                CallChecker.varInit(this, "this", 100, 3077, 3769);
                CallChecker.varInit(param, "param", 100, 3077, 3769);
                CallChecker.varInit(x, "x", 100, 3077, 3769);
                validateParameters(param);
                if (CallChecker.beforeDeref(param, double[].class, 104, 3740, 3744)) {
                    if (CallChecker.beforeDeref(param, double[].class, 104, 3750, 3754)) {
                        param = CallChecker.beforeCalled(param, double[].class, 104, 3740, 3744);
                        param = CallChecker.beforeCalled(param, double[].class, 104, 3750, 3754);
                        return Sigmoid.value(x, CallChecker.isCalled(param, double[].class, 104, 3740, 3744)[0], CallChecker.isCalled(param, double[].class, 104, 3750, 3754)[1]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3683.methodEnd();
            }
        }

        public double[] gradient(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3684 = new MethodContext(double[].class, 120, 3780, 4754);
            try {
                CallChecker.varInit(this, "this", 120, 3780, 4754);
                CallChecker.varInit(param, "param", 120, 3780, 4754);
                CallChecker.varInit(x, "x", 120, 3780, 4754);
                validateParameters(param);
                final double invExp1 = CallChecker.varInit(((double) (1 / (1 + (FastMath.exp((-x)))))), "invExp1", 125, 4636, 4685);
                return new double[]{ 1 - invExp1 , invExp1 };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3684.methodEnd();
            }
        }

        private void validateParameters(double[] param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3685 = new MethodContext(void.class, 140, 4765, 5592);
            try {
                CallChecker.varInit(this, "this", 140, 4765, 5592);
                CallChecker.varInit(param, "param", 140, 4765, 5592);
                if (param == null) {
                    throw new NullArgumentException();
                }
                if ((param.length) != 2) {
                    throw new DimensionMismatchException(param.length, 2);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3685.methodEnd();
            }
        }
    }

    private final double lo;

    private final double hi;

    public Sigmoid() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context845 = new ConstructorContext(Sigmoid.class, 52, 2008, 2167);
        try {
        } finally {
            _bcornu_methode_context845.methodEnd();
        }
    }

    public Sigmoid(double lo, double hi) {
        ConstructorContext _bcornu_methode_context846 = new ConstructorContext(Sigmoid.class, 62, 2174, 2397);
        try {
            this.lo = lo;
            CallChecker.varAssign(this.lo, "this.lo", 64, 2357, 2369);
            this.hi = hi;
            CallChecker.varAssign(this.hi, "this.hi", 65, 2379, 2391);
        } finally {
            _bcornu_methode_context846.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3686 = new MethodContext(UnivariateFunction.class, 72, 2404, 2657);
        try {
            CallChecker.varInit(this, "this", 72, 2404, 2657);
            CallChecker.varInit(this.hi, "hi", 72, 2404, 2657);
            CallChecker.varInit(this.lo, "lo", 72, 2404, 2657);
            final DifferentiableUnivariateFunction npe_invocation_var821 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var821, DifferentiableUnivariateFunction.class, 73, 2584, 2637)) {
                return CallChecker.isCalled(npe_invocation_var821, DifferentiableUnivariateFunction.class, 73, 2584, 2637).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3686.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context3687 = new MethodContext(double.class, 77, 2664, 2758);
        try {
            CallChecker.varInit(this, "this", 77, 2664, 2758);
            CallChecker.varInit(x, "x", 77, 2664, 2758);
            CallChecker.varInit(this.hi, "hi", 77, 2664, 2758);
            CallChecker.varInit(this.lo, "lo", 77, 2664, 2758);
            return Sigmoid.value(x, lo, hi);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3687.methodEnd();
        }
    }

    private static double value(double x, double lo, double hi) {
        MethodContext _bcornu_methode_context3688 = new MethodContext(double.class, 158, 5605, 5994);
        try {
            CallChecker.varInit(hi, "hi", 158, 5605, 5994);
            CallChecker.varInit(lo, "lo", 158, 5605, 5994);
            CallChecker.varInit(x, "x", 158, 5605, 5994);
            return lo + ((hi - lo) / (1 + (FastMath.exp((-x)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3688.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3689 = new MethodContext(DerivativeStructure.class, 167, 6001, 7668);
        try {
            CallChecker.varInit(this, "this", 167, 6001, 7668);
            CallChecker.varInit(t, "t", 167, 6001, 7668);
            CallChecker.varInit(this.hi, "hi", 167, 6001, 7668);
            CallChecker.varInit(this.lo, "lo", 167, 6001, 7668);
            double[] f = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 170, 6188, 6188)) {
                f = new double[(CallChecker.isCalled(t, DerivativeStructure.class, 170, 6188, 6188).getOrder()) + 1];
                CallChecker.varAssign(f, "f", 170, 6188, 6188);
            }
            final double exp = CallChecker.varInit(((double) (FastMath.exp((-(CallChecker.isCalled(t, DerivativeStructure.class, 171, 6248, 6248).getValue()))))), "exp", 171, 6215, 6261);
            if (Double.isInfinite(exp)) {
                if (CallChecker.beforeDeref(f, double[].class, 175, 6380, 6380)) {
                    f = CallChecker.beforeCalled(f, double[].class, 175, 6380, 6380);
                    CallChecker.isCalled(f, double[].class, 175, 6380, 6380)[0] = lo;
                    CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 175, 6380, 6380)[0], "CallChecker.isCalled(f, double[].class, 175, 6380, 6380)[0]", 175, 6380, 6389);
                }
                if (CallChecker.beforeDeref(f, double[].class, 176, 6421, 6421)) {
                    f = CallChecker.beforeCalled(f, double[].class, 176, 6421, 6421);
                    Arrays.fill(f, 1, CallChecker.isCalled(f, double[].class, 176, 6421, 6421).length, 0.0);
                }
            }else {
                f = CallChecker.beforeCalled(f, double[].class, 186, 6919, 6919);
                final double[] p = CallChecker.varInit(new double[CallChecker.isCalled(f, double[].class, 186, 6919, 6919).length], "p", 186, 6889, 6928);
                final double inv = CallChecker.varInit(((double) (1 / (1 + exp))), "inv", 188, 6943, 6977);
                double coeff = CallChecker.varInit(((double) ((this.hi) - (this.lo))), "coeff", 189, 6991, 7013);
                f = CallChecker.beforeCalled(f, double[].class, 190, 7047, 7047);
                for (int n = 0; n < (CallChecker.isCalled(f, double[].class, 190, 7047, 7047).length); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 193, 7138, 7150);
                    if (CallChecker.beforeDeref(p, double[].class, 194, 7168, 7168)) {
                        CallChecker.isCalled(p, double[].class, 194, 7168, 7168)[n] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 194, 7168, 7168)[n], "CallChecker.isCalled(p, double[].class, 194, 7168, 7168)[n]", 194, 7168, 7176);
                    }
                    for (int k = n; k >= 0; --k) {
                        if (CallChecker.beforeDeref(p, double[].class, 196, 7259, 7259)) {
                            v = (v * exp) + (CallChecker.isCalled(p, double[].class, 196, 7259, 7259)[k]);
                            CallChecker.varAssign(v, "v", 196, 7245, 7263);
                        }
                        if (k > 1) {
                            if (CallChecker.beforeDeref(p, double[].class, 198, 7322, 7322)) {
                                if (CallChecker.beforeDeref(p, double[].class, 198, 7347, 7347)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 198, 7368, 7368)) {
                                        CallChecker.isCalled(p, double[].class, 198, 7322, 7322)[(k - 1)] = (((n - k) + 2) * (CallChecker.isCalled(p, double[].class, 198, 7347, 7347)[(k - 2)])) - ((k - 1) * (CallChecker.isCalled(p, double[].class, 198, 7368, 7368)[(k - 1)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 198, 7322, 7322)[(k - 1)], "CallChecker.isCalled(p, double[].class, 198, 7322, 7322)[(k - 1)]", 198, 7322, 7376);
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(p, double[].class, 200, 7431, 7431)) {
                                CallChecker.isCalled(p, double[].class, 200, 7431, 7431)[0] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 200, 7431, 7431)[0], "CallChecker.isCalled(p, double[].class, 200, 7431, 7431)[0]", 200, 7431, 7439);
                            }
                        }
                    }
                    coeff *= inv;
                    CallChecker.varAssign(coeff, "coeff", 204, 7498, 7510);
                    if (CallChecker.beforeDeref(f, double[].class, 205, 7528, 7528)) {
                        f = CallChecker.beforeCalled(f, double[].class, 205, 7528, 7528);
                        CallChecker.isCalled(f, double[].class, 205, 7528, 7528)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 205, 7528, 7528)[n], "CallChecker.isCalled(f, double[].class, 205, 7528, 7528)[n]", 205, 7528, 7546);
                    }
                }
                if (CallChecker.beforeDeref(f, double[].class, 210, 7610, 7610)) {
                    f = CallChecker.beforeCalled(f, double[].class, 210, 7610, 7610);
                    CallChecker.isCalled(f, double[].class, 210, 7610, 7610)[0] += lo;
                    CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 210, 7610, 7610)[0], "CallChecker.isCalled(f, double[].class, 210, 7610, 7610)[0]", 210, 7610, 7620);
                }
            }
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 214, 7649, 7649)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 214, 7649, 7649).compose(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3689.methodEnd();
        }
    }
}

