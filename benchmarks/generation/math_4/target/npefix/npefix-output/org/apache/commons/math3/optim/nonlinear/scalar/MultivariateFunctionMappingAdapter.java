package org.apache.commons.math3.optim.nonlinear.scalar;

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

public class MultivariateFunctionMappingAdapter implements MultivariateFunction {
    private interface Mapper {
        double unboundedToBounded(double y);

        double boundedToUnbounded(double x);
    }

    private static class NoBoundsMapper implements MultivariateFunctionMappingAdapter.Mapper {
        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2049 = new MethodContext(double.class, 206, 8637, 8747);
            try {
                CallChecker.varInit(this, "this", 206, 8637, 8747);
                CallChecker.varInit(y, "y", 206, 8637, 8747);
                return y;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2049.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2050 = new MethodContext(double.class, 211, 8758, 8868);
            try {
                CallChecker.varInit(this, "this", 211, 8758, 8868);
                CallChecker.varInit(x, "x", 211, 8758, 8868);
                return x;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2050.methodEnd();
            }
        }
    }

    private static class LowerBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final double lower;

        public LowerBoundMapper(final double lower) {
            ConstructorContext _bcornu_methode_context469 = new ConstructorContext(MultivariateFunctionMappingAdapter.LowerBoundMapper.class, 226, 9059, 9247);
            try {
                this.lower = lower;
                CallChecker.varAssign(this.lower, "this.lower", 227, 9219, 9237);
            } finally {
                _bcornu_methode_context469.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2051 = new MethodContext(double.class, 231, 9258, 9390);
            try {
                CallChecker.varInit(this, "this", 231, 9258, 9390);
                CallChecker.varInit(y, "y", 231, 9258, 9390);
                CallChecker.varInit(this.lower, "lower", 231, 9258, 9390);
                return (lower) + (FastMath.exp(y));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2051.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2052 = new MethodContext(double.class, 236, 9401, 9533);
            try {
                CallChecker.varInit(this, "this", 236, 9401, 9533);
                CallChecker.varInit(x, "x", 236, 9401, 9533);
                CallChecker.varInit(this.lower, "lower", 236, 9401, 9533);
                return FastMath.log((x - (lower)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2052.methodEnd();
            }
        }
    }

    private static class UpperBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final double upper;

        public UpperBoundMapper(final double upper) {
            ConstructorContext _bcornu_methode_context470 = new ConstructorContext(MultivariateFunctionMappingAdapter.UpperBoundMapper.class, 251, 9728, 9894);
            try {
                this.upper = upper;
                CallChecker.varAssign(this.upper, "this.upper", 252, 9866, 9884);
            } finally {
                _bcornu_methode_context470.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2053 = new MethodContext(double.class, 256, 9905, 10038);
            try {
                CallChecker.varInit(this, "this", 256, 9905, 10038);
                CallChecker.varInit(y, "y", 256, 9905, 10038);
                CallChecker.varInit(this.upper, "upper", 256, 9905, 10038);
                return (upper) - (FastMath.exp((-y)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2053.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2054 = new MethodContext(double.class, 261, 10049, 10182);
            try {
                CallChecker.varInit(this, "this", 261, 10049, 10182);
                CallChecker.varInit(x, "x", 261, 10049, 10182);
                CallChecker.varInit(this.upper, "upper", 261, 10049, 10182);
                return -(FastMath.log(((upper) - x)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2054.methodEnd();
            }
        }
    }

    private static class LowerUpperBoundMapper implements MultivariateFunctionMappingAdapter.Mapper {
        private final UnivariateFunction boundingFunction;

        private final UnivariateFunction unboundingFunction;

        public LowerUpperBoundMapper(final double lower, final double upper) {
            ConstructorContext _bcornu_methode_context471 = new ConstructorContext(MultivariateFunctionMappingAdapter.LowerUpperBoundMapper.class, 280, 10543, 10878);
            try {
                boundingFunction = new Sigmoid(lower, upper);
                CallChecker.varAssign(this.boundingFunction, "this.boundingFunction", 281, 10764, 10810);
                unboundingFunction = new Logit(lower, upper);
                CallChecker.varAssign(this.unboundingFunction, "this.unboundingFunction", 282, 10824, 10868);
            } finally {
                _bcornu_methode_context471.methodEnd();
            }
        }

        public double unboundedToBounded(final double y) {
            MethodContext _bcornu_methode_context2055 = new MethodContext(double.class, 286, 10889, 11023);
            try {
                CallChecker.varInit(this, "this", 286, 10889, 11023);
                CallChecker.varInit(y, "y", 286, 10889, 11023);
                CallChecker.varInit(this.unboundingFunction, "unboundingFunction", 286, 10889, 11023);
                CallChecker.varInit(this.boundingFunction, "boundingFunction", 286, 10889, 11023);
                if (CallChecker.beforeDeref(boundingFunction, UnivariateFunction.class, 287, 10988, 11003)) {
                    return CallChecker.isCalled(boundingFunction, UnivariateFunction.class, 287, 10988, 11003).value(y);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2055.methodEnd();
            }
        }

        public double boundedToUnbounded(final double x) {
            MethodContext _bcornu_methode_context2056 = new MethodContext(double.class, 291, 11034, 11170);
            try {
                CallChecker.varInit(this, "this", 291, 11034, 11170);
                CallChecker.varInit(x, "x", 291, 11034, 11170);
                CallChecker.varInit(this.unboundingFunction, "unboundingFunction", 291, 11034, 11170);
                CallChecker.varInit(this.boundingFunction, "boundingFunction", 291, 11034, 11170);
                if (CallChecker.beforeDeref(unboundingFunction, UnivariateFunction.class, 292, 11133, 11150)) {
                    return CallChecker.isCalled(unboundingFunction, UnivariateFunction.class, 292, 11133, 11150).value(x);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2056.methodEnd();
            }
        }
    }

    private final MultivariateFunction bounded;

    private final MultivariateFunctionMappingAdapter.Mapper[] mappers;

    public MultivariateFunctionMappingAdapter(final MultivariateFunction bounded, final double[] lower, final double[] upper) {
        ConstructorContext _bcornu_methode_context472 = new ConstructorContext(MultivariateFunctionMappingAdapter.class, 99, 4395, 6591);
        try {
            MathUtils.checkNotNull(lower);
            MathUtils.checkNotNull(upper);
            if (CallChecker.beforeDeref(lower, double[].class, 104, 5252, 5256)) {
                if (CallChecker.beforeDeref(upper, double[].class, 104, 5268, 5272)) {
                    if ((CallChecker.isCalled(lower, double[].class, 104, 5252, 5256).length) != (CallChecker.isCalled(upper, double[].class, 104, 5268, 5272).length)) {
                        if (CallChecker.beforeDeref(lower, double[].class, 105, 5333, 5337)) {
                            if (CallChecker.beforeDeref(upper, double[].class, 105, 5347, 5351)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(lower, double[].class, 105, 5333, 5337).length, CallChecker.isCalled(upper, double[].class, 105, 5347, 5351).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < (CallChecker.isCalled(lower, double[].class, 107, 5400, 5404).length); ++i) {
                if (CallChecker.beforeDeref(upper, double[].class, 109, 5525, 5529)) {
                    if (CallChecker.beforeDeref(lower, double[].class, 109, 5537, 5541)) {
                        if (!((CallChecker.isCalled(upper, double[].class, 109, 5525, 5529)[i]) >= (CallChecker.isCalled(lower, double[].class, 109, 5537, 5541)[i]))) {
                            if (CallChecker.beforeDeref(upper, double[].class, 110, 5602, 5606)) {
                                if (CallChecker.beforeDeref(lower, double[].class, 110, 5612, 5616)) {
                                    throw new NumberIsTooSmallException(CallChecker.isCalled(upper, double[].class, 110, 5602, 5606)[i], CallChecker.isCalled(lower, double[].class, 110, 5612, 5616)[i], true);
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
            CallChecker.varAssign(this.bounded, "this.bounded", 114, 5662, 5684);
            this.mappers = new MultivariateFunctionMappingAdapter.Mapper[CallChecker.isCalled(lower, double[].class, 115, 5720, 5724).length];
            CallChecker.varAssign(this.mappers, "this.mappers", 115, 5694, 5733);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 116, 5763, 5769).length); ++i) {
                if (CallChecker.beforeDeref(lower, double[].class, 117, 5820, 5824)) {
                    if (Double.isInfinite(CallChecker.isCalled(lower, double[].class, 117, 5820, 5824)[i])) {
                        if (CallChecker.beforeDeref(upper, double[].class, 118, 5871, 5875)) {
                            if (Double.isInfinite(CallChecker.isCalled(upper, double[].class, 118, 5871, 5875)[i])) {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 120, 5977, 5983)) {
                                    CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 120, 5977, 5983)[i] = new MultivariateFunctionMappingAdapter.NoBoundsMapper();
                                    CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 120, 5977, 5983)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 120, 5977, 5983)[i]", 120, 5977, 6010);
                                }
                            }else {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 123, 6124, 6130)) {
                                    if (CallChecker.beforeDeref(upper, double[].class, 123, 6158, 6162)) {
                                        CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 123, 6124, 6130)[i] = new MultivariateFunctionMappingAdapter.UpperBoundMapper(CallChecker.isCalled(upper, double[].class, 123, 6158, 6162)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 123, 6124, 6130)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 123, 6124, 6130)[i]", 123, 6124, 6167);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(upper, double[].class, 126, 6246, 6250)) {
                            if (Double.isInfinite(CallChecker.isCalled(upper, double[].class, 126, 6246, 6250)[i])) {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 128, 6346, 6352)) {
                                    if (CallChecker.beforeDeref(lower, double[].class, 128, 6380, 6384)) {
                                        CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 128, 6346, 6352)[i] = new MultivariateFunctionMappingAdapter.LowerBoundMapper(CallChecker.isCalled(lower, double[].class, 128, 6380, 6384)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 128, 6346, 6352)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 128, 6346, 6352)[i]", 128, 6346, 6389);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 131, 6485, 6491)) {
                                    if (CallChecker.beforeDeref(lower, double[].class, 131, 6524, 6528)) {
                                        if (CallChecker.beforeDeref(upper, double[].class, 131, 6534, 6538)) {
                                            CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 131, 6485, 6491)[i] = new MultivariateFunctionMappingAdapter.LowerUpperBoundMapper(CallChecker.isCalled(lower, double[].class, 131, 6524, 6528)[i], CallChecker.isCalled(upper, double[].class, 131, 6534, 6538)[i]);
                                            CallChecker.varAssign(CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 131, 6485, 6491)[i], "CallChecker.isCalled(this.mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 131, 6485, 6491)[i]", 131, 6485, 6543);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context472.methodEnd();
        }
    }

    public double[] unboundedToBounded(double[] point) {
        MethodContext _bcornu_methode_context2057 = new MethodContext(double[].class, 143, 6598, 7064);
        try {
            CallChecker.varInit(this, "this", 143, 6598, 7064);
            CallChecker.varInit(point, "point", 143, 6598, 7064);
            CallChecker.varInit(this.mappers, "mappers", 143, 6598, 7064);
            CallChecker.varInit(this.bounded, "bounded", 143, 6598, 7064);
            final double[] mapped = CallChecker.varInit(new double[CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 145, 6893, 6899).length], "mapped", 145, 6858, 6908);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 146, 6938, 6944).length); ++i) {
                if (CallChecker.beforeDeref(mapped, double[].class, 147, 6973, 6978)) {
                    if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6985, 6991)) {
                        if (CallChecker.beforeDeref(point, double[].class, 147, 7015, 7019)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6985, 6991)[i], MultivariateFunctionMappingAdapter.Mapper.class, 147, 6985, 6994)) {
                                point = CallChecker.beforeCalled(point, double[].class, 147, 7015, 7019);
                                CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6985, 6991)[i] = CallChecker.beforeCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6985, 6991)[i], MultivariateFunctionMappingAdapter.Mapper.class, 147, 6985, 6994);
                                CallChecker.isCalled(mapped, double[].class, 147, 6973, 6978)[i] = CallChecker.isCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 147, 6985, 6991)[i], MultivariateFunctionMappingAdapter.Mapper.class, 147, 6985, 6994).unboundedToBounded(CallChecker.isCalled(point, double[].class, 147, 7015, 7019)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(mapped, double[].class, 147, 6973, 6978)[i], "CallChecker.isCalled(mapped, double[].class, 147, 6973, 6978)[i]", 147, 6973, 7024);
                            }
                        }
                    }
                }
            }
            return mapped;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2057.methodEnd();
        }
    }

