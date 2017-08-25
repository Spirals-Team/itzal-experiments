package org.apache.commons.math3.primes;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;

class SmallPrimes {
    public static final int[] PRIMES = new int[]{ 2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 , 67 , 71 , 73 , 79 , 83 , 89 , 97 , 101 , 103 , 107 , 109 , 113 , 127 , 131 , 137 , 139 , 149 , 151 , 157 , 163 , 167 , 173 , 179 , 181 , 191 , 193 , 197 , 199 , 211 , 223 , 227 , 229 , 233 , 239 , 241 , 251 , 257 , 263 , 269 , 271 , 277 , 281 , 283 , 293 , 307 , 311 , 313 , 317 , 331 , 337 , 347 , 349 , 353 , 359 , 367 , 373 , 379 , 383 , 389 , 397 , 401 , 409 , 419 , 421 , 431 , 433 , 439 , 443 , 449 , 457 , 461 , 463 , 467 , 479 , 487 , 491 , 499 , 503 , 509 , 521 , 523 , 541 , 547 , 557 , 563 , 569 , 571 , 577 , 587 , 593 , 599 , 601 , 607 , 613 , 617 , 619 , 631 , 641 , 643 , 647 , 653 , 659 , 661 , 673 , 677 , 683 , 691 , 701 , 709 , 719 , 727 , 733 , 739 , 743 , 751 , 757 , 761 , 769 , 773 , 787 , 797 , 809 , 811 , 821 , 823 , 827 , 829 , 839 , 853 , 857 , 859 , 863 , 877 , 881 , 883 , 887 , 907 , 911 , 919 , 929 , 937 , 941 , 947 , 953 , 967 , 971 , 977 , 983 , 991 , 997 , 1009 , 1013 , 1019 , 1021 , 1031 , 1033 , 1039 , 1049 , 1051 , 1061 , 1063 , 1069 , 1087 , 1091 , 1093 , 1097 , 1103 , 1109 , 1117 , 1123 , 1129 , 1151 , 1153 , 1163 , 1171 , 1181 , 1187 , 1193 , 1201 , 1213 , 1217 , 1223 , 1229 , 1231 , 1237 , 1249 , 1259 , 1277 , 1279 , 1283 , 1289 , 1291 , 1297 , 1301 , 1303 , 1307 , 1319 , 1321 , 1327 , 1361 , 1367 , 1373 , 1381 , 1399 , 1409 , 1423 , 1427 , 1429 , 1433 , 1439 , 1447 , 1451 , 1453 , 1459 , 1471 , 1481 , 1483 , 1487 , 1489 , 1493 , 1499 , 1511 , 1523 , 1531 , 1543 , 1549 , 1553 , 1559 , 1567 , 1571 , 1579 , 1583 , 1597 , 1601 , 1607 , 1609 , 1613 , 1619 , 1621 , 1627 , 1637 , 1657 , 1663 , 1667 , 1669 , 1693 , 1697 , 1699 , 1709 , 1721 , 1723 , 1733 , 1741 , 1747 , 1753 , 1759 , 1777 , 1783 , 1787 , 1789 , 1801 , 1811 , 1823 , 1831 , 1847 , 1861 , 1867 , 1871 , 1873 , 1877 , 1879 , 1889 , 1901 , 1907 , 1913 , 1931 , 1933 , 1949 , 1951 , 1973 , 1979 , 1987 , 1993 , 1997 , 1999 , 2003 , 2011 , 2017 , 2027 , 2029 , 2039 , 2053 , 2063 , 2069 , 2081 , 2083 , 2087 , 2089 , 2099 , 2111 , 2113 , 2129 , 2131 , 2137 , 2141 , 2143 , 2153 , 2161 , 2179 , 2203 , 2207 , 2213 , 2221 , 2237 , 2239 , 2243 , 2251 , 2267 , 2269 , 2273 , 2281 , 2287 , 2293 , 2297 , 2309 , 2311 , 2333 , 2339 , 2341 , 2347 , 2351 , 2357 , 2371 , 2377 , 2381 , 2383 , 2389 , 2393 , 2399 , 2411 , 2417 , 2423 , 2437 , 2441 , 2447 , 2459 , 2467 , 2473 , 2477 , 2503 , 2521 , 2531 , 2539 , 2543 , 2549 , 2551 , 2557 , 2579 , 2591 , 2593 , 2609 , 2617 , 2621 , 2633 , 2647 , 2657 , 2659 , 2663 , 2671 , 2677 , 2683 , 2687 , 2689 , 2693 , 2699 , 2707 , 2711 , 2713 , 2719 , 2729 , 2731 , 2741 , 2749 , 2753 , 2767 , 2777 , 2789 , 2791 , 2797 , 2801 , 2803 , 2819 , 2833 , 2837 , 2843 , 2851 , 2857 , 2861 , 2879 , 2887 , 2897 , 2903 , 2909 , 2917 , 2927 , 2939 , 2953 , 2957 , 2963 , 2969 , 2971 , 2999 , 3001 , 3011 , 3019 , 3023 , 3037 , 3041 , 3049 , 3061 , 3067 , 3079 , 3083 , 3089 , 3109 , 3119 , 3121 , 3137 , 3163 , 3167 , 3169 , 3181 , 3187 , 3191 , 3203 , 3209 , 3217 , 3221 , 3229 , 3251 , 3253 , 3257 , 3259 , 3271 , 3299 , 3301 , 3307 , 3313 , 3319 , 3323 , 3329 , 3331 , 3343 , 3347 , 3359 , 3361 , 3371 , 3373 , 3389 , 3391 , 3407 , 3413 , 3433 , 3449 , 3457 , 3461 , 3463 , 3467 , 3469 , 3491 , 3499 , 3511 , 3517 , 3527 , 3529 , 3533 , 3539 , 3541 , 3547 , 3557 , 3559 , 3571 , 3581 , 3583 , 3593 , 3607 , 3613 , 3617 , 3623 , 3631 , 3637 , 3643 , 3659 , 3671 };

