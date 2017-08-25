package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

public class Array2DRowRealMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;

    private double[][] data;

    public Array2DRowRealMatrix() {
        ConstructorContext _bcornu_methode_context879 = new ConstructorContext(Array2DRowRealMatrix.class, 48, 1851, 1935);
        try {
        } finally {
            _bcornu_methode_context879.methodEnd();
        }
    }

    public Array2DRowRealMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        super(rowDimension, columnDimension);
        ConstructorContext _bcornu_methode_context880 = new ConstructorContext(Array2DRowRealMatrix.class, 58, 1942, 2533);
        try {
            data = new double[rowDimension][columnDimension];
            CallChecker.varAssign(this.data, "this.data", 62, 2479, 2527);
        } finally {
            _bcornu_methode_context880.methodEnd();
        }
    }

    public Array2DRowRealMatrix(final double[][] d) throws DimensionMismatchException, NoDataException, NullArgumentException {
        ConstructorContext _bcornu_methode_context881 = new ConstructorContext(Array2DRowRealMatrix.class, 78, 2540, 3347);
        try {
            copyIn(d);
        } finally {
            _bcornu_methode_context881.methodEnd();
        }
    }

    public Array2DRowRealMatrix(final double[][] d, final boolean copyArray) throws DimensionMismatchException, NoDataException, NullArgumentException {
        ConstructorContext _bcornu_methode_context882 = new ConstructorContext(Array2DRowRealMatrix.class, 99, 3354, 5057);
        try {
            if (copyArray) {
                copyIn(d);
            }else {
                if (d == null) {
                    throw new NullArgumentException();
                }
                final int nRows = CallChecker.varInit(((int) (d.length)), "nRows", 108, 4503, 4529);
                if (nRows == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
                }
                d[0] = CallChecker.beforeCalled(d[0], double[].class, 112, 4683, 4686);
                final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(d[0], double[].class, 112, 4683, 4686).length)), "nCols", 112, 4665, 4694);
                if (nCols == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
                for (int r = 1; r < nRows; r++) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 117, 4887, 4887)[r], double[].class, 117, 4887, 4890)) {
                        d[r] = CallChecker.beforeCalled(d[r], double[].class, 117, 4887, 4890);
                        if ((CallChecker.isCalled(d[r], double[].class, 117, 4887, 4890).length) != nCols) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(d, double[][].class, 118, 4968, 4968)[r], double[].class, 118, 4968, 4971)) {
                                d[r] = CallChecker.beforeCalled(d[r], double[].class, 118, 4968, 4971);
                                throw new DimensionMismatchException(CallChecker.isCalled(d[r], double[].class, 118, 4968, 4971).length, nCols);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                data = d;
                CallChecker.varAssign(this.data, "this.data", 121, 5033, 5041);
            }
        } finally {
            _bcornu_methode_context882.methodEnd();
        }
    }

    public Array2DRowRealMatrix(final double[] v) {
        ConstructorContext _bcornu_methode_context883 = new ConstructorContext(Array2DRowRealMatrix.class, 132, 5064, 5518);
        try {
            final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(v, double[].class, 133, 5374, 5374).length)), "nRows", 133, 5356, 5382);
            data = new double[nRows][1];
            CallChecker.varAssign(this.data, "this.data", 134, 5392, 5419);
            for (int row = 0; row < nRows; row++) {
                if (CallChecker.beforeDeref(data, double[][].class, 136, 5481, 5484)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 136, 5481, 5484);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 136, 5481, 5484)[row], double[].class, 136, 5481, 5489)) {
                        if (CallChecker.beforeDeref(v, double[].class, 136, 5496, 5496)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 136, 5481, 5484);
                            CallChecker.isCalled(data, double[][].class, 136, 5481, 5484)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 136, 5481, 5484)[row], double[].class, 136, 5481, 5489);
                            CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 136, 5481, 5484)[row], double[].class, 136, 5481, 5489)[0] = CallChecker.isCalled(v, double[].class, 136, 5496, 5496)[row];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 136, 5481, 5484)[row], double[].class, 136, 5481, 5489)[0], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 136, 5481, 5484)[row], double[].class, 136, 5481, 5489)[0]", 136, 5481, 5502);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context883.methodEnd();
        }
    }

    @Override
    public RealMatrix createMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3918 = new MethodContext(RealMatrix.class, 142, 5525, 5803);
        try {
            CallChecker.varInit(this, "this", 142, 5525, 5803);
            CallChecker.varInit(columnDimension, "columnDimension", 142, 5525, 5803);
            CallChecker.varInit(rowDimension, "rowDimension", 142, 5525, 5803);
            CallChecker.varInit(this.data, "data", 142, 5525, 5803);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 142, 5525, 5803);
            return new Array2DRowRealMatrix(rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3918.methodEnd();
        }
    }

    @Override
    public RealMatrix copy() {
        MethodContext _bcornu_methode_context3919 = new MethodContext(RealMatrix.class, 150, 5810, 5939);
        try {
            CallChecker.varInit(this, "this", 150, 5810, 5939);
            CallChecker.varInit(this.data, "data", 150, 5810, 5939);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 150, 5810, 5939);
            return new Array2DRowRealMatrix(copyOut(), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3919.methodEnd();
        }
    }

    public Array2DRowRealMatrix add(final Array2DRowRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3920 = new MethodContext(Array2DRowRealMatrix.class, 162, 5946, 6978);
        try {
            CallChecker.varInit(this, "this", 162, 5946, 6978);
            CallChecker.varInit(m, "m", 162, 5946, 6978);
            CallChecker.varInit(this.data, "data", 162, 5946, 6978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 162, 5946, 6978);
            MatrixUtils.checkAdditionCompatible(this, m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 167, 6398, 6439);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 168, 6449, 6493);
            final double[][] outData = CallChecker.varInit(new double[rowCount][columnCount], "outData", 169, 6503, 6563);
            for (int row = 0; row < rowCount; row++) {
                data = CallChecker.beforeCalled(data, double[][].class, 171, 6656, 6659);
                final double[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 171, 6656, 6659)[row], "dataRow", 171, 6628, 6665);
                CallChecker.isCalled(m, Array2DRowRealMatrix.class, 172, 6707, 6707).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowRealMatrix.class, 172, 6707, 6707).data, double[][].class, 172, 6707, 6712);
                final double[] mRow = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowRealMatrix.class, 172, 6707, 6707).data, double[][].class, 172, 6707, 6712)[row], "mRow", 172, 6679, 6718);
                final double[] outDataRow = CallChecker.varInit(CallChecker.isCalled(outData, double[][].class, 173, 6760, 6766)[row], "outDataRow", 173, 6732, 6772);
                for (int col = 0; col < columnCount; col++) {
                    if (CallChecker.beforeDeref(outDataRow, double[].class, 175, 6848, 6857)) {
                        if (CallChecker.beforeDeref(dataRow, double[].class, 175, 6866, 6872)) {
                            if (CallChecker.beforeDeref(mRow, double[].class, 175, 6881, 6884)) {
                                CallChecker.isCalled(outDataRow, double[].class, 175, 6848, 6857)[col] = (CallChecker.isCalled(dataRow, double[].class, 175, 6866, 6872)[col]) + (CallChecker.isCalled(mRow, double[].class, 175, 6881, 6884)[col]);
                                CallChecker.varAssign(CallChecker.isCalled(outDataRow, double[].class, 175, 6848, 6857)[col], "CallChecker.isCalled(outDataRow, double[].class, 175, 6848, 6857)[col]", 175, 6848, 6890);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3920.methodEnd();
        }
    }

    public Array2DRowRealMatrix subtract(final Array2DRowRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3921 = new MethodContext(Array2DRowRealMatrix.class, 190, 6985, 7995);
        try {
            CallChecker.varInit(this, "this", 190, 6985, 7995);
            CallChecker.varInit(m, "m", 190, 6985, 7995);
            CallChecker.varInit(this.data, "data", 190, 6985, 7995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 190, 6985, 7995);
            MatrixUtils.checkSubtractionCompatible(this, m);
            final int rowCount = CallChecker.varInit(((int) (getRowDimension())), "rowCount", 194, 7415, 7456);
            final int columnCount = CallChecker.varInit(((int) (getColumnDimension())), "columnCount", 195, 7466, 7510);
            final double[][] outData = CallChecker.varInit(new double[rowCount][columnCount], "outData", 196, 7520, 7580);
            for (int row = 0; row < rowCount; row++) {
                data = CallChecker.beforeCalled(data, double[][].class, 198, 7673, 7676);
                final double[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 198, 7673, 7676)[row], "dataRow", 198, 7645, 7682);
                CallChecker.isCalled(m, Array2DRowRealMatrix.class, 199, 7724, 7724).data = CallChecker.beforeCalled(CallChecker.isCalled(m, Array2DRowRealMatrix.class, 199, 7724, 7724).data, double[][].class, 199, 7724, 7729);
                final double[] mRow = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, Array2DRowRealMatrix.class, 199, 7724, 7724).data, double[][].class, 199, 7724, 7729)[row], "mRow", 199, 7696, 7735);
                final double[] outDataRow = CallChecker.varInit(CallChecker.isCalled(outData, double[][].class, 200, 7777, 7783)[row], "outDataRow", 200, 7749, 7789);
                for (int col = 0; col < columnCount; col++) {
                    if (CallChecker.beforeDeref(outDataRow, double[].class, 202, 7865, 7874)) {
                        if (CallChecker.beforeDeref(dataRow, double[].class, 202, 7883, 7889)) {
                            if (CallChecker.beforeDeref(mRow, double[].class, 202, 7898, 7901)) {
                                CallChecker.isCalled(outDataRow, double[].class, 202, 7865, 7874)[col] = (CallChecker.isCalled(dataRow, double[].class, 202, 7883, 7889)[col]) - (CallChecker.isCalled(mRow, double[].class, 202, 7898, 7901)[col]);
                                CallChecker.varAssign(CallChecker.isCalled(outDataRow, double[].class, 202, 7865, 7874)[col], "CallChecker.isCalled(outDataRow, double[].class, 202, 7865, 7874)[col]", 202, 7865, 7907);
                            }
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3921.methodEnd();
        }
    }

    public Array2DRowRealMatrix multiply(final Array2DRowRealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3922 = new MethodContext(Array2DRowRealMatrix.class, 217, 8002, 9459);
        try {
            CallChecker.varInit(this, "this", 217, 8002, 9459);
            CallChecker.varInit(m, "m", 217, 8002, 9459);
            CallChecker.varInit(this.data, "data", 217, 8002, 9459);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 217, 8002, 9459);
            MatrixUtils.checkMultiplicationCompatible(this, m);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 221, 8452, 8492);
            final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, Array2DRowRealMatrix.class, 222, 8520, 8520).getColumnDimension())), "nCols", 222, 8502, 8542);
            final int nSum = CallChecker.varInit(((int) (this.getColumnDimension())), "nSum", 223, 8552, 8594);
            final double[][] outData = CallChecker.varInit(new double[nRows][nCols], "outData", 225, 8605, 8656);
            final double[] mCol = CallChecker.varInit(new double[nSum], "mCol", 227, 8704, 8742);
            final double[][] mData = CallChecker.varInit(CallChecker.isCalled(m, Array2DRowRealMatrix.class, 228, 8777, 8777).data, "mData", 228, 8752, 8783);
            for (int col = 0; col < nCols; col++) {
                for (int mRow = 0; mRow < nSum; mRow++) {
                    if (CallChecker.beforeDeref(mCol, double[].class, 235, 9034, 9037)) {
                        if (CallChecker.beforeDeref(mData, double[][].class, 235, 9047, 9051)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(mData, double[][].class, 235, 9047, 9051)[mRow], double[].class, 235, 9047, 9057)) {
                                CallChecker.isCalled(mData, double[][].class, 235, 9047, 9051)[mRow] = CallChecker.beforeCalled(CallChecker.isCalled(mData, double[][].class, 235, 9047, 9051)[mRow], double[].class, 235, 9047, 9057);
                                CallChecker.isCalled(mCol, double[].class, 235, 9034, 9037)[mRow] = CallChecker.isCalled(CallChecker.isCalled(mData, double[][].class, 235, 9047, 9051)[mRow], double[].class, 235, 9047, 9057)[col];
                                CallChecker.varAssign(CallChecker.isCalled(mCol, double[].class, 235, 9034, 9037)[mRow], "CallChecker.isCalled(mCol, double[].class, 235, 9034, 9037)[mRow]", 235, 9034, 9063);
                            }
                        }
                    }
                }
                for (int row = 0; row < nRows; row++) {
                    data = CallChecker.beforeCalled(data, double[][].class, 239, 9173, 9176);
                    final double[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 239, 9173, 9176)[row], "dataRow", 239, 9148, 9182);
                    double sum = CallChecker.varInit(((double) (0)), "sum", 240, 9200, 9214);
                    for (int i = 0; i < nSum; i++) {
                        if (CallChecker.beforeDeref(dataRow, double[].class, 242, 9292, 9298)) {
                            if (CallChecker.beforeDeref(mCol, double[].class, 242, 9305, 9308)) {
                                sum += (CallChecker.isCalled(dataRow, double[].class, 242, 9292, 9298)[i]) * (CallChecker.isCalled(mCol, double[].class, 242, 9305, 9308)[i]);
                                CallChecker.varAssign(sum, "sum", 242, 9285, 9312);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(outData, double[][].class, 244, 9348, 9354)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row], double[].class, 244, 9348, 9359)) {
                            CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row] = CallChecker.beforeCalled(CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row], double[].class, 244, 9348, 9359);
                            CallChecker.isCalled(CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row], double[].class, 244, 9348, 9359)[col] = sum;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row], double[].class, 244, 9348, 9359)[col], "CallChecker.isCalled(CallChecker.isCalled(outData, double[][].class, 244, 9348, 9354)[row], double[].class, 244, 9348, 9359)[col]", 244, 9348, 9371);
                        }
                    }
                }
            }
            return new Array2DRowRealMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3922.methodEnd();
        }
    }

    @Override
    public double[][] getData() {
        MethodContext _bcornu_methode_context3923 = new MethodContext(double[][].class, 253, 9466, 9565);
        try {
            CallChecker.varInit(this, "this", 253, 9466, 9565);
            CallChecker.varInit(this.data, "data", 253, 9466, 9565);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 253, 9466, 9565);
            return copyOut();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3923.methodEnd();
        }
    }

    public double[][] getDataRef() {
        MethodContext _bcornu_methode_context3924 = new MethodContext(double[][].class, 262, 9572, 9753);
        try {
            CallChecker.varInit(this, "this", 262, 9572, 9753);
            CallChecker.varInit(this.data, "data", 262, 9572, 9753);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 262, 9572, 9753);
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3924.methodEnd();
        }
    }

    @Override
    public void setSubMatrix(final double[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context3925 = new MethodContext(void.class, 268, 9760, 11201);
        try {
            CallChecker.varInit(this, "this", 268, 9760, 11201);
            CallChecker.varInit(column, "column", 268, 9760, 11201);
            CallChecker.varInit(row, "row", 268, 9760, 11201);
            CallChecker.varInit(subMatrix, "subMatrix", 268, 9760, 11201);
            CallChecker.varInit(this.data, "data", 268, 9760, 11201);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 268, 9760, 11201);
            if ((data) == null) {
                if (row > 0) {
                    throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, row);
                }
                if (column > 0) {
                    throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, column);
                }
                MathUtils.checkNotNull(subMatrix);
                final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(subMatrix, double[][].class, 280, 10437, 10445).length)), "nRows", 280, 10419, 10453);
                if (nRows == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
                }
                CallChecker.isCalled(subMatrix, double[][].class, 285, 10608, 10616)[0] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 285, 10608, 10616)[0], double[].class, 285, 10608, 10619);
                final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 285, 10608, 10616)[0], double[].class, 285, 10608, 10619).length)), "nCols", 285, 10590, 10627);
                if (nCols == 0) {
                    throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
                }
                if (CallChecker.beforeDeref(subMatrix, double[][].class, 289, 10784, 10792)) {
                    data = new double[CallChecker.isCalled(subMatrix, double[][].class, 289, 10784, 10792).length][nCols];
                    CallChecker.varAssign(this.data, "this.data", 289, 10766, 10808);
                }
                data = CallChecker.beforeCalled(data, double[][].class, 290, 10842, 10845);
                for (int i = 0; i < (CallChecker.isCalled(data, double[][].class, 290, 10842, 10845).length); ++i) {
                    if (CallChecker.beforeDeref(subMatrix, double[][].class, 291, 10882, 10890)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, double[][].class, 291, 10882, 10890)[i], double[].class, 291, 10882, 10893)) {
                            CallChecker.isCalled(subMatrix, double[][].class, 291, 10882, 10890)[i] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 291, 10882, 10890)[i], double[].class, 291, 10882, 10893);
                            if ((CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 291, 10882, 10890)[i], double[].class, 291, 10882, 10893).length) != nCols) {
                                if (CallChecker.beforeDeref(subMatrix, double[][].class, 292, 10971, 10979)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(subMatrix, double[][].class, 292, 10971, 10979)[i], double[].class, 292, 10971, 10982)) {
                                        CallChecker.isCalled(subMatrix, double[][].class, 292, 10971, 10979)[i] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 292, 10971, 10979)[i], double[].class, 292, 10971, 10982);
                                        throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 292, 10971, 10979)[i], double[].class, 292, 10971, 10982).length, nCols);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(subMatrix, double[][].class, 294, 11051, 11059)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 294, 11068, 11071)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 294, 11068, 11071);
                            System.arraycopy(CallChecker.isCalled(subMatrix, double[][].class, 294, 11051, 11059)[i], 0, CallChecker.isCalled(data, double[][].class, 294, 11068, 11071)[(i + row)], column, nCols);
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
            _bcornu_methode_context3925.methodEnd();
        }
    }

    @Override
    public double getEntry(final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3926 = new MethodContext(double.class, 304, 11208, 11435);
        try {
            CallChecker.varInit(this, "this", 304, 11208, 11435);
            CallChecker.varInit(column, "column", 304, 11208, 11435);
            CallChecker.varInit(row, "row", 304, 11208, 11435);
            CallChecker.varInit(this.data, "data", 304, 11208, 11435);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 304, 11208, 11435);
            MatrixUtils.checkMatrixIndex(this, row, column);
            if (CallChecker.beforeDeref(data, double[][].class, 307, 11412, 11415)) {
                data = CallChecker.beforeCalled(data, double[][].class, 307, 11412, 11415);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 307, 11412, 11415)[row], double[].class, 307, 11412, 11420)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 307, 11412, 11415);
                    CallChecker.isCalled(data, double[][].class, 307, 11412, 11415)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 307, 11412, 11415)[row], double[].class, 307, 11412, 11420);
                    return CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 307, 11412, 11415)[row], double[].class, 307, 11412, 11420)[column];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3926.methodEnd();
        }
    }

    @Override
    public void setEntry(final int row, final int column, final double value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3927 = new MethodContext(void.class, 312, 11442, 11688);
        try {
            CallChecker.varInit(this, "this", 312, 11442, 11688);
            CallChecker.varInit(value, "value", 312, 11442, 11688);
            CallChecker.varInit(column, "column", 312, 11442, 11688);
            CallChecker.varInit(row, "row", 312, 11442, 11688);
            CallChecker.varInit(this.data, "data", 312, 11442, 11688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 312, 11442, 11688);
            MatrixUtils.checkMatrixIndex(this, row, column);
            if (CallChecker.beforeDeref(data, double[][].class, 315, 11657, 11660)) {
                data = CallChecker.beforeCalled(data, double[][].class, 315, 11657, 11660);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 315, 11657, 11660)[row], double[].class, 315, 11657, 11665)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 315, 11657, 11660);
                    CallChecker.isCalled(data, double[][].class, 315, 11657, 11660)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 315, 11657, 11660)[row], double[].class, 315, 11657, 11665);
                    CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 315, 11657, 11660)[row], double[].class, 315, 11657, 11665)[column] = value;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 315, 11657, 11660)[row], double[].class, 315, 11657, 11665)[column], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 315, 11657, 11660)[row], double[].class, 315, 11657, 11665)[column]", 315, 11657, 11682);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3927.methodEnd();
        }
    }

    @Override
    public void addToEntry(final int row, final int column, final double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3928 = new MethodContext(void.class, 320, 11695, 11979);
        try {
            CallChecker.varInit(this, "this", 320, 11695, 11979);
            CallChecker.varInit(increment, "increment", 320, 11695, 11979);
            CallChecker.varInit(column, "column", 320, 11695, 11979);
            CallChecker.varInit(row, "row", 320, 11695, 11979);
            CallChecker.varInit(this.data, "data", 320, 11695, 11979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 320, 11695, 11979);
            MatrixUtils.checkMatrixIndex(this, row, column);
            if (CallChecker.beforeDeref(data, double[][].class, 324, 11943, 11946)) {
                data = CallChecker.beforeCalled(data, double[][].class, 324, 11943, 11946);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 324, 11943, 11946)[row], double[].class, 324, 11943, 11951)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 324, 11943, 11946);
                    CallChecker.isCalled(data, double[][].class, 324, 11943, 11946)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 324, 11943, 11946)[row], double[].class, 324, 11943, 11951);
                    CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 324, 11943, 11946)[row], double[].class, 324, 11943, 11951)[column] += increment;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 324, 11943, 11946)[row], double[].class, 324, 11943, 11951)[column], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 324, 11943, 11946)[row], double[].class, 324, 11943, 11951)[column]", 324, 11943, 11973);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3928.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(final int row, final int column, final double factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3929 = new MethodContext(void.class, 329, 11986, 12270);
        try {
            CallChecker.varInit(this, "this", 329, 11986, 12270);
            CallChecker.varInit(factor, "factor", 329, 11986, 12270);
            CallChecker.varInit(column, "column", 329, 11986, 12270);
            CallChecker.varInit(row, "row", 329, 11986, 12270);
            CallChecker.varInit(this.data, "data", 329, 11986, 12270);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 329, 11986, 12270);
            MatrixUtils.checkMatrixIndex(this, row, column);
            if (CallChecker.beforeDeref(data, double[][].class, 333, 12237, 12240)) {
                data = CallChecker.beforeCalled(data, double[][].class, 333, 12237, 12240);
                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 333, 12237, 12240)[row], double[].class, 333, 12237, 12245)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 333, 12237, 12240);
                    CallChecker.isCalled(data, double[][].class, 333, 12237, 12240)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 333, 12237, 12240)[row], double[].class, 333, 12237, 12245);
                    CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 333, 12237, 12240)[row], double[].class, 333, 12237, 12245)[column] *= factor;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 333, 12237, 12240)[row], double[].class, 333, 12237, 12245)[column], "CallChecker.isCalled(CallChecker.isCalled(this.data, double[][].class, 333, 12237, 12240)[row], double[].class, 333, 12237, 12245)[column]", 333, 12237, 12264);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3929.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context3930 = new MethodContext(int.class, 338, 12277, 12400);
        try {
            CallChecker.varInit(this, "this", 338, 12277, 12400);
            CallChecker.varInit(this.data, "data", 338, 12277, 12400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 338, 12277, 12400);
            if ((data) == null) {
                return 0;
            }else {
                return data.length;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3930.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context3931 = new MethodContext(int.class, 344, 12407, 12559);
        try {
            CallChecker.varInit(this, "this", 344, 12407, 12559);
            CallChecker.varInit(this.data, "data", 344, 12407, 12559);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 344, 12407, 12559);
            if (((data) == null) || ((data[0]) == null)) {
                return 0;
            }else {
                return data[0].length;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3931.methodEnd();
        }
    }

    @Override
    public double[] operate(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3932 = new MethodContext(double[].class, 350, 12566, 13240);
        try {
            CallChecker.varInit(this, "this", 350, 12566, 13240);
            CallChecker.varInit(v, "v", 350, 12566, 13240);
            CallChecker.varInit(this.data, "data", 350, 12566, 13240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 350, 12566, 13240);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 352, 12699, 12739);
            final int nCols = CallChecker.varInit(((int) (this.getColumnDimension())), "nCols", 353, 12749, 12792);
            if (CallChecker.beforeDeref(v, double[].class, 354, 12806, 12806)) {
                if ((CallChecker.isCalled(v, double[].class, 354, 12806, 12806).length) != nCols) {
                    if (CallChecker.beforeDeref(v, double[].class, 355, 12876, 12876)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 355, 12876, 12876).length, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[nRows], "out", 357, 12912, 12950);
            for (int row = 0; row < nRows; row++) {
                data = CallChecker.beforeCalled(data, double[][].class, 359, 13037, 13040);
                final double[] dataRow = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 359, 13037, 13040)[row], "dataRow", 359, 13012, 13046);
                double sum = CallChecker.varInit(((double) (0)), "sum", 360, 13060, 13074);
                for (int i = 0; i < nCols; i++) {
                    if (CallChecker.beforeDeref(dataRow, double[].class, 362, 13145, 13151)) {
                        if (CallChecker.beforeDeref(v, double[].class, 362, 13158, 13158)) {
                            sum += (CallChecker.isCalled(dataRow, double[].class, 362, 13145, 13151)[i]) * (CallChecker.isCalled(v, double[].class, 362, 13158, 13158)[i]);
                            CallChecker.varAssign(sum, "sum", 362, 13138, 13162);
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, double[].class, 364, 13190, 13192)) {
                    CallChecker.isCalled(out, double[].class, 364, 13190, 13192)[row] = sum;
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 364, 13190, 13192)[row], "CallChecker.isCalled(out, double[].class, 364, 13190, 13192)[row]", 364, 13190, 13204);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3932.methodEnd();
        }
    }

    @Override
    public double[] preMultiply(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3933 = new MethodContext(double[].class, 371, 13247, 13872);
        try {
            CallChecker.varInit(this, "this", 371, 13247, 13872);
            CallChecker.varInit(v, "v", 371, 13247, 13872);
            CallChecker.varInit(this.data, "data", 371, 13247, 13872);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 371, 13247, 13872);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 373, 13384, 13419);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 374, 13429, 13467);
            if (CallChecker.beforeDeref(v, double[].class, 375, 13481, 13481)) {
                if ((CallChecker.isCalled(v, double[].class, 375, 13481, 13481).length) != nRows) {
                    if (CallChecker.beforeDeref(v, double[].class, 376, 13551, 13551)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 376, 13551, 13551).length, nRows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[nCols], "out", 379, 13588, 13626);
            for (int col = 0; col < nCols; ++col) {
                double sum = CallChecker.varInit(((double) (0)), "sum", 381, 13688, 13702);
                for (int i = 0; i < nRows; ++i) {
                    if (CallChecker.beforeDeref(data, double[][].class, 383, 13773, 13776)) {
                        data = CallChecker.beforeCalled(data, double[][].class, 383, 13773, 13776);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 383, 13773, 13776)[i], double[].class, 383, 13773, 13779)) {
                            if (CallChecker.beforeDeref(v, double[].class, 383, 13788, 13788)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 383, 13773, 13776);
                                CallChecker.isCalled(data, double[][].class, 383, 13773, 13776)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 383, 13773, 13776)[i], double[].class, 383, 13773, 13779);
                                sum += (CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 383, 13773, 13776)[i], double[].class, 383, 13773, 13779)[col]) * (CallChecker.isCalled(v, double[].class, 383, 13788, 13788)[i]);
                                CallChecker.varAssign(sum, "sum", 383, 13766, 13792);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(out, double[].class, 385, 13820, 13822)) {
                    CallChecker.isCalled(out, double[].class, 385, 13820, 13822)[col] = sum;
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 385, 13820, 13822)[col], "CallChecker.isCalled(out, double[].class, 385, 13820, 13822)[col]", 385, 13820, 13834);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3933.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context3934 = new MethodContext(double.class, 394, 13879, 14400);
        try {
            CallChecker.varInit(this, "this", 394, 13879, 14400);
            CallChecker.varInit(visitor, "visitor", 394, 13879, 14400);
            CallChecker.varInit(this.data, "data", 394, 13879, 14400);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 394, 13879, 14400);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 395, 13998, 14035);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 396, 14045, 14085);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 397, 14095, 14101)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 397, 14095, 14101).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int i = 0; i < rows; ++i) {
                data = CallChecker.beforeCalled(data, double[][].class, 399, 14229, 14232);
                final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 399, 14229, 14232)[i], "rowI", 399, 14207, 14236);
                for (int j = 0; j < columns; ++j) {
                    if (CallChecker.beforeDeref(rowI, double[].class, 401, 14302, 14305)) {
                        if (CallChecker.beforeDeref(rowI, double[].class, 401, 14332, 14335)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 401, 14312, 14318)) {
                                CallChecker.isCalled(rowI, double[].class, 401, 14302, 14305)[j] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 401, 14312, 14318).visit(i, j, CallChecker.isCalled(rowI, double[].class, 401, 14332, 14335)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(rowI, double[].class, 401, 14302, 14305)[j], "CallChecker.isCalled(rowI, double[].class, 401, 14302, 14305)[j]", 401, 14302, 14340);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 404, 14381, 14387)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 404, 14381, 14387).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3934.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context3935 = new MethodContext(double.class, 409, 14407, 14920);
        try {
            CallChecker.varInit(this, "this", 409, 14407, 14920);
            CallChecker.varInit(visitor, "visitor", 409, 14407, 14920);
            CallChecker.varInit(this.data, "data", 409, 14407, 14920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 409, 14407, 14920);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 410, 14528, 14565);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 411, 14575, 14615);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 412, 14625, 14631)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 412, 14625, 14631).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int i = 0; i < rows; ++i) {
                data = CallChecker.beforeCalled(data, double[][].class, 414, 14759, 14762);
                final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 414, 14759, 14762)[i], "rowI", 414, 14737, 14766);
                for (int j = 0; j < columns; ++j) {
                    if (CallChecker.beforeDeref(rowI, double[].class, 416, 14852, 14855)) {
                        if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 416, 14832, 14838)) {
                            CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 416, 14832, 14838).visit(i, j, CallChecker.isCalled(rowI, double[].class, 416, 14852, 14855)[j]);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 419, 14901, 14907)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 419, 14901, 14907).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3935.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3936 = new MethodContext(double.class, 424, 14927, 15734);
        try {
            CallChecker.varInit(this, "this", 424, 14927, 15734);
            CallChecker.varInit(endColumn, "endColumn", 424, 14927, 15734);
            CallChecker.varInit(startColumn, "startColumn", 424, 14927, 15734);
            CallChecker.varInit(endRow, "endRow", 424, 14927, 15734);
            CallChecker.varInit(startRow, "startRow", 424, 14927, 15734);
            CallChecker.varInit(visitor, "visitor", 424, 14927, 15734);
            CallChecker.varInit(this.data, "data", 424, 14927, 15734);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 424, 14927, 15734);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 429, 15345, 15351)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 429, 15345, 15351).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int i = startRow; i <= endRow; ++i) {
                data = CallChecker.beforeCalled(data, double[][].class, 432, 15550, 15553);
                final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 432, 15550, 15553)[i], "rowI", 432, 15528, 15557);
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(rowI, double[].class, 434, 15636, 15639)) {
                        if (CallChecker.beforeDeref(rowI, double[].class, 434, 15666, 15669)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 434, 15646, 15652)) {
                                CallChecker.isCalled(rowI, double[].class, 434, 15636, 15639)[j] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 434, 15646, 15652).visit(i, j, CallChecker.isCalled(rowI, double[].class, 434, 15666, 15669)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(rowI, double[].class, 434, 15636, 15639)[j], "CallChecker.isCalled(rowI, double[].class, 434, 15636, 15639)[j]", 434, 15636, 15674);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 437, 15715, 15721)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 437, 15715, 15721).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3936.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3937 = new MethodContext(double.class, 442, 15741, 16540);
        try {
            CallChecker.varInit(this, "this", 442, 15741, 16540);
            CallChecker.varInit(endColumn, "endColumn", 442, 15741, 16540);
            CallChecker.varInit(startColumn, "startColumn", 442, 15741, 16540);
            CallChecker.varInit(endRow, "endRow", 442, 15741, 16540);
            CallChecker.varInit(startRow, "startRow", 442, 15741, 16540);
            CallChecker.varInit(visitor, "visitor", 442, 15741, 16540);
            CallChecker.varInit(this.data, "data", 442, 15741, 16540);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 442, 15741, 16540);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 447, 16161, 16167)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 447, 16161, 16167).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int i = startRow; i <= endRow; ++i) {
                data = CallChecker.beforeCalled(data, double[][].class, 450, 16366, 16369);
                final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 450, 16366, 16369)[i], "rowI", 450, 16344, 16373);
                for (int j = startColumn; j <= endColumn; ++j) {
                    if (CallChecker.beforeDeref(rowI, double[].class, 452, 16472, 16475)) {
                        if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 452, 16452, 16458)) {
                            CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 452, 16452, 16458).visit(i, j, CallChecker.isCalled(rowI, double[].class, 452, 16472, 16475)[j]);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 455, 16521, 16527)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 455, 16521, 16527).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3937.methodEnd();
        }
    }

    @Override
    public double walkInColumnOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context3938 = new MethodContext(double.class, 460, 16547, 17075);
        try {
            CallChecker.varInit(this, "this", 460, 16547, 17075);
            CallChecker.varInit(visitor, "visitor", 460, 16547, 17075);
            CallChecker.varInit(this.data, "data", 460, 16547, 17075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 460, 16547, 17075);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 461, 16669, 16706);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 462, 16716, 16756);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 463, 16766, 16772)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 463, 16766, 16772).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int j = 0; j < columns; ++j) {
                for (int i = 0; i < rows; ++i) {
                    data = CallChecker.beforeCalled(data, double[][].class, 466, 16952, 16955);
                    final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 466, 16952, 16955)[i], "rowI", 466, 16930, 16959);
                    if (CallChecker.beforeDeref(rowI, double[].class, 467, 16977, 16980)) {
                        if (CallChecker.beforeDeref(rowI, double[].class, 467, 17007, 17010)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 467, 16987, 16993)) {
                                CallChecker.isCalled(rowI, double[].class, 467, 16977, 16980)[j] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 467, 16987, 16993).visit(i, j, CallChecker.isCalled(rowI, double[].class, 467, 17007, 17010)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(rowI, double[].class, 467, 16977, 16980)[j], "CallChecker.isCalled(rowI, double[].class, 467, 16977, 16980)[j]", 467, 16977, 17015);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 470, 17056, 17062)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 470, 17056, 17062).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3938.methodEnd();
        }
    }

    @Override
    public double walkInColumnOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context3939 = new MethodContext(double.class, 475, 17082, 17558);
        try {
            CallChecker.varInit(this, "this", 475, 17082, 17558);
            CallChecker.varInit(visitor, "visitor", 475, 17082, 17558);
            CallChecker.varInit(this.data, "data", 475, 17082, 17558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 475, 17082, 17558);
            final int rows = CallChecker.varInit(((int) (getRowDimension())), "rows", 476, 17206, 17243);
            final int columns = CallChecker.varInit(((int) (getColumnDimension())), "columns", 477, 17253, 17293);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 478, 17303, 17309)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 478, 17303, 17309).start(rows, columns, 0, (rows - 1), 0, (columns - 1));
            }
            for (int j = 0; j < columns; ++j) {
                for (int i = 0; i < rows; ++i) {
                    if (CallChecker.beforeDeref(data, double[][].class, 481, 17487, 17490)) {
                        data = CallChecker.beforeCalled(data, double[][].class, 481, 17487, 17490);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 481, 17487, 17490)[i], double[].class, 481, 17487, 17493)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 481, 17467, 17473)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 481, 17487, 17490);
                                CallChecker.isCalled(data, double[][].class, 481, 17487, 17490)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 481, 17487, 17490)[i], double[].class, 481, 17487, 17493);
                                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 481, 17467, 17473).visit(i, j, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 481, 17487, 17490)[i], double[].class, 481, 17487, 17493)[j]);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 484, 17539, 17545)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 484, 17539, 17545).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3939.methodEnd();
        }
    }

    @Override
    public double walkInColumnOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3940 = new MethodContext(double.class, 489, 17565, 18385);
        try {
            CallChecker.varInit(this, "this", 489, 17565, 18385);
            CallChecker.varInit(endColumn, "endColumn", 489, 17565, 18385);
            CallChecker.varInit(startColumn, "startColumn", 489, 17565, 18385);
            CallChecker.varInit(endRow, "endRow", 489, 17565, 18385);
            CallChecker.varInit(startRow, "startRow", 489, 17565, 18385);
            CallChecker.varInit(visitor, "visitor", 489, 17565, 18385);
            CallChecker.varInit(this.data, "data", 489, 17565, 18385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 489, 17565, 18385);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 494, 17992, 17998)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 494, 17992, 17998).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int j = startColumn; j <= endColumn; ++j) {
                for (int i = startRow; i <= endRow; ++i) {
                    data = CallChecker.beforeCalled(data, double[][].class, 498, 18262, 18265);
                    final double[] rowI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 498, 18262, 18265)[i], "rowI", 498, 18240, 18269);
                    if (CallChecker.beforeDeref(rowI, double[].class, 499, 18287, 18290)) {
                        if (CallChecker.beforeDeref(rowI, double[].class, 499, 18317, 18320)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 499, 18297, 18303)) {
                                CallChecker.isCalled(rowI, double[].class, 499, 18287, 18290)[j] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 499, 18297, 18303).visit(i, j, CallChecker.isCalled(rowI, double[].class, 499, 18317, 18320)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(rowI, double[].class, 499, 18287, 18290)[j], "CallChecker.isCalled(rowI, double[].class, 499, 18287, 18290)[j]", 499, 18287, 18325);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 502, 18366, 18372)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 502, 18366, 18372).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3940.methodEnd();
        }
    }

    @Override
    public double walkInColumnOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3941 = new MethodContext(double.class, 507, 18392, 19160);
        try {
            CallChecker.varInit(this, "this", 507, 18392, 19160);
            CallChecker.varInit(endColumn, "endColumn", 507, 18392, 19160);
            CallChecker.varInit(startColumn, "startColumn", 507, 18392, 19160);
            CallChecker.varInit(endRow, "endRow", 507, 18392, 19160);
            CallChecker.varInit(startRow, "startRow", 507, 18392, 19160);
            CallChecker.varInit(visitor, "visitor", 507, 18392, 19160);
            CallChecker.varInit(this.data, "data", 507, 18392, 19160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 507, 18392, 19160);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 512, 18821, 18827)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 512, 18821, 18827).start(getRowDimension(), getColumnDimension(), startRow, endRow, startColumn, endColumn);
            }
            for (int j = startColumn; j <= endColumn; ++j) {
                for (int i = startRow; i <= endRow; ++i) {
                    if (CallChecker.beforeDeref(data, double[][].class, 516, 19089, 19092)) {
                        data = CallChecker.beforeCalled(data, double[][].class, 516, 19089, 19092);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 516, 19089, 19092)[i], double[].class, 516, 19089, 19095)) {
                            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 516, 19069, 19075)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 516, 19089, 19092);
                                CallChecker.isCalled(data, double[][].class, 516, 19089, 19092)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 516, 19089, 19092)[i], double[].class, 516, 19089, 19095);
                                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 516, 19069, 19075).visit(i, j, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 516, 19089, 19092)[i], double[].class, 516, 19089, 19095)[j]);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 519, 19141, 19147)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 519, 19141, 19147).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3941.methodEnd();
        }
    }

    private double[][] copyOut() {
        MethodContext _bcornu_methode_context3942 = new MethodContext(double[][].class, 527, 19167, 19673);
        try {
            CallChecker.varInit(this, "this", 527, 19167, 19673);
            CallChecker.varInit(this.data, "data", 527, 19167, 19673);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 527, 19167, 19673);
            final int nRows = CallChecker.varInit(((int) (this.getRowDimension())), "nRows", 528, 19335, 19375);
            final double[][] out = CallChecker.varInit(new double[nRows][this.getColumnDimension()], "out", 529, 19385, 19452);
            for (int i = 0; i < nRows; i++) {
                if (CallChecker.beforeDeref(data, double[][].class, 532, 19599, 19602)) {
                    if (CallChecker.beforeDeref(out, double[][].class, 532, 19611, 19613)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 532, 19622, 19625)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 532, 19622, 19625);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 532, 19622, 19625)[i], double[].class, 532, 19622, 19628)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 532, 19599, 19602);
                                data = CallChecker.beforeCalled(data, double[][].class, 532, 19622, 19625);
                                CallChecker.isCalled(data, double[][].class, 532, 19622, 19625)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 532, 19622, 19625)[i], double[].class, 532, 19622, 19628);
                                System.arraycopy(CallChecker.isCalled(data, double[][].class, 532, 19599, 19602)[i], 0, CallChecker.isCalled(out, double[][].class, 532, 19611, 19613)[i], 0, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 532, 19622, 19625)[i], double[].class, 532, 19622, 19628).length);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3942.methodEnd();
        }
    }

    private void copyIn(final double[][] in) throws DimensionMismatchException, NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context3943 = new MethodContext(void.class, 545, 19680, 20167);
        try {
            CallChecker.varInit(this, "this", 545, 19680, 20167);
            CallChecker.varInit(in, "in", 545, 19680, 20167);
            CallChecker.varInit(this.data, "data", 545, 19680, 20167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.Array2DRowRealMatrix.serialVersionUID", 545, 19680, 20167);
            setSubMatrix(in, 0, 0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3943.methodEnd();
        }
    }
}

