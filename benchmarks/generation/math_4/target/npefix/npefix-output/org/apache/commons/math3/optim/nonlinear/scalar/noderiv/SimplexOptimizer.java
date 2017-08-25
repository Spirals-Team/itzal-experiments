package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.SimpleValueChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

public class SimplexOptimizer extends MultivariateOptimizer {
    private AbstractSimplex simplex;

    public SimplexOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context146 = new ConstructorContext(SimplexOptimizer.class, 96, 4281, 4438);
        try {
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public SimplexOptimizer(double rel, double abs) {
        this(new SimpleValueChecker(rel, abs));
        ConstructorContext _bcornu_methode_context147 = new ConstructorContext(SimplexOptimizer.class, 104, 4445, 4639);
        try {
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) {
        MethodContext _bcornu_methode_context528 = new MethodContext(PointValuePair.class, 120, 4646, 5190);
        try {
            CallChecker.varInit(this, "this", 120, 4646, 5190);
            CallChecker.varInit(optData, "optData", 120, 4646, 5190);
            CallChecker.varInit(this.iterations, "iterations", 120, 4646, 5190);
            CallChecker.varInit(this.evaluations, "evaluations", 120, 4646, 5190);
            CallChecker.varInit(this.simplex, "simplex", 120, 4646, 5190);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context528.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context531 = new MethodContext(PointValuePair.class, 127, 5197, 7121);
        try {
            CallChecker.varInit(this, "this", 127, 5197, 7121);
            CallChecker.varInit(this.iterations, "iterations", 127, 5197, 7121);
            CallChecker.varInit(this.evaluations, "evaluations", 127, 5197, 7121);
            CallChecker.varInit(this.simplex, "simplex", 127, 5197, 7121);
            checkParameters();
            final MultivariateFunction evalFunc = new MultivariateFunction() {
                public double value(double[] point) {
                    MethodContext _bcornu_methode_context529 = new MethodContext(double.class, 134, 5514, 5625);
                    try {
                        CallChecker.varInit(this, "this", 134, 5514, 5625);
                        CallChecker.varInit(point, "point", 134, 5514, 5625);
                        return computeObjectiveValue(point);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context529.methodEnd();
                    }
                }
            };
            final boolean isMinim = CallChecker.varInit(((boolean) ((getGoalType()) == (GoalType.MINIMIZE))), "isMinim", 139, 5651, 5709);
            final Comparator<PointValuePair> comparator = new Comparator<PointValuePair>() {
                public int compare(final PointValuePair o1, final PointValuePair o2) {
                    MethodContext _bcornu_methode_context530 = new MethodContext(int.class, 142, 5824, 6118);
                    try {
                        CallChecker.varInit(this, "this", 142, 5824, 6118);
                        CallChecker.varInit(o2, "o2", 142, 5824, 6118);
                        CallChecker.varInit(o1, "o1", 142, 5824, 6118);
                        double v1 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o1, PointValuePair.class, 144, 5960, 5961)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 144, 5960, 5961).getValue())), double.class, 144, 5960, 5972)) {
                                if (CallChecker.beforeDeref(o1, PointValuePair.class, 144, 5960, 5961)) {
                                    v1 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 144, 5960, 5961).getValue())), double.class, 144, 5960, 5972);
                                    CallChecker.varAssign(v1, "v1", 144, 5960, 5972);
                                }
                            }
                        }
                        double v2 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o2, PointValuePair.class, 145, 6009, 6010)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 145, 6009, 6010).getValue())), double.class, 145, 6009, 6021)) {
                                if (CallChecker.beforeDeref(o2, PointValuePair.class, 145, 6009, 6010)) {
                                    v2 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 145, 6009, 6010).getValue())), double.class, 145, 6009, 6021);
                                    CallChecker.varAssign(v2, "v2", 145, 6009, 6021);
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
                        _bcornu_methode_context530.methodEnd();
                    }
                }
            };
            if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 151, 6170, 6176)) {
                simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 151, 6170, 6176);
                CallChecker.isCalled(simplex, AbstractSimplex.class, 151, 6170, 6176).build(getStartPoint());
            }
            if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 152, 6210, 6216)) {
                simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 152, 6210, 6216);
                CallChecker.isCalled(simplex, AbstractSimplex.class, 152, 6210, 6216).evaluate(evalFunc, comparator);
            }
            PointValuePair[] previous = CallChecker.varInit(null, "previous", 154, 6259, 6291);
            int iteration = CallChecker.varInit(((int) (0)), "iteration", 155, 6301, 6318);
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 156, 6328, 6402);
            while (true) {
                if ((getIterations()) > 0) {
                    boolean converged = CallChecker.varInit(((boolean) (true)), "converged", 159, 6482, 6506);
                    simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 160, 6544, 6550);
                    for (int i = 0; i < (CallChecker.isCalled(simplex, AbstractSimplex.class, 160, 6544, 6550).getSize()); i++) {
                        PointValuePair prev = CallChecker.init(PointValuePair.class);
                        if (CallChecker.beforeDeref(previous, PointValuePair[].class, 161, 6612, 6619)) {
                            previous = CallChecker.beforeCalled(previous, PointValuePair[].class, 161, 6612, 6619);
                            prev = CallChecker.isCalled(previous, PointValuePair[].class, 161, 6612, 6619)[i];
                            CallChecker.varAssign(prev, "prev", 161, 6612, 6619);
                        }
                        if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 163, 6729, 6735)) {
                            if (CallChecker.beforeDeref(checker, ConvergenceChecker.class, 163, 6694, 6700)) {
                                simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 163, 6729, 6735);
                                converged = converged && (CallChecker.isCalled(checker, ConvergenceChecker.class, 163, 6694, 6700).converged(iteration, prev, CallChecker.isCalled(simplex, AbstractSimplex.class, 163, 6729, 6735).getPoint(i)));
                                CallChecker.varAssign(converged, "converged", 162, 6645, 6749);
                            }
                        }
                    }
                    if (converged) {
                        if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 167, 6878, 6884)) {
                            simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 167, 6878, 6884);
                            return CallChecker.isCalled(simplex, AbstractSimplex.class, 167, 6878, 6884).getPoint(0);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 172, 6995, 7001)) {
                    simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 172, 6995, 7001);
                    previous = CallChecker.isCalled(simplex, AbstractSimplex.class, 172, 6995, 7001).getPoints();
                    CallChecker.varAssign(previous, "previous", 172, 6984, 7014);
                }
                if (CallChecker.beforeDeref(simplex, AbstractSimplex.class, 173, 7028, 7034)) {
                    simplex = CallChecker.beforeCalled(simplex, AbstractSimplex.class, 173, 7028, 7034);
                    CallChecker.isCalled(simplex, AbstractSimplex.class, 173, 7028, 7034).iterate(evalFunc, comparator);
                }
                incrementIterationCount();
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context531.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context532 = new MethodContext(void.class, 190, 7128, 8028);
        try {
            CallChecker.varInit(this, "this", 190, 7128, 8028);
            CallChecker.varInit(optData, "optData", 190, 7128, 8028);
            CallChecker.varInit(this.iterations, "iterations", 190, 7128, 8028);
            CallChecker.varInit(this.evaluations, "evaluations", 190, 7128, 8028);
            CallChecker.varInit(this.simplex, "simplex", 190, 7128, 8028);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 196, 7750, 7756)) {
                for (OptimizationData data : optData) {
                    if (data instanceof AbstractSimplex) {
                        simplex = ((AbstractSimplex) (data));
                        CallChecker.varAssign(this.simplex, "this.simplex", 198, 7828, 7860);
                        break;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context532.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context533 = new MethodContext(void.class, 212, 8035, 8629);
        try {
            CallChecker.varInit(this, "this", 212, 8035, 8629);
            CallChecker.varInit(this.iterations, "iterations", 212, 8035, 8629);
            CallChecker.varInit(this.evaluations, "evaluations", 212, 8035, 8629);
            CallChecker.varInit(this.simplex, "simplex", 212, 8035, 8629);
            if ((simplex) == null) {
                throw new NullArgumentException();
            }
            if (((getLowerBound()) != null) || ((getUpperBound()) != null)) {
                throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context533.methodEnd();
        }
    }
}

