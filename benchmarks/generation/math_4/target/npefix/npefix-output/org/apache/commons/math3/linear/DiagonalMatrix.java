package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public class DiagonalMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 20121229L;

    private final double[] data;

    public DiagonalMatrix(final int dimension) throws NotStrictlyPositiveException {
        super(dimension, dimension);
        ConstructorContext _bcornu_methode_context1245 = new ConstructorContext(DiagonalMatrix.class, 50, 1705, 2104);
        try {
            data = new double[dimension];
            CallChecker.varAssign(this.data, "this.data", 53, 2070, 2098);
        } finally {
            _bcornu_methode_context1245.methodEnd();
        }
    }

    public DiagonalMatrix(final double[] d) {
        this(d, true);
        ConstructorContext _bcornu_methode_context1246 = new ConstructorContext(DiagonalMatrix.class, 63, 2111, 2377);
        try {
        } finally {
            _bcornu_methode_context1246.methodEnd();
        }
    }

    public DiagonalMatrix(final double[] d, final boolean copyArray) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context1247 = new ConstructorContext(DiagonalMatrix.class, 81, 2384, 3175);
        try {
            MathUtils.checkNotNull(d);
            if (copyArray) {
                data = CallChecker.isCalled(d, double[].class, 84, 3156, 3156).clone();
                CallChecker.varAssign(this.data, "this.data", 84, 3137, 3169);
            }else {
                data = d;
                CallChecker.varAssign(this.data, "this.data", 84, 3137, 3169);
            }
        } finally {
            _bcornu_methode_context1247.methodEnd();
        }
    }

    @Override
    public RealMatrix createMatrix(final int rowDimension, final int columnDimension) throws DimensionMismatchException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5594 = new MethodContext(RealMatrix.class, 93, 3182, 3723);
        try {
            CallChecker.varInit(this, "this", 93, 3182, 3723);
            CallChecker.varInit(columnDimension, "columnDimension", 93, 3182, 3723);
            CallChecker.varInit(rowDimension, "rowDimension", 93, 3182, 3723);
            CallChecker.varInit(this.data, "data", 93, 3182, 3723);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 93, 3182, 3723);
            if (rowDimension != columnDimension) {
                throw new DimensionMismatchException(rowDimension, columnDimension);
            }
            return new DiagonalMatrix(rowDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5594.methodEnd();
        }
    }

    @Override
    public RealMatrix copy() {
        MethodContext _bcornu_methode_context5595 = new MethodContext(RealMatrix.class, 106, 3730, 3841);
        try {
            CallChecker.varInit(this, "this", 106, 3730, 3841);
            CallChecker.varInit(this.data, "data", 106, 3730, 3841);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 106, 3730, 3841);
            return new DiagonalMatrix(data);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5595.methodEnd();
        }
    }

    public DiagonalMatrix add(final DiagonalMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context5596 = new MethodContext(DiagonalMatrix.class, 118, 3848, 4525);
        try {
            CallChecker.varInit(this, "this", 118, 3848, 4525);
            CallChecker.varInit(m, "m", 118, 3848, 4525);
            CallChecker.varInit(this.data, "data", 118, 3848, 4525);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 118, 3848, 4525);
            MatrixUtils.checkAdditionCompatible(this, m);
            final int dim = CallChecker.varInit(((int) (getRowDimension())), "dim", 123, 4288, 4321);
            final double[] outData = CallChecker.varInit(new double[dim], "outData", 124, 4331, 4371);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(outData, double[].class, 126, 4425, 4431)) {
                    if (CallChecker.beforeDeref(data, double[].class, 126, 4438, 4441)) {
                        if (CallChecker.beforeDeref(m, DiagonalMatrix.class, 126, 4448, 4448)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m, DiagonalMatrix.class, 126, 4448, 4448).data, double[].class, 126, 4448, 4453)) {
                                CallChecker.isCalled(outData, double[].class, 126, 4425, 4431)[i] = (CallChecker.isCalled(data, double[].class, 126, 4438, 4441)[i]) + (CallChecker.isCalled(CallChecker.isCalled(m, DiagonalMatrix.class, 126, 4448, 4448).data, double[].class, 126, 4448, 4453)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(outData, double[].class, 126, 4425, 4431)[i], "CallChecker.isCalled(outData, double[].class, 126, 4425, 4431)[i]", 126, 4425, 4457);
                            }
                        }
                    }
                }
            }
            return new DiagonalMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DiagonalMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5596.methodEnd();
        }
    }

    public DiagonalMatrix subtract(final DiagonalMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context5597 = new MethodContext(DiagonalMatrix.class, 140, 4532, 5187);
        try {
            CallChecker.varInit(this, "this", 140, 4532, 5187);
            CallChecker.varInit(m, "m", 140, 4532, 5187);
            CallChecker.varInit(this.data, "data", 140, 4532, 5187);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 140, 4532, 5187);
            MatrixUtils.checkSubtractionCompatible(this, m);
            final int dim = CallChecker.varInit(((int) (getRowDimension())), "dim", 144, 4950, 4983);
            final double[] outData = CallChecker.varInit(new double[dim], "outData", 145, 4993, 5033);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(outData, double[].class, 147, 5087, 5093)) {
                    if (CallChecker.beforeDeref(data, double[].class, 147, 5100, 5103)) {
                        if (CallChecker.beforeDeref(m, DiagonalMatrix.class, 147, 5110, 5110)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m, DiagonalMatrix.class, 147, 5110, 5110).data, double[].class, 147, 5110, 5115)) {
                                CallChecker.isCalled(outData, double[].class, 147, 5087, 5093)[i] = (CallChecker.isCalled(data, double[].class, 147, 5100, 5103)[i]) - (CallChecker.isCalled(CallChecker.isCalled(m, DiagonalMatrix.class, 147, 5110, 5110).data, double[].class, 147, 5110, 5115)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(outData, double[].class, 147, 5087, 5093)[i], "CallChecker.isCalled(outData, double[].class, 147, 5087, 5093)[i]", 147, 5087, 5119);
                            }
                        }
                    }
                }
            }
            return new DiagonalMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DiagonalMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5597.methodEnd();
        }
    }

    public DiagonalMatrix multiply(final DiagonalMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5598 = new MethodContext(DiagonalMatrix.class, 161, 5194, 5869);
        try {
            CallChecker.varInit(this, "this", 161, 5194, 5869);
            CallChecker.varInit(m, "m", 161, 5194, 5869);
            CallChecker.varInit(this.data, "data", 161, 5194, 5869);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 161, 5194, 5869);
            MatrixUtils.checkMultiplicationCompatible(this, m);
            final int dim = CallChecker.varInit(((int) (getRowDimension())), "dim", 165, 5632, 5665);
            final double[] outData = CallChecker.varInit(new double[dim], "outData", 166, 5675, 5715);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(outData, double[].class, 168, 5769, 5775)) {
                    if (CallChecker.beforeDeref(data, double[].class, 168, 5782, 5785)) {
                        if (CallChecker.beforeDeref(m, DiagonalMatrix.class, 168, 5792, 5792)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m, DiagonalMatrix.class, 168, 5792, 5792).data, double[].class, 168, 5792, 5797)) {
                                CallChecker.isCalled(outData, double[].class, 168, 5769, 5775)[i] = (CallChecker.isCalled(data, double[].class, 168, 5782, 5785)[i]) * (CallChecker.isCalled(CallChecker.isCalled(m, DiagonalMatrix.class, 168, 5792, 5792).data, double[].class, 168, 5792, 5797)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(outData, double[].class, 168, 5769, 5775)[i], "CallChecker.isCalled(outData, double[].class, 168, 5769, 5775)[i]", 168, 5769, 5801);
                            }
                        }
                    }
                }
            }
            return new DiagonalMatrix(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DiagonalMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5598.methodEnd();
        }
    }

    public RealMatrix multiply(final RealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5599 = new MethodContext(RealMatrix.class, 182, 5876, 6847);
        try {
            CallChecker.varInit(this, "this", 182, 5876, 6847);
            CallChecker.varInit(m, "m", 182, 5876, 6847);
            CallChecker.varInit(this.data, "data", 182, 5876, 6847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 182, 5876, 6847);
            if (m instanceof DiagonalMatrix) {
                return multiply(((DiagonalMatrix) (m)));
            }else {
                MatrixUtils.checkMultiplicationCompatible(this, m);
                final int nRows = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 188, 6440, 6440).getRowDimension())), "nRows", 188, 6422, 6459);
                final int nCols = CallChecker.varInit(((int) (CallChecker.isCalled(m, RealMatrix.class, 189, 6491, 6491).getColumnDimension())), "nCols", 189, 6473, 6513);
                final double[][] product = CallChecker.varInit(new double[nRows][nCols], "product", 190, 6527, 6578);
                for (int r = 0; r < nRows; r++) {
                    for (int c = 0; c < nCols; c++) {
                        if (CallChecker.beforeDeref(product, double[][].class, 193, 6696, 6702)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r], double[].class, 193, 6696, 6705)) {
                                if (CallChecker.beforeDeref(data, double[].class, 193, 6712, 6715)) {
                                    if (CallChecker.beforeDeref(m, RealMatrix.class, 193, 6722, 6722)) {
                                        CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r] = CallChecker.beforeCalled(CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r], double[].class, 193, 6696, 6705);
                                        CallChecker.isCalled(CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r], double[].class, 193, 6696, 6705)[c] = (CallChecker.isCalled(data, double[].class, 193, 6712, 6715)[r]) * (CallChecker.isCalled(m, RealMatrix.class, 193, 6722, 6722).getEntry(r, c));
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r], double[].class, 193, 6696, 6705)[c], "CallChecker.isCalled(CallChecker.isCalled(product, double[][].class, 193, 6696, 6702)[r], double[].class, 193, 6696, 6705)[c]", 193, 6696, 6738);
                                    }
                                }
                            }
                        }
                    }
                }
                return new Array2DRowRealMatrix(product, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5599.methodEnd();
        }
    }

    @Override
    public double[][] getData() {
        MethodContext _bcornu_methode_context5600 = new MethodContext(double[][].class, 202, 6854, 7128);
        try {
            CallChecker.varInit(this, "this", 202, 6854, 7128);
            CallChecker.varInit(this.data, "data", 202, 6854, 7128);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 202, 6854, 7128);
            final int dim = CallChecker.varInit(((int) (getRowDimension())), "dim", 203, 6931, 6964);
            final double[][] out = CallChecker.varInit(new double[dim][dim], "out", 204, 6974, 7017);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(out, double[][].class, 207, 7072, 7074)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i], double[].class, 207, 7072, 7077)) {
                        if (CallChecker.beforeDeref(data, double[].class, 207, 7084, 7087)) {
                            CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i] = CallChecker.beforeCalled(CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i], double[].class, 207, 7072, 7077);
                            CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i], double[].class, 207, 7072, 7077)[i] = CallChecker.isCalled(data, double[].class, 207, 7084, 7087)[i];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i], double[].class, 207, 7072, 7077)[i], "CallChecker.isCalled(CallChecker.isCalled(out, double[][].class, 207, 7072, 7074)[i], double[].class, 207, 7072, 7077)[i]", 207, 7072, 7091);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5600.methodEnd();
        }
    }

    public double[] getDataRef() {
        MethodContext _bcornu_methode_context5601 = new MethodContext(double[].class, 218, 7135, 7315);
        try {
            CallChecker.varInit(this, "this", 218, 7135, 7315);
            CallChecker.varInit(this.data, "data", 218, 7135, 7315);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 218, 7135, 7315);
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5601.methodEnd();
        }
    }

    @Override
    public double getEntry(final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5602 = new MethodContext(double.class, 224, 7322, 7561);
        try {
            CallChecker.varInit(this, "this", 224, 7322, 7561);
            CallChecker.varInit(column, "column", 224, 7322, 7561);
            CallChecker.varInit(row, "row", 224, 7322, 7561);
            CallChecker.varInit(this.data, "data", 224, 7322, 7561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 224, 7322, 7561);
            MatrixUtils.checkMatrixIndex(this, row, column);
            if (row == column) {
                if (CallChecker.beforeDeref(data, double[].class, 227, 7542, 7545)) {
                    return CallChecker.isCalled(data, double[].class, 227, 7542, 7545)[row];
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5602.methodEnd();
        }
    }

    @Override
    public void setEntry(final int row, final int column, final double value) throws NumberIsTooLargeException, OutOfRangeException {
        MethodContext _bcornu_methode_context5603 = new MethodContext(void.class, 234, 7568, 8011);
        try {
            CallChecker.varInit(this, "this", 234, 7568, 8011);
            CallChecker.varInit(value, "value", 234, 7568, 8011);
            CallChecker.varInit(column, "column", 234, 7568, 8011);
            CallChecker.varInit(row, "row", 234, 7568, 8011);
            CallChecker.varInit(this.data, "data", 234, 7568, 8011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 234, 7568, 8011);
            if (row == column) {
                MatrixUtils.checkRowIndex(this, row);
                if (CallChecker.beforeDeref(data, double[].class, 238, 7930, 7933)) {
                    CallChecker.isCalled(data, double[].class, 238, 7930, 7933)[row] = value;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 238, 7930, 7933)[row], "CallChecker.isCalled(this.data, double[].class, 238, 7930, 7933)[row]", 238, 7930, 7947);
                }
            }else {
                ensureZero(value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5603.methodEnd();
        }
    }

    @Override
    public void addToEntry(final int row, final int column, final double increment) throws NumberIsTooLargeException, OutOfRangeException {
        MethodContext _bcornu_methode_context5604 = new MethodContext(void.class, 248, 8018, 8534);
        try {
            CallChecker.varInit(this, "this", 248, 8018, 8534);
            CallChecker.varInit(increment, "increment", 248, 8018, 8534);
            CallChecker.varInit(column, "column", 248, 8018, 8534);
            CallChecker.varInit(row, "row", 248, 8018, 8534);
            CallChecker.varInit(this.data, "data", 248, 8018, 8534);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 248, 8018, 8534);
            if (row == column) {
                MatrixUtils.checkRowIndex(this, row);
                if (CallChecker.beforeDeref(data, double[].class, 254, 8444, 8447)) {
                    CallChecker.isCalled(data, double[].class, 254, 8444, 8447)[row] += increment;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 254, 8444, 8447)[row], "CallChecker.isCalled(this.data, double[].class, 254, 8444, 8447)[row]", 254, 8444, 8466);
                }
            }else {
                ensureZero(increment);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5604.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(final int row, final int column, final double factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5605 = new MethodContext(void.class, 262, 8541, 8955);
        try {
            CallChecker.varInit(this, "this", 262, 8541, 8955);
            CallChecker.varInit(factor, "factor", 262, 8541, 8955);
            CallChecker.varInit(column, "column", 262, 8541, 8955);
            CallChecker.varInit(row, "row", 262, 8541, 8955);
            CallChecker.varInit(this.data, "data", 262, 8541, 8955);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 262, 8541, 8955);
            if (row == column) {
                MatrixUtils.checkRowIndex(this, row);
                if (CallChecker.beforeDeref(data, double[].class, 269, 8920, 8923)) {
                    CallChecker.isCalled(data, double[].class, 269, 8920, 8923)[row] *= factor;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 269, 8920, 8923)[row], "CallChecker.isCalled(this.data, double[].class, 269, 8920, 8923)[row]", 269, 8920, 8939);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5605.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context5606 = new MethodContext(int.class, 275, 8962, 9064);
        try {
            CallChecker.varInit(this, "this", 275, 8962, 9064);
            CallChecker.varInit(this.data, "data", 275, 8962, 9064);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 275, 8962, 9064);
            if (CallChecker.beforeDeref(data, double[].class, 276, 9047, 9050)) {
                return CallChecker.isCalled(data, double[].class, 276, 9047, 9050).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5606.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context5607 = new MethodContext(int.class, 281, 9071, 9176);
        try {
            CallChecker.varInit(this, "this", 281, 9071, 9176);
            CallChecker.varInit(this.data, "data", 281, 9071, 9176);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 281, 9071, 9176);
            if (CallChecker.beforeDeref(data, double[].class, 282, 9159, 9162)) {
                return CallChecker.isCalled(data, double[].class, 282, 9159, 9162).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5607.methodEnd();
        }
    }

    @Override
    public double[] operate(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5608 = new MethodContext(double[].class, 287, 9183, 9380);
        try {
            CallChecker.varInit(this, "this", 287, 9183, 9380);
            CallChecker.varInit(v, "v", 287, 9183, 9380);
            CallChecker.varInit(this.data, "data", 287, 9183, 9380);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 287, 9183, 9380);
            final DiagonalMatrix npe_invocation_var1017 = multiply(new DiagonalMatrix(v, false));
            if (CallChecker.beforeDeref(npe_invocation_var1017, DiagonalMatrix.class, 289, 9323, 9360)) {
                return CallChecker.isCalled(npe_invocation_var1017, DiagonalMatrix.class, 289, 9323, 9360).getDataRef();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5608.methodEnd();
        }
    }

    @Override
    public double[] preMultiply(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5609 = new MethodContext(double[].class, 294, 9387, 9547);
        try {
            CallChecker.varInit(this, "this", 294, 9387, 9547);
            CallChecker.varInit(v, "v", 294, 9387, 9547);
            CallChecker.varInit(this.data, "data", 294, 9387, 9547);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 294, 9387, 9547);
            return operate(v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5609.methodEnd();
        }
    }

    private void ensureZero(final double value) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5610 = new MethodContext(void.class, 303, 9554, 9914);
        try {
            CallChecker.varInit(this, "this", 303, 9554, 9914);
            CallChecker.varInit(value, "value", 303, 9554, 9914);
            CallChecker.varInit(this.data, "data", 303, 9554, 9914);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.DiagonalMatrix.serialVersionUID", 303, 9554, 9914);
            if (!(Precision.equals(0.0, value, 1))) {
                throw new NumberIsTooLargeException(FastMath.abs(value), 0, true);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5610.methodEnd();
        }
    }
}

