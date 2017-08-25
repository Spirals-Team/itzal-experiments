package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Collection;
import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.CauchyDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.distribution.PascalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class RandomDataGenerator implements Serializable , RandomData {
    private static final long serialVersionUID = -626730818244969716L;

    private RandomGenerator rand = null;

    private SecureRandom secRand = null;

    public RandomDataGenerator() {
        ConstructorContext _bcornu_methode_context919 = new ConstructorContext(RandomDataGenerator.class, 130, 6176, 6552);
        try {
        } finally {
            _bcornu_methode_context919.methodEnd();
        }
    }

    public RandomDataGenerator(RandomGenerator rand) {
        ConstructorContext _bcornu_methode_context920 = new ConstructorContext(RandomDataGenerator.class, 140, 6559, 6910);
        try {
            this.rand = rand;
            CallChecker.varAssign(this.rand, "this.rand", 141, 6888, 6904);
        } finally {
            _bcornu_methode_context920.methodEnd();
        }
    }

    public String nextHexString(int len) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4172 = new MethodContext(String.class, 160, 6917, 8663);
        try {
            CallChecker.varInit(this, "this", 160, 6917, 8663);
            CallChecker.varInit(len, "len", 160, 6917, 8663);
            CallChecker.varInit(this.secRand, "secRand", 160, 6917, 8663);
            CallChecker.varInit(this.rand, "rand", 160, 6917, 8663);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 160, 6917, 8663);
            if (len <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, len);
            }
            RandomGenerator ran = CallChecker.varInit(getRandomGenerator(), "ran", 166, 7661, 7703);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 169, 7750, 7795);
            byte[] randomBytes = CallChecker.varInit(new byte[(len / 2) + 1], "randomBytes", 172, 7847, 7891);
            if (CallChecker.beforeDeref(ran, RandomGenerator.class, 173, 7901, 7903)) {
                ran = CallChecker.beforeCalled(ran, RandomGenerator.class, 173, 7901, 7903);
                CallChecker.isCalled(ran, RandomGenerator.class, 173, 7901, 7903).nextBytes(randomBytes);
            }
            randomBytes = CallChecker.beforeCalled(randomBytes, byte[].class, 176, 8003, 8013);
            for (int i = 0; i < (CallChecker.isCalled(randomBytes, byte[].class, 176, 8003, 8013).length); i++) {
                Integer c = CallChecker.init(Integer.class);
                if (CallChecker.beforeDeref(randomBytes, byte[].class, 177, 8070, 8080)) {
                    randomBytes = CallChecker.beforeCalled(randomBytes, byte[].class, 177, 8070, 8080);
                    c = Integer.valueOf(CallChecker.isCalled(randomBytes, byte[].class, 177, 8070, 8080)[i]);
                    CallChecker.varAssign(c, "c", 177, 8070, 8080);
                }
                String hex = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(c, Integer.class, 184, 8394, 8394)) {
                    c = CallChecker.beforeCalled(c, Integer.class, 184, 8394, 8394);
                    hex = Integer.toHexString(((CallChecker.isCalled(c, Integer.class, 184, 8394, 8394).intValue()) + 128));
                    CallChecker.varAssign(hex, "hex", 184, 8394, 8394);
                }
                if (CallChecker.beforeDeref(hex, String.class, 187, 8491, 8493)) {
                    hex = CallChecker.beforeCalled(hex, String.class, 187, 8491, 8493);
                    if ((CallChecker.isCalled(hex, String.class, 187, 8491, 8493).length()) == 1) {
                        hex = "0" + hex;
                        CallChecker.varAssign(hex, "hex", 188, 8528, 8543);
                    }
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 190, 8571, 8579)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 190, 8571, 8579);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 190, 8571, 8579).append(hex);
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 192, 8619, 8627)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 192, 8619, 8627);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 192, 8619, 8627).toString(), String.class, 192, 8619, 8638)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 192, 8619, 8627);
                    return CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 192, 8619, 8627).toString(), String.class, 192, 8619, 8638).substring(0, len);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4172.methodEnd();
        }
    }

    public int nextInt(final int lower, final int upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4173 = new MethodContext(int.class, 196, 8670, 9660);
        try {
            CallChecker.varInit(this, "this", 196, 8670, 9660);
            CallChecker.varInit(upper, "upper", 196, 8670, 9660);
            CallChecker.varInit(lower, "lower", 196, 8670, 9660);
            CallChecker.varInit(this.secRand, "secRand", 196, 8670, 9660);
            CallChecker.varInit(this.rand, "rand", 196, 8670, 9660);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 196, 8670, 9660);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            final int max = CallChecker.varInit(((int) ((upper - lower) + 1)), "max", 201, 9001, 9036);
            if (max <= 0) {
                final RandomGenerator rng = CallChecker.varInit(getRandomGenerator(), "rng", 205, 9074, 9308);
                while (true) {
                    final int r = CallChecker.varInit(((int) (CallChecker.isCalled(rng, RandomGenerator.class, 207, 9367, 9369).nextInt())), "r", 207, 9353, 9380);
                    if ((r >= lower) && (r <= upper)) {
                        return r;
                    }
                } 
            }else {
                return lower + (CallChecker.isCalled(getRandomGenerator(), RandomGenerator.class, 214, 9611, 9630).nextInt(max));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4173.methodEnd();
        }
    }

    public long nextLong(final long lower, final long upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4174 = new MethodContext(long.class, 219, 9667, 10853);
        try {
            CallChecker.varInit(this, "this", 219, 9667, 10853);
            CallChecker.varInit(upper, "upper", 219, 9667, 10853);
            CallChecker.varInit(lower, "lower", 219, 9667, 10853);
            CallChecker.varInit(this.secRand, "secRand", 219, 9667, 10853);
            CallChecker.varInit(this.rand, "rand", 219, 9667, 10853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 219, 9667, 10853);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            final long max = CallChecker.varInit(((long) ((upper - lower) + 1)), "max", 224, 10002, 10038);
            if (max <= 0) {
                final RandomGenerator rng = CallChecker.varInit(getRandomGenerator(), "rng", 228, 10076, 10308);
                while (true) {
                    final long r = CallChecker.varInit(((long) (CallChecker.isCalled(rng, RandomGenerator.class, 230, 10368, 10370).nextLong())), "r", 230, 10353, 10382);
                    if ((r >= lower) && (r <= upper)) {
                        return r;
                    }
                } 
            }else
                if (max < (Integer.MAX_VALUE)) {
                    return lower + (CallChecker.isCalled(getRandomGenerator(), RandomGenerator.class, 237, 10641, 10660).nextInt(((int) (max))));
                }else {
                    return lower + (RandomDataGenerator.nextLong(getRandomGenerator(), max));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4174.methodEnd();
        }
    }

    private static long nextLong(final RandomGenerator rng, final long n) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context4175 = new MethodContext(long.class, 256, 10860, 12053);
        try {
            CallChecker.varInit(n, "n", 256, 10860, 12053);
            CallChecker.varInit(rng, "rng", 256, 10860, 12053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 256, 10860, 12053);
            if (n > 0) {
                final byte[] byteArray = CallChecker.varInit(new byte[8], "byteArray", 258, 11534, 11570);
                long bits = CallChecker.init(long.class);
                long val = CallChecker.init(long.class);
                do {
                    if (CallChecker.beforeDeref(rng, RandomGenerator.class, 262, 11650, 11652)) {
                        CallChecker.isCalled(rng, RandomGenerator.class, 262, 11650, 11652).nextBytes(byteArray);
                    }
                    bits = 0;
                    CallChecker.varAssign(bits, "bits", 263, 11692, 11700);
                    if (CallChecker.beforeDeref(byteArray, long.class, 264, 11738, 11746)) {
                        for (final byte b : byteArray) {
                            bits = (bits << 8) | (((long) (b)) & 255L);
                            CallChecker.varAssign(bits, "bits", 265, 11771, 11812);
                        }
                    }
                    bits = bits & 9223372036854775807L;
                    CallChecker.varAssign(bits, "bits", 267, 11848, 11881);
                    val = bits % n;
                    CallChecker.varAssign(val, "val", 268, 11899, 11914);
                } while (((bits - val) + (n - 1)) < 0 );
                return val;
            }
            throw new NotStrictlyPositiveException(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4175.methodEnd();
        }
    }

    public String nextSecureHexString(int len) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4176 = new MethodContext(String.class, 292, 12060, 14406);
        try {
            CallChecker.varInit(this, "this", 292, 12060, 14406);
            CallChecker.varInit(len, "len", 292, 12060, 14406);
            CallChecker.varInit(this.secRand, "secRand", 292, 12060, 14406);
            CallChecker.varInit(this.rand, "rand", 292, 12060, 14406);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 292, 12060, 14406);
            if (len <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, len);
            }
            SecureRandom secRan = CallChecker.varInit(getSecRan(), "secRan", 298, 12867, 12900);
            MessageDigest alg = CallChecker.varInit(null, "alg", 299, 12910, 12934);
            TryContext _bcornu_try_context_88 = new TryContext(88, RandomDataGenerator.class, "java.security.NoSuchAlgorithmException");
            try {
                alg = MessageDigest.getInstance("SHA-1");
                CallChecker.varAssign(alg, "alg", 301, 12962, 13002);
            } catch (NoSuchAlgorithmException ex) {
                _bcornu_try_context_88.catchStart(88);
                throw new MathInternalError(ex);
            } finally {
                _bcornu_try_context_88.finallyStart(88);
            }
            if (CallChecker.beforeDeref(alg, MessageDigest.class, 306, 13155, 13157)) {
                alg = CallChecker.beforeCalled(alg, MessageDigest.class, 306, 13155, 13157);
                CallChecker.isCalled(alg, MessageDigest.class, 306, 13155, 13157).reset();
            }
            int numIter = CallChecker.varInit(((int) ((len / 40) + 1)), "numIter", 309, 13242, 13270);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 311, 13281, 13326);
            for (int iter = 1; iter < (numIter + 1); iter++) {
                byte[] randomBytes = CallChecker.varInit(new byte[40], "randomBytes", 313, 13397, 13430);
                if (CallChecker.beforeDeref(secRan, SecureRandom.class, 314, 13444, 13449)) {
                    secRan = CallChecker.beforeCalled(secRan, SecureRandom.class, 314, 13444, 13449);
                    CallChecker.isCalled(secRan, SecureRandom.class, 314, 13444, 13449).nextBytes(randomBytes);
                }
                if (CallChecker.beforeDeref(alg, MessageDigest.class, 315, 13487, 13489)) {
                    alg = CallChecker.beforeCalled(alg, MessageDigest.class, 315, 13487, 13489);
                    CallChecker.isCalled(alg, MessageDigest.class, 315, 13487, 13489).update(randomBytes);
                }
                byte[] hash = CallChecker.init(byte[].class);
                if (CallChecker.beforeDeref(alg, MessageDigest.class, 318, 13602, 13604)) {
                    alg = CallChecker.beforeCalled(alg, MessageDigest.class, 318, 13602, 13604);
                    hash = CallChecker.isCalled(alg, MessageDigest.class, 318, 13602, 13604).digest();
                    CallChecker.varAssign(hash, "hash", 318, 13602, 13604);
                }
                hash = CallChecker.beforeCalled(hash, byte[].class, 321, 13721, 13724);
                for (int i = 0; i < (CallChecker.isCalled(hash, byte[].class, 321, 13721, 13724).length); i++) {
                    Integer c = CallChecker.init(Integer.class);
                    if (CallChecker.beforeDeref(hash, byte[].class, 322, 13785, 13788)) {
                        hash = CallChecker.beforeCalled(hash, byte[].class, 322, 13785, 13788);
                        c = Integer.valueOf(CallChecker.isCalled(hash, byte[].class, 322, 13785, 13788)[i]);
                        CallChecker.varAssign(c, "c", 322, 13785, 13788);
                    }
                    String hex = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(c, Integer.class, 329, 14096, 14096)) {
                        c = CallChecker.beforeCalled(c, Integer.class, 329, 14096, 14096);
                        hex = Integer.toHexString(((CallChecker.isCalled(c, Integer.class, 329, 14096, 14096).intValue()) + 128));
                        CallChecker.varAssign(hex, "hex", 329, 14096, 14096);
                    }
                    if (CallChecker.beforeDeref(hex, String.class, 332, 14208, 14210)) {
                        hex = CallChecker.beforeCalled(hex, String.class, 332, 14208, 14210);
                        if ((CallChecker.isCalled(hex, String.class, 332, 14208, 14210).length()) == 1) {
                            hex = "0" + hex;
                            CallChecker.varAssign(hex, "hex", 333, 14249, 14264);
                        }
                    }
                    if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 335, 14300, 14308)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 335, 14300, 14308);
                        CallChecker.isCalled(outBuffer, StringBuilder.class, 335, 14300, 14308).append(hex);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 338, 14362, 14370)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 338, 14362, 14370);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuilder.class, 338, 14362, 14370).toString(), String.class, 338, 14362, 14381)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 338, 14362, 14370);
                    return CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuilder.class, 338, 14362, 14370).toString(), String.class, 338, 14362, 14381).substring(0, len);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4176.methodEnd();
        }
    }

    public int nextSecureInt(final int lower, final int upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4177 = new MethodContext(int.class, 342, 14413, 15389);
        try {
            CallChecker.varInit(this, "this", 342, 14413, 15389);
            CallChecker.varInit(upper, "upper", 342, 14413, 15389);
            CallChecker.varInit(lower, "lower", 342, 14413, 15389);
            CallChecker.varInit(this.secRand, "secRand", 342, 14413, 15389);
            CallChecker.varInit(this.rand, "rand", 342, 14413, 15389);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 342, 14413, 15389);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            final int max = CallChecker.varInit(((int) ((upper - lower) + 1)), "max", 347, 14751, 14786);
            if (max <= 0) {
                final SecureRandom rng = CallChecker.varInit(getSecRan(), "rng", 351, 14824, 15046);
                while (true) {
                    final int r = CallChecker.varInit(((int) (CallChecker.isCalled(rng, SecureRandom.class, 353, 15105, 15107).nextInt())), "r", 353, 15091, 15118);
                    if ((r >= lower) && (r <= upper)) {
                        return r;
                    }
                } 
            }else {
                return lower + (CallChecker.isCalled(getSecRan(), SecureRandom.class, 360, 15349, 15359).nextInt(max));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4177.methodEnd();
        }
    }

    public long nextSecureLong(final long lower, final long upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4178 = new MethodContext(long.class, 365, 15396, 16558);
        try {
            CallChecker.varInit(this, "this", 365, 15396, 16558);
            CallChecker.varInit(upper, "upper", 365, 15396, 16558);
            CallChecker.varInit(lower, "lower", 365, 15396, 16558);
            CallChecker.varInit(this.secRand, "secRand", 365, 15396, 16558);
            CallChecker.varInit(this.rand, "rand", 365, 15396, 16558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 365, 15396, 16558);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            final long max = CallChecker.varInit(((long) ((upper - lower) + 1)), "max", 370, 15737, 15773);
            if (max <= 0) {
                final SecureRandom rng = CallChecker.varInit(getSecRan(), "rng", 374, 15811, 16031);
                while (true) {
                    final long r = CallChecker.varInit(((long) (CallChecker.isCalled(rng, SecureRandom.class, 376, 16091, 16093).nextLong())), "r", 376, 16076, 16105);
                    if ((r >= lower) && (r <= upper)) {
                        return r;
                    }
                } 
            }else
                if (max < (Integer.MAX_VALUE)) {
                    return lower + (CallChecker.isCalled(getSecRan(), SecureRandom.class, 383, 16364, 16374).nextInt(((int) (max))));
                }else {
                    return lower + (RandomDataGenerator.nextLong(getSecRan(), max));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4178.methodEnd();
        }
    }

    private static long nextLong(final SecureRandom rng, final long n) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context4179 = new MethodContext(long.class, 402, 16565, 17755);
        try {
            CallChecker.varInit(n, "n", 402, 16565, 17755);
            CallChecker.varInit(rng, "rng", 402, 16565, 17755);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 402, 16565, 17755);
            if (n > 0) {
                final byte[] byteArray = CallChecker.varInit(new byte[8], "byteArray", 404, 17236, 17272);
                long bits = CallChecker.init(long.class);
                long val = CallChecker.init(long.class);
                do {
                    if (CallChecker.beforeDeref(rng, SecureRandom.class, 408, 17352, 17354)) {
                        CallChecker.isCalled(rng, SecureRandom.class, 408, 17352, 17354).nextBytes(byteArray);
                    }
                    bits = 0;
                    CallChecker.varAssign(bits, "bits", 409, 17394, 17402);
                    if (CallChecker.beforeDeref(byteArray, long.class, 410, 17440, 17448)) {
                        for (final byte b : byteArray) {
                            bits = (bits << 8) | (((long) (b)) & 255L);
                            CallChecker.varAssign(bits, "bits", 411, 17473, 17514);
                        }
                    }
                    bits = bits & 9223372036854775807L;
                    CallChecker.varAssign(bits, "bits", 413, 17550, 17583);
                    val = bits % n;
                    CallChecker.varAssign(val, "val", 414, 17601, 17616);
                } while (((bits - val) + (n - 1)) < 0 );
                return val;
            }
            throw new NotStrictlyPositiveException(n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4179.methodEnd();
        }
    }

    public long nextPoisson(double mean) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4180 = new MethodContext(long.class, 435, 17762, 18709);
        try {
            CallChecker.varInit(this, "this", 435, 17762, 18709);
            CallChecker.varInit(mean, "mean", 435, 17762, 18709);
            CallChecker.varInit(this.secRand, "secRand", 435, 17762, 18709);
            CallChecker.varInit(this.rand, "rand", 435, 17762, 18709);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 435, 17762, 18709);
            if (CallChecker.beforeDeref(new PoissonDistribution(getRandomGenerator(), mean, PoissonDistribution.DEFAULT_EPSILON, PoissonDistribution.DEFAULT_MAX_ITERATIONS), PoissonDistribution.class, 436, 18530, 18693)) {
                return CallChecker.isCalled(new PoissonDistribution(getRandomGenerator(), mean, PoissonDistribution.DEFAULT_EPSILON, PoissonDistribution.DEFAULT_MAX_ITERATIONS), PoissonDistribution.class, 436, 18530, 18693).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4180.methodEnd();
        }
    }

    public double nextGaussian(double mu, double sigma) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4181 = new MethodContext(double.class, 442, 18716, 19032);
        try {
            CallChecker.varInit(this, "this", 442, 18716, 19032);
            CallChecker.varInit(sigma, "sigma", 442, 18716, 19032);
            CallChecker.varInit(mu, "mu", 442, 18716, 19032);
            CallChecker.varInit(this.secRand, "secRand", 442, 18716, 19032);
            CallChecker.varInit(this.rand, "rand", 442, 18716, 19032);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 442, 18716, 19032);
            if (sigma <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, sigma);
            }
            return (sigma * (CallChecker.isCalled(getRandomGenerator(), RandomGenerator.class, 446, 18986, 19005).nextGaussian())) + mu;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4181.methodEnd();
        }
    }

    public double nextExponential(double mean) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4182 = new MethodContext(double.class, 460, 19039, 19628);
        try {
            CallChecker.varInit(this, "this", 460, 19039, 19628);
            CallChecker.varInit(mean, "mean", 460, 19039, 19628);
            CallChecker.varInit(this.secRand, "secRand", 460, 19039, 19628);
            CallChecker.varInit(this.rand, "rand", 460, 19039, 19628);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 460, 19039, 19628);
            if (CallChecker.beforeDeref(new ExponentialDistribution(getRandomGenerator(), mean, ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), ExponentialDistribution.class, 461, 19483, 19612)) {
                return CallChecker.isCalled(new ExponentialDistribution(getRandomGenerator(), mean, ExponentialDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), ExponentialDistribution.class, 461, 19483, 19612).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4182.methodEnd();
        }
    }

    public double nextGamma(double shape, double scale) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4183 = new MethodContext(double.class, 487, 19635, 20849);
        try {
            CallChecker.varInit(this, "this", 487, 19635, 20849);
            CallChecker.varInit(scale, "scale", 487, 19635, 20849);
            CallChecker.varInit(shape, "shape", 487, 19635, 20849);
            CallChecker.varInit(this.secRand, "secRand", 487, 19635, 20849);
            CallChecker.varInit(this.rand, "rand", 487, 19635, 20849);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 487, 19635, 20849);
            if (CallChecker.beforeDeref(new GammaDistribution(getRandomGenerator(), shape, scale, GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), GammaDistribution.class, 488, 20709, 20833)) {
                return CallChecker.isCalled(new GammaDistribution(getRandomGenerator(), shape, scale, GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), GammaDistribution.class, 488, 20709, 20833).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4183.methodEnd();
        }
    }

    public int nextHypergeometric(int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4184 = new MethodContext(int.class, 504, 20856, 21956);
        try {
            CallChecker.varInit(this, "this", 504, 20856, 21956);
            CallChecker.varInit(sampleSize, "sampleSize", 504, 20856, 21956);
            CallChecker.varInit(numberOfSuccesses, "numberOfSuccesses", 504, 20856, 21956);
            CallChecker.varInit(populationSize, "populationSize", 504, 20856, 21956);
            CallChecker.varInit(this.secRand, "secRand", 504, 20856, 21956);
            CallChecker.varInit(this.rand, "rand", 504, 20856, 21956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 504, 20856, 21956);
            if (CallChecker.beforeDeref(new HypergeometricDistribution(getRandomGenerator(), populationSize, numberOfSuccesses, sampleSize), HypergeometricDistribution.class, 505, 21827, 21940)) {
                return CallChecker.isCalled(new HypergeometricDistribution(getRandomGenerator(), populationSize, numberOfSuccesses, sampleSize), HypergeometricDistribution.class, 505, 21827, 21940).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4184.methodEnd();
        }
    }

    public int nextPascal(int r, double p) throws NotStrictlyPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context4185 = new MethodContext(int.class, 519, 21963, 22656);
        try {
            CallChecker.varInit(this, "this", 519, 21963, 22656);
            CallChecker.varInit(p, "p", 519, 21963, 22656);
            CallChecker.varInit(r, "r", 519, 21963, 22656);
            CallChecker.varInit(this.secRand, "secRand", 519, 21963, 22656);
            CallChecker.varInit(this.rand, "rand", 519, 21963, 22656);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 519, 21963, 22656);
            if (CallChecker.beforeDeref(new PascalDistribution(getRandomGenerator(), r, p), PascalDistribution.class, 520, 22591, 22640)) {
                return CallChecker.isCalled(new PascalDistribution(getRandomGenerator(), r, p), PascalDistribution.class, 520, 22591, 22640).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4185.methodEnd();
        }
    }

    public double nextT(double df) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4186 = new MethodContext(double.class, 530, 22663, 23153);
        try {
            CallChecker.varInit(this, "this", 530, 22663, 23153);
            CallChecker.varInit(df, "df", 530, 22663, 23153);
            CallChecker.varInit(this.secRand, "secRand", 530, 22663, 23153);
            CallChecker.varInit(this.rand, "rand", 530, 22663, 23153);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 530, 22663, 23153);
            if (CallChecker.beforeDeref(new TDistribution(getRandomGenerator(), df, TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), TDistribution.class, 531, 23030, 23137)) {
                return CallChecker.isCalled(new TDistribution(getRandomGenerator(), df, TDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), TDistribution.class, 531, 23030, 23137).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4186.methodEnd();
        }
    }

    public double nextWeibull(double shape, double scale) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4187 = new MethodContext(double.class, 544, 23160, 23837);
        try {
            CallChecker.varInit(this, "this", 544, 23160, 23837);
            CallChecker.varInit(scale, "scale", 544, 23160, 23837);
            CallChecker.varInit(shape, "shape", 544, 23160, 23837);
            CallChecker.varInit(this.secRand, "secRand", 544, 23160, 23837);
            CallChecker.varInit(this.rand, "rand", 544, 23160, 23837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 544, 23160, 23837);
            if (CallChecker.beforeDeref(new WeibullDistribution(getRandomGenerator(), shape, scale, WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), WeibullDistribution.class, 545, 23692, 23821)) {
                return CallChecker.isCalled(new WeibullDistribution(getRandomGenerator(), shape, scale, WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), WeibullDistribution.class, 545, 23692, 23821).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4187.methodEnd();
        }
    }

    public int nextZipf(int numberOfElements, double exponent) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4188 = new MethodContext(int.class, 558, 23844, 24491);
        try {
            CallChecker.varInit(this, "this", 558, 23844, 24491);
            CallChecker.varInit(exponent, "exponent", 558, 23844, 24491);
            CallChecker.varInit(numberOfElements, "numberOfElements", 558, 23844, 24491);
            CallChecker.varInit(this.secRand, "secRand", 558, 23844, 24491);
            CallChecker.varInit(this.rand, "rand", 558, 23844, 24491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 558, 23844, 24491);
            if (CallChecker.beforeDeref(new ZipfDistribution(getRandomGenerator(), numberOfElements, exponent), ZipfDistribution.class, 559, 24406, 24475)) {
                return CallChecker.isCalled(new ZipfDistribution(getRandomGenerator(), numberOfElements, exponent), ZipfDistribution.class, 559, 24406, 24475).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4188.methodEnd();
        }
    }

    public double nextBeta(double alpha, double beta) {
        MethodContext _bcornu_methode_context4189 = new MethodContext(double.class, 569, 24498, 24997);
        try {
            CallChecker.varInit(this, "this", 569, 24498, 24997);
            CallChecker.varInit(beta, "beta", 569, 24498, 24997);
            CallChecker.varInit(alpha, "alpha", 569, 24498, 24997);
            CallChecker.varInit(this.secRand, "secRand", 569, 24498, 24997);
            CallChecker.varInit(this.rand, "rand", 569, 24498, 24997);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 569, 24498, 24997);
            if (CallChecker.beforeDeref(new BetaDistribution(getRandomGenerator(), alpha, beta, BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), BetaDistribution.class, 570, 24859, 24981)) {
                return CallChecker.isCalled(new BetaDistribution(getRandomGenerator(), alpha, beta, BetaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), BetaDistribution.class, 570, 24859, 24981).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4189.methodEnd();
        }
    }

    public int nextBinomial(int numberOfTrials, double probabilityOfSuccess) {
        MethodContext _bcornu_methode_context4190 = new MethodContext(int.class, 581, 25004, 25576);
        try {
            CallChecker.varInit(this, "this", 581, 25004, 25576);
            CallChecker.varInit(probabilityOfSuccess, "probabilityOfSuccess", 581, 25004, 25576);
            CallChecker.varInit(numberOfTrials, "numberOfTrials", 581, 25004, 25576);
            CallChecker.varInit(this.secRand, "secRand", 581, 25004, 25576);
            CallChecker.varInit(this.rand, "rand", 581, 25004, 25576);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 581, 25004, 25576);
            if (CallChecker.beforeDeref(new BinomialDistribution(getRandomGenerator(), numberOfTrials, probabilityOfSuccess), BinomialDistribution.class, 582, 25477, 25560)) {
                return CallChecker.isCalled(new BinomialDistribution(getRandomGenerator(), numberOfTrials, probabilityOfSuccess), BinomialDistribution.class, 582, 25477, 25560).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4190.methodEnd();
        }
    }

    public double nextCauchy(double median, double scale) {
        MethodContext _bcornu_methode_context4191 = new MethodContext(double.class, 592, 25583, 26116);
        try {
            CallChecker.varInit(this, "this", 592, 25583, 26116);
            CallChecker.varInit(scale, "scale", 592, 25583, 26116);
            CallChecker.varInit(median, "median", 592, 25583, 26116);
            CallChecker.varInit(this.secRand, "secRand", 592, 25583, 26116);
            CallChecker.varInit(this.rand, "rand", 592, 25583, 26116);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 592, 25583, 26116);
            if (CallChecker.beforeDeref(new CauchyDistribution(getRandomGenerator(), median, scale, CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), CauchyDistribution.class, 593, 25972, 26100)) {
                return CallChecker.isCalled(new CauchyDistribution(getRandomGenerator(), median, scale, CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), CauchyDistribution.class, 593, 25972, 26100).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4191.methodEnd();
        }
    }

    public double nextChiSquare(double df) {
        MethodContext _bcornu_methode_context4192 = new MethodContext(double.class, 603, 26123, 26581);
        try {
            CallChecker.varInit(this, "this", 603, 26123, 26581);
            CallChecker.varInit(df, "df", 603, 26123, 26581);
            CallChecker.varInit(this.secRand, "secRand", 603, 26123, 26581);
            CallChecker.varInit(this.rand, "rand", 603, 26123, 26581);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 603, 26123, 26581);
            if (CallChecker.beforeDeref(new ChiSquaredDistribution(getRandomGenerator(), df, ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), ChiSquaredDistribution.class, 604, 26440, 26565)) {
                return CallChecker.isCalled(new ChiSquaredDistribution(getRandomGenerator(), df, ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), ChiSquaredDistribution.class, 604, 26440, 26565).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4192.methodEnd();
        }
    }

    public double nextF(double numeratorDf, double denominatorDf) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4193 = new MethodContext(double.class, 617, 26588, 27316);
        try {
            CallChecker.varInit(this, "this", 617, 26588, 27316);
            CallChecker.varInit(denominatorDf, "denominatorDf", 617, 26588, 27316);
            CallChecker.varInit(numeratorDf, "numeratorDf", 617, 26588, 27316);
            CallChecker.varInit(this.secRand, "secRand", 617, 26588, 27316);
            CallChecker.varInit(this.rand, "rand", 617, 26588, 27316);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 617, 26588, 27316);
            if (CallChecker.beforeDeref(new FDistribution(getRandomGenerator(), numeratorDf, denominatorDf, FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), FDistribution.class, 618, 27169, 27300)) {
                return CallChecker.isCalled(new FDistribution(getRandomGenerator(), numeratorDf, denominatorDf, FDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY), FDistribution.class, 618, 27169, 27300).sample();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4193.methodEnd();
        }
    }

    public double nextUniform(double lower, double upper) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4194 = new MethodContext(double.class, 635, 27323, 28083);
        try {
            CallChecker.varInit(this, "this", 635, 27323, 28083);
            CallChecker.varInit(upper, "upper", 635, 27323, 28083);
            CallChecker.varInit(lower, "lower", 635, 27323, 28083);
            CallChecker.varInit(this.secRand, "secRand", 635, 27323, 28083);
            CallChecker.varInit(this.rand, "rand", 635, 27323, 28083);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 635, 27323, 28083);
            return nextUniform(lower, upper, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4194.methodEnd();
        }
    }

    public double nextUniform(double lower, double upper, boolean lowerInclusive) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4195 = new MethodContext(double.class, 655, 28090, 29766);
        try {
            CallChecker.varInit(this, "this", 655, 28090, 29766);
            CallChecker.varInit(lowerInclusive, "lowerInclusive", 655, 28090, 29766);
            CallChecker.varInit(upper, "upper", 655, 28090, 29766);
            CallChecker.varInit(lower, "lower", 655, 28090, 29766);
            CallChecker.varInit(this.secRand, "secRand", 655, 28090, 29766);
            CallChecker.varInit(this.rand, "rand", 655, 28090, 29766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 655, 28090, 29766);
            if (lower >= upper) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, lower, upper, false);
            }
            if (Double.isInfinite(lower)) {
                throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, lower);
            }
            if (Double.isInfinite(upper)) {
                throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, upper);
            }
            if ((Double.isNaN(lower)) || (Double.isNaN(upper))) {
                throw new NotANumberException();
            }
            final RandomGenerator generator = CallChecker.varInit(getRandomGenerator(), "generator", 674, 29478, 29532);
            double u = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(generator, RandomGenerator.class, 677, 29595, 29603)) {
                u = CallChecker.isCalled(generator, RandomGenerator.class, 677, 29595, 29603).nextDouble();
                CallChecker.varAssign(u, "u", 677, 29595, 29603);
            }
            while ((!lowerInclusive) && (u <= 0.0)) {
                if (CallChecker.beforeDeref(generator, RandomGenerator.class, 679, 29681, 29689)) {
                    u = CallChecker.isCalled(generator, RandomGenerator.class, 679, 29681, 29689).nextDouble();
                    CallChecker.varAssign(u, "u", 679, 29677, 29703);
                }
            } 
            return (u * upper) + ((1.0 - u) * lower);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4195.methodEnd();
        }
    }

    public int[] nextPermutation(int n, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4196 = new MethodContext(int[].class, 696, 29773, 30828);
        try {
            CallChecker.varInit(this, "this", 696, 29773, 30828);
            CallChecker.varInit(k, "k", 696, 29773, 30828);
            CallChecker.varInit(n, "n", 696, 29773, 30828);
            CallChecker.varInit(this.secRand, "secRand", 696, 29773, 30828);
            CallChecker.varInit(this.rand, "rand", 696, 29773, 30828);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 696, 29773, 30828);
            if (k > n) {
                throw new NumberIsTooLargeException(LocalizedFormats.PERMUTATION_EXCEEDS_N, k, n, true);
            }
            if (k <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.PERMUTATION_SIZE, k);
            }
            int[] index = CallChecker.varInit(getNatural(n), "index", 707, 30615, 30642);
            shuffle(index, (n - k));
            int[] result = CallChecker.varInit(new int[k], "result", 709, 30683, 30708);
            for (int i = 0; i < k; i++) {
                if (CallChecker.beforeDeref(result, int[].class, 711, 30760, 30765)) {
                    if (CallChecker.beforeDeref(index, int[].class, 711, 30772, 30776)) {
                        result = CallChecker.beforeCalled(result, int[].class, 711, 30760, 30765);
                        index = CallChecker.beforeCalled(index, int[].class, 711, 30772, 30776);
                        CallChecker.isCalled(result, int[].class, 711, 30760, 30765)[i] = CallChecker.isCalled(index, int[].class, 711, 30772, 30776)[((n - i) - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(result, int[].class, 711, 30760, 30765)[i], "CallChecker.isCalled(result, int[].class, 711, 30760, 30765)[i]", 711, 30760, 30788);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4196.methodEnd();
        }
    }

    public Object[] nextSample(Collection<?> c, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context4197 = new MethodContext(Object[].class, 730, 30835, 32047);
        try {
            CallChecker.varInit(this, "this", 730, 30835, 32047);
            CallChecker.varInit(k, "k", 730, 30835, 32047);
            CallChecker.varInit(c, "c", 730, 30835, 32047);
            CallChecker.varInit(this.secRand, "secRand", 730, 30835, 32047);
            CallChecker.varInit(this.rand, "rand", 730, 30835, 32047);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 730, 30835, 32047);
            int len = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(c, Collection.class, 732, 31469, 31469)) {
                c = CallChecker.beforeCalled(c, Collection.class, 732, 31469, 31469);
                len = CallChecker.isCalled(c, Collection.class, 732, 31469, 31469).size();
                CallChecker.varAssign(len, "len", 732, 31469, 31469);
            }
            if (k > len) {
                throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, k, len, true);
            }
            if (k <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, k);
            }
            Object[] objects = CallChecker.init(Object[].class);
            if (CallChecker.beforeDeref(c, Collection.class, 741, 31828, 31828)) {
                c = CallChecker.beforeCalled(c, Collection.class, 741, 31828, 31828);
                objects = CallChecker.isCalled(c, Collection.class, 741, 31828, 31828).toArray();
                CallChecker.varAssign(objects, "objects", 741, 31828, 31828);
            }
            int[] index = CallChecker.varInit(nextPermutation(len, k), "index", 742, 31849, 31886);
            Object[] result = CallChecker.varInit(new Object[k], "result", 743, 31896, 31927);
            for (int i = 0; i < k; i++) {
                if (CallChecker.beforeDeref(result, Object[].class, 745, 31979, 31984)) {
                    if (CallChecker.beforeDeref(index, int[].class, 745, 31999, 32003)) {
                        if (CallChecker.beforeDeref(objects, Object[].class, 745, 31991, 31997)) {
                            result = CallChecker.beforeCalled(result, Object[].class, 745, 31979, 31984);
                            index = CallChecker.beforeCalled(index, int[].class, 745, 31999, 32003);
                            objects = CallChecker.beforeCalled(objects, Object[].class, 745, 31991, 31997);
                            CallChecker.isCalled(result, Object[].class, 745, 31979, 31984)[i] = CallChecker.isCalled(objects, Object[].class, 745, 31991, 31997)[CallChecker.isCalled(index, int[].class, 745, 31999, 32003)[i]];
                            CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 745, 31979, 31984)[i], "CallChecker.isCalled(result, Object[].class, 745, 31979, 31984)[i]", 745, 31979, 32008);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4197.methodEnd();
        }
    }

    public void reSeed(long seed) {
        MethodContext _bcornu_methode_context4198 = new MethodContext(void.class, 760, 32056, 32332);
        try {
            CallChecker.varInit(this, "this", 760, 32056, 32332);
            CallChecker.varInit(seed, "seed", 760, 32056, 32332);
            CallChecker.varInit(this.secRand, "secRand", 760, 32056, 32332);
            CallChecker.varInit(this.rand, "rand", 760, 32056, 32332);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 760, 32056, 32332);
            final RandomGenerator npe_invocation_var897 = getRandomGenerator();
            if (CallChecker.beforeDeref(npe_invocation_var897, RandomGenerator.class, 761, 32292, 32311)) {
                CallChecker.isCalled(npe_invocation_var897, RandomGenerator.class, 761, 32292, 32311).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4198.methodEnd();
        }
    }

    public void reSeedSecure() {
        MethodContext _bcornu_methode_context4199 = new MethodContext(void.class, 771, 32339, 32607);
        try {
            CallChecker.varInit(this, "this", 771, 32339, 32607);
            CallChecker.varInit(this.secRand, "secRand", 771, 32339, 32607);
            CallChecker.varInit(this.rand, "rand", 771, 32339, 32607);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 771, 32339, 32607);
            final SecureRandom npe_invocation_var898 = getSecRan();
            if (CallChecker.beforeDeref(npe_invocation_var898, SecureRandom.class, 772, 32554, 32564)) {
                CallChecker.isCalled(npe_invocation_var898, SecureRandom.class, 772, 32554, 32564).setSeed(System.currentTimeMillis());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4199.methodEnd();
        }
    }

    public void reSeedSecure(long seed) {
        MethodContext _bcornu_methode_context4200 = new MethodContext(void.class, 783, 32614, 32895);
        try {
            CallChecker.varInit(this, "this", 783, 32614, 32895);
            CallChecker.varInit(seed, "seed", 783, 32614, 32895);
            CallChecker.varInit(this.secRand, "secRand", 783, 32614, 32895);
            CallChecker.varInit(this.rand, "rand", 783, 32614, 32895);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 783, 32614, 32895);
            final SecureRandom npe_invocation_var899 = getSecRan();
            if (CallChecker.beforeDeref(npe_invocation_var899, SecureRandom.class, 784, 32864, 32874)) {
                CallChecker.isCalled(npe_invocation_var899, SecureRandom.class, 784, 32864, 32874).setSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4200.methodEnd();
        }
    }

    public void reSeed() {
        MethodContext _bcornu_methode_context4201 = new MethodContext(void.class, 791, 32902, 33167);
        try {
            CallChecker.varInit(this, "this", 791, 32902, 33167);
            CallChecker.varInit(this.secRand, "secRand", 791, 32902, 33167);
            CallChecker.varInit(this.rand, "rand", 791, 32902, 33167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 791, 32902, 33167);
            final RandomGenerator npe_invocation_var900 = getRandomGenerator();
            if (CallChecker.beforeDeref(npe_invocation_var900, RandomGenerator.class, 792, 33073, 33092)) {
                CallChecker.isCalled(npe_invocation_var900, RandomGenerator.class, 792, 33073, 33092).setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4201.methodEnd();
        }
    }

    public void setSecureAlgorithm(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        MethodContext _bcornu_methode_context4202 = new MethodContext(void.class, 811, 33174, 34149);
        try {
            CallChecker.varInit(this, "this", 811, 33174, 34149);
            CallChecker.varInit(provider, "provider", 811, 33174, 34149);
            CallChecker.varInit(algorithm, "algorithm", 811, 33174, 34149);
            CallChecker.varInit(this.secRand, "secRand", 811, 33174, 34149);
            CallChecker.varInit(this.rand, "rand", 811, 33174, 34149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 811, 33174, 34149);
            secRand = SecureRandom.getInstance(algorithm, provider);
            CallChecker.varAssign(this.secRand, "this.secRand", 813, 34088, 34143);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4202.methodEnd();
        }
    }

    public RandomGenerator getRandomGenerator() {
        MethodContext _bcornu_methode_context4203 = new MethodContext(RandomGenerator.class, 827, 34156, 34687);
        try {
            CallChecker.varInit(this, "this", 827, 34156, 34687);
            CallChecker.varInit(this.secRand, "secRand", 827, 34156, 34687);
            CallChecker.varInit(this.rand, "rand", 827, 34156, 34687);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 827, 34156, 34687);
            if ((rand) == null) {
                initRan();
            }
            return rand;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RandomGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4203.methodEnd();
        }
    }

    private void initRan() {
        MethodContext _bcornu_methode_context4204 = new MethodContext(void.class, 838, 34694, 34986);
        try {
            CallChecker.varInit(this, "this", 838, 34694, 34986);
            CallChecker.varInit(this.secRand, "secRand", 838, 34694, 34986);
            CallChecker.varInit(this.rand, "rand", 838, 34694, 34986);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 838, 34694, 34986);
            rand = new Well19937c(((System.currentTimeMillis()) + (System.identityHashCode(this))));
            CallChecker.varAssign(this.rand, "this.rand", 839, 34899, 34980);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4204.methodEnd();
        }
    }

    private SecureRandom getSecRan() {
        MethodContext _bcornu_methode_context4205 = new MethodContext(SecureRandom.class, 851, 34993, 35552);
        try {
            CallChecker.varInit(this, "this", 851, 34993, 35552);
            CallChecker.varInit(this.secRand, "secRand", 851, 34993, 35552);
            CallChecker.varInit(this.rand, "rand", 851, 34993, 35552);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 851, 34993, 35552);
            if ((secRand) == null) {
                secRand = new SecureRandom();
                CallChecker.varAssign(this.secRand, "this.secRand", 853, 35395, 35423);
                if (CallChecker.beforeDeref(secRand, SecureRandom.class, 854, 35437, 35443)) {
                    secRand = CallChecker.beforeCalled(secRand, SecureRandom.class, 854, 35437, 35443);
                    CallChecker.isCalled(secRand, SecureRandom.class, 854, 35437, 35443).setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
                }
            }
            return secRand;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SecureRandom) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4205.methodEnd();
        }
    }

    private void shuffle(int[] list, int end) {
        MethodContext _bcornu_methode_context4206 = new MethodContext(void.class, 866, 35559, 36197);
        try {
            CallChecker.varInit(this, "this", 866, 35559, 36197);
            CallChecker.varInit(end, "end", 866, 35559, 36197);
            CallChecker.varInit(list, "list", 866, 35559, 36197);
            CallChecker.varInit(this.secRand, "secRand", 866, 35559, 36197);
            CallChecker.varInit(this.rand, "rand", 866, 35559, 36197);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 866, 35559, 36197);
            int target = CallChecker.varInit(((int) (0)), "target", 867, 35824, 35838);
            list = CallChecker.beforeCalled(list, int[].class, 868, 35861, 35864);
            for (int i = (CallChecker.isCalled(list, int[].class, 868, 35861, 35864).length) - 1; i >= end; i--) {
                if (i == 0) {
                    target = 0;
                    CallChecker.varAssign(target, "target", 870, 35937, 35947);
                }else {
                    target = nextInt(0, i);
                    CallChecker.varAssign(target, "target", 873, 36044, 36066);
                }
                int temp = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(list, int[].class, 875, 36105, 36108)) {
                    list = CallChecker.beforeCalled(list, int[].class, 875, 36105, 36108);
                    temp = CallChecker.isCalled(list, int[].class, 875, 36105, 36108)[target];
                    CallChecker.varAssign(temp, "temp", 875, 36105, 36108);
                }
                if (CallChecker.beforeDeref(list, int[].class, 876, 36131, 36134)) {
                    if (CallChecker.beforeDeref(list, int[].class, 876, 36146, 36149)) {
                        list = CallChecker.beforeCalled(list, int[].class, 876, 36131, 36134);
                        list = CallChecker.beforeCalled(list, int[].class, 876, 36146, 36149);
                        CallChecker.isCalled(list, int[].class, 876, 36131, 36134)[target] = CallChecker.isCalled(list, int[].class, 876, 36146, 36149)[i];
                        CallChecker.varAssign(CallChecker.isCalled(list, int[].class, 876, 36131, 36134)[target], "CallChecker.isCalled(list, int[].class, 876, 36131, 36134)[target]", 876, 36131, 36153);
                    }
                }
                if (CallChecker.beforeDeref(list, int[].class, 877, 36167, 36170)) {
                    list = CallChecker.beforeCalled(list, int[].class, 877, 36167, 36170);
                    CallChecker.isCalled(list, int[].class, 877, 36167, 36170)[i] = temp;
                    CallChecker.varAssign(CallChecker.isCalled(list, int[].class, 877, 36167, 36170)[i], "CallChecker.isCalled(list, int[].class, 877, 36167, 36170)[i]", 877, 36167, 36181);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4206.methodEnd();
        }
    }

    private int[] getNatural(int n) {
        MethodContext _bcornu_methode_context4207 = new MethodContext(int[].class, 887, 36204, 36539);
        try {
            CallChecker.varInit(this, "this", 887, 36204, 36539);
            CallChecker.varInit(n, "n", 887, 36204, 36539);
            CallChecker.varInit(this.secRand, "secRand", 887, 36204, 36539);
            CallChecker.varInit(this.rand, "rand", 887, 36204, 36539);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataGenerator.serialVersionUID", 887, 36204, 36539);
            int[] natural = CallChecker.varInit(new int[n], "natural", 888, 36407, 36433);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(natural, int[].class, 890, 36485, 36491)) {
                    natural = CallChecker.beforeCalled(natural, int[].class, 890, 36485, 36491);
                    CallChecker.isCalled(natural, int[].class, 890, 36485, 36491)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(natural, int[].class, 890, 36485, 36491)[i], "CallChecker.isCalled(natural, int[].class, 890, 36485, 36491)[i]", 890, 36485, 36499);
                }
            }
            return natural;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4207.methodEnd();
        }
    }
}

