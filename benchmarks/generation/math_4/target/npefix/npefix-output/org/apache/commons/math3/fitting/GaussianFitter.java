package org.apache.commons.math3.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

public class GaussianFitter extends CurveFitter<Gaussian.Parametric> {
    public static class ParameterGuesser {
        private final double norm;

        private final double mean;

        private final double sigma;

        public ParameterGuesser(WeightedObservedPoint[] observations) {
            ConstructorContext _bcornu_methode_context63 = new ConstructorContext(GaussianFitter.ParameterGuesser.class, 144, 5133, 6110);
            try {
                if (observations == null) {
                    throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
                }
                if ((observations.length) < 3) {
                    throw new NumberIsTooSmallException(observations.length, 3, true);
                }
                final WeightedObservedPoint[] sorted = CallChecker.varInit(sortObservations(observations), "sorted", 152, 5883, 5952);
                final double[] params = CallChecker.varInit(basicGuess(sorted), "params", 153, 5966, 6008);
                norm = CallChecker.isCalled(params, double[].class, 155, 6030, 6035)[0];
                CallChecker.varAssign(this.norm, "this.norm", 155, 6023, 6039);
                mean = CallChecker.isCalled(params, double[].class, 156, 6060, 6065)[1];
                CallChecker.varAssign(this.mean, "this.mean", 156, 6053, 6069);
                sigma = CallChecker.isCalled(params, double[].class, 157, 6091, 6096)[2];
                CallChecker.varAssign(this.sigma, "this.sigma", 157, 6083, 6100);
            } finally {
                _bcornu_methode_context63.methodEnd();
            }
        }

        public double[] guess() {
            MethodContext _bcornu_methode_context252 = new MethodContext(double[].class, 170, 6121, 6502);
            try {
                CallChecker.varInit(this, "this", 170, 6121, 6502);
                CallChecker.varInit(this.sigma, "sigma", 170, 6121, 6502);
                CallChecker.varInit(this.mean, "mean", 170, 6121, 6502);
                CallChecker.varInit(this.norm, "norm", 170, 6121, 6502);
                return new double[]{ norm , mean , sigma };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context252.methodEnd();
            }
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] unsorted) {
            MethodContext _bcornu_methode_context254 = new MethodContext(WeightedObservedPoint[].class, 180, 6513, 8179);
            try {
                CallChecker.varInit(this, "this", 180, 6513, 8179);
                CallChecker.varInit(unsorted, "unsorted", 180, 6513, 8179);
                CallChecker.varInit(this.sigma, "sigma", 180, 6513, 8179);
                CallChecker.varInit(this.mean, "mean", 180, 6513, 8179);
                CallChecker.varInit(this.norm, "norm", 180, 6513, 8179);
                unsorted = CallChecker.beforeCalled(unsorted, WeightedObservedPoint[].class, 181, 6822, 6829);
                final WeightedObservedPoint[] observations = CallChecker.varInit(CallChecker.isCalled(unsorted, WeightedObservedPoint[].class, 181, 6822, 6829).clone(), "observations", 181, 6777, 6838);
                final Comparator<WeightedObservedPoint> cmp = new Comparator<WeightedObservedPoint>() {
                    public int compare(WeightedObservedPoint p1, WeightedObservedPoint p2) {
                        MethodContext _bcornu_methode_context253 = new MethodContext(int.class, 184, 6972, 8076);
                        try {
                            CallChecker.varInit(this, "this", 184, 6972, 8076);
                            CallChecker.varInit(p2, "p2", 184, 6972, 8076);
                            CallChecker.varInit(p1, "p1", 184, 6972, 8076);
                            if ((p1 == null) && (p2 == null)) {
                                return 0;
                            }
                            if (p1 == null) {
                                return -1;
                            }
                            if (p2 == null) {
                                return 1;
                            }
                            if ((p1.getX()) < (p2.getX())) {
                                return -1;
                            }
                            if ((p1.getX()) > (p2.getX())) {
                                return 1;
                            }
                            if ((p1.getY()) < (p2.getY())) {
                                return -1;
                            }
                            if ((p1.getY()) > (p2.getY())) {
                                return 1;
                            }
                            if ((p1.getWeight()) < (p2.getWeight())) {
                                return -1;
                            }
                            if ((p1.getWeight()) > (p2.getWeight())) {
                                return 1;
                            }
                            return 0;
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context253.methodEnd();
                        }
                    }
                };
                Arrays.sort(observations, cmp);
                return observations;
            } catch (ForceReturn _bcornu_return_t) {
                return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context254.methodEnd();
            }
        }

