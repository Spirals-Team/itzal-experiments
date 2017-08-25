package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class BlockFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    public static final int BLOCK_SIZE = 36;

    private static final long serialVersionUID = -4602336630143123183L;

    private final T[][] blocks;

    private final int rows;

    private final int columns;

    private final int blockRows;

    private final int blockColumns;

    public BlockFieldMatrix(final Field<T> field, final int rows, final int columns) throws NotStrictlyPositiveException {
        super(field, rows, columns);
        ConstructorContext _bcornu_methode_context869 = new ConstructorContext(BlockFieldMatrix.class, 100, 4434, 5350);
        try {
            this.rows = rows;
            CallChecker.varAssign(this.rows, "this.rows", 104, 4992, 5011);
            this.columns = columns;
            CallChecker.varAssign(this.columns, "this.columns", 105, 5021, 5043);
            blockRows = ((rows + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockRows, "this.blockRows", 108, 5082, 5136);
            blockColumns = ((columns + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockColumns, "this.blockColumns", 109, 5146, 5200);
            blocks = BlockFieldMatrix.createBlocksLayout(field, rows, columns);
            CallChecker.varAssign(this.blocks, "this.blocks", 112, 5295, 5344);
        } finally {
            _bcornu_methode_context869.methodEnd();
        }
    }

    public BlockFieldMatrix(final T[][] rawData) throws DimensionMismatchException {
        this(CallChecker.isCalled(rawData, null, 130, 6109, 6115).length, CallChecker.isCalled(CallChecker.isCalled(rawData, null, 130, 6125, 6131)[0], null, 130, 6125, 6134).length, BlockFieldMatrix.toBlocksLayout(rawData), false);
        ConstructorContext _bcornu_methode_context870 = new ConstructorContext(BlockFieldMatrix.class, 128, 5357, 6181);
        try {
        } finally {
            _bcornu_methode_context870.methodEnd();
        }
    }

    public BlockFieldMatrix(final int rows, final int columns, final T[][] blockData, final boolean copyArray) throws DimensionMismatchException, NotStrictlyPositiveException {
        super(AbstractFieldMatrix.extractField(blockData), rows, columns);
        ConstructorContext _bcornu_methode_context871 = new ConstructorContext(BlockFieldMatrix.class, 150, 6188, 8382);
        try {
            this.rows = rows;
            CallChecker.varAssign(this.rows, "this.rows", 154, 7250, 7269);
            this.columns = columns;
            CallChecker.varAssign(this.columns, "this.columns", 155, 7279, 7301);
            blockRows = ((rows + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockRows, "this.blockRows", 158, 7340, 7394);
            blockColumns = ((columns + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE);
            CallChecker.varAssign(this.blockColumns, "this.blockColumns", 159, 7404, 7458);
            if (copyArray) {
                blocks = MathArrays.buildArray(getField(), ((blockRows) * (blockColumns)), (-1));
                CallChecker.varAssign(this.blocks, "this.blocks", 163, 7586, 7658);
            }else {
                blocks = blockData;
                CallChecker.varAssign(this.blocks, "this.blocks", 166, 7729, 7747);
            }
            int index = CallChecker.varInit(((int) (0)), "index", 169, 7768, 7781);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 171, 7856, 7895);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock , ++index) {
                    if (CallChecker.beforeDeref(blockData, null, 173, 7994, 8002)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, null, 173, 7994, 8002)[index], null, 173, 7994, 8009)) {
                            CallChecker.isCalled(blockData, null, 173, 7994, 8002)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, null, 173, 7994, 8002)[index], null, 173, 7994, 8009);
                            if ((CallChecker.isCalled(CallChecker.isCalled(blockData, null, 173, 7994, 8002)[index], null, 173, 7994, 8009).length) != (iHeight * (blockWidth(jBlock)))) {
                                if (CallChecker.beforeDeref(blockData, null, 174, 8110, 8118)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, null, 174, 8110, 8118)[index], null, 174, 8110, 8125)) {
                                        CallChecker.isCalled(blockData, null, 174, 8110, 8118)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, null, 174, 8110, 8118)[index], null, 174, 8110, 8125);
                                        throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(blockData, null, 174, 8110, 8118)[index], null, 174, 8110, 8125).length, (iHeight * (blockWidth(jBlock))));
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
                        if (CallChecker.beforeDeref(blocks, null, 178, 8294, 8299)) {
                            if (CallChecker.beforeDeref(blockData, null, 178, 8310, 8318)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(blockData, null, 178, 8310, 8318)[index], null, 178, 8310, 8325)) {
                                    CallChecker.isCalled(blockData, null, 178, 8310, 8318)[index] = CallChecker.beforeCalled(CallChecker.isCalled(blockData, null, 178, 8310, 8318)[index], null, 178, 8310, 8325);
                                    CallChecker.isCalled(blocks, null, 178, 8294, 8299)[index] = CallChecker.isCalled(CallChecker.isCalled(blockData, null, 178, 8310, 8318)[index], null, 178, 8310, 8325).clone();
                                    CallChecker.varAssign(CallChecker.isCalled(this.blocks, null, 178, 8294, 8299)[index], "CallChecker.isCalled(this.blocks, null, 178, 8294, 8299)[index]", 178, 8294, 8334);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context871.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> T[][] toBlocksLayout(final T[][] rawData) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3841 = new MethodContext(null, 208, 8389, 11415);
        try {
            CallChecker.varInit(rawData, "rawData", 208, 8389, 11415);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 208, 8389, 11415);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 208, 8389, 11415);
            final int rows = CallChecker.varInit(((int) (CallChecker.isCalled(rawData, null, 211, 9758, 9764).length)), "rows", 211, 9733, 9772);
            CallChecker.isCalled(rawData, null, 212, 9807, 9813)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rawData, null, 212, 9807, 9813)[0], null, 212, 9807, 9816);
            final int columns = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(rawData, null, 212, 9807, 9813)[0], null, 212, 9807, 9816).length)), "columns", 212, 9782, 9824);
            final int blockRows = CallChecker.varInit(((int) (((rows + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE))), "blockRows", 213, 9834, 9898);
            final int blockColumns = CallChecker.varInit(((int) (((columns + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE))), "blockColumns", 214, 9908, 9972);
            for (int i = 0; i < (CallChecker.isCalled(rawData, null, 217, 10028, 10034).length); ++i) {
                CallChecker.isCalled(rawData, null, 218, 10082, 10088)[i] = CallChecker.beforeCalled(CallChecker.isCalled(rawData, null, 218, 10082, 10088)[i], null, 218, 10082, 10091);
                final int length = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(rawData, null, 218, 10082, 10088)[i], null, 218, 10082, 10091).length)), "length", 218, 10063, 10099);
                if (length != columns) {
                    throw new DimensionMismatchException(columns, length);
                }
            }
            final Field<T> field = CallChecker.varInit(AbstractFieldMatrix.extractField(rawData), "field", 225, 10242, 10311);
            final T[][] blocks = CallChecker.varInit(MathArrays.buildArray(field, (blockRows * blockColumns), (-1)), "blocks", 226, 10321, 10400);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 227, 10410, 10428);
            for (int iBlock = 0; iBlock < blockRows; ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 229, 10503, 10542);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), rows))), "pEnd", 230, 10556, 10615);
                final int iHeight = CallChecker.varInit(((int) (pEnd - pStart)), "iHeight", 231, 10629, 10662);
                for (int jBlock = 0; jBlock < blockColumns; ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 233, 10748, 10786);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), columns))), "qEnd", 234, 10804, 10865);
                    final int jWidth = CallChecker.varInit(((int) (qEnd - qStart)), "jWidth", 235, 10883, 10915);
                    final T[] block = CallChecker.varInit(MathArrays.buildArray(field, (iHeight * jWidth)), "block", 238, 10972, 11036);
                    if (CallChecker.beforeDeref(blocks, null, 239, 11054, 11059)) {
                        CallChecker.isCalled(blocks, null, 239, 11054, 11059)[blockIndex] = block;
                        CallChecker.varAssign(CallChecker.isCalled(blocks, null, 239, 11054, 11059)[blockIndex], "CallChecker.isCalled(blocks, null, 239, 11054, 11059)[blockIndex]", 239, 11054, 11080);
                    }
                    int index = CallChecker.varInit(((int) (0)), "index", 242, 11128, 11141);
                    for (int p = pStart; p < pEnd; ++p) {
                        if (CallChecker.beforeDeref(rawData, null, 244, 11234, 11240)) {
                            System.arraycopy(CallChecker.isCalled(rawData, null, 244, 11234, 11240)[p], qStart, block, index, jWidth);
                        }
                        index += jWidth;
                        CallChecker.varAssign(index, "index", 245, 11297, 11312);
                    }
                    ++blockIndex;
                }
            }
            return blocks;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3841.methodEnd();
        }
    }

    public static <T extends FieldElement<T>> T[][] createBlocksLayout(final Field<T> field, final int rows, final int columns) {
        MethodContext _bcornu_methode_context3842 = new MethodContext(null, 270, 11422, 13157);
        try {
            CallChecker.varInit(columns, "columns", 270, 11422, 13157);
            CallChecker.varInit(rows, "rows", 270, 11422, 13157);
            CallChecker.varInit(field, "field", 270, 11422, 13157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 270, 11422, 13157);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 270, 11422, 13157);
            final int blockRows = CallChecker.varInit(((int) (((rows + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE))), "blockRows", 272, 12245, 12309);
            final int blockColumns = CallChecker.varInit(((int) (((columns + (BlockFieldMatrix.BLOCK_SIZE)) - 1) / (BlockFieldMatrix.BLOCK_SIZE))), "blockColumns", 273, 12319, 12383);
            final T[][] blocks = CallChecker.varInit(MathArrays.buildArray(field, (blockRows * blockColumns), (-1)), "blocks", 275, 12394, 12473);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 276, 12483, 12501);
            for (int iBlock = 0; iBlock < blockRows; ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 278, 12576, 12615);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), rows))), "pEnd", 279, 12629, 12688);
                final int iHeight = CallChecker.varInit(((int) (pEnd - pStart)), "iHeight", 280, 12702, 12735);
                for (int jBlock = 0; jBlock < blockColumns; ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 282, 12821, 12859);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), columns))), "qEnd", 283, 12877, 12938);
                    final int jWidth = CallChecker.varInit(((int) (qEnd - qStart)), "jWidth", 284, 12956, 12988);
                    if (CallChecker.beforeDeref(blocks, null, 285, 13006, 13011)) {
                        CallChecker.isCalled(blocks, null, 285, 13006, 13011)[blockIndex] = MathArrays.buildArray(field, (iHeight * jWidth));
                        CallChecker.varAssign(CallChecker.isCalled(blocks, null, 285, 13006, 13011)[blockIndex], "CallChecker.isCalled(blocks, null, 285, 13006, 13011)[blockIndex]", 285, 13006, 13073);
                    }
                    ++blockIndex;
                }
            }
            return blocks;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3842.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> createMatrix(final int rowDimension, final int columnDimension) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3843 = new MethodContext(FieldMatrix.class, 295, 13164, 13500);
        try {
            CallChecker.varInit(this, "this", 295, 13164, 13500);
            CallChecker.varInit(columnDimension, "columnDimension", 295, 13164, 13500);
            CallChecker.varInit(rowDimension, "rowDimension", 295, 13164, 13500);
            CallChecker.varInit(this.blockColumns, "blockColumns", 295, 13164, 13500);
            CallChecker.varInit(this.blockRows, "blockRows", 295, 13164, 13500);
            CallChecker.varInit(this.columns, "columns", 295, 13164, 13500);
            CallChecker.varInit(this.rows, "rows", 295, 13164, 13500);
            CallChecker.varInit(this.blocks, "blocks", 295, 13164, 13500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 295, 13164, 13500);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 295, 13164, 13500);
            return new BlockFieldMatrix<T>(getField(), rowDimension, columnDimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3843.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> copy() {
        MethodContext _bcornu_methode_context3844 = new MethodContext(FieldMatrix.class, 304, 13507, 13900);
        try {
            CallChecker.varInit(this, "this", 304, 13507, 13900);
            CallChecker.varInit(this.blockColumns, "blockColumns", 304, 13507, 13900);
            CallChecker.varInit(this.blockRows, "blockRows", 304, 13507, 13900);
            CallChecker.varInit(this.columns, "columns", 304, 13507, 13900);
            CallChecker.varInit(this.rows, "rows", 304, 13507, 13900);
            CallChecker.varInit(this.blocks, "blocks", 304, 13507, 13900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 304, 13507, 13900);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 304, 13507, 13900);
            BlockFieldMatrix<T> copied = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "copied", 307, 13620, 13699);
            for (int i = 0; i < (CallChecker.isCalled(blocks, null, 310, 13757, 13762).length); ++i) {
                if (CallChecker.beforeDeref(blocks, null, 311, 13808, 13813)) {
                    if (CallChecker.beforeDeref(copied, BlockFieldMatrix.class, 311, 13822, 13827)) {
                        copied = CallChecker.beforeCalled(copied, BlockFieldMatrix.class, 311, 13822, 13827);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(copied, BlockFieldMatrix.class, 311, 13822, 13827).blocks, null, 311, 13822, 13834)) {
                            if (CallChecker.beforeDeref(blocks, null, 311, 13843, 13848)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, null, 311, 13843, 13848)[i], null, 311, 13843, 13851)) {
                                    copied = CallChecker.beforeCalled(copied, BlockFieldMatrix.class, 311, 13822, 13827);
                                    CallChecker.isCalled(blocks, null, 311, 13843, 13848)[i] = CallChecker.beforeCalled(CallChecker.isCalled(blocks, null, 311, 13843, 13848)[i], null, 311, 13843, 13851);
                                    System.arraycopy(CallChecker.isCalled(blocks, null, 311, 13808, 13813)[i], 0, CallChecker.isCalled(CallChecker.isCalled(copied, BlockFieldMatrix.class, 311, 13822, 13827).blocks, null, 311, 13822, 13834)[i], 0, CallChecker.isCalled(CallChecker.isCalled(blocks, null, 311, 13843, 13848)[i], null, 311, 13843, 13851).length);
                                }
                            }
                        }
                    }
                }
            }
            return copied;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3844.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> add(final FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3845 = new MethodContext(FieldMatrix.class, 319, 13907, 15523);
        try {
            CallChecker.varInit(this, "this", 319, 13907, 15523);
            CallChecker.varInit(m, "m", 319, 13907, 15523);
            CallChecker.varInit(this.blockColumns, "blockColumns", 319, 13907, 15523);
            CallChecker.varInit(this.blockRows, "blockRows", 319, 13907, 15523);
            CallChecker.varInit(this.columns, "columns", 319, 13907, 15523);
            CallChecker.varInit(this.rows, "rows", 319, 13907, 15523);
            CallChecker.varInit(this.blocks, "blocks", 319, 13907, 15523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 319, 13907, 15523);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 319, 13907, 15523);
            TryContext _bcornu_try_context_80 = new TryContext(80, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                return add(((BlockFieldMatrix<T>) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_80.catchStart(80);
                checkAdditionCompatible(m);
                final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 328, 14234, 14316);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 331, 14405, 14423);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 332, 14467, 14469).blockRows); ++iBlock) {
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 333, 14540, 14542).blockColumns); ++jBlock) {
                        final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 336, 14673, 14675).blocks, null, 336, 14673, 14682)[blockIndex], "outBlock", 336, 14652, 14695);
                        final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 337, 14738, 14743)[blockIndex], "tBlock", 337, 14717, 14756);
                        final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 338, 14778, 14823);
                        final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 339, 14845, 14910);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 340, 14932, 14977);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 341, 14999, 15067);
                        int k = CallChecker.varInit(((int) (0)), "k", 342, 15089, 15098);
                        for (int p = pStart; p < pEnd; ++p) {
                            for (int q = qStart; q < qEnd; ++q) {
                                if (CallChecker.beforeDeref(outBlock, null, 345, 15248, 15255)) {
                                    if (CallChecker.beforeDeref(tBlock, null, 345, 15262, 15267)) {
                                        if (CallChecker.beforeDeref(m, FieldMatrix.class, 345, 15276, 15276)) {
                                            if (CallChecker.beforeDeref(tBlock[k], null, 345, 15262, 15270)) {
                                                outBlock[k] = tBlock[k].add(m.getEntry(p, q));
                                                CallChecker.varAssign(outBlock[k], "outBlock[k]", 345, 15248, 15293);
                                            }
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
                _bcornu_try_context_80.finallyStart(80);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3845.methodEnd();
        }
    }

    public BlockFieldMatrix<T> add(final BlockFieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3846 = new MethodContext(BlockFieldMatrix.class, 368, 15530, 16521);
        try {
            CallChecker.varInit(this, "this", 368, 15530, 16521);
            CallChecker.varInit(m, "m", 368, 15530, 16521);
            CallChecker.varInit(this.blockColumns, "blockColumns", 368, 15530, 16521);
            CallChecker.varInit(this.blockRows, "blockRows", 368, 15530, 16521);
            CallChecker.varInit(this.columns, "columns", 368, 15530, 16521);
            CallChecker.varInit(this.rows, "rows", 368, 15530, 16521);
            CallChecker.varInit(this.blocks, "blocks", 368, 15530, 16521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 368, 15530, 16521);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 368, 15530, 16521);
            checkAdditionCompatible(m);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 374, 15959, 16041);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 377, 16160, 16162).blocks, null, 377, 16160, 16169).length); ++blockIndex) {
                final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 378, 16228, 16230).blocks, null, 378, 16228, 16237)[blockIndex], "outBlock", 378, 16207, 16250);
                final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 379, 16285, 16290)[blockIndex], "tBlock", 379, 16264, 16303);
                final T[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockFieldMatrix.class, 380, 16338, 16338).blocks, null, 380, 16338, 16345)[blockIndex], "mBlock", 380, 16317, 16358);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, null, 381, 16392, 16399).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, null, 382, 16432, 16439)) {
                        if (CallChecker.beforeDeref(tBlock, null, 382, 16446, 16451)) {
                            if (CallChecker.beforeDeref(mBlock, null, 382, 16460, 16465)) {
                                if (CallChecker.beforeDeref(tBlock[k], null, 382, 16446, 16454)) {
                                    outBlock[k] = tBlock[k].add(mBlock[k]);
                                    CallChecker.varAssign(outBlock[k], "outBlock[k]", 382, 16432, 16470);
                                }
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3846.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> subtract(final FieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3847 = new MethodContext(FieldMatrix.class, 391, 16528, 18168);
        try {
            CallChecker.varInit(this, "this", 391, 16528, 18168);
            CallChecker.varInit(m, "m", 391, 16528, 18168);
            CallChecker.varInit(this.blockColumns, "blockColumns", 391, 16528, 18168);
            CallChecker.varInit(this.blockRows, "blockRows", 391, 16528, 18168);
            CallChecker.varInit(this.columns, "columns", 391, 16528, 18168);
            CallChecker.varInit(this.rows, "rows", 391, 16528, 18168);
            CallChecker.varInit(this.blocks, "blocks", 391, 16528, 18168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 391, 16528, 18168);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 391, 16528, 18168);
            TryContext _bcornu_try_context_81 = new TryContext(81, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                return subtract(((BlockFieldMatrix<T>) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_81.catchStart(81);
                checkSubtractionCompatible(m);
                final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 400, 16868, 16950);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 403, 17042, 17060);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 404, 17104, 17106).blockRows); ++iBlock) {
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 405, 17177, 17179).blockColumns); ++jBlock) {
                        final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 408, 17313, 17315).blocks, null, 408, 17313, 17322)[blockIndex], "outBlock", 408, 17292, 17335);
                        final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 409, 17378, 17383)[blockIndex], "tBlock", 409, 17357, 17396);
                        final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 410, 17418, 17463);
                        final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 411, 17485, 17550);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 412, 17572, 17617);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 413, 17639, 17707);
                        int k = CallChecker.varInit(((int) (0)), "k", 414, 17729, 17738);
                        for (int p = pStart; p < pEnd; ++p) {
                            for (int q = qStart; q < qEnd; ++q) {
                                if (CallChecker.beforeDeref(outBlock, null, 417, 17888, 17895)) {
                                    if (CallChecker.beforeDeref(tBlock, null, 417, 17902, 17907)) {
                                        if (CallChecker.beforeDeref(m, FieldMatrix.class, 417, 17921, 17921)) {
                                            if (CallChecker.beforeDeref(tBlock[k], null, 417, 17902, 17910)) {
                                                outBlock[k] = tBlock[k].subtract(m.getEntry(p, q));
                                                CallChecker.varAssign(outBlock[k], "outBlock[k]", 417, 17888, 17938);
                                            }
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
                _bcornu_try_context_81.finallyStart(81);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3847.methodEnd();
        }
    }

    public BlockFieldMatrix<T> subtract(final BlockFieldMatrix<T> m) throws MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3848 = new MethodContext(BlockFieldMatrix.class, 440, 18175, 19157);
        try {
            CallChecker.varInit(this, "this", 440, 18175, 19157);
            CallChecker.varInit(m, "m", 440, 18175, 19157);
            CallChecker.varInit(this.blockColumns, "blockColumns", 440, 18175, 19157);
            CallChecker.varInit(this.blockRows, "blockRows", 440, 18175, 19157);
            CallChecker.varInit(this.columns, "columns", 440, 18175, 19157);
            CallChecker.varInit(this.rows, "rows", 440, 18175, 19157);
            CallChecker.varInit(this.blocks, "blocks", 440, 18175, 19157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 440, 18175, 19157);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 440, 18175, 19157);
            checkSubtractionCompatible(m);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 444, 18587, 18669);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 447, 18791, 18793).blocks, null, 447, 18791, 18800).length); ++blockIndex) {
                final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 448, 18859, 18861).blocks, null, 448, 18859, 18868)[blockIndex], "outBlock", 448, 18838, 18881);
                final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 449, 18916, 18921)[blockIndex], "tBlock", 449, 18895, 18934);
                final T[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockFieldMatrix.class, 450, 18969, 18969).blocks, null, 450, 18969, 18976)[blockIndex], "mBlock", 450, 18948, 18989);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, null, 451, 19023, 19030).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, null, 452, 19063, 19070)) {
                        if (CallChecker.beforeDeref(tBlock, null, 452, 19077, 19082)) {
                            if (CallChecker.beforeDeref(mBlock, null, 452, 19096, 19101)) {
                                if (CallChecker.beforeDeref(tBlock[k], null, 452, 19077, 19085)) {
                                    outBlock[k] = tBlock[k].subtract(mBlock[k]);
                                    CallChecker.varAssign(outBlock[k], "outBlock[k]", 452, 19063, 19106);
                                }
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BlockFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3848.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> scalarAdd(final T d) {
        MethodContext _bcornu_methode_context3849 = new MethodContext(FieldMatrix.class, 461, 19164, 19758);
        try {
            CallChecker.varInit(this, "this", 461, 19164, 19758);
            CallChecker.varInit(d, "d", 461, 19164, 19758);
            CallChecker.varInit(this.blockColumns, "blockColumns", 461, 19164, 19758);
            CallChecker.varInit(this.blockRows, "blockRows", 461, 19164, 19758);
            CallChecker.varInit(this.columns, "columns", 461, 19164, 19758);
            CallChecker.varInit(this.rows, "rows", 461, 19164, 19758);
            CallChecker.varInit(this.blocks, "blocks", 461, 19164, 19758);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 461, 19164, 19758);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 461, 19164, 19758);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 462, 19256, 19338);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 465, 19460, 19462).blocks, null, 465, 19460, 19469).length); ++blockIndex) {
                final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 466, 19528, 19530).blocks, null, 466, 19528, 19537)[blockIndex], "outBlock", 466, 19507, 19550);
                final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 467, 19585, 19590)[blockIndex], "tBlock", 467, 19564, 19603);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, null, 468, 19637, 19644).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, null, 469, 19677, 19684)) {
                        if (CallChecker.beforeDeref(tBlock, null, 469, 19691, 19696)) {
                            if (CallChecker.beforeDeref(tBlock[k], null, 469, 19691, 19699)) {
                                outBlock[k] = tBlock[k].add(d);
                                CallChecker.varAssign(outBlock[k], "outBlock[k]", 469, 19677, 19707);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3849.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> scalarMultiply(final T d) {
        MethodContext _bcornu_methode_context3850 = new MethodContext(FieldMatrix.class, 478, 19765, 20370);
        try {
            CallChecker.varInit(this, "this", 478, 19765, 20370);
            CallChecker.varInit(d, "d", 478, 19765, 20370);
            CallChecker.varInit(this.blockColumns, "blockColumns", 478, 19765, 20370);
            CallChecker.varInit(this.blockRows, "blockRows", 478, 19765, 20370);
            CallChecker.varInit(this.columns, "columns", 478, 19765, 20370);
            CallChecker.varInit(this.rows, "rows", 478, 19765, 20370);
            CallChecker.varInit(this.blocks, "blocks", 478, 19765, 20370);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 478, 19765, 20370);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 478, 19765, 20370);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, columns), "out", 480, 19863, 19945);
            for (int blockIndex = 0; blockIndex < (CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 483, 20067, 20069).blocks, null, 483, 20067, 20076).length); ++blockIndex) {
                final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 484, 20135, 20137).blocks, null, 484, 20135, 20144)[blockIndex], "outBlock", 484, 20114, 20157);
                final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 485, 20192, 20197)[blockIndex], "tBlock", 485, 20171, 20210);
                for (int k = 0; k < (CallChecker.isCalled(outBlock, null, 486, 20244, 20251).length); ++k) {
                    if (CallChecker.beforeDeref(outBlock, null, 487, 20284, 20291)) {
                        if (CallChecker.beforeDeref(tBlock, null, 487, 20298, 20303)) {
                            if (CallChecker.beforeDeref(tBlock[k], null, 487, 20298, 20306)) {
                                outBlock[k] = tBlock[k].multiply(d);
                                CallChecker.varAssign(outBlock[k], "outBlock[k]", 487, 20284, 20319);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3850.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> multiply(final FieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3851 = new MethodContext(FieldMatrix.class, 496, 20377, 22838);
        try {
            CallChecker.varInit(this, "this", 496, 20377, 22838);
            CallChecker.varInit(m, "m", 496, 20377, 22838);
            CallChecker.varInit(this.blockColumns, "blockColumns", 496, 20377, 22838);
            CallChecker.varInit(this.blockRows, "blockRows", 496, 20377, 22838);
            CallChecker.varInit(this.columns, "columns", 496, 20377, 22838);
            CallChecker.varInit(this.rows, "rows", 496, 20377, 22838);
            CallChecker.varInit(this.blocks, "blocks", 496, 20377, 22838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 496, 20377, 22838);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 496, 20377, 22838);
            TryContext _bcornu_try_context_82 = new TryContext(82, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                return multiply(((BlockFieldMatrix<T>) (m)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_82.catchStart(82);
                checkMultiplicationCompatible(m);
                final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, CallChecker.isCalled(m, FieldMatrix.class, 505, 20788, 20788).getColumnDimension()), "out", 505, 20714, 20811);
                final T zero = CallChecker.varInit(getField().getZero(), "zero", 506, 20825, 20860);
                int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 509, 20955, 20973);
                for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 510, 21017, 21019).blockRows); ++iBlock) {
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 512, 21061, 21099);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 513, 21117, 21175);
                    for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 515, 21224, 21226).blockColumns); ++jBlock) {
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 517, 21275, 21313);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), CallChecker.isCalled(m, FieldMatrix.class, 518, 21388, 21388).getColumnDimension()))), "qEnd", 518, 21335, 21411);
                        final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 521, 21499, 21501).blocks, null, 521, 21499, 21508)[blockIndex], "outBlock", 521, 21478, 21521);
                        for (int kBlock = 0; kBlock < (blockColumns); ++kBlock) {
                            final int kWidth = CallChecker.varInit(((int) (blockWidth(kBlock))), "kWidth", 525, 21687, 21729);
                            final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 526, 21774, 21779)[((iBlock * (blockColumns)) + kBlock)], "tBlock", 526, 21755, 21812);
                            final int rStart = CallChecker.varInit(((int) (kBlock * (BlockFieldMatrix.BLOCK_SIZE))), "rStart", 527, 21838, 21881);
                            int k = CallChecker.varInit(((int) (0)), "k", 528, 21907, 21916);
                            for (int p = pStart; p < pEnd; ++p) {
                                final int lStart = CallChecker.varInit(((int) ((p - pStart) * kWidth)), "lStart", 530, 22008, 22048);
                                final int lEnd = CallChecker.varInit(((int) (lStart + kWidth)), "lEnd", 531, 22078, 22112);
                                for (int q = qStart; q < qEnd; ++q) {
                                    T sum = CallChecker.varInit(zero, "sum", 533, 22212, 22224);
                                    int r = CallChecker.varInit(((int) (rStart)), "r", 534, 22258, 22272);
                                    for (int l = lStart; l < lEnd; ++l) {
                                        if (CallChecker.beforeDeref(tBlock, null, 536, 22394, 22399)) {
                                            if (CallChecker.beforeDeref(m, FieldMatrix.class, 536, 22413, 22413)) {
                                                if (CallChecker.beforeDeref(tBlock[l], null, 536, 22394, 22402)) {
                                                    if (CallChecker.beforeDeref(sum, null, 536, 22386, 22388)) {
                                                        sum = sum.add(tBlock[l].multiply(m.getEntry(r, q)));
                                                        CallChecker.varAssign(sum, "sum", 536, 22380, 22431);
                                                    }
                                                }
                                            }
                                        }
                                        ++r;
                                    }
                                    if (CallChecker.beforeDeref(outBlock, null, 539, 22540, 22547)) {
                                        if (CallChecker.beforeDeref(outBlock, null, 539, 22554, 22561)) {
                                            if (CallChecker.beforeDeref(outBlock[k], null, 539, 22554, 22564)) {
                                                outBlock[k] = outBlock[k].add(sum);
                                                CallChecker.varAssign(outBlock[k], "outBlock[k]", 539, 22540, 22574);
                                            }
                                        }
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
                _bcornu_try_context_82.finallyStart(82);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3851.methodEnd();
        }
    }

    public BlockFieldMatrix<T> multiply(BlockFieldMatrix<T> m) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3852 = new MethodContext(BlockFieldMatrix.class, 562, 22845, 25893);
        try {
            CallChecker.varInit(this, "this", 562, 22845, 25893);
            CallChecker.varInit(m, "m", 562, 22845, 25893);
            CallChecker.varInit(this.blockColumns, "blockColumns", 562, 22845, 25893);
            CallChecker.varInit(this.blockRows, "blockRows", 562, 22845, 25893);
            CallChecker.varInit(this.columns, "columns", 562, 22845, 25893);
            CallChecker.varInit(this.rows, "rows", 562, 22845, 25893);
            CallChecker.varInit(this.blocks, "blocks", 562, 22845, 25893);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 562, 22845, 25893);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 562, 22845, 25893);
            checkMultiplicationCompatible(m);
            m = CallChecker.beforeCalled(m, BlockFieldMatrix.class, 568, 23345, 23345);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, CallChecker.isCalled(m, BlockFieldMatrix.class, 568, 23345, 23345).columns), "out", 568, 23271, 23355);
            final T zero = CallChecker.varInit(getField().getZero(), "zero", 569, 23365, 23400);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 572, 23487, 23505);
            for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 573, 23545, 23547).blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 575, 23585, 23623);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 576, 23637, 23695);
                for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 578, 23740, 23742).blockColumns); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockFieldMatrix.class, 579, 23805, 23807).blockWidth(jBlock))), "jWidth", 579, 23786, 23827);
                    final int jWidth2 = CallChecker.varInit(((int) (jWidth + jWidth)), "jWidth2", 580, 23845, 23881);
                    final int jWidth3 = CallChecker.varInit(((int) (jWidth2 + jWidth)), "jWidth3", 581, 23899, 23935);
                    final int jWidth4 = CallChecker.varInit(((int) (jWidth3 + jWidth)), "jWidth4", 582, 23953, 23989);
                    final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 585, 24069, 24071).blocks, null, 585, 24069, 24078)[blockIndex], "outBlock", 585, 24048, 24091);
                    for (int kBlock = 0; kBlock < (blockColumns); ++kBlock) {
                        final int kWidth = CallChecker.varInit(((int) (blockWidth(kBlock))), "kWidth", 589, 24245, 24282);
                        final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 590, 24323, 24328)[((iBlock * (blockColumns)) + kBlock)], "tBlock", 590, 24304, 24361);
                        m = CallChecker.beforeCalled(m, BlockFieldMatrix.class, 591, 24402, 24402);
                        m = CallChecker.beforeCalled(m, BlockFieldMatrix.class, 591, 24420, 24420);
                        final T[] mBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(m, BlockFieldMatrix.class, 591, 24402, 24402).blocks, null, 591, 24402, 24409)[((kBlock * (CallChecker.isCalled(m, BlockFieldMatrix.class, 591, 24420, 24420).blockColumns)) + jBlock)], "mBlock", 591, 24383, 24444);
                        int k = CallChecker.varInit(((int) (0)), "k", 592, 24466, 24475);
                        for (int p = pStart; p < pEnd; ++p) {
                            final int lStart = CallChecker.varInit(((int) ((p - pStart) * kWidth)), "lStart", 594, 24559, 24599);
                            final int lEnd = CallChecker.varInit(((int) (lStart + kWidth)), "lEnd", 595, 24625, 24659);
                            for (int nStart = 0; nStart < jWidth; ++nStart) {
                                T sum = CallChecker.varInit(zero, "sum", 597, 24763, 24775);
                                int l = CallChecker.varInit(((int) (lStart)), "l", 598, 24805, 24819);
                                int n = CallChecker.varInit(((int) (nStart)), "n", 599, 24849, 24863);
                                while (l < (lEnd - 3)) {
                                    if (CallChecker.beforeDeref(tBlock, null, 602, 25001, 25006)) {
                                        if (CallChecker.beforeDeref(mBlock, null, 602, 25020, 25025)) {
                                            if (CallChecker.beforeDeref(tBlock[l], null, 602, 25001, 25009)) {
                                                if (CallChecker.beforeDeref(sum, null, 601, 24954, 24956)) {
                                                    if (CallChecker.beforeDeref(tBlock, null, 603, 25075, 25080)) {
                                                        if (CallChecker.beforeDeref(mBlock, null, 603, 25098, 25103)) {
                                                            if (CallChecker.beforeDeref(tBlock[(l + 1)], null, 603, 25075, 25087)) {
                                                                final FieldElement<T> npe_invocation_var834 = sum.add(tBlock[l].multiply(mBlock[n]));
                                                                if (CallChecker.beforeDeref(npe_invocation_var834, FieldElement.class, 601, 24954, 25030)) {
                                                                    if (CallChecker.beforeDeref(tBlock, null, 604, 25162, 25167)) {
                                                                        if (CallChecker.beforeDeref(mBlock, null, 604, 25185, 25190)) {
                                                                            if (CallChecker.beforeDeref(tBlock[(l + 2)], null, 604, 25162, 25174)) {
                                                                                final FieldElement<T> npe_invocation_var835 = npe_invocation_var834.add(tBlock[(l + 1)].multiply(mBlock[(n + jWidth)]));
                                                                                if (CallChecker.beforeDeref(npe_invocation_var835, FieldElement.class, 601, 24954, 25117)) {
                                                                                    if (CallChecker.beforeDeref(tBlock, null, 605, 25250, 25255)) {
                                                                                        if (CallChecker.beforeDeref(mBlock, null, 605, 25273, 25278)) {
                                                                                            if (CallChecker.beforeDeref(tBlock[(l + 3)], null, 605, 25250, 25262)) {
                                                                                                final FieldElement<T> npe_invocation_var836 = npe_invocation_var835.add(tBlock[(l + 2)].multiply(mBlock[(n + jWidth2)]));
                                                                                                if (CallChecker.beforeDeref(npe_invocation_var836, FieldElement.class, 601, 24954, 25205)) {
                                                                                                    sum = npe_invocation_var836.add(tBlock[(l + 3)].multiply(mBlock[(n + jWidth3)]));
                                                                                                    CallChecker.varAssign(sum, "sum", 601, 24948, 25294);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    l += 4;
                                    CallChecker.varAssign(l, "l", 606, 25328, 25334);
                                    n += jWidth4;
                                    CallChecker.varAssign(n, "n", 607, 25368, 25380);
                                } 
                                while (l < lEnd) {
                                    if (CallChecker.beforeDeref(tBlock, null, 610, 25505, 25510)) {
                                        if (CallChecker.beforeDeref(mBlock, null, 610, 25526, 25531)) {
                                            if (CallChecker.beforeDeref(tBlock[l], null, 610, 25505, 25515)) {
                                                if (CallChecker.beforeDeref(sum, null, 610, 25497, 25499)) {
                                                    sum = sum.add(tBlock[(l++)].multiply(mBlock[n]));
                                                    CallChecker.varAssign(sum, "sum", 610, 25491, 25537);
                                                }
                                            }
                                        }
                                    }
                                    n += jWidth;
                                    CallChecker.varAssign(n, "n", 611, 25571, 25582);
                                } 
                                if (CallChecker.beforeDeref(outBlock, null, 613, 25642, 25649)) {
                                    if (CallChecker.beforeDeref(outBlock, null, 613, 25656, 25663)) {
                                        if (CallChecker.beforeDeref(outBlock[k], null, 613, 25656, 25666)) {
                                            outBlock[k] = outBlock[k].add(sum);
                                            CallChecker.varAssign(outBlock[k], "outBlock[k]", 613, 25642, 25676);
                                        }
                                    }
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
            return ((BlockFieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3852.methodEnd();
        }
    }

    @Override
    public T[][] getData() {
        MethodContext _bcornu_methode_context3853 = new MethodContext(null, 629, 25900, 27046);
        try {
            CallChecker.varInit(this, "this", 629, 25900, 27046);
            CallChecker.varInit(this.blockColumns, "blockColumns", 629, 25900, 27046);
            CallChecker.varInit(this.blockRows, "blockRows", 629, 25900, 27046);
            CallChecker.varInit(this.columns, "columns", 629, 25900, 27046);
            CallChecker.varInit(this.rows, "rows", 629, 25900, 27046);
            CallChecker.varInit(this.blocks, "blocks", 629, 25900, 27046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 629, 25900, 27046);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 629, 25900, 27046);
            final T[][] data = CallChecker.varInit(MathArrays.buildArray(getField(), getRowDimension(), getColumnDimension()), "data", 631, 25973, 26066);
            final int lastColumns = CallChecker.varInit(((int) ((this.columns) - (((this.blockColumns) - 1) * (BlockFieldMatrix.BLOCK_SIZE)))), "lastColumns", 632, 26076, 26141);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 635, 26217, 26255);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 636, 26269, 26327);
                int regularPos = CallChecker.varInit(((int) (0)), "regularPos", 637, 26341, 26361);
                int lastPos = CallChecker.varInit(((int) (0)), "lastPos", 638, 26375, 26395);
                for (int p = pStart; p < pEnd; ++p) {
                    final T[] dataP = CallChecker.varInit(CallChecker.isCalled(data, null, 640, 26481, 26484)[p], "dataP", 640, 26463, 26488);
                    int blockIndex = CallChecker.varInit(((int) (iBlock * (this.blockColumns))), "blockIndex", 641, 26506, 26544);
                    int dataPos = CallChecker.varInit(((int) (0)), "dataPos", 642, 26562, 26580);
                    for (int jBlock = 0; jBlock < ((blockColumns) - 1); ++jBlock) {
                        if (CallChecker.beforeDeref(blocks, null, 644, 26695, 26700)) {
                            System.arraycopy(CallChecker.isCalled(blocks, null, 644, 26695, 26700)[(blockIndex++)], regularPos, dataP, dataPos, BlockFieldMatrix.BLOCK_SIZE);
                        }
                        dataPos += BlockFieldMatrix.BLOCK_SIZE;
                        CallChecker.varAssign(dataPos, "dataPos", 645, 26778, 26799);
                    }
                    if (CallChecker.beforeDeref(blocks, null, 647, 26852, 26857)) {
                        System.arraycopy(CallChecker.isCalled(blocks, null, 647, 26852, 26857)[blockIndex], lastPos, dataP, dataPos, lastColumns);
                    }
                    regularPos += BlockFieldMatrix.BLOCK_SIZE;
                    CallChecker.varAssign(regularPos, "regularPos", 648, 26927, 26951);
                    lastPos += lastColumns;
                    CallChecker.varAssign(lastPos, "lastPos", 649, 26969, 26994);
                }
            }
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3853.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> getSubMatrix(final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3854 = new MethodContext(FieldMatrix.class, 658, 27053, 32305);
        try {
            CallChecker.varInit(this, "this", 658, 27053, 32305);
            CallChecker.varInit(endColumn, "endColumn", 658, 27053, 32305);
            CallChecker.varInit(startColumn, "startColumn", 658, 27053, 32305);
            CallChecker.varInit(endRow, "endRow", 658, 27053, 32305);
            CallChecker.varInit(startRow, "startRow", 658, 27053, 32305);
            CallChecker.varInit(this.blockColumns, "blockColumns", 658, 27053, 32305);
            CallChecker.varInit(this.blockRows, "blockRows", 658, 27053, 32305);
            CallChecker.varInit(this.columns, "columns", 658, 27053, 32305);
            CallChecker.varInit(this.rows, "rows", 658, 27053, 32305);
            CallChecker.varInit(this.blocks, "blocks", 658, 27053, 32305);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 658, 27053, 32305);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 658, 27053, 32305);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), ((endRow - startRow) + 1), ((endColumn - startColumn) + 1)), "out", 666, 27456, 27623);
            final int blockStartRow = CallChecker.varInit(((int) (startRow / (BlockFieldMatrix.BLOCK_SIZE))), "blockStartRow", 670, 27634, 27720);
            final int rowsShift = CallChecker.varInit(((int) (startRow % (BlockFieldMatrix.BLOCK_SIZE))), "rowsShift", 671, 27730, 27783);
            final int blockStartColumn = CallChecker.varInit(((int) (startColumn / (BlockFieldMatrix.BLOCK_SIZE))), "blockStartColumn", 672, 27793, 27846);
            final int columnsShift = CallChecker.varInit(((int) (startColumn % (BlockFieldMatrix.BLOCK_SIZE))), "columnsShift", 673, 27856, 27909);
            int pBlock = CallChecker.varInit(((int) (blockStartRow)), "pBlock", 676, 27992, 28018);
            for (int iBlock = 0; iBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 677, 28058, 28060).blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockFieldMatrix.class, 678, 28117, 28119).blockHeight(iBlock))), "iHeight", 678, 28097, 28140);
                int qBlock = CallChecker.varInit(((int) (blockStartColumn)), "qBlock", 679, 28154, 28183);
                for (int jBlock = 0; jBlock < (CallChecker.isCalled(out, BlockFieldMatrix.class, 680, 28227, 28229).blockColumns); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (CallChecker.isCalled(out, BlockFieldMatrix.class, 681, 28292, 28294).blockWidth(jBlock))), "jWidth", 681, 28273, 28314);
                    final int outIndex = CallChecker.varInit(((int) ((iBlock * (CallChecker.isCalled(out, BlockFieldMatrix.class, 684, 28425, 28427).blockColumns)) + jBlock)), "outIndex", 684, 28333, 28450);
                    final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 685, 28489, 28491).blocks, null, 685, 28489, 28498)[outIndex], "outBlock", 685, 28468, 28509);
                    final int index = CallChecker.varInit(((int) ((pBlock * (this.blockColumns)) + qBlock)), "index", 686, 28527, 28583);
                    final int width = CallChecker.varInit(((int) (blockWidth(qBlock))), "width", 687, 28601, 28645);
                    final int heightExcess = CallChecker.varInit(((int) ((iHeight + rowsShift) - (BlockFieldMatrix.BLOCK_SIZE))), "heightExcess", 689, 28664, 28721);
                    final int widthExcess = CallChecker.varInit(((int) ((jWidth + columnsShift) - (BlockFieldMatrix.BLOCK_SIZE))), "widthExcess", 690, 28739, 28798);
                    if (heightExcess > 0) {
                        if (widthExcess > 0) {
                            final int width2 = CallChecker.varInit(((int) (blockWidth((qBlock + 1)))), "width2", 695, 29000, 29141);
                            if (CallChecker.beforeDeref(blocks, null, 696, 29181, 29186)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 696, 29181, 29186)[index], width, rowsShift, BlockFieldMatrix.BLOCK_SIZE, columnsShift, BlockFieldMatrix.BLOCK_SIZE, outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, null, 700, 29429, 29434)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 700, 29429, 29434)[(index + 1)], width2, rowsShift, BlockFieldMatrix.BLOCK_SIZE, 0, widthExcess, outBlock, jWidth, 0, (jWidth - widthExcess));
                            }
                            if (CallChecker.beforeDeref(blocks, null, 704, 29691, 29696)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 704, 29691, 29696)[(index + (blockColumns))], width, 0, heightExcess, columnsShift, BlockFieldMatrix.BLOCK_SIZE, outBlock, jWidth, (iHeight - heightExcess), 0);
                            }
                            if (CallChecker.beforeDeref(blocks, null, 708, 29969, 29974)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 708, 29969, 29974)[((index + (blockColumns)) + 1)], width2, 0, heightExcess, 0, widthExcess, outBlock, jWidth, (iHeight - heightExcess), (jWidth - widthExcess));
                            }
                        }else {
                            if (CallChecker.beforeDeref(blocks, null, 714, 30388, 30393)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 714, 30388, 30393)[index], width, rowsShift, BlockFieldMatrix.BLOCK_SIZE, columnsShift, (jWidth + columnsShift), outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, null, 718, 30647, 30652)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 718, 30647, 30652)[(index + (blockColumns))], width, 0, heightExcess, columnsShift, (jWidth + columnsShift), outBlock, jWidth, (iHeight - heightExcess), 0);
                            }
                        }
                    }else {
                        if (widthExcess > 0) {
                            final int width2 = CallChecker.varInit(((int) (blockWidth((qBlock + 1)))), "width2", 727, 31103, 31244);
                            if (CallChecker.beforeDeref(blocks, null, 728, 31284, 31289)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 728, 31284, 31289)[index], width, rowsShift, (iHeight + rowsShift), columnsShift, BlockFieldMatrix.BLOCK_SIZE, outBlock, jWidth, 0, 0);
                            }
                            if (CallChecker.beforeDeref(blocks, null, 732, 31541, 31546)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 732, 31541, 31546)[(index + 1)], width2, rowsShift, (iHeight + rowsShift), 0, widthExcess, outBlock, jWidth, 0, (jWidth - widthExcess));
                            }
                        }else {
                            if (CallChecker.beforeDeref(blocks, null, 738, 31939, 31944)) {
                                copyBlockPart(CallChecker.isCalled(blocks, null, 738, 31939, 31944)[index], width, rowsShift, (iHeight + rowsShift), columnsShift, (jWidth + columnsShift), outBlock, jWidth, 0, 0);
                            }
                        }
                    }
                    ++qBlock;
                }
                ++pBlock;
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3854.methodEnd();
        }
    }

    private void copyBlockPart(final T[] srcBlock, final int srcWidth, final int srcStartRow, final int srcEndRow, final int srcStartColumn, final int srcEndColumn, final T[] dstBlock, final int dstWidth, final int dstStartRow, final int dstStartColumn) {
        MethodContext _bcornu_methode_context3855 = new MethodContext(void.class, 767, 32312, 33895);
        try {
            CallChecker.varInit(this, "this", 767, 32312, 33895);
            CallChecker.varInit(dstStartColumn, "dstStartColumn", 767, 32312, 33895);
            CallChecker.varInit(dstStartRow, "dstStartRow", 767, 32312, 33895);
            CallChecker.varInit(dstWidth, "dstWidth", 767, 32312, 33895);
            CallChecker.varInit(dstBlock, "dstBlock", 767, 32312, 33895);
            CallChecker.varInit(srcEndColumn, "srcEndColumn", 767, 32312, 33895);
            CallChecker.varInit(srcStartColumn, "srcStartColumn", 767, 32312, 33895);
            CallChecker.varInit(srcEndRow, "srcEndRow", 767, 32312, 33895);
            CallChecker.varInit(srcStartRow, "srcStartRow", 767, 32312, 33895);
            CallChecker.varInit(srcWidth, "srcWidth", 767, 32312, 33895);
            CallChecker.varInit(srcBlock, "srcBlock", 767, 32312, 33895);
            CallChecker.varInit(this.blockColumns, "blockColumns", 767, 32312, 33895);
            CallChecker.varInit(this.blockRows, "blockRows", 767, 32312, 33895);
            CallChecker.varInit(this.columns, "columns", 767, 32312, 33895);
            CallChecker.varInit(this.rows, "rows", 767, 32312, 33895);
            CallChecker.varInit(this.blocks, "blocks", 767, 32312, 33895);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 767, 32312, 33895);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 767, 32312, 33895);
            final int length = CallChecker.varInit(((int) (srcEndColumn - srcStartColumn)), "length", 772, 33498, 33546);
            int srcPos = CallChecker.varInit(((int) ((srcStartRow * srcWidth) + srcStartColumn)), "srcPos", 773, 33556, 33608);
            int dstPos = CallChecker.varInit(((int) ((dstStartRow * dstWidth) + dstStartColumn)), "dstPos", 774, 33618, 33670);
            for (int srcRow = srcStartRow; srcRow < srcEndRow; ++srcRow) {
                System.arraycopy(srcBlock, srcPos, dstBlock, dstPos, length);
                srcPos += srcWidth;
                CallChecker.varAssign(srcPos, "srcPos", 777, 33829, 33847);
                dstPos += dstWidth;
                CallChecker.varAssign(dstPos, "dstPos", 778, 33861, 33879);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3855.methodEnd();
        }
    }

    @Override
    public void setSubMatrix(final T[][] subMatrix, final int row, final int column) throws DimensionMismatchException, NoDataException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context3856 = new MethodContext(void.class, 784, 33902, 36328);
        try {
            CallChecker.varInit(this, "this", 784, 33902, 36328);
            CallChecker.varInit(column, "column", 784, 33902, 36328);
            CallChecker.varInit(row, "row", 784, 33902, 36328);
            CallChecker.varInit(subMatrix, "subMatrix", 784, 33902, 36328);
            CallChecker.varInit(this.blockColumns, "blockColumns", 784, 33902, 36328);
            CallChecker.varInit(this.blockRows, "blockRows", 784, 33902, 36328);
            CallChecker.varInit(this.columns, "columns", 784, 33902, 36328);
            CallChecker.varInit(this.rows, "rows", 784, 33902, 36328);
            CallChecker.varInit(this.blocks, "blocks", 784, 33902, 36328);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 784, 33902, 36328);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 784, 33902, 36328);
            MathUtils.checkNotNull(subMatrix);
            CallChecker.isCalled(subMatrix, null, 790, 34262, 34270)[0] = CallChecker.beforeCalled(CallChecker.isCalled(subMatrix, null, 790, 34262, 34270)[0], null, 790, 34262, 34273);
            final int refLength = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(subMatrix, null, 790, 34262, 34270)[0], null, 790, 34262, 34273).length)), "refLength", 790, 34240, 34281);
            if (refLength == 0) {
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            final int endRow = CallChecker.varInit(((int) ((row + (CallChecker.isCalled(subMatrix, null, 794, 34436, 34444).length)) - 1)), "endRow", 794, 34408, 34456);
            final int endColumn = CallChecker.varInit(((int) ((column + refLength) - 1)), "endColumn", 795, 34466, 34510);
            checkSubMatrixIndex(row, endRow, column, endColumn);
            if (CallChecker.beforeDeref(subMatrix, void.class, 797, 34605, 34613)) {
                for (final T[] subRow : subMatrix) {
                    if (CallChecker.beforeDeref(subRow, null, 798, 34634, 34639)) {
                        if ((CallChecker.isCalled(subRow, null, 798, 34634, 34639).length) != refLength) {
                            if (CallChecker.beforeDeref(subRow, null, 799, 34728, 34733)) {
                                throw new DimensionMismatchException(refLength, CallChecker.isCalled(subRow, null, 799, 34728, 34733).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }
            final int blockStartRow = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "blockStartRow", 804, 34777, 34855);
            final int blockEndRow = CallChecker.varInit(((int) ((endRow + (BlockFieldMatrix.BLOCK_SIZE)) / (BlockFieldMatrix.BLOCK_SIZE))), "blockEndRow", 805, 34865, 34928);
            final int blockStartColumn = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "blockStartColumn", 806, 34938, 34986);
            final int blockEndColumn = CallChecker.varInit(((int) ((endColumn + (BlockFieldMatrix.BLOCK_SIZE)) / (BlockFieldMatrix.BLOCK_SIZE))), "blockEndColumn", 807, 34996, 35062);
            for (int iBlock = blockStartRow; iBlock < blockEndRow; ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 811, 35218, 35258);
                final int firstRow = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "firstRow", 812, 35272, 35312);
                final int iStart = CallChecker.varInit(((int) (FastMath.max(row, firstRow))), "iStart", 813, 35326, 35377);
                final int iEnd = CallChecker.varInit(((int) (FastMath.min((endRow + 1), (firstRow + iHeight)))), "iEnd", 814, 35391, 35456);
                for (int jBlock = blockStartColumn; jBlock < blockEndColumn; ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 817, 35560, 35602);
                    final int firstColumn = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "firstColumn", 818, 35620, 35663);
                    final int jStart = CallChecker.varInit(((int) (FastMath.max(column, firstColumn))), "jStart", 819, 35681, 35741);
                    final int jEnd = CallChecker.varInit(((int) (FastMath.min((endColumn + 1), (firstColumn + jWidth)))), "jEnd", 820, 35759, 35832);
                    final int jLength = CallChecker.varInit(((int) (jEnd - jStart)), "jLength", 821, 35850, 35887);
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 824, 35972, 35977)[((iBlock * (blockColumns)) + jBlock)], "block", 824, 35954, 36010);
                    for (int i = iStart; i < iEnd; ++i) {
                        if (CallChecker.beforeDeref(subMatrix, null, 826, 36103, 36111)) {
                            System.arraycopy(CallChecker.isCalled(subMatrix, null, 826, 36103, 36111)[(i - row)], (jStart - column), block, (((i - firstRow) * jWidth) + (jStart - firstColumn)), jLength);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3856.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> getRowMatrix(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3857 = new MethodContext(FieldMatrix.class, 837, 36335, 37617);
        try {
            CallChecker.varInit(this, "this", 837, 36335, 37617);
            CallChecker.varInit(row, "row", 837, 36335, 37617);
            CallChecker.varInit(this.blockColumns, "blockColumns", 837, 36335, 37617);
            CallChecker.varInit(this.blockRows, "blockRows", 837, 36335, 37617);
            CallChecker.varInit(this.columns, "columns", 837, 36335, 37617);
            CallChecker.varInit(this.rows, "rows", 837, 36335, 37617);
            CallChecker.varInit(this.blocks, "blocks", 837, 36335, 37617);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 837, 36335, 37617);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 837, 36335, 37617);
            checkRowIndex(row);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), 1, columns), "out", 840, 36497, 36576);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 843, 36587, 36689);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "iRow", 844, 36699, 36744);
            int outBlockIndex = CallChecker.varInit(((int) (0)), "outBlockIndex", 845, 36754, 36775);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 846, 36785, 36806);
            T[] outBlock = CallChecker.init(null);
            if (CallChecker.beforeDeref(out, BlockFieldMatrix.class, 847, 36831, 36833)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockFieldMatrix.class, 847, 36831, 36833).blocks, null, 847, 36831, 36840)) {
                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 847, 36831, 36833).blocks, null, 847, 36831, 36840)[outBlockIndex];
                    CallChecker.varAssign(outBlock, "outBlock", 847, 36831, 36833);
                }
            }
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 849, 36934, 36975);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 850, 37007, 37012)[((iBlock * (blockColumns)) + jBlock)], "block", 850, 36989, 37045);
                outBlock = CallChecker.beforeCalled(outBlock, null, 851, 37082, 37089);
                final int available = CallChecker.varInit(((int) ((CallChecker.isCalled(outBlock, null, 851, 37082, 37089).length) - outIndex)), "available", 851, 37059, 37108);
                if (jWidth > available) {
                    System.arraycopy(block, (iRow * jWidth), outBlock, outIndex, available);
                    if (CallChecker.beforeDeref(out, BlockFieldMatrix.class, 854, 37262, 37264)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockFieldMatrix.class, 854, 37262, 37264).blocks, null, 854, 37262, 37271)) {
                            outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 854, 37262, 37264).blocks, null, 854, 37262, 37271)[(++outBlockIndex)];
                            CallChecker.varAssign(outBlock, "outBlock", 854, 37251, 37289);
                        }
                    }
                    System.arraycopy(block, (iRow * jWidth), outBlock, 0, (jWidth - available));
                    outIndex = jWidth - available;
                    CallChecker.varAssign(outIndex, "outIndex", 856, 37396, 37425);
                }else {
                    System.arraycopy(block, (iRow * jWidth), outBlock, outIndex, jWidth);
                    outIndex += jWidth;
                    CallChecker.varAssign(outIndex, "outIndex", 859, 37548, 37566);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3857.methodEnd();
        }
    }

    @Override
    public void setRowMatrix(final int row, final FieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3858 = new MethodContext(void.class, 868, 37624, 37980);
        try {
            CallChecker.varInit(this, "this", 868, 37624, 37980);
            CallChecker.varInit(matrix, "matrix", 868, 37624, 37980);
            CallChecker.varInit(row, "row", 868, 37624, 37980);
            CallChecker.varInit(this.blockColumns, "blockColumns", 868, 37624, 37980);
            CallChecker.varInit(this.blockRows, "blockRows", 868, 37624, 37980);
            CallChecker.varInit(this.columns, "columns", 868, 37624, 37980);
            CallChecker.varInit(this.rows, "rows", 868, 37624, 37980);
            CallChecker.varInit(this.blocks, "blocks", 868, 37624, 37980);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 868, 37624, 37980);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 868, 37624, 37980);
            TryContext _bcornu_try_context_83 = new TryContext(83, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                setRowMatrix(row, ((BlockFieldMatrix<T>) (matrix)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_83.catchStart(83);
                super.setRowMatrix(row, matrix);
            } finally {
                _bcornu_try_context_83.finallyStart(83);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3858.methodEnd();
        }
    }

    public void setRowMatrix(final int row, final BlockFieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3859 = new MethodContext(void.class, 888, 37987, 39998);
        try {
            CallChecker.varInit(this, "this", 888, 37987, 39998);
            CallChecker.varInit(matrix, "matrix", 888, 37987, 39998);
            CallChecker.varInit(row, "row", 888, 37987, 39998);
            CallChecker.varInit(this.blockColumns, "blockColumns", 888, 37987, 39998);
            CallChecker.varInit(this.blockRows, "blockRows", 888, 37987, 39998);
            CallChecker.varInit(this.columns, "columns", 888, 37987, 39998);
            CallChecker.varInit(this.rows, "rows", 888, 37987, 39998);
            CallChecker.varInit(this.blocks, "blocks", 888, 37987, 39998);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 888, 37987, 39998);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 888, 37987, 39998);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 891, 38622, 38660);
            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 892, 38675, 38680)) {
                if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 893, 38722, 38727)) {
                    if (((CallChecker.isCalled(matrix, BlockFieldMatrix.class, 892, 38675, 38680).getRowDimension()) != 1) || ((CallChecker.isCalled(matrix, BlockFieldMatrix.class, 893, 38722, 38727).getColumnDimension()) != nCols)) {
                        if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 894, 38818, 38823)) {
                            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 895, 38899, 38904)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 894, 38818, 38823).getRowDimension(), CallChecker.isCalled(matrix, BlockFieldMatrix.class, 895, 38899, 38904).getColumnDimension(), 1, nCols);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 900, 39013, 39114);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "iRow", 901, 39124, 39168);
            int mBlockIndex = CallChecker.varInit(((int) (0)), "mBlockIndex", 902, 39178, 39198);
            int mIndex = CallChecker.varInit(((int) (0)), "mIndex", 903, 39208, 39228);
            T[] mBlock = CallChecker.init(null);
            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 904, 39252, 39257)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 904, 39252, 39257).blocks, null, 904, 39252, 39264)) {
                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 904, 39252, 39257).blocks, null, 904, 39252, 39264)[mBlockIndex];
                    CallChecker.varAssign(mBlock, "mBlock", 904, 39252, 39257);
                }
            }
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 906, 39356, 39397);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 907, 39429, 39434)[((iBlock * (blockColumns)) + jBlock)], "block", 907, 39411, 39467);
                mBlock = CallChecker.beforeCalled(mBlock, null, 908, 39504, 39509);
                final int available = CallChecker.varInit(((int) ((CallChecker.isCalled(mBlock, null, 908, 39504, 39509).length) - mIndex)), "available", 908, 39481, 39526);
                if (jWidth > available) {
                    System.arraycopy(mBlock, mIndex, block, (iRow * jWidth), available);
                    if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 911, 39674, 39679)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 911, 39674, 39679).blocks, null, 911, 39674, 39686)) {
                            mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 911, 39674, 39679).blocks, null, 911, 39674, 39686)[(++mBlockIndex)];
                            CallChecker.varAssign(mBlock, "mBlock", 911, 39665, 39702);
                        }
                    }
                    System.arraycopy(mBlock, 0, block, (iRow * jWidth), (jWidth - available));
                    mIndex = jWidth - available;
                    CallChecker.varAssign(mIndex, "mIndex", 913, 39807, 39834);
                }else {
                    System.arraycopy(mBlock, mIndex, block, (iRow * jWidth), jWidth);
                    mIndex += jWidth;
                    CallChecker.varAssign(mIndex, "mIndex", 916, 39953, 39969);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3859.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> getColumnMatrix(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3860 = new MethodContext(FieldMatrix.class, 923, 40005, 41103);
        try {
            CallChecker.varInit(this, "this", 923, 40005, 41103);
            CallChecker.varInit(column, "column", 923, 40005, 41103);
            CallChecker.varInit(this.blockColumns, "blockColumns", 923, 40005, 41103);
            CallChecker.varInit(this.blockRows, "blockRows", 923, 40005, 41103);
            CallChecker.varInit(this.columns, "columns", 923, 40005, 41103);
            CallChecker.varInit(this.rows, "rows", 923, 40005, 41103);
            CallChecker.varInit(this.blocks, "blocks", 923, 40005, 41103);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 923, 40005, 41103);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 923, 40005, 41103);
            checkColumnIndex(column);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), rows, 1), "out", 926, 40179, 40255);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 929, 40266, 40371);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "jColumn", 930, 40381, 40429);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 931, 40439, 40477);
            int outBlockIndex = CallChecker.varInit(((int) (0)), "outBlockIndex", 932, 40487, 40508);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 933, 40518, 40539);
            T[] outBlock = CallChecker.init(null);
            if (CallChecker.beforeDeref(out, BlockFieldMatrix.class, 934, 40564, 40566)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockFieldMatrix.class, 934, 40564, 40566).blocks, null, 934, 40564, 40573)) {
                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 934, 40564, 40566).blocks, null, 934, 40564, 40573)[outBlockIndex];
                    CallChecker.varAssign(outBlock, "outBlock", 934, 40564, 40566);
                }
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 936, 40664, 40703);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 937, 40735, 40740)[((iBlock * (blockColumns)) + jBlock)], "block", 937, 40717, 40773);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(outBlock, null, 939, 40855, 40862)) {
                        outBlock = CallChecker.beforeCalled(outBlock, null, 939, 40855, 40862);
                        if (outIndex >= (CallChecker.isCalled(outBlock, null, 939, 40855, 40862).length)) {
                            if (CallChecker.beforeDeref(out, BlockFieldMatrix.class, 940, 40905, 40907)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(out, BlockFieldMatrix.class, 940, 40905, 40907).blocks, null, 940, 40905, 40914)) {
                                    outBlock = CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 940, 40905, 40907).blocks, null, 940, 40905, 40914)[(++outBlockIndex)];
                                    CallChecker.varAssign(outBlock, "outBlock", 940, 40894, 40932);
                                }
                            }
                            outIndex = 0;
                            CallChecker.varAssign(outIndex, "outIndex", 941, 40954, 40966);
                        }
                    }
                    if (CallChecker.beforeDeref(outBlock, null, 943, 41002, 41009)) {
                        if (CallChecker.beforeDeref(block, null, 943, 41025, 41029)) {
                            outBlock[(outIndex++)] = block[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(outBlock[(outIndex - 1)], "outBlock[(outIndex - 1)]", 943, 41002, 41052);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3860.methodEnd();
        }
    }

    @Override
    public void setColumnMatrix(final int column, final FieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3861 = new MethodContext(void.class, 952, 41110, 41484);
        try {
            CallChecker.varInit(this, "this", 952, 41110, 41484);
            CallChecker.varInit(matrix, "matrix", 952, 41110, 41484);
            CallChecker.varInit(column, "column", 952, 41110, 41484);
            CallChecker.varInit(this.blockColumns, "blockColumns", 952, 41110, 41484);
            CallChecker.varInit(this.blockRows, "blockRows", 952, 41110, 41484);
            CallChecker.varInit(this.columns, "columns", 952, 41110, 41484);
            CallChecker.varInit(this.rows, "rows", 952, 41110, 41484);
            CallChecker.varInit(this.blocks, "blocks", 952, 41110, 41484);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 952, 41110, 41484);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 952, 41110, 41484);
            TryContext _bcornu_try_context_84 = new TryContext(84, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                setColumnMatrix(column, ((BlockFieldMatrix<T>) (matrix)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_84.catchStart(84);
                super.setColumnMatrix(column, matrix);
            } finally {
                _bcornu_try_context_84.finallyStart(84);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3861.methodEnd();
        }
    }

    void setColumnMatrix(final int column, final BlockFieldMatrix<T> matrix) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3862 = new MethodContext(void.class, 972, 41491, 43339);
        try {
            CallChecker.varInit(this, "this", 972, 41491, 43339);
            CallChecker.varInit(matrix, "matrix", 972, 41491, 43339);
            CallChecker.varInit(column, "column", 972, 41491, 43339);
            CallChecker.varInit(this.blockColumns, "blockColumns", 972, 41491, 43339);
            CallChecker.varInit(this.blockRows, "blockRows", 972, 41491, 43339);
            CallChecker.varInit(this.columns, "columns", 972, 41491, 43339);
            CallChecker.varInit(this.rows, "rows", 972, 41491, 43339);
            CallChecker.varInit(this.blocks, "blocks", 972, 41491, 43339);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 972, 41491, 43339);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 972, 41491, 43339);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 975, 42151, 42186);
            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 976, 42201, 42206)) {
                if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 977, 42252, 42257)) {
                    if (((CallChecker.isCalled(matrix, BlockFieldMatrix.class, 976, 42201, 42206).getRowDimension()) != nRows) || ((CallChecker.isCalled(matrix, BlockFieldMatrix.class, 977, 42252, 42257).getColumnDimension()) != 1)) {
                        if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 978, 42344, 42349)) {
                            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 979, 42425, 42430)) {
                                throw new MatrixDimensionMismatchException(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 978, 42344, 42349).getRowDimension(), CallChecker.isCalled(matrix, BlockFieldMatrix.class, 979, 42425, 42430).getColumnDimension(), nRows, 1);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 984, 42539, 42644);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "jColumn", 985, 42654, 42702);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 986, 42712, 42750);
            int mBlockIndex = CallChecker.varInit(((int) (0)), "mBlockIndex", 987, 42760, 42779);
            int mIndex = CallChecker.varInit(((int) (0)), "mIndex", 988, 42789, 42808);
            T[] mBlock = CallChecker.init(null);
            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 989, 42831, 42836)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 989, 42831, 42836).blocks, null, 989, 42831, 42843)) {
                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 989, 42831, 42836).blocks, null, 989, 42831, 42843)[mBlockIndex];
                    CallChecker.varAssign(mBlock, "mBlock", 989, 42831, 42836);
                }
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 991, 42932, 42971);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 992, 43003, 43008)[((iBlock * (blockColumns)) + jBlock)], "block", 992, 42985, 43041);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(mBlock, null, 994, 43121, 43126)) {
                        mBlock = CallChecker.beforeCalled(mBlock, null, 994, 43121, 43126);
                        if (mIndex >= (CallChecker.isCalled(mBlock, null, 994, 43121, 43126).length)) {
                            if (CallChecker.beforeDeref(matrix, BlockFieldMatrix.class, 995, 43167, 43172)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 995, 43167, 43172).blocks, null, 995, 43167, 43179)) {
                                    mBlock = CallChecker.isCalled(CallChecker.isCalled(matrix, BlockFieldMatrix.class, 995, 43167, 43172).blocks, null, 995, 43167, 43179)[(++mBlockIndex)];
                                    CallChecker.varAssign(mBlock, "mBlock", 995, 43158, 43195);
                                }
                            }
                            mIndex = 0;
                            CallChecker.varAssign(mIndex, "mIndex", 996, 43217, 43227);
                        }
                    }
                    if (CallChecker.beforeDeref(block, null, 998, 43263, 43267)) {
                        if (CallChecker.beforeDeref(mBlock, null, 998, 43293, 43298)) {
                            block[((i * jWidth) + jColumn)] = mBlock[(mIndex++)];
                            CallChecker.varAssign(block[((i * jWidth) + jColumn)], "block[((i * jWidth) + jColumn)]", 998, 43263, 43309);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3862.methodEnd();
        }
    }

    @Override
    public FieldVector<T> getRowVector(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3863 = new MethodContext(FieldVector.class, 1005, 43346, 44154);
        try {
            CallChecker.varInit(this, "this", 1005, 43346, 44154);
            CallChecker.varInit(row, "row", 1005, 43346, 44154);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1005, 43346, 44154);
            CallChecker.varInit(this.blockRows, "blockRows", 1005, 43346, 44154);
            CallChecker.varInit(this.columns, "columns", 1005, 43346, 44154);
            CallChecker.varInit(this.rows, "rows", 1005, 43346, 44154);
            CallChecker.varInit(this.blocks, "blocks", 1005, 43346, 44154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1005, 43346, 44154);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1005, 43346, 44154);
            checkRowIndex(row);
            final T[] outData = CallChecker.varInit(MathArrays.buildArray(getField(), columns), "outData", 1008, 43508, 43570);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1011, 43581, 43683);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "iRow", 1012, 43693, 43738);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1013, 43748, 43769);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1015, 43847, 43888);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1016, 43920, 43925)[((iBlock * (blockColumns)) + jBlock)], "block", 1016, 43902, 43958);
                System.arraycopy(block, (iRow * jWidth), outData, outIndex, jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1018, 44051, 44069);
            }
            return new ArrayFieldVector<T>(getField(), outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3863.methodEnd();
        }
    }

    @Override
    public void setRowVector(final int row, final FieldVector<T> vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3864 = new MethodContext(void.class, 1026, 44161, 44526);
        try {
            CallChecker.varInit(this, "this", 1026, 44161, 44526);
            CallChecker.varInit(vector, "vector", 1026, 44161, 44526);
            CallChecker.varInit(row, "row", 1026, 44161, 44526);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1026, 44161, 44526);
            CallChecker.varInit(this.blockRows, "blockRows", 1026, 44161, 44526);
            CallChecker.varInit(this.columns, "columns", 1026, 44161, 44526);
            CallChecker.varInit(this.rows, "rows", 1026, 44161, 44526);
            CallChecker.varInit(this.blocks, "blocks", 1026, 44161, 44526);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1026, 44161, 44526);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1026, 44161, 44526);
            TryContext _bcornu_try_context_85 = new TryContext(85, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(vector, FieldVector.class, 1029, 44401, 44406)) {
                    setRow(row, CallChecker.isCalled(((ArrayFieldVector<T>) (vector)), ArrayFieldVector.class, 1029, 44401, 44406).getDataRef());
                }
            } catch (ClassCastException cce) {
                _bcornu_try_context_85.catchStart(85);
                super.setRowVector(row, vector);
            } finally {
                _bcornu_try_context_85.finallyStart(85);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3864.methodEnd();
        }
    }

    @Override
    public FieldVector<T> getColumnVector(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3865 = new MethodContext(FieldVector.class, 1037, 44533, 45417);
        try {
            CallChecker.varInit(this, "this", 1037, 44533, 45417);
            CallChecker.varInit(column, "column", 1037, 44533, 45417);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1037, 44533, 45417);
            CallChecker.varInit(this.blockRows, "blockRows", 1037, 44533, 45417);
            CallChecker.varInit(this.columns, "columns", 1037, 44533, 45417);
            CallChecker.varInit(this.rows, "rows", 1037, 44533, 45417);
            CallChecker.varInit(this.blocks, "blocks", 1037, 44533, 45417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1037, 44533, 45417);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1037, 44533, 45417);
            checkColumnIndex(column);
            final T[] outData = CallChecker.varInit(MathArrays.buildArray(getField(), rows), "outData", 1040, 44707, 44766);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1043, 44777, 44882);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "jColumn", 1044, 44892, 44940);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1045, 44950, 44988);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1046, 44998, 45019);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1048, 45094, 45133);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1049, 45165, 45170)[((iBlock * (blockColumns)) + jBlock)], "block", 1049, 45147, 45203);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(outData, null, 1051, 45269, 45275)) {
                        if (CallChecker.beforeDeref(block, null, 1051, 45291, 45295)) {
                            outData[(outIndex++)] = block[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(outData[(outIndex - 1)], "outData[(outIndex - 1)]", 1051, 45269, 45318);
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(getField(), outData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3865.methodEnd();
        }
    }

    @Override
    public void setColumnVector(final int column, final FieldVector<T> vector) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3866 = new MethodContext(void.class, 1060, 45424, 45807);
        try {
            CallChecker.varInit(this, "this", 1060, 45424, 45807);
            CallChecker.varInit(vector, "vector", 1060, 45424, 45807);
            CallChecker.varInit(column, "column", 1060, 45424, 45807);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1060, 45424, 45807);
            CallChecker.varInit(this.blockRows, "blockRows", 1060, 45424, 45807);
            CallChecker.varInit(this.columns, "columns", 1060, 45424, 45807);
            CallChecker.varInit(this.rows, "rows", 1060, 45424, 45807);
            CallChecker.varInit(this.blocks, "blocks", 1060, 45424, 45807);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1060, 45424, 45807);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1060, 45424, 45807);
            TryContext _bcornu_try_context_86 = new TryContext(86, BlockFieldMatrix.class, "java.lang.ClassCastException");
            try {
                if (CallChecker.beforeDeref(vector, FieldVector.class, 1063, 45676, 45681)) {
                    setColumn(column, CallChecker.isCalled(((ArrayFieldVector<T>) (vector)), ArrayFieldVector.class, 1063, 45676, 45681).getDataRef());
                }
            } catch (ClassCastException cce) {
                _bcornu_try_context_86.catchStart(86);
                super.setColumnVector(column, vector);
            } finally {
                _bcornu_try_context_86.finallyStart(86);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3866.methodEnd();
        }
    }

    @Override
    public T[] getRow(final int row) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3867 = new MethodContext(null, 1071, 45814, 46541);
        try {
            CallChecker.varInit(this, "this", 1071, 45814, 46541);
            CallChecker.varInit(row, "row", 1071, 45814, 46541);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1071, 45814, 46541);
            CallChecker.varInit(this.blockRows, "blockRows", 1071, 45814, 46541);
            CallChecker.varInit(this.columns, "columns", 1071, 45814, 46541);
            CallChecker.varInit(this.rows, "rows", 1071, 45814, 46541);
            CallChecker.varInit(this.blocks, "blocks", 1071, 45814, 46541);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1071, 45814, 46541);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1071, 45814, 46541);
            checkRowIndex(row);
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), columns), "out", 1073, 45951, 46009);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1076, 46020, 46122);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "iRow", 1077, 46132, 46177);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1078, 46187, 46208);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1080, 46286, 46327);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1081, 46359, 46364)[((iBlock * (blockColumns)) + jBlock)], "block", 1081, 46341, 46397);
                System.arraycopy(block, (iRow * jWidth), out, outIndex, jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1083, 46486, 46504);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3867.methodEnd();
        }
    }

    @Override
    public void setRow(final int row, final T[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3868 = new MethodContext(void.class, 1091, 46548, 47426);
        try {
            CallChecker.varInit(this, "this", 1091, 46548, 47426);
            CallChecker.varInit(array, "array", 1091, 46548, 47426);
            CallChecker.varInit(row, "row", 1091, 46548, 47426);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1091, 46548, 47426);
            CallChecker.varInit(this.blockRows, "blockRows", 1091, 46548, 47426);
            CallChecker.varInit(this.columns, "columns", 1091, 46548, 47426);
            CallChecker.varInit(this.rows, "rows", 1091, 46548, 47426);
            CallChecker.varInit(this.blocks, "blocks", 1091, 46548, 47426);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1091, 46548, 47426);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1091, 46548, 47426);
            checkRowIndex(row);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 1094, 46745, 46783);
            if (CallChecker.beforeDeref(array, null, 1095, 46797, 46801)) {
                if ((CallChecker.isCalled(array, null, 1095, 46797, 46801).length) != nCols) {
                    if (CallChecker.beforeDeref(array, null, 1096, 46880, 46884)) {
                        throw new MatrixDimensionMismatchException(1, CallChecker.isCalled(array, null, 1096, 46880, 46884).length, 1, nCols);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1100, 46924, 47026);
            final int iRow = CallChecker.varInit(((int) (row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "iRow", 1101, 47036, 47081);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1102, 47091, 47112);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1104, 47190, 47231);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1105, 47263, 47268)[((iBlock * (blockColumns)) + jBlock)], "block", 1105, 47245, 47301);
                System.arraycopy(array, outIndex, block, (iRow * jWidth), jWidth);
                outIndex += jWidth;
                CallChecker.varAssign(outIndex, "outIndex", 1107, 47392, 47410);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3868.methodEnd();
        }
    }

    @Override
    public T[] getColumn(final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3869 = new MethodContext(null, 1113, 47433, 48236);
        try {
            CallChecker.varInit(this, "this", 1113, 47433, 48236);
            CallChecker.varInit(column, "column", 1113, 47433, 48236);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1113, 47433, 48236);
            CallChecker.varInit(this.blockRows, "blockRows", 1113, 47433, 48236);
            CallChecker.varInit(this.columns, "columns", 1113, 47433, 48236);
            CallChecker.varInit(this.rows, "rows", 1113, 47433, 48236);
            CallChecker.varInit(this.blocks, "blocks", 1113, 47433, 48236);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1113, 47433, 48236);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1113, 47433, 48236);
            checkColumnIndex(column);
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), rows), "out", 1115, 47582, 47637);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1118, 47648, 47753);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "jColumn", 1119, 47763, 47811);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1120, 47821, 47859);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1121, 47869, 47890);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1123, 47965, 48004);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1124, 48036, 48041)[((iBlock * (blockColumns)) + jBlock)], "block", 1124, 48018, 48074);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(out, null, 1126, 48140, 48142)) {
                        if (CallChecker.beforeDeref(block, null, 1126, 48158, 48162)) {
                            out[(outIndex++)] = block[((i * jWidth) + jColumn)];
                            CallChecker.varAssign(out[(outIndex - 1)], "out[(outIndex - 1)]", 1126, 48140, 48185);
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3869.methodEnd();
        }
    }

    @Override
    public void setColumn(final int column, final T[] array) throws OutOfRangeException, MatrixDimensionMismatchException {
        MethodContext _bcornu_methode_context3870 = new MethodContext(void.class, 1135, 48243, 49197);
        try {
            CallChecker.varInit(this, "this", 1135, 48243, 49197);
            CallChecker.varInit(array, "array", 1135, 48243, 49197);
            CallChecker.varInit(column, "column", 1135, 48243, 49197);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1135, 48243, 49197);
            CallChecker.varInit(this.blockRows, "blockRows", 1135, 48243, 49197);
            CallChecker.varInit(this.columns, "columns", 1135, 48243, 49197);
            CallChecker.varInit(this.rows, "rows", 1135, 48243, 49197);
            CallChecker.varInit(this.blocks, "blocks", 1135, 48243, 49197);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1135, 48243, 49197);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1135, 48243, 49197);
            checkColumnIndex(column);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 1138, 48452, 48487);
            if (CallChecker.beforeDeref(array, null, 1139, 48501, 48505)) {
                if ((CallChecker.isCalled(array, null, 1139, 48501, 48505).length) != nRows) {
                    if (CallChecker.beforeDeref(array, null, 1140, 48581, 48585)) {
                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(array, null, 1140, 48581, 48585).length, 1, nRows, 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1144, 48628, 48733);
            final int jColumn = CallChecker.varInit(((int) (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE)))), "jColumn", 1145, 48743, 48791);
            final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1146, 48801, 48839);
            int outIndex = CallChecker.varInit(((int) (0)), "outIndex", 1147, 48849, 48870);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int iHeight = CallChecker.varInit(((int) (blockHeight(iBlock))), "iHeight", 1149, 48945, 48984);
                final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1150, 49016, 49021)[((iBlock * (blockColumns)) + jBlock)], "block", 1150, 48998, 49054);
                for (int i = 0; i < iHeight; ++i) {
                    if (CallChecker.beforeDeref(block, null, 1152, 49120, 49124)) {
                        if (CallChecker.beforeDeref(array, null, 1152, 49150, 49154)) {
                            block[((i * jWidth) + jColumn)] = array[(outIndex++)];
                            CallChecker.varAssign(block[((i * jWidth) + jColumn)], "block[((i * jWidth) + jColumn)]", 1152, 49120, 49167);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3870.methodEnd();
        }
    }

    @Override
    public T getEntry(final int row, final int column) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3871 = new MethodContext(null, 1159, 49204, 49678);
        try {
            CallChecker.varInit(this, "this", 1159, 49204, 49678);
            CallChecker.varInit(column, "column", 1159, 49204, 49678);
            CallChecker.varInit(row, "row", 1159, 49204, 49678);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1159, 49204, 49678);
            CallChecker.varInit(this.blockRows, "blockRows", 1159, 49204, 49678);
            CallChecker.varInit(this.columns, "columns", 1159, 49204, 49678);
            CallChecker.varInit(this.rows, "rows", 1159, 49204, 49678);
            CallChecker.varInit(this.blocks, "blocks", 1159, 49204, 49678);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1159, 49204, 49678);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1159, 49204, 49678);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1164, 49402, 49440);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1165, 49450, 49488);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE))))), "k", 1166, 49498, 49613);
            if (CallChecker.beforeDeref(blocks, null, 1169, 49631, 49636)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, null, 1169, 49631, 49636)[((iBlock * (blockColumns)) + jBlock)], null, 1169, 49631, 49668)) {
                    return CallChecker.isCalled(blocks, null, 1169, 49631, 49636)[((iBlock * (blockColumns)) + jBlock)][k];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3871.methodEnd();
        }
    }

    @Override
    public void setEntry(final int row, final int column, final T value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3872 = new MethodContext(void.class, 1174, 49685, 50178);
        try {
            CallChecker.varInit(this, "this", 1174, 49685, 50178);
            CallChecker.varInit(value, "value", 1174, 49685, 50178);
            CallChecker.varInit(column, "column", 1174, 49685, 50178);
            CallChecker.varInit(row, "row", 1174, 49685, 50178);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1174, 49685, 50178);
            CallChecker.varInit(this.blockRows, "blockRows", 1174, 49685, 50178);
            CallChecker.varInit(this.columns, "columns", 1174, 49685, 50178);
            CallChecker.varInit(this.rows, "rows", 1174, 49685, 50178);
            CallChecker.varInit(this.blocks, "blocks", 1174, 49685, 50178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1174, 49685, 50178);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1174, 49685, 50178);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1179, 49901, 49939);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1180, 49949, 49987);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE))))), "k", 1181, 49997, 50112);
            if (CallChecker.beforeDeref(blocks, null, 1184, 50123, 50128)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(blocks, null, 1184, 50123, 50128)[((iBlock * (blockColumns)) + jBlock)], null, 1184, 50123, 50160)) {
                    CallChecker.isCalled(blocks, null, 1184, 50123, 50128)[((iBlock * (blockColumns)) + jBlock)][k] = value;
                    CallChecker.varAssign(CallChecker.isCalled(this.blocks, null, 1184, 50123, 50128)[((iBlock * (this.blockColumns)) + jBlock)][k], "CallChecker.isCalled(this.blocks, null, 1184, 50123, 50128)[((iBlock * (this.blockColumns)) + jBlock)][k]", 1184, 50123, 50172);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3872.methodEnd();
        }
    }

    @Override
    public void addToEntry(final int row, final int column, final T increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3873 = new MethodContext(void.class, 1189, 50185, 50741);
        try {
            CallChecker.varInit(this, "this", 1189, 50185, 50741);
            CallChecker.varInit(increment, "increment", 1189, 50185, 50741);
            CallChecker.varInit(column, "column", 1189, 50185, 50741);
            CallChecker.varInit(row, "row", 1189, 50185, 50741);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1189, 50185, 50741);
            CallChecker.varInit(this.blockRows, "blockRows", 1189, 50185, 50741);
            CallChecker.varInit(this.columns, "columns", 1189, 50185, 50741);
            CallChecker.varInit(this.rows, "rows", 1189, 50185, 50741);
            CallChecker.varInit(this.blocks, "blocks", 1189, 50185, 50741);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1189, 50185, 50741);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1189, 50185, 50741);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1194, 50407, 50445);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1195, 50455, 50493);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE))))), "k", 1196, 50503, 50618);
            final T[] blockIJ = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1198, 50648, 50653)[((iBlock * (blockColumns)) + jBlock)], "blockIJ", 1198, 50628, 50686);
            if (CallChecker.beforeDeref(blockIJ, null, 1200, 50697, 50703)) {
                if (CallChecker.beforeDeref(blockIJ, null, 1200, 50710, 50716)) {
                    if (CallChecker.beforeDeref(blockIJ[k], null, 1200, 50710, 50719)) {
                        blockIJ[k] = blockIJ[k].add(increment);
                        CallChecker.varAssign(blockIJ[k], "blockIJ[k]", 1200, 50697, 50735);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3873.methodEnd();
        }
    }

    @Override
    public void multiplyEntry(final int row, final int column, final T factor) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3874 = new MethodContext(void.class, 1205, 50748, 51306);
        try {
            CallChecker.varInit(this, "this", 1205, 50748, 51306);
            CallChecker.varInit(factor, "factor", 1205, 50748, 51306);
            CallChecker.varInit(column, "column", 1205, 50748, 51306);
            CallChecker.varInit(row, "row", 1205, 50748, 51306);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1205, 50748, 51306);
            CallChecker.varInit(this.blockRows, "blockRows", 1205, 50748, 51306);
            CallChecker.varInit(this.columns, "columns", 1205, 50748, 51306);
            CallChecker.varInit(this.rows, "rows", 1205, 50748, 51306);
            CallChecker.varInit(this.blocks, "blocks", 1205, 50748, 51306);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1205, 50748, 51306);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1205, 50748, 51306);
            checkRowIndex(row);
            checkColumnIndex(column);
            final int iBlock = CallChecker.varInit(((int) (row / (BlockFieldMatrix.BLOCK_SIZE))), "iBlock", 1210, 50970, 51008);
            final int jBlock = CallChecker.varInit(((int) (column / (BlockFieldMatrix.BLOCK_SIZE))), "jBlock", 1211, 51018, 51056);
            final int k = CallChecker.varInit(((int) (((row - (iBlock * (BlockFieldMatrix.BLOCK_SIZE))) * (blockWidth(jBlock))) + (column - (jBlock * (BlockFieldMatrix.BLOCK_SIZE))))), "k", 1212, 51066, 51181);
            final T[] blockIJ = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1214, 51211, 51216)[((iBlock * (blockColumns)) + jBlock)], "blockIJ", 1214, 51191, 51249);
            if (CallChecker.beforeDeref(blockIJ, null, 1216, 51260, 51266)) {
                if (CallChecker.beforeDeref(blockIJ, null, 1216, 51273, 51279)) {
                    if (CallChecker.beforeDeref(blockIJ[k], null, 1216, 51273, 51282)) {
                        blockIJ[k] = blockIJ[k].multiply(factor);
                        CallChecker.varAssign(blockIJ[k], "blockIJ[k]", 1216, 51260, 51300);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3874.methodEnd();
        }
    }

    @Override
    public FieldMatrix<T> transpose() {
        MethodContext _bcornu_methode_context3875 = new MethodContext(FieldMatrix.class, 1221, 51313, 52778);
        try {
            CallChecker.varInit(this, "this", 1221, 51313, 52778);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1221, 51313, 52778);
            CallChecker.varInit(this.blockRows, "blockRows", 1221, 51313, 52778);
            CallChecker.varInit(this.columns, "columns", 1221, 51313, 52778);
            CallChecker.varInit(this.rows, "rows", 1221, 51313, 52778);
            CallChecker.varInit(this.blocks, "blocks", 1221, 51313, 52778);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1221, 51313, 52778);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1221, 51313, 52778);
            final int nRows = CallChecker.varInit(((int) (getRowDimension())), "nRows", 1222, 51396, 51431);
            final int nCols = CallChecker.varInit(((int) (getColumnDimension())), "nCols", 1223, 51441, 51479);
            final BlockFieldMatrix<T> out = CallChecker.varInit(new BlockFieldMatrix<T>(getField(), nCols, nRows), "out", 1224, 51489, 51570);
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1227, 51652, 51670);
            for (int iBlock = 0; iBlock < (blockColumns); ++iBlock) {
                for (int jBlock = 0; jBlock < (blockRows); ++jBlock) {
                    final T[] outBlock = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(out, BlockFieldMatrix.class, 1232, 51882, 51884).blocks, null, 1232, 51882, 51891)[blockIndex], "outBlock", 1232, 51861, 51904);
                    final T[] tBlock = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1233, 51943, 51948)[((jBlock * (blockColumns)) + iBlock)], "tBlock", 1233, 51922, 51981);
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1234, 51999, 52044);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "pEnd", 1235, 52062, 52130);
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1236, 52148, 52193);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "qEnd", 1237, 52211, 52276);
                    int k = CallChecker.varInit(((int) (0)), "k", 1238, 52294, 52303);
                    for (int p = pStart; p < pEnd; ++p) {
                        final int lInc = CallChecker.varInit(((int) (pEnd - pStart)), "lInc", 1240, 52379, 52409);
                        int l = CallChecker.varInit(((int) (p - pStart)), "l", 1241, 52431, 52449);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(outBlock, null, 1243, 52533, 52540)) {
                                if (CallChecker.beforeDeref(tBlock, null, 1243, 52547, 52552)) {
                                    outBlock[k] = tBlock[l];
                                    CallChecker.varAssign(outBlock[k], "outBlock[k]", 1243, 52533, 52556);
                                }
                            }
                            ++k;
                            l += lInc;
                            CallChecker.varAssign(l, "l", 1245, 52611, 52619);
                        }
                    }
                    ++blockIndex;
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3875.methodEnd();
        }
    }

    @Override
    public int getRowDimension() {
        MethodContext _bcornu_methode_context3876 = new MethodContext(int.class, 1260, 52785, 52880);
        try {
            CallChecker.varInit(this, "this", 1260, 52785, 52880);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1260, 52785, 52880);
            CallChecker.varInit(this.blockRows, "blockRows", 1260, 52785, 52880);
            CallChecker.varInit(this.columns, "columns", 1260, 52785, 52880);
            CallChecker.varInit(this.rows, "rows", 1260, 52785, 52880);
            CallChecker.varInit(this.blocks, "blocks", 1260, 52785, 52880);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1260, 52785, 52880);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1260, 52785, 52880);
            return rows;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3876.methodEnd();
        }
    }

    @Override
    public int getColumnDimension() {
        MethodContext _bcornu_methode_context3877 = new MethodContext(int.class, 1266, 52887, 52988);
        try {
            CallChecker.varInit(this, "this", 1266, 52887, 52988);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1266, 52887, 52988);
            CallChecker.varInit(this.blockRows, "blockRows", 1266, 52887, 52988);
            CallChecker.varInit(this.columns, "columns", 1266, 52887, 52988);
            CallChecker.varInit(this.rows, "rows", 1266, 52887, 52988);
            CallChecker.varInit(this.blocks, "blocks", 1266, 52887, 52988);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1266, 52887, 52988);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1266, 52887, 52988);
            return columns;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3877.methodEnd();
        }
    }

    @Override
    public T[] operate(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3878 = new MethodContext(null, 1272, 52995, 54697);
        try {
            CallChecker.varInit(this, "this", 1272, 52995, 54697);
            CallChecker.varInit(v, "v", 1272, 52995, 54697);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1272, 52995, 54697);
            CallChecker.varInit(this.blockRows, "blockRows", 1272, 52995, 54697);
            CallChecker.varInit(this.columns, "columns", 1272, 52995, 54697);
            CallChecker.varInit(this.rows, "rows", 1272, 52995, 54697);
            CallChecker.varInit(this.blocks, "blocks", 1272, 52995, 54697);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1272, 52995, 54697);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1272, 52995, 54697);
            if (CallChecker.beforeDeref(v, null, 1273, 53114, 53114)) {
                if ((CallChecker.isCalled(v, null, 1273, 53114, 53114).length) != (columns)) {
                    if (CallChecker.beforeDeref(v, null, 1274, 53186, 53186)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 1274, 53186, 53186).length, columns);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), rows), "out", 1276, 53224, 53279);
            final T zero = CallChecker.varInit(getField().getZero(), "zero", 1277, 53289, 53324);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1281, 53476, 53514);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1282, 53528, 53586);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1284, 53691, 53696)[((iBlock * (blockColumns)) + jBlock)], "block", 1284, 53672, 53729);
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1285, 53747, 53790);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1286, 53808, 53874);
                    int k = CallChecker.varInit(((int) (0)), "k", 1287, 53892, 53901);
                    for (int p = pStart; p < pEnd; ++p) {
                        T sum = CallChecker.varInit(zero, "sum", 1289, 53977, 53989);
                        int q = CallChecker.varInit(((int) (qStart)), "q", 1290, 54011, 54025);
                        while (q < (qEnd - 3)) {
                            if (CallChecker.beforeDeref(block, null, 1293, 54139, 54143)) {
                                if (CallChecker.beforeDeref(v, null, 1293, 54157, 54157)) {
                                    if (CallChecker.beforeDeref(block[k], null, 1293, 54139, 54146)) {
                                        if (CallChecker.beforeDeref(sum, null, 1292, 54100, 54102)) {
                                            if (CallChecker.beforeDeref(block, null, 1294, 54199, 54203)) {
                                                if (CallChecker.beforeDeref(v, null, 1294, 54221, 54221)) {
                                                    if (CallChecker.beforeDeref(block[(k + 1)], null, 1294, 54199, 54210)) {
                                                        final FieldElement<T> npe_invocation_var837 = sum.add(block[k].multiply(v[q]));
                                                        if (CallChecker.beforeDeref(npe_invocation_var837, FieldElement.class, 1292, 54100, 54162)) {
                                                            if (CallChecker.beforeDeref(block, null, 1295, 54267, 54271)) {
                                                                if (CallChecker.beforeDeref(v, null, 1295, 54289, 54289)) {
                                                                    if (CallChecker.beforeDeref(block[(k + 2)], null, 1295, 54267, 54278)) {
                                                                        final FieldElement<T> npe_invocation_var838 = npe_invocation_var837.add(block[(k + 1)].multiply(v[(q + 1)]));
                                                                        if (CallChecker.beforeDeref(npe_invocation_var838, FieldElement.class, 1292, 54100, 54230)) {
                                                                            if (CallChecker.beforeDeref(block, null, 1296, 54335, 54339)) {
                                                                                if (CallChecker.beforeDeref(v, null, 1296, 54357, 54357)) {
                                                                                    if (CallChecker.beforeDeref(block[(k + 3)], null, 1296, 54335, 54346)) {
                                                                                        final FieldElement<T> npe_invocation_var839 = npe_invocation_var838.add(block[(k + 2)].multiply(v[(q + 2)]));
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var839, FieldElement.class, 1292, 54100, 54298)) {
                                                                                            sum = npe_invocation_var839.add(block[(k + 3)].multiply(v[(q + 3)]));
                                                                                            CallChecker.varAssign(sum, "sum", 1292, 54094, 54367);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            k += 4;
                            CallChecker.varAssign(k, "k", 1297, 54393, 54399);
                            q += 4;
                            CallChecker.varAssign(q, "q", 1298, 54425, 54431);
                        } 
                        while (q < qEnd) {
                            if (CallChecker.beforeDeref(block, null, 1301, 54532, 54536)) {
                                if (CallChecker.beforeDeref(v, null, 1301, 54552, 54552)) {
                                    if (CallChecker.beforeDeref(block[k], null, 1301, 54532, 54541)) {
                                        if (CallChecker.beforeDeref(sum, null, 1301, 54524, 54526)) {
                                            sum = sum.add(block[(k++)].multiply(v[(q++)]));
                                            CallChecker.varAssign(sum, "sum", 1301, 54518, 54560);
                                        }
                                    }
                                }
                            }
                        } 
                        if (CallChecker.beforeDeref(out, null, 1303, 54604, 54606)) {
                            if (CallChecker.beforeDeref(out, null, 1303, 54613, 54615)) {
                                if (CallChecker.beforeDeref(out[p], null, 1303, 54613, 54618)) {
                                    out[p] = out[p].add(sum);
                                    CallChecker.varAssign(out[p], "out[p]", 1303, 54604, 54628);
                                }
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3878.methodEnd();
        }
    }

    @Override
    public T[] preMultiply(final T[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3879 = new MethodContext(null, 1313, 54704, 56681);
        try {
            CallChecker.varInit(this, "this", 1313, 54704, 56681);
            CallChecker.varInit(v, "v", 1313, 54704, 56681);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1313, 54704, 56681);
            CallChecker.varInit(this.blockRows, "blockRows", 1313, 54704, 56681);
            CallChecker.varInit(this.columns, "columns", 1313, 54704, 56681);
            CallChecker.varInit(this.rows, "rows", 1313, 54704, 56681);
            CallChecker.varInit(this.blocks, "blocks", 1313, 54704, 56681);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1313, 54704, 56681);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1313, 54704, 56681);
            if (CallChecker.beforeDeref(v, null, 1315, 54828, 54828)) {
                if ((CallChecker.isCalled(v, null, 1315, 54828, 54828).length) != (rows)) {
                    if (CallChecker.beforeDeref(v, null, 1316, 54897, 54897)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(v, null, 1316, 54897, 54897).length, rows);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] out = CallChecker.varInit(MathArrays.buildArray(getField(), columns), "out", 1318, 54932, 54990);
            final T zero = CallChecker.varInit(getField().getZero(), "zero", 1319, 55000, 55035);
            for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1323, 55190, 55228);
                final int jWidth2 = CallChecker.varInit(((int) (jWidth + jWidth)), "jWidth2", 1324, 55242, 55278);
                final int jWidth3 = CallChecker.varInit(((int) (jWidth2 + jWidth)), "jWidth3", 1325, 55292, 55328);
                final int jWidth4 = CallChecker.varInit(((int) (jWidth3 + jWidth)), "jWidth4", 1326, 55342, 55378);
                final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1327, 55392, 55430);
                final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1328, 55444, 55505);
                for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1330, 55607, 55612)[((iBlock * (blockColumns)) + jBlock)], "block", 1330, 55588, 55645);
                    final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1331, 55663, 55706);
                    final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1332, 55724, 55787);
                    for (int q = qStart; q < qEnd; ++q) {
                        int k = CallChecker.varInit(((int) (q - qStart)), "k", 1334, 55863, 55881);
                        T sum = CallChecker.varInit(zero, "sum", 1335, 55903, 55915);
                        int p = CallChecker.varInit(((int) (pStart)), "p", 1336, 55937, 55951);
                        while (p < (pEnd - 3)) {
                            if (CallChecker.beforeDeref(block, null, 1339, 56065, 56069)) {
                                if (CallChecker.beforeDeref(v, null, 1339, 56083, 56083)) {
                                    if (CallChecker.beforeDeref(block[k], null, 1339, 56065, 56072)) {
                                        if (CallChecker.beforeDeref(sum, null, 1338, 56026, 56028)) {
                                            if (CallChecker.beforeDeref(block, null, 1340, 56125, 56129)) {
                                                if (CallChecker.beforeDeref(v, null, 1340, 56152, 56152)) {
                                                    if (CallChecker.beforeDeref(block[(k + jWidth)], null, 1340, 56125, 56141)) {
                                                        final FieldElement<T> npe_invocation_var840 = sum.add(block[k].multiply(v[p]));
                                                        if (CallChecker.beforeDeref(npe_invocation_var840, FieldElement.class, 1338, 56026, 56088)) {
                                                            if (CallChecker.beforeDeref(block, null, 1341, 56198, 56202)) {
                                                                if (CallChecker.beforeDeref(v, null, 1341, 56226, 56226)) {
                                                                    if (CallChecker.beforeDeref(block[(k + jWidth2)], null, 1341, 56198, 56215)) {
                                                                        final FieldElement<T> npe_invocation_var841 = npe_invocation_var840.add(block[(k + jWidth)].multiply(v[(p + 1)]));
                                                                        if (CallChecker.beforeDeref(npe_invocation_var841, FieldElement.class, 1338, 56026, 56161)) {
                                                                            if (CallChecker.beforeDeref(block, null, 1342, 56272, 56276)) {
                                                                                if (CallChecker.beforeDeref(v, null, 1342, 56300, 56300)) {
                                                                                    if (CallChecker.beforeDeref(block[(k + jWidth3)], null, 1342, 56272, 56289)) {
                                                                                        final FieldElement<T> npe_invocation_var842 = npe_invocation_var841.add(block[(k + jWidth2)].multiply(v[(p + 2)]));
                                                                                        if (CallChecker.beforeDeref(npe_invocation_var842, FieldElement.class, 1338, 56026, 56235)) {
                                                                                            sum = npe_invocation_var842.add(block[(k + jWidth3)].multiply(v[(p + 3)]));
                                                                                            CallChecker.varAssign(sum, "sum", 1338, 56020, 56310);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            k += jWidth4;
                            CallChecker.varAssign(k, "k", 1343, 56336, 56348);
                            p += 4;
                            CallChecker.varAssign(p, "p", 1344, 56374, 56380);
                        } 
                        while (p < pEnd) {
                            if (CallChecker.beforeDeref(block, null, 1347, 56481, 56485)) {
                                if (CallChecker.beforeDeref(v, null, 1347, 56499, 56499)) {
                                    if (CallChecker.beforeDeref(block[k], null, 1347, 56481, 56488)) {
                                        if (CallChecker.beforeDeref(sum, null, 1347, 56473, 56475)) {
                                            sum = sum.add(block[k].multiply(v[(p++)]));
                                            CallChecker.varAssign(sum, "sum", 1347, 56467, 56507);
                                        }
                                    }
                                }
                            }
                            k += jWidth;
                            CallChecker.varAssign(k, "k", 1348, 56533, 56544);
                        } 
                        if (CallChecker.beforeDeref(out, null, 1350, 56588, 56590)) {
                            if (CallChecker.beforeDeref(out, null, 1350, 56597, 56599)) {
                                if (CallChecker.beforeDeref(out[q], null, 1350, 56597, 56602)) {
                                    out[q] = out[q].add(sum);
                                    CallChecker.varAssign(out[q], "out[q]", 1350, 56588, 56612);
                                }
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3879.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context3880 = new MethodContext(null, 1360, 56688, 57755);
        try {
            CallChecker.varInit(this, "this", 1360, 56688, 57755);
            CallChecker.varInit(visitor, "visitor", 1360, 56688, 57755);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1360, 56688, 57755);
            CallChecker.varInit(this.blockRows, "blockRows", 1360, 56688, 57755);
            CallChecker.varInit(this.columns, "columns", 1360, 56688, 57755);
            CallChecker.varInit(this.rows, "rows", 1360, 56688, 57755);
            CallChecker.varInit(this.blocks, "blocks", 1360, 56688, 57755);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1360, 56688, 57755);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1360, 56688, 57755);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1361, 56806, 56812)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 1361, 56806, 56812).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1363, 56938, 56976);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1364, 56990, 57048);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1367, 57192, 57229);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1368, 57251, 57289);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1369, 57311, 57372);
                        final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1370, 57412, 57417)[((iBlock * (blockColumns)) + jBlock)], "block", 1370, 57394, 57450);
                        int k = CallChecker.varInit(((int) ((p - pStart) * jWidth)), "k", 1371, 57472, 57501);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1373, 57585, 57589)) {
                                if (CallChecker.beforeDeref(block, null, 1373, 57616, 57620)) {
                                    if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1373, 57596, 57602)) {
                                        block[k] = visitor.visit(p, q, block[k]);
                                        CallChecker.varAssign(block[k], "block[k]", 1373, 57585, 57625);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1379, 57736, 57742)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3880.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context3881 = new MethodContext(null, 1384, 57762, 58820);
        try {
            CallChecker.varInit(this, "this", 1384, 57762, 58820);
            CallChecker.varInit(visitor, "visitor", 1384, 57762, 58820);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1384, 57762, 58820);
            CallChecker.varInit(this.blockRows, "blockRows", 1384, 57762, 58820);
            CallChecker.varInit(this.columns, "columns", 1384, 57762, 58820);
            CallChecker.varInit(this.rows, "rows", 1384, 57762, 58820);
            CallChecker.varInit(this.blocks, "blocks", 1384, 57762, 58820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1384, 57762, 58820);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1384, 57762, 58820);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1385, 57882, 57888)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1385, 57882, 57888).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1387, 58014, 58052);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1388, 58066, 58124);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1391, 58268, 58305);
                        final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1392, 58327, 58365);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1393, 58387, 58448);
                        final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1394, 58488, 58493)[((iBlock * (blockColumns)) + jBlock)], "block", 1394, 58470, 58526);
                        int k = CallChecker.varInit(((int) ((p - pStart) * jWidth)), "k", 1395, 58548, 58577);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1397, 58681, 58685)) {
                                if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1397, 58661, 58667)) {
                                    CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1397, 58661, 58667).visit(p, q, block[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1403, 58801, 58807)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3881.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3882 = new MethodContext(null, 1408, 58827, 60412);
        try {
            CallChecker.varInit(this, "this", 1408, 58827, 60412);
            CallChecker.varInit(endColumn, "endColumn", 1408, 58827, 60412);
            CallChecker.varInit(startColumn, "startColumn", 1408, 58827, 60412);
            CallChecker.varInit(endRow, "endRow", 1408, 58827, 60412);
            CallChecker.varInit(startRow, "startRow", 1408, 58827, 60412);
            CallChecker.varInit(visitor, "visitor", 1408, 58827, 60412);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1408, 58827, 60412);
            CallChecker.varInit(this.blockRows, "blockRows", 1408, 58827, 60412);
            CallChecker.varInit(this.columns, "columns", 1408, 58827, 60412);
            CallChecker.varInit(this.rows, "rows", 1408, 58827, 60412);
            CallChecker.varInit(this.blocks, "blocks", 1408, 58827, 60412);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1408, 58827, 60412);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1408, 58827, 60412);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1413, 59216, 59222)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 1413, 59216, 59222).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockFieldMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockFieldMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "p0", 1415, 59395, 59433);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1416, 59447, 59492);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1417, 59506, 59576);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = startColumn / (BlockFieldMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockFieldMatrix.BLOCK_SIZE))); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1420, 59757, 59794);
                        final int q0 = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "q0", 1421, 59816, 59854);
                        final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1422, 59876, 59924);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1423, 59946, 60019);
                        final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1424, 60059, 60064)[((iBlock * (blockColumns)) + jBlock)], "block", 1424, 60041, 60097);
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1425, 60119, 60158);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1427, 60242, 60246)) {
                                if (CallChecker.beforeDeref(block, null, 1427, 60273, 60277)) {
                                    if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1427, 60253, 60259)) {
                                        block[k] = visitor.visit(p, q, block[k]);
                                        CallChecker.varAssign(block[k], "block[k]", 1427, 60242, 60282);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1433, 60393, 60399)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3882.methodEnd();
        }
    }

    @Override
    public T walkInRowOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3883 = new MethodContext(null, 1438, 60419, 61995);
        try {
            CallChecker.varInit(this, "this", 1438, 60419, 61995);
            CallChecker.varInit(endColumn, "endColumn", 1438, 60419, 61995);
            CallChecker.varInit(startColumn, "startColumn", 1438, 60419, 61995);
            CallChecker.varInit(endRow, "endRow", 1438, 60419, 61995);
            CallChecker.varInit(startRow, "startRow", 1438, 60419, 61995);
            CallChecker.varInit(visitor, "visitor", 1438, 60419, 61995);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1438, 60419, 61995);
            CallChecker.varInit(this.blockRows, "blockRows", 1438, 60419, 61995);
            CallChecker.varInit(this.columns, "columns", 1438, 60419, 61995);
            CallChecker.varInit(this.rows, "rows", 1438, 60419, 61995);
            CallChecker.varInit(this.blocks, "blocks", 1438, 60419, 61995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1438, 60419, 61995);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1438, 60419, 61995);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1443, 60810, 60816)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1443, 60810, 60816).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockFieldMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockFieldMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "p0", 1445, 60989, 61027);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1446, 61041, 61086);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1447, 61100, 61170);
                for (int p = pStart; p < pEnd; ++p) {
                    for (int jBlock = startColumn / (BlockFieldMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockFieldMatrix.BLOCK_SIZE))); ++jBlock) {
                        final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1450, 61351, 61388);
                        final int q0 = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "q0", 1451, 61410, 61448);
                        final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1452, 61470, 61518);
                        final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1453, 61540, 61613);
                        final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1454, 61653, 61658)[((iBlock * (blockColumns)) + jBlock)], "block", 1454, 61635, 61691);
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1455, 61713, 61752);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1457, 61856, 61860)) {
                                if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1457, 61836, 61842)) {
                                    CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1457, 61836, 61842).visit(p, q, block[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1463, 61976, 61982)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3883.methodEnd();
        }
    }

    @Override
    public T walkInOptimizedOrder(final FieldMatrixChangingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context3884 = new MethodContext(null, 1468, 62002, 63017);
        try {
            CallChecker.varInit(this, "this", 1468, 62002, 63017);
            CallChecker.varInit(visitor, "visitor", 1468, 62002, 63017);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1468, 62002, 63017);
            CallChecker.varInit(this.blockRows, "blockRows", 1468, 62002, 63017);
            CallChecker.varInit(this.columns, "columns", 1468, 62002, 63017);
            CallChecker.varInit(this.rows, "rows", 1468, 62002, 63017);
            CallChecker.varInit(this.blocks, "blocks", 1468, 62002, 63017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1468, 62002, 63017);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1468, 62002, 63017);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1469, 62126, 62132)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 1469, 62126, 62132).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1470, 62193, 62211);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1472, 62286, 62324);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1473, 62338, 62396);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1475, 62482, 62520);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1476, 62538, 62599);
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1477, 62635, 62640)[blockIndex], "block", 1477, 62617, 62653);
                    int k = CallChecker.varInit(((int) (0)), "k", 1478, 62671, 62680);
                    for (int p = pStart; p < pEnd; ++p) {
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1481, 62818, 62822)) {
                                if (CallChecker.beforeDeref(block, null, 1481, 62849, 62853)) {
                                    if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1481, 62829, 62835)) {
                                        block[k] = visitor.visit(p, q, block[k]);
                                        CallChecker.varAssign(block[k], "block[k]", 1481, 62818, 62858);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                    ++blockIndex;
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1488, 62998, 63004)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3884.methodEnd();
        }
    }

    @Override
    public T walkInOptimizedOrder(final FieldMatrixPreservingVisitor<T> visitor) {
        MethodContext _bcornu_methode_context3885 = new MethodContext(null, 1493, 63024, 64030);
        try {
            CallChecker.varInit(this, "this", 1493, 63024, 64030);
            CallChecker.varInit(visitor, "visitor", 1493, 63024, 64030);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1493, 63024, 64030);
            CallChecker.varInit(this.blockRows, "blockRows", 1493, 63024, 64030);
            CallChecker.varInit(this.columns, "columns", 1493, 63024, 64030);
            CallChecker.varInit(this.rows, "rows", 1493, 63024, 64030);
            CallChecker.varInit(this.blocks, "blocks", 1493, 63024, 64030);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1493, 63024, 64030);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1493, 63024, 64030);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1494, 63150, 63156)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1494, 63150, 63156).start(rows, columns, 0, ((rows) - 1), 0, ((columns) - 1));
            }
            int blockIndex = CallChecker.varInit(((int) (0)), "blockIndex", 1495, 63217, 63235);
            for (int iBlock = 0; iBlock < (blockRows); ++iBlock) {
                final int pStart = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "pStart", 1497, 63310, 63348);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min((pStart + (BlockFieldMatrix.BLOCK_SIZE)), this.rows))), "pEnd", 1498, 63362, 63420);
                for (int jBlock = 0; jBlock < (blockColumns); ++jBlock) {
                    final int qStart = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "qStart", 1500, 63506, 63544);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min((qStart + (BlockFieldMatrix.BLOCK_SIZE)), this.columns))), "qEnd", 1501, 63562, 63623);
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1502, 63659, 63664)[blockIndex], "block", 1502, 63641, 63677);
                    int k = CallChecker.varInit(((int) (0)), "k", 1503, 63695, 63704);
                    for (int p = pStart; p < pEnd; ++p) {
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1506, 63862, 63866)) {
                                if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1506, 63842, 63848)) {
                                    CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1506, 63842, 63848).visit(p, q, block[k]);
                                }
                            }
                            ++k;
                        }
                    }
                    ++blockIndex;
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1513, 64011, 64017)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3885.methodEnd();
        }
    }

    @Override
    public T walkInOptimizedOrder(final FieldMatrixChangingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3886 = new MethodContext(null, 1518, 64037, 65619);
        try {
            CallChecker.varInit(this, "this", 1518, 64037, 65619);
            CallChecker.varInit(endColumn, "endColumn", 1518, 64037, 65619);
            CallChecker.varInit(startColumn, "startColumn", 1518, 64037, 65619);
            CallChecker.varInit(endRow, "endRow", 1518, 64037, 65619);
            CallChecker.varInit(startRow, "startRow", 1518, 64037, 65619);
            CallChecker.varInit(visitor, "visitor", 1518, 64037, 65619);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1518, 64037, 65619);
            CallChecker.varInit(this.blockRows, "blockRows", 1518, 64037, 65619);
            CallChecker.varInit(this.columns, "columns", 1518, 64037, 65619);
            CallChecker.varInit(this.rows, "rows", 1518, 64037, 65619);
            CallChecker.varInit(this.blocks, "blocks", 1518, 64037, 65619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1518, 64037, 65619);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1518, 64037, 65619);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1523, 64444, 64450)) {
                CallChecker.isCalled(visitor, FieldMatrixChangingVisitor.class, 1523, 64444, 64450).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockFieldMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockFieldMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "p0", 1525, 64623, 64661);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1526, 64675, 64720);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1527, 64734, 64804);
                for (int jBlock = startColumn / (BlockFieldMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockFieldMatrix.BLOCK_SIZE))); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1529, 64927, 64964);
                    final int q0 = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "q0", 1530, 64982, 65020);
                    final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1531, 65038, 65086);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1532, 65104, 65177);
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1533, 65213, 65218)[((iBlock * (blockColumns)) + jBlock)], "block", 1533, 65195, 65251);
                    for (int p = pStart; p < pEnd; ++p) {
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1535, 65327, 65366);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1537, 65450, 65454)) {
                                if (CallChecker.beforeDeref(block, null, 1537, 65481, 65485)) {
                                    if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1537, 65461, 65467)) {
                                        block[k] = visitor.visit(p, q, block[k]);
                                        CallChecker.varAssign(block[k], "block[k]", 1537, 65450, 65490);
                                    }
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixChangingVisitor.class, 1543, 65600, 65606)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3886.methodEnd();
        }
    }

    @Override
    public T walkInOptimizedOrder(final FieldMatrixPreservingVisitor<T> visitor, final int startRow, final int endRow, final int startColumn, final int endColumn) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3887 = new MethodContext(null, 1548, 65626, 67199);
        try {
            CallChecker.varInit(this, "this", 1548, 65626, 67199);
            CallChecker.varInit(endColumn, "endColumn", 1548, 65626, 67199);
            CallChecker.varInit(startColumn, "startColumn", 1548, 65626, 67199);
            CallChecker.varInit(endRow, "endRow", 1548, 65626, 67199);
            CallChecker.varInit(startRow, "startRow", 1548, 65626, 67199);
            CallChecker.varInit(visitor, "visitor", 1548, 65626, 67199);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1548, 65626, 67199);
            CallChecker.varInit(this.blockRows, "blockRows", 1548, 65626, 67199);
            CallChecker.varInit(this.columns, "columns", 1548, 65626, 67199);
            CallChecker.varInit(this.rows, "rows", 1548, 65626, 67199);
            CallChecker.varInit(this.blocks, "blocks", 1548, 65626, 67199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1548, 65626, 67199);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1548, 65626, 67199);
            checkSubMatrixIndex(startRow, endRow, startColumn, endColumn);
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1553, 66035, 66041)) {
                CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1553, 66035, 66041).start(rows, columns, startRow, endRow, startColumn, endColumn);
            }
            for (int iBlock = startRow / (BlockFieldMatrix.BLOCK_SIZE); iBlock < (1 + (endRow / (BlockFieldMatrix.BLOCK_SIZE))); ++iBlock) {
                final int p0 = CallChecker.varInit(((int) (iBlock * (BlockFieldMatrix.BLOCK_SIZE))), "p0", 1555, 66214, 66252);
                final int pStart = CallChecker.varInit(((int) (FastMath.max(startRow, p0))), "pStart", 1556, 66266, 66311);
                final int pEnd = CallChecker.varInit(((int) (FastMath.min(((iBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endRow)))), "pEnd", 1557, 66325, 66395);
                for (int jBlock = startColumn / (BlockFieldMatrix.BLOCK_SIZE); jBlock < (1 + (endColumn / (BlockFieldMatrix.BLOCK_SIZE))); ++jBlock) {
                    final int jWidth = CallChecker.varInit(((int) (blockWidth(jBlock))), "jWidth", 1559, 66518, 66555);
                    final int q0 = CallChecker.varInit(((int) (jBlock * (BlockFieldMatrix.BLOCK_SIZE))), "q0", 1560, 66573, 66611);
                    final int qStart = CallChecker.varInit(((int) (FastMath.max(startColumn, q0))), "qStart", 1561, 66629, 66677);
                    final int qEnd = CallChecker.varInit(((int) (FastMath.min(((jBlock + 1) * (BlockFieldMatrix.BLOCK_SIZE)), (1 + endColumn)))), "qEnd", 1562, 66695, 66768);
                    final T[] block = CallChecker.varInit(CallChecker.isCalled(blocks, null, 1563, 66804, 66809)[((iBlock * (blockColumns)) + jBlock)], "block", 1563, 66786, 66842);
                    for (int p = pStart; p < pEnd; ++p) {
                        int k = CallChecker.varInit(((int) ((((p - p0) * jWidth) + qStart) - q0)), "k", 1565, 66918, 66957);
                        for (int q = qStart; q < qEnd; ++q) {
                            if (CallChecker.beforeDeref(block, null, 1567, 67061, 67065)) {
                                if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1567, 67041, 67047)) {
                                    CallChecker.isCalled(visitor, FieldMatrixPreservingVisitor.class, 1567, 67041, 67047).visit(p, q, block[k]);
                                }
                            }
                            ++k;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, FieldMatrixPreservingVisitor.class, 1573, 67180, 67186)) {
                return visitor.end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3887.methodEnd();
        }
    }

    private int blockHeight(final int blockRow) {
        MethodContext _bcornu_methode_context3888 = new MethodContext(int.class, 1581, 67206, 67509);
        try {
            CallChecker.varInit(this, "this", 1581, 67206, 67509);
            CallChecker.varInit(blockRow, "blockRow", 1581, 67206, 67509);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1581, 67206, 67509);
            CallChecker.varInit(this.blockRows, "blockRows", 1581, 67206, 67509);
            CallChecker.varInit(this.columns, "columns", 1581, 67206, 67509);
            CallChecker.varInit(this.rows, "rows", 1581, 67206, 67509);
            CallChecker.varInit(this.blocks, "blocks", 1581, 67206, 67509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1581, 67206, 67509);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1581, 67206, 67509);
            if (blockRow == ((blockRows) - 1)) {
                return (rows) - (blockRow * (BlockFieldMatrix.BLOCK_SIZE));
            }else {
                return BlockFieldMatrix.BLOCK_SIZE;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3888.methodEnd();
        }
    }

    private int blockWidth(final int blockColumn) {
        MethodContext _bcornu_methode_context3889 = new MethodContext(int.class, 1590, 67516, 67840);
        try {
            CallChecker.varInit(this, "this", 1590, 67516, 67840);
            CallChecker.varInit(blockColumn, "blockColumn", 1590, 67516, 67840);
            CallChecker.varInit(this.blockColumns, "blockColumns", 1590, 67516, 67840);
            CallChecker.varInit(this.blockRows, "blockRows", 1590, 67516, 67840);
            CallChecker.varInit(this.columns, "columns", 1590, 67516, 67840);
            CallChecker.varInit(this.rows, "rows", 1590, 67516, 67840);
            CallChecker.varInit(this.blocks, "blocks", 1590, 67516, 67840);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.BlockFieldMatrix.serialVersionUID", 1590, 67516, 67840);
            CallChecker.varInit(BLOCK_SIZE, "org.apache.commons.math3.linear.BlockFieldMatrix.BLOCK_SIZE", 1590, 67516, 67840);
            if (blockColumn == ((blockColumns) - 1)) {
                return (columns) - (blockColumn * (BlockFieldMatrix.BLOCK_SIZE));
            }else {
                return BlockFieldMatrix.BLOCK_SIZE;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3889.methodEnd();
        }
    }
}

