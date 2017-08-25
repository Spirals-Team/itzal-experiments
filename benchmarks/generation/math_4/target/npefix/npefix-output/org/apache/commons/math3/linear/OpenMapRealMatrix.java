package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

@Deprecated
public class OpenMapRealMatrix extends AbstractRealMatrix implements Serializable , SparseRealMatrix {
    private static final long serialVersionUID = -5962461716457143437L;

    private final int rows;

    private final int columns;

    private final OpenIntToDoubleHashMap entries;

    public OpenMapRealMatrix(int rowDimension, int columnDimension) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        super(rowDimension, columnDimension);
        ConstructorContext _bcornu_methode_context717 = new ConstructorContext(OpenMapRealMatrix.class, 61, 2017, 2998);
        try {
            long lRow = CallChecker.varInit(((long) (rowDimension)), "lRow", 64, 2655, 2679);
            long lCol = CallChecker.varInit(((long) (columnDimension)), "lCol", 65, 2689, 2716);
            if ((lRow * lCol) >= (Integer.MAX_VALUE)) {
                throw new NumberIsTooLargeException((lRow * lCol), Integer.MAX_VALUE, false);
            }
            this.rows = rowDimension;
            CallChecker.varAssign(this.rows, "this.rows", 69, 2872, 2896);
            this.columns = columnDimension;
            CallChecker.varAssign(this.columns, "this.columns", 70, 2906, 2936);
            this.entries = new OpenIntToDoubleHashMap(0.0);
            CallChecker.varAssign(this.entries, "this.entries", 71, 2946, 2992);
        } finally {
            _bcornu_methode_context717.methodEnd();
        }
    }

    public OpenMapRealMatrix(OpenMapRealMatrix matrix) {
        ConstructorContext _bcornu_methode_context718 = new ConstructorContext(OpenMapRealMatrix.class, 79, 3005, 3307);
        try {
            matrix = CallChecker.beforeCalled(matrix, OpenMapRealMatrix.class, 80, 3184, 3189);
            this.rows = CallChecker.isCalled(matrix, OpenMapRealMatrix.class, 80, 3184, 3189).rows;
            CallChecker.varAssign(this.rows, "this.rows", 80, 3172, 3195);
            matrix = CallChecker.beforeCalled(matrix, OpenMapRealMatrix.class, 81, 3220, 3225);
            this.columns = CallChecker.isCalled(matrix, OpenMapRealMatrix.class, 81, 3220, 3225).columns;
            CallChecker.varAssign(this.columns, "this.columns", 81, 3205, 3234);
            matrix = CallChecker.beforeCalled(matrix, OpenMapRealMatrix.class, 82, 3286, 3291);
            this.entries = new OpenIntToDoubleHashMap(CallChecker.isCalled(matrix, OpenMapRealMatrix.class, 82, 3286, 3291).entries);
            CallChecker.varAssign(this.entries, "this.entries", 82, 3244, 3301);
        } finally {
            _bcornu_methode_context718.methodEnd();
        }
    }

    @Override
    public OpenMapRealMatrix copy() {
        MethodContext _bcornu_methode_context3221 = new MethodContext(OpenMapRealMatrix.class, 87, 3314, 3435);
        try {
            CallChecker.varInit(this, "this", 87, 3314, 3435);
            CallChecker.varInit(this.entries, "entries", 87, 3314, 3435);
            CallChecker.varInit(this.columns, "columns", 87, 3314, 3435);
            CallChecker.varInit(this.rows, "rows", 87, 3314, 3435);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 87, 3314, 3435);
            return new OpenMapRealMatrix(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3221.methodEnd();
        }
    }

    @Override
    public OpenMapRealMatrix createMatrix(int rowDimension, int columnDimension) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3222 = new MethodContext(OpenMapRealMatrix.class, 98, 3442, 3858);
        try {
            CallChecker.varInit(this, "this", 98, 3442, 3858);
            CallChecker.varInit(columnDimension, "columnDimension", 98, 3442, 3858);
            CallChecker.varInit(rowDimension, "rowDimension", 98, 3442, 3858);
            CallChecker.varInit(this.entries, "entries", 98, 3442, 3858);
            CallChecker.varInit(this.columns, "columns", 98, 3442, 3858);
            CallChecker.varInit(this.rows, "rows", 98, 3442, 3858);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 98, 3442, 3858);
            return new OpenMapRealMatrix(rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3222.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context3223 = new MethodContext(int.class, 105, 3865, 3966);
        try {
            CallChecker.varInit(this, "this", 105, 3865, 3966);
            CallChecker.varInit(this.entries, "entries", 105, 3865, 3966);
            CallChecker.varInit(this.columns, "columns", 105, 3865, 3966);
            CallChecker.varInit(this.rows, "rows", 105, 3865, 3966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 105, 3865, 3966);
            return columns;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3223.methodEnd();
        }
    }

    public OpenMapRealMatrix add(OpenMapRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3224 = new MethodContext(OpenMapRealMatrix.class, 117, 3973, 4813);
        try {
            CallChecker.varInit(this, "this", 117, 3973, 4813);
            CallChecker.varInit(m, "m", 117, 3973, 4813);
            CallChecker.varInit(this.entries, "entries", 117, 3973, 4813);
            CallChecker.varInit(this.columns, "columns", 117, 3973, 4813);
            CallChecker.varInit(this.rows, "rows", 117, 3973, 4813);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 117, 3973, 4813);
            MatrixUtils.checkAdditionCompatible(this, m);
            final OpenMapRealMatrix out = CallChecker.varInit(new OpenMapRealMatrix(this), "out", 122, 4396, 4453);
            m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 123, 4511, 4511);
            for (OpenIntToDoubleHashMap.Iterator iterator = CallChecker.isCalled(CallChecker.isCalled(m, OpenMapRealMatrix.class, 123, 4511, 4511).entries, OpenIntToDoubleHashMap.class, 123, 4511, 4519).iterator(); CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 123, 4533, 4540).hasNext();) {
                if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 124, 4568, 4575)) {
                    CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 124, 4568, 4575).advance();
                }
                final int row = CallChecker.varInit(((int) ((CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 125, 4616, 4623).key()) / (this.columns))), "row", 125, 4600, 4640);
                final int col = CallChecker.varInit(((int) ((CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 126, 4670, 4677).key()) - (row * (this.columns)))), "col", 126, 4654, 4700);
                if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 127, 4758, 4765)) {
                    if (CallChecker.beforeDeref(out, OpenMapRealMatrix.class, 127, 4714, 4716)) {
                        CallChecker.isCalled(out, OpenMapRealMatrix.class, 127, 4714, 4716).setEntry(row, col, ((getEntry(row, col)) + (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 127, 4758, 4765).value())));
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3224.methodEnd();
        }
    }

    @Override
    public OpenMapRealMatrix subtract(final RealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3225 = new MethodContext(OpenMapRealMatrix.class, 136, 4820, 5144);
        try {
            CallChecker.varInit(this, "this", 136, 4820, 5144);
            CallChecker.varInit(m, "m", 136, 4820, 5144);
            CallChecker.varInit(this.entries, "entries", 136, 4820, 5144);
            CallChecker.varInit(this.columns, "columns", 136, 4820, 5144);
            CallChecker.varInit(this.rows, "rows", 136, 4820, 5144);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 136, 4820, 5144);
            TryContext _bcornu_try_context_67 = new TryContext(67, OpenMapRealMatrix.class, "java.lang.ClassCastException");
            try {
                return subtract(((OpenMapRealMatrix) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_67.catchStart(67);
                return ((OpenMapRealMatrix) (super.subtract(m)));
            } finally {
                _bcornu_try_context_67.finallyStart(67);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3225.methodEnd();
        }
    }

    public OpenMapRealMatrix subtract(OpenMapRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3226 = new MethodContext(OpenMapRealMatrix.class, 153, 5151, 5990);
        try {
            CallChecker.varInit(this, "this", 153, 5151, 5990);
            CallChecker.varInit(m, "m", 153, 5151, 5990);
            CallChecker.varInit(this.entries, "entries", 153, 5151, 5990);
            CallChecker.varInit(this.columns, "columns", 153, 5151, 5990);
            CallChecker.varInit(this.rows, "rows", 153, 5151, 5990);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 153, 5151, 5990);
            MatrixUtils.checkAdditionCompatible(this, m);
            final OpenMapRealMatrix out = CallChecker.varInit(new OpenMapRealMatrix(this), "out", 157, 5574, 5631);
            m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 158, 5689, 5689);
            for (OpenIntToDoubleHashMap.Iterator iterator = CallChecker.isCalled(CallChecker.isCalled(m, OpenMapRealMatrix.class, 158, 5689, 5689).entries, OpenIntToDoubleHashMap.class, 158, 5689, 5697).iterator(); CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 158, 5711, 5718).hasNext();) {
                if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 159, 5746, 5753)) {
                    CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 159, 5746, 5753).advance();
                }
                final int row = CallChecker.varInit(((int) ((CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 160, 5794, 5801).key()) / (this.columns))), "row", 160, 5778, 5818);
                final int col = CallChecker.varInit(((int) ((CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 161, 5848, 5855).key()) - (row * (this.columns)))), "col", 161, 5832, 5878);
                if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 162, 5936, 5943)) {
                    if (CallChecker.beforeDeref(out, OpenMapRealMatrix.class, 162, 5892, 5894)) {
                        CallChecker.isCalled(out, OpenMapRealMatrix.class, 162, 5892, 5894).setEntry(row, col, ((getEntry(row, col)) - (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 162, 5936, 5943).value())));
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3226.methodEnd();
        }
    }

    @Override
    public RealMatrix multiply(final RealMatrix m) throws DimensionMismatchException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3227 = new MethodContext(RealMatrix.class, 176, 5997, 7212);
        try {
            CallChecker.varInit(this, "this", 176, 5997, 7212);
            CallChecker.varInit(m, "m", 176, 5997, 7212);
            CallChecker.varInit(this.entries, "entries", 176, 5997, 7212);
            CallChecker.varInit(this.columns, "columns", 176, 5997, 7212);
            CallChecker.varInit(this.rows, "rows", 176, 5997, 7212);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 176, 5997, 7212);
            TryContext _bcornu_try_context_68 = new TryContext(68, OpenMapRealMatrix.class, "java.lang.ClassCastException");
            try {
                return multiply(((OpenMapRealMatrix) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_68.catchStart(68);
                MatrixUtils.checkMultiplicationCompatible(this, m);
                final int outCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 184, 6570, 6570).getColumnDimension())), "outCols", 184, 6550, 6592);
                final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, outCols), "out", 185, 6606, 6668);
                for (OpenIntToDoubleHashMap.Iterator iterator = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 186, 6730, 6736).iterator(); CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 186, 6750, 6757).hasNext();) {
                    if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 187, 6789, 6796)) {
                        CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 187, 6789, 6796).advance();
                    }
                    final double value = CallChecker.varInit(((double) (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 188, 6846, 6853).value())), "value", 188, 6825, 6862);
                    final int key = CallChecker.varInit(((int) (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 189, 6901, 6908).key())), "key", 189, 6880, 6915);
                    final int i = CallChecker.varInit(((int) (key / (this.columns))), "i", 190, 6933, 6967);
                    final int k = CallChecker.varInit(((int) (key % (this.columns))), "k", 191, 6985, 7019);
                    for (int j = 0; j < outCols; ++j) {
                        if (CallChecker.beforeDeref(m, RealMatrix.class, 193, 7122, 7122)) {
                            if (CallChecker.beforeDeref(out, BlockRealMatrix.class, 193, 7093, 7095)) {
                                CallChecker.isCalled(out, BlockRealMatrix.class, 193, 7093, 7095).addToEntry(i, j, (value * (CallChecker.isCalled(m, RealMatrix.class, 193, 7122, 7122).getEntry(k, j))));
                            }
                        }
                    }
                }
                return out;
            } finally {
                _bcornu_try_context_68.finallyStart(68);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3227.methodEnd();
        }
    }

    public OpenMapRealMatrix multiply(OpenMapRealMatrix m) throws DimensionMismatchException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3228 = new MethodContext(OpenMapRealMatrix.class, 211, 7219, 8931);
        try {
            CallChecker.varInit(this, "this", 211, 7219, 8931);
            CallChecker.varInit(m, "m", 211, 7219, 8931);
            CallChecker.varInit(this.entries, "entries", 211, 7219, 8931);
            CallChecker.varInit(this.columns, "columns", 211, 7219, 8931);
            CallChecker.varInit(this.rows, "rows", 211, 7219, 8931);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 211, 7219, 8931);
            MatrixUtils.checkMultiplicationCompatible(this, m);
            m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 216, 7890, 7890);
            final int outCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, OpenMapRealMatrix.class, 216, 7890, 7890).getColumnDimension())), "outCols", 216, 7870, 7912);
            OpenMapRealMatrix out = CallChecker.varInit(new OpenMapRealMatrix(rows, outCols), "out", 217, 7922, 7982);
            for (OpenIntToDoubleHashMap.Iterator iterator = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 218, 8040, 8046).iterator(); CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 218, 8060, 8067).hasNext();) {
                if (CallChecker.beforeDeref(iterator, OpenIntToDoubleHashMap.Iterator.class, 219, 8095, 8102)) {
                    CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 219, 8095, 8102).advance();
                }
                final double value = CallChecker.varInit(((double) (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 220, 8148, 8155).value())), "value", 220, 8127, 8164);
                final int key = CallChecker.varInit(((int) (CallChecker.isCalled(iterator, OpenIntToDoubleHashMap.Iterator.class, 221, 8199, 8206).key())), "key", 221, 8178, 8213);
                final int i = CallChecker.varInit(((int) (key / (this.columns))), "i", 222, 8227, 8261);
                final int k = CallChecker.varInit(((int) (key % (this.columns))), "k", 223, 8275, 8309);
                for (int j = 0; j < outCols; ++j) {
                    m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 225, 8396, 8396);
                    final int rightKey = CallChecker.varInit(((int) (CallChecker.isCalled(m, OpenMapRealMatrix.class, 225, 8396, 8396).computeKey(k, j))), "rightKey", 225, 8375, 8414);
                    if (CallChecker.beforeDeref(m, OpenMapRealMatrix.class, 226, 8436, 8436)) {
                        m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 226, 8436, 8436);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m, OpenMapRealMatrix.class, 226, 8436, 8436).entries, OpenIntToDoubleHashMap.class, 226, 8436, 8444)) {
                            m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 226, 8436, 8436);
                            if (CallChecker.isCalled(CallChecker.isCalled(m, OpenMapRealMatrix.class, 226, 8436, 8436).entries, OpenIntToDoubleHashMap.class, 226, 8436, 8444).containsKey(rightKey)) {
                                out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 227, 8510, 8512);
                                final int outKey = CallChecker.varInit(((int) (CallChecker.isCalled(out, OpenMapRealMatrix.class, 227, 8510, 8512).computeKey(i, j))), "outKey", 227, 8491, 8530);
                                out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 229, 8600, 8602);
                                m = CallChecker.beforeCalled(m, OpenMapRealMatrix.class, 229, 8634, 8634);
                                final double outValue = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(out, OpenMapRealMatrix.class, 229, 8600, 8602).entries, OpenIntToDoubleHashMap.class, 229, 8600, 8610).get(outKey)) + (value * (CallChecker.isCalled(CallChecker.isCalled(m, OpenMapRealMatrix.class, 229, 8634, 8634).entries, OpenIntToDoubleHashMap.class, 229, 8634, 8642).get(rightKey))))), "outValue", 228, 8552, 8657);
                                if (outValue == 0.0) {
                                    if (CallChecker.beforeDeref(out, OpenMapRealMatrix.class, 231, 8726, 8728)) {
                                        out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 231, 8726, 8728);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(out, OpenMapRealMatrix.class, 231, 8726, 8728).entries, OpenIntToDoubleHashMap.class, 231, 8726, 8736)) {
                                            out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 231, 8726, 8728);
                                            CallChecker.isCalled(CallChecker.isCalled(out, OpenMapRealMatrix.class, 231, 8726, 8728).entries, OpenIntToDoubleHashMap.class, 231, 8726, 8736).remove(outKey);
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(out, OpenMapRealMatrix.class, 233, 8807, 8809)) {
                                        out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 233, 8807, 8809);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(out, OpenMapRealMatrix.class, 233, 8807, 8809).entries, OpenIntToDoubleHashMap.class, 233, 8807, 8817)) {
                                            out = CallChecker.beforeCalled(out, OpenMapRealMatrix.class, 233, 8807, 8809);
                                            CallChecker.isCalled(CallChecker.isCalled(out, OpenMapRealMatrix.class, 233, 8807, 8809).entries, OpenIntToDoubleHashMap.class, 233, 8807, 8817).put(outKey, outValue);
                                        }
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3228.methodEnd();
        }
    }

    @Override
    public double getEntry(int row, int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3229 = new MethodContext(double.class, 244, 8938, 9205);
        try {
            CallChecker.varInit(this, "this", 244, 8938, 9205);
            CallChecker.varInit(column, "column", 244, 8938, 9205);
            CallChecker.varInit(row, "row", 244, 8938, 9205);
            CallChecker.varInit(this.entries, "entries", 244, 8938, 9205);
            CallChecker.varInit(this.columns, "columns", 244, 8938, 9205);
            CallChecker.varInit(this.rows, "rows", 244, 8938, 9205);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 244, 8938, 9205);
            MatrixUtils.checkRowIndex(this, row);
            MatrixUtils.checkColumnIndex(this, column);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 247, 9163, 9169)) {
                return CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 247, 9163, 9169).get(computeKey(row, column));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3229.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context3230 = new MethodContext(int.class, 252, 9212, 9307);
        try {
            CallChecker.varInit(this, "this", 252, 9212, 9307);
            CallChecker.varInit(this.entries, "entries", 252, 9212, 9307);
            CallChecker.varInit(this.columns, "columns", 252, 9212, 9307);
            CallChecker.varInit(this.rows, "rows", 252, 9212, 9307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 252, 9212, 9307);
            return rows;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3230.methodEnd();
        }
    }

    @Override
    public void setEntry(int row, int column, double value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3231 = new MethodContext(void.class, 258, 9314, 9713);
        try {
            CallChecker.varInit(this, "this", 258, 9314, 9713);
            CallChecker.varInit(value, "value", 258, 9314, 9713);
            CallChecker.varInit(column, "column", 258, 9314, 9713);
            CallChecker.varInit(row, "row", 258, 9314, 9713);
            CallChecker.varInit(this.entries, "entries", 258, 9314, 9713);
            CallChecker.varInit(this.columns, "columns", 258, 9314, 9713);
            CallChecker.varInit(this.rows, "rows", 258, 9314, 9713);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 258, 9314, 9713);
            MatrixUtils.checkRowIndex(this, row);
            MatrixUtils.checkColumnIndex(this, column);
            if (value == 0.0) {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 263, 9584, 9590)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 263, 9584, 9590).remove(computeKey(row, column));
                }
            }else {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 265, 9654, 9660)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 265, 9654, 9660).put(computeKey(row, column), value);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3231.methodEnd();
        }
    }

    @Override
    public void addToEntry(int row, int column, double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3232 = new MethodContext(void.class, 271, 9720, 10193);
        try {
            CallChecker.varInit(this, "this", 271, 9720, 10193);
            CallChecker.varInit(increment, "increment", 271, 9720, 10193);
            CallChecker.varInit(column, "column", 271, 9720, 10193);
            CallChecker.varInit(row, "row", 271, 9720, 10193);
            CallChecker.varInit(this.entries, "entries", 271, 9720, 10193);
            CallChecker.varInit(this.columns, "columns", 271, 9720, 10193);
            CallChecker.varInit(this.rows, "rows", 271, 9720, 10193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 271, 9720, 10193);
            MatrixUtils.checkRowIndex(this, row);
            MatrixUtils.checkColumnIndex(this, column);
            final int key = CallChecker.varInit(((int) (computeKey(row, column))), "key", 275, 9964, 10003);
            final double value = CallChecker.varInit(((double) ((CallChecker.isCalled(this.entries, OpenIntToDoubleHashMap.class, 276, 10034, 10040).get(key)) + increment)), "value", 276, 10013, 10062);
            if (value == 0.0) {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 278, 10104, 10110)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 278, 10104, 10110).remove(key);
                }
            }else {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 280, 10154, 10160)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 280, 10154, 10160).put(key, value);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3232.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(int row, int column, double factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3233 = new MethodContext(void.class, 286, 10200, 10670);
        try {
            CallChecker.varInit(this, "this", 286, 10200, 10670);
            CallChecker.varInit(factor, "factor", 286, 10200, 10670);
            CallChecker.varInit(column, "column", 286, 10200, 10670);
            CallChecker.varInit(row, "row", 286, 10200, 10670);
            CallChecker.varInit(this.entries, "entries", 286, 10200, 10670);
            CallChecker.varInit(this.columns, "columns", 286, 10200, 10670);
            CallChecker.varInit(this.rows, "rows", 286, 10200, 10670);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 286, 10200, 10670);
            MatrixUtils.checkRowIndex(this, row);
            MatrixUtils.checkColumnIndex(this, column);
            final int key = CallChecker.varInit(((int) (computeKey(row, column))), "key", 290, 10444, 10483);
            final double value = CallChecker.varInit(((double) ((CallChecker.isCalled(this.entries, OpenIntToDoubleHashMap.class, 291, 10514, 10520).get(key)) * factor)), "value", 291, 10493, 10539);
            if (value == 0.0) {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 293, 10581, 10587)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 293, 10581, 10587).remove(key);
                }
            }else {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 295, 10631, 10637)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 295, 10631, 10637).put(key, value);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3233.methodEnd();
        }
    }

    private int computeKey(int row, int column) {
        MethodContext _bcornu_methode_context3234 = new MethodContext(int.class, 305, 10677, 11001);
        try {
            CallChecker.varInit(this, "this", 305, 10677, 11001);
            CallChecker.varInit(column, "column", 305, 10677, 11001);
            CallChecker.varInit(row, "row", 305, 10677, 11001);
            CallChecker.varInit(this.entries, "entries", 305, 10677, 11001);
            CallChecker.varInit(this.columns, "columns", 305, 10677, 11001);
            CallChecker.varInit(this.rows, "rows", 305, 10677, 11001);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealMatrix.serialVersionUID", 305, 10677, 11001);
            return (row * (columns)) + column;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3234.methodEnd();
        }
    }
}

