package org.apache.commons.math3.analysis.integration.gauss;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;
import static org.apache.commons.math3.util.MathArrays.OrderDirection.INCREASING;

public class GaussIntegrator {
    private final double[] points;

    private final double[] weights;

    public GaussIntegrator(double[] points, double[] weights) throws DimensionMismatchException, NonMonotonicSequenceException {
        ConstructorContext _bcornu_methode_context706 = new ConstructorContext(GaussIntegrator.class, 50, 1480, 2553);
        try {
            if (CallChecker.beforeDeref(points, double[].class, 53, 2205, 2210)) {
                if (CallChecker.beforeDeref(weights, double[].class, 53, 2222, 2228)) {
                    points = CallChecker.beforeCalled(points, double[].class, 53, 2205, 2210);
                    weights = CallChecker.beforeCalled(weights, double[].class, 53, 2222, 2228);
                    if ((CallChecker.isCalled(points, double[].class, 53, 2205, 2210).length) != (CallChecker.isCalled(weights, double[].class, 53, 2222, 2228).length)) {
                        if (CallChecker.beforeDeref(points, double[].class, 54, 2289, 2294)) {
                            if (CallChecker.beforeDeref(weights, double[].class, 55, 2353, 2359)) {
                                points = CallChecker.beforeCalled(points, double[].class, 54, 2289, 2294);
                                weights = CallChecker.beforeCalled(weights, double[].class, 55, 2353, 2359);
                                throw new DimensionMismatchException(CallChecker.isCalled(points, double[].class, 54, 2289, 2294).length, CallChecker.isCalled(weights, double[].class, 55, 2353, 2359).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            MathArrays.checkOrder(points, INCREASING, true, true);
            points = CallChecker.beforeCalled(points, double[].class, 60, 2493, 2498);
            this.points = CallChecker.isCalled(points, double[].class, 60, 2493, 2498).clone();
            CallChecker.varAssign(this.points, "this.points", 60, 2479, 2507);
            weights = CallChecker.beforeCalled(weights, double[].class, 61, 2532, 2538);
            this.weights = CallChecker.isCalled(weights, double[].class, 61, 2532, 2538).clone();
            CallChecker.varAssign(this.weights, "this.weights", 61, 2517, 2547);
        } finally {
            _bcornu_methode_context706.methodEnd();
        }
    }

    public GaussIntegrator(Pair<double[], double[]> pointsAndWeights) throws NonMonotonicSequenceException {
        this(CallChecker.isCalled(pointsAndWeights, Pair.class, 76, 3087, 3102).getFirst(), CallChecker.isCalled(pointsAndWeights, Pair.class, 76, 3116, 3131).getSecond());
        ConstructorContext _bcornu_methode_context707 = new ConstructorContext(GaussIntegrator.class, 74, 2560, 3151);
        try {
        } finally {
            _bcornu_methode_context707.methodEnd();
        }
    }

    public double integrate(UnivariateFunction f) {
        MethodContext _bcornu_methode_context3114 = new MethodContext(double.class, 89, 3158, 3989);
        try {
            CallChecker.varInit(this, "this", 89, 3158, 3989);
            CallChecker.varInit(f, "f", 89, 3158, 3989);
            CallChecker.varInit(this.weights, "weights", 89, 3158, 3989);
            CallChecker.varInit(this.points, "points", 89, 3158, 3989);
            double s = CallChecker.varInit(((double) (0)), "s", 90, 3657, 3669);
            double c = CallChecker.varInit(((double) (0)), "c", 91, 3679, 3691);
            for (int i = 0; i < (CallChecker.isCalled(points, double[].class, 92, 3721, 3726).length); i++) {
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(this.points, double[].class, 93, 3772, 3777)[i])), "x", 93, 3755, 3781);
                final double w = CallChecker.varInit(((double) (CallChecker.isCalled(this.weights, double[].class, 94, 3812, 3818)[i])), "w", 94, 3795, 3822);
                f = CallChecker.beforeCalled(f, UnivariateFunction.class, 95, 3857, 3857);
                final double y = CallChecker.varInit(((double) ((w * (CallChecker.isCalled(f, UnivariateFunction.class, 95, 3857, 3857).value(x))) - c)), "y", 95, 3836, 3871);
                final double t = CallChecker.varInit(((double) (s + y)), "t", 96, 3885, 3907);
                c = (t - s) - y;
                CallChecker.varAssign(c, "c", 97, 3921, 3936);
                s = t;
                CallChecker.varAssign(s, "s", 98, 3950, 3955);
            }
            return s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3114.methodEnd();
        }
    }

    public int getNumberOfPoints() {
        MethodContext _bcornu_methode_context3115 = new MethodContext(int.class, 107, 3996, 4171);
        try {
            CallChecker.varInit(this, "this", 107, 3996, 4171);
            CallChecker.varInit(this.weights, "weights", 107, 3996, 4171);
            CallChecker.varInit(this.points, "points", 107, 3996, 4171);
            if (CallChecker.beforeDeref(points, double[].class, 108, 4152, 4157)) {
                return CallChecker.isCalled(points, double[].class, 108, 4152, 4157).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3115.methodEnd();
        }
    }
}

