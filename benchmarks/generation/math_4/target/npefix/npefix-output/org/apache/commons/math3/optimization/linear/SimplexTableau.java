package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

class SimplexTableau implements Serializable {
    private static final String NEGATIVE_VAR_COLUMN_LABEL = "x-";

    private static final int DEFAULT_ULPS = 10;

    private static final double CUTOFF_THRESHOLD = 1.0E-12;

    private static final long serialVersionUID = -1369660067587938365L;

    private final LinearObjectiveFunction f;

    private final List<LinearConstraint> constraints;

    private final boolean restrictToNonNegative;

    private final List<String> columnLabels = new ArrayList<String>();

    private transient RealMatrix tableau;

    private final int numDecisionVariables;

    private final int numSlackVariables;

    private int numArtificialVariables;

    private final double epsilon;

    private final int maxUlps;

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon) {
        this(f, constraints, goalType, restrictToNonNegative, epsilon, SimplexTableau.DEFAULT_ULPS);
        ConstructorContext _bcornu_methode_context51 = new ConstructorContext(SimplexTableau.class, 118, 3982, 4741);
        try {
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon, final int maxUlps) {
        ConstructorContext _bcornu_methode_context52 = new ConstructorContext(SimplexTableau.class, 134, 4748, 6380);
        try {
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 139, 5541, 5572);
            this.constraints = normalizeConstraints(constraints);
            CallChecker.varAssign(this.constraints, "this.constraints", 140, 5582, 5645);
            this.restrictToNonNegative = restrictToNonNegative;
            CallChecker.varAssign(this.restrictToNonNegative, "this.restrictToNonNegative", 141, 5655, 5706);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 142, 5716, 5753);
            this.maxUlps = maxUlps;
            CallChecker.varAssign(this.maxUlps, "this.maxUlps", 143, 5763, 5800);
            if (restrictToNonNegative) {
                this.numDecisionVariables = (CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 144, 5840, 5840).getCoefficients(), RealVector.class, 144, 5840, 5858).getDimension()) + 0;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 144, 5810, 5946);
            }else {
                this.numDecisionVariables = (CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 144, 5840, 5840).getCoefficients(), RealVector.class, 144, 5840, 5858).getDimension()) + 1;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 144, 5810, 5946);
            }
            this.numSlackVariables = (getConstraintTypeCounts(Relationship.LEQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numSlackVariables, "this.numSlackVariables", 146, 5956, 6109);
            this.numArtificialVariables = (getConstraintTypeCounts(Relationship.EQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 148, 6119, 6271);
            this.tableau = createTableau((goalType == (GoalType.MAXIMIZE)));
            CallChecker.varAssign(this.tableau, "this.tableau", 150, 6281, 6340);
            initializeColumnLabels();
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    protected void initializeColumnLabels() {
        MethodContext _bcornu_methode_context167 = new MethodContext(void.class, 157, 6387, 7052);
        try {
            CallChecker.varInit(this, "this", 157, 6387, 7052);
            CallChecker.varInit(this.maxUlps, "maxUlps", 157, 6387, 7052);
            CallChecker.varInit(this.epsilon, "epsilon", 157, 6387, 7052);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 157, 6387, 7052);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 157, 6387, 7052);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 157, 6387, 7052);
            CallChecker.varInit(this.tableau, "tableau", 157, 6387, 7052);
            CallChecker.varInit(this.columnLabels, "columnLabels", 157, 6387, 7052);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 157, 6387, 7052);
            CallChecker.varInit(this.constraints, "constraints", 157, 6387, 7052);
            CallChecker.varInit(this.f, "f", 157, 6387, 7052);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 157, 6387, 7052);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 157, 6387, 7052);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 157, 6387, 7052);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 157, 6387, 7052);
            if ((getNumObjectiveFunctions()) == 2) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 159, 6544, 6555)) {
                    CallChecker.isCalled(columnLabels, List.class, 159, 6544, 6555).add("W");
                }
            }
            if (CallChecker.beforeDeref(columnLabels, List.class, 161, 6581, 6592)) {
                CallChecker.isCalled(columnLabels, List.class, 161, 6581, 6592).add("Z");
            }
            for (int i = 0; i < (getOriginalNumDecisionVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 163, 6680, 6691)) {
                    CallChecker.isCalled(columnLabels, List.class, 163, 6680, 6691).add(("x" + i));
                }
            }
            if (!(restrictToNonNegative)) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 166, 6759, 6770)) {
                    CallChecker.isCalled(columnLabels, List.class, 166, 6759, 6770).add(SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL);
                }
            }
            for (int i = 0; i < (getNumSlackVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 169, 6877, 6888)) {
                    CallChecker.isCalled(columnLabels, List.class, 169, 6877, 6888).add(("s" + i));
                }
            }
            for (int i = 0; i < (getNumArtificialVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 172, 6982, 6993)) {
                    CallChecker.isCalled(columnLabels, List.class, 172, 6982, 6993).add(("a" + i));
                }
            }
            if (CallChecker.beforeDeref(columnLabels, List.class, 174, 7023, 7034)) {
                CallChecker.isCalled(columnLabels, List.class, 174, 7023, 7034).add("RHS");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    protected RealMatrix createTableau(final boolean maximize) {
        MethodContext _bcornu_methode_context168 = new MethodContext(RealMatrix.class, 182, 7059, 9988);
        try {
            CallChecker.varInit(this, "this", 182, 7059, 9988);
            CallChecker.varInit(maximize, "maximize", 182, 7059, 9988);
            CallChecker.varInit(this.maxUlps, "maxUlps", 182, 7059, 9988);
            CallChecker.varInit(this.epsilon, "epsilon", 182, 7059, 9988);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 182, 7059, 9988);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 182, 7059, 9988);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 182, 7059, 9988);
            CallChecker.varInit(this.tableau, "tableau", 182, 7059, 9988);
            CallChecker.varInit(this.columnLabels, "columnLabels", 182, 7059, 9988);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 182, 7059, 9988);
            CallChecker.varInit(this.constraints, "constraints", 182, 7059, 9988);
            CallChecker.varInit(this.f, "f", 182, 7059, 9988);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 182, 7059, 9988);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 182, 7059, 9988);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 182, 7059, 9988);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 182, 7059, 9988);
            int width = CallChecker.varInit(((int) (((((this.numDecisionVariables) + (this.numSlackVariables)) + (this.numArtificialVariables)) + (getNumObjectiveFunctions())) + 1)), "width", 185, 7335, 7453);
            int height = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(constraints, List.class, 187, 7494, 7504)) {
                height = (CallChecker.isCalled(constraints, List.class, 187, 7494, 7504).size()) + (getNumObjectiveFunctions());
                CallChecker.varAssign(height, "height", 187, 7494, 7504);
            }
            Array2DRowRealMatrix matrix = CallChecker.varInit(new Array2DRowRealMatrix(height, width), "matrix", 188, 7551, 7620);
            if ((getNumObjectiveFunctions()) == 2) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 192, 7732, 7737)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 192, 7732, 7737);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 192, 7732, 7737).setEntry(0, 0, (-1));
                }
            }
            int zIndex = CallChecker.init(int.class);
            if ((getNumObjectiveFunctions()) == 1) {
                zIndex = 0;
                CallChecker.varAssign(zIndex, "zIndex", 194, 7790, 7830);
            }else {
                zIndex = 1;
                CallChecker.varAssign(zIndex, "zIndex", 194, 7790, 7830);
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846).setEntry(zIndex, zIndex, 1);
                }
            }else {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 195, 7841, 7846).setEntry(zIndex, zIndex, (-1));
                }
            }
            RealVector objectiveCoefficients = CallChecker.init(RealVector.class);
            if (maximize) {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 197, 7959, 7959)) {
                    final RealVector npe_invocation_var11 = CallChecker.isCalled(f, LinearObjectiveFunction.class, 197, 7959, 7959).getCoefficients();
                    if (CallChecker.beforeDeref(npe_invocation_var11, RealVector.class, 197, 7959, 7977)) {
                        objectiveCoefficients = CallChecker.isCalled(npe_invocation_var11, RealVector.class, 197, 7959, 7977).mapMultiply((-1));
                        CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 197, 7948, 8015);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 197, 7997, 7997)) {
                    objectiveCoefficients = CallChecker.isCalled(f, LinearObjectiveFunction.class, 197, 7997, 7997).getCoefficients();
                    CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 197, 7948, 8015);
                }
            }
            if (CallChecker.beforeDeref(objectiveCoefficients, RealVector.class, 198, 8036, 8056)) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 198, 8069, 8074)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 198, 8069, 8074);
                    final double[][] npe_invocation_var12 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 198, 8069, 8074).getDataRef();
                    if (CallChecker.beforeDeref(npe_invocation_var12, double[][].class, 198, 8069, 8087)) {
                        objectiveCoefficients = CallChecker.beforeCalled(objectiveCoefficients, RealVector.class, 198, 8036, 8056);
                        copyArray(CallChecker.isCalled(objectiveCoefficients, RealVector.class, 198, 8036, 8056).toArray(), CallChecker.isCalled(npe_invocation_var12, double[][].class, 198, 8069, 8087)[zIndex]);
                    }
                }
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112).setEntry(zIndex, (width - 1), CallChecker.isCalled(f, LinearObjectiveFunction.class, 200, 8165, 8165).getConstantTerm());
                }
            }else {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 199, 8107, 8112).setEntry(zIndex, (width - 1), ((-1) * (CallChecker.isCalled(f, LinearObjectiveFunction.class, 200, 8192, 8192).getConstantTerm())));
                }
            }
            if (!(restrictToNonNegative)) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 203, 8265, 8270)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 203, 8265, 8270);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 203, 8265, 8270).setEntry(zIndex, ((getSlackVariableOffset()) - 1), SimplexTableau.getInvertedCoefficientSum(objectiveCoefficients));
                }
            }
            int slackVar = CallChecker.varInit(((int) (0)), "slackVar", 208, 8447, 8463);
            int artificialVar = CallChecker.varInit(((int) (0)), "artificialVar", 209, 8473, 8494);
            for (int i = 0; i < (CallChecker.isCalled(constraints, List.class, 210, 8524, 8534).size()); i++) {
                LinearConstraint constraint = CallChecker.init(LinearConstraint.class);
                if (CallChecker.beforeDeref(constraints, List.class, 211, 8593, 8603)) {
                    constraint = CallChecker.isCalled(constraints, List.class, 211, 8593, 8603).get(i);
                    CallChecker.varAssign(constraint, "constraint", 211, 8593, 8603);
                }
                int row = CallChecker.varInit(((int) ((getNumObjectiveFunctions()) + i)), "row", 212, 8625, 8665);
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 215, 8736, 8745)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 215, 8736, 8745);
                    final RealVector npe_invocation_var13 = CallChecker.isCalled(constraint, LinearConstraint.class, 215, 8736, 8745).getCoefficients();
                    if (CallChecker.beforeDeref(npe_invocation_var13, RealVector.class, 215, 8736, 8763)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 215, 8776, 8781)) {
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 215, 8776, 8781);
                            final double[][] npe_invocation_var14 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 215, 8776, 8781).getDataRef();
                            if (CallChecker.beforeDeref(npe_invocation_var14, double[][].class, 215, 8776, 8794)) {
                                copyArray(CallChecker.isCalled(npe_invocation_var13, RealVector.class, 215, 8736, 8763).toArray(), CallChecker.isCalled(npe_invocation_var14, double[][].class, 215, 8776, 8794)[row]);
                            }
                        }
                    }
                }
                if (!(restrictToNonNegative)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 220, 8977, 8986)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 219, 8880, 8885)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 220, 8977, 8986);
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 219, 8880, 8885);
                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 219, 8880, 8885).setEntry(row, ((getSlackVariableOffset()) - 1), SimplexTableau.getInvertedCoefficientSum(CallChecker.isCalled(constraint, LinearConstraint.class, 220, 8977, 8986).getCoefficients()));
                        }
                    }
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 224, 9087, 9096)) {
                    if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 224, 9055, 9060)) {
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 224, 9087, 9096);
                        matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 224, 9055, 9060);
                        CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 224, 9055, 9060).setEntry(row, (width - 1), CallChecker.isCalled(constraint, LinearConstraint.class, 224, 9087, 9096).getValue());
                    }
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 227, 9159, 9168)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 227, 9159, 9168);
                    if ((CallChecker.isCalled(constraint, LinearConstraint.class, 227, 9159, 9168).getRelationship()) == (Relationship.LEQ)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 228, 9227, 9232)) {
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 228, 9227, 9232);
                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 228, 9227, 9232).setEntry(row, ((getSlackVariableOffset()) + (slackVar++)), 1);
                        }
                    }else
                        if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 229, 9324, 9333)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 229, 9324, 9333);
                            if ((CallChecker.isCalled(constraint, LinearConstraint.class, 229, 9324, 9333).getRelationship()) == (Relationship.GEQ)) {
                                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 230, 9392, 9397)) {
                                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 230, 9392, 9397);
                                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 230, 9392, 9397).setEntry(row, ((getSlackVariableOffset()) + (slackVar++)), (-1));
                                }
                            }
                        }
                    
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 234, 9535, 9544)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 235, 9608, 9617)) {
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 234, 9535, 9544);
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 235, 9608, 9617);
                        if (((CallChecker.isCalled(constraint, LinearConstraint.class, 234, 9535, 9544).getRelationship()) == (Relationship.EQ)) || ((CallChecker.isCalled(constraint, LinearConstraint.class, 235, 9608, 9617).getRelationship()) == (Relationship.GEQ))) {
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 236, 9677, 9682)) {
                                matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 236, 9677, 9682);
                                CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 236, 9677, 9682).setEntry(0, ((getArtificialVariableOffset()) + artificialVar), 1);
                            }
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 237, 9763, 9768)) {
                                matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 237, 9763, 9768);
                                CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 237, 9763, 9768).setEntry(row, ((getArtificialVariableOffset()) + (artificialVar++)), 1);
                            }
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 238, 9876, 9881)) {
                                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 238, 9908, 9913)) {
                                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 238, 9876, 9881);
                                    final RealVector npe_invocation_var15 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 238, 9876, 9881).getRowVector(0);
                                    if (CallChecker.beforeDeref(npe_invocation_var15, RealVector.class, 238, 9876, 9897)) {
                                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 238, 9853, 9858)) {
                                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 238, 9908, 9913);
                                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 238, 9853, 9858);
                                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 238, 9853, 9858).setRowVector(0, CallChecker.isCalled(npe_invocation_var15, RealVector.class, 238, 9876, 9897).subtract(CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 238, 9908, 9913).getRowVector(row)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return matrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    public List<LinearConstraint> normalizeConstraints(Collection<LinearConstraint> originalConstraints) {
        MethodContext _bcornu_methode_context169 = new MethodContext(List.class, 250, 9995, 10551);
        try {
            CallChecker.varInit(this, "this", 250, 9995, 10551);
            CallChecker.varInit(originalConstraints, "originalConstraints", 250, 9995, 10551);
            CallChecker.varInit(this.maxUlps, "maxUlps", 250, 9995, 10551);
            CallChecker.varInit(this.epsilon, "epsilon", 250, 9995, 10551);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 250, 9995, 10551);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 250, 9995, 10551);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 250, 9995, 10551);
            CallChecker.varInit(this.tableau, "tableau", 250, 9995, 10551);
            CallChecker.varInit(this.columnLabels, "columnLabels", 250, 9995, 10551);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 250, 9995, 10551);
            CallChecker.varInit(this.constraints, "constraints", 250, 9995, 10551);
            CallChecker.varInit(this.f, "f", 250, 9995, 10551);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 250, 9995, 10551);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 250, 9995, 10551);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 250, 9995, 10551);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 250, 9995, 10551);
            List<LinearConstraint> normalized = CallChecker.varInit(new ArrayList<LinearConstraint>(), "normalized", 251, 10322, 10391);
            if (CallChecker.beforeDeref(originalConstraints, List.class, 252, 10436, 10454)) {
                for (LinearConstraint constraint : originalConstraints) {
                    if (CallChecker.beforeDeref(normalized, List.class, 253, 10471, 10480)) {
                        normalized = CallChecker.beforeCalled(normalized, List.class, 253, 10471, 10480);
                        CallChecker.isCalled(normalized, List.class, 253, 10471, 10480).add(normalize(constraint));
                    }
                }
            }
            return normalized;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    private LinearConstraint normalize(final LinearConstraint constraint) {
        MethodContext _bcornu_methode_context170 = new MethodContext(LinearConstraint.class, 263, 10558, 11261);
        try {
            CallChecker.varInit(this, "this", 263, 10558, 11261);
            CallChecker.varInit(constraint, "constraint", 263, 10558, 11261);
            CallChecker.varInit(this.maxUlps, "maxUlps", 263, 10558, 11261);
            CallChecker.varInit(this.epsilon, "epsilon", 263, 10558, 11261);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 263, 10558, 11261);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 263, 10558, 11261);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 263, 10558, 11261);
            CallChecker.varInit(this.tableau, "tableau", 263, 10558, 11261);
            CallChecker.varInit(this.columnLabels, "columnLabels", 263, 10558, 11261);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 263, 10558, 11261);
            CallChecker.varInit(this.constraints, "constraints", 263, 10558, 11261);
            CallChecker.varInit(this.f, "f", 263, 10558, 11261);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 263, 10558, 11261);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 263, 10558, 11261);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 263, 10558, 11261);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 263, 10558, 11261);
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 264, 10814, 10823)) {
                if ((CallChecker.isCalled(constraint, LinearConstraint.class, 264, 10814, 10823).getValue()) < 0) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 265, 10883, 10892)) {
                        final RealVector npe_invocation_var16 = CallChecker.isCalled(constraint, LinearConstraint.class, 265, 10883, 10892).getCoefficients();
                        if (CallChecker.beforeDeref(npe_invocation_var16, RealVector.class, 265, 10883, 10910)) {
                            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 266, 10969, 10978)) {
                                final Relationship npe_invocation_var17 = CallChecker.isCalled(constraint, LinearConstraint.class, 266, 10969, 10978).getRelationship();
                                if (CallChecker.beforeDeref(npe_invocation_var17, Relationship.class, 266, 10969, 10996)) {
                                    return new LinearConstraint(CallChecker.isCalled(npe_invocation_var16, RealVector.class, 265, 10883, 10910).mapMultiply((-1)), CallChecker.isCalled(npe_invocation_var17, Relationship.class, 266, 10969, 10996).oppositeRelationship(), ((-1) * (CallChecker.isCalled(constraint, LinearConstraint.class, 267, 11067, 11076).getValue())));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 269, 11137, 11146)) {
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 270, 11203, 11212)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 270, 11233, 11242)) {
                        return new LinearConstraint(CallChecker.isCalled(constraint, LinearConstraint.class, 269, 11137, 11146).getCoefficients(), CallChecker.isCalled(constraint, LinearConstraint.class, 270, 11203, 11212).getRelationship(), CallChecker.isCalled(constraint, LinearConstraint.class, 270, 11233, 11242).getValue());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinearConstraint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    protected final int getNumObjectiveFunctions() {
        MethodContext _bcornu_methode_context171 = new MethodContext(int.class, 277, 11268, 11501);
        try {
            CallChecker.varInit(this, "this", 277, 11268, 11501);
            CallChecker.varInit(this.maxUlps, "maxUlps", 277, 11268, 11501);
            CallChecker.varInit(this.epsilon, "epsilon", 277, 11268, 11501);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 277, 11268, 11501);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 277, 11268, 11501);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 277, 11268, 11501);
            CallChecker.varInit(this.tableau, "tableau", 277, 11268, 11501);
            CallChecker.varInit(this.columnLabels, "columnLabels", 277, 11268, 11501);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 277, 11268, 11501);
            CallChecker.varInit(this.constraints, "constraints", 277, 11268, 11501);
            CallChecker.varInit(this.f, "f", 277, 11268, 11501);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 277, 11268, 11501);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 277, 11268, 11501);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 277, 11268, 11501);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 277, 11268, 11501);
            if ((this.numArtificialVariables) > 0) {
                return 2;
            }else {
                return 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    private int getConstraintTypeCounts(final Relationship relationship) {
        MethodContext _bcornu_methode_context172 = new MethodContext(int.class, 286, 11508, 12015);
        try {
            CallChecker.varInit(this, "this", 286, 11508, 12015);
            CallChecker.varInit(relationship, "relationship", 286, 11508, 12015);
            CallChecker.varInit(this.maxUlps, "maxUlps", 286, 11508, 12015);
            CallChecker.varInit(this.epsilon, "epsilon", 286, 11508, 12015);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 286, 11508, 12015);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 286, 11508, 12015);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 286, 11508, 12015);
            CallChecker.varInit(this.tableau, "tableau", 286, 11508, 12015);
            CallChecker.varInit(this.columnLabels, "columnLabels", 286, 11508, 12015);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 286, 11508, 12015);
            CallChecker.varInit(this.constraints, "constraints", 286, 11508, 12015);
            CallChecker.varInit(this.f, "f", 286, 11508, 12015);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 286, 11508, 12015);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 286, 11508, 12015);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 286, 11508, 12015);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 286, 11508, 12015);
            int count = CallChecker.varInit(((int) (0)), "count", 287, 11797, 11810);
            if (CallChecker.beforeDeref(constraints, int.class, 288, 11861, 11871)) {
                for (final LinearConstraint constraint : constraints) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 289, 11892, 11901)) {
                        if ((CallChecker.isCalled(constraint, LinearConstraint.class, 289, 11892, 11901).getRelationship()) == relationship) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }

    protected static double getInvertedCoefficientSum(final RealVector coefficients) {
        MethodContext _bcornu_methode_context173 = new MethodContext(double.class, 301, 12022, 12466);
        try {
            CallChecker.varInit(coefficients, "coefficients", 301, 12022, 12466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 301, 12022, 12466);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 301, 12022, 12466);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 301, 12022, 12466);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 301, 12022, 12466);
            double sum = CallChecker.varInit(((double) (0)), "sum", 302, 12324, 12338);
            for (double coefficient : CallChecker.isCalled(coefficients, RealVector.class, 303, 12374, 12385).toArray()) {
                sum -= coefficient;
                CallChecker.varAssign(sum, "sum", 304, 12412, 12430);
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    protected Integer getBasicRow(final int col) {
        MethodContext _bcornu_methode_context174 = new MethodContext(Integer.class, 314, 12473, 13085);
        try {
            CallChecker.varInit(this, "this", 314, 12473, 13085);
            CallChecker.varInit(col, "col", 314, 12473, 13085);
            CallChecker.varInit(this.maxUlps, "maxUlps", 314, 12473, 13085);
            CallChecker.varInit(this.epsilon, "epsilon", 314, 12473, 13085);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 314, 12473, 13085);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 314, 12473, 13085);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 314, 12473, 13085);
            CallChecker.varInit(this.tableau, "tableau", 314, 12473, 13085);
            CallChecker.varInit(this.columnLabels, "columnLabels", 314, 12473, 13085);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 314, 12473, 13085);
            CallChecker.varInit(this.constraints, "constraints", 314, 12473, 13085);
            CallChecker.varInit(this.f, "f", 314, 12473, 13085);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 314, 12473, 13085);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 314, 12473, 13085);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 314, 12473, 13085);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 314, 12473, 13085);
            Integer row = CallChecker.varInit(null, "row", 315, 12727, 12745);
            for (int i = 0; i < (getHeight()); i++) {
                final double entry = CallChecker.varInit(((double) (getEntry(i, col))), "entry", 317, 12807, 12844);
                if ((Precision.equals(entry, 1.0, maxUlps)) && (row == null)) {
                    row = i;
                    CallChecker.varAssign(row, "row", 319, 12935, 12942);
                }else
                    if (!(Precision.equals(entry, 0.0, maxUlps))) {
                        return null;
                    }
                
            }
            return row;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    protected void dropPhase1Objective() {
        MethodContext _bcornu_methode_context175 = new MethodContext(void.class, 331, 13092, 14812);
        try {
            CallChecker.varInit(this, "this", 331, 13092, 14812);
            CallChecker.varInit(this.maxUlps, "maxUlps", 331, 13092, 14812);
            CallChecker.varInit(this.epsilon, "epsilon", 331, 13092, 14812);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 331, 13092, 14812);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 331, 13092, 14812);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 331, 13092, 14812);
            CallChecker.varInit(this.tableau, "tableau", 331, 13092, 14812);
            CallChecker.varInit(this.columnLabels, "columnLabels", 331, 13092, 14812);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 331, 13092, 14812);
            CallChecker.varInit(this.constraints, "constraints", 331, 13092, 14812);
            CallChecker.varInit(this.f, "f", 331, 13092, 14812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 331, 13092, 14812);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 331, 13092, 14812);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 331, 13092, 14812);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 331, 13092, 14812);
            if ((getNumObjectiveFunctions()) == 1) {
                return ;
            }
            Set<Integer> columnsToDrop = CallChecker.varInit(new TreeSet<Integer>(), "columnsToDrop", 336, 13385, 13436);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 337, 13446, 13458)) {
                columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 337, 13446, 13458);
                CallChecker.isCalled(columnsToDrop, Set.class, 337, 13446, 13458).add(0);
            }
            for (int i = getNumObjectiveFunctions(); i < (getArtificialVariableOffset()); i++) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 341, 13643, 13649);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(this.tableau, RealMatrix.class, 341, 13643, 13649).getEntry(0, i))), "entry", 341, 13622, 13665);
                if ((Precision.compareTo(entry, 0.0, epsilon)) > 0) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 343, 13746, 13758)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 343, 13746, 13758);
                        CallChecker.isCalled(columnsToDrop, Set.class, 343, 13746, 13758).add(i);
                    }
                }
            }
            for (int i = 0; i < (getNumArtificialVariables()); i++) {
                int col = CallChecker.varInit(((int) (i + (getArtificialVariableOffset()))), "col", 349, 13911, 13954);
                if ((getBasicRow(col)) == null) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 351, 14016, 14028)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 351, 14016, 14028);
                        CallChecker.isCalled(columnsToDrop, Set.class, 351, 14016, 14028).add(col);
                    }
                }
            }
            double[][] matrix = CallChecker.init(double[][].class);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 355, 14134, 14146)) {
                columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 355, 14134, 14146);
                matrix = new double[(getHeight()) - 1][(getWidth()) - (CallChecker.isCalled(columnsToDrop, Set.class, 355, 14134, 14146).size())];
                CallChecker.varAssign(matrix, "matrix", 355, 14134, 14146);
            }
            for (int i = 1; i < (getHeight()); i++) {
                int col = CallChecker.varInit(((int) (0)), "col", 357, 14217, 14228);
                for (int j = 0; j < (getWidth()); j++) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 359, 14302, 14314)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 359, 14302, 14314);
                        if (!(CallChecker.isCalled(columnsToDrop, Set.class, 359, 14302, 14314).contains(j))) {
                            if (CallChecker.beforeDeref(matrix, double[][].class, 360, 14351, 14356)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 360, 14351, 14356);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)], double[].class, 360, 14351, 14363)) {
                                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 360, 14374, 14380)) {
                                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 360, 14351, 14356);
                                        CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)], double[].class, 360, 14351, 14363);
                                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 360, 14374, 14380);
                                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)], double[].class, 360, 14351, 14363)[(col++)] = CallChecker.isCalled(tableau, RealMatrix.class, 360, 14374, 14380).getEntry(i, j);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)], double[].class, 360, 14351, 14363)[(col - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 360, 14351, 14356)[(i - 1)], double[].class, 360, 14351, 14363)[(col - 1)]", 360, 14351, 14396);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Integer[] drop = CallChecker.init(Integer[].class);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 366, 14574, 14586)) {
                if (CallChecker.beforeDeref(columnsToDrop, Set.class, 366, 14540, 14552)) {
                    columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 366, 14574, 14586);
                    columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 366, 14540, 14552);
                    drop = CallChecker.isCalled(columnsToDrop, Set.class, 366, 14540, 14552).toArray(new Integer[CallChecker.isCalled(columnsToDrop, Set.class, 366, 14574, 14586).size()]);
                    CallChecker.varAssign(drop, "drop", 366, 14574, 14586);
                }
            }
            drop = CallChecker.beforeCalled(drop, Integer[].class, 367, 14619, 14622);
            for (int i = (CallChecker.isCalled(drop, Integer[].class, 367, 14619, 14622).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(drop, Integer[].class, 368, 14689, 14692)) {
                    if (CallChecker.beforeDeref(columnLabels, List.class, 368, 14663, 14674)) {
                        drop = CallChecker.beforeCalled(drop, Integer[].class, 368, 14689, 14692);
                        CallChecker.isCalled(columnLabels, List.class, 368, 14663, 14674).remove(((int) (CallChecker.isCalled(drop, Integer[].class, 368, 14689, 14692)[i])));
                    }
                }
            }
            this.tableau = new Array2DRowRealMatrix(matrix);
            CallChecker.varAssign(this.tableau, "this.tableau", 371, 14718, 14765);
            this.numArtificialVariables = 0;
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 372, 14775, 14806);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    private void copyArray(final double[] src, final double[] dest) {
        MethodContext _bcornu_methode_context176 = new MethodContext(void.class, 379, 14819, 15061);
        try {
            CallChecker.varInit(this, "this", 379, 14819, 15061);
            CallChecker.varInit(dest, "dest", 379, 14819, 15061);
            CallChecker.varInit(src, "src", 379, 14819, 15061);
            CallChecker.varInit(this.maxUlps, "maxUlps", 379, 14819, 15061);
            CallChecker.varInit(this.epsilon, "epsilon", 379, 14819, 15061);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 379, 14819, 15061);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 379, 14819, 15061);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 379, 14819, 15061);
            CallChecker.varInit(this.tableau, "tableau", 379, 14819, 15061);
            CallChecker.varInit(this.columnLabels, "columnLabels", 379, 14819, 15061);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 379, 14819, 15061);
            CallChecker.varInit(this.constraints, "constraints", 379, 14819, 15061);
            CallChecker.varInit(this.f, "f", 379, 14819, 15061);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 379, 14819, 15061);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 379, 14819, 15061);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 379, 14819, 15061);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 379, 14819, 15061);
            if (CallChecker.beforeDeref(src, double[].class, 380, 15044, 15046)) {
                System.arraycopy(src, 0, dest, getNumObjectiveFunctions(), CallChecker.isCalled(src, double[].class, 380, 15044, 15046).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    boolean isOptimal() {
        MethodContext _bcornu_methode_context177 = new MethodContext(boolean.class, 387, 15068, 15489);
        try {
            CallChecker.varInit(this, "this", 387, 15068, 15489);
            CallChecker.varInit(this.maxUlps, "maxUlps", 387, 15068, 15489);
            CallChecker.varInit(this.epsilon, "epsilon", 387, 15068, 15489);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 387, 15068, 15489);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 387, 15068, 15489);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 387, 15068, 15489);
            CallChecker.varInit(this.tableau, "tableau", 387, 15068, 15489);
            CallChecker.varInit(this.columnLabels, "columnLabels", 387, 15068, 15489);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 387, 15068, 15489);
            CallChecker.varInit(this.constraints, "constraints", 387, 15068, 15489);
            CallChecker.varInit(this.f, "f", 387, 15068, 15489);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 387, 15068, 15489);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 387, 15068, 15489);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 387, 15068, 15489);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 387, 15068, 15489);
            for (int i = getNumObjectiveFunctions(); i < ((getWidth()) - 1); i++) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 389, 15323, 15329);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(this.tableau, RealMatrix.class, 389, 15323, 15329).getEntry(0, i))), "entry", 389, 15302, 15345);
                if ((Precision.compareTo(entry, 0.0, epsilon)) < 0) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    protected PointValuePair getSolution() {
        MethodContext _bcornu_methode_context178 = new MethodContext(PointValuePair.class, 401, 15496, 17203);
        try {
            CallChecker.varInit(this, "this", 401, 15496, 17203);
            CallChecker.varInit(this.maxUlps, "maxUlps", 401, 15496, 17203);
            CallChecker.varInit(this.epsilon, "epsilon", 401, 15496, 17203);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 401, 15496, 17203);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 401, 15496, 17203);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 401, 15496, 17203);
            CallChecker.varInit(this.tableau, "tableau", 401, 15496, 17203);
            CallChecker.varInit(this.columnLabels, "columnLabels", 401, 15496, 17203);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 401, 15496, 17203);
            CallChecker.varInit(this.constraints, "constraints", 401, 15496, 17203);
            CallChecker.varInit(this.f, "f", 401, 15496, 17203);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 401, 15496, 17203);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 401, 15496, 17203);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 401, 15496, 17203);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 401, 15496, 17203);
            int negativeVarColumn = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(columnLabels, List.class, 402, 15648, 15659)) {
                negativeVarColumn = CallChecker.isCalled(columnLabels, List.class, 402, 15648, 15659).indexOf(SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL);
                CallChecker.varAssign(negativeVarColumn, "negativeVarColumn", 402, 15648, 15659);
            }
            Integer negativeVarBasicRow = CallChecker.init(Integer.class);
            if (negativeVarColumn > 0) {
                negativeVarBasicRow = getBasicRow(negativeVarColumn);
                CallChecker.varAssign(negativeVarBasicRow, "negativeVarBasicRow", 403, 15733, 15793);
            }else {
                negativeVarBasicRow = null;
                CallChecker.varAssign(negativeVarBasicRow, "negativeVarBasicRow", 403, 15733, 15793);
            }
            double mostNegative = CallChecker.init(double.class);
            if (negativeVarBasicRow == null) {
                mostNegative = 0;
                CallChecker.varAssign(mostNegative, "mostNegative", 404, 15824, 15902);
            }else {
                mostNegative = getEntry(negativeVarBasicRow, getRhsOffset());
                CallChecker.varAssign(mostNegative, "mostNegative", 404, 15824, 15902);
            }
            Set<Integer> basicRows = CallChecker.varInit(new HashSet<Integer>(), "basicRows", 406, 15912, 15959);
            double[] coefficients = CallChecker.varInit(new double[getOriginalNumDecisionVariables()], "coefficients", 407, 15967, 16036);
            coefficients = CallChecker.beforeCalled(coefficients, double[].class, 408, 16064, 16075);
            for (int i = 0; i < (CallChecker.isCalled(coefficients, double[].class, 408, 16064, 16075).length); i++) {
                int colIndex = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(columnLabels, List.class, 409, 16117, 16128)) {
                    colIndex = CallChecker.isCalled(columnLabels, List.class, 409, 16117, 16128).indexOf(("x" + i));
                    CallChecker.varAssign(colIndex, "colIndex", 409, 16117, 16128);
                }
                if (colIndex < 0) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 411, 16190, 16201)) {
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 411, 16190, 16201);
                        CallChecker.isCalled(coefficients, double[].class, 411, 16190, 16201)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 411, 16190, 16201)[i], "CallChecker.isCalled(coefficients, double[].class, 411, 16190, 16201)[i]", 411, 16190, 16209);
                    }
                    continue;
                }
                Integer basicRow = CallChecker.varInit(getBasicRow(colIndex), "basicRow", 414, 16255, 16295);
                if ((basicRow != null) && (basicRow == 0)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 419, 16588, 16599)) {
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 419, 16588, 16599);
                        CallChecker.isCalled(coefficients, double[].class, 419, 16588, 16599)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 419, 16588, 16599)[i], "CallChecker.isCalled(coefficients, double[].class, 419, 16588, 16599)[i]", 419, 16588, 16607);
                    }
                }else
                    if (CallChecker.beforeDeref(basicRows, Set.class, 420, 16630, 16638)) {
                        basicRows = CallChecker.beforeCalled(basicRows, Set.class, 420, 16630, 16638);
                        if (CallChecker.isCalled(basicRows, Set.class, 420, 16630, 16638).contains(basicRow)) {
                            if (restrictToNonNegative) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 423, 16808, 16819)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 423, 16808, 16819);
                                    CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i] = 0 - 0;
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i], "CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i]", 423, 16808, 16872);
                                }
                            }else {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 423, 16808, 16819)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 423, 16808, 16819);
                                    CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i] = 0 - mostNegative;
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i], "CallChecker.isCalled(coefficients, double[].class, 423, 16808, 16819)[i]", 423, 16808, 16872);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(basicRows, Set.class, 425, 16907, 16915)) {
                                basicRows = CallChecker.beforeCalled(basicRows, Set.class, 425, 16907, 16915);
                                CallChecker.isCalled(basicRows, Set.class, 425, 16907, 16915).add(basicRow);
                            }
                            if (basicRow == null) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 426, 16946, 16957)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 426, 16946, 16957);
                                    CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i] = 0 - (restrictToNonNegative ? 0 : mostNegative);
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i], "CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i]", 426, 16946, 17104);
                                }
                            }else {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 426, 16946, 16957)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 426, 16946, 16957);
                                    CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i] = (getEntry(basicRow, getRhsOffset())) - (restrictToNonNegative ? 0 : mostNegative);
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i], "CallChecker.isCalled(coefficients, double[].class, 426, 16946, 16957)[i]", 426, 16946, 17104);
                                }
                            }
                        }
                    }
                
            }
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 431, 17172, 17172)) {
                return new PointValuePair(coefficients, CallChecker.isCalled(f, LinearObjectiveFunction.class, 431, 17172, 17172).getValue(coefficients));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    protected void divideRow(final int dividendRow, final double divisor) {
        MethodContext _bcornu_methode_context179 = new MethodContext(void.class, 443, 17210, 17744);
        try {
            CallChecker.varInit(this, "this", 443, 17210, 17744);
            CallChecker.varInit(divisor, "divisor", 443, 17210, 17744);
            CallChecker.varInit(dividendRow, "dividendRow", 443, 17210, 17744);
            CallChecker.varInit(this.maxUlps, "maxUlps", 443, 17210, 17744);
            CallChecker.varInit(this.epsilon, "epsilon", 443, 17210, 17744);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 443, 17210, 17744);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 443, 17210, 17744);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 443, 17210, 17744);
            CallChecker.varInit(this.tableau, "tableau", 443, 17210, 17744);
            CallChecker.varInit(this.columnLabels, "columnLabels", 443, 17210, 17744);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 443, 17210, 17744);
            CallChecker.varInit(this.constraints, "constraints", 443, 17210, 17744);
            CallChecker.varInit(this.f, "f", 443, 17210, 17744);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 443, 17210, 17744);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 443, 17210, 17744);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 443, 17210, 17744);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 443, 17210, 17744);
            for (int j = 0; j < (getWidth()); j++) {
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 445, 17685, 17691)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 445, 17652, 17658)) {
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 445, 17685, 17691);
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 445, 17652, 17658);
                        CallChecker.isCalled(tableau, RealMatrix.class, 445, 17652, 17658).setEntry(dividendRow, j, ((CallChecker.isCalled(tableau, RealMatrix.class, 445, 17685, 17691).getEntry(dividendRow, j)) / divisor));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    protected void subtractRow(final int minuendRow, final int subtrahendRow, final double multiple) {
        MethodContext _bcornu_methode_context180 = new MethodContext(void.class, 459, 17751, 18661);
        try {
            CallChecker.varInit(this, "this", 459, 17751, 18661);
            CallChecker.varInit(multiple, "multiple", 459, 17751, 18661);
            CallChecker.varInit(subtrahendRow, "subtrahendRow", 459, 17751, 18661);
            CallChecker.varInit(minuendRow, "minuendRow", 459, 17751, 18661);
            CallChecker.varInit(this.maxUlps, "maxUlps", 459, 17751, 18661);
            CallChecker.varInit(this.epsilon, "epsilon", 459, 17751, 18661);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 459, 17751, 18661);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 459, 17751, 18661);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 459, 17751, 18661);
            CallChecker.varInit(this.tableau, "tableau", 459, 17751, 18661);
            CallChecker.varInit(this.columnLabels, "columnLabels", 459, 17751, 18661);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 459, 17751, 18661);
            CallChecker.varInit(this.constraints, "constraints", 459, 17751, 18661);
            CallChecker.varInit(this.f, "f", 459, 17751, 18661);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 459, 17751, 18661);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 459, 17751, 18661);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 459, 17751, 18661);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 459, 17751, 18661);
            for (int i = 0; i < (getWidth()); i++) {
                double result = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 462, 18299, 18305)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 462, 18333, 18339)) {
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 462, 18299, 18305);
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 462, 18333, 18339);
                        result = (CallChecker.isCalled(tableau, RealMatrix.class, 462, 18299, 18305).getEntry(minuendRow, i)) - ((CallChecker.isCalled(tableau, RealMatrix.class, 462, 18333, 18339).getEntry(subtrahendRow, i)) * multiple);
                        CallChecker.varAssign(result, "result", 462, 18299, 18305);
                    }
                }
                if ((FastMath.abs(result)) < (SimplexTableau.CUTOFF_THRESHOLD)) {
                    result = 0.0;
                    CallChecker.varAssign(result, "result", 465, 18566, 18578);
                }
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 467, 18606, 18612)) {
                    tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 467, 18606, 18612);
                    CallChecker.isCalled(tableau, RealMatrix.class, 467, 18606, 18612).setEntry(minuendRow, i, result);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context180.methodEnd();
        }
    }

    protected final int getWidth() {
        MethodContext _bcornu_methode_context181 = new MethodContext(int.class, 475, 18668, 18839);
        try {
            CallChecker.varInit(this, "this", 475, 18668, 18839);
            CallChecker.varInit(this.maxUlps, "maxUlps", 475, 18668, 18839);
            CallChecker.varInit(this.epsilon, "epsilon", 475, 18668, 18839);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 475, 18668, 18839);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 475, 18668, 18839);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 475, 18668, 18839);
            CallChecker.varInit(this.tableau, "tableau", 475, 18668, 18839);
            CallChecker.varInit(this.columnLabels, "columnLabels", 475, 18668, 18839);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 475, 18668, 18839);
            CallChecker.varInit(this.constraints, "constraints", 475, 18668, 18839);
            CallChecker.varInit(this.f, "f", 475, 18668, 18839);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 475, 18668, 18839);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 475, 18668, 18839);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 475, 18668, 18839);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 475, 18668, 18839);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 476, 18805, 18811)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 476, 18805, 18811);
                return CallChecker.isCalled(tableau, RealMatrix.class, 476, 18805, 18811).getColumnDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    protected final int getHeight() {
        MethodContext _bcornu_methode_context182 = new MethodContext(int.class, 483, 18846, 19017);
        try {
            CallChecker.varInit(this, "this", 483, 18846, 19017);
            CallChecker.varInit(this.maxUlps, "maxUlps", 483, 18846, 19017);
            CallChecker.varInit(this.epsilon, "epsilon", 483, 18846, 19017);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 483, 18846, 19017);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 483, 18846, 19017);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 483, 18846, 19017);
            CallChecker.varInit(this.tableau, "tableau", 483, 18846, 19017);
            CallChecker.varInit(this.columnLabels, "columnLabels", 483, 18846, 19017);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 483, 18846, 19017);
            CallChecker.varInit(this.constraints, "constraints", 483, 18846, 19017);
            CallChecker.varInit(this.f, "f", 483, 18846, 19017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 483, 18846, 19017);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 483, 18846, 19017);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 483, 18846, 19017);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 483, 18846, 19017);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 484, 18986, 18992)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 484, 18986, 18992);
                return CallChecker.isCalled(tableau, RealMatrix.class, 484, 18986, 18992).getRowDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context182.methodEnd();
        }
    }

    protected final double getEntry(final int row, final int column) {
        MethodContext _bcornu_methode_context183 = new MethodContext(double.class, 493, 19024, 19293);
        try {
            CallChecker.varInit(this, "this", 493, 19024, 19293);
            CallChecker.varInit(column, "column", 493, 19024, 19293);
            CallChecker.varInit(row, "row", 493, 19024, 19293);
            CallChecker.varInit(this.maxUlps, "maxUlps", 493, 19024, 19293);
            CallChecker.varInit(this.epsilon, "epsilon", 493, 19024, 19293);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 493, 19024, 19293);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 493, 19024, 19293);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 493, 19024, 19293);
            CallChecker.varInit(this.tableau, "tableau", 493, 19024, 19293);
            CallChecker.varInit(this.columnLabels, "columnLabels", 493, 19024, 19293);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 493, 19024, 19293);
            CallChecker.varInit(this.constraints, "constraints", 493, 19024, 19293);
            CallChecker.varInit(this.f, "f", 493, 19024, 19293);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 493, 19024, 19293);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 493, 19024, 19293);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 493, 19024, 19293);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 493, 19024, 19293);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 494, 19258, 19264)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 494, 19258, 19264);
                return CallChecker.isCalled(tableau, RealMatrix.class, 494, 19258, 19264).getEntry(row, column);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context183.methodEnd();
        }
    }

    protected final void setEntry(final int row, final int column, final double value) {
        MethodContext _bcornu_methode_context184 = new MethodContext(void.class, 503, 19300, 19617);
        try {
            CallChecker.varInit(this, "this", 503, 19300, 19617);
            CallChecker.varInit(value, "value", 503, 19300, 19617);
            CallChecker.varInit(column, "column", 503, 19300, 19617);
            CallChecker.varInit(row, "row", 503, 19300, 19617);
            CallChecker.varInit(this.maxUlps, "maxUlps", 503, 19300, 19617);
            CallChecker.varInit(this.epsilon, "epsilon", 503, 19300, 19617);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 503, 19300, 19617);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 503, 19300, 19617);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 503, 19300, 19617);
            CallChecker.varInit(this.tableau, "tableau", 503, 19300, 19617);
            CallChecker.varInit(this.columnLabels, "columnLabels", 503, 19300, 19617);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 503, 19300, 19617);
            CallChecker.varInit(this.constraints, "constraints", 503, 19300, 19617);
            CallChecker.varInit(this.f, "f", 503, 19300, 19617);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 503, 19300, 19617);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 503, 19300, 19617);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 503, 19300, 19617);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 503, 19300, 19617);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 505, 19575, 19581)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 505, 19575, 19581);
                CallChecker.isCalled(tableau, RealMatrix.class, 505, 19575, 19581).setEntry(row, column, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context184.methodEnd();
        }
    }

    protected final int getSlackVariableOffset() {
        MethodContext _bcornu_methode_context185 = new MethodContext(int.class, 512, 19624, 19858);
        try {
            CallChecker.varInit(this, "this", 512, 19624, 19858);
            CallChecker.varInit(this.maxUlps, "maxUlps", 512, 19624, 19858);
            CallChecker.varInit(this.epsilon, "epsilon", 512, 19624, 19858);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 512, 19624, 19858);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 512, 19624, 19858);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 512, 19624, 19858);
            CallChecker.varInit(this.tableau, "tableau", 512, 19624, 19858);
            CallChecker.varInit(this.columnLabels, "columnLabels", 512, 19624, 19858);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 512, 19624, 19858);
            CallChecker.varInit(this.constraints, "constraints", 512, 19624, 19858);
            CallChecker.varInit(this.f, "f", 512, 19624, 19858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 512, 19624, 19858);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 512, 19624, 19858);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 512, 19624, 19858);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 512, 19624, 19858);
            return (getNumObjectiveFunctions()) + (numDecisionVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context185.methodEnd();
        }
    }

    protected final int getArtificialVariableOffset() {
        MethodContext _bcornu_methode_context186 = new MethodContext(int.class, 520, 19865, 20134);
        try {
            CallChecker.varInit(this, "this", 520, 19865, 20134);
            CallChecker.varInit(this.maxUlps, "maxUlps", 520, 19865, 20134);
            CallChecker.varInit(this.epsilon, "epsilon", 520, 19865, 20134);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 520, 19865, 20134);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 520, 19865, 20134);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 520, 19865, 20134);
            CallChecker.varInit(this.tableau, "tableau", 520, 19865, 20134);
            CallChecker.varInit(this.columnLabels, "columnLabels", 520, 19865, 20134);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 520, 19865, 20134);
            CallChecker.varInit(this.constraints, "constraints", 520, 19865, 20134);
            CallChecker.varInit(this.f, "f", 520, 19865, 20134);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 520, 19865, 20134);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 520, 19865, 20134);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 520, 19865, 20134);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 520, 19865, 20134);
            return ((getNumObjectiveFunctions()) + (numDecisionVariables)) + (numSlackVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context186.methodEnd();
        }
    }

    protected final int getRhsOffset() {
        MethodContext _bcornu_methode_context187 = new MethodContext(int.class, 528, 20141, 20320);
        try {
            CallChecker.varInit(this, "this", 528, 20141, 20320);
            CallChecker.varInit(this.maxUlps, "maxUlps", 528, 20141, 20320);
            CallChecker.varInit(this.epsilon, "epsilon", 528, 20141, 20320);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 528, 20141, 20320);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 528, 20141, 20320);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 528, 20141, 20320);
            CallChecker.varInit(this.tableau, "tableau", 528, 20141, 20320);
            CallChecker.varInit(this.columnLabels, "columnLabels", 528, 20141, 20320);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 528, 20141, 20320);
            CallChecker.varInit(this.constraints, "constraints", 528, 20141, 20320);
            CallChecker.varInit(this.f, "f", 528, 20141, 20320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 528, 20141, 20320);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 528, 20141, 20320);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 528, 20141, 20320);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 528, 20141, 20320);
            return (getWidth()) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context187.methodEnd();
        }
    }

    protected final int getNumDecisionVariables() {
        MethodContext _bcornu_methode_context188 = new MethodContext(int.class, 541, 20327, 20759);
        try {
            CallChecker.varInit(this, "this", 541, 20327, 20759);
            CallChecker.varInit(this.maxUlps, "maxUlps", 541, 20327, 20759);
            CallChecker.varInit(this.epsilon, "epsilon", 541, 20327, 20759);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 541, 20327, 20759);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 541, 20327, 20759);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 541, 20327, 20759);
            CallChecker.varInit(this.tableau, "tableau", 541, 20327, 20759);
            CallChecker.varInit(this.columnLabels, "columnLabels", 541, 20327, 20759);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 541, 20327, 20759);
            CallChecker.varInit(this.constraints, "constraints", 541, 20327, 20759);
            CallChecker.varInit(this.f, "f", 541, 20327, 20759);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 541, 20327, 20759);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 541, 20327, 20759);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 541, 20327, 20759);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 541, 20327, 20759);
            return numDecisionVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    protected final int getOriginalNumDecisionVariables() {
        MethodContext _bcornu_methode_context189 = new MethodContext(int.class, 550, 20766, 21039);
        try {
            CallChecker.varInit(this, "this", 550, 20766, 21039);
            CallChecker.varInit(this.maxUlps, "maxUlps", 550, 20766, 21039);
            CallChecker.varInit(this.epsilon, "epsilon", 550, 20766, 21039);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 550, 20766, 21039);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 550, 20766, 21039);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 550, 20766, 21039);
            CallChecker.varInit(this.tableau, "tableau", 550, 20766, 21039);
            CallChecker.varInit(this.columnLabels, "columnLabels", 550, 20766, 21039);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 550, 20766, 21039);
            CallChecker.varInit(this.constraints, "constraints", 550, 20766, 21039);
            CallChecker.varInit(this.f, "f", 550, 20766, 21039);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 550, 20766, 21039);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 550, 20766, 21039);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 550, 20766, 21039);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 550, 20766, 21039);
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 551, 20999, 20999)) {
                final RealVector npe_invocation_var18 = CallChecker.isCalled(f, LinearObjectiveFunction.class, 551, 20999, 20999).getCoefficients();
                if (CallChecker.beforeDeref(npe_invocation_var18, RealVector.class, 551, 20999, 21017)) {
                    return CallChecker.isCalled(npe_invocation_var18, RealVector.class, 551, 20999, 21017).getDimension();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context189.methodEnd();
        }
    }

    protected final int getNumSlackVariables() {
        MethodContext _bcornu_methode_context190 = new MethodContext(int.class, 558, 21046, 21228);
        try {
            CallChecker.varInit(this, "this", 558, 21046, 21228);
            CallChecker.varInit(this.maxUlps, "maxUlps", 558, 21046, 21228);
            CallChecker.varInit(this.epsilon, "epsilon", 558, 21046, 21228);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 558, 21046, 21228);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 558, 21046, 21228);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 558, 21046, 21228);
            CallChecker.varInit(this.tableau, "tableau", 558, 21046, 21228);
            CallChecker.varInit(this.columnLabels, "columnLabels", 558, 21046, 21228);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 558, 21046, 21228);
            CallChecker.varInit(this.constraints, "constraints", 558, 21046, 21228);
            CallChecker.varInit(this.f, "f", 558, 21046, 21228);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 558, 21046, 21228);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 558, 21046, 21228);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 558, 21046, 21228);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 558, 21046, 21228);
            return numSlackVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    protected final int getNumArtificialVariables() {
        MethodContext _bcornu_methode_context191 = new MethodContext(int.class, 566, 21235, 21437);
        try {
            CallChecker.varInit(this, "this", 566, 21235, 21437);
            CallChecker.varInit(this.maxUlps, "maxUlps", 566, 21235, 21437);
            CallChecker.varInit(this.epsilon, "epsilon", 566, 21235, 21437);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 566, 21235, 21437);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 566, 21235, 21437);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 566, 21235, 21437);
            CallChecker.varInit(this.tableau, "tableau", 566, 21235, 21437);
            CallChecker.varInit(this.columnLabels, "columnLabels", 566, 21235, 21437);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 566, 21235, 21437);
            CallChecker.varInit(this.constraints, "constraints", 566, 21235, 21437);
            CallChecker.varInit(this.f, "f", 566, 21235, 21437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 566, 21235, 21437);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 566, 21235, 21437);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 566, 21235, 21437);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 566, 21235, 21437);
            return numArtificialVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }

    protected final double[][] getData() {
        MethodContext _bcornu_methode_context192 = new MethodContext(double[][].class, 574, 21444, 21594);
        try {
            CallChecker.varInit(this, "this", 574, 21444, 21594);
            CallChecker.varInit(this.maxUlps, "maxUlps", 574, 21444, 21594);
            CallChecker.varInit(this.epsilon, "epsilon", 574, 21444, 21594);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 574, 21444, 21594);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 574, 21444, 21594);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 574, 21444, 21594);
            CallChecker.varInit(this.tableau, "tableau", 574, 21444, 21594);
            CallChecker.varInit(this.columnLabels, "columnLabels", 574, 21444, 21594);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 574, 21444, 21594);
            CallChecker.varInit(this.constraints, "constraints", 574, 21444, 21594);
            CallChecker.varInit(this.f, "f", 574, 21444, 21594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 574, 21444, 21594);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 574, 21444, 21594);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 574, 21444, 21594);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 574, 21444, 21594);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 575, 21571, 21577)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 575, 21571, 21577);
                return CallChecker.isCalled(tableau, RealMatrix.class, 575, 21571, 21577).getData();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context192.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context193 = new MethodContext(boolean.class, 579, 21601, 22393);
        try {
            CallChecker.varInit(this, "this", 579, 21601, 22393);
            CallChecker.varInit(other, "other", 579, 21601, 22393);
            CallChecker.varInit(this.maxUlps, "maxUlps", 579, 21601, 22393);
            CallChecker.varInit(this.epsilon, "epsilon", 579, 21601, 22393);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 579, 21601, 22393);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 579, 21601, 22393);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 579, 21601, 22393);
            CallChecker.varInit(this.tableau, "tableau", 579, 21601, 22393);
            CallChecker.varInit(this.columnLabels, "columnLabels", 579, 21601, 22393);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 579, 21601, 22393);
            CallChecker.varInit(this.constraints, "constraints", 579, 21601, 22393);
            CallChecker.varInit(this.f, "f", 579, 21601, 22393);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 579, 21601, 22393);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 579, 21601, 22393);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 579, 21601, 22393);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 579, 21601, 22393);
            if ((this) == other) {
                return true;
            }
            if (other instanceof SimplexTableau) {
                SimplexTableau rhs = CallChecker.varInit(((SimplexTableau) (other)), "rhs", 586, 21766, 21809);
                if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 593, 22249, 22251)) {
                    if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 594, 22295, 22297)) {
                        if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 595, 22347, 22349)) {
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 587, 21855, 21857);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 588, 21929, 21931);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 589, 22002, 22004);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 590, 22072, 22074);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 591, 22147, 22149);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 592, 22207, 22209);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 593, 22249, 22251);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 594, 22295, 22297);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 595, 22347, 22349);
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 595, 22332, 22338);
                            return (((((((((restrictToNonNegative) == (CallChecker.isCalled(rhs, SimplexTableau.class, 587, 21855, 21857).restrictToNonNegative)) && ((numDecisionVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 588, 21929, 21931).numDecisionVariables))) && ((numSlackVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 589, 22002, 22004).numSlackVariables))) && ((numArtificialVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 590, 22072, 22074).numArtificialVariables))) && ((epsilon) == (CallChecker.isCalled(rhs, SimplexTableau.class, 591, 22147, 22149).epsilon))) && ((maxUlps) == (CallChecker.isCalled(rhs, SimplexTableau.class, 592, 22207, 22209).maxUlps))) && (CallChecker.isCalled(f, LinearObjectiveFunction.class, 593, 22240, 22240).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 593, 22249, 22251).f))) && (CallChecker.isCalled(constraints, List.class, 594, 22276, 22286).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 594, 22295, 22297).constraints))) && (CallChecker.isCalled(tableau, RealMatrix.class, 595, 22332, 22338).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 595, 22347, 22349).tableau));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context194 = new MethodContext(int.class, 601, 22400, 22804);
        try {
            CallChecker.varInit(this, "this", 601, 22400, 22804);
            CallChecker.varInit(this.maxUlps, "maxUlps", 601, 22400, 22804);
            CallChecker.varInit(this.epsilon, "epsilon", 601, 22400, 22804);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 601, 22400, 22804);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 601, 22400, 22804);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 601, 22400, 22804);
            CallChecker.varInit(this.tableau, "tableau", 601, 22400, 22804);
            CallChecker.varInit(this.columnLabels, "columnLabels", 601, 22400, 22804);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 601, 22400, 22804);
            CallChecker.varInit(this.constraints, "constraints", 601, 22400, 22804);
            CallChecker.varInit(this.f, "f", 601, 22400, 22804);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 601, 22400, 22804);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 601, 22400, 22804);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 601, 22400, 22804);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 601, 22400, 22804);
            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 610, 22780, 22786);
            return ((((((((CallChecker.isCalled(Boolean.valueOf(restrictToNonNegative), Boolean.class, 602, 22453, 22490).hashCode()) ^ (numDecisionVariables)) ^ (numSlackVariables)) ^ (numArtificialVariables)) ^ (CallChecker.isCalled(Double.valueOf(epsilon), Double.class, 606, 22633, 22655).hashCode())) ^ (maxUlps)) ^ (CallChecker.isCalled(f, LinearObjectiveFunction.class, 608, 22710, 22710).hashCode())) ^ (CallChecker.isCalled(constraints, List.class, 609, 22740, 22750).hashCode())) ^ (CallChecker.isCalled(tableau, RealMatrix.class, 610, 22780, 22786).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context194.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context195 = new MethodContext(void.class, 618, 22811, 23150);
        try {
            CallChecker.varInit(this, "this", 618, 22811, 23150);
            CallChecker.varInit(oos, "oos", 618, 22811, 23150);
            CallChecker.varInit(this.maxUlps, "maxUlps", 618, 22811, 23150);
            CallChecker.varInit(this.epsilon, "epsilon", 618, 22811, 23150);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 618, 22811, 23150);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 618, 22811, 23150);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 618, 22811, 23150);
            CallChecker.varInit(this.tableau, "tableau", 618, 22811, 23150);
            CallChecker.varInit(this.columnLabels, "columnLabels", 618, 22811, 23150);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 618, 22811, 23150);
            CallChecker.varInit(this.constraints, "constraints", 618, 22811, 23150);
            CallChecker.varInit(this.f, "f", 618, 22811, 23150);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 618, 22811, 23150);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 618, 22811, 23150);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 618, 22811, 23150);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 618, 22811, 23150);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 620, 23065, 23067)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 620, 23065, 23067);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 620, 23065, 23067).defaultWriteObject();
            }
            MatrixUtils.serializeRealMatrix(tableau, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context195.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context196 = new MethodContext(void.class, 630, 23157, 23615);
        try {
            CallChecker.varInit(this, "this", 630, 23157, 23615);
            CallChecker.varInit(ois, "ois", 630, 23157, 23615);
            CallChecker.varInit(this.maxUlps, "maxUlps", 630, 23157, 23615);
            CallChecker.varInit(this.epsilon, "epsilon", 630, 23157, 23615);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 630, 23157, 23615);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 630, 23157, 23615);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 630, 23157, 23615);
            CallChecker.varInit(this.tableau, "tableau", 630, 23157, 23615);
            CallChecker.varInit(this.columnLabels, "columnLabels", 630, 23157, 23615);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 630, 23157, 23615);
            CallChecker.varInit(this.constraints, "constraints", 630, 23157, 23615);
            CallChecker.varInit(this.f, "f", 630, 23157, 23615);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optimization.linear.SimplexTableau.serialVersionUID", 630, 23157, 23615);
            CallChecker.varInit(CUTOFF_THRESHOLD, "org.apache.commons.math3.optimization.linear.SimplexTableau.CUTOFF_THRESHOLD", 630, 23157, 23615);
            CallChecker.varInit(DEFAULT_ULPS, "org.apache.commons.math3.optimization.linear.SimplexTableau.DEFAULT_ULPS", 630, 23157, 23615);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optimization.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 630, 23157, 23615);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 632, 23521, 23523)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 632, 23521, 23523);
                CallChecker.isCalled(ois, ObjectInputStream.class, 632, 23521, 23523).defaultReadObject();
            }
            MatrixUtils.deserializeRealMatrix(this, "tableau", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context196.methodEnd();
        }
    }
}

