package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

public class MatrixUtils {
    private static class FractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<Fraction> {
        private double[][] data;

        public FractionMatrixConverter() {
            super(Fraction.ZERO);
            ConstructorContext _bcornu_methode_context1156 = new ConstructorContext(MatrixUtils.FractionMatrixConverter.class, 628, 24937, 25049);
            try {
            } finally {
                _bcornu_methode_context1156.methodEnd();
            }
        }

        @Override
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            MethodContext _bcornu_methode_context5200 = new MethodContext(void.class, 634, 25060, 25288);
            try {
                CallChecker.varInit(this, "this", 634, 25060, 25288);
                CallChecker.varInit(endColumn, "endColumn", 634, 25060, 25288);
                CallChecker.varInit(startColumn, "startColumn", 634, 25060, 25288);
                CallChecker.varInit(endRow, "endRow", 634, 25060, 25288);
                CallChecker.varInit(startRow, "startRow", 634, 25060, 25288);
                CallChecker.varInit(columns, "columns", 634, 25060, 25288);
                CallChecker.varInit(rows, "rows", 634, 25060, 25288);
                CallChecker.varInit(this.data, "data", 634, 25060, 25288);
                data = new double[rows][columns];
                CallChecker.varAssign(this.data, "this.data", 636, 25246, 25278);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5200.methodEnd();
            }
        }

