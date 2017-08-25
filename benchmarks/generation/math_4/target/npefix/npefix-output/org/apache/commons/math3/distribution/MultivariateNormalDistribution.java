package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class MultivariateNormalDistribution extends AbstractMultivariateRealDistribution {
    private final double[] means;

    private final RealMatrix covarianceMatrix;

    private final RealMatrix covarianceMatrixInverse;

    private final double covarianceMatrixDeterminant;

    private final RealMatrix samplingMatrix;

    public MultivariateNormalDistribution(final double[] means, final double[][] covariances) throws DimensionMismatchException, NonPositiveDefiniteMatrixException, SingularMatrixException {
        this(new Well19937c(), means, covariances);
        ConstructorContext _bcornu_methode_context49 = new ConstructorContext(MultivariateNormalDistribution.class, 71, 2370, 3432);
        try {
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public MultivariateNormalDistribution(RandomGenerator rng, final double[] means, final double[][] covariances) throws DimensionMismatchException, NonPositiveDefiniteMatrixException, SingularMatrixException {
        super(rng, CallChecker.isCalled(means, double[].class, 103, 4582, 4586).length);
        ConstructorContext _bcornu_methode_context50 = new ConstructorContext(MultivariateNormalDistribution.class, 97, 3439, 6593);
        try {
            final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(means, double[].class, 105, 4622, 4626).length)), "dim", 105, 4606, 4634);
            if (CallChecker.beforeDeref(covariances, double[][].class, 107, 4649, 4659)) {
                if ((CallChecker.isCalled(covariances, double[][].class, 107, 4649, 4659).length) != dim) {
                    if (CallChecker.beforeDeref(covariances, double[][].class, 108, 4727, 4737)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(covariances, double[][].class, 108, 4727, 4737).length, dim);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(covariances, double[][].class, 112, 4827, 4837)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(covariances, double[][].class, 112, 4827, 4837)[i], double[].class, 112, 4827, 4840)) {
                        CallChecker.isCalled(covariances, double[][].class, 112, 4827, 4837)[i] = CallChecker.beforeCalled(CallChecker.isCalled(covariances, double[][].class, 112, 4827, 4837)[i], double[].class, 112, 4827, 4840);
                        if (dim != (CallChecker.isCalled(CallChecker.isCalled(covariances, double[][].class, 112, 4827, 4837)[i], double[].class, 112, 4827, 4840).length)) {
                            if (CallChecker.beforeDeref(covariances, double[][].class, 113, 4905, 4915)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(covariances, double[][].class, 113, 4905, 4915)[i], double[].class, 113, 4905, 4918)) {
                                    CallChecker.isCalled(covariances, double[][].class, 113, 4905, 4915)[i] = CallChecker.beforeCalled(CallChecker.isCalled(covariances, double[][].class, 113, 4905, 4915)[i], double[].class, 113, 4905, 4918);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(covariances, double[][].class, 113, 4905, 4915)[i], double[].class, 113, 4905, 4918).length, dim);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            this.means = MathArrays.copyOf(means);
            CallChecker.varAssign(this.means, "this.means", 117, 4967, 5004);
            covarianceMatrix = new Array2DRowRealMatrix(covariances);
            CallChecker.varAssign(this.covarianceMatrix, "this.covarianceMatrix", 119, 5015, 5071);
            final EigenDecomposition covMatDec = CallChecker.varInit(new EigenDecomposition(covarianceMatrix), "covMatDec", 122, 5082, 5209);
            covarianceMatrixInverse = CallChecker.isCalled(CallChecker.isCalled(covMatDec, EigenDecomposition.class, 125, 5288, 5296).getSolver(), DecompositionSolver.class, 125, 5288, 5308).getInverse();
            CallChecker.varAssign(this.covarianceMatrixInverse, "this.covarianceMatrixInverse", 125, 5262, 5322);
            covarianceMatrixDeterminant = CallChecker.isCalled(covMatDec, EigenDecomposition.class, 127, 5408, 5416).getDeterminant();
            CallChecker.varAssign(this.covarianceMatrixDeterminant, "this.covarianceMatrixDeterminant", 127, 5378, 5434);
            final double[] covMatEigenvalues = CallChecker.varInit(CallChecker.isCalled(covMatDec, EigenDecomposition.class, 130, 5529, 5537).getRealEigenvalues(), "covMatEigenvalues", 130, 5494, 5559);
            for (int i = 0; i < (CallChecker.isCalled(covMatEigenvalues, double[].class, 132, 5590, 5606).length); i++) {
                if (CallChecker.beforeDeref(covMatEigenvalues, double[].class, 133, 5639, 5655)) {
                    if ((CallChecker.isCalled(covMatEigenvalues, double[].class, 133, 5639, 5655)[i]) < 0) {
                        if (CallChecker.beforeDeref(covMatEigenvalues, double[].class, 134, 5728, 5744)) {
                            throw new NonPositiveDefiniteMatrixException(CallChecker.isCalled(covMatEigenvalues, double[].class, 134, 5728, 5744)[i], i, 0);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            final Array2DRowRealMatrix covMatEigenvectors = CallChecker.varInit(new Array2DRowRealMatrix(dim, dim), "covMatEigenvectors", 139, 5790, 5952);
            for (int v = 0; v < dim; v++) {
                final double[] evec = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(covMatDec, EigenDecomposition.class, 141, 6028, 6036).getEigenvector(v), RealVector.class, 141, 6028, 6054).toArray(), "evec", 141, 6006, 6065);
                if (CallChecker.beforeDeref(covMatEigenvectors, Array2DRowRealMatrix.class, 142, 6079, 6096)) {
                    CallChecker.isCalled(covMatEigenvectors, Array2DRowRealMatrix.class, 142, 6079, 6096).setColumn(v, evec);
                }
            }
            final RealMatrix tmpMatrix = CallChecker.varInit(CallChecker.isCalled(covMatEigenvectors, Array2DRowRealMatrix.class, 145, 6166, 6183).transpose(), "tmpMatrix", 145, 6137, 6196);
            for (int row = 0; row < dim; row++) {
                final double factor = CallChecker.varInit(((double) (FastMath.sqrt(CallChecker.isCalled(covMatEigenvalues, double[].class, 149, 6365, 6381)[row]))), "factor", 149, 6329, 6388);
                for (int col = 0; col < dim; col++) {
                    if (CallChecker.beforeDeref(tmpMatrix, RealMatrix.class, 151, 6456, 6464)) {
                        CallChecker.isCalled(tmpMatrix, RealMatrix.class, 151, 6456, 6464).multiplyEntry(row, col, factor);
                    }
                }
            }
            samplingMatrix = CallChecker.isCalled(covMatEigenvectors, Array2DRowRealMatrix.class, 155, 6549, 6566).multiply(tmpMatrix);
            CallChecker.varAssign(this.samplingMatrix, "this.samplingMatrix", 155, 6532, 6587);
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public double[] getMeans() {
        MethodContext _bcornu_methode_context161 = new MethodContext(double[].class, 163, 6600, 6758);
        try {
            CallChecker.varInit(this, "this", 163, 6600, 6758);
            CallChecker.varInit(this.random, "random", 163, 6600, 6758);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 163, 6600, 6758);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 163, 6600, 6758);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 163, 6600, 6758);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 163, 6600, 6758);
            CallChecker.varInit(this.means, "means", 163, 6600, 6758);
            return MathArrays.copyOf(means);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    public RealMatrix getCovariances() {
        MethodContext _bcornu_methode_context162 = new MethodContext(RealMatrix.class, 172, 6765, 6942);
        try {
            CallChecker.varInit(this, "this", 172, 6765, 6942);
            CallChecker.varInit(this.random, "random", 172, 6765, 6942);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 172, 6765, 6942);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 172, 6765, 6942);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 172, 6765, 6942);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 172, 6765, 6942);
            CallChecker.varInit(this.means, "means", 172, 6765, 6942);
            if (CallChecker.beforeDeref(covarianceMatrix, RealMatrix.class, 173, 6913, 6928)) {
                return CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 173, 6913, 6928).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public double density(final double[] vals) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context163 = new MethodContext(double.class, 177, 6949, 7366);
        try {
            CallChecker.varInit(this, "this", 177, 6949, 7366);
            CallChecker.varInit(vals, "vals", 177, 6949, 7366);
            CallChecker.varInit(this.random, "random", 177, 6949, 7366);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 177, 6949, 7366);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 177, 6949, 7366);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 177, 6949, 7366);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 177, 6949, 7366);
            CallChecker.varInit(this.means, "means", 177, 6949, 7366);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 178, 7061, 7091);
            if (CallChecker.beforeDeref(vals, double[].class, 179, 7105, 7108)) {
                if ((CallChecker.isCalled(vals, double[].class, 179, 7105, 7108).length) != dim) {
                    if (CallChecker.beforeDeref(vals, double[].class, 180, 7176, 7179)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(vals, double[].class, 180, 7176, 7179).length, dim);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return ((FastMath.pow((2 * (FastMath.PI)), ((-0.5) * dim))) * (FastMath.pow(covarianceMatrixDeterminant, (-0.5)))) * (getExponentTerm(vals));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    public double[] getStandardDeviations() {
        MethodContext _bcornu_methode_context164 = new MethodContext(double[].class, 194, 7373, 7833);
        try {
            CallChecker.varInit(this, "this", 194, 7373, 7833);
            CallChecker.varInit(this.random, "random", 194, 7373, 7833);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 194, 7373, 7833);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 194, 7373, 7833);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 194, 7373, 7833);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 194, 7373, 7833);
            CallChecker.varInit(this.means, "means", 194, 7373, 7833);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 195, 7579, 7609);
            final double[] std = CallChecker.varInit(new double[dim], "std", 196, 7619, 7655);
            final double[][] s = CallChecker.varInit(CallChecker.isCalled(covarianceMatrix, RealMatrix.class, 197, 7686, 7701).getData(), "s", 197, 7665, 7712);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(std, double[].class, 199, 7766, 7768)) {
                    if (CallChecker.beforeDeref(s, double[][].class, 199, 7789, 7789)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(s, double[][].class, 199, 7789, 7789)[i], double[].class, 199, 7789, 7792)) {
                            CallChecker.isCalled(s, double[][].class, 199, 7789, 7789)[i] = CallChecker.beforeCalled(CallChecker.isCalled(s, double[][].class, 199, 7789, 7789)[i], double[].class, 199, 7789, 7792);
                            CallChecker.isCalled(std, double[].class, 199, 7766, 7768)[i] = FastMath.sqrt(CallChecker.isCalled(CallChecker.isCalled(s, double[][].class, 199, 7789, 7789)[i], double[].class, 199, 7789, 7792)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(std, double[].class, 199, 7766, 7768)[i], "CallChecker.isCalled(std, double[].class, 199, 7766, 7768)[i]", 199, 7766, 7797);
                        }
                    }
                }
            }
            return std;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    public double[] sample() {
        MethodContext _bcornu_methode_context165 = new MethodContext(double[].class, 205, 7840, 8264);
        try {
            CallChecker.varInit(this, "this", 205, 7840, 8264);
            CallChecker.varInit(this.random, "random", 205, 7840, 8264);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 205, 7840, 8264);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 205, 7840, 8264);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 205, 7840, 8264);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 205, 7840, 8264);
            CallChecker.varInit(this.means, "means", 205, 7840, 8264);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 206, 7900, 7930);
            final double[] normalVals = CallChecker.varInit(new double[dim], "normalVals", 207, 7940, 7983);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(normalVals, double[].class, 210, 8038, 8047)) {
                    if (CallChecker.beforeDeref(random, RandomGenerator.class, 210, 8054, 8059)) {
                        CallChecker.isCalled(normalVals, double[].class, 210, 8038, 8047)[i] = CallChecker.isCalled(random, RandomGenerator.class, 210, 8054, 8059).nextGaussian();
                        CallChecker.varAssign(CallChecker.isCalled(normalVals, double[].class, 210, 8038, 8047)[i], "CallChecker.isCalled(normalVals, double[].class, 210, 8038, 8047)[i]", 210, 8038, 8075);
                    }
                }
            }
            final double[] vals = CallChecker.varInit(CallChecker.isCalled(samplingMatrix, RealMatrix.class, 213, 8118, 8131).operate(normalVals), "vals", 213, 8096, 8152);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(vals, double[].class, 216, 8207, 8210)) {
                    if (CallChecker.beforeDeref(means, double[].class, 216, 8218, 8222)) {
                        CallChecker.isCalled(vals, double[].class, 216, 8207, 8210)[i] += CallChecker.isCalled(means, double[].class, 216, 8218, 8222)[i];
                        CallChecker.varAssign(CallChecker.isCalled(vals, double[].class, 216, 8207, 8210)[i], "CallChecker.isCalled(vals, double[].class, 216, 8207, 8210)[i]", 216, 8207, 8226);
                    }
                }
            }
            return vals;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    private double getExponentTerm(final double[] values) {
        MethodContext _bcornu_methode_context166 = new MethodContext(double.class, 228, 8271, 9006);
        try {
            CallChecker.varInit(this, "this", 228, 8271, 9006);
            CallChecker.varInit(values, "values", 228, 8271, 9006);
            CallChecker.varInit(this.random, "random", 228, 8271, 9006);
            CallChecker.varInit(this.samplingMatrix, "samplingMatrix", 228, 8271, 9006);
            CallChecker.varInit(this.covarianceMatrixDeterminant, "covarianceMatrixDeterminant", 228, 8271, 9006);
            CallChecker.varInit(this.covarianceMatrixInverse, "covarianceMatrixInverse", 228, 8271, 9006);
            CallChecker.varInit(this.covarianceMatrix, "covarianceMatrix", 228, 8271, 9006);
            CallChecker.varInit(this.means, "means", 228, 8271, 9006);
            final double[] centered = CallChecker.varInit(new double[CallChecker.isCalled(values, double[].class, 229, 8602, 8607).length], "centered", 229, 8565, 8616);
            for (int i = 0; i < (CallChecker.isCalled(centered, double[].class, 230, 8646, 8653).length); i++) {
                if (CallChecker.beforeDeref(centered, double[].class, 231, 8682, 8689)) {
                    if (CallChecker.beforeDeref(values, double[].class, 231, 8696, 8701)) {
                        final double[] npe_invocation_var10 = getMeans();
                        if (CallChecker.beforeDeref(npe_invocation_var10, double[].class, 231, 8708, 8717)) {
                            CallChecker.isCalled(centered, double[].class, 231, 8682, 8689)[i] = (CallChecker.isCalled(values, double[].class, 231, 8696, 8701)[i]) - (CallChecker.isCalled(npe_invocation_var10, double[].class, 231, 8708, 8717)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(centered, double[].class, 231, 8682, 8689)[i], "CallChecker.isCalled(centered, double[].class, 231, 8682, 8689)[i]", 231, 8682, 8721);
                        }
                    }
                }
            }
            final double[] preMultiplied = CallChecker.varInit(CallChecker.isCalled(covarianceMatrixInverse, RealMatrix.class, 233, 8772, 8794).preMultiply(centered), "preMultiplied", 233, 8741, 8817);
            double sum = CallChecker.varInit(((double) (0)), "sum", 234, 8827, 8841);
            for (int i = 0; i < (CallChecker.isCalled(preMultiplied, double[].class, 235, 8871, 8883).length); i++) {
                if (CallChecker.beforeDeref(preMultiplied, double[].class, 236, 8919, 8931)) {
                    if (CallChecker.beforeDeref(centered, double[].class, 236, 8938, 8945)) {
                        sum += (CallChecker.isCalled(preMultiplied, double[].class, 236, 8919, 8931)[i]) * (CallChecker.isCalled(centered, double[].class, 236, 8938, 8945)[i]);
                        CallChecker.varAssign(sum, "sum", 236, 8912, 8949);
                    }
                }
            }
            return FastMath.exp(((-0.5) * sum));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }
}

