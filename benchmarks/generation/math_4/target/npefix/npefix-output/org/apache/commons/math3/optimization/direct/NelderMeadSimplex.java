package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.PointValuePair;

@Deprecated
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
        ConstructorContext _bcornu_methode_context22 = new ConstructorContext(NelderMeadSimplex.class, 58, 1922, 2216);
        try {
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, double sideLength) {
        this(n, sideLength, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context23 = new ConstructorContext(NelderMeadSimplex.class, 71, 2223, 2758);
        try {
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, double sideLength, final double rho, final double khi, final double gamma, final double sigma) {
        super(n, sideLength);
        ConstructorContext _bcornu_methode_context24 = new ConstructorContext(NelderMeadSimplex.class, 88, 2765, 3606);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 93, 3506, 3520);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 94, 3530, 3544);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 95, 3554, 3572);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 96, 3582, 3600);
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public NelderMeadSimplex(final int n, final double rho, final double khi, final double gamma, final double sigma) {
        this(n, 1.0, rho, khi, gamma, sigma);
        ConstructorContext _bcornu_methode_context25 = new ConstructorContext(NelderMeadSimplex.class, 109, 3613, 4193);
        try {
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[] steps) {
        this(steps, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context26 = new ConstructorContext(NelderMeadSimplex.class, 123, 4200, 4638);
        try {
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[] steps, final double rho, final double khi, final double gamma, final double sigma) {
        super(steps);
        ConstructorContext _bcornu_methode_context27 = new ConstructorContext(NelderMeadSimplex.class, 139, 4645, 5465);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 144, 5365, 5379);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 145, 5389, 5403);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 146, 5413, 5431);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 147, 5441, 5459);
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[][] referenceSimplex) {
        this(referenceSimplex, NelderMeadSimplex.DEFAULT_RHO, NelderMeadSimplex.DEFAULT_KHI, NelderMeadSimplex.DEFAULT_GAMMA, NelderMeadSimplex.DEFAULT_SIGMA);
        ConstructorContext _bcornu_methode_context28 = new ConstructorContext(NelderMeadSimplex.class, 158, 5472, 5927);
        try {
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public NelderMeadSimplex(final double[][] referenceSimplex, final double rho, final double khi, final double gamma, final double sigma) {
        super(referenceSimplex);
        ConstructorContext _bcornu_methode_context29 = new ConstructorContext(NelderMeadSimplex.class, 176, 5934, 6935);
        try {
            this.rho = rho;
            CallChecker.varAssign(this.rho, "this.rho", 181, 6835, 6849);
            this.khi = khi;
            CallChecker.varAssign(this.khi, "this.khi", 182, 6859, 6873);
            this.gamma = gamma;
            CallChecker.varAssign(this.gamma, "this.gamma", 183, 6883, 6901);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 184, 6911, 6929);
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    @Override
    public void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context94 = new MethodContext(void.class, 189, 6942, 10992);
        try {
            CallChecker.varInit(this, "this", 189, 6942, 10992);
            CallChecker.varInit(comparator, "comparator", 189, 6942, 10992);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 189, 6942, 10992);
            CallChecker.varInit(this.sigma, "sigma", 189, 6942, 10992);
            CallChecker.varInit(this.gamma, "gamma", 189, 6942, 10992);
            CallChecker.varInit(this.khi, "khi", 189, 6942, 10992);
            CallChecker.varInit(this.rho, "rho", 189, 6942, 10992);
            CallChecker.varInit(DEFAULT_SIGMA, "org.apache.commons.math3.optimization.direct.NelderMeadSimplex.DEFAULT_SIGMA", 189, 6942, 10992);
            CallChecker.varInit(DEFAULT_GAMMA, "org.apache.commons.math3.optimization.direct.NelderMeadSimplex.DEFAULT_GAMMA", 189, 6942, 10992);
            CallChecker.varInit(DEFAULT_KHI, "org.apache.commons.math3.optimization.direct.NelderMeadSimplex.DEFAULT_KHI", 189, 6942, 10992);
            CallChecker.varInit(DEFAULT_RHO, "org.apache.commons.math3.optimization.direct.NelderMeadSimplex.DEFAULT_RHO", 189, 6942, 10992);
            final int n = CallChecker.varInit(((int) (getDimension())), "n", 192, 7127, 7214);
            final PointValuePair best = CallChecker.varInit(getPoint(0), "best", 195, 7225, 7295);
            final PointValuePair secondBest = CallChecker.varInit(getPoint((n - 1)), "secondBest", 196, 7305, 7354);
            final PointValuePair worst = CallChecker.varInit(getPoint(n), "worst", 197, 7364, 7404);
            final double[] xWorst = CallChecker.varInit(CallChecker.isCalled(worst, PointValuePair.class, 198, 7438, 7442).getPointRef(), "xWorst", 198, 7414, 7457);
            final double[] centroid = CallChecker.varInit(new double[n], "centroid", 202, 7573, 7612);
            for (int i = 0; i < n; i++) {
                final double[] x = CallChecker.varInit(CallChecker.isCalled(getPoint(i), PointValuePair.class, 204, 7683, 7693).getPointRef(), "x", 204, 7664, 7708);
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(centroid, double[].class, 206, 7768, 7775)) {
                        if (CallChecker.beforeDeref(x, double[].class, 206, 7783, 7783)) {
                            CallChecker.isCalled(centroid, double[].class, 206, 7768, 7775)[j] += CallChecker.isCalled(x, double[].class, 206, 7783, 7783)[j];
                            CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 206, 7768, 7775)[j], "CallChecker.isCalled(centroid, double[].class, 206, 7768, 7775)[j]", 206, 7768, 7787);
                        }
                    }
                }
            }
            final double scaling = CallChecker.varInit(((double) (1.0 / n)), "scaling", 209, 7821, 7851);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(centroid, double[].class, 211, 7903, 7910)) {
                    CallChecker.isCalled(centroid, double[].class, 211, 7903, 7910)[j] *= scaling;
                    CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 211, 7903, 7910)[j], "CallChecker.isCalled(centroid, double[].class, 211, 7903, 7910)[j]", 211, 7903, 7925);
                }
            }
            final double[] xR = CallChecker.varInit(new double[n], "xR", 215, 7986, 8019);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(xR, double[].class, 217, 8071, 8072)) {
                    if (CallChecker.beforeDeref(centroid, double[].class, 217, 8079, 8086)) {
                        if (CallChecker.beforeDeref(centroid, double[].class, 217, 8100, 8107)) {
                            if (CallChecker.beforeDeref(xWorst, double[].class, 217, 8114, 8119)) {
                                CallChecker.isCalled(xR, double[].class, 217, 8071, 8072)[j] = (CallChecker.isCalled(centroid, double[].class, 217, 8079, 8086)[j]) + ((rho) * ((CallChecker.isCalled(centroid, double[].class, 217, 8100, 8107)[j]) - (CallChecker.isCalled(xWorst, double[].class, 217, 8114, 8119)[j])));
                                CallChecker.varAssign(CallChecker.isCalled(xR, double[].class, 217, 8071, 8072)[j], "CallChecker.isCalled(xR, double[].class, 217, 8071, 8072)[j]", 217, 8071, 8124);
                            }
                        }
                    }
                }
            }
            final PointValuePair reflected = CallChecker.varInit(new PointValuePair(xR, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 220, 8212, 8229).value(xR), false), "reflected", 219, 8144, 8248);
            if (CallChecker.beforeDeref(comparator, Comparator.class, 222, 8263, 8272)) {
                if (CallChecker.beforeDeref(comparator, Comparator.class, 223, 8319, 8328)) {
                    if (((CallChecker.isCalled(comparator, Comparator.class, 222, 8263, 8272).compare(best, reflected)) <= 0) && ((CallChecker.isCalled(comparator, Comparator.class, 223, 8319, 8328).compare(reflected, secondBest)) < 0)) {
                        replaceWorstPoint(reflected, comparator);
                    }else
                        if (CallChecker.beforeDeref(comparator, Comparator.class, 226, 8484, 8493)) {
                            if ((CallChecker.isCalled(comparator, Comparator.class, 226, 8484, 8493).compare(reflected, best)) < 0) {
                                final double[] xE = CallChecker.varInit(new double[n], "xE", 228, 8583, 8616);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(xE, double[].class, 230, 8676, 8677)) {
                                        if (CallChecker.beforeDeref(centroid, double[].class, 230, 8684, 8691)) {
                                            if (CallChecker.beforeDeref(xR, double[].class, 230, 8705, 8706)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 230, 8713, 8720)) {
                                                    CallChecker.isCalled(xE, double[].class, 230, 8676, 8677)[j] = (CallChecker.isCalled(centroid, double[].class, 230, 8684, 8691)[j]) + ((khi) * ((CallChecker.isCalled(xR, double[].class, 230, 8705, 8706)[j]) - (CallChecker.isCalled(centroid, double[].class, 230, 8713, 8720)[j])));
                                                    CallChecker.varAssign(CallChecker.isCalled(xE, double[].class, 230, 8676, 8677)[j], "CallChecker.isCalled(xE, double[].class, 230, 8676, 8677)[j]", 230, 8676, 8725);
                                                }
                                            }
                                        }
                                    }
                                }
                                final PointValuePair expanded = CallChecker.varInit(new PointValuePair(xE, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 233, 8824, 8841).value(xE), false), "expanded", 232, 8753, 8860);
                                if (CallChecker.beforeDeref(comparator, Comparator.class, 235, 8879, 8888)) {
                                    if ((CallChecker.isCalled(comparator, Comparator.class, 235, 8879, 8888).compare(expanded, reflected)) < 0) {
                                        replaceWorstPoint(expanded, comparator);
                                    }else {
                                        replaceWorstPoint(reflected, comparator);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(comparator, Comparator.class, 243, 9203, 9212)) {
                                    if ((CallChecker.isCalled(comparator, Comparator.class, 243, 9203, 9212).compare(reflected, worst)) < 0) {
                                        final double[] xC = CallChecker.varInit(new double[n], "xC", 245, 9314, 9347);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(xC, double[].class, 247, 9415, 9416)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 247, 9423, 9430)) {
                                                    if (CallChecker.beforeDeref(xR, double[].class, 247, 9446, 9447)) {
                                                        if (CallChecker.beforeDeref(centroid, double[].class, 247, 9454, 9461)) {
                                                            CallChecker.isCalled(xC, double[].class, 247, 9415, 9416)[j] = (CallChecker.isCalled(centroid, double[].class, 247, 9423, 9430)[j]) + ((gamma) * ((CallChecker.isCalled(xR, double[].class, 247, 9446, 9447)[j]) - (CallChecker.isCalled(centroid, double[].class, 247, 9454, 9461)[j])));
                                                            CallChecker.varAssign(CallChecker.isCalled(xC, double[].class, 247, 9415, 9416)[j], "CallChecker.isCalled(xC, double[].class, 247, 9415, 9416)[j]", 247, 9415, 9466);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        final PointValuePair outContracted = CallChecker.varInit(new PointValuePair(xC, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 250, 9582, 9599).value(xC), false), "outContracted", 249, 9502, 9618);
                                        if (CallChecker.beforeDeref(comparator, Comparator.class, 251, 9640, 9649)) {
                                            if ((CallChecker.isCalled(comparator, Comparator.class, 251, 9640, 9649).compare(outContracted, reflected)) <= 0) {
                                                replaceWorstPoint(outContracted, comparator);
                                                return ;
                                            }
                                        }
                                    }else {
                                        final double[] xC = CallChecker.varInit(new double[n], "xC", 258, 9945, 9978);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(xC, double[].class, 260, 10046, 10047)) {
                                                if (CallChecker.beforeDeref(centroid, double[].class, 260, 10054, 10061)) {
                                                    if (CallChecker.beforeDeref(centroid, double[].class, 260, 10077, 10084)) {
                                                        if (CallChecker.beforeDeref(xWorst, double[].class, 260, 10091, 10096)) {
                                                            CallChecker.isCalled(xC, double[].class, 260, 10046, 10047)[j] = (CallChecker.isCalled(centroid, double[].class, 260, 10054, 10061)[j]) - ((gamma) * ((CallChecker.isCalled(centroid, double[].class, 260, 10077, 10084)[j]) - (CallChecker.isCalled(xWorst, double[].class, 260, 10091, 10096)[j])));
                                                            CallChecker.varAssign(CallChecker.isCalled(xC, double[].class, 260, 10046, 10047)[j], "CallChecker.isCalled(xC, double[].class, 260, 10046, 10047)[j]", 260, 10046, 10101);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        final PointValuePair inContracted = CallChecker.varInit(new PointValuePair(xC, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 263, 10216, 10233).value(xC), false), "inContracted", 262, 10137, 10252);
                                        if (CallChecker.beforeDeref(comparator, Comparator.class, 265, 10275, 10284)) {
                                            if ((CallChecker.isCalled(comparator, Comparator.class, 265, 10275, 10284).compare(inContracted, worst)) < 0) {
                                                replaceWorstPoint(inContracted, comparator);
                                                return ;
                                            }
                                        }
                                    }
                                }
                                final double[] xSmallest = CallChecker.varInit(CallChecker.isCalled(getPoint(0), PointValuePair.class, 273, 10573, 10583).getPointRef(), "xSmallest", 273, 10546, 10598);
                                for (int i = 1; i <= n; i++) {
                                    final double[] x = CallChecker.varInit(CallChecker.isCalled(getPoint(i), PointValuePair.class, 275, 10678, 10688).getPoint(), "x", 275, 10659, 10700);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(x, double[].class, 277, 10768, 10768)) {
                                            if (CallChecker.beforeDeref(xSmallest, double[].class, 277, 10775, 10783)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 277, 10799, 10799)) {
                                                    if (CallChecker.beforeDeref(xSmallest, double[].class, 277, 10806, 10814)) {
                                                        CallChecker.isCalled(x, double[].class, 277, 10768, 10768)[j] = (CallChecker.isCalled(xSmallest, double[].class, 277, 10775, 10783)[j]) + ((sigma) * ((CallChecker.isCalled(x, double[].class, 277, 10799, 10799)[j]) - (CallChecker.isCalled(xSmallest, double[].class, 277, 10806, 10814)[j])));
                                                        CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 277, 10768, 10768)[j], "CallChecker.isCalled(x, double[].class, 277, 10768, 10768)[j]", 277, 10768, 10819);
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
            _bcornu_methode_context94.methodEnd();
        }
    }
}

