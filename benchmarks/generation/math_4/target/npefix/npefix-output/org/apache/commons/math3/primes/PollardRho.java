package org.apache.commons.math3.primes;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;

class PollardRho {
    private PollardRho() {
        ConstructorContext _bcornu_methode_context1216 = new ConstructorContext(PollardRho.class, 34, 1072, 1142);
        try {
        } finally {
            _bcornu_methode_context1216.methodEnd();
        }
    }

    public static List<Integer> primeFactors(int n) {
        MethodContext _bcornu_methode_context5515 = new MethodContext(List.class, 42, 1149, 1791);
        try {
            CallChecker.varInit(n, "n", 42, 1149, 1791);
            final List<Integer> factors = CallChecker.varInit(new ArrayList<Integer>(), "factors", 43, 1372, 1426);
            n = SmallPrimes.smallTrialDivision(n, factors);
            CallChecker.varAssign(n, "n", 45, 1437, 1483);
            if (1 == n) {
                return factors;
            }
            if (SmallPrimes.millerRabinPrimeTest(n)) {
                if (CallChecker.beforeDeref(factors, List.class, 51, 1609, 1615)) {
                    CallChecker.isCalled(factors, List.class, 51, 1609, 1615).add(n);
                }
                return factors;
            }
            int divisor = CallChecker.varInit(((int) (PollardRho.rhoBrent(n))), "divisor", 55, 1672, 1697);
            if (CallChecker.beforeDeref(factors, List.class, 56, 1707, 1713)) {
                CallChecker.isCalled(factors, List.class, 56, 1707, 1713).add(divisor);
            }
            if (CallChecker.beforeDeref(factors, List.class, 57, 1737, 1743)) {
                CallChecker.isCalled(factors, List.class, 57, 1737, 1743).add((n / divisor));
            }
            return factors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5515.methodEnd();
        }
    }

    static int rhoBrent(final int n) {
        MethodContext _bcornu_methode_context5516 = new MethodContext(int.class, 73, 1798, 3841);
        try {
            CallChecker.varInit(n, "n", 73, 1798, 3841);
            final int x0 = CallChecker.varInit(((int) (2)), "x0", 74, 2392, 2408);
            final int m = CallChecker.varInit(((int) (25)), "m", 75, 2418, 2434);
            int cst = CallChecker.varInit(((int) (SmallPrimes.PRIMES_LAST)), "cst", 76, 2444, 2477);
            int y = CallChecker.varInit(((int) (x0)), "y", 77, 2487, 2497);
            int r = CallChecker.varInit(((int) (1)), "r", 78, 2507, 2516);
            do {
                int x = CallChecker.varInit(((int) (y)), "x", 80, 2543, 2552);
                for (int i = 0; i < r; i++) {
                    final long y2 = CallChecker.varInit(((long) (((long) (y)) * y)), "y2", 82, 2612, 2642);
                    y = ((int) ((y2 + cst) % n));
                    CallChecker.varAssign(y, "y", 83, 2660, 2686);
                }
                int k = CallChecker.varInit(((int) (0)), "k", 85, 2714, 2723);
                do {
                    final int bound = CallChecker.varInit(((int) (FastMath.min(m, (r - k)))), "bound", 87, 2758, 2798);
                    int q = CallChecker.varInit(((int) (1)), "q", 88, 2816, 2825);
                    for (int i = -3; i < bound; i++) {
                        final long y2 = CallChecker.varInit(((long) (((long) (y)) * y)), "y2", 90, 2958, 2988);
                        y = ((int) ((y2 + cst) % n));
                        CallChecker.varAssign(y, "y", 91, 3010, 3036);
                        final long divisor = CallChecker.varInit(((long) (FastMath.abs((x - y)))), "divisor", 92, 3058, 3098);
                        if (0 == divisor) {
                            cst += SmallPrimes.PRIMES_LAST;
                            CallChecker.varAssign(cst, "cst", 94, 3164, 3194);
                            k = -m;
                            CallChecker.varAssign(k, "k", 95, 3220, 3226);
                            y = x0;
                            CallChecker.varAssign(y, "y", 96, 3252, 3258);
                            r = 1;
                            CallChecker.varAssign(r, "r", 97, 3284, 3289);
                            break;
                        }
                        final long prod = CallChecker.varInit(((long) (divisor * q)), "prod", 100, 3364, 3393);
                        q = ((int) (prod % n));
                        CallChecker.varAssign(q, "q", 101, 3415, 3435);
                        if (0 == q) {
                            return PollardRho.gcdPositive(FastMath.abs(((int) (divisor))), n);
                        }
                    }
                    final int out = CallChecker.varInit(((int) (PollardRho.gcdPositive(FastMath.abs(q), n))), "out", 106, 3603, 3650);
                    if (1 != out) {
                        return out;
                    }
                    k = k + m;
                    CallChecker.varAssign(k, "k", 110, 3750, 3759);
                } while (k < r );
                r = 2 * r;
                CallChecker.varAssign(r, "r", 112, 3802, 3811);
            } while (true );
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5516.methodEnd();
        }
    }

    static int gcdPositive(int a, int b) {
        MethodContext _bcornu_methode_context5517 = new MethodContext(int.class, 133, 3848, 5676);
        try {
            CallChecker.varInit(b, "b", 133, 3848, 5676);
            CallChecker.varInit(a, "a", 133, 3848, 5676);
            if (a == 0) {
                return b;
            }else
                if (b == 0) {
                    return a;
                }
            
            final int aTwos = CallChecker.varInit(((int) (Integer.numberOfTrailingZeros(a))), "aTwos", 143, 4764, 4881);
            a >>= aTwos;
            CallChecker.varAssign(a, "a", 144, 4891, 4902);
            final int bTwos = CallChecker.varInit(((int) (Integer.numberOfTrailingZeros(b))), "bTwos", 145, 4912, 4962);
            b >>= bTwos;
            CallChecker.varAssign(b, "b", 146, 4972, 4983);
            final int shift = CallChecker.varInit(((int) (FastMath.min(aTwos, bTwos))), "shift", 147, 4993, 5037);
            while (a != b) {
                final int delta = CallChecker.varInit(((int) (a - b)), "delta", 154, 5285, 5308);
                b = FastMath.min(a, b);
                CallChecker.varAssign(b, "b", 155, 5322, 5344);
                a = FastMath.abs(delta);
                CallChecker.varAssign(a, "a", 156, 5358, 5381);
                a >>= Integer.numberOfTrailingZeros(a);
                CallChecker.varAssign(a, "a", 159, 5533, 5571);
            } 
            return a << shift;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5517.methodEnd();
        }
    }
}

