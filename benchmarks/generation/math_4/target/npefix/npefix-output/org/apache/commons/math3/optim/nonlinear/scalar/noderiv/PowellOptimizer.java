package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.optim.univariate.BracketFinder;
import org.apache.commons.math3.optim.univariate.BrentOptimizer;
import org.apache.commons.math3.optim.univariate.SearchInterval;
import org.apache.commons.math3.optim.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optim.univariate.UnivariateObjectiveFunction;
import org.apache.commons.math3.optim.univariate.UnivariatePointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class PowellOptimizer extends MultivariateOptimizer {
    private class LineSearch extends BrentOptimizer {
        private static final double REL_TOL_UNUSED = 1.0E-15;

        private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;

        private final BracketFinder bracket = new BracketFinder();

        LineSearch(double rel, double abs) {
            super(PowellOptimizer.LineSearch.REL_TOL_UNUSED, PowellOptimizer.LineSearch.ABS_TOL_UNUSED, new SimpleUnivariateValueChecker(rel, abs));
            ConstructorContext _bcornu_methode_context786 = new ConstructorContext(PowellOptimizer.LineSearch.class, 325, 12222, 12754);
            try {
            } finally {
                _bcornu_methode_context786.methodEnd();
            }
        }

        public UnivariatePointValuePair search(final double[] p, final double[] d) {
            MethodContext _bcornu_methode_context3487 = new MethodContext(UnivariatePointValuePair.class, 341, 12765, 14384);
            try {
                CallChecker.varInit(this, "this", 341, 12765, 14384);
                CallChecker.varInit(d, "d", 341, 12765, 14384);
                CallChecker.varInit(p, "p", 341, 12765, 14384);
                CallChecker.varInit(this.iterations, "iterations", 341, 12765, 14384);
                CallChecker.varInit(this.evaluations, "evaluations", 341, 12765, 14384);
                CallChecker.varInit(this.bracket, "bracket", 341, 12765, 14384);
                CallChecker.varInit(ABS_TOL_UNUSED, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.LineSearch.ABS_TOL_UNUSED", 341, 12765, 14384);
                CallChecker.varInit(REL_TOL_UNUSED, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.LineSearch.REL_TOL_UNUSED", 341, 12765, 14384);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(p, double[].class, 342, 13214, 13214).length)), "n", 342, 13200, 13222);
                final UnivariateFunction f = new UnivariateFunction() {
                    public double value(double alpha) {
                        MethodContext _bcornu_methode_context3486 = new MethodContext(double.class, 344, 13312, 13688);
                        try {
                            CallChecker.varInit(this, "this", 344, 13312, 13688);
                            CallChecker.varInit(alpha, "alpha", 344, 13312, 13688);
                            final double[] x = CallChecker.varInit(new double[n], "x", 345, 13372, 13404);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(x, double[].class, 347, 13488, 13488)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 347, 13495, 13495)) {
                                        if (CallChecker.beforeDeref(d, double[].class, 347, 13510, 13510)) {
                                            CallChecker.isCalled(x, double[].class, 347, 13488, 13488)[i] = (CallChecker.isCalled(p, double[].class, 347, 13495, 13495)[i]) + (alpha * (CallChecker.isCalled(d, double[].class, 347, 13510, 13510)[i]));
                                            CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 347, 13488, 13488)[i], "CallChecker.isCalled(x, double[].class, 347, 13488, 13488)[i]", 347, 13488, 13514);
                                        }
                                    }
                                }
                            }
                            final double obj = CallChecker.varInit(((double) (PowellOptimizer.this.computeObjectiveValue(x))), "obj", 349, 13566, 13630);
                            return obj;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Double) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context3486.methodEnd();
                        }
                    }
                };
                final GoalType goal = CallChecker.varInit(PowellOptimizer.this.getGoalType(), "goal", 354, 13722, 13778);
                if (CallChecker.beforeDeref(bracket, BracketFinder.class, 355, 13792, 13798)) {
                    CallChecker.isCalled(bracket, BracketFinder.class, 355, 13792, 13798).search(f, goal, 0, 1);
                }
                if (CallChecker.beforeDeref(bracket, BracketFinder.class, 362, 14228, 14234)) {
                    if (CallChecker.beforeDeref(bracket, BracketFinder.class, 363, 14292, 14298)) {
                        if (CallChecker.beforeDeref(bracket, BracketFinder.class, 364, 14356, 14362)) {
                            return optimize(new MaxEval(Integer.MAX_VALUE), new UnivariateObjectiveFunction(f), goal, new SearchInterval(CallChecker.isCalled(bracket, BracketFinder.class, 362, 14228, 14234).getLo(), CallChecker.isCalled(bracket, BracketFinder.class, 363, 14292, 14298).getHi(), CallChecker.isCalled(bracket, BracketFinder.class, 364, 14356, 14362).getMid()));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((UnivariatePointValuePair) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3487.methodEnd();
            }
        }
    }

    private static final double MIN_RELATIVE_TOLERANCE = 2 * (FastMath.ulp(1.0));

    private final double relativeThreshold;

    private final double absoluteThreshold;

    private final PowellOptimizer.LineSearch line;

    public PowellOptimizer(double rel, double abs, ConvergenceChecker<PointValuePair> checker) {
        this(rel, abs, FastMath.sqrt(rel), FastMath.sqrt(abs), checker);
        ConstructorContext _bcornu_methode_context787 = new ConstructorContext(PowellOptimizer.class, 98, 3659, 4495);
        try {
        } finally {
            _bcornu_methode_context787.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs, double lineRel, double lineAbs, ConvergenceChecker<PointValuePair> checker) {
        super(checker);
        ConstructorContext _bcornu_methode_context788 = new ConstructorContext(PowellOptimizer.class, 117, 4502, 5877);
        try {
            if (rel < (PowellOptimizer.MIN_RELATIVE_TOLERANCE)) {
                throw new NumberIsTooSmallException(rel, PowellOptimizer.MIN_RELATIVE_TOLERANCE, true);
            }
            if (abs <= 0) {
                throw new NotStrictlyPositiveException(abs);
            }
            relativeThreshold = rel;
            CallChecker.varAssign(this.relativeThreshold, "this.relativeThreshold", 130, 5690, 5713);
            absoluteThreshold = abs;
            CallChecker.varAssign(this.absoluteThreshold, "this.absoluteThreshold", 131, 5723, 5746);
            line = new PowellOptimizer.LineSearch(lineRel, lineAbs);
            CallChecker.varAssign(this.line, "this.line", 134, 5802, 5871);
        } finally {
            _bcornu_methode_context788.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs) {
        this(rel, abs, null);
        ConstructorContext _bcornu_methode_context789 = new ConstructorContext(PowellOptimizer.class, 149, 5884, 6458);
        try {
        } finally {
            _bcornu_methode_context789.methodEnd();
        }
    }

    public PowellOptimizer(double rel, double abs, double lineRel, double lineAbs) {
        this(rel, abs, lineRel, lineAbs, null);
        ConstructorContext _bcornu_methode_context790 = new ConstructorContext(PowellOptimizer.class, 164, 6465, 7156);
        try {
        } finally {
            _bcornu_methode_context790.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context3488 = new MethodContext(PointValuePair.class, 173, 7163, 10350);
        try {
            CallChecker.varInit(this, "this", 173, 7163, 10350);
            CallChecker.varInit(this.iterations, "iterations", 173, 7163, 10350);
            CallChecker.varInit(this.evaluations, "evaluations", 173, 7163, 10350);
            CallChecker.varInit(this.line, "line", 173, 7163, 10350);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 173, 7163, 10350);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 173, 7163, 10350);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.MIN_RELATIVE_TOLERANCE", 173, 7163, 10350);
            checkParameters();
            final GoalType goal = CallChecker.varInit(getGoalType(), "goal", 176, 7278, 7313);
            final double[] guess = CallChecker.varInit(getStartPoint(), "guess", 177, 7323, 7361);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(guess, double[].class, 178, 7385, 7389).length)), "n", 178, 7371, 7397);
            final double[][] direc = CallChecker.varInit(new double[n][n], "direc", 180, 7408, 7449);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(direc, double[][].class, 182, 7501, 7505)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i], double[].class, 182, 7501, 7508)) {
                        CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i] = CallChecker.beforeCalled(CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i], double[].class, 182, 7501, 7508);
                        CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i], double[].class, 182, 7501, 7508)[i] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i], double[].class, 182, 7501, 7508)[i], "CallChecker.isCalled(CallChecker.isCalled(direc, double[][].class, 182, 7501, 7505)[i], double[].class, 182, 7501, 7508)[i]", 182, 7501, 7516);
                    }
                }
            }
            final ConvergenceChecker<PointValuePair> checker = CallChecker.varInit(getConvergenceChecker(), "checker", 185, 7537, 7623);
            double[] x = CallChecker.varInit(guess, "x", 188, 7634, 7652);
            double fVal = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fVal", 189, 7662, 7700);
            double[] x1 = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(x, double[].class, 190, 7724, 7724)) {
                x = CallChecker.beforeCalled(x, double[].class, 190, 7724, 7724);
                x1 = CallChecker.isCalled(x, double[].class, 190, 7724, 7724).clone();
                CallChecker.varAssign(x1, "x1", 190, 7724, 7724);
            }
            while (true) {
                incrementIterationCount();
                double fX = CallChecker.varInit(((double) (fVal)), "fX", 194, 7810, 7826);
                double fX2 = CallChecker.varInit(((double) (0)), "fX2", 195, 7840, 7854);
                double delta = CallChecker.varInit(((double) (0)), "delta", 196, 7868, 7884);
                int bigInd = CallChecker.varInit(((int) (0)), "bigInd", 197, 7898, 7912);
                double alphaMin = CallChecker.varInit(((double) (0)), "alphaMin", 198, 7926, 7945);
                for (int i = 0; i < n; i++) {
                    final double[] d = CallChecker.varInit(MathArrays.copyOf(CallChecker.isCalled(direc, double[][].class, 201, 8043, 8047)[i]), "d", 201, 8006, 8052);
                    fX2 = fVal;
                    CallChecker.varAssign(fX2, "fX2", 203, 8071, 8081);
                    final UnivariatePointValuePair optimum = CallChecker.varInit(CallChecker.isCalled(line, PowellOptimizer.LineSearch.class, 205, 8141, 8144).search(x, d), "optimum", 205, 8100, 8158);
                    if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 206, 8183, 8189)) {
                        fVal = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 206, 8183, 8189).getValue();
                        CallChecker.varAssign(fVal, "fVal", 206, 8176, 8201);
                    }
                    if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 207, 8230, 8236)) {
                        alphaMin = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 207, 8230, 8236).getPoint();
                        CallChecker.varAssign(alphaMin, "alphaMin", 207, 8219, 8248);
                    }
                    final double[][] result = CallChecker.varInit(newPointAndDirection(x, d, alphaMin), "result", 208, 8266, 8328);
                    if (CallChecker.beforeDeref(result, double[][].class, 209, 8350, 8355)) {
                        x = CallChecker.isCalled(result, double[][].class, 209, 8350, 8355)[0];
                        CallChecker.varAssign(x, "x", 209, 8346, 8359);
                    }
                    if ((fX2 - fVal) > delta) {
                        delta = fX2 - fVal;
                        CallChecker.varAssign(delta, "delta", 212, 8426, 8444);
                        bigInd = i;
                        CallChecker.varAssign(bigInd, "bigInd", 213, 8466, 8476);
                    }
                }
                boolean stop = CallChecker.varInit(((boolean) ((2 * (fX - fVal)) <= (((this.relativeThreshold) * ((FastMath.abs(fX)) + (FastMath.abs(fVal)))) + (this.absoluteThreshold)))), "stop", 218, 8565, 8713);
                final PointValuePair previous = CallChecker.varInit(new PointValuePair(x1, fX), "previous", 222, 8728, 8786);
                final PointValuePair current = CallChecker.varInit(new PointValuePair(x, fVal), "current", 223, 8800, 8858);
                if ((!stop) && (checker != null)) {
                    stop = checker.converged(getIterations(), previous, current);
                    CallChecker.varAssign(stop, "stop", 225, 8955, 9015);
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
                final double[] d = CallChecker.varInit(new double[n], "d", 235, 9296, 9328);
                final double[] x2 = CallChecker.varInit(new double[n], "x2", 236, 9342, 9375);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(d, double[].class, 238, 9435, 9435)) {
                        if (CallChecker.beforeDeref(x, double[].class, 238, 9442, 9442)) {
                            if (CallChecker.beforeDeref(x1, double[].class, 238, 9449, 9450)) {
                                x = CallChecker.beforeCalled(x, double[].class, 238, 9442, 9442);
                                x1 = CallChecker.beforeCalled(x1, double[].class, 238, 9449, 9450);
                                CallChecker.isCalled(d, double[].class, 238, 9435, 9435)[i] = (CallChecker.isCalled(x, double[].class, 238, 9442, 9442)[i]) - (CallChecker.isCalled(x1, double[].class, 238, 9449, 9450)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(d, double[].class, 238, 9435, 9435)[i], "CallChecker.isCalled(d, double[].class, 238, 9435, 9435)[i]", 238, 9435, 9454);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(x2, double[].class, 239, 9472, 9473)) {
                        if (CallChecker.beforeDeref(x, double[].class, 239, 9484, 9484)) {
                            if (CallChecker.beforeDeref(x1, double[].class, 239, 9491, 9492)) {
                                x = CallChecker.beforeCalled(x, double[].class, 239, 9484, 9484);
                                x1 = CallChecker.beforeCalled(x1, double[].class, 239, 9491, 9492);
                                CallChecker.isCalled(x2, double[].class, 239, 9472, 9473)[i] = (2 * (CallChecker.isCalled(x, double[].class, 239, 9484, 9484)[i])) - (CallChecker.isCalled(x1, double[].class, 239, 9491, 9492)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(x2, double[].class, 239, 9472, 9473)[i], "CallChecker.isCalled(x2, double[].class, 239, 9472, 9473)[i]", 239, 9472, 9496);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(x, double[].class, 242, 9530, 9530)) {
                    x = CallChecker.beforeCalled(x, double[].class, 242, 9530, 9530);
                    x1 = CallChecker.isCalled(x, double[].class, 242, 9530, 9530).clone();
                    CallChecker.varAssign(x1, "x1", 242, 9525, 9539);
                }
                fX2 = computeObjectiveValue(x2);
                CallChecker.varAssign(fX2, "fX2", 243, 9553, 9584);
                if (fX > fX2) {
                    double t = CallChecker.varInit(((double) (2 * ((fX + fX2) - (2 * fVal)))), "t", 246, 9631, 9667);
                    double temp = CallChecker.varInit(((double) ((fX - fVal) - delta)), "temp", 247, 9685, 9716);
                    t *= temp * temp;
                    CallChecker.varAssign(t, "t", 248, 9734, 9750);
                    temp = fX - fX2;
                    CallChecker.varAssign(temp, "temp", 249, 9768, 9783);
                    t -= (delta * temp) * temp;
                    CallChecker.varAssign(t, "t", 250, 9801, 9825);
                    if (t < 0.0) {
                        final UnivariatePointValuePair optimum = CallChecker.varInit(CallChecker.isCalled(line, PowellOptimizer.LineSearch.class, 253, 9920, 9923).search(x, d), "optimum", 253, 9879, 9937);
                        if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 254, 9966, 9972)) {
                            fVal = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 254, 9966, 9972).getValue();
                            CallChecker.varAssign(fVal, "fVal", 254, 9959, 9984);
                        }
                        if (CallChecker.beforeDeref(optimum, UnivariatePointValuePair.class, 255, 10017, 10023)) {
                            alphaMin = CallChecker.isCalled(optimum, UnivariatePointValuePair.class, 255, 10017, 10023).getPoint();
                            CallChecker.varAssign(alphaMin, "alphaMin", 255, 10006, 10035);
                        }
                        final double[][] result = CallChecker.varInit(newPointAndDirection(x, d, alphaMin), "result", 256, 10057, 10119);
                        if (CallChecker.beforeDeref(result, double[][].class, 257, 10145, 10150)) {
                            x = CallChecker.isCalled(result, double[][].class, 257, 10145, 10150)[0];
                            CallChecker.varAssign(x, "x", 257, 10141, 10154);
                        }
                        final int lastInd = CallChecker.varInit(((int) (n - 1)), "lastInd", 259, 10177, 10202);
                        if (CallChecker.beforeDeref(direc, double[][].class, 260, 10224, 10228)) {
                            if (CallChecker.beforeDeref(direc, double[][].class, 260, 10240, 10244)) {
                                CallChecker.isCalled(direc, double[][].class, 260, 10224, 10228)[bigInd] = CallChecker.isCalled(direc, double[][].class, 260, 10240, 10244)[lastInd];
                                CallChecker.varAssign(CallChecker.isCalled(direc, double[][].class, 260, 10224, 10228)[bigInd], "CallChecker.isCalled(direc, double[][].class, 260, 10224, 10228)[bigInd]", 260, 10224, 10254);
                            }
                        }
                        if (CallChecker.beforeDeref(direc, double[][].class, 261, 10276, 10280)) {
                            if (CallChecker.beforeDeref(result, double[][].class, 261, 10293, 10298)) {
                                CallChecker.isCalled(direc, double[][].class, 261, 10276, 10280)[lastInd] = CallChecker.isCalled(result, double[][].class, 261, 10293, 10298)[1];
                                CallChecker.varAssign(CallChecker.isCalled(direc, double[][].class, 261, 10276, 10280)[lastInd], "CallChecker.isCalled(direc, double[][].class, 261, 10276, 10280)[lastInd]", 261, 10276, 10302);
                            }
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3488.methodEnd();
        }
    }

    private double[][] newPointAndDirection(double[] p, double[] d, double optimum) {
        MethodContext _bcornu_methode_context3489 = new MethodContext(double[][].class, 277, 10357, 11300);
        try {
            CallChecker.varInit(this, "this", 277, 10357, 11300);
            CallChecker.varInit(optimum, "optimum", 277, 10357, 11300);
            CallChecker.varInit(d, "d", 277, 10357, 11300);
            CallChecker.varInit(p, "p", 277, 10357, 11300);
            CallChecker.varInit(this.iterations, "iterations", 277, 10357, 11300);
            CallChecker.varInit(this.evaluations, "evaluations", 277, 10357, 11300);
            CallChecker.varInit(this.line, "line", 277, 10357, 11300);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 277, 10357, 11300);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 277, 10357, 11300);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.MIN_RELATIVE_TOLERANCE", 277, 10357, 11300);
            p = CallChecker.beforeCalled(p, double[].class, 280, 10958, 10958);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(p, double[].class, 280, 10958, 10958).length)), "n", 280, 10944, 10966);
            final double[] nP = CallChecker.varInit(new double[n], "nP", 281, 10976, 11009);
            final double[] nD = CallChecker.varInit(new double[n], "nD", 282, 11019, 11052);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(nD, double[].class, 284, 11104, 11105)) {
                    if (CallChecker.beforeDeref(d, double[].class, 284, 11112, 11112)) {
                        d = CallChecker.beforeCalled(d, double[].class, 284, 11112, 11112);
                        CallChecker.isCalled(nD, double[].class, 284, 11104, 11105)[i] = (CallChecker.isCalled(d, double[].class, 284, 11112, 11112)[i]) * optimum;
                        CallChecker.varAssign(CallChecker.isCalled(nD, double[].class, 284, 11104, 11105)[i], "CallChecker.isCalled(nD, double[].class, 284, 11104, 11105)[i]", 284, 11104, 11126);
                    }
                }
                if (CallChecker.beforeDeref(nP, double[].class, 285, 11140, 11141)) {
                    if (CallChecker.beforeDeref(p, double[].class, 285, 11148, 11148)) {
                        if (CallChecker.beforeDeref(nD, double[].class, 285, 11155, 11156)) {
                            p = CallChecker.beforeCalled(p, double[].class, 285, 11148, 11148);
                            CallChecker.isCalled(nP, double[].class, 285, 11140, 11141)[i] = (CallChecker.isCalled(p, double[].class, 285, 11148, 11148)[i]) + (CallChecker.isCalled(nD, double[].class, 285, 11155, 11156)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(nP, double[].class, 285, 11140, 11141)[i], "CallChecker.isCalled(nP, double[].class, 285, 11140, 11141)[i]", 285, 11140, 11160);
                        }
                    }
                }
            }
            final double[][] result = CallChecker.varInit(new double[2][], "result", 288, 11181, 11222);
            if (CallChecker.beforeDeref(result, double[][].class, 289, 11232, 11237)) {
                CallChecker.isCalled(result, double[][].class, 289, 11232, 11237)[0] = nP;
                CallChecker.varAssign(CallChecker.isCalled(result, double[][].class, 289, 11232, 11237)[0], "CallChecker.isCalled(result, double[][].class, 289, 11232, 11237)[0]", 289, 11232, 11246);
            }
            if (CallChecker.beforeDeref(result, double[][].class, 290, 11256, 11261)) {
                CallChecker.isCalled(result, double[][].class, 290, 11256, 11261)[1] = nD;
                CallChecker.varAssign(CallChecker.isCalled(result, double[][].class, 290, 11256, 11261)[1], "CallChecker.isCalled(result, double[][].class, 290, 11256, 11261)[1]", 290, 11256, 11270);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3489.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context3490 = new MethodContext(void.class, 372, 14397, 14764);
        try {
            CallChecker.varInit(this, "this", 372, 14397, 14764);
            CallChecker.varInit(this.iterations, "iterations", 372, 14397, 14764);
            CallChecker.varInit(this.evaluations, "evaluations", 372, 14397, 14764);
            CallChecker.varInit(this.line, "line", 372, 14397, 14764);
            CallChecker.varInit(this.absoluteThreshold, "absoluteThreshold", 372, 14397, 14764);
            CallChecker.varInit(this.relativeThreshold, "relativeThreshold", 372, 14397, 14764);
            CallChecker.varInit(MIN_RELATIVE_TOLERANCE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.PowellOptimizer.MIN_RELATIVE_TOLERANCE", 372, 14397, 14764);
            if (((getLowerBound()) != null) || ((getUpperBound()) != null)) {
                throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3490.methodEnd();
        }
    }
}

