package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.FastMath;

public abstract class AbstractMultipleLinearRegression implements MultipleLinearRegression {
    private RealMatrix xMatrix;

    private RealVector yVector;

    private boolean noIntercept = false;

    protected RealMatrix getX() {
        MethodContext _bcornu_methode_context1567 = new MethodContext(RealMatrix.class, 53, 2125, 2233);
        try {
            CallChecker.varInit(this, "this", 53, 2125, 2233);
            CallChecker.varInit(this.noIntercept, "noIntercept", 53, 2125, 2233);
            CallChecker.varInit(this.yVector, "yVector", 53, 2125, 2233);
            CallChecker.varInit(this.xMatrix, "xMatrix", 53, 2125, 2233);
            return xMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1567.methodEnd();
        }
    }

    protected RealVector getY() {
        MethodContext _bcornu_methode_context1568 = new MethodContext(RealVector.class, 60, 2240, 2348);
        try {
            CallChecker.varInit(this, "this", 60, 2240, 2348);
            CallChecker.varInit(this.noIntercept, "noIntercept", 60, 2240, 2348);
            CallChecker.varInit(this.yVector, "yVector", 60, 2240, 2348);
            CallChecker.varInit(this.xMatrix, "xMatrix", 60, 2240, 2348);
            return yVector;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1568.methodEnd();
        }
    }

    public boolean isNoIntercept() {
        MethodContext _bcornu_methode_context1569 = new MethodContext(boolean.class, 68, 2355, 2526);
        try {
            CallChecker.varInit(this, "this", 68, 2355, 2526);
            CallChecker.varInit(this.noIntercept, "noIntercept", 68, 2355, 2526);
            CallChecker.varInit(this.yVector, "yVector", 68, 2355, 2526);
            CallChecker.varInit(this.xMatrix, "xMatrix", 68, 2355, 2526);
            return noIntercept;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1569.methodEnd();
        }
    }

    public void setNoIntercept(boolean noIntercept) {
        MethodContext _bcornu_methode_context1570 = new MethodContext(void.class, 76, 2533, 2753);
        try {
            CallChecker.varInit(this, "this", 76, 2533, 2753);
            CallChecker.varInit(noIntercept, "noIntercept", 76, 2533, 2753);
            CallChecker.varInit(this.noIntercept, "noIntercept", 76, 2533, 2753);
            CallChecker.varInit(this.yVector, "yVector", 76, 2533, 2753);
            CallChecker.varInit(this.xMatrix, "xMatrix", 76, 2533, 2753);
            this.noIntercept = noIntercept;
            CallChecker.varAssign(this.noIntercept, "this.noIntercept", 77, 2717, 2747);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1570.methodEnd();
        }
    }

