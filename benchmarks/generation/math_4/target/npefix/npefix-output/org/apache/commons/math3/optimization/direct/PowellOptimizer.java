package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.univariate.BracketFinder;
import org.apache.commons.math3.optimization.univariate.BrentOptimizer;
import org.apache.commons.math3.optimization.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optimization.univariate.UnivariatePointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

@Deprecated
public class PowellOptimizer extends BaseAbstractMultivariateOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private class LineSearch extends BrentOptimizer {
        private static final double REL_TOL_UNUSED = 1.0E-15;

        private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;

        private final BracketFinder bracket = new BracketFinder();

        LineSearch(double rel, double abs) {
            super(PowellOptimizer.LineSearch.REL_TOL_UNUSED, PowellOptimizer.LineSearch.ABS_TOL_UNUSED, new SimpleUnivariateValueChecker(rel, abs));
            ConstructorContext _bcornu_methode_context781 = new ConstructorContext(PowellOptimizer.LineSearch.class, 315, 11482, 12014);
            try {
            } finally {
                _bcornu_methode_context781.methodEnd();
            }
        }

        public UnivariatePointValuePair search(final double[] p, final double[] d) {
            MethodContext _bcornu_methode_context3483 = new MethodContext(UnivariatePointValuePair.class, 331, 12025, 13428);
            try {
                CallChecker.varInit(this, "this", 331, 12025, 13428);
                CallChecker.varInit(d, "d", 331, 12025, 13428);
                CallChecker.varInit(p, "p", 331, 12025, 13428);
                CallChecker.varInit(this.bracket, "bracket", 331, 12025, 13428);
                CallChecker.varInit(ABS_TOL_UNUSED, "org.apache.commons.math3.optimization.direct.PowellOptimizer.LineSearch.ABS_TOL_UNUSED", 331, 12025, 13428);
                CallChecker.varInit(REL_TOL_UNUSED, "org.apache.commons.math3.optimization.direct.PowellOptimizer.LineSearch.REL_TOL_UNUSED", 331, 12025, 13428);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(p, double[].class, 332, 12474, 12474).length)), "n", 332, 12460, 12482);
                final UnivariateFunction f = new UnivariateFunction() {
                    public double value(double alpha) {
                        MethodContext _bcornu_methode_context3482 = new MethodContext(double.class, 334, 12572, 12948);
                        try {
                            CallChecker.varInit(this, "this", 334, 12572, 12948);
                            CallChecker.varInit(alpha, "alpha", 334, 12572, 12948);
                            final double[] x = CallChecker.varInit(new double[n], "x", 335, 12632, 12664);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(x, double[].class, 337, 12748, 12748)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 337, 12755, 12755)) {
                                        if (CallChecker.beforeDeref(d, double[].class, 337, 12770, 12770)) {
                                            CallChecker.isCalled(x, double[].class, 337, 12748, 12748)[i] = (CallChecker.isCalled(p, double[].class, 337, 12755, 12755)[i]) + (alpha * (CallChecker.isCalled(d, double[].class, 337, 12770, 12770)[i]));
                                            CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 337, 12748, 12748)[i], "CallChecker.isCalled(x, double[].class, 337, 12748, 12748)[i]", 337, 12748, 12774);
                                        }
                                    }
                                }
                            }
                            final double obj = CallChecker.varInit(((double) (PowellOptimizer.this.computeObjectiveValue(x))), "obj", 339, 12826, 12890);
                            return obj;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Double) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context3482.methodEnd();
                        }
                    }
                };
                final GoalType goal = CallChecker.varInit(PowellOptimizer.this.getGoalType(), "goal", 344, 12982, 13038);
                if (CallChecker.beforeDeref(bracket, BracketFinder.class, 345, 13052, 13058)) {
                    CallChecker.isCalled(bracket, BracketFinder.class, 345, 13052, 13058).search(f, goal, 0, 1);
                }
                if (CallChecker.beforeDeref(bracket, BracketFinder.class, 350, 13367, 13373)) {
                    if (CallChecker.beforeDeref(bracket, BracketFinder.class, 350, 13384, 13390)) {
                        if (CallChecker.beforeDeref(bracket, BracketFinder.class, 350, 13401, 13407)) {
                            return optimize(Integer.MAX_VALUE, f, goal, CallChecker.isCalled(bracket, BracketFinder.class, 350, 13367, 13373).getLo(), CallChecker.isCalled(bracket, BracketFinder.class, 350, 13384, 13390).getHi(), CallChecker.isCalled(bracket, BracketFinder.class, 350, 13401, 13407).getMid());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3483.methodEnd();
            }
        }
    }

    private static final double MIN_RELATIVE_TOLERANCE = 2 * (FastMath.ulp(1.0));

    private final double relativeThreshold;

    private final double absoluteThreshold;

    private final PowellOptimizer.LineSearch line;

    public PowellOptimizer(double rel, double abs, ConvergenceChecker<PointValuePair> checker) {
        this(rel, abs, FastMath.sqrt(rel), FastMath.sqrt(abs), checker);
        ConstructorContext _bcornu_methode_context782 = new ConstructorContext(PowellOptimizer.class, 88, 2972, 3808);
        try {
        } finally {
            _bcornu_methode_context782.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs, double lineRel, double lineAbs, ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context783 = new ConstructorContext(PowellOptimizer.class, 107, 3815, 5190);
        try {
            if (rel < (PowellOptimizer.MIN_RELATIVE_TOLERANCE)) {
                throw new NumberIsTooSmallException(rel, PowellOptimizer.MIN_RELATIVE_TOLERANCE, true);
            }
            if (abs <= 0) {
                throw new NotStrictlyPositiveException(abs);
            }
            relativeThreshold = rel;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 120, 5003, 5026);
            absoluteThreshold = abs;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 121, 5036, 5059);
            line = new PowellOptimizer.LineSearch(lineRel, lineAbs);
            CallChecker.varAssign(this.line, "this.line", 124, 5115, 5184);
        } finally {
            _bcornu_methode_context783.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs) {
        this(rel, abs, null);
        ConstructorContext _bcornu_methode_context784 = new ConstructorContext(PowellOptimizer.class, 139, 5197, 5771);
        try {
        } finally {
            _bcornu_methode_context784.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs, double lineRel, double lineAbs) {
        this(rel, abs, lineRel, lineAbs, null);
        ConstructorContext _bcornu_methode_context785 = new ConstructorContext(PowellOptimizer.class, 155, 5778, 6487);
        try {
        } finally {
            _bcornu_methode_context785.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context3484 = new MethodContext(PointValuePair.class, 164, 6494, 9610);
        try {
            CallChecker.varInit(this, "this", 164, 6494, 9610);
            CallChecker.varInit(this.evaluations, "evaluations", 164, 6494, 9610);
            CallChecker.varInit(this.line, "line", 164, 6494, 9610);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 164, 6494, 9610);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 164, 6494, 9610);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optimization.direct.PowellOptimizer.MIN_RELATIVE_TOLERANCE", 164, 6494, 9610);
            final GoalType goal = CallChecker.varInit(getGoalType(), "goal", 165, 6581, 6616);
            final double[] guess = CallChecker.varInit(getStartPoint(), "guess", 166, 6626, 6664);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(guess, double[].class, 167, 6688, 6692).length)), "n", 167, 6674, 6700);
            final double[][] direc = CallChecker.varInit(new double[n][n], "direc", 169, 6711, 6752);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(direc, double[][].class, 171, 6804, 6808)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i], double[].class, 171, 6804, 6811)) {
                        CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i] = CallChecker.beforeCalled(CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i], double[].class, 171, 6804, 6811);
                        CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i], double[].class, 171, 6804, 6811)[i] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i], double[].class, 171, 6804, 6811)[i], "CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 171, 6804, 6808)[i], double[].class, 171, 6804, 6811)[i]", 171, 6804, 6819);
                    }
                }
            }
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 174, 6840, 6926);
            double[] x = CallChecker.varInit(guess, "x", 177, 6937, 6955);
            double fVal = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fVal", 178, 6965, 7003);
            double[] x1 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(x, double[].class, 179, 7027, 7027)) {
                x = CallChecker.beforeCalled(x, double[].class, 179, 7027, 7027);
                x1 = CallChecker.isCalled(x, double[].class, 179, 7027, 7027).clone();
                CallChecker.varAssign(x1, "x1", 179, 7027, 7027);
            }
            int iter = CallChecker.varInit(((int) (0)), "iter", 180, 7046, 7058);
            while (true) {
                ++iter;
                double fX = CallChecker.varInit(((double) (fVal)), "fX", 184, 7116, 7132);
                double fX2 = CallChecker.varInit(((double) (0)), "fX2", 185, 7146, 7160);
                double delta = CallChecker.varInit(((double) (0)), "delta", 186, 7174, 7190);
                int bigInd = CallChecker.varInit(((int) (0)), "bigInd", 187, 7204, 7218);
                double alphaMin = CallChecker.varInit(((double) (0)), "alphaMin", 188, 7232, 7251);
                for (int i = 0; i < n; i++) {
                    final double[] d = CallChecker.varInit(MathArrays.copyOf(CallChecker.isCalled(direc, double[][].class, 191, 7349, 7353)[i]), "d", 191, 7312, 7358);
                    fX2 = fVal;
                    CallChecker.varAssign(fX2, "fX2", 193, 7377, 7387);
                    final UnivariatePointValuePair optimum = CallChecker.varInit(CallChecker.isCalled(line, PowellOptimizer.LineSearch.class, 195, 7447, 7450).search(x, d), "optimum", 195, 7406, 7464);
                    if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 196, 7489, 7495)) {
                        fVal = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 196, 7489, 7495).getValue();
                        CallChecker.varAssign(fVal, "fVal", 196, 7482, 7507);
                    }
                    if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 197, 7536, 7542)) {
                        alphaMin = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 197, 7536, 7542).getPoint();
                        CallChecker.varAssign(alphaMin, "alphaMin", 197, 7525, 7554);
                    }
                    final double[][] result = CallChecker.varInit(newPointAndDirection(x, d, alphaMin), "result", 198, 7572, 7634);
                    if (CallChecker.beforeDeref(result, double[][].class, 199, 7656, 7661)) {
                        x = CallChecker.isCalled(result, double[][].class, 199, 7656, 7661)[0];
                        CallChecker.varAssign(x, "x", 199, 7652, 7665);
                    }
                    if ((fX2 - fVal) > delta) {
                        delta = fX2 - fVal;
                        CallChecker.varAssign(delta, "delta", 202, 7732, 7750);
                        bigInd = i;
                        CallChecker.varAssign(bigInd, "bigInd", 203, 7772, 7782);
                    }
                }
                boolean stop = CallChecker.varInit(((boolean) ((2 * (fX - fVal)) <= (((this.relativeThreshold) * ((FastMath.abs(fX)) + (FastMath.abs(fVal)))) + (this.absoluteThreshold)))), "stop", 208, 7871, 8019);
                final PointValuePair previous = CallChecker.varInit(new PointValuePair(x1, fX), "previous", 212, 8034, 8092);
                final PointValuePair current = CallChecker.varInit(new PointValuePair(x, fVal), "current", 213, 8106, 8164);
                if ((!stop) && (checker != null)) {
                    stop = checker.converged(iter, previous, current);
                    CallChecker.varAssign(stop, "stop", 215, 8226, 8275);
                }
                if (stop) {
                    if (goal == (GoalType.MINIMIZE)) {
                        if (fVal < fX) {
                            return current;
                        }else {
                            return previous;
                        }
                    }else {
                        if (fVal > fX) {
                            return current;
                        }else {
                            return previous;
                        }
                    }
                }
                final double[] d = CallChecker.varInit(new double[n], "d", 225, 8556, 8588);
                final double[] x2 = CallChecker.varInit(new double[n], "x2", 226, 8602, 8635);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(d, double[].class, 228, 8695, 8695)) {
                        if (CallChecker.beforeDeref(x, double[].class, 228, 8702, 8702)) {
                            if (CallChecker.beforeDeref(x1, double[].class, 228, 8709, 8710)) {
                                x = CallChecker.beforeCalled(x, double[].class, 228, 8702, 8702);
                                x1 = CallChecker.beforeCalled(x1, double[].class, 228, 8709, 8710);
                                CallChecker.isCalled(d, double[].class, 228, 8695, 8695)[i] = (CallChecker.isCalled(x, double[].class, 228, 8702, 8702)[i]) - (CallChecker.isCalled(x1, double[].class, 228, 8709, 8710)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(d, double[].class, 228, 8695, 8695)[i], "CallChecker.isCalled(d, double[].class, 228, 8695, 8695)[i]", 228, 8695, 8714);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(x2, double[].class, 229, 8732, 8733)) {
                        if (CallChecker.beforeDeref(x, double[].class, 229, 8744, 8744)) {
                            if (CallChecker.beforeDeref(x1, double[].class, 229, 8751, 8752)) {
                                x = CallChecker.beforeCalled(x, double[].class, 229, 8744, 8744);
                                x1 = CallChecker.beforeCalled(x1, double[].class, 229, 8751, 8752);
                                CallChecker.isCalled(x2, double[].class, 229, 8732, 8733)[i] = (2 * (CallChecker.isCalled(x, double[].class, 229, 8744, 8744)[i])) - (CallChecker.isCalled(x1, double[].class, 229, 8751, 8752)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(x2, double[].class, 229, 8732, 8733)[i], "CallChecker.isCalled(x2, double[].class, 229, 8732, 8733)[i]", 229, 8732, 8756);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(x, double[].class, 232, 8790, 8790)) {
                    x = CallChecker.beforeCalled(x, double[].class, 232, 8790, 8790);
                    x1 = CallChecker.isCalled(x, double[].class, 232, 8790, 8790).clone();
                    CallChecker.varAssign(x1, "x1", 232, 8785, 8799);
                }
                fX2 = computeObjectiveValue(x2);
                CallChecker.varAssign(fX2, "fX2", 233, 8813, 8844);
                if (fX > fX2) {
                    double t = CallChecker.varInit(((double) (2 * ((fX + fX2) - (2 * fVal)))), "t", 236, 8891, 8927);
                    double temp = CallChecker.varInit(((double) ((fX - fVal) - delta)), "temp", 237, 8945, 8976);
                    t *= temp * temp;
                    CallChecker.varAssign(t, "t", 238, 8994, 9010);
                    temp = fX - fX2;
                    CallChecker.varAssign(temp, "temp", 239, 9028, 9043);
                    t -= (delta * temp) * temp;
                    CallChecker.varAssign(t, "t", 240, 9061, 9085);
                    if (t < 0.0) {
                        final UnivariatePointValuePair optimum = CallChecker.varInit(CallChecker.isCalled(line, PowellOptimizer.LineSearch.class, 243, 9180, 9183).search(x, d), "optimum", 243, 9139, 9197);
                        if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 244, 9226, 9232)) {
                            fVal = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 244, 9226, 9232).getValue();
                            CallChecker.varAssign(fVal, "fVal", 244, 9219, 9244);
                        }
                        if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 245, 9277, 9283)) {
                            alphaMin = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 245, 9277, 9283).getPoint();
                            CallChecker.varAssign(alphaMin, "alphaMin", 245, 9266, 9295);
                        }
                        final double[][] result = CallChecker.varInit(newPointAndDirection(x, d, alphaMin), "result", 246, 9317, 9379);
                        if (CallChecker.beforeDeref(result, double[][].class, 247, 9405, 9410)) {
                            x = CallChecker.isCalled(result, double[][].class, 247, 9405, 9410)[0];
                            CallChecker.varAssign(x, "x", 247, 9401, 9414);
                        }
                        final int lastInd = CallChecker.varInit(((int) (n - 1)), "lastInd", 249, 9437, 9462);
                        if (CallChecker.beforeDeref(direc, double[][].class, 250, 9484, 9488)) {
                            if (CallChecker.beforeDeref(direc, double[][].class, 250, 9500, 9504)) {
                                CallChecker.isCalled(direc, double[][].class, 250, 9484, 9488)[bigInd] = CallChecker.isCalled(direc, double[][].class, 250, 9500, 9504)[lastInd];
                                CallChecker.varAssign(CallChecker.isCalled(direc, double[][].class, 250, 9484, 9488)[bigInd], "CallChecker.isCalled(direc, double[][].class, 250, 9484, 9488)[bigInd]", 250, 9484, 9514);
                            }
                        }
                        if (CallChecker.beforeDeref(direc, double[][].class, 251, 9536, 9540)) {
                            if (CallChecker.beforeDeref(result, double[][].class, 251, 9553, 9558)) {
                                CallChecker.isCalled(direc, double[][].class, 251, 9536, 9540)[lastInd] = CallChecker.isCalled(result, double[][].class, 251, 9553, 9558)[1];
                                CallChecker.varAssign(CallChecker.isCalled(direc, double[][].class, 251, 9536, 9540)[lastInd], "CallChecker.isCalled(direc, double[][].class, 251, 9536, 9540)[lastInd]", 251, 9536, 9562);
                            }
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3484.methodEnd();
        }
    }

    private double[][] newPointAndDirection(double[] p, double[] d, double optimum) {
        MethodContext _bcornu_methode_context3485 = new MethodContext(double[][].class, 267, 9617, 10560);
        try {
            CallChecker.varInit(this, "this", 267, 9617, 10560);
            CallChecker.varInit(optimum, "optimum", 267, 9617, 10560);
            CallChecker.varInit(d, "d", 267, 9617, 10560);
            CallChecker.varInit(p, "p", 267, 9617, 10560);
            CallChecker.varInit(this.evaluations, "evaluations", 267, 9617, 10560);
            CallChecker.varInit(this.line, "line", 267, 9617, 10560);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 267, 9617, 10560);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 267, 9617, 10560);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optimization.direct.PowellOptimizer.MIN_RELATIVE_TOLERANCE", 267, 9617, 10560);
            p = CallChecker.beforeCalled(p, double[].class, 270, 10218, 10218);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(p, double[].class, 270, 10218, 10218).length)), "n", 270, 10204, 10226);
            final double[] nP = CallChecker.varInit(new double[n], "nP", 271, 10236, 10269);
            final double[] nD = CallChecker.varInit(new double[n], "nD", 272, 10279, 10312);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(nD, double[].class, 274, 10364, 10365)) {
                    if (CallChecker.beforeDeref(d, double[].class, 274, 10372, 10372)) {
                        d = CallChecker.beforeCalled(d, double[].class, 274, 10372, 10372);
                        CallChecker.isCalled(nD, double[].class, 274, 10364, 10365)[i] = (CallChecker.isCalled(d, double[].class, 274, 10372, 10372)[i]) * optimum;
                        CallChecker.varAssign(CallChecker.isCalled(nD, double[].class, 274, 10364, 10365)[i], "CallChecker.isCalled(nD, double[].class, 274, 10364, 10365)[i]", 274, 10364, 10386);
                    }
                }
                if (CallChecker.beforeDeref(nP, double[].class, 275, 10400, 10401)) {
                    if (CallChecker.beforeDeref(p, double[].class, 275, 10408, 10408)) {
                        if (CallChecker.beforeDeref(nD, double[].class, 275, 10415, 10416)) {
                            p = CallChecker.beforeCalled(p, double[].class, 275, 10408, 10408);
                            CallChecker.isCalled(nP, double[].class, 275, 10400, 10401)[i] = (CallChecker.isCalled(p, double[].class, 275, 10408, 10408)[i]) + (CallChecker.isCalled(nD, double[].class, 275, 10415, 10416)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(nP, double[].class, 275, 10400, 10401)[i], "CallChecker.isCalled(nP, double[].class, 275, 10400, 10401)[i]", 275, 10400, 10420);
                        }
                    }
                }
            }
            final double[][] result = CallChecker.varInit(new double[2][], "result", 278, 10441, 10482);
            if (CallChecker.beforeDeref(result, double[][].class, 279, 10492, 10497)) {
                CallChecker.isCalled(result, double[][].class, 279, 10492, 10497)[0] = nP;
                CallChecker.varAssign(CallChecker.isCalled(result, double[][].class, 279, 10492, 10497)[0], "CallChecker.isCalled(result, double[][].class, 279, 10492, 10497)[0]", 279, 10492, 10506);
            }
            if (CallChecker.beforeDeref(result, double[][].class, 280, 10516, 10521)) {
                CallChecker.isCalled(result, double[][].class, 280, 10516, 10521)[1] = nD;
                CallChecker.varAssign(CallChecker.isCalled(result, double[][].class, 280, 10516, 10521)[1], "CallChecker.isCalled(result, double[][].class, 280, 10516, 10521)[1]", 280, 10516, 10530);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3485.methodEnd();
        }
    }
}

