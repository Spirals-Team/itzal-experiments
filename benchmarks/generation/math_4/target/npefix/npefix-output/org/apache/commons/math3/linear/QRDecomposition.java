package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

public class QRDecomposition {
    private static class Solver implements DecompositionSolver {
        private final double[][] qrt;

        private final double[] rDiag;

        private final double threshold;

        private Solver(final double[][] qrt, final double[] rDiag, final double threshold) {
            ConstructorContext _bcornu_methode_context838 = new ConstructorContext(QRDecomposition.Solver.class, 321, 11374, 11879);
            try {
                this.qrt = qrt;
                CallChecker.varAssign(this.qrt, "this.qrt", 324, 11781, 11797);
                this.rDiag = rDiag;
                CallChecker.varAssign(this.rDiag, "this.rDiag", 325, 11811, 11829);
                this.threshold = threshold;
                CallChecker.varAssign(this.threshold, "this.threshold", 326, 11843, 11869);
            } finally {
                _bcornu_methode_context838.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context3654 = new MethodContext(boolean.class, 330, 11890, 12146);
            try {
                CallChecker.varInit(this, "this", 330, 11890, 12146);
                CallChecker.varInit(this.threshold, "threshold", 330, 11890, 12146);
                CallChecker.varInit(this.rDiag, "rDiag", 330, 11890, 12146);
                CallChecker.varInit(this.qrt, "qrt", 330, 11890, 12146);
                if (CallChecker.beforeDeref(rDiag, boolean.class, 331, 11983, 11987)) {
                    for (double diag : rDiag) {
                        if ((FastMath.abs(diag)) <= (threshold)) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3654.methodEnd();
            }
        }

        public RealVector solve(RealVector b) {
            MethodContext _bcornu_methode_context3655 = new MethodContext(RealVector.class, 340, 12157, 13657);
            try {
                CallChecker.varInit(this, "this", 340, 12157, 13657);
                CallChecker.varInit(b, "b", 340, 12157, 13657);
                CallChecker.varInit(this.threshold, "threshold", 340, 12157, 13657);
                CallChecker.varInit(this.rDiag, "rDiag", 340, 12157, 13657);
                CallChecker.varInit(this.qrt, "qrt", 340, 12157, 13657);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.qrt, double[][].class, 341, 12252, 12254).length)), "n", 341, 12238, 12262);
                CallChecker.isCalled(qrt, double[][].class, 342, 12290, 12292)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 342, 12290, 12292)[0], double[].class, 342, 12290, 12295);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qrt, double[][].class, 342, 12290, 12292)[0], double[].class, 342, 12290, 12295).length)), "m", 342, 12276, 12303);
                if (CallChecker.beforeDeref(b, RealVector.class, 343, 12321, 12321)) {
                    b = CallChecker.beforeCalled(b, RealVector.class, 343, 12321, 12321);
                    if ((CallChecker.isCalled(b, RealVector.class, 343, 12321, 12321).getDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealVector.class, 344, 12399, 12399)) {
                            b = CallChecker.beforeCalled(b, RealVector.class, 344, 12399, 12399);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealVector.class, 344, 12399, 12399).getDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (!(isNonSingular())) {
                    throw new SingularMatrixException();
                }
                final double[] x = CallChecker.varInit(new double[n], "x", 350, 12551, 12583);
                b = CallChecker.beforeCalled(b, RealVector.class, 351, 12616, 12616);
                final double[] y = CallChecker.varInit(CallChecker.isCalled(b, RealVector.class, 351, 12616, 12616).toArray(), "y", 351, 12597, 12627);
                for (int minor = 0; minor < (FastMath.min(m, n)); minor++) {
                    final double[] qrtMinor = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 356, 12805, 12807)[minor], "qrtMinor", 356, 12779, 12815);
                    double dotProduct = CallChecker.varInit(((double) (0)), "dotProduct", 357, 12833, 12854);
                    for (int row = minor; row < m; row++) {
                        if (CallChecker.beforeDeref(y, double[].class, 359, 12946, 12946)) {
                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 359, 12955, 12962)) {
                                dotProduct += (CallChecker.isCalled(y, double[].class, 359, 12946, 12946)[row]) * (CallChecker.isCalled(qrtMinor, double[].class, 359, 12955, 12962)[row]);
                                CallChecker.varAssign(dotProduct, "dotProduct", 359, 12932, 12968);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(rDiag, double[].class, 361, 13018, 13022)) {
                        if (CallChecker.beforeDeref(qrtMinor, double[].class, 361, 13033, 13040)) {
                            dotProduct /= (CallChecker.isCalled(rDiag, double[].class, 361, 13018, 13022)[minor]) * (CallChecker.isCalled(qrtMinor, double[].class, 361, 13033, 13040)[minor]);
                            CallChecker.varAssign(dotProduct, "dotProduct", 361, 13004, 13048);
                        }
                    }
                    for (int row = minor; row < m; row++) {
                        if (CallChecker.beforeDeref(y, double[].class, 364, 13127, 13127)) {
                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 364, 13150, 13157)) {
                                CallChecker.isCalled(y, double[].class, 364, 13127, 13127)[row] += dotProduct * (CallChecker.isCalled(qrtMinor, double[].class, 364, 13150, 13157)[row]);
                                CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 364, 13127, 13127)[row], "CallChecker.isCalled(y, double[].class, 364, 13127, 13127)[row]", 364, 13127, 13163);
                            }
                        }
                    }
                }
                for (int row = (CallChecker.isCalled(rDiag, double[].class, 369, 13272, 13276).length) - 1; row >= 0; --row) {
                    if (CallChecker.beforeDeref(y, double[].class, 370, 13325, 13325)) {
                        if (CallChecker.beforeDeref(rDiag, double[].class, 370, 13335, 13339)) {
                            CallChecker.isCalled(y, double[].class, 370, 13325, 13325)[row] /= CallChecker.isCalled(rDiag, double[].class, 370, 13335, 13339)[row];
                            CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 370, 13325, 13325)[row], "CallChecker.isCalled(y, double[].class, 370, 13325, 13325)[row]", 370, 13325, 13345);
                        }
                    }
                    final double yRow = CallChecker.varInit(((double) (CallChecker.isCalled(y, double[].class, 371, 13383, 13383)[row])), "yRow", 371, 13363, 13389);
                    final double[] qrtRow = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 372, 13431, 13433)[row], "qrtRow", 372, 13407, 13439);
                    if (CallChecker.beforeDeref(x, double[].class, 373, 13457, 13457)) {
                        CallChecker.isCalled(x, double[].class, 373, 13457, 13457)[row] = yRow;
                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 373, 13457, 13457)[row], "CallChecker.isCalled(x, double[].class, 373, 13457, 13457)[row]", 373, 13457, 13470);
                    }
                    for (int i = 0; i < row; i++) {
                        if (CallChecker.beforeDeref(y, double[].class, 375, 13540, 13540)) {
                            if (CallChecker.beforeDeref(qrtRow, double[].class, 375, 13555, 13560)) {
                                CallChecker.isCalled(y, double[].class, 375, 13540, 13540)[i] -= yRow * (CallChecker.isCalled(qrtRow, double[].class, 375, 13555, 13560)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 375, 13540, 13540)[i], "CallChecker.isCalled(y, double[].class, 375, 13540, 13540)[i]", 375, 13540, 13564);
                            }
                        }
                    }
                }
                return new ArrayRealVector(x, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3655.methodEnd();
            }
        }

        public RealMatrix solve(RealMatrix b) {
            MethodContext _bcornu_methode_context3656 = new MethodContext(RealMatrix.class, 383, 13668, 17138);
            try {
                CallChecker.varInit(this, "this", 383, 13668, 17138);
                CallChecker.varInit(b, "b", 383, 13668, 17138);
                CallChecker.varInit(this.threshold, "threshold", 383, 13668, 17138);
                CallChecker.varInit(this.rDiag, "rDiag", 383, 13668, 17138);
                CallChecker.varInit(this.qrt, "qrt", 383, 13668, 17138);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.qrt, double[][].class, 384, 13763, 13765).length)), "n", 384, 13749, 13773);
                CallChecker.isCalled(qrt, double[][].class, 385, 13801, 13803)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 385, 13801, 13803)[0], double[].class, 385, 13801, 13806);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qrt, double[][].class, 385, 13801, 13803)[0], double[].class, 385, 13801, 13806).length)), "m", 385, 13787, 13814);
                if (CallChecker.beforeDeref(b, RealMatrix.class, 386, 13832, 13832)) {
                    b = CallChecker.beforeCalled(b, RealMatrix.class, 386, 13832, 13832);
                    if ((CallChecker.isCalled(b, RealMatrix.class, 386, 13832, 13832).getRowDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealMatrix.class, 387, 13913, 13913)) {
                            b = CallChecker.beforeCalled(b, RealMatrix.class, 387, 13913, 13913);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealMatrix.class, 387, 13913, 13913).getRowDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (!(isNonSingular())) {
                    throw new SingularMatrixException();
                }
                b = CallChecker.beforeCalled(b, RealMatrix.class, 393, 14095, 14095);
                final int columns = CallChecker.varInit(((int) (CallChecker.isCalled(b, RealMatrix.class, 393, 14095, 14095).getColumnDimension())), "columns", 393, 14068, 14117);
                final int blockSize = CallChecker.varInit(((int) (BlockRealMatrix.BLOCK_SIZE)), "blockSize", 394, 14131, 14184);
                final int cBlocks = CallChecker.varInit(((int) (((columns + blockSize) - 1) / blockSize)), "cBlocks", 395, 14198, 14262);
                final double[][] xBlocks = CallChecker.varInit(BlockRealMatrix.createBlocksLayout(n, columns), "xBlocks", 396, 14276, 14349);
                b = CallChecker.beforeCalled(b, RealMatrix.class, 397, 14401, 14401);
                final double[][] y = CallChecker.varInit(new double[CallChecker.isCalled(b, RealMatrix.class, 397, 14401, 14401).getRowDimension()][blockSize], "y", 397, 14363, 14432);
                final double[] alpha = CallChecker.varInit(new double[blockSize], "alpha", 398, 14446, 14494);
                for (int kBlock = 0; kBlock < cBlocks; ++kBlock) {
                    final int kStart = CallChecker.varInit(((int) (kBlock * blockSize)), "kStart", 401, 14576, 14613);
                    final int kEnd = CallChecker.varInit(((int) (FastMath.min((kStart + blockSize), columns))), "kEnd", 402, 14631, 14691);
                    final int kWidth = CallChecker.varInit(((int) (kEnd - kStart)), "kWidth", 403, 14709, 14741);
                    if (CallChecker.beforeDeref(b, RealMatrix.class, 406, 14810, 14810)) {
                        b = CallChecker.beforeCalled(b, RealMatrix.class, 406, 14810, 14810);
                        CallChecker.isCalled(b, RealMatrix.class, 406, 14810, 14810).copySubMatrix(0, (m - 1), kStart, (kEnd - 1), y);
                    }
                    for (int minor = 0; minor < (FastMath.min(m, n)); minor++) {
                        final double[] qrtMinor = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 410, 15045, 15047)[minor], "qrtMinor", 410, 15019, 15055);
                        final double factor = CallChecker.varInit(((double) (1.0 / ((CallChecker.isCalled(this.rDiag, double[].class, 411, 15110, 15114)[minor]) * (CallChecker.isCalled(qrtMinor, double[].class, 411, 15125, 15132)[minor])))), "factor", 411, 15077, 15141);
                        Arrays.fill(alpha, 0, kWidth, 0.0);
                        for (int row = minor; row < m; ++row) {
                            final double d = CallChecker.varInit(((double) (CallChecker.isCalled(qrtMinor, double[].class, 415, 15306, 15313)[row])), "d", 415, 15284, 15319);
                            final double[] yRow = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 416, 15367, 15367)[row], "yRow", 416, 15345, 15373);
                            for (int k = 0; k < kWidth; ++k) {
                                if (CallChecker.beforeDeref(alpha, double[].class, 418, 15462, 15466)) {
                                    if (CallChecker.beforeDeref(yRow, double[].class, 418, 15478, 15481)) {
                                        CallChecker.isCalled(alpha, double[].class, 418, 15462, 15466)[k] += d * (CallChecker.isCalled(yRow, double[].class, 418, 15478, 15481)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(alpha, double[].class, 418, 15462, 15466)[k], "CallChecker.isCalled(alpha, double[].class, 418, 15462, 15466)[k]", 418, 15462, 15485);
                                    }
                                }
                            }
                        }
                        for (int k = 0; k < kWidth; ++k) {
                            if (CallChecker.beforeDeref(alpha, double[].class, 422, 15614, 15618)) {
                                CallChecker.isCalled(alpha, double[].class, 422, 15614, 15618)[k] *= factor;
                                CallChecker.varAssign(CallChecker.isCalled(alpha, double[].class, 422, 15614, 15618)[k], "CallChecker.isCalled(alpha, double[].class, 422, 15614, 15618)[k]", 422, 15614, 15632);
                            }
                        }
                        for (int row = minor; row < m; ++row) {
                            final double d = CallChecker.varInit(((double) (CallChecker.isCalled(qrtMinor, double[].class, 426, 15763, 15770)[row])), "d", 426, 15741, 15776);
                            final double[] yRow = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 427, 15824, 15824)[row], "yRow", 427, 15802, 15830);
                            for (int k = 0; k < kWidth; ++k) {
                                if (CallChecker.beforeDeref(yRow, double[].class, 429, 15919, 15922)) {
                                    if (CallChecker.beforeDeref(alpha, double[].class, 429, 15930, 15934)) {
                                        CallChecker.isCalled(yRow, double[].class, 429, 15919, 15922)[k] += (CallChecker.isCalled(alpha, double[].class, 429, 15930, 15934)[k]) * d;
                                        CallChecker.varAssign(CallChecker.isCalled(yRow, double[].class, 429, 15919, 15922)[k], "CallChecker.isCalled(yRow, double[].class, 429, 15919, 15922)[k]", 429, 15919, 15942);
                                    }
                                }
                            }
                        }
                    }
                    for (int j = (CallChecker.isCalled(rDiag, double[].class, 435, 16091, 16095).length) - 1; j >= 0; --j) {
                        final int jBlock = CallChecker.varInit(((int) (j / blockSize)), "jBlock", 436, 16144, 16181);
                        final int jStart = CallChecker.varInit(((int) (jBlock * blockSize)), "jStart", 437, 16203, 16245);
                        final double factor = CallChecker.varInit(((double) (1.0 / (CallChecker.isCalled(this.rDiag, double[].class, 438, 16297, 16301)[j]))), "factor", 438, 16267, 16305);
                        final double[] yJ = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 439, 16351, 16351)[j], "yJ", 439, 16327, 16355);
                        final double[] xBlock = CallChecker.varInit(CallChecker.isCalled(xBlocks, double[][].class, 440, 16401, 16407)[((jBlock * cBlocks) + kBlock)], "xBlock", 440, 16377, 16435);
                        int index = CallChecker.varInit(((int) ((j - jStart) * kWidth)), "index", 441, 16457, 16490);
                        for (int k = 0; k < kWidth; ++k) {
                            if (CallChecker.beforeDeref(yJ, double[].class, 443, 16571, 16572)) {
                                CallChecker.isCalled(yJ, double[].class, 443, 16571, 16572)[k] *= factor;
                                CallChecker.varAssign(CallChecker.isCalled(yJ, double[].class, 443, 16571, 16572)[k], "CallChecker.isCalled(yJ, double[].class, 443, 16571, 16572)[k]", 443, 16571, 16595);
                            }
                            if (CallChecker.beforeDeref(xBlock, double[].class, 444, 16621, 16626)) {
                                if (CallChecker.beforeDeref(yJ, double[].class, 444, 16639, 16640)) {
                                    CallChecker.isCalled(xBlock, double[].class, 444, 16621, 16626)[(index++)] = CallChecker.isCalled(yJ, double[].class, 444, 16639, 16640)[k];
                                    CallChecker.varAssign(CallChecker.isCalled(xBlock, double[].class, 444, 16621, 16626)[(index - 1)], "CallChecker.isCalled(xBlock, double[].class, 444, 16621, 16626)[(index - 1)]", 444, 16621, 16644);
                                }
                            }
                        }
                        final double[] qrtJ = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 447, 16711, 16713)[j], "qrtJ", 447, 16689, 16717);
                        for (int i = 0; i < j; ++i) {
                            final double rIJ = CallChecker.varInit(((double) (CallChecker.isCalled(qrtJ, double[].class, 449, 16813, 16816)[i])), "rIJ", 449, 16793, 16820);
                            final double[] yI = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 450, 16866, 16866)[i], "yI", 450, 16846, 16870);
                            for (int k = 0; k < kWidth; ++k) {
                                if (CallChecker.beforeDeref(yI, double[].class, 452, 16959, 16960)) {
                                    if (CallChecker.beforeDeref(yJ, double[].class, 452, 16968, 16969)) {
                                        CallChecker.isCalled(yI, double[].class, 452, 16959, 16960)[k] -= (CallChecker.isCalled(yJ, double[].class, 452, 16968, 16969)[k]) * rIJ;
                                        CallChecker.varAssign(CallChecker.isCalled(yI, double[].class, 452, 16959, 16960)[k], "CallChecker.isCalled(yI, double[].class, 452, 16959, 16960)[k]", 452, 16959, 16979);
                                    }
                                }
                            }
                        }
                    }
                }
                return new BlockRealMatrix(n, columns, xBlocks, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3656.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context3657 = new MethodContext(RealMatrix.class, 462, 17149, 17297);
            try {
                CallChecker.varInit(this, "this", 462, 17149, 17297);
                CallChecker.varInit(this.threshold, "threshold", 462, 17149, 17297);
                CallChecker.varInit(this.rDiag, "rDiag", 462, 17149, 17297);
                CallChecker.varInit(this.qrt, "qrt", 462, 17149, 17297);
                if (CallChecker.beforeDeref(rDiag, double[].class, 463, 17273, 17277)) {
                    return solve(MatrixUtils.createRealIdentityMatrix(CallChecker.isCalled(rDiag, double[].class, 463, 17273, 17277).length));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3657.methodEnd();
            }
        }
    }

    private double[][] qrt;

    private double[] rDiag;

    private RealMatrix cachedQ;

    private RealMatrix cachedQT;

    private RealMatrix cachedR;

    private RealMatrix cachedH;

    private final double threshold;

    public QRDecomposition(RealMatrix matrix) {
        this(matrix, 0.0);
        ConstructorContext _bcornu_methode_context839 = new ConstructorContext(QRDecomposition.class, 80, 3003, 3312);
        try {
        } finally {
            _bcornu_methode_context839.methodEnd();
        }
    }

    public QRDecomposition(RealMatrix matrix, double threshold) {
        ConstructorContext _bcornu_methode_context840 = new ConstructorContext(QRDecomposition.class, 90, 3319, 3942);
        try {
            this.threshold = threshold;
            CallChecker.varAssign(this.threshold, "this.threshold", 92, 3592, 3618);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 94, 3643, 3648);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 94, 3643, 3648).getRowDimension())), "m", 94, 3629, 3667);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 95, 3691, 3696);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 95, 3691, 3696).getColumnDimension())), "n", 95, 3677, 3718);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 96, 3734, 3739)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 96, 3734, 3739);
                final RealMatrix npe_invocation_var818 = CallChecker.isCalled(matrix, RealMatrix.class, 96, 3734, 3739).transpose();
                if (CallChecker.beforeDeref(npe_invocation_var818, RealMatrix.class, 96, 3734, 3751)) {
                    qrt = CallChecker.isCalled(npe_invocation_var818, RealMatrix.class, 96, 3734, 3751).getData();
                    CallChecker.varAssign(this.qrt, "this.qrt", 96, 3728, 3762);
                }
            }
            rDiag = new double[FastMath.min(m, n)];
            CallChecker.varAssign(this.rDiag, "this.rDiag", 97, 3772, 3810);
            cachedQ = null;
            CallChecker.varAssign(this.cachedQ, "this.cachedQ", 98, 3820, 3835);
            cachedQT = null;
            CallChecker.varAssign(this.cachedQT, "this.cachedQT", 99, 3845, 3860);
            cachedR = null;
            CallChecker.varAssign(this.cachedR, "this.cachedR", 100, 3870, 3885);
            cachedH = null;
            CallChecker.varAssign(this.cachedH, "this.cachedH", 101, 3895, 3910);
            decompose(qrt);
        } finally {
            _bcornu_methode_context840.methodEnd();
        }
    }

    protected void decompose(double[][] matrix) {
        MethodContext _bcornu_methode_context3658 = new MethodContext(void.class, 111, 3949, 4242);
        try {
            CallChecker.varInit(this, "this", 111, 3949, 4242);
            CallChecker.varInit(matrix, "matrix", 111, 3949, 4242);
            CallChecker.varInit(this.threshold, "threshold", 111, 3949, 4242);
            CallChecker.varInit(this.cachedH, "cachedH", 111, 3949, 4242);
            CallChecker.varInit(this.cachedR, "cachedR", 111, 3949, 4242);
            CallChecker.varInit(this.cachedQT, "cachedQT", 111, 3949, 4242);
            CallChecker.varInit(this.cachedQ, "cachedQ", 111, 3949, 4242);
            CallChecker.varInit(this.rDiag, "rDiag", 111, 3949, 4242);
            CallChecker.varInit(this.qrt, "qrt", 111, 3949, 4242);
            qrt = CallChecker.beforeCalled(qrt, double[][].class, 112, 4135, 4137);
            qrt = CallChecker.beforeCalled(qrt, double[][].class, 112, 4147, 4149);
            CallChecker.isCalled(qrt, double[][].class, 112, 4147, 4149)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 112, 4147, 4149)[0], double[].class, 112, 4147, 4152);
            for (int minor = 0; minor < (FastMath.min(CallChecker.isCalled(qrt, double[][].class, 112, 4135, 4137).length, CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 112, 4147, 4149)[0], double[].class, 112, 4147, 4152).length)); minor++) {
                performHouseholderReflection(minor, qrt);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3658.methodEnd();
        }
    }

    protected void performHouseholderReflection(int minor, double[][] matrix) {
        MethodContext _bcornu_methode_context3659 = new MethodContext(void.class, 122, 4249, 6887);
        try {
            CallChecker.varInit(this, "this", 122, 4249, 6887);
            CallChecker.varInit(matrix, "matrix", 122, 4249, 6887);
            CallChecker.varInit(minor, "minor", 122, 4249, 6887);
            CallChecker.varInit(this.threshold, "threshold", 122, 4249, 6887);
            CallChecker.varInit(this.cachedH, "cachedH", 122, 4249, 6887);
            CallChecker.varInit(this.cachedR, "cachedR", 122, 4249, 6887);
            CallChecker.varInit(this.cachedQT, "cachedQT", 122, 4249, 6887);
            CallChecker.varInit(this.cachedQ, "cachedQ", 122, 4249, 6887);
            CallChecker.varInit(this.rDiag, "rDiag", 122, 4249, 6887);
            CallChecker.varInit(this.qrt, "qrt", 122, 4249, 6887);
            qrt = CallChecker.beforeCalled(qrt, double[][].class, 124, 4530, 4532);
            final double[] qrtMinor = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 124, 4530, 4532)[minor], "qrtMinor", 124, 4504, 4540);
            double xNormSqr = CallChecker.varInit(((double) (0)), "xNormSqr", 133, 4908, 4927);
            for (int row = minor; row < (CallChecker.isCalled(qrtMinor, double[].class, 134, 4965, 4972).length); row++) {
                final double c = CallChecker.varInit(((double) (CallChecker.isCalled(qrtMinor, double[].class, 135, 5020, 5027)[row])), "c", 135, 5003, 5033);
                xNormSqr += c * c;
                CallChecker.varAssign(xNormSqr, "xNormSqr", 136, 5047, 5064);
            }
            double a = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(qrtMinor, double[].class, 138, 5102, 5109)) {
                if ((CallChecker.isCalled(qrtMinor, double[].class, 138, 5102, 5109)[minor]) > 0) {
                    a = -(FastMath.sqrt(xNormSqr));
                    CallChecker.varAssign(a, "a", 138, 5101, 5174);
                }else {
                    a = FastMath.sqrt(xNormSqr);
                    CallChecker.varAssign(a, "a", 138, 5101, 5174);
                }
            }
            if (CallChecker.beforeDeref(rDiag, double[].class, 139, 5185, 5189)) {
                rDiag = CallChecker.beforeCalled(rDiag, double[].class, 139, 5185, 5189);
                CallChecker.isCalled(rDiag, double[].class, 139, 5185, 5189)[minor] = a;
                CallChecker.varAssign(CallChecker.isCalled(this.rDiag, double[].class, 139, 5185, 5189)[minor], "CallChecker.isCalled(this.rDiag, double[].class, 139, 5185, 5189)[minor]", 139, 5185, 5201);
            }
            if (a != 0.0) {
                if (CallChecker.beforeDeref(qrtMinor, double[].class, 151, 5643, 5650)) {
                    CallChecker.isCalled(qrtMinor, double[].class, 151, 5643, 5650)[minor] -= a;
                    CallChecker.varAssign(CallChecker.isCalled(qrtMinor, double[].class, 151, 5643, 5650)[minor], "CallChecker.isCalled(qrtMinor, double[].class, 151, 5643, 5650)[minor]", 151, 5643, 5663);
                }
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 165, 6357, 6359);
                for (int col = minor + 1; col < (CallChecker.isCalled(qrt, double[][].class, 165, 6357, 6359).length); col++) {
                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 166, 6418, 6420);
                    final double[] qrtCol = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 166, 6418, 6420)[col], "qrtCol", 166, 6394, 6426);
                    double alpha = CallChecker.varInit(((double) (0)), "alpha", 167, 6444, 6460);
                    for (int row = minor; row < (CallChecker.isCalled(qrtCol, double[].class, 168, 6506, 6511).length); row++) {
                        if (CallChecker.beforeDeref(qrtCol, double[].class, 169, 6559, 6564)) {
                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 169, 6573, 6580)) {
                                alpha -= (CallChecker.isCalled(qrtCol, double[].class, 169, 6559, 6564)[row]) * (CallChecker.isCalled(qrtMinor, double[].class, 169, 6573, 6580)[row]);
                                CallChecker.varAssign(alpha, "alpha", 169, 6550, 6586);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(qrtMinor, double[].class, 171, 6635, 6642)) {
                        alpha /= a * (CallChecker.isCalled(qrtMinor, double[].class, 171, 6635, 6642)[minor]);
                        CallChecker.varAssign(alpha, "alpha", 171, 6622, 6650);
                    }
                    for (int row = minor; row < (CallChecker.isCalled(qrtCol, double[].class, 174, 6759, 6764).length); row++) {
                        if (CallChecker.beforeDeref(qrtCol, double[].class, 175, 6803, 6808)) {
                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 175, 6826, 6833)) {
                                CallChecker.isCalled(qrtCol, double[].class, 175, 6803, 6808)[row] -= alpha * (CallChecker.isCalled(qrtMinor, double[].class, 175, 6826, 6833)[row]);
                                CallChecker.varAssign(CallChecker.isCalled(qrtCol, double[].class, 175, 6803, 6808)[row], "CallChecker.isCalled(qrtCol, double[].class, 175, 6803, 6808)[row]", 175, 6803, 6839);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3659.methodEnd();
        }
    }

    public RealMatrix getR() {
        MethodContext _bcornu_methode_context3660 = new MethodContext(RealMatrix.class, 187, 6895, 7718);
        try {
            CallChecker.varInit(this, "this", 187, 6895, 7718);
            CallChecker.varInit(this.threshold, "threshold", 187, 6895, 7718);
            CallChecker.varInit(this.cachedH, "cachedH", 187, 6895, 7718);
            CallChecker.varInit(this.cachedR, "cachedR", 187, 6895, 7718);
            CallChecker.varInit(this.cachedQT, "cachedQT", 187, 6895, 7718);
            CallChecker.varInit(this.cachedQ, "cachedQ", 187, 6895, 7718);
            CallChecker.varInit(this.rDiag, "rDiag", 187, 6895, 7718);
            CallChecker.varInit(this.qrt, "qrt", 187, 6895, 7718);
            if ((cachedR) == null) {
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 192, 7162, 7164);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.qrt, double[][].class, 192, 7162, 7164).length)), "n", 192, 7107, 7172);
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 193, 7200, 7202);
                CallChecker.isCalled(qrt, double[][].class, 193, 7200, 7202)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 193, 7200, 7202)[0], double[].class, 193, 7200, 7205);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qrt, double[][].class, 193, 7200, 7202)[0], double[].class, 193, 7200, 7205).length)), "m", 193, 7186, 7213);
                double[][] ra = CallChecker.varInit(new double[m][n], "ra", 194, 7227, 7259);
                for (int row = (FastMath.min(m, n)) - 1; row >= 0; row--) {
                    if (CallChecker.beforeDeref(ra, double[][].class, 197, 7420, 7421)) {
                        ra = CallChecker.beforeCalled(ra, double[][].class, 197, 7420, 7421);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row], double[].class, 197, 7420, 7426)) {
                            if (CallChecker.beforeDeref(rDiag, double[].class, 197, 7435, 7439)) {
                                ra = CallChecker.beforeCalled(ra, double[][].class, 197, 7420, 7421);
                                CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row] = CallChecker.beforeCalled(CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row], double[].class, 197, 7420, 7426);
                                rDiag = CallChecker.beforeCalled(rDiag, double[].class, 197, 7435, 7439);
                                CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row], double[].class, 197, 7420, 7426)[row] = CallChecker.isCalled(rDiag, double[].class, 197, 7435, 7439)[row];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row], double[].class, 197, 7420, 7426)[row], "CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 197, 7420, 7421)[row], double[].class, 197, 7420, 7426)[row]", 197, 7420, 7445);
                            }
                        }
                    }
                    for (int col = row + 1; col < n; col++) {
                        if (CallChecker.beforeDeref(ra, double[][].class, 199, 7525, 7526)) {
                            ra = CallChecker.beforeCalled(ra, double[][].class, 199, 7525, 7526);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row], double[].class, 199, 7525, 7531)) {
                                if (CallChecker.beforeDeref(qrt, double[][].class, 199, 7540, 7542)) {
                                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 199, 7540, 7542);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(qrt, double[][].class, 199, 7540, 7542)[col], double[].class, 199, 7540, 7547)) {
                                        ra = CallChecker.beforeCalled(ra, double[][].class, 199, 7525, 7526);
                                        CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row] = CallChecker.beforeCalled(CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row], double[].class, 199, 7525, 7531);
                                        qrt = CallChecker.beforeCalled(qrt, double[][].class, 199, 7540, 7542);
                                        CallChecker.isCalled(qrt, double[][].class, 199, 7540, 7542)[col] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 199, 7540, 7542)[col], double[].class, 199, 7540, 7547);
                                        CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row], double[].class, 199, 7525, 7531)[col] = CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 199, 7540, 7542)[col], double[].class, 199, 7540, 7547)[row];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row], double[].class, 199, 7525, 7531)[col], "CallChecker.isCalled(CallChecker.isCalled(ra, double[][].class, 199, 7525, 7526)[row], double[].class, 199, 7525, 7531)[col]", 199, 7525, 7553);
                                    }
                                }
                            }
                        }
                    }
                }
                cachedR = MatrixUtils.createRealMatrix(ra);
                CallChecker.varAssign(this.cachedR, "this.cachedR", 202, 7599, 7641);
            }
            return cachedR;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3660.methodEnd();
        }
    }

    public RealMatrix getQ() {
        MethodContext _bcornu_methode_context3661 = new MethodContext(RealMatrix.class, 214, 7725, 7998);
        try {
            CallChecker.varInit(this, "this", 214, 7725, 7998);
            CallChecker.varInit(this.threshold, "threshold", 214, 7725, 7998);
            CallChecker.varInit(this.cachedH, "cachedH", 214, 7725, 7998);
            CallChecker.varInit(this.cachedR, "cachedR", 214, 7725, 7998);
            CallChecker.varInit(this.cachedQT, "cachedQT", 214, 7725, 7998);
            CallChecker.varInit(this.cachedQ, "cachedQ", 214, 7725, 7998);
            CallChecker.varInit(this.rDiag, "rDiag", 214, 7725, 7998);
            CallChecker.varInit(this.qrt, "qrt", 214, 7725, 7998);
            if ((cachedQ) == null) {
                final RealMatrix npe_invocation_var819 = getQT();
                if (CallChecker.beforeDeref(npe_invocation_var819, RealMatrix.class, 216, 7939, 7945)) {
                    cachedQ = CallChecker.isCalled(npe_invocation_var819, RealMatrix.class, 216, 7939, 7945).transpose();
                    CallChecker.varAssign(this.cachedQ, "this.cachedQ", 216, 7929, 7958);
                }
            }
            return cachedQ;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3661.methodEnd();
        }
    }

    public RealMatrix getQT() {
        MethodContext _bcornu_methode_context3662 = new MethodContext(RealMatrix.class, 226, 8005, 9676);
        try {
            CallChecker.varInit(this, "this", 226, 8005, 9676);
            CallChecker.varInit(this.threshold, "threshold", 226, 8005, 9676);
            CallChecker.varInit(this.cachedH, "cachedH", 226, 8005, 9676);
            CallChecker.varInit(this.cachedR, "cachedR", 226, 8005, 9676);
            CallChecker.varInit(this.cachedQT, "cachedQT", 226, 8005, 9676);
            CallChecker.varInit(this.cachedQ, "cachedQ", 226, 8005, 9676);
            CallChecker.varInit(this.rDiag, "rDiag", 226, 8005, 9676);
            CallChecker.varInit(this.qrt, "qrt", 226, 8005, 9676);
            if ((cachedQT) == null) {
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 230, 8317, 8319);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.qrt, double[][].class, 230, 8317, 8319).length)), "n", 230, 8261, 8327);
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 231, 8355, 8357);
                CallChecker.isCalled(qrt, double[][].class, 231, 8355, 8357)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 231, 8355, 8357)[0], double[].class, 231, 8355, 8360);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qrt, double[][].class, 231, 8355, 8357)[0], double[].class, 231, 8355, 8360).length)), "m", 231, 8341, 8368);
                double[][] qta = CallChecker.varInit(new double[m][m], "qta", 232, 8382, 8415);
                for (int minor = m - 1; minor >= (FastMath.min(m, n)); minor--) {
                    if (CallChecker.beforeDeref(qta, double[][].class, 240, 8747, 8749)) {
                        qta = CallChecker.beforeCalled(qta, double[][].class, 240, 8747, 8749);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor], double[].class, 240, 8747, 8756)) {
                            qta = CallChecker.beforeCalled(qta, double[][].class, 240, 8747, 8749);
                            CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor], double[].class, 240, 8747, 8756);
                            CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor], double[].class, 240, 8747, 8756)[minor] = 1.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor], double[].class, 240, 8747, 8756)[minor], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 240, 8747, 8749)[minor], double[].class, 240, 8747, 8756)[minor]", 240, 8747, 8771);
                        }
                    }
                }
                for (int minor = (FastMath.min(m, n)) - 1; minor >= 0; minor--) {
                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 244, 8903, 8905);
                    final double[] qrtMinor = CallChecker.varInit(CallChecker.isCalled(qrt, double[][].class, 244, 8903, 8905)[minor], "qrtMinor", 244, 8877, 8913);
                    if (CallChecker.beforeDeref(qta, double[][].class, 245, 8931, 8933)) {
                        qta = CallChecker.beforeCalled(qta, double[][].class, 245, 8931, 8933);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor], double[].class, 245, 8931, 8940)) {
                            qta = CallChecker.beforeCalled(qta, double[][].class, 245, 8931, 8933);
                            CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor], double[].class, 245, 8931, 8940);
                            CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor], double[].class, 245, 8931, 8940)[minor] = 1.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor], double[].class, 245, 8931, 8940)[minor], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 245, 8931, 8933)[minor], double[].class, 245, 8931, 8940)[minor]", 245, 8931, 8955);
                        }
                    }
                    if (CallChecker.beforeDeref(qrtMinor, double[].class, 246, 8977, 8984)) {
                        if ((CallChecker.isCalled(qrtMinor, double[].class, 246, 8977, 8984)[minor]) != 0.0) {
                            for (int col = minor; col < m; col++) {
                                double alpha = CallChecker.varInit(((double) (0)), "alpha", 248, 9087, 9103);
                                for (int row = minor; row < m; row++) {
                                    if (CallChecker.beforeDeref(qta, double[][].class, 250, 9206, 9208)) {
                                        qta = CallChecker.beforeCalled(qta, double[][].class, 250, 9206, 9208);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 250, 9206, 9208)[col], double[].class, 250, 9206, 9213)) {
                                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 250, 9222, 9229)) {
                                                qta = CallChecker.beforeCalled(qta, double[][].class, 250, 9206, 9208);
                                                CallChecker.isCalled(qta, double[][].class, 250, 9206, 9208)[col] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 250, 9206, 9208)[col], double[].class, 250, 9206, 9213);
                                                alpha -= (CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 250, 9206, 9208)[col], double[].class, 250, 9206, 9213)[row]) * (CallChecker.isCalled(qrtMinor, double[].class, 250, 9222, 9229)[row]);
                                                CallChecker.varAssign(alpha, "alpha", 250, 9197, 9235);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(rDiag, double[].class, 252, 9296, 9300)) {
                                    if (CallChecker.beforeDeref(qrtMinor, double[].class, 252, 9311, 9318)) {
                                        rDiag = CallChecker.beforeCalled(rDiag, double[].class, 252, 9296, 9300);
                                        alpha /= (CallChecker.isCalled(rDiag, double[].class, 252, 9296, 9300)[minor]) * (CallChecker.isCalled(qrtMinor, double[].class, 252, 9311, 9318)[minor]);
                                        CallChecker.varAssign(alpha, "alpha", 252, 9287, 9326);
                                    }
                                }
                                for (int row = minor; row < m; row++) {
                                    if (CallChecker.beforeDeref(qta, double[][].class, 255, 9421, 9423)) {
                                        qta = CallChecker.beforeCalled(qta, double[][].class, 255, 9421, 9423);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col], double[].class, 255, 9421, 9428)) {
                                            if (CallChecker.beforeDeref(qrtMinor, double[].class, 255, 9447, 9454)) {
                                                qta = CallChecker.beforeCalled(qta, double[][].class, 255, 9421, 9423);
                                                CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col] = CallChecker.beforeCalled(CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col], double[].class, 255, 9421, 9428);
                                                CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col], double[].class, 255, 9421, 9428)[row] += (-alpha) * (CallChecker.isCalled(qrtMinor, double[].class, 255, 9447, 9454)[row]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col], double[].class, 255, 9421, 9428)[row], "CallChecker.isCalled(CallChecker.isCalled(qta, double[][].class, 255, 9421, 9423)[col], double[].class, 255, 9421, 9428)[row]", 255, 9421, 9460);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                cachedQT = MatrixUtils.createRealMatrix(qta);
                CallChecker.varAssign(this.cachedQT, "this.cachedQT", 260, 9554, 9598);
            }
            return cachedQT;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3662.methodEnd();
        }
    }

    public RealMatrix getH() {
        MethodContext _bcornu_methode_context3663 = new MethodContext(RealMatrix.class, 274, 9683, 10492);
        try {
            CallChecker.varInit(this, "this", 274, 9683, 10492);
            CallChecker.varInit(this.threshold, "threshold", 274, 9683, 10492);
            CallChecker.varInit(this.cachedH, "cachedH", 274, 9683, 10492);
            CallChecker.varInit(this.cachedR, "cachedR", 274, 9683, 10492);
            CallChecker.varInit(this.cachedQT, "cachedQT", 274, 9683, 10492);
            CallChecker.varInit(this.cachedQ, "cachedQ", 274, 9683, 10492);
            CallChecker.varInit(this.rDiag, "rDiag", 274, 9683, 10492);
            CallChecker.varInit(this.qrt, "qrt", 274, 9683, 10492);
            if ((cachedH) == null) {
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 277, 10067, 10069);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.qrt, double[][].class, 277, 10067, 10069).length)), "n", 277, 10053, 10077);
                qrt = CallChecker.beforeCalled(qrt, double[][].class, 278, 10105, 10107);
                CallChecker.isCalled(qrt, double[][].class, 278, 10105, 10107)[0] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 278, 10105, 10107)[0], double[].class, 278, 10105, 10110);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qrt, double[][].class, 278, 10105, 10107)[0], double[].class, 278, 10105, 10110).length)), "m", 278, 10091, 10118);
                double[][] ha = CallChecker.varInit(new double[m][n], "ha", 279, 10132, 10164);
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < (FastMath.min((i + 1), n)); ++j) {
                        if (CallChecker.beforeDeref(ha, double[][].class, 282, 10295, 10296)) {
                            ha = CallChecker.beforeCalled(ha, double[][].class, 282, 10295, 10296);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i], double[].class, 282, 10295, 10299)) {
                                if (CallChecker.beforeDeref(qrt, double[][].class, 282, 10306, 10308)) {
                                    qrt = CallChecker.beforeCalled(qrt, double[][].class, 282, 10306, 10308);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(qrt, double[][].class, 282, 10306, 10308)[j], double[].class, 282, 10306, 10311)) {
                                        if (CallChecker.beforeDeref(rDiag, double[].class, 282, 10319, 10323)) {
                                            ha = CallChecker.beforeCalled(ha, double[][].class, 282, 10295, 10296);
                                            CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i], double[].class, 282, 10295, 10299);
                                            qrt = CallChecker.beforeCalled(qrt, double[][].class, 282, 10306, 10308);
                                            CallChecker.isCalled(qrt, double[][].class, 282, 10306, 10308)[j] = CallChecker.beforeCalled(CallChecker.isCalled(qrt, double[][].class, 282, 10306, 10308)[j], double[].class, 282, 10306, 10311);
                                            rDiag = CallChecker.beforeCalled(rDiag, double[].class, 282, 10319, 10323);
                                            CallChecker.isCalled(CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i], double[].class, 282, 10295, 10299)[j] = (CallChecker.isCalled(CallChecker.isCalled(qrt, double[][].class, 282, 10306, 10308)[j], double[].class, 282, 10306, 10311)[i]) / (-(CallChecker.isCalled(rDiag, double[].class, 282, 10319, 10323)[j]));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i], double[].class, 282, 10295, 10299)[j], "CallChecker.isCalled(CallChecker.isCalled(ha, double[][].class, 282, 10295, 10296)[i], double[].class, 282, 10295, 10299)[j]", 282, 10295, 10327);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                cachedH = MatrixUtils.createRealMatrix(ha);
                CallChecker.varAssign(this.cachedH, "this.cachedH", 285, 10373, 10415);
            }
            return cachedH;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3663.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context3664 = new MethodContext(DecompositionSolver.class, 296, 10499, 10718);
        try {
            CallChecker.varInit(this, "this", 296, 10499, 10718);
            CallChecker.varInit(this.threshold, "threshold", 296, 10499, 10718);
            CallChecker.varInit(this.cachedH, "cachedH", 296, 10499, 10718);
            CallChecker.varInit(this.cachedR, "cachedR", 296, 10499, 10718);
            CallChecker.varInit(this.cachedQT, "cachedQT", 296, 10499, 10718);
            CallChecker.varInit(this.cachedQ, "cachedQ", 296, 10499, 10718);
            CallChecker.varInit(this.rDiag, "rDiag", 296, 10499, 10718);
            CallChecker.varInit(this.qrt, "qrt", 296, 10499, 10718);
            return new QRDecomposition.Solver(qrt, rDiag, threshold);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3664.methodEnd();
        }
    }
}

