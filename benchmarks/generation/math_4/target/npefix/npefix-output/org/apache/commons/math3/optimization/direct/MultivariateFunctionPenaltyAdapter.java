package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

@Deprecated
public class MultivariateFunctionPenaltyAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;

    private final double[] lower;

    private final double[] upper;

    private final double offset;

    private final double[] scale;

    public MultivariateFunctionPenaltyAdapter(final MultivariateFunction bounded, final double[] lower, final double[] upper, final double offset, final double[] scale) {
        ConstructorContext _bcornu_methode_context395 = new ConstructorContext(MultivariateFunctionPenaltyAdapter.class, 125, 3578, 6977);
        try {
            MathUtils.checkNotNull(lower);
            MathUtils.checkNotNull(upper);
            MathUtils.checkNotNull(scale);
            if (CallChecker.beforeDeref(lower, double[].class, 133, 6261, 6265)) {
                if (CallChecker.beforeDeref(upper, double[].class, 133, 6277, 6281)) {
                    if ((CallChecker.isCalled(lower, double[].class, 133, 6261, 6265).length) != (CallChecker.isCalled(upper, double[].class, 133, 6277, 6281).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 134, 6342, 6346)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 134, 6356, 6360)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 134, 6342, 6346).length, CallChecker.isCalled(upper, double[].class, 134, 6356, 6360).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(lower, double[].class, 136, 6393, 6397)) {
                if (CallChecker.beforeDeref(scale, double[].class, 136, 6409, 6413)) {
                    if ((CallChecker.isCalled(lower, double[].class, 136, 6393, 6397).length) != (CallChecker.isCalled(scale, double[].class, 136, 6409, 6413).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 137, 6474, 6478)) {
                            if (CallChecker.beforeDeref(scale, double[].class, 137, 6488, 6492)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 137, 6474, 6478).length, CallChecker.isCalled(scale, double[].class, 137, 6488, 6492).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(lower, double[].class, 139, 6541, 6545).length); ++i) {
                if (CallChecker.beforeDeref(upper, double[].class, 141, 6666, 6670)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 141, 6678, 6682)) {
                        if (!((CallChecker.isCalled(upper, double[].class, 141, 6666, 6670)[i]) >= (CallChecker.isCalled(lower, double[].class, 141, 6678, 6682)[i]))) {
                            if (CallChecker.beforeDeref(upper, double[].class, 142, 6743, 6747)) {
                                if (CallChecker.beforeDeref(lower, double[].class, 142, 6753, 6757)) {
                                    throw new NumberIsTooSmallException(CallChecker.isCalled(upper, double[].class, 142, 6743, 6747)[i], CallChecker.isCalled(lower, double[].class, 142, 6753, 6757)[i], true);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            this.bounded = bounded;
            CallChecker.varAssign(this.bounded, "this.bounded", 146, 6803, 6825);
            this.lower = CallChecker.isCalled(lower, double[].class, 147, 6850, 6854).clone();
            CallChecker.varAssign(this.lower, "this.lower", 147, 6835, 6863);
            this.upper = CallChecker.isCalled(upper, double[].class, 148, 6888, 6892).clone();
            CallChecker.varAssign(this.upper, "this.upper", 148, 6873, 6901);
            this.offset = offset;
            CallChecker.varAssign(this.offset, "this.offset", 149, 6911, 6932);
            this.scale = CallChecker.isCalled(scale, double[].class, 150, 6957, 6961).clone();
            CallChecker.varAssign(this.scale, "this.scale", 150, 6942, 6970);
        } finally {
            _bcornu_methode_context395.methodEnd();
        }
    }

    public double value(double[] point) {
        MethodContext _bcornu_methode_context1722 = new MethodContext(double.class, 164, 6984, 8424);
        try {
            CallChecker.varInit(this, "this", 164, 6984, 8424);
            CallChecker.varInit(point, "point", 164, 6984, 8424);
            CallChecker.varInit(this.scale, "scale", 164, 6984, 8424);
            CallChecker.varInit(this.offset, "offset", 164, 6984, 8424);
            CallChecker.varInit(this.upper, "upper", 164, 6984, 8424);
            CallChecker.varInit(this.lower, "lower", 164, 6984, 8424);
            CallChecker.varInit(this.bounded, "bounded", 164, 6984, 8424);
            for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 166, 7527, 7531).length); ++i) {
                if (CallChecker.beforeDeref(point, double[].class, 167, 7565, 7569)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 167, 7576, 7580)) {
                        if (CallChecker.beforeDeref(point, double[].class, 167, 7590, 7594)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 167, 7601, 7605)) {
                                point = CallChecker.beforeCalled(point, double[].class, 167, 7565, 7569);
                                point = CallChecker.beforeCalled(point, double[].class, 167, 7590, 7594);
                                if (((CallChecker.isCalled(point, double[].class, 167, 7565, 7569)[i]) < (CallChecker.isCalled(lower, double[].class, 167, 7576, 7580)[i])) || ((CallChecker.isCalled(point, double[].class, 167, 7590, 7594)[i]) > (CallChecker.isCalled(upper, double[].class, 167, 7601, 7605)[i]))) {
                                    double sum = CallChecker.varInit(((double) (0)), "sum", 169, 7692, 7706);
                                    for (int j = i; j < (CallChecker.isCalled(scale, double[].class, 170, 7744, 7748).length); ++j) {
                                        double overshoot = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(point, double[].class, 172, 7833, 7837)) {
                                            if (CallChecker.beforeDeref(lower, double[].class, 172, 7844, 7848)) {
                                                point = CallChecker.beforeCalled(point, double[].class, 172, 7833, 7837);
                                                if ((CallChecker.isCalled(point, double[].class, 172, 7833, 7837)[j]) < (CallChecker.isCalled(lower, double[].class, 172, 7844, 7848)[j])) {
                                                    if (CallChecker.beforeDeref(scale, double[].class, 173, 7892, 7896)) {
                                                        if (CallChecker.beforeDeref(lower, double[].class, 173, 7904, 7908)) {
                                                            if (CallChecker.beforeDeref(point, double[].class, 173, 7915, 7919)) {
                                                                point = CallChecker.beforeCalled(point, double[].class, 173, 7915, 7919);
                                                                overshoot = (CallChecker.isCalled(scale, double[].class, 173, 7892, 7896)[j]) * ((CallChecker.isCalled(lower, double[].class, 173, 7904, 7908)[j]) - (CallChecker.isCalled(point, double[].class, 173, 7915, 7919)[j]));
                                                                CallChecker.varAssign(overshoot, "overshoot", 173, 7880, 7924);
                                                            }
                                                        }
                                                    }
                                                }else
                                                    if (CallChecker.beforeDeref(point, double[].class, 174, 7957, 7961)) {
                                                        if (CallChecker.beforeDeref(upper, double[].class, 174, 7968, 7972)) {
                                                            point = CallChecker.beforeCalled(point, double[].class, 174, 7957, 7961);
                                                            if ((CallChecker.isCalled(point, double[].class, 174, 7957, 7961)[j]) > (CallChecker.isCalled(upper, double[].class, 174, 7968, 7972)[j])) {
                                                                if (CallChecker.beforeDeref(scale, double[].class, 175, 8016, 8020)) {
                                                                    if (CallChecker.beforeDeref(point, double[].class, 175, 8028, 8032)) {
                                                                        if (CallChecker.beforeDeref(upper, double[].class, 175, 8039, 8043)) {
                                                                            point = CallChecker.beforeCalled(point, double[].class, 175, 8028, 8032);
                                                                            overshoot = (CallChecker.isCalled(scale, double[].class, 175, 8016, 8020)[j]) * ((CallChecker.isCalled(point, double[].class, 175, 8028, 8032)[j]) - (CallChecker.isCalled(upper, double[].class, 175, 8039, 8043)[j]));
                                                                            CallChecker.varAssign(overshoot, "overshoot", 175, 8004, 8048);
                                                                        }
                                                                    }
                                                                }
                                                            }else {
                                                                overshoot = 0;
                                                                CallChecker.varAssign(overshoot, "overshoot", 177, 8103, 8116);
                                                            }
                                                        }
                                                    }
                                                
                                            }
                                        }
                                        sum += FastMath.sqrt(overshoot);
                                        CallChecker.varAssign(sum, "sum", 179, 8160, 8191);
                                    }
                                    return (offset) + sum;
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
            if (CallChecker.beforeDeref(bounded, MultivariateFunction.class, 187, 8397, 8403)) {
                return CallChecker.isCalled(bounded, MultivariateFunction.class, 187, 8397, 8403).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1722.methodEnd();
        }
    }
}

