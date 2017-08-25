package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;

@Deprecated
public class BOBYQAOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    private static class PathIsExploredException extends RuntimeException {
        private static final long serialVersionUID = 745350979634801853L;

        private static final String PATH_IS_EXPLORED = "If this exception is thrown, just remove it from the code";

        PathIsExploredException() {
            super((((BOBYQAOptimizer.PathIsExploredException.PATH_IS_EXPLORED) + " ") + (BOBYQAOptimizer.caller(3))));
            ConstructorContext _bcornu_methode_context1012 = new ConstructorContext(BOBYQAOptimizer.PathIsExploredException.class, 2460, 113279, 113386);
            try {
            } finally {
                _bcornu_methode_context1012.methodEnd();
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
        ConstructorContext _bcornu_methode_context1013 = new ConstructorContext(BOBYQAOptimizer.class, 211, 8618, 9068);
        try {
        } finally {
            _bcornu_methode_context1013.methodEnd();
        }
    }

    public BOBYQAOptimizer(int numberOfInterpolationPoints, double initialTrustRegionRadius, double stoppingTrustRegionRadius) {
        super(null);
        ConstructorContext _bcornu_methode_context1014 = new ConstructorContext(BOBYQAOptimizer.class, 225, 9075, 9929);
        try {
            this.numberOfInterpolationPoints = numberOfInterpolationPoints;
            CallChecker.varAssign(this.numberOfInterpolationPoints, "this.numberOfInterpolationPoints", 229, 9727, 9789);
            this.initialTrustRegionRadius = initialTrustRegionRadius;
            CallChecker.varAssign(this.initialTrustRegionRadius, "this.initialTrustRegionRadius", 230, 9799, 9855);
            this.stoppingTrustRegionRadius = stoppingTrustRegionRadius;
            CallChecker.varAssign(this.stoppingTrustRegionRadius, "this.stoppingTrustRegionRadius", 231, 9865, 9923);
        } finally {
            _bcornu_methode_context1014.methodEnd();
        }
    }

    @Override
    protected PointValuePair doOptimize() {
        MethodContext _bcornu_methode_context4532 = new MethodContext(PointValuePair.class, 236, 9936, 10504);
        try {
            CallChecker.varInit(this, "this", 236, 9936, 10504);
            CallChecker.varInit(this.evaluations, "evaluations", 236, 9936, 10504);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 236, 9936, 10504);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 236, 9936, 10504);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 236, 9936, 10504);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 236, 9936, 10504);
            CallChecker.varInit(this.newPoint, "newPoint", 236, 9936, 10504);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 236, 9936, 10504);
            CallChecker.varInit(this.upperDifference, "upperDifference", 236, 9936, 10504);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 236, 9936, 10504);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 236, 9936, 10504);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 236, 9936, 10504);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 236, 9936, 10504);
            CallChecker.varInit(this.originShift, "originShift", 236, 9936, 10504);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 236, 9936, 10504);
            CallChecker.varInit(this.zMatrix, "zMatrix", 236, 9936, 10504);
            CallChecker.varInit(this.bMatrix, "bMatrix", 236, 9936, 10504);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 236, 9936, 10504);
            CallChecker.varInit(this.boundDifference, "boundDifference", 236, 9936, 10504);
            CallChecker.varInit(this.currentBest, "currentBest", 236, 9936, 10504);
            CallChecker.varInit(this.isMinimize, "isMinimize", 236, 9936, 10504);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 236, 9936, 10504);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 236, 9936, 10504);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 236, 9936, 10504);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 236, 9936, 10504);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 236, 9936, 10504);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 236, 9936, 10504);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 236, 9936, 10504);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 236, 9936, 10504);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 236, 9936, 10504);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 236, 9936, 10504);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 236, 9936, 10504);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 236, 9936, 10504);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 236, 9936, 10504);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 236, 9936, 10504);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 236, 9936, 10504);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 236, 9936, 10504);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 236, 9936, 10504);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 236, 9936, 10504);
            final double[] lowerBound = CallChecker.varInit(getLowerBound(), "lowerBound", 237, 10023, 10066);
            final double[] upperBound = CallChecker.varInit(getUpperBound(), "upperBound", 238, 10076, 10119);
            setup(lowerBound, upperBound);
            isMinimize = (getGoalType()) == (GoalType.MINIMIZE);
            CallChecker.varAssign(this.isMinimize, "this.isMinimize", 243, 10198, 10247);
            currentBest = new ArrayRealVector(getStartPoint());
            CallChecker.varAssign(this.currentBest, "this.currentBest", 244, 10257, 10307);
            final double value = CallChecker.varInit(((double) (bobyqa(lowerBound, upperBound))), "value", 246, 10318, 10369);
            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 248, 10406, 10416)) {
                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 248, 10406, 10416);
                return new PointValuePair(CallChecker.isCalled(currentBest, ArrayRealVector.class, 248, 10406, 10416).getDataRef(), (isMinimize ? value : -value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4532.methodEnd();
        }
    }

    private double bobyqa(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4533 = new MethodContext(double.class, 287, 10511, 15338);
        try {
            CallChecker.varInit(this, "this", 287, 10511, 15338);
            CallChecker.varInit(upperBound, "upperBound", 287, 10511, 15338);
            CallChecker.varInit(lowerBound, "lowerBound", 287, 10511, 15338);
            CallChecker.varInit(this.evaluations, "evaluations", 287, 10511, 15338);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 287, 10511, 15338);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 287, 10511, 15338);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 287, 10511, 15338);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 287, 10511, 15338);
            CallChecker.varInit(this.newPoint, "newPoint", 287, 10511, 15338);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 287, 10511, 15338);
            CallChecker.varInit(this.upperDifference, "upperDifference", 287, 10511, 15338);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 287, 10511, 15338);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 287, 10511, 15338);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 287, 10511, 15338);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 287, 10511, 15338);
            CallChecker.varInit(this.originShift, "originShift", 287, 10511, 15338);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 287, 10511, 15338);
            CallChecker.varInit(this.zMatrix, "zMatrix", 287, 10511, 15338);
            CallChecker.varInit(this.bMatrix, "bMatrix", 287, 10511, 15338);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 287, 10511, 15338);
            CallChecker.varInit(this.boundDifference, "boundDifference", 287, 10511, 15338);
            CallChecker.varInit(this.currentBest, "currentBest", 287, 10511, 15338);
            CallChecker.varInit(this.isMinimize, "isMinimize", 287, 10511, 15338);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 287, 10511, 15338);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 287, 10511, 15338);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 287, 10511, 15338);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 287, 10511, 15338);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 287, 10511, 15338);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 287, 10511, 15338);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 287, 10511, 15338);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 287, 10511, 15338);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 287, 10511, 15338);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 287, 10511, 15338);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 287, 10511, 15338);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 287, 10511, 15338);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 287, 10511, 15338);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 287, 10511, 15338);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 287, 10511, 15338);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 287, 10511, 15338);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 287, 10511, 15338);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 287, 10511, 15338);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 291, 12914, 12924);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 291, 12914, 12924).getDimension())), "n", 291, 12900, 12940);
            for (int j = 0; j < n; j++) {
                boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 301, 13504, 13518);
                final double boundDiff = CallChecker.varInit(((double) (CallChecker.isCalled(this.boundDifference, double[].class, 301, 13504, 13518)[j])), "boundDiff", 301, 13479, 13522);
                if (CallChecker.beforeDeref(lowerBound, double[].class, 302, 13564, 13573)) {
                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 302, 13580, 13590)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 302, 13536, 13550)) {
                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 302, 13564, 13573);
                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 302, 13580, 13590);
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 302, 13536, 13550);
                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 302, 13536, 13550).setEntry(j, ((CallChecker.isCalled(lowerBound, double[].class, 302, 13564, 13573)[j]) - (CallChecker.isCalled(currentBest, ArrayRealVector.class, 302, 13580, 13590).getEntry(j))));
                        }
                    }
                }
                if (CallChecker.beforeDeref(upperBound, double[].class, 303, 13646, 13655)) {
                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 303, 13662, 13672)) {
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 303, 13618, 13632)) {
                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 303, 13646, 13655);
                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 303, 13662, 13672);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 303, 13618, 13632);
                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 303, 13618, 13632).setEntry(j, ((CallChecker.isCalled(upperBound, double[].class, 303, 13646, 13655)[j]) - (CallChecker.isCalled(currentBest, ArrayRealVector.class, 303, 13662, 13672).getEntry(j))));
                        }
                    }
                }
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 304, 13704, 13718)) {
                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 304, 13704, 13718);
                    if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 304, 13704, 13718).getEntry(j)) >= (-(initialTrustRegionRadius))) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 305, 13784, 13798)) {
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 305, 13784, 13798);
                            if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 305, 13784, 13798).getEntry(j)) >= (BOBYQAOptimizer.ZERO)) {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 306, 13867, 13876)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 306, 13843, 13853)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 306, 13867, 13876);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 306, 13843, 13853);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 306, 13843, 13853).setEntry(j, CallChecker.isCalled(lowerBound, double[].class, 306, 13867, 13876)[j]);
                                    }
                                }
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 307, 13903, 13917)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 307, 13903, 13917);
                                    CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 307, 13903, 13917).setEntry(j, BOBYQAOptimizer.ZERO);
                                }
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 308, 13958, 13972)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 308, 13958, 13972);
                                    CallChecker.isCalled(upperDifference, ArrayRealVector.class, 308, 13958, 13972).setEntry(j, boundDiff);
                                }
                            }else {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 310, 14067, 14076)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 310, 14043, 14053)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 310, 14067, 14076);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 310, 14043, 14053);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 310, 14043, 14053).setEntry(j, ((CallChecker.isCalled(lowerBound, double[].class, 310, 14067, 14076)[j]) + (initialTrustRegionRadius)));
                                    }
                                }
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 311, 14130, 14144)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 311, 14130, 14144);
                                    CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 311, 14130, 14144).setEntry(j, (-(initialTrustRegionRadius)));
                                }
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 313, 14267, 14276);
                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 313, 14283, 14293);
                                final double deltaOne = CallChecker.varInit(((double) ((CallChecker.isCalled(upperBound, double[].class, 313, 14267, 14276)[j]) - (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 313, 14283, 14293).getEntry(j)))), "deltaOne", 313, 14206, 14306);
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 314, 14328, 14342)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 314, 14328, 14342);
                                    CallChecker.isCalled(upperDifference, ArrayRealVector.class, 314, 14328, 14342).setEntry(j, Math.max(deltaOne, initialTrustRegionRadius));
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 316, 14444, 14458)) {
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 316, 14444, 14458);
                            if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 316, 14444, 14458).getEntry(j)) <= (initialTrustRegionRadius)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 317, 14523, 14537)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 317, 14523, 14537);
                                    if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 317, 14523, 14537).getEntry(j)) <= (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(upperBound, double[].class, 318, 14606, 14615)) {
                                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 318, 14582, 14592)) {
                                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 318, 14606, 14615);
                                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 318, 14582, 14592);
                                                CallChecker.isCalled(currentBest, ArrayRealVector.class, 318, 14582, 14592).setEntry(j, CallChecker.isCalled(upperBound, double[].class, 318, 14606, 14615)[j]);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 319, 14642, 14656)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 319, 14642, 14656);
                                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 319, 14642, 14656).setEntry(j, (-boundDiff));
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 320, 14703, 14717)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 320, 14703, 14717);
                                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 320, 14703, 14717).setEntry(j, BOBYQAOptimizer.ZERO);
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(upperBound, double[].class, 322, 14807, 14816)) {
                                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 322, 14783, 14793)) {
                                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 322, 14807, 14816);
                                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 322, 14783, 14793);
                                                CallChecker.isCalled(currentBest, ArrayRealVector.class, 322, 14783, 14793).setEntry(j, ((CallChecker.isCalled(upperBound, double[].class, 322, 14807, 14816)[j]) - (initialTrustRegionRadius)));
                                            }
                                        }
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 324, 14931, 14940);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 324, 14947, 14957);
                                        final double deltaOne = CallChecker.varInit(((double) ((CallChecker.isCalled(lowerBound, double[].class, 324, 14931, 14940)[j]) - (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 324, 14947, 14957).getEntry(j)))), "deltaOne", 324, 14870, 14970);
                                        final double deltaTwo = CallChecker.varInit(((double) (-(this.initialTrustRegionRadius))), "deltaTwo", 325, 14992, 15041);
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 326, 15063, 15077)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 326, 15063, 15077);
                                            CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 326, 15063, 15077).setEntry(j, Math.min(deltaOne, deltaTwo));
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 327, 15142, 15156)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 327, 15142, 15156);
                                            CallChecker.isCalled(upperDifference, ArrayRealVector.class, 327, 15142, 15156).setEntry(j, initialTrustRegionRadius);
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
            _bcornu_methode_context4533.methodEnd();
        }
    }

    private double bobyqb(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4534 = new MethodContext(double.class, 376, 15345, 57734);
        try {
            CallChecker.varInit(this, "this", 376, 15345, 57734);
            CallChecker.varInit(upperBound, "upperBound", 376, 15345, 57734);
            CallChecker.varInit(lowerBound, "lowerBound", 376, 15345, 57734);
            CallChecker.varInit(this.evaluations, "evaluations", 376, 15345, 57734);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 376, 15345, 57734);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 376, 15345, 57734);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 376, 15345, 57734);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 376, 15345, 57734);
            CallChecker.varInit(this.newPoint, "newPoint", 376, 15345, 57734);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 376, 15345, 57734);
            CallChecker.varInit(this.upperDifference, "upperDifference", 376, 15345, 57734);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 376, 15345, 57734);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 376, 15345, 57734);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 376, 15345, 57734);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 376, 15345, 57734);
            CallChecker.varInit(this.originShift, "originShift", 376, 15345, 57734);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 376, 15345, 57734);
            CallChecker.varInit(this.zMatrix, "zMatrix", 376, 15345, 57734);
            CallChecker.varInit(this.bMatrix, "bMatrix", 376, 15345, 57734);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 376, 15345, 57734);
            CallChecker.varInit(this.boundDifference, "boundDifference", 376, 15345, 57734);
            CallChecker.varInit(this.currentBest, "currentBest", 376, 15345, 57734);
            CallChecker.varInit(this.isMinimize, "isMinimize", 376, 15345, 57734);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 376, 15345, 57734);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 376, 15345, 57734);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 376, 15345, 57734);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 376, 15345, 57734);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 376, 15345, 57734);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 376, 15345, 57734);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 376, 15345, 57734);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 376, 15345, 57734);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 376, 15345, 57734);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 376, 15345, 57734);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 376, 15345, 57734);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 376, 15345, 57734);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 376, 15345, 57734);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 376, 15345, 57734);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 376, 15345, 57734);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 376, 15345, 57734);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 376, 15345, 57734);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 376, 15345, 57734);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 380, 18004, 18014);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 380, 18004, 18014).getDimension())), "n", 380, 17990, 18030);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 381, 18040, 18083);
            final int np = CallChecker.varInit(((int) (n + 1)), "np", 382, 18093, 18113);
            final int nptm = CallChecker.varInit(((int) (npt - np)), "nptm", 383, 18123, 18148);
            final int nh = CallChecker.varInit(((int) ((n * np) / 2)), "nh", 384, 18158, 18183);
            final ArrayRealVector work1 = CallChecker.varInit(new ArrayRealVector(n), "work1", 386, 18194, 18246);
            final ArrayRealVector work2 = CallChecker.varInit(new ArrayRealVector(npt), "work2", 387, 18256, 18310);
            final ArrayRealVector work3 = CallChecker.varInit(new ArrayRealVector(npt), "work3", 388, 18320, 18374);
            double cauchy = CallChecker.varInit(((double) (Double.NaN)), "cauchy", 390, 18385, 18411);
            double alpha = CallChecker.varInit(((double) (Double.NaN)), "alpha", 391, 18421, 18446);
            double dsq = CallChecker.varInit(((double) (Double.NaN)), "dsq", 392, 18456, 18479);
            double crvmin = CallChecker.varInit(((double) (Double.NaN)), "crvmin", 393, 18489, 18515);
            trustRegionCenterInterpolationPointIndex = 0;
            CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 407, 19107, 19151);
            prelim(lowerBound, upperBound);
            double xoptsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "xoptsq", 410, 19202, 19222);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 412, 19310, 19328)) {
                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 412, 19274, 19296)) {
                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 412, 19310, 19328);
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 412, 19274, 19296);
                        CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 412, 19274, 19296).setEntry(i, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 412, 19310, 19328).getEntry(trustRegionCenterInterpolationPointIndex, i));
                    }
                }
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 414, 19457, 19479);
                final double deltaOne = CallChecker.varInit(((double) (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 414, 19457, 19479).getEntry(i))), "deltaOne", 414, 19398, 19492);
                xoptsq += deltaOne * deltaOne;
                CallChecker.varAssign(xoptsq, "xoptsq", 415, 19506, 19535);
            }
            double fsave = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 417, 19570, 19591)) {
                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 417, 19570, 19591);
                fsave = CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 417, 19570, 19591).getEntry(0);
                CallChecker.varAssign(fsave, "fsave", 417, 19570, 19591);
            }
            final int kbase = CallChecker.varInit(((int) (0)), "kbase", 418, 19614, 19633);
            int ntrits = CallChecker.varInit(((int) (0)), "ntrits", 422, 19725, 19739);
            int itest = CallChecker.varInit(((int) (0)), "itest", 423, 19749, 19762);
            int knew = CallChecker.varInit(((int) (0)), "knew", 424, 19772, 19784);
            int nfsav = CallChecker.varInit(((int) (getEvaluations())), "nfsav", 425, 19794, 19822);
            double rho = CallChecker.varInit(((double) (this.initialTrustRegionRadius)), "rho", 426, 19832, 19869);
            double delta = CallChecker.varInit(((double) (rho)), "delta", 427, 19879, 19897);
            double diffa = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffa", 428, 19907, 19926);
            double diffb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffb", 429, 19936, 19955);
            double diffc = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "diffc", 430, 19965, 19984);
            double f = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "f", 431, 19994, 20009);
            double beta = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "beta", 432, 20019, 20037);
            double adelt = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "adelt", 433, 20047, 20066);
            double denom = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "denom", 434, 20076, 20095);
            double ratio = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ratio", 435, 20105, 20124);
            double dnorm = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dnorm", 436, 20134, 20153);
            double scaden = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "scaden", 437, 20163, 20183);
            double biglsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "biglsq", 438, 20193, 20213);
            double distsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "distsq", 439, 20223, 20243);
            int state = CallChecker.varInit(((int) (20)), "state", 444, 20388, 20402);
            for (; ;)
                switch (state) {
                    case 20 :
                        {
                            BOBYQAOptimizer.printState(20);
                            if ((trustRegionCenterInterpolationPointIndex) != kbase) {
                                int ih = CallChecker.varInit(((int) (0)), "ih", 449, 20576, 20586);
                                for (int j = 0; j < n; j++) {
                                    for (int i = 0; i <= j; i++) {
                                        if (i < j) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20791, 20817)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 453, 20833, 20860)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 453, 20877, 20899)) {
                                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20750, 20776)) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20791, 20817);
                                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 453, 20833, 20860);
                                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 453, 20877, 20899);
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20750, 20776);
                                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20750, 20776).setEntry(j, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 453, 20791, 20817).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 453, 20833, 20860).getEntry(ih)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 453, 20877, 20899).getEntry(i)))));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 21006, 21032)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 455, 21048, 21075)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 455, 21092, 21114)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 20965, 20991)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 21006, 21032);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 455, 21048, 21075);
                                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 455, 21092, 21114);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 20965, 20991);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 20965, 20991).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 455, 21006, 21032).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 455, 21048, 21075).getEntry(ih)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 455, 21092, 21114).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                if ((getEvaluations()) > npt) {
                                    for (int k = 0; k < npt; k++) {
                                        double temp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "temp", 461, 21322, 21340);
                                        for (int j = 0; j < n; j++) {
                                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 463, 21432, 21450)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 463, 21469, 21491)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 463, 21432, 21450);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 463, 21469, 21491);
                                                    temp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 463, 21432, 21450).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 463, 21469, 21491).getEntry(j));
                                                    CallChecker.varAssign(temp, "temp", 463, 21424, 21504);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 465, 21564, 21595)) {
                                            modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 465, 21564, 21595);
                                            temp *= CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 465, 21564, 21595).getEntry(k);
                                            CallChecker.varAssign(temp, "temp", 465, 21556, 21608);
                                        }
                                        for (int i = 0; i < n; i++) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21732, 21758)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 467, 21781, 21799)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21692, 21718)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21732, 21758);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 467, 21781, 21799);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21692, 21718);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21692, 21718).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 467, 21732, 21758).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 467, 21781, 21799).getEntry(k, i)))));
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
                            final ArrayRealVector gnew = CallChecker.varInit(new ArrayRealVector(n), "gnew", 484, 22546, 22597);
                            final ArrayRealVector xbdi = CallChecker.varInit(new ArrayRealVector(n), "xbdi", 485, 22611, 22662);
                            final ArrayRealVector s = CallChecker.varInit(new ArrayRealVector(n), "s", 486, 22676, 22724);
                            final ArrayRealVector hs = CallChecker.varInit(new ArrayRealVector(n), "hs", 487, 22738, 22787);
                            final ArrayRealVector hred = CallChecker.varInit(new ArrayRealVector(n), "hred", 488, 22801, 22852);
                            final double[] dsqCrvmin = CallChecker.varInit(trsbox(delta, gnew, xbdi, s, hs, hred), "dsqCrvmin", 490, 22867, 22978);
                            if (CallChecker.beforeDeref(dsqCrvmin, double[].class, 492, 22998, 23006)) {
                                dsq = CallChecker.isCalled(dsqCrvmin, double[].class, 492, 22998, 23006)[0];
                                CallChecker.varAssign(dsq, "dsq", 492, 22992, 23010);
                            }
                            if (CallChecker.beforeDeref(dsqCrvmin, double[].class, 493, 23033, 23041)) {
                                crvmin = CallChecker.isCalled(dsqCrvmin, double[].class, 493, 23033, 23041)[1];
                                CallChecker.varAssign(crvmin, "crvmin", 493, 23024, 23045);
                            }
                            double deltaOne = CallChecker.varInit(((double) (delta)), "deltaOne", 496, 23089, 23112);
                            double deltaTwo = CallChecker.varInit(((double) (Math.sqrt(dsq))), "deltaTwo", 497, 23126, 23158);
                            dnorm = Math.min(deltaOne, deltaTwo);
                            CallChecker.varAssign(dnorm, "dnorm", 498, 23172, 23208);
                            if (dnorm < ((BOBYQAOptimizer.HALF) * rho)) {
                                ntrits = -1;
                                CallChecker.varAssign(ntrits, "ntrits", 500, 23264, 23275);
                                deltaOne = (BOBYQAOptimizer.TEN) * rho;
                                CallChecker.varAssign(deltaOne, "deltaOne", 502, 23332, 23352);
                                distsq = deltaOne * deltaOne;
                                CallChecker.varAssign(distsq, "distsq", 503, 23370, 23398);
                                if ((getEvaluations()) <= (nfsav + 2)) {
                                    state = 650;
                                    CallChecker.varAssign(state, "state", 505, 23473, 23484);
                                    break;
                                }
                                deltaOne = Math.max(diffa, diffb);
                                CallChecker.varAssign(deltaOne, "deltaOne", 515, 24011, 24044);
                                final double errbig = CallChecker.varInit(((double) (Math.max(deltaOne, diffc))), "errbig", 516, 24062, 24109);
                                final double frhosq = CallChecker.varInit(((double) ((rho * (BOBYQAOptimizer.ONE_OVER_EIGHT)) * rho)), "frhosq", 517, 24127, 24175);
                                if ((crvmin > (BOBYQAOptimizer.ZERO)) && (errbig > (frhosq * crvmin))) {
                                    state = 650;
                                    CallChecker.varAssign(state, "state", 520, 24282, 24293);
                                    break;
                                }
                                final double bdtol = CallChecker.varInit(((double) (errbig / rho)), "bdtol", 522, 24336, 24369);
                                for (int j = 0; j < n; j++) {
                                    double bdtest = CallChecker.varInit(((double) (bdtol)), "bdtest", 524, 24437, 24458);
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 525, 24484, 24491)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 525, 24508, 24522)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 525, 24484, 24491);
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 525, 24508, 24522);
                                            if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 525, 24484, 24491).getEntry(j)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 525, 24508, 24522).getEntry(j))) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 526, 24572, 24576)) {
                                                    bdtest = CallChecker.isCalled(work1, ArrayRealVector.class, 526, 24572, 24576).getEntry(j);
                                                    CallChecker.varAssign(bdtest, "bdtest", 526, 24563, 24589);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 528, 24637, 24644)) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 528, 24661, 24675)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 528, 24637, 24644);
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 528, 24661, 24675);
                                            if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 528, 24637, 24644).getEntry(j)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 528, 24661, 24675).getEntry(j))) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 529, 24726, 24730)) {
                                                    bdtest = -(CallChecker.isCalled(work1, ArrayRealVector.class, 529, 24726, 24730).getEntry(j));
                                                    CallChecker.varAssign(bdtest, "bdtest", 529, 24716, 24743);
                                                }
                                            }
                                        }
                                    }
                                    if (bdtest < bdtol) {
                                        double curv = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 532, 24847, 24874)) {
                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 532, 24847, 24874);
                                            curv = CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 532, 24847, 24874).getEntry(((j + (j * j)) / 2));
                                            CallChecker.varAssign(curv, "curv", 532, 24847, 24874);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 535, 25056, 25074);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 535, 25056, 25074).getEntry(k, j))), "d1", 535, 24987, 25090);
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 536, 25128, 25159)) {
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 536, 25128, 25159);
                                                curv += (CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 536, 25128, 25159).getEntry(k)) * (d1 * d1);
                                                CallChecker.varAssign(curv, "curv", 536, 25120, 25184);
                                            }
                                        }
                                        bdtest += ((BOBYQAOptimizer.HALF) * curv) * rho;
                                        CallChecker.varAssign(bdtest, "bdtest", 538, 25236, 25263);
                                        if (bdtest < bdtol) {
                                            state = 650;
                                            CallChecker.varAssign(state, "state", 540, 25339, 25350);
                                            break;
                                        }
                                    }
                                }
                                state = 680;
                                CallChecker.varAssign(state, "state", 545, 25512, 25523);
                                break;
                            }
                            ++ntrits;
                        }
                    case 90 :
                        {
                            BOBYQAOptimizer.printState(90);
                            if (dsq <= (xoptsq * (BOBYQAOptimizer.ONE_OVER_A_THOUSAND))) {
                                final double fracsq = CallChecker.varInit(((double) (xoptsq * (BOBYQAOptimizer.ONE_OVER_FOUR))), "fracsq", 559, 26128, 26172);
                                double sumpq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumpq", 560, 26190, 26209);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 564, 26453, 26484)) {
                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 564, 26453, 26484);
                                        sumpq += CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 564, 26453, 26484).getEntry(k);
                                        CallChecker.varAssign(sumpq, "sumpq", 564, 26444, 26497);
                                    }
                                    double sum = CallChecker.varInit(((double) ((-(BOBYQAOptimizer.HALF)) * xoptsq)), "sum", 565, 26519, 26546);
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 567, 26629, 26647)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 567, 26666, 26688)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 567, 26629, 26647);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 567, 26666, 26688);
                                                sum += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 567, 26629, 26647).getEntry(k, i)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 567, 26666, 26688).getEntry(i));
                                                CallChecker.varAssign(sum, "sum", 567, 26622, 26701);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 570, 26841, 26845)) {
                                        CallChecker.isCalled(work2, ArrayRealVector.class, 570, 26841, 26845).setEntry(k, sum);
                                    }
                                    final double temp = CallChecker.varInit(((double) (fracsq - ((BOBYQAOptimizer.HALF) * sum))), "temp", 571, 26885, 26924);
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 573, 27018, 27024)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 573, 27000, 27004)) {
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 573, 27018, 27024);
                                                CallChecker.isCalled(work1, ArrayRealVector.class, 573, 27000, 27004).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 573, 27018, 27024).getEntry(k, i));
                                            }
                                        }
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 574, 27110, 27128)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 574, 27154, 27176)) {
                                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27067, 27090)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 574, 27110, 27128);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 574, 27154, 27176);
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27067, 27090);
                                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 574, 27067, 27090).setEntry(i, ((sum * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 574, 27110, 27128).getEntry(k, i))) + (temp * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 574, 27154, 27176).getEntry(i)))));
                                                }
                                            }
                                        }
                                        final int ip = CallChecker.varInit(((int) (npt + i)), "ip", 575, 27216, 27238);
                                        for (int j = 0; j <= i; j++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 578, 27389, 27395)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 579, 27457, 27461)) {
                                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 579, 27477, 27500)) {
                                                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 580, 27558, 27581)) {
                                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 580, 27597, 27601)) {
                                                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 577, 27323, 27329)) {
                                                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 578, 27389, 27395);
                                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 579, 27477, 27500);
                                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 580, 27558, 27581);
                                                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 577, 27323, 27329);
                                                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 577, 27323, 27329).setEntry(ip, j, (((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 578, 27389, 27395).getEntry(ip, j)) + ((CallChecker.isCalled(work1, ArrayRealVector.class, 579, 27457, 27461).getEntry(i)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 579, 27477, 27500).getEntry(j)))) + ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 580, 27558, 27581).getEntry(i)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 580, 27597, 27601).getEntry(j)))));
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
                                    double sumz = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumz", 588, 27836, 27854);
                                    double sumw = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumw", 589, 27876, 27894);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 591, 27980, 27986)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 591, 27980, 27986);
                                            sumz += CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 591, 27980, 27986).getEntry(k, m);
                                            CallChecker.varAssign(sumz, "sumz", 591, 27972, 28002);
                                        }
                                        if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 592, 28065, 28069)) {
                                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 592, 28085, 28091)) {
                                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 592, 28028, 28051)) {
                                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 592, 28085, 28091);
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 592, 28028, 28051);
                                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 592, 28028, 28051).setEntry(k, ((CallChecker.isCalled(work2, ArrayRealVector.class, 592, 28065, 28069).getEntry(k)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 592, 28085, 28091).getEntry(k, m))));
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28142, 28165)) {
                                            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28142, 28165);
                                            sumw += CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 593, 28142, 28165).getEntry(k);
                                            CallChecker.varAssign(sumw, "sumw", 593, 28134, 28178);
                                        }
                                    }
                                    for (int j = 0; j < n; j++) {
                                        double sum = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 596, 28321, 28343)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 596, 28321, 28343);
                                            sum = ((fracsq * sumz) - ((BOBYQAOptimizer.HALF) * sumw)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 596, 28321, 28343).getEntry(j));
                                            CallChecker.varAssign(sum, "sum", 596, 28321, 28343);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 598, 28449, 28472)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 598, 28488, 28506)) {
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 598, 28449, 28472);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 598, 28488, 28506);
                                                    sum += (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 598, 28449, 28472).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 598, 28488, 28506).getEntry(k, j));
                                                    CallChecker.varAssign(sum, "sum", 598, 28442, 28522);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 600, 28574, 28578)) {
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 600, 28574, 28578).setEntry(j, sum);
                                        }
                                        for (int k = 0; k < npt; k++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 603, 28747, 28753)) {
                                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 604, 28820, 28826)) {
                                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 602, 28682, 28688)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 603, 28747, 28753);
                                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 604, 28820, 28826);
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 602, 28682, 28688);
                                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 602, 28682, 28688).setEntry(k, j, ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 603, 28747, 28753).getEntry(k, j)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 604, 28820, 28826).getEntry(k, m)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    for (int i = 0; i < n; i++) {
                                        final int ip = CallChecker.varInit(((int) (i + npt)), "ip", 608, 28967, 28989);
                                        final double temp = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 609, 29035, 29039).getEntry(i))), "temp", 609, 29015, 29052);
                                        for (int j = 0; j <= i; j++) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 612, 29203, 29209)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 613, 29278, 29282)) {
                                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 611, 29137, 29143)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 612, 29203, 29209);
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 611, 29137, 29143);
                                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 611, 29137, 29143).setEntry(ip, j, ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 612, 29203, 29209).getEntry(ip, j)) + (temp * (CallChecker.isCalled(work1, ArrayRealVector.class, 613, 29278, 29282).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                int ih = CallChecker.varInit(((int) (0)), "ih", 621, 29549, 29559);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 623, 29661, 29683)) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 623, 29627, 29631)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 623, 29661, 29683);
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 623, 29627, 29631).setEntry(j, (((-(BOBYQAOptimizer.HALF)) * sumpq) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 623, 29661, 29683).getEntry(j))));
                                        }
                                    }
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 625, 29793, 29797)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 625, 29813, 29844)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 625, 29860, 29878)) {
                                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 625, 29775, 29779)) {
                                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 625, 29813, 29844);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 625, 29860, 29878);
                                                        CallChecker.isCalled(work1, ArrayRealVector.class, 625, 29775, 29779).setEntry(j, ((CallChecker.isCalled(work1, ArrayRealVector.class, 625, 29793, 29797).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 625, 29813, 29844).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 625, 29860, 29878).getEntry(k, j)))));
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 626, 29956, 29974)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 626, 29993, 30015)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 626, 29921, 29939)) {
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 626, 29956, 29974);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 626, 29993, 30015);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 626, 29921, 29939);
                                                    CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 626, 29921, 29939).setEntry(k, j, ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 626, 29956, 29974).getEntry(k, j)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 626, 29993, 30015).getEntry(j))));
                                                }
                                            }
                                        }
                                    }
                                    for (int i = 0; i <= j; i++) {
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 630, 30207, 30234)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 631, 30287, 30291)) {
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 631, 30307, 30329)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 632, 30381, 30403)) {
                                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 632, 30419, 30423)) {
                                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 629, 30129, 30156)) {
                                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 630, 30207, 30234);
                                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 631, 30307, 30329);
                                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 632, 30381, 30403);
                                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 629, 30129, 30156);
                                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 629, 30129, 30156).setEntry(ih, (((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 630, 30207, 30234).getEntry(ih)) + ((CallChecker.isCalled(work1, ArrayRealVector.class, 631, 30287, 30291).getEntry(i)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 631, 30307, 30329).getEntry(j)))) + ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 632, 30381, 30403).getEntry(i)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 632, 30419, 30423).getEntry(j)))));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 633, 30492, 30498)) {
                                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 633, 30463, 30469)) {
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 633, 30492, 30498);
                                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 633, 30463, 30469);
                                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 633, 30463, 30469).setEntry((npt + i), j, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 633, 30492, 30498).getEntry((npt + j), i));
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 638, 30683, 30693)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 638, 30709, 30731)) {
                                            if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 638, 30659, 30669)) {
                                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 638, 30683, 30693);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 638, 30709, 30731);
                                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 638, 30659, 30669);
                                                CallChecker.isCalled(originShift, ArrayRealVector.class, 638, 30659, 30669).setEntry(i, ((CallChecker.isCalled(originShift, ArrayRealVector.class, 638, 30683, 30693).getEntry(i)) + (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 638, 30709, 30731).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 639, 30788, 30795)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 639, 30811, 30833)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 639, 30767, 30774)) {
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 639, 30788, 30795);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 639, 30811, 30833);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 639, 30767, 30774);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 639, 30767, 30774).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 639, 30788, 30795).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 639, 30811, 30833).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 640, 30897, 30911)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 640, 30927, 30949)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 640, 30869, 30883)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 640, 30897, 30911);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 640, 30927, 30949);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 640, 30869, 30883);
                                                CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 640, 30869, 30883).setEntry(i, ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 640, 30897, 30911).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 640, 30927, 30949).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 641, 31013, 31027)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 641, 31043, 31065)) {
                                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 641, 30985, 30999)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 641, 31013, 31027);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 641, 31043, 31065);
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 641, 30985, 30999);
                                                CallChecker.isCalled(upperDifference, ArrayRealVector.class, 641, 30985, 30999).setEntry(i, ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 641, 31013, 31027).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 641, 31043, 31065).getEntry(i))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 642, 31101, 31123)) {
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 642, 31101, 31123);
                                        CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 642, 31101, 31123).setEntry(i, BOBYQAOptimizer.ZERO);
                                    }
                                }
                                xoptsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(xoptsq, "xoptsq", 644, 31178, 31191);
                            }
                            if (ntrits == 0) {
                                state = 210;
                                CallChecker.varAssign(state, "state", 647, 31254, 31265);
                                break;
                            }
                            state = 230;
                            CallChecker.varAssign(state, "state", 649, 31300, 31311);
                            break;
                        }
                    case 210 :
                        {
                            BOBYQAOptimizer.printState(210);
                            final double[] alphaCauchy = CallChecker.varInit(altmov(knew, adelt), "alphaCauchy", 674, 32877, 32925);
                            if (CallChecker.beforeDeref(alphaCauchy, double[].class, 675, 32947, 32957)) {
                                alpha = CallChecker.isCalled(alphaCauchy, double[].class, 675, 32947, 32957)[0];
                                CallChecker.varAssign(alpha, "alpha", 675, 32939, 32961);
                            }
                            if (CallChecker.beforeDeref(alphaCauchy, double[].class, 676, 32984, 32994)) {
                                cauchy = CallChecker.isCalled(alphaCauchy, double[].class, 676, 32984, 32994)[1];
                                CallChecker.varAssign(cauchy, "cauchy", 676, 32975, 32998);
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 679, 33086, 33093)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 679, 33109, 33131)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 679, 33059, 33072)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 679, 33086, 33093);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 679, 33109, 33131);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 679, 33059, 33072);
                                            CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 679, 33059, 33072).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 679, 33086, 33093).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 679, 33109, 33131).getEntry(i))));
                                        }
                                    }
                                }
                            }
                        }
                    case 230 :
                        {
                            BOBYQAOptimizer.printState(230);
                            for (int k = 0; k < npt; k++) {
                                double suma = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "suma", 690, 33491, 33509);
                                double sumb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumb", 691, 33527, 33545);
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 692, 33563, 33580);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 694, 33656, 33674)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 694, 33693, 33706)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 694, 33656, 33674);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 694, 33693, 33706);
                                            suma += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 694, 33656, 33674).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 694, 33693, 33706).getEntry(j));
                                            CallChecker.varAssign(suma, "suma", 694, 33648, 33719);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 695, 33749, 33767)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 695, 33786, 33808)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 695, 33749, 33767);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 695, 33786, 33808);
                                            sumb += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 695, 33749, 33767).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 695, 33786, 33808).getEntry(j));
                                            CallChecker.varAssign(sumb, "sumb", 695, 33741, 33821);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 696, 33850, 33856)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 696, 33875, 33888)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 696, 33850, 33856);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 696, 33875, 33888);
                                            sum += (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 696, 33850, 33856).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 696, 33875, 33888).getEntry(j));
                                            CallChecker.varAssign(sum, "sum", 696, 33843, 33901);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 698, 33937, 33941)) {
                                    CallChecker.isCalled(work3, ArrayRealVector.class, 698, 33937, 33941).setEntry(k, (suma * (((BOBYQAOptimizer.HALF) * suma) + sumb)));
                                }
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 699, 34001, 34024)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 699, 34001, 34024);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 699, 34001, 34024).setEntry(k, sum);
                                }
                                if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 700, 34060, 34064)) {
                                    CallChecker.isCalled(work2, ArrayRealVector.class, 700, 34060, 34064).setEntry(k, suma);
                                }
                            }
                            beta = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(beta, "beta", 702, 34111, 34122);
                            for (int m = 0; m < nptm; m++) {
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 704, 34185, 34202);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 706, 34279, 34285)) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 706, 34304, 34308)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 706, 34279, 34285);
                                            sum += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 706, 34279, 34285).getEntry(k, m)) * (CallChecker.isCalled(work3, ArrayRealVector.class, 706, 34304, 34308).getEntry(k));
                                            CallChecker.varAssign(sum, "sum", 706, 34272, 34321);
                                        }
                                    }
                                }
                                beta -= sum * sum;
                                CallChecker.varAssign(beta, "beta", 708, 34357, 34374);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34481, 34504)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 710, 34526, 34532)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34444, 34467)) {
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34481, 34504);
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 710, 34526, 34532);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34444, 34467);
                                                CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34444, 34467).setEntry(k, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 710, 34481, 34504).getEntry(k)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 710, 34526, 34532).getEntry(k, m)))));
                                            }
                                        }
                                    }
                                }
                            }
                            dsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dsq, "dsq", 713, 34595, 34605);
                            double bsum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "bsum", 714, 34619, 34637);
                            double dx = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dx", 715, 34651, 34667);
                            for (int j = 0; j < n; j++) {
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 718, 34784, 34797);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 718, 34784, 34797).getEntry(j))), "d1", 718, 34727, 34810);
                                dsq += d1 * d1;
                                CallChecker.varAssign(dsq, "dsq", 719, 34828, 34842);
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 720, 34860, 34877);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 722, 34954, 34958)) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 722, 34974, 34980)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 722, 34974, 34980);
                                            sum += (CallChecker.isCalled(work3, ArrayRealVector.class, 722, 34954, 34958).getEntry(k)) * (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 722, 34974, 34980).getEntry(k, j));
                                            CallChecker.varAssign(sum, "sum", 722, 34947, 34996);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 724, 35046, 35059)) {
                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 724, 35046, 35059);
                                    bsum += sum * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 724, 35046, 35059).getEntry(j));
                                    CallChecker.varAssign(bsum, "bsum", 724, 35032, 35072);
                                }
                                final int jp = CallChecker.varInit(((int) (npt + j)), "jp", 725, 35090, 35112);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 727, 35187, 35193)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 727, 35213, 35226)) {
                                            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 727, 35187, 35193);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 727, 35213, 35226);
                                            sum += (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 727, 35187, 35193).getEntry(jp, i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 727, 35213, 35226).getEntry(i));
                                            CallChecker.varAssign(sum, "sum", 727, 35180, 35239);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 729, 35275, 35298)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 729, 35275, 35298);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 729, 35275, 35298).setEntry(jp, sum);
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 730, 35349, 35362)) {
                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 730, 35349, 35362);
                                    bsum += sum * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 730, 35349, 35362).getEntry(j));
                                    CallChecker.varAssign(bsum, "bsum", 730, 35335, 35375);
                                }
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 731, 35399, 35412)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 731, 35428, 35450)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 731, 35399, 35412);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 731, 35428, 35450);
                                        dx += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 731, 35399, 35412).getEntry(j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 731, 35428, 35450).getEntry(j));
                                        CallChecker.varAssign(dx, "dx", 731, 35393, 35463);
                                    }
                                }
                            }
                            beta = (((dx * dx) + (dsq * (((xoptsq + dx) + dx) + ((BOBYQAOptimizer.HALF) * dsq)))) + beta) - bsum;
                            CallChecker.varAssign(beta, "beta", 734, 35492, 35560);
                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 739, 35924, 35947)) {
                                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 738, 35822, 35845)) {
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 739, 35924, 35947);
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 738, 35822, 35845);
                                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 738, 35822, 35845).setEntry(trustRegionCenterInterpolationPointIndex, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 739, 35924, 35947).getEntry(trustRegionCenterInterpolationPointIndex)) + (BOBYQAOptimizer.ONE)));
                                }
                            }
                            if (ntrits == 0) {
                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 747, 36345, 36368);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 747, 36345, 36368).getEntry(knew))), "d1", 747, 36288, 36384);
                                denom = (d1 * d1) + (alpha * beta);
                                CallChecker.varAssign(denom, "denom", 748, 36402, 36432);
                                if ((denom < cauchy) && (cauchy > (BOBYQAOptimizer.ZERO))) {
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 751, 36584, 36602)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 751, 36563, 36570)) {
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 751, 36584, 36602);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 751, 36563, 36570);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 751, 36563, 36570).setEntry(i, CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 751, 36584, 36602).getEntry(i));
                                            }
                                        }
                                        if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 752, 36669, 36676)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 752, 36692, 36714)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 752, 36642, 36655)) {
                                                    newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 752, 36669, 36676);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 752, 36692, 36714);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 752, 36642, 36655);
                                                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 752, 36642, 36655).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 752, 36669, 36676).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 752, 36692, 36714).getEntry(i))));
                                                }
                                            }
                                        }
                                    }
                                    cauchy = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(cauchy, "cauchy", 754, 36772, 36785);
                                    state = 230;
                                    CallChecker.varAssign(state, "state", 755, 36832, 36843);
                                    break;
                                }
                            }else {
                                final double delsq = CallChecker.varInit(((double) (delta * delta)), "delsq", 764, 37347, 37381);
                                scaden = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(scaden, "scaden", 765, 37399, 37412);
                                biglsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(biglsq, "biglsq", 766, 37430, 37443);
                                knew = 0;
                                CallChecker.varAssign(knew, "knew", 767, 37461, 37469);
                                for (int k = 0; k < npt; k++) {
                                    if (k == (trustRegionCenterInterpolationPointIndex)) {
                                        continue;
                                    }
                                    double hdiag = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "hdiag", 772, 37668, 37687);
                                    for (int m = 0; m < nptm; m++) {
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 775, 37831, 37837);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 775, 37831, 37837).getEntry(k, m))), "d1", 775, 37766, 37853);
                                        hdiag += d1 * d1;
                                        CallChecker.varAssign(hdiag, "hdiag", 776, 37879, 37895);
                                    }
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 779, 38000, 38023);
                                    final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 779, 38000, 38023).getEntry(k))), "d2", 779, 37939, 38036);
                                    final double den = CallChecker.varInit(((double) ((beta * hdiag) + (d2 * d2))), "den", 780, 38058, 38099);
                                    distsq = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(distsq, "distsq", 781, 38121, 38134);
                                    for (int j = 0; j < n; j++) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 784, 38275, 38293);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 784, 38312, 38334);
                                        final double d3 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 784, 38275, 38293).getEntry(k, j)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 784, 38312, 38334).getEntry(j)))), "d3", 784, 38210, 38347);
                                        distsq += d3 * d3;
                                        CallChecker.varAssign(distsq, "distsq", 785, 38373, 38390);
                                    }
                                    final double d4 = CallChecker.varInit(((double) (distsq / delsq)), "d4", 789, 38434, 38546);
                                    final double temp = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ONE, (d4 * d4)))), "temp", 790, 38568, 38610);
                                    if ((temp * den) > scaden) {
                                        scaden = temp * den;
                                        CallChecker.varAssign(scaden, "scaden", 792, 38683, 38702);
                                        knew = k;
                                        CallChecker.varAssign(knew, "knew", 793, 38728, 38736);
                                        denom = den;
                                        CallChecker.varAssign(denom, "denom", 794, 38762, 38773);
                                    }
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 798, 38915, 38938);
                                    final double d5 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 798, 38915, 38938).getEntry(k))), "d5", 798, 38817, 38951);
                                    biglsq = Math.max(biglsq, (temp * (d5 * d5)));
                                    CallChecker.varAssign(biglsq, "biglsq", 799, 38973, 39016);
                                }
                            }
                        }
                    case 360 :
                        {
                            BOBYQAOptimizer.printState(360);
                            for (int i = 0; i < n; i++) {
                                lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 815, 39571, 39580);
                                final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(lowerBound, double[].class, 815, 39571, 39580)[i])), "d3", 815, 39487, 39584);
                                originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 816, 39620, 39630);
                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 816, 39646, 39653);
                                final double d4 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.originShift, ArrayRealVector.class, 816, 39620, 39630).getEntry(i)) + (CallChecker.isCalled(this.newPoint, ArrayRealVector.class, 816, 39646, 39653).getEntry(i)))), "d4", 816, 39602, 39666);
                                final double d1 = CallChecker.varInit(((double) (Math.max(d3, d4))), "d1", 817, 39684, 39718);
                                upperBound = CallChecker.beforeCalled(upperBound, double[].class, 818, 39754, 39763);
                                final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(upperBound, double[].class, 818, 39754, 39763)[i])), "d2", 818, 39736, 39767);
                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 819, 39785, 39795)) {
                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 819, 39785, 39795);
                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 819, 39785, 39795).setEntry(i, Math.min(d1, d2));
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 820, 39848, 39855)) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 820, 39872, 39886)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 820, 39848, 39855);
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 820, 39872, 39886);
                                        if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 820, 39848, 39855).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 820, 39872, 39886).getEntry(i))) {
                                            if (CallChecker.beforeDeref(lowerBound, double[].class, 821, 39947, 39956)) {
                                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 821, 39923, 39933)) {
                                                    lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 821, 39947, 39956);
                                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 821, 39923, 39933);
                                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 821, 39923, 39933).setEntry(i, CallChecker.isCalled(lowerBound, double[].class, 821, 39947, 39956)[i]);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 823, 40001, 40008)) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 823, 40025, 40039)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 823, 40001, 40008);
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 823, 40025, 40039);
                                        if ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 823, 40001, 40008).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 823, 40025, 40039).getEntry(i))) {
                                            if (CallChecker.beforeDeref(upperBound, double[].class, 824, 40100, 40109)) {
                                                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 824, 40076, 40086)) {
                                                    upperBound = CallChecker.beforeCalled(upperBound, double[].class, 824, 40100, 40109);
                                                    currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 824, 40076, 40086);
                                                    CallChecker.isCalled(currentBest, ArrayRealVector.class, 824, 40076, 40086).setEntry(i, CallChecker.isCalled(upperBound, double[].class, 824, 40100, 40109)[i]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 828, 40187, 40197)) {
                                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 828, 40187, 40197);
                                f = computeObjectiveValue(CallChecker.isCalled(currentBest, ArrayRealVector.class, 828, 40187, 40197).toArray());
                                CallChecker.varAssign(f, "f", 828, 40161, 40209);
                            }
                            if (!(isMinimize)) {
                                f = -f;
                                CallChecker.varAssign(f, "f", 831, 40257, 40263);
                            }
                            if (ntrits == (-1)) {
                                fsave = f;
                                CallChecker.varAssign(fsave, "fsave", 833, 40313, 40322);
                                state = 720;
                                CallChecker.varAssign(state, "state", 834, 40340, 40351);
                                break;
                            }
                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 840, 40556, 40577);
                            final double fopt = CallChecker.varInit(((double) (CallChecker.isCalled(this.fAtInterpolationPoints, ArrayRealVector.class, 840, 40556, 40577).getEntry(this.trustRegionCenterInterpolationPointIndex))), "fopt", 840, 40387, 40629);
                            double vquad = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "vquad", 841, 40643, 40662);
                            int ih = CallChecker.varInit(((int) (0)), "ih", 842, 40676, 40686);
                            for (int j = 0; j < n; j++) {
                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 844, 40755, 40768)) {
                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 844, 40784, 40810)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 844, 40755, 40768);
                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 844, 40784, 40810);
                                        vquad += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 844, 40755, 40768).getEntry(j)) * (CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 844, 40784, 40810).getEntry(j));
                                        CallChecker.varAssign(vquad, "vquad", 844, 40746, 40823);
                                    }
                                }
                                for (int i = 0; i <= j; i++) {
                                    double temp = CallChecker.init(double.class);
                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 846, 40906, 40919)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 846, 40935, 40948)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 846, 40906, 40919);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 846, 40935, 40948);
                                            temp = (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 846, 40906, 40919).getEntry(i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 846, 40935, 40948).getEntry(j));
                                            CallChecker.varAssign(temp, "temp", 846, 40906, 40919);
                                        }
                                    }
                                    if (i == j) {
                                        temp *= BOBYQAOptimizer.HALF;
                                        CallChecker.varAssign(temp, "temp", 848, 41021, 41033);
                                    }
                                    if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 850, 41086, 41113)) {
                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 850, 41086, 41113);
                                        vquad += (CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 850, 41086, 41113).getEntry(ih)) * temp;
                                        CallChecker.varAssign(vquad, "vquad", 850, 41077, 41134);
                                    }
                                    ih++;
                                }
                            }
                            for (int k = 0; k < npt; k++) {
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work2, ArrayRealVector.class, 856, 41310, 41314).getEntry(k))), "d1", 856, 41253, 41327);
                                final double d2 = CallChecker.varInit(((double) (d1 * d1)), "d2", 857, 41345, 41370);
                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 858, 41460, 41491)) {
                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 858, 41460, 41491);
                                    vquad += ((BOBYQAOptimizer.HALF) * (CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 858, 41460, 41491).getEntry(k))) * d2;
                                    CallChecker.varAssign(vquad, "vquad", 858, 41444, 41509);
                                }
                            }
                            final double diff = CallChecker.varInit(((double) ((f - fopt) - vquad)), "diff", 860, 41537, 41573);
                            diffc = diffb;
                            CallChecker.varAssign(diffc, "diffc", 861, 41587, 41600);
                            diffb = diffa;
                            CallChecker.varAssign(diffb, "diffb", 862, 41614, 41627);
                            diffa = Math.abs(diff);
                            CallChecker.varAssign(diffa, "diffa", 863, 41641, 41663);
                            if (dnorm > rho) {
                                nfsav = getEvaluations();
                                CallChecker.varAssign(nfsav, "nfsav", 865, 41712, 41736);
                            }
                            if (ntrits > 0) {
                                if (vquad >= (BOBYQAOptimizer.ZERO)) {
                                    throw new MathIllegalStateException(LocalizedFormats.TRUST_REGION_STEP_FAILED, vquad);
                                }
                                ratio = (f - fopt) / vquad;
                                CallChecker.varAssign(ratio, "ratio", 874, 42033, 42059);
                                final double hDelta = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * delta)), "hDelta", 875, 42077, 42111);
                                if (ratio <= (BOBYQAOptimizer.ONE_OVER_TEN)) {
                                    delta = Math.min(hDelta, dnorm);
                                    CallChecker.varAssign(delta, "delta", 878, 42215, 42246);
                                }else
                                    if (ratio <= 0.7) {
                                        delta = Math.max(hDelta, dnorm);
                                        CallChecker.varAssign(delta, "delta", 881, 42347, 42378);
                                    }else {
                                        delta = Math.max(hDelta, (2 * dnorm));
                                        CallChecker.varAssign(delta, "delta", 884, 42462, 42497);
                                    }
                                
                                if (delta <= (rho * 1.5)) {
                                    delta = rho;
                                    CallChecker.varAssign(delta, "delta", 887, 42579, 42590);
                                }
                                if (f < fopt) {
                                    final int ksav = CallChecker.varInit(((int) (knew)), "ksav", 893, 42742, 42763);
                                    final double densav = CallChecker.varInit(((double) (denom)), "densav", 894, 42785, 42812);
                                    final double delsq = CallChecker.varInit(((double) (delta * delta)), "delsq", 895, 42834, 42868);
                                    scaden = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(scaden, "scaden", 896, 42890, 42903);
                                    biglsq = BOBYQAOptimizer.ZERO;
                                    CallChecker.varAssign(biglsq, "biglsq", 897, 42925, 42938);
                                    knew = 0;
                                    CallChecker.varAssign(knew, "knew", 898, 42960, 42968);
                                    for (int k = 0; k < npt; k++) {
                                        double hdiag = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "hdiag", 900, 43046, 43065);
                                        for (int m = 0; m < nptm; m++) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 903, 43221, 43227);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 903, 43221, 43227).getEntry(k, m))), "d1", 903, 43152, 43243);
                                            hdiag += d1 * d1;
                                            CallChecker.varAssign(hdiag, "hdiag", 904, 43273, 43289);
                                        }
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 907, 43406, 43429);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 907, 43406, 43429).getEntry(k))), "d1", 907, 43341, 43442);
                                        final double den = CallChecker.varInit(((double) ((beta * hdiag) + (d1 * d1))), "den", 908, 43468, 43509);
                                        distsq = BOBYQAOptimizer.ZERO;
                                        CallChecker.varAssign(distsq, "distsq", 909, 43535, 43548);
                                        for (int j = 0; j < n; j++) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 912, 43701, 43719);
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 912, 43738, 43745);
                                            final double d2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 912, 43701, 43719).getEntry(k, j)) - (CallChecker.isCalled(this.newPoint, ArrayRealVector.class, 912, 43738, 43745).getEntry(j)))), "d2", 912, 43632, 43758);
                                            distsq += d2 * d2;
                                            CallChecker.varAssign(distsq, "distsq", 913, 43788, 43805);
                                        }
                                        final double d3 = CallChecker.varInit(((double) (distsq / delsq)), "d3", 917, 43857, 43977);
                                        final double temp = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ONE, (d3 * d3)))), "temp", 918, 44003, 44045);
                                        if ((temp * den) > scaden) {
                                            scaden = temp * den;
                                            CallChecker.varAssign(scaden, "scaden", 920, 44126, 44145);
                                            knew = k;
                                            CallChecker.varAssign(knew, "knew", 921, 44175, 44183);
                                            denom = den;
                                            CallChecker.varAssign(denom, "denom", 922, 44213, 44224);
                                        }
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 926, 44382, 44405);
                                        final double d4 = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 926, 44382, 44405).getEntry(k))), "d4", 926, 44276, 44418);
                                        final double d5 = CallChecker.varInit(((double) (temp * (d4 * d4))), "d5", 927, 44444, 44478);
                                        biglsq = Math.max(biglsq, d5);
                                        CallChecker.varAssign(biglsq, "biglsq", 928, 44504, 44533);
                                    }
                                    if (scaden <= ((BOBYQAOptimizer.HALF) * biglsq)) {
                                        knew = ksav;
                                        CallChecker.varAssign(knew, "knew", 931, 44632, 44643);
                                        denom = densav;
                                        CallChecker.varAssign(denom, "denom", 932, 44669, 44683);
                                    }
                                }
                            }
                            update(beta, denom, knew);
                            ih = 0;
                            CallChecker.varAssign(ih, "ih", 942, 44953, 44959);
                            modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 943, 44994, 45025);
                            final double pqold = CallChecker.varInit(((double) (CallChecker.isCalled(this.modelSecondDerivativesParameters, ArrayRealVector.class, 943, 44994, 45025).getEntry(knew))), "pqold", 943, 44973, 45041);
                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 944, 45055, 45086)) {
                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 944, 45055, 45086);
                                CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 944, 45055, 45086).setEntry(knew, BOBYQAOptimizer.ZERO);
                            }
                            for (int i = 0; i < n; i++) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 946, 45196, 45214);
                                final double temp = CallChecker.varInit(((double) (pqold * (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 946, 45196, 45214).getEntry(knew, i)))), "temp", 946, 45168, 45233);
                                for (int j = 0; j <= i; j++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45344, 45371)) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 948, 45395, 45413)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45302, 45329)) {
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45344, 45371);
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 948, 45395, 45413);
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45302, 45329);
                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45302, 45329).setEntry(ih, ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 948, 45344, 45371).getEntry(ih)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 948, 45395, 45413).getEntry(knew, j)))));
                                            }
                                        }
                                    }
                                    ih++;
                                }
                            }
                            for (int m = 0; m < nptm; m++) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 953, 45581, 45587);
                                final double temp = CallChecker.varInit(((double) (diff * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 953, 45581, 45587).getEntry(knew, m)))), "temp", 953, 45554, 45606);
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45721, 45752)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 955, 45775, 45781)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45676, 45707)) {
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45721, 45752);
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 955, 45775, 45781);
                                                modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45676, 45707);
                                                CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45676, 45707).setEntry(k, ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 955, 45721, 45752).getEntry(k)) + (temp * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 955, 45775, 45781).getEntry(k, m)))));
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 962, 46014, 46035)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 962, 46014, 46035);
                                CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 962, 46014, 46035).setEntry(knew, f);
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 964, 46153, 46160)) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 964, 46115, 46133)) {
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 964, 46153, 46160);
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 964, 46115, 46133);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 964, 46115, 46133).setEntry(knew, i, CallChecker.isCalled(newPoint, ArrayRealVector.class, 964, 46153, 46160).getEntry(i));
                                    }
                                }
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 965, 46210, 46216)) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 965, 46192, 46196)) {
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 965, 46210, 46216);
                                        CallChecker.isCalled(work1, ArrayRealVector.class, 965, 46192, 46196).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 965, 46210, 46216).getEntry(knew, i));
                                    }
                                }
                            }
                            for (int k = 0; k < npt; k++) {
                                double suma = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "suma", 968, 46312, 46330);
                                for (int m = 0; m < nptm; m++) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 970, 46409, 46415)) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 970, 46437, 46443)) {
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 970, 46409, 46415);
                                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 970, 46437, 46443);
                                            suma += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 970, 46409, 46415).getEntry(knew, m)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 970, 46437, 46443).getEntry(k, m));
                                            CallChecker.varAssign(suma, "suma", 970, 46401, 46459);
                                        }
                                    }
                                }
                                double sumb = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sumb", 972, 46495, 46513);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 974, 46589, 46607)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 974, 46626, 46648)) {
                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 974, 46589, 46607);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 974, 46626, 46648);
                                            sumb += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 974, 46589, 46607).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 974, 46626, 46648).getEntry(j));
                                            CallChecker.varAssign(sumb, "sumb", 974, 46581, 46661);
                                        }
                                    }
                                }
                                final double temp = CallChecker.varInit(((double) (suma * sumb)), "temp", 976, 46697, 46728);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 978, 46814, 46818)) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 978, 46841, 46859)) {
                                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 978, 46796, 46800)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 978, 46841, 46859);
                                                CallChecker.isCalled(work1, ArrayRealVector.class, 978, 46796, 46800).setEntry(i, ((CallChecker.isCalled(work1, ArrayRealVector.class, 978, 46814, 46818).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 978, 46841, 46859).getEntry(k, i)))));
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 47008, 47034)) {
                                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 982, 47057, 47061)) {
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 46968, 46994)) {
                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 47008, 47034);
                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 46968, 46994);
                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 46968, 46994).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 982, 47008, 47034).getEntry(i)) + (diff * (CallChecker.isCalled(work1, ArrayRealVector.class, 982, 47057, 47061).getEntry(i)))));
                                        }
                                    }
                                }
                            }
                            if (f < fopt) {
                                trustRegionCenterInterpolationPointIndex = knew;
                                CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 988, 47222, 47269);
                                xoptsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(xoptsq, "xoptsq", 989, 47287, 47300);
                                ih = 0;
                                CallChecker.varAssign(ih, "ih", 990, 47318, 47324);
                                for (int j = 0; j < n; j++) {
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 992, 47428, 47435)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 992, 47392, 47414)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 992, 47428, 47435);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 992, 47392, 47414);
                                            CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 992, 47392, 47414).setEntry(j, CallChecker.isCalled(newPoint, ArrayRealVector.class, 992, 47428, 47435).getEntry(j));
                                        }
                                    }
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 994, 47532, 47554);
                                    final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 994, 47532, 47554).getEntry(j))), "d1", 994, 47471, 47567);
                                    xoptsq += d1 * d1;
                                    CallChecker.varAssign(xoptsq, "xoptsq", 995, 47589, 47606);
                                    for (int i = 0; i <= j; i++) {
                                        if (i < j) {
                                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47764, 47790)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 998, 47806, 47833)) {
                                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 998, 47850, 47863)) {
                                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47724, 47750)) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47764, 47790);
                                                            modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 998, 47806, 47833);
                                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 998, 47850, 47863);
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47724, 47750);
                                                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47724, 47750).setEntry(j, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 998, 47764, 47790).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 998, 47806, 47833).getEntry(ih)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 998, 47850, 47863).getEntry(i)))));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47969, 47995)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1000, 48011, 48038)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1000, 48055, 48068)) {
                                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47929, 47955)) {
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47969, 47995);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1000, 48011, 48038);
                                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1000, 48055, 48068);
                                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47929, 47955);
                                                        CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47929, 47955).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1000, 47969, 47995).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1000, 48011, 48038).getEntry(ih)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1000, 48055, 48068).getEntry(j)))));
                                                    }
                                                }
                                            }
                                        }
                                        ih++;
                                    }
                                }
                                for (int k = 0; k < npt; k++) {
                                    double temp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "temp", 1005, 48222, 48240);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1007, 48324, 48342)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1007, 48361, 48374)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1007, 48324, 48342);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1007, 48361, 48374);
                                                temp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1007, 48324, 48342).getEntry(k, j)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1007, 48361, 48374).getEntry(j));
                                                CallChecker.varAssign(temp, "temp", 1007, 48316, 48387);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1009, 48439, 48470)) {
                                        modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1009, 48439, 48470);
                                        temp *= CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1009, 48439, 48470).getEntry(k);
                                        CallChecker.varAssign(temp, "temp", 1009, 48431, 48483);
                                    }
                                    for (int i = 0; i < n; i++) {
                                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48599, 48625)) {
                                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1011, 48648, 48666)) {
                                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48559, 48585)) {
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48599, 48625);
                                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1011, 48648, 48666);
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48559, 48585);
                                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48559, 48585).setEntry(i, ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1011, 48599, 48625).getEntry(i)) + (temp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1011, 48648, 48666).getEntry(k, i)))));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (ntrits > 0) {
                                for (int k = 0; k < npt; k++) {
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49089, 49110)) {
                                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49126, 49147)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1022, 49052, 49075)) {
                                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49089, 49110);
                                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49126, 49147);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1022, 49052, 49075);
                                                CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1022, 49052, 49075).setEntry(k, ((CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49089, 49110).getEntry(k)) - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1022, 49126, 49147).getEntry(trustRegionCenterInterpolationPointIndex))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1023, 49222, 49226)) {
                                        CallChecker.isCalled(work3, ArrayRealVector.class, 1023, 49222, 49226).setEntry(k, BOBYQAOptimizer.ZERO);
                                    }
                                }
                                for (int j = 0; j < nptm; j++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1026, 49334, 49351);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1028, 49436, 49442)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1028, 49461, 49484)) {
                                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1028, 49436, 49442);
                                                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1028, 49461, 49484);
                                                sum += (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1028, 49436, 49442).getEntry(k, j)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1028, 49461, 49484).getEntry(k));
                                                CallChecker.varAssign(sum, "sum", 1028, 49429, 49497);
                                            }
                                        }
                                    }
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1031, 49615, 49619)) {
                                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1031, 49641, 49647)) {
                                                if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1031, 49597, 49601)) {
                                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1031, 49641, 49647);
                                                    CallChecker.isCalled(work3, ArrayRealVector.class, 1031, 49597, 49601).setEntry(k, ((CallChecker.isCalled(work3, ArrayRealVector.class, 1031, 49615, 49619).getEntry(k)) + (sum * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1031, 49641, 49647).getEntry(k, j)))));
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int k = 0; k < npt; k++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1035, 49774, 49791);
                                    for (int j = 0; j < n; j++) {
                                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1037, 49874, 49892)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1037, 49911, 49933)) {
                                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1037, 49874, 49892);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1037, 49911, 49933);
                                                sum += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1037, 49874, 49892).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1037, 49911, 49933).getEntry(j));
                                                CallChecker.varAssign(sum, "sum", 1037, 49867, 49946);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1039, 50008, 50012)) {
                                        if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1039, 49990, 49994)) {
                                            CallChecker.isCalled(work2, ArrayRealVector.class, 1039, 49990, 49994).setEntry(k, CallChecker.isCalled(work3, ArrayRealVector.class, 1039, 50008, 50012).getEntry(k));
                                        }
                                    }
                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1040, 50072, 50076)) {
                                        if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1040, 50048, 50052)) {
                                            CallChecker.isCalled(work3, ArrayRealVector.class, 1040, 50048, 50052).setEntry(k, (sum * (CallChecker.isCalled(work3, ArrayRealVector.class, 1040, 50072, 50076).getEntry(k))));
                                        }
                                    }
                                }
                                double gqsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gqsq", 1042, 50126, 50144);
                                double gisq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gisq", 1043, 50162, 50180);
                                for (int i = 0; i < n; i++) {
                                    double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1045, 50248, 50265);
                                    for (int k = 0; k < npt; k++) {
                                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1047, 50350, 50356)) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1048, 50403, 50426)) {
                                                if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1048, 50442, 50460)) {
                                                    if (CallChecker.beforeDeref(work3, ArrayRealVector.class, 1048, 50479, 50483)) {
                                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1047, 50350, 50356);
                                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1048, 50403, 50426);
                                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1048, 50442, 50460);
                                                        sum += ((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1047, 50350, 50356).getEntry(k, i)) * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1048, 50403, 50426).getEntry(k))) + ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1048, 50442, 50460).getEntry(k, i)) * (CallChecker.isCalled(work3, ArrayRealVector.class, 1048, 50479, 50483).getEntry(k)));
                                                        CallChecker.varAssign(sum, "sum", 1047, 50343, 50496);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1050, 50544, 50566)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1050, 50583, 50597)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1050, 50544, 50566);
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1050, 50583, 50597);
                                            if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1050, 50544, 50566).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1050, 50583, 50597).getEntry(i))) {
                                                gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1053, 50759, 50785);
                                                final double d1 = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ZERO, CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1053, 50759, 50785).getEntry(i)))), "d1", 1053, 50638, 50799);
                                                gqsq += d1 * d1;
                                                CallChecker.varAssign(gqsq, "gqsq", 1054, 50825, 50840);
                                                final double d2 = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ZERO, sum))), "d2", 1056, 50866, 50950);
                                                gisq += d2 * d2;
                                                CallChecker.varAssign(gisq, "gisq", 1057, 50976, 50991);
                                            }else
                                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1058, 51024, 51046)) {
                                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1058, 51063, 51077)) {
                                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1058, 51024, 51046);
                                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1058, 51063, 51077);
                                                        if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1058, 51024, 51046).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1058, 51063, 51077).getEntry(i))) {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1061, 51239, 51265);
                                                            final double d1 = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ZERO, CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1061, 51239, 51265).getEntry(i)))), "d1", 1061, 51118, 51279);
                                                            gqsq += d1 * d1;
                                                            CallChecker.varAssign(gqsq, "gqsq", 1062, 51305, 51320);
                                                            final double d2 = CallChecker.varInit(((double) (Math.max(BOBYQAOptimizer.ZERO, sum))), "d2", 1064, 51346, 51430);
                                                            gisq += d2 * d2;
                                                            CallChecker.varAssign(gisq, "gisq", 1065, 51456, 51471);
                                                        }else {
                                                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1068, 51591, 51617);
                                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.gradientAtTrustRegionCenter, ArrayRealVector.class, 1068, 51591, 51617).getEntry(i))), "d1", 1068, 51526, 51630);
                                                            gqsq += d1 * d1;
                                                            CallChecker.varAssign(gqsq, "gqsq", 1069, 51656, 51671);
                                                            gisq += sum * sum;
                                                            CallChecker.varAssign(gisq, "gisq", 1070, 51697, 51714);
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1072, 51758, 51781)) {
                                        lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1072, 51758, 51781);
                                        CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1072, 51758, 51781).setEntry((npt + i), sum);
                                    }
                                }
                                ++itest;
                                if (gqsq < ((BOBYQAOptimizer.TEN) * gisq)) {
                                    itest = 0;
                                    CallChecker.varAssign(itest, "itest", 1080, 52089, 52098);
                                }
                                if (itest >= 3) {
                                    for (int i = 0, max = Math.max(npt, nh); i < max; i++) {
                                        if (i < n) {
                                            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1085, 52334, 52357)) {
                                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1085, 52294, 52320)) {
                                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1085, 52334, 52357);
                                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1085, 52294, 52320);
                                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1085, 52294, 52320).setEntry(i, CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 1085, 52334, 52357).getEntry((npt + i)));
                                                }
                                            }
                                        }
                                        if (i < npt) {
                                            if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1088, 52517, 52521)) {
                                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1088, 52472, 52503)) {
                                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1088, 52472, 52503);
                                                    CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1088, 52472, 52503).setEntry(i, CallChecker.isCalled(work2, ArrayRealVector.class, 1088, 52517, 52521).getEntry(i));
                                                }
                                            }
                                        }
                                        if (i < nh) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1091, 52629, 52656)) {
                                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1091, 52629, 52656);
                                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1091, 52629, 52656).setEntry(i, BOBYQAOptimizer.ZERO);
                                            }
                                        }
                                        itest = 0;
                                        CallChecker.varAssign(itest, "itest", 1093, 52727, 52736);
                                    }
                                }
                            }
                            if (ntrits == 0) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1103, 53094, 53104);
                                break;
                            }
                            if (f <= (fopt + ((BOBYQAOptimizer.ONE_OVER_TEN) * vquad))) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1106, 53195, 53205);
                                break;
                            }
                            final double d1 = CallChecker.varInit(((double) ((BOBYQAOptimizer.TWO) * delta)), "d1", 1114, 53241, 53462);
                            final double d2 = CallChecker.varInit(((double) ((BOBYQAOptimizer.TEN) * rho)), "d2", 1116, 53476, 53538);
                            distsq = Math.max((d1 * d1), (d2 * d2));
                            CallChecker.varAssign(distsq, "distsq", 1117, 53552, 53587);
                        }
                    case 650 :
                        {
                            BOBYQAOptimizer.printState(650);
                            knew = -1;
                            CallChecker.varAssign(knew, "knew", 1121, 53667, 53676);
                            for (int k = 0; k < npt; k++) {
                                double sum = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "sum", 1123, 53738, 53755);
                                for (int j = 0; j < n; j++) {
                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1126, 53884, 53902);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1126, 53921, 53943);
                                    final double d1 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1126, 53884, 53902).getEntry(k, j)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1126, 53921, 53943).getEntry(j)))), "d1", 1126, 53823, 53956);
                                    sum += d1 * d1;
                                    CallChecker.varAssign(sum, "sum", 1127, 53978, 53992);
                                }
                                if (sum > distsq) {
                                    knew = k;
                                    CallChecker.varAssign(knew, "knew", 1130, 54068, 54076);
                                    distsq = sum;
                                    CallChecker.varAssign(distsq, "distsq", 1131, 54098, 54110);
                                }
                            }
                            if (knew >= 0) {
                                final double dist = CallChecker.varInit(((double) (Math.sqrt(distsq))), "dist", 1142, 54562, 54599);
                                if (ntrits == (-1)) {
                                    delta = Math.min(((BOBYQAOptimizer.ONE_OVER_TEN) * delta), ((BOBYQAOptimizer.HALF) * dist));
                                    CallChecker.varAssign(delta, "delta", 1145, 54694, 54745);
                                    if (delta <= (rho * 1.5)) {
                                        delta = rho;
                                        CallChecker.varAssign(delta, "delta", 1147, 54817, 54828);
                                    }
                                }
                                ntrits = 0;
                                CallChecker.varAssign(ntrits, "ntrits", 1150, 54886, 54896);
                                final double d1 = CallChecker.varInit(((double) (Math.min(((BOBYQAOptimizer.ONE_OVER_TEN) * dist), delta))), "d1", 1153, 54914, 55034);
                                adelt = Math.max(d1, rho);
                                CallChecker.varAssign(adelt, "adelt", 1154, 55052, 55077);
                                dsq = adelt * adelt;
                                CallChecker.varAssign(dsq, "dsq", 1155, 55095, 55114);
                                state = 90;
                                CallChecker.varAssign(state, "state", 1156, 55132, 55142);
                                break;
                            }
                            if (ntrits == (-1)) {
                                state = 680;
                                CallChecker.varAssign(state, "state", 1159, 55213, 55224);
                                break;
                            }
                            if (ratio > (BOBYQAOptimizer.ZERO)) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1162, 55295, 55305);
                                break;
                            }
                            if ((Math.max(delta, dnorm)) > rho) {
                                state = 60;
                                CallChecker.varAssign(state, "state", 1165, 55392, 55402);
                                break;
                            }
                        }
                    case 680 :
                        {
                            BOBYQAOptimizer.printState(680);
                            if (rho > (stoppingTrustRegionRadius)) {
                                delta = (BOBYQAOptimizer.HALF) * rho;
                                CallChecker.varAssign(delta, "delta", 1174, 55691, 55709);
                                ratio = rho / (stoppingTrustRegionRadius);
                                CallChecker.varAssign(ratio, "ratio", 1175, 55727, 55766);
                                if (ratio <= (BOBYQAOptimizer.SIXTEEN)) {
                                    rho = stoppingTrustRegionRadius;
                                    CallChecker.varAssign(rho, "rho", 1177, 55828, 55859);
                                }else
                                    if (ratio <= (BOBYQAOptimizer.TWO_HUNDRED_FIFTY)) {
                                        rho = (Math.sqrt(ratio)) * (stoppingTrustRegionRadius);
                                        CallChecker.varAssign(rho, "rho", 1179, 55938, 55988);
                                    }else {
                                        rho *= BOBYQAOptimizer.ONE_OVER_TEN;
                                        CallChecker.varAssign(rho, "rho", 1181, 56035, 56054);
                                    }
                                
                                delta = Math.max(delta, rho);
                                CallChecker.varAssign(delta, "delta", 1183, 56090, 56118);
                                ntrits = 0;
                                CallChecker.varAssign(ntrits, "ntrits", 1184, 56136, 56146);
                                nfsav = getEvaluations();
                                CallChecker.varAssign(nfsav, "nfsav", 1185, 56164, 56188);
                                state = 60;
                                CallChecker.varAssign(state, "state", 1186, 56206, 56216);
                                break;
                            }
                            if (ntrits == (-1)) {
                                state = 360;
                                CallChecker.varAssign(state, "state", 1193, 56431, 56442);
                                break;
                            }
                        }
                    case 720 :
                        {
                            BOBYQAOptimizer.printState(720);
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1198, 56547, 56568)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1198, 56547, 56568);
                                if ((CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1198, 56547, 56568).getEntry(trustRegionCenterInterpolationPointIndex)) <= fsave) {
                                    for (int i = 0; i < n; i++) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1202, 56791, 56800);
                                        final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(lowerBound, double[].class, 1202, 56791, 56800)[i])), "d3", 1202, 56699, 56804);
                                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1203, 56844, 56854);
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1203, 56870, 56892);
                                        final double d4 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.originShift, ArrayRealVector.class, 1203, 56844, 56854).getEntry(i)) + (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1203, 56870, 56892).getEntry(i)))), "d4", 1203, 56826, 56905);
                                        final double d1 = CallChecker.varInit(((double) (Math.max(d3, d4))), "d1", 1204, 56927, 56961);
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1205, 57001, 57010);
                                        final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(upperBound, double[].class, 1205, 57001, 57010)[i])), "d2", 1205, 56983, 57014);
                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1206, 57036, 57046)) {
                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1206, 57036, 57046);
                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1206, 57036, 57046).setEntry(i, Math.min(d1, d2));
                                        }
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1207, 57103, 57125)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1207, 57142, 57156)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1207, 57103, 57125);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1207, 57142, 57156);
                                                if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1207, 57103, 57125).getEntry(i)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1207, 57142, 57156).getEntry(i))) {
                                                    if (CallChecker.beforeDeref(lowerBound, double[].class, 1208, 57221, 57230)) {
                                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1208, 57197, 57207)) {
                                                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1208, 57221, 57230);
                                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1208, 57197, 57207);
                                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1208, 57197, 57207).setEntry(i, CallChecker.isCalled(lowerBound, double[].class, 1208, 57221, 57230)[i]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1210, 57283, 57305)) {
                                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1210, 57322, 57336)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1210, 57283, 57305);
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1210, 57322, 57336);
                                                if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1210, 57283, 57305).getEntry(i)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1210, 57322, 57336).getEntry(i))) {
                                                    if (CallChecker.beforeDeref(upperBound, double[].class, 1211, 57401, 57410)) {
                                                        if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1211, 57377, 57387)) {
                                                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1211, 57401, 57410);
                                                            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1211, 57377, 57387);
                                                            CallChecker.isCalled(currentBest, ArrayRealVector.class, 1211, 57377, 57387).setEntry(i, CallChecker.isCalled(upperBound, double[].class, 1211, 57401, 57410)[i]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1214, 57477, 57498)) {
                                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1214, 57477, 57498);
                                        f = CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1214, 57477, 57498).getEntry(trustRegionCenterInterpolationPointIndex);
                                        CallChecker.varAssign(f, "f", 1214, 57473, 57550);
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
            _bcornu_methode_context4534.methodEnd();
        }
    }

    private double[] altmov(int knew, double adelt) {
        MethodContext _bcornu_methode_context4535 = new MethodContext(double[].class, 1258, 57741, 73088);
        try {
            CallChecker.varInit(this, "this", 1258, 57741, 73088);
            CallChecker.varInit(adelt, "adelt", 1258, 57741, 73088);
            CallChecker.varInit(knew, "knew", 1258, 57741, 73088);
            CallChecker.varInit(this.evaluations, "evaluations", 1258, 57741, 73088);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1258, 57741, 73088);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1258, 57741, 73088);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1258, 57741, 73088);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1258, 57741, 73088);
            CallChecker.varInit(this.newPoint, "newPoint", 1258, 57741, 73088);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1258, 57741, 73088);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1258, 57741, 73088);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1258, 57741, 73088);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1258, 57741, 73088);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1258, 57741, 73088);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1258, 57741, 73088);
            CallChecker.varInit(this.originShift, "originShift", 1258, 57741, 73088);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1258, 57741, 73088);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1258, 57741, 73088);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1258, 57741, 73088);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1258, 57741, 73088);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1258, 57741, 73088);
            CallChecker.varInit(this.currentBest, "currentBest", 1258, 57741, 73088);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1258, 57741, 73088);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1258, 57741, 73088);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1258, 57741, 73088);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1258, 57741, 73088);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1258, 57741, 73088);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 1258, 57741, 73088);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 1258, 57741, 73088);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 1258, 57741, 73088);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 1258, 57741, 73088);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 1258, 57741, 73088);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1258, 57741, 73088);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 1258, 57741, 73088);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 1258, 57741, 73088);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 1258, 57741, 73088);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 1258, 57741, 73088);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 1258, 57741, 73088);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1258, 57741, 73088);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1258, 57741, 73088);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1258, 57741, 73088);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1264, 60139, 60149);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1264, 60139, 60149).getDimension())), "n", 1264, 60125, 60165);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1265, 60175, 60218);
            final ArrayRealVector glag = CallChecker.varInit(new ArrayRealVector(n), "glag", 1267, 60229, 60280);
            final ArrayRealVector hcol = CallChecker.varInit(new ArrayRealVector(npt), "hcol", 1268, 60290, 60343);
            final ArrayRealVector work1 = CallChecker.varInit(new ArrayRealVector(n), "work1", 1270, 60354, 60406);
            final ArrayRealVector work2 = CallChecker.varInit(new ArrayRealVector(n), "work2", 1271, 60416, 60468);
            for (int k = 0; k < npt; k++) {
                if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1274, 60523, 60526)) {
                    CallChecker.isCalled(hcol, ArrayRealVector.class, 1274, 60523, 60526).setEntry(k, BOBYQAOptimizer.ZERO);
                }
            }
            for (int j = 0, max = (npt - n) - 1; j < max; j++) {
                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1277, 60647, 60653);
                final double tmp = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 1277, 60647, 60653).getEntry(knew, j))), "tmp", 1277, 60628, 60672);
                for (int k = 0; k < npt; k++) {
                    if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1279, 60751, 60754)) {
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1279, 60776, 60782)) {
                            if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1279, 60734, 60737)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1279, 60776, 60782);
                                CallChecker.isCalled(hcol, ArrayRealVector.class, 1279, 60734, 60737).setEntry(k, ((CallChecker.isCalled(hcol, ArrayRealVector.class, 1279, 60751, 60754).getEntry(k)) + (tmp * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1279, 60776, 60782).getEntry(k, j)))));
                            }
                        }
                    }
                }
            }
            final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(hcol, ArrayRealVector.class, 1282, 60854, 60857).getEntry(knew))), "alpha", 1282, 60833, 60873);
            final double ha = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * alpha)), "ha", 1283, 60883, 60913);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1288, 61060, 61066)) {
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1288, 61043, 61046)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1288, 61060, 61066);
                        CallChecker.isCalled(glag, ArrayRealVector.class, 1288, 61043, 61046).setEntry(i, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1288, 61060, 61066).getEntry(knew, i));
                    }
                }
            }
            for (int k = 0; k < npt; k++) {
                double tmp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "tmp", 1291, 61150, 61167);
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1293, 61234, 61252)) {
                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1293, 61271, 61293)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1293, 61234, 61252);
                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1293, 61271, 61293);
                            tmp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1293, 61234, 61252).getEntry(k, j)) * (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1293, 61271, 61293).getEntry(j));
                            CallChecker.varAssign(tmp, "tmp", 1293, 61227, 61306);
                        }
                    }
                }
                if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1295, 61341, 61344)) {
                    tmp *= CallChecker.isCalled(hcol, ArrayRealVector.class, 1295, 61341, 61344).getEntry(k);
                    CallChecker.varAssign(tmp, "tmp", 1295, 61334, 61357);
                }
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1297, 61434, 61437)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1297, 61459, 61477)) {
                            if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1297, 61417, 61420)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1297, 61459, 61477);
                                CallChecker.isCalled(glag, ArrayRealVector.class, 1297, 61417, 61420).setEntry(i, ((CallChecker.isCalled(glag, ArrayRealVector.class, 1297, 61434, 61437).getEntry(i)) + (tmp * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1297, 61459, 61477).getEntry(k, i)))));
                            }
                        }
                    }
                }
            }
            double presav = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "presav", 1307, 61930, 61950);
            double step = CallChecker.varInit(((double) (Double.NaN)), "step", 1308, 61960, 61984);
            int ksav = CallChecker.varInit(((int) (0)), "ksav", 1309, 61994, 62006);
            int ibdsav = CallChecker.varInit(((int) (0)), "ibdsav", 1310, 62016, 62030);
            double stpsav = CallChecker.varInit(((double) (0)), "stpsav", 1311, 62040, 62057);
            for (int k = 0; k < npt; k++) {
                if (k == (trustRegionCenterInterpolationPointIndex)) {
                    continue;
                }
                double dderiv = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "dderiv", 1316, 62216, 62236);
                double distsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "distsq", 1317, 62250, 62270);
                for (int i = 0; i < n; i++) {
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1319, 62349, 62367);
                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1319, 62386, 62408);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1319, 62349, 62367).getEntry(k, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1319, 62386, 62408).getEntry(i)))), "tmp", 1319, 62330, 62421);
                    if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1320, 62449, 62452)) {
                        dderiv += (CallChecker.isCalled(glag, ArrayRealVector.class, 1320, 62449, 62452).getEntry(i)) * tmp;
                        CallChecker.varAssign(dderiv, "dderiv", 1320, 62439, 62471);
                    }
                    distsq += tmp * tmp;
                    CallChecker.varAssign(distsq, "distsq", 1321, 62489, 62508);
                }
                double subd = CallChecker.varInit(((double) (adelt / (Math.sqrt(distsq)))), "subd", 1323, 62536, 62575);
                double slbd = CallChecker.varInit(((double) (-subd)), "slbd", 1324, 62589, 62608);
                int ilbd = CallChecker.varInit(((int) (0)), "ilbd", 1325, 62622, 62634);
                int iubd = CallChecker.varInit(((int) (0)), "iubd", 1326, 62648, 62660);
                final double sumin = CallChecker.varInit(((double) (Math.min(BOBYQAOptimizer.ONE, subd))), "sumin", 1327, 62674, 62714);
                for (int i = 0; i < n; i++) {
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1332, 62880, 62898);
                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1332, 62917, 62939);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1332, 62880, 62898).getEntry(k, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1332, 62917, 62939).getEntry(i)))), "tmp", 1332, 62861, 62952);
                    if (tmp > (BOBYQAOptimizer.ZERO)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1334, 63025, 63039)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1334, 63055, 63077)) {
                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1334, 63025, 63039);
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1334, 63055, 63077);
                                if ((slbd * tmp) < ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1334, 63025, 63039).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1334, 63055, 63077).getEntry(i)))) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1335, 63126, 63140)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1335, 63156, 63178)) {
                                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1335, 63126, 63140);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1335, 63156, 63178);
                                            slbd = ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1335, 63126, 63140).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1335, 63156, 63178).getEntry(i))) / tmp;
                                            CallChecker.varAssign(slbd, "slbd", 1335, 63118, 63198);
                                        }
                                    }
                                    ilbd = (-i) - 1;
                                    CallChecker.varAssign(ilbd, "ilbd", 1336, 63224, 63237);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1338, 63298, 63312)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1338, 63328, 63350)) {
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1338, 63298, 63312);
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1338, 63328, 63350);
                                if ((subd * tmp) > ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1338, 63298, 63312).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1338, 63328, 63350).getEntry(i)))) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1341, 63496, 63510)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63526, 63548)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1341, 63496, 63510);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63526, 63548);
                                            subd = Math.max(sumin, (((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1341, 63496, 63510).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1341, 63526, 63548).getEntry(i))) / tmp));
                                            CallChecker.varAssign(subd, "subd", 1340, 63432, 63569);
                                        }
                                    }
                                    iubd = i + 1;
                                    CallChecker.varAssign(iubd, "iubd", 1342, 63595, 63607);
                                }
                            }
                        }
                    }else
                        if (tmp < (BOBYQAOptimizer.ZERO)) {
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1345, 63709, 63723)) {
                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1345, 63739, 63761)) {
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1345, 63709, 63723);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1345, 63739, 63761);
                                    if ((slbd * tmp) > ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1345, 63709, 63723).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1345, 63739, 63761).getEntry(i)))) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1346, 63810, 63824)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1346, 63840, 63862)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1346, 63810, 63824);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1346, 63840, 63862);
                                                slbd = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1346, 63810, 63824).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1346, 63840, 63862).getEntry(i))) / tmp;
                                                CallChecker.varAssign(slbd, "slbd", 1346, 63802, 63882);
                                            }
                                        }
                                        ilbd = i + 1;
                                        CallChecker.varAssign(ilbd, "ilbd", 1347, 63908, 63920);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1349, 63981, 63995)) {
                                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1349, 64011, 64033)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1349, 63981, 63995);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1349, 64011, 64033);
                                    if ((subd * tmp) < ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1349, 63981, 63995).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1349, 64011, 64033).getEntry(i)))) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1352, 64179, 64193)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1352, 64209, 64231)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1352, 64179, 64193);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1352, 64209, 64231);
                                                subd = Math.max(sumin, (((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1352, 64179, 64193).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1352, 64209, 64231).getEntry(i))) / tmp));
                                                CallChecker.varAssign(subd, "subd", 1351, 64115, 64252);
                                            }
                                        }
                                        iubd = (-i) - 1;
                                        CallChecker.varAssign(iubd, "iubd", 1353, 64278, 64291);
                                    }
                                }
                            }
                        }
                    
                }
                step = slbd;
                CallChecker.varAssign(step, "step", 1361, 64527, 64538);
                int isbd = CallChecker.varInit(((int) (ilbd)), "isbd", 1362, 64552, 64567);
                double vlag = CallChecker.varInit(((double) (Double.NaN)), "vlag", 1363, 64581, 64605);
                if (k == knew) {
                    final double diff = CallChecker.varInit(((double) (dderiv - (BOBYQAOptimizer.ONE))), "diff", 1365, 64652, 64684);
                    vlag = slbd * (dderiv - (slbd * diff));
                    CallChecker.varAssign(vlag, "vlag", 1366, 64702, 64738);
                    final double d1 = CallChecker.varInit(((double) (subd * (dderiv - (subd * diff)))), "d1", 1367, 64756, 64803);
                    if ((Math.abs(d1)) > (Math.abs(vlag))) {
                        step = subd;
                        CallChecker.varAssign(step, "step", 1369, 64878, 64889);
                        vlag = d1;
                        CallChecker.varAssign(vlag, "vlag", 1370, 64911, 64920);
                        isbd = iubd;
                        CallChecker.varAssign(isbd, "isbd", 1371, 64942, 64953);
                    }
                    final double d2 = CallChecker.varInit(((double) ((BOBYQAOptimizer.HALF) * dderiv)), "d2", 1373, 64989, 65020);
                    final double d3 = CallChecker.varInit(((double) (d2 - (diff * slbd))), "d3", 1374, 65038, 65072);
                    final double d4 = CallChecker.varInit(((double) (d2 - (diff * subd))), "d4", 1375, 65090, 65124);
                    if ((d3 * d4) < (BOBYQAOptimizer.ZERO)) {
                        final double d5 = CallChecker.varInit(((double) ((d2 * d2) / diff)), "d5", 1377, 65184, 65216);
                        if ((Math.abs(d5)) > (Math.abs(vlag))) {
                            step = d2 / diff;
                            CallChecker.varAssign(step, "step", 1379, 65299, 65315);
                            vlag = d5;
                            CallChecker.varAssign(vlag, "vlag", 1380, 65341, 65350);
                            isbd = 0;
                            CallChecker.varAssign(isbd, "isbd", 1381, 65376, 65384);
                        }
                    }
                }else {
                    vlag = slbd * ((BOBYQAOptimizer.ONE) - slbd);
                    CallChecker.varAssign(vlag, "vlag", 1388, 65553, 65579);
                    final double tmp = CallChecker.varInit(((double) (subd * ((BOBYQAOptimizer.ONE) - subd))), "tmp", 1389, 65597, 65635);
                    if ((Math.abs(tmp)) > (Math.abs(vlag))) {
                        step = subd;
                        CallChecker.varAssign(step, "step", 1391, 65711, 65722);
                        vlag = tmp;
                        CallChecker.varAssign(vlag, "vlag", 1392, 65744, 65754);
                        isbd = iubd;
                        CallChecker.varAssign(isbd, "isbd", 1393, 65776, 65787);
                    }
                    if ((subd > (BOBYQAOptimizer.HALF)) && ((Math.abs(vlag)) < (BOBYQAOptimizer.ONE_OVER_FOUR))) {
                        step = BOBYQAOptimizer.HALF;
                        CallChecker.varAssign(step, "step", 1396, 65896, 65907);
                        vlag = BOBYQAOptimizer.ONE_OVER_FOUR;
                        CallChecker.varAssign(vlag, "vlag", 1397, 65929, 65949);
                        isbd = 0;
                        CallChecker.varAssign(isbd, "isbd", 1398, 65971, 65979);
                    }
                    vlag *= dderiv;
                    CallChecker.varAssign(vlag, "vlag", 1400, 66015, 66029);
                }
                final double tmp = CallChecker.varInit(((double) ((step * ((BOBYQAOptimizer.ONE) - step)) * distsq)), "tmp", 1405, 66058, 66187);
                final double predsq = CallChecker.varInit(((double) ((vlag * vlag) * ((vlag * vlag) + ((ha * tmp) * tmp)))), "predsq", 1406, 66201, 66267);
                if (predsq > presav) {
                    presav = predsq;
                    CallChecker.varAssign(presav, "presav", 1408, 66320, 66335);
                    ksav = k;
                    CallChecker.varAssign(ksav, "ksav", 1409, 66353, 66361);
                    stpsav = step;
                    CallChecker.varAssign(stpsav, "stpsav", 1410, 66379, 66392);
                    ibdsav = isbd;
                    CallChecker.varAssign(ibdsav, "ibdsav", 1411, 66410, 66423);
                }
            }
            for (int i = 0; i < n; i++) {
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1418, 66601, 66623);
                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1418, 66649, 66667);
                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1418, 66689, 66711);
                final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1418, 66601, 66623).getEntry(i)) + (stpsav * ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1418, 66649, 66667).getEntry(ksav, i)) - (CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1418, 66689, 66711).getEntry(i)))))), "tmp", 1418, 66582, 66725);
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1419, 66769, 66783)) {
                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1420, 66845, 66859)) {
                        if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1419, 66739, 66746)) {
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1419, 66769, 66783);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1420, 66845, 66859);
                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1419, 66739, 66746);
                            CallChecker.isCalled(newPoint, ArrayRealVector.class, 1419, 66739, 66746).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1419, 66769, 66783).getEntry(i), Math.min(CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1420, 66845, 66859).getEntry(i), tmp)));
                        }
                    }
                }
            }
            if (ibdsav < 0) {
                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1423, 66961, 66975)) {
                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1423, 66930, 66937)) {
                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1423, 66961, 66975);
                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1423, 66930, 66937);
                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 1423, 66930, 66937).setEntry(((-ibdsav) - 1), CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1423, 66961, 66975).getEntry(((-ibdsav) - 1)));
                    }
                }
            }
            if (ibdsav > 0) {
                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1426, 67079, 67093)) {
                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 1426, 67049, 67056)) {
                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1426, 67079, 67093);
                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 1426, 67049, 67056);
                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 1426, 67049, 67056).setEntry((ibdsav - 1), CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1426, 67079, 67093).getEntry((ibdsav - 1)));
                    }
                }
            }
            final double bigstp = CallChecker.varInit(((double) (adelt + adelt)), "bigstp", 1433, 67137, 67405);
            int iflag = CallChecker.varInit(((int) (0)), "iflag", 1434, 67415, 67428);
            double cauchy = CallChecker.varInit(((double) (Double.NaN)), "cauchy", 1435, 67438, 67464);
            double csave = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "csave", 1436, 67474, 67493);
            while (true) {
                double wfixsq = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "wfixsq", 1438, 67530, 67550);
                double ggfree = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ggfree", 1439, 67564, 67584);
                for (int i = 0; i < n; i++) {
                    final double glagValue = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1441, 67669, 67672).getEntry(i))), "glagValue", 1441, 67644, 67685);
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1442, 67703, 67707)) {
                        CallChecker.isCalled(work1, ArrayRealVector.class, 1442, 67703, 67707).setEntry(i, BOBYQAOptimizer.ZERO);
                    }
                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1443, 67757, 67779)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1443, 67795, 67809)) {
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1444, 67874, 67896)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1444, 67912, 67926)) {
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1443, 67757, 67779);
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1443, 67795, 67809);
                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1444, 67874, 67896);
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1444, 67912, 67926);
                                    if (((Math.min(((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1443, 67757, 67779).getEntry(i)) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1443, 67795, 67809).getEntry(i))), glagValue)) > (BOBYQAOptimizer.ZERO)) || ((Math.max(((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1444, 67874, 67896).getEntry(i)) - (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1444, 67912, 67926).getEntry(i))), glagValue)) < (BOBYQAOptimizer.ZERO))) {
                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1445, 67982, 67986)) {
                                            CallChecker.isCalled(work1, ArrayRealVector.class, 1445, 67982, 67986).setEntry(i, bigstp);
                                        }
                                        ggfree += glagValue * glagValue;
                                        CallChecker.varAssign(ggfree, "ggfree", 1447, 68072, 68103);
                                    }
                                }
                            }
                        }
                    }
                }
                if (ggfree == (BOBYQAOptimizer.ZERO)) {
                    return new double[]{ alpha , BOBYQAOptimizer.ZERO };
                }
                final double tmp1 = CallChecker.varInit(((double) ((adelt * adelt) - wfixsq)), "tmp1", 1455, 68251, 68363);
                if (tmp1 > (BOBYQAOptimizer.ZERO)) {
                    step = Math.sqrt((tmp1 / ggfree));
                    CallChecker.varAssign(step, "step", 1457, 68412, 68443);
                    ggfree = BOBYQAOptimizer.ZERO;
                    CallChecker.varAssign(ggfree, "ggfree", 1458, 68461, 68474);
                    for (int i = 0; i < n; i++) {
                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1460, 68546, 68550)) {
                            if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1460, 68546, 68550).getEntry(i)) == bigstp) {
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1461, 68621, 68643);
                                final double tmp2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1461, 68621, 68643).getEntry(i)) - (step * (CallChecker.isCalled(glag, ArrayRealVector.class, 1461, 68666, 68669).getEntry(i))))), "tmp2", 1461, 68601, 68682);
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1462, 68720, 68734)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1462, 68720, 68734);
                                    if (tmp2 <= (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1462, 68720, 68734).getEntry(i))) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1463, 68797, 68811)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68827, 68849)) {
                                                if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1463, 68779, 68783)) {
                                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1463, 68797, 68811);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68827, 68849);
                                                    CallChecker.isCalled(work1, ArrayRealVector.class, 1463, 68779, 68783).setEntry(i, ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1463, 68797, 68811).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1463, 68827, 68849).getEntry(i))));
                                                }
                                            }
                                        }
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 1465, 68962, 68966).getEntry(i))), "d1", 1465, 68893, 68979);
                                        wfixsq += d1 * d1;
                                        CallChecker.varAssign(wfixsq, "wfixsq", 1466, 69009, 69026);
                                    }else
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1467, 69071, 69085)) {
                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1467, 69071, 69085);
                                            if (tmp2 >= (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1467, 69071, 69085).getEntry(i))) {
                                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1468, 69148, 69162)) {
                                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1468, 69178, 69200)) {
                                                        if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1468, 69130, 69134)) {
                                                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1468, 69148, 69162);
                                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1468, 69178, 69200);
                                                            CallChecker.isCalled(work1, ArrayRealVector.class, 1468, 69130, 69134).setEntry(i, ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1468, 69148, 69162).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1468, 69178, 69200).getEntry(i))));
                                                        }
                                                    }
                                                }
                                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(work1, ArrayRealVector.class, 1470, 69313, 69317).getEntry(i))), "d1", 1470, 69244, 69330);
                                                wfixsq += d1 * d1;
                                                CallChecker.varAssign(wfixsq, "wfixsq", 1471, 69360, 69377);
                                            }else {
                                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1474, 69509, 69512).getEntry(i))), "d1", 1474, 69440, 69525);
                                                ggfree += d1 * d1;
                                                CallChecker.varAssign(ggfree, "ggfree", 1475, 69555, 69572);
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
                double gw = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "gw", 1484, 69800, 69816);
                for (int i = 0; i < n; i++) {
                    final double glagValue = CallChecker.varInit(((double) (CallChecker.isCalled(glag, ArrayRealVector.class, 1486, 69901, 69904).getEntry(i))), "glagValue", 1486, 69876, 69917);
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1487, 69939, 69943)) {
                        if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1487, 69939, 69943).getEntry(i)) == bigstp) {
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1488, 69990, 69994)) {
                                CallChecker.isCalled(work1, ArrayRealVector.class, 1488, 69990, 69994).setEntry(i, ((-step) * glagValue));
                            }
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1489, 70076, 70090);
                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1490, 70153, 70175);
                            final double min = CallChecker.varInit(((double) (Math.min(CallChecker.isCalled(this.upperDifference, ArrayRealVector.class, 1489, 70076, 70090).getEntry(i), ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1490, 70153, 70175).getEntry(i)) + (CallChecker.isCalled(work1, ArrayRealVector.class, 1490, 70191, 70195).getEntry(i)))))), "min", 1489, 70048, 70209);
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1491, 70272, 70286)) {
                                if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1491, 70231, 70249)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1491, 70272, 70286);
                                    alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1491, 70231, 70249);
                                    CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1491, 70231, 70249).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1491, 70272, 70286).getEntry(i), min));
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1492, 70335, 70339)) {
                                if ((CallChecker.isCalled(work1, ArrayRealVector.class, 1492, 70335, 70339).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1493, 70416, 70438)) {
                                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1493, 70384, 70402)) {
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1493, 70416, 70438);
                                            alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1493, 70384, 70402);
                                            CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1493, 70384, 70402).setEntry(i, CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1493, 70416, 70438).getEntry(i));
                                        }
                                    }
                                }else
                                    if (glagValue > (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1495, 70553, 70567)) {
                                            if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1495, 70521, 70539)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1495, 70553, 70567);
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1495, 70521, 70539);
                                                CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1495, 70521, 70539).setEntry(i, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1495, 70553, 70567).getEntry(i));
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1497, 70660, 70674)) {
                                            if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1497, 70628, 70646)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1497, 70660, 70674);
                                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1497, 70628, 70646);
                                                CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1497, 70628, 70646).setEntry(i, CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1497, 70660, 70674).getEntry(i));
                                            }
                                        }
                                    }
                                
                            }
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1499, 70742, 70746)) {
                        gw += glagValue * (CallChecker.isCalled(work1, ArrayRealVector.class, 1499, 70742, 70746).getEntry(i));
                        CallChecker.varAssign(gw, "gw", 1499, 70724, 70759);
                    }
                }
                double curv = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "curv", 1507, 71080, 71098);
                for (int k = 0; k < npt; k++) {
                    double tmp = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "tmp", 1509, 71160, 71177);
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1511, 71252, 71270)) {
                            if (CallChecker.beforeDeref(work1, ArrayRealVector.class, 1511, 71289, 71293)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1511, 71252, 71270);
                                tmp += (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1511, 71252, 71270).getEntry(k, j)) * (CallChecker.isCalled(work1, ArrayRealVector.class, 1511, 71289, 71293).getEntry(j));
                                CallChecker.varAssign(tmp, "tmp", 1511, 71245, 71306);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(hcol, ArrayRealVector.class, 1513, 71350, 71353)) {
                        curv += ((CallChecker.isCalled(hcol, ArrayRealVector.class, 1513, 71350, 71353).getEntry(k)) * tmp) * tmp;
                        CallChecker.varAssign(curv, "curv", 1513, 71342, 71378);
                    }
                }
                if (iflag == 1) {
                    curv = -curv;
                    CallChecker.varAssign(curv, "curv", 1516, 71440, 71452);
                }
                if ((curv > (-gw)) && (curv < ((-gw) * ((BOBYQAOptimizer.ONE) + (Math.sqrt(BOBYQAOptimizer.TWO)))))) {
                    final double scale = CallChecker.varInit(((double) ((-gw) / curv)), "scale", 1520, 71569, 71600);
                    for (int i = 0; i < n; i++) {
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1522, 71687, 71709);
                        final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 1522, 71687, 71709).getEntry(i)) + (scale * (CallChecker.isCalled(work1, ArrayRealVector.class, 1522, 71733, 71737).getEntry(i))))), "tmp", 1522, 71668, 71750);
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1523, 71813, 71827)) {
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1524, 71897, 71911)) {
                                if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1523, 71772, 71790)) {
                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1523, 71813, 71827);
                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1524, 71897, 71911);
                                    alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1523, 71772, 71790);
                                    CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1523, 71772, 71790).setEntry(i, Math.max(CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1523, 71813, 71827).getEntry(i), Math.min(CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1524, 71897, 71911).getEntry(i), tmp)));
                                }
                            }
                        }
                    }
                    final double d1 = CallChecker.varInit(((double) (((BOBYQAOptimizer.HALF) * gw) * scale)), "d1", 1527, 71968, 72042);
                    cauchy = d1 * d1;
                    CallChecker.varAssign(cauchy, "cauchy", 1528, 72060, 72076);
                }else {
                    final double d1 = CallChecker.varInit(((double) (gw + ((BOBYQAOptimizer.HALF) * curv))), "d1", 1531, 72115, 72188);
                    cauchy = d1 * d1;
                    CallChecker.varAssign(cauchy, "cauchy", 1532, 72206, 72222);
                }
                if (iflag == 0) {
                    for (int i = 0; i < n; i++) {
                        if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1541, 72598, 72601)) {
                            if (CallChecker.beforeDeref(glag, ArrayRealVector.class, 1541, 72580, 72583)) {
                                CallChecker.isCalled(glag, ArrayRealVector.class, 1541, 72580, 72583).setEntry(i, (-(CallChecker.isCalled(glag, ArrayRealVector.class, 1541, 72598, 72601).getEntry(i))));
                            }
                        }
                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1542, 72655, 72673)) {
                            if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1542, 72637, 72641)) {
                                alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1542, 72655, 72673);
                                CallChecker.isCalled(work2, ArrayRealVector.class, 1542, 72637, 72641).setEntry(i, CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1542, 72655, 72673).getEntry(i));
                            }
                        }
                    }
                    csave = cauchy;
                    CallChecker.varAssign(csave, "csave", 1544, 72723, 72737);
                    iflag = 1;
                    CallChecker.varAssign(iflag, "iflag", 1545, 72755, 72764);
                }else {
                    break;
                }
            } 
            if (csave > cauchy) {
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(work2, ArrayRealVector.class, 1552, 72954, 72958)) {
                        if (CallChecker.beforeDeref(alternativeNewPoint, ArrayRealVector.class, 1552, 72922, 72940)) {
                            alternativeNewPoint = CallChecker.beforeCalled(alternativeNewPoint, ArrayRealVector.class, 1552, 72922, 72940);
                            CallChecker.isCalled(alternativeNewPoint, ArrayRealVector.class, 1552, 72922, 72940).setEntry(i, CallChecker.isCalled(work2, ArrayRealVector.class, 1552, 72954, 72958).getEntry(i));
                        }
                    }
                }
                cauchy = csave;
                CallChecker.varAssign(cauchy, "cauchy", 1554, 73000, 73014);
            }
            return new double[]{ alpha , cauchy };
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4535.methodEnd();
        }
    }

    private void prelim(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4536 = new MethodContext(void.class, 1582, 73095, 83172);
        try {
            CallChecker.varInit(this, "this", 1582, 73095, 83172);
            CallChecker.varInit(upperBound, "upperBound", 1582, 73095, 83172);
            CallChecker.varInit(lowerBound, "lowerBound", 1582, 73095, 83172);
            CallChecker.varInit(this.evaluations, "evaluations", 1582, 73095, 83172);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1582, 73095, 83172);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1582, 73095, 83172);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1582, 73095, 83172);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1582, 73095, 83172);
            CallChecker.varInit(this.newPoint, "newPoint", 1582, 73095, 83172);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1582, 73095, 83172);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1582, 73095, 83172);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1582, 73095, 83172);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1582, 73095, 83172);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1582, 73095, 83172);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1582, 73095, 83172);
            CallChecker.varInit(this.originShift, "originShift", 1582, 73095, 83172);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1582, 73095, 83172);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1582, 73095, 83172);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1582, 73095, 83172);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1582, 73095, 83172);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1582, 73095, 83172);
            CallChecker.varInit(this.currentBest, "currentBest", 1582, 73095, 83172);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1582, 73095, 83172);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1582, 73095, 83172);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1582, 73095, 83172);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1582, 73095, 83172);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1582, 73095, 83172);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 1582, 73095, 83172);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 1582, 73095, 83172);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 1582, 73095, 83172);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 1582, 73095, 83172);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 1582, 73095, 83172);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1582, 73095, 83172);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 1582, 73095, 83172);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 1582, 73095, 83172);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 1582, 73095, 83172);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 1582, 73095, 83172);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 1582, 73095, 83172);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1582, 73095, 83172);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1582, 73095, 83172);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1582, 73095, 83172);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1586, 74488, 74498);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1586, 74488, 74498).getDimension())), "n", 1586, 74474, 74514);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1587, 74524, 74567);
            bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1588, 74594, 74600);
            final int ndim = CallChecker.varInit(((int) (CallChecker.isCalled(this.bMatrix, Array2DRowRealMatrix.class, 1588, 74594, 74600).getRowDimension())), "ndim", 1588, 74577, 74619);
            final double rhosq = CallChecker.varInit(((double) ((this.initialTrustRegionRadius) * (this.initialTrustRegionRadius))), "rhosq", 1590, 74630, 74702);
            final double recip = CallChecker.varInit(((double) (1.0 / rhosq)), "recip", 1591, 74712, 74743);
            final int np = CallChecker.varInit(((int) (n + 1)), "np", 1592, 74753, 74773);
            for (int j = 0; j < n; j++) {
                if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1598, 74987, 74997)) {
                    if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 1598, 74963, 74973)) {
                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1598, 74987, 74997);
                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1598, 74963, 74973);
                        CallChecker.isCalled(originShift, ArrayRealVector.class, 1598, 74963, 74973).setEntry(j, CallChecker.isCalled(currentBest, ArrayRealVector.class, 1598, 74987, 74997).getEntry(j));
                    }
                }
                for (int k = 0; k < npt; k++) {
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1600, 75073, 75091)) {
                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1600, 75073, 75091);
                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1600, 75073, 75091).setEntry(k, j, BOBYQAOptimizer.ZERO);
                    }
                }
                for (int i = 0; i < ndim; i++) {
                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1603, 75190, 75196)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1603, 75190, 75196);
                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1603, 75190, 75196).setEntry(i, j, BOBYQAOptimizer.ZERO);
                    }
                }
            }
            for (int i = 0, max = (n * np) / 2; i < max; i++) {
                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1607, 75314, 75341)) {
                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1607, 75314, 75341);
                    CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1607, 75314, 75341).setEntry(i, BOBYQAOptimizer.ZERO);
                }
            }
            for (int k = 0; k < npt; k++) {
                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 1610, 75424, 75455)) {
                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1610, 75424, 75455);
                    CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 1610, 75424, 75455).setEntry(k, BOBYQAOptimizer.ZERO);
                }
                for (int j = 0, max = npt - np; j < max; j++) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1612, 75552, 75558)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1612, 75552, 75558);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1612, 75552, 75558).setEntry(k, j, BOBYQAOptimizer.ZERO);
                    }
                }
            }
            int ipt = CallChecker.varInit(((int) (0)), "ipt", 1620, 75859, 75870);
            int jpt = CallChecker.varInit(((int) (0)), "jpt", 1621, 75880, 75891);
            double fbeg = CallChecker.varInit(((double) (Double.NaN)), "fbeg", 1622, 75901, 75925);
            do {
                final int nfm = CallChecker.varInit(((int) (getEvaluations())), "nfm", 1624, 75952, 75984);
                final int nfx = CallChecker.varInit(((int) (nfm - n)), "nfx", 1625, 75998, 76021);
                final int nfmm = CallChecker.varInit(((int) (nfm - 1)), "nfmm", 1626, 76035, 76059);
                final int nfxm = CallChecker.varInit(((int) (nfx - 1)), "nfxm", 1627, 76073, 76097);
                double stepa = CallChecker.varInit(((double) (0)), "stepa", 1628, 76111, 76127);
                double stepb = CallChecker.varInit(((double) (0)), "stepb", 1629, 76141, 76157);
                if (nfm <= (2 * n)) {
                    if ((nfm >= 1) && (nfm <= n)) {
                        stepa = initialTrustRegionRadius;
                        CallChecker.varAssign(stepa, "stepa", 1633, 76275, 76307);
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1634, 76333, 76347)) {
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1634, 76333, 76347);
                            if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1634, 76333, 76347).getEntry(nfmm)) == (BOBYQAOptimizer.ZERO)) {
                                stepa = -stepa;
                                CallChecker.varAssign(stepa, "stepa", 1635, 76399, 76413);
                            }
                        }
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1638, 76528, 76546)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1638, 76528, 76546);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1638, 76528, 76546).setEntry(nfm, nfmm, stepa);
                        }
                    }else
                        if (nfm > n) {
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1640, 76642, 76660)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1640, 76642, 76660);
                                stepa = CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1640, 76642, 76660).getEntry(nfx, nfxm);
                                CallChecker.varAssign(stepa, "stepa", 1640, 76634, 76681);
                            }
                            stepb = -(initialTrustRegionRadius);
                            CallChecker.varAssign(stepb, "stepb", 1641, 76703, 76736);
                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1642, 76762, 76776)) {
                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1642, 76762, 76776);
                                if ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1642, 76762, 76776).getEntry(nfxm)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1643, 76877, 76891)) {
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1643, 76877, 76891);
                                        stepb = Math.min(((BOBYQAOptimizer.TWO) * (initialTrustRegionRadius)), CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1643, 76877, 76891).getEntry(nfxm));
                                        CallChecker.varAssign(stepb, "stepb", 1643, 76828, 76908);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1646, 77027, 77041)) {
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1646, 77027, 77041);
                                if ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1646, 77027, 77041).getEntry(nfxm)) == (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1647, 77143, 77157)) {
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1647, 77143, 77157);
                                        stepb = Math.max(((-(BOBYQAOptimizer.TWO)) * (initialTrustRegionRadius)), CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1647, 77143, 77157).getEntry(nfxm));
                                        CallChecker.varAssign(stepb, "stepb", 1647, 77093, 77174);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1650, 77289, 77307)) {
                                interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1650, 77289, 77307);
                                CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1650, 77289, 77307).setEntry(nfm, nfxm, stepb);
                            }
                        }
                    
                }else {
                    final int tmp1 = CallChecker.varInit(((int) ((nfm - np) / n)), "tmp1", 1653, 77392, 77423);
                    jpt = (nfm - (tmp1 * n)) - n;
                    CallChecker.varAssign(jpt, "jpt", 1654, 77441, 77465);
                    ipt = jpt + tmp1;
                    CallChecker.varAssign(ipt, "ipt", 1655, 77483, 77499);
                    if (ipt > n) {
                        final int tmp2 = CallChecker.varInit(((int) (jpt)), "tmp2", 1657, 77552, 77572);
                        jpt = ipt - n;
                        CallChecker.varAssign(jpt, "jpt", 1658, 77594, 77607);
                        ipt = tmp2;
                        CallChecker.varAssign(ipt, "ipt", 1659, 77629, 77639);
                    }
                    final int iptMinus1 = CallChecker.varInit(((int) (ipt - 1)), "iptMinus1", 1662, 77742, 77771);
                    final int jptMinus1 = CallChecker.varInit(((int) (jpt - 1)), "jptMinus1", 1663, 77789, 77818);
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77881, 77899)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77836, 77854)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77881, 77899);
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77836, 77854);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77836, 77854).setEntry(nfm, iptMinus1, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1664, 77881, 77899).getEntry(ipt, iptMinus1));
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77989, 78007)) {
                        if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77944, 77962)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77989, 78007);
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77944, 77962);
                            CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77944, 77962).setEntry(nfm, jptMinus1, CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1665, 77989, 78007).getEntry(jpt, jptMinus1));
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(lowerBound, double[].class, 1672, 78273, 78282)) {
                        if (CallChecker.beforeDeref(originShift, ArrayRealVector.class, 1673, 78346, 78356)) {
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78372, 78390)) {
                                if (CallChecker.beforeDeref(upperBound, double[].class, 1674, 78460, 78469)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1672, 78231, 78241)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1672, 78273, 78282);
                                        originShift = CallChecker.beforeCalled(originShift, ArrayRealVector.class, 1673, 78346, 78356);
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78372, 78390);
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1674, 78460, 78469);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1672, 78231, 78241);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1672, 78231, 78241).setEntry(j, Math.min(Math.max(CallChecker.isCalled(lowerBound, double[].class, 1672, 78273, 78282)[j], ((CallChecker.isCalled(originShift, ArrayRealVector.class, 1673, 78346, 78356).getEntry(j)) + (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1673, 78372, 78390).getEntry(nfm, j)))), CallChecker.isCalled(upperBound, double[].class, 1674, 78460, 78469)[j]));
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1675, 78497, 78515)) {
                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1675, 78537, 78551)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1675, 78497, 78515);
                            lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1675, 78537, 78551);
                            if ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1675, 78497, 78515).getEntry(nfm, j)) == (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1675, 78537, 78551).getEntry(j))) {
                                if (CallChecker.beforeDeref(lowerBound, double[].class, 1676, 78612, 78621)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1676, 78588, 78598)) {
                                        lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 1676, 78612, 78621);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1676, 78588, 78598);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1676, 78588, 78598).setEntry(j, CallChecker.isCalled(lowerBound, double[].class, 1676, 78612, 78621)[j]);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1678, 78666, 78684)) {
                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1678, 78706, 78720)) {
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1678, 78666, 78684);
                            upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1678, 78706, 78720);
                            if ((CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1678, 78666, 78684).getEntry(nfm, j)) == (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1678, 78706, 78720).getEntry(j))) {
                                if (CallChecker.beforeDeref(upperBound, double[].class, 1679, 78781, 78790)) {
                                    if (CallChecker.beforeDeref(currentBest, ArrayRealVector.class, 1679, 78757, 78767)) {
                                        upperBound = CallChecker.beforeCalled(upperBound, double[].class, 1679, 78781, 78790);
                                        currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1679, 78757, 78767);
                                        CallChecker.isCalled(currentBest, ArrayRealVector.class, 1679, 78757, 78767).setEntry(j, CallChecker.isCalled(upperBound, double[].class, 1679, 78781, 78790)[j]);
                                    }
                                }
                            }
                        }
                    }
                }
                currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1683, 78894, 78904);
                final double objectiveValue = CallChecker.varInit(((double) (computeObjectiveValue(CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1683, 78894, 78904).toArray()))), "objectiveValue", 1683, 78842, 78916);
                double f = CallChecker.init(double.class);
                if (isMinimize) {
                    f = objectiveValue;
                    CallChecker.varAssign(f, "f", 1684, 78947, 78991);
                }else {
                    f = -objectiveValue;
                    CallChecker.varAssign(f, "f", 1684, 78947, 78991);
                }
                final int numEval = CallChecker.varInit(((int) (getEvaluations())), "numEval", 1685, 79006, 79042);
                if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79067, 79088)) {
                    fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79067, 79088);
                    CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1686, 79067, 79088).setEntry(nfm, f);
                }
                if (numEval == 1) {
                    fbeg = f;
                    CallChecker.varAssign(fbeg, "fbeg", 1689, 79157, 79165);
                    trustRegionCenterInterpolationPointIndex = 0;
                    CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1690, 79183, 79227);
                }else
                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1691, 79256, 79277)) {
                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1691, 79256, 79277);
                        if (f < (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1691, 79256, 79277).getEntry(trustRegionCenterInterpolationPointIndex))) {
                            trustRegionCenterInterpolationPointIndex = nfm;
                            CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1692, 79349, 79395);
                        }
                    }
                
                if (numEval <= ((2 * n) + 1)) {
                    if ((numEval >= 2) && (numEval <= (n + 1))) {
                        if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1704, 79973, 79999)) {
                            gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1704, 79973, 79999);
                            CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1704, 79973, 79999).setEntry(nfmm, ((f - fbeg) / stepa));
                        }
                        if (npt < (numEval + n)) {
                            final double oneOverStepA = CallChecker.varInit(((double) ((BOBYQAOptimizer.ONE) / stepa)), "oneOverStepA", 1706, 80106, 80145);
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1707, 80171, 80177)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1707, 80171, 80177);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1707, 80171, 80177).setEntry(0, nfmm, (-oneOverStepA));
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1708, 80237, 80243)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1708, 80237, 80243);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1708, 80237, 80243).setEntry(nfm, nfmm, oneOverStepA);
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1709, 80304, 80310)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1709, 80304, 80310);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1709, 80304, 80310).setEntry((npt + nfmm), nfmm, ((-(BOBYQAOptimizer.HALF)) * rhosq));
                            }
                        }
                    }else
                        if (numEval >= (n + 2)) {
                            final int ih = CallChecker.varInit(((int) (((nfx * (nfx + 1)) / 2) - 1)), "ih", 1713, 80515, 80553);
                            final double tmp = CallChecker.varInit(((double) ((f - fbeg) / stepb)), "tmp", 1714, 80575, 80612);
                            final double diff = CallChecker.varInit(((double) (stepb - stepa)), "diff", 1715, 80634, 80667);
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1716, 80744, 80770)) {
                                if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1716, 80689, 80716)) {
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1716, 80744, 80770);
                                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1716, 80689, 80716);
                                    CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1716, 80689, 80716).setEntry(ih, (((BOBYQAOptimizer.TWO) * (tmp - (CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1716, 80744, 80770).getEntry(nfxm)))) / diff));
                                }
                            }
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80861, 80887)) {
                                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80817, 80843)) {
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80861, 80887);
                                    gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80817, 80843);
                                    CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80817, 80843).setEntry(nfxm, ((((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1717, 80861, 80887).getEntry(nfxm)) * stepb) - (tmp * stepa)) / diff));
                                }
                            }
                            if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1718, 80988, 81009)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1718, 80988, 81009);
                                if (((stepa * stepb) < (BOBYQAOptimizer.ZERO)) && (f < (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1718, 80988, 81009).getEntry((nfm - n))))) {
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81093, 81114)) {
                                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81056, 81077)) {
                                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81093, 81114);
                                            fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81056, 81077);
                                            CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81056, 81077).setEntry(nfm, CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1719, 81093, 81114).getEntry((nfm - n)));
                                        }
                                    }
                                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1720, 81160, 81181)) {
                                        fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1720, 81160, 81181);
                                        CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1720, 81160, 81181).setEntry((nfm - n), f);
                                    }
                                    if ((trustRegionCenterInterpolationPointIndex) == nfm) {
                                        trustRegionCenterInterpolationPointIndex = nfm - n;
                                        CallChecker.varAssign(this.trustRegionCenterInterpolationPointIndex, "this.trustRegionCenterInterpolationPointIndex", 1722, 81312, 81362);
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1724, 81414, 81432)) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1724, 81414, 81432);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1724, 81414, 81432).setEntry((nfm - n), nfxm, stepb);
                                    }
                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1725, 81490, 81508)) {
                                        interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1725, 81490, 81508);
                                        CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1725, 81490, 81508).setEntry(nfm, nfxm, stepa);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1727, 81580, 81586)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1727, 81580, 81586);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1727, 81580, 81586).setEntry(0, nfxm, ((-(stepa + stepb)) / (stepa * stepb)));
                            }
                            if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 1728, 81699, 81717)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1728, 81663, 81669)) {
                                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1728, 81699, 81717);
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1728, 81663, 81669);
                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1728, 81663, 81669).setEntry(nfm, nfxm, ((-(BOBYQAOptimizer.HALF)) / (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 1728, 81699, 81717).getEntry((nfm - n), nfxm))));
                                }
                            }
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1730, 81832, 81838)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1730, 81860, 81866)) {
                                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 1729, 81765, 81771)) {
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1730, 81832, 81838);
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1730, 81860, 81866);
                                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 1729, 81765, 81771);
                                        CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1729, 81765, 81771).setEntry((nfm - n), nfxm, ((-(CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1730, 81832, 81838).getEntry(0, nfxm))) - (CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 1730, 81860, 81866).getEntry(nfm, nfxm))));
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1731, 81910, 81916)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1731, 81910, 81916);
                                CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1731, 81910, 81916).setEntry(0, nfxm, ((Math.sqrt(BOBYQAOptimizer.TWO)) / (stepa * stepb)));
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1732, 81991, 81997)) {
                                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1732, 81991, 81997);
                                CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1732, 81991, 81997).setEntry(nfm, nfxm, ((Math.sqrt(BOBYQAOptimizer.HALF)) / rhosq));
                            }
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1735, 82253, 82259)) {
                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1735, 82281, 82287)) {
                                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1734, 82186, 82192)) {
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1735, 82253, 82259);
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1735, 82281, 82287);
                                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1734, 82186, 82192);
                                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1734, 82186, 82192).setEntry((nfm - n), nfxm, ((-(CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1735, 82253, 82259).getEntry(0, nfxm))) - (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1735, 82281, 82287).getEntry(nfm, nfxm))));
                                    }
                                }
                            }
                        }
                    
                }else {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1742, 82505, 82511)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1742, 82505, 82511);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1742, 82505, 82511).setEntry(0, nfxm, recip);
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1743, 82555, 82561)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1743, 82555, 82561);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1743, 82555, 82561).setEntry(nfm, nfxm, recip);
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1744, 82607, 82613)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1744, 82607, 82613);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1744, 82607, 82613).setEntry(ipt, nfxm, (-recip));
                    }
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 1745, 82660, 82666)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 1745, 82660, 82666);
                        CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 1745, 82660, 82666).setEntry(jpt, nfxm, (-recip));
                    }
                    final int ih = CallChecker.varInit(((int) ((((ipt * (ipt - 1)) / 2) + jpt) - 1)), "ih", 1747, 82714, 82758);
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1748, 82795, 82813);
                    interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 1748, 82840, 82858);
                    final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1748, 82795, 82813).getEntry(nfm, (ipt - 1))) * (CallChecker.isCalled(this.interpolationPoints, Array2DRowRealMatrix.class, 1748, 82840, 82858).getEntry(nfm, (jpt - 1))))), "tmp", 1748, 82776, 82882);
                    if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82950, 82971)) {
                        if (CallChecker.beforeDeref(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82989, 83010)) {
                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 1749, 82900, 82927)) {
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82950, 82971);
                                fAtInterpolationPoints = CallChecker.beforeCalled(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82989, 83010);
                                modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1749, 82900, 82927);
                                CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 1749, 82900, 82927).setEntry(ih, ((((fbeg - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82950, 82971).getEntry(ipt))) - (CallChecker.isCalled(fAtInterpolationPoints, ArrayRealVector.class, 1749, 82989, 83010).getEntry(jpt))) + f) / tmp));
                            }
                        }
                    }
                }
            } while ((getEvaluations()) < npt );
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4536.methodEnd();
        }
    }

    private double[] trsbox(double delta, ArrayRealVector gnew, ArrayRealVector xbdi, ArrayRealVector s, ArrayRealVector hs, ArrayRealVector hred) {
        MethodContext _bcornu_methode_context4537 = new MethodContext(double[].class, 1802, 83180, 104980);
        try {
            CallChecker.varInit(this, "this", 1802, 83180, 104980);
            CallChecker.varInit(hred, "hred", 1802, 83180, 104980);
            CallChecker.varInit(hs, "hs", 1802, 83180, 104980);
            CallChecker.varInit(s, "s", 1802, 83180, 104980);
            CallChecker.varInit(xbdi, "xbdi", 1802, 83180, 104980);
            CallChecker.varInit(gnew, "gnew", 1802, 83180, 104980);
            CallChecker.varInit(delta, "delta", 1802, 83180, 104980);
            CallChecker.varInit(this.evaluations, "evaluations", 1802, 83180, 104980);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 1802, 83180, 104980);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 1802, 83180, 104980);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 1802, 83180, 104980);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 1802, 83180, 104980);
            CallChecker.varInit(this.newPoint, "newPoint", 1802, 83180, 104980);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 1802, 83180, 104980);
            CallChecker.varInit(this.upperDifference, "upperDifference", 1802, 83180, 104980);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 1802, 83180, 104980);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 1802, 83180, 104980);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 1802, 83180, 104980);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 1802, 83180, 104980);
            CallChecker.varInit(this.originShift, "originShift", 1802, 83180, 104980);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 1802, 83180, 104980);
            CallChecker.varInit(this.zMatrix, "zMatrix", 1802, 83180, 104980);
            CallChecker.varInit(this.bMatrix, "bMatrix", 1802, 83180, 104980);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 1802, 83180, 104980);
            CallChecker.varInit(this.boundDifference, "boundDifference", 1802, 83180, 104980);
            CallChecker.varInit(this.currentBest, "currentBest", 1802, 83180, 104980);
            CallChecker.varInit(this.isMinimize, "isMinimize", 1802, 83180, 104980);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 1802, 83180, 104980);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 1802, 83180, 104980);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 1802, 83180, 104980);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 1802, 83180, 104980);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 1802, 83180, 104980);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 1802, 83180, 104980);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 1802, 83180, 104980);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 1802, 83180, 104980);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 1802, 83180, 104980);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 1802, 83180, 104980);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 1802, 83180, 104980);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 1802, 83180, 104980);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 1802, 83180, 104980);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 1802, 83180, 104980);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 1802, 83180, 104980);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 1802, 83180, 104980);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 1802, 83180, 104980);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 1802, 83180, 104980);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 1812, 86433, 86443);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 1812, 86433, 86443).getDimension())), "n", 1812, 86419, 86459);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 1813, 86469, 86512);
            double dsq = CallChecker.varInit(((double) (Double.NaN)), "dsq", 1815, 86523, 86546);
            double crvmin = CallChecker.varInit(((double) (Double.NaN)), "crvmin", 1816, 86556, 86582);
            double ds = CallChecker.init(double.class);
            int iu = CallChecker.init(int.class);
            double dhd = CallChecker.init(double.class);
            double dhs = CallChecker.init(double.class);
            double cth = CallChecker.init(double.class);
            double shs = CallChecker.init(double.class);
            double sth = CallChecker.init(double.class);
            double ssq = CallChecker.init(double.class);
            double beta = CallChecker.varInit(((double) (0)), "beta", 1821, 86655, 86710);
            double sdec = CallChecker.init(double.class);
            double blen = CallChecker.init(double.class);
            int iact = CallChecker.varInit(((int) (-1)), "iact", 1822, 86720, 86733);
            int nact = CallChecker.varInit(((int) (0)), "nact", 1823, 86743, 86755);
            double angt = CallChecker.varInit(((double) (0)), "angt", 1824, 86765, 86786);
            double qred = CallChecker.init(double.class);
            int isav = CallChecker.init(int.class);
            double temp = CallChecker.varInit(((double) (0)), "temp", 1826, 86814, 86882);
            double xsav = CallChecker.varInit(((double) (0)), "xsav", 1826, 86814, 86882);
            double xsum = CallChecker.varInit(((double) (0)), "xsum", 1826, 86814, 86882);
            double angbd = CallChecker.varInit(((double) (0)), "angbd", 1826, 86814, 86882);
            double dredg = CallChecker.varInit(((double) (0)), "dredg", 1826, 86814, 86882);
            double sredg = CallChecker.varInit(((double) (0)), "sredg", 1826, 86814, 86882);
            int iterc = CallChecker.init(int.class);
            double resid = CallChecker.varInit(((double) (0)), "resid", 1828, 86911, 87039);
            double delsq = CallChecker.varInit(((double) (0)), "delsq", 1828, 86911, 87039);
            double ggsav = CallChecker.varInit(((double) (0)), "ggsav", 1828, 86911, 87039);
            double tempa = CallChecker.varInit(((double) (0)), "tempa", 1828, 86911, 87039);
            double tempb = CallChecker.varInit(((double) (0)), "tempb", 1828, 86911, 87039);
            double redmax = CallChecker.varInit(((double) (0)), "redmax", 1829, 86911, 87039);
            double dredsq = CallChecker.varInit(((double) (0)), "dredsq", 1829, 86911, 87039);
            double redsav = CallChecker.varInit(((double) (0)), "redsav", 1829, 86911, 87039);
            double gredsq = CallChecker.varInit(((double) (0)), "gredsq", 1829, 86911, 87039);
            double rednew = CallChecker.varInit(((double) (0)), "rednew", 1829, 86911, 87039);
            int itcsav = CallChecker.varInit(((int) (0)), "itcsav", 1830, 87049, 87063);
            double rdprev = CallChecker.varInit(((double) (0)), "rdprev", 1831, 87073, 87126);
            double rdnext = CallChecker.varInit(((double) (0)), "rdnext", 1831, 87073, 87126);
            double stplen = CallChecker.varInit(((double) (0)), "stplen", 1831, 87073, 87126);
            double stepsq = CallChecker.varInit(((double) (0)), "stepsq", 1831, 87073, 87126);
            int itermax = CallChecker.varInit(((int) (0)), "itermax", 1832, 87136, 87151);
            iterc = 0;
            CallChecker.varAssign(iterc, "iterc", 1845, 87704, 87713);
            nact = 0;
            CallChecker.varAssign(nact, "nact", 1846, 87723, 87731);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1848, 87783, 87786)) {
                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1848, 87783, 87786);
                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 1848, 87783, 87786).setEntry(i, BOBYQAOptimizer.ZERO);
                }
                if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1849, 87823, 87845)) {
                    if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1849, 87862, 87876)) {
                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1849, 87823, 87845);
                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1849, 87862, 87876);
                        if ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1849, 87823, 87845).getEntry(i)) <= (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1849, 87862, 87876).getEntry(i))) {
                            if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1850, 87913, 87939)) {
                                gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1850, 87913, 87939);
                                if ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1850, 87913, 87939).getEntry(i)) >= (BOBYQAOptimizer.ZERO)) {
                                    if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1851, 87984, 87987)) {
                                        xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1851, 87984, 87987);
                                        CallChecker.isCalled(xbdi, ArrayRealVector.class, 1851, 87984, 87987).setEntry(i, BOBYQAOptimizer.MINUS_ONE);
                                    }
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1853, 88054, 88076)) {
                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1853, 88093, 88107)) {
                                    if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1854, 88147, 88173)) {
                                        trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1853, 88054, 88076);
                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1853, 88093, 88107);
                                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1854, 88147, 88173);
                                        if (((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1853, 88054, 88076).getEntry(i)) >= (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1853, 88093, 88107).getEntry(i))) && ((CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1854, 88147, 88173).getEntry(i)) <= (BOBYQAOptimizer.ZERO))) {
                                            if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1855, 88214, 88217)) {
                                                xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1855, 88214, 88217);
                                                CallChecker.isCalled(xbdi, ArrayRealVector.class, 1855, 88214, 88217).setEntry(i, BOBYQAOptimizer.ONE);
                                            }
                                        }
                                    }
                                }
                            }
                        
                    }
                }
                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1857, 88267, 88270)) {
                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1857, 88267, 88270);
                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1857, 88267, 88270).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                        ++nact;
                    }
                }
                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1860, 88345, 88358)) {
                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1860, 88345, 88358);
                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1860, 88345, 88358).setEntry(i, BOBYQAOptimizer.ZERO);
                }
                if (CallChecker.beforeDeref(gradientAtTrustRegionCenter, ArrayRealVector.class, 1861, 88408, 88434)) {
                    if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1861, 88391, 88394)) {
                        gradientAtTrustRegionCenter = CallChecker.beforeCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1861, 88408, 88434);
                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1861, 88391, 88394);
                        CallChecker.isCalled(gnew, ArrayRealVector.class, 1861, 88391, 88394).setEntry(i, CallChecker.isCalled(gradientAtTrustRegionCenter, ArrayRealVector.class, 1861, 88408, 88434).getEntry(i));
                    }
                }
            }
            delsq = delta * delta;
            CallChecker.varAssign(delsq, "delsq", 1863, 88468, 88489);
            qred = BOBYQAOptimizer.ZERO;
            CallChecker.varAssign(qred, "qred", 1864, 88499, 88510);
            crvmin = BOBYQAOptimizer.MINUS_ONE;
            CallChecker.varAssign(crvmin, "crvmin", 1865, 88520, 88538);
            int state = CallChecker.varInit(((int) (20)), "state", 1873, 88946, 88960);
            for (; ;) {
                switch (state) {
                    case 20 :
                        {
                            BOBYQAOptimizer.printState(20);
                            beta = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(beta, "beta", 1878, 89075, 89086);
                        }
                    case 30 :
                        {
                            BOBYQAOptimizer.printState(30);
                            stepsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(stepsq, "stepsq", 1882, 89164, 89177);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1884, 89241, 89244)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1884, 89241, 89244);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1884, 89241, 89244).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1885, 89289, 89289)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1885, 89289, 89289);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 1885, 89289, 89289).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }else
                                        if (beta == (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1887, 89388, 89391)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1887, 89373, 89373)) {
                                                    gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1887, 89388, 89391);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1887, 89373, 89373);
                                                    CallChecker.isCalled(s, ArrayRealVector.class, 1887, 89373, 89373).setEntry(i, (-(CallChecker.isCalled(gnew, ArrayRealVector.class, 1887, 89388, 89391).getEntry(i))));
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1889, 89473, 89473)) {
                                                if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1889, 89489, 89492)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1889, 89452, 89452)) {
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1889, 89473, 89473);
                                                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1889, 89489, 89492);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1889, 89452, 89452);
                                                        CallChecker.isCalled(s, ArrayRealVector.class, 1889, 89452, 89452).setEntry(i, ((beta * (CallChecker.isCalled(s, ArrayRealVector.class, 1889, 89473, 89473).getEntry(i))) - (CallChecker.isCalled(gnew, ArrayRealVector.class, 1889, 89489, 89492).getEntry(i))));
                                                    }
                                                }
                                            }
                                        }
                                    
                                }
                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1892, 89599, 89599);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(s, ArrayRealVector.class, 1892, 89599, 89599).getEntry(i))), "d1", 1892, 89542, 89612);
                                stepsq += d1 * d1;
                                CallChecker.varAssign(stepsq, "stepsq", 1893, 89630, 89647);
                            }
                            if (stepsq == (BOBYQAOptimizer.ZERO)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 1896, 89713, 89724);
                                break;
                            }
                            if (beta == (BOBYQAOptimizer.ZERO)) {
                                gredsq = stepsq;
                                CallChecker.varAssign(gredsq, "gredsq", 1899, 89795, 89810);
                                itermax = (iterc + n) - nact;
                                CallChecker.varAssign(itermax, "itermax", 1900, 89828, 89854);
                            }
                            if ((gredsq * delsq) <= ((qred * 1.0E-4) * qred)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 1903, 89942, 89953);
                                break;
                            }
                            state = 210;
                            CallChecker.varAssign(state, "state", 1911, 90305, 90316);
                            break;
                        }
                    case 50 :
                        {
                            BOBYQAOptimizer.printState(50);
                            resid = delsq;
                            CallChecker.varAssign(resid, "resid", 1915, 90401, 90414);
                            ds = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(ds, "ds", 1916, 90428, 90437);
                            shs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(shs, "shs", 1917, 90451, 90461);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1919, 90525, 90528)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1919, 90525, 90528);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1919, 90525, 90528).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1921, 90634, 90647);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 1921, 90634, 90647).getEntry(i))), "d1", 1921, 90573, 90660);
                                        resid -= d1 * d1;
                                        CallChecker.varAssign(resid, "resid", 1922, 90682, 90698);
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1923, 90726, 90726)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1923, 90742, 90755)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1923, 90726, 90726);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1923, 90742, 90755);
                                                ds += (CallChecker.isCalled(s, ArrayRealVector.class, 1923, 90726, 90726).getEntry(i)) * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1923, 90742, 90755).getEntry(i));
                                                CallChecker.varAssign(ds, "ds", 1923, 90720, 90768);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1924, 90797, 90797)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 1924, 90813, 90814)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1924, 90797, 90797);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 1924, 90813, 90814);
                                                shs += (CallChecker.isCalled(s, ArrayRealVector.class, 1924, 90797, 90797).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 1924, 90813, 90814).getEntry(i));
                                                CallChecker.varAssign(shs, "shs", 1924, 90790, 90827);
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            if (resid <= (BOBYQAOptimizer.ZERO)) {
                                state = 90;
                                CallChecker.varAssign(state, "state", 1928, 90910, 90920);
                                break;
                            }
                            temp = Math.sqrt(((stepsq * resid) + (ds * ds)));
                            CallChecker.varAssign(temp, "temp", 1930, 90955, 90997);
                            if (ds < (BOBYQAOptimizer.ZERO)) {
                                blen = (temp - ds) / stepsq;
                                CallChecker.varAssign(blen, "blen", 1932, 91044, 91071);
                            }else {
                                blen = resid / (temp + ds);
                                CallChecker.varAssign(blen, "blen", 1934, 91110, 91136);
                            }
                            stplen = blen;
                            CallChecker.varAssign(stplen, "stplen", 1936, 91164, 91177);
                            if (shs > (BOBYQAOptimizer.ZERO)) {
                                stplen = Math.min(blen, (gredsq / shs));
                                CallChecker.varAssign(stplen, "stplen", 1939, 91258, 91295);
                            }
                            iact = -1;
                            CallChecker.varAssign(iact, "iact", 1945, 91481, 91490);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1947, 91554, 91554)) {
                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1947, 91554, 91554);
                                    if ((CallChecker.isCalled(s, ArrayRealVector.class, 1947, 91554, 91554).getEntry(i)) != (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 1948, 91606, 91628)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1948, 91644, 91657)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 1948, 91606, 91628);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1948, 91644, 91657);
                                                xsum = (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 1948, 91606, 91628).getEntry(i)) + (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1948, 91644, 91657).getEntry(i));
                                                CallChecker.varAssign(xsum, "xsum", 1948, 91599, 91670);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1949, 91696, 91696)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1949, 91696, 91696);
                                            if ((CallChecker.isCalled(s, ArrayRealVector.class, 1949, 91696, 91696).getEntry(i)) > (BOBYQAOptimizer.ZERO)) {
                                                if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 1950, 91752, 91766)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1950, 91790, 91790)) {
                                                        upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 1950, 91752, 91766);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1950, 91790, 91790);
                                                        temp = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 1950, 91752, 91766).getEntry(i)) - xsum) / (CallChecker.isCalled(s, ArrayRealVector.class, 1950, 91790, 91790).getEntry(i));
                                                        CallChecker.varAssign(temp, "temp", 1950, 91744, 91803);
                                                    }
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 1952, 91866, 91880)) {
                                                    if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1952, 91904, 91904)) {
                                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 1952, 91866, 91880);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1952, 91904, 91904);
                                                        temp = ((CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 1952, 91866, 91880).getEntry(i)) - xsum) / (CallChecker.isCalled(s, ArrayRealVector.class, 1952, 91904, 91904).getEntry(i));
                                                        CallChecker.varAssign(temp, "temp", 1952, 91858, 91917);
                                                    }
                                                }
                                            }
                                        }
                                        if (temp < stplen) {
                                            stplen = temp;
                                            CallChecker.varAssign(stplen, "stplen", 1955, 92006, 92019);
                                            iact = i;
                                            CallChecker.varAssign(iact, "iact", 1956, 92045, 92053);
                                        }
                                    }
                                }
                            }
                            sdec = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(sdec, "sdec", 1963, 92208, 92219);
                            if (stplen > (BOBYQAOptimizer.ZERO)) {
                                ++iterc;
                                temp = shs / stepsq;
                                CallChecker.varAssign(temp, "temp", 1966, 92295, 92314);
                                if ((iact == (-1)) && (temp > (BOBYQAOptimizer.ZERO))) {
                                    crvmin = Math.min(crvmin, temp);
                                    CallChecker.varAssign(crvmin, "crvmin", 1968, 92385, 92415);
                                    if (crvmin == (BOBYQAOptimizer.MINUS_ONE)) {
                                        crvmin = temp;
                                        CallChecker.varAssign(crvmin, "crvmin", 1970, 92488, 92501);
                                    }
                                }
                                ggsav = gredsq;
                                CallChecker.varAssign(ggsav, "ggsav", 1973, 92559, 92573);
                                gredsq = BOBYQAOptimizer.ZERO;
                                CallChecker.varAssign(gredsq, "gredsq", 1974, 92591, 92604);
                                for (int i = 0; i < n; i++) {
                                    if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1976, 92689, 92692)) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 1976, 92717, 92718)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 1976, 92672, 92675)) {
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1976, 92689, 92692);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 1976, 92717, 92718);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1976, 92672, 92675);
                                                CallChecker.isCalled(gnew, ArrayRealVector.class, 1976, 92672, 92675).setEntry(i, ((CallChecker.isCalled(gnew, ArrayRealVector.class, 1976, 92689, 92692).getEntry(i)) + (stplen * (CallChecker.isCalled(hs, ArrayRealVector.class, 1976, 92717, 92718).getEntry(i)))));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1977, 92758, 92761)) {
                                        xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1977, 92758, 92761);
                                        if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 1977, 92758, 92761).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                            gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 1979, 92875, 92878);
                                            final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(gnew, ArrayRealVector.class, 1979, 92875, 92878).getEntry(i))), "d1", 1979, 92810, 92891);
                                            gredsq += d1 * d1;
                                            CallChecker.varAssign(gredsq, "gredsq", 1980, 92917, 92934);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1982, 93005, 93018)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1982, 93043, 93043)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 1982, 92978, 92991)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1982, 93005, 93018);
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1982, 93043, 93043);
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1982, 92978, 92991);
                                                CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1982, 92978, 92991).setEntry(i, ((CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 1982, 93005, 93018).getEntry(i)) + (stplen * (CallChecker.isCalled(s, ArrayRealVector.class, 1982, 93043, 93043).getEntry(i)))));
                                            }
                                        }
                                    }
                                }
                                final double d1 = CallChecker.varInit(((double) (stplen * (ggsav - (((BOBYQAOptimizer.HALF) * stplen) * shs)))), "d1", 1985, 93093, 93182);
                                sdec = Math.max(d1, BOBYQAOptimizer.ZERO);
                                CallChecker.varAssign(sdec, "sdec", 1986, 93200, 93225);
                                qred += sdec;
                                CallChecker.varAssign(qred, "qred", 1987, 93243, 93255);
                            }
                            if (iact >= 0) {
                                ++nact;
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1994, 93422, 93425)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1994, 93422, 93425);
                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 1994, 93422, 93425).setEntry(iact, BOBYQAOptimizer.ONE);
                                }
                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 1995, 93468, 93468)) {
                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 1995, 93468, 93468);
                                    if ((CallChecker.isCalled(s, ArrayRealVector.class, 1995, 93468, 93468).getEntry(iact)) < (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 1996, 93515, 93518)) {
                                            xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 1996, 93515, 93518);
                                            CallChecker.isCalled(xbdi, ArrayRealVector.class, 1996, 93515, 93518).setEntry(iact, BOBYQAOptimizer.MINUS_ONE);
                                        }
                                    }
                                }
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 1999, 93638, 93651);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 1999, 93638, 93651).getEntry(iact))), "d1", 1999, 93581, 93667);
                                delsq -= d1 * d1;
                                CallChecker.varAssign(delsq, "delsq", 2000, 93685, 93701);
                                if (delsq <= (BOBYQAOptimizer.ZERO)) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 2002, 93760, 93771);
                                    break;
                                }
                                state = 20;
                                CallChecker.varAssign(state, "state", 2004, 93814, 93824);
                                break;
                            }
                            if (stplen < blen) {
                                if (iterc == itermax) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 2012, 94067, 94078);
                                    break;
                                }
                                if (sdec <= (qred * 0.01)) {
                                    state = 190;
                                    CallChecker.varAssign(state, "state", 2015, 94167, 94178);
                                    break;
                                }
                                beta = gredsq / ggsav;
                                CallChecker.varAssign(beta, "beta", 2017, 94221, 94242);
                                state = 30;
                                CallChecker.varAssign(state, "state", 2018, 94260, 94270);
                                break;
                            }
                        }
                    case 90 :
                        {
                            BOBYQAOptimizer.printState(90);
                            crvmin = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(crvmin, "crvmin", 2023, 94369, 94382);
                        }
                    case 100 :
                        {
                            BOBYQAOptimizer.printState(100);
                            if (nact >= (n - 1)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2033, 94734, 94745);
                                break;
                            }
                            dredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredsq, "dredsq", 2035, 94780, 94793);
                            dredg = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredg, "dredg", 2036, 94807, 94819);
                            gredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(gredsq, "gredsq", 2037, 94833, 94846);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2039, 94910, 94913)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2039, 94910, 94913);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2039, 94910, 94913).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        double d1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2041, 95013, 95026)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2041, 95013, 95026);
                                            d1 = CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2041, 95013, 95026).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2041, 95013, 95026);
                                        }
                                        dredsq += d1 * d1;
                                        CallChecker.varAssign(dredsq, "dredsq", 2042, 95061, 95078);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2043, 95109, 95122)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2043, 95138, 95141)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2043, 95109, 95122);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2043, 95138, 95141);
                                                dredg += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2043, 95109, 95122).getEntry(i)) * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2043, 95138, 95141).getEntry(i));
                                                CallChecker.varAssign(dredg, "dredg", 2043, 95100, 95154);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2045, 95224, 95227)) {
                                            gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2045, 95224, 95227);
                                            d1 = CallChecker.isCalled(gnew, ArrayRealVector.class, 2045, 95224, 95227).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2045, 95219, 95240);
                                        }
                                        gredsq += d1 * d1;
                                        CallChecker.varAssign(gredsq, "gredsq", 2046, 95262, 95279);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2047, 95315, 95328)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2047, 95301, 95301)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2047, 95315, 95328);
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2047, 95301, 95301);
                                                CallChecker.isCalled(s, ArrayRealVector.class, 2047, 95301, 95301).setEntry(i, CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2047, 95315, 95328).getEntry(i));
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2049, 95389, 95389)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2049, 95389, 95389);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 2049, 95389, 95389).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            itcsav = iterc;
                            CallChecker.varAssign(itcsav, "itcsav", 2052, 95454, 95468);
                            state = 210;
                            CallChecker.varAssign(state, "state", 2053, 95482, 95493);
                            break;
                        }
                    case 120 :
                        {
                            BOBYQAOptimizer.printState(120);
                            ++iterc;
                            temp = (gredsq * dredsq) - (dredg * dredg);
                            CallChecker.varAssign(temp, "temp", 2060, 95754, 95792);
                            if (temp <= ((qred * 1.0E-4) * qred)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2062, 95856, 95867);
                                break;
                            }
                            temp = Math.sqrt(temp);
                            CallChecker.varAssign(temp, "temp", 2064, 95902, 95924);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2066, 95988, 95991)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2066, 95988, 95991);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2066, 95988, 95991).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2067, 96059, 96072)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2067, 96097, 96100)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2067, 96036, 96036)) {
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2067, 96059, 96072);
                                                    gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2067, 96097, 96100);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2067, 96036, 96036);
                                                    CallChecker.isCalled(s, ArrayRealVector.class, 2067, 96036, 96036).setEntry(i, (((dredg * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2067, 96059, 96072).getEntry(i))) - (dredsq * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2067, 96097, 96100).getEntry(i)))) / temp));
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2069, 96169, 96169)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2069, 96169, 96169);
                                            CallChecker.isCalled(s, ArrayRealVector.class, 2069, 96169, 96169).setEntry(i, BOBYQAOptimizer.ZERO);
                                        }
                                    }
                                }
                            }
                            sredg = -temp;
                            CallChecker.varAssign(sredg, "sredg", 2072, 96234, 96247);
                            angbd = BOBYQAOptimizer.ONE;
                            CallChecker.varAssign(angbd, "angbd", 2079, 96601, 96612);
                            iact = -1;
                            CallChecker.varAssign(iact, "iact", 2080, 96626, 96635);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2082, 96699, 96702)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2082, 96699, 96702);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2082, 96699, 96702).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2083, 96755, 96777)) {
                                            if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2083, 96793, 96806)) {
                                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2083, 96822, 96836)) {
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2083, 96755, 96777);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2083, 96793, 96806);
                                                    lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2083, 96822, 96836);
                                                    tempa = ((CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2083, 96755, 96777).getEntry(i)) + (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2083, 96793, 96806).getEntry(i))) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2083, 96822, 96836).getEntry(i));
                                                    CallChecker.varAssign(tempa, "tempa", 2083, 96747, 96849);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2084, 96879, 96893)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2084, 96909, 96931)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2084, 96947, 96960)) {
                                                    upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2084, 96879, 96893);
                                                    trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2084, 96909, 96931);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2084, 96947, 96960);
                                                    tempb = ((CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2084, 96879, 96893).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2084, 96909, 96931).getEntry(i))) - (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2084, 96947, 96960).getEntry(i));
                                                    CallChecker.varAssign(tempb, "tempb", 2084, 96871, 96973);
                                                }
                                            }
                                        }
                                        if (tempa <= (BOBYQAOptimizer.ZERO)) {
                                            ++nact;
                                            if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2087, 97072, 97075)) {
                                                xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2087, 97072, 97075);
                                                CallChecker.isCalled(xbdi, ArrayRealVector.class, 2087, 97072, 97075).setEntry(i, BOBYQAOptimizer.MINUS_ONE);
                                            }
                                            state = 100;
                                            CallChecker.varAssign(state, "state", 2088, 97125, 97136);
                                            break;
                                        }else
                                            if (tempb <= (BOBYQAOptimizer.ZERO)) {
                                                ++nact;
                                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2091, 97249, 97252)) {
                                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2091, 97249, 97252);
                                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 2091, 97249, 97252).setEntry(i, BOBYQAOptimizer.ONE);
                                                }
                                                state = 100;
                                                CallChecker.varAssign(state, "state", 2092, 97296, 97307);
                                                break;
                                            }
                                        
                                        double d1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2095, 97413, 97426)) {
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2095, 97413, 97426);
                                            d1 = CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2095, 97413, 97426).getEntry(i);
                                            CallChecker.varAssign(d1, "d1", 2095, 97413, 97426);
                                        }
                                        double d2 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2097, 97516, 97516)) {
                                            s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2097, 97516, 97516);
                                            d2 = CallChecker.isCalled(s, ArrayRealVector.class, 2097, 97516, 97516).getEntry(i);
                                            CallChecker.varAssign(d2, "d2", 2097, 97516, 97516);
                                        }
                                        ssq = (d1 * d1) + (d2 * d2);
                                        CallChecker.varAssign(ssq, "ssq", 2098, 97551, 97574);
                                        if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2100, 97644, 97666)) {
                                            if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2100, 97682, 97696)) {
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2100, 97644, 97666);
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2100, 97682, 97696);
                                                d1 = (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2100, 97644, 97666).getEntry(i)) - (CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2100, 97682, 97696).getEntry(i));
                                                CallChecker.varAssign(d1, "d1", 2100, 97639, 97709);
                                            }
                                        }
                                        temp = ssq - (d1 * d1);
                                        CallChecker.varAssign(temp, "temp", 2101, 97731, 97751);
                                        if (temp > (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2103, 97841, 97841)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2103, 97841, 97841);
                                                temp = (Math.sqrt(temp)) - (CallChecker.isCalled(s, ArrayRealVector.class, 2103, 97841, 97841).getEntry(i));
                                                CallChecker.varAssign(temp, "temp", 2103, 97816, 97854);
                                            }
                                            if ((angbd * temp) > tempa) {
                                                angbd = tempa / temp;
                                                CallChecker.varAssign(angbd, "angbd", 2105, 97936, 97956);
                                                iact = i;
                                                CallChecker.varAssign(iact, "iact", 2106, 97986, 97994);
                                                xsav = BOBYQAOptimizer.MINUS_ONE;
                                                CallChecker.varAssign(xsav, "xsav", 2107, 98024, 98040);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2111, 98158, 98172)) {
                                            if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2111, 98188, 98210)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2111, 98158, 98172);
                                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2111, 98188, 98210);
                                                d1 = (CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2111, 98158, 98172).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2111, 98188, 98210).getEntry(i));
                                                CallChecker.varAssign(d1, "d1", 2111, 98153, 98223);
                                            }
                                        }
                                        temp = ssq - (d1 * d1);
                                        CallChecker.varAssign(temp, "temp", 2112, 98245, 98265);
                                        if (temp > (BOBYQAOptimizer.ZERO)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2114, 98355, 98355)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2114, 98355, 98355);
                                                temp = (Math.sqrt(temp)) + (CallChecker.isCalled(s, ArrayRealVector.class, 2114, 98355, 98355).getEntry(i));
                                                CallChecker.varAssign(temp, "temp", 2114, 98330, 98368);
                                            }
                                            if ((angbd * temp) > tempb) {
                                                angbd = tempb / temp;
                                                CallChecker.varAssign(angbd, "angbd", 2116, 98450, 98470);
                                                iact = i;
                                                CallChecker.varAssign(iact, "iact", 2117, 98500, 98508);
                                                xsav = BOBYQAOptimizer.ONE;
                                                CallChecker.varAssign(xsav, "xsav", 2118, 98538, 98548);
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                            state = 210;
                            CallChecker.varAssign(state, "state", 2126, 98724, 98735);
                            break;
                        }
                    case 150 :
                        {
                            BOBYQAOptimizer.printState(150);
                            shs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(shs, "shs", 2130, 98822, 98832);
                            dhs = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dhs, "dhs", 2131, 98846, 98856);
                            dhd = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dhd, "dhd", 2132, 98870, 98880);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2134, 98944, 98947)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2134, 98944, 98947);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2134, 98944, 98947).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2135, 98999, 98999)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2135, 99015, 99016)) {
                                                s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2135, 98999, 98999);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2135, 99015, 99016);
                                                shs += (CallChecker.isCalled(s, ArrayRealVector.class, 2135, 98999, 98999).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 2135, 99015, 99016).getEntry(i));
                                                CallChecker.varAssign(shs, "shs", 2135, 98992, 99029);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2136, 99058, 99071)) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2136, 99087, 99088)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2136, 99058, 99071);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2136, 99087, 99088);
                                                dhs += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2136, 99058, 99071).getEntry(i)) * (CallChecker.isCalled(hs, ArrayRealVector.class, 2136, 99087, 99088).getEntry(i));
                                                CallChecker.varAssign(dhs, "dhs", 2136, 99051, 99101);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2137, 99130, 99143)) {
                                            if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2137, 99159, 99162)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2137, 99130, 99143);
                                                hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2137, 99159, 99162);
                                                dhd += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2137, 99130, 99143).getEntry(i)) * (CallChecker.isCalled(hred, ArrayRealVector.class, 2137, 99159, 99162).getEntry(i));
                                                CallChecker.varAssign(dhd, "dhd", 2137, 99123, 99175);
                                            }
                                        }
                                    }
                                }
                            }
                            redmax = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(redmax, "redmax", 2145, 99434, 99447);
                            isav = -1;
                            CallChecker.varAssign(isav, "isav", 2146, 99461, 99470);
                            redsav = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(redsav, "redsav", 2147, 99484, 99497);
                            iu = ((int) ((angbd * 17.0) + 3.1));
                            CallChecker.varAssign(iu, "iu", 2148, 99511, 99541);
                            for (int i = 0; i < iu; i++) {
                                angt = (angbd * i) / iu;
                                CallChecker.varAssign(angt, "angt", 2150, 99602, 99623);
                                sth = (angt + angt) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                                CallChecker.varAssign(sth, "sth", 2151, 99641, 99682);
                                temp = shs + (angt * (((angt * dhd) - dhs) - dhs));
                                CallChecker.varAssign(temp, "temp", 2152, 99700, 99744);
                                rednew = sth * (((angt * dredg) - sredg) - (((BOBYQAOptimizer.HALF) * sth) * temp));
                                CallChecker.varAssign(rednew, "rednew", 2153, 99762, 99819);
                                if (rednew > redmax) {
                                    redmax = rednew;
                                    CallChecker.varAssign(redmax, "redmax", 2155, 99880, 99895);
                                    isav = i;
                                    CallChecker.varAssign(isav, "isav", 2156, 99917, 99925);
                                    rdprev = redsav;
                                    CallChecker.varAssign(rdprev, "rdprev", 2157, 99947, 99962);
                                }else
                                    if (i == (isav + 1)) {
                                        rdnext = rednew;
                                        CallChecker.varAssign(rdnext, "rdnext", 2159, 100028, 100043);
                                    }
                                
                                redsav = rednew;
                                CallChecker.varAssign(redsav, "redsav", 2161, 100079, 100094);
                            }
                            if (isav < 0) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2168, 100317, 100328);
                                break;
                            }
                            if (isav < iu) {
                                temp = (rdnext - rdprev) / (((redmax + redmax) - rdprev) - rdnext);
                                CallChecker.varAssign(temp, "temp", 2171, 100396, 100458);
                                angt = (angbd * (isav + ((BOBYQAOptimizer.HALF) * temp))) / iu;
                                CallChecker.varAssign(angt, "angt", 2172, 100476, 100516);
                            }
                            cth = ((BOBYQAOptimizer.ONE) - (angt * angt)) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                            CallChecker.varAssign(cth, "cth", 2174, 100544, 100591);
                            sth = (angt + angt) / ((BOBYQAOptimizer.ONE) + (angt * angt));
                            CallChecker.varAssign(sth, "sth", 2175, 100605, 100646);
                            temp = shs + (angt * (((angt * dhd) - dhs) - dhs));
                            CallChecker.varAssign(temp, "temp", 2176, 100660, 100704);
                            sdec = sth * (((angt * dredg) - sredg) - (((BOBYQAOptimizer.HALF) * sth) * temp));
                            CallChecker.varAssign(sdec, "sdec", 2177, 100718, 100773);
                            if (sdec <= (BOBYQAOptimizer.ZERO)) {
                                state = 190;
                                CallChecker.varAssign(state, "state", 2179, 100823, 100834);
                                break;
                            }
                            dredg = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dredg, "dredg", 2186, 101065, 101077);
                            gredsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(gredsq, "gredsq", 2187, 101091, 101104);
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2189, 101181, 101184)) {
                                    if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2189, 101214, 101217)) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2189, 101239, 101240)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2189, 101164, 101167)) {
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2189, 101181, 101184);
                                                hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2189, 101214, 101217);
                                                hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2189, 101239, 101240);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2189, 101164, 101167);
                                                CallChecker.isCalled(gnew, ArrayRealVector.class, 2189, 101164, 101167).setEntry(i, (((CallChecker.isCalled(gnew, ArrayRealVector.class, 2189, 101181, 101184).getEntry(i)) + ((cth - (BOBYQAOptimizer.ONE)) * (CallChecker.isCalled(hred, ArrayRealVector.class, 2189, 101214, 101217).getEntry(i)))) + (sth * (CallChecker.isCalled(hs, ArrayRealVector.class, 2189, 101239, 101240).getEntry(i)))));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2190, 101276, 101279)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2190, 101276, 101279);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2190, 101276, 101279).getEntry(i)) == (BOBYQAOptimizer.ZERO)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2191, 101357, 101370)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2191, 101392, 101392)) {
                                                if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2191, 101324, 101337)) {
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2191, 101357, 101370);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2191, 101392, 101392);
                                                    trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2191, 101324, 101337);
                                                    CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2191, 101324, 101337).setEntry(i, ((cth * (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2191, 101357, 101370).getEntry(i))) + (sth * (CallChecker.isCalled(s, ArrayRealVector.class, 2191, 101392, 101392).getEntry(i)))));
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2192, 101437, 101450)) {
                                            if (CallChecker.beforeDeref(gnew, ArrayRealVector.class, 2192, 101466, 101469)) {
                                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2192, 101437, 101450);
                                                gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2192, 101466, 101469);
                                                dredg += (CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2192, 101437, 101450).getEntry(i)) * (CallChecker.isCalled(gnew, ArrayRealVector.class, 2192, 101466, 101469).getEntry(i));
                                                CallChecker.varAssign(dredg, "dredg", 2192, 101428, 101482);
                                            }
                                        }
                                        gnew = CallChecker.beforeCalled(gnew, ArrayRealVector.class, 2194, 101565, 101568);
                                        final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(gnew, ArrayRealVector.class, 2194, 101565, 101568).getEntry(i))), "d1", 2194, 101504, 101581);
                                        gredsq += d1 * d1;
                                        CallChecker.varAssign(gredsq, "gredsq", 2195, 101603, 101620);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2197, 101679, 101682)) {
                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2197, 101704, 101705)) {
                                        if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2197, 101656, 101659)) {
                                            hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2197, 101679, 101682);
                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2197, 101704, 101705);
                                            hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2197, 101656, 101659);
                                            CallChecker.isCalled(hred, ArrayRealVector.class, 2197, 101656, 101659).setEntry(i, ((cth * (CallChecker.isCalled(hred, ArrayRealVector.class, 2197, 101679, 101682).getEntry(i))) + (sth * (CallChecker.isCalled(hs, ArrayRealVector.class, 2197, 101704, 101705).getEntry(i)))));
                                        }
                                    }
                                }
                            }
                            qred += sdec;
                            CallChecker.varAssign(qred, "qred", 2199, 101747, 101759);
                            if ((iact >= 0) && (isav == iu)) {
                                ++nact;
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2202, 101844, 101847)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2202, 101844, 101847);
                                    CallChecker.isCalled(xbdi, ArrayRealVector.class, 2202, 101844, 101847).setEntry(iact, xsav);
                                }
                                state = 100;
                                CallChecker.varAssign(state, "state", 2203, 101887, 101898);
                                break;
                            }
                            if (sdec > (qred * 0.01)) {
                                state = 120;
                                CallChecker.varAssign(state, "state", 2210, 102119, 102130);
                                break;
                            }
                        }
                    case 190 :
                        {
                            BOBYQAOptimizer.printState(190);
                            dsq = BOBYQAOptimizer.ZERO;
                            CallChecker.varAssign(dsq, "dsq", 2215, 102231, 102241);
                            for (int i = 0; i < n; i++) {
                                trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2219, 102395, 102417);
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2219, 102433, 102446);
                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2220, 102505, 102519);
                                final double min = CallChecker.varInit(((double) (Math.min(((CallChecker.isCalled(this.trustRegionCenterOffset, ArrayRealVector.class, 2219, 102395, 102417).getEntry(i)) + (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 2219, 102433, 102446).getEntry(i))), CallChecker.isCalled(this.upperDifference, ArrayRealVector.class, 2220, 102505, 102519).getEntry(i)))), "min", 2219, 102301, 102533);
                                if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2221, 102586, 102600)) {
                                    if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2221, 102551, 102558)) {
                                        lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2221, 102586, 102600);
                                        newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2221, 102551, 102558);
                                        CallChecker.isCalled(newPoint, ArrayRealVector.class, 2221, 102551, 102558).setEntry(i, Math.max(min, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2221, 102586, 102600).getEntry(i)));
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2222, 102637, 102640)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2222, 102637, 102640);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2222, 102637, 102640).getEntry(i)) == (BOBYQAOptimizer.MINUS_ONE)) {
                                        if (CallChecker.beforeDeref(lowerDifference, ArrayRealVector.class, 2223, 102711, 102725)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2223, 102690, 102697)) {
                                                lowerDifference = CallChecker.beforeCalled(lowerDifference, ArrayRealVector.class, 2223, 102711, 102725);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2223, 102690, 102697);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 2223, 102690, 102697).setEntry(i, CallChecker.isCalled(lowerDifference, ArrayRealVector.class, 2223, 102711, 102725).getEntry(i));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(xbdi, ArrayRealVector.class, 2225, 102779, 102782)) {
                                    xbdi = CallChecker.beforeCalled(xbdi, ArrayRealVector.class, 2225, 102779, 102782);
                                    if ((CallChecker.isCalled(xbdi, ArrayRealVector.class, 2225, 102779, 102782).getEntry(i)) == (BOBYQAOptimizer.ONE)) {
                                        if (CallChecker.beforeDeref(upperDifference, ArrayRealVector.class, 2226, 102847, 102861)) {
                                            if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2226, 102826, 102833)) {
                                                upperDifference = CallChecker.beforeCalled(upperDifference, ArrayRealVector.class, 2226, 102847, 102861);
                                                newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2226, 102826, 102833);
                                                CallChecker.isCalled(newPoint, ArrayRealVector.class, 2226, 102826, 102833).setEntry(i, CallChecker.isCalled(upperDifference, ArrayRealVector.class, 2226, 102847, 102861).getEntry(i));
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(newPoint, ArrayRealVector.class, 2228, 102938, 102945)) {
                                    if (CallChecker.beforeDeref(trustRegionCenterOffset, ArrayRealVector.class, 2228, 102961, 102983)) {
                                        if (CallChecker.beforeDeref(trialStepPoint, ArrayRealVector.class, 2228, 102911, 102924)) {
                                            newPoint = CallChecker.beforeCalled(newPoint, ArrayRealVector.class, 2228, 102938, 102945);
                                            trustRegionCenterOffset = CallChecker.beforeCalled(trustRegionCenterOffset, ArrayRealVector.class, 2228, 102961, 102983);
                                            trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2228, 102911, 102924);
                                            CallChecker.isCalled(trialStepPoint, ArrayRealVector.class, 2228, 102911, 102924).setEntry(i, ((CallChecker.isCalled(newPoint, ArrayRealVector.class, 2228, 102938, 102945).getEntry(i)) - (CallChecker.isCalled(trustRegionCenterOffset, ArrayRealVector.class, 2228, 102961, 102983).getEntry(i))));
                                        }
                                    }
                                }
                                trialStepPoint = CallChecker.beforeCalled(trialStepPoint, ArrayRealVector.class, 2230, 103072, 103085);
                                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.trialStepPoint, ArrayRealVector.class, 2230, 103072, 103085).getEntry(i))), "d1", 2230, 103015, 103098);
                                dsq += d1 * d1;
                                CallChecker.varAssign(dsq, "dsq", 2231, 103116, 103130);
                            }
                            return new double[]{ dsq , crvmin };
                        }
                    case 210 :
                        {
                            BOBYQAOptimizer.printState(210);
                            int ih = CallChecker.varInit(((int) (0)), "ih", 2241, 103591, 103601);
                            for (int j = 0; j < n; j++) {
                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2243, 103661, 103662)) {
                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2243, 103661, 103662);
                                    CallChecker.isCalled(hs, ArrayRealVector.class, 2243, 103661, 103662).setEntry(j, BOBYQAOptimizer.ZERO);
                                }
                                for (int i = 0; i <= j; i++) {
                                    if (i < j) {
                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2246, 103802, 103803)) {
                                            if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 2246, 103819, 103846)) {
                                                if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2246, 103863, 103863)) {
                                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2246, 103787, 103788)) {
                                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2246, 103802, 103803);
                                                        modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2246, 103819, 103846);
                                                        s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2246, 103863, 103863);
                                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2246, 103787, 103788);
                                                        CallChecker.isCalled(hs, ArrayRealVector.class, 2246, 103787, 103788).setEntry(j, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2246, 103802, 103803).getEntry(j)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2246, 103819, 103846).getEntry(ih)) * (CallChecker.isCalled(s, ArrayRealVector.class, 2246, 103863, 103863).getEntry(i)))));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2248, 103936, 103937)) {
                                        if (CallChecker.beforeDeref(modelSecondDerivativesValues, ArrayRealVector.class, 2248, 103953, 103980)) {
                                            if (CallChecker.beforeDeref(s, ArrayRealVector.class, 2248, 103997, 103997)) {
                                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2248, 103921, 103922)) {
                                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2248, 103936, 103937);
                                                    modelSecondDerivativesValues = CallChecker.beforeCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2248, 103953, 103980);
                                                    s = CallChecker.beforeCalled(s, ArrayRealVector.class, 2248, 103997, 103997);
                                                    hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2248, 103921, 103922);
                                                    CallChecker.isCalled(hs, ArrayRealVector.class, 2248, 103921, 103922).setEntry(i, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2248, 103936, 103937).getEntry(i)) + ((CallChecker.isCalled(modelSecondDerivativesValues, ArrayRealVector.class, 2248, 103953, 103980).getEntry(ih)) * (CallChecker.isCalled(s, ArrayRealVector.class, 2248, 103997, 103997).getEntry(j)))));
                                                }
                                            }
                                        }
                                    }
                                    ih++;
                                }
                            }
                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 2252, 104106, 104124);
                            final RealVector tmp = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 2252, 104106, 104124).operate(s), RealVector.class, 2252, 104106, 104135).ebeMultiply(modelSecondDerivativesParameters), "tmp", 2252, 104083, 104182);
                            for (int k = 0; k < npt; k++) {
                                if (CallChecker.beforeDeref(modelSecondDerivativesParameters, ArrayRealVector.class, 2254, 104248, 104279)) {
                                    modelSecondDerivativesParameters = CallChecker.beforeCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 2254, 104248, 104279);
                                    if ((CallChecker.isCalled(modelSecondDerivativesParameters, ArrayRealVector.class, 2254, 104248, 104279).getEntry(k)) != (BOBYQAOptimizer.ZERO)) {
                                        for (int i = 0; i < n; i++) {
                                            if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2256, 104393, 104394)) {
                                                if (CallChecker.beforeDeref(tmp, RealVector.class, 2256, 104410, 104412)) {
                                                    if (CallChecker.beforeDeref(interpolationPoints, Array2DRowRealMatrix.class, 2256, 104428, 104446)) {
                                                        if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2256, 104378, 104379)) {
                                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2256, 104393, 104394);
                                                            interpolationPoints = CallChecker.beforeCalled(interpolationPoints, Array2DRowRealMatrix.class, 2256, 104428, 104446);
                                                            hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2256, 104378, 104379);
                                                            CallChecker.isCalled(hs, ArrayRealVector.class, 2256, 104378, 104379).setEntry(i, ((CallChecker.isCalled(hs, ArrayRealVector.class, 2256, 104393, 104394).getEntry(i)) + ((CallChecker.isCalled(tmp, RealVector.class, 2256, 104410, 104412).getEntry(k)) * (CallChecker.isCalled(interpolationPoints, Array2DRowRealMatrix.class, 2256, 104428, 104446).getEntry(k, i)))));
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
                                CallChecker.varAssign(state, "state", 2261, 104569, 104579);
                                break;
                            }
                            if (iterc > itcsav) {
                                state = 150;
                                CallChecker.varAssign(state, "state", 2264, 104652, 104663);
                                break;
                            }
                            for (int i = 0; i < n; i++) {
                                if (CallChecker.beforeDeref(hs, ArrayRealVector.class, 2267, 104761, 104762)) {
                                    if (CallChecker.beforeDeref(hred, ArrayRealVector.class, 2267, 104744, 104747)) {
                                        hs = CallChecker.beforeCalled(hs, ArrayRealVector.class, 2267, 104761, 104762);
                                        hred = CallChecker.beforeCalled(hred, ArrayRealVector.class, 2267, 104744, 104747);
                                        CallChecker.isCalled(hred, ArrayRealVector.class, 2267, 104744, 104747).setEntry(i, CallChecker.isCalled(hs, ArrayRealVector.class, 2267, 104761, 104762).getEntry(i));
                                    }
                                }
                            }
                            state = 120;
                            CallChecker.varAssign(state, "state", 2269, 104804, 104815);
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
            _bcornu_methode_context4537.methodEnd();
        }
    }

    private void update(double beta, double denom, int knew) {
        MethodContext _bcornu_methode_context4538 = new MethodContext(void.class, 2292, 104987, 109118);
        try {
            CallChecker.varInit(this, "this", 2292, 104987, 109118);
            CallChecker.varInit(knew, "knew", 2292, 104987, 109118);
            CallChecker.varInit(denom, "denom", 2292, 104987, 109118);
            CallChecker.varInit(beta, "beta", 2292, 104987, 109118);
            CallChecker.varInit(this.evaluations, "evaluations", 2292, 104987, 109118);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 2292, 104987, 109118);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 2292, 104987, 109118);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 2292, 104987, 109118);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 2292, 104987, 109118);
            CallChecker.varInit(this.newPoint, "newPoint", 2292, 104987, 109118);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 2292, 104987, 109118);
            CallChecker.varInit(this.upperDifference, "upperDifference", 2292, 104987, 109118);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 2292, 104987, 109118);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 2292, 104987, 109118);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 2292, 104987, 109118);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 2292, 104987, 109118);
            CallChecker.varInit(this.originShift, "originShift", 2292, 104987, 109118);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 2292, 104987, 109118);
            CallChecker.varInit(this.zMatrix, "zMatrix", 2292, 104987, 109118);
            CallChecker.varInit(this.bMatrix, "bMatrix", 2292, 104987, 109118);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 2292, 104987, 109118);
            CallChecker.varInit(this.boundDifference, "boundDifference", 2292, 104987, 109118);
            CallChecker.varInit(this.currentBest, "currentBest", 2292, 104987, 109118);
            CallChecker.varInit(this.isMinimize, "isMinimize", 2292, 104987, 109118);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 2292, 104987, 109118);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 2292, 104987, 109118);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 2292, 104987, 109118);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2292, 104987, 109118);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 2292, 104987, 109118);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 2292, 104987, 109118);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 2292, 104987, 109118);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 2292, 104987, 109118);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 2292, 104987, 109118);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2292, 104987, 109118);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 2292, 104987, 109118);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 2292, 104987, 109118);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 2292, 104987, 109118);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 2292, 104987, 109118);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 2292, 104987, 109118);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2292, 104987, 109118);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2292, 104987, 109118);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2292, 104987, 109118);
            BOBYQAOptimizer.printMethod();
            currentBest = CallChecker.beforeCalled(currentBest, ArrayRealVector.class, 2299, 105956, 105966);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.currentBest, ArrayRealVector.class, 2299, 105956, 105966).getDimension())), "n", 2299, 105942, 105982);
            final int npt = CallChecker.varInit(((int) (this.numberOfInterpolationPoints)), "npt", 2300, 105992, 106035);
            final int nptm = CallChecker.varInit(((int) ((npt - n) - 1)), "nptm", 2301, 106045, 106073);
            final ArrayRealVector work = CallChecker.varInit(new ArrayRealVector((npt + n)), "work", 2304, 106084, 106198);
            double ztest = CallChecker.varInit(((double) (BOBYQAOptimizer.ZERO)), "ztest", 2306, 106209, 106228);
            for (int k = 0; k < npt; k++) {
                for (int j = 0; j < nptm; j++) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2310, 106397, 106403)) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2310, 106397, 106403);
                        ztest = Math.max(ztest, Math.abs(CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2310, 106397, 106403).getEntry(k, j)));
                        CallChecker.varAssign(ztest, "ztest", 2310, 106364, 106421);
                    }
                }
            }
            ztest *= 1.0E-20;
            CallChecker.varAssign(ztest, "ztest", 2313, 106455, 106469);
            for (int j = 1; j < nptm; j++) {
                zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2318, 106618, 106624);
                final double d1 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2318, 106618, 106624).getEntry(knew, j))), "d1", 2318, 106600, 106643);
                if ((Math.abs(d1)) > ztest) {
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2321, 106758, 106764);
                    final double d2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2321, 106758, 106764).getEntry(knew, 0))), "d2", 2321, 106701, 106783);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2323, 106858, 106864);
                    final double d3 = CallChecker.varInit(((double) (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2323, 106858, 106864).getEntry(knew, j))), "d3", 2323, 106801, 106883);
                    final double d4 = CallChecker.varInit(((double) (Math.sqrt(((d2 * d2) + (d3 * d3))))), "d4", 2324, 106901, 106947);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2325, 106983, 106989);
                    final double d5 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2325, 106983, 106989).getEntry(knew, 0)) / d4)), "d5", 2325, 106965, 107013);
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2326, 107049, 107055);
                    final double d6 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2326, 107049, 107055).getEntry(knew, j)) / d4)), "d6", 2326, 107031, 107079);
                    for (int i = 0; i < npt; i++) {
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2328, 107172, 107178);
                        zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2328, 107202, 107208);
                        final double d7 = CallChecker.varInit(((double) ((d5 * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2328, 107172, 107178).getEntry(i, 0))) + (d6 * (CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2328, 107202, 107208).getEntry(i, j))))), "d7", 2328, 107149, 107224);
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2329, 107274, 107280)) {
                            if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2329, 107304, 107310)) {
                                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2329, 107246, 107252)) {
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107274, 107280);
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107304, 107310);
                                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107246, 107252);
                                    CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107246, 107252).setEntry(i, j, ((d5 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107274, 107280).getEntry(i, j))) - (d6 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2329, 107304, 107310).getEntry(i, 0)))));
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2330, 107349, 107355)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2330, 107349, 107355);
                            CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2330, 107349, 107355).setEntry(i, 0, d7);
                        }
                    }
                }
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2333, 107421, 107427)) {
                    zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2333, 107421, 107427);
                    CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2333, 107421, 107427).setEntry(knew, j, BOBYQAOptimizer.ZERO);
                }
            }
            for (int i = 0; i < npt; i++) {
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2340, 107678, 107684)) {
                    if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2340, 107706, 107712)) {
                        if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2340, 107661, 107664)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2340, 107678, 107684);
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2340, 107706, 107712);
                            CallChecker.isCalled(work, ArrayRealVector.class, 2340, 107661, 107664).setEntry(i, ((CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2340, 107678, 107684).getEntry(knew, 0)) * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2340, 107706, 107712).getEntry(i, 0))));
                        }
                    }
                }
            }
            final double alpha = CallChecker.varInit(((double) (CallChecker.isCalled(work, ArrayRealVector.class, 2342, 107770, 107773).getEntry(knew))), "alpha", 2342, 107749, 107789);
            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2343, 107818, 107841);
            final double tau = CallChecker.varInit(((double) (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2343, 107818, 107841).getEntry(knew))), "tau", 2343, 107799, 107857);
            if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107907, 107930)) {
                if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107867, 107890)) {
                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107907, 107930);
                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107867, 107890);
                    CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107867, 107890).setEntry(knew, ((CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2344, 107907, 107930).getEntry(knew)) - (BOBYQAOptimizer.ONE)));
                }
            }
            final double sqrtDenom = CallChecker.varInit(((double) (Math.sqrt(denom))), "sqrtDenom", 2348, 107964, 108048);
            final double d1 = CallChecker.varInit(((double) (tau / sqrtDenom)), "d1", 2349, 108058, 108091);
            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2350, 108119, 108125);
            final double d2 = CallChecker.varInit(((double) ((CallChecker.isCalled(this.zMatrix, Array2DRowRealMatrix.class, 2350, 108119, 108125).getEntry(knew, 0)) / sqrtDenom)), "d2", 2350, 108101, 108156);
            for (int i = 0; i < npt; i++) {
                if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2353, 108264, 108270)) {
                    if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2353, 108294, 108317)) {
                        if (CallChecker.beforeDeref(zMatrix, Array2DRowRealMatrix.class, 2352, 108210, 108216)) {
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2353, 108264, 108270);
                            lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2353, 108294, 108317);
                            zMatrix = CallChecker.beforeCalled(zMatrix, Array2DRowRealMatrix.class, 2352, 108210, 108216);
                            CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2352, 108210, 108216).setEntry(i, 0, ((d1 * (CallChecker.isCalled(zMatrix, Array2DRowRealMatrix.class, 2353, 108264, 108270).getEntry(i, 0))) - (d2 * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2353, 108294, 108317).getEntry(i)))));
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                final int jp = CallChecker.varInit(((int) (npt + j)), "jp", 2359, 108439, 108461);
                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2360, 108493, 108499)) {
                    if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2360, 108475, 108478)) {
                        bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2360, 108493, 108499);
                        CallChecker.isCalled(work, ArrayRealVector.class, 2360, 108475, 108478).setEntry(jp, CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2360, 108493, 108499).getEntry(knew, j));
                    }
                }
                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2361, 108560, 108583);
                final double d3 = CallChecker.varInit(((double) (((alpha * (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2361, 108560, 108583).getEntry(jp))) - (tau * (CallChecker.isCalled(work, ArrayRealVector.class, 2361, 108606, 108609).getEntry(jp)))) / denom)), "d3", 2361, 108533, 108632);
                lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2362, 108699, 108722);
                final double d4 = CallChecker.varInit(((double) ((((-beta) * (CallChecker.isCalled(work, ArrayRealVector.class, 2362, 108673, 108676).getEntry(jp))) - (tau * (CallChecker.isCalled(this.lagrangeValuesAtNewPoint, ArrayRealVector.class, 2362, 108699, 108722).getEntry(jp)))) / denom)), "d4", 2362, 108646, 108745);
                for (int i = 0; i <= jp; i++) {
                    if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2365, 108860, 108866)) {
                        if (CallChecker.beforeDeref(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2365, 108890, 108913)) {
                            if (CallChecker.beforeDeref(work, ArrayRealVector.class, 2365, 108934, 108937)) {
                                if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2364, 108807, 108813)) {
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2365, 108860, 108866);
                                    lagrangeValuesAtNewPoint = CallChecker.beforeCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2365, 108890, 108913);
                                    bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2364, 108807, 108813);
                                    CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2364, 108807, 108813).setEntry(i, j, (((CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2365, 108860, 108866).getEntry(i, j)) + (d3 * (CallChecker.isCalled(lagrangeValuesAtNewPoint, ArrayRealVector.class, 2365, 108890, 108913).getEntry(i)))) + (d4 * (CallChecker.isCalled(work, ArrayRealVector.class, 2365, 108934, 108937).getEntry(i)))));
                                }
                            }
                        }
                    }
                    if (i >= npt) {
                        if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2367, 109037, 109043)) {
                            if (CallChecker.beforeDeref(bMatrix, Array2DRowRealMatrix.class, 2367, 109005, 109011)) {
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2367, 109037, 109043);
                                bMatrix = CallChecker.beforeCalled(bMatrix, Array2DRowRealMatrix.class, 2367, 109005, 109011);
                                CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2367, 109005, 109011).setEntry(jp, (i - npt), CallChecker.isCalled(bMatrix, Array2DRowRealMatrix.class, 2367, 109037, 109043).getEntry(i, j));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4538.methodEnd();
        }
    }

    private void setup(double[] lowerBound, double[] upperBound) {
        MethodContext _bcornu_methode_context4539 = new MethodContext(void.class, 2379, 109125, 112168);
        try {
            CallChecker.varInit(this, "this", 2379, 109125, 112168);
            CallChecker.varInit(upperBound, "upperBound", 2379, 109125, 112168);
            CallChecker.varInit(lowerBound, "lowerBound", 2379, 109125, 112168);
            CallChecker.varInit(this.evaluations, "evaluations", 2379, 109125, 112168);
            CallChecker.varInit(this.modelSecondDerivativesValues, "modelSecondDerivativesValues", 2379, 109125, 112168);
            CallChecker.varInit(this.lagrangeValuesAtNewPoint, "lagrangeValuesAtNewPoint", 2379, 109125, 112168);
            CallChecker.varInit(this.trialStepPoint, "trialStepPoint", 2379, 109125, 112168);
            CallChecker.varInit(this.alternativeNewPoint, "alternativeNewPoint", 2379, 109125, 112168);
            CallChecker.varInit(this.newPoint, "newPoint", 2379, 109125, 112168);
            CallChecker.varInit(this.modelSecondDerivativesParameters, "modelSecondDerivativesParameters", 2379, 109125, 112168);
            CallChecker.varInit(this.upperDifference, "upperDifference", 2379, 109125, 112168);
            CallChecker.varInit(this.lowerDifference, "lowerDifference", 2379, 109125, 112168);
            CallChecker.varInit(this.gradientAtTrustRegionCenter, "gradientAtTrustRegionCenter", 2379, 109125, 112168);
            CallChecker.varInit(this.trustRegionCenterOffset, "trustRegionCenterOffset", 2379, 109125, 112168);
            CallChecker.varInit(this.fAtInterpolationPoints, "fAtInterpolationPoints", 2379, 109125, 112168);
            CallChecker.varInit(this.originShift, "originShift", 2379, 109125, 112168);
            CallChecker.varInit(this.interpolationPoints, "interpolationPoints", 2379, 109125, 112168);
            CallChecker.varInit(this.zMatrix, "zMatrix", 2379, 109125, 112168);
            CallChecker.varInit(this.bMatrix, "bMatrix", 2379, 109125, 112168);
            CallChecker.varInit(this.trustRegionCenterInterpolationPointIndex, "trustRegionCenterInterpolationPointIndex", 2379, 109125, 112168);
            CallChecker.varInit(this.boundDifference, "boundDifference", 2379, 109125, 112168);
            CallChecker.varInit(this.currentBest, "currentBest", 2379, 109125, 112168);
            CallChecker.varInit(this.isMinimize, "isMinimize", 2379, 109125, 112168);
            CallChecker.varInit(this.stoppingTrustRegionRadius, "stoppingTrustRegionRadius", 2379, 109125, 112168);
            CallChecker.varInit(this.initialTrustRegionRadius, "initialTrustRegionRadius", 2379, 109125, 112168);
            CallChecker.varInit(this.numberOfInterpolationPoints, "numberOfInterpolationPoints", 2379, 109125, 112168);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2379, 109125, 112168);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 2379, 109125, 112168);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 2379, 109125, 112168);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 2379, 109125, 112168);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 2379, 109125, 112168);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 2379, 109125, 112168);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2379, 109125, 112168);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 2379, 109125, 112168);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 2379, 109125, 112168);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 2379, 109125, 112168);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 2379, 109125, 112168);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 2379, 109125, 112168);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2379, 109125, 112168);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2379, 109125, 112168);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2379, 109125, 112168);
            BOBYQAOptimizer.printMethod();
            double[] init = CallChecker.varInit(getStartPoint(), "init", 2383, 109468, 109499);
            init = CallChecker.beforeCalled(init, double[].class, 2384, 109531, 109534);
            final int dimension = CallChecker.varInit(((int) (CallChecker.isCalled(init, double[].class, 2384, 109531, 109534).length)), "dimension", 2384, 109509, 109542);
            if (dimension < (BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION)) {
                throw new NumberIsTooSmallException(dimension, BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION, true);
            }
            final int[] nPointsInterval = CallChecker.varInit(new int[]{ dimension + 2 , ((dimension + 2) * (dimension + 1)) / 2 }, "nPointsInterval", 2391, 109794, 109880);
            if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2392, 109924, 109938)) {
                if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2393, 109988, 110002)) {
                    if (((numberOfInterpolationPoints) < (CallChecker.isCalled(nPointsInterval, int[].class, 2392, 109924, 109938)[0])) || ((numberOfInterpolationPoints) > (CallChecker.isCalled(nPointsInterval, int[].class, 2393, 109988, 110002)[1]))) {
                        if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2396, 110214, 110228)) {
                            if (CallChecker.beforeDeref(nPointsInterval, int[].class, 2397, 110276, 110290)) {
                                throw new OutOfRangeException(LocalizedFormats.NUMBER_OF_INTERPOLATION_POINTS, numberOfInterpolationPoints, CallChecker.isCalled(nPointsInterval, int[].class, 2396, 110214, 110228)[0], CallChecker.isCalled(nPointsInterval, int[].class, 2397, 110276, 110290)[1]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            boundDifference = new double[dimension];
            CallChecker.varAssign(this.boundDifference, "this.boundDifference", 2401, 110357, 110396);
            double requiredMinDiff = CallChecker.varInit(((double) (2 * (this.initialTrustRegionRadius))), "requiredMinDiff", 2403, 110407, 110460);
            double minDiff = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "minDiff", 2404, 110470, 110511);
            for (int i = 0; i < dimension; i++) {
                if (CallChecker.beforeDeref(boundDifference, double[].class, 2406, 110571, 110585)) {
                    if (CallChecker.beforeDeref(upperBound, double[].class, 2406, 110592, 110601)) {
                        if (CallChecker.beforeDeref(lowerBound, double[].class, 2406, 110608, 110617)) {
                            boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 2406, 110571, 110585);
                            upperBound = CallChecker.beforeCalled(upperBound, double[].class, 2406, 110592, 110601);
                            lowerBound = CallChecker.beforeCalled(lowerBound, double[].class, 2406, 110608, 110617);
                            CallChecker.isCalled(boundDifference, double[].class, 2406, 110571, 110585)[i] = (CallChecker.isCalled(upperBound, double[].class, 2406, 110592, 110601)[i]) - (CallChecker.isCalled(lowerBound, double[].class, 2406, 110608, 110617)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.boundDifference, double[].class, 2406, 110571, 110585)[i], "CallChecker.isCalled(this.boundDifference, double[].class, 2406, 110571, 110585)[i]", 2406, 110571, 110621);
                        }
                    }
                }
                if (CallChecker.beforeDeref(boundDifference, double[].class, 2407, 110663, 110677)) {
                    boundDifference = CallChecker.beforeCalled(boundDifference, double[].class, 2407, 110663, 110677);
                    minDiff = Math.min(minDiff, CallChecker.isCalled(boundDifference, double[].class, 2407, 110663, 110677)[i]);
                    CallChecker.varAssign(minDiff, "minDiff", 2407, 110635, 110682);
                }
            }
            if (minDiff < requiredMinDiff) {
                initialTrustRegionRadius = minDiff / 3.0;
                CallChecker.varAssign(this.initialTrustRegionRadius, "this.initialTrustRegionRadius", 2410, 110747, 110787);
            }
            bMatrix = new Array2DRowRealMatrix((dimension + (numberOfInterpolationPoints)), dimension);
            CallChecker.varAssign(this.bMatrix, "this.bMatrix", 2414, 110879, 111008);
            zMatrix = new Array2DRowRealMatrix(numberOfInterpolationPoints, (((numberOfInterpolationPoints) - dimension) - 1));
            CallChecker.varAssign(this.zMatrix, "this.zMatrix", 2416, 111018, 111169);
            interpolationPoints = new Array2DRowRealMatrix(numberOfInterpolationPoints, dimension);
            CallChecker.varAssign(this.interpolationPoints, "this.interpolationPoints", 2418, 111179, 111320);
            originShift = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.originShift, "this.originShift", 2420, 111330, 111374);
            fAtInterpolationPoints = new ArrayRealVector(numberOfInterpolationPoints);
            CallChecker.varAssign(this.fAtInterpolationPoints, "this.fAtInterpolationPoints", 2421, 111384, 111457);
            trustRegionCenterOffset = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.trustRegionCenterOffset, "this.trustRegionCenterOffset", 2422, 111467, 111523);
            gradientAtTrustRegionCenter = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.gradientAtTrustRegionCenter, "this.gradientAtTrustRegionCenter", 2423, 111533, 111593);
            lowerDifference = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.lowerDifference, "this.lowerDifference", 2424, 111603, 111651);
            upperDifference = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.upperDifference, "this.upperDifference", 2425, 111661, 111709);
            modelSecondDerivativesParameters = new ArrayRealVector(numberOfInterpolationPoints);
            CallChecker.varAssign(this.modelSecondDerivativesParameters, "this.modelSecondDerivativesParameters", 2426, 111719, 111802);
            newPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.newPoint, "this.newPoint", 2427, 111812, 111853);
            alternativeNewPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.alternativeNewPoint, "this.alternativeNewPoint", 2428, 111863, 111915);
            trialStepPoint = new ArrayRealVector(dimension);
            CallChecker.varAssign(this.trialStepPoint, "this.trialStepPoint", 2429, 111925, 111972);
            lagrangeValuesAtNewPoint = new ArrayRealVector((dimension + (numberOfInterpolationPoints)));
            CallChecker.varAssign(this.lagrangeValuesAtNewPoint, "this.lagrangeValuesAtNewPoint", 2430, 111982, 112069);
            modelSecondDerivativesValues = new ArrayRealVector(((dimension * (dimension + 1)) / 2));
            CallChecker.varAssign(this.modelSecondDerivativesValues, "this.modelSecondDerivativesValues", 2431, 112079, 112162);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4539.methodEnd();
        }
    }

    private static String caller(int n) {
        MethodContext _bcornu_methode_context4540 = new MethodContext(String.class, 2435, 112175, 112501);
        try {
            CallChecker.varInit(n, "n", 2435, 112175, 112501);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2435, 112175, 112501);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 2435, 112175, 112501);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 2435, 112175, 112501);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 2435, 112175, 112501);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 2435, 112175, 112501);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 2435, 112175, 112501);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2435, 112175, 112501);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 2435, 112175, 112501);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 2435, 112175, 112501);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 2435, 112175, 112501);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 2435, 112175, 112501);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 2435, 112175, 112501);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2435, 112175, 112501);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2435, 112175, 112501);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2435, 112175, 112501);
            final Throwable t = CallChecker.varInit(new Throwable(), "t", 2436, 112272, 112307);
            final StackTraceElement[] elements = CallChecker.varInit(CallChecker.isCalled(t, Throwable.class, 2437, 112354, 112354).getStackTrace(), "elements", 2437, 112317, 112371);
            final StackTraceElement e = CallChecker.varInit(CallChecker.isCalled(elements, StackTraceElement[].class, 2438, 112409, 112416)[n], "e", 2438, 112381, 112420);
            return (((CallChecker.isCalled(e, StackTraceElement.class, 2439, 112437, 112437).getMethodName()) + " (at line ") + (CallChecker.isCalled(e, StackTraceElement.class, 2439, 112472, 112472).getLineNumber())) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4540.methodEnd();
        }
    }

    private static void printState(int s) {
        MethodContext _bcornu_methode_context4541 = new MethodContext(void.class, 2442, 112507, 112668);
        try {
            CallChecker.varInit(s, "s", 2442, 112507, 112668);
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2442, 112507, 112668);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 2442, 112507, 112668);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 2442, 112507, 112668);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 2442, 112507, 112668);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 2442, 112507, 112668);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 2442, 112507, 112668);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2442, 112507, 112668);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 2442, 112507, 112668);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 2442, 112507, 112668);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 2442, 112507, 112668);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 2442, 112507, 112668);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 2442, 112507, 112668);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2442, 112507, 112668);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2442, 112507, 112668);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2442, 112507, 112668);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4541.methodEnd();
        }
    }

    private static void printMethod() {
        MethodContext _bcornu_methode_context4542 = new MethodContext(void.class, 2446, 112674, 112814);
        try {
            CallChecker.varInit(ONE_OVER_A_THOUSAND, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_A_THOUSAND", 2446, 112674, 112814);
            CallChecker.varInit(ONE_OVER_TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_TEN", 2446, 112674, 112814);
            CallChecker.varInit(ONE_OVER_EIGHT, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_EIGHT", 2446, 112674, 112814);
            CallChecker.varInit(ONE_OVER_FOUR, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE_OVER_FOUR", 2446, 112674, 112814);
            CallChecker.varInit(HALF, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.HALF", 2446, 112674, 112814);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINUS_ONE", 2446, 112674, 112814);
            CallChecker.varInit(TWO_HUNDRED_FIFTY, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO_HUNDRED_FIFTY", 2446, 112674, 112814);
            CallChecker.varInit(SIXTEEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.SIXTEEN", 2446, 112674, 112814);
            CallChecker.varInit(TEN, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TEN", 2446, 112674, 112814);
            CallChecker.varInit(TWO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.TWO", 2446, 112674, 112814);
            CallChecker.varInit(ONE, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ONE", 2446, 112674, 112814);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.ZERO", 2446, 112674, 112814);
            CallChecker.varInit(DEFAULT_STOPPING_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_STOPPING_RADIUS", 2446, 112674, 112814);
            CallChecker.varInit(DEFAULT_INITIAL_RADIUS, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.DEFAULT_INITIAL_RADIUS", 2446, 112674, 112814);
            CallChecker.varInit(MINIMUM_PROBLEM_DIMENSION, "org.apache.commons.math3.optimization.direct.BOBYQAOptimizer.MINIMUM_PROBLEM_DIMENSION", 2446, 112674, 112814);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4542.methodEnd();
        }
    }
}

