package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class LoessInterpolator implements Serializable , UnivariateInterpolator {
    public static final double DEFAULT_BANDWIDTH = 0.3;

    public static final int DEFAULT_ROBUSTNESS_ITERS = 2;

    public static final double DEFAULT_ACCURACY = 1.0E-12;

    private static final long serialVersionUID = 5204927143605193821L;

    private final double bandwidth;

    private final int robustnessIters;

    private final double accuracy;

    public LoessInterpolator() {
        ConstructorContext _bcornu_methode_context183 = new ConstructorContext(LoessInterpolator.class, 95, 3619, 4136);
        try {
            this.bandwidth = LoessInterpolator.DEFAULT_BANDWIDTH;
            CallChecker.varAssign(this.bandwidth, "this.bandwidth", 96, 3997, 4031);
            this.robustnessIters = LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS;
            CallChecker.varAssign(this.robustnessIters, "this.robustnessIters", 97, 4041, 4088);
            this.accuracy = LoessInterpolator.DEFAULT_ACCURACY;
            CallChecker.varAssign(this.accuracy, "this.accuracy", 98, 4098, 4130);
        } finally {
            _bcornu_methode_context183.methodEnd();
        }
    }

    public LoessInterpolator(double bandwidth, int robustnessIters) {
        this(bandwidth, robustnessIters, LoessInterpolator.DEFAULT_ACCURACY);
        ConstructorContext _bcornu_methode_context184 = new ConstructorContext(LoessInterpolator.class, 123, 4143, 5271);
        try {
        } finally {
            _bcornu_methode_context184.methodEnd();
        }
    }

    public LoessInterpolator(double bandwidth, int robustnessIters, double accuracy) throws NotPositiveException, OutOfRangeException {
        ConstructorContext _bcornu_methode_context185 = new ConstructorContext(LoessInterpolator.class, 148, 5278, 6946);
        try {
            if ((bandwidth < 0) || (bandwidth > 1)) {
                throw new OutOfRangeException(LocalizedFormats.BANDWIDTH, bandwidth, 0, 1);
            }
            this.bandwidth = bandwidth;
            CallChecker.varAssign(this.bandwidth, "this.bandwidth", 155, 6686, 6712);
            if (robustnessIters < 0) {
                throw new NotPositiveException(LocalizedFormats.ROBUSTNESS_ITERATIONS, robustnessIters);
            }
            this.robustnessIters = robustnessIters;
            CallChecker.varAssign(this.robustnessIters, "this.robustnessIters", 159, 6868, 6906);
            this.accuracy = accuracy;
            CallChecker.varAssign(this.accuracy, "this.accuracy", 160, 6916, 6940);
        } finally {
            _bcornu_methode_context185.methodEnd();
        }
    }

    public final PolynomialSplineFunction interpolate(final double[] xval, final double[] yval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NotFiniteNumberException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context685 = new MethodContext(PolynomialSplineFunction.class, 184, 6953, 8466);
        try {
            CallChecker.varInit(this, "this", 184, 6953, 8466);
            CallChecker.varInit(yval, "yval", 184, 6953, 8466);
            CallChecker.varInit(xval, "xval", 184, 6953, 8466);
            CallChecker.varInit(this.accuracy, "accuracy", 184, 6953, 8466);
            CallChecker.varInit(this.robustnessIters, "robustnessIters", 184, 6953, 8466);
            CallChecker.varInit(this.bandwidth, "bandwidth", 184, 6953, 8466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 184, 6953, 8466);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 184, 6953, 8466);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 184, 6953, 8466);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 184, 6953, 8466);
            if (CallChecker.beforeDeref(new SplineInterpolator(), SplineInterpolator.class, 191, 8398, 8421)) {
                return CallChecker.isCalled(new SplineInterpolator(), SplineInterpolator.class, 191, 8398, 8421).interpolate(xval, smooth(xval, yval));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolynomialSplineFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context685.methodEnd();
        }
    }

    public final double[] smooth(final double[] xval, final double[] yval, final double[] weights) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NotFiniteNumberException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context686 = new MethodContext(double[].class, 214, 8473, 15088);
        try {
            CallChecker.varInit(this, "this", 214, 8473, 15088);
            CallChecker.varInit(weights, "weights", 214, 8473, 15088);
            CallChecker.varInit(yval, "yval", 214, 8473, 15088);
            CallChecker.varInit(xval, "xval", 214, 8473, 15088);
            CallChecker.varInit(this.accuracy, "accuracy", 214, 8473, 15088);
            CallChecker.varInit(this.robustnessIters, "robustnessIters", 214, 8473, 15088);
            CallChecker.varInit(this.bandwidth, "bandwidth", 214, 8473, 15088);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 214, 8473, 15088);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 214, 8473, 15088);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 214, 8473, 15088);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 214, 8473, 15088);
            if (CallChecker.beforeDeref(xval, double[].class, 221, 9815, 9818)) {
                if (CallChecker.beforeDeref(yval, double[].class, 221, 9830, 9833)) {
                    if ((CallChecker.isCalled(xval, double[].class, 221, 9815, 9818).length) != (CallChecker.isCalled(yval, double[].class, 221, 9830, 9833).length)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 222, 9894, 9897)) {
                            if (CallChecker.beforeDeref(yval, double[].class, 222, 9907, 9910)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xval, double[].class, 222, 9894, 9897).length, CallChecker.isCalled(yval, double[].class, 222, 9907, 9910).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(xval, double[].class, 225, 9954, 9957).length)), "n", 225, 9940, 9965);
            if (n == 0) {
                throw new NoDataException();
            }
            LoessInterpolator.checkAllFiniteReal(xval);
            LoessInterpolator.checkAllFiniteReal(yval);
            LoessInterpolator.checkAllFiniteReal(weights);
            MathArrays.checkOrder(xval);
            if (n == 1) {
                if (CallChecker.beforeDeref(yval, double[].class, 238, 10240, 10243)) {
                    return new double[]{ CallChecker.isCalled(yval, double[].class, 238, 10240, 10243)[0] };
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (n == 2) {
                if (CallChecker.beforeDeref(yval, double[].class, 242, 10315, 10318)) {
                    if (CallChecker.beforeDeref(yval, double[].class, 242, 10324, 10327)) {
                        return new double[]{ CallChecker.isCalled(yval, double[].class, 242, 10315, 10318)[0] , CallChecker.isCalled(yval, double[].class, 242, 10324, 10327)[1] };
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            int bandwidthInPoints = CallChecker.varInit(((int) ((int) ((this.bandwidth) * n))), "bandwidthInPoints", 245, 10353, 10398);
            if (bandwidthInPoints < 2) {
                throw new NumberIsTooSmallException(LocalizedFormats.BANDWIDTH, bandwidthInPoints, 2, true);
            }
            final double[] res = CallChecker.varInit(new double[n], "res", 252, 10610, 10644);
            final double[] residuals = CallChecker.varInit(new double[n], "residuals", 254, 10655, 10695);
            final double[] sortedResiduals = CallChecker.varInit(new double[n], "sortedResiduals", 255, 10705, 10751);
            final double[] robustnessWeights = CallChecker.varInit(new double[n], "robustnessWeights", 257, 10762, 10810);
            Arrays.fill(robustnessWeights, 1);
            for (int iter = 0; iter <= (robustnessIters); ++iter) {
                final int[] bandwidthInterval = CallChecker.varInit(new int[]{ 0 , bandwidthInPoints - 1 }, "bandwidthInterval", 265, 11144, 11202);
                for (int i = 0; i < n; ++i) {
                    final double x = CallChecker.varInit(((double) (CallChecker.isCalled(xval, double[].class, 268, 11348, 11351)[i])), "x", 268, 11331, 11355);
                    if (i > 0) {
                        LoessInterpolator.updateBandwidthInterval(xval, weights, i, bandwidthInterval);
                    }
                    final int ileft = CallChecker.varInit(((int) (CallChecker.isCalled(bandwidthInterval, int[].class, 276, 11636, 11652)[0])), "ileft", 276, 11618, 11656);
                    final int iright = CallChecker.varInit(((int) (CallChecker.isCalled(bandwidthInterval, int[].class, 277, 11693, 11709)[1])), "iright", 277, 11674, 11713);
                    int edge = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(xval, double[].class, 282, 11874, 11877)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 282, 11884, 11887)) {
                            if (CallChecker.beforeDeref(xval, double[].class, 282, 11898, 11901)) {
                                if (CallChecker.beforeDeref(xval, double[].class, 282, 11913, 11916)) {
                                    if (((CallChecker.isCalled(xval, double[].class, 282, 11874, 11877)[i]) - (CallChecker.isCalled(xval, double[].class, 282, 11884, 11887)[ileft])) > ((CallChecker.isCalled(xval, double[].class, 282, 11898, 11901)[iright]) - (CallChecker.isCalled(xval, double[].class, 282, 11913, 11916)[i]))) {
                                        edge = ileft;
                                        CallChecker.varAssign(edge, "edge", 283, 11944, 11956);
                                    }else {
                                        edge = iright;
                                        CallChecker.varAssign(edge, "edge", 285, 12003, 12016);
                                    }
                                }
                            }
                        }
                    }
                    double sumWeights = CallChecker.varInit(((double) (0)), "sumWeights", 295, 12477, 12498);
                    double sumX = CallChecker.varInit(((double) (0)), "sumX", 296, 12516, 12531);
                    double sumXSquared = CallChecker.varInit(((double) (0)), "sumXSquared", 297, 12549, 12571);
                    double sumY = CallChecker.varInit(((double) (0)), "sumY", 298, 12589, 12604);
                    double sumXY = CallChecker.varInit(((double) (0)), "sumXY", 299, 12622, 12638);
                    double denom = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(xval, double[].class, 300, 12691, 12694)) {
                        denom = FastMath.abs((1.0 / ((CallChecker.isCalled(xval, double[].class, 300, 12691, 12694)[edge]) - x)));
                        CallChecker.varAssign(denom, "denom", 300, 12691, 12694);
                    }
                    for (int k = ileft; k <= iright; ++k) {
                        final double xk = CallChecker.varInit(((double) (CallChecker.isCalled(xval, double[].class, 302, 12805, 12808)[k])), "xk", 302, 12785, 12812);
                        final double yk = CallChecker.varInit(((double) (CallChecker.isCalled(yval, double[].class, 303, 12854, 12857)[k])), "yk", 303, 12834, 12861);
                        double dist = CallChecker.init(double.class);
                        if (k < i) {
                            dist = x - xk;
                            CallChecker.varAssign(dist, "dist", 304, 12903, 12927);
                        }else {
                            dist = xk - x;
                            CallChecker.varAssign(dist, "dist", 304, 12903, 12927);
                        }
                        final double w = CallChecker.varInit(((double) (((LoessInterpolator.tricube((dist * denom))) * (CallChecker.isCalled(robustnessWeights, double[].class, 305, 12994, 13010)[k])) * (CallChecker.isCalled(weights, double[].class, 305, 13017, 13023)[k]))), "w", 305, 12950, 13027);
                        final double xkw = CallChecker.varInit(((double) (xk * w)), "xkw", 306, 13049, 13075);
                        sumWeights += w;
                        CallChecker.varAssign(sumWeights, "sumWeights", 307, 13097, 13112);
                        sumX += xkw;
                        CallChecker.varAssign(sumX, "sumX", 308, 13134, 13145);
                        sumXSquared += xk * xkw;
                        CallChecker.varAssign(sumXSquared, "sumXSquared", 309, 13167, 13190);
                        sumY += yk * w;
                        CallChecker.varAssign(sumY, "sumY", 310, 13212, 13226);
                        sumXY += yk * xkw;
                        CallChecker.varAssign(sumXY, "sumXY", 311, 13248, 13265);
                    }
                    final double meanX = CallChecker.varInit(((double) (sumX / sumWeights)), "meanX", 314, 13302, 13340);
                    final double meanY = CallChecker.varInit(((double) (sumY / sumWeights)), "meanY", 315, 13358, 13396);
                    final double meanXY = CallChecker.varInit(((double) (sumXY / sumWeights)), "meanXY", 316, 13414, 13454);
                    final double meanXSquared = CallChecker.varInit(((double) (sumXSquared / sumWeights)), "meanXSquared", 317, 13472, 13524);
                    double beta = CallChecker.init(double.class);
                    if ((FastMath.sqrt(FastMath.abs((meanXSquared - (meanX * meanX))))) < (accuracy)) {
                        beta = 0;
                        CallChecker.varAssign(beta, "beta", 321, 13674, 13682);
                    }else {
                        beta = (meanXY - (meanX * meanY)) / (meanXSquared - (meanX * meanX));
                        CallChecker.varAssign(beta, "beta", 323, 13729, 13793);
                    }
                    final double alpha = CallChecker.varInit(((double) (meanY - (beta * meanX))), "alpha", 326, 13830, 13871);
                    if (CallChecker.beforeDeref(res, double[].class, 328, 13890, 13892)) {
                        CallChecker.isCalled(res, double[].class, 328, 13890, 13892)[i] = (beta * x) + alpha;
                        CallChecker.varAssign(CallChecker.isCalled(res, double[].class, 328, 13890, 13892)[i], "CallChecker.isCalled(res, double[].class, 328, 13890, 13892)[i]", 328, 13890, 13915);
                    }
                    if (CallChecker.beforeDeref(residuals, double[].class, 329, 13933, 13941)) {
                        if (CallChecker.beforeDeref(yval, double[].class, 329, 13961, 13964)) {
                            if (CallChecker.beforeDeref(res, double[].class, 329, 13971, 13973)) {
                                CallChecker.isCalled(residuals, double[].class, 329, 13933, 13941)[i] = FastMath.abs(((CallChecker.isCalled(yval, double[].class, 329, 13961, 13964)[i]) - (CallChecker.isCalled(res, double[].class, 329, 13971, 13973)[i])));
                                CallChecker.varAssign(CallChecker.isCalled(residuals, double[].class, 329, 13933, 13941)[i], "CallChecker.isCalled(residuals, double[].class, 329, 13933, 13941)[i]", 329, 13933, 13978);
                            }
                        }
                    }
                }
                if (iter == (robustnessIters)) {
                    break;
                }
                System.arraycopy(residuals, 0, sortedResiduals, 0, n);
                Arrays.sort(sortedResiduals);
                final double medianResidual = CallChecker.varInit(((double) (CallChecker.isCalled(sortedResiduals, double[].class, 345, 14580, 14594)[(n / 2)])), "medianResidual", 345, 14550, 14602);
                if ((FastMath.abs(medianResidual)) < (accuracy)) {
                    break;
                }
                for (int i = 0; i < n; ++i) {
                    final double arg = CallChecker.varInit(((double) ((CallChecker.isCalled(residuals, double[].class, 352, 14779, 14787)[i]) / (6 * medianResidual))), "arg", 352, 14760, 14814);
                    if (arg >= 1) {
                        if (CallChecker.beforeDeref(robustnessWeights, double[].class, 354, 14868, 14884)) {
                            CallChecker.isCalled(robustnessWeights, double[].class, 354, 14868, 14884)[i] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(robustnessWeights, double[].class, 354, 14868, 14884)[i], "CallChecker.isCalled(robustnessWeights, double[].class, 354, 14868, 14884)[i]", 354, 14868, 14892);
                        }
                    }else {
                        final double w = CallChecker.varInit(((double) (1 - (arg * arg))), "w", 356, 14939, 14969);
                        if (CallChecker.beforeDeref(robustnessWeights, double[].class, 357, 14991, 15007)) {
                            CallChecker.isCalled(robustnessWeights, double[].class, 357, 14991, 15007)[i] = w * w;
                            CallChecker.varAssign(CallChecker.isCalled(robustnessWeights, double[].class, 357, 14991, 15007)[i], "CallChecker.isCalled(robustnessWeights, double[].class, 357, 14991, 15007)[i]", 357, 14991, 15019);
                        }
                    }
                }
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context686.methodEnd();
        }
    }

    public final double[] smooth(final double[] xval, final double[] yval) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException, NotFiniteNumberException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context687 = new MethodContext(double[].class, 382, 15095, 16513);
        try {
            CallChecker.varInit(this, "this", 382, 15095, 16513);
            CallChecker.varInit(yval, "yval", 382, 15095, 16513);
            CallChecker.varInit(xval, "xval", 382, 15095, 16513);
            CallChecker.varInit(this.accuracy, "accuracy", 382, 15095, 16513);
            CallChecker.varInit(this.robustnessIters, "robustnessIters", 382, 15095, 16513);
            CallChecker.varInit(this.bandwidth, "bandwidth", 382, 15095, 16513);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 382, 15095, 16513);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 382, 15095, 16513);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 382, 15095, 16513);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 382, 15095, 16513);
            if (CallChecker.beforeDeref(xval, double[].class, 388, 16242, 16245)) {
                if (CallChecker.beforeDeref(yval, double[].class, 388, 16257, 16260)) {
                    if ((CallChecker.isCalled(xval, double[].class, 388, 16242, 16245).length) != (CallChecker.isCalled(yval, double[].class, 388, 16257, 16260).length)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 389, 16321, 16324)) {
                            if (CallChecker.beforeDeref(yval, double[].class, 389, 16334, 16337)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xval, double[].class, 389, 16321, 16324).length, CallChecker.isCalled(yval, double[].class, 389, 16334, 16337).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] unitWeights = CallChecker.varInit(new double[CallChecker.isCalled(xval, double[].class, 392, 16407, 16410).length], "unitWeights", 392, 16367, 16419);
            Arrays.fill(unitWeights, 1.0);
            return smooth(xval, yval, unitWeights);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context687.methodEnd();
        }
    }

    private static void updateBandwidthInterval(final double[] xval, final double[] weights, final int i, final int[] bandwidthInterval) {
        MethodContext _bcornu_methode_context688 = new MethodContext(void.class, 413, 16520, 18027);
        try {
            CallChecker.varInit(bandwidthInterval, "bandwidthInterval", 413, 16520, 18027);
            CallChecker.varInit(i, "i", 413, 16520, 18027);
            CallChecker.varInit(weights, "weights", 413, 16520, 18027);
            CallChecker.varInit(xval, "xval", 413, 16520, 18027);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 413, 16520, 18027);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 413, 16520, 18027);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 413, 16520, 18027);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 413, 16520, 18027);
            final int left = CallChecker.varInit(((int) (CallChecker.isCalled(bandwidthInterval, int[].class, 416, 17480, 17496)[0])), "left", 416, 17463, 17500);
            final int right = CallChecker.varInit(((int) (CallChecker.isCalled(bandwidthInterval, int[].class, 417, 17528, 17544)[1])), "right", 417, 17510, 17548);
            int nextRight = CallChecker.varInit(((int) (LoessInterpolator.nextNonzero(weights, right))), "nextRight", 421, 17715, 17758);
            if (CallChecker.beforeDeref(xval, double[].class, 422, 17784, 17787)) {
                if (CallChecker.beforeDeref(xval, double[].class, 422, 17799, 17802)) {
                    if (CallChecker.beforeDeref(xval, double[].class, 422, 17817, 17820)) {
                        if (CallChecker.beforeDeref(xval, double[].class, 422, 17827, 17830)) {
                            if (CallChecker.beforeDeref(xval, double[].class, 422, 17837, 17840)) {
                                if ((nextRight < (CallChecker.isCalled(xval, double[].class, 422, 17784, 17787).length)) && (((CallChecker.isCalled(xval, double[].class, 422, 17799, 17802)[nextRight]) - (CallChecker.isCalled(xval, double[].class, 422, 17817, 17820)[i])) < ((CallChecker.isCalled(xval, double[].class, 422, 17827, 17830)[i]) - (CallChecker.isCalled(xval, double[].class, 422, 17837, 17840)[left])))) {
                                    int nextLeft = CallChecker.init(int.class);
                                    if (CallChecker.beforeDeref(bandwidthInterval, int[].class, 423, 17899, 17915)) {
                                        nextLeft = LoessInterpolator.nextNonzero(weights, CallChecker.isCalled(bandwidthInterval, int[].class, 423, 17899, 17915)[0]);
                                        CallChecker.varAssign(nextLeft, "nextLeft", 423, 17899, 17915);
                                    }
                                    if (CallChecker.beforeDeref(bandwidthInterval, int[].class, 424, 17934, 17950)) {
                                        CallChecker.isCalled(bandwidthInterval, int[].class, 424, 17934, 17950)[0] = nextLeft;
                                        CallChecker.varAssign(CallChecker.isCalled(bandwidthInterval, int[].class, 424, 17934, 17950)[0], "CallChecker.isCalled(bandwidthInterval, int[].class, 424, 17934, 17950)[0]", 424, 17934, 17965);
                                    }
                                    if (CallChecker.beforeDeref(bandwidthInterval, int[].class, 425, 17979, 17995)) {
                                        CallChecker.isCalled(bandwidthInterval, int[].class, 425, 17979, 17995)[1] = nextRight;
                                        CallChecker.varAssign(CallChecker.isCalled(bandwidthInterval, int[].class, 425, 17979, 17995)[1], "CallChecker.isCalled(bandwidthInterval, int[].class, 425, 17979, 17995)[1]", 425, 17979, 18011);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context688.methodEnd();
        }
    }

    private static int nextNonzero(final double[] weights, final int i) {
        MethodContext _bcornu_methode_context689 = new MethodContext(int.class, 437, 18034, 18505);
        try {
            CallChecker.varInit(i, "i", 437, 18034, 18505);
            CallChecker.varInit(weights, "weights", 437, 18034, 18505);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 437, 18034, 18505);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 437, 18034, 18505);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 437, 18034, 18505);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 437, 18034, 18505);
            int j = CallChecker.varInit(((int) (i + 1)), "j", 438, 18386, 18399);
            while ((j < (CallChecker.isCalled(weights, double[].class, 439, 18419, 18425).length)) && ((CallChecker.isCalled(weights, double[].class, 439, 18437, 18443)[j]) == 0)) {
                ++j;
            } 
            return j;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context689.methodEnd();
        }
    }

    private static double tricube(final double x) {
        MethodContext _bcornu_methode_context690 = new MethodContext(double.class, 453, 18512, 19026);
        try {
            CallChecker.varInit(x, "x", 453, 18512, 19026);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 453, 18512, 19026);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 453, 18512, 19026);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 453, 18512, 19026);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 453, 18512, 19026);
            final double absX = CallChecker.varInit(((double) (FastMath.abs(x))), "absX", 454, 18841, 18876);
            if (absX >= 1.0) {
                return 0.0;
            }
            final double tmp = CallChecker.varInit(((double) (1 - ((absX * absX) * absX))), "tmp", 458, 18947, 18988);
            return (tmp * tmp) * tmp;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context690.methodEnd();
        }
    }

    private static void checkAllFiniteReal(final double[] values) {
        MethodContext _bcornu_methode_context691 = new MethodContext(void.class, 469, 19033, 19465);
        try {
            CallChecker.varInit(values, "values", 469, 19033, 19465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.serialVersionUID", 469, 19033, 19465);
            CallChecker.varInit(DEFAULT_ACCURACY, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ACCURACY", 469, 19033, 19465);
            CallChecker.varInit(DEFAULT_ROBUSTNESS_ITERS, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_ROBUSTNESS_ITERS", 469, 19033, 19465);
            CallChecker.varInit(DEFAULT_BANDWIDTH, "org.apache.commons.math3.analysis.interpolation.LoessInterpolator.DEFAULT_BANDWIDTH", 469, 19033, 19465);
            for (int i = 0; i < (CallChecker.isCalled(values, double[].class, 470, 19383, 19388).length); i++) {
                if (CallChecker.beforeDeref(values, double[].class, 471, 19439, 19444)) {
                    MathUtils.checkFinite(CallChecker.isCalled(values, double[].class, 471, 19439, 19444)[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context691.methodEnd();
        }
    }
}

