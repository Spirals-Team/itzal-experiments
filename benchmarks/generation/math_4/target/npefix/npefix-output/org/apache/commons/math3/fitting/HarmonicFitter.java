package org.apache.commons.math3.fitting;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.nonlinear.vector.MultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

public class HarmonicFitter extends CurveFitter<HarmonicOscillator.Parametric> {
    public static class ParameterGuesser {
        private final double a;

        private final double omega;

        private final double phi;

        public ParameterGuesser(WeightedObservedPoint[] observations) {
            ConstructorContext _bcornu_methode_context102 = new ConstructorContext(HarmonicFitter.ParameterGuesser.class, 195, 8496, 9427);
            try {
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 196, 8949, 8960)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 196, 8949, 8960);
                    if ((CallChecker.isCalled(observations, WeightedObservedPoint[].class, 196, 8949, 8960).length) < 4) {
                        if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 198, 9137, 9148)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 198, 9137, 9148);
                            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, CallChecker.isCalled(observations, WeightedObservedPoint[].class, 198, 9137, 9148).length, 4, true);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final WeightedObservedPoint[] sorted = CallChecker.varInit(sortObservations(observations), "sorted", 201, 9195, 9264);
                final double[] aOmega = CallChecker.varInit(guessAOmega(sorted), "aOmega", 203, 9279, 9322);
                a = CallChecker.isCalled(aOmega, double[].class, 204, 9340, 9345)[0];
                CallChecker.varAssign(this.a, "this.a", 204, 9336, 9349);
                omega = CallChecker.isCalled(aOmega, double[].class, 205, 9371, 9376)[1];
                CallChecker.varAssign(this.omega, "this.omega", 205, 9363, 9380);
                phi = guessPhi(sorted);
                CallChecker.varAssign(this.phi, "this.phi", 207, 9395, 9417);
            } finally {
                _bcornu_methode_context102.methodEnd();
            }
        }

        public double[] guess() {
            MethodContext _bcornu_methode_context371 = new MethodContext(double[].class, 220, 9438, 9804);
            try {
                CallChecker.varInit(this, "this", 220, 9438, 9804);
                CallChecker.varInit(this.phi, "phi", 220, 9438, 9804);
                CallChecker.varInit(this.omega, "omega", 220, 9438, 9804);
                CallChecker.varInit(this.a, "a", 220, 9438, 9804);
                return new double[]{ a , omega , phi };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context371.methodEnd();
            }
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] unsorted) {
            MethodContext _bcornu_methode_context372 = new MethodContext(WeightedObservedPoint[].class, 230, 9815, 11266);
            try {
                CallChecker.varInit(this, "this", 230, 9815, 11266);
                CallChecker.varInit(unsorted, "unsorted", 230, 9815, 11266);
                CallChecker.varInit(this.phi, "phi", 230, 9815, 11266);
                CallChecker.varInit(this.omega, "omega", 230, 9815, 11266);
                CallChecker.varInit(this.a, "a", 230, 9815, 11266);
                unsorted = CallChecker.beforeCalled(unsorted, WeightedObservedPoint[].class, 231, 10153, 10160);
                final WeightedObservedPoint[] observations = CallChecker.varInit(CallChecker.isCalled(unsorted, WeightedObservedPoint[].class, 231, 10153, 10160).clone(), "observations", 231, 10108, 10169);
                WeightedObservedPoint curr = CallChecker.init(WeightedObservedPoint.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 236, 10442, 10453)) {
                    curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 236, 10442, 10453)[0];
                    CallChecker.varAssign(curr, "curr", 236, 10442, 10453);
                }
                for (int j = 1; j < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 237, 10491, 10502).length); ++j) {
                    WeightedObservedPoint prec = CallChecker.varInit(curr, "prec", 238, 10535, 10568);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 239, 10593, 10604)) {
                        curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 239, 10593, 10604)[j];
                        CallChecker.varAssign(curr, "curr", 239, 10586, 10608);
                    }
                    if (CallChecker.beforeDeref(curr, WeightedObservedPoint.class, 240, 10630, 10633)) {
                        if (CallChecker.beforeDeref(prec, WeightedObservedPoint.class, 240, 10644, 10647)) {
                            curr = CallChecker.beforeCalled(curr, WeightedObservedPoint.class, 240, 10630, 10633);
                            prec = CallChecker.beforeCalled(prec, WeightedObservedPoint.class, 240, 10644, 10647);
                            if ((CallChecker.isCalled(curr, WeightedObservedPoint.class, 240, 10630, 10633).getX()) < (CallChecker.isCalled(prec, WeightedObservedPoint.class, 240, 10644, 10647).getX())) {
                                int i = CallChecker.varInit(((int) (j - 1)), "i", 242, 10765, 10778);
                                WeightedObservedPoint mI = CallChecker.init(WeightedObservedPoint.class);
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 243, 10827, 10838)) {
                                    mI = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 243, 10827, 10838)[i];
                                    CallChecker.varAssign(mI, "mI", 243, 10827, 10838);
                                }
                                curr = CallChecker.beforeCalled(curr, WeightedObservedPoint.class, 244, 10884, 10887);
                                mI = CallChecker.beforeCalled(mI, WeightedObservedPoint.class, 244, 10898, 10899);
                                while ((i >= 0) && ((CallChecker.isCalled(curr, WeightedObservedPoint.class, 244, 10884, 10887).getX()) < (CallChecker.isCalled(mI, WeightedObservedPoint.class, 244, 10898, 10899).getX()))) {
                                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 245, 10936, 10947)) {
                                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 245, 10936, 10947)[(i + 1)] = mI;
                                        CallChecker.varAssign(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 245, 10936, 10947)[(i + 1)], "CallChecker.isCalled(observations, WeightedObservedPoint[].class, 245, 10936, 10947)[(i + 1)]", 245, 10936, 10960);
                                    }
                                    if ((i--) != 0) {
                                        if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 247, 11035, 11046)) {
                                            mI = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 247, 11035, 11046)[i];
                                            CallChecker.varAssign(mI, "mI", 247, 11030, 11050);
                                        }
                                    }
                                } 
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 250, 11120, 11131)) {
                                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 250, 11120, 11131)[(i + 1)] = curr;
                                    CallChecker.varAssign(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 250, 11120, 11131)[(i + 1)], "CallChecker.isCalled(observations, WeightedObservedPoint[].class, 250, 11120, 11131)[(i + 1)]", 250, 11120, 11146);
                                }
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 251, 11175, 11186)) {
                                    curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 251, 11175, 11186)[j];
                                    CallChecker.varAssign(curr, "curr", 251, 11168, 11190);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return observations;
            } catch (ForceReturn _bcornu_return_t) {
                return ((WeightedObservedPoint[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context372.methodEnd();
            }
        }

        private double[] guessAOmega(WeightedObservedPoint[] observations) {
            MethodContext _bcornu_methode_context373 = new MethodContext(double[].class, 270, 11277, 15201);
            try {
                CallChecker.varInit(this, "this", 270, 11277, 15201);
                CallChecker.varInit(observations, "observations", 270, 11277, 15201);
                CallChecker.varInit(this.phi, "phi", 270, 11277, 15201);
                CallChecker.varInit(this.omega, "omega", 270, 11277, 15201);
                CallChecker.varInit(this.a, "a", 270, 11277, 15201);
                final double[] aOmega = CallChecker.varInit(new double[2], "aOmega", 271, 11933, 11970);
                double sx2 = CallChecker.varInit(((double) (0)), "sx2", 274, 12067, 12081);
                double sy2 = CallChecker.varInit(((double) (0)), "sy2", 275, 12095, 12109);
                double sxy = CallChecker.varInit(((double) (0)), "sxy", 276, 12123, 12137);
                double sxz = CallChecker.varInit(((double) (0)), "sxz", 277, 12151, 12165);
                double syz = CallChecker.varInit(((double) (0)), "syz", 278, 12179, 12193);
                double currentX = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 280, 12226, 12237)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237)[0], WeightedObservedPoint.class, 280, 12226, 12240)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237)[0], WeightedObservedPoint.class, 280, 12226, 12240);
                        currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 280, 12226, 12237)[0], WeightedObservedPoint.class, 280, 12226, 12240).getX();
                        CallChecker.varAssign(currentX, "currentX", 280, 12226, 12237);
                    }
                }
                double currentY = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 281, 12280, 12291)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291)[0], WeightedObservedPoint.class, 281, 12280, 12294)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291)[0], WeightedObservedPoint.class, 281, 12280, 12294);
                        currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 281, 12280, 12291)[0], WeightedObservedPoint.class, 281, 12280, 12294).getY();
                        CallChecker.varAssign(currentY, "currentY", 281, 12280, 12291);
                    }
                }
                double f2Integral = CallChecker.varInit(((double) (0)), "f2Integral", 282, 12316, 12337);
                double fPrime2Integral = CallChecker.varInit(((double) (0)), "fPrime2Integral", 283, 12351, 12377);
                final double startX = CallChecker.varInit(((double) (currentX)), "startX", 284, 12391, 12421);
                observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 285, 12455, 12466);
                for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 285, 12455, 12466).length); ++i) {
                    final double previousX = CallChecker.varInit(((double) (currentX)), "previousX", 287, 12499, 12568);
                    final double previousY = CallChecker.varInit(((double) (currentY)), "previousY", 288, 12586, 12619);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 289, 12648, 12659)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659)[i], WeightedObservedPoint.class, 289, 12648, 12662)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659)[i], WeightedObservedPoint.class, 289, 12648, 12662);
                            currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 289, 12648, 12659)[i], WeightedObservedPoint.class, 289, 12648, 12662).getX();
                            CallChecker.varAssign(currentX, "currentX", 289, 12637, 12670);
                        }
                    }
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 290, 12699, 12710)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710)[i], WeightedObservedPoint.class, 290, 12699, 12713)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710)[i], WeightedObservedPoint.class, 290, 12699, 12713);
                            currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 290, 12699, 12710)[i], WeightedObservedPoint.class, 290, 12699, 12713).getY();
                            CallChecker.varAssign(currentY, "currentY", 290, 12688, 12721);
                        }
                    }
                    final double dx = CallChecker.varInit(((double) (currentX - previousX)), "dx", 294, 12740, 12934);
                    final double dy = CallChecker.varInit(((double) (currentY - previousY)), "dy", 295, 12952, 12990);
                    final double f2StepIntegral = CallChecker.varInit(((double) ((dx * (((previousY * previousY) + (previousY * currentY)) + (currentY * currentY))) / 3)), "f2StepIntegral", 296, 13008, 13135);
                    final double fPrime2StepIntegral = CallChecker.varInit(((double) ((dy * dy) / dx)), "fPrime2StepIntegral", 298, 13153, 13200);
                    final double x = CallChecker.varInit(((double) (currentX - startX)), "x", 300, 13219, 13253);
                    f2Integral += f2StepIntegral;
                    CallChecker.varAssign(f2Integral, "f2Integral", 301, 13271, 13299);
                    fPrime2Integral += fPrime2StepIntegral;
                    CallChecker.varAssign(fPrime2Integral, "fPrime2Integral", 302, 13317, 13355);
                    sx2 += x * x;
                    CallChecker.varAssign(sx2, "sx2", 304, 13374, 13386);
                    sy2 += f2Integral * f2Integral;
                    CallChecker.varAssign(sy2, "sy2", 305, 13404, 13434);
                    sxy += x * f2Integral;
                    CallChecker.varAssign(sxy, "sxy", 306, 13452, 13473);
                    sxz += x * fPrime2Integral;
                    CallChecker.varAssign(sxz, "sxz", 307, 13491, 13517);
                    syz += f2Integral * fPrime2Integral;
                    CallChecker.varAssign(syz, "syz", 308, 13535, 13570);
                }
                double c1 = CallChecker.varInit(((double) ((sy2 * sxz) - (sxy * syz))), "c1", 312, 13663, 13696);
                double c2 = CallChecker.varInit(((double) ((sxy * sxz) - (sx2 * syz))), "c2", 313, 13710, 13743);
                double c3 = CallChecker.varInit(((double) ((sx2 * sy2) - (sxy * sxy))), "c3", 314, 13757, 13790);
                if (((c1 / c2) < 0) || ((c2 / c3) < 0)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 316, 13875, 13886);
                    final int last = CallChecker.varInit(((int) ((CallChecker.isCalled(observations, WeightedObservedPoint[].class, 316, 13875, 13886).length) - 1)), "last", 316, 13858, 13898);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 319, 14046, 14057);
                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14046, 14057)[last] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14046, 14057)[last], WeightedObservedPoint.class, 319, 14046, 14063);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 319, 14074, 14085);
                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14074, 14085)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14074, 14085)[0], WeightedObservedPoint.class, 319, 14074, 14088);
                    final double xRange = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14046, 14057)[last], WeightedObservedPoint.class, 319, 14046, 14063).getX()) - (CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 14074, 14085)[0], WeightedObservedPoint.class, 319, 14074, 14088).getX()))), "xRange", 319, 13916, 14096);
                    if (xRange == 0) {
                        throw new ZeroException();
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 323, 14214, 14219)) {
                        CallChecker.isCalled(aOmega, double[].class, 323, 14214, 14219)[1] = (2 * (Math.PI)) / xRange;
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 323, 14214, 14219)[1], "CallChecker.isCalled(aOmega, double[].class, 323, 14214, 14219)[1]", 323, 14214, 14246);
                    }
                    double yMin = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "yMin", 325, 14265, 14303);
                    double yMax = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "yMax", 326, 14321, 14359);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 327, 14397, 14408);
                    for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 327, 14397, 14408).length); ++i) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 328, 14462, 14473);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 328, 14462, 14473)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 328, 14462, 14473)[i], WeightedObservedPoint.class, 328, 14462, 14476);
                        final double y = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 328, 14462, 14473)[i], WeightedObservedPoint.class, 328, 14462, 14476).getY())), "y", 328, 14445, 14484);
                        if (y < yMin) {
                            yMin = y;
                            CallChecker.varAssign(yMin, "yMin", 330, 14546, 14554);
                        }
                        if (y > yMax) {
                            yMax = y;
                            CallChecker.varAssign(yMax, "yMax", 333, 14638, 14646);
                        }
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 336, 14704, 14709)) {
                        CallChecker.isCalled(aOmega, double[].class, 336, 14704, 14709)[0] = 0.5 * (yMax - yMin);
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 336, 14704, 14709)[0], "CallChecker.isCalled(aOmega, double[].class, 336, 14704, 14709)[0]", 336, 14704, 14735);
                    }
                }else {
                    if (c2 == 0) {
                        throw new MathIllegalStateException(LocalizedFormats.ZERO_DENOMINATOR);
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 344, 15063, 15068)) {
                        CallChecker.isCalled(aOmega, double[].class, 344, 15063, 15068)[0] = FastMath.sqrt((c1 / c2));
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 344, 15063, 15068)[0], "CallChecker.isCalled(aOmega, double[].class, 344, 15063, 15068)[0]", 344, 15063, 15097);
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 345, 15115, 15120)) {
                        CallChecker.isCalled(aOmega, double[].class, 345, 15115, 15120)[1] = FastMath.sqrt((c2 / c3));
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 345, 15115, 15120)[1], "CallChecker.isCalled(aOmega, double[].class, 345, 15115, 15120)[1]", 345, 15115, 15149);
                    }
                }
                return aOmega;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context373.methodEnd();
            }
        }

        private double guessPhi(WeightedObservedPoint[] observations) {
            MethodContext _bcornu_methode_context374 = new MethodContext(double.class, 357, 15212, 16451);
            try {
                CallChecker.varInit(this, "this", 357, 15212, 16451);
                CallChecker.varInit(observations, "observations", 357, 15212, 16451);
                CallChecker.varInit(this.phi, "phi", 357, 15212, 16451);
                CallChecker.varInit(this.omega, "omega", 357, 15212, 16451);
                CallChecker.varInit(this.a, "a", 357, 15212, 16451);
                double fcMean = CallChecker.varInit(((double) (0)), "fcMean", 359, 15514, 15531);
                double fsMean = CallChecker.varInit(((double) (0)), "fsMean", 360, 15545, 15562);
                double currentX = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 362, 15595, 15606)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606)[0], WeightedObservedPoint.class, 362, 15595, 15609)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606)[0], WeightedObservedPoint.class, 362, 15595, 15609);
                        currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 362, 15595, 15606)[0], WeightedObservedPoint.class, 362, 15595, 15609).getX();
                        CallChecker.varAssign(currentX, "currentX", 362, 15595, 15606);
                    }
                }
                double currentY = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 363, 15649, 15660)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660)[0], WeightedObservedPoint.class, 363, 15649, 15663)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660)[0], WeightedObservedPoint.class, 363, 15649, 15663);
                        currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 363, 15649, 15660)[0], WeightedObservedPoint.class, 363, 15649, 15663).getY();
                        CallChecker.varAssign(currentY, "currentY", 363, 15649, 15660);
                    }
                }
                observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 364, 15705, 15716);
                for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 364, 15705, 15716).length); ++i) {
                    final double previousX = CallChecker.varInit(((double) (currentX)), "previousX", 366, 15749, 15818);
                    final double previousY = CallChecker.varInit(((double) (currentY)), "previousY", 367, 15836, 15869);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 368, 15898, 15909)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909)[i], WeightedObservedPoint.class, 368, 15898, 15912)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909)[i], WeightedObservedPoint.class, 368, 15898, 15912);
                            currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 368, 15898, 15909)[i], WeightedObservedPoint.class, 368, 15898, 15912).getX();
                            CallChecker.varAssign(currentX, "currentX", 368, 15887, 15920);
                        }
                    }
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 369, 15949, 15960)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960)[i], WeightedObservedPoint.class, 369, 15949, 15963)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960)[i], WeightedObservedPoint.class, 369, 15949, 15963);
                            currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 369, 15949, 15960)[i], WeightedObservedPoint.class, 369, 15949, 15963).getY();
                            CallChecker.varAssign(currentY, "currentY", 369, 15938, 15971);
                        }
                    }
                    final double currentYPrime = CallChecker.varInit(((double) ((currentY - previousY) / (currentX - previousX))), "currentYPrime", 370, 15989, 16065);
                    double omegaX = CallChecker.varInit(((double) ((this.omega) * currentX)), "omegaX", 372, 16084, 16116);
                    double cosine = CallChecker.varInit(((double) (FastMath.cos(omegaX))), "cosine", 373, 16134, 16170);
                    double sine = CallChecker.varInit(((double) (FastMath.sin(omegaX))), "sine", 374, 16188, 16222);
                    fcMean += (((omega) * currentY) * cosine) - (currentYPrime * sine);
                    CallChecker.varAssign(fcMean, "fcMean", 375, 16240, 16298);
                    fsMean += (((omega) * currentY) * sine) + (currentYPrime * cosine);
                    CallChecker.varAssign(fsMean, "fsMean", 376, 16316, 16374);
                }
                return FastMath.atan2((-fsMean), fcMean);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context374.methodEnd();
            }
        }
    }

    public HarmonicFitter(final MultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context103 = new ConstructorContext(HarmonicFitter.class, 44, 1868, 2068);
        try {
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public double[] fit(double[] initialGuess) {
        MethodContext _bcornu_methode_context375 = new MethodContext(double[].class, 60, 2075, 2581);
        try {
            CallChecker.varInit(this, "this", 60, 2075, 2581);
            CallChecker.varInit(initialGuess, "initialGuess", 60, 2075, 2581);
            return fit(new HarmonicOscillator.Parametric(), initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context375.methodEnd();
        }
    }

    public double[] fit() {
        MethodContext _bcornu_methode_context376 = new MethodContext(double[].class, 75, 2588, 3194);
        try {
            CallChecker.varInit(this, "this", 75, 2588, 3194);
            if (CallChecker.beforeDeref(new HarmonicFitter.ParameterGuesser(getObservations()), HarmonicFitter.ParameterGuesser.class, 76, 3138, 3178)) {
                return fit(CallChecker.isCalled(new HarmonicFitter.ParameterGuesser(getObservations()), HarmonicFitter.ParameterGuesser.class, 76, 3138, 3178).guess());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context376.methodEnd();
        }
    }
}

