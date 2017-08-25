package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;

public class BOBYQAOptimizer extends MultivariateOptimizer {
    private static class PathIsExploredException extends RuntimeException {
        private static final long serialVersionUID = 745350979634801853L;

        private static final String PATH_IS_EXPLORED = "If this exception is thrown, just remove it from the code";

        PathIsExploredException() {
            super((((BOBYQAOptimizer.PathIsExploredException.PATH_IS_EXPLORED) + " ") + (BOBYQAOptimizer.caller(3))));
            ConstructorContext _bcornu_methode_context1015 = new ConstructorContext(BOBYQAOptimizer.PathIsExploredException.class, 2455, 113086, 113193);
            try {
            } finally {
                _bcornu_methode_context1015.methodEnd();
            }
        }
    }

    public static final int MINIMUM_PROBLEM_DIMENSION = 2;

    public static final double DEFAULT_INITIAL_RADIUS = 10.0;

    public static final double DEFAULT_STOPPING_RADIUS = 1.0E-8;

    private static final double ZERO = 0.0;

    private static final double ONE = 1.0;

    private static final double TWO = 2.0;

    private static final double TEN = 10.0;

    private static final double SIXTEEN = 16.0;

    private static final double TWO_HUNDRED_FIFTY = 250.0;

    private static final double MINUS_ONE = -(BOBYQAOptimizer.ONE);

    private static final double HALF = (BOBYQAOptimizer.ONE) / 2;

    private static final double ONE_OVER_FOUR = (BOBYQAOptimizer.ONE) / 4;

    private static final double ONE_OVER_EIGHT = (BOBYQAOptimizer.ONE) / 8;

    private static final double ONE_OVER_TEN = (BOBYQAOptimizer.ONE) / 10;

    private static final double ONE_OVER_A_THOUSAND = (BOBYQAOptimizer.ONE) / 1000;

    private final int numberOfInterpolationPoints;

    private double initialTrustRegionRadius;

    private final double stoppingTrustRegionRadius;

    private boolean isMinimize;

    private ArrayRealVector currentBest;

    private double[] boundDifference;

    private int trustRegionCenterInterpolationPointIndex;

    private Array2DRowRealMatrix bMatrix;

    private Array2DRowRealMatrix zMatrix;

    private Array2DRowRealMatrix interpolationPoints;

    private ArrayRealVector originShift;

    private ArrayRealVector fAtInterpolationPoints;

    private ArrayRealVector trustRegionCenterOffset;

    private ArrayRealVector gradientAtTrustRegionCenter;

    private ArrayRealVector lowerDifference;

    private ArrayRealVector upperDifference;

    private ArrayRealVector modelSecondDerivativesParameters;

    private ArrayRealVector newPoint;

    private ArrayRealVector alternativeNewPoint;

    private ArrayRealVector trialStepPoint;

    private ArrayRealVector lagrangeValuesAtNewPoint;

    private ArrayRealVector modelSecondDerivativesValues;

    public BOBYQAOptimizer(int numberOfInterpolationPoints) {
        this(numberOfInterpolationPoints, BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS, BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS);
        ConstructorContext _bcornu_methode_context1016 = new ConstructorContext(BOBYQAOptimizer.class, 206, 8434, 8884);
        try {
        } finally {
            _bcornu_methode_context1016.methodEnd();
        }
    }

