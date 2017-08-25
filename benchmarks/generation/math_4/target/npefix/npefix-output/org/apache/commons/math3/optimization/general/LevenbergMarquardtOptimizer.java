package org.apache.commons.math3.optimization.general;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

@Deprecated
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private int solvedCols;

    private double[] diagR;

    private double[] jacNorm;

    private double[] beta;

    private int[] permutation;

    private int rank;

    private double lmPar;

    private double[] lmDir;

    private final double initialStepBoundFactor;

    private final double costRelativeTolerance;

    private final double parRelativeTolerance;

    private final double orthoTolerance;

    private final double qrRankingThreshold;

    private double[] weightedResidual;

    private double[][] weightedJacobian;

    public LevenbergMarquardtOptimizer() {
        this(100, 1.0E-10, 1.0E-10, 1.0E-10, Precision.SAFE_MIN);
        ConstructorContext _bcornu_methode_context549 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 157, 6865, 7555);
        try {
        } finally {
            _bcornu_methode_context549.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        this(100, checker, 1.0E-10, 1.0E-10, 1.0E-10, Precision.SAFE_MIN);
        ConstructorContext _bcornu_methode_context550 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 176, 7562, 8301);
        try {
        } finally {
            _bcornu_methode_context550.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double initialStepBoundFactor, ConvergenceChecker<PointVectorValuePair> checker, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) {
        super(checker);
        ConstructorContext _bcornu_methode_context551 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 202, 8308, 10224);
        try {
            this.initialStepBoundFactor = initialStepBoundFactor;
            CallChecker.varAssign(this.initialStepBoundFactor, "this.initialStepBoundFactor", 209, 9957, 10009);
            this.costRelativeTolerance = costRelativeTolerance;
            CallChecker.varAssign(this.costRelativeTolerance, "this.costRelativeTolerance", 210, 10019, 10069);
            this.parRelativeTolerance = parRelativeTolerance;
            CallChecker.varAssign(this.parRelativeTolerance, "this.parRelativeTolerance", 211, 10079, 10127);
            this.orthoTolerance = orthoTolerance;
            CallChecker.varAssign(this.orthoTolerance, "this.orthoTolerance", 212, 10137, 10173);
            this.qrRankingThreshold = threshold;
            CallChecker.varAssign(this.qrRankingThreshold, "this.qrRankingThreshold", 213, 10183, 10218);
        } finally {
            _bcornu_methode_context551.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance) {
        this(100, costRelativeTolerance, parRelativeTolerance, orthoTolerance, Precision.SAFE_MIN);
        ConstructorContext _bcornu_methode_context552 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 234, 10231, 11339);
        try {
        } finally {
            _bcornu_methode_context552.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double initialStepBoundFactor, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) {
        super(null);
        ConstructorContext _bcornu_methode_context553 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 265, 11346, 13236);
        try {
            this.initialStepBoundFactor = initialStepBoundFactor;
            CallChecker.varAssign(this.initialStepBoundFactor, "this.initialStepBoundFactor", 271, 12969, 13021);
            this.costRelativeTolerance = costRelativeTolerance;
            CallChecker.varAssign(this.costRelativeTolerance, "this.costRelativeTolerance", 272, 13031, 13081);
            this.parRelativeTolerance = parRelativeTolerance;
            CallChecker.varAssign(this.parRelativeTolerance, "this.parRelativeTolerance", 273, 13091, 13139);
            this.orthoTolerance = orthoTolerance;
            CallChecker.varAssign(this.orthoTolerance, "this.orthoTolerance", 274, 13149, 13185);
            this.qrRankingThreshold = threshold;
            CallChecker.varAssign(this.qrRankingThreshold, "this.qrRankingThreshold", 275, 13195, 13230);
        } finally {
            _bcornu_methode_context553.methodEnd();
        }
    }

    @Override
    protected PointVectorValuePair doOptimize() {
        MethodContext _bcornu_methode_context2576 = new MethodContext(PointVectorValuePair.class, 280, 13243, 24085);
        try {
            CallChecker.varInit(this, "this", 280, 13243, 24085);
            CallChecker.varInit(this.evaluations, "evaluations", 280, 13243, 24085);
            CallChecker.varInit(this.cost, "cost", 280, 13243, 24085);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 280, 13243, 24085);
            CallChecker.varInit(this.objective, "objective", 280, 13243, 24085);
            CallChecker.varInit(this.point, "point", 280, 13243, 24085);
            CallChecker.varInit(this.rows, "rows", 280, 13243, 24085);
            CallChecker.varInit(this.cols, "cols", 280, 13243, 24085);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 280, 13243, 24085);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 280, 13243, 24085);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 280, 13243, 24085);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 280, 13243, 24085);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 280, 13243, 24085);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 280, 13243, 24085);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 280, 13243, 24085);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 280, 13243, 24085);
            CallChecker.varInit(this.lmDir, "lmDir", 280, 13243, 24085);
            CallChecker.varInit(this.lmPar, "lmPar", 280, 13243, 24085);
            CallChecker.varInit(this.rank, "rank", 280, 13243, 24085);
            CallChecker.varInit(this.permutation, "permutation", 280, 13243, 24085);
            CallChecker.varInit(this.beta, "beta", 280, 13243, 24085);
            CallChecker.varInit(this.jacNorm, "jacNorm", 280, 13243, 24085);
            CallChecker.varInit(this.diagR, "diagR", 280, 13243, 24085);
            CallChecker.varInit(this.solvedCols, "solvedCols", 280, 13243, 24085);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(getTarget(), double[].class, 281, 13351, 13361).length)), "nR", 281, 13336, 13369);
            final double[] currentPoint = CallChecker.varInit(getStartPoint(), "currentPoint", 282, 13407, 13452);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(currentPoint, double[].class, 283, 13477, 13488).length)), "nC", 283, 13462, 13496);
            solvedCols = FastMath.min(nR, nC);
            CallChecker.varAssign(this.solvedCols, "this.solvedCols", 286, 13588, 13622);
            diagR = new double[nC];
            CallChecker.varAssign(this.diagR, "this.diagR", 287, 13632, 13660);
            jacNorm = new double[nC];
            CallChecker.varAssign(this.jacNorm, "this.jacNorm", 288, 13670, 13698);
            beta = new double[nC];
            CallChecker.varAssign(this.beta, "this.beta", 289, 13708, 13736);
            permutation = new int[nC];
            CallChecker.varAssign(this.permutation, "this.permutation", 290, 13746, 13771);
            lmDir = new double[nC];
            CallChecker.varAssign(this.lmDir, "this.lmDir", 291, 13781, 13809);
            double delta = CallChecker.varInit(((double) (0)), "delta", 294, 13843, 13863);
            double xNorm = CallChecker.varInit(((double) (0)), "xNorm", 295, 13873, 13893);
            double[] diag = CallChecker.varInit(new double[nC], "diag", 296, 13903, 13936);
            double[] oldX = CallChecker.varInit(new double[nC], "oldX", 297, 13946, 13979);
            double[] oldRes = CallChecker.varInit(new double[nR], "oldRes", 298, 13989, 14022);
            double[] oldObj = CallChecker.varInit(new double[nR], "oldObj", 299, 14032, 14065);
            double[] qtf = CallChecker.varInit(new double[nR], "qtf", 300, 14075, 14108);
            double[] work1 = CallChecker.varInit(new double[nC], "work1", 301, 14118, 14151);
            double[] work2 = CallChecker.varInit(new double[nC], "work2", 302, 14161, 14194);
            double[] work3 = CallChecker.varInit(new double[nC], "work3", 303, 14204, 14237);
            final RealMatrix weightMatrixSqrt = CallChecker.varInit(getWeightSquareRoot(), "weightMatrixSqrt", 305, 14248, 14305);
            double[] currentObjective = CallChecker.varInit(computeObjectiveValue(currentPoint), "currentObjective", 308, 14395, 14458);
            double[] currentResiduals = CallChecker.varInit(computeResiduals(currentObjective), "currentResiduals", 309, 14468, 14530);
            PointVectorValuePair current = CallChecker.varInit(new PointVectorValuePair(currentPoint, currentObjective), "current", 310, 14540, 14627);
            double currentCost = CallChecker.varInit(((double) (computeCost(currentResiduals))), "currentCost", 311, 14637, 14687);
            lmPar = 0;
            CallChecker.varAssign(this.lmPar, "this.lmPar", 314, 14721, 14730);
            boolean firstIteration = CallChecker.varInit(((boolean) (true)), "firstIteration", 315, 14740, 14769);
            int iter = CallChecker.varInit(((int) (0)), "iter", 316, 14779, 14791);
            final ConvergenceChecker<PointVectorValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 317, 14801, 14881);
            while (true) {
                ++iter;
                final PointVectorValuePair previous = CallChecker.varInit(current, "previous", 320, 14938, 14983);
                qrDecomposition(computeWeightedJacobian(currentPoint));
                if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 325, 15141, 15156)) {
                    weightedResidual = CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 325, 15141, 15156).operate(currentResiduals);
                    CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 325, 15122, 15183);
                }
                for (int i = 0; i < nR; i++) {
                    if (CallChecker.beforeDeref(qtf, double[].class, 327, 15244, 15246)) {
                        if (CallChecker.beforeDeref(weightedResidual, double[].class, 327, 15253, 15268)) {
                            qtf = CallChecker.beforeCalled(qtf, double[].class, 327, 15244, 15246);
                            weightedResidual = CallChecker.beforeCalled(weightedResidual, double[].class, 327, 15253, 15268);
                            CallChecker.isCalled(qtf, double[].class, 327, 15244, 15246)[i] = CallChecker.isCalled(weightedResidual, double[].class, 327, 15253, 15268)[i];
                            CallChecker.varAssign(CallChecker.isCalled(qtf, double[].class, 327, 15244, 15246)[i], "CallChecker.isCalled(qtf, double[].class, 327, 15244, 15246)[i]", 327, 15244, 15272);
                        }
                    }
                }
                qTy(qtf);
                for (int k = 0; k < (solvedCols); ++k) {
                    int pk = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 336, 15541, 15551)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 336, 15541, 15551);
                        pk = CallChecker.isCalled(permutation, int[].class, 336, 15541, 15551)[k];
                        CallChecker.varAssign(pk, "pk", 336, 15541, 15551);
                    }
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 337, 15573, 15588)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 337, 15573, 15588);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 337, 15573, 15588)[k], double[].class, 337, 15573, 15591)) {
                            if (CallChecker.beforeDeref(diagR, double[].class, 337, 15599, 15603)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 337, 15573, 15588);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 337, 15573, 15588)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 337, 15573, 15588)[k], double[].class, 337, 15573, 15591);
                                diagR = CallChecker.beforeCalled(diagR, double[].class, 337, 15599, 15603);
                                CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 337, 15573, 15588)[k], double[].class, 337, 15573, 15591)[pk] = CallChecker.isCalled(diagR, double[].class, 337, 15599, 15603)[pk];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 337, 15573, 15588)[k], double[].class, 337, 15573, 15591)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 337, 15573, 15588)[k], double[].class, 337, 15573, 15591)[pk]", 337, 15573, 15608);
                            }
                        }
                    }
                }
                if (firstIteration) {
                    xNorm = 0;
                    CallChecker.varAssign(xNorm, "xNorm", 343, 15791, 15800);
                    for (int k = 0; k < nC; ++k) {
                        double dk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(jacNorm, double[].class, 345, 15881, 15887)) {
                            jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 345, 15881, 15887);
                            dk = CallChecker.isCalled(jacNorm, double[].class, 345, 15881, 15887)[k];
                            CallChecker.varAssign(dk, "dk", 345, 15881, 15887);
                        }
                        if (dk == 0) {
                            dk = 1.0;
                            CallChecker.varAssign(dk, "dk", 347, 15952, 15960);
                        }
                        double xk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 349, 16021, 16032)) {
                            xk = dk * (CallChecker.isCalled(currentPoint, double[].class, 349, 16021, 16032)[k]);
                            CallChecker.varAssign(xk, "xk", 349, 16021, 16032);
                        }
                        xNorm += xk * xk;
                        CallChecker.varAssign(xNorm, "xNorm", 350, 16058, 16075);
                        if (CallChecker.beforeDeref(diag, double[].class, 351, 16097, 16100)) {
                            diag = CallChecker.beforeCalled(diag, double[].class, 351, 16097, 16100);
                            CallChecker.isCalled(diag, double[].class, 351, 16097, 16100)[k] = dk;
                            CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 351, 16097, 16100)[k], "CallChecker.isCalled(diag, double[].class, 351, 16097, 16100)[k]", 351, 16097, 16109);
                        }
                    }
                    xNorm = FastMath.sqrt(xNorm);
                    CallChecker.varAssign(xNorm, "xNorm", 353, 16145, 16173);
                    if (xNorm == 0) {
                        delta = initialStepBoundFactor;
                        CallChecker.varAssign(delta, "delta", 356, 16243, 16323);
                    }else {
                        delta = (initialStepBoundFactor) * xNorm;
                        CallChecker.varAssign(delta, "delta", 356, 16243, 16323);
                    }
                }
                double maxCosine = CallChecker.varInit(((double) (0)), "maxCosine", 360, 16432, 16452);
                if (currentCost != 0) {
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 363, 16577, 16587)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 363, 16577, 16587);
                            pj = CallChecker.isCalled(permutation, int[].class, 363, 16577, 16587)[j];
                            CallChecker.varAssign(pj, "pj", 363, 16577, 16587);
                        }
                        double s = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(jacNorm, double[].class, 364, 16625, 16631)) {
                            jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 364, 16625, 16631);
                            s = CallChecker.isCalled(jacNorm, double[].class, 364, 16625, 16631)[pj];
                            CallChecker.varAssign(s, "s", 364, 16625, 16631);
                        }
                        if (s != 0) {
                            double sum = CallChecker.varInit(((double) (0)), "sum", 366, 16696, 16710);
                            for (int i = 0; i <= j; ++i) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 368, 16802, 16817)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 368, 16802, 16817);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 368, 16802, 16817)[i], double[].class, 368, 16802, 16820)) {
                                        if (CallChecker.beforeDeref(qtf, double[].class, 368, 16828, 16830)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 368, 16802, 16817);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 368, 16802, 16817)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 368, 16802, 16817)[i], double[].class, 368, 16802, 16820);
                                            qtf = CallChecker.beforeCalled(qtf, double[].class, 368, 16828, 16830);
                                            sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 368, 16802, 16817)[i], double[].class, 368, 16802, 16820)[pj]) * (CallChecker.isCalled(qtf, double[].class, 368, 16828, 16830)[i]);
                                            CallChecker.varAssign(sum, "sum", 368, 16795, 16834);
                                        }
                                    }
                                }
                            }
                            maxCosine = FastMath.max(maxCosine, ((FastMath.abs(sum)) / (s * currentCost)));
                            CallChecker.varAssign(maxCosine, "maxCosine", 370, 16886, 16960);
                        }
                    }
                }
                if (maxCosine <= (orthoTolerance)) {
                    setCost(currentCost);
                    if (CallChecker.beforeDeref(current, PointVectorValuePair.class, 378, 17228, 17234)) {
                        current = CallChecker.beforeCalled(current, PointVectorValuePair.class, 378, 17228, 17234);
                        point = CallChecker.isCalled(current, PointVectorValuePair.class, 378, 17228, 17234).getPoint();
                        CallChecker.varAssign(this.point, "this.point", 378, 17220, 17246);
                    }
                    return current;
                }
                for (int j = 0; j < nC; ++j) {
                    if (CallChecker.beforeDeref(diag, double[].class, 384, 17390, 17393)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 384, 17413, 17416)) {
                            if (CallChecker.beforeDeref(jacNorm, double[].class, 384, 17422, 17428)) {
                                diag = CallChecker.beforeCalled(diag, double[].class, 384, 17390, 17393);
                                diag = CallChecker.beforeCalled(diag, double[].class, 384, 17413, 17416);
                                jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 384, 17422, 17428);
                                CallChecker.isCalled(diag, double[].class, 384, 17390, 17393)[j] = FastMath.max(CallChecker.isCalled(diag, double[].class, 384, 17413, 17416)[j], CallChecker.isCalled(jacNorm, double[].class, 384, 17422, 17428)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 384, 17390, 17393)[j], "CallChecker.isCalled(diag, double[].class, 384, 17390, 17393)[j]", 384, 17390, 17433);
                            }
                        }
                    }
                }
                for (double ratio = 0; ratio < 1.0E-4;) {
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 392, 17650, 17660)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 392, 17650, 17660);
                            pj = CallChecker.isCalled(permutation, int[].class, 392, 17650, 17660)[j];
                            CallChecker.varAssign(pj, "pj", 392, 17650, 17660);
                        }
                        if (CallChecker.beforeDeref(oldX, double[].class, 393, 17686, 17689)) {
                            if (CallChecker.beforeDeref(currentPoint, double[].class, 393, 17697, 17708)) {
                                oldX = CallChecker.beforeCalled(oldX, double[].class, 393, 17686, 17689);
                                CallChecker.isCalled(oldX, double[].class, 393, 17686, 17689)[pj] = CallChecker.isCalled(currentPoint, double[].class, 393, 17697, 17708)[pj];
                                CallChecker.varAssign(CallChecker.isCalled(oldX, double[].class, 393, 17686, 17689)[pj], "CallChecker.isCalled(oldX, double[].class, 393, 17686, 17689)[pj]", 393, 17686, 17713);
                            }
                        }
                    }
                    final double previousCost = CallChecker.varInit(((double) (currentCost)), "previousCost", 395, 17749, 17788);
                    double[] tmpVec = CallChecker.varInit(weightedResidual, "tmpVec", 396, 17806, 17840);
                    weightedResidual = oldRes;
                    CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 397, 17858, 17883);
                    oldRes = tmpVec;
                    CallChecker.varAssign(oldRes, "oldRes", 398, 17901, 17919);
                    tmpVec = currentObjective;
                    CallChecker.varAssign(tmpVec, "tmpVec", 399, 17937, 17965);
                    currentObjective = oldObj;
                    CallChecker.varAssign(currentObjective, "currentObjective", 400, 17983, 18008);
                    oldObj = tmpVec;
                    CallChecker.varAssign(oldObj, "oldObj", 401, 18026, 18044);
                    determineLMParameter(qtf, delta, diag, work1, work2, work3);
                    double lmNorm = CallChecker.varInit(((double) (0)), "lmNorm", 407, 18285, 18302);
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 409, 18388, 18398)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 409, 18388, 18398);
                            pj = CallChecker.isCalled(permutation, int[].class, 409, 18388, 18398)[j];
                            CallChecker.varAssign(pj, "pj", 409, 18388, 18398);
                        }
                        if (CallChecker.beforeDeref(lmDir, double[].class, 410, 18424, 18428)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 410, 18437, 18441)) {
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 410, 18424, 18428);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 410, 18437, 18441);
                                CallChecker.isCalled(lmDir, double[].class, 410, 18424, 18428)[pj] = -(CallChecker.isCalled(lmDir, double[].class, 410, 18437, 18441)[pj]);
                                CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 410, 18424, 18428)[pj], "CallChecker.isCalled(this.lmDir, double[].class, 410, 18424, 18428)[pj]", 410, 18424, 18446);
                            }
                        }
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 411, 18468, 18479)) {
                            if (CallChecker.beforeDeref(oldX, double[].class, 411, 18487, 18490)) {
                                if (CallChecker.beforeDeref(lmDir, double[].class, 411, 18498, 18502)) {
                                    oldX = CallChecker.beforeCalled(oldX, double[].class, 411, 18487, 18490);
                                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 411, 18498, 18502);
                                    CallChecker.isCalled(currentPoint, double[].class, 411, 18468, 18479)[pj] = (CallChecker.isCalled(oldX, double[].class, 411, 18487, 18490)[pj]) + (CallChecker.isCalled(lmDir, double[].class, 411, 18498, 18502)[pj]);
                                    CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 411, 18468, 18479)[pj], "CallChecker.isCalled(currentPoint, double[].class, 411, 18468, 18479)[pj]", 411, 18468, 18507);
                                }
                            }
                        }
                        double s = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(diag, double[].class, 412, 18540, 18543)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 412, 18551, 18555)) {
                                diag = CallChecker.beforeCalled(diag, double[].class, 412, 18540, 18543);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 412, 18551, 18555);
                                s = (CallChecker.isCalled(diag, double[].class, 412, 18540, 18543)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 412, 18551, 18555)[pj]);
                                CallChecker.varAssign(s, "s", 412, 18540, 18543);
                            }
                        }
                        lmNorm += s * s;
                        CallChecker.varAssign(lmNorm, "lmNorm", 413, 18582, 18598);
                    }
                    lmNorm = FastMath.sqrt(lmNorm);
                    CallChecker.varAssign(lmNorm, "lmNorm", 415, 18634, 18664);
                    if (firstIteration) {
                        delta = FastMath.min(delta, lmNorm);
                        CallChecker.varAssign(delta, "delta", 418, 18798, 18833);
                    }
                    currentObjective = computeObjectiveValue(currentPoint);
                    CallChecker.varAssign(currentObjective, "currentObjective", 422, 18944, 18998);
                    currentResiduals = computeResiduals(currentObjective);
                    CallChecker.varAssign(currentResiduals, "currentResiduals", 423, 19016, 19069);
                    current = new PointVectorValuePair(currentPoint, currentObjective);
                    CallChecker.varAssign(current, "current", 424, 19087, 19153);
                    currentCost = computeCost(currentResiduals);
                    CallChecker.varAssign(currentCost, "currentCost", 425, 19171, 19214);
                    double actRed = CallChecker.varInit(((double) (-1.0)), "actRed", 428, 19288, 19308);
                    if ((0.1 * currentCost) < previousCost) {
                        double r = CallChecker.varInit(((double) (currentCost / previousCost)), "r", 430, 19386, 19423);
                        actRed = 1.0 - (r * r);
                        CallChecker.varAssign(actRed, "actRed", 431, 19445, 19465);
                    }
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 437, 19685, 19695)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 437, 19685, 19695);
                            pj = CallChecker.isCalled(permutation, int[].class, 437, 19685, 19695)[j];
                            CallChecker.varAssign(pj, "pj", 437, 19685, 19695);
                        }
                        double dirJ = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(lmDir, double[].class, 438, 19735, 19739)) {
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 438, 19735, 19739);
                            dirJ = CallChecker.isCalled(lmDir, double[].class, 438, 19735, 19739)[pj];
                            CallChecker.varAssign(dirJ, "dirJ", 438, 19735, 19739);
                        }
                        if (CallChecker.beforeDeref(work1, double[].class, 439, 19766, 19770)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 439, 19766, 19770);
                            CallChecker.isCalled(work1, double[].class, 439, 19766, 19770)[j] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 439, 19766, 19770)[j], "CallChecker.isCalled(work1, double[].class, 439, 19766, 19770)[j]", 439, 19766, 19778);
                        }
                        for (int i = 0; i <= j; ++i) {
                            if (CallChecker.beforeDeref(work1, double[].class, 441, 19855, 19859)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 441, 19867, 19882)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 441, 19867, 19882);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 441, 19867, 19882)[i], double[].class, 441, 19867, 19885)) {
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 441, 19855, 19859);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 441, 19867, 19882);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 441, 19867, 19882)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 441, 19867, 19882)[i], double[].class, 441, 19867, 19885);
                                        CallChecker.isCalled(work1, double[].class, 441, 19855, 19859)[i] += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 441, 19867, 19882)[i], double[].class, 441, 19867, 19885)[pj]) * dirJ;
                                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 441, 19855, 19859)[i], "CallChecker.isCalled(work1, double[].class, 441, 19855, 19859)[i]", 441, 19855, 19897);
                                    }
                                }
                            }
                        }
                    }
                    double coeff1 = CallChecker.varInit(((double) (0)), "coeff1", 444, 19955, 19972);
                    for (int j = 0; j < (solvedCols); ++j) {
                        if (CallChecker.beforeDeref(work1, double[].class, 446, 20059, 20063)) {
                            if (CallChecker.beforeDeref(work1, double[].class, 446, 20070, 20074)) {
                                work1 = CallChecker.beforeCalled(work1, double[].class, 446, 20059, 20063);
                                work1 = CallChecker.beforeCalled(work1, double[].class, 446, 20070, 20074);
                                coeff1 += (CallChecker.isCalled(work1, double[].class, 446, 20059, 20063)[j]) * (CallChecker.isCalled(work1, double[].class, 446, 20070, 20074)[j]);
                                CallChecker.varAssign(coeff1, "coeff1", 446, 20049, 20078);
                            }
                        }
                    }
                    double pc2 = CallChecker.varInit(((double) (previousCost * previousCost)), "pc2", 448, 20114, 20154);
                    coeff1 = coeff1 / pc2;
                    CallChecker.varAssign(coeff1, "coeff1", 449, 20172, 20193);
                    double coeff2 = CallChecker.varInit(((double) ((((this.lmPar) * lmNorm) * lmNorm) / pc2)), "coeff2", 450, 20211, 20256);
                    double preRed = CallChecker.varInit(((double) (coeff1 + (2 * coeff2))), "preRed", 451, 20274, 20309);
                    double dirDer = CallChecker.varInit(((double) (-(coeff1 + coeff2))), "dirDer", 452, 20327, 20361);
                    if (preRed == 0) {
                        ratio = 0;
                        CallChecker.varAssign(ratio, "ratio", 455, 20446, 20491);
                    }else {
                        ratio = actRed / preRed;
                        CallChecker.varAssign(ratio, "ratio", 455, 20446, 20491);
                    }
                    if (ratio <= 0.25) {
                        double tmp = CallChecker.init(double.class);
                        if (actRed < 0) {
                            tmp = (0.5 * dirDer) / (dirDer + (0.5 * actRed));
                            CallChecker.varAssign(tmp, "tmp", 460, 20629, 20689);
                        }else {
                            tmp = 0.5;
                            CallChecker.varAssign(tmp, "tmp", 460, 20629, 20689);
                        }
                        if (((0.1 * currentCost) >= previousCost) || (tmp < 0.1)) {
                            tmp = 0.1;
                            CallChecker.varAssign(tmp, "tmp", 462, 20802, 20811);
                        }
                        delta = tmp * (FastMath.min(delta, (10.0 * lmNorm)));
                        CallChecker.varAssign(delta, "delta", 464, 20863, 20911);
                        lmPar /= tmp;
                        CallChecker.varAssign(this.lmPar, "this.lmPar", 465, 20937, 20949);
                    }else
                        if (((lmPar) == 0) || (ratio >= 0.75)) {
                            delta = 2 * lmNorm;
                            CallChecker.varAssign(delta, "delta", 467, 21033, 21051);
                            lmPar *= 0.5;
                            CallChecker.varAssign(this.lmPar, "this.lmPar", 468, 21073, 21085);
                        }
                    
                    if (ratio >= 1.0E-4) {
                        firstIteration = false;
                        CallChecker.varAssign(firstIteration, "firstIteration", 474, 21276, 21298);
                        xNorm = 0;
                        CallChecker.varAssign(xNorm, "xNorm", 475, 21320, 21329);
                        for (int k = 0; k < nC; ++k) {
                            double xK = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(diag, double[].class, 477, 21418, 21421)) {
                                if (CallChecker.beforeDeref(currentPoint, double[].class, 477, 21428, 21439)) {
                                    diag = CallChecker.beforeCalled(diag, double[].class, 477, 21418, 21421);
                                    xK = (CallChecker.isCalled(diag, double[].class, 477, 21418, 21421)[k]) * (CallChecker.isCalled(currentPoint, double[].class, 477, 21428, 21439)[k]);
                                    CallChecker.varAssign(xK, "xK", 477, 21418, 21421);
                                }
                            }
                            xNorm += xK * xK;
                            CallChecker.varAssign(xNorm, "xNorm", 478, 21469, 21485);
                        }
                        xNorm = FastMath.sqrt(xNorm);
                        CallChecker.varAssign(xNorm, "xNorm", 480, 21529, 21557);
                        if ((checker != null) && (checker.converged(iter, previous, current))) {
                            setCost(currentCost);
                            if (CallChecker.beforeDeref(current, PointVectorValuePair.class, 486, 21835, 21841)) {
                                current = CallChecker.beforeCalled(current, PointVectorValuePair.class, 486, 21835, 21841);
                                point = CallChecker.isCalled(current, PointVectorValuePair.class, 486, 21835, 21841).getPoint();
                                CallChecker.varAssign(this.point, "this.point", 486, 21827, 21853);
                            }
                            return current;
                        }
                    }else {
                        currentCost = previousCost;
                        CallChecker.varAssign(currentCost, "currentCost", 491, 22029, 22055);
                        for (int j = 0; j < (solvedCols); ++j) {
                            int pj = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(permutation, int[].class, 493, 22149, 22159)) {
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 493, 22149, 22159);
                                pj = CallChecker.isCalled(permutation, int[].class, 493, 22149, 22159)[j];
                                CallChecker.varAssign(pj, "pj", 493, 22149, 22159);
                            }
                            if (CallChecker.beforeDeref(currentPoint, double[].class, 494, 22189, 22200)) {
                                if (CallChecker.beforeDeref(oldX, double[].class, 494, 22208, 22211)) {
                                    oldX = CallChecker.beforeCalled(oldX, double[].class, 494, 22208, 22211);
                                    CallChecker.isCalled(currentPoint, double[].class, 494, 22189, 22200)[pj] = CallChecker.isCalled(oldX, double[].class, 494, 22208, 22211)[pj];
                                    CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 494, 22189, 22200)[pj], "CallChecker.isCalled(currentPoint, double[].class, 494, 22189, 22200)[pj]", 494, 22189, 22216);
                                }
                            }
                        }
                        tmpVec = weightedResidual;
                        CallChecker.varAssign(tmpVec, "tmpVec", 496, 22260, 22288);
                        weightedResidual = oldRes;
                        CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 497, 22310, 22335);
                        oldRes = tmpVec;
                        CallChecker.varAssign(oldRes, "oldRes", 498, 22357, 22375);
                        tmpVec = currentObjective;
                        CallChecker.varAssign(tmpVec, "tmpVec", 499, 22397, 22425);
                        currentObjective = oldObj;
                        CallChecker.varAssign(currentObjective, "currentObjective", 500, 22447, 22472);
                        oldObj = tmpVec;
                        CallChecker.varAssign(oldObj, "oldObj", 501, 22494, 22512);
                        current = new PointVectorValuePair(currentPoint, currentObjective);
                        CallChecker.varAssign(current, "current", 503, 22593, 22659);
                    }
                    if (((((FastMath.abs(actRed)) <= (costRelativeTolerance)) && (preRed <= (costRelativeTolerance))) && (ratio <= 2.0)) || (delta <= ((parRelativeTolerance) * xNorm))) {
                        setCost(currentCost);
                        if (CallChecker.beforeDeref(current, PointVectorValuePair.class, 513, 23082, 23088)) {
                            current = CallChecker.beforeCalled(current, PointVectorValuePair.class, 513, 23082, 23088);
                            point = CallChecker.isCalled(current, PointVectorValuePair.class, 513, 23082, 23088).getPoint();
                            CallChecker.varAssign(this.point, "this.point", 513, 23074, 23100);
                        }
                        return current;
                    }
                    if ((((FastMath.abs(actRed)) <= 2.2204E-16) && (preRed <= 2.2204E-16)) && (ratio <= 2.0)) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, costRelativeTolerance);
                    }else
                        if (delta <= (2.2204E-16 * xNorm)) {
                            throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, parRelativeTolerance);
                        }else
                            if (maxCosine <= 2.2204E-16) {
                                throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, orthoTolerance);
                            }
                        
                    
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2576.methodEnd();
        }
    }

    private void determineLMParameter(double[] qy, double delta, double[] diag, double[] work1, double[] work2, double[] work3) {
        MethodContext _bcornu_methode_context2577 = new MethodContext(void.class, 555, 24092, 30379);
        try {
            CallChecker.varInit(this, "this", 555, 24092, 30379);
            CallChecker.varInit(work3, "work3", 555, 24092, 30379);
            CallChecker.varInit(work2, "work2", 555, 24092, 30379);
            CallChecker.varInit(work1, "work1", 555, 24092, 30379);
            CallChecker.varInit(diag, "diag", 555, 24092, 30379);
            CallChecker.varInit(delta, "delta", 555, 24092, 30379);
            CallChecker.varInit(qy, "qy", 555, 24092, 30379);
            CallChecker.varInit(this.evaluations, "evaluations", 555, 24092, 30379);
            CallChecker.varInit(this.cost, "cost", 555, 24092, 30379);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 555, 24092, 30379);
            CallChecker.varInit(this.objective, "objective", 555, 24092, 30379);
            CallChecker.varInit(this.point, "point", 555, 24092, 30379);
            CallChecker.varInit(this.rows, "rows", 555, 24092, 30379);
            CallChecker.varInit(this.cols, "cols", 555, 24092, 30379);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 555, 24092, 30379);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 555, 24092, 30379);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 555, 24092, 30379);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 555, 24092, 30379);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 555, 24092, 30379);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 555, 24092, 30379);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 555, 24092, 30379);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 555, 24092, 30379);
            CallChecker.varInit(this.lmDir, "lmDir", 555, 24092, 30379);
            CallChecker.varInit(this.lmPar, "lmPar", 555, 24092, 30379);
            CallChecker.varInit(this.rank, "rank", 555, 24092, 30379);
            CallChecker.varInit(this.permutation, "permutation", 555, 24092, 30379);
            CallChecker.varInit(this.beta, "beta", 555, 24092, 30379);
            CallChecker.varInit(this.jacNorm, "jacNorm", 555, 24092, 30379);
            CallChecker.varInit(this.diagR, "diagR", 555, 24092, 30379);
            CallChecker.varInit(this.solvedCols, "solvedCols", 555, 24092, 30379);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 557, 25136, 25151);
            CallChecker.isCalled(weightedJacobian, double[][].class, 557, 25136, 25151)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 557, 25136, 25151)[0], double[].class, 557, 25136, 25154);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 557, 25136, 25151)[0], double[].class, 557, 25136, 25154).length)), "nC", 557, 25121, 25162);
            for (int j = 0; j < (rank); ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 562, 25364, 25374)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 562, 25358, 25362)) {
                        if (CallChecker.beforeDeref(qy, double[].class, 562, 25382, 25383)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 562, 25364, 25374);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 562, 25358, 25362);
                            qy = CallChecker.beforeCalled(qy, double[].class, 562, 25382, 25383);
                            CallChecker.isCalled(lmDir, double[].class, 562, 25358, 25362)[CallChecker.isCalled(permutation, int[].class, 562, 25364, 25374)[j]] = CallChecker.isCalled(qy, double[].class, 562, 25382, 25383)[j];
                            CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 562, 25358, 25362)[CallChecker.isCalled(this.permutation, int[].class, 562, 25364, 25374)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 562, 25358, 25362)[CallChecker.isCalled(this.permutation, int[].class, 562, 25364, 25374)[j]]", 562, 25358, 25387);
                        }
                    }
                }
            }
            for (int j = rank; j < nC; ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 565, 25459, 25469)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 565, 25453, 25457)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 565, 25459, 25469);
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 565, 25453, 25457);
                        CallChecker.isCalled(lmDir, double[].class, 565, 25453, 25457)[CallChecker.isCalled(permutation, int[].class, 565, 25459, 25469)[j]] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 565, 25453, 25457)[CallChecker.isCalled(this.permutation, int[].class, 565, 25459, 25469)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 565, 25453, 25457)[CallChecker.isCalled(this.permutation, int[].class, 565, 25459, 25469)[j]]", 565, 25453, 25478);
                    }
                }
            }
            for (int k = (rank) - 1; k >= 0; --k) {
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 568, 25557, 25567)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 568, 25557, 25567);
                    pk = CallChecker.isCalled(permutation, int[].class, 568, 25557, 25567)[k];
                    CallChecker.varAssign(pk, "pk", 568, 25557, 25567);
                }
                double ypk = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lmDir, double[].class, 569, 25598, 25602)) {
                    if (CallChecker.beforeDeref(diagR, double[].class, 569, 25610, 25614)) {
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 569, 25598, 25602);
                        diagR = CallChecker.beforeCalled(diagR, double[].class, 569, 25610, 25614);
                        ypk = (CallChecker.isCalled(lmDir, double[].class, 569, 25598, 25602)[pk]) / (CallChecker.isCalled(diagR, double[].class, 569, 25610, 25614)[pk]);
                        CallChecker.varAssign(ypk, "ypk", 569, 25598, 25602);
                    }
                }
                for (int i = 0; i < k; ++i) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 571, 25685, 25695)) {
                        if (CallChecker.beforeDeref(lmDir, double[].class, 571, 25679, 25683)) {
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 571, 25710, 25725)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 571, 25710, 25725);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 571, 25710, 25725)[i], double[].class, 571, 25710, 25728)) {
                                    permutation = CallChecker.beforeCalled(permutation, int[].class, 571, 25685, 25695);
                                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 571, 25679, 25683);
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 571, 25710, 25725);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 571, 25710, 25725)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 571, 25710, 25725)[i], double[].class, 571, 25710, 25728);
                                    CallChecker.isCalled(lmDir, double[].class, 571, 25679, 25683)[CallChecker.isCalled(permutation, int[].class, 571, 25685, 25695)[i]] -= ypk * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 571, 25710, 25725)[i], double[].class, 571, 25710, 25728)[pk]);
                                    CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 571, 25679, 25683)[CallChecker.isCalled(this.permutation, int[].class, 571, 25685, 25695)[i]], "CallChecker.isCalled(this.lmDir, double[].class, 571, 25679, 25683)[CallChecker.isCalled(this.permutation, int[].class, 571, 25685, 25695)[i]]", 571, 25679, 25733);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDir, double[].class, 573, 25761, 25765)) {
                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 573, 25761, 25765);
                    CallChecker.isCalled(lmDir, double[].class, 573, 25761, 25765)[pk] = ypk;
                    CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 573, 25761, 25765)[pk], "CallChecker.isCalled(this.lmDir, double[].class, 573, 25761, 25765)[pk]", 573, 25761, 25776);
                }
            }
            double dxNorm = CallChecker.varInit(((double) (0)), "dxNorm", 578, 25910, 25927);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 580, 25997, 26007)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 580, 25997, 26007);
                    pj = CallChecker.isCalled(permutation, int[].class, 580, 25997, 26007)[j];
                    CallChecker.varAssign(pj, "pj", 580, 25997, 26007);
                }
                double s = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(diag, double[].class, 581, 26036, 26039)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 581, 26047, 26051)) {
                        diag = CallChecker.beforeCalled(diag, double[].class, 581, 26036, 26039);
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 581, 26047, 26051);
                        s = (CallChecker.isCalled(diag, double[].class, 581, 26036, 26039)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 581, 26047, 26051)[pj]);
                        CallChecker.varAssign(s, "s", 581, 26036, 26039);
                    }
                }
                if (CallChecker.beforeDeref(work1, double[].class, 582, 26070, 26074)) {
                    work1 = CallChecker.beforeCalled(work1, double[].class, 582, 26070, 26074);
                    CallChecker.isCalled(work1, double[].class, 582, 26070, 26074)[pj] = s;
                    CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 582, 26070, 26074)[pj], "CallChecker.isCalled(work1, double[].class, 582, 26070, 26074)[pj]", 582, 26070, 26083);
                }
                dxNorm += s * s;
                CallChecker.varAssign(dxNorm, "dxNorm", 583, 26097, 26112);
            }
            dxNorm = FastMath.sqrt(dxNorm);
            CallChecker.varAssign(dxNorm, "dxNorm", 585, 26132, 26162);
            double fp = CallChecker.varInit(((double) (dxNorm - delta)), "fp", 586, 26172, 26198);
            if (fp <= (0.1 * delta)) {
                lmPar = 0;
                CallChecker.varAssign(this.lmPar, "this.lmPar", 588, 26245, 26254);
                return ;
            }
            double sum2 = CallChecker.init(double.class);
            double parl = CallChecker.varInit(((double) (0)), "parl", 596, 26497, 26512);
            if ((rank) == (solvedCols)) {
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 599, 26624, 26634)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 599, 26624, 26634);
                        pj = CallChecker.isCalled(permutation, int[].class, 599, 26624, 26634)[j];
                        CallChecker.varAssign(pj, "pj", 599, 26624, 26634);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 600, 26656, 26660)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 600, 26669, 26672)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 600, 26656, 26660);
                            diag = CallChecker.beforeCalled(diag, double[].class, 600, 26669, 26672);
                            CallChecker.isCalled(work1, double[].class, 600, 26656, 26660)[pj] *= (CallChecker.isCalled(diag, double[].class, 600, 26669, 26672)[pj]) / dxNorm;
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 600, 26656, 26660)[pj], "CallChecker.isCalled(work1, double[].class, 600, 26656, 26660)[pj]", 600, 26656, 26686);
                        }
                    }
                }
                sum2 = 0;
                CallChecker.varAssign(sum2, "sum2", 602, 26714, 26722);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 604, 26800, 26810)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 604, 26800, 26810);
                        pj = CallChecker.isCalled(permutation, int[].class, 604, 26800, 26810)[j];
                        CallChecker.varAssign(pj, "pj", 604, 26800, 26810);
                    }
                    double sum = CallChecker.varInit(((double) (0)), "sum", 605, 26832, 26846);
                    for (int i = 0; i < j; ++i) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 607, 26921, 26936)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 607, 26921, 26936);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 607, 26921, 26936)[i], double[].class, 607, 26921, 26939)) {
                                if (CallChecker.beforeDeref(permutation, int[].class, 607, 26953, 26963)) {
                                    if (CallChecker.beforeDeref(work1, double[].class, 607, 26947, 26951)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 607, 26921, 26936);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 607, 26921, 26936)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 607, 26921, 26936)[i], double[].class, 607, 26921, 26939);
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 607, 26953, 26963);
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 607, 26947, 26951);
                                        sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 607, 26921, 26936)[i], double[].class, 607, 26921, 26939)[pj]) * (CallChecker.isCalled(work1, double[].class, 607, 26947, 26951)[CallChecker.isCalled(permutation, int[].class, 607, 26953, 26963)[i]]);
                                        CallChecker.varAssign(sum, "sum", 607, 26914, 26968);
                                    }
                                }
                            }
                        }
                    }
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(work1, double[].class, 609, 27016, 27020)) {
                        if (CallChecker.beforeDeref(diagR, double[].class, 609, 27035, 27039)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 609, 27016, 27020);
                            diagR = CallChecker.beforeCalled(diagR, double[].class, 609, 27035, 27039);
                            s = ((CallChecker.isCalled(work1, double[].class, 609, 27016, 27020)[pj]) - sum) / (CallChecker.isCalled(diagR, double[].class, 609, 27035, 27039)[pj]);
                            CallChecker.varAssign(s, "s", 609, 27016, 27020);
                        }
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 610, 27062, 27066)) {
                        work1 = CallChecker.beforeCalled(work1, double[].class, 610, 27062, 27066);
                        CallChecker.isCalled(work1, double[].class, 610, 27062, 27066)[pj] = s;
                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 610, 27062, 27066)[pj], "CallChecker.isCalled(work1, double[].class, 610, 27062, 27066)[pj]", 610, 27062, 27075);
                    }
                    sum2 += s * s;
                    CallChecker.varAssign(sum2, "sum2", 611, 27093, 27106);
                }
                parl = fp / (delta * sum2);
                CallChecker.varAssign(parl, "parl", 613, 27134, 27160);
            }
            sum2 = 0;
            CallChecker.varAssign(sum2, "sum2", 617, 27253, 27261);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 619, 27331, 27341)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 619, 27331, 27341);
                    pj = CallChecker.isCalled(permutation, int[].class, 619, 27331, 27341)[j];
                    CallChecker.varAssign(pj, "pj", 619, 27331, 27341);
                }
                double sum = CallChecker.varInit(((double) (0)), "sum", 620, 27359, 27373);
                for (int i = 0; i <= j; ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 622, 27441, 27456)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 622, 27441, 27456);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 622, 27441, 27456)[i], double[].class, 622, 27441, 27459)) {
                            if (CallChecker.beforeDeref(qy, double[].class, 622, 27467, 27468)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 622, 27441, 27456);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 622, 27441, 27456)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 622, 27441, 27456)[i], double[].class, 622, 27441, 27459);
                                qy = CallChecker.beforeCalled(qy, double[].class, 622, 27467, 27468);
                                sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 622, 27441, 27456)[i], double[].class, 622, 27441, 27459)[pj]) * (CallChecker.isCalled(qy, double[].class, 622, 27467, 27468)[i]);
                                CallChecker.varAssign(sum, "sum", 622, 27434, 27472);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(diag, double[].class, 624, 27507, 27510)) {
                    diag = CallChecker.beforeCalled(diag, double[].class, 624, 27507, 27510);
                    sum /= CallChecker.isCalled(diag, double[].class, 624, 27507, 27510)[pj];
                    CallChecker.varAssign(sum, "sum", 624, 27500, 27515);
                }
                sum2 += sum * sum;
                CallChecker.varAssign(sum2, "sum2", 625, 27529, 27546);
            }
            double gNorm = CallChecker.varInit(((double) (FastMath.sqrt(sum2))), "gNorm", 627, 27566, 27600);
            double paru = CallChecker.varInit(((double) (gNorm / delta)), "paru", 628, 27610, 27637);
            if (paru == 0) {
                paru = 2.2251E-308 / (FastMath.min(delta, 0.1));
                CallChecker.varAssign(paru, "paru", 631, 27744, 27789);
            }
            lmPar = FastMath.min(paru, FastMath.max(lmPar, parl));
            CallChecker.varAssign(this.lmPar, "this.lmPar", 636, 27922, 27975);
            if ((lmPar) == 0) {
                lmPar = gNorm / dxNorm;
                CallChecker.varAssign(this.lmPar, "this.lmPar", 638, 28015, 28037);
            }
            for (int countdown = 10; countdown >= 0; --countdown) {
                if ((lmPar) == 0) {
                    lmPar = FastMath.max(2.2251E-308, (0.001 * paru));
                    CallChecker.varAssign(this.lmPar, "this.lmPar", 645, 28228, 28275);
                }
                double sPar = CallChecker.varInit(((double) (FastMath.sqrt(this.lmPar))), "sPar", 647, 28303, 28337);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 649, 28415, 28425)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 649, 28415, 28425);
                        pj = CallChecker.isCalled(permutation, int[].class, 649, 28415, 28425)[j];
                        CallChecker.varAssign(pj, "pj", 649, 28415, 28425);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 650, 28447, 28451)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 650, 28466, 28469)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 650, 28447, 28451);
                            diag = CallChecker.beforeCalled(diag, double[].class, 650, 28466, 28469);
                            CallChecker.isCalled(work1, double[].class, 650, 28447, 28451)[pj] = sPar * (CallChecker.isCalled(diag, double[].class, 650, 28466, 28469)[pj]);
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 650, 28447, 28451)[pj], "CallChecker.isCalled(work1, double[].class, 650, 28447, 28451)[pj]", 650, 28447, 28474);
                        }
                    }
                }
                determineLMDirection(qy, work1, work2, work3);
                dxNorm = 0;
                CallChecker.varAssign(dxNorm, "dxNorm", 654, 28562, 28572);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 656, 28650, 28660)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 656, 28650, 28660);
                        pj = CallChecker.isCalled(permutation, int[].class, 656, 28650, 28660)[j];
                        CallChecker.varAssign(pj, "pj", 656, 28650, 28660);
                    }
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(diag, double[].class, 657, 28693, 28696)) {
                        if (CallChecker.beforeDeref(lmDir, double[].class, 657, 28704, 28708)) {
                            diag = CallChecker.beforeCalled(diag, double[].class, 657, 28693, 28696);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 657, 28704, 28708);
                            s = (CallChecker.isCalled(diag, double[].class, 657, 28693, 28696)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 657, 28704, 28708)[pj]);
                            CallChecker.varAssign(s, "s", 657, 28693, 28696);
                        }
                    }
                    if (CallChecker.beforeDeref(work3, double[].class, 658, 28731, 28735)) {
                        work3 = CallChecker.beforeCalled(work3, double[].class, 658, 28731, 28735);
                        CallChecker.isCalled(work3, double[].class, 658, 28731, 28735)[pj] = s;
                        CallChecker.varAssign(CallChecker.isCalled(work3, double[].class, 658, 28731, 28735)[pj], "CallChecker.isCalled(work3, double[].class, 658, 28731, 28735)[pj]", 658, 28731, 28744);
                    }
                    dxNorm += s * s;
                    CallChecker.varAssign(dxNorm, "dxNorm", 659, 28762, 28777);
                }
                dxNorm = FastMath.sqrt(dxNorm);
                CallChecker.varAssign(dxNorm, "dxNorm", 661, 28805, 28835);
                double previousFP = CallChecker.varInit(((double) (fp)), "previousFP", 662, 28849, 28871);
                fp = dxNorm - delta;
                CallChecker.varAssign(fp, "fp", 663, 28885, 28904);
                if (((FastMath.abs(fp)) <= (0.1 * delta)) || (((parl == 0) && (fp <= previousFP)) && (previousFP < 0))) {
                    return ;
                }
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 674, 29352, 29362)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 674, 29352, 29362);
                        pj = CallChecker.isCalled(permutation, int[].class, 674, 29352, 29362)[j];
                        CallChecker.varAssign(pj, "pj", 674, 29352, 29362);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 675, 29384, 29388)) {
                        if (CallChecker.beforeDeref(work3, double[].class, 675, 29396, 29400)) {
                            if (CallChecker.beforeDeref(diag, double[].class, 675, 29408, 29411)) {
                                work1 = CallChecker.beforeCalled(work1, double[].class, 675, 29384, 29388);
                                work3 = CallChecker.beforeCalled(work3, double[].class, 675, 29396, 29400);
                                diag = CallChecker.beforeCalled(diag, double[].class, 675, 29408, 29411);
                                CallChecker.isCalled(work1, double[].class, 675, 29384, 29388)[pj] = ((CallChecker.isCalled(work3, double[].class, 675, 29396, 29400)[pj]) * (CallChecker.isCalled(diag, double[].class, 675, 29408, 29411)[pj])) / dxNorm;
                                CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 675, 29384, 29388)[pj], "CallChecker.isCalled(work1, double[].class, 675, 29384, 29388)[pj]", 675, 29384, 29425);
                            }
                        }
                    }
                }
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 678, 29517, 29527)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 678, 29517, 29527);
                        pj = CallChecker.isCalled(permutation, int[].class, 678, 29517, 29527)[j];
                        CallChecker.varAssign(pj, "pj", 678, 29517, 29527);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 679, 29549, 29553)) {
                        if (CallChecker.beforeDeref(work2, double[].class, 679, 29562, 29566)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 679, 29549, 29553);
                            work2 = CallChecker.beforeCalled(work2, double[].class, 679, 29562, 29566);
                            CallChecker.isCalled(work1, double[].class, 679, 29549, 29553)[pj] /= CallChecker.isCalled(work2, double[].class, 679, 29562, 29566)[j];
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 679, 29549, 29553)[pj], "CallChecker.isCalled(work1, double[].class, 679, 29549, 29553)[pj]", 679, 29549, 29570);
                        }
                    }
                    double tmp = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(work1, double[].class, 680, 29601, 29605)) {
                        work1 = CallChecker.beforeCalled(work1, double[].class, 680, 29601, 29605);
                        tmp = CallChecker.isCalled(work1, double[].class, 680, 29601, 29605)[pj];
                        CallChecker.varAssign(tmp, "tmp", 680, 29601, 29605);
                    }
                    for (int i = j + 1; i < (solvedCols); ++i) {
                        if (CallChecker.beforeDeref(permutation, int[].class, 682, 29697, 29707)) {
                            if (CallChecker.beforeDeref(work1, double[].class, 682, 29691, 29695)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 682, 29716, 29731)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 682, 29716, 29731);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 682, 29716, 29731)[i], double[].class, 682, 29716, 29734)) {
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 682, 29697, 29707);
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 682, 29691, 29695);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 682, 29716, 29731);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 682, 29716, 29731)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 682, 29716, 29731)[i], double[].class, 682, 29716, 29734);
                                        CallChecker.isCalled(work1, double[].class, 682, 29691, 29695)[CallChecker.isCalled(permutation, int[].class, 682, 29697, 29707)[i]] -= (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 682, 29716, 29731)[i], double[].class, 682, 29716, 29734)[pj]) * tmp;
                                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 682, 29691, 29695)[CallChecker.isCalled(this.permutation, int[].class, 682, 29697, 29707)[i]], "CallChecker.isCalled(work1, double[].class, 682, 29691, 29695)[CallChecker.isCalled(this.permutation, int[].class, 682, 29697, 29707)[i]]", 682, 29691, 29745);
                                    }
                                }
                            }
                        }
                    }
                }
                sum2 = 0;
                CallChecker.varAssign(sum2, "sum2", 685, 29791, 29799);
                for (int j = 0; j < (solvedCols); ++j) {
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 687, 29885, 29895)) {
                        if (CallChecker.beforeDeref(work1, double[].class, 687, 29879, 29883)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 687, 29885, 29895);
                            work1 = CallChecker.beforeCalled(work1, double[].class, 687, 29879, 29883);
                            s = CallChecker.isCalled(work1, double[].class, 687, 29879, 29883)[CallChecker.isCalled(permutation, int[].class, 687, 29885, 29895)[j]];
                            CallChecker.varAssign(s, "s", 687, 29885, 29895);
                        }
                    }
                    sum2 += s * s;
                    CallChecker.varAssign(sum2, "sum2", 688, 29918, 29931);
                }
                double correction = CallChecker.varInit(((double) (fp / (delta * sum2))), "correction", 690, 29959, 29998);
                if (fp > 0) {
                    parl = FastMath.max(parl, lmPar);
                    CallChecker.varAssign(parl, "parl", 694, 30118, 30150);
                }else
                    if (fp < 0) {
                        paru = FastMath.min(paru, lmPar);
                        CallChecker.varAssign(paru, "paru", 696, 30201, 30233);
                    }
                
                lmPar = FastMath.max(parl, ((lmPar) + correction));
                CallChecker.varAssign(this.lmPar, "this.lmPar", 700, 30316, 30362);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2577.methodEnd();
        }
    }

    private void determineLMDirection(double[] qy, double[] diag, double[] lmDiag, double[] work) {
        MethodContext _bcornu_methode_context2578 = new MethodContext(void.class, 725, 30386, 35268);
        try {
            CallChecker.varInit(this, "this", 725, 30386, 35268);
            CallChecker.varInit(work, "work", 725, 30386, 35268);
            CallChecker.varInit(lmDiag, "lmDiag", 725, 30386, 35268);
            CallChecker.varInit(diag, "diag", 725, 30386, 35268);
            CallChecker.varInit(qy, "qy", 725, 30386, 35268);
            CallChecker.varInit(this.evaluations, "evaluations", 725, 30386, 35268);
            CallChecker.varInit(this.cost, "cost", 725, 30386, 35268);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 725, 30386, 35268);
            CallChecker.varInit(this.objective, "objective", 725, 30386, 35268);
            CallChecker.varInit(this.point, "point", 725, 30386, 35268);
            CallChecker.varInit(this.rows, "rows", 725, 30386, 35268);
            CallChecker.varInit(this.cols, "cols", 725, 30386, 35268);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 725, 30386, 35268);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 725, 30386, 35268);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 725, 30386, 35268);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 725, 30386, 35268);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 725, 30386, 35268);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 725, 30386, 35268);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 725, 30386, 35268);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 725, 30386, 35268);
            CallChecker.varInit(this.lmDir, "lmDir", 725, 30386, 35268);
            CallChecker.varInit(this.lmPar, "lmPar", 725, 30386, 35268);
            CallChecker.varInit(this.rank, "rank", 725, 30386, 35268);
            CallChecker.varInit(this.permutation, "permutation", 725, 30386, 35268);
            CallChecker.varInit(this.beta, "beta", 725, 30386, 35268);
            CallChecker.varInit(this.jacNorm, "jacNorm", 725, 30386, 35268);
            CallChecker.varInit(this.diagR, "diagR", 725, 30386, 35268);
            CallChecker.varInit(this.solvedCols, "solvedCols", 725, 30386, 35268);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 731, 31514, 31524)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 731, 31514, 31524);
                    pj = CallChecker.isCalled(permutation, int[].class, 731, 31514, 31524)[j];
                    CallChecker.varAssign(pj, "pj", 731, 31514, 31524);
                }
                for (int i = j + 1; i < (solvedCols); ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 733, 31601, 31616)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 733, 31601, 31616);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31601, 31616)[i], double[].class, 733, 31601, 31619)) {
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 733, 31627, 31642)) {
                                if (CallChecker.beforeDeref(permutation, int[].class, 733, 31647, 31657)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 733, 31627, 31642);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31627, 31642)[j], double[].class, 733, 31627, 31645)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 733, 31601, 31616);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31601, 31616)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31601, 31616)[i], double[].class, 733, 31601, 31619);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 733, 31627, 31642);
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 733, 31647, 31657);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31627, 31642)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31627, 31642)[j], double[].class, 733, 31627, 31645);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31601, 31616)[i], double[].class, 733, 31601, 31619)[pj] = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 733, 31627, 31642)[j], double[].class, 733, 31627, 31645)[CallChecker.isCalled(permutation, int[].class, 733, 31647, 31657)[i]];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 733, 31601, 31616)[i], double[].class, 733, 31601, 31619)[pj], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 733, 31601, 31616)[i], double[].class, 733, 31601, 31619)[pj]", 733, 31601, 31662);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDir, double[].class, 735, 31690, 31694)) {
                    if (CallChecker.beforeDeref(diagR, double[].class, 735, 31701, 31705)) {
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 735, 31690, 31694);
                        diagR = CallChecker.beforeCalled(diagR, double[].class, 735, 31701, 31705);
                        CallChecker.isCalled(lmDir, double[].class, 735, 31690, 31694)[j] = CallChecker.isCalled(diagR, double[].class, 735, 31701, 31705)[pj];
                        CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 735, 31690, 31694)[j], "CallChecker.isCalled(this.lmDir, double[].class, 735, 31690, 31694)[j]", 735, 31690, 31710);
                    }
                }
                if (CallChecker.beforeDeref(work, double[].class, 736, 31724, 31727)) {
                    if (CallChecker.beforeDeref(qy, double[].class, 736, 31735, 31736)) {
                        work = CallChecker.beforeCalled(work, double[].class, 736, 31724, 31727);
                        qy = CallChecker.beforeCalled(qy, double[].class, 736, 31735, 31736);
                        CallChecker.isCalled(work, double[].class, 736, 31724, 31727)[j] = CallChecker.isCalled(qy, double[].class, 736, 31735, 31736)[j];
                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 736, 31724, 31727)[j], "CallChecker.isCalled(work, double[].class, 736, 31724, 31727)[j]", 736, 31724, 31740);
                    }
                }
            }
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 744, 32024, 32034)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 744, 32024, 32034);
                    pj = CallChecker.isCalled(permutation, int[].class, 744, 32024, 32034)[j];
                    CallChecker.varAssign(pj, "pj", 744, 32024, 32034);
                }
                double dpj = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(diag, double[].class, 745, 32065, 32068)) {
                    diag = CallChecker.beforeCalled(diag, double[].class, 745, 32065, 32068);
                    dpj = CallChecker.isCalled(diag, double[].class, 745, 32065, 32068)[pj];
                    CallChecker.varAssign(dpj, "dpj", 745, 32065, 32068);
                }
                if (dpj != 0) {
                    if (CallChecker.beforeDeref(lmDiag, double[].class, 747, 32146, 32151)) {
                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 747, 32146, 32151);
                        Arrays.fill(lmDiag, (j + 1), CallChecker.isCalled(lmDiag, double[].class, 747, 32146, 32151).length, 0);
                    }
                }
                if (CallChecker.beforeDeref(lmDiag, double[].class, 749, 32191, 32196)) {
                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 749, 32191, 32196);
                    CallChecker.isCalled(lmDiag, double[].class, 749, 32191, 32196)[j] = dpj;
                    CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 749, 32191, 32196)[j], "CallChecker.isCalled(lmDiag, double[].class, 749, 32191, 32196)[j]", 749, 32191, 32206);
                }
                double qtbpj = CallChecker.varInit(((double) (0)), "qtbpj", 754, 32394, 32410);
                for (int k = j; k < (solvedCols); ++k) {
                    int pk = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 756, 32488, 32498)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 756, 32488, 32498);
                        pk = CallChecker.isCalled(permutation, int[].class, 756, 32488, 32498)[k];
                        CallChecker.varAssign(pk, "pk", 756, 32488, 32498);
                    }
                    if (CallChecker.beforeDeref(lmDiag, double[].class, 760, 32656, 32661)) {
                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 760, 32656, 32661);
                        if ((CallChecker.isCalled(lmDiag, double[].class, 760, 32656, 32661)[k]) != 0) {
                            double sin = CallChecker.init(double.class);
                            double cos = CallChecker.init(double.class);
                            double rkk = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 764, 32784, 32799)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 764, 32784, 32799);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 764, 32784, 32799)[k], double[].class, 764, 32784, 32802)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 764, 32784, 32799);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 764, 32784, 32799)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 764, 32784, 32799)[k], double[].class, 764, 32784, 32802);
                                    rkk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 764, 32784, 32799)[k], double[].class, 764, 32784, 32802)[pk];
                                    CallChecker.varAssign(rkk, "rkk", 764, 32784, 32799);
                                }
                            }
                            if (CallChecker.beforeDeref(lmDiag, double[].class, 765, 32866, 32871)) {
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 765, 32866, 32871);
                                if ((FastMath.abs(rkk)) < (FastMath.abs(CallChecker.isCalled(lmDiag, double[].class, 765, 32866, 32871)[k]))) {
                                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 766, 32931, 32936);
                                    final double cotan = CallChecker.varInit(((double) (rkk / (CallChecker.isCalled(lmDiag, double[].class, 766, 32931, 32936)[k]))), "cotan", 766, 32904, 32940);
                                    sin = 1.0 / (FastMath.sqrt((1.0 + (cotan * cotan))));
                                    CallChecker.varAssign(sin, "sin", 767, 32966, 33014);
                                    cos = sin * cotan;
                                    CallChecker.varAssign(cos, "cos", 768, 33040, 33059);
                                }else {
                                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 770, 33133, 33138);
                                    final double tan = CallChecker.varInit(((double) ((CallChecker.isCalled(lmDiag, double[].class, 770, 33133, 33138)[k]) / rkk)), "tan", 770, 33114, 33148);
                                    cos = 1.0 / (FastMath.sqrt((1.0 + (tan * tan))));
                                    CallChecker.varAssign(cos, "cos", 771, 33174, 33216);
                                    sin = cos * tan;
                                    CallChecker.varAssign(sin, "sin", 772, 33242, 33257);
                                }
                            }
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 777, 33427, 33442)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 777, 33427, 33442);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 777, 33427, 33442)[k], double[].class, 777, 33427, 33445)) {
                                    if (CallChecker.beforeDeref(lmDiag, double[].class, 777, 33471, 33476)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 777, 33427, 33442);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 777, 33427, 33442)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 777, 33427, 33442)[k], double[].class, 777, 33427, 33445);
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 777, 33471, 33476);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 777, 33427, 33442)[k], double[].class, 777, 33427, 33445)[pk] = (cos * rkk) + (sin * (CallChecker.isCalled(lmDiag, double[].class, 777, 33471, 33476)[k]));
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 777, 33427, 33442)[k], double[].class, 777, 33427, 33445)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 777, 33427, 33442)[k], double[].class, 777, 33427, 33445)[pk]", 777, 33427, 33480);
                                    }
                                }
                            }
                            work = CallChecker.beforeCalled(work, double[].class, 778, 33528, 33531);
                            final double temp = CallChecker.varInit(((double) ((cos * (CallChecker.isCalled(work, double[].class, 778, 33528, 33531)[k])) + (sin * qtbpj))), "temp", 778, 33502, 33549);
                            if (CallChecker.beforeDeref(work, double[].class, 779, 33586, 33589)) {
                                work = CallChecker.beforeCalled(work, double[].class, 779, 33586, 33589);
                                qtbpj = ((-sin) * (CallChecker.isCalled(work, double[].class, 779, 33586, 33589)[k])) + (cos * qtbpj);
                                CallChecker.varAssign(qtbpj, "qtbpj", 779, 33571, 33607);
                            }
                            if (CallChecker.beforeDeref(work, double[].class, 780, 33629, 33632)) {
                                work = CallChecker.beforeCalled(work, double[].class, 780, 33629, 33632);
                                CallChecker.isCalled(work, double[].class, 780, 33629, 33632)[k] = temp;
                                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 780, 33629, 33632)[k], "CallChecker.isCalled(work, double[].class, 780, 33629, 33632)[k]", 780, 33629, 33643);
                            }
                            for (int i = k + 1; i < (solvedCols); ++i) {
                                double rik = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 784, 33814, 33829)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 784, 33814, 33829);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 784, 33814, 33829)[i], double[].class, 784, 33814, 33832)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 784, 33814, 33829);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 784, 33814, 33829)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 784, 33814, 33829)[i], double[].class, 784, 33814, 33832);
                                        rik = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 784, 33814, 33829)[i], double[].class, 784, 33814, 33832)[pk];
                                        CallChecker.varAssign(rik, "rik", 784, 33814, 33829);
                                    }
                                }
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 785, 33902, 33907);
                                final double temp2 = CallChecker.varInit(((double) ((cos * rik) + (sin * (CallChecker.isCalled(lmDiag, double[].class, 785, 33902, 33907)[i])))), "temp2", 785, 33863, 33911);
                                if (CallChecker.beforeDeref(lmDiag, double[].class, 786, 33937, 33942)) {
                                    if (CallChecker.beforeDeref(lmDiag, double[].class, 786, 33968, 33973)) {
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 786, 33937, 33942);
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 786, 33968, 33973);
                                        CallChecker.isCalled(lmDiag, double[].class, 786, 33937, 33942)[i] = ((-sin) * rik) + (cos * (CallChecker.isCalled(lmDiag, double[].class, 786, 33968, 33973)[i]));
                                        CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 786, 33937, 33942)[i], "CallChecker.isCalled(lmDiag, double[].class, 786, 33937, 33942)[i]", 786, 33937, 33977);
                                    }
                                }
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 787, 34003, 34018)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 787, 34003, 34018);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 787, 34003, 34018)[i], double[].class, 787, 34003, 34021)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 787, 34003, 34018);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 787, 34003, 34018)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 787, 34003, 34018)[i], double[].class, 787, 34003, 34021);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 787, 34003, 34018)[i], double[].class, 787, 34003, 34021)[pk] = temp2;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 787, 34003, 34018)[i], double[].class, 787, 34003, 34021)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 787, 34003, 34018)[i], double[].class, 787, 34003, 34021)[pk]", 787, 34003, 34034);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDiag, double[].class, 794, 34217, 34222)) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 794, 34229, 34244)) {
                        if (CallChecker.beforeDeref(permutation, int[].class, 794, 34249, 34259)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 794, 34229, 34244);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 794, 34229, 34244)[j], double[].class, 794, 34229, 34247)) {
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 794, 34217, 34222);
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 794, 34229, 34244);
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 794, 34249, 34259);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 794, 34229, 34244)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 794, 34229, 34244)[j], double[].class, 794, 34229, 34247);
                                CallChecker.isCalled(lmDiag, double[].class, 794, 34217, 34222)[j] = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 794, 34229, 34244)[j], double[].class, 794, 34229, 34247)[CallChecker.isCalled(permutation, int[].class, 794, 34249, 34259)[j]];
                                CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 794, 34217, 34222)[j], "CallChecker.isCalled(lmDiag, double[].class, 794, 34217, 34222)[j]", 794, 34217, 34264);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 795, 34278, 34293)) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 795, 34298, 34308)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 795, 34278, 34293);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 795, 34278, 34293)[j], double[].class, 795, 34278, 34296)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 795, 34316, 34320)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 795, 34278, 34293);
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 795, 34298, 34308);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 795, 34278, 34293)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 795, 34278, 34293)[j], double[].class, 795, 34278, 34296);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 795, 34316, 34320);
                                CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 795, 34278, 34293)[j], double[].class, 795, 34278, 34296)[CallChecker.isCalled(permutation, int[].class, 795, 34298, 34308)[j]] = CallChecker.isCalled(lmDir, double[].class, 795, 34316, 34320)[j];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 795, 34278, 34293)[j], double[].class, 795, 34278, 34296)[CallChecker.isCalled(this.permutation, int[].class, 795, 34298, 34308)[j]], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 795, 34278, 34293)[j], double[].class, 795, 34278, 34296)[CallChecker.isCalled(this.permutation, int[].class, 795, 34298, 34308)[j]]", 795, 34278, 34324);
                            }
                        }
                    }
                }
            }
            int nSing = CallChecker.varInit(((int) (this.solvedCols)), "nSing", 800, 34466, 34488);
            for (int j = 0; j < (solvedCols); ++j) {
                if (CallChecker.beforeDeref(lmDiag, double[].class, 802, 34554, 34559)) {
                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 802, 34554, 34559);
                    if (((CallChecker.isCalled(lmDiag, double[].class, 802, 34554, 34559)[j]) == 0) && (nSing == (solvedCols))) {
                        nSing = j;
                        CallChecker.varAssign(nSing, "nSing", 803, 34614, 34623);
                    }
                }
                if (nSing < (solvedCols)) {
                    if (CallChecker.beforeDeref(work, double[].class, 806, 34693, 34696)) {
                        work = CallChecker.beforeCalled(work, double[].class, 806, 34693, 34696);
                        CallChecker.isCalled(work, double[].class, 806, 34693, 34696)[j] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 806, 34693, 34696)[j], "CallChecker.isCalled(work, double[].class, 806, 34693, 34696)[j]", 806, 34693, 34704);
                    }
                }
            }
            if (nSing > 0) {
                for (int j = nSing - 1; j >= 0; --j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 811, 34831, 34841)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 811, 34831, 34841);
                        pj = CallChecker.isCalled(permutation, int[].class, 811, 34831, 34841)[j];
                        CallChecker.varAssign(pj, "pj", 811, 34831, 34841);
                    }
                    double sum = CallChecker.varInit(((double) (0)), "sum", 812, 34863, 34877);
                    for (int i = j + 1; i < nSing; ++i) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 814, 34960, 34975)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 814, 34960, 34975);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 814, 34960, 34975)[i], double[].class, 814, 34960, 34978)) {
                                if (CallChecker.beforeDeref(work, double[].class, 814, 34986, 34989)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 814, 34960, 34975);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 814, 34960, 34975)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 814, 34960, 34975)[i], double[].class, 814, 34960, 34978);
                                    work = CallChecker.beforeCalled(work, double[].class, 814, 34986, 34989);
                                    sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 814, 34960, 34975)[i], double[].class, 814, 34960, 34978)[pj]) * (CallChecker.isCalled(work, double[].class, 814, 34986, 34989)[i]);
                                    CallChecker.varAssign(sum, "sum", 814, 34953, 34993);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(work, double[].class, 816, 35029, 35032)) {
                        if (CallChecker.beforeDeref(work, double[].class, 816, 35040, 35043)) {
                            if (CallChecker.beforeDeref(lmDiag, double[].class, 816, 35057, 35062)) {
                                work = CallChecker.beforeCalled(work, double[].class, 816, 35029, 35032);
                                work = CallChecker.beforeCalled(work, double[].class, 816, 35040, 35043);
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 816, 35057, 35062);
                                CallChecker.isCalled(work, double[].class, 816, 35029, 35032)[j] = ((CallChecker.isCalled(work, double[].class, 816, 35040, 35043)[j]) - sum) / (CallChecker.isCalled(lmDiag, double[].class, 816, 35057, 35062)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 816, 35029, 35032)[j], "CallChecker.isCalled(work, double[].class, 816, 35029, 35032)[j]", 816, 35029, 35066);
                            }
                        }
                    }
                }
            }
            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 821, 35188, 35192);
            for (int j = 0; j < (CallChecker.isCalled(lmDir, double[].class, 821, 35188, 35192).length); ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 822, 35227, 35237)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 822, 35221, 35225)) {
                        if (CallChecker.beforeDeref(work, double[].class, 822, 35245, 35248)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 822, 35227, 35237);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 822, 35221, 35225);
                            work = CallChecker.beforeCalled(work, double[].class, 822, 35245, 35248);
                            CallChecker.isCalled(lmDir, double[].class, 822, 35221, 35225)[CallChecker.isCalled(permutation, int[].class, 822, 35227, 35237)[j]] = CallChecker.isCalled(work, double[].class, 822, 35245, 35248)[j];
                            CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 822, 35221, 35225)[CallChecker.isCalled(this.permutation, int[].class, 822, 35227, 35237)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 822, 35221, 35225)[CallChecker.isCalled(this.permutation, int[].class, 822, 35227, 35237)[j]]", 822, 35221, 35252);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2578.methodEnd();
        }
    }

    private void qrDecomposition(RealMatrix jacobian) throws ConvergenceException {
        MethodContext _bcornu_methode_context2579 = new MethodContext(void.class, 850, 35275, 39413);
        try {
            CallChecker.varInit(this, "this", 850, 35275, 39413);
            CallChecker.varInit(jacobian, "jacobian", 850, 35275, 39413);
            CallChecker.varInit(this.evaluations, "evaluations", 850, 35275, 39413);
            CallChecker.varInit(this.cost, "cost", 850, 35275, 39413);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 850, 35275, 39413);
            CallChecker.varInit(this.objective, "objective", 850, 35275, 39413);
            CallChecker.varInit(this.point, "point", 850, 35275, 39413);
            CallChecker.varInit(this.rows, "rows", 850, 35275, 39413);
            CallChecker.varInit(this.cols, "cols", 850, 35275, 39413);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 850, 35275, 39413);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 850, 35275, 39413);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 850, 35275, 39413);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 850, 35275, 39413);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 850, 35275, 39413);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 850, 35275, 39413);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 850, 35275, 39413);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 850, 35275, 39413);
            CallChecker.varInit(this.lmDir, "lmDir", 850, 35275, 39413);
            CallChecker.varInit(this.lmPar, "lmPar", 850, 35275, 39413);
            CallChecker.varInit(this.rank, "rank", 850, 35275, 39413);
            CallChecker.varInit(this.permutation, "permutation", 850, 35275, 39413);
            CallChecker.varInit(this.beta, "beta", 850, 35275, 39413);
            CallChecker.varInit(this.jacNorm, "jacNorm", 850, 35275, 39413);
            CallChecker.varInit(this.diagR, "diagR", 850, 35275, 39413);
            CallChecker.varInit(this.solvedCols, "solvedCols", 850, 35275, 39413);
            if (CallChecker.beforeDeref(jacobian, RealMatrix.class, 853, 36808, 36815)) {
                jacobian = CallChecker.beforeCalled(jacobian, RealMatrix.class, 853, 36808, 36815);
                final RealMatrix npe_invocation_var682 = CallChecker.isCalled(jacobian, RealMatrix.class, 853, 36808, 36815).scalarMultiply((-1));
                if (CallChecker.beforeDeref(npe_invocation_var682, RealMatrix.class, 853, 36808, 36834)) {
                    weightedJacobian = CallChecker.isCalled(npe_invocation_var682, RealMatrix.class, 853, 36808, 36834).getData();
                    CallChecker.varAssign(this.weightedJacobian, "this.weightedJacobian", 853, 36789, 36845);
                }
            }
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 855, 36871, 36886);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(this.weightedJacobian, double[][].class, 855, 36871, 36886).length)), "nR", 855, 36856, 36894);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 856, 36919, 36934);
            CallChecker.isCalled(weightedJacobian, double[][].class, 856, 36919, 36934)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 856, 36919, 36934)[0], double[].class, 856, 36919, 36937);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 856, 36919, 36934)[0], double[].class, 856, 36919, 36937).length)), "nC", 856, 36904, 36945);
            for (int k = 0; k < nC; ++k) {
                if (CallChecker.beforeDeref(permutation, int[].class, 860, 37026, 37036)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 860, 37026, 37036);
                    CallChecker.isCalled(permutation, int[].class, 860, 37026, 37036)[k] = k;
                    CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 860, 37026, 37036)[k], "CallChecker.isCalled(this.permutation, int[].class, 860, 37026, 37036)[k]", 860, 37026, 37044);
                }
                double norm2 = CallChecker.varInit(((double) (0)), "norm2", 861, 37058, 37074);
                for (int i = 0; i < nR; ++i) {
                    double akk = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 863, 37148, 37163)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 863, 37148, 37163);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 863, 37148, 37163)[i], double[].class, 863, 37148, 37166)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 863, 37148, 37163);
                            CallChecker.isCalled(weightedJacobian, double[][].class, 863, 37148, 37163)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 863, 37148, 37163)[i], double[].class, 863, 37148, 37166);
                            akk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 863, 37148, 37163)[i], double[].class, 863, 37148, 37166)[k];
                            CallChecker.varAssign(akk, "akk", 863, 37148, 37163);
                        }
                    }
                    norm2 += akk * akk;
                    CallChecker.varAssign(norm2, "norm2", 864, 37188, 37206);
                }
                if (CallChecker.beforeDeref(jacNorm, double[].class, 866, 37234, 37240)) {
                    jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 866, 37234, 37240);
                    CallChecker.isCalled(jacNorm, double[].class, 866, 37234, 37240)[k] = FastMath.sqrt(norm2);
                    CallChecker.varAssign(CallChecker.isCalled(this.jacNorm, double[].class, 866, 37234, 37240)[k], "CallChecker.isCalled(this.jacNorm, double[].class, 866, 37234, 37240)[k]", 866, 37234, 37267);
                }
            }
            for (int k = 0; k < nC; ++k) {
                int nextColumn = CallChecker.varInit(((int) (-1)), "nextColumn", 873, 37461, 37480);
                double ak2 = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "ak2", 874, 37494, 37531);
                for (int i = k; i < nC; ++i) {
                    double norm2 = CallChecker.varInit(((double) (0)), "norm2", 876, 37592, 37608);
                    for (int j = k; j < nR; ++j) {
                        double aki = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 878, 37690, 37705)) {
                            if (CallChecker.beforeDeref(permutation, int[].class, 878, 37710, 37720)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 878, 37690, 37705);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 878, 37690, 37705)[j], double[].class, 878, 37690, 37708)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 878, 37690, 37705);
                                    permutation = CallChecker.beforeCalled(permutation, int[].class, 878, 37710, 37720);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 878, 37690, 37705)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 878, 37690, 37705)[j], double[].class, 878, 37690, 37708);
                                    aki = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 878, 37690, 37705)[j], double[].class, 878, 37690, 37708)[CallChecker.isCalled(permutation, int[].class, 878, 37710, 37720)[i]];
                                    CallChecker.varAssign(aki, "aki", 878, 37690, 37705);
                                }
                            }
                        }
                        norm2 += aki * aki;
                        CallChecker.varAssign(norm2, "norm2", 879, 37747, 37765);
                    }
                    if ((Double.isInfinite(norm2)) || (Double.isNaN(norm2))) {
                        throw new ConvergenceException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, nR, nC);
                    }
                    if (norm2 > ak2) {
                        nextColumn = i;
                        CallChecker.varAssign(nextColumn, "nextColumn", 886, 38105, 38119);
                        ak2 = norm2;
                        CallChecker.varAssign(ak2, "ak2", 887, 38141, 38159);
                    }
                }
                if (ak2 <= (qrRankingThreshold)) {
                    rank = k;
                    CallChecker.varAssign(this.rank, "this.rank", 891, 38254, 38262);
                    return ;
                }
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 894, 38340, 38350)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 894, 38340, 38350);
                    pk = CallChecker.isCalled(permutation, int[].class, 894, 38340, 38350)[nextColumn];
                    CallChecker.varAssign(pk, "pk", 894, 38340, 38350);
                }
                if (CallChecker.beforeDeref(permutation, int[].class, 895, 38377, 38387)) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 895, 38403, 38413)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 895, 38377, 38387);
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 895, 38403, 38413);
                        CallChecker.isCalled(permutation, int[].class, 895, 38377, 38387)[nextColumn] = CallChecker.isCalled(permutation, int[].class, 895, 38403, 38413)[k];
                        CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 895, 38377, 38387)[nextColumn], "CallChecker.isCalled(this.permutation, int[].class, 895, 38377, 38387)[nextColumn]", 895, 38377, 38417);
                    }
                }
                if (CallChecker.beforeDeref(permutation, int[].class, 896, 38431, 38441)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 896, 38431, 38441);
                    CallChecker.isCalled(permutation, int[].class, 896, 38431, 38441)[k] = pk;
                    CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 896, 38431, 38441)[k], "CallChecker.isCalled(this.permutation, int[].class, 896, 38431, 38441)[k]", 896, 38431, 38459);
                }
                double akk = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 899, 38543, 38558)) {
                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 899, 38543, 38558);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 899, 38543, 38558)[k], double[].class, 899, 38543, 38561)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 899, 38543, 38558);
                        CallChecker.isCalled(weightedJacobian, double[][].class, 899, 38543, 38558)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 899, 38543, 38558)[k], double[].class, 899, 38543, 38561);
                        akk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 899, 38543, 38558)[k], double[].class, 899, 38543, 38561)[pk];
                        CallChecker.varAssign(akk, "akk", 899, 38543, 38558);
                    }
                }
                double alpha = CallChecker.init(double.class);
                if (akk > 0) {
                    alpha = -(FastMath.sqrt(ak2));
                    CallChecker.varAssign(alpha, "alpha", 900, 38595, 38646);
                }else {
                    alpha = FastMath.sqrt(ak2);
                    CallChecker.varAssign(alpha, "alpha", 900, 38595, 38646);
                }
                double betak = CallChecker.varInit(((double) (1.0 / (ak2 - (akk * alpha)))), "betak", 901, 38661, 38701);
                if (CallChecker.beforeDeref(beta, double[].class, 902, 38715, 38718)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 902, 38715, 38718);
                    CallChecker.isCalled(beta, double[].class, 902, 38715, 38718)[pk] = betak;
                    CallChecker.varAssign(CallChecker.isCalled(this.beta, double[].class, 902, 38715, 38718)[pk], "CallChecker.isCalled(this.beta, double[].class, 902, 38715, 38718)[pk]", 902, 38715, 38735);
                }
                if (CallChecker.beforeDeref(diagR, double[].class, 905, 38794, 38798)) {
                    diagR = CallChecker.beforeCalled(diagR, double[].class, 905, 38794, 38798);
                    CallChecker.isCalled(diagR, double[].class, 905, 38794, 38798)[pk] = alpha;
                    CallChecker.varAssign(CallChecker.isCalled(this.diagR, double[].class, 905, 38794, 38798)[pk], "CallChecker.isCalled(this.diagR, double[].class, 905, 38794, 38798)[pk]", 905, 38794, 38818);
                }
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 906, 38832, 38847)) {
                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 906, 38832, 38847);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 906, 38832, 38847)[k], double[].class, 906, 38832, 38850)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 906, 38832, 38847);
                        CallChecker.isCalled(weightedJacobian, double[][].class, 906, 38832, 38847)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 906, 38832, 38847)[k], double[].class, 906, 38832, 38850);
                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 906, 38832, 38847)[k], double[].class, 906, 38832, 38850)[pk] -= alpha;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 906, 38832, 38847)[k], double[].class, 906, 38832, 38850)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 906, 38832, 38847)[k], double[].class, 906, 38832, 38850)[pk]", 906, 38832, 38864);
                    }
                }
                for (int dk = (nC - 1) - k; dk > 0; --dk) {
                    double gamma = CallChecker.varInit(((double) (0)), "gamma", 910, 38984, 39000);
                    for (int j = k; j < nR; ++j) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 912, 39078, 39093)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 912, 39078, 39093);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39078, 39093)[j], double[].class, 912, 39078, 39096)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 912, 39104, 39119)) {
                                    if (CallChecker.beforeDeref(permutation, int[].class, 912, 39124, 39134)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 912, 39104, 39119);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39104, 39119)[j], double[].class, 912, 39104, 39122)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 912, 39078, 39093);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39078, 39093)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39078, 39093)[j], double[].class, 912, 39078, 39096);
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 912, 39104, 39119);
                                            permutation = CallChecker.beforeCalled(permutation, int[].class, 912, 39124, 39134);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39104, 39119)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39104, 39119)[j], double[].class, 912, 39104, 39122);
                                            gamma += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39078, 39093)[j], double[].class, 912, 39078, 39096)[pk]) * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 912, 39104, 39119)[j], double[].class, 912, 39104, 39122)[CallChecker.isCalled(permutation, int[].class, 912, 39124, 39134)[(k + dk)]]);
                                            CallChecker.varAssign(gamma, "gamma", 912, 39069, 39144);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    gamma *= betak;
                    CallChecker.varAssign(gamma, "gamma", 914, 39180, 39194);
                    for (int j = k; j < nR; ++j) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 916, 39263, 39278)) {
                            if (CallChecker.beforeDeref(permutation, int[].class, 916, 39283, 39293)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 916, 39263, 39278);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39263, 39278)[j], double[].class, 916, 39263, 39281)) {
                                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 916, 39315, 39330)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 916, 39315, 39330);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39315, 39330)[j], double[].class, 916, 39315, 39333)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 916, 39263, 39278);
                                            permutation = CallChecker.beforeCalled(permutation, int[].class, 916, 39283, 39293);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39263, 39278)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39263, 39278)[j], double[].class, 916, 39263, 39281);
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 916, 39315, 39330);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39315, 39330)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39315, 39330)[j], double[].class, 916, 39315, 39333);
                                            CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39263, 39278)[j], double[].class, 916, 39263, 39281)[CallChecker.isCalled(permutation, int[].class, 916, 39283, 39293)[(k + dk)]] -= gamma * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 916, 39315, 39330)[j], double[].class, 916, 39315, 39333)[pk]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 916, 39263, 39278)[j], double[].class, 916, 39263, 39281)[CallChecker.isCalled(this.permutation, int[].class, 916, 39283, 39293)[(k + dk)]], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 916, 39263, 39278)[j], double[].class, 916, 39263, 39281)[CallChecker.isCalled(this.permutation, int[].class, 916, 39283, 39293)[(k + dk)]]", 916, 39263, 39338);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            rank = solvedCols;
            CallChecker.varAssign(this.rank, "this.rank", 920, 39390, 39407);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2579.methodEnd();
        }
    }

    private void qTy(double[] y) {
        MethodContext _bcornu_methode_context2580 = new MethodContext(void.class, 928, 39420, 40087);
        try {
            CallChecker.varInit(this, "this", 928, 39420, 40087);
            CallChecker.varInit(y, "y", 928, 39420, 40087);
            CallChecker.varInit(this.evaluations, "evaluations", 928, 39420, 40087);
            CallChecker.varInit(this.cost, "cost", 928, 39420, 40087);
            CallChecker.varInit(this.weightedResiduals, "weightedResiduals", 928, 39420, 40087);
            CallChecker.varInit(this.objective, "objective", 928, 39420, 40087);
            CallChecker.varInit(this.point, "point", 928, 39420, 40087);
            CallChecker.varInit(this.rows, "rows", 928, 39420, 40087);
            CallChecker.varInit(this.cols, "cols", 928, 39420, 40087);
            CallChecker.varInit(this.weightedResidualJacobian, "weightedResidualJacobian", 928, 39420, 40087);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 928, 39420, 40087);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 928, 39420, 40087);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 928, 39420, 40087);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 928, 39420, 40087);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 928, 39420, 40087);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 928, 39420, 40087);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 928, 39420, 40087);
            CallChecker.varInit(this.lmDir, "lmDir", 928, 39420, 40087);
            CallChecker.varInit(this.lmPar, "lmPar", 928, 39420, 40087);
            CallChecker.varInit(this.rank, "rank", 928, 39420, 40087);
            CallChecker.varInit(this.permutation, "permutation", 928, 39420, 40087);
            CallChecker.varInit(this.beta, "beta", 928, 39420, 40087);
            CallChecker.varInit(this.jacNorm, "jacNorm", 928, 39420, 40087);
            CallChecker.varInit(this.diagR, "diagR", 928, 39420, 40087);
            CallChecker.varInit(this.solvedCols, "solvedCols", 928, 39420, 40087);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 929, 39631, 39646);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(this.weightedJacobian, double[][].class, 929, 39631, 39646).length)), "nR", 929, 39616, 39654);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 930, 39679, 39694);
            CallChecker.isCalled(weightedJacobian, double[][].class, 930, 39679, 39694)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 930, 39679, 39694)[0], double[].class, 930, 39679, 39697);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 930, 39679, 39694)[0], double[].class, 930, 39679, 39697).length)), "nC", 930, 39664, 39705);
            for (int k = 0; k < nC; ++k) {
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 933, 39768, 39778)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 933, 39768, 39778);
                    pk = CallChecker.isCalled(permutation, int[].class, 933, 39768, 39778)[k];
                    CallChecker.varAssign(pk, "pk", 933, 39768, 39778);
                }
                double gamma = CallChecker.varInit(((double) (0)), "gamma", 934, 39796, 39812);
                for (int i = k; i < nR; ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 936, 39882, 39897)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 936, 39882, 39897);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 936, 39882, 39897)[i], double[].class, 936, 39882, 39900)) {
                            if (CallChecker.beforeDeref(y, double[].class, 936, 39908, 39908)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 936, 39882, 39897);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 936, 39882, 39897)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 936, 39882, 39897)[i], double[].class, 936, 39882, 39900);
                                y = CallChecker.beforeCalled(y, double[].class, 936, 39908, 39908);
                                gamma += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 936, 39882, 39897)[i], double[].class, 936, 39882, 39900)[pk]) * (CallChecker.isCalled(y, double[].class, 936, 39908, 39908)[i]);
                                CallChecker.varAssign(gamma, "gamma", 936, 39873, 39912);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(beta, double[].class, 938, 39949, 39952)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 938, 39949, 39952);
                    gamma *= CallChecker.isCalled(beta, double[].class, 938, 39949, 39952)[pk];
                    CallChecker.varAssign(gamma, "gamma", 938, 39940, 39957);
                }
                for (int i = k; i < nR; ++i) {
                    if (CallChecker.beforeDeref(y, double[].class, 940, 40018, 40018)) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 940, 40034, 40049)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 940, 40034, 40049);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 940, 40034, 40049)[i], double[].class, 940, 40034, 40052)) {
                                y = CallChecker.beforeCalled(y, double[].class, 940, 40018, 40018);
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 940, 40034, 40049);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 940, 40034, 40049)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 940, 40034, 40049)[i], double[].class, 940, 40034, 40052);
                                CallChecker.isCalled(y, double[].class, 940, 40018, 40018)[i] -= gamma * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 940, 40034, 40049)[i], double[].class, 940, 40034, 40052)[pk]);
                                CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 940, 40018, 40018)[i], "CallChecker.isCalled(y, double[].class, 940, 40018, 40018)[i]", 940, 40018, 40057);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2580.methodEnd();
        }
    }
}

