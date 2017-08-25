package org.apache.commons.math3.optim.nonlinear.scalar.gradient;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer;
import org.apache.commons.math3.util.FastMath;

public class NonLinearConjugateGradientOptimizer extends GradientMultivariateOptimizer {
    public static enum Formula {
FLETCHER_REEVES, POLAK_RIBIERE;    }

    public static class BracketingStep implements OptimizationData {
        private final double initialStep;

        public BracketingStep(double step) {
            ConstructorContext _bcornu_methode_context86 = new ConstructorContext(NonLinearConjugateGradientOptimizer.BracketingStep.class, 118, 4694, 4855);
            try {
                initialStep = step;
                CallChecker.varAssign(this.initialStep, "this.initialStep", 119, 4827, 4845);
            } finally {
                _bcornu_methode_context86.methodEnd();
            }
        }

        public double getBracketingStep() {
            MethodContext _bcornu_methode_context339 = new MethodContext(double.class, 127, 4866, 5048);
            try {
                CallChecker.varInit(this, "this", 127, 4866, 5048);
                CallChecker.varInit(this.initialStep, "initialStep", 127, 4866, 5048);
                return initialStep;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context339.methodEnd();
            }
        }
    }

    public static class IdentityPreconditioner implements Preconditioner {
        public double[] precondition(double[] variables, double[] r) {
            MethodContext _bcornu_methode_context340 = new MethodContext(double[].class, 342, 13072, 13202);
            try {
                CallChecker.varInit(this, "this", 342, 13072, 13202);
                CallChecker.varInit(r, "r", 342, 13072, 13202);
                CallChecker.varInit(variables, "variables", 342, 13072, 13202);
                if (CallChecker.beforeDeref(r, double[].class, 343, 13183, 13183)) {
                    r = CallChecker.beforeCalled(r, double[].class, 343, 13183, 13183);
                    return CallChecker.isCalled(r, double[].class, 343, 13183, 13183).clone();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context340.methodEnd();
            }
        }
    }

    private class LineSearchFunction implements UnivariateFunction {
        private final double[] currentPoint;

        private final double[] searchDirection;

        public LineSearchFunction(double[] point, double[] direction) {
            ConstructorContext _bcornu_methode_context87 = new ConstructorContext(NonLinearConjugateGradientOptimizer.LineSearchFunction.class, 367, 13839, 14145);
            try {
                point = CallChecker.beforeCalled(point, double[].class, 369, 14073, 14077);
                currentPoint = CallChecker.isCalled(point, double[].class, 369, 14073, 14077).clone();
                CallChecker.varAssign(this.currentPoint, "this.currentPoint", 369, 14058, 14086);
                direction = CallChecker.beforeCalled(direction, double[].class, 370, 14118, 14126);
                searchDirection = CallChecker.isCalled(direction, double[].class, 370, 14118, 14126).clone();
                CallChecker.varAssign(this.searchDirection, "this.searchDirection", 370, 14100, 14135);
            } finally {
                _bcornu_methode_context87.methodEnd();
            }
        }

