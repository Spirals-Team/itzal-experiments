package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public final class ArithmeticUtils {
    static final long[] FACTORIALS = new long[]{ 1L , 1L , 2L , 6L , 24L , 120L , 720L , 5040L , 40320L , 362880L , 3628800L , 39916800L , 479001600L , 6227020800L , 87178291200L , 1307674368000L , 20922789888000L , 355687428096000L , 6402373705728000L , 121645100408832000L , 2432902008176640000L };

    static final AtomicReference<long[][]> STIRLING_S2 = new AtomicReference<long[][]>(null);

    private ArithmeticUtils() {
        super();
        ConstructorContext _bcornu_methode_context728 = new ConstructorContext(ArithmeticUtils.class, 50, 2146, 2227);
        try {
        } finally {
            _bcornu_methode_context728.methodEnd();
        }
    }

    public static int addAndCheck(int x, int y) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3260 = new MethodContext(int.class, 64, 2234, 2828);
        try {
            CallChecker.varInit(y, "y", 64, 2234, 2828);
            CallChecker.varInit(x, "x", 64, 2234, 2828);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 64, 2234, 2828);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 64, 2234, 2828);
            long s = CallChecker.varInit(((long) (((long) (x)) + ((long) (y)))), "s", 66, 2609, 2635);
            if ((s < (Integer.MIN_VALUE)) || (s > (Integer.MAX_VALUE))) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, x, y);
            }
            return ((int) (s));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3260.methodEnd();
        }
    }

    public static long addAndCheck(long a, long b) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3261 = new MethodContext(long.class, 83, 2835, 3291);
        try {
            CallChecker.varInit(b, "b", 83, 2835, 3291);
            CallChecker.varInit(a, "a", 83, 2835, 3291);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 83, 2835, 3291);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 83, 2835, 3291);
            return ArithmeticUtils.addAndCheck(a, b, LocalizedFormats.OVERFLOW_IN_ADDITION);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3261.methodEnd();
        }
    }

    public static long binomialCoefficient(final int n, final int k) throws MathArithmeticException, NotPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3262 = new MethodContext(long.class, 113, 3298, 6528);
        try {
            CallChecker.varInit(k, "k", 113, 3298, 6528);
            CallChecker.varInit(n, "n", 113, 3298, 6528);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 113, 3298, 6528);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 113, 3298, 6528);
            ArithmeticUtils.checkBinomial(n, k);
            if ((n == k) || (k == 0)) {
                return 1;
            }
            if ((k == 1) || (k == (n - 1))) {
                return n;
            }
            if (k > (n / 2)) {
                return ArithmeticUtils.binomialCoefficient(n, (n - k));
            }
            long result = CallChecker.varInit(((long) (1)), "result", 132, 5100, 5115);
            if (n <= 61) {
                int i = CallChecker.varInit(((int) ((n - k) + 1)), "i", 135, 5222, 5239);
                for (int j = 1; j <= k; j++) {
                    result = (result * i) / j;
                    CallChecker.varAssign(result, "result", 137, 5300, 5323);
                    i++;
                }
            }else
                if (n <= 66) {
                    int i = CallChecker.varInit(((int) ((n - k) + 1)), "i", 143, 5543, 5560);
                    for (int j = 1; j <= k; j++) {
                        final long d = CallChecker.varInit(((long) (ArithmeticUtils.gcd(i, j))), "d", 151, 5621, 6007);
                        result = (result / (j / d)) * (i / d);
                        CallChecker.varAssign(result, "result", 152, 6025, 6062);
                        i++;
                    }
                }else {
                    int i = CallChecker.varInit(((int) ((n - k) + 1)), "i", 159, 6289, 6306);
                    for (int j = 1; j <= k; j++) {
                        final long d = CallChecker.varInit(((long) (ArithmeticUtils.gcd(i, j))), "d", 161, 6367, 6391);
                        result = ArithmeticUtils.mulAndCheck((result / (j / d)), (i / d));
                        CallChecker.varAssign(result, "result", 162, 6409, 6454);
                        i++;
                    }
                }
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3262.methodEnd();
        }
    }

    public static double binomialCoefficientDouble(final int n, final int k) throws MathArithmeticException, NotPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3263 = new MethodContext(double.class, 194, 6535, 8340);
        try {
            CallChecker.varInit(k, "k", 194, 6535, 8340);
            CallChecker.varInit(n, "n", 194, 6535, 8340);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 194, 6535, 8340);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 194, 6535, 8340);
            ArithmeticUtils.checkBinomial(n, k);
            if ((n == k) || (k == 0)) {
                return 1.0;
            }
            if ((k == 1) || (k == (n - 1))) {
                return n;
            }
            if (k > (n / 2)) {
                return ArithmeticUtils.binomialCoefficientDouble(n, (n - k));
            }
            if (n < 67) {
                return ArithmeticUtils.binomialCoefficient(n, k);
            }
            double result = CallChecker.varInit(((double) (1.0)), "result", 210, 8165, 8183);
            for (int i = 1; i <= k; i++) {
                result *= ((double) ((n - k) + i)) / ((double) (i));
                CallChecker.varAssign(result, "result", 212, 8237, 8278);
            }
            return FastMath.floor((result + 0.5));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3263.methodEnd();
        }
    }

    public static double binomialCoefficientLog(final int n, final int k) throws MathArithmeticException, NotPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3264 = new MethodContext(double.class, 239, 8347, 10462);
        try {
            CallChecker.varInit(k, "k", 239, 8347, 10462);
            CallChecker.varInit(n, "n", 239, 8347, 10462);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 239, 8347, 10462);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 239, 8347, 10462);
            ArithmeticUtils.checkBinomial(n, k);
            if ((n == k) || (k == 0)) {
                return 0;
            }
            if ((k == 1) || (k == (n - 1))) {
                return FastMath.log(n);
            }
            if (n < 67) {
                return FastMath.log(ArithmeticUtils.binomialCoefficient(n, k));
            }
            if (n < 1030) {
                return FastMath.log(ArithmeticUtils.binomialCoefficientDouble(n, k));
            }
            if (k > (n / 2)) {
                return ArithmeticUtils.binomialCoefficientLog(n, (n - k));
            }
            double logSum = CallChecker.varInit(((double) (0)), "logSum", 272, 10184, 10201);
            for (int i = (n - k) + 1; i <= n; i++) {
                logSum += FastMath.log(i);
                CallChecker.varAssign(logSum, "logSum", 276, 10284, 10309);
            }
            for (int i = 2; i <= k; i++) {
                logSum -= FastMath.log(i);
                CallChecker.varAssign(logSum, "logSum", 281, 10397, 10422);
            }
            return logSum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3264.methodEnd();
        }
    }

    public static long factorial(final int n) throws MathArithmeticException, NotPositiveException {
        MethodContext _bcornu_methode_context3265 = new MethodContext(long.class, 311, 10469, 11829);
        try {
            CallChecker.varInit(n, "n", 311, 10469, 11829);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 311, 10469, 11829);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 311, 10469, 11829);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, n);
            }
            if (n > 20) {
                throw new MathArithmeticException();
            }
            if (CallChecker.beforeDeref(ArithmeticUtils.FACTORIALS, long[].class, 319, 11810, 11819)) {
                return CallChecker.isCalled(ArithmeticUtils.FACTORIALS, long[].class, 319, 11810, 11819)[n];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3265.methodEnd();
        }
    }

    public static double factorialDouble(final int n) throws NotPositiveException {
        MethodContext _bcornu_methode_context3266 = new MethodContext(double.class, 335, 11836, 12807);
        try {
            CallChecker.varInit(n, "n", 335, 11836, 12807);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 335, 11836, 12807);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 335, 11836, 12807);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, n);
            }
            if (n < 21) {
                if (CallChecker.beforeDeref(ArithmeticUtils.FACTORIALS, long[].class, 341, 12694, 12703)) {
                    return CallChecker.isCalled(ArithmeticUtils.FACTORIALS, long[].class, 341, 12694, 12703)[n];
                }else
                    throw new AbnormalExecutionError();
                
            }
            return FastMath.floor(((FastMath.exp(ArithmeticUtils.factorialLog(n))) + 0.5));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3266.methodEnd();
        }
    }

    public static double factorialLog(final int n) throws NotPositiveException {
        MethodContext _bcornu_methode_context3267 = new MethodContext(double.class, 353, 12814, 13478);
        try {
            CallChecker.varInit(n, "n", 353, 12814, 13478);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 353, 12814, 13478);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 353, 12814, 13478);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, n);
            }
            if (n < 21) {
                if (CallChecker.beforeDeref(ArithmeticUtils.FACTORIALS, long[].class, 359, 13310, 13319)) {
                    return FastMath.log(CallChecker.isCalled(ArithmeticUtils.FACTORIALS, long[].class, 359, 13310, 13319)[n]);
                }else
                    throw new AbnormalExecutionError();
                
            }
            double logSum = CallChecker.varInit(((double) (0)), "logSum", 361, 13344, 13361);
            for (int i = 2; i <= n; i++) {
                logSum += FastMath.log(i);
                CallChecker.varAssign(logSum, "logSum", 363, 13414, 13439);
            }
            return logSum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3267.methodEnd();
        }
    }

    public static int gcd(int p, int q) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3268 = new MethodContext(int.class, 396, 13485, 16322);
        try {
            CallChecker.varInit(q, "q", 396, 13485, 16322);
            CallChecker.varInit(p, "p", 396, 13485, 16322);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 396, 13485, 16322);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 396, 13485, 16322);
            int a = CallChecker.varInit(((int) (p)), "a", 399, 14744, 14753);
            int b = CallChecker.varInit(((int) (q)), "b", 400, 14763, 14772);
            if ((a == 0) || (b == 0)) {
                if ((a == (Integer.MIN_VALUE)) || (b == (Integer.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, p, q);
                }
                return FastMath.abs((a + b));
            }
            long al = CallChecker.varInit(((long) (a)), "al", 411, 15121, 15132);
            long bl = CallChecker.varInit(((long) (b)), "bl", 412, 15142, 15153);
            boolean useLong = CallChecker.varInit(((boolean) (false)), "useLong", 413, 15163, 15186);
            if (a < 0) {
                if ((Integer.MIN_VALUE) == a) {
                    useLong = true;
                    CallChecker.varAssign(useLong, "useLong", 416, 15266, 15280);
                }else {
                    a = -a;
                    CallChecker.varAssign(a, "a", 418, 15319, 15325);
                }
                al = -al;
                CallChecker.varAssign(al, "al", 420, 15353, 15361);
            }
            if (b < 0) {
                if ((Integer.MIN_VALUE) == b) {
                    useLong = true;
                    CallChecker.varAssign(useLong, "useLong", 424, 15452, 15466);
                }else {
                    b = -b;
                    CallChecker.varAssign(b, "b", 426, 15505, 15511);
                }
                bl = -bl;
                CallChecker.varAssign(bl, "bl", 428, 15539, 15547);
            }
            if (useLong) {
                if (al == bl) {
                    throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, p, q);
                }
                long blbu = CallChecker.varInit(((long) (bl)), "blbu", 435, 15781, 15795);
                bl = al;
                CallChecker.varAssign(bl, "bl", 436, 15809, 15816);
                al = blbu % al;
                CallChecker.varAssign(al, "al", 437, 15830, 15844);
                if (al == 0) {
                    if (bl > (Integer.MAX_VALUE)) {
                        throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_32_BITS, p, q);
                    }
                    return ((int) (bl));
                }
                blbu = bl;
                CallChecker.varAssign(blbu, "blbu", 445, 16150, 16159);
                b = ((int) (al));
                CallChecker.varAssign(b, "b", 448, 16224, 16236);
                a = ((int) (blbu % al));
                CallChecker.varAssign(a, "a", 449, 16250, 16271);
            }
            return ArithmeticUtils.gcdPositive(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3268.methodEnd();
        }
    }

    private static int gcdPositive(int a, int b) {
        MethodContext _bcornu_methode_context3269 = new MethodContext(int.class, 475, 16329, 18261);
        try {
            CallChecker.varInit(b, "b", 475, 16329, 18261);
            CallChecker.varInit(a, "a", 475, 16329, 18261);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 475, 16329, 18261);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 475, 16329, 18261);
            if (a == 0) {
                return b;
            }else
                if (b == 0) {
                    return a;
                }
            
            final int aTwos = CallChecker.varInit(((int) (Integer.numberOfTrailingZeros(a))), "aTwos", 485, 17301, 17420);
            a >>= aTwos;
            CallChecker.varAssign(a, "a", 486, 17430, 17441);
            final int bTwos = CallChecker.varInit(((int) (Integer.numberOfTrailingZeros(b))), "bTwos", 487, 17451, 17501);
            b >>= bTwos;
            CallChecker.varAssign(b, "b", 488, 17511, 17522);
            final int shift = CallChecker.varInit(((int) (Math.min(aTwos, bTwos))), "shift", 489, 17532, 17572);
            while (a != b) {
                final int delta = CallChecker.varInit(((int) (a - b)), "delta", 498, 17959, 17982);
                b = Math.min(a, b);
                CallChecker.varAssign(b, "b", 499, 17996, 18014);
                a = Math.abs(delta);
                CallChecker.varAssign(a, "a", 500, 18028, 18047);
                a >>= Integer.numberOfTrailingZeros(a);
                CallChecker.varAssign(a, "a", 503, 18137, 18175);
            } 
            return a << shift;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3269.methodEnd();
        }
    }

    public static long gcd(final long p, final long q) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3270 = new MethodContext(long.class, 539, 18268, 21626);
        try {
            CallChecker.varInit(q, "q", 539, 18268, 21626);
            CallChecker.varInit(p, "p", 539, 18268, 21626);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 539, 18268, 21626);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 539, 18268, 21626);
            long u = CallChecker.varInit(((long) (p)), "u", 540, 19508, 19518);
            long v = CallChecker.varInit(((long) (q)), "v", 541, 19528, 19538);
            if ((u == 0) || (v == 0)) {
                if ((u == (Long.MIN_VALUE)) || (v == (Long.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, p, q);
                }
                return (FastMath.abs(u)) + (FastMath.abs(v));
            }
            if (u > 0) {
                u = -u;
                CallChecker.varAssign(u, "u", 555, 20166, 20172);
            }
            if (v > 0) {
                v = -v;
                CallChecker.varAssign(v, "v", 558, 20236, 20242);
            }
            int k = CallChecker.varInit(((int) (0)), "k", 561, 20314, 20323);
            while ((((u & 1) == 0) && ((v & 1) == 0)) && (k < 63)) {
                u /= 2;
                CallChecker.varAssign(u, "u", 564, 20491, 20497);
                v /= 2;
                CallChecker.varAssign(v, "v", 565, 20511, 20517);
                k++;
            } 
            if (k == 63) {
                throw new MathArithmeticException(LocalizedFormats.GCD_OVERFLOW_64_BITS, p, q);
            }
            long t = CallChecker.init(long.class);
            if ((u & 1) == 1) {
                t = v;
                CallChecker.varAssign(t, "t", 574, 20848, 20876);
            }else {
                t = -(u / 2);
                CallChecker.varAssign(t, "t", 574, 20848, 20876);
            }
            do {
                while ((t & 1) == 0) {
                    t /= 2;
                    CallChecker.varAssign(t, "t", 581, 21175, 21181);
                } 
                if (t > 0) {
                    u = -t;
                    CallChecker.varAssign(u, "u", 585, 21290, 21296);
                }else {
                    v = t;
                    CallChecker.varAssign(v, "v", 587, 21335, 21340);
                }
                t = (v - u) / 2;
                CallChecker.varAssign(t, "t", 590, 21432, 21447);
            } while (t != 0 );
            return (-u) * (1L << k);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3270.methodEnd();
        }
    }

    public static int lcm(int a, int b) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3271 = new MethodContext(int.class, 619, 21633, 22912);
        try {
            CallChecker.varInit(b, "b", 619, 21633, 22912);
            CallChecker.varInit(a, "a", 619, 21633, 22912);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 619, 21633, 22912);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 619, 21633, 22912);
            if ((a == 0) || (b == 0)) {
                return 0;
            }
            int lcm = CallChecker.varInit(((int) (FastMath.abs(ArithmeticUtils.mulAndCheck((a / (ArithmeticUtils.gcd(a, b))), b)))), "lcm", 623, 22629, 22698);
            if (lcm == (Integer.MIN_VALUE)) {
                throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_32_BITS, a, b);
            }
            return lcm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3271.methodEnd();
        }
    }

    public static long lcm(long a, long b) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3272 = new MethodContext(long.class, 653, 22919, 24196);
        try {
            CallChecker.varInit(b, "b", 653, 22919, 24196);
            CallChecker.varInit(a, "a", 653, 22919, 24196);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 653, 22919, 24196);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 653, 22919, 24196);
            if ((a == 0) || (b == 0)) {
                return 0;
            }
            long lcm = CallChecker.varInit(((long) (FastMath.abs(ArithmeticUtils.mulAndCheck((a / (ArithmeticUtils.gcd(a, b))), b)))), "lcm", 657, 23916, 23986);
            if (lcm == (Long.MIN_VALUE)) {
                throw new MathArithmeticException(LocalizedFormats.LCM_OVERFLOW_64_BITS, a, b);
            }
            return lcm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3272.methodEnd();
        }
    }

    public static int mulAndCheck(int x, int y) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3273 = new MethodContext(int.class, 675, 24203, 24754);
        try {
            CallChecker.varInit(y, "y", 675, 24203, 24754);
            CallChecker.varInit(x, "x", 675, 24203, 24754);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 675, 24203, 24754);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 675, 24203, 24754);
            long m = CallChecker.varInit(((long) (((long) (x)) * ((long) (y)))), "m", 676, 24574, 24604);
            if ((m < (Integer.MIN_VALUE)) || (m > (Integer.MAX_VALUE))) {
                throw new MathArithmeticException();
            }
            return ((int) (m));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3273.methodEnd();
        }
    }

    public static long mulAndCheck(long a, long b) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3274 = new MethodContext(long.class, 693, 24761, 26515);
        try {
            CallChecker.varInit(b, "b", 693, 24761, 26515);
            CallChecker.varInit(a, "a", 693, 24761, 26515);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 693, 24761, 26515);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 693, 24761, 26515);
            long ret = CallChecker.init(long.class);
            if (a > b) {
                ret = ArithmeticUtils.mulAndCheck(b, a);
                CallChecker.varAssign(ret, "ret", 697, 25236, 25259);
            }else {
                if (a < 0) {
                    if (b < 0) {
                        if (a >= ((Long.MAX_VALUE) / b)) {
                            ret = a * b;
                            CallChecker.varAssign(ret, "ret", 703, 25486, 25497);
                        }else {
                            throw new MathArithmeticException();
                        }
                    }else
                        if (b > 0) {
                            if (((Long.MIN_VALUE) / b) <= a) {
                                ret = a * b;
                                CallChecker.varAssign(ret, "ret", 710, 25801, 25812);
                            }else {
                                throw new MathArithmeticException();
                            }
                        }else {
                            ret = 0;
                            CallChecker.varAssign(ret, "ret", 717, 26009, 26016);
                        }
                    
                }else
                    if (a > 0) {
                        if (a <= ((Long.MAX_VALUE) / b)) {
                            ret = a * b;
                            CallChecker.varAssign(ret, "ret", 725, 26275, 26286);
                        }else {
                            throw new MathArithmeticException();
                        }
                    }else {
                        ret = 0;
                        CallChecker.varAssign(ret, "ret", 731, 26458, 26465);
                    }
                
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3274.methodEnd();
        }
    }

    public static int subAndCheck(int x, int y) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3275 = new MethodContext(int.class, 747, 26522, 27123);
        try {
            CallChecker.varInit(y, "y", 747, 26522, 27123);
            CallChecker.varInit(x, "x", 747, 26522, 27123);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 747, 26522, 27123);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 747, 26522, 27123);
            long s = CallChecker.varInit(((long) (((long) (x)) - ((long) (y)))), "s", 748, 26901, 26927);
            if ((s < (Integer.MIN_VALUE)) || (s > (Integer.MAX_VALUE))) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, x, y);
            }
            return ((int) (s));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3275.methodEnd();
        }
    }

    public static long subAndCheck(long a, long b) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3276 = new MethodContext(long.class, 765, 27130, 27905);
        try {
            CallChecker.varInit(b, "b", 765, 27130, 27905);
            CallChecker.varInit(a, "a", 765, 27130, 27905);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 765, 27130, 27905);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 765, 27130, 27905);
            long ret = CallChecker.init(long.class);
            if (b == (Long.MIN_VALUE)) {
                if (a < 0) {
                    ret = a - b;
                    CallChecker.varAssign(ret, "ret", 769, 27596, 27607);
                }else {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, a, (-b));
                }
            }else {
                ret = ArithmeticUtils.addAndCheck(a, (-b), LocalizedFormats.OVERFLOW_IN_ADDITION);
                CallChecker.varAssign(ret, "ret", 775, 27806, 27869);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3276.methodEnd();
        }
    }

    public static int pow(final int k, int e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3277 = new MethodContext(int.class, 788, 27912, 28557);
        try {
            CallChecker.varInit(e, "e", 788, 27912, 28557);
            CallChecker.varInit(k, "k", 788, 27912, 28557);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 788, 27912, 28557);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 788, 27912, 28557);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            int result = CallChecker.varInit(((int) (1)), "result", 793, 28327, 28341);
            int k2p = CallChecker.varInit(((int) (k)), "k2p", 794, 28351, 28365);
            while (e != 0) {
                if ((e & 1) != 0) {
                    result *= k2p;
                    CallChecker.varAssign(result, "result", 797, 28442, 28455);
                }
                k2p *= k2p;
                CallChecker.varAssign(k2p, "k2p", 799, 28483, 28493);
                e = e >> 1;
                CallChecker.varAssign(e, "e", 800, 28507, 28517);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3277.methodEnd();
        }
    }

    public static int pow(final int k, long e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3278 = new MethodContext(int.class, 814, 28564, 29210);
        try {
            CallChecker.varInit(e, "e", 814, 28564, 29210);
            CallChecker.varInit(k, "k", 814, 28564, 29210);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 814, 28564, 29210);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 814, 28564, 29210);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            int result = CallChecker.varInit(((int) (1)), "result", 819, 28980, 28994);
            int k2p = CallChecker.varInit(((int) (k)), "k2p", 820, 29004, 29018);
            while (e != 0) {
                if ((e & 1) != 0) {
                    result *= k2p;
                    CallChecker.varAssign(result, "result", 823, 29095, 29108);
                }
                k2p *= k2p;
                CallChecker.varAssign(k2p, "k2p", 825, 29136, 29146);
                e = e >> 1;
                CallChecker.varAssign(e, "e", 826, 29160, 29170);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3278.methodEnd();
        }
    }

    public static long pow(final long k, int e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3279 = new MethodContext(long.class, 840, 29217, 29867);
        try {
            CallChecker.varInit(e, "e", 840, 29217, 29867);
            CallChecker.varInit(k, "k", 840, 29217, 29867);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 840, 29217, 29867);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 840, 29217, 29867);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            long result = CallChecker.varInit(((long) (1L)), "result", 845, 29634, 29650);
            long k2p = CallChecker.varInit(((long) (k)), "k2p", 846, 29660, 29675);
            while (e != 0) {
                if ((e & 1) != 0) {
                    result *= k2p;
                    CallChecker.varAssign(result, "result", 849, 29752, 29765);
                }
                k2p *= k2p;
                CallChecker.varAssign(k2p, "k2p", 851, 29793, 29803);
                e = e >> 1;
                CallChecker.varAssign(e, "e", 852, 29817, 29827);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3279.methodEnd();
        }
    }

    public static long pow(final long k, long e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3280 = new MethodContext(long.class, 866, 29874, 30525);
        try {
            CallChecker.varInit(e, "e", 866, 29874, 30525);
            CallChecker.varInit(k, "k", 866, 29874, 30525);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 866, 29874, 30525);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 866, 29874, 30525);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            long result = CallChecker.varInit(((long) (1L)), "result", 871, 30292, 30308);
            long k2p = CallChecker.varInit(((long) (k)), "k2p", 872, 30318, 30333);
            while (e != 0) {
                if ((e & 1) != 0) {
                    result *= k2p;
                    CallChecker.varAssign(result, "result", 875, 30410, 30423);
                }
                k2p *= k2p;
                CallChecker.varAssign(k2p, "k2p", 877, 30451, 30461);
                e = e >> 1;
                CallChecker.varAssign(e, "e", 878, 30475, 30485);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3280.methodEnd();
        }
    }

    public static BigInteger pow(final BigInteger k, int e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3281 = new MethodContext(BigInteger.class, 892, 30532, 30988);
        try {
            CallChecker.varInit(e, "e", 892, 30532, 30988);
            CallChecker.varInit(k, "k", 892, 30532, 30988);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 892, 30532, 30988);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 892, 30532, 30988);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            if (CallChecker.beforeDeref(k, BigInteger.class, 897, 30974, 30974)) {
                return CallChecker.isCalled(k, BigInteger.class, 897, 30974, 30974).pow(e);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3281.methodEnd();
        }
    }

    public static BigInteger pow(final BigInteger k, long e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3282 = new MethodContext(BigInteger.class, 908, 30995, 31718);
        try {
            CallChecker.varInit(e, "e", 908, 30995, 31718);
            CallChecker.varInit(k, "k", 908, 30995, 31718);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 908, 30995, 31718);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 908, 30995, 31718);
            if (e < 0) {
                throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
            }
            BigInteger result = CallChecker.varInit(BigInteger.ONE, "result", 913, 31431, 31465);
            BigInteger k2p = CallChecker.varInit(k, "k2p", 914, 31475, 31496);
            while (e != 0) {
                if ((e & 1) != 0) {
                    if (CallChecker.beforeDeref(result, BigInteger.class, 917, 31582, 31587)) {
                        result = CallChecker.beforeCalled(result, BigInteger.class, 917, 31582, 31587);
                        result = CallChecker.isCalled(result, BigInteger.class, 917, 31582, 31587).multiply(k2p);
                        CallChecker.varAssign(result, "result", 917, 31573, 31602);
                    }
                }
                if (CallChecker.beforeDeref(k2p, BigInteger.class, 919, 31636, 31638)) {
                    k2p = CallChecker.beforeCalled(k2p, BigInteger.class, 919, 31636, 31638);
                    k2p = CallChecker.isCalled(k2p, BigInteger.class, 919, 31636, 31638).multiply(k2p);
                    CallChecker.varAssign(k2p, "k2p", 919, 31630, 31653);
                }
                e = e >> 1;
                CallChecker.varAssign(e, "e", 920, 31667, 31677);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3282.methodEnd();
        }
    }

    public static BigInteger pow(final BigInteger k, BigInteger e) throws NotPositiveException {
        MethodContext _bcornu_methode_context3283 = new MethodContext(BigInteger.class, 935, 31725, 32513);
        try {
            CallChecker.varInit(e, "e", 935, 31725, 32513);
            CallChecker.varInit(k, "k", 935, 31725, 32513);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 935, 31725, 32513);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 935, 31725, 32513);
            if (CallChecker.beforeDeref(e, BigInteger.class, 936, 32071, 32071)) {
                e = CallChecker.beforeCalled(e, BigInteger.class, 936, 32071, 32071);
                if ((CallChecker.isCalled(e, BigInteger.class, 936, 32071, 32071).compareTo(BigInteger.ZERO)) < 0) {
                    throw new NotPositiveException(LocalizedFormats.EXPONENT, e);
                }
            }else
                throw new AbnormalExecutionError();
            
            BigInteger result = CallChecker.varInit(BigInteger.ONE, "result", 940, 32200, 32234);
            BigInteger k2p = CallChecker.varInit(k, "k2p", 941, 32244, 32265);
            while (!(CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 942, 32283, 32297).equals(e))) {
                if (CallChecker.beforeDeref(e, BigInteger.class, 943, 32328, 32328)) {
                    e = CallChecker.beforeCalled(e, BigInteger.class, 943, 32328, 32328);
                    if (CallChecker.isCalled(e, BigInteger.class, 943, 32328, 32328).testBit(0)) {
                        if (CallChecker.beforeDeref(result, BigInteger.class, 944, 32369, 32374)) {
                            result = CallChecker.beforeCalled(result, BigInteger.class, 944, 32369, 32374);
                            result = CallChecker.isCalled(result, BigInteger.class, 944, 32369, 32374).multiply(k2p);
                            CallChecker.varAssign(result, "result", 944, 32360, 32389);
                        }
                    }
                }
                if (CallChecker.beforeDeref(k2p, BigInteger.class, 946, 32423, 32425)) {
                    k2p = CallChecker.beforeCalled(k2p, BigInteger.class, 946, 32423, 32425);
                    k2p = CallChecker.isCalled(k2p, BigInteger.class, 946, 32423, 32425).multiply(k2p);
                    CallChecker.varAssign(k2p, "k2p", 946, 32417, 32440);
                }
                if (CallChecker.beforeDeref(e, BigInteger.class, 947, 32458, 32458)) {
                    e = CallChecker.beforeCalled(e, BigInteger.class, 947, 32458, 32458);
                    e = CallChecker.isCalled(e, BigInteger.class, 947, 32458, 32458).shiftRight(1);
                    CallChecker.varAssign(e, "e", 947, 32454, 32473);
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3283.methodEnd();
        }
    }

    public static long stirlingS2(final int n, final int k) throws MathArithmeticException, NotPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3284 = new MethodContext(long.class, 972, 32520, 35893);
        try {
            CallChecker.varInit(k, "k", 972, 32520, 35893);
            CallChecker.varInit(n, "n", 972, 32520, 35893);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 972, 32520, 35893);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 972, 32520, 35893);
            if (k < 0) {
                throw new NotPositiveException(k);
            }
            if (k > n) {
                throw new NumberIsTooLargeException(k, n, true);
            }
            long[][] stirlingS2 = CallChecker.init(long[][].class);
            if (CallChecker.beforeDeref(ArithmeticUtils.STIRLING_S2, AtomicReference.class, 981, 33716, 33726)) {
                stirlingS2 = CallChecker.isCalled(ArithmeticUtils.STIRLING_S2, AtomicReference.class, 981, 33716, 33726).get();
                CallChecker.varAssign(stirlingS2, "stirlingS2", 981, 33716, 33726);
            }
            if (stirlingS2 == null) {
                final int maxIndex = CallChecker.varInit(((int) (26)), "maxIndex", 989, 33782, 34059);
                stirlingS2 = new long[maxIndex][];
                CallChecker.varAssign(stirlingS2, "stirlingS2", 990, 34073, 34106);
                if (CallChecker.beforeDeref(stirlingS2, long[][].class, 991, 34120, 34129)) {
                    stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 991, 34120, 34129);
                    CallChecker.isCalled(stirlingS2, long[][].class, 991, 34120, 34129)[0] = new long[]{ 1L };
                    CallChecker.varAssign(CallChecker.isCalled(stirlingS2, long[][].class, 991, 34120, 34129)[0], "CallChecker.isCalled(stirlingS2, long[][].class, 991, 34120, 34129)[0]", 991, 34120, 34153);
                }
                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 992, 34187, 34196);
                for (int i = 1; i < (CallChecker.isCalled(stirlingS2, long[][].class, 992, 34187, 34196).length); ++i) {
                    if (CallChecker.beforeDeref(stirlingS2, long[][].class, 993, 34229, 34238)) {
                        stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 993, 34229, 34238);
                        CallChecker.isCalled(stirlingS2, long[][].class, 993, 34229, 34238)[i] = new long[i + 1];
                        CallChecker.varAssign(CallChecker.isCalled(stirlingS2, long[][].class, 993, 34229, 34238)[i], "CallChecker.isCalled(stirlingS2, long[][].class, 993, 34229, 34238)[i]", 993, 34229, 34260);
                    }
                    if (CallChecker.beforeDeref(stirlingS2, long[][].class, 994, 34278, 34287)) {
                        stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 994, 34278, 34287);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i], long[].class, 994, 34278, 34290)) {
                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 994, 34278, 34287);
                            CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i], long[].class, 994, 34278, 34290);
                            CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i], long[].class, 994, 34278, 34290)[0] = 0;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i], long[].class, 994, 34278, 34290)[0], "CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 994, 34278, 34287)[i], long[].class, 994, 34278, 34290)[0]", 994, 34278, 34298);
                        }
                    }
                    if (CallChecker.beforeDeref(stirlingS2, long[][].class, 995, 34316, 34325)) {
                        stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 995, 34316, 34325);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i], long[].class, 995, 34316, 34328)) {
                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 995, 34316, 34325);
                            CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i], long[].class, 995, 34316, 34328);
                            CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i], long[].class, 995, 34316, 34328)[1] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i], long[].class, 995, 34316, 34328)[1], "CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 995, 34316, 34325)[i], long[].class, 995, 34316, 34328)[1]", 995, 34316, 34336);
                        }
                    }
                    if (CallChecker.beforeDeref(stirlingS2, long[][].class, 996, 34354, 34363)) {
                        stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 996, 34354, 34363);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i], long[].class, 996, 34354, 34366)) {
                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 996, 34354, 34363);
                            CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i], long[].class, 996, 34354, 34366);
                            CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i], long[].class, 996, 34354, 34366)[i] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i], long[].class, 996, 34354, 34366)[i], "CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 996, 34354, 34363)[i], long[].class, 996, 34354, 34366)[i]", 996, 34354, 34374);
                        }
                    }
                    for (int j = 2; j < i; ++j) {
                        if (CallChecker.beforeDeref(stirlingS2, long[][].class, 998, 34442, 34451)) {
                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34442, 34451);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i], long[].class, 998, 34442, 34454)) {
                                if (CallChecker.beforeDeref(stirlingS2, long[][].class, 998, 34465, 34474)) {
                                    stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34465, 34474);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34465, 34474)[(i - 1)], long[].class, 998, 34465, 34481)) {
                                        if (CallChecker.beforeDeref(stirlingS2, long[][].class, 998, 34488, 34497)) {
                                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34488, 34497);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34488, 34497)[(i - 1)], long[].class, 998, 34488, 34504)) {
                                                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34442, 34451);
                                                CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i], long[].class, 998, 34442, 34454);
                                                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34465, 34474);
                                                CallChecker.isCalled(stirlingS2, long[][].class, 998, 34465, 34474)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34465, 34474)[(i - 1)], long[].class, 998, 34465, 34481);
                                                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 998, 34488, 34497);
                                                CallChecker.isCalled(stirlingS2, long[][].class, 998, 34488, 34497)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34488, 34497)[(i - 1)], long[].class, 998, 34488, 34504);
                                                CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i], long[].class, 998, 34442, 34454)[j] = (j * (CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34465, 34474)[(i - 1)], long[].class, 998, 34465, 34481)[j])) + (CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34488, 34497)[(i - 1)], long[].class, 998, 34488, 34504)[(j - 1)]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i], long[].class, 998, 34442, 34454)[j], "CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 998, 34442, 34451)[i], long[].class, 998, 34442, 34454)[j]", 998, 34442, 34512);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(ArithmeticUtils.STIRLING_S2, AtomicReference.class, 1003, 34600, 34610)) {
                    CallChecker.isCalled(ArithmeticUtils.STIRLING_S2, AtomicReference.class, 1003, 34600, 34610).compareAndSet(null, stirlingS2);
                }
            }
            if (CallChecker.beforeDeref(stirlingS2, long[][].class, 1007, 34673, 34682)) {
                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 1007, 34673, 34682);
                if (n < (CallChecker.isCalled(stirlingS2, long[][].class, 1007, 34673, 34682).length)) {
                    if (CallChecker.beforeDeref(stirlingS2, long[][].class, 1009, 34761, 34770)) {
                        stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 1009, 34761, 34770);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(stirlingS2, long[][].class, 1009, 34761, 34770)[n], long[].class, 1009, 34761, 34773)) {
                            stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 1009, 34761, 34770);
                            CallChecker.isCalled(stirlingS2, long[][].class, 1009, 34761, 34770)[n] = CallChecker.beforeCalled(CallChecker.isCalled(stirlingS2, long[][].class, 1009, 34761, 34770)[n], long[].class, 1009, 34761, 34773);
                            return CallChecker.isCalled(CallChecker.isCalled(stirlingS2, long[][].class, 1009, 34761, 34770)[n], long[].class, 1009, 34761, 34773)[k];
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if (k == 0) {
                        return 0;
                    }else
                        if ((k == 1) || (k == n)) {
                            return 1;
                        }else
                            if (k == 2) {
                                return (1L << (n - 1)) - 1L;
                            }else
                                if (k == (n - 1)) {
                                    return ArithmeticUtils.binomialCoefficient(n, 2);
                                }else {
                                    long sum = CallChecker.varInit(((long) (0)), "sum", 1022, 35276, 35288);
                                    long sign = CallChecker.init(long.class);
                                    if ((k & 1) == 0) {
                                        sign = 1;
                                        CallChecker.varAssign(sign, "sign", 1023, 35318, 35342);
                                    }else {
                                        sign = -1;
                                        CallChecker.varAssign(sign, "sign", 1023, 35318, 35342);
                                    }
                                    for (int j = 1; j <= k; ++j) {
                                        sign = -sign;
                                        CallChecker.varAssign(sign, "sign", 1025, 35412, 35424);
                                        sum += (sign * (ArithmeticUtils.binomialCoefficient(k, j))) * (ArithmeticUtils.pow(j, n));
                                        CallChecker.varAssign(sum, "sum", 1026, 35446, 35497);
                                        if (sum < 0) {
                                            if (CallChecker.beforeDeref(stirlingS2, long[][].class, 1030, 35757, 35766)) {
                                                stirlingS2 = CallChecker.beforeCalled(stirlingS2, long[][].class, 1030, 35757, 35766);
                                                throw new MathArithmeticException(LocalizedFormats.ARGUMENT_OUTSIDE_DOMAIN, n, 0, ((CallChecker.isCalled(stirlingS2, long[][].class, 1030, 35757, 35766).length) - 1));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    }
                                    return sum / (ArithmeticUtils.factorial(k));
                                }
                            
                        
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3284.methodEnd();
        }
    }

    private static long addAndCheck(long a, long b, Localizable pattern) throws MathArithmeticException {
        MethodContext _bcornu_methode_context3285 = new MethodContext(long.class, 1050, 35900, 37363);
        try {
            CallChecker.varInit(pattern, "pattern", 1050, 35900, 37363);
            CallChecker.varInit(b, "b", 1050, 35900, 37363);
            CallChecker.varInit(a, "a", 1050, 35900, 37363);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 1050, 35900, 37363);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 1050, 35900, 37363);
            long ret = CallChecker.init(long.class);
            if (a > b) {
                ret = ArithmeticUtils.addAndCheck(b, a, pattern);
                CallChecker.varAssign(ret, "ret", 1054, 36451, 36483);
            }else {
                if (a < 0) {
                    if (b < 0) {
                        if (((Long.MIN_VALUE) - b) <= a) {
                            ret = a + b;
                            CallChecker.varAssign(ret, "ret", 1062, 36712, 36723);
                        }else {
                            throw new MathArithmeticException(pattern, a, b);
                        }
                    }else {
                        ret = a + b;
                        CallChecker.varAssign(ret, "ret", 1068, 36956, 36967);
                    }
                }else {
                    if (a <= ((Long.MAX_VALUE) - b)) {
                        ret = a + b;
                        CallChecker.varAssign(ret, "ret", 1076, 37189, 37200);
                    }else {
                        throw new MathArithmeticException(pattern, a, b);
                    }
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3285.methodEnd();
        }
    }

    private static void checkBinomial(final int n, final int k) throws NotPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context3286 = new MethodContext(void.class, 1093, 37370, 38064);
        try {
            CallChecker.varInit(k, "k", 1093, 37370, 38064);
            CallChecker.varInit(n, "n", 1093, 37370, 38064);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 1093, 37370, 38064);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 1093, 37370, 38064);
            if (n < k) {
                throw new NumberIsTooLargeException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, k, n, true);
            }
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.BINOMIAL_NEGATIVE_PARAMETER, n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3286.methodEnd();
        }
    }

    public static boolean isPowerOfTwo(long n) {
        MethodContext _bcornu_methode_context3287 = new MethodContext(boolean.class, 1109, 38071, 38335);
        try {
            CallChecker.varInit(n, "n", 1109, 38071, 38335);
            CallChecker.varInit(STIRLING_S2, "org.apache.commons.math3.util.ArithmeticUtils.STIRLING_S2", 1109, 38071, 38335);
            CallChecker.varInit(FACTORIALS, "org.apache.commons.math3.util.ArithmeticUtils.FACTORIALS", 1109, 38071, 38335);
            return (n > 0) && ((n & (n - 1)) == 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3287.methodEnd();
        }
    }
}

