package org.apache.commons.math3.stat.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

@Deprecated
public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {
    public static enum EmptyClusterStrategy {
LARGEST_VARIANCE, LARGEST_POINTS_NUMBER, FARTHEST_POINT, ERROR;    }

    private final Random random;

    private final KMeansPlusPlusClusterer.EmptyClusterStrategy emptyStrategy;

    public KMeansPlusPlusClusterer(final Random random) {
        this(random, KMeansPlusPlusClusterer.EmptyClusterStrategy.LARGEST_VARIANCE);
        ConstructorContext _bcornu_methode_context372 = new ConstructorContext(KMeansPlusPlusClusterer.class, 75, 2504, 2918);
        try {
        } finally {
            _bcornu_methode_context372.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer(final Random random, final KMeansPlusPlusClusterer.EmptyClusterStrategy emptyStrategy) {
        ConstructorContext _bcornu_methode_context373 = new ConstructorContext(KMeansPlusPlusClusterer.class, 85, 2925, 3356);
        try {
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 86, 3279, 3306);
            this.emptyStrategy = emptyStrategy;
            CallChecker.varAssign(this.emptyStrategy, "this.emptyStrategy", 87, 3316, 3350);
        } finally {
            _bcornu_methode_context373.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points, final int k, int numTrials, int maxIterationsPerTrial) throws ConvergenceException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1628 = new MethodContext(List.class, 104, 3363, 5626);
        try {
            CallChecker.varInit(this, "this", 104, 3363, 5626);
            CallChecker.varInit(maxIterationsPerTrial, "maxIterationsPerTrial", 104, 3363, 5626);
            CallChecker.varInit(numTrials, "numTrials", 104, 3363, 5626);
            CallChecker.varInit(k, "k", 104, 3363, 5626);
            CallChecker.varInit(points, "points", 104, 3363, 5626);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 104, 3363, 5626);
            CallChecker.varInit(this.random, "random", 104, 3363, 5626);
            List<Cluster<T>> best = CallChecker.varInit(null, "best", 109, 4374, 4402);
            double bestVarianceSum = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "bestVarianceSum", 110, 4412, 4461);
            for (int i = 0; i < numTrials; ++i) {
                List<Cluster<T>> clusters = CallChecker.varInit(cluster(points, k, maxIterationsPerTrial), "clusters", 116, 4602, 4671);
                double varianceSum = CallChecker.varInit(((double) (0.0)), "varianceSum", 119, 4742, 4766);
                if (CallChecker.beforeDeref(clusters, List.class, 120, 4812, 4819)) {
                    for (final Cluster<T> cluster : clusters) {
                        if (CallChecker.beforeDeref(cluster, Cluster.class, 121, 4845, 4851)) {
                            final List<T> npe_invocation_var141 = CallChecker.isCalled(cluster, Cluster.class, 121, 4845, 4851).getPoints();
                            if (CallChecker.beforeDeref(npe_invocation_var141, List.class, 121, 4845, 4863)) {
                                if (!(CallChecker.isCalled(npe_invocation_var141, List.class, 121, 4845, 4863).isEmpty())) {
                                    final T center = CallChecker.varInit(cluster.getCenter(), "center", 124, 4899, 5011);
                                    final Variance stat = CallChecker.varInit(new Variance(), "stat", 125, 5033, 5069);
                                    for (final T point : CallChecker.isCalled(cluster, Cluster.class, 126, 5112, 5118).getPoints()) {
                                        if (CallChecker.beforeDeref(point, null, 127, 5174, 5178)) {
                                            if (CallChecker.beforeDeref(stat, Variance.class, 127, 5159, 5162)) {
                                                CallChecker.isCalled(stat, Variance.class, 127, 5159, 5162).increment(point.distanceFrom(center));
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(stat, Variance.class, 129, 5260, 5263)) {
                                        varianceSum += CallChecker.isCalled(stat, Variance.class, 129, 5260, 5263).getResult();
                                        CallChecker.varAssign(varianceSum, "varianceSum", 129, 5245, 5276);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
                if (varianceSum <= bestVarianceSum) {
                    best = clusters;
                    CallChecker.varAssign(best, "best", 136, 5452, 5478);
                    bestVarianceSum = varianceSum;
                    CallChecker.varAssign(bestVarianceSum, "bestVarianceSum", 137, 5496, 5525);
                }
            }
            return best;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1628.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points, final int k, final int maxIterations) throws ConvergenceException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1629 = new MethodContext(List.class, 160, 5633, 8972);
        try {
            CallChecker.varInit(this, "this", 160, 5633, 8972);
            CallChecker.varInit(maxIterations, "maxIterations", 160, 5633, 8972);
            CallChecker.varInit(k, "k", 160, 5633, 8972);
            CallChecker.varInit(points, "points", 160, 5633, 8972);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 160, 5633, 8972);
            CallChecker.varInit(this.random, "random", 160, 5633, 8972);
            MathUtils.checkNotNull(points);
            if (CallChecker.beforeDeref(points, Collection.class, 168, 6648, 6653)) {
                if ((CallChecker.isCalled(points, Collection.class, 168, 6648, 6653).size()) < k) {
                    if (CallChecker.beforeDeref(points, Collection.class, 169, 6717, 6722)) {
                        throw new NumberIsTooSmallException(CallChecker.isCalled(points, Collection.class, 169, 6717, 6722).size(), k, false);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            List<Cluster<T>> clusters = CallChecker.varInit(KMeansPlusPlusClusterer.chooseInitialCenters(points, k, random), "clusters", 173, 6801, 6868);
            int[] assignments = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(points, Collection.class, 177, 7082, 7087)) {
                assignments = new int[CallChecker.isCalled(points, Collection.class, 177, 7082, 7087).size()];
                CallChecker.varAssign(assignments, "assignments", 177, 7082, 7087);
            }
            KMeansPlusPlusClusterer.assignPointsToClusters(clusters, points, assignments);
            int max = CallChecker.init(int.class);
            if (maxIterations < 0) {
                max = Integer.MAX_VALUE;
                CallChecker.varAssign(max, "max", 181, 7251, 7305);
            }else {
                max = maxIterations;
                CallChecker.varAssign(max, "max", 181, 7251, 7305);
            }
            for (int count = 0; count < max; count++) {
                boolean emptyCluster = CallChecker.varInit(((boolean) (false)), "emptyCluster", 183, 7372, 7400);
                List<Cluster<T>> newClusters = CallChecker.varInit(new ArrayList<Cluster<T>>(), "newClusters", 184, 7414, 7472);
                if (CallChecker.beforeDeref(clusters, List.class, 185, 7518, 7525)) {
                    for (final Cluster<T> cluster : clusters) {
                        T newCenter = CallChecker.init(null);
                        if (CallChecker.beforeDeref(cluster, Cluster.class, 187, 7585, 7591)) {
                            final List<T> npe_invocation_var142 = CallChecker.isCalled(cluster, Cluster.class, 187, 7585, 7591).getPoints();
                            if (CallChecker.beforeDeref(npe_invocation_var142, List.class, 187, 7585, 7603)) {
                                if (CallChecker.isCalled(npe_invocation_var142, List.class, 187, 7585, 7603).isEmpty()) {
                                    switch (emptyStrategy) {
                                        case LARGEST_VARIANCE :
                                            newCenter = getPointFromLargestVarianceCluster(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 190, 7739, 7795);
                                            break;
                                        case LARGEST_POINTS_NUMBER :
                                            newCenter = getPointFromLargestNumberCluster(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 193, 7913, 7967);
                                            break;
                                        case FARTHEST_POINT :
                                            newCenter = getFarthestPoint(clusters);
                                            CallChecker.varAssign(newCenter, "newCenter", 196, 8078, 8116);
                                            break;
                                        default :
                                            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
                                    }
                                    emptyCluster = true;
                                    CallChecker.varAssign(emptyCluster, "emptyCluster", 201, 8332, 8351);
                                }else {
                                    if (CallChecker.beforeDeref(cluster, Cluster.class, 203, 8410, 8416)) {
                                        if (CallChecker.beforeDeref(cluster, Cluster.class, 203, 8441, 8447)) {
                                            final Clusterable<T> npe_invocation_var143 = cluster.getCenter();
                                            if (CallChecker.beforeDeref(npe_invocation_var143, Clusterable.class, 203, 8410, 8428)) {
                                                newCenter = npe_invocation_var143.centroidOf(CallChecker.isCalled(cluster, Cluster.class, 203, 8441, 8447).getPoints());
                                                CallChecker.varAssign(newCenter, "newCenter", 203, 8398, 8461);
                                            }
                                        }
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(newClusters, List.class, 205, 8497, 8507)) {
                            newClusters = CallChecker.beforeCalled(newClusters, List.class, 205, 8497, 8507);
                            CallChecker.isCalled(newClusters, List.class, 205, 8497, 8507).add(new Cluster<T>(newCenter));
                        }
                    }
                }
                int changes = CallChecker.varInit(((int) (KMeansPlusPlusClusterer.assignPointsToClusters(newClusters, points, assignments))), "changes", 207, 8567, 8637);
                clusters = newClusters;
                CallChecker.varAssign(clusters, "clusters", 208, 8651, 8673);
                if ((changes == 0) && (!emptyCluster)) {
                    return clusters;
                }
            }
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1629.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> int assignPointsToClusters(final List<Cluster<T>> clusters, final Collection<T> points, final int[] assignments) {
        MethodContext _bcornu_methode_context1630 = new MethodContext(int.class, 229, 8979, 10064);
        try {
            CallChecker.varInit(assignments, "assignments", 229, 8979, 10064);
            CallChecker.varInit(points, "points", 229, 8979, 10064);
            CallChecker.varInit(clusters, "clusters", 229, 8979, 10064);
            int assignedDifferently = CallChecker.varInit(((int) (0)), "assignedDifferently", 231, 9597, 9624);
            int pointIndex = CallChecker.varInit(((int) (0)), "pointIndex", 232, 9634, 9652);
            if (CallChecker.beforeDeref(points, int.class, 233, 9679, 9684)) {
                for (final T p : points) {
                    int clusterIndex = CallChecker.varInit(((int) (KMeansPlusPlusClusterer.getNearestCluster(clusters, p))), "clusterIndex", 234, 9701, 9750);
                    if (CallChecker.beforeDeref(assignments, int[].class, 235, 9784, 9794)) {
                        if (clusterIndex != (CallChecker.isCalled(assignments, int[].class, 235, 9784, 9794)[pointIndex])) {
                            assignedDifferently++;
                        }
                    }
                    Cluster<T> cluster = CallChecker.init(Cluster.class);
                    if (CallChecker.beforeDeref(clusters, List.class, 239, 9898, 9905)) {
                        cluster = CallChecker.isCalled(clusters, List.class, 239, 9898, 9905).get(clusterIndex);
                        CallChecker.varAssign(cluster, "cluster", 239, 9898, 9905);
                    }
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 240, 9938, 9944)) {
                        cluster = CallChecker.beforeCalled(cluster, Cluster.class, 240, 9938, 9944);
                        CallChecker.isCalled(cluster, Cluster.class, 240, 9938, 9944).addPoint(p);
                    }
                    if (CallChecker.beforeDeref(assignments, int[].class, 241, 9971, 9981)) {
                        CallChecker.isCalled(assignments, int[].class, 241, 9971, 9981)[(pointIndex++)] = clusterIndex;
                        CallChecker.varAssign(CallChecker.isCalled(assignments, int[].class, 241, 9971, 9981)[(pointIndex - 1)], "CallChecker.isCalled(assignments, int[].class, 241, 9971, 9981)[(pointIndex - 1)]", 241, 9971, 10011);
                    }
                }
            }
            return assignedDifferently;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1630.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(final Collection<T> points, final int k, final Random random) {
        MethodContext _bcornu_methode_context1631 = new MethodContext(List.class, 257, 10071, 14806);
        try {
            CallChecker.varInit(random, "random", 257, 10071, 14806);
            CallChecker.varInit(k, "k", 257, 10071, 14806);
            CallChecker.varInit(points, "points", 257, 10071, 14806);
            final List<T> pointList = CallChecker.varInit(Collections.unmodifiableList(new ArrayList<T>(points)), "pointList", 261, 10550, 10775);
            final int numPoints = CallChecker.varInit(((int) (CallChecker.isCalled(pointList, List.class, 264, 10853, 10861).size())), "numPoints", 264, 10786, 10869);
            final boolean[] taken = CallChecker.varInit(new boolean[numPoints], "taken", 268, 11010, 11056);
            final List<Cluster<T>> resultSet = CallChecker.varInit(new ArrayList<Cluster<T>>(), "resultSet", 271, 11067, 11179);
            final int firstPointIndex = CallChecker.varInit(((int) (CallChecker.isCalled(random, Random.class, 274, 11295, 11300).nextInt(numPoints))), "firstPointIndex", 274, 11190, 11320);
            final T firstPoint = CallChecker.varInit(pointList.get(firstPointIndex), "firstPoint", 276, 11331, 11382);
            if (CallChecker.beforeDeref(resultSet, List.class, 278, 11393, 11401)) {
                CallChecker.isCalled(resultSet, List.class, 278, 11393, 11401).add(new Cluster<T>(firstPoint));
            }
            if (CallChecker.beforeDeref(taken, boolean[].class, 281, 11478, 11482)) {
                CallChecker.isCalled(taken, boolean[].class, 281, 11478, 11482)[firstPointIndex] = true;
                CallChecker.varAssign(CallChecker.isCalled(taken, boolean[].class, 281, 11478, 11482)[firstPointIndex], "CallChecker.isCalled(taken, boolean[].class, 281, 11478, 11482)[firstPointIndex]", 281, 11478, 11507);
            }
            final double[] minDistSquared = CallChecker.varInit(new double[numPoints], "minDistSquared", 285, 11637, 11690);
            for (int i = 0; i < numPoints; i++) {
                if (i != firstPointIndex) {
                    double d = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(pointList, List.class, 291, 11977, 11985)) {
                        if (CallChecker.beforeDeref(firstPoint, null, 291, 11953, 11962)) {
                            d = firstPoint.distanceFrom(pointList.get(i));
                            CallChecker.varAssign(d, "d", 291, 11977, 11985);
                        }
                    }
                    if (CallChecker.beforeDeref(minDistSquared, double[].class, 292, 12012, 12025)) {
                        CallChecker.isCalled(minDistSquared, double[].class, 292, 12012, 12025)[i] = d * d;
                        CallChecker.varAssign(CallChecker.isCalled(minDistSquared, double[].class, 292, 12012, 12025)[i], "CallChecker.isCalled(minDistSquared, double[].class, 292, 12012, 12025)[i]", 292, 12012, 12035);
                    }
                }
            }
            while ((CallChecker.isCalled(resultSet, List.class, 296, 12077, 12085).size()) < k) {
                double distSqSum = CallChecker.varInit(((double) (0.0)), "distSqSum", 300, 12220, 12242);
                for (int i = 0; i < numPoints; i++) {
                    if (CallChecker.beforeDeref(taken, boolean[].class, 303, 12316, 12320)) {
                        if (!(CallChecker.isCalled(taken, boolean[].class, 303, 12316, 12320)[i])) {
                            if (CallChecker.beforeDeref(minDistSquared, double[].class, 304, 12361, 12374)) {
                                distSqSum += CallChecker.isCalled(minDistSquared, double[].class, 304, 12361, 12374)[i];
                                CallChecker.varAssign(distSqSum, "distSqSum", 304, 12348, 12378);
                            }
                        }
                    }
                }
                final double r = CallChecker.varInit(((double) ((CallChecker.isCalled(random, Random.class, 310, 12570, 12575).nextDouble()) * distSqSum)), "r", 310, 12425, 12601);
                int nextPointIndex = CallChecker.varInit(((int) (-1)), "nextPointIndex", 313, 12689, 12712);
                double sum = CallChecker.varInit(((double) (0.0)), "sum", 317, 12826, 12842);
                for (int i = 0; i < numPoints; i++) {
                    if (CallChecker.beforeDeref(taken, boolean[].class, 319, 12915, 12919)) {
                        if (!(CallChecker.isCalled(taken, boolean[].class, 319, 12915, 12919)[i])) {
                            if (CallChecker.beforeDeref(minDistSquared, double[].class, 320, 12954, 12967)) {
                                sum += CallChecker.isCalled(minDistSquared, double[].class, 320, 12954, 12967)[i];
                                CallChecker.varAssign(sum, "sum", 320, 12947, 12971);
                            }
                            if (sum >= r) {
                                nextPointIndex = i;
                                CallChecker.varAssign(nextPointIndex, "nextPointIndex", 322, 13033, 13051);
                                break;
                            }
                        }
                    }
                }
                if (nextPointIndex == (-1)) {
                    for (int i = numPoints - 1; i >= 0; i--) {
                        if (CallChecker.beforeDeref(taken, boolean[].class, 333, 13467, 13471)) {
                            if (!(CallChecker.isCalled(taken, boolean[].class, 333, 13467, 13471)[i])) {
                                nextPointIndex = i;
                                CallChecker.varAssign(nextPointIndex, "nextPointIndex", 334, 13503, 13521);
                                break;
                            }
                        }
                    }
                }
                if (nextPointIndex >= 0) {
                    final T p = CallChecker.varInit(pointList.get(nextPointIndex), "p", 343, 13694, 13735);
                    if (CallChecker.beforeDeref(resultSet, List.class, 345, 13754, 13762)) {
                        CallChecker.isCalled(resultSet, List.class, 345, 13754, 13762).add(new Cluster<T>(p));
                    }
                    if (CallChecker.beforeDeref(taken, boolean[].class, 348, 13843, 13847)) {
                        CallChecker.isCalled(taken, boolean[].class, 348, 13843, 13847)[nextPointIndex] = true;
                        CallChecker.varAssign(CallChecker.isCalled(taken, boolean[].class, 348, 13843, 13847)[nextPointIndex], "CallChecker.isCalled(taken, boolean[].class, 348, 13843, 13847)[nextPointIndex]", 348, 13843, 13871);
                    }
                    if (CallChecker.beforeDeref(resultSet, List.class, 350, 13894, 13902)) {
                        if ((CallChecker.isCalled(resultSet, List.class, 350, 13894, 13902).size()) < k) {
                            for (int j = 0; j < numPoints; j++) {
                                if (CallChecker.beforeDeref(taken, boolean[].class, 355, 14238, 14242)) {
                                    if (!(CallChecker.isCalled(taken, boolean[].class, 355, 14238, 14242)[j])) {
                                        double d = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(pointList, List.class, 356, 14304, 14312)) {
                                            if (CallChecker.beforeDeref(p, null, 356, 14289, 14289)) {
                                                d = p.distanceFrom(pointList.get(j));
                                                CallChecker.varAssign(d, "d", 356, 14304, 14312);
                                            }
                                        }
                                        double d2 = CallChecker.varInit(((double) (d * d)), "d2", 357, 14351, 14368);
                                        if (CallChecker.beforeDeref(minDistSquared, double[].class, 358, 14407, 14420)) {
                                            if (d2 < (CallChecker.isCalled(minDistSquared, double[].class, 358, 14407, 14420)[j])) {
                                                if (CallChecker.beforeDeref(minDistSquared, double[].class, 359, 14460, 14473)) {
                                                    CallChecker.isCalled(minDistSquared, double[].class, 359, 14460, 14473)[j] = d2;
                                                    CallChecker.varAssign(CallChecker.isCalled(minDistSquared, double[].class, 359, 14460, 14473)[j], "CallChecker.isCalled(minDistSquared, double[].class, 359, 14460, 14473)[j]", 359, 14460, 14482);
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
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1631.methodEnd();
        }
    }

    private T getPointFromLargestVarianceCluster(final Collection<Cluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1632 = new MethodContext(null, 383, 14813, 16407);
        try {
            CallChecker.varInit(this, "this", 383, 14813, 16407);
            CallChecker.varInit(clusters, "clusters", 383, 14813, 16407);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 383, 14813, 16407);
            CallChecker.varInit(this.random, "random", 383, 14813, 16407);
            double maxVariance = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "maxVariance", 386, 15222, 15267);
            Cluster<T> selected = CallChecker.varInit(null, "selected", 387, 15277, 15303);
            if (CallChecker.beforeDeref(clusters, null, 388, 15345, 15352)) {
                for (final Cluster<T> cluster : clusters) {
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 389, 15374, 15380)) {
                        final List<T> npe_invocation_var144 = CallChecker.isCalled(cluster, Cluster.class, 389, 15374, 15380).getPoints();
                        if (CallChecker.beforeDeref(npe_invocation_var144, List.class, 389, 15374, 15392)) {
                            if (!(CallChecker.isCalled(npe_invocation_var144, List.class, 389, 15374, 15392).isEmpty())) {
                                final T center = CallChecker.varInit(cluster.getCenter(), "center", 392, 15424, 15532);
                                final Variance stat = CallChecker.varInit(new Variance(), "stat", 393, 15550, 15586);
                                for (final T point : CallChecker.isCalled(cluster, Cluster.class, 394, 15625, 15631).getPoints()) {
                                    if (CallChecker.beforeDeref(point, null, 395, 15683, 15687)) {
                                        if (CallChecker.beforeDeref(stat, Variance.class, 395, 15668, 15671)) {
                                            CallChecker.isCalled(stat, Variance.class, 395, 15668, 15671).increment(point.distanceFrom(center));
                                        }
                                    }
                                }
                                final double variance = CallChecker.varInit(((double) (CallChecker.isCalled(stat, Variance.class, 397, 15770, 15773).getResult())), "variance", 397, 15746, 15786);
                                if (variance > maxVariance) {
                                    maxVariance = variance;
                                    CallChecker.varAssign(maxVariance, "maxVariance", 401, 15919, 15941);
                                    selected = cluster;
                                    CallChecker.varAssign(selected, "selected", 402, 15963, 15981);
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
            final List<T> selectedPoints = CallChecker.varInit(selected.getPoints(), "selectedPoints", 414, 16221, 16323);
            if (CallChecker.beforeDeref(selectedPoints, List.class, 415, 16377, 16390)) {
                if (CallChecker.beforeDeref(random, Random.class, 415, 16362, 16367)) {
                    if (CallChecker.beforeDeref(selectedPoints, List.class, 415, 16340, 16353)) {
                        return selectedPoints.remove(CallChecker.isCalled(random, Random.class, 415, 16362, 16367).nextInt(CallChecker.isCalled(selectedPoints, List.class, 415, 16377, 16390).size()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1632.methodEnd();
        }
    }

    private T getPointFromLargestNumberCluster(final Collection<Cluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1633 = new MethodContext(null, 426, 16414, 17630);
        try {
            CallChecker.varInit(this, "this", 426, 16414, 17630);
            CallChecker.varInit(clusters, "clusters", 426, 16414, 17630);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 426, 16414, 17630);
            CallChecker.varInit(this.random, "random", 426, 16414, 17630);
            int maxNumber = CallChecker.varInit(((int) (0)), "maxNumber", 428, 16815, 16832);
            Cluster<T> selected = CallChecker.varInit(null, "selected", 429, 16842, 16868);
            if (CallChecker.beforeDeref(clusters, null, 430, 16910, 16917)) {
                for (final Cluster<T> cluster : clusters) {
                    final int number = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(cluster, Cluster.class, 433, 17017, 17023).getPoints(), List.class, 433, 17017, 17035).size())), "number", 433, 16935, 17043);
                    if (number > maxNumber) {
                        maxNumber = number;
                        CallChecker.varAssign(maxNumber, "maxNumber", 437, 17168, 17186);
                        selected = cluster;
                        CallChecker.varAssign(selected, "selected", 438, 17204, 17222);
                    }
                }
            }
            if (selected == null) {
                throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
            }
            final List<T> selectedPoints = CallChecker.varInit(selected.getPoints(), "selectedPoints", 449, 17444, 17546);
            if (CallChecker.beforeDeref(selectedPoints, List.class, 450, 17600, 17613)) {
                if (CallChecker.beforeDeref(random, Random.class, 450, 17585, 17590)) {
                    if (CallChecker.beforeDeref(selectedPoints, List.class, 450, 17563, 17576)) {
                        return selectedPoints.remove(CallChecker.isCalled(random, Random.class, 450, 17585, 17590).nextInt(CallChecker.isCalled(selectedPoints, List.class, 450, 17600, 17613).size()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1633.methodEnd();
        }
    }

    private T getFarthestPoint(final Collection<Cluster<T>> clusters) throws ConvergenceException {
        MethodContext _bcornu_methode_context1634 = new MethodContext(null, 461, 17637, 18924);
        try {
            CallChecker.varInit(this, "this", 461, 17637, 18924);
            CallChecker.varInit(clusters, "clusters", 461, 17637, 18924);
            CallChecker.varInit(this.emptyStrategy, "emptyStrategy", 461, 17637, 18924);
            CallChecker.varInit(this.random, "random", 461, 17637, 18924);
            double maxDistance = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "maxDistance", 463, 17985, 18030);
            Cluster<T> selectedCluster = CallChecker.varInit(null, "selectedCluster", 464, 18040, 18073);
            int selectedPoint = CallChecker.varInit(((int) (-1)), "selectedPoint", 465, 18083, 18105);
            if (CallChecker.beforeDeref(clusters, null, 466, 18147, 18154)) {
                for (final Cluster<T> cluster : clusters) {
                    final T center = CallChecker.varInit(cluster.getCenter(), "center", 469, 18172, 18246);
                    final List<T> points = CallChecker.varInit(CallChecker.isCalled(cluster, Cluster.class, 470, 18283, 18289).getPoints(), "points", 470, 18260, 18302);
                    for (int i = 0; i < (CallChecker.isCalled(points, List.class, 471, 18336, 18341).size()); ++i) {
                        final double distance = CallChecker.varInit(((double) (points.get(i).distanceFrom(center))), "distance", 472, 18374, 18432);
                        if (distance > maxDistance) {
                            maxDistance = distance;
                            CallChecker.varAssign(maxDistance, "maxDistance", 474, 18500, 18526);
                            selectedCluster = cluster;
                            CallChecker.varAssign(selectedCluster, "selectedCluster", 475, 18548, 18573);
                            selectedPoint = i;
                            CallChecker.varAssign(selectedPoint, "selectedPoint", 476, 18595, 18614);
                        }
                    }
                }
            }
            if (selectedCluster == null) {
                throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS);
            }
            selectedCluster = CallChecker.beforeCalled(selectedCluster, Cluster.class, 487, 18868, 18882);
            final List<T> npe_invocation_var145 = CallChecker.isCalled(selectedCluster, Cluster.class, 487, 18868, 18882).getPoints();
            if (CallChecker.beforeDeref(npe_invocation_var145, List.class, 487, 18868, 18894)) {
                return npe_invocation_var145.remove(selectedPoint);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1634.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> int getNearestCluster(final Collection<Cluster<T>> clusters, final T point) {
        MethodContext _bcornu_methode_context1635 = new MethodContext(int.class, 500, 18931, 19821);
        try {
            CallChecker.varInit(point, "point", 500, 18931, 19821);
            CallChecker.varInit(clusters, "clusters", 500, 18931, 19821);
            double minDistance = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minDistance", 501, 19399, 19436);
            int clusterIndex = CallChecker.varInit(((int) (0)), "clusterIndex", 502, 19446, 19466);
            int minCluster = CallChecker.varInit(((int) (0)), "minCluster", 503, 19476, 19494);
            if (CallChecker.beforeDeref(clusters, int.class, 504, 19530, 19537)) {
                for (final Cluster<T> c : clusters) {
                    final double distance = CallChecker.varInit(((double) (point.distanceFrom(c.getCenter()))), "distance", 505, 19554, 19611);
                    if (distance < minDistance) {
                        minDistance = distance;
                        CallChecker.varAssign(minDistance, "minDistance", 507, 19671, 19693);
                        minCluster = clusterIndex;
                        CallChecker.varAssign(minCluster, "minCluster", 508, 19711, 19736);
                    }
                    clusterIndex++;
                }
            }
            return minCluster;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1635.methodEnd();
        }
    }
}

