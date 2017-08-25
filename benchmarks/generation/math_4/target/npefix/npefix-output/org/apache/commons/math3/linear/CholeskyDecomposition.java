package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

public class CholeskyDecomposition {
    private static class Solver implements DecompositionSolver {
        private final double[][] lTData;

        private Solver(final double[][] lTData) {
            ConstructorContext _bcornu_methode_context151 = new ConstructorContext(CholeskyDecomposition.Solver.class, 215, 8184, 8418);
            try {
                this.lTData = lTData;
                CallChecker.varAssign(this.lTData, "this.lTData", 216, 8388, 8408);
            } finally {
                _bcornu_methode_context151.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context540 = new MethodContext(boolean.class, 220, 8429, 8612);
            try {
                CallChecker.varInit(this, "this", 220, 8429, 8612);
                CallChecker.varInit(this.lTData, "lTData", 220, 8429, 8612);
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context540.methodEnd();
            }
        }

        public RealVector solve(final RealVector b) {
            MethodContext _bcornu_methode_context541 = new MethodContext(RealVector.class, 226, 8623, 9564);
            try {
                CallChecker.varInit(this, "this", 226, 8623, 9564);
                CallChecker.varInit(b, "b", 226, 8623, 9564);
                CallChecker.varInit(this.lTData, "lTData", 226, 8623, 9564);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.lTData, double[][].class, 227, 8724, 8729).length)), "m", 227, 8710, 8737);
                if (CallChecker.beforeDeref(b, RealVector.class, 228, 8755, 8755)) {
                    if ((CallChecker.isCalled(b, RealVector.class, 228, 8755, 8755).getDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealVector.class, 229, 8833, 8833)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealVector.class, 229, 8833, 8833).getDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final double[] x = CallChecker.varInit(CallChecker.isCalled(b, RealVector.class, 232, 8901, 8901).toArray(), "x", 232, 8882, 8912);
                for (int j = 0; j < m; j++) {
                    final double[] lJ = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 236, 9021, 9026)[j], "lJ", 236, 9001, 9030);
                    if (CallChecker.beforeDeref(x, double[].class, 237, 9048, 9048)) {
                        if (CallChecker.beforeDeref(lJ, double[].class, 237, 9056, 9057)) {
                            CallChecker.isCalled(x, double[].class, 237, 9048, 9048)[j] /= CallChecker.isCalled(lJ, double[].class, 237, 9056, 9057)[j];
                            CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 237, 9048, 9048)[j], "CallChecker.isCalled(x, double[].class, 237, 9048, 9048)[j]", 237, 9048, 9061);
                        }
                    }
                    final double xJ = CallChecker.varInit(((double) (CallChecker.isCalled(x, double[].class, 238, 9097, 9097)[j])), "xJ", 238, 9079, 9101);
                    for (int i = j + 1; i < m; i++) {
                        if (CallChecker.beforeDeref(x, double[].class, 240, 9173, 9173)) {
                            if (CallChecker.beforeDeref(lJ, double[].class, 240, 9186, 9187)) {
                                CallChecker.isCalled(x, double[].class, 240, 9173, 9173)[i] -= xJ * (CallChecker.isCalled(lJ, double[].class, 240, 9186, 9187)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 240, 9173, 9173)[i], "CallChecker.isCalled(x, double[].class, 240, 9173, 9173)[i]", 240, 9173, 9191);
                            }
                        }
                    }
                }
                for (int j = m - 1; j >= 0; j--) {
                    if (CallChecker.beforeDeref(x, double[].class, 246, 9318, 9318)) {
                        if (CallChecker.beforeDeref(lTData, double[][].class, 246, 9326, 9331)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(lTData, double[][].class, 246, 9326, 9331)[j], double[].class, 246, 9326, 9334)) {
                                CallChecker.isCalled(lTData, double[][].class, 246, 9326, 9331)[j] = CallChecker.beforeCalled(CallChecker.isCalled(lTData, double[][].class, 246, 9326, 9331)[j], double[].class, 246, 9326, 9334);
                                CallChecker.isCalled(x, double[].class, 246, 9318, 9318)[j] /= CallChecker.isCalled(CallChecker.isCalled(lTData, double[][].class, 246, 9326, 9331)[j], double[].class, 246, 9326, 9334)[j];
                                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 246, 9318, 9318)[j], "CallChecker.isCalled(x, double[].class, 246, 9318, 9318)[j]", 246, 9318, 9338);
                            }
                        }
                    }
                    final double xJ = CallChecker.varInit(((double) (CallChecker.isCalled(x, double[].class, 247, 9374, 9374)[j])), "xJ", 247, 9356, 9378);
                    for (int i = 0; i < j; i++) {
                        if (CallChecker.beforeDeref(x, double[].class, 249, 9446, 9446)) {
                            if (CallChecker.beforeDeref(lTData, double[][].class, 249, 9459, 9464)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lTData, double[][].class, 249, 9459, 9464)[i], double[].class, 249, 9459, 9467)) {
                                    CallChecker.isCalled(lTData, double[][].class, 249, 9459, 9464)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lTData, double[][].class, 249, 9459, 9464)[i], double[].class, 249, 9459, 9467);
                                    CallChecker.isCalled(x, double[].class, 249, 9446, 9446)[i] -= xJ * (CallChecker.isCalled(CallChecker.isCalled(lTData, double[][].class, 249, 9459, 9464)[i], double[].class, 249, 9459, 9467)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 249, 9446, 9446)[i], "CallChecker.isCalled(x, double[].class, 249, 9446, 9446)[i]", 249, 9446, 9471);
                                }
                            }
                        }
                    }
                }
                return new ArrayRealVector(x, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context541.methodEnd();
            }
        }

        public RealMatrix solve(RealMatrix b) {
            MethodContext _bcornu_methode_context542 = new MethodContext(RealMatrix.class, 257, 9575, 11148);
            try {
                CallChecker.varInit(this, "this", 257, 9575, 11148);
                CallChecker.varInit(b, "b", 257, 9575, 11148);
                CallChecker.varInit(this.lTData, "lTData", 257, 9575, 11148);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.lTData, double[][].class, 258, 9670, 9675).length)), "m", 258, 9656, 9683);
                if (CallChecker.beforeDeref(b, RealMatrix.class, 259, 9701, 9701)) {
                    b = CallChecker.beforeCalled(b, RealMatrix.class, 259, 9701, 9701);
                    if ((CallChecker.isCalled(b, RealMatrix.class, 259, 9701, 9701).getRowDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealMatrix.class, 260, 9782, 9782)) {
                            b = CallChecker.beforeCalled(b, RealMatrix.class, 260, 9782, 9782);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealMatrix.class, 260, 9782, 9782).getRowDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                b = CallChecker.beforeCalled(b, RealMatrix.class, 263, 9852, 9852);
                final int nColB = CallChecker.varInit(((int) (CallChecker.isCalled(b, RealMatrix.class, 263, 9852, 9852).getColumnDimension())), "nColB", 263, 9834, 9874);
                b = CallChecker.beforeCalled(b, RealMatrix.class, 264, 9909, 9909);
                final double[][] x = CallChecker.varInit(CallChecker.isCalled(b, RealMatrix.class, 264, 9909, 9909).getData(), "x", 264, 9888, 9920);
                for (int j = 0; j < m; j++) {
                    final double[] lJ = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 268, 10029, 10034)[j], "lJ", 268, 10009, 10038);
                    final double lJJ = CallChecker.varInit(((double) (CallChecker.isCalled(lJ, double[].class, 269, 10075, 10076)[j])), "lJJ", 269, 10056, 10080);
                    final double[] xJ = CallChecker.varInit(CallChecker.isCalled(x, double[][].class, 270, 10118, 10118)[j], "xJ", 270, 10098, 10122);
                    for (int k = 0; k < nColB; ++k) {
                        if (CallChecker.beforeDeref(xJ, double[].class, 272, 10194, 10195)) {
                            CallChecker.isCalled(xJ, double[].class, 272, 10194, 10195)[k] /= lJJ;
                            CallChecker.varAssign(CallChecker.isCalled(xJ, double[].class, 272, 10194, 10195)[k], "CallChecker.isCalled(xJ, double[].class, 272, 10194, 10195)[k]", 272, 10194, 10206);
                        }
                    }
                    for (int i = j + 1; i < m; i++) {
                        final double[] xI = CallChecker.varInit(CallChecker.isCalled(x, double[][].class, 275, 10316, 10316)[i], "xI", 275, 10296, 10320);
                        final double lJI = CallChecker.varInit(((double) (CallChecker.isCalled(lJ, double[].class, 276, 10361, 10362)[i])), "lJI", 276, 10342, 10366);
                        for (int k = 0; k < nColB; ++k) {
                            if (CallChecker.beforeDeref(xI, double[].class, 278, 10446, 10447)) {
                                if (CallChecker.beforeDeref(xJ, double[].class, 278, 10455, 10456)) {
                                    CallChecker.isCalled(xI, double[].class, 278, 10446, 10447)[k] -= (CallChecker.isCalled(xJ, double[].class, 278, 10455, 10456)[k]) * lJI;
                                    CallChecker.varAssign(CallChecker.isCalled(xI, double[].class, 278, 10446, 10447)[k], "CallChecker.isCalled(xI, double[].class, 278, 10446, 10447)[k]", 278, 10446, 10466);
                                }
                            }
                        }
                    }
                }
                for (int j = m - 1; j >= 0; j--) {
                    CallChecker.isCalled(lTData, double[][].class, 285, 10634, 10639)[j] = CallChecker.beforeCalled(CallChecker.isCalled(lTData, double[][].class, 285, 10634, 10639)[j], double[].class, 285, 10634, 10642);
                    final double lJJ = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lTData, double[][].class, 285, 10634, 10639)[j], double[].class, 285, 10634, 10642)[j])), "lJJ", 285, 10615, 10646);
                    final double[] xJ = CallChecker.varInit(CallChecker.isCalled(x, double[][].class, 286, 10684, 10684)[j], "xJ", 286, 10664, 10688);
                    for (int k = 0; k < nColB; ++k) {
                        if (CallChecker.beforeDeref(xJ, double[].class, 288, 10760, 10761)) {
                            CallChecker.isCalled(xJ, double[].class, 288, 10760, 10761)[k] /= lJJ;
                            CallChecker.varAssign(CallChecker.isCalled(xJ, double[].class, 288, 10760, 10761)[k], "CallChecker.isCalled(xJ, double[].class, 288, 10760, 10761)[k]", 288, 10760, 10772);
                        }
                    }
                    for (int i = 0; i < j; i++) {
                        final double[] xI = CallChecker.varInit(CallChecker.isCalled(x, double[][].class, 291, 10878, 10878)[i], "xI", 291, 10858, 10882);
                        CallChecker.isCalled(lTData, double[][].class, 292, 10923, 10928)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lTData, double[][].class, 292, 10923, 10928)[i], double[].class, 292, 10923, 10931);
                        final double lIJ = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lTData, double[][].class, 292, 10923, 10928)[i], double[].class, 292, 10923, 10931)[j])), "lIJ", 292, 10904, 10935);
                        for (int k = 0; k < nColB; ++k) {
                            if (CallChecker.beforeDeref(xI, double[].class, 294, 11015, 11016)) {
                                if (CallChecker.beforeDeref(xJ, double[].class, 294, 11024, 11025)) {
                                    CallChecker.isCalled(xI, double[].class, 294, 11015, 11016)[k] -= (CallChecker.isCalled(xJ, double[].class, 294, 11024, 11025)[k]) * lIJ;
                                    CallChecker.varAssign(CallChecker.isCalled(xI, double[].class, 294, 11015, 11016)[k], "CallChecker.isCalled(xI, double[].class, 294, 11015, 11016)[k]", 294, 11015, 11035);
                                }
                            }
                        }
                    }
                }
                return new Array2DRowRealMatrix(x);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context542.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context543 = new MethodContext(RealMatrix.class, 303, 11159, 11308);
            try {
                CallChecker.varInit(this, "this", 303, 11159, 11308);
                CallChecker.varInit(this.lTData, "lTData", 303, 11159, 11308);
                if (CallChecker.beforeDeref(lTData, double[][].class, 304, 11283, 11288)) {
                    return solve(MatrixUtils.createRealIdentityMatrix(CallChecker.isCalled(lTData, double[][].class, 304, 11283, 11288).length));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context543.methodEnd();
            }
        }
    }

    public static final double DEFAULT_RELATIVE_SYMMETRY_THRESHOLD = 1.0E-15;

    public static final double DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD = 1.0E-10;

    private double[][] lTData;

    private RealMatrix cachedL;

    private RealMatrix cachedLT;

    public CholeskyDecomposition(final RealMatrix matrix) {
        this(matrix, CholeskyDecomposition.DEFAULT_RELATIVE_SYMMETRY_THRESHOLD, CholeskyDecomposition.DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD);
        ConstructorContext _bcornu_methode_context152 = new ConstructorContext(CholeskyDecomposition.class, 84, 2887, 3904);
        try {
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    public CholeskyDecomposition(final RealMatrix matrix, final double relativeSymmetryThreshold, final double absolutePositivityThreshold) {
        ConstructorContext _bcornu_methode_context153 = new ConstructorContext(CholeskyDecomposition.class, 104, 3911, 6712);
        try {
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 107, 4947, 4952)) {
                if (!(CallChecker.isCalled(matrix, RealMatrix.class, 107, 4947, 4952).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 108, 5015, 5020)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 109, 5088, 5093)) {
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, RealMatrix.class, 108, 5015, 5020).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 109, 5088, 5093).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final int order = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 112, 5155, 5160).getRowDimension())), "order", 112, 5137, 5179);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 113, 5200, 5205)) {
                lTData = CallChecker.isCalled(matrix, RealMatrix.class, 113, 5200, 5205).getData();
                CallChecker.varAssign(this.lTData, "this.lTData", 113, 5189, 5216);
            }
            cachedL = null;
            CallChecker.varAssign(this.cachedL, "this.cachedL", 114, 5226, 5241);
            cachedLT = null;
            CallChecker.varAssign(this.cachedLT, "this.cachedLT", 115, 5251, 5266);
            for (int i = 0; i < order; ++i) {
                lTData = CallChecker.beforeCalled(lTData, double[][].class, 119, 5393, 5398);
                final double[] lI = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 119, 5393, 5398)[i], "lI", 119, 5373, 5402);
                for (int j = i + 1; j < order; ++j) {
                    lTData = CallChecker.beforeCalled(lTData, double[][].class, 123, 5556, 5561);
                    final double[] lJ = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 123, 5556, 5561)[j], "lJ", 123, 5536, 5565);
                    final double lIJ = CallChecker.varInit(((double) (CallChecker.isCalled(lI, double[].class, 124, 5602, 5603)[j])), "lIJ", 124, 5583, 5607);
                    final double lJI = CallChecker.varInit(((double) (CallChecker.isCalled(lJ, double[].class, 125, 5644, 5645)[i])), "lJI", 125, 5625, 5649);
                    final double maxDelta = CallChecker.varInit(((double) (relativeSymmetryThreshold * (FastMath.max(FastMath.abs(lIJ), FastMath.abs(lJI))))), "maxDelta", 126, 5667, 5789);
                    if ((FastMath.abs((lIJ - lJI))) > maxDelta) {
                        throw new NonSymmetricMatrixException(i, j, relativeSymmetryThreshold);
                    }
                    if (CallChecker.beforeDeref(lJ, double[].class, 131, 5975, 5976)) {
                        CallChecker.isCalled(lJ, double[].class, 131, 5975, 5976)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(lJ, double[].class, 131, 5975, 5976)[i], "CallChecker.isCalled(lJ, double[].class, 131, 5975, 5976)[i]", 131, 5975, 5984);
                    }
                }
            }
            for (int i = 0; i < order; ++i) {
                lTData = CallChecker.beforeCalled(lTData, double[][].class, 138, 6118, 6123);
                final double[] ltI = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 138, 6118, 6123)[i], "ltI", 138, 6097, 6127);
                if (CallChecker.beforeDeref(ltI, double[].class, 141, 6184, 6186)) {
                    if ((CallChecker.isCalled(ltI, double[].class, 141, 6184, 6186)[i]) <= absolutePositivityThreshold) {
                        if (CallChecker.beforeDeref(ltI, double[].class, 142, 6286, 6288)) {
                            throw new NonPositiveDefiniteMatrixException(CallChecker.isCalled(ltI, double[].class, 142, 6286, 6288)[i], i, absolutePositivityThreshold);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(ltI, double[].class, 145, 6354, 6356)) {
                    if (CallChecker.beforeDeref(ltI, double[].class, 145, 6377, 6379)) {
                        CallChecker.isCalled(ltI, double[].class, 145, 6354, 6356)[i] = FastMath.sqrt(CallChecker.isCalled(ltI, double[].class, 145, 6377, 6379)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(ltI, double[].class, 145, 6354, 6356)[i], "CallChecker.isCalled(ltI, double[].class, 145, 6354, 6356)[i]", 145, 6354, 6384);
                    }
                }
                final double inverse = CallChecker.varInit(((double) (1.0 / (CallChecker.isCalled(ltI, double[].class, 146, 6427, 6429)[i]))), "inverse", 146, 6398, 6433);
                for (int q = order - 1; q > i; --q) {
                    if (CallChecker.beforeDeref(ltI, double[].class, 149, 6502, 6504)) {
                        CallChecker.isCalled(ltI, double[].class, 149, 6502, 6504)[q] *= inverse;
                        CallChecker.varAssign(CallChecker.isCalled(ltI, double[].class, 149, 6502, 6504)[q], "CallChecker.isCalled(ltI, double[].class, 149, 6502, 6504)[q]", 149, 6502, 6519);
                    }
                    lTData = CallChecker.beforeCalled(lTData, double[][].class, 150, 6558, 6563);
                    final double[] ltQ = CallChecker.varInit(CallChecker.isCalled(lTData, double[][].class, 150, 6558, 6563)[q], "ltQ", 150, 6537, 6567);
                    for (int p = q; p < order; ++p) {
                        if (CallChecker.beforeDeref(ltQ, double[].class, 152, 6639, 6641)) {
                            if (CallChecker.beforeDeref(ltI, double[].class, 152, 6649, 6651)) {
                                if (CallChecker.beforeDeref(ltI, double[].class, 152, 6658, 6660)) {
                                    CallChecker.isCalled(ltQ, double[].class, 152, 6639, 6641)[p] -= (CallChecker.isCalled(ltI, double[].class, 152, 6649, 6651)[q]) * (CallChecker.isCalled(ltI, double[].class, 152, 6658, 6660)[p]);
                                    CallChecker.varAssign(CallChecker.isCalled(ltQ, double[].class, 152, 6639, 6641)[p], "CallChecker.isCalled(ltQ, double[].class, 152, 6639, 6641)[p]", 152, 6639, 6664);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    public RealMatrix getL() {
        MethodContext _bcornu_methode_context544 = new MethodContext(RealMatrix.class, 163, 6719, 6998);
        try {
            CallChecker.varInit(this, "this", 163, 6719, 6998);
            CallChecker.varInit(this.cachedLT, "cachedLT", 163, 6719, 6998);
            CallChecker.varInit(this.cachedL, "cachedL", 163, 6719, 6998);
            CallChecker.varInit(this.lTData, "lTData", 163, 6719, 6998);
            CallChecker.varInit(DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD", 163, 6719, 6998);
            CallChecker.varInit(DEFAULT_RELATIVE_SYMMETRY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_RELATIVE_SYMMETRY_THRESHOLD", 163, 6719, 6998);
            if ((cachedL) == null) {
                final RealMatrix npe_invocation_var49 = getLT();
                if (CallChecker.beforeDeref(npe_invocation_var49, RealMatrix.class, 165, 6939, 6945)) {
                    cachedL = CallChecker.isCalled(npe_invocation_var49, RealMatrix.class, 165, 6939, 6945).transpose();
                    CallChecker.varAssign(this.cachedL, "this.cachedL", 165, 6929, 6958);
                }
            }
            return cachedL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context544.methodEnd();
        }
    }

    public RealMatrix getLT() {
        MethodContext _bcornu_methode_context545 = new MethodContext(RealMatrix.class, 175, 7005, 7410);
        try {
            CallChecker.varInit(this, "this", 175, 7005, 7410);
            CallChecker.varInit(this.cachedLT, "cachedLT", 175, 7005, 7410);
            CallChecker.varInit(this.cachedL, "cachedL", 175, 7005, 7410);
            CallChecker.varInit(this.lTData, "lTData", 175, 7005, 7410);
            CallChecker.varInit(DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD", 175, 7005, 7410);
            CallChecker.varInit(DEFAULT_RELATIVE_SYMMETRY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_RELATIVE_SYMMETRY_THRESHOLD", 175, 7005, 7410);
            if ((cachedLT) == null) {
                cachedLT = MatrixUtils.createRealMatrix(lTData);
                CallChecker.varAssign(this.cachedLT, "this.cachedLT", 178, 7285, 7332);
            }
            return cachedLT;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context545.methodEnd();
        }
    }

    public double getDeterminant() {
        MethodContext _bcornu_methode_context546 = new MethodContext(double.class, 189, 7417, 7757);
        try {
            CallChecker.varInit(this, "this", 189, 7417, 7757);
            CallChecker.varInit(this.cachedLT, "cachedLT", 189, 7417, 7757);
            CallChecker.varInit(this.cachedL, "cachedL", 189, 7417, 7757);
            CallChecker.varInit(this.lTData, "lTData", 189, 7417, 7757);
            CallChecker.varInit(DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD", 189, 7417, 7757);
            CallChecker.varInit(DEFAULT_RELATIVE_SYMMETRY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_RELATIVE_SYMMETRY_THRESHOLD", 189, 7417, 7757);
            double determinant = CallChecker.varInit(((double) (1.0)), "determinant", 190, 7559, 7583);
            lTData = CallChecker.beforeCalled(lTData, double[][].class, 191, 7613, 7618);
            for (int i = 0; i < (CallChecker.isCalled(lTData, double[][].class, 191, 7613, 7618).length); ++i) {
                double lTii = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lTData, double[][].class, 192, 7661, 7666)) {
                    lTData = CallChecker.beforeCalled(lTData, double[][].class, 192, 7661, 7666);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(lTData, double[][].class, 192, 7661, 7666)[i], double[].class, 192, 7661, 7669)) {
                        lTData = CallChecker.beforeCalled(lTData, double[][].class, 192, 7661, 7666);
                        CallChecker.isCalled(lTData, double[][].class, 192, 7661, 7666)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lTData, double[][].class, 192, 7661, 7666)[i], double[].class, 192, 7661, 7669);
                        lTii = CallChecker.isCalled(CallChecker.isCalled(lTData, double[][].class, 192, 7661, 7666)[i], double[].class, 192, 7661, 7669)[i];
                        CallChecker.varAssign(lTii, "lTii", 192, 7661, 7666);
                    }
                }
                determinant *= lTii * lTii;
                CallChecker.varAssign(determinant, "determinant", 193, 7687, 7713);
            }
            return determinant;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context546.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context547 = new MethodContext(DecompositionSolver.class, 202, 7764, 7968);
        try {
            CallChecker.varInit(this, "this", 202, 7764, 7968);
            CallChecker.varInit(this.cachedLT, "cachedLT", 202, 7764, 7968);
            CallChecker.varInit(this.cachedL, "cachedL", 202, 7764, 7968);
            CallChecker.varInit(this.lTData, "lTData", 202, 7764, 7968);
            CallChecker.varInit(DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD", 202, 7764, 7968);
            CallChecker.varInit(DEFAULT_RELATIVE_SYMMETRY_THRESHOLD, "org.apache.commons.math3.linear.CholeskyDecomposition.DEFAULT_RELATIVE_SYMMETRY_THRESHOLD", 202, 7764, 7968);
            return new CholeskyDecomposition.Solver(lTData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context547.methodEnd();
        }
    }
}

