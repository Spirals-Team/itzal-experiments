package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class BlockRealMatrix extends AbstractRealMatrix implements Serializable {
    public static final int BLOCK_SIZE = 52;

    private static final long serialVersionUID = 4991895511313664478L;

    private final double[][] blocks;

    private final int rows;

    private final int columns;

    private final int blockRows;

    private final int blockColumns;

    public BlockRealMatrix(final int rows, final int columns) throws NotStrictlyPositiveException {
        super(rows, columns);
        ConstructorContext _bcornu_methode_context257 = new ConstructorContext(BlockRealMatrix.class, 96, 4268, 5062);
        try {
            this.rows = rows;
            CallChecker.varAssign(this.rows, "this.rows", 99, 4720, 4736);
            this.columns = columns;
            CallChecker.varAssign(this.columns, "this.columns", 100, 4746, 4768);
            blockRows = ((rows + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockRows, "this.blockRows", 103, 4807, 4855);
            blockColumns = ((columns + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockColumns, "this.blockColumns", 104, 4865, 4919);
            blocks = BlockRealMatrix.createBlocksLayout(rows, columns);
            CallChecker.varAssign(this.blocks, "this.blocks", 107, 5014, 5056);
        } finally {
            _bcornu_methode_context257.methodEnd();
        }
    }

    public BlockRealMatrix(final double[][] rawData) throws DimensionMismatchException, NotStrictlyPositiveException {
        this(CallChecker.isCalled(rawData, double[][].class, 127, 5925, 5931).length, CallChecker.isCalled(CallChecker.isCalled(rawData, double[][].class, 127, 5941, 5947)[0], double[].class, 127, 5941, 5950).length, BlockRealMatrix.toBlocksLayout(rawData), false);
        ConstructorContext _bcornu_methode_context258 = new ConstructorContext(BlockRealMatrix.class, 125, 5069, 5997);
        try {
        } finally {
            _bcornu_methode_context258.methodEnd();
        }
    }

    public BlockRealMatrix(final int rows, final int columns, final double[][] blockData, final boolean copyArray) throws DimensionMismatchException, NotStrictlyPositiveException {
        super(rows, columns);
        ConstructorContext _bcornu_methode_context259 = new ConstructorContext(BlockRealMatrix.class, 146, 6004, 8091);
        try {
            this.rows = rows;
            CallChecker.varAssign(this.rows, "this.rows", 150, 6993, 7009);
            this.columns = columns;
            CallChecker.varAssign(this.columns, "this.columns", 151, 7019, 7041);
            blockRows = ((rows + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockRows, "this.blockRows", 154, 7080, 7128);
            blockColumns = ((columns + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockColumns, "this.blockColumns", 155, 7138, 7192);
            if (copyArray) {
                blocks = new double[(blockRows) * (blockColumns)][];
                CallChecker.varAssign(this.blocks, "this.blocks", 159, 7320, 7367);
            }else {
                blocks = blockData;
                CallChecker.varAssign(this.blocks, "this.blocks", 162, 7438, 7456);
            }
            int index = CallChecker.varInit(((int) (0)), "index", 165, 7477, 7490);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 167, 7565, 7604);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock , ++index) {
                    if (CallChecker.beforeDeref(blockData, double[][].class, 169, 7703, 7711)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, double[][].class, 169, 7703, 7711)[index], double[].class, 169, 7703, 7718)) {
                            CallChecker.isCalled(blockData, double[][].class, 169, 7703, 7711)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, double[][].class, 169, 7703, 7711)[index], double[].class, 169, 7703, 7718);
                            if ((CallChecker.isCalled(CallChecker.isCalled(blockData, double[][].class, 169, 7703, 7711)[index], double[].class, 169, 7703, 7718).length) != (iHeight * (blockWidth(jBlock)))) {
                                if (CallChecker.beforeDeref(blockData, double[][].class, 170, 7819, 7827)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, double[][].class, 170, 7819, 7827)[index], double[].class, 170, 7819, 7834)) {
                                        CallChecker.isCalled(blockData, double[][].class, 170, 7819, 7827)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, double[][].class, 170, 7819, 7827)[index], double[].class, 170, 7819, 7834);
                                        throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(blockData, double[][].class, 170, 7819, 7827)[index], double[].class, 170, 7819, 7834).length, (iHeight * (blockWidth(jBlock))));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (copyArray) {
                        if (CallChecker.beforeDeref(blocks, double[][].class, 174, 8003, 8008)) {
                            if (CallChecker.beforeDeref(blockData, double[][].class, 174, 8019, 8027)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, double[][].class, 174, 8019, 8027)[index], double[].class, 174, 8019, 8034)) {
                                    CallChecker.isCalled(blockData, double[][].class, 174, 8019, 8027)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, double[][].class, 174, 8019, 8027)[index], double[].class, 174, 8019, 8034);
                                    CallChecker.isCalled(blocks, double[][].class, 174, 8003, 8008)[index] = CallChecker.isCalled(CallChecker.isCalled(blockData, double[][].class, 174, 8019, 8027)[index], double[].class, 174, 8019, 8034).clone();
                                    CallChecker.varAssign(CallChecker.isCalled(this.blocks, double[][].class, 174, 8003, 8008)[index], "CallChecker.isCalled(this.blocks, double[][].class, 174, 8003, 8008)[index]", 174, 8003, 8043);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context259.methodEnd();
        }
    }

    public static double[][] toBlocksLayout(final double[][] rawData) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1083 = new MethodContext(double[][].class, 201, 8098, 10882);
        try {
            CallChecker.varInit(rawData, "rawData", 201, 8098, 10882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 201, 8098, 10882);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 201, 8098, 10882);
            final int rows = CallChecker.varInit(((int) (CallChecker.isCalled(rawData, double[][].class, 203, 9322, 9328).length)), "rows", 203, 9305, 9336);
            CallChecker.isCalled(rawData, double[][].class, 204, 9366, 9372)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rawData, double[][].class, 204, 9366, 9372)[0], double[].class, 204, 9366, 9375);
            final int columns = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(rawData, double[][].class, 204, 9366, 9372)[0], double[].class, 204, 9366, 9375).length)), "columns", 204, 9346, 9383);
            final int blockRows = CallChecker.varInit(((int) (((rows + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE))), "blockRows", 205, 9393, 9454);
            final int blockColumns = CallChecker.varInit(((int) (((columns + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE))), "blockColumns", 206, 9464, 9528);
            for (int i = 0; i < (CallChecker.isCalled(rawData, double[][].class, 209, 9584, 9590).length); ++i) {
                CallChecker.isCalled(rawData, double[][].class, 210, 9638, 9644)[i] = CallChecker.beforeCalled(CallChecker.isCalled(rawData, double[][].class, 210, 9638, 9644)[i], double[].class, 210, 9638, 9647);
                final int length = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(rawData, double[][].class, 210, 9638, 9644)[i], double[].class, 210, 9638, 9647).length)), "length", 210, 9619, 9655);
                if (length != columns) {
                    throw new DimensionMismatchException(columns, length);
                }
            }
            final double[][] blocks = CallChecker.varInit(new double[blockRows * blockColumns][], "blocks", 217, 9823, 9887);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 218, 9897, 9915);
            for (int iBlock = 0; iBlock < blockRows; ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 220, 9990, 10028);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), rows))), "pEnd", 221, 10042, 10098);
                final int iHeight = CallChecker.varInit(((int) (pEnd - pStart)), "iHeight", 222, 10112, 10145);
                for (int jBlock = 0; jBlock < blockColumns; ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 224, 10231, 10269);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), columns))), "qEnd", 225, 10287, 10346);
                    final int jWidth = CallChecker.varInit(((int) (qEnd - qStart)), "jWidth", 226, 10364, 10396);
                    final double[] block = CallChecker.varInit(new double[iHeight * jWidth], "block", 229, 10453, 10504);
                    if (CallChecker.beforeDeref(blocks, double[][].class, 230, 10522, 10527)) {
                        CallChecker.isCalled(blocks, double[][].class, 230, 10522, 10527)[blockIndex] = block;
                        CallChecker.varAssign(CallChecker.isCalled(blocks, double[][].class, 230, 10522, 10527)[blockIndex], "CallChecker.isCalled(blocks, double[][].class, 230, 10522, 10527)[blockIndex]", 230, 10522, 10548);
                    }
                    int index = CallChecker.varInit(((int) (0)), "index", 233, 10596, 10609);
                    for (int p = pStart; p < pEnd; ++p) {
                        if (CallChecker.beforeDeref(rawData, double[][].class, 235, 10702, 10708)) {
                            System.arraycopy(CallChecker.isCalled(rawData, double[][].class, 235, 10702, 10708)[p], qStart, block, index, jWidth);
                        }
                        index += jWidth;
                        CallChecker.varAssign(index, "index", 236, 10765, 10780);
                    }
                    ++blockIndex;
                }
            }
            return blocks;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1083.methodEnd();
        }
    }

    public static double[][] createBlocksLayout(final int rows, final int columns) {
        MethodContext _bcornu_methode_context1084 = new MethodContext(double[][].class, 257, 10889, 12337);
        try {
            CallChecker.varInit(columns, "columns", 257, 10889, 12337);
            CallChecker.varInit(rows, "rows", 257, 10889, 12337);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 257, 10889, 12337);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 257, 10889, 12337);
            final int blockRows = CallChecker.varInit(((int) (((rows + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE))), "blockRows", 258, 11467, 11528);
            final int blockColumns = CallChecker.varInit(((int) (((columns + (BlockRealMatrix.BLOCK_SIZE)) - 1) / (BlockRealMatrix.BLOCK_SIZE))), "blockColumns", 259, 11538, 11602);
            final double[][] blocks = CallChecker.varInit(new double[blockRows * blockColumns][], "blocks", 261, 11613, 11677);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 262, 11687, 11705);
            for (int iBlock = 0; iBlock < blockRows; ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 264, 11780, 11818);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), rows))), "pEnd", 265, 11832, 11888);
                final int iHeight = CallChecker.varInit(((int) (pEnd - pStart)), "iHeight", 266, 11902, 11935);
                for (int jBlock = 0; jBlock < blockColumns; ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 268, 12021, 12059);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), columns))), "qEnd", 269, 12077, 12136);
                    final int jWidth = CallChecker.varInit(((int) (qEnd - qStart)), "jWidth", 270, 12154, 12186);
                    if (CallChecker.beforeDeref(blocks, double[][].class, 271, 12204, 12209)) {
                        CallChecker.isCalled(blocks, double[][].class, 271, 12204, 12209)[blockIndex] = new double[iHeight * jWidth];
                        CallChecker.varAssign(CallChecker.isCalled(blocks, double[][].class, 271, 12204, 12209)[blockIndex], "CallChecker.isCalled(blocks, double[][].class, 271, 12204, 12209)[blockIndex]", 271, 12204, 12253);
                    }
                    ++blockIndex;
                }
            }
            return blocks;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1084.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix createMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context1085 = new MethodContext(BlockRealMatrix.class, 281, 12344, 12627);
        try {
            CallChecker.varInit(this, "this", 281, 12344, 12627);
            CallChecker.varInit(columnDimension, "columnDimension", 281, 12344, 12627);
            CallChecker.varInit(rowDimension, "rowDimension", 281, 12344, 12627);
            CallChecker.varInit(this.blockColumns, "blockColumns", 281, 12344, 12627);
            CallChecker.varInit(this.blockRows, "blockRows", 281, 12344, 12627);
            CallChecker.varInit(this.columns, "columns", 281, 12344, 12627);
            CallChecker.varInit(this.rows, "rows", 281, 12344, 12627);
            CallChecker.varInit(this.blocks, "blocks", 281, 12344, 12627);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 281, 12344, 12627);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 281, 12344, 12627);
            return new BlockRealMatrix(rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1085.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix copy() {
        MethodContext _bcornu_methode_context1086 = new MethodContext(BlockRealMatrix.class, 289, 12634, 13007);
        try {
            CallChecker.varInit(this, "this", 289, 12634, 13007);
            CallChecker.varInit(this.blockColumns, "blockColumns", 289, 12634, 13007);
            CallChecker.varInit(this.blockRows, "blockRows", 289, 12634, 13007);
            CallChecker.varInit(this.columns, "columns", 289, 12634, 13007);
            CallChecker.varInit(this.rows, "rows", 289, 12634, 13007);
            CallChecker.varInit(this.blocks, "blocks", 289, 12634, 13007);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 289, 12634, 13007);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 289, 12634, 13007);
            BlockRealMatrix copied = CallChecker.varInit(new BlockRealMatrix(rows, columns), "copied", 291, 12747, 12806);
            for (int i = 0; i < (CallChecker.isCalled(blocks, double[][].class, 294, 12864, 12869).length); ++i) {
                if (CallChecker.beforeDeref(blocks, double[][].class, 295, 12915, 12920)) {
                    if (CallChecker.beforeDeref(copied, BlockRealMatrix.class, 295, 12929, 12934)) {
                        copied = CallChecker.beforeCalled(copied, BlockRealMatrix.class, 295, 12929, 12934);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(copied, BlockRealMatrix.class, 295, 12929, 12934).blocks, double[][].class, 295, 12929, 12941)) {
                            if (CallChecker.beforeDeref(blocks, double[][].class, 295, 12950, 12955)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, double[][].class, 295, 12950, 12955)[i], double[].class, 295, 12950, 12958)) {
                                    copied = CallChecker.beforeCalled(copied, BlockRealMatrix.class, 295, 12929, 12934);
                                    CallChecker.isCalled(blocks, double[][].class, 295, 12950, 12955)[i] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, double[][].class, 295, 12950, 12955)[i], double[].class, 295, 12950, 12958);
                                    System.arraycopy(CallChecker.isCalled(blocks, double[][].class, 295, 12915, 12920)[i], 0, CallChecker.isCalled(CallChecker.isCalled(copied, BlockRealMatrix.class, 295, 12929, 12934).blocks, double[][].class, 295, 12929, 12941)[i], 0, CallChecker.isCalled(CallChecker.isCalled(blocks, double[][].class, 295, 12950, 12955)[i], double[].class, 295, 12950, 12958).length);
                                }
                            }
                        }
                    }
                }
            }
            return copied;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1086.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix add(final RealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1087 = new MethodContext(BlockRealMatrix.class, 303, 13014, 14593);
        try {
            CallChecker.varInit(this, "this", 303, 13014, 14593);
            CallChecker.varInit(m, "m", 303, 13014, 14593);
            CallChecker.varInit(this.blockColumns, "blockColumns", 303, 13014, 14593);
            CallChecker.varInit(this.blockRows, "blockRows", 303, 13014, 14593);
            CallChecker.varInit(this.columns, "columns", 303, 13014, 14593);
            CallChecker.varInit(this.rows, "rows", 303, 13014, 14593);
            CallChecker.varInit(this.blocks, "blocks", 303, 13014, 14593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 303, 13014, 14593);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 303, 13014, 14593);
            TryContext _bcornu_try_context_14 = new TryContext(14, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                return add(((BlockRealMatrix) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_14.catchStart(14);
                MatrixUtils.checkAdditionCompatible(this, m);
                final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 311, 13351, 13413);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 314, 13502, 13520);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 315, 13564, 13566).blockRows); ++iBlock) {
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 316, 13637, 13639).blockColumns); ++jBlock) {
                        final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 319, 13775, 13777).blocks, double[][].class, 319, 13775, 13784)[blockIndex], "outBlock", 319, 13749, 13797);
                        final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 320, 13845, 13850)[blockIndex], "tBlock", 320, 13819, 13863);
                        final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 321, 13885, 13923);
                        final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 322, 13945, 14001);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 323, 14023, 14061);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 324, 14083, 14142);
                        int k = CallChecker.varInit(((int) (0)), "k", 325, 14164, 14173);
                        for (int p = pStart; p < pEnd; ++p) {
                            for (int q = qStart; q < qEnd; ++q) {
                                if (CallChecker.beforeDeref(outBlock, double[].class, 328, 14323, 14330)) {
                                    if (CallChecker.beforeDeref(tBlock, double[].class, 328, 14337, 14342)) {
                                        if (CallChecker.beforeDeref(m, RealMatrix.class, 328, 14349, 14349)) {
                                            CallChecker.isCalled(outBlock, double[].class, 328, 14323, 14330)[k] = (CallChecker.isCalled(tBlock, double[].class, 328, 14337, 14342)[k]) + (CallChecker.isCalled(m, RealMatrix.class, 328, 14349, 14349).getEntry(p, q));
                                            CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 328, 14323, 14330)[k], "CallChecker.isCalled(outBlock, double[].class, 328, 14323, 14330)[k]", 328, 14323, 14365);
                                        }
                                    }
                                }
                                ++k;
                            }
                        }
                        ++blockIndex;
                    }
                }
                return out;
            } finally {
                _bcornu_try_context_14.finallyStart(14);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1087.methodEnd();
        }
    }

    public BlockRealMatrix add(final BlockRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1088 = new MethodContext(BlockRealMatrix.class, 349, 14600, 15589);
        try {
            CallChecker.varInit(this, "this", 349, 14600, 15589);
            CallChecker.varInit(m, "m", 349, 14600, 15589);
            CallChecker.varInit(this.blockColumns, "blockColumns", 349, 14600, 15589);
            CallChecker.varInit(this.blockRows, "blockRows", 349, 14600, 15589);
            CallChecker.varInit(this.columns, "columns", 349, 14600, 15589);
            CallChecker.varInit(this.rows, "rows", 349, 14600, 15589);
            CallChecker.varInit(this.blocks, "blocks", 349, 14600, 15589);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 349, 14600, 15589);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 349, 14600, 15589);
            MatrixUtils.checkAdditionCompatible(this, m);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 354, 15039, 15101);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 357, 15220, 15222).blocks, double[][].class, 357, 15220, 15229).length); ++blockIndex) {
                final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 358, 15293, 15295).blocks, double[][].class, 358, 15293, 15302)[blockIndex], "outBlock", 358, 15267, 15315);
                final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 359, 15353, 15358)[blockIndex], "tBlock", 359, 15329, 15371);
                final double[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockRealMatrix.class, 360, 15409, 15409).blocks, double[][].class, 360, 15409, 15416)[blockIndex], "mBlock", 360, 15385, 15429);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, double[].class, 361, 15463, 15470).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, double[].class, 362, 15503, 15510)) {
                        if (CallChecker.beforeDeref(tBlock, double[].class, 362, 15517, 15522)) {
                            if (CallChecker.beforeDeref(mBlock, double[].class, 362, 15529, 15534)) {
                                CallChecker.isCalled(outBlock, double[].class, 362, 15503, 15510)[k] = (CallChecker.isCalled(tBlock, double[].class, 362, 15517, 15522)[k]) + (CallChecker.isCalled(mBlock, double[].class, 362, 15529, 15534)[k]);
                                CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 362, 15503, 15510)[k], "CallChecker.isCalled(outBlock, double[].class, 362, 15503, 15510)[k]", 362, 15503, 15538);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1088.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix subtract(final RealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1089 = new MethodContext(BlockRealMatrix.class, 371, 15596, 17192);
        try {
            CallChecker.varInit(this, "this", 371, 15596, 17192);
            CallChecker.varInit(m, "m", 371, 15596, 17192);
            CallChecker.varInit(this.blockColumns, "blockColumns", 371, 15596, 17192);
            CallChecker.varInit(this.blockRows, "blockRows", 371, 15596, 17192);
            CallChecker.varInit(this.columns, "columns", 371, 15596, 17192);
            CallChecker.varInit(this.rows, "rows", 371, 15596, 17192);
            CallChecker.varInit(this.blocks, "blocks", 371, 15596, 17192);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 371, 15596, 17192);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 371, 15596, 17192);
            TryContext _bcornu_try_context_15 = new TryContext(15, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                return subtract(((BlockRealMatrix) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_15.catchStart(15);
                MatrixUtils.checkSubtractionCompatible(this, m);
                final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 379, 15946, 16008);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 382, 16100, 16118);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 383, 16162, 16164).blockRows); ++iBlock) {
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 384, 16235, 16237).blockColumns); ++jBlock) {
                        final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 387, 16376, 16378).blocks, double[][].class, 387, 16376, 16385)[blockIndex], "outBlock", 387, 16350, 16398);
                        final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 388, 16444, 16449)[blockIndex], "tBlock", 388, 16420, 16462);
                        final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 389, 16484, 16522);
                        final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 390, 16544, 16600);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 391, 16622, 16660);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 392, 16682, 16741);
                        int k = CallChecker.varInit(((int) (0)), "k", 393, 16763, 16772);
                        for (int p = pStart; p < pEnd; ++p) {
                            for (int q = qStart; q < qEnd; ++q) {
                                if (CallChecker.beforeDeref(outBlock, double[].class, 396, 16922, 16929)) {
                                    if (CallChecker.beforeDeref(tBlock, double[].class, 396, 16936, 16941)) {
                                        if (CallChecker.beforeDeref(m, RealMatrix.class, 396, 16948, 16948)) {
                                            CallChecker.isCalled(outBlock, double[].class, 396, 16922, 16929)[k] = (CallChecker.isCalled(tBlock, double[].class, 396, 16936, 16941)[k]) - (CallChecker.isCalled(m, RealMatrix.class, 396, 16948, 16948).getEntry(p, q));
                                            CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 396, 16922, 16929)[k], "CallChecker.isCalled(outBlock, double[].class, 396, 16922, 16929)[k]", 396, 16922, 16964);
                                        }
                                    }
                                }
                                ++k;
                            }
                        }
                        ++blockIndex;
                    }
                }
                return out;
            } finally {
                _bcornu_try_context_15.finallyStart(15);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1089.methodEnd();
        }
    }

    public BlockRealMatrix subtract(final BlockRealMatrix m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1090 = new MethodContext(BlockRealMatrix.class, 417, 17199, 18195);
        try {
            CallChecker.varInit(this, "this", 417, 17199, 18195);
            CallChecker.varInit(m, "m", 417, 17199, 18195);
            CallChecker.varInit(this.blockColumns, "blockColumns", 417, 17199, 18195);
            CallChecker.varInit(this.blockRows, "blockRows", 417, 17199, 18195);
            CallChecker.varInit(this.columns, "columns", 417, 17199, 18195);
            CallChecker.varInit(this.rows, "rows", 417, 17199, 18195);
            CallChecker.varInit(this.blocks, "blocks", 417, 17199, 18195);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 417, 17199, 18195);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 417, 17199, 18195);
            MatrixUtils.checkSubtractionCompatible(this, m);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 422, 17642, 17704);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 425, 17826, 17828).blocks, double[][].class, 425, 17826, 17835).length); ++blockIndex) {
                final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 426, 17899, 17901).blocks, double[][].class, 426, 17899, 17908)[blockIndex], "outBlock", 426, 17873, 17921);
                final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 427, 17959, 17964)[blockIndex], "tBlock", 427, 17935, 17977);
                final double[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockRealMatrix.class, 428, 18015, 18015).blocks, double[][].class, 428, 18015, 18022)[blockIndex], "mBlock", 428, 17991, 18035);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, double[].class, 429, 18069, 18076).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, double[].class, 430, 18109, 18116)) {
                        if (CallChecker.beforeDeref(tBlock, double[].class, 430, 18123, 18128)) {
                            if (CallChecker.beforeDeref(mBlock, double[].class, 430, 18135, 18140)) {
                                CallChecker.isCalled(outBlock, double[].class, 430, 18109, 18116)[k] = (CallChecker.isCalled(tBlock, double[].class, 430, 18123, 18128)[k]) - (CallChecker.isCalled(mBlock, double[].class, 430, 18135, 18140)[k]);
                                CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 430, 18109, 18116)[k], "CallChecker.isCalled(outBlock, double[].class, 430, 18109, 18116)[k]", 430, 18109, 18144);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1090.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix scalarAdd(final double d) {
        MethodContext _bcornu_methode_context1091 = new MethodContext(BlockRealMatrix.class, 439, 18202, 18788);
        try {
            CallChecker.varInit(this, "this", 439, 18202, 18788);
            CallChecker.varInit(d, "d", 439, 18202, 18788);
            CallChecker.varInit(this.blockColumns, "blockColumns", 439, 18202, 18788);
            CallChecker.varInit(this.blockRows, "blockRows", 439, 18202, 18788);
            CallChecker.varInit(this.columns, "columns", 439, 18202, 18788);
            CallChecker.varInit(this.rows, "rows", 439, 18202, 18788);
            CallChecker.varInit(this.blocks, "blocks", 439, 18202, 18788);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 439, 18202, 18788);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 439, 18202, 18788);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 441, 18301, 18363);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 444, 18485, 18487).blocks, double[][].class, 444, 18485, 18494).length); ++blockIndex) {
                final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 445, 18558, 18560).blocks, double[][].class, 445, 18558, 18567)[blockIndex], "outBlock", 445, 18532, 18580);
                final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 446, 18618, 18623)[blockIndex], "tBlock", 446, 18594, 18636);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, double[].class, 447, 18670, 18677).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, double[].class, 448, 18710, 18717)) {
                        if (CallChecker.beforeDeref(tBlock, double[].class, 448, 18724, 18729)) {
                            CallChecker.isCalled(outBlock, double[].class, 448, 18710, 18717)[k] = (CallChecker.isCalled(tBlock, double[].class, 448, 18724, 18729)[k]) + d;
                            CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 448, 18710, 18717)[k], "CallChecker.isCalled(outBlock, double[].class, 448, 18710, 18717)[k]", 448, 18710, 18737);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1091.methodEnd();
        }
    }

    @Override
    public RealMatrix scalarMultiply(final double d) {
        MethodContext _bcornu_methode_context1092 = new MethodContext(RealMatrix.class, 457, 18795, 19380);
        try {
            CallChecker.varInit(this, "this", 457, 18795, 19380);
            CallChecker.varInit(d, "d", 457, 18795, 19380);
            CallChecker.varInit(this.blockColumns, "blockColumns", 457, 18795, 19380);
            CallChecker.varInit(this.blockRows, "blockRows", 457, 18795, 19380);
            CallChecker.varInit(this.columns, "columns", 457, 18795, 19380);
            CallChecker.varInit(this.rows, "rows", 457, 18795, 19380);
            CallChecker.varInit(this.blocks, "blocks", 457, 18795, 19380);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 457, 18795, 19380);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 457, 18795, 19380);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, columns), "out", 458, 18893, 18955);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 461, 19077, 19079).blocks, double[][].class, 461, 19077, 19086).length); ++blockIndex) {
                final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 462, 19150, 19152).blocks, double[][].class, 462, 19150, 19159)[blockIndex], "outBlock", 462, 19124, 19172);
                final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 463, 19210, 19215)[blockIndex], "tBlock", 463, 19186, 19228);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, double[].class, 464, 19262, 19269).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, double[].class, 465, 19302, 19309)) {
                        if (CallChecker.beforeDeref(tBlock, double[].class, 465, 19316, 19321)) {
                            CallChecker.isCalled(outBlock, double[].class, 465, 19302, 19309)[k] = (CallChecker.isCalled(tBlock, double[].class, 465, 19316, 19321)[k]) * d;
                            CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 465, 19302, 19309)[k], "CallChecker.isCalled(outBlock, double[].class, 465, 19302, 19309)[k]", 465, 19302, 19329);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1092.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix multiply(final RealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1093 = new MethodContext(BlockRealMatrix.class, 474, 19387, 21749);
        try {
            CallChecker.varInit(this, "this", 474, 19387, 21749);
            CallChecker.varInit(m, "m", 474, 19387, 21749);
            CallChecker.varInit(this.blockColumns, "blockColumns", 474, 19387, 21749);
            CallChecker.varInit(this.blockRows, "blockRows", 474, 19387, 21749);
            CallChecker.varInit(this.columns, "columns", 474, 19387, 21749);
            CallChecker.varInit(this.rows, "rows", 474, 19387, 21749);
            CallChecker.varInit(this.blocks, "blocks", 474, 19387, 21749);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 474, 19387, 21749);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 474, 19387, 21749);
            TryContext _bcornu_try_context_16 = new TryContext(16, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                return multiply(((BlockRealMatrix) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_16.catchStart(16);
                MatrixUtils.checkMultiplicationCompatible(this, m);
                final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, CallChecker.isCalled(m, RealMatrix.class, 482, 19788, 19788).getColumnDimension()), "out", 482, 19734, 19811);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 485, 19906, 19924);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 486, 19968, 19970).blockRows); ++iBlock) {
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 487, 20011, 20049);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 488, 20067, 20123);
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 490, 20172, 20174).blockColumns); ++jBlock) {
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 491, 20222, 20260);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), CallChecker.isCalled(m, RealMatrix.class, 492, 20333, 20333).getColumnDimension()))), "qEnd", 492, 20282, 20356);
                        final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 495, 20449, 20451).blocks, double[][].class, 495, 20449, 20458)[blockIndex], "outBlock", 495, 20423, 20471);
                        for (int kBlock = 0; kBlock < (blockColumns); ++kBlock) {
                            final int kWidth = CallChecker.varInit(((int) (blockWidth(kBlock))), "kWidth", 499, 20637, 20674);
                            final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 500, 20724, 20729)[((iBlock * (blockColumns)) + kBlock)], "tBlock", 500, 20700, 20762);
                            final int rStart = CallChecker.varInit(((int) (kBlock * (BlockRealMatrix.BLOCK_SIZE))), "rStart", 501, 20788, 20826);
                            int k = CallChecker.varInit(((int) (0)), "k", 502, 20852, 20861);
                            for (int p = pStart; p < pEnd; ++p) {
                                final int lStart = CallChecker.varInit(((int) ((p - pStart) * kWidth)), "lStart", 504, 20953, 20993);
                                final int lEnd = CallChecker.varInit(((int) (lStart + kWidth)), "lEnd", 505, 21023, 21055);
                                for (int q = qStart; q < qEnd; ++q) {
                                    double sum = CallChecker.varInit(((double) (0)), "sum", 507, 21155, 21169);
                                    int r = CallChecker.varInit(((int) (rStart)), "r", 508, 21203, 21217);
                                    for (int l = lStart; l < lEnd; ++l) {
                                        if (CallChecker.beforeDeref(tBlock, double[].class, 510, 21332, 21337)) {
                                            if (CallChecker.beforeDeref(m, RealMatrix.class, 510, 21344, 21344)) {
                                                sum += (CallChecker.isCalled(tBlock, double[].class, 510, 21332, 21337)[l]) * (CallChecker.isCalled(m, RealMatrix.class, 510, 21344, 21344).getEntry(r, q));
                                                CallChecker.varAssign(sum, "sum", 510, 21325, 21360);
                                            }
                                        }
                                        ++r;
                                    }
                                    if (CallChecker.beforeDeref(outBlock, double[].class, 513, 21469, 21476)) {
                                        CallChecker.isCalled(outBlock, double[].class, 513, 21469, 21476)[k] += sum;
                                        CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 513, 21469, 21476)[k], "CallChecker.isCalled(outBlock, double[].class, 513, 21469, 21476)[k]", 513, 21469, 21487);
                                    }
                                    ++k;
                                }
                            }
                        }
                        ++blockIndex;
                    }
                }
                return out;
            } finally {
                _bcornu_try_context_16.finallyStart(16);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1093.methodEnd();
        }
    }

    public BlockRealMatrix multiply(BlockRealMatrix m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1094 = new MethodContext(BlockRealMatrix.class, 534, 21756, 24634);
        try {
            CallChecker.varInit(this, "this", 534, 21756, 24634);
            CallChecker.varInit(m, "m", 534, 21756, 24634);
            CallChecker.varInit(this.blockColumns, "blockColumns", 534, 21756, 24634);
            CallChecker.varInit(this.blockRows, "blockRows", 534, 21756, 24634);
            CallChecker.varInit(this.columns, "columns", 534, 21756, 24634);
            CallChecker.varInit(this.rows, "rows", 534, 21756, 24634);
            CallChecker.varInit(this.blocks, "blocks", 534, 21756, 24634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 534, 21756, 24634);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 534, 21756, 24634);
            MatrixUtils.checkMultiplicationCompatible(this, m);
            m = CallChecker.beforeCalled(m, BlockRealMatrix.class, 539, 22239, 22239);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, CallChecker.isCalled(m, BlockRealMatrix.class, 539, 22239, 22239).columns), "out", 539, 22185, 22249);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 542, 22336, 22354);
            for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 543, 22394, 22396).blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 545, 22434, 22472);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 546, 22486, 22542);
                for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 548, 22587, 22589).blockColumns); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockRealMatrix.class, 549, 22652, 22654).blockWidth(jBlock))), "jWidth", 549, 22633, 22674);
                    final int jWidth2 = CallChecker.varInit(((int) (jWidth + jWidth)), "jWidth2", 550, 22692, 22728);
                    final int jWidth3 = CallChecker.varInit(((int) (jWidth2 + jWidth)), "jWidth3", 551, 22746, 22782);
                    final int jWidth4 = CallChecker.varInit(((int) (jWidth3 + jWidth)), "jWidth4", 552, 22800, 22836);
                    final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 555, 22921, 22923).blocks, double[][].class, 555, 22921, 22930)[blockIndex], "outBlock", 555, 22895, 22943);
                    for (int kBlock = 0; kBlock < (blockColumns); ++kBlock) {
                        final int kWidth = CallChecker.varInit(((int) (blockWidth(kBlock))), "kWidth", 559, 23097, 23134);
                        final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 560, 23180, 23185)[((iBlock * (blockColumns)) + kBlock)], "tBlock", 560, 23156, 23218);
                        m = CallChecker.beforeCalled(m, BlockRealMatrix.class, 561, 23264, 23264);
                        m = CallChecker.beforeCalled(m, BlockRealMatrix.class, 561, 23282, 23282);
                        final double[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockRealMatrix.class, 561, 23264, 23264).blocks, double[][].class, 561, 23264, 23271)[((kBlock * (CallChecker.isCalled(m, BlockRealMatrix.class, 561, 23282, 23282).blockColumns)) + jBlock)], "mBlock", 561, 23240, 23306);
                        int k = CallChecker.varInit(((int) (0)), "k", 562, 23328, 23337);
                        for (int p = pStart; p < pEnd; ++p) {
                            final int lStart = CallChecker.varInit(((int) ((p - pStart) * kWidth)), "lStart", 564, 23421, 23461);
                            final int lEnd = CallChecker.varInit(((int) (lStart + kWidth)), "lEnd", 565, 23487, 23519);
                            for (int nStart = 0; nStart < jWidth; ++nStart) {
                                double sum = CallChecker.varInit(((double) (0)), "sum", 567, 23623, 23637);
                                int l = CallChecker.varInit(((int) (lStart)), "l", 568, 23667, 23681);
                                int n = CallChecker.varInit(((int) (nStart)), "n", 569, 23711, 23725);
                                while (l < (lEnd - 3)) {
                                    if (CallChecker.beforeDeref(tBlock, double[].class, 571, 23817, 23822)) {
                                        if (CallChecker.beforeDeref(mBlock, double[].class, 571, 23829, 23834)) {
                                            if (CallChecker.beforeDeref(tBlock, double[].class, 572, 23880, 23885)) {
                                                if (CallChecker.beforeDeref(mBlock, double[].class, 572, 23896, 23901)) {
                                                    if (CallChecker.beforeDeref(tBlock, double[].class, 573, 23956, 23961)) {
                                                        if (CallChecker.beforeDeref(mBlock, double[].class, 573, 23972, 23977)) {
                                                            if (CallChecker.beforeDeref(tBlock, double[].class, 574, 24033, 24038)) {
                                                                if (CallChecker.beforeDeref(mBlock, double[].class, 574, 24049, 24054)) {
                                                                    sum += ((((CallChecker.isCalled(tBlock, double[].class, 571, 23817, 23822)[l]) * (CallChecker.isCalled(mBlock, double[].class, 571, 23829, 23834)[n])) + ((CallChecker.isCalled(tBlock, double[].class, 572, 23880, 23885)[(l + 1)]) * (CallChecker.isCalled(mBlock, double[].class, 572, 23896, 23901)[(n + jWidth)]))) + ((CallChecker.isCalled(tBlock, double[].class, 573, 23956, 23961)[(l + 2)]) * (CallChecker.isCalled(mBlock, double[].class, 573, 23972, 23977)[(n + jWidth2)]))) + ((CallChecker.isCalled(tBlock, double[].class, 574, 24033, 24038)[(l + 3)]) * (CallChecker.isCalled(mBlock, double[].class, 574, 24049, 24054)[(n + jWidth3)]));
                                                                    CallChecker.varAssign(sum, "sum", 571, 23810, 24068);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    l += 4;
                                    CallChecker.varAssign(l, "l", 575, 24102, 24108);
                                    n += jWidth4;
                                    CallChecker.varAssign(n, "n", 576, 24142, 24154);
                                } 
                                while (l < lEnd) {
                                    if (CallChecker.beforeDeref(tBlock, double[].class, 579, 24272, 24277)) {
                                        if (CallChecker.beforeDeref(mBlock, double[].class, 579, 24286, 24291)) {
                                            sum += (CallChecker.isCalled(tBlock, double[].class, 579, 24272, 24277)[(l++)]) * (CallChecker.isCalled(mBlock, double[].class, 579, 24286, 24291)[n]);
                                            CallChecker.varAssign(sum, "sum", 579, 24265, 24295);
                                        }
                                    }
                                    n += jWidth;
                                    CallChecker.varAssign(n, "n", 580, 24329, 24340);
                                } 
                                if (CallChecker.beforeDeref(outBlock, double[].class, 582, 24400, 24407)) {
                                    CallChecker.isCalled(outBlock, double[].class, 582, 24400, 24407)[k] += sum;
                                    CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 582, 24400, 24407)[k], "CallChecker.isCalled(outBlock, double[].class, 582, 24400, 24407)[k]", 582, 24400, 24418);
                                }
                                ++k;
                            }
                        }
                    }
                    ++blockIndex;
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1094.methodEnd();
        }
    }

    @Override
    public double[][] getData() {
        MethodContext _bcornu_methode_context1095 = new MethodContext(double[][].class, 597, 24641, 25766);
        try {
            CallChecker.varInit(this, "this", 597, 24641, 25766);
            CallChecker.varInit(this.blockColumns, "blockColumns", 597, 24641, 25766);
            CallChecker.varInit(this.blockRows, "blockRows", 597, 24641, 25766);
            CallChecker.varInit(this.columns, "columns", 597, 24641, 25766);
            CallChecker.varInit(this.rows, "rows", 597, 24641, 25766);
            CallChecker.varInit(this.blocks, "blocks", 597, 24641, 25766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 597, 24641, 25766);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 597, 24641, 25766);
            final double[][] data = CallChecker.varInit(new double[getRowDimension()][getColumnDimension()], "data", 598, 24718, 24793);
            final int lastColumns = CallChecker.varInit(((int) ((this.columns) - (((this.blockColumns) - 1) * (BlockRealMatrix.BLOCK_SIZE)))), "lastColumns", 599, 24803, 24868);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 602, 24944, 24982);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 603, 24996, 25052);
                int regularPos = CallChecker.varInit(((int) (0)), "regularPos", 604, 25066, 25084);
                int lastPos = CallChecker.varInit(((int) (0)), "lastPos", 605, 25098, 25113);
                for (int p = pStart; p < pEnd; ++p) {
                    final double[] dataP = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 607, 25204, 25207)[p], "dataP", 607, 25181, 25211);
                    int blockIndex = CallChecker.varInit(((int) (iBlock * (this.blockColumns))), "blockIndex", 608, 25229, 25267);
                    int dataPos = CallChecker.varInit(((int) (0)), "dataPos", 609, 25285, 25300);
                    for (int jBlock = 0; jBlock < ((blockColumns) - 1); ++jBlock) {
                        if (CallChecker.beforeDeref(blocks, double[][].class, 611, 25415, 25420)) {
                            System.arraycopy(CallChecker.isCalled(blocks, double[][].class, 611, 25415, 25420)[(blockIndex++)], regularPos, dataP, dataPos, BlockRealMatrix.BLOCK_SIZE);
                        }
                        dataPos += BlockRealMatrix.BLOCK_SIZE;
                        CallChecker.varAssign(dataPos, "dataPos", 612, 25498, 25519);
                    }
                    if (CallChecker.beforeDeref(blocks, double[][].class, 614, 25572, 25577)) {
                        System.arraycopy(CallChecker.isCalled(blocks, double[][].class, 614, 25572, 25577)[blockIndex], lastPos, dataP, dataPos, lastColumns);
                    }
                    regularPos += BlockRealMatrix.BLOCK_SIZE;
                    CallChecker.varAssign(regularPos, "regularPos", 615, 25647, 25671);
                    lastPos += lastColumns;
                    CallChecker.varAssign(lastPos, "lastPos", 616, 25689, 25714);
                }
            }
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1095.methodEnd();
        }
    }

    @Override
    public double getNorm() {
        MethodContext _bcornu_methode_context1096 = new MethodContext(double.class, 625, 25773, 26761);
        try {
            CallChecker.varInit(this, "this", 625, 25773, 26761);
            CallChecker.varInit(this.blockColumns, "blockColumns", 625, 25773, 26761);
            CallChecker.varInit(this.blockRows, "blockRows", 625, 25773, 26761);
            CallChecker.varInit(this.columns, "columns", 625, 25773, 26761);
            CallChecker.varInit(this.rows, "rows", 625, 25773, 26761);
            CallChecker.varInit(this.blocks, "blocks", 625, 25773, 26761);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 625, 25773, 26761);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 625, 25773, 26761);
            final double[] colSums = CallChecker.varInit(new double[BlockRealMatrix.BLOCK_SIZE], "colSums", 626, 25846, 25893);
            double maxColSum = CallChecker.varInit(((double) (0)), "maxColSum", 627, 25903, 25923);
            for (int jBlock = 0; jBlock < (blockColumns); jBlock++) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 629, 26001, 26038);
                Arrays.fill(colSums, 0, jWidth, 0.0);
                for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                    final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 632, 26171, 26210);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 633, 26251, 26256)[((iBlock * (blockColumns)) + jBlock)], "block", 633, 26228, 26289);
                    for (int j = 0; j < jWidth; ++j) {
                        double sum = CallChecker.varInit(((double) (0)), "sum", 635, 26362, 26376);
                        for (int i = 0; i < iHeight; ++i) {
                            if (CallChecker.beforeDeref(block, double[].class, 637, 26478, 26482)) {
                                sum += FastMath.abs(CallChecker.isCalled(block, double[].class, 637, 26478, 26482)[((i * jWidth) + j)]);
                                CallChecker.varAssign(sum, "sum", 637, 26458, 26500);
                            }
                        }
                        if (CallChecker.beforeDeref(colSums, double[].class, 639, 26544, 26550)) {
                            CallChecker.isCalled(colSums, double[].class, 639, 26544, 26550)[j] += sum;
                            CallChecker.varAssign(CallChecker.isCalled(colSums, double[].class, 639, 26544, 26550)[j], "CallChecker.isCalled(colSums, double[].class, 639, 26544, 26550)[j]", 639, 26544, 26561);
                        }
                    }
                }
                for (int j = 0; j < jWidth; ++j) {
                    if (CallChecker.beforeDeref(colSums, double[].class, 643, 26694, 26700)) {
                        maxColSum = FastMath.max(maxColSum, CallChecker.isCalled(colSums, double[].class, 643, 26694, 26700)[j]);
                        CallChecker.varAssign(maxColSum, "maxColSum", 643, 26658, 26705);
                    }
                }
            }
            return maxColSum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1096.methodEnd();
        }
    }

    @Override
    public double getFrobeniusNorm() {
        MethodContext _bcornu_methode_context1097 = new MethodContext(double.class, 651, 26768, 27107);
        try {
            CallChecker.varInit(this, "this", 651, 26768, 27107);
            CallChecker.varInit(this.blockColumns, "blockColumns", 651, 26768, 27107);
            CallChecker.varInit(this.blockRows, "blockRows", 651, 26768, 27107);
            CallChecker.varInit(this.columns, "columns", 651, 26768, 27107);
            CallChecker.varInit(this.rows, "rows", 651, 26768, 27107);
            CallChecker.varInit(this.blocks, "blocks", 651, 26768, 27107);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 651, 26768, 27107);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 651, 26768, 27107);
            double sum2 = CallChecker.varInit(((double) (0)), "sum2", 652, 26850, 26865);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(blocks, double[][].class, 653, 26913, 26918).length); ++blockIndex) {
                for (final double entry : CallChecker.isCalled(blocks, double[][].class, 654, 26982, 26987)[blockIndex]) {
                    sum2 += entry * entry;
                    CallChecker.varAssign(sum2, "sum2", 655, 27020, 27041);
                }
            }
            return FastMath.sqrt(sum2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1097.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix getSubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1098 = new MethodContext(BlockRealMatrix.class, 663, 27114, 32330);
        try {
            CallChecker.varInit(this, "this", 663, 27114, 32330);
            CallChecker.varInit(endColumn, "endColumn", 663, 27114, 32330);
            CallChecker.varInit(startColumn, "startColumn", 663, 27114, 32330);
            CallChecker.varInit(endRow, "endRow", 663, 27114, 32330);
            CallChecker.varInit(startRow, "startRow", 663, 27114, 32330);
            CallChecker.varInit(this.blockColumns, "blockColumns", 663, 27114, 32330);
            CallChecker.varInit(this.blockRows, "blockRows", 663, 27114, 32330);
            CallChecker.varInit(this.columns, "columns", 663, 27114, 32330);
            CallChecker.varInit(this.rows, "rows", 663, 27114, 32330);
            CallChecker.varInit(this.blocks, "blocks", 663, 27114, 32330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 663, 27114, 32330);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 663, 27114, 32330);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(((endRow - startRow) + 1), ((endColumn - startColumn) + 1)), "out", 671, 27538, 27685);
            final int blockStartRow = CallChecker.varInit(((int) (startRow / (BlockRealMatrix.BLOCK_SIZE))), "blockStartRow", 675, 27696, 27776);
            final int rowsShift = CallChecker.varInit(((int) (startRow % (BlockRealMatrix.BLOCK_SIZE))), "rowsShift", 676, 27786, 27829);
            final int blockStartColumn = CallChecker.varInit(((int) (startColumn / (BlockRealMatrix.BLOCK_SIZE))), "blockStartColumn", 677, 27839, 27892);
            final int columnsShift = CallChecker.varInit(((int) (startColumn % (BlockRealMatrix.BLOCK_SIZE))), "columnsShift", 678, 27902, 27951);
            int pBlock = CallChecker.varInit(((int) (blockStartRow)), "pBlock", 681, 28034, 28060);
            for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 682, 28100, 28102).blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockRealMatrix.class, 683, 28159, 28161).blockHeight(iBlock))), "iHeight", 683, 28139, 28182);
                int qBlock = CallChecker.varInit(((int) (blockStartColumn)), "qBlock", 684, 28196, 28225);
                for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockRealMatrix.class, 685, 28269, 28271).blockColumns); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockRealMatrix.class, 686, 28334, 28336).blockWidth(jBlock))), "jWidth", 686, 28315, 28356);
                    final int outIndex = CallChecker.varInit(((int) ((iBlock * (CallChecker.isCalled(out, BlockRealMatrix.class, 689, 28462, 28464).blockColumns)) + jBlock)), "outIndex", 689, 28375, 28487);
                    final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 690, 28531, 28533).blocks, double[][].class, 690, 28531, 28540)[outIndex], "outBlock", 690, 28505, 28551);
                    final int index = CallChecker.varInit(((int) ((pBlock * (this.blockColumns)) + qBlock)), "index", 691, 28569, 28617);
                    final int width = CallChecker.varInit(((int) (blockWidth(qBlock))), "width", 692, 28635, 28671);
                    final int heightExcess = CallChecker.varInit(((int) ((iHeight + rowsShift) - (BlockRealMatrix.BLOCK_SIZE))), "heightExcess", 694, 28690, 28747);
                    final int widthExcess = CallChecker.varInit(((int) ((jWidth + columnsShift) - (BlockRealMatrix.BLOCK_SIZE))), "widthExcess", 695, 28765, 28823);
                    if (heightExcess > 0) {
                        if (widthExcess > 0) {
                            final int width2 = CallChecker.varInit(((int) (blockWidth((qBlock + 1)))), "width2", 700, 29025, 29166);
                            if (CallChecker.beforeDeref(blocks, double[][].class, 701, 29206, 29211)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 701, 29206, 29211)[index], width, rowsShift, BlockRealMatrix.BLOCK_SIZE, columnsShift, BlockRealMatrix.BLOCK_SIZE, outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, double[][].class, 705, 29454, 29459)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 705, 29454, 29459)[(index + 1)], width2, rowsShift, BlockRealMatrix.BLOCK_SIZE, 0, widthExcess, outBlock, jWidth, 0, (jWidth - widthExcess));
                            }
                            if (CallChecker.beforeDeref(blocks, double[][].class, 709, 29716, 29721)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 709, 29716, 29721)[(index + (blockColumns))], width, 0, heightExcess, columnsShift, BlockRealMatrix.BLOCK_SIZE, outBlock, jWidth, (iHeight - heightExcess), 0);
                            }
                            if (CallChecker.beforeDeref(blocks, double[][].class, 713, 29994, 29999)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 713, 29994, 29999)[((index + (blockColumns)) + 1)], width2, 0, heightExcess, 0, widthExcess, outBlock, jWidth, (iHeight - heightExcess), (jWidth - widthExcess));
                            }
                        }else {
                            if (CallChecker.beforeDeref(blocks, double[][].class, 719, 30413, 30418)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 719, 30413, 30418)[index], width, rowsShift, BlockRealMatrix.BLOCK_SIZE, columnsShift, (jWidth + columnsShift), outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, double[][].class, 723, 30672, 30677)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 723, 30672, 30677)[(index + (blockColumns))], width, 0, heightExcess, columnsShift, (jWidth + columnsShift), outBlock, jWidth, (iHeight - heightExcess), 0);
                            }
                        }
                    }else {
                        if (widthExcess > 0) {
                            final int width2 = CallChecker.varInit(((int) (blockWidth((qBlock + 1)))), "width2", 732, 31128, 31269);
                            if (CallChecker.beforeDeref(blocks, double[][].class, 733, 31309, 31314)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 733, 31309, 31314)[index], width, rowsShift, (iHeight + rowsShift), columnsShift, BlockRealMatrix.BLOCK_SIZE, outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, double[][].class, 737, 31566, 31571)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 737, 31566, 31571)[(index + 1)], width2, rowsShift, (iHeight + rowsShift), 0, widthExcess, outBlock, jWidth, 0, (jWidth - widthExcess));
                            }
                        }else {
                            if (CallChecker.beforeDeref(blocks, double[][].class, 743, 31964, 31969)) {
                                copyBlockPart(CallChecker.isCalled(blocks, double[][].class, 743, 31964, 31969)[index], width, rowsShift, (iHeight + rowsShift), columnsShift, (jWidth + columnsShift), outBlock, jWidth, 0, 0);
                            }
                        }
                    }
                    ++qBlock;
                }
                ++pBlock;
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1098.methodEnd();
        }
    }

    private void copyBlockPart(final double[] srcBlock, final int srcWidth, final int srcStartRow, final int srcEndRow, final int srcStartColumn, final int srcEndColumn, final double[] dstBlock, final int dstWidth, final int dstStartRow, final int dstStartColumn) {
        MethodContext _bcornu_methode_context1099 = new MethodContext(void.class, 772, 32337, 33930);
        try {
            CallChecker.varInit(this, "this", 772, 32337, 33930);
            CallChecker.varInit(dstStartColumn, "dstStartColumn", 772, 32337, 33930);
            CallChecker.varInit(dstStartRow, "dstStartRow", 772, 32337, 33930);
            CallChecker.varInit(dstWidth, "dstWidth", 772, 32337, 33930);
            CallChecker.varInit(dstBlock, "dstBlock", 772, 32337, 33930);
            CallChecker.varInit(srcEndColumn, "srcEndColumn", 772, 32337, 33930);
            CallChecker.varInit(srcStartColumn, "srcStartColumn", 772, 32337, 33930);
            CallChecker.varInit(srcEndRow, "srcEndRow", 772, 32337, 33930);
            CallChecker.varInit(srcStartRow, "srcStartRow", 772, 32337, 33930);
            CallChecker.varInit(srcWidth, "srcWidth", 772, 32337, 33930);
            CallChecker.varInit(srcBlock, "srcBlock", 772, 32337, 33930);
            CallChecker.varInit(this.blockColumns, "blockColumns", 772, 32337, 33930);
            CallChecker.varInit(this.blockRows, "blockRows", 772, 32337, 33930);
            CallChecker.varInit(this.columns, "columns", 772, 32337, 33930);
            CallChecker.varInit(this.rows, "rows", 772, 32337, 33930);
            CallChecker.varInit(this.blocks, "blocks", 772, 32337, 33930);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 772, 32337, 33930);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 772, 32337, 33930);
            final int length = CallChecker.varInit(((int) (srcEndColumn - srcStartColumn)), "length", 777, 33533, 33581);
            int srcPos = CallChecker.varInit(((int) ((srcStartRow * srcWidth) + srcStartColumn)), "srcPos", 778, 33591, 33643);
            int dstPos = CallChecker.varInit(((int) ((dstStartRow * dstWidth) + dstStartColumn)), "dstPos", 779, 33653, 33705);
            for (int srcRow = srcStartRow; srcRow < srcEndRow; ++srcRow) {
                System.arraycopy(srcBlock, srcPos, dstBlock, dstPos, length);
                srcPos += srcWidth;
                CallChecker.varAssign(srcPos, "srcPos", 782, 33864, 33882);
                dstPos += dstWidth;
                CallChecker.varAssign(dstPos, "dstPos", 783, 33896, 33914);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1099.methodEnd();
        }
    }

    @Override
    public void setSubMatrix(final double[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context1100 = new MethodContext(void.class, 789, 33937, 36355);
        try {
            CallChecker.varInit(this, "this", 789, 33937, 36355);
            CallChecker.varInit(column, "column", 789, 33937, 36355);
            CallChecker.varInit(row, "row", 789, 33937, 36355);
            CallChecker.varInit(subMatrix, "subMatrix", 789, 33937, 36355);
            CallChecker.varInit(this.blockColumns, "blockColumns", 789, 33937, 36355);
            CallChecker.varInit(this.blockRows, "blockRows", 789, 33937, 36355);
            CallChecker.varInit(this.columns, "columns", 789, 33937, 36355);
            CallChecker.varInit(this.rows, "rows", 789, 33937, 36355);
            CallChecker.varInit(this.blocks, "blocks", 789, 33937, 36355);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 789, 33937, 36355);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 789, 33937, 36355);
            MathUtils.checkNotNull(subMatrix);
            CallChecker.isCalled(subMatrix, double[][].class, 795, 34302, 34310)[0] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, double[][].class, 795, 34302, 34310)[0], double[].class, 795, 34302, 34313);
            final int refLength = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(subMatrix, double[][].class, 795, 34302, 34310)[0], double[].class, 795, 34302, 34313).length)), "refLength", 795, 34280, 34321);
            if (refLength == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            final int endRow = CallChecker.varInit(((int) ((row + (CallChecker.isCalled(subMatrix, double[][].class, 799, 34473, 34481).length)) - 1)), "endRow", 799, 34448, 34493);
            final int endColumn = CallChecker.varInit(((int) ((column + refLength) - 1)), "endColumn", 800, 34503, 34547);
            MatrixUtils.checkSubMatrixIndex(this, row, endRow, column, endColumn);
            if (CallChecker.beforeDeref(subMatrix, void.class, 802, 34665, 34673)) {
                for (final double[] subRow : subMatrix) {
                    if (CallChecker.beforeDeref(subRow, double[].class, 803, 34694, 34699)) {
                        if ((CallChecker.isCalled(subRow, double[].class, 803, 34694, 34699).length) != refLength) {
                            if (CallChecker.beforeDeref(subRow, double[].class, 804, 34788, 34793)) {
                                throw new DimensionMismatchException(refLength, CallChecker.isCalled(subRow, double[].class, 804, 34788, 34793).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }
            final int blockStartRow = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "blockStartRow", 809, 34837, 34912);
            final int blockEndRow = CallChecker.varInit(((int) ((endRow + (BlockRealMatrix.BLOCK_SIZE)) / (BlockRealMatrix.BLOCK_SIZE))), "blockEndRow", 810, 34922, 34980);
            final int blockStartColumn = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "blockStartColumn", 811, 34990, 35038);
            final int blockEndColumn = CallChecker.varInit(((int) ((endColumn + (BlockRealMatrix.BLOCK_SIZE)) / (BlockRealMatrix.BLOCK_SIZE))), "blockEndColumn", 812, 35048, 35112);
            for (int iBlock = blockStartRow; iBlock < blockEndRow; ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 816, 35268, 35307);
                final int firstRow = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "firstRow", 817, 35321, 35361);
                final int iStart = CallChecker.varInit(((int) (FastMath.max(row, firstRow))), "iStart", 818, 35375, 35424);
                final int iEnd = CallChecker.varInit(((int) (FastMath.min((endRow + 1), (firstRow + iHeight)))), "iEnd", 819, 35438, 35499);
                for (int jBlock = blockStartColumn; jBlock < blockEndColumn; ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 822, 35603, 35640);
                    final int firstColumn = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "firstColumn", 823, 35658, 35701);
                    final int jStart = CallChecker.varInit(((int) (FastMath.max(column, firstColumn))), "jStart", 824, 35719, 35774);
                    final int jEnd = CallChecker.varInit(((int) (FastMath.min((endColumn + 1), (firstColumn + jWidth)))), "jEnd", 825, 35792, 35858);
                    final int jLength = CallChecker.varInit(((int) (jEnd - jStart)), "jLength", 826, 35876, 35909);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 829, 35999, 36004)[((iBlock * (blockColumns)) + jBlock)], "block", 829, 35976, 36037);
                    for (int i = iStart; i < iEnd; ++i) {
                        if (CallChecker.beforeDeref(subMatrix, double[][].class, 831, 36130, 36138)) {
                            System.arraycopy(CallChecker.isCalled(subMatrix, double[][].class, 831, 36130, 36138)[(i - row)], (jStart - column), block, (((i - firstRow) * jWidth) + (jStart - firstColumn)), jLength);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1100.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix getRowMatrix(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1101 = new MethodContext(BlockRealMatrix.class, 842, 36362, 37639);
        try {
            CallChecker.varInit(this, "this", 842, 36362, 37639);
            CallChecker.varInit(row, "row", 842, 36362, 37639);
            CallChecker.varInit(this.blockColumns, "blockColumns", 842, 36362, 37639);
            CallChecker.varInit(this.blockRows, "blockRows", 842, 36362, 37639);
            CallChecker.varInit(this.columns, "columns", 842, 36362, 37639);
            CallChecker.varInit(this.rows, "rows", 842, 36362, 37639);
            CallChecker.varInit(this.blocks, "blocks", 842, 36362, 37639);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 842, 36362, 37639);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 842, 36362, 37639);
            MatrixUtils.checkRowIndex(this, row);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(1, columns), "out", 845, 36543, 36602);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 848, 36613, 36714);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockRealMatrix.BLOCK_SIZE)))), "iRow", 849, 36724, 36766);
            int outBlockIndex = CallChecker.varInit(((int) (0)), "outBlockIndex", 850, 36776, 36797);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 851, 36807, 36823);
            double[] outBlock = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(out, BlockRealMatrix.class, 852, 36853, 36855)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockRealMatrix.class, 852, 36853, 36855).blocks, double[][].class, 852, 36853, 36862)) {
                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 852, 36853, 36855).blocks, double[][].class, 852, 36853, 36862)[outBlockIndex];
                    CallChecker.varAssign(outBlock, "outBlock", 852, 36853, 36855);
                }
            }
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 854, 36956, 36993);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 855, 37030, 37035)[((iBlock * (blockColumns)) + jBlock)], "block", 855, 37007, 37068);
                outBlock = CallChecker.beforeCalled(outBlock, double[].class, 856, 37104, 37111);
                final int available = CallChecker.varInit(((int) ((CallChecker.isCalled(outBlock, double[].class, 856, 37104, 37111).length) - outIndex)), "available", 856, 37082, 37130);
                if (jWidth > available) {
                    System.arraycopy(block, (iRow * jWidth), outBlock, outIndex, available);
                    if (CallChecker.beforeDeref(out, BlockRealMatrix.class, 859, 37284, 37286)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockRealMatrix.class, 859, 37284, 37286).blocks, double[][].class, 859, 37284, 37293)) {
                            outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 859, 37284, 37286).blocks, double[][].class, 859, 37284, 37293)[(++outBlockIndex)];
                            CallChecker.varAssign(outBlock, "outBlock", 859, 37273, 37311);
                        }
                    }
                    System.arraycopy(block, (iRow * jWidth), outBlock, 0, (jWidth - available));
                    outIndex = jWidth - available;
                    CallChecker.varAssign(outIndex, "outIndex", 861, 37418, 37447);
                }else {
                    System.arraycopy(block, (iRow * jWidth), outBlock, outIndex, jWidth);
                    outIndex += jWidth;
                    CallChecker.varAssign(outIndex, "outIndex", 864, 37570, 37588);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1101.methodEnd();
        }
    }

    @Override
    public void setRowMatrix(final int row, final RealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1102 = new MethodContext(void.class, 873, 37646, 37994);
        try {
            CallChecker.varInit(this, "this", 873, 37646, 37994);
            CallChecker.varInit(matrix, "matrix", 873, 37646, 37994);
            CallChecker.varInit(row, "row", 873, 37646, 37994);
            CallChecker.varInit(this.blockColumns, "blockColumns", 873, 37646, 37994);
            CallChecker.varInit(this.blockRows, "blockRows", 873, 37646, 37994);
            CallChecker.varInit(this.columns, "columns", 873, 37646, 37994);
            CallChecker.varInit(this.rows, "rows", 873, 37646, 37994);
            CallChecker.varInit(this.blocks, "blocks", 873, 37646, 37994);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 873, 37646, 37994);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 873, 37646, 37994);
            TryContext _bcornu_try_context_17 = new TryContext(17, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                setRowMatrix(row, ((BlockRealMatrix) (matrix)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_17.catchStart(17);
                super.setRowMatrix(row, matrix);
            } finally {
                _bcornu_try_context_17.finallyStart(17);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1102.methodEnd();
        }
    }

    public void setRowMatrix(final int row, final BlockRealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1103 = new MethodContext(void.class, 893, 38001, 40022);
        try {
            CallChecker.varInit(this, "this", 893, 38001, 40022);
            CallChecker.varInit(matrix, "matrix", 893, 38001, 40022);
            CallChecker.varInit(row, "row", 893, 38001, 40022);
            CallChecker.varInit(this.blockColumns, "blockColumns", 893, 38001, 40022);
            CallChecker.varInit(this.blockRows, "blockRows", 893, 38001, 40022);
            CallChecker.varInit(this.columns, "columns", 893, 38001, 40022);
            CallChecker.varInit(this.rows, "rows", 893, 38001, 40022);
            CallChecker.varInit(this.blocks, "blocks", 893, 38001, 40022);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 893, 38001, 40022);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 893, 38001, 40022);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 896, 38650, 38688);
            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 897, 38703, 38708)) {
                if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 898, 38750, 38755)) {
                    if (((CallChecker.isCalled(matrix, BlockRealMatrix.class, 897, 38703, 38708).getRowDimension()) != 1) || ((CallChecker.isCalled(matrix, BlockRealMatrix.class, 898, 38750, 38755).getColumnDimension()) != nCols)) {
                        if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 899, 38846, 38851)) {
                            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 900, 38927, 38932)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, BlockRealMatrix.class, 899, 38846, 38851).getRowDimension(), CallChecker.isCalled(matrix, BlockRealMatrix.class, 900, 38927, 38932).getColumnDimension(), 1, nCols);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 905, 39041, 39142);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockRealMatrix.BLOCK_SIZE)))), "iRow", 906, 39152, 39194);
            int mBlockIndex = CallChecker.varInit(((int) (0)), "mBlockIndex", 907, 39204, 39223);
            int mIndex = CallChecker.varInit(((int) (0)), "mIndex", 908, 39233, 39247);
            double[] mBlock = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 909, 39275, 39280)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockRealMatrix.class, 909, 39275, 39280).blocks, double[][].class, 909, 39275, 39287)) {
                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockRealMatrix.class, 909, 39275, 39280).blocks, double[][].class, 909, 39275, 39287)[mBlockIndex];
                    CallChecker.varAssign(mBlock, "mBlock", 909, 39275, 39280);
                }
            }
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 911, 39379, 39416);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 912, 39453, 39458)[((iBlock * (blockColumns)) + jBlock)], "block", 912, 39430, 39491);
                mBlock = CallChecker.beforeCalled(mBlock, double[].class, 913, 39528, 39533);
                final int available = CallChecker.varInit(((int) ((CallChecker.isCalled(mBlock, double[].class, 913, 39528, 39533).length) - mIndex)), "available", 913, 39505, 39550);
                if (jWidth > available) {
                    System.arraycopy(mBlock, mIndex, block, (iRow * jWidth), available);
                    if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 916, 39698, 39703)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockRealMatrix.class, 916, 39698, 39703).blocks, double[][].class, 916, 39698, 39710)) {
                            mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockRealMatrix.class, 916, 39698, 39703).blocks, double[][].class, 916, 39698, 39710)[(++mBlockIndex)];
                            CallChecker.varAssign(mBlock, "mBlock", 916, 39689, 39726);
                        }
                    }
                    System.arraycopy(mBlock, 0, block, (iRow * jWidth), (jWidth - available));
                    mIndex = jWidth - available;
                    CallChecker.varAssign(mIndex, "mIndex", 918, 39831, 39858);
                }else {
                    System.arraycopy(mBlock, mIndex, block, (iRow * jWidth), jWidth);
                    mIndex += jWidth;
                    CallChecker.varAssign(mIndex, "mIndex", 921, 39977, 39993);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1103.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix getColumnMatrix(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1104 = new MethodContext(BlockRealMatrix.class, 928, 40029, 41129);
        try {
            CallChecker.varInit(this, "this", 928, 40029, 41129);
            CallChecker.varInit(column, "column", 928, 40029, 41129);
            CallChecker.varInit(this.blockColumns, "blockColumns", 928, 40029, 41129);
            CallChecker.varInit(this.blockRows, "blockRows", 928, 40029, 41129);
            CallChecker.varInit(this.columns, "columns", 928, 40029, 41129);
            CallChecker.varInit(this.rows, "rows", 928, 40029, 41129);
            CallChecker.varInit(this.blocks, "blocks", 928, 40029, 41129);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 928, 40029, 41129);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 928, 40029, 41129);
            MatrixUtils.checkColumnIndex(this, column);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(rows, 1), "out", 931, 40222, 40278);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 934, 40289, 40393);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE)))), "jColumn", 935, 40403, 40451);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 936, 40461, 40498);
            int outBlockIndex = CallChecker.varInit(((int) (0)), "outBlockIndex", 937, 40508, 40529);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 938, 40539, 40555);
            double[] outBlock = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(out, BlockRealMatrix.class, 939, 40585, 40587)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockRealMatrix.class, 939, 40585, 40587).blocks, double[][].class, 939, 40585, 40594)) {
                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 939, 40585, 40587).blocks, double[][].class, 939, 40585, 40594)[outBlockIndex];
                    CallChecker.varAssign(outBlock, "outBlock", 939, 40585, 40587);
                }
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 941, 40685, 40724);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 942, 40761, 40766)[((iBlock * (blockColumns)) + jBlock)], "block", 942, 40738, 40799);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(outBlock, double[].class, 944, 40881, 40888)) {
                        outBlock = CallChecker.beforeCalled(outBlock, double[].class, 944, 40881, 40888);
                        if (outIndex >= (CallChecker.isCalled(outBlock, double[].class, 944, 40881, 40888).length)) {
                            if (CallChecker.beforeDeref(out, BlockRealMatrix.class, 945, 40931, 40933)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockRealMatrix.class, 945, 40931, 40933).blocks, double[][].class, 945, 40931, 40940)) {
                                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 945, 40931, 40933).blocks, double[][].class, 945, 40931, 40940)[(++outBlockIndex)];
                                    CallChecker.varAssign(outBlock, "outBlock", 945, 40920, 40958);
                                }
                            }
                            outIndex = 0;
                            CallChecker.varAssign(outIndex, "outIndex", 946, 40980, 40992);
                        }
                    }
                    if (CallChecker.beforeDeref(outBlock, double[].class, 948, 41028, 41035)) {
                        if (CallChecker.beforeDeref(block, double[].class, 948, 41051, 41055)) {
                            outBlock = CallChecker.beforeCalled(outBlock, double[].class, 948, 41028, 41035);
                            CallChecker.isCalled(outBlock, double[].class, 948, 41028, 41035)[(outIndex++)] = CallChecker.isCalled(block, double[].class, 948, 41051, 41055)[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 948, 41028, 41035)[(outIndex - 1)], "CallChecker.isCalled(outBlock, double[].class, 948, 41028, 41035)[(outIndex - 1)]", 948, 41028, 41078);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1104.methodEnd();
        }
    }

    @Override
    public void setColumnMatrix(final int column, final RealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1105 = new MethodContext(void.class, 957, 41136, 41502);
        try {
            CallChecker.varInit(this, "this", 957, 41136, 41502);
            CallChecker.varInit(matrix, "matrix", 957, 41136, 41502);
            CallChecker.varInit(column, "column", 957, 41136, 41502);
            CallChecker.varInit(this.blockColumns, "blockColumns", 957, 41136, 41502);
            CallChecker.varInit(this.blockRows, "blockRows", 957, 41136, 41502);
            CallChecker.varInit(this.columns, "columns", 957, 41136, 41502);
            CallChecker.varInit(this.rows, "rows", 957, 41136, 41502);
            CallChecker.varInit(this.blocks, "blocks", 957, 41136, 41502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 957, 41136, 41502);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 957, 41136, 41502);
            TryContext _bcornu_try_context_18 = new TryContext(18, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                setColumnMatrix(column, ((BlockRealMatrix) (matrix)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_18.catchStart(18);
                super.setColumnMatrix(column, matrix);
            } finally {
                _bcornu_try_context_18.finallyStart(18);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1105.methodEnd();
        }
    }

    void setColumnMatrix(final int column, final BlockRealMatrix matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1106 = new MethodContext(void.class, 977, 41509, 43381);
        try {
            CallChecker.varInit(this, "this", 977, 41509, 43381);
            CallChecker.varInit(matrix, "matrix", 977, 41509, 43381);
            CallChecker.varInit(column, "column", 977, 41509, 43381);
            CallChecker.varInit(this.blockColumns, "blockColumns", 977, 41509, 43381);
            CallChecker.varInit(this.blockRows, "blockRows", 977, 41509, 43381);
            CallChecker.varInit(this.columns, "columns", 977, 41509, 43381);
            CallChecker.varInit(this.rows, "rows", 977, 41509, 43381);
            CallChecker.varInit(this.blocks, "blocks", 977, 41509, 43381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 977, 41509, 43381);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 977, 41509, 43381);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 980, 42190, 42225);
            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 981, 42240, 42245)) {
                if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 982, 42291, 42296)) {
                    if (((CallChecker.isCalled(matrix, BlockRealMatrix.class, 981, 42240, 42245).getRowDimension()) != nRows) || ((CallChecker.isCalled(matrix, BlockRealMatrix.class, 982, 42291, 42296).getColumnDimension()) != 1)) {
                        if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 983, 42383, 42388)) {
                            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 984, 42464, 42469)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, BlockRealMatrix.class, 983, 42383, 42388).getRowDimension(), CallChecker.isCalled(matrix, BlockRealMatrix.class, 984, 42464, 42469).getColumnDimension(), nRows, 1);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 989, 42578, 42682);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE)))), "jColumn", 990, 42692, 42740);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 991, 42750, 42787);
            int mBlockIndex = CallChecker.varInit(((int) (0)), "mBlockIndex", 992, 42797, 42816);
            int mIndex = CallChecker.varInit(((int) (0)), "mIndex", 993, 42826, 42840);
            double[] mBlock = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 994, 42868, 42873)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockRealMatrix.class, 994, 42868, 42873).blocks, double[][].class, 994, 42868, 42880)) {
                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockRealMatrix.class, 994, 42868, 42873).blocks, double[][].class, 994, 42868, 42880)[mBlockIndex];
                    CallChecker.varAssign(mBlock, "mBlock", 994, 42868, 42873);
                }
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 996, 42969, 43008);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 997, 43045, 43050)[((iBlock * (blockColumns)) + jBlock)], "block", 997, 43022, 43083);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(mBlock, double[].class, 999, 43163, 43168)) {
                        mBlock = CallChecker.beforeCalled(mBlock, double[].class, 999, 43163, 43168);
                        if (mIndex >= (CallChecker.isCalled(mBlock, double[].class, 999, 43163, 43168).length)) {
                            if (CallChecker.beforeDeref(matrix, BlockRealMatrix.class, 1000, 43209, 43214)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockRealMatrix.class, 1000, 43209, 43214).blocks, double[][].class, 1000, 43209, 43221)) {
                                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockRealMatrix.class, 1000, 43209, 43214).blocks, double[][].class, 1000, 43209, 43221)[(++mBlockIndex)];
                                    CallChecker.varAssign(mBlock, "mBlock", 1000, 43200, 43237);
                                }
                            }
                            mIndex = 0;
                            CallChecker.varAssign(mIndex, "mIndex", 1001, 43259, 43269);
                        }
                    }
                    if (CallChecker.beforeDeref(block, double[].class, 1003, 43305, 43309)) {
                        if (CallChecker.beforeDeref(mBlock, double[].class, 1003, 43335, 43340)) {
                            mBlock = CallChecker.beforeCalled(mBlock, double[].class, 1003, 43335, 43340);
                            CallChecker.isCalled(block, double[].class, 1003, 43305, 43309)[((i * jWidth) + jColumn)] = CallChecker.isCalled(mBlock, double[].class, 1003, 43335, 43340)[(mIndex++)];
                            CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1003, 43305, 43309)[((i * jWidth) + jColumn)], "CallChecker.isCalled(block, double[].class, 1003, 43305, 43309)[((i * jWidth) + jColumn)]", 1003, 43305, 43351);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1106.methodEnd();
        }
    }

    @Override
    public RealVector getRowVector(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1107 = new MethodContext(RealVector.class, 1010, 43388, 44168);
        try {
            CallChecker.varInit(this, "this", 1010, 43388, 44168);
            CallChecker.varInit(row, "row", 1010, 43388, 44168);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1010, 43388, 44168);
            CallChecker.varInit(this.blockRows, "blockRows", 1010, 43388, 44168);
            CallChecker.varInit(this.columns, "columns", 1010, 43388, 44168);
            CallChecker.varInit(this.rows, "rows", 1010, 43388, 44168);
            CallChecker.varInit(this.blocks, "blocks", 1010, 43388, 44168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1010, 43388, 44168);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1010, 43388, 44168);
            MatrixUtils.checkRowIndex(this, row);
            final double[] outData = CallChecker.varInit(new double[columns], "outData", 1013, 43564, 43608);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1016, 43619, 43720);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockRealMatrix.BLOCK_SIZE)))), "iRow", 1017, 43730, 43772);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1018, 43782, 43798);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1020, 43876, 43913);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1021, 43950, 43955)[((iBlock * (blockColumns)) + jBlock)], "block", 1021, 43927, 43988);
                System.arraycopy(block, (iRow * jWidth), outData, outIndex, jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1023, 44081, 44099);
            }
            return new ArrayRealVector(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1107.methodEnd();
        }
    }

    @Override
    public void setRowVector(final int row, final RealVector vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1108 = new MethodContext(void.class, 1031, 44175, 44532);
        try {
            CallChecker.varInit(this, "this", 1031, 44175, 44532);
            CallChecker.varInit(vector, "vector", 1031, 44175, 44532);
            CallChecker.varInit(row, "row", 1031, 44175, 44532);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1031, 44175, 44532);
            CallChecker.varInit(this.blockRows, "blockRows", 1031, 44175, 44532);
            CallChecker.varInit(this.columns, "columns", 1031, 44175, 44532);
            CallChecker.varInit(this.rows, "rows", 1031, 44175, 44532);
            CallChecker.varInit(this.blocks, "blocks", 1031, 44175, 44532);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1031, 44175, 44532);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1031, 44175, 44532);
            TryContext _bcornu_try_context_19 = new TryContext(19, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(vector, RealVector.class, 1034, 44407, 44412)) {
                    setRow(row, CallChecker.isCalled(((ArrayRealVector) (vector)), ArrayRealVector.class, 1034, 44407, 44412).getDataRef());
                }
            } catch (ClassCastException cce) {
                _bcornu_try_context_19.catchStart(19);
                super.setRowVector(row, vector);
            } finally {
                _bcornu_try_context_19.finallyStart(19);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1108.methodEnd();
        }
    }

    @Override
    public RealVector getColumnVector(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1109 = new MethodContext(RealVector.class, 1042, 44539, 45401);
        try {
            CallChecker.varInit(this, "this", 1042, 44539, 45401);
            CallChecker.varInit(column, "column", 1042, 44539, 45401);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1042, 44539, 45401);
            CallChecker.varInit(this.blockRows, "blockRows", 1042, 44539, 45401);
            CallChecker.varInit(this.columns, "columns", 1042, 44539, 45401);
            CallChecker.varInit(this.rows, "rows", 1042, 44539, 45401);
            CallChecker.varInit(this.blocks, "blocks", 1042, 44539, 45401);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1042, 44539, 45401);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1042, 44539, 45401);
            MatrixUtils.checkColumnIndex(this, column);
            final double[] outData = CallChecker.varInit(new double[rows], "outData", 1045, 44727, 44768);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1048, 44779, 44883);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE)))), "jColumn", 1049, 44893, 44941);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1050, 44951, 44988);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1051, 44998, 45014);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1053, 45089, 45128);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1054, 45165, 45170)[((iBlock * (blockColumns)) + jBlock)], "block", 1054, 45142, 45203);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(outData, double[].class, 1056, 45269, 45275)) {
                        if (CallChecker.beforeDeref(block, double[].class, 1056, 45291, 45295)) {
                            CallChecker.isCalled(outData, double[].class, 1056, 45269, 45275)[(outIndex++)] = CallChecker.isCalled(block, double[].class, 1056, 45291, 45295)[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(CallChecker.isCalled(outData, double[].class, 1056, 45269, 45275)[(outIndex - 1)], "CallChecker.isCalled(outData, double[].class, 1056, 45269, 45275)[(outIndex - 1)]", 1056, 45269, 45318);
                        }
                    }
                }
            }
            return new ArrayRealVector(outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1109.methodEnd();
        }
    }

    @Override
    public void setColumnVector(final int column, final RealVector vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1110 = new MethodContext(void.class, 1065, 45408, 45783);
        try {
            CallChecker.varInit(this, "this", 1065, 45408, 45783);
            CallChecker.varInit(vector, "vector", 1065, 45408, 45783);
            CallChecker.varInit(column, "column", 1065, 45408, 45783);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1065, 45408, 45783);
            CallChecker.varInit(this.blockRows, "blockRows", 1065, 45408, 45783);
            CallChecker.varInit(this.columns, "columns", 1065, 45408, 45783);
            CallChecker.varInit(this.rows, "rows", 1065, 45408, 45783);
            CallChecker.varInit(this.blocks, "blocks", 1065, 45408, 45783);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1065, 45408, 45783);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1065, 45408, 45783);
            TryContext _bcornu_try_context_20 = new TryContext(20, BlockRealMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(vector, RealVector.class, 1068, 45652, 45657)) {
                    setColumn(column, CallChecker.isCalled(((ArrayRealVector) (vector)), ArrayRealVector.class, 1068, 45652, 45657).getDataRef());
                }
            } catch (ClassCastException cce) {
                _bcornu_try_context_20.catchStart(20);
                super.setColumnVector(column, vector);
            } finally {
                _bcornu_try_context_20.finallyStart(20);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1110.methodEnd();
        }
    }

    @Override
    public double[] getRow(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1111 = new MethodContext(double[].class, 1076, 45790, 46518);
        try {
            CallChecker.varInit(this, "this", 1076, 45790, 46518);
            CallChecker.varInit(row, "row", 1076, 45790, 46518);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1076, 45790, 46518);
            CallChecker.varInit(this.blockRows, "blockRows", 1076, 45790, 46518);
            CallChecker.varInit(this.columns, "columns", 1076, 45790, 46518);
            CallChecker.varInit(this.rows, "rows", 1076, 45790, 46518);
            CallChecker.varInit(this.blocks, "blocks", 1076, 45790, 46518);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1076, 45790, 46518);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1076, 45790, 46518);
            MatrixUtils.checkRowIndex(this, row);
            final double[] out = CallChecker.varInit(new double[columns], "out", 1078, 45950, 45990);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1081, 46001, 46102);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockRealMatrix.BLOCK_SIZE)))), "iRow", 1082, 46112, 46154);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1083, 46164, 46180);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1085, 46258, 46299);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1086, 46336, 46341)[((iBlock * (blockColumns)) + jBlock)], "block", 1086, 46313, 46374);
                System.arraycopy(block, (iRow * jWidth), out, outIndex, jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1088, 46463, 46481);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1111.methodEnd();
        }
    }

    @Override
    public void setRow(final int row, final double[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1112 = new MethodContext(void.class, 1096, 46525, 47422);
        try {
            CallChecker.varInit(this, "this", 1096, 46525, 47422);
            CallChecker.varInit(array, "array", 1096, 46525, 47422);
            CallChecker.varInit(row, "row", 1096, 46525, 47422);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1096, 46525, 47422);
            CallChecker.varInit(this.blockRows, "blockRows", 1096, 46525, 47422);
            CallChecker.varInit(this.columns, "columns", 1096, 46525, 47422);
            CallChecker.varInit(this.rows, "rows", 1096, 46525, 47422);
            CallChecker.varInit(this.blocks, "blocks", 1096, 46525, 47422);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1096, 46525, 47422);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1096, 46525, 47422);
            MatrixUtils.checkRowIndex(this, row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 1099, 46745, 46783);
            if (CallChecker.beforeDeref(array, double[].class, 1100, 46797, 46801)) {
                if ((CallChecker.isCalled(array, double[].class, 1100, 46797, 46801).length) != nCols) {
                    if (CallChecker.beforeDeref(array, double[].class, 1101, 46880, 46884)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(array, double[].class, 1101, 46880, 46884).length, 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1105, 46924, 47025);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockRealMatrix.BLOCK_SIZE)))), "iRow", 1106, 47035, 47077);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1107, 47087, 47103);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1109, 47181, 47222);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1110, 47259, 47264)[((iBlock * (blockColumns)) + jBlock)], "block", 1110, 47236, 47297);
                System.arraycopy(array, outIndex, block, (iRow * jWidth), jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1112, 47388, 47406);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1112.methodEnd();
        }
    }

    @Override
    public double[] getColumn(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1113 = new MethodContext(double[].class, 1118, 47429, 48237);
        try {
            CallChecker.varInit(this, "this", 1118, 47429, 48237);
            CallChecker.varInit(column, "column", 1118, 47429, 48237);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1118, 47429, 48237);
            CallChecker.varInit(this.blockRows, "blockRows", 1118, 47429, 48237);
            CallChecker.varInit(this.columns, "columns", 1118, 47429, 48237);
            CallChecker.varInit(this.rows, "rows", 1118, 47429, 48237);
            CallChecker.varInit(this.blocks, "blocks", 1118, 47429, 48237);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1118, 47429, 48237);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1118, 47429, 48237);
            MatrixUtils.checkColumnIndex(this, column);
            final double[] out = CallChecker.varInit(new double[rows], "out", 1120, 47601, 47638);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1123, 47649, 47754);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE)))), "jColumn", 1124, 47764, 47812);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1125, 47822, 47860);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1126, 47870, 47886);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1128, 47961, 48000);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1129, 48037, 48042)[((iBlock * (blockColumns)) + jBlock)], "block", 1129, 48014, 48075);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(out, double[].class, 1131, 48141, 48143)) {
                        if (CallChecker.beforeDeref(block, double[].class, 1131, 48159, 48163)) {
                            CallChecker.isCalled(out, double[].class, 1131, 48141, 48143)[(outIndex++)] = CallChecker.isCalled(block, double[].class, 1131, 48159, 48163)[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 1131, 48141, 48143)[(outIndex - 1)], "CallChecker.isCalled(out, double[].class, 1131, 48141, 48143)[(outIndex - 1)]", 1131, 48141, 48186);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1113.methodEnd();
        }
    }

    @Override
    public void setColumn(final int column, final double[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context1114 = new MethodContext(void.class, 1140, 48244, 49220);
        try {
            CallChecker.varInit(this, "this", 1140, 48244, 49220);
            CallChecker.varInit(array, "array", 1140, 48244, 49220);
            CallChecker.varInit(column, "column", 1140, 48244, 49220);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1140, 48244, 49220);
            CallChecker.varInit(this.blockRows, "blockRows", 1140, 48244, 49220);
            CallChecker.varInit(this.columns, "columns", 1140, 48244, 49220);
            CallChecker.varInit(this.rows, "rows", 1140, 48244, 49220);
            CallChecker.varInit(this.blocks, "blocks", 1140, 48244, 49220);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1140, 48244, 49220);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1140, 48244, 49220);
            MatrixUtils.checkColumnIndex(this, column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 1143, 48476, 48511);
            if (CallChecker.beforeDeref(array, double[].class, 1144, 48525, 48529)) {
                if ((CallChecker.isCalled(array, double[].class, 1144, 48525, 48529).length) != nRows) {
                    if (CallChecker.beforeDeref(array, double[].class, 1145, 48605, 48609)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(array, double[].class, 1145, 48605, 48609).length, 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1149, 48652, 48757);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE)))), "jColumn", 1150, 48767, 48815);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1151, 48825, 48862);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1152, 48872, 48888);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1154, 48963, 49002);
                final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1155, 49039, 49044)[((iBlock * (blockColumns)) + jBlock)], "block", 1155, 49016, 49077);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(block, double[].class, 1157, 49143, 49147)) {
                        if (CallChecker.beforeDeref(array, double[].class, 1157, 49173, 49177)) {
                            CallChecker.isCalled(block, double[].class, 1157, 49143, 49147)[((i * jWidth) + jColumn)] = CallChecker.isCalled(array, double[].class, 1157, 49173, 49177)[(outIndex++)];
                            CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1157, 49143, 49147)[((i * jWidth) + jColumn)], "CallChecker.isCalled(block, double[].class, 1157, 49143, 49147)[((i * jWidth) + jColumn)]", 1157, 49143, 49190);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1114.methodEnd();
        }
    }

    @Override
    public double getEntry(final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1115 = new MethodContext(double.class, 1164, 49227, 49688);
        try {
            CallChecker.varInit(this, "this", 1164, 49227, 49688);
            CallChecker.varInit(column, "column", 1164, 49227, 49688);
            CallChecker.varInit(row, "row", 1164, 49227, 49688);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1164, 49227, 49688);
            CallChecker.varInit(this.blockRows, "blockRows", 1164, 49227, 49688);
            CallChecker.varInit(this.columns, "columns", 1164, 49227, 49688);
            CallChecker.varInit(this.rows, "rows", 1164, 49227, 49688);
            CallChecker.varInit(this.blocks, "blocks", 1164, 49227, 49688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1164, 49227, 49688);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1164, 49227, 49688);
            MatrixUtils.checkMatrixIndex(this, row, column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1167, 49424, 49459);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1168, 49469, 49507);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockRealMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE))))), "k", 1169, 49517, 49624);
            if (CallChecker.beforeDeref(blocks, double[][].class, 1171, 49641, 49646)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, double[][].class, 1171, 49641, 49646)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1171, 49641, 49678)) {
                    CallChecker.isCalled(blocks, double[][].class, 1171, 49641, 49646)[((iBlock * (blockColumns)) + jBlock)] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, double[][].class, 1171, 49641, 49646)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1171, 49641, 49678);
                    return CallChecker.isCalled(CallChecker.isCalled(blocks, double[][].class, 1171, 49641, 49646)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1171, 49641, 49678)[k];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1115.methodEnd();
        }
    }

    @Override
    public void setEntry(final int row, final int column, final double value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1116 = new MethodContext(void.class, 1176, 49695, 50175);
        try {
            CallChecker.varInit(this, "this", 1176, 49695, 50175);
            CallChecker.varInit(value, "value", 1176, 49695, 50175);
            CallChecker.varInit(column, "column", 1176, 49695, 50175);
            CallChecker.varInit(row, "row", 1176, 49695, 50175);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1176, 49695, 50175);
            CallChecker.varInit(this.blockRows, "blockRows", 1176, 49695, 50175);
            CallChecker.varInit(this.columns, "columns", 1176, 49695, 50175);
            CallChecker.varInit(this.rows, "rows", 1176, 49695, 50175);
            CallChecker.varInit(this.blocks, "blocks", 1176, 49695, 50175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1176, 49695, 50175);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1176, 49695, 50175);
            MatrixUtils.checkMatrixIndex(this, row, column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1179, 49910, 49945);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1180, 49955, 49993);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockRealMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE))))), "k", 1181, 50003, 50110);
            if (CallChecker.beforeDeref(blocks, double[][].class, 1183, 50120, 50125)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1183, 50120, 50157)) {
                    CallChecker.isCalled(blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (blockColumns)) + jBlock)] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1183, 50120, 50157);
                    CallChecker.isCalled(CallChecker.isCalled(blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1183, 50120, 50157)[k] = value;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1183, 50120, 50157)[k], "CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1183, 50120, 50125)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1183, 50120, 50157)[k]", 1183, 50120, 50169);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1116.methodEnd();
        }
    }

    @Override
    public void addToEntry(final int row, final int column, final double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1117 = new MethodContext(void.class, 1188, 50182, 50706);
        try {
            CallChecker.varInit(this, "this", 1188, 50182, 50706);
            CallChecker.varInit(increment, "increment", 1188, 50182, 50706);
            CallChecker.varInit(column, "column", 1188, 50182, 50706);
            CallChecker.varInit(row, "row", 1188, 50182, 50706);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1188, 50182, 50706);
            CallChecker.varInit(this.blockRows, "blockRows", 1188, 50182, 50706);
            CallChecker.varInit(this.columns, "columns", 1188, 50182, 50706);
            CallChecker.varInit(this.rows, "rows", 1188, 50182, 50706);
            CallChecker.varInit(this.blocks, "blocks", 1188, 50182, 50706);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1188, 50182, 50706);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1188, 50182, 50706);
            MatrixUtils.checkMatrixIndex(this, row, column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1192, 50430, 50468);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1193, 50478, 50516);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockRealMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE))))), "k", 1194, 50526, 50636);
            if (CallChecker.beforeDeref(blocks, double[][].class, 1196, 50646, 50651)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1196, 50646, 50683)) {
                    CallChecker.isCalled(blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (blockColumns)) + jBlock)] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1196, 50646, 50683);
                    CallChecker.isCalled(CallChecker.isCalled(blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1196, 50646, 50683)[k] += increment;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1196, 50646, 50683)[k], "CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1196, 50646, 50651)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1196, 50646, 50683)[k]", 1196, 50646, 50700);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1117.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(final int row, final int column, final double factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context1118 = new MethodContext(void.class, 1201, 50713, 51231);
        try {
            CallChecker.varInit(this, "this", 1201, 50713, 51231);
            CallChecker.varInit(factor, "factor", 1201, 50713, 51231);
            CallChecker.varInit(column, "column", 1201, 50713, 51231);
            CallChecker.varInit(row, "row", 1201, 50713, 51231);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1201, 50713, 51231);
            CallChecker.varInit(this.blockRows, "blockRows", 1201, 50713, 51231);
            CallChecker.varInit(this.columns, "columns", 1201, 50713, 51231);
            CallChecker.varInit(this.rows, "rows", 1201, 50713, 51231);
            CallChecker.varInit(this.blocks, "blocks", 1201, 50713, 51231);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1201, 50713, 51231);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1201, 50713, 51231);
            MatrixUtils.checkMatrixIndex(this, row, column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockRealMatrix.BLOCK_SIZE))), "iBlock", 1205, 50964, 50999);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockRealMatrix.BLOCK_SIZE))), "jBlock", 1206, 51009, 51047);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockRealMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockRealMatrix.BLOCK_SIZE))))), "k", 1207, 51057, 51164);
            if (CallChecker.beforeDeref(blocks, double[][].class, 1209, 51174, 51179)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1209, 51174, 51211)) {
                    CallChecker.isCalled(blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (blockColumns)) + jBlock)] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1209, 51174, 51211);
                    CallChecker.isCalled(CallChecker.isCalled(blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (blockColumns)) + jBlock)], double[].class, 1209, 51174, 51211)[k] *= factor;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1209, 51174, 51211)[k], "CallChecker.isCalled(CallChecker.isCalled(this.blocks, double[][].class, 1209, 51174, 51179)[((iBlock * (this.blockColumns)) + jBlock)], double[].class, 1209, 51174, 51211)[k]", 1209, 51174, 51225);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1118.methodEnd();
        }
    }

    @Override
    public BlockRealMatrix transpose() {
        MethodContext _bcornu_methode_context1119 = new MethodContext(BlockRealMatrix.class, 1214, 51238, 52657);
        try {
            CallChecker.varInit(this, "this", 1214, 51238, 52657);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1214, 51238, 52657);
            CallChecker.varInit(this.blockRows, "blockRows", 1214, 51238, 52657);
            CallChecker.varInit(this.columns, "columns", 1214, 51238, 52657);
            CallChecker.varInit(this.rows, "rows", 1214, 51238, 52657);
            CallChecker.varInit(this.blocks, "blocks", 1214, 51238, 52657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1214, 51238, 52657);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1214, 51238, 52657);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 1215, 51322, 51357);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 1216, 51367, 51405);
            final BlockRealMatrix out = CallChecker.varInit(new BlockRealMatrix(nCols, nRows), "out", 1217, 51415, 51476);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1220, 51558, 51576);
            for (int iBlock = 0; iBlock < (blockColumns); ++iBlock) {
                for (int jBlock = 0; jBlock < (blockRows); ++jBlock) {
                    final double[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockRealMatrix.class, 1224, 51792, 51794).blocks, double[][].class, 1224, 51792, 51801)[blockIndex], "outBlock", 1224, 51766, 51814);
                    final double[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1225, 51856, 51861)[((jBlock * (blockColumns)) + iBlock)], "tBlock", 1225, 51832, 51894);
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1226, 51912, 51950);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "pEnd", 1227, 51968, 52027);
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1228, 52045, 52083);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "qEnd", 1229, 52101, 52157);
                    int k = CallChecker.varInit(((int) (0)), "k", 1230, 52175, 52184);
                    for (int p = pStart; p < pEnd; ++p) {
                        final int lInc = CallChecker.varInit(((int) (pEnd - pStart)), "lInc", 1232, 52260, 52290);
                        int l = CallChecker.varInit(((int) (p - pStart)), "l", 1233, 52312, 52330);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(outBlock, double[].class, 1235, 52414, 52421)) {
                                if (CallChecker.beforeDeref(tBlock, double[].class, 1235, 52428, 52433)) {
                                    CallChecker.isCalled(outBlock, double[].class, 1235, 52414, 52421)[k] = CallChecker.isCalled(tBlock, double[].class, 1235, 52428, 52433)[l];
                                    CallChecker.varAssign(CallChecker.isCalled(outBlock, double[].class, 1235, 52414, 52421)[k], "CallChecker.isCalled(outBlock, double[].class, 1235, 52414, 52421)[k]", 1235, 52414, 52437);
                                }
                            }
                            ++k;
                            l += lInc;
                            CallChecker.varAssign(l, "l", 1237, 52492, 52500);
                        }
                    }
                    ++blockIndex;
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1119.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context1120 = new MethodContext(int.class, 1250, 52664, 52759);
        try {
            CallChecker.varInit(this, "this", 1250, 52664, 52759);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1250, 52664, 52759);
            CallChecker.varInit(this.blockRows, "blockRows", 1250, 52664, 52759);
            CallChecker.varInit(this.columns, "columns", 1250, 52664, 52759);
            CallChecker.varInit(this.rows, "rows", 1250, 52664, 52759);
            CallChecker.varInit(this.blocks, "blocks", 1250, 52664, 52759);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1250, 52664, 52759);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1250, 52664, 52759);
            return rows;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1120.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context1121 = new MethodContext(int.class, 1256, 52766, 52867);
        try {
            CallChecker.varInit(this, "this", 1256, 52766, 52867);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1256, 52766, 52867);
            CallChecker.varInit(this.blockRows, "blockRows", 1256, 52766, 52867);
            CallChecker.varInit(this.columns, "columns", 1256, 52766, 52867);
            CallChecker.varInit(this.rows, "rows", 1256, 52766, 52867);
            CallChecker.varInit(this.blocks, "blocks", 1256, 52766, 52867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1256, 52766, 52867);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1256, 52766, 52867);
            return columns;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1121.methodEnd();
        }
    }

    @Override
    public double[] operate(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1122 = new MethodContext(double[].class, 1262, 52874, 54425);
        try {
            CallChecker.varInit(this, "this", 1262, 52874, 54425);
            CallChecker.varInit(v, "v", 1262, 52874, 54425);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1262, 52874, 54425);
            CallChecker.varInit(this.blockRows, "blockRows", 1262, 52874, 54425);
            CallChecker.varInit(this.columns, "columns", 1262, 52874, 54425);
            CallChecker.varInit(this.rows, "rows", 1262, 52874, 54425);
            CallChecker.varInit(this.blocks, "blocks", 1262, 52874, 54425);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1262, 52874, 54425);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1262, 52874, 54425);
            if (CallChecker.beforeDeref(v, double[].class, 1264, 53011, 53011)) {
                if ((CallChecker.isCalled(v, double[].class, 1264, 53011, 53011).length) != (columns)) {
                    if (CallChecker.beforeDeref(v, double[].class, 1265, 53083, 53083)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 1265, 53083, 53083).length, columns);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[rows], "out", 1267, 53121, 53158);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1271, 53310, 53348);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1272, 53362, 53418);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1274, 53528, 53533)[((iBlock * (blockColumns)) + jBlock)], "block", 1274, 53504, 53566);
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1275, 53584, 53622);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1276, 53640, 53699);
                    int k = CallChecker.varInit(((int) (0)), "k", 1277, 53717, 53726);
                    for (int p = pStart; p < pEnd; ++p) {
                        double sum = CallChecker.varInit(((double) (0)), "sum", 1279, 53802, 53816);
                        int q = CallChecker.varInit(((int) (qStart)), "q", 1280, 53838, 53852);
                        while (q < (qEnd - 3)) {
                            if (CallChecker.beforeDeref(block, double[].class, 1282, 53928, 53932)) {
                                if (CallChecker.beforeDeref(v, double[].class, 1282, 53943, 53943)) {
                                    if (CallChecker.beforeDeref(block, double[].class, 1283, 53985, 53989)) {
                                        if (CallChecker.beforeDeref(v, double[].class, 1283, 54000, 54000)) {
                                            if (CallChecker.beforeDeref(block, double[].class, 1284, 54042, 54046)) {
                                                if (CallChecker.beforeDeref(v, double[].class, 1284, 54057, 54057)) {
                                                    if (CallChecker.beforeDeref(block, double[].class, 1285, 54099, 54103)) {
                                                        if (CallChecker.beforeDeref(v, double[].class, 1285, 54114, 54114)) {
                                                            sum += ((((CallChecker.isCalled(block, double[].class, 1282, 53928, 53932)[k]) * (CallChecker.isCalled(v, double[].class, 1282, 53943, 53943)[q])) + ((CallChecker.isCalled(block, double[].class, 1283, 53985, 53989)[(k + 1)]) * (CallChecker.isCalled(v, double[].class, 1283, 54000, 54000)[(q + 1)]))) + ((CallChecker.isCalled(block, double[].class, 1284, 54042, 54046)[(k + 2)]) * (CallChecker.isCalled(v, double[].class, 1284, 54057, 54057)[(q + 2)]))) + ((CallChecker.isCalled(block, double[].class, 1285, 54099, 54103)[(k + 3)]) * (CallChecker.isCalled(v, double[].class, 1285, 54114, 54114)[(q + 3)]));
                                                            CallChecker.varAssign(sum, "sum", 1282, 53921, 54122);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            k += 4;
                            CallChecker.varAssign(k, "k", 1286, 54148, 54154);
                            q += 4;
                            CallChecker.varAssign(q, "q", 1287, 54180, 54186);
                        } 
                        while (q < qEnd) {
                            if (CallChecker.beforeDeref(block, double[].class, 1290, 54280, 54284)) {
                                if (CallChecker.beforeDeref(v, double[].class, 1290, 54293, 54293)) {
                                    sum += (CallChecker.isCalled(block, double[].class, 1290, 54280, 54284)[(k++)]) * (CallChecker.isCalled(v, double[].class, 1290, 54293, 54293)[(q++)]);
                                    CallChecker.varAssign(sum, "sum", 1290, 54273, 54299);
                                }
                            }
                        } 
                        if (CallChecker.beforeDeref(out, double[].class, 1292, 54343, 54345)) {
                            CallChecker.isCalled(out, double[].class, 1292, 54343, 54345)[p] += sum;
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 1292, 54343, 54345)[p], "CallChecker.isCalled(out, double[].class, 1292, 54343, 54345)[p]", 1292, 54343, 54356);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1122.methodEnd();
        }
    }

    @Override
    public double[] preMultiply(final double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1123 = new MethodContext(double[].class, 1302, 54432, 56264);
        try {
            CallChecker.varInit(this, "this", 1302, 54432, 56264);
            CallChecker.varInit(v, "v", 1302, 54432, 56264);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1302, 54432, 56264);
            CallChecker.varInit(this.blockRows, "blockRows", 1302, 54432, 56264);
            CallChecker.varInit(this.columns, "columns", 1302, 54432, 56264);
            CallChecker.varInit(this.rows, "rows", 1302, 54432, 56264);
            CallChecker.varInit(this.blocks, "blocks", 1302, 54432, 56264);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1302, 54432, 56264);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1302, 54432, 56264);
            if (CallChecker.beforeDeref(v, double[].class, 1304, 54573, 54573)) {
                if ((CallChecker.isCalled(v, double[].class, 1304, 54573, 54573).length) != (rows)) {
                    if (CallChecker.beforeDeref(v, double[].class, 1305, 54642, 54642)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 1305, 54642, 54642).length, rows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] out = CallChecker.varInit(new double[columns], "out", 1307, 54677, 54717);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1311, 54872, 54910);
                final int jWidth2 = CallChecker.varInit(((int) (jWidth + jWidth)), "jWidth2", 1312, 54924, 54960);
                final int jWidth3 = CallChecker.varInit(((int) (jWidth2 + jWidth)), "jWidth3", 1313, 54974, 55010);
                final int jWidth4 = CallChecker.varInit(((int) (jWidth3 + jWidth)), "jWidth4", 1314, 55024, 55060);
                final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1315, 55074, 55112);
                final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1316, 55126, 55185);
                for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1318, 55292, 55297)[((iBlock * (blockColumns)) + jBlock)], "block", 1318, 55268, 55330);
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1319, 55348, 55386);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1320, 55404, 55460);
                    for (int q = qStart; q < qEnd; ++q) {
                        int k = CallChecker.varInit(((int) (q - qStart)), "k", 1322, 55536, 55554);
                        double sum = CallChecker.varInit(((double) (0)), "sum", 1323, 55576, 55590);
                        int p = CallChecker.varInit(((int) (pStart)), "p", 1324, 55612, 55626);
                        while (p < (pEnd - 3)) {
                            if (CallChecker.beforeDeref(block, double[].class, 1326, 55702, 55706)) {
                                if (CallChecker.beforeDeref(v, double[].class, 1326, 55723, 55723)) {
                                    if (CallChecker.beforeDeref(block, double[].class, 1327, 55765, 55769)) {
                                        if (CallChecker.beforeDeref(v, double[].class, 1327, 55786, 55786)) {
                                            if (CallChecker.beforeDeref(block, double[].class, 1328, 55828, 55832)) {
                                                if (CallChecker.beforeDeref(v, double[].class, 1328, 55849, 55849)) {
                                                    if (CallChecker.beforeDeref(block, double[].class, 1329, 55891, 55895)) {
                                                        if (CallChecker.beforeDeref(v, double[].class, 1329, 55912, 55912)) {
                                                            sum += ((((CallChecker.isCalled(block, double[].class, 1326, 55702, 55706)[k]) * (CallChecker.isCalled(v, double[].class, 1326, 55723, 55723)[p])) + ((CallChecker.isCalled(block, double[].class, 1327, 55765, 55769)[(k + jWidth)]) * (CallChecker.isCalled(v, double[].class, 1327, 55786, 55786)[(p + 1)]))) + ((CallChecker.isCalled(block, double[].class, 1328, 55828, 55832)[(k + jWidth2)]) * (CallChecker.isCalled(v, double[].class, 1328, 55849, 55849)[(p + 2)]))) + ((CallChecker.isCalled(block, double[].class, 1329, 55891, 55895)[(k + jWidth3)]) * (CallChecker.isCalled(v, double[].class, 1329, 55912, 55912)[(p + 3)]));
                                                            CallChecker.varAssign(sum, "sum", 1326, 55695, 55920);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            k += jWidth4;
                            CallChecker.varAssign(k, "k", 1330, 55946, 55958);
                            p += 4;
                            CallChecker.varAssign(p, "p", 1331, 55984, 55990);
                        } 
                        while (p < pEnd) {
                            if (CallChecker.beforeDeref(block, double[].class, 1334, 56084, 56088)) {
                                if (CallChecker.beforeDeref(v, double[].class, 1334, 56095, 56095)) {
                                    sum += (CallChecker.isCalled(block, double[].class, 1334, 56084, 56088)[k]) * (CallChecker.isCalled(v, double[].class, 1334, 56095, 56095)[(p++)]);
                                    CallChecker.varAssign(sum, "sum", 1334, 56077, 56101);
                                }
                            }
                            k += jWidth;
                            CallChecker.varAssign(k, "k", 1335, 56127, 56138);
                        } 
                        if (CallChecker.beforeDeref(out, double[].class, 1337, 56182, 56184)) {
                            CallChecker.isCalled(out, double[].class, 1337, 56182, 56184)[q] += sum;
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 1337, 56182, 56184)[q], "CallChecker.isCalled(out, double[].class, 1337, 56182, 56184)[q]", 1337, 56182, 56195);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1123.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context1124 = new MethodContext(double.class, 1347, 56271, 57340);
        try {
            CallChecker.varInit(this, "this", 1347, 56271, 57340);
            CallChecker.varInit(visitor, "visitor", 1347, 56271, 57340);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1347, 56271, 57340);
            CallChecker.varInit(this.blockRows, "blockRows", 1347, 56271, 57340);
            CallChecker.varInit(this.columns, "columns", 1347, 56271, 57340);
            CallChecker.varInit(this.rows, "rows", 1347, 56271, 57340);
            CallChecker.varInit(this.blocks, "blocks", 1347, 56271, 57340);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1347, 56271, 57340);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1347, 56271, 57340);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1348, 56390, 56396)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1348, 56390, 56396).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1350, 56522, 56560);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1351, 56574, 56630);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1354, 56774, 56811);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1355, 56833, 56871);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1356, 56893, 56952);
                        final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1357, 56997, 57002)[((iBlock * (blockColumns)) + jBlock)], "block", 1357, 56974, 57035);
                        int k = CallChecker.varInit(((int) ((p - pStart) * jWidth)), "k", 1358, 57057, 57086);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1360, 57170, 57174)) {
                                if (CallChecker.beforeDeref(block, double[].class, 1360, 57201, 57205)) {
                                    if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1360, 57181, 57187)) {
                                        CallChecker.isCalled(block, double[].class, 1360, 57170, 57174)[k] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1360, 57181, 57187).visit(p, q, CallChecker.isCalled(block, double[].class, 1360, 57201, 57205)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1360, 57170, 57174)[k], "CallChecker.isCalled(block, double[].class, 1360, 57170, 57174)[k]", 1360, 57170, 57210);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1366, 57321, 57327)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1366, 57321, 57327).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1124.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context1125 = new MethodContext(double.class, 1371, 57347, 58407);
        try {
            CallChecker.varInit(this, "this", 1371, 57347, 58407);
            CallChecker.varInit(visitor, "visitor", 1371, 57347, 58407);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1371, 57347, 58407);
            CallChecker.varInit(this.blockRows, "blockRows", 1371, 57347, 58407);
            CallChecker.varInit(this.columns, "columns", 1371, 57347, 58407);
            CallChecker.varInit(this.rows, "rows", 1371, 57347, 58407);
            CallChecker.varInit(this.blocks, "blocks", 1371, 57347, 58407);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1371, 57347, 58407);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1371, 57347, 58407);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1372, 57468, 57474)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1372, 57468, 57474).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1374, 57600, 57638);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1375, 57652, 57708);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1378, 57852, 57889);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1379, 57911, 57949);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1380, 57971, 58030);
                        final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1381, 58075, 58080)[((iBlock * (blockColumns)) + jBlock)], "block", 1381, 58052, 58113);
                        int k = CallChecker.varInit(((int) ((p - pStart) * jWidth)), "k", 1382, 58135, 58164);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1384, 58268, 58272)) {
                                if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1384, 58248, 58254)) {
                                    CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1384, 58248, 58254).visit(p, q, CallChecker.isCalled(block, double[].class, 1384, 58268, 58272)[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1390, 58388, 58394)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1390, 58388, 58394).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1125.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1126 = new MethodContext(double.class, 1395, 58414, 60021);
        try {
            CallChecker.varInit(this, "this", 1395, 58414, 60021);
            CallChecker.varInit(endColumn, "endColumn", 1395, 58414, 60021);
            CallChecker.varInit(startColumn, "startColumn", 1395, 58414, 60021);
            CallChecker.varInit(endRow, "endRow", 1395, 58414, 60021);
            CallChecker.varInit(startRow, "startRow", 1395, 58414, 60021);
            CallChecker.varInit(visitor, "visitor", 1395, 58414, 60021);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1395, 58414, 60021);
            CallChecker.varInit(this.blockRows, "blockRows", 1395, 58414, 60021);
            CallChecker.varInit(this.columns, "columns", 1395, 58414, 60021);
            CallChecker.varInit(this.rows, "rows", 1395, 58414, 60021);
            CallChecker.varInit(this.blocks, "blocks", 1395, 58414, 60021);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1395, 58414, 60021);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1395, 58414, 60021);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1400, 58832, 58838)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1400, 58832, 58838).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockRealMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockRealMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "p0", 1402, 59011, 59045);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1403, 59059, 59104);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1404, 59118, 59186);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = startColumn / (BlockRealMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockRealMatrix.BLOCK_SIZE))); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1407, 59367, 59404);
                        final int q0 = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "q0", 1408, 59426, 59460);
                        final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1409, 59482, 59530);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1410, 59552, 59623);
                        final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1411, 59668, 59673)[((iBlock * (blockColumns)) + jBlock)], "block", 1411, 59645, 59706);
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1412, 59728, 59767);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1414, 59851, 59855)) {
                                if (CallChecker.beforeDeref(block, double[].class, 1414, 59882, 59886)) {
                                    if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1414, 59862, 59868)) {
                                        CallChecker.isCalled(block, double[].class, 1414, 59851, 59855)[k] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1414, 59862, 59868).visit(p, q, CallChecker.isCalled(block, double[].class, 1414, 59882, 59886)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1414, 59851, 59855)[k], "CallChecker.isCalled(block, double[].class, 1414, 59851, 59855)[k]", 1414, 59851, 59891);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1420, 60002, 60008)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1420, 60002, 60008).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1126.methodEnd();
        }
    }

    @Override
    public double walkInRowOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1127 = new MethodContext(double.class, 1425, 60028, 61626);
        try {
            CallChecker.varInit(this, "this", 1425, 60028, 61626);
            CallChecker.varInit(endColumn, "endColumn", 1425, 60028, 61626);
            CallChecker.varInit(startColumn, "startColumn", 1425, 60028, 61626);
            CallChecker.varInit(endRow, "endRow", 1425, 60028, 61626);
            CallChecker.varInit(startRow, "startRow", 1425, 60028, 61626);
            CallChecker.varInit(visitor, "visitor", 1425, 60028, 61626);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1425, 60028, 61626);
            CallChecker.varInit(this.blockRows, "blockRows", 1425, 60028, 61626);
            CallChecker.varInit(this.columns, "columns", 1425, 60028, 61626);
            CallChecker.varInit(this.rows, "rows", 1425, 60028, 61626);
            CallChecker.varInit(this.blocks, "blocks", 1425, 60028, 61626);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1425, 60028, 61626);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1425, 60028, 61626);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1430, 60448, 60454)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1430, 60448, 60454).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockRealMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockRealMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "p0", 1432, 60627, 60661);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1433, 60675, 60720);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1434, 60734, 60802);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = startColumn / (BlockRealMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockRealMatrix.BLOCK_SIZE))); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1437, 60983, 61020);
                        final int q0 = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "q0", 1438, 61042, 61076);
                        final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1439, 61098, 61146);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1440, 61168, 61239);
                        final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1441, 61284, 61289)[((iBlock * (blockColumns)) + jBlock)], "block", 1441, 61261, 61322);
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1442, 61344, 61383);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1444, 61487, 61491)) {
                                if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1444, 61467, 61473)) {
                                    CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1444, 61467, 61473).visit(p, q, CallChecker.isCalled(block, double[].class, 1444, 61487, 61491)[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1450, 61607, 61613)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1450, 61607, 61613).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1127.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealMatrixChangingVisitor visitor) {
        MethodContext _bcornu_methode_context1128 = new MethodContext(double.class, 1455, 61633, 62650);
        try {
            CallChecker.varInit(this, "this", 1455, 61633, 62650);
            CallChecker.varInit(visitor, "visitor", 1455, 61633, 62650);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1455, 61633, 62650);
            CallChecker.varInit(this.blockRows, "blockRows", 1455, 61633, 62650);
            CallChecker.varInit(this.columns, "columns", 1455, 61633, 62650);
            CallChecker.varInit(this.rows, "rows", 1455, 61633, 62650);
            CallChecker.varInit(this.blocks, "blocks", 1455, 61633, 62650);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1455, 61633, 62650);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1455, 61633, 62650);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1456, 61758, 61764)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1456, 61758, 61764).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1457, 61825, 61843);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1459, 61918, 61956);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1460, 61970, 62026);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1462, 62112, 62150);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1463, 62168, 62227);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1464, 62268, 62273)[blockIndex], "block", 1464, 62245, 62286);
                    int k = CallChecker.varInit(((int) (0)), "k", 1465, 62304, 62313);
                    for (int p = pStart; p < pEnd; ++p) {
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1468, 62451, 62455)) {
                                if (CallChecker.beforeDeref(block, double[].class, 1468, 62482, 62486)) {
                                    if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1468, 62462, 62468)) {
                                        CallChecker.isCalled(block, double[].class, 1468, 62451, 62455)[k] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1468, 62462, 62468).visit(p, q, CallChecker.isCalled(block, double[].class, 1468, 62482, 62486)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1468, 62451, 62455)[k], "CallChecker.isCalled(block, double[].class, 1468, 62451, 62455)[k]", 1468, 62451, 62491);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                    ++blockIndex;
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1475, 62631, 62637)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1475, 62631, 62637).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1128.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealMatrixPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context1129 = new MethodContext(double.class, 1480, 62657, 63665);
        try {
            CallChecker.varInit(this, "this", 1480, 62657, 63665);
            CallChecker.varInit(visitor, "visitor", 1480, 62657, 63665);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1480, 62657, 63665);
            CallChecker.varInit(this.blockRows, "blockRows", 1480, 62657, 63665);
            CallChecker.varInit(this.columns, "columns", 1480, 62657, 63665);
            CallChecker.varInit(this.rows, "rows", 1480, 62657, 63665);
            CallChecker.varInit(this.blocks, "blocks", 1480, 62657, 63665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1480, 62657, 63665);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1480, 62657, 63665);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1481, 62784, 62790)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1481, 62784, 62790).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1482, 62851, 62869);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "pStart", 1484, 62944, 62982);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockRealMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1485, 62996, 63052);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "qStart", 1487, 63138, 63176);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockRealMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1488, 63194, 63253);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1489, 63294, 63299)[blockIndex], "block", 1489, 63271, 63312);
                    int k = CallChecker.varInit(((int) (0)), "k", 1490, 63330, 63339);
                    for (int p = pStart; p < pEnd; ++p) {
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1493, 63497, 63501)) {
                                if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1493, 63477, 63483)) {
                                    CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1493, 63477, 63483).visit(p, q, CallChecker.isCalled(block, double[].class, 1493, 63497, 63501)[k]);
                                }
                            }
                            ++k;
                        }
                    }
                    ++blockIndex;
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1500, 63646, 63652)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1500, 63646, 63652).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1129.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealMatrixChangingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1130 = new MethodContext(double.class, 1505, 63672, 65315);
        try {
            CallChecker.varInit(this, "this", 1505, 63672, 65315);
            CallChecker.varInit(endColumn, "endColumn", 1505, 63672, 65315);
            CallChecker.varInit(startColumn, "startColumn", 1505, 63672, 65315);
            CallChecker.varInit(endRow, "endRow", 1505, 63672, 65315);
            CallChecker.varInit(startRow, "startRow", 1505, 63672, 65315);
            CallChecker.varInit(visitor, "visitor", 1505, 63672, 65315);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1505, 63672, 65315);
            CallChecker.varInit(this.blockRows, "blockRows", 1505, 63672, 65315);
            CallChecker.varInit(this.columns, "columns", 1505, 63672, 65315);
            CallChecker.varInit(this.rows, "rows", 1505, 63672, 65315);
            CallChecker.varInit(this.blocks, "blocks", 1505, 63672, 65315);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1505, 63672, 65315);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1505, 63672, 65315);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1511, 64147, 64153)) {
                CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1511, 64147, 64153).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockRealMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockRealMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "p0", 1513, 64326, 64360);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1514, 64374, 64419);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1515, 64433, 64501);
                for (int jBlock = startColumn / (BlockRealMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockRealMatrix.BLOCK_SIZE))); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1517, 64624, 64661);
                    final int q0 = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "q0", 1518, 64679, 64713);
                    final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1519, 64731, 64779);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1520, 64797, 64868);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1521, 64909, 64914)[((iBlock * (blockColumns)) + jBlock)], "block", 1521, 64886, 64947);
                    for (int p = pStart; p < pEnd; ++p) {
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1523, 65023, 65062);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1525, 65146, 65150)) {
                                if (CallChecker.beforeDeref(block, double[].class, 1525, 65177, 65181)) {
                                    if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1525, 65157, 65163)) {
                                        CallChecker.isCalled(block, double[].class, 1525, 65146, 65150)[k] = CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1525, 65157, 65163).visit(p, q, CallChecker.isCalled(block, double[].class, 1525, 65177, 65181)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(block, double[].class, 1525, 65146, 65150)[k], "CallChecker.isCalled(block, double[].class, 1525, 65146, 65150)[k]", 1525, 65146, 65186);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixChangingVisitor.class, 1531, 65296, 65302)) {
                return CallChecker.isCalled(visitor, RealMatrixChangingVisitor.class, 1531, 65296, 65302).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1130.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealMatrixPreservingVisitor visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context1131 = new MethodContext(double.class, 1536, 65322, 66956);
        try {
            CallChecker.varInit(this, "this", 1536, 65322, 66956);
            CallChecker.varInit(endColumn, "endColumn", 1536, 65322, 66956);
            CallChecker.varInit(startColumn, "startColumn", 1536, 65322, 66956);
            CallChecker.varInit(endRow, "endRow", 1536, 65322, 66956);
            CallChecker.varInit(startRow, "startRow", 1536, 65322, 66956);
            CallChecker.varInit(visitor, "visitor", 1536, 65322, 66956);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1536, 65322, 66956);
            CallChecker.varInit(this.blockRows, "blockRows", 1536, 65322, 66956);
            CallChecker.varInit(this.columns, "columns", 1536, 65322, 66956);
            CallChecker.varInit(this.rows, "rows", 1536, 65322, 66956);
            CallChecker.varInit(this.blocks, "blocks", 1536, 65322, 66956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1536, 65322, 66956);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1536, 65322, 66956);
            MatrixUtils.checkSubMatrixIndex(this, startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1542, 65799, 65805)) {
                CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1542, 65799, 65805).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockRealMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockRealMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockRealMatrix.BLOCK_SIZE))), "p0", 1544, 65978, 66012);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1545, 66026, 66071);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1546, 66085, 66153);
                for (int jBlock = startColumn / (BlockRealMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockRealMatrix.BLOCK_SIZE))); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1548, 66276, 66313);
                    final int q0 = CallChecker.varInit(((int) (jBlock * (BlockRealMatrix.BLOCK_SIZE))), "q0", 1549, 66331, 66365);
                    final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1550, 66383, 66431);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockRealMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1551, 66449, 66520);
                    final double[] block = CallChecker.varInit(CallChecker.isCalled(blocks, double[][].class, 1552, 66561, 66566)[((iBlock * (blockColumns)) + jBlock)], "block", 1552, 66538, 66599);
                    for (int p = pStart; p < pEnd; ++p) {
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1554, 66675, 66714);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, double[].class, 1556, 66818, 66822)) {
                                if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1556, 66798, 66804)) {
                                    CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1556, 66798, 66804).visit(p, q, CallChecker.isCalled(block, double[].class, 1556, 66818, 66822)[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealMatrixPreservingVisitor.class, 1562, 66937, 66943)) {
                return CallChecker.isCalled(visitor, RealMatrixPreservingVisitor.class, 1562, 66937, 66943).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1131.methodEnd();
        }
    }

    private int blockHeight(final int blockRow) {
        MethodContext _bcornu_methode_context1132 = new MethodContext(int.class, 1570, 66963, 67266);
        try {
            CallChecker.varInit(this, "this", 1570, 66963, 67266);
            CallChecker.varInit(blockRow, "blockRow", 1570, 66963, 67266);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1570, 66963, 67266);
            CallChecker.varInit(this.blockRows, "blockRows", 1570, 66963, 67266);
            CallChecker.varInit(this.columns, "columns", 1570, 66963, 67266);
            CallChecker.varInit(this.rows, "rows", 1570, 66963, 67266);
            CallChecker.varInit(this.blocks, "blocks", 1570, 66963, 67266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1570, 66963, 67266);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1570, 66963, 67266);
            if (blockRow == ((blockRows) - 1)) {
                return (rows) - (blockRow * (BlockRealMatrix.BLOCK_SIZE));
            }else {
                return BlockRealMatrix.BLOCK_SIZE;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1132.methodEnd();
        }
    }

    private int blockWidth(final int blockColumn) {
        MethodContext _bcornu_methode_context1133 = new MethodContext(int.class, 1579, 67273, 67597);
        try {
            CallChecker.varInit(this, "this", 1579, 67273, 67597);
            CallChecker.varInit(blockColumn, "blockColumn", 1579, 67273, 67597);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1579, 67273, 67597);
            CallChecker.varInit(this.blockRows, "blockRows", 1579, 67273, 67597);
            CallChecker.varInit(this.columns, "columns", 1579, 67273, 67597);
            CallChecker.varInit(this.rows, "rows", 1579, 67273, 67597);
            CallChecker.varInit(this.blocks, "blocks", 1579, 67273, 67597);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockRealMatrix.serialVersionUID", 1579, 67273, 67597);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockRealMatrix.BLOCK_SIZE", 1579, 67273, 67597);
            if (blockColumn == ((blockColumns) - 1)) {
                return (columns) - (blockColumn * (BlockRealMatrix.BLOCK_SIZE));
            }else {
                return BlockRealMatrix.BLOCK_SIZE;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1133.methodEnd();
        }
    }
}

