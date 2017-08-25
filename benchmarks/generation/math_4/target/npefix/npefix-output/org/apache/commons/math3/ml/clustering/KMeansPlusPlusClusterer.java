package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

public class KMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    public static enum EmptyClusterStrategy {
LARGEST_VARIANCE, LARGEST_POINTS_NUMBER, FARTHEST_POINT, ERROR;    }

    private final int k;

    private final int maxIterations;

    private final RandomGenerator random;

    private final KMeansPlusPlusClusterer.EmptyClusterStrategy emptyStrategy;

    public KMeansPlusPlusClusterer(final int k) {
        this(k, (-1));
        ConstructorContext _bcornu_methode_context374 = new ConstructorContext(KMeansPlusPlusClusterer.class, 83, 2740, 3172);
        try {
        } finally {
            _bcornu_methode_context374.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer(final int k, final int maxIterations) {
        this(k, maxIterations, new EuclideanDistance());
        ConstructorContext _bcornu_methode_context375 = new ConstructorContext(KMeansPlusPlusClusterer.class, 98, 3179, 3806);
        try {
        } finally {
            _bcornu_methode_context375.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer(final int k, final int maxIterations, final DistanceMeasure measure) {
        this(k, maxIterations, measure, new JDKRandomGenerator());
        ConstructorContext _bcornu_methode_context376 = new ConstructorContext(KMeansPlusPlusClusterer.class, 112, 3813, 4448);
        try {
        } finally {
            _bcornu_methode_context376.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer(final int k, final int maxIterations, final DistanceMeasure measure, final RandomGenerator random) {
        this(k, maxIterations, measure, random, KMeansPlusPlusClusterer.EmptyClusterStrategy.LARGEST_VARIANCE);
        ConstructorContext _bcornu_methode_context377 = new ConstructorContext(KMeansPlusPlusClusterer.class, 127, 4455, 5285);
        try {
        } finally {
            _bcornu_methode_context377.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer(final int k, final int maxIterations, final DistanceMeasure measure, final RandomGenerator random, final KMeansPlusPlusClusterer.EmptyClusterStrategy emptyStrategy) {
        super(measure);
        ConstructorContext _bcornu_methode_context378 = new ConstructorContext(KMeansPlusPlusClusterer.class, 143, 5292, 6241);
        try {
            this.k = k;
            CallChecker.varAssign(this.k, "this.k", 148, 6088, 6110);
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 149, 6120, 6154);
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 150, 6164, 6191);
            this.emptyStrategy = emptyStrategy;
            CallChecker.varAssign(this.emptyStrategy, "this.emptyStrategy", 151, 6201, 6235);
        } finally {
            _bcornu_methode_context378.methodEnd();
        }
    }

    public int getK() {
        MethodContext _bcornu_methode_context1636 = new MethodContext(int.class, 158, 6248, 6405);
        try {
            CallChecker.varInit(this, "this", 158, 6248, 6405);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 158, 6248, 6405);
            CallChecker.varInit(this.random, "random", 158, 6248, 6405);
            CallChecker.varInit(this.maxIterations, "maxIterations", 158, 6248, 6405);
            CallChecker.varInit(this.k, "k", 158, 6248, 6405);
            return k;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1636.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context1637 = new MethodContext(int.class, 166, 6412, 6642);
        try {
            CallChecker.varInit(this, "this", 166, 6412, 6642);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 166, 6412, 6642);
            CallChecker.varInit(this.random, "random", 166, 6412, 6642);
            CallChecker.varInit(this.maxIterations, "maxIterations", 166, 6412, 6642);
            CallChecker.varInit(this.k, "k", 166, 6412, 6642);
            return maxIterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1637.methodEnd();
        }
    }

    public RandomGenerator getRandomGenerator() {
        MethodContext _bcornu_methode_context1638 = new MethodContext(RandomGenerator.class, 174, 6649, 6834);
        try {
            CallChecker.varInit(this, "this", 174, 6649, 6834);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 174, 6649, 6834);
            CallChecker.varInit(this.random, "random", 174, 6649, 6834);
            CallChecker.varInit(this.maxIterations, "maxIterations", 174, 6649, 6834);
            CallChecker.varInit(this.k, "k", 174, 6649, 6834);
            return random;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RandomGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1638.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer.EmptyClusterStrategy getEmptyClusterStrategy() {
        MethodContext _bcornu_methode_context1639 = new MethodContext(KMeansPlusPlusClusterer.EmptyClusterStrategy.class, 182, 6841, 7066);
        try {
            CallChecker.varInit(this, "this", 182, 6841, 7066);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 182, 6841, 7066);
            CallChecker.varInit(this.random, "random", 182, 6841, 7066);
            CallChecker.varInit(this.maxIterations, "maxIterations", 182, 6841, 7066);
            CallChecker.varInit(this.k, "k", 182, 6841, 7066);
            return emptyStrategy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((KMeansPlusPlusClusterer.EmptyClusterStrategy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1639.methodEnd();
        }
    }

    public List<CentroidCluster<T>> cluster(final Collection<T> points) throws ConvergenceException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1640 = new MethodContext(List.class, 196, 7073, 10206);
        try {
            CallChecker.varInit(this, "this", 196, 7073, 10206);
            CallChecker.varInit(points, "points", 196, 7073, 10206);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 196, 7073, 10206);
            CallChecker.varInit(this.random, "random", 196, 7073, 10206);
            CallChecker.varInit(this.maxIterations, "maxIterations", 196, 7073, 10206);
            CallChecker.varInit(this.k, "k", 196, 7073, 10206);
            MathUtils.checkNotNull(points);
            if (CallChecker.beforeDeref(points, Collection.class, 203, 7824, 7829)) {
                if ((CallChecker.isCalled(points, Collection.class, 203, 7824, 7829).size()) < (k)) {
                    if (CallChecker.beforeDeref(points, Collection.class, 204, 7893, 7898)) {
                        throw new NumberIsTooSmallException(CallChecker.isCalled(points, Collection.class, 204, 7893, 7898).size(), k, false);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            List<CentroidCluster<T>> clusters = CallChecker.varInit(chooseInitialCenters(points), "clusters", 208, 7977, 8041);
            int[] assignments = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(points, Collection.class, 212, 8255, 8260)) {
                assignments = new int[CallChecker.isCalled(points, Collection.class, 212, 8255, 8260).size()];
                CallChecker.varAssign(assignments, "assignments", 212, 8255, 8260);
            }
            assignPointsToClusters(clusters, points, assignments);
            int max = CallChecker.init(int.class);
            if ((maxIterations) < 0) {
                max = Integer.MAX_VALUE;
                CallChecker.varAssign(max, "max", 216, 8424, 8478);
            }else {
                max = maxIterations;
                CallChecker.varAssign(max, "max", 216, 8424, 8478);
            }
            for (int count = 0; count < max; count++) {
                boolean emptyCluster = CallChecker.varInit(((boolean) (false)), "emptyCluster", 218, 8545, 8573);
                List<CentroidCluster<T>> newClusters = CallChecker.varInit(new ArrayList<CentroidCluster<T>>(), "newClusters", 219, 8587, 8661);
                if (CallChecker.beforeDeref(clusters, List.class, 220, 8715, 8722)) {
                    for (final CentroidCluster<T> cluster : clusters) {
                        Clusterable newCenter = CallChecker.init(Clusterable.class);
                        if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 222, 8792, 8798)) {
                            final List<T> npe_invocation_var146 = CallChecker.isCalled(cluster, CentroidCluster.class, 222, 8792, 8798).getPoints();
                            if (CallChecker.beforeDeref(npe_invocation_var146, List.class, 222, 8792, 8810)) {
                                if (CallChecker.isCalled(npe_invocation_var146, List.class, 222, 8792, 8810).isEmpty()) {
                                    switch (emptyStrategy) {
                                        case LARGEST_VARIANCE :
                                            newCenter = getPointFromLargestVarianceCluster(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 225, 8946, 9002);
                                            break;
                                        case LARGEST_POINTS_NUMBER :
                                            newCenter = getPointFromLargestNumberCluster(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 228, 9120, 9174);
                                            break;
                                        case FARTHEST_POINT :
                                            newCenter = getFarthestPoint(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 231, 9285, 9323);
                                            break;
                                        default :
                                            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
                                    }
                                    emptyCluster = true;
                                    CallChecker.varAssign(emptyCluster, "emptyCluster", 236, 9539, 9558);
                                }else {
                                    if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 238, 9628, 9634)) {
                                        if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 238, 9649, 9655)) {
                                            final Clusterable npe_invocation_var147 = CallChecker.isCalled(cluster, CentroidCluster.class, 238, 9649, 9655).getCenter();
                                            if (CallChecker.beforeDeref(npe_invocation_var147, Clusterable.class, 238, 9649, 9667)) {
                                                final double[] npe_invocation_var148 = CallChecker.isCalled(npe_invocation_var147, Clusterable.class, 238, 9649, 9667).getPoint();
                                                if (CallChecker.beforeDeref(npe_invocation_var148, double[].class, 238, 9649, 9678)) {
                                                    newCenter = centroidOf(CallChecker.isCalled(cluster, CentroidCluster.class, 238, 9628, 9634).getPoints(), CallChecker.isCalled(npe_invocation_var148, double[].class, 238, 9649, 9678).length);
                                                    CallChecker.varAssign(newCenter, "newCenter", 238, 9605, 9687);
                                                }
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(newClusters, List.class, 240, 9723, 9733)) {
                            newClusters = CallChecker.beforeCalled(newClusters, List.class, 240, 9723, 9733);
                            CallChecker.isCalled(newClusters, List.class, 240, 9723, 9733).add(new CentroidCluster<T>(newCenter));
                        }
                    }
                }
                int changes = CallChecker.varInit(((int) (assignPointsToClusters(newClusters, points, assignments))), "changes", 242, 9801, 9871);
                clusters = newClusters;
                CallChecker.varAssign(clusters, "clusters", 243, 9885, 9907);
                if ((changes == 0) && (!emptyCluster)) {
                    return clusters;
                }
            }
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<CentroidCluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1640.methodEnd();
        }
    }

    private int assignPointsToClusters(final List<CentroidCluster<T>> clusters, final Collection<T> points, final int[] assignments) {
        MethodContext _bcornu_methode_context1641 = new MethodContext(int.class, 262, 10213, 11271);
        try {
            CallChecker.varInit(this, "this", 262, 10213, 11271);
            CallChecker.varInit(assignments, "assignments", 262, 10213, 11271);
            CallChecker.varInit(points, "points", 262, 10213, 11271);
            CallChecker.varInit(clusters, "clusters", 262, 10213, 11271);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 262, 10213, 11271);
            CallChecker.varInit(this.random, "random", 262, 10213, 11271);
            CallChecker.varInit(this.maxIterations, "maxIterations", 262, 10213, 11271);
            CallChecker.varInit(this.k, "k", 262, 10213, 11271);
            int assignedDifferently = CallChecker.varInit(((int) (0)), "assignedDifferently", 265, 10796, 10823);
            int pointIndex = CallChecker.varInit(((int) (0)), "pointIndex", 266, 10833, 10851);
            if (CallChecker.beforeDeref(points, int.class, 267, 10878, 10883)) {
                for (final T p : points) {
                    int clusterIndex = CallChecker.varInit(((int) (getNearestCluster(clusters, p))), "clusterIndex", 268, 10900, 10949);
                    if (CallChecker.beforeDeref(assignments, int[].class, 269, 10983, 10993)) {
                        if (clusterIndex != (CallChecker.isCalled(assignments, int[].class, 269, 10983, 10993)[pointIndex])) {
                            assignedDifferently++;
                        }
                    }
                    CentroidCluster<T> cluster = CallChecker.init(CentroidCluster.class);
                    if (CallChecker.beforeDeref(clusters, List.class, 273, 11105, 11112)) {
                        cluster = CallChecker.isCalled(clusters, List.class, 273, 11105, 11112).get(clusterIndex);
                        CallChecker.varAssign(cluster, "cluster", 273, 11105, 11112);
                    }
                    if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 274, 11145, 11151)) {
                        cluster = CallChecker.beforeCalled(cluster, CentroidCluster.class, 274, 11145, 11151);
                        CallChecker.isCalled(cluster, CentroidCluster.class, 274, 11145, 11151).addPoint(p);
                    }
                    if (CallChecker.beforeDeref(assignments, int[].class, 275, 11178, 11188)) {
                        CallChecker.isCalled(assignments, int[].class, 275, 11178, 11188)[(pointIndex++)] = clusterIndex;
                        CallChecker.varAssign(CallChecker.isCalled(assignments, int[].class, 275, 11178, 11188)[(pointIndex - 1)], "CallChecker.isCalled(assignments, int[].class, 275, 11178, 11188)[(pointIndex - 1)]", 275, 11178, 11218);
                    }
                }
            }
            return assignedDifferently;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1641.methodEnd();
        }
    }

    private List<CentroidCluster<T>> chooseInitialCenters(final Collection<T> points) {
        MethodContext _bcornu_methode_context1642 = new MethodContext(List.class, 287, 11278, 15830);
        try {
            CallChecker.varInit(this, "this", 287, 11278, 15830);
            CallChecker.varInit(points, "points", 287, 11278, 15830);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 287, 11278, 15830);
            CallChecker.varInit(this.random, "random", 287, 11278, 15830);
            CallChecker.varInit(this.maxIterations, "maxIterations", 287, 11278, 15830);
            CallChecker.varInit(this.k, "k", 287, 11278, 15830);
            final List<T> pointList = CallChecker.varInit(Collections.unmodifiableList(new ArrayList<T>(points)), "pointList", 291, 11548, 11773);
            final int numPoints = CallChecker.varInit(((int) (CallChecker.isCalled(pointList, List.class, 294, 11851, 11859).size())), "numPoints", 294, 11784, 11867);
            final boolean[] taken = CallChecker.varInit(new boolean[numPoints], "taken", 298, 12008, 12054);
            final List<CentroidCluster<T>> resultSet = CallChecker.varInit(new ArrayList<CentroidCluster<T>>(), "resultSet", 301, 12065, 12193);
            final int firstPointIndex = CallChecker.varInit(((int) (CallChecker.isCalled(this.random, RandomGenerator.class, 304, 12309, 12314).nextInt(numPoints))), "firstPointIndex", 304, 12204, 12334);
            final T firstPoint = CallChecker.varInit(pointList.get(firstPointIndex), "firstPoint", 306, 12345, 12396);
            if (CallChecker.beforeDeref(resultSet, List.class, 308, 12407, 12415)) {
                CallChecker.isCalled(resultSet, List.class, 308, 12407, 12415).add(new CentroidCluster<T>(firstPoint));
            }
            if (CallChecker.beforeDeref(taken, boolean[].class, 311, 12500, 12504)) {
                CallChecker.isCalled(taken, boolean[].class, 311, 12500, 12504)[firstPointIndex] = true;
                CallChecker.varAssign(CallChecker.isCalled(taken, boolean[].class, 311, 12500, 12504)[firstPointIndex], "CallChecker.isCalled(taken, boolean[].class, 311, 12500, 12504)[firstPointIndex]", 311, 12500, 12529);
            }
            final double[] minDistSquared = CallChecker.varInit(new double[numPoints], "minDistSquared", 315, 12659, 12712);
            for (int i = 0; i < numPoints; i++) {
                if (i != firstPointIndex) {
                    double d = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(pointList, List.class, 321, 12996, 13004)) {
                        d = distance(firstPoint, pointList.get(i));
                        CallChecker.varAssign(d, "d", 321, 12996, 13004);
                    }
                    if (CallChecker.beforeDeref(minDistSquared, double[].class, 322, 13031, 13044)) {
                        CallChecker.isCalled(minDistSquared, double[].class, 322, 13031, 13044)[i] = d * d;
                        CallChecker.varAssign(CallChecker.isCalled(minDistSquared, double[].class, 322, 13031, 13044)[i], "CallChecker.isCalled(minDistSquared, double[].class, 322, 13031, 13044)[i]", 322, 13031, 13054);
                    }
                }
            }
            while ((CallChecker.isCalled(resultSet, List.class, 326, 13096, 13104).size()) < (k)) {
                double distSqSum = CallChecker.varInit(((double) (0.0)), "distSqSum", 330, 13239, 13261);
                for (int i = 0; i < numPoints; i++) {
                    if (CallChecker.beforeDeref(taken, boolean[].class, 333, 13335, 13339)) {
                        if (!(CallChecker.isCalled(taken, boolean[].class, 333, 13335, 13339)[i])) {
                            if (CallChecker.beforeDeref(minDistSquared, double[].class, 334, 13380, 13393)) {
                                distSqSum += CallChecker.isCalled(minDistSquared, double[].class, 334, 13380, 13393)[i];
                                CallChecker.varAssign(distSqSum, "distSqSum", 334, 13367, 13397);
                            }
                        }
                    }
                }
                final double r = CallChecker.varInit(((double) ((CallChecker.isCalled(this.random, RandomGenerator.class, 340, 13589, 13594).nextDouble()) * distSqSum)), "r", 340, 13444, 13620);
                int nextPointIndex = CallChecker.varInit(((int) (-1)), "nextPointIndex", 343, 13708, 13731);
                double sum = CallChecker.varInit(((double) (0.0)), "sum", 347, 13845, 13861);
                for (int i = 0; i < numPoints; i++) {
                    if (CallChecker.beforeDeref(taken, boolean[].class, 349, 13934, 13938)) {
                        if (!(CallChecker.isCalled(taken, boolean[].class, 349, 13934, 13938)[i])) {
                            if (CallChecker.beforeDeref(minDistSquared, double[].class, 350, 13973, 13986)) {
                                sum += CallChecker.isCalled(minDistSquared, double[].class, 350, 13973, 13986)[i];
                                CallChecker.varAssign(sum, "sum", 350, 13966, 13990);
                            }
                            if (sum >= r) {
                                nextPointIndex = i;
                                CallChecker.varAssign(nextPointIndex, "nextPointIndex", 352, 14052, 14070);
                                break;
                            }
                        }
                    }
                }
                if (nextPointIndex == (-1)) {
                    for (int i = numPoints - 1; i >= 0; i--) {
                        if (CallChecker.beforeDeref(taken, boolean[].class, 363, 14486, 14490)) {
                            if (!(CallChecker.isCalled(taken, boolean[].class, 363, 14486, 14490)[i])) {
                                nextPointIndex = i;
                                CallChecker.varAssign(nextPointIndex, "nextPointIndex", 364, 14522, 14540);
                                break;
                            }
                        }
                    }
                }
                if (nextPointIndex >= 0) {
                    final T p = CallChecker.varInit(pointList.get(nextPointIndex), "p", 373, 14713, 14754);
                    if (CallChecker.beforeDeref(resultSet, List.class, 375, 14773, 14781)) {
                        CallChecker.isCalled(resultSet, List.class, 375, 14773, 14781).add(new CentroidCluster<T>(p));
                    }
                    if (CallChecker.beforeDeref(taken, boolean[].class, 378, 14870, 14874)) {
                        CallChecker.isCalled(taken, boolean[].class, 378, 14870, 14874)[nextPointIndex] = true;
                        CallChecker.varAssign(CallChecker.isCalled(taken, boolean[].class, 378, 14870, 14874)[nextPointIndex], "CallChecker.isCalled(taken, boolean[].class, 378, 14870, 14874)[nextPointIndex]", 378, 14870, 14898);
                    }
                    if (CallChecker.beforeDeref(resultSet, List.class, 380, 14921, 14929)) {
                        if ((CallChecker.isCalled(resultSet, List.class, 380, 14921, 14929).size()) < (k)) {
                            for (int j = 0; j < numPoints; j++) {
                                if (CallChecker.beforeDeref(taken, boolean[].class, 385, 15265, 15269)) {
                                    if (!(CallChecker.isCalled(taken, boolean[].class, 385, 15265, 15269)[j])) {
                                        double d = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(pointList, List.class, 386, 15328, 15336)) {
                                            d = distance(p, pointList.get(j));
                                            CallChecker.varAssign(d, "d", 386, 15328, 15336);
                                        }
                                        double d2 = CallChecker.varInit(((double) (d * d)), "d2", 387, 15375, 15392);
                                        if (CallChecker.beforeDeref(minDistSquared, double[].class, 388, 15431, 15444)) {
                                            if (d2 < (CallChecker.isCalled(minDistSquared, double[].class, 388, 15431, 15444)[j])) {
                                                if (CallChecker.beforeDeref(minDistSquared, double[].class, 389, 15484, 15497)) {
                                                    CallChecker.isCalled(minDistSquared, double[].class, 389, 15484, 15497)[j] = d2;
                                                    CallChecker.varAssign(CallChecker.isCalled(minDistSquared, double[].class, 389, 15484, 15497)[j], "CallChecker.isCalled(minDistSquared, double[].class, 389, 15484, 15497)[j]", 389, 15484, 15506);
                                                }
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    break;
                }
            } 
            return resultSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<CentroidCluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1642.methodEnd();
        }
    }

    private T getPointFromLargestVarianceCluster(final Collection<CentroidCluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1643 = new MethodContext(null, 413, 15837, 17462);
        try {
            CallChecker.varInit(this, "this", 413, 15837, 17462);
            CallChecker.varInit(clusters, "clusters", 413, 15837, 17462);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 413, 15837, 17462);
            CallChecker.varInit(this.random, "random", 413, 15837, 17462);
            CallChecker.varInit(this.maxIterations, "maxIterations", 413, 15837, 17462);
            CallChecker.varInit(this.k, "k", 413, 15837, 17462);
            double maxVariance = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "maxVariance", 416, 16262, 16307);
            Cluster<T> selected = CallChecker.varInit(null, "selected", 417, 16317, 16343);
            if (CallChecker.beforeDeref(clusters, null, 418, 16393, 16400)) {
                for (final CentroidCluster<T> cluster : clusters) {
                    if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 419, 16422, 16428)) {
                        final List<T> npe_invocation_var149 = CallChecker.isCalled(cluster, CentroidCluster.class, 419, 16422, 16428).getPoints();
                        if (CallChecker.beforeDeref(npe_invocation_var149, List.class, 419, 16422, 16440)) {
                            if (!(CallChecker.isCalled(npe_invocation_var149, List.class, 419, 16422, 16440).isEmpty())) {
                                final Clusterable center = CallChecker.varInit(CallChecker.isCalled(cluster, CentroidCluster.class, 422, 16571, 16577).getCenter(), "center", 422, 16472, 16590);
                                final Variance stat = CallChecker.varInit(new Variance(), "stat", 423, 16608, 16644);
                                for (final T point : CallChecker.isCalled(cluster, CentroidCluster.class, 424, 16683, 16689).getPoints()) {
                                    if (CallChecker.beforeDeref(stat, Variance.class, 425, 16726, 16729)) {
                                        CallChecker.isCalled(stat, Variance.class, 425, 16726, 16729).increment(distance(point, center));
                                    }
                                }
                                final double variance = CallChecker.varInit(((double) (CallChecker.isCalled(stat, Variance.class, 427, 16825, 16828).getResult())), "variance", 427, 16801, 16841);
                                if (variance > maxVariance) {
                                    maxVariance = variance;
                                    CallChecker.varAssign(maxVariance, "maxVariance", 431, 16974, 16996);
                                    selected = cluster;
                                    CallChecker.varAssign(selected, "selected", 432, 17018, 17036);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (selected == null) {
                throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
            }
            final List<T> selectedPoints = CallChecker.varInit(selected.getPoints(), "selectedPoints", 444, 17276, 17378);
            if (CallChecker.beforeDeref(selectedPoints, List.class, 445, 17432, 17445)) {
                if (CallChecker.beforeDeref(random, RandomGenerator.class, 445, 17417, 17422)) {
                    if (CallChecker.beforeDeref(selectedPoints, List.class, 445, 17395, 17408)) {
                        return selectedPoints.remove(CallChecker.isCalled(random, RandomGenerator.class, 445, 17417, 17422).nextInt(CallChecker.isCalled(selectedPoints, List.class, 445, 17432, 17445).size()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1643.methodEnd();
        }
    }

    private T getPointFromLargestNumberCluster(final Collection<? extends Cluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1644 = new MethodContext(null, 456, 17469, 18707);
        try {
            CallChecker.varInit(this, "this", 456, 17469, 18707);
            CallChecker.varInit(clusters, "clusters", 456, 17469, 18707);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 456, 17469, 18707);
            CallChecker.varInit(this.random, "random", 456, 17469, 18707);
            CallChecker.varInit(this.maxIterations, "maxIterations", 456, 17469, 18707);
            CallChecker.varInit(this.k, "k", 456, 17469, 18707);
            int maxNumber = CallChecker.varInit(((int) (0)), "maxNumber", 459, 17892, 17909);
            Cluster<T> selected = CallChecker.varInit(null, "selected", 460, 17919, 17945);
            if (CallChecker.beforeDeref(clusters, null, 461, 17987, 17994)) {
                for (final Cluster<T> cluster : clusters) {
                    final int number = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(cluster, Cluster.class, 464, 18094, 18100).getPoints(), List.class, 464, 18094, 18112).size())), "number", 464, 18012, 18120);
                    if (number > maxNumber) {
                        maxNumber = number;
                        CallChecker.varAssign(maxNumber, "maxNumber", 468, 18245, 18263);
                        selected = cluster;
                        CallChecker.varAssign(selected, "selected", 469, 18281, 18299);
                    }
                }
            }
            if (selected == null) {
                throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
            }
            final List<T> selectedPoints = CallChecker.varInit(selected.getPoints(), "selectedPoints", 480, 18521, 18623);
            if (CallChecker.beforeDeref(selectedPoints, List.class, 481, 18677, 18690)) {
                if (CallChecker.beforeDeref(random, RandomGenerator.class, 481, 18662, 18667)) {
                    if (CallChecker.beforeDeref(selectedPoints, List.class, 481, 18640, 18653)) {
                        return selectedPoints.remove(CallChecker.isCalled(random, RandomGenerator.class, 481, 18662, 18667).nextInt(CallChecker.isCalled(selectedPoints, List.class, 481, 18677, 18690).size()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1644.methodEnd();
        }
    }

    private T getFarthestPoint(final Collection<CentroidCluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1645 = new MethodContext(null, 492, 18714, 20024);
        try {
            CallChecker.varInit(this, "this", 492, 18714, 20024);
            CallChecker.varInit(clusters, "clusters", 492, 18714, 20024);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 492, 18714, 20024);
            CallChecker.varInit(this.random, "random", 492, 18714, 20024);
            CallChecker.varInit(this.maxIterations, "maxIterations", 492, 18714, 20024);
            CallChecker.varInit(this.k, "k", 492, 18714, 20024);
            double maxDistance = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "maxDistance", 494, 19070, 19115);
            Cluster<T> selectedCluster = CallChecker.varInit(null, "selectedCluster", 495, 19125, 19158);
            int selectedPoint = CallChecker.varInit(((int) (-1)), "selectedPoint", 496, 19168, 19190);
            if (CallChecker.beforeDeref(clusters, null, 497, 19240, 19247)) {
                for (final CentroidCluster<T> cluster : clusters) {
                    final Clusterable center = CallChecker.varInit(CallChecker.isCalled(cluster, CentroidCluster.class, 500, 19330, 19336).getCenter(), "center", 500, 19265, 19349);
                    final List<T> points = CallChecker.varInit(CallChecker.isCalled(cluster, CentroidCluster.class, 501, 19386, 19392).getPoints(), "points", 501, 19363, 19405);
                    for (int i = 0; i < (CallChecker.isCalled(points, List.class, 502, 19439, 19444).size()); ++i) {
                        final double distance = CallChecker.varInit(((double) (distance(points.get(i), center))), "distance", 503, 19477, 19532);
                        if (distance > maxDistance) {
                            maxDistance = distance;
                            CallChecker.varAssign(maxDistance, "maxDistance", 505, 19600, 19626);
                            selectedCluster = cluster;
                            CallChecker.varAssign(selectedCluster, "selectedCluster", 506, 19648, 19673);
                            selectedPoint = i;
                            CallChecker.varAssign(selectedPoint, "selectedPoint", 507, 19695, 19714);
                        }
                    }
                }
            }
            if (selectedCluster == null) {
                throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
            }
            selectedCluster = CallChecker.beforeCalled(selectedCluster, Cluster.class, 518, 19968, 19982);
            final List<T> npe_invocation_var150 = CallChecker.isCalled(selectedCluster, Cluster.class, 518, 19968, 19982).getPoints();
            if (CallChecker.beforeDeref(npe_invocation_var150, List.class, 518, 19968, 19994)) {
                return npe_invocation_var150.remove(selectedPoint);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1645.methodEnd();
        }
    }

    private int getNearestCluster(final Collection<CentroidCluster<T>> clusters, final T point) {
        MethodContext _bcornu_methode_context1646 = new MethodContext(int.class, 529, 20031, 20844);
        try {
            CallChecker.varInit(this, "this", 529, 20031, 20844);
            CallChecker.varInit(point, "point", 529, 20031, 20844);
            CallChecker.varInit(clusters, "clusters", 529, 20031, 20844);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 529, 20031, 20844);
            CallChecker.varInit(this.random, "random", 529, 20031, 20844);
            CallChecker.varInit(this.maxIterations, "maxIterations", 529, 20031, 20844);
            CallChecker.varInit(this.k, "k", 529, 20031, 20844);
            double minDistance = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minDistance", 530, 20417, 20454);
            int clusterIndex = CallChecker.varInit(((int) (0)), "clusterIndex", 531, 20464, 20484);
            int minCluster = CallChecker.varInit(((int) (0)), "minCluster", 532, 20494, 20512);
            if (CallChecker.beforeDeref(clusters, int.class, 533, 20556, 20563)) {
                for (final CentroidCluster<T> c : clusters) {
                    final double distance = CallChecker.varInit(((double) (distance(point, CallChecker.isCalled(c, CentroidCluster.class, 534, 20620, 20620).getCenter()))), "distance", 534, 20580, 20634);
                    if (distance < minDistance) {
                        minDistance = distance;
                        CallChecker.varAssign(minDistance, "minDistance", 536, 20694, 20716);
                        minCluster = clusterIndex;
                        CallChecker.varAssign(minCluster, "minCluster", 537, 20734, 20759);
                    }
                    clusterIndex++;
                }
            }
            return minCluster;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1646.methodEnd();
        }
    }

    private Clusterable centroidOf(final Collection<T> points, final int dimension) {
        MethodContext _bcornu_methode_context1647 = new MethodContext(Clusterable.class, 551, 20851, 21560);
        try {
            CallChecker.varInit(this, "this", 551, 20851, 21560);
            CallChecker.varInit(dimension, "dimension", 551, 20851, 21560);
            CallChecker.varInit(points, "points", 551, 20851, 21560);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 551, 20851, 21560);
            CallChecker.varInit(this.random, "random", 551, 20851, 21560);
            CallChecker.varInit(this.maxIterations, "maxIterations", 551, 20851, 21560);
            CallChecker.varInit(this.k, "k", 551, 20851, 21560);
            final double[] centroid = CallChecker.varInit(new double[dimension], "centroid", 552, 21156, 21203);
            if (CallChecker.beforeDeref(points, Clusterable.class, 553, 21230, 21235)) {
                for (final T p : points) {
                    final double[] point = CallChecker.varInit(p.getPoint(), "point", 554, 21252, 21287);
                    for (int i = 0; i < (CallChecker.isCalled(centroid, double[].class, 555, 21321, 21328).length); i++) {
                        if (CallChecker.beforeDeref(centroid, double[].class, 556, 21361, 21368)) {
                            if (CallChecker.beforeDeref(point, double[].class, 556, 21376, 21380)) {
                                CallChecker.isCalled(centroid, double[].class, 556, 21361, 21368)[i] += CallChecker.isCalled(point, double[].class, 556, 21376, 21380)[i];
                                CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 556, 21361, 21368)[i], "CallChecker.isCalled(centroid, double[].class, 556, 21361, 21368)[i]", 556, 21361, 21384);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(centroid, double[].class, 559, 21438, 21445).length); i++) {
                if (CallChecker.beforeDeref(centroid, double[].class, 560, 21474, 21481)) {
                    if (CallChecker.beforeDeref(points, Collection.class, 560, 21489, 21494)) {
                        CallChecker.isCalled(centroid, double[].class, 560, 21474, 21481)[i] /= CallChecker.isCalled(points, Collection.class, 560, 21489, 21494).size();
                        CallChecker.varAssign(CallChecker.isCalled(centroid, double[].class, 560, 21474, 21481)[i], "CallChecker.isCalled(centroid, double[].class, 560, 21474, 21481)[i]", 560, 21474, 21502);
                    }
                }
            }
            return new DoublePoint(centroid);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Clusterable) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1647.methodEnd();
        }
    }
}

