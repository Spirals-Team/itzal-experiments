package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

public class SymmLQ extends PreconditionedIterativeLinearSolver {
    private static class State {
        static final double CBRT_MACH_PREC;

        static final double MACH_PREC;

        private final RealLinearOperator a;

        private final RealVector b;

        private final boolean check;

        private final double delta;

        private double beta;

        private double beta1;

        private double bstep;

        private double cgnorm;

        private double dbar;

        private double gammaZeta;

        private double gbar;

        private double gmax;

        private double gmin;

        private final boolean goodb;

        private boolean hasConverged;

        private double lqnorm;

        private final RealLinearOperator m;

        private double minusEpsZeta;

        private final RealVector mb;

        private double oldb;

        private RealVector r1;

        private RealVector r2;

        private double rnorm;

        private final double shift;

        private double snprod;

        private double tnorm;

        private RealVector wbar;

        private final RealVector xL;

        private RealVector y;

        private double ynorm2;

        private boolean bIsNull;

        static {
            MACH_PREC = FastMath.ulp(1.0);
            CallChecker.varAssign(MACH_PREC, "MACH_PREC", 366, 15329, 15357);
            CBRT_MACH_PREC = FastMath.cbrt(SymmLQ.State.MACH_PREC);
            CallChecker.varAssign(CBRT_MACH_PREC, "CBRT_MACH_PREC", 367, 15371, 15412);
        }

        public State(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final boolean goodb, final double shift, final double delta, final boolean check) {
            ConstructorContext _bcornu_methode_context1036 = new ConstructorContext(SymmLQ.State.class, 384, 15433, 16735);
            try {
                this.a = a;
                CallChecker.varAssign(this.a, "this.a", 391, 16387, 16397);
                this.m = m;
                CallChecker.varAssign(this.m, "this.m", 392, 16411, 16421);
                this.b = b;
                CallChecker.varAssign(this.b, "this.b", 393, 16435, 16445);
                this.xL = new ArrayRealVector(CallChecker.isCalled(b, RealVector.class, 394, 16489, 16489).getDimension());
                CallChecker.varAssign(this.xL, "this.xL", 394, 16459, 16506);
                this.goodb = goodb;
                CallChecker.varAssign(this.goodb, "this.goodb", 395, 16520, 16538);
                this.shift = shift;
                CallChecker.varAssign(this.shift, "this.shift", 396, 16552, 16570);
                if (m == null) {
                    this.mb = b;
                    CallChecker.varAssign(this.mb, "this.mb", 397, 16584, 16622);
                }else {
                    this.mb = m.operate(b);
                    CallChecker.varAssign(this.mb, "this.mb", 397, 16584, 16622);
                }
                this.hasConverged = false;
                CallChecker.varAssign(this.hasConverged, "this.hasConverged", 398, 16636, 16661);
                this.check = check;
                CallChecker.varAssign(this.check, "this.check", 399, 16675, 16693);
                this.delta = delta;
                CallChecker.varAssign(this.delta, "this.delta", 400, 16707, 16725);
            } finally {
                _bcornu_methode_context1036.methodEnd();
            }
        }

