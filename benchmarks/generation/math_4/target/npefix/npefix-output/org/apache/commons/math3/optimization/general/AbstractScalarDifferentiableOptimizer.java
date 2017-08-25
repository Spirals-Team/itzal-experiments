package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableMultivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateOptimizer;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer;

@Deprecated
public abstract class AbstractScalarDifferentiableOptimizer extends BaseAbstractMultivariateOptimizer<DifferentiableMultivariateFunction> implements DifferentiableMultivariateOptimizer {
    private MultivariateVectorFunction gradient;

    @Deprecated
    protected AbstractScalarDifferentiableOptimizer() {
        ConstructorContext _bcornu_methode_context1213 = new ConstructorContext(AbstractScalarDifferentiableOptimizer.class, 56, 2076, 2457);
        try {
        } finally {
            _bcornu_methode_context1213.methodEnd();
        }
    }

    protected AbstractScalarDifferentiableOptimizer(ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context1214 = new ConstructorContext(AbstractScalarDifferentiableOptimizer.class, 61, 2464, 2645);
        try {
        } finally {
            _bcornu_methode_context1214.methodEnd();
        }
    }

    protected double[] computeObjectiveGradient(final double[] evaluationPoint) {
        MethodContext _bcornu_methode_context5497 = new MethodContext(double[].class, 73, 2652, 3105);
        try {
            CallChecker.varInit(this, "this", 73, 2652, 3105);
            CallChecker.varInit(evaluationPoint, "evaluationPoint", 73, 2652, 3105);
            CallChecker.varInit(this.evaluations, "evaluations", 73, 2652, 3105);
            CallChecker.varInit(this.gradient, "gradient", 73, 2652, 3105);
            if (CallChecker.beforeDeref(gradient, MultivariateVectorFunction.class, 74, 3068, 3075)) {
                gradient = CallChecker.beforeCalled(gradient, MultivariateVectorFunction.class, 74, 3068, 3075);
                return CallChecker.isCalled(gradient, MultivariateVectorFunction.class, 74, 3068, 3075).value(evaluationPoint);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5497.methodEnd();
        }
    }

    @Override
    protected PointValuePair optimizeInternal(int maxEval, final DifferentiableMultivariateFunction f, final GoalType goalType, final double[] startPoint) {
        MethodContext _bcornu_methode_context5498 = new MethodContext(PointValuePair.class, 79, 3112, 3608);
        try {
            CallChecker.varInit(this, "this", 79, 3112, 3608);
            CallChecker.varInit(startPoint, "startPoint", 79, 3112, 3608);
            CallChecker.varInit(goalType, "goalType", 79, 3112, 3608);
            CallChecker.varInit(f, "f", 79, 3112, 3608);
            CallChecker.varInit(maxEval, "maxEval", 79, 3112, 3608);
            CallChecker.varInit(this.evaluations, "evaluations", 79, 3112, 3608);
            CallChecker.varInit(this.gradient, "gradient", 79, 3112, 3608);
            if (CallChecker.beforeDeref(f, DifferentiableMultivariateFunction.class, 84, 3516, 3516)) {
                gradient = CallChecker.isCalled(f, DifferentiableMultivariateFunction.class, 84, 3516, 3516).gradient();
                CallChecker.varAssign(this.gradient, "this.gradient", 84, 3505, 3528);
            }
            return super.optimizeInternal(maxEval, f, goalType, startPoint);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5498.methodEnd();
        }
    }

    public PointValuePair optimize(final int maxEval, final MultivariateDifferentiableFunction f, final GoalType goalType, final double[] startPoint) {
        MethodContext _bcornu_methode_context5499 = new MethodContext(PointValuePair.class, 106, 3615, 4884);
        try {
            CallChecker.varInit(this, "this", 106, 3615, 4884);
            CallChecker.varInit(startPoint, "startPoint", 106, 3615, 4884);
            CallChecker.varInit(goalType, "goalType", 106, 3615, 4884);
            CallChecker.varInit(f, "f", 106, 3615, 4884);
            CallChecker.varInit(maxEval, "maxEval", 106, 3615, 4884);
            CallChecker.varInit(this.evaluations, "evaluations", 106, 3615, 4884);
            CallChecker.varInit(this.gradient, "gradient", 106, 3615, 4884);
            return optimizeInternal(maxEval, FunctionUtils.toDifferentiableMultivariateFunction(f), goalType, startPoint);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5499.methodEnd();
        }
    }
}

