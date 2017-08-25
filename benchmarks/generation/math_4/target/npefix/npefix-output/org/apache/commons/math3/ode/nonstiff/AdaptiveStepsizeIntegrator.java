package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.util.FastMath;

public abstract class AdaptiveStepsizeIntegrator extends AbstractIntegrator {
    protected double scalAbsoluteTolerance;

    protected double scalRelativeTolerance;

    protected double[] vecAbsoluteTolerance;

    protected double[] vecRelativeTolerance;

    protected int mainSetDimension;

    private double initialStep;

    private double minStep;

    private double maxStep;

    public AdaptiveStepsizeIntegrator(final String name, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(name);
        ConstructorContext _bcornu_methode_context268 = new ConstructorContext(AdaptiveStepsizeIntegrator.class, 105, 3415, 4411);
        try {
            setStepSizeControl(minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
            resetInternalState();
        } finally {
            _bcornu_methode_context268.methodEnd();
        }
    }

    public AdaptiveStepsizeIntegrator(final String name, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(name);
        ConstructorContext _bcornu_methode_context269 = new ConstructorContext(AdaptiveStepsizeIntegrator.class, 128, 4416, 5410);
        try {
            setStepSizeControl(minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
            resetInternalState();
        } finally {
            _bcornu_methode_context269.methodEnd();
        }
    }

    public void setStepSizeControl(final double minimalStep, final double maximalStep, final double absoluteTolerance, final double relativeTolerance) {
        MethodContext _bcornu_methode_context1166 = new MethodContext(void.class, 153, 5415, 6552);
        try {
            CallChecker.varInit(this, "this", 153, 5415, 6552);
            CallChecker.varInit(relativeTolerance, "relativeTolerance", 153, 5415, 6552);
            CallChecker.varInit(absoluteTolerance, "absoluteTolerance", 153, 5415, 6552);
            CallChecker.varInit(maximalStep, "maximalStep", 153, 5415, 6552);
            CallChecker.varInit(minimalStep, "minimalStep", 153, 5415, 6552);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 153, 5415, 6552);
            CallChecker.varInit(this.isLastStep, "isLastStep", 153, 5415, 6552);
            CallChecker.varInit(this.stepSize, "stepSize", 153, 5415, 6552);
            CallChecker.varInit(this.stepStart, "stepStart", 153, 5415, 6552);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 153, 5415, 6552);
            CallChecker.varInit(this.maxStep, "maxStep", 153, 5415, 6552);
            CallChecker.varInit(this.minStep, "minStep", 153, 5415, 6552);
            CallChecker.varInit(this.initialStep, "initialStep", 153, 5415, 6552);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 153, 5415, 6552);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 153, 5415, 6552);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 153, 5415, 6552);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 153, 5415, 6552);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 153, 5415, 6552);
            minStep = FastMath.abs(minimalStep);
            CallChecker.varAssign(this.minStep, "this.minStep", 157, 6266, 6305);
            maxStep = FastMath.abs(maximalStep);
            CallChecker.varAssign(this.maxStep, "this.maxStep", 158, 6313, 6352);
            initialStep = -1;
            CallChecker.varAssign(this.initialStep, "this.initialStep", 159, 6360, 6376);
            scalAbsoluteTolerance = absoluteTolerance;
            CallChecker.varAssign(this.scalAbsoluteTolerance, "this.scalAbsoluteTolerance", 161, 6385, 6426);
            scalRelativeTolerance = relativeTolerance;
            CallChecker.varAssign(this.scalRelativeTolerance, "this.scalRelativeTolerance", 162, 6434, 6475);
            vecAbsoluteTolerance = null;
            CallChecker.varAssign(this.vecAbsoluteTolerance, "this.vecAbsoluteTolerance", 163, 6483, 6511);
            vecRelativeTolerance = null;
            CallChecker.varAssign(this.vecRelativeTolerance, "this.vecRelativeTolerance", 164, 6519, 6547);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1166.methodEnd();
        }
    }

    public void setStepSizeControl(final double minimalStep, final double maximalStep, final double[] absoluteTolerance, final double[] relativeTolerance) {
        MethodContext _bcornu_methode_context1167 = new MethodContext(void.class, 182, 6557, 7708);
        try {
            CallChecker.varInit(this, "this", 182, 6557, 7708);
            CallChecker.varInit(relativeTolerance, "relativeTolerance", 182, 6557, 7708);
            CallChecker.varInit(absoluteTolerance, "absoluteTolerance", 182, 6557, 7708);
            CallChecker.varInit(maximalStep, "maximalStep", 182, 6557, 7708);
            CallChecker.varInit(minimalStep, "minimalStep", 182, 6557, 7708);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 182, 6557, 7708);
            CallChecker.varInit(this.isLastStep, "isLastStep", 182, 6557, 7708);
            CallChecker.varInit(this.stepSize, "stepSize", 182, 6557, 7708);
            CallChecker.varInit(this.stepStart, "stepStart", 182, 6557, 7708);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 182, 6557, 7708);
            CallChecker.varInit(this.maxStep, "maxStep", 182, 6557, 7708);
            CallChecker.varInit(this.minStep, "minStep", 182, 6557, 7708);
            CallChecker.varInit(this.initialStep, "initialStep", 182, 6557, 7708);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 182, 6557, 7708);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 182, 6557, 7708);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 182, 6557, 7708);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 182, 6557, 7708);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 182, 6557, 7708);
            minStep = FastMath.abs(minimalStep);
            CallChecker.varAssign(this.minStep, "this.minStep", 186, 7412, 7451);
            maxStep = FastMath.abs(maximalStep);
            CallChecker.varAssign(this.maxStep, "this.maxStep", 187, 7459, 7498);
            initialStep = -1;
            CallChecker.varAssign(this.initialStep, "this.initialStep", 188, 7506, 7522);
            scalAbsoluteTolerance = 0;
            CallChecker.varAssign(this.scalAbsoluteTolerance, "this.scalAbsoluteTolerance", 190, 7531, 7556);
            scalRelativeTolerance = 0;
            CallChecker.varAssign(this.scalRelativeTolerance, "this.scalRelativeTolerance", 191, 7564, 7589);
            if (CallChecker.beforeDeref(absoluteTolerance, double[].class, 192, 7621, 7637)) {
                vecAbsoluteTolerance = CallChecker.isCalled(absoluteTolerance, double[].class, 192, 7621, 7637).clone();
                CallChecker.varAssign(this.vecAbsoluteTolerance, "this.vecAbsoluteTolerance", 192, 7597, 7646);
            }
            if (CallChecker.beforeDeref(relativeTolerance, double[].class, 193, 7678, 7694)) {
                vecRelativeTolerance = CallChecker.isCalled(relativeTolerance, double[].class, 193, 7678, 7694).clone();
                CallChecker.varAssign(this.vecRelativeTolerance, "this.vecRelativeTolerance", 193, 7654, 7703);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1167.methodEnd();
        }
    }

    public void setInitialStepSize(final double initialStepSize) {
        MethodContext _bcornu_methode_context1168 = new MethodContext(void.class, 208, 7713, 8526);
        try {
            CallChecker.varInit(this, "this", 208, 7713, 8526);
            CallChecker.varInit(initialStepSize, "initialStepSize", 208, 7713, 8526);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 208, 7713, 8526);
            CallChecker.varInit(this.isLastStep, "isLastStep", 208, 7713, 8526);
            CallChecker.varInit(this.stepSize, "stepSize", 208, 7713, 8526);
            CallChecker.varInit(this.stepStart, "stepStart", 208, 7713, 8526);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 208, 7713, 8526);
            CallChecker.varInit(this.maxStep, "maxStep", 208, 7713, 8526);
            CallChecker.varInit(this.minStep, "minStep", 208, 7713, 8526);
            CallChecker.varInit(this.initialStep, "initialStep", 208, 7713, 8526);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 208, 7713, 8526);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 208, 7713, 8526);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 208, 7713, 8526);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 208, 7713, 8526);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 208, 7713, 8526);
            if ((initialStepSize < (minStep)) || (initialStepSize > (maxStep))) {
                initialStep = -1.0;
                CallChecker.varAssign(this.initialStep, "this.initialStep", 210, 8448, 8466);
            }else {
                initialStep = initialStepSize;
                CallChecker.varAssign(this.initialStep, "this.initialStep", 212, 8487, 8516);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1168.methodEnd();
        }
    }

    @Override
    protected void sanityChecks(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1169 = new MethodContext(void.class, 218, 8531, 9235);
        try {
            CallChecker.varInit(this, "this", 218, 8531, 9235);
            CallChecker.varInit(t, "t", 218, 8531, 9235);
            CallChecker.varInit(equations, "equations", 218, 8531, 9235);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 218, 8531, 9235);
            CallChecker.varInit(this.isLastStep, "isLastStep", 218, 8531, 9235);
            CallChecker.varInit(this.stepSize, "stepSize", 218, 8531, 9235);
            CallChecker.varInit(this.stepStart, "stepStart", 218, 8531, 9235);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 218, 8531, 9235);
            CallChecker.varInit(this.maxStep, "maxStep", 218, 8531, 9235);
            CallChecker.varInit(this.minStep, "minStep", 218, 8531, 9235);
            CallChecker.varInit(this.initialStep, "initialStep", 218, 8531, 9235);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 218, 8531, 9235);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 218, 8531, 9235);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 218, 8531, 9235);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 218, 8531, 9235);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 218, 8531, 9235);
            super.sanityChecks(equations, t);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 223, 8785, 8793)) {
                final EquationsMapper npe_invocation_var121 = CallChecker.isCalled(equations, ExpandableStatefulODE.class, 223, 8785, 8793).getPrimaryMapper();
                if (CallChecker.beforeDeref(npe_invocation_var121, EquationsMapper.class, 223, 8785, 8812)) {
                    mainSetDimension = CallChecker.isCalled(npe_invocation_var121, EquationsMapper.class, 223, 8785, 8812).getDimension();
                    CallChecker.varAssign(this.mainSetDimension, "this.mainSetDimension", 223, 8766, 8828);
                }
            }
            if (((vecAbsoluteTolerance) != null) && ((vecAbsoluteTolerance.length) != (mainSetDimension))) {
                throw new DimensionMismatchException(mainSetDimension, vecAbsoluteTolerance.length);
            }
            if (((vecRelativeTolerance) != null) && ((vecRelativeTolerance.length) != (mainSetDimension))) {
                throw new DimensionMismatchException(mainSetDimension, vecRelativeTolerance.length);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1169.methodEnd();
        }
    }

    public double initializeStep(final boolean forward, final int order, final double[] scale, final double t0, final double[] y0, final double[] yDot0, final double[] y1, final double[] yDot1) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context1170 = new MethodContext(double.class, 248, 9240, 12091);
        try {
            CallChecker.varInit(this, "this", 248, 9240, 12091);
            CallChecker.varInit(yDot1, "yDot1", 248, 9240, 12091);
            CallChecker.varInit(y1, "y1", 248, 9240, 12091);
            CallChecker.varInit(yDot0, "yDot0", 248, 9240, 12091);
            CallChecker.varInit(y0, "y0", 248, 9240, 12091);
            CallChecker.varInit(t0, "t0", 248, 9240, 12091);
            CallChecker.varInit(scale, "scale", 248, 9240, 12091);
            CallChecker.varInit(order, "order", 248, 9240, 12091);
            CallChecker.varInit(forward, "forward", 248, 9240, 12091);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 248, 9240, 12091);
            CallChecker.varInit(this.isLastStep, "isLastStep", 248, 9240, 12091);
            CallChecker.varInit(this.stepSize, "stepSize", 248, 9240, 12091);
            CallChecker.varInit(this.stepStart, "stepStart", 248, 9240, 12091);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 248, 9240, 12091);
            CallChecker.varInit(this.maxStep, "maxStep", 248, 9240, 12091);
            CallChecker.varInit(this.minStep, "minStep", 248, 9240, 12091);
            CallChecker.varInit(this.initialStep, "initialStep", 248, 9240, 12091);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 248, 9240, 12091);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 248, 9240, 12091);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 248, 9240, 12091);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 248, 9240, 12091);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 248, 9240, 12091);
            if ((initialStep) > 0) {
                if (forward) {
                    return initialStep;
                }else {
                    return -(initialStep);
                }
            }
            double ratio = CallChecker.init(double.class);
            double yOnScale2 = CallChecker.varInit(((double) (0)), "yOnScale2", 261, 10495, 10515);
            double yDotOnScale2 = CallChecker.varInit(((double) (0)), "yDotOnScale2", 262, 10521, 10544);
            for (int j = 0; j < (CallChecker.isCalled(scale, double[].class, 263, 10570, 10574).length); ++j) {
                if (CallChecker.beforeDeref(y0, double[].class, 264, 10613, 10614)) {
                    if (CallChecker.beforeDeref(scale, double[].class, 264, 10621, 10625)) {
                        ratio = (CallChecker.isCalled(y0, double[].class, 264, 10613, 10614)[j]) / (CallChecker.isCalled(scale, double[].class, 264, 10621, 10625)[j]);
                        CallChecker.varAssign(ratio, "ratio", 264, 10597, 10629);
                    }
                }
                yOnScale2 += ratio * ratio;
                CallChecker.varAssign(yOnScale2, "yOnScale2", 265, 10637, 10666);
                if (CallChecker.beforeDeref(yDot0, double[].class, 266, 10690, 10694)) {
                    if (CallChecker.beforeDeref(scale, double[].class, 266, 10701, 10705)) {
                        ratio = (CallChecker.isCalled(yDot0, double[].class, 266, 10690, 10694)[j]) / (CallChecker.isCalled(scale, double[].class, 266, 10701, 10705)[j]);
                        CallChecker.varAssign(ratio, "ratio", 266, 10674, 10709);
                    }
                }
                yDotOnScale2 += ratio * ratio;
                CallChecker.varAssign(yDotOnScale2, "yDotOnScale2", 267, 10717, 10746);
            }
            double h = CallChecker.init(double.class);
            if ((yOnScale2 < 1.0E-10) || (yDotOnScale2 < 1.0E-10)) {
                h = 1.0E-6;
                CallChecker.varAssign(h, "h", 270, 10770, 10895);
            }else {
                h = 0.01 * (FastMath.sqrt((yOnScale2 / yDotOnScale2)));
                CallChecker.varAssign(h, "h", 270, 10770, 10895);
            }
            if (!forward) {
                h = -h;
                CallChecker.varAssign(h, "h", 273, 10925, 10931);
            }
            for (int j = 0; j < (CallChecker.isCalled(y0, double[].class, 277, 11025, 11026).length); ++j) {
                if (CallChecker.beforeDeref(y1, double[].class, 278, 11049, 11050)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 278, 11057, 11058)) {
                        if (CallChecker.beforeDeref(yDot0, double[].class, 278, 11069, 11073)) {
                            CallChecker.isCalled(y1, double[].class, 278, 11049, 11050)[j] = (CallChecker.isCalled(y0, double[].class, 278, 11057, 11058)[j]) + (h * (CallChecker.isCalled(yDot0, double[].class, 278, 11069, 11073)[j]));
                            CallChecker.varAssign(CallChecker.isCalled(y1, double[].class, 278, 11049, 11050)[j], "CallChecker.isCalled(y1, double[].class, 278, 11049, 11050)[j]", 278, 11049, 11077);
                        }
                    }
                }
            }
            computeDerivatives((t0 + h), y1, yDot1);
            double yDDotOnScale = CallChecker.varInit(((double) (0)), "yDDotOnScale", 283, 11187, 11210);
            for (int j = 0; j < (CallChecker.isCalled(scale, double[].class, 284, 11236, 11240).length); ++j) {
                if (CallChecker.beforeDeref(yDot1, double[].class, 285, 11280, 11284)) {
                    if (CallChecker.beforeDeref(yDot0, double[].class, 285, 11291, 11295)) {
                        if (CallChecker.beforeDeref(scale, double[].class, 285, 11303, 11307)) {
                            ratio = ((CallChecker.isCalled(yDot1, double[].class, 285, 11280, 11284)[j]) - (CallChecker.isCalled(yDot0, double[].class, 285, 11291, 11295)[j])) / (CallChecker.isCalled(scale, double[].class, 285, 11303, 11307)[j]);
                            CallChecker.varAssign(ratio, "ratio", 285, 11263, 11311);
                        }
                    }
                }
                yDDotOnScale += ratio * ratio;
                CallChecker.varAssign(yDDotOnScale, "yDDotOnScale", 286, 11319, 11348);
            }
            yDDotOnScale = (FastMath.sqrt(yDDotOnScale)) / h;
            CallChecker.varAssign(yDDotOnScale, "yDDotOnScale", 288, 11360, 11406);
            final double maxInv2 = CallChecker.varInit(((double) (FastMath.max(FastMath.sqrt(yDotOnScale2), yDDotOnScale))), "maxInv2", 292, 11413, 11584);
            double h1 = CallChecker.init(double.class);
            if (maxInv2 < 1.0E-15) {
                h1 = FastMath.max(1.0E-6, (0.001 * (FastMath.abs(h))));
                CallChecker.varAssign(h1, "h1", 293, 11608, 11762);
            }else {
                h1 = FastMath.pow((0.01 / maxInv2), (1.0 / order));
                CallChecker.varAssign(h1, "h1", 293, 11608, 11762);
            }
            h = FastMath.min((100.0 * (FastMath.abs(h))), h1);
            CallChecker.varAssign(h, "h", 296, 11769, 11814);
            h = FastMath.max(h, (1.0E-12 * (FastMath.abs(t0))));
            CallChecker.varAssign(h, "h", 297, 11820, 11867);
            if (h < (getMinStep())) {
                h = getMinStep();
                CallChecker.varAssign(h, "h", 299, 11950, 11966);
            }
            if (h > (getMaxStep())) {
                h = getMaxStep();
                CallChecker.varAssign(h, "h", 302, 12008, 12024);
            }
            if (!forward) {
                h = -h;
                CallChecker.varAssign(h, "h", 305, 12059, 12065);
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1170.methodEnd();
        }
    }

    protected double filterStep(final double h, final boolean forward, final boolean acceptSmall) throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context1171 = new MethodContext(double.class, 321, 12096, 13253);
        try {
            CallChecker.varInit(this, "this", 321, 12096, 13253);
            CallChecker.varInit(acceptSmall, "acceptSmall", 321, 12096, 13253);
            CallChecker.varInit(forward, "forward", 321, 12096, 13253);
            CallChecker.varInit(h, "h", 321, 12096, 13253);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 321, 12096, 13253);
            CallChecker.varInit(this.isLastStep, "isLastStep", 321, 12096, 13253);
            CallChecker.varInit(this.stepSize, "stepSize", 321, 12096, 13253);
            CallChecker.varInit(this.stepStart, "stepStart", 321, 12096, 13253);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 321, 12096, 13253);
            CallChecker.varInit(this.maxStep, "maxStep", 321, 12096, 13253);
            CallChecker.varInit(this.minStep, "minStep", 321, 12096, 13253);
            CallChecker.varInit(this.initialStep, "initialStep", 321, 12096, 13253);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 321, 12096, 13253);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 321, 12096, 13253);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 321, 12096, 13253);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 321, 12096, 13253);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 321, 12096, 13253);
            double filteredH = CallChecker.varInit(((double) (h)), "filteredH", 324, 12699, 12719);
            if ((FastMath.abs(h)) < (minStep)) {
                if (acceptSmall) {
                    if (forward) {
                        filteredH = minStep;
                        CallChecker.varAssign(filteredH, "filteredH", 327, 12803, 12843);
                    }else {
                        filteredH = -(minStep);
                        CallChecker.varAssign(filteredH, "filteredH", 327, 12803, 12843);
                    }
                }else {
                    throw new NumberIsTooSmallException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, FastMath.abs(h), minStep, true);
                }
            }
            if (filteredH > (maxStep)) {
                filteredH = maxStep;
                CallChecker.varAssign(filteredH, "filteredH", 335, 13123, 13142);
            }else
                if (filteredH < (-(maxStep))) {
                    filteredH = -(maxStep);
                    CallChecker.varAssign(filteredH, "filteredH", 337, 13195, 13215);
                }
            
            return filteredH;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1171.methodEnd();
        }
    }

    @Override
    public abstract void integrate(ExpandableStatefulODE equations, double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException;

    @Override
    public double getCurrentStepStart() {
        MethodContext _bcornu_methode_context1173 = new MethodContext(double.class, 352, 13502, 13599);
        try {
            CallChecker.varInit(this, "this", 352, 13502, 13599);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 352, 13502, 13599);
            CallChecker.varInit(this.isLastStep, "isLastStep", 352, 13502, 13599);
            CallChecker.varInit(this.stepSize, "stepSize", 352, 13502, 13599);
            CallChecker.varInit(this.stepStart, "stepStart", 352, 13502, 13599);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 352, 13502, 13599);
            CallChecker.varInit(this.maxStep, "maxStep", 352, 13502, 13599);
            CallChecker.varInit(this.minStep, "minStep", 352, 13502, 13599);
            CallChecker.varInit(this.initialStep, "initialStep", 352, 13502, 13599);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 352, 13502, 13599);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 352, 13502, 13599);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 352, 13502, 13599);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 352, 13502, 13599);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 352, 13502, 13599);
            return stepStart;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1173.methodEnd();
        }
    }

    protected void resetInternalState() {
        MethodContext _bcornu_methode_context1174 = new MethodContext(void.class, 357, 13604, 13769);
        try {
            CallChecker.varInit(this, "this", 357, 13604, 13769);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 357, 13604, 13769);
            CallChecker.varInit(this.isLastStep, "isLastStep", 357, 13604, 13769);
            CallChecker.varInit(this.stepSize, "stepSize", 357, 13604, 13769);
            CallChecker.varInit(this.stepStart, "stepStart", 357, 13604, 13769);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 357, 13604, 13769);
            CallChecker.varInit(this.maxStep, "maxStep", 357, 13604, 13769);
            CallChecker.varInit(this.minStep, "minStep", 357, 13604, 13769);
            CallChecker.varInit(this.initialStep, "initialStep", 357, 13604, 13769);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 357, 13604, 13769);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 357, 13604, 13769);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 357, 13604, 13769);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 357, 13604, 13769);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 357, 13604, 13769);
            stepStart = Double.NaN;
            CallChecker.varAssign(this.stepStart, "this.stepStart", 358, 13693, 13715);
            stepSize = FastMath.sqrt(((minStep) * (maxStep)));
            CallChecker.varAssign(this.stepSize, "this.stepSize", 359, 13721, 13765);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1174.methodEnd();
        }
    }

    public double getMinStep() {
        MethodContext _bcornu_methode_context1175 = new MethodContext(double.class, 365, 13774, 13885);
        try {
            CallChecker.varInit(this, "this", 365, 13774, 13885);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 365, 13774, 13885);
            CallChecker.varInit(this.isLastStep, "isLastStep", 365, 13774, 13885);
            CallChecker.varInit(this.stepSize, "stepSize", 365, 13774, 13885);
            CallChecker.varInit(this.stepStart, "stepStart", 365, 13774, 13885);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 365, 13774, 13885);
            CallChecker.varInit(this.maxStep, "maxStep", 365, 13774, 13885);
            CallChecker.varInit(this.minStep, "minStep", 365, 13774, 13885);
            CallChecker.varInit(this.initialStep, "initialStep", 365, 13774, 13885);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 365, 13774, 13885);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 365, 13774, 13885);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 365, 13774, 13885);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 365, 13774, 13885);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 365, 13774, 13885);
            return minStep;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1175.methodEnd();
        }
    }

    public double getMaxStep() {
        MethodContext _bcornu_methode_context1176 = new MethodContext(double.class, 372, 13890, 14001);
        try {
            CallChecker.varInit(this, "this", 372, 13890, 14001);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 372, 13890, 14001);
            CallChecker.varInit(this.isLastStep, "isLastStep", 372, 13890, 14001);
            CallChecker.varInit(this.stepSize, "stepSize", 372, 13890, 14001);
            CallChecker.varInit(this.stepStart, "stepStart", 372, 13890, 14001);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 372, 13890, 14001);
            CallChecker.varInit(this.maxStep, "maxStep", 372, 13890, 14001);
            CallChecker.varInit(this.minStep, "minStep", 372, 13890, 14001);
            CallChecker.varInit(this.initialStep, "initialStep", 372, 13890, 14001);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 372, 13890, 14001);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 372, 13890, 14001);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 372, 13890, 14001);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 372, 13890, 14001);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 372, 13890, 14001);
            return maxStep;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1176.methodEnd();
        }
    }
}

