package org.apache.commons.math3.optimization.fitting;

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
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class GaussianFitter extends CurveFitter<Gaussian.Parametric> {
    public static class ParameterGuesser {
        private final double norm;

        private final double mean;

        private final double sigma;

        public ParameterGuesser(WeightedObservedPoint[] observations) {
            ConstructorContext _bcornu_methode_context61 = new ConstructorContext(GaussianFitter.ParameterGuesser.class, 148, 5173, 6150);
            try {
                if (observations == null) {
                    throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
                }
                if ((observations.length) < 3) {
                    throw new NumberIsTooSmallException(observations.length, 3, true);
                }
                final WeightedObservedPoint[] sorted = CallChecker.varInit(sortObservations(observations), "sorted", 156, 5923, 5992);
                final double[] params = CallChecker.varInit(basicGuess(sorted), "params", 157, 6006, 6048);
                norm = CallChecker.isCalled(params, double[].class, 159, 6070, 6075)[0];
                CallChecker.varAssign(this.norm, "this.norm", 159, 6063, 6079);
                mean = CallChecker.isCalled(params, double[].class, 160, 6100, 6105)[1];
                CallChecker.varAssign(this.mean, "this.mean", 160, 6093, 6109);
                sigma = CallChecker.isCalled(params, double[].class, 161, 6131, 6136)[2];
                CallChecker.varAssign(this.sigma, "this.sigma", 161, 6123, 6140);
            } finally {
                _bcornu_methode_context61.methodEnd();
            }
        }

        public double[] guess() {
            MethodContext _bcornu_methode_context240 = new MethodContext(double[].class, 174, 6161, 6542);
            try {
                CallChecker.varInit(this, "this", 174, 6161, 6542);
                CallChecker.varInit(this.sigma, "sigma", 174, 6161, 6542);
                CallChecker.varInit(this.mean, "mean", 174, 6161, 6542);
                CallChecker.varInit(this.norm, "norm", 174, 6161, 6542);
                return new double[]{ norm , mean , sigma };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context240.methodEnd();
            }
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] unsorted) {
            MethodContext _bcornu_methode_context242 = new MethodContext(WeightedObservedPoint[].class, 184, 6553, 8219);
            try {
                CallChecker.varInit(this, "this", 184, 6553, 8219);
                CallChecker.varInit(unsorted, "unsorted", 184, 6553, 8219);
                CallChecker.varInit(this.sigma, "sigma", 184, 6553, 8219);
                CallChecker.varInit(this.mean, "mean", 184, 6553, 8219);
                CallChecker.varInit(this.norm, "norm", 184, 6553, 8219);
                unsorted = CallChecker.beforeCalled(unsorted, WeightedObservedPoint[].class, 185, 6862, 6869);
                final WeightedObservedPoint[] observations = CallChecker.varInit(CallChecker.isCalled(unsorted, WeightedObservedPoint[].class, 185, 6862, 6869).clone(), "observations", 185, 6817, 6878);
                final Comparator<WeightedObservedPoint> cmp = new Comparator<WeightedObservedPoint>() {
                    public int compare(WeightedObservedPoint p1, WeightedObservedPoint p2) {
                        MethodContext _bcornu_methode_context241 = new MethodContext(int.class, 188, 7012, 8116);
                        try {
                            CallChecker.varInit(this, "this", 188, 7012, 8116);
                            CallChecker.varInit(p2, "p2", 188, 7012, 8116);
                            CallChecker.varInit(p1, "p1", 188, 7012, 8116);
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
                            _bcornu_methode_context241.methodEnd();
                        }
                    }
                };
                Arrays.sort(observations, cmp);
                return observations;
            } catch (ForceReturn _bcornu_return_t) {
                return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context242.methodEnd();
            }
        }

        private double[] basicGuess(WeightedObservedPoint[] points) {
            MethodContext _bcornu_methode_context243 = new MethodContext(double[].class, 232, 8230, 9370);
            try {
                CallChecker.varInit(this, "this", 232, 8230, 9370);
                CallChecker.varInit(points, "points", 232, 8230, 9370);
                CallChecker.varInit(this.sigma, "sigma", 232, 8230, 9370);
                CallChecker.varInit(this.mean, "mean", 232, 8230, 9370);
                CallChecker.varInit(this.norm, "norm", 232, 8230, 9370);
                final int maxYIdx = CallChecker.varInit(((int) (findMaxY(points))), "maxYIdx", 233, 8556, 8592);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 234, 8623, 8628);
                CallChecker.isCalled(points, WeightedObservedPoint[].class, 234, 8623, 8628)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 234, 8623, 8628)[maxYIdx], WeightedObservedPoint.class, 234, 8623, 8637);
                final double n = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 234, 8623, 8628)[maxYIdx], WeightedObservedPoint.class, 234, 8623, 8637).getY())), "n", 234, 8606, 8645);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 235, 8676, 8681);
                CallChecker.isCalled(points, WeightedObservedPoint[].class, 235, 8676, 8681)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 235, 8676, 8681)[maxYIdx], WeightedObservedPoint.class, 235, 8676, 8690);
                final double m = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 235, 8676, 8681)[maxYIdx], WeightedObservedPoint.class, 235, 8676, 8690).getX())), "m", 235, 8659, 8698);
                double fwhmApprox = CallChecker.init(double.class);
                TryContext _bcornu_try_context_1 = new TryContext(1, GaussianFitter.class, "org.apache.commons.math3.exception.OutOfRangeException");
                try {
                    final double halfY = CallChecker.varInit(((double) (n + ((m - n) / 2))), "halfY", 239, 8766, 8804);
                    final double fwhmX1 = CallChecker.varInit(((double) (interpolateXAtY(points, maxYIdx, (-1), halfY))), "fwhmX1", 240, 8822, 8887);
                    final double fwhmX2 = CallChecker.varInit(((double) (interpolateXAtY(points, maxYIdx, 1, halfY))), "fwhmX2", 241, 8905, 8969);
                    fwhmApprox = fwhmX2 - fwhmX1;
                    CallChecker.varAssign(fwhmApprox, "fwhmApprox", 242, 8987, 9015);
                } catch (OutOfRangeException e) {
                    _bcornu_try_context_1.catchStart(1);
                    if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 245, 9172, 9177)) {
                        if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 245, 9165, 9170)) {
                            points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177);
                            points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177).length) - 1)], WeightedObservedPoint.class, 245, 9165, 9189)) {
                                if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 245, 9200, 9205)) {
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205)[0], WeightedObservedPoint.class, 245, 9200, 9208)) {
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177);
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170);
                                        CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177).length) - 1)], WeightedObservedPoint.class, 245, 9165, 9189);
                                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205);
                                        CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205)[0] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205)[0], WeightedObservedPoint.class, 245, 9200, 9208);
                                        fwhmApprox = (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9165, 9170)[((CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9172, 9177).length) - 1)], WeightedObservedPoint.class, 245, 9165, 9189).getX()) - (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 245, 9200, 9205)[0], WeightedObservedPoint.class, 245, 9200, 9208).getX());
                                        CallChecker.varAssign(fwhmApprox, "fwhmApprox", 245, 9152, 9216);
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_1.finallyStart(1);
                }
                final double s = CallChecker.varInit(((double) (fwhmApprox / (2 * (FastMath.sqrt((2 * (FastMath.log(2)))))))), "s", 247, 9244, 9314);
                return new double[]{ n , m , s };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context243.methodEnd();
            }
        }

        private int findMaxY(WeightedObservedPoint[] points) {
            MethodContext _bcornu_methode_context244 = new MethodContext(int.class, 258, 9381, 9891);
            try {
                CallChecker.varInit(this, "this", 258, 9381, 9891);
                CallChecker.varInit(points, "points", 258, 9381, 9891);
                CallChecker.varInit(this.sigma, "sigma", 258, 9381, 9891);
                CallChecker.varInit(this.mean, "mean", 258, 9381, 9891);
                CallChecker.varInit(this.norm, "norm", 258, 9381, 9891);
                int maxYIdx = CallChecker.varInit(((int) (0)), "maxYIdx", 259, 9654, 9669);
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 260, 9703, 9708);
                for (int i = 1; i < (CallChecker.isCalled(points, WeightedObservedPoint[].class, 260, 9703, 9708).length); i++) {
                    if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 261, 9745, 9750)) {
                        points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750)[i], WeightedObservedPoint.class, 261, 9745, 9753)) {
                            if (CallChecker.beforeDeref(points, WeightedObservedPoint[].class, 261, 9764, 9769)) {
                                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769)[maxYIdx], WeightedObservedPoint.class, 261, 9764, 9778)) {
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750);
                                    CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750)[i] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750)[i], WeightedObservedPoint.class, 261, 9745, 9753);
                                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769);
                                    CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769)[maxYIdx] = CallChecker.beforeCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769)[maxYIdx], WeightedObservedPoint.class, 261, 9764, 9778);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9745, 9750)[i], WeightedObservedPoint.class, 261, 9745, 9753).getY()) > (CallChecker.isCalled(CallChecker.isCalled(points, WeightedObservedPoint[].class, 261, 9764, 9769)[maxYIdx], WeightedObservedPoint.class, 261, 9764, 9778).getY())) {
                                        maxYIdx = i;
                                        CallChecker.varAssign(maxYIdx, "maxYIdx", 262, 9810, 9821);
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
                _bcornu_methode_context244.methodEnd();
            }
        }

        private double interpolateXAtY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
            MethodContext _bcornu_methode_context245 = new MethodContext(double.class, 282, 9902, 11500);
            try {
                CallChecker.varInit(this, "this", 282, 9902, 11500);
                CallChecker.varInit(y, "y", 282, 9902, 11500);
                CallChecker.varInit(idxStep, "idxStep", 282, 9902, 11500);
                CallChecker.varInit(startIdx, "startIdx", 282, 9902, 11500);
                CallChecker.varInit(points, "points", 282, 9902, 11500);
                CallChecker.varInit(this.sigma, "sigma", 282, 9902, 11500);
                CallChecker.varInit(this.mean, "mean", 282, 9902, 11500);
                CallChecker.varInit(this.norm, "norm", 282, 9902, 11500);
                if (idxStep == 0) {
                    throw new ZeroException();
                }
                final WeightedObservedPoint[] twoPoints = CallChecker.varInit(getInterpolationPointsForY(points, startIdx, idxStep, y), "twoPoints", 290, 10958, 11072);
                final WeightedObservedPoint p1 = CallChecker.varInit(CallChecker.isCalled(twoPoints, WeightedObservedPoint[].class, 292, 11119, 11127)[0], "p1", 292, 11086, 11131);
                final WeightedObservedPoint p2 = CallChecker.varInit(CallChecker.isCalled(twoPoints, WeightedObservedPoint[].class, 293, 11178, 11186)[1], "p2", 293, 11145, 11190);
                if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 294, 11208, 11209)) {
                    if ((CallChecker.isCalled(p1, WeightedObservedPoint.class, 294, 11208, 11209).getY()) == y) {
                        if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 295, 11249, 11250)) {
                            return CallChecker.isCalled(p1, WeightedObservedPoint.class, 295, 11249, 11250).getX();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 297, 11290, 11291)) {
                    if ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 297, 11290, 11291).getY()) == y) {
                        if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 298, 11331, 11332)) {
                            return CallChecker.isCalled(p2, WeightedObservedPoint.class, 298, 11331, 11332).getX();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return (CallChecker.isCalled(p1, WeightedObservedPoint.class, 300, 11375, 11376).getX()) + (((y - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 300, 11394, 11395).getY())) * ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 300, 11408, 11409).getX()) - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 300, 11420, 11421).getX()))) / ((CallChecker.isCalled(p2, WeightedObservedPoint.class, 301, 11467, 11468).getY()) - (CallChecker.isCalled(p1, WeightedObservedPoint.class, 301, 11479, 11480).getY())));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context245.methodEnd();
            }
        }

        private WeightedObservedPoint[] getInterpolationPointsForY(WeightedObservedPoint[] points, int startIdx, int idxStep, double y) throws OutOfRangeException {
            MethodContext _bcornu_methode_context246 = new MethodContext(WeightedObservedPoint[].class, 319, 11511, 13760);
            try {
                CallChecker.varInit(this, "this", 319, 11511, 13760);
                CallChecker.varInit(y, "y", 319, 11511, 13760);
                CallChecker.varInit(idxStep, "idxStep", 319, 11511, 13760);
                CallChecker.varInit(startIdx, "startIdx", 319, 11511, 13760);
                CallChecker.varInit(points, "points", 319, 11511, 13760);
                CallChecker.varInit(this.sigma, "sigma", 319, 11511, 13760);
                CallChecker.varInit(this.mean, "mean", 319, 11511, 13760);
                CallChecker.varInit(this.norm, "norm", 319, 11511, 13760);
                if (idxStep == 0) {
                    throw new ZeroException();
                }
                points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 328, 12858, 12863);
                for (int i = startIdx; idxStep < 0 ? (i + idxStep) >= 0 : (i + idxStep) < (CallChecker.isCalled(points, WeightedObservedPoint[].class, 328, 12858, 12863).length); i += idxStep) {
                    CallChecker.varAssign(i, "i", 329, 12890, 12901);
                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 330, 12955, 12960);
                    final WeightedObservedPoint p1 = CallChecker.varInit(CallChecker.isCalled(points, WeightedObservedPoint[].class, 330, 12955, 12960)[i], "p1", 330, 12922, 12964);
                    points = CallChecker.beforeCalled(points, WeightedObservedPoint[].class, 331, 13015, 13020);
                    final WeightedObservedPoint p2 = CallChecker.varInit(CallChecker.isCalled(points, WeightedObservedPoint[].class, 331, 13015, 13020)[(i + idxStep)], "p2", 331, 12982, 13034);
                    if (CallChecker.beforeDeref(p1, WeightedObservedPoint.class, 332, 13069, 13070)) {
                        if (CallChecker.beforeDeref(p2, WeightedObservedPoint.class, 332, 13080, 13081)) {
                            if (isBetween(y, CallChecker.isCalled(p1, WeightedObservedPoint.class, 332, 13069, 13070).getY(), CallChecker.isCalled(p2, WeightedObservedPoint.class, 332, 13080, 13081).getY())) {
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
                _bcornu_methode_context246.methodEnd();
            }
        }

        private boolean isBetween(double value, double boundary1, double boundary2) {
            MethodContext _bcornu_methode_context247 = new MethodContext(boolean.class, 359, 13771, 14515);
            try {
                CallChecker.varInit(this, "this", 359, 13771, 14515);
                CallChecker.varInit(boundary2, "boundary2", 359, 13771, 14515);
                CallChecker.varInit(boundary1, "boundary1", 359, 13771, 14515);
                CallChecker.varInit(value, "value", 359, 13771, 14515);
                CallChecker.varInit(this.sigma, "sigma", 359, 13771, 14515);
                CallChecker.varInit(this.mean, "mean", 359, 13771, 14515);
                CallChecker.varInit(this.norm, "norm", 359, 13771, 14515);
                return ((value >= boundary1) && (value <= boundary2)) || ((value >= boundary2) && (value <= boundary1));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context247.methodEnd();
            }
        }
    }

    public GaussianFitter(DifferentiableMultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context62 = new ConstructorContext(GaussianFitter.class, 67, 2602, 2851);
        try {
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    public double[] fit(double[] initialGuess) {
        MethodContext _bcornu_methode_context250 = new MethodContext(double[].class, 84, 2858, 4347);
        try {
            CallChecker.varInit(this, "this", 84, 2858, 4347);
            CallChecker.varInit(initialGuess, "initialGuess", 84, 2858, 4347);
            final Gaussian.Parametric f = new Gaussian.Parametric() {
                @Override
                public double value(double x, double... p) {
                    MethodContext _bcornu_methode_context248 = new MethodContext(double.class, 87, 3371, 3752);
                    try {
                        CallChecker.varInit(this, "this", 87, 3371, 3752);
                        CallChecker.varInit(p, "p", 87, 3371, 3752);
                        CallChecker.varInit(x, "x", 87, 3371, 3752);
                        double v = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "v", 88, 3463, 3498);
                        TryContext _bcornu_try_context_2 = new TryContext(2, GaussianFitter.class, "org.apache.commons.math3.exception.NotStrictlyPositiveException");
                        try {
                            v = super.value(x, p);
                            CallChecker.varAssign(v, "v", 90, 3550, 3571);
                        } catch (NotStrictlyPositiveException e) {
                            _bcornu_try_context_2.catchStart(2);
                        } finally {
                            _bcornu_try_context_2.finallyStart(2);
                        }
                        return v;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context248.methodEnd();
                    }
                }

                @Override
                public double[] gradient(double x, double... p) {
                    MethodContext _bcornu_methode_context249 = new MethodContext(double[].class, 98, 3771, 4288);
                    try {
                        CallChecker.varInit(this, "this", 98, 3771, 4288);
                        CallChecker.varInit(p, "p", 98, 3771, 4288);
                        CallChecker.varInit(x, "x", 98, 3771, 4288);
                        double[] v = CallChecker.varInit(new double[]{ Double.POSITIVE_INFINITY , Double.POSITIVE_INFINITY , Double.POSITIVE_INFINITY }, "v", 99, 3868, 4031);
                        TryContext _bcornu_try_context_3 = new TryContext(3, GaussianFitter.class, "org.apache.commons.math3.exception.NotStrictlyPositiveException");
                        try {
                            v = super.gradient(x, p);
                            CallChecker.varAssign(v, "v", 103, 4083, 4107);
                        } catch (NotStrictlyPositiveException e) {
                            _bcornu_try_context_3.catchStart(3);
                        } finally {
                            _bcornu_try_context_3.finallyStart(3);
                        }
                        return v;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context249.methodEnd();
                    }
                }
            };
            return fit(f, initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context250.methodEnd();
        }
    }

    public double[] fit() {
        MethodContext _bcornu_methode_context251 = new MethodContext(double[].class, 120, 4354, 4697);
        try {
            CallChecker.varInit(this, "this", 120, 4354, 4697);
            final double[] guess = CallChecker.varInit(CallChecker.isCalled(new GaussianFitter.ParameterGuesser(getObservations()), GaussianFitter.ParameterGuesser.class, 121, 4615, 4655).guess(), "guess", 121, 4592, 4664);
            return fit(guess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context251.methodEnd();
        }
    }
}

