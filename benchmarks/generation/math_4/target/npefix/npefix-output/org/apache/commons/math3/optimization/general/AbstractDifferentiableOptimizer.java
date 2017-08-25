package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.GradientFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer;

@Deprecated
public abstract class AbstractDifferentiableOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateDifferentiableFunction> {
    private MultivariateVectorFunction gradient;

    protected AbstractDifferentiableOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context924 = new ConstructorContext(AbstractDifferentiableOptimizer.class, 50, 2001, 2176);
        try {
        } finally {
            _bcornu_methode_context924.methodEnd();
        }
    }

    protected double[] computeObjectiveGradient(final double[] evaluationPoint) {
        MethodContext _bcornu_methode_context4220 = new MethodContext(double[].class, 60, 2183, 2501);
        try {
            CallChecker.varInit(this, "this", 60, 2183, 2501);
            CallChecker.varInit(evaluationPoint, "evaluationPoint", 60, 2183, 2501);
            CallChecker.varInit(this.evaluations, "evaluations", 60, 2183, 2501);
            CallChecker.varInit(this.gradient, "gradient", 60, 2183, 2501);
            if (CallChecker.beforeDeref(gradient, MultivariateVectorFunction.class, 61, 2464, 2471)) {
                gradient = CallChecker.beforeCalled(gradient, MultivariateVectorFunction.class, 61, 2464, 2471);
                return CallChecker.isCalled(gradient, MultivariateVectorFunction.class, 61, 2464, 2471).value(evaluationPoint);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4220.methodEnd();
        }
    }

    @Override
    @Deprecated
    protected PointValuePair optimizeInternal(final int maxEval, final MultivariateDifferentiableFunction f, final GoalType goalType, final double[] startPoint) {
        MethodContext _bcornu_methode_context4221 = new MethodContext(PointValuePair.class, 72, 2508, 3118);
        try {
            CallChecker.varInit(this, "this", 72, 2508, 3118);
            CallChecker.varInit(startPoint, "startPoint", 72, 2508, 3118);
            CallChecker.varInit(goalType, "goalType", 72, 2508, 3118);
            CallChecker.varInit(f, "f", 72, 2508, 3118);
            CallChecker.varInit(maxEval, "maxEval", 72, 2508, 3118);
            CallChecker.varInit(this.evaluations, "evaluations", 72, 2508, 3118);
            CallChecker.varInit(this.gradient, "gradient", 72, 2508, 3118);
            return optimizeInternal(maxEval, f, goalType, new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4221.methodEnd();
        }
    }

    @Override
    protected PointValuePair optimizeInternal(final int maxEval, final MultivariateDifferentiableFunction f, final GoalType goalType, final OptimizationData... optData) {
        MethodContext _bcornu_methode_context4222 = new MethodContext(PointValuePair.class, 81, 3125, 3676);
        try {
            CallChecker.varInit(this, "this", 81, 3125, 3676);
            CallChecker.varInit(optData, "optData", 81, 3125, 3676);
            CallChecker.varInit(goalType, "goalType", 81, 3125, 3676);
            CallChecker.varInit(f, "f", 81, 3125, 3676);
            CallChecker.varInit(maxEval, "maxEval", 81, 3125, 3676);
            CallChecker.varInit(this.evaluations, "evaluations", 81, 3125, 3676);
            CallChecker.varInit(this.gradient, "gradient", 81, 3125, 3676);
            gradient = new GradientFunction(f);
            CallChecker.varAssign(this.gradient, "this.gradient", 86, 3532, 3566);
            return super.optimizeInternal(maxEval, f, goalType, optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4222.methodEnd();
        }
    }
}

