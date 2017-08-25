package org.apache.commons.math.stat.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {
    private final Random random;

    public KMeansPlusPlusClusterer(final Random random) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(KMeansPlusPlusClusterer.class, 40, 1495, 1692);
        try {
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 41, 1666, 1686);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points, final int k, final int maxIterations) {
        MethodContext _bcornu_methode_context1 = new MethodContext(List.class, 53, 1699, 3449);
        try {
            CallChecker.varInit(this, "this", 53, 1699, 3449);
            CallChecker.varInit(maxIterations, "maxIterations", 53, 1699, 3449);
            CallChecker.varInit(k, "k", 53, 1699, 3449);
            CallChecker.varInit(points, "points", 53, 1699, 3449);
            CallChecker.varInit(this.random, "random", 53, 1699, 3449);
            List<Cluster<T>> clusters = CallChecker.varInit(KMeansPlusPlusClusterer.chooseInitialCenters(points, k, random), "clusters", 56, 2290, 2397);
            KMeansPlusPlusClusterer.assignPointsToClusters(clusters, points);
            int max = CallChecker.init(int.class);
            if (maxIterations < 0) {
                max = Integer.MAX_VALUE;
                CallChecker.varAssign(max, "max", 60, 2539, 2593);
            }else {
                max = maxIterations;
                CallChecker.varAssign(max, "max", 60, 2539, 2593);
            }
            for (int count = 0; count < max; count++) {
                boolean clusteringChanged = CallChecker.varInit(((boolean) (false)), "clusteringChanged", 62, 2660, 2693);
                List<Cluster<T>> newClusters = CallChecker.varInit(new ArrayList<Cluster<T>>(), "newClusters", 63, 2707, 2845);
                if (CallChecker.beforeDeref(clusters, List.class, 64, 2891, 2898)) {
                    for (final Cluster<T> cluster : clusters) {
                        final T newCenter = CallChecker.varInit(cluster.getCenter().centroidOf(CallChecker.isCalled(cluster, Cluster.class, 65, 2970, 2976).getPoints()), "newCenter", 65, 2919, 2990);
                        if (CallChecker.beforeDeref(cluster, Cluster.class, 66, 3030, 3036)) {
                            if (CallChecker.beforeDeref(newCenter, null, 66, 3013, 3021)) {
                                if (!(newCenter.equals(cluster.getCenter()))) {
                                    clusteringChanged = true;
                                    CallChecker.varAssign(clusteringChanged, "clusteringChanged", 67, 3074, 3098);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(newClusters, List.class, 69, 3134, 3144)) {
                            newClusters = CallChecker.beforeCalled(newClusters, List.class, 69, 3134, 3144);
                            CallChecker.isCalled(newClusters, List.class, 69, 3134, 3144).add(new Cluster<T>(newCenter));
                        }
                    }
                }
                if (!clusteringChanged) {
                    return clusters;
                }
                KMeansPlusPlusClusterer.assignPointsToClusters(newClusters, points);
                clusters = newClusters;
                CallChecker.varAssign(clusters, "clusters", 75, 3386, 3408);
            }
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> void assignPointsToClusters(final Collection<Cluster<T>> clusters, final Collection<T> points) {
        MethodContext _bcornu_methode_context2 = new MethodContext(void.class, 88, 3456, 4140);
        try {
            CallChecker.varInit(points, "points", 88, 3456, 4140);
            CallChecker.varInit(clusters, "clusters", 88, 3456, 4140);
            if (CallChecker.beforeDeref(points, void.class, 89, 3978, 3983)) {
                for (final T p : points) {
                    Cluster<T> cluster = CallChecker.varInit(KMeansPlusPlusClusterer.getNearestCluster(clusters, p), "cluster", 90, 4000, 4091);
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 91, 4105, 4111)) {
                        cluster = CallChecker.beforeCalled(cluster, Cluster.class, 91, 4105, 4111);
                        CallChecker.isCalled(cluster, Cluster.class, 91, 4105, 4111).addPoint(p);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(final Collection<T> points, final int k, final Random random) {
        MethodContext _bcornu_methode_context3 = new MethodContext(List.class, 105, 4147, 6223);
        try {
            CallChecker.varInit(random, "random", 105, 4147, 6223);
            CallChecker.varInit(k, "k", 105, 4147, 6223);
            CallChecker.varInit(points, "points", 105, 4147, 6223);
            final List<T> pointSet = CallChecker.varInit(new ArrayList<T>(points), "pointSet", 107, 4666, 4715);
            final List<Cluster<T>> resultSet = CallChecker.varInit(new ArrayList<Cluster<T>>(), "resultSet", 108, 4725, 4827);
            final T firstPoint = CallChecker.varInit(pointSet.remove(CallChecker.isCalled(random, Random.class, 111, 4952, 4957).nextInt(CallChecker.isCalled(pointSet, List.class, 111, 4967, 4974).size())), "firstPoint", 111, 4838, 4984);
            if (CallChecker.beforeDeref(resultSet, List.class, 112, 4994, 5002)) {
                CallChecker.isCalled(resultSet, List.class, 112, 4994, 5002).add(new Cluster<T>(firstPoint));
            }
            final double[] dx2 = CallChecker.varInit(new double[CallChecker.isCalled(pointSet, List.class, 114, 5118, 5125).size()], "dx2", 114, 5086, 5134);
            while ((CallChecker.isCalled(resultSet, List.class, 115, 5151, 5159).size()) < k) {
                int sum = CallChecker.varInit(((int) (0)), "sum", 118, 5330, 5341);
                for (int i = 0; i < (CallChecker.isCalled(pointSet, List.class, 119, 5375, 5382).size()); i++) {
                    final T p = CallChecker.varInit(pointSet.get(i), "p", 120, 5415, 5442);
                    final Cluster<T> nearest = CallChecker.varInit(KMeansPlusPlusClusterer.getNearestCluster(resultSet, p), "nearest", 121, 5460, 5558);
                    final double d = CallChecker.varInit(((double) (p.distanceFrom(nearest.getCenter()))), "d", 122, 5576, 5628);
                    sum += d * d;
                    CallChecker.varAssign(sum, "sum", 123, 5646, 5658);
                    if (CallChecker.beforeDeref(dx2, double[].class, 124, 5676, 5678)) {
                        CallChecker.isCalled(dx2, double[].class, 124, 5676, 5678)[i] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(dx2, double[].class, 124, 5676, 5678)[i], "CallChecker.isCalled(dx2, double[].class, 124, 5676, 5678)[i]", 124, 5676, 5688);
                    }
                }
                final double r = CallChecker.varInit(((double) ((CallChecker.isCalled(random, Random.class, 129, 5862, 5867).nextDouble()) * sum)), "r", 129, 5717, 5887);
                for (int i = 0; i < (CallChecker.isCalled(dx2, double[].class, 130, 5922, 5924).length); i++) {
                    if (CallChecker.beforeDeref(dx2, double[].class, 131, 5961, 5963)) {
                        if ((CallChecker.isCalled(dx2, double[].class, 131, 5961, 5963)[i]) >= r) {
                            final T p = CallChecker.varInit(pointSet.remove(i), "p", 132, 5996, 6026);
                            if (CallChecker.beforeDeref(resultSet, List.class, 133, 6048, 6056)) {
                                CallChecker.isCalled(resultSet, List.class, 133, 6048, 6056).add(new Cluster<T>(p));
                            }
                            break;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            } 
            return resultSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> Cluster<T> getNearestCluster(final Collection<Cluster<T>> clusters, final T point) {
        MethodContext _bcornu_methode_context4 = new MethodContext(Cluster.class, 152, 6230, 7215);
        try {
            CallChecker.varInit(point, "point", 152, 6230, 7215);
            CallChecker.varInit(clusters, "clusters", 152, 6230, 7215);
            double minDistance = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minDistance", 153, 6772, 6809);
            Cluster<T> minCluster = CallChecker.varInit(null, "minCluster", 154, 6819, 6887);
            if (CallChecker.beforeDeref(clusters, Cluster.class, 155, 6963, 6970)) {
                for (final Cluster<T> c : clusters) {
                    final double distance = CallChecker.varInit(((double) (point.distanceFrom(c.getCenter()))), "distance", 156, 6987, 7044);
                    if (distance < minDistance) {
                        minDistance = distance;
                        CallChecker.varAssign(minDistance, "minDistance", 158, 7104, 7126);
                        minCluster = c;
                        CallChecker.varAssign(minCluster, "minCluster", 159, 7144, 7158);
                    }
                }
            }
            return minCluster;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Cluster<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }
}

