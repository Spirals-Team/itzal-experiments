package org.apache.commons.math3.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunction;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunctionJacobian;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.optim.nonlinear.vector.Target;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;

public class CurveFitter<T extends ParametricUnivariateFunction> {
    private class TheoreticalValuesFunction {
        private final ParametricUnivariateFunction f;

        public TheoreticalValuesFunction(final ParametricUnivariateFunction f) {
            ConstructorContext _bcornu_methode_context477 = new ConstructorContext(CurveFitter.TheoreticalValuesFunction.class, 191, 7721, 7887);
            try {
                this.f = f;
                CallChecker.varAssign(this.f, "this.f", 192, 7867, 7877);
            } finally {
                _bcornu_methode_context477.methodEnd();
            }
        }

        public ModelFunction getModelFunction() {
            MethodContext _bcornu_methode_context2074 = new MethodContext(ModelFunction.class, 198, 7898, 8617);
            try {
                CallChecker.varInit(this, "this", 198, 7898, 8617);
                CallChecker.varInit(this.f, "f", 198, 7898, 8617);
                return new ModelFunction(new MultivariateVectorFunction() {
                    public double[] value(double[] point) {
                        MethodContext _bcornu_methode_context2073 = new MethodContext(double[].class, 201, 8102, 8587);
                        try {
                            CallChecker.varInit(this, "this", 201, 8102, 8587);
                            CallChecker.varInit(point, "point", 201, 8102, 8587);
                            final double[] values = CallChecker.varInit(new double[CallChecker.isCalled(observations, List.class, 203, 8291, 8302).size()], "values", 203, 8256, 8311);
                            int i = CallChecker.varInit(((int) (0)), "i", 204, 8337, 8346);
                            if (CallChecker.beforeDeref(observations, double[].class, 205, 8410, 8421)) {
                                for (WeightedObservedPoint observed : observations) {
                                    if (CallChecker.beforeDeref(values, double[].class, 206, 8454, 8459)) {
                                        if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 206, 8476, 8483)) {
                                            if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 206, 8468, 8468)) {
                                                CallChecker.isCalled(values, double[].class, 206, 8454, 8459)[(i++)] = CallChecker.isCalled(f, ParametricUnivariateFunction.class, 206, 8468, 8468).value(CallChecker.isCalled(observed, WeightedObservedPoint.class, 206, 8476, 8483).getX(), point);
                                                CallChecker.varAssign(CallChecker.isCalled(values, double[].class, 206, 8454, 8459)[(i - 1)], "CallChecker.isCalled(values, double[].class, 206, 8454, 8459)[(i - 1)]", 206, 8454, 8499);
                                            }
                                        }
                                    }
                                }
                            }
                            return values;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context2073.methodEnd();
                        }
                    }
                });
            } catch (ForceReturn _bcornu_return_t) {
                return ((ModelFunction) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2074.methodEnd();
            }
        }

        public ModelFunctionJacobian getModelFunctionJacobian() {
            MethodContext _bcornu_methode_context2076 = new MethodContext(ModelFunctionJacobian.class, 217, 8628, 9297);
            try {
                CallChecker.varInit(this, "this", 217, 8628, 9297);
                CallChecker.varInit(this.f, "f", 217, 8628, 9297);
                return new ModelFunctionJacobian(new MultivariateMatrixFunction() {
                    public double[][] value(double[] point) {
                        MethodContext _bcornu_methode_context2075 = new MethodContext(double[][].class, 219, 8858, 9267);
                        try {
                            CallChecker.varInit(this, "this", 219, 8858, 9267);
                            CallChecker.varInit(point, "point", 219, 8858, 9267);
                            final double[][] jacobian = CallChecker.varInit(new double[CallChecker.isCalled(observations, List.class, 220, 8963, 8974).size()][], "jacobian", 220, 8924, 8985);
                            int i = CallChecker.varInit(((int) (0)), "i", 221, 9011, 9020);
                            if (CallChecker.beforeDeref(observations, double[][].class, 222, 9084, 9095)) {
                                for (WeightedObservedPoint observed : observations) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 223, 9128, 9135)) {
                                        if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 223, 9155, 9162)) {
                                            if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 223, 9144, 9144)) {
                                                CallChecker.isCalled(jacobian, double[][].class, 223, 9128, 9135)[(i++)] = CallChecker.isCalled(f, ParametricUnivariateFunction.class, 223, 9144, 9144).gradient(CallChecker.isCalled(observed, WeightedObservedPoint.class, 223, 9155, 9162).getX(), point);
                                                CallChecker.varAssign(CallChecker.isCalled(jacobian, double[][].class, 223, 9128, 9135)[(i - 1)], "CallChecker.isCalled(jacobian, double[][].class, 223, 9128, 9135)[(i - 1)]", 223, 9128, 9178);
                                            }
                                        }
                                    }
                                }
                            }
                            return jacobian;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context2075.methodEnd();
                        }
                    }
                });
            } catch (ForceReturn _bcornu_return_t) {
                return ((ModelFunctionJacobian) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2076.methodEnd();
            }
        }
    }

    private final MultivariateVectorOptimizer optimizer;

    private final List<WeightedObservedPoint> observations;

    public CurveFitter(final MultivariateVectorOptimizer optimizer) {
        ConstructorContext _bcornu_methode_context478 = new ConstructorContext(CurveFitter.class, 63, 2683, 2978);
        try {
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 64, 2883, 2909);
            observations = new ArrayList<WeightedObservedPoint>();
            CallChecker.varAssign(this.observations, "this.observations", 65, 2919, 2972);
        } finally {
            _bcornu_methode_context478.methodEnd();
        }
    }

    public void addObservedPoint(double x, double y) {
        MethodContext _bcornu_methode_context2077 = new MethodContext(void.class, 78, 2985, 3555);
        try {
            CallChecker.varInit(this, "this", 78, 2985, 3555);
            CallChecker.varInit(y, "y", 78, 2985, 3555);
            CallChecker.varInit(x, "x", 78, 2985, 3555);
            CallChecker.varInit(this.observations, "observations", 78, 2985, 3555);
            CallChecker.varInit(this.optimizer, "optimizer", 78, 2985, 3555);
            addObservedPoint(1.0, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2077.methodEnd();
        }
    }

    public void addObservedPoint(double weight, double x, double y) {
        MethodContext _bcornu_methode_context2078 = new MethodContext(void.class, 91, 3562, 4122);
        try {
            CallChecker.varInit(this, "this", 91, 3562, 4122);
            CallChecker.varInit(y, "y", 91, 3562, 4122);
            CallChecker.varInit(x, "x", 91, 3562, 4122);
            CallChecker.varInit(weight, "weight", 91, 3562, 4122);
            CallChecker.varInit(this.observations, "observations", 91, 3562, 4122);
            CallChecker.varInit(this.optimizer, "optimizer", 91, 3562, 4122);
            if (CallChecker.beforeDeref(observations, List.class, 92, 4059, 4070)) {
                CallChecker.isCalled(observations, List.class, 92, 4059, 4070).add(new WeightedObservedPoint(weight, x, y));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2078.methodEnd();
        }
    }

    public void addObservedPoint(WeightedObservedPoint observed) {
        MethodContext _bcornu_methode_context2079 = new MethodContext(void.class, 101, 4129, 4476);
        try {
            CallChecker.varInit(this, "this", 101, 4129, 4476);
            CallChecker.varInit(observed, "observed", 101, 4129, 4476);
            CallChecker.varInit(this.observations, "observations", 101, 4129, 4476);
            CallChecker.varInit(this.optimizer, "optimizer", 101, 4129, 4476);
            if (CallChecker.beforeDeref(observations, List.class, 102, 4444, 4455)) {
                CallChecker.isCalled(observations, List.class, 102, 4444, 4455).add(observed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2079.methodEnd();
        }
    }

    public WeightedObservedPoint[] getObservations() {
        MethodContext _bcornu_methode_context2080 = new MethodContext(WeightedObservedPoint[].class, 111, 4483, 4848);
        try {
            CallChecker.varInit(this, "this", 111, 4483, 4848);
            CallChecker.varInit(this.observations, "observations", 111, 4483, 4848);
            CallChecker.varInit(this.optimizer, "optimizer", 111, 4483, 4848);
            if (CallChecker.beforeDeref(observations, List.class, 112, 4821, 4832)) {
                if (CallChecker.beforeDeref(observations, List.class, 112, 4774, 4785)) {
                    return CallChecker.isCalled(observations, List.class, 112, 4774, 4785).toArray(new WeightedObservedPoint[CallChecker.isCalled(observations, List.class, 112, 4821, 4832).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2080.methodEnd();
        }
    }

    public void clearObservations() {
        MethodContext _bcornu_methode_context2081 = new MethodContext(void.class, 118, 4855, 4971);
        try {
            CallChecker.varInit(this, "this", 118, 4855, 4971);
            CallChecker.varInit(this.observations, "observations", 118, 4855, 4971);
            CallChecker.varInit(this.optimizer, "optimizer", 118, 4855, 4971);
            if (CallChecker.beforeDeref(observations, List.class, 119, 4945, 4956)) {
                CallChecker.isCalled(observations, List.class, 119, 4945, 4956).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2081.methodEnd();
        }
    }

    public double[] fit(T f, final double[] initialGuess) {
        MethodContext _bcornu_methode_context2082 = new MethodContext(double[].class, 135, 4978, 5643);
        try {
            CallChecker.varInit(this, "this", 135, 4978, 5643);
            CallChecker.varInit(initialGuess, "initialGuess", 135, 4978, 5643);
            CallChecker.varInit(f, "f", 135, 4978, 5643);
            CallChecker.varInit(this.observations, "observations", 135, 4978, 5643);
            CallChecker.varInit(this.optimizer, "optimizer", 135, 4978, 5643);
            return fit(Integer.MAX_VALUE, f, initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2082.methodEnd();
        }
    }

    public double[] fit(int maxEval, T f, final double[] initialGuess) {
        MethodContext _bcornu_methode_context2083 = new MethodContext(double[].class, 156, 5650, 7508);
        try {
            CallChecker.varInit(this, "this", 156, 5650, 7508);
            CallChecker.varInit(initialGuess, "initialGuess", 156, 5650, 7508);
            CallChecker.varInit(f, "f", 156, 5650, 7508);
            CallChecker.varInit(maxEval, "maxEval", 156, 5650, 7508);
            CallChecker.varInit(this.observations, "observations", 156, 5650, 7508);
            CallChecker.varInit(this.optimizer, "optimizer", 156, 5650, 7508);
            double[] target = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(observations, List.class, 159, 6587, 6598)) {
                target = new double[CallChecker.isCalled(observations, List.class, 159, 6587, 6598).size()];
                CallChecker.varAssign(target, "target", 159, 6587, 6598);
            }
            double[] weights = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(observations, List.class, 160, 6647, 6658)) {
                weights = new double[CallChecker.isCalled(observations, List.class, 160, 6647, 6658).size()];
                CallChecker.varAssign(weights, "weights", 160, 6647, 6658);
            }
            int i = CallChecker.varInit(((int) (0)), "i", 161, 6677, 6686);
            if (CallChecker.beforeDeref(observations, double[].class, 162, 6731, 6742)) {
                for (WeightedObservedPoint point : observations) {
                    if (CallChecker.beforeDeref(target, double[].class, 163, 6759, 6764)) {
                        if (CallChecker.beforeDeref(point, WeightedObservedPoint.class, 163, 6772, 6776)) {
                            target = CallChecker.beforeCalled(target, double[].class, 163, 6759, 6764);
                            CallChecker.isCalled(target, double[].class, 163, 6759, 6764)[i] = CallChecker.isCalled(point, WeightedObservedPoint.class, 163, 6772, 6776).getY();
                            CallChecker.varAssign(CallChecker.isCalled(target, double[].class, 163, 6759, 6764)[i], "CallChecker.isCalled(target, double[].class, 163, 6759, 6764)[i]", 163, 6759, 6784);
                        }
                    }
                    if (CallChecker.beforeDeref(weights, double[].class, 164, 6798, 6804)) {
                        if (CallChecker.beforeDeref(point, WeightedObservedPoint.class, 164, 6811, 6815)) {
                            weights = CallChecker.beforeCalled(weights, double[].class, 164, 6798, 6804);
                            CallChecker.isCalled(weights, double[].class, 164, 6798, 6804)[i] = CallChecker.isCalled(point, WeightedObservedPoint.class, 164, 6811, 6815).getWeight();
                            CallChecker.varAssign(CallChecker.isCalled(weights, double[].class, 164, 6798, 6804)[i], "CallChecker.isCalled(weights, double[].class, 164, 6798, 6804)[i]", 164, 6798, 6828);
                        }
                    }
                    ++i;
                }
            }
            final CurveFitter<T>.TheoreticalValuesFunction model = CallChecker.varInit(new TheoreticalValuesFunction(f), "model", 169, 6866, 7001);
            final PointVectorValuePair optimum = CallChecker.varInit(CallChecker.isCalled(optimizer, MultivariateVectorOptimizer.class, 173, 7089, 7097).optimize(new MaxEval(maxEval), CallChecker.isCalled(model, CurveFitter.TheoreticalValuesFunction.class, 174, 7163, 7167).getModelFunction(), CallChecker.isCalled(model, CurveFitter.TheoreticalValuesFunction.class, 175, 7222, 7226).getModelFunctionJacobian(), new Target(target), new Weight(weights), new InitialGuess(initialGuess)), "optimum", 172, 7012, 7427);
            if (CallChecker.beforeDeref(optimum, PointVectorValuePair.class, 180, 7481, 7487)) {
                return CallChecker.isCalled(optimum, PointVectorValuePair.class, 180, 7481, 7487).getPointRef();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2083.methodEnd();
        }
    }
}

