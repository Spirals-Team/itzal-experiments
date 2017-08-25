package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.util.MathUtils;

public class DBSCANClusterer<T extends Clusterable> extends Clusterer<T> {
    private enum PointStatus {
NOISE, PART_OF_CLUSTER;    }

    private final double eps;

    private final int minPts;

    public DBSCANClusterer(final double eps, final int minPts) throws NotPositiveException {
        this(eps, minPts, new EuclideanDistance());
        ConstructorContext _bcornu_methode_context274 = new ConstructorContext(DBSCANClusterer.class, 84, 3148, 3675);
        try {
        } finally {
            _bcornu_methode_context274.methodEnd();
        }
    }

    public DBSCANClusterer(final double eps, final int minPts, final DistanceMeasure measure) throws NotPositiveException {
        super(measure);
        ConstructorContext _bcornu_methode_context275 = new ConstructorContext(DBSCANClusterer.class, 97, 3682, 4407);
        try {
            if (eps < 0.0) {
                throw new NotPositiveException(eps);
            }
            if (minPts < 0) {
                throw new NotPositiveException(minPts);
            }
            this.eps = eps;
            CallChecker.varAssign(this.eps, "this.eps", 107, 4357, 4371);
            this.minPts = minPts;
            CallChecker.varAssign(this.minPts, "this.minPts", 108, 4381, 4401);
        } finally {
            _bcornu_methode_context275.methodEnd();
        }
    }

    public double getEps() {
        MethodContext _bcornu_methode_context1203 = new MethodContext(double.class, 115, 4414, 4601);
        try {
            CallChecker.varInit(this, "this", 115, 4414, 4601);
            CallChecker.varInit(this.minPts, "minPts", 115, 4414, 4601);
            CallChecker.varInit(this.eps, "eps", 115, 4414, 4601);
            return eps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1203.methodEnd();
        }
    }

