package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class EigenDecomposition {
    private static class Solver implements DecompositionSolver {
        private double[] realEigenvalues;

        private double[] imagEigenvalues;

        private final ArrayRealVector[] eigenvectors;

        private Solver(final double[] realEigenvalues, final double[] imagEigenvalues, final ArrayRealVector[] eigenvectors) {
            ConstructorContext _bcornu_methode_context894 = new ConstructorContext(EigenDecomposition.Solver.class, 428, 15681, 16256);
            try {
                this.realEigenvalues = realEigenvalues;
                CallChecker.varAssign(this.realEigenvalues, "this.realEigenvalues", 431, 16110, 16148);
                this.imagEigenvalues = imagEigenvalues;
                CallChecker.varAssign(this.imagEigenvalues, "this.imagEigenvalues", 432, 16162, 16200);
                this.eigenvectors = eigenvectors;
                CallChecker.varAssign(this.eigenvectors, "this.eigenvectors", 433, 16214, 16246);
            } finally {
                _bcornu_methode_context894.methodEnd();
            }
        }

        public RealVector solve(final RealVector b) {
            MethodContext _bcornu_methode_context3989 = new MethodContext(RealVector.class, 449, 16267, 17653);
            try {
                CallChecker.varInit(this, "this", 449, 16267, 17653);
                CallChecker.varInit(b, "b", 449, 16267, 17653);
                CallChecker.varInit(this.eigenvectors, "eigenvectors", 449, 16267, 17653);
                CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 449, 16267, 17653);
                CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 449, 16267, 17653);
                if (!(isNonSingular())) {
                    throw new SingularMatrixException();
                }
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 454, 17043, 17057);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.realEigenvalues, double[].class, 454, 17043, 17057).length)), "m", 454, 17029, 17065);
                if (CallChecker.beforeDeref(b, RealVector.class, 455, 17083, 17083)) {
                    if ((CallChecker.isCalled(b, RealVector.class, 455, 17083, 17083).getDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealVector.class, 456, 17161, 17161)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealVector.class, 456, 17161, 17161).getDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final double[] bp = CallChecker.varInit(new double[m], "bp", 459, 17210, 17243);
                for (int i = 0; i < m; ++i) {
                    final ArrayRealVector v = CallChecker.varInit(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 461, 17329, 17340)[i], "v", 461, 17303, 17344);
                    final double[] vData = CallChecker.varInit(CallChecker.isCalled(v, ArrayRealVector.class, 462, 17385, 17385).getDataRef(), "vData", 462, 17362, 17399);
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 463, 17452, 17466);
                    final double s = CallChecker.varInit(((double) ((CallChecker.isCalled(v, ArrayRealVector.class, 463, 17434, 17434).dotProduct(b)) / (CallChecker.isCalled(this.realEigenvalues, double[].class, 463, 17452, 17466)[i]))), "s", 463, 17417, 17470);
                    for (int j = 0; j < m; ++j) {
                        if (CallChecker.beforeDeref(bp, double[].class, 465, 17538, 17539)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 465, 17551, 17555)) {
                                CallChecker.isCalled(bp, double[].class, 465, 17538, 17539)[j] += s * (CallChecker.isCalled(vData, double[].class, 465, 17551, 17555)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(bp, double[].class, 465, 17538, 17539)[j], "CallChecker.isCalled(bp, double[].class, 465, 17538, 17539)[j]", 465, 17538, 17559);
                            }
                        }
                    }
                }
                return new ArrayRealVector(bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3989.methodEnd();
            }
        }

        public RealMatrix solve(RealMatrix b) {
            MethodContext _bcornu_methode_context3990 = new MethodContext(RealMatrix.class, 473, 17664, 18976);
            try {
                CallChecker.varInit(this, "this", 473, 17664, 18976);
                CallChecker.varInit(b, "b", 473, 17664, 18976);
                CallChecker.varInit(this.eigenvectors, "eigenvectors", 473, 17664, 18976);
                CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 473, 17664, 18976);
                CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 473, 17664, 18976);
                if (!(isNonSingular())) {
                    throw new SingularMatrixException();
                }
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 479, 17864, 17878);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.realEigenvalues, double[].class, 479, 17864, 17878).length)), "m", 479, 17850, 17886);
                if (CallChecker.beforeDeref(b, RealMatrix.class, 480, 17904, 17904)) {
                    b = CallChecker.beforeCalled(b, RealMatrix.class, 480, 17904, 17904);
                    if ((CallChecker.isCalled(b, RealMatrix.class, 480, 17904, 17904).getRowDimension()) != m) {
                        if (CallChecker.beforeDeref(b, RealMatrix.class, 481, 17985, 17985)) {
                            b = CallChecker.beforeCalled(b, RealMatrix.class, 481, 17985, 17985);
                            throw new DimensionMismatchException(CallChecker.isCalled(b, RealMatrix.class, 481, 17985, 17985).getRowDimension(), m);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                b = CallChecker.beforeCalled(b, RealMatrix.class, 484, 18055, 18055);
                final int nColB = CallChecker.varInit(((int) (CallChecker.isCalled(b, RealMatrix.class, 484, 18055, 18055).getColumnDimension())), "nColB", 484, 18037, 18077);
                final double[][] bp = CallChecker.varInit(new double[m][nColB], "bp", 485, 18091, 18133);
                final double[] tmpCol = CallChecker.varInit(new double[m], "tmpCol", 486, 18147, 18184);
                for (int k = 0; k < nColB; ++k) {
                    for (int i = 0; i < m; ++i) {
                        if (CallChecker.beforeDeref(tmpCol, double[].class, 489, 18298, 18303)) {
                            if (CallChecker.beforeDeref(b, RealMatrix.class, 489, 18310, 18310)) {
                                b = CallChecker.beforeCalled(b, RealMatrix.class, 489, 18310, 18310);
                                CallChecker.isCalled(tmpCol, double[].class, 489, 18298, 18303)[i] = CallChecker.isCalled(b, RealMatrix.class, 489, 18310, 18310).getEntry(i, k);
                                CallChecker.varAssign(CallChecker.isCalled(tmpCol, double[].class, 489, 18298, 18303)[i], "CallChecker.isCalled(tmpCol, double[].class, 489, 18298, 18303)[i]", 489, 18298, 18326);
                            }
                        }
                        if (CallChecker.beforeDeref(bp, double[][].class, 490, 18348, 18349)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i], double[].class, 490, 18348, 18352)) {
                                CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i] = CallChecker.beforeCalled(CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i], double[].class, 490, 18348, 18352);
                                CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i], double[].class, 490, 18348, 18352)[k] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i], double[].class, 490, 18348, 18352)[k], "CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 490, 18348, 18349)[i], double[].class, 490, 18348, 18352)[k]", 490, 18348, 18361);
                            }
                        }
                    }
                    for (int i = 0; i < m; ++i) {
                        final ArrayRealVector v = CallChecker.varInit(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 493, 18473, 18484)[i], "v", 493, 18447, 18488);
                        final double[] vData = CallChecker.varInit(CallChecker.isCalled(v, ArrayRealVector.class, 494, 18533, 18533).getDataRef(), "vData", 494, 18510, 18547);
                        double s = CallChecker.varInit(((double) (0)), "s", 495, 18569, 18581);
                        for (int j = 0; j < m; ++j) {
                            if (CallChecker.beforeDeref(v, ArrayRealVector.class, 497, 18662, 18662)) {
                                if (CallChecker.beforeDeref(tmpCol, double[].class, 497, 18678, 18683)) {
                                    s += (CallChecker.isCalled(v, ArrayRealVector.class, 497, 18662, 18662).getEntry(j)) * (CallChecker.isCalled(tmpCol, double[].class, 497, 18678, 18683)[j]);
                                    CallChecker.varAssign(s, "s", 497, 18657, 18687);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 499, 18736, 18750)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 499, 18736, 18750);
                            s /= CallChecker.isCalled(realEigenvalues, double[].class, 499, 18736, 18750)[i];
                            CallChecker.varAssign(s, "s", 499, 18731, 18754);
                        }
                        for (int j = 0; j < m; ++j) {
                            if (CallChecker.beforeDeref(bp, double[][].class, 501, 18830, 18831)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j], double[].class, 501, 18830, 18834)) {
                                    if (CallChecker.beforeDeref(vData, double[].class, 501, 18846, 18850)) {
                                        CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j] = CallChecker.beforeCalled(CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j], double[].class, 501, 18830, 18834);
                                        CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j], double[].class, 501, 18830, 18834)[k] += s * (CallChecker.isCalled(vData, double[].class, 501, 18846, 18850)[j]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j], double[].class, 501, 18830, 18834)[k], "CallChecker.isCalled(CallChecker.isCalled(bp, double[][].class, 501, 18830, 18831)[j], double[].class, 501, 18830, 18834)[k]", 501, 18830, 18854);
                                    }
                                }
                            }
                        }
                    }
                }
                return new Array2DRowRealMatrix(bp, false);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3990.methodEnd();
            }
        }

        public boolean isNonSingular() {
            MethodContext _bcornu_methode_context3991 = new MethodContext(boolean.class, 515, 18987, 19442);
            try {
                CallChecker.varInit(this, "this", 515, 18987, 19442);
                CallChecker.varInit(this.eigenvectors, "eigenvectors", 515, 18987, 19442);
                CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 515, 18987, 19442);
                CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 515, 18987, 19442);
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 516, 19218, 19232);
                for (int i = 0; i < (CallChecker.isCalled(realEigenvalues, double[].class, 516, 19218, 19232).length); ++i) {
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 517, 19269, 19283)) {
                        if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 518, 19316, 19330)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 517, 19269, 19283);
                            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 518, 19316, 19330);
                            if (((CallChecker.isCalled(realEigenvalues, double[].class, 517, 19269, 19283)[i]) == 0) && ((CallChecker.isCalled(imagEigenvalues, double[].class, 518, 19316, 19330)[i]) == 0)) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3991.methodEnd();
            }
        }

        public RealMatrix getInverse() {
            MethodContext _bcornu_methode_context3992 = new MethodContext(RealMatrix.class, 531, 19453, 20432);
            try {
                CallChecker.varInit(this, "this", 531, 19453, 20432);
                CallChecker.varInit(this.eigenvectors, "eigenvectors", 531, 19453, 20432);
                CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 531, 19453, 20432);
                CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 531, 19453, 20432);
                if (!(isNonSingular())) {
                    throw new SingularMatrixException();
                }
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 536, 19824, 19838);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.realEigenvalues, double[].class, 536, 19824, 19838).length)), "m", 536, 19810, 19846);
                final double[][] invData = CallChecker.varInit(new double[m][m], "invData", 537, 19860, 19903);
                for (int i = 0; i < m; ++i) {
                    final double[] invI = CallChecker.varInit(CallChecker.isCalled(invData, double[][].class, 540, 19986, 19992)[i], "invI", 540, 19964, 19996);
                    for (int j = 0; j < m; ++j) {
                        double invIJ = CallChecker.varInit(((double) (0)), "invIJ", 542, 20064, 20080);
                        for (int k = 0; k < m; ++k) {
                            CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 544, 20176, 20187)[k] = CallChecker.beforeCalled(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 544, 20176, 20187)[k], ArrayRealVector.class, 544, 20176, 20190);
                            final double[] vK = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 544, 20176, 20187)[k], ArrayRealVector.class, 544, 20176, 20190).getDataRef(), "vK", 544, 20156, 20204);
                            if (CallChecker.beforeDeref(vK, double[].class, 545, 20239, 20240)) {
                                if (CallChecker.beforeDeref(vK, double[].class, 545, 20247, 20248)) {
                                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 545, 20255, 20269)) {
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 545, 20255, 20269);
                                        invIJ += ((CallChecker.isCalled(vK, double[].class, 545, 20239, 20240)[i]) * (CallChecker.isCalled(vK, double[].class, 545, 20247, 20248)[j])) / (CallChecker.isCalled(realEigenvalues, double[].class, 545, 20255, 20269)[k]);
                                        CallChecker.varAssign(invIJ, "invIJ", 545, 20230, 20273);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(invI, double[].class, 547, 20317, 20320)) {
                            CallChecker.isCalled(invI, double[].class, 547, 20317, 20320)[j] = invIJ;
                            CallChecker.varAssign(CallChecker.isCalled(invI, double[].class, 547, 20317, 20320)[j], "CallChecker.isCalled(invI, double[].class, 547, 20317, 20320)[j]", 547, 20317, 20332);
                        }
                    }
                }
                return MatrixUtils.createRealMatrix(invData);
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3992.methodEnd();
            }
        }
    }

    private static final double EPSILON = 1.0E-12;

    private byte maxIter = 30;

    private double[] main;

    private double[] secondary;

    private TriDiagonalTransformer transformer;

    private double[] realEigenvalues;

    private double[] imagEigenvalues;

    private ArrayRealVector[] eigenvectors;

    private RealMatrix cachedV;

    private RealMatrix cachedD;

    private RealMatrix cachedVt;

    private final boolean isSymmetric;

    public EigenDecomposition(final RealMatrix matrix) throws MathArithmeticException {
        ConstructorContext _bcornu_methode_context895 = new ConstructorContext(EigenDecomposition.class, 117, 4785, 5742);
        try {
            final double symTol = CallChecker.varInit(((double) (((10 * (CallChecker.isCalled(matrix, RealMatrix.class, 119, 5334, 5339).getRowDimension())) * (CallChecker.isCalled(matrix, RealMatrix.class, 119, 5361, 5366).getColumnDimension())) * (Precision.EPSILON))), "symTol", 119, 5307, 5408);
            isSymmetric = MatrixUtils.isSymmetric(matrix, symTol);
            CallChecker.varAssign(this.isSymmetric, "this.isSymmetric", 120, 5418, 5471);
            if (isSymmetric) {
                transformToTridiagonal(matrix);
                if (CallChecker.beforeDeref(transformer, TriDiagonalTransformer.class, 123, 5573, 5583)) {
                    transformer = CallChecker.beforeCalled(transformer, TriDiagonalTransformer.class, 123, 5573, 5583);
                    final RealMatrix npe_invocation_var843 = CallChecker.isCalled(transformer, TriDiagonalTransformer.class, 123, 5573, 5583).getQ();
                    if (CallChecker.beforeDeref(npe_invocation_var843, RealMatrix.class, 123, 5573, 5590)) {
                        findEigenVectors(CallChecker.isCalled(npe_invocation_var843, RealMatrix.class, 123, 5573, 5590).getData());
                    }
                }
            }else {
                final SchurTransformer t = CallChecker.varInit(transformToSchur(matrix), "t", 125, 5633, 5684);
                findEigenVectorsFromSchur(t);
            }
        } finally {
            _bcornu_methode_context895.methodEnd();
        }
    }

    @Deprecated
    public EigenDecomposition(final RealMatrix matrix, final double splitTolerance) throws MathArithmeticException {
        this(matrix);
        ConstructorContext _bcornu_methode_context896 = new ConstructorContext(EigenDecomposition.class, 142, 5749, 6443);
        try {
        } finally {
            _bcornu_methode_context896.methodEnd();
        }
    }

    public EigenDecomposition(final double[] main, final double[] secondary) {
        ConstructorContext _bcornu_methode_context897 = new ConstructorContext(EigenDecomposition.class, 157, 6450, 7262);
        try {
            isSymmetric = true;
            CallChecker.varAssign(this.isSymmetric, "this.isSymmetric", 158, 6926, 6944);
            if (CallChecker.beforeDeref(main, double[].class, 159, 6971, 6974)) {
                this.main = CallChecker.isCalled(main, double[].class, 159, 6971, 6974).clone();
                CallChecker.varAssign(this.main, "this.main", 159, 6954, 6983);
            }
            if (CallChecker.beforeDeref(secondary, double[].class, 160, 7010, 7018)) {
                this.secondary = CallChecker.isCalled(secondary, double[].class, 160, 7010, 7018).clone();
                CallChecker.varAssign(this.secondary, "this.secondary", 160, 6993, 7027);
            }
            transformer = null;
            CallChecker.varAssign(this.transformer, "this.transformer", 161, 7037, 7058);
            final int size = CallChecker.varInit(((int) (CallChecker.isCalled(main, double[].class, 162, 7085, 7088).length)), "size", 162, 7068, 7096);
            final double[][] z = CallChecker.varInit(new double[size][size], "z", 163, 7106, 7149);
            for (int i = 0; i < size; i++) {
                if (CallChecker.beforeDeref(z, double[][].class, 165, 7204, 7204)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i], double[].class, 165, 7204, 7207)) {
                        CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i], double[].class, 165, 7204, 7207);
                        CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i], double[].class, 165, 7204, 7207)[i] = 1.0;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i], double[].class, 165, 7204, 7207)[i], "CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 165, 7204, 7204)[i], double[].class, 165, 7204, 7207)[i]", 165, 7204, 7217);
                    }
                }
            }
            findEigenVectors(z);
        } finally {
            _bcornu_methode_context897.methodEnd();
        }
    }

    @Deprecated
    public EigenDecomposition(final double[] main, final double[] secondary, final double splitTolerance) {
        this(main, secondary);
        ConstructorContext _bcornu_methode_context898 = new ConstructorContext(EigenDecomposition.class, 182, 7269, 7997);
        try {
        } finally {
            _bcornu_methode_context898.methodEnd();
        }
    }

    public RealMatrix getV() {
        MethodContext _bcornu_methode_context3993 = new MethodContext(RealMatrix.class, 197, 8004, 8786);
        try {
            CallChecker.varInit(this, "this", 197, 8004, 8786);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 197, 8004, 8786);
            CallChecker.varInit(this.cachedVt, "cachedVt", 197, 8004, 8786);
            CallChecker.varInit(this.cachedD, "cachedD", 197, 8004, 8786);
            CallChecker.varInit(this.cachedV, "cachedV", 197, 8004, 8786);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 197, 8004, 8786);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 197, 8004, 8786);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 197, 8004, 8786);
            CallChecker.varInit(this.transformer, "transformer", 197, 8004, 8786);
            CallChecker.varInit(this.secondary, "secondary", 197, 8004, 8786);
            CallChecker.varInit(this.main, "main", 197, 8004, 8786);
            CallChecker.varInit(this.maxIter, "maxIter", 197, 8004, 8786);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 197, 8004, 8786);
            if ((cachedV) == null) {
                eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 200, 8516, 8527);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 200, 8516, 8527).length)), "m", 200, 8502, 8535);
                cachedV = MatrixUtils.createRealMatrix(m, m);
                CallChecker.varAssign(this.cachedV, "this.cachedV", 201, 8549, 8593);
                for (int k = 0; k < m; ++k) {
                    if (CallChecker.beforeDeref(eigenvectors, ArrayRealVector[].class, 203, 8680, 8691)) {
                        if (CallChecker.beforeDeref(cachedV, RealMatrix.class, 203, 8653, 8659)) {
                            eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 203, 8680, 8691);
                            cachedV = CallChecker.beforeCalled(cachedV, RealMatrix.class, 203, 8653, 8659);
                            CallChecker.isCalled(cachedV, RealMatrix.class, 203, 8653, 8659).setColumnVector(k, CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 203, 8680, 8691)[k]);
                        }
                    }
                }
            }
            return cachedV;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3993.methodEnd();
        }
    }

    public RealMatrix getD() {
        MethodContext _bcornu_methode_context3994 = new MethodContext(RealMatrix.class, 221, 8793, 9776);
        try {
            CallChecker.varInit(this, "this", 221, 8793, 9776);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 221, 8793, 9776);
            CallChecker.varInit(this.cachedVt, "cachedVt", 221, 8793, 9776);
            CallChecker.varInit(this.cachedD, "cachedD", 221, 8793, 9776);
            CallChecker.varInit(this.cachedV, "cachedV", 221, 8793, 9776);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 221, 8793, 9776);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 221, 8793, 9776);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 221, 8793, 9776);
            CallChecker.varInit(this.transformer, "transformer", 221, 8793, 9776);
            CallChecker.varInit(this.secondary, "secondary", 221, 8793, 9776);
            CallChecker.varInit(this.main, "main", 221, 8793, 9776);
            CallChecker.varInit(this.maxIter, "maxIter", 221, 8793, 9776);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 221, 8793, 9776);
            if ((cachedD) == null) {
                cachedD = MatrixUtils.createRealDiagonalMatrix(realEigenvalues);
                CallChecker.varAssign(this.cachedD, "this.cachedD", 225, 9276, 9339);
                imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 227, 9374, 9388);
                for (int i = 0; i < (CallChecker.isCalled(imagEigenvalues, double[].class, 227, 9374, 9388).length); i++) {
                    if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 228, 9445, 9459)) {
                        imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 228, 9445, 9459);
                        if ((Precision.compareTo(CallChecker.isCalled(imagEigenvalues, double[].class, 228, 9445, 9459)[i], 0.0, EigenDecomposition.EPSILON)) > 0) {
                            if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 229, 9531, 9545)) {
                                if (CallChecker.beforeDeref(cachedD, RealMatrix.class, 229, 9506, 9512)) {
                                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 229, 9531, 9545);
                                    cachedD = CallChecker.beforeCalled(cachedD, RealMatrix.class, 229, 9506, 9512);
                                    CallChecker.isCalled(cachedD, RealMatrix.class, 229, 9506, 9512).setEntry(i, (i + 1), CallChecker.isCalled(imagEigenvalues, double[].class, 229, 9531, 9545)[i]);
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 230, 9599, 9613)) {
                                imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 230, 9599, 9613);
                                if ((Precision.compareTo(CallChecker.isCalled(imagEigenvalues, double[].class, 230, 9599, 9613)[i], 0.0, EigenDecomposition.EPSILON)) < 0) {
                                    if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 231, 9685, 9699)) {
                                        if (CallChecker.beforeDeref(cachedD, RealMatrix.class, 231, 9660, 9666)) {
                                            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 231, 9685, 9699);
                                            cachedD = CallChecker.beforeCalled(cachedD, RealMatrix.class, 231, 9660, 9666);
                                            CallChecker.isCalled(cachedD, RealMatrix.class, 231, 9660, 9666).setEntry(i, (i - 1), CallChecker.isCalled(imagEigenvalues, double[].class, 231, 9685, 9699)[i]);
                                        }
                                    }
                                }
                            }
                        
                    }
                }
            }
            return cachedD;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3994.methodEnd();
        }
    }

    public RealMatrix getVT() {
        MethodContext _bcornu_methode_context3995 = new MethodContext(RealMatrix.class, 248, 9783, 10602);
        try {
            CallChecker.varInit(this, "this", 248, 9783, 10602);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 248, 9783, 10602);
            CallChecker.varInit(this.cachedVt, "cachedVt", 248, 9783, 10602);
            CallChecker.varInit(this.cachedD, "cachedD", 248, 9783, 10602);
            CallChecker.varInit(this.cachedV, "cachedV", 248, 9783, 10602);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 248, 9783, 10602);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 248, 9783, 10602);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 248, 9783, 10602);
            CallChecker.varInit(this.transformer, "transformer", 248, 9783, 10602);
            CallChecker.varInit(this.secondary, "secondary", 248, 9783, 10602);
            CallChecker.varInit(this.main, "main", 248, 9783, 10602);
            CallChecker.varInit(this.maxIter, "maxIter", 248, 9783, 10602);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 248, 9783, 10602);
            if ((cachedVt) == null) {
                eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 251, 10331, 10342);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 251, 10331, 10342).length)), "m", 251, 10317, 10350);
                cachedVt = MatrixUtils.createRealMatrix(m, m);
                CallChecker.varAssign(this.cachedVt, "this.cachedVt", 252, 10364, 10409);
                for (int k = 0; k < m; ++k) {
                    if (CallChecker.beforeDeref(eigenvectors, ArrayRealVector[].class, 254, 10494, 10505)) {
                        if (CallChecker.beforeDeref(cachedVt, RealMatrix.class, 254, 10469, 10476)) {
                            eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 254, 10494, 10505);
                            cachedVt = CallChecker.beforeCalled(cachedVt, RealMatrix.class, 254, 10469, 10476);
                            CallChecker.isCalled(cachedVt, RealMatrix.class, 254, 10469, 10476).setRowVector(k, CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 254, 10494, 10505)[k]);
                        }
                    }
                }
            }
            return cachedVt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3995.methodEnd();
        }
    }

    public boolean hasComplexEigenvalues() {
        MethodContext _bcornu_methode_context3996 = new MethodContext(boolean.class, 271, 10609, 11236);
        try {
            CallChecker.varInit(this, "this", 271, 10609, 11236);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 271, 10609, 11236);
            CallChecker.varInit(this.cachedVt, "cachedVt", 271, 10609, 11236);
            CallChecker.varInit(this.cachedD, "cachedD", 271, 10609, 11236);
            CallChecker.varInit(this.cachedV, "cachedV", 271, 10609, 11236);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 271, 10609, 11236);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 271, 10609, 11236);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 271, 10609, 11236);
            CallChecker.varInit(this.transformer, "transformer", 271, 10609, 11236);
            CallChecker.varInit(this.secondary, "secondary", 271, 10609, 11236);
            CallChecker.varInit(this.main, "main", 271, 10609, 11236);
            CallChecker.varInit(this.maxIter, "maxIter", 271, 10609, 11236);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 271, 10609, 11236);
            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 272, 11055, 11069);
            for (int i = 0; i < (CallChecker.isCalled(imagEigenvalues, double[].class, 272, 11055, 11069).length); i++) {
                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 273, 11120, 11134)) {
                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 273, 11120, 11134);
                    if (!(Precision.equals(CallChecker.isCalled(imagEigenvalues, double[].class, 273, 11120, 11134)[i], 0.0, EigenDecomposition.EPSILON))) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3996.methodEnd();
        }
    }

    public double[] getRealEigenvalues() {
        MethodContext _bcornu_methode_context3997 = new MethodContext(double[].class, 289, 11243, 11609);
        try {
            CallChecker.varInit(this, "this", 289, 11243, 11609);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 289, 11243, 11609);
            CallChecker.varInit(this.cachedVt, "cachedVt", 289, 11243, 11609);
            CallChecker.varInit(this.cachedD, "cachedD", 289, 11243, 11609);
            CallChecker.varInit(this.cachedV, "cachedV", 289, 11243, 11609);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 289, 11243, 11609);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 289, 11243, 11609);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 289, 11243, 11609);
            CallChecker.varInit(this.transformer, "transformer", 289, 11243, 11609);
            CallChecker.varInit(this.secondary, "secondary", 289, 11243, 11609);
            CallChecker.varInit(this.main, "main", 289, 11243, 11609);
            CallChecker.varInit(this.maxIter, "maxIter", 289, 11243, 11609);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 289, 11243, 11609);
            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 290, 11580, 11594)) {
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 290, 11580, 11594);
                return CallChecker.isCalled(realEigenvalues, double[].class, 290, 11580, 11594).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3997.methodEnd();
        }
    }

    public double getRealEigenvalue(final int i) {
        MethodContext _bcornu_methode_context3998 = new MethodContext(double.class, 305, 11616, 12062);
        try {
            CallChecker.varInit(this, "this", 305, 11616, 12062);
            CallChecker.varInit(i, "i", 305, 11616, 12062);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 305, 11616, 12062);
            CallChecker.varInit(this.cachedVt, "cachedVt", 305, 11616, 12062);
            CallChecker.varInit(this.cachedD, "cachedD", 305, 11616, 12062);
            CallChecker.varInit(this.cachedV, "cachedV", 305, 11616, 12062);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 305, 11616, 12062);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 305, 11616, 12062);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 305, 11616, 12062);
            CallChecker.varInit(this.transformer, "transformer", 305, 11616, 12062);
            CallChecker.varInit(this.secondary, "secondary", 305, 11616, 12062);
            CallChecker.varInit(this.main, "main", 305, 11616, 12062);
            CallChecker.varInit(this.maxIter, "maxIter", 305, 11616, 12062);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 305, 11616, 12062);
            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 306, 12038, 12052)) {
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 306, 12038, 12052);
                return CallChecker.isCalled(realEigenvalues, double[].class, 306, 12038, 12052)[i];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3998.methodEnd();
        }
    }

    public double[] getImagEigenvalues() {
        MethodContext _bcornu_methode_context3999 = new MethodContext(double[].class, 320, 12069, 12459);
        try {
            CallChecker.varInit(this, "this", 320, 12069, 12459);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 320, 12069, 12459);
            CallChecker.varInit(this.cachedVt, "cachedVt", 320, 12069, 12459);
            CallChecker.varInit(this.cachedD, "cachedD", 320, 12069, 12459);
            CallChecker.varInit(this.cachedV, "cachedV", 320, 12069, 12459);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 320, 12069, 12459);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 320, 12069, 12459);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 320, 12069, 12459);
            CallChecker.varInit(this.transformer, "transformer", 320, 12069, 12459);
            CallChecker.varInit(this.secondary, "secondary", 320, 12069, 12459);
            CallChecker.varInit(this.main, "main", 320, 12069, 12459);
            CallChecker.varInit(this.maxIter, "maxIter", 320, 12069, 12459);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 320, 12069, 12459);
            if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 321, 12430, 12444)) {
                imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 321, 12430, 12444);
                return CallChecker.isCalled(imagEigenvalues, double[].class, 321, 12430, 12444).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3999.methodEnd();
        }
    }

    public double getImagEigenvalue(final int i) {
        MethodContext _bcornu_methode_context4000 = new MethodContext(double.class, 336, 12466, 12924);
        try {
            CallChecker.varInit(this, "this", 336, 12466, 12924);
            CallChecker.varInit(i, "i", 336, 12466, 12924);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 336, 12466, 12924);
            CallChecker.varInit(this.cachedVt, "cachedVt", 336, 12466, 12924);
            CallChecker.varInit(this.cachedD, "cachedD", 336, 12466, 12924);
            CallChecker.varInit(this.cachedV, "cachedV", 336, 12466, 12924);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 336, 12466, 12924);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 336, 12466, 12924);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 336, 12466, 12924);
            CallChecker.varInit(this.transformer, "transformer", 336, 12466, 12924);
            CallChecker.varInit(this.secondary, "secondary", 336, 12466, 12924);
            CallChecker.varInit(this.main, "main", 336, 12466, 12924);
            CallChecker.varInit(this.maxIter, "maxIter", 336, 12466, 12924);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 336, 12466, 12924);
            if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 337, 12900, 12914)) {
                imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 337, 12900, 12914);
                return CallChecker.isCalled(imagEigenvalues, double[].class, 337, 12900, 12914)[i];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4000.methodEnd();
        }
    }

    public RealVector getEigenvector(final int i) {
        MethodContext _bcornu_methode_context4001 = new MethodContext(RealVector.class, 347, 12931, 13282);
        try {
            CallChecker.varInit(this, "this", 347, 12931, 13282);
            CallChecker.varInit(i, "i", 347, 12931, 13282);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 347, 12931, 13282);
            CallChecker.varInit(this.cachedVt, "cachedVt", 347, 12931, 13282);
            CallChecker.varInit(this.cachedD, "cachedD", 347, 12931, 13282);
            CallChecker.varInit(this.cachedV, "cachedV", 347, 12931, 13282);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 347, 12931, 13282);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 347, 12931, 13282);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 347, 12931, 13282);
            CallChecker.varInit(this.transformer, "transformer", 347, 12931, 13282);
            CallChecker.varInit(this.secondary, "secondary", 347, 12931, 13282);
            CallChecker.varInit(this.main, "main", 347, 12931, 13282);
            CallChecker.varInit(this.maxIter, "maxIter", 347, 12931, 13282);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 347, 12931, 13282);
            if (CallChecker.beforeDeref(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265)) {
                eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265);
                if (CallChecker.beforeDeref(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265)[i], ArrayRealVector.class, 348, 13254, 13268)) {
                    eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265);
                    CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265)[i] = CallChecker.beforeCalled(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265)[i], ArrayRealVector.class, 348, 13254, 13268);
                    return CallChecker.isCalled(CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 348, 13254, 13265)[i], ArrayRealVector.class, 348, 13254, 13268).copy();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4001.methodEnd();
        }
    }

    public double getDeterminant() {
        MethodContext _bcornu_methode_context4002 = new MethodContext(double.class, 356, 13289, 13595);
        try {
            CallChecker.varInit(this, "this", 356, 13289, 13595);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 356, 13289, 13595);
            CallChecker.varInit(this.cachedVt, "cachedVt", 356, 13289, 13595);
            CallChecker.varInit(this.cachedD, "cachedD", 356, 13289, 13595);
            CallChecker.varInit(this.cachedV, "cachedV", 356, 13289, 13595);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 356, 13289, 13595);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 356, 13289, 13595);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 356, 13289, 13595);
            CallChecker.varInit(this.transformer, "transformer", 356, 13289, 13595);
            CallChecker.varInit(this.secondary, "secondary", 356, 13289, 13595);
            CallChecker.varInit(this.main, "main", 356, 13289, 13595);
            CallChecker.varInit(this.maxIter, "maxIter", 356, 13289, 13595);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 356, 13289, 13595);
            double determinant = CallChecker.varInit(((double) (1)), "determinant", 357, 13446, 13468);
            if (CallChecker.beforeDeref(realEigenvalues, double.class, 358, 13499, 13513)) {
                for (double lambda : realEigenvalues) {
                    determinant *= lambda;
                    CallChecker.varAssign(determinant, "determinant", 359, 13530, 13551);
                }
            }
            return determinant;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4002.methodEnd();
        }
    }

    public RealMatrix getSquareRoot() {
        MethodContext _bcornu_methode_context4003 = new MethodContext(RealMatrix.class, 374, 13602, 14662);
        try {
            CallChecker.varInit(this, "this", 374, 13602, 14662);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 374, 13602, 14662);
            CallChecker.varInit(this.cachedVt, "cachedVt", 374, 13602, 14662);
            CallChecker.varInit(this.cachedD, "cachedD", 374, 13602, 14662);
            CallChecker.varInit(this.cachedV, "cachedV", 374, 13602, 14662);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 374, 13602, 14662);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 374, 13602, 14662);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 374, 13602, 14662);
            CallChecker.varInit(this.transformer, "transformer", 374, 13602, 14662);
            CallChecker.varInit(this.secondary, "secondary", 374, 13602, 14662);
            CallChecker.varInit(this.main, "main", 374, 13602, 14662);
            CallChecker.varInit(this.maxIter, "maxIter", 374, 13602, 14662);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 374, 13602, 14662);
            if (!(isSymmetric)) {
                throw new MathUnsupportedOperationException();
            }
            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 379, 14129, 14143);
            final double[] sqrtEigenValues = CallChecker.varInit(new double[CallChecker.isCalled(realEigenvalues, double[].class, 379, 14129, 14143).length], "sqrtEigenValues", 379, 14085, 14152);
            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 380, 14182, 14196);
            for (int i = 0; i < (CallChecker.isCalled(realEigenvalues, double[].class, 380, 14182, 14196).length); i++) {
                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 381, 14246, 14260);
                final double eigen = CallChecker.varInit(((double) (CallChecker.isCalled(this.realEigenvalues, double[].class, 381, 14246, 14260)[i])), "eigen", 381, 14225, 14264);
                if (eigen <= 0) {
                    throw new MathUnsupportedOperationException();
                }
                if (CallChecker.beforeDeref(sqrtEigenValues, double[].class, 385, 14385, 14399)) {
                    CallChecker.isCalled(sqrtEigenValues, double[].class, 385, 14385, 14399)[i] = FastMath.sqrt(eigen);
                    CallChecker.varAssign(CallChecker.isCalled(sqrtEigenValues, double[].class, 385, 14385, 14399)[i], "CallChecker.isCalled(sqrtEigenValues, double[].class, 385, 14385, 14399)[i]", 385, 14385, 14426);
                }
            }
            final RealMatrix sqrtEigen = CallChecker.varInit(MatrixUtils.createRealDiagonalMatrix(sqrtEigenValues), "sqrtEigen", 387, 14446, 14528);
            final RealMatrix v = CallChecker.varInit(getV(), "v", 388, 14538, 14565);
            final RealMatrix vT = CallChecker.varInit(getVT(), "vT", 389, 14575, 14604);
            if (CallChecker.beforeDeref(v, RealMatrix.class, 391, 14622, 14622)) {
                final RealMatrix npe_invocation_var844 = CallChecker.isCalled(v, RealMatrix.class, 391, 14622, 14622).multiply(sqrtEigen);
                if (CallChecker.beforeDeref(npe_invocation_var844, RealMatrix.class, 391, 14622, 14642)) {
                    return CallChecker.isCalled(npe_invocation_var844, RealMatrix.class, 391, 14622, 14642).multiply(vT);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4003.methodEnd();
        }
    }

    public DecompositionSolver getSolver() {
        MethodContext _bcornu_methode_context4004 = new MethodContext(DecompositionSolver.class, 405, 14669, 15303);
        try {
            CallChecker.varInit(this, "this", 405, 14669, 15303);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 405, 14669, 15303);
            CallChecker.varInit(this.cachedVt, "cachedVt", 405, 14669, 15303);
            CallChecker.varInit(this.cachedD, "cachedD", 405, 14669, 15303);
            CallChecker.varInit(this.cachedV, "cachedV", 405, 14669, 15303);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 405, 14669, 15303);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 405, 14669, 15303);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 405, 14669, 15303);
            CallChecker.varInit(this.transformer, "transformer", 405, 14669, 15303);
            CallChecker.varInit(this.secondary, "secondary", 405, 14669, 15303);
            CallChecker.varInit(this.main, "main", 405, 14669, 15303);
            CallChecker.varInit(this.maxIter, "maxIter", 405, 14669, 15303);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 405, 14669, 15303);
            if (hasComplexEigenvalues()) {
                throw new MathUnsupportedOperationException();
            }
            return new EigenDecomposition.Solver(realEigenvalues, imagEigenvalues, eigenvectors);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DecompositionSolver) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4004.methodEnd();
        }
    }

    private void transformToTridiagonal(final RealMatrix matrix) {
        MethodContext _bcornu_methode_context4005 = new MethodContext(void.class, 559, 20445, 20840);
        try {
            CallChecker.varInit(this, "this", 559, 20445, 20840);
            CallChecker.varInit(matrix, "matrix", 559, 20445, 20840);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 559, 20445, 20840);
            CallChecker.varInit(this.cachedVt, "cachedVt", 559, 20445, 20840);
            CallChecker.varInit(this.cachedD, "cachedD", 559, 20445, 20840);
            CallChecker.varInit(this.cachedV, "cachedV", 559, 20445, 20840);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 559, 20445, 20840);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 559, 20445, 20840);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 559, 20445, 20840);
            CallChecker.varInit(this.transformer, "transformer", 559, 20445, 20840);
            CallChecker.varInit(this.secondary, "secondary", 559, 20445, 20840);
            CallChecker.varInit(this.main, "main", 559, 20445, 20840);
            CallChecker.varInit(this.maxIter, "maxIter", 559, 20445, 20840);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 559, 20445, 20840);
            transformer = new TriDiagonalTransformer(matrix);
            CallChecker.varAssign(this.transformer, "this.transformer", 561, 20678, 20726);
            if (CallChecker.beforeDeref(transformer, TriDiagonalTransformer.class, 562, 20743, 20753)) {
                transformer = CallChecker.beforeCalled(transformer, TriDiagonalTransformer.class, 562, 20743, 20753);
                main = CallChecker.isCalled(transformer, TriDiagonalTransformer.class, 562, 20743, 20753).getMainDiagonalRef();
                CallChecker.varAssign(this.main, "this.main", 562, 20736, 20775);
            }
            if (CallChecker.beforeDeref(transformer, TriDiagonalTransformer.class, 563, 20797, 20807)) {
                transformer = CallChecker.beforeCalled(transformer, TriDiagonalTransformer.class, 563, 20797, 20807);
                secondary = CallChecker.isCalled(transformer, TriDiagonalTransformer.class, 563, 20797, 20807).getSecondaryDiagonalRef();
                CallChecker.varAssign(this.secondary, "this.secondary", 563, 20785, 20834);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4005.methodEnd();
        }
    }

    private void findEigenVectors(final double[][] householderMatrix) {
        MethodContext _bcornu_methode_context4006 = new MethodContext(void.class, 572, 20847, 26972);
        try {
            CallChecker.varInit(this, "this", 572, 20847, 26972);
            CallChecker.varInit(householderMatrix, "householderMatrix", 572, 20847, 26972);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 572, 20847, 26972);
            CallChecker.varInit(this.cachedVt, "cachedVt", 572, 20847, 26972);
            CallChecker.varInit(this.cachedD, "cachedD", 572, 20847, 26972);
            CallChecker.varInit(this.cachedV, "cachedV", 572, 20847, 26972);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 572, 20847, 26972);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 572, 20847, 26972);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 572, 20847, 26972);
            CallChecker.varInit(this.transformer, "transformer", 572, 20847, 26972);
            CallChecker.varInit(this.secondary, "secondary", 572, 20847, 26972);
            CallChecker.varInit(this.main, "main", 572, 20847, 26972);
            CallChecker.varInit(this.maxIter, "maxIter", 572, 20847, 26972);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 572, 20847, 26972);
            final double[][] z = CallChecker.varInit(CallChecker.isCalled(householderMatrix, double[][].class, 573, 21132, 21148).clone(), "z", 573, 21112, 21157);
            main = CallChecker.beforeCalled(main, double[].class, 574, 21181, 21184);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.main, double[].class, 574, 21181, 21184).length)), "n", 574, 21167, 21192);
            realEigenvalues = new double[n];
            CallChecker.varAssign(this.realEigenvalues, "this.realEigenvalues", 575, 21202, 21233);
            imagEigenvalues = new double[n];
            CallChecker.varAssign(this.imagEigenvalues, "this.imagEigenvalues", 576, 21243, 21274);
            final double[] e = CallChecker.varInit(new double[n], "e", 577, 21284, 21316);
            for (int i = 0; i < (n - 1); i++) {
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 579, 21372, 21386)) {
                    if (CallChecker.beforeDeref(main, double[].class, 579, 21393, 21396)) {
                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 579, 21372, 21386);
                        main = CallChecker.beforeCalled(main, double[].class, 579, 21393, 21396);
                        CallChecker.isCalled(realEigenvalues, double[].class, 579, 21372, 21386)[i] = CallChecker.isCalled(main, double[].class, 579, 21393, 21396)[i];
                        CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 579, 21372, 21386)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 579, 21372, 21386)[i]", 579, 21372, 21400);
                    }
                }
                if (CallChecker.beforeDeref(e, double[].class, 580, 21414, 21414)) {
                    if (CallChecker.beforeDeref(secondary, double[].class, 580, 21421, 21429)) {
                        secondary = CallChecker.beforeCalled(secondary, double[].class, 580, 21421, 21429);
                        CallChecker.isCalled(e, double[].class, 580, 21414, 21414)[i] = CallChecker.isCalled(secondary, double[].class, 580, 21421, 21429)[i];
                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 580, 21414, 21414)[i], "CallChecker.isCalled(e, double[].class, 580, 21414, 21414)[i]", 580, 21414, 21433);
                    }
                }
            }
            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 582, 21453, 21467)) {
                if (CallChecker.beforeDeref(main, double[].class, 582, 21478, 21481)) {
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 582, 21453, 21467);
                    main = CallChecker.beforeCalled(main, double[].class, 582, 21478, 21481);
                    CallChecker.isCalled(realEigenvalues, double[].class, 582, 21453, 21467)[(n - 1)] = CallChecker.isCalled(main, double[].class, 582, 21478, 21481)[(n - 1)];
                    CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 582, 21453, 21467)[(n - 1)], "CallChecker.isCalled(this.realEigenvalues, double[].class, 582, 21453, 21467)[(n - 1)]", 582, 21453, 21489);
                }
            }
            if (CallChecker.beforeDeref(e, double[].class, 583, 21499, 21499)) {
                CallChecker.isCalled(e, double[].class, 583, 21499, 21499)[(n - 1)] = 0;
                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 583, 21499, 21499)[(n - 1)], "CallChecker.isCalled(e, double[].class, 583, 21499, 21499)[(n - 1)]", 583, 21499, 21511);
            }
            double maxAbsoluteValue = CallChecker.varInit(((double) (0)), "maxAbsoluteValue", 586, 21598, 21625);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 588, 21694, 21708)) {
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 588, 21694, 21708);
                    if ((FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 588, 21694, 21708)[i])) > maxAbsoluteValue) {
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 589, 21784, 21798)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 589, 21784, 21798);
                            maxAbsoluteValue = FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 589, 21784, 21798)[i]);
                            CallChecker.varAssign(maxAbsoluteValue, "maxAbsoluteValue", 589, 21752, 21803);
                        }
                    }
                }
                if (CallChecker.beforeDeref(e, double[].class, 591, 21848, 21848)) {
                    if ((FastMath.abs(CallChecker.isCalled(e, double[].class, 591, 21848, 21848)[i])) > maxAbsoluteValue) {
                        if (CallChecker.beforeDeref(e, double[].class, 592, 21924, 21924)) {
                            maxAbsoluteValue = FastMath.abs(CallChecker.isCalled(e, double[].class, 592, 21924, 21924)[i]);
                            CallChecker.varAssign(maxAbsoluteValue, "maxAbsoluteValue", 592, 21892, 21929);
                        }
                    }
                }
            }
            if (maxAbsoluteValue != 0) {
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 598, 22143, 22157)) {
                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 598, 22143, 22157);
                        if ((FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 598, 22143, 22157)[i])) <= ((Precision.EPSILON) * maxAbsoluteValue)) {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 599, 22226, 22240)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 599, 22226, 22240);
                                CallChecker.isCalled(realEigenvalues, double[].class, 599, 22226, 22240)[i] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 599, 22226, 22240)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 599, 22226, 22240)[i]", 599, 22226, 22248);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(e, double[].class, 601, 22301, 22301)) {
                        if ((FastMath.abs(CallChecker.isCalled(e, double[].class, 601, 22301, 22301)[i])) <= ((Precision.EPSILON) * maxAbsoluteValue)) {
                            if (CallChecker.beforeDeref(e, double[].class, 602, 22370, 22370)) {
                                CallChecker.isCalled(e, double[].class, 602, 22370, 22370)[i] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 602, 22370, 22370)[i], "CallChecker.isCalled(e, double[].class, 602, 22370, 22370)[i]", 602, 22370, 22376);
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                int its = CallChecker.varInit(((int) (0)), "its", 608, 22471, 22482);
                int m = CallChecker.init(int.class);
                do {
                    for (m = j; m < (n - 1); m++) {
                        CallChecker.varAssign(m, "m", 611, 22541, 22545);
                        double delta = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 612, 22614, 22628)) {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 613, 22673, 22687)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 612, 22614, 22628);
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 613, 22673, 22687);
                                delta = (FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 612, 22614, 22628)[m])) + (FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 613, 22673, 22687)[(m + 1)]));
                                CallChecker.varAssign(delta, "delta", 612, 22614, 22628);
                            }
                        }
                        if (CallChecker.beforeDeref(e, double[].class, 614, 22735, 22735)) {
                            if (((FastMath.abs(CallChecker.isCalled(e, double[].class, 614, 22735, 22735)[m])) + delta) == delta) {
                                break;
                            }
                        }
                    }
                    if (m != j) {
                        if (its == (maxIter)) {
                            throw new MaxCountExceededException(LocalizedFormats.CONVERGENCE_FAILED, maxIter);
                        }
                        its++;
                        double q = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 624, 23152, 23166)) {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 624, 23177, 23191)) {
                                if (CallChecker.beforeDeref(e, double[].class, 624, 23204, 23204)) {
                                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 624, 23152, 23166);
                                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 624, 23177, 23191);
                                    q = ((CallChecker.isCalled(realEigenvalues, double[].class, 624, 23152, 23166)[(j + 1)]) - (CallChecker.isCalled(realEigenvalues, double[].class, 624, 23177, 23191)[j])) / (2 * (CallChecker.isCalled(e, double[].class, 624, 23204, 23204)[j]));
                                    CallChecker.varAssign(q, "q", 624, 23152, 23166);
                                }
                            }
                        }
                        double t = CallChecker.varInit(((double) (FastMath.sqrt((1 + (q * q))))), "t", 625, 23231, 23266);
                        if (q < 0.0) {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 627, 23331, 23345)) {
                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 627, 23352, 23366)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 627, 23373, 23373)) {
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 627, 23331, 23345);
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 627, 23352, 23366);
                                        q = ((CallChecker.isCalled(realEigenvalues, double[].class, 627, 23331, 23345)[m]) - (CallChecker.isCalled(realEigenvalues, double[].class, 627, 23352, 23366)[j])) + ((CallChecker.isCalled(e, double[].class, 627, 23373, 23373)[j]) / (q - t));
                                        CallChecker.varAssign(q, "q", 627, 23327, 23387);
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 629, 23446, 23460)) {
                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 629, 23467, 23481)) {
                                    if (CallChecker.beforeDeref(e, double[].class, 629, 23488, 23488)) {
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 629, 23446, 23460);
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 629, 23467, 23481);
                                        q = ((CallChecker.isCalled(realEigenvalues, double[].class, 629, 23446, 23460)[m]) - (CallChecker.isCalled(realEigenvalues, double[].class, 629, 23467, 23481)[j])) + ((CallChecker.isCalled(e, double[].class, 629, 23488, 23488)[j]) / (q + t));
                                        CallChecker.varAssign(q, "q", 629, 23442, 23502);
                                    }
                                }
                            }
                        }
                        double u = CallChecker.varInit(((double) (0.0)), "u", 631, 23546, 23560);
                        double s = CallChecker.varInit(((double) (1.0)), "s", 632, 23582, 23596);
                        double c = CallChecker.varInit(((double) (1.0)), "c", 633, 23618, 23632);
                        int i = CallChecker.init(int.class);
                        for (i = m - 1; i >= j; i--) {
                            CallChecker.varAssign(i, "i", 635, 23686, 23694);
                            double p = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(e, double[].class, 636, 23751, 23751)) {
                                p = s * (CallChecker.isCalled(e, double[].class, 636, 23751, 23751)[i]);
                                CallChecker.varAssign(p, "p", 636, 23751, 23751);
                            }
                            double h = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(e, double[].class, 637, 23796, 23796)) {
                                h = c * (CallChecker.isCalled(e, double[].class, 637, 23796, 23796)[i]);
                                CallChecker.varAssign(h, "h", 637, 23796, 23796);
                            }
                            if ((FastMath.abs(p)) >= (FastMath.abs(q))) {
                                c = q / p;
                                CallChecker.varAssign(c, "c", 639, 23896, 23905);
                                t = FastMath.sqrt(((c * c) + 1.0));
                                CallChecker.varAssign(t, "t", 640, 23935, 23965);
                                if (CallChecker.beforeDeref(e, double[].class, 641, 23995, 23995)) {
                                    CallChecker.isCalled(e, double[].class, 641, 23995, 23995)[(i + 1)] = p * t;
                                    CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 641, 23995, 23995)[(i + 1)], "CallChecker.isCalled(e, double[].class, 641, 23995, 23995)[(i + 1)]", 641, 23995, 24011);
                                }
                                s = 1.0 / t;
                                CallChecker.varAssign(s, "s", 642, 24041, 24052);
                                c = c * s;
                                CallChecker.varAssign(c, "c", 643, 24082, 24091);
                            }else {
                                s = p / q;
                                CallChecker.varAssign(s, "s", 645, 24154, 24163);
                                t = FastMath.sqrt(((s * s) + 1.0));
                                CallChecker.varAssign(t, "t", 646, 24193, 24223);
                                if (CallChecker.beforeDeref(e, double[].class, 647, 24253, 24253)) {
                                    CallChecker.isCalled(e, double[].class, 647, 24253, 24253)[(i + 1)] = q * t;
                                    CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 647, 24253, 24253)[(i + 1)], "CallChecker.isCalled(e, double[].class, 647, 24253, 24253)[(i + 1)]", 647, 24253, 24269);
                                }
                                c = 1.0 / t;
                                CallChecker.varAssign(c, "c", 648, 24299, 24310);
                                s = s * c;
                                CallChecker.varAssign(s, "s", 649, 24340, 24349);
                            }
                            if (CallChecker.beforeDeref(e, double[].class, 651, 24405, 24405)) {
                                if ((CallChecker.isCalled(e, double[].class, 651, 24405, 24405)[(i + 1)]) == 0.0) {
                                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 652, 24452, 24466)) {
                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 652, 24452, 24466);
                                        CallChecker.isCalled(realEigenvalues, double[].class, 652, 24452, 24466)[(i + 1)] -= u;
                                        CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 652, 24452, 24466)[(i + 1)], "CallChecker.isCalled(this.realEigenvalues, double[].class, 652, 24452, 24466)[(i + 1)]", 652, 24452, 24479);
                                    }
                                    if (CallChecker.beforeDeref(e, double[].class, 653, 24509, 24509)) {
                                        CallChecker.isCalled(e, double[].class, 653, 24509, 24509)[m] = 0.0;
                                        CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 653, 24509, 24509)[m], "CallChecker.isCalled(e, double[].class, 653, 24509, 24509)[m]", 653, 24509, 24519);
                                    }
                                    break;
                                }
                            }
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 656, 24610, 24624)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 656, 24610, 24624);
                                q = (CallChecker.isCalled(realEigenvalues, double[].class, 656, 24610, 24624)[(i + 1)]) - u;
                                CallChecker.varAssign(q, "q", 656, 24606, 24636);
                            }
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 657, 24667, 24681)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 657, 24667, 24681);
                                t = (((CallChecker.isCalled(realEigenvalues, double[].class, 657, 24667, 24681)[i]) - q) * s) + ((2.0 * c) * h);
                                CallChecker.varAssign(t, "t", 657, 24662, 24708);
                            }
                            u = s * t;
                            CallChecker.varAssign(u, "u", 658, 24734, 24743);
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 659, 24769, 24783)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 659, 24769, 24783);
                                CallChecker.isCalled(realEigenvalues, double[].class, 659, 24769, 24783)[(i + 1)] = q + u;
                                CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 659, 24769, 24783)[(i + 1)], "CallChecker.isCalled(this.realEigenvalues, double[].class, 659, 24769, 24783)[(i + 1)]", 659, 24769, 24799);
                            }
                            q = (c * t) - h;
                            CallChecker.varAssign(q, "q", 660, 24825, 24838);
                            for (int ia = 0; ia < n; ia++) {
                                if (CallChecker.beforeDeref(z, double[][].class, 662, 24929, 24929)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 662, 24929, 24929)[ia], double[].class, 662, 24929, 24933)) {
                                        CallChecker.isCalled(z, double[][].class, 662, 24929, 24929)[ia] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 662, 24929, 24929)[ia], double[].class, 662, 24929, 24933);
                                        p = CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 662, 24929, 24929)[ia], double[].class, 662, 24929, 24933)[(i + 1)];
                                        CallChecker.varAssign(p, "p", 662, 24925, 24941);
                                    }
                                }
                                if (CallChecker.beforeDeref(z, double[][].class, 663, 24971, 24971)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia], double[].class, 663, 24971, 24975)) {
                                        if (CallChecker.beforeDeref(z, double[][].class, 663, 24990, 24990)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 663, 24990, 24990)[ia], double[].class, 663, 24990, 24994)) {
                                                CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia], double[].class, 663, 24971, 24975);
                                                CallChecker.isCalled(z, double[][].class, 663, 24990, 24990)[ia] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 663, 24990, 24990)[ia], double[].class, 663, 24990, 24994);
                                                CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia], double[].class, 663, 24971, 24975)[(i + 1)] = (s * (CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 663, 24990, 24990)[ia], double[].class, 663, 24990, 24994)[i])) + (c * p);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia], double[].class, 663, 24971, 24975)[(i + 1)], "CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 663, 24971, 24971)[ia], double[].class, 663, 24971, 24975)[(i + 1)]", 663, 24971, 25006);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(z, double[][].class, 664, 25036, 25036)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia], double[].class, 664, 25036, 25040)) {
                                        if (CallChecker.beforeDeref(z, double[][].class, 664, 25051, 25051)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 664, 25051, 25051)[ia], double[].class, 664, 25051, 25055)) {
                                                CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia], double[].class, 664, 25036, 25040);
                                                CallChecker.isCalled(z, double[][].class, 664, 25051, 25051)[ia] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 664, 25051, 25051)[ia], double[].class, 664, 25051, 25055);
                                                CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia], double[].class, 664, 25036, 25040)[i] = (c * (CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 664, 25051, 25051)[ia], double[].class, 664, 25051, 25055)[i])) - (s * p);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia], double[].class, 664, 25036, 25040)[i], "CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 664, 25036, 25036)[ia], double[].class, 664, 25036, 25040)[i]", 664, 25036, 25067);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if ((t == 0.0) && (i >= j)) {
                            continue;
                        }
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 670, 25239, 25253)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 670, 25239, 25253);
                            CallChecker.isCalled(realEigenvalues, double[].class, 670, 25239, 25253)[j] -= u;
                            CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 670, 25239, 25253)[j], "CallChecker.isCalled(this.realEigenvalues, double[].class, 670, 25239, 25253)[j]", 670, 25239, 25262);
                        }
                        if (CallChecker.beforeDeref(e, double[].class, 671, 25284, 25284)) {
                            CallChecker.isCalled(e, double[].class, 671, 25284, 25284)[j] = q;
                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 671, 25284, 25284)[j], "CallChecker.isCalled(e, double[].class, 671, 25284, 25284)[j]", 671, 25284, 25292);
                        }
                        if (CallChecker.beforeDeref(e, double[].class, 672, 25314, 25314)) {
                            CallChecker.isCalled(e, double[].class, 672, 25314, 25314)[m] = 0.0;
                            CallChecker.varAssign(CallChecker.isCalled(e, double[].class, 672, 25314, 25314)[m], "CallChecker.isCalled(e, double[].class, 672, 25314, 25314)[m]", 672, 25314, 25324);
                        }
                    }
                } while (m != j );
            }
            for (int i = 0; i < n; i++) {
                int k = CallChecker.varInit(((int) (i)), "k", 679, 25499, 25508);
                double p = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 680, 25533, 25547)) {
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 680, 25533, 25547);
                    p = CallChecker.isCalled(realEigenvalues, double[].class, 680, 25533, 25547)[i];
                    CallChecker.varAssign(p, "p", 680, 25533, 25547);
                }
                for (int j = i + 1; j < n; j++) {
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 682, 25619, 25633)) {
                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 682, 25619, 25633);
                        if ((CallChecker.isCalled(realEigenvalues, double[].class, 682, 25619, 25633)[j]) > p) {
                            k = j;
                            CallChecker.varAssign(k, "k", 683, 25665, 25670);
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 684, 25696, 25710)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 684, 25696, 25710);
                                p = CallChecker.isCalled(realEigenvalues, double[].class, 684, 25696, 25710)[j];
                                CallChecker.varAssign(p, "p", 684, 25692, 25714);
                            }
                        }
                    }
                }
                if (k != i) {
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 688, 25790, 25804)) {
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 688, 25811, 25825)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 688, 25790, 25804);
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 688, 25811, 25825);
                            CallChecker.isCalled(realEigenvalues, double[].class, 688, 25790, 25804)[k] = CallChecker.isCalled(realEigenvalues, double[].class, 688, 25811, 25825)[i];
                            CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 688, 25790, 25804)[k], "CallChecker.isCalled(this.realEigenvalues, double[].class, 688, 25790, 25804)[k]", 688, 25790, 25829);
                        }
                    }
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 689, 25847, 25861)) {
                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 689, 25847, 25861);
                        CallChecker.isCalled(realEigenvalues, double[].class, 689, 25847, 25861)[i] = p;
                        CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 689, 25847, 25861)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 689, 25847, 25861)[i]", 689, 25847, 25869);
                    }
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(z, double[][].class, 691, 25941, 25941)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 691, 25941, 25941)[j], double[].class, 691, 25941, 25944)) {
                                CallChecker.isCalled(z, double[][].class, 691, 25941, 25941)[j] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 691, 25941, 25941)[j], double[].class, 691, 25941, 25944);
                                p = CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 691, 25941, 25941)[j], double[].class, 691, 25941, 25944)[i];
                                CallChecker.varAssign(p, "p", 691, 25937, 25948);
                            }
                        }
                        if (CallChecker.beforeDeref(z, double[][].class, 692, 25970, 25970)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j], double[].class, 692, 25970, 25973)) {
                                if (CallChecker.beforeDeref(z, double[][].class, 692, 25980, 25980)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 692, 25980, 25980)[j], double[].class, 692, 25980, 25983)) {
                                        CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j], double[].class, 692, 25970, 25973);
                                        CallChecker.isCalled(z, double[][].class, 692, 25980, 25980)[j] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 692, 25980, 25980)[j], double[].class, 692, 25980, 25983);
                                        CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j], double[].class, 692, 25970, 25973)[i] = CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 692, 25980, 25980)[j], double[].class, 692, 25980, 25983)[k];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j], double[].class, 692, 25970, 25973)[i], "CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 692, 25970, 25970)[j], double[].class, 692, 25970, 25973)[i]", 692, 25970, 25987);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(z, double[][].class, 693, 26009, 26009)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j], double[].class, 693, 26009, 26012)) {
                                CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j], double[].class, 693, 26009, 26012);
                                CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j], double[].class, 693, 26009, 26012)[k] = p;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j], double[].class, 693, 26009, 26012)[k], "CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 693, 26009, 26009)[j], double[].class, 693, 26009, 26012)[k]", 693, 26009, 26020);
                            }
                        }
                    }
                }
            }
            maxAbsoluteValue = 0;
            CallChecker.varAssign(maxAbsoluteValue, "maxAbsoluteValue", 699, 26136, 26156);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 701, 26225, 26239)) {
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 701, 26225, 26239);
                    if ((FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 701, 26225, 26239)[i])) > maxAbsoluteValue) {
                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 702, 26313, 26327)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 702, 26313, 26327);
                            maxAbsoluteValue = FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 702, 26313, 26327)[i]);
                            CallChecker.varAssign(maxAbsoluteValue, "maxAbsoluteValue", 702, 26283, 26332);
                        }
                    }
                }
            }
            if (maxAbsoluteValue != 0.0) {
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(realEigenvalues, double[].class, 708, 26535, 26549)) {
                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 708, 26535, 26549);
                        if ((FastMath.abs(CallChecker.isCalled(realEigenvalues, double[].class, 708, 26535, 26549)[i])) < ((Precision.EPSILON) * maxAbsoluteValue)) {
                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 709, 26617, 26631)) {
                                realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 709, 26617, 26631);
                                CallChecker.isCalled(realEigenvalues, double[].class, 709, 26617, 26631)[i] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 709, 26617, 26631)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 709, 26617, 26631)[i]", 709, 26617, 26639);
                            }
                        }
                    }
                }
            }
            eigenvectors = new ArrayRealVector[n];
            CallChecker.varAssign(this.eigenvectors, "this.eigenvectors", 713, 26691, 26728);
            final double[] tmp = CallChecker.varInit(new double[n], "tmp", 714, 26738, 26772);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(tmp, double[].class, 717, 26870, 26872)) {
                        if (CallChecker.beforeDeref(z, double[][].class, 717, 26879, 26879)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(z, double[][].class, 717, 26879, 26879)[j], double[].class, 717, 26879, 26882)) {
                                CallChecker.isCalled(z, double[][].class, 717, 26879, 26879)[j] = CallChecker.beforeCalled(CallChecker.isCalled(z, double[][].class, 717, 26879, 26879)[j], double[].class, 717, 26879, 26882);
                                CallChecker.isCalled(tmp, double[].class, 717, 26870, 26872)[j] = CallChecker.isCalled(CallChecker.isCalled(z, double[][].class, 717, 26879, 26879)[j], double[].class, 717, 26879, 26882)[i];
                                CallChecker.varAssign(CallChecker.isCalled(tmp, double[].class, 717, 26870, 26872)[j], "CallChecker.isCalled(tmp, double[].class, 717, 26870, 26872)[j]", 717, 26870, 26886);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(eigenvectors, ArrayRealVector[].class, 719, 26914, 26925)) {
                    eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 719, 26914, 26925);
                    CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 719, 26914, 26925)[i] = new ArrayRealVector(tmp);
                    CallChecker.varAssign(CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 719, 26914, 26925)[i], "CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 719, 26914, 26925)[i]", 719, 26914, 26956);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4006.methodEnd();
        }
    }

    private SchurTransformer transformToSchur(final RealMatrix matrix) {
        MethodContext _bcornu_methode_context4007 = new MethodContext(SchurTransformer.class, 729, 26979, 28228);
        try {
            CallChecker.varInit(this, "this", 729, 26979, 28228);
            CallChecker.varInit(matrix, "matrix", 729, 26979, 28228);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 729, 26979, 28228);
            CallChecker.varInit(this.cachedVt, "cachedVt", 729, 26979, 28228);
            CallChecker.varInit(this.cachedD, "cachedD", 729, 26979, 28228);
            CallChecker.varInit(this.cachedV, "cachedV", 729, 26979, 28228);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 729, 26979, 28228);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 729, 26979, 28228);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 729, 26979, 28228);
            CallChecker.varInit(this.transformer, "transformer", 729, 26979, 28228);
            CallChecker.varInit(this.secondary, "secondary", 729, 26979, 28228);
            CallChecker.varInit(this.main, "main", 729, 26979, 28228);
            CallChecker.varInit(this.maxIter, "maxIter", 729, 26979, 28228);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 729, 26979, 28228);
            final SchurTransformer schurTransform = CallChecker.varInit(new SchurTransformer(matrix), "schurTransform", 730, 27271, 27339);
            final double[][] matT = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(schurTransform, SchurTransformer.class, 731, 27373, 27386).getT(), RealMatrix.class, 731, 27373, 27393).getData(), "matT", 731, 27349, 27404);
            if (CallChecker.beforeDeref(matT, double[][].class, 733, 27444, 27447)) {
                realEigenvalues = new double[CallChecker.isCalled(matT, double[][].class, 733, 27444, 27447).length];
                CallChecker.varAssign(this.realEigenvalues, "this.realEigenvalues", 733, 27415, 27456);
            }
            if (CallChecker.beforeDeref(matT, double[][].class, 734, 27495, 27498)) {
                imagEigenvalues = new double[CallChecker.isCalled(matT, double[][].class, 734, 27495, 27498).length];
                CallChecker.varAssign(this.imagEigenvalues, "this.imagEigenvalues", 734, 27466, 27507);
            }
            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 736, 27538, 27552);
            for (int i = 0; i < (CallChecker.isCalled(realEigenvalues, double[].class, 736, 27538, 27552).length); i++) {
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 737, 27591, 27605)) {
                    if (CallChecker.beforeDeref(matT, double[][].class, 738, 27655, 27658)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matT, double[][].class, 738, 27655, 27658)[(i + 1)], double[].class, 738, 27655, 27665)) {
                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 737, 27591, 27605);
                            CallChecker.isCalled(matT, double[][].class, 738, 27655, 27658)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 738, 27655, 27658)[(i + 1)], double[].class, 738, 27655, 27665);
                            if ((i == ((CallChecker.isCalled(realEigenvalues, double[].class, 737, 27591, 27605).length) - 1)) || (Precision.equals(CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 738, 27655, 27658)[(i + 1)], double[].class, 738, 27655, 27665)[i], 0.0, EigenDecomposition.EPSILON))) {
                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 739, 27704, 27718)) {
                                    if (CallChecker.beforeDeref(matT, double[][].class, 739, 27725, 27728)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matT, double[][].class, 739, 27725, 27728)[i], double[].class, 739, 27725, 27731)) {
                                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 739, 27704, 27718);
                                            CallChecker.isCalled(matT, double[][].class, 739, 27725, 27728)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 739, 27725, 27728)[i], double[].class, 739, 27725, 27731);
                                            CallChecker.isCalled(realEigenvalues, double[].class, 739, 27704, 27718)[i] = CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 739, 27725, 27728)[i], double[].class, 739, 27725, 27731)[i];
                                            CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 739, 27704, 27718)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 739, 27704, 27718)[i]", 739, 27704, 27735);
                                        }
                                    }
                                }
                            }else {
                                CallChecker.isCalled(matT, double[][].class, 741, 27791, 27794)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 741, 27791, 27794)[(i + 1)], double[].class, 741, 27791, 27801);
                                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 741, 27791, 27794)[(i + 1)], double[].class, 741, 27791, 27801)[(i + 1)])), "x", 741, 27774, 27809);
                                CallChecker.isCalled(matT, double[][].class, 742, 27851, 27854)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 742, 27851, 27854)[i], double[].class, 742, 27851, 27857);
                                final double p = CallChecker.varInit(((double) (0.5 * ((CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 742, 27851, 27854)[i], double[].class, 742, 27851, 27857)[i]) - x))), "p", 742, 27827, 27866);
                                CallChecker.isCalled(matT, double[][].class, 743, 27936, 27939)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 743, 27936, 27939)[(i + 1)], double[].class, 743, 27936, 27946);
                                CallChecker.isCalled(matT, double[][].class, 743, 27953, 27956)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matT, double[][].class, 743, 27953, 27956)[i], double[].class, 743, 27953, 27959);
                                final double z = CallChecker.varInit(((double) (FastMath.sqrt(FastMath.abs(((p * p) + ((CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 743, 27936, 27939)[(i + 1)], double[].class, 743, 27936, 27946)[i]) * (CallChecker.isCalled(CallChecker.isCalled(matT, double[][].class, 743, 27953, 27956)[i], double[].class, 743, 27953, 27959)[(i + 1)]))))))), "z", 743, 27884, 27969);
                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 744, 27987, 28001)) {
                                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 744, 27987, 28001);
                                    CallChecker.isCalled(realEigenvalues, double[].class, 744, 27987, 28001)[i] = x + p;
                                    CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 744, 27987, 28001)[i], "CallChecker.isCalled(this.realEigenvalues, double[].class, 744, 27987, 28001)[i]", 744, 27987, 28013);
                                }
                                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 745, 28031, 28045)) {
                                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 745, 28031, 28045);
                                    CallChecker.isCalled(imagEigenvalues, double[].class, 745, 28031, 28045)[i] = z;
                                    CallChecker.varAssign(CallChecker.isCalled(this.imagEigenvalues, double[].class, 745, 28031, 28045)[i], "CallChecker.isCalled(this.imagEigenvalues, double[].class, 745, 28031, 28045)[i]", 745, 28031, 28053);
                                }
                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 746, 28071, 28085)) {
                                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 746, 28071, 28085);
                                    CallChecker.isCalled(realEigenvalues, double[].class, 746, 28071, 28085)[(i + 1)] = x + p;
                                    CallChecker.varAssign(CallChecker.isCalled(this.realEigenvalues, double[].class, 746, 28071, 28085)[(i + 1)], "CallChecker.isCalled(this.realEigenvalues, double[].class, 746, 28071, 28085)[(i + 1)]", 746, 28071, 28101);
                                }
                                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 747, 28119, 28133)) {
                                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 747, 28119, 28133);
                                    CallChecker.isCalled(imagEigenvalues, double[].class, 747, 28119, 28133)[(i + 1)] = -z;
                                    CallChecker.varAssign(CallChecker.isCalled(this.imagEigenvalues, double[].class, 747, 28119, 28133)[(i + 1)], "CallChecker.isCalled(this.imagEigenvalues, double[].class, 747, 28119, 28133)[(i + 1)]", 747, 28119, 28146);
                                }
                                i++;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return schurTransform;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SchurTransformer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4007.methodEnd();
        }
    }

    private Complex cdiv(final double xr, final double xi, final double yr, final double yi) {
        MethodContext _bcornu_methode_context4008 = new MethodContext(Complex.class, 763, 28235, 28739);
        try {
            CallChecker.varInit(this, "this", 763, 28235, 28739);
            CallChecker.varInit(yi, "yi", 763, 28235, 28739);
            CallChecker.varInit(yr, "yr", 763, 28235, 28739);
            CallChecker.varInit(xi, "xi", 763, 28235, 28739);
            CallChecker.varInit(xr, "xr", 763, 28235, 28739);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 763, 28235, 28739);
            CallChecker.varInit(this.cachedVt, "cachedVt", 763, 28235, 28739);
            CallChecker.varInit(this.cachedD, "cachedD", 763, 28235, 28739);
            CallChecker.varInit(this.cachedV, "cachedV", 763, 28235, 28739);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 763, 28235, 28739);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 763, 28235, 28739);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 763, 28235, 28739);
            CallChecker.varInit(this.transformer, "transformer", 763, 28235, 28739);
            CallChecker.varInit(this.secondary, "secondary", 763, 28235, 28739);
            CallChecker.varInit(this.main, "main", 763, 28235, 28739);
            CallChecker.varInit(this.maxIter, "maxIter", 763, 28235, 28739);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 763, 28235, 28739);
            if (CallChecker.beforeDeref(new Complex(xr, xi), Complex.class, 765, 28686, 28704)) {
                return CallChecker.isCalled(new Complex(xr, xi), Complex.class, 765, 28686, 28704).divide(new Complex(yr, yi));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4008.methodEnd();
        }
    }

    private void findEigenVectorsFromSchur(final SchurTransformer schur) throws MathArithmeticException {
        MethodContext _bcornu_methode_context4009 = new MethodContext(void.class, 774, 28746, 37392);
        try {
            CallChecker.varInit(this, "this", 774, 28746, 37392);
            CallChecker.varInit(schur, "schur", 774, 28746, 37392);
            CallChecker.varInit(this.isSymmetric, "isSymmetric", 774, 28746, 37392);
            CallChecker.varInit(this.cachedVt, "cachedVt", 774, 28746, 37392);
            CallChecker.varInit(this.cachedD, "cachedD", 774, 28746, 37392);
            CallChecker.varInit(this.cachedV, "cachedV", 774, 28746, 37392);
            CallChecker.varInit(this.eigenvectors, "eigenvectors", 774, 28746, 37392);
            CallChecker.varInit(this.imagEigenvalues, "imagEigenvalues", 774, 28746, 37392);
            CallChecker.varInit(this.realEigenvalues, "realEigenvalues", 774, 28746, 37392);
            CallChecker.varInit(this.transformer, "transformer", 774, 28746, 37392);
            CallChecker.varInit(this.secondary, "secondary", 774, 28746, 37392);
            CallChecker.varInit(this.main, "main", 774, 28746, 37392);
            CallChecker.varInit(this.maxIter, "maxIter", 774, 28746, 37392);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.linear.EigenDecomposition.EPSILON", 774, 28746, 37392);
            final double[][] matrixT = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(schur, SchurTransformer.class, 776, 29115, 29119).getT(), RealMatrix.class, 776, 29115, 29126).getData(), "matrixT", 776, 29088, 29137);
            final double[][] matrixP = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(schur, SchurTransformer.class, 777, 29174, 29178).getP(), RealMatrix.class, 777, 29174, 29185).getData(), "matrixP", 777, 29147, 29196);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(matrixT, double[][].class, 779, 29221, 29227).length)), "n", 779, 29207, 29235);
            double norm = CallChecker.varInit(((double) (0.0)), "norm", 782, 29277, 29294);
            for (int i = 0; i < n; i++) {
                for (int j = FastMath.max((i - 1), 0); j < n; j++) {
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 785, 29437, 29443)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 785, 29437, 29443)[i], double[].class, 785, 29437, 29446)) {
                            CallChecker.isCalled(matrixT, double[][].class, 785, 29437, 29443)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 785, 29437, 29443)[i], double[].class, 785, 29437, 29446);
                            norm = norm + (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 785, 29437, 29443)[i], double[].class, 785, 29437, 29446)[j]));
                            CallChecker.varAssign(norm, "norm", 785, 29410, 29451);
                        }
                    }
                }
            }
            if (Precision.equals(norm, 0.0, EigenDecomposition.EPSILON)) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            double r = CallChecker.varInit(((double) (0.0)), "r", 796, 29743, 29757);
            double s = CallChecker.varInit(((double) (0.0)), "s", 797, 29767, 29781);
            double z = CallChecker.varInit(((double) (0.0)), "z", 798, 29791, 29805);
            for (int idx = n - 1; idx >= 0; idx--) {
                double p = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 801, 29880, 29894)) {
                    realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 801, 29880, 29894);
                    p = CallChecker.isCalled(realEigenvalues, double[].class, 801, 29880, 29894)[idx];
                    CallChecker.varAssign(p, "p", 801, 29880, 29894);
                }
                double q = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 802, 29925, 29939)) {
                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 802, 29925, 29939);
                    q = CallChecker.isCalled(imagEigenvalues, double[].class, 802, 29925, 29939)[idx];
                    CallChecker.varAssign(q, "q", 802, 29925, 29939);
                }
                if (Precision.equals(q, 0.0)) {
                    int l = CallChecker.varInit(((int) (idx)), "l", 806, 30039, 30050);
                    if (CallChecker.beforeDeref(matrixT, double[][].class, 807, 30068, 30074)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx], double[].class, 807, 30068, 30079)) {
                            CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx], double[].class, 807, 30068, 30079);
                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx], double[].class, 807, 30068, 30079)[idx] = 1.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx], double[].class, 807, 30068, 30079)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 807, 30068, 30074)[idx], double[].class, 807, 30068, 30079)[idx]", 807, 30068, 30091);
                        }
                    }
                    for (int i = idx - 1; i >= 0; i--) {
                        double w = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 809, 30177, 30183)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 809, 30177, 30183)[i], double[].class, 809, 30177, 30186)) {
                                CallChecker.isCalled(matrixT, double[][].class, 809, 30177, 30183)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 809, 30177, 30183)[i], double[].class, 809, 30177, 30186);
                                w = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 809, 30177, 30183)[i], double[].class, 809, 30177, 30186)[i]) - p;
                                CallChecker.varAssign(w, "w", 809, 30177, 30183);
                            }
                        }
                        r = 0.0;
                        CallChecker.varAssign(r, "r", 810, 30216, 30223);
                        for (int j = l; j <= idx; j++) {
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 812, 30310, 30316)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 812, 30310, 30316)[i], double[].class, 812, 30310, 30319)) {
                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 812, 30326, 30332)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 812, 30326, 30332)[j], double[].class, 812, 30326, 30335)) {
                                            CallChecker.isCalled(matrixT, double[][].class, 812, 30310, 30316)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 812, 30310, 30316)[i], double[].class, 812, 30310, 30319);
                                            CallChecker.isCalled(matrixT, double[][].class, 812, 30326, 30332)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 812, 30326, 30332)[j], double[].class, 812, 30326, 30335);
                                            r = r + ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 812, 30310, 30316)[i], double[].class, 812, 30310, 30319)[j]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 812, 30326, 30332)[j], double[].class, 812, 30326, 30335)[idx]));
                                            CallChecker.varAssign(r, "r", 812, 30302, 30341);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 814, 30409, 30423)) {
                            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 814, 30409, 30423);
                            if ((Precision.compareTo(CallChecker.isCalled(imagEigenvalues, double[].class, 814, 30409, 30423)[i], 0.0, EigenDecomposition.EPSILON)) < 0.0) {
                                z = w;
                                CallChecker.varAssign(z, "z", 815, 30476, 30481);
                                s = r;
                                CallChecker.varAssign(s, "s", 816, 30507, 30512);
                            }else {
                                l = i;
                                CallChecker.varAssign(l, "l", 818, 30567, 30572);
                                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 819, 30619, 30633)) {
                                    imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 819, 30619, 30633);
                                    if (Precision.equals(CallChecker.isCalled(imagEigenvalues, double[].class, 819, 30619, 30633)[i], 0.0)) {
                                        if (w != 0.0) {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 821, 30723, 30729)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i], double[].class, 821, 30723, 30732)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i], double[].class, 821, 30723, 30732);
                                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i], double[].class, 821, 30723, 30732)[idx] = (-r) / w;
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i], double[].class, 821, 30723, 30732)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 821, 30723, 30729)[i], double[].class, 821, 30723, 30732)[idx]", 821, 30723, 30747);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 823, 30818, 30824)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i], double[].class, 823, 30818, 30827)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i], double[].class, 823, 30818, 30827);
                                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i], double[].class, 823, 30818, 30827)[idx] = (-r) / ((Precision.EPSILON) * norm);
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i], double[].class, 823, 30818, 30827)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 823, 30818, 30824)[i], double[].class, 823, 30818, 30827)[idx]", 823, 30818, 30867);
                                                }
                                            }
                                        }
                                    }else {
                                        double x = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 827, 31023, 31029)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 827, 31023, 31029)[i], double[].class, 827, 31023, 31032)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 827, 31023, 31029)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 827, 31023, 31029)[i], double[].class, 827, 31023, 31032);
                                                x = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 827, 31023, 31029)[i], double[].class, 827, 31023, 31032)[(i + 1)];
                                                CallChecker.varAssign(x, "x", 827, 31023, 31029);
                                            }
                                        }
                                        double y = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 828, 31081, 31087)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 828, 31081, 31087)[(i + 1)], double[].class, 828, 31081, 31094)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 828, 31081, 31087)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 828, 31081, 31087)[(i + 1)], double[].class, 828, 31081, 31094);
                                                y = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 828, 31081, 31087)[(i + 1)], double[].class, 828, 31081, 31094)[i];
                                                CallChecker.varAssign(y, "y", 828, 31081, 31087);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(realEigenvalues, double[].class, 829, 31133, 31147)) {
                                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 829, 31160, 31174)) {
                                                if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 830, 31218, 31232)) {
                                                    if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 830, 31239, 31253)) {
                                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 829, 31133, 31147);
                                                        realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 829, 31160, 31174);
                                                        imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 830, 31218, 31232);
                                                        imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 830, 31239, 31253);
                                                        q = (((CallChecker.isCalled(realEigenvalues, double[].class, 829, 31133, 31147)[i]) - p) * ((CallChecker.isCalled(realEigenvalues, double[].class, 829, 31160, 31174)[i]) - p)) + ((CallChecker.isCalled(imagEigenvalues, double[].class, 830, 31218, 31232)[i]) * (CallChecker.isCalled(imagEigenvalues, double[].class, 830, 31239, 31253)[i]));
                                                        CallChecker.varAssign(q, "q", 829, 31128, 31257);
                                                    }
                                                }
                                            }
                                        }
                                        double t = CallChecker.varInit(((double) (((x * s) - (z * r)) / q)), "t", 831, 31287, 31317);
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 832, 31347, 31353)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i], double[].class, 832, 31347, 31356)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i], double[].class, 832, 31347, 31356);
                                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i], double[].class, 832, 31347, 31356)[idx] = t;
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i], double[].class, 832, 31347, 31356)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 832, 31347, 31353)[i], double[].class, 832, 31347, 31356)[idx]", 832, 31347, 31366);
                                            }
                                        }
                                        if ((FastMath.abs(x)) > (FastMath.abs(z))) {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 834, 31469, 31475)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)], double[].class, 834, 31469, 31482)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)], double[].class, 834, 31469, 31482);
                                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)], double[].class, 834, 31469, 31482)[idx] = ((-r) - (w * t)) / x;
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)], double[].class, 834, 31469, 31482)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 834, 31469, 31475)[(i + 1)], double[].class, 834, 31469, 31482)[idx]", 834, 31469, 31507);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 836, 31578, 31584)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)], double[].class, 836, 31578, 31591)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)], double[].class, 836, 31578, 31591);
                                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)], double[].class, 836, 31578, 31591)[idx] = ((-s) - (y * t)) / z;
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)], double[].class, 836, 31578, 31591)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 836, 31578, 31584)[(i + 1)], double[].class, 836, 31578, 31591)[idx]", 836, 31578, 31616);
                                                }
                                            }
                                        }
                                    }
                                }
                                double t = CallChecker.init(double.class);
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 841, 31767, 31773)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 841, 31767, 31773)[i], double[].class, 841, 31767, 31776)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 841, 31767, 31773)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 841, 31767, 31773)[i], double[].class, 841, 31767, 31776);
                                        t = FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 841, 31767, 31773)[i], double[].class, 841, 31767, 31776)[idx]);
                                        CallChecker.varAssign(t, "t", 841, 31767, 31773);
                                    }
                                }
                                if ((((Precision.EPSILON) * t) * t) > 1) {
                                    for (int j = i; j <= idx; j++) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 844, 31941, 31947)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j], double[].class, 844, 31941, 31950)) {
                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 844, 31959, 31965)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 844, 31959, 31965)[j], double[].class, 844, 31959, 31968)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j], double[].class, 844, 31941, 31950);
                                                        CallChecker.isCalled(matrixT, double[][].class, 844, 31959, 31965)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31959, 31965)[j], double[].class, 844, 31959, 31968);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j], double[].class, 844, 31941, 31950)[idx] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31959, 31965)[j], double[].class, 844, 31959, 31968)[idx]) / t;
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j], double[].class, 844, 31941, 31950)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 844, 31941, 31947)[j], double[].class, 844, 31941, 31950)[idx]", 844, 31941, 31978);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else
                    if (q < 0.0) {
                        int l = CallChecker.varInit(((int) (idx - 1)), "l", 851, 32160, 32175);
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 854, 32286, 32292)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 854, 32286, 32292)[idx], double[].class, 854, 32286, 32297)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 854, 32324, 32330)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 854, 32324, 32330)[(idx - 1)], double[].class, 854, 32324, 32339)) {
                                        CallChecker.isCalled(matrixT, double[][].class, 854, 32286, 32292)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 854, 32286, 32292)[idx], double[].class, 854, 32286, 32297);
                                        CallChecker.isCalled(matrixT, double[][].class, 854, 32324, 32330)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 854, 32324, 32330)[(idx - 1)], double[].class, 854, 32324, 32339);
                                        if ((FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 854, 32286, 32292)[idx], double[].class, 854, 32286, 32297)[(idx - 1)])) > (FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 854, 32324, 32330)[(idx - 1)], double[].class, 854, 32324, 32339)[idx]))) {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 855, 32370, 32376)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)], double[].class, 855, 32370, 32385)) {
                                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 855, 32402, 32408)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 855, 32402, 32408)[idx], double[].class, 855, 32402, 32413)) {
                                                            CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)], double[].class, 855, 32370, 32385);
                                                            CallChecker.isCalled(matrixT, double[][].class, 855, 32402, 32408)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32402, 32408)[idx], double[].class, 855, 32402, 32413);
                                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)], double[].class, 855, 32370, 32385)[(idx - 1)] = q / (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32402, 32408)[idx], double[].class, 855, 32402, 32413)[(idx - 1)]);
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)], double[].class, 855, 32370, 32385)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 855, 32370, 32376)[(idx - 1)], double[].class, 855, 32370, 32385)[(idx - 1)]", 855, 32370, 32423);
                                                        }
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 856, 32445, 32451)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)], double[].class, 856, 32445, 32460)) {
                                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 856, 32475, 32481)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 856, 32475, 32481)[idx], double[].class, 856, 32475, 32486)) {
                                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 856, 32500, 32506)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 856, 32500, 32506)[idx], double[].class, 856, 32500, 32511)) {
                                                                    CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)], double[].class, 856, 32445, 32460);
                                                                    CallChecker.isCalled(matrixT, double[][].class, 856, 32475, 32481)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32475, 32481)[idx], double[].class, 856, 32475, 32486);
                                                                    CallChecker.isCalled(matrixT, double[][].class, 856, 32500, 32506)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32500, 32506)[idx], double[].class, 856, 32500, 32511);
                                                                    CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)], double[].class, 856, 32445, 32460)[idx] = (-((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32475, 32481)[idx], double[].class, 856, 32475, 32486)[idx]) - p)) / (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32500, 32506)[idx], double[].class, 856, 32500, 32511)[(idx - 1)]);
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)], double[].class, 856, 32445, 32460)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 856, 32445, 32451)[(idx - 1)], double[].class, 856, 32445, 32460)[idx]", 856, 32445, 32521);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }else {
                                            CallChecker.isCalled(matrixT, double[][].class, 858, 32602, 32608)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 858, 32602, 32608)[(idx - 1)], double[].class, 858, 32602, 32617);
                                            CallChecker.isCalled(matrixT, double[][].class, 859, 32673, 32679)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 859, 32673, 32679)[(idx - 1)], double[].class, 859, 32673, 32688);
                                            final Complex result = CallChecker.varInit(cdiv(0.0, (-(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 858, 32602, 32608)[(idx - 1)], double[].class, 858, 32602, 32617)[idx])), ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 859, 32673, 32679)[(idx - 1)], double[].class, 859, 32673, 32688)[(idx - 1)]) - p), q), "result", 858, 32568, 32706);
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 860, 32728, 32734)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)], double[].class, 860, 32728, 32743)) {
                                                    if (CallChecker.beforeDeref(result, Complex.class, 860, 32756, 32761)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)], double[].class, 860, 32728, 32743);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)], double[].class, 860, 32728, 32743)[(idx - 1)] = CallChecker.isCalled(result, Complex.class, 860, 32756, 32761).getReal();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)], double[].class, 860, 32728, 32743)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 860, 32728, 32734)[(idx - 1)], double[].class, 860, 32728, 32743)[(idx - 1)]", 860, 32728, 32772);
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 861, 32794, 32800)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)], double[].class, 861, 32794, 32809)) {
                                                    if (CallChecker.beforeDeref(result, Complex.class, 861, 32822, 32827)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)], double[].class, 861, 32794, 32809);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)], double[].class, 861, 32794, 32809)[idx] = CallChecker.isCalled(result, Complex.class, 861, 32822, 32827).getImaginary();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)], double[].class, 861, 32794, 32809)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 861, 32794, 32800)[(idx - 1)], double[].class, 861, 32794, 32809)[idx]", 861, 32794, 32843);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 864, 32880, 32886)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx], double[].class, 864, 32880, 32891)) {
                                CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx], double[].class, 864, 32880, 32891);
                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx], double[].class, 864, 32880, 32891)[(idx - 1)] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx], double[].class, 864, 32880, 32891)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 864, 32880, 32886)[idx], double[].class, 864, 32880, 32891)[(idx - 1)]", 864, 32880, 32907);
                            }
                        }
                        if (CallChecker.beforeDeref(matrixT, double[][].class, 865, 32925, 32931)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx], double[].class, 865, 32925, 32936)) {
                                CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx], double[].class, 865, 32925, 32936);
                                CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx], double[].class, 865, 32925, 32936)[idx] = 1.0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx], double[].class, 865, 32925, 32936)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 865, 32925, 32931)[idx], double[].class, 865, 32925, 32936)[idx]", 865, 32925, 32952);
                            }
                        }
                        for (int i = idx - 2; i >= 0; i--) {
                            double ra = CallChecker.varInit(((double) (0.0)), "ra", 868, 33028, 33043);
                            double sa = CallChecker.varInit(((double) (0.0)), "sa", 869, 33065, 33080);
                            for (int j = l; j <= idx; j++) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 871, 33169, 33175)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 871, 33169, 33175)[i], double[].class, 871, 33169, 33178)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 871, 33185, 33191)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 871, 33185, 33191)[j], double[].class, 871, 33185, 33194)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 871, 33169, 33175)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 871, 33169, 33175)[i], double[].class, 871, 33169, 33178);
                                                CallChecker.isCalled(matrixT, double[][].class, 871, 33185, 33191)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 871, 33185, 33191)[j], double[].class, 871, 33185, 33194);
                                                ra = ra + ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 871, 33169, 33175)[i], double[].class, 871, 33169, 33178)[j]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 871, 33185, 33191)[j], double[].class, 871, 33185, 33194)[(idx - 1)]));
                                                CallChecker.varAssign(ra, "ra", 871, 33159, 33204);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 872, 33240, 33246)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 872, 33240, 33246)[i], double[].class, 872, 33240, 33249)) {
                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 872, 33256, 33262)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 872, 33256, 33262)[j], double[].class, 872, 33256, 33265)) {
                                                CallChecker.isCalled(matrixT, double[][].class, 872, 33240, 33246)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 872, 33240, 33246)[i], double[].class, 872, 33240, 33249);
                                                CallChecker.isCalled(matrixT, double[][].class, 872, 33256, 33262)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 872, 33256, 33262)[j], double[].class, 872, 33256, 33265);
                                                sa = sa + ((CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 872, 33240, 33246)[i], double[].class, 872, 33240, 33249)[j]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 872, 33256, 33262)[j], double[].class, 872, 33256, 33265)[idx]));
                                                CallChecker.varAssign(sa, "sa", 872, 33230, 33271);
                                            }
                                        }
                                    }
                                }
                            }
                            double w = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(matrixT, double[][].class, 874, 33326, 33332)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 874, 33326, 33332)[i], double[].class, 874, 33326, 33335)) {
                                    CallChecker.isCalled(matrixT, double[][].class, 874, 33326, 33332)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 874, 33326, 33332)[i], double[].class, 874, 33326, 33335);
                                    w = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 874, 33326, 33332)[i], double[].class, 874, 33326, 33335)[i]) - p;
                                    CallChecker.varAssign(w, "w", 874, 33326, 33332);
                                }
                            }
                            if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 876, 33390, 33404)) {
                                imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 876, 33390, 33404);
                                if ((Precision.compareTo(CallChecker.isCalled(imagEigenvalues, double[].class, 876, 33390, 33404)[i], 0.0, EigenDecomposition.EPSILON)) < 0.0) {
                                    z = w;
                                    CallChecker.varAssign(z, "z", 877, 33457, 33462);
                                    r = ra;
                                    CallChecker.varAssign(r, "r", 878, 33488, 33494);
                                    s = sa;
                                    CallChecker.varAssign(s, "s", 879, 33520, 33526);
                                }else {
                                    l = i;
                                    CallChecker.varAssign(l, "l", 881, 33581, 33586);
                                    if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 882, 33633, 33647)) {
                                        imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 882, 33633, 33647);
                                        if (Precision.equals(CallChecker.isCalled(imagEigenvalues, double[].class, 882, 33633, 33647)[i], 0.0)) {
                                            final Complex c = CallChecker.varInit(cdiv((-ra), (-sa), w, q), "c", 883, 33689, 33727);
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 884, 33757, 33763)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i], double[].class, 884, 33757, 33766)) {
                                                    if (CallChecker.beforeDeref(c, Complex.class, 884, 33779, 33779)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i], double[].class, 884, 33757, 33766);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i], double[].class, 884, 33757, 33766)[(idx - 1)] = CallChecker.isCalled(c, Complex.class, 884, 33779, 33779).getReal();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i], double[].class, 884, 33757, 33766)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 884, 33757, 33763)[i], double[].class, 884, 33757, 33766)[(idx - 1)]", 884, 33757, 33790);
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 885, 33820, 33826)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i], double[].class, 885, 33820, 33829)) {
                                                    if (CallChecker.beforeDeref(c, Complex.class, 885, 33838, 33838)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i], double[].class, 885, 33820, 33829);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i], double[].class, 885, 33820, 33829)[idx] = CallChecker.isCalled(c, Complex.class, 885, 33838, 33838).getImaginary();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i], double[].class, 885, 33820, 33829)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 885, 33820, 33826)[i], double[].class, 885, 33820, 33829)[idx]", 885, 33820, 33854);
                                                    }
                                                }
                                            }
                                        }else {
                                            double x = CallChecker.init(double.class);
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 888, 33983, 33989)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 888, 33983, 33989)[i], double[].class, 888, 33983, 33992)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 888, 33983, 33989)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 888, 33983, 33989)[i], double[].class, 888, 33983, 33992);
                                                    x = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 888, 33983, 33989)[i], double[].class, 888, 33983, 33992)[(i + 1)];
                                                    CallChecker.varAssign(x, "x", 888, 33983, 33989);
                                                }
                                            }
                                            double y = CallChecker.init(double.class);
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 889, 34041, 34047)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 889, 34041, 34047)[(i + 1)], double[].class, 889, 34041, 34054)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 889, 34041, 34047)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 889, 34041, 34047)[(i + 1)], double[].class, 889, 34041, 34054);
                                                    y = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 889, 34041, 34047)[(i + 1)], double[].class, 889, 34041, 34054)[i];
                                                    CallChecker.varAssign(y, "y", 889, 34041, 34047);
                                                }
                                            }
                                            double vr = CallChecker.init(double.class);
                                            if (CallChecker.beforeDeref(realEigenvalues, double[].class, 890, 34101, 34115)) {
                                                if (CallChecker.beforeDeref(realEigenvalues, double[].class, 890, 34128, 34142)) {
                                                    if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 891, 34194, 34208)) {
                                                        if (CallChecker.beforeDeref(imagEigenvalues, double[].class, 891, 34215, 34229)) {
                                                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 890, 34101, 34115);
                                                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 890, 34128, 34142);
                                                            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 891, 34194, 34208);
                                                            imagEigenvalues = CallChecker.beforeCalled(imagEigenvalues, double[].class, 891, 34215, 34229);
                                                            vr = ((((CallChecker.isCalled(realEigenvalues, double[].class, 890, 34101, 34115)[i]) - p) * ((CallChecker.isCalled(realEigenvalues, double[].class, 890, 34128, 34142)[i]) - p)) + ((CallChecker.isCalled(imagEigenvalues, double[].class, 891, 34194, 34208)[i]) * (CallChecker.isCalled(imagEigenvalues, double[].class, 891, 34215, 34229)[i]))) - (q * q);
                                                            CallChecker.varAssign(vr, "vr", 890, 34101, 34115);
                                                        }
                                                    }
                                                }
                                            }
                                            realEigenvalues = CallChecker.beforeCalled(realEigenvalues, double[].class, 892, 34290, 34304);
                                            final double vi = CallChecker.varInit(((double) ((((CallChecker.isCalled(this.realEigenvalues, double[].class, 892, 34290, 34304)[i]) - p) * 2.0) * q)), "vi", 892, 34271, 34323);
                                            if ((Precision.equals(vr, 0.0)) && (Precision.equals(vi, 0.0))) {
                                                vr = ((Precision.EPSILON) * norm) * (((((FastMath.abs(w)) + (FastMath.abs(q))) + (FastMath.abs(x))) + (FastMath.abs(y))) + (FastMath.abs(z)));
                                                CallChecker.varAssign(vr, "vr", 894, 34447, 34643);
                                            }
                                            final Complex c = CallChecker.varInit(cdiv((((x * r) - (z * ra)) + (q * sa)), (((x * s) - (z * sa)) - (q * ra)), vr, vi), "c", 898, 34703, 34842);
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 900, 34872, 34878)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i], double[].class, 900, 34872, 34881)) {
                                                    if (CallChecker.beforeDeref(c, Complex.class, 900, 34894, 34894)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i], double[].class, 900, 34872, 34881);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i], double[].class, 900, 34872, 34881)[(idx - 1)] = CallChecker.isCalled(c, Complex.class, 900, 34894, 34894).getReal();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i], double[].class, 900, 34872, 34881)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 900, 34872, 34878)[i], double[].class, 900, 34872, 34881)[(idx - 1)]", 900, 34872, 34905);
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 901, 34935, 34941)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i], double[].class, 901, 34935, 34944)) {
                                                    if (CallChecker.beforeDeref(c, Complex.class, 901, 34957, 34957)) {
                                                        CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i], double[].class, 901, 34935, 34944);
                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i], double[].class, 901, 34935, 34944)[idx] = CallChecker.isCalled(c, Complex.class, 901, 34957, 34957).getImaginary();
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i], double[].class, 901, 34935, 34944)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 901, 34935, 34941)[i], double[].class, 901, 34935, 34944)[idx]", 901, 34935, 34973);
                                                    }
                                                }
                                            }
                                            if ((FastMath.abs(x)) > ((FastMath.abs(z)) + (FastMath.abs(q)))) {
                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 904, 35097, 35103)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)], double[].class, 904, 35097, 35110)) {
                                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 904, 35134, 35140)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 904, 35134, 35140)[i], double[].class, 904, 35134, 35143)) {
                                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 905, 35219, 35225)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 905, 35219, 35225)[i], double[].class, 905, 35219, 35228)) {
                                                                        CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)], double[].class, 904, 35097, 35110);
                                                                        CallChecker.isCalled(matrixT, double[][].class, 904, 35134, 35140)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35134, 35140)[i], double[].class, 904, 35134, 35143);
                                                                        CallChecker.isCalled(matrixT, double[][].class, 905, 35219, 35225)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 905, 35219, 35225)[i], double[].class, 905, 35219, 35228);
                                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)], double[].class, 904, 35097, 35110)[(idx - 1)] = (((-ra) - (w * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35134, 35140)[i], double[].class, 904, 35134, 35143)[(idx - 1)]))) + (q * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 905, 35219, 35225)[i], double[].class, 905, 35219, 35228)[idx]))) / x;
                                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)], double[].class, 904, 35097, 35110)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 904, 35097, 35103)[(i + 1)], double[].class, 904, 35097, 35110)[(idx - 1)]", 904, 35097, 35239);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 906, 35273, 35279)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)], double[].class, 906, 35273, 35286)) {
                                                        if (CallChecker.beforeDeref(matrixT, double[][].class, 906, 35310, 35316)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 906, 35310, 35316)[i], double[].class, 906, 35310, 35319)) {
                                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 907, 35391, 35397)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 907, 35391, 35397)[i], double[].class, 907, 35391, 35400)) {
                                                                        CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)], double[].class, 906, 35273, 35286);
                                                                        CallChecker.isCalled(matrixT, double[][].class, 906, 35310, 35316)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35310, 35316)[i], double[].class, 906, 35310, 35319);
                                                                        CallChecker.isCalled(matrixT, double[][].class, 907, 35391, 35397)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 907, 35391, 35397)[i], double[].class, 907, 35391, 35400);
                                                                        CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)], double[].class, 906, 35273, 35286)[idx] = (((-sa) - (w * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35310, 35316)[i], double[].class, 906, 35310, 35319)[idx]))) - (q * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 907, 35391, 35397)[i], double[].class, 907, 35391, 35400)[(idx - 1)]))) / x;
                                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)], double[].class, 906, 35273, 35286)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 906, 35273, 35279)[(i + 1)], double[].class, 906, 35273, 35286)[idx]", 906, 35273, 35415);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else {
                                                CallChecker.isCalled(matrixT, double[][].class, 909, 35526, 35532)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 909, 35526, 35532)[i], double[].class, 909, 35526, 35535);
                                                CallChecker.isCalled(matrixT, double[][].class, 910, 35619, 35625)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 910, 35619, 35625)[i], double[].class, 910, 35619, 35628);
                                                final Complex c2 = CallChecker.varInit(cdiv(((-r) - (y * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 909, 35526, 35532)[i], double[].class, 909, 35526, 35535)[(idx - 1)]))), ((-s) - (y * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 910, 35619, 35625)[i], double[].class, 910, 35619, 35628)[idx]))), z, q), "c2", 909, 35486, 35641);
                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 911, 35675, 35681)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)], double[].class, 911, 35675, 35688)) {
                                                        if (CallChecker.beforeDeref(c2, Complex.class, 911, 35701, 35702)) {
                                                            CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)], double[].class, 911, 35675, 35688);
                                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)], double[].class, 911, 35675, 35688)[(idx - 1)] = CallChecker.isCalled(c2, Complex.class, 911, 35701, 35702).getReal();
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)], double[].class, 911, 35675, 35688)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 911, 35675, 35681)[(i + 1)], double[].class, 911, 35675, 35688)[(idx - 1)]", 911, 35675, 35713);
                                                        }
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(matrixT, double[][].class, 912, 35747, 35753)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)], double[].class, 912, 35747, 35760)) {
                                                        if (CallChecker.beforeDeref(c2, Complex.class, 912, 35773, 35774)) {
                                                            CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)], double[].class, 912, 35747, 35760);
                                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)], double[].class, 912, 35747, 35760)[idx] = CallChecker.isCalled(c2, Complex.class, 912, 35773, 35774).getImaginary();
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)], double[].class, 912, 35747, 35760)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 912, 35747, 35753)[(i + 1)], double[].class, 912, 35747, 35760)[idx]", 912, 35747, 35790);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    double t = CallChecker.init(double.class);
                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 917, 35954, 35960)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 917, 35954, 35960)[i], double[].class, 917, 35954, 35963)) {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 918, 36037, 36043)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 918, 36037, 36043)[i], double[].class, 918, 36037, 36046)) {
                                                    CallChecker.isCalled(matrixT, double[][].class, 917, 35954, 35960)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 917, 35954, 35960)[i], double[].class, 917, 35954, 35963);
                                                    CallChecker.isCalled(matrixT, double[][].class, 918, 36037, 36043)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 918, 36037, 36043)[i], double[].class, 918, 36037, 36046);
                                                    t = FastMath.max(FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 917, 35954, 35960)[i], double[].class, 917, 35954, 35963)[(idx - 1)]), FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 918, 36037, 36043)[i], double[].class, 918, 36037, 36046)[idx]));
                                                    CallChecker.varAssign(t, "t", 917, 35954, 35960);
                                                }
                                            }
                                        }
                                    }
                                    if ((((Precision.EPSILON) * t) * t) > 1) {
                                        for (int j = i; j <= idx; j++) {
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 921, 36212, 36218)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j], double[].class, 921, 36212, 36221)) {
                                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 921, 36234, 36240)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 921, 36234, 36240)[j], double[].class, 921, 36234, 36243)) {
                                                            CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j], double[].class, 921, 36212, 36221);
                                                            CallChecker.isCalled(matrixT, double[][].class, 921, 36234, 36240)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36234, 36240)[j], double[].class, 921, 36234, 36243);
                                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j], double[].class, 921, 36212, 36221)[(idx - 1)] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36234, 36240)[j], double[].class, 921, 36234, 36243)[(idx - 1)]) / t;
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j], double[].class, 921, 36212, 36221)[(idx - 1)], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 921, 36212, 36218)[j], double[].class, 921, 36212, 36221)[(idx - 1)]", 921, 36212, 36257);
                                                        }
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(matrixT, double[][].class, 922, 36291, 36297)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j], double[].class, 922, 36291, 36300)) {
                                                    if (CallChecker.beforeDeref(matrixT, double[][].class, 922, 36313, 36319)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 922, 36313, 36319)[j], double[].class, 922, 36313, 36322)) {
                                                            CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j], double[].class, 922, 36291, 36300);
                                                            CallChecker.isCalled(matrixT, double[][].class, 922, 36313, 36319)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36313, 36319)[j], double[].class, 922, 36313, 36322);
                                                            CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j], double[].class, 922, 36291, 36300)[idx] = (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36313, 36319)[j], double[].class, 922, 36313, 36322)[idx]) / t;
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j], double[].class, 922, 36291, 36300)[idx], "CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 922, 36291, 36297)[j], double[].class, 922, 36291, 36300)[idx]", 922, 36291, 36332);
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
            for (int i = 0; i < n; i++) {
                if ((i < 0) | (i > (n - 1))) {
                    for (int j = i; j < n; j++) {
                        if (CallChecker.beforeDeref(matrixP, double[][].class, 934, 36633, 36639)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i], double[].class, 934, 36633, 36642)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 934, 36649, 36655)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 934, 36649, 36655)[i], double[].class, 934, 36649, 36658)) {
                                        CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i], double[].class, 934, 36633, 36642);
                                        CallChecker.isCalled(matrixT, double[][].class, 934, 36649, 36655)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 934, 36649, 36655)[i], double[].class, 934, 36649, 36658);
                                        CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i], double[].class, 934, 36633, 36642)[j] = CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 934, 36649, 36655)[i], double[].class, 934, 36649, 36658)[j];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i], double[].class, 934, 36633, 36642)[j], "CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 934, 36633, 36639)[i], double[].class, 934, 36633, 36642)[j]", 934, 36633, 36662);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i <= (n - 1); i++) {
                    z = 0.0;
                    CallChecker.varAssign(z, "z", 942, 36883, 36890);
                    for (int k = 0; k <= (FastMath.min(j, (n - 1))); k++) {
                        if (CallChecker.beforeDeref(matrixP, double[][].class, 944, 36988, 36994)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 944, 36988, 36994)[i], double[].class, 944, 36988, 36997)) {
                                if (CallChecker.beforeDeref(matrixT, double[][].class, 944, 37004, 37010)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(matrixT, double[][].class, 944, 37004, 37010)[k], double[].class, 944, 37004, 37013)) {
                                        CallChecker.isCalled(matrixP, double[][].class, 944, 36988, 36994)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 944, 36988, 36994)[i], double[].class, 944, 36988, 36997);
                                        CallChecker.isCalled(matrixT, double[][].class, 944, 37004, 37010)[k] = CallChecker.beforeCalled(CallChecker.isCalled(matrixT, double[][].class, 944, 37004, 37010)[k], double[].class, 944, 37004, 37013);
                                        z = z + ((CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 944, 36988, 36994)[i], double[].class, 944, 36988, 36997)[k]) * (CallChecker.isCalled(CallChecker.isCalled(matrixT, double[][].class, 944, 37004, 37010)[k], double[].class, 944, 37004, 37013)[j]));
                                        CallChecker.varAssign(z, "z", 944, 36980, 37017);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(matrixP, double[][].class, 946, 37053, 37059)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i], double[].class, 946, 37053, 37062)) {
                            CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i], double[].class, 946, 37053, 37062);
                            CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i], double[].class, 946, 37053, 37062)[j] = z;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i], double[].class, 946, 37053, 37062)[j], "CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 946, 37053, 37059)[i], double[].class, 946, 37053, 37062)[j]", 946, 37053, 37070);
                        }
                    }
                }
            }
            eigenvectors = new ArrayRealVector[n];
            CallChecker.varAssign(this.eigenvectors, "this.eigenvectors", 950, 37105, 37142);
            final double[] tmp = CallChecker.varInit(new double[n], "tmp", 951, 37152, 37186);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(tmp, double[].class, 954, 37284, 37286)) {
                        if (CallChecker.beforeDeref(matrixP, double[][].class, 954, 37293, 37299)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(matrixP, double[][].class, 954, 37293, 37299)[j], double[].class, 954, 37293, 37302)) {
                                CallChecker.isCalled(matrixP, double[][].class, 954, 37293, 37299)[j] = CallChecker.beforeCalled(CallChecker.isCalled(matrixP, double[][].class, 954, 37293, 37299)[j], double[].class, 954, 37293, 37302);
                                CallChecker.isCalled(tmp, double[].class, 954, 37284, 37286)[j] = CallChecker.isCalled(CallChecker.isCalled(matrixP, double[][].class, 954, 37293, 37299)[j], double[].class, 954, 37293, 37302)[i];
                                CallChecker.varAssign(CallChecker.isCalled(tmp, double[].class, 954, 37284, 37286)[j], "CallChecker.isCalled(tmp, double[].class, 954, 37284, 37286)[j]", 954, 37284, 37306);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(eigenvectors, ArrayRealVector[].class, 956, 37334, 37345)) {
                    eigenvectors = CallChecker.beforeCalled(eigenvectors, ArrayRealVector[].class, 956, 37334, 37345);
                    CallChecker.isCalled(eigenvectors, ArrayRealVector[].class, 956, 37334, 37345)[i] = new ArrayRealVector(tmp);
                    CallChecker.varAssign(CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 956, 37334, 37345)[i], "CallChecker.isCalled(this.eigenvectors, ArrayRealVector[].class, 956, 37334, 37345)[i]", 956, 37334, 37376);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4009.methodEnd();
        }
    }
}

