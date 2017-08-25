package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.util.Precision;

public class SimplexSolver extends LinearOptimizer {
    static final int DEFAULT_ULPS = 10;

    static final double DEFAULT_CUT_OFF = 1.0E-12;

    private static final double DEFAULT_EPSILON = 1.0E-6;

    private final double epsilon;

    private final int maxUlps;

    private final double cutOff;

    public SimplexSolver() {
        this(SimplexSolver.DEFAULT_EPSILON, SimplexSolver.DEFAULT_ULPS, SimplexSolver.DEFAULT_CUT_OFF);
        ConstructorContext _bcornu_methode_context429 = new ConstructorContext(SimplexSolver.class, 81, 3467, 3628);
        try {
        } finally {
            _bcornu_methode_context429.methodEnd();
        }
    }

    public SimplexSolver(final double epsilon) {
        this(epsilon, SimplexSolver.DEFAULT_ULPS, SimplexSolver.DEFAULT_CUT_OFF);
        ConstructorContext _bcornu_methode_context430 = new ConstructorContext(SimplexSolver.class, 90, 3635, 3910);
        try {
        } finally {
            _bcornu_methode_context430.methodEnd();
        }
    }

    public SimplexSolver(final double epsilon, final int maxUlps) {
        this(epsilon, maxUlps, SimplexSolver.DEFAULT_CUT_OFF);
        ConstructorContext _bcornu_methode_context431 = new ConstructorContext(SimplexSolver.class, 100, 3917, 4285);
        try {
        } finally {
            _bcornu_methode_context431.methodEnd();
        }
    }

