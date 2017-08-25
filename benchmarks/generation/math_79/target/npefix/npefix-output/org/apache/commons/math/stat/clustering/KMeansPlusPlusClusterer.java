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
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(KMeansPlusPlusClusterer.class, 40, 1396, 1593);
        try {
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 41, 1567, 1587);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points, final int k, final int maxIterations) {
        MethodContext _bcornu_methode_context1 = new MethodContext(List.class, 53, 1600, 3150);
        try {
            CallChecker.varInit(this, "this", 53, 1600, 3150);
            CallChecker.varInit(maxIterations, "maxIterations", 53, 1600, 3150);
            CallChecker.varInit(k, "k", 53, 1600, 3150);
            CallChecker.varInit(points, "points", 53, 1600, 3150);
            CallChecker.varInit(this.random, "random", 53, 1600, 3150);
            List<Cluster<T>> clusters = CallChecker.varInit(KMeansPlusPlusClusterer.chooseInitialCenters(points, k, random), "clusters", 56, 2151, 2218);
            KMeansPlusPlusClusterer.assignPointsToClusters(clusters, points);
            int max = CallChecker.init(int.class);
            if (maxIterations < 0) {
                max = Integer.MAX_VALUE;
                CallChecker.varAssign(max, "max", 60, 2360, 2414);
            }else {
                max = maxIterations;
                CallChecker.varAssign(max, "max", 60, 2360, 2414);
            }
            for (int count = 0; count < max; count++) {
                boolean clusteringChanged = CallChecker.varInit(((boolean) (false)), "clusteringChanged", 62, 2481, 2514);
                List<Cluster<T>> newClusters = CallChecker.varInit(new ArrayList<Cluster<T>>(), "newClusters", 63, 2528, 2586);
                if (CallChecker.beforeDeref(clusters, List.class, 64, 2632, 2639)) {
                    for (final Cluster<T> cluster : clusters) {
                        final T newCenter = CallChecker.varInit(cluster.getCenter().centroidOf(CallChecker.isCalled(cluster, Cluster.class, 65, 2711, 2717).getPoints()), "newCenter", 65, 2660, 2731);
                        if (CallChecker.beforeDeref(cluster, Cluster.class, 66, 2771, 2777)) {
                            if (CallChecker.beforeDeref(newCenter, null, 66, 2754, 2762)) {
                                if (!(newCenter.equals(cluster.getCenter()))) {
                                    clusteringChanged = true;
                                    CallChecker.varAssign(clusteringChanged, "clusteringChanged", 67, 2815, 2839);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(newClusters, List.class, 69, 2875, 2885)) {
                            newClusters = CallChecker.beforeCalled(newClusters, List.class, 69, 2875, 2885);
                            CallChecker.isCalled(newClusters, List.class, 69, 2875, 2885).add(new Cluster<T>(newCenter));
                        }
                    }
                }
                if (!clusteringChanged) {
                    return clusters;
                }
                KMeansPlusPlusClusterer.assignPointsToClusters(newClusters, points);
                clusters = newClusters;
                CallChecker.varAssign(clusters, "clusters", 75, 3087, 3109);
            }
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    private static <T extends Clusterable<T>> void assignPointsToClusters(final Collection<Cluster<T>> clusters, final Collection<T> points) {
        MethodContext _bcornu_methode_context2 = new MethodContext(void.class, 88, 3157, 3717);
        try {
            CallChecker.varInit(points, "points", 88, 3157, 3717);
            CallChecker.varInit(clusters, "clusters", 88, 3157, 3717);
            if (CallChecker.beforeDeref(points, void.class, 89, 3595, 3600)) {
                for (final T p : points) {
                    Cluster<T> cluster = CallChecker.varInit(KMeansPlusPlusClusterer.getNearestCluster(clusters, p), "cluster", 90, 3617, 3668);
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 91, 3682, 3688)) {
                        cluster = CallChecker.beforeCalled(cluster, Cluster.class, 91, 3682, 3688);
                        CallChecker.isCalled(cluster, Cluster.class, 91, 3682, 3688).addPoint(p);
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
        MethodContext _bcornu_methode_context3 = new MethodContext(List.class, 105, 3724, 5600);
        try {
            CallChecker.varInit(random, "random", 105, 3724, 5600);
            CallChecker.varInit(k, "k", 105, 3724, 5600);
            CallChecker.varInit(points, "points", 105, 3724, 5600);
            final List<T> pointSet = CallChecker.varInit(new ArrayList<T>(points), "pointSet", 107, 4203, 4252);
            final List<Cluster<T>> resultSet = CallChecker.varInit(new ArrayList<Cluster<T>>(), "resultSet", 108, 4262, 4324);
            final T firstPoint = CallChecker.varInit(pointSet.remove(CallChecker.isCalled(random, Random.class, 111, 4449, 4454).nextInt(CallChecker.isCalled(pointSet, List.class, 111, 4464, 4471).size())), "firstPoint", 111, 4335, 4481);
            if (CallChecker.beforeDeref(resultSet, List.class, 112, 4491, 4499)) {
                CallChecker.isCalled(resultSet, List.class, 112, 4491, 4499).add(new Cluster<T>(firstPoint));
            }
            final double[] dx2 = CallChecker.varInit(new double[CallChecker.isCalled(pointSet, List.class, 114, 4575, 4582).size()], "dx2", 114, 4543, 4591);
            while ((CallChecker.isCalled(resultSet, List.class, 115, 4608, 4616).size()) < k) {
                int sum = CallChecker.varInit(((int) (0)), "sum", 118, 4787, 4798);
                for (int i = 0; i < (CallChecker.isCalled(pointSet, List.class, 119, 4832, 4839).size()); i++) {
                    final T p = CallChecker.varInit(pointSet.get(i), "p", 120, 4872, 4899);
                    final Cluster<T> nearest = CallChecker.varInit(KMeansPlusPlusClusterer.getNearestCluster(resultSet, p), "nearest", 121, 4917, 4975);
                    final double d = CallChecker.varInit(((double) (p.distanceFrom(nearest.getCenter()))), "d", 122, 4993, 5045);
                    sum += d * d;
                    CallChecker.varAssign(sum, "sum", 123, 5063, 5075);
                    if (CallChecker.beforeDeref(dx2, double[].class, 124, 5093, 5095)) {
                        CallChecker.isCalled(dx2, double[].class, 124, 5093, 5095)[i] = sum;
                        CallChecker.varAssign(CallChecker.isCalled(dx2, double[].class, 124, 5093, 5095)[i], "CallChecker.isCalled(dx2, double[].class, 124, 5093, 5095)[i]", 124, 5093, 5105);
                    }
                }
                final double r = CallChecker.varInit(((double) ((CallChecker.isCalled(random, Random.class, 129, 5279, 5284).nextDouble()) * sum)), "r", 129, 5134, 5304);
                for (int i = 0; i < (CallChecker.isCalled(dx2, double[].class, 130, 5339, 5341).length); i++) {
                    if (CallChecker.beforeDeref(dx2, double[].class, 131, 5378, 5380)) {
                        if ((CallChecker.isCalled(dx2, double[].class, 131, 5378, 5380)[i]) >= r) {
                            final T p = CallChecker.varInit(pointSet.remove(i), "p", 132, 5413, 5443);
                            if (CallChecker.beforeDeref(resultSet, List.class, 133, 5465, 5473)) {
                                CallChecker.isCalled(resultSet, List.class, 133, 5465, 5473).add(new Cluster<T>(p));
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
        MethodContext _bcornu_methode_context4 = new MethodContext(Cluster.class, 152, 5607, 6432);
        try {
            CallChecker.varInit(point, "point", 152, 5607, 6432);
            CallChecker.varInit(clusters, "clusters", 152, 5607, 6432);
            double minDistance = CallChecker.varInit(((double) (Double.MAX_VALUE)), "minDistance", 153, 6069, 6106);
            Cluster<T> minCluster = CallChecker.varInit(null, "minCluster", 154, 6116, 6144);
            if (CallChecker.beforeDeref(clusters, Cluster.class, 155, 6180, 6187)) {
                for (final Cluster<T> c : clusters) {
                    final double distance = CallChecker.varInit(((double) (point.distanceFrom(c.getCenter()))), "distance", 156, 6204, 6261);
                    if (distance < minDistance) {
                        minDistance = distance;
                        CallChecker.varAssign(minDistance, "minDistance", 158, 6321, 6343);
                        minCluster = c;
                        CallChecker.varAssign(minCluster, "minCluster", 159, 6361, 6375);
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