    public void newSampleData(double[] data, int nobs, int nvars) {
        MethodContext _bcornu_methode_context1571 = new MethodContext(void.class, 115, 2760, 5374);
        try {
            CallChecker.varInit(this, "this", 115, 2760, 5374);
            CallChecker.varInit(nvars, "nvars", 115, 2760, 5374);
            CallChecker.varInit(nobs, "nobs", 115, 2760, 5374);
            CallChecker.varInit(data, "data", 115, 2760, 5374);
            CallChecker.varInit(this.noIntercept, "noIntercept", 115, 2760, 5374);
            CallChecker.varInit(this.yVector, "yVector", 115, 2760, 5374);
            CallChecker.varInit(this.xMatrix, "xMatrix", 115, 2760, 5374);
            if (data == null) {
                throw new NullArgumentException();
            }
            if ((data.length) != (nobs * (nvars + 1))) {
                throw new DimensionMismatchException(data.length, (nobs * (nvars + 1)));
            }
            if (nobs <= nvars) {
                throw new NumberIsTooSmallException(nobs, nvars, false);
            }
            double[] y = CallChecker.varInit(new double[nobs], "y", 125, 4826, 4855);
            int cols = CallChecker.init(int.class);
            if (noIntercept) {
                cols = nvars;
                CallChecker.varAssign(cols, "cols", 126, 4882, 4911);
            }else {
                cols = nvars + 1;
                CallChecker.varAssign(cols, "cols", 126, 4882, 4911);
            }
            double[][] x = CallChecker.varInit(new double[nobs][cols], "x", 127, 4922, 4959);
            int pointer = CallChecker.varInit(((int) (0)), "pointer", 128, 4969, 4984);
            for (int i = 0; i < nobs; i++) {
                if (CallChecker.beforeDeref(y, double[].class, 130, 5039, 5039)) {
                    y = CallChecker.beforeCalled(y, double[].class, 130, 5039, 5039);
                    CallChecker.isCalled(y, double[].class, 130, 5039, 5039)[i] = data[(pointer++)];
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 130, 5039, 5039)[i], "CallChecker.isCalled(y, double[].class, 130, 5039, 5039)[i]", 130, 5039, 5061);
                }
                if (!(noIntercept)) {
                    if (CallChecker.beforeDeref(x, double[][].class, 132, 5111, 5111)) {
                        x = CallChecker.beforeCalled(x, double[][].class, 132, 5111, 5111);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i], double[].class, 132, 5111, 5114)) {
                            x = CallChecker.beforeCalled(x, double[][].class, 132, 5111, 5111);
                            CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i] = CallChecker.beforeCalled(CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i], double[].class, 132, 5111, 5114);
                            CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i], double[].class, 132, 5111, 5114)[0] = 1.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i], double[].class, 132, 5111, 5114)[0], "CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 132, 5111, 5111)[i], double[].class, 132, 5111, 5114)[0]", 132, 5111, 5125);
                        }
                    }
                }
                for (int j = (noIntercept) ? 0 : 1; j < cols; j++) {
                    if (CallChecker.beforeDeref(x, double[][].class, 135, 5220, 5220)) {
                        x = CallChecker.beforeCalled(x, double[][].class, 135, 5220, 5220);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i], double[].class, 135, 5220, 5223)) {
                            x = CallChecker.beforeCalled(x, double[][].class, 135, 5220, 5220);
                            CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i] = CallChecker.beforeCalled(CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i], double[].class, 135, 5220, 5223);
                            CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i], double[].class, 135, 5220, 5223)[j] = data[(pointer++)];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i], double[].class, 135, 5220, 5223)[j], "CallChecker.isCalled(CallChecker.isCalled(x, double[][].class, 135, 5220, 5220)[i], double[].class, 135, 5220, 5223)[j]", 135, 5220, 5245);
                        }
                    }
                }
            }
            this.xMatrix = new Array2DRowRealMatrix(x);
            CallChecker.varAssign(this.xMatrix, "this.xMatrix", 138, 5279, 5321);
            this.yVector = new ArrayRealVector(y);
            CallChecker.varAssign(this.yVector, "this.yVector", 139, 5331, 5368);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1571.methodEnd();
        }
    }

    protected void newYSampleData(double[] y) {
        MethodContext _bcornu_methode_context1572 = new MethodContext(void.class, 149, 5381, 5870);
        try {
            CallChecker.varInit(this, "this", 149, 5381, 5870);
            CallChecker.varInit(y, "y", 149, 5381, 5870);
            CallChecker.varInit(this.noIntercept, "noIntercept", 149, 5381, 5870);
            CallChecker.varInit(this.yVector, "yVector", 149, 5381, 5870);
            CallChecker.varInit(this.xMatrix, "xMatrix", 149, 5381, 5870);
            if (y == null) {
                throw new NullArgumentException();
            }
            if ((y.length) == 0) {
                throw new NoDataException();
            }
            this.yVector = new ArrayRealVector(y);
            CallChecker.varAssign(this.yVector, "this.yVector", 156, 5827, 5864);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1572.methodEnd();
        }
    }

    protected void newXSampleData(double[][] x) {
        MethodContext _bcornu_methode_context1573 = new MethodContext(void.class, 184, 5877, 7714);
        try {
            CallChecker.varInit(this, "this", 184, 5877, 7714);
            CallChecker.varInit(x, "x", 184, 5877, 7714);
            CallChecker.varInit(this.noIntercept, "noIntercept", 184, 5877, 7714);
            CallChecker.varInit(this.yVector, "yVector", 184, 5877, 7714);
            CallChecker.varInit(this.xMatrix, "xMatrix", 184, 5877, 7714);
            if (x == null) {
                throw new NullArgumentException();
            }
            if ((x.length) == 0) {
                throw new NoDataException();
            }
            if (noIntercept) {
                this.xMatrix = new Array2DRowRealMatrix(x, true);
                CallChecker.varAssign(this.xMatrix, "this.xMatrix", 192, 7102, 7150);
            }else {
                x[0] = CallChecker.beforeCalled(x[0], double[].class, 194, 7252, 7255);
                final int nVars = CallChecker.varInit(((int) (CallChecker.isCalled(x[0], double[].class, 194, 7252, 7255).length)), "nVars", 194, 7234, 7263);
                final double[][] xAug = CallChecker.varInit(new double[x.length][nVars + 1], "xAug", 195, 7277, 7332);
                for (int i = 0; i < (x.length); i++) {
                    x = CallChecker.beforeCalled(x, double[][].class, 197, 7403, 7403);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 197, 7403, 7403)[i], double[].class, 197, 7403, 7406)) {
                        x[i] = CallChecker.beforeCalled(x[i], double[].class, 197, 7403, 7406);
                        if ((CallChecker.isCalled(x[i], double[].class, 197, 7403, 7406).length) != nVars) {
                            x = CallChecker.beforeCalled(x, double[][].class, 198, 7484, 7484);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 198, 7484, 7484)[i], double[].class, 198, 7484, 7487)) {
                                x[i] = CallChecker.beforeCalled(x[i], double[].class, 198, 7484, 7487);
                                throw new DimensionMismatchException(CallChecker.isCalled(x[i], double[].class, 198, 7484, 7487).length, nVars);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    if (CallChecker.beforeDeref(xAug, double[][].class, 200, 7539, 7542)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i], double[].class, 200, 7539, 7545)) {
                            CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i] = CallChecker.beforeCalled(CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i], double[].class, 200, 7539, 7545);
                            CallChecker.isCalled(CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i], double[].class, 200, 7539, 7545)[0] = 1.0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i], double[].class, 200, 7539, 7545)[0], "CallChecker.isCalled(CallChecker.isCalled(xAug, double[][].class, 200, 7539, 7542)[i], double[].class, 200, 7539, 7545)[0]", 200, 7539, 7556);
                        }
                    }
                    if (CallChecker.beforeDeref(xAug, double[][].class, 201, 7600, 7603)) {
                        System.arraycopy(x[i], 0, CallChecker.isCalled(xAug, double[][].class, 201, 7600, 7603)[i], 1, nVars);
                    }
                }
                this.xMatrix = new Array2DRowRealMatrix(xAug, false);
                CallChecker.varAssign(this.xMatrix, "this.xMatrix", 203, 7646, 7698);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1573.methodEnd();
        }
    }

    protected void validateSampleData(double[][] x, double[] y) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1574 = new MethodContext(void.class, 225, 7721, 9268);
        try {
            CallChecker.varInit(this, "this", 225, 7721, 9268);
            CallChecker.varInit(y, "y", 225, 7721, 9268);
            CallChecker.varInit(x, "x", 225, 7721, 9268);
            CallChecker.varInit(this.noIntercept, "noIntercept", 225, 7721, 9268);
            CallChecker.varInit(this.yVector, "yVector", 225, 7721, 9268);
            CallChecker.varInit(this.xMatrix, "xMatrix", 225, 7721, 9268);
            if ((x == null) || (y == null)) {
                throw new NullArgumentException();
            }
            if ((x.length) != (y.length)) {
                throw new DimensionMismatchException(y.length, x.length);
            }
            if ((x.length) == 0) {
                throw new NoDataException();
            }
            x = CallChecker.beforeCalled(x, double[][].class, 235, 9049, 9049);
            if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 235, 9049, 9049)[0], double[].class, 235, 9049, 9052)) {
                x[0] = CallChecker.beforeCalled(x[0], double[].class, 235, 9049, 9052);
                if (((CallChecker.isCalled(x[0], double[].class, 235, 9049, 9052).length) + 1) > (x.length)) {
                    x = CallChecker.beforeCalled(x, double[][].class, 238, 9240, 9240);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 238, 9240, 9240)[0], double[].class, 238, 9240, 9243)) {
                        x[0] = CallChecker.beforeCalled(x[0], double[].class, 238, 9240, 9243);
                        throw new MathIllegalArgumentException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, x.length, CallChecker.isCalled(x[0], double[].class, 238, 9240, 9243).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1574.methodEnd();
        }
    }

    protected void validateCovarianceData(double[][] x, double[][] covariance) {
        MethodContext _bcornu_methode_context1575 = new MethodContext(void.class, 252, 9275, 10165);
        try {
            CallChecker.varInit(this, "this", 252, 9275, 10165);
            CallChecker.varInit(covariance, "covariance", 252, 9275, 10165);
            CallChecker.varInit(x, "x", 252, 9275, 10165);
            CallChecker.varInit(this.noIntercept, "noIntercept", 252, 9275, 10165);
            CallChecker.varInit(this.yVector, "yVector", 252, 9275, 10165);
            CallChecker.varInit(this.xMatrix, "xMatrix", 252, 9275, 10165);
            if (CallChecker.beforeDeref(x, double[][].class, 253, 9858, 9858)) {
                if (CallChecker.beforeDeref(covariance, double[][].class, 253, 9870, 9879)) {
                    x = CallChecker.beforeCalled(x, double[][].class, 253, 9858, 9858);
                    covariance = CallChecker.beforeCalled(covariance, double[][].class, 253, 9870, 9879);
                    if ((CallChecker.isCalled(x, double[][].class, 253, 9858, 9858).length) != (CallChecker.isCalled(covariance, double[][].class, 253, 9870, 9879).length)) {
                        if (CallChecker.beforeDeref(x, double[][].class, 254, 9940, 9940)) {
                            if (CallChecker.beforeDeref(covariance, double[][].class, 254, 9950, 9959)) {
                                x = CallChecker.beforeCalled(x, double[][].class, 254, 9940, 9940);
                                covariance = CallChecker.beforeCalled(covariance, double[][].class, 254, 9950, 9959);
                                throw new DimensionMismatchException(CallChecker.isCalled(x, double[][].class, 254, 9940, 9940).length, CallChecker.isCalled(covariance, double[][].class, 254, 9950, 9959).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(covariance, double[][].class, 256, 9992, 10001)) {
                if (CallChecker.beforeDeref(covariance, double[][].class, 256, 10017, 10026)) {
                    if (CallChecker.beforeDeref(covariance, double[][].class, 256, 10038, 10047)) {
                        covariance = CallChecker.beforeCalled(covariance, double[][].class, 256, 10038, 10047);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(covariance, double[][].class, 256, 10038, 10047)[0], double[].class, 256, 10038, 10050)) {
                            covariance = CallChecker.beforeCalled(covariance, double[][].class, 256, 9992, 10001);
                            covariance = CallChecker.beforeCalled(covariance, double[][].class, 256, 10017, 10026);
                            covariance = CallChecker.beforeCalled(covariance, double[][].class, 256, 10038, 10047);
                            CallChecker.isCalled(covariance, double[][].class, 256, 10038, 10047)[0] = CallChecker.beforeCalled(CallChecker.isCalled(covariance, double[][].class, 256, 10038, 10047)[0], double[].class, 256, 10038, 10050);
                            if (((CallChecker.isCalled(covariance, double[][].class, 256, 9992, 10001).length) > 0) && ((CallChecker.isCalled(covariance, double[][].class, 256, 10017, 10026).length) != (CallChecker.isCalled(CallChecker.isCalled(covariance, double[][].class, 256, 10038, 10047)[0], double[].class, 256, 10038, 10050).length))) {
                                if (CallChecker.beforeDeref(covariance, double[][].class, 257, 10109, 10118)) {
                                    if (CallChecker.beforeDeref(covariance, double[][].class, 257, 10128, 10137)) {
                                        covariance = CallChecker.beforeCalled(covariance, double[][].class, 257, 10128, 10137);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(covariance, double[][].class, 257, 10128, 10137)[0], double[].class, 257, 10128, 10140)) {
                                            covariance = CallChecker.beforeCalled(covariance, double[][].class, 257, 10109, 10118);
                                            covariance = CallChecker.beforeCalled(covariance, double[][].class, 257, 10128, 10137);
                                            CallChecker.isCalled(covariance, double[][].class, 257, 10128, 10137)[0] = CallChecker.beforeCalled(CallChecker.isCalled(covariance, double[][].class, 257, 10128, 10137)[0], double[].class, 257, 10128, 10140);
                                            throw new NonSquareMatrixException(CallChecker.isCalled(covariance, double[][].class, 257, 10109, 10118).length, CallChecker.isCalled(CallChecker.isCalled(covariance, double[][].class, 257, 10128, 10137)[0], double[].class, 257, 10128, 10140).length);
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
            _bcornu_methode_context1575.methodEnd();
        }
    }

    public double[] estimateRegressionParameters() {
        MethodContext _bcornu_methode_context1576 = new MethodContext(double[].class, 264, 10172, 10330);
        try {
            CallChecker.varInit(this, "this", 264, 10172, 10330);
            CallChecker.varInit(this.noIntercept, "noIntercept", 264, 10172, 10330);
            CallChecker.varInit(this.yVector, "yVector", 264, 10172, 10330);
            CallChecker.varInit(this.xMatrix, "xMatrix", 264, 10172, 10330);
            RealVector b = CallChecker.varInit(calculateBeta(), "b", 265, 10266, 10296);
            if (CallChecker.beforeDeref(b, RealVector.class, 266, 10313, 10313)) {
                b = CallChecker.beforeCalled(b, RealVector.class, 266, 10313, 10313);
                return CallChecker.isCalled(b, RealVector.class, 266, 10313, 10313).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1576.methodEnd();
        }
    }

    public double[] estimateResiduals() {
        MethodContext _bcornu_methode_context1577 = new MethodContext(double[].class, 272, 10337, 10545);
        try {
            CallChecker.varInit(this, "this", 272, 10337, 10545);
            CallChecker.varInit(this.noIntercept, "noIntercept", 272, 10337, 10545);
            CallChecker.varInit(this.yVector, "yVector", 272, 10337, 10545);
            CallChecker.varInit(this.xMatrix, "xMatrix", 272, 10337, 10545);
            RealVector b = CallChecker.varInit(calculateBeta(), "b", 273, 10420, 10450);
            RealVector e = CallChecker.init(RealVector.class);
            if (CallChecker.beforeDeref(xMatrix, RealMatrix.class, 274, 10492, 10498)) {
                if (CallChecker.beforeDeref(yVector, RealVector.class, 274, 10475, 10481)) {
                    xMatrix = CallChecker.beforeCalled(xMatrix, RealMatrix.class, 274, 10492, 10498);
                    yVector = CallChecker.beforeCalled(yVector, RealVector.class, 274, 10475, 10481);
                    e = CallChecker.isCalled(yVector, RealVector.class, 274, 10475, 10481).subtract(CallChecker.isCalled(xMatrix, RealMatrix.class, 274, 10492, 10498).operate(b));
                    CallChecker.varAssign(e, "e", 274, 10492, 10498);
                }
            }
            if (CallChecker.beforeDeref(e, RealVector.class, 275, 10528, 10528)) {
                e = CallChecker.beforeCalled(e, RealVector.class, 275, 10528, 10528);
                return CallChecker.isCalled(e, RealVector.class, 275, 10528, 10528).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1577.methodEnd();
        }
    }

    public double[][] estimateRegressionParametersVariance() {
        MethodContext _bcornu_methode_context1578 = new MethodContext(double[][].class, 281, 10552, 10702);
        try {
            CallChecker.varInit(this, "this", 281, 10552, 10702);
            CallChecker.varInit(this.noIntercept, "noIntercept", 281, 10552, 10702);
            CallChecker.varInit(this.yVector, "yVector", 281, 10552, 10702);
            CallChecker.varInit(this.xMatrix, "xMatrix", 281, 10552, 10702);
            final RealMatrix npe_invocation_var138 = calculateBetaVariance();
            if (CallChecker.beforeDeref(npe_invocation_var138, RealMatrix.class, 282, 10663, 10685)) {
                return CallChecker.isCalled(npe_invocation_var138, RealMatrix.class, 282, 10663, 10685).getData();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1578.methodEnd();
        }
    }

    public double[] estimateRegressionParametersStandardErrors() {
        MethodContext _bcornu_methode_context1579 = new MethodContext(double[].class, 288, 10709, 11170);
        try {
            CallChecker.varInit(this, "this", 288, 10709, 11170);
            CallChecker.varInit(this.noIntercept, "noIntercept", 288, 10709, 11170);
            CallChecker.varInit(this.yVector, "yVector", 288, 10709, 11170);
            CallChecker.varInit(this.xMatrix, "xMatrix", 288, 10709, 11170);
            double[][] betaVariance = CallChecker.varInit(estimateRegressionParametersVariance(), "betaVariance", 289, 10817, 10881);
            double sigma = CallChecker.varInit(((double) (calculateErrorVariance())), "sigma", 290, 10891, 10930);
            int length = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(betaVariance, double[][].class, 291, 10953, 10964)) {
                betaVariance = CallChecker.beforeCalled(betaVariance, double[][].class, 291, 10953, 10964);
                if (CallChecker.beforeDeref(CallChecker.isCalled(betaVariance, double[][].class, 291, 10953, 10964)[0], double[].class, 291, 10953, 10967)) {
                    betaVariance = CallChecker.beforeCalled(betaVariance, double[][].class, 291, 10953, 10964);
                    CallChecker.isCalled(betaVariance, double[][].class, 291, 10953, 10964)[0] = CallChecker.beforeCalled(CallChecker.isCalled(betaVariance, double[][].class, 291, 10953, 10964)[0], double[].class, 291, 10953, 10967);
                    length = CallChecker.isCalled(CallChecker.isCalled(betaVariance, double[][].class, 291, 10953, 10964)[0], double[].class, 291, 10953, 10967).length;
                    CallChecker.varAssign(length, "length", 291, 10953, 10964);
                }
            }
            double[] result = CallChecker.varInit(new double[length], "result", 292, 10985, 11021);
            for (int i = 0; i < length; i++) {
                if (CallChecker.beforeDeref(result, double[].class, 294, 11078, 11083)) {
                    if (CallChecker.beforeDeref(betaVariance, double[][].class, 294, 11112, 11123)) {
                        betaVariance = CallChecker.beforeCalled(betaVariance, double[][].class, 294, 11112, 11123);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(betaVariance, double[][].class, 294, 11112, 11123)[i], double[].class, 294, 11112, 11126)) {
                            result = CallChecker.beforeCalled(result, double[].class, 294, 11078, 11083);
                            betaVariance = CallChecker.beforeCalled(betaVariance, double[][].class, 294, 11112, 11123);
                            CallChecker.isCalled(betaVariance, double[][].class, 294, 11112, 11123)[i] = CallChecker.beforeCalled(CallChecker.isCalled(betaVariance, double[][].class, 294, 11112, 11123)[i], double[].class, 294, 11112, 11126);
                            CallChecker.isCalled(result, double[].class, 294, 11078, 11083)[i] = FastMath.sqrt((sigma * (CallChecker.isCalled(CallChecker.isCalled(betaVariance, double[][].class, 294, 11112, 11123)[i], double[].class, 294, 11112, 11126)[i])));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 294, 11078, 11083)[i], "CallChecker.isCalled(result, double[].class, 294, 11078, 11083)[i]", 294, 11078, 11131);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1579.methodEnd();
        }
    }

    public double estimateRegressandVariance() {
        MethodContext _bcornu_methode_context1580 = new MethodContext(double.class, 302, 11177, 11300);
        try {
            CallChecker.varInit(this, "this", 302, 11177, 11300);
            CallChecker.varInit(this.noIntercept, "noIntercept", 302, 11177, 11300);
            CallChecker.varInit(this.yVector, "yVector", 302, 11177, 11300);
            CallChecker.varInit(this.xMatrix, "xMatrix", 302, 11177, 11300);
            return calculateYVariance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1580.methodEnd();
        }
    }

    public double estimateErrorVariance() {
        MethodContext _bcornu_methode_context1581 = new MethodContext(double.class, 312, 11307, 11524);
        try {
            CallChecker.varInit(this, "this", 312, 11307, 11524);
            CallChecker.varInit(this.noIntercept, "noIntercept", 312, 11307, 11524);
            CallChecker.varInit(this.yVector, "yVector", 312, 11307, 11524);
            CallChecker.varInit(this.xMatrix, "xMatrix", 312, 11307, 11524);
            return calculateErrorVariance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1581.methodEnd();
        }
    }

    public double estimateRegressionStandardError() {
        MethodContext _bcornu_methode_context1582 = new MethodContext(double.class, 323, 11531, 11773);
        try {
            CallChecker.varInit(this, "this", 323, 11531, 11773);
            CallChecker.varInit(this.noIntercept, "noIntercept", 323, 11531, 11773);
            CallChecker.varInit(this.yVector, "yVector", 323, 11531, 11773);
            CallChecker.varInit(this.xMatrix, "xMatrix", 323, 11531, 11773);
            return Math.sqrt(estimateErrorVariance());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1582.methodEnd();
        }
    }

    protected abstract RealVector calculateBeta();

    protected abstract RealMatrix calculateBetaVariance();

    protected double calculateYVariance() {
        MethodContext _bcornu_methode_context1585 = new MethodContext(double.class, 348, 12158, 12358);
        try {
            CallChecker.varInit(this, "this", 348, 12158, 12358);
            CallChecker.varInit(this.noIntercept, "noIntercept", 348, 12158, 12358);
            CallChecker.varInit(this.yVector, "yVector", 348, 12158, 12358);
            CallChecker.varInit(this.xMatrix, "xMatrix", 348, 12158, 12358);
            if (CallChecker.beforeDeref(yVector, RealVector.class, 349, 12334, 12340)) {
                if (CallChecker.beforeDeref(new Variance(), Variance.class, 349, 12310, 12323)) {
                    yVector = CallChecker.beforeCalled(yVector, RealVector.class, 349, 12334, 12340);
                    return CallChecker.isCalled(new Variance(), Variance.class, 349, 12310, 12323).evaluate(CallChecker.isCalled(yVector, RealVector.class, 349, 12334, 12340).toArray());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1585.methodEnd();
        }
    }

    protected double calculateErrorVariance() {
        MethodContext _bcornu_methode_context1586 = new MethodContext(double.class, 363, 12365, 12896);
        try {
            CallChecker.varInit(this, "this", 363, 12365, 12896);
            CallChecker.varInit(this.noIntercept, "noIntercept", 363, 12365, 12896);
            CallChecker.varInit(this.yVector, "yVector", 363, 12365, 12896);
            CallChecker.varInit(this.xMatrix, "xMatrix", 363, 12365, 12896);
            RealVector residuals = CallChecker.varInit(calculateResiduals(), "residuals", 364, 12723, 12766);
            residuals = CallChecker.beforeCalled(residuals, RealVector.class, 365, 12783, 12791);
            xMatrix = CallChecker.beforeCalled(xMatrix, RealMatrix.class, 366, 12833, 12839);
            xMatrix = CallChecker.beforeCalled(xMatrix, RealMatrix.class, 366, 12861, 12867);
            return (CallChecker.isCalled(residuals, RealVector.class, 365, 12783, 12791).dotProduct(residuals)) / ((CallChecker.isCalled(xMatrix, RealMatrix.class, 366, 12833, 12839).getRowDimension()) - (CallChecker.isCalled(xMatrix, RealMatrix.class, 366, 12861, 12867).getColumnDimension()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1586.methodEnd();
        }
    }

    protected RealVector calculateResiduals() {
        MethodContext _bcornu_methode_context1587 = new MethodContext(RealVector.class, 379, 12903, 13253);
        try {
            CallChecker.varInit(this, "this", 379, 12903, 13253);
            CallChecker.varInit(this.noIntercept, "noIntercept", 379, 12903, 13253);
            CallChecker.varInit(this.yVector, "yVector", 379, 12903, 13253);
            CallChecker.varInit(this.xMatrix, "xMatrix", 379, 12903, 13253);
            RealVector b = CallChecker.varInit(calculateBeta(), "b", 380, 13164, 13194);
            if (CallChecker.beforeDeref(xMatrix, RealMatrix.class, 381, 13228, 13234)) {
                if (CallChecker.beforeDeref(yVector, RealVector.class, 381, 13211, 13217)) {
                    xMatrix = CallChecker.beforeCalled(xMatrix, RealMatrix.class, 381, 13228, 13234);
                    yVector = CallChecker.beforeCalled(yVector, RealVector.class, 381, 13211, 13217);
                    return CallChecker.isCalled(yVector, RealVector.class, 381, 13211, 13217).subtract(CallChecker.isCalled(xMatrix, RealMatrix.class, 381, 13228, 13234).operate(b));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1587.methodEnd();
        }
    }
}

