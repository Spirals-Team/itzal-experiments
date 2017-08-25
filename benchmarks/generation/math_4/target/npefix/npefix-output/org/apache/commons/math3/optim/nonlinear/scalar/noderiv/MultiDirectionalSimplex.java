package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.PointValuePair;

public class MultiDirectionalSimplex extends AbstractSimplex {
    private static final double DEFAULT_KHI = 2;

    private static final double DEFAULT_GAMMA = 0.5;

    private final double khi;

    private final double gamma;

    public MultiDirectionalSimplex(final int n) {
        this(n, 1.0);
        ConstructorContext _bcornu_methode_context986 = new ConstructorContext(MultiDirectionalSimplex.class, 46, 1538, 1803);
        try {
        } finally {
            _bcornu_methode_context986.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, double sideLength) {
        this(n, sideLength, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context987 = new ConstructorContext(MultiDirectionalSimplex.class, 58, 1810, 2275);
        try {
        } finally {
            _bcornu_methode_context987.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, final double khi, final double gamma) {
        this(n, 1.0, khi, gamma);
        ConstructorContext _bcornu_methode_context988 = new ConstructorContext(MultiDirectionalSimplex.class, 70, 2282, 2723);
        try {
        } finally {
            _bcornu_methode_context988.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, double sideLength, final double khi, final double gamma) {
        super(n, sideLength);
        ConstructorContext _bcornu_methode_context989 = new ConstructorContext(MultiDirectionalSimplex.class, 85, 2730, 3387);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 89, 3337, 3353);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 90, 3363, 3381);
        } finally {
            _bcornu_methode_context989.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[] steps) {
        this(steps, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context990 = new ConstructorContext(MultiDirectionalSimplex.class, 100, 3394, 3775);
        try {
        } finally {
            _bcornu_methode_context990.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[] steps, final double khi, final double gamma) {
        super(steps);
        ConstructorContext _bcornu_methode_context991 = new ConstructorContext(MultiDirectionalSimplex.class, 113, 3782, 4349);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 117, 4299, 4315);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 118, 4325, 4343);
        } finally {
            _bcornu_methode_context991.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[][] referenceSimplex) {
        this(referenceSimplex, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context992 = new ConstructorContext(MultiDirectionalSimplex.class, 128, 4356, 4754);
        try {
        } finally {
            _bcornu_methode_context992.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[][] referenceSimplex, final double khi, final double gamma) {
        super(referenceSimplex);
        ConstructorContext _bcornu_methode_context993 = new ConstructorContext(MultiDirectionalSimplex.class, 144, 4761, 5578);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 148, 5528, 5544);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 149, 5554, 5572);
        } finally {
            _bcornu_methode_context993.methodEnd();
        }
    }

    @Override
    public void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context4413 = new MethodContext(void.class, 154, 5585, 6826);
        try {
            CallChecker.varInit(this, "this", 154, 5585, 6826);
            CallChecker.varInit(comparator, "comparator", 154, 5585, 6826);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 154, 5585, 6826);
            CallChecker.varInit(this.gamma, "gamma", 154, 5585, 6826);
            CallChecker.varInit(this.khi, "khi", 154, 5585, 6826);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.MultiDirectionalSimplex.DEFAULT_GAMMA", 154, 5585, 6826);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.MultiDirectionalSimplex.DEFAULT_KHI", 154, 5585, 6826);
            final PointValuePair[] original = CallChecker.varInit(getPoints(), "original", 157, 5808, 5853);
            final PointValuePair best = CallChecker.varInit(CallChecker.isCalled(original, PointValuePair[].class, 158, 5891, 5898)[0], "best", 158, 5863, 5902);
            final PointValuePair reflected = CallChecker.varInit(evaluateNewSimplex(evaluationFunction, original, 1, comparator), "reflected", 161, 5913, 6111);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 163, 6125, 6134)) {
                if ((CallChecker.isCalled(comparator, Comparator.class, 163, 6125, 6134).compare(reflected, best)) < 0) {
                    final PointValuePair[] reflectedSimplex = CallChecker.varInit(getPoints(), "reflectedSimplex", 165, 6225, 6278);
                    final PointValuePair expanded = CallChecker.varInit(evaluateNewSimplex(evaluationFunction, original, khi, comparator), "expanded", 166, 6292, 6456);
                    if (CallChecker.beforeDeref(comparator, Comparator.class, 168, 6474, 6483)) {
                        if ((CallChecker.isCalled(comparator, Comparator.class, 168, 6474, 6483).compare(reflected, expanded)) <= 0) {
                            setPoints(reflectedSimplex);
                        }
                    }
                    return ;
                }
            }
            evaluateNewSimplex(evaluationFunction, original, gamma, comparator);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4413.methodEnd();
        }
    }

    private PointValuePair evaluateNewSimplex(final MultivariateFunction evaluationFunction, final PointValuePair[] original, final double coeff, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context4414 = new MethodContext(PointValuePair.class, 193, 6833, 8442);
        try {
            CallChecker.varInit(this, "this", 193, 6833, 8442);
            CallChecker.varInit(comparator, "comparator", 193, 6833, 8442);
            CallChecker.varInit(coeff, "coeff", 193, 6833, 8442);
            CallChecker.varInit(original, "original", 193, 6833, 8442);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 193, 6833, 8442);
            CallChecker.varInit(this.gamma, "gamma", 193, 6833, 8442);
            CallChecker.varInit(this.khi, "khi", 193, 6833, 8442);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.MultiDirectionalSimplex.DEFAULT_GAMMA", 193, 6833, 8442);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.MultiDirectionalSimplex.DEFAULT_KHI", 193, 6833, 8442);
            CallChecker.isCalled(original, PointValuePair[].class, 197, 7716, 7723)[0] = CallChecker.beforeCalled(CallChecker.isCalled(original, PointValuePair[].class, 197, 7716, 7723)[0], PointValuePair.class, 197, 7716, 7726);
            final double[] xSmallest = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(original, PointValuePair[].class, 197, 7716, 7723)[0], PointValuePair.class, 197, 7716, 7726).getPointRef(), "xSmallest", 197, 7689, 7741);
            if (CallChecker.beforeDeref(original, PointValuePair[].class, 200, 7866, 7873)) {
                setPoint(0, CallChecker.isCalled(original, PointValuePair[].class, 200, 7866, 7873)[0]);
            }
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 201, 7888, 7918);
            for (int i = 1; i < (getSize()); i++) {
                CallChecker.isCalled(original, PointValuePair[].class, 203, 8005, 8012)[i] = CallChecker.beforeCalled(CallChecker.isCalled(original, PointValuePair[].class, 203, 8005, 8012)[i], PointValuePair.class, 203, 8005, 8015);
                final double[] xOriginal = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(original, PointValuePair[].class, 203, 8005, 8012)[i], PointValuePair.class, 203, 8005, 8015).getPointRef(), "xOriginal", 203, 7978, 8030);
                final double[] xTransformed = CallChecker.varInit(new double[dim], "xTransformed", 204, 8044, 8089);
                for (int j = 0; j < dim; j++) {
                    if (CallChecker.beforeDeref(xTransformed, double[].class, 206, 8151, 8162)) {
                        if (CallChecker.beforeDeref(xSmallest, double[].class, 206, 8169, 8177)) {
                            if (CallChecker.beforeDeref(xSmallest, double[].class, 206, 8193, 8201)) {
                                if (CallChecker.beforeDeref(xOriginal, double[].class, 206, 8208, 8216)) {
                                    CallChecker.isCalled(xTransformed, double[].class, 206, 8151, 8162)[j] = (CallChecker.isCalled(xSmallest, double[].class, 206, 8169, 8177)[j]) + (coeff * ((CallChecker.isCalled(xSmallest, double[].class, 206, 8193, 8201)[j]) - (CallChecker.isCalled(xOriginal, double[].class, 206, 8208, 8216)[j])));
                                    CallChecker.varAssign(CallChecker.isCalled(xTransformed, double[].class, 206, 8151, 8162)[j], "CallChecker.isCalled(xTransformed, double[].class, 206, 8151, 8162)[j]", 206, 8151, 8221);
                                }
                            }
                        }
                    }
                }
                setPoint(i, new PointValuePair(xTransformed, Double.NaN, false));
            }
            evaluate(evaluationFunction, comparator);
            return getPoint(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4414.methodEnd();
        }
    }
}

