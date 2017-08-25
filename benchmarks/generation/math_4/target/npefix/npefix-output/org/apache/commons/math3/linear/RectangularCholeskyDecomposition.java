package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class RectangularCholeskyDecomposition {
    private final RealMatrix root;

    private int rank;

    public RectangularCholeskyDecomposition(RealMatrix matrix) throws NonPositiveDefiniteMatrixException {
        this(matrix, 0);
        ConstructorContext _bcornu_methode_context10 = new ConstructorContext(RectangularCholeskyDecomposition.class, 68, 2546, 3332);
        try {
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public RectangularCholeskyDecomposition(RealMatrix matrix, double small) throws NonPositiveDefiniteMatrixException {
        ConstructorContext _bcornu_methode_context11 = new ConstructorContext(RectangularCholeskyDecomposition.class, 82, 3339, 6971);
        try {
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 85, 3880, 3885);
            final int order = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 85, 3880, 3885).getRowDimension())), "order", 85, 3862, 3904);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 86, 3935, 3940);
            final double[][] c = CallChecker.varInit(CallChecker.isCalled(matrix, RealMatrix.class, 86, 3935, 3940).getData(), "c", 86, 3914, 3951);
            final double[][] b = CallChecker.varInit(new double[order][order], "b", 87, 3961, 4006);
            int[] index = CallChecker.varInit(new int[order], "index", 89, 4017, 4045);
            for (int i = 0; i < order; ++i) {
                if (CallChecker.beforeDeref(index, int[].class, 91, 4101, 4105)) {
                    index = CallChecker.beforeCalled(index, int[].class, 91, 4101, 4105);
                    CallChecker.isCalled(index, int[].class, 91, 4101, 4105)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(index, int[].class, 91, 4101, 4105)[i], "CallChecker.isCalled(index, int[].class, 91, 4101, 4105)[i]", 91, 4101, 4113);
                }
            }
            int r = CallChecker.varInit(((int) (0)), "r", 94, 4134, 4143);
            for (boolean loop = true; loop;) {
                int swapR = CallChecker.varInit(((int) (r)), "swapR", 98, 4246, 4259);
                for (int i = r + 1; i < order; ++i) {
                    int ii = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(index, int[].class, 100, 4337, 4341)) {
                        index = CallChecker.beforeCalled(index, int[].class, 100, 4337, 4341);
                        ii = CallChecker.isCalled(index, int[].class, 100, 4337, 4341)[i];
                        CallChecker.varAssign(ii, "ii", 100, 4337, 4341);
                    }
                    int isr = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(index, int[].class, 101, 4373, 4377)) {
                        index = CallChecker.beforeCalled(index, int[].class, 101, 4373, 4377);
                        isr = CallChecker.isCalled(index, int[].class, 101, 4373, 4377)[swapR];
                        CallChecker.varAssign(isr, "isr", 101, 4373, 4377);
                    }
                    if (CallChecker.beforeDeref(c, double[][].class, 102, 4407, 4407)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 102, 4407, 4407)[ii], double[].class, 102, 4407, 4411)) {
                            if (CallChecker.beforeDeref(c, double[][].class, 102, 4419, 4419)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 102, 4419, 4419)[isr], double[].class, 102, 4419, 4424)) {
                                    CallChecker.isCalled(c, double[][].class, 102, 4407, 4407)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 102, 4407, 4407)[ii], double[].class, 102, 4407, 4411);
                                    CallChecker.isCalled(c, double[][].class, 102, 4419, 4419)[isr] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 102, 4419, 4419)[isr], double[].class, 102, 4419, 4424);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 102, 4407, 4407)[ii], double[].class, 102, 4407, 4411)[ii]) > (CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 102, 4419, 4419)[isr], double[].class, 102, 4419, 4424)[isr])) {
                                        swapR = i;
                                        CallChecker.varAssign(swapR, "swapR", 103, 4454, 4463);
                                    }
                                }
                            }
                        }
                    }
                }
                if (swapR != r) {
                    index = CallChecker.beforeCalled(index, int[].class, 110, 4598, 4602);
                    final int tmpIndex = CallChecker.varInit(((int) (CallChecker.isCalled(index, int[].class, 110, 4598, 4602)[r])), "tmpIndex", 110, 4574, 4606);
                    if (CallChecker.beforeDeref(index, int[].class, 111, 4624, 4628)) {
                        if (CallChecker.beforeDeref(index, int[].class, 111, 4648, 4652)) {
                            index = CallChecker.beforeCalled(index, int[].class, 111, 4624, 4628);
                            index = CallChecker.beforeCalled(index, int[].class, 111, 4648, 4652);
                            CallChecker.isCalled(index, int[].class, 111, 4624, 4628)[r] = CallChecker.isCalled(index, int[].class, 111, 4648, 4652)[swapR];
                            CallChecker.varAssign(CallChecker.isCalled(index, int[].class, 111, 4624, 4628)[r], "CallChecker.isCalled(index, int[].class, 111, 4624, 4628)[r]", 111, 4624, 4660);
                        }
                    }
                    if (CallChecker.beforeDeref(index, int[].class, 112, 4678, 4682)) {
                        index = CallChecker.beforeCalled(index, int[].class, 112, 4678, 4682);
                        CallChecker.isCalled(index, int[].class, 112, 4678, 4682)[swapR] = tmpIndex;
                        CallChecker.varAssign(CallChecker.isCalled(index, int[].class, 112, 4678, 4682)[swapR], "CallChecker.isCalled(index, int[].class, 112, 4678, 4682)[swapR]", 112, 4678, 4710);
                    }
                    final double[] tmpRow = CallChecker.varInit(CallChecker.isCalled(b, double[][].class, 113, 4752, 4752)[r], "tmpRow", 113, 4728, 4756);
                    if (CallChecker.beforeDeref(b, double[][].class, 114, 4774, 4774)) {
                        if (CallChecker.beforeDeref(b, double[][].class, 114, 4798, 4798)) {
                            CallChecker.isCalled(b, double[][].class, 114, 4774, 4774)[r] = CallChecker.isCalled(b, double[][].class, 114, 4798, 4798)[swapR];
                            CallChecker.varAssign(CallChecker.isCalled(b, double[][].class, 114, 4774, 4774)[r], "CallChecker.isCalled(b, double[][].class, 114, 4774, 4774)[r]", 114, 4774, 4806);
                        }
                    }
                    if (CallChecker.beforeDeref(b, double[][].class, 115, 4824, 4824)) {
                        CallChecker.isCalled(b, double[][].class, 115, 4824, 4824)[swapR] = tmpRow;
                        CallChecker.varAssign(CallChecker.isCalled(b, double[][].class, 115, 4824, 4824)[swapR], "CallChecker.isCalled(b, double[][].class, 115, 4824, 4824)[swapR]", 115, 4824, 4854);
                    }
                }
                int ir = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(index, int[].class, 119, 4930, 4934)) {
                    index = CallChecker.beforeCalled(index, int[].class, 119, 4930, 4934);
                    ir = CallChecker.isCalled(index, int[].class, 119, 4930, 4934)[r];
                    CallChecker.varAssign(ir, "ir", 119, 4930, 4934);
                }
                if (CallChecker.beforeDeref(c, double[][].class, 120, 4956, 4956)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 120, 4956, 4956)[ir], double[].class, 120, 4956, 4960)) {
                        CallChecker.isCalled(c, double[][].class, 120, 4956, 4956)[ir] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 120, 4956, 4956)[ir], double[].class, 120, 4956, 4960);
                        if ((CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 120, 4956, 4956)[ir], double[].class, 120, 4956, 4960)[ir]) <= small) {
                            if (r == 0) {
                                if (CallChecker.beforeDeref(c, double[][].class, 123, 5074, 5074)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 123, 5074, 5074)[ir], double[].class, 123, 5074, 5078)) {
                                        CallChecker.isCalled(c, double[][].class, 123, 5074, 5074)[ir] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 123, 5074, 5074)[ir], double[].class, 123, 5074, 5078);
                                        throw new NonPositiveDefiniteMatrixException(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 123, 5074, 5074)[ir], double[].class, 123, 5074, 5078)[ir], ir, small);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            for (int i = r; i < order; ++i) {
                                if (CallChecker.beforeDeref(index, int[].class, 128, 5245, 5249)) {
                                    if (CallChecker.beforeDeref(c, double[][].class, 128, 5243, 5243)) {
                                        if (CallChecker.beforeDeref(index, int[].class, 128, 5255, 5259)) {
                                            index = CallChecker.beforeCalled(index, int[].class, 128, 5245, 5249);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 128, 5243, 5243)[CallChecker.isCalled(index, int[].class, 128, 5245, 5249)[i]], double[].class, 128, 5243, 5253)) {
                                                index = CallChecker.beforeCalled(index, int[].class, 128, 5245, 5249);
                                                index = CallChecker.beforeCalled(index, int[].class, 128, 5255, 5259);
                                                CallChecker.isCalled(c, double[][].class, 128, 5243, 5243)[CallChecker.isCalled(index, int[].class, 128, 5245, 5249)[i]] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 128, 5243, 5243)[CallChecker.isCalled(index, int[].class, 128, 5245, 5249)[i]], double[].class, 128, 5243, 5253);
                                                if ((CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 128, 5243, 5243)[CallChecker.isCalled(index, int[].class, 128, 5245, 5249)[i]], double[].class, 128, 5243, 5253)[CallChecker.isCalled(index, int[].class, 128, 5255, 5259)[i]]) < (-small)) {
                                                    if (CallChecker.beforeDeref(index, int[].class, 131, 5516, 5520)) {
                                                        if (CallChecker.beforeDeref(c, double[][].class, 131, 5514, 5514)) {
                                                            if (CallChecker.beforeDeref(index, int[].class, 131, 5526, 5530)) {
                                                                index = CallChecker.beforeCalled(index, int[].class, 131, 5516, 5520);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 131, 5514, 5514)[CallChecker.isCalled(index, int[].class, 131, 5516, 5520)[i]], double[].class, 131, 5514, 5524)) {
                                                                    index = CallChecker.beforeCalled(index, int[].class, 131, 5516, 5520);
                                                                    index = CallChecker.beforeCalled(index, int[].class, 131, 5526, 5530);
                                                                    CallChecker.isCalled(c, double[][].class, 131, 5514, 5514)[CallChecker.isCalled(index, int[].class, 131, 5516, 5520)[i]] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 131, 5514, 5514)[CallChecker.isCalled(index, int[].class, 131, 5516, 5520)[i]], double[].class, 131, 5514, 5524);
                                                                    throw new NonPositiveDefiniteMatrixException(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 131, 5514, 5514)[CallChecker.isCalled(index, int[].class, 131, 5516, 5520)[i]], double[].class, 131, 5514, 5524)[CallChecker.isCalled(index, int[].class, 131, 5526, 5530)[i]], i, small);
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            loop = false;
                            CallChecker.varAssign(loop, "loop", 137, 5775, 5787);
                        }else {
                            CallChecker.isCalled(c, double[][].class, 142, 5902, 5902)[ir] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 142, 5902, 5902)[ir], double[].class, 142, 5902, 5906);
                            final double sqrt = CallChecker.varInit(((double) (FastMath.sqrt(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 142, 5902, 5902)[ir], double[].class, 142, 5902, 5906)[ir]))), "sqrt", 142, 5828, 5912);
                            if (CallChecker.beforeDeref(b, double[][].class, 143, 5930, 5930)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r], double[].class, 143, 5930, 5933)) {
                                    CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r] = CallChecker.beforeCalled(CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r], double[].class, 143, 5930, 5933);
                                    CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r], double[].class, 143, 5930, 5933)[r] = sqrt;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r], double[].class, 143, 5930, 5933)[r], "CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 143, 5930, 5930)[r], double[].class, 143, 5930, 5933)[r]", 143, 5930, 5944);
                                }
                            }
                            final double inverse = CallChecker.varInit(((double) (1 / sqrt)), "inverse", 144, 5962, 5994);
                            CallChecker.isCalled(c, double[][].class, 145, 6040, 6040)[ir] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 145, 6040, 6040)[ir], double[].class, 145, 6040, 6044);
                            final double inverse2 = CallChecker.varInit(((double) (1 / (CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 145, 6040, 6040)[ir], double[].class, 145, 6040, 6044)[ir]))), "inverse2", 145, 6012, 6049);
                            for (int i = r + 1; i < order; ++i) {
                                index = CallChecker.beforeCalled(index, int[].class, 147, 6140, 6144);
                                final int ii = CallChecker.varInit(((int) (CallChecker.isCalled(index, int[].class, 147, 6140, 6144)[i])), "ii", 147, 6125, 6148);
                                CallChecker.isCalled(c, double[][].class, 148, 6197, 6197)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 148, 6197, 6197)[ii], double[].class, 148, 6197, 6201);
                                final double e = CallChecker.varInit(((double) (inverse * (CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 148, 6197, 6197)[ii], double[].class, 148, 6197, 6201)[ir]))), "e", 148, 6170, 6206);
                                if (CallChecker.beforeDeref(b, double[][].class, 149, 6228, 6228)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i], double[].class, 149, 6228, 6231)) {
                                        CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i], double[].class, 149, 6228, 6231);
                                        CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i], double[].class, 149, 6228, 6231)[r] = e;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i], double[].class, 149, 6228, 6231)[r], "CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 149, 6228, 6228)[i], double[].class, 149, 6228, 6231)[r]", 149, 6228, 6239);
                                    }
                                }
                                if (CallChecker.beforeDeref(c, double[][].class, 150, 6261, 6261)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii], double[].class, 150, 6261, 6265)) {
                                        if (CallChecker.beforeDeref(c, double[][].class, 150, 6274, 6274)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 150, 6274, 6274)[ii], double[].class, 150, 6274, 6278)) {
                                                if (CallChecker.beforeDeref(c, double[][].class, 150, 6286, 6286)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 150, 6286, 6286)[ii], double[].class, 150, 6286, 6290)) {
                                                        CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii], double[].class, 150, 6261, 6265);
                                                        CallChecker.isCalled(c, double[][].class, 150, 6274, 6274)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 150, 6274, 6274)[ii], double[].class, 150, 6274, 6278);
                                                        CallChecker.isCalled(c, double[][].class, 150, 6286, 6286)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 150, 6286, 6286)[ii], double[].class, 150, 6286, 6290);
                                                        CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii], double[].class, 150, 6261, 6265)[ii] -= ((CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 150, 6274, 6274)[ii], double[].class, 150, 6274, 6278)[ir]) * (CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 150, 6286, 6286)[ii], double[].class, 150, 6286, 6290)[ir])) * inverse2;
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii], double[].class, 150, 6261, 6265)[ii], "CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 150, 6261, 6261)[ii], double[].class, 150, 6261, 6265)[ii]", 150, 6261, 6306);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int j = r + 1; j < i; ++j) {
                                    index = CallChecker.beforeCalled(index, int[].class, 152, 6401, 6405);
                                    final int ij = CallChecker.varInit(((int) (CallChecker.isCalled(index, int[].class, 152, 6401, 6405)[j])), "ij", 152, 6386, 6409);
                                    CallChecker.isCalled(c, double[][].class, 153, 6452, 6452)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 153, 6452, 6452)[ii], double[].class, 153, 6452, 6456);
                                    CallChecker.isCalled(b, double[][].class, 153, 6468, 6468)[j] = CallChecker.beforeCalled(CallChecker.isCalled(b, double[][].class, 153, 6468, 6468)[j], double[].class, 153, 6468, 6471);
                                    final double f = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 153, 6452, 6452)[ii], double[].class, 153, 6452, 6456)[ij]) - (e * (CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 153, 6468, 6468)[j], double[].class, 153, 6468, 6471)[r])))), "f", 153, 6435, 6475);
                                    if (CallChecker.beforeDeref(c, double[][].class, 154, 6501, 6501)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii], double[].class, 154, 6501, 6505)) {
                                            CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii], double[].class, 154, 6501, 6505);
                                            CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii], double[].class, 154, 6501, 6505)[ij] = f;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii], double[].class, 154, 6501, 6505)[ij], "CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 154, 6501, 6501)[ii], double[].class, 154, 6501, 6505)[ij]", 154, 6501, 6514);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(c, double[][].class, 155, 6540, 6540)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij], double[].class, 155, 6540, 6544)) {
                                            CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij] = CallChecker.beforeCalled(CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij], double[].class, 155, 6540, 6544);
                                            CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij], double[].class, 155, 6540, 6544)[ii] = f;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij], double[].class, 155, 6540, 6544)[ii], "CallChecker.isCalled(CallChecker.isCalled(c, double[][].class, 155, 6540, 6540)[ij], double[].class, 155, 6540, 6544)[ii]", 155, 6540, 6553);
                                        }
                                    }
                                }
                            }
                            loop = (++r) < order;
                            CallChecker.varAssign(loop, "loop", 160, 6654, 6672);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            rank = r;
            CallChecker.varAssign(this.rank, "this.rank", 165, 6740, 6748);
            root = MatrixUtils.createRealMatrix(order, r);
            CallChecker.varAssign(this.root, "this.root", 166, 6758, 6803);
            for (int i = 0; i < order; ++i) {
                for (int j = 0; j < r; ++j) {
                    if (CallChecker.beforeDeref(index, int[].class, 169, 6919, 6923)) {
                        if (CallChecker.beforeDeref(b, double[][].class, 169, 6932, 6932)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(b, double[][].class, 169, 6932, 6932)[i], double[].class, 169, 6932, 6935)) {
                                if (CallChecker.beforeDeref(root, RealMatrix.class, 169, 6905, 6908)) {
                                    index = CallChecker.beforeCalled(index, int[].class, 169, 6919, 6923);
                                    CallChecker.isCalled(b, double[][].class, 169, 6932, 6932)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, double[][].class, 169, 6932, 6932)[i], double[].class, 169, 6932, 6935);
                                    CallChecker.isCalled(root, RealMatrix.class, 169, 6905, 6908).setEntry(CallChecker.isCalled(index, int[].class, 169, 6919, 6923)[i], j, CallChecker.isCalled(CallChecker.isCalled(b, double[][].class, 169, 6932, 6932)[i], double[].class, 169, 6932, 6935)[j]);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public RealMatrix getRootMatrix() {
        MethodContext _bcornu_methode_context53 = new MethodContext(RealMatrix.class, 181, 6978, 7295);
        try {
            CallChecker.varInit(this, "this", 181, 6978, 7295);
            CallChecker.varInit(this.rank, "rank", 181, 6978, 7295);
            CallChecker.varInit(this.root, "root", 181, 6978, 7295);
            return root;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public int getRank() {
        MethodContext _bcornu_methode_context54 = new MethodContext(int.class, 192, 7302, 7683);
        try {
            CallChecker.varInit(this, "this", 192, 7302, 7683);
            CallChecker.varInit(this.rank, "rank", 192, 7302, 7683);
            CallChecker.varInit(this.root, "root", 192, 7302, 7683);
            return rank;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }
}

