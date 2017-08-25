package org.apache.commons.math.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.util.MathUtils;

public class SimplexSolver extends AbstractLinearOptimizer {
    private static final double DEFAULT_EPSILON = 1.0E-6;

    protected final double epsilon;

    public SimplexSolver() {
        this(SimplexSolver.DEFAULT_EPSILON);
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(SimplexSolver.class, 41, 1521, 1650);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public SimplexSolver(final double epsilon) {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(SimplexSolver.class, 49, 1657, 1908);
        try {
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 50, 1880, 1902);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    private Integer getPivotColumn(SimplexTableau tableau) {
        MethodContext _bcornu_methode_context1 = new MethodContext(Integer.class, 58, 1915, 2558);
        try {
            CallChecker.varInit(this, "this", 58, 1915, 2558);
            CallChecker.varInit(tableau, "tableau", 58, 1915, 2558);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 58, 1915, 2558);
            CallChecker.varInit(this.goalType, "goalType", 58, 1915, 2558);
            CallChecker.varInit(this.constraints, "constraints", 58, 1915, 2558);
            CallChecker.varInit(this.f, "f", 58, 1915, 2558);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 58, 1915, 2558);
            CallChecker.varInit(this.epsilon, "epsilon", 58, 1915, 2558);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 58, 1915, 2558);
            double minValue = CallChecker.varInit(((double) (0)), "minValue", 59, 2198, 2217);
            Integer minPos = CallChecker.varInit(null, "minPos", 60, 2227, 2248);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 61, 2271, 2277);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 61, 2311, 2317);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 61, 2271, 2277).getNumObjectiveFunctions(); i < ((CallChecker.isCalled(tableau, SimplexTableau.class, 61, 2311, 2317).getWidth()) - 1); i++) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 62, 2378, 2384)) {
                    tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 62, 2378, 2384);
                    if ((MathUtils.compareTo(CallChecker.isCalled(tableau, SimplexTableau.class, 62, 2378, 2384).getEntry(0, i), minValue, epsilon)) < 0) {
                        if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 63, 2455, 2461)) {
                            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 63, 2455, 2461);
                            minValue = CallChecker.isCalled(tableau, SimplexTableau.class, 63, 2455, 2461).getEntry(0, i);
                            CallChecker.varAssign(minValue, "minValue", 63, 2444, 2477);
                        }
                        minPos = i;
                        CallChecker.varAssign(minPos, "minPos", 64, 2495, 2505);
                    }
                }
            }
            return minPos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    private Integer getPivotRow(final int col, final SimplexTableau tableau) {
        MethodContext _bcornu_methode_context2 = new MethodContext(Integer.class, 76, 2565, 3541);
        try {
            CallChecker.varInit(this, "this", 76, 2565, 3541);
            CallChecker.varInit(tableau, "tableau", 76, 2565, 3541);
            CallChecker.varInit(col, "col", 76, 2565, 3541);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 76, 2565, 3541);
            CallChecker.varInit(this.goalType, "goalType", 76, 2565, 3541);
            CallChecker.varInit(this.constraints, "constraints", 76, 2565, 3541);
            CallChecker.varInit(this.f, "f", 76, 2565, 3541);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 76, 2565, 3541);
            CallChecker.varInit(this.epsilon, "epsilon", 76, 2565, 3541);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 76, 2565, 3541);
            double minRatio = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minRatio", 77, 2943, 2977);
            Integer minRatioPos = CallChecker.varInit(null, "minRatioPos", 78, 2987, 3013);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 79, 3036, 3042).getNumObjectiveFunctions(); i < (CallChecker.isCalled(tableau, SimplexTableau.class, 79, 3076, 3082).getHeight()); i++) {
                final double rhs = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 80, 3135, 3141).getEntry(i, ((CallChecker.isCalled(tableau, SimplexTableau.class, 80, 3155, 3161).getWidth()) - 1)))), "rhs", 80, 3116, 3178);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 81, 3213, 3219).getEntry(i, col))), "entry", 81, 3192, 3237);
                if ((MathUtils.compareTo(entry, 0, epsilon)) > 0) {
                    final double ratio = CallChecker.varInit(((double) (rhs / entry)), "ratio", 83, 3317, 3349);
                    if (ratio < minRatio) {
                        minRatio = ratio;
                        CallChecker.varAssign(minRatio, "minRatio", 85, 3411, 3427);
                        minRatioPos = i;
                        CallChecker.varAssign(minRatioPos, "minRatioPos", 86, 3449, 3464);
                    }
                }
            }
            return minRatioPos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    protected void doIteration(final SimplexTableau tableau) throws OptimizationException {
        MethodContext _bcornu_methode_context3 = new MethodContext(void.class, 100, 3549, 4622);
        try {
            CallChecker.varInit(this, "this", 100, 3549, 4622);
            CallChecker.varInit(tableau, "tableau", 100, 3549, 4622);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 100, 3549, 4622);
            CallChecker.varInit(this.goalType, "goalType", 100, 3549, 4622);
            CallChecker.varInit(this.constraints, "constraints", 100, 3549, 4622);
            CallChecker.varInit(this.f, "f", 100, 3549, 4622);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 100, 3549, 4622);
            CallChecker.varInit(this.epsilon, "epsilon", 100, 3549, 4622);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 100, 3549, 4622);
            incrementIterationsCounter();
            Integer pivotCol = CallChecker.varInit(getPivotColumn(tableau), "pivotCol", 105, 3979, 4021);
            Integer pivotRow = CallChecker.varInit(getPivotRow(pivotCol, tableau), "pivotRow", 106, 4031, 4080);
            if (pivotRow == null) {
                throw new UnboundedSolutionException();
            }
            double pivotVal = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 112, 4241, 4247)) {
                pivotVal = CallChecker.isCalled(tableau, SimplexTableau.class, 112, 4241, 4247).getEntry(pivotRow, pivotCol);
                CallChecker.varAssign(pivotVal, "pivotVal", 112, 4241, 4247);
            }
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 113, 4287, 4293)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 113, 4287, 4293).divideRow(pivotRow, pivotVal);
            }
            for (int i = 0; i < (CallChecker.isCalled(tableau, SimplexTableau.class, 116, 4404, 4410).getHeight()); i++) {
                if (i != pivotRow) {
                    double multiplier = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 118, 4501, 4507)) {
                        multiplier = CallChecker.isCalled(tableau, SimplexTableau.class, 118, 4501, 4507).getEntry(i, pivotCol);
                        CallChecker.varAssign(multiplier, "multiplier", 118, 4501, 4507);
                    }
                    if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 119, 4548, 4554)) {
                        CallChecker.isCalled(tableau, SimplexTableau.class, 119, 4548, 4554).subtractRow(i, pivotRow, multiplier);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    private boolean isPhase1Solved(final SimplexTableau tableau) {
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class, 129, 4629, 5184);
        try {
            CallChecker.varInit(this, "this", 129, 4629, 5184);
            CallChecker.varInit(tableau, "tableau", 129, 4629, 5184);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 129, 4629, 5184);
            CallChecker.varInit(this.goalType, "goalType", 129, 4629, 5184);
            CallChecker.varInit(this.constraints, "constraints", 129, 4629, 5184);
            CallChecker.varInit(this.f, "f", 129, 4629, 5184);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 129, 4629, 5184);
            CallChecker.varInit(this.epsilon, "epsilon", 129, 4629, 5184);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 129, 4629, 5184);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 130, 4855, 4861)) {
                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 130, 4855, 4861).getNumArtificialVariables()) == 0) {
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 133, 4955, 4961).getNumObjectiveFunctions(); i < ((CallChecker.isCalled(tableau, SimplexTableau.class, 133, 4995, 5001).getWidth()) - 1); i++) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 134, 5062, 5068)) {
                    if ((MathUtils.compareTo(CallChecker.isCalled(tableau, SimplexTableau.class, 134, 5062, 5068).getEntry(0, i), 0, epsilon)) < 0) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public boolean isOptimal(final SimplexTableau tableau) {
        MethodContext _bcornu_methode_context5 = new MethodContext(boolean.class, 146, 5191, 5766);
        try {
            CallChecker.varInit(this, "this", 146, 5191, 5766);
            CallChecker.varInit(tableau, "tableau", 146, 5191, 5766);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 146, 5191, 5766);
            CallChecker.varInit(this.goalType, "goalType", 146, 5191, 5766);
            CallChecker.varInit(this.constraints, "constraints", 146, 5191, 5766);
            CallChecker.varInit(this.f, "f", 146, 5191, 5766);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 146, 5191, 5766);
            CallChecker.varInit(this.epsilon, "epsilon", 146, 5191, 5766);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 146, 5191, 5766);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 147, 5437, 5443)) {
                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 147, 5437, 5443).getNumArtificialVariables()) > 0) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 150, 5537, 5543).getNumObjectiveFunctions(); i < ((CallChecker.isCalled(tableau, SimplexTableau.class, 150, 5577, 5583).getWidth()) - 1); i++) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 151, 5644, 5650)) {
                    if ((MathUtils.compareTo(CallChecker.isCalled(tableau, SimplexTableau.class, 151, 5644, 5650).getEntry(0, i), 0, epsilon)) < 0) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    protected void solvePhase1(final SimplexTableau tableau) throws OptimizationException {
        MethodContext _bcornu_methode_context6 = new MethodContext(void.class, 165, 5773, 6613);
        try {
            CallChecker.varInit(this, "this", 165, 5773, 6613);
            CallChecker.varInit(tableau, "tableau", 165, 5773, 6613);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 165, 5773, 6613);
            CallChecker.varInit(this.goalType, "goalType", 165, 5773, 6613);
            CallChecker.varInit(this.constraints, "constraints", 165, 5773, 6613);
            CallChecker.varInit(this.f, "f", 165, 5773, 6613);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 165, 5773, 6613);
            CallChecker.varInit(this.epsilon, "epsilon", 165, 5773, 6613);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 165, 5773, 6613);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 168, 6231, 6237)) {
                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 168, 6231, 6237).getNumArtificialVariables()) == 0) {
                    return ;
                }
            }
            while (!(isPhase1Solved(tableau))) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 177, 6506, 6512)) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 177, 6486, 6492)) {
                    if (!(MathUtils.equals(CallChecker.isCalled(tableau, SimplexTableau.class, 177, 6486, 6492).getEntry(0, CallChecker.isCalled(tableau, SimplexTableau.class, 177, 6506, 6512).getRhsOffset()), 0, epsilon))) {
                        throw new NoFeasibleSolutionException();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    @Override
    public RealPointValuePair doOptimize() throws OptimizationException {
        MethodContext _bcornu_methode_context7 = new MethodContext(RealPointValuePair.class, 184, 6620, 7066);
        try {
            CallChecker.varInit(this, "this", 184, 6620, 7066);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 184, 6620, 7066);
            CallChecker.varInit(this.goalType, "goalType", 184, 6620, 7066);
            CallChecker.varInit(this.constraints, "constraints", 184, 6620, 7066);
            CallChecker.varInit(this.f, "f", 184, 6620, 7066);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 184, 6620, 7066);
            CallChecker.varInit(this.epsilon, "epsilon", 184, 6620, 7066);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 184, 6620, 7066);
            final SimplexTableau tableau = CallChecker.varInit(new SimplexTableau(f, constraints, goalType, restrictToNonNegative, epsilon), "tableau", 186, 6745, 6864);
            solvePhase1(tableau);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 189, 6904, 6910)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 189, 6904, 6910).discardArtificialVariables();
            }
            while (!(isOptimal(tableau))) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 193, 7039, 7045)) {
                return CallChecker.isCalled(tableau, SimplexTableau.class, 193, 7039, 7045).getSolution();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealPointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }
}

