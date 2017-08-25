package org.apache.commons.math3.stat;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

public final class StatUtils {
    private static final UnivariateStatistic SUM = new Sum();

    private static final UnivariateStatistic SUM_OF_SQUARES = new SumOfSquares();

    private static final UnivariateStatistic PRODUCT = new Product();

    private static final UnivariateStatistic SUM_OF_LOGS = new SumOfLogs();

    private static final UnivariateStatistic MIN = new Min();

    private static final UnivariateStatistic MAX = new Max();

    private static final UnivariateStatistic MEAN = new Mean();

    private static final Variance VARIANCE = new Variance();

    private static final Percentile PERCENTILE = new Percentile();

    private static final GeometricMean GEOMETRIC_MEAN = new GeometricMean();

    private StatUtils() {
        ConstructorContext _bcornu_methode_context856 = new ConstructorContext(StatUtils.class, 78, 3014, 3083);
        try {
        } finally {
            _bcornu_methode_context856.methodEnd();
        }
    }

    public static double sum(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3748 = new MethodContext(double.class, 93, 3090, 3663);
        try {
            CallChecker.varInit(values, "values", 93, 3090, 3663);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 93, 3090, 3663);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 93, 3090, 3663);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 93, 3090, 3663);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 93, 3090, 3663);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 93, 3090, 3663);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 93, 3090, 3663);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 93, 3090, 3663);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 93, 3090, 3663);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 93, 3090, 3663);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 93, 3090, 3663);
            if (CallChecker.beforeDeref(StatUtils.SUM, UnivariateStatistic.class, 95, 3637, 3639)) {
                return CallChecker.isCalled(StatUtils.SUM, UnivariateStatistic.class, 95, 3637, 3639).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3748.methodEnd();
        }
    }

    public static double sum(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3749 = new MethodContext(double.class, 112, 3670, 4470);
        try {
            CallChecker.varInit(length, "length", 112, 3670, 4470);
            CallChecker.varInit(begin, "begin", 112, 3670, 4470);
            CallChecker.varInit(values, "values", 112, 3670, 4470);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 112, 3670, 4470);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 112, 3670, 4470);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 112, 3670, 4470);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 112, 3670, 4470);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 112, 3670, 4470);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 112, 3670, 4470);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 112, 3670, 4470);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 112, 3670, 4470);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 112, 3670, 4470);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 112, 3670, 4470);
            if (CallChecker.beforeDeref(StatUtils.SUM, UnivariateStatistic.class, 114, 4429, 4431)) {
                return CallChecker.isCalled(StatUtils.SUM, UnivariateStatistic.class, 114, 4429, 4431).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3749.methodEnd();
        }
    }

    public static double sumSq(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3750 = new MethodContext(double.class, 128, 4477, 5059);
        try {
            CallChecker.varInit(values, "values", 128, 4477, 5059);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 128, 4477, 5059);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 128, 4477, 5059);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 128, 4477, 5059);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 128, 4477, 5059);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 128, 4477, 5059);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 128, 4477, 5059);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 128, 4477, 5059);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 128, 4477, 5059);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 128, 4477, 5059);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 128, 4477, 5059);
            if (CallChecker.beforeDeref(StatUtils.SUM_OF_SQUARES, UnivariateStatistic.class, 129, 5022, 5035)) {
                return CallChecker.isCalled(StatUtils.SUM_OF_SQUARES, UnivariateStatistic.class, 129, 5022, 5035).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3750.methodEnd();
        }
    }

    public static double sumSq(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3751 = new MethodContext(double.class, 146, 5066, 5908);
        try {
            CallChecker.varInit(length, "length", 146, 5066, 5908);
            CallChecker.varInit(begin, "begin", 146, 5066, 5908);
            CallChecker.varInit(values, "values", 146, 5066, 5908);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 146, 5066, 5908);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 146, 5066, 5908);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 146, 5066, 5908);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 146, 5066, 5908);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 146, 5066, 5908);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 146, 5066, 5908);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 146, 5066, 5908);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 146, 5066, 5908);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 146, 5066, 5908);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 146, 5066, 5908);
            if (CallChecker.beforeDeref(StatUtils.SUM_OF_SQUARES, UnivariateStatistic.class, 148, 5856, 5869)) {
                return CallChecker.isCalled(StatUtils.SUM_OF_SQUARES, UnivariateStatistic.class, 148, 5856, 5869).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3751.methodEnd();
        }
    }

    public static double product(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3752 = new MethodContext(double.class, 161, 5915, 6464);
        try {
            CallChecker.varInit(values, "values", 161, 5915, 6464);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 161, 5915, 6464);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 161, 5915, 6464);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 161, 5915, 6464);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 161, 5915, 6464);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 161, 5915, 6464);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 161, 5915, 6464);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 161, 5915, 6464);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 161, 5915, 6464);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 161, 5915, 6464);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 161, 5915, 6464);
            if (CallChecker.beforeDeref(StatUtils.PRODUCT, UnivariateStatistic.class, 163, 6434, 6440)) {
                return CallChecker.isCalled(StatUtils.PRODUCT, UnivariateStatistic.class, 163, 6434, 6440).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3752.methodEnd();
        }
    }

    public static double product(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3753 = new MethodContext(double.class, 180, 6471, 7286);
        try {
            CallChecker.varInit(length, "length", 180, 6471, 7286);
            CallChecker.varInit(begin, "begin", 180, 6471, 7286);
            CallChecker.varInit(values, "values", 180, 6471, 7286);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 180, 6471, 7286);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 180, 6471, 7286);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 180, 6471, 7286);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 180, 6471, 7286);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 180, 6471, 7286);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 180, 6471, 7286);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 180, 6471, 7286);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 180, 6471, 7286);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 180, 6471, 7286);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 180, 6471, 7286);
            if (CallChecker.beforeDeref(StatUtils.PRODUCT, UnivariateStatistic.class, 182, 7241, 7247)) {
                return CallChecker.isCalled(StatUtils.PRODUCT, UnivariateStatistic.class, 182, 7241, 7247).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3753.methodEnd();
        }
    }

    public static double sumLog(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3754 = new MethodContext(double.class, 199, 7293, 7987);
        try {
            CallChecker.varInit(values, "values", 199, 7293, 7987);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 199, 7293, 7987);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 199, 7293, 7987);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 199, 7293, 7987);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 199, 7293, 7987);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 199, 7293, 7987);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 199, 7293, 7987);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 199, 7293, 7987);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 199, 7293, 7987);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 199, 7293, 7987);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 199, 7293, 7987);
            if (CallChecker.beforeDeref(StatUtils.SUM_OF_LOGS, UnivariateStatistic.class, 201, 7953, 7963)) {
                return CallChecker.isCalled(StatUtils.SUM_OF_LOGS, UnivariateStatistic.class, 201, 7953, 7963).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3754.methodEnd();
        }
    }

    public static double sumLog(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3755 = new MethodContext(double.class, 222, 7994, 8954);
        try {
            CallChecker.varInit(length, "length", 222, 7994, 8954);
            CallChecker.varInit(begin, "begin", 222, 7994, 8954);
            CallChecker.varInit(values, "values", 222, 7994, 8954);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 222, 7994, 8954);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 222, 7994, 8954);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 222, 7994, 8954);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 222, 7994, 8954);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 222, 7994, 8954);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 222, 7994, 8954);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 222, 7994, 8954);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 222, 7994, 8954);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 222, 7994, 8954);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 222, 7994, 8954);
            if (CallChecker.beforeDeref(StatUtils.SUM_OF_LOGS, UnivariateStatistic.class, 224, 8905, 8915)) {
                return CallChecker.isCalled(StatUtils.SUM_OF_LOGS, UnivariateStatistic.class, 224, 8905, 8915).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3755.methodEnd();
        }
    }

    public static double mean(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3756 = new MethodContext(double.class, 240, 8961, 9644);
        try {
            CallChecker.varInit(values, "values", 240, 8961, 9644);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 240, 8961, 9644);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 240, 8961, 9644);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 240, 8961, 9644);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 240, 8961, 9644);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 240, 8961, 9644);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 240, 8961, 9644);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 240, 8961, 9644);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 240, 8961, 9644);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 240, 8961, 9644);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 240, 8961, 9644);
            if (CallChecker.beforeDeref(StatUtils.MEAN, UnivariateStatistic.class, 242, 9617, 9620)) {
                return CallChecker.isCalled(StatUtils.MEAN, UnivariateStatistic.class, 242, 9617, 9620).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3756.methodEnd();
        }
    }

    public static double mean(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3757 = new MethodContext(double.class, 262, 9651, 10600);
        try {
            CallChecker.varInit(length, "length", 262, 9651, 10600);
            CallChecker.varInit(begin, "begin", 262, 9651, 10600);
            CallChecker.varInit(values, "values", 262, 9651, 10600);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 262, 9651, 10600);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 262, 9651, 10600);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 262, 9651, 10600);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 262, 9651, 10600);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 262, 9651, 10600);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 262, 9651, 10600);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 262, 9651, 10600);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 262, 9651, 10600);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 262, 9651, 10600);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 262, 9651, 10600);
            if (CallChecker.beforeDeref(StatUtils.MEAN, UnivariateStatistic.class, 264, 10558, 10561)) {
                return CallChecker.isCalled(StatUtils.MEAN, UnivariateStatistic.class, 264, 10558, 10561).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3757.methodEnd();
        }
    }

    public static double geometricMean(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3758 = new MethodContext(double.class, 280, 10607, 11327);
        try {
            CallChecker.varInit(values, "values", 280, 10607, 11327);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 280, 10607, 11327);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 280, 10607, 11327);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 280, 10607, 11327);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 280, 10607, 11327);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 280, 10607, 11327);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 280, 10607, 11327);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 280, 10607, 11327);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 280, 10607, 11327);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 280, 10607, 11327);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 280, 10607, 11327);
            if (CallChecker.beforeDeref(StatUtils.GEOMETRIC_MEAN, GeometricMean.class, 282, 11290, 11303)) {
                return CallChecker.isCalled(StatUtils.GEOMETRIC_MEAN, GeometricMean.class, 282, 11290, 11303).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3758.methodEnd();
        }
    }

    public static double geometricMean(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3759 = new MethodContext(double.class, 302, 11334, 12320);
        try {
            CallChecker.varInit(length, "length", 302, 11334, 12320);
            CallChecker.varInit(begin, "begin", 302, 11334, 12320);
            CallChecker.varInit(values, "values", 302, 11334, 12320);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 302, 11334, 12320);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 302, 11334, 12320);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 302, 11334, 12320);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 302, 11334, 12320);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 302, 11334, 12320);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 302, 11334, 12320);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 302, 11334, 12320);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 302, 11334, 12320);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 302, 11334, 12320);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 302, 11334, 12320);
            if (CallChecker.beforeDeref(StatUtils.GEOMETRIC_MEAN, GeometricMean.class, 304, 12268, 12281)) {
                return CallChecker.isCalled(StatUtils.GEOMETRIC_MEAN, GeometricMean.class, 304, 12268, 12281).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3759.methodEnd();
        }
    }

    public static double variance(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3760 = new MethodContext(double.class, 327, 12328, 13320);
        try {
            CallChecker.varInit(values, "values", 327, 12328, 13320);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 327, 12328, 13320);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 327, 12328, 13320);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 327, 12328, 13320);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 327, 12328, 13320);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 327, 12328, 13320);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 327, 12328, 13320);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 327, 12328, 13320);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 327, 12328, 13320);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 327, 12328, 13320);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 327, 12328, 13320);
            if (CallChecker.beforeDeref(StatUtils.VARIANCE, Variance.class, 328, 13289, 13296)) {
                return CallChecker.isCalled(StatUtils.VARIANCE, Variance.class, 328, 13289, 13296).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3760.methodEnd();
        }
    }

    public static double variance(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3761 = new MethodContext(double.class, 355, 13327, 14651);
        try {
            CallChecker.varInit(length, "length", 355, 13327, 14651);
            CallChecker.varInit(begin, "begin", 355, 13327, 14651);
            CallChecker.varInit(values, "values", 355, 13327, 14651);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 355, 13327, 14651);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 355, 13327, 14651);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 355, 13327, 14651);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 355, 13327, 14651);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 355, 13327, 14651);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 355, 13327, 14651);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 355, 13327, 14651);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 355, 13327, 14651);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 355, 13327, 14651);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 355, 13327, 14651);
            if (CallChecker.beforeDeref(StatUtils.VARIANCE, Variance.class, 357, 14605, 14612)) {
                return CallChecker.isCalled(StatUtils.VARIANCE, Variance.class, 357, 14605, 14612).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3761.methodEnd();
        }
    }

    public static double variance(final double[] values, final double mean, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3762 = new MethodContext(double.class, 390, 14658, 16366);
        try {
            CallChecker.varInit(length, "length", 390, 14658, 16366);
            CallChecker.varInit(begin, "begin", 390, 14658, 16366);
            CallChecker.varInit(mean, "mean", 390, 14658, 16366);
            CallChecker.varInit(values, "values", 390, 14658, 16366);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 390, 14658, 16366);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 390, 14658, 16366);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 390, 14658, 16366);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 390, 14658, 16366);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 390, 14658, 16366);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 390, 14658, 16366);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 390, 14658, 16366);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 390, 14658, 16366);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 390, 14658, 16366);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 390, 14658, 16366);
            if (CallChecker.beforeDeref(StatUtils.VARIANCE, Variance.class, 392, 16314, 16321)) {
                return CallChecker.isCalled(StatUtils.VARIANCE, Variance.class, 392, 16314, 16321).evaluate(values, mean, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3762.methodEnd();
        }
    }

    public static double variance(final double[] values, final double mean) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3763 = new MethodContext(double.class, 421, 16373, 17760);
        try {
            CallChecker.varInit(mean, "mean", 421, 16373, 17760);
            CallChecker.varInit(values, "values", 421, 16373, 17760);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 421, 16373, 17760);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 421, 16373, 17760);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 421, 16373, 17760);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 421, 16373, 17760);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 421, 16373, 17760);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 421, 16373, 17760);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 421, 16373, 17760);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 421, 16373, 17760);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 421, 16373, 17760);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 421, 16373, 17760);
            if (CallChecker.beforeDeref(StatUtils.VARIANCE, Variance.class, 423, 17723, 17730)) {
                return CallChecker.isCalled(StatUtils.VARIANCE, Variance.class, 423, 17723, 17730).evaluate(values, mean);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3763.methodEnd();
        }
    }

    public static double populationVariance(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3764 = new MethodContext(double.class, 442, 17767, 18674);
        try {
            CallChecker.varInit(values, "values", 442, 17767, 18674);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 442, 17767, 18674);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 442, 17767, 18674);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 442, 17767, 18674);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 442, 17767, 18674);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 442, 17767, 18674);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 442, 17767, 18674);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 442, 17767, 18674);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 442, 17767, 18674);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 442, 17767, 18674);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 442, 17767, 18674);
            if (CallChecker.beforeDeref(new Variance(false), Variance.class, 444, 18632, 18650)) {
                return CallChecker.isCalled(new Variance(false), Variance.class, 444, 18632, 18650).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3764.methodEnd();
        }
    }

    public static double populationVariance(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3765 = new MethodContext(double.class, 468, 18681, 19894);
        try {
            CallChecker.varInit(length, "length", 468, 18681, 19894);
            CallChecker.varInit(begin, "begin", 468, 18681, 19894);
            CallChecker.varInit(values, "values", 468, 18681, 19894);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 468, 18681, 19894);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 468, 18681, 19894);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 468, 18681, 19894);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 468, 18681, 19894);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 468, 18681, 19894);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 468, 18681, 19894);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 468, 18681, 19894);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 468, 18681, 19894);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 468, 18681, 19894);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 468, 18681, 19894);
            if (CallChecker.beforeDeref(new Variance(false), Variance.class, 470, 19837, 19855)) {
                return CallChecker.isCalled(new Variance(false), Variance.class, 470, 19837, 19855).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3765.methodEnd();
        }
    }

    public static double populationVariance(final double[] values, final double mean, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3766 = new MethodContext(double.class, 500, 19901, 21490);
        try {
            CallChecker.varInit(length, "length", 500, 19901, 21490);
            CallChecker.varInit(begin, "begin", 500, 19901, 21490);
            CallChecker.varInit(mean, "mean", 500, 19901, 21490);
            CallChecker.varInit(values, "values", 500, 19901, 21490);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 500, 19901, 21490);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 500, 19901, 21490);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 500, 19901, 21490);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 500, 19901, 21490);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 500, 19901, 21490);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 500, 19901, 21490);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 500, 19901, 21490);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 500, 19901, 21490);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 500, 19901, 21490);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 500, 19901, 21490);
            if (CallChecker.beforeDeref(new Variance(false), Variance.class, 502, 21427, 21445)) {
                return CallChecker.isCalled(new Variance(false), Variance.class, 502, 21427, 21445).evaluate(values, mean, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3766.methodEnd();
        }
    }

    public static double populationVariance(final double[] values, final double mean) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3767 = new MethodContext(double.class, 528, 21497, 22775);
        try {
            CallChecker.varInit(mean, "mean", 528, 21497, 22775);
            CallChecker.varInit(values, "values", 528, 21497, 22775);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 528, 21497, 22775);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 528, 21497, 22775);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 528, 21497, 22775);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 528, 21497, 22775);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 528, 21497, 22775);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 528, 21497, 22775);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 528, 21497, 22775);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 528, 21497, 22775);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 528, 21497, 22775);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 528, 21497, 22775);
            if (CallChecker.beforeDeref(new Variance(false), Variance.class, 530, 22727, 22745)) {
                return CallChecker.isCalled(new Variance(false), Variance.class, 530, 22727, 22745).evaluate(values, mean);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3767.methodEnd();
        }
    }

    public static double max(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3768 = new MethodContext(double.class, 550, 22782, 23673);
        try {
            CallChecker.varInit(values, "values", 550, 22782, 23673);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 550, 22782, 23673);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 550, 22782, 23673);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 550, 22782, 23673);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 550, 22782, 23673);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 550, 22782, 23673);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 550, 22782, 23673);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 550, 22782, 23673);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 550, 22782, 23673);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 550, 22782, 23673);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 550, 22782, 23673);
            if (CallChecker.beforeDeref(StatUtils.MAX, UnivariateStatistic.class, 551, 23647, 23649)) {
                return CallChecker.isCalled(StatUtils.MAX, UnivariateStatistic.class, 551, 23647, 23649).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3768.methodEnd();
        }
    }

    public static double max(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3769 = new MethodContext(double.class, 576, 23680, 24892);
        try {
            CallChecker.varInit(length, "length", 576, 23680, 24892);
            CallChecker.varInit(begin, "begin", 576, 23680, 24892);
            CallChecker.varInit(values, "values", 576, 23680, 24892);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 576, 23680, 24892);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 576, 23680, 24892);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 576, 23680, 24892);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 576, 23680, 24892);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 576, 23680, 24892);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 576, 23680, 24892);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 576, 23680, 24892);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 576, 23680, 24892);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 576, 23680, 24892);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 576, 23680, 24892);
            if (CallChecker.beforeDeref(StatUtils.MAX, UnivariateStatistic.class, 578, 24851, 24853)) {
                return CallChecker.isCalled(StatUtils.MAX, UnivariateStatistic.class, 578, 24851, 24853).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3769.methodEnd();
        }
    }

    public static double min(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3770 = new MethodContext(double.class, 598, 24900, 25792);
        try {
            CallChecker.varInit(values, "values", 598, 24900, 25792);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 598, 24900, 25792);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 598, 24900, 25792);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 598, 24900, 25792);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 598, 24900, 25792);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 598, 24900, 25792);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 598, 24900, 25792);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 598, 24900, 25792);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 598, 24900, 25792);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 598, 24900, 25792);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 598, 24900, 25792);
            if (CallChecker.beforeDeref(StatUtils.MIN, UnivariateStatistic.class, 599, 25766, 25768)) {
                return CallChecker.isCalled(StatUtils.MIN, UnivariateStatistic.class, 599, 25766, 25768).evaluate(values);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3770.methodEnd();
        }
    }

    public static double min(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3771 = new MethodContext(double.class, 624, 25800, 27012);
        try {
            CallChecker.varInit(length, "length", 624, 25800, 27012);
            CallChecker.varInit(begin, "begin", 624, 25800, 27012);
            CallChecker.varInit(values, "values", 624, 25800, 27012);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 624, 25800, 27012);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 624, 25800, 27012);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 624, 25800, 27012);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 624, 25800, 27012);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 624, 25800, 27012);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 624, 25800, 27012);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 624, 25800, 27012);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 624, 25800, 27012);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 624, 25800, 27012);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 624, 25800, 27012);
            if (CallChecker.beforeDeref(StatUtils.MIN, UnivariateStatistic.class, 626, 26971, 26973)) {
                return CallChecker.isCalled(StatUtils.MIN, UnivariateStatistic.class, 626, 26971, 26973).evaluate(values, begin, length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3771.methodEnd();
        }
    }

    public static double percentile(final double[] values, final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3772 = new MethodContext(double.class, 652, 27019, 28234);
        try {
            CallChecker.varInit(p, "p", 652, 27019, 28234);
            CallChecker.varInit(values, "values", 652, 27019, 28234);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 652, 27019, 28234);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 652, 27019, 28234);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 652, 27019, 28234);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 652, 27019, 28234);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 652, 27019, 28234);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 652, 27019, 28234);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 652, 27019, 28234);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 652, 27019, 28234);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 652, 27019, 28234);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 652, 27019, 28234);
            if (CallChecker.beforeDeref(StatUtils.PERCENTILE, Percentile.class, 654, 28199, 28208)) {
                return CallChecker.isCalled(StatUtils.PERCENTILE, Percentile.class, 654, 28199, 28208).evaluate(values, p);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3772.methodEnd();
        }
    }

    public static double percentile(final double[] values, final int begin, final int length, final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3773 = new MethodContext(double.class, 684, 28242, 29791);
        try {
            CallChecker.varInit(p, "p", 684, 28242, 29791);
            CallChecker.varInit(length, "length", 684, 28242, 29791);
            CallChecker.varInit(begin, "begin", 684, 28242, 29791);
            CallChecker.varInit(values, "values", 684, 28242, 29791);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 684, 28242, 29791);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 684, 28242, 29791);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 684, 28242, 29791);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 684, 28242, 29791);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 684, 28242, 29791);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 684, 28242, 29791);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 684, 28242, 29791);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 684, 28242, 29791);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 684, 28242, 29791);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 684, 28242, 29791);
            if (CallChecker.beforeDeref(StatUtils.PERCENTILE, Percentile.class, 686, 29740, 29749)) {
                return CallChecker.isCalled(StatUtils.PERCENTILE, Percentile.class, 686, 29740, 29749).evaluate(values, begin, length, p);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3773.methodEnd();
        }
    }

    public static double sumDifference(final double[] sample1, final double[] sample2) throws DimensionMismatchException, NoDataException {
        MethodContext _bcornu_methode_context3774 = new MethodContext(double.class, 700, 29798, 30802);
        try {
            CallChecker.varInit(sample2, "sample2", 700, 29798, 30802);
            CallChecker.varInit(sample1, "sample1", 700, 29798, 30802);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 700, 29798, 30802);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 700, 29798, 30802);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 700, 29798, 30802);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 700, 29798, 30802);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 700, 29798, 30802);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 700, 29798, 30802);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 700, 29798, 30802);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 700, 29798, 30802);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 700, 29798, 30802);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 700, 29798, 30802);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(sample1, double[].class, 702, 30411, 30417)) {
                n = CallChecker.isCalled(sample1, double[].class, 702, 30411, 30417).length;
                CallChecker.varAssign(n, "n", 702, 30411, 30417);
            }
            if (CallChecker.beforeDeref(sample2, double[].class, 703, 30444, 30450)) {
                if (n != (CallChecker.isCalled(sample2, double[].class, 703, 30444, 30450).length)) {
                    if (CallChecker.beforeDeref(sample2, double[].class, 704, 30514, 30520)) {
                        throw new DimensionMismatchException(n, CallChecker.isCalled(sample2, double[].class, 704, 30514, 30520).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (n <= 0) {
                throw new NoDataException(LocalizedFormats.INSUFFICIENT_DIMENSION);
            }
            double result = CallChecker.varInit(((double) (0)), "result", 709, 30661, 30678);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(sample1, double[].class, 711, 30740, 30746)) {
                    if (CallChecker.beforeDeref(sample2, double[].class, 711, 30753, 30759)) {
                        result += (CallChecker.isCalled(sample1, double[].class, 711, 30740, 30746)[i]) - (CallChecker.isCalled(sample2, double[].class, 711, 30753, 30759)[i]);
                        CallChecker.varAssign(result, "result", 711, 30730, 30763);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3774.methodEnd();
        }
    }

    public static double meanDifference(final double[] sample1, final double[] sample2) throws DimensionMismatchException, NoDataException {
        MethodContext _bcornu_methode_context3775 = new MethodContext(double.class, 727, 30809, 31494);
        try {
            CallChecker.varInit(sample2, "sample2", 727, 30809, 31494);
            CallChecker.varInit(sample1, "sample1", 727, 30809, 31494);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 727, 30809, 31494);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 727, 30809, 31494);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 727, 30809, 31494);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 727, 30809, 31494);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 727, 30809, 31494);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 727, 30809, 31494);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 727, 30809, 31494);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 727, 30809, 31494);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 727, 30809, 31494);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 727, 30809, 31494);
            return (StatUtils.sumDifference(sample1, sample2)) / (CallChecker.isCalled(sample1, double[].class, 729, 31474, 31480).length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3775.methodEnd();
        }
    }

    public static double varianceDifference(final double[] sample1, final double[] sample2, double meanDifference) throws DimensionMismatchException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3776 = new MethodContext(double.class, 745, 31501, 32876);
        try {
            CallChecker.varInit(meanDifference, "meanDifference", 745, 31501, 32876);
            CallChecker.varInit(sample2, "sample2", 745, 31501, 32876);
            CallChecker.varInit(sample1, "sample1", 745, 31501, 32876);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 745, 31501, 32876);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 745, 31501, 32876);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 745, 31501, 32876);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 745, 31501, 32876);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 745, 31501, 32876);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 745, 31501, 32876);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 745, 31501, 32876);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 745, 31501, 32876);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 745, 31501, 32876);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 745, 31501, 32876);
            double sum1 = CallChecker.varInit(((double) (0.0)), "sum1", 748, 32306, 32322);
            double sum2 = CallChecker.varInit(((double) (0.0)), "sum2", 749, 32332, 32348);
            double diff = CallChecker.varInit(((double) (0.0)), "diff", 750, 32358, 32374);
            int n = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(sample1, double[].class, 751, 32392, 32398)) {
                n = CallChecker.isCalled(sample1, double[].class, 751, 32392, 32398).length;
                CallChecker.varAssign(n, "n", 751, 32392, 32398);
            }
            if (CallChecker.beforeDeref(sample2, double[].class, 752, 32425, 32431)) {
                if (n != (CallChecker.isCalled(sample2, double[].class, 752, 32425, 32431).length)) {
                    if (CallChecker.beforeDeref(sample2, double[].class, 753, 32495, 32501)) {
                        throw new DimensionMismatchException(n, CallChecker.isCalled(sample2, double[].class, 753, 32495, 32501).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (n < 2) {
                throw new NumberIsTooSmallException(n, 2, true);
            }
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(sample1, double[].class, 759, 32671, 32677)) {
                    if (CallChecker.beforeDeref(sample2, double[].class, 759, 32684, 32690)) {
                        diff = (CallChecker.isCalled(sample1, double[].class, 759, 32671, 32677)[i]) - (CallChecker.isCalled(sample2, double[].class, 759, 32684, 32690)[i]);
                        CallChecker.varAssign(diff, "diff", 759, 32664, 32694);
                    }
                }
                sum1 += (diff - meanDifference) * (diff - meanDifference);
                CallChecker.varAssign(sum1, "sum1", 760, 32708, 32764);
                sum2 += diff - meanDifference;
                CallChecker.varAssign(sum2, "sum2", 761, 32778, 32807);
            }
            return (sum1 - ((sum2 * sum2) / n)) / (n - 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3776.methodEnd();
        }
    }

    public static double[] normalize(final double[] sample) {
        MethodContext _bcornu_methode_context3777 = new MethodContext(double[].class, 773, 32883, 33915);
        try {
            CallChecker.varInit(sample, "sample", 773, 32883, 33915);
            CallChecker.varInit(GEOMETRIC_MEAN, "org.apache.commons.math3.stat.StatUtils.GEOMETRIC_MEAN", 773, 32883, 33915);
            CallChecker.varInit(PERCENTILE, "org.apache.commons.math3.stat.StatUtils.PERCENTILE", 773, 32883, 33915);
            CallChecker.varInit(VARIANCE, "org.apache.commons.math3.stat.StatUtils.VARIANCE", 773, 32883, 33915);
            CallChecker.varInit(MEAN, "org.apache.commons.math3.stat.StatUtils.MEAN", 773, 32883, 33915);
            CallChecker.varInit(MAX, "org.apache.commons.math3.stat.StatUtils.MAX", 773, 32883, 33915);
            CallChecker.varInit(MIN, "org.apache.commons.math3.stat.StatUtils.MIN", 773, 32883, 33915);
            CallChecker.varInit(SUM_OF_LOGS, "org.apache.commons.math3.stat.StatUtils.SUM_OF_LOGS", 773, 32883, 33915);
            CallChecker.varInit(PRODUCT, "org.apache.commons.math3.stat.StatUtils.PRODUCT", 773, 32883, 33915);
            CallChecker.varInit(SUM_OF_SQUARES, "org.apache.commons.math3.stat.StatUtils.SUM_OF_SQUARES", 773, 32883, 33915);
            CallChecker.varInit(SUM, "org.apache.commons.math3.stat.StatUtils.SUM", 773, 32883, 33915);
            DescriptiveStatistics stats = CallChecker.varInit(new DescriptiveStatistics(), "stats", 774, 33180, 33237);
            for (int i = 0; i < (CallChecker.isCalled(sample, double[].class, 777, 33317, 33322).length); i++) {
                if (CallChecker.beforeDeref(sample, double[].class, 778, 33366, 33371)) {
                    if (CallChecker.beforeDeref(stats, DescriptiveStatistics.class, 778, 33351, 33355)) {
                        stats = CallChecker.beforeCalled(stats, DescriptiveStatistics.class, 778, 33351, 33355);
                        CallChecker.isCalled(stats, DescriptiveStatistics.class, 778, 33351, 33355).addValue(CallChecker.isCalled(sample, double[].class, 778, 33366, 33371)[i]);
                    }
                }
            }
            double mean = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(stats, DescriptiveStatistics.class, 782, 33458, 33462)) {
                stats = CallChecker.beforeCalled(stats, DescriptiveStatistics.class, 782, 33458, 33462);
                mean = CallChecker.isCalled(stats, DescriptiveStatistics.class, 782, 33458, 33462).getMean();
                CallChecker.varAssign(mean, "mean", 782, 33458, 33462);
            }
            double standardDeviation = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(stats, DescriptiveStatistics.class, 783, 33510, 33514)) {
                stats = CallChecker.beforeCalled(stats, DescriptiveStatistics.class, 783, 33510, 33514);
                standardDeviation = CallChecker.isCalled(stats, DescriptiveStatistics.class, 783, 33510, 33514).getStandardDeviation();
                CallChecker.varAssign(standardDeviation, "standardDeviation", 783, 33510, 33514);
            }
            double[] standardizedSample = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(sample, double[].class, 786, 33676, 33681)) {
                standardizedSample = new double[CallChecker.isCalled(sample, double[].class, 786, 33676, 33681).length];
                CallChecker.varAssign(standardizedSample, "standardizedSample", 786, 33676, 33681);
            }
            for (int i = 0; i < (CallChecker.isCalled(sample, double[].class, 788, 33721, 33726).length); i++) {
                if (CallChecker.beforeDeref(standardizedSample, double[].class, 790, 33802, 33819)) {
                    if (CallChecker.beforeDeref(sample, double[].class, 790, 33827, 33832)) {
                        standardizedSample = CallChecker.beforeCalled(standardizedSample, double[].class, 790, 33802, 33819);
                        CallChecker.isCalled(standardizedSample, double[].class, 790, 33802, 33819)[i] = ((CallChecker.isCalled(sample, double[].class, 790, 33827, 33832)[i]) - mean) / standardDeviation;
                        CallChecker.varAssign(CallChecker.isCalled(standardizedSample, double[].class, 790, 33802, 33819)[i], "CallChecker.isCalled(standardizedSample, double[].class, 790, 33802, 33819)[i]", 790, 33802, 33864);
                    }
                }
            }
            return standardizedSample;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3777.methodEnd();
        }
    }
}

