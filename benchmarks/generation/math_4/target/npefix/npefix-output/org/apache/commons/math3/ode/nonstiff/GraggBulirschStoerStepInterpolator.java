package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

class GraggBulirschStoerStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = 20110928L;

    private double[] y0Dot;

    private double[] y1;

    private double[] y1Dot;

    private double[][] yMidDots;

    private double[][] polynomials;

    private double[] errfac;

    private int currentDegree;

    public GraggBulirschStoerStepInterpolator() {
        ConstructorContext _bcornu_methode_context1233 = new ConstructorContext(GraggBulirschStoerStepInterpolator.class, 111, 4192, 4484);
        try {
            y0Dot = null;
            CallChecker.varAssign(this.y0Dot, "this.y0Dot", 112, 4381, 4396);
            y1 = null;
            CallChecker.varAssign(this.y1, "this.y1", 113, 4402, 4417);
            y1Dot = null;
            CallChecker.varAssign(this.y1Dot, "this.y1Dot", 114, 4423, 4438);
            yMidDots = null;
            CallChecker.varAssign(this.yMidDots, "this.yMidDots", 115, 4444, 4459);
            resetTables((-1));
        } finally {
            _bcornu_methode_context1233.methodEnd();
        }
    }

    public GraggBulirschStoerStepInterpolator(final double[] y, final double[] y0Dot, final double[] y1, final double[] y1Dot, final double[][] yMidDots, final boolean forward, final EquationsMapper primaryMapper, final EquationsMapper[] secondaryMappers) {
        super(y, forward, primaryMapper, secondaryMappers);
        ConstructorContext _bcornu_methode_context1234 = new ConstructorContext(GraggBulirschStoerStepInterpolator.class, 133, 4489, 5894);
        try {
            this.y0Dot = y0Dot;
            CallChecker.varAssign(this.y0Dot, "this.y0Dot", 141, 5748, 5769);
            this.y1 = y1;
            CallChecker.varAssign(this.y1, "this.y1", 142, 5775, 5793);
            this.y1Dot = y1Dot;
            CallChecker.varAssign(this.y1Dot, "this.y1Dot", 143, 5799, 5820);
            this.yMidDots = yMidDots;
            CallChecker.varAssign(this.yMidDots, "this.yMidDots", 144, 5826, 5850);
            if (CallChecker.beforeDeref(yMidDots, double[][].class, 146, 5869, 5876)) {
                resetTables(((CallChecker.isCalled(yMidDots, double[][].class, 146, 5869, 5876).length) + 4));
            }
        } finally {
            _bcornu_methode_context1234.methodEnd();
        }
    }

    public GraggBulirschStoerStepInterpolator(final GraggBulirschStoerStepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context1235 = new ConstructorContext(GraggBulirschStoerStepInterpolator.class, 155, 5899, 6952);
        try {
            currentState = CallChecker.beforeCalled(currentState, double[].class, 160, 6239, 6250);
            final int dimension = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentState, double[].class, 160, 6239, 6250).length)), "dimension", 160, 6217, 6258);
            y0Dot = null;
            CallChecker.varAssign(this.y0Dot, "this.y0Dot", 164, 6360, 6375);
            y1 = null;
            CallChecker.varAssign(this.y1, "this.y1", 165, 6381, 6396);
            y1Dot = null;
            CallChecker.varAssign(this.y1Dot, "this.y1Dot", 166, 6402, 6417);
            yMidDots = null;
            CallChecker.varAssign(this.yMidDots, "this.yMidDots", 167, 6423, 6438);
            if (CallChecker.beforeDeref(interpolator, GraggBulirschStoerStepInterpolator.class, 170, 6523, 6534)) {
                if ((CallChecker.isCalled(interpolator, GraggBulirschStoerStepInterpolator.class, 170, 6523, 6534).polynomials) == null) {
                    polynomials = null;
                    CallChecker.varAssign(this.polynomials, "this.polynomials", 171, 6565, 6583);
                    currentDegree = -1;
                    CallChecker.varAssign(this.currentDegree, "this.currentDegree", 172, 6591, 6609);
                }else {
                    if (CallChecker.beforeDeref(interpolator, GraggBulirschStoerStepInterpolator.class, 174, 6642, 6653)) {
                        resetTables(CallChecker.isCalled(interpolator, GraggBulirschStoerStepInterpolator.class, 174, 6642, 6653).currentDegree);
                    }
                    for (int i = 0; i < (polynomials.length); ++i) {
                        polynomials[i] = new double[dimension];
                        CallChecker.varAssign(this.polynomials[i], "this.polynomials[i]", 176, 6732, 6770);
                        if (CallChecker.beforeDeref(interpolator, GraggBulirschStoerStepInterpolator.class, 177, 6797, 6808)) {
                            System.arraycopy(CallChecker.isCalled(interpolator, GraggBulirschStoerStepInterpolator.class, 177, 6797, 6808).polynomials[i], 0, polynomials[i], 0, dimension);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, GraggBulirschStoerStepInterpolator.class, 180, 6915, 6926)) {
                        currentDegree = CallChecker.isCalled(interpolator, GraggBulirschStoerStepInterpolator.class, 180, 6915, 6926).currentDegree;
                        CallChecker.varAssign(this.currentDegree, "this.currentDegree", 180, 6899, 6941);
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context1235.methodEnd();
        }
    }

    private void resetTables(final int maxDegree) {
        MethodContext _bcornu_methode_context5549 = new MethodContext(void.class, 190, 6957, 8327);
        try {
            CallChecker.varInit(this, "this", 190, 6957, 8327);
            CallChecker.varInit(maxDegree, "maxDegree", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 190, 6957, 8327);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 190, 6957, 8327);
            CallChecker.varInit(this.currentState, "currentState", 190, 6957, 8327);
            CallChecker.varInit(this.h, "h", 190, 6957, 8327);
            CallChecker.varInit(this.currentDegree, "currentDegree", 190, 6957, 8327);
            CallChecker.varInit(this.errfac, "errfac", 190, 6957, 8327);
            CallChecker.varInit(this.polynomials, "polynomials", 190, 6957, 8327);
            CallChecker.varInit(this.yMidDots, "yMidDots", 190, 6957, 8327);
            CallChecker.varInit(this.y1Dot, "y1Dot", 190, 6957, 8327);
            CallChecker.varInit(this.y1, "y1", 190, 6957, 8327);
            CallChecker.varInit(this.y0Dot, "y0Dot", 190, 6957, 8327);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 190, 6957, 8327);
            if (maxDegree < 0) {
                polynomials = null;
                CallChecker.varAssign(this.polynomials, "this.polynomials", 193, 7248, 7268);
                errfac = null;
                CallChecker.varAssign(this.errfac, "this.errfac", 194, 7276, 7296);
                currentDegree = -1;
                CallChecker.varAssign(this.currentDegree, "this.currentDegree", 195, 7304, 7322);
            }else {
                final double[][] newPols = CallChecker.varInit(new double[maxDegree + 1][], "newPols", 198, 7344, 7398);
                if ((polynomials) != null) {
                    System.arraycopy(polynomials, 0, newPols, 0, polynomials.length);
                    for (int i = polynomials.length; i < (CallChecker.isCalled(newPols, double[][].class, 201, 7552, 7558).length); ++i) {
                        if (CallChecker.beforeDeref(newPols, double[][].class, 202, 7585, 7591)) {
                            if (CallChecker.beforeDeref(currentState, double[].class, 202, 7609, 7620)) {
                                currentState = CallChecker.beforeCalled(currentState, double[].class, 202, 7609, 7620);
                                CallChecker.isCalled(newPols, double[][].class, 202, 7585, 7591)[i] = new double[CallChecker.isCalled(currentState, double[].class, 202, 7609, 7620).length];
                                CallChecker.varAssign(CallChecker.isCalled(newPols, double[][].class, 202, 7585, 7591)[i], "CallChecker.isCalled(newPols, double[][].class, 202, 7585, 7591)[i]", 202, 7585, 7629);
                            }
                        }
                    }
                }else {
                    for (int i = 0; i < (CallChecker.isCalled(newPols, double[][].class, 205, 7684, 7690).length); ++i) {
                        if (CallChecker.beforeDeref(newPols, double[][].class, 206, 7717, 7723)) {
                            if (CallChecker.beforeDeref(currentState, double[].class, 206, 7741, 7752)) {
                                currentState = CallChecker.beforeCalled(currentState, double[].class, 206, 7741, 7752);
                                CallChecker.isCalled(newPols, double[][].class, 206, 7717, 7723)[i] = new double[CallChecker.isCalled(currentState, double[].class, 206, 7741, 7752).length];
                                CallChecker.varAssign(CallChecker.isCalled(newPols, double[][].class, 206, 7717, 7723)[i], "CallChecker.isCalled(newPols, double[][].class, 206, 7717, 7723)[i]", 206, 7717, 7761);
                            }
                        }
                    }
                }
                polynomials = newPols;
                CallChecker.varAssign(this.polynomials, "this.polynomials", 209, 7787, 7808);
                if (maxDegree <= 4) {
                    errfac = null;
                    CallChecker.varAssign(this.errfac, "this.errfac", 213, 7909, 7922);
                }else {
                    errfac = new double[maxDegree - 4];
                    CallChecker.varAssign(this.errfac, "this.errfac", 215, 7947, 7981);
                    errfac = CallChecker.beforeCalled(errfac, double[].class, 216, 8011, 8016);
                    for (int i = 0; i < (CallChecker.isCalled(errfac, double[].class, 216, 8011, 8016).length); ++i) {
                        final int ip5 = CallChecker.varInit(((int) (i + 5)), "ip5", 217, 8043, 8064);
                        if (CallChecker.beforeDeref(errfac, double[].class, 218, 8076, 8081)) {
                            errfac = CallChecker.beforeCalled(errfac, double[].class, 218, 8076, 8081);
                            CallChecker.isCalled(errfac, double[].class, 218, 8076, 8081)[i] = 1.0 / (ip5 * ip5);
                            CallChecker.varAssign(CallChecker.isCalled(this.errfac, double[].class, 218, 8076, 8081)[i], "CallChecker.isCalled(this.errfac, double[].class, 218, 8076, 8081)[i]", 218, 8076, 8105);
                        }
                        final double e = CallChecker.varInit(((double) (0.5 * (FastMath.sqrt((((double) (i + 1)) / ip5))))), "e", 219, 8117, 8180);
                        for (int j = 0; j <= i; ++j) {
                            if (CallChecker.beforeDeref(errfac, double[].class, 221, 8235, 8240)) {
                                errfac = CallChecker.beforeCalled(errfac, double[].class, 221, 8235, 8240);
                                CallChecker.isCalled(errfac, double[].class, 221, 8235, 8240)[i] *= e / (j + 1);
                                CallChecker.varAssign(CallChecker.isCalled(this.errfac, double[].class, 221, 8235, 8240)[i], "CallChecker.isCalled(this.errfac, double[].class, 221, 8235, 8240)[i]", 221, 8235, 8259);
                            }
                        }
                    }
                }
                currentDegree = 0;
                CallChecker.varAssign(this.currentDegree, "this.currentDegree", 226, 8298, 8315);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5549.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context5550 = new MethodContext(StepInterpolator.class, 234, 8332, 8464);
        try {
            CallChecker.varInit(this, "this", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 234, 8332, 8464);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 234, 8332, 8464);
            CallChecker.varInit(this.currentState, "currentState", 234, 8332, 8464);
            CallChecker.varInit(this.h, "h", 234, 8332, 8464);
            CallChecker.varInit(this.currentDegree, "currentDegree", 234, 8332, 8464);
            CallChecker.varInit(this.errfac, "errfac", 234, 8332, 8464);
            CallChecker.varInit(this.polynomials, "polynomials", 234, 8332, 8464);
            CallChecker.varInit(this.yMidDots, "yMidDots", 234, 8332, 8464);
            CallChecker.varInit(this.y1Dot, "y1Dot", 234, 8332, 8464);
            CallChecker.varInit(this.y1, "y1", 234, 8332, 8464);
            CallChecker.varInit(this.y0Dot, "y0Dot", 234, 8332, 8464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 234, 8332, 8464);
            return new GraggBulirschStoerStepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5550.methodEnd();
        }
    }

    public void computeCoefficients(final int mu, final double h) {
        MethodContext _bcornu_methode_context5551 = new MethodContext(void.class, 243, 8470, 10238);
        try {
            CallChecker.varInit(this, "this", 243, 8470, 10238);
            CallChecker.varInit(h, "h", 243, 8470, 10238);
            CallChecker.varInit(mu, "mu", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 243, 8470, 10238);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 243, 8470, 10238);
            CallChecker.varInit(this.currentState, "currentState", 243, 8470, 10238);
            CallChecker.varInit(this.h, "h", 243, 8470, 10238);
            CallChecker.varInit(this.currentDegree, "currentDegree", 243, 8470, 10238);
            CallChecker.varInit(this.errfac, "errfac", 243, 8470, 10238);
            CallChecker.varInit(this.polynomials, "polynomials", 243, 8470, 10238);
            CallChecker.varInit(this.yMidDots, "yMidDots", 243, 8470, 10238);
            CallChecker.varInit(this.y1Dot, "y1Dot", 243, 8470, 10238);
            CallChecker.varInit(this.y1, "y1", 243, 8470, 10238);
            CallChecker.varInit(this.y0Dot, "y0Dot", 243, 8470, 10238);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 243, 8470, 10238);
            if (((polynomials) == null) || ((polynomials.length) <= (mu + 4))) {
                resetTables((mu + 4));
            }
            currentDegree = mu + 4;
            CallChecker.varAssign(this.currentDegree, "this.currentDegree", 249, 8792, 8814);
            currentState = CallChecker.beforeCalled(currentState, double[].class, 251, 8841, 8852);
            for (int i = 0; i < (CallChecker.isCalled(currentState, double[].class, 251, 8841, 8852).length); ++i) {
                y0Dot = CallChecker.beforeCalled(y0Dot, double[].class, 253, 8901, 8905);
                final double yp0 = CallChecker.varInit(((double) (h * (CallChecker.isCalled(this.y0Dot, double[].class, 253, 8901, 8905)[i]))), "yp0", 253, 8876, 8909);
                y1Dot = CallChecker.beforeCalled(y1Dot, double[].class, 254, 8942, 8946);
                final double yp1 = CallChecker.varInit(((double) (h * (CallChecker.isCalled(this.y1Dot, double[].class, 254, 8942, 8946)[i]))), "yp1", 254, 8917, 8950);
                y1 = CallChecker.beforeCalled(y1, double[].class, 255, 8979, 8980);
                currentState = CallChecker.beforeCalled(currentState, double[].class, 255, 8987, 8998);
                final double ydiff = CallChecker.varInit(((double) ((CallChecker.isCalled(this.y1, double[].class, 255, 8979, 8980)[i]) - (CallChecker.isCalled(this.currentState, double[].class, 255, 8987, 8998)[i]))), "ydiff", 255, 8958, 9002);
                final double aspl = CallChecker.varInit(((double) (ydiff - yp1)), "aspl", 256, 9010, 9042);
                final double bspl = CallChecker.varInit(((double) (yp0 - ydiff)), "bspl", 257, 9050, 9082);
                if (CallChecker.beforeDeref(polynomials, double[][].class, 259, 9091, 9101)) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 259, 9091, 9101);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 259, 9091, 9101)[0], double[].class, 259, 9091, 9104)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 259, 9111, 9122)) {
                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 259, 9091, 9101);
                            CallChecker.isCalled(polynomials, double[][].class, 259, 9091, 9101)[0] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 259, 9091, 9101)[0], double[].class, 259, 9091, 9104);
                            currentState = CallChecker.beforeCalled(currentState, double[].class, 259, 9111, 9122);
                            CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 259, 9091, 9101)[0], double[].class, 259, 9091, 9104)[i] = CallChecker.isCalled(currentState, double[].class, 259, 9111, 9122)[i];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 259, 9091, 9101)[0], double[].class, 259, 9091, 9104)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 259, 9091, 9101)[0], double[].class, 259, 9091, 9104)[i]", 259, 9091, 9126);
                        }
                    }
                }
                if (CallChecker.beforeDeref(polynomials, double[][].class, 260, 9134, 9144)) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 260, 9134, 9144);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 260, 9134, 9144)[1], double[].class, 260, 9134, 9147)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 260, 9134, 9144);
                        CallChecker.isCalled(polynomials, double[][].class, 260, 9134, 9144)[1] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 260, 9134, 9144)[1], double[].class, 260, 9134, 9147);
                        CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 260, 9134, 9144)[1], double[].class, 260, 9134, 9147)[i] = ydiff;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 260, 9134, 9144)[1], double[].class, 260, 9134, 9147)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 260, 9134, 9144)[1], double[].class, 260, 9134, 9147)[i]", 260, 9134, 9159);
                    }
                }
                if (CallChecker.beforeDeref(polynomials, double[][].class, 261, 9167, 9177)) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 261, 9167, 9177);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 261, 9167, 9177)[2], double[].class, 261, 9167, 9180)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 261, 9167, 9177);
                        CallChecker.isCalled(polynomials, double[][].class, 261, 9167, 9177)[2] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 261, 9167, 9177)[2], double[].class, 261, 9167, 9180);
                        CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 261, 9167, 9177)[2], double[].class, 261, 9167, 9180)[i] = aspl;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 261, 9167, 9177)[2], double[].class, 261, 9167, 9180)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 261, 9167, 9177)[2], double[].class, 261, 9167, 9180)[i]", 261, 9167, 9191);
                    }
                }
                if (CallChecker.beforeDeref(polynomials, double[][].class, 262, 9199, 9209)) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 262, 9199, 9209);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 262, 9199, 9209)[3], double[].class, 262, 9199, 9212)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 262, 9199, 9209);
                        CallChecker.isCalled(polynomials, double[][].class, 262, 9199, 9209)[3] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 262, 9199, 9209)[3], double[].class, 262, 9199, 9212);
                        CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 262, 9199, 9209)[3], double[].class, 262, 9199, 9212)[i] = bspl;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 262, 9199, 9209)[3], double[].class, 262, 9199, 9212)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 262, 9199, 9209)[3], double[].class, 262, 9199, 9212)[i]", 262, 9199, 9223);
                    }
                }
                if (mu < 0) {
                    return ;
                }
                currentState = CallChecker.beforeCalled(currentState, double[].class, 269, 9347, 9358);
                y1 = CallChecker.beforeCalled(y1, double[].class, 269, 9365, 9366);
                final double ph0 = CallChecker.varInit(((double) ((0.5 * ((CallChecker.isCalled(this.currentState, double[].class, 269, 9347, 9358)[i]) + (CallChecker.isCalled(this.y1, double[].class, 269, 9365, 9366)[i]))) + (0.125 * (aspl + bspl)))), "ph0", 269, 9277, 9395);
                if (CallChecker.beforeDeref(polynomials, double[][].class, 270, 9403, 9413)) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 270, 9403, 9413);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 270, 9403, 9413)[4], double[].class, 270, 9403, 9416)) {
                        if (CallChecker.beforeDeref(yMidDots, double[][].class, 270, 9429, 9436)) {
                            yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 270, 9429, 9436);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 270, 9429, 9436)[0], double[].class, 270, 9429, 9439)) {
                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 270, 9403, 9413);
                                CallChecker.isCalled(polynomials, double[][].class, 270, 9403, 9413)[4] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 270, 9403, 9413)[4], double[].class, 270, 9403, 9416);
                                yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 270, 9429, 9436);
                                CallChecker.isCalled(yMidDots, double[][].class, 270, 9429, 9436)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 270, 9429, 9436)[0], double[].class, 270, 9429, 9439);
                                CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 270, 9403, 9413)[4], double[].class, 270, 9403, 9416)[i] = 16 * ((CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 270, 9429, 9436)[0], double[].class, 270, 9429, 9439)[i]) - ph0);
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 270, 9403, 9413)[4], double[].class, 270, 9403, 9416)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 270, 9403, 9413)[4], double[].class, 270, 9403, 9416)[i]", 270, 9403, 9450);
                            }
                        }
                    }
                }
                if (mu > 0) {
                    final double ph1 = CallChecker.varInit(((double) (ydiff + (0.25 * (aspl - bspl)))), "ph1", 273, 9481, 9528);
                    if (CallChecker.beforeDeref(polynomials, double[][].class, 274, 9538, 9548)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 274, 9538, 9548);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 274, 9538, 9548)[5], double[].class, 274, 9538, 9551)) {
                            if (CallChecker.beforeDeref(yMidDots, double[][].class, 274, 9564, 9571)) {
                                yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 274, 9564, 9571);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 274, 9564, 9571)[1], double[].class, 274, 9564, 9574)) {
                                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 274, 9538, 9548);
                                    CallChecker.isCalled(polynomials, double[][].class, 274, 9538, 9548)[5] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 274, 9538, 9548)[5], double[].class, 274, 9538, 9551);
                                    yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 274, 9564, 9571);
                                    CallChecker.isCalled(yMidDots, double[][].class, 274, 9564, 9571)[1] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 274, 9564, 9571)[1], double[].class, 274, 9564, 9574);
                                    CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 274, 9538, 9548)[5], double[].class, 274, 9538, 9551)[i] = 16 * ((CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 274, 9564, 9571)[1], double[].class, 274, 9564, 9574)[i]) - ph1);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 274, 9538, 9548)[5], double[].class, 274, 9538, 9551)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 274, 9538, 9548)[5], double[].class, 274, 9538, 9551)[i]", 274, 9538, 9585);
                                }
                            }
                        }
                    }
                    if (mu > 1) {
                        final double ph2 = CallChecker.varInit(((double) (yp1 - yp0)), "ph2", 277, 9620, 9648);
                        if (CallChecker.beforeDeref(polynomials, double[][].class, 278, 9660, 9670)) {
                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 278, 9660, 9670);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 278, 9660, 9670)[6], double[].class, 278, 9660, 9673)) {
                                if (CallChecker.beforeDeref(yMidDots, double[][].class, 278, 9686, 9693)) {
                                    yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 278, 9686, 9693);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 278, 9686, 9693)[2], double[].class, 278, 9686, 9696)) {
                                        if (CallChecker.beforeDeref(polynomials, double[][].class, 278, 9709, 9719)) {
                                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 278, 9709, 9719);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 278, 9709, 9719)[4], double[].class, 278, 9709, 9722)) {
                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 278, 9660, 9670);
                                                CallChecker.isCalled(polynomials, double[][].class, 278, 9660, 9670)[6] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 278, 9660, 9670)[6], double[].class, 278, 9660, 9673);
                                                yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 278, 9686, 9693);
                                                CallChecker.isCalled(yMidDots, double[][].class, 278, 9686, 9693)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 278, 9686, 9693)[2], double[].class, 278, 9686, 9696);
                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 278, 9709, 9719);
                                                CallChecker.isCalled(polynomials, double[][].class, 278, 9709, 9719)[4] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 278, 9709, 9719)[4], double[].class, 278, 9709, 9722);
                                                CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 278, 9660, 9670)[6], double[].class, 278, 9660, 9673)[i] = 16 * (((CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 278, 9686, 9693)[2], double[].class, 278, 9686, 9696)[i]) - ph2) + (CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 278, 9709, 9719)[4], double[].class, 278, 9709, 9722)[i]));
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 278, 9660, 9670)[6], double[].class, 278, 9660, 9673)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 278, 9660, 9670)[6], double[].class, 278, 9660, 9673)[i]", 278, 9660, 9727);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (mu > 2) {
                            final double ph3 = CallChecker.varInit(((double) (6 * (bspl - aspl))), "ph3", 281, 9766, 9802);
                            if (CallChecker.beforeDeref(polynomials, double[][].class, 282, 9816, 9826)) {
                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 282, 9816, 9826);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 282, 9816, 9826)[7], double[].class, 282, 9816, 9829)) {
                                    if (CallChecker.beforeDeref(yMidDots, double[][].class, 282, 9842, 9849)) {
                                        yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 282, 9842, 9849);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 282, 9842, 9849)[3], double[].class, 282, 9842, 9852)) {
                                            if (CallChecker.beforeDeref(polynomials, double[][].class, 282, 9869, 9879)) {
                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 282, 9869, 9879);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 282, 9869, 9879)[5], double[].class, 282, 9869, 9882)) {
                                                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 282, 9816, 9826);
                                                    CallChecker.isCalled(polynomials, double[][].class, 282, 9816, 9826)[7] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 282, 9816, 9826)[7], double[].class, 282, 9816, 9829);
                                                    yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 282, 9842, 9849);
                                                    CallChecker.isCalled(yMidDots, double[][].class, 282, 9842, 9849)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 282, 9842, 9849)[3], double[].class, 282, 9842, 9852);
                                                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 282, 9869, 9879);
                                                    CallChecker.isCalled(polynomials, double[][].class, 282, 9869, 9879)[5] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 282, 9869, 9879)[5], double[].class, 282, 9869, 9882);
                                                    CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 282, 9816, 9826)[7], double[].class, 282, 9816, 9829)[i] = 16 * (((CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 282, 9842, 9849)[3], double[].class, 282, 9842, 9852)[i]) - ph3) + (3 * (CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 282, 9869, 9879)[5], double[].class, 282, 9869, 9882)[i])));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 282, 9816, 9826)[7], double[].class, 282, 9816, 9829)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 282, 9816, 9826)[7], double[].class, 282, 9816, 9829)[i]", 282, 9816, 9887);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            for (int j = 4; j <= mu; ++j) {
                                final double fac1 = CallChecker.varInit(((double) ((0.5 * j) * (j - 1))), "fac1", 285, 9948, 9985);
                                final double fac2 = CallChecker.varInit(((double) (((2 * fac1) * (j - 2)) * (j - 3))), "fac2", 286, 10001, 10049);
                                if (CallChecker.beforeDeref(polynomials, double[][].class, 287, 10065, 10075)) {
                                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 287, 10065, 10075);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 287, 10065, 10075)[(j + 4)], double[].class, 287, 10065, 10080)) {
                                        if (CallChecker.beforeDeref(yMidDots, double[][].class, 288, 10111, 10118)) {
                                            yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 288, 10111, 10118);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 288, 10111, 10118)[j], double[].class, 288, 10111, 10121)) {
                                                if (CallChecker.beforeDeref(polynomials, double[][].class, 288, 10135, 10145)) {
                                                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 288, 10135, 10145);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 288, 10135, 10145)[(j + 2)], double[].class, 288, 10135, 10150)) {
                                                        if (CallChecker.beforeDeref(polynomials, double[][].class, 288, 10164, 10174)) {
                                                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 288, 10164, 10174);
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 288, 10164, 10174)[j], double[].class, 288, 10164, 10177)) {
                                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 287, 10065, 10075);
                                                                CallChecker.isCalled(polynomials, double[][].class, 287, 10065, 10075)[(j + 4)] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 287, 10065, 10075)[(j + 4)], double[].class, 287, 10065, 10080);
                                                                yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 288, 10111, 10118);
                                                                CallChecker.isCalled(yMidDots, double[][].class, 288, 10111, 10118)[j] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 288, 10111, 10118)[j], double[].class, 288, 10111, 10121);
                                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 288, 10135, 10145);
                                                                CallChecker.isCalled(polynomials, double[][].class, 288, 10135, 10145)[(j + 2)] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 288, 10135, 10145)[(j + 2)], double[].class, 288, 10135, 10150);
                                                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 288, 10164, 10174);
                                                                CallChecker.isCalled(polynomials, double[][].class, 288, 10164, 10174)[j] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 288, 10164, 10174)[j], double[].class, 288, 10164, 10177);
                                                                CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 287, 10065, 10075)[(j + 4)], double[].class, 287, 10065, 10080)[i] = 16 * (((CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 288, 10111, 10118)[j], double[].class, 288, 10111, 10121)[i]) + (fac1 * (CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 288, 10135, 10145)[(j + 2)], double[].class, 288, 10135, 10150)[i]))) - (fac2 * (CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 288, 10164, 10174)[j], double[].class, 288, 10164, 10177)[i])));
                                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 287, 10065, 10075)[(j + 4)], double[].class, 287, 10065, 10080)[i], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 287, 10065, 10075)[(j + 4)], double[].class, 287, 10065, 10080)[i]", 287, 10065, 10182);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
            _bcornu_methode_context5551.methodEnd();
        }
    }

    public double estimateError(final double[] scale) {
        MethodContext _bcornu_methode_context5552 = new MethodContext(double.class, 302, 10243, 10721);
        try {
            CallChecker.varInit(this, "this", 302, 10243, 10721);
            CallChecker.varInit(scale, "scale", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 302, 10243, 10721);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 302, 10243, 10721);
            CallChecker.varInit(this.currentState, "currentState", 302, 10243, 10721);
            CallChecker.varInit(this.h, "h", 302, 10243, 10721);
            CallChecker.varInit(this.currentDegree, "currentDegree", 302, 10243, 10721);
            CallChecker.varInit(this.errfac, "errfac", 302, 10243, 10721);
            CallChecker.varInit(this.polynomials, "polynomials", 302, 10243, 10721);
            CallChecker.varInit(this.yMidDots, "yMidDots", 302, 10243, 10721);
            CallChecker.varInit(this.y1Dot, "y1Dot", 302, 10243, 10721);
            CallChecker.varInit(this.y1, "y1", 302, 10243, 10721);
            CallChecker.varInit(this.y0Dot, "y0Dot", 302, 10243, 10721);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 302, 10243, 10721);
            double error = CallChecker.varInit(((double) (0)), "error", 303, 10422, 10438);
            if ((currentDegree) >= 5) {
                for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 305, 10496, 10500).length); ++i) {
                    polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 306, 10542, 10552);
                    CallChecker.isCalled(polynomials, double[][].class, 306, 10542, 10552)[currentDegree] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 306, 10542, 10552)[currentDegree], double[].class, 306, 10542, 10567);
                    final double e = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 306, 10542, 10552)[this.currentDegree], double[].class, 306, 10542, 10567)[i]) / (CallChecker.isCalled(scale, double[].class, 306, 10574, 10578)[i]))), "e", 306, 10525, 10582);
                    error += e * e;
                    CallChecker.varAssign(error, "error", 307, 10592, 10606);
                }
                if (CallChecker.beforeDeref(scale, double[].class, 309, 10652, 10656)) {
                    if (CallChecker.beforeDeref(errfac, double[].class, 309, 10668, 10673)) {
                        errfac = CallChecker.beforeCalled(errfac, double[].class, 309, 10668, 10673);
                        error = (FastMath.sqrt((error / (CallChecker.isCalled(scale, double[].class, 309, 10652, 10656).length)))) * (CallChecker.isCalled(errfac, double[].class, 309, 10668, 10673)[((currentDegree) - 5)]);
                        CallChecker.varAssign(error, "error", 309, 10622, 10693);
                    }
                }
            }
            return error;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5552.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context5553 = new MethodContext(void.class, 316, 10726, 12537);
        try {
            CallChecker.varInit(this, "this", 316, 10726, 12537);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 316, 10726, 12537);
            CallChecker.varInit(theta, "theta", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 316, 10726, 12537);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 316, 10726, 12537);
            CallChecker.varInit(this.currentState, "currentState", 316, 10726, 12537);
            CallChecker.varInit(this.h, "h", 316, 10726, 12537);
            CallChecker.varInit(this.currentDegree, "currentDegree", 316, 10726, 12537);
            CallChecker.varInit(this.errfac, "errfac", 316, 10726, 12537);
            CallChecker.varInit(this.polynomials, "polynomials", 316, 10726, 12537);
            CallChecker.varInit(this.yMidDots, "yMidDots", 316, 10726, 12537);
            CallChecker.varInit(this.y1Dot, "y1Dot", 316, 10726, 12537);
            CallChecker.varInit(this.y1, "y1", 316, 10726, 12537);
            CallChecker.varInit(this.y0Dot, "y0Dot", 316, 10726, 12537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 316, 10726, 12537);
            currentState = CallChecker.beforeCalled(currentState, double[].class, 319, 10949, 10960);
            final int dimension = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentState, double[].class, 319, 10949, 10960).length)), "dimension", 319, 10927, 10968);
            final double oneMinusTheta = CallChecker.varInit(((double) (1.0 - theta)), "oneMinusTheta", 321, 10975, 11015);
            final double theta05 = CallChecker.varInit(((double) (theta - 0.5)), "theta05", 322, 11021, 11061);
            final double tOmT = CallChecker.varInit(((double) (theta * oneMinusTheta)), "tOmT", 323, 11067, 11117);
            final double t4 = CallChecker.varInit(((double) (tOmT * tOmT)), "t4", 324, 11123, 11163);
            final double t4Dot = CallChecker.varInit(((double) ((2 * tOmT) * (1 - (2 * theta)))), "t4Dot", 325, 11169, 11224);
            final double dot1 = CallChecker.varInit(((double) (1.0 / (this.h))), "dot1", 326, 11230, 11266);
            final double dot2 = CallChecker.varInit(((double) ((theta * (2 - (3 * theta))) / (this.h))), "dot2", 327, 11272, 11328);
            final double dot3 = CallChecker.varInit(((double) (((((3 * theta) - 4) * theta) + 1) / (this.h))), "dot3", 328, 11334, 11396);
            for (int i = 0; i < dimension; ++i) {
                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 332, 11468, 11478);
                CallChecker.isCalled(polynomials, double[][].class, 332, 11468, 11478)[0] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 332, 11468, 11478)[0], double[].class, 332, 11468, 11481);
                final double p0 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 332, 11468, 11478)[0], double[].class, 332, 11468, 11481)[i])), "p0", 332, 11450, 11485);
                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 333, 11513, 11523);
                CallChecker.isCalled(polynomials, double[][].class, 333, 11513, 11523)[1] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 333, 11513, 11523)[1], double[].class, 333, 11513, 11526);
                final double p1 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 333, 11513, 11523)[1], double[].class, 333, 11513, 11526)[i])), "p1", 333, 11495, 11530);
                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 334, 11558, 11568);
                CallChecker.isCalled(polynomials, double[][].class, 334, 11558, 11568)[2] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 334, 11558, 11568)[2], double[].class, 334, 11558, 11571);
                final double p2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 334, 11558, 11568)[2], double[].class, 334, 11558, 11571)[i])), "p2", 334, 11540, 11575);
                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 335, 11603, 11613);
                CallChecker.isCalled(polynomials, double[][].class, 335, 11603, 11613)[3] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 335, 11603, 11613)[3], double[].class, 335, 11603, 11616);
                final double p3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 335, 11603, 11613)[3], double[].class, 335, 11603, 11616)[i])), "p3", 335, 11585, 11620);
                if (CallChecker.beforeDeref(interpolatedState, double[].class, 336, 11630, 11646)) {
                    interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 336, 11630, 11646);
                    CallChecker.isCalled(interpolatedState, double[].class, 336, 11630, 11646)[i] = p0 + (theta * (p1 + (oneMinusTheta * ((p2 * theta) + (p3 * oneMinusTheta)))));
                    CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 336, 11630, 11646)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 336, 11630, 11646)[i]", 336, 11630, 11722);
                }
                if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 337, 11732, 11754)) {
                    interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 337, 11732, 11754);
                    CallChecker.isCalled(interpolatedDerivatives, double[].class, 337, 11732, 11754)[i] = ((dot1 * p1) + (dot2 * p2)) + (dot3 * p3);
                    CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 337, 11732, 11754)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 337, 11732, 11754)[i]", 337, 11732, 11794);
                }
                if ((currentDegree) > 3) {
                    double cDot = CallChecker.varInit(((double) (0)), "cDot", 340, 11842, 11857);
                    double c = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(polynomials, double[][].class, 341, 11882, 11892)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 341, 11882, 11892);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 341, 11882, 11892)[currentDegree], double[].class, 341, 11882, 11907)) {
                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 341, 11882, 11892);
                            CallChecker.isCalled(polynomials, double[][].class, 341, 11882, 11892)[currentDegree] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 341, 11882, 11892)[currentDegree], double[].class, 341, 11882, 11907);
                            c = CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 341, 11882, 11892)[currentDegree], double[].class, 341, 11882, 11907)[i];
                            CallChecker.varAssign(c, "c", 341, 11882, 11892);
                        }
                    }
                    for (int j = (currentDegree) - 1; j > 3; --j) {
                        final double d = CallChecker.varInit(((double) (1.0 / (j - 3))), "d", 343, 11987, 12017);
                        cDot = d * ((theta05 * cDot) + c);
                        CallChecker.varAssign(cDot, "cDot", 344, 12035, 12066);
                        if (CallChecker.beforeDeref(polynomials, double[][].class, 345, 12088, 12098)) {
                            polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 345, 12088, 12098);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 345, 12088, 12098)[j], double[].class, 345, 12088, 12101)) {
                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 345, 12088, 12098);
                                CallChecker.isCalled(polynomials, double[][].class, 345, 12088, 12098)[j] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 345, 12088, 12098)[j], double[].class, 345, 12088, 12101);
                                c = (CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 345, 12088, 12098)[j], double[].class, 345, 12088, 12101)[i]) + ((c * d) * theta05);
                                CallChecker.varAssign(c, "c", 345, 12084, 12123);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 347, 12151, 12167)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 347, 12151, 12167);
                        CallChecker.isCalled(interpolatedState, double[].class, 347, 12151, 12167)[i] += t4 * c;
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 347, 12151, 12167)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 347, 12151, 12167)[i]", 347, 12151, 12187);
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 348, 12201, 12223)) {
                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 348, 12201, 12223);
                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 348, 12201, 12223)[i] += ((t4 * cDot) + (t4Dot * c)) / (h);
                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 348, 12201, 12223)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 348, 12201, 12223)[i]", 348, 12201, 12258);
                    }
                }
            }
            if ((h) == 0) {
                if (CallChecker.beforeDeref(yMidDots, double[][].class, 356, 12472, 12479)) {
                    yMidDots = CallChecker.beforeCalled(yMidDots, double[][].class, 356, 12472, 12479);
                    System.arraycopy(CallChecker.isCalled(yMidDots, double[][].class, 356, 12472, 12479)[1], 0, interpolatedDerivatives, 0, dimension);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5553.methodEnd();
        }
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        MethodContext _bcornu_methode_context5554 = new MethodContext(void.class, 363, 12542, 13050);
        try {
            CallChecker.varInit(this, "this", 363, 12542, 13050);
            CallChecker.varInit(out, "out", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 363, 12542, 13050);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 363, 12542, 13050);
            CallChecker.varInit(this.currentState, "currentState", 363, 12542, 13050);
            CallChecker.varInit(this.h, "h", 363, 12542, 13050);
            CallChecker.varInit(this.currentDegree, "currentDegree", 363, 12542, 13050);
            CallChecker.varInit(this.errfac, "errfac", 363, 12542, 13050);
            CallChecker.varInit(this.polynomials, "polynomials", 363, 12542, 13050);
            CallChecker.varInit(this.yMidDots, "yMidDots", 363, 12542, 13050);
            CallChecker.varInit(this.y1Dot, "y1Dot", 363, 12542, 13050);
            CallChecker.varInit(this.y1, "y1", 363, 12542, 13050);
            CallChecker.varInit(this.y0Dot, "y0Dot", 363, 12542, 13050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 363, 12542, 13050);
            int dimension = CallChecker.init(int.class);
            if ((currentState) == null) {
                dimension = -1;
                CallChecker.varAssign(dimension, "dimension", 366, 12679, 12727);
            }else {
                dimension = currentState.length;
                CallChecker.varAssign(dimension, "dimension", 366, 12679, 12727);
            }
            writeBaseExternal(out);
            if (CallChecker.beforeDeref(out, ObjectOutput.class, 372, 12869, 12871)) {
                CallChecker.isCalled(out, ObjectOutput.class, 372, 12869, 12871).writeInt(currentDegree);
            }
            for (int k = 0; k <= (currentDegree); ++k) {
                for (int l = 0; l < dimension; ++l) {
                    if (CallChecker.beforeDeref(polynomials, double[][].class, 375, 13013, 13023)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 375, 13013, 13023);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 375, 13013, 13023)[k], double[].class, 375, 13013, 13026)) {
                            if (CallChecker.beforeDeref(out, ObjectOutput.class, 375, 12997, 12999)) {
                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 375, 13013, 13023);
                                CallChecker.isCalled(polynomials, double[][].class, 375, 13013, 13023)[k] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 375, 13013, 13023)[k], double[].class, 375, 13013, 13026);
                                CallChecker.isCalled(out, ObjectOutput.class, 375, 12997, 12999).writeDouble(CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 375, 13013, 13023)[k], double[].class, 375, 13013, 13026)[l]);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5554.methodEnd();
        }
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context5555 = new MethodContext(void.class, 383, 13055, 13695);
        try {
            CallChecker.varInit(this, "this", 383, 13055, 13695);
            CallChecker.varInit(in, "in", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 383, 13055, 13695);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 383, 13055, 13695);
            CallChecker.varInit(this.currentState, "currentState", 383, 13055, 13695);
            CallChecker.varInit(this.h, "h", 383, 13055, 13695);
            CallChecker.varInit(this.currentDegree, "currentDegree", 383, 13055, 13695);
            CallChecker.varInit(this.errfac, "errfac", 383, 13055, 13695);
            CallChecker.varInit(this.polynomials, "polynomials", 383, 13055, 13695);
            CallChecker.varInit(this.yMidDots, "yMidDots", 383, 13055, 13695);
            CallChecker.varInit(this.y1Dot, "y1Dot", 383, 13055, 13695);
            CallChecker.varInit(this.y1, "y1", 383, 13055, 13695);
            CallChecker.varInit(this.y0Dot, "y0Dot", 383, 13055, 13695);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerStepInterpolator.serialVersionUID", 383, 13055, 13695);
            final double t = CallChecker.varInit(((double) (readBaseExternal(in))), "t", 387, 13191, 13255);
            int dimension = CallChecker.init(int.class);
            if ((currentState) == null) {
                dimension = -1;
                CallChecker.varAssign(dimension, "dimension", 388, 13283, 13331);
            }else {
                dimension = currentState.length;
                CallChecker.varAssign(dimension, "dimension", 388, 13283, 13331);
            }
            final int degree = CallChecker.varInit(((int) (CallChecker.isCalled(in, ObjectInput.class, 391, 13391, 13392).readInt())), "degree", 391, 13339, 13403);
            resetTables(degree);
            currentDegree = degree;
            CallChecker.varAssign(this.currentDegree, "this.currentDegree", 393, 13434, 13456);
            for (int k = 0; k <= (currentDegree); ++k) {
                for (int l = 0; l < dimension; ++l) {
                    if (CallChecker.beforeDeref(polynomials, double[][].class, 397, 13558, 13568)) {
                        polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 397, 13558, 13568);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(polynomials, double[][].class, 397, 13558, 13568)[k], double[].class, 397, 13558, 13571)) {
                            if (CallChecker.beforeDeref(in, ObjectInput.class, 397, 13578, 13579)) {
                                polynomials = CallChecker.beforeCalled(polynomials, double[][].class, 397, 13558, 13568);
                                CallChecker.isCalled(polynomials, double[][].class, 397, 13558, 13568)[k] = CallChecker.beforeCalled(CallChecker.isCalled(polynomials, double[][].class, 397, 13558, 13568)[k], double[].class, 397, 13558, 13571);
                                CallChecker.isCalled(CallChecker.isCalled(polynomials, double[][].class, 397, 13558, 13568)[k], double[].class, 397, 13558, 13571)[l] = CallChecker.isCalled(in, ObjectInput.class, 397, 13578, 13579).readDouble();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 397, 13558, 13568)[k], double[].class, 397, 13558, 13571)[l], "CallChecker.isCalled(CallChecker.isCalled(this.polynomials, double[][].class, 397, 13558, 13568)[k], double[].class, 397, 13558, 13571)[l]", 397, 13558, 13593);
                            }
                        }
                    }
                }
            }
            setInterpolatedTime(t);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5555.methodEnd();
        }
    }
}

