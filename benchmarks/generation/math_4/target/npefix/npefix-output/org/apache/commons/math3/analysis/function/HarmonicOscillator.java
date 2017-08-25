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
import org.apache.commons.math3.util.FastMath;

public class HarmonicOscillator implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double value(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3436 = new MethodContext(double.class, 93, 3031, 3755);
            try {
                CallChecker.varInit(this, "this", 93, 3031, 3755);
                CallChecker.varInit(param, "param", 93, 3031, 3755);
                CallChecker.varInit(x, "x", 93, 3031, 3755);
                validateParameters(param);
                if (CallChecker.beforeDeref(param, double[].class, 97, 3736, 3740)) {
                    param = CallChecker.beforeCalled(param, double[].class, 97, 3715, 3719);
                    param = CallChecker.beforeCalled(param, double[].class, 97, 3726, 3730);
                    param = CallChecker.beforeCalled(param, double[].class, 97, 3736, 3740);
                    return HarmonicOscillator.value(((x * (CallChecker.isCalled(param, double[].class, 97, 3715, 3719)[1])) + (CallChecker.isCalled(param, double[].class, 97, 3726, 3730)[2])), CallChecker.isCalled(param, double[].class, 97, 3736, 3740)[0]);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3436.methodEnd();
            }
        }

        public double[] gradient(double x, double... param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3437 = new MethodContext(double[].class, 113, 3766, 5062);
            try {
                CallChecker.varInit(this, "this", 113, 3766, 5062);
                CallChecker.varInit(param, "param", 113, 3766, 5062);
                CallChecker.varInit(x, "x", 113, 3766, 5062);
                validateParameters(param);
                param = CallChecker.beforeCalled(param, double[].class, 118, 4650, 4654);
                final double amplitude = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 118, 4650, 4654)[0])), "amplitude", 118, 4625, 4658);
                param = CallChecker.beforeCalled(param, double[].class, 119, 4693, 4697);
                final double omega = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 119, 4693, 4697)[1])), "omega", 119, 4672, 4701);
                param = CallChecker.beforeCalled(param, double[].class, 120, 4736, 4740);
                final double phase = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 120, 4736, 4740)[2])), "phase", 120, 4715, 4744);
                final double xTimesOmegaPlusPhase = CallChecker.varInit(((double) ((omega * x) + phase)), "xTimesOmegaPlusPhase", 122, 4759, 4812);
                final double a = CallChecker.varInit(((double) (HarmonicOscillator.value(xTimesOmegaPlusPhase, 1))), "a", 123, 4826, 4892);
                final double p = CallChecker.varInit(((double) ((-amplitude) * (FastMath.sin(xTimesOmegaPlusPhase)))), "p", 124, 4906, 4970);
                final double w = CallChecker.varInit(((double) (p * x)), "w", 125, 4984, 5006);
                return new double[]{ a , w , p };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3437.methodEnd();
            }
        }

        private void validateParameters(double[] param) throws DimensionMismatchException, NullArgumentException {
            MethodContext _bcornu_methode_context3438 = new MethodContext(void.class, 140, 5073, 5905);
            try {
                CallChecker.varInit(this, "this", 140, 5073, 5905);
                CallChecker.varInit(param, "param", 140, 5073, 5905);
                if (param == null) {
                    throw new NullArgumentException();
                }
                if ((param.length) != 3) {
                    throw new DimensionMismatchException(param.length, 3);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3438.methodEnd();
            }
        }
    }

    private final double amplitude;

    private final double omega;

    private final double phase;

    public HarmonicOscillator(double amplitude, double omega, double phase) {
        ConstructorContext _bcornu_methode_context766 = new ConstructorContext(HarmonicOscillator.class, 52, 1909, 2300);
        try {
            this.amplitude = amplitude;
            CallChecker.varAssign(this.amplitude, "this.amplitude", 55, 2212, 2238);
            this.omega = omega;
            CallChecker.varAssign(this.omega, "this.omega", 56, 2248, 2266);
            this.phase = phase;
            CallChecker.varAssign(this.phase, "this.phase", 57, 2276, 2294);
        } finally {
            _bcornu_methode_context766.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context3439 = new MethodContext(double.class, 61, 2307, 2420);
        try {
            CallChecker.varInit(this, "this", 61, 2307, 2420);
            CallChecker.varInit(x, "x", 61, 2307, 2420);
            CallChecker.varInit(this.phase, "phase", 61, 2307, 2420);
            CallChecker.varInit(this.omega, "omega", 61, 2307, 2420);
            CallChecker.varInit(this.amplitude, "amplitude", 61, 2307, 2420);
            return HarmonicOscillator.value((((omega) * x) + (phase)), amplitude);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3439.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context3440 = new MethodContext(UnivariateFunction.class, 69, 2427, 2680);
        try {
            CallChecker.varInit(this, "this", 69, 2427, 2680);
            CallChecker.varInit(this.phase, "phase", 69, 2427, 2680);
            CallChecker.varInit(this.omega, "omega", 69, 2427, 2680);
            CallChecker.varInit(this.amplitude, "amplitude", 69, 2427, 2680);
            final DifferentiableUnivariateFunction npe_invocation_var811 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var811, DifferentiableUnivariateFunction.class, 70, 2607, 2660)) {
                return CallChecker.isCalled(npe_invocation_var811, DifferentiableUnivariateFunction.class, 70, 2607, 2660).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3440.methodEnd();
        }
    }

    private static double value(double xTimesOmegaPlusPhase, double amplitude) {
        MethodContext _bcornu_methode_context3441 = new MethodContext(double.class, 157, 5918, 6282);
        try {
            CallChecker.varInit(amplitude, "amplitude", 157, 5918, 6282);
            CallChecker.varInit(xTimesOmegaPlusPhase, "xTimesOmegaPlusPhase", 157, 5918, 6282);
            return amplitude * (FastMath.cos(xTimesOmegaPlusPhase));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3441.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3442 = new MethodContext(DerivativeStructure.class, 165, 6289, 6914);
        try {
            CallChecker.varInit(this, "this", 165, 6289, 6914);
            CallChecker.varInit(t, "t", 165, 6289, 6914);
            CallChecker.varInit(this.phase, "phase", 165, 6289, 6914);
            CallChecker.varInit(this.omega, "omega", 165, 6289, 6914);
            CallChecker.varInit(this.amplitude, "amplitude", 165, 6289, 6914);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(t, DerivativeStructure.class, 167, 6468, 6468).getValue())), "x", 167, 6451, 6480);
            double[] f = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 168, 6514, 6514)) {
                f = new double[(CallChecker.isCalled(t, DerivativeStructure.class, 168, 6514, 6514).getOrder()) + 1];
                CallChecker.varAssign(f, "f", 168, 6514, 6514);
            }
            final double alpha = CallChecker.varInit(((double) (((this.omega) * x) + (this.phase))), "alpha", 170, 6542, 6580);
            if (CallChecker.beforeDeref(f, double[].class, 171, 6590, 6590)) {
                f = CallChecker.beforeCalled(f, double[].class, 171, 6590, 6590);
                CallChecker.isCalled(f, double[].class, 171, 6590, 6590)[0] = (amplitude) * (FastMath.cos(alpha));
                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 171, 6590, 6590)[0], "CallChecker.isCalled(f, double[].class, 171, 6590, 6590)[0]", 171, 6590, 6628);
            }
            if (CallChecker.beforeDeref(f, double[].class, 172, 6642, 6642)) {
                f = CallChecker.beforeCalled(f, double[].class, 172, 6642, 6642);
                if ((CallChecker.isCalled(f, double[].class, 172, 6642, 6642).length) > 1) {
                    if (CallChecker.beforeDeref(f, double[].class, 173, 6670, 6670)) {
                        f = CallChecker.beforeCalled(f, double[].class, 173, 6670, 6670);
                        CallChecker.isCalled(f, double[].class, 173, 6670, 6670)[1] = ((-(amplitude)) * (omega)) * (FastMath.sin(alpha));
                        CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 173, 6670, 6670)[1], "CallChecker.isCalled(f, double[].class, 173, 6670, 6670)[1]", 173, 6670, 6717);
                    }
                    final double mo2 = CallChecker.varInit(((double) ((-(this.omega)) * (this.omega))), "mo2", 174, 6731, 6765);
                    f = CallChecker.beforeCalled(f, double[].class, 175, 6799, 6799);
                    for (int i = 2; i < (CallChecker.isCalled(f, double[].class, 175, 6799, 6799).length); ++i) {
                        if (CallChecker.beforeDeref(f, double[].class, 176, 6832, 6832)) {
                            if (CallChecker.beforeDeref(f, double[].class, 176, 6845, 6845)) {
                                f = CallChecker.beforeCalled(f, double[].class, 176, 6832, 6832);
                                f = CallChecker.beforeCalled(f, double[].class, 176, 6845, 6845);
                                CallChecker.isCalled(f, double[].class, 176, 6832, 6832)[i] = mo2 * (CallChecker.isCalled(f, double[].class, 176, 6845, 6845)[(i - 2)]);
                                CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 176, 6832, 6832)[i], "CallChecker.isCalled(f, double[].class, 176, 6832, 6832)[i]", 176, 6832, 6853);
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 180, 6895, 6895)) {
                return CallChecker.isCalled(t, DerivativeStructure.class, 180, 6895, 6895).compose(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3442.methodEnd();
        }
    }
}

