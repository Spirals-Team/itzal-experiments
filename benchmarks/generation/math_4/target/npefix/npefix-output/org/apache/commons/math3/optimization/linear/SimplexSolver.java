package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.Precision;

@Deprecated
public class SimplexSolver extends AbstractLinearOptimizer {
    private static final double DEFAULT_EPSILON = 1.0E-6;

    private static final int DEFAULT_ULPS = 10;

    private final double epsilon;

    private final int maxUlps;

    public SimplexSolver() {
        this(SimplexSolver.DEFAULT_EPSILON, SimplexSolver.DEFAULT_ULPS);
        ConstructorContext _bcornu_methode_context427 = new ConstructorContext(SimplexSolver.class, 53, 1798, 1941);
        try {
        } finally {
            _bcornu_methode_context427.methodEnd();
        }
    }

    public SimplexSolver(final double epsilon, final int maxUlps) {
        ConstructorContext _bcornu_methode_context428 = new ConstructorContext(SimplexSolver.class, 62, 1948, 2324);
        try {
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 63, 2264, 2286);
            this.maxUlps = maxUlps;
            CallChecker.varAssign(this.maxUlps, "this.maxUlps", 64, 2296, 2318);
        } finally {
            _bcornu_methode_context428.methodEnd();
        }
    }

    private Integer getPivotColumn(SimplexTableau tableau) {
        MethodContext _bcornu_methode_context1818 = new MethodContext(Integer.class, 72, 2331, 3089);
        try {
            CallChecker.varInit(this, "this", 72, 2331, 3089);
            CallChecker.varInit(tableau, "tableau", 72, 2331, 3089);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 72, 2331, 3089);
            CallChecker.varInit(this.maxUlps, "maxUlps", 72, 2331, 3089);
            CallChecker.varInit(this.epsilon, "epsilon", 72, 2331, 3089);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_ULPS", 72, 2331, 3089);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 72, 2331, 3089);
            double minValue = CallChecker.varInit(((double) (0)), "minValue", 73, 2614, 2633);
            Integer minPos = CallChecker.varInit(null, "minPos", 74, 2643, 2664);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 75, 2687, 2693);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 75, 2727, 2733);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 75, 2687, 2693).getNumObjectiveFunctions(); i < ((CallChecker.isCalled(tableau, SimplexTableau.class, 75, 2727, 2733).getWidth()) - 1); i++) {
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 76, 2791, 2797);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 76, 2791, 2797).getEntry(0, i))), "entry", 76, 2770, 2813);
                if (entry < minValue) {
                    minValue = entry;
                    CallChecker.varAssign(minValue, "minValue", 80, 2992, 3008);
                    minPos = i;
                    CallChecker.varAssign(minPos, "minPos", 81, 3026, 3036);
                }
            }
            return minPos;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1818.methodEnd();
        }
    }

    private Integer getPivotRow(SimplexTableau tableau, final int col) {
        MethodContext _bcornu_methode_context1819 = new MethodContext(Integer.class, 93, 3096, 6877);
        try {
            CallChecker.varInit(this, "this", 93, 3096, 6877);
            CallChecker.varInit(col, "col", 93, 3096, 6877);
            CallChecker.varInit(tableau, "tableau", 93, 3096, 6877);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 93, 3096, 6877);
            CallChecker.varInit(this.maxUlps, "maxUlps", 93, 3096, 6877);
            CallChecker.varInit(this.epsilon, "epsilon", 93, 3096, 6877);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_ULPS", 93, 3096, 6877);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 93, 3096, 6877);
            List<Integer> minRatioPositions = CallChecker.varInit(new ArrayList<Integer>(), "minRatioPositions", 95, 3565, 3623);
            double minRatio = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minRatio", 96, 3633, 3667);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 97, 3690, 3696);
            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 97, 3730, 3736);
            for (int i = CallChecker.isCalled(tableau, SimplexTableau.class, 97, 3690, 3696).getNumObjectiveFunctions(); i < (CallChecker.isCalled(tableau, SimplexTableau.class, 97, 3730, 3736).getHeight()); i++) {
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 98, 3809, 3815);
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 98, 3789, 3795);
                final double rhs = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 98, 3789, 3795).getEntry(i, ((CallChecker.isCalled(tableau, SimplexTableau.class, 98, 3809, 3815).getWidth()) - 1)))), "rhs", 98, 3770, 3832);
                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 99, 3867, 3873);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 99, 3867, 3873).getEntry(i, col))), "entry", 99, 3846, 3891);
                if ((Precision.compareTo(entry, 0.0, maxUlps)) > 0) {
                    final double ratio = CallChecker.varInit(((double) (rhs / entry)), "ratio", 102, 3973, 4005);
                    final int cmp = CallChecker.varInit(((int) (Double.compare(ratio, minRatio))), "cmp", 105, 4023, 4201);
                    if (cmp == 0) {
                        if (CallChecker.beforeDeref(minRatioPositions, List.class, 107, 4255, 4271)) {
                            minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 107, 4255, 4271);
                            CallChecker.isCalled(minRatioPositions, List.class, 107, 4255, 4271).add(i);
                        }
                    }else
                        if (cmp < 0) {
                            minRatio = ratio;
                            CallChecker.varAssign(minRatio, "minRatio", 109, 4339, 4355);
                            minRatioPositions = new ArrayList<Integer>();
                            CallChecker.varAssign(minRatioPositions, "minRatioPositions", 110, 4377, 4421);
                            if (CallChecker.beforeDeref(minRatioPositions, List.class, 111, 4443, 4459)) {
                                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 111, 4443, 4459);
                                CallChecker.isCalled(minRatioPositions, List.class, 111, 4443, 4459).add(i);
                            }
                        }
                    
                }
            }
            if (CallChecker.beforeDeref(minRatioPositions, List.class, 116, 4524, 4540)) {
                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 116, 4524, 4540);
                if ((CallChecker.isCalled(minRatioPositions, List.class, 116, 4524, 4540).size()) == 0) {
                    return null;
                }else
                    if (CallChecker.beforeDeref(minRatioPositions, List.class, 118, 4601, 4617)) {
                        minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 118, 4601, 4617);
                        if ((CallChecker.isCalled(minRatioPositions, List.class, 118, 4601, 4617).size()) > 1) {
                            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 122, 4828, 4834)) {
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 122, 4828, 4834);
                                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 122, 4828, 4834).getNumArtificialVariables()) > 0) {
                                    if (CallChecker.beforeDeref(minRatioPositions, Integer.class, 123, 4906, 4922)) {
                                        for (Integer row : minRatioPositions) {
                                            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 124, 4967, 4973);
                                            for (int i = 0; i < (CallChecker.isCalled(tableau, SimplexTableau.class, 124, 4967, 4973).getNumArtificialVariables()); i++) {
                                                int column = CallChecker.init(int.class);
                                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 125, 5052, 5058)) {
                                                    tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 125, 5052, 5058);
                                                    column = i + (CallChecker.isCalled(tableau, SimplexTableau.class, 125, 5052, 5058).getArtificialVariableOffset());
                                                    CallChecker.varAssign(column, "column", 125, 5052, 5058);
                                                }
                                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 126, 5136, 5142);
                                                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 126, 5136, 5142).getEntry(row, column))), "entry", 126, 5115, 5165);
                                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 127, 5246, 5252)) {
                                                    if (CallChecker.beforeDeref(row, Integer.class, 127, 5235, 5237)) {
                                                        tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 127, 5246, 5252);
                                                        if ((Precision.equals(entry, 1.0, maxUlps)) && (CallChecker.isCalled(row, Integer.class, 127, 5235, 5237).equals(CallChecker.isCalled(tableau, SimplexTableau.class, 127, 5246, 5252).getBasicRow(column)))) {
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
                            
                            if ((getIterations()) < ((getMaxIterations()) / 2)) {
                                Integer minRow = CallChecker.varInit(null, "minRow", 144, 6119, 6140);
                                int minIndex = CallChecker.init(int.class);
                                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 145, 6173, 6179)) {
                                    tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 145, 6173, 6179);
                                    minIndex = CallChecker.isCalled(tableau, SimplexTableau.class, 145, 6173, 6179).getWidth();
                                    CallChecker.varAssign(minIndex, "minIndex", 145, 6173, 6179);
                                }
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 146, 6230, 6236);
                                final int varStart = CallChecker.varInit(((int) (CallChecker.isCalled(tableau, SimplexTableau.class, 146, 6230, 6236).getNumObjectiveFunctions())), "varStart", 146, 6209, 6264);
                                tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 147, 6301, 6307);
                                final int varEnd = CallChecker.varInit(((int) ((CallChecker.isCalled(tableau, SimplexTableau.class, 147, 6301, 6307).getWidth()) - 1)), "varEnd", 147, 6282, 6323);
                                if (CallChecker.beforeDeref(minRatioPositions, Integer.class, 148, 6360, 6376)) {
                                    for (Integer row : minRatioPositions) {
                                        for (int i = varStart; (i < varEnd) && (!(CallChecker.isCalled(row, Integer.class, 149, 6439, 6441).equals(minRow))); i++) {
                                            tableau = CallChecker.beforeCalled(tableau, SimplexTableau.class, 150, 6515, 6521);
                                            final Integer basicRow = CallChecker.varInit(CallChecker.isCalled(tableau, SimplexTableau.class, 150, 6515, 6521).getBasicRow(i), "basicRow", 150, 6490, 6537);
                                            if (((basicRow != null) && (basicRow.equals(row))) && (i < minIndex)) {
                                                minIndex = i;
                                                CallChecker.varAssign(minIndex, "minIndex", 152, 6655, 6667);
                                                minRow = row;
                                                CallChecker.varAssign(minRow, "minRow", 153, 6697, 6709);
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
            
            if (CallChecker.beforeDeref(minRatioPositions, List.class, 160, 6847, 6863)) {
                minRatioPositions = CallChecker.beforeCalled(minRatioPositions, List.class, 160, 6847, 6863);
                return CallChecker.isCalled(minRatioPositions, List.class, 160, 6847, 6863).get(0);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1819.methodEnd();
        }
    }

    protected void doIteration(final SimplexTableau tableau) throws MaxCountExceededException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1820 = new MethodContext(void.class, 169, 6884, 8031);
        try {
            CallChecker.varInit(this, "this", 169, 6884, 8031);
            CallChecker.varInit(tableau, "tableau", 169, 6884, 8031);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 169, 6884, 8031);
            CallChecker.varInit(this.maxUlps, "maxUlps", 169, 6884, 8031);
            CallChecker.varInit(this.epsilon, "epsilon", 169, 6884, 8031);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_ULPS", 169, 6884, 8031);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 169, 6884, 8031);
            incrementIterationsCounter();
            Integer pivotCol = CallChecker.varInit(getPivotColumn(tableau), "pivotCol", 174, 7382, 7424);
            Integer pivotRow = CallChecker.varInit(getPivotRow(tableau, pivotCol), "pivotRow", 175, 7434, 7483);
            if (pivotRow == null) {
                throw new UnboundedSolutionException();
            }
            double pivotVal = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 181, 7644, 7650)) {
                pivotVal = CallChecker.isCalled(tableau, SimplexTableau.class, 181, 7644, 7650).getEntry(pivotRow, pivotCol);
                CallChecker.varAssign(pivotVal, "pivotVal", 181, 7644, 7650);
            }
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 182, 7690, 7696)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 182, 7690, 7696).divideRow(pivotRow, pivotVal);
            }
            for (int i = 0; i < (CallChecker.isCalled(tableau, SimplexTableau.class, 185, 7807, 7813).getHeight()); i++) {
                if (i != pivotRow) {
                    final double multiplier = CallChecker.varInit(((double) (CallChecker.isCalled(tableau, SimplexTableau.class, 187, 7910, 7916).getEntry(i, pivotCol))), "multiplier", 187, 7884, 7939);
                    if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 188, 7957, 7963)) {
                        CallChecker.isCalled(tableau, SimplexTableau.class, 188, 7957, 7963).subtractRow(i, pivotRow, multiplier);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1820.methodEnd();
        }
    }

    protected void solvePhase1(final SimplexTableau tableau) throws MaxCountExceededException, NoFeasibleSolutionException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1821 = new MethodContext(void.class, 200, 8038, 9000);
        try {
            CallChecker.varInit(this, "this", 200, 8038, 9000);
            CallChecker.varInit(tableau, "tableau", 200, 8038, 9000);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 200, 8038, 9000);
            CallChecker.varInit(this.maxUlps, "maxUlps", 200, 8038, 9000);
            CallChecker.varInit(this.epsilon, "epsilon", 200, 8038, 9000);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_ULPS", 200, 8038, 9000);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 200, 8038, 9000);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 204, 8621, 8627)) {
                if ((CallChecker.isCalled(tableau, SimplexTableau.class, 204, 8621, 8627).getNumArtificialVariables()) == 0) {
                    return ;
                }
            }
            while (!(CallChecker.isCalled(tableau, SimplexTableau.class, 208, 8712, 8718).isOptimal())) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 213, 8892, 8898)) {
                if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 213, 8872, 8878)) {
                    if (!(Precision.equals(CallChecker.isCalled(tableau, SimplexTableau.class, 213, 8872, 8878).getEntry(0, CallChecker.isCalled(tableau, SimplexTableau.class, 213, 8892, 8898).getRhsOffset()), 0.0, epsilon))) {
                        throw new NoFeasibleSolutionException();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1821.methodEnd();
        }
    }

    @Override
    public PointValuePair doOptimize() throws MaxCountExceededException, NoFeasibleSolutionException, UnboundedSolutionException {
        MethodContext _bcornu_methode_context1822 = new MethodContext(PointValuePair.class, 220, 9007, 9694);
        try {
            CallChecker.varInit(this, "this", 220, 9007, 9694);
            CallChecker.varInit(AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS, "org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer.DEFAULT_MAX_ITERATIONS", 220, 9007, 9694);
            CallChecker.varInit(this.maxUlps, "maxUlps", 220, 9007, 9694);
            CallChecker.varInit(this.epsilon, "epsilon", 220, 9007, 9694);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_ULPS", 220, 9007, 9694);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.optimization.linear.SimplexSolver.DEFAULT_EPSILON", 220, 9007, 9694);
            final SimplexTableau tableau = CallChecker.varInit(new SimplexTableau(getFunction(), getConstraints(), getGoalType(), restrictToNonNegative(), epsilon, maxUlps), "tableau", 222, 9189, 9496);
            solvePhase1(tableau);
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 231, 9537, 9543)) {
                CallChecker.isCalled(tableau, SimplexTableau.class, 231, 9537, 9543).dropPhase1Objective();
            }
            while (!(CallChecker.isCalled(tableau, SimplexTableau.class, 233, 9585, 9591).isOptimal())) {
                doIteration(tableau);
            } 
            if (CallChecker.beforeDeref(tableau, SimplexTableau.class, 236, 9667, 9673)) {
                return CallChecker.isCalled(tableau, SimplexTableau.class, 236, 9667, 9673).getSolution();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1822.methodEnd();
        }
    }
}

