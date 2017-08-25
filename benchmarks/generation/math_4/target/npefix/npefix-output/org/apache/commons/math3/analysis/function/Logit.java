package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

public class Logit implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double value(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context5581 = new MethodContext(double.class, 98, 3039, 3720);
            try {
                CallChecker.varInit(this, "this", 98, 3039, 3720);
                CallChecker.varInit(param, "param", 98, 3039, 3720);
                CallChecker.varInit(x, "x", 98, 3039, 3720);
                validateParameters(param);
                if (CallChecker.beforeDeref(param, double[].class, 102, 3691, 3695)) {
                    if (CallChecker.beforeDeref(param, double[].class, 102, 3701, 3705)) {
                        param = CallChecker.beforeCalled(param, double[].class, 102, 3691, 3695);
                        param = CallChecker.beforeCalled(param, double[].class, 102, 3701, 3705);
                        return Logit.value(x, CallChecker.isCalled(param, double[].class, 102, 3691, 3695)[0], CallChecker.isCalled(param, double[].class, 102, 3701, 3705)[1]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5581.methodEnd();
            }
        }

        public double[] gradient(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context5582 = new MethodContext(double[].class, 118, 3731, 4707);
            try {
                CallChecker.varInit(this, "this", 118, 3731, 4707);
                CallChecker.varInit(param, "param", 118, 3731, 4707);
                CallChecker.varInit(x, "x", 118, 3731, 4707);
                validateParameters(param);
                param = CallChecker.beforeCalled(param, double[].class, 123, 4584, 4588);
                final double lo = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 123, 4584, 4588)[0])), "lo", 123, 4566, 4592);
                param = CallChecker.beforeCalled(param, double[].class, 124, 4624, 4628);
                final double hi = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 124, 4624, 4628)[1])), "hi", 124, 4606, 4632);
                return new double[]{ 1 / (lo - x) , 1 / (hi - x) };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5582.methodEnd();
            }
        }

        private void validateParameters(double[] param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context5583 = new MethodContext(void.class, 139, 4718, 5541);
            try {
                CallChecker.varInit(this, "this", 139, 4718, 5541);
                CallChecker.varInit(param, "param", 139, 4718, 5541);
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
                _bcornu_methode_context5583.methodEnd();
            }
        }
    }

    private final double lo;

    private final double hi;

    public Logit() {
        this(0, 1);
        ConstructorContext _bcornu_methode_context1242 = new ConstructorContext(Logit.class, 49, 1923, 2070);
        try {
        } finally {
            _bcornu_methode_context1242.methodEnd();
        }
    }

    public Logit(double lo, double hi) {
        ConstructorContext _bcornu_methode_context1243 = new ConstructorContext(Logit.class, 59, 2077, 2332);
        try {
            this.lo = lo;
            CallChecker.varAssign(this.lo, "this.lo", 61, 2292, 2304);
            this.hi = hi;
            CallChecker.varAssign(this.hi, "this.hi", 62, 2314, 2326);
        } finally {
            _bcornu_methode_context1243.methodEnd();
        }
    }

    public double value(double x) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5584 = new MethodContext(double.class, 66, 2339, 2468);
        try {
            CallChecker.varInit(this, "this", 66, 2339, 2468);
            CallChecker.varInit(x, "x", 66, 2339, 2468);
            CallChecker.varInit(this.hi, "hi", 66, 2339, 2468);
            CallChecker.varInit(this.lo, "lo", 66, 2339, 2468);
            return Logit.value(x, lo, hi);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5584.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5585 = new MethodContext(UnivariateFunction.class, 75, 2475, 2728);
        try {
            CallChecker.varInit(this, "this", 75, 2475, 2728);
            CallChecker.varInit(this.hi, "hi", 75, 2475, 2728);
            CallChecker.varInit(this.lo, "lo", 75, 2475, 2728);
            final DifferentiableUnivariateFunction npe_invocation_var1015 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var1015, DifferentiableUnivariateFunction.class, 76, 2655, 2708)) {
                return CallChecker.isCalled(npe_invocation_var1015, DifferentiableUnivariateFunction.class, 76, 2655, 2708).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5585.methodEnd();
        }
    }

    private static double value(double x, double lo, double hi) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5586 = new MethodContext(double.class, 158, 5554, 6128);
        try {
            CallChecker.varInit(hi, "hi", 158, 5554, 6128);
            CallChecker.varInit(lo, "lo", 158, 5554, 6128);
            CallChecker.varInit(x, "x", 158, 5554, 6128);
            if ((x < lo) || (x > hi)) {
                throw new OutOfRangeException(x, lo, hi);
            }
            return FastMath.log(((x - lo) / (hi - x)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5586.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5587 = new MethodContext(DerivativeStructure.class, 172, 6135, 7616);
        try {
            CallChecker.varInit(this, "this", 172, 6135, 7616);
            CallChecker.varInit(t, "t", 172, 6135, 7616);
            CallChecker.varInit(this.hi, "hi", 172, 6135, 7616);
            CallChecker.varInit(this.lo, "lo", 172, 6135, 7616);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(t, DerivativeStructure.class, 174, 6388, 6388).getValue())), "x", 174, 6371, 6400);
            if ((x < (lo)) || (x > (hi))) {
                throw new OutOfRangeException(x, lo, hi);
            }
            double[] f = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 178, 6530, 6530)) {
                f = new double[(CallChecker.isCalled(t, DerivativeStructure.class, 178, 6530, 6530).getOrder()) + 1];
                CallChecker.varAssign(f, "f", 178, 6530, 6530);
            }
            if (CallChecker.beforeDeref(f, double[].class, 181, 6584, 6584)) {
                f = CallChecker.beforeCalled(f, double[].class, 181, 6584, 6584);
                CallChecker.isCalled(f, double[].class, 181, 6584, 6584)[0] = FastMath.log(((x - (lo)) / ((hi) - x)));
                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 181, 6584, 6584)[0], "CallChecker.isCalled(f, double[].class, 181, 6584, 6584)[0]", 181, 6584, 6624);
            }
            if (CallChecker.beforeDeref(f, double[].class, 183, 6657, 6657)) {
                f = CallChecker.beforeCalled(f, double[].class, 183, 6657, 6657);
                if (Double.isInfinite(CallChecker.isCalled(f, double[].class, 183, 6657, 6657)[0])) {
                    if (CallChecker.beforeDeref(f, double[].class, 185, 6683, 6683)) {
                        f = CallChecker.beforeCalled(f, double[].class, 185, 6683, 6683);
                        if ((CallChecker.isCalled(f, double[].class, 185, 6683, 6683).length) > 1) {
                            if (CallChecker.beforeDeref(f, double[].class, 186, 6715, 6715)) {
                                f = CallChecker.beforeCalled(f, double[].class, 186, 6715, 6715);
                                CallChecker.isCalled(f, double[].class, 186, 6715, 6715)[1] = Double.POSITIVE_INFINITY;
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 186, 6715, 6715)[1], "CallChecker.isCalled(f, double[].class, 186, 6715, 6715)[1]", 186, 6715, 6746);
                            }
                        }
                    }
                    f = CallChecker.beforeCalled(f, double[].class, 193, 7134, 7134);
                    for (int i = 2; i < (CallChecker.isCalled(f, double[].class, 193, 7134, 7134).length); ++i) {
                        if (CallChecker.beforeDeref(f, double[].class, 194, 7167, 7167)) {
                            if (CallChecker.beforeDeref(f, double[].class, 194, 7174, 7174)) {
                                f = CallChecker.beforeCalled(f, double[].class, 194, 7167, 7167);
                                f = CallChecker.beforeCalled(f, double[].class, 194, 7174, 7174);
                                CallChecker.isCalled(f, double[].class, 194, 7167, 7167)[i] = CallChecker.isCalled(f, double[].class, 194, 7174, 7174)[(i - 2)];
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 194, 7167, 7167)[i], "CallChecker.isCalled(f, double[].class, 194, 7167, 7167)[i]", 194, 7167, 7182);
                            }
                        }
                    }
                }else {
                    final double invL = CallChecker.varInit(((double) (1.0 / (x - (this.lo)))), "invL", 200, 7229, 7299);
                    double xL = CallChecker.varInit(((double) (invL)), "xL", 201, 7313, 7329);
                    final double invH = CallChecker.varInit(((double) (1.0 / ((this.hi) - x))), "invH", 202, 7343, 7377);
                    double xH = CallChecker.varInit(((double) (invH)), "xH", 203, 7391, 7407);
                    f = CallChecker.beforeCalled(f, double[].class, 204, 7441, 7441);
                    for (int i = 1; i < (CallChecker.isCalled(f, double[].class, 204, 7441, 7441).length); ++i) {
                        if (CallChecker.beforeDeref(f, double[].class, 205, 7474, 7474)) {
                            f = CallChecker.beforeCalled(f, double[].class, 205, 7474, 7474);
                            CallChecker.isCalled(f, double[].class, 205, 7474, 7474)[i] = xL + xH;
                            CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 205, 7474, 7474)[i], "CallChecker.isCalled(f, double[].class, 205, 7474, 7474)[i]", 205, 7474, 7488);
                        }
                        xL *= (-i) * invL;
                        CallChecker.varAssign(xL, "xL", 206, 7506, 7522);
                        xH *= i * invH;
                        CallChecker.varAssign(xH, "xH", 207, 7540, 7556);
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 211, 7598, 7598)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 211, 7598, 7598).compose(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5587.methodEnd();
        }
    }
}

