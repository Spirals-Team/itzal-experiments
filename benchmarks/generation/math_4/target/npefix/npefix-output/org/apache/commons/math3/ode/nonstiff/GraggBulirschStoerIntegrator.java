package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;

public class GraggBulirschStoerIntegrator extends AdaptiveStepsizeIntegrator {
    private static final String METHOD_NAME = "Gragg-Bulirsch-Stoer";

    private int maxOrder;

    private int[] sequence;

    private int[] costPerStep;

    private double[] costPerTimeUnit;

    private double[] optimalStep;

    private double[][] coeff;

    private boolean performTest;

    private int maxChecks;

    private int maxIter;

    private double stabilityReduction;

    private double stepControl1;

    private double stepControl2;

    private double stepControl3;

    private double stepControl4;

    private double orderControl1;

    private double orderControl2;

    private boolean useInterpolationError;

    private int mudif;

    public GraggBulirschStoerIntegrator(final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) {
        super(GraggBulirschStoerIntegrator.METHOD_NAME, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context748 = new ConstructorContext(GraggBulirschStoerIntegrator.class, 169, 6335, 7464);
        try {
            setStabilityCheck(true, (-1), (-1), (-1));
            setControlFactors((-1), (-1), (-1), (-1));
            setOrderControl((-1), (-1), (-1));
            setInterpolationControl(true, (-1));
        } finally {
            _bcornu_methode_context748.methodEnd();
        }
    }

    public GraggBulirschStoerIntegrator(final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) {
        super(GraggBulirschStoerIntegrator.METHOD_NAME, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context749 = new ConstructorContext(GraggBulirschStoerIntegrator.class, 191, 7469, 8486);
        try {
            setStabilityCheck(true, (-1), (-1), (-1));
            setControlFactors((-1), (-1), (-1), (-1));
            setOrderControl((-1), (-1), (-1));
            setInterpolationControl(true, (-1));
        } finally {
            _bcornu_methode_context749.methodEnd();
        }
    }

    public void setStabilityCheck(final boolean performStabilityCheck, final int maxNumIter, final int maxNumChecks, final double stepsizeReductionFactor) {
        MethodContext _bcornu_methode_context3372 = new MethodContext(void.class, 220, 8491, 10086);
        try {
            CallChecker.varInit(this, "this", 220, 8491, 10086);
            CallChecker.varInit(stepsizeReductionFactor, "stepsizeReductionFactor", 220, 8491, 10086);
            CallChecker.varInit(maxNumChecks, "maxNumChecks", 220, 8491, 10086);
            CallChecker.varInit(maxNumIter, "maxNumIter", 220, 8491, 10086);
            CallChecker.varInit(performStabilityCheck, "performStabilityCheck", 220, 8491, 10086);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 220, 8491, 10086);
            CallChecker.varInit(this.isLastStep, "isLastStep", 220, 8491, 10086);
            CallChecker.varInit(this.stepSize, "stepSize", 220, 8491, 10086);
            CallChecker.varInit(this.stepStart, "stepStart", 220, 8491, 10086);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 220, 8491, 10086);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 220, 8491, 10086);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 220, 8491, 10086);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 220, 8491, 10086);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 220, 8491, 10086);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 220, 8491, 10086);
            CallChecker.varInit(this.mudif, "mudif", 220, 8491, 10086);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 220, 8491, 10086);
            CallChecker.varInit(this.orderControl2, "orderControl2", 220, 8491, 10086);
            CallChecker.varInit(this.orderControl1, "orderControl1", 220, 8491, 10086);
            CallChecker.varInit(this.stepControl4, "stepControl4", 220, 8491, 10086);
            CallChecker.varInit(this.stepControl3, "stepControl3", 220, 8491, 10086);
            CallChecker.varInit(this.stepControl2, "stepControl2", 220, 8491, 10086);
            CallChecker.varInit(this.stepControl1, "stepControl1", 220, 8491, 10086);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 220, 8491, 10086);
            CallChecker.varInit(this.maxIter, "maxIter", 220, 8491, 10086);
            CallChecker.varInit(this.maxChecks, "maxChecks", 220, 8491, 10086);
            CallChecker.varInit(this.performTest, "performTest", 220, 8491, 10086);
            CallChecker.varInit(this.coeff, "coeff", 220, 8491, 10086);
            CallChecker.varInit(this.optimalStep, "optimalStep", 220, 8491, 10086);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 220, 8491, 10086);
            CallChecker.varInit(this.costPerStep, "costPerStep", 220, 8491, 10086);
            CallChecker.varInit(this.sequence, "sequence", 220, 8491, 10086);
            CallChecker.varInit(this.maxOrder, "maxOrder", 220, 8491, 10086);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 220, 8491, 10086);
            this.performTest = performStabilityCheck;
            CallChecker.varAssign(this.performTest, "this.performTest", 224, 9719, 9759);
            if (maxNumIter <= 0) {
                this.maxIter = 2;
                CallChecker.varAssign(this.maxIter, "this.maxIter", 225, 9765, 9820);
            }else {
                this.maxIter = maxNumIter;
                CallChecker.varAssign(this.maxIter, "this.maxIter", 225, 9765, 9820);
            }
            if (maxNumChecks <= 0) {
                this.maxChecks = 1;
                CallChecker.varAssign(this.maxChecks, "this.maxChecks", 226, 9826, 9883);
            }else {
                this.maxChecks = maxNumChecks;
                CallChecker.varAssign(this.maxChecks, "this.maxChecks", 226, 9826, 9883);
            }
            if ((stepsizeReductionFactor < 1.0E-4) || (stepsizeReductionFactor > 0.9999)) {
                this.stabilityReduction = 0.5;
                CallChecker.varAssign(this.stabilityReduction, "this.stabilityReduction", 229, 9976, 10005);
            }else {
                this.stabilityReduction = stepsizeReductionFactor;
                CallChecker.varAssign(this.stabilityReduction, "this.stabilityReduction", 231, 10026, 10075);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3372.methodEnd();
        }
    }

    public void setControlFactors(final double control1, final double control2, final double control3, final double control4) {
        MethodContext _bcornu_methode_context3373 = new MethodContext(void.class, 260, 10091, 11984);
        try {
            CallChecker.varInit(this, "this", 260, 10091, 11984);
            CallChecker.varInit(control4, "control4", 260, 10091, 11984);
            CallChecker.varInit(control3, "control3", 260, 10091, 11984);
            CallChecker.varInit(control2, "control2", 260, 10091, 11984);
            CallChecker.varInit(control1, "control1", 260, 10091, 11984);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 260, 10091, 11984);
            CallChecker.varInit(this.isLastStep, "isLastStep", 260, 10091, 11984);
            CallChecker.varInit(this.stepSize, "stepSize", 260, 10091, 11984);
            CallChecker.varInit(this.stepStart, "stepStart", 260, 10091, 11984);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 260, 10091, 11984);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 260, 10091, 11984);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 260, 10091, 11984);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 260, 10091, 11984);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 260, 10091, 11984);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 260, 10091, 11984);
            CallChecker.varInit(this.mudif, "mudif", 260, 10091, 11984);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 260, 10091, 11984);
            CallChecker.varInit(this.orderControl2, "orderControl2", 260, 10091, 11984);
            CallChecker.varInit(this.orderControl1, "orderControl1", 260, 10091, 11984);
            CallChecker.varInit(this.stepControl4, "stepControl4", 260, 10091, 11984);
            CallChecker.varInit(this.stepControl3, "stepControl3", 260, 10091, 11984);
            CallChecker.varInit(this.stepControl2, "stepControl2", 260, 10091, 11984);
            CallChecker.varInit(this.stepControl1, "stepControl1", 260, 10091, 11984);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 260, 10091, 11984);
            CallChecker.varInit(this.maxIter, "maxIter", 260, 10091, 11984);
            CallChecker.varInit(this.maxChecks, "maxChecks", 260, 10091, 11984);
            CallChecker.varInit(this.performTest, "performTest", 260, 10091, 11984);
            CallChecker.varInit(this.coeff, "coeff", 260, 10091, 11984);
            CallChecker.varInit(this.optimalStep, "optimalStep", 260, 10091, 11984);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 260, 10091, 11984);
            CallChecker.varInit(this.costPerStep, "costPerStep", 260, 10091, 11984);
            CallChecker.varInit(this.sequence, "sequence", 260, 10091, 11984);
            CallChecker.varInit(this.maxOrder, "maxOrder", 260, 10091, 11984);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 260, 10091, 11984);
            if ((control1 < 1.0E-4) || (control1 > 0.9999)) {
                this.stepControl1 = 0.65;
                CallChecker.varAssign(this.stepControl1, "this.stepControl1", 264, 11476, 11500);
            }else {
                this.stepControl1 = control1;
                CallChecker.varAssign(this.stepControl1, "this.stepControl1", 266, 11521, 11549);
            }
            if ((control2 < 1.0E-4) || (control2 > 0.9999)) {
                this.stepControl2 = 0.94;
                CallChecker.varAssign(this.stepControl2, "this.stepControl2", 270, 11618, 11642);
            }else {
                this.stepControl2 = control2;
                CallChecker.varAssign(this.stepControl2, "this.stepControl2", 272, 11663, 11691);
            }
            if ((control3 < 1.0E-4) || (control3 > 0.9999)) {
                this.stepControl3 = 0.02;
                CallChecker.varAssign(this.stepControl3, "this.stepControl3", 276, 11760, 11784);
            }else {
                this.stepControl3 = control3;
                CallChecker.varAssign(this.stepControl3, "this.stepControl3", 278, 11805, 11833);
            }
            if ((control4 < 1.0001) || (control4 > 999.9)) {
                this.stepControl4 = 4.0;
                CallChecker.varAssign(this.stepControl4, "this.stepControl4", 282, 11901, 11924);
            }else {
                this.stepControl4 = control4;
                CallChecker.varAssign(this.stepControl4, "this.stepControl4", 284, 11945, 11973);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3373.methodEnd();
        }
    }

    public void setOrderControl(final int maximalOrder, final double control1, final double control2) {
        MethodContext _bcornu_methode_context3374 = new MethodContext(void.class, 312, 11989, 13827);
        try {
            CallChecker.varInit(this, "this", 312, 11989, 13827);
            CallChecker.varInit(control2, "control2", 312, 11989, 13827);
            CallChecker.varInit(control1, "control1", 312, 11989, 13827);
            CallChecker.varInit(maximalOrder, "maximalOrder", 312, 11989, 13827);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 312, 11989, 13827);
            CallChecker.varInit(this.isLastStep, "isLastStep", 312, 11989, 13827);
            CallChecker.varInit(this.stepSize, "stepSize", 312, 11989, 13827);
            CallChecker.varInit(this.stepStart, "stepStart", 312, 11989, 13827);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 312, 11989, 13827);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 312, 11989, 13827);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 312, 11989, 13827);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 312, 11989, 13827);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 312, 11989, 13827);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 312, 11989, 13827);
            CallChecker.varInit(this.mudif, "mudif", 312, 11989, 13827);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 312, 11989, 13827);
            CallChecker.varInit(this.orderControl2, "orderControl2", 312, 11989, 13827);
            CallChecker.varInit(this.orderControl1, "orderControl1", 312, 11989, 13827);
            CallChecker.varInit(this.stepControl4, "stepControl4", 312, 11989, 13827);
            CallChecker.varInit(this.stepControl3, "stepControl3", 312, 11989, 13827);
            CallChecker.varInit(this.stepControl2, "stepControl2", 312, 11989, 13827);
            CallChecker.varInit(this.stepControl1, "stepControl1", 312, 11989, 13827);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 312, 11989, 13827);
            CallChecker.varInit(this.maxIter, "maxIter", 312, 11989, 13827);
            CallChecker.varInit(this.maxChecks, "maxChecks", 312, 11989, 13827);
            CallChecker.varInit(this.performTest, "performTest", 312, 11989, 13827);
            CallChecker.varInit(this.coeff, "coeff", 312, 11989, 13827);
            CallChecker.varInit(this.optimalStep, "optimalStep", 312, 11989, 13827);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 312, 11989, 13827);
            CallChecker.varInit(this.costPerStep, "costPerStep", 312, 11989, 13827);
            CallChecker.varInit(this.sequence, "sequence", 312, 11989, 13827);
            CallChecker.varInit(this.maxOrder, "maxOrder", 312, 11989, 13827);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 312, 11989, 13827);
            if ((maximalOrder <= 6) || ((maximalOrder % 2) != 0)) {
                this.maxOrder = 18;
                CallChecker.varAssign(this.maxOrder, "this.maxOrder", 316, 13456, 13474);
            }
            if ((control1 < 1.0E-4) || (control1 > 0.9999)) {
                this.orderControl1 = 0.8;
                CallChecker.varAssign(this.orderControl1, "this.orderControl1", 320, 13543, 13567);
            }else {
                this.orderControl1 = control1;
                CallChecker.varAssign(this.orderControl1, "this.orderControl1", 322, 13588, 13617);
            }
            if ((control2 < 1.0E-4) || (control2 > 0.9999)) {
                this.orderControl2 = 0.9;
                CallChecker.varAssign(this.orderControl2, "this.orderControl2", 326, 13686, 13710);
            }else {
                this.orderControl2 = control2;
                CallChecker.varAssign(this.orderControl2, "this.orderControl2", 328, 13731, 13760);
            }
            initializeArrays();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3374.methodEnd();
        }
    }

    @Override
    public void addStepHandler(final StepHandler handler) {
        MethodContext _bcornu_methode_context3375 = new MethodContext(void.class, 338, 13832, 14019);
        try {
            CallChecker.varInit(this, "this", 338, 13832, 14019);
            CallChecker.varInit(handler, "handler", 338, 13832, 14019);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 338, 13832, 14019);
            CallChecker.varInit(this.isLastStep, "isLastStep", 338, 13832, 14019);
            CallChecker.varInit(this.stepSize, "stepSize", 338, 13832, 14019);
            CallChecker.varInit(this.stepStart, "stepStart", 338, 13832, 14019);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 338, 13832, 14019);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 338, 13832, 14019);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 338, 13832, 14019);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 338, 13832, 14019);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 338, 13832, 14019);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 338, 13832, 14019);
            CallChecker.varInit(this.mudif, "mudif", 338, 13832, 14019);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 338, 13832, 14019);
            CallChecker.varInit(this.orderControl2, "orderControl2", 338, 13832, 14019);
            CallChecker.varInit(this.orderControl1, "orderControl1", 338, 13832, 14019);
            CallChecker.varInit(this.stepControl4, "stepControl4", 338, 13832, 14019);
            CallChecker.varInit(this.stepControl3, "stepControl3", 338, 13832, 14019);
            CallChecker.varInit(this.stepControl2, "stepControl2", 338, 13832, 14019);
            CallChecker.varInit(this.stepControl1, "stepControl1", 338, 13832, 14019);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 338, 13832, 14019);
            CallChecker.varInit(this.maxIter, "maxIter", 338, 13832, 14019);
            CallChecker.varInit(this.maxChecks, "maxChecks", 338, 13832, 14019);
            CallChecker.varInit(this.performTest, "performTest", 338, 13832, 14019);
            CallChecker.varInit(this.coeff, "coeff", 338, 13832, 14019);
            CallChecker.varInit(this.optimalStep, "optimalStep", 338, 13832, 14019);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 338, 13832, 14019);
            CallChecker.varInit(this.costPerStep, "costPerStep", 338, 13832, 14019);
            CallChecker.varInit(this.sequence, "sequence", 338, 13832, 14019);
            CallChecker.varInit(this.maxOrder, "maxOrder", 338, 13832, 14019);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 338, 13832, 14019);
            super.addStepHandler(handler);
            initializeArrays();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3375.methodEnd();
        }
    }

    @Override
    public void addEventHandler(final EventHandler function, final double maxCheckInterval, final double convergence, final int maxIterationCount, final UnivariateSolver solver) {
        MethodContext _bcornu_methode_context3376 = new MethodContext(void.class, 349, 14024, 14535);
        try {
            CallChecker.varInit(this, "this", 349, 14024, 14535);
            CallChecker.varInit(solver, "solver", 349, 14024, 14535);
            CallChecker.varInit(maxIterationCount, "maxIterationCount", 349, 14024, 14535);
            CallChecker.varInit(convergence, "convergence", 349, 14024, 14535);
            CallChecker.varInit(maxCheckInterval, "maxCheckInterval", 349, 14024, 14535);
            CallChecker.varInit(function, "function", 349, 14024, 14535);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 349, 14024, 14535);
            CallChecker.varInit(this.isLastStep, "isLastStep", 349, 14024, 14535);
            CallChecker.varInit(this.stepSize, "stepSize", 349, 14024, 14535);
            CallChecker.varInit(this.stepStart, "stepStart", 349, 14024, 14535);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 349, 14024, 14535);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 349, 14024, 14535);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 349, 14024, 14535);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 349, 14024, 14535);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 349, 14024, 14535);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 349, 14024, 14535);
            CallChecker.varInit(this.mudif, "mudif", 349, 14024, 14535);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 349, 14024, 14535);
            CallChecker.varInit(this.orderControl2, "orderControl2", 349, 14024, 14535);
            CallChecker.varInit(this.orderControl1, "orderControl1", 349, 14024, 14535);
            CallChecker.varInit(this.stepControl4, "stepControl4", 349, 14024, 14535);
            CallChecker.varInit(this.stepControl3, "stepControl3", 349, 14024, 14535);
            CallChecker.varInit(this.stepControl2, "stepControl2", 349, 14024, 14535);
            CallChecker.varInit(this.stepControl1, "stepControl1", 349, 14024, 14535);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 349, 14024, 14535);
            CallChecker.varInit(this.maxIter, "maxIter", 349, 14024, 14535);
            CallChecker.varInit(this.maxChecks, "maxChecks", 349, 14024, 14535);
            CallChecker.varInit(this.performTest, "performTest", 349, 14024, 14535);
            CallChecker.varInit(this.coeff, "coeff", 349, 14024, 14535);
            CallChecker.varInit(this.optimalStep, "optimalStep", 349, 14024, 14535);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 349, 14024, 14535);
            CallChecker.varInit(this.costPerStep, "costPerStep", 349, 14024, 14535);
            CallChecker.varInit(this.sequence, "sequence", 349, 14024, 14535);
            CallChecker.varInit(this.maxOrder, "maxOrder", 349, 14024, 14535);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 349, 14024, 14535);
            super.addEventHandler(function, maxCheckInterval, convergence, maxIterationCount, solver);
            initializeArrays();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3376.methodEnd();
        }
    }

    private void initializeArrays() {
        MethodContext _bcornu_methode_context3377 = new MethodContext(void.class, 363, 14540, 15686);
        try {
            CallChecker.varInit(this, "this", 363, 14540, 15686);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 363, 14540, 15686);
            CallChecker.varInit(this.isLastStep, "isLastStep", 363, 14540, 15686);
            CallChecker.varInit(this.stepSize, "stepSize", 363, 14540, 15686);
            CallChecker.varInit(this.stepStart, "stepStart", 363, 14540, 15686);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 363, 14540, 15686);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 363, 14540, 15686);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 363, 14540, 15686);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 363, 14540, 15686);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 363, 14540, 15686);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 363, 14540, 15686);
            CallChecker.varInit(this.mudif, "mudif", 363, 14540, 15686);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 363, 14540, 15686);
            CallChecker.varInit(this.orderControl2, "orderControl2", 363, 14540, 15686);
            CallChecker.varInit(this.orderControl1, "orderControl1", 363, 14540, 15686);
            CallChecker.varInit(this.stepControl4, "stepControl4", 363, 14540, 15686);
            CallChecker.varInit(this.stepControl3, "stepControl3", 363, 14540, 15686);
            CallChecker.varInit(this.stepControl2, "stepControl2", 363, 14540, 15686);
            CallChecker.varInit(this.stepControl1, "stepControl1", 363, 14540, 15686);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 363, 14540, 15686);
            CallChecker.varInit(this.maxIter, "maxIter", 363, 14540, 15686);
            CallChecker.varInit(this.maxChecks, "maxChecks", 363, 14540, 15686);
            CallChecker.varInit(this.performTest, "performTest", 363, 14540, 15686);
            CallChecker.varInit(this.coeff, "coeff", 363, 14540, 15686);
            CallChecker.varInit(this.optimalStep, "optimalStep", 363, 14540, 15686);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 363, 14540, 15686);
            CallChecker.varInit(this.costPerStep, "costPerStep", 363, 14540, 15686);
            CallChecker.varInit(this.sequence, "sequence", 363, 14540, 15686);
            CallChecker.varInit(this.maxOrder, "maxOrder", 363, 14540, 15686);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 363, 14540, 15686);
            final int size = CallChecker.varInit(((int) ((this.maxOrder) / 2)), "size", 365, 14631, 14660);
            if (((sequence) == null) || ((sequence.length) != size)) {
                sequence = new int[size];
                CallChecker.varAssign(this.sequence, "this.sequence", 369, 14790, 14821);
                costPerStep = new int[size];
                CallChecker.varAssign(this.costPerStep, "this.costPerStep", 370, 14829, 14860);
                coeff = new double[size][];
                CallChecker.varAssign(this.coeff, "this.coeff", 371, 14868, 14904);
                costPerTimeUnit = new double[size];
                CallChecker.varAssign(this.costPerTimeUnit, "this.costPerTimeUnit", 372, 14912, 14946);
                optimalStep = new double[size];
                CallChecker.varAssign(this.optimalStep, "this.optimalStep", 373, 14954, 14988);
            }
            for (int k = 0; k < size; ++k) {
                if (CallChecker.beforeDeref(sequence, int[].class, 378, 15087, 15094)) {
                    sequence = CallChecker.beforeCalled(sequence, int[].class, 378, 15087, 15094);
                    CallChecker.isCalled(sequence, int[].class, 378, 15087, 15094)[k] = (4 * k) + 2;
                    CallChecker.varAssign(CallChecker.isCalled(this.sequence, int[].class, 378, 15087, 15094)[k], "CallChecker.isCalled(this.sequence, int[].class, 378, 15087, 15094)[k]", 378, 15087, 15110);
                }
            }
            if (CallChecker.beforeDeref(costPerStep, int[].class, 383, 15249, 15259)) {
                if (CallChecker.beforeDeref(sequence, int[].class, 383, 15266, 15273)) {
                    costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 383, 15249, 15259);
                    sequence = CallChecker.beforeCalled(sequence, int[].class, 383, 15266, 15273);
                    CallChecker.isCalled(costPerStep, int[].class, 383, 15249, 15259)[0] = (CallChecker.isCalled(sequence, int[].class, 383, 15266, 15273)[0]) + 1;
                    CallChecker.varAssign(CallChecker.isCalled(this.costPerStep, int[].class, 383, 15249, 15259)[0], "CallChecker.isCalled(this.costPerStep, int[].class, 383, 15249, 15259)[0]", 383, 15249, 15281);
                }
            }
            for (int k = 1; k < size; ++k) {
                if (CallChecker.beforeDeref(costPerStep, int[].class, 385, 15326, 15336)) {
                    if (CallChecker.beforeDeref(costPerStep, int[].class, 385, 15343, 15353)) {
                        if (CallChecker.beforeDeref(sequence, int[].class, 385, 15362, 15369)) {
                            costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 385, 15326, 15336);
                            costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 385, 15343, 15353);
                            sequence = CallChecker.beforeCalled(sequence, int[].class, 385, 15362, 15369);
                            CallChecker.isCalled(costPerStep, int[].class, 385, 15326, 15336)[k] = (CallChecker.isCalled(costPerStep, int[].class, 385, 15343, 15353)[(k - 1)]) + (CallChecker.isCalled(sequence, int[].class, 385, 15362, 15369)[k]);
                            CallChecker.varAssign(CallChecker.isCalled(this.costPerStep, int[].class, 385, 15326, 15336)[k], "CallChecker.isCalled(this.costPerStep, int[].class, 385, 15326, 15336)[k]", 385, 15326, 15373);
                        }
                    }
                }
            }
            for (int k = 0; k < size; ++k) {
                if (k > 0) {
                    if (CallChecker.beforeDeref(coeff, double[][].class, 390, 15468, 15472)) {
                        coeff = CallChecker.beforeCalled(coeff, double[][].class, 390, 15468, 15472);
                        CallChecker.isCalled(coeff, double[][].class, 390, 15468, 15472)[k] = new double[k];
                        CallChecker.varAssign(CallChecker.isCalled(this.coeff, double[][].class, 390, 15468, 15472)[k], "CallChecker.isCalled(this.coeff, double[][].class, 390, 15468, 15472)[k]", 390, 15468, 15509);
                    }
                }else {
                    if (CallChecker.beforeDeref(coeff, double[][].class, 390, 15468, 15472)) {
                        coeff = CallChecker.beforeCalled(coeff, double[][].class, 390, 15468, 15472);
                        CallChecker.isCalled(coeff, double[][].class, 390, 15468, 15472)[k] = null;
                        CallChecker.varAssign(CallChecker.isCalled(this.coeff, double[][].class, 390, 15468, 15472)[k], "CallChecker.isCalled(this.coeff, double[][].class, 390, 15468, 15472)[k]", 390, 15468, 15509);
                    }
                }
                for (int l = 0; l < k; ++l) {
                    sequence = CallChecker.beforeCalled(sequence, int[].class, 392, 15586, 15593);
                    sequence = CallChecker.beforeCalled(sequence, int[].class, 392, 15601, 15608);
                    final double ratio = CallChecker.varInit(((double) (((double) (CallChecker.isCalled(this.sequence, int[].class, 392, 15586, 15593)[k])) / (CallChecker.isCalled(this.sequence, int[].class, 392, 15601, 15608)[((k - l) - 1)]))), "ratio", 392, 15555, 15616);
                    if (CallChecker.beforeDeref(coeff, double[][].class, 393, 15626, 15630)) {
                        coeff = CallChecker.beforeCalled(coeff, double[][].class, 393, 15626, 15630);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, double[][].class, 393, 15626, 15630)[k], double[].class, 393, 15626, 15633)) {
                            coeff = CallChecker.beforeCalled(coeff, double[][].class, 393, 15626, 15630);
                            CallChecker.isCalled(coeff, double[][].class, 393, 15626, 15630)[k] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, double[][].class, 393, 15626, 15630)[k], double[].class, 393, 15626, 15633);
                            CallChecker.isCalled(CallChecker.isCalled(coeff, double[][].class, 393, 15626, 15630)[k], double[].class, 393, 15626, 15633)[l] = 1.0 / ((ratio * ratio) - 1.0);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.coeff, double[][].class, 393, 15626, 15630)[k], double[].class, 393, 15626, 15633)[l], "CallChecker.isCalled(CallChecker.isCalled(this.coeff, double[][].class, 393, 15626, 15630)[k], double[].class, 393, 15626, 15633)[l]", 393, 15626, 15667);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3377.methodEnd();
        }
    }

    public void setInterpolationControl(final boolean useInterpolationErrorForControl, final int mudifControlParameter) {
        MethodContext _bcornu_methode_context3378 = new MethodContext(void.class, 409, 15691, 16545);
        try {
            CallChecker.varInit(this, "this", 409, 15691, 16545);
            CallChecker.varInit(mudifControlParameter, "mudifControlParameter", 409, 15691, 16545);
            CallChecker.varInit(useInterpolationErrorForControl, "useInterpolationErrorForControl", 409, 15691, 16545);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 409, 15691, 16545);
            CallChecker.varInit(this.isLastStep, "isLastStep", 409, 15691, 16545);
            CallChecker.varInit(this.stepSize, "stepSize", 409, 15691, 16545);
            CallChecker.varInit(this.stepStart, "stepStart", 409, 15691, 16545);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 409, 15691, 16545);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 409, 15691, 16545);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 409, 15691, 16545);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 409, 15691, 16545);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 409, 15691, 16545);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 409, 15691, 16545);
            CallChecker.varInit(this.mudif, "mudif", 409, 15691, 16545);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 409, 15691, 16545);
            CallChecker.varInit(this.orderControl2, "orderControl2", 409, 15691, 16545);
            CallChecker.varInit(this.orderControl1, "orderControl1", 409, 15691, 16545);
            CallChecker.varInit(this.stepControl4, "stepControl4", 409, 15691, 16545);
            CallChecker.varInit(this.stepControl3, "stepControl3", 409, 15691, 16545);
            CallChecker.varInit(this.stepControl2, "stepControl2", 409, 15691, 16545);
            CallChecker.varInit(this.stepControl1, "stepControl1", 409, 15691, 16545);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 409, 15691, 16545);
            CallChecker.varInit(this.maxIter, "maxIter", 409, 15691, 16545);
            CallChecker.varInit(this.maxChecks, "maxChecks", 409, 15691, 16545);
            CallChecker.varInit(this.performTest, "performTest", 409, 15691, 16545);
            CallChecker.varInit(this.coeff, "coeff", 409, 15691, 16545);
            CallChecker.varInit(this.optimalStep, "optimalStep", 409, 15691, 16545);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 409, 15691, 16545);
            CallChecker.varInit(this.costPerStep, "costPerStep", 409, 15691, 16545);
            CallChecker.varInit(this.sequence, "sequence", 409, 15691, 16545);
            CallChecker.varInit(this.maxOrder, "maxOrder", 409, 15691, 16545);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 409, 15691, 16545);
            this.useInterpolationError = useInterpolationErrorForControl;
            CallChecker.varAssign(this.useInterpolationError, "this.useInterpolationError", 412, 16324, 16384);
            if ((mudifControlParameter <= 0) || (mudifControlParameter >= 7)) {
                this.mudif = 4;
                CallChecker.varAssign(this.mudif, "this.mudif", 415, 16465, 16479);
            }else {
                this.mudif = mudifControlParameter;
                CallChecker.varAssign(this.mudif, "this.mudif", 417, 16500, 16534);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3378.methodEnd();
        }
    }

    private void rescale(final double[] y1, final double[] y2, final double[] scale) {
        MethodContext _bcornu_methode_context3379 = new MethodContext(void.class, 427, 16550, 17325);
        try {
            CallChecker.varInit(this, "this", 427, 16550, 17325);
            CallChecker.varInit(scale, "scale", 427, 16550, 17325);
            CallChecker.varInit(y2, "y2", 427, 16550, 17325);
            CallChecker.varInit(y1, "y1", 427, 16550, 17325);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 427, 16550, 17325);
            CallChecker.varInit(this.isLastStep, "isLastStep", 427, 16550, 17325);
            CallChecker.varInit(this.stepSize, "stepSize", 427, 16550, 17325);
            CallChecker.varInit(this.stepStart, "stepStart", 427, 16550, 17325);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 427, 16550, 17325);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 427, 16550, 17325);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 427, 16550, 17325);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 427, 16550, 17325);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 427, 16550, 17325);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 427, 16550, 17325);
            CallChecker.varInit(this.mudif, "mudif", 427, 16550, 17325);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 427, 16550, 17325);
            CallChecker.varInit(this.orderControl2, "orderControl2", 427, 16550, 17325);
            CallChecker.varInit(this.orderControl1, "orderControl1", 427, 16550, 17325);
            CallChecker.varInit(this.stepControl4, "stepControl4", 427, 16550, 17325);
            CallChecker.varInit(this.stepControl3, "stepControl3", 427, 16550, 17325);
            CallChecker.varInit(this.stepControl2, "stepControl2", 427, 16550, 17325);
            CallChecker.varInit(this.stepControl1, "stepControl1", 427, 16550, 17325);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 427, 16550, 17325);
            CallChecker.varInit(this.maxIter, "maxIter", 427, 16550, 17325);
            CallChecker.varInit(this.maxChecks, "maxChecks", 427, 16550, 17325);
            CallChecker.varInit(this.performTest, "performTest", 427, 16550, 17325);
            CallChecker.varInit(this.coeff, "coeff", 427, 16550, 17325);
            CallChecker.varInit(this.optimalStep, "optimalStep", 427, 16550, 17325);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 427, 16550, 17325);
            CallChecker.varInit(this.costPerStep, "costPerStep", 427, 16550, 17325);
            CallChecker.varInit(this.sequence, "sequence", 427, 16550, 17325);
            CallChecker.varInit(this.maxOrder, "maxOrder", 427, 16550, 17325);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 427, 16550, 17325);
            if ((vecAbsoluteTolerance) == null) {
                for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 429, 16910, 16914).length); ++i) {
                    final double yi = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(y1, double[].class, 430, 16983, 16984)[i]), FastMath.abs(CallChecker.isCalled(y2, double[].class, 430, 17004, 17005)[i])))), "yi", 430, 16939, 17011);
                    if (CallChecker.beforeDeref(scale, double[].class, 431, 17021, 17025)) {
                        CallChecker.isCalled(scale, double[].class, 431, 17021, 17025)[i] = (scalAbsoluteTolerance) + ((scalRelativeTolerance) * yi);
                        CallChecker.varAssign(CallChecker.isCalled(scale, double[].class, 431, 17021, 17025)[i], "CallChecker.isCalled(scale, double[].class, 431, 17021, 17025)[i]", 431, 17021, 17082);
                    }
                }
            }else {
                for (int i = 0; i < (CallChecker.isCalled(scale, double[].class, 434, 17131, 17135).length); ++i) {
                    final double yi = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(CallChecker.isCalled(y1, double[].class, 435, 17204, 17205)[i]), FastMath.abs(CallChecker.isCalled(y2, double[].class, 435, 17225, 17226)[i])))), "yi", 435, 17160, 17232);
                    if (CallChecker.beforeDeref(scale, double[].class, 436, 17242, 17246)) {
                        if (CallChecker.beforeDeref(vecRelativeTolerance, double[].class, 436, 17279, 17298)) {
                            vecRelativeTolerance = CallChecker.beforeCalled(vecRelativeTolerance, double[].class, 436, 17279, 17298);
                            CallChecker.isCalled(scale, double[].class, 436, 17242, 17246)[i] = (vecAbsoluteTolerance[i]) + ((CallChecker.isCalled(vecRelativeTolerance, double[].class, 436, 17279, 17298)[i]) * yi);
                            CallChecker.varAssign(CallChecker.isCalled(scale, double[].class, 436, 17242, 17246)[i], "CallChecker.isCalled(scale, double[].class, 436, 17242, 17246)[i]", 436, 17242, 17307);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3379.methodEnd();
        }
    }

    private boolean tryStep(final double t0, final double[] y0, final double step, final int k, final double[] scale, final double[][] f, final double[] yMiddle, final double[] yEnd, final double[] yTmp) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context3380 = new MethodContext(boolean.class, 458, 17330, 20209);
        try {
            CallChecker.varInit(this, "this", 458, 17330, 20209);
            CallChecker.varInit(yTmp, "yTmp", 458, 17330, 20209);
            CallChecker.varInit(yEnd, "yEnd", 458, 17330, 20209);
            CallChecker.varInit(yMiddle, "yMiddle", 458, 17330, 20209);
            CallChecker.varInit(f, "f", 458, 17330, 20209);
            CallChecker.varInit(scale, "scale", 458, 17330, 20209);
            CallChecker.varInit(k, "k", 458, 17330, 20209);
            CallChecker.varInit(step, "step", 458, 17330, 20209);
            CallChecker.varInit(y0, "y0", 458, 17330, 20209);
            CallChecker.varInit(t0, "t0", 458, 17330, 20209);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 458, 17330, 20209);
            CallChecker.varInit(this.isLastStep, "isLastStep", 458, 17330, 20209);
            CallChecker.varInit(this.stepSize, "stepSize", 458, 17330, 20209);
            CallChecker.varInit(this.stepStart, "stepStart", 458, 17330, 20209);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 458, 17330, 20209);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 458, 17330, 20209);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 458, 17330, 20209);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 458, 17330, 20209);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 458, 17330, 20209);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 458, 17330, 20209);
            CallChecker.varInit(this.mudif, "mudif", 458, 17330, 20209);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 458, 17330, 20209);
            CallChecker.varInit(this.orderControl2, "orderControl2", 458, 17330, 20209);
            CallChecker.varInit(this.orderControl1, "orderControl1", 458, 17330, 20209);
            CallChecker.varInit(this.stepControl4, "stepControl4", 458, 17330, 20209);
            CallChecker.varInit(this.stepControl3, "stepControl3", 458, 17330, 20209);
            CallChecker.varInit(this.stepControl2, "stepControl2", 458, 17330, 20209);
            CallChecker.varInit(this.stepControl1, "stepControl1", 458, 17330, 20209);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 458, 17330, 20209);
            CallChecker.varInit(this.maxIter, "maxIter", 458, 17330, 20209);
            CallChecker.varInit(this.maxChecks, "maxChecks", 458, 17330, 20209);
            CallChecker.varInit(this.performTest, "performTest", 458, 17330, 20209);
            CallChecker.varInit(this.coeff, "coeff", 458, 17330, 20209);
            CallChecker.varInit(this.optimalStep, "optimalStep", 458, 17330, 20209);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 458, 17330, 20209);
            CallChecker.varInit(this.costPerStep, "costPerStep", 458, 17330, 20209);
            CallChecker.varInit(this.sequence, "sequence", 458, 17330, 20209);
            CallChecker.varInit(this.maxOrder, "maxOrder", 458, 17330, 20209);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 458, 17330, 20209);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 464, 18704, 18711);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.sequence, int[].class, 464, 18704, 18711)[k])), "n", 464, 18680, 18715);
            final double subStep = CallChecker.varInit(((double) (step / n)), "subStep", 465, 18721, 18753);
            final double subStep2 = CallChecker.varInit(((double) (2 * subStep)), "subStep2", 466, 18759, 18794);
            double t = CallChecker.varInit(((double) (t0 + subStep)), "t", 469, 18822, 18845);
            for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 470, 18871, 18872).length); ++i) {
                if (CallChecker.beforeDeref(yTmp, double[].class, 471, 18895, 18898)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 471, 18905, 18906)) {
                        CallChecker.isCalled(yTmp, double[].class, 471, 18895, 18898)[i] = CallChecker.isCalled(y0, double[].class, 471, 18905, 18906)[i];
                        CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 471, 18895, 18898)[i], "CallChecker.isCalled(yTmp, double[].class, 471, 18895, 18898)[i]", 471, 18895, 18910);
                    }
                }
                if (CallChecker.beforeDeref(yEnd, double[].class, 472, 18918, 18921)) {
                    if (CallChecker.beforeDeref(y0, double[].class, 472, 18928, 18929)) {
                        if (CallChecker.beforeDeref(f, double[][].class, 472, 18946, 18946)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 472, 18946, 18946)[0], double[].class, 472, 18946, 18949)) {
                                CallChecker.isCalled(f, double[][].class, 472, 18946, 18946)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 472, 18946, 18946)[0], double[].class, 472, 18946, 18949);
                                CallChecker.isCalled(yEnd, double[].class, 472, 18918, 18921)[i] = (CallChecker.isCalled(y0, double[].class, 472, 18928, 18929)[i]) + (subStep * (CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 472, 18946, 18946)[0], double[].class, 472, 18946, 18949)[i]));
                                CallChecker.varAssign(CallChecker.isCalled(yEnd, double[].class, 472, 18918, 18921)[i], "CallChecker.isCalled(yEnd, double[].class, 472, 18918, 18921)[i]", 472, 18918, 18953);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(f, double[][].class, 474, 18993, 18993)) {
                computeDerivatives(t, yEnd, CallChecker.isCalled(f, double[][].class, 474, 18993, 18993)[1]);
            }
            for (int j = 1; j < n; ++j) {
                if ((2 * j) == n) {
                    if (CallChecker.beforeDeref(y0, double[].class, 481, 19180, 19181)) {
                        System.arraycopy(yEnd, 0, yMiddle, 0, CallChecker.isCalled(y0, double[].class, 481, 19180, 19181).length);
                    }
                }
                t += subStep;
                CallChecker.varAssign(t, "t", 484, 19207, 19219);
                for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 485, 19247, 19248).length); ++i) {
                    final double middle = CallChecker.varInit(((double) (CallChecker.isCalled(yEnd, double[].class, 486, 19295, 19298)[i])), "middle", 486, 19273, 19302);
                    if (CallChecker.beforeDeref(yEnd, double[].class, 487, 19312, 19315)) {
                        if (CallChecker.beforeDeref(yTmp, double[].class, 487, 19328, 19331)) {
                            if (CallChecker.beforeDeref(f, double[][].class, 487, 19349, 19349)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 487, 19349, 19349)[j], double[].class, 487, 19349, 19352)) {
                                    CallChecker.isCalled(f, double[][].class, 487, 19349, 19349)[j] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 487, 19349, 19349)[j], double[].class, 487, 19349, 19352);
                                    CallChecker.isCalled(yEnd, double[].class, 487, 19312, 19315)[i] = (CallChecker.isCalled(yTmp, double[].class, 487, 19328, 19331)[i]) + (subStep2 * (CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 487, 19349, 19349)[j], double[].class, 487, 19349, 19352)[i]));
                                    CallChecker.varAssign(CallChecker.isCalled(yEnd, double[].class, 487, 19312, 19315)[i], "CallChecker.isCalled(yEnd, double[].class, 487, 19312, 19315)[i]", 487, 19312, 19356);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(yTmp, double[].class, 488, 19366, 19369)) {
                        CallChecker.isCalled(yTmp, double[].class, 488, 19366, 19369)[i] = middle;
                        CallChecker.varAssign(CallChecker.isCalled(yTmp, double[].class, 488, 19366, 19369)[i], "CallChecker.isCalled(yTmp, double[].class, 488, 19366, 19369)[i]", 488, 19366, 19388);
                    }
                }
                if (CallChecker.beforeDeref(f, double[][].class, 491, 19433, 19433)) {
                    computeDerivatives(t, yEnd, CallChecker.isCalled(f, double[][].class, 491, 19433, 19433)[(j + 1)]);
                }
                if (((performTest) && (j <= (maxChecks))) && (k < (maxIter))) {
                    double initialNorm = CallChecker.varInit(((double) (0.0)), "initialNorm", 495, 19538, 19562);
                    for (int l = 0; l < (CallChecker.isCalled(scale, double[].class, 496, 19592, 19596).length); ++l) {
                        CallChecker.isCalled(f, double[][].class, 497, 19644, 19644)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 497, 19644, 19644)[0], double[].class, 497, 19644, 19647);
                        final double ratio = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 497, 19644, 19644)[0], double[].class, 497, 19644, 19647)[l]) / (CallChecker.isCalled(scale, double[].class, 497, 19654, 19658)[l]))), "ratio", 497, 19623, 19662);
                        initialNorm += ratio * ratio;
                        CallChecker.varAssign(initialNorm, "initialNorm", 498, 19674, 19702);
                    }
                    double deltaNorm = CallChecker.varInit(((double) (0.0)), "deltaNorm", 500, 19722, 19744);
                    for (int l = 0; l < (CallChecker.isCalled(scale, double[].class, 501, 19774, 19778).length); ++l) {
                        CallChecker.isCalled(f, double[][].class, 502, 19827, 19827)[(j + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 502, 19827, 19827)[(j + 1)], double[].class, 502, 19827, 19832);
                        CallChecker.isCalled(f, double[][].class, 502, 19839, 19839)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 502, 19839, 19839)[0], double[].class, 502, 19839, 19842);
                        final double ratio = CallChecker.varInit(((double) (((CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 502, 19827, 19827)[(j + 1)], double[].class, 502, 19827, 19832)[l]) - (CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 502, 19839, 19839)[0], double[].class, 502, 19839, 19842)[l])) / (CallChecker.isCalled(scale, double[].class, 502, 19850, 19854)[l]))), "ratio", 502, 19805, 19858);
                        deltaNorm += ratio * ratio;
                        CallChecker.varAssign(deltaNorm, "deltaNorm", 503, 19870, 19896);
                    }
                    if (deltaNorm > (4 * (FastMath.max(1.0E-15, initialNorm)))) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 513, 20101, 20102).length); ++i) {
                if (CallChecker.beforeDeref(yEnd, double[].class, 514, 20125, 20128)) {
                    if (CallChecker.beforeDeref(yTmp, double[].class, 514, 20142, 20145)) {
                        if (CallChecker.beforeDeref(yEnd, double[].class, 514, 20152, 20155)) {
                            if (CallChecker.beforeDeref(f, double[][].class, 514, 20172, 20172)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 514, 20172, 20172)[n], double[].class, 514, 20172, 20175)) {
                                    CallChecker.isCalled(f, double[][].class, 514, 20172, 20172)[n] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 514, 20172, 20172)[n], double[].class, 514, 20172, 20175);
                                    CallChecker.isCalled(yEnd, double[].class, 514, 20125, 20128)[i] = 0.5 * (((CallChecker.isCalled(yTmp, double[].class, 514, 20142, 20145)[i]) + (CallChecker.isCalled(yEnd, double[].class, 514, 20152, 20155)[i])) + (subStep * (CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 514, 20172, 20172)[n], double[].class, 514, 20172, 20175)[i])));
                                    CallChecker.varAssign(CallChecker.isCalled(yEnd, double[].class, 514, 20125, 20128)[i], "CallChecker.isCalled(yEnd, double[].class, 514, 20125, 20128)[i]", 514, 20125, 20180);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3380.methodEnd();
        }
    }

    private void extrapolate(final int offset, final int k, final double[][] diag, final double[] last) {
        MethodContext _bcornu_methode_context3381 = new MethodContext(void.class, 528, 20214, 21103);
        try {
            CallChecker.varInit(this, "this", 528, 20214, 21103);
            CallChecker.varInit(last, "last", 528, 20214, 21103);
            CallChecker.varInit(diag, "diag", 528, 20214, 21103);
            CallChecker.varInit(k, "k", 528, 20214, 21103);
            CallChecker.varInit(offset, "offset", 528, 20214, 21103);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 528, 20214, 21103);
            CallChecker.varInit(this.isLastStep, "isLastStep", 528, 20214, 21103);
            CallChecker.varInit(this.stepSize, "stepSize", 528, 20214, 21103);
            CallChecker.varInit(this.stepStart, "stepStart", 528, 20214, 21103);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 528, 20214, 21103);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 528, 20214, 21103);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 528, 20214, 21103);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 528, 20214, 21103);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 528, 20214, 21103);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 528, 20214, 21103);
            CallChecker.varInit(this.mudif, "mudif", 528, 20214, 21103);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 528, 20214, 21103);
            CallChecker.varInit(this.orderControl2, "orderControl2", 528, 20214, 21103);
            CallChecker.varInit(this.orderControl1, "orderControl1", 528, 20214, 21103);
            CallChecker.varInit(this.stepControl4, "stepControl4", 528, 20214, 21103);
            CallChecker.varInit(this.stepControl3, "stepControl3", 528, 20214, 21103);
            CallChecker.varInit(this.stepControl2, "stepControl2", 528, 20214, 21103);
            CallChecker.varInit(this.stepControl1, "stepControl1", 528, 20214, 21103);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 528, 20214, 21103);
            CallChecker.varInit(this.maxIter, "maxIter", 528, 20214, 21103);
            CallChecker.varInit(this.maxChecks, "maxChecks", 528, 20214, 21103);
            CallChecker.varInit(this.performTest, "performTest", 528, 20214, 21103);
            CallChecker.varInit(this.coeff, "coeff", 528, 20214, 21103);
            CallChecker.varInit(this.optimalStep, "optimalStep", 528, 20214, 21103);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 528, 20214, 21103);
            CallChecker.varInit(this.costPerStep, "costPerStep", 528, 20214, 21103);
            CallChecker.varInit(this.sequence, "sequence", 528, 20214, 21103);
            CallChecker.varInit(this.maxOrder, "maxOrder", 528, 20214, 21103);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 528, 20214, 21103);
            for (int j = 1; j < k; ++j) {
                for (int i = 0; i < (CallChecker.isCalled(last, double[].class, 533, 20698, 20701).length); ++i) {
                    if (CallChecker.beforeDeref(diag, double[][].class, 535, 20772, 20775)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)], double[].class, 535, 20772, 20782)) {
                            if (CallChecker.beforeDeref(diag, double[][].class, 535, 20789, 20792)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 535, 20789, 20792)[(k - j)], double[].class, 535, 20789, 20797)) {
                                    if (CallChecker.beforeDeref(coeff, double[][].class, 536, 20829, 20833)) {
                                        coeff = CallChecker.beforeCalled(coeff, double[][].class, 536, 20829, 20833);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, double[][].class, 536, 20829, 20833)[(k + offset)], double[].class, 536, 20829, 20843)) {
                                            if (CallChecker.beforeDeref(diag, double[][].class, 536, 20853, 20856)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 536, 20853, 20856)[(k - j)], double[].class, 536, 20853, 20861)) {
                                                    if (CallChecker.beforeDeref(diag, double[][].class, 536, 20868, 20871)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 536, 20868, 20871)[((k - j) - 1)], double[].class, 536, 20868, 20878)) {
                                                            CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)], double[].class, 535, 20772, 20782);
                                                            CallChecker.isCalled(diag, double[][].class, 535, 20789, 20792)[(k - j)] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 535, 20789, 20792)[(k - j)], double[].class, 535, 20789, 20797);
                                                            coeff = CallChecker.beforeCalled(coeff, double[][].class, 536, 20829, 20833);
                                                            CallChecker.isCalled(coeff, double[][].class, 536, 20829, 20833)[(k + offset)] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, double[][].class, 536, 20829, 20833)[(k + offset)], double[].class, 536, 20829, 20843);
                                                            CallChecker.isCalled(diag, double[][].class, 536, 20853, 20856)[(k - j)] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 536, 20853, 20856)[(k - j)], double[].class, 536, 20853, 20861);
                                                            CallChecker.isCalled(diag, double[][].class, 536, 20868, 20871)[((k - j) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 536, 20868, 20871)[((k - j) - 1)], double[].class, 536, 20868, 20878);
                                                            CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)], double[].class, 535, 20772, 20782)[i] = (CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 535, 20789, 20792)[(k - j)], double[].class, 535, 20789, 20797)[i]) + ((CallChecker.isCalled(CallChecker.isCalled(coeff, double[][].class, 536, 20829, 20833)[(k + offset)], double[].class, 536, 20829, 20843)[(j - 1)]) * ((CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 536, 20853, 20856)[(k - j)], double[].class, 536, 20853, 20861)[i]) - (CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 536, 20868, 20871)[((k - j) - 1)], double[].class, 536, 20868, 20878)[i])));
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)], double[].class, 535, 20772, 20782)[i], "CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 535, 20772, 20775)[((k - j) - 1)], double[].class, 535, 20772, 20782)[i]", 535, 20772, 20883);
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
            for (int i = 0; i < (CallChecker.isCalled(last, double[].class, 541, 20955, 20958).length); ++i) {
                if (CallChecker.beforeDeref(last, double[].class, 543, 21025, 21028)) {
                    if (CallChecker.beforeDeref(diag, double[][].class, 543, 21035, 21038)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 543, 21035, 21038)[0], double[].class, 543, 21035, 21041)) {
                            if (CallChecker.beforeDeref(coeff, double[][].class, 543, 21048, 21052)) {
                                coeff = CallChecker.beforeCalled(coeff, double[][].class, 543, 21048, 21052);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, double[][].class, 543, 21048, 21052)[(k + offset)], double[].class, 543, 21048, 21062)) {
                                    if (CallChecker.beforeDeref(diag, double[][].class, 543, 21072, 21075)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(diag, double[][].class, 543, 21072, 21075)[0], double[].class, 543, 21072, 21078)) {
                                            if (CallChecker.beforeDeref(last, double[].class, 543, 21085, 21088)) {
                                                CallChecker.isCalled(diag, double[][].class, 543, 21035, 21038)[0] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 543, 21035, 21038)[0], double[].class, 543, 21035, 21041);
                                                coeff = CallChecker.beforeCalled(coeff, double[][].class, 543, 21048, 21052);
                                                CallChecker.isCalled(coeff, double[][].class, 543, 21048, 21052)[(k + offset)] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, double[][].class, 543, 21048, 21052)[(k + offset)], double[].class, 543, 21048, 21062);
                                                CallChecker.isCalled(diag, double[][].class, 543, 21072, 21075)[0] = CallChecker.beforeCalled(CallChecker.isCalled(diag, double[][].class, 543, 21072, 21075)[0], double[].class, 543, 21072, 21078);
                                                CallChecker.isCalled(last, double[].class, 543, 21025, 21028)[i] = (CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 543, 21035, 21038)[0], double[].class, 543, 21035, 21041)[i]) + ((CallChecker.isCalled(CallChecker.isCalled(coeff, double[][].class, 543, 21048, 21052)[(k + offset)], double[].class, 543, 21048, 21062)[(k - 1)]) * ((CallChecker.isCalled(CallChecker.isCalled(diag, double[][].class, 543, 21072, 21075)[0], double[].class, 543, 21072, 21078)[i]) - (CallChecker.isCalled(last, double[].class, 543, 21085, 21088)[i])));
                                                CallChecker.varAssign(CallChecker.isCalled(last, double[].class, 543, 21025, 21028)[i], "CallChecker.isCalled(last, double[].class, 543, 21025, 21028)[i]", 543, 21025, 21093);
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
            _bcornu_methode_context3381.methodEnd();
        }
    }

    @Override
    public void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3382 = new MethodContext(void.class, 549, 21108, 34972);
        try {
            CallChecker.varInit(this, "this", 549, 21108, 34972);
            CallChecker.varInit(t, "t", 549, 21108, 34972);
            CallChecker.varInit(equations, "equations", 549, 21108, 34972);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 549, 21108, 34972);
            CallChecker.varInit(this.isLastStep, "isLastStep", 549, 21108, 34972);
            CallChecker.varInit(this.stepSize, "stepSize", 549, 21108, 34972);
            CallChecker.varInit(this.stepStart, "stepStart", 549, 21108, 34972);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 549, 21108, 34972);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 549, 21108, 34972);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 549, 21108, 34972);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 549, 21108, 34972);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 549, 21108, 34972);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 549, 21108, 34972);
            CallChecker.varInit(this.mudif, "mudif", 549, 21108, 34972);
            CallChecker.varInit(this.useInterpolationError, "useInterpolationError", 549, 21108, 34972);
            CallChecker.varInit(this.orderControl2, "orderControl2", 549, 21108, 34972);
            CallChecker.varInit(this.orderControl1, "orderControl1", 549, 21108, 34972);
            CallChecker.varInit(this.stepControl4, "stepControl4", 549, 21108, 34972);
            CallChecker.varInit(this.stepControl3, "stepControl3", 549, 21108, 34972);
            CallChecker.varInit(this.stepControl2, "stepControl2", 549, 21108, 34972);
            CallChecker.varInit(this.stepControl1, "stepControl1", 549, 21108, 34972);
            CallChecker.varInit(this.stabilityReduction, "stabilityReduction", 549, 21108, 34972);
            CallChecker.varInit(this.maxIter, "maxIter", 549, 21108, 34972);
            CallChecker.varInit(this.maxChecks, "maxChecks", 549, 21108, 34972);
            CallChecker.varInit(this.performTest, "performTest", 549, 21108, 34972);
            CallChecker.varInit(this.coeff, "coeff", 549, 21108, 34972);
            CallChecker.varInit(this.optimalStep, "optimalStep", 549, 21108, 34972);
            CallChecker.varInit(this.costPerTimeUnit, "costPerTimeUnit", 549, 21108, 34972);
            CallChecker.varInit(this.costPerStep, "costPerStep", 549, 21108, 34972);
            CallChecker.varInit(this.sequence, "sequence", 549, 21108, 34972);
            CallChecker.varInit(this.maxOrder, "maxOrder", 549, 21108, 34972);
            CallChecker.varInit(METHOD_NAME, "org.apache.commons.math3.ode.nonstiff.GraggBulirschStoerIntegrator.METHOD_NAME", 549, 21108, 34972);
            sanityChecks(equations, t);
            setEquations(equations);
            final boolean forward = CallChecker.varInit(((boolean) (t > (CallChecker.isCalled(equations, ExpandableStatefulODE.class, 555, 21446, 21454).getTime()))), "forward", 555, 21418, 21465);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 558, 21540, 21548).getCompleteState(), "y0", 558, 21515, 21568);
            final double[] y = CallChecker.varInit(CallChecker.isCalled(y0, double[].class, 559, 21599, 21600).clone(), "y", 559, 21574, 21609);
            final double[] yDot0 = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 560, 21651, 21651).length], "yDot0", 560, 21615, 21660);
            final double[] y1 = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 561, 21702, 21702).length], "y1", 561, 21666, 21711);
            final double[] yTmp = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 562, 21753, 21753).length], "yTmp", 562, 21717, 21762);
            final double[] yTmpDot = CallChecker.varInit(new double[CallChecker.isCalled(y, double[].class, 563, 21804, 21804).length], "yTmpDot", 563, 21768, 21813);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 565, 21859, 21866);
            final double[][] diagonal = CallChecker.varInit(new double[(CallChecker.isCalled(sequence, int[].class, 565, 21859, 21866).length) - 1][], "diagonal", 565, 21820, 21879);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 566, 21922, 21929);
            final double[][] y1Diag = CallChecker.varInit(new double[(CallChecker.isCalled(sequence, int[].class, 566, 21922, 21929).length) - 1][], "y1Diag", 566, 21885, 21942);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 567, 21968, 21975);
            for (int k = 0; k < ((CallChecker.isCalled(sequence, int[].class, 567, 21968, 21975).length) - 1); ++k) {
                if (CallChecker.beforeDeref(diagonal, double[][].class, 568, 22000, 22007)) {
                    if (CallChecker.beforeDeref(y, double[].class, 568, 22025, 22025)) {
                        CallChecker.isCalled(diagonal, double[][].class, 568, 22000, 22007)[k] = new double[CallChecker.isCalled(y, double[].class, 568, 22025, 22025).length];
                        CallChecker.varAssign(CallChecker.isCalled(diagonal, double[][].class, 568, 22000, 22007)[k], "CallChecker.isCalled(diagonal, double[][].class, 568, 22000, 22007)[k]", 568, 22000, 22034);
                    }
                }
                if (CallChecker.beforeDeref(y1Diag, double[][].class, 569, 22042, 22047)) {
                    if (CallChecker.beforeDeref(y, double[].class, 569, 22065, 22065)) {
                        CallChecker.isCalled(y1Diag, double[][].class, 569, 22042, 22047)[k] = new double[CallChecker.isCalled(y, double[].class, 569, 22065, 22065).length];
                        CallChecker.varAssign(CallChecker.isCalled(y1Diag, double[][].class, 569, 22042, 22047)[k], "CallChecker.isCalled(y1Diag, double[][].class, 569, 22042, 22047)[k]", 569, 22042, 22074);
                    }
                }
            }
            sequence = CallChecker.beforeCalled(sequence, int[].class, 572, 22123, 22130);
            final double[][][] fk = CallChecker.varInit(new double[CallChecker.isCalled(sequence, int[].class, 572, 22123, 22130).length][][], "fk", 572, 22087, 22143);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 573, 22169, 22176);
            for (int k = 0; k < (CallChecker.isCalled(sequence, int[].class, 573, 22169, 22176).length); ++k) {
                if (CallChecker.beforeDeref(fk, double[][][].class, 575, 22200, 22201)) {
                    if (CallChecker.beforeDeref(sequence, int[].class, 575, 22222, 22229)) {
                        sequence = CallChecker.beforeCalled(sequence, int[].class, 575, 22222, 22229);
                        CallChecker.isCalled(fk, double[][][].class, 575, 22200, 22201)[k] = new double[(CallChecker.isCalled(sequence, int[].class, 575, 22222, 22229)[k]) + 1][];
                        CallChecker.varAssign(CallChecker.isCalled(fk, double[][][].class, 575, 22200, 22201)[k], "CallChecker.isCalled(fk, double[][][].class, 575, 22200, 22201)[k]", 575, 22200, 22240);
                    }
                }
                if (CallChecker.beforeDeref(fk, double[][][].class, 578, 22321, 22322)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k], double[][].class, 578, 22321, 22325)) {
                        CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k], double[][].class, 578, 22321, 22325);
                        CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k], double[][].class, 578, 22321, 22325)[0] = yDot0;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k], double[][].class, 578, 22321, 22325)[0], "CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 578, 22321, 22322)[k], double[][].class, 578, 22321, 22325)[0]", 578, 22321, 22337);
                    }
                }
                sequence = CallChecker.beforeCalled(sequence, int[].class, 580, 22366, 22373);
                for (int l = 0; l < (CallChecker.isCalled(sequence, int[].class, 580, 22366, 22373)[k]); ++l) {
                    if (CallChecker.beforeDeref(fk, double[][][].class, 581, 22394, 22395)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k], double[][].class, 581, 22394, 22398)) {
                            if (CallChecker.beforeDeref(y0, double[].class, 581, 22418, 22419)) {
                                CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k], double[][].class, 581, 22394, 22398);
                                CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k], double[][].class, 581, 22394, 22398)[(l + 1)] = new double[CallChecker.isCalled(y0, double[].class, 581, 22418, 22419).length];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k], double[][].class, 581, 22394, 22398)[(l + 1)], "CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 581, 22394, 22395)[k], double[][].class, 581, 22394, 22398)[(l + 1)]", 581, 22394, 22428);
                            }
                        }
                    }
                }
            }
            if (y != y0) {
                if (CallChecker.beforeDeref(y0, double[].class, 587, 22501, 22502)) {
                    System.arraycopy(y0, 0, y, 0, CallChecker.isCalled(y0, double[].class, 587, 22501, 22502).length);
                }
            }
            final double[] yDot1 = CallChecker.varInit(new double[CallChecker.isCalled(y0, double[].class, 590, 22558, 22559).length], "yDot1", 590, 22524, 22568);
            sequence = CallChecker.beforeCalled(sequence, int[].class, 591, 22621, 22628);
            final double[][] yMidDots = CallChecker.varInit(new double[1 + (2 * (CallChecker.isCalled(sequence, int[].class, 591, 22621, 22628).length))][CallChecker.isCalled(y0, double[].class, 591, 22638, 22639).length], "yMidDots", 591, 22574, 22648);
            final double[] scale = CallChecker.varInit(new double[mainSetDimension], "scale", 594, 22678, 22729);
            rescale(y, y, scale);
            double tol = CallChecker.init(double.class);
            if ((vecRelativeTolerance) == null) {
                tol = scalRelativeTolerance;
                CallChecker.varAssign(tol, "tol", 599, 22820, 22899);
            }else {
                tol = vecRelativeTolerance[0];
                CallChecker.varAssign(tol, "tol", 599, 22820, 22899);
            }
            final double log10R = CallChecker.varInit(((double) (FastMath.log10(FastMath.max(1.0E-10, tol)))), "log10R", 600, 22906, 22970);
            int targetIter = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(sequence, int[].class, 602, 23052, 23059)) {
                sequence = CallChecker.beforeCalled(sequence, int[].class, 602, 23052, 23059);
                targetIter = FastMath.max(1, FastMath.min(((CallChecker.isCalled(sequence, int[].class, 602, 23052, 23059).length) - 2), ((int) (FastMath.floor((0.5 - (0.6 * log10R)))))));
                CallChecker.varAssign(targetIter, "targetIter", 602, 23052, 23059);
            }
            final AbstractStepInterpolator interpolator = CallChecker.varInit(new GraggBulirschStoerStepInterpolator(y, yDot0, y1, yDot1, yMidDots, forward, CallChecker.isCalled(equations, ExpandableStatefulODE.class, 610, 23511, 23519).getPrimaryMapper(), CallChecker.isCalled(equations, ExpandableStatefulODE.class, 611, 23592, 23600).getSecondaryMappers()), "interpolator", 606, 23161, 23624);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 612, 23653, 23661)) {
                if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 612, 23630, 23641)) {
                    CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 612, 23630, 23641).storeTime(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 612, 23653, 23661).getTime());
                }
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 614, 23692, 23700)) {
                stepStart = CallChecker.isCalled(equations, ExpandableStatefulODE.class, 614, 23692, 23700).getTime();
                CallChecker.varAssign(this.stepStart, "this.stepStart", 614, 23680, 23711);
            }
            double hNew = CallChecker.varInit(((double) (0)), "hNew", 615, 23717, 23745);
            double maxError = CallChecker.varInit(((double) (Double.MAX_VALUE)), "maxError", 616, 23751, 23794);
            boolean previousRejected = CallChecker.varInit(((boolean) (false)), "previousRejected", 617, 23800, 23832);
            boolean firstTime = CallChecker.varInit(((boolean) (true)), "firstTime", 618, 23838, 23869);
            boolean newStep = CallChecker.varInit(((boolean) (true)), "newStep", 619, 23875, 23906);
            boolean firstStepAlreadyComputed = CallChecker.varInit(((boolean) (false)), "firstStepAlreadyComputed", 620, 23912, 23952);
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 621, 23974, 23982)) {
                initIntegration(CallChecker.isCalled(equations, ExpandableStatefulODE.class, 621, 23974, 23982).getTime(), y0, t);
            }
            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 622, 24007, 24021)) {
                costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 622, 24007, 24021);
                CallChecker.isCalled(costPerTimeUnit, double[].class, 622, 24007, 24021)[0] = 0;
                CallChecker.varAssign(CallChecker.isCalled(this.costPerTimeUnit, double[].class, 622, 24007, 24021)[0], "CallChecker.isCalled(this.costPerTimeUnit, double[].class, 622, 24007, 24021)[0]", 622, 24007, 24029);
            }
            isLastStep = false;
            CallChecker.varAssign(this.isLastStep, "this.isLastStep", 623, 24035, 24053);
            do {
                double error = CallChecker.init(double.class);
                boolean reject = CallChecker.varInit(((boolean) (false)), "reject", 627, 24091, 24113);
                if (newStep) {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 631, 24146, 24157)) {
                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 631, 24146, 24157).shift();
                    }
                    if (!firstStepAlreadyComputed) {
                        computeDerivatives(stepStart, y, yDot0);
                    }
                    if (firstTime) {
                        hNew = initializeStep(forward, ((2 * targetIter) + 1), scale, stepStart, y, yDot0, yTmp, yTmpDot);
                        CallChecker.varAssign(hNew, "hNew", 639, 24366, 24491);
                    }
                    newStep = false;
                    CallChecker.varAssign(newStep, "newStep", 643, 24512, 24527);
                }
                stepSize = hNew;
                CallChecker.varAssign(this.stepSize, "this.stepSize", 647, 24545, 24560);
                if ((forward && (((stepStart) + (stepSize)) > t)) || ((!forward) && (((stepStart) + (stepSize)) < t))) {
                    stepSize = t - (stepStart);
                    CallChecker.varAssign(this.stepSize, "this.stepSize", 652, 24718, 24742);
                }
                final double nextT = CallChecker.varInit(((double) ((this.stepStart) + (this.stepSize))), "nextT", 654, 24758, 24799);
                if (forward) {
                    isLastStep = nextT >= t;
                    CallChecker.varAssign(this.isLastStep, "this.isLastStep", 655, 24807, 24857);
                }else {
                    isLastStep = nextT <= t;
                    CallChecker.varAssign(this.isLastStep, "this.isLastStep", 655, 24807, 24857);
                }
                int k = CallChecker.varInit(((int) (-1)), "k", 658, 24910, 24920);
                for (boolean loop = true; loop;) {
                    ++k;
                    if (CallChecker.beforeDeref(fk, double[][][].class, 664, 25102, 25103)) {
                        if ((!(k == 0)) || (CallChecker.beforeDeref(yMidDots, double[][].class, 665, 25143, 25150))) {
                            if ((k == 0) || (CallChecker.beforeDeref(diagonal, double[][].class, 665, 25157, 25164))) {
                                if ((k == 0) || (CallChecker.beforeDeref(y1Diag, double[][].class, 666, 25211, 25216))) {
                                    if (!(tryStep(stepStart, y, stepSize, k, scale, CallChecker.isCalled(fk, double[][][].class, 664, 25102, 25103)[k], ((k == 0) ? CallChecker.isCalled(yMidDots, double[][].class, 665, 25143, 25150)[0] : CallChecker.isCalled(diagonal, double[][].class, 665, 25157, 25164)[(k - 1)]), ((k == 0) ? y1 : CallChecker.isCalled(y1Diag, double[][].class, 666, 25211, 25216)[(k - 1)]), yTmp))) {
                                        hNew = FastMath.abs(filterStep(((stepSize) * (stabilityReduction)), forward, false));
                                        CallChecker.varAssign(hNew, "hNew", 670, 25334, 25414);
                                        reject = true;
                                        CallChecker.varAssign(reject, "reject", 671, 25426, 25439);
                                        loop = false;
                                        CallChecker.varAssign(loop, "loop", 672, 25451, 25465);
                                    }else {
                                        if (k > 0) {
                                            extrapolate(0, k, y1Diag, y1);
                                            rescale(y, y1, scale);
                                            error = 0;
                                            CallChecker.varAssign(error, "error", 685, 25811, 25820);
                                            for (int j = 0; j < (mainSetDimension); ++j) {
                                                CallChecker.isCalled(y1Diag, double[][].class, 687, 25931, 25936)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y1Diag, double[][].class, 687, 25931, 25936)[0], double[].class, 687, 25931, 25939);
                                                final double e = CallChecker.varInit(((double) ((FastMath.abs(((CallChecker.isCalled(y1, double[].class, 687, 25923, 25924)[j]) - (CallChecker.isCalled(CallChecker.isCalled(y1Diag, double[][].class, 687, 25931, 25936)[0], double[].class, 687, 25931, 25939)[j])))) / (CallChecker.isCalled(scale, double[].class, 687, 25947, 25951)[j]))), "e", 687, 25893, 25955);
                                                error += e * e;
                                                CallChecker.varAssign(error, "error", 688, 25971, 25985);
                                            }
                                            error = FastMath.sqrt((error / (mainSetDimension)));
                                            CallChecker.varAssign(error, "error", 690, 26013, 26060);
                                            if ((error > 1.0E15) || ((k > 1) && (error > maxError))) {
                                                hNew = FastMath.abs(filterStep(((stepSize) * (stabilityReduction)), forward, false));
                                                CallChecker.varAssign(hNew, "hNew", 694, 26209, 26289);
                                                reject = true;
                                                CallChecker.varAssign(reject, "reject", 695, 26305, 26318);
                                                loop = false;
                                                CallChecker.varAssign(loop, "loop", 696, 26334, 26348);
                                            }else {
                                                maxError = FastMath.max((4 * error), 1.0);
                                                CallChecker.varAssign(maxError, "maxError", 699, 26386, 26425);
                                                final double exp = CallChecker.varInit(((double) (1.0 / ((2 * k) + 1))), "exp", 702, 26442, 26535);
                                                double fac = CallChecker.varInit(((double) ((this.stepControl2) / (FastMath.pow((error / (this.stepControl1)), exp)))), "fac", 703, 26551, 26618);
                                                final double pow = CallChecker.varInit(((double) (FastMath.pow(this.stepControl3, exp))), "pow", 704, 26634, 26684);
                                                fac = FastMath.max((pow / (stepControl4)), FastMath.min((1 / pow), fac));
                                                CallChecker.varAssign(fac, "fac", 705, 26700, 26766);
                                                if (CallChecker.beforeDeref(optimalStep, double[].class, 706, 26782, 26792)) {
                                                    optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 706, 26782, 26792);
                                                    CallChecker.isCalled(optimalStep, double[].class, 706, 26782, 26792)[k] = FastMath.abs(filterStep(((stepSize) * fac), forward, true));
                                                    CallChecker.varAssign(CallChecker.isCalled(this.optimalStep, double[].class, 706, 26782, 26792)[k], "CallChecker.isCalled(this.optimalStep, double[].class, 706, 26782, 26792)[k]", 706, 26782, 26858);
                                                }
                                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 707, 26874, 26888)) {
                                                    if (CallChecker.beforeDeref(costPerStep, int[].class, 707, 26895, 26905)) {
                                                        if (CallChecker.beforeDeref(optimalStep, double[].class, 707, 26912, 26922)) {
                                                            costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 707, 26874, 26888);
                                                            costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 707, 26895, 26905);
                                                            optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 707, 26912, 26922);
                                                            CallChecker.isCalled(costPerTimeUnit, double[].class, 707, 26874, 26888)[k] = (CallChecker.isCalled(costPerStep, int[].class, 707, 26895, 26905)[k]) / (CallChecker.isCalled(optimalStep, double[].class, 707, 26912, 26922)[k]);
                                                            CallChecker.varAssign(CallChecker.isCalled(this.costPerTimeUnit, double[].class, 707, 26874, 26888)[k], "CallChecker.isCalled(this.costPerTimeUnit, double[].class, 707, 26874, 26888)[k]", 707, 26874, 26926);
                                                        }
                                                    }
                                                }
                                                switch (k - targetIter) {
                                                    case -1 :
                                                        if ((targetIter > 1) && (!previousRejected)) {
                                                            if (error <= 1.0) {
                                                                loop = false;
                                                                CallChecker.varAssign(loop, "loop", 718, 27283, 27295);
                                                            }else {
                                                                sequence = CallChecker.beforeCalled(sequence, int[].class, 723, 27561, 27568);
                                                                sequence = CallChecker.beforeCalled(sequence, int[].class, 723, 27585, 27592);
                                                                sequence = CallChecker.beforeCalled(sequence, int[].class, 724, 27655, 27662);
                                                                sequence = CallChecker.beforeCalled(sequence, int[].class, 724, 27669, 27676);
                                                                final double ratio = CallChecker.varInit(((double) ((((double) (CallChecker.isCalled(this.sequence, int[].class, 723, 27561, 27568)[targetIter])) * (CallChecker.isCalled(this.sequence, int[].class, 723, 27585, 27592)[(targetIter + 1)])) / ((CallChecker.isCalled(this.sequence, int[].class, 724, 27655, 27662)[0]) * (CallChecker.isCalled(this.sequence, int[].class, 724, 27669, 27676)[0])))), "ratio", 723, 27344, 27681);
                                                                if (error > (ratio * ratio)) {
                                                                    reject = true;
                                                                    CallChecker.varAssign(reject, "reject", 728, 27898, 27911);
                                                                    loop = false;
                                                                    CallChecker.varAssign(loop, "loop", 729, 27935, 27949);
                                                                    targetIter = k;
                                                                    CallChecker.varAssign(targetIter, "targetIter", 730, 27973, 27987);
                                                                    if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 732, 28062, 28076)) {
                                                                        if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 733, 28137, 28151)) {
                                                                            costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 732, 28062, 28076);
                                                                            costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 733, 28137, 28151);
                                                                            if ((targetIter > 1) && ((CallChecker.isCalled(costPerTimeUnit, double[].class, 732, 28062, 28076)[(targetIter - 1)]) < ((orderControl1) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 733, 28137, 28151)[targetIter])))) {
                                                                                --targetIter;
                                                                            }
                                                                        }
                                                                    }
                                                                    if (CallChecker.beforeDeref(optimalStep, double[].class, 736, 28260, 28270)) {
                                                                        optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 736, 28260, 28270);
                                                                        hNew = CallChecker.isCalled(optimalStep, double[].class, 736, 28260, 28270)[targetIter];
                                                                        CallChecker.varAssign(hNew, "hNew", 736, 28253, 28283);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    case 0 :
                                                        if (error <= 1.0) {
                                                            loop = false;
                                                            CallChecker.varAssign(loop, "loop", 745, 28517, 28529);
                                                        }else {
                                                            sequence = CallChecker.beforeCalled(sequence, int[].class, 750, 28785, 28792);
                                                            sequence = CallChecker.beforeCalled(sequence, int[].class, 750, 28802, 28809);
                                                            final double ratio = CallChecker.varInit(((double) (((double) (CallChecker.isCalled(this.sequence, int[].class, 750, 28785, 28792)[(k + 1)])) / (CallChecker.isCalled(this.sequence, int[].class, 750, 28802, 28809)[0]))), "ratio", 750, 28574, 28813);
                                                            if (error > (ratio * ratio)) {
                                                                reject = true;
                                                                CallChecker.varAssign(reject, "reject", 754, 29005, 29018);
                                                                loop = false;
                                                                CallChecker.varAssign(loop, "loop", 755, 29040, 29052);
                                                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 757, 29123, 29137)) {
                                                                    if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 758, 29196, 29210)) {
                                                                        costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 757, 29123, 29137);
                                                                        costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 758, 29196, 29210);
                                                                        if ((targetIter > 1) && ((CallChecker.isCalled(costPerTimeUnit, double[].class, 757, 29123, 29137)[(targetIter - 1)]) < ((orderControl1) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 758, 29196, 29210)[targetIter])))) {
                                                                            --targetIter;
                                                                        }
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(optimalStep, double[].class, 761, 29313, 29323)) {
                                                                    optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 761, 29313, 29323);
                                                                    hNew = CallChecker.isCalled(optimalStep, double[].class, 761, 29313, 29323)[targetIter];
                                                                    CallChecker.varAssign(hNew, "hNew", 761, 29306, 29336);
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    case 1 :
                                                        if (error > 1.0) {
                                                            reject = true;
                                                            CallChecker.varAssign(reject, "reject", 768, 29476, 29489);
                                                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 770, 29556, 29570)) {
                                                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 771, 29627, 29641)) {
                                                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 770, 29556, 29570);
                                                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 771, 29627, 29641);
                                                                    if ((targetIter > 1) && ((CallChecker.isCalled(costPerTimeUnit, double[].class, 770, 29556, 29570)[(targetIter - 1)]) < ((orderControl1) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 771, 29627, 29641)[targetIter])))) {
                                                                        --targetIter;
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(optimalStep, double[].class, 774, 29738, 29748)) {
                                                                optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 774, 29738, 29748);
                                                                hNew = CallChecker.isCalled(optimalStep, double[].class, 774, 29738, 29748)[targetIter];
                                                                CallChecker.varAssign(hNew, "hNew", 774, 29731, 29761);
                                                            }
                                                        }
                                                        loop = false;
                                                        CallChecker.varAssign(loop, "loop", 776, 29797, 29809);
                                                        break;
                                                    default :
                                                        if ((firstTime || (isLastStep)) && (error <= 1.0)) {
                                                            loop = false;
                                                            CallChecker.varAssign(loop, "loop", 781, 29944, 29956);
                                                        }
                                                        break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (!reject) {
                    computeDerivatives(((stepStart) + (stepSize)), y1, yDot1);
                }
                double hInt = CallChecker.varInit(((double) (getMaxStep())), "hInt", 798, 30233, 30259);
                if (!reject) {
                    for (int j = 1; j <= k; ++j) {
                        if (CallChecker.beforeDeref(yMidDots, double[][].class, 803, 30418, 30425)) {
                            extrapolate(0, j, diagonal, CallChecker.isCalled(yMidDots, double[][].class, 803, 30418, 30425)[0]);
                        }
                    }
                    final int mu = CallChecker.varInit(((int) (((2 * k) - (this.mudif)) + 3)), "mu", 806, 30451, 30483);
                    for (int l = 0; l < mu; ++l) {
                        final int l2 = CallChecker.varInit(((int) (l / 2)), "l2", 811, 30536, 30608);
                        double factor = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(sequence, int[].class, 812, 30655, 30662)) {
                            sequence = CallChecker.beforeCalled(sequence, int[].class, 812, 30655, 30662);
                            factor = FastMath.pow((0.5 * (CallChecker.isCalled(sequence, int[].class, 812, 30655, 30662)[l2])), l);
                            CallChecker.varAssign(factor, "factor", 812, 30655, 30662);
                        }
                        int middleIndex = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(fk, double[][][].class, 813, 30701, 30702)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 813, 30701, 30702)[l2], double[][].class, 813, 30701, 30706)) {
                                CallChecker.isCalled(fk, double[][][].class, 813, 30701, 30702)[l2] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 813, 30701, 30702)[l2], double[][].class, 813, 30701, 30706);
                                middleIndex = (CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 813, 30701, 30702)[l2], double[][].class, 813, 30701, 30706).length) / 2;
                                CallChecker.varAssign(middleIndex, "middleIndex", 813, 30701, 30702);
                            }
                        }
                        for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 814, 30750, 30751).length); ++i) {
                            if (CallChecker.beforeDeref(yMidDots, double[][].class, 815, 30780, 30787)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)], double[].class, 815, 30780, 30792)) {
                                    if (CallChecker.beforeDeref(fk, double[][][].class, 815, 30808, 30809)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813)) {
                                            CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813)[(middleIndex + l)], double[].class, 815, 30808, 30830)) {
                                                CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)], double[].class, 815, 30780, 30792);
                                                CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813);
                                                CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813)[(middleIndex + l)] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813)[(middleIndex + l)], double[].class, 815, 30808, 30830);
                                                CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)], double[].class, 815, 30780, 30792)[i] = factor * (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 815, 30808, 30809)[l2], double[][].class, 815, 30808, 30813)[(middleIndex + l)], double[].class, 815, 30808, 30830)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)], double[].class, 815, 30780, 30792)[i], "CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 815, 30780, 30787)[(l + 1)], double[].class, 815, 30780, 30792)[i]", 815, 30780, 30834);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (int j = 1; j <= (k - l2); ++j) {
                            if (CallChecker.beforeDeref(sequence, int[].class, 818, 30934, 30941)) {
                                sequence = CallChecker.beforeCalled(sequence, int[].class, 818, 30934, 30941);
                                factor = FastMath.pow((0.5 * (CallChecker.isCalled(sequence, int[].class, 818, 30934, 30941)[(j + l2)])), l);
                                CallChecker.varAssign(factor, "factor", 818, 30906, 30954);
                            }
                            if (CallChecker.beforeDeref(fk, double[][][].class, 819, 30982, 30983)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 819, 30982, 30983)[(l2 + j)], double[][].class, 819, 30982, 30989)) {
                                    CallChecker.isCalled(fk, double[][][].class, 819, 30982, 30983)[(l2 + j)] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 819, 30982, 30983)[(l2 + j)], double[][].class, 819, 30982, 30989);
                                    middleIndex = (CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 819, 30982, 30983)[(l2 + j)], double[][].class, 819, 30982, 30989).length) / 2;
                                    CallChecker.varAssign(middleIndex, "middleIndex", 819, 30968, 31001);
                                }
                            }
                            for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 820, 31035, 31036).length); ++i) {
                                if (CallChecker.beforeDeref(diagonal, double[][].class, 821, 31067, 31074)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)], double[].class, 821, 31067, 31079)) {
                                        if (CallChecker.beforeDeref(fk, double[][][].class, 821, 31095, 31096)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102)) {
                                                CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102)[(middleIndex + l)], double[].class, 821, 31095, 31117)) {
                                                    CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)], double[].class, 821, 31067, 31079);
                                                    CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102);
                                                    CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102)[(middleIndex + l)] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102)[(middleIndex + l)], double[].class, 821, 31095, 31117);
                                                    CallChecker.isCalled(CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)], double[].class, 821, 31067, 31079)[i] = factor * (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 821, 31095, 31096)[(l2 + j)], double[][].class, 821, 31095, 31102)[(middleIndex + l)], double[].class, 821, 31095, 31117)[i]);
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)], double[].class, 821, 31067, 31079)[i], "CallChecker.isCalled(CallChecker.isCalled(diagonal, double[][].class, 821, 31067, 31074)[(j - 1)], double[].class, 821, 31067, 31079)[i]", 821, 31067, 31121);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(yMidDots, double[][].class, 823, 31178, 31185)) {
                                extrapolate(l2, j, diagonal, CallChecker.isCalled(yMidDots, double[][].class, 823, 31178, 31185)[(l + 1)]);
                            }
                        }
                        for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 825, 31236, 31237).length); ++i) {
                            if (CallChecker.beforeDeref(yMidDots, double[][].class, 826, 31266, 31273)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)], double[].class, 826, 31266, 31278)) {
                                    CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)] = CallChecker.beforeCalled(CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)], double[].class, 826, 31266, 31278);
                                    CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)], double[].class, 826, 31266, 31278)[i] *= stepSize;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)], double[].class, 826, 31266, 31278)[i], "CallChecker.isCalled(CallChecker.isCalled(yMidDots, double[][].class, 826, 31266, 31273)[(l + 1)], double[].class, 826, 31266, 31278)[i]", 826, 31266, 31294);
                                }
                            }
                        }
                        for (int j = (l + 1) / 2; j <= k; ++j) {
                            CallChecker.isCalled(fk, double[][][].class, 831, 31456, 31457)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 831, 31456, 31457)[j], double[][].class, 831, 31456, 31460);
                            for (int m = (CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 831, 31456, 31457)[j], double[][].class, 831, 31456, 31460).length) - 1; m >= (2 * (l + 1)); --m) {
                                for (int i = 0; i < (CallChecker.isCalled(y0, double[].class, 832, 31533, 31534).length); ++i) {
                                    if (CallChecker.beforeDeref(fk, double[][][].class, 833, 31567, 31568)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)) {
                                            CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m], double[].class, 833, 31567, 31574)) {
                                                if (CallChecker.beforeDeref(fk, double[][][].class, 833, 31582, 31583)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586)) {
                                                        CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586)[(m - 2)], double[].class, 833, 31582, 31591)) {
                                                            CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571);
                                                            CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m], double[].class, 833, 31567, 31574);
                                                            CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j] = CallChecker.beforeCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586);
                                                            CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586)[(m - 2)] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586)[(m - 2)], double[].class, 833, 31582, 31591);
                                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m], double[].class, 833, 31567, 31574)[i] -= CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31582, 31583)[j], double[][].class, 833, 31582, 31586)[(m - 2)], double[].class, 833, 31582, 31591)[i];
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m], double[].class, 833, 31567, 31574)[i], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(fk, double[][][].class, 833, 31567, 31568)[j], double[][].class, 833, 31567, 31571)[m], double[].class, 833, 31567, 31574)[i]", 833, 31567, 31595);
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
                    if (mu >= 0) {
                        final GraggBulirschStoerStepInterpolator gbsInterpolator = CallChecker.varInit(((GraggBulirschStoerStepInterpolator) (interpolator)), "gbsInterpolator", 843, 31685, 31857);
                        if (CallChecker.beforeDeref(gbsInterpolator, GraggBulirschStoerStepInterpolator.class, 845, 31869, 31883)) {
                            CallChecker.isCalled(gbsInterpolator, GraggBulirschStoerStepInterpolator.class, 845, 31869, 31883).computeCoefficients(mu, stepSize);
                        }
                        if (useInterpolationError) {
                            final double interpError = CallChecker.varInit(((double) (CallChecker.isCalled(gbsInterpolator, GraggBulirschStoerStepInterpolator.class, 849, 32060, 32074).estimateError(scale))), "interpError", 849, 31972, 32096);
                            hInt = FastMath.abs(((stepSize) / (FastMath.max(FastMath.pow(interpError, (1.0 / (mu + 4))), 0.01))));
                            CallChecker.varAssign(hInt, "hInt", 850, 32110, 32249);
                            if (interpError > 10.0) {
                                hNew = hInt;
                                CallChecker.varAssign(hNew, "hNew", 853, 32303, 32314);
                                reject = true;
                                CallChecker.varAssign(reject, "reject", 854, 32330, 32343);
                            }
                        }
                    }
                }
                if (!reject) {
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 865, 32459, 32470)) {
                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 865, 32459, 32470).storeTime(((stepStart) + (stepSize)));
                    }
                    stepStart = acceptStep(interpolator, y1, yDot1, t);
                    CallChecker.varAssign(this.stepStart, "this.stepStart", 866, 32513, 32563);
                    if (CallChecker.beforeDeref(interpolator, AbstractStepInterpolator.class, 869, 32603, 32614)) {
                        CallChecker.isCalled(interpolator, AbstractStepInterpolator.class, 869, 32603, 32614).storeTime(stepStart);
                    }
                    if (CallChecker.beforeDeref(y0, double[].class, 870, 32676, 32677)) {
                        System.arraycopy(y1, 0, y, 0, CallChecker.isCalled(y0, double[].class, 870, 32676, 32677).length);
                    }
                    if (CallChecker.beforeDeref(y0, double[].class, 871, 32733, 32734)) {
                        System.arraycopy(yDot1, 0, yDot0, 0, CallChecker.isCalled(y0, double[].class, 871, 32733, 32734).length);
                    }
                    firstStepAlreadyComputed = true;
                    CallChecker.varAssign(firstStepAlreadyComputed, "firstStepAlreadyComputed", 872, 32753, 32784);
                    int optimalIter = CallChecker.init(int.class);
                    if (k == 1) {
                        optimalIter = 2;
                        CallChecker.varAssign(optimalIter, "optimalIter", 876, 32844, 32859);
                        if (previousRejected) {
                            optimalIter = 1;
                            CallChecker.varAssign(optimalIter, "optimalIter", 878, 32907, 32922);
                        }
                    }else
                        if (k <= targetIter) {
                            optimalIter = k;
                            CallChecker.varAssign(optimalIter, "optimalIter", 881, 32984, 32999);
                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 882, 33015, 33029)) {
                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 882, 33054, 33068)) {
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 882, 33015, 33029);
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 882, 33054, 33068);
                                    if ((CallChecker.isCalled(costPerTimeUnit, double[].class, 882, 33015, 33029)[(k - 1)]) < ((orderControl1) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 882, 33054, 33068)[k]))) {
                                        optimalIter = k - 1;
                                        CallChecker.varAssign(optimalIter, "optimalIter", 883, 33088, 33105);
                                    }else
                                        if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 884, 33128, 33142)) {
                                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 884, 33165, 33179)) {
                                                costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 884, 33128, 33142);
                                                costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 884, 33165, 33179);
                                                if ((CallChecker.isCalled(costPerTimeUnit, double[].class, 884, 33128, 33142)[k]) < ((orderControl2) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 884, 33165, 33179)[(k - 1)]))) {
                                                    if (CallChecker.beforeDeref(sequence, int[].class, 885, 33233, 33240)) {
                                                        sequence = CallChecker.beforeCalled(sequence, int[].class, 885, 33233, 33240);
                                                        optimalIter = FastMath.min((k + 1), ((CallChecker.isCalled(sequence, int[].class, 885, 33233, 33240).length) - 2));
                                                        CallChecker.varAssign(optimalIter, "optimalIter", 885, 33201, 33253);
                                                    }
                                                }
                                            }
                                        }
                                    
                                }
                            }
                        }else {
                            optimalIter = k - 1;
                            CallChecker.varAssign(optimalIter, "optimalIter", 888, 33294, 33313);
                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 890, 33355, 33369)) {
                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 890, 33394, 33408)) {
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 890, 33355, 33369);
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 890, 33394, 33408);
                                    if ((k > 2) && ((CallChecker.isCalled(costPerTimeUnit, double[].class, 890, 33355, 33369)[(k - 2)]) < ((orderControl1) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 890, 33394, 33408)[(k - 1)])))) {
                                        optimalIter = k - 2;
                                        CallChecker.varAssign(optimalIter, "optimalIter", 891, 33431, 33450);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 893, 33478, 33492)) {
                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 893, 33515, 33529)) {
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 893, 33478, 33492);
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 893, 33515, 33529);
                                    if ((CallChecker.isCalled(costPerTimeUnit, double[].class, 893, 33478, 33492)[k]) < ((orderControl2) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 893, 33515, 33529)[optimalIter]))) {
                                        if (CallChecker.beforeDeref(sequence, int[].class, 894, 33589, 33596)) {
                                            sequence = CallChecker.beforeCalled(sequence, int[].class, 894, 33589, 33596);
                                            optimalIter = FastMath.min(k, ((CallChecker.isCalled(sequence, int[].class, 894, 33589, 33596).length) - 2));
                                            CallChecker.varAssign(optimalIter, "optimalIter", 894, 33559, 33609);
                                        }
                                    }
                                }
                            }
                        }
                    
                    if (previousRejected) {
                        targetIter = FastMath.min(optimalIter, k);
                        CallChecker.varAssign(targetIter, "targetIter", 901, 33767, 33808);
                        if (CallChecker.beforeDeref(optimalStep, double[].class, 902, 33864, 33874)) {
                            optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 902, 33864, 33874);
                            hNew = FastMath.min(FastMath.abs(stepSize), CallChecker.isCalled(optimalStep, double[].class, 902, 33864, 33874)[targetIter]);
                            CallChecker.varAssign(hNew, "hNew", 902, 33820, 33888);
                        }
                    }else {
                        if (optimalIter <= k) {
                            if (CallChecker.beforeDeref(optimalStep, double[].class, 906, 33990, 34000)) {
                                optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 906, 33990, 34000);
                                hNew = CallChecker.isCalled(optimalStep, double[].class, 906, 33990, 34000)[optimalIter];
                                CallChecker.varAssign(hNew, "hNew", 906, 33983, 34014);
                            }
                        }else {
                            if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 909, 34088, 34102)) {
                                if (CallChecker.beforeDeref(costPerTimeUnit, double[].class, 909, 34125, 34139)) {
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 909, 34088, 34102);
                                    costPerTimeUnit = CallChecker.beforeCalled(costPerTimeUnit, double[].class, 909, 34125, 34139);
                                    if ((k < targetIter) && ((CallChecker.isCalled(costPerTimeUnit, double[].class, 909, 34088, 34102)[k]) < ((orderControl2) * (CallChecker.isCalled(costPerTimeUnit, double[].class, 909, 34125, 34139)[(k - 1)])))) {
                                        if (CallChecker.beforeDeref(optimalStep, double[].class, 910, 34182, 34192)) {
                                            if (CallChecker.beforeDeref(costPerStep, int[].class, 910, 34199, 34209)) {
                                                if (CallChecker.beforeDeref(costPerStep, int[].class, 910, 34228, 34238)) {
                                                    optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 910, 34182, 34192);
                                                    costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 910, 34199, 34209);
                                                    costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 910, 34228, 34238);
                                                    hNew = filterStep((((CallChecker.isCalled(optimalStep, double[].class, 910, 34182, 34192)[k]) * (CallChecker.isCalled(costPerStep, int[].class, 910, 34199, 34209)[(optimalIter + 1)])) / (CallChecker.isCalled(costPerStep, int[].class, 910, 34228, 34238)[k])), forward, false);
                                                    CallChecker.varAssign(hNew, "hNew", 910, 34164, 34290);
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(optimalStep, double[].class, 913, 34345, 34355)) {
                                            if (CallChecker.beforeDeref(costPerStep, int[].class, 913, 34362, 34372)) {
                                                if (CallChecker.beforeDeref(costPerStep, int[].class, 913, 34389, 34399)) {
                                                    optimalStep = CallChecker.beforeCalled(optimalStep, double[].class, 913, 34345, 34355);
                                                    costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 913, 34362, 34372);
                                                    costPerStep = CallChecker.beforeCalled(costPerStep, int[].class, 913, 34389, 34399);
                                                    hNew = filterStep((((CallChecker.isCalled(optimalStep, double[].class, 913, 34345, 34355)[k]) * (CallChecker.isCalled(costPerStep, int[].class, 913, 34362, 34372)[optimalIter])) / (CallChecker.isCalled(costPerStep, int[].class, 913, 34389, 34399)[k])), forward, false);
                                                    CallChecker.varAssign(hNew, "hNew", 913, 34327, 34452);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        targetIter = optimalIter;
                        CallChecker.varAssign(targetIter, "targetIter", 918, 34491, 34515);
                    }
                    newStep = true;
                    CallChecker.varAssign(newStep, "newStep", 922, 34537, 34551);
                }
                hNew = FastMath.min(hNew, hInt);
                CallChecker.varAssign(hNew, "hNew", 926, 34569, 34600);
                if (!forward) {
                    hNew = -hNew;
                    CallChecker.varAssign(hNew, "hNew", 928, 34633, 34645);
                }
                firstTime = false;
                CallChecker.varAssign(firstTime, "firstTime", 931, 34662, 34679);
                if (reject) {
                    isLastStep = false;
                    CallChecker.varAssign(this.isLastStep, "this.isLastStep", 934, 34710, 34728);
                    previousRejected = true;
                    CallChecker.varAssign(previousRejected, "previousRejected", 935, 34738, 34761);
                }else {
                    previousRejected = false;
                    CallChecker.varAssign(previousRejected, "previousRejected", 937, 34786, 34810);
                }
            } while (!(isLastStep) );
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 943, 34877, 34885)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 943, 34877, 34885).setTime(stepStart);
            }
            if (CallChecker.beforeDeref(equations, ExpandableStatefulODE.class, 944, 34911, 34919)) {
                CallChecker.isCalled(equations, ExpandableStatefulODE.class, 944, 34911, 34919).setCompleteState(y);
            }
            resetInternalState();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3382.methodEnd();
        }
    }
}

