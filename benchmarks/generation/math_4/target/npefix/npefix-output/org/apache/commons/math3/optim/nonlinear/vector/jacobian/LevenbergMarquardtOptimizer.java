package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private static final double TWO_EPS = 2 * (Precision.EPSILON);

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
        ConstructorContext _bcornu_methode_context554 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 163, 7178, 7868);
        try {
        } finally {
            _bcornu_methode_context554.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        this(100, checker, 1.0E-10, 1.0E-10, 1.0E-10, Precision.SAFE_MIN);
        ConstructorContext _bcornu_methode_context555 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 182, 7875, 8614);
        try {
        } finally {
            _bcornu_methode_context555.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double initialStepBoundFactor, ConvergenceChecker<PointVectorValuePair> checker, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) {
        super(checker);
        ConstructorContext _bcornu_methode_context556 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 208, 8621, 10537);
        try {
            this.initialStepBoundFactor = initialStepBoundFactor;
            CallChecker.varAssign(this.initialStepBoundFactor, "this.initialStepBoundFactor", 215, 10270, 10322);
            this.costRelativeTolerance = costRelativeTolerance;
            CallChecker.varAssign(this.costRelativeTolerance, "this.costRelativeTolerance", 216, 10332, 10382);
            this.parRelativeTolerance = parRelativeTolerance;
            CallChecker.varAssign(this.parRelativeTolerance, "this.parRelativeTolerance", 217, 10392, 10440);
            this.orthoTolerance = orthoTolerance;
            CallChecker.varAssign(this.orthoTolerance, "this.orthoTolerance", 218, 10450, 10486);
            this.qrRankingThreshold = threshold;
            CallChecker.varAssign(this.qrRankingThreshold, "this.qrRankingThreshold", 219, 10496, 10531);
        } finally {
            _bcornu_methode_context556.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance) {
        this(100, costRelativeTolerance, parRelativeTolerance, orthoTolerance, Precision.SAFE_MIN);
        ConstructorContext _bcornu_methode_context557 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 240, 10544, 11652);
        try {
        } finally {
            _bcornu_methode_context557.methodEnd();
        }
    }

    public LevenbergMarquardtOptimizer(double initialStepBoundFactor, double costRelativeTolerance, double parRelativeTolerance, double orthoTolerance, double threshold) {
        super(null);
        ConstructorContext _bcornu_methode_context558 = new ConstructorContext(LevenbergMarquardtOptimizer.class, 271, 11659, 13549);
        try {
            this.initialStepBoundFactor = initialStepBoundFactor;
            CallChecker.varAssign(this.initialStepBoundFactor, "this.initialStepBoundFactor", 277, 13282, 13334);
            this.costRelativeTolerance = costRelativeTolerance;
            CallChecker.varAssign(this.costRelativeTolerance, "this.costRelativeTolerance", 278, 13344, 13394);
            this.parRelativeTolerance = parRelativeTolerance;
            CallChecker.varAssign(this.parRelativeTolerance, "this.parRelativeTolerance", 279, 13404, 13452);
            this.orthoTolerance = orthoTolerance;
            CallChecker.varAssign(this.orthoTolerance, "this.orthoTolerance", 280, 13462, 13498);
            this.qrRankingThreshold = threshold;
            CallChecker.varAssign(this.qrRankingThreshold, "this.qrRankingThreshold", 281, 13508, 13543);
        } finally {
            _bcornu_methode_context558.methodEnd();
        }
    }

    @Override
    protected PointVectorValuePair doOptimize() {
        MethodContext _bcornu_methode_context2581 = new MethodContext(PointVectorValuePair.class, 286, 13556, 24071);
        try {
            CallChecker.varInit(this, "this", 286, 13556, 24071);
            CallChecker.varInit(this.iterations, "iterations", 286, 13556, 24071);
            CallChecker.varInit(this.evaluations, "evaluations", 286, 13556, 24071);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 286, 13556, 24071);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 286, 13556, 24071);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 286, 13556, 24071);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 286, 13556, 24071);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 286, 13556, 24071);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 286, 13556, 24071);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 286, 13556, 24071);
            CallChecker.varInit(this.lmDir, "lmDir", 286, 13556, 24071);
            CallChecker.varInit(this.lmPar, "lmPar", 286, 13556, 24071);
            CallChecker.varInit(this.rank, "rank", 286, 13556, 24071);
            CallChecker.varInit(this.permutation, "permutation", 286, 13556, 24071);
            CallChecker.varInit(this.beta, "beta", 286, 13556, 24071);
            CallChecker.varInit(this.jacNorm, "jacNorm", 286, 13556, 24071);
            CallChecker.varInit(this.diagR, "diagR", 286, 13556, 24071);
            CallChecker.varInit(this.solvedCols, "solvedCols", 286, 13556, 24071);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 286, 13556, 24071);
            checkParameters();
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(getTarget(), double[].class, 289, 13692, 13702).length)), "nR", 289, 13677, 13710);
            final double[] currentPoint = CallChecker.varInit(getStartPoint(), "currentPoint", 290, 13748, 13793);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(currentPoint, double[].class, 291, 13818, 13829).length)), "nC", 291, 13803, 13837);
            solvedCols = FastMath.min(nR, nC);
            CallChecker.varAssign(this.solvedCols, "this.solvedCols", 294, 13929, 13963);
            diagR = new double[nC];
            CallChecker.varAssign(this.diagR, "this.diagR", 295, 13973, 14001);
            jacNorm = new double[nC];
            CallChecker.varAssign(this.jacNorm, "this.jacNorm", 296, 14011, 14039);
            beta = new double[nC];
            CallChecker.varAssign(this.beta, "this.beta", 297, 14049, 14077);
            permutation = new int[nC];
            CallChecker.varAssign(this.permutation, "this.permutation", 298, 14087, 14112);
            lmDir = new double[nC];
            CallChecker.varAssign(this.lmDir, "this.lmDir", 299, 14122, 14150);
            double delta = CallChecker.varInit(((double) (0)), "delta", 302, 14184, 14204);
            double xNorm = CallChecker.varInit(((double) (0)), "xNorm", 303, 14214, 14234);
            double[] diag = CallChecker.varInit(new double[nC], "diag", 304, 14244, 14277);
            double[] oldX = CallChecker.varInit(new double[nC], "oldX", 305, 14287, 14320);
            double[] oldRes = CallChecker.varInit(new double[nR], "oldRes", 306, 14330, 14363);
            double[] oldObj = CallChecker.varInit(new double[nR], "oldObj", 307, 14373, 14406);
            double[] qtf = CallChecker.varInit(new double[nR], "qtf", 308, 14416, 14449);
            double[] work1 = CallChecker.varInit(new double[nC], "work1", 309, 14459, 14492);
            double[] work2 = CallChecker.varInit(new double[nC], "work2", 310, 14502, 14535);
            double[] work3 = CallChecker.varInit(new double[nC], "work3", 311, 14545, 14578);
            final RealMatrix weightMatrixSqrt = CallChecker.varInit(getWeightSquareRoot(), "weightMatrixSqrt", 313, 14589, 14646);
            double[] currentObjective = CallChecker.varInit(computeObjectiveValue(currentPoint), "currentObjective", 316, 14736, 14799);
            double[] currentResiduals = CallChecker.varInit(computeResiduals(currentObjective), "currentResiduals", 317, 14809, 14871);
            PointVectorValuePair current = CallChecker.varInit(new PointVectorValuePair(currentPoint, currentObjective), "current", 318, 14881, 14968);
            double currentCost = CallChecker.varInit(((double) (computeCost(currentResiduals))), "currentCost", 319, 14978, 15028);
            lmPar = 0;
            CallChecker.varAssign(this.lmPar, "this.lmPar", 322, 15062, 15071);
            boolean firstIteration = CallChecker.varInit(((boolean) (true)), "firstIteration", 323, 15081, 15110);
            final ConvergenceChecker<PointVectorValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 324, 15120, 15200);
            while (true) {
                incrementIterationCount();
                final PointVectorValuePair previous = CallChecker.varInit(current, "previous", 328, 15277, 15322);
                qrDecomposition(computeWeightedJacobian(currentPoint));
                if (CallChecker.beforeDeref(weightMatrixSqrt, RealMatrix.class, 333, 15480, 15495)) {
                    weightedResidual = CallChecker.isCalled(weightMatrixSqrt, RealMatrix.class, 333, 15480, 15495).operate(currentResiduals);
                    CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 333, 15461, 15522);
                }
                for (int i = 0; i < nR; i++) {
                    if (CallChecker.beforeDeref(qtf, double[].class, 335, 15583, 15585)) {
                        if (CallChecker.beforeDeref(weightedResidual, double[].class, 335, 15592, 15607)) {
                            qtf = CallChecker.beforeCalled(qtf, double[].class, 335, 15583, 15585);
                            weightedResidual = CallChecker.beforeCalled(weightedResidual, double[].class, 335, 15592, 15607);
                            CallChecker.isCalled(qtf, double[].class, 335, 15583, 15585)[i] = CallChecker.isCalled(weightedResidual, double[].class, 335, 15592, 15607)[i];
                            CallChecker.varAssign(CallChecker.isCalled(qtf, double[].class, 335, 15583, 15585)[i], "CallChecker.isCalled(qtf, double[].class, 335, 15583, 15585)[i]", 335, 15583, 15611);
                        }
                    }
                }
                qTy(qtf);
                for (int k = 0; k < (solvedCols); ++k) {
                    int pk = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 344, 15880, 15890)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 344, 15880, 15890);
                        pk = CallChecker.isCalled(permutation, int[].class, 344, 15880, 15890)[k];
                        CallChecker.varAssign(pk, "pk", 344, 15880, 15890);
                    }
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 345, 15912, 15927)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 345, 15912, 15927);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 345, 15912, 15927)[k], double[].class, 345, 15912, 15930)) {
                            if (CallChecker.beforeDeref(diagR, double[].class, 345, 15938, 15942)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 345, 15912, 15927);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 345, 15912, 15927)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 345, 15912, 15927)[k], double[].class, 345, 15912, 15930);
                                diagR = CallChecker.beforeCalled(diagR, double[].class, 345, 15938, 15942);
                                CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 345, 15912, 15927)[k], double[].class, 345, 15912, 15930)[pk] = CallChecker.isCalled(diagR, double[].class, 345, 15938, 15942)[pk];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 345, 15912, 15927)[k], double[].class, 345, 15912, 15930)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 345, 15912, 15927)[k], double[].class, 345, 15912, 15930)[pk]", 345, 15912, 15947);
                            }
                        }
                    }
                }
                if (firstIteration) {
                    xNorm = 0;
                    CallChecker.varAssign(xNorm, "xNorm", 351, 16130, 16139);
                    for (int k = 0; k < nC; ++k) {
                        double dk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(jacNorm, double[].class, 353, 16220, 16226)) {
                            jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 353, 16220, 16226);
                            dk = CallChecker.isCalled(jacNorm, double[].class, 353, 16220, 16226)[k];
                            CallChecker.varAssign(dk, "dk", 353, 16220, 16226);
                        }
                        if (dk == 0) {
                            dk = 1.0;
                            CallChecker.varAssign(dk, "dk", 355, 16291, 16299);
                        }
                        double xk = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 357, 16360, 16371)) {
                            xk = dk * (CallChecker.isCalled(currentPoint, double[].class, 357, 16360, 16371)[k]);
                            CallChecker.varAssign(xk, "xk", 357, 16360, 16371);
                        }
                        xNorm += xk * xk;
                        CallChecker.varAssign(xNorm, "xNorm", 358, 16397, 16414);
                        if (CallChecker.beforeDeref(diag, double[].class, 359, 16436, 16439)) {
                            diag = CallChecker.beforeCalled(diag, double[].class, 359, 16436, 16439);
                            CallChecker.isCalled(diag, double[].class, 359, 16436, 16439)[k] = dk;
                            CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 359, 16436, 16439)[k], "CallChecker.isCalled(diag, double[].class, 359, 16436, 16439)[k]", 359, 16436, 16448);
                        }
                    }
                    xNorm = FastMath.sqrt(xNorm);
                    CallChecker.varAssign(xNorm, "xNorm", 361, 16484, 16512);
                    if (xNorm == 0) {
                        delta = initialStepBoundFactor;
                        CallChecker.varAssign(delta, "delta", 364, 16582, 16662);
                    }else {
                        delta = (initialStepBoundFactor) * xNorm;
                        CallChecker.varAssign(delta, "delta", 364, 16582, 16662);
                    }
                }
                double maxCosine = CallChecker.varInit(((double) (0)), "maxCosine", 368, 16771, 16791);
                if (currentCost != 0) {
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 371, 16916, 16926)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 371, 16916, 16926);
                            pj = CallChecker.isCalled(permutation, int[].class, 371, 16916, 16926)[j];
                            CallChecker.varAssign(pj, "pj", 371, 16916, 16926);
                        }
                        double s = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(jacNorm, double[].class, 372, 16964, 16970)) {
                            jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 372, 16964, 16970);
                            s = CallChecker.isCalled(jacNorm, double[].class, 372, 16964, 16970)[pj];
                            CallChecker.varAssign(s, "s", 372, 16964, 16970);
                        }
                        if (s != 0) {
                            double sum = CallChecker.varInit(((double) (0)), "sum", 374, 17035, 17049);
                            for (int i = 0; i <= j; ++i) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 376, 17141, 17156)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 376, 17141, 17156);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 376, 17141, 17156)[i], double[].class, 376, 17141, 17159)) {
                                        if (CallChecker.beforeDeref(qtf, double[].class, 376, 17167, 17169)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 376, 17141, 17156);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 376, 17141, 17156)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 376, 17141, 17156)[i], double[].class, 376, 17141, 17159);
                                            qtf = CallChecker.beforeCalled(qtf, double[].class, 376, 17167, 17169);
                                            sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 376, 17141, 17156)[i], double[].class, 376, 17141, 17159)[pj]) * (CallChecker.isCalled(qtf, double[].class, 376, 17167, 17169)[i]);
                                            CallChecker.varAssign(sum, "sum", 376, 17134, 17173);
                                        }
                                    }
                                }
                            }
                            maxCosine = FastMath.max(maxCosine, ((FastMath.abs(sum)) / (s * currentCost)));
                            CallChecker.varAssign(maxCosine, "maxCosine", 378, 17225, 17299);
                        }
                    }
                }
                if (maxCosine <= (orthoTolerance)) {
                    setCost(currentCost);
                    return current;
                }
                for (int j = 0; j < nC; ++j) {
                    if (CallChecker.beforeDeref(diag, double[].class, 390, 17631, 17634)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 390, 17654, 17657)) {
                            if (CallChecker.beforeDeref(jacNorm, double[].class, 390, 17663, 17669)) {
                                diag = CallChecker.beforeCalled(diag, double[].class, 390, 17631, 17634);
                                diag = CallChecker.beforeCalled(diag, double[].class, 390, 17654, 17657);
                                jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 390, 17663, 17669);
                                CallChecker.isCalled(diag, double[].class, 390, 17631, 17634)[j] = FastMath.max(CallChecker.isCalled(diag, double[].class, 390, 17654, 17657)[j], CallChecker.isCalled(jacNorm, double[].class, 390, 17663, 17669)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(diag, double[].class, 390, 17631, 17634)[j], "CallChecker.isCalled(diag, double[].class, 390, 17631, 17634)[j]", 390, 17631, 17674);
                            }
                        }
                    }
                }
                for (double ratio = 0; ratio < 1.0E-4;) {
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 398, 17891, 17901)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 398, 17891, 17901);
                            pj = CallChecker.isCalled(permutation, int[].class, 398, 17891, 17901)[j];
                            CallChecker.varAssign(pj, "pj", 398, 17891, 17901);
                        }
                        if (CallChecker.beforeDeref(oldX, double[].class, 399, 17927, 17930)) {
                            if (CallChecker.beforeDeref(currentPoint, double[].class, 399, 17938, 17949)) {
                                oldX = CallChecker.beforeCalled(oldX, double[].class, 399, 17927, 17930);
                                CallChecker.isCalled(oldX, double[].class, 399, 17927, 17930)[pj] = CallChecker.isCalled(currentPoint, double[].class, 399, 17938, 17949)[pj];
                                CallChecker.varAssign(CallChecker.isCalled(oldX, double[].class, 399, 17927, 17930)[pj], "CallChecker.isCalled(oldX, double[].class, 399, 17927, 17930)[pj]", 399, 17927, 17954);
                            }
                        }
                    }
                    final double previousCost = CallChecker.varInit(((double) (currentCost)), "previousCost", 401, 17990, 18029);
                    double[] tmpVec = CallChecker.varInit(weightedResidual, "tmpVec", 402, 18047, 18081);
                    weightedResidual = oldRes;
                    CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 403, 18099, 18124);
                    oldRes = tmpVec;
                    CallChecker.varAssign(oldRes, "oldRes", 404, 18142, 18160);
                    tmpVec = currentObjective;
                    CallChecker.varAssign(tmpVec, "tmpVec", 405, 18178, 18206);
                    currentObjective = oldObj;
                    CallChecker.varAssign(currentObjective, "currentObjective", 406, 18224, 18249);
                    oldObj = tmpVec;
                    CallChecker.varAssign(oldObj, "oldObj", 407, 18267, 18285);
                    determineLMParameter(qtf, delta, diag, work1, work2, work3);
                    double lmNorm = CallChecker.varInit(((double) (0)), "lmNorm", 413, 18526, 18543);
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 415, 18629, 18639)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 415, 18629, 18639);
                            pj = CallChecker.isCalled(permutation, int[].class, 415, 18629, 18639)[j];
                            CallChecker.varAssign(pj, "pj", 415, 18629, 18639);
                        }
                        if (CallChecker.beforeDeref(lmDir, double[].class, 416, 18665, 18669)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 416, 18678, 18682)) {
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 416, 18665, 18669);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 416, 18678, 18682);
                                CallChecker.isCalled(lmDir, double[].class, 416, 18665, 18669)[pj] = -(CallChecker.isCalled(lmDir, double[].class, 416, 18678, 18682)[pj]);
                                CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 416, 18665, 18669)[pj], "CallChecker.isCalled(this.lmDir, double[].class, 416, 18665, 18669)[pj]", 416, 18665, 18687);
                            }
                        }
                        if (CallChecker.beforeDeref(currentPoint, double[].class, 417, 18709, 18720)) {
                            if (CallChecker.beforeDeref(oldX, double[].class, 417, 18728, 18731)) {
                                if (CallChecker.beforeDeref(lmDir, double[].class, 417, 18739, 18743)) {
                                    oldX = CallChecker.beforeCalled(oldX, double[].class, 417, 18728, 18731);
                                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 417, 18739, 18743);
                                    CallChecker.isCalled(currentPoint, double[].class, 417, 18709, 18720)[pj] = (CallChecker.isCalled(oldX, double[].class, 417, 18728, 18731)[pj]) + (CallChecker.isCalled(lmDir, double[].class, 417, 18739, 18743)[pj]);
                                    CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 417, 18709, 18720)[pj], "CallChecker.isCalled(currentPoint, double[].class, 417, 18709, 18720)[pj]", 417, 18709, 18748);
                                }
                            }
                        }
                        double s = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(diag, double[].class, 418, 18781, 18784)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 418, 18792, 18796)) {
                                diag = CallChecker.beforeCalled(diag, double[].class, 418, 18781, 18784);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 418, 18792, 18796);
                                s = (CallChecker.isCalled(diag, double[].class, 418, 18781, 18784)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 418, 18792, 18796)[pj]);
                                CallChecker.varAssign(s, "s", 418, 18781, 18784);
                            }
                        }
                        lmNorm += s * s;
                        CallChecker.varAssign(lmNorm, "lmNorm", 419, 18823, 18839);
                    }
                    lmNorm = FastMath.sqrt(lmNorm);
                    CallChecker.varAssign(lmNorm, "lmNorm", 421, 18875, 18905);
                    if (firstIteration) {
                        delta = FastMath.min(delta, lmNorm);
                        CallChecker.varAssign(delta, "delta", 424, 19039, 19074);
                    }
                    currentObjective = computeObjectiveValue(currentPoint);
                    CallChecker.varAssign(currentObjective, "currentObjective", 428, 19185, 19239);
                    currentResiduals = computeResiduals(currentObjective);
                    CallChecker.varAssign(currentResiduals, "currentResiduals", 429, 19257, 19310);
                    current = new PointVectorValuePair(currentPoint, currentObjective);
                    CallChecker.varAssign(current, "current", 430, 19328, 19394);
                    currentCost = computeCost(currentResiduals);
                    CallChecker.varAssign(currentCost, "currentCost", 431, 19412, 19455);
                    double actRed = CallChecker.varInit(((double) (-1.0)), "actRed", 434, 19529, 19549);
                    if ((0.1 * currentCost) < previousCost) {
                        double r = CallChecker.varInit(((double) (currentCost / previousCost)), "r", 436, 19627, 19664);
                        actRed = 1.0 - (r * r);
                        CallChecker.varAssign(actRed, "actRed", 437, 19686, 19706);
                    }
                    for (int j = 0; j < (solvedCols); ++j) {
                        int pj = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(permutation, int[].class, 443, 19926, 19936)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 443, 19926, 19936);
                            pj = CallChecker.isCalled(permutation, int[].class, 443, 19926, 19936)[j];
                            CallChecker.varAssign(pj, "pj", 443, 19926, 19936);
                        }
                        double dirJ = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(lmDir, double[].class, 444, 19976, 19980)) {
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 444, 19976, 19980);
                            dirJ = CallChecker.isCalled(lmDir, double[].class, 444, 19976, 19980)[pj];
                            CallChecker.varAssign(dirJ, "dirJ", 444, 19976, 19980);
                        }
                        if (CallChecker.beforeDeref(work1, double[].class, 445, 20007, 20011)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 445, 20007, 20011);
                            CallChecker.isCalled(work1, double[].class, 445, 20007, 20011)[j] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 445, 20007, 20011)[j], "CallChecker.isCalled(work1, double[].class, 445, 20007, 20011)[j]", 445, 20007, 20019);
                        }
                        for (int i = 0; i <= j; ++i) {
                            if (CallChecker.beforeDeref(work1, double[].class, 447, 20096, 20100)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 447, 20108, 20123)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 447, 20108, 20123);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 447, 20108, 20123)[i], double[].class, 447, 20108, 20126)) {
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 447, 20096, 20100);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 447, 20108, 20123);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 447, 20108, 20123)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 447, 20108, 20123)[i], double[].class, 447, 20108, 20126);
                                        CallChecker.isCalled(work1, double[].class, 447, 20096, 20100)[i] += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 447, 20108, 20123)[i], double[].class, 447, 20108, 20126)[pj]) * dirJ;
                                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 447, 20096, 20100)[i], "CallChecker.isCalled(work1, double[].class, 447, 20096, 20100)[i]", 447, 20096, 20138);
                                    }
                                }
                            }
                        }
                    }
                    double coeff1 = CallChecker.varInit(((double) (0)), "coeff1", 450, 20196, 20213);
                    for (int j = 0; j < (solvedCols); ++j) {
                        if (CallChecker.beforeDeref(work1, double[].class, 452, 20300, 20304)) {
                            if (CallChecker.beforeDeref(work1, double[].class, 452, 20311, 20315)) {
                                work1 = CallChecker.beforeCalled(work1, double[].class, 452, 20300, 20304);
                                work1 = CallChecker.beforeCalled(work1, double[].class, 452, 20311, 20315);
                                coeff1 += (CallChecker.isCalled(work1, double[].class, 452, 20300, 20304)[j]) * (CallChecker.isCalled(work1, double[].class, 452, 20311, 20315)[j]);
                                CallChecker.varAssign(coeff1, "coeff1", 452, 20290, 20319);
                            }
                        }
                    }
                    double pc2 = CallChecker.varInit(((double) (previousCost * previousCost)), "pc2", 454, 20355, 20395);
                    coeff1 = coeff1 / pc2;
                    CallChecker.varAssign(coeff1, "coeff1", 455, 20413, 20434);
                    double coeff2 = CallChecker.varInit(((double) ((((this.lmPar) * lmNorm) * lmNorm) / pc2)), "coeff2", 456, 20452, 20497);
                    double preRed = CallChecker.varInit(((double) (coeff1 + (2 * coeff2))), "preRed", 457, 20515, 20550);
                    double dirDer = CallChecker.varInit(((double) (-(coeff1 + coeff2))), "dirDer", 458, 20568, 20602);
                    if (preRed == 0) {
                        ratio = 0;
                        CallChecker.varAssign(ratio, "ratio", 461, 20687, 20732);
                    }else {
                        ratio = actRed / preRed;
                        CallChecker.varAssign(ratio, "ratio", 461, 20687, 20732);
                    }
                    if (ratio <= 0.25) {
                        double tmp = CallChecker.init(double.class);
                        if (actRed < 0) {
                            tmp = (0.5 * dirDer) / (dirDer + (0.5 * actRed));
                            CallChecker.varAssign(tmp, "tmp", 466, 20870, 20930);
                        }else {
                            tmp = 0.5;
                            CallChecker.varAssign(tmp, "tmp", 466, 20870, 20930);
                        }
                        if (((0.1 * currentCost) >= previousCost) || (tmp < 0.1)) {
                            tmp = 0.1;
                            CallChecker.varAssign(tmp, "tmp", 468, 21043, 21052);
                        }
                        delta = tmp * (FastMath.min(delta, (10.0 * lmNorm)));
                        CallChecker.varAssign(delta, "delta", 470, 21104, 21152);
                        lmPar /= tmp;
                        CallChecker.varAssign(this.lmPar, "this.lmPar", 471, 21178, 21190);
                    }else
                        if (((lmPar) == 0) || (ratio >= 0.75)) {
                            delta = 2 * lmNorm;
                            CallChecker.varAssign(delta, "delta", 473, 21274, 21292);
                            lmPar *= 0.5;
                            CallChecker.varAssign(this.lmPar, "this.lmPar", 474, 21314, 21326);
                        }
                    
                    if (ratio >= 1.0E-4) {
                        firstIteration = false;
                        CallChecker.varAssign(firstIteration, "firstIteration", 480, 21517, 21539);
                        xNorm = 0;
                        CallChecker.varAssign(xNorm, "xNorm", 481, 21561, 21570);
                        for (int k = 0; k < nC; ++k) {
                            double xK = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(diag, double[].class, 483, 21659, 21662)) {
                                if (CallChecker.beforeDeref(currentPoint, double[].class, 483, 21669, 21680)) {
                                    diag = CallChecker.beforeCalled(diag, double[].class, 483, 21659, 21662);
                                    xK = (CallChecker.isCalled(diag, double[].class, 483, 21659, 21662)[k]) * (CallChecker.isCalled(currentPoint, double[].class, 483, 21669, 21680)[k]);
                                    CallChecker.varAssign(xK, "xK", 483, 21659, 21662);
                                }
                            }
                            xNorm += xK * xK;
                            CallChecker.varAssign(xNorm, "xNorm", 484, 21710, 21726);
                        }
                        xNorm = FastMath.sqrt(xNorm);
                        CallChecker.varAssign(xNorm, "xNorm", 486, 21770, 21798);
                        if ((checker != null) && (checker.converged(getIterations(), previous, current))) {
                            setCost(currentCost);
                            return current;
                        }
                    }else {
                        currentCost = previousCost;
                        CallChecker.varAssign(currentCost, "currentCost", 495, 22167, 22193);
                        for (int j = 0; j < (solvedCols); ++j) {
                            int pj = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(permutation, int[].class, 497, 22287, 22297)) {
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 497, 22287, 22297);
                                pj = CallChecker.isCalled(permutation, int[].class, 497, 22287, 22297)[j];
                                CallChecker.varAssign(pj, "pj", 497, 22287, 22297);
                            }
                            if (CallChecker.beforeDeref(currentPoint, double[].class, 498, 22327, 22338)) {
                                if (CallChecker.beforeDeref(oldX, double[].class, 498, 22346, 22349)) {
                                    oldX = CallChecker.beforeCalled(oldX, double[].class, 498, 22346, 22349);
                                    CallChecker.isCalled(currentPoint, double[].class, 498, 22327, 22338)[pj] = CallChecker.isCalled(oldX, double[].class, 498, 22346, 22349)[pj];
                                    CallChecker.varAssign(CallChecker.isCalled(currentPoint, double[].class, 498, 22327, 22338)[pj], "CallChecker.isCalled(currentPoint, double[].class, 498, 22327, 22338)[pj]", 498, 22327, 22354);
                                }
                            }
                        }
                        tmpVec = weightedResidual;
                        CallChecker.varAssign(tmpVec, "tmpVec", 500, 22398, 22426);
                        weightedResidual = oldRes;
                        CallChecker.varAssign(this.weightedResidual, "this.weightedResidual", 501, 22448, 22473);
                        oldRes = tmpVec;
                        CallChecker.varAssign(oldRes, "oldRes", 502, 22495, 22513);
                        tmpVec = currentObjective;
                        CallChecker.varAssign(tmpVec, "tmpVec", 503, 22535, 22563);
                        currentObjective = oldObj;
                        CallChecker.varAssign(currentObjective, "currentObjective", 504, 22585, 22610);
                        oldObj = tmpVec;
                        CallChecker.varAssign(oldObj, "oldObj", 505, 22632, 22650);
                        current = new PointVectorValuePair(currentPoint, currentObjective);
                        CallChecker.varAssign(current, "current", 507, 22731, 22797);
                    }
                    if (((((FastMath.abs(actRed)) <= (costRelativeTolerance)) && (preRed <= (costRelativeTolerance))) && (ratio <= 2.0)) || (delta <= ((parRelativeTolerance) * xNorm))) {
                        setCost(currentCost);
                        return current;
                    }
                    if ((((FastMath.abs(actRed)) <= (LevenbergMarquardtOptimizer.TWO_EPS)) && (preRed <= (LevenbergMarquardtOptimizer.TWO_EPS))) && (ratio <= 2.0)) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, costRelativeTolerance);
                    }else
                        if (delta <= ((LevenbergMarquardtOptimizer.TWO_EPS) * xNorm)) {
                            throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, parRelativeTolerance);
                        }else
                            if (maxCosine <= (LevenbergMarquardtOptimizer.TWO_EPS)) {
                                throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, orthoTolerance);
                            }
                        
                    
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2581.methodEnd();
        }
    }

    private void determineLMParameter(double[] qy, double delta, double[] diag, double[] work1, double[] work2, double[] work3) {
        MethodContext _bcornu_methode_context2582 = new MethodContext(void.class, 558, 24078, 30311);
        try {
            CallChecker.varInit(this, "this", 558, 24078, 30311);
            CallChecker.varInit(work3, "work3", 558, 24078, 30311);
            CallChecker.varInit(work2, "work2", 558, 24078, 30311);
            CallChecker.varInit(work1, "work1", 558, 24078, 30311);
            CallChecker.varInit(diag, "diag", 558, 24078, 30311);
            CallChecker.varInit(delta, "delta", 558, 24078, 30311);
            CallChecker.varInit(qy, "qy", 558, 24078, 30311);
            CallChecker.varInit(this.iterations, "iterations", 558, 24078, 30311);
            CallChecker.varInit(this.evaluations, "evaluations", 558, 24078, 30311);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 558, 24078, 30311);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 558, 24078, 30311);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 558, 24078, 30311);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 558, 24078, 30311);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 558, 24078, 30311);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 558, 24078, 30311);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 558, 24078, 30311);
            CallChecker.varInit(this.lmDir, "lmDir", 558, 24078, 30311);
            CallChecker.varInit(this.lmPar, "lmPar", 558, 24078, 30311);
            CallChecker.varInit(this.rank, "rank", 558, 24078, 30311);
            CallChecker.varInit(this.permutation, "permutation", 558, 24078, 30311);
            CallChecker.varInit(this.beta, "beta", 558, 24078, 30311);
            CallChecker.varInit(this.jacNorm, "jacNorm", 558, 24078, 30311);
            CallChecker.varInit(this.diagR, "diagR", 558, 24078, 30311);
            CallChecker.varInit(this.solvedCols, "solvedCols", 558, 24078, 30311);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 558, 24078, 30311);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 560, 25122, 25137);
            CallChecker.isCalled(weightedJacobian, double[][].class, 560, 25122, 25137)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 560, 25122, 25137)[0], double[].class, 560, 25122, 25140);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 560, 25122, 25137)[0], double[].class, 560, 25122, 25140).length)), "nC", 560, 25107, 25148);
            for (int j = 0; j < (rank); ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 565, 25350, 25360)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 565, 25344, 25348)) {
                        if (CallChecker.beforeDeref(qy, double[].class, 565, 25368, 25369)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 565, 25350, 25360);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 565, 25344, 25348);
                            qy = CallChecker.beforeCalled(qy, double[].class, 565, 25368, 25369);
                            CallChecker.isCalled(lmDir, double[].class, 565, 25344, 25348)[CallChecker.isCalled(permutation, int[].class, 565, 25350, 25360)[j]] = CallChecker.isCalled(qy, double[].class, 565, 25368, 25369)[j];
                            CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 565, 25344, 25348)[CallChecker.isCalled(this.permutation, int[].class, 565, 25350, 25360)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 565, 25344, 25348)[CallChecker.isCalled(this.permutation, int[].class, 565, 25350, 25360)[j]]", 565, 25344, 25373);
                        }
                    }
                }
            }
            for (int j = rank; j < nC; ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 568, 25445, 25455)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 568, 25439, 25443)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 568, 25445, 25455);
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 568, 25439, 25443);
                        CallChecker.isCalled(lmDir, double[].class, 568, 25439, 25443)[CallChecker.isCalled(permutation, int[].class, 568, 25445, 25455)[j]] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 568, 25439, 25443)[CallChecker.isCalled(this.permutation, int[].class, 568, 25445, 25455)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 568, 25439, 25443)[CallChecker.isCalled(this.permutation, int[].class, 568, 25445, 25455)[j]]", 568, 25439, 25464);
                    }
                }
            }
            for (int k = (rank) - 1; k >= 0; --k) {
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 571, 25543, 25553)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 571, 25543, 25553);
                    pk = CallChecker.isCalled(permutation, int[].class, 571, 25543, 25553)[k];
                    CallChecker.varAssign(pk, "pk", 571, 25543, 25553);
                }
                double ypk = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lmDir, double[].class, 572, 25584, 25588)) {
                    if (CallChecker.beforeDeref(diagR, double[].class, 572, 25596, 25600)) {
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 572, 25584, 25588);
                        diagR = CallChecker.beforeCalled(diagR, double[].class, 572, 25596, 25600);
                        ypk = (CallChecker.isCalled(lmDir, double[].class, 572, 25584, 25588)[pk]) / (CallChecker.isCalled(diagR, double[].class, 572, 25596, 25600)[pk]);
                        CallChecker.varAssign(ypk, "ypk", 572, 25584, 25588);
                    }
                }
                for (int i = 0; i < k; ++i) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 574, 25671, 25681)) {
                        if (CallChecker.beforeDeref(lmDir, double[].class, 574, 25665, 25669)) {
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 574, 25696, 25711)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 574, 25696, 25711);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 574, 25696, 25711)[i], double[].class, 574, 25696, 25714)) {
                                    permutation = CallChecker.beforeCalled(permutation, int[].class, 574, 25671, 25681);
                                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 574, 25665, 25669);
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 574, 25696, 25711);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 574, 25696, 25711)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 574, 25696, 25711)[i], double[].class, 574, 25696, 25714);
                                    CallChecker.isCalled(lmDir, double[].class, 574, 25665, 25669)[CallChecker.isCalled(permutation, int[].class, 574, 25671, 25681)[i]] -= ypk * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 574, 25696, 25711)[i], double[].class, 574, 25696, 25714)[pk]);
                                    CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 574, 25665, 25669)[CallChecker.isCalled(this.permutation, int[].class, 574, 25671, 25681)[i]], "CallChecker.isCalled(this.lmDir, double[].class, 574, 25665, 25669)[CallChecker.isCalled(this.permutation, int[].class, 574, 25671, 25681)[i]]", 574, 25665, 25719);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDir, double[].class, 576, 25747, 25751)) {
                    lmDir = CallChecker.beforeCalled(lmDir, double[].class, 576, 25747, 25751);
                    CallChecker.isCalled(lmDir, double[].class, 576, 25747, 25751)[pk] = ypk;
                    CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 576, 25747, 25751)[pk], "CallChecker.isCalled(this.lmDir, double[].class, 576, 25747, 25751)[pk]", 576, 25747, 25762);
                }
            }
            double dxNorm = CallChecker.varInit(((double) (0)), "dxNorm", 581, 25896, 25913);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 583, 25983, 25993)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 583, 25983, 25993);
                    pj = CallChecker.isCalled(permutation, int[].class, 583, 25983, 25993)[j];
                    CallChecker.varAssign(pj, "pj", 583, 25983, 25993);
                }
                double s = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(diag, double[].class, 584, 26022, 26025)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 584, 26033, 26037)) {
                        diag = CallChecker.beforeCalled(diag, double[].class, 584, 26022, 26025);
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 584, 26033, 26037);
                        s = (CallChecker.isCalled(diag, double[].class, 584, 26022, 26025)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 584, 26033, 26037)[pj]);
                        CallChecker.varAssign(s, "s", 584, 26022, 26025);
                    }
                }
                if (CallChecker.beforeDeref(work1, double[].class, 585, 26056, 26060)) {
                    work1 = CallChecker.beforeCalled(work1, double[].class, 585, 26056, 26060);
                    CallChecker.isCalled(work1, double[].class, 585, 26056, 26060)[pj] = s;
                    CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 585, 26056, 26060)[pj], "CallChecker.isCalled(work1, double[].class, 585, 26056, 26060)[pj]", 585, 26056, 26069);
                }
                dxNorm += s * s;
                CallChecker.varAssign(dxNorm, "dxNorm", 586, 26083, 26098);
            }
            dxNorm = FastMath.sqrt(dxNorm);
            CallChecker.varAssign(dxNorm, "dxNorm", 588, 26118, 26148);
            double fp = CallChecker.varInit(((double) (dxNorm - delta)), "fp", 589, 26158, 26184);
            if (fp <= (0.1 * delta)) {
                lmPar = 0;
                CallChecker.varAssign(this.lmPar, "this.lmPar", 591, 26231, 26240);
                return ;
            }
            double sum2 = CallChecker.init(double.class);
            double parl = CallChecker.varInit(((double) (0)), "parl", 599, 26483, 26498);
            if ((rank) == (solvedCols)) {
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 602, 26610, 26620)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 602, 26610, 26620);
                        pj = CallChecker.isCalled(permutation, int[].class, 602, 26610, 26620)[j];
                        CallChecker.varAssign(pj, "pj", 602, 26610, 26620);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 603, 26642, 26646)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 603, 26655, 26658)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 603, 26642, 26646);
                            diag = CallChecker.beforeCalled(diag, double[].class, 603, 26655, 26658);
                            CallChecker.isCalled(work1, double[].class, 603, 26642, 26646)[pj] *= (CallChecker.isCalled(diag, double[].class, 603, 26655, 26658)[pj]) / dxNorm;
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 603, 26642, 26646)[pj], "CallChecker.isCalled(work1, double[].class, 603, 26642, 26646)[pj]", 603, 26642, 26672);
                        }
                    }
                }
                sum2 = 0;
                CallChecker.varAssign(sum2, "sum2", 605, 26700, 26708);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 607, 26786, 26796)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 607, 26786, 26796);
                        pj = CallChecker.isCalled(permutation, int[].class, 607, 26786, 26796)[j];
                        CallChecker.varAssign(pj, "pj", 607, 26786, 26796);
                    }
                    double sum = CallChecker.varInit(((double) (0)), "sum", 608, 26818, 26832);
                    for (int i = 0; i < j; ++i) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 610, 26907, 26922)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 610, 26907, 26922);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 610, 26907, 26922)[i], double[].class, 610, 26907, 26925)) {
                                if (CallChecker.beforeDeref(permutation, int[].class, 610, 26939, 26949)) {
                                    if (CallChecker.beforeDeref(work1, double[].class, 610, 26933, 26937)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 610, 26907, 26922);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 610, 26907, 26922)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 610, 26907, 26922)[i], double[].class, 610, 26907, 26925);
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 610, 26939, 26949);
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 610, 26933, 26937);
                                        sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 610, 26907, 26922)[i], double[].class, 610, 26907, 26925)[pj]) * (CallChecker.isCalled(work1, double[].class, 610, 26933, 26937)[CallChecker.isCalled(permutation, int[].class, 610, 26939, 26949)[i]]);
                                        CallChecker.varAssign(sum, "sum", 610, 26900, 26954);
                                    }
                                }
                            }
                        }
                    }
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(work1, double[].class, 612, 27002, 27006)) {
                        if (CallChecker.beforeDeref(diagR, double[].class, 612, 27021, 27025)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 612, 27002, 27006);
                            diagR = CallChecker.beforeCalled(diagR, double[].class, 612, 27021, 27025);
                            s = ((CallChecker.isCalled(work1, double[].class, 612, 27002, 27006)[pj]) - sum) / (CallChecker.isCalled(diagR, double[].class, 612, 27021, 27025)[pj]);
                            CallChecker.varAssign(s, "s", 612, 27002, 27006);
                        }
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 613, 27048, 27052)) {
                        work1 = CallChecker.beforeCalled(work1, double[].class, 613, 27048, 27052);
                        CallChecker.isCalled(work1, double[].class, 613, 27048, 27052)[pj] = s;
                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 613, 27048, 27052)[pj], "CallChecker.isCalled(work1, double[].class, 613, 27048, 27052)[pj]", 613, 27048, 27061);
                    }
                    sum2 += s * s;
                    CallChecker.varAssign(sum2, "sum2", 614, 27079, 27092);
                }
                parl = fp / (delta * sum2);
                CallChecker.varAssign(parl, "parl", 616, 27120, 27146);
            }
            sum2 = 0;
            CallChecker.varAssign(sum2, "sum2", 620, 27239, 27247);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 622, 27317, 27327)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 622, 27317, 27327);
                    pj = CallChecker.isCalled(permutation, int[].class, 622, 27317, 27327)[j];
                    CallChecker.varAssign(pj, "pj", 622, 27317, 27327);
                }
                double sum = CallChecker.varInit(((double) (0)), "sum", 623, 27345, 27359);
                for (int i = 0; i <= j; ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 625, 27427, 27442)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 625, 27427, 27442);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 625, 27427, 27442)[i], double[].class, 625, 27427, 27445)) {
                            if (CallChecker.beforeDeref(qy, double[].class, 625, 27453, 27454)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 625, 27427, 27442);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 625, 27427, 27442)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 625, 27427, 27442)[i], double[].class, 625, 27427, 27445);
                                qy = CallChecker.beforeCalled(qy, double[].class, 625, 27453, 27454);
                                sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 625, 27427, 27442)[i], double[].class, 625, 27427, 27445)[pj]) * (CallChecker.isCalled(qy, double[].class, 625, 27453, 27454)[i]);
                                CallChecker.varAssign(sum, "sum", 625, 27420, 27458);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(diag, double[].class, 627, 27493, 27496)) {
                    diag = CallChecker.beforeCalled(diag, double[].class, 627, 27493, 27496);
                    sum /= CallChecker.isCalled(diag, double[].class, 627, 27493, 27496)[pj];
                    CallChecker.varAssign(sum, "sum", 627, 27486, 27501);
                }
                sum2 += sum * sum;
                CallChecker.varAssign(sum2, "sum2", 628, 27515, 27532);
            }
            double gNorm = CallChecker.varInit(((double) (FastMath.sqrt(sum2))), "gNorm", 630, 27552, 27586);
            double paru = CallChecker.varInit(((double) (gNorm / delta)), "paru", 631, 27596, 27623);
            if (paru == 0) {
                paru = (Precision.SAFE_MIN) / (FastMath.min(delta, 0.1));
                CallChecker.varAssign(paru, "paru", 633, 27662, 27714);
            }
            lmPar = FastMath.min(paru, FastMath.max(lmPar, parl));
            CallChecker.varAssign(this.lmPar, "this.lmPar", 638, 27847, 27900);
            if ((lmPar) == 0) {
                lmPar = gNorm / dxNorm;
                CallChecker.varAssign(this.lmPar, "this.lmPar", 640, 27940, 27962);
            }
            for (int countdown = 10; countdown >= 0; --countdown) {
                if ((lmPar) == 0) {
                    lmPar = FastMath.max(Precision.SAFE_MIN, (0.001 * paru));
                    CallChecker.varAssign(this.lmPar, "this.lmPar", 647, 28153, 28207);
                }
                double sPar = CallChecker.varInit(((double) (FastMath.sqrt(this.lmPar))), "sPar", 649, 28235, 28269);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 651, 28347, 28357)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 651, 28347, 28357);
                        pj = CallChecker.isCalled(permutation, int[].class, 651, 28347, 28357)[j];
                        CallChecker.varAssign(pj, "pj", 651, 28347, 28357);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 652, 28379, 28383)) {
                        if (CallChecker.beforeDeref(diag, double[].class, 652, 28398, 28401)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 652, 28379, 28383);
                            diag = CallChecker.beforeCalled(diag, double[].class, 652, 28398, 28401);
                            CallChecker.isCalled(work1, double[].class, 652, 28379, 28383)[pj] = sPar * (CallChecker.isCalled(diag, double[].class, 652, 28398, 28401)[pj]);
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 652, 28379, 28383)[pj], "CallChecker.isCalled(work1, double[].class, 652, 28379, 28383)[pj]", 652, 28379, 28406);
                        }
                    }
                }
                determineLMDirection(qy, work1, work2, work3);
                dxNorm = 0;
                CallChecker.varAssign(dxNorm, "dxNorm", 656, 28494, 28504);
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 658, 28582, 28592)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 658, 28582, 28592);
                        pj = CallChecker.isCalled(permutation, int[].class, 658, 28582, 28592)[j];
                        CallChecker.varAssign(pj, "pj", 658, 28582, 28592);
                    }
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(diag, double[].class, 659, 28625, 28628)) {
                        if (CallChecker.beforeDeref(lmDir, double[].class, 659, 28636, 28640)) {
                            diag = CallChecker.beforeCalled(diag, double[].class, 659, 28625, 28628);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 659, 28636, 28640);
                            s = (CallChecker.isCalled(diag, double[].class, 659, 28625, 28628)[pj]) * (CallChecker.isCalled(lmDir, double[].class, 659, 28636, 28640)[pj]);
                            CallChecker.varAssign(s, "s", 659, 28625, 28628);
                        }
                    }
                    if (CallChecker.beforeDeref(work3, double[].class, 660, 28663, 28667)) {
                        work3 = CallChecker.beforeCalled(work3, double[].class, 660, 28663, 28667);
                        CallChecker.isCalled(work3, double[].class, 660, 28663, 28667)[pj] = s;
                        CallChecker.varAssign(CallChecker.isCalled(work3, double[].class, 660, 28663, 28667)[pj], "CallChecker.isCalled(work3, double[].class, 660, 28663, 28667)[pj]", 660, 28663, 28676);
                    }
                    dxNorm += s * s;
                    CallChecker.varAssign(dxNorm, "dxNorm", 661, 28694, 28709);
                }
                dxNorm = FastMath.sqrt(dxNorm);
                CallChecker.varAssign(dxNorm, "dxNorm", 663, 28737, 28767);
                double previousFP = CallChecker.varInit(((double) (fp)), "previousFP", 664, 28781, 28803);
                fp = dxNorm - delta;
                CallChecker.varAssign(fp, "fp", 665, 28817, 28836);
                if (((FastMath.abs(fp)) <= (0.1 * delta)) || (((parl == 0) && (fp <= previousFP)) && (previousFP < 0))) {
                    return ;
                }
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 676, 29284, 29294)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 676, 29284, 29294);
                        pj = CallChecker.isCalled(permutation, int[].class, 676, 29284, 29294)[j];
                        CallChecker.varAssign(pj, "pj", 676, 29284, 29294);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 677, 29316, 29320)) {
                        if (CallChecker.beforeDeref(work3, double[].class, 677, 29328, 29332)) {
                            if (CallChecker.beforeDeref(diag, double[].class, 677, 29340, 29343)) {
                                work1 = CallChecker.beforeCalled(work1, double[].class, 677, 29316, 29320);
                                work3 = CallChecker.beforeCalled(work3, double[].class, 677, 29328, 29332);
                                diag = CallChecker.beforeCalled(diag, double[].class, 677, 29340, 29343);
                                CallChecker.isCalled(work1, double[].class, 677, 29316, 29320)[pj] = ((CallChecker.isCalled(work3, double[].class, 677, 29328, 29332)[pj]) * (CallChecker.isCalled(diag, double[].class, 677, 29340, 29343)[pj])) / dxNorm;
                                CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 677, 29316, 29320)[pj], "CallChecker.isCalled(work1, double[].class, 677, 29316, 29320)[pj]", 677, 29316, 29357);
                            }
                        }
                    }
                }
                for (int j = 0; j < (solvedCols); ++j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 680, 29449, 29459)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 680, 29449, 29459);
                        pj = CallChecker.isCalled(permutation, int[].class, 680, 29449, 29459)[j];
                        CallChecker.varAssign(pj, "pj", 680, 29449, 29459);
                    }
                    if (CallChecker.beforeDeref(work1, double[].class, 681, 29481, 29485)) {
                        if (CallChecker.beforeDeref(work2, double[].class, 681, 29494, 29498)) {
                            work1 = CallChecker.beforeCalled(work1, double[].class, 681, 29481, 29485);
                            work2 = CallChecker.beforeCalled(work2, double[].class, 681, 29494, 29498);
                            CallChecker.isCalled(work1, double[].class, 681, 29481, 29485)[pj] /= CallChecker.isCalled(work2, double[].class, 681, 29494, 29498)[j];
                            CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 681, 29481, 29485)[pj], "CallChecker.isCalled(work1, double[].class, 681, 29481, 29485)[pj]", 681, 29481, 29502);
                        }
                    }
                    double tmp = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(work1, double[].class, 682, 29533, 29537)) {
                        work1 = CallChecker.beforeCalled(work1, double[].class, 682, 29533, 29537);
                        tmp = CallChecker.isCalled(work1, double[].class, 682, 29533, 29537)[pj];
                        CallChecker.varAssign(tmp, "tmp", 682, 29533, 29537);
                    }
                    for (int i = j + 1; i < (solvedCols); ++i) {
                        if (CallChecker.beforeDeref(permutation, int[].class, 684, 29629, 29639)) {
                            if (CallChecker.beforeDeref(work1, double[].class, 684, 29623, 29627)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 684, 29648, 29663)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 684, 29648, 29663);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 684, 29648, 29663)[i], double[].class, 684, 29648, 29666)) {
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 684, 29629, 29639);
                                        work1 = CallChecker.beforeCalled(work1, double[].class, 684, 29623, 29627);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 684, 29648, 29663);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 684, 29648, 29663)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 684, 29648, 29663)[i], double[].class, 684, 29648, 29666);
                                        CallChecker.isCalled(work1, double[].class, 684, 29623, 29627)[CallChecker.isCalled(permutation, int[].class, 684, 29629, 29639)[i]] -= (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 684, 29648, 29663)[i], double[].class, 684, 29648, 29666)[pj]) * tmp;
                                        CallChecker.varAssign(CallChecker.isCalled(work1, double[].class, 684, 29623, 29627)[CallChecker.isCalled(this.permutation, int[].class, 684, 29629, 29639)[i]], "CallChecker.isCalled(work1, double[].class, 684, 29623, 29627)[CallChecker.isCalled(this.permutation, int[].class, 684, 29629, 29639)[i]]", 684, 29623, 29677);
                                    }
                                }
                            }
                        }
                    }
                }
                sum2 = 0;
                CallChecker.varAssign(sum2, "sum2", 687, 29723, 29731);
                for (int j = 0; j < (solvedCols); ++j) {
                    double s = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 689, 29817, 29827)) {
                        if (CallChecker.beforeDeref(work1, double[].class, 689, 29811, 29815)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 689, 29817, 29827);
                            work1 = CallChecker.beforeCalled(work1, double[].class, 689, 29811, 29815);
                            s = CallChecker.isCalled(work1, double[].class, 689, 29811, 29815)[CallChecker.isCalled(permutation, int[].class, 689, 29817, 29827)[j]];
                            CallChecker.varAssign(s, "s", 689, 29817, 29827);
                        }
                    }
                    sum2 += s * s;
                    CallChecker.varAssign(sum2, "sum2", 690, 29850, 29863);
                }
                double correction = CallChecker.varInit(((double) (fp / (delta * sum2))), "correction", 692, 29891, 29930);
                if (fp > 0) {
                    parl = FastMath.max(parl, lmPar);
                    CallChecker.varAssign(parl, "parl", 696, 30050, 30082);
                }else
                    if (fp < 0) {
                        paru = FastMath.min(paru, lmPar);
                        CallChecker.varAssign(paru, "paru", 698, 30133, 30165);
                    }
                
                lmPar = FastMath.max(parl, ((lmPar) + correction));
                CallChecker.varAssign(this.lmPar, "this.lmPar", 702, 30248, 30294);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2582.methodEnd();
        }
    }

    private void determineLMDirection(double[] qy, double[] diag, double[] lmDiag, double[] work) {
        MethodContext _bcornu_methode_context2583 = new MethodContext(void.class, 727, 30318, 35200);
        try {
            CallChecker.varInit(this, "this", 727, 30318, 35200);
            CallChecker.varInit(work, "work", 727, 30318, 35200);
            CallChecker.varInit(lmDiag, "lmDiag", 727, 30318, 35200);
            CallChecker.varInit(diag, "diag", 727, 30318, 35200);
            CallChecker.varInit(qy, "qy", 727, 30318, 35200);
            CallChecker.varInit(this.iterations, "iterations", 727, 30318, 35200);
            CallChecker.varInit(this.evaluations, "evaluations", 727, 30318, 35200);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 727, 30318, 35200);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 727, 30318, 35200);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 727, 30318, 35200);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 727, 30318, 35200);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 727, 30318, 35200);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 727, 30318, 35200);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 727, 30318, 35200);
            CallChecker.varInit(this.lmDir, "lmDir", 727, 30318, 35200);
            CallChecker.varInit(this.lmPar, "lmPar", 727, 30318, 35200);
            CallChecker.varInit(this.rank, "rank", 727, 30318, 35200);
            CallChecker.varInit(this.permutation, "permutation", 727, 30318, 35200);
            CallChecker.varInit(this.beta, "beta", 727, 30318, 35200);
            CallChecker.varInit(this.jacNorm, "jacNorm", 727, 30318, 35200);
            CallChecker.varInit(this.diagR, "diagR", 727, 30318, 35200);
            CallChecker.varInit(this.solvedCols, "solvedCols", 727, 30318, 35200);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 727, 30318, 35200);
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 733, 31446, 31456)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 733, 31446, 31456);
                    pj = CallChecker.isCalled(permutation, int[].class, 733, 31446, 31456)[j];
                    CallChecker.varAssign(pj, "pj", 733, 31446, 31456);
                }
                for (int i = j + 1; i < (solvedCols); ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 735, 31533, 31548)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 735, 31533, 31548);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31533, 31548)[i], double[].class, 735, 31533, 31551)) {
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 735, 31559, 31574)) {
                                if (CallChecker.beforeDeref(permutation, int[].class, 735, 31579, 31589)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 735, 31559, 31574);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31559, 31574)[j], double[].class, 735, 31559, 31577)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 735, 31533, 31548);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31533, 31548)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31533, 31548)[i], double[].class, 735, 31533, 31551);
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 735, 31559, 31574);
                                        permutation = CallChecker.beforeCalled(permutation, int[].class, 735, 31579, 31589);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31559, 31574)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31559, 31574)[j], double[].class, 735, 31559, 31577);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31533, 31548)[i], double[].class, 735, 31533, 31551)[pj] = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 735, 31559, 31574)[j], double[].class, 735, 31559, 31577)[CallChecker.isCalled(permutation, int[].class, 735, 31579, 31589)[i]];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 735, 31533, 31548)[i], double[].class, 735, 31533, 31551)[pj], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 735, 31533, 31548)[i], double[].class, 735, 31533, 31551)[pj]", 735, 31533, 31594);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDir, double[].class, 737, 31622, 31626)) {
                    if (CallChecker.beforeDeref(diagR, double[].class, 737, 31633, 31637)) {
                        lmDir = CallChecker.beforeCalled(lmDir, double[].class, 737, 31622, 31626);
                        diagR = CallChecker.beforeCalled(diagR, double[].class, 737, 31633, 31637);
                        CallChecker.isCalled(lmDir, double[].class, 737, 31622, 31626)[j] = CallChecker.isCalled(diagR, double[].class, 737, 31633, 31637)[pj];
                        CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 737, 31622, 31626)[j], "CallChecker.isCalled(this.lmDir, double[].class, 737, 31622, 31626)[j]", 737, 31622, 31642);
                    }
                }
                if (CallChecker.beforeDeref(work, double[].class, 738, 31656, 31659)) {
                    if (CallChecker.beforeDeref(qy, double[].class, 738, 31667, 31668)) {
                        work = CallChecker.beforeCalled(work, double[].class, 738, 31656, 31659);
                        qy = CallChecker.beforeCalled(qy, double[].class, 738, 31667, 31668);
                        CallChecker.isCalled(work, double[].class, 738, 31656, 31659)[j] = CallChecker.isCalled(qy, double[].class, 738, 31667, 31668)[j];
                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 738, 31656, 31659)[j], "CallChecker.isCalled(work, double[].class, 738, 31656, 31659)[j]", 738, 31656, 31672);
                    }
                }
            }
            for (int j = 0; j < (solvedCols); ++j) {
                int pj = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 746, 31956, 31966)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 746, 31956, 31966);
                    pj = CallChecker.isCalled(permutation, int[].class, 746, 31956, 31966)[j];
                    CallChecker.varAssign(pj, "pj", 746, 31956, 31966);
                }
                double dpj = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(diag, double[].class, 747, 31997, 32000)) {
                    diag = CallChecker.beforeCalled(diag, double[].class, 747, 31997, 32000);
                    dpj = CallChecker.isCalled(diag, double[].class, 747, 31997, 32000)[pj];
                    CallChecker.varAssign(dpj, "dpj", 747, 31997, 32000);
                }
                if (dpj != 0) {
                    if (CallChecker.beforeDeref(lmDiag, double[].class, 749, 32078, 32083)) {
                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 749, 32078, 32083);
                        Arrays.fill(lmDiag, (j + 1), CallChecker.isCalled(lmDiag, double[].class, 749, 32078, 32083).length, 0);
                    }
                }
                if (CallChecker.beforeDeref(lmDiag, double[].class, 751, 32123, 32128)) {
                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 751, 32123, 32128);
                    CallChecker.isCalled(lmDiag, double[].class, 751, 32123, 32128)[j] = dpj;
                    CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 751, 32123, 32128)[j], "CallChecker.isCalled(lmDiag, double[].class, 751, 32123, 32128)[j]", 751, 32123, 32138);
                }
                double qtbpj = CallChecker.varInit(((double) (0)), "qtbpj", 756, 32326, 32342);
                for (int k = j; k < (solvedCols); ++k) {
                    int pk = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 758, 32420, 32430)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 758, 32420, 32430);
                        pk = CallChecker.isCalled(permutation, int[].class, 758, 32420, 32430)[k];
                        CallChecker.varAssign(pk, "pk", 758, 32420, 32430);
                    }
                    if (CallChecker.beforeDeref(lmDiag, double[].class, 762, 32588, 32593)) {
                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 762, 32588, 32593);
                        if ((CallChecker.isCalled(lmDiag, double[].class, 762, 32588, 32593)[k]) != 0) {
                            double sin = CallChecker.init(double.class);
                            double cos = CallChecker.init(double.class);
                            double rkk = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 766, 32716, 32731)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 766, 32716, 32731);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 766, 32716, 32731)[k], double[].class, 766, 32716, 32734)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 766, 32716, 32731);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 766, 32716, 32731)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 766, 32716, 32731)[k], double[].class, 766, 32716, 32734);
                                    rkk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 766, 32716, 32731)[k], double[].class, 766, 32716, 32734)[pk];
                                    CallChecker.varAssign(rkk, "rkk", 766, 32716, 32731);
                                }
                            }
                            if (CallChecker.beforeDeref(lmDiag, double[].class, 767, 32798, 32803)) {
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 767, 32798, 32803);
                                if ((FastMath.abs(rkk)) < (FastMath.abs(CallChecker.isCalled(lmDiag, double[].class, 767, 32798, 32803)[k]))) {
                                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 768, 32863, 32868);
                                    final double cotan = CallChecker.varInit(((double) (rkk / (CallChecker.isCalled(lmDiag, double[].class, 768, 32863, 32868)[k]))), "cotan", 768, 32836, 32872);
                                    sin = 1.0 / (FastMath.sqrt((1.0 + (cotan * cotan))));
                                    CallChecker.varAssign(sin, "sin", 769, 32898, 32946);
                                    cos = sin * cotan;
                                    CallChecker.varAssign(cos, "cos", 770, 32972, 32991);
                                }else {
                                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 772, 33065, 33070);
                                    final double tan = CallChecker.varInit(((double) ((CallChecker.isCalled(lmDiag, double[].class, 772, 33065, 33070)[k]) / rkk)), "tan", 772, 33046, 33080);
                                    cos = 1.0 / (FastMath.sqrt((1.0 + (tan * tan))));
                                    CallChecker.varAssign(cos, "cos", 773, 33106, 33148);
                                    sin = cos * tan;
                                    CallChecker.varAssign(sin, "sin", 774, 33174, 33189);
                                }
                            }
                            if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 779, 33359, 33374)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 779, 33359, 33374);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 779, 33359, 33374)[k], double[].class, 779, 33359, 33377)) {
                                    if (CallChecker.beforeDeref(lmDiag, double[].class, 779, 33403, 33408)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 779, 33359, 33374);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 779, 33359, 33374)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 779, 33359, 33374)[k], double[].class, 779, 33359, 33377);
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 779, 33403, 33408);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 779, 33359, 33374)[k], double[].class, 779, 33359, 33377)[pk] = (cos * rkk) + (sin * (CallChecker.isCalled(lmDiag, double[].class, 779, 33403, 33408)[k]));
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 779, 33359, 33374)[k], double[].class, 779, 33359, 33377)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 779, 33359, 33374)[k], double[].class, 779, 33359, 33377)[pk]", 779, 33359, 33412);
                                    }
                                }
                            }
                            work = CallChecker.beforeCalled(work, double[].class, 780, 33460, 33463);
                            final double temp = CallChecker.varInit(((double) ((cos * (CallChecker.isCalled(work, double[].class, 780, 33460, 33463)[k])) + (sin * qtbpj))), "temp", 780, 33434, 33481);
                            if (CallChecker.beforeDeref(work, double[].class, 781, 33518, 33521)) {
                                work = CallChecker.beforeCalled(work, double[].class, 781, 33518, 33521);
                                qtbpj = ((-sin) * (CallChecker.isCalled(work, double[].class, 781, 33518, 33521)[k])) + (cos * qtbpj);
                                CallChecker.varAssign(qtbpj, "qtbpj", 781, 33503, 33539);
                            }
                            if (CallChecker.beforeDeref(work, double[].class, 782, 33561, 33564)) {
                                work = CallChecker.beforeCalled(work, double[].class, 782, 33561, 33564);
                                CallChecker.isCalled(work, double[].class, 782, 33561, 33564)[k] = temp;
                                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 782, 33561, 33564)[k], "CallChecker.isCalled(work, double[].class, 782, 33561, 33564)[k]", 782, 33561, 33575);
                            }
                            for (int i = k + 1; i < (solvedCols); ++i) {
                                double rik = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 786, 33746, 33761)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 786, 33746, 33761);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 786, 33746, 33761)[i], double[].class, 786, 33746, 33764)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 786, 33746, 33761);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 786, 33746, 33761)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 786, 33746, 33761)[i], double[].class, 786, 33746, 33764);
                                        rik = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 786, 33746, 33761)[i], double[].class, 786, 33746, 33764)[pk];
                                        CallChecker.varAssign(rik, "rik", 786, 33746, 33761);
                                    }
                                }
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 787, 33834, 33839);
                                final double temp2 = CallChecker.varInit(((double) ((cos * rik) + (sin * (CallChecker.isCalled(lmDiag, double[].class, 787, 33834, 33839)[i])))), "temp2", 787, 33795, 33843);
                                if (CallChecker.beforeDeref(lmDiag, double[].class, 788, 33869, 33874)) {
                                    if (CallChecker.beforeDeref(lmDiag, double[].class, 788, 33900, 33905)) {
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 788, 33869, 33874);
                                        lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 788, 33900, 33905);
                                        CallChecker.isCalled(lmDiag, double[].class, 788, 33869, 33874)[i] = ((-sin) * rik) + (cos * (CallChecker.isCalled(lmDiag, double[].class, 788, 33900, 33905)[i]));
                                        CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 788, 33869, 33874)[i], "CallChecker.isCalled(lmDiag, double[].class, 788, 33869, 33874)[i]", 788, 33869, 33909);
                                    }
                                }
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 789, 33935, 33950)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 789, 33935, 33950);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 789, 33935, 33950)[i], double[].class, 789, 33935, 33953)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 789, 33935, 33950);
                                        CallChecker.isCalled(weightedJacobian, double[][].class, 789, 33935, 33950)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 789, 33935, 33950)[i], double[].class, 789, 33935, 33953);
                                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 789, 33935, 33950)[i], double[].class, 789, 33935, 33953)[pk] = temp2;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 789, 33935, 33950)[i], double[].class, 789, 33935, 33953)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 789, 33935, 33950)[i], double[].class, 789, 33935, 33953)[pk]", 789, 33935, 33966);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(lmDiag, double[].class, 796, 34149, 34154)) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 796, 34161, 34176)) {
                        if (CallChecker.beforeDeref(permutation, int[].class, 796, 34181, 34191)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 796, 34161, 34176);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 796, 34161, 34176)[j], double[].class, 796, 34161, 34179)) {
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 796, 34149, 34154);
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 796, 34161, 34176);
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 796, 34181, 34191);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 796, 34161, 34176)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 796, 34161, 34176)[j], double[].class, 796, 34161, 34179);
                                CallChecker.isCalled(lmDiag, double[].class, 796, 34149, 34154)[j] = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 796, 34161, 34176)[j], double[].class, 796, 34161, 34179)[CallChecker.isCalled(permutation, int[].class, 796, 34181, 34191)[j]];
                                CallChecker.varAssign(CallChecker.isCalled(lmDiag, double[].class, 796, 34149, 34154)[j], "CallChecker.isCalled(lmDiag, double[].class, 796, 34149, 34154)[j]", 796, 34149, 34196);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 797, 34210, 34225)) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 797, 34230, 34240)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 797, 34210, 34225);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 797, 34210, 34225)[j], double[].class, 797, 34210, 34228)) {
                            if (CallChecker.beforeDeref(lmDir, double[].class, 797, 34248, 34252)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 797, 34210, 34225);
                                permutation = CallChecker.beforeCalled(permutation, int[].class, 797, 34230, 34240);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 797, 34210, 34225)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 797, 34210, 34225)[j], double[].class, 797, 34210, 34228);
                                lmDir = CallChecker.beforeCalled(lmDir, double[].class, 797, 34248, 34252);
                                CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 797, 34210, 34225)[j], double[].class, 797, 34210, 34228)[CallChecker.isCalled(permutation, int[].class, 797, 34230, 34240)[j]] = CallChecker.isCalled(lmDir, double[].class, 797, 34248, 34252)[j];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 797, 34210, 34225)[j], double[].class, 797, 34210, 34228)[CallChecker.isCalled(this.permutation, int[].class, 797, 34230, 34240)[j]], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 797, 34210, 34225)[j], double[].class, 797, 34210, 34228)[CallChecker.isCalled(this.permutation, int[].class, 797, 34230, 34240)[j]]", 797, 34210, 34256);
                            }
                        }
                    }
                }
            }
            int nSing = CallChecker.varInit(((int) (this.solvedCols)), "nSing", 802, 34398, 34420);
            for (int j = 0; j < (solvedCols); ++j) {
                if (CallChecker.beforeDeref(lmDiag, double[].class, 804, 34486, 34491)) {
                    lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 804, 34486, 34491);
                    if (((CallChecker.isCalled(lmDiag, double[].class, 804, 34486, 34491)[j]) == 0) && (nSing == (solvedCols))) {
                        nSing = j;
                        CallChecker.varAssign(nSing, "nSing", 805, 34546, 34555);
                    }
                }
                if (nSing < (solvedCols)) {
                    if (CallChecker.beforeDeref(work, double[].class, 808, 34625, 34628)) {
                        work = CallChecker.beforeCalled(work, double[].class, 808, 34625, 34628);
                        CallChecker.isCalled(work, double[].class, 808, 34625, 34628)[j] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 808, 34625, 34628)[j], "CallChecker.isCalled(work, double[].class, 808, 34625, 34628)[j]", 808, 34625, 34636);
                    }
                }
            }
            if (nSing > 0) {
                for (int j = nSing - 1; j >= 0; --j) {
                    int pj = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(permutation, int[].class, 813, 34763, 34773)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 813, 34763, 34773);
                        pj = CallChecker.isCalled(permutation, int[].class, 813, 34763, 34773)[j];
                        CallChecker.varAssign(pj, "pj", 813, 34763, 34773);
                    }
                    double sum = CallChecker.varInit(((double) (0)), "sum", 814, 34795, 34809);
                    for (int i = j + 1; i < nSing; ++i) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 816, 34892, 34907)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 816, 34892, 34907);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 816, 34892, 34907)[i], double[].class, 816, 34892, 34910)) {
                                if (CallChecker.beforeDeref(work, double[].class, 816, 34918, 34921)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 816, 34892, 34907);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 816, 34892, 34907)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 816, 34892, 34907)[i], double[].class, 816, 34892, 34910);
                                    work = CallChecker.beforeCalled(work, double[].class, 816, 34918, 34921);
                                    sum += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 816, 34892, 34907)[i], double[].class, 816, 34892, 34910)[pj]) * (CallChecker.isCalled(work, double[].class, 816, 34918, 34921)[i]);
                                    CallChecker.varAssign(sum, "sum", 816, 34885, 34925);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(work, double[].class, 818, 34961, 34964)) {
                        if (CallChecker.beforeDeref(work, double[].class, 818, 34972, 34975)) {
                            if (CallChecker.beforeDeref(lmDiag, double[].class, 818, 34989, 34994)) {
                                work = CallChecker.beforeCalled(work, double[].class, 818, 34961, 34964);
                                work = CallChecker.beforeCalled(work, double[].class, 818, 34972, 34975);
                                lmDiag = CallChecker.beforeCalled(lmDiag, double[].class, 818, 34989, 34994);
                                CallChecker.isCalled(work, double[].class, 818, 34961, 34964)[j] = ((CallChecker.isCalled(work, double[].class, 818, 34972, 34975)[j]) - sum) / (CallChecker.isCalled(lmDiag, double[].class, 818, 34989, 34994)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 818, 34961, 34964)[j], "CallChecker.isCalled(work, double[].class, 818, 34961, 34964)[j]", 818, 34961, 34998);
                            }
                        }
                    }
                }
            }
            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 823, 35120, 35124);
            for (int j = 0; j < (CallChecker.isCalled(lmDir, double[].class, 823, 35120, 35124).length); ++j) {
                if (CallChecker.beforeDeref(permutation, int[].class, 824, 35159, 35169)) {
                    if (CallChecker.beforeDeref(lmDir, double[].class, 824, 35153, 35157)) {
                        if (CallChecker.beforeDeref(work, double[].class, 824, 35177, 35180)) {
                            permutation = CallChecker.beforeCalled(permutation, int[].class, 824, 35159, 35169);
                            lmDir = CallChecker.beforeCalled(lmDir, double[].class, 824, 35153, 35157);
                            work = CallChecker.beforeCalled(work, double[].class, 824, 35177, 35180);
                            CallChecker.isCalled(lmDir, double[].class, 824, 35153, 35157)[CallChecker.isCalled(permutation, int[].class, 824, 35159, 35169)[j]] = CallChecker.isCalled(work, double[].class, 824, 35177, 35180)[j];
                            CallChecker.varAssign(CallChecker.isCalled(this.lmDir, double[].class, 824, 35153, 35157)[CallChecker.isCalled(this.permutation, int[].class, 824, 35159, 35169)[j]], "CallChecker.isCalled(this.lmDir, double[].class, 824, 35153, 35157)[CallChecker.isCalled(this.permutation, int[].class, 824, 35159, 35169)[j]]", 824, 35153, 35184);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2583.methodEnd();
        }
    }

    private void qrDecomposition(RealMatrix jacobian) throws ConvergenceException {
        MethodContext _bcornu_methode_context2584 = new MethodContext(void.class, 852, 35207, 39345);
        try {
            CallChecker.varInit(this, "this", 852, 35207, 39345);
            CallChecker.varInit(jacobian, "jacobian", 852, 35207, 39345);
            CallChecker.varInit(this.iterations, "iterations", 852, 35207, 39345);
            CallChecker.varInit(this.evaluations, "evaluations", 852, 35207, 39345);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 852, 35207, 39345);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 852, 35207, 39345);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 852, 35207, 39345);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 852, 35207, 39345);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 852, 35207, 39345);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 852, 35207, 39345);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 852, 35207, 39345);
            CallChecker.varInit(this.lmDir, "lmDir", 852, 35207, 39345);
            CallChecker.varInit(this.lmPar, "lmPar", 852, 35207, 39345);
            CallChecker.varInit(this.rank, "rank", 852, 35207, 39345);
            CallChecker.varInit(this.permutation, "permutation", 852, 35207, 39345);
            CallChecker.varInit(this.beta, "beta", 852, 35207, 39345);
            CallChecker.varInit(this.jacNorm, "jacNorm", 852, 35207, 39345);
            CallChecker.varInit(this.diagR, "diagR", 852, 35207, 39345);
            CallChecker.varInit(this.solvedCols, "solvedCols", 852, 35207, 39345);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 852, 35207, 39345);
            if (CallChecker.beforeDeref(jacobian, RealMatrix.class, 855, 36740, 36747)) {
                jacobian = CallChecker.beforeCalled(jacobian, RealMatrix.class, 855, 36740, 36747);
                final RealMatrix npe_invocation_var683 = CallChecker.isCalled(jacobian, RealMatrix.class, 855, 36740, 36747).scalarMultiply((-1));
                if (CallChecker.beforeDeref(npe_invocation_var683, RealMatrix.class, 855, 36740, 36766)) {
                    weightedJacobian = CallChecker.isCalled(npe_invocation_var683, RealMatrix.class, 855, 36740, 36766).getData();
                    CallChecker.varAssign(this.weightedJacobian, "this.weightedJacobian", 855, 36721, 36777);
                }
            }
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 857, 36803, 36818);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(this.weightedJacobian, double[][].class, 857, 36803, 36818).length)), "nR", 857, 36788, 36826);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 858, 36851, 36866);
            CallChecker.isCalled(weightedJacobian, double[][].class, 858, 36851, 36866)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 858, 36851, 36866)[0], double[].class, 858, 36851, 36869);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 858, 36851, 36866)[0], double[].class, 858, 36851, 36869).length)), "nC", 858, 36836, 36877);
            for (int k = 0; k < nC; ++k) {
                if (CallChecker.beforeDeref(permutation, int[].class, 862, 36958, 36968)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 862, 36958, 36968);
                    CallChecker.isCalled(permutation, int[].class, 862, 36958, 36968)[k] = k;
                    CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 862, 36958, 36968)[k], "CallChecker.isCalled(this.permutation, int[].class, 862, 36958, 36968)[k]", 862, 36958, 36976);
                }
                double norm2 = CallChecker.varInit(((double) (0)), "norm2", 863, 36990, 37006);
                for (int i = 0; i < nR; ++i) {
                    double akk = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 865, 37080, 37095)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 865, 37080, 37095);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 865, 37080, 37095)[i], double[].class, 865, 37080, 37098)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 865, 37080, 37095);
                            CallChecker.isCalled(weightedJacobian, double[][].class, 865, 37080, 37095)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 865, 37080, 37095)[i], double[].class, 865, 37080, 37098);
                            akk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 865, 37080, 37095)[i], double[].class, 865, 37080, 37098)[k];
                            CallChecker.varAssign(akk, "akk", 865, 37080, 37095);
                        }
                    }
                    norm2 += akk * akk;
                    CallChecker.varAssign(norm2, "norm2", 866, 37120, 37138);
                }
                if (CallChecker.beforeDeref(jacNorm, double[].class, 868, 37166, 37172)) {
                    jacNorm = CallChecker.beforeCalled(jacNorm, double[].class, 868, 37166, 37172);
                    CallChecker.isCalled(jacNorm, double[].class, 868, 37166, 37172)[k] = FastMath.sqrt(norm2);
                    CallChecker.varAssign(CallChecker.isCalled(this.jacNorm, double[].class, 868, 37166, 37172)[k], "CallChecker.isCalled(this.jacNorm, double[].class, 868, 37166, 37172)[k]", 868, 37166, 37199);
                }
            }
            for (int k = 0; k < nC; ++k) {
                int nextColumn = CallChecker.varInit(((int) (-1)), "nextColumn", 875, 37393, 37412);
                double ak2 = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "ak2", 876, 37426, 37463);
                for (int i = k; i < nC; ++i) {
                    double norm2 = CallChecker.varInit(((double) (0)), "norm2", 878, 37524, 37540);
                    for (int j = k; j < nR; ++j) {
                        double aki = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 880, 37622, 37637)) {
                            if (CallChecker.beforeDeref(permutation, int[].class, 880, 37642, 37652)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 880, 37622, 37637);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 880, 37622, 37637)[j], double[].class, 880, 37622, 37640)) {
                                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 880, 37622, 37637);
                                    permutation = CallChecker.beforeCalled(permutation, int[].class, 880, 37642, 37652);
                                    CallChecker.isCalled(weightedJacobian, double[][].class, 880, 37622, 37637)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 880, 37622, 37637)[j], double[].class, 880, 37622, 37640);
                                    aki = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 880, 37622, 37637)[j], double[].class, 880, 37622, 37640)[CallChecker.isCalled(permutation, int[].class, 880, 37642, 37652)[i]];
                                    CallChecker.varAssign(aki, "aki", 880, 37622, 37637);
                                }
                            }
                        }
                        norm2 += aki * aki;
                        CallChecker.varAssign(norm2, "norm2", 881, 37679, 37697);
                    }
                    if ((Double.isInfinite(norm2)) || (Double.isNaN(norm2))) {
                        throw new ConvergenceException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, nR, nC);
                    }
                    if (norm2 > ak2) {
                        nextColumn = i;
                        CallChecker.varAssign(nextColumn, "nextColumn", 888, 38037, 38051);
                        ak2 = norm2;
                        CallChecker.varAssign(ak2, "ak2", 889, 38073, 38091);
                    }
                }
                if (ak2 <= (qrRankingThreshold)) {
                    rank = k;
                    CallChecker.varAssign(this.rank, "this.rank", 893, 38186, 38194);
                    return ;
                }
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 896, 38272, 38282)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 896, 38272, 38282);
                    pk = CallChecker.isCalled(permutation, int[].class, 896, 38272, 38282)[nextColumn];
                    CallChecker.varAssign(pk, "pk", 896, 38272, 38282);
                }
                if (CallChecker.beforeDeref(permutation, int[].class, 897, 38309, 38319)) {
                    if (CallChecker.beforeDeref(permutation, int[].class, 897, 38335, 38345)) {
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 897, 38309, 38319);
                        permutation = CallChecker.beforeCalled(permutation, int[].class, 897, 38335, 38345);
                        CallChecker.isCalled(permutation, int[].class, 897, 38309, 38319)[nextColumn] = CallChecker.isCalled(permutation, int[].class, 897, 38335, 38345)[k];
                        CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 897, 38309, 38319)[nextColumn], "CallChecker.isCalled(this.permutation, int[].class, 897, 38309, 38319)[nextColumn]", 897, 38309, 38349);
                    }
                }
                if (CallChecker.beforeDeref(permutation, int[].class, 898, 38363, 38373)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 898, 38363, 38373);
                    CallChecker.isCalled(permutation, int[].class, 898, 38363, 38373)[k] = pk;
                    CallChecker.varAssign(CallChecker.isCalled(this.permutation, int[].class, 898, 38363, 38373)[k], "CallChecker.isCalled(this.permutation, int[].class, 898, 38363, 38373)[k]", 898, 38363, 38391);
                }
                double akk = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 901, 38475, 38490)) {
                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 901, 38475, 38490);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 901, 38475, 38490)[k], double[].class, 901, 38475, 38493)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 901, 38475, 38490);
                        CallChecker.isCalled(weightedJacobian, double[][].class, 901, 38475, 38490)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 901, 38475, 38490)[k], double[].class, 901, 38475, 38493);
                        akk = CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 901, 38475, 38490)[k], double[].class, 901, 38475, 38493)[pk];
                        CallChecker.varAssign(akk, "akk", 901, 38475, 38490);
                    }
                }
                double alpha = CallChecker.init(double.class);
                if (akk > 0) {
                    alpha = -(FastMath.sqrt(ak2));
                    CallChecker.varAssign(alpha, "alpha", 902, 38527, 38578);
                }else {
                    alpha = FastMath.sqrt(ak2);
                    CallChecker.varAssign(alpha, "alpha", 902, 38527, 38578);
                }
                double betak = CallChecker.varInit(((double) (1.0 / (ak2 - (akk * alpha)))), "betak", 903, 38593, 38633);
                if (CallChecker.beforeDeref(beta, double[].class, 904, 38647, 38650)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 904, 38647, 38650);
                    CallChecker.isCalled(beta, double[].class, 904, 38647, 38650)[pk] = betak;
                    CallChecker.varAssign(CallChecker.isCalled(this.beta, double[].class, 904, 38647, 38650)[pk], "CallChecker.isCalled(this.beta, double[].class, 904, 38647, 38650)[pk]", 904, 38647, 38667);
                }
                if (CallChecker.beforeDeref(diagR, double[].class, 907, 38726, 38730)) {
                    diagR = CallChecker.beforeCalled(diagR, double[].class, 907, 38726, 38730);
                    CallChecker.isCalled(diagR, double[].class, 907, 38726, 38730)[pk] = alpha;
                    CallChecker.varAssign(CallChecker.isCalled(this.diagR, double[].class, 907, 38726, 38730)[pk], "CallChecker.isCalled(this.diagR, double[].class, 907, 38726, 38730)[pk]", 907, 38726, 38750);
                }
                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 908, 38764, 38779)) {
                    weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 908, 38764, 38779);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 908, 38764, 38779)[k], double[].class, 908, 38764, 38782)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 908, 38764, 38779);
                        CallChecker.isCalled(weightedJacobian, double[][].class, 908, 38764, 38779)[k] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 908, 38764, 38779)[k], double[].class, 908, 38764, 38782);
                        CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 908, 38764, 38779)[k], double[].class, 908, 38764, 38782)[pk] -= alpha;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 908, 38764, 38779)[k], double[].class, 908, 38764, 38782)[pk], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 908, 38764, 38779)[k], double[].class, 908, 38764, 38782)[pk]", 908, 38764, 38796);
                    }
                }
                for (int dk = (nC - 1) - k; dk > 0; --dk) {
                    double gamma = CallChecker.varInit(((double) (0)), "gamma", 912, 38916, 38932);
                    for (int j = k; j < nR; ++j) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 914, 39010, 39025)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 914, 39010, 39025);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39010, 39025)[j], double[].class, 914, 39010, 39028)) {
                                if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 914, 39036, 39051)) {
                                    if (CallChecker.beforeDeref(permutation, int[].class, 914, 39056, 39066)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 914, 39036, 39051);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39036, 39051)[j], double[].class, 914, 39036, 39054)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 914, 39010, 39025);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39010, 39025)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39010, 39025)[j], double[].class, 914, 39010, 39028);
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 914, 39036, 39051);
                                            permutation = CallChecker.beforeCalled(permutation, int[].class, 914, 39056, 39066);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39036, 39051)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39036, 39051)[j], double[].class, 914, 39036, 39054);
                                            gamma += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39010, 39025)[j], double[].class, 914, 39010, 39028)[pk]) * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 914, 39036, 39051)[j], double[].class, 914, 39036, 39054)[CallChecker.isCalled(permutation, int[].class, 914, 39056, 39066)[(k + dk)]]);
                                            CallChecker.varAssign(gamma, "gamma", 914, 39001, 39076);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    gamma *= betak;
                    CallChecker.varAssign(gamma, "gamma", 916, 39112, 39126);
                    for (int j = k; j < nR; ++j) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 918, 39195, 39210)) {
                            if (CallChecker.beforeDeref(permutation, int[].class, 918, 39215, 39225)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 918, 39195, 39210);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39195, 39210)[j], double[].class, 918, 39195, 39213)) {
                                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 918, 39247, 39262)) {
                                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 918, 39247, 39262);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39247, 39262)[j], double[].class, 918, 39247, 39265)) {
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 918, 39195, 39210);
                                            permutation = CallChecker.beforeCalled(permutation, int[].class, 918, 39215, 39225);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39195, 39210)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39195, 39210)[j], double[].class, 918, 39195, 39213);
                                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 918, 39247, 39262);
                                            CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39247, 39262)[j] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39247, 39262)[j], double[].class, 918, 39247, 39265);
                                            CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39195, 39210)[j], double[].class, 918, 39195, 39213)[CallChecker.isCalled(permutation, int[].class, 918, 39215, 39225)[(k + dk)]] -= gamma * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 918, 39247, 39262)[j], double[].class, 918, 39247, 39265)[pk]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 918, 39195, 39210)[j], double[].class, 918, 39195, 39213)[CallChecker.isCalled(this.permutation, int[].class, 918, 39215, 39225)[(k + dk)]], "CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 918, 39195, 39210)[j], double[].class, 918, 39195, 39213)[CallChecker.isCalled(this.permutation, int[].class, 918, 39215, 39225)[(k + dk)]]", 918, 39195, 39270);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            rank = solvedCols;
            CallChecker.varAssign(this.rank, "this.rank", 922, 39322, 39339);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2584.methodEnd();
        }
    }

    private void qTy(double[] y) {
        MethodContext _bcornu_methode_context2585 = new MethodContext(void.class, 930, 39352, 40019);
        try {
            CallChecker.varInit(this, "this", 930, 39352, 40019);
            CallChecker.varInit(y, "y", 930, 39352, 40019);
            CallChecker.varInit(this.iterations, "iterations", 930, 39352, 40019);
            CallChecker.varInit(this.evaluations, "evaluations", 930, 39352, 40019);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 930, 39352, 40019);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 930, 39352, 40019);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 930, 39352, 40019);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 930, 39352, 40019);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 930, 39352, 40019);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 930, 39352, 40019);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 930, 39352, 40019);
            CallChecker.varInit(this.lmDir, "lmDir", 930, 39352, 40019);
            CallChecker.varInit(this.lmPar, "lmPar", 930, 39352, 40019);
            CallChecker.varInit(this.rank, "rank", 930, 39352, 40019);
            CallChecker.varInit(this.permutation, "permutation", 930, 39352, 40019);
            CallChecker.varInit(this.beta, "beta", 930, 39352, 40019);
            CallChecker.varInit(this.jacNorm, "jacNorm", 930, 39352, 40019);
            CallChecker.varInit(this.diagR, "diagR", 930, 39352, 40019);
            CallChecker.varInit(this.solvedCols, "solvedCols", 930, 39352, 40019);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 930, 39352, 40019);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 931, 39563, 39578);
            final int nR = CallChecker.varInit(((int) (CallChecker.isCalled(this.weightedJacobian, double[][].class, 931, 39563, 39578).length)), "nR", 931, 39548, 39586);
            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 932, 39611, 39626);
            CallChecker.isCalled(weightedJacobian, double[][].class, 932, 39611, 39626)[0] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 932, 39611, 39626)[0], double[].class, 932, 39611, 39629);
            final int nC = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.weightedJacobian, double[][].class, 932, 39611, 39626)[0], double[].class, 932, 39611, 39629).length)), "nC", 932, 39596, 39637);
            for (int k = 0; k < nC; ++k) {
                int pk = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(permutation, int[].class, 935, 39700, 39710)) {
                    permutation = CallChecker.beforeCalled(permutation, int[].class, 935, 39700, 39710);
                    pk = CallChecker.isCalled(permutation, int[].class, 935, 39700, 39710)[k];
                    CallChecker.varAssign(pk, "pk", 935, 39700, 39710);
                }
                double gamma = CallChecker.varInit(((double) (0)), "gamma", 936, 39728, 39744);
                for (int i = k; i < nR; ++i) {
                    if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 938, 39814, 39829)) {
                        weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 938, 39814, 39829);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 938, 39814, 39829)[i], double[].class, 938, 39814, 39832)) {
                            if (CallChecker.beforeDeref(y, double[].class, 938, 39840, 39840)) {
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 938, 39814, 39829);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 938, 39814, 39829)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 938, 39814, 39829)[i], double[].class, 938, 39814, 39832);
                                y = CallChecker.beforeCalled(y, double[].class, 938, 39840, 39840);
                                gamma += (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 938, 39814, 39829)[i], double[].class, 938, 39814, 39832)[pk]) * (CallChecker.isCalled(y, double[].class, 938, 39840, 39840)[i]);
                                CallChecker.varAssign(gamma, "gamma", 938, 39805, 39844);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(beta, double[].class, 940, 39881, 39884)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 940, 39881, 39884);
                    gamma *= CallChecker.isCalled(beta, double[].class, 940, 39881, 39884)[pk];
                    CallChecker.varAssign(gamma, "gamma", 940, 39872, 39889);
                }
                for (int i = k; i < nR; ++i) {
                    if (CallChecker.beforeDeref(y, double[].class, 942, 39950, 39950)) {
                        if (CallChecker.beforeDeref(weightedJacobian, double[][].class, 942, 39966, 39981)) {
                            weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 942, 39966, 39981);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(weightedJacobian, double[][].class, 942, 39966, 39981)[i], double[].class, 942, 39966, 39984)) {
                                y = CallChecker.beforeCalled(y, double[].class, 942, 39950, 39950);
                                weightedJacobian = CallChecker.beforeCalled(weightedJacobian, double[][].class, 942, 39966, 39981);
                                CallChecker.isCalled(weightedJacobian, double[][].class, 942, 39966, 39981)[i] = CallChecker.beforeCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 942, 39966, 39981)[i], double[].class, 942, 39966, 39984);
                                CallChecker.isCalled(y, double[].class, 942, 39950, 39950)[i] -= gamma * (CallChecker.isCalled(CallChecker.isCalled(weightedJacobian, double[][].class, 942, 39966, 39981)[i], double[].class, 942, 39966, 39984)[pk]);
                                CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 942, 39950, 39950)[i], "CallChecker.isCalled(y, double[].class, 942, 39950, 39950)[i]", 942, 39950, 39989);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2585.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context2586 = new MethodContext(void.class, 951, 40026, 40393);
        try {
            CallChecker.varInit(this, "this", 951, 40026, 40393);
            CallChecker.varInit(this.iterations, "iterations", 951, 40026, 40393);
            CallChecker.varInit(this.evaluations, "evaluations", 951, 40026, 40393);
            CallChecker.varInit(this.weightedJacobian, "weightedJacobian", 951, 40026, 40393);
            CallChecker.varInit(this.weightedResidual, "weightedResidual", 951, 40026, 40393);
            CallChecker.varInit(this.qrRankingThreshold, "qrRankingThreshold", 951, 40026, 40393);
            CallChecker.varInit(this.orthoTolerance, "orthoTolerance", 951, 40026, 40393);
            CallChecker.varInit(this.parRelativeTolerance, "parRelativeTolerance", 951, 40026, 40393);
            CallChecker.varInit(this.costRelativeTolerance, "costRelativeTolerance", 951, 40026, 40393);
            CallChecker.varInit(this.initialStepBoundFactor, "initialStepBoundFactor", 951, 40026, 40393);
            CallChecker.varInit(this.lmDir, "lmDir", 951, 40026, 40393);
            CallChecker.varInit(this.lmPar, "lmPar", 951, 40026, 40393);
            CallChecker.varInit(this.rank, "rank", 951, 40026, 40393);
            CallChecker.varInit(this.permutation, "permutation", 951, 40026, 40393);
            CallChecker.varInit(this.beta, "beta", 951, 40026, 40393);
            CallChecker.varInit(this.jacNorm, "jacNorm", 951, 40026, 40393);
            CallChecker.varInit(this.diagR, "diagR", 951, 40026, 40393);
            CallChecker.varInit(this.solvedCols, "solvedCols", 951, 40026, 40393);
            CallChecker.varInit(TWO_EPS, "org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer.TWO_EPS", 951, 40026, 40393);
            if (((getLowerBound()) != null) || ((getUpperBound()) != null)) {
                throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2586.methodEnd();
        }
    }
}

