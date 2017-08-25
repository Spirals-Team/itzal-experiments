package org.apache.commons.math3.primes;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class Primes {
    private Primes() {
        ConstructorContext _bcornu_methode_context855 = new ConstructorContext(Primes.class, 41, 1253, 1319);
        try {
        } finally {
            _bcornu_methode_context855.methodEnd();
        }
    }

    public static boolean isPrime(int n) {
        MethodContext _bcornu_methode_context3733 = new MethodContext(boolean.class, 54, 1326, 2042);
        try {
            CallChecker.varInit(n, "n", 54, 1326, 2042);
            if (n < 2) {
                return false;
            }
            if (CallChecker.beforeDeref(SmallPrimes.PRIMES, boolean.class, 59, 1877, 1894)) {
                for (int p : SmallPrimes.PRIMES) {
                    if (0 == (n % p)) {
                        return n == p;
                    }
                }
            }
            return SmallPrimes.millerRabinPrimeTest(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3733.methodEnd();
        }
    }

    public static int nextPrime(int n) {
        MethodContext _bcornu_methode_context3734 = new MethodContext(int.class, 74, 2049, 3264);
        try {
            CallChecker.varInit(n, "n", 74, 2049, 3264);
            if (n < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, n, 0);
            }
            if (n == 2) {
                return 2;
            }
            n = n | 1;
            CallChecker.varAssign(n, "n", 81, 2510, 2519);
            if (n == 1) {
                return 2;
            }
            if (Primes.isPrime(n)) {
                return n;
            }
            final int rem = CallChecker.varInit(((int) (n % 3)), "rem", 92, 2663, 2772);
            if (0 == rem) {
                n += 2;
                CallChecker.varAssign(n, "n", 94, 2827, 2833);
            }else
                if (1 == rem) {
                    n += 4;
                    CallChecker.varAssign(n, "n", 97, 2950, 2956);
                }
            
            while (true) {
                if (Primes.isPrime(n)) {
                    return n;
                }
                n += 2;
                CallChecker.varAssign(n, "n", 103, 3124, 3130);
                if (Primes.isPrime(n)) {
                    return n;
                }
                n += 4;
                CallChecker.varAssign(n, "n", 107, 3228, 3234);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3734.methodEnd();
        }
    }

    public static List<Integer> primeFactors(int n) {
        MethodContext _bcornu_methode_context3735 = new MethodContext(List.class, 118, 3271, 3896);
        try {
            CallChecker.varInit(n, "n", 118, 3271, 3896);
            if (n < 2) {
                throw new MathIllegalArgumentException(LocalizedFormats.NUMBER_TOO_SMALL, n, 2);
            }
            return SmallPrimes.trialDivision(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3735.methodEnd();
        }
    }
}

