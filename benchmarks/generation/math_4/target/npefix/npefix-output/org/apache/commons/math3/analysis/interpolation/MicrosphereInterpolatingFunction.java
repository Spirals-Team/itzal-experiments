package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math3.util.FastMath;

public class MicrosphereInterpolatingFunction implements MultivariateFunction {
    private static class MicrosphereSurfaceElement {
        private final RealVector normal;

        private double brightestIllumination;

        private Map.Entry<RealVector, Double> brightestSample;

        MicrosphereSurfaceElement(double[] n) {
            ConstructorContext _bcornu_methode_context1102 = new ConstructorContext(MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 77, 2720, 2935);
            try {
                normal = new ArrayRealVector(n);
                CallChecker.varAssign(this.normal, "this.normal", 78, 2894, 2925);
            } finally {
                _bcornu_methode_context1102.methodEnd();
            }
        }

        RealVector normal() {
            MethodContext _bcornu_methode_context4912 = new MethodContext(RealVector.class, 85, 2946, 3101);
            try {
                CallChecker.varInit(this, "this", 85, 2946, 3101);
                CallChecker.varInit(this.brightestSample, "brightestSample", 85, 2946, 3101);
                CallChecker.varInit(this.brightestIllumination, "brightestIllumination", 85, 2946, 3101);
                CallChecker.varInit(this.normal, "normal", 85, 2946, 3101);
                return normal;
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4912.methodEnd();
            }
        }

        void reset() {
            MethodContext _bcornu_methode_context4913 = new MethodContext(void.class, 92, 3112, 3285);
            try {
                CallChecker.varInit(this, "this", 92, 3112, 3285);
                CallChecker.varInit(this.brightestSample, "brightestSample", 92, 3112, 3285);
                CallChecker.varInit(this.brightestIllumination, "brightestIllumination", 92, 3112, 3285);
                CallChecker.varInit(this.normal, "normal", 92, 3112, 3285);
                brightestIllumination = 0;
                CallChecker.varAssign(this.brightestIllumination, "this.brightestIllumination", 93, 3214, 3239);
                brightestSample = null;
                CallChecker.varAssign(this.brightestSample, "this.brightestSample", 94, 3253, 3275);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4913.methodEnd();
            }
        }

        void store(final double illuminationFromSample, final Map.Entry<RealVector, Double> sample) {
            MethodContext _bcornu_methode_context4914 = new MethodContext(void.class, 102, 3296, 3851);
            try {
                CallChecker.varInit(this, "this", 102, 3296, 3851);
                CallChecker.varInit(sample, "sample", 102, 3296, 3851);
                CallChecker.varInit(illuminationFromSample, "illuminationFromSample", 102, 3296, 3851);
                CallChecker.varInit(this.brightestSample, "brightestSample", 102, 3296, 3851);
                CallChecker.varInit(this.brightestIllumination, "brightestIllumination", 102, 3296, 3851);
                CallChecker.varInit(this.normal, "normal", 102, 3296, 3851);
                if (illuminationFromSample > (this.brightestIllumination)) {
                    this.brightestIllumination = illuminationFromSample;
                    CallChecker.varAssign(this.brightestIllumination, "this.brightestIllumination", 105, 3729, 3780);
                    this.brightestSample = sample;
                    CallChecker.varAssign(this.brightestSample, "this.brightestSample", 106, 3798, 3827);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4914.methodEnd();
            }
        }

        double illumination() {
            MethodContext _bcornu_methode_context4915 = new MethodContext(double.class, 114, 3862, 4045);
            try {
                CallChecker.varInit(this, "this", 114, 3862, 4045);
                CallChecker.varInit(this.brightestSample, "brightestSample", 114, 3862, 4045);
                CallChecker.varInit(this.brightestIllumination, "brightestIllumination", 114, 3862, 4045);
                CallChecker.varInit(this.normal, "normal", 114, 3862, 4045);
                return brightestIllumination;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4915.methodEnd();
            }
        }

        Map.Entry<RealVector, Double> sample() {
            MethodContext _bcornu_methode_context4916 = new MethodContext(Map.Entry.class, 122, 4056, 4257);
            try {
                CallChecker.varInit(this, "this", 122, 4056, 4257);
                CallChecker.varInit(this.brightestSample, "brightestSample", 122, 4056, 4257);
                CallChecker.varInit(this.brightestIllumination, "brightestIllumination", 122, 4056, 4257);
                CallChecker.varInit(this.normal, "normal", 122, 4056, 4257);
                return brightestSample;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<RealVector, Double>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4916.methodEnd();
            }
        }
    }

