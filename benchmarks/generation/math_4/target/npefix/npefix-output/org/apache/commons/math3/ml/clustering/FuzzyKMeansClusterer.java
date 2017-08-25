package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class FuzzyKMeansClusterer<T extends Clusterable> extends Clusterer<T> {
    private static final double DEFAULT_EPSILON = 0.001;

    private final int k;

    private final int maxIterations;

    private final double fuzziness;

    private final double epsilon;

    private final RandomGenerator random;

    private double[][] membershipMatrix;

    private List<T> points;

    private List<CentroidCluster<T>> clusters;

    public FuzzyKMeansClusterer(final int k, final double fuzziness) throws NumberIsTooSmallException {
        this(k, fuzziness, (-1), new EuclideanDistance());
        ConstructorContext _bcornu_methode_context741 = new ConstructorContext(FuzzyKMeansClusterer.class, 107, 3809, 4327);
        try {
        } finally {
            _bcornu_methode_context741.methodEnd();
        }
    }

    public FuzzyKMeansClusterer(final int k, final double fuzziness, final int maxIterations, final DistanceMeasure measure) throws NumberIsTooSmallException {
        this(k, fuzziness, maxIterations, measure, FuzzyKMeansClusterer.DEFAULT_EPSILON, new JDKRandomGenerator());
        ConstructorContext _bcornu_methode_context742 = new ConstructorContext(FuzzyKMeansClusterer.class, 121, 4334, 5091);
        try {
        } finally {
            _bcornu_methode_context742.methodEnd();
        }
    }

    public FuzzyKMeansClusterer(final int k, final double fuzziness, final int maxIterations, final DistanceMeasure measure, final double epsilon, final RandomGenerator random) throws NumberIsTooSmallException {
        super(measure);
        ConstructorContext _bcornu_methode_context743 = new ConstructorContext(FuzzyKMeansClusterer.class, 139, 5098, 6383);
        try {
            if (fuzziness <= 1.0) {
                throw new NumberIsTooSmallException(fuzziness, 1.0, false);
            }
            this.k = k;
            CallChecker.varAssign(this.k, "this.k", 149, 6128, 6138);
            this.fuzziness = fuzziness;
            CallChecker.varAssign(this.fuzziness, "this.fuzziness", 150, 6148, 6174);
            this.maxIterations = maxIterations;
            CallChecker.varAssign(this.maxIterations, "this.maxIterations", 151, 6184, 6218);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 152, 6228, 6250);
            this.random = random;
            CallChecker.varAssign(this.random, "this.random", 153, 6260, 6280);
            this.membershipMatrix = null;
            CallChecker.varAssign(this.membershipMatrix, "this.membershipMatrix", 155, 6291, 6319);
            this.points = null;
            CallChecker.varAssign(this.points, "this.points", 156, 6329, 6347);
            this.clusters = null;
            CallChecker.varAssign(this.clusters, "this.clusters", 157, 6357, 6377);
        } finally {
            _bcornu_methode_context743.methodEnd();
        }
    }

    public int getK() {
        MethodContext _bcornu_methode_context3326 = new MethodContext(int.class, 164, 6390, 6547);
        try {
            CallChecker.varInit(this, "this", 164, 6390, 6547);
            CallChecker.varInit(this.clusters, "clusters", 164, 6390, 6547);
            CallChecker.varInit(this.points, "points", 164, 6390, 6547);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 164, 6390, 6547);
            CallChecker.varInit(this.random, "random", 164, 6390, 6547);
            CallChecker.varInit(this.epsilon, "epsilon", 164, 6390, 6547);
            CallChecker.varInit(this.fuzziness, "fuzziness", 164, 6390, 6547);
            CallChecker.varInit(this.maxIterations, "maxIterations", 164, 6390, 6547);
            CallChecker.varInit(this.k, "k", 164, 6390, 6547);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 164, 6390, 6547);
            return k;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3326.methodEnd();
        }
    }

    public double getFuzziness() {
        MethodContext _bcornu_methode_context3327 = new MethodContext(double.class, 172, 6554, 6726);
        try {
            CallChecker.varInit(this, "this", 172, 6554, 6726);
            CallChecker.varInit(this.clusters, "clusters", 172, 6554, 6726);
            CallChecker.varInit(this.points, "points", 172, 6554, 6726);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 172, 6554, 6726);
            CallChecker.varInit(this.random, "random", 172, 6554, 6726);
            CallChecker.varInit(this.epsilon, "epsilon", 172, 6554, 6726);
            CallChecker.varInit(this.fuzziness, "fuzziness", 172, 6554, 6726);
            CallChecker.varInit(this.maxIterations, "maxIterations", 172, 6554, 6726);
            CallChecker.varInit(this.k, "k", 172, 6554, 6726);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 172, 6554, 6726);
            return fuzziness;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3327.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context3328 = new MethodContext(int.class, 180, 6733, 6963);
        try {
            CallChecker.varInit(this, "this", 180, 6733, 6963);
            CallChecker.varInit(this.clusters, "clusters", 180, 6733, 6963);
            CallChecker.varInit(this.points, "points", 180, 6733, 6963);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 180, 6733, 6963);
            CallChecker.varInit(this.random, "random", 180, 6733, 6963);
            CallChecker.varInit(this.epsilon, "epsilon", 180, 6733, 6963);
            CallChecker.varInit(this.fuzziness, "fuzziness", 180, 6733, 6963);
            CallChecker.varInit(this.maxIterations, "maxIterations", 180, 6733, 6963);
            CallChecker.varInit(this.k, "k", 180, 6733, 6963);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 180, 6733, 6963);
            return maxIterations;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3328.methodEnd();
        }
    }

    public double getEpsilon() {
        MethodContext _bcornu_methode_context3329 = new MethodContext(double.class, 188, 6970, 7146);
        try {
            CallChecker.varInit(this, "this", 188, 6970, 7146);
            CallChecker.varInit(this.clusters, "clusters", 188, 6970, 7146);
            CallChecker.varInit(this.points, "points", 188, 6970, 7146);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 188, 6970, 7146);
            CallChecker.varInit(this.random, "random", 188, 6970, 7146);
            CallChecker.varInit(this.epsilon, "epsilon", 188, 6970, 7146);
            CallChecker.varInit(this.fuzziness, "fuzziness", 188, 6970, 7146);
            CallChecker.varInit(this.maxIterations, "maxIterations", 188, 6970, 7146);
            CallChecker.varInit(this.k, "k", 188, 6970, 7146);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 188, 6970, 7146);
            return epsilon;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3329.methodEnd();
        }
    }

    public RandomGenerator getRandomGenerator() {
        MethodContext _bcornu_methode_context3330 = new MethodContext(RandomGenerator.class, 196, 7153, 7338);
        try {
            CallChecker.varInit(this, "this", 196, 7153, 7338);
            CallChecker.varInit(this.clusters, "clusters", 196, 7153, 7338);
            CallChecker.varInit(this.points, "points", 196, 7153, 7338);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 196, 7153, 7338);
            CallChecker.varInit(this.random, "random", 196, 7153, 7338);
            CallChecker.varInit(this.epsilon, "epsilon", 196, 7153, 7338);
            CallChecker.varInit(this.fuzziness, "fuzziness", 196, 7153, 7338);
            CallChecker.varInit(this.maxIterations, "maxIterations", 196, 7153, 7338);
            CallChecker.varInit(this.k, "k", 196, 7153, 7338);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 196, 7153, 7338);
            return random;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RandomGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3330.methodEnd();
        }
    }

    public RealMatrix getMembershipMatrix() {
        MethodContext _bcornu_methode_context3331 = new MethodContext(RealMatrix.class, 210, 7345, 7987);
        try {
            CallChecker.varInit(this, "this", 210, 7345, 7987);
            CallChecker.varInit(this.clusters, "clusters", 210, 7345, 7987);
            CallChecker.varInit(this.points, "points", 210, 7345, 7987);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 210, 7345, 7987);
            CallChecker.varInit(this.random, "random", 210, 7345, 7987);
            CallChecker.varInit(this.epsilon, "epsilon", 210, 7345, 7987);
            CallChecker.varInit(this.fuzziness, "fuzziness", 210, 7345, 7987);
            CallChecker.varInit(this.maxIterations, "maxIterations", 210, 7345, 7987);
            CallChecker.varInit(this.k, "k", 210, 7345, 7987);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 210, 7345, 7987);
            if ((membershipMatrix) == null) {
                throw new MathIllegalStateException();
            }
            return MatrixUtils.createRealMatrix(membershipMatrix);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3331.methodEnd();
        }
    }

    public List<T> getDataPoints() {
        MethodContext _bcornu_methode_context3332 = new MethodContext(List.class, 223, 7994, 8312);
        try {
            CallChecker.varInit(this, "this", 223, 7994, 8312);
            CallChecker.varInit(this.clusters, "clusters", 223, 7994, 8312);
            CallChecker.varInit(this.points, "points", 223, 7994, 8312);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 223, 7994, 8312);
            CallChecker.varInit(this.random, "random", 223, 7994, 8312);
            CallChecker.varInit(this.epsilon, "epsilon", 223, 7994, 8312);
            CallChecker.varInit(this.fuzziness, "fuzziness", 223, 7994, 8312);
            CallChecker.varInit(this.maxIterations, "maxIterations", 223, 7994, 8312);
            CallChecker.varInit(this.k, "k", 223, 7994, 8312);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 223, 7994, 8312);
            return points;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3332.methodEnd();
        }
    }

    public List<CentroidCluster<T>> getClusters() {
        MethodContext _bcornu_methode_context3333 = new MethodContext(List.class, 232, 8319, 8632);
        try {
            CallChecker.varInit(this, "this", 232, 8319, 8632);
            CallChecker.varInit(this.clusters, "clusters", 232, 8319, 8632);
            CallChecker.varInit(this.points, "points", 232, 8319, 8632);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 232, 8319, 8632);
            CallChecker.varInit(this.random, "random", 232, 8319, 8632);
            CallChecker.varInit(this.epsilon, "epsilon", 232, 8319, 8632);
            CallChecker.varInit(this.fuzziness, "fuzziness", 232, 8319, 8632);
            CallChecker.varInit(this.maxIterations, "maxIterations", 232, 8319, 8632);
            CallChecker.varInit(this.k, "k", 232, 8319, 8632);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 232, 8319, 8632);
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<CentroidCluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3333.methodEnd();
        }
    }

    public double getObjectiveFunctionValue() {
        MethodContext _bcornu_methode_context3334 = new MethodContext(double.class, 241, 8639, 9467);
        try {
            CallChecker.varInit(this, "this", 241, 8639, 9467);
            CallChecker.varInit(this.clusters, "clusters", 241, 8639, 9467);
            CallChecker.varInit(this.points, "points", 241, 8639, 9467);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 241, 8639, 9467);
            CallChecker.varInit(this.random, "random", 241, 8639, 9467);
            CallChecker.varInit(this.epsilon, "epsilon", 241, 8639, 9467);
            CallChecker.varInit(this.fuzziness, "fuzziness", 241, 8639, 9467);
            CallChecker.varInit(this.maxIterations, "maxIterations", 241, 8639, 9467);
            CallChecker.varInit(this.k, "k", 241, 8639, 9467);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 241, 8639, 9467);
            if (((points) == null) || ((clusters) == null)) {
                throw new MathIllegalStateException();
            }
            int i = CallChecker.varInit(((int) (0)), "i", 246, 9032, 9041);
            double objFunction = CallChecker.varInit(((double) (0.0)), "objFunction", 247, 9051, 9075);
            for (final T point : points) {
                int j = CallChecker.varInit(((int) (0)), "j", 249, 9128, 9137);
                for (final CentroidCluster<T> cluster : clusters) {
                    final double dist = CallChecker.varInit(((double) (distance(point, CallChecker.isCalled(cluster, CentroidCluster.class, 251, 9255, 9261).getCenter()))), "dist", 251, 9219, 9275);
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 252, 9337, 9352)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 252, 9337, 9352);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 252, 9337, 9352)[i], double[].class, 252, 9337, 9355)) {
                            membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 252, 9337, 9352);
                            CallChecker.isCalled(membershipMatrix, double[][].class, 252, 9337, 9352)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 252, 9337, 9352)[i], double[].class, 252, 9337, 9355);
                            objFunction += (dist * dist) * (FastMath.pow(CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 252, 9337, 9352)[i], double[].class, 252, 9337, 9355)[j], fuzziness));
                            CallChecker.varAssign(objFunction, "objFunction", 252, 9293, 9371);
                        }
                    }
                    j++;
                }
                i++;
            }
            return objFunction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3334.methodEnd();
        }
    }

    public List<CentroidCluster<T>> cluster(final Collection<T> dataPoints) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3335 = new MethodContext(List.class, 268, 9474, 11377);
        try {
            CallChecker.varInit(this, "this", 268, 9474, 11377);
            CallChecker.varInit(dataPoints, "dataPoints", 268, 9474, 11377);
            CallChecker.varInit(this.clusters, "clusters", 268, 9474, 11377);
            CallChecker.varInit(this.points, "points", 268, 9474, 11377);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 268, 9474, 11377);
            CallChecker.varInit(this.random, "random", 268, 9474, 11377);
            CallChecker.varInit(this.epsilon, "epsilon", 268, 9474, 11377);
            CallChecker.varInit(this.fuzziness, "fuzziness", 268, 9474, 11377);
            CallChecker.varInit(this.maxIterations, "maxIterations", 268, 9474, 11377);
            CallChecker.varInit(this.k, "k", 268, 9474, 11377);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 268, 9474, 11377);
            MathUtils.checkNotNull(dataPoints);
            final int size = CallChecker.varInit(((int) (CallChecker.isCalled(dataPoints, Collection.class, 274, 9996, 10005).size())), "size", 274, 9979, 10013);
            if (size < (k)) {
                throw new NumberIsTooSmallException(size, k, false);
            }
            points = Collections.unmodifiableList(new ArrayList<T>(dataPoints));
            CallChecker.varAssign(this.points, "this.points", 282, 10288, 10355);
            clusters = new ArrayList<CentroidCluster<T>>();
            CallChecker.varAssign(this.clusters, "this.clusters", 283, 10365, 10411);
            membershipMatrix = new double[size][k];
            CallChecker.varAssign(this.membershipMatrix, "this.membershipMatrix", 284, 10421, 10459);
            final double[][] oldMatrix = CallChecker.varInit(new double[size][k], "oldMatrix", 285, 10469, 10517);
            if (size == 0) {
                return clusters;
            }
            initializeMembershipMatrix();
            final int pointDimension = CallChecker.varInit(((int) (CallChecker.isCalled(this.points.get(0).getPoint(), double[].class, 295, 10769, 10792).length)), "pointDimension", 295, 10703, 10800);
            for (int i = 0; i < (k); i++) {
                if (CallChecker.beforeDeref(clusters, List.class, 297, 10852, 10859)) {
                    clusters = CallChecker.beforeCalled(clusters, List.class, 297, 10852, 10859);
                    CallChecker.isCalled(clusters, List.class, 297, 10852, 10859).add(new CentroidCluster<T>(new DoublePoint(new double[pointDimension])));
                }
            }
            int iteration = CallChecker.varInit(((int) (0)), "iteration", 300, 10954, 10971);
            int max = CallChecker.init(int.class);
            if ((maxIterations) < 0) {
                max = Integer.MAX_VALUE;
                CallChecker.varAssign(max, "max", 301, 10997, 11051);
            }else {
                max = maxIterations;
                CallChecker.varAssign(max, "max", 301, 10997, 11051);
            }
            double difference = CallChecker.varInit(((double) (0.0)), "difference", 302, 11062, 11085);
            do {
                saveMembershipMatrix(oldMatrix);
                updateClusterCenters();
                updateMembershipMatrix();
                difference = calculateMaxMembershipChange(oldMatrix);
                CallChecker.varAssign(difference, "difference", 308, 11232, 11284);
            } while ((difference > (epsilon)) && ((++iteration) < max) );
            return clusters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<CentroidCluster<T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3335.methodEnd();
        }
    }

    private void updateClusterCenters() {
        MethodContext _bcornu_methode_context3336 = new MethodContext(void.class, 317, 11384, 12414);
        try {
            CallChecker.varInit(this, "this", 317, 11384, 12414);
            CallChecker.varInit(this.clusters, "clusters", 317, 11384, 12414);
            CallChecker.varInit(this.points, "points", 317, 11384, 12414);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 317, 11384, 12414);
            CallChecker.varInit(this.random, "random", 317, 11384, 12414);
            CallChecker.varInit(this.epsilon, "epsilon", 317, 11384, 12414);
            CallChecker.varInit(this.fuzziness, "fuzziness", 317, 11384, 12414);
            CallChecker.varInit(this.maxIterations, "maxIterations", 317, 11384, 12414);
            CallChecker.varInit(this.k, "k", 317, 11384, 12414);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 317, 11384, 12414);
            int j = CallChecker.varInit(((int) (0)), "j", 318, 11481, 11490);
            final List<CentroidCluster<T>> newClusters = CallChecker.varInit(new ArrayList<CentroidCluster<T>>(k), "newClusters", 319, 11500, 11581);
            if (CallChecker.beforeDeref(clusters, void.class, 320, 11631, 11638)) {
                for (final CentroidCluster<T> cluster : clusters) {
                    final Clusterable center = CallChecker.varInit(CallChecker.isCalled(cluster, CentroidCluster.class, 321, 11682, 11688).getCenter(), "center", 321, 11655, 11701);
                    int i = CallChecker.varInit(((int) (0)), "i", 322, 11715, 11724);
                    double[] arr = CallChecker.init(double[].class);
                    if (CallChecker.beforeDeref(center, Clusterable.class, 323, 11764, 11769)) {
                        final double[] npe_invocation_var800 = CallChecker.isCalled(center, Clusterable.class, 323, 11764, 11769).getPoint();
                        if (CallChecker.beforeDeref(npe_invocation_var800, double[].class, 323, 11764, 11780)) {
                            arr = new double[CallChecker.isCalled(npe_invocation_var800, double[].class, 323, 11764, 11780).length];
                            CallChecker.varAssign(arr, "arr", 323, 11764, 11769);
                        }
                    }
                    double sum = CallChecker.varInit(((double) (0.0)), "sum", 324, 11803, 11819);
                    if (CallChecker.beforeDeref(points, void.class, 325, 11854, 11859)) {
                        for (final T point : points) {
                            membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 326, 11910, 11925);
                            CallChecker.isCalled(membershipMatrix, double[][].class, 326, 11910, 11925)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 326, 11910, 11925)[i], double[].class, 326, 11910, 11928);
                            final double u = CallChecker.varInit(((double) (FastMath.pow(CallChecker.isCalled(CallChecker.isCalled(this.membershipMatrix, double[][].class, 326, 11910, 11925)[i], double[].class, 326, 11910, 11928)[j], this.fuzziness))), "u", 326, 11880, 11944);
                            final double[] pointArr = CallChecker.varInit(point.getPoint(), "pointArr", 327, 11962, 12004);
                            arr = CallChecker.beforeCalled(arr, double[].class, 328, 12046, 12048);
                            for (int idx = 0; idx < (CallChecker.isCalled(arr, double[].class, 328, 12046, 12048).length); idx++) {
                                if (CallChecker.beforeDeref(arr, double[].class, 329, 12087, 12089)) {
                                    if (CallChecker.beforeDeref(pointArr, double[].class, 329, 12103, 12110)) {
                                        arr = CallChecker.beforeCalled(arr, double[].class, 329, 12087, 12089);
                                        CallChecker.isCalled(arr, double[].class, 329, 12087, 12089)[idx] += u * (CallChecker.isCalled(pointArr, double[].class, 329, 12103, 12110)[idx]);
                                        CallChecker.varAssign(CallChecker.isCalled(arr, double[].class, 329, 12087, 12089)[idx], "CallChecker.isCalled(arr, double[].class, 329, 12087, 12089)[idx]", 329, 12087, 12116);
                                    }
                                }
                            }
                            sum += u;
                            CallChecker.varAssign(sum, "sum", 331, 12152, 12160);
                            i++;
                        }
                    }
                    MathArrays.scaleInPlace((1.0 / sum), arr);
                    if (CallChecker.beforeDeref(newClusters, List.class, 335, 12262, 12272)) {
                        CallChecker.isCalled(newClusters, List.class, 335, 12262, 12272).add(new CentroidCluster<T>(new DoublePoint(arr)));
                    }
                    j++;
                }
            }
            if (CallChecker.beforeDeref(clusters, List.class, 338, 12360, 12367)) {
                clusters = CallChecker.beforeCalled(clusters, List.class, 338, 12360, 12367);
                CallChecker.isCalled(clusters, List.class, 338, 12360, 12367).clear();
            }
            clusters = newClusters;
            CallChecker.varAssign(this.clusters, "this.clusters", 339, 12386, 12408);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3336.methodEnd();
        }
    }

    private void updateMembershipMatrix() {
        MethodContext _bcornu_methode_context3337 = new MethodContext(void.class, 346, 12421, 13502);
        try {
            CallChecker.varInit(this, "this", 346, 12421, 13502);
            CallChecker.varInit(this.clusters, "clusters", 346, 12421, 13502);
            CallChecker.varInit(this.points, "points", 346, 12421, 13502);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 346, 12421, 13502);
            CallChecker.varInit(this.random, "random", 346, 12421, 13502);
            CallChecker.varInit(this.epsilon, "epsilon", 346, 12421, 13502);
            CallChecker.varInit(this.fuzziness, "fuzziness", 346, 12421, 13502);
            CallChecker.varInit(this.maxIterations, "maxIterations", 346, 12421, 13502);
            CallChecker.varInit(this.k, "k", 346, 12421, 13502);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 346, 12421, 13502);
            points = CallChecker.beforeCalled(points, List.class, 347, 12616, 12621);
            for (int i = 0; i < (CallChecker.isCalled(points, List.class, 347, 12616, 12621).size()); i++) {
                final T point = CallChecker.varInit(points.get(i), "point", 348, 12650, 12679);
                double maxMembership = CallChecker.varInit(((double) (0.0)), "maxMembership", 349, 12693, 12719);
                int newCluster = CallChecker.varInit(((int) (-1)), "newCluster", 350, 12733, 12752);
                clusters = CallChecker.beforeCalled(clusters, List.class, 351, 12786, 12793);
                for (int j = 0; j < (CallChecker.isCalled(clusters, List.class, 351, 12786, 12793).size()); j++) {
                    double sum = CallChecker.varInit(((double) (0.0)), "sum", 352, 12826, 12842);
                    clusters = CallChecker.beforeCalled(clusters, List.class, 353, 12910, 12917);
                    final double distA = CallChecker.varInit(((double) (FastMath.abs(distance(point, CallChecker.isCalled(CallChecker.isCalled(this.clusters, List.class, 353, 12910, 12917).get(j), CentroidCluster.class, 353, 12910, 12924).getCenter())))), "distA", 353, 12860, 12939);
                    if (CallChecker.beforeDeref(clusters, void.class, 355, 12992, 12999)) {
                        for (final CentroidCluster<T> c : clusters) {
                            final double distB = CallChecker.varInit(((double) (FastMath.abs(distance(point, CallChecker.isCalled(c, CentroidCluster.class, 356, 13074, 13074).getCenter())))), "distB", 356, 13024, 13089);
                            sum += FastMath.pow((distA / distB), (2.0 / ((fuzziness) - 1.0)));
                            CallChecker.varAssign(sum, "sum", 357, 13111, 13170);
                        }
                    }
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 360, 13207, 13222)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 360, 13207, 13222);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 360, 13207, 13222)[i], double[].class, 360, 13207, 13225)) {
                            membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 360, 13207, 13222);
                            CallChecker.isCalled(membershipMatrix, double[][].class, 360, 13207, 13222)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 360, 13207, 13222)[i], double[].class, 360, 13207, 13225);
                            CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 360, 13207, 13222)[i], double[].class, 360, 13207, 13225)[j] = 1.0 / sum;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.membershipMatrix, double[][].class, 360, 13207, 13222)[i], double[].class, 360, 13207, 13225)[j], "CallChecker.isCalled(CallChecker.isCalled(this.membershipMatrix, double[][].class, 360, 13207, 13222)[i], double[].class, 360, 13207, 13225)[j]", 360, 13207, 13241);
                        }
                    }
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 362, 13264, 13279)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 362, 13264, 13279);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 362, 13264, 13279)[i], double[].class, 362, 13264, 13282)) {
                            membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 362, 13264, 13279);
                            CallChecker.isCalled(membershipMatrix, double[][].class, 362, 13264, 13279)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 362, 13264, 13279)[i], double[].class, 362, 13264, 13282);
                            if ((CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 362, 13264, 13279)[i], double[].class, 362, 13264, 13282)[j]) > maxMembership) {
                                if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 363, 13342, 13357)) {
                                    membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 363, 13342, 13357);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 363, 13342, 13357)[i], double[].class, 363, 13342, 13360)) {
                                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 363, 13342, 13357);
                                        CallChecker.isCalled(membershipMatrix, double[][].class, 363, 13342, 13357)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 363, 13342, 13357)[i], double[].class, 363, 13342, 13360);
                                        maxMembership = CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 363, 13342, 13357)[i], double[].class, 363, 13342, 13360)[j];
                                        CallChecker.varAssign(maxMembership, "maxMembership", 363, 13326, 13364);
                                    }
                                }
                                newCluster = j;
                                CallChecker.varAssign(newCluster, "newCluster", 364, 13386, 13400);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(clusters, List.class, 367, 13446, 13453)) {
                    clusters = CallChecker.beforeCalled(clusters, List.class, 367, 13446, 13453);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clusters, List.class, 367, 13446, 13453).get(newCluster), CentroidCluster.class, 367, 13446, 13469)) {
                        clusters = CallChecker.beforeCalled(clusters, List.class, 367, 13446, 13453);
                        CallChecker.isCalled(CallChecker.isCalled(clusters, List.class, 367, 13446, 13453).get(newCluster), CentroidCluster.class, 367, 13446, 13469).addPoint(point);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3337.methodEnd();
        }
    }

    private void initializeMembershipMatrix() {
        MethodContext _bcornu_methode_context3338 = new MethodContext(void.class, 374, 13509, 13898);
        try {
            CallChecker.varInit(this, "this", 374, 13509, 13898);
            CallChecker.varInit(this.clusters, "clusters", 374, 13509, 13898);
            CallChecker.varInit(this.points, "points", 374, 13509, 13898);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 374, 13509, 13898);
            CallChecker.varInit(this.random, "random", 374, 13509, 13898);
            CallChecker.varInit(this.epsilon, "epsilon", 374, 13509, 13898);
            CallChecker.varInit(this.fuzziness, "fuzziness", 374, 13509, 13898);
            CallChecker.varInit(this.maxIterations, "maxIterations", 374, 13509, 13898);
            CallChecker.varInit(this.k, "k", 374, 13509, 13898);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 374, 13509, 13898);
            points = CallChecker.beforeCalled(points, List.class, 375, 13657, 13662);
            for (int i = 0; i < (CallChecker.isCalled(points, List.class, 375, 13657, 13662).size()); i++) {
                for (int j = 0; j < (k); j++) {
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 377, 13737, 13752)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 377, 13737, 13752);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 377, 13737, 13752)[i], double[].class, 377, 13737, 13755)) {
                            if (CallChecker.beforeDeref(random, RandomGenerator.class, 377, 13762, 13767)) {
                                membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 377, 13737, 13752);
                                CallChecker.isCalled(membershipMatrix, double[][].class, 377, 13737, 13752)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 377, 13737, 13752)[i], double[].class, 377, 13737, 13755);
                                CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 377, 13737, 13752)[i], double[].class, 377, 13737, 13755)[j] = CallChecker.isCalled(random, RandomGenerator.class, 377, 13762, 13767).nextDouble();
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.membershipMatrix, double[][].class, 377, 13737, 13752)[i], double[].class, 377, 13737, 13755)[j], "CallChecker.isCalled(CallChecker.isCalled(this.membershipMatrix, double[][].class, 377, 13737, 13752)[i], double[].class, 377, 13737, 13755)[j]", 377, 13737, 13781);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 379, 13809, 13824)) {
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 379, 13857, 13872)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 379, 13809, 13824);
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 379, 13857, 13872);
                        CallChecker.isCalled(membershipMatrix, double[][].class, 379, 13809, 13824)[i] = MathArrays.normalizeArray(CallChecker.isCalled(membershipMatrix, double[][].class, 379, 13857, 13872)[i], 1.0);
                        CallChecker.varAssign(CallChecker.isCalled(this.membershipMatrix, double[][].class, 379, 13809, 13824)[i], "CallChecker.isCalled(this.membershipMatrix, double[][].class, 379, 13809, 13824)[i]", 379, 13809, 13882);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3338.methodEnd();
        }
    }

    private double calculateMaxMembershipChange(final double[][] matrix) {
        MethodContext _bcornu_methode_context3339 = new MethodContext(double.class, 390, 13905, 14578);
        try {
            CallChecker.varInit(this, "this", 390, 13905, 14578);
            CallChecker.varInit(matrix, "matrix", 390, 13905, 14578);
            CallChecker.varInit(this.clusters, "clusters", 390, 13905, 14578);
            CallChecker.varInit(this.points, "points", 390, 13905, 14578);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 390, 13905, 14578);
            CallChecker.varInit(this.random, "random", 390, 13905, 14578);
            CallChecker.varInit(this.epsilon, "epsilon", 390, 13905, 14578);
            CallChecker.varInit(this.fuzziness, "fuzziness", 390, 13905, 14578);
            CallChecker.varInit(this.maxIterations, "maxIterations", 390, 13905, 14578);
            CallChecker.varInit(this.k, "k", 390, 13905, 14578);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 390, 13905, 14578);
            double maxMembership = CallChecker.varInit(((double) (0.0)), "maxMembership", 391, 14242, 14268);
            points = CallChecker.beforeCalled(points, List.class, 392, 14298, 14303);
            for (int i = 0; i < (CallChecker.isCalled(points, List.class, 392, 14298, 14303).size()); i++) {
                clusters = CallChecker.beforeCalled(clusters, List.class, 393, 14352, 14359);
                for (int j = 0; j < (CallChecker.isCalled(clusters, List.class, 393, 14352, 14359).size()); j++) {
                    double v = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 394, 14416, 14431)) {
                        membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 394, 14416, 14431);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(membershipMatrix, double[][].class, 394, 14416, 14431)[i], double[].class, 394, 14416, 14434)) {
                            if (CallChecker.beforeDeref(matrix, double[][].class, 394, 14441, 14446)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(matrix, double[][].class, 394, 14441, 14446)[i], double[].class, 394, 14441, 14449)) {
                                    membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 394, 14416, 14431);
                                    CallChecker.isCalled(membershipMatrix, double[][].class, 394, 14416, 14431)[i] = CallChecker.beforeCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 394, 14416, 14431)[i], double[].class, 394, 14416, 14434);
                                    CallChecker.isCalled(matrix, double[][].class, 394, 14441, 14446)[i] = CallChecker.beforeCalled(CallChecker.isCalled(matrix, double[][].class, 394, 14441, 14446)[i], double[].class, 394, 14441, 14449);
                                    v = FastMath.abs(((CallChecker.isCalled(CallChecker.isCalled(membershipMatrix, double[][].class, 394, 14416, 14431)[i], double[].class, 394, 14416, 14434)[j]) - (CallChecker.isCalled(CallChecker.isCalled(matrix, double[][].class, 394, 14441, 14446)[i], double[].class, 394, 14441, 14449)[j])));
                                    CallChecker.varAssign(v, "v", 394, 14416, 14431);
                                }
                            }
                        }
                    }
                    maxMembership = FastMath.max(v, maxMembership);
                    CallChecker.varAssign(maxMembership, "maxMembership", 395, 14472, 14518);
                }
            }
            return maxMembership;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3339.methodEnd();
        }
    }

    private void saveMembershipMatrix(final double[][] matrix) {
        MethodContext _bcornu_methode_context3340 = new MethodContext(void.class, 406, 14585, 14940);
        try {
            CallChecker.varInit(this, "this", 406, 14585, 14940);
            CallChecker.varInit(matrix, "matrix", 406, 14585, 14940);
            CallChecker.varInit(this.clusters, "clusters", 406, 14585, 14940);
            CallChecker.varInit(this.points, "points", 406, 14585, 14940);
            CallChecker.varInit(this.membershipMatrix, "membershipMatrix", 406, 14585, 14940);
            CallChecker.varInit(this.random, "random", 406, 14585, 14940);
            CallChecker.varInit(this.epsilon, "epsilon", 406, 14585, 14940);
            CallChecker.varInit(this.fuzziness, "fuzziness", 406, 14585, 14940);
            CallChecker.varInit(this.maxIterations, "maxIterations", 406, 14585, 14940);
            CallChecker.varInit(this.k, "k", 406, 14585, 14940);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.ml.clustering.FuzzyKMeansClusterer.DEFAULT_EPSILON", 406, 14585, 14940);
            points = CallChecker.beforeCalled(points, List.class, 407, 14819, 14824);
            for (int i = 0; i < (CallChecker.isCalled(points, List.class, 407, 14819, 14824).size()); i++) {
                if (CallChecker.beforeDeref(membershipMatrix, double[][].class, 408, 14870, 14885)) {
                    if (CallChecker.beforeDeref(matrix, double[][].class, 408, 14894, 14899)) {
                        if (CallChecker.beforeDeref(clusters, List.class, 408, 14908, 14915)) {
                            membershipMatrix = CallChecker.beforeCalled(membershipMatrix, double[][].class, 408, 14870, 14885);
                            clusters = CallChecker.beforeCalled(clusters, List.class, 408, 14908, 14915);
                            System.arraycopy(CallChecker.isCalled(membershipMatrix, double[][].class, 408, 14870, 14885)[i], 0, CallChecker.isCalled(matrix, double[][].class, 408, 14894, 14899)[i], 0, CallChecker.isCalled(clusters, List.class, 408, 14908, 14915).size());
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3340.methodEnd();
        }
    }
}

