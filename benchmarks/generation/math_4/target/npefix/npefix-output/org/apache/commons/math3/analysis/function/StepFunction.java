package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathArrays;

public class StepFunction implements UnivariateFunction {
    private final double[] abscissa;

    private final double[] ordinate;

    public StepFunction(double[] x, double[] y) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NullArgumentException {
        ConstructorContext _bcornu_methode_context321 = new ConstructorContext(StepFunction.class, 61, 1563, 3145);
        try {
            if ((x == null) || (y == null)) {
                throw new NullArgumentException();
            }
            if (((x.length) == 0) || ((y.length) == 0)) {
                throw new NoDataException();
            }
            if ((y.length) != (x.length)) {
                throw new DimensionMismatchException(y.length, x.length);
            }
            MathArrays.checkOrder(x);
            abscissa = MathArrays.copyOf(x);
            CallChecker.varAssign(this.abscissa, "this.abscissa", 78, 3067, 3098);
            ordinate = MathArrays.copyOf(y);
            CallChecker.varAssign(this.ordinate, "this.ordinate", 79, 3108, 3139);
        } finally {
            _bcornu_methode_context321.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context1481 = new MethodContext(double.class, 83, 3152, 3767);
        try {
            CallChecker.varInit(this, "this", 83, 3152, 3767);
            CallChecker.varInit(x, "x", 83, 3152, 3767);
            CallChecker.varInit(this.ordinate, "ordinate", 83, 3152, 3767);
            CallChecker.varInit(this.abscissa, "abscissa", 83, 3152, 3767);
            int index = CallChecker.varInit(((int) (Arrays.binarySearch(this.abscissa, x))), "index", 84, 3217, 3261);
            double fx = CallChecker.varInit(((double) (0)), "fx", 85, 3271, 3284);
            if (index < (-1)) {
                if (CallChecker.beforeDeref(ordinate, double[].class, 89, 3407, 3414)) {
                    fx = CallChecker.isCalled(ordinate, double[].class, 89, 3407, 3414)[((-index) - 2)];
                    CallChecker.varAssign(fx, "fx", 89, 3402, 3425);
                }
            }else
                if (index >= 0) {
                    if (CallChecker.beforeDeref(ordinate, double[].class, 92, 3526, 3533)) {
                        fx = CallChecker.isCalled(ordinate, double[].class, 92, 3526, 3533)[index];
                        CallChecker.varAssign(fx, "fx", 92, 3521, 3541);
                    }
                }else {
                    if (CallChecker.beforeDeref(ordinate, double[].class, 96, 3720, 3727)) {
                        fx = CallChecker.isCalled(ordinate, double[].class, 96, 3720, 3727)[0];
                        CallChecker.varAssign(fx, "fx", 96, 3715, 3731);
                    }
                }
            
            return fx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1481.methodEnd();
        }
    }
}

