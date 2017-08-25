package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public abstract class AbstractRealMatrix extends RealLinearOperator implements RealMatrix {
    private static final RealMatrixFormat DEFAULT_FORMAT = RealMatrixFormat.getInstance(Locale.US);

    static {
        if (CallChecker.beforeDeref(AbstractRealMatrix.DEFAULT_FORMAT, RealMatrixFormat.class, 50, 2123, 2136)) {
            final NumberFormat npe_invocation_var134 = CallChecker.isCalled(AbstractRealMatrix.DEFAULT_FORMAT, RealMatrixFormat.class, 50, 2123, 2136).getFormat();
            if (CallChecker.beforeDeref(npe_invocation_var134, NumberFormat.class, 50, 2123, 2148)) {
                CallChecker.isCalled(npe_invocation_var134, NumberFormat.class, 50, 2123, 2148).setMinimumFractionDigits(1);
            }
        }
    }

    protected AbstractRealMatrix() {
        ConstructorContext _bcornu_methode_context312 = new ConstructorContext(AbstractRealMatrix.class, 56, 2190, 2275);
        try {
        } finally {
            _bcornu_methode_context312.methodEnd();
        }
    }

    protected AbstractRealMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context313 = new ConstructorContext(AbstractRealMatrix.class, 65, 2282, 2964);
        try {
            if (rowDimension < 1) {
                throw new NotStrictlyPositiveException(rowDimension);
            }
            if (columnDimension < 1) {
                throw new NotStrictlyPositiveException(columnDimension);
            }
        } finally {
            _bcornu_methode_context313.methodEnd();
        }
    }

    public RealMatrix add(RealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1389 = new MethodContext(RealMatrix.class, 77, 2971, 3551);
        try {
            CallChecker.varInit(this, "this", 77, 2971, 3551);
            CallChecker.varInit(m, "m", 77, 2971, 3551);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 77, 2971, 3551);
            MatrixUtils.checkAdditionCompatible(this, m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 81, 3145, 3186);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 82, 3196, 3240);
            final RealMatrix out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 83, 3250, 3308);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 86, 3479, 3479)) {
                        if (CallChecker.beforeDeref(out, RealMatrix.class, 86, 3435, 3437)) {
                            m = CallChecker.beforeCalled(m, RealMatrix.class, 86, 3479, 3479);
                            CallChecker.isCalled(out, RealMatrix.class, 86, 3435, 3437).setEntry(row, col, ((getEntry(row, col)) + (CallChecker.isCalled(m, RealMatrix.class, 86, 3479, 3479).getEntry(row, col))));
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1389.methodEnd();
        }
    }

    public RealMatrix subtract(final RealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1390 = new MethodContext(RealMatrix.class, 94, 3558, 4152);
        try {
            CallChecker.varInit(this, "this", 94, 3558, 4152);
            CallChecker.varInit(m, "m", 94, 3558, 4152);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 94, 3558, 4152);
            MatrixUtils.checkSubtractionCompatible(this, m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 98, 3746, 3787);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 99, 3797, 3841);
            final RealMatrix out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 100, 3851, 3909);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 103, 4080, 4080)) {
                        if (CallChecker.beforeDeref(out, RealMatrix.class, 103, 4036, 4038)) {
                            CallChecker.isCalled(out, RealMatrix.class, 103, 4036, 4038).setEntry(row, col, ((getEntry(row, col)) - (CallChecker.isCalled(m, RealMatrix.class, 103, 4080, 4080).getEntry(row, col))));
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1390.methodEnd();
        }
    }

    public RealMatrix scalarAdd(final double d) {
        MethodContext _bcornu_methode_context1391 = new MethodContext(RealMatrix.class, 111, 4159, 4625);
        try {
            CallChecker.varInit(this, "this", 111, 4159, 4625);
            CallChecker.varInit(d, "d", 111, 4159, 4625);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 111, 4159, 4625);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 112, 4238, 4279);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 113, 4289, 4333);
            final RealMatrix out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 114, 4343, 4401);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(out, RealMatrix.class, 117, 4528, 4530)) {
                        CallChecker.isCalled(out, RealMatrix.class, 117, 4528, 4530).setEntry(row, col, ((getEntry(row, col)) + d));
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1391.methodEnd();
        }
    }

    public RealMatrix scalarMultiply(final double d) {
        MethodContext _bcornu_methode_context1392 = new MethodContext(RealMatrix.class, 125, 4632, 5103);
        try {
            CallChecker.varInit(this, "this", 125, 4632, 5103);
            CallChecker.varInit(d, "d", 125, 4632, 5103);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 125, 4632, 5103);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 126, 4716, 4757);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 127, 4767, 4811);
            final RealMatrix out = CallChecker.varInit(createMatrix(rowCount, columnCount), "out", 128, 4821, 4879);
            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < columnCount; ++col) {
                    if (CallChecker.beforeDeref(out, RealMatrix.class, 131, 5006, 5008)) {
                        CallChecker.isCalled(out, RealMatrix.class, 131, 5006, 5008).setEntry(row, col, ((getEntry(row, col)) * d));
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1392.methodEnd();
        }
    }

    public RealMatrix multiply(final RealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1393 = new MethodContext(RealMatrix.class, 139, 5110, 5848);
        try {
            CallChecker.varInit(this, "this", 139, 5110, 5848);
            CallChecker.varInit(m, "m", 139, 5110, 5848);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 139, 5110, 5848);
            MatrixUtils.checkMultiplicationCompatible(this, m);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 143, 5295, 5330);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 144, 5358, 5358).getColumnDimension())), "nCols", 144, 5340, 5380);
            final int nSum = CallChecker.varInit(((int) (getColumnDimension())), "nSum", 145, 5390, 5428);
            final RealMatrix out = CallChecker.varInit(createMatrix(nRows, nCols), "out", 146, 5438, 5487);
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    double sum = CallChecker.varInit(((double) (0)), "sum", 149, 5605, 5619);
                    for (int i = 0; i < nSum; ++i) {
                        if (CallChecker.beforeDeref(m, RealMatrix.class, 151, 5716, 5716)) {
                            sum += (getEntry(row, i)) * (CallChecker.isCalled(m, RealMatrix.class, 151, 5716, 5716).getEntry(i, col));
                            CallChecker.varAssign(sum, "sum", 151, 5690, 5734);
                        }
                    }
                    if (CallChecker.beforeDeref(out, RealMatrix.class, 153, 5770, 5772)) {
                        CallChecker.isCalled(out, RealMatrix.class, 153, 5770, 5772).setEntry(row, col, sum);
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1393.methodEnd();
        }
    }

    public RealMatrix preMultiply(final RealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1394 = new MethodContext(RealMatrix.class, 161, 5855, 6011);
        try {
            CallChecker.varInit(this, "this", 161, 5855, 6011);
            CallChecker.varInit(m, "m", 161, 5855, 6011);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 161, 5855, 6011);
            if (CallChecker.beforeDeref(m, RealMatrix.class, 163, 5989, 5989)) {
                return CallChecker.isCalled(m, RealMatrix.class, 163, 5989, 5989).multiply(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1394.methodEnd();
        }
    }

    public RealMatrix power(final int p) throws NotPositiveException, NonSquareMatrixException {
        MethodContext _bcornu_methode_context1395 = new MethodContext(RealMatrix.class, 167, 6018, 7802);
        try {
            CallChecker.varInit(this, "this", 167, 6018, 7802);
            CallChecker.varInit(p, "p", 167, 6018, 7802);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 167, 6018, 7802);
            if (p < 0) {
                throw new NotPositiveException(LocalizedFormats.NOT_POSITIVE_EXPONENT, p);
            }
            if (!(isSquare())) {
                throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
            }
            if (p == 0) {
                return MatrixUtils.createRealIdentityMatrix(this.getRowDimension());
            }
            if (p == 1) {
                return this.copy();
            }
            final int power = CallChecker.varInit(((int) (p - 1)), "power", 185, 6577, 6600);
            final char[] binaryRepresentation = CallChecker.varInit(CallChecker.isCalled(Integer.toBinaryString(power), String.class, 194, 6856, 6884).toCharArray(), "binaryRepresentation", 194, 6820, 6899);
            final ArrayList<Integer> nonZeroPositions = CallChecker.varInit(new ArrayList<Integer>(), "nonZeroPositions", 195, 6909, 6977);
            int maxI = CallChecker.varInit(((int) (-1)), "maxI", 196, 6987, 7000);
            for (int i = 0; i < (CallChecker.isCalled(binaryRepresentation, char[].class, 198, 7031, 7050).length); ++i) {
                if (CallChecker.beforeDeref(binaryRepresentation, char[].class, 199, 7083, 7102)) {
                    if ((CallChecker.isCalled(binaryRepresentation, char[].class, 199, 7083, 7102)[i]) == '1') {
                        final int pos = CallChecker.varInit(((int) (((CallChecker.isCalled(binaryRepresentation, char[].class, 200, 7149, 7168).length) - i) - 1)), "pos", 200, 7133, 7184);
                        if (CallChecker.beforeDeref(nonZeroPositions, ArrayList.class, 201, 7202, 7217)) {
                            CallChecker.isCalled(nonZeroPositions, ArrayList.class, 201, 7202, 7217).add(pos);
                        }
                        if (maxI == (-1)) {
                            maxI = pos;
                            CallChecker.varAssign(maxI, "maxI", 205, 7365, 7375);
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            RealMatrix[] results = CallChecker.varInit(new RealMatrix[maxI + 1], "results", 210, 7428, 7475);
            if (CallChecker.beforeDeref(results, RealMatrix[].class, 211, 7485, 7491)) {
                results = CallChecker.beforeCalled(results, RealMatrix[].class, 211, 7485, 7491);
                CallChecker.isCalled(results, RealMatrix[].class, 211, 7485, 7491)[0] = this.copy();
                CallChecker.varAssign(CallChecker.isCalled(results, RealMatrix[].class, 211, 7485, 7491)[0], "CallChecker.isCalled(results, RealMatrix[].class, 211, 7485, 7491)[0]", 211, 7485, 7509);
            }
            for (int i = 1; i <= maxI; ++i) {
                if (CallChecker.beforeDeref(results, RealMatrix[].class, 214, 7566, 7572)) {
                    if (CallChecker.beforeDeref(results, RealMatrix[].class, 214, 7579, 7585)) {
                        if (CallChecker.beforeDeref(results, RealMatrix[].class, 214, 7601, 7607)) {
                            results = CallChecker.beforeCalled(results, RealMatrix[].class, 214, 7579, 7585);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(results, RealMatrix[].class, 214, 7579, 7585)[(i - 1)], RealMatrix.class, 214, 7579, 7590)) {
                                results = CallChecker.beforeCalled(results, RealMatrix[].class, 214, 7566, 7572);
                                results = CallChecker.beforeCalled(results, RealMatrix[].class, 214, 7579, 7585);
                                results = CallChecker.beforeCalled(results, RealMatrix[].class, 214, 7601, 7607);
                                CallChecker.isCalled(results, RealMatrix[].class, 214, 7579, 7585)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(results, RealMatrix[].class, 214, 7579, 7585)[(i - 1)], RealMatrix.class, 214, 7579, 7590);
                                CallChecker.isCalled(results, RealMatrix[].class, 214, 7566, 7572)[i] = CallChecker.isCalled(CallChecker.isCalled(results, RealMatrix[].class, 214, 7579, 7585)[(i - 1)], RealMatrix.class, 214, 7579, 7590).multiply(CallChecker.isCalled(results, RealMatrix[].class, 214, 7601, 7607)[(i - 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(results, RealMatrix[].class, 214, 7566, 7572)[i], "CallChecker.isCalled(results, RealMatrix[].class, 214, 7566, 7572)[i]", 214, 7566, 7614);
                            }
                        }
                    }
                }
            }
            RealMatrix result = CallChecker.varInit(this.copy(), "result", 217, 7635, 7666);
            if (CallChecker.beforeDeref(nonZeroPositions, RealMatrix.class, 219, 7694, 7709)) {
                for (Integer i : nonZeroPositions) {
                    if (CallChecker.beforeDeref(results, RealMatrix[].class, 220, 7751, 7757)) {
                        if (CallChecker.beforeDeref(result, RealMatrix.class, 220, 7735, 7740)) {
                            results = CallChecker.beforeCalled(results, RealMatrix[].class, 220, 7751, 7757);
                            result = CallChecker.beforeCalled(result, RealMatrix.class, 220, 7735, 7740);
                            result = CallChecker.isCalled(result, RealMatrix.class, 220, 7735, 7740).multiply(CallChecker.isCalled(results, RealMatrix[].class, 220, 7751, 7757)[i]);
                            CallChecker.varAssign(result, "result", 220, 7726, 7762);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1395.methodEnd();
        }
    }

    public double[][] getData() {
        MethodContext _bcornu_methode_context1396 = new MethodContext(double[][].class, 227, 7809, 8188);
        try {
            CallChecker.varInit(this, "this", 227, 7809, 8188);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 227, 7809, 8188);
            final double[][] data = CallChecker.varInit(new double[getRowDimension()][getColumnDimension()], "data", 228, 7872, 7947);
            for (int i = 0; i < (CallChecker.isCalled(data, double[][].class, 230, 7978, 7981).length); ++i) {
                final double[] dataI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 231, 8033, 8036)[i], "dataI", 231, 8010, 8040);
                for (int j = 0; j < (CallChecker.isCalled(dataI, double[].class, 232, 8074, 8078).length); ++j) {
                    if (CallChecker.beforeDeref(dataI, double[].class, 233, 8111, 8115)) {
                        CallChecker.isCalled(dataI, double[].class, 233, 8111, 8115)[j] = getEntry(i, j);
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 233, 8111, 8115)[j], "CallChecker.isCalled(dataI, double[].class, 233, 8111, 8115)[j]", 233, 8111, 8136);
                    }
                }
            }
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1396.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context1400 = new MethodContext(double.class, 241, 8195, 9406);
        try {
            CallChecker.varInit(this, "this", 241, 8195, 9406);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 241, 8195, 9406);
            return walkInColumnOrder(new RealMatrixPreservingVisitor() {
                private double endRow;

                private double columnSum;

                private double maxColSum;

                public void start(final int rows, final int columns, final int startRow, final int endRow, final int startColumn, final int endColumn) {
                    MethodContext _bcornu_methode_context1397 = new MethodContext(void.class, 254, 8585, 8931);
                    try {
                        CallChecker.varInit(this, "this", 254, 8585, 8931);
                        CallChecker.varInit(endColumn, "endColumn", 254, 8585, 8931);
                        CallChecker.varInit(startColumn, "startColumn", 254, 8585, 8931);
                        CallChecker.varInit(endRow, "endRow", 254, 8585, 8931);
                        CallChecker.varInit(startRow, "startRow", 254, 8585, 8931);
                        CallChecker.varInit(columns, "columns", 254, 8585, 8931);
                        CallChecker.varInit(rows, "rows", 254, 8585, 8931);
                        this.endRow = endRow;
                        CallChecker.varAssign(this.endRow, "this.endRow", 257, 8831, 8851);
                        columnSum = 0;
                        CallChecker.varAssign(this.columnSum, "this.columnSum", 258, 8869, 8884);
                        maxColSum = 0;
                        CallChecker.varAssign(this.maxColSum, "this.maxColSum", 259, 8902, 8917);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1397.methodEnd();
                    }
                }

                public void visit(final int row, final int column, final double value) {
                    MethodContext _bcornu_methode_context1398 = new MethodContext(void.class, 263, 8946, 9272);
                    try {
                        CallChecker.varInit(this, "this", 263, 8946, 9272);
                        CallChecker.varInit(value, "value", 263, 8946, 9272);
                        CallChecker.varInit(column, "column", 263, 8946, 9272);
                        CallChecker.varInit(row, "row", 263, 8946, 9272);
                        columnSum += FastMath.abs(value);
                        CallChecker.varAssign(this.columnSum, "this.columnSum", 264, 9068, 9100);
                        if (row == (endRow)) {
                            maxColSum = FastMath.max(maxColSum, columnSum);
                            CallChecker.varAssign(this.maxColSum, "this.maxColSum", 266, 9159, 9205);
                            columnSum = 0;
                            CallChecker.varAssign(this.columnSum, "this.columnSum", 267, 9227, 9240);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1398.methodEnd();
                    }
                }

                public double end() {
                    MethodContext _bcornu_methode_context1399 = new MethodContext(double.class, 272, 9287, 9388);
                    try {
                        CallChecker.varInit(this, "this", 272, 9287, 9388);
                        return maxColSum;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1399.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1400.methodEnd();
        }
    }

    public double getFrobeniusNorm() {
        MethodContext _bcornu_methode_context1404 = new MethodContext(double.class, 279, 9413, 10215);
        try {
            CallChecker.varInit(this, "this", 279, 9413, 10215);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 279, 9413, 10215);
            return walkInOptimizedOrder(new RealMatrixPreservingVisitor() {
                private double sum;

                public void start(final int rows, final int columns, final int startRow, final int endRow, final int startColumn, final int endColumn) {
                    MethodContext _bcornu_methode_context1401 = new MethodContext(void.class, 286, 9634, 9901);
                    try {
                        CallChecker.varInit(this, "this", 286, 9634, 9901);
                        CallChecker.varInit(endColumn, "endColumn", 286, 9634, 9901);
                        CallChecker.varInit(startColumn, "startColumn", 286, 9634, 9901);
                        CallChecker.varInit(endRow, "endRow", 286, 9634, 9901);
                        CallChecker.varInit(startRow, "startRow", 286, 9634, 9901);
                        CallChecker.varInit(columns, "columns", 286, 9634, 9901);
                        CallChecker.varInit(rows, "rows", 286, 9634, 9901);
                        sum = 0;
                        CallChecker.varAssign(this.sum, "this.sum", 289, 9880, 9887);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1401.methodEnd();
                    }
                }

                public void visit(final int row, final int column, final double value) {
                    MethodContext _bcornu_methode_context1402 = new MethodContext(void.class, 293, 9916, 10072);
                    try {
                        CallChecker.varInit(this, "this", 293, 9916, 10072);
                        CallChecker.varInit(value, "value", 293, 9916, 10072);
                        CallChecker.varInit(column, "column", 293, 9916, 10072);
                        CallChecker.varInit(row, "row", 293, 9916, 10072);
                        sum += value * value;
                        CallChecker.varAssign(this.sum, "this.sum", 294, 10038, 10058);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1402.methodEnd();
                    }
                }

                public double end() {
                    MethodContext _bcornu_methode_context1403 = new MethodContext(double.class, 298, 10087, 10197);
                    try {
                        CallChecker.varInit(this, "this", 298, 10087, 10197);
                        return FastMath.sqrt(sum);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1403.methodEnd();
                    }
                }
            });
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1404.methodEnd();
        }
    }

    public RealMatrix getSubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1405 = new MethodContext(RealMatrix.class, 305, 10222, 10914);
        try {
            CallChecker.varInit(this, "this", 305, 10222, 10914);
            CallChecker.varInit(endColumn, "endColumn", 305, 10222, 10914);
            CallChecker.varInit(startColumn, "startColumn", 305, 10222, 10914);
            CallChecker.varInit(endRow, "endRow", 305, 10222, 10914);
            CallChecker.varInit(startRow, "startRow", 305, 10222, 10914);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 305, 10222, 10914);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            final RealMatrix subMatrix = CallChecker.varInit(createMatrix(((endRow - startRow) + 1), ((endColumn - startColumn) + 1)), "subMatrix", 310, 10557, 10662);
            for (int i = startRow; i <= endRow; ++i) {
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(subMatrix, RealMatrix.class, 314, 10792, 10800)) {
                        CallChecker.isCalled(subMatrix, RealMatrix.class, 314, 10792, 10800).setEntry((i - startRow), (j - startColumn), getEntry(i, j));
                    }
                }
            }
            return subMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1405.methodEnd();
        }
    }

    public RealMatrix getSubMatrix(final int[] selectedRows, final int[] selectedColumns) throws NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1407 = new MethodContext(RealMatrix.class, 322, 10921, 11689);
        try {
            CallChecker.varInit(this, "this", 322, 10921, 11689);
            CallChecker.varInit(selectedColumns, "selectedColumns", 322, 10921, 11689);
            CallChecker.varInit(selectedRows, "selectedRows", 322, 10921, 11689);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 322, 10921, 11689);
            MatrixUtils.checkSubMatrixIndex(this, selectedRows, selectedColumns);
            final RealMatrix subMatrix = CallChecker.varInit(createMatrix(CallChecker.isCalled(selectedRows, int[].class, 328, 11285, 11296).length, CallChecker.isCalled(selectedColumns, int[].class, 328, 11306, 11320).length), "subMatrix", 327, 11231, 11329);
            if (CallChecker.beforeDeref(subMatrix, RealMatrix.class, 329, 11339, 11347)) {
                CallChecker.isCalled(subMatrix, RealMatrix.class, 329, 11339, 11347).walkInOptimizedOrder(new DefaultRealMatrixChangingVisitor() {
                    @Override
                    public double visit(final int row, final int column, final double value) {
                        MethodContext _bcornu_methode_context1406 = new MethodContext(double.class, 333, 11424, 11643);
                        try {
                            CallChecker.varInit(this, "this", 333, 11424, 11643);
                            CallChecker.varInit(value, "value", 333, 11424, 11643);
                            CallChecker.varInit(column, "column", 333, 11424, 11643);
                            CallChecker.varInit(row, "row", 333, 11424, 11643);
                            if (CallChecker.beforeDeref(selectedRows, int[].class, 334, 11586, 11597)) {
                                if (CallChecker.beforeDeref(selectedColumns, int[].class, 334, 11605, 11619)) {
                                    return getEntry(CallChecker.isCalled(selectedRows, int[].class, 334, 11586, 11597)[row], CallChecker.isCalled(selectedColumns, int[].class, 334, 11605, 11619)[column]);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Double) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context1406.methodEnd();
                        }
                    }
                });
            }else
                throw new AbnormalExecutionError();
            
            return subMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1407.methodEnd();
        }
    }

    public void copySubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn, final double[][] destination) throws NumberIsTooSmallException, OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1410 = new MethodContext(void.class, 343, 11696, 13711);
        try {
            CallChecker.varInit(this, "this", 343, 11696, 13711);
            CallChecker.varInit(destination, "destination", 343, 11696, 13711);
            CallChecker.varInit(endColumn, "endColumn", 343, 11696, 13711);
            CallChecker.varInit(startColumn, "startColumn", 343, 11696, 13711);
            CallChecker.varInit(endRow, "endRow", 343, 11696, 13711);
            CallChecker.varInit(startRow, "startRow", 343, 11696, 13711);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 343, 11696, 13711);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            final int rowsCount = CallChecker.varInit(((int) ((endRow + 1) - startRow)), "rowsCount", 349, 12122, 12168);
            final int columnsCount = CallChecker.varInit(((int) ((endColumn + 1) - startColumn)), "columnsCount", 350, 12178, 12230);
            if (CallChecker.beforeDeref(destination, double[][].class, 351, 12245, 12255)) {
                if (CallChecker.beforeDeref(destination, double[][].class, 351, 12281, 12291)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 351, 12281, 12291)[0], double[].class, 351, 12281, 12294)) {
                        CallChecker.isCalled(destination, double[][].class, 351, 12281, 12291)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 351, 12281, 12291)[0], double[].class, 351, 12281, 12294);
                        if (((CallChecker.isCalled(destination, double[][].class, 351, 12245, 12255).length) < rowsCount) || ((CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 351, 12281, 12291)[0], double[].class, 351, 12281, 12294).length) < columnsCount)) {
                            if (CallChecker.beforeDeref(destination, double[][].class, 352, 12377, 12387)) {
                                if (CallChecker.beforeDeref(destination, double[][].class, 352, 12397, 12407)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 352, 12397, 12407)[0], double[].class, 352, 12397, 12410)) {
                                        CallChecker.isCalled(destination, double[][].class, 352, 12397, 12407)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 352, 12397, 12407)[0], double[].class, 352, 12397, 12410);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, double[][].class, 352, 12377, 12387).length, CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 352, 12397, 12407)[0], double[].class, 352, 12397, 12410).length, rowsCount, columnsCount);
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
            for (int i = 1; i < rowsCount; i++) {
                if (CallChecker.beforeDeref(destination, double[][].class, 357, 12574, 12584)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 357, 12574, 12584)[i], double[].class, 357, 12574, 12587)) {
                        CallChecker.isCalled(destination, double[][].class, 357, 12574, 12584)[i] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 357, 12574, 12584)[i], double[].class, 357, 12574, 12587);
                        if ((CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 357, 12574, 12584)[i], double[].class, 357, 12574, 12587).length) < columnsCount) {
                            if (CallChecker.beforeDeref(destination, double[][].class, 358, 12673, 12683)) {
                                if (CallChecker.beforeDeref(destination, double[][].class, 358, 12693, 12703)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 358, 12693, 12703)[i], double[].class, 358, 12693, 12706)) {
                                        CallChecker.isCalled(destination, double[][].class, 358, 12693, 12703)[i] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 358, 12693, 12703)[i], double[].class, 358, 12693, 12706);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, double[][].class, 358, 12673, 12683).length, CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 358, 12693, 12703)[i], double[].class, 358, 12693, 12706).length, rowsCount, columnsCount);
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
            walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() {
                private int startRow;

                private int startColumn;

                @Override
                public void start(final int rows, final int columns, final int startRow, final int endRow, final int startColumn, final int endColumn) {
                    MethodContext _bcornu_methode_context1408 = new MethodContext(void.class, 373, 13063, 13420);
                    try {
                        CallChecker.varInit(this, "this", 373, 13063, 13420);
                        CallChecker.varInit(endColumn, "endColumn", 373, 13063, 13420);
                        CallChecker.varInit(startColumn, "startColumn", 373, 13063, 13420);
                        CallChecker.varInit(endRow, "endRow", 373, 13063, 13420);
                        CallChecker.varInit(startRow, "startRow", 373, 13063, 13420);
                        CallChecker.varInit(columns, "columns", 373, 13063, 13420);
                        CallChecker.varInit(rows, "rows", 373, 13063, 13420);
                        this.startRow = startRow;
                        CallChecker.varAssign(this.startRow, "this.startRow", 376, 13331, 13358);
                        this.startColumn = startColumn;
                        CallChecker.varAssign(this.startColumn, "this.startColumn", 377, 13376, 13406);
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1408.methodEnd();
                    }
                }

                @Override
                public void visit(final int row, final int column, final double value) {
                    MethodContext _bcornu_methode_context1409 = new MethodContext(void.class, 382, 13435, 13650);
                    try {
                        CallChecker.varInit(this, "this", 382, 13435, 13650);
                        CallChecker.varInit(value, "value", 382, 13435, 13650);
                        CallChecker.varInit(column, "column", 382, 13435, 13650);
                        CallChecker.varInit(row, "row", 382, 13435, 13650);
                        if (CallChecker.beforeDeref(destination, double[][].class, 383, 13579, 13589)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (startRow))], double[].class, 383, 13579, 13605)) {
                                CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (startRow))] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (startRow))], double[].class, 383, 13579, 13605);
                                CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (startRow))], double[].class, 383, 13579, 13605)[(column - (startColumn))] = value;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (this.startRow))], double[].class, 383, 13579, 13605)[(column - (this.startColumn))], "CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 383, 13579, 13589)[(row - (this.startRow))], double[].class, 383, 13579, 13605)[(column - (this.startColumn))]", 383, 13579, 13636);
                            }
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1409.methodEnd();
                    }
                }
            }, startRow, endRow, startColumn, endColumn);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1410.methodEnd();
        }
    }

    public void copySubMatrix(int[] selectedRows, int[] selectedColumns, double[][] destination) throws NoDataException, NullArgumentException, OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1411 = new MethodContext(void.class, 390, 13718, 14980);
        try {
            CallChecker.varInit(this, "this", 390, 13718, 14980);
            CallChecker.varInit(destination, "destination", 390, 13718, 14980);
            CallChecker.varInit(selectedColumns, "selectedColumns", 390, 13718, 14980);
            CallChecker.varInit(selectedRows, "selectedRows", 390, 13718, 14980);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 390, 13718, 14980);
            MatrixUtils.checkSubMatrixIndex(this, selectedRows, selectedColumns);
            selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 395, 14089, 14103);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(selectedColumns, int[].class, 395, 14089, 14103).length)), "nCols", 395, 14071, 14111);
            if (CallChecker.beforeDeref(destination, double[][].class, 396, 14126, 14136)) {
                if (CallChecker.beforeDeref(selectedRows, int[].class, 396, 14147, 14158)) {
                    if (CallChecker.beforeDeref(destination, double[][].class, 397, 14184, 14194)) {
                        destination = CallChecker.beforeCalled(destination, double[][].class, 397, 14184, 14194);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 397, 14184, 14194)[0], double[].class, 397, 14184, 14197)) {
                            destination = CallChecker.beforeCalled(destination, double[][].class, 396, 14126, 14136);
                            selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 396, 14147, 14158);
                            destination = CallChecker.beforeCalled(destination, double[][].class, 397, 14184, 14194);
                            CallChecker.isCalled(destination, double[][].class, 397, 14184, 14194)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 397, 14184, 14194)[0], double[].class, 397, 14184, 14197);
                            if (((CallChecker.isCalled(destination, double[][].class, 396, 14126, 14136).length) < (CallChecker.isCalled(selectedRows, int[].class, 396, 14147, 14158).length)) || ((CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 397, 14184, 14194)[0], double[].class, 397, 14184, 14197).length) < nCols)) {
                                if (CallChecker.beforeDeref(destination, double[][].class, 398, 14273, 14283)) {
                                    if (CallChecker.beforeDeref(destination, double[][].class, 398, 14293, 14303)) {
                                        destination = CallChecker.beforeCalled(destination, double[][].class, 398, 14293, 14303);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(destination, double[][].class, 398, 14293, 14303)[0], double[].class, 398, 14293, 14306)) {
                                            if (CallChecker.beforeDeref(selectedRows, int[].class, 399, 14371, 14382)) {
                                                if (CallChecker.beforeDeref(selectedColumns, int[].class, 399, 14392, 14406)) {
                                                    destination = CallChecker.beforeCalled(destination, double[][].class, 398, 14273, 14283);
                                                    destination = CallChecker.beforeCalled(destination, double[][].class, 398, 14293, 14303);
                                                    CallChecker.isCalled(destination, double[][].class, 398, 14293, 14303)[0] = CallChecker.beforeCalled(CallChecker.isCalled(destination, double[][].class, 398, 14293, 14303)[0], double[].class, 398, 14293, 14306);
                                                    selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 399, 14371, 14382);
                                                    selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 399, 14392, 14406);
                                                    throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, double[][].class, 398, 14273, 14283).length, CallChecker.isCalled(CallChecker.isCalled(destination, double[][].class, 398, 14293, 14303)[0], double[].class, 398, 14293, 14306).length, CallChecker.isCalled(selectedRows, int[].class, 399, 14371, 14382).length, CallChecker.isCalled(selectedColumns, int[].class, 399, 14392, 14406).length);
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
            selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 402, 14456, 14467);
            for (int i = 0; i < (CallChecker.isCalled(selectedRows, int[].class, 402, 14456, 14467).length); i++) {
                destination = CallChecker.beforeCalled(destination, double[][].class, 403, 14526, 14536);
                final double[] destinationI = CallChecker.varInit(CallChecker.isCalled(destination, double[][].class, 403, 14526, 14536)[i], "destinationI", 403, 14496, 14540);
                if (CallChecker.beforeDeref(destinationI, double[].class, 404, 14558, 14569)) {
                    if ((CallChecker.isCalled(destinationI, double[].class, 404, 14558, 14569).length) < nCols) {
                        if (CallChecker.beforeDeref(destination, double[][].class, 405, 14648, 14658)) {
                            if (CallChecker.beforeDeref(destinationI, double[].class, 405, 14668, 14679)) {
                                if (CallChecker.beforeDeref(selectedRows, int[].class, 406, 14748, 14759)) {
                                    if (CallChecker.beforeDeref(selectedColumns, int[].class, 406, 14769, 14783)) {
                                        destination = CallChecker.beforeCalled(destination, double[][].class, 405, 14648, 14658);
                                        selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 406, 14748, 14759);
                                        selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 406, 14769, 14783);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(destination, double[][].class, 405, 14648, 14658).length, CallChecker.isCalled(destinationI, double[].class, 405, 14668, 14679).length, CallChecker.isCalled(selectedRows, int[].class, 406, 14748, 14759).length, CallChecker.isCalled(selectedColumns, int[].class, 406, 14769, 14783).length);
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
                selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 408, 14840, 14854);
                for (int j = 0; j < (CallChecker.isCalled(selectedColumns, int[].class, 408, 14840, 14854).length); j++) {
                    if (CallChecker.beforeDeref(destinationI, double[].class, 409, 14887, 14898)) {
                        if (CallChecker.beforeDeref(selectedRows, int[].class, 409, 14914, 14925)) {
                            if (CallChecker.beforeDeref(selectedColumns, int[].class, 409, 14931, 14945)) {
                                selectedRows = CallChecker.beforeCalled(selectedRows, int[].class, 409, 14914, 14925);
                                selectedColumns = CallChecker.beforeCalled(selectedColumns, int[].class, 409, 14931, 14945);
                                CallChecker.isCalled(destinationI, double[].class, 409, 14887, 14898)[j] = getEntry(CallChecker.isCalled(selectedRows, int[].class, 409, 14914, 14925)[i], CallChecker.isCalled(selectedColumns, int[].class, 409, 14931, 14945)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(destinationI, double[].class, 409, 14887, 14898)[j], "CallChecker.isCalled(destinationI, double[].class, 409, 14887, 14898)[j]", 409, 14887, 14950);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1411.methodEnd();
        }
    }

    public void setSubMatrix(final double[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1412 = new MethodContext(void.class, 415, 14987, 16168);
        try {
            CallChecker.varInit(this, "this", 415, 14987, 16168);
            CallChecker.varInit(column, "column", 415, 14987, 16168);
            CallChecker.varInit(row, "row", 415, 14987, 16168);
            CallChecker.varInit(subMatrix, "subMatrix", 415, 14987, 16168);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 415, 14987, 16168);
            MathUtils.checkNotNull(subMatrix);
            final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(subMatrix, double[][].class, 419, 15280, 15288).length)), "nRows", 419, 15262, 15296);
            if (nRows == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
            }
            CallChecker.isCalled(subMatrix, double[][].class, 424, 15435, 15443)[0] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 424, 15435, 15443)[0], double[].class, 424, 15435, 15446);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 424, 15435, 15443)[0], double[].class, 424, 15435, 15446).length)), "nCols", 424, 15417, 15454);
            if (nCols == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            for (int r = 1; r < nRows; ++r) {
                if (CallChecker.beforeDeref(subMatrix, double[][].class, 430, 15628, 15636)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, double[][].class, 430, 15628, 15636)[r], double[].class, 430, 15628, 15639)) {
                        CallChecker.isCalled(subMatrix, double[][].class, 430, 15628, 15636)[r] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 430, 15628, 15636)[r], double[].class, 430, 15628, 15639);
                        if ((CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 430, 15628, 15636)[r], double[].class, 430, 15628, 15639).length) != nCols) {
                            if (CallChecker.beforeDeref(subMatrix, double[][].class, 431, 15720, 15728)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, double[][].class, 431, 15720, 15728)[r], double[].class, 431, 15720, 15731)) {
                                    CallChecker.isCalled(subMatrix, double[][].class, 431, 15720, 15728)[r] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 431, 15720, 15728)[r], double[].class, 431, 15720, 15731);
                                    throw new DimensionMismatchException(nCols, CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 431, 15720, 15728)[r], double[].class, 431, 15720, 15731).length);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }
            MatrixUtils.checkRowIndex(this, row);
            MatrixUtils.checkColumnIndex(this, column);
            MatrixUtils.checkRowIndex(this, ((nRows + row) - 1));
            MatrixUtils.checkColumnIndex(this, ((nCols + column) - 1));
            for (int i = 0; i < nRows; ++i) {
                for (int j = 0; j < nCols; ++j) {
                    if (CallChecker.beforeDeref(subMatrix, double[][].class, 442, 16122, 16130)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, double[][].class, 442, 16122, 16130)[i], double[].class, 442, 16122, 16133)) {
                            CallChecker.isCalled(subMatrix, double[][].class, 442, 16122, 16130)[i] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 442, 16122, 16130)[i], double[].class, 442, 16122, 16133);
                            setEntry((row + i), (column + j), CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 442, 16122, 16130)[i], double[].class, 442, 16122, 16133)[j]);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1412.methodEnd();
        }
    }

    public RealMatrix getRowMatrix(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1413 = new MethodContext(RealMatrix.class, 448, 16175, 16551);
        try {
            CallChecker.varInit(this, "this", 448, 16175, 16551);
            CallChecker.varInit(row, "row", 448, 16175, 16551);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 448, 16175, 16551);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 450, 16329, 16367);
            final RealMatrix out = CallChecker.varInit(createMatrix(1, nCols), "out", 451, 16377, 16422);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(out, RealMatrix.class, 453, 16478, 16480)) {
                    CallChecker.isCalled(out, RealMatrix.class, 453, 16478, 16480).setEntry(0, i, getEntry(row, i));
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1413.methodEnd();
        }
    }

    public void setRowMatrix(final int row, final RealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1414 = new MethodContext(void.class, 460, 16558, 17264);
        try {
            CallChecker.varInit(this, "this", 460, 16558, 17264);
            CallChecker.varInit(matrix, "matrix", 460, 16558, 17264);
            CallChecker.varInit(row, "row", 460, 16558, 17264);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 460, 16558, 17264);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 463, 16773, 16811);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 464, 16826, 16831)) {
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 465, 16873, 16878)) {
                    if (((CallChecker.isCalled(matrix, RealMatrix.class, 464, 16826, 16831).getRowDimension()) != 1) || ((CallChecker.isCalled(matrix, RealMatrix.class, 465, 16873, 16878).getColumnDimension()) != nCols)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 466, 16969, 16974)) {
                            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 467, 17050, 17055)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, RealMatrix.class, 466, 16969, 16974).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 467, 17050, 17055).getColumnDimension(), 1, nCols);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 471, 17226, 17231)) {
                    setEntry(row, i, CallChecker.isCalled(matrix, RealMatrix.class, 471, 17226, 17231).getEntry(0, i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1414.methodEnd();
        }
    }

    public RealMatrix getColumnMatrix(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1415 = new MethodContext(RealMatrix.class, 476, 17271, 17667);
        try {
            CallChecker.varInit(this, "this", 476, 17271, 17667);
            CallChecker.varInit(column, "column", 476, 17271, 17667);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 476, 17271, 17667);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 479, 17445, 17480);
            final RealMatrix out = CallChecker.varInit(createMatrix(nRows, 1), "out", 480, 17490, 17535);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(out, RealMatrix.class, 482, 17591, 17593)) {
                    CallChecker.isCalled(out, RealMatrix.class, 482, 17591, 17593).setEntry(i, 0, getEntry(i, column));
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1415.methodEnd();
        }
    }

    public void setColumnMatrix(final int column, final RealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1416 = new MethodContext(void.class, 489, 17674, 18392);
        try {
            CallChecker.varInit(this, "this", 489, 17674, 18392);
            CallChecker.varInit(matrix, "matrix", 489, 17674, 18392);
            CallChecker.varInit(column, "column", 489, 17674, 18392);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 489, 17674, 18392);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 492, 17901, 17936);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 493, 17951, 17956)) {
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 494, 18002, 18007)) {
                    if (((CallChecker.isCalled(matrix, RealMatrix.class, 493, 17951, 17956).getRowDimension()) != nRows) || ((CallChecker.isCalled(matrix, RealMatrix.class, 494, 18002, 18007).getColumnDimension()) != 1)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 495, 18094, 18099)) {
                            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 496, 18175, 18180)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, RealMatrix.class, 495, 18094, 18099).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 496, 18175, 18180).getColumnDimension(), nRows, 1);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 500, 18354, 18359)) {
                    setEntry(i, column, CallChecker.isCalled(matrix, RealMatrix.class, 500, 18354, 18359).getEntry(i, 0));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1416.methodEnd();
        }
    }

    public RealVector getRowVector(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1417 = new MethodContext(RealVector.class, 505, 18399, 18567);
        try {
            CallChecker.varInit(this, "this", 505, 18399, 18567);
            CallChecker.varInit(row, "row", 505, 18399, 18567);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 505, 18399, 18567);
            return new ArrayRealVector(getRow(row), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1417.methodEnd();
        }
    }

    public void setRowVector(final int row, final RealVector vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1418 = new MethodContext(void.class, 511, 18574, 19138);
        try {
            CallChecker.varInit(this, "this", 511, 18574, 19138);
            CallChecker.varInit(vector, "vector", 511, 18574, 19138);
            CallChecker.varInit(row, "row", 511, 18574, 19138);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 511, 18574, 19138);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 514, 18789, 18827);
            if (CallChecker.beforeDeref(vector, RealVector.class, 515, 18841, 18846)) {
                if ((CallChecker.isCalled(vector, RealVector.class, 515, 18841, 18846).getDimension()) != nCols) {
                    if (CallChecker.beforeDeref(vector, RealVector.class, 516, 18933, 18938)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(vector, RealVector.class, 516, 18933, 18938).getDimension(), 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(vector, RealVector.class, 520, 19103, 19108)) {
                    setEntry(row, i, CallChecker.isCalled(vector, RealVector.class, 520, 19103, 19108).getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1418.methodEnd();
        }
    }

    public RealVector getColumnVector(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1419 = new MethodContext(RealVector.class, 525, 19145, 19325);
        try {
            CallChecker.varInit(this, "this", 525, 19145, 19325);
            CallChecker.varInit(column, "column", 525, 19145, 19325);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 525, 19145, 19325);
            return new ArrayRealVector(getColumn(column), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1419.methodEnd();
        }
    }

    public void setColumnVector(final int column, final RealVector vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1420 = new MethodContext(void.class, 531, 19332, 19908);
        try {
            CallChecker.varInit(this, "this", 531, 19332, 19908);
            CallChecker.varInit(vector, "vector", 531, 19332, 19908);
            CallChecker.varInit(column, "column", 531, 19332, 19908);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 531, 19332, 19908);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 534, 19559, 19594);
            if (CallChecker.beforeDeref(vector, RealVector.class, 535, 19608, 19613)) {
                if ((CallChecker.isCalled(vector, RealVector.class, 535, 19608, 19613).getDimension()) != nRows) {
                    if (CallChecker.beforeDeref(vector, RealVector.class, 536, 19697, 19702)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(vector, RealVector.class, 536, 19697, 19702).getDimension(), 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(vector, RealVector.class, 540, 19873, 19878)) {
                    setEntry(i, column, CallChecker.isCalled(vector, RealVector.class, 540, 19873, 19878).getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1420.methodEnd();
        }
    }

    public double[] getRow(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1421 = new MethodContext(double[].class, 545, 19915, 20265);
        try {
            CallChecker.varInit(this, "this", 545, 19915, 20265);
            CallChecker.varInit(row, "row", 545, 19915, 20265);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 545, 19915, 20265);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 547, 20061, 20099);
            final double[] out = CallChecker.varInit(new double[nCols], "out", 548, 20109, 20147);
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(out, double[].class, 550, 20203, 20205)) {
                    CallChecker.isCalled(out, double[].class, 550, 20203, 20205)[i] = getEntry(row, i);
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 550, 20203, 20205)[i], "CallChecker.isCalled(out, double[].class, 550, 20203, 20205)[i]", 550, 20203, 20228);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1421.methodEnd();
        }
    }

    public void setRow(final int row, final double[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1422 = new MethodContext(void.class, 557, 20272, 20744);
        try {
            CallChecker.varInit(this, "this", 557, 20272, 20744);
            CallChecker.varInit(array, "array", 557, 20272, 20744);
            CallChecker.varInit(row, "row", 557, 20272, 20744);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 557, 20272, 20744);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 560, 20478, 20516);
            if (CallChecker.beforeDeref(array, double[].class, 561, 20530, 20534)) {
                if ((CallChecker.isCalled(array, double[].class, 561, 20530, 20534).length) != nCols) {
                    if (CallChecker.beforeDeref(array, double[].class, 562, 20613, 20617)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(array, double[].class, 562, 20613, 20617).length, 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nCols; ++i) {
                if (CallChecker.beforeDeref(array, double[].class, 565, 20719, 20723)) {
                    setEntry(row, i, CallChecker.isCalled(array, double[].class, 565, 20719, 20723)[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1422.methodEnd();
        }
    }

    public double[] getColumn(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1423 = new MethodContext(double[].class, 570, 20751, 21113);
        try {
            CallChecker.varInit(this, "this", 570, 20751, 21113);
            CallChecker.varInit(column, "column", 570, 20751, 21113);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 570, 20751, 21113);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 572, 20909, 20944);
            final double[] out = CallChecker.varInit(new double[nRows], "out", 573, 20954, 20992);
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(out, double[].class, 575, 21048, 21050)) {
                    CallChecker.isCalled(out, double[].class, 575, 21048, 21050)[i] = getEntry(i, column);
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 575, 21048, 21050)[i], "CallChecker.isCalled(out, double[].class, 575, 21048, 21050)[i]", 575, 21048, 21076);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1423.methodEnd();
        }
    }

    public void setColumn(final int column, final double[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1424 = new MethodContext(void.class, 582, 21120, 21604);
        try {
            CallChecker.varInit(this, "this", 582, 21120, 21604);
            CallChecker.varInit(array, "array", 582, 21120, 21604);
            CallChecker.varInit(column, "column", 582, 21120, 21604);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 582, 21120, 21604);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 585, 21338, 21373);
            if (CallChecker.beforeDeref(array, double[].class, 586, 21387, 21391)) {
                if ((CallChecker.isCalled(array, double[].class, 586, 21387, 21391).length) != nRows) {
                    if (CallChecker.beforeDeref(array, double[].class, 587, 21467, 21471)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(array, double[].class, 587, 21467, 21471).length, 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < nRows; ++i) {
                if (CallChecker.beforeDeref(array, double[].class, 590, 21579, 21583)) {
                    setEntry(i, column, CallChecker.isCalled(array, double[].class, 590, 21579, 21583)[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1424.methodEnd();
        }
    }

    public void addToEntry(int row, int column, double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1425 = new MethodContext(void.class, 595, 21611, 21862);
        try {
            CallChecker.varInit(this, "this", 595, 21611, 21862);
            CallChecker.varInit(increment, "increment", 595, 21611, 21862);
            CallChecker.varInit(column, "column", 595, 21611, 21862);
            CallChecker.varInit(row, "row", 595, 21611, 21862);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 595, 21611, 21862);
            MatrixUtils.checkMatrixIndex(this, row, column);
            setEntry(row, column, ((getEntry(row, column)) + increment));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1425.methodEnd();
        }
    }

    public void multiplyEntry(int row, int column, double factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1426 = new MethodContext(void.class, 602, 21869, 22117);
        try {
            CallChecker.varInit(this, "this", 602, 21869, 22117);
            CallChecker.varInit(factor, "factor", 602, 21869, 22117);
            CallChecker.varInit(column, "column", 602, 21869, 22117);
            CallChecker.varInit(row, "row", 602, 21869, 22117);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 602, 21869, 22117);
            MatrixUtils.checkMatrixIndex(this, row, column);
            setEntry(row, column, ((getEntry(row, column)) * factor));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1426.methodEnd();
        }
    }

    public RealMatrix transpose() {
        MethodContext _bcornu_methode_context1428 = new MethodContext(RealMatrix.class, 609, 22124, 22648);
        try {
            CallChecker.varInit(this, "this", 609, 22124, 22648);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 609, 22124, 22648);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 610, 22189, 22224);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 611, 22234, 22272);
            final RealMatrix out = CallChecker.varInit(createMatrix(nCols, nRows), "out", 612, 22282, 22331);
            walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() {
                @Override
                public void visit(final int row, final int column, final double value) {
                    MethodContext _bcornu_methode_context1427 = new MethodContext(void.class, 617, 22418, 22608);
                    try {
                        CallChecker.varInit(this, "this", 617, 22418, 22608);
                        CallChecker.varInit(value, "value", 617, 22418, 22608);
                        CallChecker.varInit(column, "column", 617, 22418, 22608);
                        CallChecker.varInit(row, "row", 617, 22418, 22608);
                        if (CallChecker.beforeDeref(out, RealMatrix.class, 618, 22562, 22564)) {
                            CallChecker.isCalled(out, RealMatrix.class, 618, 22562, 22564).setEntry(column, row, value);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context1427.methodEnd();
                    }
                }
            });
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1428.methodEnd();
        }
    }

    public boolean isSquare() {
        MethodContext _bcornu_methode_context1429 = new MethodContext(boolean.class, 627, 22655, 22770);
        try {
            CallChecker.varInit(this, "this", 627, 22655, 22770);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 627, 22655, 22770);
            return (getColumnDimension()) == (getRowDimension());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1429.methodEnd();
        }
    }

    @Override
    public abstract int getRowDimension();

    @Override
    public abstract int getColumnDimension();

    public double getTrace() throws NonSquareMatrixException {
        MethodContext _bcornu_methode_context1432 = new MethodContext(double.class, 648, 23118, 23537);
        try {
            CallChecker.varInit(this, "this", 648, 23118, 23537);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 648, 23118, 23537);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 649, 23210, 23245);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 650, 23255, 23293);
            if (nRows != nCols) {
                throw new NonSquareMatrixException(nRows, nCols);
            }
            double trace = CallChecker.varInit(((double) (0)), "trace", 654, 23404, 23420);
            for (int i = 0; i < nRows; ++i) {
                trace += getEntry(i, i);
                CallChecker.varAssign(trace, "trace", 656, 23476, 23499);
            }
            return trace;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1432.methodEnd();
        }
    }

    public double[] operate(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1433 = new MethodContext(double[].class, 662, 23544, 24154);
        try {
            CallChecker.varInit(this, "this", 662, 23544, 24154);
            CallChecker.varInit(v, "v", 662, 23544, 24154);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 662, 23544, 24154);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 664, 23663, 23698);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 665, 23708, 23746);
            if (CallChecker.beforeDeref(v, double[].class, 666, 23760, 23760)) {
                if ((CallChecker.isCalled(v, double[].class, 666, 23760, 23760).length) != nCols) {
                    if (CallChecker.beforeDeref(v, double[].class, 667, 23830, 23830)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 667, 23830, 23830).length, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[nRows], "out", 670, 23867, 23905);
            for (int row = 0; row < nRows; ++row) {
                double sum = CallChecker.varInit(((double) (0)), "sum", 672, 23967, 23981);
                for (int i = 0; i < nCols; ++i) {
                    if (CallChecker.beforeDeref(v, double[].class, 674, 24071, 24071)) {
                        sum += (getEntry(row, i)) * (CallChecker.isCalled(v, double[].class, 674, 24071, 24071)[i]);
                        CallChecker.varAssign(sum, "sum", 674, 24045, 24075);
                    }
                }
                if (CallChecker.beforeDeref(out, double[].class, 676, 24103, 24105)) {
                    CallChecker.isCalled(out, double[].class, 676, 24103, 24105)[row] = sum;
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 676, 24103, 24105)[row], "CallChecker.isCalled(out, double[].class, 676, 24103, 24105)[row]", 676, 24103, 24117);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1433.methodEnd();
        }
    }

    @Override
    public RealVector operate(final RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1434 = new MethodContext(RealVector.class, 684, 24161, 25057);
        try {
            CallChecker.varInit(this, "this", 684, 24161, 25057);
            CallChecker.varInit(v, "v", 684, 24161, 25057);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 684, 24161, 25057);
            TryContext _bcornu_try_context_23 = new TryContext(23, AbstractRealMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(v, RealVector.class, 687, 24370, 24370)) {
                    return new ArrayRealVector(operate(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 687, 24370, 24370).getDataRef()), false);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassCastException cce) {
                _bcornu_try_context_23.catchStart(23);
                final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 689, 24451, 24486);
                final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 690, 24500, 24538);
                if (CallChecker.beforeDeref(v, RealVector.class, 691, 24556, 24556)) {
                    if ((CallChecker.isCalled(v, RealVector.class, 691, 24556, 24556).getDimension()) != nCols) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 692, 24638, 24638)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(v, RealVector.class, 692, 24638, 24638).getDimension(), nCols);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final double[] out = CallChecker.varInit(new double[nRows], "out", 695, 24691, 24729);
                for (int row = 0; row < nRows; ++row) {
                    double sum = CallChecker.varInit(((double) (0)), "sum", 697, 24799, 24813);
                    for (int i = 0; i < nCols; ++i) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 699, 24911, 24911)) {
                            sum += (getEntry(row, i)) * (CallChecker.isCalled(v, RealVector.class, 699, 24911, 24911).getEntry(i));
                            CallChecker.varAssign(sum, "sum", 699, 24885, 24924);
                        }
                    }
                    if (CallChecker.beforeDeref(out, double[].class, 701, 24960, 24962)) {
                        CallChecker.isCalled(out, double[].class, 701, 24960, 24962)[row] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 701, 24960, 24962)[row], "CallChecker.isCalled(out, double[].class, 701, 24960, 24962)[row]", 701, 24960, 24974);
                    }
                }
                return new ArrayRealVector(out, false);
            } finally {
                _bcornu_try_context_23.finallyStart(23);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1434.methodEnd();
        }
    }

    public double[] preMultiply(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1435 = new MethodContext(double[].class, 709, 25064, 25671);
        try {
            CallChecker.varInit(this, "this", 709, 25064, 25671);
            CallChecker.varInit(v, "v", 709, 25064, 25671);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 709, 25064, 25671);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 711, 25180, 25215);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 712, 25225, 25263);
            if (CallChecker.beforeDeref(v, double[].class, 713, 25277, 25277)) {
                if ((CallChecker.isCalled(v, double[].class, 713, 25277, 25277).length) != nRows) {
                    if (CallChecker.beforeDeref(v, double[].class, 714, 25347, 25347)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 714, 25347, 25347).length, nRows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[nCols], "out", 717, 25384, 25422);
            for (int col = 0; col < nCols; ++col) {
                double sum = CallChecker.varInit(((double) (0)), "sum", 719, 25484, 25498);
                for (int i = 0; i < nRows; ++i) {
                    if (CallChecker.beforeDeref(v, double[].class, 721, 25588, 25588)) {
                        sum += (getEntry(i, col)) * (CallChecker.isCalled(v, double[].class, 721, 25588, 25588)[i]);
                        CallChecker.varAssign(sum, "sum", 721, 25562, 25592);
                    }
                }
                if (CallChecker.beforeDeref(out, double[].class, 723, 25620, 25622)) {
                    CallChecker.isCalled(out, double[].class, 723, 25620, 25622)[col] = sum;
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 723, 25620, 25622)[col], "CallChecker.isCalled(out, double[].class, 723, 25620, 25622)[col]", 723, 25620, 25634);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1435.methodEnd();
        }
    }

    public RealVector preMultiply(final RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1436 = new MethodContext(RealVector.class, 730, 25678, 26561);
        try {
            CallChecker.varInit(this, "this", 730, 25678, 26561);
            CallChecker.varInit(v, "v", 730, 25678, 26561);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 730, 25678, 26561);
            TryContext _bcornu_try_context_24 = new TryContext(24, AbstractRealMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(v, RealVector.class, 732, 25873, 25873)) {
                    return new ArrayRealVector(preMultiply(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 732, 25873, 25873).getDataRef()), false);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ClassCastException cce) {
                _bcornu_try_context_24.catchStart(24);
                final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 735, 25955, 25990);
                final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 736, 26004, 26042);
                if (CallChecker.beforeDeref(v, RealVector.class, 737, 26060, 26060)) {
                    if ((CallChecker.isCalled(v, RealVector.class, 737, 26060, 26060).getDimension()) != nRows) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 738, 26142, 26142)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(v, RealVector.class, 738, 26142, 26142).getDimension(), nRows);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final double[] out = CallChecker.varInit(new double[nCols], "out", 741, 26195, 26233);
                for (int col = 0; col < nCols; ++col) {
                    double sum = CallChecker.varInit(((double) (0)), "sum", 743, 26303, 26317);
                    for (int i = 0; i < nRows; ++i) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 745, 26415, 26415)) {
                            sum += (getEntry(i, col)) * (CallChecker.isCalled(v, RealVector.class, 745, 26415, 26415).getEntry(i));
                            CallChecker.varAssign(sum, "sum", 745, 26389, 26428);
                        }
                    }
                    if (CallChecker.beforeDeref(out, double[].class, 747, 26464, 26466)) {
                        CallChecker.isCalled(out, double[].class, 747, 26464, 26466)[col] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 747, 26464, 26466)[col], "CallChecker.isCalled(out, double[].class, 747, 26464, 26466)[col]", 747, 26464, 26478);
                    }
                }
                return new ArrayRealVector(out, false);
            } finally {
                _bcornu_try_context_24.finallyStart(24);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1436.methodEnd();
        }
    }

    public double walkInRowOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context1437 = new MethodContext(double.class, 755, 26568, 27187);
        try {
            CallChecker.varInit(this, "this", 755, 26568, 27187);
            CallChecker.varInit(visitor, "visitor", 755, 26568, 27187);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 755, 26568, 27187);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 756, 26673, 26710);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 757, 26720, 26760);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 758, 26770, 26776)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 758, 26770, 26776).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int row = 0; row < rows; ++row) {
                for (int column = 0; column < columns; ++column) {
                    final double oldValue = CallChecker.varInit(((double) (getEntry(row, column))), "oldValue", 761, 26955, 27000);
                    final double newValue = CallChecker.varInit(((double) (CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 762, 27042, 27048).visit(row, column, oldValue))), "newValue", 762, 27018, 27078);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 766, 27168, 27174)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 766, 27168, 27174).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1437.methodEnd();
        }
    }

    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context1438 = new MethodContext(double.class, 770, 27194, 27692);
        try {
            CallChecker.varInit(this, "this", 770, 27194, 27692);
            CallChecker.varInit(visitor, "visitor", 770, 27194, 27692);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 770, 27194, 27692);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 771, 27301, 27338);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 772, 27348, 27388);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 773, 27398, 27404)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 773, 27398, 27404).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int row = 0; row < rows; ++row) {
                for (int column = 0; column < columns; ++column) {
                    if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 776, 27583, 27589)) {
                        CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 776, 27583, 27589).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 779, 27673, 27679)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 779, 27673, 27679).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1438.methodEnd();
        }
    }

    public double walkInRowOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1439 = new MethodContext(double.class, 783, 27699, 28604);
        try {
            CallChecker.varInit(this, "this", 783, 27699, 28604);
            CallChecker.varInit(endColumn, "endColumn", 783, 27699, 28604);
            CallChecker.varInit(startColumn, "startColumn", 783, 27699, 28604);
            CallChecker.varInit(endRow, "endRow", 783, 27699, 28604);
            CallChecker.varInit(startRow, "startRow", 783, 27699, 28604);
            CallChecker.varInit(visitor, "visitor", 783, 27699, 28604);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 783, 27699, 28604);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 788, 28103, 28109)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 788, 28103, 28109).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int row = startRow; row <= endRow; ++row) {
                for (int column = startColumn; column <= endColumn; ++column) {
                    final double oldValue = CallChecker.varInit(((double) (getEntry(row, column))), "oldValue", 792, 28372, 28417);
                    final double newValue = CallChecker.varInit(((double) (CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 793, 28459, 28465).visit(row, column, oldValue))), "newValue", 793, 28435, 28495);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 797, 28585, 28591)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 797, 28585, 28591).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1439.methodEnd();
        }
    }

    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1440 = new MethodContext(double.class, 801, 28611, 29395);
        try {
            CallChecker.varInit(this, "this", 801, 28611, 29395);
            CallChecker.varInit(endColumn, "endColumn", 801, 28611, 29395);
            CallChecker.varInit(startColumn, "startColumn", 801, 28611, 29395);
            CallChecker.varInit(endRow, "endRow", 801, 28611, 29395);
            CallChecker.varInit(startRow, "startRow", 801, 28611, 29395);
            CallChecker.varInit(visitor, "visitor", 801, 28611, 29395);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 801, 28611, 29395);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 806, 29017, 29023)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 806, 29017, 29023).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int row = startRow; row <= endRow; ++row) {
                for (int column = startColumn; column <= endColumn; ++column) {
                    if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 810, 29286, 29292)) {
                        CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 810, 29286, 29292).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 813, 29376, 29382)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 813, 29376, 29382).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1440.methodEnd();
        }
    }

    public double walkInColumnOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context1441 = new MethodContext(double.class, 817, 29402, 30024);
        try {
            CallChecker.varInit(this, "this", 817, 29402, 30024);
            CallChecker.varInit(visitor, "visitor", 817, 29402, 30024);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 817, 29402, 30024);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 818, 29510, 29547);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 819, 29557, 29597);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 820, 29607, 29613)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 820, 29607, 29613).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int column = 0; column < columns; ++column) {
                for (int row = 0; row < rows; ++row) {
                    final double oldValue = CallChecker.varInit(((double) (getEntry(row, column))), "oldValue", 823, 29792, 29837);
                    final double newValue = CallChecker.varInit(((double) (CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 824, 29879, 29885).visit(row, column, oldValue))), "newValue", 824, 29855, 29915);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 828, 30005, 30011)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 828, 30005, 30011).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1441.methodEnd();
        }
    }

    public double walkInColumnOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context1442 = new MethodContext(double.class, 832, 30031, 30532);
        try {
            CallChecker.varInit(this, "this", 832, 30031, 30532);
            CallChecker.varInit(visitor, "visitor", 832, 30031, 30532);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 832, 30031, 30532);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 833, 30141, 30178);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 834, 30188, 30228);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 835, 30238, 30244)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 835, 30238, 30244).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int column = 0; column < columns; ++column) {
                for (int row = 0; row < rows; ++row) {
                    if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 838, 30423, 30429)) {
                        CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 838, 30423, 30429).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 841, 30513, 30519)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 841, 30513, 30519).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1442.methodEnd();
        }
    }

    public double walkInColumnOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1443 = new MethodContext(double.class, 845, 30539, 31453);
        try {
            CallChecker.varInit(this, "this", 845, 30539, 31453);
            CallChecker.varInit(endColumn, "endColumn", 845, 30539, 31453);
            CallChecker.varInit(startColumn, "startColumn", 845, 30539, 31453);
            CallChecker.varInit(endRow, "endRow", 845, 30539, 31453);
            CallChecker.varInit(startRow, "startRow", 845, 30539, 31453);
            CallChecker.varInit(visitor, "visitor", 845, 30539, 31453);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 845, 30539, 31453);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 850, 30952, 30958)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 850, 30952, 30958).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int column = startColumn; column <= endColumn; ++column) {
                for (int row = startRow; row <= endRow; ++row) {
                    final double oldValue = CallChecker.varInit(((double) (getEntry(row, column))), "oldValue", 854, 31221, 31266);
                    final double newValue = CallChecker.varInit(((double) (CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 855, 31308, 31314).visit(row, column, oldValue))), "newValue", 855, 31284, 31344);
                    setEntry(row, column, newValue);
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 859, 31434, 31440)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 859, 31434, 31440).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1443.methodEnd();
        }
    }

    public double walkInColumnOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1444 = new MethodContext(double.class, 863, 31460, 32253);
        try {
            CallChecker.varInit(this, "this", 863, 31460, 32253);
            CallChecker.varInit(endColumn, "endColumn", 863, 31460, 32253);
            CallChecker.varInit(startColumn, "startColumn", 863, 31460, 32253);
            CallChecker.varInit(endRow, "endRow", 863, 31460, 32253);
            CallChecker.varInit(startRow, "startRow", 863, 31460, 32253);
            CallChecker.varInit(visitor, "visitor", 863, 31460, 32253);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 863, 31460, 32253);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 868, 31875, 31881)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 868, 31875, 31881).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int column = startColumn; column <= endColumn; ++column) {
                for (int row = startRow; row <= endRow; ++row) {
                    if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 872, 32144, 32150)) {
                        CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 872, 32144, 32150).visit(row, column, getEntry(row, column));
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 875, 32234, 32240)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 875, 32234, 32240).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1444.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context1445 = new MethodContext(double.class, 879, 32260, 32407);
        try {
            CallChecker.varInit(this, "this", 879, 32260, 32407);
            CallChecker.varInit(visitor, "visitor", 879, 32260, 32407);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 879, 32260, 32407);
            return walkInRowOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1445.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context1446 = new MethodContext(double.class, 884, 32414, 32563);
        try {
            CallChecker.varInit(this, "this", 884, 32414, 32563);
            CallChecker.varInit(visitor, "visitor", 884, 32414, 32563);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 884, 32414, 32563);
            return walkInRowOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1446.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1447 = new MethodContext(double.class, 889, 32570, 33020);
        try {
            CallChecker.varInit(this, "this", 889, 32570, 33020);
            CallChecker.varInit(endColumn, "endColumn", 889, 32570, 33020);
            CallChecker.varInit(startColumn, "startColumn", 889, 32570, 33020);
            CallChecker.varInit(endRow, "endRow", 889, 32570, 33020);
            CallChecker.varInit(startRow, "startRow", 889, 32570, 33020);
            CallChecker.varInit(visitor, "visitor", 889, 32570, 33020);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 889, 32570, 33020);
            return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1447.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1448 = new MethodContext(double.class, 898, 33027, 33479);
        try {
            CallChecker.varInit(this, "this", 898, 33027, 33479);
            CallChecker.varInit(endColumn, "endColumn", 898, 33027, 33479);
            CallChecker.varInit(startColumn, "startColumn", 898, 33027, 33479);
            CallChecker.varInit(endRow, "endRow", 898, 33027, 33479);
            CallChecker.varInit(startRow, "startRow", 898, 33027, 33479);
            CallChecker.varInit(visitor, "visitor", 898, 33027, 33479);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 898, 33027, 33479);
            return walkInRowOrder(visitor, startRow, endRow, startColumn, endColumn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1448.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1449 = new MethodContext(String.class, 911, 33486, 33971);
        try {
            CallChecker.varInit(this, "this", 911, 33486, 33971);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 911, 33486, 33971);
            final StringBuilder res = CallChecker.varInit(new StringBuilder(), "res", 912, 33658, 33703);
            String fullClassName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(getClass(), Class.class, 913, 33736, 33745)) {
                fullClassName = CallChecker.isCalled(getClass(), Class.class, 913, 33736, 33745).getName();
                CallChecker.varAssign(fullClassName, "fullClassName", 913, 33736, 33745);
            }
            String shortClassName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(fullClassName, String.class, 914, 33814, 33826)) {
                if (CallChecker.beforeDeref(fullClassName, String.class, 914, 33790, 33802)) {
                    fullClassName = CallChecker.beforeCalled(fullClassName, String.class, 914, 33814, 33826);
                    fullClassName = CallChecker.beforeCalled(fullClassName, String.class, 914, 33790, 33802);
                    shortClassName = CallChecker.isCalled(fullClassName, String.class, 914, 33790, 33802).substring(((CallChecker.isCalled(fullClassName, String.class, 914, 33814, 33826).lastIndexOf('.')) + 1));
                    CallChecker.varAssign(shortClassName, "shortClassName", 914, 33814, 33826);
                }
            }
            if (CallChecker.beforeDeref(res, StringBuilder.class, 915, 33859, 33861)) {
                CallChecker.isCalled(res, StringBuilder.class, 915, 33859, 33861).append(shortClassName);
            }
            if (CallChecker.beforeDeref(AbstractRealMatrix.DEFAULT_FORMAT, RealMatrixFormat.class, 916, 33906, 33919)) {
                if (CallChecker.beforeDeref(res, StringBuilder.class, 916, 33895, 33897)) {
                    CallChecker.isCalled(res, StringBuilder.class, 916, 33895, 33897).append(CallChecker.isCalled(AbstractRealMatrix.DEFAULT_FORMAT, RealMatrixFormat.class, 916, 33906, 33919).format(this));
                }
            }
            if (CallChecker.beforeDeref(res, StringBuilder.class, 917, 33951, 33953)) {
                return CallChecker.isCalled(res, StringBuilder.class, 917, 33951, 33953).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1449.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object object) {
        MethodContext _bcornu_methode_context1450 = new MethodContext(boolean.class, 929, 33978, 35011);
        try {
            CallChecker.varInit(this, "this", 929, 33978, 35011);
            CallChecker.varInit(object, "object", 929, 33978, 35011);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 929, 33978, 35011);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof RealMatrix) == false) {
                return false;
            }
            RealMatrix m = CallChecker.varInit(((RealMatrix) (object)), "m", 936, 34500, 34534);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 937, 34544, 34579);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 938, 34589, 34627);
            if (CallChecker.beforeDeref(m, RealMatrix.class, 939, 34641, 34641)) {
                if (CallChecker.beforeDeref(m, RealMatrix.class, 939, 34676, 34676)) {
                    m = CallChecker.beforeCalled(m, RealMatrix.class, 939, 34641, 34641);
                    m = CallChecker.beforeCalled(m, RealMatrix.class, 939, 34676, 34676);
                    if (((CallChecker.isCalled(m, RealMatrix.class, 939, 34641, 34641).getColumnDimension()) != nCols) || ((CallChecker.isCalled(m, RealMatrix.class, 939, 34676, 34676).getRowDimension()) != nRows)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    if (CallChecker.beforeDeref(m, RealMatrix.class, 944, 34886, 34886)) {
                        m = CallChecker.beforeCalled(m, RealMatrix.class, 944, 34886, 34886);
                        if ((getEntry(row, col)) != (CallChecker.isCalled(m, RealMatrix.class, 944, 34886, 34886).getEntry(row, col))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1450.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1451 = new MethodContext(int.class, 958, 35018, 35601);
        try {
            CallChecker.varInit(this, "this", 958, 35018, 35601);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.AbstractRealMatrix.DEFAULT_FORMAT", 958, 35018, 35601);
            int ret = CallChecker.varInit(((int) (7)), "ret", 959, 35165, 35176);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 960, 35186, 35221);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 961, 35231, 35269);
            ret = (ret * 31) + nRows;
            CallChecker.varAssign(ret, "ret", 962, 35279, 35301);
            ret = (ret * 31) + nCols;
            CallChecker.varAssign(ret, "ret", 963, 35311, 35333);
            for (int row = 0; row < nRows; ++row) {
                for (int col = 0; col < nCols; ++col) {
                    ret = (ret * 31) + (((11 * (row + 1)) + (17 * (col + 1))) * (MathUtils.hash(getEntry(row, col))));
                    CallChecker.varAssign(ret, "ret", 966, 35450, 35552);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1451.methodEnd();
        }
    }

    public abstract RealMatrix createMatrix(int rowDimension, int columnDimension) throws NotStrictlyPositiveException;

    public abstract RealMatrix copy();

    public abstract double getEntry(int row, int column) throws OutOfRangeException;

    public abstract void setEntry(int row, int column, double value) throws OutOfRangeException;
}

