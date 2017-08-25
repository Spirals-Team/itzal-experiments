package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.MultistepIntegrator;

public abstract class AdamsIntegrator extends MultistepIntegrator {
    private final AdamsNordsieckTransformer transformer;

    public AdamsIntegrator(final String name, final int nSteps, final int order, final double minStep, final double maxStep, final double scalAbsoluteTolerance, final double scalRelativeTolerance) throws NumberIsTooSmallException {
        super(name, nSteps, order, minStep, maxStep, scalAbsoluteTolerance, scalRelativeTolerance);
        ConstructorContext _bcornu_methode_context1197 = new ConstructorContext(AdamsIntegrator.class, 54, 1627, 2912);
        try {
            transformer = AdamsNordsieckTransformer.getInstance(nSteps);
            CallChecker.varAssign(this.transformer, "this.transformer", 61, 2847, 2906);
        } finally {
            _bcornu_methode_context1197.methodEnd();
        }
    }

    public AdamsIntegrator(final String name, final int nSteps, final int order, final double minStep, final double maxStep, final double[] vecAbsoluteTolerance, final double[] vecRelativeTolerance) throws IllegalArgumentException {
        super(name, nSteps, order, minStep, maxStep, vecAbsoluteTolerance, vecRelativeTolerance);
        ConstructorContext _bcornu_methode_context1198 = new ConstructorContext(AdamsIntegrator.class, 79, 2919, 4200);
        try {
            transformer = AdamsNordsieckTransformer.getInstance(nSteps);
            CallChecker.varAssign(this.transformer, "this.transformer", 86, 4135, 4194);
        } finally {
            _bcornu_methode_context1198.methodEnd();
        }
    }

    @Override
    public abstract void integrate(final ExpandableStatefulODE equations, final double t) throws DimensionMismatchException, MaxCountExceededException, NoBracketingException, NumberIsTooSmallException;

    @Override
    protected Array2DRowRealMatrix initializeHighOrderDerivatives(final double h, final double[] t, final double[][] y, final double[][] yDot) {
        MethodContext _bcornu_methode_context5379 = new MethodContext(Array2DRowRealMatrix.class, 97, 4472, 4862);
        try {
            CallChecker.varInit(this, "this", 97, 4472, 4862);
            CallChecker.varInit(yDot, "yDot", 97, 4472, 4862);
            CallChecker.varInit(y, "y", 97, 4472, 4862);
            CallChecker.varInit(t, "t", 97, 4472, 4862);
            CallChecker.varInit(h, "h", 97, 4472, 4862);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 97, 4472, 4862);
            CallChecker.varInit(this.isLastStep, "isLastStep", 97, 4472, 4862);
            CallChecker.varInit(this.stepSize, "stepSize", 97, 4472, 4862);
            CallChecker.varInit(this.stepStart, "stepStart", 97, 4472, 4862);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 97, 4472, 4862);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 97, 4472, 4862);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 97, 4472, 4862);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 97, 4472, 4862);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 97, 4472, 4862);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 97, 4472, 4862);
            CallChecker.varInit(this.nordsieck, "nordsieck", 97, 4472, 4862);
            CallChecker.varInit(this.scaled, "scaled", 97, 4472, 4862);
            CallChecker.varInit(this.transformer, "transformer", 97, 4472, 4862);
            if (CallChecker.beforeDeref(transformer, AdamsNordsieckTransformer.class, 100, 4799, 4809)) {
                return CallChecker.isCalled(transformer, AdamsNordsieckTransformer.class, 100, 4799, 4809).initializeHighOrderDerivatives(h, t, y, yDot);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5379.methodEnd();
        }
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(final Array2DRowRealMatrix highOrder) {
        MethodContext _bcornu_methode_context5380 = new MethodContext(Array2DRowRealMatrix.class, 114, 4869, 5678);
        try {
            CallChecker.varInit(this, "this", 114, 4869, 5678);
            CallChecker.varInit(highOrder, "highOrder", 114, 4869, 5678);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 114, 4869, 5678);
            CallChecker.varInit(this.isLastStep, "isLastStep", 114, 4869, 5678);
            CallChecker.varInit(this.stepSize, "stepSize", 114, 4869, 5678);
            CallChecker.varInit(this.stepStart, "stepStart", 114, 4869, 5678);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 114, 4869, 5678);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 114, 4869, 5678);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 114, 4869, 5678);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 114, 4869, 5678);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 114, 4869, 5678);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 114, 4869, 5678);
            CallChecker.varInit(this.nordsieck, "nordsieck", 114, 4869, 5678);
            CallChecker.varInit(this.scaled, "scaled", 114, 4869, 5678);
            CallChecker.varInit(this.transformer, "transformer", 114, 4869, 5678);
            if (CallChecker.beforeDeref(transformer, AdamsNordsieckTransformer.class, 115, 5617, 5627)) {
                return CallChecker.isCalled(transformer, AdamsNordsieckTransformer.class, 115, 5617, 5627).updateHighOrderDerivativesPhase1(highOrder);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5380.methodEnd();
        }
    }

    public void updateHighOrderDerivativesPhase2(final double[] start, final double[] end, final Array2DRowRealMatrix highOrder) {
        MethodContext _bcornu_methode_context5381 = new MethodContext(void.class, 131, 5685, 6791);
        try {
            CallChecker.varInit(this, "this", 131, 5685, 6791);
            CallChecker.varInit(highOrder, "highOrder", 131, 5685, 6791);
            CallChecker.varInit(end, "end", 131, 5685, 6791);
            CallChecker.varInit(start, "start", 131, 5685, 6791);
            CallChecker.varInit(this.resetOccurred, "resetOccurred", 131, 5685, 6791);
            CallChecker.varInit(this.isLastStep, "isLastStep", 131, 5685, 6791);
            CallChecker.varInit(this.stepSize, "stepSize", 131, 5685, 6791);
            CallChecker.varInit(this.stepStart, "stepStart", 131, 5685, 6791);
            CallChecker.varInit(this.stepHandlers, "stepHandlers", 131, 5685, 6791);
            CallChecker.varInit(this.mainSetDimension, "mainSetDimension", 131, 5685, 6791);
            CallChecker.varInit(this.vecRelativeTolerance, "vecRelativeTolerance", 131, 5685, 6791);
            CallChecker.varInit(this.vecAbsoluteTolerance, "vecAbsoluteTolerance", 131, 5685, 6791);
            CallChecker.varInit(this.scalRelativeTolerance, "scalRelativeTolerance", 131, 5685, 6791);
            CallChecker.varInit(this.scalAbsoluteTolerance, "scalAbsoluteTolerance", 131, 5685, 6791);
            CallChecker.varInit(this.nordsieck, "nordsieck", 131, 5685, 6791);
            CallChecker.varInit(this.scaled, "scaled", 131, 5685, 6791);
            CallChecker.varInit(this.transformer, "transformer", 131, 5685, 6791);
            if (CallChecker.beforeDeref(transformer, AdamsNordsieckTransformer.class, 134, 6718, 6728)) {
                CallChecker.isCalled(transformer, AdamsNordsieckTransformer.class, 134, 6718, 6728).updateHighOrderDerivativesPhase2(start, end, highOrder);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5381.methodEnd();
        }
    }
}

