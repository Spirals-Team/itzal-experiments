package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

@Deprecated
public class SparseFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> {
    private final OpenIntToFieldHashMap<T> entries;

    private final int rows;

    private final int columns;

    public SparseFieldMatrix(final Field<T> field) {
        super(field);
        ConstructorContext _bcornu_methode_context1228 = new ConstructorContext(SparseFieldMatrix.class, 50, 1683, 1967);
        try {
            rows = 0;
            CallChecker.varAssign(this.rows, "this.rows", 52, 1878, 1886);
            columns = 0;
            CallChecker.varAssign(this.columns, "this.columns", 53, 1896, 1906);
            entries = new OpenIntToFieldHashMap<T>(field);
            CallChecker.varAssign(this.entries, "this.entries", 54, 1916, 1961);
        } finally {
            _bcornu_methode_context1228.methodEnd();
        }
    }

    public SparseFieldMatrix(final Field<T> field, final int rowDimension, final int columnDimension) {
        super(field, rowDimension, columnDimension);
        ConstructorContext _bcornu_methode_context1229 = new ConstructorContext(SparseFieldMatrix.class, 67, 1974, 2719);
        try {
            this.rows = rowDimension;
            CallChecker.varAssign(this.rows, "this.rows", 70, 2594, 2618);
            this.columns = columnDimension;
            CallChecker.varAssign(this.columns, "this.columns", 71, 2628, 2658);
            entries = new OpenIntToFieldHashMap<T>(field);
            CallChecker.varAssign(this.entries, "this.entries", 72, 2668, 2713);
        } finally {
            _bcornu_methode_context1229.methodEnd();
        }
    }

    public SparseFieldMatrix(SparseFieldMatrix<T> other) {
        super(CallChecker.isCalled(other, SparseFieldMatrix.class, 81, 2881, 2885).getField(), CallChecker.isCalled(other, SparseFieldMatrix.class, 81, 2899, 2903).getRowDimension(), CallChecker.isCalled(other, SparseFieldMatrix.class, 81, 2924, 2928).getColumnDimension());
        ConstructorContext _bcornu_methode_context1230 = new ConstructorContext(SparseFieldMatrix.class, 80, 2726, 3106);
        try {
            other = CallChecker.beforeCalled(other, SparseFieldMatrix.class, 82, 2968, 2972);
            rows = CallChecker.isCalled(other, SparseFieldMatrix.class, 82, 2968, 2972).getRowDimension();
            CallChecker.varAssign(this.rows, "this.rows", 82, 2961, 2991);
            other = CallChecker.beforeCalled(other, SparseFieldMatrix.class, 83, 3011, 3015);
            columns = CallChecker.isCalled(other, SparseFieldMatrix.class, 83, 3011, 3015).getColumnDimension();
            CallChecker.varAssign(this.columns, "this.columns", 83, 3001, 3037);
            other = CallChecker.beforeCalled(other, SparseFieldMatrix.class, 84, 3086, 3090);
            entries = new OpenIntToFieldHashMap<T>(CallChecker.isCalled(other, SparseFieldMatrix.class, 84, 3086, 3090).entries);
            CallChecker.varAssign(this.entries, "this.entries", 84, 3047, 3100);
        } finally {
            _bcornu_methode_context1230.methodEnd();
        }
    }

    public SparseFieldMatrix(FieldMatrix<T> other) {
        super(CallChecker.isCalled(other, FieldMatrix.class, 93, 3269, 3273).getField(), CallChecker.isCalled(other, FieldMatrix.class, 93, 3287, 3291).getRowDimension(), CallChecker.isCalled(other, FieldMatrix.class, 93, 3312, 3316).getColumnDimension());
        ConstructorContext _bcornu_methode_context1231 = new ConstructorContext(SparseFieldMatrix.class, 92, 3113, 3658);
        try {
            other = CallChecker.beforeCalled(other, FieldMatrix.class, 94, 3356, 3360);
            rows = CallChecker.isCalled(other, FieldMatrix.class, 94, 3356, 3360).getRowDimension();
            CallChecker.varAssign(this.rows, "this.rows", 94, 3349, 3379);
            other = CallChecker.beforeCalled(other, FieldMatrix.class, 95, 3399, 3403);
            columns = CallChecker.isCalled(other, FieldMatrix.class, 95, 3399, 3403).getColumnDimension();
            CallChecker.varAssign(this.columns, "this.columns", 95, 3389, 3425);
            entries = new OpenIntToFieldHashMap<T>(getField());
            CallChecker.varAssign(this.entries, "this.entries", 96, 3435, 3485);
            for (int i = 0; i < (rows); i++) {
                for (int j = 0; j < (columns); j++) {
                    if (CallChecker.beforeDeref(other, FieldMatrix.class, 99, 3607, 3611)) {
                        setEntry(i, j, other.getEntry(i, j));
                    }
                }
            }
        } finally {
            _bcornu_methode_context1231.methodEnd();
        }
    }

