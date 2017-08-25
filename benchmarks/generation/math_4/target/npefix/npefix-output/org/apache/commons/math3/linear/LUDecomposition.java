package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

public class LUDecomposition {
    private static class Solver implements DecompositionSolver {
        private final double[][] lu;

        private final int[] pivot;

        private final boolean singular;

        private Solver(final double[][] lu, final int[] pivot, final boolean singular) {
            ConstructorContext _bcornu_methode_context334 = new ConstructorContext(LUDecomposition.Solver.class, 279, 9565, 10006);
            try {
                this.lu = lu;
                CallChecker.varAssign(this.lu, "this.lu", 280, 9905, 9923);
                this.pivot = pivot;
                CallChecker.varAssign(this.pivot, "this.pivot", 281, 9937, 9958);
                this.singular = singular;
                CallChecker.varAssign(this.singular, "this.singular", 282, 9972, 9996);
            } finally {
                _bcornu_methode_context334.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context1550 = new MethodContext(boolean.class, 286, 10017, 10117);
            try {
                CallChecker.varInit(this, "this", 286, 10017, 10117);
                CallChecker.varInit(this.singular, "singular", 286, 10017, 10117);
                CallChecker.varInit(this.pivot, "pivot", 286, 10017, 10117);
                CallChecker.varInit(this.lu, "lu", 286, 10017, 10117);
                return !(singular);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1550.methodEnd();
            }
        }

        public RealVector solve(RealVector b) {
            MethodContext _bcornu_methode_context1551 = new MethodContext(RealVector.class, 291, 10128, 11276);
            try {
                CallChecker.varInit(this, "this", 291, 10128, 11276);
                CallChecker.varInit(b, "b", 291, 10128, 11276);
                CallChecker.varInit(this.singular, "singular", 291, 10128, 11276);
                CallChecker.varInit(this.pivot, "pivot", 291, 10128, 11276);
                CallChecker.varInit(this.lu, "lu", 291, 10128, 11276);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 292, 10223, 10227).length)), "m", 292, 10209, 10235);
                if (CallChecker.beforeDeref(b, RealVector.class, 293, 10253, 10253)) {
                    b = CallChecker.beforeCalled(b, RealVector.class, 293, 10253, 10253);
                    if ((CallChecker.isCalled(b, RealVector.class, 293, 10253, 10253).getDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealVector.class, 294, 10331, 10331)) {
                            b = CallChecker.beforeCalled(b, RealVector.class, 294, 10331, 10331);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealVector.class, 294, 10331, 10331).getDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (singular) {
                    throw new SingularMatrixException();
                }
                final double[] bp = CallChecker.varInit(new double[m], "bp", 300, 10475, 10508);
                for (int row = 0; row < m; row++) {
                    if (CallChecker.beforeDeref(bp, double[].class, 304, 10614, 10615)) {
                        if (CallChecker.beforeDeref(pivot, int[].class, 304, 10635, 10639)) {
                            if (CallChecker.beforeDeref(b, RealVector.class, 304, 10624, 10624)) {
                                b = CallChecker.beforeCalled(b, RealVector.class, 304, 10624, 10624);
                                CallChecker.isCalled(bp, double[].class, 304, 10614, 10615)[row] = CallChecker.isCalled(b, RealVector.class, 304, 10624, 10624).getEntry(CallChecker.isCalled(pivot, int[].class, 304, 10635, 10639)[row]);
                                CallChecker.varAssign(CallChecker.isCalled(bp, double[].class, 304, 10614, 10615)[row], "CallChecker.isCalled(bp, double[].class, 304, 10614, 10615)[row]", 304, 10614, 10646);
                            }
                        }
                    }
                }
                for (int col = 0; col < m; col++) {
                    final double bpCol = CallChecker.varInit(((double) (CallChecker.isCalled(bp, double[].class, 309, 10776, 10777)[col])), "bpCol", 309, 10755, 10783);
                    for (int i = col + 1; i < m; i++) {
                        if (CallChecker.beforeDeref(bp, double[].class, 311, 10857, 10858)) {
                            if (CallChecker.beforeDeref(lu, double[][].class, 311, 10874, 10875)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 311, 10874, 10875)[i], double[].class, 311, 10874, 10878)) {
                                    CallChecker.isCalled(lu, double[][].class, 311, 10874, 10875)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 311, 10874, 10875)[i], double[].class, 311, 10874, 10878);
                                    CallChecker.isCalled(bp, double[].class, 311, 10857, 10858)[i] -= bpCol * (CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 311, 10874, 10875)[i], double[].class, 311, 10874, 10878)[col]);
                                    CallChecker.varAssign(CallChecker.isCalled(bp, double[].class, 311, 10857, 10858)[i], "CallChecker.isCalled(bp, double[].class, 311, 10857, 10858)[i]", 311, 10857, 10884);
                                }
                            }
                        }
                    }
                }
                for (int col = m - 1; col >= 0; col--) {
                    if (CallChecker.beforeDeref(bp, double[].class, 317, 11016, 11017)) {
                        if (CallChecker.beforeDeref(lu, double[][].class, 317, 11027, 11028)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 317, 11027, 11028)[col], double[].class, 317, 11027, 11033)) {
                                CallChecker.isCalled(lu, double[][].class, 317, 11027, 11028)[col] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 317, 11027, 11028)[col], double[].class, 317, 11027, 11033);
                                CallChecker.isCalled(bp, double[].class, 317, 11016, 11017)[col] /= CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 317, 11027, 11028)[col], double[].class, 317, 11027, 11033)[col];
                                CallChecker.varAssign(CallChecker.isCalled(bp, double[].class, 317, 11016, 11017)[col], "CallChecker.isCalled(bp, double[].class, 317, 11016, 11017)[col]", 317, 11016, 11039);
                            }
                        }
                    }
                    final double bpCol = CallChecker.varInit(((double) (CallChecker.isCalled(bp, double[].class, 318, 11078, 11079)[col])), "bpCol", 318, 11057, 11085);
                    for (int i = 0; i < col; i++) {
                        if (CallChecker.beforeDeref(bp, double[].class, 320, 11155, 11156)) {
                            if (CallChecker.beforeDeref(lu, double[][].class, 320, 11172, 11173)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 320, 11172, 11173)[i], double[].class, 320, 11172, 11176)) {
                                    CallChecker.isCalled(lu, double[][].class, 320, 11172, 11173)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 320, 11172, 11173)[i], double[].class, 320, 11172, 11176);
                                    CallChecker.isCalled(bp, double[].class, 320, 11155, 11156)[i] -= bpCol * (CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 320, 11172, 11173)[i], double[].class, 320, 11172, 11176)[col]);
                                    CallChecker.varAssign(CallChecker.isCalled(bp, double[].class, 320, 11155, 11156)[i], "CallChecker.isCalled(bp, double[].class, 320, 11155, 11156)[i]", 320, 11155, 11182);
                                }
                            }
                        }
                    }
                }
                return new ArrayRealVector(bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1551.methodEnd();
            }
        }

        public RealMatrix solve(RealMatrix b) {
            MethodContext _bcornu_methode_context1552 = new MethodContext(RealMatrix.class, 328, 11287, 13170);
            try {
                CallChecker.varInit(this, "this", 328, 11287, 13170);
                CallChecker.varInit(b, "b", 328, 11287, 13170);
                CallChecker.varInit(this.singular, "singular", 328, 11287, 13170);
                CallChecker.varInit(this.pivot, "pivot", 328, 11287, 13170);
                CallChecker.varInit(this.lu, "lu", 328, 11287, 13170);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 330, 11383, 11387).length)), "m", 330, 11369, 11395);
                if (CallChecker.beforeDeref(b, RealMatrix.class, 331, 11413, 11413)) {
                    b = CallChecker.beforeCalled(b, RealMatrix.class, 331, 11413, 11413);
                    if ((CallChecker.isCalled(b, RealMatrix.class, 331, 11413, 11413).getRowDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealMatrix.class, 332, 11494, 11494)) {
                            b = CallChecker.beforeCalled(b, RealMatrix.class, 332, 11494, 11494);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealMatrix.class, 332, 11494, 11494).getRowDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (singular) {
                    throw new SingularMatrixException();
                }
                b = CallChecker.beforeCalled(b, RealMatrix.class, 338, 11659, 11659);
                final int nColB = CallChecker.varInit(((int) (CallChecker.isCalled(b, RealMatrix.class, 338, 11659, 11659).getColumnDimension())), "nColB", 338, 11641, 11681);
                final double[][] bp = CallChecker.varInit(new double[m][nColB], "bp", 341, 11735, 11777);
                for (int row = 0; row < m; row++) {
                    final double[] bpRow = CallChecker.varInit(CallChecker.isCalled(bp, double[][].class, 343, 11866, 11867)[row], "bpRow", 343, 11843, 11873);
                    final int pRow = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 344, 11908, 11912)[row])), "pRow", 344, 11891, 11918);
                    for (int col = 0; col < nColB; col++) {
                        if (CallChecker.beforeDeref(bpRow, double[].class, 346, 11996, 12000)) {
                            if (CallChecker.beforeDeref(b, RealMatrix.class, 346, 12009, 12009)) {
                                b = CallChecker.beforeCalled(b, RealMatrix.class, 346, 12009, 12009);
                                CallChecker.isCalled(bpRow, double[].class, 346, 11996, 12000)[col] = CallChecker.isCalled(b, RealMatrix.class, 346, 12009, 12009).getEntry(pRow, col);
                                CallChecker.varAssign(CallChecker.isCalled(bpRow, double[].class, 346, 11996, 12000)[col], "CallChecker.isCalled(bpRow, double[].class, 346, 11996, 12000)[col]", 346, 11996, 12030);
                            }
                        }
                    }
                }
                for (int col = 0; col < m; col++) {
                    final double[] bpCol = CallChecker.varInit(CallChecker.isCalled(bp, double[][].class, 352, 12180, 12181)[col], "bpCol", 352, 12157, 12187);
                    for (int i = col + 1; i < m; i++) {
                        final double[] bpI = CallChecker.varInit(CallChecker.isCalled(bp, double[][].class, 354, 12282, 12283)[i], "bpI", 354, 12261, 12287);
                        CallChecker.isCalled(lu, double[][].class, 355, 12331, 12332)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 355, 12331, 12332)[i], double[].class, 355, 12331, 12335);
                        final double luICol = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 355, 12331, 12332)[i], double[].class, 355, 12331, 12335)[col])), "luICol", 355, 12309, 12341);
                        for (int j = 0; j < nColB; j++) {
                            if (CallChecker.beforeDeref(bpI, double[].class, 357, 12421, 12423)) {
                                if (CallChecker.beforeDeref(bpCol, double[].class, 357, 12431, 12435)) {
                                    CallChecker.isCalled(bpI, double[].class, 357, 12421, 12423)[j] -= (CallChecker.isCalled(bpCol, double[].class, 357, 12431, 12435)[j]) * luICol;
                                    CallChecker.varAssign(CallChecker.isCalled(bpI, double[].class, 357, 12421, 12423)[j], "CallChecker.isCalled(bpI, double[].class, 357, 12421, 12423)[j]", 357, 12421, 12448);
                                }
                            }
                        }
                    }
                }
                for (int col = m - 1; col >= 0; col--) {
                    final double[] bpCol = CallChecker.varInit(CallChecker.isCalled(bp, double[][].class, 364, 12625, 12626)[col], "bpCol", 364, 12602, 12632);
                    CallChecker.isCalled(lu, double[][].class, 365, 12672, 12673)[col] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 365, 12672, 12673)[col], double[].class, 365, 12672, 12678);
                    final double luDiag = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 365, 12672, 12673)[col], double[].class, 365, 12672, 12678)[col])), "luDiag", 365, 12650, 12684);
                    for (int j = 0; j < nColB; j++) {
                        if (CallChecker.beforeDeref(bpCol, double[].class, 367, 12756, 12760)) {
                            CallChecker.isCalled(bpCol, double[].class, 367, 12756, 12760)[j] /= luDiag;
                            CallChecker.varAssign(CallChecker.isCalled(bpCol, double[].class, 367, 12756, 12760)[j], "CallChecker.isCalled(bpCol, double[].class, 367, 12756, 12760)[j]", 367, 12756, 12774);
                        }
                    }
                    for (int i = 0; i < col; i++) {
                        final double[] bpI = CallChecker.varInit(CallChecker.isCalled(bp, double[][].class, 370, 12883, 12884)[i], "bpI", 370, 12862, 12888);
                        CallChecker.isCalled(lu, double[][].class, 371, 12932, 12933)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 371, 12932, 12933)[i], double[].class, 371, 12932, 12936);
                        final double luICol = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 371, 12932, 12933)[i], double[].class, 371, 12932, 12936)[col])), "luICol", 371, 12910, 12942);
                        for (int j = 0; j < nColB; j++) {
                            if (CallChecker.beforeDeref(bpI, double[].class, 373, 13022, 13024)) {
                                if (CallChecker.beforeDeref(bpCol, double[].class, 373, 13032, 13036)) {
                                    CallChecker.isCalled(bpI, double[].class, 373, 13022, 13024)[j] -= (CallChecker.isCalled(bpCol, double[].class, 373, 13032, 13036)[j]) * luICol;
                                    CallChecker.varAssign(CallChecker.isCalled(bpI, double[].class, 373, 13022, 13024)[j], "CallChecker.isCalled(bpI, double[].class, 373, 13022, 13024)[j]", 373, 13022, 13049);
                                }
                            }
                        }
                    }
                }
                return new Array2DRowRealMatrix(bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1552.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context1553 = new MethodContext(RealMatrix.class, 382, 13181, 13329);
            try {
                CallChecker.varInit(this, "this", 382, 13181, 13329);
                CallChecker.varInit(this.singular, "singular", 382, 13181, 13329);
                CallChecker.varInit(this.pivot, "pivot", 382, 13181, 13329);
                CallChecker.varInit(this.lu, "lu", 382, 13181, 13329);
                if (CallChecker.beforeDeref(pivot, int[].class, 383, 13305, 13309)) {
                    return solve(MatrixUtils.createRealIdentityMatrix(CallChecker.isCalled(pivot, int[].class, 383, 13305, 13309).length));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1553.methodEnd();
            }
        }
    }

    private static final double DEFAULT_TOO_SMALL = 1.0E-11;

    private final double[][] lu;

    private final int[] pivot;

    private boolean even;

    private boolean singular;

    private RealMatrix cachedL;

    private RealMatrix cachedU;

    private RealMatrix cachedP;

    public LUDecomposition(RealMatrix matrix) {
        this(matrix, LUDecomposition.DEFAULT_TOO_SMALL);
        ConstructorContext _bcornu_methode_context335 = new ConstructorContext(LUDecomposition.class, 75, 3007, 3376);
        try {
        } finally {
            _bcornu_methode_context335.methodEnd();
        }
    }

    public LUDecomposition(RealMatrix matrix, double singularityThreshold) {
        ConstructorContext _bcornu_methode_context336 = new ConstructorContext(LUDecomposition.class, 86, 3383, 6303);
        try {
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 87, 3779, 3784)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 87, 3779, 3784);
                if (!(CallChecker.isCalled(matrix, RealMatrix.class, 87, 3779, 3784).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 88, 3847, 3852)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 89, 3920, 3925)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 88, 3847, 3852);
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 89, 3920, 3925);
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, RealMatrix.class, 88, 3847, 3852).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 89, 3920, 3925).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 92, 3983, 3988);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 92, 3983, 3988).getColumnDimension())), "m", 92, 3969, 4010);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 93, 4025, 4030);
            lu = CallChecker.isCalled(matrix, RealMatrix.class, 93, 4025, 4030).getData();
            CallChecker.varAssign(this.lu, "this.lu", 93, 4020, 4041);
            pivot = new int[m];
            CallChecker.varAssign(this.pivot, "this.pivot", 94, 4051, 4069);
            cachedL = null;
            CallChecker.varAssign(this.cachedL, "this.cachedL", 95, 4079, 4093);
            cachedU = null;
            CallChecker.varAssign(this.cachedU, "this.cachedU", 96, 4103, 4117);
            cachedP = null;
            CallChecker.varAssign(this.cachedP, "this.cachedP", 97, 4127, 4141);
            for (int row = 0; row < m; row++) {
                if (CallChecker.beforeDeref(pivot, int[].class, 101, 4251, 4255)) {
                    CallChecker.isCalled(pivot, int[].class, 101, 4251, 4255)[row] = row;
                    CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 101, 4251, 4255)[row], "CallChecker.isCalled(this.pivot, int[].class, 101, 4251, 4255)[row]", 101, 4251, 4267);
                }
            }
            even = true;
            CallChecker.varAssign(this.even, "this.even", 103, 4287, 4302);
            singular = false;
            CallChecker.varAssign(this.singular, "this.singular", 104, 4312, 4328);
            for (int col = 0; col < m; col++) {
                for (int row = 0; row < col; row++) {
                    final double[] luRow = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 111, 4515, 4516)[row], "luRow", 111, 4492, 4522);
                    double sum = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(luRow, double[].class, 112, 4553, 4557)) {
                        sum = CallChecker.isCalled(luRow, double[].class, 112, 4553, 4557)[col];
                        CallChecker.varAssign(sum, "sum", 112, 4553, 4557);
                    }
                    for (int i = 0; i < row; i++) {
                        if (CallChecker.beforeDeref(luRow, double[].class, 114, 4640, 4644)) {
                            if (CallChecker.beforeDeref(lu, double[][].class, 114, 4651, 4652)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 114, 4651, 4652)[i], double[].class, 114, 4651, 4655)) {
                                    CallChecker.isCalled(lu, double[][].class, 114, 4651, 4652)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 114, 4651, 4652)[i], double[].class, 114, 4651, 4655);
                                    sum -= (CallChecker.isCalled(luRow, double[].class, 114, 4640, 4644)[i]) * (CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 114, 4651, 4652)[i], double[].class, 114, 4651, 4655)[col]);
                                    CallChecker.varAssign(sum, "sum", 114, 4633, 4661);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(luRow, double[].class, 116, 4697, 4701)) {
                        CallChecker.isCalled(luRow, double[].class, 116, 4697, 4701)[col] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(luRow, double[].class, 116, 4697, 4701)[col], "CallChecker.isCalled(luRow, double[].class, 116, 4697, 4701)[col]", 116, 4697, 4713);
                    }
                }
                int max = CallChecker.varInit(((int) (col)), "max", 120, 4763, 4776);
                double largest = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "largest", 121, 4809, 4850);
                for (int row = col; row < m; row++) {
                    final double[] luRow = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 123, 4941, 4942)[row], "luRow", 123, 4918, 4948);
                    double sum = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(luRow, double[].class, 124, 4979, 4983)) {
                        sum = CallChecker.isCalled(luRow, double[].class, 124, 4979, 4983)[col];
                        CallChecker.varAssign(sum, "sum", 124, 4979, 4983);
                    }
                    for (int i = 0; i < col; i++) {
                        if (CallChecker.beforeDeref(luRow, double[].class, 126, 5066, 5070)) {
                            if (CallChecker.beforeDeref(lu, double[][].class, 126, 5077, 5078)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 126, 5077, 5078)[i], double[].class, 126, 5077, 5081)) {
                                    CallChecker.isCalled(lu, double[][].class, 126, 5077, 5078)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 126, 5077, 5078)[i], double[].class, 126, 5077, 5081);
                                    sum -= (CallChecker.isCalled(luRow, double[].class, 126, 5066, 5070)[i]) * (CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 126, 5077, 5078)[i], double[].class, 126, 5077, 5081)[col]);
                                    CallChecker.varAssign(sum, "sum", 126, 5059, 5087);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(luRow, double[].class, 128, 5123, 5127)) {
                        CallChecker.isCalled(luRow, double[].class, 128, 5123, 5127)[col] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(luRow, double[].class, 128, 5123, 5127)[col], "CallChecker.isCalled(luRow, double[].class, 128, 5123, 5127)[col]", 128, 5123, 5139);
                    }
                    if ((FastMath.abs(sum)) > largest) {
                        largest = FastMath.abs(sum);
                        CallChecker.varAssign(largest, "largest", 132, 5265, 5292);
                        max = row;
                        CallChecker.varAssign(max, "max", 133, 5314, 5323);
                    }
                }
                if (CallChecker.beforeDeref(lu, double[][].class, 138, 5420, 5421)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 138, 5420, 5421)[max], double[].class, 138, 5420, 5426)) {
                        CallChecker.isCalled(lu, double[][].class, 138, 5420, 5421)[max] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 138, 5420, 5421)[max], double[].class, 138, 5420, 5426);
                        if ((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 138, 5420, 5421)[max], double[].class, 138, 5420, 5426)[col])) < singularityThreshold) {
                            singular = true;
                            CallChecker.varAssign(this.singular, "this.singular", 139, 5476, 5491);
                            return ;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (max != col) {
                    double tmp = CallChecker.varInit(((double) (0)), "tmp", 145, 5612, 5626);
                    final double[] luMax = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 146, 5667, 5668)[max], "luMax", 146, 5644, 5674);
                    final double[] luCol = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 147, 5715, 5716)[col], "luCol", 147, 5692, 5722);
                    for (int i = 0; i < m; i++) {
                        if (CallChecker.beforeDeref(luMax, double[].class, 149, 5796, 5800)) {
                            tmp = CallChecker.isCalled(luMax, double[].class, 149, 5796, 5800)[i];
                            CallChecker.varAssign(tmp, "tmp", 149, 5790, 5804);
                        }
                        if (CallChecker.beforeDeref(luMax, double[].class, 150, 5826, 5830)) {
                            if (CallChecker.beforeDeref(luCol, double[].class, 150, 5837, 5841)) {
                                CallChecker.isCalled(luMax, double[].class, 150, 5826, 5830)[i] = CallChecker.isCalled(luCol, double[].class, 150, 5837, 5841)[i];
                                CallChecker.varAssign(CallChecker.isCalled(luMax, double[].class, 150, 5826, 5830)[i], "CallChecker.isCalled(luMax, double[].class, 150, 5826, 5830)[i]", 150, 5826, 5845);
                            }
                        }
                        if (CallChecker.beforeDeref(luCol, double[].class, 151, 5867, 5871)) {
                            CallChecker.isCalled(luCol, double[].class, 151, 5867, 5871)[i] = tmp;
                            CallChecker.varAssign(CallChecker.isCalled(luCol, double[].class, 151, 5867, 5871)[i], "CallChecker.isCalled(luCol, double[].class, 151, 5867, 5871)[i]", 151, 5867, 5881);
                        }
                    }
                    int temp = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(pivot, int[].class, 153, 5928, 5932)) {
                        temp = CallChecker.isCalled(pivot, int[].class, 153, 5928, 5932)[max];
                        CallChecker.varAssign(temp, "temp", 153, 5928, 5932);
                    }
                    if (CallChecker.beforeDeref(pivot, int[].class, 154, 5956, 5960)) {
                        if (CallChecker.beforeDeref(pivot, int[].class, 154, 5969, 5973)) {
                            CallChecker.isCalled(pivot, int[].class, 154, 5956, 5960)[max] = CallChecker.isCalled(pivot, int[].class, 154, 5969, 5973)[col];
                            CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 154, 5956, 5960)[max], "CallChecker.isCalled(this.pivot, int[].class, 154, 5956, 5960)[max]", 154, 5956, 5979);
                        }
                    }
                    if (CallChecker.beforeDeref(pivot, int[].class, 155, 5997, 6001)) {
                        CallChecker.isCalled(pivot, int[].class, 155, 5997, 6001)[col] = temp;
                        CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 155, 5997, 6001)[col], "CallChecker.isCalled(this.pivot, int[].class, 155, 5997, 6001)[col]", 155, 5997, 6014);
                    }
                    even = !(even);
                    CallChecker.varAssign(this.even, "this.even", 156, 6032, 6044);
                }
                CallChecker.isCalled(lu, double[][].class, 160, 6167, 6168)[col] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 160, 6167, 6168)[col], double[].class, 160, 6167, 6173);
                final double luDiag = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 160, 6167, 6168)[col], double[].class, 160, 6167, 6173)[col])), "luDiag", 160, 6073, 6179);
                for (int row = col + 1; row < m; row++) {
                    if (CallChecker.beforeDeref(lu, double[][].class, 162, 6251, 6252)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 162, 6251, 6252)[row], double[].class, 162, 6251, 6257)) {
                            CallChecker.isCalled(lu, double[][].class, 162, 6251, 6252)[row] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 162, 6251, 6252)[row], double[].class, 162, 6251, 6257);
                            CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 162, 6251, 6252)[row], double[].class, 162, 6251, 6257)[col] /= luDiag;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 162, 6251, 6252)[row], double[].class, 162, 6251, 6257)[col], "CallChecker.isCalled(CallChecker.isCalled(this.lu, double[][].class, 162, 6251, 6252)[row], double[].class, 162, 6251, 6257)[col]", 162, 6251, 6273);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context336.methodEnd();
        }
    }

    public RealMatrix getL() {
        MethodContext _bcornu_methode_context1554 = new MethodContext(RealMatrix.class, 172, 6310, 6962);
        try {
            CallChecker.varInit(this, "this", 172, 6310, 6962);
            CallChecker.varInit(this.cachedP, "cachedP", 172, 6310, 6962);
            CallChecker.varInit(this.cachedU, "cachedU", 172, 6310, 6962);
            CallChecker.varInit(this.cachedL, "cachedL", 172, 6310, 6962);
            CallChecker.varInit(this.singular, "singular", 172, 6310, 6962);
            CallChecker.varInit(this.even, "even", 172, 6310, 6962);
            CallChecker.varInit(this.pivot, "pivot", 172, 6310, 6962);
            CallChecker.varInit(this.lu, "lu", 172, 6310, 6962);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 172, 6310, 6962);
            if (((cachedL) == null) && (!(singular))) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 174, 6591, 6595).length)), "m", 174, 6577, 6603);
                cachedL = MatrixUtils.createRealMatrix(m, m);
                CallChecker.varAssign(this.cachedL, "this.cachedL", 175, 6617, 6661);
                for (int i = 0; i < m; ++i) {
                    final double[] luI = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 177, 6742, 6743)[i], "luI", 177, 6721, 6747);
                    for (int j = 0; j < i; ++j) {
                        if (CallChecker.beforeDeref(luI, double[].class, 179, 6838, 6840)) {
                            if (CallChecker.beforeDeref(cachedL, RealMatrix.class, 179, 6815, 6821)) {
                                cachedL = CallChecker.beforeCalled(cachedL, RealMatrix.class, 179, 6815, 6821);
                                CallChecker.isCalled(cachedL, RealMatrix.class, 179, 6815, 6821).setEntry(i, j, CallChecker.isCalled(luI, double[].class, 179, 6838, 6840)[j]);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(cachedL, RealMatrix.class, 181, 6881, 6887)) {
                        cachedL = CallChecker.beforeCalled(cachedL, RealMatrix.class, 181, 6881, 6887);
                        CallChecker.isCalled(cachedL, RealMatrix.class, 181, 6881, 6887).setEntry(i, i, 1.0);
                    }
                }
            }
            return cachedL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1554.methodEnd();
        }
    }

    public RealMatrix getU() {
        MethodContext _bcornu_methode_context1555 = new MethodContext(RealMatrix.class, 192, 6969, 7577);
        try {
            CallChecker.varInit(this, "this", 192, 6969, 7577);
            CallChecker.varInit(this.cachedP, "cachedP", 192, 6969, 7577);
            CallChecker.varInit(this.cachedU, "cachedU", 192, 6969, 7577);
            CallChecker.varInit(this.cachedL, "cachedL", 192, 6969, 7577);
            CallChecker.varInit(this.singular, "singular", 192, 6969, 7577);
            CallChecker.varInit(this.even, "even", 192, 6969, 7577);
            CallChecker.varInit(this.pivot, "pivot", 192, 6969, 7577);
            CallChecker.varInit(this.lu, "lu", 192, 6969, 7577);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 192, 6969, 7577);
            if (((cachedU) == null) && (!(singular))) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 194, 7251, 7255).length)), "m", 194, 7237, 7263);
                cachedU = MatrixUtils.createRealMatrix(m, m);
                CallChecker.varAssign(this.cachedU, "this.cachedU", 195, 7277, 7321);
                for (int i = 0; i < m; ++i) {
                    final double[] luI = CallChecker.varInit(CallChecker.isCalled(lu, double[][].class, 197, 7402, 7403)[i], "luI", 197, 7381, 7407);
                    for (int j = i; j < m; ++j) {
                        if (CallChecker.beforeDeref(luI, double[].class, 199, 7498, 7500)) {
                            if (CallChecker.beforeDeref(cachedU, RealMatrix.class, 199, 7475, 7481)) {
                                cachedU = CallChecker.beforeCalled(cachedU, RealMatrix.class, 199, 7475, 7481);
                                CallChecker.isCalled(cachedU, RealMatrix.class, 199, 7475, 7481).setEntry(i, j, CallChecker.isCalled(luI, double[].class, 199, 7498, 7500)[j]);
                            }
                        }
                    }
                }
            }
            return cachedU;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1555.methodEnd();
        }
    }

    public RealMatrix getP() {
        MethodContext _bcornu_methode_context1556 = new MethodContext(RealMatrix.class, 215, 7584, 8335);
        try {
            CallChecker.varInit(this, "this", 215, 7584, 8335);
            CallChecker.varInit(this.cachedP, "cachedP", 215, 7584, 8335);
            CallChecker.varInit(this.cachedU, "cachedU", 215, 7584, 8335);
            CallChecker.varInit(this.cachedL, "cachedL", 215, 7584, 8335);
            CallChecker.varInit(this.singular, "singular", 215, 7584, 8335);
            CallChecker.varInit(this.even, "even", 215, 7584, 8335);
            CallChecker.varInit(this.pivot, "pivot", 215, 7584, 8335);
            CallChecker.varInit(this.lu, "lu", 215, 7584, 8335);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 215, 7584, 8335);
            if (((cachedP) == null) && (!(singular))) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 217, 8117, 8121).length)), "m", 217, 8103, 8129);
                cachedP = MatrixUtils.createRealMatrix(m, m);
                CallChecker.varAssign(this.cachedP, "this.cachedP", 218, 8143, 8187);
                for (int i = 0; i < m; ++i) {
                    if (CallChecker.beforeDeref(pivot, int[].class, 220, 8267, 8271)) {
                        if (CallChecker.beforeDeref(cachedP, RealMatrix.class, 220, 8247, 8253)) {
                            cachedP = CallChecker.beforeCalled(cachedP, RealMatrix.class, 220, 8247, 8253);
                            CallChecker.isCalled(cachedP, RealMatrix.class, 220, 8247, 8253).setEntry(i, CallChecker.isCalled(pivot, int[].class, 220, 8267, 8271)[i], 1.0);
                        }
                    }
                }
            }
            return cachedP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1556.methodEnd();
        }
    }

    public int[] getPivot() {
        MethodContext _bcornu_methode_context1557 = new MethodContext(int[].class, 231, 8342, 8527);
        try {
            CallChecker.varInit(this, "this", 231, 8342, 8527);
            CallChecker.varInit(this.cachedP, "cachedP", 231, 8342, 8527);
            CallChecker.varInit(this.cachedU, "cachedU", 231, 8342, 8527);
            CallChecker.varInit(this.cachedL, "cachedL", 231, 8342, 8527);
            CallChecker.varInit(this.singular, "singular", 231, 8342, 8527);
            CallChecker.varInit(this.even, "even", 231, 8342, 8527);
            CallChecker.varInit(this.pivot, "pivot", 231, 8342, 8527);
            CallChecker.varInit(this.lu, "lu", 231, 8342, 8527);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 231, 8342, 8527);
            if (CallChecker.beforeDeref(pivot, int[].class, 232, 8508, 8512)) {
                return CallChecker.isCalled(pivot, int[].class, 232, 8508, 8512).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1557.methodEnd();
        }
    }

    public double getDeterminant() {
        MethodContext _bcornu_methode_context1558 = new MethodContext(double.class, 239, 8534, 8962);
        try {
            CallChecker.varInit(this, "this", 239, 8534, 8962);
            CallChecker.varInit(this.cachedP, "cachedP", 239, 8534, 8962);
            CallChecker.varInit(this.cachedU, "cachedU", 239, 8534, 8962);
            CallChecker.varInit(this.cachedL, "cachedL", 239, 8534, 8962);
            CallChecker.varInit(this.singular, "singular", 239, 8534, 8962);
            CallChecker.varInit(this.even, "even", 239, 8534, 8962);
            CallChecker.varInit(this.pivot, "pivot", 239, 8534, 8962);
            CallChecker.varInit(this.lu, "lu", 239, 8534, 8962);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 239, 8534, 8962);
            if (singular) {
                return 0;
            }else {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 243, 8757, 8761).length)), "m", 243, 8743, 8769);
                double determinant = CallChecker.init(double.class);
                if (even) {
                    determinant = 1;
                    CallChecker.varAssign(determinant, "determinant", 244, 8804, 8816);
                }else {
                    determinant = -1;
                    CallChecker.varAssign(determinant, "determinant", 244, 8804, 8816);
                }
                for (int i = 0; i < m; i++) {
                    if (CallChecker.beforeDeref(lu, double[][].class, 246, 8892, 8893)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, double[][].class, 246, 8892, 8893)[i], double[].class, 246, 8892, 8896)) {
                            CallChecker.isCalled(lu, double[][].class, 246, 8892, 8893)[i] = CallChecker.beforeCalled(CallChecker.isCalled(lu, double[][].class, 246, 8892, 8893)[i], double[].class, 246, 8892, 8896);
                            determinant *= CallChecker.isCalled(CallChecker.isCalled(lu, double[][].class, 246, 8892, 8893)[i], double[].class, 246, 8892, 8896)[i];
                            CallChecker.varAssign(determinant, "determinant", 246, 8877, 8900);
                        }
                    }
                }
                return determinant;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1558.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context1559 = new MethodContext(DecompositionSolver.class, 257, 8969, 9193);
        try {
            CallChecker.varInit(this, "this", 257, 8969, 9193);
            CallChecker.varInit(this.cachedP, "cachedP", 257, 8969, 9193);
            CallChecker.varInit(this.cachedU, "cachedU", 257, 8969, 9193);
            CallChecker.varInit(this.cachedL, "cachedL", 257, 8969, 9193);
            CallChecker.varInit(this.singular, "singular", 257, 8969, 9193);
            CallChecker.varInit(this.even, "even", 257, 8969, 9193);
            CallChecker.varInit(this.pivot, "pivot", 257, 8969, 9193);
            CallChecker.varInit(this.lu, "lu", 257, 8969, 9193);
            CallChecker.varInit(DEFAULT_TOO_SMALL, "org.apache.commons.math3.linear.LUDecomposition.DEFAULT_TOO_SMALL", 257, 8969, 9193);
            return new LUDecomposition.Solver(lu, pivot, singular);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1559.methodEnd();
        }
    }
}

