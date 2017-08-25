package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.MathUtils;

public abstract class BaseAbstractUnivariateSolver<FUNC extends UnivariateFunction> implements BaseUnivariateSolver<FUNC> {
    private static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-14;

    private static final double DEFAULT_FUNCTION_VALUE_ACCURACY = 1.0E-15;

    private final double functionValueAccuracy;

    private final double absoluteAccuracy;

    private final double relativeAccuracy;

    private final Incrementor evaluations = new Incrementor();

    private double searchMin;

    private double searchMax;

    private double searchStart;

    private FUNC function;

    protected BaseAbstractUnivariateSolver(final double absoluteAccuracy) {
        this(BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY, absoluteAccuracy, BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY);
        ConstructorContext _bcornu_methode_context1060 = new ConstructorContext(BaseAbstractUnivariateSolver.class, 66, 2470, 2798);
        try {
        } finally {
            _bcornu_methode_context1060.methodEnd();
        }
    }

    protected BaseAbstractUnivariateSolver(final double relativeAccuracy, final double absoluteAccuracy) {
        this(relativeAccuracy, absoluteAccuracy, BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY);
        ConstructorContext _bcornu_methode_context1061 = new ConstructorContext(BaseAbstractUnivariateSolver.class, 78, 2805, 3250);
        try {
        } finally {
            _bcornu_methode_context1061.methodEnd();
        }
    }

    protected BaseAbstractUnivariateSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy) {
        ConstructorContext _bcornu_methode_context1062 = new ConstructorContext(BaseAbstractUnivariateSolver.class, 92, 3257, 3902);
        try {
            this.absoluteAccuracy = absoluteAccuracy;
            CallChecker.varAssign(this.absoluteAccuracy, "this.absoluteAccuracy", 95, 3746, 3786);
            this.relativeAccuracy = relativeAccuracy;
            CallChecker.varAssign(this.relativeAccuracy, "this.relativeAccuracy", 96, 3796, 3836);
            this.functionValueAccuracy = functionValueAccuracy;
            CallChecker.varAssign(this.functionValueAccuracy, "this.functionValueAccuracy", 97, 3846, 3896);
        } finally {
            _bcornu_methode_context1062.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context4702 = new MethodContext(int.class, 101, 3909, 4017);
        try {
            CallChecker.varInit(this, "this", 101, 3909, 4017);
            CallChecker.varInit(this.function, "function", 101, 3909, 4017);
            CallChecker.varInit(this.searchStart, "searchStart", 101, 3909, 4017);
            CallChecker.varInit(this.searchMax, "searchMax", 101, 3909, 4017);
            CallChecker.varInit(this.searchMin, "searchMin", 101, 3909, 4017);
            CallChecker.varInit(this.evaluations, "evaluations", 101, 3909, 4017);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 101, 3909, 4017);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 101, 3909, 4017);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 101, 3909, 4017);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 101, 3909, 4017);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 101, 3909, 4017);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 102, 3982, 3992)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 102, 3982, 3992).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4702.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context4703 = new MethodContext(int.class, 105, 4023, 4121);
        try {
            CallChecker.varInit(this, "this", 105, 4023, 4121);
            CallChecker.varInit(this.function, "function", 105, 4023, 4121);
            CallChecker.varInit(this.searchStart, "searchStart", 105, 4023, 4121);
            CallChecker.varInit(this.searchMax, "searchMax", 105, 4023, 4121);
            CallChecker.varInit(this.searchMin, "searchMin", 105, 4023, 4121);
            CallChecker.varInit(this.evaluations, "evaluations", 105, 4023, 4121);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 105, 4023, 4121);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 105, 4023, 4121);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 105, 4023, 4121);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 105, 4023, 4121);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 105, 4023, 4121);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 106, 4093, 4103)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 106, 4093, 4103).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4703.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context4704 = new MethodContext(double.class, 111, 4127, 4251);
        try {
            CallChecker.varInit(this, "this", 111, 4127, 4251);
            CallChecker.varInit(this.function, "function", 111, 4127, 4251);
            CallChecker.varInit(this.searchStart, "searchStart", 111, 4127, 4251);
            CallChecker.varInit(this.searchMax, "searchMax", 111, 4127, 4251);
            CallChecker.varInit(this.searchMin, "searchMin", 111, 4127, 4251);
            CallChecker.varInit(this.evaluations, "evaluations", 111, 4127, 4251);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 111, 4127, 4251);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 111, 4127, 4251);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 111, 4127, 4251);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 111, 4127, 4251);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 111, 4127, 4251);
            return searchMin;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4704.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context4705 = new MethodContext(double.class, 117, 4257, 4382);
        try {
            CallChecker.varInit(this, "this", 117, 4257, 4382);
            CallChecker.varInit(this.function, "function", 117, 4257, 4382);
            CallChecker.varInit(this.searchStart, "searchStart", 117, 4257, 4382);
            CallChecker.varInit(this.searchMax, "searchMax", 117, 4257, 4382);
            CallChecker.varInit(this.searchMin, "searchMin", 117, 4257, 4382);
            CallChecker.varInit(this.evaluations, "evaluations", 117, 4257, 4382);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 117, 4257, 4382);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 117, 4257, 4382);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 117, 4257, 4382);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 117, 4257, 4382);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 117, 4257, 4382);
            return searchMax;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4705.methodEnd();
        }
    }

    public double getStartValue() {
        MethodContext _bcornu_methode_context4706 = new MethodContext(double.class, 123, 4388, 4502);
        try {
            CallChecker.varInit(this, "this", 123, 4388, 4502);
            CallChecker.varInit(this.function, "function", 123, 4388, 4502);
            CallChecker.varInit(this.searchStart, "searchStart", 123, 4388, 4502);
            CallChecker.varInit(this.searchMax, "searchMax", 123, 4388, 4502);
            CallChecker.varInit(this.searchMin, "searchMin", 123, 4388, 4502);
            CallChecker.varInit(this.evaluations, "evaluations", 123, 4388, 4502);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 123, 4388, 4502);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 123, 4388, 4502);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 123, 4388, 4502);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 123, 4388, 4502);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 123, 4388, 4502);
            return searchStart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4706.methodEnd();
        }
    }

    public double getAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context4707 = new MethodContext(double.class, 129, 4508, 4620);
        try {
            CallChecker.varInit(this, "this", 129, 4508, 4620);
            CallChecker.varInit(this.function, "function", 129, 4508, 4620);
            CallChecker.varInit(this.searchStart, "searchStart", 129, 4508, 4620);
            CallChecker.varInit(this.searchMax, "searchMax", 129, 4508, 4620);
            CallChecker.varInit(this.searchMin, "searchMin", 129, 4508, 4620);
            CallChecker.varInit(this.evaluations, "evaluations", 129, 4508, 4620);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 129, 4508, 4620);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 129, 4508, 4620);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 129, 4508, 4620);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 129, 4508, 4620);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 129, 4508, 4620);
            return absoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4707.methodEnd();
        }
    }

    public double getRelativeAccuracy() {
        MethodContext _bcornu_methode_context4708 = new MethodContext(double.class, 135, 4626, 4738);
        try {
            CallChecker.varInit(this, "this", 135, 4626, 4738);
            CallChecker.varInit(this.function, "function", 135, 4626, 4738);
            CallChecker.varInit(this.searchStart, "searchStart", 135, 4626, 4738);
            CallChecker.varInit(this.searchMax, "searchMax", 135, 4626, 4738);
            CallChecker.varInit(this.searchMin, "searchMin", 135, 4626, 4738);
            CallChecker.varInit(this.evaluations, "evaluations", 135, 4626, 4738);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 135, 4626, 4738);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 135, 4626, 4738);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 135, 4626, 4738);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 135, 4626, 4738);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 135, 4626, 4738);
            return relativeAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4708.methodEnd();
        }
    }

    public double getFunctionValueAccuracy() {
        MethodContext _bcornu_methode_context4709 = new MethodContext(double.class, 141, 4744, 4866);
        try {
            CallChecker.varInit(this, "this", 141, 4744, 4866);
            CallChecker.varInit(this.function, "function", 141, 4744, 4866);
            CallChecker.varInit(this.searchStart, "searchStart", 141, 4744, 4866);
            CallChecker.varInit(this.searchMax, "searchMax", 141, 4744, 4866);
            CallChecker.varInit(this.searchMin, "searchMin", 141, 4744, 4866);
            CallChecker.varInit(this.evaluations, "evaluations", 141, 4744, 4866);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 141, 4744, 4866);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 141, 4744, 4866);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 141, 4744, 4866);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 141, 4744, 4866);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 141, 4744, 4866);
            return functionValueAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4709.methodEnd();
        }
    }

    protected double computeObjectiveValue(double point) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4710 = new MethodContext(double.class, 153, 4873, 5358);
        try {
            CallChecker.varInit(this, "this", 153, 4873, 5358);
            CallChecker.varInit(point, "point", 153, 4873, 5358);
            CallChecker.varInit(this.function, "function", 153, 4873, 5358);
            CallChecker.varInit(this.searchStart, "searchStart", 153, 4873, 5358);
            CallChecker.varInit(this.searchMax, "searchMax", 153, 4873, 5358);
            CallChecker.varInit(this.searchMin, "searchMin", 153, 4873, 5358);
            CallChecker.varInit(this.evaluations, "evaluations", 153, 4873, 5358);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 153, 4873, 5358);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 153, 4873, 5358);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 153, 4873, 5358);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 153, 4873, 5358);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 153, 4873, 5358);
            incrementEvaluationCount();
            if (CallChecker.beforeDeref(function, null, 156, 5331, 5338)) {
                return function.value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4710.methodEnd();
        }
    }

    protected void setup(int maxEval, FUNC f, double min, double max, double startValue) throws NullArgumentException {
        MethodContext _bcornu_methode_context4711 = new MethodContext(void.class, 171, 5365, 6262);
        try {
            CallChecker.varInit(this, "this", 171, 5365, 6262);
            CallChecker.varInit(startValue, "startValue", 171, 5365, 6262);
            CallChecker.varInit(max, "max", 171, 5365, 6262);
            CallChecker.varInit(min, "min", 171, 5365, 6262);
            CallChecker.varInit(f, "f", 171, 5365, 6262);
            CallChecker.varInit(maxEval, "maxEval", 171, 5365, 6262);
            CallChecker.varInit(this.function, "function", 171, 5365, 6262);
            CallChecker.varInit(this.searchStart, "searchStart", 171, 5365, 6262);
            CallChecker.varInit(this.searchMax, "searchMax", 171, 5365, 6262);
            CallChecker.varInit(this.searchMin, "searchMin", 171, 5365, 6262);
            CallChecker.varInit(this.evaluations, "evaluations", 171, 5365, 6262);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 171, 5365, 6262);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 171, 5365, 6262);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 171, 5365, 6262);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 171, 5365, 6262);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 171, 5365, 6262);
            MathUtils.checkNotNull(f);
            searchMin = min;
            CallChecker.varAssign(this.searchMin, "this.searchMin", 180, 6080, 6095);
            searchMax = max;
            CallChecker.varAssign(this.searchMax, "this.searchMax", 181, 6105, 6120);
            searchStart = startValue;
            CallChecker.varAssign(this.searchStart, "this.searchStart", 182, 6130, 6154);
            function = f;
            CallChecker.varAssign(this.function, "this.function", 183, 6164, 6176);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 184, 6186, 6196)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 184, 6186, 6196).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 185, 6232, 6242)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 185, 6232, 6242).resetCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4711.methodEnd();
        }
    }

    public double solve(int maxEval, FUNC f, double min, double max, double startValue) throws NoBracketingException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4712 = new MethodContext(double.class, 189, 6269, 6600);
        try {
            CallChecker.varInit(this, "this", 189, 6269, 6600);
            CallChecker.varInit(startValue, "startValue", 189, 6269, 6600);
            CallChecker.varInit(max, "max", 189, 6269, 6600);
            CallChecker.varInit(min, "min", 189, 6269, 6600);
            CallChecker.varInit(f, "f", 189, 6269, 6600);
            CallChecker.varInit(maxEval, "maxEval", 189, 6269, 6600);
            CallChecker.varInit(this.function, "function", 189, 6269, 6600);
            CallChecker.varInit(this.searchStart, "searchStart", 189, 6269, 6600);
            CallChecker.varInit(this.searchMax, "searchMax", 189, 6269, 6600);
            CallChecker.varInit(this.searchMin, "searchMin", 189, 6269, 6600);
            CallChecker.varInit(this.evaluations, "evaluations", 189, 6269, 6600);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 189, 6269, 6600);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 189, 6269, 6600);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 189, 6269, 6600);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 189, 6269, 6600);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 189, 6269, 6600);
            setup(maxEval, f, min, max, startValue);
            return doSolve();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4712.methodEnd();
        }
    }

    public double solve(int maxEval, FUNC f, double min, double max) {
        MethodContext _bcornu_methode_context4713 = new MethodContext(double.class, 200, 6607, 6772);
        try {
            CallChecker.varInit(this, "this", 200, 6607, 6772);
            CallChecker.varInit(max, "max", 200, 6607, 6772);
            CallChecker.varInit(min, "min", 200, 6607, 6772);
            CallChecker.varInit(f, "f", 200, 6607, 6772);
            CallChecker.varInit(maxEval, "maxEval", 200, 6607, 6772);
            CallChecker.varInit(this.function, "function", 200, 6607, 6772);
            CallChecker.varInit(this.searchStart, "searchStart", 200, 6607, 6772);
            CallChecker.varInit(this.searchMax, "searchMax", 200, 6607, 6772);
            CallChecker.varInit(this.searchMin, "searchMin", 200, 6607, 6772);
            CallChecker.varInit(this.evaluations, "evaluations", 200, 6607, 6772);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 200, 6607, 6772);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 200, 6607, 6772);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 200, 6607, 6772);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 200, 6607, 6772);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 200, 6607, 6772);
            return solve(maxEval, f, min, max, (min + (0.5 * (max - min))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4713.methodEnd();
        }
    }

    public double solve(int maxEval, FUNC f, double startValue) throws NoBracketingException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4714 = new MethodContext(double.class, 205, 6779, 7021);
        try {
            CallChecker.varInit(this, "this", 205, 6779, 7021);
            CallChecker.varInit(startValue, "startValue", 205, 6779, 7021);
            CallChecker.varInit(f, "f", 205, 6779, 7021);
            CallChecker.varInit(maxEval, "maxEval", 205, 6779, 7021);
            CallChecker.varInit(this.function, "function", 205, 6779, 7021);
            CallChecker.varInit(this.searchStart, "searchStart", 205, 6779, 7021);
            CallChecker.varInit(this.searchMax, "searchMax", 205, 6779, 7021);
            CallChecker.varInit(this.searchMin, "searchMin", 205, 6779, 7021);
            CallChecker.varInit(this.evaluations, "evaluations", 205, 6779, 7021);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 205, 6779, 7021);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 205, 6779, 7021);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 205, 6779, 7021);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 205, 6779, 7021);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 205, 6779, 7021);
            return solve(maxEval, f, Double.NaN, Double.NaN, startValue);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4714.methodEnd();
        }
    }

    protected abstract double doSolve() throws NoBracketingException, TooManyEvaluationsException;

    protected boolean isBracketing(final double lower, final double upper) {
        MethodContext _bcornu_methode_context4716 = new MethodContext(boolean.class, 232, 7500, 7954);
        try {
            CallChecker.varInit(this, "this", 232, 7500, 7954);
            CallChecker.varInit(upper, "upper", 232, 7500, 7954);
            CallChecker.varInit(lower, "lower", 232, 7500, 7954);
            CallChecker.varInit(this.function, "function", 232, 7500, 7954);
            CallChecker.varInit(this.searchStart, "searchStart", 232, 7500, 7954);
            CallChecker.varInit(this.searchMax, "searchMax", 232, 7500, 7954);
            CallChecker.varInit(this.searchMin, "searchMin", 232, 7500, 7954);
            CallChecker.varInit(this.evaluations, "evaluations", 232, 7500, 7954);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 232, 7500, 7954);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 232, 7500, 7954);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 232, 7500, 7954);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 232, 7500, 7954);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 232, 7500, 7954);
            return UnivariateSolverUtils.isBracketing(function, lower, upper);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4716.methodEnd();
        }
    }

    protected boolean isSequence(final double start, final double mid, final double end) {
        MethodContext _bcornu_methode_context4717 = new MethodContext(boolean.class, 245, 7961, 8454);
        try {
            CallChecker.varInit(this, "this", 245, 7961, 8454);
            CallChecker.varInit(end, "end", 245, 7961, 8454);
            CallChecker.varInit(mid, "mid", 245, 7961, 8454);
            CallChecker.varInit(start, "start", 245, 7961, 8454);
            CallChecker.varInit(this.function, "function", 245, 7961, 8454);
            CallChecker.varInit(this.searchStart, "searchStart", 245, 7961, 8454);
            CallChecker.varInit(this.searchMax, "searchMax", 245, 7961, 8454);
            CallChecker.varInit(this.searchMin, "searchMin", 245, 7961, 8454);
            CallChecker.varInit(this.evaluations, "evaluations", 245, 7961, 8454);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 245, 7961, 8454);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 245, 7961, 8454);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 245, 7961, 8454);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 245, 7961, 8454);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 245, 7961, 8454);
            return UnivariateSolverUtils.isSequence(start, mid, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4717.methodEnd();
        }
    }

    protected void verifyInterval(final double lower, final double upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4718 = new MethodContext(void.class, 258, 8461, 8888);
        try {
            CallChecker.varInit(this, "this", 258, 8461, 8888);
            CallChecker.varInit(upper, "upper", 258, 8461, 8888);
            CallChecker.varInit(lower, "lower", 258, 8461, 8888);
            CallChecker.varInit(this.function, "function", 258, 8461, 8888);
            CallChecker.varInit(this.searchStart, "searchStart", 258, 8461, 8888);
            CallChecker.varInit(this.searchMax, "searchMax", 258, 8461, 8888);
            CallChecker.varInit(this.searchMin, "searchMin", 258, 8461, 8888);
            CallChecker.varInit(this.evaluations, "evaluations", 258, 8461, 8888);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 258, 8461, 8888);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 258, 8461, 8888);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 258, 8461, 8888);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 258, 8461, 8888);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 258, 8461, 8888);
            UnivariateSolverUtils.verifyInterval(lower, upper);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4718.methodEnd();
        }
    }

    protected void verifySequence(final double lower, final double initial, final double upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4719 = new MethodContext(void.class, 273, 8895, 9459);
        try {
            CallChecker.varInit(this, "this", 273, 8895, 9459);
            CallChecker.varInit(upper, "upper", 273, 8895, 9459);
            CallChecker.varInit(initial, "initial", 273, 8895, 9459);
            CallChecker.varInit(lower, "lower", 273, 8895, 9459);
            CallChecker.varInit(this.function, "function", 273, 8895, 9459);
            CallChecker.varInit(this.searchStart, "searchStart", 273, 8895, 9459);
            CallChecker.varInit(this.searchMax, "searchMax", 273, 8895, 9459);
            CallChecker.varInit(this.searchMin, "searchMin", 273, 8895, 9459);
            CallChecker.varInit(this.evaluations, "evaluations", 273, 8895, 9459);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 273, 8895, 9459);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 273, 8895, 9459);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 273, 8895, 9459);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 273, 8895, 9459);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 273, 8895, 9459);
            UnivariateSolverUtils.verifySequence(lower, initial, upper);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4719.methodEnd();
        }
    }

    protected void verifyBracketing(final double lower, final double upper) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context4720 = new MethodContext(void.class, 290, 9466, 10104);
        try {
            CallChecker.varInit(this, "this", 290, 9466, 10104);
            CallChecker.varInit(upper, "upper", 290, 9466, 10104);
            CallChecker.varInit(lower, "lower", 290, 9466, 10104);
            CallChecker.varInit(this.function, "function", 290, 9466, 10104);
            CallChecker.varInit(this.searchStart, "searchStart", 290, 9466, 10104);
            CallChecker.varInit(this.searchMax, "searchMax", 290, 9466, 10104);
            CallChecker.varInit(this.searchMin, "searchMin", 290, 9466, 10104);
            CallChecker.varInit(this.evaluations, "evaluations", 290, 9466, 10104);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 290, 9466, 10104);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 290, 9466, 10104);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 290, 9466, 10104);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 290, 9466, 10104);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 290, 9466, 10104);
            UnivariateSolverUtils.verifyBracketing(function, lower, upper);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4720.methodEnd();
        }
    }

    protected void incrementEvaluationCount() throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context4721 = new MethodContext(void.class, 307, 10111, 10838);
        try {
            CallChecker.varInit(this, "this", 307, 10111, 10838);
            CallChecker.varInit(this.function, "function", 307, 10111, 10838);
            CallChecker.varInit(this.searchStart, "searchStart", 307, 10111, 10838);
            CallChecker.varInit(this.searchMax, "searchMax", 307, 10111, 10838);
            CallChecker.varInit(this.searchMin, "searchMin", 307, 10111, 10838);
            CallChecker.varInit(this.evaluations, "evaluations", 307, 10111, 10838);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 307, 10111, 10838);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 307, 10111, 10838);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 307, 10111, 10838);
            CallChecker.varInit(DEFAULT_FUNCTION_VALUE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_FUNCTION_VALUE_ACCURACY", 307, 10111, 10838);
            CallChecker.varInit(DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver.DEFAULT_RELATIVE_ACCURACY", 307, 10111, 10838);
            TryContext _bcornu_try_context_96 = new TryContext(96, BaseAbstractUnivariateSolver.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 310, 10683, 10693)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 310, 10683, 10693).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_96.catchStart(96);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_96.finallyStart(96);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4721.methodEnd();
        }
    }
}