        public double value(double x) {
            MethodContext _bcornu_methode_context341 = new MethodContext(double.class, 374, 14156, 14859);
            try {
                CallChecker.varInit(this, "this", 374, 14156, 14859);
                CallChecker.varInit(x, "x", 374, 14156, 14859);
                CallChecker.varInit(this.searchDirection, "searchDirection", 374, 14156, 14859);
                CallChecker.varInit(this.currentPoint, "currentPoint", 374, 14156, 14859);
                final double[] shiftedPoint = CallChecker.varInit(CallChecker.isCalled(currentPoint, double[].class, 376, 14312, 14323).clone(), "shiftedPoint", 376, 14282, 14332);
                for (int i = 0; i < (CallChecker.isCalled(shiftedPoint, double[].class, 377, 14366, 14377).length); ++i) {
                    if (CallChecker.beforeDeref(shiftedPoint, double[].class, 378, 14410, 14421)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 378, 14433, 14447)) {
                            CallChecker.isCalled(shiftedPoint, double[].class, 378, 14410, 14421)[i] += x * (CallChecker.isCalled(searchDirection, double[].class, 378, 14433, 14447)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(shiftedPoint, double[].class, 378, 14410, 14421)[i], "CallChecker.isCalled(shiftedPoint, double[].class, 378, 14410, 14421)[i]", 378, 14410, 14451);
                        }
                    }
                }
                final double[] gradient = CallChecker.varInit(computeObjectiveGradient(shiftedPoint), "gradient", 382, 14530, 14594);
                double dotProduct = CallChecker.varInit(((double) (0)), "dotProduct", 385, 14662, 14683);
                for (int i = 0; i < (CallChecker.isCalled(gradient, double[].class, 386, 14717, 14724).length); ++i) {
                    if (CallChecker.beforeDeref(gradient, double[].class, 387, 14771, 14778)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 387, 14785, 14799)) {
                            dotProduct += (CallChecker.isCalled(gradient, double[].class, 387, 14771, 14778)[i]) * (CallChecker.isCalled(searchDirection, double[].class, 387, 14785, 14799)[i]);
                            CallChecker.varAssign(dotProduct, "dotProduct", 387, 14757, 14803);
                        }
                    }
                }
                return dotProduct;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context341.methodEnd();
            }
        }
    }

    private final NonLinearConjugateGradientOptimizer.Formula updateFormula;

    private final Preconditioner preconditioner;

    private final UnivariateSolver solver;

    private double initialStep = 1;

    public NonLinearConjugateGradientOptimizer(final NonLinearConjugateGradientOptimizer.Formula updateFormula, ConvergenceChecker<PointValuePair> checker) {
        this(updateFormula, checker, new BrentSolver(), new NonLinearConjugateGradientOptimizer.IdentityPreconditioner());
        ConstructorContext _bcornu_methode_context88 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 69, 2712, 3375);
        try {
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public NonLinearConjugateGradientOptimizer(final NonLinearConjugateGradientOptimizer.Formula updateFormula, ConvergenceChecker<PointValuePair> checker, final UnivariateSolver lineSearchSolver) {
        this(updateFormula, checker, lineSearchSolver, new NonLinearConjugateGradientOptimizer.IdentityPreconditioner());
        ConstructorContext _bcornu_methode_context89 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 141, 5061, 5826);
        try {
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public NonLinearConjugateGradientOptimizer(final NonLinearConjugateGradientOptimizer.Formula updateFormula, ConvergenceChecker<PointValuePair> checker, final UnivariateSolver lineSearchSolver, final Preconditioner preconditioner) {
        super(checker);
        ConstructorContext _bcornu_methode_context90 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 158, 5833, 6691);
        try {
            this.updateFormula = updateFormula;
            CallChecker.varAssign(this.updateFormula, "this.updateFormula", 164, 6545, 6579);
            solver = lineSearchSolver;
            CallChecker.varAssign(this.solver, "this.solver", 165, 6589, 6614);
            this.preconditioner = preconditioner;
            CallChecker.varAssign(this.preconditioner, "this.preconditioner", 166, 6624, 6660);
            initialStep = 1;
            CallChecker.varAssign(this.initialStep, "this.initialStep", 167, 6670, 6685);
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    @Override
    public PointValuePair optimize(OptimizationData... optData) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context342 = new MethodContext(PointValuePair.class, 184, 6698, 7428);
        try {
            CallChecker.varInit(this, "this", 184, 6698, 7428);
            CallChecker.varInit(optData, "optData", 184, 6698, 7428);
            CallChecker.varInit(this.iterations, "iterations", 184, 6698, 7428);
            CallChecker.varInit(this.evaluations, "evaluations", 184, 6698, 7428);
            CallChecker.varInit(this.initialStep, "initialStep", 184, 6698, 7428);
            CallChecker.varInit(this.solver, "solver", 184, 6698, 7428);
            CallChecker.varInit(this.preconditioner, "preconditioner", 184, 6698, 7428);
            CallChecker.varInit(this.updateFormula, "updateFormula", 184, 6698, 7428);
            return super.optimize(optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context342.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context343 = new MethodContext(PointValuePair.class, 192, 7435, 11070);
        try {
            CallChecker.varInit(this, "this", 192, 7435, 11070);
            CallChecker.varInit(this.iterations, "iterations", 192, 7435, 11070);
            CallChecker.varInit(this.evaluations, "evaluations", 192, 7435, 11070);
            CallChecker.varInit(this.initialStep, "initialStep", 192, 7435, 11070);
            CallChecker.varInit(this.solver, "solver", 192, 7435, 11070);
            CallChecker.varInit(this.preconditioner, "preconditioner", 192, 7435, 11070);
            CallChecker.varInit(this.updateFormula, "updateFormula", 192, 7435, 11070);
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 193, 7522, 7596);
            final double[] point = CallChecker.varInit(getStartPoint(), "point", 194, 7606, 7644);
            final GoalType goal = CallChecker.varInit(getGoalType(), "goal", 195, 7654, 7689);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(point, double[].class, 196, 7713, 7717).length)), "n", 196, 7699, 7725);
            double[] r = CallChecker.varInit(computeObjectiveGradient(point), "r", 197, 7735, 7779);
            if (goal == (GoalType.MINIMIZE)) {
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(r, double[].class, 200, 7880, 7880)) {
                        if (CallChecker.beforeDeref(r, double[].class, 200, 7888, 7888)) {
                            r = CallChecker.beforeCalled(r, double[].class, 200, 7880, 7880);
                            r = CallChecker.beforeCalled(r, double[].class, 200, 7888, 7888);
                            CallChecker.isCalled(r, double[].class, 200, 7880, 7880)[i] = -(CallChecker.isCalled(r, double[].class, 200, 7888, 7888)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(r, double[].class, 200, 7880, 7880)[i], "CallChecker.isCalled(r, double[].class, 200, 7880, 7880)[i]", 200, 7880, 7892);
                        }
                    }
                }
            }
            double[] steepestDescent = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(preconditioner, Preconditioner.class, 205, 7991, 8004)) {
                steepestDescent = CallChecker.isCalled(preconditioner, Preconditioner.class, 205, 7991, 8004).precondition(point, r);
                CallChecker.varAssign(steepestDescent, "steepestDescent", 205, 7991, 8004);
            }
            double[] searchDirection = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(steepestDescent, double[].class, 206, 8065, 8079)) {
                steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 206, 8065, 8079);
                searchDirection = CallChecker.isCalled(steepestDescent, double[].class, 206, 8065, 8079).clone();
                CallChecker.varAssign(searchDirection, "searchDirection", 206, 8065, 8079);
            }
            double delta = CallChecker.varInit(((double) (0)), "delta", 208, 8099, 8115);
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(r, double[].class, 210, 8176, 8176)) {
                    if (CallChecker.beforeDeref(searchDirection, double[].class, 210, 8183, 8197)) {
                        r = CallChecker.beforeCalled(r, double[].class, 210, 8176, 8176);
                        searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 210, 8183, 8197);
                        delta += (CallChecker.isCalled(r, double[].class, 210, 8176, 8176)[i]) * (CallChecker.isCalled(searchDirection, double[].class, 210, 8183, 8197)[i]);
                        CallChecker.varAssign(delta, "delta", 210, 8167, 8201);
                    }
                }
            }
            PointValuePair current = CallChecker.varInit(null, "current", 213, 8222, 8251);
            int maxEval = CallChecker.varInit(((int) (getMaxEvaluations())), "maxEval", 214, 8261, 8294);
            while (true) {
                incrementIterationCount();
                final double objective = CallChecker.varInit(((double) (computeObjectiveValue(point))), "objective", 218, 8371, 8424);
                PointValuePair previous = CallChecker.varInit(current, "previous", 219, 8438, 8471);
                current = new PointValuePair(point, objective);
                CallChecker.varAssign(current, "current", 220, 8485, 8531);
                if (CallChecker.beforeDeref(checker, ConvergenceChecker.class, 221, 8569, 8575)) {
                    if ((previous != null) && (CallChecker.isCalled(checker, ConvergenceChecker.class, 221, 8569, 8575).converged(getIterations(), previous, current))) {
                        return current;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final UnivariateFunction lsf = CallChecker.varInit(new NonLinearConjugateGradientOptimizer.LineSearchFunction(point, searchDirection), "lsf", 227, 8730, 8869);
                final double uB = CallChecker.varInit(((double) (findUpperBound(lsf, 0, this.initialStep))), "uB", 228, 8883, 8936);
                final double step = CallChecker.varInit(((double) (CallChecker.isCalled(this.solver, UnivariateSolver.class, 232, 9167, 9172).solve(maxEval, lsf, 0, uB, 1.0E-15))), "step", 232, 8950, 9207);
                if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 233, 9232, 9237)) {
                    maxEval -= CallChecker.isCalled(solver, UnivariateSolver.class, 233, 9232, 9237).getEvaluations();
                    CallChecker.varAssign(maxEval, "maxEval", 233, 9221, 9255);
                }
                for (int i = 0; i < (CallChecker.isCalled(point, double[].class, 236, 9358, 9362).length); ++i) {
                    if (CallChecker.beforeDeref(point, double[].class, 237, 9395, 9399)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 237, 9414, 9428)) {
                            searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 237, 9414, 9428);
                            CallChecker.isCalled(point, double[].class, 237, 9395, 9399)[i] += step * (CallChecker.isCalled(searchDirection, double[].class, 237, 9414, 9428)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(point, double[].class, 237, 9395, 9399)[i], "CallChecker.isCalled(point, double[].class, 237, 9395, 9399)[i]", 237, 9395, 9432);
                        }
                    }
                }
                r = computeObjectiveGradient(point);
                CallChecker.varAssign(r, "r", 240, 9461, 9496);
                if (goal == (GoalType.MINIMIZE)) {
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(r, double[].class, 243, 9609, 9609)) {
                            if (CallChecker.beforeDeref(r, double[].class, 243, 9617, 9617)) {
                                r = CallChecker.beforeCalled(r, double[].class, 243, 9609, 9609);
                                r = CallChecker.beforeCalled(r, double[].class, 243, 9617, 9617);
                                CallChecker.isCalled(r, double[].class, 243, 9609, 9609)[i] = -(CallChecker.isCalled(r, double[].class, 243, 9617, 9617)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(r, double[].class, 243, 9609, 9609)[i], "CallChecker.isCalled(r, double[].class, 243, 9609, 9609)[i]", 243, 9609, 9621);
                            }
                        }
                    }
                }
                final double deltaOld = CallChecker.varInit(((double) (delta)), "deltaOld", 248, 9668, 9726);
                final double[] newSteepestDescent = CallChecker.varInit(CallChecker.isCalled(preconditioner, Preconditioner.class, 249, 9776, 9789).precondition(point, r), "newSteepestDescent", 249, 9740, 9813);
                delta = 0;
                CallChecker.varAssign(delta, "delta", 250, 9827, 9836);
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(r, double[].class, 252, 9905, 9905)) {
                        if (CallChecker.beforeDeref(newSteepestDescent, double[].class, 252, 9912, 9929)) {
                            r = CallChecker.beforeCalled(r, double[].class, 252, 9905, 9905);
                            delta += (CallChecker.isCalled(r, double[].class, 252, 9905, 9905)[i]) * (CallChecker.isCalled(newSteepestDescent, double[].class, 252, 9912, 9929)[i]);
                            CallChecker.varAssign(delta, "delta", 252, 9896, 9933);
                        }
                    }
                }
                double beta = CallChecker.init(double.class);
                switch (updateFormula) {
                    case FLETCHER_REEVES :
                        beta = delta / deltaOld;
                        CallChecker.varAssign(beta, "beta", 258, 10068, 10091);
                        break;
                    case POLAK_RIBIERE :
                        double deltaMid = CallChecker.varInit(((double) (0)), "deltaMid", 261, 10164, 10183);
                        r = CallChecker.beforeCalled(r, double[].class, 262, 10221, 10221);
                        for (int i = 0; i < (CallChecker.isCalled(r, double[].class, 262, 10221, 10221).length); ++i) {
                            if (CallChecker.beforeDeref(r, double[].class, 263, 10270, 10270)) {
                                if (CallChecker.beforeDeref(steepestDescent, double[].class, 263, 10277, 10291)) {
                                    r = CallChecker.beforeCalled(r, double[].class, 263, 10270, 10270);
                                    steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 263, 10277, 10291);
                                    deltaMid += (CallChecker.isCalled(r, double[].class, 263, 10270, 10270)[i]) * (CallChecker.isCalled(steepestDescent, double[].class, 263, 10277, 10291)[i]);
                                    CallChecker.varAssign(deltaMid, "deltaMid", 263, 10258, 10295);
                                }
                            }
                        }
                        beta = (delta - deltaMid) / deltaOld;
                        CallChecker.varAssign(beta, "beta", 265, 10331, 10367);
                        break;
                    default :
                        throw new MathInternalError();
                }
                steepestDescent = newSteepestDescent;
                CallChecker.varAssign(steepestDescent, "steepestDescent", 271, 10526, 10562);
                if ((((getIterations()) % n) == 0) || (beta < 0)) {
                    if (CallChecker.beforeDeref(steepestDescent, double[].class, 277, 10784, 10798)) {
                        steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 277, 10784, 10798);
                        searchDirection = CallChecker.isCalled(steepestDescent, double[].class, 277, 10784, 10798).clone();
                        CallChecker.varAssign(searchDirection, "searchDirection", 277, 10766, 10807);
                    }
                }else {
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 281, 10955, 10969)) {
                            if (CallChecker.beforeDeref(steepestDescent, double[].class, 281, 10976, 10990)) {
                                if (CallChecker.beforeDeref(searchDirection, double[].class, 281, 11004, 11018)) {
                                    searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 281, 10955, 10969);
                                    steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 281, 10976, 10990);
                                    searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 281, 11004, 11018);
                                    CallChecker.isCalled(searchDirection, double[].class, 281, 10955, 10969)[i] = (CallChecker.isCalled(steepestDescent, double[].class, 281, 10976, 10990)[i]) + (beta * (CallChecker.isCalled(searchDirection, double[].class, 281, 11004, 11018)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(searchDirection, double[].class, 281, 10955, 10969)[i], "CallChecker.isCalled(searchDirection, double[].class, 281, 10955, 10969)[i]", 281, 10955, 11022);
                                }
                            }
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context343.methodEnd();
        }
    }

    @Override
    protected void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context344 = new MethodContext(void.class, 298, 11077, 12029);
        try {
            CallChecker.varInit(this, "this", 298, 11077, 12029);
            CallChecker.varInit(optData, "optData", 298, 11077, 12029);
            CallChecker.varInit(this.iterations, "iterations", 298, 11077, 12029);
            CallChecker.varInit(this.evaluations, "evaluations", 298, 11077, 12029);
            CallChecker.varInit(this.initialStep, "initialStep", 298, 11077, 12029);
            CallChecker.varInit(this.solver, "solver", 298, 11077, 12029);
            CallChecker.varInit(this.preconditioner, "preconditioner", 298, 11077, 12029);
            CallChecker.varInit(this.updateFormula, "updateFormula", 298, 11077, 12029);
            super.parseOptimizationData(optData);
            if (CallChecker.beforeDeref(optData, void.class, 304, 11698, 11704)) {
                for (OptimizationData data : optData) {
                    if (data instanceof NonLinearConjugateGradientOptimizer.BracketingStep) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 306, 11808, 11811)) {
                            initialStep = CallChecker.isCalled(((NonLinearConjugateGradientOptimizer.BracketingStep) (data)), NonLinearConjugateGradientOptimizer.BracketingStep.class, 306, 11808, 11811).getBracketingStep();
                            CallChecker.varAssign(this.initialStep, "this.initialStep", 306, 11776, 11833);
                        }
                        break;
                    }
                }
            }
            checkParameters();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context344.methodEnd();
        }
    }

    private double findUpperBound(final UnivariateFunction f, final double a, final double h) {
        MethodContext _bcornu_methode_context345 = new MethodContext(double.class, 325, 12036, 12942);
        try {
            CallChecker.varInit(this, "this", 325, 12036, 12942);
            CallChecker.varInit(h, "h", 325, 12036, 12942);
            CallChecker.varInit(a, "a", 325, 12036, 12942);
            CallChecker.varInit(f, "f", 325, 12036, 12942);
            CallChecker.varInit(this.iterations, "iterations", 325, 12036, 12942);
            CallChecker.varInit(this.evaluations, "evaluations", 325, 12036, 12942);
            CallChecker.varInit(this.initialStep, "initialStep", 325, 12036, 12942);
            CallChecker.varInit(this.solver, "solver", 325, 12036, 12942);
            CallChecker.varInit(this.preconditioner, "preconditioner", 325, 12036, 12942);
            CallChecker.varInit(this.updateFormula, "updateFormula", 325, 12036, 12942);
            final double yA = CallChecker.varInit(((double) (CallChecker.isCalled(f, UnivariateFunction.class, 327, 12557, 12557).value(a))), "yA", 327, 12539, 12567);
            double yB = CallChecker.varInit(((double) (yA)), "yB", 328, 12577, 12591);
            for (double step = h; step < (Double.MAX_VALUE); step *= FastMath.max(2, (yA / yB))) {
                CallChecker.varAssign(step, "step", 329, 12648, 12679);
                final double b = CallChecker.varInit(((double) (a + step)), "b", 330, 12696, 12721);
                if (CallChecker.beforeDeref(f, UnivariateFunction.class, 331, 12740, 12740)) {
                    yB = CallChecker.isCalled(f, UnivariateFunction.class, 331, 12740, 12740).value(b);
                    CallChecker.varAssign(yB, "yB", 331, 12735, 12750);
                }
                if ((yA * yB) <= 0) {
                    return b;
                }
            }
            throw new MathIllegalStateException(LocalizedFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context345.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context346 = new MethodContext(void.class, 398, 14872, 15239);
        try {
            CallChecker.varInit(this, "this", 398, 14872, 15239);
            CallChecker.varInit(this.iterations, "iterations", 398, 14872, 15239);
            CallChecker.varInit(this.evaluations, "evaluations", 398, 14872, 15239);
            CallChecker.varInit(this.initialStep, "initialStep", 398, 14872, 15239);
            CallChecker.varInit(this.solver, "solver", 398, 14872, 15239);
            CallChecker.varInit(this.preconditioner, "preconditioner", 398, 14872, 15239);
            CallChecker.varInit(this.updateFormula, "updateFormula", 398, 14872, 15239);
            if (((getLowerBound()) != null) || ((getUpperBound()) != null)) {
                throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }
}

