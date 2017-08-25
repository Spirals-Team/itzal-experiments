package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class Array2DRowFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    private static final long serialVersionUID = 7260756672015356458L;

    private T[][] data;

    public Array2DRowFieldMatrix(final Field<T> field) {
        super(field);
        ConstructorContext _bcornu_methode_context419 = new ConstructorContext(Array2DRowFieldMatrix.class, 58, 2283, 2470);
        try {
        } finally {
            _bcornu_methode_context419.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final Field<T> field, final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        super(field, rowDimension, columnDimension);
        ConstructorContext _bcornu_methode_context420 = new ConstructorContext(Array2DRowFieldMatrix.class, 70, 2477, 3174);
        try {
            data = MathArrays.buildArray(field, rowDimension, columnDimension);
            CallChecker.varAssign(this.data, "this.data", 74, 3102, 3168);
        } finally {
            _bcornu_methode_context420.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final T[][] d) throws DimensionMismatchException, NoDataException, NullArgumentException {
        this(AbstractFieldMatrix.extractField(d), d);
        ConstructorContext _bcornu_methode_context421 = new ConstructorContext(Array2DRowFieldMatrix.class, 90, 3181, 4029);
        try {
        } finally {
            _bcornu_methode_context421.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final Field<T> field, final T[][] d) throws DimensionMismatchException, NoDataException, NullArgumentException {
        super(field);
        ConstructorContext _bcornu_methode_context422 = new ConstructorContext(Array2DRowFieldMatrix.class, 110, 4036, 4969);
        try {
            copyIn(d);
        } finally {
            _bcornu_methode_context422.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final T[][] d, final boolean copyArray) throws DimensionMismatchException, NoDataException, NullArgumentException {
        this(AbstractFieldMatrix.extractField(d), d, copyArray);
        ConstructorContext _bcornu_methode_context423 = new ConstructorContext(Array2DRowFieldMatrix.class, 132, 4976, 6002);
        try {
        } finally {
            _bcornu_methode_context423.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final Field<T> field, final T[][] d, final boolean copyArray) throws DimensionMismatchException, NoDataException, NullArgumentException {
        super(field);
        ConstructorContext _bcornu_methode_context424 = new ConstructorContext(Array2DRowFieldMatrix.class, 154, 6009, 7748);
        try {
            if (copyArray) {
                copyIn(d);
            }else {
                MathUtils.checkNotNull(d);
                final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(d, null, 161, 7212, 7212).length)), "nRows", 161, 7194, 7220);
                if (nRows == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
                }
                CallChecker.isCalled(d, null, 165, 7374, 7374)[0] = CallChecker.beforeCalled(CallChecker.isCalled(d, null, 165, 7374, 7374)[0], null, 165, 7374, 7377);
                final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(d, null, 165, 7374, 7374)[0], null, 165, 7374, 7377).length)), "nCols", 165, 7356, 7385);
                if (nCols == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
                for (int r = 1; r < nRows; r++) {
                    if (CallChecker.beforeDeref(d, null, 170, 7578, 7578)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, null, 170, 7578, 7578)[r], null, 170, 7578, 7581)) {
                            CallChecker.isCalled(d, null, 170, 7578, 7578)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, null, 170, 7578, 7578)[r], null, 170, 7578, 7581);
                            if ((CallChecker.isCalled(CallChecker.isCalled(d, null, 170, 7578, 7578)[r], null, 170, 7578, 7581).length) != nCols) {
                                if (CallChecker.beforeDeref(d, null, 171, 7666, 7666)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, null, 171, 7666, 7666)[r], null, 171, 7666, 7669)) {
                                        CallChecker.isCalled(d, null, 171, 7666, 7666)[r] = CallChecker.beforeCalled(CallChecker.isCalled(d, null, 171, 7666, 7666)[r], null, 171, 7666, 7669);
                                        throw new DimensionMismatchException(nCols, CallChecker.isCalled(CallChecker.isCalled(d, null, 171, 7666, 7666)[r], null, 171, 7666, 7669).length);
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
                data = d;
                CallChecker.varAssign(this.data, "this.data", 174, 7724, 7732);
            }
        } finally {
            _bcornu_methode_context424.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final T[] v) throws NoDataException {
        this(AbstractFieldMatrix.extractField(v), v);
        ConstructorContext _bcornu_methode_context425 = new ConstructorContext(Array2DRowFieldMatrix.class, 186, 7755, 8153);
        try {
        } finally {
            _bcornu_methode_context425.methodEnd();
        }
    }

    public Array2DRowFieldMatrix(final Field<T> field, final T[] v) {
        super(field);
        ConstructorContext _bcornu_methode_context426 = new ConstructorContext(Array2DRowFieldMatrix.class, 198, 8160, 8745);
        try {
            final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(v, null, 200, 8578, 8578).length)), "nRows", 200, 8560, 8586);
            data = MathArrays.buildArray(getField(), nRows, 1);
            CallChecker.varAssign(this.data, "this.data", 201, 8596, 8646);
            for (int row = 0; row < nRows; row++) {
                if (CallChecker.beforeDeref(data, null, 203, 8708, 8711)) {
                    data = CallChecker.beforeCalled(data, null, 203, 8708, 8711);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 203, 8708, 8711)[row], null, 203, 8708, 8716)) {
                        if (CallChecker.beforeDeref(v, null, 203, 8723, 8723)) {
                            data = CallChecker.beforeCalled(data, null, 203, 8708, 8711);
                            CallChecker.isCalled(data, null, 203, 8708, 8711)[row][0] = v[row];
                            CallChecker.varAssign(CallChecker.isCalled(this.data, null, 203, 8708, 8711)[row][0], "CallChecker.isCalled(this.data, null, 203, 8708, 8711)[row][0]", 203, 8708, 8729);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context426.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> createMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context1792 = new MethodContext(FieldMatrix.class, 209, 8752, 9054);
        try {
            CallChecker.varInit(this, "this", 209, 8752, 9054);
            CallChecker.varInit(columnDimension, "columnDimension", 209, 8752, 9054);
            CallChecker.varInit(rowDimension, "rowDimension", 209, 8752, 9054);
            CallChecker.varInit(this.data, "data", 209, 8752, 9054);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 209, 8752, 9054);
            return new Array2DRowFieldMatrix<T>(getField(), rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1792.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> copy() {
        MethodContext _bcornu_methode_context1793 = new MethodContext(FieldMatrix.class, 217, 9061, 9210);
        try {
            CallChecker.varInit(this, "this", 217, 9061, 9210);
            CallChecker.varInit(this.data, "data", 217, 9061, 9210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 217, 9061, 9210);
            return new Array2DRowFieldMatrix<T>(getField(), copyOut(), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1793.methodEnd();
        }
    }

    public Array2DRowFieldMatrix<T> add(final Array2DRowFieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1794 = new MethodContext(Array2DRowFieldMatrix.class, 229, 9217, 10242);
        try {
            CallChecker.varInit(this, "this", 229, 9217, 10242);
            CallChecker.varInit(m, "m", 229, 9217, 10242);
            CallChecker.varInit(this.data, "data", 229, 9217, 10242);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 229, 9217, 10242);
            checkAdditionCompatible(m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 234, 9640, 9681);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 235, 9691, 9735);
            final T[][] outData = CallChecker.varInit(MathArrays.buildArray(getField(), rowCount, columnCount), "outData", 236, 9745, 9823);
            for (int row = 0; row < rowCount; row++) {
                data = CallChecker.beforeCalled(data, null, 238, 9911, 9914);
                final T[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, null, 238, 9911, 9914)[row], "dataRow", 238, 9888, 9920);
                CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 239, 9957, 9957).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 239, 9957, 9957).data, null, 239, 9957, 9962);
                final T[] mRow = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 239, 9957, 9957).data, null, 239, 9957, 9962)[row], "mRow", 239, 9934, 9968);
                final T[] outDataRow = CallChecker.varInit(CallChecker.isCalled(outData, null, 240, 10005, 10011)[row], "outDataRow", 240, 9982, 10017);
                for (int col = 0; col < columnCount; col++) {
                    if (CallChecker.beforeDeref(outDataRow, null, 242, 10093, 10102)) {
                        if (CallChecker.beforeDeref(dataRow, null, 242, 10111, 10117)) {
                            if (CallChecker.beforeDeref(mRow, null, 242, 10128, 10131)) {
                                if (CallChecker.beforeDeref(dataRow[col], null, 242, 10111, 10122)) {
                                    outDataRow[col] = dataRow[col].add(mRow[col]);
                                    CallChecker.varAssign(outDataRow[col], "outDataRow[col]", 242, 10093, 10138);
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowFieldMatrix<T>(getField(), outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1794.methodEnd();
        }
    }

    public Array2DRowFieldMatrix<T> subtract(final Array2DRowFieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1795 = new MethodContext(Array2DRowFieldMatrix.class, 257, 10249, 11300);
        try {
            CallChecker.varInit(this, "this", 257, 10249, 11300);
            CallChecker.varInit(m, "m", 257, 10249, 11300);
            CallChecker.varInit(this.data, "data", 257, 10249, 11300);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 257, 10249, 11300);
            checkSubtractionCompatible(m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 262, 10692, 10733);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 263, 10743, 10787);
            final T[][] outData = CallChecker.varInit(MathArrays.buildArray(getField(), rowCount, columnCount), "outData", 264, 10797, 10875);
            for (int row = 0; row < rowCount; row++) {
                data = CallChecker.beforeCalled(data, null, 266, 10963, 10966);
                final T[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, null, 266, 10963, 10966)[row], "dataRow", 266, 10940, 10972);
                CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 267, 11009, 11009).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 267, 11009, 11009).data, null, 267, 11009, 11014);
                final T[] mRow = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 267, 11009, 11009).data, null, 267, 11009, 11014)[row], "mRow", 267, 10986, 11020);
                final T[] outDataRow = CallChecker.varInit(CallChecker.isCalled(outData, null, 268, 11057, 11063)[row], "outDataRow", 268, 11034, 11069);
                for (int col = 0; col < columnCount; col++) {
                    if (CallChecker.beforeDeref(outDataRow, null, 270, 11145, 11154)) {
                        if (CallChecker.beforeDeref(dataRow, null, 270, 11163, 11169)) {
                            if (CallChecker.beforeDeref(mRow, null, 270, 11185, 11188)) {
                                if (CallChecker.beforeDeref(dataRow[col], null, 270, 11163, 11174)) {
                                    outDataRow[col] = dataRow[col].subtract(mRow[col]);
                                    CallChecker.varAssign(outDataRow[col], "outDataRow[col]", 270, 11145, 11195);
                                }
                            }
                        }
                    }
                }
            }
            return new Array2DRowFieldMatrix<T>(getField(), outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1795.methodEnd();
        }
    }

    public Array2DRowFieldMatrix<T> multiply(final Array2DRowFieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1796 = new MethodContext(Array2DRowFieldMatrix.class, 286, 11307, 12532);
        try {
            CallChecker.varInit(this, "this", 286, 11307, 12532);
            CallChecker.varInit(m, "m", 286, 11307, 12532);
            CallChecker.varInit(this.data, "data", 286, 11307, 12532);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 286, 11307, 12532);
            checkMultiplicationCompatible(m);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 291, 11787, 11827);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 292, 11855, 11855).getColumnDimension())), "nCols", 292, 11837, 11877);
            final int nSum = CallChecker.varInit(((int) (this.getColumnDimension())), "nSum", 293, 11887, 11929);
            final T[][] outData = CallChecker.varInit(MathArrays.buildArray(getField(), nRows, nCols), "outData", 294, 11939, 12008);
            for (int row = 0; row < nRows; row++) {
                data = CallChecker.beforeCalled(data, null, 296, 12093, 12096);
                final T[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, null, 296, 12093, 12096)[row], "dataRow", 296, 12070, 12102);
                final T[] outDataRow = CallChecker.varInit(CallChecker.isCalled(outData, null, 297, 12139, 12145)[row], "outDataRow", 297, 12116, 12151);
                for (int col = 0; col < nCols; col++) {
                    final Field<T> npe_invocation_var176 = getField();
                    T sum = CallChecker.init(null);
                    if (CallChecker.beforeDeref(npe_invocation_var176, Field.class, 299, 12229, 12238)) {
                        sum = npe_invocation_var176.getZero();
                        CallChecker.varAssign(sum, "sum", 299, 12229, 12238);
                    }
                    for (int i = 0; i < nSum; i++) {
                        if (CallChecker.beforeDeref(dataRow, null, 301, 12334, 12340)) {
                            if (CallChecker.beforeDeref(m, Array2DRowFieldMatrix.class, 301, 12354, 12354)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data, null, 301, 12354, 12359)) {
                                    CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data, null, 301, 12354, 12359);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data, null, 301, 12354, 12359)[i], null, 301, 12354, 12362)) {
                                        if (CallChecker.beforeDeref(dataRow[i], null, 301, 12334, 12343)) {
                                            if (CallChecker.beforeDeref(sum, null, 301, 12326, 12328)) {
                                                CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data, null, 301, 12354, 12359);
                                                sum = sum.add(dataRow[i].multiply(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowFieldMatrix.class, 301, 12354, 12354).data, null, 301, 12354, 12359)[i][col]));
                                                CallChecker.varAssign(sum, "sum", 301, 12320, 12370);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(outDataRow, null, 303, 12406, 12415)) {
                        outDataRow[col] = sum;
                        CallChecker.varAssign(outDataRow[col], "outDataRow[col]", 303, 12406, 12427);
                    }
                }
            }
            return new Array2DRowFieldMatrix<T>(getField(), outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1796.methodEnd();
        }
    }

    @Override
    public T[][] getData() {
        MethodContext _bcornu_methode_context1797 = new MethodContext(null, 313, 12539, 12633);
        try {
            CallChecker.varInit(this, "this", 313, 12539, 12633);
            CallChecker.varInit(this.data, "data", 313, 12539, 12633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 313, 12539, 12633);
            return copyOut();
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1797.methodEnd();
        }
    }

    public T[][] getDataRef() {
        MethodContext _bcornu_methode_context1798 = new MethodContext(null, 323, 12640, 12902);
        try {
            CallChecker.varInit(this, "this", 323, 12640, 12902);
            CallChecker.varInit(this.data, "data", 323, 12640, 12902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 323, 12640, 12902);
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1798.methodEnd();
        }
    }

    @Override
    public void setSubMatrix(final T[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1799 = new MethodContext(void.class, 329, 12909, 14321);
        try {
            CallChecker.varInit(this, "this", 329, 12909, 14321);
            CallChecker.varInit(column, "column", 329, 12909, 14321);
            CallChecker.varInit(row, "row", 329, 12909, 14321);
            CallChecker.varInit(subMatrix, "subMatrix", 329, 12909, 14321);
            CallChecker.varInit(this.data, "data", 329, 12909, 14321);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 329, 12909, 14321);
            if ((data) == null) {
                if (row > 0) {
                    throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, row);
                }
                if (column > 0) {
                    throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, column);
                }
                final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(subMatrix, null, 340, 13534, 13542).length)), "nRows", 340, 13516, 13550);
                if (nRows == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
                }
                CallChecker.isCalled(subMatrix, null, 345, 13705, 13713)[0] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, null, 345, 13705, 13713)[0], null, 345, 13705, 13716);
                final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(subMatrix, null, 345, 13705, 13713)[0], null, 345, 13705, 13716).length)), "nCols", 345, 13687, 13724);
                if (nCols == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
                if (CallChecker.beforeDeref(subMatrix, null, 349, 13904, 13912)) {
                    data = MathArrays.buildArray(getField(), CallChecker.isCalled(subMatrix, null, 349, 13904, 13912).length, nCols);
                    CallChecker.varAssign(this.data, "this.data", 349, 13863, 13928);
                }
                data = CallChecker.beforeCalled(data, null, 350, 13962, 13965);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 350, 13962, 13965).length); ++i) {
                    if (CallChecker.beforeDeref(subMatrix, null, 351, 14002, 14010)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, null, 351, 14002, 14010)[i], null, 351, 14002, 14013)) {
                            CallChecker.isCalled(subMatrix, null, 351, 14002, 14010)[i] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, null, 351, 14002, 14010)[i], null, 351, 14002, 14013);
                            if ((CallChecker.isCalled(CallChecker.isCalled(subMatrix, null, 351, 14002, 14010)[i], null, 351, 14002, 14013).length) != nCols) {
                                if (CallChecker.beforeDeref(subMatrix, null, 352, 14098, 14106)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, null, 352, 14098, 14106)[i], null, 352, 14098, 14109)) {
                                        CallChecker.isCalled(subMatrix, null, 352, 14098, 14106)[i] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, null, 352, 14098, 14106)[i], null, 352, 14098, 14109);
                                        throw new DimensionMismatchException(nCols, CallChecker.isCalled(CallChecker.isCalled(subMatrix, null, 352, 14098, 14106)[i], null, 352, 14098, 14109).length);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(subMatrix, null, 354, 14171, 14179)) {
                        if (CallChecker.beforeDeref(data, null, 354, 14188, 14191)) {
                            data = CallChecker.beforeCalled(data, null, 354, 14188, 14191);
                            System.arraycopy(CallChecker.isCalled(subMatrix, null, 354, 14171, 14179)[i], 0, CallChecker.isCalled(data, null, 354, 14188, 14191)[(i + row)], column, nCols);
                        }
                    }
                }
            }else {
                super.setSubMatrix(subMatrix, row, column);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1799.methodEnd();
        }
    }

    @Override
    public T getEntry(final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1800 = new MethodContext(null, 364, 14328, 14556);
        try {
            CallChecker.varInit(this, "this", 364, 14328, 14556);
            CallChecker.varInit(column, "column", 364, 14328, 14556);
            CallChecker.varInit(row, "row", 364, 14328, 14556);
            CallChecker.varInit(this.data, "data", 364, 14328, 14556);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 364, 14328, 14556);
            checkRowIndex(row);
            checkColumnIndex(column);
            if (CallChecker.beforeDeref(data, null, 369, 14533, 14536)) {
                data = CallChecker.beforeCalled(data, null, 369, 14533, 14536);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 369, 14533, 14536)[row], null, 369, 14533, 14541)) {
                    data = CallChecker.beforeCalled(data, null, 369, 14533, 14536);
                    return CallChecker.isCalled(data, null, 369, 14533, 14536)[row][column];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1800.methodEnd();
        }
    }

    @Override
    public void setEntry(final int row, final int column, final T value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1801 = new MethodContext(void.class, 374, 14563, 14810);
        try {
            CallChecker.varInit(this, "this", 374, 14563, 14810);
            CallChecker.varInit(value, "value", 374, 14563, 14810);
            CallChecker.varInit(column, "column", 374, 14563, 14810);
            CallChecker.varInit(row, "row", 374, 14563, 14810);
            CallChecker.varInit(this.data, "data", 374, 14563, 14810);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 374, 14563, 14810);
            checkRowIndex(row);
            checkColumnIndex(column);
            if (CallChecker.beforeDeref(data, null, 379, 14779, 14782)) {
                data = CallChecker.beforeCalled(data, null, 379, 14779, 14782);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 379, 14779, 14782)[row], null, 379, 14779, 14787)) {
                    data = CallChecker.beforeCalled(data, null, 379, 14779, 14782);
                    CallChecker.isCalled(data, null, 379, 14779, 14782)[row][column] = value;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, null, 379, 14779, 14782)[row][column], "CallChecker.isCalled(this.data, null, 379, 14779, 14782)[row][column]", 379, 14779, 14804);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1801.methodEnd();
        }
    }

    @Override
    public void addToEntry(final int row, final int column, final T increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1802 = new MethodContext(void.class, 384, 14817, 15097);
        try {
            CallChecker.varInit(this, "this", 384, 14817, 15097);
            CallChecker.varInit(increment, "increment", 384, 14817, 15097);
            CallChecker.varInit(column, "column", 384, 14817, 15097);
            CallChecker.varInit(row, "row", 384, 14817, 15097);
            CallChecker.varInit(this.data, "data", 384, 14817, 15097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 384, 14817, 15097);
            checkRowIndex(row);
            checkColumnIndex(column);
            if (CallChecker.beforeDeref(data, null, 389, 15039, 15042)) {
                data = CallChecker.beforeCalled(data, null, 389, 15039, 15042);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 389, 15039, 15042)[row], null, 389, 15039, 15047)) {
                    if (CallChecker.beforeDeref(data, null, 389, 15059, 15062)) {
                        data = CallChecker.beforeCalled(data, null, 389, 15059, 15062);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 389, 15059, 15062)[row], null, 389, 15059, 15067)) {
                            data = CallChecker.beforeCalled(data, null, 389, 15059, 15062);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 389, 15059, 15062)[row][column], null, 389, 15059, 15075)) {
                                data = CallChecker.beforeCalled(data, null, 389, 15039, 15042);
                                data = CallChecker.beforeCalled(data, null, 389, 15059, 15062);
                                CallChecker.isCalled(data, null, 389, 15039, 15042)[row][column] = CallChecker.isCalled(data, null, 389, 15059, 15062)[row][column].add(increment);
                                CallChecker.varAssign(CallChecker.isCalled(this.data, null, 389, 15039, 15042)[row][column], "CallChecker.isCalled(this.data, null, 389, 15039, 15042)[row][column]", 389, 15039, 15091);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1802.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(final int row, final int column, final T factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1803 = new MethodContext(void.class, 394, 15104, 15386);
        try {
            CallChecker.varInit(this, "this", 394, 15104, 15386);
            CallChecker.varInit(factor, "factor", 394, 15104, 15386);
            CallChecker.varInit(column, "column", 394, 15104, 15386);
            CallChecker.varInit(row, "row", 394, 15104, 15386);
            CallChecker.varInit(this.data, "data", 394, 15104, 15386);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 394, 15104, 15386);
            checkRowIndex(row);
            checkColumnIndex(column);
            if (CallChecker.beforeDeref(data, null, 399, 15326, 15329)) {
                data = CallChecker.beforeCalled(data, null, 399, 15326, 15329);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 399, 15326, 15329)[row], null, 399, 15326, 15334)) {
                    if (CallChecker.beforeDeref(data, null, 399, 15346, 15349)) {
                        data = CallChecker.beforeCalled(data, null, 399, 15346, 15349);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 399, 15346, 15349)[row], null, 399, 15346, 15354)) {
                            data = CallChecker.beforeCalled(data, null, 399, 15346, 15349);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 399, 15346, 15349)[row][column], null, 399, 15346, 15362)) {
                                data = CallChecker.beforeCalled(data, null, 399, 15326, 15329);
                                data = CallChecker.beforeCalled(data, null, 399, 15346, 15349);
                                CallChecker.isCalled(data, null, 399, 15326, 15329)[row][column] = CallChecker.isCalled(data, null, 399, 15346, 15349)[row][column].multiply(factor);
                                CallChecker.varAssign(CallChecker.isCalled(this.data, null, 399, 15326, 15329)[row][column], "CallChecker.isCalled(this.data, null, 399, 15326, 15329)[row][column]", 399, 15326, 15380);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1803.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context1804 = new MethodContext(int.class, 404, 15393, 15516);
        try {
            CallChecker.varInit(this, "this", 404, 15393, 15516);
            CallChecker.varInit(this.data, "data", 404, 15393, 15516);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 404, 15393, 15516);
            if ((data) == null) {
                return 0;
            }else {
                if (CallChecker.beforeDeref(data, null, 405, 15499, 15502)) {
                    data = CallChecker.beforeCalled(data, null, 405, 15499, 15502);
                    return CallChecker.isCalled(data, null, 405, 15499, 15502).length;
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1804.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context1805 = new MethodContext(int.class, 410, 15523, 15675);
        try {
            CallChecker.varInit(this, "this", 410, 15523, 15675);
            CallChecker.varInit(this.data, "data", 410, 15523, 15675);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 410, 15523, 15675);
            if (((data) == null) || ((data[0]) == null)) {
                return 0;
            }else {
                return data[0].length;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1805.methodEnd();
        }
    }

    @Override
    public T[] operate(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1806 = new MethodContext(null, 416, 15682, 16381);
        try {
            CallChecker.varInit(this, "this", 416, 15682, 16381);
            CallChecker.varInit(v, "v", 416, 15682, 16381);
            CallChecker.varInit(this.data, "data", 416, 15682, 16381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 416, 15682, 16381);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 417, 15797, 15837);
            final int nCols = CallChecker.varInit(((int) (this.getColumnDimension())), "nCols", 418, 15847, 15890);
            if (CallChecker.beforeDeref(v, null, 419, 15904, 15904)) {
                if ((CallChecker.isCalled(v, null, 419, 15904, 15904).length) != nCols) {
                    if (CallChecker.beforeDeref(v, null, 420, 15974, 15974)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 420, 15974, 15974).length, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), nRows), "out", 422, 16010, 16066);
            for (int row = 0; row < nRows; row++) {
                data = CallChecker.beforeCalled(data, null, 424, 16148, 16151);
                final T[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, null, 424, 16148, 16151)[row], "dataRow", 424, 16128, 16157);
                final Field<T> npe_invocation_var177 = getField();
                T sum = CallChecker.init(null);
                if (CallChecker.beforeDeref(npe_invocation_var177, Field.class, 425, 16179, 16188)) {
                    sum = npe_invocation_var177.getZero();
                    CallChecker.varAssign(sum, "sum", 425, 16179, 16188);
                }
                for (int i = 0; i < nCols; i++) {
                    if (CallChecker.beforeDeref(dataRow, null, 427, 16277, 16283)) {
                        if (CallChecker.beforeDeref(v, null, 427, 16297, 16297)) {
                            if (CallChecker.beforeDeref(dataRow[i], null, 427, 16277, 16286)) {
                                if (CallChecker.beforeDeref(sum, null, 427, 16269, 16271)) {
                                    sum = sum.add(dataRow[i].multiply(v[i]));
                                    CallChecker.varAssign(sum, "sum", 427, 16263, 16303);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, null, 429, 16331, 16333)) {
                    out[row] = sum;
                    CallChecker.varAssign(out[row], "out[row]", 429, 16331, 16345);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1806.methodEnd();
        }
    }

    @Override
    public T[] preMultiply(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1807 = new MethodContext(null, 436, 16388, 17042);
        try {
            CallChecker.varInit(this, "this", 436, 16388, 17042);
            CallChecker.varInit(v, "v", 436, 16388, 17042);
            CallChecker.varInit(this.data, "data", 436, 16388, 17042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 436, 16388, 17042);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 437, 16507, 16542);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 438, 16552, 16590);
            if (CallChecker.beforeDeref(v, null, 439, 16604, 16604)) {
                if ((CallChecker.isCalled(v, null, 439, 16604, 16604).length) != nRows) {
                    if (CallChecker.beforeDeref(v, null, 440, 16674, 16674)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 440, 16674, 16674).length, nRows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), nCols), "out", 443, 16711, 16767);
            for (int col = 0; col < nCols; ++col) {
                final Field<T> npe_invocation_var178 = getField();
                T sum = CallChecker.init(null);
                if (CallChecker.beforeDeref(npe_invocation_var178, Field.class, 445, 16837, 16846)) {
                    sum = npe_invocation_var178.getZero();
                    CallChecker.varAssign(sum, "sum", 445, 16837, 16846);
                }
                for (int i = 0; i < nRows; ++i) {
                    if (CallChecker.beforeDeref(data, null, 447, 16935, 16938)) {
                        data = CallChecker.beforeCalled(data, null, 447, 16935, 16938);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 447, 16935, 16938)[i], null, 447, 16935, 16941)) {
                            if (CallChecker.beforeDeref(v, null, 447, 16957, 16957)) {
                                data = CallChecker.beforeCalled(data, null, 447, 16935, 16938);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 447, 16935, 16938)[i][col], null, 447, 16935, 16946)) {
                                    if (CallChecker.beforeDeref(sum, null, 447, 16927, 16929)) {
                                        data = CallChecker.beforeCalled(data, null, 447, 16935, 16938);
                                        sum = sum.add(CallChecker.isCalled(data, null, 447, 16935, 16938)[i][col].multiply(v[i]));
                                        CallChecker.varAssign(sum, "sum", 447, 16921, 16963);
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, null, 449, 16991, 16993)) {
                    out[col] = sum;
                    CallChecker.varAssign(out[col], "out[col]", 449, 16991, 17005);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1807.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1808 = new MethodContext(null, 457, 17049, 17564);
        try {
            CallChecker.varInit(this, "this", 457, 17049, 17564);
            CallChecker.varInit(visitor, "visitor", 457, 17049, 17564);
            CallChecker.varInit(this.data, "data", 457, 17049, 17564);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 457, 17049, 17564);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 458, 17167, 17204);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 459, 17214, 17254);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 460, 17264, 17270)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 460, 17264, 17270).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int i = 0; i < rows; ++i) {
                data = CallChecker.beforeCalled(data, null, 462, 17393, 17396);
                final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 462, 17393, 17396)[i], "rowI", 462, 17376, 17400);
                for (int j = 0; j < columns; ++j) {
                    if (CallChecker.beforeDeref(rowI, null, 464, 17466, 17469)) {
                        if (CallChecker.beforeDeref(rowI, null, 464, 17496, 17499)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 464, 17476, 17482)) {
                                rowI[j] = visitor.visit(i, j, rowI[j]);
                                CallChecker.varAssign(rowI[j], "rowI[j]", 464, 17466, 17504);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 467, 17545, 17551)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1808.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1809 = new MethodContext(null, 472, 17571, 18078);
        try {
            CallChecker.varInit(this, "this", 472, 17571, 18078);
            CallChecker.varInit(visitor, "visitor", 472, 17571, 18078);
            CallChecker.varInit(this.data, "data", 472, 17571, 18078);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 472, 17571, 18078);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 473, 17691, 17728);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 474, 17738, 17778);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 475, 17788, 17794)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 475, 17788, 17794).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int i = 0; i < rows; ++i) {
                data = CallChecker.beforeCalled(data, null, 477, 17917, 17920);
                final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 477, 17917, 17920)[i], "rowI", 477, 17900, 17924);
                for (int j = 0; j < columns; ++j) {
                    if (CallChecker.beforeDeref(rowI, null, 479, 18010, 18013)) {
                        if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 479, 17990, 17996)) {
                            CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 479, 17990, 17996).visit(i, j, rowI[j]);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 482, 18059, 18065)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1809.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1810 = new MethodContext(null, 487, 18085, 18858);
        try {
            CallChecker.varInit(this, "this", 487, 18085, 18858);
            CallChecker.varInit(endColumn, "endColumn", 487, 18085, 18858);
            CallChecker.varInit(startColumn, "startColumn", 487, 18085, 18858);
            CallChecker.varInit(endRow, "endRow", 487, 18085, 18858);
            CallChecker.varInit(startRow, "startRow", 487, 18085, 18858);
            CallChecker.varInit(visitor, "visitor", 487, 18085, 18858);
            CallChecker.varInit(this.data, "data", 487, 18085, 18858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 487, 18085, 18858);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 492, 18474, 18480)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 492, 18474, 18480).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int i = startRow; i <= endRow; ++i) {
                data = CallChecker.beforeCalled(data, null, 495, 18674, 18677);
                final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 495, 18674, 18677)[i], "rowI", 495, 18657, 18681);
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(rowI, null, 497, 18760, 18763)) {
                        if (CallChecker.beforeDeref(rowI, null, 497, 18790, 18793)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 497, 18770, 18776)) {
                                rowI[j] = visitor.visit(i, j, rowI[j]);
                                CallChecker.varAssign(rowI[j], "rowI[j]", 497, 18760, 18798);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 500, 18839, 18845)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1810.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1811 = new MethodContext(null, 505, 18865, 19630);
        try {
            CallChecker.varInit(this, "this", 505, 18865, 19630);
            CallChecker.varInit(endColumn, "endColumn", 505, 18865, 19630);
            CallChecker.varInit(startColumn, "startColumn", 505, 18865, 19630);
            CallChecker.varInit(endRow, "endRow", 505, 18865, 19630);
            CallChecker.varInit(startRow, "startRow", 505, 18865, 19630);
            CallChecker.varInit(visitor, "visitor", 505, 18865, 19630);
            CallChecker.varInit(this.data, "data", 505, 18865, 19630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 505, 18865, 19630);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 510, 19256, 19262)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 510, 19256, 19262).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int i = startRow; i <= endRow; ++i) {
                data = CallChecker.beforeCalled(data, null, 513, 19456, 19459);
                final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 513, 19456, 19459)[i], "rowI", 513, 19439, 19463);
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(rowI, null, 515, 19562, 19565)) {
                        if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 515, 19542, 19548)) {
                            CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 515, 19542, 19548).visit(i, j, rowI[j]);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 518, 19611, 19617)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1811.methodEnd();
        }
    }

    @Override
    public T walkInColumnOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1812 = new MethodContext(null, 523, 19637, 20159);
        try {
            CallChecker.varInit(this, "this", 523, 19637, 20159);
            CallChecker.varInit(visitor, "visitor", 523, 19637, 20159);
            CallChecker.varInit(this.data, "data", 523, 19637, 20159);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 523, 19637, 20159);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 524, 19758, 19795);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 525, 19805, 19845);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 526, 19855, 19861)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 526, 19855, 19861).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int j = 0; j < columns; ++j) {
                for (int i = 0; i < rows; ++i) {
                    data = CallChecker.beforeCalled(data, null, 529, 20036, 20039);
                    final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 529, 20036, 20039)[i], "rowI", 529, 20019, 20043);
                    if (CallChecker.beforeDeref(rowI, null, 530, 20061, 20064)) {
                        if (CallChecker.beforeDeref(rowI, null, 530, 20091, 20094)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 530, 20071, 20077)) {
                                rowI[j] = visitor.visit(i, j, rowI[j]);
                                CallChecker.varAssign(rowI[j], "rowI[j]", 530, 20061, 20099);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 533, 20140, 20146)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1812.methodEnd();
        }
    }

    @Override
    public T walkInColumnOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1813 = new MethodContext(null, 538, 20166, 20641);
        try {
            CallChecker.varInit(this, "this", 538, 20166, 20641);
            CallChecker.varInit(visitor, "visitor", 538, 20166, 20641);
            CallChecker.varInit(this.data, "data", 538, 20166, 20641);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 538, 20166, 20641);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 539, 20289, 20326);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 540, 20336, 20376);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 541, 20386, 20392)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 541, 20386, 20392).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int j = 0; j < columns; ++j) {
                for (int i = 0; i < rows; ++i) {
                    if (CallChecker.beforeDeref(data, null, 544, 20570, 20573)) {
                        data = CallChecker.beforeCalled(data, null, 544, 20570, 20573);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 544, 20570, 20573)[i], null, 544, 20570, 20576)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 544, 20550, 20556)) {
                                data = CallChecker.beforeCalled(data, null, 544, 20570, 20573);
                                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 544, 20550, 20556).visit(i, j, CallChecker.isCalled(data, null, 544, 20570, 20573)[i][j]);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 547, 20622, 20628)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1813.methodEnd();
        }
    }

    @Override
    public T walkInColumnOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1814 = new MethodContext(null, 552, 20648, 21430);
        try {
            CallChecker.varInit(this, "this", 552, 20648, 21430);
            CallChecker.varInit(endColumn, "endColumn", 552, 20648, 21430);
            CallChecker.varInit(startColumn, "startColumn", 552, 20648, 21430);
            CallChecker.varInit(endRow, "endRow", 552, 20648, 21430);
            CallChecker.varInit(startRow, "startRow", 552, 20648, 21430);
            CallChecker.varInit(visitor, "visitor", 552, 20648, 21430);
            CallChecker.varInit(this.data, "data", 552, 20648, 21430);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 552, 20648, 21430);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 557, 21042, 21048)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 557, 21042, 21048).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int j = startColumn; j <= endColumn; ++j) {
                for (int i = startRow; i <= endRow; ++i) {
                    data = CallChecker.beforeCalled(data, null, 561, 21307, 21310);
                    final T[] rowI = CallChecker.varInit(CallChecker.isCalled(data, null, 561, 21307, 21310)[i], "rowI", 561, 21290, 21314);
                    if (CallChecker.beforeDeref(rowI, null, 562, 21332, 21335)) {
                        if (CallChecker.beforeDeref(rowI, null, 562, 21362, 21365)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 562, 21342, 21348)) {
                                rowI[j] = visitor.visit(i, j, rowI[j]);
                                CallChecker.varAssign(rowI[j], "rowI[j]", 562, 21332, 21370);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 565, 21411, 21417)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1814.methodEnd();
        }
    }

    @Override
    public T walkInColumnOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1815 = new MethodContext(null, 570, 21437, 22176);
        try {
            CallChecker.varInit(this, "this", 570, 21437, 22176);
            CallChecker.varInit(endColumn, "endColumn", 570, 21437, 22176);
            CallChecker.varInit(startColumn, "startColumn", 570, 21437, 22176);
            CallChecker.varInit(endRow, "endRow", 570, 21437, 22176);
            CallChecker.varInit(startRow, "startRow", 570, 21437, 22176);
            CallChecker.varInit(visitor, "visitor", 570, 21437, 22176);
            CallChecker.varInit(this.data, "data", 570, 21437, 22176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 570, 21437, 22176);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 575, 21837, 21843)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 575, 21837, 21843).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int j = startColumn; j <= endColumn; ++j) {
                for (int i = startRow; i <= endRow; ++i) {
                    if (CallChecker.beforeDeref(data, null, 579, 22105, 22108)) {
                        data = CallChecker.beforeCalled(data, null, 579, 22105, 22108);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 579, 22105, 22108)[i], null, 579, 22105, 22111)) {
                            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 579, 22085, 22091)) {
                                data = CallChecker.beforeCalled(data, null, 579, 22105, 22108);
                                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 579, 22085, 22091).visit(i, j, CallChecker.isCalled(data, null, 579, 22105, 22108)[i][j]);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 582, 22157, 22163)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1815.methodEnd();
        }
    }

    private T[][] copyOut() {
        MethodContext _bcornu_methode_context1816 = new MethodContext(null, 590, 22183, 22697);
        try {
            CallChecker.varInit(this, "this", 590, 22183, 22697);
            CallChecker.varInit(this.data, "data", 590, 22183, 22697);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 590, 22183, 22697);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 591, 22346, 22386);
            final T[][] out = CallChecker.varInit(MathArrays.buildArray(getField(), nRows, getColumnDimension()), "out", 592, 22396, 22476);
            for (int i = 0; i < nRows; i++) {
                if (CallChecker.beforeDeref(data, null, 595, 22623, 22626)) {
                    if (CallChecker.beforeDeref(out, null, 595, 22635, 22637)) {
                        if (CallChecker.beforeDeref(data, null, 595, 22646, 22649)) {
                            data = CallChecker.beforeCalled(data, null, 595, 22646, 22649);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, null, 595, 22646, 22649)[i], null, 595, 22646, 22652)) {
                                data = CallChecker.beforeCalled(data, null, 595, 22623, 22626);
                                data = CallChecker.beforeCalled(data, null, 595, 22646, 22649);
                                CallChecker.isCalled(data, null, 595, 22646, 22649)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, null, 595, 22646, 22649)[i], null, 595, 22646, 22652);
                                System.arraycopy(CallChecker.isCalled(data, null, 595, 22623, 22626)[i], 0, CallChecker.isCalled(out, null, 595, 22635, 22637)[i], 0, CallChecker.isCalled(CallChecker.isCalled(data, null, 595, 22646, 22649)[i], null, 595, 22646, 22652).length);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1816.methodEnd();
        }
    }

    private void copyIn(final T[][] in) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context1817 = new MethodContext(void.class, 608, 22704, 23194);
        try {
            CallChecker.varInit(this, "this", 608, 22704, 23194);
            CallChecker.varInit(in, "in", 608, 22704, 23194);
            CallChecker.varInit(this.data, "data", 608, 22704, 23194);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowFieldMatrix.serialVersionUID", 608, 22704, 23194);
            setSubMatrix(in, 0, 0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1817.methodEnd();
        }
    }
}

