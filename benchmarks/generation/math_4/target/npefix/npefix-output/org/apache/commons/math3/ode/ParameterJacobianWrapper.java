package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

class ParameterJacobianWrapper implements ParameterJacobianProvider {
    private final FirstOrderDifferentialEquations fode;

    private final ParameterizedODE pode;

    private final Map<String, Double> hParam;

    public ParameterJacobianWrapper(final FirstOrderDifferentialEquations fode, final ParameterizedODE pode, final ParameterConfiguration[] paramsAndSteps) {
        ConstructorContext _bcornu_methode_context951 = new ConstructorContext(ParameterJacobianWrapper.class, 50, 1685, 2695);
        try {
            this.fode = fode;
            CallChecker.varAssign(this.fode, "this.fode", 53, 2298, 2314);
            this.pode = pode;
            CallChecker.varAssign(this.pode, "this.pode", 54, 2324, 2340);
            this.hParam = new HashMap<String, Double>();
            CallChecker.varAssign(this.hParam, "this.hParam", 55, 2350, 2393);
            if (CallChecker.beforeDeref(paramsAndSteps, null, 58, 2500, 2513)) {
                for (final ParameterConfiguration param : paramsAndSteps) {
                    final String name = CallChecker.varInit(CallChecker.isCalled(param, ParameterConfiguration.class, 59, 2550, 2554).getParameterName(), "name", 59, 2530, 2574);
                    if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 60, 2592, 2595)) {
                        if (CallChecker.isCalled(pode, ParameterizedODE.class, 60, 2592, 2595).isSupported(name)) {
                            if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 61, 2651, 2655)) {
                                if (CallChecker.beforeDeref(hParam, Map.class, 61, 2634, 2639)) {
                                    CallChecker.isCalled(hParam, Map.class, 61, 2634, 2639).put(name, CallChecker.isCalled(param, ParameterConfiguration.class, 61, 2651, 2655).getHP());
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context951.methodEnd();
        }
    }

    public Collection<String> getParametersNames() {
        MethodContext _bcornu_methode_context4282 = new MethodContext(Collection.class, 67, 2702, 2822);
        try {
            CallChecker.varInit(this, "this", 67, 2702, 2822);
            CallChecker.varInit(this.hParam, "hParam", 67, 2702, 2822);
            CallChecker.varInit(this.pode, "pode", 67, 2702, 2822);
            CallChecker.varInit(this.fode, "fode", 67, 2702, 2822);
            if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 68, 2791, 2794)) {
                return CallChecker.isCalled(pode, ParameterizedODE.class, 68, 2791, 2794).getParametersNames();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4282.methodEnd();
        }
    }

    public boolean isSupported(String name) {
        MethodContext _bcornu_methode_context4283 = new MethodContext(boolean.class, 72, 2829, 2939);
        try {
            CallChecker.varInit(this, "this", 72, 2829, 2939);
            CallChecker.varInit(name, "name", 72, 2829, 2939);
            CallChecker.varInit(this.hParam, "hParam", 72, 2829, 2939);
            CallChecker.varInit(this.pode, "pode", 72, 2829, 2939);
            CallChecker.varInit(this.fode, "fode", 72, 2829, 2939);
            if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 73, 2911, 2914)) {
                return CallChecker.isCalled(pode, ParameterizedODE.class, 73, 2911, 2914).isSupported(name);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4283.methodEnd();
        }
    }

    public void computeParameterJacobian(double t, double[] y, double[] yDot, String paramName, double[] dFdP) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context4284 = new MethodContext(void.class, 77, 2946, 3831);
        try {
            CallChecker.varInit(this, "this", 77, 2946, 3831);
            CallChecker.varInit(dFdP, "dFdP", 77, 2946, 3831);
            CallChecker.varInit(paramName, "paramName", 77, 2946, 3831);
            CallChecker.varInit(yDot, "yDot", 77, 2946, 3831);
            CallChecker.varInit(y, "y", 77, 2946, 3831);
            CallChecker.varInit(t, "t", 77, 2946, 3831);
            CallChecker.varInit(this.hParam, "hParam", 77, 2946, 3831);
            CallChecker.varInit(this.pode, "pode", 77, 2946, 3831);
            CallChecker.varInit(this.fode, "fode", 77, 2946, 3831);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.fode, FirstOrderDifferentialEquations.class, 81, 3213, 3216).getDimension())), "n", 81, 3199, 3232);
            if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 82, 3246, 3249)) {
                if (CallChecker.isCalled(pode, ParameterizedODE.class, 82, 3246, 3249).isSupported(paramName)) {
                    final double[] tmpDot = CallChecker.varInit(new double[n], "tmpDot", 83, 3289, 3326);
                    final double p = CallChecker.varInit(((double) (CallChecker.isCalled(this.pode, ParameterizedODE.class, 86, 3418, 3421).getParameter(paramName))), "p", 86, 3341, 3446);
                    double hP = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(hParam, Map.class, 87, 3478, 3483)) {
                        if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(hParam, Map.class, 87, 3478, 3483).get(paramName))), double.class, 87, 3478, 3498)) {
                            if (CallChecker.beforeDeref(hParam, Map.class, 87, 3478, 3483)) {
                                hP = CallChecker.isCalled(((Double) (CallChecker.isCalled(hParam, Map.class, 87, 3478, 3483).get(paramName))), double.class, 87, 3478, 3498);
                                CallChecker.varAssign(hP, "hP", 87, 3478, 3498);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 88, 3513, 3516)) {
                        CallChecker.isCalled(pode, ParameterizedODE.class, 88, 3513, 3516).setParameter(paramName, (p + hP));
                    }
                    if (CallChecker.beforeDeref(fode, FirstOrderDifferentialEquations.class, 89, 3563, 3566)) {
                        CallChecker.isCalled(fode, FirstOrderDifferentialEquations.class, 89, 3563, 3566).computeDerivatives(t, y, tmpDot);
                    }
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(dFdP, double[].class, 91, 3660, 3663)) {
                            if (CallChecker.beforeDeref(tmpDot, double[].class, 91, 3671, 3676)) {
                                if (CallChecker.beforeDeref(yDot, double[].class, 91, 3683, 3686)) {
                                    dFdP = CallChecker.beforeCalled(dFdP, double[].class, 91, 3660, 3663);
                                    yDot = CallChecker.beforeCalled(yDot, double[].class, 91, 3683, 3686);
                                    CallChecker.isCalled(dFdP, double[].class, 91, 3660, 3663)[i] = ((CallChecker.isCalled(tmpDot, double[].class, 91, 3671, 3676)[i]) - (CallChecker.isCalled(yDot, double[].class, 91, 3683, 3686)[i])) / hP;
                                    CallChecker.varAssign(CallChecker.isCalled(dFdP, double[].class, 91, 3660, 3663)[i], "CallChecker.isCalled(dFdP, double[].class, 91, 3660, 3663)[i]", 91, 3660, 3696);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(pode, ParameterizedODE.class, 93, 3724, 3727)) {
                        CallChecker.isCalled(pode, ParameterizedODE.class, 93, 3724, 3727).setParameter(paramName, p);
                    }
                }else {
                    Arrays.fill(dFdP, 0, n, 0.0);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4284.methodEnd();
        }
    }
}

