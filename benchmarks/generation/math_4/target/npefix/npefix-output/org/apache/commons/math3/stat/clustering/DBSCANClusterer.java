package org.apache.commons.math3.stat.clustering;

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
import org.apache.commons.math3.util.MathUtils;

@Deprecated
public class DBSCANClusterer<T extends Clusterable<T>> {
    private enum PointStatus {
NOISE, PART_OF_CLUSTER;    }

    private final double eps;

    private final int minPts;

    public DBSCANClusterer(final double eps, final int minPts) throws NotPositiveException {
        ConstructorContext _bcornu_methode_context273 = new ConstructorContext(DBSCANClusterer.class, 87, 3358, 3977);
        try {
            if (eps < 0.0) {
                throw new NotPositiveException(eps);
            }
            if (minPts < 0) {
                throw new NotPositiveException(minPts);
            }
            this.eps = eps;
            CallChecker.varAssign(this.eps, "this.eps", 95, 3927, 3941);
            this.minPts = minPts;
            CallChecker.varAssign(this.minPts, "this.minPts", 96, 3951, 3971);
        } finally {
            _bcornu_methode_context273.methodEnd();
        }
    }

    public double getEps() {
        MethodContext _bcornu_methode_context1197 = new MethodContext(double.class, 104, 3984, 4178);
        try {
            CallChecker.varInit(this, "this", 104, 3984, 4178);
            CallChecker.varInit(this.minPts, "minPts", 104, 3984, 4178);
            CallChecker.varInit(this.eps, "eps", 104, 3984, 4178);
            return eps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1197.methodEnd();
        }
    }

    public int getMinPts() {
        MethodContext _bcornu_methode_context1198 = new MethodContext(int.class, 113, 4185, 4387);
        try {
            CallChecker.varInit(this, "this", 113, 4185, 4387);
            CallChecker.varInit(this.minPts, "minPts", 113, 4185, 4387);
            CallChecker.varInit(this.eps, "eps", 113, 4185, 4387);
            return minPts;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1198.methodEnd();
        }
    }

