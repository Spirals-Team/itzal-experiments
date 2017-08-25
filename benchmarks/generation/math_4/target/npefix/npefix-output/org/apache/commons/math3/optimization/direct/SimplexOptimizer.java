package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;

@Deprecated
public class SimplexOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private AbstractSimplex simplex;

    @Deprecated
    public SimplexOptimizer() {
        this(new SimpleValueChecker());
        ConstructorContext _bcornu_methode_context143 = new ConstructorContext(SimplexOptimizer.class, 101, 4112, 4377);
        try {
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public SimplexOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context144 = new ConstructorContext(SimplexOptimizer.class, 108, 4384, 4541);
        try {
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public SimplexOptimizer(double rel, double abs) {
        this(new SimpleValueChecker(rel, abs));
        ConstructorContext _bcornu_methode_context145 = new ConstructorContext(SimplexOptimizer.class, 116, 4548, 4742);
        try {
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    @Deprecated
    public void setSimplex(AbstractSimplex simplex) {
        MethodContext _bcornu_methode_context522 = new MethodContext(void.class, 129, 4749, 5131);
        try {
            CallChecker.varInit(this, "this", 129, 4749, 5131);
            CallChecker.varInit(simplex, "simplex", 129, 4749, 5131);
            CallChecker.varInit(this.evaluations, "evaluations", 129, 4749, 5131);
            CallChecker.varInit(this.simplex, "simplex", 129, 4749, 5131);
            parseOptimizationData(simplex);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context522.methodEnd();
        }
    }

    @Override
    protected PointValuePair optimizeInternal(int maxEval, MultivariateFunction f, GoalType goalType, OptimizationData... optData) {
        MethodContext _bcornu_methode_context523 = new MethodContext(PointValuePair.class, 148, 5138, 6218);
        try {
            CallChecker.varInit(this, "this", 148, 5138, 6218);
            CallChecker.varInit(optData, "optData", 148, 5138, 6218);
            CallChecker.varInit(goalType, "goalType", 148, 5138, 6218);
            CallChecker.varInit(f, "f", 148, 5138, 6218);
            CallChecker.varInit(maxEval, "maxEval", 148, 5138, 6218);
            CallChecker.varInit(this.evaluations, "evaluations", 148, 5138, 6218);
            CallChecker.varInit(this.simplex, "simplex", 148, 5138, 6218);
            parseOptimizationData(optData);
            return super.optimizeInternal(maxEval, f, goalType, optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context523.methodEnd();
        }
    }

    private void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context524 = new MethodContext(void.class, 168, 6225, 6889);
        try {
            CallChecker.varInit(this, "this", 168, 6225, 6889);
            CallChecker.varInit(optData, "optData", 168, 6225, 6889);
            CallChecker.varInit(this.evaluations, "evaluations", 168, 6225, 6889);
            CallChecker.varInit(this.simplex, "simplex", 168, 6225, 6889);
            if (CallChecker.beforeDeref(optData, void.class, 171, 6723, 6729)) {
                for (OptimizationData data : optData) {
                    if (data instanceof AbstractSimplex) {
                        simplex = ((AbstractSimplex) (data));
                        CallChecker.varAssign(this.simplex, "this.simplex", 173, 6801, 6833);
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context524.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context527 = new MethodContext(PointValuePair.class, 181, 6896, 8860);
        try {
            CallChecker.varInit(this, "this", 181, 6896, 8860);
            CallChecker.varInit(this.evaluations, "evaluations", 181, 6896, 8860);
            CallChecker.varInit(this.simplex, "simplex", 181, 6896, 8860);
            if ((simplex) == null) {
                throw new NullArgumentException();
            }
            final MultivariateFunction evalFunc = new MultivariateFunction() {
                public double value(double[] point) {
                    MethodContext _bcornu_methode_context525 = new MethodContext(double.class, 190, 7274, 7385);
                    try {
                        CallChecker.varInit(this, "this", 190, 7274, 7385);
                        CallChecker.varInit(point, "point", 190, 7274, 7385);
                        return computeObjectiveValue(point);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context525.methodEnd();
                    }
                }
            };
            final boolean isMinim = CallChecker.varInit(((boolean) ((getGoalType()) == (GoalType.MINIMIZE))), "isMinim", 195, 7411, 7469);
            final Comparator<PointValuePair> comparator = new Comparator<PointValuePair>() {
                public int compare(final PointValuePair o1, final PointValuePair o2) {
                    MethodContext _bcornu_methode_context526 = new MethodContext(int.class, 198, 7584, 7878);
                    try {
                        CallChecker.varInit(this, "this", 198, 7584, 7878);
                        CallChecker.varInit(o2, "o2", 198, 7584, 7878);
                        CallChecker.varInit(o1, "o1", 198, 7584, 7878);
                        double v1 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o1, PointValuePair.class, 200, 7720, 7721)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 200, 7720, 7721).getValue())), double.class, 200, 7720, 7732)) {
                                if (CallChecker.beforeDeref(o1, PointValuePair.class, 200, 7720, 7721)) {
                                    v1 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 200, 7720, 7721).getValue())), double.class, 200, 7720, 7732);
                                    CallChecker.varAssign(v1, "v1", 200, 7720, 7732);
                                }
                            }
                        }
                        double v2 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o2, PointValuePair.class, 201, 7769, 7770)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 201, 7769, 7770).getValue())), double.class, 201, 7769, 7781)) {
                                if (CallChecker.beforeDeref(o2, PointValuePair.class, 201, 7769, 7770)) {
                                    v2 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 201, 7769, 7770).getValue())), double.class, 201, 7769, 7781);
                                    CallChecker.varAssign(v2, "v2", 201, 7769, 7781);
                                }
                            }
                        }
                        if (isMinim) {
                            return Double.compare(v1, v2);
                        }else {
                            return Double.compare(v2, v1);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context526.methodEnd();
                    }
                }
            };
            simplex.build(getStartPoint());
            simplex.evaluate(evalFunc, comparator);
            PointValuePair[] previous = CallChecker.varInit(null, "previous", 210, 8019, 8051);
            int iteration = CallChecker.varInit(((int) (0)), "iteration", 211, 8061, 8078);
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 212, 8088, 8162);
            while (true) {
                if (iteration > 0) {
                    boolean converged = CallChecker.varInit(((boolean) (true)), "converged", 215, 8236, 8260);
                    for (int i = 0; i < (simplex.getSize()); i++) {
                        PointValuePair prev = CallChecker.init(PointValuePair.class);
                        if (CallChecker.beforeDeref(previous, PointValuePair[].class, 217, 8366, 8373)) {
                            previous = CallChecker.beforeCalled(previous, PointValuePair[].class, 217, 8366, 8373);
                            prev = CallChecker.isCalled(previous, PointValuePair[].class, 217, 8366, 8373)[i];
                            CallChecker.varAssign(prev, "prev", 217, 8366, 8373);
                        }
                        if (CallChecker.beforeDeref(checker, ConvergenceChecker.class, 219, 8448, 8454)) {
                            converged = converged && (CallChecker.isCalled(checker, ConvergenceChecker.class, 219, 8448, 8454).converged(iteration, prev, simplex.getPoint(i)));
                            CallChecker.varAssign(converged, "converged", 218, 8399, 8503);
                        }
                    }
                    if (converged) {
                        return simplex.getPoint(0);
                    }
                }
                previous = simplex.getPoints();
                CallChecker.varAssign(previous, "previous", 228, 8738, 8768);
                simplex.iterate(evalFunc, comparator);
                ++iteration;
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context527.methodEnd();
        }
    }
}

