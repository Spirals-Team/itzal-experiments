package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.util.FastMath;

public abstract class BaseSecantSolver extends AbstractUnivariateSolver implements BracketedUnivariateSolver<UnivariateFunction> {
    protected enum Method {
REGULA_FALSI, ILLINOIS, PEGASUS;    }

    protected static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    private AllowedSolution allowed;

    private final BaseSecantSolver.Method method;

    protected BaseSecantSolver(final double absoluteAccuracy, final BaseSecantSolver.Method method) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context636 = new ConstructorContext(BaseSecantSolver.class, 68, 2563, 2931);
        try {
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 70, 2856, 2895);
            this.method = method;
            CallChecker.varAssign(this.method, "this.method", 71, 2905, 2925);
        } finally {
            _bcornu_methode_context636.methodEnd();
        }
    }

    protected BaseSecantSolver(final double relativeAccuracy, final double absoluteAccuracy, final BaseSecantSolver.Method method) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context637 = new ConstructorContext(BaseSecantSolver.class, 81, 2938, 3467);
        try {
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 85, 3392, 3431);
            this.method = method;
            CallChecker.varAssign(this.method, "this.method", 86, 3441, 3461);
        } finally {
            _bcornu_methode_context637.methodEnd();
        }
    }

    protected BaseSecantSolver(final double relativeAccuracy, final double absoluteAccuracy, final double functionValueAccuracy, final BaseSecantSolver.Method method) {
        super(relativeAccuracy, absoluteAccuracy, functionValueAccuracy);
        ConstructorContext _bcornu_methode_context638 = new ConstructorContext(BaseSecantSolver.class, 97, 3474, 4168);
        try {
            this.allowed = AllowedSolution.ANY_SIDE;
            CallChecker.varAssign(this.allowed, "this.allowed", 102, 4093, 4132);
            this.method = method;
            CallChecker.varAssign(this.method, "this.method", 103, 4142, 4162);
        } finally {
            _bcornu_methode_context638.methodEnd();
        }
    }

    public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final AllowedSolution allowedSolution) {
        MethodContext _bcornu_methode_context2800 = new MethodContext(double.class, 107, 4175, 4482);
        try {
            CallChecker.varInit(this, "this", 107, 4175, 4482);
            CallChecker.varInit(allowedSolution, "allowedSolution", 107, 4175, 4482);
            CallChecker.varInit(max, "max", 107, 4175, 4482);
            CallChecker.varInit(min, "min", 107, 4175, 4482);
            CallChecker.varInit(f, "f", 107, 4175, 4482);
            CallChecker.varInit(maxEval, "maxEval", 107, 4175, 4482);
            CallChecker.varInit(this.method, "method", 107, 4175, 4482);
            CallChecker.varInit(this.allowed, "allowed", 107, 4175, 4482);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY", 107, 4175, 4482);
            return solve(maxEval, f, min, max, (min + (0.5 * (max - min))), allowedSolution);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2800.methodEnd();
        }
    }

    public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final double startValue, final AllowedSolution allowedSolution) {
        MethodContext _bcornu_methode_context2801 = new MethodContext(double.class, 114, 4489, 4837);
        try {
            CallChecker.varInit(this, "this", 114, 4489, 4837);
            CallChecker.varInit(allowedSolution, "allowedSolution", 114, 4489, 4837);
            CallChecker.varInit(startValue, "startValue", 114, 4489, 4837);
            CallChecker.varInit(max, "max", 114, 4489, 4837);
            CallChecker.varInit(min, "min", 114, 4489, 4837);
            CallChecker.varInit(f, "f", 114, 4489, 4837);
            CallChecker.varInit(maxEval, "maxEval", 114, 4489, 4837);
            CallChecker.varInit(this.method, "method", 114, 4489, 4837);
            CallChecker.varInit(this.allowed, "allowed", 114, 4489, 4837);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY", 114, 4489, 4837);
            this.allowed = allowedSolution;
            CallChecker.varAssign(this.allowed, "this.allowed", 117, 4739, 4769);
            return super.solve(maxEval, f, min, max, startValue);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2801.methodEnd();
        }
    }

    @Override
    public double solve(final int maxEval, final UnivariateFunction f, final double min, final double max, final double startValue) {
        MethodContext _bcornu_methode_context2802 = new MethodContext(double.class, 123, 4844, 5123);
        try {
            CallChecker.varInit(this, "this", 123, 4844, 5123);
            CallChecker.varInit(startValue, "startValue", 123, 4844, 5123);
            CallChecker.varInit(max, "max", 123, 4844, 5123);
            CallChecker.varInit(min, "min", 123, 4844, 5123);
            CallChecker.varInit(f, "f", 123, 4844, 5123);
            CallChecker.varInit(maxEval, "maxEval", 123, 4844, 5123);
            CallChecker.varInit(this.method, "method", 123, 4844, 5123);
            CallChecker.varInit(this.allowed, "allowed", 123, 4844, 5123);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY", 123, 4844, 5123);
            return solve(maxEval, f, min, max, startValue, AllowedSolution.ANY_SIDE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2802.methodEnd();
        }
    }

    @Override
    protected final double doSolve() throws ConvergenceException {
        MethodContext _bcornu_methode_context2803 = new MethodContext(double.class, 135, 5130, 9804);
        try {
            CallChecker.varInit(this, "this", 135, 5130, 9804);
            CallChecker.varInit(this.method, "method", 135, 5130, 9804);
            CallChecker.varInit(this.allowed, "allowed", 135, 5130, 9804);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.BaseSecantSolver.DEFAULT_ABSOLUTE_ACCURACY", 135, 5130, 9804);
            double x0 = CallChecker.varInit(((double) (getMin())), "x0", 138, 5391, 5411);
            double x1 = CallChecker.varInit(((double) (getMax())), "x1", 139, 5421, 5441);
            double f0 = CallChecker.varInit(((double) (computeObjectiveValue(x0))), "f0", 140, 5451, 5488);
            double f1 = CallChecker.varInit(((double) (computeObjectiveValue(x1))), "f1", 141, 5498, 5535);
            if (f0 == 0.0) {
                return x0;
            }
            if (f1 == 0.0) {
                return x1;
            }
            verifyBracketing(x0, x1);
            final double ftol = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "ftol", 157, 5953, 6026);
            final double atol = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "atol", 158, 6036, 6077);
            final double rtol = CallChecker.varInit(((double) (getRelativeAccuracy())), "rtol", 159, 6087, 6128);
            boolean inverted = CallChecker.varInit(((boolean) (false)), "inverted", 163, 6255, 6279);
            while (true) {
                final double x = CallChecker.varInit(((double) (x1 - ((f1 * (x1 - x0)) / (f1 - f0)))), "x", 168, 6364, 6465);
                final double fx = CallChecker.varInit(((double) (computeObjectiveValue(x))), "fx", 169, 6479, 6521);
                if (fx == 0.0) {
                    return x;
                }
                if ((f1 * fx) < 0) {
                    x0 = x1;
                    CallChecker.varAssign(x0, "x0", 182, 7039, 7046);
                    f0 = f1;
                    CallChecker.varAssign(f0, "f0", 183, 7064, 7071);
                    inverted = !inverted;
                    CallChecker.varAssign(inverted, "inverted", 184, 7089, 7109);
                }else {
                    switch (method) {
                        case ILLINOIS :
                            f0 *= 0.5;
                            CallChecker.varAssign(f0, "f0", 188, 7217, 7226);
                            break;
                        case PEGASUS :
                            f0 *= f1 / (f1 + fx);
                            CallChecker.varAssign(f0, "f0", 191, 7305, 7325);
                            break;
                        case REGULA_FALSI :
                            if (x == x1) {
                                throw new ConvergenceException();
                            }
                            break;
                        default :
                            throw new MathInternalError();
                    }
                }
                x1 = x;
                CallChecker.varAssign(x1, "x1", 206, 7899, 7905);
                f1 = fx;
                CallChecker.varAssign(f1, "f1", 207, 7919, 7926);
                if ((FastMath.abs(f1)) <= ftol) {
                    switch (allowed) {
                        case ANY_SIDE :
                            return x1;
                        case LEFT_SIDE :
                            if (inverted) {
                                return x1;
                            }
                            break;
                        case RIGHT_SIDE :
                            if (!inverted) {
                                return x1;
                            }
                            break;
                        case BELOW_SIDE :
                            if (f1 <= 0) {
                                return x1;
                            }
                            break;
                        case ABOVE_SIDE :
                            if (f1 >= 0) {
                                return x1;
                            }
                            break;
                        default :
                            throw new MathInternalError();
                    }
                }
                if ((FastMath.abs((x1 - x0))) < (FastMath.max((rtol * (FastMath.abs(x1))), atol))) {
                    switch (allowed) {
                        case ANY_SIDE :
                            return x1;
                        case LEFT_SIDE :
                            if (inverted) {
                                return x1;
                            }else {
                                return x0;
                            }
                        case RIGHT_SIDE :
                            if (inverted) {
                                return x0;
                            }else {
                                return x1;
                            }
                        case BELOW_SIDE :
                            if (f1 <= 0) {
                                return x1;
                            }else {
                                return x0;
                            }
                        case ABOVE_SIDE :
                            if (f1 >= 0) {
                                return x1;
                            }else {
                                return x0;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2803.methodEnd();
        }
    }
}