    public BOBYQAOptimizer(int numberOfInterpolationPoints, double initialTrustRegionRadius, double stoppingTrustRegionRadius) {
        super(null);
        ConstructorContext _bcornu_methode_context1017 = new ConstructorContext(BOBYQAOptimizer.class, 220, 8891, 9745);
        try {
            this.numberOfInterpolationPoints = numberOfInterpolationPoints;
            CallChecker.varAssign(this.numberOfInterpolationPoints, "this.numberOfInterpolationPoints", 224, 9543, 9605);
            this.initialTrustRegionRadius = initialTrustRegionRadius;
            CallChecker.varAssign(this.initialTrustRegionRadius, "this.initialTrustRegionRadius", 225, 9615, 9671);
            this.stoppingTrustRegionRadius = stoppingTrustRegionRadius;
            CallChecker.varAssign(this.stoppingTrustRegionRadius, "this.stoppingTrustRegionRadius", 226, 9681, 9739);
        } finally {
            _bcornu_methode_context1017.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context4543 = new MethodContext(PointValuePair.class, 231, 9752, 10316);
        try {
            CallChecker.varInit(this, "this", 231, 9752, 10316);
            CallChecker.varInit(this.iterations, "iterations", 231, 9752, 10316);
            CallChecker.varInit(this.evaluations, "evaluations", 231, 9752, 10316);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 231, 9752, 10316);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 231, 9752, 10316);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 231, 9752, 10316);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 231, 9752, 10316);
            CallChecker.varInit(this.newPoint, "newPoint", 231, 9752, 10316);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 231, 9752, 10316);
            CallChecker.varInit(this.upperDifference, "upperDifference", 231, 9752, 10316);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 231, 9752, 10316);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 231, 9752, 10316);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 231, 9752, 10316);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 231, 9752, 10316);
            CallChecker.varInit(this.originShift, "originShift", 231, 9752, 10316);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 231, 9752, 10316);
            CallChecker.varInit(this.zMatrix, "zMatrix", 231, 9752, 10316);
            CallChecker.varInit(this.bMatrix, "bMatrix", 231, 9752, 10316);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 231, 9752, 10316);
            CallChecker.varInit(this.boundDifference, "boundDifference", 231, 9752, 10316);
            CallChecker.varInit(this.currentBest, "currentBest", 231, 9752, 10316);
            CallChecker.varInit(this.isMinimize, "isMinimize", 231, 9752, 10316);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 231, 9752, 10316);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 231, 9752, 10316);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 231, 9752, 10316);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 231, 9752, 10316);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 231, 9752, 10316);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 231, 9752, 10316);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 231, 9752, 10316);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 231, 9752, 10316);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 231, 9752, 10316);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 231, 9752, 10316);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 231, 9752, 10316);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 231, 9752, 10316);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 231, 9752, 10316);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 231, 9752, 10316);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 231, 9752, 10316);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 231, 9752, 10316);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 231, 9752, 10316);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 231, 9752, 10316);
            final double[] lowerBound = CallChecker.varInit(getLowerBound(), "lowerBound", 232, 9839, 9882);
            final double[] upperBound = CallChecker.varInit(getUpperBound(), "upperBound", 233, 9892, 9935);
            setup(lowerBound, upperBound);
            isMinimize = (getGoalType()) == (GoalType.MINIMIZE);
            CallChecker.varAssign(this.isMinimize, "this.isMinimize", 238, 10014, 10063);
            currentBest = new ArrayRealVector(getStartPoint());
            CallChecker.varAssign(this.currentBest, "this.currentBest", 239, 10073, 10123);
            final double value = CallChecker.varInit(((double) (bobyqa(lowerBound, upperBound))), "value", 241, 10134, 10185);
            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 243, 10222, 10232)) {
                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 243, 10222, 10232);
                return new PointValuePair(CallChecker.isCalled(currentBest, ArrayRealVector.class, 243, 10222, 10232).getDataRef(), (isMinimize ? value : -value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4543.methodEnd();
        }
    }

    private double bobyqa(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4544 = new MethodContext(double.class, 282, 10323, 15150);
        try {
            CallChecker.varInit(this, "this", 282, 10323, 15150);
            CallChecker.varInit(upperBound, "upperBound", 282, 10323, 15150);
            CallChecker.varInit(lowerBound, "lowerBound", 282, 10323, 15150);
            CallChecker.varInit(this.iterations, "iterations", 282, 10323, 15150);
            CallChecker.varInit(this.evaluations, "evaluations", 282, 10323, 15150);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 282, 10323, 15150);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 282, 10323, 15150);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 282, 10323, 15150);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 282, 10323, 15150);
            CallChecker.varInit(this.newPoint, "newPoint", 282, 10323, 15150);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 282, 10323, 15150);
            CallChecker.varInit(this.upperDifference, "upperDifference", 282, 10323, 15150);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 282, 10323, 15150);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 282, 10323, 15150);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 282, 10323, 15150);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 282, 10323, 15150);
            CallChecker.varInit(this.originShift, "originShift", 282, 10323, 15150);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 282, 10323, 15150);
            CallChecker.varInit(this.zMatrix, "zMatrix", 282, 10323, 15150);
            CallChecker.varInit(this.bMatrix, "bMatrix", 282, 10323, 15150);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 282, 10323, 15150);
            CallChecker.varInit(this.boundDifference, "boundDifference", 282, 10323, 15150);
            CallChecker.varInit(this.currentBest, "currentBest", 282, 10323, 15150);
            CallChecker.varInit(this.isMinimize, "isMinimize", 282, 10323, 15150);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 282, 10323, 15150);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 282, 10323, 15150);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 282, 10323, 15150);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 282, 10323, 15150);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 282, 10323, 15150);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 282, 10323, 15150);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 282, 10323, 15150);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 282, 10323, 15150);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 282, 10323, 15150);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 282, 10323, 15150);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 282, 10323, 15150);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 282, 10323, 15150);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 282, 10323, 15150);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 282, 10323, 15150);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 282, 10323, 15150);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 282, 10323, 15150);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 282, 10323, 15150);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 282, 10323, 15150);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 286, 12726, 12736);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 286, 12726, 12736).getDimension())), "n", 286, 12712, 12752);
            for (int j = 0; j < n; j++) {
                boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 296, 13316, 13330);
                final double boundDiff = CallChecker.varInit(((double) (CallChecker.isCalled(this.boundDifference, double[].class, 296, 13316, 13330)[j])), "boundDiff", 296, 13291, 13334);
                if (CallChecker.beforeDeref(lowerBound, double[].class, 297, 13376, 13385)) {
                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 297, 13392, 13402)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 297, 13348, 13362)) {
                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 297, 13376, 13385);
                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 297, 13392, 13402);
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 297, 13348, 13362);
                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 297, 13348, 13362).setEntry(j, ((CallChecker.isCalled(lowerBound, double[].class, 297, 13376, 13385)[j]) - (CallChecker.isCalled(currentBest, ArrayRealVector.class, 297, 13392, 13402).getEntry(j))));
                        }
                    }
                }
                if (CallChecker.beforeDeref(upperBound, double[].class, 298, 13458, 13467)) {
                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 298, 13474, 13484)) {
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 298, 13430, 13444)) {
                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 298, 13458, 13467);
                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 298, 13474, 13484);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 298, 13430, 13444);
                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 298, 13430, 13444).setEntry(j, ((CallChecker.isCalled(upperBound, double[].class, 298, 13458, 13467)[j]) - (CallChecker.isCalled(currentBest, ArrayRealVector.class, 298, 13474, 13484).getEntry(j))));
                        }
                    }
                }
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 299, 13516, 13530)) {
                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 299, 13516, 13530);
                    if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 299, 13516, 13530).getEntry(j)) >= (-(initialTrustRegionRadius))) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 300, 13596, 13610)) {
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 300, 13596, 13610);
                            if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 300, 13596, 13610).getEntry(j)) >= (BOBYQAOptimizer.ZERO)) {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 301, 13679, 13688)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 301, 13655, 13665)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 301, 13679, 13688);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 301, 13655, 13665);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 301, 13655, 13665).setEntry(j, CallChecker.isCalled(lowerBound, double[].class, 301, 13679, 13688)[j]);
                                    }
                                }
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 302, 13715, 13729)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 302, 13715, 13729);
                                    CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 302, 13715, 13729).setEntry(j, BOBYQAOptimizer.ZERO);
                                }
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 303, 13770, 13784)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 303, 13770, 13784);
                                    CallChecker.isCalled(upperDifference, ArrayRealVector.class, 303, 13770, 13784).setEntry(j, boundDiff);
                                }
                            }else {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 305, 13879, 13888)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 305, 13855, 13865)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 305, 13879, 13888);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 305, 13855, 13865);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 305, 13855, 13865).setEntry(j, ((CallChecker.isCalled(lowerBound, double[].class, 305, 13879, 13888)[j]) + (initialTrustRegionRadius)));
                                    }
                                }
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 306, 13942, 13956)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 306, 13942, 13956);
                                    CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 306, 13942, 13956).setEntry(j, (-(initialTrustRegionRadius)));
                                }
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 308, 14079, 14088);
                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 308, 14095, 14105);
                                final double deltaOne = CallChecker.varInit(((double) ((CallChecker.isCalled(upperBound, double[].class, 308, 14079, 14088)[j]) - (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 308, 14095, 14105).getEntry(j)))), "deltaOne", 308, 14018, 14118);
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 309, 14140, 14154)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 309, 14140, 14154);
                                    CallChecker.isCalled(upperDifference, ArrayRealVector.class, 309, 14140, 14154).setEntry(j, Math.max(deltaOne, initialTrustRegionRadius));
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 311, 14256, 14270)) {
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 311, 14256, 14270);
                            if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 311, 14256, 14270).getEntry(j)) <= (initialTrustRegionRadius)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 312, 14335, 14349)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 312, 14335, 14349);
                                    if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 312, 14335, 14349).getEntry(j)) <= (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(upperBound, double[].class, 313, 14418, 14427)) {
                                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 313, 14394, 14404)) {
                                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 313, 14418, 14427);
                                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 313, 14394, 14404);
                                                CallChecker.isCalled(currentBest, ArrayRealVector.class, 313, 14394, 14404).setEntry(j, CallChecker.isCalled(upperBound, double[].class, 313, 14418, 14427)[j]);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 314, 14454, 14468)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 314, 14454, 14468);
                                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 314, 14454, 14468).setEntry(j, (-boundDiff));
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 315, 14515, 14529)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 315, 14515, 14529);
                                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 315, 14515, 14529).setEntry(j, BOBYQAOptimizer.ZERO);
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(upperBound, double[].class, 317, 14619, 14628)) {
                                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 317, 14595, 14605)) {
                                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 317, 14619, 14628);
                                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 317, 14595, 14605);
                                                CallChecker.isCalled(currentBest, ArrayRealVector.class, 317, 14595, 14605).setEntry(j, ((CallChecker.isCalled(upperBound, double[].class, 317, 14619, 14628)[j]) - (initialTrustRegionRadius)));
                                            }
                                        }
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 319, 14743, 14752);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 319, 14759, 14769);
                                        final double deltaOne = CallChecker.varInit(((double) ((CallChecker.isCalled(lowerBound, double[].class, 319, 14743, 14752)[j]) - (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 319, 14759, 14769).getEntry(j)))), "deltaOne", 319, 14682, 14782);
                                        final double deltaTwo = CallChecker.varInit(((double) (-(this.initialTrustRegionRadius))), "deltaTwo", 320, 14804, 14853);
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 321, 14875, 14889)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 321, 14875, 14889);
                                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 321, 14875, 14889).setEntry(j, Math.min(deltaOne, deltaTwo));
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 322, 14954, 14968)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 322, 14954, 14968);
                                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 322, 14954, 14968).setEntry(j, initialTrustRegionRadius);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return bobyqb(lowerBound, upperBound);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4544.methodEnd();
        }
    }

    private double bobyqb(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4545 = new MethodContext(double.class, 371, 15157, 57544);
        try {
            CallChecker.varInit(this, "this", 371, 15157, 57544);
            CallChecker.varInit(upperBound, "upperBound", 371, 15157, 57544);
            CallChecker.varInit(lowerBound, "lowerBound", 371, 15157, 57544);
            CallChecker.varInit(this.iterations, "iterations", 371, 15157, 57544);
            CallChecker.varInit(this.evaluations, "evaluations", 371, 15157, 57544);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 371, 15157, 57544);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 371, 15157, 57544);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 371, 15157, 57544);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 371, 15157, 57544);
            CallChecker.varInit(this.newPoint, "newPoint", 371, 15157, 57544);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 371, 15157, 57544);
            CallChecker.varInit(this.upperDifference, "upperDifference", 371, 15157, 57544);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 371, 15157, 57544);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 371, 15157, 57544);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 371, 15157, 57544);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 371, 15157, 57544);
            CallChecker.varInit(this.originShift, "originShift", 371, 15157, 57544);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 371, 15157, 57544);
            CallChecker.varInit(this.zMatrix, "zMatrix", 371, 15157, 57544);
            CallChecker.varInit(this.bMatrix, "bMatrix", 371, 15157, 57544);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 371, 15157, 57544);
            CallChecker.varInit(this.boundDifference, "boundDifference", 371, 15157, 57544);
            CallChecker.varInit(this.currentBest, "currentBest", 371, 15157, 57544);
            CallChecker.varInit(this.isMinimize, "isMinimize", 371, 15157, 57544);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 371, 15157, 57544);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 371, 15157, 57544);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 371, 15157, 57544);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 371, 15157, 57544);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 371, 15157, 57544);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 371, 15157, 57544);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 371, 15157, 57544);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 371, 15157, 57544);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 371, 15157, 57544);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 371, 15157, 57544);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 371, 15157, 57544);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 371, 15157, 57544);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 371, 15157, 57544);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 371, 15157, 57544);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 371, 15157, 57544);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 371, 15157, 57544);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 371, 15157, 57544);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 371, 15157, 57544);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 375, 17816, 17826);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 375, 17816, 17826).getDimension())), "n", 375, 17802, 17842);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 376, 17852, 17895);
            final int np = CallChecker.varInit(((int) (n + 1)), "np", 377, 17905, 17925);
            final int nptm = CallChecker.varInit(((int) (npt - np)), "nptm", 378, 17935, 17960);
            final int nh = CallChecker.varInit(((int) ((n * np) / 2)), "nh", 379, 17970, 17995);
            final ArrayRealVector work1 = CallChecker.varInit(new ArrayRealVector(n), "work1", 381, 18006, 18058);
            final ArrayRealVector work2 = CallChecker.varInit(new ArrayRealVector(npt), "work2", 382, 18068, 18122);
            final ArrayRealVector work3 = CallChecker.varInit(new ArrayRealVector(npt), "work3", 383, 18132, 18186);
            double cauchy = CallChecker.varInit(((double) (Double.NaN)), "cauchy", 385, 18197, 18223);
            double alpha = CallChecker.varInit(((double) (Double.NaN)), "alpha", 386, 18233, 18258);
            double dsq = CallChecker.varInit(((double) (Double.NaN)), "dsq", 387, 18268, 18291);
            double crvmin = CallChecker.varInit(((double) (Double.NaN)), "crvmin", 388, 18301, 18327);
            trustRegionCenterInterpolationPointIndex = 0;
            CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 402, 18919, 18963);
            prelim(lowerBound, upperBound);
            double xoptsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "xoptsq", 405, 19014, 19034);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 407, 19122, 19140)) {
                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 407, 19086, 19108)) {
                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 407, 19122, 19140);
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 407, 19086, 19108);
                        CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 407, 19086, 19108).setEntry(i, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 407, 19122, 19140).getEntry(trustRegionCenterInterpolationPointIndex, i));
                    }
                }
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 409, 19269, 19291);
                final double deltaOne = CallChecker.varInit(((double) (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 409, 19269, 19291).getEntry(i))), "deltaOne", 409, 19210, 19304);
                xoptsq += deltaOne * deltaOne;
                CallChecker.varAssign(xoptsq, "xoptsq", 410, 19318, 19347);
            }
            double fsave = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 412, 19382, 19403)) {
                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 412, 19382, 19403);
                fsave = CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 412, 19382, 19403).getEntry(0);
                CallChecker.varAssign(fsave, "fsave", 412, 19382, 19403);
            }
            final int kbase = CallChecker.varInit(((int) (0)), "kbase", 413, 19426, 19445);
            int ntrits = CallChecker.varInit(((int) (0)), "ntrits", 417, 19537, 19551);
            int itest = CallChecker.varInit(((int) (0)), "itest", 418, 19561, 19574);
            int knew = CallChecker.varInit(((int) (0)), "knew", 419, 19584, 19596);
            int nfsav = CallChecker.varInit(((int) (getEvaluations())), "nfsav", 420, 19606, 19634);
            double rho = CallChecker.varInit(((double) (this.initialTrustRegionRadius)), "rho", 421, 19644, 19681);
            double delta = CallChecker.varInit(((double) (rho)), "delta", 422, 19691, 19709);
            double diffa = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffa", 423, 19719, 19738);
            double diffb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffb", 424, 19748, 19767);
            double diffc = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffc", 425, 19777, 19796);
            double f = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "f", 426, 19806, 19821);
            double beta = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "beta", 427, 19831, 19849);
            double adelt = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "adelt", 428, 19859, 19878);
            double denom = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "denom", 429, 19888, 19907);
            double ratio = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ratio", 430, 19917, 19936);
            double dnorm = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dnorm", 431, 19946, 19965);
            double scaden = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "scaden", 432, 19975, 19995);
            double biglsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "biglsq", 433, 20005, 20025);
            double distsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "distsq", 434, 20035, 20055);
            int state = CallChecker.varInit(((int) (20)), "state", 439, 20200, 20214);
            for (; ;)
                switch (state) {
                    case 20 :
                        {
                            BOBYQAOptimizer.printState(20);
                            if ((trustRegionCenterInterpolationPointIndex) != kbase) {
                                int ih = CallChecker.varInit(((int) (0)), "ih", 444, 20388, 20398);
                                for (int j = 0; j < n; j++) {
                                    for (int i = 0; i <= j; i++) {
                                        if (i < j) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20602, 20628)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 448, 20644, 20671)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 448, 20688, 20710)) {
                                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20562, 20588)) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20602, 20628);
                                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 448, 20644, 20671);
                                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 448, 20688, 20710);
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20562, 20588);
                                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20562, 20588).setEntry(j, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 448, 20602, 20628).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 448, 20644, 20671).getEntry(ih)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 448, 20688, 20710).getEntry(i)))));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20816, 20842)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 450, 20858, 20885)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 450, 20902, 20924)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20776, 20802)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20816, 20842);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 450, 20858, 20885);
                                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 450, 20902, 20924);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20776, 20802);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20776, 20802).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 450, 20816, 20842).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 450, 20858, 20885).getEntry(ih)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 450, 20902, 20924).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                if ((getEvaluations()) > npt) {
                                    for (int k = 0; k < npt; k++) {
                                        double temp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "temp", 456, 21132, 21150);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 458, 21242, 21260)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 458, 21279, 21301)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 458, 21242, 21260);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 458, 21279, 21301);
                                                    temp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 458, 21242, 21260).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 458, 21279, 21301).getEntry(j));
                                                    CallChecker.varAssign(temp, "temp", 458, 21234, 21314);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 460, 21374, 21405)) {
                                            modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 460, 21374, 21405);
                                            temp *= CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 460, 21374, 21405).getEntry(k);
                                            CallChecker.varAssign(temp, "temp", 460, 21366, 21418);
                                        }
                                        for (int i = 0; i < n; i++) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21542, 21568)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 462, 21591, 21609)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21502, 21528)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21542, 21568);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 462, 21591, 21609);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21502, 21528);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21502, 21528).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 462, 21542, 21568).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 462, 21591, 21609).getEntry(k, i)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    case 60 :
                        {
                            BOBYQAOptimizer.printState(60);
                            final ArrayRealVector gnew = CallChecker.varInit(new ArrayRealVector(n), "gnew", 479, 22356, 22407);
                            final ArrayRealVector xbdi = CallChecker.varInit(new ArrayRealVector(n), "xbdi", 480, 22421, 22472);
                            final ArrayRealVector s = CallChecker.varInit(new ArrayRealVector(n), "s", 481, 22486, 22534);
                            final ArrayRealVector hs = CallChecker.varInit(new ArrayRealVector(n), "hs", 482, 22548, 22597);
                            final ArrayRealVector hred = CallChecker.varInit(new ArrayRealVector(n), "hred", 483, 22611, 22662);
                            final double[] dsqCrvmin = CallChecker.varInit(trsbox(delta, gnew, xbdi, s, hs, hred), "dsqCrvmin", 485, 22677, 22788);
                            if (CallChecker.beforeDeref(dsqCrvmin, double[].class, 487, 22808, 22816)) {
                                dsq = CallChecker.isCalled(dsqCrvmin, double[].class, 487, 22808, 22816)[0];
                                CallChecker.varAssign(dsq, "dsq", 487, 22802, 22820);
                            }
                            if (CallChecker.beforeDeref(dsqCrvmin, double[].class, 488, 22843, 22851)) {
                                crvmin = CallChecker.isCalled(dsqCrvmin, double[].class, 488, 22843, 22851)[1];
                                CallChecker.varAssign(crvmin, "crvmin", 488, 22834, 22855);
                            }
                            double deltaOne = CallChecker.varInit(((double) (delta)), "deltaOne", 491, 22899, 22922);
                            double deltaTwo = CallChecker.varInit(((double) (Math.sqrt(dsq))), "deltaTwo", 492, 22936, 22968);
                            dnorm = Math.min(deltaOne, deltaTwo);
                            CallChecker.varAssign(dnorm, "dnorm", 493, 22982, 23018);
                            if (dnorm < ((BOBYQAOptimizer.HALF) * rho)) {
                                ntrits = -1;
                                CallChecker.varAssign(ntrits, "ntrits", 495, 23074, 23085);
                                deltaOne = (BOBYQAOptimizer.TEN) * rho;
                                CallChecker.varAssign(deltaOne, "deltaOne", 497, 23142, 23162);
                                distsq = deltaOne * deltaOne;
                                CallChecker.varAssign(distsq, "distsq", 498, 23180, 23208);
                                if ((getEvaluations()) <= (nfsav + 2)) {
                                    state = 650;
                                    CallChecker.varAssign(state, "state", 500, 23283, 23294);
                                    break;
                                }
                                deltaOne = Math.max(diffa, diffb);
                                CallChecker.varAssign(deltaOne, "deltaOne", 510, 23821, 23854);
                                final double errbig = CallChecker.varInit(((double) (Math.max(deltaOne, diffc))), "errbig", 511, 23872, 23919);
                                final double frhosq = CallChecker.varInit(((double) ((rho * (BOBYQAOptimizer.ONE_OVER_EIGHT)) * rho)), "frhosq", 512, 23937, 23985);
                                if ((crvmin > (BOBYQAOptimizer.ZERO)) && (errbig > (frhosq * crvmin))) {
                                    state = 650;
                                    CallChecker.varAssign(state, "state", 515, 24092, 24103);
                                    break;
                                }
                                final double bdtol = CallChecker.varInit(((double) (errbig / rho)), "bdtol", 517, 24146, 24179);
                                for (int j = 0; j < n; j++) {
                                    double bdtest = CallChecker.varInit(((double) (bdtol)), "bdtest", 519, 24247, 24268);
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 520, 24294, 24301)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 520, 24318, 24332)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 520, 24294, 24301);
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 520, 24318, 24332);
                                            if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 520, 24294, 24301).getEntry(j)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 520, 24318, 24332).getEntry(j))) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 521, 24382, 24386)) {
                                                    bdtest = CallChecker.isCalled(work1, ArrayRealVector.class, 521, 24382, 24386).getEntry(j);
                                                    CallChecker.varAssign(bdtest, "bdtest", 521, 24373, 24399);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 523, 24447, 24454)) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 523, 24471, 24485)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 523, 24447, 24454);
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 523, 24471, 24485);
                                            if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 523, 24447, 24454).getEntry(j)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 523, 24471, 24485).getEntry(j))) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 524, 24536, 24540)) {
                                                    bdtest = -(CallChecker.isCalled(work1, ArrayRealVector.class, 524, 24536, 24540).getEntry(j));
                                                    CallChecker.varAssign(bdtest, "bdtest", 524, 24526, 24553);
                                                }
                                            }
                                        }
                                    }
                                    if (bdtest < bdtol) {
                                        double curv = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 527, 24657, 24684)) {
                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 527, 24657, 24684);
                                            curv = CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 527, 24657, 24684).getEntry(((j + (j * j)) / 2));
                                            CallChecker.varAssign(curv, "curv", 527, 24657, 24684);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 530, 24866, 24884);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 530, 24866, 24884).getEntry(k, j))), "d1", 530, 24797, 24900);
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 531, 24938, 24969)) {
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 531, 24938, 24969);
                                                curv += (CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 531, 24938, 24969).getEntry(k)) * (d1 * d1);
                                                CallChecker.varAssign(curv, "curv", 531, 24930, 24994);
                                            }
                                        }
                                        bdtest += ((BOBYQAOptimizer.HALF) * curv) * rho;
                                        CallChecker.varAssign(bdtest, "bdtest", 533, 25046, 25073);
                                        if (bdtest < bdtol) {
                                            state = 650;
                                            CallChecker.varAssign(state, "state", 535, 25149, 25160);
                                            break;
                                        }
                                    }
                                }
                                state = 680;
                                CallChecker.varAssign(state, "state", 540, 25322, 25333);
                                break;
                            }
                            ++ntrits;
                        }
                    case 90 :
                        {
                            BOBYQAOptimizer.printState(90);
                            if (dsq <= (xoptsq * (BOBYQAOptimizer.ONE_OVER_A_THOUSAND))) {
                                final double fracsq = CallChecker.varInit(((double) (xoptsq * (BOBYQAOptimizer.ONE_OVER_FOUR))), "fracsq", 554, 25938, 25982);
                                double sumpq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumpq", 555, 26000, 26019);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 559, 26263, 26294)) {
                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 559, 26263, 26294);
                                        sumpq += CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 559, 26263, 26294).getEntry(k);
                                        CallChecker.varAssign(sumpq, "sumpq", 559, 26254, 26307);
                                    }
                                    double sum = CallChecker.varInit(((double) ((-(BOBYQAOptimizer.HALF)) * xoptsq)), "sum", 560, 26329, 26356);
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 562, 26439, 26457)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 562, 26476, 26498)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 562, 26439, 26457);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 562, 26476, 26498);
                                                sum += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 562, 26439, 26457).getEntry(k, i)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 562, 26476, 26498).getEntry(i));
                                                CallChecker.varAssign(sum, "sum", 562, 26432, 26511);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 565, 26651, 26655)) {
                                        CallChecker.isCalled(work2, ArrayRealVector.class, 565, 26651, 26655).setEntry(k, sum);
                                    }
                                    final double temp = CallChecker.varInit(((double) (fracsq - ((BOBYQAOptimizer.HALF) * sum))), "temp", 566, 26695, 26734);
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 568, 26828, 26834)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 568, 26810, 26814)) {
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 568, 26828, 26834);
                                                CallChecker.isCalled(work1, ArrayRealVector.class, 568, 26810, 26814).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 568, 26828, 26834).getEntry(k, i));
                                            }
                                        }
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 569, 26920, 26938)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 569, 26964, 26986)) {
                                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 569, 26877, 26900)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 569, 26920, 26938);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 569, 26964, 26986);
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 569, 26877, 26900);
                                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 569, 26877, 26900).setEntry(i, ((sum * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 569, 26920, 26938).getEntry(k, i))) + (temp * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 569, 26964, 26986).getEntry(i)))));
                                                }
                                            }
                                        }
                                        final int ip = CallChecker.varInit(((int) (npt + i)), "ip", 570, 27026, 27048);
                                        for (int j = 0; j <= i; j++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 573, 27199, 27205)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 574, 27267, 27271)) {
                                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27287, 27310)) {
                                                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 575, 27368, 27391)) {
                                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 575, 27407, 27411)) {
                                                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 572, 27133, 27139)) {
                                                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 573, 27199, 27205);
                                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27287, 27310);
                                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 575, 27368, 27391);
                                                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 572, 27133, 27139);
                                                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 572, 27133, 27139).setEntry(ip, j, (((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 573, 27199, 27205).getEntry(ip, j)) + ((CallChecker.isCalled(work1, ArrayRealVector.class, 574, 27267, 27271).getEntry(i)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27287, 27310).getEntry(j)))) + ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 575, 27368, 27391).getEntry(i)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 575, 27407, 27411).getEntry(j)))));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int m = 0; m < nptm; m++) {
                                    double sumz = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumz", 583, 27646, 27664);
                                    double sumw = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumw", 584, 27686, 27704);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 586, 27790, 27796)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 586, 27790, 27796);
                                            sumz += CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 586, 27790, 27796).getEntry(k, m);
                                            CallChecker.varAssign(sumz, "sumz", 586, 27782, 27812);
                                        }
                                        if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 587, 27875, 27879)) {
                                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 587, 27895, 27901)) {
                                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 587, 27838, 27861)) {
                                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 587, 27895, 27901);
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 587, 27838, 27861);
                                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 587, 27838, 27861).setEntry(k, ((CallChecker.isCalled(work2, ArrayRealVector.class, 587, 27875, 27879).getEntry(k)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 587, 27895, 27901).getEntry(k, m))));
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 588, 27952, 27975)) {
                                            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 588, 27952, 27975);
                                            sumw += CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 588, 27952, 27975).getEntry(k);
                                            CallChecker.varAssign(sumw, "sumw", 588, 27944, 27988);
                                        }
                                    }
                                    for (int j = 0; j < n; j++) {
                                        double sum = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 591, 28131, 28153)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 591, 28131, 28153);
                                            sum = ((fracsq * sumz) - ((BOBYQAOptimizer.HALF) * sumw)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 591, 28131, 28153).getEntry(j));
                                            CallChecker.varAssign(sum, "sum", 591, 28131, 28153);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28259, 28282)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 593, 28298, 28316)) {
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28259, 28282);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 593, 28298, 28316);
                                                    sum += (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28259, 28282).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 593, 28298, 28316).getEntry(k, j));
                                                    CallChecker.varAssign(sum, "sum", 593, 28252, 28332);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 595, 28384, 28388)) {
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 595, 28384, 28388).setEntry(j, sum);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 598, 28557, 28563)) {
                                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 599, 28630, 28636)) {
                                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 597, 28492, 28498)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 598, 28557, 28563);
                                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 599, 28630, 28636);
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 597, 28492, 28498);
                                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 597, 28492, 28498).setEntry(k, j, ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 598, 28557, 28563).getEntry(k, j)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 599, 28630, 28636).getEntry(k, m)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    for (int i = 0; i < n; i++) {
                                        final int ip = CallChecker.varInit(((int) (i + npt)), "ip", 603, 28777, 28799);
                                        final double temp = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 604, 28845, 28849).getEntry(i))), "temp", 604, 28825, 28862);
                                        for (int j = 0; j <= i; j++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 607, 29013, 29019)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 608, 29088, 29092)) {
                                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 606, 28947, 28953)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 607, 29013, 29019);
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 606, 28947, 28953);
                                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 606, 28947, 28953).setEntry(ip, j, ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 607, 29013, 29019).getEntry(ip, j)) + (temp * (CallChecker.isCalled(work1, ArrayRealVector.class, 608, 29088, 29092).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                int ih = CallChecker.varInit(((int) (0)), "ih", 616, 29359, 29369);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 618, 29471, 29493)) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 618, 29437, 29441)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 618, 29471, 29493);
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 618, 29437, 29441).setEntry(j, (((-(BOBYQAOptimizer.HALF)) * sumpq) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 618, 29471, 29493).getEntry(j))));
                                        }
                                    }
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 620, 29603, 29607)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 620, 29623, 29654)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 620, 29670, 29688)) {
                                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 620, 29585, 29589)) {
                                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 620, 29623, 29654);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 620, 29670, 29688);
                                                        CallChecker.isCalled(work1, ArrayRealVector.class, 620, 29585, 29589).setEntry(j, ((CallChecker.isCalled(work1, ArrayRealVector.class, 620, 29603, 29607).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 620, 29623, 29654).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 620, 29670, 29688).getEntry(k, j)))));
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 621, 29766, 29784)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 621, 29803, 29825)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 621, 29731, 29749)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 621, 29766, 29784);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 621, 29803, 29825);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 621, 29731, 29749);
                                                    CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 621, 29731, 29749).setEntry(k, j, ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 621, 29766, 29784).getEntry(k, j)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 621, 29803, 29825).getEntry(j))));
                                                }
                                            }
                                        }
                                    }
                                    for (int i = 0; i <= j; i++) {
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 625, 30017, 30044)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 626, 30097, 30101)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 626, 30117, 30139)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 627, 30191, 30213)) {
                                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 627, 30229, 30233)) {
                                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 624, 29939, 29966)) {
                                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 625, 30017, 30044);
                                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 626, 30117, 30139);
                                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 627, 30191, 30213);
                                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 624, 29939, 29966);
                                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 624, 29939, 29966).setEntry(ih, (((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 625, 30017, 30044).getEntry(ih)) + ((CallChecker.isCalled(work1, ArrayRealVector.class, 626, 30097, 30101).getEntry(i)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 626, 30117, 30139).getEntry(j)))) + ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 627, 30191, 30213).getEntry(i)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 627, 30229, 30233).getEntry(j)))));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 628, 30302, 30308)) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 628, 30273, 30279)) {
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 628, 30302, 30308);
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 628, 30273, 30279);
                                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 628, 30273, 30279).setEntry((npt + i), j, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 628, 30302, 30308).getEntry((npt + j), i));
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 633, 30493, 30503)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 633, 30519, 30541)) {
                                            if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 633, 30469, 30479)) {
                                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 633, 30493, 30503);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 633, 30519, 30541);
                                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 633, 30469, 30479);
                                                CallChecker.isCalled(originShift, ArrayRealVector.class, 633, 30469, 30479).setEntry(i, ((CallChecker.isCalled(originShift, ArrayRealVector.class, 633, 30493, 30503).getEntry(i)) + (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 633, 30519, 30541).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 634, 30598, 30605)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 634, 30621, 30643)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 634, 30577, 30584)) {
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 634, 30598, 30605);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 634, 30621, 30643);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 634, 30577, 30584);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 634, 30577, 30584).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 634, 30598, 30605).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 634, 30621, 30643).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 635, 30707, 30721)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 635, 30737, 30759)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 635, 30679, 30693)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 635, 30707, 30721);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 635, 30737, 30759);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 635, 30679, 30693);
                                                CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 635, 30679, 30693).setEntry(i, ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 635, 30707, 30721).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 635, 30737, 30759).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 636, 30823, 30837)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 636, 30853, 30875)) {
                                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 636, 30795, 30809)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 636, 30823, 30837);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 636, 30853, 30875);
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 636, 30795, 30809);
                                                CallChecker.isCalled(upperDifference, ArrayRealVector.class, 636, 30795, 30809).setEntry(i, ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 636, 30823, 30837).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 636, 30853, 30875).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 637, 30911, 30933)) {
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 637, 30911, 30933);
                                        CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 637, 30911, 30933).setEntry(i, BOBYQAOptimizer.ZERO);
                                    }
                                }
                                xoptsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(xoptsq, "xoptsq", 639, 30988, 31001);
                            }
                            if (ntrits == 0) {
                                state = 210;
                                CallChecker.varAssign(state, "state", 642, 31064, 31075);
                                break;
                            }
                            state = 230;
                            CallChecker.varAssign(state, "state", 644, 31110, 31121);
                            break;
                        }
                    case 210 :
                        {
                            BOBYQAOptimizer.printState(210);
                            final double[] alphaCauchy = CallChecker.varInit(altmov(knew, adelt), "alphaCauchy", 669, 32687, 32735);
                            if (CallChecker.beforeDeref(alphaCauchy, double[].class, 670, 32757, 32767)) {
                                alpha = CallChecker.isCalled(alphaCauchy, double[].class, 670, 32757, 32767)[0];
                                CallChecker.varAssign(alpha, "alpha", 670, 32749, 32771);
                            }
                            if (CallChecker.beforeDeref(alphaCauchy, double[].class, 671, 32794, 32804)) {
                                cauchy = CallChecker.isCalled(alphaCauchy, double[].class, 671, 32794, 32804)[1];
                                CallChecker.varAssign(cauchy, "cauchy", 671, 32785, 32808);
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 674, 32896, 32903)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 674, 32919, 32941)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 674, 32869, 32882)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 674, 32896, 32903);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 674, 32919, 32941);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 674, 32869, 32882);
                                            CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 674, 32869, 32882).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 674, 32896, 32903).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 674, 32919, 32941).getEntry(i))));
                                        }
                                    }
                                }
                            }
                        }
                    case 230 :
                        {
                            BOBYQAOptimizer.printState(230);
                            for (int k = 0; k < npt; k++) {
                                double suma = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "suma", 685, 33301, 33319);
                                double sumb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumb", 686, 33337, 33355);
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 687, 33373, 33390);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 689, 33466, 33484)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 689, 33503, 33516)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 689, 33466, 33484);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 689, 33503, 33516);
                                            suma += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 689, 33466, 33484).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 689, 33503, 33516).getEntry(j));
                                            CallChecker.varAssign(suma, "suma", 689, 33458, 33529);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 690, 33559, 33577)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 690, 33596, 33618)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 690, 33559, 33577);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 690, 33596, 33618);
                                            sumb += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 690, 33559, 33577).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 690, 33596, 33618).getEntry(j));
                                            CallChecker.varAssign(sumb, "sumb", 690, 33551, 33631);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 691, 33660, 33666)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 691, 33685, 33698)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 691, 33660, 33666);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 691, 33685, 33698);
                                            sum += (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 691, 33660, 33666).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 691, 33685, 33698).getEntry(j));
                                            CallChecker.varAssign(sum, "sum", 691, 33653, 33711);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 693, 33747, 33751)) {
                                    CallChecker.isCalled(work3, ArrayRealVector.class, 693, 33747, 33751).setEntry(k, (suma * (((BOBYQAOptimizer.HALF) * suma) + sumb)));
                                }
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 694, 33811, 33834)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 694, 33811, 33834);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 694, 33811, 33834).setEntry(k, sum);
                                }
                                if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 695, 33870, 33874)) {
                                    CallChecker.isCalled(work2, ArrayRealVector.class, 695, 33870, 33874).setEntry(k, suma);
                                }
                            }
                            beta = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(beta, "beta", 697, 33921, 33932);
                            for (int m = 0; m < nptm; m++) {
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 699, 33995, 34012);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 701, 34089, 34095)) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 701, 34114, 34118)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 701, 34089, 34095);
                                            sum += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 701, 34089, 34095).getEntry(k, m)) * (CallChecker.isCalled(work3, ArrayRealVector.class, 701, 34114, 34118).getEntry(k));
                                            CallChecker.varAssign(sum, "sum", 701, 34082, 34131);
                                        }
                                    }
                                }
                                beta -= sum * sum;
                                CallChecker.varAssign(beta, "beta", 703, 34167, 34184);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34291, 34314)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 705, 34336, 34342)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34254, 34277)) {
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34291, 34314);
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 705, 34336, 34342);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34254, 34277);
                                                CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34254, 34277).setEntry(k, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 705, 34291, 34314).getEntry(k)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 705, 34336, 34342).getEntry(k, m)))));
                                            }
                                        }
                                    }
                                }
                            }
                            dsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dsq, "dsq", 708, 34405, 34415);
                            double bsum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "bsum", 709, 34429, 34447);
                            double dx = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dx", 710, 34461, 34477);
                            for (int j = 0; j < n; j++) {
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 713, 34594, 34607);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 713, 34594, 34607).getEntry(j))), "d1", 713, 34537, 34620);
                                dsq += d1 * d1;
                                CallChecker.varAssign(dsq, "dsq", 714, 34638, 34652);
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 715, 34670, 34687);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 717, 34764, 34768)) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 717, 34784, 34790)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 717, 34784, 34790);
                                            sum += (CallChecker.isCalled(work3, ArrayRealVector.class, 717, 34764, 34768).getEntry(k)) * (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 717, 34784, 34790).getEntry(k, j));
                                            CallChecker.varAssign(sum, "sum", 717, 34757, 34806);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 719, 34856, 34869)) {
                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 719, 34856, 34869);
                                    bsum += sum * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 719, 34856, 34869).getEntry(j));
                                    CallChecker.varAssign(bsum, "bsum", 719, 34842, 34882);
                                }
                                final int jp = CallChecker.varInit(((int) (npt + j)), "jp", 720, 34900, 34922);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 722, 34997, 35003)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 722, 35023, 35036)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 722, 34997, 35003);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 722, 35023, 35036);
                                            sum += (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 722, 34997, 35003).getEntry(jp, i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 722, 35023, 35036).getEntry(i));
                                            CallChecker.varAssign(sum, "sum", 722, 34990, 35049);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 724, 35085, 35108)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 724, 35085, 35108);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 724, 35085, 35108).setEntry(jp, sum);
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 725, 35159, 35172)) {
                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 725, 35159, 35172);
                                    bsum += sum * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 725, 35159, 35172).getEntry(j));
                                    CallChecker.varAssign(bsum, "bsum", 725, 35145, 35185);
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 726, 35209, 35222)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 726, 35238, 35260)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 726, 35209, 35222);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 726, 35238, 35260);
                                        dx += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 726, 35209, 35222).getEntry(j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 726, 35238, 35260).getEntry(j));
                                        CallChecker.varAssign(dx, "dx", 726, 35203, 35273);
                                    }
                                }
                            }
                            beta = (((dx * dx) + (dsq * (((xoptsq + dx) + dx) + ((BOBYQAOptimizer.HALF) * dsq)))) + beta) - bsum;
                            CallChecker.varAssign(beta, "beta", 729, 35302, 35370);
                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 734, 35734, 35757)) {
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 733, 35632, 35655)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 734, 35734, 35757);
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 733, 35632, 35655);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 733, 35632, 35655).setEntry(trustRegionCenterInterpolationPointIndex, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 734, 35734, 35757).getEntry(trustRegionCenterInterpolationPointIndex)) + (BOBYQAOptimizer.ONE)));
                                }
                            }
                            if (ntrits == 0) {
                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 742, 36155, 36178);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 742, 36155, 36178).getEntry(knew))), "d1", 742, 36098, 36194);
                                denom = (d1 * d1) + (alpha * beta);
                                CallChecker.varAssign(denom, "denom", 743, 36212, 36242);
                                if ((denom < cauchy) && (cauchy > (BOBYQAOptimizer.ZERO))) {
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 746, 36394, 36412)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 746, 36373, 36380)) {
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 746, 36394, 36412);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 746, 36373, 36380);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 746, 36373, 36380).setEntry(i, CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 746, 36394, 36412).getEntry(i));
                                            }
                                        }
                                        if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 747, 36479, 36486)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 747, 36502, 36524)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 747, 36452, 36465)) {
                                                    newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 747, 36479, 36486);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 747, 36502, 36524);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 747, 36452, 36465);
                                                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 747, 36452, 36465).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 747, 36479, 36486).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 747, 36502, 36524).getEntry(i))));
                                                }
                                            }
                                        }
                                    }
                                    cauchy = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(cauchy, "cauchy", 749, 36582, 36595);
                                    state = 230;
                                    CallChecker.varAssign(state, "state", 750, 36642, 36653);
                                    break;
                                }
                            }else {
                                final double delsq = CallChecker.varInit(((double) (delta * delta)), "delsq", 759, 37157, 37191);
                                scaden = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(scaden, "scaden", 760, 37209, 37222);
                                biglsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(biglsq, "biglsq", 761, 37240, 37253);
                                knew = 0;
                                CallChecker.varAssign(knew, "knew", 762, 37271, 37279);
                                for (int k = 0; k < npt; k++) {
                                    if (k == (trustRegionCenterInterpolationPointIndex)) {
                                        continue;
                                    }
                                    double hdiag = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "hdiag", 767, 37478, 37497);
                                    for (int m = 0; m < nptm; m++) {
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 770, 37641, 37647);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 770, 37641, 37647).getEntry(k, m))), "d1", 770, 37576, 37663);
                                        hdiag += d1 * d1;
                                        CallChecker.varAssign(hdiag, "hdiag", 771, 37689, 37705);
                                    }
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 774, 37810, 37833);
                                    final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 774, 37810, 37833).getEntry(k))), "d2", 774, 37749, 37846);
                                    final double den = CallChecker.varInit(((double) ((beta * hdiag) + (d2 * d2))), "den", 775, 37868, 37909);
                                    distsq = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(distsq, "distsq", 776, 37931, 37944);
                                    for (int j = 0; j < n; j++) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 779, 38085, 38103);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 779, 38122, 38144);
                                        final double d3 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 779, 38085, 38103).getEntry(k, j)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 779, 38122, 38144).getEntry(j)))), "d3", 779, 38020, 38157);
                                        distsq += d3 * d3;
                                        CallChecker.varAssign(distsq, "distsq", 780, 38183, 38200);
                                    }
                                    final double d4 = CallChecker.varInit(((double) (distsq / delsq)), "d4", 784, 38244, 38356);
                                    final double temp = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ONE, (d4 * d4)))), "temp", 785, 38378, 38420);
                                    if ((temp * den) > scaden) {
                                        scaden = temp * den;
                                        CallChecker.varAssign(scaden, "scaden", 787, 38493, 38512);
                                        knew = k;
                                        CallChecker.varAssign(knew, "knew", 788, 38538, 38546);
                                        denom = den;
                                        CallChecker.varAssign(denom, "denom", 789, 38572, 38583);
                                    }
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 793, 38725, 38748);
                                    final double d5 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 793, 38725, 38748).getEntry(k))), "d5", 793, 38627, 38761);
                                    biglsq = Math.max(biglsq, (temp * (d5 * d5)));
                                    CallChecker.varAssign(biglsq, "biglsq", 794, 38783, 38826);
                                }
                            }
                        }
                    case 360 :
                        {
                            BOBYQAOptimizer.printState(360);
                            for (int i = 0; i < n; i++) {
                                lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 810, 39381, 39390);
                                final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(lowerBound, double[].class, 810, 39381, 39390)[i])), "d3", 810, 39297, 39394);
                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 811, 39430, 39440);
                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 811, 39456, 39463);
                                final double d4 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.originShift, ArrayRealVector.class, 811, 39430, 39440).getEntry(i)) + (CallChecker.isCalled(this.newPoint, ArrayRealVector.class, 811, 39456, 39463).getEntry(i)))), "d4", 811, 39412, 39476);
                                final double d1 = CallChecker.varInit(((double) (Math.max(d3, d4))), "d1", 812, 39494, 39528);
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 813, 39564, 39573);
                                final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(upperBound, double[].class, 813, 39564, 39573)[i])), "d2", 813, 39546, 39577);
                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 814, 39595, 39605)) {
                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 814, 39595, 39605);
                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 814, 39595, 39605).setEntry(i, Math.min(d1, d2));
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 815, 39658, 39665)) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 815, 39682, 39696)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 815, 39658, 39665);
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 815, 39682, 39696);
                                        if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 815, 39658, 39665).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 815, 39682, 39696).getEntry(i))) {
                                            if (CallChecker.beforeDeref(lowerBound, double[].class, 816, 39757, 39766)) {
                                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 816, 39733, 39743)) {
                                                    lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 816, 39757, 39766);
                                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 816, 39733, 39743);
                                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 816, 39733, 39743).setEntry(i, CallChecker.isCalled(lowerBound, double[].class, 816, 39757, 39766)[i]);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 818, 39811, 39818)) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 818, 39835, 39849)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 818, 39811, 39818);
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 818, 39835, 39849);
                                        if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 818, 39811, 39818).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 818, 39835, 39849).getEntry(i))) {
                                            if (CallChecker.beforeDeref(upperBound, double[].class, 819, 39910, 39919)) {
                                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 819, 39886, 39896)) {
                                                    upperBound = CallChecker.beforeCalled(upperBound, double[].class, 819, 39910, 39919);
                                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 819, 39886, 39896);
                                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 819, 39886, 39896).setEntry(i, CallChecker.isCalled(upperBound, double[].class, 819, 39910, 39919)[i]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 823, 39997, 40007)) {
                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 823, 39997, 40007);
                                f = computeObjectiveValue(CallChecker.isCalled(currentBest, ArrayRealVector.class, 823, 39997, 40007).toArray());
                                CallChecker.varAssign(f, "f", 823, 39971, 40019);
                            }
                            if (!(isMinimize)) {
                                f = -f;
                                CallChecker.varAssign(f, "f", 826, 40067, 40073);
                            }
                            if (ntrits == (-1)) {
                                fsave = f;
                                CallChecker.varAssign(fsave, "fsave", 828, 40123, 40132);
                                state = 720;
                                CallChecker.varAssign(state, "state", 829, 40150, 40161);
                                break;
                            }
                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 835, 40366, 40387);
                            final double fopt = CallChecker.varInit(((double) (CallChecker.isCalled(this.fAtInterpolationPoints, ArrayRealVector.class, 835, 40366, 40387).getEntry(this.trustRegionCenterInterpolationPointIndex))), "fopt", 835, 40197, 40439);
                            double vquad = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "vquad", 836, 40453, 40472);
                            int ih = CallChecker.varInit(((int) (0)), "ih", 837, 40486, 40496);
                            for (int j = 0; j < n; j++) {
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 839, 40565, 40578)) {
                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 839, 40594, 40620)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 839, 40565, 40578);
                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 839, 40594, 40620);
                                        vquad += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 839, 40565, 40578).getEntry(j)) * (CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 839, 40594, 40620).getEntry(j));
                                        CallChecker.varAssign(vquad, "vquad", 839, 40556, 40633);
                                    }
                                }
                                for (int i = 0; i <= j; i++) {
                                    double temp = CallChecker.init(double.class);
                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 841, 40716, 40729)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 841, 40745, 40758)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 841, 40716, 40729);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 841, 40745, 40758);
                                            temp = (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 841, 40716, 40729).getEntry(i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 841, 40745, 40758).getEntry(j));
                                            CallChecker.varAssign(temp, "temp", 841, 40716, 40729);
                                        }
                                    }
                                    if (i == j) {
                                        temp *= BOBYQAOptimizer.HALF;
                                        CallChecker.varAssign(temp, "temp", 843, 40831, 40843);
                                    }
                                    if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 845, 40896, 40923)) {
                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 845, 40896, 40923);
                                        vquad += (CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 845, 40896, 40923).getEntry(ih)) * temp;
                                        CallChecker.varAssign(vquad, "vquad", 845, 40887, 40944);
                                    }
                                    ih++;
                                }
                            }
                            for (int k = 0; k < npt; k++) {
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work2, ArrayRealVector.class, 851, 41120, 41124).getEntry(k))), "d1", 851, 41063, 41137);
                                final double d2 = CallChecker.varInit(((double) (d1 * d1)), "d2", 852, 41155, 41180);
                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 853, 41270, 41301)) {
                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 853, 41270, 41301);
                                    vquad += ((BOBYQAOptimizer.HALF) * (CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 853, 41270, 41301).getEntry(k))) * d2;
                                    CallChecker.varAssign(vquad, "vquad", 853, 41254, 41319);
                                }
                            }
                            final double diff = CallChecker.varInit(((double) ((f - fopt) - vquad)), "diff", 855, 41347, 41383);
                            diffc = diffb;
                            CallChecker.varAssign(diffc, "diffc", 856, 41397, 41410);
                            diffb = diffa;
                            CallChecker.varAssign(diffb, "diffb", 857, 41424, 41437);
                            diffa = Math.abs(diff);
                            CallChecker.varAssign(diffa, "diffa", 858, 41451, 41473);
                            if (dnorm > rho) {
                                nfsav = getEvaluations();
                                CallChecker.varAssign(nfsav, "nfsav", 860, 41522, 41546);
                            }
                            if (ntrits > 0) {
                                if (vquad >= (BOBYQAOptimizer.ZERO)) {
                                    throw new MathIllegalStateException(LocalizedFormats.TRUST_REGION_STEP_FAILED, vquad);
                                }
                                ratio = (f - fopt) / vquad;
                                CallChecker.varAssign(ratio, "ratio", 869, 41843, 41869);
                                final double hDelta = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * delta)), "hDelta", 870, 41887, 41921);
                                if (ratio <= (BOBYQAOptimizer.ONE_OVER_TEN)) {
                                    delta = Math.min(hDelta, dnorm);
                                    CallChecker.varAssign(delta, "delta", 873, 42025, 42056);
                                }else
                                    if (ratio <= 0.7) {
                                        delta = Math.max(hDelta, dnorm);
                                        CallChecker.varAssign(delta, "delta", 876, 42157, 42188);
                                    }else {
                                        delta = Math.max(hDelta, (2 * dnorm));
                                        CallChecker.varAssign(delta, "delta", 879, 42272, 42307);
                                    }
                                
                                if (delta <= (rho * 1.5)) {
                                    delta = rho;
                                    CallChecker.varAssign(delta, "delta", 882, 42389, 42400);
                                }
                                if (f < fopt) {
                                    final int ksav = CallChecker.varInit(((int) (knew)), "ksav", 888, 42552, 42573);
                                    final double densav = CallChecker.varInit(((double) (denom)), "densav", 889, 42595, 42622);
                                    final double delsq = CallChecker.varInit(((double) (delta * delta)), "delsq", 890, 42644, 42678);
                                    scaden = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(scaden, "scaden", 891, 42700, 42713);
                                    biglsq = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(biglsq, "biglsq", 892, 42735, 42748);
                                    knew = 0;
                                    CallChecker.varAssign(knew, "knew", 893, 42770, 42778);
                                    for (int k = 0; k < npt; k++) {
                                        double hdiag = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "hdiag", 895, 42856, 42875);
                                        for (int m = 0; m < nptm; m++) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 898, 43031, 43037);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 898, 43031, 43037).getEntry(k, m))), "d1", 898, 42962, 43053);
                                            hdiag += d1 * d1;
                                            CallChecker.varAssign(hdiag, "hdiag", 899, 43083, 43099);
                                        }
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 902, 43216, 43239);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 902, 43216, 43239).getEntry(k))), "d1", 902, 43151, 43252);
                                        final double den = CallChecker.varInit(((double) ((beta * hdiag) + (d1 * d1))), "den", 903, 43278, 43319);
                                        distsq = BOBYQAOptimizer.ZERO;
                                        CallChecker.varAssign(distsq, "distsq", 904, 43345, 43358);
                                        for (int j = 0; j < n; j++) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 907, 43511, 43529);
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 907, 43548, 43555);
                                            final double d2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 907, 43511, 43529).getEntry(k, j)) - (CallChecker.isCalled(this.newPoint, ArrayRealVector.class, 907, 43548, 43555).getEntry(j)))), "d2", 907, 43442, 43568);
                                            distsq += d2 * d2;
                                            CallChecker.varAssign(distsq, "distsq", 908, 43598, 43615);
                                        }
                                        final double d3 = CallChecker.varInit(((double) (distsq / delsq)), "d3", 912, 43667, 43787);
                                        final double temp = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ONE, (d3 * d3)))), "temp", 913, 43813, 43855);
                                        if ((temp * den) > scaden) {
                                            scaden = temp * den;
                                            CallChecker.varAssign(scaden, "scaden", 915, 43936, 43955);
                                            knew = k;
                                            CallChecker.varAssign(knew, "knew", 916, 43985, 43993);
                                            denom = den;
                                            CallChecker.varAssign(denom, "denom", 917, 44023, 44034);
                                        }
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 921, 44192, 44215);
                                        final double d4 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 921, 44192, 44215).getEntry(k))), "d4", 921, 44086, 44228);
                                        final double d5 = CallChecker.varInit(((double) (temp * (d4 * d4))), "d5", 922, 44254, 44288);
                                        biglsq = Math.max(biglsq, d5);
                                        CallChecker.varAssign(biglsq, "biglsq", 923, 44314, 44343);
                                    }
                                    if (scaden <= ((BOBYQAOptimizer.HALF) * biglsq)) {
                                        knew = ksav;
                                        CallChecker.varAssign(knew, "knew", 926, 44442, 44453);
                                        denom = densav;
                                        CallChecker.varAssign(denom, "denom", 927, 44479, 44493);
                                    }
                                }
                            }
                            update(beta, denom, knew);
                            ih = 0;
                            CallChecker.varAssign(ih, "ih", 937, 44763, 44769);
                            modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 938, 44804, 44835);
                            final double pqold = CallChecker.varInit(((double) (CallChecker.isCalled(this.modelSecondDerivativesParameters, ArrayRealVector.class, 938, 44804, 44835).getEntry(knew))), "pqold", 938, 44783, 44851);
                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 939, 44865, 44896)) {
                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 939, 44865, 44896);
                                CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 939, 44865, 44896).setEntry(knew, BOBYQAOptimizer.ZERO);
                            }
                            for (int i = 0; i < n; i++) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 941, 45006, 45024);
                                final double temp = CallChecker.varInit(((double) (pqold * (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 941, 45006, 45024).getEntry(knew, i)))), "temp", 941, 44978, 45043);
                                for (int j = 0; j <= i; j++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45154, 45181)) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 943, 45205, 45223)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45112, 45139)) {
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45154, 45181);
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 943, 45205, 45223);
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45112, 45139);
                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45112, 45139).setEntry(ih, ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 943, 45154, 45181).getEntry(ih)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 943, 45205, 45223).getEntry(knew, j)))));
                                            }
                                        }
                                    }
                                    ih++;
                                }
                            }
                            for (int m = 0; m < nptm; m++) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 948, 45391, 45397);
                                final double temp = CallChecker.varInit(((double) (diff * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 948, 45391, 45397).getEntry(knew, m)))), "temp", 948, 45364, 45416);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45531, 45562)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 950, 45585, 45591)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45486, 45517)) {
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45531, 45562);
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 950, 45585, 45591);
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45486, 45517);
                                                CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45486, 45517).setEntry(k, ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 950, 45531, 45562).getEntry(k)) + (temp * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 950, 45585, 45591).getEntry(k, m)))));
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 957, 45824, 45845)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 957, 45824, 45845);
                                CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 957, 45824, 45845).setEntry(knew, f);
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 959, 45963, 45970)) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 959, 45925, 45943)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 959, 45963, 45970);
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 959, 45925, 45943);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 959, 45925, 45943).setEntry(knew, i, CallChecker.isCalled(newPoint, ArrayRealVector.class, 959, 45963, 45970).getEntry(i));
                                    }
                                }
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 960, 46020, 46026)) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 960, 46002, 46006)) {
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 960, 46020, 46026);
                                        CallChecker.isCalled(work1, ArrayRealVector.class, 960, 46002, 46006).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 960, 46020, 46026).getEntry(knew, i));
                                    }
                                }
                            }
                            for (int k = 0; k < npt; k++) {
                                double suma = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "suma", 963, 46122, 46140);
                                for (int m = 0; m < nptm; m++) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 965, 46219, 46225)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 965, 46247, 46253)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 965, 46219, 46225);
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 965, 46247, 46253);
                                            suma += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 965, 46219, 46225).getEntry(knew, m)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 965, 46247, 46253).getEntry(k, m));
                                            CallChecker.varAssign(suma, "suma", 965, 46211, 46269);
                                        }
                                    }
                                }
                                double sumb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumb", 967, 46305, 46323);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 969, 46399, 46417)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 969, 46436, 46458)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 969, 46399, 46417);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 969, 46436, 46458);
                                            sumb += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 969, 46399, 46417).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 969, 46436, 46458).getEntry(j));
                                            CallChecker.varAssign(sumb, "sumb", 969, 46391, 46471);
                                        }
                                    }
                                }
                                final double temp = CallChecker.varInit(((double) (suma * sumb)), "temp", 971, 46507, 46538);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 973, 46624, 46628)) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 973, 46651, 46669)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 973, 46606, 46610)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 973, 46651, 46669);
                                                CallChecker.isCalled(work1, ArrayRealVector.class, 973, 46606, 46610).setEntry(i, ((CallChecker.isCalled(work1, ArrayRealVector.class, 973, 46624, 46628).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 973, 46651, 46669).getEntry(k, i)))));
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46818, 46844)) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 977, 46867, 46871)) {
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46778, 46804)) {
                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46818, 46844);
                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46778, 46804);
                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46778, 46804).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 977, 46818, 46844).getEntry(i)) + (diff * (CallChecker.isCalled(work1, ArrayRealVector.class, 977, 46867, 46871).getEntry(i)))));
                                        }
                                    }
                                }
                            }
                            if (f < fopt) {
                                trustRegionCenterInterpolationPointIndex = knew;
                                CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 983, 47032, 47079);
                                xoptsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(xoptsq, "xoptsq", 984, 47097, 47110);
                                ih = 0;
                                CallChecker.varAssign(ih, "ih", 985, 47128, 47134);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 987, 47238, 47245)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 987, 47202, 47224)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 987, 47238, 47245);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 987, 47202, 47224);
                                            CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 987, 47202, 47224).setEntry(j, CallChecker.isCalled(newPoint, ArrayRealVector.class, 987, 47238, 47245).getEntry(j));
                                        }
                                    }
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 989, 47342, 47364);
                                    final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 989, 47342, 47364).getEntry(j))), "d1", 989, 47281, 47377);
                                    xoptsq += d1 * d1;
                                    CallChecker.varAssign(xoptsq, "xoptsq", 990, 47399, 47416);
                                    for (int i = 0; i <= j; i++) {
                                        if (i < j) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47574, 47600)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 993, 47616, 47643)) {
                                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 993, 47660, 47673)) {
                                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47534, 47560)) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47574, 47600);
                                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 993, 47616, 47643);
                                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 993, 47660, 47673);
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47534, 47560);
                                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47534, 47560).setEntry(j, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 993, 47574, 47600).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 993, 47616, 47643).getEntry(ih)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 993, 47660, 47673).getEntry(i)))));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47779, 47805)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 995, 47821, 47848)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 995, 47865, 47878)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47739, 47765)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47779, 47805);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 995, 47821, 47848);
                                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 995, 47865, 47878);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47739, 47765);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47739, 47765).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 995, 47779, 47805).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 995, 47821, 47848).getEntry(ih)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 995, 47865, 47878).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                for (int k = 0; k < npt; k++) {
                                    double temp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "temp", 1000, 48032, 48050);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1002, 48134, 48152)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1002, 48171, 48184)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1002, 48134, 48152);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1002, 48171, 48184);
                                                temp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1002, 48134, 48152).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1002, 48171, 48184).getEntry(j));
                                                CallChecker.varAssign(temp, "temp", 1002, 48126, 48197);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1004, 48249, 48280)) {
                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1004, 48249, 48280);
                                        temp *= CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1004, 48249, 48280).getEntry(k);
                                        CallChecker.varAssign(temp, "temp", 1004, 48241, 48293);
                                    }
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48409, 48435)) {
                                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1006, 48458, 48476)) {
                                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48369, 48395)) {
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48409, 48435);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1006, 48458, 48476);
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48369, 48395);
                                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48369, 48395).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1006, 48409, 48435).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1006, 48458, 48476).getEntry(k, i)))));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (ntrits > 0) {
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48899, 48920)) {
                                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48936, 48957)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1017, 48862, 48885)) {
                                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48899, 48920);
                                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48936, 48957);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1017, 48862, 48885);
                                                CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1017, 48862, 48885).setEntry(k, ((CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48899, 48920).getEntry(k)) - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1017, 48936, 48957).getEntry(trustRegionCenterInterpolationPointIndex))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1018, 49032, 49036)) {
                                        CallChecker.isCalled(work3, ArrayRealVector.class, 1018, 49032, 49036).setEntry(k, BOBYQAOptimizer.ZERO);
                                    }
                                }
                                for (int j = 0; j < nptm; j++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1021, 49144, 49161);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1023, 49246, 49252)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1023, 49271, 49294)) {
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1023, 49246, 49252);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1023, 49271, 49294);
                                                sum += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1023, 49246, 49252).getEntry(k, j)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1023, 49271, 49294).getEntry(k));
                                                CallChecker.varAssign(sum, "sum", 1023, 49239, 49307);
                                            }
                                        }
                                    }
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1026, 49425, 49429)) {
                                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1026, 49451, 49457)) {
                                                if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1026, 49407, 49411)) {
                                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1026, 49451, 49457);
                                                    CallChecker.isCalled(work3, ArrayRealVector.class, 1026, 49407, 49411).setEntry(k, ((CallChecker.isCalled(work3, ArrayRealVector.class, 1026, 49425, 49429).getEntry(k)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1026, 49451, 49457).getEntry(k, j)))));
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int k = 0; k < npt; k++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1030, 49584, 49601);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1032, 49684, 49702)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1032, 49721, 49743)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1032, 49684, 49702);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1032, 49721, 49743);
                                                sum += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1032, 49684, 49702).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1032, 49721, 49743).getEntry(j));
                                                CallChecker.varAssign(sum, "sum", 1032, 49677, 49756);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1034, 49818, 49822)) {
                                        if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1034, 49800, 49804)) {
                                            CallChecker.isCalled(work2, ArrayRealVector.class, 1034, 49800, 49804).setEntry(k, CallChecker.isCalled(work3, ArrayRealVector.class, 1034, 49818, 49822).getEntry(k));
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1035, 49882, 49886)) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1035, 49858, 49862)) {
                                            CallChecker.isCalled(work3, ArrayRealVector.class, 1035, 49858, 49862).setEntry(k, (sum * (CallChecker.isCalled(work3, ArrayRealVector.class, 1035, 49882, 49886).getEntry(k))));
                                        }
                                    }
                                }
                                double gqsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gqsq", 1037, 49936, 49954);
                                double gisq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gisq", 1038, 49972, 49990);
                                for (int i = 0; i < n; i++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1040, 50058, 50075);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1042, 50160, 50166)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1043, 50213, 50236)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1043, 50252, 50270)) {
                                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1043, 50289, 50293)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1042, 50160, 50166);
                                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1043, 50213, 50236);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1043, 50252, 50270);
                                                        sum += ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1042, 50160, 50166).getEntry(k, i)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1043, 50213, 50236).getEntry(k))) + ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1043, 50252, 50270).getEntry(k, i)) * (CallChecker.isCalled(work3, ArrayRealVector.class, 1043, 50289, 50293).getEntry(k)));
                                                        CallChecker.varAssign(sum, "sum", 1042, 50153, 50306);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1045, 50354, 50376)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1045, 50393, 50407)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1045, 50354, 50376);
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1045, 50393, 50407);
                                            if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1045, 50354, 50376).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1045, 50393, 50407).getEntry(i))) {
                                                gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1048, 50569, 50595);
                                                final double d1 = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ZERO, CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1048, 50569, 50595).getEntry(i)))), "d1", 1048, 50448, 50609);
                                                gqsq += d1 * d1;
                                                CallChecker.varAssign(gqsq, "gqsq", 1049, 50635, 50650);
                                                final double d2 = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ZERO, sum))), "d2", 1051, 50676, 50760);
                                                gisq += d2 * d2;
                                                CallChecker.varAssign(gisq, "gisq", 1052, 50786, 50801);
                                            }else
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1053, 50834, 50856)) {
                                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1053, 50873, 50887)) {
                                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1053, 50834, 50856);
                                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1053, 50873, 50887);
                                                        if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1053, 50834, 50856).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1053, 50873, 50887).getEntry(i))) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1056, 51049, 51075);
                                                            final double d1 = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ZERO, CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1056, 51049, 51075).getEntry(i)))), "d1", 1056, 50928, 51089);
                                                            gqsq += d1 * d1;
                                                            CallChecker.varAssign(gqsq, "gqsq", 1057, 51115, 51130);
                                                            final double d2 = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ZERO, sum))), "d2", 1059, 51156, 51240);
                                                            gisq += d2 * d2;
                                                            CallChecker.varAssign(gisq, "gisq", 1060, 51266, 51281);
                                                        }else {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1063, 51401, 51427);
                                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1063, 51401, 51427).getEntry(i))), "d1", 1063, 51336, 51440);
                                                            gqsq += d1 * d1;
                                                            CallChecker.varAssign(gqsq, "gqsq", 1064, 51466, 51481);
                                                            gisq += sum * sum;
                                                            CallChecker.varAssign(gisq, "gisq", 1065, 51507, 51524);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1067, 51568, 51591)) {
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1067, 51568, 51591);
                                        CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1067, 51568, 51591).setEntry((npt + i), sum);
                                    }
                                }
                                ++itest;
                                if (gqsq < ((BOBYQAOptimizer.TEN) * gisq)) {
                                    itest = 0;
                                    CallChecker.varAssign(itest, "itest", 1075, 51899, 51908);
                                }
                                if (itest >= 3) {
                                    for (int i = 0, max = Math.max(npt, nh); i < max; i++) {
                                        if (i < n) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1080, 52144, 52167)) {
                                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1080, 52104, 52130)) {
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1080, 52144, 52167);
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1080, 52104, 52130);
                                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1080, 52104, 52130).setEntry(i, CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1080, 52144, 52167).getEntry((npt + i)));
                                                }
                                            }
                                        }
                                        if (i < npt) {
                                            if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1083, 52327, 52331)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1083, 52282, 52313)) {
                                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1083, 52282, 52313);
                                                    CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1083, 52282, 52313).setEntry(i, CallChecker.isCalled(work2, ArrayRealVector.class, 1083, 52327, 52331).getEntry(i));
                                                }
                                            }
                                        }
                                        if (i < nh) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1086, 52439, 52466)) {
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1086, 52439, 52466);
                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1086, 52439, 52466).setEntry(i, BOBYQAOptimizer.ZERO);
                                            }
                                        }
                                        itest = 0;
                                        CallChecker.varAssign(itest, "itest", 1088, 52537, 52546);
                                    }
                                }
                            }
                            if (ntrits == 0) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1098, 52904, 52914);
                                break;
                            }
                            if (f <= (fopt + ((BOBYQAOptimizer.ONE_OVER_TEN) * vquad))) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1101, 53005, 53015);
                                break;
                            }
                            final double d1 = CallChecker.varInit(((double) ((BOBYQAOptimizer.TWO) * delta)), "d1", 1109, 53051, 53272);
                            final double d2 = CallChecker.varInit(((double) ((BOBYQAOptimizer.TEN) * rho)), "d2", 1111, 53286, 53348);
                            distsq = Math.max((d1 * d1), (d2 * d2));
                            CallChecker.varAssign(distsq, "distsq", 1112, 53362, 53397);
                        }
                    case 650 :
                        {
                            BOBYQAOptimizer.printState(650);
                            knew = -1;
                            CallChecker.varAssign(knew, "knew", 1116, 53477, 53486);
                            for (int k = 0; k < npt; k++) {
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1118, 53548, 53565);
                                for (int j = 0; j < n; j++) {
                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1121, 53694, 53712);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1121, 53731, 53753);
                                    final double d1 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1121, 53694, 53712).getEntry(k, j)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1121, 53731, 53753).getEntry(j)))), "d1", 1121, 53633, 53766);
                                    sum += d1 * d1;
                                    CallChecker.varAssign(sum, "sum", 1122, 53788, 53802);
                                }
                                if (sum > distsq) {
                                    knew = k;
                                    CallChecker.varAssign(knew, "knew", 1125, 53878, 53886);
                                    distsq = sum;
                                    CallChecker.varAssign(distsq, "distsq", 1126, 53908, 53920);
                                }
                            }
                            if (knew >= 0) {
                                final double dist = CallChecker.varInit(((double) (Math.sqrt(distsq))), "dist", 1137, 54372, 54409);
                                if (ntrits == (-1)) {
                                    delta = Math.min(((BOBYQAOptimizer.ONE_OVER_TEN) * delta), ((BOBYQAOptimizer.HALF) * dist));
                                    CallChecker.varAssign(delta, "delta", 1140, 54504, 54555);
                                    if (delta <= (rho * 1.5)) {
                                        delta = rho;
                                        CallChecker.varAssign(delta, "delta", 1142, 54627, 54638);
                                    }
                                }
                                ntrits = 0;
                                CallChecker.varAssign(ntrits, "ntrits", 1145, 54696, 54706);
                                final double d1 = CallChecker.varInit(((double) (Math.min(((BOBYQAOptimizer.ONE_OVER_TEN) * dist), delta))), "d1", 1148, 54724, 54844);
                                adelt = Math.max(d1, rho);
                                CallChecker.varAssign(adelt, "adelt", 1149, 54862, 54887);
                                dsq = adelt * adelt;
                                CallChecker.varAssign(dsq, "dsq", 1150, 54905, 54924);
                                state = 90;
                                CallChecker.varAssign(state, "state", 1151, 54942, 54952);
                                break;
                            }
                            if (ntrits == (-1)) {
                                state = 680;
                                CallChecker.varAssign(state, "state", 1154, 55023, 55034);
                                break;
                            }
                            if (ratio > (BOBYQAOptimizer.ZERO)) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1157, 55105, 55115);
                                break;
                            }
                            if ((Math.max(delta, dnorm)) > rho) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1160, 55202, 55212);
                                break;
                            }
                        }
                    case 680 :
                        {
                            BOBYQAOptimizer.printState(680);
                            if (rho > (stoppingTrustRegionRadius)) {
                                delta = (BOBYQAOptimizer.HALF) * rho;
                                CallChecker.varAssign(delta, "delta", 1169, 55501, 55519);
                                ratio = rho / (stoppingTrustRegionRadius);
                                CallChecker.varAssign(ratio, "ratio", 1170, 55537, 55576);
                                if (ratio <= (BOBYQAOptimizer.SIXTEEN)) {
                                    rho = stoppingTrustRegionRadius;
                                    CallChecker.varAssign(rho, "rho", 1172, 55638, 55669);
                                }else
                                    if (ratio <= (BOBYQAOptimizer.TWO_HUNDRED_FIFTY)) {
                                        rho = (Math.sqrt(ratio)) * (stoppingTrustRegionRadius);
                                        CallChecker.varAssign(rho, "rho", 1174, 55748, 55798);
                                    }else {
                                        rho *= BOBYQAOptimizer.ONE_OVER_TEN;
                                        CallChecker.varAssign(rho, "rho", 1176, 55845, 55864);
                                    }
                                
                                delta = Math.max(delta, rho);
                                CallChecker.varAssign(delta, "delta", 1178, 55900, 55928);
                                ntrits = 0;
                                CallChecker.varAssign(ntrits, "ntrits", 1179, 55946, 55956);
                                nfsav = getEvaluations();
                                CallChecker.varAssign(nfsav, "nfsav", 1180, 55974, 55998);
                                state = 60;
                                CallChecker.varAssign(state, "state", 1181, 56016, 56026);
                                break;
                            }
                            if (ntrits == (-1)) {
                                state = 360;
                                CallChecker.varAssign(state, "state", 1188, 56241, 56252);
                                break;
                            }
                        }
                    case 720 :
                        {
                            BOBYQAOptimizer.printState(720);
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1193, 56357, 56378)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1193, 56357, 56378);
                                if ((CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1193, 56357, 56378).getEntry(trustRegionCenterInterpolationPointIndex)) <= fsave) {
                                    for (int i = 0; i < n; i++) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1197, 56601, 56610);
                                        final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(lowerBound, double[].class, 1197, 56601, 56610)[i])), "d3", 1197, 56509, 56614);
                                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1198, 56654, 56664);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1198, 56680, 56702);
                                        final double d4 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.originShift, ArrayRealVector.class, 1198, 56654, 56664).getEntry(i)) + (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1198, 56680, 56702).getEntry(i)))), "d4", 1198, 56636, 56715);
                                        final double d1 = CallChecker.varInit(((double) (Math.max(d3, d4))), "d1", 1199, 56737, 56771);
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1200, 56811, 56820);
                                        final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(upperBound, double[].class, 1200, 56811, 56820)[i])), "d2", 1200, 56793, 56824);
                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1201, 56846, 56856)) {
                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1201, 56846, 56856);
                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1201, 56846, 56856).setEntry(i, Math.min(d1, d2));
                                        }
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1202, 56913, 56935)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1202, 56952, 56966)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1202, 56913, 56935);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1202, 56952, 56966);
                                                if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1202, 56913, 56935).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1202, 56952, 56966).getEntry(i))) {
                                                    if (CallChecker.beforeDeref(lowerBound, double[].class, 1203, 57031, 57040)) {
                                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1203, 57007, 57017)) {
                                                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1203, 57031, 57040);
                                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1203, 57007, 57017);
                                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1203, 57007, 57017).setEntry(i, CallChecker.isCalled(lowerBound, double[].class, 1203, 57031, 57040)[i]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1205, 57093, 57115)) {
                                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1205, 57132, 57146)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1205, 57093, 57115);
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1205, 57132, 57146);
                                                if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1205, 57093, 57115).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1205, 57132, 57146).getEntry(i))) {
                                                    if (CallChecker.beforeDeref(upperBound, double[].class, 1206, 57211, 57220)) {
                                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1206, 57187, 57197)) {
                                                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1206, 57211, 57220);
                                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1206, 57187, 57197);
                                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1206, 57187, 57197).setEntry(i, CallChecker.isCalled(upperBound, double[].class, 1206, 57211, 57220)[i]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1209, 57287, 57308)) {
                                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1209, 57287, 57308);
                                        f = CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1209, 57287, 57308).getEntry(trustRegionCenterInterpolationPointIndex);
                                        CallChecker.varAssign(f, "f", 1209, 57283, 57360);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            return f;
                        }
                    default :
                        {
                            throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, "bobyqb");
                        }
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4545.methodEnd();
        }
    }

    private double[] altmov(int knew, double adelt) {
        MethodContext _bcornu_methode_context4546 = new MethodContext(double[].class, 1253, 57551, 72898);
        try {
            CallChecker.varInit(this, "this", 1253, 57551, 72898);
            CallChecker.varInit(adelt, "adelt", 1253, 57551, 72898);
            CallChecker.varInit(knew, "knew", 1253, 57551, 72898);
            CallChecker.varInit(this.iterations, "iterations", 1253, 57551, 72898);
            CallChecker.varInit(this.evaluations, "evaluations", 1253, 57551, 72898);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1253, 57551, 72898);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1253, 57551, 72898);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1253, 57551, 72898);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1253, 57551, 72898);
            CallChecker.varInit(this.newPoint, "newPoint", 1253, 57551, 72898);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1253, 57551, 72898);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1253, 57551, 72898);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1253, 57551, 72898);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1253, 57551, 72898);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1253, 57551, 72898);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1253, 57551, 72898);
            CallChecker.varInit(this.originShift, "originShift", 1253, 57551, 72898);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1253, 57551, 72898);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1253, 57551, 72898);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1253, 57551, 72898);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1253, 57551, 72898);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1253, 57551, 72898);
            CallChecker.varInit(this.currentBest, "currentBest", 1253, 57551, 72898);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1253, 57551, 72898);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1253, 57551, 72898);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1253, 57551, 72898);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1253, 57551, 72898);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1253, 57551, 72898);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 1253, 57551, 72898);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 1253, 57551, 72898);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 1253, 57551, 72898);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 1253, 57551, 72898);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 1253, 57551, 72898);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1253, 57551, 72898);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 1253, 57551, 72898);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 1253, 57551, 72898);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 1253, 57551, 72898);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 1253, 57551, 72898);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 1253, 57551, 72898);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1253, 57551, 72898);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1253, 57551, 72898);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1253, 57551, 72898);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1259, 59949, 59959);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1259, 59949, 59959).getDimension())), "n", 1259, 59935, 59975);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1260, 59985, 60028);
            final ArrayRealVector glag = CallChecker.varInit(new ArrayRealVector(n), "glag", 1262, 60039, 60090);
            final ArrayRealVector hcol = CallChecker.varInit(new ArrayRealVector(npt), "hcol", 1263, 60100, 60153);
            final ArrayRealVector work1 = CallChecker.varInit(new ArrayRealVector(n), "work1", 1265, 60164, 60216);
            final ArrayRealVector work2 = CallChecker.varInit(new ArrayRealVector(n), "work2", 1266, 60226, 60278);
            for (int k = 0; k < npt; k++) {
                if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1269, 60333, 60336)) {
                    CallChecker.isCalled(hcol, ArrayRealVector.class, 1269, 60333, 60336).setEntry(k, BOBYQAOptimizer.ZERO);
                }
            }
            for (int j = 0, max = (npt - n) - 1; j < max; j++) {
                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1272, 60457, 60463);
                final double tmp = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 1272, 60457, 60463).getEntry(knew, j))), "tmp", 1272, 60438, 60482);
                for (int k = 0; k < npt; k++) {
                    if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1274, 60561, 60564)) {
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1274, 60586, 60592)) {
                            if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1274, 60544, 60547)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1274, 60586, 60592);
                                CallChecker.isCalled(hcol, ArrayRealVector.class, 1274, 60544, 60547).setEntry(k, ((CallChecker.isCalled(hcol, ArrayRealVector.class, 1274, 60561, 60564).getEntry(k)) + (tmp * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1274, 60586, 60592).getEntry(k, j)))));
                            }
                        }
                    }
                }
            }
            final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(hcol, ArrayRealVector.class, 1277, 60664, 60667).getEntry(knew))), "alpha", 1277, 60643, 60683);
            final double ha = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * alpha)), "ha", 1278, 60693, 60723);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1283, 60870, 60876)) {
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1283, 60853, 60856)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1283, 60870, 60876);
                        CallChecker.isCalled(glag, ArrayRealVector.class, 1283, 60853, 60856).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1283, 60870, 60876).getEntry(knew, i));
                    }
                }
            }
            for (int k = 0; k < npt; k++) {
                double tmp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "tmp", 1286, 60960, 60977);
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1288, 61044, 61062)) {
                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1288, 61081, 61103)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1288, 61044, 61062);
                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1288, 61081, 61103);
                            tmp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1288, 61044, 61062).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1288, 61081, 61103).getEntry(j));
                            CallChecker.varAssign(tmp, "tmp", 1288, 61037, 61116);
                        }
                    }
                }
                if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1290, 61151, 61154)) {
                    tmp *= CallChecker.isCalled(hcol, ArrayRealVector.class, 1290, 61151, 61154).getEntry(k);
                    CallChecker.varAssign(tmp, "tmp", 1290, 61144, 61167);
                }
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1292, 61244, 61247)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1292, 61269, 61287)) {
                            if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1292, 61227, 61230)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1292, 61269, 61287);
                                CallChecker.isCalled(glag, ArrayRealVector.class, 1292, 61227, 61230).setEntry(i, ((CallChecker.isCalled(glag, ArrayRealVector.class, 1292, 61244, 61247).getEntry(i)) + (tmp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1292, 61269, 61287).getEntry(k, i)))));
                            }
                        }
                    }
                }
            }
            double presav = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "presav", 1302, 61740, 61760);
            double step = CallChecker.varInit(((double) (Double.NaN)), "step", 1303, 61770, 61794);
            int ksav = CallChecker.varInit(((int) (0)), "ksav", 1304, 61804, 61816);
            int ibdsav = CallChecker.varInit(((int) (0)), "ibdsav", 1305, 61826, 61840);
            double stpsav = CallChecker.varInit(((double) (0)), "stpsav", 1306, 61850, 61867);
            for (int k = 0; k < npt; k++) {
                if (k == (trustRegionCenterInterpolationPointIndex)) {
                    continue;
                }
                double dderiv = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dderiv", 1311, 62026, 62046);
                double distsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "distsq", 1312, 62060, 62080);
                for (int i = 0; i < n; i++) {
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1314, 62159, 62177);
                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1314, 62196, 62218);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1314, 62159, 62177).getEntry(k, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1314, 62196, 62218).getEntry(i)))), "tmp", 1314, 62140, 62231);
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1315, 62259, 62262)) {
                        dderiv += (CallChecker.isCalled(glag, ArrayRealVector.class, 1315, 62259, 62262).getEntry(i)) * tmp;
                        CallChecker.varAssign(dderiv, "dderiv", 1315, 62249, 62281);
                    }
                    distsq += tmp * tmp;
                    CallChecker.varAssign(distsq, "distsq", 1316, 62299, 62318);
                }
                double subd = CallChecker.varInit(((double) (adelt / (Math.sqrt(distsq)))), "subd", 1318, 62346, 62385);
                double slbd = CallChecker.varInit(((double) (-subd)), "slbd", 1319, 62399, 62418);
                int ilbd = CallChecker.varInit(((int) (0)), "ilbd", 1320, 62432, 62444);
                int iubd = CallChecker.varInit(((int) (0)), "iubd", 1321, 62458, 62470);
                final double sumin = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ONE, subd))), "sumin", 1322, 62484, 62524);
                for (int i = 0; i < n; i++) {
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1327, 62690, 62708);
                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1327, 62727, 62749);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1327, 62690, 62708).getEntry(k, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1327, 62727, 62749).getEntry(i)))), "tmp", 1327, 62671, 62762);
                    if (tmp > (BOBYQAOptimizer.ZERO)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1329, 62835, 62849)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1329, 62865, 62887)) {
                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1329, 62835, 62849);
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1329, 62865, 62887);
                                if ((slbd * tmp) < ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1329, 62835, 62849).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1329, 62865, 62887).getEntry(i)))) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1330, 62936, 62950)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1330, 62966, 62988)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1330, 62936, 62950);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1330, 62966, 62988);
                                            slbd = ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1330, 62936, 62950).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1330, 62966, 62988).getEntry(i))) / tmp;
                                            CallChecker.varAssign(slbd, "slbd", 1330, 62928, 63008);
                                        }
                                    }
                                    ilbd = (-i) - 1;
                                    CallChecker.varAssign(ilbd, "ilbd", 1331, 63034, 63047);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1333, 63108, 63122)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1333, 63138, 63160)) {
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1333, 63108, 63122);
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1333, 63138, 63160);
                                if ((subd * tmp) > ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1333, 63108, 63122).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1333, 63138, 63160).getEntry(i)))) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1336, 63306, 63320)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1336, 63336, 63358)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1336, 63306, 63320);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1336, 63336, 63358);
                                            subd = Math.max(sumin, (((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1336, 63306, 63320).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1336, 63336, 63358).getEntry(i))) / tmp));
                                            CallChecker.varAssign(subd, "subd", 1335, 63242, 63379);
                                        }
                                    }
                                    iubd = i + 1;
                                    CallChecker.varAssign(iubd, "iubd", 1337, 63405, 63417);
                                }
                            }
                        }
                    }else
                        if (tmp < (BOBYQAOptimizer.ZERO)) {
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1340, 63519, 63533)) {
                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1340, 63549, 63571)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1340, 63519, 63533);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1340, 63549, 63571);
                                    if ((slbd * tmp) > ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1340, 63519, 63533).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1340, 63549, 63571).getEntry(i)))) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1341, 63620, 63634)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63650, 63672)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1341, 63620, 63634);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63650, 63672);
                                                slbd = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1341, 63620, 63634).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63650, 63672).getEntry(i))) / tmp;
                                                CallChecker.varAssign(slbd, "slbd", 1341, 63612, 63692);
                                            }
                                        }
                                        ilbd = i + 1;
                                        CallChecker.varAssign(ilbd, "ilbd", 1342, 63718, 63730);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1344, 63791, 63805)) {
                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1344, 63821, 63843)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1344, 63791, 63805);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1344, 63821, 63843);
                                    if ((subd * tmp) < ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1344, 63791, 63805).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1344, 63821, 63843).getEntry(i)))) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1347, 63989, 64003)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1347, 64019, 64041)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1347, 63989, 64003);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1347, 64019, 64041);
                                                subd = Math.max(sumin, (((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1347, 63989, 64003).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1347, 64019, 64041).getEntry(i))) / tmp));
                                                CallChecker.varAssign(subd, "subd", 1346, 63925, 64062);
                                            }
                                        }
                                        iubd = (-i) - 1;
                                        CallChecker.varAssign(iubd, "iubd", 1348, 64088, 64101);
                                    }
                                }
                            }
                        }
                    
                }
                step = slbd;
                CallChecker.varAssign(step, "step", 1356, 64337, 64348);
                int isbd = CallChecker.varInit(((int) (ilbd)), "isbd", 1357, 64362, 64377);
                double vlag = CallChecker.varInit(((double) (Double.NaN)), "vlag", 1358, 64391, 64415);
                if (k == knew) {
                    final double diff = CallChecker.varInit(((double) (dderiv - (BOBYQAOptimizer.ONE))), "diff", 1360, 64462, 64494);
                    vlag = slbd * (dderiv - (slbd * diff));
                    CallChecker.varAssign(vlag, "vlag", 1361, 64512, 64548);
                    final double d1 = CallChecker.varInit(((double) (subd * (dderiv - (subd * diff)))), "d1", 1362, 64566, 64613);
                    if ((Math.abs(d1)) > (Math.abs(vlag))) {
                        step = subd;
                        CallChecker.varAssign(step, "step", 1364, 64688, 64699);
                        vlag = d1;
                        CallChecker.varAssign(vlag, "vlag", 1365, 64721, 64730);
                        isbd = iubd;
                        CallChecker.varAssign(isbd, "isbd", 1366, 64752, 64763);
                    }
                    final double d2 = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * dderiv)), "d2", 1368, 64799, 64830);
                    final double d3 = CallChecker.varInit(((double) (d2 - (diff * slbd))), "d3", 1369, 64848, 64882);
                    final double d4 = CallChecker.varInit(((double) (d2 - (diff * subd))), "d4", 1370, 64900, 64934);
                    if ((d3 * d4) < (BOBYQAOptimizer.ZERO)) {
                        final double d5 = CallChecker.varInit(((double) ((d2 * d2) / diff)), "d5", 1372, 64994, 65026);
                        if ((Math.abs(d5)) > (Math.abs(vlag))) {
                            step = d2 / diff;
                            CallChecker.varAssign(step, "step", 1374, 65109, 65125);
                            vlag = d5;
                            CallChecker.varAssign(vlag, "vlag", 1375, 65151, 65160);
                            isbd = 0;
                            CallChecker.varAssign(isbd, "isbd", 1376, 65186, 65194);
                        }
                    }
                }else {
                    vlag = slbd * ((BOBYQAOptimizer.ONE) - slbd);
                    CallChecker.varAssign(vlag, "vlag", 1383, 65363, 65389);
                    final double tmp = CallChecker.varInit(((double) (subd * ((BOBYQAOptimizer.ONE) - subd))), "tmp", 1384, 65407, 65445);
                    if ((Math.abs(tmp)) > (Math.abs(vlag))) {
                        step = subd;
                        CallChecker.varAssign(step, "step", 1386, 65521, 65532);
                        vlag = tmp;
                        CallChecker.varAssign(vlag, "vlag", 1387, 65554, 65564);
                        isbd = iubd;
                        CallChecker.varAssign(isbd, "isbd", 1388, 65586, 65597);
                    }
                    if ((subd > (BOBYQAOptimizer.HALF)) && ((Math.abs(vlag)) < (BOBYQAOptimizer.ONE_OVER_FOUR))) {
                        step = BOBYQAOptimizer.HALF;
                        CallChecker.varAssign(step, "step", 1391, 65706, 65717);
                        vlag = BOBYQAOptimizer.ONE_OVER_FOUR;
                        CallChecker.varAssign(vlag, "vlag", 1392, 65739, 65759);
                        isbd = 0;
                        CallChecker.varAssign(isbd, "isbd", 1393, 65781, 65789);
                    }
                    vlag *= dderiv;
                    CallChecker.varAssign(vlag, "vlag", 1395, 65825, 65839);
                }
                final double tmp = CallChecker.varInit(((double) ((step * ((BOBYQAOptimizer.ONE) - step)) * distsq)), "tmp", 1400, 65868, 65997);
                final double predsq = CallChecker.varInit(((double) ((vlag * vlag) * ((vlag * vlag) + ((ha * tmp) * tmp)))), "predsq", 1401, 66011, 66077);
                if (predsq > presav) {
                    presav = predsq;
                    CallChecker.varAssign(presav, "presav", 1403, 66130, 66145);
                    ksav = k;
                    CallChecker.varAssign(ksav, "ksav", 1404, 66163, 66171);
                    stpsav = step;
                    CallChecker.varAssign(stpsav, "stpsav", 1405, 66189, 66202);
                    ibdsav = isbd;
                    CallChecker.varAssign(ibdsav, "ibdsav", 1406, 66220, 66233);
                }
            }
            for (int i = 0; i < n; i++) {
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1413, 66411, 66433);
                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1413, 66459, 66477);
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1413, 66499, 66521);
                final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1413, 66411, 66433).getEntry(i)) + (stpsav * ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1413, 66459, 66477).getEntry(ksav, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1413, 66499, 66521).getEntry(i)))))), "tmp", 1413, 66392, 66535);
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1414, 66579, 66593)) {
                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1415, 66655, 66669)) {
                        if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1414, 66549, 66556)) {
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1414, 66579, 66593);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1415, 66655, 66669);
                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1414, 66549, 66556);
                            CallChecker.isCalled(newPoint, ArrayRealVector.class, 1414, 66549, 66556).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1414, 66579, 66593).getEntry(i), Math.min(CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1415, 66655, 66669).getEntry(i), tmp)));
                        }
                    }
                }
            }
            if (ibdsav < 0) {
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1418, 66771, 66785)) {
                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1418, 66740, 66747)) {
                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1418, 66771, 66785);
                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1418, 66740, 66747);
                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 1418, 66740, 66747).setEntry(((-ibdsav) - 1), CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1418, 66771, 66785).getEntry(((-ibdsav) - 1)));
                    }
                }
            }
            if (ibdsav > 0) {
                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1421, 66889, 66903)) {
                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1421, 66859, 66866)) {
                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1421, 66889, 66903);
                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1421, 66859, 66866);
                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 1421, 66859, 66866).setEntry((ibdsav - 1), CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1421, 66889, 66903).getEntry((ibdsav - 1)));
                    }
                }
            }
            final double bigstp = CallChecker.varInit(((double) (adelt + adelt)), "bigstp", 1428, 66947, 67215);
            int iflag = CallChecker.varInit(((int) (0)), "iflag", 1429, 67225, 67238);
            double cauchy = CallChecker.varInit(((double) (Double.NaN)), "cauchy", 1430, 67248, 67274);
            double csave = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "csave", 1431, 67284, 67303);
            while (true) {
                double wfixsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "wfixsq", 1433, 67340, 67360);
                double ggfree = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ggfree", 1434, 67374, 67394);
                for (int i = 0; i < n; i++) {
                    final double glagValue = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1436, 67479, 67482).getEntry(i))), "glagValue", 1436, 67454, 67495);
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1437, 67513, 67517)) {
                        CallChecker.isCalled(work1, ArrayRealVector.class, 1437, 67513, 67517).setEntry(i, BOBYQAOptimizer.ZERO);
                    }
                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1438, 67567, 67589)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1438, 67605, 67619)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1439, 67684, 67706)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1439, 67722, 67736)) {
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1438, 67567, 67589);
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1438, 67605, 67619);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1439, 67684, 67706);
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1439, 67722, 67736);
                                    if (((Math.min(((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1438, 67567, 67589).getEntry(i)) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1438, 67605, 67619).getEntry(i))), glagValue)) > (BOBYQAOptimizer.ZERO)) || ((Math.max(((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1439, 67684, 67706).getEntry(i)) - (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1439, 67722, 67736).getEntry(i))), glagValue)) < (BOBYQAOptimizer.ZERO))) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1440, 67792, 67796)) {
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 1440, 67792, 67796).setEntry(i, bigstp);
                                        }
                                        ggfree += glagValue * glagValue;
                                        CallChecker.varAssign(ggfree, "ggfree", 1442, 67882, 67913);
                                    }
                                }
                            }
                        }
                    }
                }
                if (ggfree == (BOBYQAOptimizer.ZERO)) {
                    return new double[]{ alpha , BOBYQAOptimizer.ZERO };
                }
                final double tmp1 = CallChecker.varInit(((double) ((adelt * adelt) - wfixsq)), "tmp1", 1450, 68061, 68173);
                if (tmp1 > (BOBYQAOptimizer.ZERO)) {
                    step = Math.sqrt((tmp1 / ggfree));
                    CallChecker.varAssign(step, "step", 1452, 68222, 68253);
                    ggfree = BOBYQAOptimizer.ZERO;
                    CallChecker.varAssign(ggfree, "ggfree", 1453, 68271, 68284);
                    for (int i = 0; i < n; i++) {
                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1455, 68356, 68360)) {
                            if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1455, 68356, 68360).getEntry(i)) == bigstp) {
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1456, 68431, 68453);
                                final double tmp2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1456, 68431, 68453).getEntry(i)) - (step * (CallChecker.isCalled(glag, ArrayRealVector.class, 1456, 68476, 68479).getEntry(i))))), "tmp2", 1456, 68411, 68492);
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1457, 68530, 68544)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1457, 68530, 68544);
                                    if (tmp2 <= (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1457, 68530, 68544).getEntry(i))) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1458, 68607, 68621)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1458, 68637, 68659)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1458, 68589, 68593)) {
                                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1458, 68607, 68621);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1458, 68637, 68659);
                                                    CallChecker.isCalled(work1, ArrayRealVector.class, 1458, 68589, 68593).setEntry(i, ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1458, 68607, 68621).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1458, 68637, 68659).getEntry(i))));
                                                }
                                            }
                                        }
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 1460, 68772, 68776).getEntry(i))), "d1", 1460, 68703, 68789);
                                        wfixsq += d1 * d1;
                                        CallChecker.varAssign(wfixsq, "wfixsq", 1461, 68819, 68836);
                                    }else
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1462, 68881, 68895)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1462, 68881, 68895);
                                            if (tmp2 >= (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1462, 68881, 68895).getEntry(i))) {
                                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1463, 68958, 68972)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68988, 69010)) {
                                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1463, 68940, 68944)) {
                                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1463, 68958, 68972);
                                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68988, 69010);
                                                            CallChecker.isCalled(work1, ArrayRealVector.class, 1463, 68940, 68944).setEntry(i, ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1463, 68958, 68972).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68988, 69010).getEntry(i))));
                                                        }
                                                    }
                                                }
                                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 1465, 69123, 69127).getEntry(i))), "d1", 1465, 69054, 69140);
                                                wfixsq += d1 * d1;
                                                CallChecker.varAssign(wfixsq, "wfixsq", 1466, 69170, 69187);
                                            }else {
                                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1469, 69319, 69322).getEntry(i))), "d1", 1469, 69250, 69335);
                                                ggfree += d1 * d1;
                                                CallChecker.varAssign(ggfree, "ggfree", 1470, 69365, 69382);
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                double gw = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gw", 1479, 69610, 69626);
                for (int i = 0; i < n; i++) {
                    final double glagValue = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1481, 69711, 69714).getEntry(i))), "glagValue", 1481, 69686, 69727);
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1482, 69749, 69753)) {
                        if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1482, 69749, 69753).getEntry(i)) == bigstp) {
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1483, 69800, 69804)) {
                                CallChecker.isCalled(work1, ArrayRealVector.class, 1483, 69800, 69804).setEntry(i, ((-step) * glagValue));
                            }
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1484, 69886, 69900);
                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1485, 69963, 69985);
                            final double min = CallChecker.varInit(((double) (Math.min(CallChecker.isCalled(this.upperDifference, ArrayRealVector.class, 1484, 69886, 69900).getEntry(i), ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1485, 69963, 69985).getEntry(i)) + (CallChecker.isCalled(work1, ArrayRealVector.class, 1485, 70001, 70005).getEntry(i)))))), "min", 1484, 69858, 70019);
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1486, 70082, 70096)) {
                                if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1486, 70041, 70059)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1486, 70082, 70096);
                                    alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1486, 70041, 70059);
                                    CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1486, 70041, 70059).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1486, 70082, 70096).getEntry(i), min));
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1487, 70145, 70149)) {
                                if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1487, 70145, 70149).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1488, 70226, 70248)) {
                                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1488, 70194, 70212)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1488, 70226, 70248);
                                            alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1488, 70194, 70212);
                                            CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1488, 70194, 70212).setEntry(i, CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1488, 70226, 70248).getEntry(i));
                                        }
                                    }
                                }else
                                    if (glagValue > (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1490, 70363, 70377)) {
                                            if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1490, 70331, 70349)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1490, 70363, 70377);
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1490, 70331, 70349);
                                                CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1490, 70331, 70349).setEntry(i, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1490, 70363, 70377).getEntry(i));
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1492, 70470, 70484)) {
                                            if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1492, 70438, 70456)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1492, 70470, 70484);
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1492, 70438, 70456);
                                                CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1492, 70438, 70456).setEntry(i, CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1492, 70470, 70484).getEntry(i));
                                            }
                                        }
                                    }
                                
                            }
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1494, 70552, 70556)) {
                        gw += glagValue * (CallChecker.isCalled(work1, ArrayRealVector.class, 1494, 70552, 70556).getEntry(i));
                        CallChecker.varAssign(gw, "gw", 1494, 70534, 70569);
                    }
                }
                double curv = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "curv", 1502, 70890, 70908);
                for (int k = 0; k < npt; k++) {
                    double tmp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "tmp", 1504, 70970, 70987);
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1506, 71062, 71080)) {
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1506, 71099, 71103)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1506, 71062, 71080);
                                tmp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1506, 71062, 71080).getEntry(k, j)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 1506, 71099, 71103).getEntry(j));
                                CallChecker.varAssign(tmp, "tmp", 1506, 71055, 71116);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1508, 71160, 71163)) {
                        curv += ((CallChecker.isCalled(hcol, ArrayRealVector.class, 1508, 71160, 71163).getEntry(k)) * tmp) * tmp;
                        CallChecker.varAssign(curv, "curv", 1508, 71152, 71188);
                    }
                }
                if (iflag == 1) {
                    curv = -curv;
                    CallChecker.varAssign(curv, "curv", 1511, 71250, 71262);
                }
                if ((curv > (-gw)) && (curv < ((-gw) * ((BOBYQAOptimizer.ONE) + (Math.sqrt(BOBYQAOptimizer.TWO)))))) {
                    final double scale = CallChecker.varInit(((double) ((-gw) / curv)), "scale", 1515, 71379, 71410);
                    for (int i = 0; i < n; i++) {
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1517, 71497, 71519);
                        final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1517, 71497, 71519).getEntry(i)) + (scale * (CallChecker.isCalled(work1, ArrayRealVector.class, 1517, 71543, 71547).getEntry(i))))), "tmp", 1517, 71478, 71560);
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1518, 71623, 71637)) {
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1519, 71707, 71721)) {
                                if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1518, 71582, 71600)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1518, 71623, 71637);
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1519, 71707, 71721);
                                    alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1518, 71582, 71600);
                                    CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1518, 71582, 71600).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1518, 71623, 71637).getEntry(i), Math.min(CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1519, 71707, 71721).getEntry(i), tmp)));
                                }
                            }
                        }
                    }
                    final double d1 = CallChecker.varInit(((double) (((BOBYQAOptimizer.HALF) * gw) * scale)), "d1", 1522, 71778, 71852);
                    cauchy = d1 * d1;
                    CallChecker.varAssign(cauchy, "cauchy", 1523, 71870, 71886);
                }else {
                    final double d1 = CallChecker.varInit(((double) (gw + ((BOBYQAOptimizer.HALF) * curv))), "d1", 1526, 71925, 71998);
                    cauchy = d1 * d1;
                    CallChecker.varAssign(cauchy, "cauchy", 1527, 72016, 72032);
                }
                if (iflag == 0) {
                    for (int i = 0; i < n; i++) {
                        if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1536, 72408, 72411)) {
                            if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1536, 72390, 72393)) {
                                CallChecker.isCalled(glag, ArrayRealVector.class, 1536, 72390, 72393).setEntry(i, (-(CallChecker.isCalled(glag, ArrayRealVector.class, 1536, 72408, 72411).getEntry(i))));
                            }
                        }
                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1537, 72465, 72483)) {
                            if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1537, 72447, 72451)) {
                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1537, 72465, 72483);
                                CallChecker.isCalled(work2, ArrayRealVector.class, 1537, 72447, 72451).setEntry(i, CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1537, 72465, 72483).getEntry(i));
                            }
                        }
                    }
                    csave = cauchy;
                    CallChecker.varAssign(csave, "csave", 1539, 72533, 72547);
                    iflag = 1;
                    CallChecker.varAssign(iflag, "iflag", 1540, 72565, 72574);
                }else {
                    break;
                }
            } 
            if (csave > cauchy) {
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1547, 72764, 72768)) {
                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1547, 72732, 72750)) {
                            alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1547, 72732, 72750);
                            CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1547, 72732, 72750).setEntry(i, CallChecker.isCalled(work2, ArrayRealVector.class, 1547, 72764, 72768).getEntry(i));
                        }
                    }
                }
                cauchy = csave;
                CallChecker.varAssign(cauchy, "cauchy", 1549, 72810, 72824);
            }
            return new double[]{ alpha , cauchy };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4546.methodEnd();
        }
    }

    private void prelim(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4547 = new MethodContext(void.class, 1577, 72905, 82982);
        try {
            CallChecker.varInit(this, "this", 1577, 72905, 82982);
            CallChecker.varInit(upperBound, "upperBound", 1577, 72905, 82982);
            CallChecker.varInit(lowerBound, "lowerBound", 1577, 72905, 82982);
            CallChecker.varInit(this.iterations, "iterations", 1577, 72905, 82982);
            CallChecker.varInit(this.evaluations, "evaluations", 1577, 72905, 82982);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1577, 72905, 82982);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1577, 72905, 82982);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1577, 72905, 82982);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1577, 72905, 82982);
            CallChecker.varInit(this.newPoint, "newPoint", 1577, 72905, 82982);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1577, 72905, 82982);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1577, 72905, 82982);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1577, 72905, 82982);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1577, 72905, 82982);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1577, 72905, 82982);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1577, 72905, 82982);
            CallChecker.varInit(this.originShift, "originShift", 1577, 72905, 82982);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1577, 72905, 82982);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1577, 72905, 82982);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1577, 72905, 82982);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1577, 72905, 82982);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1577, 72905, 82982);
            CallChecker.varInit(this.currentBest, "currentBest", 1577, 72905, 82982);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1577, 72905, 82982);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1577, 72905, 82982);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1577, 72905, 82982);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1577, 72905, 82982);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1577, 72905, 82982);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 1577, 72905, 82982);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 1577, 72905, 82982);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 1577, 72905, 82982);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 1577, 72905, 82982);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 1577, 72905, 82982);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1577, 72905, 82982);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 1577, 72905, 82982);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 1577, 72905, 82982);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 1577, 72905, 82982);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 1577, 72905, 82982);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 1577, 72905, 82982);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1577, 72905, 82982);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1577, 72905, 82982);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1577, 72905, 82982);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1581, 74298, 74308);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1581, 74298, 74308).getDimension())), "n", 1581, 74284, 74324);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1582, 74334, 74377);
            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1583, 74404, 74410);
            final int ndim = CallChecker.varInit(((int) (CallChecker.isCalled(this.bMatrix, Array2DRowRealMatrix.class, 1583, 74404, 74410).getRowDimension())), "ndim", 1583, 74387, 74429);
            final double rhosq = CallChecker.varInit(((double) ((this.initialTrustRegionRadius) * (this.initialTrustRegionRadius))), "rhosq", 1585, 74440, 74512);
            final double recip = CallChecker.varInit(((double) (1.0 / rhosq)), "recip", 1586, 74522, 74553);
            final int np = CallChecker.varInit(((int) (n + 1)), "np", 1587, 74563, 74583);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1593, 74797, 74807)) {
                    if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 1593, 74773, 74783)) {
                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1593, 74797, 74807);
                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1593, 74773, 74783);
                        CallChecker.isCalled(originShift, ArrayRealVector.class, 1593, 74773, 74783).setEntry(j, CallChecker.isCalled(currentBest, ArrayRealVector.class, 1593, 74797, 74807).getEntry(j));
                    }
                }
                for (int k = 0; k < npt; k++) {
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1595, 74883, 74901)) {
                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1595, 74883, 74901);
                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1595, 74883, 74901).setEntry(k, j, BOBYQAOptimizer.ZERO);
                    }
                }
                for (int i = 0; i < ndim; i++) {
                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1598, 75000, 75006)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1598, 75000, 75006);
                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1598, 75000, 75006).setEntry(i, j, BOBYQAOptimizer.ZERO);
                    }
                }
            }
            for (int i = 0, max = (n * np) / 2; i < max; i++) {
                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1602, 75124, 75151)) {
                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1602, 75124, 75151);
                    CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1602, 75124, 75151).setEntry(i, BOBYQAOptimizer.ZERO);
                }
            }
            for (int k = 0; k < npt; k++) {
                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1605, 75234, 75265)) {
                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1605, 75234, 75265);
                    CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1605, 75234, 75265).setEntry(k, BOBYQAOptimizer.ZERO);
                }
                for (int j = 0, max = npt - np; j < max; j++) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1607, 75362, 75368)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1607, 75362, 75368);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1607, 75362, 75368).setEntry(k, j, BOBYQAOptimizer.ZERO);
                    }
                }
            }
            int ipt = CallChecker.varInit(((int) (0)), "ipt", 1615, 75669, 75680);
            int jpt = CallChecker.varInit(((int) (0)), "jpt", 1616, 75690, 75701);
            double fbeg = CallChecker.varInit(((double) (Double.NaN)), "fbeg", 1617, 75711, 75735);
            do {
                final int nfm = CallChecker.varInit(((int) (getEvaluations())), "nfm", 1619, 75762, 75794);
                final int nfx = CallChecker.varInit(((int) (nfm - n)), "nfx", 1620, 75808, 75831);
                final int nfmm = CallChecker.varInit(((int) (nfm - 1)), "nfmm", 1621, 75845, 75869);
                final int nfxm = CallChecker.varInit(((int) (nfx - 1)), "nfxm", 1622, 75883, 75907);
                double stepa = CallChecker.varInit(((double) (0)), "stepa", 1623, 75921, 75937);
                double stepb = CallChecker.varInit(((double) (0)), "stepb", 1624, 75951, 75967);
                if (nfm <= (2 * n)) {
                    if ((nfm >= 1) && (nfm <= n)) {
                        stepa = initialTrustRegionRadius;
                        CallChecker.varAssign(stepa, "stepa", 1628, 76085, 76117);
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1629, 76143, 76157)) {
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1629, 76143, 76157);
                            if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1629, 76143, 76157).getEntry(nfmm)) == (BOBYQAOptimizer.ZERO)) {
                                stepa = -stepa;
                                CallChecker.varAssign(stepa, "stepa", 1630, 76209, 76223);
                            }
                        }
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1633, 76338, 76356)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1633, 76338, 76356);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1633, 76338, 76356).setEntry(nfm, nfmm, stepa);
                        }
                    }else
                        if (nfm > n) {
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1635, 76452, 76470)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1635, 76452, 76470);
                                stepa = CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1635, 76452, 76470).getEntry(nfx, nfxm);
                                CallChecker.varAssign(stepa, "stepa", 1635, 76444, 76491);
                            }
                            stepb = -(initialTrustRegionRadius);
                            CallChecker.varAssign(stepb, "stepb", 1636, 76513, 76546);
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1637, 76572, 76586)) {
                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1637, 76572, 76586);
                                if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1637, 76572, 76586).getEntry(nfxm)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1638, 76687, 76701)) {
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1638, 76687, 76701);
                                        stepb = Math.min(((BOBYQAOptimizer.TWO) * (initialTrustRegionRadius)), CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1638, 76687, 76701).getEntry(nfxm));
                                        CallChecker.varAssign(stepb, "stepb", 1638, 76638, 76718);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1641, 76837, 76851)) {
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1641, 76837, 76851);
                                if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1641, 76837, 76851).getEntry(nfxm)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1642, 76953, 76967)) {
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1642, 76953, 76967);
                                        stepb = Math.max(((-(BOBYQAOptimizer.TWO)) * (initialTrustRegionRadius)), CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1642, 76953, 76967).getEntry(nfxm));
                                        CallChecker.varAssign(stepb, "stepb", 1642, 76903, 76984);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1645, 77099, 77117)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1645, 77099, 77117);
                                CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1645, 77099, 77117).setEntry(nfm, nfxm, stepb);
                            }
                        }
                    
                }else {
                    final int tmp1 = CallChecker.varInit(((int) ((nfm - np) / n)), "tmp1", 1648, 77202, 77233);
                    jpt = (nfm - (tmp1 * n)) - n;
                    CallChecker.varAssign(jpt, "jpt", 1649, 77251, 77275);
                    ipt = jpt + tmp1;
                    CallChecker.varAssign(ipt, "ipt", 1650, 77293, 77309);
                    if (ipt > n) {
                        final int tmp2 = CallChecker.varInit(((int) (jpt)), "tmp2", 1652, 77362, 77382);
                        jpt = ipt - n;
                        CallChecker.varAssign(jpt, "jpt", 1653, 77404, 77417);
                        ipt = tmp2;
                        CallChecker.varAssign(ipt, "ipt", 1654, 77439, 77449);
                    }
                    final int iptMinus1 = CallChecker.varInit(((int) (ipt - 1)), "iptMinus1", 1657, 77552, 77581);
                    final int jptMinus1 = CallChecker.varInit(((int) (jpt - 1)), "jptMinus1", 1658, 77599, 77628);
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77691, 77709)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77646, 77664)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77691, 77709);
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77646, 77664);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77646, 77664).setEntry(nfm, iptMinus1, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1659, 77691, 77709).getEntry(ipt, iptMinus1));
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77799, 77817)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77754, 77772)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77799, 77817);
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77754, 77772);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77754, 77772).setEntry(nfm, jptMinus1, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1660, 77799, 77817).getEntry(jpt, jptMinus1));
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(lowerBound, double[].class, 1667, 78083, 78092)) {
                        if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 1668, 78156, 78166)) {
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1668, 78182, 78200)) {
                                if (CallChecker.beforeDeref(upperBound, double[].class, 1669, 78270, 78279)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1667, 78041, 78051)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1667, 78083, 78092);
                                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1668, 78156, 78166);
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1668, 78182, 78200);
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1669, 78270, 78279);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1667, 78041, 78051);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1667, 78041, 78051).setEntry(j, Math.min(Math.max(CallChecker.isCalled(lowerBound, double[].class, 1667, 78083, 78092)[j], ((CallChecker.isCalled(originShift, ArrayRealVector.class, 1668, 78156, 78166).getEntry(j)) + (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1668, 78182, 78200).getEntry(nfm, j)))), CallChecker.isCalled(upperBound, double[].class, 1669, 78270, 78279)[j]));
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1670, 78307, 78325)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1670, 78347, 78361)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1670, 78307, 78325);
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1670, 78347, 78361);
                            if ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1670, 78307, 78325).getEntry(nfm, j)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1670, 78347, 78361).getEntry(j))) {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 1671, 78422, 78431)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1671, 78398, 78408)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1671, 78422, 78431);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1671, 78398, 78408);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1671, 78398, 78408).setEntry(j, CallChecker.isCalled(lowerBound, double[].class, 1671, 78422, 78431)[j]);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78476, 78494)) {
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1673, 78516, 78530)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78476, 78494);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1673, 78516, 78530);
                            if ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78476, 78494).getEntry(nfm, j)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1673, 78516, 78530).getEntry(j))) {
                                if (CallChecker.beforeDeref(upperBound, double[].class, 1674, 78591, 78600)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1674, 78567, 78577)) {
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1674, 78591, 78600);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1674, 78567, 78577);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1674, 78567, 78577).setEntry(j, CallChecker.isCalled(upperBound, double[].class, 1674, 78591, 78600)[j]);
                                    }
                                }
                            }
                        }
                    }
                }
                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1678, 78704, 78714);
                final double objectiveValue = CallChecker.varInit(((double) (computeObjectiveValue(CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1678, 78704, 78714).toArray()))), "objectiveValue", 1678, 78652, 78726);
                double f = CallChecker.init(double.class);
                if (isMinimize) {
                    f = objectiveValue;
                    CallChecker.varAssign(f, "f", 1679, 78757, 78801);
                }else {
                    f = -objectiveValue;
                    CallChecker.varAssign(f, "f", 1679, 78757, 78801);
                }
                final int numEval = CallChecker.varInit(((int) (getEvaluations())), "numEval", 1680, 78816, 78852);
                if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1681, 78877, 78898)) {
                    fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1681, 78877, 78898);
                    CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1681, 78877, 78898).setEntry(nfm, f);
                }
                if (numEval == 1) {
                    fbeg = f;
                    CallChecker.varAssign(fbeg, "fbeg", 1684, 78967, 78975);
                    trustRegionCenterInterpolationPointIndex = 0;
                    CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1685, 78993, 79037);
                }else
                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79066, 79087)) {
                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79066, 79087);
                        if (f < (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79066, 79087).getEntry(trustRegionCenterInterpolationPointIndex))) {
                            trustRegionCenterInterpolationPointIndex = nfm;
                            CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1687, 79159, 79205);
                        }
                    }
                
                if (numEval <= ((2 * n) + 1)) {
                    if ((numEval >= 2) && (numEval <= (n + 1))) {
                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1699, 79783, 79809)) {
                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1699, 79783, 79809);
                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1699, 79783, 79809).setEntry(nfmm, ((f - fbeg) / stepa));
                        }
                        if (npt < (numEval + n)) {
                            final double oneOverStepA = CallChecker.varInit(((double) ((BOBYQAOptimizer.ONE) / stepa)), "oneOverStepA", 1701, 79916, 79955);
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1702, 79981, 79987)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1702, 79981, 79987);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1702, 79981, 79987).setEntry(0, nfmm, (-oneOverStepA));
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1703, 80047, 80053)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1703, 80047, 80053);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1703, 80047, 80053).setEntry(nfm, nfmm, oneOverStepA);
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1704, 80114, 80120)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1704, 80114, 80120);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1704, 80114, 80120).setEntry((npt + nfmm), nfmm, ((-(BOBYQAOptimizer.HALF)) * rhosq));
                            }
                        }
                    }else
                        if (numEval >= (n + 2)) {
                            final int ih = CallChecker.varInit(((int) (((nfx * (nfx + 1)) / 2) - 1)), "ih", 1708, 80325, 80363);
                            final double tmp = CallChecker.varInit(((double) ((f - fbeg) / stepb)), "tmp", 1709, 80385, 80422);
                            final double diff = CallChecker.varInit(((double) (stepb - stepa)), "diff", 1710, 80444, 80477);
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1711, 80554, 80580)) {
                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1711, 80499, 80526)) {
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1711, 80554, 80580);
                                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1711, 80499, 80526);
                                    CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1711, 80499, 80526).setEntry(ih, (((BOBYQAOptimizer.TWO) * (tmp - (CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1711, 80554, 80580).getEntry(nfxm)))) / diff));
                                }
                            }
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80671, 80697)) {
                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80627, 80653)) {
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80671, 80697);
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80627, 80653);
                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80627, 80653).setEntry(nfxm, ((((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1712, 80671, 80697).getEntry(nfxm)) * stepb) - (tmp * stepa)) / diff));
                                }
                            }
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1713, 80798, 80819)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1713, 80798, 80819);
                                if (((stepa * stepb) < (BOBYQAOptimizer.ZERO)) && (f < (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1713, 80798, 80819).getEntry((nfm - n))))) {
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80903, 80924)) {
                                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80866, 80887)) {
                                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80903, 80924);
                                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80866, 80887);
                                            CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80866, 80887).setEntry(nfm, CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1714, 80903, 80924).getEntry((nfm - n)));
                                        }
                                    }
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1715, 80970, 80991)) {
                                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1715, 80970, 80991);
                                        CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1715, 80970, 80991).setEntry((nfm - n), f);
                                    }
                                    if ((trustRegionCenterInterpolationPointIndex) == nfm) {
                                        trustRegionCenterInterpolationPointIndex = nfm - n;
                                        CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1717, 81122, 81172);
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1719, 81224, 81242)) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1719, 81224, 81242);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1719, 81224, 81242).setEntry((nfm - n), nfxm, stepb);
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1720, 81300, 81318)) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1720, 81300, 81318);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1720, 81300, 81318).setEntry(nfm, nfxm, stepa);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1722, 81390, 81396)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1722, 81390, 81396);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1722, 81390, 81396).setEntry(0, nfxm, ((-(stepa + stepb)) / (stepa * stepb)));
                            }
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1723, 81509, 81527)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1723, 81473, 81479)) {
                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1723, 81509, 81527);
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1723, 81473, 81479);
                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1723, 81473, 81479).setEntry(nfm, nfxm, ((-(BOBYQAOptimizer.HALF)) / (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1723, 81509, 81527).getEntry((nfm - n), nfxm))));
                                }
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1725, 81642, 81648)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1725, 81670, 81676)) {
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1724, 81575, 81581)) {
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1725, 81642, 81648);
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1725, 81670, 81676);
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1724, 81575, 81581);
                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1724, 81575, 81581).setEntry((nfm - n), nfxm, ((-(CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1725, 81642, 81648).getEntry(0, nfxm))) - (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1725, 81670, 81676).getEntry(nfm, nfxm))));
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1726, 81720, 81726)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1726, 81720, 81726);
                                CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1726, 81720, 81726).setEntry(0, nfxm, ((Math.sqrt(BOBYQAOptimizer.TWO)) / (stepa * stepb)));
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1727, 81801, 81807)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1727, 81801, 81807);
                                CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1727, 81801, 81807).setEntry(nfm, nfxm, ((Math.sqrt(BOBYQAOptimizer.HALF)) / rhosq));
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1730, 82063, 82069)) {
                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1730, 82091, 82097)) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1729, 81996, 82002)) {
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1730, 82063, 82069);
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1730, 82091, 82097);
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1729, 81996, 82002);
                                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1729, 81996, 82002).setEntry((nfm - n), nfxm, ((-(CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1730, 82063, 82069).getEntry(0, nfxm))) - (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1730, 82091, 82097).getEntry(nfm, nfxm))));
                                    }
                                }
                            }
                        }
                    
                }else {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1737, 82315, 82321)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1737, 82315, 82321);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1737, 82315, 82321).setEntry(0, nfxm, recip);
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1738, 82365, 82371)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1738, 82365, 82371);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1738, 82365, 82371).setEntry(nfm, nfxm, recip);
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1739, 82417, 82423)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1739, 82417, 82423);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1739, 82417, 82423).setEntry(ipt, nfxm, (-recip));
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1740, 82470, 82476)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1740, 82470, 82476);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1740, 82470, 82476).setEntry(jpt, nfxm, (-recip));
                    }
                    final int ih = CallChecker.varInit(((int) ((((ipt * (ipt - 1)) / 2) + jpt) - 1)), "ih", 1742, 82524, 82568);
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1743, 82605, 82623);
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1743, 82650, 82668);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1743, 82605, 82623).getEntry(nfm, (ipt - 1))) * (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1743, 82650, 82668).getEntry(nfm, (jpt - 1))))), "tmp", 1743, 82586, 82692);
                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82760, 82781)) {
                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82799, 82820)) {
                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1744, 82710, 82737)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82760, 82781);
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82799, 82820);
                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1744, 82710, 82737);
                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1744, 82710, 82737).setEntry(ih, ((((fbeg - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82760, 82781).getEntry(ipt))) - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1744, 82799, 82820).getEntry(jpt))) + f) / tmp));
                            }
                        }
                    }
                }
            } while ((getEvaluations()) < npt );
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4547.methodEnd();
        }
    }

    private double[] trsbox(double delta, ArrayRealVector gnew, ArrayRealVector xbdi, ArrayRealVector s, ArrayRealVector hs, ArrayRealVector hred) {
        MethodContext _bcornu_methode_context4548 = new MethodContext(double[].class, 1797, 82990, 104787);
        try {
            CallChecker.varInit(this, "this", 1797, 82990, 104787);
            CallChecker.varInit(hred, "hred", 1797, 82990, 104787);
            CallChecker.varInit(hs, "hs", 1797, 82990, 104787);
            CallChecker.varInit(s, "s", 1797, 82990, 104787);
            CallChecker.varInit(xbdi, "xbdi", 1797, 82990, 104787);
            CallChecker.varInit(gnew, "gnew", 1797, 82990, 104787);
            CallChecker.varInit(delta, "delta", 1797, 82990, 104787);
            CallChecker.varInit(this.iterations, "iterations", 1797, 82990, 104787);
            CallChecker.varInit(this.evaluations, "evaluations", 1797, 82990, 104787);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1797, 82990, 104787);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1797, 82990, 104787);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1797, 82990, 104787);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1797, 82990, 104787);
            CallChecker.varInit(this.newPoint, "newPoint", 1797, 82990, 104787);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1797, 82990, 104787);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1797, 82990, 104787);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1797, 82990, 104787);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1797, 82990, 104787);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1797, 82990, 104787);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1797, 82990, 104787);
            CallChecker.varInit(this.originShift, "originShift", 1797, 82990, 104787);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1797, 82990, 104787);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1797, 82990, 104787);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1797, 82990, 104787);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1797, 82990, 104787);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1797, 82990, 104787);
            CallChecker.varInit(this.currentBest, "currentBest", 1797, 82990, 104787);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1797, 82990, 104787);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1797, 82990, 104787);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1797, 82990, 104787);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1797, 82990, 104787);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1797, 82990, 104787);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 1797, 82990, 104787);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 1797, 82990, 104787);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 1797, 82990, 104787);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 1797, 82990, 104787);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 1797, 82990, 104787);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1797, 82990, 104787);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 1797, 82990, 104787);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 1797, 82990, 104787);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 1797, 82990, 104787);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 1797, 82990, 104787);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 1797, 82990, 104787);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1797, 82990, 104787);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1797, 82990, 104787);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1797, 82990, 104787);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1807, 86243, 86253);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1807, 86243, 86253).getDimension())), "n", 1807, 86229, 86269);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1808, 86279, 86322);
            double dsq = CallChecker.varInit(((double) (Double.NaN)), "dsq", 1810, 86333, 86356);
            double crvmin = CallChecker.varInit(((double) (Double.NaN)), "crvmin", 1811, 86366, 86392);
            double ds = CallChecker.init(double.class);
            int iu = CallChecker.init(int.class);
            double dhd = CallChecker.init(double.class);
            double dhs = CallChecker.init(double.class);
            double cth = CallChecker.init(double.class);
            double shs = CallChecker.init(double.class);
            double sth = CallChecker.init(double.class);
            double ssq = CallChecker.init(double.class);
            double beta = CallChecker.varInit(((double) (0)), "beta", 1816, 86465, 86520);
            double sdec = CallChecker.init(double.class);
            double blen = CallChecker.init(double.class);
            int iact = CallChecker.varInit(((int) (-1)), "iact", 1817, 86530, 86543);
            int nact = CallChecker.varInit(((int) (0)), "nact", 1818, 86553, 86565);
            double angt = CallChecker.varInit(((double) (0)), "angt", 1819, 86575, 86596);
            double qred = CallChecker.init(double.class);
            int isav = CallChecker.init(int.class);
            double temp = CallChecker.varInit(((double) (0)), "temp", 1821, 86624, 86692);
            double xsav = CallChecker.varInit(((double) (0)), "xsav", 1821, 86624, 86692);
            double xsum = CallChecker.varInit(((double) (0)), "xsum", 1821, 86624, 86692);
            double angbd = CallChecker.varInit(((double) (0)), "angbd", 1821, 86624, 86692);
            double dredg = CallChecker.varInit(((double) (0)), "dredg", 1821, 86624, 86692);
            double sredg = CallChecker.varInit(((double) (0)), "sredg", 1821, 86624, 86692);
            int iterc = CallChecker.init(int.class);
            double resid = CallChecker.varInit(((double) (0)), "resid", 1823, 86721, 86849);
            double delsq = CallChecker.varInit(((double) (0)), "delsq", 1823, 86721, 86849);
            double ggsav = CallChecker.varInit(((double) (0)), "ggsav", 1823, 86721, 86849);
            double tempa = CallChecker.varInit(((double) (0)), "tempa", 1823, 86721, 86849);
            double tempb = CallChecker.varInit(((double) (0)), "tempb", 1823, 86721, 86849);
            double redmax = CallChecker.varInit(((double) (0)), "redmax", 1824, 86721, 86849);
            double dredsq = CallChecker.varInit(((double) (0)), "dredsq", 1824, 86721, 86849);
            double redsav = CallChecker.varInit(((double) (0)), "redsav", 1824, 86721, 86849);
            double gredsq = CallChecker.varInit(((double) (0)), "gredsq", 1824, 86721, 86849);
            double rednew = CallChecker.varInit(((double) (0)), "rednew", 1824, 86721, 86849);
            int itcsav = CallChecker.varInit(((int) (0)), "itcsav", 1825, 86859, 86873);
            double rdprev = CallChecker.varInit(((double) (0)), "rdprev", 1826, 86883, 86936);
            double rdnext = CallChecker.varInit(((double) (0)), "rdnext", 1826, 86883, 86936);
            double stplen = CallChecker.varInit(((double) (0)), "stplen", 1826, 86883, 86936);
            double stepsq = CallChecker.varInit(((double) (0)), "stepsq", 1826, 86883, 86936);
            int itermax = CallChecker.varInit(((int) (0)), "itermax", 1827, 86946, 86961);
            iterc = 0;
            CallChecker.varAssign(iterc, "iterc", 1840, 87514, 87523);
            nact = 0;
            CallChecker.varAssign(nact, "nact", 1841, 87533, 87541);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1843, 87593, 87596)) {
                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1843, 87593, 87596);
                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 1843, 87593, 87596).setEntry(i, BOBYQAOptimizer.ZERO);
                }
                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1844, 87633, 87655)) {
                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1844, 87672, 87686)) {
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1844, 87633, 87655);
                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1844, 87672, 87686);
                        if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1844, 87633, 87655).getEntry(i)) <= (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1844, 87672, 87686).getEntry(i))) {
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1845, 87723, 87749)) {
                                gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1845, 87723, 87749);
                                if ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1845, 87723, 87749).getEntry(i)) >= (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1846, 87794, 87797)) {
                                        xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1846, 87794, 87797);
                                        CallChecker.isCalled(xbdi, ArrayRealVector.class, 1846, 87794, 87797).setEntry(i, BOBYQAOptimizer.MINUS_ONE);
                                    }
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1848, 87864, 87886)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1848, 87903, 87917)) {
                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1849, 87954, 87980)) {
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1848, 87864, 87886);
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1848, 87903, 87917);
                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1849, 87954, 87980);
                                        if (((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1848, 87864, 87886).getEntry(i)) >= (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1848, 87903, 87917).getEntry(i))) && ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1849, 87954, 87980).getEntry(i)) <= (BOBYQAOptimizer.ZERO))) {
                                            if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1850, 88021, 88024)) {
                                                xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1850, 88021, 88024);
                                                CallChecker.isCalled(xbdi, ArrayRealVector.class, 1850, 88021, 88024).setEntry(i, BOBYQAOptimizer.ONE);
                                            }
                                        }
                                    }
                                }
                            }
                        
                    }
                }
                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1852, 88074, 88077)) {
                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1852, 88074, 88077);
                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1852, 88074, 88077).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                        ++nact;
                    }
                }
                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1855, 88152, 88165)) {
                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1855, 88152, 88165);
                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1855, 88152, 88165).setEntry(i, BOBYQAOptimizer.ZERO);
                }
                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1856, 88215, 88241)) {
                    if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1856, 88198, 88201)) {
                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1856, 88215, 88241);
                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1856, 88198, 88201);
                        CallChecker.isCalled(gnew, ArrayRealVector.class, 1856, 88198, 88201).setEntry(i, CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1856, 88215, 88241).getEntry(i));
                    }
                }
            }
            delsq = delta * delta;
            CallChecker.varAssign(delsq, "delsq", 1858, 88275, 88296);
            qred = BOBYQAOptimizer.ZERO;
            CallChecker.varAssign(qred, "qred", 1859, 88306, 88317);
            crvmin = BOBYQAOptimizer.MINUS_ONE;
            CallChecker.varAssign(crvmin, "crvmin", 1860, 88327, 88345);
            int state = CallChecker.varInit(((int) (20)), "state", 1868, 88753, 88767);
            for (; ;) {
                switch (state) {
                    case 20 :
                        {
                            BOBYQAOptimizer.printState(20);
                            beta = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(beta, "beta", 1873, 88882, 88893);
                        }
                    case 30 :
                        {
                            BOBYQAOptimizer.printState(30);
                            stepsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(stepsq, "stepsq", 1877, 88971, 88984);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1879, 89048, 89051)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1879, 89048, 89051);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1879, 89048, 89051).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1880, 89096, 89096)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1880, 89096, 89096);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 1880, 89096, 89096).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }else
                                        if (beta == (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1882, 89195, 89198)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1882, 89180, 89180)) {
                                                    gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1882, 89195, 89198);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1882, 89180, 89180);
                                                    CallChecker.isCalled(s, ArrayRealVector.class, 1882, 89180, 89180).setEntry(i, (-(CallChecker.isCalled(gnew, ArrayRealVector.class, 1882, 89195, 89198).getEntry(i))));
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1884, 89280, 89280)) {
                                                if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1884, 89296, 89299)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1884, 89259, 89259)) {
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1884, 89280, 89280);
                                                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1884, 89296, 89299);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1884, 89259, 89259);
                                                        CallChecker.isCalled(s, ArrayRealVector.class, 1884, 89259, 89259).setEntry(i, ((beta * (CallChecker.isCalled(s, ArrayRealVector.class, 1884, 89280, 89280).getEntry(i))) - (CallChecker.isCalled(gnew, ArrayRealVector.class, 1884, 89296, 89299).getEntry(i))));
                                                    }
                                                }
                                            }
                                        }
                                    
                                }
                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1887, 89406, 89406);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(s, ArrayRealVector.class, 1887, 89406, 89406).getEntry(i))), "d1", 1887, 89349, 89419);
                                stepsq += d1 * d1;
                                CallChecker.varAssign(stepsq, "stepsq", 1888, 89437, 89454);
                            }
                            if (stepsq == (BOBYQAOptimizer.ZERO)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 1891, 89520, 89531);
                                break;
                            }
                            if (beta == (BOBYQAOptimizer.ZERO)) {
                                gredsq = stepsq;
                                CallChecker.varAssign(gredsq, "gredsq", 1894, 89602, 89617);
                                itermax = (iterc + n) - nact;
                                CallChecker.varAssign(itermax, "itermax", 1895, 89635, 89661);
                            }
                            if ((gredsq * delsq) <= ((qred * 1.0E-4) * qred)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 1898, 89749, 89760);
                                break;
                            }
                            state = 210;
                            CallChecker.varAssign(state, "state", 1906, 90112, 90123);
                            break;
                        }
                    case 50 :
                        {
                            BOBYQAOptimizer.printState(50);
                            resid = delsq;
                            CallChecker.varAssign(resid, "resid", 1910, 90208, 90221);
                            ds = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(ds, "ds", 1911, 90235, 90244);
                            shs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(shs, "shs", 1912, 90258, 90268);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1914, 90332, 90335)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1914, 90332, 90335);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1914, 90332, 90335).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1916, 90441, 90454);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 1916, 90441, 90454).getEntry(i))), "d1", 1916, 90380, 90467);
                                        resid -= d1 * d1;
                                        CallChecker.varAssign(resid, "resid", 1917, 90489, 90505);
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1918, 90533, 90533)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1918, 90549, 90562)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1918, 90533, 90533);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1918, 90549, 90562);
                                                ds += (CallChecker.isCalled(s, ArrayRealVector.class, 1918, 90533, 90533).getEntry(i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1918, 90549, 90562).getEntry(i));
                                                CallChecker.varAssign(ds, "ds", 1918, 90527, 90575);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1919, 90604, 90604)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 1919, 90620, 90621)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1919, 90604, 90604);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 1919, 90620, 90621);
                                                shs += (CallChecker.isCalled(s, ArrayRealVector.class, 1919, 90604, 90604).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 1919, 90620, 90621).getEntry(i));
                                                CallChecker.varAssign(shs, "shs", 1919, 90597, 90634);
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            if (resid <= (BOBYQAOptimizer.ZERO)) {
                                state = 90;
                                CallChecker.varAssign(state, "state", 1923, 90717, 90727);
                                break;
                            }
                            temp = Math.sqrt(((stepsq * resid) + (ds * ds)));
                            CallChecker.varAssign(temp, "temp", 1925, 90762, 90804);
                            if (ds < (BOBYQAOptimizer.ZERO)) {
                                blen = (temp - ds) / stepsq;
                                CallChecker.varAssign(blen, "blen", 1927, 90851, 90878);
                            }else {
                                blen = resid / (temp + ds);
                                CallChecker.varAssign(blen, "blen", 1929, 90917, 90943);
                            }
                            stplen = blen;
                            CallChecker.varAssign(stplen, "stplen", 1931, 90971, 90984);
                            if (shs > (BOBYQAOptimizer.ZERO)) {
                                stplen = Math.min(blen, (gredsq / shs));
                                CallChecker.varAssign(stplen, "stplen", 1934, 91065, 91102);
                            }
                            iact = -1;
                            CallChecker.varAssign(iact, "iact", 1940, 91288, 91297);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1942, 91361, 91361)) {
                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1942, 91361, 91361);
                                    if ((CallChecker.isCalled(s, ArrayRealVector.class, 1942, 91361, 91361).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1943, 91413, 91435)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1943, 91451, 91464)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1943, 91413, 91435);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1943, 91451, 91464);
                                                xsum = (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1943, 91413, 91435).getEntry(i)) + (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1943, 91451, 91464).getEntry(i));
                                                CallChecker.varAssign(xsum, "xsum", 1943, 91406, 91477);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1944, 91503, 91503)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1944, 91503, 91503);
                                            if ((CallChecker.isCalled(s, ArrayRealVector.class, 1944, 91503, 91503).getEntry(i)) > (BOBYQAOptimizer.ZERO)) {
                                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1945, 91559, 91573)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1945, 91597, 91597)) {
                                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1945, 91559, 91573);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1945, 91597, 91597);
                                                        temp = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1945, 91559, 91573).getEntry(i)) - xsum) / (CallChecker.isCalled(s, ArrayRealVector.class, 1945, 91597, 91597).getEntry(i));
                                                        CallChecker.varAssign(temp, "temp", 1945, 91551, 91610);
                                                    }
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1947, 91673, 91687)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1947, 91711, 91711)) {
                                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1947, 91673, 91687);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1947, 91711, 91711);
                                                        temp = ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1947, 91673, 91687).getEntry(i)) - xsum) / (CallChecker.isCalled(s, ArrayRealVector.class, 1947, 91711, 91711).getEntry(i));
                                                        CallChecker.varAssign(temp, "temp", 1947, 91665, 91724);
                                                    }
                                                }
                                            }
                                        }
                                        if (temp < stplen) {
                                            stplen = temp;
                                            CallChecker.varAssign(stplen, "stplen", 1950, 91813, 91826);
                                            iact = i;
                                            CallChecker.varAssign(iact, "iact", 1951, 91852, 91860);
                                        }
                                    }
                                }
                            }
                            sdec = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(sdec, "sdec", 1958, 92015, 92026);
                            if (stplen > (BOBYQAOptimizer.ZERO)) {
                                ++iterc;
                                temp = shs / stepsq;
                                CallChecker.varAssign(temp, "temp", 1961, 92102, 92121);
                                if ((iact == (-1)) && (temp > (BOBYQAOptimizer.ZERO))) {
                                    crvmin = Math.min(crvmin, temp);
                                    CallChecker.varAssign(crvmin, "crvmin", 1963, 92192, 92222);
                                    if (crvmin == (BOBYQAOptimizer.MINUS_ONE)) {
                                        crvmin = temp;
                                        CallChecker.varAssign(crvmin, "crvmin", 1965, 92295, 92308);
                                    }
                                }
                                ggsav = gredsq;
                                CallChecker.varAssign(ggsav, "ggsav", 1968, 92366, 92380);
                                gredsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(gredsq, "gredsq", 1969, 92398, 92411);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1971, 92496, 92499)) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 1971, 92524, 92525)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1971, 92479, 92482)) {
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1971, 92496, 92499);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 1971, 92524, 92525);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1971, 92479, 92482);
                                                CallChecker.isCalled(gnew, ArrayRealVector.class, 1971, 92479, 92482).setEntry(i, ((CallChecker.isCalled(gnew, ArrayRealVector.class, 1971, 92496, 92499).getEntry(i)) + (stplen * (CallChecker.isCalled(hs, ArrayRealVector.class, 1971, 92524, 92525).getEntry(i)))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1972, 92565, 92568)) {
                                        xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1972, 92565, 92568);
                                        if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1972, 92565, 92568).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                            gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1974, 92682, 92685);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(gnew, ArrayRealVector.class, 1974, 92682, 92685).getEntry(i))), "d1", 1974, 92617, 92698);
                                            gredsq += d1 * d1;
                                            CallChecker.varAssign(gredsq, "gredsq", 1975, 92724, 92741);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1977, 92812, 92825)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1977, 92850, 92850)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1977, 92785, 92798)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1977, 92812, 92825);
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1977, 92850, 92850);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1977, 92785, 92798);
                                                CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1977, 92785, 92798).setEntry(i, ((CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1977, 92812, 92825).getEntry(i)) + (stplen * (CallChecker.isCalled(s, ArrayRealVector.class, 1977, 92850, 92850).getEntry(i)))));
                                            }
                                        }
                                    }
                                }
                                final double d1 = CallChecker.varInit(((double) (stplen * (ggsav - (((BOBYQAOptimizer.HALF) * stplen) * shs)))), "d1", 1980, 92900, 92989);
                                sdec = Math.max(d1, BOBYQAOptimizer.ZERO);
                                CallChecker.varAssign(sdec, "sdec", 1981, 93007, 93032);
                                qred += sdec;
                                CallChecker.varAssign(qred, "qred", 1982, 93050, 93062);
                            }
                            if (iact >= 0) {
                                ++nact;
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1989, 93229, 93232)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1989, 93229, 93232);
                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 1989, 93229, 93232).setEntry(iact, BOBYQAOptimizer.ONE);
                                }
                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1990, 93275, 93275)) {
                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1990, 93275, 93275);
                                    if ((CallChecker.isCalled(s, ArrayRealVector.class, 1990, 93275, 93275).getEntry(iact)) < (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1991, 93322, 93325)) {
                                            xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1991, 93322, 93325);
                                            CallChecker.isCalled(xbdi, ArrayRealVector.class, 1991, 93322, 93325).setEntry(iact, BOBYQAOptimizer.MINUS_ONE);
                                        }
                                    }
                                }
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1994, 93445, 93458);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 1994, 93445, 93458).getEntry(iact))), "d1", 1994, 93388, 93474);
                                delsq -= d1 * d1;
                                CallChecker.varAssign(delsq, "delsq", 1995, 93492, 93508);
                                if (delsq <= (BOBYQAOptimizer.ZERO)) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 1997, 93567, 93578);
                                    break;
                                }
                                state = 20;
                                CallChecker.varAssign(state, "state", 1999, 93621, 93631);
                                break;
                            }
                            if (stplen < blen) {
                                if (iterc == itermax) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 2007, 93874, 93885);
                                    break;
                                }
                                if (sdec <= (qred * 0.01)) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 2010, 93974, 93985);
                                    break;
                                }
                                beta = gredsq / ggsav;
                                CallChecker.varAssign(beta, "beta", 2012, 94028, 94049);
                                state = 30;
                                CallChecker.varAssign(state, "state", 2013, 94067, 94077);
                                break;
                            }
                        }
                    case 90 :
                        {
                            BOBYQAOptimizer.printState(90);
                            crvmin = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(crvmin, "crvmin", 2018, 94176, 94189);
                        }
                    case 100 :
                        {
                            BOBYQAOptimizer.printState(100);
                            if (nact >= (n - 1)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2028, 94541, 94552);
                                break;
                            }
                            dredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredsq, "dredsq", 2030, 94587, 94600);
                            dredg = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredg, "dredg", 2031, 94614, 94626);
                            gredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(gredsq, "gredsq", 2032, 94640, 94653);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2034, 94717, 94720)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2034, 94717, 94720);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2034, 94717, 94720).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        double d1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2036, 94820, 94833)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2036, 94820, 94833);
                                            d1 = CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2036, 94820, 94833).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2036, 94820, 94833);
                                        }
                                        dredsq += d1 * d1;
                                        CallChecker.varAssign(dredsq, "dredsq", 2037, 94868, 94885);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2038, 94916, 94929)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2038, 94945, 94948)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2038, 94916, 94929);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2038, 94945, 94948);
                                                dredg += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2038, 94916, 94929).getEntry(i)) * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2038, 94945, 94948).getEntry(i));
                                                CallChecker.varAssign(dredg, "dredg", 2038, 94907, 94961);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2040, 95031, 95034)) {
                                            gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2040, 95031, 95034);
                                            d1 = CallChecker.isCalled(gnew, ArrayRealVector.class, 2040, 95031, 95034).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2040, 95026, 95047);
                                        }
                                        gredsq += d1 * d1;
                                        CallChecker.varAssign(gredsq, "gredsq", 2041, 95069, 95086);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2042, 95122, 95135)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2042, 95108, 95108)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2042, 95122, 95135);
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2042, 95108, 95108);
                                                CallChecker.isCalled(s, ArrayRealVector.class, 2042, 95108, 95108).setEntry(i, CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2042, 95122, 95135).getEntry(i));
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2044, 95196, 95196)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2044, 95196, 95196);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 2044, 95196, 95196).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            itcsav = iterc;
                            CallChecker.varAssign(itcsav, "itcsav", 2047, 95261, 95275);
                            state = 210;
                            CallChecker.varAssign(state, "state", 2048, 95289, 95300);
                            break;
                        }
                    case 120 :
                        {
                            BOBYQAOptimizer.printState(120);
                            ++iterc;
                            temp = (gredsq * dredsq) - (dredg * dredg);
                            CallChecker.varAssign(temp, "temp", 2055, 95561, 95599);
                            if (temp <= ((qred * 1.0E-4) * qred)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2057, 95663, 95674);
                                break;
                            }
                            temp = Math.sqrt(temp);
                            CallChecker.varAssign(temp, "temp", 2059, 95709, 95731);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2061, 95795, 95798)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2061, 95795, 95798);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2061, 95795, 95798).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2062, 95866, 95879)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2062, 95904, 95907)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2062, 95843, 95843)) {
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2062, 95866, 95879);
                                                    gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2062, 95904, 95907);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2062, 95843, 95843);
                                                    CallChecker.isCalled(s, ArrayRealVector.class, 2062, 95843, 95843).setEntry(i, (((dredg * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2062, 95866, 95879).getEntry(i))) - (dredsq * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2062, 95904, 95907).getEntry(i)))) / temp));
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2064, 95976, 95976)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2064, 95976, 95976);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 2064, 95976, 95976).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }
                                }
                            }
                            sredg = -temp;
                            CallChecker.varAssign(sredg, "sredg", 2067, 96041, 96054);
                            angbd = BOBYQAOptimizer.ONE;
                            CallChecker.varAssign(angbd, "angbd", 2074, 96408, 96419);
                            iact = -1;
                            CallChecker.varAssign(iact, "iact", 2075, 96433, 96442);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2077, 96506, 96509)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2077, 96506, 96509);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2077, 96506, 96509).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2078, 96562, 96584)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2078, 96600, 96613)) {
                                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2078, 96629, 96643)) {
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2078, 96562, 96584);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2078, 96600, 96613);
                                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2078, 96629, 96643);
                                                    tempa = ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2078, 96562, 96584).getEntry(i)) + (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2078, 96600, 96613).getEntry(i))) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2078, 96629, 96643).getEntry(i));
                                                    CallChecker.varAssign(tempa, "tempa", 2078, 96554, 96656);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2079, 96686, 96700)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2079, 96716, 96738)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2079, 96754, 96767)) {
                                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2079, 96686, 96700);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2079, 96716, 96738);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2079, 96754, 96767);
                                                    tempb = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2079, 96686, 96700).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2079, 96716, 96738).getEntry(i))) - (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2079, 96754, 96767).getEntry(i));
                                                    CallChecker.varAssign(tempb, "tempb", 2079, 96678, 96780);
                                                }
                                            }
                                        }
                                        if (tempa <= (BOBYQAOptimizer.ZERO)) {
                                            ++nact;
                                            if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2082, 96879, 96882)) {
                                                xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2082, 96879, 96882);
                                                CallChecker.isCalled(xbdi, ArrayRealVector.class, 2082, 96879, 96882).setEntry(i, BOBYQAOptimizer.MINUS_ONE);
                                            }
                                            state = 100;
                                            CallChecker.varAssign(state, "state", 2083, 96932, 96943);
                                            break;
                                        }else
                                            if (tempb <= (BOBYQAOptimizer.ZERO)) {
                                                ++nact;
                                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2086, 97056, 97059)) {
                                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2086, 97056, 97059);
                                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 2086, 97056, 97059).setEntry(i, BOBYQAOptimizer.ONE);
                                                }
                                                state = 100;
                                                CallChecker.varAssign(state, "state", 2087, 97103, 97114);
                                                break;
                                            }
                                        
                                        double d1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2090, 97220, 97233)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2090, 97220, 97233);
                                            d1 = CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2090, 97220, 97233).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2090, 97220, 97233);
                                        }
                                        double d2 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2092, 97323, 97323)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2092, 97323, 97323);
                                            d2 = CallChecker.isCalled(s, ArrayRealVector.class, 2092, 97323, 97323).getEntry(i);
                                            CallChecker.varAssign(d2, "d2", 2092, 97323, 97323);
                                        }
                                        ssq = (d1 * d1) + (d2 * d2);
                                        CallChecker.varAssign(ssq, "ssq", 2093, 97358, 97381);
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2095, 97451, 97473)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2095, 97489, 97503)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2095, 97451, 97473);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2095, 97489, 97503);
                                                d1 = (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2095, 97451, 97473).getEntry(i)) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2095, 97489, 97503).getEntry(i));
                                                CallChecker.varAssign(d1, "d1", 2095, 97446, 97516);
                                            }
                                        }
                                        temp = ssq - (d1 * d1);
                                        CallChecker.varAssign(temp, "temp", 2096, 97538, 97558);
                                        if (temp > (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2098, 97648, 97648)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2098, 97648, 97648);
                                                temp = (Math.sqrt(temp)) - (CallChecker.isCalled(s, ArrayRealVector.class, 2098, 97648, 97648).getEntry(i));
                                                CallChecker.varAssign(temp, "temp", 2098, 97623, 97661);
                                            }
                                            if ((angbd * temp) > tempa) {
                                                angbd = tempa / temp;
                                                CallChecker.varAssign(angbd, "angbd", 2100, 97743, 97763);
                                                iact = i;
                                                CallChecker.varAssign(iact, "iact", 2101, 97793, 97801);
                                                xsav = BOBYQAOptimizer.MINUS_ONE;
                                                CallChecker.varAssign(xsav, "xsav", 2102, 97831, 97847);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2106, 97965, 97979)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2106, 97995, 98017)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2106, 97965, 97979);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2106, 97995, 98017);
                                                d1 = (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2106, 97965, 97979).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2106, 97995, 98017).getEntry(i));
                                                CallChecker.varAssign(d1, "d1", 2106, 97960, 98030);
                                            }
                                        }
                                        temp = ssq - (d1 * d1);
                                        CallChecker.varAssign(temp, "temp", 2107, 98052, 98072);
                                        if (temp > (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2109, 98162, 98162)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2109, 98162, 98162);
                                                temp = (Math.sqrt(temp)) + (CallChecker.isCalled(s, ArrayRealVector.class, 2109, 98162, 98162).getEntry(i));
                                                CallChecker.varAssign(temp, "temp", 2109, 98137, 98175);
                                            }
                                            if ((angbd * temp) > tempb) {
                                                angbd = tempb / temp;
                                                CallChecker.varAssign(angbd, "angbd", 2111, 98257, 98277);
                                                iact = i;
                                                CallChecker.varAssign(iact, "iact", 2112, 98307, 98315);
                                                xsav = BOBYQAOptimizer.ONE;
                                                CallChecker.varAssign(xsav, "xsav", 2113, 98345, 98355);
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            state = 210;
                            CallChecker.varAssign(state, "state", 2121, 98531, 98542);
                            break;
                        }
                    case 150 :
                        {
                            BOBYQAOptimizer.printState(150);
                            shs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(shs, "shs", 2125, 98629, 98639);
                            dhs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dhs, "dhs", 2126, 98653, 98663);
                            dhd = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dhd, "dhd", 2127, 98677, 98687);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2129, 98751, 98754)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2129, 98751, 98754);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2129, 98751, 98754).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2130, 98806, 98806)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2130, 98822, 98823)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2130, 98806, 98806);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2130, 98822, 98823);
                                                shs += (CallChecker.isCalled(s, ArrayRealVector.class, 2130, 98806, 98806).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 2130, 98822, 98823).getEntry(i));
                                                CallChecker.varAssign(shs, "shs", 2130, 98799, 98836);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2131, 98865, 98878)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2131, 98894, 98895)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2131, 98865, 98878);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2131, 98894, 98895);
                                                dhs += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2131, 98865, 98878).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 2131, 98894, 98895).getEntry(i));
                                                CallChecker.varAssign(dhs, "dhs", 2131, 98858, 98908);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2132, 98937, 98950)) {
                                            if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2132, 98966, 98969)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2132, 98937, 98950);
                                                hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2132, 98966, 98969);
                                                dhd += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2132, 98937, 98950).getEntry(i)) * (CallChecker.isCalled(hred, ArrayRealVector.class, 2132, 98966, 98969).getEntry(i));
                                                CallChecker.varAssign(dhd, "dhd", 2132, 98930, 98982);
                                            }
                                        }
                                    }
                                }
                            }
                            redmax = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(redmax, "redmax", 2140, 99241, 99254);
                            isav = -1;
                            CallChecker.varAssign(isav, "isav", 2141, 99268, 99277);
                            redsav = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(redsav, "redsav", 2142, 99291, 99304);
                            iu = ((int) ((angbd * 17.0) + 3.1));
                            CallChecker.varAssign(iu, "iu", 2143, 99318, 99348);
                            for (int i = 0; i < iu; i++) {
                                angt = (angbd * i) / iu;
                                CallChecker.varAssign(angt, "angt", 2145, 99409, 99430);
                                sth = (angt + angt) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                                CallChecker.varAssign(sth, "sth", 2146, 99448, 99489);
                                temp = shs + (angt * (((angt * dhd) - dhs) - dhs));
                                CallChecker.varAssign(temp, "temp", 2147, 99507, 99551);
                                rednew = sth * (((angt * dredg) - sredg) - (((BOBYQAOptimizer.HALF) * sth) * temp));
                                CallChecker.varAssign(rednew, "rednew", 2148, 99569, 99626);
                                if (rednew > redmax) {
                                    redmax = rednew;
                                    CallChecker.varAssign(redmax, "redmax", 2150, 99687, 99702);
                                    isav = i;
                                    CallChecker.varAssign(isav, "isav", 2151, 99724, 99732);
                                    rdprev = redsav;
                                    CallChecker.varAssign(rdprev, "rdprev", 2152, 99754, 99769);
                                }else
                                    if (i == (isav + 1)) {
                                        rdnext = rednew;
                                        CallChecker.varAssign(rdnext, "rdnext", 2154, 99835, 99850);
                                    }
                                
                                redsav = rednew;
                                CallChecker.varAssign(redsav, "redsav", 2156, 99886, 99901);
                            }
                            if (isav < 0) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2163, 100124, 100135);
                                break;
                            }
                            if (isav < iu) {
                                temp = (rdnext - rdprev) / (((redmax + redmax) - rdprev) - rdnext);
                                CallChecker.varAssign(temp, "temp", 2166, 100203, 100265);
                                angt = (angbd * (isav + ((BOBYQAOptimizer.HALF) * temp))) / iu;
                                CallChecker.varAssign(angt, "angt", 2167, 100283, 100323);
                            }
                            cth = ((BOBYQAOptimizer.ONE) - (angt * angt)) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                            CallChecker.varAssign(cth, "cth", 2169, 100351, 100398);
                            sth = (angt + angt) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                            CallChecker.varAssign(sth, "sth", 2170, 100412, 100453);
                            temp = shs + (angt * (((angt * dhd) - dhs) - dhs));
                            CallChecker.varAssign(temp, "temp", 2171, 100467, 100511);
                            sdec = sth * (((angt * dredg) - sredg) - (((BOBYQAOptimizer.HALF) * sth) * temp));
                            CallChecker.varAssign(sdec, "sdec", 2172, 100525, 100580);
                            if (sdec <= (BOBYQAOptimizer.ZERO)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2174, 100630, 100641);
                                break;
                            }
                            dredg = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredg, "dredg", 2181, 100872, 100884);
                            gredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(gredsq, "gredsq", 2182, 100898, 100911);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2184, 100988, 100991)) {
                                    if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2184, 101021, 101024)) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2184, 101046, 101047)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2184, 100971, 100974)) {
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2184, 100988, 100991);
                                                hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2184, 101021, 101024);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2184, 101046, 101047);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2184, 100971, 100974);
                                                CallChecker.isCalled(gnew, ArrayRealVector.class, 2184, 100971, 100974).setEntry(i, (((CallChecker.isCalled(gnew, ArrayRealVector.class, 2184, 100988, 100991).getEntry(i)) + ((cth - (BOBYQAOptimizer.ONE)) * (CallChecker.isCalled(hred, ArrayRealVector.class, 2184, 101021, 101024).getEntry(i)))) + (sth * (CallChecker.isCalled(hs, ArrayRealVector.class, 2184, 101046, 101047).getEntry(i)))));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2185, 101083, 101086)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2185, 101083, 101086);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2185, 101083, 101086).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2186, 101164, 101177)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2186, 101199, 101199)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2186, 101131, 101144)) {
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2186, 101164, 101177);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2186, 101199, 101199);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2186, 101131, 101144);
                                                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2186, 101131, 101144).setEntry(i, ((cth * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2186, 101164, 101177).getEntry(i))) + (sth * (CallChecker.isCalled(s, ArrayRealVector.class, 2186, 101199, 101199).getEntry(i)))));
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2187, 101244, 101257)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2187, 101273, 101276)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2187, 101244, 101257);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2187, 101273, 101276);
                                                dredg += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2187, 101244, 101257).getEntry(i)) * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2187, 101273, 101276).getEntry(i));
                                                CallChecker.varAssign(dredg, "dredg", 2187, 101235, 101289);
                                            }
                                        }
                                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2189, 101372, 101375);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(gnew, ArrayRealVector.class, 2189, 101372, 101375).getEntry(i))), "d1", 2189, 101311, 101388);
                                        gredsq += d1 * d1;
                                        CallChecker.varAssign(gredsq, "gredsq", 2190, 101410, 101427);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2192, 101486, 101489)) {
                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2192, 101511, 101512)) {
                                        if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2192, 101463, 101466)) {
                                            hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2192, 101486, 101489);
                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2192, 101511, 101512);
                                            hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2192, 101463, 101466);
                                            CallChecker.isCalled(hred, ArrayRealVector.class, 2192, 101463, 101466).setEntry(i, ((cth * (CallChecker.isCalled(hred, ArrayRealVector.class, 2192, 101486, 101489).getEntry(i))) + (sth * (CallChecker.isCalled(hs, ArrayRealVector.class, 2192, 101511, 101512).getEntry(i)))));
                                        }
                                    }
                                }
                            }
                            qred += sdec;
                            CallChecker.varAssign(qred, "qred", 2194, 101554, 101566);
                            if ((iact >= 0) && (isav == iu)) {
                                ++nact;
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2197, 101651, 101654)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2197, 101651, 101654);
                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 2197, 101651, 101654).setEntry(iact, xsav);
                                }
                                state = 100;
                                CallChecker.varAssign(state, "state", 2198, 101694, 101705);
                                break;
                            }
                            if (sdec > (qred * 0.01)) {
                                state = 120;
                                CallChecker.varAssign(state, "state", 2205, 101926, 101937);
                                break;
                            }
                        }
                    case 190 :
                        {
                            BOBYQAOptimizer.printState(190);
                            dsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dsq, "dsq", 2210, 102038, 102048);
                            for (int i = 0; i < n; i++) {
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2214, 102202, 102224);
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2214, 102240, 102253);
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2215, 102312, 102326);
                                final double min = CallChecker.varInit(((double) (Math.min(((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 2214, 102202, 102224).getEntry(i)) + (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 2214, 102240, 102253).getEntry(i))), CallChecker.isCalled(this.upperDifference, ArrayRealVector.class, 2215, 102312, 102326).getEntry(i)))), "min", 2214, 102108, 102340);
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2216, 102393, 102407)) {
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2216, 102358, 102365)) {
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2216, 102393, 102407);
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2216, 102358, 102365);
                                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 2216, 102358, 102365).setEntry(i, Math.max(min, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2216, 102393, 102407).getEntry(i)));
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2217, 102444, 102447)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2217, 102444, 102447);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2217, 102444, 102447).getEntry(i)) == (BOBYQAOptimizer.MINUS_ONE)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2218, 102518, 102532)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2218, 102497, 102504)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2218, 102518, 102532);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2218, 102497, 102504);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 2218, 102497, 102504).setEntry(i, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2218, 102518, 102532).getEntry(i));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2220, 102586, 102589)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2220, 102586, 102589);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2220, 102586, 102589).getEntry(i)) == (BOBYQAOptimizer.ONE)) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2221, 102654, 102668)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2221, 102633, 102640)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2221, 102654, 102668);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2221, 102633, 102640);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 2221, 102633, 102640).setEntry(i, CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2221, 102654, 102668).getEntry(i));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2223, 102745, 102752)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2223, 102768, 102790)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2223, 102718, 102731)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2223, 102745, 102752);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2223, 102768, 102790);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2223, 102718, 102731);
                                            CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2223, 102718, 102731).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 2223, 102745, 102752).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2223, 102768, 102790).getEntry(i))));
                                        }
                                    }
                                }
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2225, 102879, 102892);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 2225, 102879, 102892).getEntry(i))), "d1", 2225, 102822, 102905);
                                dsq += d1 * d1;
                                CallChecker.varAssign(dsq, "dsq", 2226, 102923, 102937);
                            }
                            return new double[]{ dsq , crvmin };
                        }
                    case 210 :
                        {
                            BOBYQAOptimizer.printState(210);
                            int ih = CallChecker.varInit(((int) (0)), "ih", 2236, 103398, 103408);
                            for (int j = 0; j < n; j++) {
                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2238, 103468, 103469)) {
                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2238, 103468, 103469);
                                    CallChecker.isCalled(hs, ArrayRealVector.class, 2238, 103468, 103469).setEntry(j, BOBYQAOptimizer.ZERO);
                                }
                                for (int i = 0; i <= j; i++) {
                                    if (i < j) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2241, 103609, 103610)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 2241, 103626, 103653)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2241, 103670, 103670)) {
                                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2241, 103594, 103595)) {
                                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2241, 103609, 103610);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2241, 103626, 103653);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2241, 103670, 103670);
                                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2241, 103594, 103595);
                                                        CallChecker.isCalled(hs, ArrayRealVector.class, 2241, 103594, 103595).setEntry(j, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2241, 103609, 103610).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2241, 103626, 103653).getEntry(ih)) * (CallChecker.isCalled(s, ArrayRealVector.class, 2241, 103670, 103670).getEntry(i)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2243, 103743, 103744)) {
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 2243, 103760, 103787)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2243, 103804, 103804)) {
                                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2243, 103728, 103729)) {
                                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2243, 103743, 103744);
                                                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2243, 103760, 103787);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2243, 103804, 103804);
                                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2243, 103728, 103729);
                                                    CallChecker.isCalled(hs, ArrayRealVector.class, 2243, 103728, 103729).setEntry(i, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2243, 103743, 103744).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2243, 103760, 103787).getEntry(ih)) * (CallChecker.isCalled(s, ArrayRealVector.class, 2243, 103804, 103804).getEntry(j)))));
                                                }
                                            }
                                        }
                                    }
                                    ih++;
                                }
                            }
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 2247, 103913, 103931);
                            final RealVector tmp = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 2247, 103913, 103931).operate(s), RealVector.class, 2247, 103913, 103942).ebeMultiply(modelSecondDerivativesParameters), "tmp", 2247, 103890, 103989);
                            for (int k = 0; k < npt; k++) {
                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 2249, 104055, 104086)) {
                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 2249, 104055, 104086);
                                    if ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 2249, 104055, 104086).getEntry(k)) != (BOBYQAOptimizer.ZERO)) {
                                        for (int i = 0; i < n; i++) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2251, 104200, 104201)) {
                                                if (CallChecker.beforeDeref(tmp, RealVector.class, 2251, 104217, 104219)) {
                                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 2251, 104235, 104253)) {
                                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2251, 104185, 104186)) {
                                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2251, 104200, 104201);
                                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 2251, 104235, 104253);
                                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2251, 104185, 104186);
                                                            CallChecker.isCalled(hs, ArrayRealVector.class, 2251, 104185, 104186).setEntry(i, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2251, 104200, 104201).getEntry(i)) + ((CallChecker.isCalled(tmp, RealVector.class, 2251, 104217, 104219).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 2251, 104235, 104253).getEntry(k, i)))));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            if (crvmin != (BOBYQAOptimizer.ZERO)) {
                                state = 50;
                                CallChecker.varAssign(state, "state", 2256, 104376, 104386);
                                break;
                            }
                            if (iterc > itcsav) {
                                state = 150;
                                CallChecker.varAssign(state, "state", 2259, 104459, 104470);
                                break;
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2262, 104568, 104569)) {
                                    if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2262, 104551, 104554)) {
                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2262, 104568, 104569);
                                        hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2262, 104551, 104554);
                                        CallChecker.isCalled(hred, ArrayRealVector.class, 2262, 104551, 104554).setEntry(i, CallChecker.isCalled(hs, ArrayRealVector.class, 2262, 104568, 104569).getEntry(i));
                                    }
                                }
                            }
                            state = 120;
                            CallChecker.varAssign(state, "state", 2264, 104611, 104622);
                            break;
                        }
                    default :
                        {
                            throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, "trsbox");
                        }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4548.methodEnd();
        }
    }

    private void update(double beta, double denom, int knew) {
        MethodContext _bcornu_methode_context4549 = new MethodContext(void.class, 2287, 104794, 108925);
        try {
            CallChecker.varInit(this, "this", 2287, 104794, 108925);
            CallChecker.varInit(knew, "knew", 2287, 104794, 108925);
            CallChecker.varInit(denom, "denom", 2287, 104794, 108925);
            CallChecker.varInit(beta, "beta", 2287, 104794, 108925);
            CallChecker.varInit(this.iterations, "iterations", 2287, 104794, 108925);
            CallChecker.varInit(this.evaluations, "evaluations", 2287, 104794, 108925);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 2287, 104794, 108925);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 2287, 104794, 108925);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 2287, 104794, 108925);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 2287, 104794, 108925);
            CallChecker.varInit(this.newPoint, "newPoint", 2287, 104794, 108925);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 2287, 104794, 108925);
            CallChecker.varInit(this.upperDifference, "upperDifference", 2287, 104794, 108925);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 2287, 104794, 108925);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 2287, 104794, 108925);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 2287, 104794, 108925);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 2287, 104794, 108925);
            CallChecker.varInit(this.originShift, "originShift", 2287, 104794, 108925);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 2287, 104794, 108925);
            CallChecker.varInit(this.zMatrix, "zMatrix", 2287, 104794, 108925);
            CallChecker.varInit(this.bMatrix, "bMatrix", 2287, 104794, 108925);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 2287, 104794, 108925);
            CallChecker.varInit(this.boundDifference, "boundDifference", 2287, 104794, 108925);
            CallChecker.varInit(this.currentBest, "currentBest", 2287, 104794, 108925);
            CallChecker.varInit(this.isMinimize, "isMinimize", 2287, 104794, 108925);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 2287, 104794, 108925);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 2287, 104794, 108925);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 2287, 104794, 108925);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2287, 104794, 108925);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 2287, 104794, 108925);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 2287, 104794, 108925);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 2287, 104794, 108925);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 2287, 104794, 108925);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 2287, 104794, 108925);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2287, 104794, 108925);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 2287, 104794, 108925);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 2287, 104794, 108925);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 2287, 104794, 108925);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 2287, 104794, 108925);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 2287, 104794, 108925);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2287, 104794, 108925);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2287, 104794, 108925);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2287, 104794, 108925);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 2294, 105763, 105773);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 2294, 105763, 105773).getDimension())), "n", 2294, 105749, 105789);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 2295, 105799, 105842);
            final int nptm = CallChecker.varInit(((int) ((npt - n) - 1)), "nptm", 2296, 105852, 105880);
            final ArrayRealVector work = CallChecker.varInit(new ArrayRealVector((npt + n)), "work", 2299, 105891, 106005);
            double ztest = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ztest", 2301, 106016, 106035);
            for (int k = 0; k < npt; k++) {
                for (int j = 0; j < nptm; j++) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2305, 106204, 106210)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2305, 106204, 106210);
                        ztest = Math.max(ztest, Math.abs(CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2305, 106204, 106210).getEntry(k, j)));
                        CallChecker.varAssign(ztest, "ztest", 2305, 106171, 106228);
                    }
                }
            }
            ztest *= 1.0E-20;
            CallChecker.varAssign(ztest, "ztest", 2308, 106262, 106276);
            for (int j = 1; j < nptm; j++) {
                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2313, 106425, 106431);
                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2313, 106425, 106431).getEntry(knew, j))), "d1", 2313, 106407, 106450);
                if ((Math.abs(d1)) > ztest) {
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2316, 106565, 106571);
                    final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2316, 106565, 106571).getEntry(knew, 0))), "d2", 2316, 106508, 106590);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2318, 106665, 106671);
                    final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2318, 106665, 106671).getEntry(knew, j))), "d3", 2318, 106608, 106690);
                    final double d4 = CallChecker.varInit(((double) (Math.sqrt(((d2 * d2) + (d3 * d3))))), "d4", 2319, 106708, 106754);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2320, 106790, 106796);
                    final double d5 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2320, 106790, 106796).getEntry(knew, 0)) / d4)), "d5", 2320, 106772, 106820);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2321, 106856, 106862);
                    final double d6 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2321, 106856, 106862).getEntry(knew, j)) / d4)), "d6", 2321, 106838, 106886);
                    for (int i = 0; i < npt; i++) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2323, 106979, 106985);
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2323, 107009, 107015);
                        final double d7 = CallChecker.varInit(((double) ((d5 * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2323, 106979, 106985).getEntry(i, 0))) + (d6 * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2323, 107009, 107015).getEntry(i, j))))), "d7", 2323, 106956, 107031);
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2324, 107081, 107087)) {
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2324, 107111, 107117)) {
                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2324, 107053, 107059)) {
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107081, 107087);
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107111, 107117);
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107053, 107059);
                                    CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107053, 107059).setEntry(i, j, ((d5 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107081, 107087).getEntry(i, j))) - (d6 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2324, 107111, 107117).getEntry(i, 0)))));
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2325, 107156, 107162)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2325, 107156, 107162);
                            CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2325, 107156, 107162).setEntry(i, 0, d7);
                        }
                    }
                }
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2328, 107228, 107234)) {
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2328, 107228, 107234);
                    CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2328, 107228, 107234).setEntry(knew, j, BOBYQAOptimizer.ZERO);
                }
            }
            for (int i = 0; i < npt; i++) {
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2335, 107485, 107491)) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2335, 107513, 107519)) {
                        if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2335, 107468, 107471)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2335, 107485, 107491);
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2335, 107513, 107519);
                            CallChecker.isCalled(work, ArrayRealVector.class, 2335, 107468, 107471).setEntry(i, ((CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2335, 107485, 107491).getEntry(knew, 0)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2335, 107513, 107519).getEntry(i, 0))));
                        }
                    }
                }
            }
            final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(work, ArrayRealVector.class, 2337, 107577, 107580).getEntry(knew))), "alpha", 2337, 107556, 107596);
            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2338, 107625, 107648);
            final double tau = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2338, 107625, 107648).getEntry(knew))), "tau", 2338, 107606, 107664);
            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107714, 107737)) {
                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107674, 107697)) {
                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107714, 107737);
                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107674, 107697);
                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107674, 107697).setEntry(knew, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2339, 107714, 107737).getEntry(knew)) - (BOBYQAOptimizer.ONE)));
                }
            }
            final double sqrtDenom = CallChecker.varInit(((double) (Math.sqrt(denom))), "sqrtDenom", 2343, 107771, 107855);
            final double d1 = CallChecker.varInit(((double) (tau / sqrtDenom)), "d1", 2344, 107865, 107898);
            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2345, 107926, 107932);
            final double d2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2345, 107926, 107932).getEntry(knew, 0)) / sqrtDenom)), "d2", 2345, 107908, 107963);
            for (int i = 0; i < npt; i++) {
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2348, 108071, 108077)) {
                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2348, 108101, 108124)) {
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2347, 108017, 108023)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2348, 108071, 108077);
                            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2348, 108101, 108124);
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2347, 108017, 108023);
                            CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2347, 108017, 108023).setEntry(i, 0, ((d1 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2348, 108071, 108077).getEntry(i, 0))) - (d2 * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2348, 108101, 108124).getEntry(i)))));
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                final int jp = CallChecker.varInit(((int) (npt + j)), "jp", 2354, 108246, 108268);
                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2355, 108300, 108306)) {
                    if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2355, 108282, 108285)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2355, 108300, 108306);
                        CallChecker.isCalled(work, ArrayRealVector.class, 2355, 108282, 108285).setEntry(jp, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2355, 108300, 108306).getEntry(knew, j));
                    }
                }
                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2356, 108367, 108390);
                final double d3 = CallChecker.varInit(((double) (((alpha * (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2356, 108367, 108390).getEntry(jp))) - (tau * (CallChecker.isCalled(work, ArrayRealVector.class, 2356, 108413, 108416).getEntry(jp)))) / denom)), "d3", 2356, 108340, 108439);
                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2357, 108506, 108529);
                final double d4 = CallChecker.varInit(((double) ((((-beta) * (CallChecker.isCalled(work, ArrayRealVector.class, 2357, 108480, 108483).getEntry(jp))) - (tau * (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2357, 108506, 108529).getEntry(jp)))) / denom)), "d4", 2357, 108453, 108552);
                for (int i = 0; i <= jp; i++) {
                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2360, 108667, 108673)) {
                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2360, 108697, 108720)) {
                            if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2360, 108741, 108744)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2359, 108614, 108620)) {
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2360, 108667, 108673);
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2360, 108697, 108720);
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2359, 108614, 108620);
                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2359, 108614, 108620).setEntry(i, j, (((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2360, 108667, 108673).getEntry(i, j)) + (d3 * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2360, 108697, 108720).getEntry(i)))) + (d4 * (CallChecker.isCalled(work, ArrayRealVector.class, 2360, 108741, 108744).getEntry(i)))));
                                }
                            }
                        }
                    }
                    if (i >= npt) {
                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2362, 108844, 108850)) {
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2362, 108812, 108818)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2362, 108844, 108850);
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2362, 108812, 108818);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2362, 108812, 108818).setEntry(jp, (i - npt), CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2362, 108844, 108850).getEntry(i, j));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4549.methodEnd();
        }
    }

    private void setup(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4550 = new MethodContext(void.class, 2374, 108932, 111975);
        try {
            CallChecker.varInit(this, "this", 2374, 108932, 111975);
            CallChecker.varInit(upperBound, "upperBound", 2374, 108932, 111975);
            CallChecker.varInit(lowerBound, "lowerBound", 2374, 108932, 111975);
            CallChecker.varInit(this.iterations, "iterations", 2374, 108932, 111975);
            CallChecker.varInit(this.evaluations, "evaluations", 2374, 108932, 111975);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 2374, 108932, 111975);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 2374, 108932, 111975);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 2374, 108932, 111975);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 2374, 108932, 111975);
            CallChecker.varInit(this.newPoint, "newPoint", 2374, 108932, 111975);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 2374, 108932, 111975);
            CallChecker.varInit(this.upperDifference, "upperDifference", 2374, 108932, 111975);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 2374, 108932, 111975);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 2374, 108932, 111975);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 2374, 108932, 111975);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 2374, 108932, 111975);
            CallChecker.varInit(this.originShift, "originShift", 2374, 108932, 111975);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 2374, 108932, 111975);
            CallChecker.varInit(this.zMatrix, "zMatrix", 2374, 108932, 111975);
            CallChecker.varInit(this.bMatrix, "bMatrix", 2374, 108932, 111975);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 2374, 108932, 111975);
            CallChecker.varInit(this.boundDifference, "boundDifference", 2374, 108932, 111975);
            CallChecker.varInit(this.currentBest, "currentBest", 2374, 108932, 111975);
            CallChecker.varInit(this.isMinimize, "isMinimize", 2374, 108932, 111975);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 2374, 108932, 111975);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 2374, 108932, 111975);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 2374, 108932, 111975);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2374, 108932, 111975);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 2374, 108932, 111975);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 2374, 108932, 111975);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 2374, 108932, 111975);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 2374, 108932, 111975);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 2374, 108932, 111975);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2374, 108932, 111975);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 2374, 108932, 111975);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 2374, 108932, 111975);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 2374, 108932, 111975);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 2374, 108932, 111975);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 2374, 108932, 111975);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2374, 108932, 111975);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2374, 108932, 111975);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2374, 108932, 111975);
            BOBYQAOptimizer.printMethod();
            double[] init = CallChecker.varInit(getStartPoint(), "init", 2378, 109275, 109306);
            init = CallChecker.beforeCalled(init, double[].class, 2379, 109338, 109341);
            final int dimension = CallChecker.varInit(((int) (CallChecker.isCalled(init, double[].class, 2379, 109338, 109341).length)), "dimension", 2379, 109316, 109349);
            if (dimension < (BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION)) {
                throw new NumberIsTooSmallException(dimension, BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION, true);
            }
            final int[] nPointsInterval = CallChecker.varInit(new int[]{ dimension + 2 , ((dimension + 2) * (dimension + 1)) / 2 }, "nPointsInterval", 2386, 109601, 109687);
            if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2387, 109731, 109745)) {
                if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2388, 109795, 109809)) {
                    if (((numberOfInterpolationPoints) < (CallChecker.isCalled(nPointsInterval, int[].class, 2387, 109731, 109745)[0])) || ((numberOfInterpolationPoints) > (CallChecker.isCalled(nPointsInterval, int[].class, 2388, 109795, 109809)[1]))) {
                        if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2391, 110021, 110035)) {
                            if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2392, 110083, 110097)) {
                                throw new OutOfRangeException(LocalizedFormats.NUMBER_OF_INTERPOLATION_POINTS, numberOfInterpolationPoints, CallChecker.isCalled(nPointsInterval, int[].class, 2391, 110021, 110035)[0], CallChecker.isCalled(nPointsInterval, int[].class, 2392, 110083, 110097)[1]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            boundDifference = new double[dimension];
            CallChecker.varAssign(this.boundDifference, "this.boundDifference", 2396, 110164, 110203);
            double requiredMinDiff = CallChecker.varInit(((double) (2 * (this.initialTrustRegionRadius))), "requiredMinDiff", 2398, 110214, 110267);
            double minDiff = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "minDiff", 2399, 110277, 110318);
            for (int i = 0; i < dimension; i++) {
                if (CallChecker.beforeDeref(boundDifference, double[].class, 2401, 110378, 110392)) {
                    if (CallChecker.beforeDeref(upperBound, double[].class, 2401, 110399, 110408)) {
                        if (CallChecker.beforeDeref(lowerBound, double[].class, 2401, 110415, 110424)) {
                            boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 2401, 110378, 110392);
                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 2401, 110399, 110408);
                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 2401, 110415, 110424);
                            CallChecker.isCalled(boundDifference, double[].class, 2401, 110378, 110392)[i] = (CallChecker.isCalled(upperBound, double[].class, 2401, 110399, 110408)[i]) - (CallChecker.isCalled(lowerBound, double[].class, 2401, 110415, 110424)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.boundDifference, double[].class, 2401, 110378, 110392)[i], "CallChecker.isCalled(this.boundDifference, double[].class, 2401, 110378, 110392)[i]", 2401, 110378, 110428);
                        }
                    }
                }
                if (CallChecker.beforeDeref(boundDifference, double[].class, 2402, 110470, 110484)) {
                    boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 2402, 110470, 110484);
                    minDiff = Math.min(minDiff, CallChecker.isCalled(boundDifference, double[].class, 2402, 110470, 110484)[i]);
                    CallChecker.varAssign(minDiff, "minDiff", 2402, 110442, 110489);
                }
            }
            if (minDiff < requiredMinDiff) {
                initialTrustRegionRadius = minDiff / 3.0;
                CallChecker.varAssign(this.initialTrustRegionRadius, "this.initialTrustRegionRadius", 2405, 110554, 110594);
            }
            bMatrix = new Array2DRowRealMatrix((dimension + (numberOfInterpolationPoints)), dimension);
            CallChecker.varAssign(this.bMatrix, "this.bMatrix", 2409, 110686, 110815);
            zMatrix = new Array2DRowRealMatrix(numberOfInterpolationPoints, (((numberOfInterpolationPoints) - dimension) - 1));
            CallChecker.varAssign(this.zMatrix, "this.zMatrix", 2411, 110825, 110976);
            interpolationPoints = new Array2DRowRealMatrix(numberOfInterpolationPoints, dimension);
            CallChecker.varAssign(this.interpolationPoints, "this.interpolationPoints", 2413, 110986, 111127);
            originShift = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.originShift, "this.originShift", 2415, 111137, 111181);
            fAtInterpolationPoints = new ArrayRealVector(numberOfInterpolationPoints);
            CallChecker.varAssign(this.fAtInterpolationPoints, "this.fAtInterpolationPoints", 2416, 111191, 111264);
            trustRegionCenterOffset = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.trustRegionCenterOffset, "this.trustRegionCenterOffset", 2417, 111274, 111330);
            gradientAtTrustRegionCenter = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.gradientAtTrustRegionCenter, "this.gradientAtTrustRegionCenter", 2418, 111340, 111400);
            lowerDifference = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.lowerDifference, "this.lowerDifference", 2419, 111410, 111458);
            upperDifference = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.upperDifference, "this.upperDifference", 2420, 111468, 111516);
            modelSecondDerivativesParameters = new ArrayRealVector(numberOfInterpolationPoints);
            CallChecker.varAssign(this.modelSecondDerivativesParameters, "this.modelSecondDerivativesParameters", 2421, 111526, 111609);
            newPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.newPoint, "this.newPoint", 2422, 111619, 111660);
            alternativeNewPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.alternativeNewPoint, "this.alternativeNewPoint", 2423, 111670, 111722);
            trialStepPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.trialStepPoint, "this.trialStepPoint", 2424, 111732, 111779);
            lagrangeValuesAtNewPoint = new ArrayRealVector((dimension + (numberOfInterpolationPoints)));
            CallChecker.varAssign(this.lagrangeValuesAtNewPoint, "this.lagrangeValuesAtNewPoint", 2425, 111789, 111876);
            modelSecondDerivativesValues = new ArrayRealVector(((dimension * (dimension + 1)) / 2));
            CallChecker.varAssign(this.modelSecondDerivativesValues, "this.modelSecondDerivativesValues", 2426, 111886, 111969);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4550.methodEnd();
        }
    }

    private static String caller(int n) {
        MethodContext _bcornu_methode_context4551 = new MethodContext(String.class, 2430, 111982, 112308);
        try {
            CallChecker.varInit(n, "n", 2430, 111982, 112308);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2430, 111982, 112308);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 2430, 111982, 112308);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 2430, 111982, 112308);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 2430, 111982, 112308);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 2430, 111982, 112308);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 2430, 111982, 112308);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2430, 111982, 112308);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 2430, 111982, 112308);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 2430, 111982, 112308);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 2430, 111982, 112308);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 2430, 111982, 112308);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 2430, 111982, 112308);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2430, 111982, 112308);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2430, 111982, 112308);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2430, 111982, 112308);
            final Throwable t = CallChecker.varInit(new Throwable(), "t", 2431, 112079, 112114);
            final StackTraceElement[] elements = CallChecker.varInit(CallChecker.isCalled(t, Throwable.class, 2432, 112161, 112161).getStackTrace(), "elements", 2432, 112124, 112178);
            final StackTraceElement e = CallChecker.varInit(CallChecker.isCalled(elements, StackTraceElement[].class, 2433, 112216, 112223)[n], "e", 2433, 112188, 112227);
            return (((CallChecker.isCalled(e, StackTraceElement.class, 2434, 112244, 112244).getMethodName()) + " (at line ") + (CallChecker.isCalled(e, StackTraceElement.class, 2434, 112279, 112279).getLineNumber())) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4551.methodEnd();
        }
    }

    private static void printState(int s) {
        MethodContext _bcornu_methode_context4552 = new MethodContext(void.class, 2437, 112314, 112475);
        try {
            CallChecker.varInit(s, "s", 2437, 112314, 112475);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2437, 112314, 112475);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 2437, 112314, 112475);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 2437, 112314, 112475);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 2437, 112314, 112475);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 2437, 112314, 112475);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 2437, 112314, 112475);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2437, 112314, 112475);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 2437, 112314, 112475);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 2437, 112314, 112475);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 2437, 112314, 112475);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 2437, 112314, 112475);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 2437, 112314, 112475);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2437, 112314, 112475);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2437, 112314, 112475);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2437, 112314, 112475);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4552.methodEnd();
        }
    }

    private static void printMethod() {
        MethodContext _bcornu_methode_context4553 = new MethodContext(void.class, 2441, 112481, 112621);
        try {
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2441, 112481, 112621);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_TEN", 2441, 112481, 112621);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_EIGHT", 2441, 112481, 112621);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE_OVER_FOUR", 2441, 112481, 112621);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.HALF", 2441, 112481, 112621);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINUS_ONE", 2441, 112481, 112621);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2441, 112481, 112621);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.SIXTEEN", 2441, 112481, 112621);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TEN", 2441, 112481, 112621);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.TWO", 2441, 112481, 112621);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ONE", 2441, 112481, 112621);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.ZERO", 2441, 112481, 112621);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2441, 112481, 112621);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2441, 112481, 112621);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2441, 112481, 112621);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4553.methodEnd();
        }
    }
}