    public static final int PRIMES_LAST = CallChecker.isCalled(SmallPrimes.PRIMES, int[].class, 69, 4707, 4712)[((CallChecker.isCalled(SmallPrimes.PRIMES, int[].class, 69, 4714, 4719).length) - 1)];

    private SmallPrimes() {
        ConstructorContext _bcornu_methode_context135 = new ConstructorContext(SmallPrimes.class, 74, 4739, 4810);
        try {
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public static int smallTrialDivision(int n, final List<Integer> factors) {
        MethodContext _bcornu_methode_context474 = new MethodContext(int.class, 83, 4817, 5314);
        try {
            CallChecker.varInit(factors, "factors", 83, 4817, 5314);
            CallChecker.varInit(n, "n", 83, 4817, 5314);
            CallChecker.varInit(PRIMES_LAST, "org.apache.commons.math3.primes.SmallPrimes.PRIMES_LAST", 83, 4817, 5314);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.primes.SmallPrimes.PRIMES", 83, 4817, 5314);
            if (CallChecker.beforeDeref(SmallPrimes.PRIMES, int.class, 84, 5166, 5171)) {
                for (int p : SmallPrimes.PRIMES) {
                    while (0 == (n % p)) {
                        n = n / p;
                        CallChecker.varAssign(n, "n", 86, 5225, 5234);
                        if (CallChecker.beforeDeref(factors, List.class, 87, 5252, 5258)) {
                            CallChecker.isCalled(factors, List.class, 87, 5252, 5258).add(p);
                        }
                    } 
                }
            }
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context474.methodEnd();
        }
    }

    public static int boundedTrialDivision(int n, int maxFactor, List<Integer> factors) {
        MethodContext _bcornu_methode_context475 = new MethodContext(int.class, 100, 5321, 6343);
        try {
            CallChecker.varInit(factors, "factors", 100, 5321, 6343);
            CallChecker.varInit(maxFactor, "maxFactor", 100, 5321, 6343);
            CallChecker.varInit(n, "n", 100, 5321, 6343);
            CallChecker.varInit(PRIMES_LAST, "org.apache.commons.math3.primes.SmallPrimes.PRIMES_LAST", 100, 5321, 6343);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.primes.SmallPrimes.PRIMES", 100, 5321, 6343);
            int f = CallChecker.varInit(((int) ((SmallPrimes.PRIMES_LAST) + 2)), "f", 101, 5860, 5883);
            while (f <= maxFactor) {
                if (0 == (n % f)) {
                    n = n / f;
                    CallChecker.varAssign(n, "n", 105, 6005, 6014);
                    if (CallChecker.beforeDeref(factors, List.class, 106, 6032, 6038)) {
                        factors = CallChecker.beforeCalled(factors, List.class, 106, 6032, 6038);
                        CallChecker.isCalled(factors, List.class, 106, 6032, 6038).add(f);
                    }
                    break;
                }
                f += 4;
                CallChecker.varAssign(f, "f", 109, 6097, 6103);
                if (0 == (n % f)) {
                    n = n / f;
                    CallChecker.varAssign(n, "n", 111, 6151, 6160);
                    if (CallChecker.beforeDeref(factors, List.class, 112, 6178, 6184)) {
                        factors = CallChecker.beforeCalled(factors, List.class, 112, 6178, 6184);
                        CallChecker.isCalled(factors, List.class, 112, 6178, 6184).add(f);
                    }
                    break;
                }
                f += 2;
                CallChecker.varAssign(f, "f", 115, 6243, 6249);
            } 
            if (n != 1) {
                if (CallChecker.beforeDeref(factors, List.class, 118, 6295, 6301)) {
                    factors = CallChecker.beforeCalled(factors, List.class, 118, 6295, 6301);
                    CallChecker.isCalled(factors, List.class, 118, 6295, 6301).add(n);
                }
            }
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context475.methodEnd();
        }
    }

    public static List<Integer> trialDivision(int n) {
        MethodContext _bcornu_methode_context476 = new MethodContext(List.class, 128, 6350, 6905);
        try {
            CallChecker.varInit(n, "n", 128, 6350, 6905);
            CallChecker.varInit(PRIMES_LAST, "org.apache.commons.math3.primes.SmallPrimes.PRIMES_LAST", 128, 6350, 6905);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.primes.SmallPrimes.PRIMES", 128, 6350, 6905);
            final List<Integer> factors = CallChecker.varInit(new ArrayList<Integer>(32), "factors", 129, 6547, 6603);
            n = SmallPrimes.smallTrialDivision(n, factors);
            CallChecker.varAssign(n, "n", 130, 6613, 6647);
            if (1 == n) {
                return factors;
            }
            final int bound = CallChecker.varInit(((int) ((int) (FastMath.sqrt(n)))), "bound", 135, 6717, 6826);
            SmallPrimes.boundedTrialDivision(n, bound, factors);
            return factors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context476.methodEnd();
        }
    }

    public static boolean millerRabinPrimeTest(final int n) {
        MethodContext _bcornu_methode_context477 = new MethodContext(boolean.class, 149, 6912, 8709);
        try {
            CallChecker.varInit(n, "n", 149, 6912, 8709);
            CallChecker.varInit(PRIMES_LAST, "org.apache.commons.math3.primes.SmallPrimes.PRIMES_LAST", 149, 6912, 8709);
            CallChecker.varInit(PRIMES, "org.apache.commons.math3.primes.SmallPrimes.PRIMES", 149, 6912, 8709);
            final int nMinus1 = CallChecker.varInit(((int) (n - 1)), "nMinus1", 150, 7424, 7449);
            final int s = CallChecker.varInit(((int) (Integer.numberOfTrailingZeros(nMinus1))), "s", 151, 7459, 7511);
            final int r = CallChecker.varInit(((int) (nMinus1 >> s)), "r", 152, 7521, 7547);
            int t = CallChecker.varInit(((int) (1)), "t", 154, 7605, 7614);
            if (n >= 2047) {
                t = 2;
                CallChecker.varAssign(t, "t", 156, 7653, 7658);
            }
            if (n >= 1373653) {
                t = 3;
                CallChecker.varAssign(t, "t", 159, 7710, 7715);
            }
            if (n >= 25326001) {
                t = 4;
                CallChecker.varAssign(t, "t", 162, 7768, 7773);
            }
            BigInteger br = CallChecker.varInit(BigInteger.valueOf(r), "br", 164, 7863, 7900);
            BigInteger bn = CallChecker.varInit(BigInteger.valueOf(n), "bn", 165, 7910, 7947);
            for (int i = 0; i < t; i++) {
                BigInteger a = CallChecker.init(BigInteger.class);
                if (CallChecker.beforeDeref(SmallPrimes.PRIMES, int[].class, 168, 8034, 8051)) {
                    a = BigInteger.valueOf(CallChecker.isCalled(SmallPrimes.PRIMES, int[].class, 168, 8034, 8051)[i]);
                    CallChecker.varAssign(a, "a", 168, 8034, 8051);
                }
                BigInteger bPow = CallChecker.init(BigInteger.class);
                if (CallChecker.beforeDeref(a, BigInteger.class, 169, 8088, 8088)) {
                    a = CallChecker.beforeCalled(a, BigInteger.class, 169, 8088, 8088);
                    bPow = CallChecker.isCalled(a, BigInteger.class, 169, 8088, 8088).modPow(br, bn);
                    CallChecker.varAssign(bPow, "bPow", 169, 8088, 8088);
                }
                int y = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(bPow, BigInteger.class, 170, 8126, 8129)) {
                    bPow = CallChecker.beforeCalled(bPow, BigInteger.class, 170, 8126, 8129);
                    y = CallChecker.isCalled(bPow, BigInteger.class, 170, 8126, 8129).intValue();
                    CallChecker.varAssign(y, "y", 170, 8126, 8129);
                }
                if ((1 != y) && (y != nMinus1)) {
                    int j = CallChecker.varInit(((int) (1)), "j", 172, 8205, 8214);
                    while ((j <= (s - 1)) && (nMinus1 != y)) {
                        long square = CallChecker.varInit(((long) (((long) (y)) * y)), "square", 174, 8293, 8321);
                        y = ((int) (square % n));
                        CallChecker.varAssign(y, "y", 175, 8343, 8365);
                        if (1 == y) {
                            return false;
                        }
                        j++;
                    } 
                    if (nMinus1 != y) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context477.methodEnd();
        }
    }
}

