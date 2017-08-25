package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.PointValuePair;

public class NelderMeadSimplex extends AbstractSimplex {
    private static final double DEFAULT_RHO = 1;

    private static final double DEFAULT_KHI = 2;

    private static final double DEFAULT_GAMMA = 0.5;

    private static final double DEFAULT_SIGMA = 0.5;

    private final double rho;

    private final double khi;

    private final double gamma;

    private final double sigma;

    public NelderMeadSimplex(final int n) {
        this(n, 1.0);
        ConstructorContext _bcornu_methode_context30 = new ConstructorContext(NelderMeadSimplex.class, 55, 1864, 2158);
        try {
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, double sideLength) {
        this(n, sideLength, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context31 = new ConstructorContext(NelderMeadSimplex.class, 68, 2165, 2700);
        try {
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, double sideLength, final double rho, final double khi, final double gamma, final double sigma) {
        super(n, sideLength);
        ConstructorContext _bcornu_methode_context32 = new ConstructorContext(NelderMeadSimplex.class, 85, 2707, 3548);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 90, 3448, 3462);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 91, 3472, 3486);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 92, 3496, 3514);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 93, 3524, 3542);
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, final double rho, final double khi, final double gamma, final double sigma) {
        this(n, 1.0, rho, khi, gamma, sigma);
        ConstructorContext _bcornu_methode_context33 = new ConstructorContext(NelderMeadSimplex.class, 106, 3555, 4135);
        try {
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[] steps) {
        this(steps, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context34 = new ConstructorContext(NelderMeadSimplex.class, 120, 4142, 4580);
        try {
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[] steps, final double rho, final double khi, final double gamma, final double sigma) {
        super(steps);
        ConstructorContext _bcornu_methode_context35 = new ConstructorContext(NelderMeadSimplex.class, 136, 4587, 5407);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 141, 5307, 5321);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 142, 5331, 5345);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 143, 5355, 5373);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 144, 5383, 5401);
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[][] referenceSimplex) {
        this(referenceSimplex, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context36 = new ConstructorContext(NelderMeadSimplex.class, 155, 5414, 5869);
        try {
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[][] referenceSimplex, final double rho, final double khi, final double gamma, final double sigma) {
        super(referenceSimplex);
        ConstructorContext _bcornu_methode_context37 = new ConstructorContext(NelderMeadSimplex.class, 173, 5876, 6877);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 178, 6777, 6791);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 179, 6801, 6815);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 180, 6825, 6843);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 181, 6853, 6871);
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    @Override
    public void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context95 = new MethodContext(void.class, 186, 6884, 10934);
        try {
            CallChecker.varInit(this, "this", 186, 6884, 10934);
            CallChecker.varInit(comparator, "comparator", 186, 6884, 10934);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 186, 6884, 10934);
            CallChecker.varInit(this.sigma, "sigma", 186, 6884, 10934);
            CallChecker.varInit(this.gamma, "gamma", 186, 6884, 10934);
            CallChecker.varInit(this.khi, "khi", 186, 6884, 10934);
            CallChecker.varInit(this.rho, "rho", 186, 6884, 10934);
            CallChecker.varInit(DEFAULT_SIGMA, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex.DEFAULT_SIGMA", 186, 6884, 10934);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex.DEFAULT_GAMMA", 186, 6884, 10934);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex.DEFAULT_KHI", 186, 6884, 10934);
            CallChecker.varInit(DEFAULT_RHO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex.DEFAULT_RHO", 186, 6884, 10934);
            final int n = CallChecker.varInit(((int) (getDimension())), "n", 189, 7069, 7156);
            final PointValuePair best = CallChecker.varInit(getPoint(0), "best", 192, 7167, 7237);
            final PointValuePair secondBest = CallChecker.varInit(getPoint((n - 1)), "secondBest", 193, 7247, 7296);
            final PointValuePair worst = CallChecker.varInit(getPoint(n), "worst", 194, 7306, 7346);
            final double[] xWorst = CallChecker.varInit(CallChecker.isCalled(worst, PointValuePair.class, 195, 7380, 7384).getPointRef(), "xWorst", 195, 7356, 7399);
            final double[] centroid = CallChecker.varInit(new double[n], "centroid", 199, 7515, 7554);
            for (int i = 0; i < n; i++) {
                final double[] x = CallChecker.varInit(CallChecker.isCalled(getPoint(i), PointValuePair.class, 201, 7625, 7635).getPointRef(), "x", 201, 7606, 7650);
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(centroid, double[].class, 203, 7710, 7717)) {
                        if (CallChecker.beforeDeref(x, double[].class, 203, 7725, 7725)) {
                            CallChecker.isCalled(centroid, double[].class, 203, 7710, 7717)[j] += CallChecker.isCalled(x, double[].class, 203, 7725, 7725)[j];
                            CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 203, 7710, 7717)[j], "CallChecker.isCalled(centroid, double[].class, 203, 7710, 7717)[j]", 203, 7710, 7729);
                        }
                    }
                }
            }
            final double scaling = CallChecker.varInit(((double) (1.0 / n)), "scaling", 206, 7763, 7793);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(centroid, double[].class, 208, 7845, 7852)) {
                    CallChecker.isCalled(centroid, double[].class, 208, 7845, 7852)[j] *= scaling;
                    CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 208, 7845, 7852)[j], "CallChecker.isCalled(centroid, double[].class, 208, 7845, 7852)[j]", 208, 7845, 7867);
                }
            }
            final double[] xR = CallChecker.varInit(new double[n], "xR", 212, 7928, 7961);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(xR, double[].class, 214, 8013, 8014)) {
                    if (CallChecker.beforeDeref(centroid, double[].class, 214, 8021, 8028)) {
                        if (CallChecker.beforeDeref(centroid, double[].class, 214, 8042, 8049)) {
                            if (CallChecker.beforeDeref(xWorst, double[].class, 214, 8056, 8061)) {
                                CallChecker.isCalled(xR, double[].class, 214, 8013, 8014)[j] = (CallChecker.isCalled(centroid, double[].class, 214, 8021, 8028)[j]) + ((rho) * ((CallChecker.isCalled(centroid, double[].class, 214, 8042, 8049)[j]) - (CallChecker.isCalled(xWorst, double[].class, 214, 8056, 8061)[j])));
                                CallChecker.varAssign(CallChecker.isCalled(xR, double[].class, 214, 8013, 8014)[j], "CallChecker.isCalled(xR, double[].class, 214, 8013, 8014)[j]", 214, 8013, 8066);
                            }
                        }
                    }
                }
            }
            final PointValuePair reflected = CallChecker.varInit(new PointValuePair(xR, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 217, 8154, 8171).value(xR), false), "reflected", 216, 8086, 8190);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 219, 8205, 8214)) {
                if (CallChecker.beforeDeref(comparator, Comparator.class, 220, 8261, 8270)) {
                    if (((CallChecker.isCalled(comparator, Comparator.class, 219, 8205, 8214).compare(best, reflected)) <= 0) && ((CallChecker.isCalled(comparator, Comparator.class, 220, 8261, 8270).compare(reflected, secondBest)) < 0)) {
                        replaceWorstPoint(reflected, comparator);
                    }else
                        if (CallChecker.beforeDeref(comparator, Comparator.class, 223, 8426, 8435)) {
                            if ((CallChecker.isCalled(comparator, Comparator.class, 223, 8426, 8435).compare(reflected, best)) < 0) {
                                final double[] xE = CallChecker.varInit(new double[n], "xE", 225, 8525, 8558);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(xE, double[].class, 227, 8618, 8619)) {
                                        if (CallChecker.beforeDeref(centroid, double[].class, 227, 8626, 8633)) {
                                            if (CallChecker.beforeDeref(xR, double[].class, 227, 8647, 8648)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 227, 8655, 8662)) {
                                                    CallChecker.isCalled(xE, double[].class, 227, 8618, 8619)[j] = (CallChecker.isCalled(centroid, double[].class, 227, 8626, 8633)[j]) + ((khi) * ((CallChecker.isCalled(xR, double[].class, 227, 8647, 8648)[j]) - (CallChecker.isCalled(centroid, double[].class, 227, 8655, 8662)[j])));
                                                    CallChecker.varAssign(CallChecker.isCalled(xE, double[].class, 227, 8618, 8619)[j], "CallChecker.isCalled(xE, double[].class, 227, 8618, 8619)[j]", 227, 8618, 8667);
                                                }
                                            }
                                        }
                                    }
                                }
                                final PointValuePair expanded = CallChecker.varInit(new PointValuePair(xE, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 230, 8766, 8783).value(xE), false), "expanded", 229, 8695, 8802);
                                if (CallChecker.beforeDeref(comparator, Comparator.class, 232, 8821, 8830)) {
                                    if ((CallChecker.isCalled(comparator, Comparator.class, 232, 8821, 8830).compare(expanded, reflected)) < 0) {
                                        replaceWorstPoint(expanded, comparator);
                                    }else {
                                        replaceWorstPoint(reflected, comparator);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(comparator, Comparator.class, 240, 9145, 9154)) {
                                    if ((CallChecker.isCalled(comparator, Comparator.class, 240, 9145, 9154).compare(reflected, worst)) < 0) {
                                        final double[] xC = CallChecker.varInit(new double[n], "xC", 242, 9256, 9289);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(xC, double[].class, 244, 9357, 9358)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 244, 9365, 9372)) {
                                                    if (CallChecker.beforeDeref(xR, double[].class, 244, 9388, 9389)) {
                                                        if (CallChecker.beforeDeref(centroid, double[].class, 244, 9396, 9403)) {
                                                            CallChecker.isCalled(xC, double[].class, 244, 9357, 9358)[j] = (CallChecker.isCalled(centroid, double[].class, 244, 9365, 9372)[j]) + ((gamma) * ((CallChecker.isCalled(xR, double[].class, 244, 9388, 9389)[j]) - (CallChecker.isCalled(centroid, double[].class, 244, 9396, 9403)[j])));
                                                            CallChecker.varAssign(CallChecker.isCalled(xC, double[].class, 244, 9357, 9358)[j], "CallChecker.isCalled(xC, double[].class, 244, 9357, 9358)[j]", 244, 9357, 9408);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        final PointValuePair outContracted = CallChecker.varInit(new PointValuePair(xC, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 247, 9524, 9541).value(xC), false), "outContracted", 246, 9444, 9560);
                                        if (CallChecker.beforeDeref(comparator, Comparator.class, 248, 9582, 9591)) {
                                            if ((CallChecker.isCalled(comparator, Comparator.class, 248, 9582, 9591).compare(outContracted, reflected)) <= 0) {
                                                replaceWorstPoint(outContracted, comparator);
                                                return ;
                                            }
                                        }
                                    }else {
                                        final double[] xC = CallChecker.varInit(new double[n], "xC", 255, 9887, 9920);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(xC, double[].class, 257, 9988, 9989)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 257, 9996, 10003)) {
                                                    if (CallChecker.beforeDeref(centroid, double[].class, 257, 10019, 10026)) {
                                                        if (CallChecker.beforeDeref(xWorst, double[].class, 257, 10033, 10038)) {
                                                            CallChecker.isCalled(xC, double[].class, 257, 9988, 9989)[j] = (CallChecker.isCalled(centroid, double[].class, 257, 9996, 10003)[j]) - ((gamma) * ((CallChecker.isCalled(centroid, double[].class, 257, 10019, 10026)[j]) - (CallChecker.isCalled(xWorst, double[].class, 257, 10033, 10038)[j])));
                                                            CallChecker.varAssign(CallChecker.isCalled(xC, double[].class, 257, 9988, 9989)[j], "CallChecker.isCalled(xC, double[].class, 257, 9988, 9989)[j]", 257, 9988, 10043);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        final PointValuePair inContracted = CallChecker.varInit(new PointValuePair(xC, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 260, 10158, 10175).value(xC), false), "inContracted", 259, 10079, 10194);
                                        if (CallChecker.beforeDeref(comparator, Comparator.class, 262, 10217, 10226)) {
                                            if ((CallChecker.isCalled(comparator, Comparator.class, 262, 10217, 10226).compare(inContracted, worst)) < 0) {
                                                replaceWorstPoint(inContracted, comparator);
                                                return ;
                                            }
                                        }
                                    }
                                }
                                final double[] xSmallest = CallChecker.varInit(CallChecker.isCalled(getPoint(0), PointValuePair.class, 270, 10515, 10525).getPointRef(), "xSmallest", 270, 10488, 10540);
                                for (int i = 1; i <= n; i++) {
                                    final double[] x = CallChecker.varInit(CallChecker.isCalled(getPoint(i), PointValuePair.class, 272, 10620, 10630).getPoint(), "x", 272, 10601, 10642);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(x, double[].class, 274, 10710, 10710)) {
                                            if (CallChecker.beforeDeref(xSmallest, double[].class, 274, 10717, 10725)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 274, 10741, 10741)) {
                                                    if (CallChecker.beforeDeref(xSmallest, double[].class, 274, 10748, 10756)) {
                                                        CallChecker.isCalled(x, double[].class, 274, 10710, 10710)[j] = (CallChecker.isCalled(xSmallest, double[].class, 274, 10717, 10725)[j]) + ((sigma) * ((CallChecker.isCalled(x, double[].class, 274, 10741, 10741)[j]) - (CallChecker.isCalled(xSmallest, double[].class, 274, 10748, 10756)[j])));
                                                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 274, 10710, 10710)[j], "CallChecker.isCalled(x, double[].class, 274, 10710, 10710)[j]", 274, 10710, 10761);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    setPoint(i, new PointValuePair(x, Double.NaN, false));
                                }
                                evaluate(evaluationFunction, comparator);
                            }
                        }
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }
}

