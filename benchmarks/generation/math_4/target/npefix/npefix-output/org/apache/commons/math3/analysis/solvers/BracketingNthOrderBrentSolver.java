package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class BracketingNthOrderBrentSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    private static final int DEFAULT_MAXIMAL_ORDER = 5;

    private static final int MAXIMAL_AGING = 2;

    private static final double REDUCTION_FACTOR = 1.0 / 16.0;

    private final int maximalOrder;

    private AllowedSolution allowed;

    public BracketingNthOrderBrentSolver() {
        this(BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY, BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER);
        ConstructorContext _bcornu_methode_context519 = new ConstructorContext(BracketingNthOrderBrentSolver.class, 70, 2687, 2904);
        try {
        } finally {
            _bcornu_methode_context519.methodEnd();
        }
    }

    public BracketingNthOrderBrentSolver(final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context520 = new ConstructorContext(BracketingNthOrderBrentSolver.class, 81, 2911, 3548);
        try {
            if (maximalOrder < 2) {
                throw new NumberIsTooSmallException(maximalOrder, 2, true);
            }
            this.maximalOrder = maximalOrder;
            CallChecker.varAssign(this.maximalOrder, "this.maximalOrder", 88, 3461, 3493);
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 89, 3503, 3542);
        } finally {
            _bcornu_methode_context520.methodEnd();
        }
    }

    public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final int maximalOrder) throws NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context521 = new ConstructorContext(BracketingNthOrderBrentSolver.class, 100, 3555, 4332);
        try {
            if (maximalOrder < 2) {
                throw new NumberIsTooSmallException(maximalOrder, 2, true);
            }
            this.maximalOrder = maximalOrder;
            CallChecker.varAssign(this.maximalOrder, "this.maximalOrder", 108, 4245, 4277);
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 109, 4287, 4326);
        } finally {
            _bcornu_methode_context521.methodEnd();
        }
    }

    public BracketingNthOrderBrentSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy, final int maximalOrder) throws NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context522 = new ConstructorContext(BracketingNthOrderBrentSolver.class, 121, 4339, 5277);
        try {
            if (maximalOrder < 2) {
                throw new NumberIsTooSmallException(maximalOrder, 2, true);
            }
            this.maximalOrder = maximalOrder;
            CallChecker.varAssign(this.maximalOrder, "this.maximalOrder", 130, 5190, 5222);
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 131, 5232, 5271);
        } finally {
            _bcornu_methode_context522.methodEnd();
        }
    }

    public int getMaximalOrder() {
        MethodContext _bcornu_methode_context2460 = new MethodContext(int.class, 137, 5284, 5416);
        try {
            CallChecker.varInit(this, "this", 137, 5284, 5416);
            CallChecker.varInit(this.allowed, "allowed", 137, 5284, 5416);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 137, 5284, 5416);
            CallChecker.varInit(REDUCTION_FACTOR, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.REDUCTION_FACTOR", 137, 5284, 5416);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.MAXIMAL_AGING", 137, 5284, 5416);
            CallChecker.varInit(DEFAULT_MAXIMAL_ORDER, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER", 137, 5284, 5416);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 137, 5284, 5416);
            return maximalOrder;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2460.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2461 = new MethodContext(double.class, 145, 5423, 13590);
        try {
            CallChecker.varInit(this, "this", 145, 5423, 13590);
            CallChecker.varInit(this.allowed, "allowed", 145, 5423, 13590);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 145, 5423, 13590);
            CallChecker.varInit(REDUCTION_FACTOR, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.REDUCTION_FACTOR", 145, 5423, 13590);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.MAXIMAL_AGING", 145, 5423, 13590);
            CallChecker.varInit(DEFAULT_MAXIMAL_ORDER, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER", 145, 5423, 13590);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 145, 5423, 13590);
            final double[] x = CallChecker.varInit(new double[(maximalOrder) + 1], "x", 150, 5682, 5729);
            final double[] y = CallChecker.varInit(new double[(maximalOrder) + 1], "y", 151, 5739, 5786);
            if (CallChecker.beforeDeref(x, double[].class, 152, 5796, 5796)) {
                CallChecker.isCalled(x, double[].class, 152, 5796, 5796)[0] = getMin();
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 152, 5796, 5796)[0], "CallChecker.isCalled(x, double[].class, 152, 5796, 5796)[0]", 152, 5796, 5811);
            }
            if (CallChecker.beforeDeref(x, double[].class, 153, 5821, 5821)) {
                CallChecker.isCalled(x, double[].class, 153, 5821, 5821)[1] = getStartValue();
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 153, 5821, 5821)[1], "CallChecker.isCalled(x, double[].class, 153, 5821, 5821)[1]", 153, 5821, 5843);
            }
            if (CallChecker.beforeDeref(x, double[].class, 154, 5853, 5853)) {
                CallChecker.isCalled(x, double[].class, 154, 5853, 5853)[2] = getMax();
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 154, 5853, 5853)[2], "CallChecker.isCalled(x, double[].class, 154, 5853, 5853)[2]", 154, 5853, 5868);
            }
            if (CallChecker.beforeDeref(x, double[].class, 155, 5893, 5893)) {
                if (CallChecker.beforeDeref(x, double[].class, 155, 5899, 5899)) {
                    if (CallChecker.beforeDeref(x, double[].class, 155, 5905, 5905)) {
                        verifySequence(CallChecker.isCalled(x, double[].class, 155, 5893, 5893)[0], CallChecker.isCalled(x, double[].class, 155, 5899, 5899)[1], CallChecker.isCalled(x, double[].class, 155, 5905, 5905)[2]);
                    }
                }
            }
            if (CallChecker.beforeDeref(y, double[].class, 158, 5955, 5955)) {
                if (CallChecker.beforeDeref(x, double[].class, 158, 5984, 5984)) {
                    CallChecker.isCalled(y, double[].class, 158, 5955, 5955)[1] = computeObjectiveValue(CallChecker.isCalled(x, double[].class, 158, 5984, 5984)[1]);
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 158, 5955, 5955)[1], "CallChecker.isCalled(y, double[].class, 158, 5955, 5955)[1]", 158, 5955, 5989);
                }
            }
            if (CallChecker.beforeDeref(y, double[].class, 159, 6020, 6020)) {
                if (Precision.equals(CallChecker.isCalled(y, double[].class, 159, 6020, 6020)[1], 0.0, 1)) {
                    if (CallChecker.beforeDeref(x, double[].class, 161, 6121, 6121)) {
                        return CallChecker.isCalled(x, double[].class, 161, 6121, 6121)[1];
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(y, double[].class, 165, 6182, 6182)) {
                if (CallChecker.beforeDeref(x, double[].class, 165, 6211, 6211)) {
                    CallChecker.isCalled(y, double[].class, 165, 6182, 6182)[0] = computeObjectiveValue(CallChecker.isCalled(x, double[].class, 165, 6211, 6211)[0]);
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 165, 6182, 6182)[0], "CallChecker.isCalled(y, double[].class, 165, 6182, 6182)[0]", 165, 6182, 6216);
                }
            }
            if (CallChecker.beforeDeref(y, double[].class, 166, 6247, 6247)) {
                if (Precision.equals(CallChecker.isCalled(y, double[].class, 166, 6247, 6247)[0], 0.0, 1)) {
                    if (CallChecker.beforeDeref(x, double[].class, 168, 6349, 6349)) {
                        return CallChecker.isCalled(x, double[].class, 168, 6349, 6349)[0];
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            int nbPoints = CallChecker.init(int.class);
            int signChangeIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(y, double[].class, 173, 6429, 6429)) {
                if (CallChecker.beforeDeref(y, double[].class, 173, 6436, 6436)) {
                    if (((CallChecker.isCalled(y, double[].class, 173, 6429, 6429)[0]) * (CallChecker.isCalled(y, double[].class, 173, 6436, 6436)[1])) < 0) {
                        nbPoints = 2;
                        CallChecker.varAssign(nbPoints, "nbPoints", 176, 6516, 6535);
                        signChangeIndex = 1;
                        CallChecker.varAssign(signChangeIndex, "signChangeIndex", 177, 6549, 6568);
                    }else {
                        if (CallChecker.beforeDeref(y, double[].class, 182, 6641, 6641)) {
                            if (CallChecker.beforeDeref(x, double[].class, 182, 6670, 6670)) {
                                CallChecker.isCalled(y, double[].class, 182, 6641, 6641)[2] = computeObjectiveValue(CallChecker.isCalled(x, double[].class, 182, 6670, 6670)[2]);
                                CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 182, 6641, 6641)[2], "CallChecker.isCalled(y, double[].class, 182, 6641, 6641)[2]", 182, 6641, 6675);
                            }
                        }
                        if (CallChecker.beforeDeref(y, double[].class, 183, 6710, 6710)) {
                            if (Precision.equals(CallChecker.isCalled(y, double[].class, 183, 6710, 6710)[2], 0.0, 1)) {
                                if (CallChecker.beforeDeref(x, double[].class, 185, 6821, 6821)) {
                                    return CallChecker.isCalled(x, double[].class, 185, 6821, 6821)[2];
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(y, double[].class, 188, 6858, 6858)) {
                            if (CallChecker.beforeDeref(y, double[].class, 188, 6865, 6865)) {
                                if (((CallChecker.isCalled(y, double[].class, 188, 6858, 6858)[1]) * (CallChecker.isCalled(y, double[].class, 188, 6865, 6865)[2])) < 0) {
                                    nbPoints = 3;
                                    CallChecker.varAssign(nbPoints, "nbPoints", 190, 6973, 6992);
                                    signChangeIndex = 2;
                                    CallChecker.varAssign(signChangeIndex, "signChangeIndex", 191, 7010, 7029);
                                }else {
                                    if (CallChecker.beforeDeref(x, double[].class, 193, 7100, 7100)) {
                                        if (CallChecker.beforeDeref(x, double[].class, 193, 7106, 7106)) {
                                            if (CallChecker.beforeDeref(y, double[].class, 193, 7112, 7112)) {
                                                if (CallChecker.beforeDeref(y, double[].class, 193, 7118, 7118)) {
                                                    throw new NoBracketingException(CallChecker.isCalled(x, double[].class, 193, 7100, 7100)[0], CallChecker.isCalled(x, double[].class, 193, 7106, 7106)[2], CallChecker.isCalled(y, double[].class, 193, 7112, 7112)[0], CallChecker.isCalled(y, double[].class, 193, 7118, 7118)[2]);
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] tmpX = CallChecker.varInit(new double[CallChecker.isCalled(x, double[].class, 199, 7261, 7261).length], "tmpX", 199, 7228, 7270);
            double xA = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(x, double[].class, 202, 7347, 7347)) {
                xA = CallChecker.isCalled(x, double[].class, 202, 7347, 7347)[(signChangeIndex - 1)];
                CallChecker.varAssign(xA, "xA", 202, 7347, 7347);
            }
            double yA = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(y, double[].class, 203, 7394, 7394)) {
                yA = CallChecker.isCalled(y, double[].class, 203, 7394, 7394)[(signChangeIndex - 1)];
                CallChecker.varAssign(yA, "yA", 203, 7394, 7394);
            }
            double absYA = CallChecker.varInit(((double) (FastMath.abs(yA))), "absYA", 204, 7426, 7457);
            int agingA = CallChecker.varInit(((int) (0)), "agingA", 205, 7467, 7483);
            double xB = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(x, double[].class, 206, 7508, 7508)) {
                xB = CallChecker.isCalled(x, double[].class, 206, 7508, 7508)[signChangeIndex];
                CallChecker.varAssign(xB, "xB", 206, 7508, 7508);
            }
            double yB = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(y, double[].class, 207, 7551, 7551)) {
                yB = CallChecker.isCalled(y, double[].class, 207, 7551, 7551)[signChangeIndex];
                CallChecker.varAssign(yB, "yB", 207, 7551, 7551);
            }
            double absYB = CallChecker.varInit(((double) (FastMath.abs(yB))), "absYB", 208, 7579, 7610);
            int agingB = CallChecker.varInit(((int) (0)), "agingB", 209, 7620, 7636);
            while (true) {
                final double xTol = CallChecker.varInit(((double) ((getAbsoluteAccuracy()) + ((getRelativeAccuracy()) * (FastMath.max(FastMath.abs(xA), FastMath.abs(xB)))))), "xTol", 215, 7698, 7902);
                if (((xB - xA) <= xTol) || ((FastMath.max(absYA, absYB)) < (getFunctionValueAccuracy()))) {
                    switch (allowed) {
                        case ANY_SIDE :
                            if (absYA < absYB) {
                                return xA;
                            }else {
                                return xB;
                            }
                        case LEFT_SIDE :
                            return xA;
                        case RIGHT_SIDE :
                            return xB;
                        case BELOW_SIDE :
                            if (yA <= 0) {
                                return xA;
                            }else {
                                return xB;
                            }
                        case ABOVE_SIDE :
                            if (yA < 0) {
                                return xB;
                            }else {
                                return xA;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }
                double targetY = CallChecker.init(double.class);
                if (agingA >= (BracketingNthOrderBrentSolver.MAXIMAL_AGING)) {
                    final int p = CallChecker.varInit(((int) (agingA - (BracketingNthOrderBrentSolver.MAXIMAL_AGING))), "p", 239, 8713, 8826);
                    final double weightA = CallChecker.varInit(((double) ((1 << p) - 1)), "weightA", 240, 8844, 8879);
                    final double weightB = CallChecker.varInit(((double) (p + 1)), "weightB", 241, 8897, 8925);
                    targetY = ((weightA * yA) - ((weightB * (BracketingNthOrderBrentSolver.REDUCTION_FACTOR)) * yB)) / (weightA + weightB);
                    CallChecker.varAssign(targetY, "targetY", 242, 8943, 9023);
                }else
                    if (agingB >= (BracketingNthOrderBrentSolver.MAXIMAL_AGING)) {
                        final int p = CallChecker.varInit(((int) (agingB - (BracketingNthOrderBrentSolver.MAXIMAL_AGING))), "p", 245, 9091, 9203);
                        final double weightA = CallChecker.varInit(((double) (p + 1)), "weightA", 246, 9221, 9249);
                        final double weightB = CallChecker.varInit(((double) ((1 << p) - 1)), "weightB", 247, 9267, 9302);
                        targetY = ((weightB * yB) - ((weightA * (BracketingNthOrderBrentSolver.REDUCTION_FACTOR)) * yA)) / (weightA + weightB);
                        CallChecker.varAssign(targetY, "targetY", 248, 9320, 9400);
                    }else {
                        targetY = 0;
                        CallChecker.varAssign(targetY, "targetY", 251, 9510, 9521);
                    }
                
                double nextX = CallChecker.init(double.class);
                int start = CallChecker.varInit(((int) (0)), "start", 256, 9628, 9641);
                int end = CallChecker.varInit(((int) (nbPoints)), "end", 257, 9655, 9675);
                do {
                    System.arraycopy(x, start, tmpX, start, (end - start));
                    nextX = guessX(targetY, tmpX, y, start, end);
                    CallChecker.varAssign(nextX, "nextX", 262, 9873, 9917);
                    if (!((nextX > xA) && (nextX < xB))) {
                        if ((signChangeIndex - start) >= (end - signChangeIndex)) {
                            ++start;
                        }else {
                            --end;
                        }
                        nextX = Double.NaN;
                        CallChecker.varAssign(nextX, "nextX", 279, 10771, 10789);
                    }
                } while ((Double.isNaN(nextX)) && ((end - start) > 1) );
                if (Double.isNaN(nextX)) {
                    nextX = xA + (0.5 * (xB - xA));
                    CallChecker.varAssign(nextX, "nextX", 287, 10973, 11001);
                    start = signChangeIndex - 1;
                    CallChecker.varAssign(start, "start", 288, 11019, 11046);
                    end = signChangeIndex;
                    CallChecker.varAssign(end, "end", 289, 11064, 11087);
                }
                final double nextY = CallChecker.varInit(((double) (computeObjectiveValue(nextX))), "nextY", 293, 11116, 11222);
                if (Precision.equals(nextY, 0.0, 1)) {
                    return nextX;
                }
                if ((nbPoints > 2) && ((end - start) != nbPoints)) {
                    nbPoints = end - start;
                    CallChecker.varAssign(nbPoints, "nbPoints", 304, 11723, 11745);
                    System.arraycopy(x, start, x, 0, nbPoints);
                    System.arraycopy(y, start, y, 0, nbPoints);
                    signChangeIndex -= start;
                    CallChecker.varAssign(signChangeIndex, "signChangeIndex", 307, 11883, 11907);
                }else
                    if (CallChecker.beforeDeref(x, double[].class, 309, 11946, 11946)) {
                        if (nbPoints == (CallChecker.isCalled(x, double[].class, 309, 11946, 11946).length)) {
                            nbPoints--;
                            if (CallChecker.beforeDeref(x, double[].class, 315, 12185, 12185)) {
                                if (signChangeIndex >= (((CallChecker.isCalled(x, double[].class, 315, 12185, 12185).length) + 1) / 2)) {
                                    System.arraycopy(x, 1, x, 0, nbPoints);
                                    System.arraycopy(y, 1, y, 0, nbPoints);
                                    --signChangeIndex;
                                }
                            }
                        }
                    }
                
                System.arraycopy(x, signChangeIndex, x, (signChangeIndex + 1), (nbPoints - signChangeIndex));
                if (CallChecker.beforeDeref(x, double[].class, 327, 12739, 12739)) {
                    CallChecker.isCalled(x, double[].class, 327, 12739, 12739)[signChangeIndex] = nextX;
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 327, 12739, 12739)[signChangeIndex], "CallChecker.isCalled(x, double[].class, 327, 12739, 12739)[signChangeIndex]", 327, 12739, 12765);
                }
                System.arraycopy(y, signChangeIndex, y, (signChangeIndex + 1), (nbPoints - signChangeIndex));
                if (CallChecker.beforeDeref(y, double[].class, 329, 12881, 12881)) {
                    CallChecker.isCalled(y, double[].class, 329, 12881, 12881)[signChangeIndex] = nextY;
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 329, 12881, 12881)[signChangeIndex], "CallChecker.isCalled(y, double[].class, 329, 12881, 12881)[signChangeIndex]", 329, 12881, 12907);
                }
                ++nbPoints;
                if ((nextY * yA) <= 0) {
                    xB = nextX;
                    CallChecker.varAssign(xB, "xB", 335, 13099, 13109);
                    yB = nextY;
                    CallChecker.varAssign(yB, "yB", 336, 13127, 13137);
                    absYB = FastMath.abs(yB);
                    CallChecker.varAssign(absYB, "absYB", 337, 13155, 13179);
                    ++agingA;
                    agingB = 0;
                    CallChecker.varAssign(agingB, "agingB", 339, 13223, 13233);
                }else {
                    xA = nextX;
                    CallChecker.varAssign(xA, "xA", 342, 13339, 13349);
                    yA = nextY;
                    CallChecker.varAssign(yA, "yA", 343, 13367, 13377);
                    absYA = FastMath.abs(yA);
                    CallChecker.varAssign(absYA, "absYA", 344, 13395, 13419);
                    agingA = 0;
                    CallChecker.varAssign(agingA, "agingA", 345, 13437, 13447);
                    ++agingB;
                    signChangeIndex++;
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2461.methodEnd();
        }
    }

    private double guessX(final double targetY, final double[] x, final double[] y, final int start, final int end) {
        MethodContext _bcornu_methode_context2462 = new MethodContext(double.class, 371, 13597, 14983);
        try {
            CallChecker.varInit(this, "this", 371, 13597, 14983);
            CallChecker.varInit(end, "end", 371, 13597, 14983);
            CallChecker.varInit(start, "start", 371, 13597, 14983);
            CallChecker.varInit(y, "y", 371, 13597, 14983);
            CallChecker.varInit(x, "x", 371, 13597, 14983);
            CallChecker.varInit(targetY, "targetY", 371, 13597, 14983);
            CallChecker.varInit(this.allowed, "allowed", 371, 13597, 14983);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 371, 13597, 14983);
            CallChecker.varInit(REDUCTION_FACTOR, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.REDUCTION_FACTOR", 371, 13597, 14983);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.MAXIMAL_AGING", 371, 13597, 14983);
            CallChecker.varInit(DEFAULT_MAXIMAL_ORDER, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER", 371, 13597, 14983);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 371, 13597, 14983);
            for (int i = start; i < (end - 1); ++i) {
                final int delta = CallChecker.varInit(((int) ((i + 1) - start)), "delta", 376, 14628, 14659);
                for (int j = end - 1; j > i; --j) {
                    if (CallChecker.beforeDeref(x, double[].class, 378, 14725, 14725)) {
                        if (CallChecker.beforeDeref(x, double[].class, 378, 14733, 14733)) {
                            if (CallChecker.beforeDeref(x, double[].class, 378, 14740, 14740)) {
                                if (CallChecker.beforeDeref(y, double[].class, 378, 14751, 14751)) {
                                    if (CallChecker.beforeDeref(y, double[].class, 378, 14758, 14758)) {
                                        CallChecker.isCalled(x, double[].class, 378, 14725, 14725)[j] = ((CallChecker.isCalled(x, double[].class, 378, 14733, 14733)[j]) - (CallChecker.isCalled(x, double[].class, 378, 14740, 14740)[(j - 1)])) / ((CallChecker.isCalled(y, double[].class, 378, 14751, 14751)[j]) - (CallChecker.isCalled(y, double[].class, 378, 14758, 14758)[(j - delta)]));
                                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 378, 14725, 14725)[j], "CallChecker.isCalled(x, double[].class, 378, 14725, 14725)[j]", 378, 14725, 14771);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            double x0 = CallChecker.varInit(((double) (0)), "x0", 383, 14837, 14850);
            for (int j = end - 1; j >= start; --j) {
                if (CallChecker.beforeDeref(x, double[].class, 385, 14918, 14918)) {
                    if (CallChecker.beforeDeref(y, double[].class, 385, 14941, 14941)) {
                        x0 = (CallChecker.isCalled(x, double[].class, 385, 14918, 14918)[j]) + (x0 * (targetY - (CallChecker.isCalled(y, double[].class, 385, 14941, 14941)[j])));
                        CallChecker.varAssign(x0, "x0", 385, 14913, 14946);
                    }
                }
            }
            return x0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2462.methodEnd();
        }
    }

    public double solve(int maxEval, UnivariateFunction f, double min, double max, AllowedSolution allowedSolution) throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2463 = new MethodContext(double.class, 393, 14990, 15370);
        try {
            CallChecker.varInit(this, "this", 393, 14990, 15370);
            CallChecker.varInit(allowedSolution, "allowedSolution", 393, 14990, 15370);
            CallChecker.varInit(max, "max", 393, 14990, 15370);
            CallChecker.varInit(min, "min", 393, 14990, 15370);
            CallChecker.varInit(f, "f", 393, 14990, 15370);
            CallChecker.varInit(maxEval, "maxEval", 393, 14990, 15370);
            CallChecker.varInit(this.allowed, "allowed", 393, 14990, 15370);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 393, 14990, 15370);
            CallChecker.varInit(REDUCTION_FACTOR, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.REDUCTION_FACTOR", 393, 14990, 15370);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.MAXIMAL_AGING", 393, 14990, 15370);
            CallChecker.varInit(DEFAULT_MAXIMAL_ORDER, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER", 393, 14990, 15370);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 393, 14990, 15370);
            this.allowed = allowedSolution;
            CallChecker.varAssign(this.allowed, "this.allowed", 398, 15284, 15314);
            return super.solve(maxEval, f, min, max);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2463.methodEnd();
        }
    }

    public double solve(int maxEval, UnivariateFunction f, double min, double max, double startValue, AllowedSolution allowedSolution) throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2464 = new MethodContext(double.class, 403, 15377, 15812);
        try {
            CallChecker.varInit(this, "this", 403, 15377, 15812);
            CallChecker.varInit(allowedSolution, "allowedSolution", 403, 15377, 15812);
            CallChecker.varInit(startValue, "startValue", 403, 15377, 15812);
            CallChecker.varInit(max, "max", 403, 15377, 15812);
            CallChecker.varInit(min, "min", 403, 15377, 15812);
            CallChecker.varInit(f, "f", 403, 15377, 15812);
            CallChecker.varInit(maxEval, "maxEval", 403, 15377, 15812);
            CallChecker.varInit(this.allowed, "allowed", 403, 15377, 15812);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 403, 15377, 15812);
            CallChecker.varInit(REDUCTION_FACTOR, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.REDUCTION_FACTOR", 403, 15377, 15812);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.MAXIMAL_AGING", 403, 15377, 15812);
            CallChecker.varInit(DEFAULT_MAXIMAL_ORDER, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_MAXIMAL_ORDER", 403, 15377, 15812);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver.DEFAULT_ABSOLUTE_ACCURACY", 403, 15377, 15812);
            this.allowed = allowedSolution;
            CallChecker.varAssign(this.allowed, "this.allowed", 409, 15714, 15744);
            return super.solve(maxEval, f, min, max, startValue);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2464.methodEnd();
        }
    }
}

