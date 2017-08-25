package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class RootsOfUnity implements Serializable {
    private static final long serialVersionUID = 20120201L;

    private int omegaCount;

    private double[] omegaReal;

    private double[] omegaImaginaryCounterClockwise;

    private double[] omegaImaginaryClockwise;

    private boolean isCounterClockWise;

    public RootsOfUnity() {
        ConstructorContext _bcornu_methode_context182 = new ConstructorContext(RootsOfUnity.class, 69, 2387, 2674);
        try {
            omegaCount = 0;
            CallChecker.varAssign(this.omegaCount, "this.omegaCount", 71, 2506, 2520);
            omegaReal = null;
            CallChecker.varAssign(this.omegaReal, "this.omegaReal", 72, 2530, 2546);
            omegaImaginaryCounterClockwise = null;
            CallChecker.varAssign(this.omegaImaginaryCounterClockwise, "this.omegaImaginaryCounterClockwise", 73, 2556, 2593);
            omegaImaginaryClockwise = null;
            CallChecker.varAssign(this.omegaImaginaryClockwise, "this.omegaImaginaryClockwise", 74, 2603, 2633);
            isCounterClockWise = true;
            CallChecker.varAssign(this.isCounterClockWise, "this.isCounterClockWise", 75, 2643, 2668);
        } finally {
            _bcornu_methode_context182.methodEnd();
        }
    }

    public synchronized boolean isCounterClockWise() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context680 = new MethodContext(boolean.class, 88, 2681, 3407);
        try {
            CallChecker.varInit(this, "this", 88, 2681, 3407);
            CallChecker.varInit(this.isCounterClockWise, "isCounterClockWise", 88, 2681, 3407);
            CallChecker.varInit(this.omegaImaginaryClockwise, "omegaImaginaryClockwise", 88, 2681, 3407);
            CallChecker.varInit(this.omegaImaginaryCounterClockwise, "omegaImaginaryCounterClockwise", 88, 2681, 3407);
            CallChecker.varInit(this.omegaReal, "omegaReal", 88, 2681, 3407);
            CallChecker.varInit(this.omegaCount, "omegaCount", 88, 2681, 3407);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.RootsOfUnity.serialVersionUID", 88, 2681, 3407);
            if ((omegaCount) == 0) {
                throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET);
            }
            return isCounterClockWise;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context680.methodEnd();
        }
    }

    public synchronized void computeRoots(int n) throws ZeroException {
        MethodContext _bcornu_methode_context681 = new MethodContext(void.class, 117, 3414, 5423);
        try {
            CallChecker.varInit(this, "this", 117, 3414, 5423);
            CallChecker.varInit(n, "n", 117, 3414, 5423);
            CallChecker.varInit(this.isCounterClockWise, "isCounterClockWise", 117, 3414, 5423);
            CallChecker.varInit(this.omegaImaginaryClockwise, "omegaImaginaryClockwise", 117, 3414, 5423);
            CallChecker.varInit(this.omegaImaginaryCounterClockwise, "omegaImaginaryCounterClockwise", 117, 3414, 5423);
            CallChecker.varInit(this.omegaReal, "omegaReal", 117, 3414, 5423);
            CallChecker.varInit(this.omegaCount, "omegaCount", 117, 3414, 5423);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.RootsOfUnity.serialVersionUID", 117, 3414, 5423);
            if (n == 0) {
                throw new ZeroException(LocalizedFormats.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY);
            }
            isCounterClockWise = n > 0;
            CallChecker.varAssign(this.isCounterClockWise, "this.isCounterClockWise", 124, 4373, 4399);
            final int absN = CallChecker.varInit(((int) (FastMath.abs(n))), "absN", 127, 4410, 4483);
            if (absN == (omegaCount)) {
                return ;
            }
            final double t = CallChecker.varInit(((double) ((2.0 * (FastMath.PI)) / absN)), "t", 134, 4559, 4645);
            final double cosT = CallChecker.varInit(((double) (FastMath.cos(t))), "cosT", 135, 4655, 4690);
            final double sinT = CallChecker.varInit(((double) (FastMath.sin(t))), "sinT", 136, 4700, 4735);
            omegaReal = new double[absN];
            CallChecker.varAssign(this.omegaReal, "this.omegaReal", 137, 4745, 4773);
            omegaImaginaryCounterClockwise = new double[absN];
            CallChecker.varAssign(this.omegaImaginaryCounterClockwise, "this.omegaImaginaryCounterClockwise", 138, 4783, 4832);
            omegaImaginaryClockwise = new double[absN];
            CallChecker.varAssign(this.omegaImaginaryClockwise, "this.omegaImaginaryClockwise", 139, 4842, 4884);
            if (CallChecker.beforeDeref(omegaReal, double[].class, 140, 4894, 4902)) {
                omegaReal = CallChecker.beforeCalled(omegaReal, double[].class, 140, 4894, 4902);
                CallChecker.isCalled(omegaReal, double[].class, 140, 4894, 4902)[0] = 1.0;
                CallChecker.varAssign(CallChecker.isCalled(this.omegaReal, double[].class, 140, 4894, 4902)[0], "CallChecker.isCalled(this.omegaReal, double[].class, 140, 4894, 4902)[0]", 140, 4894, 4912);
            }
            if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 141, 4922, 4951)) {
                omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 141, 4922, 4951);
                CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 141, 4922, 4951)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(this.omegaImaginaryCounterClockwise, double[].class, 141, 4922, 4951)[0], "CallChecker.isCalled(this.omegaImaginaryCounterClockwise, double[].class, 141, 4922, 4951)[0]", 141, 4922, 4961);
            }
            if (CallChecker.beforeDeref(omegaImaginaryClockwise, double[].class, 142, 4971, 4993)) {
                omegaImaginaryClockwise = CallChecker.beforeCalled(omegaImaginaryClockwise, double[].class, 142, 4971, 4993);
                CallChecker.isCalled(omegaImaginaryClockwise, double[].class, 142, 4971, 4993)[0] = 0.0;
                CallChecker.varAssign(CallChecker.isCalled(this.omegaImaginaryClockwise, double[].class, 142, 4971, 4993)[0], "CallChecker.isCalled(this.omegaImaginaryClockwise, double[].class, 142, 4971, 4993)[0]", 142, 4971, 5003);
            }
            for (int i = 1; i < absN; i++) {
                if (CallChecker.beforeDeref(omegaReal, double[].class, 144, 5058, 5066)) {
                    if (CallChecker.beforeDeref(omegaReal, double[].class, 144, 5073, 5081)) {
                        if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 145, 5119, 5148)) {
                            omegaReal = CallChecker.beforeCalled(omegaReal, double[].class, 144, 5058, 5066);
                            omegaReal = CallChecker.beforeCalled(omegaReal, double[].class, 144, 5073, 5081);
                            omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 145, 5119, 5148);
                            CallChecker.isCalled(omegaReal, double[].class, 144, 5058, 5066)[i] = ((CallChecker.isCalled(omegaReal, double[].class, 144, 5073, 5081)[(i - 1)]) * cosT) - ((CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 145, 5119, 5148)[(i - 1)]) * sinT);
                            CallChecker.varAssign(CallChecker.isCalled(this.omegaReal, double[].class, 144, 5058, 5066)[i], "CallChecker.isCalled(this.omegaReal, double[].class, 144, 5058, 5066)[i]", 144, 5058, 5163);
                        }
                    }
                }
                if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 146, 5177, 5206)) {
                    if (CallChecker.beforeDeref(omegaReal, double[].class, 146, 5213, 5221)) {
                        if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 147, 5259, 5288)) {
                            omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 146, 5177, 5206);
                            omegaReal = CallChecker.beforeCalled(omegaReal, double[].class, 146, 5213, 5221);
                            omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 147, 5259, 5288);
                            CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 146, 5177, 5206)[i] = ((CallChecker.isCalled(omegaReal, double[].class, 146, 5213, 5221)[(i - 1)]) * sinT) + ((CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 147, 5259, 5288)[(i - 1)]) * cosT);
                            CallChecker.varAssign(CallChecker.isCalled(this.omegaImaginaryCounterClockwise, double[].class, 146, 5177, 5206)[i], "CallChecker.isCalled(this.omegaImaginaryCounterClockwise, double[].class, 146, 5177, 5206)[i]", 146, 5177, 5303);
                        }
                    }
                }
                if (CallChecker.beforeDeref(omegaImaginaryClockwise, double[].class, 148, 5317, 5339)) {
                    if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 148, 5347, 5376)) {
                        omegaImaginaryClockwise = CallChecker.beforeCalled(omegaImaginaryClockwise, double[].class, 148, 5317, 5339);
                        omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 148, 5347, 5376);
                        CallChecker.isCalled(omegaImaginaryClockwise, double[].class, 148, 5317, 5339)[i] = -(CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 148, 5347, 5376)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(this.omegaImaginaryClockwise, double[].class, 148, 5317, 5339)[i], "CallChecker.isCalled(this.omegaImaginaryClockwise, double[].class, 148, 5317, 5339)[i]", 148, 5317, 5380);
                    }
                }
            }
            omegaCount = absN;
            CallChecker.varAssign(this.omegaCount, "this.omegaCount", 150, 5400, 5417);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context681.methodEnd();
        }
    }

    public synchronized double getReal(int k) throws MathIllegalArgumentException, MathIllegalStateException {
        MethodContext _bcornu_methode_context682 = new MethodContext(double.class, 162, 5430, 6436);
        try {
            CallChecker.varInit(this, "this", 162, 5430, 6436);
            CallChecker.varInit(k, "k", 162, 5430, 6436);
            CallChecker.varInit(this.isCounterClockWise, "isCounterClockWise", 162, 5430, 6436);
            CallChecker.varInit(this.omegaImaginaryClockwise, "omegaImaginaryClockwise", 162, 5430, 6436);
            CallChecker.varInit(this.omegaImaginaryCounterClockwise, "omegaImaginaryCounterClockwise", 162, 5430, 6436);
            CallChecker.varInit(this.omegaReal, "omegaReal", 162, 5430, 6436);
            CallChecker.varInit(this.omegaCount, "omegaCount", 162, 5430, 6436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.RootsOfUnity.serialVersionUID", 162, 5430, 6436);
            if ((omegaCount) == 0) {
                throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET);
            }
            if ((k < 0) || (k >= (omegaCount))) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(((omegaCount) - 1)));
            }
            if (CallChecker.beforeDeref(omegaReal, double[].class, 177, 6418, 6426)) {
                omegaReal = CallChecker.beforeCalled(omegaReal, double[].class, 177, 6418, 6426);
                return CallChecker.isCalled(omegaReal, double[].class, 177, 6418, 6426)[k];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context682.methodEnd();
        }
    }

    public synchronized double getImaginary(int k) throws MathIllegalStateException, OutOfRangeException {
        MethodContext _bcornu_methode_context683 = new MethodContext(double.class, 189, 6443, 7529);
        try {
            CallChecker.varInit(this, "this", 189, 6443, 7529);
            CallChecker.varInit(k, "k", 189, 6443, 7529);
            CallChecker.varInit(this.isCounterClockWise, "isCounterClockWise", 189, 6443, 7529);
            CallChecker.varInit(this.omegaImaginaryClockwise, "omegaImaginaryClockwise", 189, 6443, 7529);
            CallChecker.varInit(this.omegaImaginaryCounterClockwise, "omegaImaginaryCounterClockwise", 189, 6443, 7529);
            CallChecker.varInit(this.omegaReal, "omegaReal", 189, 6443, 7529);
            CallChecker.varInit(this.omegaCount, "omegaCount", 189, 6443, 7529);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.RootsOfUnity.serialVersionUID", 189, 6443, 7529);
            if ((omegaCount) == 0) {
                throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET);
            }
            if ((k < 0) || (k >= (omegaCount))) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(((omegaCount) - 1)));
            }
            if (isCounterClockWise) {
                if (CallChecker.beforeDeref(omegaImaginaryCounterClockwise, double[].class, 204, 7449, 7478)) {
                    omegaImaginaryCounterClockwise = CallChecker.beforeCalled(omegaImaginaryCounterClockwise, double[].class, 204, 7449, 7478);
                    return CallChecker.isCalled(omegaImaginaryCounterClockwise, double[].class, 204, 7449, 7478)[k];
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(omegaImaginaryClockwise, double[].class, 205, 7497, 7519)) {
                    omegaImaginaryClockwise = CallChecker.beforeCalled(omegaImaginaryClockwise, double[].class, 205, 7497, 7519);
                    return CallChecker.isCalled(omegaImaginaryClockwise, double[].class, 205, 7497, 7519)[k];
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context683.methodEnd();
        }
    }

    public synchronized int getNumberOfRoots() {
        MethodContext _bcornu_methode_context684 = new MethodContext(int.class, 216, 7536, 7945);
        try {
            CallChecker.varInit(this, "this", 216, 7536, 7945);
            CallChecker.varInit(this.isCounterClockWise, "isCounterClockWise", 216, 7536, 7945);
            CallChecker.varInit(this.omegaImaginaryClockwise, "omegaImaginaryClockwise", 216, 7536, 7945);
            CallChecker.varInit(this.omegaImaginaryCounterClockwise, "omegaImaginaryCounterClockwise", 216, 7536, 7945);
            CallChecker.varInit(this.omegaReal, "omegaReal", 216, 7536, 7945);
            CallChecker.varInit(this.omegaCount, "omegaCount", 216, 7536, 7945);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.complex.RootsOfUnity.serialVersionUID", 216, 7536, 7945);
            return omegaCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context684.methodEnd();
        }
    }
}