    private final int dimension;

    private final List<MicrosphereInterpolatingFunction.MicrosphereSurfaceElement> microsphere;

    private final double brightnessExponent;

    private final Map<RealVector, Double> samples;

    public MicrosphereInterpolatingFunction(double[][] xval, double[] yval, int brightnessExponent, int microsphereElements, UnitSphereRandomVectorGenerator rand) throws DimensionMismatchException, NoDataException, NullArgumentException {
        ConstructorContext _bcornu_methode_context1103 = new ConstructorContext(MicrosphereInterpolatingFunction.class, 146, 4270, 7171);
        try {
            if ((xval == null) || (yval == null)) {
                throw new NullArgumentException();
            }
            if ((xval.length) == 0) {
                throw new NoDataException();
            }
            if ((xval.length) != (yval.length)) {
                throw new DimensionMismatchException(xval.length, yval.length);
            }
            if ((xval[0]) == null) {
                throw new NullArgumentException();
            }
            dimension = xval[0].length;
            CallChecker.varAssign(this.dimension, "this.dimension", 168, 6219, 6245);
            this.brightnessExponent = brightnessExponent;
            CallChecker.varAssign(this.brightnessExponent, "this.brightnessExponent", 169, 6255, 6299);
            samples = new HashMap<RealVector, Double>(yval.length);
            CallChecker.varAssign(this.samples, "this.samples", 172, 6340, 6394);
            for (int i = 0; i < (xval.length); ++i) {
                final double[] xvalI = CallChecker.varInit(xval[i], "xvalI", 174, 6456, 6486);
                if (xvalI == null) {
                    throw new NullArgumentException();
                }
                if ((xvalI.length) != (dimension)) {
                    throw new DimensionMismatchException(xvalI.length, dimension);
                }
                if (CallChecker.beforeDeref(samples, Map.class, 182, 6737, 6743)) {
                    CallChecker.isCalled(samples, Map.class, 182, 6737, 6743).put(new ArrayRealVector(xvalI), yval[i]);
                }
            }
            microsphere = new ArrayList<MicrosphereInterpolatingFunction.MicrosphereSurfaceElement>(microsphereElements);
            CallChecker.varAssign(this.microsphere, "this.microsphere", 185, 6806, 6881);
            for (int i = 0; i < microsphereElements; i++) {
                if (CallChecker.beforeDeref(rand, UnitSphereRandomVectorGenerator.class, 189, 7136, 7139)) {
                    if (CallChecker.beforeDeref(microsphere, List.class, 189, 7090, 7100)) {
                        rand = CallChecker.beforeCalled(rand, UnitSphereRandomVectorGenerator.class, 189, 7136, 7139);
                        CallChecker.isCalled(microsphere, List.class, 189, 7090, 7100).add(new MicrosphereInterpolatingFunction.MicrosphereSurfaceElement(CallChecker.isCalled(rand, UnitSphereRandomVectorGenerator.class, 189, 7136, 7139).nextVector()));
                    }
                }
            }
        } finally {
            _bcornu_methode_context1103.methodEnd();
        }
    }

