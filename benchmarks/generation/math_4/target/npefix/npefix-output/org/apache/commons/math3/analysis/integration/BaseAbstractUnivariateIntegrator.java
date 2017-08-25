package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.MathUtils;

public abstract class BaseAbstractUnivariateIntegrator implements UnivariateIntegrator {
    public static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-15;

    public static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-6;

    public static final int DEFAULT_MIN_ITERATIONS_COUNT = 3;

    public static final int DEFAULT_MAX_ITERATIONS_COUNT = Integer.MAX_VALUE;

    protected final Incrementor iterations;

    private final double absoluteAccuracy;

    private final double relativeAccuracy;

    private final int minimalIterationCount;

    private final Incrementor evaluations;

    private UnivariateFunction function;

    private double min;

    private double max;

    protected BaseAbstractUnivariateIntegrator(final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context270 = new ConstructorContext(BaseAbstractUnivariateIntegrator.class, 109, 2771, 5966);
        try {
            this.relativeAccuracy = relativeAccuracy;
            CallChecker.varAssign(this.relativeAccuracy, "this.relativeAccuracy", 116, 5241, 5286);
            this.absoluteAccuracy = absoluteAccuracy;
            CallChecker.varAssign(this.absoluteAccuracy, "this.absoluteAccuracy", 117, 5296, 5341);
            if (minimalIterationCount <= 0) {
                throw new NotStrictlyPositiveException(minimalIterationCount);
            }
            if (maximalIterationCount <= minimalIterationCount) {
                throw new NumberIsTooSmallException(maximalIterationCount, minimalIterationCount, false);
            }
            this.minimalIterationCount = minimalIterationCount;
            CallChecker.varAssign(this.minimalIterationCount, "this.minimalIterationCount", 126, 5690, 5740);
            this.iterations = new Incrementor();
            CallChecker.varAssign(this.iterations, "this.iterations", 127, 5750, 5796);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 128, 5806, 5815)) {
                CallChecker.isCalled(iterations, Incrementor.class, 128, 5806, 5815).setMaximalCount(maximalIterationCount);
            }
            evaluations = new Incrementor();
            CallChecker.varAssign(this.evaluations, "this.evaluations", 131, 5928, 5959);
        } finally {
            _bcornu_methode_context270.methodEnd();
        }
    }

    protected BaseAbstractUnivariateIntegrator(final double relativeAccuracy, final double absoluteAccuracy) {
        this(relativeAccuracy, absoluteAccuracy, BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context271 = new ConstructorContext(BaseAbstractUnivariateIntegrator.class, 140, 5973, 6446);
        try {
        } finally {
            _bcornu_methode_context271.methodEnd();
        }
    }

    protected BaseAbstractUnivariateIntegrator(final int minimalIterationCount, final int maximalIterationCount) throws NotStrictlyPositiveException, NumberIsTooSmallException {
        this(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context272 = new ConstructorContext(BaseAbstractUnivariateIntegrator.class, 155, 6453, 7269);
        try {
        } finally {
            _bcornu_methode_context272.methodEnd();
        }
    }

    public double getRelativeAccuracy() {
        MethodContext _bcornu_methode_context1177 = new MethodContext(double.class, 163, 7276, 7376);
        try {
            CallChecker.varInit(this, "this", 163, 7276, 7376);
            CallChecker.varInit(this.max, "max", 163, 7276, 7376);
            CallChecker.varInit(this.min, "min", 163, 7276, 7376);
            CallChecker.varInit(this.function, "function", 163, 7276, 7376);
            CallChecker.varInit(this.evaluations, "evaluations", 163, 7276, 7376);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 163, 7276, 7376);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 163, 7276, 7376);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 163, 7276, 7376);
            CallChecker.varInit(this.iterations, "iterations", 163, 7276, 7376);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 163, 7276, 7376);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 163, 7276, 7376);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 163, 7276, 7376);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 163, 7276, 7376);
            return relativeAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1177.methodEnd();
        }
    }

    public double getAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context1178 = new MethodContext(double.class, 168, 7383, 7483);
        try {
            CallChecker.varInit(this, "this", 168, 7383, 7483);
            CallChecker.varInit(this.max, "max", 168, 7383, 7483);
            CallChecker.varInit(this.min, "min", 168, 7383, 7483);
            CallChecker.varInit(this.function, "function", 168, 7383, 7483);
            CallChecker.varInit(this.evaluations, "evaluations", 168, 7383, 7483);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 168, 7383, 7483);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 168, 7383, 7483);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 168, 7383, 7483);
            CallChecker.varInit(this.iterations, "iterations", 168, 7383, 7483);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 168, 7383, 7483);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 168, 7383, 7483);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 168, 7383, 7483);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 168, 7383, 7483);
            return absoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1178.methodEnd();
        }
    }

    public int getMinimalIterationCount() {
        MethodContext _bcornu_methode_context1179 = new MethodContext(int.class, 173, 7490, 7597);
        try {
            CallChecker.varInit(this, "this", 173, 7490, 7597);
            CallChecker.varInit(this.max, "max", 173, 7490, 7597);
            CallChecker.varInit(this.min, "min", 173, 7490, 7597);
            CallChecker.varInit(this.function, "function", 173, 7490, 7597);
            CallChecker.varInit(this.evaluations, "evaluations", 173, 7490, 7597);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 173, 7490, 7597);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 173, 7490, 7597);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 173, 7490, 7597);
            CallChecker.varInit(this.iterations, "iterations", 173, 7490, 7597);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 173, 7490, 7597);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 173, 7490, 7597);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 173, 7490, 7597);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 173, 7490, 7597);
            return minimalIterationCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1179.methodEnd();
        }
    }

    public int getMaximalIterationCount() {
        MethodContext _bcornu_methode_context1180 = new MethodContext(int.class, 178, 7604, 7718);
        try {
            CallChecker.varInit(this, "this", 178, 7604, 7718);
            CallChecker.varInit(this.max, "max", 178, 7604, 7718);
            CallChecker.varInit(this.min, "min", 178, 7604, 7718);
            CallChecker.varInit(this.function, "function", 178, 7604, 7718);
            CallChecker.varInit(this.evaluations, "evaluations", 178, 7604, 7718);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 178, 7604, 7718);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 178, 7604, 7718);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 178, 7604, 7718);
            CallChecker.varInit(this.iterations, "iterations", 178, 7604, 7718);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 178, 7604, 7718);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 178, 7604, 7718);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 178, 7604, 7718);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 178, 7604, 7718);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 179, 7684, 7693)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 179, 7684, 7693).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1180.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context1181 = new MethodContext(int.class, 183, 7725, 7823);
        try {
            CallChecker.varInit(this, "this", 183, 7725, 7823);
            CallChecker.varInit(this.max, "max", 183, 7725, 7823);
            CallChecker.varInit(this.min, "min", 183, 7725, 7823);
            CallChecker.varInit(this.function, "function", 183, 7725, 7823);
            CallChecker.varInit(this.evaluations, "evaluations", 183, 7725, 7823);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 183, 7725, 7823);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 183, 7725, 7823);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 183, 7725, 7823);
            CallChecker.varInit(this.iterations, "iterations", 183, 7725, 7823);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 183, 7725, 7823);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 183, 7725, 7823);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 183, 7725, 7823);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 183, 7725, 7823);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 184, 7795, 7805)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 184, 7795, 7805).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1181.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context1182 = new MethodContext(int.class, 188, 7830, 7926);
        try {
            CallChecker.varInit(this, "this", 188, 7830, 7926);
            CallChecker.varInit(this.max, "max", 188, 7830, 7926);
            CallChecker.varInit(this.min, "min", 188, 7830, 7926);
            CallChecker.varInit(this.function, "function", 188, 7830, 7926);
            CallChecker.varInit(this.evaluations, "evaluations", 188, 7830, 7926);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 188, 7830, 7926);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 188, 7830, 7926);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 188, 7830, 7926);
            CallChecker.varInit(this.iterations, "iterations", 188, 7830, 7926);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 188, 7830, 7926);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 188, 7830, 7926);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 188, 7830, 7926);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 188, 7830, 7926);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 189, 7899, 7908)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 189, 7899, 7908).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1182.methodEnd();
        }
    }

    protected double getMin() {
        MethodContext _bcornu_methode_context1183 = new MethodContext(double.class, 195, 7933, 8033);
        try {
            CallChecker.varInit(this, "this", 195, 7933, 8033);
            CallChecker.varInit(this.max, "max", 195, 7933, 8033);
            CallChecker.varInit(this.min, "min", 195, 7933, 8033);
            CallChecker.varInit(this.function, "function", 195, 7933, 8033);
            CallChecker.varInit(this.evaluations, "evaluations", 195, 7933, 8033);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 195, 7933, 8033);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 195, 7933, 8033);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 195, 7933, 8033);
            CallChecker.varInit(this.iterations, "iterations", 195, 7933, 8033);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 195, 7933, 8033);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 195, 7933, 8033);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 195, 7933, 8033);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 195, 7933, 8033);
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1183.methodEnd();
        }
    }

    protected double getMax() {
        MethodContext _bcornu_methode_context1184 = new MethodContext(double.class, 201, 8039, 8139);
        try {
            CallChecker.varInit(this, "this", 201, 8039, 8139);
            CallChecker.varInit(this.max, "max", 201, 8039, 8139);
            CallChecker.varInit(this.min, "min", 201, 8039, 8139);
            CallChecker.varInit(this.function, "function", 201, 8039, 8139);
            CallChecker.varInit(this.evaluations, "evaluations", 201, 8039, 8139);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 201, 8039, 8139);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 201, 8039, 8139);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 201, 8039, 8139);
            CallChecker.varInit(this.iterations, "iterations", 201, 8039, 8139);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 201, 8039, 8139);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 201, 8039, 8139);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 201, 8039, 8139);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 201, 8039, 8139);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1184.methodEnd();
        }
    }

    protected double computeObjectiveValue(final double point) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context1185 = new MethodContext(double.class, 213, 8146, 8787);
        try {
            CallChecker.varInit(this, "this", 213, 8146, 8787);
            CallChecker.varInit(point, "point", 213, 8146, 8787);
            CallChecker.varInit(this.max, "max", 213, 8146, 8787);
            CallChecker.varInit(this.min, "min", 213, 8146, 8787);
            CallChecker.varInit(this.function, "function", 213, 8146, 8787);
            CallChecker.varInit(this.evaluations, "evaluations", 213, 8146, 8787);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 213, 8146, 8787);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 213, 8146, 8787);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 213, 8146, 8787);
            CallChecker.varInit(this.iterations, "iterations", 213, 8146, 8787);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 213, 8146, 8787);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 213, 8146, 8787);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 213, 8146, 8787);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 213, 8146, 8787);
            TryContext _bcornu_try_context_21 = new TryContext(21, BaseAbstractUnivariateIntegrator.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 216, 8594, 8604)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 216, 8594, 8604).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_21.catchStart(21);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_21.finallyStart(21);
            }
            if (CallChecker.beforeDeref(function, UnivariateFunction.class, 220, 8760, 8767)) {
                function = CallChecker.beforeCalled(function, UnivariateFunction.class, 220, 8760, 8767);
                return CallChecker.isCalled(function, UnivariateFunction.class, 220, 8760, 8767).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1185.methodEnd();
        }
    }

    protected void setup(final int maxEval, final UnivariateFunction f, final double lower, final double upper) throws MathIllegalArgumentException, NullArgumentException {
        MethodContext _bcornu_methode_context1186 = new MethodContext(void.class, 235, 8794, 9820);
        try {
            CallChecker.varInit(this, "this", 235, 8794, 9820);
            CallChecker.varInit(upper, "upper", 235, 8794, 9820);
            CallChecker.varInit(lower, "lower", 235, 8794, 9820);
            CallChecker.varInit(f, "f", 235, 8794, 9820);
            CallChecker.varInit(maxEval, "maxEval", 235, 8794, 9820);
            CallChecker.varInit(this.max, "max", 235, 8794, 9820);
            CallChecker.varInit(this.min, "min", 235, 8794, 9820);
            CallChecker.varInit(this.function, "function", 235, 8794, 9820);
            CallChecker.varInit(this.evaluations, "evaluations", 235, 8794, 9820);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 235, 8794, 9820);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 235, 8794, 9820);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 235, 8794, 9820);
            CallChecker.varInit(this.iterations, "iterations", 235, 8794, 9820);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 235, 8794, 9820);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 235, 8794, 9820);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 235, 8794, 9820);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 235, 8794, 9820);
            MathUtils.checkNotNull(f);
            UnivariateSolverUtils.verifyInterval(lower, upper);
            min = lower;
            CallChecker.varAssign(this.min, "this.min", 245, 9646, 9657);
            max = upper;
            CallChecker.varAssign(this.max, "this.max", 246, 9667, 9678);
            function = f;
            CallChecker.varAssign(this.function, "this.function", 247, 9688, 9700);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 248, 9710, 9720)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 248, 9710, 9720).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 249, 9756, 9766)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 249, 9756, 9766).resetCount();
            }
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 250, 9790, 9799)) {
                CallChecker.isCalled(iterations, Incrementor.class, 250, 9790, 9799).resetCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1186.methodEnd();
        }
    }

    public double integrate(final int maxEval, final UnivariateFunction f, final double lower, final double upper) throws MathIllegalArgumentException, MaxCountExceededException, NullArgumentException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context1187 = new MethodContext(double.class, 255, 9827, 10268);
        try {
            CallChecker.varInit(this, "this", 255, 9827, 10268);
            CallChecker.varInit(upper, "upper", 255, 9827, 10268);
            CallChecker.varInit(lower, "lower", 255, 9827, 10268);
            CallChecker.varInit(f, "f", 255, 9827, 10268);
            CallChecker.varInit(maxEval, "maxEval", 255, 9827, 10268);
            CallChecker.varInit(this.max, "max", 255, 9827, 10268);
            CallChecker.varInit(this.min, "min", 255, 9827, 10268);
            CallChecker.varInit(this.function, "function", 255, 9827, 10268);
            CallChecker.varInit(this.evaluations, "evaluations", 255, 9827, 10268);
            CallChecker.varInit(this.minimalIterationCount, "minimalIterationCount", 255, 9827, 10268);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 255, 9827, 10268);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 255, 9827, 10268);
            CallChecker.varInit(this.iterations, "iterations", 255, 9827, 10268);
            CallChecker.varInit(DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 255, 9827, 10268);
            CallChecker.varInit(DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 255, 9827, 10268);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 255, 9827, 10268);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 255, 9827, 10268);
            setup(maxEval, f, lower, upper);
            return doIntegrate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1187.methodEnd();
        }
    }

    protected abstract double doIntegrate() throws MaxCountExceededException, TooManyEvaluationsException;
}

