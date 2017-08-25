package org.apache.commons.math3.dfp;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.MathUtils;

public class BracketingNthOrderBrentSolverDFP {
    private static final int MAXIMAL_AGING = 2;

    private final int maximalOrder;

    private final Dfp functionValueAccuracy;

    private final Dfp absoluteAccuracy;

    private final Dfp relativeAccuracy;

    private final Incrementor evaluations = new Incrementor();

    public BracketingNthOrderBrentSolverDFP(final Dfp relativeAccuracy, final Dfp absoluteAccuracy, final Dfp functionValueAccuracy, final int maximalOrder) throws NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context76 = new ConstructorContext(BracketingNthOrderBrentSolverDFP.class, 73, 2391, 3369);
        try {
            if (maximalOrder < 2) {
                throw new NumberIsTooSmallException(maximalOrder, 2, true);
            }
            this.maximalOrder = maximalOrder;
            CallChecker.varAssign(this.maximalOrder, "this.maximalOrder", 81, 3171, 3203);
            this.absoluteAccuracy = absoluteAccuracy;
            CallChecker.varAssign(this.absoluteAccuracy, "this.absoluteAccuracy", 82, 3213, 3253);
            this.relativeAccuracy = relativeAccuracy;
            CallChecker.varAssign(this.relativeAccuracy, "this.relativeAccuracy", 83, 3263, 3303);
            this.functionValueAccuracy = functionValueAccuracy;
            CallChecker.varAssign(this.functionValueAccuracy, "this.functionValueAccuracy", 84, 3313, 3363);
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public int getMaximalOrder() {
        MethodContext _bcornu_methode_context308 = new MethodContext(int.class, 90, 3376, 3508);
        try {
            CallChecker.varInit(this, "this", 90, 3376, 3508);
            CallChecker.varInit(this.evaluations, "evaluations", 90, 3376, 3508);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 90, 3376, 3508);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 90, 3376, 3508);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 90, 3376, 3508);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 90, 3376, 3508);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 90, 3376, 3508);
            return maximalOrder;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context308.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context309 = new MethodContext(int.class, 99, 3515, 3735);
        try {
            CallChecker.varInit(this, "this", 99, 3515, 3735);
            CallChecker.varInit(this.evaluations, "evaluations", 99, 3515, 3735);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 99, 3515, 3735);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 99, 3515, 3735);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 99, 3515, 3735);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 99, 3515, 3735);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 99, 3515, 3735);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 100, 3700, 3710)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 100, 3700, 3710).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context309.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context310 = new MethodContext(int.class, 111, 3742, 4125);
        try {
            CallChecker.varInit(this, "this", 111, 3742, 4125);
            CallChecker.varInit(this.evaluations, "evaluations", 111, 3742, 4125);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 111, 3742, 4125);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 111, 3742, 4125);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 111, 3742, 4125);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 111, 3742, 4125);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 111, 3742, 4125);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 112, 4097, 4107)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 112, 4097, 4107).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context310.methodEnd();
        }
    }

    public Dfp getAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context311 = new MethodContext(Dfp.class, 119, 4132, 4287);
        try {
            CallChecker.varInit(this, "this", 119, 4132, 4287);
            CallChecker.varInit(this.evaluations, "evaluations", 119, 4132, 4287);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 119, 4132, 4287);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 119, 4132, 4287);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 119, 4132, 4287);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 119, 4132, 4287);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 119, 4132, 4287);
            return absoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context311.methodEnd();
        }
    }

    public Dfp getRelativeAccuracy() {
        MethodContext _bcornu_methode_context312 = new MethodContext(Dfp.class, 127, 4294, 4449);
        try {
            CallChecker.varInit(this, "this", 127, 4294, 4449);
            CallChecker.varInit(this.evaluations, "evaluations", 127, 4294, 4449);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 127, 4294, 4449);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 127, 4294, 4449);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 127, 4294, 4449);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 127, 4294, 4449);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 127, 4294, 4449);
            return relativeAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context312.methodEnd();
        }
    }

    public Dfp getFunctionValueAccuracy() {
        MethodContext _bcornu_methode_context313 = new MethodContext(Dfp.class, 135, 4456, 4621);
        try {
            CallChecker.varInit(this, "this", 135, 4456, 4621);
            CallChecker.varInit(this.evaluations, "evaluations", 135, 4456, 4621);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 135, 4456, 4621);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 135, 4456, 4621);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 135, 4456, 4621);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 135, 4456, 4621);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 135, 4456, 4621);
            return functionValueAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context313.methodEnd();
        }
    }

    public Dfp solve(final int maxEval, final UnivariateDfpFunction f, final Dfp min, final Dfp max, final AllowedSolution allowedSolution) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context314 = new MethodContext(Dfp.class, 155, 4628, 5682);
        try {
            CallChecker.varInit(this, "this", 155, 4628, 5682);
            CallChecker.varInit(allowedSolution, "allowedSolution", 155, 4628, 5682);
            CallChecker.varInit(max, "max", 155, 4628, 5682);
            CallChecker.varInit(min, "min", 155, 4628, 5682);
            CallChecker.varInit(f, "f", 155, 4628, 5682);
            CallChecker.varInit(maxEval, "maxEval", 155, 4628, 5682);
            CallChecker.varInit(this.evaluations, "evaluations", 155, 4628, 5682);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 155, 4628, 5682);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 155, 4628, 5682);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 155, 4628, 5682);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 155, 4628, 5682);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 155, 4628, 5682);
            if (CallChecker.beforeDeref(min, Dfp.class, 158, 5636, 5638)) {
                final Dfp npe_invocation_var34 = CallChecker.isCalled(min, Dfp.class, 158, 5636, 5638).add(max);
                if (CallChecker.beforeDeref(npe_invocation_var34, Dfp.class, 158, 5636, 5647)) {
                    return solve(maxEval, f, min, max, CallChecker.isCalled(npe_invocation_var34, Dfp.class, 158, 5636, 5647).divide(2), allowedSolution);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context314.methodEnd();
        }
    }

    public Dfp solve(final int maxEval, final UnivariateDfpFunction f, final Dfp min, final Dfp max, final Dfp startValue, final AllowedSolution allowedSolution) throws NoBracketingException, NullArgumentException {
        MethodContext _bcornu_methode_context315 = new MethodContext(Dfp.class, 178, 5689, 14819);
        try {
            CallChecker.varInit(this, "this", 178, 5689, 14819);
            CallChecker.varInit(allowedSolution, "allowedSolution", 178, 5689, 14819);
            CallChecker.varInit(startValue, "startValue", 178, 5689, 14819);
            CallChecker.varInit(max, "max", 178, 5689, 14819);
            CallChecker.varInit(min, "min", 178, 5689, 14819);
            CallChecker.varInit(f, "f", 178, 5689, 14819);
            CallChecker.varInit(maxEval, "maxEval", 178, 5689, 14819);
            CallChecker.varInit(this.evaluations, "evaluations", 178, 5689, 14819);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 178, 5689, 14819);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 178, 5689, 14819);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 178, 5689, 14819);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 178, 5689, 14819);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 178, 5689, 14819);
            MathUtils.checkNotNull(f);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 187, 6853, 6863)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 187, 6853, 6863).setMaximalCount(maxEval);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 188, 6899, 6909)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 188, 6899, 6909).resetCount();
            }
            Dfp zero = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(startValue, Dfp.class, 189, 6944, 6953)) {
                zero = CallChecker.isCalled(startValue, Dfp.class, 189, 6944, 6953).getZero();
                CallChecker.varAssign(zero, "zero", 189, 6944, 6953);
            }
            Dfp nan = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(zero, Dfp.class, 190, 6985, 6988)) {
                zero = CallChecker.beforeCalled(zero, Dfp.class, 190, 6985, 6988);
                nan = CallChecker.isCalled(zero, Dfp.class, 190, 6985, 6988).newInstance(((byte) (1)), Dfp.QNAN);
                CallChecker.varAssign(nan, "nan", 190, 6985, 6988);
            }
            final Dfp[] x = CallChecker.varInit(new Dfp[(maximalOrder) + 1], "x", 193, 7080, 7121);
            final Dfp[] y = CallChecker.varInit(new Dfp[(maximalOrder) + 1], "y", 194, 7131, 7172);
            if (CallChecker.beforeDeref(x, Dfp[].class, 195, 7182, 7182)) {
                CallChecker.isCalled(x, Dfp[].class, 195, 7182, 7182)[0] = min;
                CallChecker.varAssign(CallChecker.isCalled(x, Dfp[].class, 195, 7182, 7182)[0], "CallChecker.isCalled(x, Dfp[].class, 195, 7182, 7182)[0]", 195, 7182, 7192);
            }
            if (CallChecker.beforeDeref(x, Dfp[].class, 196, 7202, 7202)) {
                CallChecker.isCalled(x, Dfp[].class, 196, 7202, 7202)[1] = startValue;
                CallChecker.varAssign(CallChecker.isCalled(x, Dfp[].class, 196, 7202, 7202)[1], "CallChecker.isCalled(x, Dfp[].class, 196, 7202, 7202)[1]", 196, 7202, 7219);
            }
            if (CallChecker.beforeDeref(x, Dfp[].class, 197, 7229, 7229)) {
                CallChecker.isCalled(x, Dfp[].class, 197, 7229, 7229)[2] = max;
                CallChecker.varAssign(CallChecker.isCalled(x, Dfp[].class, 197, 7229, 7229)[2], "CallChecker.isCalled(x, Dfp[].class, 197, 7229, 7229)[2]", 197, 7229, 7239);
            }
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 200, 7284, 7294)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 200, 7284, 7294).incrementCount();
            }
            if (CallChecker.beforeDeref(y, Dfp[].class, 201, 7322, 7322)) {
                if (CallChecker.beforeDeref(x, Dfp[].class, 201, 7337, 7337)) {
                    if (CallChecker.beforeDeref(f, UnivariateDfpFunction.class, 201, 7329, 7329)) {
                        CallChecker.isCalled(y, Dfp[].class, 201, 7322, 7322)[1] = CallChecker.isCalled(f, UnivariateDfpFunction.class, 201, 7329, 7329).value(CallChecker.isCalled(x, Dfp[].class, 201, 7337, 7337)[1]);
                        CallChecker.varAssign(CallChecker.isCalled(y, Dfp[].class, 201, 7322, 7322)[1], "CallChecker.isCalled(y, Dfp[].class, 201, 7322, 7322)[1]", 201, 7322, 7342);
                    }
                }
            }
            if (CallChecker.beforeDeref(y, Dfp[].class, 202, 7356, 7356)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 202, 7356, 7356)[1], Dfp.class, 202, 7356, 7359)) {
                    CallChecker.isCalled(y, Dfp[].class, 202, 7356, 7356)[1] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 202, 7356, 7356)[1], Dfp.class, 202, 7356, 7359);
                    if (CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 202, 7356, 7356)[1], Dfp.class, 202, 7356, 7359).isZero()) {
                        if (CallChecker.beforeDeref(x, Dfp[].class, 204, 7457, 7457)) {
                            return CallChecker.isCalled(x, Dfp[].class, 204, 7457, 7457)[1];
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 208, 7518, 7528)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 208, 7518, 7528).incrementCount();
            }
            if (CallChecker.beforeDeref(y, Dfp[].class, 209, 7556, 7556)) {
                if (CallChecker.beforeDeref(x, Dfp[].class, 209, 7571, 7571)) {
                    if (CallChecker.beforeDeref(f, UnivariateDfpFunction.class, 209, 7563, 7563)) {
                        CallChecker.isCalled(y, Dfp[].class, 209, 7556, 7556)[0] = CallChecker.isCalled(f, UnivariateDfpFunction.class, 209, 7563, 7563).value(CallChecker.isCalled(x, Dfp[].class, 209, 7571, 7571)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(y, Dfp[].class, 209, 7556, 7556)[0], "CallChecker.isCalled(y, Dfp[].class, 209, 7556, 7556)[0]", 209, 7556, 7576);
                    }
                }
            }
            if (CallChecker.beforeDeref(y, Dfp[].class, 210, 7590, 7590)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 210, 7590, 7590)[0], Dfp.class, 210, 7590, 7593)) {
                    CallChecker.isCalled(y, Dfp[].class, 210, 7590, 7590)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 210, 7590, 7590)[0], Dfp.class, 210, 7590, 7593);
                    if (CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 210, 7590, 7590)[0], Dfp.class, 210, 7590, 7593).isZero()) {
                        if (CallChecker.beforeDeref(x, Dfp[].class, 212, 7692, 7692)) {
                            return CallChecker.isCalled(x, Dfp[].class, 212, 7692, 7692)[0];
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int nbPoints = CallChecker.init(int.class);
            int signChangeIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(y, Dfp[].class, 217, 7772, 7772)) {
                if (CallChecker.beforeDeref(y, Dfp[].class, 217, 7786, 7786)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 217, 7772, 7772)[0], Dfp.class, 217, 7772, 7775)) {
                        CallChecker.isCalled(y, Dfp[].class, 217, 7772, 7772)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 217, 7772, 7772)[0], Dfp.class, 217, 7772, 7775);
                        final Dfp npe_invocation_var35 = CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 217, 7772, 7772)[0], Dfp.class, 217, 7772, 7775).multiply(CallChecker.isCalled(y, Dfp[].class, 217, 7786, 7786)[1]);
                        if (CallChecker.beforeDeref(npe_invocation_var35, Dfp.class, 217, 7772, 7790)) {
                            if (CallChecker.isCalled(npe_invocation_var35, Dfp.class, 217, 7772, 7790).negativeOrNull()) {
                                nbPoints = 2;
                                CallChecker.varAssign(nbPoints, "nbPoints", 220, 7880, 7899);
                                signChangeIndex = 1;
                                CallChecker.varAssign(signChangeIndex, "signChangeIndex", 221, 7913, 7932);
                            }else {
                                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 226, 8005, 8015)) {
                                    CallChecker.isCalled(evaluations, Incrementor.class, 226, 8005, 8015).incrementCount();
                                }
                                if (CallChecker.beforeDeref(y, Dfp[].class, 227, 8047, 8047)) {
                                    if (CallChecker.beforeDeref(x, Dfp[].class, 227, 8062, 8062)) {
                                        if (CallChecker.beforeDeref(f, UnivariateDfpFunction.class, 227, 8054, 8054)) {
                                            CallChecker.isCalled(y, Dfp[].class, 227, 8047, 8047)[2] = CallChecker.isCalled(f, UnivariateDfpFunction.class, 227, 8054, 8054).value(CallChecker.isCalled(x, Dfp[].class, 227, 8062, 8062)[2]);
                                            CallChecker.varAssign(CallChecker.isCalled(y, Dfp[].class, 227, 8047, 8047)[2], "CallChecker.isCalled(y, Dfp[].class, 227, 8047, 8047)[2]", 227, 8047, 8067);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(y, Dfp[].class, 228, 8085, 8085)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 228, 8085, 8085)[2], Dfp.class, 228, 8085, 8088)) {
                                        CallChecker.isCalled(y, Dfp[].class, 228, 8085, 8085)[2] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 228, 8085, 8085)[2], Dfp.class, 228, 8085, 8088);
                                        if (CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 228, 8085, 8085)[2], Dfp.class, 228, 8085, 8088).isZero()) {
                                            if (CallChecker.beforeDeref(x, Dfp[].class, 230, 8196, 8196)) {
                                                return CallChecker.isCalled(x, Dfp[].class, 230, 8196, 8196)[2];
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(y, Dfp[].class, 233, 8233, 8233)) {
                                    if (CallChecker.beforeDeref(y, Dfp[].class, 233, 8247, 8247)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 233, 8233, 8233)[1], Dfp.class, 233, 8233, 8236)) {
                                            CallChecker.isCalled(y, Dfp[].class, 233, 8233, 8233)[1] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 233, 8233, 8233)[1], Dfp.class, 233, 8233, 8236);
                                            final Dfp npe_invocation_var36 = CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 233, 8233, 8233)[1], Dfp.class, 233, 8233, 8236).multiply(CallChecker.isCalled(y, Dfp[].class, 233, 8247, 8247)[2]);
                                            if (CallChecker.beforeDeref(npe_invocation_var36, Dfp.class, 233, 8233, 8251)) {
                                                if (CallChecker.isCalled(npe_invocation_var36, Dfp.class, 233, 8233, 8251).negativeOrNull()) {
                                                    nbPoints = 3;
                                                    CallChecker.varAssign(nbPoints, "nbPoints", 235, 8369, 8388);
                                                    signChangeIndex = 2;
                                                    CallChecker.varAssign(signChangeIndex, "signChangeIndex", 236, 8406, 8425);
                                                }else {
                                                    if (CallChecker.beforeDeref(x, Dfp[].class, 238, 8496, 8496)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp[].class, 238, 8496, 8496)[0], Dfp.class, 238, 8496, 8499)) {
                                                            if (CallChecker.beforeDeref(x, Dfp[].class, 238, 8513, 8513)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp[].class, 238, 8513, 8513)[2], Dfp.class, 238, 8513, 8516)) {
                                                                    if (CallChecker.beforeDeref(y, Dfp[].class, 239, 8578, 8578)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 239, 8578, 8578)[0], Dfp.class, 239, 8578, 8581)) {
                                                                            if (CallChecker.beforeDeref(y, Dfp[].class, 239, 8595, 8595)) {
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 239, 8595, 8595)[2], Dfp.class, 239, 8595, 8598)) {
                                                                                    CallChecker.isCalled(x, Dfp[].class, 238, 8496, 8496)[0] = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp[].class, 238, 8496, 8496)[0], Dfp.class, 238, 8496, 8499);
                                                                                    CallChecker.isCalled(x, Dfp[].class, 238, 8513, 8513)[2] = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp[].class, 238, 8513, 8513)[2], Dfp.class, 238, 8513, 8516);
                                                                                    CallChecker.isCalled(y, Dfp[].class, 239, 8578, 8578)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 239, 8578, 8578)[0], Dfp.class, 239, 8578, 8581);
                                                                                    CallChecker.isCalled(y, Dfp[].class, 239, 8595, 8595)[2] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 239, 8595, 8595)[2], Dfp.class, 239, 8595, 8598);
                                                                                    throw new NoBracketingException(CallChecker.isCalled(CallChecker.isCalled(x, Dfp[].class, 238, 8496, 8496)[0], Dfp.class, 238, 8496, 8499).toDouble(), CallChecker.isCalled(CallChecker.isCalled(x, Dfp[].class, 238, 8513, 8513)[2], Dfp.class, 238, 8513, 8516).toDouble(), CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 239, 8578, 8578)[0], Dfp.class, 239, 8578, 8581).toDouble(), CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 239, 8595, 8595)[2], Dfp.class, 239, 8595, 8598).toDouble());
                                                                                }else
                                                                                    throw new AbnormalExecutionError();
                                                                                
                                                                            }else
                                                                                throw new AbnormalExecutionError();
                                                                            
                                                                        }else
                                                                            throw new AbnormalExecutionError();
                                                                        
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final Dfp[] tmpX = CallChecker.varInit(new Dfp[CallChecker.isCalled(x, Dfp[].class, 245, 8743, 8743).length], "tmpX", 245, 8716, 8752);
            Dfp xA = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(x, Dfp[].class, 248, 8826, 8826)) {
                xA = CallChecker.isCalled(x, Dfp[].class, 248, 8826, 8826)[(signChangeIndex - 1)];
                CallChecker.varAssign(xA, "xA", 248, 8826, 8826);
            }
            Dfp yA = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(y, Dfp[].class, 249, 8870, 8870)) {
                yA = CallChecker.isCalled(y, Dfp[].class, 249, 8870, 8870)[(signChangeIndex - 1)];
                CallChecker.varAssign(yA, "yA", 249, 8870, 8870);
            }
            Dfp absXA = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(xA, Dfp.class, 250, 8914, 8915)) {
                xA = CallChecker.beforeCalled(xA, Dfp.class, 250, 8914, 8915);
                absXA = CallChecker.isCalled(xA, Dfp.class, 250, 8914, 8915).abs();
                CallChecker.varAssign(absXA, "absXA", 250, 8914, 8915);
            }
            Dfp absYA = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(yA, Dfp.class, 251, 8944, 8945)) {
                yA = CallChecker.beforeCalled(yA, Dfp.class, 251, 8944, 8945);
                absYA = CallChecker.isCalled(yA, Dfp.class, 251, 8944, 8945).abs();
                CallChecker.varAssign(absYA, "absYA", 251, 8944, 8945);
            }
            int agingA = CallChecker.varInit(((int) (0)), "agingA", 252, 8962, 8978);
            Dfp xB = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(x, Dfp[].class, 253, 9000, 9000)) {
                xB = CallChecker.isCalled(x, Dfp[].class, 253, 9000, 9000)[signChangeIndex];
                CallChecker.varAssign(xB, "xB", 253, 9000, 9000);
            }
            Dfp yB = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(y, Dfp[].class, 254, 9040, 9040)) {
                yB = CallChecker.isCalled(y, Dfp[].class, 254, 9040, 9040)[signChangeIndex];
                CallChecker.varAssign(yB, "yB", 254, 9040, 9040);
            }
            Dfp absXB = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(xB, Dfp.class, 255, 9080, 9081)) {
                xB = CallChecker.beforeCalled(xB, Dfp.class, 255, 9080, 9081);
                absXB = CallChecker.isCalled(xB, Dfp.class, 255, 9080, 9081).abs();
                CallChecker.varAssign(absXB, "absXB", 255, 9080, 9081);
            }
            Dfp absYB = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(yB, Dfp.class, 256, 9110, 9111)) {
                yB = CallChecker.beforeCalled(yB, Dfp.class, 256, 9110, 9111);
                absYB = CallChecker.isCalled(yB, Dfp.class, 256, 9110, 9111).abs();
                CallChecker.varAssign(absYB, "absYB", 256, 9110, 9111);
            }
            int agingB = CallChecker.varInit(((int) (0)), "agingB", 257, 9128, 9144);
            while (true) {
                Dfp maxX = CallChecker.init(Dfp.class);
                if (CallChecker.beforeDeref(absXA, Dfp.class, 263, 9273, 9277)) {
                    absXA = CallChecker.beforeCalled(absXA, Dfp.class, 263, 9273, 9277);
                    if (CallChecker.isCalled(absXA, Dfp.class, 263, 9273, 9277).lessThan(absXB)) {
                        maxX = absXB;
                        CallChecker.varAssign(maxX, "maxX", 263, 9273, 9309);
                    }else {
                        maxX = absXA;
                        CallChecker.varAssign(maxX, "maxX", 263, 9273, 9309);
                    }
                }
                Dfp maxY = CallChecker.init(Dfp.class);
                if (CallChecker.beforeDeref(absYA, Dfp.class, 264, 9335, 9339)) {
                    absYA = CallChecker.beforeCalled(absYA, Dfp.class, 264, 9335, 9339);
                    if (CallChecker.isCalled(absYA, Dfp.class, 264, 9335, 9339).lessThan(absYB)) {
                        maxY = absYB;
                        CallChecker.varAssign(maxY, "maxY", 264, 9335, 9371);
                    }else {
                        maxY = absYA;
                        CallChecker.varAssign(maxY, "maxY", 264, 9335, 9371);
                    }
                }
                final Dfp xTol = CallChecker.varInit(CallChecker.isCalled(absoluteAccuracy, Dfp.class, 265, 9403, 9418).add(CallChecker.isCalled(relativeAccuracy, Dfp.class, 265, 9424, 9439).multiply(maxX)), "xTol", 265, 9386, 9456);
                if (CallChecker.beforeDeref(xB, Dfp.class, 266, 9474, 9475)) {
                    xB = CallChecker.beforeCalled(xB, Dfp.class, 266, 9474, 9475);
                    final Dfp npe_invocation_var37 = CallChecker.isCalled(xB, Dfp.class, 266, 9474, 9475).subtract(xA);
                    if (CallChecker.beforeDeref(npe_invocation_var37, Dfp.class, 266, 9474, 9488)) {
                        final Dfp npe_invocation_var38 = CallChecker.isCalled(npe_invocation_var37, Dfp.class, 266, 9474, 9488).subtract(xTol);
                        if (CallChecker.beforeDeref(npe_invocation_var38, Dfp.class, 266, 9474, 9503)) {
                            if (CallChecker.beforeDeref(maxY, Dfp.class, 267, 9541, 9544)) {
                                maxY = CallChecker.beforeCalled(maxY, Dfp.class, 267, 9541, 9544);
                                if ((CallChecker.isCalled(npe_invocation_var38, Dfp.class, 266, 9474, 9503).negativeOrNull()) || (CallChecker.isCalled(maxY, Dfp.class, 267, 9541, 9544).lessThan(functionValueAccuracy))) {
                                    switch (allowedSolution) {
                                        case ANY_SIDE :
                                            if (CallChecker.beforeDeref(absYA, Dfp.class, 270, 9683, 9687)) {
                                                absYA = CallChecker.beforeCalled(absYA, Dfp.class, 270, 9683, 9687);
                                                if (CallChecker.isCalled(absYA, Dfp.class, 270, 9683, 9687).lessThan(absYB)) {
                                                    return xA;
                                                }else {
                                                    return xB;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        case LEFT_SIDE :
                                            return xA;
                                        case RIGHT_SIDE :
                                            return xB;
                                        case BELOW_SIDE :
                                            if (CallChecker.beforeDeref(yA, Dfp.class, 276, 9906, 9907)) {
                                                yA = CallChecker.beforeCalled(yA, Dfp.class, 276, 9906, 9907);
                                                if (CallChecker.isCalled(yA, Dfp.class, 276, 9906, 9907).lessThan(zero)) {
                                                    return xA;
                                                }else {
                                                    return xB;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        case ABOVE_SIDE :
                                            if (CallChecker.beforeDeref(yA, Dfp.class, 278, 9996, 9997)) {
                                                yA = CallChecker.beforeCalled(yA, Dfp.class, 278, 9996, 9997);
                                                if (CallChecker.isCalled(yA, Dfp.class, 278, 9996, 9997).lessThan(zero)) {
                                                    return xB;
                                                }else {
                                                    return xA;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        default :
                                            throw new MathInternalError(null);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                Dfp targetY = CallChecker.init(Dfp.class);
                if (agingA >= (BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING)) {
                    if (CallChecker.beforeDeref(yB, Dfp.class, 289, 10410, 10411)) {
                        yB = CallChecker.beforeCalled(yB, Dfp.class, 289, 10410, 10411);
                        final Dfp npe_invocation_var39 = CallChecker.isCalled(yB, Dfp.class, 289, 10410, 10411).divide(16);
                        if (CallChecker.beforeDeref(npe_invocation_var39, Dfp.class, 289, 10410, 10422)) {
                            targetY = CallChecker.isCalled(npe_invocation_var39, Dfp.class, 289, 10410, 10422).negate();
                            CallChecker.varAssign(targetY, "targetY", 289, 10400, 10432);
                        }
                    }
                }else
                    if (agingB >= (BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING)) {
                        if (CallChecker.beforeDeref(yA, Dfp.class, 292, 10586, 10587)) {
                            yA = CallChecker.beforeCalled(yA, Dfp.class, 292, 10586, 10587);
                            final Dfp npe_invocation_var40 = CallChecker.isCalled(yA, Dfp.class, 292, 10586, 10587).divide(16);
                            if (CallChecker.beforeDeref(npe_invocation_var40, Dfp.class, 292, 10586, 10598)) {
                                targetY = CallChecker.isCalled(npe_invocation_var40, Dfp.class, 292, 10586, 10598).negate();
                                CallChecker.varAssign(targetY, "targetY", 292, 10576, 10608);
                            }
                        }
                    }else {
                        targetY = zero;
                        CallChecker.varAssign(targetY, "targetY", 295, 10718, 10732);
                    }
                
                Dfp nextX = CallChecker.init(Dfp.class);
                int start = CallChecker.varInit(((int) (0)), "start", 300, 10836, 10849);
                int end = CallChecker.varInit(((int) (nbPoints)), "end", 301, 10863, 10883);
                nextX = CallChecker.beforeCalled(nextX, Dfp.class, 327, 12048, 12052);
                do {
                    System.arraycopy(x, start, tmpX, start, (end - start));
                    nextX = guessX(targetY, tmpX, y, start, end);
                    CallChecker.varAssign(nextX, "nextX", 306, 11081, 11125);
                    if (CallChecker.beforeDeref(nextX, Dfp.class, 308, 11150, 11154)) {
                        if (CallChecker.beforeDeref(nextX, Dfp.class, 308, 11175, 11179)) {
                            nextX = CallChecker.beforeCalled(nextX, Dfp.class, 308, 11150, 11154);
                            nextX = CallChecker.beforeCalled(nextX, Dfp.class, 308, 11175, 11179);
                            if (!((CallChecker.isCalled(nextX, Dfp.class, 308, 11150, 11154).greaterThan(xA)) && (CallChecker.isCalled(nextX, Dfp.class, 308, 11175, 11179).lessThan(xB)))) {
                                if ((signChangeIndex - start) >= (end - signChangeIndex)) {
                                    ++start;
                                }else {
                                    --end;
                                }
                                nextX = nan;
                                CallChecker.varAssign(nextX, "nextX", 323, 11994, 12005);
                            }
                        }
                    }
                } while ((CallChecker.isCalled(nextX, Dfp.class, 327, 12048, 12052).isNaN()) && ((end - start) > 1) );
                if (CallChecker.beforeDeref(nextX, Dfp.class, 329, 12102, 12106)) {
                    nextX = CallChecker.beforeCalled(nextX, Dfp.class, 329, 12102, 12106);
                    if (CallChecker.isCalled(nextX, Dfp.class, 329, 12102, 12106).isNaN()) {
                        if (CallChecker.beforeDeref(xB, Dfp.class, 331, 12192, 12193)) {
                            xB = CallChecker.beforeCalled(xB, Dfp.class, 331, 12192, 12193);
                            final Dfp npe_invocation_var41 = CallChecker.isCalled(xB, Dfp.class, 331, 12192, 12193).subtract(xA);
                            if (CallChecker.beforeDeref(npe_invocation_var41, Dfp.class, 331, 12192, 12206)) {
                                if (CallChecker.beforeDeref(xA, Dfp.class, 331, 12185, 12186)) {
                                    xA = CallChecker.beforeCalled(xA, Dfp.class, 331, 12185, 12186);
                                    nextX = CallChecker.isCalled(xA, Dfp.class, 331, 12185, 12186).add(CallChecker.isCalled(npe_invocation_var41, Dfp.class, 331, 12192, 12206).divide(2));
                                    CallChecker.varAssign(nextX, "nextX", 331, 12177, 12218);
                                }
                            }
                        }
                        start = signChangeIndex - 1;
                        CallChecker.varAssign(start, "start", 332, 12236, 12263);
                        end = signChangeIndex;
                        CallChecker.varAssign(end, "end", 333, 12281, 12304);
                    }
                }
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 337, 12390, 12400)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 337, 12390, 12400).incrementCount();
                }
                final Dfp nextY = CallChecker.varInit(CallChecker.isCalled(f, UnivariateDfpFunction.class, 338, 12450, 12450).value(nextX), "nextY", 338, 12432, 12464);
                if (CallChecker.beforeDeref(nextY, Dfp.class, 339, 12482, 12486)) {
                    if (CallChecker.isCalled(nextY, Dfp.class, 339, 12482, 12486).isZero()) {
                        return nextX;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if ((nbPoints > 2) && ((end - start) != nbPoints)) {
                    nbPoints = end - start;
                    CallChecker.varAssign(nbPoints, "nbPoints", 349, 12948, 12970);
                    System.arraycopy(x, start, x, 0, nbPoints);
                    System.arraycopy(y, start, y, 0, nbPoints);
                    signChangeIndex -= start;
                    CallChecker.varAssign(signChangeIndex, "signChangeIndex", 352, 13108, 13132);
                }else
                    if (CallChecker.beforeDeref(x, Dfp[].class, 354, 13171, 13171)) {
                        if (nbPoints == (CallChecker.isCalled(x, Dfp[].class, 354, 13171, 13171).length)) {
                            nbPoints--;
                            if (CallChecker.beforeDeref(x, Dfp[].class, 360, 13410, 13410)) {
                                if (signChangeIndex >= (((CallChecker.isCalled(x, Dfp[].class, 360, 13410, 13410).length) + 1) / 2)) {
                                    System.arraycopy(x, 1, x, 0, nbPoints);
                                    System.arraycopy(y, 1, y, 0, nbPoints);
                                    --signChangeIndex;
                                }
                            }
                        }
                    }
                
                System.arraycopy(x, signChangeIndex, x, (signChangeIndex + 1), (nbPoints - signChangeIndex));
                if (CallChecker.beforeDeref(x, Dfp[].class, 372, 13964, 13964)) {
                    CallChecker.isCalled(x, Dfp[].class, 372, 13964, 13964)[signChangeIndex] = nextX;
                    CallChecker.varAssign(CallChecker.isCalled(x, Dfp[].class, 372, 13964, 13964)[signChangeIndex], "CallChecker.isCalled(x, Dfp[].class, 372, 13964, 13964)[signChangeIndex]", 372, 13964, 13990);
                }
                System.arraycopy(y, signChangeIndex, y, (signChangeIndex + 1), (nbPoints - signChangeIndex));
                if (CallChecker.beforeDeref(y, Dfp[].class, 374, 14106, 14106)) {
                    CallChecker.isCalled(y, Dfp[].class, 374, 14106, 14106)[signChangeIndex] = nextY;
                    CallChecker.varAssign(CallChecker.isCalled(y, Dfp[].class, 374, 14106, 14106)[signChangeIndex], "CallChecker.isCalled(y, Dfp[].class, 374, 14106, 14106)[signChangeIndex]", 374, 14106, 14132);
                }
                ++nbPoints;
                if (CallChecker.beforeDeref(nextY, Dfp.class, 378, 14221, 14225)) {
                    final Dfp npe_invocation_var42 = CallChecker.isCalled(nextY, Dfp.class, 378, 14221, 14225).multiply(yA);
                    if (CallChecker.beforeDeref(npe_invocation_var42, Dfp.class, 378, 14221, 14238)) {
                        if (CallChecker.isCalled(npe_invocation_var42, Dfp.class, 378, 14221, 14238).negativeOrNull()) {
                            xB = nextX;
                            CallChecker.varAssign(xB, "xB", 380, 14344, 14354);
                            yB = nextY;
                            CallChecker.varAssign(yB, "yB", 381, 14372, 14382);
                            if (CallChecker.beforeDeref(yB, Dfp.class, 382, 14408, 14409)) {
                                yB = CallChecker.beforeCalled(yB, Dfp.class, 382, 14408, 14409);
                                absYB = CallChecker.isCalled(yB, Dfp.class, 382, 14408, 14409).abs();
                                CallChecker.varAssign(absYB, "absYB", 382, 14400, 14416);
                            }
                            ++agingA;
                            agingB = 0;
                            CallChecker.varAssign(agingB, "agingB", 384, 14460, 14470);
                        }else {
                            xA = nextX;
                            CallChecker.varAssign(xA, "xA", 387, 14576, 14586);
                            yA = nextY;
                            CallChecker.varAssign(yA, "yA", 388, 14604, 14614);
                            if (CallChecker.beforeDeref(yA, Dfp.class, 389, 14640, 14641)) {
                                yA = CallChecker.beforeCalled(yA, Dfp.class, 389, 14640, 14641);
                                absYA = CallChecker.isCalled(yA, Dfp.class, 389, 14640, 14641).abs();
                                CallChecker.varAssign(absYA, "absYA", 389, 14632, 14648);
                            }
                            agingA = 0;
                            CallChecker.varAssign(agingA, "agingA", 390, 14666, 14676);
                            ++agingB;
                            signChangeIndex++;
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context315.methodEnd();
        }
    }

    private Dfp guessX(final Dfp targetY, final Dfp[] x, final Dfp[] y, final int start, final int end) {
        MethodContext _bcornu_methode_context316 = new MethodContext(Dfp.class, 416, 14826, 16245);
        try {
            CallChecker.varInit(this, "this", 416, 14826, 16245);
            CallChecker.varInit(end, "end", 416, 14826, 16245);
            CallChecker.varInit(start, "start", 416, 14826, 16245);
            CallChecker.varInit(y, "y", 416, 14826, 16245);
            CallChecker.varInit(x, "x", 416, 14826, 16245);
            CallChecker.varInit(targetY, "targetY", 416, 14826, 16245);
            CallChecker.varInit(this.evaluations, "evaluations", 416, 14826, 16245);
            CallChecker.varInit(this.relativeAccuracy, "relativeAccuracy", 416, 14826, 16245);
            CallChecker.varInit(this.absoluteAccuracy, "absoluteAccuracy", 416, 14826, 16245);
            CallChecker.varInit(this.functionValueAccuracy, "functionValueAccuracy", 416, 14826, 16245);
            CallChecker.varInit(this.maximalOrder, "maximalOrder", 416, 14826, 16245);
            CallChecker.varInit(MAXIMAL_AGING, "org.apache.commons.math3.dfp.BracketingNthOrderBrentSolverDFP.MAXIMAL_AGING", 416, 14826, 16245);
            for (int i = start; i < (end - 1); ++i) {
                final int delta = CallChecker.varInit(((int) ((i + 1) - start)), "delta", 421, 15842, 15873);
                for (int j = end - 1; j > i; --j) {
                    if (CallChecker.beforeDeref(x, Dfp[].class, 423, 15939, 15939)) {
                        if (CallChecker.beforeDeref(x, Dfp[].class, 423, 15946, 15946)) {
                            if (CallChecker.beforeDeref(x, Dfp[].class, 423, 15960, 15960)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp[].class, 423, 15946, 15946)[j], Dfp.class, 423, 15946, 15949)) {
                                    if (CallChecker.beforeDeref(y, Dfp[].class, 423, 15975, 15975)) {
                                        if (CallChecker.beforeDeref(y, Dfp[].class, 423, 15989, 15989)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(y, Dfp[].class, 423, 15975, 15975)[j], Dfp.class, 423, 15975, 15978)) {
                                                CallChecker.isCalled(x, Dfp[].class, 423, 15946, 15946)[j] = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp[].class, 423, 15946, 15946)[j], Dfp.class, 423, 15946, 15949);
                                                final Dfp npe_invocation_var43 = CallChecker.isCalled(CallChecker.isCalled(x, Dfp[].class, 423, 15946, 15946)[j], Dfp.class, 423, 15946, 15949).subtract(CallChecker.isCalled(x, Dfp[].class, 423, 15960, 15960)[(j - 1)]);
                                                if (CallChecker.beforeDeref(npe_invocation_var43, Dfp.class, 423, 15946, 15966)) {
                                                    CallChecker.isCalled(y, Dfp[].class, 423, 15975, 15975)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, Dfp[].class, 423, 15975, 15975)[j], Dfp.class, 423, 15975, 15978);
                                                    CallChecker.isCalled(x, Dfp[].class, 423, 15939, 15939)[j] = CallChecker.isCalled(npe_invocation_var43, Dfp.class, 423, 15946, 15966).divide(CallChecker.isCalled(CallChecker.isCalled(y, Dfp[].class, 423, 15975, 15975)[j], Dfp.class, 423, 15975, 15978).subtract(CallChecker.isCalled(y, Dfp[].class, 423, 15989, 15989)[(j - delta)]));
                                                    CallChecker.varAssign(CallChecker.isCalled(x, Dfp[].class, 423, 15939, 15939)[j], "CallChecker.isCalled(x, Dfp[].class, 423, 15939, 15939)[j]", 423, 15939, 16003);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Dfp x0 = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(targetY, Dfp.class, 428, 16078, 16084)) {
                x0 = CallChecker.isCalled(targetY, Dfp.class, 428, 16078, 16084).getZero();
                CallChecker.varAssign(x0, "x0", 428, 16078, 16084);
            }
            for (int j = end - 1; j >= start; --j) {
                if (CallChecker.beforeDeref(x, Dfp[].class, 430, 16163, 16163)) {
                    if (CallChecker.beforeDeref(y, Dfp[].class, 430, 16201, 16201)) {
                        if (CallChecker.beforeDeref(targetY, Dfp.class, 430, 16184, 16190)) {
                            if (CallChecker.beforeDeref(x0, Dfp.class, 430, 16172, 16173)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp[].class, 430, 16163, 16163)[j], Dfp.class, 430, 16163, 16166)) {
                                    x0 = CallChecker.beforeCalled(x0, Dfp.class, 430, 16172, 16173);
                                    CallChecker.isCalled(x, Dfp[].class, 430, 16163, 16163)[j] = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp[].class, 430, 16163, 16163)[j], Dfp.class, 430, 16163, 16166);
                                    x0 = CallChecker.isCalled(CallChecker.isCalled(x, Dfp[].class, 430, 16163, 16163)[j], Dfp.class, 430, 16163, 16166).add(CallChecker.isCalled(x0, Dfp.class, 430, 16172, 16173).multiply(CallChecker.isCalled(targetY, Dfp.class, 430, 16184, 16190).subtract(CallChecker.isCalled(y, Dfp[].class, 430, 16201, 16201)[j])));
                                    CallChecker.varAssign(x0, "x0", 430, 16158, 16208);
                                }
                            }
                        }
                    }
                }
            }
            return x0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context316.methodEnd();
        }
    }
}