        private static void checkSymmetry(final RealLinearOperator l, final RealVector x, final RealVector y, final RealVector z) throws NonSelfAdjointOperatorException {
            MethodContext _bcornu_methode_context4586 = new MethodContext(void.class, 416, 16746, 18231);
            try {
                CallChecker.varInit(z, "z", 416, 16746, 18231);
                CallChecker.varInit(y, "y", 416, 16746, 18231);
                CallChecker.varInit(x, "x", 416, 16746, 18231);
                CallChecker.varInit(l, "l", 416, 16746, 18231);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 416, 16746, 18231);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 416, 16746, 18231);
                final double s = CallChecker.varInit(((double) (CallChecker.isCalled(y, RealVector.class, 419, 17594, 17594).dotProduct(y))), "s", 419, 17577, 17609);
                final double t = CallChecker.varInit(((double) (CallChecker.isCalled(x, RealVector.class, 420, 17640, 17640).dotProduct(z))), "t", 420, 17623, 17655);
                final double epsa = CallChecker.varInit(((double) ((s + (SymmLQ.State.MACH_PREC)) * (SymmLQ.State.CBRT_MACH_PREC))), "epsa", 421, 17669, 17721);
                if ((FastMath.abs((s - t))) > epsa) {
                    NonSelfAdjointOperatorException e = CallChecker.init(NonSelfAdjointOperatorException.class);
                    e = new NonSelfAdjointOperatorException();
                    CallChecker.varAssign(e, "e", 424, 17842, 17883);
                    e = CallChecker.beforeCalled(e, NonSelfAdjointOperatorException.class, 425, 17934, 17934);
                    final ExceptionContext context = CallChecker.varInit(CallChecker.isCalled(e, NonSelfAdjointOperatorException.class, 425, 17934, 17934).getContext(), "context", 425, 17901, 17948);
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 426, 17966, 17972)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 426, 17966, 17972).setValue(SymmLQ.OPERATOR, l);
                    }
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 427, 18020, 18026)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 427, 18020, 18026).setValue(SymmLQ.VECTOR1, x);
                    }
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 428, 18073, 18079)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 428, 18073, 18079).setValue(SymmLQ.VECTOR2, y);
                    }
                    if (CallChecker.beforeDeref(context, ExceptionContext.class, 429, 18126, 18132)) {
                        CallChecker.isCalled(context, ExceptionContext.class, 429, 18126, 18132).setValue(SymmLQ.THRESHOLD, Double.valueOf(epsa));
                    }
                    throw e;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4586.methodEnd();
            }
        }

        private static void throwNPDLOException(final RealLinearOperator l, final RealVector v) throws NonPositiveDefiniteOperatorException {
            MethodContext _bcornu_methode_context4587 = new MethodContext(void.class, 442, 18242, 18989);
            try {
                CallChecker.varInit(v, "v", 442, 18242, 18989);
                CallChecker.varInit(l, "l", 442, 18242, 18989);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 442, 18242, 18989);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 442, 18242, 18989);
                NonPositiveDefiniteOperatorException e = CallChecker.init(NonPositiveDefiniteOperatorException.class);
                e = new NonPositiveDefiniteOperatorException();
                CallChecker.varAssign(e, "e", 445, 18767, 18813);
                e = CallChecker.beforeCalled(e, NonPositiveDefiniteOperatorException.class, 446, 18860, 18860);
                final ExceptionContext context = CallChecker.varInit(CallChecker.isCalled(e, NonPositiveDefiniteOperatorException.class, 446, 18860, 18860).getContext(), "context", 446, 18827, 18874);
                if (CallChecker.beforeDeref(context, ExceptionContext.class, 447, 18888, 18894)) {
                    CallChecker.isCalled(context, ExceptionContext.class, 447, 18888, 18894).setValue(SymmLQ.OPERATOR, l);
                }
                if (CallChecker.beforeDeref(context, ExceptionContext.class, 448, 18931, 18937)) {
                    CallChecker.isCalled(context, ExceptionContext.class, 448, 18931, 18937).setValue(SymmLQ.VECTOR, v);
                }
                throw e;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4587.methodEnd();
            }
        }

        private static void daxpy(final double a, final RealVector x, final RealVector y) {
            MethodContext _bcornu_methode_context4588 = new MethodContext(void.class, 461, 19000, 19681);
            try {
                CallChecker.varInit(y, "y", 461, 19000, 19681);
                CallChecker.varInit(x, "x", 461, 19000, 19681);
                CallChecker.varInit(a, "a", 461, 19000, 19681);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 461, 19000, 19681);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 461, 19000, 19681);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, RealVector.class, 463, 19533, 19533).getDimension())), "n", 463, 19519, 19549);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(x, RealVector.class, 465, 19627, 19627)) {
                        if (CallChecker.beforeDeref(y, RealVector.class, 465, 19643, 19643)) {
                            if (CallChecker.beforeDeref(y, RealVector.class, 465, 19609, 19609)) {
                                CallChecker.isCalled(y, RealVector.class, 465, 19609, 19609).setEntry(i, ((a * (CallChecker.isCalled(x, RealVector.class, 465, 19627, 19627).getEntry(i))) + (CallChecker.isCalled(y, RealVector.class, 465, 19643, 19643).getEntry(i))));
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4588.methodEnd();
            }
        }

        private static void daxpbypz(final double a, final RealVector x, final double b, final RealVector y, final RealVector z) {
            MethodContext _bcornu_methode_context4589 = new MethodContext(void.class, 480, 19692, 20608);
            try {
                CallChecker.varInit(z, "z", 480, 19692, 20608);
                CallChecker.varInit(y, "y", 480, 19692, 20608);
                CallChecker.varInit(b, "b", 480, 19692, 20608);
                CallChecker.varInit(x, "x", 480, 19692, 20608);
                CallChecker.varInit(a, "a", 480, 19692, 20608);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 480, 19692, 20608);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 480, 19692, 20608);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(z, RealVector.class, 482, 20382, 20382).getDimension())), "n", 482, 20368, 20398);
                for (int i = 0; i < n; i++) {
                    double zi = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(x, RealVector.class, 485, 20500, 20500)) {
                        if (CallChecker.beforeDeref(y, RealVector.class, 485, 20520, 20520)) {
                            if (CallChecker.beforeDeref(z, RealVector.class, 485, 20536, 20536)) {
                                zi = ((a * (CallChecker.isCalled(x, RealVector.class, 485, 20500, 20500).getEntry(i))) + (b * (CallChecker.isCalled(y, RealVector.class, 485, 20520, 20520).getEntry(i)))) + (CallChecker.isCalled(z, RealVector.class, 485, 20536, 20536).getEntry(i));
                                CallChecker.varAssign(zi, "zi", 485, 20491, 20549);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(z, RealVector.class, 486, 20567, 20567)) {
                        CallChecker.isCalled(z, RealVector.class, 486, 20567, 20567).setEntry(i, zi);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4589.methodEnd();
            }
        }

        void refineSolution(final RealVector x) {
            MethodContext _bcornu_methode_context4590 = new MethodContext(void.class, 503, 20619, 22686);
            try {
                CallChecker.varInit(this, "this", 503, 20619, 22686);
                CallChecker.varInit(x, "x", 503, 20619, 22686);
                CallChecker.varInit(this.bIsNull, "bIsNull", 503, 20619, 22686);
                CallChecker.varInit(this.ynorm2, "ynorm2", 503, 20619, 22686);
                CallChecker.varInit(this.y, "y", 503, 20619, 22686);
                CallChecker.varInit(this.xL, "xL", 503, 20619, 22686);
                CallChecker.varInit(this.wbar, "wbar", 503, 20619, 22686);
                CallChecker.varInit(this.tnorm, "tnorm", 503, 20619, 22686);
                CallChecker.varInit(this.snprod, "snprod", 503, 20619, 22686);
                CallChecker.varInit(this.shift, "shift", 503, 20619, 22686);
                CallChecker.varInit(this.rnorm, "rnorm", 503, 20619, 22686);
                CallChecker.varInit(this.r2, "r2", 503, 20619, 22686);
                CallChecker.varInit(this.r1, "r1", 503, 20619, 22686);
                CallChecker.varInit(this.oldb, "oldb", 503, 20619, 22686);
                CallChecker.varInit(this.mb, "mb", 503, 20619, 22686);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 503, 20619, 22686);
                CallChecker.varInit(this.m, "m", 503, 20619, 22686);
                CallChecker.varInit(this.lqnorm, "lqnorm", 503, 20619, 22686);
                CallChecker.varInit(this.hasConverged, "hasConverged", 503, 20619, 22686);
                CallChecker.varInit(this.goodb, "goodb", 503, 20619, 22686);
                CallChecker.varInit(this.gmin, "gmin", 503, 20619, 22686);
                CallChecker.varInit(this.gmax, "gmax", 503, 20619, 22686);
                CallChecker.varInit(this.gbar, "gbar", 503, 20619, 22686);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 503, 20619, 22686);
                CallChecker.varInit(this.dbar, "dbar", 503, 20619, 22686);
                CallChecker.varInit(this.cgnorm, "cgnorm", 503, 20619, 22686);
                CallChecker.varInit(this.bstep, "bstep", 503, 20619, 22686);
                CallChecker.varInit(this.beta1, "beta1", 503, 20619, 22686);
                CallChecker.varInit(this.beta, "beta", 503, 20619, 22686);
                CallChecker.varInit(this.delta, "delta", 503, 20619, 22686);
                CallChecker.varInit(this.check, "check", 503, 20619, 22686);
                CallChecker.varInit(this.b, "b", 503, 20619, 22686);
                CallChecker.varInit(this.a, "a", 503, 20619, 22686);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 503, 20619, 22686);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 503, 20619, 22686);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.xL, RealVector.class, 504, 21196, 21202).getDimension())), "n", 504, 21182, 21218);
                if ((lqnorm) < (cgnorm)) {
                    if (!(goodb)) {
                        if (CallChecker.beforeDeref(x, RealVector.class, 507, 21305, 21305)) {
                            CallChecker.isCalled(x, RealVector.class, 507, 21305, 21305).setSubVector(0, this.xL);
                        }
                    }else {
                        final double step = CallChecker.varInit(((double) ((this.bstep) / (this.beta1))), "step", 509, 21378, 21411);
                        for (int i = 0; i < n; i++) {
                            final double bi = CallChecker.varInit(((double) (CallChecker.isCalled(this.mb, RealVector.class, 511, 21505, 21506).getEntry(i))), "bi", 511, 21487, 21519);
                            final double xi = CallChecker.varInit(((double) (CallChecker.isCalled(this.xL, RealVector.class, 512, 21563, 21569).getEntry(i))), "xi", 512, 21545, 21582);
                            if (CallChecker.beforeDeref(x, RealVector.class, 513, 21608, 21608)) {
                                CallChecker.isCalled(x, RealVector.class, 513, 21608, 21608).setEntry(i, (xi + (step * bi)));
                            }
                        }
                    }
                }else {
                    final double anorm = CallChecker.varInit(((double) (FastMath.sqrt(this.tnorm))), "anorm", 517, 21716, 21757);
                    double diag = CallChecker.init(double.class);
                    if ((gbar) == 0.0) {
                        diag = anorm * (SymmLQ.State.MACH_PREC);
                        CallChecker.varAssign(diag, "diag", 518, 21795, 21831);
                    }else {
                        diag = gbar;
                        CallChecker.varAssign(diag, "diag", 518, 21795, 21831);
                    }
                    final double zbar = CallChecker.varInit(((double) ((this.gammaZeta) / diag)), "zbar", 519, 21850, 21886);
                    final double step = CallChecker.varInit(((double) (((this.bstep) + ((this.snprod) * zbar)) / (this.beta1))), "step", 520, 21904, 21955);
                    if (!(goodb)) {
                        for (int i = 0; i < n; i++) {
                            final double xi = CallChecker.varInit(((double) (CallChecker.isCalled(this.xL, RealVector.class, 524, 22143, 22149).getEntry(i))), "xi", 524, 22125, 22162);
                            wbar = CallChecker.beforeCalled(wbar, RealVector.class, 525, 22206, 22209);
                            final double wi = CallChecker.varInit(((double) (CallChecker.isCalled(this.wbar, RealVector.class, 525, 22206, 22209).getEntry(i))), "wi", 525, 22188, 22222);
                            if (CallChecker.beforeDeref(x, RealVector.class, 526, 22248, 22248)) {
                                CallChecker.isCalled(x, RealVector.class, 526, 22248, 22248).setEntry(i, (xi + (zbar * wi)));
                            }
                        }
                    }else {
                        for (int i = 0; i < n; i++) {
                            final double xi = CallChecker.varInit(((double) (CallChecker.isCalled(this.xL, RealVector.class, 530, 22418, 22424).getEntry(i))), "xi", 530, 22400, 22437);
                            wbar = CallChecker.beforeCalled(wbar, RealVector.class, 531, 22481, 22484);
                            final double wi = CallChecker.varInit(((double) (CallChecker.isCalled(this.wbar, RealVector.class, 531, 22481, 22484).getEntry(i))), "wi", 531, 22463, 22497);
                            final double bi = CallChecker.varInit(((double) (CallChecker.isCalled(this.mb, RealVector.class, 532, 22541, 22542).getEntry(i))), "bi", 532, 22523, 22555);
                            if (CallChecker.beforeDeref(x, RealVector.class, 533, 22581, 22581)) {
                                CallChecker.isCalled(x, RealVector.class, 533, 22581, 22581).setEntry(i, ((xi + (zbar * wi)) + (step * bi)));
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4590.methodEnd();
            }
        }

        void init() {
            MethodContext _bcornu_methode_context4591 = new MethodContext(void.class, 544, 22697, 26037);
            try {
                CallChecker.varInit(this, "this", 544, 22697, 26037);
                CallChecker.varInit(this.bIsNull, "bIsNull", 544, 22697, 26037);
                CallChecker.varInit(this.ynorm2, "ynorm2", 544, 22697, 26037);
                CallChecker.varInit(this.y, "y", 544, 22697, 26037);
                CallChecker.varInit(this.xL, "xL", 544, 22697, 26037);
                CallChecker.varInit(this.wbar, "wbar", 544, 22697, 26037);
                CallChecker.varInit(this.tnorm, "tnorm", 544, 22697, 26037);
                CallChecker.varInit(this.snprod, "snprod", 544, 22697, 26037);
                CallChecker.varInit(this.shift, "shift", 544, 22697, 26037);
                CallChecker.varInit(this.rnorm, "rnorm", 544, 22697, 26037);
                CallChecker.varInit(this.r2, "r2", 544, 22697, 26037);
                CallChecker.varInit(this.r1, "r1", 544, 22697, 26037);
                CallChecker.varInit(this.oldb, "oldb", 544, 22697, 26037);
                CallChecker.varInit(this.mb, "mb", 544, 22697, 26037);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 544, 22697, 26037);
                CallChecker.varInit(this.m, "m", 544, 22697, 26037);
                CallChecker.varInit(this.lqnorm, "lqnorm", 544, 22697, 26037);
                CallChecker.varInit(this.hasConverged, "hasConverged", 544, 22697, 26037);
                CallChecker.varInit(this.goodb, "goodb", 544, 22697, 26037);
                CallChecker.varInit(this.gmin, "gmin", 544, 22697, 26037);
                CallChecker.varInit(this.gmax, "gmax", 544, 22697, 26037);
                CallChecker.varInit(this.gbar, "gbar", 544, 22697, 26037);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 544, 22697, 26037);
                CallChecker.varInit(this.dbar, "dbar", 544, 22697, 26037);
                CallChecker.varInit(this.cgnorm, "cgnorm", 544, 22697, 26037);
                CallChecker.varInit(this.bstep, "bstep", 544, 22697, 26037);
                CallChecker.varInit(this.beta1, "beta1", 544, 22697, 26037);
                CallChecker.varInit(this.beta, "beta", 544, 22697, 26037);
                CallChecker.varInit(this.delta, "delta", 544, 22697, 26037);
                CallChecker.varInit(this.check, "check", 544, 22697, 26037);
                CallChecker.varInit(this.b, "b", 544, 22697, 26037);
                CallChecker.varInit(this.a, "a", 544, 22697, 26037);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 544, 22697, 26037);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 544, 22697, 26037);
                if (CallChecker.beforeDeref(this.xL, RealVector.class, 545, 22921, 22927)) {
                    CallChecker.isCalled(this.xL, RealVector.class, 545, 22921, 22927).set(0.0);
                }
                if (CallChecker.beforeDeref(this.b, RealVector.class, 550, 23095, 23100)) {
                    this.r1 = CallChecker.isCalled(this.b, RealVector.class, 550, 23095, 23100).copy();
                    CallChecker.varAssign(this.r1, "this.r1", 550, 23085, 23108);
                }
                if ((this.m) == null) {
                    if (CallChecker.beforeDeref(this.b, RealVector.class, 551, 23148, 23153)) {
                        this.y = CallChecker.isCalled(this.b, RealVector.class, 551, 23148, 23153).copy();
                        CallChecker.varAssign(this.y, "this.y", 551, 23122, 23187);
                    }
                }else {
                    this.y = this.m.operate(this.r1);
                    CallChecker.varAssign(this.y, "this.y", 551, 23122, 23187);
                }
                if (((this.m) != null) && (this.check)) {
                    SymmLQ.State.checkSymmetry(this.m, this.r1, this.y, this.m.operate(this.y));
                }
                if (CallChecker.beforeDeref(this.r1, RealVector.class, 556, 23359, 23365)) {
                    this.r1 = CallChecker.beforeCalled(this.r1, RealVector.class, 556, 23359, 23365);
                    this.beta1 = CallChecker.isCalled(this.r1, RealVector.class, 556, 23359, 23365).dotProduct(this.y);
                    CallChecker.varAssign(this.beta1, "this.beta1", 556, 23346, 23385);
                }
                if ((this.beta1) < 0.0) {
                    SymmLQ.State.throwNPDLOException(this.m, this.y);
                }
                if ((this.beta1) == 0.0) {
                    this.bIsNull = true;
                    CallChecker.varAssign(this.bIsNull, "this.bIsNull", 562, 23598, 23617);
                    return ;
                }
                this.bIsNull = false;
                CallChecker.varAssign(this.bIsNull, "this.bIsNull", 565, 23669, 23689);
                this.beta1 = FastMath.sqrt(this.beta1);
                CallChecker.varAssign(this.beta1, "this.beta1", 566, 23703, 23741);
                this.y = CallChecker.beforeCalled(this.y, RealVector.class, 572, 23908, 23913);
                final RealVector v = CallChecker.varInit(CallChecker.isCalled(this.y, RealVector.class, 572, 23908, 23913).mapMultiply((1.0 / (this.beta1))), "v", 572, 23755, 23943);
                if (CallChecker.beforeDeref(this.a, RealLinearOperator.class, 573, 23966, 23971)) {
                    this.y = CallChecker.isCalled(this.a, RealLinearOperator.class, 573, 23966, 23971).operate(v);
                    CallChecker.varAssign(this.y, "this.y", 573, 23957, 23983);
                }
                if (this.check) {
                    if (CallChecker.beforeDeref(this.a, RealLinearOperator.class, 575, 24064, 24069)) {
                        SymmLQ.State.checkSymmetry(this.a, v, this.y, CallChecker.isCalled(this.a, RealLinearOperator.class, 575, 24064, 24069).operate(this.y));
                    }
                }
                SymmLQ.State.daxpy((-(this.shift)), v, this.y);
                final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 582, 24342, 24342).dotProduct(this.y))), "alpha", 582, 24321, 24362);
                SymmLQ.State.daxpy(((-alpha) / (this.beta1)), this.r1, this.y);
                final double vty = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 590, 24666, 24666).dotProduct(this.y))), "vty", 590, 24433, 24686);
                final double vtv = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 591, 24719, 24719).dotProduct(v))), "vtv", 591, 24700, 24734);
                SymmLQ.State.daxpy(((-vty) / vtv), v, this.y);
                if (CallChecker.beforeDeref(this.y, RealVector.class, 593, 24800, 24805)) {
                    this.y = CallChecker.beforeCalled(this.y, RealVector.class, 593, 24800, 24805);
                    this.r2 = CallChecker.isCalled(this.y, RealVector.class, 593, 24800, 24805).copy();
                    CallChecker.varAssign(this.r2, "this.r2", 593, 24790, 24813);
                }
                if ((this.m) != null) {
                    this.y = this.m.operate(this.r2);
                    CallChecker.varAssign(this.y, "this.y", 595, 24865, 24897);
                }
                this.oldb = this.beta1;
                CallChecker.varAssign(this.oldb, "this.oldb", 597, 24925, 24947);
                if (CallChecker.beforeDeref(this.r2, RealVector.class, 598, 24973, 24979)) {
                    this.r2 = CallChecker.beforeCalled(this.r2, RealVector.class, 598, 24973, 24979);
                    this.beta = CallChecker.isCalled(this.r2, RealVector.class, 598, 24973, 24979).dotProduct(this.y);
                    CallChecker.varAssign(this.beta, "this.beta", 598, 24961, 24999);
                }
                if ((this.beta) < 0.0) {
                    SymmLQ.State.throwNPDLOException(this.m, this.y);
                }
                this.beta = FastMath.sqrt(this.beta);
                CallChecker.varAssign(this.beta, "this.beta", 602, 25114, 25150);
                this.cgnorm = this.beta1;
                CallChecker.varAssign(this.cgnorm, "this.cgnorm", 610, 25381, 25405);
                this.gbar = alpha;
                CallChecker.varAssign(this.gbar, "this.gbar", 611, 25419, 25436);
                this.dbar = this.beta;
                CallChecker.varAssign(this.dbar, "this.dbar", 612, 25450, 25471);
                this.gammaZeta = this.beta1;
                CallChecker.varAssign(this.gammaZeta, "this.gammaZeta", 613, 25485, 25512);
                this.minusEpsZeta = 0.0;
                CallChecker.varAssign(this.minusEpsZeta, "this.minusEpsZeta", 614, 25526, 25548);
                this.bstep = 0.0;
                CallChecker.varAssign(this.bstep, "this.bstep", 615, 25562, 25577);
                this.snprod = 1.0;
                CallChecker.varAssign(this.snprod, "this.snprod", 616, 25591, 25607);
                this.tnorm = (alpha * alpha) + ((this.beta) * (this.beta));
                CallChecker.varAssign(this.tnorm, "this.tnorm", 617, 25621, 25671);
                this.ynorm2 = 0.0;
                CallChecker.varAssign(this.ynorm2, "this.ynorm2", 618, 25685, 25701);
                this.gmax = (FastMath.abs(alpha)) + (SymmLQ.State.MACH_PREC);
                CallChecker.varAssign(this.gmax, "this.gmax", 619, 25715, 25758);
                this.gmin = this.gmax;
                CallChecker.varAssign(this.gmin, "this.gmin", 620, 25772, 25793);
                if (this.goodb) {
                    if (CallChecker.beforeDeref(this.a, RealLinearOperator.class, 623, 25874, 25879)) {
                        this.wbar = new ArrayRealVector(CallChecker.isCalled(this.a, RealLinearOperator.class, 623, 25874, 25879).getRowDimension());
                        CallChecker.varAssign(this.wbar, "this.wbar", 623, 25842, 25899);
                    }
                    if (CallChecker.beforeDeref(this.wbar, RealVector.class, 624, 25917, 25925)) {
                        this.wbar = CallChecker.beforeCalled(this.wbar, RealVector.class, 624, 25917, 25925);
                        CallChecker.isCalled(this.wbar, RealVector.class, 624, 25917, 25925).set(0.0);
                    }
                }else {
                    this.wbar = v;
                    CallChecker.varAssign(this.wbar, "this.wbar", 626, 25973, 25986);
                }
                updateNorms();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4591.methodEnd();
            }
        }

        void update() {
            MethodContext _bcornu_methode_context4592 = new MethodContext(void.class, 637, 26048, 31370);
            try {
                CallChecker.varInit(this, "this", 637, 26048, 31370);
                CallChecker.varInit(this.bIsNull, "bIsNull", 637, 26048, 31370);
                CallChecker.varInit(this.ynorm2, "ynorm2", 637, 26048, 31370);
                CallChecker.varInit(this.y, "y", 637, 26048, 31370);
                CallChecker.varInit(this.xL, "xL", 637, 26048, 31370);
                CallChecker.varInit(this.wbar, "wbar", 637, 26048, 31370);
                CallChecker.varInit(this.tnorm, "tnorm", 637, 26048, 31370);
                CallChecker.varInit(this.snprod, "snprod", 637, 26048, 31370);
                CallChecker.varInit(this.shift, "shift", 637, 26048, 31370);
                CallChecker.varInit(this.rnorm, "rnorm", 637, 26048, 31370);
                CallChecker.varInit(this.r2, "r2", 637, 26048, 31370);
                CallChecker.varInit(this.r1, "r1", 637, 26048, 31370);
                CallChecker.varInit(this.oldb, "oldb", 637, 26048, 31370);
                CallChecker.varInit(this.mb, "mb", 637, 26048, 31370);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 637, 26048, 31370);
                CallChecker.varInit(this.m, "m", 637, 26048, 31370);
                CallChecker.varInit(this.lqnorm, "lqnorm", 637, 26048, 31370);
                CallChecker.varInit(this.hasConverged, "hasConverged", 637, 26048, 31370);
                CallChecker.varInit(this.goodb, "goodb", 637, 26048, 31370);
                CallChecker.varInit(this.gmin, "gmin", 637, 26048, 31370);
                CallChecker.varInit(this.gmax, "gmax", 637, 26048, 31370);
                CallChecker.varInit(this.gbar, "gbar", 637, 26048, 31370);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 637, 26048, 31370);
                CallChecker.varInit(this.dbar, "dbar", 637, 26048, 31370);
                CallChecker.varInit(this.cgnorm, "cgnorm", 637, 26048, 31370);
                CallChecker.varInit(this.bstep, "bstep", 637, 26048, 31370);
                CallChecker.varInit(this.beta1, "beta1", 637, 26048, 31370);
                CallChecker.varInit(this.beta, "beta", 637, 26048, 31370);
                CallChecker.varInit(this.delta, "delta", 637, 26048, 31370);
                CallChecker.varInit(this.check, "check", 637, 26048, 31370);
                CallChecker.varInit(this.b, "b", 637, 26048, 31370);
                CallChecker.varInit(this.a, "a", 637, 26048, 31370);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 637, 26048, 31370);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 637, 26048, 31370);
                y = CallChecker.beforeCalled(y, RealVector.class, 638, 26403, 26403);
                final RealVector v = CallChecker.varInit(CallChecker.isCalled(y, RealVector.class, 638, 26403, 26403).mapMultiply((1.0 / (beta))), "v", 638, 26382, 26427);
                if (CallChecker.beforeDeref(a, RealLinearOperator.class, 639, 26445, 26445)) {
                    y = CallChecker.isCalled(a, RealLinearOperator.class, 639, 26445, 26445).operate(v);
                    CallChecker.varAssign(this.y, "this.y", 639, 26441, 26457);
                }
                SymmLQ.State.daxpbypz((-(shift)), v, ((-(beta)) / (oldb)), r1, y);
                final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 641, 26546, 26546).dotProduct(this.y))), "alpha", 641, 26525, 26561);
                SymmLQ.State.daxpy(((-alpha) / (beta)), r2, y);
                r1 = r2;
                CallChecker.varAssign(this.r1, "this.r1", 666, 27761, 27768);
                r2 = y;
                CallChecker.varAssign(this.r2, "this.r2", 667, 27782, 27788);
                if ((m) != null) {
                    y = m.operate(r2);
                    CallChecker.varAssign(this.y, "this.y", 669, 27835, 27852);
                }
                oldb = beta;
                CallChecker.varAssign(this.oldb, "this.oldb", 671, 27880, 27891);
                if (CallChecker.beforeDeref(r2, RealVector.class, 672, 27912, 27913)) {
                    r2 = CallChecker.beforeCalled(r2, RealVector.class, 672, 27912, 27913);
                    beta = CallChecker.isCalled(r2, RealVector.class, 672, 27912, 27913).dotProduct(y);
                    CallChecker.varAssign(this.beta, "this.beta", 672, 27905, 27928);
                }
                if ((beta) < 0.0) {
                    SymmLQ.State.throwNPDLOException(m, y);
                }
                beta = FastMath.sqrt(beta);
                CallChecker.varAssign(this.beta, "this.beta", 676, 28028, 28054);
                tnorm += ((alpha * alpha) + ((oldb) * (oldb))) + ((beta) * (beta));
                CallChecker.varAssign(this.tnorm, "this.tnorm", 685, 28351, 28401);
                final double gamma = CallChecker.varInit(((double) (FastMath.sqrt((((this.gbar) * (this.gbar)) + ((this.oldb) * (this.oldb)))))), "gamma", 693, 28415, 28731);
                final double c = CallChecker.varInit(((double) ((this.gbar) / gamma)), "c", 694, 28745, 28774);
                final double s = CallChecker.varInit(((double) ((this.oldb) / gamma)), "s", 695, 28788, 28817);
                final double deltak = CallChecker.varInit(((double) ((c * (this.dbar)) + (s * alpha))), "deltak", 705, 28831, 29334);
                gbar = (s * (dbar)) - (c * alpha);
                CallChecker.varAssign(this.gbar, "this.gbar", 706, 29348, 29375);
                final double eps = CallChecker.varInit(((double) (s * (this.beta))), "eps", 707, 29389, 29416);
                dbar = (-c) * (beta);
                CallChecker.varAssign(this.dbar, "this.dbar", 708, 29430, 29446);
                final double zeta = CallChecker.varInit(((double) ((this.gammaZeta) / gamma)), "zeta", 709, 29460, 29497);
                final double zetaC = CallChecker.varInit(((double) (zeta * c)), "zetaC", 718, 29511, 29776);
                final double zetaS = CallChecker.varInit(((double) (zeta * s)), "zetaS", 719, 29790, 29819);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.xL, RealVector.class, 720, 29847, 29848).getDimension())), "n", 720, 29833, 29864);
                for (int i = 0; i < n; i++) {
                    final double xi = CallChecker.varInit(((double) (CallChecker.isCalled(this.xL, RealVector.class, 722, 29942, 29943).getEntry(i))), "xi", 722, 29924, 29956);
                    final double vi = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 723, 29992, 29992).getEntry(i))), "vi", 723, 29974, 30005);
                    wbar = CallChecker.beforeCalled(wbar, RealVector.class, 724, 30041, 30044);
                    final double wi = CallChecker.varInit(((double) (CallChecker.isCalled(this.wbar, RealVector.class, 724, 30041, 30044).getEntry(i))), "wi", 724, 30023, 30057);
                    if (CallChecker.beforeDeref(xL, RealVector.class, 725, 30075, 30076)) {
                        CallChecker.isCalled(xL, RealVector.class, 725, 30075, 30076).setEntry(i, ((xi + (wi * zetaC)) + (vi * zetaS)));
                    }
                    if (CallChecker.beforeDeref(wbar, RealVector.class, 726, 30137, 30140)) {
                        wbar = CallChecker.beforeCalled(wbar, RealVector.class, 726, 30137, 30140);
                        CallChecker.isCalled(wbar, RealVector.class, 726, 30137, 30140).setEntry(i, ((wi * s) - (vi * c)));
                    }
                }
                bstep += ((snprod) * c) * zeta;
                CallChecker.varAssign(this.bstep, "this.bstep", 734, 30400, 30426);
                snprod *= s;
                CallChecker.varAssign(this.snprod, "this.snprod", 735, 30440, 30451);
                gmax = FastMath.max(gmax, gamma);
                CallChecker.varAssign(this.gmax, "this.gmax", 736, 30465, 30497);
                gmin = FastMath.min(gmin, gamma);
                CallChecker.varAssign(this.gmin, "this.gmin", 737, 30511, 30543);
                ynorm2 += zeta * zeta;
                CallChecker.varAssign(this.ynorm2, "this.ynorm2", 738, 30557, 30578);
                gammaZeta = (minusEpsZeta) - (deltak * zeta);
                CallChecker.varAssign(this.gammaZeta, "this.gammaZeta", 739, 30592, 30632);
                minusEpsZeta = (-eps) * zeta;
                CallChecker.varAssign(this.minusEpsZeta, "this.minusEpsZeta", 740, 30646, 30672);
                updateNorms();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4592.methodEnd();
            }
        }

        private void updateNorms() {
            MethodContext _bcornu_methode_context4593 = new MethodContext(void.class, 760, 31381, 33182);
            try {
                CallChecker.varInit(this, "this", 760, 31381, 33182);
                CallChecker.varInit(this.bIsNull, "bIsNull", 760, 31381, 33182);
                CallChecker.varInit(this.ynorm2, "ynorm2", 760, 31381, 33182);
                CallChecker.varInit(this.y, "y", 760, 31381, 33182);
                CallChecker.varInit(this.xL, "xL", 760, 31381, 33182);
                CallChecker.varInit(this.wbar, "wbar", 760, 31381, 33182);
                CallChecker.varInit(this.tnorm, "tnorm", 760, 31381, 33182);
                CallChecker.varInit(this.snprod, "snprod", 760, 31381, 33182);
                CallChecker.varInit(this.shift, "shift", 760, 31381, 33182);
                CallChecker.varInit(this.rnorm, "rnorm", 760, 31381, 33182);
                CallChecker.varInit(this.r2, "r2", 760, 31381, 33182);
                CallChecker.varInit(this.r1, "r1", 760, 31381, 33182);
                CallChecker.varInit(this.oldb, "oldb", 760, 31381, 33182);
                CallChecker.varInit(this.mb, "mb", 760, 31381, 33182);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 760, 31381, 33182);
                CallChecker.varInit(this.m, "m", 760, 31381, 33182);
                CallChecker.varInit(this.lqnorm, "lqnorm", 760, 31381, 33182);
                CallChecker.varInit(this.hasConverged, "hasConverged", 760, 31381, 33182);
                CallChecker.varInit(this.goodb, "goodb", 760, 31381, 33182);
                CallChecker.varInit(this.gmin, "gmin", 760, 31381, 33182);
                CallChecker.varInit(this.gmax, "gmax", 760, 31381, 33182);
                CallChecker.varInit(this.gbar, "gbar", 760, 31381, 33182);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 760, 31381, 33182);
                CallChecker.varInit(this.dbar, "dbar", 760, 31381, 33182);
                CallChecker.varInit(this.cgnorm, "cgnorm", 760, 31381, 33182);
                CallChecker.varInit(this.bstep, "bstep", 760, 31381, 33182);
                CallChecker.varInit(this.beta1, "beta1", 760, 31381, 33182);
                CallChecker.varInit(this.beta, "beta", 760, 31381, 33182);
                CallChecker.varInit(this.delta, "delta", 760, 31381, 33182);
                CallChecker.varInit(this.check, "check", 760, 31381, 33182);
                CallChecker.varInit(this.b, "b", 760, 31381, 33182);
                CallChecker.varInit(this.a, "a", 760, 31381, 33182);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 760, 31381, 33182);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 760, 31381, 33182);
                final double anorm = CallChecker.varInit(((double) (FastMath.sqrt(this.tnorm))), "anorm", 761, 31578, 31619);
                final double ynorm = CallChecker.varInit(((double) (FastMath.sqrt(this.ynorm2))), "ynorm", 762, 31633, 31675);
                final double epsa = CallChecker.varInit(((double) (anorm * (SymmLQ.State.MACH_PREC))), "epsa", 763, 31689, 31726);
                final double epsx = CallChecker.varInit(((double) ((anorm * ynorm) * (SymmLQ.State.MACH_PREC))), "epsx", 764, 31740, 31785);
                final double epsr = CallChecker.varInit(((double) ((anorm * ynorm) * (this.delta))), "epsr", 765, 31799, 31840);
                double diag = CallChecker.init(double.class);
                if ((gbar) == 0.0) {
                    diag = epsa;
                    CallChecker.varAssign(diag, "diag", 766, 31874, 31897);
                }else {
                    diag = gbar;
                    CallChecker.varAssign(diag, "diag", 766, 31874, 31897);
                }
                lqnorm = FastMath.sqrt((((gammaZeta) * (gammaZeta)) + ((minusEpsZeta) * (minusEpsZeta))));
                CallChecker.varAssign(this.lqnorm, "this.lqnorm", 767, 31912, 32022);
                final double qrnorm = CallChecker.varInit(((double) ((this.snprod) * (this.beta1))), "qrnorm", 769, 32036, 32072);
                cgnorm = (qrnorm * (beta)) / (FastMath.abs(diag));
                CallChecker.varAssign(this.cgnorm, "this.cgnorm", 770, 32086, 32129);
                double acond = CallChecker.init(double.class);
                if ((lqnorm) <= (cgnorm)) {
                    acond = (gmax) / (gmin);
                    CallChecker.varAssign(acond, "acond", 780, 32551, 32570);
                }else {
                    acond = (gmax) / (FastMath.min(gmin, FastMath.abs(diag)));
                    CallChecker.varAssign(acond, "acond", 782, 32609, 32662);
                }
                if ((acond * (SymmLQ.State.MACH_PREC)) >= 0.1) {
                    throw new IllConditionedOperatorException(acond);
                }
                if ((beta1) <= epsx) {
                    throw new SingularOperatorException();
                }
                rnorm = FastMath.min(cgnorm, lqnorm);
                CallChecker.varAssign(this.rnorm, "this.rnorm", 794, 33071, 33107);
                hasConverged = ((cgnorm) <= epsx) || ((cgnorm) <= epsr);
                CallChecker.varAssign(this.hasConverged, "this.hasConverged", 795, 33121, 33172);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4593.methodEnd();
            }
        }

        boolean hasConverged() {
            MethodContext _bcornu_methode_context4594 = new MethodContext(boolean.class, 803, 33193, 33451);
            try {
                CallChecker.varInit(this, "this", 803, 33193, 33451);
                CallChecker.varInit(this.bIsNull, "bIsNull", 803, 33193, 33451);
                CallChecker.varInit(this.ynorm2, "ynorm2", 803, 33193, 33451);
                CallChecker.varInit(this.y, "y", 803, 33193, 33451);
                CallChecker.varInit(this.xL, "xL", 803, 33193, 33451);
                CallChecker.varInit(this.wbar, "wbar", 803, 33193, 33451);
                CallChecker.varInit(this.tnorm, "tnorm", 803, 33193, 33451);
                CallChecker.varInit(this.snprod, "snprod", 803, 33193, 33451);
                CallChecker.varInit(this.shift, "shift", 803, 33193, 33451);
                CallChecker.varInit(this.rnorm, "rnorm", 803, 33193, 33451);
                CallChecker.varInit(this.r2, "r2", 803, 33193, 33451);
                CallChecker.varInit(this.r1, "r1", 803, 33193, 33451);
                CallChecker.varInit(this.oldb, "oldb", 803, 33193, 33451);
                CallChecker.varInit(this.mb, "mb", 803, 33193, 33451);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 803, 33193, 33451);
                CallChecker.varInit(this.m, "m", 803, 33193, 33451);
                CallChecker.varInit(this.lqnorm, "lqnorm", 803, 33193, 33451);
                CallChecker.varInit(this.hasConverged, "hasConverged", 803, 33193, 33451);
                CallChecker.varInit(this.goodb, "goodb", 803, 33193, 33451);
                CallChecker.varInit(this.gmin, "gmin", 803, 33193, 33451);
                CallChecker.varInit(this.gmax, "gmax", 803, 33193, 33451);
                CallChecker.varInit(this.gbar, "gbar", 803, 33193, 33451);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 803, 33193, 33451);
                CallChecker.varInit(this.dbar, "dbar", 803, 33193, 33451);
                CallChecker.varInit(this.cgnorm, "cgnorm", 803, 33193, 33451);
                CallChecker.varInit(this.bstep, "bstep", 803, 33193, 33451);
                CallChecker.varInit(this.beta1, "beta1", 803, 33193, 33451);
                CallChecker.varInit(this.beta, "beta", 803, 33193, 33451);
                CallChecker.varInit(this.delta, "delta", 803, 33193, 33451);
                CallChecker.varInit(this.check, "check", 803, 33193, 33451);
                CallChecker.varInit(this.b, "b", 803, 33193, 33451);
                CallChecker.varInit(this.a, "a", 803, 33193, 33451);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 803, 33193, 33451);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 803, 33193, 33451);
                return hasConverged;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4594.methodEnd();
            }
        }

        boolean bEqualsNullVector() {
            MethodContext _bcornu_methode_context4595 = new MethodContext(boolean.class, 812, 33462, 33697);
            try {
                CallChecker.varInit(this, "this", 812, 33462, 33697);
                CallChecker.varInit(this.bIsNull, "bIsNull", 812, 33462, 33697);
                CallChecker.varInit(this.ynorm2, "ynorm2", 812, 33462, 33697);
                CallChecker.varInit(this.y, "y", 812, 33462, 33697);
                CallChecker.varInit(this.xL, "xL", 812, 33462, 33697);
                CallChecker.varInit(this.wbar, "wbar", 812, 33462, 33697);
                CallChecker.varInit(this.tnorm, "tnorm", 812, 33462, 33697);
                CallChecker.varInit(this.snprod, "snprod", 812, 33462, 33697);
                CallChecker.varInit(this.shift, "shift", 812, 33462, 33697);
                CallChecker.varInit(this.rnorm, "rnorm", 812, 33462, 33697);
                CallChecker.varInit(this.r2, "r2", 812, 33462, 33697);
                CallChecker.varInit(this.r1, "r1", 812, 33462, 33697);
                CallChecker.varInit(this.oldb, "oldb", 812, 33462, 33697);
                CallChecker.varInit(this.mb, "mb", 812, 33462, 33697);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 812, 33462, 33697);
                CallChecker.varInit(this.m, "m", 812, 33462, 33697);
                CallChecker.varInit(this.lqnorm, "lqnorm", 812, 33462, 33697);
                CallChecker.varInit(this.hasConverged, "hasConverged", 812, 33462, 33697);
                CallChecker.varInit(this.goodb, "goodb", 812, 33462, 33697);
                CallChecker.varInit(this.gmin, "gmin", 812, 33462, 33697);
                CallChecker.varInit(this.gmax, "gmax", 812, 33462, 33697);
                CallChecker.varInit(this.gbar, "gbar", 812, 33462, 33697);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 812, 33462, 33697);
                CallChecker.varInit(this.dbar, "dbar", 812, 33462, 33697);
                CallChecker.varInit(this.cgnorm, "cgnorm", 812, 33462, 33697);
                CallChecker.varInit(this.bstep, "bstep", 812, 33462, 33697);
                CallChecker.varInit(this.beta1, "beta1", 812, 33462, 33697);
                CallChecker.varInit(this.beta, "beta", 812, 33462, 33697);
                CallChecker.varInit(this.delta, "delta", 812, 33462, 33697);
                CallChecker.varInit(this.check, "check", 812, 33462, 33697);
                CallChecker.varInit(this.b, "b", 812, 33462, 33697);
                CallChecker.varInit(this.a, "a", 812, 33462, 33697);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 812, 33462, 33697);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 812, 33462, 33697);
                return bIsNull;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4595.methodEnd();
            }
        }

        boolean betaEqualsZero() {
            MethodContext _bcornu_methode_context4596 = new MethodContext(boolean.class, 822, 33708, 34027);
            try {
                CallChecker.varInit(this, "this", 822, 33708, 34027);
                CallChecker.varInit(this.bIsNull, "bIsNull", 822, 33708, 34027);
                CallChecker.varInit(this.ynorm2, "ynorm2", 822, 33708, 34027);
                CallChecker.varInit(this.y, "y", 822, 33708, 34027);
                CallChecker.varInit(this.xL, "xL", 822, 33708, 34027);
                CallChecker.varInit(this.wbar, "wbar", 822, 33708, 34027);
                CallChecker.varInit(this.tnorm, "tnorm", 822, 33708, 34027);
                CallChecker.varInit(this.snprod, "snprod", 822, 33708, 34027);
                CallChecker.varInit(this.shift, "shift", 822, 33708, 34027);
                CallChecker.varInit(this.rnorm, "rnorm", 822, 33708, 34027);
                CallChecker.varInit(this.r2, "r2", 822, 33708, 34027);
                CallChecker.varInit(this.r1, "r1", 822, 33708, 34027);
                CallChecker.varInit(this.oldb, "oldb", 822, 33708, 34027);
                CallChecker.varInit(this.mb, "mb", 822, 33708, 34027);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 822, 33708, 34027);
                CallChecker.varInit(this.m, "m", 822, 33708, 34027);
                CallChecker.varInit(this.lqnorm, "lqnorm", 822, 33708, 34027);
                CallChecker.varInit(this.hasConverged, "hasConverged", 822, 33708, 34027);
                CallChecker.varInit(this.goodb, "goodb", 822, 33708, 34027);
                CallChecker.varInit(this.gmin, "gmin", 822, 33708, 34027);
                CallChecker.varInit(this.gmax, "gmax", 822, 33708, 34027);
                CallChecker.varInit(this.gbar, "gbar", 822, 33708, 34027);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 822, 33708, 34027);
                CallChecker.varInit(this.dbar, "dbar", 822, 33708, 34027);
                CallChecker.varInit(this.cgnorm, "cgnorm", 822, 33708, 34027);
                CallChecker.varInit(this.bstep, "bstep", 822, 33708, 34027);
                CallChecker.varInit(this.beta1, "beta1", 822, 33708, 34027);
                CallChecker.varInit(this.beta, "beta", 822, 33708, 34027);
                CallChecker.varInit(this.delta, "delta", 822, 33708, 34027);
                CallChecker.varInit(this.check, "check", 822, 33708, 34027);
                CallChecker.varInit(this.b, "b", 822, 33708, 34027);
                CallChecker.varInit(this.a, "a", 822, 33708, 34027);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 822, 33708, 34027);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 822, 33708, 34027);
                return (beta) < (SymmLQ.State.MACH_PREC);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4596.methodEnd();
            }
        }

        double getNormOfResidual() {
            MethodContext _bcornu_methode_context4597 = new MethodContext(double.class, 831, 34038, 34260);
            try {
                CallChecker.varInit(this, "this", 831, 34038, 34260);
                CallChecker.varInit(this.bIsNull, "bIsNull", 831, 34038, 34260);
                CallChecker.varInit(this.ynorm2, "ynorm2", 831, 34038, 34260);
                CallChecker.varInit(this.y, "y", 831, 34038, 34260);
                CallChecker.varInit(this.xL, "xL", 831, 34038, 34260);
                CallChecker.varInit(this.wbar, "wbar", 831, 34038, 34260);
                CallChecker.varInit(this.tnorm, "tnorm", 831, 34038, 34260);
                CallChecker.varInit(this.snprod, "snprod", 831, 34038, 34260);
                CallChecker.varInit(this.shift, "shift", 831, 34038, 34260);
                CallChecker.varInit(this.rnorm, "rnorm", 831, 34038, 34260);
                CallChecker.varInit(this.r2, "r2", 831, 34038, 34260);
                CallChecker.varInit(this.r1, "r1", 831, 34038, 34260);
                CallChecker.varInit(this.oldb, "oldb", 831, 34038, 34260);
                CallChecker.varInit(this.mb, "mb", 831, 34038, 34260);
                CallChecker.varInit(this.minusEpsZeta, "minusEpsZeta", 831, 34038, 34260);
                CallChecker.varInit(this.m, "m", 831, 34038, 34260);
                CallChecker.varInit(this.lqnorm, "lqnorm", 831, 34038, 34260);
                CallChecker.varInit(this.hasConverged, "hasConverged", 831, 34038, 34260);
                CallChecker.varInit(this.goodb, "goodb", 831, 34038, 34260);
                CallChecker.varInit(this.gmin, "gmin", 831, 34038, 34260);
                CallChecker.varInit(this.gmax, "gmax", 831, 34038, 34260);
                CallChecker.varInit(this.gbar, "gbar", 831, 34038, 34260);
                CallChecker.varInit(this.gammaZeta, "gammaZeta", 831, 34038, 34260);
                CallChecker.varInit(this.dbar, "dbar", 831, 34038, 34260);
                CallChecker.varInit(this.cgnorm, "cgnorm", 831, 34038, 34260);
                CallChecker.varInit(this.bstep, "bstep", 831, 34038, 34260);
                CallChecker.varInit(this.beta1, "beta1", 831, 34038, 34260);
                CallChecker.varInit(this.beta, "beta", 831, 34038, 34260);
                CallChecker.varInit(this.delta, "delta", 831, 34038, 34260);
                CallChecker.varInit(this.check, "check", 831, 34038, 34260);
                CallChecker.varInit(this.b, "b", 831, 34038, 34260);
                CallChecker.varInit(this.a, "a", 831, 34038, 34260);
                CallChecker.varInit(MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.MACH_PREC", 831, 34038, 34260);
                CallChecker.varInit(CBRT_MACH_PREC, "org.apache.commons.math3.linear.SymmLQ.State.CBRT_MACH_PREC", 831, 34038, 34260);
                return rnorm;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4597.methodEnd();
            }
        }
    }

    private static final String OPERATOR = "operator";

    private static final String THRESHOLD = "threshold";

    private static final String VECTOR = "vector";

    private static final String VECTOR1 = "vector1";

    private static final String VECTOR2 = "vector2";

    private final boolean check;

    private final double delta;

    public SymmLQ(final int maxIterations, final double delta, final boolean check) {
        super(maxIterations);
        ConstructorContext _bcornu_methode_context1037 = new ConstructorContext(SymmLQ.class, 870, 35011, 35701);
        try {
            this.delta = delta;
            CallChecker.varAssign(this.delta, "this.delta", 873, 35649, 35667);
            this.check = check;
            CallChecker.varAssign(this.check, "this.check", 874, 35677, 35695);
        } finally {
            _bcornu_methode_context1037.methodEnd();
        }
    }

    public SymmLQ(final IterationManager manager, final double delta, final boolean check) {
        super(manager);
        ConstructorContext _bcornu_methode_context1038 = new ConstructorContext(SymmLQ.class, 888, 35708, 36425);
        try {
            this.delta = delta;
            CallChecker.varAssign(this.delta, "this.delta", 891, 36373, 36391);
            this.check = check;
            CallChecker.varAssign(this.check, "this.check", 892, 36401, 36419);
        } finally {
            _bcornu_methode_context1038.methodEnd();
        }
    }

    public final boolean getCheck() {
        MethodContext _bcornu_methode_context4598 = new MethodContext(boolean.class, 901, 36432, 36725);
        try {
            CallChecker.varInit(this, "this", 901, 36432, 36725);
            CallChecker.varInit(this.delta, "delta", 901, 36432, 36725);
            CallChecker.varInit(this.check, "check", 901, 36432, 36725);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 901, 36432, 36725);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 901, 36432, 36725);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 901, 36432, 36725);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 901, 36432, 36725);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 901, 36432, 36725);
            return check;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4598.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealLinearOperator m, final RealVector b) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonPositiveDefiniteOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4599 = new MethodContext(RealVector.class, 915, 36732, 37630);
        try {
            CallChecker.varInit(this, "this", 915, 36732, 37630);
            CallChecker.varInit(b, "b", 915, 36732, 37630);
            CallChecker.varInit(m, "m", 915, 36732, 37630);
            CallChecker.varInit(a, "a", 915, 36732, 37630);
            CallChecker.varInit(this.delta, "delta", 915, 36732, 37630);
            CallChecker.varInit(this.check, "check", 915, 36732, 37630);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 915, 36732, 37630);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 915, 36732, 37630);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 915, 36732, 37630);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 915, 36732, 37630);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 915, 36732, 37630);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 922, 37549, 37549).getColumnDimension()), "x", 922, 37508, 37572);
            return solveInPlace(a, m, b, x, false, 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4599.methodEnd();
        }
    }

    public RealVector solve(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final boolean goodb, final double shift) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonPositiveDefiniteOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4600 = new MethodContext(RealVector.class, 966, 37637, 40434);
        try {
            CallChecker.varInit(this, "this", 966, 37637, 40434);
            CallChecker.varInit(shift, "shift", 966, 37637, 40434);
            CallChecker.varInit(goodb, "goodb", 966, 37637, 40434);
            CallChecker.varInit(b, "b", 966, 37637, 40434);
            CallChecker.varInit(m, "m", 966, 37637, 40434);
            CallChecker.varInit(a, "a", 966, 37637, 40434);
            CallChecker.varInit(this.delta, "delta", 966, 37637, 40434);
            CallChecker.varInit(this.check, "check", 966, 37637, 40434);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 966, 37637, 40434);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 966, 37637, 40434);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 966, 37637, 40434);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 966, 37637, 40434);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 966, 37637, 40434);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 973, 40350, 40350).getColumnDimension()), "x", 973, 40309, 40373);
            return solveInPlace(a, m, b, x, goodb, shift);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4600.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonPositiveDefiniteOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4601 = new MethodContext(RealVector.class, 989, 40441, 41431);
        try {
            CallChecker.varInit(this, "this", 989, 40441, 41431);
            CallChecker.varInit(x, "x", 989, 40441, 41431);
            CallChecker.varInit(b, "b", 989, 40441, 41431);
            CallChecker.varInit(m, "m", 989, 40441, 41431);
            CallChecker.varInit(a, "a", 989, 40441, 41431);
            CallChecker.varInit(this.delta, "delta", 989, 40441, 41431);
            CallChecker.varInit(this.check, "check", 989, 40441, 41431);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 989, 40441, 41431);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 989, 40441, 41431);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 989, 40441, 41431);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 989, 40441, 41431);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 989, 40441, 41431);
            MathUtils.checkNotNull(x);
            if (CallChecker.beforeDeref(x, RealVector.class, 996, 41405, 41405)) {
                return solveInPlace(a, m, b, CallChecker.isCalled(x, RealVector.class, 996, 41405, 41405).copy(), false, 0.0);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4601.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealVector b) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4602 = new MethodContext(RealVector.class, 1007, 41438, 42166);
        try {
            CallChecker.varInit(this, "this", 1007, 41438, 42166);
            CallChecker.varInit(b, "b", 1007, 41438, 42166);
            CallChecker.varInit(a, "a", 1007, 41438, 42166);
            CallChecker.varInit(this.delta, "delta", 1007, 41438, 42166);
            CallChecker.varInit(this.check, "check", 1007, 41438, 42166);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1007, 41438, 42166);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1007, 41438, 42166);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1007, 41438, 42166);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1007, 41438, 42166);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1007, 41438, 42166);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 1012, 42063, 42063).getColumnDimension()), "x", 1012, 42022, 42086);
            if (CallChecker.beforeDeref(x, RealVector.class, 1013, 42096, 42096)) {
                CallChecker.isCalled(x, RealVector.class, 1013, 42096, 42096).set(0.0);
            }
            return solveInPlace(a, null, b, x, false, 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4602.methodEnd();
        }
    }

    public RealVector solve(final RealLinearOperator a, final RealVector b, final boolean goodb, final double shift) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4603 = new MethodContext(RealVector.class, 1052, 42173, 44592);
        try {
            CallChecker.varInit(this, "this", 1052, 42173, 44592);
            CallChecker.varInit(shift, "shift", 1052, 42173, 44592);
            CallChecker.varInit(goodb, "goodb", 1052, 42173, 44592);
            CallChecker.varInit(b, "b", 1052, 42173, 44592);
            CallChecker.varInit(a, "a", 1052, 42173, 44592);
            CallChecker.varInit(this.delta, "delta", 1052, 42173, 44592);
            CallChecker.varInit(this.check, "check", 1052, 42173, 44592);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1052, 42173, 44592);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1052, 42173, 44592);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1052, 42173, 44592);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1052, 42173, 44592);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1052, 42173, 44592);
            MathUtils.checkNotNull(a);
            final RealVector x = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(a, RealLinearOperator.class, 1058, 44505, 44505).getColumnDimension()), "x", 1058, 44464, 44528);
            return solveInPlace(a, null, b, x, goodb, shift);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4603.methodEnd();
        }
    }

    @Override
    public RealVector solve(final RealLinearOperator a, final RealVector b, final RealVector x) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4604 = new MethodContext(RealVector.class, 1072, 44599, 45408);
        try {
            CallChecker.varInit(this, "this", 1072, 44599, 45408);
            CallChecker.varInit(x, "x", 1072, 44599, 45408);
            CallChecker.varInit(b, "b", 1072, 44599, 45408);
            CallChecker.varInit(a, "a", 1072, 44599, 45408);
            CallChecker.varInit(this.delta, "delta", 1072, 44599, 45408);
            CallChecker.varInit(this.check, "check", 1072, 44599, 45408);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1072, 44599, 45408);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1072, 44599, 45408);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1072, 44599, 45408);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1072, 44599, 45408);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1072, 44599, 45408);
            MathUtils.checkNotNull(x);
            if (CallChecker.beforeDeref(x, RealVector.class, 1078, 45382, 45382)) {
                return solveInPlace(a, null, b, CallChecker.isCalled(x, RealVector.class, 1078, 45382, 45382).copy(), false, 0.0);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4604.methodEnd();
        }
    }

    @Override
    public RealVector solveInPlace(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonPositiveDefiniteOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4605 = new MethodContext(RealVector.class, 1093, 45415, 46385);
        try {
            CallChecker.varInit(this, "this", 1093, 45415, 46385);
            CallChecker.varInit(x, "x", 1093, 45415, 46385);
            CallChecker.varInit(b, "b", 1093, 45415, 46385);
            CallChecker.varInit(m, "m", 1093, 45415, 46385);
            CallChecker.varInit(a, "a", 1093, 45415, 46385);
            CallChecker.varInit(this.delta, "delta", 1093, 45415, 46385);
            CallChecker.varInit(this.check, "check", 1093, 45415, 46385);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1093, 45415, 46385);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1093, 45415, 46385);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1093, 45415, 46385);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1093, 45415, 46385);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1093, 45415, 46385);
            return solveInPlace(a, m, b, x, false, 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4605.methodEnd();
        }
    }

    public RealVector solveInPlace(final RealLinearOperator a, final RealLinearOperator m, final RealVector b, final RealVector x, final boolean goodb, final double shift) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonPositiveDefiniteOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4606 = new MethodContext(RealVector.class, 1144, 46392, 51896);
        try {
            CallChecker.varInit(this, "this", 1144, 46392, 51896);
            CallChecker.varInit(shift, "shift", 1144, 46392, 51896);
            CallChecker.varInit(goodb, "goodb", 1144, 46392, 51896);
            CallChecker.varInit(x, "x", 1144, 46392, 51896);
            CallChecker.varInit(b, "b", 1144, 46392, 51896);
            CallChecker.varInit(m, "m", 1144, 46392, 51896);
            CallChecker.varInit(a, "a", 1144, 46392, 51896);
            CallChecker.varInit(this.delta, "delta", 1144, 46392, 51896);
            CallChecker.varInit(this.check, "check", 1144, 46392, 51896);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1144, 46392, 51896);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1144, 46392, 51896);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1144, 46392, 51896);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1144, 46392, 51896);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1144, 46392, 51896);
            PreconditionedIterativeLinearSolver.checkParameters(a, m, b, x);
            final IterationManager manager = CallChecker.varInit(getIterationManager(), "manager", 1153, 49304, 49358);
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1155, 49421, 49427)) {
                CallChecker.isCalled(manager, IterationManager.class, 1155, 49421, 49427).resetIterationCount();
            }
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1156, 49460, 49466)) {
                CallChecker.isCalled(manager, IterationManager.class, 1156, 49460, 49466).incrementIterationCount();
            }
            SymmLQ.State state = CallChecker.init(SymmLQ.State.class);
            state = new SymmLQ.State(a, m, b, goodb, shift, delta, check);
            CallChecker.varAssign(state, "state", 1159, 49531, 49585);
            if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1160, 49595, 49599)) {
                state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1160, 49595, 49599);
                CallChecker.isCalled(state, SymmLQ.State.class, 1160, 49595, 49599).init();
            }
            if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1161, 49617, 49621)) {
                state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1161, 49617, 49621);
                CallChecker.isCalled(state, SymmLQ.State.class, 1161, 49617, 49621).refineSolution(x);
            }
            IterativeLinearSolverEvent event = CallChecker.init(IterativeLinearSolverEvent.class);
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1164, 49798, 49804)) {
                if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1167, 49991, 49995)) {
                    state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1167, 49991, 49995);
                    event = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 1164, 49798, 49804).getIterations(), x, b, CallChecker.isCalled(state, SymmLQ.State.class, 1167, 49991, 49995).getNormOfResidual());
                    CallChecker.varAssign(event, "event", 1163, 49692, 50017);
                }
            }
            if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1168, 50031, 50035)) {
                state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1168, 50031, 50035);
                if (CallChecker.isCalled(state, SymmLQ.State.class, 1168, 50031, 50035).bEqualsNullVector()) {
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1170, 50125, 50131)) {
                        CallChecker.isCalled(manager, IterationManager.class, 1170, 50125, 50131).fireTerminationEvent(event);
                    }
                    return x;
                }
            }else
                throw new AbnormalExecutionError();
            
            boolean earlyStop = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1175, 50308, 50312)) {
                if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1175, 50334, 50338)) {
                    state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1175, 50308, 50312);
                    state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1175, 50334, 50338);
                    earlyStop = (CallChecker.isCalled(state, SymmLQ.State.class, 1175, 50308, 50312).betaEqualsZero()) || (CallChecker.isCalled(state, SymmLQ.State.class, 1175, 50334, 50338).hasConverged());
                    CallChecker.varAssign(earlyStop, "earlyStop", 1175, 50296, 50354);
                }
            }
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1176, 50364, 50370)) {
                CallChecker.isCalled(manager, IterationManager.class, 1176, 50364, 50370).fireInitializationEvent(event);
            }
            if (!earlyStop) {
                state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1194, 51461, 51465);
                do {
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1179, 50463, 50469)) {
                        CallChecker.isCalled(manager, IterationManager.class, 1179, 50463, 50469).incrementIterationCount();
                    }
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1181, 50628, 50634)) {
                        if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1184, 50845, 50849)) {
                            state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1184, 50845, 50849);
                            event = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 1181, 50628, 50634).getIterations(), x, b, CallChecker.isCalled(state, SymmLQ.State.class, 1184, 50845, 50849).getNormOfResidual());
                            CallChecker.varAssign(event, "event", 1180, 50514, 50871);
                        }
                    }
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1185, 50889, 50895)) {
                        CallChecker.isCalled(manager, IterationManager.class, 1185, 50889, 50895).fireIterationStartedEvent(event);
                    }
                    if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1186, 50947, 50951)) {
                        state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1186, 50947, 50951);
                        CallChecker.isCalled(state, SymmLQ.State.class, 1186, 50947, 50951).update();
                    }
                    if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1187, 50979, 50983)) {
                        state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1187, 50979, 50983);
                        CallChecker.isCalled(state, SymmLQ.State.class, 1187, 50979, 50983).refineSolution(x);
                    }
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1189, 51134, 51140)) {
                        if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1192, 51351, 51355)) {
                            state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1192, 51351, 51355);
                            event = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 1189, 51134, 51140).getIterations(), x, b, CallChecker.isCalled(state, SymmLQ.State.class, 1192, 51351, 51355).getNormOfResidual());
                            CallChecker.varAssign(event, "event", 1188, 51020, 51377);
                        }
                    }
                    if (CallChecker.beforeDeref(manager, IterationManager.class, 1193, 51395, 51401)) {
                        CallChecker.isCalled(manager, IterationManager.class, 1193, 51395, 51401).fireIterationPerformedEvent(event);
                    }
                } while (!(CallChecker.isCalled(state, SymmLQ.State.class, 1194, 51461, 51465).hasConverged()) );
            }
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1197, 51608, 51614)) {
                if (CallChecker.beforeDeref(state, SymmLQ.State.class, 1200, 51801, 51805)) {
                    state = CallChecker.beforeCalled(state, SymmLQ.State.class, 1200, 51801, 51805);
                    event = new DefaultIterativeLinearSolverEvent(this, CallChecker.isCalled(manager, IterationManager.class, 1197, 51608, 51614).getIterations(), x, b, CallChecker.isCalled(state, SymmLQ.State.class, 1200, 51801, 51805).getNormOfResidual());
                    CallChecker.varAssign(event, "event", 1196, 51502, 51827);
                }
            }
            if (CallChecker.beforeDeref(manager, IterationManager.class, 1201, 51837, 51843)) {
                CallChecker.isCalled(manager, IterationManager.class, 1201, 51837, 51843).fireTerminationEvent(event);
            }
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4606.methodEnd();
        }
    }

    @Override
    public RealVector solveInPlace(final RealLinearOperator a, final RealVector b, final RealVector x) throws DimensionMismatchException, MaxCountExceededException, NullArgumentException, IllConditionedOperatorException, NonSelfAdjointOperatorException, NonSquareOperatorException {
        MethodContext _bcornu_methode_context4607 = new MethodContext(RealVector.class, 1215, 51903, 52692);
        try {
            CallChecker.varInit(this, "this", 1215, 51903, 52692);
            CallChecker.varInit(x, "x", 1215, 51903, 52692);
            CallChecker.varInit(b, "b", 1215, 51903, 52692);
            CallChecker.varInit(a, "a", 1215, 51903, 52692);
            CallChecker.varInit(this.delta, "delta", 1215, 51903, 52692);
            CallChecker.varInit(this.check, "check", 1215, 51903, 52692);
            CallChecker.varInit(VECTOR2, "org.apache.commons.math3.linear.SymmLQ.VECTOR2", 1215, 51903, 52692);
            CallChecker.varInit(VECTOR1, "org.apache.commons.math3.linear.SymmLQ.VECTOR1", 1215, 51903, 52692);
            CallChecker.varInit(VECTOR, "org.apache.commons.math3.linear.SymmLQ.VECTOR", 1215, 51903, 52692);
            CallChecker.varInit(THRESHOLD, "org.apache.commons.math3.linear.SymmLQ.THRESHOLD", 1215, 51903, 52692);
            CallChecker.varInit(OPERATOR, "org.apache.commons.math3.linear.SymmLQ.OPERATOR", 1215, 51903, 52692);
            return solveInPlace(a, null, b, x, false, 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4607.methodEnd();
        }
    }
}