    public List<Cluster<T>> cluster(final Collection<T> points) throws NullArgumentException {
        MethodContext _bcornu_methode_context1199 = new MethodContext(List.class, 128, 4394, 5742);
        try {
            CallChecker.varInit(this, "this", 128, 4394, 5742);
            CallChecker.varInit(points, "points", 128, 4394, 5742);
            CallChecker.varInit(this.minPts, "minPts", 128, 4394, 5742);
            CallChecker.varInit(this.eps, "eps", 128, 4394, 5742);
            MathUtils.checkNotNull(points);
            final List<Cluster<T>> clusters = CallChecker.varInit(new ArrayList<Cluster<T>>(), "clusters", 133, 4995, 5056);
            final Map<Clusterable<T>, DBSCANClusterer.PointStatus> visited = CallChecker.varInit(new HashMap<Clusterable<T>, DBSCANClusterer.PointStatus>(), "visited", 134, 5066, 5157);
            if (CallChecker.beforeDeref(points, List.class, 136, 5189, 5194)) {
                for (final T point : points) {
                    if (CallChecker.beforeDeref(visited, Map.class, 137, 5215, 5221)) {
                        if ((CallChecker.isCalled(visited, Map.class, 137, 5215, 5221).get(point)) != null) {
                            continue;
                        }
                    }
                    final List<T> neighbors = CallChecker.varInit(getNeighbors(point, points), "neighbors", 140, 5297, 5350);
                    if (CallChecker.beforeDeref(neighbors, List.class, 141, 5368, 5376)) {
                        if ((CallChecker.isCalled(neighbors, List.class, 141, 5368, 5376).size()) >= (minPts)) {
                            final Cluster<T> cluster = CallChecker.varInit(new Cluster<T>(null), "cluster", 143, 5414, 5521);
                            if (CallChecker.beforeDeref(clusters, List.class, 144, 5539, 5546)) {
                                CallChecker.isCalled(clusters, List.class, 144, 5539, 5546).add(expandCluster(cluster, point, neighbors, points, visited));
                            }
                        }else {
                            if (CallChecker.beforeDeref(visited, Map.class, 146, 5649, 5655)) {
                                CallChecker.isCalled(visited, Map.class, 146, 5649, 5655).put(point, DBSCANClusterer.PointStatus.NOISE);
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
            _bcornu_methode_context1199.methodEnd();
        }
    }

    private Cluster<T> expandCluster(final Cluster<T> cluster, final T point, final List<T> neighbors, final Collection<T> points, final Map<Clusterable<T>, DBSCANClusterer.PointStatus> visited) {
        MethodContext _bcornu_methode_context1200 = new MethodContext(Cluster.class, 163, 5749, 7274);
        try {
            CallChecker.varInit(this, "this", 163, 5749, 7274);
            CallChecker.varInit(visited, "visited", 163, 5749, 7274);
            CallChecker.varInit(points, "points", 163, 5749, 7274);
            CallChecker.varInit(neighbors, "neighbors", 163, 5749, 7274);
            CallChecker.varInit(point, "point", 163, 5749, 7274);
            CallChecker.varInit(cluster, "cluster", 163, 5749, 7274);
            CallChecker.varInit(this.minPts, "minPts", 163, 5749, 7274);
            CallChecker.varInit(this.eps, "eps", 163, 5749, 7274);
            if (CallChecker.beforeDeref(cluster, Cluster.class, 168, 6420, 6426)) {
                CallChecker.isCalled(cluster, Cluster.class, 168, 6420, 6426).addPoint(point);
            }
            if (CallChecker.beforeDeref(visited, Map.class, 169, 6453, 6459)) {
                CallChecker.isCalled(visited, Map.class, 169, 6453, 6459).put(point, DBSCANClusterer.PointStatus.PART_OF_CLUSTER);
            }
            List<T> seeds = CallChecker.varInit(new ArrayList<T>(neighbors), "seeds", 171, 6511, 6554);
            int index = CallChecker.varInit(((int) (0)), "index", 172, 6564, 6577);
            seeds = CallChecker.beforeCalled(seeds, List.class, 173, 6602, 6606);
            while (index < (CallChecker.isCalled(seeds, List.class, 173, 6602, 6606).size())) {
                final T current = CallChecker.varInit(seeds.get(index), "current", 174, 6630, 6664);
                DBSCANClusterer.PointStatus pStatus = CallChecker.init(DBSCANClusterer.PointStatus.class);
                if (CallChecker.beforeDeref(visited, Map.class, 175, 6700, 6706)) {
                    pStatus = CallChecker.isCalled(visited, Map.class, 175, 6700, 6706).get(current);
                    CallChecker.varAssign(pStatus, "pStatus", 175, 6700, 6706);
                }
                if (pStatus == null) {
                    final List<T> currentNeighbors = CallChecker.varInit(getNeighbors(current, points), "currentNeighbors", 178, 6818, 6880);
                    if (CallChecker.beforeDeref(currentNeighbors, List.class, 179, 6902, 6917)) {
                        if ((CallChecker.isCalled(currentNeighbors, List.class, 179, 6902, 6917).size()) >= (minPts)) {
                            seeds = merge(seeds, currentNeighbors);
                            CallChecker.varAssign(seeds, "seeds", 180, 6959, 6997);
                        }
                    }
                }
                if (pStatus != (DBSCANClusterer.PointStatus.PART_OF_CLUSTER)) {
                    if (CallChecker.beforeDeref(visited, Map.class, 185, 7106, 7112)) {
                        CallChecker.isCalled(visited, Map.class, 185, 7106, 7112).put(current, DBSCANClusterer.PointStatus.PART_OF_CLUSTER);
                    }
                    if (CallChecker.beforeDeref(cluster, Cluster.class, 186, 7173, 7179)) {
                        CallChecker.isCalled(cluster, Cluster.class, 186, 7173, 7179).addPoint(current);
                    }
                }
                index++;
            } 
            return cluster;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Cluster<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1200.methodEnd();
        }
    }

    private List<T> getNeighbors(final T point, final Collection<T> points) {
        MethodContext _bcornu_methode_context1201 = new MethodContext(List.class, 201, 7281, 7837);
        try {
            CallChecker.varInit(this, "this", 201, 7281, 7837);
            CallChecker.varInit(points, "points", 201, 7281, 7837);
            CallChecker.varInit(point, "point", 201, 7281, 7837);
            CallChecker.varInit(this.minPts, "minPts", 201, 7281, 7837);
            CallChecker.varInit(this.eps, "eps", 201, 7281, 7837);
            final List<T> neighbors = CallChecker.varInit(new ArrayList<T>(), "neighbors", 202, 7578, 7622);
            if (CallChecker.beforeDeref(points, List.class, 203, 7656, 7661)) {
                for (final T neighbor : points) {
                    if (CallChecker.beforeDeref(neighbor, null, 204, 7703, 7710)) {
                        if ((point != neighbor) && ((neighbor.distanceFrom(point)) <= (eps))) {
                            if (CallChecker.beforeDeref(neighbors, List.class, 205, 7758, 7766)) {
                                CallChecker.isCalled(neighbors, List.class, 205, 7758, 7766).add(neighbor);
                            }
                        }
                    }
                }
            }
            return neighbors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1201.methodEnd();
        }
    }

    private List<T> merge(final List<T> one, final List<T> two) {
        MethodContext _bcornu_methode_context1202 = new MethodContext(List.class, 218, 7844, 8251);
        try {
            CallChecker.varInit(this, "this", 218, 7844, 8251);
            CallChecker.varInit(two, "two", 218, 7844, 8251);
            CallChecker.varInit(one, "one", 218, 7844, 8251);
            CallChecker.varInit(this.minPts, "minPts", 218, 7844, 8251);
            CallChecker.varInit(this.eps, "eps", 218, 7844, 8251);
            final Set<T> oneSet = CallChecker.varInit(new HashSet<T>(one), "oneSet", 219, 8058, 8099);
            if (CallChecker.beforeDeref(two, List.class, 220, 8123, 8125)) {
                for (T item : two) {
                    if (CallChecker.beforeDeref(oneSet, Set.class, 221, 8147, 8152)) {
                        if (!(CallChecker.isCalled(oneSet, Set.class, 221, 8147, 8152).contains(item))) {
                            if (CallChecker.beforeDeref(one, List.class, 222, 8188, 8190)) {
                                CallChecker.isCalled(one, List.class, 222, 8188, 8190).add(item);
                            }
                        }
                    }
                }
            }
            return one;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1202.methodEnd();
        }
    }
}

