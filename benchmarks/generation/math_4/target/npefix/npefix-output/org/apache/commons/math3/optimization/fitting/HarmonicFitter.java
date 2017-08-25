package org.apache.commons.math3.optimization.fitting;

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
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

@Deprecated
public class HarmonicFitter extends CurveFitter<HarmonicOscillator.Parametric> {
    public static class ParameterGuesser {
        private final double a;

        private final double omega;

        private final double phi;

        public ParameterGuesser(WeightedObservedPoint[] observations) {
            ConstructorContext _bcornu_methode_context97 = new ConstructorContext(HarmonicFitter.ParameterGuesser.class, 198, 8535, 9466);
            try {
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 199, 8988, 8999)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 199, 8988, 8999);
                    if ((CallChecker.isCalled(observations, WeightedObservedPoint[].class, 199, 8988, 8999).length) < 4) {
                        if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 201, 9176, 9187)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 201, 9176, 9187);
                            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, CallChecker.isCalled(observations, WeightedObservedPoint[].class, 201, 9176, 9187).length, 4, true);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                final WeightedObservedPoint[] sorted = CallChecker.varInit(sortObservations(observations), "sorted", 204, 9234, 9303);
                final double[] aOmega = CallChecker.varInit(guessAOmega(sorted), "aOmega", 206, 9318, 9361);
                a = CallChecker.isCalled(aOmega, double[].class, 207, 9379, 9384)[0];
                CallChecker.varAssign(this.a, "this.a", 207, 9375, 9388);
                omega = CallChecker.isCalled(aOmega, double[].class, 208, 9410, 9415)[1];
                CallChecker.varAssign(this.omega, "this.omega", 208, 9402, 9419);
                phi = guessPhi(sorted);
                CallChecker.varAssign(this.phi, "this.phi", 210, 9434, 9456);
            } finally {
                _bcornu_methode_context97.methodEnd();
            }
        }

        public double[] guess() {
            MethodContext _bcornu_methode_context365 = new MethodContext(double[].class, 223, 9477, 9843);
            try {
                CallChecker.varInit(this, "this", 223, 9477, 9843);
                CallChecker.varInit(this.phi, "phi", 223, 9477, 9843);
                CallChecker.varInit(this.omega, "omega", 223, 9477, 9843);
                CallChecker.varInit(this.a, "a", 223, 9477, 9843);
                return new double[]{ a , omega , phi };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context365.methodEnd();
            }
        }

        private WeightedObservedPoint[] sortObservations(WeightedObservedPoint[] unsorted) {
            MethodContext _bcornu_methode_context366 = new MethodContext(WeightedObservedPoint[].class, 233, 9854, 11305);
            try {
                CallChecker.varInit(this, "this", 233, 9854, 11305);
                CallChecker.varInit(unsorted, "unsorted", 233, 9854, 11305);
                CallChecker.varInit(this.phi, "phi", 233, 9854, 11305);
                CallChecker.varInit(this.omega, "omega", 233, 9854, 11305);
                CallChecker.varInit(this.a, "a", 233, 9854, 11305);
                unsorted = CallChecker.beforeCalled(unsorted, WeightedObservedPoint[].class, 234, 10192, 10199);
                final WeightedObservedPoint[] observations = CallChecker.varInit(CallChecker.isCalled(unsorted, WeightedObservedPoint[].class, 234, 10192, 10199).clone(), "observations", 234, 10147, 10208);
                WeightedObservedPoint curr = CallChecker.init(WeightedObservedPoint.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 239, 10481, 10492)) {
                    curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 239, 10481, 10492)[0];
                    CallChecker.varAssign(curr, "curr", 239, 10481, 10492);
                }
                for (int j = 1; j < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 240, 10530, 10541).length); ++j) {
                    WeightedObservedPoint prec = CallChecker.varInit(curr, "prec", 241, 10574, 10607);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 242, 10632, 10643)) {
                        curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 242, 10632, 10643)[j];
                        CallChecker.varAssign(curr, "curr", 242, 10625, 10647);
                    }
                    if (CallChecker.beforeDeref(curr, WeightedObservedPoint.class, 243, 10669, 10672)) {
                        if (CallChecker.beforeDeref(prec, WeightedObservedPoint.class, 243, 10683, 10686)) {
                            curr = CallChecker.beforeCalled(curr, WeightedObservedPoint.class, 243, 10669, 10672);
                            prec = CallChecker.beforeCalled(prec, WeightedObservedPoint.class, 243, 10683, 10686);
                            if ((CallChecker.isCalled(curr, WeightedObservedPoint.class, 243, 10669, 10672).getX()) < (CallChecker.isCalled(prec, WeightedObservedPoint.class, 243, 10683, 10686).getX())) {
                                int i = CallChecker.varInit(((int) (j - 1)), "i", 245, 10804, 10817);
                                WeightedObservedPoint mI = CallChecker.init(WeightedObservedPoint.class);
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 246, 10866, 10877)) {
                                    mI = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 246, 10866, 10877)[i];
                                    CallChecker.varAssign(mI, "mI", 246, 10866, 10877);
                                }
                                curr = CallChecker.beforeCalled(curr, WeightedObservedPoint.class, 247, 10923, 10926);
                                mI = CallChecker.beforeCalled(mI, WeightedObservedPoint.class, 247, 10937, 10938);
                                while ((i >= 0) && ((CallChecker.isCalled(curr, WeightedObservedPoint.class, 247, 10923, 10926).getX()) < (CallChecker.isCalled(mI, WeightedObservedPoint.class, 247, 10937, 10938).getX()))) {
                                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 248, 10975, 10986)) {
                                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 248, 10975, 10986)[(i + 1)] = mI;
                                        CallChecker.varAssign(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 248, 10975, 10986)[(i + 1)], "CallChecker.isCalled(observations, WeightedObservedPoint[].class, 248, 10975, 10986)[(i + 1)]", 248, 10975, 10999);
                                    }
                                    if ((i--) != 0) {
                                        if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 250, 11074, 11085)) {
                                            mI = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 250, 11074, 11085)[i];
                                            CallChecker.varAssign(mI, "mI", 250, 11069, 11089);
                                        }
                                    }
                                } 
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 253, 11159, 11170)) {
                                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 253, 11159, 11170)[(i + 1)] = curr;
                                    CallChecker.varAssign(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 253, 11159, 11170)[(i + 1)], "CallChecker.isCalled(observations, WeightedObservedPoint[].class, 253, 11159, 11170)[(i + 1)]", 253, 11159, 11185);
                                }
                                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 254, 11214, 11225)) {
                                    curr = CallChecker.isCalled(observations, WeightedObservedPoint[].class, 254, 11214, 11225)[j];
                                    CallChecker.varAssign(curr, "curr", 254, 11207, 11229);
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
                _bcornu_methode_context366.methodEnd();
            }
        }

        private double[] guessAOmega(WeightedObservedPoint[] observations) {
            MethodContext _bcornu_methode_context367 = new MethodContext(double[].class, 273, 11316, 15240);
            try {
                CallChecker.varInit(this, "this", 273, 11316, 15240);
                CallChecker.varInit(observations, "observations", 273, 11316, 15240);
                CallChecker.varInit(this.phi, "phi", 273, 11316, 15240);
                CallChecker.varInit(this.omega, "omega", 273, 11316, 15240);
                CallChecker.varInit(this.a, "a", 273, 11316, 15240);
                final double[] aOmega = CallChecker.varInit(new double[2], "aOmega", 274, 11972, 12009);
                double sx2 = CallChecker.varInit(((double) (0)), "sx2", 277, 12106, 12120);
                double sy2 = CallChecker.varInit(((double) (0)), "sy2", 278, 12134, 12148);
                double sxy = CallChecker.varInit(((double) (0)), "sxy", 279, 12162, 12176);
                double sxz = CallChecker.varInit(((double) (0)), "sxz", 280, 12190, 12204);
                double syz = CallChecker.varInit(((double) (0)), "syz", 281, 12218, 12232);
                double currentX = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 283, 12265, 12276)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276)[0], WeightedObservedPoint.class, 283, 12265, 12279)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276)[0], WeightedObservedPoint.class, 283, 12265, 12279);
                        currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 283, 12265, 12276)[0], WeightedObservedPoint.class, 283, 12265, 12279).getX();
                        CallChecker.varAssign(currentX, "currentX", 283, 12265, 12276);
                    }
                }
                double currentY = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 284, 12319, 12330)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330)[0], WeightedObservedPoint.class, 284, 12319, 12333)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330)[0], WeightedObservedPoint.class, 284, 12319, 12333);
                        currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 284, 12319, 12330)[0], WeightedObservedPoint.class, 284, 12319, 12333).getY();
                        CallChecker.varAssign(currentY, "currentY", 284, 12319, 12330);
                    }
                }
                double f2Integral = CallChecker.varInit(((double) (0)), "f2Integral", 285, 12355, 12376);
                double fPrime2Integral = CallChecker.varInit(((double) (0)), "fPrime2Integral", 286, 12390, 12416);
                final double startX = CallChecker.varInit(((double) (currentX)), "startX", 287, 12430, 12460);
                observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 288, 12494, 12505);
                for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 288, 12494, 12505).length); ++i) {
                    final double previousX = CallChecker.varInit(((double) (currentX)), "previousX", 290, 12538, 12607);
                    final double previousY = CallChecker.varInit(((double) (currentY)), "previousY", 291, 12625, 12658);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 292, 12687, 12698)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698)[i], WeightedObservedPoint.class, 292, 12687, 12701)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698)[i], WeightedObservedPoint.class, 292, 12687, 12701);
                            currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 292, 12687, 12698)[i], WeightedObservedPoint.class, 292, 12687, 12701).getX();
                            CallChecker.varAssign(currentX, "currentX", 292, 12676, 12709);
                        }
                    }
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 293, 12738, 12749)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749)[i], WeightedObservedPoint.class, 293, 12738, 12752)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749)[i], WeightedObservedPoint.class, 293, 12738, 12752);
                            currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 293, 12738, 12749)[i], WeightedObservedPoint.class, 293, 12738, 12752).getY();
                            CallChecker.varAssign(currentY, "currentY", 293, 12727, 12760);
                        }
                    }
                    final double dx = CallChecker.varInit(((double) (currentX - previousX)), "dx", 297, 12779, 12973);
                    final double dy = CallChecker.varInit(((double) (currentY - previousY)), "dy", 298, 12991, 13029);
                    final double f2StepIntegral = CallChecker.varInit(((double) ((dx * (((previousY * previousY) + (previousY * currentY)) + (currentY * currentY))) / 3)), "f2StepIntegral", 299, 13047, 13174);
                    final double fPrime2StepIntegral = CallChecker.varInit(((double) ((dy * dy) / dx)), "fPrime2StepIntegral", 301, 13192, 13239);
                    final double x = CallChecker.varInit(((double) (currentX - startX)), "x", 303, 13258, 13292);
                    f2Integral += f2StepIntegral;
                    CallChecker.varAssign(f2Integral, "f2Integral", 304, 13310, 13338);
                    fPrime2Integral += fPrime2StepIntegral;
                    CallChecker.varAssign(fPrime2Integral, "fPrime2Integral", 305, 13356, 13394);
                    sx2 += x * x;
                    CallChecker.varAssign(sx2, "sx2", 307, 13413, 13425);
                    sy2 += f2Integral * f2Integral;
                    CallChecker.varAssign(sy2, "sy2", 308, 13443, 13473);
                    sxy += x * f2Integral;
                    CallChecker.varAssign(sxy, "sxy", 309, 13491, 13512);
                    sxz += x * fPrime2Integral;
                    CallChecker.varAssign(sxz, "sxz", 310, 13530, 13556);
                    syz += f2Integral * fPrime2Integral;
                    CallChecker.varAssign(syz, "syz", 311, 13574, 13609);
                }
                double c1 = CallChecker.varInit(((double) ((sy2 * sxz) - (sxy * syz))), "c1", 315, 13702, 13735);
                double c2 = CallChecker.varInit(((double) ((sxy * sxz) - (sx2 * syz))), "c2", 316, 13749, 13782);
                double c3 = CallChecker.varInit(((double) ((sx2 * sy2) - (sxy * sxy))), "c3", 317, 13796, 13829);
                if (((c1 / c2) < 0) || ((c2 / c3) < 0)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 319, 13914, 13925);
                    final int last = CallChecker.varInit(((int) ((CallChecker.isCalled(observations, WeightedObservedPoint[].class, 319, 13914, 13925).length) - 1)), "last", 319, 13897, 13937);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 322, 14085, 14096);
                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14085, 14096)[last] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14085, 14096)[last], WeightedObservedPoint.class, 322, 14085, 14102);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 322, 14113, 14124);
                    CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14113, 14124)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14113, 14124)[0], WeightedObservedPoint.class, 322, 14113, 14127);
                    final double xRange = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14085, 14096)[last], WeightedObservedPoint.class, 322, 14085, 14102).getX()) - (CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 322, 14113, 14124)[0], WeightedObservedPoint.class, 322, 14113, 14127).getX()))), "xRange", 322, 13955, 14135);
                    if (xRange == 0) {
                        throw new ZeroException();
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 326, 14253, 14258)) {
                        CallChecker.isCalled(aOmega, double[].class, 326, 14253, 14258)[1] = (2 * (Math.PI)) / xRange;
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 326, 14253, 14258)[1], "CallChecker.isCalled(aOmega, double[].class, 326, 14253, 14258)[1]", 326, 14253, 14285);
                    }
                    double yMin = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "yMin", 328, 14304, 14342);
                    double yMax = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "yMax", 329, 14360, 14398);
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 330, 14436, 14447);
                    for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 330, 14436, 14447).length); ++i) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 331, 14501, 14512);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 331, 14501, 14512)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 331, 14501, 14512)[i], WeightedObservedPoint.class, 331, 14501, 14515);
                        final double y = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 331, 14501, 14512)[i], WeightedObservedPoint.class, 331, 14501, 14515).getY())), "y", 331, 14484, 14523);
                        if (y < yMin) {
                            yMin = y;
                            CallChecker.varAssign(yMin, "yMin", 333, 14585, 14593);
                        }
                        if (y > yMax) {
                            yMax = y;
                            CallChecker.varAssign(yMax, "yMax", 336, 14677, 14685);
                        }
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 339, 14743, 14748)) {
                        CallChecker.isCalled(aOmega, double[].class, 339, 14743, 14748)[0] = 0.5 * (yMax - yMin);
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 339, 14743, 14748)[0], "CallChecker.isCalled(aOmega, double[].class, 339, 14743, 14748)[0]", 339, 14743, 14774);
                    }
                }else {
                    if (c2 == 0) {
                        throw new MathIllegalStateException(LocalizedFormats.ZERO_DENOMINATOR);
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 347, 15102, 15107)) {
                        CallChecker.isCalled(aOmega, double[].class, 347, 15102, 15107)[0] = FastMath.sqrt((c1 / c2));
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 347, 15102, 15107)[0], "CallChecker.isCalled(aOmega, double[].class, 347, 15102, 15107)[0]", 347, 15102, 15136);
                    }
                    if (CallChecker.beforeDeref(aOmega, double[].class, 348, 15154, 15159)) {
                        CallChecker.isCalled(aOmega, double[].class, 348, 15154, 15159)[1] = FastMath.sqrt((c2 / c3));
                        CallChecker.varAssign(CallChecker.isCalled(aOmega, double[].class, 348, 15154, 15159)[1], "CallChecker.isCalled(aOmega, double[].class, 348, 15154, 15159)[1]", 348, 15154, 15188);
                    }
                }
                return aOmega;
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context367.methodEnd();
            }
        }

        private double guessPhi(WeightedObservedPoint[] observations) {
            MethodContext _bcornu_methode_context368 = new MethodContext(double.class, 360, 15251, 16490);
            try {
                CallChecker.varInit(this, "this", 360, 15251, 16490);
                CallChecker.varInit(observations, "observations", 360, 15251, 16490);
                CallChecker.varInit(this.phi, "phi", 360, 15251, 16490);
                CallChecker.varInit(this.omega, "omega", 360, 15251, 16490);
                CallChecker.varInit(this.a, "a", 360, 15251, 16490);
                double fcMean = CallChecker.varInit(((double) (0)), "fcMean", 362, 15553, 15570);
                double fsMean = CallChecker.varInit(((double) (0)), "fsMean", 363, 15584, 15601);
                double currentX = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 365, 15634, 15645)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645)[0], WeightedObservedPoint.class, 365, 15634, 15648)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645)[0], WeightedObservedPoint.class, 365, 15634, 15648);
                        currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 365, 15634, 15645)[0], WeightedObservedPoint.class, 365, 15634, 15648).getX();
                        CallChecker.varAssign(currentX, "currentX", 365, 15634, 15645);
                    }
                }
                double currentY = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 366, 15688, 15699)) {
                    observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699)[0], WeightedObservedPoint.class, 366, 15688, 15702)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699);
                        CallChecker.isCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699)[0] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699)[0], WeightedObservedPoint.class, 366, 15688, 15702);
                        currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 366, 15688, 15699)[0], WeightedObservedPoint.class, 366, 15688, 15702).getY();
                        CallChecker.varAssign(currentY, "currentY", 366, 15688, 15699);
                    }
                }
                observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 367, 15744, 15755);
                for (int i = 1; i < (CallChecker.isCalled(observations, WeightedObservedPoint[].class, 367, 15744, 15755).length); ++i) {
                    final double previousX = CallChecker.varInit(((double) (currentX)), "previousX", 369, 15788, 15857);
                    final double previousY = CallChecker.varInit(((double) (currentY)), "previousY", 370, 15875, 15908);
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 371, 15937, 15948)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948)[i], WeightedObservedPoint.class, 371, 15937, 15951)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948)[i], WeightedObservedPoint.class, 371, 15937, 15951);
                            currentX = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 371, 15937, 15948)[i], WeightedObservedPoint.class, 371, 15937, 15951).getX();
                            CallChecker.varAssign(currentX, "currentX", 371, 15926, 15959);
                        }
                    }
                    if (CallChecker.beforeDeref(observations, WeightedObservedPoint[].class, 372, 15988, 15999)) {
                        observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999)[i], WeightedObservedPoint.class, 372, 15988, 16002)) {
                            observations = CallChecker.beforeCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999);
                            CallChecker.isCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999)[i] = CallChecker.beforeCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999)[i], WeightedObservedPoint.class, 372, 15988, 16002);
                            currentY = CallChecker.isCalled(CallChecker.isCalled(observations, WeightedObservedPoint[].class, 372, 15988, 15999)[i], WeightedObservedPoint.class, 372, 15988, 16002).getY();
                            CallChecker.varAssign(currentY, "currentY", 372, 15977, 16010);
                        }
                    }
                    final double currentYPrime = CallChecker.varInit(((double) ((currentY - previousY) / (currentX - previousX))), "currentYPrime", 373, 16028, 16104);
                    double omegaX = CallChecker.varInit(((double) ((this.omega) * currentX)), "omegaX", 375, 16123, 16155);
                    double cosine = CallChecker.varInit(((double) (FastMath.cos(omegaX))), "cosine", 376, 16173, 16209);
                    double sine = CallChecker.varInit(((double) (FastMath.sin(omegaX))), "sine", 377, 16227, 16261);
                    fcMean += (((omega) * currentY) * cosine) - (currentYPrime * sine);
                    CallChecker.varAssign(fcMean, "fcMean", 378, 16279, 16337);
                    fsMean += (((omega) * currentY) * sine) + (currentYPrime * cosine);
                    CallChecker.varAssign(fsMean, "fsMean", 379, 16355, 16413);
                }
                return FastMath.atan2((-fsMean), fcMean);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context368.methodEnd();
            }
        }
    }

    public HarmonicFitter(final DifferentiableMultivariateVectorOptimizer optimizer) {
        super(optimizer);
        ConstructorContext _bcornu_methode_context98 = new ConstructorContext(HarmonicFitter.class, 47, 1893, 2107);
        try {
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    public double[] fit(double[] initialGuess) {
        MethodContext _bcornu_methode_context369 = new MethodContext(double[].class, 63, 2114, 2620);
        try {
            CallChecker.varInit(this, "this", 63, 2114, 2620);
            CallChecker.varInit(initialGuess, "initialGuess", 63, 2114, 2620);
            return fit(new HarmonicOscillator.Parametric(), initialGuess);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context369.methodEnd();
        }
    }

    public double[] fit() {
        MethodContext _bcornu_methode_context370 = new MethodContext(double[].class, 78, 2627, 3233);
        try {
            CallChecker.varInit(this, "this", 78, 2627, 3233);
            if (CallChecker.beforeDeref(new HarmonicFitter.ParameterGuesser(getObservations()), HarmonicFitter.ParameterGuesser.class, 79, 3177, 3217)) {
                return fit(CallChecker.isCalled(new HarmonicFitter.ParameterGuesser(getObservations()), HarmonicFitter.ParameterGuesser.class, 79, 3177, 3217).guess());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context370.methodEnd();
        }
    }
}

