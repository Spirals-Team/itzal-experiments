package org.apache.commons.math3.analysis.differentiation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateMatrixFunction;
import org.apache.commons.math3.analysis.UnivariateVectorFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

public class FiniteDifferencesDifferentiator implements Serializable , UnivariateFunctionDifferentiator , UnivariateMatrixFunctionDifferentiator , UnivariateVectorFunctionDifferentiator {
    private static final long serialVersionUID = 20120917L;

    private final int nbPoints;

    private final double stepSize;

    private final double halfSampleSpan;

    private final double tMin;

    private final double tMax;

    public FiniteDifferencesDifferentiator(final int nbPoints, final double stepSize) throws NotPositiveException, NumberIsTooSmallException {
        this(nbPoints, stepSize, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        ConstructorContext _bcornu_methode_context719 = new ConstructorContext(FiniteDifferencesDifferentiator.class, 107, 4096, 5048);
        try {
        } finally {
            _bcornu_methode_context719.methodEnd();
        }
    }

    public FiniteDifferencesDifferentiator(final int nbPoints, final double stepSize, final double tLower, final double tUpper) throws NotPositiveException, NumberIsTooLargeException, NumberIsTooSmallException {
        ConstructorContext _bcornu_methode_context720 = new ConstructorContext(FiniteDifferencesDifferentiator.class, 141, 5055, 7630);
        try {
            if (nbPoints <= 1) {
                throw new NumberIsTooSmallException(stepSize, 1, false);
            }
            this.nbPoints = nbPoints;
            CallChecker.varAssign(this.nbPoints, "this.nbPoints", 148, 7088, 7112);
            if (stepSize <= 0) {
                throw new NotPositiveException(stepSize);
            }
            this.stepSize = stepSize;
            CallChecker.varAssign(this.stepSize, "this.stepSize", 153, 7216, 7240);
            halfSampleSpan = (0.5 * stepSize) * (nbPoints - 1);
            CallChecker.varAssign(this.halfSampleSpan, "this.halfSampleSpan", 155, 7251, 7299);
            if ((2 * (halfSampleSpan)) >= (tUpper - tLower)) {
                throw new NumberIsTooLargeException((2 * (halfSampleSpan)), (tUpper - tLower), false);
            }
            final double safety = CallChecker.varInit(((double) (FastMath.ulp(this.halfSampleSpan))), "safety", 159, 7465, 7515);
            this.tMin = (tLower + (halfSampleSpan)) + safety;
            CallChecker.varAssign(this.tMin, "this.tMin", 160, 7525, 7569);
            this.tMax = (tUpper - (halfSampleSpan)) - safety;
            CallChecker.varAssign(this.tMax, "this.tMax", 161, 7579, 7623);
        } finally {
            _bcornu_methode_context720.methodEnd();
        }
    }

    public int getNbPoints() {
        MethodContext _bcornu_methode_context3235 = new MethodContext(int.class, 169, 7637, 7788);
        try {
            CallChecker.varInit(this, "this", 169, 7637, 7788);
            CallChecker.varInit(this.tMax, "tMax", 169, 7637, 7788);
            CallChecker.varInit(this.tMin, "tMin", 169, 7637, 7788);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 169, 7637, 7788);
            CallChecker.varInit(this.stepSize, "stepSize", 169, 7637, 7788);
            CallChecker.varInit(this.nbPoints, "nbPoints", 169, 7637, 7788);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 169, 7637, 7788);
            return nbPoints;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3235.methodEnd();
        }
    }

    public double getStepSize() {
        MethodContext _bcornu_methode_context3236 = new MethodContext(double.class, 177, 7795, 7921);
        try {
            CallChecker.varInit(this, "this", 177, 7795, 7921);
            CallChecker.varInit(this.tMax, "tMax", 177, 7795, 7921);
            CallChecker.varInit(this.tMin, "tMin", 177, 7795, 7921);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 177, 7795, 7921);
            CallChecker.varInit(this.stepSize, "stepSize", 177, 7795, 7921);
            CallChecker.varInit(this.nbPoints, "nbPoints", 177, 7795, 7921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 177, 7795, 7921);
            return stepSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3236.methodEnd();
        }
    }

    private DerivativeStructure evaluate(final DerivativeStructure t, final double t0, final double[] y) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3237 = new MethodContext(DerivativeStructure.class, 193, 7928, 10277);
        try {
            CallChecker.varInit(this, "this", 193, 7928, 10277);
            CallChecker.varInit(y, "y", 193, 7928, 10277);
            CallChecker.varInit(t0, "t0", 193, 7928, 10277);
            CallChecker.varInit(t, "t", 193, 7928, 10277);
            CallChecker.varInit(this.tMax, "tMax", 193, 7928, 10277);
            CallChecker.varInit(this.tMin, "tMin", 193, 7928, 10277);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 193, 7928, 10277);
            CallChecker.varInit(this.stepSize, "stepSize", 193, 7928, 10277);
            CallChecker.varInit(this.nbPoints, "nbPoints", 193, 7928, 10277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 193, 7928, 10277);
            final double[] top = CallChecker.varInit(new double[nbPoints], "top", 198, 8677, 8721);
            final double[] bottom = CallChecker.varInit(new double[nbPoints], "bottom", 199, 8731, 8775);
            for (int i = 0; i < (nbPoints); ++i) {
                if (CallChecker.beforeDeref(bottom, double[].class, 204, 8911, 8916)) {
                    if (CallChecker.beforeDeref(y, double[].class, 204, 8923, 8923)) {
                        CallChecker.isCalled(bottom, double[].class, 204, 8911, 8916)[i] = CallChecker.isCalled(y, double[].class, 204, 8923, 8923)[i];
                        CallChecker.varAssign(CallChecker.isCalled(bottom, double[].class, 204, 8911, 8916)[i], "CallChecker.isCalled(bottom, double[].class, 204, 8911, 8916)[i]", 204, 8911, 8927);
                    }
                }
                for (int j = 1; j <= i; ++j) {
                    if (CallChecker.beforeDeref(bottom, double[].class, 206, 8988, 8993)) {
                        if (CallChecker.beforeDeref(bottom, double[].class, 206, 9005, 9010)) {
                            if (CallChecker.beforeDeref(bottom, double[].class, 206, 9025, 9030)) {
                                CallChecker.isCalled(bottom, double[].class, 206, 8988, 8993)[(i - j)] = ((CallChecker.isCalled(bottom, double[].class, 206, 9005, 9010)[((i - j) + 1)]) - (CallChecker.isCalled(bottom, double[].class, 206, 9025, 9030)[(i - j)])) / (j * (stepSize));
                                CallChecker.varAssign(CallChecker.isCalled(bottom, double[].class, 206, 8988, 8993)[(i - j)], "CallChecker.isCalled(bottom, double[].class, 206, 8988, 8993)[(i - j)]", 206, 8988, 9056);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(top, double[].class, 210, 9157, 9159)) {
                    if (CallChecker.beforeDeref(bottom, double[].class, 210, 9166, 9171)) {
                        CallChecker.isCalled(top, double[].class, 210, 9157, 9159)[i] = CallChecker.isCalled(bottom, double[].class, 210, 9166, 9171)[0];
                        CallChecker.varAssign(CallChecker.isCalled(top, double[].class, 210, 9157, 9159)[i], "CallChecker.isCalled(top, double[].class, 210, 9157, 9159)[i]", 210, 9157, 9175);
                    }
                }
            }
            final int order = CallChecker.varInit(((int) (CallChecker.isCalled(t, DerivativeStructure.class, 215, 9306, 9306).getOrder())), "order", 215, 9197, 9318);
            final int parameters = CallChecker.varInit(((int) (CallChecker.isCalled(t, DerivativeStructure.class, 216, 9357, 9357).getFreeParameters())), "parameters", 216, 9328, 9378);
            final double[] derivatives = CallChecker.varInit(CallChecker.isCalled(t, DerivativeStructure.class, 217, 9417, 9417).getAllDerivatives(), "derivatives", 217, 9388, 9438);
            final double dt0 = CallChecker.varInit(((double) ((CallChecker.isCalled(t, DerivativeStructure.class, 218, 9477, 9477).getValue()) - t0)), "dt0", 218, 9448, 9494);
            DerivativeStructure interpolation = CallChecker.varInit(new DerivativeStructure(parameters, order, 0.0), "interpolation", 219, 9504, 9587);
            DerivativeStructure monomial = CallChecker.varInit(null, "monomial", 220, 9597, 9632);
            for (int i = 0; i < (nbPoints); ++i) {
                if (i == 0) {
                    monomial = new DerivativeStructure(parameters, order, 1.0);
                    CallChecker.varAssign(monomial, "monomial", 224, 9767, 9825);
                }else {
                    if (CallChecker.beforeDeref(derivatives, double[].class, 227, 9938, 9948)) {
                        CallChecker.isCalled(derivatives, double[].class, 227, 9938, 9948)[0] = dt0 - ((i - 1) * (stepSize));
                        CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 227, 9938, 9948)[0], "CallChecker.isCalled(derivatives, double[].class, 227, 9938, 9948)[0]", 227, 9938, 9979);
                    }
                    final DerivativeStructure deltaX = CallChecker.varInit(new DerivativeStructure(parameters, order, derivatives), "deltaX", 228, 9997, 10087);
                    if (CallChecker.beforeDeref(monomial, DerivativeStructure.class, 229, 10116, 10123)) {
                        monomial = CallChecker.beforeCalled(monomial, DerivativeStructure.class, 229, 10116, 10123);
                        monomial = CallChecker.isCalled(monomial, DerivativeStructure.class, 229, 10116, 10123).multiply(deltaX);
                        CallChecker.varAssign(monomial, "monomial", 229, 10105, 10141);
                    }
                }
                if (CallChecker.beforeDeref(top, double[].class, 231, 10221, 10223)) {
                    if (CallChecker.beforeDeref(monomial, DerivativeStructure.class, 231, 10203, 10210)) {
                        if (CallChecker.beforeDeref(interpolation, DerivativeStructure.class, 231, 10185, 10197)) {
                            monomial = CallChecker.beforeCalled(monomial, DerivativeStructure.class, 231, 10203, 10210);
                            interpolation = CallChecker.beforeCalled(interpolation, DerivativeStructure.class, 231, 10185, 10197);
                            interpolation = CallChecker.isCalled(interpolation, DerivativeStructure.class, 231, 10185, 10197).add(CallChecker.isCalled(monomial, DerivativeStructure.class, 231, 10203, 10210).multiply(CallChecker.isCalled(top, double[].class, 231, 10221, 10223)[i]));
                            CallChecker.varAssign(interpolation, "interpolation", 231, 10169, 10229);
                        }
                    }
                }
            }
            return interpolation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3237.methodEnd();
        }
    }

    public UnivariateDifferentiableFunction differentiate(final UnivariateFunction function) {
        MethodContext _bcornu_methode_context3240 = new MethodContext(UnivariateDifferentiableFunction.class, 244, 10284, 11820);
        try {
            CallChecker.varInit(this, "this", 244, 10284, 11820);
            CallChecker.varInit(function, "function", 244, 10284, 11820);
            CallChecker.varInit(this.tMax, "tMax", 244, 10284, 11820);
            CallChecker.varInit(this.tMin, "tMin", 244, 10284, 11820);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 244, 10284, 11820);
            CallChecker.varInit(this.stepSize, "stepSize", 244, 10284, 11820);
            CallChecker.varInit(this.nbPoints, "nbPoints", 244, 10284, 11820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 244, 10284, 11820);
            return new UnivariateDifferentiableFunction() {
                public double value(final double x) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3238 = new MethodContext(double.class, 248, 10722, 10883);
                    try {
                        CallChecker.varInit(this, "this", 248, 10722, 10883);
                        CallChecker.varInit(x, "x", 248, 10722, 10883);
                        if (CallChecker.beforeDeref(function, UnivariateFunction.class, 249, 10852, 10859)) {
                            return CallChecker.isCalled(function, UnivariateFunction.class, 249, 10852, 10859).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3238.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure t) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3239 = new MethodContext(DerivativeStructure.class, 253, 10898, 11802);
                    try {
                        CallChecker.varInit(this, "this", 253, 10898, 11802);
                        CallChecker.varInit(t, "t", 253, 10898, 11802);
                        if ((CallChecker.isCalled(t, DerivativeStructure.class, 257, 11155, 11155).getOrder()) >= (nbPoints)) {
                            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 258, 11239, 11239)) {
                                throw new NumberIsTooLargeException(CallChecker.isCalled(t, DerivativeStructure.class, 258, 11239, 11239).getOrder(), nbPoints, false);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        final double t0 = CallChecker.varInit(((double) ((FastMath.max(FastMath.min(CallChecker.isCalled(t, DerivativeStructure.class, 262, 11428, 11428).getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin)) - (FiniteDifferencesDifferentiator.this.halfSampleSpan))), "t0", 262, 11306, 11471);
                        final double[] y = CallChecker.varInit(new double[nbPoints], "y", 265, 11531, 11570);
                        for (int i = 0; i < (nbPoints); ++i) {
                            if (CallChecker.beforeDeref(y, double[].class, 267, 11645, 11645)) {
                                if (CallChecker.beforeDeref(function, UnivariateFunction.class, 267, 11652, 11659)) {
                                    CallChecker.isCalled(y, double[].class, 267, 11645, 11645)[i] = CallChecker.isCalled(function, UnivariateFunction.class, 267, 11652, 11659).value((t0 + (i * (stepSize))));
                                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 267, 11645, 11645)[i], "CallChecker.isCalled(y, double[].class, 267, 11645, 11645)[i]", 267, 11645, 11685);
                                }
                            }
                        }
                        return evaluate(t, t0, y);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3239.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3240.methodEnd();
        }
    }

    public UnivariateDifferentiableVectorFunction differentiate(final UnivariateVectorFunction function) {
        MethodContext _bcornu_methode_context3243 = new MethodContext(UnivariateDifferentiableVectorFunction.class, 284, 11827, 13815);
        try {
            CallChecker.varInit(this, "this", 284, 11827, 13815);
            CallChecker.varInit(function, "function", 284, 11827, 13815);
            CallChecker.varInit(this.tMax, "tMax", 284, 11827, 13815);
            CallChecker.varInit(this.tMin, "tMin", 284, 11827, 13815);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 284, 11827, 13815);
            CallChecker.varInit(this.stepSize, "stepSize", 284, 11827, 13815);
            CallChecker.varInit(this.nbPoints, "nbPoints", 284, 11827, 13815);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 284, 11827, 13815);
            return new UnivariateDifferentiableVectorFunction() {
                public double[] value(final double x) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3241 = new MethodContext(double[].class, 288, 12283, 12445);
                    try {
                        CallChecker.varInit(this, "this", 288, 12283, 12445);
                        CallChecker.varInit(x, "x", 288, 12283, 12445);
                        if (CallChecker.beforeDeref(function, UnivariateVectorFunction.class, 289, 12414, 12421)) {
                            return CallChecker.isCalled(function, UnivariateVectorFunction.class, 289, 12414, 12421).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3241.methodEnd();
                    }
                }

                public DerivativeStructure[] value(final DerivativeStructure t) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3242 = new MethodContext(DerivativeStructure[].class, 293, 12460, 13797);
                    try {
                        CallChecker.varInit(this, "this", 293, 12460, 13797);
                        CallChecker.varInit(t, "t", 293, 12460, 13797);
                        if ((CallChecker.isCalled(t, DerivativeStructure.class, 297, 12719, 12719).getOrder()) >= (nbPoints)) {
                            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 298, 12803, 12803)) {
                                throw new NumberIsTooLargeException(CallChecker.isCalled(t, DerivativeStructure.class, 298, 12803, 12803).getOrder(), nbPoints, false);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        final double t0 = CallChecker.varInit(((double) ((FastMath.max(FastMath.min(CallChecker.isCalled(t, DerivativeStructure.class, 302, 12992, 12992).getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin)) - (FiniteDifferencesDifferentiator.this.halfSampleSpan))), "t0", 302, 12870, 13035);
                        double[][] y = CallChecker.varInit(null, "y", 305, 13095, 13114);
                        for (int i = 0; i < (nbPoints); ++i) {
                            final double[] v = CallChecker.varInit(CallChecker.isCalled(function, UnivariateVectorFunction.class, 307, 13208, 13215).value((t0 + (i * (stepSize)))), "v", 307, 13189, 13241);
                            if (i == 0) {
                                if (CallChecker.beforeDeref(v, double[].class, 309, 13316, 13316)) {
                                    y = new double[CallChecker.isCalled(v, double[].class, 309, 13316, 13316).length][nbPoints];
                                    CallChecker.varAssign(y, "y", 309, 13301, 13335);
                                }
                            }
                            for (int j = 0; j < (CallChecker.isCalled(v, double[].class, 311, 13399, 13399).length); ++j) {
                                if (CallChecker.beforeDeref(y, double[][].class, 312, 13440, 13440)) {
                                    y = CallChecker.beforeCalled(y, double[][].class, 312, 13440, 13440);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j], double[].class, 312, 13440, 13443)) {
                                        if (CallChecker.beforeDeref(v, double[].class, 312, 13450, 13450)) {
                                            y = CallChecker.beforeCalled(y, double[][].class, 312, 13440, 13440);
                                            CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j], double[].class, 312, 13440, 13443);
                                            CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j], double[].class, 312, 13440, 13443)[i] = CallChecker.isCalled(v, double[].class, 312, 13450, 13450)[j];
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j], double[].class, 312, 13440, 13443)[i], "CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 312, 13440, 13440)[j], double[].class, 312, 13440, 13443)[i]", 312, 13440, 13454);
                                        }
                                    }
                                }
                            }
                        }
                        y = CallChecker.beforeCalled(y, double[][].class, 317, 13613, 13613);
                        final DerivativeStructure[] value = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(y, double[][].class, 317, 13613, 13613).length], "value", 317, 13553, 13622);
                        for (int j = 0; j < (CallChecker.isCalled(value, DerivativeStructure[].class, 318, 13660, 13664).length); ++j) {
                            if (CallChecker.beforeDeref(value, DerivativeStructure[].class, 319, 13701, 13705)) {
                                if (CallChecker.beforeDeref(y, double[][].class, 319, 13728, 13728)) {
                                    y = CallChecker.beforeCalled(y, double[][].class, 319, 13728, 13728);
                                    CallChecker.isCalled(value, DerivativeStructure[].class, 319, 13701, 13705)[j] = evaluate(t, t0, CallChecker.isCalled(y, double[][].class, 319, 13728, 13728)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(value, DerivativeStructure[].class, 319, 13701, 13705)[j], "CallChecker.isCalled(value, DerivativeStructure[].class, 319, 13701, 13705)[j]", 319, 13701, 13733);
                                }
                            }
                        }
                        return value;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3242.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableVectorFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3243.methodEnd();
        }
    }

    public UnivariateDifferentiableMatrixFunction differentiate(final UnivariateMatrixFunction function) {
        MethodContext _bcornu_methode_context3246 = new MethodContext(UnivariateDifferentiableMatrixFunction.class, 335, 13822, 16041);
        try {
            CallChecker.varInit(this, "this", 335, 13822, 16041);
            CallChecker.varInit(function, "function", 335, 13822, 16041);
            CallChecker.varInit(this.tMax, "tMax", 335, 13822, 16041);
            CallChecker.varInit(this.tMin, "tMin", 335, 13822, 16041);
            CallChecker.varInit(this.halfSampleSpan, "halfSampleSpan", 335, 13822, 16041);
            CallChecker.varInit(this.stepSize, "stepSize", 335, 13822, 16041);
            CallChecker.varInit(this.nbPoints, "nbPoints", 335, 13822, 16041);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.FiniteDifferencesDifferentiator.serialVersionUID", 335, 13822, 16041);
            return new UnivariateDifferentiableMatrixFunction() {
                public double[][] value(final double x) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3244 = new MethodContext(double[][].class, 339, 14278, 14444);
                    try {
                        CallChecker.varInit(this, "this", 339, 14278, 14444);
                        CallChecker.varInit(x, "x", 339, 14278, 14444);
                        if (CallChecker.beforeDeref(function, UnivariateMatrixFunction.class, 340, 14413, 14420)) {
                            return CallChecker.isCalled(function, UnivariateMatrixFunction.class, 340, 14413, 14420).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3244.methodEnd();
                    }
                }

                public DerivativeStructure[][] value(final DerivativeStructure t) throws MathIllegalArgumentException {
                    MethodContext _bcornu_methode_context3245 = new MethodContext(DerivativeStructure[][].class, 344, 14459, 16023);
                    try {
                        CallChecker.varInit(this, "this", 344, 14459, 16023);
                        CallChecker.varInit(t, "t", 344, 14459, 16023);
                        if ((CallChecker.isCalled(t, DerivativeStructure.class, 348, 14721, 14721).getOrder()) >= (nbPoints)) {
                            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 349, 14805, 14805)) {
                                throw new NumberIsTooLargeException(CallChecker.isCalled(t, DerivativeStructure.class, 349, 14805, 14805).getOrder(), nbPoints, false);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        final double t0 = CallChecker.varInit(((double) ((FastMath.max(FastMath.min(CallChecker.isCalled(t, DerivativeStructure.class, 353, 14994, 14994).getValue(), FiniteDifferencesDifferentiator.this.tMax), FiniteDifferencesDifferentiator.this.tMin)) - (FiniteDifferencesDifferentiator.this.halfSampleSpan))), "t0", 353, 14872, 15037);
                        double[][][] y = CallChecker.varInit(null, "y", 356, 15097, 15118);
                        for (int i = 0; i < (nbPoints); ++i) {
                            final double[][] v = CallChecker.varInit(CallChecker.isCalled(function, UnivariateMatrixFunction.class, 358, 15214, 15221).value((t0 + (i * (stepSize)))), "v", 358, 15193, 15247);
                            if (i == 0) {
                                if (CallChecker.beforeDeref(v, double[][].class, 360, 15322, 15322)) {
                                    if (CallChecker.beforeDeref(v, double[][].class, 360, 15332, 15332)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(v, double[][].class, 360, 15332, 15332)[0], double[].class, 360, 15332, 15335)) {
                                            CallChecker.isCalled(v, double[][].class, 360, 15332, 15332)[0] = CallChecker.beforeCalled(CallChecker.isCalled(v, double[][].class, 360, 15332, 15332)[0], double[].class, 360, 15332, 15335);
                                            y = new double[CallChecker.isCalled(v, double[][].class, 360, 15322, 15322).length][CallChecker.isCalled(CallChecker.isCalled(v, double[][].class, 360, 15332, 15332)[0], double[].class, 360, 15332, 15335).length][nbPoints];
                                            CallChecker.varAssign(y, "y", 360, 15307, 15354);
                                        }
                                    }
                                }
                            }
                            for (int j = 0; j < (CallChecker.isCalled(v, double[][].class, 362, 15418, 15418).length); ++j) {
                                CallChecker.isCalled(v, double[][].class, 363, 15479, 15479)[j] = CallChecker.beforeCalled(CallChecker.isCalled(v, double[][].class, 363, 15479, 15479)[j], double[].class, 363, 15479, 15482);
                                for (int k = 0; k < (CallChecker.isCalled(CallChecker.isCalled(v, double[][].class, 363, 15479, 15479)[j], double[].class, 363, 15479, 15482).length); ++k) {
                                    if (CallChecker.beforeDeref(y, double[][][].class, 364, 15527, 15527)) {
                                        y = CallChecker.beforeCalled(y, double[][][].class, 364, 15527, 15527);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)) {
                                            y = CallChecker.beforeCalled(y, double[][][].class, 364, 15527, 15527);
                                            CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k], double[].class, 364, 15527, 15533)) {
                                                if (CallChecker.beforeDeref(v, double[][].class, 364, 15540, 15540)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, double[][].class, 364, 15540, 15540)[j], double[].class, 364, 15540, 15543)) {
                                                        y = CallChecker.beforeCalled(y, double[][][].class, 364, 15527, 15527);
                                                        CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530);
                                                        CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k], double[].class, 364, 15527, 15533);
                                                        CallChecker.isCalled(v, double[][].class, 364, 15540, 15540)[j] = CallChecker.beforeCalled(CallChecker.isCalled(v, double[][].class, 364, 15540, 15540)[j], double[].class, 364, 15540, 15543);
                                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k], double[].class, 364, 15527, 15533)[i] = CallChecker.isCalled(CallChecker.isCalled(v, double[][].class, 364, 15540, 15540)[j], double[].class, 364, 15540, 15543)[k];
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k], double[].class, 364, 15527, 15533)[i], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 364, 15527, 15527)[j], double[][].class, 364, 15527, 15530)[k], double[].class, 364, 15527, 15533)[i]", 364, 15527, 15547);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        y = CallChecker.beforeCalled(y, double[][][].class, 370, 15734, 15734);
                        y = CallChecker.beforeCalled(y, double[][][].class, 370, 15744, 15744);
                        CallChecker.isCalled(y, double[][][].class, 370, 15744, 15744)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][][].class, 370, 15744, 15744)[0], double[][].class, 370, 15744, 15747);
                        final DerivativeStructure[][] value = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(y, double[][][].class, 370, 15734, 15734).length][CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 370, 15744, 15744)[0], double[][].class, 370, 15744, 15747).length], "value", 370, 15672, 15756);
                        for (int j = 0; j < (CallChecker.isCalled(value, DerivativeStructure[][].class, 371, 15794, 15798).length); ++j) {
                            y = CallChecker.beforeCalled(y, double[][][].class, 372, 15855, 15855);
                            CallChecker.isCalled(y, double[][][].class, 372, 15855, 15855)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][][].class, 372, 15855, 15855)[j], double[][].class, 372, 15855, 15858);
                            for (int k = 0; k < (CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 372, 15855, 15855)[j], double[][].class, 372, 15855, 15858).length); ++k) {
                                if (CallChecker.beforeDeref(value, DerivativeStructure[][].class, 373, 15899, 15903)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j], DerivativeStructure[].class, 373, 15899, 15906)) {
                                        if (CallChecker.beforeDeref(y, double[][][].class, 373, 15929, 15929)) {
                                            y = CallChecker.beforeCalled(y, double[][][].class, 373, 15929, 15929);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(y, double[][][].class, 373, 15929, 15929)[j], double[][].class, 373, 15929, 15932)) {
                                                CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j] = CallChecker.beforeCalled(CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j], DerivativeStructure[].class, 373, 15899, 15906);
                                                y = CallChecker.beforeCalled(y, double[][][].class, 373, 15929, 15929);
                                                CallChecker.isCalled(y, double[][][].class, 373, 15929, 15929)[j] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][][].class, 373, 15929, 15929)[j], double[][].class, 373, 15929, 15932);
                                                CallChecker.isCalled(CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j], DerivativeStructure[].class, 373, 15899, 15906)[k] = evaluate(t, t0, CallChecker.isCalled(CallChecker.isCalled(y, double[][][].class, 373, 15929, 15929)[j], double[][].class, 373, 15929, 15932)[k]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j], DerivativeStructure[].class, 373, 15899, 15906)[k], "CallChecker.isCalled(CallChecker.isCalled(value, DerivativeStructure[][].class, 373, 15899, 15903)[j], DerivativeStructure[].class, 373, 15899, 15906)[k]", 373, 15899, 15937);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return value;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure[][]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3245.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableMatrixFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3246.methodEnd();
        }
    }
}

