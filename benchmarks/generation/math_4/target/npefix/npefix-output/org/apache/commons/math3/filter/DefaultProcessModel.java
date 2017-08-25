package org.apache.commons.math3.filter;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class DefaultProcessModel implements ProcessModel {
    private RealMatrix stateTransitionMatrix;

    private RealMatrix controlMatrix;

    private RealMatrix processNoiseCovMatrix;

    private RealVector initialStateEstimateVector;

    private RealMatrix initialErrorCovMatrix;

    public DefaultProcessModel(final double[][] stateTransition, final double[][] control, final double[][] processNoise, final double[] initialStateEstimate, final double[][] initialErrorCovariance) throws DimensionMismatchException, NoDataException, NullArgumentException {
        this(new Array2DRowRealMatrix(stateTransition), new Array2DRowRealMatrix(control), new Array2DRowRealMatrix(processNoise), new ArrayRealVector(initialStateEstimate), new Array2DRowRealMatrix(initialErrorCovariance));
        ConstructorContext _bcornu_methode_context729 = new ConstructorContext(DefaultProcessModel.class, 73, 2092, 3602);
        try {
        } finally {
            _bcornu_methode_context729.methodEnd();
        }
    }

    public DefaultProcessModel(final double[][] stateTransition, final double[][] control, final double[][] processNoise) throws DimensionMismatchException, NoDataException, NullArgumentException {
        this(new Array2DRowRealMatrix(stateTransition), new Array2DRowRealMatrix(control), new Array2DRowRealMatrix(processNoise), null, null);
        ConstructorContext _bcornu_methode_context730 = new ConstructorContext(DefaultProcessModel.class, 106, 3609, 4844);
        try {
        } finally {
            _bcornu_methode_context730.methodEnd();
        }
    }

    public DefaultProcessModel(final RealMatrix stateTransition, final RealMatrix control, final RealMatrix processNoise, final RealVector initialStateEstimate, final RealMatrix initialErrorCovariance) {
        ConstructorContext _bcornu_methode_context731 = new ConstructorContext(DefaultProcessModel.class, 130, 4851, 5937);
        try {
            this.stateTransitionMatrix = stateTransition;
            CallChecker.varAssign(this.stateTransitionMatrix, "this.stateTransitionMatrix", 135, 5673, 5717);
            this.controlMatrix = control;
            CallChecker.varAssign(this.controlMatrix, "this.controlMatrix", 136, 5727, 5755);
            this.processNoiseCovMatrix = processNoise;
            CallChecker.varAssign(this.processNoiseCovMatrix, "this.processNoiseCovMatrix", 137, 5765, 5806);
            this.initialStateEstimateVector = initialStateEstimate;
            CallChecker.varAssign(this.initialStateEstimateVector, "this.initialStateEstimateVector", 138, 5816, 5870);
            this.initialErrorCovMatrix = initialErrorCovariance;
            CallChecker.varAssign(this.initialErrorCovMatrix, "this.initialErrorCovMatrix", 139, 5880, 5931);
        } finally {
            _bcornu_methode_context731.methodEnd();
        }
    }

    public RealMatrix getStateTransitionMatrix() {
        MethodContext _bcornu_methode_context3288 = new MethodContext(RealMatrix.class, 143, 5944, 6058);
        try {
            CallChecker.varInit(this, "this", 143, 5944, 6058);
            CallChecker.varInit(this.initialErrorCovMatrix, "initialErrorCovMatrix", 143, 5944, 6058);
            CallChecker.varInit(this.initialStateEstimateVector, "initialStateEstimateVector", 143, 5944, 6058);
            CallChecker.varInit(this.processNoiseCovMatrix, "processNoiseCovMatrix", 143, 5944, 6058);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 143, 5944, 6058);
            CallChecker.varInit(this.stateTransitionMatrix, "stateTransitionMatrix", 143, 5944, 6058);
            return stateTransitionMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3288.methodEnd();
        }
    }

    public RealMatrix getControlMatrix() {
        MethodContext _bcornu_methode_context3289 = new MethodContext(RealMatrix.class, 148, 6065, 6163);
        try {
            CallChecker.varInit(this, "this", 148, 6065, 6163);
            CallChecker.varInit(this.initialErrorCovMatrix, "initialErrorCovMatrix", 148, 6065, 6163);
            CallChecker.varInit(this.initialStateEstimateVector, "initialStateEstimateVector", 148, 6065, 6163);
            CallChecker.varInit(this.processNoiseCovMatrix, "processNoiseCovMatrix", 148, 6065, 6163);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 148, 6065, 6163);
            CallChecker.varInit(this.stateTransitionMatrix, "stateTransitionMatrix", 148, 6065, 6163);
            return controlMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3289.methodEnd();
        }
    }

    public RealMatrix getProcessNoise() {
        MethodContext _bcornu_methode_context3290 = new MethodContext(RealMatrix.class, 153, 6170, 6275);
        try {
            CallChecker.varInit(this, "this", 153, 6170, 6275);
            CallChecker.varInit(this.initialErrorCovMatrix, "initialErrorCovMatrix", 153, 6170, 6275);
            CallChecker.varInit(this.initialStateEstimateVector, "initialStateEstimateVector", 153, 6170, 6275);
            CallChecker.varInit(this.processNoiseCovMatrix, "processNoiseCovMatrix", 153, 6170, 6275);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 153, 6170, 6275);
            CallChecker.varInit(this.stateTransitionMatrix, "stateTransitionMatrix", 153, 6170, 6275);
            return processNoiseCovMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3290.methodEnd();
        }
    }

    public RealVector getInitialStateEstimate() {
        MethodContext _bcornu_methode_context3291 = new MethodContext(RealVector.class, 158, 6282, 6400);
        try {
            CallChecker.varInit(this, "this", 158, 6282, 6400);
            CallChecker.varInit(this.initialErrorCovMatrix, "initialErrorCovMatrix", 158, 6282, 6400);
            CallChecker.varInit(this.initialStateEstimateVector, "initialStateEstimateVector", 158, 6282, 6400);
            CallChecker.varInit(this.processNoiseCovMatrix, "processNoiseCovMatrix", 158, 6282, 6400);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 158, 6282, 6400);
            CallChecker.varInit(this.stateTransitionMatrix, "stateTransitionMatrix", 158, 6282, 6400);
            return initialStateEstimateVector;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3291.methodEnd();
        }
    }

    public RealMatrix getInitialErrorCovariance() {
        MethodContext _bcornu_methode_context3292 = new MethodContext(RealMatrix.class, 163, 6407, 6522);
        try {
            CallChecker.varInit(this, "this", 163, 6407, 6522);
            CallChecker.varInit(this.initialErrorCovMatrix, "initialErrorCovMatrix", 163, 6407, 6522);
            CallChecker.varInit(this.initialStateEstimateVector, "initialStateEstimateVector", 163, 6407, 6522);
            CallChecker.varInit(this.processNoiseCovMatrix, "processNoiseCovMatrix", 163, 6407, 6522);
            CallChecker.varInit(this.controlMatrix, "controlMatrix", 163, 6407, 6522);
            CallChecker.varInit(this.stateTransitionMatrix, "stateTransitionMatrix", 163, 6407, 6522);
            return initialErrorCovMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3292.methodEnd();
        }
    }
}

