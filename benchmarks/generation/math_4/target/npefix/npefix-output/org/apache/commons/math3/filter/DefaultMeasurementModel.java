package org.apache.commons.math3.filter;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class DefaultMeasurementModel implements MeasurementModel {
    private RealMatrix measurementMatrix;

    private RealMatrix measurementNoise;

    public DefaultMeasurementModel(final double[][] measMatrix, final double[][] measNoise) throws DimensionMismatchException, NoDataException, NullArgumentException {
        this(new Array2DRowRealMatrix(measMatrix), new Array2DRowRealMatrix(measNoise));
        ConstructorContext _bcornu_methode_context410 = new ConstructorContext(DefaultMeasurementModel.class, 59, 1648, 2540);
        try {
        } finally {
            _bcornu_methode_context410.methodEnd();
        }
    }

    public DefaultMeasurementModel(final RealMatrix measMatrix, final RealMatrix measNoise) {
        ConstructorContext _bcornu_methode_context411 = new ConstructorContext(DefaultMeasurementModel.class, 71, 2547, 3009);
        try {
            this.measurementMatrix = measMatrix;
            CallChecker.varAssign(this.measurementMatrix, "this.measurementMatrix", 72, 2925, 2960);
            this.measurementNoise = measNoise;
            CallChecker.varAssign(this.measurementNoise, "this.measurementNoise", 73, 2970, 3003);
        } finally {
            _bcornu_methode_context411.methodEnd();
        }
    }

    public RealMatrix getMeasurementMatrix() {
        MethodContext _bcornu_methode_context1772 = new MethodContext(RealMatrix.class, 77, 3016, 3122);
        try {
            CallChecker.varInit(this, "this", 77, 3016, 3122);
            CallChecker.varInit(this.measurementNoise, "measurementNoise", 77, 3016, 3122);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 77, 3016, 3122);
            return measurementMatrix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1772.methodEnd();
        }
    }

    public RealMatrix getMeasurementNoise() {
        MethodContext _bcornu_methode_context1773 = new MethodContext(RealMatrix.class, 82, 3129, 3233);
        try {
            CallChecker.varInit(this, "this", 82, 3129, 3233);
            CallChecker.varInit(this.measurementNoise, "measurementNoise", 82, 3129, 3233);
            CallChecker.varInit(this.measurementMatrix, "measurementMatrix", 82, 3129, 3233);
            return measurementNoise;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1773.methodEnd();
        }
    }
}

