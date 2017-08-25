package org.apache.commons.math3.stat.inference;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;

public class TestUtils {
    private static final TTest T_TEST = new TTest();

    private static final ChiSquareTest CHI_SQUARE_TEST = new ChiSquareTest();

    private static final OneWayAnova ONE_WAY_ANANOVA = new OneWayAnova();

    private static final GTest G_TEST = new GTest();

    private TestUtils() {
        super();
        ConstructorContext _bcornu_methode_context716 = new ConstructorContext(TestUtils.class, 56, 2205, 2294);
        try {
        } finally {
            _bcornu_methode_context716.methodEnd();
        }
    }

    public static double homoscedasticT(final double[] sample1, final double[] sample2) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3181 = new MethodContext(double.class, 65, 2301, 2664);
        try {
            CallChecker.varInit(sample2, "sample2", 65, 2301, 2664);
            CallChecker.varInit(sample1, "sample1", 65, 2301, 2664);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 65, 2301, 2664);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 65, 2301, 2664);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 65, 2301, 2664);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 65, 2301, 2664);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 67, 2619, 2624)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 67, 2619, 2624).homoscedasticT(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3181.methodEnd();
        }
    }

    public static double homoscedasticT(final StatisticalSummary sampleStats1, final StatisticalSummary sampleStats2) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3182 = new MethodContext(double.class, 73, 2671, 3174);
        try {
            CallChecker.varInit(sampleStats2, "sampleStats2", 73, 2671, 3174);
            CallChecker.varInit(sampleStats1, "sampleStats1", 73, 2671, 3174);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 73, 2671, 3174);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 73, 2671, 3174);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 73, 2671, 3174);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 73, 2671, 3174);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 76, 3119, 3124)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 76, 3119, 3124).homoscedasticT(sampleStats1, sampleStats2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3182.methodEnd();
        }
    }

    public static boolean homoscedasticTTest(final double[] sample1, final double[] sample2, final double alpha) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3183 = new MethodContext(boolean.class, 82, 3181, 3649);
        try {
            CallChecker.varInit(alpha, "alpha", 82, 3181, 3649);
            CallChecker.varInit(sample2, "sample2", 82, 3181, 3649);
            CallChecker.varInit(sample1, "sample1", 82, 3181, 3649);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 82, 3181, 3649);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 82, 3181, 3649);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 82, 3181, 3649);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 82, 3181, 3649);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 86, 3593, 3598)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 86, 3593, 3598).homoscedasticTTest(sample1, sample2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3183.methodEnd();
        }
    }

    public static double homoscedasticTTest(final double[] sample1, final double[] sample2) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3184 = new MethodContext(double.class, 92, 3656, 4014);
        try {
            CallChecker.varInit(sample2, "sample2", 92, 3656, 4014);
            CallChecker.varInit(sample1, "sample1", 92, 3656, 4014);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 92, 3656, 4014);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 92, 3656, 4014);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 92, 3656, 4014);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 92, 3656, 4014);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 94, 3965, 3970)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 94, 3965, 3970).homoscedasticTTest(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3184.methodEnd();
        }
    }

    public static double homoscedasticTTest(final StatisticalSummary sampleStats1, final StatisticalSummary sampleStats2) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3185 = new MethodContext(double.class, 100, 4021, 4567);
        try {
            CallChecker.varInit(sampleStats2, "sampleStats2", 100, 4021, 4567);
            CallChecker.varInit(sampleStats1, "sampleStats1", 100, 4021, 4567);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 100, 4021, 4567);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 100, 4021, 4567);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 100, 4021, 4567);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 100, 4021, 4567);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 103, 4508, 4513)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 103, 4508, 4513).homoscedasticTTest(sampleStats1, sampleStats2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3185.methodEnd();
        }
    }

    public static double pairedT(final double[] sample1, final double[] sample2) throws DimensionMismatchException, NoDataException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3186 = new MethodContext(double.class, 109, 4574, 4925);
        try {
            CallChecker.varInit(sample2, "sample2", 109, 4574, 4925);
            CallChecker.varInit(sample1, "sample1", 109, 4574, 4925);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 109, 4574, 4925);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 109, 4574, 4925);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 109, 4574, 4925);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 109, 4574, 4925);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 112, 4887, 4892)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 112, 4887, 4892).pairedT(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3186.methodEnd();
        }
    }

    public static boolean pairedTTest(final double[] sample1, final double[] sample2, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NoDataException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3187 = new MethodContext(boolean.class, 118, 4932, 5417);
        try {
            CallChecker.varInit(alpha, "alpha", 118, 4932, 5417);
            CallChecker.varInit(sample2, "sample2", 118, 4932, 5417);
            CallChecker.varInit(sample1, "sample1", 118, 4932, 5417);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 118, 4932, 5417);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 118, 4932, 5417);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 118, 4932, 5417);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 118, 4932, 5417);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 122, 5368, 5373)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 122, 5368, 5373).pairedTTest(sample1, sample2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3187.methodEnd();
        }
    }

    public static double pairedTTest(final double[] sample1, final double[] sample2) throws DimensionMismatchException, MaxCountExceededException, NoDataException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3188 = new MethodContext(double.class, 128, 5424, 5814);
        try {
            CallChecker.varInit(sample2, "sample2", 128, 5424, 5814);
            CallChecker.varInit(sample1, "sample1", 128, 5424, 5814);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 128, 5424, 5814);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 128, 5424, 5814);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 128, 5424, 5814);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 128, 5424, 5814);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 131, 5772, 5777)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 131, 5772, 5777).pairedTTest(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3188.methodEnd();
        }
    }

    public static double t(final double mu, final double[] observed) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3189 = new MethodContext(double.class, 137, 5821, 6089);
        try {
            CallChecker.varInit(observed, "observed", 137, 5821, 6089);
            CallChecker.varInit(mu, "mu", 137, 5821, 6089);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 137, 5821, 6089);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 137, 5821, 6089);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 137, 5821, 6089);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 137, 5821, 6089);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 139, 6061, 6066)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 139, 6061, 6066).t(mu, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3189.methodEnd();
        }
    }

    public static double t(final double mu, final StatisticalSummary sampleStats) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3190 = new MethodContext(double.class, 145, 6096, 6432);
        try {
            CallChecker.varInit(sampleStats, "sampleStats", 145, 6096, 6432);
            CallChecker.varInit(mu, "mu", 145, 6096, 6432);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 145, 6096, 6432);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 145, 6096, 6432);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 145, 6096, 6432);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 145, 6096, 6432);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 147, 6401, 6406)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 147, 6401, 6406).t(mu, sampleStats);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3190.methodEnd();
        }
    }

    public static double t(final double[] sample1, final double[] sample2) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3191 = new MethodContext(double.class, 153, 6439, 6719);
        try {
            CallChecker.varInit(sample2, "sample2", 153, 6439, 6719);
            CallChecker.varInit(sample1, "sample1", 153, 6439, 6719);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 153, 6439, 6719);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 153, 6439, 6719);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 153, 6439, 6719);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 153, 6439, 6719);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 155, 6687, 6692)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 155, 6687, 6692).t(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3191.methodEnd();
        }
    }

    public static double t(final StatisticalSummary sampleStats1, final StatisticalSummary sampleStats2) throws NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3192 = new MethodContext(double.class, 161, 6726, 7177);
        try {
            CallChecker.varInit(sampleStats2, "sampleStats2", 161, 6726, 7177);
            CallChecker.varInit(sampleStats1, "sampleStats1", 161, 6726, 7177);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 161, 6726, 7177);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 161, 6726, 7177);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 161, 6726, 7177);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 161, 6726, 7177);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 164, 7135, 7140)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 164, 7135, 7140).t(sampleStats1, sampleStats2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3192.methodEnd();
        }
    }

    public static boolean tTest(final double mu, final double[] sample, final double alpha) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3193 = new MethodContext(boolean.class, 170, 7184, 7552);
        try {
            CallChecker.varInit(alpha, "alpha", 170, 7184, 7552);
            CallChecker.varInit(sample, "sample", 170, 7184, 7552);
            CallChecker.varInit(mu, "mu", 170, 7184, 7552);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 170, 7184, 7552);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 170, 7184, 7552);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 170, 7184, 7552);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 170, 7184, 7552);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 173, 7515, 7520)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 173, 7515, 7520).tTest(mu, sample, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3193.methodEnd();
        }
    }

    public static double tTest(final double mu, final double[] sample) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3194 = new MethodContext(double.class, 179, 7559, 7870);
        try {
            CallChecker.varInit(sample, "sample", 179, 7559, 7870);
            CallChecker.varInit(mu, "mu", 179, 7559, 7870);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 179, 7559, 7870);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 179, 7559, 7870);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 179, 7559, 7870);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 179, 7559, 7870);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 182, 7840, 7845)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 182, 7840, 7845).tTest(mu, sample);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3194.methodEnd();
        }
    }

    public static boolean tTest(final double mu, final StatisticalSummary sampleStats, final double alpha) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3195 = new MethodContext(boolean.class, 188, 7877, 8349);
        try {
            CallChecker.varInit(alpha, "alpha", 188, 7877, 8349);
            CallChecker.varInit(sampleStats, "sampleStats", 188, 7877, 8349);
            CallChecker.varInit(mu, "mu", 188, 7877, 8349);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 188, 7877, 8349);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 188, 7877, 8349);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 188, 7877, 8349);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 188, 7877, 8349);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 192, 8307, 8312)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 192, 8307, 8312).tTest(mu, sampleStats, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3195.methodEnd();
        }
    }

    public static double tTest(final double mu, final StatisticalSummary sampleStats) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3196 = new MethodContext(double.class, 198, 8356, 8739);
        try {
            CallChecker.varInit(sampleStats, "sampleStats", 198, 8356, 8739);
            CallChecker.varInit(mu, "mu", 198, 8356, 8739);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 198, 8356, 8739);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 198, 8356, 8739);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 198, 8356, 8739);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 198, 8356, 8739);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 201, 8704, 8709)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 201, 8704, 8709).tTest(mu, sampleStats);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3196.methodEnd();
        }
    }

    public static boolean tTest(final double[] sample1, final double[] sample2, final double alpha) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3197 = new MethodContext(boolean.class, 207, 8746, 9162);
        try {
            CallChecker.varInit(alpha, "alpha", 207, 8746, 9162);
            CallChecker.varInit(sample2, "sample2", 207, 8746, 9162);
            CallChecker.varInit(sample1, "sample1", 207, 8746, 9162);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 207, 8746, 9162);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 207, 8746, 9162);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 207, 8746, 9162);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 207, 8746, 9162);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 211, 9119, 9124)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 211, 9119, 9124).tTest(sample1, sample2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3197.methodEnd();
        }
    }

    public static double tTest(final double[] sample1, final double[] sample2) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3198 = new MethodContext(double.class, 217, 9169, 9496);
        try {
            CallChecker.varInit(sample2, "sample2", 217, 9169, 9496);
            CallChecker.varInit(sample1, "sample1", 217, 9169, 9496);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 217, 9169, 9496);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 217, 9169, 9496);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 217, 9169, 9496);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 217, 9169, 9496);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 220, 9460, 9465)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 220, 9460, 9465).tTest(sample1, sample2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3198.methodEnd();
        }
    }

    public static boolean tTest(final StatisticalSummary sampleStats1, final StatisticalSummary sampleStats2, final double alpha) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3199 = new MethodContext(boolean.class, 226, 9503, 10095);
        try {
            CallChecker.varInit(alpha, "alpha", 226, 9503, 10095);
            CallChecker.varInit(sampleStats2, "sampleStats2", 226, 9503, 10095);
            CallChecker.varInit(sampleStats1, "sampleStats1", 226, 9503, 10095);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 226, 9503, 10095);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 226, 9503, 10095);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 226, 9503, 10095);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 226, 9503, 10095);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 231, 10042, 10047)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 231, 10042, 10047).tTest(sampleStats1, sampleStats2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3199.methodEnd();
        }
    }

    public static double tTest(final StatisticalSummary sampleStats1, final StatisticalSummary sampleStats2) throws MaxCountExceededException, NullArgumentException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3200 = new MethodContext(double.class, 237, 10102, 10604);
        try {
            CallChecker.varInit(sampleStats2, "sampleStats2", 237, 10102, 10604);
            CallChecker.varInit(sampleStats1, "sampleStats1", 237, 10102, 10604);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 237, 10102, 10604);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 237, 10102, 10604);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 237, 10102, 10604);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 237, 10102, 10604);
            if (CallChecker.beforeDeref(TestUtils.T_TEST, TTest.class, 241, 10558, 10563)) {
                return CallChecker.isCalled(TestUtils.T_TEST, TTest.class, 241, 10558, 10563).tTest(sampleStats1, sampleStats2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3200.methodEnd();
        }
    }

    public static double chiSquare(final double[] expected, final long[] observed) throws DimensionMismatchException, NotPositiveException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3201 = new MethodContext(double.class, 247, 10611, 10970);
        try {
            CallChecker.varInit(observed, "observed", 247, 10611, 10970);
            CallChecker.varInit(expected, "expected", 247, 10611, 10970);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 247, 10611, 10970);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 247, 10611, 10970);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 247, 10611, 10970);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 247, 10611, 10970);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 250, 10919, 10933)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 250, 10919, 10933).chiSquare(expected, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3201.methodEnd();
        }
    }

    public static double chiSquare(final long[][] counts) throws DimensionMismatchException, NotPositiveException, NullArgumentException {
        MethodContext _bcornu_methode_context3202 = new MethodContext(double.class, 256, 10977, 11284);
        try {
            CallChecker.varInit(counts, "counts", 256, 10977, 11284);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 256, 10977, 11284);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 256, 10977, 11284);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 256, 10977, 11284);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 256, 10977, 11284);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 259, 11245, 11259)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 259, 11245, 11259).chiSquare(counts);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3202.methodEnd();
        }
    }

    public static boolean chiSquareTest(final double[] expected, final long[] observed, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context3203 = new MethodContext(boolean.class, 265, 11291, 11786);
        try {
            CallChecker.varInit(alpha, "alpha", 265, 11291, 11786);
            CallChecker.varInit(observed, "observed", 265, 11291, 11786);
            CallChecker.varInit(expected, "expected", 265, 11291, 11786);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 265, 11291, 11786);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 265, 11291, 11786);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 265, 11291, 11786);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 265, 11291, 11786);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 269, 11724, 11738)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 269, 11724, 11738).chiSquareTest(expected, observed, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3203.methodEnd();
        }
    }

    public static double chiSquareTest(final double[] expected, final long[] observed) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3204 = new MethodContext(double.class, 275, 11793, 12191);
        try {
            CallChecker.varInit(observed, "observed", 275, 11793, 12191);
            CallChecker.varInit(expected, "expected", 275, 11793, 12191);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 275, 11793, 12191);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 275, 11793, 12191);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 275, 11793, 12191);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 275, 11793, 12191);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 278, 12136, 12150)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 278, 12136, 12150).chiSquareTest(expected, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3204.methodEnd();
        }
    }

    public static boolean chiSquareTest(final long[][] counts, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context3205 = new MethodContext(boolean.class, 284, 12198, 12601);
        try {
            CallChecker.varInit(alpha, "alpha", 284, 12198, 12601);
            CallChecker.varInit(counts, "counts", 284, 12198, 12601);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 284, 12198, 12601);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 284, 12198, 12601);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 284, 12198, 12601);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 284, 12198, 12601);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 287, 12551, 12565)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 287, 12551, 12565).chiSquareTest(counts, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3205.methodEnd();
        }
    }

    public static double chiSquareTest(final long[][] counts) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NullArgumentException {
        MethodContext _bcornu_methode_context3206 = new MethodContext(double.class, 293, 12608, 12954);
        try {
            CallChecker.varInit(counts, "counts", 293, 12608, 12954);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 293, 12608, 12954);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 293, 12608, 12954);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 293, 12608, 12954);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 293, 12608, 12954);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 296, 12911, 12925)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 296, 12911, 12925).chiSquareTest(counts);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3206.methodEnd();
        }
    }

    public static double chiSquareDataSetsComparison(final long[] observed1, final long[] observed2) throws DimensionMismatchException, NotPositiveException, ZeroException {
        MethodContext _bcornu_methode_context3207 = new MethodContext(double.class, 304, 12961, 13429);
        try {
            CallChecker.varInit(observed2, "observed2", 304, 12961, 13429);
            CallChecker.varInit(observed1, "observed1", 304, 12961, 13429);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 304, 12961, 13429);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 304, 12961, 13429);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 304, 12961, 13429);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 304, 12961, 13429);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 307, 13358, 13372)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 307, 13358, 13372).chiSquareDataSetsComparison(observed1, observed2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3207.methodEnd();
        }
    }

    public static double chiSquareTestDataSetsComparison(final long[] observed1, final long[] observed2) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, ZeroException {
        MethodContext _bcornu_methode_context3208 = new MethodContext(double.class, 315, 13436, 13955);
        try {
            CallChecker.varInit(observed2, "observed2", 315, 13436, 13955);
            CallChecker.varInit(observed1, "observed1", 315, 13436, 13955);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 315, 13436, 13955);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 315, 13436, 13955);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 315, 13436, 13955);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 315, 13436, 13955);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 319, 13880, 13894)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 319, 13880, 13894).chiSquareTestDataSetsComparison(observed1, observed2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3208.methodEnd();
        }
    }

    public static boolean chiSquareTestDataSetsComparison(final long[] observed1, final long[] observed2, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, OutOfRangeException, ZeroException {
        MethodContext _bcornu_methode_context3209 = new MethodContext(boolean.class, 327, 13962, 14597);
        try {
            CallChecker.varInit(alpha, "alpha", 327, 13962, 14597);
            CallChecker.varInit(observed2, "observed2", 327, 13962, 14597);
            CallChecker.varInit(observed1, "observed1", 327, 13962, 14597);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 327, 13962, 14597);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 327, 13962, 14597);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 327, 13962, 14597);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 327, 13962, 14597);
            if (CallChecker.beforeDeref(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 332, 14515, 14529)) {
                return CallChecker.isCalled(TestUtils.CHI_SQUARE_TEST, ChiSquareTest.class, 332, 14515, 14529).chiSquareTestDataSetsComparison(observed1, observed2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3209.methodEnd();
        }
    }

    public static double oneWayAnovaFValue(final Collection<double[]> categoryData) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context3210 = new MethodContext(double.class, 340, 14604, 14942);
        try {
            CallChecker.varInit(categoryData, "categoryData", 340, 14604, 14942);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 340, 14604, 14942);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 340, 14604, 14942);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 340, 14604, 14942);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 340, 14604, 14942);
            if (CallChecker.beforeDeref(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 342, 14895, 14909)) {
                return CallChecker.isCalled(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 342, 14895, 14909).anovaFValue(categoryData);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3210.methodEnd();
        }
    }

    public static double oneWayAnovaPValue(final Collection<double[]> categoryData) throws ConvergenceException, DimensionMismatchException, MaxCountExceededException, NullArgumentException {
        MethodContext _bcornu_methode_context3211 = new MethodContext(double.class, 350, 14949, 15344);
        try {
            CallChecker.varInit(categoryData, "categoryData", 350, 14949, 15344);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 350, 14949, 15344);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 350, 14949, 15344);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 350, 14949, 15344);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 350, 14949, 15344);
            if (CallChecker.beforeDeref(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 353, 15297, 15311)) {
                return CallChecker.isCalled(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 353, 15297, 15311).anovaPValue(categoryData);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3211.methodEnd();
        }
    }

    public static boolean oneWayAnovaTest(final Collection<double[]> categoryData, final double alpha) throws ConvergenceException, DimensionMismatchException, MaxCountExceededException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context3212 = new MethodContext(boolean.class, 361, 15351, 15838);
        try {
            CallChecker.varInit(alpha, "alpha", 361, 15351, 15838);
            CallChecker.varInit(categoryData, "categoryData", 361, 15351, 15838);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 361, 15351, 15838);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 361, 15351, 15838);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 361, 15351, 15838);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 361, 15351, 15838);
            if (CallChecker.beforeDeref(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 365, 15786, 15800)) {
                return CallChecker.isCalled(TestUtils.ONE_WAY_ANANOVA, OneWayAnova.class, 365, 15786, 15800).anovaTest(categoryData, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3212.methodEnd();
        }
    }

    public static double g(final double[] expected, final long[] observed) throws DimensionMismatchException, NotPositiveException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3213 = new MethodContext(double.class, 372, 15846, 16182);
        try {
            CallChecker.varInit(observed, "observed", 372, 15846, 16182);
            CallChecker.varInit(expected, "expected", 372, 15846, 16182);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 372, 15846, 16182);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 372, 15846, 16182);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 372, 15846, 16182);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 372, 15846, 16182);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 375, 16148, 16153)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 375, 16148, 16153).g(expected, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3213.methodEnd();
        }
    }

    public static double gTest(final double[] expected, final long[] observed) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3214 = new MethodContext(double.class, 382, 16189, 16567);
        try {
            CallChecker.varInit(observed, "observed", 382, 16189, 16567);
            CallChecker.varInit(expected, "expected", 382, 16189, 16567);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 382, 16189, 16567);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 382, 16189, 16567);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 382, 16189, 16567);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 382, 16189, 16567);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 385, 16529, 16534)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 385, 16529, 16534).gTest(expected, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3214.methodEnd();
        }
    }

    public static double gTestIntrinsic(final double[] expected, final long[] observed) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3215 = new MethodContext(double.class, 392, 16574, 16977);
        try {
            CallChecker.varInit(observed, "observed", 392, 16574, 16977);
            CallChecker.varInit(expected, "expected", 392, 16574, 16977);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 392, 16574, 16977);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 392, 16574, 16977);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 392, 16574, 16977);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 392, 16574, 16977);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 395, 16930, 16935)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 395, 16930, 16935).gTestIntrinsic(expected, observed);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3215.methodEnd();
        }
    }

    public static boolean gTest(final double[] expected, final long[] observed, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context3216 = new MethodContext(boolean.class, 402, 16985, 17448);
        try {
            CallChecker.varInit(alpha, "alpha", 402, 16985, 17448);
            CallChecker.varInit(observed, "observed", 402, 16985, 17448);
            CallChecker.varInit(expected, "expected", 402, 16985, 17448);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 402, 16985, 17448);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 402, 16985, 17448);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 402, 16985, 17448);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 402, 16985, 17448);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 406, 17403, 17408)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 406, 17403, 17408).gTest(expected, observed, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3216.methodEnd();
        }
    }

    public static double gDataSetsComparison(final long[] observed1, final long[] observed2) throws DimensionMismatchException, NotPositiveException, ZeroException {
        MethodContext _bcornu_methode_context3217 = new MethodContext(double.class, 413, 17455, 17872);
        try {
            CallChecker.varInit(observed2, "observed2", 413, 17455, 17872);
            CallChecker.varInit(observed1, "observed1", 413, 17455, 17872);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 413, 17455, 17872);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 413, 17455, 17872);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 413, 17455, 17872);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 413, 17455, 17872);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 416, 17818, 17823)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 416, 17818, 17823).gDataSetsComparison(observed1, observed2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3217.methodEnd();
        }
    }

    public static double rootLogLikelihoodRatio(final long k11, final long k12, final long k21, final long k22) throws DimensionMismatchException, NotPositiveException, ZeroException {
        MethodContext _bcornu_methode_context3218 = new MethodContext(double.class, 423, 17879, 18277);
        try {
            CallChecker.varInit(k22, "k22", 423, 17879, 18277);
            CallChecker.varInit(k21, "k21", 423, 17879, 18277);
            CallChecker.varInit(k12, "k12", 423, 17879, 18277);
            CallChecker.varInit(k11, "k11", 423, 17879, 18277);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 423, 17879, 18277);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 423, 17879, 18277);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 423, 17879, 18277);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 423, 17879, 18277);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 425, 18222, 18227)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 425, 18222, 18227).rootLogLikelihoodRatio(k11, k12, k21, k22);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3218.methodEnd();
        }
    }

    public static double gTestDataSetsComparison(final long[] observed1, final long[] observed2) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, ZeroException {
        MethodContext _bcornu_methode_context3219 = new MethodContext(double.class, 433, 18285, 18755);
        try {
            CallChecker.varInit(observed2, "observed2", 433, 18285, 18755);
            CallChecker.varInit(observed1, "observed1", 433, 18285, 18755);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 433, 18285, 18755);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 433, 18285, 18755);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 433, 18285, 18755);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 433, 18285, 18755);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 437, 18697, 18702)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 437, 18697, 18702).gTestDataSetsComparison(observed1, observed2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3219.methodEnd();
        }
    }

    public static boolean gTestDataSetsComparison(final long[] observed1, final long[] observed2, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, OutOfRangeException, ZeroException {
        MethodContext _bcornu_methode_context3220 = new MethodContext(boolean.class, 444, 18762, 19331);
        try {
            CallChecker.varInit(alpha, "alpha", 444, 18762, 19331);
            CallChecker.varInit(observed2, "observed2", 444, 18762, 19331);
            CallChecker.varInit(observed1, "observed1", 444, 18762, 19331);
            CallChecker.varInit(G_TEST, "org.apache.commons.math3.stat.inference.TestUtils.G_TEST", 444, 18762, 19331);
            CallChecker.varInit(ONE_WAY_ANANOVA, "org.apache.commons.math3.stat.inference.TestUtils.ONE_WAY_ANANOVA", 444, 18762, 19331);
            CallChecker.varInit(CHI_SQUARE_TEST, "org.apache.commons.math3.stat.inference.TestUtils.CHI_SQUARE_TEST", 444, 18762, 19331);
            CallChecker.varInit(T_TEST, "org.apache.commons.math3.stat.inference.TestUtils.T_TEST", 444, 18762, 19331);
            if (CallChecker.beforeDeref(TestUtils.G_TEST, GTest.class, 449, 19266, 19271)) {
                return CallChecker.isCalled(TestUtils.G_TEST, GTest.class, 449, 19266, 19271).gTestDataSetsComparison(observed1, observed2, alpha);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3220.methodEnd();
        }
    }
}

