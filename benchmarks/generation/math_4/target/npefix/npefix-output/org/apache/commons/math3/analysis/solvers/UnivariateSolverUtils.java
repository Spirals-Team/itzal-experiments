package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class UnivariateSolverUtils {
    private UnivariateSolverUtils() {
        ConstructorContext _bcornu_methode_context510 = new ConstructorContext(UnivariateSolverUtils.class, 36, 1427, 1519);
        try {
        } finally {
            _bcornu_methode_context510.methodEnd();
        }
    }

    public static double solve(UnivariateFunction function, double x0, double x1) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context2374 = new MethodContext(double.class, 50, 1526, 2401);
        try {
            CallChecker.varInit(x1, "x1", 50, 1526, 2401);
            CallChecker.varInit(x0, "x0", 50, 1526, 2401);
            CallChecker.varInit(function, "function", 50, 1526, 2401);
            if (function == null) {
                throw new NullArgumentException(LocalizedFormats.FUNCTION);
            }
            final UnivariateSolver solver = CallChecker.varInit(new BrentSolver(), "solver", 56, 2280, 2329);
            if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 57, 2346, 2351)) {
                return CallChecker.isCalled(solver, UnivariateSolver.class, 57, 2346, 2351).solve(Integer.MAX_VALUE, function, x0, x1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2374.methodEnd();
        }
    }

    public static double solve(UnivariateFunction function, double x0, double x1, double absoluteAccuracy) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context2375 = new MethodContext(double.class, 73, 2408, 3452);
        try {
            CallChecker.varInit(absoluteAccuracy, "absoluteAccuracy", 73, 2408, 3452);
            CallChecker.varInit(x1, "x1", 73, 2408, 3452);
            CallChecker.varInit(x0, "x0", 73, 2408, 3452);
            CallChecker.varInit(function, "function", 73, 2408, 3452);
            if (function == null) {
                throw new NullArgumentException(LocalizedFormats.FUNCTION);
            }
            final UnivariateSolver solver = CallChecker.varInit(new BrentSolver(absoluteAccuracy), "solver", 81, 3315, 3380);
            if (CallChecker.beforeDeref(solver, UnivariateSolver.class, 82, 3397, 3402)) {
                return CallChecker.isCalled(solver, UnivariateSolver.class, 82, 3397, 3402).solve(Integer.MAX_VALUE, function, x0, x1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2375.methodEnd();
        }
    }

    public static double forceSide(final int maxEval, final UnivariateFunction f, final BracketedUnivariateSolver<UnivariateFunction> bracketing, final double baseRoot, final double min, final double max, final AllowedSolution allowedSolution) throws NoBracketingException {
        MethodContext _bcornu_methode_context2376 = new MethodContext(double.class, 101, 3459, 7051);
        try {
            CallChecker.varInit(allowedSolution, "allowedSolution", 101, 3459, 7051);
            CallChecker.varInit(max, "max", 101, 3459, 7051);
            CallChecker.varInit(min, "min", 101, 3459, 7051);
            CallChecker.varInit(baseRoot, "baseRoot", 101, 3459, 7051);
            CallChecker.varInit(bracketing, "bracketing", 101, 3459, 7051);
            CallChecker.varInit(f, "f", 101, 3459, 7051);
            CallChecker.varInit(maxEval, "maxEval", 101, 3459, 7051);
            if (allowedSolution == (AllowedSolution.ANY_SIDE)) {
                return baseRoot;
            }
            final double step = CallChecker.varInit(((double) (FastMath.max(CallChecker.isCalled(bracketing, BracketedUnivariateSolver.class, 113, 4995, 5004).getAbsoluteAccuracy(), FastMath.abs((baseRoot * (CallChecker.isCalled(bracketing, BracketedUnivariateSolver.class, 114, 5094, 5103).getRelativeAccuracy())))))), "step", 113, 4904, 5128);
            double xLo = CallChecker.varInit(((double) (FastMath.max(min, (baseRoot - step)))), "xLo", 115, 5138, 5192);
            double fLo = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 116, 5222, 5222)) {
                fLo = CallChecker.isCalled(f, UnivariateFunction.class, 116, 5222, 5222).value(xLo);
                CallChecker.varAssign(fLo, "fLo", 116, 5222, 5222);
            }
            double xHi = CallChecker.varInit(((double) (FastMath.min(max, (baseRoot + step)))), "xHi", 117, 5244, 5298);
            double fHi = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 118, 5328, 5328)) {
                fHi = CallChecker.isCalled(f, UnivariateFunction.class, 118, 5328, 5328).value(xHi);
                CallChecker.varAssign(fHi, "fHi", 118, 5328, 5328);
            }
            int remainingEval = CallChecker.varInit(((int) (maxEval - 2)), "remainingEval", 119, 5350, 5381);
            while (remainingEval > 0) {
                if (((fLo >= 0) && (fHi <= 0)) || ((fLo <= 0) && (fHi >= 0))) {
                    if (CallChecker.beforeDeref(bracketing, BracketedUnivariateSolver.class, 124, 5568, 5577)) {
                        return CallChecker.isCalled(bracketing, BracketedUnivariateSolver.class, 124, 5568, 5577).solve(remainingEval, f, xLo, xHi, baseRoot, allowedSolution);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                boolean changeLo = CallChecker.varInit(((boolean) (false)), "changeLo", 128, 5711, 5735);
                boolean changeHi = CallChecker.varInit(((boolean) (false)), "changeHi", 129, 5749, 5773);
                if (fLo < fHi) {
                    if (fLo >= 0) {
                        changeLo = true;
                        CallChecker.varAssign(changeLo, "changeLo", 133, 5895, 5910);
                    }else {
                        changeHi = true;
                        CallChecker.varAssign(changeHi, "changeHi", 135, 5957, 5972);
                    }
                }else
                    if (fLo > fHi) {
                        if (fLo <= 0) {
                            changeLo = true;
                            CallChecker.varAssign(changeLo, "changeLo", 140, 6119, 6134);
                        }else {
                            changeHi = true;
                            CallChecker.varAssign(changeHi, "changeHi", 142, 6181, 6196);
                        }
                    }else {
                        changeLo = true;
                        CallChecker.varAssign(changeLo, "changeLo", 146, 6290, 6305);
                        changeHi = true;
                        CallChecker.varAssign(changeHi, "changeHi", 147, 6323, 6338);
                    }
                
                if (changeLo) {
                    xLo = FastMath.max(min, (xLo - step));
                    CallChecker.varAssign(xLo, "xLo", 152, 6437, 6472);
                    if (CallChecker.beforeDeref(f, UnivariateFunction.class, 153, 6497, 6497)) {
                        fLo = CallChecker.isCalled(f, UnivariateFunction.class, 153, 6497, 6497).value(xLo);
                        CallChecker.varAssign(fLo, "fLo", 153, 6490, 6509);
                    }
                    remainingEval--;
                }
                if (changeHi) {
                    xHi = FastMath.min(max, (xHi + step));
                    CallChecker.varAssign(xHi, "xHi", 159, 6642, 6677);
                    if (CallChecker.beforeDeref(f, UnivariateFunction.class, 160, 6702, 6702)) {
                        fHi = CallChecker.isCalled(f, UnivariateFunction.class, 160, 6702, 6702).value(xHi);
                        CallChecker.varAssign(fHi, "fHi", 160, 6695, 6714);
                    }
                    remainingEval--;
                }
            } 
            throw new NoBracketingException(LocalizedFormats.FAILED_BRACKETING, xLo, xHi, fLo, fHi, (maxEval - remainingEval), maxEval, baseRoot, min, max);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2376.methodEnd();
        }
    }

    public static double[] bracket(UnivariateFunction function, double initial, double lowerBound, double upperBound) throws NoBracketingException, NotStrictlyPositiveException, NullArgumentException {
        MethodContext _bcornu_methode_context2377 = new MethodContext(double[].class, 212, 7058, 9445);
        try {
            CallChecker.varInit(upperBound, "upperBound", 212, 7058, 9445);
            CallChecker.varInit(lowerBound, "lowerBound", 212, 7058, 9445);
            CallChecker.varInit(initial, "initial", 212, 7058, 9445);
            CallChecker.varInit(function, "function", 212, 7058, 9445);
            return UnivariateSolverUtils.bracket(function, initial, lowerBound, upperBound, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2377.methodEnd();
        }
    }

    public static double[] bracket(UnivariateFunction function, double initial, double lowerBound, double upperBound, int maximumIterations) throws NoBracketingException, NotStrictlyPositiveException, NullArgumentException {
        MethodContext _bcornu_methode_context2378 = new MethodContext(double[].class, 253, 9453, 12634);
        try {
            CallChecker.varInit(maximumIterations, "maximumIterations", 253, 9453, 12634);
            CallChecker.varInit(upperBound, "upperBound", 253, 9453, 12634);
            CallChecker.varInit(lowerBound, "lowerBound", 253, 9453, 12634);
            CallChecker.varInit(initial, "initial", 253, 9453, 12634);
            CallChecker.varInit(function, "function", 253, 9453, 12634);
            if (function == null) {
                throw new NullArgumentException(LocalizedFormats.FUNCTION);
            }
            if (maximumIterations <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.INVALID_MAX_ITERATIONS, maximumIterations);
            }
            UnivariateSolverUtils.verifySequence(lowerBound, initial, upperBound);
            double a = CallChecker.varInit(((double) (initial)), "a", 268, 11792, 11810);
            double b = CallChecker.varInit(((double) (initial)), "b", 269, 11820, 11838);
            double fa = CallChecker.init(double.class);
            double fb = CallChecker.init(double.class);
            int numIterations = CallChecker.varInit(((int) (0)), "numIterations", 272, 11886, 11907);
            do {
                a = FastMath.max((a - 1.0), lowerBound);
                CallChecker.varAssign(a, "a", 275, 11935, 11972);
                b = FastMath.min((b + 1.0), upperBound);
                CallChecker.varAssign(b, "b", 276, 11986, 12023);
                fa = function.value(a);
                CallChecker.varAssign(fa, "fa", 277, 12037, 12059);
                fb = function.value(b);
                CallChecker.varAssign(fb, "fb", 279, 12074, 12096);
                ++numIterations;
            } while ((((fa * fb) > 0.0) && (numIterations < maximumIterations)) && ((a > lowerBound) || (b < upperBound)) );
            if ((fa * fb) > 0.0) {
                throw new NoBracketingException(LocalizedFormats.FAILED_BRACKETING, a, b, fa, fb, numIterations, maximumIterations, initial, lowerBound, upperBound);
            }
            return new double[]{ a , b };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2378.methodEnd();
        }
    }

    public static double midpoint(double a, double b) {
        MethodContext _bcornu_methode_context2379 = new MethodContext(double.class, 301, 12641, 12881);
        try {
            CallChecker.varInit(b, "b", 301, 12641, 12881);
            CallChecker.varInit(a, "a", 301, 12641, 12881);
            return (a + b) * 0.5;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2379.methodEnd();
        }
    }

    public static boolean isBracketing(UnivariateFunction function, final double lower, final double upper) throws NullArgumentException {
        MethodContext _bcornu_methode_context2380 = new MethodContext(boolean.class, 317, 12888, 13884);
        try {
            CallChecker.varInit(upper, "upper", 317, 12888, 13884);
            CallChecker.varInit(lower, "lower", 317, 12888, 13884);
            CallChecker.varInit(function, "function", 317, 12888, 13884);
            if (function == null) {
                throw new NullArgumentException(LocalizedFormats.FUNCTION);
            }
            final double fLo = CallChecker.varInit(((double) (function.value(lower))), "fLo", 324, 13723, 13763);
            final double fHi = CallChecker.varInit(((double) (function.value(upper))), "fHi", 325, 13773, 13813);
            return ((fLo >= 0) && (fHi <= 0)) || ((fLo <= 0) && (fHi >= 0));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2380.methodEnd();
        }
    }

    public static boolean isSequence(final double start, final double mid, final double end) {
        MethodContext _bcornu_methode_context2381 = new MethodContext(boolean.class, 337, 13891, 14375);
        try {
            CallChecker.varInit(end, "end", 337, 13891, 14375);
            CallChecker.varInit(mid, "mid", 337, 13891, 14375);
            CallChecker.varInit(start, "start", 337, 13891, 14375);
            return (start < mid) && (mid < end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2381.methodEnd();
        }
    }

    public static void verifyInterval(final double lower, final double upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context2382 = new MethodContext(void.class, 350, 14382, 14959);
        try {
            CallChecker.varInit(upper, "upper", 350, 14382, 14959);
            CallChecker.varInit(lower, "lower", 350, 14382, 14959);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, lower, upper, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2382.methodEnd();
        }
    }

    public static void verifySequence(final double lower, final double initial, final double upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context2383 = new MethodContext(void.class, 368, 14966, 15553);
        try {
            CallChecker.varInit(upper, "upper", 368, 14966, 15553);
            CallChecker.varInit(initial, "initial", 368, 14966, 15553);
            CallChecker.varInit(lower, "lower", 368, 14966, 15553);
            UnivariateSolverUtils.verifyInterval(lower, initial);
            UnivariateSolverUtils.verifyInterval(initial, upper);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2383.methodEnd();
        }
    }

    public static void verifyBracketing(UnivariateFunction function, final double lower, final double upper) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context2384 = new MethodContext(void.class, 387, 15560, 16626);
        try {
            CallChecker.varInit(upper, "upper", 387, 15560, 16626);
            CallChecker.varInit(lower, "lower", 387, 15560, 16626);
            CallChecker.varInit(function, "function", 387, 15560, 16626);
            if (function == null) {
                throw new NullArgumentException(LocalizedFormats.FUNCTION);
            }
            UnivariateSolverUtils.verifyInterval(lower, upper);
            if (!(UnivariateSolverUtils.isBracketing(function, lower, upper))) {
                throw new NoBracketingException(lower, upper, function.value(lower), function.value(upper));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2384.methodEnd();
        }
    }
}

