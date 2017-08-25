package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.PointValuePair;

@Deprecated
public class MultiDirectionalSimplex extends AbstractSimplex {
    private static final double DEFAULT_KHI = 2;

    private static final double DEFAULT_GAMMA = 0.5;

    private final double khi;

    private final double gamma;

    public MultiDirectionalSimplex(final int n) {
        this(n, 1.0);
        ConstructorContext _bcornu_methode_context978 = new ConstructorContext(MultiDirectionalSimplex.class, 49, 1596, 1861);
        try {
        } finally {
            _bcornu_methode_context978.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, double sideLength) {
        this(n, sideLength, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context979 = new ConstructorContext(MultiDirectionalSimplex.class, 61, 1868, 2333);
        try {
        } finally {
            _bcornu_methode_context979.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, final double khi, final double gamma) {
        this(n, 1.0, khi, gamma);
        ConstructorContext _bcornu_methode_context980 = new ConstructorContext(MultiDirectionalSimplex.class, 73, 2340, 2781);
        try {
        } finally {
            _bcornu_methode_context980.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final int n, double sideLength, final double khi, final double gamma) {
        super(n, sideLength);
        ConstructorContext _bcornu_methode_context981 = new ConstructorContext(MultiDirectionalSimplex.class, 88, 2788, 3445);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 92, 3395, 3411);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 93, 3421, 3439);
        } finally {
            _bcornu_methode_context981.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[] steps) {
        this(steps, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context982 = new ConstructorContext(MultiDirectionalSimplex.class, 103, 3452, 3833);
        try {
        } finally {
            _bcornu_methode_context982.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[] steps, final double khi, final double gamma) {
        super(steps);
        ConstructorContext _bcornu_methode_context983 = new ConstructorContext(MultiDirectionalSimplex.class, 116, 3840, 4407);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 120, 4357, 4373);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 121, 4383, 4401);
        } finally {
            _bcornu_methode_context983.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[][] referenceSimplex) {
        this(referenceSimplex, MultiDirectionalSimplex.DEFAULT_KHI, MultiDirectionalSimplex.DEFAULT_GAMMA);
        ConstructorContext _bcornu_methode_context984 = new ConstructorContext(MultiDirectionalSimplex.class, 131, 4414, 4812);
        try {
        } finally {
            _bcornu_methode_context984.methodEnd();
        }
    }

    public MultiDirectionalSimplex(final double[][] referenceSimplex, final double khi, final double gamma) {
        super(referenceSimplex);
        ConstructorContext _bcornu_methode_context985 = new ConstructorContext(MultiDirectionalSimplex.class, 147, 4819, 5636);
        try {
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 151, 5586, 5602);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 152, 5612, 5630);
        } finally {
            _bcornu_methode_context985.methodEnd();
        }
    }

