package org.apache.commons.math3.optimization.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.MultivariateDifferentiableVectorOptimizer;
import org.apache.commons.math3.optimization.PointVectorValuePair;

@Deprecated
public class CurveFitter<T extends ParametricUnivariateFunction> {
    @Deprecated
    private class OldTheoreticalValuesFunction implements DifferentiableMultivariateVectorFunction {
        private final ParametricUnivariateFunction f;

        public OldTheoreticalValuesFunction(final ParametricUnivariateFunction f) {
            ConstructorContext _bcornu_methode_context473 = new ConstructorContext(CurveFitter.OldTheoreticalValuesFunction.class, 210, 8345, 8534);
            try {
                this.f = f;
                CallChecker.varAssign(this.f, "this.f", 211, 8514, 8524);
            } finally {
                _bcornu_methode_context473.methodEnd();
            }
        }

        public MultivariateMatrixFunction jacobian() {
            MethodContext _bcornu_methode_context2061 = new MethodContext(MultivariateMatrixFunction.class, 215, 8545, 9099);
            try {
                CallChecker.varInit(this, "this", 215, 8545, 9099);
                CallChecker.varInit(this.f, "f", 215, 8545, 9099);
                return new MultivariateMatrixFunction() {
                    public double[][] value(double[] point) {
                        MethodContext _bcornu_methode_context2060 = new MethodContext(double[][].class, 217, 8691, 9074);
                        try {
                            CallChecker.varInit(this, "this", 217, 8691, 9074);
                            CallChecker.varInit(point, "point", 217, 8691, 9074);
                            final double[][] jacobian = CallChecker.varInit(new double[CallChecker.isCalled(observations, List.class, 218, 8792, 8803).size()][], "jacobian", 218, 8753, 8814);
                            int i = CallChecker.varInit(((int) (0)), "i", 220, 8837, 8846);
                            if (CallChecker.beforeDeref(observations, double[][].class, 221, 8906, 8917)) {
                                for (WeightedObservedPoint observed : observations) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 222, 8946, 8953)) {
                                        if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 222, 8973, 8980)) {
                                            if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 222, 8962, 8962)) {
                                                CallChecker.isCalled(jacobian, double[][].class, 222, 8946, 8953)[(i++)] = CallChecker.isCalled(f, ParametricUnivariateFunction.class, 222, 8962, 8962).gradient(CallChecker.isCalled(observed, WeightedObservedPoint.class, 222, 8973, 8980).getX(), point);
                                                CallChecker.varAssign(CallChecker.isCalled(jacobian, double[][].class, 222, 8946, 8953)[(i - 1)], "CallChecker.isCalled(jacobian, double[][].class, 222, 8946, 8953)[(i - 1)]", 222, 8946, 8996);
                                            }
                                        }
                                    }
                                }
                            }
                            return jacobian;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context2060.methodEnd();
                        }
                    }
                };
            } catch (ForceReturn _bcornu_return_t) {
                return ((MultivariateMatrixFunction) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2061.methodEnd();
            }
        }

        public double[] value(double[] point) {
            MethodContext _bcornu_methode_context2062 = new MethodContext(double[].class, 231, 9110, 9487);
            try {
                CallChecker.varInit(this, "this", 231, 9110, 9487);
                CallChecker.varInit(point, "point", 231, 9110, 9487);
                CallChecker.varInit(this.f, "f", 231, 9110, 9487);
                final double[] values = CallChecker.varInit(new double[CallChecker.isCalled(observations, List.class, 233, 9263, 9274).size()], "values", 233, 9228, 9283);
                int i = CallChecker.varInit(((int) (0)), "i", 234, 9297, 9306);
                if (CallChecker.beforeDeref(observations, double[].class, 235, 9358, 9369)) {
                    for (WeightedObservedPoint observed : observations) {
                        if (CallChecker.beforeDeref(values, double[].class, 236, 9390, 9395)) {
                            if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 236, 9412, 9419)) {
                                if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 236, 9404, 9404)) {
                                    CallChecker.isCalled(values, double[].class, 236, 9390, 9395)[(i++)] = CallChecker.isCalled(f, ParametricUnivariateFunction.class, 236, 9404, 9404).value(CallChecker.isCalled(observed, WeightedObservedPoint.class, 236, 9412, 9419).getX(), point);
                                    CallChecker.varAssign(CallChecker.isCalled(values, double[].class, 236, 9390, 9395)[(i - 1)], "CallChecker.isCalled(values, double[].class, 236, 9390, 9395)[(i - 1)]", 236, 9390, 9435);
                                }
                            }
                        }
                    }
                }
                return values;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2062.methodEnd();
            }
        }
    }

    private class TheoreticalValuesFunction implements MultivariateDifferentiableVectorFunction {
        private final ParametricUnivariateFunction f;

        public TheoreticalValuesFunction(final ParametricUnivariateFunction f) {
            ConstructorContext _bcornu_methode_context474 = new ConstructorContext(CurveFitter.TheoreticalValuesFunction.class, 252, 9759, 9945);
            try {
                this.f = f;
                CallChecker.varAssign(this.f, "this.f", 253, 9925, 9935);
            } finally {
                _bcornu_methode_context474.methodEnd();
            }
        }

        public double[] value(double[] point) {
            MethodContext _bcornu_methode_context2063 = new MethodContext(double[].class, 257, 9956, 10333);
            try {
                CallChecker.varInit(this, "this", 257, 9956, 10333);
                CallChecker.varInit(point, "point", 257, 9956, 10333);
                CallChecker.varInit(this.f, "f", 257, 9956, 10333);
                final double[] values = CallChecker.varInit(new double[CallChecker.isCalled(observations, List.class, 259, 10109, 10120).size()], "values", 259, 10074, 10129);
                int i = CallChecker.varInit(((int) (0)), "i", 260, 10143, 10152);
                if (CallChecker.beforeDeref(observations, double[].class, 261, 10204, 10215)) {
                    for (WeightedObservedPoint observed : observations) {
                        if (CallChecker.beforeDeref(values, double[].class, 262, 10236, 10241)) {
                            if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 262, 10258, 10265)) {
                                if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 262, 10250, 10250)) {
                                    CallChecker.isCalled(values, double[].class, 262, 10236, 10241)[(i++)] = CallChecker.isCalled(f, ParametricUnivariateFunction.class, 262, 10250, 10250).value(CallChecker.isCalled(observed, WeightedObservedPoint.class, 262, 10258, 10265).getX(), point);
                                    CallChecker.varAssign(CallChecker.isCalled(values, double[].class, 262, 10236, 10241)[(i - 1)], "CallChecker.isCalled(values, double[].class, 262, 10236, 10241)[(i - 1)]", 262, 10236, 10281);
                                }
                            }
                        }
                    }
                }
                return values;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2063.methodEnd();
            }
        }

        public DerivativeStructure[] value(DerivativeStructure[] point) {
            MethodContext _bcornu_methode_context2064 = new MethodContext(DerivativeStructure[].class, 269, 10344, 11384);
            try {
                CallChecker.varInit(this, "this", 269, 10344, 11384);
                CallChecker.varInit(point, "point", 269, 10344, 11384);
                CallChecker.varInit(this.f, "f", 269, 10344, 11384);
                point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 272, 10525, 10529);
                final double[] parameters = CallChecker.varInit(new double[CallChecker.isCalled(point, DerivativeStructure[].class, 272, 10525, 10529).length], "parameters", 272, 10486, 10538);
                point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 273, 10572, 10576);
                for (int k = 0; k < (CallChecker.isCalled(point, DerivativeStructure[].class, 273, 10572, 10576).length); ++k) {
                    if (CallChecker.beforeDeref(parameters, double[].class, 274, 10609, 10618)) {
                        if (CallChecker.beforeDeref(point, DerivativeStructure[].class, 274, 10625, 10629)) {
                            point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 274, 10625, 10629);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(point, DerivativeStructure[].class, 274, 10625, 10629)[k], DerivativeStructure.class, 274, 10625, 10632)) {
                                point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 274, 10625, 10629);
                                CallChecker.isCalled(point, DerivativeStructure[].class, 274, 10625, 10629)[k] = CallChecker.beforeCalled(CallChecker.isCalled(point, DerivativeStructure[].class, 274, 10625, 10629)[k], DerivativeStructure.class, 274, 10625, 10632);
                                CallChecker.isCalled(parameters, double[].class, 274, 10609, 10618)[k] = CallChecker.isCalled(CallChecker.isCalled(point, DerivativeStructure[].class, 274, 10625, 10629)[k], DerivativeStructure.class, 274, 10625, 10632).getValue();
                                CallChecker.varAssign(CallChecker.isCalled(parameters, double[].class, 274, 10609, 10618)[k], "CallChecker.isCalled(parameters, double[].class, 274, 10609, 10618)[k]", 274, 10609, 10644);
                            }
                        }
                    }
                }
                final DerivativeStructure[] values = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(observations, List.class, 278, 10771, 10782).size()], "values", 278, 10710, 10791);
                int i = CallChecker.varInit(((int) (0)), "i", 279, 10805, 10814);
                if (CallChecker.beforeDeref(observations, DerivativeStructure[].class, 280, 10866, 10877)) {
                    for (WeightedObservedPoint observed : observations) {
                        DerivativeStructure vi = CallChecker.init(DerivativeStructure.class);
                        if (CallChecker.beforeDeref(point, DerivativeStructure[].class, 284, 11084, 11088)) {
                            if (CallChecker.beforeDeref(observed, WeightedObservedPoint.class, 284, 11109, 11116)) {
                                if (CallChecker.beforeDeref(f, ParametricUnivariateFunction.class, 284, 11101, 11101)) {
                                    point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 284, 11084, 11088);
                                    vi = new DerivativeStructure(CallChecker.isCalled(point, DerivativeStructure[].class, 284, 11084, 11088).length, 1, CallChecker.isCalled(f, ParametricUnivariateFunction.class, 284, 11101, 11101).value(CallChecker.isCalled(observed, WeightedObservedPoint.class, 284, 11109, 11116).getX(), parameters));
                                    CallChecker.varAssign(vi, "vi", 284, 11084, 11088);
                                }
                            }
                        }
                        point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 285, 11176, 11180);
                        for (int k = 0; k < (CallChecker.isCalled(point, DerivativeStructure[].class, 285, 11176, 11180).length); ++k) {
                            if (CallChecker.beforeDeref(point, DerivativeStructure[].class, 286, 11253, 11257)) {
                                if (CallChecker.beforeDeref(vi, DerivativeStructure.class, 286, 11222, 11223)) {
                                    point = CallChecker.beforeCalled(point, DerivativeStructure[].class, 286, 11253, 11257);
                                    vi = CallChecker.beforeCalled(vi, DerivativeStructure.class, 286, 11222, 11223);
                                    vi = CallChecker.isCalled(vi, DerivativeStructure.class, 286, 11222, 11223).add(new DerivativeStructure(CallChecker.isCalled(point, DerivativeStructure[].class, 286, 11253, 11257).length, 1, k, 0.0));
                                    CallChecker.varAssign(vi, "vi", 286, 11217, 11278);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(values, DerivativeStructure[].class, 289, 11315, 11320)) {
                            CallChecker.isCalled(values, DerivativeStructure[].class, 289, 11315, 11320)[(i++)] = vi;
                            CallChecker.varAssign(CallChecker.isCalled(values, DerivativeStructure[].class, 289, 11315, 11320)[(i - 1)], "CallChecker.isCalled(values, DerivativeStructure[].class, 289, 11315, 11320)[(i - 1)]", 289, 11315, 11331);
                        }
                    }
                }
                return values;
            } catch (ForceReturn _bcornu_return_t) {
                return ((DerivativeStructure[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2064.methodEnd();
            }
        }
    }

    @Deprecated
    private final DifferentiableMultivariateVectorOptimizer oldOptimizer;

    private final MultivariateDifferentiableVectorOptimizer optimizer;

    private final List<WeightedObservedPoint> observations;

    public CurveFitter(final DifferentiableMultivariateVectorOptimizer optimizer) {
        ConstructorContext _bcornu_methode_context475 = new ConstructorContext(CurveFitter.class, 69, 2839, 3262);
        try {
            this.oldOptimizer = optimizer;
            CallChecker.varAssign(this.oldOptimizer, "this.oldOptimizer", 70, 3125, 3154);
            this.optimizer = null;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 71, 3164, 3188);
            observations = new ArrayList<WeightedObservedPoint>();
            CallChecker.varAssign(this.observations, "this.observations", 72, 3198, 3256);
        } finally {
            _bcornu_methode_context475.methodEnd();
        }
    }

    public CurveFitter(final MultivariateDifferentiableVectorOptimizer optimizer) {
        ConstructorContext _bcornu_methode_context476 = new ConstructorContext(CurveFitter.class, 79, 3269, 3605);
        try {
            this.oldOptimizer = null;
            CallChecker.varAssign(this.oldOptimizer, "this.oldOptimizer", 80, 3468, 3492);
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 81, 3502, 3531);
            observations = new ArrayList<WeightedObservedPoint>();
            CallChecker.varAssign(this.observations, "this.observations", 82, 3541, 3599);
        } finally {
            _bcornu_methode_context476.methodEnd();
        }
    }

    public void addObservedPoint(double x, double y) {
        MethodContext _bcornu_methode_context2065 = new MethodContext(void.class, 95, 3612, 4182);
        try {
            CallChecker.varInit(this, "this", 95, 3612, 4182);
            CallChecker.varInit(y, "y", 95, 3612, 4182);
            CallChecker.varInit(x, "x", 95, 3612, 4182);
            CallChecker.varInit(this.observations, "observations", 95, 3612, 4182);
            CallChecker.varInit(this.optimizer, "optimizer", 95, 3612, 4182);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 95, 3612, 4182);
            addObservedPoint(1.0, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2065.methodEnd();
        }
    }

    public void addObservedPoint(double weight, double x, double y) {
        MethodContext _bcornu_methode_context2066 = new MethodContext(void.class, 108, 4189, 4749);
        try {
            CallChecker.varInit(this, "this", 108, 4189, 4749);
            CallChecker.varInit(y, "y", 108, 4189, 4749);
            CallChecker.varInit(x, "x", 108, 4189, 4749);
            CallChecker.varInit(weight, "weight", 108, 4189, 4749);
            CallChecker.varInit(this.observations, "observations", 108, 4189, 4749);
            CallChecker.varInit(this.optimizer, "optimizer", 108, 4189, 4749);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 108, 4189, 4749);
            if (CallChecker.beforeDeref(observations, List.class, 109, 4686, 4697)) {
                CallChecker.isCalled(observations, List.class, 109, 4686, 4697).add(new WeightedObservedPoint(weight, x, y));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2066.methodEnd();
        }
    }

    public void addObservedPoint(WeightedObservedPoint observed) {
        MethodContext _bcornu_methode_context2067 = new MethodContext(void.class, 118, 4756, 5103);
        try {
            CallChecker.varInit(this, "this", 118, 4756, 5103);
            CallChecker.varInit(observed, "observed", 118, 4756, 5103);
            CallChecker.varInit(this.observations, "observations", 118, 4756, 5103);
            CallChecker.varInit(this.optimizer, "optimizer", 118, 4756, 5103);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 118, 4756, 5103);
            if (CallChecker.beforeDeref(observations, List.class, 119, 5071, 5082)) {
                CallChecker.isCalled(observations, List.class, 119, 5071, 5082).add(observed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2067.methodEnd();
        }
    }

    public WeightedObservedPoint[] getObservations() {
        MethodContext _bcornu_methode_context2068 = new MethodContext(WeightedObservedPoint[].class, 128, 5110, 5475);
        try {
            CallChecker.varInit(this, "this", 128, 5110, 5475);
            CallChecker.varInit(this.observations, "observations", 128, 5110, 5475);
            CallChecker.varInit(this.optimizer, "optimizer", 128, 5110, 5475);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 128, 5110, 5475);
            if (CallChecker.beforeDeref(observations, List.class, 129, 5448, 5459)) {
                if (CallChecker.beforeDeref(observations, List.class, 129, 5401, 5412)) {
                    return CallChecker.isCalled(observations, List.class, 129, 5401, 5412).toArray(new WeightedObservedPoint[CallChecker.isCalled(observations, List.class, 129, 5448, 5459).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2068.methodEnd();
        }
    }

    public void clearObservations() {
        MethodContext _bcornu_methode_context2069 = new MethodContext(void.class, 135, 5482, 5598);
        try {
            CallChecker.varInit(this, "this", 135, 5482, 5598);
            CallChecker.varInit(this.observations, "observations", 135, 5482, 5598);
            CallChecker.varInit(this.optimizer, "optimizer", 135, 5482, 5598);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 135, 5482, 5598);
            if (CallChecker.beforeDeref(observations, List.class, 136, 5572, 5583)) {
                CallChecker.isCalled(observations, List.class, 136, 5572, 5583).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2069.methodEnd();
        }
    }

    public double[] fit(T f, final double[] initialGuess) {
        MethodContext _bcornu_methode_context2070 = new MethodContext(double[].class, 152, 5605, 6270);
        try {
            CallChecker.varInit(this, "this", 152, 5605, 6270);
            CallChecker.varInit(initialGuess, "initialGuess", 152, 5605, 6270);
            CallChecker.varInit(f, "f", 152, 5605, 6270);
            CallChecker.varInit(this.observations, "observations", 152, 5605, 6270);
            CallChecker.varInit(this.optimizer, "optimizer", 152, 5605, 6270);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 152, 5605, 6270);
            return fit(Integer.MAX_VALUE, f, initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2070.methodEnd();
        }
    }

    public double[] fit(int maxEval, T f, final double[] initialGuess) {
        MethodContext _bcornu_methode_context2071 = new MethodContext(double[].class, 173, 6277, 8053);
        try {
            CallChecker.varInit(this, "this", 173, 6277, 8053);
            CallChecker.varInit(initialGuess, "initialGuess", 173, 6277, 8053);
            CallChecker.varInit(f, "f", 173, 6277, 8053);
            CallChecker.varInit(maxEval, "maxEval", 173, 6277, 8053);
            CallChecker.varInit(this.observations, "observations", 173, 6277, 8053);
            CallChecker.varInit(this.optimizer, "optimizer", 173, 6277, 8053);
            CallChecker.varInit(this.oldOptimizer, "oldOptimizer", 173, 6277, 8053);
            double[] target = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(observations, List.class, 176, 7213, 7224)) {
                target = new double[CallChecker.isCalled(observations, List.class, 176, 7213, 7224).size()];
                CallChecker.varAssign(target, "target", 176, 7213, 7224);
            }
            double[] weights = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(observations, List.class, 177, 7273, 7284)) {
                weights = new double[CallChecker.isCalled(observations, List.class, 177, 7273, 7284).size()];
                CallChecker.varAssign(weights, "weights", 177, 7273, 7284);
            }
            int i = CallChecker.varInit(((int) (0)), "i", 178, 7303, 7312);
            if (CallChecker.beforeDeref(observations, double[].class, 179, 7357, 7368)) {
                for (WeightedObservedPoint point : observations) {
                    if (CallChecker.beforeDeref(target, double[].class, 180, 7385, 7390)) {
                        if (CallChecker.beforeDeref(point, WeightedObservedPoint.class, 180, 7398, 7402)) {
                            target = CallChecker.beforeCalled(target, double[].class, 180, 7385, 7390);
                            CallChecker.isCalled(target, double[].class, 180, 7385, 7390)[i] = CallChecker.isCalled(point, WeightedObservedPoint.class, 180, 7398, 7402).getY();
                            CallChecker.varAssign(CallChecker.isCalled(target, double[].class, 180, 7385, 7390)[i], "CallChecker.isCalled(target, double[].class, 180, 7385, 7390)[i]", 180, 7385, 7410);
                        }
                    }
                    if (CallChecker.beforeDeref(weights, double[].class, 181, 7424, 7430)) {
                        if (CallChecker.beforeDeref(point, WeightedObservedPoint.class, 181, 7437, 7441)) {
                            weights = CallChecker.beforeCalled(weights, double[].class, 181, 7424, 7430);
                            CallChecker.isCalled(weights, double[].class, 181, 7424, 7430)[i] = CallChecker.isCalled(point, WeightedObservedPoint.class, 181, 7437, 7441).getWeight();
                            CallChecker.varAssign(CallChecker.isCalled(weights, double[].class, 181, 7424, 7430)[i], "CallChecker.isCalled(weights, double[].class, 181, 7424, 7430)[i]", 181, 7424, 7454);
                        }
                    }
                    ++i;
                }
            }
            PointVectorValuePair optimum = CallChecker.init(PointVectorValuePair.class);
            if ((optimizer) == null) {
                if (CallChecker.beforeDeref(oldOptimizer, DifferentiableMultivariateVectorOptimizer.class, 189, 7646, 7657)) {
                    optimum = CallChecker.isCalled(oldOptimizer, DifferentiableMultivariateVectorOptimizer.class, 189, 7646, 7657).optimize(maxEval, new OldTheoreticalValuesFunction(f), target, weights, initialGuess);
                    CallChecker.varAssign(optimum, "optimum", 189, 7636, 7788);
                }
            }else {
                optimum = optimizer.optimize(maxEval, new TheoreticalValuesFunction(f), target, weights, initialGuess);
                CallChecker.varAssign(optimum, "optimum", 192, 7819, 7962);
            }
            if (CallChecker.beforeDeref(optimum, PointVectorValuePair.class, 197, 8026, 8032)) {
                optimum = CallChecker.beforeCalled(optimum, PointVectorValuePair.class, 197, 8026, 8032);
                return CallChecker.isCalled(optimum, PointVectorValuePair.class, 197, 8026, 8032).getPointRef();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2071.methodEnd();
        }
    }
}

