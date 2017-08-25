package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.SimpleVectorValueChecker;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.util.Incrementor;

@Deprecated
public abstract class BaseAbstractMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    protected final Incrementor evaluations = new Incrementor();

    private ConvergenceChecker<PointVectorValuePair> checker;

    private double[] target;

    private RealMatrix weightMatrix;

    private double[] weight;

    private double[] start;

    private FUNC function;

    @Deprecated
    protected BaseAbstractMultivariateVectorOptimizer() {
        this(new SimpleVectorValueChecker());
        ConstructorContext _bcornu_methode_context529 = new ConstructorContext(BaseAbstractMultivariateVectorOptimizer.class, 73, 2925, 3268);
        try {
        } finally {
            _bcornu_methode_context529.methodEnd();
        }
    }

    protected BaseAbstractMultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> checker) {
        ConstructorContext _bcornu_methode_context530 = new ConstructorContext(BaseAbstractMultivariateVectorOptimizer.class, 79, 3274, 3471);
        try {
            this.checker = checker;
            CallChecker.varAssign(this.checker, "this.checker", 80, 3443, 3465);
        } finally {
            _bcornu_methode_context530.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context2477 = new MethodContext(int.class, 84, 3478, 3586);
        try {
            CallChecker.varInit(this, "this", 84, 3478, 3586);
            CallChecker.varInit(this.function, "function", 84, 3478, 3586);
            CallChecker.varInit(this.start, "start", 84, 3478, 3586);
            CallChecker.varInit(this.weight, "weight", 84, 3478, 3586);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 84, 3478, 3586);
            CallChecker.varInit(this.target, "target", 84, 3478, 3586);
            CallChecker.varInit(this.checker, "checker", 84, 3478, 3586);
            CallChecker.varInit(this.evaluations, "evaluations", 84, 3478, 3586);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 85, 3551, 3561)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 85, 3551, 3561).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2477.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context2478 = new MethodContext(int.class, 89, 3593, 3691);
        try {
            CallChecker.varInit(this, "this", 89, 3593, 3691);
            CallChecker.varInit(this.function, "function", 89, 3593, 3691);
            CallChecker.varInit(this.start, "start", 89, 3593, 3691);
            CallChecker.varInit(this.weight, "weight", 89, 3593, 3691);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 89, 3593, 3691);
            CallChecker.varInit(this.target, "target", 89, 3593, 3691);
            CallChecker.varInit(this.checker, "checker", 89, 3593, 3691);
            CallChecker.varInit(this.evaluations, "evaluations", 89, 3593, 3691);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 90, 3663, 3673)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 90, 3663, 3673).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2478.methodEnd();
        }
    }

    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        MethodContext _bcornu_methode_context2479 = new MethodContext(ConvergenceChecker.class, 94, 3698, 3825);
        try {
            CallChecker.varInit(this, "this", 94, 3698, 3825);
            CallChecker.varInit(this.function, "function", 94, 3698, 3825);
            CallChecker.varInit(this.start, "start", 94, 3698, 3825);
            CallChecker.varInit(this.weight, "weight", 94, 3698, 3825);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 94, 3698, 3825);
            CallChecker.varInit(this.target, "target", 94, 3698, 3825);
            CallChecker.varInit(this.checker, "checker", 94, 3698, 3825);
            CallChecker.varInit(this.evaluations, "evaluations", 94, 3698, 3825);
            return checker;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ConvergenceChecker<PointVectorValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2479.methodEnd();
        }
    }

    protected double[] computeObjectiveValue(double[] point) {
        MethodContext _bcornu_methode_context2480 = new MethodContext(double[].class, 106, 3832, 4423);
        try {
            CallChecker.varInit(this, "this", 106, 3832, 4423);
            CallChecker.varInit(point, "point", 106, 3832, 4423);
            CallChecker.varInit(this.function, "function", 106, 3832, 4423);
            CallChecker.varInit(this.start, "start", 106, 3832, 4423);
            CallChecker.varInit(this.weight, "weight", 106, 3832, 4423);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 106, 3832, 4423);
            CallChecker.varInit(this.target, "target", 106, 3832, 4423);
            CallChecker.varInit(this.checker, "checker", 106, 3832, 4423);
            CallChecker.varInit(this.evaluations, "evaluations", 106, 3832, 4423);
            TryContext _bcornu_try_context_43 = new TryContext(43, BaseAbstractMultivariateVectorOptimizer.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 108, 4230, 4240)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 108, 4230, 4240).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_43.catchStart(43);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_43.finallyStart(43);
            }
            if (CallChecker.beforeDeref(function, null, 112, 4396, 4403)) {
                return function.value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2480.methodEnd();
        }
    }

    @Deprecated
    public PointVectorValuePair optimize(int maxEval, FUNC f, double[] t, double[] w, double[] startPoint) {
        MethodContext _bcornu_methode_context2481 = new MethodContext(PointVectorValuePair.class, 122, 4430, 4829);
        try {
            CallChecker.varInit(this, "this", 122, 4430, 4829);
            CallChecker.varInit(startPoint, "startPoint", 122, 4430, 4829);
            CallChecker.varInit(w, "w", 122, 4430, 4829);
            CallChecker.varInit(t, "t", 122, 4430, 4829);
            CallChecker.varInit(f, "f", 122, 4430, 4829);
            CallChecker.varInit(maxEval, "maxEval", 122, 4430, 4829);
            CallChecker.varInit(this.function, "function", 122, 4430, 4829);
            CallChecker.varInit(this.start, "start", 122, 4430, 4829);
            CallChecker.varInit(this.weight, "weight", 122, 4430, 4829);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 122, 4430, 4829);
            CallChecker.varInit(this.target, "target", 122, 4430, 4829);
            CallChecker.varInit(this.checker, "checker", 122, 4430, 4829);
            CallChecker.varInit(this.evaluations, "evaluations", 122, 4430, 4829);
            return optimizeInternal(maxEval, f, t, w, startPoint);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2481.methodEnd();
        }
    }

    protected PointVectorValuePair optimize(int maxEval, FUNC f, OptimizationData... optData) throws DimensionMismatchException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2482 = new MethodContext(PointVectorValuePair.class, 147, 4836, 5894);
        try {
            CallChecker.varInit(this, "this", 147, 4836, 5894);
            CallChecker.varInit(optData, "optData", 147, 4836, 5894);
            CallChecker.varInit(f, "f", 147, 4836, 5894);
            CallChecker.varInit(maxEval, "maxEval", 147, 4836, 5894);
            CallChecker.varInit(this.function, "function", 147, 4836, 5894);
            CallChecker.varInit(this.start, "start", 147, 4836, 5894);
            CallChecker.varInit(this.weight, "weight", 147, 4836, 5894);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 147, 4836, 5894);
            CallChecker.varInit(this.target, "target", 147, 4836, 5894);
            CallChecker.varInit(this.checker, "checker", 147, 4836, 5894);
            CallChecker.varInit(this.evaluations, "evaluations", 147, 4836, 5894);
            return optimizeInternal(maxEval, f, optData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2482.methodEnd();
        }
    }

    @Deprecated
    protected PointVectorValuePair optimizeInternal(final int maxEval, final FUNC f, final double[] t, final double[] w, final double[] startPoint) {
        MethodContext _bcornu_methode_context2483 = new MethodContext(PointVectorValuePair.class, 179, 5901, 8019);
        try {
            CallChecker.varInit(this, "this", 179, 5901, 8019);
            CallChecker.varInit(startPoint, "startPoint", 179, 5901, 8019);
            CallChecker.varInit(w, "w", 179, 5901, 8019);
            CallChecker.varInit(t, "t", 179, 5901, 8019);
            CallChecker.varInit(f, "f", 179, 5901, 8019);
            CallChecker.varInit(maxEval, "maxEval", 179, 5901, 8019);
            CallChecker.varInit(this.function, "function", 179, 5901, 8019);
            CallChecker.varInit(this.start, "start", 179, 5901, 8019);
            CallChecker.varInit(this.weight, "weight", 179, 5901, 8019);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 179, 5901, 8019);
            CallChecker.varInit(this.target, "target", 179, 5901, 8019);
            CallChecker.varInit(this.checker, "checker", 179, 5901, 8019);
            CallChecker.varInit(this.evaluations, "evaluations", 179, 5901, 8019);
            if (f == null) {
                throw new NullArgumentException();
            }
            if (t == null) {
                throw new NullArgumentException();
            }
            if (w == null) {
                throw new NullArgumentException();
            }
            if (startPoint == null) {
                throw new NullArgumentException();
            }
            if ((t.length) != (w.length)) {
                throw new DimensionMismatchException(t.length, w.length);
            }
            return optimizeInternal(maxEval, f, new Target(t), new Weight(w), new InitialGuess(startPoint));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2483.methodEnd();
        }
    }

    protected PointVectorValuePair optimizeInternal(int maxEval, FUNC f, OptimizationData... optData) throws DimensionMismatchException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context2484 = new MethodContext(PointVectorValuePair.class, 225, 8026, 9467);
        try {
            CallChecker.varInit(this, "this", 225, 8026, 9467);
            CallChecker.varInit(optData, "optData", 225, 8026, 9467);
            CallChecker.varInit(f, "f", 225, 8026, 9467);
            CallChecker.varInit(maxEval, "maxEval", 225, 8026, 9467);
            CallChecker.varInit(this.function, "function", 225, 8026, 9467);
            CallChecker.varInit(this.start, "start", 225, 8026, 9467);
            CallChecker.varInit(this.weight, "weight", 225, 8026, 9467);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 225, 8026, 9467);
            CallChecker.varInit(this.target, "target", 225, 8026, 9467);
            CallChecker.varInit(this.checker, "checker", 225, 8026, 9467);
            CallChecker.varInit(this.evaluations, "evaluations", 225, 8026, 9467);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 231, 9089, 9099)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 231, 9089, 9099).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 232, 9135, 9145)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 232, 9135, 9145).resetCount();
            }
            function = f;
            CallChecker.varAssign(this.function, "this.function", 233, 9169, 9181);
            parseOptimizationData(optData);
            checkParameters();
            setUp();
            return doOptimize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2484.methodEnd();
        }
    }

    public double[] getStartPoint() {
        MethodContext _bcornu_methode_context2485 = new MethodContext(double[].class, 249, 9474, 9659);
        try {
            CallChecker.varInit(this, "this", 249, 9474, 9659);
            CallChecker.varInit(this.function, "function", 249, 9474, 9659);
            CallChecker.varInit(this.start, "start", 249, 9474, 9659);
            CallChecker.varInit(this.weight, "weight", 249, 9474, 9659);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 249, 9474, 9659);
            CallChecker.varInit(this.target, "target", 249, 9474, 9659);
            CallChecker.varInit(this.checker, "checker", 249, 9474, 9659);
            CallChecker.varInit(this.evaluations, "evaluations", 249, 9474, 9659);
            if (CallChecker.beforeDeref(start, double[].class, 250, 9640, 9644)) {
                start = CallChecker.beforeCalled(start, double[].class, 250, 9640, 9644);
                return CallChecker.isCalled(start, double[].class, 250, 9640, 9644).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2485.methodEnd();
        }
    }

    public RealMatrix getWeight() {
        MethodContext _bcornu_methode_context2486 = new MethodContext(RealMatrix.class, 259, 9666, 9864);
        try {
            CallChecker.varInit(this, "this", 259, 9666, 9864);
            CallChecker.varInit(this.function, "function", 259, 9666, 9864);
            CallChecker.varInit(this.start, "start", 259, 9666, 9864);
            CallChecker.varInit(this.weight, "weight", 259, 9666, 9864);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 259, 9666, 9864);
            CallChecker.varInit(this.target, "target", 259, 9666, 9864);
            CallChecker.varInit(this.checker, "checker", 259, 9666, 9864);
            CallChecker.varInit(this.evaluations, "evaluations", 259, 9666, 9864);
            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 260, 9839, 9850)) {
                weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 260, 9839, 9850);
                return CallChecker.isCalled(weightMatrix, RealMatrix.class, 260, 9839, 9850).copy();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2486.methodEnd();
        }
    }

    public double[] getTarget() {
        MethodContext _bcornu_methode_context2487 = new MethodContext(double[].class, 269, 9870, 10097);
        try {
            CallChecker.varInit(this, "this", 269, 9870, 10097);
            CallChecker.varInit(this.function, "function", 269, 9870, 10097);
            CallChecker.varInit(this.start, "start", 269, 9870, 10097);
            CallChecker.varInit(this.weight, "weight", 269, 9870, 10097);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 269, 9870, 10097);
            CallChecker.varInit(this.target, "target", 269, 9870, 10097);
            CallChecker.varInit(this.checker, "checker", 269, 9870, 10097);
            CallChecker.varInit(this.evaluations, "evaluations", 269, 9870, 10097);
            if (CallChecker.beforeDeref(target, double[].class, 270, 10077, 10082)) {
                target = CallChecker.beforeCalled(target, double[].class, 270, 10077, 10082);
                return CallChecker.isCalled(target, double[].class, 270, 10077, 10082).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2487.methodEnd();
        }
    }

    protected FUNC getObjectiveFunction() {
        MethodContext _bcornu_methode_context2488 = new MethodContext(null, 280, 10104, 10365);
        try {
            CallChecker.varInit(this, "this", 280, 10104, 10365);
            CallChecker.varInit(this.function, "function", 280, 10104, 10365);
            CallChecker.varInit(this.start, "start", 280, 10104, 10365);
            CallChecker.varInit(this.weight, "weight", 280, 10104, 10365);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 280, 10104, 10365);
            CallChecker.varInit(this.target, "target", 280, 10104, 10365);
            CallChecker.varInit(this.checker, "checker", 280, 10104, 10365);
            CallChecker.varInit(this.evaluations, "evaluations", 280, 10104, 10365);
            return function;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FUNC) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2488.methodEnd();
        }
    }

    protected abstract PointVectorValuePair doOptimize();

    @Deprecated
    protected double[] getTargetRef() {
        MethodContext _bcornu_methode_context2490 = new MethodContext(double[].class, 297, 10605, 10787);
        try {
            CallChecker.varInit(this, "this", 297, 10605, 10787);
            CallChecker.varInit(this.function, "function", 297, 10605, 10787);
            CallChecker.varInit(this.start, "start", 297, 10605, 10787);
            CallChecker.varInit(this.weight, "weight", 297, 10605, 10787);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 297, 10605, 10787);
            CallChecker.varInit(this.target, "target", 297, 10605, 10787);
            CallChecker.varInit(this.checker, "checker", 297, 10605, 10787);
            CallChecker.varInit(this.evaluations, "evaluations", 297, 10605, 10787);
            return target;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2490.methodEnd();
        }
    }

    @Deprecated
    protected double[] getWeightRef() {
        MethodContext _bcornu_methode_context2491 = new MethodContext(double[].class, 305, 10793, 10975);
        try {
            CallChecker.varInit(this, "this", 305, 10793, 10975);
            CallChecker.varInit(this.function, "function", 305, 10793, 10975);
            CallChecker.varInit(this.start, "start", 305, 10793, 10975);
            CallChecker.varInit(this.weight, "weight", 305, 10793, 10975);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 305, 10793, 10975);
            CallChecker.varInit(this.target, "target", 305, 10793, 10975);
            CallChecker.varInit(this.checker, "checker", 305, 10793, 10975);
            CallChecker.varInit(this.evaluations, "evaluations", 305, 10793, 10975);
            return weight;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2491.methodEnd();
        }
    }

    protected void setUp() {
        MethodContext _bcornu_methode_context2492 = new MethodContext(void.class, 319, 10982, 11677);
        try {
            CallChecker.varInit(this, "this", 319, 10982, 11677);
            CallChecker.varInit(this.function, "function", 319, 10982, 11677);
            CallChecker.varInit(this.start, "start", 319, 10982, 11677);
            CallChecker.varInit(this.weight, "weight", 319, 10982, 11677);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 319, 10982, 11677);
            CallChecker.varInit(this.target, "target", 319, 10982, 11677);
            CallChecker.varInit(this.checker, "checker", 319, 10982, 11677);
            CallChecker.varInit(this.evaluations, "evaluations", 319, 10982, 11677);
            target = CallChecker.beforeCalled(target, double[].class, 321, 11521, 11526);
            final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(this.target, double[].class, 321, 11521, 11526).length)), "dim", 321, 11427, 11534);
            weight = new double[dim];
            CallChecker.varAssign(this.weight, "this.weight", 322, 11544, 11568);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(weight, double[].class, 324, 11622, 11627)) {
                    if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 324, 11634, 11645)) {
                        weight = CallChecker.beforeCalled(weight, double[].class, 324, 11622, 11627);
                        weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 324, 11634, 11645);
                        CallChecker.isCalled(weight, double[].class, 324, 11622, 11627)[i] = CallChecker.isCalled(weightMatrix, RealMatrix.class, 324, 11634, 11645).getEntry(i, i);
                        CallChecker.varAssign(CallChecker.isCalled(this.weight, double[].class, 324, 11622, 11627)[i], "CallChecker.isCalled(this.weight, double[].class, 324, 11622, 11627)[i]", 324, 11622, 11661);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2492.methodEnd();
        }
    }

    private void parseOptimizationData(OptimizationData... optData) {
        MethodContext _bcornu_methode_context2493 = new MethodContext(void.class, 339, 11684, 12699);
        try {
            CallChecker.varInit(this, "this", 339, 11684, 12699);
            CallChecker.varInit(optData, "optData", 339, 11684, 12699);
            CallChecker.varInit(this.function, "function", 339, 11684, 12699);
            CallChecker.varInit(this.start, "start", 339, 11684, 12699);
            CallChecker.varInit(this.weight, "weight", 339, 11684, 12699);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 339, 11684, 12699);
            CallChecker.varInit(this.target, "target", 339, 11684, 12699);
            CallChecker.varInit(this.checker, "checker", 339, 11684, 12699);
            CallChecker.varInit(this.evaluations, "evaluations", 339, 11684, 12699);
            if (CallChecker.beforeDeref(optData, void.class, 342, 12243, 12249)) {
                for (OptimizationData data : optData) {
                    if (data instanceof Target) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 344, 12331, 12334)) {
                            target = CallChecker.isCalled(((Target) (data)), Target.class, 344, 12331, 12334).getTarget();
                            CallChecker.varAssign(this.target, "this.target", 344, 12312, 12348);
                        }
                        continue;
                    }
                    if (data instanceof Weight) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 348, 12473, 12476)) {
                            weightMatrix = CallChecker.isCalled(((Weight) (data)), Weight.class, 348, 12473, 12476).getWeight();
                            CallChecker.varAssign(this.weightMatrix, "this.weightMatrix", 348, 12448, 12490);
                        }
                        continue;
                    }
                    if (data instanceof InitialGuess) {
                        if (CallChecker.beforeDeref(data, OptimizationData.class, 352, 12620, 12623)) {
                            start = CallChecker.isCalled(((InitialGuess) (data)), InitialGuess.class, 352, 12620, 12623).getInitialGuess();
                            CallChecker.varAssign(this.start, "this.start", 352, 12596, 12643);
                        }
                        continue;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2493.methodEnd();
        }
    }

    private void checkParameters() {
        MethodContext _bcornu_methode_context2494 = new MethodContext(void.class, 364, 12706, 13152);
        try {
            CallChecker.varInit(this, "this", 364, 12706, 13152);
            CallChecker.varInit(this.function, "function", 364, 12706, 13152);
            CallChecker.varInit(this.start, "start", 364, 12706, 13152);
            CallChecker.varInit(this.weight, "weight", 364, 12706, 13152);
            CallChecker.varInit(this.weightMatrix, "weightMatrix", 364, 12706, 13152);
            CallChecker.varInit(this.target, "target", 364, 12706, 13152);
            CallChecker.varInit(this.checker, "checker", 364, 12706, 13152);
            CallChecker.varInit(this.evaluations, "evaluations", 364, 12706, 13152);
            if (CallChecker.beforeDeref(target, double[].class, 365, 12935, 12940)) {
                if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 365, 12952, 12963)) {
                    target = CallChecker.beforeCalled(target, double[].class, 365, 12935, 12940);
                    weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 365, 12952, 12963);
                    if ((CallChecker.isCalled(target, double[].class, 365, 12935, 12940).length) != (CallChecker.isCalled(weightMatrix, RealMatrix.class, 365, 12952, 12963).getColumnDimension())) {
                        if (CallChecker.beforeDeref(target, double[].class, 366, 13038, 13043)) {
                            if (CallChecker.beforeDeref(weightMatrix, RealMatrix.class, 367, 13102, 13113)) {
                                target = CallChecker.beforeCalled(target, double[].class, 366, 13038, 13043);
                                weightMatrix = CallChecker.beforeCalled(weightMatrix, RealMatrix.class, 367, 13102, 13113);
                                throw new DimensionMismatchException(CallChecker.isCalled(target, double[].class, 366, 13038, 13043).length, CallChecker.isCalled(weightMatrix, RealMatrix.class, 367, 13102, 13113).getColumnDimension());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2494.methodEnd();
        }
    }
}