    public SimplexSolver(final double epsilon, final int maxUlps, final double cutOff) {
        ConstructorContext _bcornu_methode_context432 = new ConstructorContext(SimplexSolver.class, 111, 4292, 4799);
        try {
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 112, 4709, 4731);
            this.maxUlps = maxUlps;
            CallChecker.varAssign(this.maxUlps, "this.maxUlps", 113, 4741, 4763);
            this.cutOff = cutOff;
            CallChecker.varAssign(this.cutOff, "this.cutOff", 114, 4773, 4793);
        } finally {
            _bcornu_methode_context432.methodEnd();
        }
    }

    private Integer getPivotColumn(SimplexTableau tableau) {
        MethodContext _bcornu_methode_context1823 = new MethodContext(Integer.class, 123, 4806, 5577);
        try {
            CallChecker.varInit(this, "this", 123, 4806, 5577);
            CallChecker.varInit(tableau, "tableau", 123, 4806, 5577);
            CallChecker.varInit(this.iterations, "iterations", 123, 4806, 5577);
            CallChecker.varInit(this.evaluations, "evaluations", 123, 4806, 5577);
            CallChecker.varInit(this.cutOff, "cutOff", 123, 4806, 5577);
            CallChecker.varInit(this.maxUlps, "maxUlps", 123, 4806, 5577);
            CallChecker.varInit(this.epsilon, "epsilon", 123, 4806, 5577);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_EPSILON", 123, 4806, 5577);
            CallChecker.varInit(DEFAULT_CUT_OFF, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_CUT_OFF", 123, 4806, 5577);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_ULPS", 123, 4806, 5577);
            double minValue = CallChecker.varInit(((double) (0)), "minValue", 124, 5102, 5121);
            Integer minPos = CallChecker.varInit(null, "minPos", 125, 5131, 5152);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 126, 5175, 5181);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 126, 5215, 5221);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 126, 5175, 5181).getNumObjectiveFunctions(); i < ((CallChecker.isCalled(tableau, SimplexTableau.class, 126, 5215, 5221).getWidth()) - 1); i++) {
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 127, 5279, 5285);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 127, 5279, 5285).getEntry(0, i))), "entry", 127, 5258, 5301);
                if (entry < minValue) {
                    minValue = entry;
                    CallChecker.varAssign(minValue, "minValue", 131, 5480, 5496);
                    minPos = i;
                    CallChecker.varAssign(minPos, "minPos", 132, 5514, 5524);
                }
            }
            return minPos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1823.methodEnd();
        }
    }

    private Integer getPivotRow(SimplexTableau tableau, final int col) {
        MethodContext _bcornu_methode_context1824 = new MethodContext(Integer.class, 145, 5584, 9377);
        try {
            CallChecker.varInit(this, "this", 145, 5584, 9377);
            CallChecker.varInit(col, "col", 145, 5584, 9377);
            CallChecker.varInit(tableau, "tableau", 145, 5584, 9377);
            CallChecker.varInit(this.iterations, "iterations", 145, 5584, 9377);
            CallChecker.varInit(this.evaluations, "evaluations", 145, 5584, 9377);
            CallChecker.varInit(this.cutOff, "cutOff", 145, 5584, 9377);
            CallChecker.varInit(this.maxUlps, "maxUlps", 145, 5584, 9377);
            CallChecker.varInit(this.epsilon, "epsilon", 145, 5584, 9377);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_EPSILON", 145, 5584, 9377);
            CallChecker.varInit(DEFAULT_CUT_OFF, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_CUT_OFF", 145, 5584, 9377);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_ULPS", 145, 5584, 9377);
            List<Integer> minRatioPositions = CallChecker.varInit(new ArrayList<Integer>(), "minRatioPositions", 147, 6063, 6121);
            double minRatio = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minRatio", 148, 6131, 6165);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 149, 6188, 6194);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 149, 6228, 6234);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 149, 6188, 6194).getNumObjectiveFunctions(); i < (CallChecker.isCalled(tableau, SimplexTableau.class, 149, 6228, 6234).getHeight()); i++) {
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 150, 6307, 6313);
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 150, 6287, 6293);
                final double rhs = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 150, 6287, 6293).getEntry(i, ((CallChecker.isCalled(tableau, SimplexTableau.class, 150, 6307, 6313).getWidth()) - 1)))), "rhs", 150, 6268, 6330);
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 151, 6365, 6371);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 151, 6365, 6371).getEntry(i, col))), "entry", 151, 6344, 6389);
                if ((Precision.compareTo(entry, 0.0, maxUlps)) > 0) {
                    final double ratio = CallChecker.varInit(((double) (rhs / entry)), "ratio", 154, 6471, 6503);
                    final int cmp = CallChecker.varInit(((int) (Double.compare(ratio, minRatio))), "cmp", 157, 6521, 6699);
                    if (cmp == 0) {
                        if (CallChecker.beforeDeref(minRatioPositions, List.class, 159, 6753, 6769)) {
                            minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 159, 6753, 6769);
                            CallChecker.isCalled(minRatioPositions, List.class, 159, 6753, 6769).add(i);
                        }
                    }else
                        if (cmp < 0) {
                            minRatio = ratio;
                            CallChecker.varAssign(minRatio, "minRatio", 161, 6837, 6853);
                            minRatioPositions = new ArrayList<Integer>();
                            CallChecker.varAssign(minRatioPositions, "minRatioPositions", 162, 6875, 6919);
                            if (CallChecker.beforeDeref(minRatioPositions, List.class, 163, 6941, 6957)) {
                                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 163, 6941, 6957);
                                CallChecker.isCalled(minRatioPositions, List.class, 163, 6941, 6957).add(i);
                            }
                        }
                    
                }
            }
            if (CallChecker.beforeDeref(minRatioPositions, List.class, 168, 7022, 7038)) {
                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 168, 7022, 7038);
                if ((CallChecker.isCalled(minRatioPositions, List.class, 168, 7022, 7038).size()) == 0) {
                    return null;
                }else
                    if (CallChecker.beforeDeref(minRatioPositions, List.class, 170, 7099, 7115)) {
                        minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 170, 7099, 7115);
                        if ((CallChecker.isCalled(minRatioPositions, List.class, 170, 7099, 7115).size()) > 1) {
                            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 174, 7326, 7332)) {
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 174, 7326, 7332);
                                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 174, 7326, 7332).getNumArtificialVariables()) > 0) {
                                    if (CallChecker.beforeDeref(minRatioPositions, Integer.class, 175, 7404, 7420)) {
                                        for (Integer row : minRatioPositions) {
                                            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 176, 7465, 7471);
                                            for (int i = 0; i < (CallChecker.isCalled(tableau, SimplexTableau.class, 176, 7465, 7471).getNumArtificialVariables()); i++) {
                                                int column = CallChecker.init(int.class);
                                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 177, 7550, 7556)) {
                                                    tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 177, 7550, 7556);
                                                    column = i + (CallChecker.isCalled(tableau, SimplexTableau.class, 177, 7550, 7556).getArtificialVariableOffset());
                                                    CallChecker.varAssign(column, "column", 177, 7550, 7556);
                                                }
                                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 178, 7634, 7640);
                                                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 178, 7634, 7640).getEntry(row, column))), "entry", 178, 7613, 7663);
                                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 179, 7744, 7750)) {
                                                    if (CallChecker.beforeDeref(row, Integer.class, 179, 7733, 7735)) {
                                                        tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 179, 7744, 7750);
                                                        if ((Precision.equals(entry, 1.0, maxUlps)) && (CallChecker.isCalled(row, Integer.class, 179, 7733, 7735).equals(CallChecker.isCalled(tableau, SimplexTableau.class, 179, 7744, 7750).getBasicRow(column)))) {
                                                            return row;
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if ((getEvaluations()) < ((getMaxEvaluations()) / 2)) {
                                Integer minRow = CallChecker.varInit(null, "minRow", 196, 8619, 8640);
                                int minIndex = CallChecker.init(int.class);
                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 197, 8673, 8679)) {
                                    tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 197, 8673, 8679);
                                    minIndex = CallChecker.isCalled(tableau, SimplexTableau.class, 197, 8673, 8679).getWidth();
                                    CallChecker.varAssign(minIndex, "minIndex", 197, 8673, 8679);
                                }
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 198, 8730, 8736);
                                final int varStart = CallChecker.varInit(((int) (CallChecker.isCalled(tableau, SimplexTableau.class, 198, 8730, 8736).getNumObjectiveFunctions())), "varStart", 198, 8709, 8764);
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 199, 8801, 8807);
                                final int varEnd = CallChecker.varInit(((int) ((CallChecker.isCalled(tableau, SimplexTableau.class, 199, 8801, 8807).getWidth()) - 1)), "varEnd", 199, 8782, 8823);
                                if (CallChecker.beforeDeref(minRatioPositions, Integer.class, 200, 8860, 8876)) {
                                    for (Integer row : minRatioPositions) {
                                        for (int i = varStart; (i < varEnd) && (!(CallChecker.isCalled(row, Integer.class, 201, 8939, 8941).equals(minRow))); i++) {
                                            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 202, 9015, 9021);
                                            final Integer basicRow = CallChecker.varInit(CallChecker.isCalled(tableau, SimplexTableau.class, 202, 9015, 9021).getBasicRow(i), "basicRow", 202, 8990, 9037);
                                            if (((basicRow != null) && (basicRow.equals(row))) && (i < minIndex)) {
                                                minIndex = i;
                                                CallChecker.varAssign(minIndex, "minIndex", 204, 9155, 9167);
                                                minRow = row;
                                                CallChecker.varAssign(minRow, "minRow", 205, 9197, 9209);
                                            }
                                        }
                                    }
                                }
                                return minRow;
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(minRatioPositions, List.class, 212, 9347, 9363)) {
                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 212, 9347, 9363);
                return CallChecker.isCalled(minRatioPositions, List.class, 212, 9347, 9363).get(0);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1824.methodEnd();
        }
    }

    protected void doIteration(final SimplexTableau tableau) throws TooManyIterationsException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1825 = new MethodContext(void.class, 222, 9384, 10561);
        try {
            CallChecker.varInit(this, "this", 222, 9384, 10561);
            CallChecker.varInit(tableau, "tableau", 222, 9384, 10561);
            CallChecker.varInit(this.iterations, "iterations", 222, 9384, 10561);
            CallChecker.varInit(this.evaluations, "evaluations", 222, 9384, 10561);
            CallChecker.varInit(this.cutOff, "cutOff", 222, 9384, 10561);
            CallChecker.varInit(this.maxUlps, "maxUlps", 222, 9384, 10561);
            CallChecker.varInit(this.epsilon, "epsilon", 222, 9384, 10561);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_EPSILON", 222, 9384, 10561);
            CallChecker.varInit(DEFAULT_CUT_OFF, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_CUT_OFF", 222, 9384, 10561);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_ULPS", 222, 9384, 10561);
            incrementIterationCount();
            Integer pivotCol = CallChecker.varInit(getPivotColumn(tableau), "pivotCol", 228, 9912, 9954);
            Integer pivotRow = CallChecker.varInit(getPivotRow(tableau, pivotCol), "pivotRow", 229, 9964, 10013);
            if (pivotRow == null) {
                throw new UnboundedSolutionException();
            }
            double pivotVal = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 235, 10174, 10180)) {
                pivotVal = CallChecker.isCalled(tableau, SimplexTableau.class, 235, 10174, 10180).getEntry(pivotRow, pivotCol);
                CallChecker.varAssign(pivotVal, "pivotVal", 235, 10174, 10180);
            }
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 236, 10220, 10226)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 236, 10220, 10226).divideRow(pivotRow, pivotVal);
            }
            for (int i = 0; i < (CallChecker.isCalled(tableau, SimplexTableau.class, 239, 10337, 10343).getHeight()); i++) {
                if (i != pivotRow) {
                    final double multiplier = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 241, 10440, 10446).getEntry(i, pivotCol))), "multiplier", 241, 10414, 10469);
                    if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 242, 10487, 10493)) {
                        CallChecker.isCalled(tableau, SimplexTableau.class, 242, 10487, 10493).subtractRow(i, pivotRow, multiplier);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1825.methodEnd();
        }
    }

    protected void solvePhase1(final SimplexTableau tableau) throws TooManyIterationsException, NoFeasibleSolutionException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1826 = new MethodContext(void.class, 255, 10568, 11579);
        try {
            CallChecker.varInit(this, "this", 255, 10568, 11579);
            CallChecker.varInit(tableau, "tableau", 255, 10568, 11579);
            CallChecker.varInit(this.iterations, "iterations", 255, 10568, 11579);
            CallChecker.varInit(this.evaluations, "evaluations", 255, 10568, 11579);
            CallChecker.varInit(this.cutOff, "cutOff", 255, 10568, 11579);
            CallChecker.varInit(this.maxUlps, "maxUlps", 255, 10568, 11579);
            CallChecker.varInit(this.epsilon, "epsilon", 255, 10568, 11579);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_EPSILON", 255, 10568, 11579);
            CallChecker.varInit(DEFAULT_CUT_OFF, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_CUT_OFF", 255, 10568, 11579);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_ULPS", 255, 10568, 11579);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 261, 11200, 11206)) {
                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 261, 11200, 11206).getNumArtificialVariables()) == 0) {
                    return ;
                }
            }
            while (!(CallChecker.isCalled(tableau, SimplexTableau.class, 265, 11291, 11297).isOptimal())) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 270, 11471, 11477)) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 270, 11451, 11457)) {
                    if (!(Precision.equals(CallChecker.isCalled(tableau, SimplexTableau.class, 270, 11451, 11457).getEntry(0, CallChecker.isCalled(tableau, SimplexTableau.class, 270, 11471, 11477).getRhsOffset()), 0.0, epsilon))) {
                        throw new NoFeasibleSolutionException();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1826.methodEnd();
        }
    }

    @Override
    public PointValuePair doOptimize() throws TooManyIterationsException, NoFeasibleSolutionException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1827 = new MethodContext(PointValuePair.class, 277, 11586, 12347);
        try {
            CallChecker.varInit(this, "this", 277, 11586, 12347);
            CallChecker.varInit(this.iterations, "iterations", 277, 11586, 12347);
            CallChecker.varInit(this.evaluations, "evaluations", 277, 11586, 12347);
            CallChecker.varInit(this.cutOff, "cutOff", 277, 11586, 12347);
            CallChecker.varInit(this.maxUlps, "maxUlps", 277, 11586, 12347);
            CallChecker.varInit(this.epsilon, "epsilon", 277, 11586, 12347);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_EPSILON", 277, 11586, 12347);
            CallChecker.varInit(DEFAULT_CUT_OFF, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_CUT_OFF", 277, 11586, 12347);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optim.linear.SimplexSolver.DEFAULT_ULPS", 277, 11586, 12347);
            final SimplexTableau tableau = CallChecker.varInit(new SimplexTableau(getFunction(), getConstraints(), getGoalType(), isRestrictedToNonNegative(), epsilon, maxUlps, cutOff), "tableau", 281, 11799, 12149);
            solvePhase1(tableau);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 291, 12190, 12196)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 291, 12190, 12196).dropPhase1Objective();
            }
            while (!(CallChecker.isCalled(tableau, SimplexTableau.class, 293, 12238, 12244).isOptimal())) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 296, 12320, 12326)) {
                return CallChecker.isCalled(tableau, SimplexTableau.class, 296, 12320, 12326).getSolution();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1827.methodEnd();
        }
    }
}

