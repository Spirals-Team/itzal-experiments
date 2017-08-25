package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class NonLinearConjugateGradientOptimizer extends AbstractScalarDifferentiableOptimizer {
    public static class IdentityPreconditioner implements Preconditioner {
        public double[] precondition(double[] variables, double[] r) {
            MethodContext _bcornu_methode_context334 = new MethodContext(double[].class, 267, 10627, 10757);
            try {
                CallChecker.varInit(this, "this", 267, 10627, 10757);
                CallChecker.varInit(r, "r", 267, 10627, 10757);
                CallChecker.varInit(variables, "variables", 267, 10627, 10757);
                if (CallChecker.beforeDeref(r, double[].class, 268, 10738, 10738)) {
                    r = CallChecker.beforeCalled(r, double[].class, 268, 10738, 10738);
                    return CallChecker.isCalled(r, double[].class, 268, 10738, 10738).clone();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context334.methodEnd();
            }
        }
    }

    private class LineSearchFunction implements UnivariateFunction {
        private final double[] searchDirection;

        public LineSearchFunction(final double[] searchDirection) {
            ConstructorContext _bcornu_methode_context81 = new ConstructorContext(NonLinearConjugateGradientOptimizer.LineSearchFunction.class, 288, 11312, 11527);
            try {
                this.searchDirection = searchDirection;
                CallChecker.varAssign(this.searchDirection, "this.searchDirection", 289, 11479, 11517);
            } finally {
                _bcornu_methode_context81.methodEnd();
            }
        }

        public double value(double x) {
            MethodContext _bcornu_methode_context335 = new MethodContext(double.class, 293, 11538, 12234);
            try {
                CallChecker.varInit(this, "this", 293, 11538, 12234);
                CallChecker.varInit(x, "x", 293, 11538, 12234);
                CallChecker.varInit(this.searchDirection, "searchDirection", 293, 11538, 12234);
                point = CallChecker.beforeCalled(point, double[].class, 295, 11694, 11698);
                final double[] shiftedPoint = CallChecker.varInit(CallChecker.isCalled(point, double[].class, 295, 11694, 11698).clone(), "shiftedPoint", 295, 11664, 11707);
                for (int i = 0; i < (CallChecker.isCalled(shiftedPoint, double[].class, 296, 11741, 11752).length); ++i) {
                    if (CallChecker.beforeDeref(shiftedPoint, double[].class, 297, 11785, 11796)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 297, 11808, 11822)) {
                            CallChecker.isCalled(shiftedPoint, double[].class, 297, 11785, 11796)[i] += x * (CallChecker.isCalled(searchDirection, double[].class, 297, 11808, 11822)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(shiftedPoint, double[].class, 297, 11785, 11796)[i], "CallChecker.isCalled(shiftedPoint, double[].class, 297, 11785, 11796)[i]", 297, 11785, 11826);
                        }
                    }
                }
                final double[] gradient = CallChecker.varInit(computeObjectiveGradient(shiftedPoint), "gradient", 301, 11905, 11969);
                double dotProduct = CallChecker.varInit(((double) (0)), "dotProduct", 304, 12037, 12058);
                for (int i = 0; i < (CallChecker.isCalled(gradient, double[].class, 305, 12092, 12099).length); ++i) {
                    if (CallChecker.beforeDeref(gradient, double[].class, 306, 12146, 12153)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 306, 12160, 12174)) {
                            dotProduct += (CallChecker.isCalled(gradient, double[].class, 306, 12146, 12153)[i]) * (CallChecker.isCalled(searchDirection, double[].class, 306, 12160, 12174)[i]);
                            CallChecker.varAssign(dotProduct, "dotProduct", 306, 12132, 12178);
                        }
                    }
                }
                return dotProduct;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context335.methodEnd();
            }
        }
    }

    private final ConjugateGradientFormula updateFormula;

    private final Preconditioner preconditioner;

    private final UnivariateSolver solver;

    private double initialStep;

    private double[] point;

    @Deprecated
    public NonLinearConjugateGradientOptimizer(final ConjugateGradientFormula updateFormula) {
        this(updateFormula, new SimpleValueChecker());
        ConstructorContext _bcornu_methode_context82 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 69, 2382, 3034);
        try {
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public NonLinearConjugateGradientOptimizer(final ConjugateGradientFormula updateFormula, ConvergenceChecker<PointValuePair> checker) {
        this(updateFormula, checker, new BrentSolver(), new NonLinearConjugateGradientOptimizer.IdentityPreconditioner());
        ConstructorContext _bcornu_methode_context83 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 83, 3041, 3755);
        try {
        } finally {
            _bcornu_methode_context83.methodEnd();
        }
    }

    public NonLinearConjugateGradientOptimizer(final ConjugateGradientFormula updateFormula, ConvergenceChecker<PointValuePair> checker, final UnivariateSolver lineSearchSolver) {
        this(updateFormula, checker, lineSearchSolver, new NonLinearConjugateGradientOptimizer.IdentityPreconditioner());
        ConstructorContext _bcornu_methode_context84 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 101, 3763, 4579);
        try {
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public NonLinearConjugateGradientOptimizer(final ConjugateGradientFormula updateFormula, ConvergenceChecker<PointValuePair> checker, final UnivariateSolver lineSearchSolver, final Preconditioner preconditioner) {
        super(checker);
        ConstructorContext _bcornu_methode_context85 = new ConstructorContext(NonLinearConjugateGradientOptimizer.class, 118, 4586, 5497);
        try {
            this.updateFormula = updateFormula;
            CallChecker.varAssign(this.updateFormula, "this.updateFormula", 124, 5349, 5383);
            solver = lineSearchSolver;
            CallChecker.varAssign(this.solver, "this.solver", 125, 5393, 5418);
            this.preconditioner = preconditioner;
            CallChecker.varAssign(this.preconditioner, "this.preconditioner", 126, 5428, 5464);
            initialStep = 1.0;
            CallChecker.varAssign(this.initialStep, "this.initialStep", 127, 5474, 5491);
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public void setInitialStep(final double initialStep) {
        MethodContext _bcornu_methode_context336 = new MethodContext(void.class, 140, 5504, 6142);
        try {
            CallChecker.varInit(this, "this", 140, 5504, 6142);
            CallChecker.varInit(initialStep, "initialStep", 140, 5504, 6142);
            CallChecker.varInit(this.evaluations, "evaluations", 140, 5504, 6142);
            CallChecker.varInit(this.point, "point", 140, 5504, 6142);
            CallChecker.varInit(this.initialStep, "initialStep", 140, 5504, 6142);
            CallChecker.varInit(this.solver, "solver", 140, 5504, 6142);
            CallChecker.varInit(this.preconditioner, "preconditioner", 140, 5504, 6142);
            CallChecker.varInit(this.updateFormula, "updateFormula", 140, 5504, 6142);
            if (initialStep <= 0) {
                this.initialStep = 1.0;
                CallChecker.varAssign(this.initialStep, "this.initialStep", 142, 6043, 6065);
            }else {
                this.initialStep = initialStep;
                CallChecker.varAssign(this.initialStep, "this.initialStep", 144, 6096, 6126);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context336.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context337 = new MethodContext(PointValuePair.class, 150, 6149, 9584);
        try {
            CallChecker.varInit(this, "this", 150, 6149, 9584);
            CallChecker.varInit(this.evaluations, "evaluations", 150, 6149, 9584);
            CallChecker.varInit(this.point, "point", 150, 6149, 9584);
            CallChecker.varInit(this.initialStep, "initialStep", 150, 6149, 9584);
            CallChecker.varInit(this.solver, "solver", 150, 6149, 9584);
            CallChecker.varInit(this.preconditioner, "preconditioner", 150, 6149, 9584);
            CallChecker.varInit(this.updateFormula, "updateFormula", 150, 6149, 9584);
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 151, 6236, 6310);
            point = getStartPoint();
            CallChecker.varAssign(this.point, "this.point", 152, 6320, 6343);
            final GoalType goal = CallChecker.varInit(getGoalType(), "goal", 153, 6353, 6388);
            point = CallChecker.beforeCalled(point, double[].class, 154, 6412, 6416);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.point, double[].class, 154, 6412, 6416).length)), "n", 154, 6398, 6424);
            double[] r = CallChecker.varInit(computeObjectiveGradient(point), "r", 155, 6434, 6478);
            if (goal == (GoalType.MINIMIZE)) {
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(r, double[].class, 158, 6579, 6579)) {
                        if (CallChecker.beforeDeref(r, double[].class, 158, 6587, 6587)) {
                            r = CallChecker.beforeCalled(r, double[].class, 158, 6579, 6579);
                            r = CallChecker.beforeCalled(r, double[].class, 158, 6587, 6587);
                            CallChecker.isCalled(r, double[].class, 158, 6579, 6579)[i] = -(CallChecker.isCalled(r, double[].class, 158, 6587, 6587)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(r, double[].class, 158, 6579, 6579)[i], "CallChecker.isCalled(r, double[].class, 158, 6579, 6579)[i]", 158, 6579, 6591);
                        }
                    }
                }
            }
            double[] steepestDescent = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(preconditioner, Preconditioner.class, 163, 6690, 6703)) {
                steepestDescent = CallChecker.isCalled(preconditioner, Preconditioner.class, 163, 6690, 6703).precondition(point, r);
                CallChecker.varAssign(steepestDescent, "steepestDescent", 163, 6690, 6703);
            }
            double[] searchDirection = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(steepestDescent, double[].class, 164, 6764, 6778)) {
                steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 164, 6764, 6778);
                searchDirection = CallChecker.isCalled(steepestDescent, double[].class, 164, 6764, 6778).clone();
                CallChecker.varAssign(searchDirection, "searchDirection", 164, 6764, 6778);
            }
            double delta = CallChecker.varInit(((double) (0)), "delta", 166, 6798, 6814);
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(r, double[].class, 168, 6875, 6875)) {
                    if (CallChecker.beforeDeref(searchDirection, double[].class, 168, 6882, 6896)) {
                        r = CallChecker.beforeCalled(r, double[].class, 168, 6875, 6875);
                        searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 168, 6882, 6896);
                        delta += (CallChecker.isCalled(r, double[].class, 168, 6875, 6875)[i]) * (CallChecker.isCalled(searchDirection, double[].class, 168, 6882, 6896)[i]);
                        CallChecker.varAssign(delta, "delta", 168, 6866, 6900);
                    }
                }
            }
            PointValuePair current = CallChecker.varInit(null, "current", 171, 6921, 6950);
            int iter = CallChecker.varInit(((int) (0)), "iter", 172, 6960, 6972);
            int maxEval = CallChecker.varInit(((int) (getMaxEvaluations())), "maxEval", 173, 6982, 7015);
            while (true) {
                ++iter;
                final double objective = CallChecker.varInit(((double) (computeObjectiveValue(this.point))), "objective", 177, 7073, 7126);
                PointValuePair previous = CallChecker.varInit(current, "previous", 178, 7140, 7173);
                current = new PointValuePair(point, objective);
                CallChecker.varAssign(current, "current", 179, 7187, 7233);
                if (CallChecker.beforeDeref(checker, ConvergenceChecker.class, 180, 7271, 7277)) {
                    if ((previous != null) && (CallChecker.isCalled(checker, ConvergenceChecker.class, 180, 7271, 7277).converged(iter, previous, current))) {
                        return current;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final UnivariateFunction lsf = CallChecker.varInit(new NonLinearConjugateGradientOptimizer.LineSearchFunction(searchDirection), "lsf", 186, 7421, 7553);
                final double uB = CallChecker.varInit(((double) (findUpperBound(lsf, 0, this.initialStep))), "uB", 187, 7567, 7620);
                final double step = CallChecker.varInit(((double) (CallChecker.isCalled(this.solver, UnivariateSolver.class, 191, 7851, 7856).solve(maxEval, lsf, 0, uB, 1.0E-15))), "step", 191, 7634, 7891);
                if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 192, 7916, 7921)) {
                    maxEval -= CallChecker.isCalled(solver, UnivariateSolver.class, 192, 7916, 7921).getEvaluations();
                    CallChecker.varAssign(maxEval, "maxEval", 192, 7905, 7939);
                }
                point = CallChecker.beforeCalled(point, double[].class, 195, 8042, 8046);
                for (int i = 0; i < (CallChecker.isCalled(point, double[].class, 195, 8042, 8046).length); ++i) {
                    if (CallChecker.beforeDeref(point, double[].class, 196, 8079, 8083)) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 196, 8098, 8112)) {
                            point = CallChecker.beforeCalled(point, double[].class, 196, 8079, 8083);
                            searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 196, 8098, 8112);
                            CallChecker.isCalled(point, double[].class, 196, 8079, 8083)[i] += step * (CallChecker.isCalled(searchDirection, double[].class, 196, 8098, 8112)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.point, double[].class, 196, 8079, 8083)[i], "CallChecker.isCalled(this.point, double[].class, 196, 8079, 8083)[i]", 196, 8079, 8116);
                        }
                    }
                }
                r = computeObjectiveGradient(point);
                CallChecker.varAssign(r, "r", 199, 8145, 8180);
                if (goal == (GoalType.MINIMIZE)) {
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(r, double[].class, 202, 8293, 8293)) {
                            if (CallChecker.beforeDeref(r, double[].class, 202, 8301, 8301)) {
                                r = CallChecker.beforeCalled(r, double[].class, 202, 8293, 8293);
                                r = CallChecker.beforeCalled(r, double[].class, 202, 8301, 8301);
                                CallChecker.isCalled(r, double[].class, 202, 8293, 8293)[i] = -(CallChecker.isCalled(r, double[].class, 202, 8301, 8301)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(r, double[].class, 202, 8293, 8293)[i], "CallChecker.isCalled(r, double[].class, 202, 8293, 8293)[i]", 202, 8293, 8305);
                            }
                        }
                    }
                }
                final double deltaOld = CallChecker.varInit(((double) (delta)), "deltaOld", 207, 8352, 8410);
                final double[] newSteepestDescent = CallChecker.varInit(CallChecker.isCalled(preconditioner, Preconditioner.class, 208, 8460, 8473).precondition(point, r), "newSteepestDescent", 208, 8424, 8497);
                delta = 0;
                CallChecker.varAssign(delta, "delta", 209, 8511, 8520);
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(r, double[].class, 211, 8589, 8589)) {
                        if (CallChecker.beforeDeref(newSteepestDescent, double[].class, 211, 8596, 8613)) {
                            r = CallChecker.beforeCalled(r, double[].class, 211, 8589, 8589);
                            delta += (CallChecker.isCalled(r, double[].class, 211, 8589, 8589)[i]) * (CallChecker.isCalled(newSteepestDescent, double[].class, 211, 8596, 8613)[i]);
                            CallChecker.varAssign(delta, "delta", 211, 8580, 8617);
                        }
                    }
                }
                double beta = CallChecker.init(double.class);
                if ((updateFormula) == (ConjugateGradientFormula.FLETCHER_REEVES)) {
                    beta = delta / deltaOld;
                    CallChecker.varAssign(beta, "beta", 216, 8758, 8781);
                }else {
                    double deltaMid = CallChecker.varInit(((double) (0)), "deltaMid", 218, 8820, 8839);
                    r = CallChecker.beforeCalled(r, double[].class, 219, 8877, 8877);
                    for (int i = 0; i < (CallChecker.isCalled(r, double[].class, 219, 8877, 8877).length); ++i) {
                        if (CallChecker.beforeDeref(r, double[].class, 220, 8926, 8926)) {
                            if (CallChecker.beforeDeref(steepestDescent, double[].class, 220, 8933, 8947)) {
                                r = CallChecker.beforeCalled(r, double[].class, 220, 8926, 8926);
                                steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 220, 8933, 8947);
                                deltaMid += (CallChecker.isCalled(r, double[].class, 220, 8926, 8926)[i]) * (CallChecker.isCalled(steepestDescent, double[].class, 220, 8933, 8947)[i]);
                                CallChecker.varAssign(deltaMid, "deltaMid", 220, 8914, 8951);
                            }
                        }
                    }
                    beta = (delta - deltaMid) / deltaOld;
                    CallChecker.varAssign(beta, "beta", 222, 8987, 9023);
                }
                steepestDescent = newSteepestDescent;
                CallChecker.varAssign(steepestDescent, "steepestDescent", 224, 9051, 9087);
                if (((iter % n) == 0) || (beta < 0)) {
                    if (CallChecker.beforeDeref(steepestDescent, double[].class, 230, 9298, 9312)) {
                        steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 230, 9298, 9312);
                        searchDirection = CallChecker.isCalled(steepestDescent, double[].class, 230, 9298, 9312).clone();
                        CallChecker.varAssign(searchDirection, "searchDirection", 230, 9280, 9321);
                    }
                }else {
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(searchDirection, double[].class, 234, 9469, 9483)) {
                            if (CallChecker.beforeDeref(steepestDescent, double[].class, 234, 9490, 9504)) {
                                if (CallChecker.beforeDeref(searchDirection, double[].class, 234, 9518, 9532)) {
                                    searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 234, 9469, 9483);
                                    steepestDescent = CallChecker.beforeCalled(steepestDescent, double[].class, 234, 9490, 9504);
                                    searchDirection = CallChecker.beforeCalled(searchDirection, double[].class, 234, 9518, 9532);
                                    CallChecker.isCalled(searchDirection, double[].class, 234, 9469, 9483)[i] = (CallChecker.isCalled(steepestDescent, double[].class, 234, 9490, 9504)[i]) + (beta * (CallChecker.isCalled(searchDirection, double[].class, 234, 9518, 9532)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(searchDirection, double[].class, 234, 9469, 9483)[i], "CallChecker.isCalled(searchDirection, double[].class, 234, 9469, 9483)[i]", 234, 9469, 9536);
                                }
                            }
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context337.methodEnd();
        }
    }

    private double findUpperBound(final UnivariateFunction f, final double a, final double h) {
        MethodContext _bcornu_methode_context338 = new MethodContext(double.class, 249, 9591, 10496);
        try {
            CallChecker.varInit(this, "this", 249, 9591, 10496);
            CallChecker.varInit(h, "h", 249, 9591, 10496);
            CallChecker.varInit(a, "a", 249, 9591, 10496);
            CallChecker.varInit(f, "f", 249, 9591, 10496);
            CallChecker.varInit(this.evaluations, "evaluations", 249, 9591, 10496);
            CallChecker.varInit(this.point, "point", 249, 9591, 10496);
            CallChecker.varInit(this.initialStep, "initialStep", 249, 9591, 10496);
            CallChecker.varInit(this.solver, "solver", 249, 9591, 10496);
            CallChecker.varInit(this.preconditioner, "preconditioner", 249, 9591, 10496);
            CallChecker.varInit(this.updateFormula, "updateFormula", 249, 9591, 10496);
            final double yA = CallChecker.varInit(((double) (CallChecker.isCalled(f, UnivariateFunction.class, 251, 10111, 10111).value(a))), "yA", 251, 10093, 10121);
            double yB = CallChecker.varInit(((double) (yA)), "yB", 252, 10131, 10145);
            for (double step = h; step < (Double.MAX_VALUE); step *= FastMath.max(2, (yA / yB))) {
                CallChecker.varAssign(step, "step", 253, 10202, 10233);
                final double b = CallChecker.varInit(((double) (a + step)), "b", 254, 10250, 10275);
                if (CallChecker.beforeDeref(f, UnivariateFunction.class, 255, 10294, 10294)) {
                    yB = CallChecker.isCalled(f, UnivariateFunction.class, 255, 10294, 10294).value(b);
                    CallChecker.varAssign(yB, "yB", 255, 10289, 10304);
                }
                if ((yA * yB) <= 0) {
                    return b;
                }
            }
            throw new MathIllegalStateException(LocalizedFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context338.methodEnd();
        }
    }
}

