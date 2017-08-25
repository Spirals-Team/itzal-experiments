package org.apache.commons.math3.stat.inference;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class ChiSquareTest {
    public ChiSquareTest() {
        super();
    }

    public double chiSquare(final double[] expected, final long[] observed) throws DimensionMismatchException, NotPositiveException, NotStrictlyPositiveException {
        if ((expected.length) < 2) {
            throw new DimensionMismatchException(expected.length, 2);
        }
        if ((expected.length) != (observed.length)) {
            throw new DimensionMismatchException(expected.length, observed.length);
        }
        MathArrays.checkPositive(expected);
        MathArrays.checkNonNegative(observed);
        double sumExpected = 0.0;
        double sumObserved = 0.0;
        for (int i = 0; i < (observed.length); i++) {
            sumExpected += expected[i];
            sumObserved += observed[i];
        }
        double ratio = 1.0;
        boolean rescale = false;
        if ((FastMath.abs((sumExpected - sumObserved))) > 1.0E-5) {
            ratio = sumObserved / sumExpected;
            rescale = true;
        }
        double sumSq = 0.0;
        for (int i = 0; i < (observed.length); i++) {
            if (rescale) {
                final double dev = (observed[i]) - (ratio * (expected[i]));
                sumSq += (dev * dev) / (ratio * (expected[i]));
            }else {
                final double dev = (observed[i]) - (expected[i]);
                sumSq += (dev * dev) / (expected[i]);
            }
        }
        return sumSq;
    }

    public double chiSquareTest(final double[] expected, final long[] observed) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException {
        ChiSquaredDistribution distribution = new ChiSquaredDistribution(((expected.length) - 1.0));
        return 1.0 - (distribution.cumulativeProbability(chiSquare(expected, observed)));
    }

    public boolean chiSquareTest(final double[] expected, final long[] observed, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NotStrictlyPositiveException, OutOfRangeException {
        if ((alpha <= 0) || (alpha > 0.5)) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5);
        }
        return (chiSquareTest(expected, observed)) < alpha;
    }

    public double chiSquare(final long[][] counts) throws DimensionMismatchException, NotPositiveException, NullArgumentException {
        checkArray(counts);
        int nRows = counts.length;
        int nCols = counts[0].length;
        double[] rowSum = new double[nRows];
        double[] colSum = new double[nCols];
        double total = 0.0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                rowSum[row] += counts[row][col];
                colSum[col] += counts[row][col];
                total += counts[row][col];
            }
        }
        double sumSq = 0.0;
        double expected = 0.0;
        for (int row = 0; row < nRows; row++) {
            for (int col = 0; col < nCols; col++) {
                expected = ((rowSum[row]) * (colSum[col])) / total;
                sumSq += (((counts[row][col]) - expected) * ((counts[row][col]) - expected)) / expected;
            }
        }
        return sumSq;
    }

    public double chiSquareTest(final long[][] counts) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NullArgumentException {
        checkArray(counts);
        double df = (((double) (counts.length)) - 1) * (((double) (counts[0].length)) - 1);
        ChiSquaredDistribution distribution;
        distribution = new ChiSquaredDistribution(df);
        return 1 - (distribution.cumulativeProbability(chiSquare(counts)));
    }

    public boolean chiSquareTest(final long[][] counts, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, NullArgumentException, OutOfRangeException {
        if ((alpha <= 0) || (alpha > 0.5)) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5);
        }
        return (chiSquareTest(counts)) < alpha;
    }

    public double chiSquareDataSetsComparison(long[] observed1, long[] observed2) throws DimensionMismatchException, NotPositiveException, ZeroException {
        if ((observed1.length) < 2) {
            throw new DimensionMismatchException(observed1.length, 2);
        }
        if ((observed1.length) != (observed2.length)) {
            throw new DimensionMismatchException(observed1.length, observed2.length);
        }
        MathArrays.checkNonNegative(observed1);
        MathArrays.checkNonNegative(observed2);
        long countSum1 = 0;
        long countSum2 = 0;
        boolean unequalCounts = false;
        double weight = 0.0;
        for (int i = 0; i < (observed1.length); i++) {
            countSum1 += observed1[i];
            countSum2 += observed2[i];
        }
        if ((countSum1 == 0) || (countSum2 == 0)) {
            throw new ZeroException();
        }
        unequalCounts = countSum1 != countSum2;
        if (unequalCounts) {
            weight = FastMath.sqrt((((double) (countSum1)) / ((double) (countSum2))));
        }
        double sumSq = 0.0;
        double dev = 0.0;
        double obs1 = 0.0;
        double obs2 = 0.0;
        for (int i = 0; i < (observed1.length); i++) {
            if (((observed1[i]) == 0) && ((observed2[i]) == 0)) {
                throw new ZeroException(LocalizedFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY, i);
            }else {
                obs1 = observed1[i];
                obs2 = observed2[i];
                if (unequalCounts) {
                    dev = (obs1 / weight) - (obs2 * weight);
                }else {
                    dev = obs1 - obs2;
                }
                sumSq += (dev * dev) / (obs1 + obs2);
            }
        }
        return sumSq;
    }

    public double chiSquareTestDataSetsComparison(long[] observed1, long[] observed2) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, ZeroException {
        ChiSquaredDistribution distribution;
        distribution = new ChiSquaredDistribution((((double) (observed1.length)) - 1));
        return 1 - (distribution.cumulativeProbability(chiSquareDataSetsComparison(observed1, observed2)));
    }

    public boolean chiSquareTestDataSetsComparison(final long[] observed1, final long[] observed2, final double alpha) throws DimensionMismatchException, MaxCountExceededException, NotPositiveException, OutOfRangeException, ZeroException {
        if ((alpha <= 0) || (alpha > 0.5)) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5);
        }
        return (chiSquareTestDataSetsComparison(observed1, observed2)) < alpha;
    }

    private void checkArray(final long[][] in) throws DimensionMismatchException, NotPositiveException, NullArgumentException {
        if ((in.length) < 2) {
            throw new DimensionMismatchException(in.length, 2);
        }
        if ((in[0].length) < 2) {
            throw new DimensionMismatchException(in[0].length, 2);
        }
        MathArrays.checkRectangular(in);
        MathArrays.checkNonNegative(in);
    }
}