    public double[] boundedToUnbounded(double[] point) {
        MethodContext _bcornu_methode_context2058 = new MethodContext(double[].class, 159, 7071, 7537);
        try {
            CallChecker.varInit(this, "this", 159, 7071, 7537);
            CallChecker.varInit(point, "point", 159, 7071, 7537);
            CallChecker.varInit(this.mappers, "mappers", 159, 7071, 7537);
            CallChecker.varInit(this.bounded, "bounded", 159, 7071, 7537);
            final double[] mapped = CallChecker.varInit(new double[CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 161, 7366, 7372).length], "mapped", 161, 7331, 7381);
            for (int i = 0; i < (CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 162, 7411, 7417).length); ++i) {
                if (CallChecker.beforeDeref(mapped, double[].class, 163, 7446, 7451)) {
                    if (CallChecker.beforeDeref(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7458, 7464)) {
                        if (CallChecker.beforeDeref(point, double[].class, 163, 7488, 7492)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7458, 7464)[i], MultivariateFunctionMappingAdapter.Mapper.class, 163, 7458, 7467)) {
                                point = CallChecker.beforeCalled(point, double[].class, 163, 7488, 7492);
                                CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7458, 7464)[i] = CallChecker.beforeCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7458, 7464)[i], MultivariateFunctionMappingAdapter.Mapper.class, 163, 7458, 7467);
                                CallChecker.isCalled(mapped, double[].class, 163, 7446, 7451)[i] = CallChecker.isCalled(CallChecker.isCalled(mappers, MultivariateFunctionMappingAdapter.Mapper[].class, 163, 7458, 7464)[i], MultivariateFunctionMappingAdapter.Mapper.class, 163, 7458, 7467).boundedToUnbounded(CallChecker.isCalled(point, double[].class, 163, 7488, 7492)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(mapped, double[].class, 163, 7446, 7451)[i], "CallChecker.isCalled(mapped, double[].class, 163, 7446, 7451)[i]", 163, 7446, 7497);
                            }
                        }
                    }
                }
            }
            return mapped;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2058.methodEnd();
        }
    }

    public double value(double[] point) {
        MethodContext _bcornu_methode_context2059 = new MethodContext(double.class, 180, 7544, 8039);
        try {
            CallChecker.varInit(this, "this", 180, 7544, 8039);
            CallChecker.varInit(point, "point", 180, 7544, 8039);
            CallChecker.varInit(this.mappers, "mappers", 180, 7544, 8039);
            CallChecker.varInit(this.bounded, "bounded", 180, 7544, 8039);
            if (CallChecker.beforeDeref(bounded, MultivariateFunction.class, 181, 7993, 7999)) {
                return CallChecker.isCalled(bounded, MultivariateFunction.class, 181, 7993, 7999).value(unboundedToBounded(point));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2059.methodEnd();
        }
    }
}

