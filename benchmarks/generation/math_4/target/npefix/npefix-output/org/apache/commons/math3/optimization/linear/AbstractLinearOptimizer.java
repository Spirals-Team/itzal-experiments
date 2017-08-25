package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Collections;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;

@Deprecated
public abstract class AbstractLinearOptimizer implements LinearOptimizer {
    public static final int DEFAULT_MAX_ITERATIONS = 100;

    private LinearObjectiveFunction function;

    private Collection<LinearConstraint> linearConstraints;

    private GoalType goal;

    private boolean nonNegative;

    private int maxIterations;

    private int iterations;

    protected AbstractLinearOptimizer() {
        ConstructorContext _bcornu_methode_context657 = new ConstructorContext(AbstractLinearOptimizer.class, 78, 2333, 2566);
        try {
            setMaxIterations(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS);
        } finally {
            _bcornu_methode_context657.methodEnd();
        }
    }

    protected boolean restrictToNonNegative() {
        MethodContext _bcornu_methode_context2914 = new MethodContext(boolean.class, 85, 2573, 2749);
        try {
            CallChecker.varInit(this, "this", 85, 2573, 2749);
            CallChecker.varInit(this.iterations, "iterations", 85, 2573, 2749);
            CallChecker.varInit(this.maxIterations, "maxIterations", 85, 2573, 2749);
            CallChecker.varInit(this.nonNegative, "nonNegative", 85, 2573, 2749);
            CallChecker.varInit(this.goal, "goal", 85, 2573, 2749);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 85, 2573, 2749);
            CallChecker.varInit(this.function, "function", 85, 2573, 2749);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 85, 2573, 2749);
            return nonNegative;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2914.methodEnd();
        }
    }

    protected GoalType getGoalType() {
        MethodContext _bcornu_methode_context2915 = new MethodContext(GoalType.class, 92, 2756, 2870);
        try {
            CallChecker.varInit(this, "this", 92, 2756, 2870);
            CallChecker.varInit(this.iterations, "iterations", 92, 2756, 2870);
            CallChecker.varInit(this.maxIterations, "maxIterations", 92, 2756, 2870);
            CallChecker.varInit(this.nonNegative, "nonNegative", 92, 2756, 2870);
            CallChecker.varInit(this.goal, "goal", 92, 2756, 2870);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 92, 2756, 2870);
            CallChecker.varInit(this.function, "function", 92, 2756, 2870);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 92, 2756, 2870);
            return goal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((GoalType) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2915.methodEnd();
        }
    }

    protected LinearObjectiveFunction getFunction() {
        MethodContext _bcornu_methode_context2916 = new MethodContext(LinearObjectiveFunction.class, 99, 2877, 3010);
        try {
            CallChecker.varInit(this, "this", 99, 2877, 3010);
            CallChecker.varInit(this.iterations, "iterations", 99, 2877, 3010);
            CallChecker.varInit(this.maxIterations, "maxIterations", 99, 2877, 3010);
            CallChecker.varInit(this.nonNegative, "nonNegative", 99, 2877, 3010);
            CallChecker.varInit(this.goal, "goal", 99, 2877, 3010);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 99, 2877, 3010);
            CallChecker.varInit(this.function, "function", 99, 2877, 3010);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 99, 2877, 3010);
            return function;
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinearObjectiveFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2916.methodEnd();
        }
    }

    protected Collection<LinearConstraint> getConstraints() {
        MethodContext _bcornu_methode_context2917 = new MethodContext(Collection.class, 106, 3017, 3203);
        try {
            CallChecker.varInit(this, "this", 106, 3017, 3203);
            CallChecker.varInit(this.iterations, "iterations", 106, 3017, 3203);
            CallChecker.varInit(this.maxIterations, "maxIterations", 106, 3017, 3203);
            CallChecker.varInit(this.nonNegative, "nonNegative", 106, 3017, 3203);
            CallChecker.varInit(this.goal, "goal", 106, 3017, 3203);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 106, 3017, 3203);
            CallChecker.varInit(this.function, "function", 106, 3017, 3203);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 106, 3017, 3203);
            return Collections.unmodifiableCollection(linearConstraints);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2917.methodEnd();
        }
    }

    public void setMaxIterations(int maxIterations) {
        MethodContext _bcornu_methode_context2918 = new MethodContext(void.class, 111, 3210, 3333);
        try {
            CallChecker.varInit(this, "this", 111, 3210, 3333);
            CallChecker.varInit(maxIterations, "maxIterations", 111, 3210, 3333);
            CallChecker.varInit(this.iterations, "iterations", 111, 3210, 3333);
            CallChecker.varInit(this.maxIterations, "maxIterations", 111, 3210, 3333);
            CallChecker.varInit(this.nonNegative, "nonNegative", 111, 3210, 3333);
            CallChecker.varInit(this.goal, "goal", 111, 3210, 3333);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 111, 3210, 3333);
            CallChecker.varInit(this.function, "function", 111, 3210, 3333);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 111, 3210, 3333);
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 112, 3293, 3327);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2918.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context2919 = new MethodContext(int.class, 116, 3340, 3431);
        try {
            CallChecker.varInit(this, "this", 116, 3340, 3431);
            CallChecker.varInit(this.iterations, "iterations", 116, 3340, 3431);
            CallChecker.varInit(this.maxIterations, "maxIterations", 116, 3340, 3431);
            CallChecker.varInit(this.nonNegative, "nonNegative", 116, 3340, 3431);
            CallChecker.varInit(this.goal, "goal", 116, 3340, 3431);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 116, 3340, 3431);
            CallChecker.varInit(this.function, "function", 116, 3340, 3431);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 116, 3340, 3431);
            return maxIterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2919.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context2920 = new MethodContext(int.class, 121, 3438, 3523);
        try {
            CallChecker.varInit(this, "this", 121, 3438, 3523);
            CallChecker.varInit(this.iterations, "iterations", 121, 3438, 3523);
            CallChecker.varInit(this.maxIterations, "maxIterations", 121, 3438, 3523);
            CallChecker.varInit(this.nonNegative, "nonNegative", 121, 3438, 3523);
            CallChecker.varInit(this.goal, "goal", 121, 3438, 3523);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 121, 3438, 3523);
            CallChecker.varInit(this.function, "function", 121, 3438, 3523);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 121, 3438, 3523);
            return iterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2920.methodEnd();
        }
    }

    protected void incrementIterationsCounter() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context2921 = new MethodContext(void.class, 129, 3530, 3893);
        try {
            CallChecker.varInit(this, "this", 129, 3530, 3893);
            CallChecker.varInit(this.iterations, "iterations", 129, 3530, 3893);
            CallChecker.varInit(this.maxIterations, "maxIterations", 129, 3530, 3893);
            CallChecker.varInit(this.nonNegative, "nonNegative", 129, 3530, 3893);
            CallChecker.varInit(this.goal, "goal", 129, 3530, 3893);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 129, 3530, 3893);
            CallChecker.varInit(this.function, "function", 129, 3530, 3893);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 129, 3530, 3893);
            if ((++(iterations)) > (maxIterations)) {
                throw new MaxCountExceededException(maxIterations);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2921.methodEnd();
        }
    }

    public PointValuePair optimize(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context2922 = new MethodContext(PointValuePair.class, 137, 3900, 4532);
        try {
            CallChecker.varInit(this, "this", 137, 3900, 4532);
            CallChecker.varInit(restrictToNonNegative, "restrictToNonNegative", 137, 3900, 4532);
            CallChecker.varInit(goalType, "goalType", 137, 3900, 4532);
            CallChecker.varInit(constraints, "constraints", 137, 3900, 4532);
            CallChecker.varInit(f, "f", 137, 3900, 4532);
            CallChecker.varInit(this.iterations, "iterations", 137, 3900, 4532);
            CallChecker.varInit(this.maxIterations, "maxIterations", 137, 3900, 4532);
            CallChecker.varInit(this.nonNegative, "nonNegative", 137, 3900, 4532);
            CallChecker.varInit(this.goal, "goal", 137, 3900, 4532);
            CallChecker.varInit(this.linearConstraints, "linearConstraints", 137, 3900, 4532);
            CallChecker.varInit(this.function, "function", 137, 3900, 4532);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 137, 3900, 4532);
            this.function = f;
            CallChecker.varAssign(this.function, "this.function", 143, 4269, 4295);
            this.linearConstraints = constraints;
            CallChecker.varAssign(this.linearConstraints, "this.linearConstraints", 144, 4305, 4341);
            this.goal = goalType;
            CallChecker.varAssign(this.goal, "this.goal", 145, 4351, 4384);
            this.nonNegative = restrictToNonNegative;
            CallChecker.varAssign(this.nonNegative, "this.nonNegative", 146, 4394, 4440);
            iterations = 0;
            CallChecker.varAssign(this.iterations, "this.iterations", 148, 4451, 4466);
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2922.methodEnd();
        }
    }

    protected abstract PointValuePair doOptimize() throws MathIllegalStateException;
}

