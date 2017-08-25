package org.apache.commons.math3.optim.linear;

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
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

class SimplexTableau implements Serializable {
    private static final String NEGATIVE_VAR_COLUMN_LABEL = "x-";

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

    private final double cutOff;

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon) {
        this(f, constraints, goalType, restrictToNonNegative, epsilon, SimplexSolver.DEFAULT_ULPS, SimplexSolver.DEFAULT_CUT_OFF);
        ConstructorContext _bcornu_methode_context53 = new ConstructorContext(SimplexTableau.class, 115, 3767, 4618);
        try {
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon, final int maxUlps) {
        this(f, constraints, goalType, restrictToNonNegative, epsilon, maxUlps, SimplexSolver.DEFAULT_CUT_OFF);
        ConstructorContext _bcornu_methode_context54 = new ConstructorContext(SimplexTableau.class, 133, 4625, 5545);
        try {
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon, final int maxUlps, final double cutOff) {
        ConstructorContext _bcornu_methode_context55 = new ConstructorContext(SimplexTableau.class, 152, 5552, 7348);
        try {
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 159, 6463, 6494);
            this.constraints = normalizeConstraints(constraints);
            CallChecker.varAssign(this.constraints, "this.constraints", 160, 6504, 6567);
            this.restrictToNonNegative = restrictToNonNegative;
            CallChecker.varAssign(this.restrictToNonNegative, "this.restrictToNonNegative", 161, 6577, 6628);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 162, 6638, 6675);
            this.maxUlps = maxUlps;
            CallChecker.varAssign(this.maxUlps, "this.maxUlps", 163, 6685, 6722);
            this.cutOff = cutOff;
            CallChecker.varAssign(this.cutOff, "this.cutOff", 164, 6732, 6768);
            if (restrictToNonNegative) {
                this.numDecisionVariables = (CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 165, 6808, 6808).getCoefficients(), RealVector.class, 165, 6808, 6826).getDimension()) + 0;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 165, 6778, 6914);
            }else {
                this.numDecisionVariables = (CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 165, 6808, 6808).getCoefficients(), RealVector.class, 165, 6808, 6826).getDimension()) + 1;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 165, 6778, 6914);
            }
            this.numSlackVariables = (getConstraintTypeCounts(Relationship.LEQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numSlackVariables, "this.numSlackVariables", 167, 6924, 7077);
            this.numArtificialVariables = (getConstraintTypeCounts(Relationship.EQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 169, 7087, 7239);
            this.tableau = createTableau((goalType == (GoalType.MAXIMIZE)));
            CallChecker.varAssign(this.tableau, "this.tableau", 171, 7249, 7308);
            initializeColumnLabels();
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    protected void initializeColumnLabels() {
        MethodContext _bcornu_methode_context197 = new MethodContext(void.class, 178, 7355, 8020);
        try {
            CallChecker.varInit(this, "this", 178, 7355, 8020);
            CallChecker.varInit(this.cutOff, "cutOff", 178, 7355, 8020);
            CallChecker.varInit(this.maxUlps, "maxUlps", 178, 7355, 8020);
            CallChecker.varInit(this.epsilon, "epsilon", 178, 7355, 8020);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 178, 7355, 8020);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 178, 7355, 8020);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 178, 7355, 8020);
            CallChecker.varInit(this.tableau, "tableau", 178, 7355, 8020);
            CallChecker.varInit(this.columnLabels, "columnLabels", 178, 7355, 8020);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 178, 7355, 8020);
            CallChecker.varInit(this.constraints, "constraints", 178, 7355, 8020);
            CallChecker.varInit(this.f, "f", 178, 7355, 8020);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 178, 7355, 8020);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 178, 7355, 8020);
            if ((getNumObjectiveFunctions()) == 2) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 180, 7512, 7523)) {
                    CallChecker.isCalled(columnLabels, List.class, 180, 7512, 7523).add("W");
                }
            }
            if (CallChecker.beforeDeref(columnLabels, List.class, 182, 7549, 7560)) {
                CallChecker.isCalled(columnLabels, List.class, 182, 7549, 7560).add("Z");
            }
            for (int i = 0; i < (getOriginalNumDecisionVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 184, 7648, 7659)) {
                    CallChecker.isCalled(columnLabels, List.class, 184, 7648, 7659).add(("x" + i));
                }
            }
            if (!(restrictToNonNegative)) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 187, 7727, 7738)) {
                    CallChecker.isCalled(columnLabels, List.class, 187, 7727, 7738).add(SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL);
                }
            }
            for (int i = 0; i < (getNumSlackVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 190, 7845, 7856)) {
                    CallChecker.isCalled(columnLabels, List.class, 190, 7845, 7856).add(("s" + i));
                }
            }
            for (int i = 0; i < (getNumArtificialVariables()); i++) {
                if (CallChecker.beforeDeref(columnLabels, List.class, 193, 7950, 7961)) {
                    CallChecker.isCalled(columnLabels, List.class, 193, 7950, 7961).add(("a" + i));
                }
            }
            if (CallChecker.beforeDeref(columnLabels, List.class, 195, 7991, 8002)) {
                CallChecker.isCalled(columnLabels, List.class, 195, 7991, 8002).add("RHS");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context197.methodEnd();
        }
    }

    protected RealMatrix createTableau(final boolean maximize) {
        MethodContext _bcornu_methode_context198 = new MethodContext(RealMatrix.class, 203, 8027, 10956);
        try {
            CallChecker.varInit(this, "this", 203, 8027, 10956);
            CallChecker.varInit(maximize, "maximize", 203, 8027, 10956);
            CallChecker.varInit(this.cutOff, "cutOff", 203, 8027, 10956);
            CallChecker.varInit(this.maxUlps, "maxUlps", 203, 8027, 10956);
            CallChecker.varInit(this.epsilon, "epsilon", 203, 8027, 10956);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 203, 8027, 10956);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 203, 8027, 10956);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 203, 8027, 10956);
            CallChecker.varInit(this.tableau, "tableau", 203, 8027, 10956);
            CallChecker.varInit(this.columnLabels, "columnLabels", 203, 8027, 10956);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 203, 8027, 10956);
            CallChecker.varInit(this.constraints, "constraints", 203, 8027, 10956);
            CallChecker.varInit(this.f, "f", 203, 8027, 10956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 203, 8027, 10956);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 203, 8027, 10956);
            int width = CallChecker.varInit(((int) (((((this.numDecisionVariables) + (this.numSlackVariables)) + (this.numArtificialVariables)) + (getNumObjectiveFunctions())) + 1)), "width", 206, 8303, 8421);
            int height = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(constraints, List.class, 208, 8462, 8472)) {
                height = (CallChecker.isCalled(constraints, List.class, 208, 8462, 8472).size()) + (getNumObjectiveFunctions());
                CallChecker.varAssign(height, "height", 208, 8462, 8472);
            }
            Array2DRowRealMatrix matrix = CallChecker.varInit(new Array2DRowRealMatrix(height, width), "matrix", 209, 8519, 8588);
            if ((getNumObjectiveFunctions()) == 2) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 213, 8700, 8705)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 213, 8700, 8705);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 213, 8700, 8705).setEntry(0, 0, (-1));
                }
            }
            int zIndex = CallChecker.init(int.class);
            if ((getNumObjectiveFunctions()) == 1) {
                zIndex = 0;
                CallChecker.varAssign(zIndex, "zIndex", 215, 8758, 8798);
            }else {
                zIndex = 1;
                CallChecker.varAssign(zIndex, "zIndex", 215, 8758, 8798);
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814).setEntry(zIndex, zIndex, 1);
                }
            }else {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 216, 8809, 8814).setEntry(zIndex, zIndex, (-1));
                }
            }
            RealVector objectiveCoefficients = CallChecker.init(RealVector.class);
            if (maximize) {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 218, 8927, 8927)) {
                    final RealVector npe_invocation_var19 = CallChecker.isCalled(f, LinearObjectiveFunction.class, 218, 8927, 8927).getCoefficients();
                    if (CallChecker.beforeDeref(npe_invocation_var19, RealVector.class, 218, 8927, 8945)) {
                        objectiveCoefficients = CallChecker.isCalled(npe_invocation_var19, RealVector.class, 218, 8927, 8945).mapMultiply((-1));
                        CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 218, 8916, 8983);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 218, 8965, 8965)) {
                    objectiveCoefficients = CallChecker.isCalled(f, LinearObjectiveFunction.class, 218, 8965, 8965).getCoefficients();
                    CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 218, 8916, 8983);
                }
            }
            if (CallChecker.beforeDeref(objectiveCoefficients, RealVector.class, 219, 9004, 9024)) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 219, 9037, 9042)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 219, 9037, 9042);
                    final double[][] npe_invocation_var20 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 219, 9037, 9042).getDataRef();
                    if (CallChecker.beforeDeref(npe_invocation_var20, double[][].class, 219, 9037, 9055)) {
                        objectiveCoefficients = CallChecker.beforeCalled(objectiveCoefficients, RealVector.class, 219, 9004, 9024);
                        copyArray(CallChecker.isCalled(objectiveCoefficients, RealVector.class, 219, 9004, 9024).toArray(), CallChecker.isCalled(npe_invocation_var20, double[][].class, 219, 9037, 9055)[zIndex]);
                    }
                }
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080).setEntry(zIndex, (width - 1), CallChecker.isCalled(f, LinearObjectiveFunction.class, 221, 9133, 9133).getConstantTerm());
                }
            }else {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 220, 9075, 9080).setEntry(zIndex, (width - 1), ((-1) * (CallChecker.isCalled(f, LinearObjectiveFunction.class, 221, 9160, 9160).getConstantTerm())));
                }
            }
            if (!(restrictToNonNegative)) {
                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 224, 9233, 9238)) {
                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 224, 9233, 9238);
                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 224, 9233, 9238).setEntry(zIndex, ((getSlackVariableOffset()) - 1), SimplexTableau.getInvertedCoefficientSum(objectiveCoefficients));
                }
            }
            int slackVar = CallChecker.varInit(((int) (0)), "slackVar", 229, 9415, 9431);
            int artificialVar = CallChecker.varInit(((int) (0)), "artificialVar", 230, 9441, 9462);
            for (int i = 0; i < (CallChecker.isCalled(constraints, List.class, 231, 9492, 9502).size()); i++) {
                LinearConstraint constraint = CallChecker.init(LinearConstraint.class);
                if (CallChecker.beforeDeref(constraints, List.class, 232, 9561, 9571)) {
                    constraint = CallChecker.isCalled(constraints, List.class, 232, 9561, 9571).get(i);
                    CallChecker.varAssign(constraint, "constraint", 232, 9561, 9571);
                }
                int row = CallChecker.varInit(((int) ((getNumObjectiveFunctions()) + i)), "row", 233, 9593, 9633);
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 236, 9704, 9713)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 236, 9704, 9713);
                    final RealVector npe_invocation_var21 = CallChecker.isCalled(constraint, LinearConstraint.class, 236, 9704, 9713).getCoefficients();
                    if (CallChecker.beforeDeref(npe_invocation_var21, RealVector.class, 236, 9704, 9731)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 236, 9744, 9749)) {
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 236, 9744, 9749);
                            final double[][] npe_invocation_var22 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 236, 9744, 9749).getDataRef();
                            if (CallChecker.beforeDeref(npe_invocation_var22, double[][].class, 236, 9744, 9762)) {
                                copyArray(CallChecker.isCalled(npe_invocation_var21, RealVector.class, 236, 9704, 9731).toArray(), CallChecker.isCalled(npe_invocation_var22, double[][].class, 236, 9744, 9762)[row]);
                            }
                        }
                    }
                }
                if (!(restrictToNonNegative)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 241, 9945, 9954)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 240, 9848, 9853)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 241, 9945, 9954);
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 240, 9848, 9853);
                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 240, 9848, 9853).setEntry(row, ((getSlackVariableOffset()) - 1), SimplexTableau.getInvertedCoefficientSum(CallChecker.isCalled(constraint, LinearConstraint.class, 241, 9945, 9954).getCoefficients()));
                        }
                    }
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 245, 10055, 10064)) {
                    if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 245, 10023, 10028)) {
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 245, 10055, 10064);
                        matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 245, 10023, 10028);
                        CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 245, 10023, 10028).setEntry(row, (width - 1), CallChecker.isCalled(constraint, LinearConstraint.class, 245, 10055, 10064).getValue());
                    }
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 248, 10127, 10136)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 248, 10127, 10136);
                    if ((CallChecker.isCalled(constraint, LinearConstraint.class, 248, 10127, 10136).getRelationship()) == (Relationship.LEQ)) {
                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 249, 10195, 10200)) {
                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 249, 10195, 10200);
                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 249, 10195, 10200).setEntry(row, ((getSlackVariableOffset()) + (slackVar++)), 1);
                        }
                    }else
                        if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 250, 10292, 10301)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 250, 10292, 10301);
                            if ((CallChecker.isCalled(constraint, LinearConstraint.class, 250, 10292, 10301).getRelationship()) == (Relationship.GEQ)) {
                                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 251, 10360, 10365)) {
                                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 251, 10360, 10365);
                                    CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 251, 10360, 10365).setEntry(row, ((getSlackVariableOffset()) + (slackVar++)), (-1));
                                }
                            }
                        }
                    
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 255, 10503, 10512)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 256, 10576, 10585)) {
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 255, 10503, 10512);
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 256, 10576, 10585);
                        if (((CallChecker.isCalled(constraint, LinearConstraint.class, 255, 10503, 10512).getRelationship()) == (Relationship.EQ)) || ((CallChecker.isCalled(constraint, LinearConstraint.class, 256, 10576, 10585).getRelationship()) == (Relationship.GEQ))) {
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 257, 10645, 10650)) {
                                matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 257, 10645, 10650);
                                CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 257, 10645, 10650).setEntry(0, ((getArtificialVariableOffset()) + artificialVar), 1);
                            }
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 258, 10731, 10736)) {
                                matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 258, 10731, 10736);
                                CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 258, 10731, 10736).setEntry(row, ((getArtificialVariableOffset()) + (artificialVar++)), 1);
                            }
                            if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 259, 10844, 10849)) {
                                if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 259, 10876, 10881)) {
                                    matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 259, 10844, 10849);
                                    final RealVector npe_invocation_var23 = CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 259, 10844, 10849).getRowVector(0);
                                    if (CallChecker.beforeDeref(npe_invocation_var23, RealVector.class, 259, 10844, 10865)) {
                                        if (CallChecker.beforeDeref(matrix, Array2DRowRealMatrix.class, 259, 10821, 10826)) {
                                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 259, 10876, 10881);
                                            matrix = CallChecker.beforeCalled(matrix, Array2DRowRealMatrix.class, 259, 10821, 10826);
                                            CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 259, 10821, 10826).setRowVector(0, CallChecker.isCalled(npe_invocation_var23, RealVector.class, 259, 10844, 10865).subtract(CallChecker.isCalled(matrix, Array2DRowRealMatrix.class, 259, 10876, 10881).getRowVector(row)));
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
            _bcornu_methode_context198.methodEnd();
        }
    }

    public List<LinearConstraint> normalizeConstraints(Collection<LinearConstraint> originalConstraints) {
        MethodContext _bcornu_methode_context199 = new MethodContext(List.class, 271, 10963, 11519);
        try {
            CallChecker.varInit(this, "this", 271, 10963, 11519);
            CallChecker.varInit(originalConstraints, "originalConstraints", 271, 10963, 11519);
            CallChecker.varInit(this.cutOff, "cutOff", 271, 10963, 11519);
            CallChecker.varInit(this.maxUlps, "maxUlps", 271, 10963, 11519);
            CallChecker.varInit(this.epsilon, "epsilon", 271, 10963, 11519);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 271, 10963, 11519);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 271, 10963, 11519);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 271, 10963, 11519);
            CallChecker.varInit(this.tableau, "tableau", 271, 10963, 11519);
            CallChecker.varInit(this.columnLabels, "columnLabels", 271, 10963, 11519);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 271, 10963, 11519);
            CallChecker.varInit(this.constraints, "constraints", 271, 10963, 11519);
            CallChecker.varInit(this.f, "f", 271, 10963, 11519);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 271, 10963, 11519);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 271, 10963, 11519);
            List<LinearConstraint> normalized = CallChecker.varInit(new ArrayList<LinearConstraint>(), "normalized", 272, 11290, 11359);
            if (CallChecker.beforeDeref(originalConstraints, List.class, 273, 11404, 11422)) {
                for (LinearConstraint constraint : originalConstraints) {
                    if (CallChecker.beforeDeref(normalized, List.class, 274, 11439, 11448)) {
                        normalized = CallChecker.beforeCalled(normalized, List.class, 274, 11439, 11448);
                        CallChecker.isCalled(normalized, List.class, 274, 11439, 11448).add(normalize(constraint));
                    }
                }
            }
            return normalized;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    private LinearConstraint normalize(final LinearConstraint constraint) {
        MethodContext _bcornu_methode_context200 = new MethodContext(LinearConstraint.class, 284, 11526, 12229);
        try {
            CallChecker.varInit(this, "this", 284, 11526, 12229);
            CallChecker.varInit(constraint, "constraint", 284, 11526, 12229);
            CallChecker.varInit(this.cutOff, "cutOff", 284, 11526, 12229);
            CallChecker.varInit(this.maxUlps, "maxUlps", 284, 11526, 12229);
            CallChecker.varInit(this.epsilon, "epsilon", 284, 11526, 12229);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 284, 11526, 12229);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 284, 11526, 12229);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 284, 11526, 12229);
            CallChecker.varInit(this.tableau, "tableau", 284, 11526, 12229);
            CallChecker.varInit(this.columnLabels, "columnLabels", 284, 11526, 12229);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 284, 11526, 12229);
            CallChecker.varInit(this.constraints, "constraints", 284, 11526, 12229);
            CallChecker.varInit(this.f, "f", 284, 11526, 12229);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 284, 11526, 12229);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 284, 11526, 12229);
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 285, 11782, 11791)) {
                if ((CallChecker.isCalled(constraint, LinearConstraint.class, 285, 11782, 11791).getValue()) < 0) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 286, 11851, 11860)) {
                        final RealVector npe_invocation_var24 = CallChecker.isCalled(constraint, LinearConstraint.class, 286, 11851, 11860).getCoefficients();
                        if (CallChecker.beforeDeref(npe_invocation_var24, RealVector.class, 286, 11851, 11878)) {
                            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 287, 11937, 11946)) {
                                final Relationship npe_invocation_var25 = CallChecker.isCalled(constraint, LinearConstraint.class, 287, 11937, 11946).getRelationship();
                                if (CallChecker.beforeDeref(npe_invocation_var25, Relationship.class, 287, 11937, 11964)) {
                                    return new LinearConstraint(CallChecker.isCalled(npe_invocation_var24, RealVector.class, 286, 11851, 11878).mapMultiply((-1)), CallChecker.isCalled(npe_invocation_var25, Relationship.class, 287, 11937, 11964).oppositeRelationship(), ((-1) * (CallChecker.isCalled(constraint, LinearConstraint.class, 288, 12035, 12044).getValue())));
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
            
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 290, 12105, 12114)) {
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 291, 12171, 12180)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 291, 12201, 12210)) {
                        return new LinearConstraint(CallChecker.isCalled(constraint, LinearConstraint.class, 290, 12105, 12114).getCoefficients(), CallChecker.isCalled(constraint, LinearConstraint.class, 291, 12171, 12180).getRelationship(), CallChecker.isCalled(constraint, LinearConstraint.class, 291, 12201, 12210).getValue());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinearConstraint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    protected final int getNumObjectiveFunctions() {
        MethodContext _bcornu_methode_context201 = new MethodContext(int.class, 298, 12236, 12469);
        try {
            CallChecker.varInit(this, "this", 298, 12236, 12469);
            CallChecker.varInit(this.cutOff, "cutOff", 298, 12236, 12469);
            CallChecker.varInit(this.maxUlps, "maxUlps", 298, 12236, 12469);
            CallChecker.varInit(this.epsilon, "epsilon", 298, 12236, 12469);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 298, 12236, 12469);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 298, 12236, 12469);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 298, 12236, 12469);
            CallChecker.varInit(this.tableau, "tableau", 298, 12236, 12469);
            CallChecker.varInit(this.columnLabels, "columnLabels", 298, 12236, 12469);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 298, 12236, 12469);
            CallChecker.varInit(this.constraints, "constraints", 298, 12236, 12469);
            CallChecker.varInit(this.f, "f", 298, 12236, 12469);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 298, 12236, 12469);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 298, 12236, 12469);
            if ((this.numArtificialVariables) > 0) {
                return 2;
            }else {
                return 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    private int getConstraintTypeCounts(final Relationship relationship) {
        MethodContext _bcornu_methode_context202 = new MethodContext(int.class, 307, 12476, 12983);
        try {
            CallChecker.varInit(this, "this", 307, 12476, 12983);
            CallChecker.varInit(relationship, "relationship", 307, 12476, 12983);
            CallChecker.varInit(this.cutOff, "cutOff", 307, 12476, 12983);
            CallChecker.varInit(this.maxUlps, "maxUlps", 307, 12476, 12983);
            CallChecker.varInit(this.epsilon, "epsilon", 307, 12476, 12983);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 307, 12476, 12983);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 307, 12476, 12983);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 307, 12476, 12983);
            CallChecker.varInit(this.tableau, "tableau", 307, 12476, 12983);
            CallChecker.varInit(this.columnLabels, "columnLabels", 307, 12476, 12983);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 307, 12476, 12983);
            CallChecker.varInit(this.constraints, "constraints", 307, 12476, 12983);
            CallChecker.varInit(this.f, "f", 307, 12476, 12983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 307, 12476, 12983);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 307, 12476, 12983);
            int count = CallChecker.varInit(((int) (0)), "count", 308, 12765, 12778);
            if (CallChecker.beforeDeref(constraints, int.class, 309, 12829, 12839)) {
                for (final LinearConstraint constraint : constraints) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 310, 12860, 12869)) {
                        if ((CallChecker.isCalled(constraint, LinearConstraint.class, 310, 12860, 12869).getRelationship()) == relationship) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }

    protected static double getInvertedCoefficientSum(final RealVector coefficients) {
        MethodContext _bcornu_methode_context203 = new MethodContext(double.class, 322, 12990, 13434);
        try {
            CallChecker.varInit(coefficients, "coefficients", 322, 12990, 13434);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 322, 12990, 13434);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 322, 12990, 13434);
            double sum = CallChecker.varInit(((double) (0)), "sum", 323, 13292, 13306);
            for (double coefficient : CallChecker.isCalled(coefficients, RealVector.class, 324, 13342, 13353).toArray()) {
                sum -= coefficient;
                CallChecker.varAssign(sum, "sum", 325, 13380, 13398);
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context203.methodEnd();
        }
    }

    protected Integer getBasicRow(final int col) {
        MethodContext _bcornu_methode_context204 = new MethodContext(Integer.class, 335, 13441, 14053);
        try {
            CallChecker.varInit(this, "this", 335, 13441, 14053);
            CallChecker.varInit(col, "col", 335, 13441, 14053);
            CallChecker.varInit(this.cutOff, "cutOff", 335, 13441, 14053);
            CallChecker.varInit(this.maxUlps, "maxUlps", 335, 13441, 14053);
            CallChecker.varInit(this.epsilon, "epsilon", 335, 13441, 14053);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 335, 13441, 14053);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 335, 13441, 14053);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 335, 13441, 14053);
            CallChecker.varInit(this.tableau, "tableau", 335, 13441, 14053);
            CallChecker.varInit(this.columnLabels, "columnLabels", 335, 13441, 14053);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 335, 13441, 14053);
            CallChecker.varInit(this.constraints, "constraints", 335, 13441, 14053);
            CallChecker.varInit(this.f, "f", 335, 13441, 14053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 335, 13441, 14053);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 335, 13441, 14053);
            Integer row = CallChecker.varInit(null, "row", 336, 13695, 13713);
            for (int i = 0; i < (getHeight()); i++) {
                final double entry = CallChecker.varInit(((double) (getEntry(i, col))), "entry", 338, 13775, 13812);
                if ((Precision.equals(entry, 1.0, maxUlps)) && (row == null)) {
                    row = i;
                    CallChecker.varAssign(row, "row", 340, 13903, 13910);
                }else
                    if (!(Precision.equals(entry, 0.0, maxUlps))) {
                        return null;
                    }
                
            }
            return row;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    protected void dropPhase1Objective() {
        MethodContext _bcornu_methode_context205 = new MethodContext(void.class, 352, 14060, 15780);
        try {
            CallChecker.varInit(this, "this", 352, 14060, 15780);
            CallChecker.varInit(this.cutOff, "cutOff", 352, 14060, 15780);
            CallChecker.varInit(this.maxUlps, "maxUlps", 352, 14060, 15780);
            CallChecker.varInit(this.epsilon, "epsilon", 352, 14060, 15780);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 352, 14060, 15780);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 352, 14060, 15780);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 352, 14060, 15780);
            CallChecker.varInit(this.tableau, "tableau", 352, 14060, 15780);
            CallChecker.varInit(this.columnLabels, "columnLabels", 352, 14060, 15780);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 352, 14060, 15780);
            CallChecker.varInit(this.constraints, "constraints", 352, 14060, 15780);
            CallChecker.varInit(this.f, "f", 352, 14060, 15780);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 352, 14060, 15780);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 352, 14060, 15780);
            if ((getNumObjectiveFunctions()) == 1) {
                return ;
            }
            Set<Integer> columnsToDrop = CallChecker.varInit(new TreeSet<Integer>(), "columnsToDrop", 357, 14353, 14404);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 358, 14414, 14426)) {
                columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 358, 14414, 14426);
                CallChecker.isCalled(columnsToDrop, Set.class, 358, 14414, 14426).add(0);
            }
            for (int i = getNumObjectiveFunctions(); i < (getArtificialVariableOffset()); i++) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 362, 14611, 14617);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(this.tableau, RealMatrix.class, 362, 14611, 14617).getEntry(0, i))), "entry", 362, 14590, 14633);
                if ((Precision.compareTo(entry, 0.0, epsilon)) > 0) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 364, 14714, 14726)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 364, 14714, 14726);
                        CallChecker.isCalled(columnsToDrop, Set.class, 364, 14714, 14726).add(i);
                    }
                }
            }
            for (int i = 0; i < (getNumArtificialVariables()); i++) {
                int col = CallChecker.varInit(((int) (i + (getArtificialVariableOffset()))), "col", 370, 14879, 14922);
                if ((getBasicRow(col)) == null) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 372, 14984, 14996)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 372, 14984, 14996);
                        CallChecker.isCalled(columnsToDrop, Set.class, 372, 14984, 14996).add(col);
                    }
                }
            }
            double[][] matrix = CallChecker.init(double[][].class);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 376, 15102, 15114)) {
                columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 376, 15102, 15114);
                matrix = new double[(getHeight()) - 1][(getWidth()) - (CallChecker.isCalled(columnsToDrop, Set.class, 376, 15102, 15114).size())];
                CallChecker.varAssign(matrix, "matrix", 376, 15102, 15114);
            }
            for (int i = 1; i < (getHeight()); i++) {
                int col = CallChecker.varInit(((int) (0)), "col", 378, 15185, 15196);
                for (int j = 0; j < (getWidth()); j++) {
                    if (CallChecker.beforeDeref(columnsToDrop, Set.class, 380, 15270, 15282)) {
                        columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 380, 15270, 15282);
                        if (!(CallChecker.isCalled(columnsToDrop, Set.class, 380, 15270, 15282).contains(j))) {
                            if (CallChecker.beforeDeref(matrix, double[][].class, 381, 15319, 15324)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 381, 15319, 15324);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)], double[].class, 381, 15319, 15331)) {
                                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 381, 15342, 15348)) {
                                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 381, 15319, 15324);
                                        CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)], double[].class, 381, 15319, 15331);
                                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 381, 15342, 15348);
                                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)], double[].class, 381, 15319, 15331)[(col++)] = CallChecker.isCalled(tableau, RealMatrix.class, 381, 15342, 15348).getEntry(i, j);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)], double[].class, 381, 15319, 15331)[(col - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 381, 15319, 15324)[(i - 1)], double[].class, 381, 15319, 15331)[(col - 1)]", 381, 15319, 15364);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Integer[] drop = CallChecker.init(Integer[].class);
            if (CallChecker.beforeDeref(columnsToDrop, Set.class, 387, 15542, 15554)) {
                if (CallChecker.beforeDeref(columnsToDrop, Set.class, 387, 15508, 15520)) {
                    columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 387, 15542, 15554);
                    columnsToDrop = CallChecker.beforeCalled(columnsToDrop, Set.class, 387, 15508, 15520);
                    drop = CallChecker.isCalled(columnsToDrop, Set.class, 387, 15508, 15520).toArray(new Integer[CallChecker.isCalled(columnsToDrop, Set.class, 387, 15542, 15554).size()]);
                    CallChecker.varAssign(drop, "drop", 387, 15542, 15554);
                }
            }
            drop = CallChecker.beforeCalled(drop, Integer[].class, 388, 15587, 15590);
            for (int i = (CallChecker.isCalled(drop, Integer[].class, 388, 15587, 15590).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(drop, Integer[].class, 389, 15657, 15660)) {
                    if (CallChecker.beforeDeref(columnLabels, List.class, 389, 15631, 15642)) {
                        drop = CallChecker.beforeCalled(drop, Integer[].class, 389, 15657, 15660);
                        CallChecker.isCalled(columnLabels, List.class, 389, 15631, 15642).remove(((int) (CallChecker.isCalled(drop, Integer[].class, 389, 15657, 15660)[i])));
                    }
                }
            }
            this.tableau = new Array2DRowRealMatrix(matrix);
            CallChecker.varAssign(this.tableau, "this.tableau", 392, 15686, 15733);
            this.numArtificialVariables = 0;
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 393, 15743, 15774);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    private void copyArray(final double[] src, final double[] dest) {
        MethodContext _bcornu_methode_context206 = new MethodContext(void.class, 400, 15787, 16029);
        try {
            CallChecker.varInit(this, "this", 400, 15787, 16029);
            CallChecker.varInit(dest, "dest", 400, 15787, 16029);
            CallChecker.varInit(src, "src", 400, 15787, 16029);
            CallChecker.varInit(this.cutOff, "cutOff", 400, 15787, 16029);
            CallChecker.varInit(this.maxUlps, "maxUlps", 400, 15787, 16029);
            CallChecker.varInit(this.epsilon, "epsilon", 400, 15787, 16029);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 400, 15787, 16029);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 400, 15787, 16029);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 400, 15787, 16029);
            CallChecker.varInit(this.tableau, "tableau", 400, 15787, 16029);
            CallChecker.varInit(this.columnLabels, "columnLabels", 400, 15787, 16029);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 400, 15787, 16029);
            CallChecker.varInit(this.constraints, "constraints", 400, 15787, 16029);
            CallChecker.varInit(this.f, "f", 400, 15787, 16029);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 400, 15787, 16029);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 400, 15787, 16029);
            if (CallChecker.beforeDeref(src, double[].class, 401, 16012, 16014)) {
                System.arraycopy(src, 0, dest, getNumObjectiveFunctions(), CallChecker.isCalled(src, double[].class, 401, 16012, 16014).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }

    boolean isOptimal() {
        MethodContext _bcornu_methode_context207 = new MethodContext(boolean.class, 408, 16036, 16457);
        try {
            CallChecker.varInit(this, "this", 408, 16036, 16457);
            CallChecker.varInit(this.cutOff, "cutOff", 408, 16036, 16457);
            CallChecker.varInit(this.maxUlps, "maxUlps", 408, 16036, 16457);
            CallChecker.varInit(this.epsilon, "epsilon", 408, 16036, 16457);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 408, 16036, 16457);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 408, 16036, 16457);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 408, 16036, 16457);
            CallChecker.varInit(this.tableau, "tableau", 408, 16036, 16457);
            CallChecker.varInit(this.columnLabels, "columnLabels", 408, 16036, 16457);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 408, 16036, 16457);
            CallChecker.varInit(this.constraints, "constraints", 408, 16036, 16457);
            CallChecker.varInit(this.f, "f", 408, 16036, 16457);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 408, 16036, 16457);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 408, 16036, 16457);
            for (int i = getNumObjectiveFunctions(); i < ((getWidth()) - 1); i++) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 410, 16291, 16297);
                final double entry = CallChecker.varInit(((double) (CallChecker.isCalled(this.tableau, RealMatrix.class, 410, 16291, 16297).getEntry(0, i))), "entry", 410, 16270, 16313);
                if ((Precision.compareTo(entry, 0.0, epsilon)) < 0) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context207.methodEnd();
        }
    }

    protected PointValuePair getSolution() {
        MethodContext _bcornu_methode_context208 = new MethodContext(PointValuePair.class, 422, 16464, 18230);
        try {
            CallChecker.varInit(this, "this", 422, 16464, 18230);
            CallChecker.varInit(this.cutOff, "cutOff", 422, 16464, 18230);
            CallChecker.varInit(this.maxUlps, "maxUlps", 422, 16464, 18230);
            CallChecker.varInit(this.epsilon, "epsilon", 422, 16464, 18230);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 422, 16464, 18230);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 422, 16464, 18230);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 422, 16464, 18230);
            CallChecker.varInit(this.tableau, "tableau", 422, 16464, 18230);
            CallChecker.varInit(this.columnLabels, "columnLabels", 422, 16464, 18230);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 422, 16464, 18230);
            CallChecker.varInit(this.constraints, "constraints", 422, 16464, 18230);
            CallChecker.varInit(this.f, "f", 422, 16464, 18230);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 422, 16464, 18230);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 422, 16464, 18230);
            int negativeVarColumn = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(columnLabels, List.class, 423, 16618, 16629)) {
                negativeVarColumn = CallChecker.isCalled(columnLabels, List.class, 423, 16618, 16629).indexOf(SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL);
                CallChecker.varAssign(negativeVarColumn, "negativeVarColumn", 423, 16618, 16629);
            }
            Integer negativeVarBasicRow = CallChecker.init(Integer.class);
            if (negativeVarColumn > 0) {
                negativeVarBasicRow = getBasicRow(negativeVarColumn);
                CallChecker.varAssign(negativeVarBasicRow, "negativeVarBasicRow", 424, 16705, 16765);
            }else {
                negativeVarBasicRow = null;
                CallChecker.varAssign(negativeVarBasicRow, "negativeVarBasicRow", 424, 16705, 16765);
            }
            double mostNegative = CallChecker.init(double.class);
            if (negativeVarBasicRow == null) {
                mostNegative = 0;
                CallChecker.varAssign(mostNegative, "mostNegative", 425, 16798, 16876);
            }else {
                mostNegative = getEntry(negativeVarBasicRow, getRhsOffset());
                CallChecker.varAssign(mostNegative, "mostNegative", 425, 16798, 16876);
            }
            Set<Integer> basicRows = CallChecker.varInit(new HashSet<Integer>(), "basicRows", 427, 16888, 16935);
            double[] coefficients = CallChecker.varInit(new double[getOriginalNumDecisionVariables()], "coefficients", 428, 16945, 17014);
            coefficients = CallChecker.beforeCalled(coefficients, double[].class, 429, 17044, 17055);
            for (int i = 0; i < (CallChecker.isCalled(coefficients, double[].class, 429, 17044, 17055).length); i++) {
                int colIndex = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(columnLabels, List.class, 430, 17099, 17110)) {
                    colIndex = CallChecker.isCalled(columnLabels, List.class, 430, 17099, 17110).indexOf(("x" + i));
                    CallChecker.varAssign(colIndex, "colIndex", 430, 17099, 17110);
                }
                if (colIndex < 0) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 432, 17178, 17189)) {
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 432, 17178, 17189);
                        CallChecker.isCalled(coefficients, double[].class, 432, 17178, 17189)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 432, 17178, 17189)[i], "CallChecker.isCalled(coefficients, double[].class, 432, 17178, 17189)[i]", 432, 17178, 17197);
                    }
                    continue;
                }
                Integer basicRow = CallChecker.varInit(getBasicRow(colIndex), "basicRow", 435, 17251, 17291);
                if ((basicRow != null) && (basicRow == 0)) {
                    if (CallChecker.beforeDeref(coefficients, double[].class, 440, 17594, 17605)) {
                        coefficients = CallChecker.beforeCalled(coefficients, double[].class, 440, 17594, 17605);
                        CallChecker.isCalled(coefficients, double[].class, 440, 17594, 17605)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 440, 17594, 17605)[i], "CallChecker.isCalled(coefficients, double[].class, 440, 17594, 17605)[i]", 440, 17594, 17613);
                    }
                }else
                    if (CallChecker.beforeDeref(basicRows, Set.class, 441, 17638, 17646)) {
                        basicRows = CallChecker.beforeCalled(basicRows, Set.class, 441, 17638, 17646);
                        if (CallChecker.isCalled(basicRows, Set.class, 441, 17638, 17646).contains(basicRow)) {
                            if (restrictToNonNegative) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 444, 17822, 17833)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 444, 17822, 17833);
                                    CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i] = 0 - 0;
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i], "CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i]", 444, 17822, 17886);
                                }
                            }else {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 444, 17822, 17833)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 444, 17822, 17833);
                                    CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i] = 0 - mostNegative;
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i], "CallChecker.isCalled(coefficients, double[].class, 444, 17822, 17833)[i]", 444, 17822, 17886);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(basicRows, Set.class, 446, 17925, 17933)) {
                                basicRows = CallChecker.beforeCalled(basicRows, Set.class, 446, 17925, 17933);
                                CallChecker.isCalled(basicRows, Set.class, 446, 17925, 17933).add(basicRow);
                            }
                            if (basicRow == null) {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 447, 17966, 17977)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 447, 17966, 17977);
                                    CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i] = 0 - (restrictToNonNegative ? 0 : mostNegative);
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i], "CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i]", 447, 17966, 18128);
                                }
                            }else {
                                if (CallChecker.beforeDeref(coefficients, double[].class, 447, 17966, 17977)) {
                                    coefficients = CallChecker.beforeCalled(coefficients, double[].class, 447, 17966, 17977);
                                    CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i] = (getEntry(basicRow, getRhsOffset())) - (restrictToNonNegative ? 0 : mostNegative);
                                    CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i], "CallChecker.isCalled(coefficients, double[].class, 447, 17966, 17977)[i]", 447, 17966, 18128);
                                }
                            }
                        }
                    }
                
            }
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 452, 18202, 18202)) {
                return new PointValuePair(coefficients, CallChecker.isCalled(f, LinearObjectiveFunction.class, 452, 18202, 18202).value(coefficients));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    protected void divideRow(final int dividendRow, final double divisor) {
        MethodContext _bcornu_methode_context209 = new MethodContext(void.class, 464, 18237, 18771);
        try {
            CallChecker.varInit(this, "this", 464, 18237, 18771);
            CallChecker.varInit(divisor, "divisor", 464, 18237, 18771);
            CallChecker.varInit(dividendRow, "dividendRow", 464, 18237, 18771);
            CallChecker.varInit(this.cutOff, "cutOff", 464, 18237, 18771);
            CallChecker.varInit(this.maxUlps, "maxUlps", 464, 18237, 18771);
            CallChecker.varInit(this.epsilon, "epsilon", 464, 18237, 18771);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 464, 18237, 18771);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 464, 18237, 18771);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 464, 18237, 18771);
            CallChecker.varInit(this.tableau, "tableau", 464, 18237, 18771);
            CallChecker.varInit(this.columnLabels, "columnLabels", 464, 18237, 18771);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 464, 18237, 18771);
            CallChecker.varInit(this.constraints, "constraints", 464, 18237, 18771);
            CallChecker.varInit(this.f, "f", 464, 18237, 18771);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 464, 18237, 18771);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 464, 18237, 18771);
            for (int j = 0; j < (getWidth()); j++) {
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 466, 18712, 18718)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 466, 18679, 18685)) {
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 466, 18712, 18718);
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 466, 18679, 18685);
                        CallChecker.isCalled(tableau, RealMatrix.class, 466, 18679, 18685).setEntry(dividendRow, j, ((CallChecker.isCalled(tableau, RealMatrix.class, 466, 18712, 18718).getEntry(dividendRow, j)) / divisor));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }

    protected void subtractRow(final int minuendRow, final int subtrahendRow, final double multiple) {
        MethodContext _bcornu_methode_context210 = new MethodContext(void.class, 480, 18778, 19679);
        try {
            CallChecker.varInit(this, "this", 480, 18778, 19679);
            CallChecker.varInit(multiple, "multiple", 480, 18778, 19679);
            CallChecker.varInit(subtrahendRow, "subtrahendRow", 480, 18778, 19679);
            CallChecker.varInit(minuendRow, "minuendRow", 480, 18778, 19679);
            CallChecker.varInit(this.cutOff, "cutOff", 480, 18778, 19679);
            CallChecker.varInit(this.maxUlps, "maxUlps", 480, 18778, 19679);
            CallChecker.varInit(this.epsilon, "epsilon", 480, 18778, 19679);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 480, 18778, 19679);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 480, 18778, 19679);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 480, 18778, 19679);
            CallChecker.varInit(this.tableau, "tableau", 480, 18778, 19679);
            CallChecker.varInit(this.columnLabels, "columnLabels", 480, 18778, 19679);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 480, 18778, 19679);
            CallChecker.varInit(this.constraints, "constraints", 480, 18778, 19679);
            CallChecker.varInit(this.f, "f", 480, 18778, 19679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 480, 18778, 19679);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 480, 18778, 19679);
            for (int i = 0; i < (getWidth()); i++) {
                double result = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 483, 19326, 19332)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 483, 19360, 19366)) {
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 483, 19326, 19332);
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 483, 19360, 19366);
                        result = (CallChecker.isCalled(tableau, RealMatrix.class, 483, 19326, 19332).getEntry(minuendRow, i)) - ((CallChecker.isCalled(tableau, RealMatrix.class, 483, 19360, 19366).getEntry(subtrahendRow, i)) * multiple);
                        CallChecker.varAssign(result, "result", 483, 19326, 19332);
                    }
                }
                if ((FastMath.abs(result)) < (cutOff)) {
                    result = 0.0;
                    CallChecker.varAssign(result, "result", 486, 19584, 19596);
                }
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 488, 19624, 19630)) {
                    tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 488, 19624, 19630);
                    CallChecker.isCalled(tableau, RealMatrix.class, 488, 19624, 19630).setEntry(minuendRow, i, result);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context210.methodEnd();
        }
    }

    protected final int getWidth() {
        MethodContext _bcornu_methode_context211 = new MethodContext(int.class, 496, 19686, 19857);
        try {
            CallChecker.varInit(this, "this", 496, 19686, 19857);
            CallChecker.varInit(this.cutOff, "cutOff", 496, 19686, 19857);
            CallChecker.varInit(this.maxUlps, "maxUlps", 496, 19686, 19857);
            CallChecker.varInit(this.epsilon, "epsilon", 496, 19686, 19857);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 496, 19686, 19857);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 496, 19686, 19857);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 496, 19686, 19857);
            CallChecker.varInit(this.tableau, "tableau", 496, 19686, 19857);
            CallChecker.varInit(this.columnLabels, "columnLabels", 496, 19686, 19857);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 496, 19686, 19857);
            CallChecker.varInit(this.constraints, "constraints", 496, 19686, 19857);
            CallChecker.varInit(this.f, "f", 496, 19686, 19857);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 496, 19686, 19857);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 496, 19686, 19857);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 497, 19823, 19829)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 497, 19823, 19829);
                return CallChecker.isCalled(tableau, RealMatrix.class, 497, 19823, 19829).getColumnDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    protected final int getHeight() {
        MethodContext _bcornu_methode_context212 = new MethodContext(int.class, 504, 19864, 20035);
        try {
            CallChecker.varInit(this, "this", 504, 19864, 20035);
            CallChecker.varInit(this.cutOff, "cutOff", 504, 19864, 20035);
            CallChecker.varInit(this.maxUlps, "maxUlps", 504, 19864, 20035);
            CallChecker.varInit(this.epsilon, "epsilon", 504, 19864, 20035);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 504, 19864, 20035);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 504, 19864, 20035);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 504, 19864, 20035);
            CallChecker.varInit(this.tableau, "tableau", 504, 19864, 20035);
            CallChecker.varInit(this.columnLabels, "columnLabels", 504, 19864, 20035);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 504, 19864, 20035);
            CallChecker.varInit(this.constraints, "constraints", 504, 19864, 20035);
            CallChecker.varInit(this.f, "f", 504, 19864, 20035);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 504, 19864, 20035);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 504, 19864, 20035);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 505, 20004, 20010)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 505, 20004, 20010);
                return CallChecker.isCalled(tableau, RealMatrix.class, 505, 20004, 20010).getRowDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }

    protected final double getEntry(final int row, final int column) {
        MethodContext _bcornu_methode_context213 = new MethodContext(double.class, 514, 20042, 20311);
        try {
            CallChecker.varInit(this, "this", 514, 20042, 20311);
            CallChecker.varInit(column, "column", 514, 20042, 20311);
            CallChecker.varInit(row, "row", 514, 20042, 20311);
            CallChecker.varInit(this.cutOff, "cutOff", 514, 20042, 20311);
            CallChecker.varInit(this.maxUlps, "maxUlps", 514, 20042, 20311);
            CallChecker.varInit(this.epsilon, "epsilon", 514, 20042, 20311);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 514, 20042, 20311);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 514, 20042, 20311);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 514, 20042, 20311);
            CallChecker.varInit(this.tableau, "tableau", 514, 20042, 20311);
            CallChecker.varInit(this.columnLabels, "columnLabels", 514, 20042, 20311);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 514, 20042, 20311);
            CallChecker.varInit(this.constraints, "constraints", 514, 20042, 20311);
            CallChecker.varInit(this.f, "f", 514, 20042, 20311);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 514, 20042, 20311);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 514, 20042, 20311);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 515, 20276, 20282)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 515, 20276, 20282);
                return CallChecker.isCalled(tableau, RealMatrix.class, 515, 20276, 20282).getEntry(row, column);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context213.methodEnd();
        }
    }

    protected final void setEntry(final int row, final int column, final double value) {
        MethodContext _bcornu_methode_context214 = new MethodContext(void.class, 524, 20318, 20635);
        try {
            CallChecker.varInit(this, "this", 524, 20318, 20635);
            CallChecker.varInit(value, "value", 524, 20318, 20635);
            CallChecker.varInit(column, "column", 524, 20318, 20635);
            CallChecker.varInit(row, "row", 524, 20318, 20635);
            CallChecker.varInit(this.cutOff, "cutOff", 524, 20318, 20635);
            CallChecker.varInit(this.maxUlps, "maxUlps", 524, 20318, 20635);
            CallChecker.varInit(this.epsilon, "epsilon", 524, 20318, 20635);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 524, 20318, 20635);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 524, 20318, 20635);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 524, 20318, 20635);
            CallChecker.varInit(this.tableau, "tableau", 524, 20318, 20635);
            CallChecker.varInit(this.columnLabels, "columnLabels", 524, 20318, 20635);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 524, 20318, 20635);
            CallChecker.varInit(this.constraints, "constraints", 524, 20318, 20635);
            CallChecker.varInit(this.f, "f", 524, 20318, 20635);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 524, 20318, 20635);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 524, 20318, 20635);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 526, 20593, 20599)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 526, 20593, 20599);
                CallChecker.isCalled(tableau, RealMatrix.class, 526, 20593, 20599).setEntry(row, column, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context214.methodEnd();
        }
    }

    protected final int getSlackVariableOffset() {
        MethodContext _bcornu_methode_context215 = new MethodContext(int.class, 533, 20642, 20876);
        try {
            CallChecker.varInit(this, "this", 533, 20642, 20876);
            CallChecker.varInit(this.cutOff, "cutOff", 533, 20642, 20876);
            CallChecker.varInit(this.maxUlps, "maxUlps", 533, 20642, 20876);
            CallChecker.varInit(this.epsilon, "epsilon", 533, 20642, 20876);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 533, 20642, 20876);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 533, 20642, 20876);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 533, 20642, 20876);
            CallChecker.varInit(this.tableau, "tableau", 533, 20642, 20876);
            CallChecker.varInit(this.columnLabels, "columnLabels", 533, 20642, 20876);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 533, 20642, 20876);
            CallChecker.varInit(this.constraints, "constraints", 533, 20642, 20876);
            CallChecker.varInit(this.f, "f", 533, 20642, 20876);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 533, 20642, 20876);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 533, 20642, 20876);
            return (getNumObjectiveFunctions()) + (numDecisionVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context215.methodEnd();
        }
    }

    protected final int getArtificialVariableOffset() {
        MethodContext _bcornu_methode_context216 = new MethodContext(int.class, 541, 20883, 21152);
        try {
            CallChecker.varInit(this, "this", 541, 20883, 21152);
            CallChecker.varInit(this.cutOff, "cutOff", 541, 20883, 21152);
            CallChecker.varInit(this.maxUlps, "maxUlps", 541, 20883, 21152);
            CallChecker.varInit(this.epsilon, "epsilon", 541, 20883, 21152);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 541, 20883, 21152);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 541, 20883, 21152);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 541, 20883, 21152);
            CallChecker.varInit(this.tableau, "tableau", 541, 20883, 21152);
            CallChecker.varInit(this.columnLabels, "columnLabels", 541, 20883, 21152);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 541, 20883, 21152);
            CallChecker.varInit(this.constraints, "constraints", 541, 20883, 21152);
            CallChecker.varInit(this.f, "f", 541, 20883, 21152);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 541, 20883, 21152);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 541, 20883, 21152);
            return ((getNumObjectiveFunctions()) + (numDecisionVariables)) + (numSlackVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context216.methodEnd();
        }
    }

    protected final int getRhsOffset() {
        MethodContext _bcornu_methode_context217 = new MethodContext(int.class, 549, 21159, 21338);
        try {
            CallChecker.varInit(this, "this", 549, 21159, 21338);
            CallChecker.varInit(this.cutOff, "cutOff", 549, 21159, 21338);
            CallChecker.varInit(this.maxUlps, "maxUlps", 549, 21159, 21338);
            CallChecker.varInit(this.epsilon, "epsilon", 549, 21159, 21338);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 549, 21159, 21338);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 549, 21159, 21338);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 549, 21159, 21338);
            CallChecker.varInit(this.tableau, "tableau", 549, 21159, 21338);
            CallChecker.varInit(this.columnLabels, "columnLabels", 549, 21159, 21338);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 549, 21159, 21338);
            CallChecker.varInit(this.constraints, "constraints", 549, 21159, 21338);
            CallChecker.varInit(this.f, "f", 549, 21159, 21338);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 549, 21159, 21338);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 549, 21159, 21338);
            return (getWidth()) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context217.methodEnd();
        }
    }

    protected final int getNumDecisionVariables() {
        MethodContext _bcornu_methode_context218 = new MethodContext(int.class, 562, 21345, 21777);
        try {
            CallChecker.varInit(this, "this", 562, 21345, 21777);
            CallChecker.varInit(this.cutOff, "cutOff", 562, 21345, 21777);
            CallChecker.varInit(this.maxUlps, "maxUlps", 562, 21345, 21777);
            CallChecker.varInit(this.epsilon, "epsilon", 562, 21345, 21777);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 562, 21345, 21777);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 562, 21345, 21777);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 562, 21345, 21777);
            CallChecker.varInit(this.tableau, "tableau", 562, 21345, 21777);
            CallChecker.varInit(this.columnLabels, "columnLabels", 562, 21345, 21777);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 562, 21345, 21777);
            CallChecker.varInit(this.constraints, "constraints", 562, 21345, 21777);
            CallChecker.varInit(this.f, "f", 562, 21345, 21777);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 562, 21345, 21777);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 562, 21345, 21777);
            return numDecisionVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context218.methodEnd();
        }
    }

    protected final int getOriginalNumDecisionVariables() {
        MethodContext _bcornu_methode_context219 = new MethodContext(int.class, 571, 21784, 22057);
        try {
            CallChecker.varInit(this, "this", 571, 21784, 22057);
            CallChecker.varInit(this.cutOff, "cutOff", 571, 21784, 22057);
            CallChecker.varInit(this.maxUlps, "maxUlps", 571, 21784, 22057);
            CallChecker.varInit(this.epsilon, "epsilon", 571, 21784, 22057);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 571, 21784, 22057);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 571, 21784, 22057);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 571, 21784, 22057);
            CallChecker.varInit(this.tableau, "tableau", 571, 21784, 22057);
            CallChecker.varInit(this.columnLabels, "columnLabels", 571, 21784, 22057);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 571, 21784, 22057);
            CallChecker.varInit(this.constraints, "constraints", 571, 21784, 22057);
            CallChecker.varInit(this.f, "f", 571, 21784, 22057);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 571, 21784, 22057);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 571, 21784, 22057);
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 572, 22017, 22017)) {
                final RealVector npe_invocation_var26 = CallChecker.isCalled(f, LinearObjectiveFunction.class, 572, 22017, 22017).getCoefficients();
                if (CallChecker.beforeDeref(npe_invocation_var26, RealVector.class, 572, 22017, 22035)) {
                    return CallChecker.isCalled(npe_invocation_var26, RealVector.class, 572, 22017, 22035).getDimension();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context219.methodEnd();
        }
    }

    protected final int getNumSlackVariables() {
        MethodContext _bcornu_methode_context220 = new MethodContext(int.class, 579, 22064, 22246);
        try {
            CallChecker.varInit(this, "this", 579, 22064, 22246);
            CallChecker.varInit(this.cutOff, "cutOff", 579, 22064, 22246);
            CallChecker.varInit(this.maxUlps, "maxUlps", 579, 22064, 22246);
            CallChecker.varInit(this.epsilon, "epsilon", 579, 22064, 22246);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 579, 22064, 22246);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 579, 22064, 22246);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 579, 22064, 22246);
            CallChecker.varInit(this.tableau, "tableau", 579, 22064, 22246);
            CallChecker.varInit(this.columnLabels, "columnLabels", 579, 22064, 22246);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 579, 22064, 22246);
            CallChecker.varInit(this.constraints, "constraints", 579, 22064, 22246);
            CallChecker.varInit(this.f, "f", 579, 22064, 22246);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 579, 22064, 22246);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 579, 22064, 22246);
            return numSlackVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context220.methodEnd();
        }
    }

    protected final int getNumArtificialVariables() {
        MethodContext _bcornu_methode_context221 = new MethodContext(int.class, 587, 22253, 22455);
        try {
            CallChecker.varInit(this, "this", 587, 22253, 22455);
            CallChecker.varInit(this.cutOff, "cutOff", 587, 22253, 22455);
            CallChecker.varInit(this.maxUlps, "maxUlps", 587, 22253, 22455);
            CallChecker.varInit(this.epsilon, "epsilon", 587, 22253, 22455);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 587, 22253, 22455);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 587, 22253, 22455);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 587, 22253, 22455);
            CallChecker.varInit(this.tableau, "tableau", 587, 22253, 22455);
            CallChecker.varInit(this.columnLabels, "columnLabels", 587, 22253, 22455);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 587, 22253, 22455);
            CallChecker.varInit(this.constraints, "constraints", 587, 22253, 22455);
            CallChecker.varInit(this.f, "f", 587, 22253, 22455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 587, 22253, 22455);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 587, 22253, 22455);
            return numArtificialVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context221.methodEnd();
        }
    }

    protected final double[][] getData() {
        MethodContext _bcornu_methode_context222 = new MethodContext(double[][].class, 595, 22462, 22612);
        try {
            CallChecker.varInit(this, "this", 595, 22462, 22612);
            CallChecker.varInit(this.cutOff, "cutOff", 595, 22462, 22612);
            CallChecker.varInit(this.maxUlps, "maxUlps", 595, 22462, 22612);
            CallChecker.varInit(this.epsilon, "epsilon", 595, 22462, 22612);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 595, 22462, 22612);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 595, 22462, 22612);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 595, 22462, 22612);
            CallChecker.varInit(this.tableau, "tableau", 595, 22462, 22612);
            CallChecker.varInit(this.columnLabels, "columnLabels", 595, 22462, 22612);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 595, 22462, 22612);
            CallChecker.varInit(this.constraints, "constraints", 595, 22462, 22612);
            CallChecker.varInit(this.f, "f", 595, 22462, 22612);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 595, 22462, 22612);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 595, 22462, 22612);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 596, 22589, 22595)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 596, 22589, 22595);
                return CallChecker.isCalled(tableau, RealMatrix.class, 596, 22589, 22595).getData();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context222.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context223 = new MethodContext(boolean.class, 600, 22619, 23411);
        try {
            CallChecker.varInit(this, "this", 600, 22619, 23411);
            CallChecker.varInit(other, "other", 600, 22619, 23411);
            CallChecker.varInit(this.cutOff, "cutOff", 600, 22619, 23411);
            CallChecker.varInit(this.maxUlps, "maxUlps", 600, 22619, 23411);
            CallChecker.varInit(this.epsilon, "epsilon", 600, 22619, 23411);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 600, 22619, 23411);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 600, 22619, 23411);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 600, 22619, 23411);
            CallChecker.varInit(this.tableau, "tableau", 600, 22619, 23411);
            CallChecker.varInit(this.columnLabels, "columnLabels", 600, 22619, 23411);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 600, 22619, 23411);
            CallChecker.varInit(this.constraints, "constraints", 600, 22619, 23411);
            CallChecker.varInit(this.f, "f", 600, 22619, 23411);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 600, 22619, 23411);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 600, 22619, 23411);
            if ((this) == other) {
                return true;
            }
            if (other instanceof SimplexTableau) {
                SimplexTableau rhs = CallChecker.varInit(((SimplexTableau) (other)), "rhs", 607, 22784, 22827);
                if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 614, 23267, 23269)) {
                    if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 615, 23313, 23315)) {
                        if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 616, 23365, 23367)) {
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 608, 22873, 22875);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 609, 22947, 22949);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 610, 23020, 23022);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 611, 23090, 23092);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 612, 23165, 23167);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 613, 23225, 23227);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 614, 23267, 23269);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 615, 23313, 23315);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 616, 23365, 23367);
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 616, 23350, 23356);
                            return (((((((((restrictToNonNegative) == (CallChecker.isCalled(rhs, SimplexTableau.class, 608, 22873, 22875).restrictToNonNegative)) && ((numDecisionVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 609, 22947, 22949).numDecisionVariables))) && ((numSlackVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 610, 23020, 23022).numSlackVariables))) && ((numArtificialVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 611, 23090, 23092).numArtificialVariables))) && ((epsilon) == (CallChecker.isCalled(rhs, SimplexTableau.class, 612, 23165, 23167).epsilon))) && ((maxUlps) == (CallChecker.isCalled(rhs, SimplexTableau.class, 613, 23225, 23227).maxUlps))) && (CallChecker.isCalled(f, LinearObjectiveFunction.class, 614, 23258, 23258).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 614, 23267, 23269).f))) && (CallChecker.isCalled(constraints, List.class, 615, 23294, 23304).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 615, 23313, 23315).constraints))) && (CallChecker.isCalled(tableau, RealMatrix.class, 616, 23350, 23356).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 616, 23365, 23367).tableau));
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
            _bcornu_methode_context223.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context224 = new MethodContext(int.class, 622, 23418, 23822);
        try {
            CallChecker.varInit(this, "this", 622, 23418, 23822);
            CallChecker.varInit(this.cutOff, "cutOff", 622, 23418, 23822);
            CallChecker.varInit(this.maxUlps, "maxUlps", 622, 23418, 23822);
            CallChecker.varInit(this.epsilon, "epsilon", 622, 23418, 23822);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 622, 23418, 23822);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 622, 23418, 23822);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 622, 23418, 23822);
            CallChecker.varInit(this.tableau, "tableau", 622, 23418, 23822);
            CallChecker.varInit(this.columnLabels, "columnLabels", 622, 23418, 23822);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 622, 23418, 23822);
            CallChecker.varInit(this.constraints, "constraints", 622, 23418, 23822);
            CallChecker.varInit(this.f, "f", 622, 23418, 23822);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 622, 23418, 23822);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 622, 23418, 23822);
            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 631, 23798, 23804);
            return ((((((((CallChecker.isCalled(Boolean.valueOf(restrictToNonNegative), Boolean.class, 623, 23471, 23508).hashCode()) ^ (numDecisionVariables)) ^ (numSlackVariables)) ^ (numArtificialVariables)) ^ (CallChecker.isCalled(Double.valueOf(epsilon), Double.class, 627, 23651, 23673).hashCode())) ^ (maxUlps)) ^ (CallChecker.isCalled(f, LinearObjectiveFunction.class, 629, 23728, 23728).hashCode())) ^ (CallChecker.isCalled(constraints, List.class, 630, 23758, 23768).hashCode())) ^ (CallChecker.isCalled(tableau, RealMatrix.class, 631, 23798, 23804).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context224.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context225 = new MethodContext(void.class, 639, 23829, 24168);
        try {
            CallChecker.varInit(this, "this", 639, 23829, 24168);
            CallChecker.varInit(oos, "oos", 639, 23829, 24168);
            CallChecker.varInit(this.cutOff, "cutOff", 639, 23829, 24168);
            CallChecker.varInit(this.maxUlps, "maxUlps", 639, 23829, 24168);
            CallChecker.varInit(this.epsilon, "epsilon", 639, 23829, 24168);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 639, 23829, 24168);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 639, 23829, 24168);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 639, 23829, 24168);
            CallChecker.varInit(this.tableau, "tableau", 639, 23829, 24168);
            CallChecker.varInit(this.columnLabels, "columnLabels", 639, 23829, 24168);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 639, 23829, 24168);
            CallChecker.varInit(this.constraints, "constraints", 639, 23829, 24168);
            CallChecker.varInit(this.f, "f", 639, 23829, 24168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 639, 23829, 24168);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 639, 23829, 24168);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 641, 24083, 24085)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 641, 24083, 24085);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 641, 24083, 24085).defaultWriteObject();
            }
            MatrixUtils.serializeRealMatrix(tableau, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context225.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context226 = new MethodContext(void.class, 651, 24175, 24633);
        try {
            CallChecker.varInit(this, "this", 651, 24175, 24633);
            CallChecker.varInit(ois, "ois", 651, 24175, 24633);
            CallChecker.varInit(this.cutOff, "cutOff", 651, 24175, 24633);
            CallChecker.varInit(this.maxUlps, "maxUlps", 651, 24175, 24633);
            CallChecker.varInit(this.epsilon, "epsilon", 651, 24175, 24633);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 651, 24175, 24633);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 651, 24175, 24633);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 651, 24175, 24633);
            CallChecker.varInit(this.tableau, "tableau", 651, 24175, 24633);
            CallChecker.varInit(this.columnLabels, "columnLabels", 651, 24175, 24633);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 651, 24175, 24633);
            CallChecker.varInit(this.constraints, "constraints", 651, 24175, 24633);
            CallChecker.varInit(this.f, "f", 651, 24175, 24633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.optim.linear.SimplexTableau.serialVersionUID", 651, 24175, 24633);
            CallChecker.varInit(NEGATIVE_VAR_COLUMN_LABEL, "org.apache.commons.math3.optim.linear.SimplexTableau.NEGATIVE_VAR_COLUMN_LABEL", 651, 24175, 24633);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 653, 24539, 24541)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 653, 24539, 24541);
                CallChecker.isCalled(ois, ObjectInputStream.class, 653, 24539, 24541).defaultReadObject();
            }
            MatrixUtils.deserializeRealMatrix(this, "tableau", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context226.methodEnd();
        }
    }
}

