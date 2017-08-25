package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class MultiKMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final KMeansPlusPlusClusterer<T> clusterer;

    private final int numTrials;

    public MultiKMeansPlusPlusClusterer(final KMeansPlusPlusClusterer<T> clusterer, final int numTrials) {
        super(CallChecker.isCalled(clusterer, KMeansPlusPlusClusterer.class, 48, 1866, 1874).getDistanceMeasure());
        ConstructorContext _bcornu_methode_context841 = new ConstructorContext(MultiKMeansPlusPlusClusterer.class, 46, 1576, 1975);
        try {
            this.clusterer = clusterer;
            CallChecker.varAssign(this.clusterer, "this.clusterer", 49, 1907, 1933);
            this.numTrials = numTrials;
            CallChecker.varAssign(this.numTrials, "this.numTrials", 50, 1943, 1969);
        } finally {
            _bcornu_methode_context841.methodEnd();
        }
    }

    public KMeansPlusPlusClusterer<T> getClusterer() {
        MethodContext _bcornu_methode_context3665 = new MethodContext(KMeansPlusPlusClusterer.class, 57, 1982, 2186);
        try {
            CallChecker.varInit(this, "this", 57, 1982, 2186);
            CallChecker.varInit(this.numTrials, "numTrials", 57, 1982, 2186);
            CallChecker.varInit(this.clusterer, "clusterer", 57, 1982, 2186);
            return clusterer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((KMeansPlusPlusClusterer<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3665.methodEnd();
        }
    }

    public int getNumTrials() {
        MethodContext _bcornu_methode_context3666 = new MethodContext(int.class, 65, 2193, 2362);
        try {
            CallChecker.varInit(this, "this", 65, 2193, 2362);
            CallChecker.varInit(this.numTrials, "numTrials", 65, 2193, 2362);
            CallChecker.varInit(this.clusterer, "clusterer", 65, 2193, 2362);
            return numTrials;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3666.methodEnd();
        }
    }

    public List<CentroidCluster<T>> cluster(final Collection<T> points) throws ConvergenceException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3667 = new MethodContext(List.class, 80, 2369, 4386);
        try {
            CallChecker.varInit(this, "this", 80, 2369, 4386);
            CallChecker.varInit(points, "points", 80, 2369, 4386);
            CallChecker.varInit(this.numTrials, "numTrials", 80, 2369, 4386);
            CallChecker.varInit(this.clusterer, "clusterer", 80, 2369, 4386);
            List<CentroidCluster<T>> best = CallChecker.varInit(null, "best", 84, 3119, 3155);
            double bestVarianceSum = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "bestVarianceSum", 85, 3165, 3214);
            for (int i = 0; i < (numTrials); ++i) {
                List<CentroidCluster<T>> clusters = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(clusterer, KMeansPlusPlusClusterer.class, 91, 3391, 3399)) {
                    clusters = CallChecker.isCalled(clusterer, KMeansPlusPlusClusterer.class, 91, 3391, 3399).cluster(points);
                    CallChecker.varAssign(clusters, "clusters", 91, 3391, 3399);
                }
                double varianceSum = CallChecker.varInit(((double) (0.0)), "varianceSum", 94, 3487, 3511);
                if (CallChecker.beforeDeref(clusters, List.class, 95, 3565, 3572)) {
                    for (final CentroidCluster<T> cluster : clusters) {
                        if (CallChecker.beforeDeref(cluster, CentroidCluster.class, 96, 3598, 3604)) {
                            final List<T> npe_invocation_var820 = CallChecker.isCalled(cluster, CentroidCluster.class, 96, 3598, 3604).getPoints();
                            if (CallChecker.beforeDeref(npe_invocation_var820, List.class, 96, 3598, 3616)) {
                                if (!(CallChecker.isCalled(npe_invocation_var820, List.class, 96, 3598, 3616).isEmpty())) {
                                    final Clusterable center = CallChecker.varInit(CallChecker.isCalled(cluster, CentroidCluster.class, 99, 3755, 3761).getCenter(), "center", 99, 3652, 3774);
                                    final Variance stat = CallChecker.varInit(new Variance(), "stat", 100, 3796, 3832);
                                    for (final T point : CallChecker.isCalled(cluster, CentroidCluster.class, 101, 3875, 3881).getPoints()) {
                                        if (CallChecker.beforeDeref(stat, Variance.class, 102, 3922, 3925)) {
                                            CallChecker.isCalled(stat, Variance.class, 102, 3922, 3925).increment(distance(point, center));
                                        }
                                    }
                                    if (CallChecker.beforeDeref(stat, Variance.class, 104, 4020, 4023)) {
                                        varianceSum += CallChecker.isCalled(stat, Variance.class, 104, 4020, 4023).getResult();
                                        CallChecker.varAssign(varianceSum, "varianceSum", 104, 4005, 4036);
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
                    CallChecker.varAssign(best, "best", 111, 4212, 4238);
                    bestVarianceSum = varianceSum;
                    CallChecker.varAssign(bestVarianceSum, "bestVarianceSum", 112, 4256, 4285);
                }
            }
            return best;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<CentroidCluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3667.methodEnd();
        }
    }
}

