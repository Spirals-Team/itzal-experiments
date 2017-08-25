package org.apache.commons.math.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
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
import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.util.MathUtils;

class SimplexTableau implements Serializable {
    private static final long serialVersionUID = -1369660067587938365L;

    private final LinearObjectiveFunction f;

    private final Collection<LinearConstraint> constraints;

    private final boolean restrictToNonNegative;

    protected transient RealMatrix tableau;

    protected final int numDecisionVariables;

    protected final int numSlackVariables;

    protected int numArtificialVariables;

    protected final double epsilon;

    SimplexTableau(final LinearObjectiveFunction f, final Collection<LinearConstraint> constraints, final GoalType goalType, final boolean restrictToNonNegative, final double epsilon) {
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(SimplexTableau.class, 101, 3372, 4786);
        try {
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 105, 4057, 4088);
            this.constraints = constraints;
            CallChecker.varAssign(this.constraints, "this.constraints", 106, 4098, 4139);
            this.restrictToNonNegative = restrictToNonNegative;
            CallChecker.varAssign(this.restrictToNonNegative, "this.restrictToNonNegative", 107, 4149, 4200);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 108, 4210, 4247);
            if (restrictToNonNegative) {
                this.numDecisionVariables = (getNumVariables()) + 0;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 109, 4257, 4338);
            }else {
                this.numDecisionVariables = (getNumVariables()) + 1;
                CallChecker.varAssign(this.numDecisionVariables, "this.numDecisionVariables", 109, 4257, 4338);
            }
            this.numSlackVariables = (getConstraintTypeCounts(Relationship.LEQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numSlackVariables, "this.numSlackVariables", 110, 4348, 4501);
            this.numArtificialVariables = (getConstraintTypeCounts(Relationship.EQ)) + (getConstraintTypeCounts(Relationship.GEQ));
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 112, 4511, 4663);
            this.tableau = new Array2DRowRealMatrix(createTableau((goalType == (GoalType.MAXIMIZE))));
            CallChecker.varAssign(this.tableau, "this.tableau", 114, 4673, 4758);
            initialize();
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    protected double[][] createTableau(final boolean maximize) {
        MethodContext _bcornu_methode_context8 = new MethodContext(double[][].class, 123, 4793, 7873);
        try {
            CallChecker.varInit(this, "this", 123, 4793, 7873);
            CallChecker.varInit(maximize, "maximize", 123, 4793, 7873);
            CallChecker.varInit(this.epsilon, "epsilon", 123, 4793, 7873);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 123, 4793, 7873);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 123, 4793, 7873);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 123, 4793, 7873);
            CallChecker.varInit(this.tableau, "tableau", 123, 4793, 7873);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 123, 4793, 7873);
            CallChecker.varInit(this.constraints, "constraints", 123, 4793, 7873);
            CallChecker.varInit(this.f, "f", 123, 4793, 7873);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 123, 4793, 7873);
            List<LinearConstraint> constraints = CallChecker.varInit(getNormalizedConstraints(), "constraints", 126, 5069, 5132);
            int width = CallChecker.varInit(((int) (((((this.numDecisionVariables) + (this.numSlackVariables)) + (this.numArtificialVariables)) + (getNumObjectiveFunctions())) + 1)), "width", 127, 5142, 5260);
            int height = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(constraints, List.class, 129, 5301, 5311)) {
                constraints = CallChecker.beforeCalled(constraints, List.class, 129, 5301, 5311);
                height = (CallChecker.isCalled(constraints, List.class, 129, 5301, 5311).size()) + (getNumObjectiveFunctions());
                CallChecker.varAssign(height, "height", 129, 5301, 5311);
            }
            double[][] matrix = CallChecker.varInit(new double[height][width], "matrix", 130, 5358, 5403);
            if ((getNumObjectiveFunctions()) == 2) {
                if (CallChecker.beforeDeref(matrix, double[][].class, 134, 5515, 5520)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 134, 5515, 5520);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0], double[].class, 134, 5515, 5523)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 134, 5515, 5520);
                        CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0], double[].class, 134, 5515, 5523);
                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0], double[].class, 134, 5515, 5523)[0] = -1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0], double[].class, 134, 5515, 5523)[0], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 134, 5515, 5520)[0], double[].class, 134, 5515, 5523)[0]", 134, 5515, 5532);
                    }
                }
            }
            int zIndex = CallChecker.init(int.class);
            if ((getNumObjectiveFunctions()) == 1) {
                zIndex = 0;
                CallChecker.varAssign(zIndex, "zIndex", 136, 5565, 5605);
            }else {
                zIndex = 1;
                CallChecker.varAssign(zIndex, "zIndex", 136, 5565, 5605);
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, double[][].class, 137, 5616, 5621)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 137, 5616, 5621);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 137, 5616, 5621);
                        CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629);
                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex]", 137, 5616, 5658);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(matrix, double[][].class, 137, 5616, 5621)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 137, 5616, 5621);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 137, 5616, 5621);
                        CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629);
                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex] = -1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 137, 5616, 5621)[zIndex], double[].class, 137, 5616, 5629)[zIndex]", 137, 5616, 5658);
                    }
                }
            }
            RealVector objectiveCoefficients = CallChecker.init(RealVector.class);
            if (maximize) {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 139, 5726, 5726)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(f, LinearObjectiveFunction.class, 139, 5726, 5726).getCoefficients(), RealVector.class, 139, 5726, 5744)) {
                        objectiveCoefficients = CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 139, 5726, 5726).getCoefficients(), RealVector.class, 139, 5726, 5744).mapMultiply((-1));
                        CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 139, 5715, 5782);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 139, 5764, 5764)) {
                    objectiveCoefficients = CallChecker.isCalled(f, LinearObjectiveFunction.class, 139, 5764, 5764).getCoefficients();
                    CallChecker.varAssign(objectiveCoefficients, "objectiveCoefficients", 139, 5715, 5782);
                }
            }
            if (CallChecker.beforeDeref(objectiveCoefficients, RealVector.class, 140, 5807, 5827)) {
                if (CallChecker.beforeDeref(matrix, double[][].class, 140, 5840, 5845)) {
                    objectiveCoefficients = CallChecker.beforeCalled(objectiveCoefficients, RealVector.class, 140, 5807, 5827);
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 140, 5840, 5845);
                    copyArray(CallChecker.isCalled(objectiveCoefficients, RealVector.class, 140, 5807, 5827).getData(), CallChecker.isCalled(matrix, double[][].class, 140, 5840, 5845)[zIndex], getNumObjectiveFunctions());
                }
            }
            if (maximize) {
                if (CallChecker.beforeDeref(matrix, double[][].class, 141, 5897, 5902)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 141, 5897, 5902);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)) {
                        if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 142, 5952, 5952)) {
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 141, 5897, 5902);
                            CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910);
                            CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)] = CallChecker.isCalled(f, LinearObjectiveFunction.class, 142, 5952, 5952).getConstantTerm();
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)]", 141, 5897, 5998);
                        }
                    }
                }
            }else {
                if (CallChecker.beforeDeref(matrix, double[][].class, 141, 5897, 5902)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 141, 5897, 5902);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)) {
                        if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 142, 5979, 5979)) {
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 141, 5897, 5902);
                            CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910);
                            CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)] = (-1) * (CallChecker.isCalled(f, LinearObjectiveFunction.class, 142, 5979, 5979).getConstantTerm());
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 141, 5897, 5902)[zIndex], double[].class, 141, 5897, 5910)[(width - 1)]", 141, 5897, 5998);
                        }
                    }
                }
            }
            if (!(restrictToNonNegative)) {
                if (CallChecker.beforeDeref(matrix, double[][].class, 145, 6067, 6072)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 145, 6067, 6072);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex], double[].class, 145, 6067, 6080)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 145, 6067, 6072);
                        CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex], double[].class, 145, 6067, 6080);
                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex], double[].class, 145, 6067, 6080)[((getSlackVariableOffset()) - 1)] = SimplexTableau.getInvertedCoeffiecientSum(objectiveCoefficients);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex], double[].class, 145, 6067, 6080)[((getSlackVariableOffset()) - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 145, 6067, 6072)[zIndex], double[].class, 145, 6067, 6080)[((getSlackVariableOffset()) - 1)]", 145, 6067, 6187);
                    }
                }
            }
            int slackVar = CallChecker.varInit(((int) (0)), "slackVar", 150, 6274, 6290);
            int artificialVar = CallChecker.varInit(((int) (0)), "artificialVar", 151, 6308, 6329);
            constraints = CallChecker.beforeCalled(constraints, List.class, 152, 6367, 6377);
            for (int i = 0; i < (CallChecker.isCalled(constraints, List.class, 152, 6367, 6377).size()); i++) {
                LinearConstraint constraint = CallChecker.init(LinearConstraint.class);
                if (CallChecker.beforeDeref(constraints, List.class, 153, 6444, 6454)) {
                    constraints = CallChecker.beforeCalled(constraints, List.class, 153, 6444, 6454);
                    constraint = CallChecker.isCalled(constraints, List.class, 153, 6444, 6454).get(i);
                    CallChecker.varAssign(constraint, "constraint", 153, 6444, 6454);
                }
                int row = CallChecker.varInit(((int) ((getNumObjectiveFunctions()) + i)), "row", 154, 6484, 6524);
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 157, 6611, 6620)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 157, 6611, 6620);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(constraint, LinearConstraint.class, 157, 6611, 6620).getCoefficients(), RealVector.class, 157, 6611, 6638)) {
                        if (CallChecker.beforeDeref(matrix, double[][].class, 157, 6651, 6656)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 157, 6611, 6620);
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 157, 6651, 6656);
                            copyArray(CallChecker.isCalled(CallChecker.isCalled(constraint, LinearConstraint.class, 157, 6611, 6620).getCoefficients(), RealVector.class, 157, 6611, 6638).getData(), CallChecker.isCalled(matrix, double[][].class, 157, 6651, 6656)[row], 1);
                        }
                    }
                }
                if (!(restrictToNonNegative)) {
                    if (CallChecker.beforeDeref(matrix, double[][].class, 161, 6769, 6774)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 161, 6769, 6774);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row], double[].class, 161, 6769, 6779)) {
                            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 162, 6868, 6877)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 161, 6769, 6774);
                                CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row], double[].class, 161, 6769, 6779);
                                constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 162, 6868, 6877);
                                CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row], double[].class, 161, 6769, 6779)[((getSlackVariableOffset()) - 1)] = SimplexTableau.getInvertedCoeffiecientSum(CallChecker.isCalled(constraint, LinearConstraint.class, 162, 6868, 6877).getCoefficients());
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row], double[].class, 161, 6769, 6779)[((getSlackVariableOffset()) - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 161, 6769, 6774)[row], double[].class, 161, 6769, 6779)[((getSlackVariableOffset()) - 1)]", 161, 6769, 6897);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(matrix, double[][].class, 166, 6969, 6974)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 166, 6969, 6974);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row], double[].class, 166, 6969, 6979)) {
                        if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 166, 6994, 7003)) {
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 166, 6969, 6974);
                            CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row], double[].class, 166, 6969, 6979);
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 166, 6994, 7003);
                            CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row], double[].class, 166, 6969, 6979)[(width - 1)] = CallChecker.isCalled(constraint, LinearConstraint.class, 166, 6994, 7003).getValue();
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row], double[].class, 166, 6969, 6979)[(width - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 166, 6969, 6974)[row], double[].class, 166, 6969, 6979)[(width - 1)]", 166, 6969, 7015);
                        }
                    }
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 169, 7081, 7090)) {
                    constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 169, 7081, 7090);
                    if ((CallChecker.isCalled(constraint, LinearConstraint.class, 169, 7081, 7090).getRelationship()) == (Relationship.LEQ)) {
                        if (CallChecker.beforeDeref(matrix, double[][].class, 170, 7157, 7162)) {
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 170, 7157, 7162);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row], double[].class, 170, 7157, 7167)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 170, 7157, 7162);
                                CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row], double[].class, 170, 7157, 7167);
                                CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row], double[].class, 170, 7157, 7167)[((getSlackVariableOffset()) + (slackVar++))] = 1;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row], double[].class, 170, 7157, 7167)[((getSlackVariableOffset()) + (slackVar - 1))], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 170, 7157, 7162)[row], double[].class, 170, 7157, 7167)[((getSlackVariableOffset()) + (slackVar - 1))]", 170, 7157, 7211);
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 171, 7254, 7263)) {
                            constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 171, 7254, 7263);
                            if ((CallChecker.isCalled(constraint, LinearConstraint.class, 171, 7254, 7263).getRelationship()) == (Relationship.GEQ)) {
                                if (CallChecker.beforeDeref(matrix, double[][].class, 172, 7330, 7335)) {
                                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 172, 7330, 7335);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row], double[].class, 172, 7330, 7340)) {
                                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 172, 7330, 7335);
                                        CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row], double[].class, 172, 7330, 7340);
                                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row], double[].class, 172, 7330, 7340)[((getSlackVariableOffset()) + (slackVar++))] = -1;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row], double[].class, 172, 7330, 7340)[((getSlackVariableOffset()) + (slackVar - 1))], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 172, 7330, 7335)[row], double[].class, 172, 7330, 7340)[((getSlackVariableOffset()) + (slackVar - 1))]", 172, 7330, 7385);
                                    }
                                }
                            }
                        }
                    
                }
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 176, 7489, 7498)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 177, 7566, 7575)) {
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 176, 7489, 7498);
                        constraint = CallChecker.beforeCalled(constraint, LinearConstraint.class, 177, 7566, 7575);
                        if (((CallChecker.isCalled(constraint, LinearConstraint.class, 176, 7489, 7498).getRelationship()) == (Relationship.EQ)) || ((CallChecker.isCalled(constraint, LinearConstraint.class, 177, 7566, 7575).getRelationship()) == (Relationship.GEQ))) {
                            if (CallChecker.beforeDeref(matrix, double[][].class, 178, 7643, 7648)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 178, 7643, 7648);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0], double[].class, 178, 7643, 7651)) {
                                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 178, 7643, 7648);
                                    CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0], double[].class, 178, 7643, 7651);
                                    CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0], double[].class, 178, 7643, 7651)[((getArtificialVariableOffset()) + artificialVar)] = 1;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0], double[].class, 178, 7643, 7651)[((getArtificialVariableOffset()) + artificialVar)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 178, 7643, 7648)[0], double[].class, 178, 7643, 7651)[((getArtificialVariableOffset()) + artificialVar)]", 178, 7643, 7703);
                                }
                            }
                            if (CallChecker.beforeDeref(matrix, double[][].class, 179, 7730, 7735)) {
                                matrix = CallChecker.beforeCalled(matrix, double[][].class, 179, 7730, 7735);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row], double[].class, 179, 7730, 7740)) {
                                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 179, 7730, 7735);
                                    CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row], double[].class, 179, 7730, 7740);
                                    CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row], double[].class, 179, 7730, 7740)[((getArtificialVariableOffset()) + (artificialVar++))] = 1;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row], double[].class, 179, 7730, 7740)[((getArtificialVariableOffset()) + (artificialVar - 1))], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 179, 7730, 7735)[row], double[].class, 179, 7730, 7740)[((getArtificialVariableOffset()) + (artificialVar - 1))]", 179, 7730, 7794);
                                }
                            }
                        }
                    }
                }
            }
            return matrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public int getNumVariables() {
        MethodContext _bcornu_methode_context9 = new MethodContext(int.class, 189, 7880, 8046);
        try {
            CallChecker.varInit(this, "this", 189, 7880, 8046);
            CallChecker.varInit(this.epsilon, "epsilon", 189, 7880, 8046);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 189, 7880, 8046);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 189, 7880, 8046);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 189, 7880, 8046);
            CallChecker.varInit(this.tableau, "tableau", 189, 7880, 8046);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 189, 7880, 8046);
            CallChecker.varInit(this.constraints, "constraints", 189, 7880, 8046);
            CallChecker.varInit(this.f, "f", 189, 7880, 8046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 189, 7880, 8046);
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 190, 8006, 8006)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(f, LinearObjectiveFunction.class, 190, 8006, 8006).getCoefficients(), RealVector.class, 190, 8006, 8024)) {
                    return CallChecker.isCalled(CallChecker.isCalled(f, LinearObjectiveFunction.class, 190, 8006, 8006).getCoefficients(), RealVector.class, 190, 8006, 8024).getDimension();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public List<LinearConstraint> getNormalizedConstraints() {
        MethodContext _bcornu_methode_context10 = new MethodContext(List.class, 197, 8053, 8485);
        try {
            CallChecker.varInit(this, "this", 197, 8053, 8485);
            CallChecker.varInit(this.epsilon, "epsilon", 197, 8053, 8485);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 197, 8053, 8485);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 197, 8053, 8485);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 197, 8053, 8485);
            CallChecker.varInit(this.tableau, "tableau", 197, 8053, 8485);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 197, 8053, 8485);
            CallChecker.varInit(this.constraints, "constraints", 197, 8053, 8485);
            CallChecker.varInit(this.f, "f", 197, 8053, 8485);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 197, 8053, 8485);
            List<LinearConstraint> normalized = CallChecker.varInit(new ArrayList<LinearConstraint>(), "normalized", 198, 8264, 8333);
            if (CallChecker.beforeDeref(constraints, List.class, 199, 8378, 8388)) {
                for (LinearConstraint constraint : constraints) {
                    if (CallChecker.beforeDeref(normalized, List.class, 200, 8405, 8414)) {
                        normalized = CallChecker.beforeCalled(normalized, List.class, 200, 8405, 8414);
                        CallChecker.isCalled(normalized, List.class, 200, 8405, 8414).add(normalize(constraint));
                    }
                }
            }
            return normalized;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<LinearConstraint>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    private LinearConstraint normalize(final LinearConstraint constraint) {
        MethodContext _bcornu_methode_context11 = new MethodContext(LinearConstraint.class, 210, 8492, 9196);
        try {
            CallChecker.varInit(this, "this", 210, 8492, 9196);
            CallChecker.varInit(constraint, "constraint", 210, 8492, 9196);
            CallChecker.varInit(this.epsilon, "epsilon", 210, 8492, 9196);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 210, 8492, 9196);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 210, 8492, 9196);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 210, 8492, 9196);
            CallChecker.varInit(this.tableau, "tableau", 210, 8492, 9196);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 210, 8492, 9196);
            CallChecker.varInit(this.constraints, "constraints", 210, 8492, 9196);
            CallChecker.varInit(this.f, "f", 210, 8492, 9196);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 210, 8492, 9196);
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 211, 8748, 8757)) {
                if ((CallChecker.isCalled(constraint, LinearConstraint.class, 211, 8748, 8757).getValue()) < 0) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 212, 8817, 8826)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(constraint, LinearConstraint.class, 212, 8817, 8826).getCoefficients(), RealVector.class, 212, 8817, 8844)) {
                            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 213, 8903, 8912)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(constraint, LinearConstraint.class, 213, 8903, 8912).getRelationship(), Relationship.class, 213, 8903, 8930)) {
                                    return new LinearConstraint(CallChecker.isCalled(CallChecker.isCalled(constraint, LinearConstraint.class, 212, 8817, 8826).getCoefficients(), RealVector.class, 212, 8817, 8844).mapMultiply((-1)), CallChecker.isCalled(CallChecker.isCalled(constraint, LinearConstraint.class, 213, 8903, 8912).getRelationship(), Relationship.class, 213, 8903, 8930).oppositeRelationship(), ((-1) * (CallChecker.isCalled(constraint, LinearConstraint.class, 214, 9001, 9010).getValue())));
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
            
            if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 216, 9071, 9080)) {
                if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 217, 9138, 9147)) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 217, 9168, 9177)) {
                        return new LinearConstraint(CallChecker.isCalled(constraint, LinearConstraint.class, 216, 9071, 9080).getCoefficients(), CallChecker.isCalled(constraint, LinearConstraint.class, 217, 9138, 9147).getRelationship(), CallChecker.isCalled(constraint, LinearConstraint.class, 217, 9168, 9177).getValue());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinearConstraint) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    protected final int getNumObjectiveFunctions() {
        MethodContext _bcornu_methode_context12 = new MethodContext(int.class, 224, 9203, 9436);
        try {
            CallChecker.varInit(this, "this", 224, 9203, 9436);
            CallChecker.varInit(this.epsilon, "epsilon", 224, 9203, 9436);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 224, 9203, 9436);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 224, 9203, 9436);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 224, 9203, 9436);
            CallChecker.varInit(this.tableau, "tableau", 224, 9203, 9436);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 224, 9203, 9436);
            CallChecker.varInit(this.constraints, "constraints", 224, 9203, 9436);
            CallChecker.varInit(this.f, "f", 224, 9203, 9436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 224, 9203, 9436);
            if ((this.numArtificialVariables) > 0) {
                return 2;
            }else {
                return 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    private int getConstraintTypeCounts(final Relationship relationship) {
        MethodContext _bcornu_methode_context13 = new MethodContext(int.class, 233, 9443, 9950);
        try {
            CallChecker.varInit(this, "this", 233, 9443, 9950);
            CallChecker.varInit(relationship, "relationship", 233, 9443, 9950);
            CallChecker.varInit(this.epsilon, "epsilon", 233, 9443, 9950);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 233, 9443, 9950);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 233, 9443, 9950);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 233, 9443, 9950);
            CallChecker.varInit(this.tableau, "tableau", 233, 9443, 9950);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 233, 9443, 9950);
            CallChecker.varInit(this.constraints, "constraints", 233, 9443, 9950);
            CallChecker.varInit(this.f, "f", 233, 9443, 9950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 233, 9443, 9950);
            int count = CallChecker.varInit(((int) (0)), "count", 234, 9732, 9745);
            if (CallChecker.beforeDeref(constraints, int.class, 235, 9796, 9806)) {
                for (final LinearConstraint constraint : constraints) {
                    if (CallChecker.beforeDeref(constraint, LinearConstraint.class, 236, 9827, 9836)) {
                        if ((CallChecker.isCalled(constraint, LinearConstraint.class, 236, 9827, 9836).getRelationship()) == relationship) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    private void initialize() {
        MethodContext _bcornu_methode_context14 = new MethodContext(void.class, 247, 9957, 10373);
        try {
            CallChecker.varInit(this, "this", 247, 9957, 10373);
            CallChecker.varInit(this.epsilon, "epsilon", 247, 9957, 10373);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 247, 9957, 10373);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 247, 9957, 10373);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 247, 9957, 10373);
            CallChecker.varInit(this.tableau, "tableau", 247, 9957, 10373);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 247, 9957, 10373);
            CallChecker.varInit(this.constraints, "constraints", 247, 9957, 10373);
            CallChecker.varInit(this.f, "f", 247, 9957, 10373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 247, 9957, 10373);
            for (int artificialVar = 0; artificialVar < (numArtificialVariables); artificialVar++) {
                int row = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(((Integer) (getBasicRow(((getArtificialVariableOffset()) + artificialVar)))), int.class, 249, 10261, 10318)) {
                    row = CallChecker.isCalled(((Integer) (getBasicRow(((getArtificialVariableOffset()) + artificialVar)))), int.class, 249, 10261, 10318);
                    CallChecker.varAssign(row, "row", 249, 10261, 10318);
                }
                subtractRow(0, row, 1.0);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    protected static double getInvertedCoeffiecientSum(final RealVector coefficients) {
        MethodContext _bcornu_methode_context15 = new MethodContext(double.class, 259, 10380, 10825);
        try {
            CallChecker.varInit(coefficients, "coefficients", 259, 10380, 10825);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 259, 10380, 10825);
            double sum = CallChecker.varInit(((double) (0)), "sum", 260, 10683, 10697);
            for (double coefficient : CallChecker.isCalled(coefficients, RealVector.class, 261, 10733, 10744).getData()) {
                sum -= coefficient;
                CallChecker.varAssign(sum, "sum", 262, 10771, 10789);
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    private Integer getBasicRow(final int col) {
        MethodContext _bcornu_methode_context16 = new MethodContext(Integer.class, 272, 10832, 11119);
        try {
            CallChecker.varInit(this, "this", 272, 10832, 11119);
            CallChecker.varInit(col, "col", 272, 10832, 11119);
            CallChecker.varInit(this.epsilon, "epsilon", 272, 10832, 11119);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 272, 10832, 11119);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 272, 10832, 11119);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 272, 10832, 11119);
            CallChecker.varInit(this.tableau, "tableau", 272, 10832, 11119);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 272, 10832, 11119);
            CallChecker.varInit(this.constraints, "constraints", 272, 10832, 11119);
            CallChecker.varInit(this.f, "f", 272, 10832, 11119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 272, 10832, 11119);
            return getBasicRow(col, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    private Integer getBasicRowForSolution(final int col) {
        MethodContext _bcornu_methode_context17 = new MethodContext(Integer.class, 281, 11126, 11425);
        try {
            CallChecker.varInit(this, "this", 281, 11126, 11425);
            CallChecker.varInit(col, "col", 281, 11126, 11425);
            CallChecker.varInit(this.epsilon, "epsilon", 281, 11126, 11425);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 281, 11126, 11425);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 281, 11126, 11425);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 281, 11126, 11425);
            CallChecker.varInit(this.tableau, "tableau", 281, 11126, 11425);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 281, 11126, 11425);
            CallChecker.varInit(this.constraints, "constraints", 281, 11126, 11425);
            CallChecker.varInit(this.f, "f", 281, 11126, 11425);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 281, 11126, 11425);
            return getBasicRow(col, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    private Integer getBasicRow(final int col, boolean ignoreObjectiveRows) {
        MethodContext _bcornu_methode_context18 = new MethodContext(Integer.class, 290, 11436, 12126);
        try {
            CallChecker.varInit(this, "this", 290, 11436, 12126);
            CallChecker.varInit(ignoreObjectiveRows, "ignoreObjectiveRows", 290, 11436, 12126);
            CallChecker.varInit(col, "col", 290, 11436, 12126);
            CallChecker.varInit(this.epsilon, "epsilon", 290, 11436, 12126);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 290, 11436, 12126);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 290, 11436, 12126);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 290, 11436, 12126);
            CallChecker.varInit(this.tableau, "tableau", 290, 11436, 12126);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 290, 11436, 12126);
            CallChecker.varInit(this.constraints, "constraints", 290, 11436, 12126);
            CallChecker.varInit(this.f, "f", 290, 11436, 12126);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 290, 11436, 12126);
            Integer row = CallChecker.varInit(null, "row", 291, 11717, 11735);
            int start = CallChecker.init(int.class);
            if (ignoreObjectiveRows) {
                start = getNumObjectiveFunctions();
                CallChecker.varAssign(start, "start", 292, 11757, 11808);
            }else {
                start = 0;
                CallChecker.varAssign(start, "start", 292, 11757, 11808);
            }
            for (int i = start; i < (getHeight()); i++) {
                if ((MathUtils.equals(getEntry(i, col), 1.0, epsilon)) && (row == null)) {
                    row = i;
                    CallChecker.varAssign(row, "row", 295, 11964, 11971);
                }else
                    if (!(MathUtils.equals(getEntry(i, col), 0.0, epsilon))) {
                        return null;
                    }
                
            }
            return row;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    protected void discardArtificialVariables() {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class, 306, 12133, 12854);
        try {
            CallChecker.varInit(this, "this", 306, 12133, 12854);
            CallChecker.varInit(this.epsilon, "epsilon", 306, 12133, 12854);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 306, 12133, 12854);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 306, 12133, 12854);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 306, 12133, 12854);
            CallChecker.varInit(this.tableau, "tableau", 306, 12133, 12854);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 306, 12133, 12854);
            CallChecker.varInit(this.constraints, "constraints", 306, 12133, 12854);
            CallChecker.varInit(this.f, "f", 306, 12133, 12854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 306, 12133, 12854);
            if ((numArtificialVariables) == 0) {
                return ;
            }
            int width = CallChecker.varInit(((int) (((getWidth()) - (this.numArtificialVariables)) - 1)), "width", 310, 12366, 12417);
            int height = CallChecker.varInit(((int) ((getHeight()) - 1)), "height", 311, 12427, 12455);
            double[][] matrix = CallChecker.varInit(new double[height][width], "matrix", 312, 12465, 12510);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < (width - 1); j++) {
                    if (CallChecker.beforeDeref(matrix, double[][].class, 315, 12621, 12626)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 315, 12621, 12626);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i], double[].class, 315, 12621, 12629)) {
                            matrix = CallChecker.beforeCalled(matrix, double[][].class, 315, 12621, 12626);
                            CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i], double[].class, 315, 12621, 12629);
                            CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i], double[].class, 315, 12621, 12629)[j] = getEntry((i + 1), (j + 1));
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i], double[].class, 315, 12621, 12629)[j], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 315, 12621, 12626)[i], double[].class, 315, 12621, 12629)[j]", 315, 12621, 12658);
                        }
                    }
                }
                if (CallChecker.beforeDeref(matrix, double[][].class, 317, 12686, 12691)) {
                    matrix = CallChecker.beforeCalled(matrix, double[][].class, 317, 12686, 12691);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i], double[].class, 317, 12686, 12694)) {
                        matrix = CallChecker.beforeCalled(matrix, double[][].class, 317, 12686, 12691);
                        CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i], double[].class, 317, 12686, 12694);
                        CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i], double[].class, 317, 12686, 12694)[(width - 1)] = getEntry((i + 1), getRhsOffset());
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i], double[].class, 317, 12686, 12694)[(width - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 317, 12686, 12691)[i], double[].class, 317, 12686, 12694)[(width - 1)]", 317, 12686, 12740);
                    }
                }
            }
            this.tableau = new Array2DRowRealMatrix(matrix);
            CallChecker.varAssign(this.tableau, "this.tableau", 319, 12760, 12807);
            this.numArtificialVariables = 0;
            CallChecker.varAssign(this.numArtificialVariables, "this.numArtificialVariables", 320, 12817, 12848);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    private void copyArray(final double[] src, final double[] dest, final int destPos) {
        MethodContext _bcornu_methode_context20 = new MethodContext(void.class, 329, 12862, 13198);
        try {
            CallChecker.varInit(this, "this", 329, 12862, 13198);
            CallChecker.varInit(destPos, "destPos", 329, 12862, 13198);
            CallChecker.varInit(dest, "dest", 329, 12862, 13198);
            CallChecker.varInit(src, "src", 329, 12862, 13198);
            CallChecker.varInit(this.epsilon, "epsilon", 329, 12862, 13198);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 329, 12862, 13198);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 329, 12862, 13198);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 329, 12862, 13198);
            CallChecker.varInit(this.tableau, "tableau", 329, 12862, 13198);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 329, 12862, 13198);
            CallChecker.varInit(this.constraints, "constraints", 329, 12862, 13198);
            CallChecker.varInit(this.f, "f", 329, 12862, 13198);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 329, 12862, 13198);
            if (CallChecker.beforeDeref(src, double[].class, 331, 13180, 13182)) {
                System.arraycopy(src, 0, dest, getNumObjectiveFunctions(), CallChecker.isCalled(src, double[].class, 331, 13180, 13182).length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    protected RealPointValuePair getSolution() {
        MethodContext _bcornu_methode_context21 = new MethodContext(RealPointValuePair.class, 339, 13205, 14365);
        try {
            CallChecker.varInit(this, "this", 339, 13205, 14365);
            CallChecker.varInit(this.epsilon, "epsilon", 339, 13205, 14365);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 339, 13205, 14365);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 339, 13205, 14365);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 339, 13205, 14365);
            CallChecker.varInit(this.tableau, "tableau", 339, 13205, 14365);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 339, 13205, 14365);
            CallChecker.varInit(this.constraints, "constraints", 339, 13205, 14365);
            CallChecker.varInit(this.f, "f", 339, 13205, 14365);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 339, 13205, 14365);
            double[] coefficients = CallChecker.varInit(new double[getOriginalNumDecisionVariables()], "coefficients", 340, 13345, 13414);
            Integer negativeVarBasicRow = CallChecker.varInit(getBasicRowForSolution(getNegativeDecisionVariableOffset()), "negativeVarBasicRow", 341, 13422, 13511);
            double mostNegative = CallChecker.init(double.class);
            if (negativeVarBasicRow == null) {
                mostNegative = 0;
                CallChecker.varAssign(mostNegative, "mostNegative", 342, 13541, 13619);
            }else {
                mostNegative = getEntry(negativeVarBasicRow, getRhsOffset());
                CallChecker.varAssign(mostNegative, "mostNegative", 342, 13541, 13619);
            }
            Set<Integer> basicRows = CallChecker.varInit(new HashSet<Integer>(), "basicRows", 343, 13628, 13675);
            coefficients = CallChecker.beforeCalled(coefficients, double[].class, 344, 13703, 13714);
            for (int i = 0; i < (CallChecker.isCalled(coefficients, double[].class, 344, 13703, 13714).length); i++) {
                Integer basicRow = CallChecker.varInit(getBasicRowForSolution(((getNumObjectiveFunctions()) + i)), "basicRow", 345, 13741, 13814);
                if (CallChecker.beforeDeref(basicRows, Set.class, 346, 13830, 13838)) {
                    basicRows = CallChecker.beforeCalled(basicRows, Set.class, 346, 13830, 13838);
                    if (CallChecker.isCalled(basicRows, Set.class, 346, 13830, 13838).contains(basicRow)) {
                        if (CallChecker.beforeDeref(coefficients, double[].class, 349, 14009, 14020)) {
                            coefficients = CallChecker.beforeCalled(coefficients, double[].class, 349, 14009, 14020);
                            CallChecker.isCalled(coefficients, double[].class, 349, 14009, 14020)[i] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 349, 14009, 14020)[i], "CallChecker.isCalled(coefficients, double[].class, 349, 14009, 14020)[i]", 349, 14009, 14028);
                        }
                    }else {
                        if (CallChecker.beforeDeref(basicRows, Set.class, 351, 14063, 14071)) {
                            basicRows = CallChecker.beforeCalled(basicRows, Set.class, 351, 14063, 14071);
                            CallChecker.isCalled(basicRows, Set.class, 351, 14063, 14071).add(basicRow);
                        }
                        if (basicRow == null) {
                            if (CallChecker.beforeDeref(coefficients, double[].class, 352, 14102, 14113)) {
                                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 352, 14102, 14113);
                                CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i] = 0 - (restrictToNonNegative ? 0 : mostNegative);
                                CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i], "CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i]", 352, 14102, 14260);
                            }
                        }else {
                            if (CallChecker.beforeDeref(coefficients, double[].class, 352, 14102, 14113)) {
                                coefficients = CallChecker.beforeCalled(coefficients, double[].class, 352, 14102, 14113);
                                CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i] = (getEntry(basicRow, getRhsOffset())) - (restrictToNonNegative ? 0 : mostNegative);
                                CallChecker.varAssign(CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i], "CallChecker.isCalled(coefficients, double[].class, 352, 14102, 14113)[i]", 352, 14102, 14260);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(f, LinearObjectiveFunction.class, 357, 14334, 14334)) {
                return new RealPointValuePair(coefficients, CallChecker.isCalled(f, LinearObjectiveFunction.class, 357, 14334, 14334).getValue(coefficients));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealPointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    protected void divideRow(final int dividendRow, final double divisor) {
        MethodContext _bcornu_methode_context22 = new MethodContext(void.class, 369, 14372, 14902);
        try {
            CallChecker.varInit(this, "this", 369, 14372, 14902);
            CallChecker.varInit(divisor, "divisor", 369, 14372, 14902);
            CallChecker.varInit(dividendRow, "dividendRow", 369, 14372, 14902);
            CallChecker.varInit(this.epsilon, "epsilon", 369, 14372, 14902);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 369, 14372, 14902);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 369, 14372, 14902);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 369, 14372, 14902);
            CallChecker.varInit(this.tableau, "tableau", 369, 14372, 14902);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 369, 14372, 14902);
            CallChecker.varInit(this.constraints, "constraints", 369, 14372, 14902);
            CallChecker.varInit(this.f, "f", 369, 14372, 14902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 369, 14372, 14902);
            for (int j = 0; j < (getWidth()); j++) {
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 371, 14843, 14849)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 371, 14810, 14816)) {
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 371, 14843, 14849);
                        tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 371, 14810, 14816);
                        CallChecker.isCalled(tableau, RealMatrix.class, 371, 14810, 14816).setEntry(dividendRow, j, ((CallChecker.isCalled(tableau, RealMatrix.class, 371, 14843, 14849).getEntry(dividendRow, j)) / divisor));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    protected void subtractRow(final int minuendRow, final int subtrahendRow, final double multiple) {
        MethodContext _bcornu_methode_context23 = new MethodContext(void.class, 385, 14909, 15594);
        try {
            CallChecker.varInit(this, "this", 385, 14909, 15594);
            CallChecker.varInit(multiple, "multiple", 385, 14909, 15594);
            CallChecker.varInit(subtrahendRow, "subtrahendRow", 385, 14909, 15594);
            CallChecker.varInit(minuendRow, "minuendRow", 385, 14909, 15594);
            CallChecker.varInit(this.epsilon, "epsilon", 385, 14909, 15594);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 385, 14909, 15594);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 385, 14909, 15594);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 385, 14909, 15594);
            CallChecker.varInit(this.tableau, "tableau", 385, 14909, 15594);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 385, 14909, 15594);
            CallChecker.varInit(this.constraints, "constraints", 385, 14909, 15594);
            CallChecker.varInit(this.f, "f", 385, 14909, 15594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 385, 14909, 15594);
            for (int j = 0; j < (getWidth()); j++) {
                if (CallChecker.beforeDeref(tableau, RealMatrix.class, 388, 15469, 15475)) {
                    if (CallChecker.beforeDeref(tableau, RealMatrix.class, 389, 15543, 15549)) {
                        if (CallChecker.beforeDeref(tableau, RealMatrix.class, 388, 15437, 15443)) {
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 388, 15469, 15475);
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 389, 15543, 15549);
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 388, 15437, 15443);
                            CallChecker.isCalled(tableau, RealMatrix.class, 388, 15437, 15443).setEntry(minuendRow, j, ((CallChecker.isCalled(tableau, RealMatrix.class, 388, 15469, 15475).getEntry(minuendRow, j)) - (multiple * (CallChecker.isCalled(tableau, RealMatrix.class, 389, 15543, 15549).getEntry(subtrahendRow, j)))));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    protected final int getWidth() {
        MethodContext _bcornu_methode_context24 = new MethodContext(int.class, 397, 15601, 15772);
        try {
            CallChecker.varInit(this, "this", 397, 15601, 15772);
            CallChecker.varInit(this.epsilon, "epsilon", 397, 15601, 15772);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 397, 15601, 15772);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 397, 15601, 15772);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 397, 15601, 15772);
            CallChecker.varInit(this.tableau, "tableau", 397, 15601, 15772);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 397, 15601, 15772);
            CallChecker.varInit(this.constraints, "constraints", 397, 15601, 15772);
            CallChecker.varInit(this.f, "f", 397, 15601, 15772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 397, 15601, 15772);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 398, 15738, 15744)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 398, 15738, 15744);
                return CallChecker.isCalled(tableau, RealMatrix.class, 398, 15738, 15744).getColumnDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    protected final int getHeight() {
        MethodContext _bcornu_methode_context25 = new MethodContext(int.class, 405, 15779, 15950);
        try {
            CallChecker.varInit(this, "this", 405, 15779, 15950);
            CallChecker.varInit(this.epsilon, "epsilon", 405, 15779, 15950);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 405, 15779, 15950);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 405, 15779, 15950);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 405, 15779, 15950);
            CallChecker.varInit(this.tableau, "tableau", 405, 15779, 15950);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 405, 15779, 15950);
            CallChecker.varInit(this.constraints, "constraints", 405, 15779, 15950);
            CallChecker.varInit(this.f, "f", 405, 15779, 15950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 405, 15779, 15950);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 406, 15919, 15925)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 406, 15919, 15925);
                return CallChecker.isCalled(tableau, RealMatrix.class, 406, 15919, 15925).getRowDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    protected final double getEntry(final int row, final int column) {
        MethodContext _bcornu_methode_context26 = new MethodContext(double.class, 414, 15957, 16219);
        try {
            CallChecker.varInit(this, "this", 414, 15957, 16219);
            CallChecker.varInit(column, "column", 414, 15957, 16219);
            CallChecker.varInit(row, "row", 414, 15957, 16219);
            CallChecker.varInit(this.epsilon, "epsilon", 414, 15957, 16219);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 414, 15957, 16219);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 414, 15957, 16219);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 414, 15957, 16219);
            CallChecker.varInit(this.tableau, "tableau", 414, 15957, 16219);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 414, 15957, 16219);
            CallChecker.varInit(this.constraints, "constraints", 414, 15957, 16219);
            CallChecker.varInit(this.f, "f", 414, 15957, 16219);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 414, 15957, 16219);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 415, 16184, 16190)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 415, 16184, 16190);
                return CallChecker.isCalled(tableau, RealMatrix.class, 415, 16184, 16190).getEntry(row, column);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    protected final void setEntry(final int row, final int column, final double value) {
        MethodContext _bcornu_methode_context27 = new MethodContext(void.class, 423, 16226, 16536);
        try {
            CallChecker.varInit(this, "this", 423, 16226, 16536);
            CallChecker.varInit(value, "value", 423, 16226, 16536);
            CallChecker.varInit(column, "column", 423, 16226, 16536);
            CallChecker.varInit(row, "row", 423, 16226, 16536);
            CallChecker.varInit(this.epsilon, "epsilon", 423, 16226, 16536);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 423, 16226, 16536);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 423, 16226, 16536);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 423, 16226, 16536);
            CallChecker.varInit(this.tableau, "tableau", 423, 16226, 16536);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 423, 16226, 16536);
            CallChecker.varInit(this.constraints, "constraints", 423, 16226, 16536);
            CallChecker.varInit(this.f, "f", 423, 16226, 16536);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 423, 16226, 16536);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 425, 16494, 16500)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 425, 16494, 16500);
                CallChecker.isCalled(tableau, RealMatrix.class, 425, 16494, 16500).setEntry(row, column, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    protected final int getSlackVariableOffset() {
        MethodContext _bcornu_methode_context28 = new MethodContext(int.class, 432, 16543, 16777);
        try {
            CallChecker.varInit(this, "this", 432, 16543, 16777);
            CallChecker.varInit(this.epsilon, "epsilon", 432, 16543, 16777);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 432, 16543, 16777);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 432, 16543, 16777);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 432, 16543, 16777);
            CallChecker.varInit(this.tableau, "tableau", 432, 16543, 16777);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 432, 16543, 16777);
            CallChecker.varInit(this.constraints, "constraints", 432, 16543, 16777);
            CallChecker.varInit(this.f, "f", 432, 16543, 16777);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 432, 16543, 16777);
            return (getNumObjectiveFunctions()) + (numDecisionVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    protected final int getArtificialVariableOffset() {
        MethodContext _bcornu_methode_context29 = new MethodContext(int.class, 440, 16784, 17053);
        try {
            CallChecker.varInit(this, "this", 440, 16784, 17053);
            CallChecker.varInit(this.epsilon, "epsilon", 440, 16784, 17053);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 440, 16784, 17053);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 440, 16784, 17053);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 440, 16784, 17053);
            CallChecker.varInit(this.tableau, "tableau", 440, 16784, 17053);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 440, 16784, 17053);
            CallChecker.varInit(this.constraints, "constraints", 440, 16784, 17053);
            CallChecker.varInit(this.f, "f", 440, 16784, 17053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 440, 16784, 17053);
            return ((getNumObjectiveFunctions()) + (numDecisionVariables)) + (numSlackVariables);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    protected final int getRhsOffset() {
        MethodContext _bcornu_methode_context30 = new MethodContext(int.class, 448, 17060, 17239);
        try {
            CallChecker.varInit(this, "this", 448, 17060, 17239);
            CallChecker.varInit(this.epsilon, "epsilon", 448, 17060, 17239);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 448, 17060, 17239);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 448, 17060, 17239);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 448, 17060, 17239);
            CallChecker.varInit(this.tableau, "tableau", 448, 17060, 17239);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 448, 17060, 17239);
            CallChecker.varInit(this.constraints, "constraints", 448, 17060, 17239);
            CallChecker.varInit(this.f, "f", 448, 17060, 17239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 448, 17060, 17239);
            return (getWidth()) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    protected final int getNegativeDecisionVariableOffset() {
        MethodContext _bcornu_methode_context31 = new MethodContext(int.class, 457, 17250, 17575);
        try {
            CallChecker.varInit(this, "this", 457, 17250, 17575);
            CallChecker.varInit(this.epsilon, "epsilon", 457, 17250, 17575);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 457, 17250, 17575);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 457, 17250, 17575);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 457, 17250, 17575);
            CallChecker.varInit(this.tableau, "tableau", 457, 17250, 17575);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 457, 17250, 17575);
            CallChecker.varInit(this.constraints, "constraints", 457, 17250, 17575);
            CallChecker.varInit(this.f, "f", 457, 17250, 17575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 457, 17250, 17575);
            return (getNumObjectiveFunctions()) + (getOriginalNumDecisionVariables());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    protected final int getNumDecisionVariables() {
        MethodContext _bcornu_methode_context32 = new MethodContext(int.class, 471, 17582, 18026);
        try {
            CallChecker.varInit(this, "this", 471, 17582, 18026);
            CallChecker.varInit(this.epsilon, "epsilon", 471, 17582, 18026);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 471, 17582, 18026);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 471, 17582, 18026);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 471, 17582, 18026);
            CallChecker.varInit(this.tableau, "tableau", 471, 17582, 18026);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 471, 17582, 18026);
            CallChecker.varInit(this.constraints, "constraints", 471, 17582, 18026);
            CallChecker.varInit(this.f, "f", 471, 17582, 18026);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 471, 17582, 18026);
            return numDecisionVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    protected final int getOriginalNumDecisionVariables() {
        MethodContext _bcornu_methode_context33 = new MethodContext(int.class, 480, 18033, 18343);
        try {
            CallChecker.varInit(this, "this", 480, 18033, 18343);
            CallChecker.varInit(this.epsilon, "epsilon", 480, 18033, 18343);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 480, 18033, 18343);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 480, 18033, 18343);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 480, 18033, 18343);
            CallChecker.varInit(this.tableau, "tableau", 480, 18033, 18343);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 480, 18033, 18343);
            CallChecker.varInit(this.constraints, "constraints", 480, 18033, 18343);
            CallChecker.varInit(this.f, "f", 480, 18033, 18343);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 480, 18033, 18343);
            if (restrictToNonNegative) {
                return numDecisionVariables;
            }else {
                return (numDecisionVariables) - 1;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    protected final int getNumSlackVariables() {
        MethodContext _bcornu_methode_context34 = new MethodContext(int.class, 488, 18350, 18532);
        try {
            CallChecker.varInit(this, "this", 488, 18350, 18532);
            CallChecker.varInit(this.epsilon, "epsilon", 488, 18350, 18532);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 488, 18350, 18532);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 488, 18350, 18532);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 488, 18350, 18532);
            CallChecker.varInit(this.tableau, "tableau", 488, 18350, 18532);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 488, 18350, 18532);
            CallChecker.varInit(this.constraints, "constraints", 488, 18350, 18532);
            CallChecker.varInit(this.f, "f", 488, 18350, 18532);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 488, 18350, 18532);
            return numSlackVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    protected final int getNumArtificialVariables() {
        MethodContext _bcornu_methode_context35 = new MethodContext(int.class, 496, 18539, 18741);
        try {
            CallChecker.varInit(this, "this", 496, 18539, 18741);
            CallChecker.varInit(this.epsilon, "epsilon", 496, 18539, 18741);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 496, 18539, 18741);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 496, 18539, 18741);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 496, 18539, 18741);
            CallChecker.varInit(this.tableau, "tableau", 496, 18539, 18741);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 496, 18539, 18741);
            CallChecker.varInit(this.constraints, "constraints", 496, 18539, 18741);
            CallChecker.varInit(this.f, "f", 496, 18539, 18741);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 496, 18539, 18741);
            return numArtificialVariables;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    protected final double[][] getData() {
        MethodContext _bcornu_methode_context36 = new MethodContext(double[][].class, 504, 18748, 18898);
        try {
            CallChecker.varInit(this, "this", 504, 18748, 18898);
            CallChecker.varInit(this.epsilon, "epsilon", 504, 18748, 18898);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 504, 18748, 18898);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 504, 18748, 18898);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 504, 18748, 18898);
            CallChecker.varInit(this.tableau, "tableau", 504, 18748, 18898);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 504, 18748, 18898);
            CallChecker.varInit(this.constraints, "constraints", 504, 18748, 18898);
            CallChecker.varInit(this.f, "f", 504, 18748, 18898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 504, 18748, 18898);
            if (CallChecker.beforeDeref(tableau, RealMatrix.class, 505, 18875, 18881)) {
                tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 505, 18875, 18881);
                return CallChecker.isCalled(tableau, RealMatrix.class, 505, 18875, 18881).getData();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context37 = new MethodContext(boolean.class, 510, 18905, 19765);
        try {
            CallChecker.varInit(this, "this", 510, 18905, 19765);
            CallChecker.varInit(other, "other", 510, 18905, 19765);
            CallChecker.varInit(this.epsilon, "epsilon", 510, 18905, 19765);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 510, 18905, 19765);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 510, 18905, 19765);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 510, 18905, 19765);
            CallChecker.varInit(this.tableau, "tableau", 510, 18905, 19765);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 510, 18905, 19765);
            CallChecker.varInit(this.constraints, "constraints", 510, 18905, 19765);
            CallChecker.varInit(this.f, "f", 510, 18905, 19765);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 510, 18905, 19765);
            if ((this) == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            TryContext _bcornu_try_context_1 = new TryContext(1, SimplexTableau.class, "java.lang.ClassCastException");
            try {
                SimplexTableau rhs = CallChecker.varInit(((SimplexTableau) (other)), "rhs", 522, 19122, 19165);
                if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 528, 19545, 19547)) {
                    if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 529, 19591, 19593)) {
                        if (CallChecker.beforeDeref(rhs, SimplexTableau.class, 530, 19643, 19645)) {
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 523, 19211, 19213);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 524, 19285, 19287);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 525, 19358, 19360);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 526, 19428, 19430);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 527, 19503, 19505);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 528, 19545, 19547);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 529, 19591, 19593);
                            rhs = CallChecker.beforeCalled(rhs, SimplexTableau.class, 530, 19643, 19645);
                            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 530, 19628, 19634);
                            return ((((((((restrictToNonNegative) == (CallChecker.isCalled(rhs, SimplexTableau.class, 523, 19211, 19213).restrictToNonNegative)) && ((numDecisionVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 524, 19285, 19287).numDecisionVariables))) && ((numSlackVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 525, 19358, 19360).numSlackVariables))) && ((numArtificialVariables) == (CallChecker.isCalled(rhs, SimplexTableau.class, 526, 19428, 19430).numArtificialVariables))) && ((epsilon) == (CallChecker.isCalled(rhs, SimplexTableau.class, 527, 19503, 19505).epsilon))) && (CallChecker.isCalled(f, LinearObjectiveFunction.class, 528, 19536, 19536).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 528, 19545, 19547).f))) && (CallChecker.isCalled(constraints, Collection.class, 529, 19572, 19582).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 529, 19591, 19593).constraints))) && (CallChecker.isCalled(tableau, RealMatrix.class, 530, 19628, 19634).equals(CallChecker.isCalled(rhs, SimplexTableau.class, 530, 19643, 19645).tableau));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassCastException ex) {
                _bcornu_try_context_1.catchStart(1);
                return false;
            } finally {
                _bcornu_try_context_1.finallyStart(1);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context38 = new MethodContext(int.class, 541, 19776, 20180);
        try {
            CallChecker.varInit(this, "this", 541, 19776, 20180);
            CallChecker.varInit(this.epsilon, "epsilon", 541, 19776, 20180);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 541, 19776, 20180);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 541, 19776, 20180);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 541, 19776, 20180);
            CallChecker.varInit(this.tableau, "tableau", 541, 19776, 20180);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 541, 19776, 20180);
            CallChecker.varInit(this.constraints, "constraints", 541, 19776, 20180);
            CallChecker.varInit(this.f, "f", 541, 19776, 20180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 541, 19776, 20180);
            tableau = CallChecker.beforeCalled(tableau, RealMatrix.class, 549, 20156, 20162);
            return (((((((CallChecker.isCalled(Boolean.valueOf(restrictToNonNegative), Boolean.class, 542, 19854, 19891).hashCode()) ^ (numDecisionVariables)) ^ (numSlackVariables)) ^ (numArtificialVariables)) ^ (CallChecker.isCalled(Double.valueOf(epsilon), Double.class, 546, 20034, 20056).hashCode())) ^ (CallChecker.isCalled(f, LinearObjectiveFunction.class, 547, 20086, 20086).hashCode())) ^ (CallChecker.isCalled(constraints, Collection.class, 548, 20116, 20126).hashCode())) ^ (CallChecker.isCalled(tableau, RealMatrix.class, 549, 20156, 20162).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context39 = new MethodContext(void.class, 556, 20187, 20519);
        try {
            CallChecker.varInit(this, "this", 556, 20187, 20519);
            CallChecker.varInit(oos, "oos", 556, 20187, 20519);
            CallChecker.varInit(this.epsilon, "epsilon", 556, 20187, 20519);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 556, 20187, 20519);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 556, 20187, 20519);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 556, 20187, 20519);
            CallChecker.varInit(this.tableau, "tableau", 556, 20187, 20519);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 556, 20187, 20519);
            CallChecker.varInit(this.constraints, "constraints", 556, 20187, 20519);
            CallChecker.varInit(this.f, "f", 556, 20187, 20519);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 556, 20187, 20519);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 558, 20434, 20436)) {
                oos = CallChecker.beforeCalled(oos, ObjectOutputStream.class, 558, 20434, 20436);
                CallChecker.isCalled(oos, ObjectOutputStream.class, 558, 20434, 20436).defaultWriteObject();
            }
            MatrixUtils.serializeRealMatrix(tableau, oos);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context40 = new MethodContext(void.class, 567, 20526, 20977);
        try {
            CallChecker.varInit(this, "this", 567, 20526, 20977);
            CallChecker.varInit(ois, "ois", 567, 20526, 20977);
            CallChecker.varInit(this.epsilon, "epsilon", 567, 20526, 20977);
            CallChecker.varInit(this.numArtificialVariables, "numArtificialVariables", 567, 20526, 20977);
            CallChecker.varInit(this.numSlackVariables, "numSlackVariables", 567, 20526, 20977);
            CallChecker.varInit(this.numDecisionVariables, "numDecisionVariables", 567, 20526, 20977);
            CallChecker.varInit(this.tableau, "tableau", 567, 20526, 20977);
            CallChecker.varInit(this.restrictToNonNegative, "restrictToNonNegative", 567, 20526, 20977);
            CallChecker.varInit(this.constraints, "constraints", 567, 20526, 20977);
            CallChecker.varInit(this.f, "f", 567, 20526, 20977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math.optimization.linear.SimplexTableau.serialVersionUID", 567, 20526, 20977);
            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 569, 20883, 20885)) {
                ois = CallChecker.beforeCalled(ois, ObjectInputStream.class, 569, 20883, 20885);
                CallChecker.isCalled(ois, ObjectInputStream.class, 569, 20883, 20885).defaultReadObject();
            }
            MatrixUtils.deserializeRealMatrix(this, "tableau", ois);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }
}

