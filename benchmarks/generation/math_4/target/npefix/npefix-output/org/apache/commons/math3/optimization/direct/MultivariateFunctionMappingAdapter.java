package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Logit;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

@Deprecated
public class MultivariateFunctionMappingAdapter implements MultivariateFunction {
    private interface Mapper {
        double unboundedToBounded(double y);

        double boundedToUnbounded(double x);
    }

    private static class NoBoundsMapper implements MultivariateFunctionMappingAdapter.Mapper {
        public NoBoundsMapper() {
            ConstructorContext _bcornu_methode_context464 = new ConstructorContext(MultivariateFunctionMappingAdapter.NoBoundsMapper.class, 207, 8428, 8506);
            try {
            } finally {
                _bcornu_methode_context464.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2036 = new MethodContext(double.class, 211, 8517, 8627);
            try {
                CallChecker.varInit(this, "this", 211, 8517, 8627);
                CallChecker.varInit(y, "y", 211, 8517, 8627);
                return y;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2036.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2037 = new MethodContext(double.class, 216, 8638, 8748);
            try {
                CallChecker.varInit(this, "this", 216, 8638, 8748);
                CallChecker.varInit(x, "x", 216, 8638, 8748);
                return x;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2037.methodEnd();
            }
        }
    }

    private static class LowerBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final double lower;

        public LowerBoundMapper(final double lower) {
            ConstructorContext _bcornu_methode_context465 = new ConstructorContext(MultivariateFunctionMappingAdapter.LowerBoundMapper.class, 231, 8941, 9107);
            try {
                this.lower = lower;
                CallChecker.varAssign(this.lower, "this.lower", 232, 9079, 9097);
            } finally {
                _bcornu_methode_context465.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2038 = new MethodContext(double.class, 236, 9118, 9250);
            try {
                CallChecker.varInit(this, "this", 236, 9118, 9250);
                CallChecker.varInit(y, "y", 236, 9118, 9250);
                CallChecker.varInit(this.lower, "lower", 236, 9118, 9250);
                return (lower) + (FastMath.exp(y));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2038.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2039 = new MethodContext(double.class, 241, 9261, 9393);
            try {
                CallChecker.varInit(this, "this", 241, 9261, 9393);
                CallChecker.varInit(x, "x", 241, 9261, 9393);
                CallChecker.varInit(this.lower, "lower", 241, 9261, 9393);
                return FastMath.log((x - (lower)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2039.methodEnd();
            }
        }
    }

    private static class UpperBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final double upper;

        public UpperBoundMapper(final double upper) {
            ConstructorContext _bcornu_methode_context466 = new ConstructorContext(MultivariateFunctionMappingAdapter.UpperBoundMapper.class, 256, 9588, 9754);
            try {
                this.upper = upper;
                CallChecker.varAssign(this.upper, "this.upper", 257, 9726, 9744);
            } finally {
                _bcornu_methode_context466.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2040 = new MethodContext(double.class, 261, 9765, 9898);
            try {
                CallChecker.varInit(this, "this", 261, 9765, 9898);
                CallChecker.varInit(y, "y", 261, 9765, 9898);
                CallChecker.varInit(this.upper, "upper", 261, 9765, 9898);
                return (upper) - (FastMath.exp((-y)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2040.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2041 = new MethodContext(double.class, 266, 9909, 10042);
            try {
                CallChecker.varInit(this, "this", 266, 9909, 10042);
                CallChecker.varInit(x, "x", 266, 9909, 10042);
                CallChecker.varInit(this.upper, "upper", 266, 9909, 10042);
                return -(FastMath.log(((upper) - x)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2041.methodEnd();
            }
        }
    }

    private static class LowerUpperBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final UnivariateFunction boundingFunction;

        private final UnivariateFunction unboundingFunction;

        public LowerUpperBoundMapper(final double lower, final double upper) {
            ConstructorContext _bcornu_methode_context467 = new ConstructorContext(MultivariateFunctionMappingAdapter.LowerUpperBoundMapper.class, 285, 10405, 10718);
            try {
                boundingFunction = new Sigmoid(lower, upper);
                CallChecker.varAssign(this.boundingFunction, "this.boundingFunction", 286, 10604, 10650);
                unboundingFunction = new Logit(lower, upper);
                CallChecker.varAssign(this.unboundingFunction, "this.unboundingFunction", 287, 10664, 10708);
            } finally {
                _bcornu_methode_context467.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2042 = new MethodContext(double.class, 291, 10729, 10863);
            try {
                CallChecker.varInit(this, "this", 291, 10729, 10863);
                CallChecker.varInit(y, "y", 291, 10729, 10863);
                CallChecker.varInit(this.unboundingFunction, "unboundingFunction", 291, 10729, 10863);
                CallChecker.varInit(this.boundingFunction, "boundingFunction", 291, 10729, 10863);
                if (CallChecker.beforeDeref(boundingFunction, UnivariateFunction.class, 292, 10828, 10843)) {
                    return CallChecker.isCalled(boundingFunction, UnivariateFunction.class, 292, 10828, 10843).value(y);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2042.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2043 = new MethodContext(double.class, 296, 10874, 11010);
            try {
                CallChecker.varInit(this, "this", 296, 10874, 11010);
                CallChecker.varInit(x, "x", 296, 10874, 11010);
                CallChecker.varInit(this.unboundingFunction, "unboundingFunction", 296, 10874, 11010);
                CallChecker.varInit(this.boundingFunction, "boundingFunction", 296, 10874, 11010);
                if (CallChecker.beforeDeref(unboundingFunction, UnivariateFunction.class, 297, 10973, 10990)) {
                    return CallChecker.isCalled(unboundingFunction, UnivariateFunction.class, 297, 10973, 10990).value(x);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2043.methodEnd();
            }
        }
    }

    private final MultivariateFunction bounded;

    private final MultivariateFunctionMappingAdapter.Mapper[] mappers;

    public MultivariateFunctionMappingAdapter(final MultivariateFunction bounded, final double[] lower, final double[] upper) {
        ConstructorContext _bcornu_methode_context468 = new ConstructorContext(MultivariateFunctionMappingAdapter.class, 99, 4286, 6488);
        try {
            MathUtils.checkNotNull(lower);
            MathUtils.checkNotNull(upper);
            if (CallChecker.beforeDeref(lower, double[].class, 105, 5148, 5152)) {
                if (CallChecker.beforeDeref(upper, double[].class, 105, 5164, 5168)) {
                    if ((CallChecker.isCalled(lower, double[].class, 105, 5148, 5152).length) != (CallChecker.isCalled(upper, double[].class, 105, 5164, 5168).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 106, 5229, 5233)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 106, 5243, 5247)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 106, 5229, 5233).length, CallChecker.isCalled(upper, double[].class, 106, 5243, 5247).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(lower, double[].class, 108, 5296, 5300).length); ++i) {
                if (CallChecker.beforeDeref(upper, double[].class, 110, 5421, 5425)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 110, 5433, 5437)) {
                        if (!((CallChecker.isCalled(upper, double[].class, 110, 5421, 5425)[i]) >= (CallChecker.isCalled(lower, double[].class, 110, 5433, 5437)[i]))) {
                            if (CallChecker.beforeDeref(upper, double[].class, 111, 5498, 5502)) {
                                if (CallChecker.beforeDeref(lower, double[].class, 111, 5508, 5512)) {
                                    throw new NumberIsTooSmallException(CallChecker.isCalled(upper, double[].class, 111, 5498, 5502)[i], CallChecker.isCalled(lower, double[].class, 111, 5508, 5512)[i], true);
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
            CallChecker.varAssign(this.bounded, "this.bounded", 115, 5558, 5580);
            this.mappers = new MultivariateFunctionMappingAdapter.Mapper[CallChecker.isCalled(lower, double[].class, 116, 5616, 5620).length];
            CallChecker.varAssign(this.mappers, "this.mappers", 116, 5590, 5629);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 117, 5659, 5665).length); ++i) {
                if (CallChecker.beforeDeref(lower, double[].class, 118, 5716, 5720)) {
                    if (Double.isInfinite(CallChecker.isCalled(lower, double[].class, 118, 5716, 5720)[i])) {
                        if (CallChecker.beforeDeref(upper, double[].class, 119, 5767, 5771)) {
                            if (Double.isInfinite(CallChecker.isCalled(upper, double[].class, 119, 5767, 5771)[i])) {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 121, 5873, 5879)) {
                                    CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 121, 5873, 5879)[i] = new MultivariateFunctionMappingAdapter.NoBoundsMapper();
                                    CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 121, 5873, 5879)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 121, 5873, 5879)[i]", 121, 5873, 5906);
                                }
                            }else {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 124, 6020, 6026)) {
                                    if (CallChecker.beforeDeref(upper, double[].class, 124, 6054, 6058)) {
                                        CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 124, 6020, 6026)[i] = new MultivariateFunctionMappingAdapter.UpperBoundMapper(CallChecker.isCalled(upper, double[].class, 124, 6054, 6058)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 124, 6020, 6026)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 124, 6020, 6026)[i]", 124, 6020, 6063);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(upper, double[].class, 127, 6142, 6146)) {
                            if (Double.isInfinite(CallChecker.isCalled(upper, double[].class, 127, 6142, 6146)[i])) {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 129, 6242, 6248)) {
                                    if (CallChecker.beforeDeref(lower, double[].class, 129, 6276, 6280)) {
                                        CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 129, 6242, 6248)[i] = new MultivariateFunctionMappingAdapter.LowerBoundMapper(CallChecker.isCalled(lower, double[].class, 129, 6276, 6280)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 129, 6242, 6248)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 129, 6242, 6248)[i]", 129, 6242, 6285);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 132, 6381, 6387)) {
                                    if (CallChecker.beforeDeref(lower, double[].class, 132, 6420, 6424)) {
                                        if (CallChecker.beforeDeref(upper, double[].class, 132, 6430, 6434)) {
                                            CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 132, 6381, 6387)[i] = new MultivariateFunctionMappingAdapter.LowerUpperBoundMapper(CallChecker.isCalled(lower, double[].class, 132, 6420, 6424)[i], CallChecker.isCalled(upper, double[].class, 132, 6430, 6434)[i]);
                                            CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 132, 6381, 6387)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 132, 6381, 6387)[i]", 132, 6381, 6439);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context468.methodEnd();
        }
    }

    public double[] unboundedToBounded(double[] point) {
        MethodContext _bcornu_methode_context2044 = new MethodContext(double[].class, 143, 6495, 6939);
        try {
            CallChecker.varInit(this, "this", 143, 6495, 6939);
            CallChecker.varInit(point, "point", 143, 6495, 6939);
            CallChecker.varInit(this.mappers, "mappers", 143, 6495, 6939);
            CallChecker.varInit(this.bounded, "bounded", 143, 6495, 6939);
            final double[] mapped = CallChecker.varInit(new double[CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 146, 6767, 6773).length], "mapped", 146, 6732, 6782);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6812, 6818).length); ++i) {
                if (CallChecker.beforeDeref(mapped, double[].class, 148, 6847, 6852)) {
                    if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 148, 6859, 6865)) {
                        if (CallChecker.beforeDeref(point, double[].class, 148, 6889, 6893)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 148, 6859, 6865)[i], MultivariateFunctionMappingAdapter.Mapper.class, 148, 6859, 6868)) {
                                point = CallChecker.beforeCalled(point, double[].class, 148, 6889, 6893);
                                CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 148, 6859, 6865)[i] = CallChecker.beforeCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 148, 6859, 6865)[i], MultivariateFunctionMappingAdapter.Mapper.class, 148, 6859, 6868);
                                CallChecker.isCalled(mapped, double[].class, 148, 6847, 6852)[i] = CallChecker.isCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 148, 6859, 6865)[i], MultivariateFunctionMappingAdapter.Mapper.class, 148, 6859, 6868).unboundedToBounded(CallChecker.isCalled(point, double[].class, 148, 6889, 6893)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(mapped, double[].class, 148, 6847, 6852)[i], "CallChecker.isCalled(mapped, double[].class, 148, 6847, 6852)[i]", 148, 6847, 6898);
                            }
                        }
                    }
                }
            }
            return mapped;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2044.methodEnd();
        }
    }

    public double[] boundedToUnbounded(double[] point) {
        MethodContext _bcornu_methode_context2045 = new MethodContext(double[].class, 159, 6946, 7390);
        try {
            CallChecker.varInit(this, "this", 159, 6946, 7390);
            CallChecker.varInit(point, "point", 159, 6946, 7390);
            CallChecker.varInit(this.mappers, "mappers", 159, 6946, 7390);
            CallChecker.varInit(this.bounded, "bounded", 159, 6946, 7390);
            final double[] mapped = CallChecker.varInit(new double[CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 162, 7218, 7224).length], "mapped", 162, 7183, 7233);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7263, 7269).length); ++i) {
                if (CallChecker.beforeDeref(mapped, double[].class, 164, 7298, 7303)) {
                    if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 164, 7310, 7316)) {
                        if (CallChecker.beforeDeref(point, double[].class, 164, 7340, 7344)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 164, 7310, 7316)[i], MultivariateFunctionMappingAdapter.Mapper.class, 164, 7310, 7319)) {
                                point = CallChecker.beforeCalled(point, double[].class, 164, 7340, 7344);
                                CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 164, 7310, 7316)[i] = CallChecker.beforeCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 164, 7310, 7316)[i], MultivariateFunctionMappingAdapter.Mapper.class, 164, 7310, 7319);
                                CallChecker.isCalled(mapped, double[].class, 164, 7298, 7303)[i] = CallChecker.isCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 164, 7310, 7316)[i], MultivariateFunctionMappingAdapter.Mapper.class, 164, 7310, 7319).boundedToUnbounded(CallChecker.isCalled(point, double[].class, 164, 7340, 7344)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(mapped, double[].class, 164, 7298, 7303)[i], "CallChecker.isCalled(mapped, double[].class, 164, 7298, 7303)[i]", 164, 7298, 7349);
                            }
                        }
                    }
                }
            }
            return mapped;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2045.methodEnd();
        }
    }

    public double value(double[] point) {
        MethodContext _bcornu_methode_context2046 = new MethodContext(double.class, 181, 7397, 7885);
        try {
            CallChecker.varInit(this, "this", 181, 7397, 7885);
            CallChecker.varInit(point, "point", 181, 7397, 7885);
            CallChecker.varInit(this.mappers, "mappers", 181, 7397, 7885);
            CallChecker.varInit(this.bounded, "bounded", 181, 7397, 7885);
            if (CallChecker.beforeDeref(bounded, MultivariateFunction.class, 182, 7839, 7845)) {
                return CallChecker.isCalled(bounded, MultivariateFunction.class, 182, 7839, 7845).value(unboundedToBounded(point));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2046.methodEnd();
        }
    }
}

