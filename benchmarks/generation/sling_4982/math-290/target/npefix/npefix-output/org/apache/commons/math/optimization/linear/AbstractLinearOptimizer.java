package org.apache.commons.math.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import org.apache.commons.math.MaxIterationsExceededException;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;

public abstract class AbstractLinearOptimizer implements LinearOptimizer {
    public static final int DEFAULT_MAX_ITERATIONS = 100;

    private int maxIterations;

    private int iterations;

    protected LinearObjectiveFunction f;

    protected Collection<LinearConstraint> constraints;

    protected GoalType goalType;

    protected boolean restrictToNonNegative;

    protected AbstractLinearOptimizer() {
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(AbstractLinearOptimizer.class, 61, 2195, 2421);
        try {
            setMaxIterations(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public void setMaxIterations(int maxIterations) {
        MethodContext _bcornu_methode_context41 = new MethodContext(void.class, 66, 2428, 2551);
        try {
            CallChecker.varInit(this, "this", 66, 2428, 2551);
            CallChecker.varInit(maxIterations, "maxIterations", 66, 2428, 2551);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 66, 2428, 2551);
            CallChecker.varInit(this.goalType, "goalType", 66, 2428, 2551);
            CallChecker.varInit(this.constraints, "constraints", 66, 2428, 2551);
            CallChecker.varInit(this.f, "f", 66, 2428, 2551);
            CallChecker.varInit(this.iterations, "iterations", 66, 2428, 2551);
            CallChecker.varInit(this.maxIterations, "maxIterations", 66, 2428, 2551);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 66, 2428, 2551);
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 67, 2511, 2545);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context42 = new MethodContext(int.class, 71, 2558, 2649);
        try {
            CallChecker.varInit(this, "this", 71, 2558, 2649);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 71, 2558, 2649);
            CallChecker.varInit(this.goalType, "goalType", 71, 2558, 2649);
            CallChecker.varInit(this.constraints, "constraints", 71, 2558, 2649);
            CallChecker.varInit(this.f, "f", 71, 2558, 2649);
            CallChecker.varInit(this.iterations, "iterations", 71, 2558, 2649);
            CallChecker.varInit(this.maxIterations, "maxIterations", 71, 2558, 2649);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 71, 2558, 2649);
            return maxIterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context43 = new MethodContext(int.class, 76, 2656, 2741);
        try {
            CallChecker.varInit(this, "this", 76, 2656, 2741);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 76, 2656, 2741);
            CallChecker.varInit(this.goalType, "goalType", 76, 2656, 2741);
            CallChecker.varInit(this.constraints, "constraints", 76, 2656, 2741);
            CallChecker.varInit(this.f, "f", 76, 2656, 2741);
            CallChecker.varInit(this.iterations, "iterations", 76, 2656, 2741);
            CallChecker.varInit(this.maxIterations, "maxIterations", 76, 2656, 2741);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 76, 2656, 2741);
            return iterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    protected void incrementIterationsCounter() throws OptimizationException {
        MethodContext _bcornu_methode_context44 = new MethodContext(void.class, 84, 2748, 3135);
        try {
            CallChecker.varInit(this, "this", 84, 2748, 3135);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 84, 2748, 3135);
            CallChecker.varInit(this.goalType, "goalType", 84, 2748, 3135);
            CallChecker.varInit(this.constraints, "constraints", 84, 2748, 3135);
            CallChecker.varInit(this.f, "f", 84, 2748, 3135);
            CallChecker.varInit(this.iterations, "iterations", 84, 2748, 3135);
            CallChecker.varInit(this.maxIterations, "maxIterations", 84, 2748, 3135);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 84, 2748, 3135);
            if ((++(iterations)) > (maxIterations)) {
                throw new OptimizationException(new MaxIterationsExceededException(maxIterations));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public RealPointValuePair optimize(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative) throws OptimizationException {
        MethodContext _bcornu_methode_context45 = new MethodContext(RealPointValuePair.class, 92, 3142, 3799);
        try {
            CallChecker.varInit(this, "this", 92, 3142, 3799);
            CallChecker.varInit(restrictToNonNegative, "restrictToNonNegative", 92, 3142, 3799);
            CallChecker.varInit(goalType, "goalType", 92, 3142, 3799);
            CallChecker.varInit(constraints, "constraints", 92, 3142, 3799);
            CallChecker.varInit(f, "f", 92, 3142, 3799);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 92, 3142, 3799);
            CallChecker.varInit(this.goalType, "goalType", 92, 3142, 3799);
            CallChecker.varInit(this.constraints, "constraints", 92, 3142, 3799);
            CallChecker.varInit(this.f, "f", 92, 3142, 3799);
            CallChecker.varInit(this.iterations, "iterations", 92, 3142, 3799);
            CallChecker.varInit(this.maxIterations, "maxIterations", 92, 3142, 3799);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 92, 3142, 3799);
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 98, 3520, 3550);
            this.constraints = constraints;
            CallChecker.varAssign(this.constraints, "this.constraints", 99, 3560, 3600);
            this.goalType = goalType;
            CallChecker.varAssign(this.goalType, "this.goalType", 100, 3610, 3647);
            this.restrictToNonNegative = restrictToNonNegative;
            CallChecker.varAssign(this.restrictToNonNegative, "this.restrictToNonNegative", 101, 3657, 3707);
            iterations = 0;
            CallChecker.varAssign(this.iterations, "this.iterations", 103, 3718, 3733);
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealPointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    protected abstract RealPointValuePair doOptimize() throws OptimizationException;
}