    public double value(double[] point) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4917 = new MethodContext(double.class, 198, 7178, 8887);
        try {
            CallChecker.varInit(this, "this", 198, 7178, 8887);
            CallChecker.varInit(point, "point", 198, 7178, 8887);
            CallChecker.varInit(this.samples, "samples", 198, 7178, 8887);
            CallChecker.varInit(this.brightnessExponent, "brightnessExponent", 198, 7178, 8887);
            CallChecker.varInit(this.microsphere, "microsphere", 198, 7178, 8887);
            CallChecker.varInit(this.dimension, "dimension", 198, 7178, 8887);
            final RealVector p = CallChecker.varInit(new ArrayRealVector(point), "p", 199, 7436, 7483);
            if (CallChecker.beforeDeref(microsphere, double.class, 202, 7548, 7558)) {
                for (MicrosphereInterpolatingFunction.MicrosphereSurfaceElement md : microsphere) {
                    if (CallChecker.beforeDeref(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 203, 7575, 7576)) {
                        CallChecker.isCalled(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 203, 7575, 7576).reset();
                    }
                }
            }
            for (Map.Entry<RealVector, Double> sd : CallChecker.isCalled(samples, Map.class, 207, 7741, 7747).entrySet()) {
                final RealVector diff = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(sd, Map.Entry.class, 210, 7876, 7877).getKey(), RealVector.class, 210, 7876, 7886).subtract(p), "diff", 210, 7776, 7899);
                final double diffNorm = CallChecker.varInit(((double) (CallChecker.isCalled(diff, RealVector.class, 211, 7937, 7940).getNorm())), "diffNorm", 211, 7913, 7951);
                if ((FastMath.abs(diffNorm)) < (FastMath.ulp(1.0))) {
                    if (CallChecker.beforeDeref(sd, Map.Entry.class, 216, 8182, 8183)) {
                        return CallChecker.isCalled(((Double) (CallChecker.isCalled(sd, Map.Entry.class, 216, 8182, 8183).getValue())), double.class, 216, 8182, 8194);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(microsphere, double.class, 219, 8260, 8270)) {
                    for (MicrosphereInterpolatingFunction.MicrosphereSurfaceElement md : microsphere) {
                        final double w = CallChecker.varInit(((double) (FastMath.pow(diffNorm, (-(this.brightnessExponent))))), "w", 220, 8291, 8351);
                        if (CallChecker.beforeDeref(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 221, 8393, 8394)) {
                            if (CallChecker.beforeDeref(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 221, 8369, 8370)) {
                                CallChecker.isCalled(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 221, 8369, 8370).store(((cosAngle(diff, CallChecker.isCalled(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 221, 8393, 8394).normal())) * w), sd);
                            }
                        }
                    }
                }
            }
            double value = CallChecker.varInit(((double) (0)), "value", 227, 8488, 8504);
            double totalWeight = CallChecker.varInit(((double) (0)), "totalWeight", 228, 8514, 8536);
            if (CallChecker.beforeDeref(microsphere, double.class, 229, 8582, 8592)) {
                for (MicrosphereInterpolatingFunction.MicrosphereSurfaceElement md : microsphere) {
                    final double iV = CallChecker.varInit(((double) (CallChecker.isCalled(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 230, 8627, 8628).illumination())), "iV", 230, 8609, 8644);
                    final Map.Entry<RealVector, Double> sd = CallChecker.varInit(CallChecker.isCalled(md, MicrosphereInterpolatingFunction.MicrosphereSurfaceElement.class, 231, 8699, 8700).sample(), "sd", 231, 8658, 8710);
                    if (sd != null) {
                        value += iV * (sd.getValue());
                        CallChecker.varAssign(value, "value", 233, 8758, 8785);
                        totalWeight += iV;
                        CallChecker.varAssign(totalWeight, "totalWeight", 234, 8803, 8820);
                    }
                }
            }
            return value / totalWeight;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4917.methodEnd();
        }
    }

    private double cosAngle(final RealVector v, final RealVector w) {
        MethodContext _bcornu_methode_context4918 = new MethodContext(double.class, 248, 8894, 9227);
        try {
            CallChecker.varInit(this, "this", 248, 8894, 9227);
            CallChecker.varInit(w, "w", 248, 8894, 9227);
            CallChecker.varInit(v, "v", 248, 8894, 9227);
            CallChecker.varInit(this.samples, "samples", 248, 8894, 9227);
            CallChecker.varInit(this.brightnessExponent, "brightnessExponent", 248, 8894, 9227);
            CallChecker.varInit(this.microsphere, "microsphere", 248, 8894, 9227);
            CallChecker.varInit(this.dimension, "dimension", 248, 8894, 9227);
            return (CallChecker.isCalled(v, RealVector.class, 249, 9176, 9176).dotProduct(w)) / ((CallChecker.isCalled(v, RealVector.class, 249, 9195, 9195).getNorm()) * (CallChecker.isCalled(w, RealVector.class, 249, 9209, 9209).getNorm()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4918.methodEnd();
        }
    }
}