    @Override
    public void addToEntry(int row, int column, T increment) {
        MethodContext _bcornu_methode_context5536 = new MethodContext(void.class, 106, 3665, 4082);
        try {
            CallChecker.varInit(this, "this", 106, 3665, 4082);
            CallChecker.varInit(increment, "increment", 106, 3665, 4082);
            CallChecker.varInit(column, "column", 106, 3665, 4082);
            CallChecker.varInit(row, "row", 106, 3665, 4082);
            CallChecker.varInit(this.columns, "columns", 106, 3665, 4082);
            CallChecker.varInit(this.rows, "rows", 106, 3665, 4082);
            CallChecker.varInit(this.entries, "entries", 106, 3665, 4082);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int key = CallChecker.varInit(((int) (computeKey(row, column))), "key", 109, 3833, 3872);
            final T value = CallChecker.varInit(entries.get(key).add(increment), "value", 110, 3882, 3929);
            final Field<T> npe_invocation_var1008 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var1008, Field.class, 111, 3943, 3952)) {
                final FieldElement<T> npe_invocation_var1009 = npe_invocation_var1008.getZero();
                if (CallChecker.beforeDeref(npe_invocation_var1009, FieldElement.class, 111, 3943, 3962)) {
                    if (CallChecker.isCalled(npe_invocation_var1009, FieldElement.class, 111, 3943, 3962).equals(value)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 112, 3993, 3999)) {
                            entries.remove(key);
                        }
                    }else {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 114, 4043, 4049)) {
                            entries.put(key, value);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5536.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> copy() {
        MethodContext _bcornu_methode_context5537 = new MethodContext(FieldMatrix.class, 120, 4089, 4210);
        try {
            CallChecker.varInit(this, "this", 120, 4089, 4210);
            CallChecker.varInit(this.columns, "columns", 120, 4089, 4210);
            CallChecker.varInit(this.rows, "rows", 120, 4089, 4210);
            CallChecker.varInit(this.entries, "entries", 120, 4089, 4210);
            return new SparseFieldMatrix<T>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5537.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> createMatrix(int rowDimension, int columnDimension) {
        MethodContext _bcornu_methode_context5538 = new MethodContext(FieldMatrix.class, 126, 4217, 4420);
        try {
            CallChecker.varInit(this, "this", 126, 4217, 4420);
            CallChecker.varInit(columnDimension, "columnDimension", 126, 4217, 4420);
            CallChecker.varInit(rowDimension, "rowDimension", 126, 4217, 4420);
            CallChecker.varInit(this.columns, "columns", 126, 4217, 4420);
            CallChecker.varInit(this.rows, "rows", 126, 4217, 4420);
            CallChecker.varInit(this.entries, "entries", 126, 4217, 4420);
            return new SparseFieldMatrix<T>(getField(), rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5538.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context5539 = new MethodContext(int.class, 132, 4427, 4528);
        try {
            CallChecker.varInit(this, "this", 132, 4427, 4528);
            CallChecker.varInit(this.columns, "columns", 132, 4427, 4528);
            CallChecker.varInit(this.rows, "rows", 132, 4427, 4528);
            CallChecker.varInit(this.entries, "entries", 132, 4427, 4528);
            return columns;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5539.methodEnd();
        }
    }

    @Override
    public T getEntry(int row, int column) {
        MethodContext _bcornu_methode_context5540 = new MethodContext(null, 138, 4535, 4734);
        try {
            CallChecker.varInit(this, "this", 138, 4535, 4734);
            CallChecker.varInit(column, "column", 138, 4535, 4734);
            CallChecker.varInit(row, "row", 138, 4535, 4734);
            CallChecker.varInit(this.columns, "columns", 138, 4535, 4734);
            CallChecker.varInit(this.rows, "rows", 138, 4535, 4734);
            CallChecker.varInit(this.entries, "entries", 138, 4535, 4734);
            checkRowIndex(row);
            checkColumnIndex(column);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 141, 4692, 4698)) {
                return entries.get(computeKey(row, column));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5540.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context5541 = new MethodContext(int.class, 146, 4741, 4836);
        try {
            CallChecker.varInit(this, "this", 146, 4741, 4836);
            CallChecker.varInit(this.columns, "columns", 146, 4741, 4836);
            CallChecker.varInit(this.rows, "rows", 146, 4741, 4836);
            CallChecker.varInit(this.entries, "entries", 146, 4741, 4836);
            return rows;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5541.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(int row, int column, T factor) {
        MethodContext _bcornu_methode_context5542 = new MethodContext(void.class, 152, 4843, 5263);
        try {
            CallChecker.varInit(this, "this", 152, 4843, 5263);
            CallChecker.varInit(factor, "factor", 152, 4843, 5263);
            CallChecker.varInit(column, "column", 152, 4843, 5263);
            CallChecker.varInit(row, "row", 152, 4843, 5263);
            CallChecker.varInit(this.columns, "columns", 152, 4843, 5263);
            CallChecker.varInit(this.rows, "rows", 152, 4843, 5263);
            CallChecker.varInit(this.entries, "entries", 152, 4843, 5263);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int key = CallChecker.varInit(((int) (computeKey(row, column))), "key", 155, 5011, 5050);
            final T value = CallChecker.varInit(entries.get(key).multiply(factor), "value", 156, 5060, 5109);
            final Field<T> npe_invocation_var1010 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var1010, Field.class, 157, 5123, 5132)) {
                final FieldElement<T> npe_invocation_var1011 = npe_invocation_var1010.getZero();
                if (CallChecker.beforeDeref(npe_invocation_var1011, FieldElement.class, 157, 5123, 5142)) {
                    if (CallChecker.isCalled(npe_invocation_var1011, FieldElement.class, 157, 5123, 5142).equals(value)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 158, 5173, 5179)) {
                            entries.remove(key);
                        }
                    }else {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 160, 5223, 5229)) {
                            entries.put(key, value);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5542.methodEnd();
        }
    }

    @Override
    public void setEntry(int row, int column, T value) {
        MethodContext _bcornu_methode_context5543 = new MethodContext(void.class, 167, 5270, 5615);
        try {
            CallChecker.varInit(this, "this", 167, 5270, 5615);
            CallChecker.varInit(value, "value", 167, 5270, 5615);
            CallChecker.varInit(column, "column", 167, 5270, 5615);
            CallChecker.varInit(row, "row", 167, 5270, 5615);
            CallChecker.varInit(this.columns, "columns", 167, 5270, 5615);
            CallChecker.varInit(this.rows, "rows", 167, 5270, 5615);
            CallChecker.varInit(this.entries, "entries", 167, 5270, 5615);
            checkRowIndex(row);
            checkColumnIndex(column);
            final Field<T> npe_invocation_var1012 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var1012, Field.class, 170, 5436, 5445)) {
                final FieldElement<T> npe_invocation_var1013 = npe_invocation_var1012.getZero();
                if (CallChecker.beforeDeref(npe_invocation_var1013, FieldElement.class, 170, 5436, 5455)) {
                    if (CallChecker.isCalled(npe_invocation_var1013, FieldElement.class, 170, 5436, 5455).equals(value)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 171, 5486, 5492)) {
                            entries.remove(computeKey(row, column));
                        }
                    }else {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 173, 5556, 5562)) {
                            entries.put(computeKey(row, column), value);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5543.methodEnd();
        }
    }

    private int computeKey(int row, int column) {
        MethodContext _bcornu_methode_context5544 = new MethodContext(int.class, 184, 5622, 5961);
        try {
            CallChecker.varInit(this, "this", 184, 5622, 5961);
            CallChecker.varInit(column, "column", 184, 5622, 5961);
            CallChecker.varInit(row, "row", 184, 5622, 5961);
            CallChecker.varInit(this.columns, "columns", 184, 5622, 5961);
            CallChecker.varInit(this.rows, "rows", 184, 5622, 5961);
            CallChecker.varInit(this.entries, "entries", 184, 5622, 5961);
            return (row * (columns)) + column;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5544.methodEnd();
        }
    }
}

