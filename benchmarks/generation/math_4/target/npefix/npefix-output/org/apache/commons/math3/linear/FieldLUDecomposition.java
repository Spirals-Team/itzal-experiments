package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.MathArrays;

public class FieldLUDecomposition<T extends FieldElement<T>> {
    private static class Solver<T extends FieldElement<T>> implements FieldDecompositionSolver<T> {
        private final Field<T> field;

        private final T[][] lu;

        private final int[] pivot;

        private final boolean singular;

        private Solver(final Field<T> field, final T[][] lu, final int[] pivot, final boolean singular) {
            ConstructorContext _bcornu_methode_context210 = new ConstructorContext(FieldLUDecomposition.Solver.class, 282, 9468, 10050);
            try {
                this.field = field;
                CallChecker.varAssign(this.field, "this.field", 284, 9914, 9935);
                this.lu = lu;
                CallChecker.varAssign(this.lu, "this.lu", 285, 9949, 9967);
                this.pivot = pivot;
                CallChecker.varAssign(this.pivot, "this.pivot", 286, 9981, 10002);
                this.singular = singular;
                CallChecker.varAssign(this.singular, "this.singular", 287, 10016, 10040);
            } finally {
                _bcornu_methode_context210.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context835 = new MethodContext(boolean.class, 291, 10061, 10161);
            try {
                CallChecker.varInit(this, "this", 291, 10061, 10161);
                CallChecker.varInit(this.singular, "singular", 291, 10061, 10161);
                CallChecker.varInit(this.pivot, "pivot", 291, 10061, 10161);
                CallChecker.varInit(this.lu, "lu", 291, 10061, 10161);
                CallChecker.varInit(this.field, "field", 291, 10061, 10161);
                return !(singular);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context835.methodEnd();
            }
        }

        public FieldVector<T> solve(FieldVector<T> b) {
            MethodContext _bcornu_methode_context836 = new MethodContext(FieldVector.class, 296, 10172, 11650);
            try {
                CallChecker.varInit(this, "this", 296, 10172, 11650);
                CallChecker.varInit(b, "b", 296, 10172, 11650);
                CallChecker.varInit(this.singular, "singular", 296, 10172, 11650);
                CallChecker.varInit(this.pivot, "pivot", 296, 10172, 11650);
                CallChecker.varInit(this.lu, "lu", 296, 10172, 11650);
                CallChecker.varInit(this.field, "field", 296, 10172, 11650);
                TryContext _bcornu_try_context_13 = new TryContext(13, FieldLUDecomposition.class, "java.lang.ClassCastException");
                try {
                    return solve(((ArrayFieldVector<T>) (b)));
                } catch (ClassCastException cce) {
                    _bcornu_try_context_13.catchStart(13);
                    final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 301, 10400, 10404).length)), "m", 301, 10386, 10412);
                    if (CallChecker.beforeDeref(b, FieldVector.class, 302, 10434, 10434)) {
                        b = CallChecker.beforeCalled(b, FieldVector.class, 302, 10434, 10434);
                        if ((CallChecker.isCalled(b, FieldVector.class, 302, 10434, 10434).getDimension()) != m) {
                            if (CallChecker.beforeDeref(b, FieldVector.class, 303, 10516, 10516)) {
                                b = CallChecker.beforeCalled(b, FieldVector.class, 303, 10516, 10516);
                                throw new DimensionMismatchException(CallChecker.isCalled(b, FieldVector.class, 303, 10516, 10516).getDimension(), m);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (singular) {
                        throw new SingularMatrixException();
                    }
                    final T[] bp = CallChecker.varInit(MathArrays.buildArray(field, m), "bp", 310, 10723, 10769);
                    for (int row = 0; row < m; row++) {
                        if (CallChecker.beforeDeref(bp, null, 312, 10843, 10844)) {
                            if (CallChecker.beforeDeref(pivot, int[].class, 312, 10864, 10868)) {
                                if (CallChecker.beforeDeref(b, FieldVector.class, 312, 10853, 10853)) {
                                    bp[row] = b.getEntry(CallChecker.isCalled(pivot, int[].class, 312, 10864, 10868)[row]);
                                    CallChecker.varAssign(bp[row], "bp[row]", 312, 10843, 10875);
                                }
                            }
                        }
                    }
                    for (int col = 0; col < m; col++) {
                        final T bpCol = CallChecker.varInit(bp[col], "bpCol", 317, 11000, 11023);
                        for (int i = col + 1; i < m; i++) {
                            if (CallChecker.beforeDeref(bp, null, 319, 11105, 11106)) {
                                if (CallChecker.beforeDeref(bp, null, 319, 11113, 11114)) {
                                    if (CallChecker.beforeDeref(lu, null, 319, 11143, 11144)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 319, 11143, 11144)[i], null, 319, 11143, 11147)) {
                                            if (CallChecker.beforeDeref(bpCol, null, 319, 11128, 11132)) {
                                                if (CallChecker.beforeDeref(bp[i], null, 319, 11113, 11117)) {
                                                    bp[i] = bp[i].subtract(bpCol.multiply(CallChecker.isCalled(lu, null, 319, 11143, 11144)[i][col]));
                                                    CallChecker.varAssign(bp[i], "bp[i]", 319, 11105, 11155);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int col = m - 1; col >= 0; col--) {
                        if (CallChecker.beforeDeref(bp, null, 325, 11307, 11308)) {
                            if (CallChecker.beforeDeref(bp, null, 325, 11317, 11318)) {
                                if (CallChecker.beforeDeref(lu, null, 325, 11332, 11333)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 325, 11332, 11333)[col], null, 325, 11332, 11338)) {
                                        if (CallChecker.beforeDeref(bp[col], null, 325, 11317, 11323)) {
                                            bp[col] = bp[col].divide(CallChecker.isCalled(lu, null, 325, 11332, 11333)[col][col]);
                                            CallChecker.varAssign(bp[col], "bp[col]", 325, 11307, 11345);
                                        }
                                    }
                                }
                            }
                        }
                        final T bpCol = CallChecker.varInit(bp[col], "bpCol", 326, 11367, 11390);
                        for (int i = 0; i < col; i++) {
                            if (CallChecker.beforeDeref(bp, null, 328, 11468, 11469)) {
                                if (CallChecker.beforeDeref(bp, null, 328, 11476, 11477)) {
                                    if (CallChecker.beforeDeref(lu, null, 328, 11506, 11507)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 328, 11506, 11507)[i], null, 328, 11506, 11510)) {
                                            if (CallChecker.beforeDeref(bpCol, null, 328, 11491, 11495)) {
                                                if (CallChecker.beforeDeref(bp[i], null, 328, 11476, 11480)) {
                                                    bp[i] = bp[i].subtract(bpCol.multiply(CallChecker.isCalled(lu, null, 328, 11506, 11507)[i][col]));
                                                    CallChecker.varAssign(bp[i], "bp[i]", 328, 11468, 11518);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return new ArrayFieldVector<T>(field, bp, false);
                } finally {
                    _bcornu_try_context_13.finallyStart(13);
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context836.methodEnd();
            }
        }

        public ArrayFieldVector<T> solve(ArrayFieldVector<T> b) {
            MethodContext _bcornu_methode_context837 = new MethodContext(ArrayFieldVector.class, 344, 11661, 13309);
            try {
                CallChecker.varInit(this, "this", 344, 11661, 13309);
                CallChecker.varInit(b, "b", 344, 11661, 13309);
                CallChecker.varInit(this.singular, "singular", 344, 11661, 13309);
                CallChecker.varInit(this.pivot, "pivot", 344, 11661, 13309);
                CallChecker.varInit(this.lu, "lu", 344, 11661, 13309);
                CallChecker.varInit(this.field, "field", 344, 11661, 13309);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 345, 12160, 12164).length)), "m", 345, 12146, 12172);
                b = CallChecker.beforeCalled(b, ArrayFieldVector.class, 346, 12205, 12205);
                final int length = CallChecker.varInit(((int) (CallChecker.isCalled(b, ArrayFieldVector.class, 346, 12205, 12205).getDimension())), "length", 346, 12186, 12221);
                if (length != m) {
                    throw new DimensionMismatchException(length, m);
                }
                if (singular) {
                    throw new SingularMatrixException();
                }
                final T[] bp = CallChecker.varInit(MathArrays.buildArray(field, m), "bp", 355, 12480, 12526);
                for (int row = 0; row < m; row++) {
                    if (CallChecker.beforeDeref(bp, null, 357, 12592, 12593)) {
                        if (CallChecker.beforeDeref(pivot, int[].class, 357, 12613, 12617)) {
                            if (CallChecker.beforeDeref(b, ArrayFieldVector.class, 357, 12602, 12602)) {
                                bp[row] = b.getEntry(CallChecker.isCalled(pivot, int[].class, 357, 12613, 12617)[row]);
                                CallChecker.varAssign(bp[row], "bp[row]", 357, 12592, 12624);
                            }
                        }
                    }
                }
                for (int col = 0; col < m; col++) {
                    final T bpCol = CallChecker.varInit(bp[col], "bpCol", 362, 12733, 12756);
                    for (int i = col + 1; i < m; i++) {
                        if (CallChecker.beforeDeref(bp, null, 364, 12830, 12831)) {
                            if (CallChecker.beforeDeref(bp, null, 364, 12838, 12839)) {
                                if (CallChecker.beforeDeref(lu, null, 364, 12868, 12869)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 364, 12868, 12869)[i], null, 364, 12868, 12872)) {
                                        if (CallChecker.beforeDeref(bpCol, null, 364, 12853, 12857)) {
                                            if (CallChecker.beforeDeref(bp[i], null, 364, 12838, 12842)) {
                                                bp[i] = bp[i].subtract(bpCol.multiply(CallChecker.isCalled(lu, null, 364, 12868, 12869)[i][col]));
                                                CallChecker.varAssign(bp[i], "bp[i]", 364, 12830, 12880);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for (int col = m - 1; col >= 0; col--) {
                    if (CallChecker.beforeDeref(bp, null, 370, 13012, 13013)) {
                        if (CallChecker.beforeDeref(bp, null, 370, 13022, 13023)) {
                            if (CallChecker.beforeDeref(lu, null, 370, 13037, 13038)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 370, 13037, 13038)[col], null, 370, 13037, 13043)) {
                                    if (CallChecker.beforeDeref(bp[col], null, 370, 13022, 13028)) {
                                        bp[col] = bp[col].divide(CallChecker.isCalled(lu, null, 370, 13037, 13038)[col][col]);
                                        CallChecker.varAssign(bp[col], "bp[col]", 370, 13012, 13050);
                                    }
                                }
                            }
                        }
                    }
                    final T bpCol = CallChecker.varInit(bp[col], "bpCol", 371, 13068, 13091);
                    for (int i = 0; i < col; i++) {
                        if (CallChecker.beforeDeref(bp, null, 373, 13161, 13162)) {
                            if (CallChecker.beforeDeref(bp, null, 373, 13169, 13170)) {
                                if (CallChecker.beforeDeref(lu, null, 373, 13199, 13200)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 373, 13199, 13200)[i], null, 373, 13199, 13203)) {
                                        if (CallChecker.beforeDeref(bpCol, null, 373, 13184, 13188)) {
                                            if (CallChecker.beforeDeref(bp[i], null, 373, 13169, 13173)) {
                                                bp[i] = bp[i].subtract(bpCol.multiply(CallChecker.isCalled(lu, null, 373, 13199, 13200)[i][col]));
                                                CallChecker.varAssign(bp[i], "bp[i]", 373, 13161, 13211);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return new ArrayFieldVector<T>(bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context837.methodEnd();
            }
        }

        public FieldMatrix<T> solve(FieldMatrix<T> b) {
            MethodContext _bcornu_methode_context838 = new MethodContext(FieldMatrix.class, 381, 13320, 15259);
            try {
                CallChecker.varInit(this, "this", 381, 13320, 15259);
                CallChecker.varInit(b, "b", 381, 13320, 15259);
                CallChecker.varInit(this.singular, "singular", 381, 13320, 15259);
                CallChecker.varInit(this.pivot, "pivot", 381, 13320, 15259);
                CallChecker.varInit(this.lu, "lu", 381, 13320, 15259);
                CallChecker.varInit(this.field, "field", 381, 13320, 15259);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 382, 13423, 13427).length)), "m", 382, 13409, 13435);
                if (CallChecker.beforeDeref(b, FieldMatrix.class, 383, 13453, 13453)) {
                    b = CallChecker.beforeCalled(b, FieldMatrix.class, 383, 13453, 13453);
                    if ((CallChecker.isCalled(b, FieldMatrix.class, 383, 13453, 13453).getRowDimension()) != m) {
                        if (CallChecker.beforeDeref(b, FieldMatrix.class, 384, 13534, 13534)) {
                            b = CallChecker.beforeCalled(b, FieldMatrix.class, 384, 13534, 13534);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, FieldMatrix.class, 384, 13534, 13534).getRowDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (singular) {
                    throw new SingularMatrixException();
                }
                b = CallChecker.beforeCalled(b, FieldMatrix.class, 390, 13699, 13699);
                final int nColB = CallChecker.varInit(((int) (CallChecker.isCalled(b, FieldMatrix.class, 390, 13699, 13699).getColumnDimension())), "nColB", 390, 13681, 13721);
                final T[][] bp = CallChecker.varInit(MathArrays.buildArray(field, m, nColB), "bp", 393, 13775, 13830);
                for (int row = 0; row < m; row++) {
                    final T[] bpRow = CallChecker.varInit(CallChecker.isCalled(bp, null, 395, 13914, 13915)[row], "bpRow", 395, 13896, 13921);
                    final int pRow = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 396, 13956, 13960)[row])), "pRow", 396, 13939, 13966);
                    for (int col = 0; col < nColB; col++) {
                        if (CallChecker.beforeDeref(bpRow, null, 398, 14044, 14048)) {
                            if (CallChecker.beforeDeref(b, FieldMatrix.class, 398, 14057, 14057)) {
                                bpRow[col] = b.getEntry(pRow, col);
                                CallChecker.varAssign(bpRow[col], "bpRow[col]", 398, 14044, 14078);
                            }
                        }
                    }
                }
                for (int col = 0; col < m; col++) {
                    final T[] bpCol = CallChecker.varInit(CallChecker.isCalled(bp, null, 404, 14223, 14224)[col], "bpCol", 404, 14205, 14230);
                    for (int i = col + 1; i < m; i++) {
                        final T[] bpI = CallChecker.varInit(CallChecker.isCalled(bp, null, 406, 14320, 14321)[i], "bpI", 406, 14304, 14325);
                        final T luICol = CallChecker.varInit(CallChecker.isCalled(lu, null, 407, 14364, 14365)[i][col], "luICol", 407, 14347, 14374);
                        for (int j = 0; j < nColB; j++) {
                            if (CallChecker.beforeDeref(bpI, null, 409, 14454, 14456)) {
                                if (CallChecker.beforeDeref(bpI, null, 409, 14463, 14465)) {
                                    if (CallChecker.beforeDeref(bpCol, null, 409, 14479, 14483)) {
                                        if (CallChecker.beforeDeref(bpCol[j], null, 409, 14479, 14486)) {
                                            if (CallChecker.beforeDeref(bpI[j], null, 409, 14463, 14468)) {
                                                bpI[j] = bpI[j].subtract(bpCol[j].multiply(luICol));
                                                CallChecker.varAssign(bpI[j], "bpI[j]", 409, 14454, 14505);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for (int col = m - 1; col >= 0; col--) {
                    final T[] bpCol = CallChecker.varInit(CallChecker.isCalled(bp, null, 416, 14677, 14678)[col], "bpCol", 416, 14659, 14684);
                    final T luDiag = CallChecker.varInit(CallChecker.isCalled(lu, null, 417, 14719, 14720)[col][col], "luDiag", 417, 14702, 14731);
                    for (int j = 0; j < nColB; j++) {
                        if (CallChecker.beforeDeref(bpCol, null, 419, 14803, 14807)) {
                            if (CallChecker.beforeDeref(bpCol, null, 419, 14814, 14818)) {
                                if (CallChecker.beforeDeref(bpCol[j], null, 419, 14814, 14821)) {
                                    bpCol[j] = bpCol[j].divide(luDiag);
                                    CallChecker.varAssign(bpCol[j], "bpCol[j]", 419, 14803, 14837);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < col; i++) {
                        final T[] bpI = CallChecker.varInit(CallChecker.isCalled(bp, null, 422, 14941, 14942)[i], "bpI", 422, 14925, 14946);
                        final T luICol = CallChecker.varInit(CallChecker.isCalled(lu, null, 423, 14985, 14986)[i][col], "luICol", 423, 14968, 14995);
                        for (int j = 0; j < nColB; j++) {
                            if (CallChecker.beforeDeref(bpI, null, 425, 15075, 15077)) {
                                if (CallChecker.beforeDeref(bpI, null, 425, 15084, 15086)) {
                                    if (CallChecker.beforeDeref(bpCol, null, 425, 15100, 15104)) {
                                        if (CallChecker.beforeDeref(bpCol[j], null, 425, 15100, 15107)) {
                                            if (CallChecker.beforeDeref(bpI[j], null, 425, 15084, 15089)) {
                                                bpI[j] = bpI[j].subtract(bpCol[j].multiply(luICol));
                                                CallChecker.varAssign(bpI[j], "bpI[j]", 425, 15075, 15126);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return new Array2DRowFieldMatrix<T>(field, bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context838.methodEnd();
            }
        }

        public FieldMatrix<T> getInverse() {
            MethodContext _bcornu_methode_context839 = new MethodContext(FieldMatrix.class, 435, 15270, 15645);
            try {
                CallChecker.varInit(this, "this", 435, 15270, 15645);
                CallChecker.varInit(this.singular, "singular", 435, 15270, 15645);
                CallChecker.varInit(this.pivot, "pivot", 435, 15270, 15645);
                CallChecker.varInit(this.lu, "lu", 435, 15270, 15645);
                CallChecker.varInit(this.field, "field", 435, 15270, 15645);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 436, 15362, 15366).length)), "m", 436, 15348, 15374);
                final T one = CallChecker.varInit(field.getOne(), "one", 437, 15388, 15416);
                FieldMatrix<T> identity = CallChecker.varInit(new Array2DRowFieldMatrix<T>(field, m, m), "identity", 438, 15430, 15497);
                for (int i = 0; i < m; ++i) {
                    if (CallChecker.beforeDeref(identity, FieldMatrix.class, 440, 15557, 15564)) {
                        identity = CallChecker.beforeCalled(identity, FieldMatrix.class, 440, 15557, 15564);
                        CallChecker.isCalled(identity, FieldMatrix.class, 440, 15557, 15564).setEntry(i, i, one);
                    }
                }
                return solve(identity);
            } catch (ForceReturn _bcornu_return_t) {
                return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context839.methodEnd();
            }
        }
    }

    private final Field<T> field;

    private T[][] lu;

    private int[] pivot;

    private boolean even;

    private boolean singular;

    private FieldMatrix<T> cachedL;

    private FieldMatrix<T> cachedU;

    private FieldMatrix<T> cachedP;

    public FieldLUDecomposition(FieldMatrix<T> matrix) {
        ConstructorContext _bcornu_methode_context211 = new ConstructorContext(FieldLUDecomposition.class, 85, 3201, 5953);
        try {
            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 86, 3453, 3458)) {
                matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 86, 3453, 3458);
                if (!(CallChecker.isCalled(matrix, FieldMatrix.class, 86, 3453, 3458).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 87, 3521, 3526)) {
                        if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 88, 3594, 3599)) {
                            matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 87, 3521, 3526);
                            matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 88, 3594, 3599);
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, FieldMatrix.class, 87, 3521, 3526).getRowDimension(), CallChecker.isCalled(matrix, FieldMatrix.class, 88, 3594, 3599).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 91, 3657, 3662);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, FieldMatrix.class, 91, 3657, 3662).getColumnDimension())), "m", 91, 3643, 3684);
            matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 92, 3702, 3707);
            field = CallChecker.isCalled(matrix, FieldMatrix.class, 92, 3702, 3707).getField();
            CallChecker.varAssign(this.field, "this.field", 92, 3694, 3719);
            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 93, 3734, 3739)) {
                matrix = CallChecker.beforeCalled(matrix, FieldMatrix.class, 93, 3734, 3739);
                lu = CallChecker.isCalled(matrix, FieldMatrix.class, 93, 3734, 3739).getData();
                CallChecker.varAssign(this.lu, "this.lu", 93, 3729, 3750);
            }
            pivot = new int[m];
            CallChecker.varAssign(this.pivot, "this.pivot", 94, 3760, 3778);
            cachedL = null;
            CallChecker.varAssign(this.cachedL, "this.cachedL", 95, 3788, 3802);
            cachedU = null;
            CallChecker.varAssign(this.cachedU, "this.cachedU", 96, 3812, 3826);
            cachedP = null;
            CallChecker.varAssign(this.cachedP, "this.cachedP", 97, 3836, 3850);
            for (int row = 0; row < m; row++) {
                if (CallChecker.beforeDeref(pivot, int[].class, 101, 3960, 3964)) {
                    pivot = CallChecker.beforeCalled(pivot, int[].class, 101, 3960, 3964);
                    CallChecker.isCalled(pivot, int[].class, 101, 3960, 3964)[row] = row;
                    CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 101, 3960, 3964)[row], "CallChecker.isCalled(this.pivot, int[].class, 101, 3960, 3964)[row]", 101, 3960, 3976);
                }
            }
            even = true;
            CallChecker.varAssign(this.even, "this.even", 103, 3996, 4011);
            singular = false;
            CallChecker.varAssign(this.singular, "this.singular", 104, 4021, 4037);
            for (int col = 0; col < m; col++) {
                T sum = CallChecker.init(null);
                if (CallChecker.beforeDeref(field, Field.class, 109, 4134, 4138)) {
                    sum = field.getZero();
                    CallChecker.varAssign(sum, "sum", 109, 4134, 4138);
                }
                for (int row = 0; row < col; row++) {
                    lu = CallChecker.beforeCalled(lu, null, 113, 4257, 4258);
                    final T[] luRow = CallChecker.varInit(CallChecker.isCalled(lu, null, 113, 4257, 4258)[row], "luRow", 113, 4239, 4264);
                    if (CallChecker.beforeDeref(luRow, null, 114, 4288, 4292)) {
                        sum = luRow[col];
                        CallChecker.varAssign(sum, "sum", 114, 4282, 4298);
                    }
                    for (int i = 0; i < row; i++) {
                        if (CallChecker.beforeDeref(luRow, null, 116, 4387, 4391)) {
                            if (CallChecker.beforeDeref(lu, null, 116, 4405, 4406)) {
                                lu = CallChecker.beforeCalled(lu, null, 116, 4405, 4406);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 116, 4405, 4406)[i], null, 116, 4405, 4409)) {
                                    if (CallChecker.beforeDeref(luRow[i], null, 116, 4387, 4394)) {
                                        if (CallChecker.beforeDeref(sum, null, 116, 4374, 4376)) {
                                            lu = CallChecker.beforeCalled(lu, null, 116, 4405, 4406);
                                            sum = sum.subtract(luRow[i].multiply(CallChecker.isCalled(lu, null, 116, 4405, 4406)[i][col]));
                                            CallChecker.varAssign(sum, "sum", 116, 4368, 4417);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(luRow, null, 118, 4453, 4457)) {
                        luRow[col] = sum;
                        CallChecker.varAssign(luRow[col], "luRow[col]", 118, 4453, 4469);
                    }
                }
                int nonZero = CallChecker.varInit(((int) (col)), "nonZero", 122, 4519, 4536);
                for (int row = col; row < m; row++) {
                    lu = CallChecker.beforeCalled(lu, null, 124, 4641, 4642);
                    final T[] luRow = CallChecker.varInit(CallChecker.isCalled(lu, null, 124, 4641, 4642)[row], "luRow", 124, 4623, 4648);
                    if (CallChecker.beforeDeref(luRow, null, 125, 4672, 4676)) {
                        sum = luRow[col];
                        CallChecker.varAssign(sum, "sum", 125, 4666, 4682);
                    }
                    for (int i = 0; i < col; i++) {
                        if (CallChecker.beforeDeref(luRow, null, 127, 4771, 4775)) {
                            if (CallChecker.beforeDeref(lu, null, 127, 4789, 4790)) {
                                lu = CallChecker.beforeCalled(lu, null, 127, 4789, 4790);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 127, 4789, 4790)[i], null, 127, 4789, 4793)) {
                                    if (CallChecker.beforeDeref(luRow[i], null, 127, 4771, 4778)) {
                                        if (CallChecker.beforeDeref(sum, null, 127, 4758, 4760)) {
                                            lu = CallChecker.beforeCalled(lu, null, 127, 4789, 4790);
                                            sum = sum.subtract(luRow[i].multiply(CallChecker.isCalled(lu, null, 127, 4789, 4790)[i][col]));
                                            CallChecker.varAssign(sum, "sum", 127, 4752, 4801);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(luRow, null, 129, 4837, 4841)) {
                        luRow[col] = sum;
                        CallChecker.varAssign(luRow[col], "luRow[col]", 129, 4837, 4853);
                    }
                    if (CallChecker.beforeDeref(lu, null, 131, 4876, 4877)) {
                        lu = CallChecker.beforeCalled(lu, null, 131, 4876, 4877);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 131, 4876, 4877)[nonZero], null, 131, 4876, 4886)) {
                            if (CallChecker.beforeDeref(field, Field.class, 131, 4900, 4904)) {
                                lu = CallChecker.beforeCalled(lu, null, 131, 4876, 4877);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 131, 4876, 4877)[nonZero][col], null, 131, 4876, 4891)) {
                                    lu = CallChecker.beforeCalled(lu, null, 131, 4876, 4877);
                                    if (CallChecker.isCalled(lu, null, 131, 4876, 4877)[nonZero][col].equals(field.getZero())) {
                                        ++nonZero;
                                    }
                                }
                            }
                        }
                    }
                }
                if (nonZero >= m) {
                    singular = true;
                    CallChecker.varAssign(this.singular, "this.singular", 139, 5130, 5145);
                    return ;
                }
                if (nonZero != col) {
                    T tmp = CallChecker.init(null);
                    if (CallChecker.beforeDeref(field, Field.class, 145, 5278, 5282)) {
                        tmp = field.getZero();
                        CallChecker.varAssign(tmp, "tmp", 145, 5278, 5282);
                    }
                    for (int i = 0; i < m; i++) {
                        if (CallChecker.beforeDeref(lu, null, 147, 5367, 5368)) {
                            lu = CallChecker.beforeCalled(lu, null, 147, 5367, 5368);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 147, 5367, 5368)[nonZero], null, 147, 5367, 5377)) {
                                lu = CallChecker.beforeCalled(lu, null, 147, 5367, 5368);
                                tmp = CallChecker.isCalled(lu, null, 147, 5367, 5368)[nonZero][i];
                                CallChecker.varAssign(tmp, "tmp", 147, 5361, 5381);
                            }
                        }
                        if (CallChecker.beforeDeref(lu, null, 148, 5403, 5404)) {
                            lu = CallChecker.beforeCalled(lu, null, 148, 5403, 5404);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 148, 5403, 5404)[nonZero], null, 148, 5403, 5413)) {
                                if (CallChecker.beforeDeref(lu, null, 148, 5420, 5421)) {
                                    lu = CallChecker.beforeCalled(lu, null, 148, 5420, 5421);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 148, 5420, 5421)[col], null, 148, 5420, 5426)) {
                                        lu = CallChecker.beforeCalled(lu, null, 148, 5403, 5404);
                                        lu = CallChecker.beforeCalled(lu, null, 148, 5420, 5421);
                                        CallChecker.isCalled(lu, null, 148, 5403, 5404)[nonZero][i] = CallChecker.isCalled(lu, null, 148, 5420, 5421)[col][i];
                                        CallChecker.varAssign(CallChecker.isCalled(this.lu, null, 148, 5403, 5404)[nonZero][i], "CallChecker.isCalled(this.lu, null, 148, 5403, 5404)[nonZero][i]", 148, 5403, 5430);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(lu, null, 149, 5452, 5453)) {
                            lu = CallChecker.beforeCalled(lu, null, 149, 5452, 5453);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 149, 5452, 5453)[col], null, 149, 5452, 5458)) {
                                lu = CallChecker.beforeCalled(lu, null, 149, 5452, 5453);
                                CallChecker.isCalled(lu, null, 149, 5452, 5453)[col][i] = tmp;
                                CallChecker.varAssign(CallChecker.isCalled(this.lu, null, 149, 5452, 5453)[col][i], "CallChecker.isCalled(this.lu, null, 149, 5452, 5453)[col][i]", 149, 5452, 5468);
                            }
                        }
                    }
                    int temp = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(pivot, int[].class, 151, 5515, 5519)) {
                        pivot = CallChecker.beforeCalled(pivot, int[].class, 151, 5515, 5519);
                        temp = CallChecker.isCalled(pivot, int[].class, 151, 5515, 5519)[nonZero];
                        CallChecker.varAssign(temp, "temp", 151, 5515, 5519);
                    }
                    if (CallChecker.beforeDeref(pivot, int[].class, 152, 5547, 5551)) {
                        if (CallChecker.beforeDeref(pivot, int[].class, 152, 5564, 5568)) {
                            pivot = CallChecker.beforeCalled(pivot, int[].class, 152, 5547, 5551);
                            pivot = CallChecker.beforeCalled(pivot, int[].class, 152, 5564, 5568);
                            CallChecker.isCalled(pivot, int[].class, 152, 5547, 5551)[nonZero] = CallChecker.isCalled(pivot, int[].class, 152, 5564, 5568)[col];
                            CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 152, 5547, 5551)[nonZero], "CallChecker.isCalled(this.pivot, int[].class, 152, 5547, 5551)[nonZero]", 152, 5547, 5574);
                        }
                    }
                    if (CallChecker.beforeDeref(pivot, int[].class, 153, 5592, 5596)) {
                        pivot = CallChecker.beforeCalled(pivot, int[].class, 153, 5592, 5596);
                        CallChecker.isCalled(pivot, int[].class, 153, 5592, 5596)[col] = temp;
                        CallChecker.varAssign(CallChecker.isCalled(this.pivot, int[].class, 153, 5592, 5596)[col], "CallChecker.isCalled(this.pivot, int[].class, 153, 5592, 5596)[col]", 153, 5592, 5609);
                    }
                    even = !(even);
                    CallChecker.varAssign(this.even, "this.even", 154, 5627, 5639);
                }
                lu = CallChecker.beforeCalled(lu, null, 158, 5757, 5758);
                final T luDiag = CallChecker.varInit(CallChecker.isCalled(lu, null, 158, 5757, 5758)[col][col], "luDiag", 158, 5668, 5769);
                for (int row = col + 1; row < m; row++) {
                    lu = CallChecker.beforeCalled(lu, null, 160, 5859, 5860);
                    final T[] luRow = CallChecker.varInit(CallChecker.isCalled(lu, null, 160, 5859, 5860)[row], "luRow", 160, 5841, 5866);
                    if (CallChecker.beforeDeref(luRow, null, 161, 5884, 5888)) {
                        if (CallChecker.beforeDeref(luRow, null, 161, 5897, 5901)) {
                            if (CallChecker.beforeDeref(luRow[col], null, 161, 5897, 5906)) {
                                luRow[col] = luRow[col].divide(luDiag);
                                CallChecker.varAssign(luRow[col], "luRow[col]", 161, 5884, 5922);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    public FieldMatrix<T> getL() {
        MethodContext _bcornu_methode_context840 = new MethodContext(FieldMatrix.class, 172, 5960, 6629);
        try {
            CallChecker.varInit(this, "this", 172, 5960, 6629);
            CallChecker.varInit(this.cachedP, "cachedP", 172, 5960, 6629);
            CallChecker.varInit(this.cachedU, "cachedU", 172, 5960, 6629);
            CallChecker.varInit(this.cachedL, "cachedL", 172, 5960, 6629);
            CallChecker.varInit(this.singular, "singular", 172, 5960, 6629);
            CallChecker.varInit(this.even, "even", 172, 5960, 6629);
            CallChecker.varInit(this.pivot, "pivot", 172, 5960, 6629);
            CallChecker.varInit(this.lu, "lu", 172, 5960, 6629);
            CallChecker.varInit(this.field, "field", 172, 5960, 6629);
            if (((cachedL) == null) && (!(singular))) {
                pivot = CallChecker.beforeCalled(pivot, int[].class, 174, 6245, 6249);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 174, 6245, 6249).length)), "m", 174, 6231, 6257);
                cachedL = new Array2DRowFieldMatrix<T>(field, m, m);
                CallChecker.varAssign(this.cachedL, "this.cachedL", 175, 6271, 6322);
                for (int i = 0; i < m; ++i) {
                    lu = CallChecker.beforeCalled(lu, null, 177, 6398, 6399);
                    final T[] luI = CallChecker.varInit(CallChecker.isCalled(lu, null, 177, 6398, 6399)[i], "luI", 177, 6382, 6403);
                    for (int j = 0; j < i; ++j) {
                        if (CallChecker.beforeDeref(luI, null, 179, 6494, 6496)) {
                            if (CallChecker.beforeDeref(cachedL, FieldMatrix.class, 179, 6471, 6477)) {
                                cachedL = CallChecker.beforeCalled(cachedL, FieldMatrix.class, 179, 6471, 6477);
                                CallChecker.isCalled(cachedL, FieldMatrix.class, 179, 6471, 6477).setEntry(i, j, luI[j]);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(field, Field.class, 181, 6560, 6564)) {
                        if (CallChecker.beforeDeref(cachedL, FieldMatrix.class, 181, 6537, 6543)) {
                            cachedL = CallChecker.beforeCalled(cachedL, FieldMatrix.class, 181, 6537, 6543);
                            CallChecker.isCalled(cachedL, FieldMatrix.class, 181, 6537, 6543).setEntry(i, i, field.getOne());
                        }
                    }
                }
            }
            return cachedL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context840.methodEnd();
        }
    }

    public FieldMatrix<T> getU() {
        MethodContext _bcornu_methode_context841 = new MethodContext(FieldMatrix.class, 192, 6636, 7250);
        try {
            CallChecker.varInit(this, "this", 192, 6636, 7250);
            CallChecker.varInit(this.cachedP, "cachedP", 192, 6636, 7250);
            CallChecker.varInit(this.cachedU, "cachedU", 192, 6636, 7250);
            CallChecker.varInit(this.cachedL, "cachedL", 192, 6636, 7250);
            CallChecker.varInit(this.singular, "singular", 192, 6636, 7250);
            CallChecker.varInit(this.even, "even", 192, 6636, 7250);
            CallChecker.varInit(this.pivot, "pivot", 192, 6636, 7250);
            CallChecker.varInit(this.lu, "lu", 192, 6636, 7250);
            CallChecker.varInit(this.field, "field", 192, 6636, 7250);
            if (((cachedU) == null) && (!(singular))) {
                pivot = CallChecker.beforeCalled(pivot, int[].class, 194, 6922, 6926);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 194, 6922, 6926).length)), "m", 194, 6908, 6934);
                cachedU = new Array2DRowFieldMatrix<T>(field, m, m);
                CallChecker.varAssign(this.cachedU, "this.cachedU", 195, 6948, 6999);
                for (int i = 0; i < m; ++i) {
                    lu = CallChecker.beforeCalled(lu, null, 197, 7075, 7076);
                    final T[] luI = CallChecker.varInit(CallChecker.isCalled(lu, null, 197, 7075, 7076)[i], "luI", 197, 7059, 7080);
                    for (int j = i; j < m; ++j) {
                        if (CallChecker.beforeDeref(luI, null, 199, 7171, 7173)) {
                            if (CallChecker.beforeDeref(cachedU, FieldMatrix.class, 199, 7148, 7154)) {
                                cachedU = CallChecker.beforeCalled(cachedU, FieldMatrix.class, 199, 7148, 7154);
                                CallChecker.isCalled(cachedU, FieldMatrix.class, 199, 7148, 7154).setEntry(i, j, luI[j]);
                            }
                        }
                    }
                }
            }
            return cachedU;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context841.methodEnd();
        }
    }

    public FieldMatrix<T> getP() {
        MethodContext _bcornu_methode_context842 = new MethodContext(FieldMatrix.class, 215, 7257, 8030);
        try {
            CallChecker.varInit(this, "this", 215, 7257, 8030);
            CallChecker.varInit(this.cachedP, "cachedP", 215, 7257, 8030);
            CallChecker.varInit(this.cachedU, "cachedU", 215, 7257, 8030);
            CallChecker.varInit(this.cachedL, "cachedL", 215, 7257, 8030);
            CallChecker.varInit(this.singular, "singular", 215, 7257, 8030);
            CallChecker.varInit(this.even, "even", 215, 7257, 8030);
            CallChecker.varInit(this.pivot, "pivot", 215, 7257, 8030);
            CallChecker.varInit(this.lu, "lu", 215, 7257, 8030);
            CallChecker.varInit(this.field, "field", 215, 7257, 8030);
            if (((cachedP) == null) && (!(singular))) {
                pivot = CallChecker.beforeCalled(pivot, int[].class, 217, 7794, 7798);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 217, 7794, 7798).length)), "m", 217, 7780, 7806);
                cachedP = new Array2DRowFieldMatrix<T>(field, m, m);
                CallChecker.varAssign(this.cachedP, "this.cachedP", 218, 7820, 7871);
                for (int i = 0; i < m; ++i) {
                    if (CallChecker.beforeDeref(pivot, int[].class, 220, 7951, 7955)) {
                        if (CallChecker.beforeDeref(field, Field.class, 220, 7961, 7965)) {
                            if (CallChecker.beforeDeref(cachedP, FieldMatrix.class, 220, 7931, 7937)) {
                                pivot = CallChecker.beforeCalled(pivot, int[].class, 220, 7951, 7955);
                                cachedP = CallChecker.beforeCalled(cachedP, FieldMatrix.class, 220, 7931, 7937);
                                CallChecker.isCalled(cachedP, FieldMatrix.class, 220, 7931, 7937).setEntry(i, CallChecker.isCalled(pivot, int[].class, 220, 7951, 7955)[i], field.getOne());
                            }
                        }
                    }
                }
            }
            return cachedP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context842.methodEnd();
        }
    }

    public int[] getPivot() {
        MethodContext _bcornu_methode_context843 = new MethodContext(int[].class, 231, 8037, 8222);
        try {
            CallChecker.varInit(this, "this", 231, 8037, 8222);
            CallChecker.varInit(this.cachedP, "cachedP", 231, 8037, 8222);
            CallChecker.varInit(this.cachedU, "cachedU", 231, 8037, 8222);
            CallChecker.varInit(this.cachedL, "cachedL", 231, 8037, 8222);
            CallChecker.varInit(this.singular, "singular", 231, 8037, 8222);
            CallChecker.varInit(this.even, "even", 231, 8037, 8222);
            CallChecker.varInit(this.pivot, "pivot", 231, 8037, 8222);
            CallChecker.varInit(this.lu, "lu", 231, 8037, 8222);
            CallChecker.varInit(this.field, "field", 231, 8037, 8222);
            if (CallChecker.beforeDeref(pivot, int[].class, 232, 8203, 8207)) {
                pivot = CallChecker.beforeCalled(pivot, int[].class, 232, 8203, 8207);
                return CallChecker.isCalled(pivot, int[].class, 232, 8203, 8207).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context843.methodEnd();
        }
    }

    public T getDeterminant() {
        MethodContext _bcornu_methode_context844 = new MethodContext(null, 239, 8229, 8734);
        try {
            CallChecker.varInit(this, "this", 239, 8229, 8734);
            CallChecker.varInit(this.cachedP, "cachedP", 239, 8229, 8734);
            CallChecker.varInit(this.cachedU, "cachedU", 239, 8229, 8734);
            CallChecker.varInit(this.cachedL, "cachedL", 239, 8229, 8734);
            CallChecker.varInit(this.singular, "singular", 239, 8229, 8734);
            CallChecker.varInit(this.even, "even", 239, 8229, 8734);
            CallChecker.varInit(this.pivot, "pivot", 239, 8229, 8734);
            CallChecker.varInit(this.lu, "lu", 239, 8229, 8734);
            CallChecker.varInit(this.field, "field", 239, 8229, 8734);
            if (singular) {
                if (CallChecker.beforeDeref(field, Field.class, 241, 8402, 8406)) {
                    return field.getZero();
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                pivot = CallChecker.beforeCalled(pivot, int[].class, 243, 8462, 8466);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.pivot, int[].class, 243, 8462, 8466).length)), "m", 243, 8448, 8474);
                T determinant = CallChecker.init(null);
                if (even) {
                    if (CallChecker.beforeDeref(field, Field.class, 244, 8511, 8515)) {
                        determinant = field.getOne();
                        CallChecker.varAssign(determinant, "determinant", 244, 8504, 8567);
                    }
                }else {
                    if (CallChecker.beforeDeref(field, Field.class, 244, 8528, 8532)) {
                        if (CallChecker.beforeDeref(field, Field.class, 244, 8553, 8557)) {
                            final FieldElement<T> npe_invocation_var95 = field.getZero();
                            if (CallChecker.beforeDeref(npe_invocation_var95, FieldElement.class, 244, 8528, 8542)) {
                                determinant = npe_invocation_var95.subtract(field.getOne());
                                CallChecker.varAssign(determinant, "determinant", 244, 8504, 8567);
                            }
                        }
                    }
                }
                for (int i = 0; i < m; i++) {
                    if (CallChecker.beforeDeref(lu, null, 246, 8663, 8664)) {
                        lu = CallChecker.beforeCalled(lu, null, 246, 8663, 8664);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(lu, null, 246, 8663, 8664)[i], null, 246, 8663, 8667)) {
                            if (CallChecker.beforeDeref(determinant, null, 246, 8642, 8652)) {
                                lu = CallChecker.beforeCalled(lu, null, 246, 8663, 8664);
                                determinant = determinant.multiply(CallChecker.isCalled(lu, null, 246, 8663, 8664)[i][i]);
                                CallChecker.varAssign(determinant, "determinant", 246, 8628, 8672);
                            }
                        }
                    }
                }
                return determinant;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context844.methodEnd();
        }
    }

    public FieldDecompositionSolver<T> getSolver() {
        MethodContext _bcornu_methode_context845 = new MethodContext(FieldDecompositionSolver.class, 256, 8741, 8976);
        try {
            CallChecker.varInit(this, "this", 256, 8741, 8976);
            CallChecker.varInit(this.cachedP, "cachedP", 256, 8741, 8976);
            CallChecker.varInit(this.cachedU, "cachedU", 256, 8741, 8976);
            CallChecker.varInit(this.cachedL, "cachedL", 256, 8741, 8976);
            CallChecker.varInit(this.singular, "singular", 256, 8741, 8976);
            CallChecker.varInit(this.even, "even", 256, 8741, 8976);
            CallChecker.varInit(this.pivot, "pivot", 256, 8741, 8976);
            CallChecker.varInit(this.lu, "lu", 256, 8741, 8976);
            CallChecker.varInit(this.field, "field", 256, 8741, 8976);
            return new FieldLUDecomposition.Solver<T>(field, lu, pivot, singular);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldDecompositionSolver<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context845.methodEnd();
        }
    }
}

