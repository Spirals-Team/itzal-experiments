package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.BaseMultivariateSimpleBoundsOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;

@Deprecated
public abstract class BaseAbstractMultivariateSimpleBoundsOptimizer<FUNC extends MultivariateFunction> extends BaseAbstractMultivariateOptimizer<FUNC> implements BaseMultivariateOptimizer<FUNC> , BaseMultivariateSimpleBoundsOptimizer<FUNC> {
    @Deprecated
    protected BaseAbstractMultivariateSimpleBoundsOptimizer() {
        ConstructorContext _bcornu_methode_context769 = new ConstructorContext(BaseAbstractMultivariateSimpleBoundsOptimizer.class, 58, 2293, 2747);
        try {
        } finally {
            _bcornu_methode_context769.methodEnd();
        }
    }

    protected BaseAbstractMultivariateSimpleBoundsOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context770 = new ConstructorContext(BaseAbstractMultivariateSimpleBoundsOptimizer.class, 63, 2754, 2943);
        try {
        } finally {
            _bcornu_methode_context770.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double[] startPoint) {
        MethodContext _bcornu_methode_context3448 = new MethodContext(PointValuePair.class, 69, 2950, 3251);
        try {
            CallChecker.varInit(this, "this", 69, 2950, 3251);
            CallChecker.varInit(startPoint, "startPoint", 69, 2950, 3251);
            CallChecker.varInit(goalType, "goalType", 69, 2950, 3251);
            CallChecker.varInit(f, "f", 69, 2950, 3251);
            CallChecker.varInit(maxEval, "maxEval", 69, 2950, 3251);
            CallChecker.varInit(this.evaluations, "evaluations", 69, 2950, 3251);
            return super.optimizeInternal(maxEval, f, goalType, new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3448.methodEnd();
        }
    }

    public PointValuePair optimize(int maxEval, FUNC f, GoalType goalType, double[] startPoint, double[] lower, double[] upper) {
        MethodContext _bcornu_methode_context3449 = new MethodContext(PointValuePair.class, 76, 3258, 3682);
        try {
            CallChecker.varInit(this, "this", 76, 3258, 3682);
            CallChecker.varInit(upper, "upper", 76, 3258, 3682);
            CallChecker.varInit(lower, "lower", 76, 3258, 3682);
            CallChecker.varInit(startPoint, "startPoint", 76, 3258, 3682);
            CallChecker.varInit(goalType, "goalType", 76, 3258, 3682);
            CallChecker.varInit(f, "f", 76, 3258, 3682);
            CallChecker.varInit(maxEval, "maxEval", 76, 3258, 3682);
            CallChecker.varInit(this.evaluations, "evaluations", 76, 3258, 3682);
            return super.optimizeInternal(maxEval, f, goalType, new InitialGuess(startPoint), new SimpleBounds(lower, upper));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3449.methodEnd();
        }
    }
}

