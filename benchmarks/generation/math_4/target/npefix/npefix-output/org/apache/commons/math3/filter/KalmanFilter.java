package org.apache.commons.math3.filter;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.MatrixDimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.util.MathUtils;

public class KalmanFilter {
    private final ProcessModel processModel;

    private final MeasurementModel measurementModel;

    private RealMatrix transitionMatrix;

    private RealMatrix transitionMatrixT;

    private RealMatrix controlMatrix;

    private RealMatrix measurementMatrix;

    private RealMatrix measurementMatrixT;

    private RealVector stateEstimation;

    private RealMatrix errorCovariance;

    public KalmanFilter(final ProcessModel process, final MeasurementModel measurement) throws DimensionMismatchException, NullArgumentException, MatrixDimensionMismatchException, NonSquareMatrixException {
        ConstructorContext _bcornu_methode_context534 = new ConstructorContext(KalmanFilter.class, 121, 4522, 9817);
        try {
            MathUtils.checkNotNull(process);
            MathUtils.checkNotNull(measurement);
            this.processModel = process;
            CallChecker.varAssign(this.processModel, "this.processModel", 128, 5679, 5706);
            this.measurementModel = measurement;
            CallChecker.varAssign(this.measurementModel, "this.measurementModel", 129, 5716, 5751);
            if (CallChecker.beforeDeref(processModel, ProcessModel.class, 131, 5781, 5792)) {
                transitionMatrix = CallChecker.isCalled(processModel, ProcessModel.class, 131, 5781, 5792).getStateTransitionMatrix();
                CallChecker.varAssign(this.transitionMatrix, "this.transitionMatrix", 131, 5762, 5820);
            }
            MathUtils.checkNotNull(transitionMatrix);
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 133, 5900, 5915)) {
                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 133, 5900, 5915);
                transitionMatrixT = CallChecker.isCalled(transitionMatrix, RealMatrix.class, 133, 5900, 5915).transpose();
                CallChecker.varAssign(this.transitionMatrixT, "this.transitionMatrixT", 133, 5880, 5928);
            }
            if (CallChecker.beforeDeref(processModel, ProcessModel.class, 136, 6008, 6019)) {
                if ((CallChecker.isCalled(processModel, ProcessModel.class, 136, 6008, 6019).getControlMatrix()) == null) {
                    controlMatrix = new Array2DRowRealMatrix();
                    CallChecker.varAssign(this.controlMatrix, "this.controlMatrix", 137, 6063, 6105);
                }else {
                    if (CallChecker.beforeDeref(processModel, ProcessModel.class, 139, 6152, 6163)) {
                        controlMatrix = CallChecker.isCalled(processModel, ProcessModel.class, 139, 6152, 6163).getControlMatrix();
                        CallChecker.varAssign(this.controlMatrix, "this.controlMatrix", 139, 6136, 6183);
                    }
                }
            }
            if (CallChecker.beforeDeref(measurementModel, MeasurementModel.class, 142, 6224, 6239)) {
                measurementMatrix = CallChecker.isCalled(measurementModel, MeasurementModel.class, 142, 6224, 6239).getMeasurementMatrix();
                CallChecker.varAssign(this.measurementMatrix, "this.measurementMatrix", 142, 6204, 6263);
            }
            MathUtils.checkNotNull(measurementMatrix);
            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 144, 6345, 6361)) {
                measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 144, 6345, 6361);
                measurementMatrixT = CallChecker.isCalled(measurementMatrix, RealMatrix.class, 144, 6345, 6361).transpose();
                CallChecker.varAssign(this.measurementMatrixT, "this.measurementMatrixT", 144, 6324, 6374);
            }
            RealMatrix processNoise = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(processModel, ProcessModel.class, 149, 6586, 6597)) {
                processNoise = CallChecker.isCalled(processModel, ProcessModel.class, 149, 6586, 6597).getProcessNoise();
                CallChecker.varAssign(processNoise, "processNoise", 149, 6586, 6597);
            }
            MathUtils.checkNotNull(processNoise);
            RealMatrix measNoise = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(measurementModel, MeasurementModel.class, 151, 6695, 6710)) {
                measNoise = CallChecker.isCalled(measurementModel, MeasurementModel.class, 151, 6695, 6710).getMeasurementNoise();
                CallChecker.varAssign(measNoise, "measNoise", 151, 6695, 6710);
            }
            MathUtils.checkNotNull(measNoise);
            if (CallChecker.beforeDeref(processModel, ProcessModel.class, 156, 6907, 6918)) {
                if ((CallChecker.isCalled(processModel, ProcessModel.class, 156, 6907, 6918).getInitialStateEstimate()) == null) {
                    if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 157, 7007, 7022)) {
                        transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 157, 7007, 7022);
                        stateEstimation = new ArrayRealVector(CallChecker.isCalled(transitionMatrix, RealMatrix.class, 157, 7007, 7022).getColumnDimension());
                        CallChecker.varAssign(this.stateEstimation, "this.stateEstimation", 157, 6969, 7045);
                    }
                }else {
                    if (CallChecker.beforeDeref(processModel, ProcessModel.class, 159, 7094, 7105)) {
                        stateEstimation = CallChecker.isCalled(processModel, ProcessModel.class, 159, 7094, 7105).getInitialStateEstimate();
                        CallChecker.varAssign(this.stateEstimation, "this.stateEstimation", 159, 7076, 7132);
                    }
                }
            }
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 162, 7157, 7172)) {
                if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 162, 7198, 7212)) {
                    transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 162, 7157, 7172);
                    stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 162, 7198, 7212);
                    if ((CallChecker.isCalled(transitionMatrix, RealMatrix.class, 162, 7157, 7172).getColumnDimension()) != (CallChecker.isCalled(stateEstimation, RealVector.class, 162, 7198, 7212).getDimension())) {
                        if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 163, 7281, 7296)) {
                            if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 164, 7369, 7383)) {
                                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 163, 7281, 7296);
                                stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 164, 7369, 7383);
                                throw new DimensionMismatchException(CallChecker.isCalled(transitionMatrix, RealMatrix.class, 163, 7281, 7296).getColumnDimension(), CallChecker.isCalled(stateEstimation, RealVector.class, 164, 7369, 7383).getDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(processModel, ProcessModel.class, 169, 7546, 7557)) {
                if ((CallChecker.isCalled(processModel, ProcessModel.class, 169, 7546, 7557).getInitialErrorCovariance()) == null) {
                    if (CallChecker.beforeDeref(processNoise, RealMatrix.class, 170, 7628, 7639)) {
                        processNoise = CallChecker.beforeCalled(processNoise, RealMatrix.class, 170, 7628, 7639);
                        errorCovariance = CallChecker.isCalled(processNoise, RealMatrix.class, 170, 7628, 7639).copy();
                        CallChecker.varAssign(this.errorCovariance, "this.errorCovariance", 170, 7610, 7647);
                    }
                }else {
                    if (CallChecker.beforeDeref(processModel, ProcessModel.class, 172, 7696, 7707)) {
                        errorCovariance = CallChecker.isCalled(processModel, ProcessModel.class, 172, 7696, 7707).getInitialErrorCovariance();
                        CallChecker.varAssign(this.errorCovariance, "this.errorCovariance", 172, 7678, 7736);
                    }
                }
            }
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 178, 7859, 7874)) {
                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 178, 7859, 7874);
                if (!(CallChecker.isCalled(transitionMatrix, RealMatrix.class, 178, 7859, 7874).isSquare())) {
                    if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 180, 7958, 7973)) {
                        if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 181, 8014, 8029)) {
                            transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 180, 7958, 7973);
                            transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 181, 8014, 8029);
                            throw new NonSquareMatrixException(CallChecker.isCalled(transitionMatrix, RealMatrix.class, 180, 7958, 7973).getRowDimension(), CallChecker.isCalled(transitionMatrix, RealMatrix.class, 181, 8014, 8029).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 188, 8304, 8319)) {
                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 188, 8304, 8319);
                if (((((controlMatrix) != null) && ((controlMatrix.getRowDimension()) > 0)) && ((controlMatrix.getColumnDimension()) > 0)) && (((controlMatrix.getRowDimension()) != (CallChecker.isCalled(transitionMatrix, RealMatrix.class, 188, 8304, 8319).getRowDimension())) || ((controlMatrix.getColumnDimension()) != 1))) {
                    if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 192, 8633, 8648)) {
                        transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 192, 8633, 8648);
                        throw new MatrixDimensionMismatchException(controlMatrix.getRowDimension(), controlMatrix.getColumnDimension(), CallChecker.isCalled(transitionMatrix, RealMatrix.class, 192, 8633, 8648).getRowDimension(), 1);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            MatrixUtils.checkAdditionCompatible(transitionMatrix, processNoise);
            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 199, 8875, 8891)) {
                if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 199, 8917, 8932)) {
                    measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 199, 8875, 8891);
                    transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 199, 8917, 8932);
                    if ((CallChecker.isCalled(measurementMatrix, RealMatrix.class, 199, 8875, 8891).getColumnDimension()) != (CallChecker.isCalled(transitionMatrix, RealMatrix.class, 199, 8917, 8932).getRowDimension())) {
                        if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 200, 9010, 9026)) {
                            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 201, 9102, 9118)) {
                                if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 202, 9197, 9213)) {
                                    if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 203, 9289, 9304)) {
                                        measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 200, 9010, 9026);
                                        measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 201, 9102, 9118);
                                        measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 202, 9197, 9213);
                                        transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 203, 9289, 9304);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(measurementMatrix, RealMatrix.class, 200, 9010, 9026).getRowDimension(), CallChecker.isCalled(measurementMatrix, RealMatrix.class, 201, 9102, 9118).getColumnDimension(), CallChecker.isCalled(measurementMatrix, RealMatrix.class, 202, 9197, 9213).getRowDimension(), CallChecker.isCalled(transitionMatrix, RealMatrix.class, 203, 9289, 9304).getRowDimension());
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
            
            if (CallChecker.beforeDeref(measNoise, RealMatrix.class, 207, 9415, 9423)) {
                if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 207, 9446, 9462)) {
                    if (CallChecker.beforeDeref(measNoise, RealMatrix.class, 208, 9497, 9505)) {
                        measNoise = CallChecker.beforeCalled(measNoise, RealMatrix.class, 207, 9415, 9423);
                        measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 207, 9446, 9462);
                        measNoise = CallChecker.beforeCalled(measNoise, RealMatrix.class, 208, 9497, 9505);
                        if (((CallChecker.isCalled(measNoise, RealMatrix.class, 207, 9415, 9423).getRowDimension()) != (CallChecker.isCalled(measurementMatrix, RealMatrix.class, 207, 9446, 9462).getRowDimension())) || ((CallChecker.isCalled(measNoise, RealMatrix.class, 208, 9497, 9505).getColumnDimension()) != 1)) {
                            if (CallChecker.beforeDeref(measNoise, RealMatrix.class, 209, 9591, 9599)) {
                                if (CallChecker.beforeDeref(measNoise, RealMatrix.class, 210, 9675, 9683)) {
                                    if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 211, 9762, 9778)) {
                                        measNoise = CallChecker.beforeCalled(measNoise, RealMatrix.class, 209, 9591, 9599);
                                        measNoise = CallChecker.beforeCalled(measNoise, RealMatrix.class, 210, 9675, 9683);
                                        measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 211, 9762, 9778);
                                        throw new MatrixDimensionMismatchException(CallChecker.isCalled(measNoise, RealMatrix.class, 209, 9591, 9599).getRowDimension(), CallChecker.isCalled(measNoise, RealMatrix.class, 210, 9675, 9683).getColumnDimension(), CallChecker.isCalled(measurementMatrix, RealMatrix.class, 211, 9762, 9778).getRowDimension(), 1);
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
            
        } finally {
            _bcornu_methode_context534.methodEnd();
        }
    }

    public int getStateDimension() {
        MethodContext _bcornu_methode_context2497 = new MethodContext(int.class, 220, 9824, 10027);
        try {
            CallChecker.varInit(this, "this", 220, 9824, 10027);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 220, 9824, 10027);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 220, 9824, 10027);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 220, 9824, 10027);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 220, 9824, 10027);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 220, 9824, 10027);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 220, 9824, 10027);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 220, 9824, 10027);
            CallChecker.varInit(this.measurementModel, "measurementModel", 220, 9824, 10027);
            CallChecker.varInit(this.processModel, "processModel", 220, 9824, 10027);
            if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 221, 9991, 10005)) {
                stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 221, 9991, 10005);
                return CallChecker.isCalled(stateEstimation, RealVector.class, 221, 9991, 10005).getDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2497.methodEnd();
        }
    }

    public int getMeasurementDimension() {
        MethodContext _bcornu_methode_context2498 = new MethodContext(int.class, 229, 10034, 10256);
        try {
            CallChecker.varInit(this, "this", 229, 10034, 10256);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 229, 10034, 10256);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 229, 10034, 10256);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 229, 10034, 10256);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 229, 10034, 10256);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 229, 10034, 10256);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 229, 10034, 10256);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 229, 10034, 10256);
            CallChecker.varInit(this.measurementModel, "measurementModel", 229, 10034, 10256);
            CallChecker.varInit(this.processModel, "processModel", 229, 10034, 10256);
            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 230, 10215, 10231)) {
                measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 230, 10215, 10231);
                return CallChecker.isCalled(measurementMatrix, RealMatrix.class, 230, 10215, 10231).getRowDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2498.methodEnd();
        }
    }

    public double[] getStateEstimation() {
        MethodContext _bcornu_methode_context2499 = new MethodContext(double[].class, 238, 10263, 10466);
        try {
            CallChecker.varInit(this, "this", 238, 10263, 10466);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 238, 10263, 10466);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 238, 10263, 10466);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 238, 10263, 10466);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 238, 10263, 10466);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 238, 10263, 10466);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 238, 10263, 10466);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 238, 10263, 10466);
            CallChecker.varInit(this.measurementModel, "measurementModel", 238, 10263, 10466);
            CallChecker.varInit(this.processModel, "processModel", 238, 10263, 10466);
            if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 239, 10435, 10449)) {
                stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 239, 10435, 10449);
                return CallChecker.isCalled(stateEstimation, RealVector.class, 239, 10435, 10449).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2499.methodEnd();
        }
    }

    public RealVector getStateEstimationVector() {
        MethodContext _bcornu_methode_context2500 = new MethodContext(RealVector.class, 247, 10473, 10691);
        try {
            CallChecker.varInit(this, "this", 247, 10473, 10691);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 247, 10473, 10691);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 247, 10473, 10691);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 247, 10473, 10691);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 247, 10473, 10691);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 247, 10473, 10691);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 247, 10473, 10691);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 247, 10473, 10691);
            CallChecker.varInit(this.measurementModel, "measurementModel", 247, 10473, 10691);
            CallChecker.varInit(this.processModel, "processModel", 247, 10473, 10691);
            if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 248, 10663, 10677)) {
                stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 248, 10663, 10677);
                return CallChecker.isCalled(stateEstimation, RealVector.class, 248, 10663, 10677).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2500.methodEnd();
        }
    }

    public double[][] getErrorCovariance() {
        MethodContext _bcornu_methode_context2501 = new MethodContext(double[][].class, 256, 10698, 10903);
        try {
            CallChecker.varInit(this, "this", 256, 10698, 10903);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 256, 10698, 10903);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 256, 10698, 10903);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 256, 10698, 10903);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 256, 10698, 10903);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 256, 10698, 10903);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 256, 10698, 10903);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 256, 10698, 10903);
            CallChecker.varInit(this.measurementModel, "measurementModel", 256, 10698, 10903);
            CallChecker.varInit(this.processModel, "processModel", 256, 10698, 10903);
            if (CallChecker.beforeDeref(errorCovariance, RealMatrix.class, 257, 10872, 10886)) {
                errorCovariance = CallChecker.beforeCalled(errorCovariance, RealMatrix.class, 257, 10872, 10886);
                return CallChecker.isCalled(errorCovariance, RealMatrix.class, 257, 10872, 10886).getData();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2501.methodEnd();
        }
    }

    public RealMatrix getErrorCovarianceMatrix() {
        MethodContext _bcornu_methode_context2502 = new MethodContext(RealMatrix.class, 265, 10910, 11128);
        try {
            CallChecker.varInit(this, "this", 265, 10910, 11128);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 265, 10910, 11128);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 265, 10910, 11128);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 265, 10910, 11128);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 265, 10910, 11128);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 265, 10910, 11128);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 265, 10910, 11128);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 265, 10910, 11128);
            CallChecker.varInit(this.measurementModel, "measurementModel", 265, 10910, 11128);
            CallChecker.varInit(this.processModel, "processModel", 265, 10910, 11128);
            if (CallChecker.beforeDeref(errorCovariance, RealMatrix.class, 266, 11100, 11114)) {
                errorCovariance = CallChecker.beforeCalled(errorCovariance, RealMatrix.class, 266, 11100, 11114);
                return CallChecker.isCalled(errorCovariance, RealMatrix.class, 266, 11100, 11114).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2502.methodEnd();
        }
    }

    public void predict() {
        MethodContext _bcornu_methode_context2503 = new MethodContext(void.class, 272, 11135, 11281);
        try {
            CallChecker.varInit(this, "this", 272, 11135, 11281);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 272, 11135, 11281);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 272, 11135, 11281);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 272, 11135, 11281);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 272, 11135, 11281);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 272, 11135, 11281);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 272, 11135, 11281);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 272, 11135, 11281);
            CallChecker.varInit(this.measurementModel, "measurementModel", 272, 11135, 11281);
            CallChecker.varInit(this.processModel, "processModel", 272, 11135, 11281);
            predict(((RealVector) (null)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2503.methodEnd();
        }
    }

    public void predict(final double[] u) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2504 = new MethodContext(void.class, 284, 11288, 11662);
        try {
            CallChecker.varInit(this, "this", 284, 11288, 11662);
            CallChecker.varInit(u, "u", 284, 11288, 11662);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 284, 11288, 11662);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 284, 11288, 11662);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 284, 11288, 11662);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 284, 11288, 11662);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 284, 11288, 11662);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 284, 11288, 11662);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 284, 11288, 11662);
            CallChecker.varInit(this.measurementModel, "measurementModel", 284, 11288, 11662);
            CallChecker.varInit(this.processModel, "processModel", 284, 11288, 11662);
            predict(new ArrayRealVector(u));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2504.methodEnd();
        }
    }

    public void predict(final RealVector u) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2505 = new MethodContext(void.class, 296, 11669, 12886);
        try {
            CallChecker.varInit(this, "this", 296, 11669, 12886);
            CallChecker.varInit(u, "u", 296, 11669, 12886);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 296, 11669, 12886);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 296, 11669, 12886);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 296, 11669, 12886);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 296, 11669, 12886);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 296, 11669, 12886);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 296, 11669, 12886);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 296, 11669, 12886);
            CallChecker.varInit(this.measurementModel, "measurementModel", 296, 11669, 12886);
            CallChecker.varInit(this.processModel, "processModel", 296, 11669, 12886);
            if (CallChecker.beforeDeref(controlMatrix, RealMatrix.class, 299, 12084, 12096)) {
                controlMatrix = CallChecker.beforeCalled(controlMatrix, RealMatrix.class, 299, 12084, 12096);
                if ((u != null) && ((u.getDimension()) != (CallChecker.isCalled(controlMatrix, RealMatrix.class, 299, 12084, 12096).getColumnDimension()))) {
                    if (CallChecker.beforeDeref(controlMatrix, RealMatrix.class, 301, 12238, 12250)) {
                        controlMatrix = CallChecker.beforeCalled(controlMatrix, RealMatrix.class, 301, 12238, 12250);
                        throw new DimensionMismatchException(u.getDimension(), CallChecker.isCalled(controlMatrix, RealMatrix.class, 301, 12238, 12250).getColumnDimension());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 306, 12424, 12439)) {
                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 306, 12424, 12439);
                stateEstimation = CallChecker.isCalled(transitionMatrix, RealMatrix.class, 306, 12424, 12439).operate(stateEstimation);
                CallChecker.varAssign(this.stateEstimation, "this.stateEstimation", 306, 12406, 12465);
            }
            if (u != null) {
                if (CallChecker.beforeDeref(controlMatrix, RealMatrix.class, 310, 12591, 12603)) {
                    if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 310, 12571, 12585)) {
                        controlMatrix = CallChecker.beforeCalled(controlMatrix, RealMatrix.class, 310, 12591, 12603);
                        stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 310, 12571, 12585);
                        stateEstimation = CallChecker.isCalled(stateEstimation, RealVector.class, 310, 12571, 12585).add(CallChecker.isCalled(controlMatrix, RealMatrix.class, 310, 12591, 12603).operate(u));
                        CallChecker.varAssign(this.stateEstimation, "this.stateEstimation", 310, 12553, 12616);
                    }
                }
            }
            if (CallChecker.beforeDeref(transitionMatrix, RealMatrix.class, 315, 12740, 12755)) {
                transitionMatrix = CallChecker.beforeCalled(transitionMatrix, RealMatrix.class, 315, 12740, 12755);
                final RealMatrix npe_invocation_var675 = CallChecker.isCalled(transitionMatrix, RealMatrix.class, 315, 12740, 12755).multiply(errorCovariance);
                if (CallChecker.beforeDeref(npe_invocation_var675, RealMatrix.class, 315, 12740, 12781)) {
                    if (CallChecker.beforeDeref(processModel, ProcessModel.class, 317, 12849, 12860)) {
                        final RealMatrix npe_invocation_var676 = CallChecker.isCalled(npe_invocation_var675, RealMatrix.class, 315, 12740, 12781).multiply(transitionMatrixT);
                        if (CallChecker.beforeDeref(npe_invocation_var676, RealMatrix.class, 315, 12740, 12826)) {
                            errorCovariance = CallChecker.isCalled(npe_invocation_var676, RealMatrix.class, 315, 12740, 12826).add(CallChecker.isCalled(processModel, ProcessModel.class, 317, 12849, 12860).getProcessNoise());
                            CallChecker.varAssign(this.errorCovariance, "this.errorCovariance", 315, 12722, 12880);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2505.methodEnd();
        }
    }

    public void correct(final double[] z) throws DimensionMismatchException, NullArgumentException, SingularMatrixException {
        MethodContext _bcornu_methode_context2506 = new MethodContext(void.class, 332, 12893, 13542);
        try {
            CallChecker.varInit(this, "this", 332, 12893, 13542);
            CallChecker.varInit(z, "z", 332, 12893, 13542);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 332, 12893, 13542);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 332, 12893, 13542);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 332, 12893, 13542);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 332, 12893, 13542);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 332, 12893, 13542);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 332, 12893, 13542);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 332, 12893, 13542);
            CallChecker.varInit(this.measurementModel, "measurementModel", 332, 12893, 13542);
            CallChecker.varInit(this.processModel, "processModel", 332, 12893, 13542);
            correct(new ArrayRealVector(z));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2506.methodEnd();
        }
    }

    public void correct(final RealVector z) throws DimensionMismatchException, NullArgumentException, SingularMatrixException {
        MethodContext _bcornu_methode_context2507 = new MethodContext(void.class, 349, 13549, 15762);
        try {
            CallChecker.varInit(this, "this", 349, 13549, 15762);
            CallChecker.varInit(z, "z", 349, 13549, 15762);
            CallChecker.varInit(this.errorCovariance, "errorCovariance", 349, 13549, 15762);
            CallChecker.varInit(this.stateEstimation, "stateEstimation", 349, 13549, 15762);
            CallChecker.varInit(this.measurementMatrixT, "measurementMatrixT", 349, 13549, 15762);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 349, 13549, 15762);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 349, 13549, 15762);
            CallChecker.varInit(this.transitionMatrixT, "transitionMatrixT", 349, 13549, 15762);
            CallChecker.varInit(this.transitionMatrix, "transitionMatrix", 349, 13549, 15762);
            CallChecker.varInit(this.measurementModel, "measurementModel", 349, 13549, 15762);
            CallChecker.varInit(this.processModel, "processModel", 349, 13549, 15762);
            MathUtils.checkNotNull(z);
            if (CallChecker.beforeDeref(z, RealVector.class, 354, 14228, 14228)) {
                if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 354, 14248, 14264)) {
                    measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 354, 14248, 14264);
                    if ((CallChecker.isCalled(z, RealVector.class, 354, 14228, 14228).getDimension()) != (CallChecker.isCalled(measurementMatrix, RealMatrix.class, 354, 14248, 14264).getRowDimension())) {
                        if (CallChecker.beforeDeref(z, RealVector.class, 355, 14336, 14336)) {
                            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 356, 14403, 14419)) {
                                measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 356, 14403, 14419);
                                throw new DimensionMismatchException(CallChecker.isCalled(z, RealVector.class, 355, 14336, 14336).getDimension(), CallChecker.isCalled(measurementMatrix, RealMatrix.class, 356, 14403, 14419).getRowDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            RealMatrix s = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 360, 14510, 14526)) {
                measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 360, 14510, 14526);
                final RealMatrix npe_invocation_var677 = CallChecker.isCalled(measurementMatrix, RealMatrix.class, 360, 14510, 14526).multiply(errorCovariance);
                if (CallChecker.beforeDeref(npe_invocation_var677, RealMatrix.class, 360, 14510, 14552)) {
                    if (CallChecker.beforeDeref(measurementModel, MeasurementModel.class, 362, 14613, 14628)) {
                        final RealMatrix npe_invocation_var678 = CallChecker.isCalled(npe_invocation_var677, RealMatrix.class, 360, 14510, 14552).multiply(measurementMatrixT);
                        if (CallChecker.beforeDeref(npe_invocation_var678, RealMatrix.class, 360, 14510, 14594)) {
                            s = CallChecker.isCalled(npe_invocation_var678, RealMatrix.class, 360, 14510, 14594).add(CallChecker.isCalled(measurementModel, MeasurementModel.class, 362, 14613, 14628).getMeasurementNoise());
                            CallChecker.varAssign(s, "s", 360, 14510, 14526);
                        }
                    }
                }
            }
            DecompositionSolver solver = CallChecker.init(DecompositionSolver.class);
            if (CallChecker.beforeDeref(new CholeskyDecomposition(s), CholeskyDecomposition.class, 367, 14849, 14876)) {
                solver = CallChecker.isCalled(new CholeskyDecomposition(s), CholeskyDecomposition.class, 367, 14849, 14876).getSolver();
                CallChecker.varAssign(solver, "solver", 367, 14849, 14876);
            }
            RealMatrix invertedS = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(solver, DecompositionSolver.class, 368, 14922, 14927)) {
                solver = CallChecker.beforeCalled(solver, DecompositionSolver.class, 368, 14922, 14927);
                invertedS = CallChecker.isCalled(solver, DecompositionSolver.class, 368, 14922, 14927).getInverse();
                CallChecker.varAssign(invertedS, "invertedS", 368, 14922, 14927);
            }
            RealVector innovation = CallChecker.init(RealVector.class);
            if (CallChecker.beforeDeref(measurementMatrix, RealMatrix.class, 371, 15024, 15040)) {
                if (CallChecker.beforeDeref(z, RealVector.class, 371, 15013, 15013)) {
                    measurementMatrix = CallChecker.beforeCalled(measurementMatrix, RealMatrix.class, 371, 15024, 15040);
                    innovation = CallChecker.isCalled(z, RealVector.class, 371, 15013, 15013).subtract(CallChecker.isCalled(measurementMatrix, RealMatrix.class, 371, 15024, 15040).operate(stateEstimation));
                    CallChecker.varAssign(innovation, "innovation", 371, 15024, 15040);
                }
            }
            RealMatrix kalmanGain = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(errorCovariance, RealMatrix.class, 376, 15226, 15240)) {
                errorCovariance = CallChecker.beforeCalled(errorCovariance, RealMatrix.class, 376, 15226, 15240);
                final RealMatrix npe_invocation_var679 = CallChecker.isCalled(errorCovariance, RealMatrix.class, 376, 15226, 15240).multiply(measurementMatrixT);
                if (CallChecker.beforeDeref(npe_invocation_var679, RealMatrix.class, 376, 15226, 15269)) {
                    kalmanGain = CallChecker.isCalled(npe_invocation_var679, RealMatrix.class, 376, 15226, 15269).multiply(invertedS);
                    CallChecker.varAssign(kalmanGain, "kalmanGain", 376, 15226, 15240);
                }
            }
            if (CallChecker.beforeDeref(kalmanGain, RealMatrix.class, 380, 15428, 15437)) {
                if (CallChecker.beforeDeref(stateEstimation, RealVector.class, 380, 15408, 15422)) {
                    kalmanGain = CallChecker.beforeCalled(kalmanGain, RealMatrix.class, 380, 15428, 15437);
                    stateEstimation = CallChecker.beforeCalled(stateEstimation, RealVector.class, 380, 15408, 15422);
                    stateEstimation = CallChecker.isCalled(stateEstimation, RealVector.class, 380, 15408, 15422).add(CallChecker.isCalled(kalmanGain, RealMatrix.class, 380, 15428, 15437).operate(innovation));
                    CallChecker.varAssign(this.stateEstimation, "this.stateEstimation", 380, 15390, 15459);
                }
            }
            RealMatrix identity = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(kalmanGain, RealMatrix.class, 384, 15616, 15625)) {
                kalmanGain = CallChecker.beforeCalled(kalmanGain, RealMatrix.class, 384, 15616, 15625);
                identity = MatrixUtils.createRealIdentityMatrix(CallChecker.isCalled(kalmanGain, RealMatrix.class, 384, 15616, 15625).getRowDimension());
                CallChecker.varAssign(identity, "identity", 384, 15616, 15625);
            }
            if (CallChecker.beforeDeref(kalmanGain, RealMatrix.class, 385, 15691, 15700)) {
                if (CallChecker.beforeDeref(identity, RealMatrix.class, 385, 15673, 15680)) {
                    kalmanGain = CallChecker.beforeCalled(kalmanGain, RealMatrix.class, 385, 15691, 15700);
                    identity = CallChecker.beforeCalled(identity, RealMatrix.class, 385, 15673, 15680);
                    final RealMatrix npe_invocation_var680 = CallChecker.isCalled(identity, RealMatrix.class, 385, 15673, 15680).subtract(CallChecker.isCalled(kalmanGain, RealMatrix.class, 385, 15691, 15700).multiply(measurementMatrix));
                    if (CallChecker.beforeDeref(npe_invocation_var680, RealMatrix.class, 385, 15673, 15729)) {
                        errorCovariance = CallChecker.isCalled(npe_invocation_var680, RealMatrix.class, 385, 15673, 15729).multiply(errorCovariance);
                        CallChecker.varAssign(this.errorCovariance, "this.errorCovariance", 385, 15655, 15756);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2507.methodEnd();
        }
    }
}

