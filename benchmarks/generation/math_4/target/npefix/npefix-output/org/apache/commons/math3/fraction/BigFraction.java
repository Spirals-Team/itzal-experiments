package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class BigFraction extends Number implements Serializable , Comparable<BigFraction> , FieldElement<BigFraction> {
    public static final BigFraction TWO = new BigFraction(2);

    public static final BigFraction ONE = new BigFraction(1);

    public static final BigFraction ZERO = new BigFraction(0);

    public static final BigFraction MINUS_ONE = new BigFraction((-1));

    public static final BigFraction FOUR_FIFTHS = new BigFraction(4, 5);

    public static final BigFraction ONE_FIFTH = new BigFraction(1, 5);

    public static final BigFraction ONE_HALF = new BigFraction(1, 2);

    public static final BigFraction ONE_QUARTER = new BigFraction(1, 4);

    public static final BigFraction ONE_THIRD = new BigFraction(1, 3);

    public static final BigFraction THREE_FIFTHS = new BigFraction(3, 5);

    public static final BigFraction THREE_QUARTERS = new BigFraction(3, 4);

    public static final BigFraction TWO_FIFTHS = new BigFraction(2, 5);

    public static final BigFraction TWO_QUARTERS = new BigFraction(2, 4);

    public static final BigFraction TWO_THIRDS = new BigFraction(2, 3);

    private static final long serialVersionUID = -5630213147331578515L;

    private static final BigInteger ONE_HUNDRED = BigInteger.valueOf(100);

    private final BigInteger numerator;

    private final BigInteger denominator;

    public BigFraction(final BigInteger num) {
        this(num, BigInteger.ONE);
        ConstructorContext _bcornu_methode_context671 = new ConstructorContext(BigFraction.class, 107, 3693, 3975);
        try {
        } finally {
            _bcornu_methode_context671.methodEnd();
        }
    }

    public BigFraction(BigInteger num, BigInteger den) {
        ConstructorContext _bcornu_methode_context672 = new ConstructorContext(BigFraction.class, 120, 3982, 5446);
        try {
            MathUtils.checkNotNull(num, LocalizedFormats.NUMERATOR);
            MathUtils.checkNotNull(den, LocalizedFormats.DENOMINATOR);
            if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 123, 4605, 4619)) {
                if (CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 123, 4605, 4619).equals(den)) {
                    throw new ZeroException(LocalizedFormats.ZERO_DENOMINATOR);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 126, 4730, 4744).equals(num)) {
                numerator = BigInteger.ZERO;
                CallChecker.varAssign(this.numerator, "this.numerator", 127, 4773, 4802);
                denominator = BigInteger.ONE;
                CallChecker.varAssign(this.denominator, "this.denominator", 128, 4816, 4844);
            }else {
                num = CallChecker.beforeCalled(num, BigInteger.class, 132, 4978, 4980);
                final BigInteger gcd = CallChecker.varInit(CallChecker.isCalled(num, BigInteger.class, 132, 4978, 4980).gcd(den), "gcd", 132, 4876, 4990);
                if (CallChecker.beforeDeref(BigInteger.ONE, BigInteger.class, 133, 5008, 5021)) {
                    if ((CallChecker.isCalled(BigInteger.ONE, BigInteger.class, 133, 5008, 5021).compareTo(gcd)) < 0) {
                        if (CallChecker.beforeDeref(num, BigInteger.class, 134, 5067, 5069)) {
                            num = CallChecker.beforeCalled(num, BigInteger.class, 134, 5067, 5069);
                            num = CallChecker.isCalled(num, BigInteger.class, 134, 5067, 5069).divide(gcd);
                            CallChecker.varAssign(num, "num", 134, 5061, 5082);
                        }
                        if (CallChecker.beforeDeref(den, BigInteger.class, 135, 5106, 5108)) {
                            den = CallChecker.beforeCalled(den, BigInteger.class, 135, 5106, 5108);
                            den = CallChecker.isCalled(den, BigInteger.class, 135, 5106, 5108).divide(gcd);
                            CallChecker.varAssign(den, "den", 135, 5100, 5121);
                        }
                    }
                }
                if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 139, 5192, 5206)) {
                    if ((CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 139, 5192, 5206).compareTo(den)) > 0) {
                        if (CallChecker.beforeDeref(num, BigInteger.class, 140, 5252, 5254)) {
                            num = CallChecker.beforeCalled(num, BigInteger.class, 140, 5252, 5254);
                            num = CallChecker.isCalled(num, BigInteger.class, 140, 5252, 5254).negate();
                            CallChecker.varAssign(num, "num", 140, 5246, 5264);
                        }
                        if (CallChecker.beforeDeref(den, BigInteger.class, 141, 5288, 5290)) {
                            den = CallChecker.beforeCalled(den, BigInteger.class, 141, 5288, 5290);
                            den = CallChecker.isCalled(den, BigInteger.class, 141, 5288, 5290).negate();
                            CallChecker.varAssign(den, "den", 141, 5282, 5300);
                        }
                    }
                }
                numerator = num;
                CallChecker.varAssign(this.numerator, "this.numerator", 145, 5381, 5398);
                denominator = den;
                CallChecker.varAssign(this.denominator, "this.denominator", 146, 5412, 5429);
            }
        } finally {
            _bcornu_methode_context672.methodEnd();
        }
    }

    public BigFraction(final double value) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context673 = new ConstructorContext(BigFraction.class, 172, 5453, 7850);
        try {
            if (Double.isNaN(value)) {
                throw new MathIllegalArgumentException(LocalizedFormats.NAN_VALUE_CONVERSION);
            }
            if (Double.isInfinite(value)) {
                throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_VALUE_CONVERSION);
            }
            final long bits = CallChecker.varInit(((long) (Double.doubleToLongBits(value))), "bits", 181, 6897, 7002);
            final long sign = CallChecker.varInit(((long) (bits & -9223372036854775808L)), "sign", 182, 7012, 7060);
            final long exponent = CallChecker.varInit(((long) (bits & 9218868437227405312L)), "exponent", 183, 7070, 7118);
            long m = CallChecker.varInit(((long) (bits & 4503599627370495L)), "m", 184, 7128, 7176);
            if (exponent != 0) {
                m |= 4503599627370496L;
                CallChecker.varAssign(m, "m", 187, 7302, 7326);
            }
            if (sign != 0) {
                m = -m;
                CallChecker.varAssign(m, "m", 190, 7375, 7381);
            }
            int k = CallChecker.varInit(((int) (((int) (exponent >> 52)) - 1075)), "k", 192, 7401, 7440);
            while (((m & 9007199254740990L) != 0) && ((m & 1) == 0)) {
                m = m >> 1;
                CallChecker.varAssign(m, "m", 194, 7525, 7535);
                ++k;
            } 
            if (k < 0) {
                numerator = BigInteger.valueOf(m);
                CallChecker.varAssign(this.numerator, "this.numerator", 199, 7598, 7633);
                denominator = CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 200, 7661, 7675).flipBit((-k));
                CallChecker.varAssign(this.denominator, "this.denominator", 200, 7647, 7688);
            }else {
                numerator = CallChecker.isCalled(BigInteger.valueOf(m), BigInteger.class, 202, 7733, 7753).multiply(CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 202, 7764, 7778).flipBit(k));
                CallChecker.varAssign(this.numerator, "this.numerator", 202, 7719, 7791);
                denominator = BigInteger.ONE;
                CallChecker.varAssign(this.denominator, "this.denominator", 203, 7805, 7833);
            }
        } finally {
            _bcornu_methode_context673.methodEnd();
        }
    }

    public BigFraction(final double value, final double epsilon, final int maxIterations) throws FractionConversionException {
        this(value, epsilon, Integer.MAX_VALUE, maxIterations);
        ConstructorContext _bcornu_methode_context674 = new ConstructorContext(BigFraction.class, 229, 7857, 8858);
        try {
        } finally {
            _bcornu_methode_context674.methodEnd();
        }
    }

    private BigFraction(final double value, final double epsilon, final int maxDenominator, int maxIterations) throws FractionConversionException {
        ConstructorContext _bcornu_methode_context675 = new ConstructorContext(BigFraction.class, 269, 8865, 12350);
        try {
            long overflow = CallChecker.varInit(((long) (Integer.MAX_VALUE)), "overflow", 272, 10523, 10556);
            double r0 = CallChecker.varInit(((double) (value)), "r0", 273, 10566, 10583);
            long a0 = CallChecker.varInit(((long) ((long) (FastMath.floor(r0)))), "a0", 274, 10593, 10628);
            if (a0 > overflow) {
                throw new FractionConversionException(value, a0, 1L);
            }
            if ((FastMath.abs((a0 - value))) < epsilon) {
                numerator = BigInteger.valueOf(a0);
                CallChecker.varAssign(this.numerator, "this.numerator", 282, 10893, 10927);
                denominator = BigInteger.ONE;
                CallChecker.varAssign(this.denominator, "this.denominator", 283, 10941, 10969);
                return ;
            }
            long p0 = CallChecker.varInit(((long) (1)), "p0", 287, 11010, 11021);
            long q0 = CallChecker.varInit(((long) (0)), "q0", 288, 11031, 11042);
            long p1 = CallChecker.varInit(((long) (a0)), "p1", 289, 11052, 11064);
            long q1 = CallChecker.varInit(((long) (1)), "q1", 290, 11074, 11085);
            long p2 = CallChecker.varInit(((long) (0)), "p2", 292, 11096, 11107);
            long q2 = CallChecker.varInit(((long) (1)), "q2", 293, 11117, 11128);
            int n = CallChecker.varInit(((int) (0)), "n", 295, 11139, 11148);
            boolean stop = CallChecker.varInit(((boolean) (false)), "stop", 296, 11158, 11178);
            do {
                ++n;
                final double r1 = CallChecker.varInit(((double) (1.0 / (r0 - a0))), "r1", 299, 11222, 11255);
                final long a1 = CallChecker.varInit(((long) ((long) (FastMath.floor(r1)))), "a1", 300, 11269, 11310);
                p2 = (a1 * p1) + p0;
                CallChecker.varAssign(p2, "p2", 301, 11324, 11343);
                q2 = (a1 * q1) + q0;
                CallChecker.varAssign(q2, "q2", 302, 11357, 11376);
                if ((p2 > overflow) || (q2 > overflow)) {
                    throw new FractionConversionException(value, p2, q2);
                }
                final double convergent = CallChecker.varInit(((double) (((double) (p2)) / ((double) (q2)))), "convergent", 307, 11529, 11580);
                if (((n < maxIterations) && ((FastMath.abs((convergent - value))) > epsilon)) && (q2 < maxDenominator)) {
                    p0 = p1;
                    CallChecker.varAssign(p0, "p0", 311, 11742, 11749);
                    p1 = p2;
                    CallChecker.varAssign(p1, "p1", 312, 11767, 11774);
                    q0 = q1;
                    CallChecker.varAssign(q0, "q0", 313, 11792, 11799);
                    q1 = q2;
                    CallChecker.varAssign(q1, "q1", 314, 11817, 11824);
                    a0 = a1;
                    CallChecker.varAssign(a0, "a0", 315, 11842, 11849);
                    r0 = r1;
                    CallChecker.varAssign(r0, "r0", 316, 11867, 11874);
                }else {
                    stop = true;
                    CallChecker.varAssign(stop, "stop", 318, 11913, 11924);
                }
            } while (!stop );
            if (n >= maxIterations) {
                throw new FractionConversionException(value, maxIterations);
            }
            if (q2 < maxDenominator) {
                numerator = BigInteger.valueOf(p2);
                CallChecker.varAssign(this.numerator, "this.numerator", 327, 12131, 12167);
                denominator = BigInteger.valueOf(q2);
                CallChecker.varAssign(this.denominator, "this.denominator", 328, 12181, 12217);
            }else {
                numerator = BigInteger.valueOf(p1);
                CallChecker.varAssign(this.numerator, "this.numerator", 330, 12248, 12284);
                denominator = BigInteger.valueOf(q1);
                CallChecker.varAssign(this.denominator, "this.denominator", 331, 12298, 12334);
            }
        } finally {
            _bcornu_methode_context675.methodEnd();
        }
    }

    public BigFraction(final double value, final int maxDenominator) throws FractionConversionException {
        this(value, 0, maxDenominator, 100);
        ConstructorContext _bcornu_methode_context676 = new ConstructorContext(BigFraction.class, 352, 12357, 13096);
        try {
        } finally {
            _bcornu_methode_context676.methodEnd();
        }
    }

    public BigFraction(final int num) {
        this(BigInteger.valueOf(num), BigInteger.ONE);
        ConstructorContext _bcornu_methode_context677 = new ConstructorContext(BigFraction.class, 366, 13103, 13391);
        try {
        } finally {
            _bcornu_methode_context677.methodEnd();
        }
    }

    public BigFraction(final int num, final int den) {
        this(BigInteger.valueOf(num), BigInteger.valueOf(den));
        ConstructorContext _bcornu_methode_context678 = new ConstructorContext(BigFraction.class, 381, 13398, 13822);
        try {
        } finally {
            _bcornu_methode_context678.methodEnd();
        }
    }

    public BigFraction(final long num) {
        this(BigInteger.valueOf(num), BigInteger.ONE);
        ConstructorContext _bcornu_methode_context679 = new ConstructorContext(BigFraction.class, 393, 13829, 14103);
        try {
        } finally {
            _bcornu_methode_context679.methodEnd();
        }
    }

    public BigFraction(final long num, final long den) {
        this(BigInteger.valueOf(num), BigInteger.valueOf(den));
        ConstructorContext _bcornu_methode_context680 = new ConstructorContext(BigFraction.class, 408, 14110, 14537);
        try {
        } finally {
            _bcornu_methode_context680.methodEnd();
        }
    }

    public static BigFraction getReducedFraction(final int numerator, final int denominator) {
        MethodContext _bcornu_methode_context2963 = new MethodContext(BigFraction.class, 431, 14544, 15460);
        try {
            CallChecker.varInit(denominator, "denominator", 431, 14544, 15460);
            CallChecker.varInit(numerator, "numerator", 431, 14544, 15460);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 431, 14544, 15460);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 431, 14544, 15460);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 431, 14544, 15460);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 431, 14544, 15460);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 431, 14544, 15460);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 431, 14544, 15460);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 431, 14544, 15460);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 431, 14544, 15460);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 431, 14544, 15460);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 431, 14544, 15460);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 431, 14544, 15460);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 431, 14544, 15460);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 431, 14544, 15460);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 431, 14544, 15460);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 431, 14544, 15460);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 431, 14544, 15460);
            if (numerator == 0) {
                return BigFraction.ZERO;
            }
            return new BigFraction(numerator, denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2963.methodEnd();
        }
    }

    public BigFraction abs() {
        MethodContext _bcornu_methode_context2964 = new MethodContext(BigFraction.class, 447, 15467, 15745);
        try {
            CallChecker.varInit(this, "this", 447, 15467, 15745);
            CallChecker.varInit(this.denominator, "denominator", 447, 15467, 15745);
            CallChecker.varInit(this.numerator, "numerator", 447, 15467, 15745);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 447, 15467, 15745);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 447, 15467, 15745);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 447, 15467, 15745);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 447, 15467, 15745);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 447, 15467, 15745);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 447, 15467, 15745);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 447, 15467, 15745);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 447, 15467, 15745);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 447, 15467, 15745);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 447, 15467, 15745);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 447, 15467, 15745);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 447, 15467, 15745);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 447, 15467, 15745);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 447, 15467, 15745);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 447, 15467, 15745);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 447, 15467, 15745);
            if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 448, 15679, 15693)) {
                if ((CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 448, 15679, 15693).compareTo(numerator)) <= 0) {
                    return this;
                }else {
                    return negate();
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2964.methodEnd();
        }
    }

    public BigFraction add(final BigInteger bg) throws NullArgumentException {
        MethodContext _bcornu_methode_context2965 = new MethodContext(BigFraction.class, 463, 15752, 16395);
        try {
            CallChecker.varInit(this, "this", 463, 15752, 16395);
            CallChecker.varInit(bg, "bg", 463, 15752, 16395);
            CallChecker.varInit(this.denominator, "denominator", 463, 15752, 16395);
            CallChecker.varInit(this.numerator, "numerator", 463, 15752, 16395);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 463, 15752, 16395);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 463, 15752, 16395);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 463, 15752, 16395);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 463, 15752, 16395);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 463, 15752, 16395);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 463, 15752, 16395);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 463, 15752, 16395);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 463, 15752, 16395);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 463, 15752, 16395);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 463, 15752, 16395);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 463, 15752, 16395);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 463, 15752, 16395);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 463, 15752, 16395);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 463, 15752, 16395);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 463, 15752, 16395);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 463, 15752, 16395);
            MathUtils.checkNotNull(bg);
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 465, 16350, 16360)) {
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 465, 16336, 16344)) {
                    return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 465, 16336, 16344).add(CallChecker.isCalled(denominator, BigInteger.class, 465, 16350, 16360).multiply(bg)), denominator);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2965.methodEnd();
        }
    }

    public BigFraction add(final int i) {
        MethodContext _bcornu_methode_context2966 = new MethodContext(BigFraction.class, 478, 16402, 16790);
        try {
            CallChecker.varInit(this, "this", 478, 16402, 16790);
            CallChecker.varInit(i, "i", 478, 16402, 16790);
            CallChecker.varInit(this.denominator, "denominator", 478, 16402, 16790);
            CallChecker.varInit(this.numerator, "numerator", 478, 16402, 16790);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 478, 16402, 16790);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 478, 16402, 16790);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 478, 16402, 16790);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 478, 16402, 16790);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 478, 16402, 16790);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 478, 16402, 16790);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 478, 16402, 16790);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 478, 16402, 16790);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 478, 16402, 16790);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 478, 16402, 16790);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 478, 16402, 16790);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 478, 16402, 16790);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 478, 16402, 16790);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 478, 16402, 16790);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 478, 16402, 16790);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 478, 16402, 16790);
            return add(BigInteger.valueOf(i));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2966.methodEnd();
        }
    }

    public BigFraction add(final long l) {
        MethodContext _bcornu_methode_context2967 = new MethodContext(BigFraction.class, 492, 16797, 17180);
        try {
            CallChecker.varInit(this, "this", 492, 16797, 17180);
            CallChecker.varInit(l, "l", 492, 16797, 17180);
            CallChecker.varInit(this.denominator, "denominator", 492, 16797, 17180);
            CallChecker.varInit(this.numerator, "numerator", 492, 16797, 17180);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 492, 16797, 17180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 492, 16797, 17180);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 492, 16797, 17180);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 492, 16797, 17180);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 492, 16797, 17180);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 492, 16797, 17180);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 492, 16797, 17180);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 492, 16797, 17180);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 492, 16797, 17180);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 492, 16797, 17180);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 492, 16797, 17180);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 492, 16797, 17180);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 492, 16797, 17180);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 492, 16797, 17180);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 492, 16797, 17180);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 492, 16797, 17180);
            return add(BigInteger.valueOf(l));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2967.methodEnd();
        }
    }

    public BigFraction add(final BigFraction fraction) {
        MethodContext _bcornu_methode_context2968 = new MethodContext(BigFraction.class, 507, 17187, 18276);
        try {
            CallChecker.varInit(this, "this", 507, 17187, 18276);
            CallChecker.varInit(fraction, "fraction", 507, 17187, 18276);
            CallChecker.varInit(this.denominator, "denominator", 507, 17187, 18276);
            CallChecker.varInit(this.numerator, "numerator", 507, 17187, 18276);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 507, 17187, 18276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 507, 17187, 18276);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 507, 17187, 18276);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 507, 17187, 18276);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 507, 17187, 18276);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 507, 17187, 18276);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 507, 17187, 18276);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 507, 17187, 18276);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 507, 17187, 18276);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 507, 17187, 18276);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 507, 17187, 18276);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 507, 17187, 18276);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 507, 17187, 18276);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 507, 17187, 18276);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 507, 17187, 18276);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 507, 17187, 18276);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (CallChecker.beforeDeref(BigFraction.ZERO, BigFraction.class, 511, 17766, 17769)) {
                if (CallChecker.isCalled(BigFraction.ZERO, BigFraction.class, 511, 17766, 17769).equals(fraction)) {
                    return this;
                }
            }else
                throw new AbnormalExecutionError();
            
            BigInteger num = CallChecker.varInit(null, "num", 515, 17835, 17856);
            BigInteger den = CallChecker.varInit(null, "den", 516, 17866, 17887);
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 518, 17902, 17912)) {
                if (CallChecker.isCalled(denominator, BigInteger.class, 518, 17902, 17912).equals(fraction.denominator)) {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 519, 17964, 17972)) {
                        num = CallChecker.isCalled(numerator, BigInteger.class, 519, 17964, 17972).add(fraction.numerator);
                        CallChecker.varAssign(num, "num", 519, 17958, 17997);
                    }
                    den = denominator;
                    CallChecker.varAssign(den, "den", 520, 18011, 18028);
                }else {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 522, 18066, 18074)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fraction, BigFraction.class, 522, 18112, 18120).numerator, BigInteger.class, 522, 18112, 18131)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 522, 18066, 18074).multiply(CallChecker.isCalled(fraction, BigFraction.class, 522, 18085, 18092).denominator), BigInteger.class, 522, 18065, 18106)) {
                                num = CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 522, 18066, 18074).multiply(fraction.denominator), BigInteger.class, 522, 18065, 18106).add(CallChecker.isCalled(fraction.numerator, BigInteger.class, 522, 18112, 18131).multiply(denominator));
                                CallChecker.varAssign(num, "num", 522, 18059, 18155);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(denominator, BigInteger.class, 523, 18175, 18185)) {
                        den = CallChecker.isCalled(denominator, BigInteger.class, 523, 18175, 18185).multiply(fraction.denominator);
                        CallChecker.varAssign(den, "den", 523, 18169, 18217);
                    }
                }
            }
            return new BigFraction(num, den);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2968.methodEnd();
        }
    }

    public BigDecimal bigDecimalValue() {
        MethodContext _bcornu_methode_context2969 = new MethodContext(BigDecimal.class, 541, 18283, 18804);
        try {
            CallChecker.varInit(this, "this", 541, 18283, 18804);
            CallChecker.varInit(this.denominator, "denominator", 541, 18283, 18804);
            CallChecker.varInit(this.numerator, "numerator", 541, 18283, 18804);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 541, 18283, 18804);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 541, 18283, 18804);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 541, 18283, 18804);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 541, 18283, 18804);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 541, 18283, 18804);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 541, 18283, 18804);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 541, 18283, 18804);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 541, 18283, 18804);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 541, 18283, 18804);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 541, 18283, 18804);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 541, 18283, 18804);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 541, 18283, 18804);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 541, 18283, 18804);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 541, 18283, 18804);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 541, 18283, 18804);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 541, 18283, 18804);
            if (CallChecker.beforeDeref(new BigDecimal(numerator), BigDecimal.class, 542, 18737, 18761)) {
                return CallChecker.isCalled(new BigDecimal(numerator), BigDecimal.class, 542, 18737, 18761).divide(new BigDecimal(denominator));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigDecimal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2969.methodEnd();
        }
    }

    public BigDecimal bigDecimalValue(final int roundingMode) {
        MethodContext _bcornu_methode_context2970 = new MethodContext(BigDecimal.class, 560, 18811, 19516);
        try {
            CallChecker.varInit(this, "this", 560, 18811, 19516);
            CallChecker.varInit(roundingMode, "roundingMode", 560, 18811, 19516);
            CallChecker.varInit(this.denominator, "denominator", 560, 18811, 19516);
            CallChecker.varInit(this.numerator, "numerator", 560, 18811, 19516);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 560, 18811, 19516);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 560, 18811, 19516);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 560, 18811, 19516);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 560, 18811, 19516);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 560, 18811, 19516);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 560, 18811, 19516);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 560, 18811, 19516);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 560, 18811, 19516);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 560, 18811, 19516);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 560, 18811, 19516);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 560, 18811, 19516);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 560, 18811, 19516);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 560, 18811, 19516);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 560, 18811, 19516);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 560, 18811, 19516);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 560, 18811, 19516);
            if (CallChecker.beforeDeref(new BigDecimal(numerator), BigDecimal.class, 561, 19435, 19459)) {
                return CallChecker.isCalled(new BigDecimal(numerator), BigDecimal.class, 561, 19435, 19459).divide(new BigDecimal(denominator), roundingMode);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigDecimal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2970.methodEnd();
        }
    }

    public BigDecimal bigDecimalValue(final int scale, final int roundingMode) {
        MethodContext _bcornu_methode_context2971 = new MethodContext(BigDecimal.class, 579, 19523, 20280);
        try {
            CallChecker.varInit(this, "this", 579, 19523, 20280);
            CallChecker.varInit(roundingMode, "roundingMode", 579, 19523, 20280);
            CallChecker.varInit(scale, "scale", 579, 19523, 20280);
            CallChecker.varInit(this.denominator, "denominator", 579, 19523, 20280);
            CallChecker.varInit(this.numerator, "numerator", 579, 19523, 20280);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 579, 19523, 20280);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 579, 19523, 20280);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 579, 19523, 20280);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 579, 19523, 20280);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 579, 19523, 20280);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 579, 19523, 20280);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 579, 19523, 20280);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 579, 19523, 20280);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 579, 19523, 20280);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 579, 19523, 20280);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 579, 19523, 20280);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 579, 19523, 20280);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 579, 19523, 20280);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 579, 19523, 20280);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 579, 19523, 20280);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 579, 19523, 20280);
            if (CallChecker.beforeDeref(new BigDecimal(numerator), BigDecimal.class, 580, 20192, 20216)) {
                return CallChecker.isCalled(new BigDecimal(numerator), BigDecimal.class, 580, 20192, 20216).divide(new BigDecimal(denominator), scale, roundingMode);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigDecimal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2971.methodEnd();
        }
    }

    public int compareTo(final BigFraction object) {
        MethodContext _bcornu_methode_context2972 = new MethodContext(int.class, 594, 20287, 20898);
        try {
            CallChecker.varInit(this, "this", 594, 20287, 20898);
            CallChecker.varInit(object, "object", 594, 20287, 20898);
            CallChecker.varInit(this.denominator, "denominator", 594, 20287, 20898);
            CallChecker.varInit(this.numerator, "numerator", 594, 20287, 20898);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 594, 20287, 20898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 594, 20287, 20898);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 594, 20287, 20898);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 594, 20287, 20898);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 594, 20287, 20898);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 594, 20287, 20898);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 594, 20287, 20898);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 594, 20287, 20898);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 594, 20287, 20898);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 594, 20287, 20898);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 594, 20287, 20898);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 594, 20287, 20898);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 594, 20287, 20898);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 594, 20287, 20898);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 594, 20287, 20898);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 594, 20287, 20898);
            BigInteger nOd = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(object, BigFraction.class, 595, 20773, 20778)) {
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 595, 20754, 20762)) {
                    nOd = CallChecker.isCalled(numerator, BigInteger.class, 595, 20754, 20762).multiply(CallChecker.isCalled(object, BigFraction.class, 595, 20773, 20778).denominator);
                    CallChecker.varAssign(nOd, "nOd", 595, 20773, 20778);
                }
            }
            BigInteger dOn = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(object, BigFraction.class, 596, 20840, 20845)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 596, 20819, 20829)) {
                    dOn = CallChecker.isCalled(denominator, BigInteger.class, 596, 20819, 20829).multiply(CallChecker.isCalled(object, BigFraction.class, 596, 20840, 20845).numerator);
                    CallChecker.varAssign(dOn, "dOn", 596, 20840, 20845);
                }
            }
            if (CallChecker.beforeDeref(nOd, BigInteger.class, 597, 20874, 20876)) {
                nOd = CallChecker.beforeCalled(nOd, BigInteger.class, 597, 20874, 20876);
                return CallChecker.isCalled(nOd, BigInteger.class, 597, 20874, 20876).compareTo(dOn);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2972.methodEnd();
        }
    }

    public BigFraction divide(final BigInteger bg) {
        MethodContext _bcornu_methode_context2973 = new MethodContext(BigFraction.class, 611, 20905, 21767);
        try {
            CallChecker.varInit(this, "this", 611, 20905, 21767);
            CallChecker.varInit(bg, "bg", 611, 20905, 21767);
            CallChecker.varInit(this.denominator, "denominator", 611, 20905, 21767);
            CallChecker.varInit(this.numerator, "numerator", 611, 20905, 21767);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 611, 20905, 21767);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 611, 20905, 21767);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 611, 20905, 21767);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 611, 20905, 21767);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 611, 20905, 21767);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 611, 20905, 21767);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 611, 20905, 21767);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 611, 20905, 21767);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 611, 20905, 21767);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 611, 20905, 21767);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 611, 20905, 21767);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 611, 20905, 21767);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 611, 20905, 21767);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 611, 20905, 21767);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 611, 20905, 21767);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 611, 20905, 21767);
            if (bg == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 615, 21572, 21586)) {
                if (CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 615, 21572, 21586).equals(bg)) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 618, 21736, 21746)) {
                return new BigFraction(numerator, CallChecker.isCalled(denominator, BigInteger.class, 618, 21736, 21746).multiply(bg));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2973.methodEnd();
        }
    }

    public BigFraction divide(final int i) {
        MethodContext _bcornu_methode_context2974 = new MethodContext(BigFraction.class, 631, 21774, 22242);
        try {
            CallChecker.varInit(this, "this", 631, 21774, 22242);
            CallChecker.varInit(i, "i", 631, 21774, 22242);
            CallChecker.varInit(this.denominator, "denominator", 631, 21774, 22242);
            CallChecker.varInit(this.numerator, "numerator", 631, 21774, 22242);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 631, 21774, 22242);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 631, 21774, 22242);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 631, 21774, 22242);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 631, 21774, 22242);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 631, 21774, 22242);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 631, 21774, 22242);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 631, 21774, 22242);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 631, 21774, 22242);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 631, 21774, 22242);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 631, 21774, 22242);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 631, 21774, 22242);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 631, 21774, 22242);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 631, 21774, 22242);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 631, 21774, 22242);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 631, 21774, 22242);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 631, 21774, 22242);
            return divide(BigInteger.valueOf(i));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2974.methodEnd();
        }
    }

    public BigFraction divide(final long l) {
        MethodContext _bcornu_methode_context2975 = new MethodContext(BigFraction.class, 645, 22249, 22720);
        try {
            CallChecker.varInit(this, "this", 645, 22249, 22720);
            CallChecker.varInit(l, "l", 645, 22249, 22720);
            CallChecker.varInit(this.denominator, "denominator", 645, 22249, 22720);
            CallChecker.varInit(this.numerator, "numerator", 645, 22249, 22720);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 645, 22249, 22720);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 645, 22249, 22720);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 645, 22249, 22720);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 645, 22249, 22720);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 645, 22249, 22720);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 645, 22249, 22720);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 645, 22249, 22720);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 645, 22249, 22720);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 645, 22249, 22720);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 645, 22249, 22720);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 645, 22249, 22720);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 645, 22249, 22720);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 645, 22249, 22720);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 645, 22249, 22720);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 645, 22249, 22720);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 645, 22249, 22720);
            return divide(BigInteger.valueOf(l));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2975.methodEnd();
        }
    }

    public BigFraction divide(final BigFraction fraction) {
        MethodContext _bcornu_methode_context2976 = new MethodContext(BigFraction.class, 660, 22727, 23543);
        try {
            CallChecker.varInit(this, "this", 660, 22727, 23543);
            CallChecker.varInit(fraction, "fraction", 660, 22727, 23543);
            CallChecker.varInit(this.denominator, "denominator", 660, 22727, 23543);
            CallChecker.varInit(this.numerator, "numerator", 660, 22727, 23543);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 660, 22727, 23543);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 660, 22727, 23543);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 660, 22727, 23543);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 660, 22727, 23543);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 660, 22727, 23543);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 660, 22727, 23543);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 660, 22727, 23543);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 660, 22727, 23543);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 660, 22727, 23543);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 660, 22727, 23543);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 660, 22727, 23543);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 660, 22727, 23543);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 660, 22727, 23543);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 660, 22727, 23543);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 660, 22727, 23543);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 660, 22727, 23543);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 664, 23352, 23366)) {
                if (CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 664, 23352, 23366).equals(fraction.numerator)) {
                    throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR);
                }
            }else
                throw new AbnormalExecutionError();
            
            return multiply(fraction.reciprocal());
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2976.methodEnd();
        }
    }

    @Override
    public double doubleValue() {
        MethodContext _bcornu_methode_context2977 = new MethodContext(double.class, 681, 23550, 24423);
        try {
            CallChecker.varInit(this, "this", 681, 23550, 24423);
            CallChecker.varInit(this.denominator, "denominator", 681, 23550, 24423);
            CallChecker.varInit(this.numerator, "numerator", 681, 23550, 24423);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 681, 23550, 24423);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 681, 23550, 24423);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 681, 23550, 24423);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 681, 23550, 24423);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 681, 23550, 24423);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 681, 23550, 24423);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 681, 23550, 24423);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 681, 23550, 24423);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 681, 23550, 24423);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 681, 23550, 24423);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 681, 23550, 24423);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 681, 23550, 24423);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 681, 23550, 24423);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 681, 23550, 24423);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 681, 23550, 24423);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 681, 23550, 24423);
            double result = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 682, 23880, 23888)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 682, 23906, 23916)) {
                    result = (CallChecker.isCalled(numerator, BigInteger.class, 682, 23880, 23888).doubleValue()) / (CallChecker.isCalled(denominator, BigInteger.class, 682, 23906, 23916).doubleValue());
                    CallChecker.varAssign(result, "result", 682, 23880, 23888);
                }
            }
            if (Double.isNaN(result)) {
                int shift = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 686, 24137, 24145)) {
                    if (CallChecker.beforeDeref(denominator, BigInteger.class, 687, 24193, 24203)) {
                        shift = (Math.max(CallChecker.isCalled(numerator, BigInteger.class, 686, 24137, 24145).bitLength(), CallChecker.isCalled(denominator, BigInteger.class, 687, 24193, 24203).bitLength())) - (FastMath.getExponent(Double.MAX_VALUE));
                        CallChecker.varAssign(shift, "shift", 686, 24137, 24145);
                    }
                }
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 688, 24281, 24289)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 688, 24281, 24289).shiftRight(shift), BigInteger.class, 688, 24281, 24307)) {
                        if (CallChecker.beforeDeref(denominator, BigInteger.class, 689, 24341, 24351)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(denominator, BigInteger.class, 689, 24341, 24351).shiftRight(shift), BigInteger.class, 689, 24341, 24369)) {
                                result = (CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 688, 24281, 24289).shiftRight(shift), BigInteger.class, 688, 24281, 24307).doubleValue()) / (CallChecker.isCalled(CallChecker.isCalled(denominator, BigInteger.class, 689, 24341, 24351).shiftRight(shift), BigInteger.class, 689, 24341, 24369).doubleValue());
                                CallChecker.varAssign(result, "result", 688, 24272, 24384);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2977.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context2978 = new MethodContext(boolean.class, 710, 24430, 25486);
        try {
            CallChecker.varInit(this, "this", 710, 24430, 25486);
            CallChecker.varInit(other, "other", 710, 24430, 25486);
            CallChecker.varInit(this.denominator, "denominator", 710, 24430, 25486);
            CallChecker.varInit(this.numerator, "numerator", 710, 24430, 25486);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 710, 24430, 25486);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 710, 24430, 25486);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 710, 24430, 25486);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 710, 24430, 25486);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 710, 24430, 25486);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 710, 24430, 25486);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 710, 24430, 25486);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 710, 24430, 25486);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 710, 24430, 25486);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 710, 24430, 25486);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 710, 24430, 25486);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 710, 24430, 25486);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 710, 24430, 25486);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 710, 24430, 25486);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 710, 24430, 25486);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 710, 24430, 25486);
            boolean ret = CallChecker.varInit(((boolean) (false)), "ret", 711, 25108, 25127);
            if ((this) == other) {
                ret = true;
                CallChecker.varAssign(ret, "ret", 714, 25171, 25181);
            }else
                if (other instanceof BigFraction) {
                    BigFraction rhs = CallChecker.init(BigFraction.class);
                    if (CallChecker.beforeDeref(other, Object.class, 716, 25279, 25283)) {
                        rhs = CallChecker.isCalled(((BigFraction) (other)), BigFraction.class, 716, 25279, 25283).reduce();
                        CallChecker.varAssign(rhs, "rhs", 716, 25279, 25283);
                    }
                    BigFraction thisOne = CallChecker.varInit(this.reduce(), "thisOne", 717, 25308, 25343);
                    if (CallChecker.beforeDeref(thisOne, BigFraction.class, 718, 25363, 25369)) {
                        if (CallChecker.beforeDeref(rhs, BigFraction.class, 718, 25388, 25390)) {
                            thisOne = CallChecker.beforeCalled(thisOne, BigFraction.class, 718, 25363, 25369);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(thisOne, BigFraction.class, 718, 25363, 25369).numerator, BigInteger.class, 718, 25363, 25379)) {
                                if (CallChecker.beforeDeref(thisOne, BigFraction.class, 718, 25406, 25412)) {
                                    if (CallChecker.beforeDeref(rhs, BigFraction.class, 718, 25433, 25435)) {
                                        thisOne = CallChecker.beforeCalled(thisOne, BigFraction.class, 718, 25406, 25412);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(thisOne, BigFraction.class, 718, 25406, 25412).denominator, BigInteger.class, 718, 25406, 25424)) {
                                            thisOne = CallChecker.beforeCalled(thisOne, BigFraction.class, 718, 25363, 25369);
                                            rhs = CallChecker.beforeCalled(rhs, BigFraction.class, 718, 25388, 25390);
                                            thisOne = CallChecker.beforeCalled(thisOne, BigFraction.class, 718, 25406, 25412);
                                            rhs = CallChecker.beforeCalled(rhs, BigFraction.class, 718, 25433, 25435);
                                            ret = (CallChecker.isCalled(CallChecker.isCalled(thisOne, BigFraction.class, 718, 25363, 25369).numerator, BigInteger.class, 718, 25363, 25379).equals(CallChecker.isCalled(rhs, BigFraction.class, 718, 25388, 25390).numerator)) && (CallChecker.isCalled(CallChecker.isCalled(thisOne, BigFraction.class, 718, 25406, 25412).denominator, BigInteger.class, 718, 25406, 25424).equals(CallChecker.isCalled(rhs, BigFraction.class, 718, 25433, 25435).denominator));
                                            CallChecker.varAssign(ret, "ret", 718, 25357, 25449);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2978.methodEnd();
        }
    }

    @Override
    public float floatValue() {
        MethodContext _bcornu_methode_context2979 = new MethodContext(float.class, 734, 25493, 26356);
        try {
            CallChecker.varInit(this, "this", 734, 25493, 26356);
            CallChecker.varInit(this.denominator, "denominator", 734, 25493, 26356);
            CallChecker.varInit(this.numerator, "numerator", 734, 25493, 26356);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 734, 25493, 26356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 734, 25493, 26356);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 734, 25493, 26356);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 734, 25493, 26356);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 734, 25493, 26356);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 734, 25493, 26356);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 734, 25493, 26356);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 734, 25493, 26356);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 734, 25493, 26356);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 734, 25493, 26356);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 734, 25493, 26356);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 734, 25493, 26356);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 734, 25493, 26356);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 734, 25493, 26356);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 734, 25493, 26356);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 734, 25493, 26356);
            float result = CallChecker.init(float.class);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 735, 25818, 25826)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 735, 25843, 25853)) {
                    result = (CallChecker.isCalled(numerator, BigInteger.class, 735, 25818, 25826).floatValue()) / (CallChecker.isCalled(denominator, BigInteger.class, 735, 25843, 25853).floatValue());
                    CallChecker.varAssign(result, "result", 735, 25818, 25826);
                }
            }
            if (Double.isNaN(result)) {
                int shift = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 739, 26073, 26081)) {
                    if (CallChecker.beforeDeref(denominator, BigInteger.class, 740, 26129, 26139)) {
                        shift = (Math.max(CallChecker.isCalled(numerator, BigInteger.class, 739, 26073, 26081).bitLength(), CallChecker.isCalled(denominator, BigInteger.class, 740, 26129, 26139).bitLength())) - (FastMath.getExponent(Float.MAX_VALUE));
                        CallChecker.varAssign(shift, "shift", 739, 26073, 26081);
                    }
                }
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 741, 26216, 26224)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 741, 26216, 26224).shiftRight(shift), BigInteger.class, 741, 26216, 26242)) {
                        if (CallChecker.beforeDeref(denominator, BigInteger.class, 742, 26275, 26285)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(denominator, BigInteger.class, 742, 26275, 26285).shiftRight(shift), BigInteger.class, 742, 26275, 26303)) {
                                result = (CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 741, 26216, 26224).shiftRight(shift), BigInteger.class, 741, 26216, 26242).floatValue()) / (CallChecker.isCalled(CallChecker.isCalled(denominator, BigInteger.class, 742, 26275, 26285).shiftRight(shift), BigInteger.class, 742, 26275, 26303).floatValue());
                                CallChecker.varAssign(result, "result", 741, 26207, 26317);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2979.methodEnd();
        }
    }

    public BigInteger getDenominator() {
        MethodContext _bcornu_methode_context2980 = new MethodContext(BigInteger.class, 754, 26363, 26599);
        try {
            CallChecker.varInit(this, "this", 754, 26363, 26599);
            CallChecker.varInit(this.denominator, "denominator", 754, 26363, 26599);
            CallChecker.varInit(this.numerator, "numerator", 754, 26363, 26599);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 754, 26363, 26599);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 754, 26363, 26599);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 754, 26363, 26599);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 754, 26363, 26599);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 754, 26363, 26599);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 754, 26363, 26599);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 754, 26363, 26599);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 754, 26363, 26599);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 754, 26363, 26599);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 754, 26363, 26599);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 754, 26363, 26599);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 754, 26363, 26599);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 754, 26363, 26599);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 754, 26363, 26599);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 754, 26363, 26599);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 754, 26363, 26599);
            return denominator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2980.methodEnd();
        }
    }

    public int getDenominatorAsInt() {
        MethodContext _bcornu_methode_context2981 = new MethodContext(int.class, 765, 26606, 26829);
        try {
            CallChecker.varInit(this, "this", 765, 26606, 26829);
            CallChecker.varInit(this.denominator, "denominator", 765, 26606, 26829);
            CallChecker.varInit(this.numerator, "numerator", 765, 26606, 26829);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 765, 26606, 26829);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 765, 26606, 26829);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 765, 26606, 26829);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 765, 26606, 26829);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 765, 26606, 26829);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 765, 26606, 26829);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 765, 26606, 26829);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 765, 26606, 26829);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 765, 26606, 26829);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 765, 26606, 26829);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 765, 26606, 26829);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 765, 26606, 26829);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 765, 26606, 26829);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 765, 26606, 26829);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 765, 26606, 26829);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 765, 26606, 26829);
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 766, 26801, 26811)) {
                return CallChecker.isCalled(denominator, BigInteger.class, 766, 26801, 26811).intValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2981.methodEnd();
        }
    }

    public long getDenominatorAsLong() {
        MethodContext _bcornu_methode_context2982 = new MethodContext(long.class, 776, 26836, 27064);
        try {
            CallChecker.varInit(this, "this", 776, 26836, 27064);
            CallChecker.varInit(this.denominator, "denominator", 776, 26836, 27064);
            CallChecker.varInit(this.numerator, "numerator", 776, 26836, 27064);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 776, 26836, 27064);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 776, 26836, 27064);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 776, 26836, 27064);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 776, 26836, 27064);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 776, 26836, 27064);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 776, 26836, 27064);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 776, 26836, 27064);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 776, 26836, 27064);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 776, 26836, 27064);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 776, 26836, 27064);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 776, 26836, 27064);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 776, 26836, 27064);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 776, 26836, 27064);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 776, 26836, 27064);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 776, 26836, 27064);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 776, 26836, 27064);
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 777, 27035, 27045)) {
                return CallChecker.isCalled(denominator, BigInteger.class, 777, 27035, 27045).longValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2982.methodEnd();
        }
    }

    public BigInteger getNumerator() {
        MethodContext _bcornu_methode_context2983 = new MethodContext(BigInteger.class, 787, 27071, 27299);
        try {
            CallChecker.varInit(this, "this", 787, 27071, 27299);
            CallChecker.varInit(this.denominator, "denominator", 787, 27071, 27299);
            CallChecker.varInit(this.numerator, "numerator", 787, 27071, 27299);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 787, 27071, 27299);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 787, 27071, 27299);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 787, 27071, 27299);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 787, 27071, 27299);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 787, 27071, 27299);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 787, 27071, 27299);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 787, 27071, 27299);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 787, 27071, 27299);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 787, 27071, 27299);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 787, 27071, 27299);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 787, 27071, 27299);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 787, 27071, 27299);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 787, 27071, 27299);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 787, 27071, 27299);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 787, 27071, 27299);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 787, 27071, 27299);
            return numerator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2983.methodEnd();
        }
    }

    public int getNumeratorAsInt() {
        MethodContext _bcornu_methode_context2984 = new MethodContext(int.class, 798, 27306, 27521);
        try {
            CallChecker.varInit(this, "this", 798, 27306, 27521);
            CallChecker.varInit(this.denominator, "denominator", 798, 27306, 27521);
            CallChecker.varInit(this.numerator, "numerator", 798, 27306, 27521);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 798, 27306, 27521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 798, 27306, 27521);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 798, 27306, 27521);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 798, 27306, 27521);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 798, 27306, 27521);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 798, 27306, 27521);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 798, 27306, 27521);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 798, 27306, 27521);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 798, 27306, 27521);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 798, 27306, 27521);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 798, 27306, 27521);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 798, 27306, 27521);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 798, 27306, 27521);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 798, 27306, 27521);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 798, 27306, 27521);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 798, 27306, 27521);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 799, 27495, 27503)) {
                return CallChecker.isCalled(numerator, BigInteger.class, 799, 27495, 27503).intValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2984.methodEnd();
        }
    }

    public long getNumeratorAsLong() {
        MethodContext _bcornu_methode_context2985 = new MethodContext(long.class, 809, 27528, 27748);
        try {
            CallChecker.varInit(this, "this", 809, 27528, 27748);
            CallChecker.varInit(this.denominator, "denominator", 809, 27528, 27748);
            CallChecker.varInit(this.numerator, "numerator", 809, 27528, 27748);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 809, 27528, 27748);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 809, 27528, 27748);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 809, 27528, 27748);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 809, 27528, 27748);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 809, 27528, 27748);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 809, 27528, 27748);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 809, 27528, 27748);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 809, 27528, 27748);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 809, 27528, 27748);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 809, 27528, 27748);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 809, 27528, 27748);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 809, 27528, 27748);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 809, 27528, 27748);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 809, 27528, 27748);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 809, 27528, 27748);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 809, 27528, 27748);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 810, 27721, 27729)) {
                return CallChecker.isCalled(numerator, BigInteger.class, 810, 27721, 27729).longValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2985.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2986 = new MethodContext(int.class, 822, 27755, 28053);
        try {
            CallChecker.varInit(this, "this", 822, 27755, 28053);
            CallChecker.varInit(this.denominator, "denominator", 822, 27755, 28053);
            CallChecker.varInit(this.numerator, "numerator", 822, 27755, 28053);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 822, 27755, 28053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 822, 27755, 28053);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 822, 27755, 28053);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 822, 27755, 28053);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 822, 27755, 28053);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 822, 27755, 28053);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 822, 27755, 28053);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 822, 27755, 28053);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 822, 27755, 28053);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 822, 27755, 28053);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 822, 27755, 28053);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 822, 27755, 28053);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 822, 27755, 28053);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 822, 27755, 28053);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 822, 27755, 28053);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 822, 27755, 28053);
            return (37 * ((37 * 17) + (CallChecker.isCalled(numerator, BigInteger.class, 823, 28001, 28009).hashCode()))) + (CallChecker.isCalled(denominator, BigInteger.class, 823, 28025, 28035).hashCode());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2986.methodEnd();
        }
    }

    @Override
    public int intValue() {
        MethodContext _bcornu_methode_context2987 = new MethodContext(int.class, 836, 28060, 28396);
        try {
            CallChecker.varInit(this, "this", 836, 28060, 28396);
            CallChecker.varInit(this.denominator, "denominator", 836, 28060, 28396);
            CallChecker.varInit(this.numerator, "numerator", 836, 28060, 28396);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 836, 28060, 28396);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 836, 28060, 28396);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 836, 28060, 28396);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 836, 28060, 28396);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 836, 28060, 28396);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 836, 28060, 28396);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 836, 28060, 28396);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 836, 28060, 28396);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 836, 28060, 28396);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 836, 28060, 28396);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 836, 28060, 28396);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 836, 28060, 28396);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 836, 28060, 28396);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 836, 28060, 28396);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 836, 28060, 28396);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 836, 28060, 28396);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 837, 28350, 28358)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 837, 28350, 28358).divide(denominator), BigInteger.class, 837, 28350, 28378)) {
                    return CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 837, 28350, 28358).divide(denominator), BigInteger.class, 837, 28350, 28378).intValue();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2987.methodEnd();
        }
    }

    @Override
    public long longValue() {
        MethodContext _bcornu_methode_context2988 = new MethodContext(long.class, 850, 28403, 28743);
        try {
            CallChecker.varInit(this, "this", 850, 28403, 28743);
            CallChecker.varInit(this.denominator, "denominator", 850, 28403, 28743);
            CallChecker.varInit(this.numerator, "numerator", 850, 28403, 28743);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 850, 28403, 28743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 850, 28403, 28743);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 850, 28403, 28743);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 850, 28403, 28743);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 850, 28403, 28743);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 850, 28403, 28743);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 850, 28403, 28743);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 850, 28403, 28743);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 850, 28403, 28743);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 850, 28403, 28743);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 850, 28403, 28743);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 850, 28403, 28743);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 850, 28403, 28743);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 850, 28403, 28743);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 850, 28403, 28743);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 850, 28403, 28743);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 851, 28696, 28704)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 851, 28696, 28704).divide(denominator), BigInteger.class, 851, 28696, 28724)) {
                    return CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 851, 28696, 28704).divide(denominator), BigInteger.class, 851, 28696, 28724).longValue();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2988.methodEnd();
        }
    }

    public BigFraction multiply(final BigInteger bg) {
        MethodContext _bcornu_methode_context2989 = new MethodContext(BigFraction.class, 864, 28750, 29329);
        try {
            CallChecker.varInit(this, "this", 864, 28750, 29329);
            CallChecker.varInit(bg, "bg", 864, 28750, 29329);
            CallChecker.varInit(this.denominator, "denominator", 864, 28750, 29329);
            CallChecker.varInit(this.numerator, "numerator", 864, 28750, 29329);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 864, 28750, 29329);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 864, 28750, 29329);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 864, 28750, 29329);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 864, 28750, 29329);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 864, 28750, 29329);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 864, 28750, 29329);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 864, 28750, 29329);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 864, 28750, 29329);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 864, 28750, 29329);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 864, 28750, 29329);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 864, 28750, 29329);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 864, 28750, 29329);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 864, 28750, 29329);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 864, 28750, 29329);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 864, 28750, 29329);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 864, 28750, 29329);
            if (bg == null) {
                throw new NullArgumentException();
            }
            return new BigFraction(bg.multiply(numerator), denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2989.methodEnd();
        }
    }

    public BigFraction multiply(final int i) {
        MethodContext _bcornu_methode_context2990 = new MethodContext(BigFraction.class, 881, 29336, 29733);
        try {
            CallChecker.varInit(this, "this", 881, 29336, 29733);
            CallChecker.varInit(i, "i", 881, 29336, 29733);
            CallChecker.varInit(this.denominator, "denominator", 881, 29336, 29733);
            CallChecker.varInit(this.numerator, "numerator", 881, 29336, 29733);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 881, 29336, 29733);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 881, 29336, 29733);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 881, 29336, 29733);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 881, 29336, 29733);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 881, 29336, 29733);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 881, 29336, 29733);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 881, 29336, 29733);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 881, 29336, 29733);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 881, 29336, 29733);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 881, 29336, 29733);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 881, 29336, 29733);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 881, 29336, 29733);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 881, 29336, 29733);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 881, 29336, 29733);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 881, 29336, 29733);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 881, 29336, 29733);
            return multiply(BigInteger.valueOf(i));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2990.methodEnd();
        }
    }

    public BigFraction multiply(final long l) {
        MethodContext _bcornu_methode_context2991 = new MethodContext(BigFraction.class, 895, 29740, 30140);
        try {
            CallChecker.varInit(this, "this", 895, 29740, 30140);
            CallChecker.varInit(l, "l", 895, 29740, 30140);
            CallChecker.varInit(this.denominator, "denominator", 895, 29740, 30140);
            CallChecker.varInit(this.numerator, "numerator", 895, 29740, 30140);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 895, 29740, 30140);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 895, 29740, 30140);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 895, 29740, 30140);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 895, 29740, 30140);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 895, 29740, 30140);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 895, 29740, 30140);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 895, 29740, 30140);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 895, 29740, 30140);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 895, 29740, 30140);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 895, 29740, 30140);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 895, 29740, 30140);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 895, 29740, 30140);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 895, 29740, 30140);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 895, 29740, 30140);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 895, 29740, 30140);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 895, 29740, 30140);
            return multiply(BigInteger.valueOf(l));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2991.methodEnd();
        }
    }

    public BigFraction multiply(final BigFraction fraction) {
        MethodContext _bcornu_methode_context2992 = new MethodContext(BigFraction.class, 909, 30147, 30981);
        try {
            CallChecker.varInit(this, "this", 909, 30147, 30981);
            CallChecker.varInit(fraction, "fraction", 909, 30147, 30981);
            CallChecker.varInit(this.denominator, "denominator", 909, 30147, 30981);
            CallChecker.varInit(this.numerator, "numerator", 909, 30147, 30981);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 909, 30147, 30981);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 909, 30147, 30981);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 909, 30147, 30981);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 909, 30147, 30981);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 909, 30147, 30981);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 909, 30147, 30981);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 909, 30147, 30981);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 909, 30147, 30981);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 909, 30147, 30981);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 909, 30147, 30981);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 909, 30147, 30981);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 909, 30147, 30981);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 909, 30147, 30981);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 909, 30147, 30981);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 909, 30147, 30981);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 909, 30147, 30981);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 913, 30700, 30708)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(fraction, BigFraction.class, 914, 30749, 30756).numerator, BigInteger.class, 914, 30749, 30766)) {
                    if ((CallChecker.isCalled(numerator, BigInteger.class, 913, 30700, 30708).equals(BigInteger.ZERO)) || (CallChecker.isCalled(fraction.numerator, BigInteger.class, 914, 30749, 30766).equals(BigInteger.ZERO))) {
                        return BigFraction.ZERO;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 917, 30861, 30869)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 918, 30932, 30942)) {
                    return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 917, 30861, 30869).multiply(fraction.numerator), CallChecker.isCalled(denominator, BigInteger.class, 918, 30932, 30942).multiply(fraction.denominator));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2992.methodEnd();
        }
    }

    public BigFraction negate() {
        MethodContext _bcornu_methode_context2993 = new MethodContext(BigFraction.class, 929, 30988, 31277);
        try {
            CallChecker.varInit(this, "this", 929, 30988, 31277);
            CallChecker.varInit(this.denominator, "denominator", 929, 30988, 31277);
            CallChecker.varInit(this.numerator, "numerator", 929, 30988, 31277);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 929, 30988, 31277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 929, 30988, 31277);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 929, 30988, 31277);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 929, 30988, 31277);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 929, 30988, 31277);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 929, 30988, 31277);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 929, 30988, 31277);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 929, 30988, 31277);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 929, 30988, 31277);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 929, 30988, 31277);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 929, 30988, 31277);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 929, 30988, 31277);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 929, 30988, 31277);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 929, 30988, 31277);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 929, 30988, 31277);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 929, 30988, 31277);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 930, 31239, 31247)) {
                return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 930, 31239, 31247).negate(), denominator);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2993.methodEnd();
        }
    }

    public double percentageValue() {
        MethodContext _bcornu_methode_context2994 = new MethodContext(double.class, 941, 31284, 31634);
        try {
            CallChecker.varInit(this, "this", 941, 31284, 31634);
            CallChecker.varInit(this.denominator, "denominator", 941, 31284, 31634);
            CallChecker.varInit(this.numerator, "numerator", 941, 31284, 31634);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 941, 31284, 31634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 941, 31284, 31634);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 941, 31284, 31634);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 941, 31284, 31634);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 941, 31284, 31634);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 941, 31284, 31634);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 941, 31284, 31634);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 941, 31284, 31634);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 941, 31284, 31634);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 941, 31284, 31634);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 941, 31284, 31634);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 941, 31284, 31634);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 941, 31284, 31634);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 941, 31284, 31634);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 941, 31284, 31634);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 941, 31284, 31634);
            final BigFraction npe_invocation_var771 = multiply(BigFraction.ONE_HUNDRED);
            if (CallChecker.beforeDeref(npe_invocation_var771, BigFraction.class, 942, 31593, 31613)) {
                return CallChecker.isCalled(npe_invocation_var771, BigFraction.class, 942, 31593, 31613).doubleValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2994.methodEnd();
        }
    }

    public BigFraction pow(final int exponent) {
        MethodContext _bcornu_methode_context2995 = new MethodContext(BigFraction.class, 956, 31641, 32248);
        try {
            CallChecker.varInit(this, "this", 956, 31641, 32248);
            CallChecker.varInit(exponent, "exponent", 956, 31641, 32248);
            CallChecker.varInit(this.denominator, "denominator", 956, 31641, 32248);
            CallChecker.varInit(this.numerator, "numerator", 956, 31641, 32248);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 956, 31641, 32248);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 956, 31641, 32248);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 956, 31641, 32248);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 956, 31641, 32248);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 956, 31641, 32248);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 956, 31641, 32248);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 956, 31641, 32248);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 956, 31641, 32248);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 956, 31641, 32248);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 956, 31641, 32248);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 956, 31641, 32248);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 956, 31641, 32248);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 956, 31641, 32248);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 956, 31641, 32248);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 956, 31641, 32248);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 956, 31641, 32248);
            if (exponent < 0) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 958, 32095, 32105)) {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 958, 32123, 32131)) {
                        return new BigFraction(CallChecker.isCalled(denominator, BigInteger.class, 958, 32095, 32105).pow((-exponent)), CallChecker.isCalled(numerator, BigInteger.class, 958, 32123, 32131).pow((-exponent)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 960, 32191, 32199)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 960, 32216, 32226)) {
                    return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 960, 32191, 32199).pow(exponent), CallChecker.isCalled(denominator, BigInteger.class, 960, 32216, 32226).pow(exponent));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2995.methodEnd();
        }
    }

    public BigFraction pow(final long exponent) {
        MethodContext _bcornu_methode_context2996 = new MethodContext(BigFraction.class, 973, 32255, 33024);
        try {
            CallChecker.varInit(this, "this", 973, 32255, 33024);
            CallChecker.varInit(exponent, "exponent", 973, 32255, 33024);
            CallChecker.varInit(this.denominator, "denominator", 973, 32255, 33024);
            CallChecker.varInit(this.numerator, "numerator", 973, 32255, 33024);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 973, 32255, 33024);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 973, 32255, 33024);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 973, 32255, 33024);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 973, 32255, 33024);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 973, 32255, 33024);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 973, 32255, 33024);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 973, 32255, 33024);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 973, 32255, 33024);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 973, 32255, 33024);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 973, 32255, 33024);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 973, 32255, 33024);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 973, 32255, 33024);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 973, 32255, 33024);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 973, 32255, 33024);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 973, 32255, 33024);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 973, 32255, 33024);
            if (exponent < 0) {
                return new BigFraction(ArithmeticUtils.pow(denominator, (-exponent)), ArithmeticUtils.pow(numerator, (-exponent)));
            }
            return new BigFraction(ArithmeticUtils.pow(numerator, exponent), ArithmeticUtils.pow(denominator, exponent));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2996.methodEnd();
        }
    }

    public BigFraction pow(final BigInteger exponent) {
        MethodContext _bcornu_methode_context2997 = new MethodContext(BigFraction.class, 992, 33031, 33878);
        try {
            CallChecker.varInit(this, "this", 992, 33031, 33878);
            CallChecker.varInit(exponent, "exponent", 992, 33031, 33878);
            CallChecker.varInit(this.denominator, "denominator", 992, 33031, 33878);
            CallChecker.varInit(this.numerator, "numerator", 992, 33031, 33878);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 992, 33031, 33878);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 992, 33031, 33878);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 992, 33031, 33878);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 992, 33031, 33878);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 992, 33031, 33878);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 992, 33031, 33878);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 992, 33031, 33878);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 992, 33031, 33878);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 992, 33031, 33878);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 992, 33031, 33878);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 992, 33031, 33878);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 992, 33031, 33878);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 992, 33031, 33878);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 992, 33031, 33878);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 992, 33031, 33878);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 992, 33031, 33878);
            if (CallChecker.beforeDeref(exponent, BigInteger.class, 993, 33464, 33471)) {
                if ((CallChecker.isCalled(exponent, BigInteger.class, 993, 33464, 33471).compareTo(BigInteger.ZERO)) < 0) {
                    final BigInteger eNeg = CallChecker.varInit(CallChecker.isCalled(exponent, BigInteger.class, 994, 33543, 33550).negate(), "eNeg", 994, 33519, 33560);
                    return new BigFraction(ArithmeticUtils.pow(denominator, eNeg), ArithmeticUtils.pow(numerator, eNeg));
                }
            }else
                throw new AbnormalExecutionError();
            
            return new BigFraction(ArithmeticUtils.pow(numerator, exponent), ArithmeticUtils.pow(denominator, exponent));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2997.methodEnd();
        }
    }

    public double pow(final double exponent) {
        MethodContext _bcornu_methode_context2998 = new MethodContext(double.class, 1012, 33885, 34399);
        try {
            CallChecker.varInit(this, "this", 1012, 33885, 34399);
            CallChecker.varInit(exponent, "exponent", 1012, 33885, 34399);
            CallChecker.varInit(this.denominator, "denominator", 1012, 33885, 34399);
            CallChecker.varInit(this.numerator, "numerator", 1012, 33885, 34399);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1012, 33885, 34399);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1012, 33885, 34399);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1012, 33885, 34399);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1012, 33885, 34399);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1012, 33885, 34399);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1012, 33885, 34399);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1012, 33885, 34399);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1012, 33885, 34399);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1012, 33885, 34399);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1012, 33885, 34399);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1012, 33885, 34399);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1012, 33885, 34399);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1012, 33885, 34399);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1012, 33885, 34399);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1012, 33885, 34399);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1012, 33885, 34399);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 1013, 34290, 34298)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 1014, 34357, 34367)) {
                    return (FastMath.pow(CallChecker.isCalled(numerator, BigInteger.class, 1013, 34290, 34298).doubleValue(), exponent)) / (FastMath.pow(CallChecker.isCalled(denominator, BigInteger.class, 1014, 34357, 34367).doubleValue(), exponent));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2998.methodEnd();
        }
    }

    public BigFraction reciprocal() {
        MethodContext _bcornu_methode_context2999 = new MethodContext(BigFraction.class, 1024, 34406, 34645);
        try {
            CallChecker.varInit(this, "this", 1024, 34406, 34645);
            CallChecker.varInit(this.denominator, "denominator", 1024, 34406, 34645);
            CallChecker.varInit(this.numerator, "numerator", 1024, 34406, 34645);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1024, 34406, 34645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1024, 34406, 34645);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1024, 34406, 34645);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1024, 34406, 34645);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1024, 34406, 34645);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1024, 34406, 34645);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1024, 34406, 34645);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1024, 34406, 34645);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1024, 34406, 34645);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1024, 34406, 34645);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1024, 34406, 34645);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1024, 34406, 34645);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1024, 34406, 34645);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1024, 34406, 34645);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1024, 34406, 34645);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1024, 34406, 34645);
            return new BigFraction(denominator, numerator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2999.methodEnd();
        }
    }

    public BigFraction reduce() {
        MethodContext _bcornu_methode_context3000 = new MethodContext(BigFraction.class, 1036, 34652, 35063);
        try {
            CallChecker.varInit(this, "this", 1036, 34652, 35063);
            CallChecker.varInit(this.denominator, "denominator", 1036, 34652, 35063);
            CallChecker.varInit(this.numerator, "numerator", 1036, 34652, 35063);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1036, 34652, 35063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1036, 34652, 35063);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1036, 34652, 35063);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1036, 34652, 35063);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1036, 34652, 35063);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1036, 34652, 35063);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1036, 34652, 35063);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1036, 34652, 35063);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1036, 34652, 35063);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1036, 34652, 35063);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1036, 34652, 35063);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1036, 34652, 35063);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1036, 34652, 35063);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1036, 34652, 35063);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1036, 34652, 35063);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1036, 34652, 35063);
            final BigInteger gcd = CallChecker.varInit(CallChecker.isCalled(numerator, BigInteger.class, 1037, 34951, 34959).gcd(denominator), "gcd", 1037, 34928, 34977);
            if (CallChecker.beforeDeref(numerator, BigInteger.class, 1038, 35010, 35018)) {
                if (CallChecker.beforeDeref(denominator, BigInteger.class, 1038, 35033, 35043)) {
                    return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 1038, 35010, 35018).divide(gcd), CallChecker.isCalled(denominator, BigInteger.class, 1038, 35033, 35043).divide(gcd));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3000.methodEnd();
        }
    }

    public BigFraction subtract(final BigInteger bg) {
        MethodContext _bcornu_methode_context3001 = new MethodContext(BigFraction.class, 1051, 35070, 35716);
        try {
            CallChecker.varInit(this, "this", 1051, 35070, 35716);
            CallChecker.varInit(bg, "bg", 1051, 35070, 35716);
            CallChecker.varInit(this.denominator, "denominator", 1051, 35070, 35716);
            CallChecker.varInit(this.numerator, "numerator", 1051, 35070, 35716);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1051, 35070, 35716);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1051, 35070, 35716);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1051, 35070, 35716);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1051, 35070, 35716);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1051, 35070, 35716);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1051, 35070, 35716);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1051, 35070, 35716);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1051, 35070, 35716);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1051, 35070, 35716);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1051, 35070, 35716);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1051, 35070, 35716);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1051, 35070, 35716);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1051, 35070, 35716);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1051, 35070, 35716);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1051, 35070, 35716);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1051, 35070, 35716);
            if (bg == null) {
                throw new NullArgumentException();
            }
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 1055, 35671, 35681)) {
                if (CallChecker.beforeDeref(numerator, BigInteger.class, 1055, 35652, 35660)) {
                    return new BigFraction(CallChecker.isCalled(numerator, BigInteger.class, 1055, 35652, 35660).subtract(CallChecker.isCalled(denominator, BigInteger.class, 1055, 35671, 35681).multiply(bg)), denominator);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3001.methodEnd();
        }
    }

    public BigFraction subtract(final int i) {
        MethodContext _bcornu_methode_context3002 = new MethodContext(BigFraction.class, 1067, 35723, 36124);
        try {
            CallChecker.varInit(this, "this", 1067, 35723, 36124);
            CallChecker.varInit(i, "i", 1067, 35723, 36124);
            CallChecker.varInit(this.denominator, "denominator", 1067, 35723, 36124);
            CallChecker.varInit(this.numerator, "numerator", 1067, 35723, 36124);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1067, 35723, 36124);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1067, 35723, 36124);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1067, 35723, 36124);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1067, 35723, 36124);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1067, 35723, 36124);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1067, 35723, 36124);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1067, 35723, 36124);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1067, 35723, 36124);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1067, 35723, 36124);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1067, 35723, 36124);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1067, 35723, 36124);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1067, 35723, 36124);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1067, 35723, 36124);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1067, 35723, 36124);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1067, 35723, 36124);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1067, 35723, 36124);
            return subtract(BigInteger.valueOf(i));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3002.methodEnd();
        }
    }

    public BigFraction subtract(final long l) {
        MethodContext _bcornu_methode_context3003 = new MethodContext(BigFraction.class, 1080, 36131, 36526);
        try {
            CallChecker.varInit(this, "this", 1080, 36131, 36526);
            CallChecker.varInit(l, "l", 1080, 36131, 36526);
            CallChecker.varInit(this.denominator, "denominator", 1080, 36131, 36526);
            CallChecker.varInit(this.numerator, "numerator", 1080, 36131, 36526);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1080, 36131, 36526);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1080, 36131, 36526);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1080, 36131, 36526);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1080, 36131, 36526);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1080, 36131, 36526);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1080, 36131, 36526);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1080, 36131, 36526);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1080, 36131, 36526);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1080, 36131, 36526);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1080, 36131, 36526);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1080, 36131, 36526);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1080, 36131, 36526);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1080, 36131, 36526);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1080, 36131, 36526);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1080, 36131, 36526);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1080, 36131, 36526);
            return subtract(BigInteger.valueOf(l));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3003.methodEnd();
        }
    }

    public BigFraction subtract(final BigFraction fraction) {
        MethodContext _bcornu_methode_context3004 = new MethodContext(BigFraction.class, 1094, 36533, 37634);
        try {
            CallChecker.varInit(this, "this", 1094, 36533, 37634);
            CallChecker.varInit(fraction, "fraction", 1094, 36533, 37634);
            CallChecker.varInit(this.denominator, "denominator", 1094, 36533, 37634);
            CallChecker.varInit(this.numerator, "numerator", 1094, 36533, 37634);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1094, 36533, 37634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1094, 36533, 37634);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1094, 36533, 37634);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1094, 36533, 37634);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1094, 36533, 37634);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1094, 36533, 37634);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1094, 36533, 37634);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1094, 36533, 37634);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1094, 36533, 37634);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1094, 36533, 37634);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1094, 36533, 37634);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1094, 36533, 37634);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1094, 36533, 37634);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1094, 36533, 37634);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1094, 36533, 37634);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1094, 36533, 37634);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (CallChecker.beforeDeref(BigFraction.ZERO, BigFraction.class, 1098, 37115, 37118)) {
                if (CallChecker.isCalled(BigFraction.ZERO, BigFraction.class, 1098, 37115, 37118).equals(fraction)) {
                    return this;
                }
            }else
                throw new AbnormalExecutionError();
            
            BigInteger num = CallChecker.varInit(null, "num", 1102, 37184, 37205);
            BigInteger den = CallChecker.varInit(null, "den", 1103, 37215, 37236);
            if (CallChecker.beforeDeref(denominator, BigInteger.class, 1104, 37250, 37260)) {
                if (CallChecker.isCalled(denominator, BigInteger.class, 1104, 37250, 37260).equals(fraction.denominator)) {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 1105, 37312, 37320)) {
                        num = CallChecker.isCalled(numerator, BigInteger.class, 1105, 37312, 37320).subtract(fraction.numerator);
                        CallChecker.varAssign(num, "num", 1105, 37306, 37350);
                    }
                    den = denominator;
                    CallChecker.varAssign(den, "den", 1106, 37364, 37381);
                }else {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 1108, 37419, 37427)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(fraction, BigFraction.class, 1108, 37470, 37478).numerator, BigInteger.class, 1108, 37470, 37489)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(numerator, BigInteger.class, 1108, 37419, 37427).multiply(CallChecker.isCalled(fraction, BigFraction.class, 1108, 37438, 37445).denominator), BigInteger.class, 1108, 37418, 37459)) {
                                num = CallChecker.isCalled(CallChecker.isCalled(numerator, BigInteger.class, 1108, 37419, 37427).multiply(fraction.denominator), BigInteger.class, 1108, 37418, 37459).subtract(CallChecker.isCalled(fraction.numerator, BigInteger.class, 1108, 37470, 37489).multiply(denominator));
                                CallChecker.varAssign(num, "num", 1108, 37412, 37513);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(denominator, BigInteger.class, 1109, 37533, 37543)) {
                        den = CallChecker.isCalled(denominator, BigInteger.class, 1109, 37533, 37543).multiply(fraction.denominator);
                        CallChecker.varAssign(den, "den", 1109, 37527, 37575);
                    }
                }
            }
            return new BigFraction(num, den);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3004.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context3005 = new MethodContext(String.class, 1125, 37641, 38252);
        try {
            CallChecker.varInit(this, "this", 1125, 37641, 38252);
            CallChecker.varInit(this.denominator, "denominator", 1125, 37641, 38252);
            CallChecker.varInit(this.numerator, "numerator", 1125, 37641, 38252);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1125, 37641, 38252);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1125, 37641, 38252);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1125, 37641, 38252);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1125, 37641, 38252);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1125, 37641, 38252);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1125, 37641, 38252);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1125, 37641, 38252);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1125, 37641, 38252);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1125, 37641, 38252);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1125, 37641, 38252);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1125, 37641, 38252);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1125, 37641, 38252);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1125, 37641, 38252);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1125, 37641, 38252);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1125, 37641, 38252);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1125, 37641, 38252);
            String str = CallChecker.varInit(null, "str", 1126, 37962, 37979);
            if (CallChecker.beforeDeref(BigInteger.ONE, BigInteger.class, 1127, 37993, 38006)) {
                if (CallChecker.isCalled(BigInteger.ONE, BigInteger.class, 1127, 37993, 38006).equals(denominator)) {
                    if (CallChecker.beforeDeref(numerator, BigInteger.class, 1128, 38049, 38057)) {
                        str = CallChecker.isCalled(numerator, BigInteger.class, 1128, 38049, 38057).toString();
                        CallChecker.varAssign(str, "str", 1128, 38043, 38069);
                    }
                }else
                    if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 1129, 38090, 38104)) {
                        if (CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 1129, 38090, 38104).equals(numerator)) {
                            str = "0";
                            CallChecker.varAssign(str, "str", 1130, 38139, 38148);
                        }else {
                            str = ((numerator) + " / ") + (denominator);
                            CallChecker.varAssign(str, "str", 1132, 38179, 38216);
                        }
                    }
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3005.methodEnd();
        }
    }

    public BigFractionField getField() {
        MethodContext _bcornu_methode_context3006 = new MethodContext(BigFractionField.class, 1138, 38259, 38372);
        try {
            CallChecker.varInit(this, "this", 1138, 38259, 38372);
            CallChecker.varInit(this.denominator, "denominator", 1138, 38259, 38372);
            CallChecker.varInit(this.numerator, "numerator", 1138, 38259, 38372);
            CallChecker.varInit(ONE_HUNDRED, "org.apache.commons.math3.fraction.BigFraction.ONE_HUNDRED", 1138, 38259, 38372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFraction.serialVersionUID", 1138, 38259, 38372);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.BigFraction.TWO_THIRDS", 1138, 38259, 38372);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.TWO_QUARTERS", 1138, 38259, 38372);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.TWO_FIFTHS", 1138, 38259, 38372);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.BigFraction.THREE_QUARTERS", 1138, 38259, 38372);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.THREE_FIFTHS", 1138, 38259, 38372);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.BigFraction.ONE_THIRD", 1138, 38259, 38372);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.BigFraction.ONE_QUARTER", 1138, 38259, 38372);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.BigFraction.ONE_HALF", 1138, 38259, 38372);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.BigFraction.ONE_FIFTH", 1138, 38259, 38372);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.BigFraction.FOUR_FIFTHS", 1138, 38259, 38372);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.BigFraction.MINUS_ONE", 1138, 38259, 38372);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.BigFraction.ZERO", 1138, 38259, 38372);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.BigFraction.ONE", 1138, 38259, 38372);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.BigFraction.TWO", 1138, 38259, 38372);
            return BigFractionField.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3006.methodEnd();
        }
    }
}