    public int getMinPts() {
        MethodContext _bcornu_methode_context1204 = new MethodContext(int.class, 123, 4608, 4803);
        try {
            CallChecker.varInit(this, "this", 123, 4608, 4803);
            CallChecker.varInit(this.minPts, "minPts", 123, 4608, 4803);
            CallChecker.varInit(this.eps, "eps", 123, 4608, 4803);
            return minPts;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1204.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points) throws NullArgumentException {
        MethodContext _bcornu_methode_context1205 = new MethodContext(List.class, 134, 4810, 5921);
        try {
            CallChecker.varInit(this, "this", 134, 4810, 5921);
            CallChecker.varInit(points, "points", 134, 4810, 5921);
            CallChecker.varInit(this.minPts, "minPts", 134, 4810, 5921);
            CallChecker.varInit(this.eps, "eps", 134, 4810, 5921);
            MathUtils.checkNotNull(points);
            final List<Cluster<T>> clusters = CallChecker.varInit(new ArrayList<Cluster<T>>(), "clusters", 139, 5184, 5245);
            final Map<Clusterable, DBSCANClusterer.PointStatus> visited = CallChecker.varInit(new HashMap<Clusterable, DBSCANClusterer.PointStatus>(), "visited", 140, 5255, 5340);
            if (CallChecker.beforeDeref(points, List.class, 142, 5372, 5377)) {
                for (final T point : points) {
                    if (CallChecker.beforeDeref(visited, Map.class, 143, 5398, 5404)) {
                        if ((CallChecker.isCalled(visited, Map.class, 143, 5398, 5404).get(point)) != null) {
                            continue;
                        }
                    }
                    final List<T> neighbors = CallChecker.varInit(getNeighbors(point, points), "neighbors", 146, 5480, 5533);
                    if (CallChecker.beforeDeref(neighbors, List.class, 147, 5551, 5559)) {
                        if ((CallChecker.isCalled(neighbors, List.class, 147, 5551, 5559).size()) >= (minPts)) {
                            final Cluster<T> cluster = CallChecker.varInit(new Cluster<T>(), "cluster", 149, 5597, 5700);
                            if (CallChecker.beforeDeref(clusters, List.class, 150, 5718, 5725)) {
                                CallChecker.isCalled(clusters, List.class, 150, 5718, 5725).add(expandCluster(cluster, point, neighbors, points, visited));
                            }
                        }else {
                            if (CallChecker.beforeDeref(visited, Map.class, 152, 5828, 5834)) {
                                CallChecker.isCalled(visited, Map.class, 152, 5828, 5834).put(point, DBSCANClusterer.PointStatus.NOISE);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Cluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1205.methodEnd();
        }
    }

    private Cluster<T> expandCluster(final Cluster<T> cluster, final T point, final List<T> neighbors, final Collection<T> points, final Map<Clusterable, DBSCANClusterer.PointStatus> visited) {
        MethodContext _bcornu_methode_context1206 = new MethodContext(Cluster.class, 169, 5928, 7450);
        try {
            CallChecker.varInit(this, "this", 169, 5928, 7450);
            CallChecker.varInit(visited, "visited", 169, 5928, 7450);
            CallChecker.varInit(points, "points", 169, 5928, 7450);
            CallChecker.varInit(neighbors, "neighbors", 169, 5928, 7450);
            CallChecker.varInit(point, "point", 169, 5928, 7450);
            CallChecker.varInit(cluster, "cluster", 169, 5928, 7450);
            CallChecker.varInit(this.minPts, "minPts", 169, 5928, 7450);
            CallChecker.varInit(this.eps, "eps", 169, 5928, 7450);
            if (CallChecker.beforeDeref(cluster, Cluster.class, 174, 6596, 6602)) {
                CallChecker.isCalled(cluster, Cluster.class, 174, 6596, 6602).addPoint(point);
            }
            if (CallChecker.beforeDeref(visited, Map.class, 175, 6629, 6635)) {
                CallChecker.isCalled(visited, Map.class, 175, 6629, 6635).put(point, DBSCANClusterer.PointStatus.PART_OF_CLUSTER);
            }
            List<T> seeds = CallChecker.varInit(new ArrayList<T>(neighbors), "seeds", 177, 6687, 6730);
            int index = CallChecker.varInit(((int) (0)), "index", 178, 6740, 6753);
            seeds = CallChecker.beforeCalled(seeds, List.class, 179, 6778, 6782);
            while (index < (CallChecker.isCalled(seeds, List.class, 179, 6778, 6782).size())) {
                final T current = CallChecker.varInit(seeds.get(index), "current", 180, 6806, 6840);
                DBSCANClusterer.PointStatus pStatus = CallChecker.init(DBSCANClusterer.PointStatus.class);
                if (CallChecker.beforeDeref(visited, Map.class, 181, 6876, 6882)) {
                    pStatus = CallChecker.isCalled(visited, Map.class, 181, 6876, 6882).get(current);
                    CallChecker.varAssign(pStatus, "pStatus", 181, 6876, 6882);
                }
                if (pStatus == null) {
                    final List<T> currentNeighbors = CallChecker.varInit(getNeighbors(current, points), "currentNeighbors", 184, 6994, 7056);
                    if (CallChecker.beforeDeref(currentNeighbors, List.class, 185, 7078, 7093)) {
                        if ((CallChecker.isCalled(currentNeighbors, List.class, 185, 7078, 7093).size()) >= (minPts)) {
                            seeds = merge(seeds, currentNeighbors);
                            CallChecker.varAssign(seeds, "seeds", 186, 7135, 7173);
                        }
                    }
                }
                if (pStatus != (DBSCANClusterer.PointStatus.PART_OF_CLUSTER)) {
                    if (CallChecker.beforeDeref(visited, Map.class, 191, 7282, 7288)) {
                        CallChecker.isCalled(visited, Map.class, 191, 7282, 7288).put(current, DBSCANClusterer.PointStatus.PART_OF_CLUSTER);
                    }
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 192, 7349, 7355)) {
                        CallChecker.isCalled(cluster, Cluster.class, 192, 7349, 7355).addPoint(current);
                    }
                }
                index++;
            } 
            return cluster;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Cluster<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1206.methodEnd();
        }
    }

    private List<T> getNeighbors(final T point, final Collection<T> points) {
        MethodContext _bcornu_methode_context1207 = new MethodContext(List.class, 207, 7457, 8010);
        try {
            CallChecker.varInit(this, "this", 207, 7457, 8010);
            CallChecker.varInit(points, "points", 207, 7457, 8010);
            CallChecker.varInit(point, "point", 207, 7457, 8010);
            CallChecker.varInit(this.minPts, "minPts", 207, 7457, 8010);
            CallChecker.varInit(this.eps, "eps", 207, 7457, 8010);
            final List<T> neighbors = CallChecker.varInit(new ArrayList<T>(), "neighbors", 208, 7754, 7798);
            if (CallChecker.beforeDeref(points, List.class, 209, 7832, 7837)) {
                for (final T neighbor : points) {
                    if ((point != neighbor) && ((distance(neighbor, point)) <= (eps))) {
                        if (CallChecker.beforeDeref(neighbors, List.class, 211, 7931, 7939)) {
                            CallChecker.isCalled(neighbors, List.class, 211, 7931, 7939).add(neighbor);
                        }
                    }
                }
            }
            return neighbors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1207.methodEnd();
        }
    }

    private List<T> merge(final List<T> one, final List<T> two) {
        MethodContext _bcornu_methode_context1208 = new MethodContext(List.class, 224, 8017, 8424);
        try {
            CallChecker.varInit(this, "this", 224, 8017, 8424);
            CallChecker.varInit(two, "two", 224, 8017, 8424);
            CallChecker.varInit(one, "one", 224, 8017, 8424);
            CallChecker.varInit(this.minPts, "minPts", 224, 8017, 8424);
            CallChecker.varInit(this.eps, "eps", 224, 8017, 8424);
            final Set<T> oneSet = CallChecker.varInit(new HashSet<T>(one), "oneSet", 225, 8231, 8272);
            if (CallChecker.beforeDeref(two, List.class, 226, 8296, 8298)) {
                for (T item : two) {
                    if (CallChecker.beforeDeref(oneSet, Set.class, 227, 8320, 8325)) {
                        if (!(CallChecker.isCalled(oneSet, Set.class, 227, 8320, 8325).contains(item))) {
                            if (CallChecker.beforeDeref(one, List.class, 228, 8361, 8363)) {
                                CallChecker.isCalled(one, List.class, 228, 8361, 8363).add(item);
                            }
                        }
                    }
                }
            }
            return one;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1208.methodEnd();
        }
    }
}