    @Override
    public void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context4411 = new MethodContext(void.class, 157, 5643, 6884);
        try {
            CallChecker.varInit(this, "this", 157, 5643, 6884);
            CallChecker.varInit(comparator, "comparator", 157, 5643, 6884);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 157, 5643, 6884);
            CallChecker.varInit(this.gamma, "gamma", 157, 5643, 6884);
            CallChecker.varInit(this.khi, "khi", 157, 5643, 6884);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optimization.direct.MultiDirectionalSimplex.DEFAULT_GAMMA", 157, 5643, 6884);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optimization.direct.MultiDirectionalSimplex.DEFAULT_KHI", 157, 5643, 6884);
            final PointValuePair[] original = CallChecker.varInit(getPoints(), "original", 160, 5866, 5911);
            final PointValuePair best = CallChecker.varInit(CallChecker.isCalled(original, PointValuePair[].class, 161, 5949, 5956)[0], "best", 161, 5921, 5960);
            final PointValuePair reflected = CallChecker.varInit(evaluateNewSimplex(evaluationFunction, original, 1, comparator), "reflected", 164, 5971, 6169);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 166, 6183, 6192)) {
                if ((CallChecker.isCalled(comparator, Comparator.class, 166, 6183, 6192).compare(reflected, best)) < 0) {
                    final PointValuePair[] reflectedSimplex = CallChecker.varInit(getPoints(), "reflectedSimplex", 168, 6283, 6336);
                    final PointValuePair expanded = CallChecker.varInit(evaluateNewSimplex(evaluationFunction, original, khi, comparator), "expanded", 169, 6350, 6514);
                    if (CallChecker.beforeDeref(comparator, Comparator.class, 171, 6532, 6541)) {
                        if ((CallChecker.isCalled(comparator, Comparator.class, 171, 6532, 6541).compare(reflected, expanded)) <= 0) {
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
            _bcornu_methode_context4411.methodEnd();
        }
    }

    private PointValuePair evaluateNewSimplex(final MultivariateFunction evaluationFunction, final PointValuePair[] original, final double coeff, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context4412 = new MethodContext(PointValuePair.class, 196, 6891, 8500);
        try {
            CallChecker.varInit(this, "this", 196, 6891, 8500);
            CallChecker.varInit(comparator, "comparator", 196, 6891, 8500);
            CallChecker.varInit(coeff, "coeff", 196, 6891, 8500);
            CallChecker.varInit(original, "original", 196, 6891, 8500);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 196, 6891, 8500);
            CallChecker.varInit(this.gamma, "gamma", 196, 6891, 8500);
            CallChecker.varInit(this.khi, "khi", 196, 6891, 8500);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optimization.direct.MultiDirectionalSimplex.DEFAULT_GAMMA", 196, 6891, 8500);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optimization.direct.MultiDirectionalSimplex.DEFAULT_KHI", 196, 6891, 8500);
            CallChecker.isCalled(original, PointValuePair[].class, 200, 7774, 7781)[0] = CallChecker.beforeCalled(CallChecker.isCalled(original, PointValuePair[].class, 200, 7774, 7781)[0], PointValuePair.class, 200, 7774, 7784);
            final double[] xSmallest = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(original, PointValuePair[].class, 200, 7774, 7781)[0], PointValuePair.class, 200, 7774, 7784).getPointRef(), "xSmallest", 200, 7747, 7799);
            if (CallChecker.beforeDeref(original, PointValuePair[].class, 203, 7924, 7931)) {
                setPoint(0, CallChecker.isCalled(original, PointValuePair[].class, 203, 7924, 7931)[0]);
            }
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 204, 7946, 7976);
            for (int i = 1; i < (getSize()); i++) {
                CallChecker.isCalled(original, PointValuePair[].class, 206, 8063, 8070)[i] = CallChecker.beforeCalled(CallChecker.isCalled(original, PointValuePair[].class, 206, 8063, 8070)[i], PointValuePair.class, 206, 8063, 8073);
                final double[] xOriginal = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(original, PointValuePair[].class, 206, 8063, 8070)[i], PointValuePair.class, 206, 8063, 8073).getPointRef(), "xOriginal", 206, 8036, 8088);
                final double[] xTransformed = CallChecker.varInit(new double[dim], "xTransformed", 207, 8102, 8147);
                for (int j = 0; j < dim; j++) {
                    if (CallChecker.beforeDeref(xTransformed, double[].class, 209, 8209, 8220)) {
                        if (CallChecker.beforeDeref(xSmallest, double[].class, 209, 8227, 8235)) {
                            if (CallChecker.beforeDeref(xSmallest, double[].class, 209, 8251, 8259)) {
                                if (CallChecker.beforeDeref(xOriginal, double[].class, 209, 8266, 8274)) {
                                    CallChecker.isCalled(xTransformed, double[].class, 209, 8209, 8220)[j] = (CallChecker.isCalled(xSmallest, double[].class, 209, 8227, 8235)[j]) + (coeff * ((CallChecker.isCalled(xSmallest, double[].class, 209, 8251, 8259)[j]) - (CallChecker.isCalled(xOriginal, double[].class, 209, 8266, 8274)[j])));
                                    CallChecker.varAssign(CallChecker.isCalled(xTransformed, double[].class, 209, 8209, 8220)[j], "CallChecker.isCalled(xTransformed, double[].class, 209, 8209, 8220)[j]", 209, 8209, 8279);
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
            _bcornu_methode_context4412.methodEnd();
        }
    }
}

