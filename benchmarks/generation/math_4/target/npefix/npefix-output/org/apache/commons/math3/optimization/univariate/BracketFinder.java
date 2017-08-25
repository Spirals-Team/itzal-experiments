package org.apache.commons.math3.optimization.univariate;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.Incrementor;

@Deprecated
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21;

    private static final double GOLD = 1.618034;

    private final double growLimit;

    private final Incrementor evaluations = new Incrementor();

    private double lo;

    private double hi;

    private double mid;

    private double fLo;

    private double fHi;

    private double fMid;

    public BracketFinder() {
        this(100, 50);
        ConstructorContext _bcornu_methode_context833 = new ConstructorContext(BracketFinder.class, 80, 2411, 2605);
        try {
        } finally {
            _bcornu_methode_context833.methodEnd();
        }
    }

    public BracketFinder(double growLimit, int maxEvaluations) {
        ConstructorContext _bcornu_methode_context834 = new ConstructorContext(BracketFinder.class, 91, 2612, 3226);
        try {
            if (growLimit <= 0) {
                throw new NotStrictlyPositiveException(growLimit);
            }
            if (maxEvaluations <= 0) {
                throw new NotStrictlyPositiveException(maxEvaluations);
            }
            this.growLimit = growLimit;
            CallChecker.varAssign(this.growLimit, "this.growLimit", 100, 3141, 3167);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 101, 3177, 3187)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 101, 3177, 3187).setMaximalCount(maxEvaluations);
            }
        } finally {
            _bcornu_methode_context834.methodEnd();
        }
    }

    public void search(UnivariateFunction func, GoalType goal, double xA, double xB) {
        MethodContext _bcornu_methode_context3627 = new MethodContext(void.class, 114, 3233, 6219);
        try {
            CallChecker.varInit(this, "this", 114, 3233, 6219);
            CallChecker.varInit(xB, "xB", 114, 3233, 6219);
            CallChecker.varInit(xA, "xA", 114, 3233, 6219);
            CallChecker.varInit(goal, "goal", 114, 3233, 6219);
            CallChecker.varInit(func, "func", 114, 3233, 6219);
            CallChecker.varInit(this.fMid, "fMid", 114, 3233, 6219);
            CallChecker.varInit(this.fHi, "fHi", 114, 3233, 6219);
            CallChecker.varInit(this.fLo, "fLo", 114, 3233, 6219);
            CallChecker.varInit(this.mid, "mid", 114, 3233, 6219);
            CallChecker.varInit(this.hi, "hi", 114, 3233, 6219);
            CallChecker.varInit(this.lo, "lo", 114, 3233, 6219);
            CallChecker.varInit(this.evaluations, "evaluations", 114, 3233, 6219);
            CallChecker.varInit(this.growLimit, "growLimit", 114, 3233, 6219);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 114, 3233, 6219);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 114, 3233, 6219);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 115, 3692, 3702)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 115, 3692, 3702).resetCount();
            }
            final boolean isMinim = CallChecker.varInit(((boolean) (goal == (GoalType.MINIMIZE))), "isMinim", 116, 3726, 3775);
            double fA = CallChecker.varInit(((double) (eval(func, xA))), "fA", 118, 3786, 3812);
            double fB = CallChecker.varInit(((double) (eval(func, xB))), "fB", 119, 3822, 3848);
            if (isMinim) {
                if (fA < fB) {
                    double tmp = CallChecker.varInit(((double) (xA)), "tmp", 124, 3930, 3945);
                    xA = xB;
                    CallChecker.varAssign(xA, "xA", 125, 3959, 3966);
                    xB = tmp;
                    CallChecker.varAssign(xB, "xB", 126, 3980, 3988);
                    tmp = fA;
                    CallChecker.varAssign(tmp, "tmp", 128, 4003, 4011);
                    fA = fB;
                    CallChecker.varAssign(fA, "fA", 129, 4025, 4032);
                    fB = tmp;
                    CallChecker.varAssign(fB, "fB", 130, 4046, 4054);
                }
            }else {
                if (fA > fB) {
                    double tmp = CallChecker.varInit(((double) (xA)), "tmp", 124, 3930, 3945);
                    xA = xB;
                    CallChecker.varAssign(xA, "xA", 125, 3959, 3966);
                    xB = tmp;
                    CallChecker.varAssign(xB, "xB", 126, 3980, 3988);
                    tmp = fA;
                    CallChecker.varAssign(tmp, "tmp", 128, 4003, 4011);
                    fA = fB;
                    CallChecker.varAssign(fA, "fA", 129, 4025, 4032);
                    fB = tmp;
                    CallChecker.varAssign(fB, "fB", 130, 4046, 4054);
                }
            }
            double xC = CallChecker.varInit(((double) (xB + ((BracketFinder.GOLD) * (xB - xA)))), "xC", 133, 4075, 4108);
            double fC = CallChecker.varInit(((double) (eval(func, xC))), "fC", 134, 4118, 4144);
            while (isMinim ? fC < fB : fC > fB) {
                double tmp1 = CallChecker.varInit(((double) ((xB - xA) * (fB - fC))), "tmp1", 137, 4205, 4240);
                double tmp2 = CallChecker.varInit(((double) ((xB - xC) * (fB - fA))), "tmp2", 138, 4254, 4289);
                double val = CallChecker.varInit(((double) (tmp2 - tmp1)), "val", 140, 4304, 4328);
                double denom = CallChecker.init(double.class);
                if ((Math.abs(val)) < (BracketFinder.EPS_MIN)) {
                    denom = 2 * (BracketFinder.EPS_MIN);
                    CallChecker.varAssign(denom, "denom", 141, 4357, 4403);
                }else {
                    denom = 2 * val;
                    CallChecker.varAssign(denom, "denom", 141, 4357, 4403);
                }
                double w = CallChecker.varInit(((double) (xB - ((((xB - xC) * tmp2) - ((xB - xA) * tmp1)) / denom))), "w", 143, 4419, 4480);
                double wLim = CallChecker.varInit(((double) (xB + ((this.growLimit) * (xC - xB)))), "wLim", 144, 4494, 4534);
                double fW = CallChecker.init(double.class);
                if (((w - xC) * (xB - w)) > 0) {
                    fW = eval(func, w);
                    CallChecker.varAssign(fW, "fW", 148, 4619, 4637);
                    if (isMinim) {
                        if (fW < fC) {
                            xA = xB;
                            CallChecker.varAssign(xA, "xA", 152, 4750, 4757);
                            xB = w;
                            CallChecker.varAssign(xB, "xB", 153, 4779, 4785);
                            fA = fB;
                            CallChecker.varAssign(fA, "fA", 154, 4807, 4814);
                            fB = fW;
                            CallChecker.varAssign(fB, "fB", 155, 4836, 4843);
                            break;
                        }else
                            if (isMinim ? fW > fB : fW < fB) {
                                xC = w;
                                CallChecker.varAssign(xC, "xC", 160, 5004, 5010);
                                fC = fW;
                                CallChecker.varAssign(fC, "fC", 161, 5032, 5039);
                                break;
                            }
                        
                    }else {
                        if (fW > fC) {
                            xA = xB;
                            CallChecker.varAssign(xA, "xA", 152, 4750, 4757);
                            xB = w;
                            CallChecker.varAssign(xB, "xB", 153, 4779, 4785);
                            fA = fB;
                            CallChecker.varAssign(fA, "fA", 154, 4807, 4814);
                            fB = fW;
                            CallChecker.varAssign(fB, "fB", 155, 4836, 4843);
                            break;
                        }else
                            if (isMinim ? fW > fB : fW < fB) {
                                xC = w;
                                CallChecker.varAssign(xC, "xC", 160, 5004, 5010);
                                fC = fW;
                                CallChecker.varAssign(fC, "fC", 161, 5032, 5039);
                                break;
                            }
                        
                    }
                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                    CallChecker.varAssign(w, "w", 164, 5102, 5127);
                    fW = eval(func, w);
                    CallChecker.varAssign(fW, "fW", 165, 5145, 5163);
                }else
                    if (((w - wLim) * (wLim - xC)) >= 0) {
                        w = wLim;
                        CallChecker.varAssign(w, "w", 167, 5237, 5245);
                        fW = eval(func, w);
                        CallChecker.varAssign(fW, "fW", 168, 5263, 5281);
                    }else
                        if (((w - wLim) * (xC - w)) > 0) {
                            fW = eval(func, w);
                            CallChecker.varAssign(fW, "fW", 170, 5351, 5369);
                            if (isMinim) {
                                if (fW < fC) {
                                    xB = xC;
                                    CallChecker.varAssign(xB, "xB", 174, 5482, 5489);
                                    xC = w;
                                    CallChecker.varAssign(xC, "xC", 175, 5511, 5517);
                                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                                    CallChecker.varAssign(w, "w", 176, 5539, 5564);
                                    fB = fC;
                                    CallChecker.varAssign(fB, "fB", 177, 5586, 5593);
                                    fC = fW;
                                    CallChecker.varAssign(fC, "fC", 178, 5615, 5621);
                                    fW = eval(func, w);
                                    CallChecker.varAssign(fW, "fW", 179, 5643, 5661);
                                }
                            }else {
                                if (fW > fC) {
                                    xB = xC;
                                    CallChecker.varAssign(xB, "xB", 174, 5482, 5489);
                                    xC = w;
                                    CallChecker.varAssign(xC, "xC", 175, 5511, 5517);
                                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                                    CallChecker.varAssign(w, "w", 176, 5539, 5564);
                                    fB = fC;
                                    CallChecker.varAssign(fB, "fB", 177, 5586, 5593);
                                    fC = fW;
                                    CallChecker.varAssign(fC, "fC", 178, 5615, 5621);
                                    fW = eval(func, w);
                                    CallChecker.varAssign(fW, "fW", 179, 5643, 5661);
                                }
                            }
                        }else {
                            w = xC + ((BracketFinder.GOLD) * (xC - xB));
                            CallChecker.varAssign(w, "w", 182, 5718, 5743);
                            fW = eval(func, w);
                            CallChecker.varAssign(fW, "fW", 183, 5761, 5779);
                        }
                    
                
                xA = xB;
                CallChecker.varAssign(xA, "xA", 186, 5808, 5815);
                fA = fB;
                CallChecker.varAssign(fA, "fA", 187, 5829, 5836);
                xB = xC;
                CallChecker.varAssign(xB, "xB", 188, 5850, 5857);
                fB = fC;
                CallChecker.varAssign(fB, "fB", 189, 5871, 5878);
                xC = w;
                CallChecker.varAssign(xC, "xC", 190, 5892, 5898);
                fC = fW;
                CallChecker.varAssign(fC, "fC", 191, 5912, 5919);
            } 
            lo = xA;
            CallChecker.varAssign(this.lo, "this.lo", 194, 5940, 5947);
            fLo = fA;
            CallChecker.varAssign(this.fLo, "this.fLo", 195, 5957, 5965);
            mid = xB;
            CallChecker.varAssign(this.mid, "this.mid", 196, 5975, 5983);
            fMid = fB;
            CallChecker.varAssign(this.fMid, "this.fMid", 197, 5993, 6002);
            hi = xC;
            CallChecker.varAssign(this.hi, "this.hi", 198, 6012, 6019);
            fHi = fC;
            CallChecker.varAssign(this.fHi, "this.fHi", 199, 6029, 6037);
            if ((lo) > (hi)) {
                double tmp = CallChecker.varInit(((double) (this.lo)), "tmp", 202, 6075, 6090);
                lo = hi;
                CallChecker.varAssign(this.lo, "this.lo", 203, 6104, 6111);
                hi = tmp;
                CallChecker.varAssign(this.hi, "this.hi", 204, 6125, 6133);
                tmp = fLo;
                CallChecker.varAssign(tmp, "tmp", 206, 6148, 6157);
                fLo = fHi;
                CallChecker.varAssign(this.fLo, "this.fLo", 207, 6171, 6180);
                fHi = tmp;
                CallChecker.varAssign(this.fHi, "this.fHi", 208, 6194, 6203);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3627.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context3628 = new MethodContext(int.class, 215, 6226, 6368);
        try {
            CallChecker.varInit(this, "this", 215, 6226, 6368);
            CallChecker.varInit(this.fMid, "fMid", 215, 6226, 6368);
            CallChecker.varInit(this.fHi, "fHi", 215, 6226, 6368);
            CallChecker.varInit(this.fLo, "fLo", 215, 6226, 6368);
            CallChecker.varInit(this.mid, "mid", 215, 6226, 6368);
            CallChecker.varInit(this.hi, "hi", 215, 6226, 6368);
            CallChecker.varInit(this.lo, "lo", 215, 6226, 6368);
            CallChecker.varInit(this.evaluations, "evaluations", 215, 6226, 6368);
            CallChecker.varInit(this.growLimit, "growLimit", 215, 6226, 6368);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 215, 6226, 6368);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 215, 6226, 6368);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 216, 6333, 6343)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 216, 6333, 6343).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3628.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context3629 = new MethodContext(int.class, 222, 6375, 6507);
        try {
            CallChecker.varInit(this, "this", 222, 6375, 6507);
            CallChecker.varInit(this.fMid, "fMid", 222, 6375, 6507);
            CallChecker.varInit(this.fHi, "fHi", 222, 6375, 6507);
            CallChecker.varInit(this.fLo, "fLo", 222, 6375, 6507);
            CallChecker.varInit(this.mid, "mid", 222, 6375, 6507);
            CallChecker.varInit(this.hi, "hi", 222, 6375, 6507);
            CallChecker.varInit(this.lo, "lo", 222, 6375, 6507);
            CallChecker.varInit(this.evaluations, "evaluations", 222, 6375, 6507);
            CallChecker.varInit(this.growLimit, "growLimit", 222, 6375, 6507);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 222, 6375, 6507);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 222, 6375, 6507);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 223, 6479, 6489)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 223, 6479, 6489).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3629.methodEnd();
        }
    }

    public double getLo() {
        MethodContext _bcornu_methode_context3630 = new MethodContext(double.class, 230, 6514, 6646);
        try {
            CallChecker.varInit(this, "this", 230, 6514, 6646);
            CallChecker.varInit(this.fMid, "fMid", 230, 6514, 6646);
            CallChecker.varInit(this.fHi, "fHi", 230, 6514, 6646);
            CallChecker.varInit(this.fLo, "fLo", 230, 6514, 6646);
            CallChecker.varInit(this.mid, "mid", 230, 6514, 6646);
            CallChecker.varInit(this.hi, "hi", 230, 6514, 6646);
            CallChecker.varInit(this.lo, "lo", 230, 6514, 6646);
            CallChecker.varInit(this.evaluations, "evaluations", 230, 6514, 6646);
            CallChecker.varInit(this.growLimit, "growLimit", 230, 6514, 6646);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 230, 6514, 6646);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 230, 6514, 6646);
            return lo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3630.methodEnd();
        }
    }

    public double getFLo() {
        MethodContext _bcornu_methode_context3631 = new MethodContext(double.class, 238, 6653, 6815);
        try {
            CallChecker.varInit(this, "this", 238, 6653, 6815);
            CallChecker.varInit(this.fMid, "fMid", 238, 6653, 6815);
            CallChecker.varInit(this.fHi, "fHi", 238, 6653, 6815);
            CallChecker.varInit(this.fLo, "fLo", 238, 6653, 6815);
            CallChecker.varInit(this.mid, "mid", 238, 6653, 6815);
            CallChecker.varInit(this.hi, "hi", 238, 6653, 6815);
            CallChecker.varInit(this.lo, "lo", 238, 6653, 6815);
            CallChecker.varInit(this.evaluations, "evaluations", 238, 6653, 6815);
            CallChecker.varInit(this.growLimit, "growLimit", 238, 6653, 6815);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 238, 6653, 6815);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 238, 6653, 6815);
            return fLo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3631.methodEnd();
        }
    }

    public double getHi() {
        MethodContext _bcornu_methode_context3632 = new MethodContext(double.class, 246, 6822, 6955);
        try {
            CallChecker.varInit(this, "this", 246, 6822, 6955);
            CallChecker.varInit(this.fMid, "fMid", 246, 6822, 6955);
            CallChecker.varInit(this.fHi, "fHi", 246, 6822, 6955);
            CallChecker.varInit(this.fLo, "fLo", 246, 6822, 6955);
            CallChecker.varInit(this.mid, "mid", 246, 6822, 6955);
            CallChecker.varInit(this.hi, "hi", 246, 6822, 6955);
            CallChecker.varInit(this.lo, "lo", 246, 6822, 6955);
            CallChecker.varInit(this.evaluations, "evaluations", 246, 6822, 6955);
            CallChecker.varInit(this.growLimit, "growLimit", 246, 6822, 6955);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 246, 6822, 6955);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 246, 6822, 6955);
            return hi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3632.methodEnd();
        }
    }

    public double getFHi() {
        MethodContext _bcornu_methode_context3633 = new MethodContext(double.class, 254, 6962, 7124);
        try {
            CallChecker.varInit(this, "this", 254, 6962, 7124);
            CallChecker.varInit(this.fMid, "fMid", 254, 6962, 7124);
            CallChecker.varInit(this.fHi, "fHi", 254, 6962, 7124);
            CallChecker.varInit(this.fLo, "fLo", 254, 6962, 7124);
            CallChecker.varInit(this.mid, "mid", 254, 6962, 7124);
            CallChecker.varInit(this.hi, "hi", 254, 6962, 7124);
            CallChecker.varInit(this.lo, "lo", 254, 6962, 7124);
            CallChecker.varInit(this.evaluations, "evaluations", 254, 6962, 7124);
            CallChecker.varInit(this.growLimit, "growLimit", 254, 6962, 7124);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 254, 6962, 7124);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 254, 6962, 7124);
            return fHi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3633.methodEnd();
        }
    }

    public double getMid() {
        MethodContext _bcornu_methode_context3634 = new MethodContext(double.class, 262, 7131, 7272);
        try {
            CallChecker.varInit(this, "this", 262, 7131, 7272);
            CallChecker.varInit(this.fMid, "fMid", 262, 7131, 7272);
            CallChecker.varInit(this.fHi, "fHi", 262, 7131, 7272);
            CallChecker.varInit(this.fLo, "fLo", 262, 7131, 7272);
            CallChecker.varInit(this.mid, "mid", 262, 7131, 7272);
            CallChecker.varInit(this.hi, "hi", 262, 7131, 7272);
            CallChecker.varInit(this.lo, "lo", 262, 7131, 7272);
            CallChecker.varInit(this.evaluations, "evaluations", 262, 7131, 7272);
            CallChecker.varInit(this.growLimit, "growLimit", 262, 7131, 7272);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 262, 7131, 7272);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 262, 7131, 7272);
            return mid;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3634.methodEnd();
        }
    }

    public double getFMid() {
        MethodContext _bcornu_methode_context3635 = new MethodContext(double.class, 270, 7279, 7445);
        try {
            CallChecker.varInit(this, "this", 270, 7279, 7445);
            CallChecker.varInit(this.fMid, "fMid", 270, 7279, 7445);
            CallChecker.varInit(this.fHi, "fHi", 270, 7279, 7445);
            CallChecker.varInit(this.fLo, "fLo", 270, 7279, 7445);
            CallChecker.varInit(this.mid, "mid", 270, 7279, 7445);
            CallChecker.varInit(this.hi, "hi", 270, 7279, 7445);
            CallChecker.varInit(this.lo, "lo", 270, 7279, 7445);
            CallChecker.varInit(this.evaluations, "evaluations", 270, 7279, 7445);
            CallChecker.varInit(this.growLimit, "growLimit", 270, 7279, 7445);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 270, 7279, 7445);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 270, 7279, 7445);
            return fMid;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3635.methodEnd();
        }
    }

    private double eval(UnivariateFunction f, double x) {
        MethodContext _bcornu_methode_context3636 = new MethodContext(double.class, 281, 7452, 7910);
        try {
            CallChecker.varInit(this, "this", 281, 7452, 7910);
            CallChecker.varInit(x, "x", 281, 7452, 7910);
            CallChecker.varInit(f, "f", 281, 7452, 7910);
            CallChecker.varInit(this.fMid, "fMid", 281, 7452, 7910);
            CallChecker.varInit(this.fHi, "fHi", 281, 7452, 7910);
            CallChecker.varInit(this.fLo, "fLo", 281, 7452, 7910);
            CallChecker.varInit(this.mid, "mid", 281, 7452, 7910);
            CallChecker.varInit(this.hi, "hi", 281, 7452, 7910);
            CallChecker.varInit(this.lo, "lo", 281, 7452, 7910);
            CallChecker.varInit(this.evaluations, "evaluations", 281, 7452, 7910);
            CallChecker.varInit(this.growLimit, "growLimit", 281, 7452, 7910);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optimization.univariate.BracketFinder.GOLD", 281, 7452, 7910);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optimization.univariate.BracketFinder.EPS_MIN", 281, 7452, 7910);
            TryContext _bcornu_try_context_78 = new TryContext(78, BracketFinder.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 283, 7728, 7738)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 283, 7728, 7738).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_78.catchStart(78);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_78.finallyStart(78);
            }
            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 287, 7894, 7894)) {
                f = CallChecker.beforeCalled(f, UnivariateFunction.class, 287, 7894, 7894);
                return CallChecker.isCalled(f, UnivariateFunction.class, 287, 7894, 7894).value(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3636.methodEnd();
        }
    }
}

