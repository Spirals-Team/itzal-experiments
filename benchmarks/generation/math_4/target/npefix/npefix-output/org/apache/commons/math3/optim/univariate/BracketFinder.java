package org.apache.commons.math3.optim.univariate;

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
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.Incrementor;

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
        ConstructorContext _bcornu_methode_context835 = new ConstructorContext(BracketFinder.class, 78, 2353, 2547);
        try {
        } finally {
            _bcornu_methode_context835.methodEnd();
        }
    }

    public BracketFinder(double growLimit, int maxEvaluations) {
        ConstructorContext _bcornu_methode_context836 = new ConstructorContext(BracketFinder.class, 89, 2554, 3168);
        try {
            if (growLimit <= 0) {
                throw new NotStrictlyPositiveException(growLimit);
            }
            if (maxEvaluations <= 0) {
                throw new NotStrictlyPositiveException(maxEvaluations);
            }
            this.growLimit = growLimit;
            CallChecker.varAssign(this.growLimit, "this.growLimit", 98, 3083, 3109);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 99, 3119, 3129)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 99, 3119, 3129).setMaximalCount(maxEvaluations);
            }
        } finally {
            _bcornu_methode_context836.methodEnd();
        }
    }

    public void search(UnivariateFunction func, GoalType goal, double xA, double xB) {
        MethodContext _bcornu_methode_context3637 = new MethodContext(void.class, 112, 3175, 6161);
        try {
            CallChecker.varInit(this, "this", 112, 3175, 6161);
            CallChecker.varInit(xB, "xB", 112, 3175, 6161);
            CallChecker.varInit(xA, "xA", 112, 3175, 6161);
            CallChecker.varInit(goal, "goal", 112, 3175, 6161);
            CallChecker.varInit(func, "func", 112, 3175, 6161);
            CallChecker.varInit(this.fMid, "fMid", 112, 3175, 6161);
            CallChecker.varInit(this.fHi, "fHi", 112, 3175, 6161);
            CallChecker.varInit(this.fLo, "fLo", 112, 3175, 6161);
            CallChecker.varInit(this.mid, "mid", 112, 3175, 6161);
            CallChecker.varInit(this.hi, "hi", 112, 3175, 6161);
            CallChecker.varInit(this.lo, "lo", 112, 3175, 6161);
            CallChecker.varInit(this.evaluations, "evaluations", 112, 3175, 6161);
            CallChecker.varInit(this.growLimit, "growLimit", 112, 3175, 6161);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 112, 3175, 6161);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 112, 3175, 6161);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 113, 3634, 3644)) {
                CallChecker.isCalled(evaluations, Incrementor.class, 113, 3634, 3644).resetCount();
            }
            final boolean isMinim = CallChecker.varInit(((boolean) (goal == (GoalType.MINIMIZE))), "isMinim", 114, 3668, 3717);
            double fA = CallChecker.varInit(((double) (eval(func, xA))), "fA", 116, 3728, 3754);
            double fB = CallChecker.varInit(((double) (eval(func, xB))), "fB", 117, 3764, 3790);
            if (isMinim) {
                if (fA < fB) {
                    double tmp = CallChecker.varInit(((double) (xA)), "tmp", 122, 3872, 3887);
                    xA = xB;
                    CallChecker.varAssign(xA, "xA", 123, 3901, 3908);
                    xB = tmp;
                    CallChecker.varAssign(xB, "xB", 124, 3922, 3930);
                    tmp = fA;
                    CallChecker.varAssign(tmp, "tmp", 126, 3945, 3953);
                    fA = fB;
                    CallChecker.varAssign(fA, "fA", 127, 3967, 3974);
                    fB = tmp;
                    CallChecker.varAssign(fB, "fB", 128, 3988, 3996);
                }
            }else {
                if (fA > fB) {
                    double tmp = CallChecker.varInit(((double) (xA)), "tmp", 122, 3872, 3887);
                    xA = xB;
                    CallChecker.varAssign(xA, "xA", 123, 3901, 3908);
                    xB = tmp;
                    CallChecker.varAssign(xB, "xB", 124, 3922, 3930);
                    tmp = fA;
                    CallChecker.varAssign(tmp, "tmp", 126, 3945, 3953);
                    fA = fB;
                    CallChecker.varAssign(fA, "fA", 127, 3967, 3974);
                    fB = tmp;
                    CallChecker.varAssign(fB, "fB", 128, 3988, 3996);
                }
            }
            double xC = CallChecker.varInit(((double) (xB + ((BracketFinder.GOLD) * (xB - xA)))), "xC", 131, 4017, 4050);
            double fC = CallChecker.varInit(((double) (eval(func, xC))), "fC", 132, 4060, 4086);
            while (isMinim ? fC < fB : fC > fB) {
                double tmp1 = CallChecker.varInit(((double) ((xB - xA) * (fB - fC))), "tmp1", 135, 4147, 4182);
                double tmp2 = CallChecker.varInit(((double) ((xB - xC) * (fB - fA))), "tmp2", 136, 4196, 4231);
                double val = CallChecker.varInit(((double) (tmp2 - tmp1)), "val", 138, 4246, 4270);
                double denom = CallChecker.init(double.class);
                if ((Math.abs(val)) < (BracketFinder.EPS_MIN)) {
                    denom = 2 * (BracketFinder.EPS_MIN);
                    CallChecker.varAssign(denom, "denom", 139, 4299, 4345);
                }else {
                    denom = 2 * val;
                    CallChecker.varAssign(denom, "denom", 139, 4299, 4345);
                }
                double w = CallChecker.varInit(((double) (xB - ((((xB - xC) * tmp2) - ((xB - xA) * tmp1)) / denom))), "w", 141, 4361, 4422);
                double wLim = CallChecker.varInit(((double) (xB + ((this.growLimit) * (xC - xB)))), "wLim", 142, 4436, 4476);
                double fW = CallChecker.init(double.class);
                if (((w - xC) * (xB - w)) > 0) {
                    fW = eval(func, w);
                    CallChecker.varAssign(fW, "fW", 146, 4561, 4579);
                    if (isMinim) {
                        if (fW < fC) {
                            xA = xB;
                            CallChecker.varAssign(xA, "xA", 150, 4692, 4699);
                            xB = w;
                            CallChecker.varAssign(xB, "xB", 151, 4721, 4727);
                            fA = fB;
                            CallChecker.varAssign(fA, "fA", 152, 4749, 4756);
                            fB = fW;
                            CallChecker.varAssign(fB, "fB", 153, 4778, 4785);
                            break;
                        }else
                            if (isMinim ? fW > fB : fW < fB) {
                                xC = w;
                                CallChecker.varAssign(xC, "xC", 158, 4946, 4952);
                                fC = fW;
                                CallChecker.varAssign(fC, "fC", 159, 4974, 4981);
                                break;
                            }
                        
                    }else {
                        if (fW > fC) {
                            xA = xB;
                            CallChecker.varAssign(xA, "xA", 150, 4692, 4699);
                            xB = w;
                            CallChecker.varAssign(xB, "xB", 151, 4721, 4727);
                            fA = fB;
                            CallChecker.varAssign(fA, "fA", 152, 4749, 4756);
                            fB = fW;
                            CallChecker.varAssign(fB, "fB", 153, 4778, 4785);
                            break;
                        }else
                            if (isMinim ? fW > fB : fW < fB) {
                                xC = w;
                                CallChecker.varAssign(xC, "xC", 158, 4946, 4952);
                                fC = fW;
                                CallChecker.varAssign(fC, "fC", 159, 4974, 4981);
                                break;
                            }
                        
                    }
                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                    CallChecker.varAssign(w, "w", 162, 5044, 5069);
                    fW = eval(func, w);
                    CallChecker.varAssign(fW, "fW", 163, 5087, 5105);
                }else
                    if (((w - wLim) * (wLim - xC)) >= 0) {
                        w = wLim;
                        CallChecker.varAssign(w, "w", 165, 5179, 5187);
                        fW = eval(func, w);
                        CallChecker.varAssign(fW, "fW", 166, 5205, 5223);
                    }else
                        if (((w - wLim) * (xC - w)) > 0) {
                            fW = eval(func, w);
                            CallChecker.varAssign(fW, "fW", 168, 5293, 5311);
                            if (isMinim) {
                                if (fW < fC) {
                                    xB = xC;
                                    CallChecker.varAssign(xB, "xB", 172, 5424, 5431);
                                    xC = w;
                                    CallChecker.varAssign(xC, "xC", 173, 5453, 5459);
                                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                                    CallChecker.varAssign(w, "w", 174, 5481, 5506);
                                    fB = fC;
                                    CallChecker.varAssign(fB, "fB", 175, 5528, 5535);
                                    fC = fW;
                                    CallChecker.varAssign(fC, "fC", 176, 5557, 5563);
                                    fW = eval(func, w);
                                    CallChecker.varAssign(fW, "fW", 177, 5585, 5603);
                                }
                            }else {
                                if (fW > fC) {
                                    xB = xC;
                                    CallChecker.varAssign(xB, "xB", 172, 5424, 5431);
                                    xC = w;
                                    CallChecker.varAssign(xC, "xC", 173, 5453, 5459);
                                    w = xC + ((BracketFinder.GOLD) * (xC - xB));
                                    CallChecker.varAssign(w, "w", 174, 5481, 5506);
                                    fB = fC;
                                    CallChecker.varAssign(fB, "fB", 175, 5528, 5535);
                                    fC = fW;
                                    CallChecker.varAssign(fC, "fC", 176, 5557, 5563);
                                    fW = eval(func, w);
                                    CallChecker.varAssign(fW, "fW", 177, 5585, 5603);
                                }
                            }
                        }else {
                            w = xC + ((BracketFinder.GOLD) * (xC - xB));
                            CallChecker.varAssign(w, "w", 180, 5660, 5685);
                            fW = eval(func, w);
                            CallChecker.varAssign(fW, "fW", 181, 5703, 5721);
                        }
                    
                
                xA = xB;
                CallChecker.varAssign(xA, "xA", 184, 5750, 5757);
                fA = fB;
                CallChecker.varAssign(fA, "fA", 185, 5771, 5778);
                xB = xC;
                CallChecker.varAssign(xB, "xB", 186, 5792, 5799);
                fB = fC;
                CallChecker.varAssign(fB, "fB", 187, 5813, 5820);
                xC = w;
                CallChecker.varAssign(xC, "xC", 188, 5834, 5840);
                fC = fW;
                CallChecker.varAssign(fC, "fC", 189, 5854, 5861);
            } 
            lo = xA;
            CallChecker.varAssign(this.lo, "this.lo", 192, 5882, 5889);
            fLo = fA;
            CallChecker.varAssign(this.fLo, "this.fLo", 193, 5899, 5907);
            mid = xB;
            CallChecker.varAssign(this.mid, "this.mid", 194, 5917, 5925);
            fMid = fB;
            CallChecker.varAssign(this.fMid, "this.fMid", 195, 5935, 5944);
            hi = xC;
            CallChecker.varAssign(this.hi, "this.hi", 196, 5954, 5961);
            fHi = fC;
            CallChecker.varAssign(this.fHi, "this.fHi", 197, 5971, 5979);
            if ((lo) > (hi)) {
                double tmp = CallChecker.varInit(((double) (this.lo)), "tmp", 200, 6017, 6032);
                lo = hi;
                CallChecker.varAssign(this.lo, "this.lo", 201, 6046, 6053);
                hi = tmp;
                CallChecker.varAssign(this.hi, "this.hi", 202, 6067, 6075);
                tmp = fLo;
                CallChecker.varAssign(tmp, "tmp", 204, 6090, 6099);
                fLo = fHi;
                CallChecker.varAssign(this.fLo, "this.fLo", 205, 6113, 6122);
                fHi = tmp;
                CallChecker.varAssign(this.fHi, "this.fHi", 206, 6136, 6145);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3637.methodEnd();
        }
    }

    public int getMaxEvaluations() {
        MethodContext _bcornu_methode_context3638 = new MethodContext(int.class, 213, 6168, 6310);
        try {
            CallChecker.varInit(this, "this", 213, 6168, 6310);
            CallChecker.varInit(this.fMid, "fMid", 213, 6168, 6310);
            CallChecker.varInit(this.fHi, "fHi", 213, 6168, 6310);
            CallChecker.varInit(this.fLo, "fLo", 213, 6168, 6310);
            CallChecker.varInit(this.mid, "mid", 213, 6168, 6310);
            CallChecker.varInit(this.hi, "hi", 213, 6168, 6310);
            CallChecker.varInit(this.lo, "lo", 213, 6168, 6310);
            CallChecker.varInit(this.evaluations, "evaluations", 213, 6168, 6310);
            CallChecker.varInit(this.growLimit, "growLimit", 213, 6168, 6310);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 213, 6168, 6310);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 213, 6168, 6310);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 214, 6275, 6285)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 214, 6275, 6285).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3638.methodEnd();
        }
    }

    public int getEvaluations() {
        MethodContext _bcornu_methode_context3639 = new MethodContext(int.class, 220, 6317, 6449);
        try {
            CallChecker.varInit(this, "this", 220, 6317, 6449);
            CallChecker.varInit(this.fMid, "fMid", 220, 6317, 6449);
            CallChecker.varInit(this.fHi, "fHi", 220, 6317, 6449);
            CallChecker.varInit(this.fLo, "fLo", 220, 6317, 6449);
            CallChecker.varInit(this.mid, "mid", 220, 6317, 6449);
            CallChecker.varInit(this.hi, "hi", 220, 6317, 6449);
            CallChecker.varInit(this.lo, "lo", 220, 6317, 6449);
            CallChecker.varInit(this.evaluations, "evaluations", 220, 6317, 6449);
            CallChecker.varInit(this.growLimit, "growLimit", 220, 6317, 6449);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 220, 6317, 6449);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 220, 6317, 6449);
            if (CallChecker.beforeDeref(evaluations, Incrementor.class, 221, 6421, 6431)) {
                return CallChecker.isCalled(evaluations, Incrementor.class, 221, 6421, 6431).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3639.methodEnd();
        }
    }

    public double getLo() {
        MethodContext _bcornu_methode_context3640 = new MethodContext(double.class, 228, 6456, 6588);
        try {
            CallChecker.varInit(this, "this", 228, 6456, 6588);
            CallChecker.varInit(this.fMid, "fMid", 228, 6456, 6588);
            CallChecker.varInit(this.fHi, "fHi", 228, 6456, 6588);
            CallChecker.varInit(this.fLo, "fLo", 228, 6456, 6588);
            CallChecker.varInit(this.mid, "mid", 228, 6456, 6588);
            CallChecker.varInit(this.hi, "hi", 228, 6456, 6588);
            CallChecker.varInit(this.lo, "lo", 228, 6456, 6588);
            CallChecker.varInit(this.evaluations, "evaluations", 228, 6456, 6588);
            CallChecker.varInit(this.growLimit, "growLimit", 228, 6456, 6588);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 228, 6456, 6588);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 228, 6456, 6588);
            return lo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3640.methodEnd();
        }
    }

    public double getFLo() {
        MethodContext _bcornu_methode_context3641 = new MethodContext(double.class, 236, 6595, 6757);
        try {
            CallChecker.varInit(this, "this", 236, 6595, 6757);
            CallChecker.varInit(this.fMid, "fMid", 236, 6595, 6757);
            CallChecker.varInit(this.fHi, "fHi", 236, 6595, 6757);
            CallChecker.varInit(this.fLo, "fLo", 236, 6595, 6757);
            CallChecker.varInit(this.mid, "mid", 236, 6595, 6757);
            CallChecker.varInit(this.hi, "hi", 236, 6595, 6757);
            CallChecker.varInit(this.lo, "lo", 236, 6595, 6757);
            CallChecker.varInit(this.evaluations, "evaluations", 236, 6595, 6757);
            CallChecker.varInit(this.growLimit, "growLimit", 236, 6595, 6757);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 236, 6595, 6757);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 236, 6595, 6757);
            return fLo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3641.methodEnd();
        }
    }

    public double getHi() {
        MethodContext _bcornu_methode_context3642 = new MethodContext(double.class, 244, 6764, 6897);
        try {
            CallChecker.varInit(this, "this", 244, 6764, 6897);
            CallChecker.varInit(this.fMid, "fMid", 244, 6764, 6897);
            CallChecker.varInit(this.fHi, "fHi", 244, 6764, 6897);
            CallChecker.varInit(this.fLo, "fLo", 244, 6764, 6897);
            CallChecker.varInit(this.mid, "mid", 244, 6764, 6897);
            CallChecker.varInit(this.hi, "hi", 244, 6764, 6897);
            CallChecker.varInit(this.lo, "lo", 244, 6764, 6897);
            CallChecker.varInit(this.evaluations, "evaluations", 244, 6764, 6897);
            CallChecker.varInit(this.growLimit, "growLimit", 244, 6764, 6897);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 244, 6764, 6897);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 244, 6764, 6897);
            return hi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3642.methodEnd();
        }
    }

    public double getFHi() {
        MethodContext _bcornu_methode_context3643 = new MethodContext(double.class, 252, 6904, 7066);
        try {
            CallChecker.varInit(this, "this", 252, 6904, 7066);
            CallChecker.varInit(this.fMid, "fMid", 252, 6904, 7066);
            CallChecker.varInit(this.fHi, "fHi", 252, 6904, 7066);
            CallChecker.varInit(this.fLo, "fLo", 252, 6904, 7066);
            CallChecker.varInit(this.mid, "mid", 252, 6904, 7066);
            CallChecker.varInit(this.hi, "hi", 252, 6904, 7066);
            CallChecker.varInit(this.lo, "lo", 252, 6904, 7066);
            CallChecker.varInit(this.evaluations, "evaluations", 252, 6904, 7066);
            CallChecker.varInit(this.growLimit, "growLimit", 252, 6904, 7066);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 252, 6904, 7066);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 252, 6904, 7066);
            return fHi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3643.methodEnd();
        }
    }

    public double getMid() {
        MethodContext _bcornu_methode_context3644 = new MethodContext(double.class, 260, 7073, 7214);
        try {
            CallChecker.varInit(this, "this", 260, 7073, 7214);
            CallChecker.varInit(this.fMid, "fMid", 260, 7073, 7214);
            CallChecker.varInit(this.fHi, "fHi", 260, 7073, 7214);
            CallChecker.varInit(this.fLo, "fLo", 260, 7073, 7214);
            CallChecker.varInit(this.mid, "mid", 260, 7073, 7214);
            CallChecker.varInit(this.hi, "hi", 260, 7073, 7214);
            CallChecker.varInit(this.lo, "lo", 260, 7073, 7214);
            CallChecker.varInit(this.evaluations, "evaluations", 260, 7073, 7214);
            CallChecker.varInit(this.growLimit, "growLimit", 260, 7073, 7214);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 260, 7073, 7214);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 260, 7073, 7214);
            return mid;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3644.methodEnd();
        }
    }

    public double getFMid() {
        MethodContext _bcornu_methode_context3645 = new MethodContext(double.class, 268, 7221, 7387);
        try {
            CallChecker.varInit(this, "this", 268, 7221, 7387);
            CallChecker.varInit(this.fMid, "fMid", 268, 7221, 7387);
            CallChecker.varInit(this.fHi, "fHi", 268, 7221, 7387);
            CallChecker.varInit(this.fLo, "fLo", 268, 7221, 7387);
            CallChecker.varInit(this.mid, "mid", 268, 7221, 7387);
            CallChecker.varInit(this.hi, "hi", 268, 7221, 7387);
            CallChecker.varInit(this.lo, "lo", 268, 7221, 7387);
            CallChecker.varInit(this.evaluations, "evaluations", 268, 7221, 7387);
            CallChecker.varInit(this.growLimit, "growLimit", 268, 7221, 7387);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 268, 7221, 7387);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 268, 7221, 7387);
            return fMid;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3645.methodEnd();
        }
    }

    private double eval(UnivariateFunction f, double x) {
        MethodContext _bcornu_methode_context3646 = new MethodContext(double.class, 279, 7394, 7852);
        try {
            CallChecker.varInit(this, "this", 279, 7394, 7852);
            CallChecker.varInit(x, "x", 279, 7394, 7852);
            CallChecker.varInit(f, "f", 279, 7394, 7852);
            CallChecker.varInit(this.fMid, "fMid", 279, 7394, 7852);
            CallChecker.varInit(this.fHi, "fHi", 279, 7394, 7852);
            CallChecker.varInit(this.fLo, "fLo", 279, 7394, 7852);
            CallChecker.varInit(this.mid, "mid", 279, 7394, 7852);
            CallChecker.varInit(this.hi, "hi", 279, 7394, 7852);
            CallChecker.varInit(this.lo, "lo", 279, 7394, 7852);
            CallChecker.varInit(this.evaluations, "evaluations", 279, 7394, 7852);
            CallChecker.varInit(this.growLimit, "growLimit", 279, 7394, 7852);
            CallChecker.varInit(GOLD, "org.apache.commons.math3.optim.univariate.BracketFinder.GOLD", 279, 7394, 7852);
            CallChecker.varInit(EPS_MIN, "org.apache.commons.math3.optim.univariate.BracketFinder.EPS_MIN", 279, 7394, 7852);
            TryContext _bcornu_try_context_79 = new TryContext(79, BracketFinder.class, "org.apache.commons.math3.exception.MaxCountExceededException");
            try {
                if (CallChecker.beforeDeref(evaluations, Incrementor.class, 281, 7670, 7680)) {
                    CallChecker.isCalled(evaluations, Incrementor.class, 281, 7670, 7680).incrementCount();
                }
            } catch (MaxCountExceededException e) {
                _bcornu_try_context_79.catchStart(79);
                throw new TooManyEvaluationsException(e.getMax());
            } finally {
                _bcornu_try_context_79.finallyStart(79);
            }
            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 285, 7836, 7836)) {
                f = CallChecker.beforeCalled(f, UnivariateFunction.class, 285, 7836, 7836);
                return CallChecker.isCalled(f, UnivariateFunction.class, 285, 7836, 7836).value(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3646.methodEnd();
        }
    }
}

