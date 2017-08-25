package org.apache.commons.math3.stat.correlation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class StorelessCovariance extends Covariance {
    private StorelessBivariateCovariance[] covMatrix;

    private int dimension;

    public StorelessCovariance(final int dim) {
        this(dim, true);
        ConstructorContext _bcornu_methode_context249 = new ConstructorContext(StorelessCovariance.class, 56, 2255, 2488);
        try {
        } finally {
            _bcornu_methode_context249.methodEnd();
        }
    }

    public StorelessCovariance(final int dim, final boolean biasCorrected) {
        ConstructorContext _bcornu_methode_context250 = new ConstructorContext(StorelessCovariance.class, 69, 2495, 3126);
        try {
            dimension = dim;
            CallChecker.varAssign(this.dimension, "this.dimension", 70, 2977, 2992);
            covMatrix = new StorelessBivariateCovariance[((dimension) * ((dimension) + 1)) / 2];
            CallChecker.varAssign(this.covMatrix, "this.covMatrix", 71, 3002, 3079);
            initializeMatrix(biasCorrected);
        } finally {
            _bcornu_methode_context250.methodEnd();
        }
    }

    private void initializeMatrix(final boolean biasCorrected) {
        MethodContext _bcornu_methode_context1046 = new MethodContext(void.class, 81, 3133, 3614);
        try {
            CallChecker.varInit(this, "this", 81, 3133, 3614);
            CallChecker.varInit(biasCorrected, "biasCorrected", 81, 3133, 3614);
            CallChecker.varInit(this.dimension, "dimension", 81, 3133, 3614);
            CallChecker.varInit(this.covMatrix, "covMatrix", 81, 3133, 3614);
            for (int i = 0; i < (dimension); i++) {
                for (int j = 0; j < (dimension); j++) {
                    setElement(i, j, new StorelessBivariateCovariance(biasCorrected));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1046.methodEnd();
        }
    }

    private int indexOf(final int i, final int j) {
        MethodContext _bcornu_methode_context1047 = new MethodContext(int.class, 98, 3621, 4048);
        try {
            CallChecker.varInit(this, "this", 98, 3621, 4048);
            CallChecker.varInit(j, "j", 98, 3621, 4048);
            CallChecker.varInit(i, "i", 98, 3621, 4048);
            CallChecker.varInit(this.dimension, "dimension", 98, 3621, 4048);
            CallChecker.varInit(this.covMatrix, "covMatrix", 98, 3621, 4048);
            if (j < i) {
                return ((i * (i + 1)) / 2) + j;
            }else {
                return ((j * (j + 1)) / 2) + i;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1047.methodEnd();
        }
    }

    private StorelessBivariateCovariance getElement(final int i, final int j) {
        MethodContext _bcornu_methode_context1048 = new MethodContext(StorelessBivariateCovariance.class, 108, 4055, 4405);
        try {
            CallChecker.varInit(this, "this", 108, 4055, 4405);
            CallChecker.varInit(j, "j", 108, 4055, 4405);
            CallChecker.varInit(i, "i", 108, 4055, 4405);
            CallChecker.varInit(this.dimension, "dimension", 108, 4055, 4405);
            CallChecker.varInit(this.covMatrix, "covMatrix", 108, 4055, 4405);
            if (CallChecker.beforeDeref(covMatrix, StorelessBivariateCovariance[].class, 109, 4375, 4383)) {
                covMatrix = CallChecker.beforeCalled(covMatrix, StorelessBivariateCovariance[].class, 109, 4375, 4383);
                return CallChecker.isCalled(covMatrix, StorelessBivariateCovariance[].class, 109, 4375, 4383)[indexOf(i, j)];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StorelessBivariateCovariance) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1048.methodEnd();
        }
    }

    private void setElement(final int i, final int j, final StorelessBivariateCovariance cov) {
        MethodContext _bcornu_methode_context1049 = new MethodContext(void.class, 118, 4412, 4808);
        try {
            CallChecker.varInit(this, "this", 118, 4412, 4808);
            CallChecker.varInit(cov, "cov", 118, 4412, 4808);
            CallChecker.varInit(j, "j", 118, 4412, 4808);
            CallChecker.varInit(i, "i", 118, 4412, 4808);
            CallChecker.varInit(this.dimension, "dimension", 118, 4412, 4808);
            CallChecker.varInit(this.covMatrix, "covMatrix", 118, 4412, 4808);
            if (CallChecker.beforeDeref(covMatrix, StorelessBivariateCovariance[].class, 120, 4772, 4780)) {
                covMatrix = CallChecker.beforeCalled(covMatrix, StorelessBivariateCovariance[].class, 120, 4772, 4780);
                CallChecker.isCalled(covMatrix, StorelessBivariateCovariance[].class, 120, 4772, 4780)[indexOf(i, j)] = cov;
                CallChecker.varAssign(CallChecker.isCalled(this.covMatrix, StorelessBivariateCovariance[].class, 120, 4772, 4780)[indexOf(i, j)], "CallChecker.isCalled(this.covMatrix, StorelessBivariateCovariance[].class, 120, 4772, 4780)[indexOf(i, j)]", 120, 4772, 4802);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1049.methodEnd();
        }
    }

    public double getCovariance(final int xIndex, final int yIndex) throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1050 = new MethodContext(double.class, 132, 4815, 5382);
        try {
            CallChecker.varInit(this, "this", 132, 4815, 5382);
            CallChecker.varInit(yIndex, "yIndex", 132, 4815, 5382);
            CallChecker.varInit(xIndex, "xIndex", 132, 4815, 5382);
            CallChecker.varInit(this.dimension, "dimension", 132, 4815, 5382);
            CallChecker.varInit(this.covMatrix, "covMatrix", 132, 4815, 5382);
            final StorelessBivariateCovariance npe_invocation_var117 = getElement(xIndex, yIndex);
            if (CallChecker.beforeDeref(npe_invocation_var117, StorelessBivariateCovariance.class, 136, 5337, 5362)) {
                return CallChecker.isCalled(npe_invocation_var117, StorelessBivariateCovariance.class, 136, 5337, 5362).getResult();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1050.methodEnd();
        }
    }

    public void increment(final double[] data) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1051 = new MethodContext(void.class, 147, 5389, 6198);
        try {
            CallChecker.varInit(this, "this", 147, 5389, 6198);
            CallChecker.varInit(data, "data", 147, 5389, 6198);
            CallChecker.varInit(this.dimension, "dimension", 147, 5389, 6198);
            CallChecker.varInit(this.covMatrix, "covMatrix", 147, 5389, 6198);
            int length = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(data, double[].class, 150, 5766, 5769)) {
                length = CallChecker.isCalled(data, double[].class, 150, 5766, 5769).length;
                CallChecker.varAssign(length, "length", 150, 5766, 5769);
            }
            if (length != (dimension)) {
                throw new DimensionMismatchException(length, dimension);
            }
            for (int i = 0; i < length; i++) {
                for (int j = i; j < length; j++) {
                    if (CallChecker.beforeDeref(data, double[].class, 159, 6150, 6153)) {
                        if (CallChecker.beforeDeref(data, double[].class, 159, 6159, 6162)) {
                            final StorelessBivariateCovariance npe_invocation_var118 = getElement(i, j);
                            if (CallChecker.beforeDeref(npe_invocation_var118, StorelessBivariateCovariance.class, 159, 6123, 6138)) {
                                CallChecker.isCalled(npe_invocation_var118, StorelessBivariateCovariance.class, 159, 6123, 6138).increment(CallChecker.isCalled(data, double[].class, 159, 6150, 6153)[i], CallChecker.isCalled(data, double[].class, 159, 6159, 6162)[j]);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1051.methodEnd();
        }
    }

    public void append(StorelessCovariance sc) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1052 = new MethodContext(void.class, 174, 6205, 7220);
        try {
            CallChecker.varInit(this, "this", 174, 6205, 7220);
            CallChecker.varInit(sc, "sc", 174, 6205, 7220);
            CallChecker.varInit(this.dimension, "dimension", 174, 6205, 7220);
            CallChecker.varInit(this.covMatrix, "covMatrix", 174, 6205, 7220);
            if (CallChecker.beforeDeref(sc, StorelessCovariance.class, 175, 6794, 6795)) {
                sc = CallChecker.beforeCalled(sc, StorelessCovariance.class, 175, 6794, 6795);
                if ((CallChecker.isCalled(sc, StorelessCovariance.class, 175, 6794, 6795).dimension) != (dimension)) {
                    if (CallChecker.beforeDeref(sc, StorelessCovariance.class, 176, 6872, 6873)) {
                        sc = CallChecker.beforeCalled(sc, StorelessCovariance.class, 176, 6872, 6873);
                        throw new DimensionMismatchException(CallChecker.isCalled(sc, StorelessCovariance.class, 176, 6872, 6873).dimension, dimension);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < (dimension); i++) {
                for (int j = i; j < (dimension); j++) {
                    if (CallChecker.beforeDeref(sc, StorelessCovariance.class, 183, 7170, 7171)) {
                        final StorelessBivariateCovariance npe_invocation_var119 = getElement(i, j);
                        if (CallChecker.beforeDeref(npe_invocation_var119, StorelessBivariateCovariance.class, 183, 7146, 7161)) {
                            sc = CallChecker.beforeCalled(sc, StorelessCovariance.class, 183, 7170, 7171);
                            CallChecker.isCalled(npe_invocation_var119, StorelessBivariateCovariance.class, 183, 7146, 7161).append(CallChecker.isCalled(sc, StorelessCovariance.class, 183, 7170, 7171).getElement(i, j));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1052.methodEnd();
        }
    }

    @Override
    public RealMatrix getCovarianceMatrix() throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1053 = new MethodContext(RealMatrix.class, 194, 7227, 7511);
        try {
            CallChecker.varInit(this, "this", 194, 7227, 7511);
            CallChecker.varInit(this.dimension, "dimension", 194, 7227, 7511);
            CallChecker.varInit(this.covMatrix, "covMatrix", 194, 7227, 7511);
            return MatrixUtils.createRealMatrix(getData());
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1053.methodEnd();
        }
    }

    public double[][] getData() throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1054 = new MethodContext(double[][].class, 205, 7518, 8102);
        try {
            CallChecker.varInit(this, "this", 205, 7518, 8102);
            CallChecker.varInit(this.dimension, "dimension", 205, 7518, 8102);
            CallChecker.varInit(this.covMatrix, "covMatrix", 205, 7518, 8102);
            final double[][] data = CallChecker.varInit(new double[dimension][dimension], "data", 206, 7840, 7896);
            for (int i = 0; i < (dimension); i++) {
                for (int j = 0; j < (dimension); j++) {
                    if (CallChecker.beforeDeref(data, double[][].class, 209, 8010, 8013)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i], double[].class, 209, 8010, 8016)) {
                            final StorelessBivariateCovariance npe_invocation_var120 = getElement(i, j);
                            if (CallChecker.beforeDeref(npe_invocation_var120, StorelessBivariateCovariance.class, 209, 8023, 8038)) {
                                CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i], double[].class, 209, 8010, 8016);
                                CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i], double[].class, 209, 8010, 8016)[j] = CallChecker.isCalled(npe_invocation_var120, StorelessBivariateCovariance.class, 209, 8023, 8038).getResult();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i], double[].class, 209, 8010, 8016)[j], "CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 209, 8010, 8013)[i], double[].class, 209, 8010, 8016)[j]", 209, 8010, 8051);
                            }
                        }
                    }
                }
            }
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1054.methodEnd();
        }
    }

    @Override
    public int getN() throws MathUnsupportedOperationException {
        MethodContext _bcornu_methode_context1055 = new MethodContext(int.class, 225, 8109, 8720);
        try {
            CallChecker.varInit(this, "this", 225, 8109, 8720);
            CallChecker.varInit(this.dimension, "dimension", 225, 8109, 8720);
            CallChecker.varInit(this.covMatrix, "covMatrix", 225, 8109, 8720);
            throw new MathUnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1055.methodEnd();
        }
    }
}

