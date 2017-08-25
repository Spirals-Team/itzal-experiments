package org.apache.commons.math3.optim.nonlinear.scalar;

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

public class MultivariateFunctionPenaltyAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;

    private final double[] lower;

    private final double[] upper;

    private final double offset;

    private final double[] scale;

    public MultivariateFunctionPenaltyAdapter(final MultivariateFunction bounded, final double[] lower, final double[] upper, final double offset, final double[] scale) {
        ConstructorContext _bcornu_methode_context396 = new ConstructorContext(MultivariateFunctionPenaltyAdapter.class, 123, 3686, 7083);
        try {
            MathUtils.checkNotNull(lower);
            MathUtils.checkNotNull(upper);
            MathUtils.checkNotNull(scale);
            if (CallChecker.beforeDeref(lower, double[].class, 131, 6368, 6372)) {
                if (CallChecker.beforeDeref(upper, double[].class, 131, 6384, 6388)) {
                    if ((CallChecker.isCalled(lower, double[].class, 131, 6368, 6372).length) != (CallChecker.isCalled(upper, double[].class, 131, 6384, 6388).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 132, 6449, 6453)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 132, 6463, 6467)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 132, 6449, 6453).length, CallChecker.isCalled(upper, double[].class, 132, 6463, 6467).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(lower, double[].class, 134, 6500, 6504)) {
                if (CallChecker.beforeDeref(scale, double[].class, 134, 6516, 6520)) {
                    if ((CallChecker.isCalled(lower, double[].class, 134, 6500, 6504).length) != (CallChecker.isCalled(scale, double[].class, 134, 6516, 6520).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 135, 6581, 6585)) {
                            if (CallChecker.beforeDeref(scale, double[].class, 135, 6595, 6599)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 135, 6581, 6585).length, CallChecker.isCalled(scale, double[].class, 135, 6595, 6599).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(lower, double[].class, 137, 6648, 6652).length); ++i) {
                if (CallChecker.beforeDeref(upper, double[].class, 139, 6773, 6777)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 139, 6785, 6789)) {
                        if (!((CallChecker.isCalled(upper, double[].class, 139, 6773, 6777)[i]) >= (CallChecker.isCalled(lower, double[].class, 139, 6785, 6789)[i]))) {
                            if (CallChecker.beforeDeref(upper, double[].class, 140, 6850, 6854)) {
                                if (CallChecker.beforeDeref(lower, double[].class, 140, 6860, 6864)) {
                                    throw new NumberIsTooSmallException(CallChecker.isCalled(upper, double[].class, 140, 6850, 6854)[i], CallChecker.isCalled(lower, double[].class, 140, 6860, 6864)[i], true);
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
            CallChecker.varAssign(this.bounded, "this.bounded", 144, 6910, 6932);
            this.lower = CallChecker.isCalled(lower, double[].class, 145, 6957, 6961).clone();
            CallChecker.varAssign(this.lower, "this.lower", 145, 6942, 6970);
            this.upper = CallChecker.isCalled(upper, double[].class, 146, 6995, 6999).clone();
            CallChecker.varAssign(this.upper, "this.upper", 146, 6980, 7008);
            this.offset = offset;
            CallChecker.varAssign(this.offset, "this.offset", 147, 7018, 7039);
            this.scale = CallChecker.isCalled(scale, double[].class, 148, 7064, 7068).clone();
            CallChecker.varAssign(this.scale, "this.scale", 148, 7049, 7077);
        } finally {
            _bcornu_methode_context396.methodEnd();
        }
    }

    public double value(double[] point) {
        MethodContext _bcornu_methode_context1723 = new MethodContext(double.class, 162, 7090, 8537);
        try {
            CallChecker.varInit(this, "this", 162, 7090, 8537);
            CallChecker.varInit(point, "point", 162, 7090, 8537);
            CallChecker.varInit(this.scale, "scale", 162, 7090, 8537);
            CallChecker.varInit(this.offset, "offset", 162, 7090, 8537);
            CallChecker.varInit(this.upper, "upper", 162, 7090, 8537);
            CallChecker.varInit(this.lower, "lower", 162, 7090, 8537);
            CallChecker.varInit(this.bounded, "bounded", 162, 7090, 8537);
            for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 164, 7641, 7645).length); ++i) {
                if (CallChecker.beforeDeref(point, double[].class, 165, 7679, 7683)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 165, 7690, 7694)) {
                        if (CallChecker.beforeDeref(point, double[].class, 165, 7704, 7708)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 165, 7715, 7719)) {
                                point = CallChecker.beforeCalled(point, double[].class, 165, 7679, 7683);
                                point = CallChecker.beforeCalled(point, double[].class, 165, 7704, 7708);
                                if (((CallChecker.isCalled(point, double[].class, 165, 7679, 7683)[i]) < (CallChecker.isCalled(lower, double[].class, 165, 7690, 7694)[i])) || ((CallChecker.isCalled(point, double[].class, 165, 7704, 7708)[i]) > (CallChecker.isCalled(upper, double[].class, 165, 7715, 7719)[i]))) {
                                    double sum = CallChecker.varInit(((double) (0)), "sum", 167, 7806, 7820);
                                    for (int j = i; j < (CallChecker.isCalled(scale, double[].class, 168, 7858, 7862).length); ++j) {
                                        double overshoot = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(point, double[].class, 170, 7947, 7951)) {
                                            if (CallChecker.beforeDeref(lower, double[].class, 170, 7958, 7962)) {
                                                point = CallChecker.beforeCalled(point, double[].class, 170, 7947, 7951);
                                                if ((CallChecker.isCalled(point, double[].class, 170, 7947, 7951)[j]) < (CallChecker.isCalled(lower, double[].class, 170, 7958, 7962)[j])) {
                                                    if (CallChecker.beforeDeref(scale, double[].class, 171, 8006, 8010)) {
                                                        if (CallChecker.beforeDeref(lower, double[].class, 171, 8018, 8022)) {
                                                            if (CallChecker.beforeDeref(point, double[].class, 171, 8029, 8033)) {
                                                                point = CallChecker.beforeCalled(point, double[].class, 171, 8029, 8033);
                                                                overshoot = (CallChecker.isCalled(scale, double[].class, 171, 8006, 8010)[j]) * ((CallChecker.isCalled(lower, double[].class, 171, 8018, 8022)[j]) - (CallChecker.isCalled(point, double[].class, 171, 8029, 8033)[j]));
                                                                CallChecker.varAssign(overshoot, "overshoot", 171, 7994, 8038);
                                                            }
                                                        }
                                                    }
                                                }else
                                                    if (CallChecker.beforeDeref(point, double[].class, 172, 8071, 8075)) {
                                                        if (CallChecker.beforeDeref(upper, double[].class, 172, 8082, 8086)) {
                                                            point = CallChecker.beforeCalled(point, double[].class, 172, 8071, 8075);
                                                            if ((CallChecker.isCalled(point, double[].class, 172, 8071, 8075)[j]) > (CallChecker.isCalled(upper, double[].class, 172, 8082, 8086)[j])) {
                                                                if (CallChecker.beforeDeref(scale, double[].class, 173, 8130, 8134)) {
                                                                    if (CallChecker.beforeDeref(point, double[].class, 173, 8142, 8146)) {
                                                                        if (CallChecker.beforeDeref(upper, double[].class, 173, 8153, 8157)) {
                                                                            point = CallChecker.beforeCalled(point, double[].class, 173, 8142, 8146);
                                                                            overshoot = (CallChecker.isCalled(scale, double[].class, 173, 8130, 8134)[j]) * ((CallChecker.isCalled(point, double[].class, 173, 8142, 8146)[j]) - (CallChecker.isCalled(upper, double[].class, 173, 8153, 8157)[j]));
                                                                            CallChecker.varAssign(overshoot, "overshoot", 173, 8118, 8162);
                                                                        }
                                                                    }
                                                                }
                                                            }else {
                                                                overshoot = 0;
                                                                CallChecker.varAssign(overshoot, "overshoot", 175, 8217, 8230);
                                                            }
                                                        }
                                                    }
                                                
                                            }
                                        }
                                        sum += FastMath.sqrt(overshoot);
                                        CallChecker.varAssign(sum, "sum", 177, 8274, 8305);
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
            if (CallChecker.beforeDeref(bounded, MultivariateFunction.class, 185, 8511, 8517)) {
                return CallChecker.isCalled(bounded, MultivariateFunction.class, 185, 8511, 8517).value(point);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1723.methodEnd();
        }
    }
}