        @Override
        public void visit(int row, int column, Fraction value) {
            MethodContext _bcornu_methode_context5201 = new MethodContext(void.class, 641, 25299, 25464);
            try {
                CallChecker.varInit(this, "this", 641, 25299, 25464);
                CallChecker.varInit(value, "value", 641, 25299, 25464);
                CallChecker.varInit(column, "column", 641, 25299, 25464);
                CallChecker.varInit(row, "row", 641, 25299, 25464);
                CallChecker.varInit(this.data, "data", 641, 25299, 25464);
                if (CallChecker.beforeDeref(data, double[][].class, 642, 25415, 25418)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 642, 25415, 25418);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 642, 25415, 25418)[row], double[].class, 642, 25415, 25423)) {
                        if (CallChecker.beforeDeref(value, Fraction.class, 642, 25435, 25439)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 642, 25415, 25418);
                            CallChecker.isCalled(data, double[][].class, 642, 25415, 25418)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 642, 25415, 25418)[row], double[].class, 642, 25415, 25423);
                            value = CallChecker.beforeCalled(value, Fraction.class, 642, 25435, 25439);
                            CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 642, 25415, 25418)[row], double[].class, 642, 25415, 25423)[column] = CallChecker.isCalled(value, Fraction.class, 642, 25435, 25439).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 642, 25415, 25418)[row], double[].class, 642, 25415, 25423)[column], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 642, 25415, 25418)[row], double[].class, 642, 25415, 25423)[column]", 642, 25415, 25454);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5201.methodEnd();
            }
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            MethodContext _bcornu_methode_context5202 = new MethodContext(Array2DRowRealMatrix.class, 650, 25475, 25698);
            try {
                CallChecker.varInit(this, "this", 650, 25475, 25698);
                CallChecker.varInit(this.data, "data", 650, 25475, 25698);
                return new Array2DRowRealMatrix(data, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5202.methodEnd();
            }
        }
    }

    private static class BigFractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<BigFraction> {
        private double[][] data;

        public BigFractionMatrixConverter() {
            super(BigFraction.ZERO);
            ConstructorContext _bcornu_methode_context1157 = new ConstructorContext(MatrixUtils.BigFractionMatrixConverter.class, 673, 26431, 26549);
            try {
            } finally {
                _bcornu_methode_context1157.methodEnd();
            }
        }

        @Override
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            MethodContext _bcornu_methode_context5203 = new MethodContext(void.class, 679, 26560, 26788);
            try {
                CallChecker.varInit(this, "this", 679, 26560, 26788);
                CallChecker.varInit(endColumn, "endColumn", 679, 26560, 26788);
                CallChecker.varInit(startColumn, "startColumn", 679, 26560, 26788);
                CallChecker.varInit(endRow, "endRow", 679, 26560, 26788);
                CallChecker.varInit(startRow, "startRow", 679, 26560, 26788);
                CallChecker.varInit(columns, "columns", 679, 26560, 26788);
                CallChecker.varInit(rows, "rows", 679, 26560, 26788);
                CallChecker.varInit(this.data, "data", 679, 26560, 26788);
                data = new double[rows][columns];
                CallChecker.varAssign(this.data, "this.data", 681, 26746, 26778);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5203.methodEnd();
            }
        }

        @Override
        public void visit(int row, int column, BigFraction value) {
            MethodContext _bcornu_methode_context5204 = new MethodContext(void.class, 686, 26799, 26967);
            try {
                CallChecker.varInit(this, "this", 686, 26799, 26967);
                CallChecker.varInit(value, "value", 686, 26799, 26967);
                CallChecker.varInit(column, "column", 686, 26799, 26967);
                CallChecker.varInit(row, "row", 686, 26799, 26967);
                CallChecker.varInit(this.data, "data", 686, 26799, 26967);
                if (CallChecker.beforeDeref(data, double[][].class, 687, 26918, 26921)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 687, 26918, 26921);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 687, 26918, 26921)[row], double[].class, 687, 26918, 26926)) {
                        if (CallChecker.beforeDeref(value, BigFraction.class, 687, 26938, 26942)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 687, 26918, 26921);
                            CallChecker.isCalled(data, double[][].class, 687, 26918, 26921)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 687, 26918, 26921)[row], double[].class, 687, 26918, 26926);
                            value = CallChecker.beforeCalled(value, BigFraction.class, 687, 26938, 26942);
                            CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 687, 26918, 26921)[row], double[].class, 687, 26918, 26926)[column] = CallChecker.isCalled(value, BigFraction.class, 687, 26938, 26942).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 687, 26918, 26921)[row], double[].class, 687, 26918, 26926)[column], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 687, 26918, 26921)[row], double[].class, 687, 26918, 26926)[column]", 687, 26918, 26957);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5204.methodEnd();
            }
        }

        Array2DRowRealMatrix getConvertedMatrix() {
            MethodContext _bcornu_methode_context5205 = new MethodContext(Array2DRowRealMatrix.class, 695, 26978, 27201);
            try {
                CallChecker.varInit(this, "this", 695, 26978, 27201);
                CallChecker.varInit(this.data, "data", 695, 26978, 27201);
                return new Array2DRowRealMatrix(data, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5205.methodEnd();
            }
        }
    }

    public static final RealMatrixFormat DEFAULT_FORMAT = RealMatrixFormat.getInstance();

    public static final RealMatrixFormat OCTAVE_FORMAT = new RealMatrixFormat("[", "]", "", "", "; ", ", ");

    private MatrixUtils() {
        super();
        ConstructorContext _bcornu_methode_context1158 = new ConstructorContext(MatrixUtils.class, 63, 2347, 2436);
        try {
        } finally {
            _bcornu_methode_context1158.methodEnd();
        }
    }

    public static RealMatrix createRealMatrix(final int rows, final int columns) {
        MethodContext _bcornu_methode_context5206 = new MethodContext(RealMatrix.class, 80, 2443, 3327);
        try {
            CallChecker.varInit(columns, "columns", 80, 2443, 3327);
            CallChecker.varInit(rows, "rows", 80, 2443, 3327);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 80, 2443, 3327);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 80, 2443, 3327);
            if ((rows * columns) <= 4096) {
                return new Array2DRowRealMatrix(rows, columns);
            }else {
                return new BlockRealMatrix(rows, columns);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5206.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(final Field<T> field, final int rows, final int columns) {
        MethodContext _bcornu_methode_context5207 = new MethodContext(FieldMatrix.class, 100, 3334, 4552);
        try {
            CallChecker.varInit(columns, "columns", 100, 3334, 4552);
            CallChecker.varInit(rows, "rows", 100, 3334, 4552);
            CallChecker.varInit(field, "field", 100, 3334, 4552);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 100, 3334, 4552);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 100, 3334, 4552);
            if ((rows * columns) <= 4096) {
                return new Array2DRowFieldMatrix<T>(field, rows, columns);
            }else {
                return new BlockFieldMatrix<T>(field, rows, columns);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5207.methodEnd();
        }
    }

    public static RealMatrix createRealMatrix(double[][] data) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5208 = new MethodContext(RealMatrix.class, 127, 4559, 6007);
        try {
            CallChecker.varInit(data, "data", 127, 4559, 6007);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 127, 4559, 6007);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 127, 4559, 6007);
            if ((data == null) || ((data[0]) == null)) {
                throw new NullArgumentException();
            }
            if (((data.length) * (data[0].length)) <= 4096) {
                return new Array2DRowRealMatrix(data);
            }else {
                return new BlockRealMatrix(data);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5208.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(T[][] data) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5209 = new MethodContext(FieldMatrix.class, 157, 6014, 7428);
        try {
            CallChecker.varInit(data, "data", 157, 6014, 7428);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 157, 6014, 7428);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 157, 6014, 7428);
            if ((data == null) || ((data[0]) == null)) {
                throw new NullArgumentException();
            }
            if (((data.length) * (data[0].length)) <= 4096) {
                return new Array2DRowFieldMatrix<T>(data);
            }else {
                return new BlockFieldMatrix<T>(data);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5209.methodEnd();
        }
    }

    public static RealMatrix createRealIdentityMatrix(int dimension) {
        MethodContext _bcornu_methode_context5210 = new MethodContext(RealMatrix.class, 175, 7435, 7957);
        try {
            CallChecker.varInit(dimension, "dimension", 175, 7435, 7957);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 175, 7435, 7957);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 175, 7435, 7957);
            final RealMatrix m = CallChecker.varInit(MatrixUtils.createRealMatrix(dimension, dimension), "m", 176, 7783, 7842);
            for (int i = 0; i < dimension; ++i) {
                if (CallChecker.beforeDeref(m, RealMatrix.class, 178, 7902, 7902)) {
                    CallChecker.isCalled(m, RealMatrix.class, 178, 7902, 7902).setEntry(i, i, 1.0);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5210.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldIdentityMatrix(final Field<T> field, final int dimension) {
        MethodContext _bcornu_methode_context5211 = new MethodContext(FieldMatrix.class, 194, 7964, 8863);
        try {
            CallChecker.varInit(dimension, "dimension", 194, 7964, 8863);
            CallChecker.varInit(field, "field", 194, 7964, 8863);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 194, 7964, 8863);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 194, 7964, 8863);
            final T zero = CallChecker.varInit(field.getZero(), "zero", 195, 8485, 8515);
            final T one = CallChecker.varInit(field.getOne(), "one", 196, 8525, 8554);
            final T[][] d = CallChecker.varInit(MathArrays.buildArray(field, dimension, dimension), "d", 197, 8564, 8630);
            for (int row = 0; row < dimension; row++) {
                final T[] dRow = CallChecker.varInit(CallChecker.isCalled(d, null, 199, 8713, 8713)[row], "dRow", 199, 8696, 8719);
                Arrays.fill(dRow, zero);
                if (CallChecker.beforeDeref(dRow, null, 201, 8770, 8773)) {
                    dRow[row] = one;
                    CallChecker.varAssign(dRow[row], "dRow[row]", 201, 8770, 8785);
                }
            }
            return new Array2DRowFieldMatrix<T>(field, d, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5211.methodEnd();
        }
    }

    public static RealMatrix createRealDiagonalMatrix(final double[] diagonal) {
        MethodContext _bcornu_methode_context5212 = new MethodContext(RealMatrix.class, 214, 8870, 9383);
        try {
            CallChecker.varInit(diagonal, "diagonal", 214, 8870, 9383);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 214, 8870, 9383);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 214, 8870, 9383);
            final RealMatrix m = CallChecker.varInit(MatrixUtils.createRealMatrix(CallChecker.isCalled(diagonal, double[].class, 215, 9221, 9228).length, CallChecker.isCalled(diagonal, double[].class, 215, 9238, 9245).length), "m", 215, 9183, 9254);
            for (int i = 0; i < (CallChecker.isCalled(diagonal, double[].class, 216, 9284, 9291).length); ++i) {
                if (CallChecker.beforeDeref(diagonal, double[].class, 217, 9337, 9344)) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 217, 9320, 9320)) {
                        CallChecker.isCalled(m, RealMatrix.class, 217, 9320, 9320).setEntry(i, i, CallChecker.isCalled(diagonal, double[].class, 217, 9337, 9344)[i]);
                    }
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5212.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldDiagonalMatrix(final T[] diagonal) {
        MethodContext _bcornu_methode_context5213 = new MethodContext(FieldMatrix.class, 232, 9390, 10029);
        try {
            CallChecker.varInit(diagonal, "diagonal", 232, 9390, 10029);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 232, 9390, 10029);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 232, 9390, 10029);
            final FieldMatrix<T> m = CallChecker.varInit(MatrixUtils.createFieldMatrix(diagonal[0].getField(), CallChecker.isCalled(diagonal, null, 234, 9867, 9874).length, CallChecker.isCalled(diagonal, null, 234, 9884, 9891).length), "m", 233, 9788, 9900);
            for (int i = 0; i < (CallChecker.isCalled(diagonal, null, 235, 9930, 9937).length); ++i) {
                if (CallChecker.beforeDeref(diagonal, null, 236, 9983, 9990)) {
                    if (CallChecker.beforeDeref(m, FieldMatrix.class, 236, 9966, 9966)) {
                        CallChecker.isCalled(m, FieldMatrix.class, 236, 9966, 9966).setEntry(i, i, diagonal[i]);
                    }
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5213.methodEnd();
        }
    }

    public static RealVector createRealVector(double[] data) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5214 = new MethodContext(RealVector.class, 249, 10036, 10583);
        try {
            CallChecker.varInit(data, "data", 249, 10036, 10583);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 249, 10036, 10583);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 249, 10036, 10583);
            if (data == null) {
                throw new NullArgumentException();
            }
            return new ArrayRealVector(data, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5214.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldVector<T> createFieldVector(final T[] data) throws NoDataException, NullArgumentException, ZeroException {
        MethodContext _bcornu_methode_context5215 = new MethodContext(FieldVector.class, 267, 10590, 11456);
        try {
            CallChecker.varInit(data, "data", 267, 10590, 11456);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 267, 10590, 11456);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 267, 10590, 11456);
            if (data == null) {
                throw new NullArgumentException();
            }
            if ((data.length) == 0) {
                throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT);
            }
            if (CallChecker.beforeDeref(data[0], null, 275, 11419, 11425)) {
                return new ArrayFieldVector<T>(data[0].getField(), data, true);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5215.methodEnd();
        }
    }

    public static RealMatrix createRowRealMatrix(double[] rowData) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5216 = new MethodContext(RealMatrix.class, 287, 11463, 12212);
        try {
            CallChecker.varInit(rowData, "rowData", 287, 11463, 12212);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 287, 11463, 12212);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 287, 11463, 12212);
            if (rowData == null) {
                throw new NullArgumentException();
            }
            final int nCols = CallChecker.varInit(((int) (rowData.length)), "nCols", 292, 12005, 12037);
            final RealMatrix m = CallChecker.varInit(MatrixUtils.createRealMatrix(1, nCols), "m", 293, 12047, 12094);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(m, RealMatrix.class, 295, 12150, 12150)) {
                    CallChecker.isCalled(m, RealMatrix.class, 295, 12150, 12150).setEntry(0, i, rowData[i]);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5216.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createRowFieldMatrix(final T[] rowData) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5217 = new MethodContext(FieldMatrix.class, 311, 12219, 13202);
        try {
            CallChecker.varInit(rowData, "rowData", 311, 12219, 13202);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 311, 12219, 13202);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 311, 12219, 13202);
            if (rowData == null) {
                throw new NullArgumentException();
            }
            final int nCols = CallChecker.varInit(((int) (rowData.length)), "nCols", 316, 12854, 12886);
            if (nCols == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            final FieldMatrix<T> m = CallChecker.varInit(MatrixUtils.createFieldMatrix(rowData[0].getField(), 1, nCols), "m", 320, 13009, 13084);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(m, FieldMatrix.class, 322, 13140, 13140)) {
                    CallChecker.isCalled(m, FieldMatrix.class, 322, 13140, 13140).setEntry(0, i, rowData[i]);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5217.methodEnd();
        }
    }

    public static RealMatrix createColumnRealMatrix(double[] columnData) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5218 = new MethodContext(RealMatrix.class, 336, 13209, 13986);
        try {
            CallChecker.varInit(columnData, "columnData", 336, 13209, 13986);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 336, 13209, 13986);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 336, 13209, 13986);
            if (columnData == null) {
                throw new NullArgumentException();
            }
            final int nRows = CallChecker.varInit(((int) (columnData.length)), "nRows", 341, 13773, 13808);
            final RealMatrix m = CallChecker.varInit(MatrixUtils.createRealMatrix(nRows, 1), "m", 342, 13818, 13865);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(m, RealMatrix.class, 344, 13921, 13921)) {
                    CallChecker.isCalled(m, RealMatrix.class, 344, 13921, 13921).setEntry(i, 0, columnData[i]);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5218.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createColumnFieldMatrix(final T[] columnData) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context5219 = new MethodContext(FieldMatrix.class, 360, 13993, 14998);
        try {
            CallChecker.varInit(columnData, "columnData", 360, 13993, 14998);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 360, 13993, 14998);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 360, 13993, 14998);
            if (columnData == null) {
                throw new NullArgumentException();
            }
            final int nRows = CallChecker.varInit(((int) (columnData.length)), "nRows", 365, 14644, 14679);
            if (nRows == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
            }
            final FieldMatrix<T> m = CallChecker.varInit(MatrixUtils.createFieldMatrix(columnData[0].getField(), nRows, 1), "m", 369, 14799, 14877);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(m, FieldMatrix.class, 371, 14933, 14933)) {
                    CallChecker.isCalled(m, FieldMatrix.class, 371, 14933, 14933).setEntry(i, 0, columnData[i]);
                }
            }
            return m;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5219.methodEnd();
        }
    }

    private static boolean isSymmetricInternal(RealMatrix matrix, double relativeTolerance, boolean raiseException) {
        MethodContext _bcornu_methode_context5220 = new MethodContext(boolean.class, 387, 15005, 16666);
        try {
            CallChecker.varInit(raiseException, "raiseException", 387, 15005, 16666);
            CallChecker.varInit(relativeTolerance, "relativeTolerance", 387, 15005, 16666);
            CallChecker.varInit(matrix, "matrix", 387, 15005, 16666);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 387, 15005, 16666);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 387, 15005, 16666);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 390, 15761, 15766);
            final int rows = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 390, 15761, 15766).getRowDimension())), "rows", 390, 15744, 15785);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 391, 15807, 15812)) {
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 391, 15807, 15812);
                if (rows != (CallChecker.isCalled(matrix, RealMatrix.class, 391, 15807, 15812).getColumnDimension())) {
                    if (raiseException) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 393, 15929, 15934)) {
                            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 393, 15929, 15934);
                            throw new NonSquareMatrixException(rows, CallChecker.isCalled(matrix, RealMatrix.class, 393, 15929, 15934).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        return false;
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < rows; i++) {
                for (int j = i + 1; j < rows; j++) {
                    matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 400, 16159, 16164);
                    final double mij = CallChecker.varInit(((double) (CallChecker.isCalled(matrix, RealMatrix.class, 400, 16159, 16164).getEntry(i, j))), "mij", 400, 16140, 16180);
                    matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 401, 16217, 16222);
                    final double mji = CallChecker.varInit(((double) (CallChecker.isCalled(matrix, RealMatrix.class, 401, 16217, 16222).getEntry(j, i))), "mji", 401, 16198, 16238);
                    if ((FastMath.abs((mij - mji))) > ((FastMath.max(FastMath.abs(mij), FastMath.abs(mji))) * relativeTolerance)) {
                        if (raiseException) {
                            throw new NonSymmetricMatrixException(i, j, relativeTolerance);
                        }else {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5220.methodEnd();
        }
    }

    public static void checkSymmetric(RealMatrix matrix, double eps) {
        MethodContext _bcornu_methode_context5221 = new MethodContext(void.class, 424, 16673, 17136);
        try {
            CallChecker.varInit(eps, "eps", 424, 16673, 17136);
            CallChecker.varInit(matrix, "matrix", 424, 16673, 17136);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 424, 16673, 17136);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 424, 16673, 17136);
            MatrixUtils.isSymmetricInternal(matrix, eps, true);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5221.methodEnd();
        }
    }

    public static boolean isSymmetric(RealMatrix matrix, double eps) {
        MethodContext _bcornu_methode_context5222 = new MethodContext(boolean.class, 437, 17143, 17530);
        try {
            CallChecker.varInit(eps, "eps", 437, 17143, 17530);
            CallChecker.varInit(matrix, "matrix", 437, 17143, 17530);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 437, 17143, 17530);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 437, 17143, 17530);
            return MatrixUtils.isSymmetricInternal(matrix, eps, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5222.methodEnd();
        }
    }

    public static void checkMatrixIndex(final AnyMatrix m, final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5223 = new MethodContext(void.class, 451, 17537, 18042);
        try {
            CallChecker.varInit(column, "column", 451, 17537, 18042);
            CallChecker.varInit(row, "row", 451, 17537, 18042);
            CallChecker.varInit(m, "m", 451, 17537, 18042);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 451, 17537, 18042);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 451, 17537, 18042);
            MatrixUtils.checkRowIndex(m, row);
            MatrixUtils.checkColumnIndex(m, column);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5223.methodEnd();
        }
    }

    public static void checkRowIndex(final AnyMatrix m, final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5224 = new MethodContext(void.class, 465, 18049, 18573);
        try {
            CallChecker.varInit(row, "row", 465, 18049, 18573);
            CallChecker.varInit(m, "m", 465, 18049, 18573);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 465, 18049, 18573);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 465, 18049, 18573);
            if (CallChecker.beforeDeref(m, AnyMatrix.class, 468, 18390, 18390)) {
                if ((row < 0) || (row >= (CallChecker.isCalled(m, AnyMatrix.class, 468, 18390, 18390).getRowDimension()))) {
                    if (CallChecker.beforeDeref(m, AnyMatrix.class, 470, 18533, 18533)) {
                        throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, row, 0, ((CallChecker.isCalled(m, AnyMatrix.class, 470, 18533, 18533).getRowDimension()) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5224.methodEnd();
        }
    }

    public static void checkColumnIndex(final AnyMatrix m, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5225 = new MethodContext(void.class, 481, 18580, 19129);
        try {
            CallChecker.varInit(column, "column", 481, 18580, 19129);
            CallChecker.varInit(m, "m", 481, 18580, 19129);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 481, 18580, 19129);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 481, 18580, 19129);
            if (CallChecker.beforeDeref(m, AnyMatrix.class, 483, 18933, 18933)) {
                if ((column < 0) || (column >= (CallChecker.isCalled(m, AnyMatrix.class, 483, 18933, 18933).getColumnDimension()))) {
                    if (CallChecker.beforeDeref(m, AnyMatrix.class, 485, 19086, 19086)) {
                        throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, column, 0, ((CallChecker.isCalled(m, AnyMatrix.class, 485, 19086, 19086).getColumnDimension()) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5225.methodEnd();
        }
    }

    public static void checkSubMatrixIndex(final AnyMatrix m, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context5226 = new MethodContext(void.class, 502, 19136, 20544);
        try {
            CallChecker.varInit(endColumn, "endColumn", 502, 19136, 20544);
            CallChecker.varInit(startColumn, "startColumn", 502, 19136, 20544);
            CallChecker.varInit(endRow, "endRow", 502, 19136, 20544);
            CallChecker.varInit(startRow, "startRow", 502, 19136, 20544);
            CallChecker.varInit(m, "m", 502, 19136, 20544);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 502, 19136, 20544);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 502, 19136, 20544);
            MatrixUtils.checkRowIndex(m, startRow);
            MatrixUtils.checkRowIndex(m, endRow);
            if (endRow < startRow) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, endRow, startRow, false);
            }
            MatrixUtils.checkColumnIndex(m, startColumn);
            MatrixUtils.checkColumnIndex(m, endColumn);
            if (endColumn < startColumn) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, endColumn, startColumn, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5226.methodEnd();
        }
    }

    public static void checkSubMatrixIndex(final AnyMatrix m, final int[] selectedRows, final int[] selectedColumns) throws NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context5227 = new MethodContext(void.class, 536, 20551, 22046);
        try {
            CallChecker.varInit(selectedColumns, "selectedColumns", 536, 20551, 22046);
            CallChecker.varInit(selectedRows, "selectedRows", 536, 20551, 22046);
            CallChecker.varInit(m, "m", 536, 20551, 22046);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 536, 20551, 22046);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 536, 20551, 22046);
            if (selectedRows == null) {
                throw new NullArgumentException();
            }
            if (selectedColumns == null) {
                throw new NullArgumentException();
            }
            if ((selectedRows.length) == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY);
            }
            if ((selectedColumns.length) == 0) {
                throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY);
            }
            for (final int row : selectedRows) {
                MatrixUtils.checkRowIndex(m, row);
            }
            for (final int column : selectedColumns) {
                MatrixUtils.checkColumnIndex(m, column);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5227.methodEnd();
        }
    }

    public static void checkAdditionCompatible(final AnyMatrix left, final AnyMatrix right) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context5228 = new MethodContext(void.class, 569, 22053, 22822);
        try {
            CallChecker.varInit(right, "right", 569, 22053, 22822);
            CallChecker.varInit(left, "left", 569, 22053, 22822);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 569, 22053, 22822);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 569, 22053, 22822);
            if (CallChecker.beforeDeref(left, AnyMatrix.class, 571, 22463, 22466)) {
                if (CallChecker.beforeDeref(right, AnyMatrix.class, 571, 22492, 22496)) {
                    if (CallChecker.beforeDeref(left, AnyMatrix.class, 572, 22533, 22536)) {
                        if (CallChecker.beforeDeref(right, AnyMatrix.class, 572, 22562, 22566)) {
                            if (((CallChecker.isCalled(left, AnyMatrix.class, 571, 22463, 22466).getRowDimension()) != (CallChecker.isCalled(right, AnyMatrix.class, 571, 22492, 22496).getRowDimension())) || ((CallChecker.isCalled(left, AnyMatrix.class, 572, 22533, 22536).getColumnDimension()) != (CallChecker.isCalled(right, AnyMatrix.class, 572, 22562, 22566).getColumnDimension()))) {
                                if (CallChecker.beforeDeref(left, AnyMatrix.class, 573, 22648, 22651)) {
                                    if (CallChecker.beforeDeref(left, AnyMatrix.class, 573, 22672, 22675)) {
                                        if (CallChecker.beforeDeref(right, AnyMatrix.class, 574, 22754, 22758)) {
                                            if (CallChecker.beforeDeref(right, AnyMatrix.class, 574, 22779, 22783)) {
                                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(left, AnyMatrix.class, 573, 22648, 22651).getRowDimension(), CallChecker.isCalled(left, AnyMatrix.class, 573, 22672, 22675).getColumnDimension(), CallChecker.isCalled(right, AnyMatrix.class, 574, 22754, 22758).getRowDimension(), CallChecker.isCalled(right, AnyMatrix.class, 574, 22779, 22783).getColumnDimension());
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5228.methodEnd();
        }
    }

    public static void checkSubtractionCompatible(final AnyMatrix left, final AnyMatrix right) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context5229 = new MethodContext(void.class, 586, 22829, 23603);
        try {
            CallChecker.varInit(right, "right", 586, 22829, 23603);
            CallChecker.varInit(left, "left", 586, 22829, 23603);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 586, 22829, 23603);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 586, 22829, 23603);
            if (CallChecker.beforeDeref(left, AnyMatrix.class, 588, 23244, 23247)) {
                if (CallChecker.beforeDeref(right, AnyMatrix.class, 588, 23273, 23277)) {
                    if (CallChecker.beforeDeref(left, AnyMatrix.class, 589, 23314, 23317)) {
                        if (CallChecker.beforeDeref(right, AnyMatrix.class, 589, 23343, 23347)) {
                            if (((CallChecker.isCalled(left, AnyMatrix.class, 588, 23244, 23247).getRowDimension()) != (CallChecker.isCalled(right, AnyMatrix.class, 588, 23273, 23277).getRowDimension())) || ((CallChecker.isCalled(left, AnyMatrix.class, 589, 23314, 23317).getColumnDimension()) != (CallChecker.isCalled(right, AnyMatrix.class, 589, 23343, 23347).getColumnDimension()))) {
                                if (CallChecker.beforeDeref(left, AnyMatrix.class, 590, 23429, 23432)) {
                                    if (CallChecker.beforeDeref(left, AnyMatrix.class, 590, 23453, 23456)) {
                                        if (CallChecker.beforeDeref(right, AnyMatrix.class, 591, 23535, 23539)) {
                                            if (CallChecker.beforeDeref(right, AnyMatrix.class, 591, 23560, 23564)) {
                                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(left, AnyMatrix.class, 590, 23429, 23432).getRowDimension(), CallChecker.isCalled(left, AnyMatrix.class, 590, 23453, 23456).getColumnDimension(), CallChecker.isCalled(right, AnyMatrix.class, 591, 23535, 23539).getRowDimension(), CallChecker.isCalled(right, AnyMatrix.class, 591, 23560, 23564).getColumnDimension());
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
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5229.methodEnd();
        }
    }

    public static void checkMultiplicationCompatible(final AnyMatrix left, final AnyMatrix right) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5230 = new MethodContext(void.class, 603, 23610, 24242);
        try {
            CallChecker.varInit(right, "right", 603, 23610, 24242);
            CallChecker.varInit(left, "left", 603, 23610, 24242);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 603, 23610, 24242);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 603, 23610, 24242);
            if (CallChecker.beforeDeref(left, AnyMatrix.class, 606, 24021, 24024)) {
                if (CallChecker.beforeDeref(right, AnyMatrix.class, 606, 24050, 24054)) {
                    if ((CallChecker.isCalled(left, AnyMatrix.class, 606, 24021, 24024).getColumnDimension()) != (CallChecker.isCalled(right, AnyMatrix.class, 606, 24050, 24054).getRowDimension())) {
                        if (CallChecker.beforeDeref(left, AnyMatrix.class, 607, 24126, 24129)) {
                            if (CallChecker.beforeDeref(right, AnyMatrix.class, 608, 24202, 24206)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(left, AnyMatrix.class, 607, 24126, 24129).getColumnDimension(), CallChecker.isCalled(right, AnyMatrix.class, 608, 24202, 24206).getRowDimension());
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
            _bcornu_methode_context5230.methodEnd();
        }
    }

    public static Array2DRowRealMatrix fractionMatrixToRealMatrix(final FieldMatrix<Fraction> m) {
        MethodContext _bcornu_methode_context5231 = new MethodContext(Array2DRowRealMatrix.class, 617, 24249, 24693);
        try {
            CallChecker.varInit(m, "m", 617, 24249, 24693);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 617, 24249, 24693);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 617, 24249, 24693);
            final MatrixUtils.FractionMatrixConverter converter = CallChecker.varInit(new MatrixUtils.FractionMatrixConverter(), "converter", 618, 24526, 24597);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 619, 24607, 24607)) {
                CallChecker.isCalled(m, FieldMatrix.class, 619, 24607, 24607).walkInOptimizedOrder(converter);
            }
            if (CallChecker.beforeDeref(converter, MatrixUtils.FractionMatrixConverter.class, 620, 24657, 24665)) {
                return CallChecker.isCalled(converter, MatrixUtils.FractionMatrixConverter.class, 620, 24657, 24665).getConvertedMatrix();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5231.methodEnd();
        }
    }

    public static Array2DRowRealMatrix bigFractionMatrixToRealMatrix(final FieldMatrix<BigFraction> m) {
        MethodContext _bcornu_methode_context5232 = new MethodContext(Array2DRowRealMatrix.class, 662, 25712, 26178);
        try {
            CallChecker.varInit(m, "m", 662, 25712, 26178);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 662, 25712, 26178);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 662, 25712, 26178);
            final MatrixUtils.BigFractionMatrixConverter converter = CallChecker.varInit(new MatrixUtils.BigFractionMatrixConverter(), "converter", 663, 26005, 26082);
            if (CallChecker.beforeDeref(m, FieldMatrix.class, 664, 26092, 26092)) {
                CallChecker.isCalled(m, FieldMatrix.class, 664, 26092, 26092).walkInOptimizedOrder(converter);
            }
            if (CallChecker.beforeDeref(converter, MatrixUtils.BigFractionMatrixConverter.class, 665, 26142, 26150)) {
                return CallChecker.isCalled(converter, MatrixUtils.BigFractionMatrixConverter.class, 665, 26142, 26150).getConvertedMatrix();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5232.methodEnd();
        }
    }

    public static void serializeRealVector(final RealVector vector, final ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context5233 = new MethodContext(void.class, 740, 27214, 29260);
        try {
            CallChecker.varInit(oos, "oos", 740, 27214, 29260);
            CallChecker.varInit(vector, "vector", 740, 27214, 29260);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 740, 27214, 29260);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 740, 27214, 29260);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(vector, RealVector.class, 743, 29111, 29116).getDimension())), "n", 743, 29097, 29132);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 744, 29142, 29144)) {
                CallChecker.isCalled(oos, ObjectOutputStream.class, 744, 29142, 29144).writeInt(n);
            }
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(vector, RealVector.class, 746, 29225, 29230)) {
                    if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 746, 29209, 29211)) {
                        CallChecker.isCalled(oos, ObjectOutputStream.class, 746, 29209, 29211).writeDouble(CallChecker.isCalled(vector, RealVector.class, 746, 29225, 29230).getEntry(i));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5233.methodEnd();
        }
    }

    public static void deserializeRealVector(final Object instance, final String fieldName, final ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context5234 = new MethodContext(void.class, 767, 29267, 31406);
        try {
            CallChecker.varInit(ois, "ois", 767, 29267, 31406);
            CallChecker.varInit(fieldName, "fieldName", 767, 29267, 31406);
            CallChecker.varInit(instance, "instance", 767, 29267, 31406);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 767, 29267, 31406);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 767, 29267, 31406);
            TryContext _bcornu_try_context_102 = new TryContext(102, MatrixUtils.class, "java.lang.NoSuchFieldException", "java.lang.IllegalAccessException");
            try {
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(ois, ObjectInputStream.class, 774, 30600, 30602).readInt())), "n", 774, 30550, 30613);
                final double[] data = CallChecker.varInit(new double[n], "data", 775, 30627, 30662);
                for (int i = 0; i < n; ++i) {
                    if (CallChecker.beforeDeref(data, double[].class, 777, 30722, 30725)) {
                        if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 777, 30732, 30734)) {
                            CallChecker.isCalled(data, double[].class, 777, 30722, 30725)[i] = CallChecker.isCalled(ois, ObjectInputStream.class, 777, 30732, 30734).readDouble();
                            CallChecker.varAssign(CallChecker.isCalled(data, double[].class, 777, 30722, 30725)[i], "CallChecker.isCalled(data, double[].class, 777, 30722, 30725)[i]", 777, 30722, 30748);
                        }
                    }
                }
                final RealVector vector = CallChecker.varInit(new ArrayRealVector(data, false), "vector", 781, 30777, 30870);
                final java.lang.reflect.Field f = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(instance, Object.class, 785, 30967, 30974).getClass(), Class.class, 785, 30967, 30985).getDeclaredField(fieldName), "f", 784, 30885, 31014);
                if (CallChecker.beforeDeref(f, java.lang.reflect.Field.class, 786, 31028, 31028)) {
                    CallChecker.isCalled(f, java.lang.reflect.Field.class, 786, 31028, 31028).setAccessible(true);
                }
                if (CallChecker.beforeDeref(f, java.lang.reflect.Field.class, 787, 31063, 31063)) {
                    CallChecker.isCalled(f, java.lang.reflect.Field.class, 787, 31063, 31063).set(instance, vector);
                }
            } catch (NoSuchFieldException nsfe) {
                _bcornu_try_context_102.catchStart(102);
                IOException ioe = CallChecker.varInit(new IOException(), "ioe", 790, 31147, 31182);
                if (CallChecker.beforeDeref(ioe, IOException.class, 791, 31196, 31198)) {
                    ioe = CallChecker.beforeCalled(ioe, IOException.class, 791, 31196, 31198);
                    CallChecker.isCalled(ioe, IOException.class, 791, 31196, 31198).initCause(nsfe);
                }
                throw ioe;
            } catch (IllegalAccessException iae) {
                _bcornu_try_context_102.catchStart(102);
                IOException ioe = CallChecker.varInit(new IOException(), "ioe", 794, 31299, 31334);
                if (CallChecker.beforeDeref(ioe, IOException.class, 795, 31348, 31350)) {
                    ioe = CallChecker.beforeCalled(ioe, IOException.class, 795, 31348, 31350);
                    CallChecker.isCalled(ioe, IOException.class, 795, 31348, 31350).initCause(iae);
                }
                throw ioe;
            } finally {
                _bcornu_try_context_102.finallyStart(102);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5234.methodEnd();
        }
    }

    public static void serializeRealMatrix(final RealMatrix matrix, final ObjectOutputStream oos) throws IOException {
        MethodContext _bcornu_methode_context5235 = new MethodContext(void.class, 841, 31413, 33601);
        try {
            CallChecker.varInit(oos, "oos", 841, 31413, 33601);
            CallChecker.varInit(matrix, "matrix", 841, 31413, 33601);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 841, 31413, 33601);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 841, 31413, 33601);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 844, 33310, 33315).getRowDimension())), "n", 844, 33296, 33334);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 845, 33358, 33363).getColumnDimension())), "m", 845, 33344, 33385);
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 846, 33395, 33397)) {
                CallChecker.isCalled(oos, ObjectOutputStream.class, 846, 33395, 33397).writeInt(n);
            }
            if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 847, 33420, 33422)) {
                CallChecker.isCalled(oos, ObjectOutputStream.class, 847, 33420, 33422).writeInt(m);
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 850, 33549, 33554)) {
                        if (CallChecker.beforeDeref(oos, ObjectOutputStream.class, 850, 33533, 33535)) {
                            CallChecker.isCalled(oos, ObjectOutputStream.class, 850, 33533, 33535).writeDouble(CallChecker.isCalled(matrix, RealMatrix.class, 850, 33549, 33554).getEntry(i, j));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5235.methodEnd();
        }
    }

    public static void deserializeRealMatrix(final Object instance, final String fieldName, final ObjectInputStream ois) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context5236 = new MethodContext(void.class, 872, 33608, 35914);
        try {
            CallChecker.varInit(ois, "ois", 872, 33608, 35914);
            CallChecker.varInit(fieldName, "fieldName", 872, 33608, 35914);
            CallChecker.varInit(instance, "instance", 872, 33608, 35914);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 872, 33608, 35914);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 872, 33608, 35914);
            TryContext _bcornu_try_context_103 = new TryContext(103, MatrixUtils.class, "java.lang.NoSuchFieldException", "java.lang.IllegalAccessException");
            try {
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(ois, ObjectInputStream.class, 879, 34941, 34943).readInt())), "n", 879, 34891, 34954);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(ois, ObjectInputStream.class, 880, 34982, 34984).readInt())), "m", 880, 34968, 34995);
                final double[][] data = CallChecker.varInit(new double[n][m], "data", 881, 35009, 35049);
                for (int i = 0; i < n; ++i) {
                    final double[] dataI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 883, 35132, 35135)[i], "dataI", 883, 35109, 35139);
                    for (int j = 0; j < m; ++j) {
                        if (CallChecker.beforeDeref(dataI, double[].class, 885, 35207, 35211)) {
                            if (CallChecker.beforeDeref(ois, ObjectInputStream.class, 885, 35218, 35220)) {
                                CallChecker.isCalled(dataI, double[].class, 885, 35207, 35211)[j] = CallChecker.isCalled(ois, ObjectInputStream.class, 885, 35218, 35220).readDouble();
                                CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 885, 35207, 35211)[j], "CallChecker.isCalled(dataI, double[].class, 885, 35207, 35211)[j]", 885, 35207, 35234);
                            }
                        }
                    }
                }
                final RealMatrix matrix = CallChecker.varInit(new Array2DRowRealMatrix(data, false), "matrix", 890, 35281, 35379);
                final java.lang.reflect.Field f = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(instance, Object.class, 894, 35476, 35483).getClass(), Class.class, 894, 35476, 35494).getDeclaredField(fieldName), "f", 893, 35394, 35523);
                if (CallChecker.beforeDeref(f, java.lang.reflect.Field.class, 895, 35537, 35537)) {
                    CallChecker.isCalled(f, java.lang.reflect.Field.class, 895, 35537, 35537).setAccessible(true);
                }
                if (CallChecker.beforeDeref(f, java.lang.reflect.Field.class, 896, 35572, 35572)) {
                    CallChecker.isCalled(f, java.lang.reflect.Field.class, 896, 35572, 35572).set(instance, matrix);
                }
            } catch (NoSuchFieldException nsfe) {
                _bcornu_try_context_103.catchStart(103);
                IOException ioe = CallChecker.varInit(new IOException(), "ioe", 899, 35656, 35691);
                if (CallChecker.beforeDeref(ioe, IOException.class, 900, 35705, 35707)) {
                    ioe = CallChecker.beforeCalled(ioe, IOException.class, 900, 35705, 35707);
                    CallChecker.isCalled(ioe, IOException.class, 900, 35705, 35707).initCause(nsfe);
                }
                throw ioe;
            } catch (IllegalAccessException iae) {
                _bcornu_try_context_103.catchStart(103);
                IOException ioe = CallChecker.varInit(new IOException(), "ioe", 903, 35808, 35843);
                if (CallChecker.beforeDeref(ioe, IOException.class, 904, 35857, 35859)) {
                    ioe = CallChecker.beforeCalled(ioe, IOException.class, 904, 35857, 35859);
                    CallChecker.isCalled(ioe, IOException.class, 904, 35857, 35859).initCause(iae);
                }
                throw ioe;
            } finally {
                _bcornu_try_context_103.finallyStart(103);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5236.methodEnd();
        }
    }

    public static void solveLowerTriangularSystem(RealMatrix rm, RealVector b) throws DimensionMismatchException, MathArithmeticException, NonSquareMatrixException {
        MethodContext _bcornu_methode_context5237 = new MethodContext(void.class, 927, 35921, 38028);
        try {
            CallChecker.varInit(b, "b", 927, 35921, 38028);
            CallChecker.varInit(rm, "rm", 927, 35921, 38028);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 927, 35921, 38028);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 927, 35921, 38028);
            if (((rm == null) || (b == null)) || ((rm.getRowDimension()) != (b.getDimension()))) {
                if ((rm == null) || (CallChecker.beforeDeref(rm, RealMatrix.class, 932, 37217, 37218))) {
                    if ((b == null) || (CallChecker.beforeDeref(b, RealVector.class, 933, 37277, 37277))) {
                        rm = CallChecker.beforeCalled(rm, RealMatrix.class, 932, 37217, 37218);
                        b = CallChecker.beforeCalled(b, RealVector.class, 933, 37277, 37277);
                        throw new DimensionMismatchException(((rm == null) ? 0 : CallChecker.isCalled(rm, RealMatrix.class, 932, 37217, 37218).getRowDimension()), ((b == null) ? 0 : CallChecker.isCalled(b, RealVector.class, 933, 37277, 37277).getDimension()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((rm.getColumnDimension()) != (rm.getRowDimension())) {
                throw new NonSquareMatrixException(rm.getRowDimension(), rm.getColumnDimension());
            }
            int rows = CallChecker.varInit(((int) (rm.getRowDimension())), "rows", 939, 37529, 37560);
            for (int i = 0; i < rows; i++) {
                double diag = CallChecker.varInit(((double) (rm.getEntry(i, i))), "diag", 941, 37617, 37648);
                if ((FastMath.abs(diag)) < (Precision.SAFE_MIN)) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
                }
                double bi = CallChecker.varInit(((double) ((b.getEntry(i)) / diag)), "bi", 945, 37821, 37851);
                b.setEntry(i, bi);
                for (int j = i + 1; j < rows; j++) {
                    b.setEntry(j, ((b.getEntry(j)) - (bi * (rm.getEntry(j, i)))));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5237.methodEnd();
        }
    }

    public static void solveUpperTriangularSystem(RealMatrix rm, RealVector b) throws DimensionMismatchException, MathArithmeticException, NonSquareMatrixException {
        MethodContext _bcornu_methode_context5238 = new MethodContext(void.class, 972, 38035, 40148);
        try {
            CallChecker.varInit(b, "b", 972, 38035, 40148);
            CallChecker.varInit(rm, "rm", 972, 38035, 40148);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 972, 38035, 40148);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 972, 38035, 40148);
            if (((rm == null) || (b == null)) || ((rm.getRowDimension()) != (b.getDimension()))) {
                if ((rm == null) || (CallChecker.beforeDeref(rm, RealMatrix.class, 977, 39338, 39339))) {
                    if ((b == null) || (CallChecker.beforeDeref(b, RealVector.class, 978, 39398, 39398))) {
                        rm = CallChecker.beforeCalled(rm, RealMatrix.class, 977, 39338, 39339);
                        b = CallChecker.beforeCalled(b, RealVector.class, 978, 39398, 39398);
                        throw new DimensionMismatchException(((rm == null) ? 0 : CallChecker.isCalled(rm, RealMatrix.class, 977, 39338, 39339).getRowDimension()), ((b == null) ? 0 : CallChecker.isCalled(b, RealVector.class, 978, 39398, 39398).getDimension()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((rm.getColumnDimension()) != (rm.getRowDimension())) {
                throw new NonSquareMatrixException(rm.getRowDimension(), rm.getColumnDimension());
            }
            int rows = CallChecker.varInit(((int) (rm.getRowDimension())), "rows", 984, 39650, 39681);
            for (int i = rows - 1; i > (-1); i--) {
                double diag = CallChecker.varInit(((double) (rm.getEntry(i, i))), "diag", 986, 39740, 39771);
                if ((FastMath.abs(diag)) < (Precision.SAFE_MIN)) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
                }
                double bi = CallChecker.varInit(((double) ((b.getEntry(i)) / diag)), "bi", 990, 39944, 39974);
                b.setEntry(i, bi);
                for (int j = i - 1; j > (-1); j--) {
                    b.setEntry(j, ((b.getEntry(j)) - (bi * (rm.getEntry(j, i)))));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5238.methodEnd();
        }
    }

    public static RealMatrix blockInverse(RealMatrix m, int splitIndex) {
        MethodContext _bcornu_methode_context5239 = new MethodContext(RealMatrix.class, 1010, 40155, 43257);
        try {
            CallChecker.varInit(splitIndex, "splitIndex", 1010, 40155, 43257);
            CallChecker.varInit(m, "m", 1010, 40155, 43257);
            CallChecker.varInit(OCTAVE_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.OCTAVE_FORMAT", 1010, 40155, 43257);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.MatrixUtils.DEFAULT_FORMAT", 1010, 40155, 43257);
            m = CallChecker.beforeCalled(m, RealMatrix.class, 1012, 40745, 40745);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 1012, 40745, 40745).getRowDimension())), "n", 1012, 40731, 40764);
            if (CallChecker.beforeDeref(m, RealMatrix.class, 1013, 40778, 40778)) {
                m = CallChecker.beforeCalled(m, RealMatrix.class, 1013, 40778, 40778);
                if ((CallChecker.isCalled(m, RealMatrix.class, 1013, 40778, 40778).getColumnDimension()) != n) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 1014, 40856, 40856)) {
                        if (CallChecker.beforeDeref(m, RealMatrix.class, 1015, 40924, 40924)) {
                            m = CallChecker.beforeCalled(m, RealMatrix.class, 1014, 40856, 40856);
                            m = CallChecker.beforeCalled(m, RealMatrix.class, 1015, 40924, 40924);
                            throw new NonSquareMatrixException(CallChecker.isCalled(m, RealMatrix.class, 1014, 40856, 40856).getRowDimension(), CallChecker.isCalled(m, RealMatrix.class, 1015, 40924, 40924).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final int splitIndex1 = CallChecker.varInit(((int) (splitIndex + 1)), "splitIndex1", 1018, 40968, 41006);
            m = CallChecker.beforeCalled(m, RealMatrix.class, 1020, 41038, 41038);
            final RealMatrix a = CallChecker.varInit(CallChecker.isCalled(m, RealMatrix.class, 1020, 41038, 41038).getSubMatrix(0, splitIndex, 0, splitIndex), "a", 1020, 41017, 41082);
            m = CallChecker.beforeCalled(m, RealMatrix.class, 1021, 41113, 41113);
            final RealMatrix b = CallChecker.varInit(CallChecker.isCalled(m, RealMatrix.class, 1021, 41113, 41113).getSubMatrix(0, splitIndex, splitIndex1, (n - 1)), "b", 1021, 41092, 41162);
            m = CallChecker.beforeCalled(m, RealMatrix.class, 1022, 41193, 41193);
            final RealMatrix c = CallChecker.varInit(CallChecker.isCalled(m, RealMatrix.class, 1022, 41193, 41193).getSubMatrix(splitIndex1, (n - 1), 0, splitIndex), "c", 1022, 41172, 41242);
            m = CallChecker.beforeCalled(m, RealMatrix.class, 1023, 41273, 41273);
            final RealMatrix d = CallChecker.varInit(CallChecker.isCalled(m, RealMatrix.class, 1023, 41273, 41273).getSubMatrix(splitIndex1, (n - 1), splitIndex1, (n - 1)), "d", 1023, 41252, 41327);
            final SingularValueDecomposition aDec = CallChecker.varInit(new SingularValueDecomposition(a), "aDec", 1025, 41338, 41411);
            final DecompositionSolver aSolver = CallChecker.varInit(CallChecker.isCalled(aDec, SingularValueDecomposition.class, 1026, 41457, 41460).getSolver(), "aSolver", 1026, 41421, 41473);
            if (CallChecker.beforeDeref(aSolver, DecompositionSolver.class, 1027, 41488, 41494)) {
                if (!(CallChecker.isCalled(aSolver, DecompositionSolver.class, 1027, 41488, 41494).isNonSingular())) {
                    throw new SingularMatrixException();
                }
            }else
                throw new AbnormalExecutionError();
            
            final RealMatrix aInv = CallChecker.varInit(CallChecker.isCalled(aSolver, DecompositionSolver.class, 1030, 41606, 41612).getInverse(), "aInv", 1030, 41582, 41626);
            final SingularValueDecomposition dDec = CallChecker.varInit(new SingularValueDecomposition(d), "dDec", 1032, 41637, 41710);
            final DecompositionSolver dSolver = CallChecker.varInit(CallChecker.isCalled(dDec, SingularValueDecomposition.class, 1033, 41756, 41759).getSolver(), "dSolver", 1033, 41720, 41772);
            if (CallChecker.beforeDeref(dSolver, DecompositionSolver.class, 1034, 41787, 41793)) {
                if (!(CallChecker.isCalled(dSolver, DecompositionSolver.class, 1034, 41787, 41793).isNonSingular())) {
                    throw new SingularMatrixException();
                }
            }else
                throw new AbnormalExecutionError();
            
            final RealMatrix dInv = CallChecker.varInit(CallChecker.isCalled(dSolver, DecompositionSolver.class, 1037, 41905, 41911).getInverse(), "dInv", 1037, 41881, 41925);
            final RealMatrix tmp1 = CallChecker.varInit(CallChecker.isCalled(a, RealMatrix.class, 1039, 41960, 41960).subtract(CallChecker.isCalled(CallChecker.isCalled(b, RealMatrix.class, 1039, 41971, 41971).multiply(dInv), RealMatrix.class, 1039, 41971, 41986).multiply(c)), "tmp1", 1039, 41936, 42000);
            final SingularValueDecomposition tmp1Dec = CallChecker.varInit(new SingularValueDecomposition(tmp1), "tmp1Dec", 1040, 42010, 42089);
            final DecompositionSolver tmp1Solver = CallChecker.varInit(CallChecker.isCalled(tmp1Dec, SingularValueDecomposition.class, 1041, 42138, 42144).getSolver(), "tmp1Solver", 1041, 42099, 42157);
            if (CallChecker.beforeDeref(tmp1Solver, DecompositionSolver.class, 1042, 42172, 42181)) {
                if (!(CallChecker.isCalled(tmp1Solver, DecompositionSolver.class, 1042, 42172, 42181).isNonSingular())) {
                    throw new SingularMatrixException();
                }
            }else
                throw new AbnormalExecutionError();
            
            final RealMatrix result00 = CallChecker.varInit(CallChecker.isCalled(tmp1Solver, DecompositionSolver.class, 1045, 42297, 42306).getInverse(), "result00", 1045, 42269, 42320);
            final RealMatrix tmp2 = CallChecker.varInit(CallChecker.isCalled(d, RealMatrix.class, 1047, 42355, 42355).subtract(CallChecker.isCalled(CallChecker.isCalled(c, RealMatrix.class, 1047, 42366, 42366).multiply(aInv), RealMatrix.class, 1047, 42366, 42381).multiply(b)), "tmp2", 1047, 42331, 42395);
            final SingularValueDecomposition tmp2Dec = CallChecker.varInit(new SingularValueDecomposition(tmp2), "tmp2Dec", 1048, 42405, 42484);
            final DecompositionSolver tmp2Solver = CallChecker.varInit(CallChecker.isCalled(tmp2Dec, SingularValueDecomposition.class, 1049, 42533, 42539).getSolver(), "tmp2Solver", 1049, 42494, 42552);
            if (CallChecker.beforeDeref(tmp2Solver, DecompositionSolver.class, 1050, 42567, 42576)) {
                if (!(CallChecker.isCalled(tmp2Solver, DecompositionSolver.class, 1050, 42567, 42576).isNonSingular())) {
                    throw new SingularMatrixException();
                }
            }else
                throw new AbnormalExecutionError();
            
            final RealMatrix result11 = CallChecker.varInit(CallChecker.isCalled(tmp2Solver, DecompositionSolver.class, 1053, 42692, 42701).getInverse(), "result11", 1053, 42664, 42715);
            final RealMatrix result01 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(aInv, RealMatrix.class, 1055, 42754, 42757).multiply(b), RealMatrix.class, 1055, 42754, 42769).multiply(result11), RealMatrix.class, 1055, 42754, 42788).scalarMultiply((-1)), "result01", 1055, 42726, 42808);
            final RealMatrix result10 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(dInv, RealMatrix.class, 1056, 42846, 42849).multiply(c), RealMatrix.class, 1056, 42846, 42861).multiply(result00), RealMatrix.class, 1056, 42846, 42880).scalarMultiply((-1)), "result10", 1056, 42818, 42900);
            final RealMatrix result = CallChecker.varInit(new Array2DRowRealMatrix(n, n), "result", 1058, 42911, 42967);
            if (CallChecker.beforeDeref(result00, RealMatrix.class, 1059, 42997, 43004)) {
                if (CallChecker.beforeDeref(result, RealMatrix.class, 1059, 42977, 42982)) {
                    CallChecker.isCalled(result, RealMatrix.class, 1059, 42977, 42982).setSubMatrix(CallChecker.isCalled(result00, RealMatrix.class, 1059, 42997, 43004).getData(), 0, 0);
                }
            }
            if (CallChecker.beforeDeref(result01, RealMatrix.class, 1060, 43052, 43059)) {
                if (CallChecker.beforeDeref(result, RealMatrix.class, 1060, 43032, 43037)) {
                    CallChecker.isCalled(result, RealMatrix.class, 1060, 43032, 43037).setSubMatrix(CallChecker.isCalled(result01, RealMatrix.class, 1060, 43052, 43059).getData(), 0, splitIndex1);
                }
            }
            if (CallChecker.beforeDeref(result10, RealMatrix.class, 1061, 43117, 43124)) {
                if (CallChecker.beforeDeref(result, RealMatrix.class, 1061, 43097, 43102)) {
                    CallChecker.isCalled(result, RealMatrix.class, 1061, 43097, 43102).setSubMatrix(CallChecker.isCalled(result10, RealMatrix.class, 1061, 43117, 43124).getData(), splitIndex1, 0);
                }
            }
            if (CallChecker.beforeDeref(result11, RealMatrix.class, 1062, 43182, 43189)) {
                if (CallChecker.beforeDeref(result, RealMatrix.class, 1062, 43162, 43167)) {
                    CallChecker.isCalled(result, RealMatrix.class, 1062, 43162, 43167).setSubMatrix(CallChecker.isCalled(result11, RealMatrix.class, 1062, 43182, 43189).getData(), splitIndex1, splitIndex1);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5239.methodEnd();
        }
    }
}