        private double[] basicGuess(WeightedObservedPoint[] points) {
            MethodContext _bcornu_methode_context255 = new MethodContext(double[].class, 228, 8190, 9330);
            try {
                CallChecker.varInit(this, "this", 228, 8190, 9330);
                CallChecker.varInit(points, "points", 228, 8190, 9330);
                CallChecker.varInit(this.sigma, "sigma", 228, 8190, 9330);
                CallChecker.varInit(this.mean, "mean", 228, 8190, 9330);
                CallChecker.varInit(this.norm, "norm", 228, 8190, 9330);
                final int maxYIdx = CallChecker.varInit(((int) (findMaxY(points))), "maxYIdx", 229, 8516, 8552);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 230, 8583, 8588);
                CallChecker.isCalled(points, WeightedObservedPoint[].class, 230, 8583, 8588)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 230, 8583, 8588)[maxYIdx], WeightedObservedPoint.class, 230, 8583, 8597);
                final double n = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 230, 8583, 8588)[maxYIdx], WeightedObservedPoint.class, 230, 8583, 8597).getY())), "n", 230, 8566, 8605);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 231, 8636, 8641);
                CallChecker.isCalled(points, WeightedObservedPoint[].class, 231, 8636, 8641)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 231, 8636, 8641)[maxYIdx], WeightedObservedPoint.class, 231, 8636, 8650);
                final double m = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 231, 8636, 8641)[maxYIdx], WeightedObservedPoint.class, 231, 8636, 8650).getX())), "m", 231, 8619, 8658);
                double fwhmApprox = CallChecker.init(double.class);
                TryContext _bcornu_try_context_4 = new TryContext(4, GaussianFitter.class, "org.apache.commons.math3.exception.OutOfRangeException");
                try {
                    final double halfY = CallChecker.varInit(((double) (n + ((m - n) / 2))), "halfY", 235, 8726, 8764);
                    final double fwhmX1 = CallChecker.varInit(((double) (interpolateXAtY(points, maxYIdx, (-1), halfY))), "fwhmX1", 236, 8782, 8847);
                    final double fwhmX2 = CallChecker.varInit(((double) (interpolateXAtY(points, maxYIdx, 1, halfY))), "fwhmX2", 237, 8865, 8929);
                    fwhmApprox = fwhmX2 - fwhmX1;
                    CallChecker.varAssign(fwhmApprox, "fwhmApprox", 238, 8947, 8975);
                } catch (OutOfRangeException e) {
                    _bcornu_try_context_4.catchStart(4);
                    if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 241, 9132, 9137)) {
                        if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 241, 9125, 9130)) {
                            points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137);
                            points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137).length) - 1)], WeightedObservedPoint.class, 241, 9125, 9149)) {
                                if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 241, 9160, 9165)) {
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165)[0], WeightedObservedPoint.class, 241, 9160, 9168)) {
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137);
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130);
                                        CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137).length) - 1)], WeightedObservedPoint.class, 241, 9125, 9149);
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165);
                                        CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165)[0] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165)[0], WeightedObservedPoint.class, 241, 9160, 9168);
                                        fwhmApprox = (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9125, 9130)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9132, 9137).length) - 1)], WeightedObservedPoint.class, 241, 9125, 9149).getX()) - (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 241, 9160, 9165)[0], WeightedObservedPoint.class, 241, 9160, 9168).getX());
                                        CallChecker.varAssign(fwhmApprox, "fwhmApprox", 241, 9112, 9176);
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_4.finallyStart(4);
                }
                final double s = CallChecker.varInit(((double) (fwhmApprox / (2 * (FastMath.sqrt((2 * (FastMath.log(2)))))))), "s", 243, 9204, 9274);
                return new double[]{ n , m , s };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context255.methodEnd();
            }
        }

        private int findMaxY(WeightedObservedPoint[] points) {
            MethodContext _bcornu_methode_context256 = new MethodContext(int.class, 254, 9341, 9851);
            try {
                CallChecker.varInit(this, "this", 254, 9341, 9851);
                CallChecker.varInit(points, "points", 254, 9341, 9851);
                CallChecker.varInit(this.sigma, "sigma", 254, 9341, 9851);
                CallChecker.varInit(this.mean, "mean", 254, 9341, 9851);
                CallChecker.varInit(this.norm, "norm", 254, 9341, 9851);
                int maxYIdx = CallChecker.varInit(((int) (0)), "maxYIdx", 255, 9614, 9629);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 256, 9663, 9668);
                for (int i = 1; i < (CallChecker.isCalled(points, WeightedObservedPoint[].class, 256, 9663, 9668).length); i++) {
                    if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 257, 9705, 9710)) {
                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710)[i], WeightedObservedPoint.class, 257, 9705, 9713)) {
                            if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 257, 9724, 9729)) {
                                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729)[maxYIdx], WeightedObservedPoint.class, 257, 9724, 9738)) {
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710);
                                    CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710)[i] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710)[i], WeightedObservedPoint.class, 257, 9705, 9713);
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729);
                                    CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729)[maxYIdx], WeightedObservedPoint.class, 257, 9724, 9738);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9705, 9710)[i], WeightedObservedPoint.class, 257, 9705, 9713).getY()) > (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 257, 9724, 9729)[maxYIdx], WeightedObservedPoint.class, 257, 9724, 9738).getY())) {
                                        maxYIdx = i;
                                        CallChecker.varAssign(maxYIdx, "maxYIdx", 258, 9770, 9781);
                                    }
                                }
                            }
                        }
                    }
                }
                return maxYIdx;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context256.methodEnd();
            }
        }

        private double interpolateXAtY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
            MethodContext _bcornu_methode_context257 = new MethodContext(double.class, 278, 9862, 11460);
            try {
                CallChecker.varInit(this, "this", 278, 9862, 11460);
                CallChecker.varInit(y, "y", 278, 9862, 11460);
                CallChecker.varInit(idxStep, "idxStep", 278, 9862, 11460);
                CallChecker.varInit(startIdx, "startIdx", 278, 9862, 11460);
                CallChecker.varInit(points, "points", 278, 9862, 11460);
                CallChecker.varInit(this.sigma, "sigma", 278, 9862, 11460);
                CallChecker.varInit(this.mean, "mean", 278, 9862, 11460);
                CallChecker.varInit(this.norm, "norm", 278, 9862, 11460);
                if (idxStep == 0) {
                    throw new ZeroException();
                }
                final WeightedObservedPoint[] twoPoints = CallChecker.varInit(getInterpolationPointsForY(points, startIdx, idxStep, y), "twoPoints", 286, 10918, 11032);
                final WeightedObservedPoint p1 = CallChecker.varInit(CallChecker.isCalled(twoPoints, WeightedObservedPoint[].class, 288, 11079, 11087)[0], "p1", 288, 11046, 11091);
                final WeightedObservedPoint p2 = CallChecker.varInit(CallChecker.isCalled(twoPoints, WeightedObservedPoint[].class, 289, 11138, 11146)[1], "p2", 289, 11105, 11150);
                if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 290, 11168, 11169)) {
                    if ((CallChecker.isCalled(p1, WeightedObservedPoint.class, 290, 11168, 11169).getY()) == y) {
                        if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 291, 11209, 11210)) {
                            return CallChecker.isCalled(p1, WeightedObservedPoint.class, 291, 11209, 11210).getX();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 293, 11250, 11251)) {
                    if ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 293, 11250, 11251).getY()) == y) {
                        if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 294, 11291, 11292)) {
                            return CallChecker.isCalled(p2, WeightedObservedPoint.class, 294, 11291, 11292).getX();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return (CallChecker.isCalled(p1, WeightedObservedPoint.class, 296, 11335, 11336).getX()) + (((y - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 296, 11354, 11355).getY())) * ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 296, 11368, 11369).getX()) - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 296, 11380, 11381).getX()))) / ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 297, 11427, 11428).getY()) - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 297, 11439, 11440).getY())));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context257.methodEnd();
            }
        }

        private WeightedObservedPoint[] getInterpolationPointsForY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
            MethodContext _bcornu_methode_context258 = new MethodContext(WeightedObservedPoint[].class, 315, 11471, 13720);
            try {
                CallChecker.varInit(this, "this", 315, 11471, 13720);
                CallChecker.varInit(y, "y", 315, 11471, 13720);
                CallChecker.varInit(idxStep, "idxStep", 315, 11471, 13720);
                CallChecker.varInit(startIdx, "startIdx", 315, 11471, 13720);
                CallChecker.varInit(points, "points", 315, 11471, 13720);
                CallChecker.varInit(this.sigma, "sigma", 315, 11471, 13720);
                CallChecker.varInit(this.mean, "mean", 315, 11471, 13720);
                CallChecker.varInit(this.norm, "norm", 315, 11471, 13720);
                if (idxStep == 0) {
                    throw new ZeroException();
                }
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 324, 12818, 12823);
                for (int i = startIdx; idxStep < 0 ? (i + idxStep) >= 0 : (i + idxStep) < (CallChecker.isCalled(points, WeightedObservedPoint[].class, 324, 12818, 12823).length); i += idxStep) {
                    CallChecker.varAssign(i, "i", 325, 12850, 12861);
                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 326, 12915, 12920);
                    final WeightedObservedPoint p1 = CallChecker.varInit(CallChecker.isCalled(points, WeightedObservedPoint[].class, 326, 12915, 12920)[i], "p1", 326, 12882, 12924);
                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 327, 12975, 12980);
                    final WeightedObservedPoint p2 = CallChecker.varInit(CallChecker.isCalled(points, WeightedObservedPoint[].class, 327, 12975, 12980)[(i + idxStep)], "p2", 327, 12942, 12994);
                    if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 328, 13029, 13030)) {
                        if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 328, 13040, 13041)) {
                            if (isBetween(y, CallChecker.isCalled(p1, WeightedObservedPoint.class, 328, 13029, 13030).getY(), CallChecker.isCalled(p2, WeightedObservedPoint.class, 328, 13040, 13041).getY())) {
                                if (idxStep < 0) {
                                    return new WeightedObservedPoint[]{ p2 , p1 };
                                }else {
                                    return new WeightedObservedPoint[]{ p1 , p2 };
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                throw new OutOfRangeException(y, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
            } catch (ForceReturn _bcornu_return_t) {
                return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context258.methodEnd();
            }
        }

        private boolean isBetween(double value, double boundary1, double boundary2) {
            MethodContext _bcornu_methode_context259 = new MethodContext(boolean.class, 355, 13731, 14475);
            try {
                CallChecker.varInit(this, "this", 355, 13731, 14475);
                CallChecker.varInit(boundary2, "boundary2", 355, 13731, 14475);
                CallChecker.varInit(boundary1, "boundary1", 355, 13731, 14475);
                CallChecker.varInit(value, "value", 355, 13731, 14475);
                CallChecker.varInit(this.sigma, "sigma", 355, 13731, 14475);
                CallChecker.varInit(this.mean, "mean", 355, 13731, 14475);
                CallChecker.varInit(this.norm, "norm", 355, 13731, 14475);
                return ((value >= boundary1) && (value <= boundary2)) || ((value >= boundary2) && (value <= boundary1));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context259.methodEnd();
            }
        }
    }

    public GaussianFitter(MultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context64 = new ConstructorContext(GaussianFitter.class, 63, 2576, 2811);
        try {
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public double[] fit(double[] initialGuess) {
        MethodContext _bcornu_methode_context262 = new MethodContext(double[].class, 80, 2818, 4307);
        try {
            CallChecker.varInit(this, "this", 80, 2818, 4307);
            CallChecker.varInit(initialGuess, "initialGuess", 80, 2818, 4307);
            final Gaussian.Parametric f = new Gaussian.Parametric() {
                @Override
                public double value(double x, double... p) {
                    MethodContext _bcornu_methode_context260 = new MethodContext(double.class, 83, 3331, 3712);
                    try {
                        CallChecker.varInit(this, "this", 83, 3331, 3712);
                        CallChecker.varInit(p, "p", 83, 3331, 3712);
                        CallChecker.varInit(x, "x", 83, 3331, 3712);
                        double v = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "v", 84, 3423, 3458);
                        TryContext _bcornu_try_context_5 = new TryContext(5, GaussianFitter.class, "org.apache.commons.math3.exception.NotStrictlyPositiveException");
                        try {
                            v = super.value(x, p);
                            CallChecker.varAssign(v, "v", 86, 3510, 3531);
                        } catch (NotStrictlyPositiveException e) {
                            _bcornu_try_context_5.catchStart(5);
                        } finally {
                            _bcornu_try_context_5.finallyStart(5);
                        }
                        return v;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context260.methodEnd();
                    }
                }

                @Override
                public double[] gradient(double x, double... p) {
                    MethodContext _bcornu_methode_context261 = new MethodContext(double[].class, 94, 3731, 4248);
                    try {
                        CallChecker.varInit(this, "this", 94, 3731, 4248);
                        CallChecker.varInit(p, "p", 94, 3731, 4248);
                        CallChecker.varInit(x, "x", 94, 3731, 4248);
                        double[] v = CallChecker.varInit(new double[]{ Double.POSITIVE_INFINITY , Double.POSITIVE_INFINITY , Double.POSITIVE_INFINITY }, "v", 95, 3828, 3991);
                        TryContext _bcornu_try_context_6 = new TryContext(6, GaussianFitter.class, "org.apache.commons.math3.exception.NotStrictlyPositiveException");
                        try {
                            v = super.gradient(x, p);
                            CallChecker.varAssign(v, "v", 99, 4043, 4067);
                        } catch (NotStrictlyPositiveException e) {
                            _bcornu_try_context_6.catchStart(6);
                        } finally {
                            _bcornu_try_context_6.finallyStart(6);
                        }
                        return v;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context261.methodEnd();
                    }
                }
            };
            return fit(f, initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context262.methodEnd();
        }
    }

    public double[] fit() {
        MethodContext _bcornu_methode_context263 = new MethodContext(double[].class, 116, 4314, 4657);
        try {
            CallChecker.varInit(this, "this", 116, 4314, 4657);
            final double[] guess = CallChecker.varInit(CallChecker.isCalled(new GaussianFitter.ParameterGuesser(getObservations()), GaussianFitter.ParameterGuesser.class, 117, 4575, 4615).guess(), "guess", 117, 4552, 4624);
            return fit(guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context263.methodEnd();
        }
    }
}

