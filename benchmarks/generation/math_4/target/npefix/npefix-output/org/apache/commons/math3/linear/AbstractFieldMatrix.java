package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

public abstract class AbstractFieldMatrix<T extends FieldElement<T>> implements FieldMatrix<T> {
    private final Field<T> field;

    protected AbstractFieldMatrix() {
        ConstructorContext _bcornu_methode_context456 = new ConstructorContext(AbstractFieldMatrix.class, 52, 2060, 2181);
        try {
            field = null;
            CallChecker.varAssign(this.field, "this.field", 53, 2163, 2175);
        } finally {
            _bcornu_methode_context456.methodEnd();
        }
    }

    protected AbstractFieldMatrix(final Field<T> field) {
        ConstructorContext _bcornu_methode_context457 = new ConstructorContext(AbstractFieldMatrix.class, 60, 2188, 2382);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 61, 2358, 2376);
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    protected AbstractFieldMatrix(final Field<T> field, final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context458 = new ConstructorContext(AbstractFieldMatrix.class, 73, 2389, 3402);
        try {
            if (rowDimension <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, rowDimension);
            }
            if (columnDimension <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, columnDimension);
            }
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 85, 3378, 3396);
        } finally {
            _bcornu_methode_context458.methodEnd();
        }
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(final T[][] d) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context1946 = new MethodContext(Field.class, 97, 3409, 4223);
        try {
            CallChecker.varInit(d, "d", 97, 3409, 4223);
            if (d == null) {
                throw new NullArgumentException();
            }
            if ((d.length) == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
            }
            if (CallChecker.beforeDeref(CallChecker.isCalled(d, null, 105, 4077, 4077)[0], null, 105, 4077, 4080)) {
                d[0] = CallChecker.beforeCalled(d[0], null, 105, 4077, 4080);
                if ((CallChecker.isCalled(d[0], null, 105, 4077, 4080).length) == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(CallChecker.isCalled(d, null, 108, 4199, 4199)[0], null, 108, 4199, 4202)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(d, null, 108, 4199, 4199)[0][0], null, 108, 4199, 4205)) {
                    return d[0][0].getField();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1946.methodEnd();
        }
    }

    protected static <T extends FieldElement<T>> Field<T> extractField(final T[] d) throws NoDataException {
        MethodContext _bcornu_methode_context1947 = new MethodContext(Field.class, 119, 4230, 4744);
        try {
            CallChecker.varInit(d, "d", 119, 4230, 4744);
            if (CallChecker.beforeDeref(d, null, 121, 4607, 4607)) {
                if ((CallChecker.isCalled(d, null, 121, 4607, 4607).length) == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(d, null, 124, 4723, 4723)) {
                if (CallChecker.beforeDeref(d[0], null, 124, 4723, 4726)) {
                    return d[0].getField();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1947.methodEnd();
        }
    }

    @Deprecated
    protected static <T extends FieldElement<T>> T[][] buildArray(final Field<T> field, final int rows, final int columns) {
        MethodContext _bcornu_methode_context1948 = new MethodContext(null, 140, 4751, 5600);
        try {
            CallChecker.varInit(columns, "columns", 140, 4751, 5600);
            CallChecker.varInit(rows, "rows", 140, 4751, 5600);
            CallChecker.varInit(field, "field", 140, 4751, 5600);
            return MathArrays.buildArray(field, rows, columns);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1948.methodEnd();
        }
    }

    @Deprecated
    protected static <T extends FieldElement<T>> T[] buildArray(final Field<T> field, final int length) {
        MethodContext _bcornu_methode_context1949 = new MethodContext(null, 157, 5607, 6210);
        try {
            CallChecker.varInit(length, "length", 157, 5607, 6210);
            CallChecker.varInit(field, "field", 157, 5607, 6210);
            return MathArrays.buildArray(field, length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1949.methodEnd();
        }
    }

    public Field<T> getField() {
        MethodContext _bcornu_methode_context1950 = new MethodContext(Field.class, 163, 6217, 6297);
        try {
            CallChecker.varInit(this, "this", 163, 6217, 6297);
            CallChecker.varInit(this.field, "field", 163, 6217, 6297);
            return field;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1950.methodEnd();
        }
    }

    public abstract FieldMatrix<T> createMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException;

    public abstract FieldMatrix<T> copy();

    public FieldMatrix<T> add(FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1953 = new MethodContext(FieldMatrix.class, 176, 6591, 7192);
        try {
            CallChecker.varInit(this, "this", 176, 6591, 7192);
            CallChecker.varInit(m, "m", 176, 6591, 7192);
            CallChecker.varInit(this.field, "field", 176, 6591, 7192);
            checkAdditionCompatible(m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 181, 6779, 6820);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 182, 6830, 6874);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 183, 6884, 6946);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(m, FieldMatrix.class, 186, 7119, 7119)) {
                        final FieldElement<T> npe_invocation_var613 = getEntry(row, col);
                        if (CallChecker.beforeDeref(npe_invocation_var613, FieldElement.class, 186, 7096, 7113)) {
                            if (CallChecker.beforeDeref(out, FieldMatrix.class, 186, 7073, 7075)) {
                                CallChecker.isCalled(out, FieldMatrix.class, 186, 7073, 7075).setEntry(row, col, npe_invocation_var613.add(m.getEntry(row, col)));
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1953.methodEnd();
        }
    }

    public FieldMatrix<T> subtract(final FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1954 = new MethodContext(FieldMatrix.class, 194, 7199, 7819);
        try {
            CallChecker.varInit(this, "this", 194, 7199, 7819);
            CallChecker.varInit(m, "m", 194, 7199, 7819);
            CallChecker.varInit(this.field, "field", 194, 7199, 7819);
            checkSubtractionCompatible(m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 199, 7401, 7442);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 200, 7452, 7496);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 201, 7506, 7568);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(m, FieldMatrix.class, 204, 7746, 7746)) {
                        final FieldElement<T> npe_invocation_var614 = getEntry(row, col);
                        if (CallChecker.beforeDeref(npe_invocation_var614, FieldElement.class, 204, 7718, 7735)) {
                            if (CallChecker.beforeDeref(out, FieldMatrix.class, 204, 7695, 7697)) {
                                CallChecker.isCalled(out, FieldMatrix.class, 204, 7695, 7697).setEntry(row, col, npe_invocation_var614.subtract(m.getEntry(row, col)));
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1954.methodEnd();
        }
    }

    public FieldMatrix<T> scalarAdd(final T d) {
        MethodContext _bcornu_methode_context1955 = new MethodContext(FieldMatrix.class, 212, 7826, 8299);
        try {
            CallChecker.varInit(this, "this", 212, 7826, 8299);
            CallChecker.varInit(d, "d", 212, 7826, 8299);
            CallChecker.varInit(this.field, "field", 212, 7826, 8299);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 214, 7905, 7946);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 215, 7956, 8000);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 216, 8010, 8072);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    final FieldElement<T> npe_invocation_var615 = getEntry(row, col);
                    if (CallChecker.beforeDeref(npe_invocation_var615, FieldElement.class, 219, 8222, 8239)) {
                        if (CallChecker.beforeDeref(out, FieldMatrix.class, 219, 8199, 8201)) {
                            CallChecker.isCalled(out, FieldMatrix.class, 219, 8199, 8201).setEntry(row, col, npe_invocation_var615.add(d));
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1955.methodEnd();
        }
    }

    public FieldMatrix<T> scalarMultiply(final T d) {
        MethodContext _bcornu_methode_context1956 = new MethodContext(FieldMatrix.class, 227, 8306, 8788);
        try {
            CallChecker.varInit(this, "this", 227, 8306, 8788);
            CallChecker.varInit(d, "d", 227, 8306, 8788);
            CallChecker.varInit(this.field, "field", 227, 8306, 8788);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 228, 8389, 8430);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 229, 8440, 8484);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 230, 8494, 8556);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    final FieldElement<T> npe_invocation_var616 = getEntry(row, col);
                    if (CallChecker.beforeDeref(npe_invocation_var616, FieldElement.class, 233, 8706, 8723)) {
                        if (CallChecker.beforeDeref(out, FieldMatrix.class, 233, 8683, 8685)) {
                            CallChecker.isCalled(out, FieldMatrix.class, 233, 8683, 8685).setEntry(row, col, npe_invocation_var616.multiply(d));
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1956.methodEnd();
        }
    }

    public FieldMatrix<T> multiply(final FieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1957 = new MethodContext(FieldMatrix.class, 241, 8795, 9576);
        try {
            CallChecker.varInit(this, "this", 241, 8795, 9576);
            CallChecker.varInit(m, "m", 241, 8795, 9576);
            CallChecker.varInit(this.field, "field", 241, 8795, 9576);
            checkMultiplicationCompatible(m);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 246, 8994, 9029);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, FieldMatrix.class, 247, 9057, 9057).getColumnDimension())), "nCols", 247, 9039, 9079);
            final int nSum = CallChecker.varInit(((int) (getColumnDimension())), "nSum", 248, 9089, 9127);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(nRows, nCols), "out", 249, 9137, 9190);
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    T sum = CallChecker.init(null);
                    if (CallChecker.beforeDeref(field, Field.class, 252, 9316, 9320)) {
                        sum = field.getZero();
                        CallChecker.varAssign(sum, "sum", 252, 9316, 9320);
                    }
                    for (int i = 0; i < nSum; ++i) {
                        if (CallChecker.beforeDeref(m, FieldMatrix.class, 254, 9442, 9442)) {
                            final FieldElement<T> npe_invocation_var617 = getEntry(row, i);
                            if (CallChecker.beforeDeref(npe_invocation_var617, FieldElement.class, 254, 9416, 9431)) {
                                if (CallChecker.beforeDeref(sum, null, 254, 9408, 9410)) {
                                    sum = sum.add(npe_invocation_var617.multiply(m.getEntry(i, col)));
                                    CallChecker.varAssign(sum, "sum", 254, 9402, 9462);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(out, FieldMatrix.class, 256, 9498, 9500)) {
                        CallChecker.isCalled(out, FieldMatrix.class, 256, 9498, 9500).setEntry(row, col, sum);
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1957.methodEnd();
        }
    }

    public FieldMatrix<T> preMultiply(final FieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1958 = new MethodContext(FieldMatrix.class, 264, 9583, 9747);
        try {
            CallChecker.varInit(this, "this", 264, 9583, 9747);
            CallChecker.varInit(m, "m", 264, 9583, 9747);
            CallChecker.varInit(this.field, "field", 264, 9583, 9747);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 266, 9725, 9725)) {
                return CallChecker.isCalled(m, FieldMatrix.class, 266, 9725, 9725).multiply(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1958.methodEnd();
        }
    }

    public FieldMatrix<T> power(final int p) throws NotPositiveException, NonSquareMatrixException {
        MethodContext _bcornu_methode_context1959 = new MethodContext(FieldMatrix.class, 270, 9754, 11520);
        try {
            CallChecker.varInit(this, "this", 270, 9754, 11520);
            CallChecker.varInit(p, "p", 270, 9754, 11520);
            CallChecker.varInit(this.field, "field", 270, 9754, 11520);
            if (p < 0) {
                throw new NotPositiveException(p);
            }
            if (!(isSquare())) {
                throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
            }
            if (p == 0) {
                return MatrixUtils.createFieldIdentityMatrix(this.getField(), this.getRowDimension());
            }
            if (p == 1) {
                return this.copy();
            }
            final int power = CallChecker.varInit(((int) (p - 1)), "power", 288, 10291, 10314);
            final char[] binaryRepresentation = CallChecker.varInit(CallChecker.isCalled(Integer.toBinaryString(power), String.class, 297, 10570, 10598).toCharArray(), "binaryRepresentation", 297, 10534, 10630);
            final ArrayList<Integer> nonZeroPositions = CallChecker.varInit(new ArrayList<Integer>(), "nonZeroPositions", 299, 10640, 10708);
            for (int i = 0; i < (CallChecker.isCalled(binaryRepresentation, char[].class, 301, 10739, 10758).length); ++i) {
                if (CallChecker.beforeDeref(binaryRepresentation, char[].class, 302, 10791, 10810)) {
                    if ((CallChecker.isCalled(binaryRepresentation, char[].class, 302, 10791, 10810)[i]) == '1') {
                        final int pos = CallChecker.varInit(((int) (((CallChecker.isCalled(binaryRepresentation, char[].class, 303, 10857, 10876).length) - i) - 1)), "pos", 303, 10841, 10892);
                        if (CallChecker.beforeDeref(nonZeroPositions, ArrayList.class, 304, 10910, 10925)) {
                            CallChecker.isCalled(nonZeroPositions, ArrayList.class, 304, 10910, 10925).add(pos);
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            ArrayList<FieldMatrix<T>> results = CallChecker.init(ArrayList.class);
            if (CallChecker.beforeDeref(binaryRepresentation, char[].class, 309, 11053, 11072)) {
                results = new ArrayList<FieldMatrix<T>>(CallChecker.isCalled(binaryRepresentation, char[].class, 309, 11053, 11072).length);
                CallChecker.varAssign(results, "results", 309, 11053, 11072);
            }
            if (CallChecker.beforeDeref(results, ArrayList.class, 311, 11092, 11098)) {
                results = CallChecker.beforeCalled(results, ArrayList.class, 311, 11092, 11098);
                CallChecker.isCalled(results, ArrayList.class, 311, 11092, 11098).add(0, this.copy());
            }
            for (int i = 1; i < (CallChecker.isCalled(binaryRepresentation, char[].class, 313, 11150, 11169).length); ++i) {
                results = CallChecker.beforeCalled(results, ArrayList.class, 314, 11223, 11229);
                final FieldMatrix<T> s = CallChecker.varInit(CallChecker.isCalled(results, ArrayList.class, 314, 11223, 11229).get((i - 1)), "s", 314, 11198, 11241);
                final FieldMatrix<T> r = CallChecker.varInit(CallChecker.isCalled(s, FieldMatrix.class, 315, 11280, 11280).multiply(s), "r", 315, 11255, 11293);
                if (CallChecker.beforeDeref(results, ArrayList.class, 316, 11307, 11313)) {
                    results = CallChecker.beforeCalled(results, ArrayList.class, 316, 11307, 11313);
                    CallChecker.isCalled(results, ArrayList.class, 316, 11307, 11313).add(i, r);
                }
            }
            FieldMatrix<T> result = CallChecker.varInit(this.copy(), "result", 319, 11345, 11380);
            if (CallChecker.beforeDeref(nonZeroPositions, FieldMatrix.class, 321, 11408, 11423)) {
                for (Integer i : nonZeroPositions) {
                    if (CallChecker.beforeDeref(results, ArrayList.class, 322, 11465, 11471)) {
                        if (CallChecker.beforeDeref(result, FieldMatrix.class, 322, 11449, 11454)) {
                            results = CallChecker.beforeCalled(results, ArrayList.class, 322, 11465, 11471);
                            result = CallChecker.beforeCalled(result, FieldMatrix.class, 322, 11449, 11454);
                            result = CallChecker.isCalled(result, FieldMatrix.class, 322, 11449, 11454).multiply(CallChecker.isCalled(results, ArrayList.class, 322, 11465, 11471).get(i));
                            CallChecker.varAssign(result, "result", 322, 11440, 11480);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1959.methodEnd();
        }
    }

    public T[][] getData() {
        MethodContext _bcornu_methode_context1960 = new MethodContext(null, 329, 11527, 11909);
        try {
            CallChecker.varInit(this, "this", 329, 11527, 11909);
            CallChecker.varInit(this.field, "field", 329, 11527, 11909);
            final T[][] data = CallChecker.varInit(MathArrays.buildArray(field, getRowDimension(), getColumnDimension()), "data", 330, 11585, 11673);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 332, 11704, 11707).length); ++i) {
                final T[] dataI = CallChecker.varInit(CallChecker.isCalled(data, null, 333, 11754, 11757)[i], "dataI", 333, 11736, 11761);
                for (int j = 0; j < (CallChecker.isCalled(dataI, null, 334, 11795, 11799).length); ++j) {
                    if (CallChecker.beforeDeref(dataI, null, 335, 11832, 11836)) {
                        dataI[j] = getEntry(i, j);
                        CallChecker.varAssign(dataI[j], "dataI[j]", 335, 11832, 11857);
                    }
                }
            }
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1960.methodEnd();
        }
    }

    public FieldMatrix<T> getSubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1961 = new MethodContext(FieldMatrix.class, 343, 11916, 12603);
        try {
            CallChecker.varInit(this, "this", 343, 11916, 12603);
            CallChecker.varInit(endColumn, "endColumn", 343, 11916, 12603);
            CallChecker.varInit(startColumn, "startColumn", 343, 11916, 12603);
            CallChecker.varInit(endRow, "endRow", 343, 11916, 12603);
            CallChecker.varInit(startRow, "startRow", 343, 11916, 12603);
            CallChecker.varInit(this.field, "field", 343, 11916, 12603);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            final FieldMatrix<T> subMatrix = CallChecker.varInit(createMatrix(((endRow - startRow) + 1), ((endColumn - startColumn) + 1)), "subMatrix", 348, 12241, 12350);
            for (int i = startRow; i <= endRow; ++i) {
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(subMatrix, FieldMatrix.class, 352, 12480, 12488)) {
                        CallChecker.isCalled(subMatrix, FieldMatrix.class, 352, 12480, 12488).setEntry((i - startRow), (j - startColumn), getEntry(i, j));
                    }
                }
            }
            return subMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1961.methodEnd();
        }
    }

    public FieldMatrix<T> getSubMatrix(final int[] selectedRows, final int[] selectedColumns) throws NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1963 = new MethodContext(FieldMatrix.class, 361, 12610, 13428);
        try {
            CallChecker.varInit(this, "this", 361, 12610, 13428);
            CallChecker.varInit(selectedColumns, "selectedColumns", 361, 12610, 13428);
            CallChecker.varInit(selectedRows, "selectedRows", 361, 12610, 13428);
            CallChecker.varInit(this.field, "field", 361, 12610, 13428);
            checkSubMatrixIndex(selectedRows, selectedColumns);
            final FieldMatrix<T> subMatrix = CallChecker.varInit(createMatrix(CallChecker.isCalled(selectedRows, int[].class, 370, 13014, 13025).length, CallChecker.isCalled(selectedColumns, int[].class, 370, 13035, 13049).length), "subMatrix", 369, 12932, 13058);
            if (CallChecker.beforeDeref(field, Field.class, 371, 13140, 13144)) {
                if (CallChecker.beforeDeref(subMatrix, FieldMatrix.class, 371, 13068, 13076)) {
                    subMatrix.walkInOptimizedOrder(new DefaultFieldMatrixChangingVisitor<T>(field.getZero()) {
                        @Override
                        public T visit(final int row, final int column, final T value) {
                            MethodContext _bcornu_methode_context1962 = new MethodContext(null, 375, 13172, 13381);
                            try {
                                CallChecker.varInit(this, "this", 375, 13172, 13381);
                                CallChecker.varInit(value, "value", 375, 13172, 13381);
                                CallChecker.varInit(column, "column", 375, 13172, 13381);
                                CallChecker.varInit(row, "row", 375, 13172, 13381);
                                if (CallChecker.beforeDeref(selectedRows, int[].class, 376, 13324, 13335)) {
                                    if (CallChecker.beforeDeref(selectedColumns, int[].class, 376, 13343, 13357)) {
                                        return getEntry(CallChecker.isCalled(selectedRows, int[].class, 376, 13324, 13335)[row], CallChecker.isCalled(selectedColumns, int[].class, 376, 13343, 13357)[column]);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((T) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context1962.methodEnd();
                            }
                        }
                    });
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return subMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1963.methodEnd();
        }
    }

    public void copySubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn, final T[][] destination) throws NumberIsTooSmallException, OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1966 = new MethodContext(void.class, 386, 13435, 15278);
        try {
            CallChecker.varInit(this, "this", 386, 13435, 15278);
            CallChecker.varInit(destination, "destination", 386, 13435, 15278);
            CallChecker.varInit(endColumn, "endColumn", 386, 13435, 15278);
            CallChecker.varInit(startColumn, "startColumn", 386, 13435, 15278);
            CallChecker.varInit(endRow, "endRow", 386, 13435, 15278);
            CallChecker.varInit(startRow, "startRow", 386, 13435, 15278);
            CallChecker.varInit(this.field, "field", 386, 13435, 15278);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            final int rowsCount = CallChecker.varInit(((int) ((endRow + 1) - startRow)), "rowsCount", 393, 13854, 13900);
            final int columnsCount = CallChecker.varInit(((int) ((endColumn + 1) - startColumn)), "columnsCount", 394, 13910, 13962);
            if (CallChecker.beforeDeref(destination, null, 395, 13977, 13987)) {
                if (CallChecker.beforeDeref(destination, null, 395, 14013, 14023)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, null, 395, 14013, 14023)[0], null, 395, 14013, 14026)) {
                        CallChecker.isCalled(destination, null, 395, 14013, 14023)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, null, 395, 14013, 14023)[0], null, 395, 14013, 14026);
                        if (((CallChecker.isCalled(destination, null, 395, 13977, 13987).length) < rowsCount) || ((CallChecker.isCalled(CallChecker.isCalled(destination, null, 395, 14013, 14023)[0], null, 395, 14013, 14026).length) < columnsCount)) {
                            if (CallChecker.beforeDeref(destination, null, 396, 14109, 14119)) {
                                if (CallChecker.beforeDeref(destination, null, 397, 14184, 14194)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, null, 397, 14184, 14194)[0], null, 397, 14184, 14197)) {
                                        CallChecker.isCalled(destination, null, 397, 14184, 14194)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, null, 397, 14184, 14194)[0], null, 397, 14184, 14197);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, null, 396, 14109, 14119).length, CallChecker.isCalled(CallChecker.isCalled(destination, null, 397, 14184, 14194)[0], null, 397, 14184, 14197).length, rowsCount, columnsCount);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(field, Field.class, 403, 14450, 14454)) {
                walkInOptimizedOrder(new DefaultFieldMatrixPreservingVisitor<T>(field.getZero()) {
                    private int startRow;

                    private int startColumn;

                    @Override
                    public void start(final int rows, final int columns, final int startRow, final int endRow, final int startColumn, final int endColumn) {
                        MethodContext _bcornu_methode_context1964 = new MethodContext(void.class, 413, 14634, 14991);
                        try {
                            CallChecker.varInit(this, "this", 413, 14634, 14991);
                            CallChecker.varInit(endColumn, "endColumn", 413, 14634, 14991);
                            CallChecker.varInit(startColumn, "startColumn", 413, 14634, 14991);
                            CallChecker.varInit(endRow, "endRow", 413, 14634, 14991);
                            CallChecker.varInit(startRow, "startRow", 413, 14634, 14991);
                            CallChecker.varInit(columns, "columns", 413, 14634, 14991);
                            CallChecker.varInit(rows, "rows", 413, 14634, 14991);
                            this.startRow = startRow;
                            CallChecker.varAssign(this.startRow, "this.startRow", 416, 14902, 14929);
                            this.startColumn = startColumn;
                            CallChecker.varAssign(this.startColumn, "this.startColumn", 417, 14947, 14977);
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context1964.methodEnd();
                        }
                    }

                    @Override
                    public void visit(final int row, final int column, final T value) {
                        MethodContext _bcornu_methode_context1965 = new MethodContext(void.class, 422, 15006, 15216);
                        try {
                            CallChecker.varInit(this, "this", 422, 15006, 15216);
                            CallChecker.varInit(value, "value", 422, 15006, 15216);
                            CallChecker.varInit(column, "column", 422, 15006, 15216);
                            CallChecker.varInit(row, "row", 422, 15006, 15216);
                            if (CallChecker.beforeDeref(destination, null, 423, 15145, 15155)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(destination, null, 423, 15145, 15155)[(row - (startRow))], null, 423, 15145, 15171)) {
                                    CallChecker.isCalled(destination, null, 423, 15145, 15155)[(row - (startRow))][(column - (startColumn))] = value;
                                    CallChecker.varAssign(CallChecker.isCalled(destination, null, 423, 15145, 15155)[(row - (this.startRow))][(column - (this.startColumn))], "CallChecker.isCalled(destination, null, 423, 15145, 15155)[(row - (this.startRow))][(column - (this.startColumn))]", 423, 15145, 15202);
                                }
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context1965.methodEnd();
                        }
                    }
                }, startRow, endRow, startColumn, endColumn);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1966.methodEnd();
        }
    }

    public void copySubMatrix(int[] selectedRows, int[] selectedColumns, T[][] destination) throws NoDataException, NullArgumentException, OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1967 = new MethodContext(void.class, 431, 15285, 16350);
        try {
            CallChecker.varInit(this, "this", 431, 15285, 16350);
            CallChecker.varInit(destination, "destination", 431, 15285, 16350);
            CallChecker.varInit(selectedColumns, "selectedColumns", 431, 15285, 16350);
            CallChecker.varInit(selectedRows, "selectedRows", 431, 15285, 16350);
            CallChecker.varInit(this.field, "field", 431, 15285, 16350);
            checkSubMatrixIndex(selectedRows, selectedColumns);
            if (CallChecker.beforeDeref(destination, null, 436, 15615, 15625)) {
                if (CallChecker.beforeDeref(selectedRows, int[].class, 436, 15636, 15647)) {
                    if (CallChecker.beforeDeref(destination, null, 437, 15673, 15683)) {
                        destination = CallChecker.beforeCalled(destination, null, 437, 15673, 15683);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(destination, null, 437, 15673, 15683)[0], null, 437, 15673, 15686)) {
                            if (CallChecker.beforeDeref(selectedColumns, int[].class, 437, 15697, 15711)) {
                                destination = CallChecker.beforeCalled(destination, null, 436, 15615, 15625);
                                selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 436, 15636, 15647);
                                destination = CallChecker.beforeCalled(destination, null, 437, 15673, 15683);
                                CallChecker.isCalled(destination, null, 437, 15673, 15683)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, null, 437, 15673, 15683)[0], null, 437, 15673, 15686);
                                selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 437, 15697, 15711);
                                if (((CallChecker.isCalled(destination, null, 436, 15615, 15625).length) < (CallChecker.isCalled(selectedRows, int[].class, 436, 15636, 15647).length)) || ((CallChecker.isCalled(CallChecker.isCalled(destination, null, 437, 15673, 15683)[0], null, 437, 15673, 15686).length) < (CallChecker.isCalled(selectedColumns, int[].class, 437, 15697, 15711).length))) {
                                    if (CallChecker.beforeDeref(destination, null, 438, 15779, 15789)) {
                                        if (CallChecker.beforeDeref(destination, null, 439, 15854, 15864)) {
                                            destination = CallChecker.beforeCalled(destination, null, 439, 15854, 15864);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(destination, null, 439, 15854, 15864)[0], null, 439, 15854, 15867)) {
                                                if (CallChecker.beforeDeref(selectedRows, int[].class, 440, 15932, 15943)) {
                                                    if (CallChecker.beforeDeref(selectedColumns, int[].class, 441, 16008, 16022)) {
                                                        destination = CallChecker.beforeCalled(destination, null, 438, 15779, 15789);
                                                        destination = CallChecker.beforeCalled(destination, null, 439, 15854, 15864);
                                                        CallChecker.isCalled(destination, null, 439, 15854, 15864)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, null, 439, 15854, 15864)[0], null, 439, 15854, 15867);
                                                        selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 440, 15932, 15943);
                                                        selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 441, 16008, 16022);
                                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, null, 438, 15779, 15789).length, CallChecker.isCalled(CallChecker.isCalled(destination, null, 439, 15854, 15864)[0], null, 439, 15854, 15867).length, CallChecker.isCalled(selectedRows, int[].class, 440, 15932, 15943).length, CallChecker.isCalled(selectedColumns, int[].class, 441, 16008, 16022).length);
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                        }
                    }
                }
            }
            selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 445, 16096, 16107);
            for (int i = 0; i < (CallChecker.isCalled(selectedRows, int[].class, 445, 16096, 16107).length); i++) {
                destination = CallChecker.beforeCalled(destination, null, 446, 16161, 16171);
                final T[] destinationI = CallChecker.varInit(CallChecker.isCalled(destination, null, 446, 16161, 16171)[i], "destinationI", 446, 16136, 16175);
                selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 447, 16209, 16223);
                for (int j = 0; j < (CallChecker.isCalled(selectedColumns, int[].class, 447, 16209, 16223).length); j++) {
                    if (CallChecker.beforeDeref(destinationI, null, 448, 16256, 16267)) {
                        if (CallChecker.beforeDeref(selectedRows, int[].class, 448, 16283, 16294)) {
                            if (CallChecker.beforeDeref(selectedColumns, int[].class, 448, 16300, 16314)) {
                                selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 448, 16283, 16294);
                                selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 448, 16300, 16314);
                                destinationI[j] = getEntry(CallChecker.isCalled(selectedRows, int[].class, 448, 16283, 16294)[i], CallChecker.isCalled(selectedColumns, int[].class, 448, 16300, 16314)[j]);
                                CallChecker.varAssign(destinationI[j], "destinationI[j]", 448, 16256, 16319);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1967.methodEnd();
        }
    }

    public void setSubMatrix(final T[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1968 = new MethodContext(void.class, 455, 16357, 17537);
        try {
            CallChecker.varInit(this, "this", 455, 16357, 17537);
            CallChecker.varInit(column, "column", 455, 16357, 17537);
            CallChecker.varInit(row, "row", 455, 16357, 17537);
            CallChecker.varInit(subMatrix, "subMatrix", 455, 16357, 17537);
            CallChecker.varInit(this.field, "field", 455, 16357, 17537);
            if (subMatrix == null) {
                throw new NullArgumentException();
            }
            final int nRows = CallChecker.varInit(((int) (subMatrix.length)), "nRows", 462, 16703, 16737);
            if (nRows == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
            }
            subMatrix[0] = CallChecker.beforeCalled(subMatrix[0], null, 467, 16876, 16887);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(subMatrix[0], null, 467, 16876, 16887).length)), "nCols", 467, 16858, 16895);
            if (nCols == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            for (int r = 1; r < nRows; ++r) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, null, 473, 17069, 17077)[r], null, 473, 17069, 17080)) {
                    subMatrix[r] = CallChecker.beforeCalled(subMatrix[r], null, 473, 17069, 17080);
                    if ((CallChecker.isCalled(subMatrix[r], null, 473, 17069, 17080).length) != nCols) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, null, 474, 17161, 17169)[r], null, 474, 17161, 17172)) {
                            subMatrix[r] = CallChecker.beforeCalled(subMatrix[r], null, 474, 17161, 17172);
                            throw new DimensionMismatchException(nCols, CallChecker.isCalled(subMatrix[r], null, 474, 17161, 17172).length);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            checkRowIndex(row);
            checkColumnIndex(column);
            checkRowIndex(((nRows + row) - 1));
            checkColumnIndex(((nCols + column) - 1));
            for (int i = 0; i < nRows; ++i) {
                for (int j = 0; j < nCols; ++j) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, null, 485, 17491, 17499)[i], null, 485, 17491, 17502)) {
                        setEntry((row + i), (column + j), subMatrix[i][j]);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1968.methodEnd();
        }
    }

    public FieldMatrix<T> getRowMatrix(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1969 = new MethodContext(FieldMatrix.class, 491, 17544, 17911);
        try {
            CallChecker.varInit(this, "this", 491, 17544, 17911);
            CallChecker.varInit(row, "row", 491, 17544, 17911);
            CallChecker.varInit(this.field, "field", 491, 17544, 17911);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 493, 17684, 17722);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(1, nCols), "out", 494, 17732, 17781);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(out, FieldMatrix.class, 496, 17837, 17839)) {
                    CallChecker.isCalled(out, FieldMatrix.class, 496, 17837, 17839).setEntry(0, i, getEntry(row, i));
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1969.methodEnd();
        }
    }

    public void setRowMatrix(final int row, final FieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1970 = new MethodContext(void.class, 504, 17918, 18611);
        try {
            CallChecker.varInit(this, "this", 504, 17918, 18611);
            CallChecker.varInit(matrix, "matrix", 504, 17918, 18611);
            CallChecker.varInit(row, "row", 504, 17918, 18611);
            CallChecker.varInit(this.field, "field", 504, 17918, 18611);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 507, 18119, 18157);
            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 508, 18172, 18177)) {
                if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 509, 18219, 18224)) {
                    if (((CallChecker.isCalled(matrix, FieldMatrix.class, 508, 18172, 18177).getRowDimension()) != 1) || ((CallChecker.isCalled(matrix, FieldMatrix.class, 509, 18219, 18224).getColumnDimension()) != nCols)) {
                        if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 510, 18315, 18320)) {
                            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 511, 18396, 18401)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, FieldMatrix.class, 510, 18315, 18320).getRowDimension(), CallChecker.isCalled(matrix, FieldMatrix.class, 511, 18396, 18401).getColumnDimension(), 1, nCols);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 515, 18572, 18577)) {
                    setEntry(row, i, matrix.getEntry(0, i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1970.methodEnd();
        }
    }

    public FieldMatrix<T> getColumnMatrix(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1971 = new MethodContext(FieldMatrix.class, 521, 18618, 19002);
        try {
            CallChecker.varInit(this, "this", 521, 18618, 19002);
            CallChecker.varInit(column, "column", 521, 18618, 19002);
            CallChecker.varInit(this.field, "field", 521, 18618, 19002);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 525, 18775, 18810);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(nRows, 1), "out", 526, 18820, 18869);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(out, FieldMatrix.class, 528, 18925, 18927)) {
                    CallChecker.isCalled(out, FieldMatrix.class, 528, 18925, 18927).setEntry(i, 0, getEntry(i, column));
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1971.methodEnd();
        }
    }

    public void setColumnMatrix(final int column, final FieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1972 = new MethodContext(void.class, 536, 19009, 19714);
        try {
            CallChecker.varInit(this, "this", 536, 19009, 19714);
            CallChecker.varInit(matrix, "matrix", 536, 19009, 19714);
            CallChecker.varInit(column, "column", 536, 19009, 19714);
            CallChecker.varInit(this.field, "field", 536, 19009, 19714);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 539, 19222, 19257);
            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 540, 19272, 19277)) {
                if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 541, 19323, 19328)) {
                    if (((CallChecker.isCalled(matrix, FieldMatrix.class, 540, 19272, 19277).getRowDimension()) != nRows) || ((CallChecker.isCalled(matrix, FieldMatrix.class, 541, 19323, 19328).getColumnDimension()) != 1)) {
                        if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 542, 19415, 19420)) {
                            if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 543, 19496, 19501)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, FieldMatrix.class, 542, 19415, 19420).getRowDimension(), CallChecker.isCalled(matrix, FieldMatrix.class, 543, 19496, 19501).getColumnDimension(), nRows, 1);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(matrix, FieldMatrix.class, 547, 19675, 19680)) {
                    setEntry(i, column, matrix.getEntry(i, 0));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1972.methodEnd();
        }
    }

    public FieldVector<T> getRowVector(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1973 = new MethodContext(FieldVector.class, 553, 19721, 19904);
        try {
            CallChecker.varInit(this, "this", 553, 19721, 19904);
            CallChecker.varInit(row, "row", 553, 19721, 19904);
            CallChecker.varInit(this.field, "field", 553, 19721, 19904);
            return new ArrayFieldVector<T>(field, getRow(row), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1973.methodEnd();
        }
    }

    public void setRowVector(final int row, final FieldVector<T> vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1974 = new MethodContext(void.class, 559, 19911, 20462);
        try {
            CallChecker.varInit(this, "this", 559, 19911, 20462);
            CallChecker.varInit(vector, "vector", 559, 19911, 20462);
            CallChecker.varInit(row, "row", 559, 19911, 20462);
            CallChecker.varInit(this.field, "field", 559, 19911, 20462);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 562, 20112, 20150);
            if (CallChecker.beforeDeref(vector, FieldVector.class, 563, 20164, 20169)) {
                if ((CallChecker.isCalled(vector, FieldVector.class, 563, 20164, 20169).getDimension()) != nCols) {
                    if (CallChecker.beforeDeref(vector, FieldVector.class, 564, 20256, 20261)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(vector, FieldVector.class, 564, 20256, 20261).getDimension(), 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(vector, FieldVector.class, 568, 20426, 20431)) {
                    setEntry(row, i, vector.getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1974.methodEnd();
        }
    }

    public FieldVector<T> getColumnVector(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1975 = new MethodContext(FieldVector.class, 574, 20469, 20664);
        try {
            CallChecker.varInit(this, "this", 574, 20469, 20664);
            CallChecker.varInit(column, "column", 574, 20469, 20664);
            CallChecker.varInit(this.field, "field", 574, 20469, 20664);
            return new ArrayFieldVector<T>(field, getColumn(column), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1975.methodEnd();
        }
    }

    public void setColumnVector(final int column, final FieldVector<T> vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1976 = new MethodContext(void.class, 580, 20671, 21235);
        try {
            CallChecker.varInit(this, "this", 580, 20671, 21235);
            CallChecker.varInit(vector, "vector", 580, 20671, 21235);
            CallChecker.varInit(column, "column", 580, 20671, 21235);
            CallChecker.varInit(this.field, "field", 580, 20671, 21235);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 584, 20885, 20920);
            if (CallChecker.beforeDeref(vector, FieldVector.class, 585, 20934, 20939)) {
                if ((CallChecker.isCalled(vector, FieldVector.class, 585, 20934, 20939).getDimension()) != nRows) {
                    if (CallChecker.beforeDeref(vector, FieldVector.class, 586, 21023, 21028)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(vector, FieldVector.class, 586, 21023, 21028).getDimension(), 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(vector, FieldVector.class, 590, 21199, 21204)) {
                    setEntry(i, column, vector.getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1976.methodEnd();
        }
    }

    public T[] getRow(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1977 = new MethodContext(null, 596, 21242, 21583);
        try {
            CallChecker.varInit(this, "this", 596, 21242, 21583);
            CallChecker.varInit(row, "row", 596, 21242, 21583);
            CallChecker.varInit(this.field, "field", 596, 21242, 21583);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 598, 21365, 21403);
            final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nCols), "out", 599, 21413, 21464);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(out, null, 601, 21520, 21522)) {
                    out[i] = getEntry(row, i);
                    CallChecker.varAssign(out[i], "out[i]", 601, 21520, 21545);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1977.methodEnd();
        }
    }

    public void setRow(final int row, final T[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1978 = new MethodContext(void.class, 609, 21590, 22040);
        try {
            CallChecker.varInit(this, "this", 609, 21590, 22040);
            CallChecker.varInit(array, "array", 609, 21590, 22040);
            CallChecker.varInit(row, "row", 609, 21590, 22040);
            CallChecker.varInit(this.field, "field", 609, 21590, 22040);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 612, 21773, 21811);
            if (CallChecker.beforeDeref(array, null, 613, 21825, 21829)) {
                if ((CallChecker.isCalled(array, null, 613, 21825, 21829).length) != nCols) {
                    if (CallChecker.beforeDeref(array, null, 614, 21908, 21912)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(array, null, 614, 21908, 21912).length, 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(array, null, 617, 22014, 22018)) {
                    setEntry(row, i, array[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1978.methodEnd();
        }
    }

    public T[] getColumn(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1979 = new MethodContext(null, 623, 22047, 22400);
        try {
            CallChecker.varInit(this, "this", 623, 22047, 22400);
            CallChecker.varInit(column, "column", 623, 22047, 22400);
            CallChecker.varInit(this.field, "field", 623, 22047, 22400);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 625, 22182, 22217);
            final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nRows), "out", 626, 22227, 22278);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(out, null, 628, 22334, 22336)) {
                    out[i] = getEntry(i, column);
                    CallChecker.varAssign(out[i], "out[i]", 628, 22334, 22362);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1979.methodEnd();
        }
    }

    public void setColumn(final int column, final T[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1980 = new MethodContext(void.class, 636, 22407, 22868);
        try {
            CallChecker.varInit(this, "this", 636, 22407, 22868);
            CallChecker.varInit(array, "array", 636, 22407, 22868);
            CallChecker.varInit(column, "column", 636, 22407, 22868);
            CallChecker.varInit(this.field, "field", 636, 22407, 22868);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 639, 22602, 22637);
            if (CallChecker.beforeDeref(array, null, 640, 22651, 22655)) {
                if ((CallChecker.isCalled(array, null, 640, 22651, 22655).length) != nRows) {
                    if (CallChecker.beforeDeref(array, null, 641, 22731, 22735)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(array, null, 641, 22731, 22735).length, 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(array, null, 644, 22843, 22847)) {
                    setEntry(i, column, array[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1980.methodEnd();
        }
    }

    public abstract T getEntry(int row, int column) throws OutOfRangeException;

    public abstract void setEntry(int row, int column, T value) throws OutOfRangeException;

    public abstract void addToEntry(int row, int column, T increment) throws OutOfRangeException;

    public abstract void multiplyEntry(int row, int column, T factor) throws OutOfRangeException;

    public FieldMatrix<T> transpose() {
        MethodContext _bcornu_methode_context1986 = new MethodContext(FieldMatrix.class, 661, 23347, 23891);
        try {
            CallChecker.varInit(this, "this", 661, 23347, 23891);
            CallChecker.varInit(this.field, "field", 661, 23347, 23891);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 662, 23416, 23451);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 663, 23461, 23499);
            final FieldMatrix<T> out = CallChecker.varInit(createMatrix(nCols, nRows), "out", 664, 23509, 23562);
            if (CallChecker.beforeDeref(field, Field.class, 665, 23636, 23640)) {
                walkInOptimizedOrder(new DefaultFieldMatrixPreservingVisitor<T>(field.getZero()) {
                    @Override
                    public void visit(final int row, final int column, final T value) {
                        MethodContext _bcornu_methode_context1985 = new MethodContext(void.class, 668, 23667, 23852);
                        try {
                            CallChecker.varInit(this, "this", 668, 23667, 23852);
                            CallChecker.varInit(value, "value", 668, 23667, 23852);
                            CallChecker.varInit(column, "column", 668, 23667, 23852);
                            CallChecker.varInit(row, "row", 668, 23667, 23852);
                            if (CallChecker.beforeDeref(out, FieldMatrix.class, 669, 23806, 23808)) {
                                CallChecker.isCalled(out, FieldMatrix.class, 669, 23806, 23808).setEntry(column, row, value);
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context1985.methodEnd();
                        }
                    }
                });
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1986.methodEnd();
        }
    }

    public boolean isSquare() {
        MethodContext _bcornu_methode_context1987 = new MethodContext(boolean.class, 677, 23898, 24013);
        try {
            CallChecker.varInit(this, "this", 677, 23898, 24013);
            CallChecker.varInit(this.field, "field", 677, 23898, 24013);
            return (getColumnDimension()) == (getRowDimension());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1987.methodEnd();
        }
    }

    public abstract int getRowDimension();

    public abstract int getColumnDimension();

    public T getTrace() throws NonSquareMatrixException {
        MethodContext _bcornu_methode_context1990 = new MethodContext(null, 688, 24161, 24594);
        try {
            CallChecker.varInit(this, "this", 688, 24161, 24594);
            CallChecker.varInit(this.field, "field", 688, 24161, 24594);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 689, 24248, 24283);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 690, 24293, 24331);
            if (nRows != nCols) {
                throw new NonSquareMatrixException(nRows, nCols);
            }
            T trace = CallChecker.init(null);
            if (CallChecker.beforeDeref(field, Field.class, 694, 24452, 24456)) {
                trace = field.getZero();
                CallChecker.varAssign(trace, "trace", 694, 24452, 24456);
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(trace, null, 696, 24531, 24535)) {
                    trace = trace.add(getEntry(i, i));
                    CallChecker.varAssign(trace, "trace", 696, 24523, 24556);
                }
            }
            return trace;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1990.methodEnd();
        }
    }

    public T[] operate(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1991 = new MethodContext(null, 702, 24601, 25232);
        try {
            CallChecker.varInit(this, "this", 702, 24601, 25232);
            CallChecker.varInit(v, "v", 702, 24601, 25232);
            CallChecker.varInit(this.field, "field", 702, 24601, 25232);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 704, 24703, 24738);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 705, 24748, 24786);
            if (CallChecker.beforeDeref(v, null, 706, 24800, 24800)) {
                if ((CallChecker.isCalled(v, null, 706, 24800, 24800).length) != nCols) {
                    if (CallChecker.beforeDeref(v, null, 707, 24870, 24870)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 707, 24870, 24870).length, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nRows), "out", 710, 24907, 24958);
            for (int row = 0; row < nRows; ++row) {
                T sum = CallChecker.init(null);
                if (CallChecker.beforeDeref(field, Field.class, 712, 25028, 25032)) {
                    sum = field.getZero();
                    CallChecker.varAssign(sum, "sum", 712, 25028, 25032);
                }
                for (int i = 0; i < nCols; ++i) {
                    if (CallChecker.beforeDeref(v, null, 714, 25147, 25147)) {
                        final FieldElement<T> npe_invocation_var618 = getEntry(row, i);
                        if (CallChecker.beforeDeref(npe_invocation_var618, FieldElement.class, 714, 25121, 25136)) {
                            if (CallChecker.beforeDeref(sum, null, 714, 25113, 25115)) {
                                sum = sum.add(npe_invocation_var618.multiply(v[i]));
                                CallChecker.varAssign(sum, "sum", 714, 25107, 25153);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, null, 716, 25181, 25183)) {
                    out[row] = sum;
                    CallChecker.varAssign(out[row], "out[row]", 716, 25181, 25195);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1991.methodEnd();
        }
    }

    public FieldVector<T> operate(final FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1992 = new MethodContext(FieldVector.class, 723, 25239, 26193);
        try {
            CallChecker.varInit(this, "this", 723, 25239, 26193);
            CallChecker.varInit(v, "v", 723, 25239, 26193);
            CallChecker.varInit(this.field, "field", 723, 25239, 26193);
            TryContext _bcornu_try_context_34 = new TryContext(34, AbstractFieldMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(v, FieldVector.class, 726, 25457, 25457)) {
                    return new ArrayFieldVector<T>(field, operate(CallChecker.isCalled(((ArrayFieldVector<T>) (v)), ArrayFieldVector.class, 726, 25457, 25457).getDataRef()), false);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassCastException cce) {
                _bcornu_try_context_34.catchStart(34);
                final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 728, 25538, 25573);
                final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 729, 25587, 25625);
                if (CallChecker.beforeDeref(v, FieldVector.class, 730, 25643, 25643)) {
                    if ((CallChecker.isCalled(v, FieldVector.class, 730, 25643, 25643).getDimension()) != nCols) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 731, 25725, 25725)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(v, FieldVector.class, 731, 25725, 25725).getDimension(), nCols);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nRows), "out", 734, 25778, 25829);
                for (int row = 0; row < nRows; ++row) {
                    T sum = CallChecker.init(null);
                    if (CallChecker.beforeDeref(field, Field.class, 736, 25907, 25911)) {
                        sum = field.getZero();
                        CallChecker.varAssign(sum, "sum", 736, 25907, 25911);
                    }
                    for (int i = 0; i < nCols; ++i) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 738, 26034, 26034)) {
                            final FieldElement<T> npe_invocation_var619 = getEntry(row, i);
                            if (CallChecker.beforeDeref(npe_invocation_var619, FieldElement.class, 738, 26008, 26023)) {
                                if (CallChecker.beforeDeref(sum, null, 738, 26000, 26002)) {
                                    sum = sum.add(npe_invocation_var619.multiply(v.getEntry(i)));
                                    CallChecker.varAssign(sum, "sum", 738, 25994, 26049);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(out, null, 740, 26085, 26087)) {
                        out[row] = sum;
                        CallChecker.varAssign(out[row], "out[row]", 740, 26085, 26099);
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_34.finallyStart(34);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1992.methodEnd();
        }
    }

    public T[] preMultiply(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1993 = new MethodContext(null, 748, 26200, 26835);
        try {
            CallChecker.varInit(this, "this", 748, 26200, 26835);
            CallChecker.varInit(v, "v", 748, 26200, 26835);
            CallChecker.varInit(this.field, "field", 748, 26200, 26835);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 750, 26306, 26341);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 751, 26351, 26389);
            if (CallChecker.beforeDeref(v, null, 752, 26403, 26403)) {
                if ((CallChecker.isCalled(v, null, 752, 26403, 26403).length) != nRows) {
                    if (CallChecker.beforeDeref(v, null, 753, 26473, 26473)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 753, 26473, 26473).length, nRows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nCols), "out", 756, 26510, 26561);
            for (int col = 0; col < nCols; ++col) {
                T sum = CallChecker.init(null);
                if (CallChecker.beforeDeref(field, Field.class, 758, 26631, 26635)) {
                    sum = field.getZero();
                    CallChecker.varAssign(sum, "sum", 758, 26631, 26635);
                }
                for (int i = 0; i < nRows; ++i) {
                    if (CallChecker.beforeDeref(v, null, 760, 26750, 26750)) {
                        final FieldElement<T> npe_invocation_var620 = getEntry(i, col);
                        if (CallChecker.beforeDeref(npe_invocation_var620, FieldElement.class, 760, 26724, 26739)) {
                            if (CallChecker.beforeDeref(sum, null, 760, 26716, 26718)) {
                                sum = sum.add(npe_invocation_var620.multiply(v[i]));
                                CallChecker.varAssign(sum, "sum", 760, 26710, 26756);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, null, 762, 26784, 26786)) {
                    out[col] = sum;
                    CallChecker.varAssign(out[col], "out[col]", 762, 26784, 26798);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1993.methodEnd();
        }
    }

    public FieldVector<T> preMultiply(final FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1994 = new MethodContext(FieldVector.class, 769, 26842, 27804);
        try {
            CallChecker.varInit(this, "this", 769, 26842, 27804);
            CallChecker.varInit(v, "v", 769, 26842, 27804);
            CallChecker.varInit(this.field, "field", 769, 26842, 27804);
            TryContext _bcornu_try_context_35 = new TryContext(35, AbstractFieldMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(v, FieldVector.class, 772, 27068, 27068)) {
                    return new ArrayFieldVector<T>(field, preMultiply(CallChecker.isCalled(((ArrayFieldVector<T>) (v)), ArrayFieldVector.class, 772, 27068, 27068).getDataRef()), false);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassCastException cce) {
                _bcornu_try_context_35.catchStart(35);
                final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 774, 27149, 27184);
                final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 775, 27198, 27236);
                if (CallChecker.beforeDeref(v, FieldVector.class, 776, 27254, 27254)) {
                    if ((CallChecker.isCalled(v, FieldVector.class, 776, 27254, 27254).getDimension()) != nRows) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 777, 27336, 27336)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(v, FieldVector.class, 777, 27336, 27336).getDimension(), nRows);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final T[] out = CallChecker.varInit(MathArrays.buildArray(field, nCols), "out", 780, 27389, 27440);
                for (int col = 0; col < nCols; ++col) {
                    T sum = CallChecker.init(null);
                    if (CallChecker.beforeDeref(field, Field.class, 782, 27518, 27522)) {
                        sum = field.getZero();
                        CallChecker.varAssign(sum, "sum", 782, 27518, 27522);
                    }
                    for (int i = 0; i < nRows; ++i) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 784, 27645, 27645)) {
                            final FieldElement<T> npe_invocation_var621 = getEntry(i, col);
                            if (CallChecker.beforeDeref(npe_invocation_var621, FieldElement.class, 784, 27619, 27634)) {
                                if (CallChecker.beforeDeref(sum, null, 784, 27611, 27613)) {
                                    sum = sum.add(npe_invocation_var621.multiply(v.getEntry(i)));
                                    CallChecker.varAssign(sum, "sum", 784, 27605, 27660);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(out, null, 786, 27696, 27698)) {
                        out[col] = sum;
                        CallChecker.varAssign(out[col], "out[col]", 786, 27696, 27710);
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_35.finallyStart(35);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1994.methodEnd();
        }
    }

    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1995 = new MethodContext(null, 794, 27811, 28419);
        try {
            CallChecker.varInit(this, "this", 794, 27811, 28419);
            CallChecker.varInit(visitor, "visitor", 794, 27811, 28419);
            CallChecker.varInit(this.field, "field", 794, 27811, 28419);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 795, 27915, 27952);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 796, 27962, 28002);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 797, 28012, 28018)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 797, 28012, 28018).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int row = 0; row < rows; ++row) {
                for (int column = 0; column < columns; ++column) {
                    final T oldValue = CallChecker.varInit(getEntry(row, column), "oldValue", 800, 28197, 28237);
                    final T newValue = CallChecker.varInit(visitor.visit(row, column, oldValue), "newValue", 801, 28255, 28310);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 805, 28400, 28406)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1995.methodEnd();
        }
    }

    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1996 = new MethodContext(null, 809, 28426, 28923);
        try {
            CallChecker.varInit(this, "this", 809, 28426, 28923);
            CallChecker.varInit(visitor, "visitor", 809, 28426, 28923);
            CallChecker.varInit(this.field, "field", 809, 28426, 28923);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 810, 28532, 28569);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 811, 28579, 28619);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 812, 28629, 28635)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 812, 28629, 28635).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int row = 0; row < rows; ++row) {
                for (int column = 0; column < columns; ++column) {
                    if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 815, 28814, 28820)) {
                        CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 815, 28814, 28820).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 818, 28904, 28910)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1996.methodEnd();
        }
    }

    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1997 = new MethodContext(null, 822, 28930, 29796);
        try {
            CallChecker.varInit(this, "this", 822, 28930, 29796);
            CallChecker.varInit(endColumn, "endColumn", 822, 28930, 29796);
            CallChecker.varInit(startColumn, "startColumn", 822, 28930, 29796);
            CallChecker.varInit(endRow, "endRow", 822, 28930, 29796);
            CallChecker.varInit(startRow, "startRow", 822, 28930, 29796);
            CallChecker.varInit(visitor, "visitor", 822, 28930, 29796);
            CallChecker.varInit(this.field, "field", 822, 28930, 29796);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 827, 29305, 29311)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 827, 29305, 29311).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int row = startRow; row <= endRow; ++row) {
                for (int column = startColumn; column <= endColumn; ++column) {
                    final T oldValue = CallChecker.varInit(getEntry(row, column), "oldValue", 831, 29574, 29614);
                    final T newValue = CallChecker.varInit(visitor.visit(row, column, oldValue), "newValue", 832, 29632, 29687);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 836, 29777, 29783)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1997.methodEnd();
        }
    }

    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1998 = new MethodContext(null, 840, 29803, 30558);
        try {
            CallChecker.varInit(this, "this", 840, 29803, 30558);
            CallChecker.varInit(endColumn, "endColumn", 840, 29803, 30558);
            CallChecker.varInit(startColumn, "startColumn", 840, 29803, 30558);
            CallChecker.varInit(endRow, "endRow", 840, 29803, 30558);
            CallChecker.varInit(startRow, "startRow", 840, 29803, 30558);
            CallChecker.varInit(visitor, "visitor", 840, 29803, 30558);
            CallChecker.varInit(this.field, "field", 840, 29803, 30558);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 845, 30180, 30186)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 845, 30180, 30186).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int row = startRow; row <= endRow; ++row) {
                for (int column = startColumn; column <= endColumn; ++column) {
                    if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 849, 30449, 30455)) {
                        CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 849, 30449, 30455).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 852, 30539, 30545)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1998.methodEnd();
        }
    }

    public T walkInColumnOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context1999 = new MethodContext(null, 856, 30565, 31176);
        try {
            CallChecker.varInit(this, "this", 856, 30565, 31176);
            CallChecker.varInit(visitor, "visitor", 856, 30565, 31176);
            CallChecker.varInit(this.field, "field", 856, 30565, 31176);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 857, 30672, 30709);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 858, 30719, 30759);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 859, 30769, 30775)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 859, 30769, 30775).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int column = 0; column < columns; ++column) {
                for (int row = 0; row < rows; ++row) {
                    final T oldValue = CallChecker.varInit(getEntry(row, column), "oldValue", 862, 30954, 30994);
                    final T newValue = CallChecker.varInit(visitor.visit(row, column, oldValue), "newValue", 863, 31012, 31067);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 867, 31157, 31163)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1999.methodEnd();
        }
    }

    public T walkInColumnOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context2000 = new MethodContext(null, 871, 31183, 31683);
        try {
            CallChecker.varInit(this, "this", 871, 31183, 31683);
            CallChecker.varInit(visitor, "visitor", 871, 31183, 31683);
            CallChecker.varInit(this.field, "field", 871, 31183, 31683);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 872, 31292, 31329);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 873, 31339, 31379);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 874, 31389, 31395)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 874, 31389, 31395).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int column = 0; column < columns; ++column) {
                for (int row = 0; row < rows; ++row) {
                    if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 877, 31574, 31580)) {
                        CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 877, 31574, 31580).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 880, 31664, 31670)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2000.methodEnd();
        }
    }

    public T walkInColumnOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2001 = new MethodContext(null, 884, 31690, 32561);
        try {
            CallChecker.varInit(this, "this", 884, 31690, 32561);
            CallChecker.varInit(endColumn, "endColumn", 884, 31690, 32561);
            CallChecker.varInit(startColumn, "startColumn", 884, 31690, 32561);
            CallChecker.varInit(endRow, "endRow", 884, 31690, 32561);
            CallChecker.varInit(startRow, "startRow", 884, 31690, 32561);
            CallChecker.varInit(visitor, "visitor", 884, 31690, 32561);
            CallChecker.varInit(this.field, "field", 884, 31690, 32561);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 889, 32070, 32076)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 889, 32070, 32076).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int column = startColumn; column <= endColumn; ++column) {
                for (int row = startRow; row <= endRow; ++row) {
                    final T oldValue = CallChecker.varInit(getEntry(row, column), "oldValue", 893, 32339, 32379);
                    final T newValue = CallChecker.varInit(visitor.visit(row, column, oldValue), "newValue", 894, 32397, 32452);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 898, 32542, 32548)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2001.methodEnd();
        }
    }

    public T walkInColumnOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2002 = new MethodContext(null, 902, 32568, 33327);
        try {
            CallChecker.varInit(this, "this", 902, 32568, 33327);
            CallChecker.varInit(endColumn, "endColumn", 902, 32568, 33327);
            CallChecker.varInit(startColumn, "startColumn", 902, 32568, 33327);
            CallChecker.varInit(endRow, "endRow", 902, 32568, 33327);
            CallChecker.varInit(startRow, "startRow", 902, 32568, 33327);
            CallChecker.varInit(visitor, "visitor", 902, 32568, 33327);
            CallChecker.varInit(this.field, "field", 902, 32568, 33327);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 907, 32949, 32955)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 907, 32949, 32955).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int column = startColumn; column <= endColumn; ++column) {
                for (int row = startRow; row <= endRow; ++row) {
                    if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 911, 33218, 33224)) {
                        CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 911, 33218, 33224).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 914, 33308, 33314)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2002.methodEnd();
        }
    }

    public T walkInOptimizedOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context2003 = new MethodContext(null, 918, 33334, 33480);
        try {
            CallChecker.varInit(this, "this", 918, 33334, 33480);
            CallChecker.varInit(visitor, "visitor", 918, 33334, 33480);
            CallChecker.varInit(this.field, "field", 918, 33334, 33480);
            return walkInRowOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2003.methodEnd();
        }
    }

    public T walkInOptimizedOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context2004 = new MethodContext(null, 923, 33487, 33635);
        try {
            CallChecker.varInit(this, "this", 923, 33487, 33635);
            CallChecker.varInit(visitor, "visitor", 923, 33487, 33635);
            CallChecker.varInit(this.field, "field", 923, 33487, 33635);
            return walkInRowOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2004.methodEnd();
        }
    }

    public T walkInOptimizedOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2005 = new MethodContext(null, 928, 33642, 34042);
        try {
            CallChecker.varInit(this, "this", 928, 33642, 34042);
            CallChecker.varInit(endColumn, "endColumn", 928, 33642, 34042);
            CallChecker.varInit(startColumn, "startColumn", 928, 33642, 34042);
            CallChecker.varInit(endRow, "endRow", 928, 33642, 34042);
            CallChecker.varInit(startRow, "startRow", 928, 33642, 34042);
            CallChecker.varInit(visitor, "visitor", 928, 33642, 34042);
            CallChecker.varInit(this.field, "field", 928, 33642, 34042);
            return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2005.methodEnd();
        }
    }

    public T walkInOptimizedOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2006 = new MethodContext(null, 936, 34049, 34451);
        try {
            CallChecker.varInit(this, "this", 936, 34049, 34451);
            CallChecker.varInit(endColumn, "endColumn", 936, 34049, 34451);
            CallChecker.varInit(startColumn, "startColumn", 936, 34049, 34451);
            CallChecker.varInit(endRow, "endRow", 936, 34049, 34451);
            CallChecker.varInit(startRow, "startRow", 936, 34049, 34451);
            CallChecker.varInit(visitor, "visitor", 936, 34049, 34451);
            CallChecker.varInit(this.field, "field", 936, 34049, 34451);
            return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2006.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2007 = new MethodContext(String.class, 948, 34458, 35394);
        try {
            CallChecker.varInit(this, "this", 948, 34458, 35394);
            CallChecker.varInit(this.field, "field", 948, 34458, 35394);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 949, 34630, 34665);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 950, 34675, 34713);
            final StringBuffer res = CallChecker.varInit(new StringBuffer(), "res", 951, 34723, 34766);
            String fullClassName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(getClass(), Class.class, 952, 34799, 34808)) {
                fullClassName = CallChecker.isCalled(getClass(), Class.class, 952, 34799, 34808).getName();
                CallChecker.varAssign(fullClassName, "fullClassName", 952, 34799, 34808);
            }
            String shortClassName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(fullClassName, String.class, 953, 34877, 34889)) {
                if (CallChecker.beforeDeref(fullClassName, String.class, 953, 34853, 34865)) {
                    fullClassName = CallChecker.beforeCalled(fullClassName, String.class, 953, 34877, 34889);
                    fullClassName = CallChecker.beforeCalled(fullClassName, String.class, 953, 34853, 34865);
                    shortClassName = CallChecker.isCalled(fullClassName, String.class, 953, 34853, 34865).substring(((CallChecker.isCalled(fullClassName, String.class, 953, 34877, 34889).lastIndexOf('.')) + 1));
                    CallChecker.varAssign(shortClassName, "shortClassName", 953, 34877, 34889);
                }
            }
            if (CallChecker.beforeDeref(res, StringBuffer.class, 954, 34922, 34924)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(res, StringBuffer.class, 954, 34922, 34924).append(shortClassName), StringBuffer.class, 954, 34922, 34947)) {
                    CallChecker.isCalled(CallChecker.isCalled(res, StringBuffer.class, 954, 34922, 34924).append(shortClassName), StringBuffer.class, 954, 34922, 34947).append("{");
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(res, StringBuffer.class, 958, 35046, 35048)) {
                        CallChecker.isCalled(res, StringBuffer.class, 958, 35046, 35048).append(",");
                    }
                }
                if (CallChecker.beforeDeref(res, StringBuffer.class, 960, 35089, 35091)) {
                    CallChecker.isCalled(res, StringBuffer.class, 960, 35089, 35091).append("{");
                }
                for (int j = 0; j < nCols; ++j) {
                    if (j > 0) {
                        if (CallChecker.beforeDeref(res, StringBuffer.class, 963, 35201, 35203)) {
                            CallChecker.isCalled(res, StringBuffer.class, 963, 35201, 35203).append(",");
                        }
                    }
                    if (CallChecker.beforeDeref(res, StringBuffer.class, 965, 35252, 35254)) {
                        CallChecker.isCalled(res, StringBuffer.class, 965, 35252, 35254).append(getEntry(i, j));
                    }
                }
                if (CallChecker.beforeDeref(res, StringBuffer.class, 967, 35306, 35308)) {
                    CallChecker.isCalled(res, StringBuffer.class, 967, 35306, 35308).append("}");
                }
            }
            if (CallChecker.beforeDeref(res, StringBuffer.class, 970, 35342, 35344)) {
                CallChecker.isCalled(res, StringBuffer.class, 970, 35342, 35344).append("}");
            }
            if (CallChecker.beforeDeref(res, StringBuffer.class, 971, 35374, 35376)) {
                return CallChecker.isCalled(res, StringBuffer.class, 971, 35374, 35376).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2007.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object object) {
        MethodContext _bcornu_methode_context2008 = new MethodContext(boolean.class, 983, 35401, 36453);
        try {
            CallChecker.varInit(this, "this", 983, 35401, 36453);
            CallChecker.varInit(object, "object", 983, 35401, 36453);
            CallChecker.varInit(this.field, "field", 983, 35401, 36453);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof FieldMatrix<?>) == false) {
                return false;
            }
            FieldMatrix<?> m = CallChecker.varInit(((FieldMatrix<?>) (object)), "m", 990, 35928, 35970);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 991, 35980, 36015);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 992, 36025, 36063);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 993, 36077, 36077)) {
                if (CallChecker.beforeDeref(m, FieldMatrix.class, 993, 36112, 36112)) {
                    m = CallChecker.beforeCalled(m, FieldMatrix.class, 993, 36077, 36077);
                    m = CallChecker.beforeCalled(m, FieldMatrix.class, 993, 36112, 36112);
                    if (((CallChecker.isCalled(m, FieldMatrix.class, 993, 36077, 36077).getColumnDimension()) != nCols) || ((CallChecker.isCalled(m, FieldMatrix.class, 993, 36112, 36112).getRowDimension()) != nRows)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    if (CallChecker.beforeDeref(m, FieldMatrix.class, 998, 36327, 36327)) {
                        final FieldElement<T> npe_invocation_var622 = getEntry(row, col);
                        if (CallChecker.beforeDeref(npe_invocation_var622, FieldElement.class, 998, 36301, 36318)) {
                            if (!(CallChecker.isCalled(npe_invocation_var622, FieldElement.class, 998, 36301, 36318).equals(m.getEntry(row, col)))) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2008.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2009 = new MethodContext(int.class, 1012, 36460, 37024);
        try {
            CallChecker.varInit(this, "this", 1012, 36460, 37024);
            CallChecker.varInit(this.field, "field", 1012, 36460, 37024);
            int ret = CallChecker.varInit(((int) (322562)), "ret", 1013, 36607, 36623);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 1014, 36633, 36668);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 1015, 36678, 36716);
            ret = (ret * 31) + nRows;
            CallChecker.varAssign(ret, "ret", 1016, 36726, 36748);
            ret = (ret * 31) + nCols;
            CallChecker.varAssign(ret, "ret", 1017, 36758, 36780);
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    final FieldElement<T> npe_invocation_var623 = getEntry(row, col);
                    if (CallChecker.beforeDeref(npe_invocation_var623, FieldElement.class, 1020, 36946, 36963)) {
                        ret = (ret * 31) + (((11 * (row + 1)) + (17 * (col + 1))) * (CallChecker.isCalled(npe_invocation_var623, FieldElement.class, 1020, 36946, 36963).hashCode()));
                        CallChecker.varAssign(ret, "ret", 1020, 36897, 36975);
                    }
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2009.methodEnd();
        }
    }

    protected void checkRowIndex(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2010 = new MethodContext(void.class, 1032, 37031, 37478);
        try {
            CallChecker.varInit(this, "this", 1032, 37031, 37478);
            CallChecker.varInit(row, "row", 1032, 37031, 37478);
            CallChecker.varInit(this.field, "field", 1032, 37031, 37478);
            if ((row < 0) || (row >= (getRowDimension()))) {
                throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, row, 0, ((getRowDimension()) - 1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2010.methodEnd();
        }
    }

    protected void checkColumnIndex(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2011 = new MethodContext(void.class, 1045, 37485, 37973);
        try {
            CallChecker.varInit(this, "this", 1045, 37485, 37973);
            CallChecker.varInit(column, "column", 1045, 37485, 37973);
            CallChecker.varInit(this.field, "field", 1045, 37485, 37973);
            if ((column < 0) || (column >= (getColumnDimension()))) {
                throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, column, 0, ((getColumnDimension()) - 1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2011.methodEnd();
        }
    }

    protected void checkSubMatrixIndex(final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2012 = new MethodContext(void.class, 1065, 37980, 39270);
        try {
            CallChecker.varInit(this, "this", 1065, 37980, 39270);
            CallChecker.varInit(endColumn, "endColumn", 1065, 37980, 39270);
            CallChecker.varInit(startColumn, "startColumn", 1065, 37980, 39270);
            CallChecker.varInit(endRow, "endRow", 1065, 37980, 39270);
            CallChecker.varInit(startRow, "startRow", 1065, 37980, 39270);
            CallChecker.varInit(this.field, "field", 1065, 37980, 39270);
            checkRowIndex(startRow);
            checkRowIndex(endRow);
            if (endRow < startRow) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, endRow, startRow, true);
            }
            checkColumnIndex(startColumn);
            checkColumnIndex(endColumn);
            if (endColumn < startColumn) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, endColumn, startColumn, true);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2012.methodEnd();
        }
    }

    protected void checkSubMatrixIndex(final int[] selectedRows, final int[] selectedColumns) throws NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context2013 = new MethodContext(void.class, 1093, 39277, 40352);
        try {
            CallChecker.varInit(this, "this", 1093, 39277, 40352);
            CallChecker.varInit(selectedColumns, "selectedColumns", 1093, 39277, 40352);
            CallChecker.varInit(selectedRows, "selectedRows", 1093, 39277, 40352);
            CallChecker.varInit(this.field, "field", 1093, 39277, 40352);
            if ((selectedRows == null) || (selectedColumns == null)) {
                throw new NullArgumentException();
            }
            if (((selectedRows.length) == 0) || ((selectedColumns.length) == 0)) {
                throw new NoDataException();
            }
            for (final int row : selectedRows) {
                checkRowIndex(row);
            }
            for (final int column : selectedColumns) {
                checkColumnIndex(column);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2013.methodEnd();
        }
    }

    protected void checkAdditionCompatible(final FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context2014 = new MethodContext(void.class, 1119, 40359, 41039);
        try {
            CallChecker.varInit(this, "this", 1119, 40359, 41039);
            CallChecker.varInit(m, "m", 1119, 40359, 41039);
            CallChecker.varInit(this.field, "field", 1119, 40359, 41039);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 1121, 40740, 40740)) {
                if (CallChecker.beforeDeref(m, FieldMatrix.class, 1122, 40801, 40801)) {
                    if (((getRowDimension()) != (CallChecker.isCalled(m, FieldMatrix.class, 1121, 40740, 40740).getRowDimension())) || ((getColumnDimension()) != (CallChecker.isCalled(m, FieldMatrix.class, 1122, 40801, 40801).getColumnDimension()))) {
                        if (CallChecker.beforeDeref(m, FieldMatrix.class, 1123, 40883, 40883)) {
                            if (CallChecker.beforeDeref(m, FieldMatrix.class, 1123, 40904, 40904)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(m, FieldMatrix.class, 1123, 40883, 40883).getRowDimension(), CallChecker.isCalled(m, FieldMatrix.class, 1123, 40904, 40904).getColumnDimension(), getRowDimension(), getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2014.methodEnd();
        }
    }

    protected void checkSubtractionCompatible(final FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context2015 = new MethodContext(void.class, 1135, 41046, 41735);
        try {
            CallChecker.varInit(this, "this", 1135, 41046, 41735);
            CallChecker.varInit(m, "m", 1135, 41046, 41735);
            CallChecker.varInit(this.field, "field", 1135, 41046, 41735);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 1137, 41436, 41436)) {
                if (CallChecker.beforeDeref(m, FieldMatrix.class, 1138, 41497, 41497)) {
                    if (((getRowDimension()) != (CallChecker.isCalled(m, FieldMatrix.class, 1137, 41436, 41436).getRowDimension())) || ((getColumnDimension()) != (CallChecker.isCalled(m, FieldMatrix.class, 1138, 41497, 41497).getColumnDimension()))) {
                        if (CallChecker.beforeDeref(m, FieldMatrix.class, 1139, 41579, 41579)) {
                            if (CallChecker.beforeDeref(m, FieldMatrix.class, 1139, 41600, 41600)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(m, FieldMatrix.class, 1139, 41579, 41579).getRowDimension(), CallChecker.isCalled(m, FieldMatrix.class, 1139, 41600, 41600).getColumnDimension(), getRowDimension(), getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2015.methodEnd();
        }
    }

    protected void checkMultiplicationCompatible(final FieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2016 = new MethodContext(void.class, 1151, 41742, 42261);
        try {
            CallChecker.varInit(this, "this", 1151, 41742, 42261);
            CallChecker.varInit(m, "m", 1151, 41742, 42261);
            CallChecker.varInit(this.field, "field", 1151, 41742, 42261);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 1153, 42131, 42131)) {
                if ((getColumnDimension()) != (CallChecker.isCalled(m, FieldMatrix.class, 1153, 42131, 42131).getRowDimension())) {
                    if (CallChecker.beforeDeref(m, FieldMatrix.class, 1154, 42203, 42203)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(m, FieldMatrix.class, 1154, 42203, 42203).getRowDimension(), getColumnDimension());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2016.methodEnd();
        }
    }
}

